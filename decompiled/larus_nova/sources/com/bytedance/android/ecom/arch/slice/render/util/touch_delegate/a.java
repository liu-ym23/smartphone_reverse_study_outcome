package com.bytedance.android.ecom.arch.slice.render.util.touch_delegate;

import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f50776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f50777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f50778c;

    public a() {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101 != null) goto L5;
    L15:
        return false;
    L5:
        if (r101.getAction() != 0) goto L15;
        InputDevice r102 = InputDevice.getDevice(r101.getDeviceId());
        if (r102 == null) goto L9;
        boolean r103 = r102.isVirtual();
    L10:
        this.f50776a = r103;
        this.f50777b = r101.getDeviceId();
        if (r102 == null) goto L13;
        String r104 = r102.getName();
    L14:
        this.f50778c = r104;
        goto L15
    L13:
        r104 = null;
        goto L14
    L9:
        r103 = false;
        goto L10
    }
}
