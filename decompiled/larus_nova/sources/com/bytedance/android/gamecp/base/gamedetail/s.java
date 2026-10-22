package com.bytedance.android.gamecp.base.gamedetail;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class s implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f51657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f51658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f51659c;

    @Override // com.bytedance.android.gamecp.base.gamedetail.x
    public final Drawable a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f51658b.a(r100);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.x
    public final Integer b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f51658b.b(r100);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.x
    public final Integer c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f51658b.c(r100);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.x
    public final String d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f51657a;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.x
    public final float e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f51659c;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.x
    public final Rect f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.x
    public final void g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public /* synthetic */ s(String r100, y r101) {
        this(r100, r101, 15.0f);
    }

    public s(String r100, y r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "buttonText");
        Intrinsics.checkNotNullParameter(r101, "btnUIStyle");
        this.f51657a = r100;
        this.f51658b = r101;
        this.f51659c = r102;
    }
}
