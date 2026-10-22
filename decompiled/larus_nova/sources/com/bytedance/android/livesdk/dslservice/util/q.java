package com.bytedance.android.livesdk.dslservice.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class q implements yt1.n {
    public q() {
    }

    @Override // yt1.n
    public final void a(yt1.q r100, yt1.k r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
    }

    @Override // yt1.n
    public final boolean b(String r100, yt1.q r101) {
        return false;
    }

    @Override // yt1.n
    public final void e(yt1.q r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter("", "data");
    }

    @Override // yt1.n
    public final void f(Context r100, yt1.l r101, ArrayList<yt1.h> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // yt1.n
    public final void g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // yt1.n
    public final void release() {
    }

    @Override // yt1.n
    public final yt1.k c(yt1.o r100, String r101, Context r102, yt1.r r103, yt1.m r104) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new yt1.g(new View(r102));
    }

    @Override // yt1.n
    public final yt1.k d(yt1.o r100, String r101, ViewGroup r102, yt1.r r103, yt1.m r104) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "viewGroup");
        return new yt1.g(r102);
    }
}
