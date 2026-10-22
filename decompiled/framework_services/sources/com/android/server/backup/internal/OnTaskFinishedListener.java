package com.android.server.backup.internal;

/* JADX INFO: loaded from: classes.dex */
public interface OnTaskFinishedListener {
    public static final OnTaskFinishedListener NOP = null;

    static /* synthetic */ void $r8$lambda$26Ab_iz6vs4RSW8ERwjFGkMzyrI(String r0) {
        lambda$static$0(r0);
    }

    void onFinished(String r1);

    static {
        NOP = new OnTaskFinishedListener$$ExternalSyntheticLambda0();
    }

    private static /* synthetic */ void lambda$static$0(String caller) {
    }
}
