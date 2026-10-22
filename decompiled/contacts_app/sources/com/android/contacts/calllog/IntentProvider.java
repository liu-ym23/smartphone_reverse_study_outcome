package com.android.contacts.calllog;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public abstract class IntentProvider {
    private static final String TAG = "IntentProvider";

    public abstract Intent getIntent(Context r1);

    public IntentProvider() {
    }

    public static IntentProvider getReturnCallIntentProvider(final String r1, final int r2) {
        return new AnonymousClass1(r1, r2);
    }

    public static IntentProvider getReturnCallIntentProvider(String r1, int r2, String r3) {
        return getReturnCallIntentProvider(r1, r2, r3, false, false);
    }

    public static IntentProvider getReturnCallIntentProvider(final String r7, final int r8, final String r9, final boolean r10, final boolean r11) {
        return new AnonymousClass2(r7, r10, r11, r8, r9);
    }

    public static IntentProvider getReturnCallIntentProvider(final String r1, final boolean r2) {
        return new AnonymousClass3(r1, r2);
    }

    public static IntentProvider getReturnVideoCallIntentProvider(final String r1) {
        return new AnonymousClass4(r1);
    }

    public static IntentProvider getPlayVoicemailIntentProvider(final long r1, final String r3) {
        return new AnonymousClass5(r1, r3);
    }

    public static IntentProvider getCallDetailIntentProvider(final CallLogAdapter r0, final int r1, long r2, final int r4, final String r5) {
        return new AnonymousClass6(r0, r1, r5, r4);
    }
}
