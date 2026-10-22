package com.stepos.common.animator;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public final class j implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f11298a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ W.m f11299b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f11300c;

    public j(m mVar, View view, W.m mVar2) {
        this.f11300c = mVar;
        this.f11298a = view;
        this.f11299b = mVar2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.f11300c.c(this.f11298a, motionEvent, this.f11299b);
        return false;
    }
}
