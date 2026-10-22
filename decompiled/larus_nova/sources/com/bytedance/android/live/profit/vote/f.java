package com.bytedance.android.live.profit.vote;

import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.scope.o;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.profit.vote.model.f f89196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yz0.g f89197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final er2.a f89198c;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public final void a(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$putFunctionType");
        if (this.f89198c.q() == false) goto L6;
        r100.put("function_type", "ktv");
        return;
    }

    public final void c(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$putLiveType");
        ILiveMode r101 = IRoomKt_androidKt.getStreamType(this.f89197b.getRoom());
        int r102 = h1.f66189a;
        r100.put("live_type", i1.a(r101));
    }

    public final void d(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$putUserType");
        if (this.f89197b.isAnchor() == false) goto L5;
        String r101 = "anchor";
    L6:
        r100.put("user_type", r101);
        return;
    L5:
        r101 = "user";
        goto L6
    }

    public f(com.bytedance.android.live.profit.vote.model.f r100, yz0.g r101, er2.a r102) {
        Intrinsics.checkNotNullParameter(r100, "voteRepository");
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        Intrinsics.checkNotNullParameter(r102, "ktvRoomService");
        this.f89196a = r100;
        this.f89197b = r101;
        this.f89198c = r102;
    }
}
