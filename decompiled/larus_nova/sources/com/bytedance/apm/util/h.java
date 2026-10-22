package com.bytedance.apm.util;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements ff7.c {
    public h() {
    }

    @Override // ff7.c
    public final void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // ff7.c
    public final void onActivityPause(Activity r100) {
    }

    @Override // ff7.c
    public final void onActivityResume(Activity r100) {
    }

    @Override // ff7.c
    public final void onActivityStarted(Activity r100) {
    }

    @Override // ff7.c
    public final void onBackground(Activity r100) {
    }

    @Override // ff7.c
    public final void onChange(Activity r100, Fragment r101) {
    }

    @Override // ff7.c
    public final void onFront(Activity r100) {
        if (Build.VERSION.SDK_INT < 23) goto L14;
        float r101 = r100.getWindowManager().getDefaultDisplay().getRefreshRate();
        i.f190673e = i.a(r101);
        if (com.bytedance.apm.d.f190532t == false) goto L15;
        int r102 = i.a(r101);
        i.f190670b = r102;
        if (r102 != i.f190671c) goto L11;
        boolean r103 = true;
    L12:
        i.f190672d = r103;
        i.f190669a = 1000.0f / r102;
        return;
    L11:
        r103 = false;
        goto L12
    L15:
        return;
    }
}
