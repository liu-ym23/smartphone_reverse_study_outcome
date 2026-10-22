package com.bytedance.android.ec.sdk.helper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupWindow;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i implements oj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f48124a = null;

    public i() {
    }

    static {
        f48124a = new i();
    }

    @Override // oj.a
    public final void b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        d.f48119b.getIECHostUIService().b(r100);
    }

    @Override // oj.a
    public final oj.b d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return d.f48119b.getIECHostUIService().d(r100);
    }

    @Override // oj.a
    public final Typeface a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "fontName");
        return d.f48119b.getIECHostUIService().a(r100, r101);
    }

    @Override // oj.a
    public final PopupWindow c(Activity r100, View r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "anchorView");
        Intrinsics.checkNotNullParameter(r102, "params");
        return d.f48119b.getIECHostUIService().c(r100, r101, r102);
    }

    @Override // oj.a
    public final void e(Context r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "content");
        d.f48119b.getIECHostUIService().e(r100, r101, r102, r103);
    }
}
