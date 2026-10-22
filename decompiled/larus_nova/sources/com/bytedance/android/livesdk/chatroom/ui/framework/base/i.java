package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f112914a;

    public i() {
    }

    public void f() {
    }

    public void g(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
    }

    public void h() {
    }

    public void i(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
    }

    public void l() {
    }

    public void m() {
    }

    public void n() {
    }

    public void o() {
    }

    public void onDestroy() {
    }

    public void p() {
    }

    public void q() {
    }

    public void r(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public final a getContext() {
        a r100 = this.f112914a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        return r100;
    }
}
