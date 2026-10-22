package com.bytedance.android.gamecp.business.download;

import android.text.TextUtils;
import com.bytedance.android.gamecp.base.core.service.depend.PlatformSupportPkg;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class p {
    public String A;
    public String A0;
    public String B;
    public String B0;
    public String C;
    public String C0;
    public String D;
    public JSONArray D0;
    public String E;
    public int E0;
    public String F;
    public String F0;
    public String G;
    public final s G0;
    public String H;
    public final z H0;
    public com.bytedance.android.gamecp.business.gamedetail.base.model.k I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f52834J;
    public Integer K;
    public String L;
    public String M;
    public Integer N;
    public String O;
    public Map<String, String> P;
    public Long Q;
    public String R;
    public String S;
    public String T;
    public String U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public long Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<PlatformSupportPkg> f52835a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public String f52836a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, String> f52837b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public String f52838b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap<String, String> f52839c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public String f52840c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, String> f52841d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public String f52842d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f52843e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public String f52844e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f52845f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public String f52846f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f52847g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public String f52848g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f52849h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f52850h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f52851i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public String f52852i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f52853j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public double f52854j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f52855k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f52856k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<String> f52857l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public String f52858l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f52859m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public String f52860m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f52861n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public String f52862n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f52863o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public String f52864o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Boolean f52865p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public String f52866p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f52867q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public String f52868q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f52869r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public boolean f52870r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f52871s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f52872s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Integer f52873t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public String f52874t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f52875u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public String f52876u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f52877v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f52878v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f52879w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f52880w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f52881x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public long f52882x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f52883y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f52884y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f52885z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public long f52886z0;

    public static final class a {
    }

    static {
    }

    public final Map<String, String> a() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("install_game_name", this.f52836a0);
        String r101 = this.f52860m0;
        if (r101 == null) goto L5;
        String r102 = (String) r100.put("install_pkg_name", r101);
    L5:
        r100.put("back_url_config", "false");
        String r103 = this.f52871s;
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L24;
        return r100;
    L24:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L21
        String r106 = this.f52871s;     // Catch: Throwable -> L21
        if (r106 == null) goto L20;
        String r107 = new JSONObject(r106).optString(AdDownloadModel.JsonKey.BACKUP_URLS);     // Catch: Throwable -> L21
        if (new JSONArray(r107).length() <= 0) goto L19;
        r100.put("back_url_config", "true");     // Catch: Throwable -> L21
    L19:
        r100.put("g_back_url_list", r107);     // Catch: Throwable -> L21
    L20:
        return r100;
    L21:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return r100;
    L8:
        if (r103.length() == 0) goto L11;
        r104 = false;
        goto L12
    }

    public final boolean b() {
        if (TextUtils.isEmpty(this.f52864o0) == false) goto L13;
        return false;
    L13:
        if (new JSONObject(this.f52864o0).optInt("gamecp_is_ad", 0) != 1) goto L15;
        return true;
    L15:
        return false;
    L10:
        e = move-exception;
        yr.c.b("DownloadInfo", String.valueOf(e.getMessage()));
        return false;
    }

    public p() {
        this.f52835a = new ArrayList();
        this.f52837b = new HashMap();
        this.f52839c = new HashMap();
        this.f52841d = new HashMap();
        this.f52845f = "";
        this.f52847g = "";
        this.f52849h = "0";
        this.f52851i = "";
        this.f52855k = "";
        this.f52861n = "";
        this.f52863o = "";
        this.f52865p = Boolean.FALSE;
        this.f52869r = "";
        this.f52871s = "";
        this.f52873t = 0;
        this.f52875u = "";
        this.f52877v = "";
        this.f52879w = "";
        this.f52881x = "";
        this.f52883y = "";
        this.f52885z = "";
        this.A = "";
        this.B = "";
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = "";
        this.G = "";
        this.H = "0";
        this.f52834J = "";
        this.K = 0;
        this.L = "";
        this.M = "";
        this.N = 0;
        this.O = "";
        this.Q = 2L;
        this.R = "0";
        this.S = "0";
        this.T = "";
        this.V = "";
        this.W = "";
        this.X = "";
        this.Y = "";
        this.f52836a0 = "";
        this.f52838b0 = "";
        this.f52840c0 = "";
        this.f52842d0 = "";
        this.f52844e0 = "";
        this.f52846f0 = "";
        this.f52848g0 = "";
        this.f52852i0 = "";
        this.f52858l0 = "";
        this.f52860m0 = "";
        this.f52862n0 = "";
        this.f52864o0 = "";
        this.f52866p0 = "";
        this.f52868q0 = "";
        this.f52884y0 = -1;
        this.A0 = "";
        this.B0 = "";
        this.C0 = "";
        this.E0 = 1;
        this.F0 = "";
        this.G0 = new s();
        this.H0 = new z();
    }

    public final void c(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f52835a = com.bytedance.android.gamecp.business.download.multichannel.e.j(r100);
        if (TextUtils.isEmpty(this.G) == false) goto L17;
        Iterator<T> r101 = this.f52835a.iterator();
    L7:
        String r102 = null;
        if (r101.hasNext() == false) goto L12;
        Object r103 = r101.next();
        if (Intrinsics.areEqual(((PlatformSupportPkg) r103).getName(), this.f52860m0) == false) goto L7;
    L13:
        PlatformSupportPkg r104 = (PlatformSupportPkg) r103;
        if (r104 == null) goto L16;
        r102 = r104.getOpenGameUrl();
    L16:
        this.G = r102;
        goto L17
    L12:
        r103 = null;
    L17:
        yr.c.a("AllChannelGameOpener", "allChannelPkgList:" + this.f52835a);
    }
}
