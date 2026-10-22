package com.android.vcard;

import android.accounts.Account;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class VCardEntryConstructor implements VCardInterpreter {
    private static String LOG_TAG = "vCard";
    private final Account mAccount;
    private VCardEntry mCurrentEntry;
    private final List<VCardEntryHandler> mEntryHandlers;
    private final List<VCardEntry> mEntryStack;
    private final int mVCardType;

    static {
    }

    public VCardEntryConstructor() {
        this(VCardConfig.VCARD_TYPE_V21_GENERIC, null, null);
    }

    public VCardEntryConstructor(int r2) {
        this(r2, null, null);
    }

    public VCardEntryConstructor(int r2, Account r3) {
        this(r2, r3, null);
    }

    @Deprecated
    public VCardEntryConstructor(int r2, Account r3, String r4) {
        this.mEntryStack = new ArrayList();
        this.mEntryHandlers = new ArrayList();
        Log.d("xiaor", "VCardEntryConstructor: " + r2 + " ... " + r3);
        this.mVCardType = r2;
        this.mAccount = r3;
    }

    public void addEntryHandler(VCardEntryHandler r1) {
        this.mEntryHandlers.add(r1);
    }

    @Override // com.android.vcard.VCardInterpreter
    public void onVCardStarted() {
        Iterator<VCardEntryHandler> r1 = this.mEntryHandlers.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onStart();
        goto L4
    }

    @Override // com.android.vcard.VCardInterpreter
    public void onVCardEnded() {
        Iterator<VCardEntryHandler> r1 = this.mEntryHandlers.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onEnd();
        goto L4
    }

    public void clear() {
        this.mCurrentEntry = null;
        this.mEntryStack.clear();
    }

    @Override // com.android.vcard.VCardInterpreter
    public void onEntryStarted() {
        VCardEntry r0 = new VCardEntry(this.mVCardType, this.mAccount);
        this.mCurrentEntry = r0;
        this.mEntryStack.add(r0);
    }

    @Override // com.android.vcard.VCardInterpreter
    public void onEntryEnded() {
        this.mCurrentEntry.consolidateFields();
        Iterator<VCardEntryHandler> r0 = this.mEntryHandlers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onEntryCreated(this.mCurrentEntry);
        goto L4
    L6:
        int r1 = this.mEntryStack.size();
        if (r1 <= 1) goto L9;
        VCardEntry r2 = this.mEntryStack.get(r1 - 2);
        r2.addChild(this.mCurrentEntry);
        this.mCurrentEntry = r2;
    L10:
        this.mEntryStack.remove(r1 - 1);
        return;
    L9:
        this.mCurrentEntry = null;
        goto L10
    }

    @Override // com.android.vcard.VCardInterpreter
    public void onPropertyCreated(VCardProperty r3) {
        Log.d("xiaor", "VCardEntryConstructor: onPropertyCreated..." + r3);
        this.mCurrentEntry.addProperty(r3);
    }
}
