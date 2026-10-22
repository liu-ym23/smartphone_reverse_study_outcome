package com.android.contacts.editor;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.GlobalProxyLancet;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactsApplication;

/* JADX INFO: loaded from: classes.dex */
public class ContactEditorCache {
    private static final String TAG = "ContactEditorCache";
    private static ContactEditorCache sMe;
    private Handler mHandler;
    private ContactEditorCacheListener mListener;
    private Uri mLookupUri;
    private ContactLoader.Result mResult;
    private Uri mRingtoneUri;

    public interface ContactEditorCacheListener {
        void contactActuallySaved(Uri r1);
    }

    static /* synthetic */ ContactEditorCacheListener access$000(ContactEditorCache r0) {
        return r0.mListener;
    }

    static /* synthetic */ Uri access$100(ContactEditorCache r0) {
        return r0.mLookupUri;
    }

    public static ContactEditorCache getInstance() {
        if (sMe != null) goto L6;
        sMe = new ContactEditorCache();
    L6:
        return sMe;
    }

    public ContactEditorCache() {
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public void setCache(ContactLoader.Result r1) {
        this.mResult = r1;
        this.mLookupUri = null;
        this.mListener = null;
    }

    public void setLookupUri(Uri r4) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setLookupUri " + r4);
        this.mLookupUri = r4;
        ContactLoader.Result r0 = this.mResult;
        if (r0 == null) goto L9;
        r0.mLookupUri = r4;
        if (this.mRingtoneUri == null) goto L7;
        ContentValues r5 = new ContentValues(1);
        r5.put("custom_ringtone", this.mRingtoneUri.toString());
        ContactsApplication.getInstance().getContentResolver().update(this.mLookupUri, r5, null, null);
    L7:
        this.mHandler.post(new AnonymousClass1(this));
        return;
    }

    public ContactLoader.Result getResult() {
        return this.mResult;
    }

    public Uri getLookupUri() {
        return this.mLookupUri;
    }

    public void setRingtone(Uri r1) {
        this.mRingtoneUri = r1;
    }

    public Uri getRingtone() {
        return this.mRingtoneUri;
    }

    public void setListener(ContactEditorCacheListener r1) {
        this.mListener = r1;
    }

    public void clear() {
        this.mRingtoneUri = null;
        this.mLookupUri = null;
        this.mResult = null;
        this.mListener = null;
    }
}
