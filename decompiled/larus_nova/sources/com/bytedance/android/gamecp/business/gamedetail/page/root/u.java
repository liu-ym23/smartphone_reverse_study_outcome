package com.bytedance.android.gamecp.business.gamedetail.page.root;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class u implements n0<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f55601a;

    public u(n0 r100) {
        this.f55601a = r100;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.root.n0
    public final void a(n r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        n0 r101 = this.f55601a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.root.n0
    public final void d(n r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        n0 r101 = this.f55601a;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.root.n0
    public final void b(n r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        n0 r102 = this.f55601a;
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.root.o0
    public final void c(n r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        n0 r102 = this.f55601a;
        if (r102 == null) goto L6;
        r102.c(r100, r101);
        return;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.root.n0
    public final JSONObject e(n r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        n0 r102 = this.f55601a;
        if (r102 == null) goto L5;
        JSONObject r103 = (JSONObject) r102.e(r100, r101);
    L6:
        if (r103 == null) goto L8;
        return r103;
    L8:
        return new JSONObject(JSONObjectProtectorUtils.getString(tv5.a.b(r101), "data")).optJSONObject("structure");
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.root.o0
    public final void f(n r100, Object r101) {
        JSONObject r102 = (JSONObject) r101;
        Intrinsics.checkNotNullParameter(r100, "params");
        n0 r103 = this.f55601a;
        if (r103 == null) goto L6;
        r103.f(r100, r102);
        return;
    }
}
