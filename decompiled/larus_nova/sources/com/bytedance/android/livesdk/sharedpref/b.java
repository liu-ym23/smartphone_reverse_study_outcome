package com.bytedance.android.livesdk.sharedpref;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.core.setting.a0;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdk.config.LiveAnchorOneOffKeys;
import com.bytedance.android.livesdk.config.e41;
import com.bytedance.android.livesdk.config.he1;
import com.bytedance.android.livesdk.config.nc1;
import com.bytedance.android.livesdk.config.t6;
import com.bytedance.android.livesdk.config.x;
import com.bytedance.android.livesdk.model.VSUserGuideControllerData;
import com.bytedance.android.livesdk.model.XTCategory;
import com.bytedance.android.livesdk.model.c1;
import com.bytedance.android.livesdk.model.d0;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LocalComponentXLoadConfig;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.huawei.easygo.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;

/* JADX INFO: loaded from: classes11.dex */
public interface b {
    public static final e<Boolean> A = null;
    public static final e<Boolean> A0 = null;
    public static final e<Integer> A1 = null;
    public static final e<SparseArray<String>> A2 = null;
    public static final e<Boolean> A3 = null;
    public static final e<Integer> B = null;
    public static final e<Boolean> B0 = null;
    public static final e<Long> B1 = null;
    public static final e<String> B2 = null;
    public static final e<Boolean> B3 = null;
    public static final e<String> C = null;
    public static final e<Integer> C0 = null;
    public static final e<List<String>> C1 = null;
    public static final e<Long> C2 = null;
    public static final e<Integer> C3 = null;
    public static final e<Pair<String, String>> D = null;
    public static final e<Integer> D0 = null;
    public static final e<Long> D1 = null;
    public static final e<Boolean> D2 = null;
    public static final e<Boolean> D3 = null;
    public static final e<String> E = null;
    public static final e<Boolean> E0 = null;
    public static final e<String> E1 = null;
    public static final e<Boolean> E2 = null;
    public static final e<Boolean> E3 = null;
    public static final e<Long> F = null;
    public static final e<Boolean> F0 = null;
    public static final e<Boolean> F1 = null;
    public static final e<Map<String, String>> F2 = null;
    public static final e<Long> F3 = null;
    public static final e<Map<Long, String>> G = null;
    public static final e<Boolean> G0 = null;
    public static final e<Boolean> G1 = null;
    public static final e<Boolean> G2 = null;
    public static final e<Integer> G3 = null;
    public static final e<String> H = null;
    public static final e<Boolean> H0 = null;
    public static final e<Boolean> H1 = null;
    public static final e<Boolean> H2 = null;
    public static final e<Long> H3 = null;
    public static final e<Long> I = null;
    public static final e<Boolean> I0 = null;
    public static final e<Boolean> I1 = null;
    public static final e<Boolean> I2 = null;
    public static final e<Boolean> I3 = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final e<Integer> f158116J = null;
    public static final e<Boolean> J0 = null;
    public static final e<Boolean> J1 = null;
    public static final e<Map<String, String>> J2 = null;
    public static final e<Boolean> J3 = null;
    public static final e<Integer> K = null;
    public static final e<Boolean> K0 = null;
    public static final e<Integer> K1 = null;
    public static final e<HashMap<String, Number>> K2 = null;
    public static final e<Boolean> K3 = null;
    public static final e<Boolean> L = null;
    public static final e<Boolean> L0 = null;
    public static final e<Boolean> L1 = null;
    public static final e<HashMap<String, Number>> L2 = null;
    public static final e<Integer> L3 = null;
    public static final e<String> M = null;
    public static final e<Boolean> M0 = null;
    public static final e<Boolean> M1 = null;
    public static final e<HashMap<String, List<String>>> M2 = null;
    public static final e<Boolean> M3 = null;
    public static final e<Boolean> N = null;
    public static final e<Boolean> N0 = null;
    public static final e<Boolean> N1 = null;
    public static final e<Integer> N2 = null;
    public static final e<Map<String, String>> N3 = null;
    public static final e<Boolean> O = null;
    public static final e<Boolean> O0 = null;
    public static final e<Boolean> O1 = null;
    public static final e<Boolean> O2 = null;
    public static final e<Boolean> O3 = null;
    public static final e<Boolean> P = null;
    public static final e<Boolean> P0 = null;
    public static final e<Boolean> P1 = null;
    public static final e<Long> P2 = null;
    public static final e<x> P3 = null;
    public static final e<Boolean> Q = null;
    public static final e<Boolean> Q0 = null;
    public static final e<Long> Q1 = null;
    public static final e<Map<String, Boolean>> Q2 = null;
    public static final e<ArrayList<LocalComponentXLoadConfig>> Q3 = null;
    public static final e<String> R = null;
    public static final e<Boolean> R0 = null;
    public static final e<Boolean> R1 = null;
    public static final e<LongSparseArray<Boolean>> R2 = null;
    public static final e<Map<String, Boolean>> R3 = null;
    public static final e<String> S = null;
    public static final e<Boolean> S0 = null;
    public static final e<Boolean> S1 = null;
    public static final e<Map<String, Pair<Long, Integer>>> S2 = null;
    public static final e<Boolean> S3 = null;
    public static final e<String> T = null;
    public static final e<Boolean> T0 = null;
    public static final e<Integer> T1 = null;
    public static final e<Integer> T2 = null;
    public static final e<he1> T3 = null;
    public static final e<Boolean> U = null;
    public static final e<Boolean> U0 = null;
    public static final e<Integer> U1 = null;
    public static final e<Long> U2 = null;
    public static final e<Long> U3 = null;
    public static final e<Boolean> V = null;
    public static final e<Boolean> V0 = null;
    public static final e<Boolean> V1 = null;
    public static final e<Long> V2 = null;
    public static final e<Boolean> V3 = null;
    public static final e<Boolean> W = null;
    public static final e<Integer> W0 = null;
    public static final e<Map<String, Boolean>> W1 = null;
    public static final e<Boolean> W2 = null;
    public static final e<Long> W3 = null;
    public static final e<Boolean> X = null;
    public static final e<Integer> X0 = null;
    public static final e<Boolean> X1 = null;
    public static final e<Boolean> X2 = null;
    public static final e<Boolean> X3 = null;
    public static final e<Boolean> Y = null;
    public static final e<Boolean> Y0 = null;
    public static final e<HashMap<String, Boolean>> Y1 = null;
    public static final e<Boolean> Y2 = null;
    public static final e<Boolean> Z = null;
    public static final e<Boolean> Z0 = null;
    public static final e<Boolean> Z1 = null;
    public static final e<Integer> Z2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<Integer> f158117a = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final e<Boolean> f158118a0 = null;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final e<Boolean> f158119a1 = null;

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    public static final e<Boolean> f158120a2 = null;

    /* JADX INFO: renamed from: a3, reason: collision with root package name */
    public static final e<Integer> f158121a3 = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e<Boolean> f158122b = null;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final e<HashSet<Integer>> f158123b0 = null;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final e<Boolean> f158124b1 = null;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public static final e<Map<String, Long>> f158125b2 = null;

    /* JADX INFO: renamed from: b3, reason: collision with root package name */
    public static final e<Boolean> f158126b3 = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e<String> f158127c = null;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final e<Boolean> f158128c0 = null;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public static final e<Integer> f158129c1 = null;

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    public static final e<Boolean> f158130c2 = null;

