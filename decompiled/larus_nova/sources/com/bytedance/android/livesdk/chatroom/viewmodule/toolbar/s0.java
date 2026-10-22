package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.view.MotionEvent;
import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s0 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r0 f116706a;

    public s0(r0 r100) {
        this.f116706a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "event");
        return this.f116706a.b(r101.getAction(), r101.getX(), r101.getY(), "2");
    }
}
