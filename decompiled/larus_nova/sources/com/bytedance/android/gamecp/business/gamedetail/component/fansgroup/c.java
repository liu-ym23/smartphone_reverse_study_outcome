package com.bytedance.android.gamecp.business.gamedetail.component.fansgroup;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.gamecp.business.gamedetail.base.model.GroupJoinStatus;
import com.bytedance.android.gamecp.common.utils.GameOrderMonitor;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.gamecp.common.utils.c1;
import com.bytedance.android.gamecp.host_api.model.user.IUser;
import com.bytedance.android.gamecp.host_api.model.user.User;
import com.bytedance.android.gamecp.host_api.util.gson.GsonHelper;
import com.bytedance.ies.sve_core.Store;
import com.bytedance.ies.sve_core.o;
import com.bytedance.ies.sve_core.u;
import com.bytedance.ies.sve_core.w;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wu.j3;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final User f54317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f54318e;

    public static final class a implements yv.a.InterfaceC8393a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f54319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.sve_core.a f54320b;

        @Override // yv.a.InterfaceC8393a
        public final void onFailure(JSONObject r110) {
            yr.b.b(4, "AudiencePlayGroupWidget", "join fail " + r110);
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L12
            c r101 = this.f54319a;     // Catch: Throwable -> L12
            int r102 = h.f54325b;     // Catch: Throwable -> L12
            Pair r103 = r101.c(new u("game_fans_group_join"));     // Catch: Throwable -> L12
            o r104 = (o) r103.component1();     // Catch: Throwable -> L12
            Function1 r105 = (Function1) r103.component2();     // Catch: Throwable -> L12
            if (r110 != null) goto L6;
        L10:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
        L15:
            if (r110 == null) goto L18;
            String r106 = JSONObjectProtectorUtils.getString(r110, "error_message");
            if (r106 == null) goto L18;
        L19:
            ToastUtil.b(r106, 0);
            GameOrderMonitor r107 = GameOrderMonitor.f57162b;
            JSONObject r108 = new JSONObject();
            JSONObject r109 = new JSONObject();
            String r111 = "";
            if (r110 == null) goto L25;
            String r112 = r110.optString("error_message", "");
            if (r112 == null) goto L25;
            r111 = r112;
        L25:
            hu.a.b(r108, "error_msg", r111);
            int r113 = -1;
            if (r110 == null) goto L28;
            r113 = r110.optInt("status_code", -1);
        L28:
            hu.a.a(r108, "error_code", r113);
            GameOrderMonitor.c(r107, "ttlive_reserve_game_playgroup_join", false, r108, r109, 20);
            return;
        L18:
            r106 = "加入失败，请重试";
            goto L19
        L6:
            if (JSONObjectProtectorUtils.getInt(r110, "status_code") != 7601) goto L10;
            if (((h) r104.b()) == null) goto L10;
            GroupJoinStatus r114 = GroupJoinStatus.APLLYING;     // Catch: Throwable -> L12
            Intrinsics.checkNotNullParameter(r114, "joinStatus");     // Catch: Throwable -> L12
            r105.invoke(new h(r114));     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Result.Companion r115 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L15
        }

        public a(c r100, com.bytedance.ies.sve_core.a r101) {
            this.f54319a = r100;
            this.f54320b = r101;
        }
    }

    public static final class b extends b7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f54321a;

        public b(String r100) {
            this.f54321a = r100;
        }

        @Override // b7.a, b7.b
        public final boolean onFallback(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorMessage");
            return TextUtils.isEmpty(this.f54321a);
        }
    }

    @Override // com.bytedance.ies.sve_core.h
    public final void a(com.bytedance.ies.sve_core.a r110) {
        Intrinsics.checkNotNullParameter(r110, "intent");
        if ((r110 instanceof k) == false) goto L41;
        k r100 = (k) r110;
        int r101 = com.bytedance.android.gamecp.business.gamedetail.component.fansgroup.b.f54316a[r100.f54327a.ordinal()];
        boolean r102 = true;
        if (r101 != 1) goto L7;
    L33:
        yv.a r103 = com.bytedance.android.gamecp.host_api.a.b().getHostAction();
        String r104 = r100.f54328b;
        String r105 = r100.f54329c;
        Long r106 = r100.f54330d;
        User r107 = this.f54317d;
        if (r107 == null) goto L36;
        String r108 = r107.getId();
    L37:
        r103.A2(r104, r105, r106, r108, new a(this, r110));
        return;
    L36:
        r108 = null;
        goto L37
    L7:
        if (r101 == 2) goto L33;
        if (r101 == 3) goto L33;
        if (r101 != 4) goto L43;
        String r109 = j3.f561333a.getValue();
        String r111 = UriProtector.getQueryParameter(UriProtector.parse(r109), "fallback_url");
        JsonArray r112 = new JsonArray();
        List<g> r113 = r100.f54331e;
        if (r113 == null) goto L19;
        Iterator<T> r114 = r113.iterator();
    L17:
        if (r114.hasNext() == false) goto L19;
        g r115 = (g) r114.next();
        JsonObject r116 = new JsonObject();
        r116.addProperty(r115.entryLimit, r115.meet);
        Unit r117 = Unit.INSTANCE;
        r112.add(r116);
    L19:
        Map r118 = MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "popup"), TuplesKt.to(GXTemplateKey.GAIAX_LAYER_GRAVITY, "bottom"), TuplesKt.to("hybrid_type", "lynx"), TuplesKt.to("mask_alpha", "0.3")});
        Intrinsics.checkNotNullParameter(r118, "params");
        if (r109 != null) goto L22;
    L25:
        if (r102 == false) goto L27;
        String r119 = "";
    L32:
        Uri r120 = UriProtector.parse(c1.c(r119, MapsKt.mapOf(TuplesKt.to("entry_limits", GsonProtectorUtils.toJson(GsonHelper.get(), r112))))).buildUpon().build();
        yr.b.b(4, "AudiencePlayGroupWidget", "open lynx : " + r120);
        com.bytedance.android.gamecp.host_api.a.b().getBrowserService().showHybridDialog(this.f54318e, r120, new b(r111));
        return;
    L27:
        Uri.Builder r121 = UriProtector.parse(r109).buildUpon();
        Iterator r122 = r118.entrySet().iterator();
    L29:
        if (r122.hasNext() == false) goto L31;
        Map.Entry r123 = (Map.Entry) r122.next();
        r121.appendQueryParameter((String) r123.getKey(), (String) r123.getValue());
        goto L29
    L31:
        r119 = r121.build().toString();
        goto L32
    L22:
        if (r109.length() == 0) goto L25;
        r102 = false;
        goto L25
    L43:
        return;
    }

    public c(Context r100, Store r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        super(r101);
        this.f54318e = r100;
        IUser r102 = com.bytedance.android.gamecp.host_api.a.b().getUserService().user().b();
        if ((r102 instanceof User) == true) goto L5;
        r102 = null;
    L5:
        this.f54317d = (User) r102;
    }
}
