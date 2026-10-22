package com.android.contacts;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import com.GlobalProxyLancet;
import com.android.contacts.detail.ContactDetailFragment;
import com.obric.thread.ThreadPoolManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class NfcHandler implements NfcAdapter.CreateNdefMessageCallback {
    private static final Handler MAIN_HANDLER = null;
    private static final String PROFILE_LOOKUP_KEY = "profile";
    private static final AtomicInteger REGISTER_GENERATION = null;
    private static final String TAG = "ContactNfcHandler";
    private static volatile NfcAdapter sCachedAdapter;
    private final ContactDetailFragment mContactFragment;

    static /* synthetic */ NfcAdapter access$002(NfcAdapter r0) {
        sCachedAdapter = r0;
        return r0;
    }

    static /* synthetic */ void access$100(NfcAdapter r0, Activity r1, ContactDetailFragment r2, int r3) {
        setCallbackIfValid(r0, r1, r2, r3);
    }

    static /* synthetic */ Handler access$200() {
        return MAIN_HANDLER;
    }

    static {
        MAIN_HANDLER = new Handler(Looper.getMainLooper());
        REGISTER_GENERATION = new AtomicInteger();
    }

    public static void register(Activity r4, ContactDetailFragment r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        final int r0 = REGISTER_GENERATION.incrementAndGet();
        NfcAdapter r1 = sCachedAdapter;
        if (r1 == null) goto L8;
        setCallbackIfValid(r1, r4, r5, r0);
        return;
    L8:
        final WeakReference r2 = new WeakReference(r4);
        final WeakReference r3 = new WeakReference(r5);
        final Context r6 = r4.getApplicationContext();
        ThreadPoolManager.INSTANCE.getSerialExecutor().execute(new AnonymousClass1(r6, r2, r3, r0));
    }

    private static void setCallbackIfValid(NfcAdapter r1, Activity r2, ContactDetailFragment r3, int r4) {
        if (REGISTER_GENERATION.get() != r4) goto L15;
        if (r2 == null) goto L16;
        if (r3 != null) goto L7;
        return;
    L7:
        if (r2.isFinishing() == false) goto L9;
        return;
    L9:
        if (r2.isDestroyed() == true) goto L19;
        if (r1 != null) goto L13;
        return;
    L13:
        r1.setNdefPushMessageCallback(new NfcHandler(r3), r2, new Activity[0]);
        return;
    L19:
        return;
    L16:
        return;
    }

    public static void unregister(Activity r3) {
        REGISTER_GENERATION.incrementAndGet();
        NfcAdapter r0 = sCachedAdapter;
        if (r0 == null) goto L12;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.isFinishing() == false) goto L8;
        return;
    L8:
        if (r3.isDestroyed() == true) goto L15;
        r0.setNdefPushMessageCallback(null, r3, new Activity[0]);
        return;
    L15:
        return;
    }

    public NfcHandler(ContactDetailFragment r1) {
        this.mContactFragment = r1;
    }

    @Override // android.nfc.NfcAdapter.CreateNdefMessageCallback
    public NdefMessage createNdefMessage(NfcEvent r8) {
        Uri r9 = this.mContactFragment.getUri();
        ContentResolver r7 = this.mContactFragment.getActivity().getContentResolver();
        if (r9 == null) goto L25;
        List<String> r10 = r9.getPathSegments();
        if (r10 == null) goto L7;
        String r11 = Uri.encode(r10.get(2));
    L9:
        if (r11 != null) goto L11;
    L13:
        Uri r12 = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_VCARD_URI, r11).buildUpon().appendQueryParameter("no_photo", "true").build();
    L14:
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();
        byte[] r4 = new byte[1024];
        InputStream r13 = r7.openInputStream(r12);     // Catch: IOException -> L22
        if (r13 == null) goto L20;
    L17:
        int r6 = r13.read(r4);     // Catch: IOException -> L22
        if (r6 <= 0) goto L20;
        r3.write(r4, 0, r6);     // Catch: IOException -> L22
    L20:
        return new NdefMessage(new NdefRecord[]{new NdefRecord(2, "text/x-vCard".getBytes(), new byte[0], r3.toByteArray())});
    L22:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "IOException creating vcard. e:" + e + "; shareUri:" + r12.toString());
        return null;
    L11:
        if (r11.equals(PROFILE_LOOKUP_KEY) == false) goto L13;
        r12 = ContactsContract.Profile.CONTENT_VCARD_URI.buildUpon().appendQueryParameter("no_photo", "true").build();
        goto L14
    L7:
        r11 = null;
        goto L9
    L25:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "No contact URI to share.");
        return null;
    }
}