    /* JADX INFO: renamed from: c3, reason: collision with root package name */
    public static final e<Boolean> f158131c3 = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e<Map<String, Integer>> f158132d = null;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final e<Long> f158133d0 = null;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final e<Boolean> f158134d1 = null;

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    public static final e<Boolean> f158135d2 = null;

    /* JADX INFO: renamed from: d3, reason: collision with root package name */
    public static final e<Long> f158136d3 = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e<Map<String, String>> f158137e = null;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final e<String> f158138e0 = null;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static final e<Boolean> f158139e1 = null;

    /* JADX INFO: renamed from: e2, reason: collision with root package name */
    public static final e<Long> f158140e2 = null;

    /* JADX INFO: renamed from: e3, reason: collision with root package name */
    public static final e<Boolean> f158141e3 = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e<Map<String, Long>> f158142f = null;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final e<Boolean> f158143f0 = null;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public static final e<Integer> f158144f1 = null;

    /* JADX INFO: renamed from: f2, reason: collision with root package name */
    public static final e<Boolean> f158145f2 = null;

    /* JADX INFO: renamed from: f3, reason: collision with root package name */
    public static final e<Long> f158146f3 = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e<Map<String, Boolean>> f158147g = null;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final e<Boolean> f158148g0 = null;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final e<Integer> f158149g1 = null;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public static final e<Boolean> f158150g2 = null;

    /* JADX INFO: renamed from: g3, reason: collision with root package name */
    public static final e<Boolean> f158151g3 = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e<Long> f158152h = null;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final e<Boolean> f158153h0 = null;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final e<Integer> f158154h1 = null;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public static final e<Boolean> f158155h2 = null;

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    public static final e<Boolean> f158156h3 = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e<Long> f158157i = null;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final e<Boolean> f158158i0 = null;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public static final e<Boolean> f158159i1 = null;

    /* JADX INFO: renamed from: i2, reason: collision with root package name */
    public static final e<Boolean> f158160i2 = null;

    /* JADX INFO: renamed from: i3, reason: collision with root package name */
    public static final e<Boolean> f158161i3 = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e<Long> f158162j = null;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final e<Boolean> f158163j0 = null;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public static final e<Boolean> f158164j1 = null;

    /* JADX INFO: renamed from: j2, reason: collision with root package name */
    public static final e<Boolean> f158165j2 = null;

    /* JADX INFO: renamed from: j3, reason: collision with root package name */
    public static final e<String> f158166j3 = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e<Boolean> f158167k = null;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final e<Boolean> f158168k0 = null;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final e<Integer> f158169k1 = null;

    /* JADX INFO: renamed from: k2, reason: collision with root package name */
    public static final e<Boolean> f158170k2 = null;

    /* JADX INFO: renamed from: k3, reason: collision with root package name */
    public static final e<Integer> f158171k3 = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final e<Boolean> f158172l = null;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final e<Boolean> f158173l0 = null;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static final e<Integer> f158174l1 = null;

    /* JADX INFO: renamed from: l2, reason: collision with root package name */
    public static final e<Map<String, String>> f158175l2 = null;

    /* JADX INFO: renamed from: l3, reason: collision with root package name */
    public static final e<Boolean> f158176l3 = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final e<Boolean> f158177m = null;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final e<Boolean> f158178m0 = null;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final e<Boolean> f158179m1 = null;

    /* JADX INFO: renamed from: m2, reason: collision with root package name */
    public static final e<Boolean> f158180m2 = null;

    /* JADX INFO: renamed from: m3, reason: collision with root package name */
    public static final e<Boolean> f158181m3 = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final e<Boolean> f158182n = null;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final e<String> f158183n0 = null;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static final e<String> f158184n1 = null;

    /* JADX INFO: renamed from: n2, reason: collision with root package name */
    public static final e<Boolean> f158185n2 = null;

    /* JADX INFO: renamed from: n3, reason: collision with root package name */
    public static final e<Boolean> f158186n3 = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final e<Boolean> f158187o = null;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final e<String> f158188o0 = null;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static final e<HashMap<String, String>> f158189o1 = null;

    /* JADX INFO: renamed from: o2, reason: collision with root package name */
    public static final e<Map<String, String>> f158190o2 = null;

    /* JADX INFO: renamed from: o3, reason: collision with root package name */
    public static final e<Long> f158191o3 = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final e<Boolean> f158192p = null;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final e<Set<String>> f158193p0 = null;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final e<Boolean> f158194p1 = null;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public static final e<c1> f158195p2 = null;

    /* JADX INFO: renamed from: p3, reason: collision with root package name */
    public static final e<Boolean> f158196p3 = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final e<Boolean> f158197q = null;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final e<Boolean> f158198q0 = null;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public static final e<Integer> f158199q1 = null;

    /* JADX INFO: renamed from: q2, reason: collision with root package name */
    public static final e<Long> f158200q2 = null;

    /* JADX INFO: renamed from: q3, reason: collision with root package name */
    public static final e<Boolean> f158201q3 = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final e<Boolean> f158202r = null;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final e<Boolean> f158203r0 = null;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public static final e<Long> f158204r1 = null;

    /* JADX INFO: renamed from: r2, reason: collision with root package name */
    public static final e<LiveAnchorOneOffKeys> f158205r2 = null;

    /* JADX INFO: renamed from: r3, reason: collision with root package name */
    public static final e<String> f158206r3 = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final e<Integer> f158207s = null;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final e<Boolean> f158208s0 = null;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public static final e<Map<String, String>> f158209s1 = null;

    /* JADX INFO: renamed from: s2, reason: collision with root package name */
    public static final e<Set<String>> f158210s2 = null;

    /* JADX INFO: renamed from: s3, reason: collision with root package name */
    public static final e<String> f158211s3 = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final e<Boolean> f158212t = null;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final e<Boolean> f158213t0 = null;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public static final e<Long> f158214t1 = null;

    /* JADX INFO: renamed from: t2, reason: collision with root package name */
    public static final e<Map<String, Map<String, Double>>> f158215t2 = null;

    /* JADX INFO: renamed from: t3, reason: collision with root package name */
    public static final e<Boolean> f158216t3 = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final e<Boolean> f158217u = null;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final e<Boolean> f158218u0 = null;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public static final e<Long> f158219u1 = null;

    /* JADX INFO: renamed from: u2, reason: collision with root package name */
    public static final e<Integer> f158220u2 = null;

    /* JADX INFO: renamed from: u3, reason: collision with root package name */
    public static final e<Boolean> f158221u3 = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final e<LinkedHashMap<String, String>> f158222v = null;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final e<Boolean> f158223v0 = null;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final e<Integer> f158224v1 = null;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final e<Set<String>> f158225v2 = null;

    /* JADX INFO: renamed from: v3, reason: collision with root package name */
    public static final e<String> f158226v3 = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final e<Map<String, String>> f158227w = null;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final e<Boolean> f158228w0 = null;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public static final e<Long> f158229w1 = null;

    /* JADX INFO: renamed from: w2, reason: collision with root package name */
    public static final e<ConcurrentHashMap<String, String>> f158230w2 = null;

    /* JADX INFO: renamed from: w3, reason: collision with root package name */
    public static final e<Integer> f158231w3 = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final e<String> f158232x = null;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final e<Boolean> f158233x0 = null;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public static final e<Long> f158234x1 = null;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public static final e<HashMap<String, List<nc1>>> f158235x2 = null;

    /* JADX INFO: renamed from: x3, reason: collision with root package name */
    public static final e<Boolean> f158236x3 = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final e<List<String>> f158237y = null;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final e<Boolean> f158238y0 = null;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public static final e<String> f158239y1 = null;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public static final e<HashMap<String, String>> f158240y2 = null;

