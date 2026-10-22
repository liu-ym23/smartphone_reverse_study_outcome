package com.android.ttcjpaysdk.base.h5.jsb;

import android.content.Intent;

/* JADX INFO: loaded from: classes28.dex */
@FunctionalInterface
public interface OnActivityResultCallback {

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.base.h5.jsb.OnActivityResultCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onActivityResult(OnActivityResultCallback r100, int r101, int r102, Intent r103) {
            r100.onActivityResult(r101, r102, r103, null);
        }
    }

    void onActivityResult(int r100, int r101, Intent r102);

    void onActivityResult(int r100, int r101, Intent r102, Runnable r103);
}
