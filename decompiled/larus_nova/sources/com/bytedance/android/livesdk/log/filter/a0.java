package com.bytedance.android.livesdk.log.filter;

import com.bytedance.android.livesdkapi.feed.constant.OpenFeedConstantKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a0 extends com.bytedance.android.livesdk.log.filter.a<n> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f153292c;

    public static final class a {
    }

    static {
    }

    public a0() {
        J(null);
    }

    public final void J(n r100) {
        this.f153291b.clear();
        String r101 = "1";
        if (r100 == null) goto L11;
        this.f153291b.put("channel_id", String.valueOf(r100.u()));
        this.f153291b.put(OpenFeedConstantKt.KEY_CHANNEL_NAME, r100.i());
        this.f153291b.put("member_number", String.valueOf(r100.B()));
        Map<String, String> r102 = this.f153291b;
        if (r100.c() == false) goto L7;
        String r103 = "1";
    L8:
        r102.put("is_creator", r103);
        if (r100.c() == true) goto L11;
        this.f153291b.put("creator_id", r100.q());
        this.f153291b.put("sec_creator_id", r100.p());
        goto L11
    L7:
        r103 = "0";
    L11:
        Map<String, String> r104 = this.f153291b;
        if (this.f153292c == true) goto L15;
        r101 = "0";
    L15:
        r104.put("is_tab_mode", r101);
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        super.a(r100);
        r100.putAll(this.f153291b);
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final /* bridge */ /* synthetic */ void setData(Object r100) {
        J((n) r100);
    }
}