    /* JADX INFO: renamed from: y3, reason: collision with root package name */
    public static final e<Boolean> f158241y3 = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final e<Map<String, String>> f158242z = null;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final e<Boolean> f158243z0 = null;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public static final e<Map<String, Long>> f158244z1 = null;

    /* JADX INFO: renamed from: z2, reason: collision with root package name */
    public static final e<HashMap<String, String>> f158245z2 = null;

    /* JADX INFO: renamed from: z3, reason: collision with root package name */
    public static final e<Map<String, Boolean>> f158246z3 = null;

    static {
        Boolean r100 = Boolean.FALSE;
        new e("jump_to_room_dialog", r100);
        new e("gift_list_type", new HashSet());
        new e("gift_urls", new HashSet());
        new e("assets_cache_data", "");
        new e("assets_cache_last_check_time", 0L);
        new e("live_broadcast_room_type", 0);
        f158117a = new e("live_camera_type", 1);
        f158122b = new e("live_camera_mirror", r100);
        new e("live_media_camera_mirror", r100);
        f158127c = new e("live_resource_current_version", "");
        f158132d = new e("live_link_pk_bubble_show_count", new HashMap());
        f158137e = new e("live_link_rev_rtc_data", new HashMap());
        f158142f = new e("live_link_pk_bubble_show_tip_date", new HashMap());
        f158147g = new e("live_link_pk_red_dot_show", new HashMap());
        new e("last_share_channel", "");
        Boolean r101 = Boolean.TRUE;
        new e("first_enter_live_start", r101);
        new e("location_hint_shown_count", 0);
        f158152h = new e("current_room_id", 0L);
        new e("live_is_streaming", r100);
        f158157i = new e("current_room_start_time", 0L);
        new e("current_preview_start_time", 0L);
        new e("current_preview_start_time_v2", 0L);
        new e("current_preview_start_time_v3", 0L);
        f158162j = new e("current_preview_start_live_button_click_time", 0L);
        new e("live_last_active_time", 0L);
        new e("live_stream_video_capture_last_time", 0L);
        new e("live_stream_audio_capture_last_time", 0L);
        new e("live_broadcast_xt_category", new XTCategory());
        new e("live_broadcast_game_category", "");
        new e("live_broadcast_video_category", "");
        new e("live_broadcast_gme_category_local_cache", "");
        new e("live_show_record_popup", r101);
        f158167k = new e("live_ec_flash_red_dot_click_ever", r100);
        f158172l = new e("live_show_backtrace_tip_popup", r101);
        f158177m = new e("live_show_backtrace_red_dot", r101);
        f158182n = new e("live_preview_enable_auto_gl_recycler_sp", r100);
        new e("live_create_room_button_click_duration", -1L);
        new e("live_broadcast_start_push_time", -1L);
        new e("live_create_room_is_continue", r100);
        f158187o = new e("audience_show_backtrace_red_dot", r101);
        f158192p = new e("anchor_show_backtrace_red_dot", r101);
        new e("show_broadcast_info_red_dot", r101);
        f158197q = new e("live_show_live_matrix_red_dot", r101);
        e<Boolean> r102 = b6.f65222a;
        f158202r = new e("live_fans_group_share_bubble_is_ever_clicked", r100);
        f158207s = new e("live_fans_group_share_with_out_click_count", 0);
        f158212t = new e("live_landscape_pic_type_setting_red_dot", r101);
        f158217u = new e("live_shake_match_setting_red_dot", r101);
        new e("live_broadcast_camera_ditry", new HashMap());
        new e("live_broadcast_camera_ditry_last_toast", new HashMap());
        new e("live_broadcast_camera_ditry_next_check", new HashMap());
        new e("live_room_create_info_api_end_time", -1L);
        new e("live_start_live_fragment_show_time", -1L);
        f158222v = new e("live_j_auth_tips_count", new LinkedHashMap());
        f158227w = new e("live_gift_lynx_mapping", new HashMap());
        f158232x = new e("live_lynx_debug_ip_port", "");
        f158237y = new e("live_lynx_page_history", new ArrayList());
        new e("live_broadcast_restart_effect_id_new", new ArrayList());
        new e("live_broadcast_restart_common_interact_effect_msg_arg3", "");
        new e("live_broadcast_restart_room_id", 0L);
        new e("live_broadcast_restart_notice_room_id", "");
        f158242z = new e("live_lynx_page_history_debug", new HashMap());
        A = new e("live_anchor_guard_box_show", r100);
        new e("gift_panel_opened_guide_url", new HashSet());
        new e("new_gift_notify_has_showed_id", 0L);
        new e("showed_doodle_template_popup_tip", r100);
        new e("live_gift_cup_recognition_current_times_today", new HashMap());
        new e("live_start_live_anchor", 0L);
        new e("live_preview_beauty_show_state", r100);
        new e("live_preview_makeup_show_state", r100);
        new e("live_preview_filter_show_state", r100);
        new e("live_preview_mp_show_state", r100);
        new e("live_preview_poi_add_state", r100);
        new e("live_preview_poi_add_state_in_daily", r100);
        B = new e("live_preview_location_show_state", 0);
        new e("live_preview_location_show_state_in_daily", 0);
        new e("live_preview_location_add_poi_notice_has_show", r100);
        new e("live_preview_location_closed_actively", r100);
        new e("live_preview_location_exposure_count", 0);
        new e("live_preview_location_has_shown", r100);
        new e("live_end_live_location_exposure_count", 0);
        new e("live_start_live_has_prompted_location", r100);
        C = new e("live_start_live_mode", "VIDEO");
        new e("live_start_page_title_type_name", "");
        new e("live_last_start_live_timestamp", 0L);
        new e("live_stable_mode_first_time", r101);
        new e("live_last_start_live_room_id", 0L);
        new e("live_broadcast_continue_dialog_show_count", new HashMap());
        new e("live_last_start_live_process_id", 0);
        new e("live_least_start_live_room_process_id", new Pair("0", "0"));
        D = new e("live_last_close_room_error_code", new Pair("0", "0"));
        E = new e("live_last_start_live_scene", "");
        new e("live_start_live_tag", new HashMap());
        new e("live_beauty_feedback_clicked", r100);
        new e("live_prompt_game", new Pair(r100, "0"));
        new e("live_broadcast_restart_room", "");
        new e("live_broadcast_stable_mode_push_timestamp", 0L);
        new e("live_prompt_game_count", 0);
        F = new e("live_broadcast_page_start_time", 0L);
        new e("live_start_live_notice_content", new Pair(0L, ""));
        G = new e("live_start_live_notice_content_saved", new HashMap());
        new e("live_preview_last_audio_interact_mode", 0);
        H = new e("live_last_start_live_uid", "0");
        new e("live_has_start_broadcast", r100);
        new e("live_preview_more_operation_pop_up_v3", r101);
        new e("live_preview_more_gift_pop_up", r101);
        new e("live_preview_more_link_video_pop_up", r101);
        new e("live_preview_more_camera_movement_pop_up", r101);
        new e("live_preview_more_anchor_red_packet_pop_up", r101);
        new e("live_preview_more_anchor_vertical_landscape_pop_up", r101);
        new e("live_preview_more_anchor_red_packet_red_point_showed", r100);
        new e("live_preview_more_anchor_vertical_landscape_red_point_showed", r100);
        new e("live_last_click_start_live_time", 0L);
        new e("live_has_entered_start_live_once", r100);
        new e("live_should_auto_show_inspiration_panel_times", 0);
        new e("live_last_preview_page_show_time", 0L);
        new e("prop_panel_showed_red_point", new HashSet());
        new e("privilege_panel_lock_showed_red_point", new HashSet());
        new e("privilege_red_point_first_time", 0L);
        new e("fast_gift_hide_confirm_gift_by_id", new HashSet());
        new e("fast_gift_hide_confirm_gift_by_price", new HashSet());
        new e("fast_gift_hide_confirm_gift_date", new HashMap());
        new e("fast_gift_error_confirm_next_check", r100);
        new e("gift_price_on_gift_guide_dialog", new HashSet());
        I = new e("request_user_consume_info_time_stamp", 0L);
        new e("live_gift_custom_gift_card_has_remind", new HashSet());
        new e("live_gift_custom_gift_card_remind_time", new HashMap());
        f158116J = new e("request_user_consume_info_level", -1);
        K = new e("room_notify_message_showed_count", 0);
        new e("gift_exhibition_entry_is_clicked", r100);
        new e("group_live_room_guide_is_showed", r100);
        new e("live_gift_receiver_room_hint_count", new LruCache());
        new e("live_gift_receiver_hint_count", 0);
        new e("live_broadcast_preview_landscape_ratio", new Pair(0, 0));
        new e("gift_has_selected_by_user_in_client_str", new HashSet());
        new e("gift_first_time_combo_hint", new HashMap());
        new e("gift_sweep_light_show_times", new HashMap());
        Float r110 = Float.valueOf(1.0f);
        new e("barrage_alpha", r110);
        new e("barrage_size", r110);
        new e("barrage_local_type", 2);
        new e("barrage_enable", r101);
        L = new e("room_auto_gift_thanks", r100);
        new e("game_quiz_anchor_tip_show", r100);
        new e("live_guide_to_feed_show_time", 0L);
        M = new e("gift_guide_flag", "");
        new e("live_game_promote_message_history", new t6());
        new e("live_game_float_window_background_opacity", -1);
        new e("live_game_guide_message_history", new HashMap());
        new e("live_game_quit_click", r100);
        new e("live_share_get_diamonds_tip", r101);
        new e("live_game_msg_state", 0);
        new e("live_game_msg_enabled", r101);
        new e("live_game_promote_shown_before_float_hidden", r100);
        new e("live_game_play_together_shown_before_float_hidden", r100);
        new e("live_game_comment_msg_push", r101);
        new e("live_game_gift_msg_push", r101);
        new e("live_game_enter_msg_push", r101);
        new e("live_ctrl_window_x", -1);
        new e("live_ctrl_window_y", -1);
        new e("live_game_float_first_show", r101);
        new e("live_game_msg_first_snapped", r101);
        N = new e("live_full_video_button_guide_show", r100);
        new e("live_anchor_show_fans_club_push", r100);
        new e("live_anchor_show_fans_club_auto_light_4_anchor_push", r100);
        new e("live_anchor_show_fans_club_auto_light_4_audience_push", r100);
        O = b6.E;
        new e("show_backpack_tips", r101);
        new e("audience_show_bottom_rank_gide", r101);
        new e("anchor_show_bottom_rank_gide", r101);
        new e("guard_info_map", new HashMap());
        new e("vigo_show_start_live_flame_tip", r101);
        new e("vigo_show_end_live_flame_tip_count", 0);
        new e("package_purchase_showed", r100);
        new e("last_pay_channel", "");
        new e("recharge_dialog_balance_change_tip_shown", r100);
        new e("recharge_dialog_big_deal_hint_shown", r100);
        new e("open_account_get_red_packet_time", 0L);
        new e("open_account_get_red_packet_counts", 0);
        P = new e("has_request_bluetooth_permission", r100);
        new e("live_comment_danmu_state", r100);
        new e("vs_block_gift_for_test", r100);
        new e("vs_video_ai_danmaku_tip_show", r100);
        new e("vs_ai_danmaku_effect_version", "0");
        new e("vs_danmu_setting_function_reddot_type", new HashMap());
        new e("vs_ai_danmu_filter_reddot_clicked", r100);
        new e("vs_color_danmu_filter_reddot_clicked", r100);
        new e("vs_character_danmu_filter_reddot_clicked", r100);
        new e("vs_gif_danmu_filter_reddot_clicked", r100);
        new e("vs_shown_character_bubble_on_paletee", r100);
        new e("vs_landscape_long_press_guide_shown", r100);
        new e("vs_video_slide_guide_shown", r100);
        Q = new e("vs_show_gesture_guide", r101);
        new e("vs_video_right_slide_guide_shown", r100);
        new e("vs_user_guide_controller_data", new VSUserGuideControllerData());
        new e("over_write_barrage_setting", r101);
        new e("room_decoration_customize_text", "");
        new e("room_decoration_text_pass_level", 31);
        R = new e("room_decoration_anchor_id", "0");
        new e("room_decoration_anchor_open_id", "");
        S = new e("room_decoration_list", "");
        new e("show_room_decoration_toast", r101);
        new e("show_live_forenotice_decoration", r101);
        new e("live_interact_pk_duration", 300);
        new e("live_interact_pk_duration_index", 1);
        T = b6.f65259t;
        U = new e("show_enter_other_live_room_dialog", r101);
        V = b6.X;
        W = new e("live_can_show_auto_record_notice", r101);
        X = new e("live_can_auto_record", r100);
        Y = new e("live_already_show_long_press_guide", r100);
        Z = new e("live_already_show_image_recognition_guide", r100);
        f158118a0 = new e("live_video_scale_has_show_guide", r100);
        f158123b0 = new e("live_new_anchor_task_popup_scenes", new HashSet());
        f158128c0 = new e("live_interact_link_mute_confirm_dialog_should_show", r101);
        f158133d0 = new e("mobile_flow_show_time", 0L);
        new e("match_last_tab_id", 0L);
        new e("last_first_charge_bubble_show_time", "");
        new e("last_first_charge_bubble_text", "");
        new e("last_first_charge_bubble_show_info", new ArrayList());
        new e("diy_gift_toolbar_cache", new HashMap());
        new e("last_first_privilege_popup_show_time", "");
        new e("last_first_privilege_popup_show_time_info", new ArrayList());
        new e("recharge_dialog_content_height", 0);
        new e("cash_exchange_frequency_control", new HashMap());
        new e("tool_bar_first_charge_shake_times", "");
        new e("recharge_reward_popup_in_gift_dialog_timestamp", 0L);
        new e("live_last_turntable_bubble", "");
        new e("live_last_new_drive_count", 0L);
        new e("live_showd_drive_panel", r100);
        new e("live_recreation_center_red_dot", new HashMap());
        new e("live_recreation_bubble_text", "");
        f158138e0 = new e("last_first_quit_anchor_dialog", "");
        new e("last_first_more_anchor_guide", "");
        new e("last_first_more_search_guide", r100);
        new e("join_fans_comment_guide_times", 0);
        new e("latest_show_join_fans_comment_time", 0L);
        f158143f0 = new e("red_dot_has_shown_comment", r100);
        f158148g0 = new e("red_dot_has_shown_audio_comment", r100);
        f158153h0 = new e("tips_has_shown_audio_comment_broadcast", r100);
        new e("tips_has_shown_audio_comment_broadcast_close", r100);
        new e("tips_has_shown_audio_comment_audience", r100);
        f158158i0 = new e("live_video_float_window_guide_show", r100);
        new e("vs_video_float_window_guide_show", r100);
        new e("vs_video_float_window_used", r100);
        new e("vs_video_float_window_open_notified", r100);
        f158163j0 = new e("live_video_play_setting_show", r100);
        f158168k0 = new e("live_video_float_window_open", r100);
        new e("live_full_scene_float_window_open", r100);
        new e("vs_video_float_window_open", r100);
        new e("vs_first_open_hdr", r101);
        new e("live_vs_last_selected_resolution", "");
        new e("has_show_live_long_press_clear_screen_tips", r100);
        f158173l0 = new e("broadcast_has_show_start_zoom_guide", r100);
        f158178m0 = new e("has_slide_to_exit_room", r100);
        new e("has_show_guide_screen_record", r100);
        new e("has_show_guide_screen_record_confirm", r100);
        new e("has_show_guide_challenge_by_category", r100);
        new e("has_show_landscape_tip_screen_record", r100);
        new e("show_screen_record_window_permission_count", 0);
        new e("live_screen_record_last_permission_granted", r101);
        new e("welfare_last_complete_time", 0L);
        new e("starlight_anim_guide_count", 0);
        new e("starlight_text_guide_count", 0);
        new e("hotsoon_wallet_page_guide_shown", 0);
        new e("wallet_tab_cache_sp_key", 0);
        f158183n0 = new e("live_group_toolbar_red_dot_local", "");
        f158188o0 = new e("live_group_toolbar_admin_second_reddot_local", "");
        new e("live_pk_toolbar_red_dot_local", 0);
        new e("vs_vision_has_show", r100);
        f158193p0 = new e("live_game_toolbar_red_dot_local", new HashSet());
        new e("show_cash_exchange_diamond_red_dot", r100);
        new e("has_shown_send_red_packet", r100);
        new e("official_red_envelope_map", new HashMap());
        new e("cny_red_envelope_map", new HashMap());
        new e("official_task_packet_animation", r100);
        new e("star_room_open_red_packet_rooms", new HashSet());
        new e("star_room_open_red_packet_uids", new HashSet());
        new e("welfare_open_red_packet_time", 0L);
        new e("has_shown_gift_panel_vertical_slide_guide", r100);
        new e("douyin_fansclub_tips_anchor_map", new HashMap());
        new e("douyin_fansclub_tips_count_map", new HashMap());
        new e("rank_list_tip_count", 0);
        new e("douyin_game_tips_show", r101);
        f158198q0 = new e("talk_room_emoji_tips_show", r101);
        f158203r0 = new e("link_room_fight_tips_show", r101);
        new e("live_tab_recom_dialog_last_time", 0L);
        f158208s0 = new e("manage_button_tips_show", r101);
        f158213t0 = new e("manage_button_tips_show_refine", r101);
        f158218u0 = new e("manage_button_show_danmaku_tips", r101);
        f158223v0 = new e("manage_button_show_new_comment_tips", r101);
        f158228w0 = new e("config_button_show_admin_pin_tips", r101);
        f158233x0 = new e("audience_manage_button_tips_show", r101);
        f158238y0 = new e("block_word_pannel_tips_show", r101);
        f158243z0 = new e("broadcast_window_tips_show", r101);
        A0 = new e("broadcast_video_window_tips_show", r101);
        new e("broadcast_video_window_tips_dialog_not_show", r100);
        B0 = new e("broadcast_video_mark_highlight_dot_show", r101);
        C0 = new e("broadcast_video_mark_highlight_dot_show_times", 0);
        D0 = new e("broadcast_video_window_tips_show_times", 0);
        E0 = new e("broadast_fast_start_can_show", r101);
        new e("send_gift_group_count", new LongSparseArray());
        new e("send_prop_group_count", new LongSparseArray());
        new e("official_danmu_enable", r101);
        F0 = new e("official_gift_enable", r101);
        G0 = new e("landscape_lock_enable", r100);
        new e("sticker_tips_preview_enable", r101);
        new e("preview_has_selected_sticker", r100);
        new e("enable_show_landscape_doodle_tip", r101);
        H0 = b6.C;
        new e("live_record_show", r100);
        I0 = new e("live_gen_play_show", r100);
        new e("live_publish_show", r100);
        new e("live_gen_play_backup_show", r100);
        J0 = new e("live_playback_or_highlight", r100);
        K0 = new e("live_real_time_playback_show", r100);
        L0 = new e("live_gen_play_open", r100);
        new e("live_gen_play_open_use_default", r101);
        M0 = new e("live_real_time_playback_is_open", r100);
        N0 = new e("live_play_auto_publish", r100);
        new e("live_play_auto_publish_use_default", r101);
        O0 = new e("live_play_auto_sync_to_xt", r100);
        new e("live_play_auto_sync_to_xt_use_default", r101);
        P0 = new e("live_commerce_replay_switch", r100);
        Q0 = new e("live_commerce_replay_switch_enable", r101);
        R0 = new e("live_commerce_ask_explain_switch", r100);
        S0 = new e("live_replay_product_exposit_switch", r100);
        T0 = new e("live_replay_product_exposit_switch_enable", r101);
        U0 = new e("live_fans_group", r100);
        new e("live_fans_group_default", r101);
        new e("live_setting_gift_open", 1);
        V0 = new e("live_setting_gift_open_use_default", r101);
        new e("live_setting_gift_open_user_manual_changed", r100);
        W0 = new e("live_setting_comment_v2_chat_switch", 0);
        X0 = new e("live_setting_comment_v2_audio_action", 26);
        Y0 = new e("live_setting_comment_v2_audio_chat_open", r101);
        Z0 = new e("live_setting_comment_v2_audio_auto_play", r101);
        f158119a1 = new e("live_setting_comment_v2_video_share_open", r101);
        f158124b1 = new e("live_setting_paid_live_trial_user_chat", r101);
        f158129c1 = new e("live_setting_comment_room_channel_switch", 0);
        new e("live_setting_vip_open", r101);
        new e("live_setting_fans_club_open", r101);
        new e("live_setting_fans_club_mode_dot_shown", r100);
        new e("live_setting_redpacket_audience_open", r101);
        f158134d1 = new e("live_setting_anchor_gift_open_value", r101);
        new e("live_setting_sticker_gift_open_value", r101);
        new e("live_revenue_notice_expire_time", 0L);
        f158139e1 = new e("live_privilege_setting", r101);
        f158144f1 = new e("live_privilege_setting_follow", 0);
        f158149g1 = new e("live_privilege_setting_livew", 0);
        f158154h1 = new e("live_privilege_setting_fans", 0);
        f158159i1 = new e("live_privilege_barrage_hint", r100);
        new e("live_preview_dialog_paid_dot", r100);
        f158164j1 = new e("live_privilege_setting_dot", r100);
        new e("live_has_show_privilege_bubble", r100);
        new e("live_has_show_privilege_mask", r100);
        new e("fast_gift_hide_confirm_gift", new HashSet());
        new e("show_enter_other_live_room_dialog_of_hour_rank", r101);
        f158169k1 = new e("glide_task_guide_show_count", 0);
        f158174l1 = new e("glide_task_remain_show_count", 0);
        new e("one_penny_last_show_time", "");
        new e("one_penny_show_count", 0);
        new e("cash_exchange_gift_send_checked", r100);
        new e("duty_gift_last_rules", 0);
        new e("toolbar_consume_notice_dot_shown", r100);
        new e("vote_tips_show", r101);
        f158179m1 = new e("landscape_block_enable", r100);
        new e("live_pre_setting_comment_dot", r100);
        new e("live_setting_sync_live_open_default", r101);
        new e("ktv_anchor_search_history", new ArrayList());
        new e("has_show_new_drawer_slide_guide", r100);
        new e("has_open_drawer_by_click", r100);
        new e("has_open_drawer_by_slide", r100);
        new e("live_broadcast_admin_barrage_popup", r100);
        new e("live_screen_tab_open", r100);
        new e("live_screen_tab_position", -1);
        new e("live_recharge_exchange_confirm_show_time", 0L);
        new e("auth_success_tip_last_show", 0L);
        f158184n1 = new e("last_enter_open_id", "");
        f158189o1 = new e("last_time_show_auth_toast_with_open_id", new HashMap());
        new e("last_auth_or_daily_enter_toast_show_time", 0L);
        f158194p1 = new e("live_mini_app_video_view_is_show", r100);
        f158199q1 = new e("live_bottom_guide_show_count", 0);
        f158204r1 = new e("live_bottom_guide_show_time", 0L);
        f158209s1 = new e("individual_task_show_count", new HashMap());
        f158214t1 = new e("individual_task_show_time", 0L);
        new e("interact_audience_opened_camera", 0);
        f158219u1 = new e("last_cancel_auto_enter_time", 0L);
        f158224v1 = new e("cancel_times_before_interrupted", 0);
        f158229w1 = new e("next_can_show_auto_enter_guide_time", 0L);
        f158234x1 = new e("last_identity_cached_time", 0L);
        f158239y1 = new e("last_cached_identity", "");
        new e("last_cached_identity_host_app_id", "");
        new e("should_show_clear_screen_red_dot", r101);
        new e("should_show_clear_screen_entrance_guide", r100);
        new e("should_show_clear_screen_zoom_guide", r100);
        f158244z1 = new e("ad_live_show_duration", new HashMap());
        A1 = new e("ug_coupon_window_show_count", 0);
        B1 = new e("ug_coupon_window_last_show_time", 0L);
        C1 = new e("recent_use_emoji", new ArrayList());
        new e("fusion_pop_day_count", 0);
        new e("fusion_pop_total_count", 0);
        new e("fusion_pop_last_time", 0L);
        new e("gift_fusion_guide_text", "");
        new e("fans_club_fusion_guide_text", "");
        new e("fusion_guide_schema", "");
        new e("annie_contaniner_permission_disable", r100);
        new e("no_wifi_toast_last_time", 0L);
        D1 = new e("teen_mode_last_time", 0L);
        E1 = new e("teen_mode_current_user", "");
        F1 = new e("test_for_preload", r100);
        G1 = new e("live_setting_comment_open", r101);
        H1 = new e("live_setting_audience_share_open", r101);
        new e("live_record_open", r100);
        new e("live_record_open_use_default", r101);
        new e("live_room_play_tips_show", r101);
        new e("live_start_settting_tips_show", r101);
        new e("live_start_settting_dot_show", r101);
        new e("live_preview_choose_better_cdn_dot_show", 0);
        new e("live_preview_audience_see_others_profile_dot_show", r101);
        new e("live_preview_audience_see_others_profile_current_status", r101);
        new e("live_start_audio_theme_dot_show_v2", r101);
        new e("live_start_setting_forenotice_tips_show", r101);
        new e("live_start_setting_forenotice_dot_show", r101);
        new e("live_start_settting_dot_show_for_gift", r101);
        new e("live_setting_media_like_enable", r101);
        new e("live_start_broadcast_mirror", r101);
        new e("vs_cast_screen_pop_shown", r100);
        new e("new_interact_anchor_toolbar_tip_show", r101);
        new e("live_hash_tag_tips_in_room_enable", r101);
        new e("live_game_guide_show_count", new HashMap());
        new e("live_effect_game_data", new HashMap());
        new e("live_game_play_count", new HashMap());
        I1 = new e("live_effect_degrade_notice_window_switch", r100);
        J1 = new e("digg_first_receive_message_shown", r100);
        new e("timon_calendar_write_permission_denied", r100);
        new e("commerce_flash_shopping_guide", r100);
        new e("commerce_flash_shortcut_guide", r100);
        new e("filter_entry_clicked", r100);
        new e("force_insert_sticker_time_record", new HashMap());
        K1 = new e("commerce_goods_page_status", 0);
        L1 = new e("lite_user_choice_confirmed", r100);
        new e("activityk_last_complete_time", 0L);
        new e("activityk_last_animtion_time", 0L);
        new e("has_activity_show_guide_exit_room", new HashMap());
        new e("link_mic_support_admin_operate", r101);
        M1 = new e("link_mic_support_camera", r101);
        N1 = new e("linkmic_subtitle_anchor_setting_first_show", r100);
        new e("link_mic_alert_level", 2);
        new e("chat_room_link_mic_alert_first_show", r101);
        new e("video_talk_bid_link_mic_end_guide", r101);
        new e("video_talk_bid_turn_on_kick_out_online_guest", r101);
        new e("business_configure_show_time", new LruCache(100));
        O1 = new e("video_talk_integration_guide_setting_dot_shown", r100);
        P1 = new e("video_talk_integration_guide_enable_no_need_apply_shown", r100);
        Q1 = b6.f65223a0;
        new e("audience_link_mick_time_limited_payment_switch", r100);
        new e("pk_here_tips_count", 0);
        R1 = new e("anchor_link_is_turn_on", r101);
        S1 = new e("media_anchor_link_is_turn_on", r101);
        T1 = new e("media_live_interact_duration", 300);
        U1 = new e("media_live_interact_duration_index", 1);
        new e("anchor_link_accept_multi_linkmic", r101);
        new e("anchor_link_accept_not_follower_invite", r101);
        V1 = b6.V;
        new e("enable_shake_fast_match_default", Integer.valueOf(ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_UNSET.getValue()));
        new e("anchor_interact_pk_user_list_show_count", 0);
        new e("anchor_interact_pk_user_list_show_date", "");
        new e("live_broadcast_pause_guide", r101);
        new e("broadcast_pause_window_hint_times", 0);
        new e("broadcast_pause_times_per_each", 3);
        W1 = new e("interact_dynamic_item_red_dot_show", new HashMap());
        new e("has_show_anchor_backtrack_setting_dot_pre_live", r100);
        new e("has_show_anchor_backtrack_setting_dot_in_room", r100);
        X1 = new e("has_show_anchor_backtrack", r100);
        new e("has_show_anchor_backtrack_prelive_tip_guide", r100);
        new e("has_show_anchor_backtrack_liveroom_tip_guide", r100);
        new e("anchor_backtrack_switch", r101);
        new e("live_common_short_touch_animation_record", new HashMap());
        new e("live_broadcast_msg_filter_guide", r101);
        new e("live_broadcast_dot_platform_show_count", new HashMap());
        new e("live_group_chosen_id", new HashSet());
        Y1 = new e("live_broadcast_bubble_platform_has_show", new HashMap());
        new e("live_hiboard_toolbar_guide", r101);
        new e("live_hiboard_slide_bar_guide", r101);
        new e("live_hiboard_slide_bar_position", -1);
        Z1 = new e("live_selected_message_toolbar_guide", r101);
        new e("live_anchor_open_fans_prompt_count", 0);
        new e("live_anchor_open_fans_prompt_time", 0L);
        new e("has_show_guide_screenshot_cover_tips", r100);
        new e("has_show_guide_screenshot_cover_dialog", r100);
        new e("live_audio_float_click_tip", r101);
        f158120a2 = new e("live_feed_to_start_live", r100);
        f158125b2 = new e("live_feed_to_start_live_btn_frequency", new HashMap());
        new e("has_show_new_drawer_entrance_guide", r100);
        f158130c2 = new e("live_broadcast_window_click", r100);
        f158135d2 = new e("live_broadcast_video_window_click", r100);
        new e("live_broadcast_video_window_click_tips_show", r100);
        new e("live_broadcast_video_window_click_return_back", r100);
        f158140e2 = new e("live_broadcast_window_enable_time", 0L);
        f158145f2 = new e("live_broadcast_window_popup", r100);
        new e("live_broadcast_video_window_popup", r100);
        f158150g2 = new e("live_broadcast_admin_pin_popup", r100);
        f158155h2 = new e("live_broadcast_restart_popup_has_show", r100);
        f158160i2 = new e("live_broadcast_restart_popup_is_showing", r100);
        new e("live_broadcast_preview_customer_has_show", r100);
        f158165j2 = new e("live_broadcast_restart_continue", r100);
        f158170k2 = new e("live_first_time_to_start", r100);
        new e("live_show_highlight_guide", r100);
        f158175l2 = b6.Y;
        f158180m2 = new e("live_anchor_has_choose_resolution_key", r100);
        new e("live_quick_start_live_resolution_key", PlayerResolution.SDKKEY.HD);
        f158185n2 = new e("vs_enable_show_drawer_guide", r101);
        new e("live_vs_selected_resolution", "");
        new e("live_vs_replay_selected_resolution", "");
        f158190o2 = new e("live_vs_first_show_history_cache", new HashMap());
        new e("live_vs_first_show_latest_click_cache", new HashMap());
        f158195p2 = new e("live_vs_first_show_pop_property", new c1());
        f158200q2 = new e("live_vs_first_show_history_cache_time", 86400000L);
        new e("live_anchor_resolution_dialog_last_show", 0L);
        f158205r2 = new e("live_anchor_resolution_one_off_keys", new LiveAnchorOneOffKeys());
        new e("live_broadcast_window_close_dialog_show_count", 0);
        new e("live_sound_effect_show_guide_popup", r101);
        new e("live_sound_effect_entrance_reddot", r101);
        f158210s2 = new e("live_watched_room_ids", new LinkedHashSet());
        new e("has_clicked_room_intro_setting", r100);
        new e("audience_display_type", 99);
        new e("live_interactive_conflict_flag", 0);
        new e("live_preview_game_play_count", new HashMap());
        new e("live_tc_record_map", new HashSet());
        new e("live_tc_task_time_record_map", new HashMap());
        new e("live_tc_task_state_record_map", new HashMap());
        f158215t2 = new e("live_toolbar_item_bubble_record", new HashMap());
        new e("room_cat_user_id", 0L);
        f158220u2 = new e("anchor_give_danmaku_to_admin", 0);
        f158225v2 = new e("anchor_give_danmaku_to_admin_count", new HashSet());
        f158230w2 = new e("live_interactive_game_status", new ConcurrentHashMap());
        f158235x2 = new e("live_open_game_local_usage_record_list", new HashMap());
        f158240y2 = new e("live_open_game_local_scope_map", new HashMap());
        f158245z2 = new e("live_open_platform_local_boot_config_map", new HashMap());
        new e("live_open_platform_api_constraint_list_map", new HashMap());
        A2 = new e("live_open_platform_js_sdk_file", new SparseArray());
        B2 = new e("live_open_platform_js_sdk_version", BuildConfig.VERSION_NAME);
        new e("live_open_platform_js_sdk_last_update_time", new SparseArray());
        new e("live_interact_item_bubble_record", "");
        new e("live_interact_item_breath_light_record", "");
        new e("live_screenshot_not_show_security_dialog", r100);
        new e("screen_record_live_content_red_dot", r101);
        C2 = new e("live_drawer_entrance_follow_time", 0L);
        new e("vs_cache_cancel_task_has_confirmed", r100);
        new e("vs_player_view_lock_pop_can_show", r101);
        new e("vs_player_orientation_change_pop_can_show", r101);
        D2 = new e("red_dot_has_shown_dilike", r100);
        new e("live_gift_sweep_time_record", new HashMap());
        new e("live_gift_sweep_count_record", new HashMap());
        E2 = new e("realtime_setting_update_debug_enable", r100);
        new e("live_message_debug_enable", r100);
        new e("has_show_private_short_video_slide_guide", r100);
        new e("enable_friend_room_distribute_to_friend", r101);
        new e("friend_room_show_adjust_volume_bubble_count", 0);
        new e("friend_room_has_show_adjust_volume_panel", r100);
        Float r103 = Float.valueOf(0.5f);
        new e("friend_room_video_volume_adjust_value", r103);
        new e("friend_room_link_volume_adjust_value", r103);
        new e("live_preview_startlive_visibility_new_dot_shown", r101);
        F2 = new e("live_interactive_open_platform_user_comment_counter", new HashMap());
        G2 = b6.I;
        new e("live_start_publish_tips_show", r100);
        new e("live_start_star_tips_show", 0);
        H2 = new e("live_pix_activity_h5_opened", r100);
        new e("live_pix_activity_level_zero_time", 3);
        I2 = new e("live_broadcast_is_media", r100);
        new e("live_broadcast_has_used_link", r100);
        new e("live_preview_activity_reward_message_id", "0");
        new e("live_preview_medea_introduction", "");
        new e("live_open_game_start_id_cache", "");
        new e("live_city_match_first_join", r100);
        new e("vs_bubble_show_count", 0);
        new e("vs_bubble_show_last_time", 0L);
        J2 = new e("live_privilege_toast_text", new HashMap());
        new e("live_pad_rotate_toast_time", -1L);
        new e("live_audio_chat_play_mode", 0);
        new e("live_stickers_sync_to_title", r100);
        K2 = new e("live_pay_perform_watch_duration", new HashMap());
        L2 = new e("live_privilege_clarity_frequency", new HashMap());
        M2 = new e("live_room_commerce_tips_shown_list", new HashMap());
        new e("live_friend_room_last_privacy", 0);
        new e("live_danmaku_warm_up_comsume_tip", 0L);
        new e("live_room_toutiao_float_window", r100);
        new e("toutiao_float_window_exit_room_cache_time", 0L);
        new e("toutiao_float_window_exit_record", new LongSparseArray());
        new e("toutiao_float_window_cancel_count", 0);
        new e("toutiao_float_window_disable_time", 0L);
        N2 = b6.f65265z;
        O2 = new e("live_part_scene_float_window_retain_dialog_check_state", r101);
        P2 = b6.A;
        Q2 = new e("live_notification_setting_show", new HashMap());
        R2 = new e("live_preview_enable_feedback_view", new LongSparseArray());
        new e("live_short_touch_animation_show_times", new SparseArray());
        new e("live_short_touch_bubble_show_times", new HashMap());
        new e("live_temp_short_touch_show_times", new HashMap());
        S2 = b6.f65224b;
        new e("live_interact_gift_send_guide_show", r100);
        T2 = new e("live_setting_anchor_paricipate_hour_rank_value", 0);
        U2 = new e("live_feedback_card_show_time", 0L);
        V2 = new e("live_feedback_card_show_time_for_anchor", 0L);
        new e("live_start_sync_xt_check_selected", r100);
        new e("live_start_sync_xt_checked", r100);
        W2 = new e("live_is_feedback_card_can_show_preview", r100);
        X2 = new e("live_feedback_card_battle_first_show", r101);
        new e("live_vr_recenter_guide_show", r101);
        new e("linkmic_interact_entrances", new ArrayList());
        new e("linkmic_interact_entrances_map", new ConcurrentHashMap());
        Y2 = new e("live_digg_haptic_feedback_open", r101);
        new e("live_permission_check_result_record", new ArrayList());
        Z2 = new e("live_media_inter_comment_intro_dot_show", 0);
        f158121a3 = new e("live_media_inter_comment_intro_version", 1);
        f158126b3 = new e("live_media_inter_comment_invite_dialog_enable", r101);
        f158131c3 = new e("live_gift_audience_send_gift_has_auth_switch", r100);
        f158136d3 = new e("live_gift_audience_send_gift_enabled_anchor_switch", 2L);
        f158141e3 = new e("live_gift_audience_receive_gift", r101);
        f158146f3 = new e("live_can_anchor_see_my_info_history", 2L);
        new e("live_gift_last_receiver_cache", new Pair("0", "0"));
        new e("live_gift_receiver_cache", new LruCache(40));
        new e("live_gift_all_mic_state_cache", new LruCache(40));
        f158151g3 = new e("room_channel_toolbar_guide_showed", r100);
        f158156h3 = new e("chat_channel_toolbar_bubble_showed", r100);
        new e("chat_channel_link_rtc_volume_value", a0.f65202a.getValue());
        new e("chat_channel_link_has_show_link_float_audience_tips", r100);
        new e("chat_channel_link_has_show_link_float_guest_tips", r100);
        new e("chat_channel_link_has_show_link_volume_fast_switch_tips", r100);
        new e("live_start_group_purchase_dot_show_count", new HashMap());
        new e("live_start_group_purchase_dot_show_count_new", new HashMap());
        f158161i3 = new e("live_starting_group_purchase_dot_fold_show", r101);
        new e("live_beautify_entry_dot_show", r101);
        new e("live_multi_camera_entry_dot_show", r101);
        new e("live_av_adjust_entry_dot_show", r101);
        f158166j3 = new e("live_local_life_card_bubble_guide_last_show_day", "");
        f158171k3 = new e("live_local_life_card_bubble_guide_show_times", 0);
        f158176l3 = new e("live_starting_group_purchase_dot_unfold_show", r101);
        new e("live_preview_toolbar_dot_show_map", new HashMap());
        new e("live_start_group_purchase_dot_show_count", new HashMap());
        new e("live_start_local_ads_dot_show_count", new HashMap());
        new e("live_start_dou_plus_dot_show_count", new HashMap());
        new e("live_more_panel_announcement_dot_show", r101);
        f158181m3 = new e("live_more_panel_linkmic_announce_dot_show", r101);
        f158186n3 = new e("live_more_panel_linkmic_announce_dot_show_v2", r101);
        new e("live_anchor_has_published_announcement_highlight", r100);
        new e("live_preview_star_graph_dot_show", r100);
        f158191o3 = new e("live_vip_im_api_request_time", 0L);
        new e("live_gesture_gift_recognized_map", new ArrayList());
        new e("live_vs_stable_topic_reddot_clicked", r100);
        new e("live_vs_paid_camera_ui_show_config", new d0(new HashMap(), new HashMap()));
        new e("live_vs_topic_bubble_shown", new ArrayList());
        new e("live_input_customer_service_btn_show_counter", 0);
        f158196p3 = new e("live_in_room_account_seitched", r100);
        new e("live_vs_gif_danmu_default", new HashMap());
        new e("live_vs_gif_danmu_episode", new HashMap());
        new e("live_vs_gif_danmu_default_expired_time", 0L);
        f158201q3 = new e("live_wish_finishe_gesture_dialog_shown", r100);
        new e("live_anchor_has_vip_cache", new LongSparseArray());
        new e("live_switch_scene_button_first_show", r101);
        f158206r3 = new e("lynx_history_send_To_user", "");
        f158211s3 = new e("live_vip_emoji_cache_file_name", "liveVipEmojiTemplateCache.png_0");
        new e("in_byte_cast_screen_mode", r100);
        f158216t3 = new e("interact_game_force_open_vconsole", r100);
        f158221u3 = new e("live_cloud_game_force_vip", r100);
        new e("live_profile_dynamic_sweep_anim_count", 0);
        f158226v3 = new e("match_moment_share_data", "");
        f158231w3 = new e("slide_click_position", 0);
        f158236x3 = new e("gift_preview_in_room", r100);
        f158241y3 = new e("gift_asset_preview_in_room", r100);
        new e("live_game_single_cast_intro_switch", new HashMap());
        f158246z3 = new e("live_game_single_cast_opened", new HashMap());
        A3 = new e("live_open_feature_all_game_tips_enable", r100);
        B3 = new e("live_open_platform_check_default_title", r101);
        C3 = new e("live_open_platform_shelf_management_enter_times", 0);
        D3 = new e("live_open_platform_first_close_shelf_display_dialog", r101);
        E3 = new e("live_open_platform_anchor_shelf_dialog_explain_guide", r101);
        F3 = new e("live_open_platform_last_show_open_explain_card_notice_time", 0L);
        G3 = new e("live_open_platform_show_open_explain_card_notice_count", 0);
        H3 = new e("live_open_platform_last_show_open_explain_card_bubble_time", 0L);
        I3 = new e("live_open_platform_show_live_data_bubble", r101);
        J3 = new e("live_open_platform_show_important_card_bubble", r101);
        K3 = new e("live_open_platform_show_selling_point_bubble", r101);
        new e("live_vs_board_dress_reddot_clicked", new HashSet());
        new e("live_vs_board_last_select_skin", new HashMap());
        new e("live_vs_board_last_select_badge", new HashMap());
        new e("live_open_platform_product_shelf_dialog_show", r101);
        L3 = new e("live_open_platform_anchor_more_mini_app_dot_show_count", 0);
        M3 = new e("live_open_paltform_anchor_migrate_tip_shown", r101);
        N3 = new e("live_interact_play_anchor_cast_little_window_position_v2", new HashMap());
        O3 = new e("live_open_platform_anchor_coexist_guide_show", r101);
        new e("live_interact_gift_red_dot_show", r101);
        new e("live_link_video_dot_show", r100);
        P3 = new e("live_anchor_preview_resolution_bw_probe", new x());
        new e("live_anchor_video_preview_resolution_bw_probe", new x());
        new e("game_rivals_search_history_uid_map", new HashMap());
        new e("game_rivals_search_history_list", new ArrayList());
        new e("format_user_send_fail_message", new HashMap());
        new e("live_anchor_probe_popup", new xs1.b());
        Q3 = new e("live_componentx_loading_config", new ArrayList());
        new e("live_multi_panel_tab_tag_clicked_version", 0L);
        new e("live_open_platform_atmosphere_debug_panel", r100);
        R3 = new e("live_pk_propcard_show_cache", new HashMap());
        new e("live_multi_task_independent_guide_status", e41.b());
        S3 = new e("live_anchor_gift_panel_clicked", r100);
        T3 = new e("live_player_tips_filter", new he1());
        new e("live_last_pid_for_crash_report", 0);
        new e("live_bg_broadcast_mirror_guide", 0);
        new e("live_bg_broadcast_plugin_installed", r100);
        new e("live_bg_broadcast_anchor_last_orientation_is_landscape", r101);
        U3 = new e("live_last_report_hprof_to_rig_time", 0L);
        new e("live_bg_broadcast_is_first_set_intent", r101);
        new e("live_bg_broadcast_is_first_start_live", r101);
        V3 = new e("live_radio_link_gift_comment_interactpanel_reddot", r100);
        W3 = new e("live_anchor_virtual_live_back_camera_toast_time", 0L);
        X3 = new e("live_3d_effect_open_tips_dialog_not_show", r100);
    }
}
