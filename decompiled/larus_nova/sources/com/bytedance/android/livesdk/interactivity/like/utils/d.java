package com.bytedance.android.livesdk.interactivity.like.utils;

import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.livesdk.message.model.d4;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.logsdk.format.Spm;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import u32.l;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements l.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f137725a = null;

    public d() {
    }

    static {
        f137725a = new d();
    }

    public final void a(String r100) {
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.a100.a175.a999").addArg("info", r100), "DoubleLikeTracer");
    }

    @Override // u32.l.a
    public final void b(l r100, com.bytedance.android.livesdk.interactivity.api.like.model.a r101) {
        Intrinsics.checkNotNullParameter(r100, "vm");
        Intrinsics.checkNotNullParameter(r101, "detail");
        a("onDoubleLikeStart, detail info is " + JsonUtil.toJSONString(r101));
    }

    @Override // u32.l.a
    public final void e(l r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "vm");
        a("onDoubleLikeEnd, local like count is " + r101);
    }

    @Override // u32.l.a
    public final void k(l r100, List<d4> r101) {
        Intrinsics.checkNotNullParameter(r100, "vm");
        Intrinsics.checkNotNullParameter(r101, "userRank");
        a("onDoubleLikeUserRankUpdate, list size is " + r101.size());
    }

    @Override // u32.l.a
    public final void l(l r100, com.bytedance.android.livesdk.interactivity.api.like.model.a r101) {
        Intrinsics.checkNotNullParameter(r100, "vm");
        Intrinsics.checkNotNullParameter(r101, "detail");
        a("onDoubleLikeRenewalUpdate, detail info is " + JsonUtil.toJSONString(r101));
    }

    @Override // u32.l.a
    public final void d(l r100, int r101, int r102, Text r103, Text r104) {
        Intrinsics.checkNotNullParameter(r100, "vm");
        Intrinsics.checkNotNullParameter(r103, "normalText");
        Intrinsics.checkNotNullParameter(r104, "joinText");
        a("onDoubleLikeSummary, local like count is " + r101 + ", real double like count is " + r102);
    }
}
