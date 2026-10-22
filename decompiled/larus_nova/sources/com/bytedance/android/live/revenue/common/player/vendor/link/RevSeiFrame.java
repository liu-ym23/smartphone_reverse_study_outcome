package com.bytedance.android.live.revenue.common.player.vendor.link;

import com.bytedance.android.live.revenue.common.player.utils.LiveSeiUtil;
import com.bytedance.android.live.revenue.common.q0;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.model.n0;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o51.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class RevSeiFrame {
    public static final Lazy D = null;
    public static final Map<Integer, RevSeiFrame> E = null;
    public static final List<RevSeiFrame> F = null;
    public static final a G = null;
    public final Lazy A;
    public final Lazy B;
    public final String C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f90918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f90919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f90920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f90921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f90922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f90923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f90924g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f90925h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f90926i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f90927j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f90928k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f90929l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f90930m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f90931n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f90932o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f90933p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f90934q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f90935r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f90936s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f90937t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f90938u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f90939v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f90940w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f90941x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f90942y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f90943z;

    public static final class a {
        public a() {
        }

        public static RevSeiFrame a(a r100, String r101, boolean r102, int r103) {
            boolean r104 = true;
            if ((r103 & 2) == 0) goto L5;
            boolean r105 = true;
        L7:
            if ((r103 & 4) == 0) goto L9;
            r102 = true;
        L9:
            r100.getClass();
            if (r101 != null) goto L12;
        L15:
            if (r104 == true) goto L50;
            if (r102 == false) goto L19;
        L29:
            if (r101 == null) goto L31;
            int r106 = r101.hashCode();
        L32:
            Map<Integer, RevSeiFrame> r107 = RevSeiFrame.E;
            Integer r108 = Integer.valueOf(r106);
            Intrinsics.checkNotNullParameter(r107, "$this$getOrNull");
            if (r107.containsKey(r108) == false) goto L35;
            Object r109 = ((LinkedHashMap) r107).get(r108);
        L36:
            RevSeiFrame r110 = (RevSeiFrame) r109;
            if (r110 == null) goto L39;
            return r110;
        L39:
            if (r101 != null) goto L41;
            r101 = "";
        L41:
            RevSeiFrame r111 = new RevSeiFrame(r101);
            if (r105 == false) goto L52;
            RevSeiFrame.G.getClass();
            List<RevSeiFrame> r112 = RevSeiFrame.F;
            ArrayList r113 = (ArrayList) r112;
            if (r113.size() <= 5) goto L46;
            r107.remove(Integer.valueOf(((Number) ((RevSeiFrame) ListProtector.remove(r112, 0)).f90918a.getValue()).intValue()));
        L46:
            r107.put(Integer.valueOf(((Number) r111.f90918a.getValue()).intValue()), r111);
            r113.add(r111);
            return r111;
        L52:
            return r111;
        L35:
            r109 = null;
            goto L36
        L31:
            r106 = 0;
            goto L32
        L19:
            if (Intrinsics.areEqual(new RevSeiFrame(r101).o(), Boolean.TRUE) == false) goto L29;
            b03.a r114 = b03.a.f16857a;
            if (PadConfigUtils.a() == true) goto L29;
            JSONObject r115 = new JSONObject(r101);     // Catch: Exception -> L24
            JSONObject r116 = new JSONObject(JSONObjectProtectorUtils.getString(r115, "app_data"));     // Catch: Exception -> L24
            r116.put("grids", r116.get("horizontal_grids"));     // Catch: Exception -> L24
            r115.put("app_data", r116.toString());     // Catch: Exception -> L24
            r101 = r115.toString();     // Catch: Exception -> L24
        L24:
            e = move-exception;
            int r117 = w51.a.f558315a;
            String r118 = q0.a(e);
            if (r118 != null) goto L28;
            r118 = "empty error msg";
        L28:
            w51.a.C8068a.b("Change Grids Info Error", r118);
            goto L29
        L50:
            return (RevSeiFrame) RevSeiFrame.D.getValue();
        L12:
            if (r101.length() == 0) goto L15;
            r104 = false;
            goto L15
        L5:
            r105 = false;
            goto L7
        }
    }

    public final p0 b() {
        return (p0) this.f90927j.getValue();
    }

    public final int c() {
        return ((Number) this.B.getValue()).intValue();
    }

    public final JSONObject d() {
        return (JSONObject) this.f90925h.getValue();
    }

    public final Long e() {
        return (Long) this.f90926i.getValue();
    }

    public final float f() {
        return ((Number) this.f90935r.getValue()).floatValue();
    }

    public final n0 g() {
        return (n0) this.f90931n.getValue();
    }

    public final boolean h() {
        return ((Boolean) this.f90943z.getValue()).booleanValue();
    }

    public final int i() {
        return ((Number) this.f90942y.getValue()).intValue();
    }

    public final Integer m() {
        return (Integer) this.f90929l.getValue();
    }

    public final Integer n() {
        return (Integer) this.f90921d.getValue();
    }

    public final Boolean o() {
        return (Boolean) this.f90920c.getValue();
    }

    public final boolean p() {
        return ((Boolean) this.f90928k.getValue()).booleanValue();
    }

    static {
        G = new a();
        D = LazyKt.lazy(RevSeiFrame$Companion$emptyFrame$2.INSTANCE);
        E = new LinkedHashMap();
        F = new ArrayList();
    }

    public final JSONObject a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L12
        Lazy r101 = LiveSeiUtil.f90915a;     // Catch: Throwable -> L12
        JSONObject r102 = LiveSeiUtil.a(this.C);     // Catch: Throwable -> L12
        if (r102.has("info") == true) goto L6;
    L10:
        Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r103) == false) goto L18;
        r103 = null;
    L18:
        return (JSONObject) r103;
    L6:
        if (r102.has("source") == false) goto L10;
        if (Intrinsics.areEqual(r102.optString("source"), "zego") == false) goto L10;
        r102 = JSONObjectProtectorUtils.getJSONObject(r102, "info");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public final n0 r() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L21
        if (StringsKt.contains$default(this.C, "linkmic_crop", false, 2, null) == false) goto L20;
        JSONObject r102 = d();     // Catch: Throwable -> L21
        if (r102 == null) goto L20;
        if (r102.has("linkmic_crop") != true) goto L20;
        int r103 = n0.f153942a;     // Catch: Throwable -> L21
        JSONObject r104 = d();     // Catch: Throwable -> L21
        if (r104 == null) goto L13;
        JSONObject r105 = JSONObjectProtectorUtils.getJSONObject(r104, "linkmic_crop");     // Catch: Throwable -> L21
    L14:
        n0 r106 = n0.a.a(r105);     // Catch: Throwable -> L21
        if (r106 == null) goto L20;
        if (r106.g() == false) goto L20;
        return r106;
    L13:
        r105 = null;
    L20:
        return null;
    L21:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Object r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r108) == true) goto L27;
        r100 = r108;
    L27:
        return (n0) r100;
    }

    public final n0 s() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L21
        if (StringsKt.contains$default(this.C, "live_crop", false, 2, null) == false) goto L20;
        JSONObject r102 = (JSONObject) this.f90919b.getValue();     // Catch: Throwable -> L21
        if (r102 == null) goto L20;
        if (r102.has("live_crop") != true) goto L20;
        int r103 = n0.f153942a;     // Catch: Throwable -> L21
        JSONObject r104 = (JSONObject) this.f90919b.getValue();     // Catch: Throwable -> L21
        if (r104 == null) goto L13;
        JSONObject r105 = JSONObjectProtectorUtils.getJSONObject(r104, "live_crop");     // Catch: Throwable -> L21
    L14:
        n0 r106 = n0.a.a(r105);     // Catch: Throwable -> L21
        if (r106 == null) goto L20;
        if (r106.g() == false) goto L20;
        return r106;
    L13:
        r105 = null;
    L20:
        return null;
    L21:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Object r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r108) == true) goto L27;
        r100 = r108;
    L27:
        return (n0) r100;
    }

    public final f k() {
        p0 r100 = b();
        boolean r101 = false;
        if (r100 == null) goto L7;
        List<RevSeiRegion> r102 = r100.e();
        if (r102 == null) goto L7;
        int r103 = r102.size();
    L8:
        p0 r104 = b();
        if (r104 == null) goto L11;
        int r105 = r104.getGameType();
    L13:
        if (((Number) this.f90937t.getValue()).intValue() == 0) goto L15;
        r101 = true;
    L15:
        if (r105 == 0) goto L19;
        if (r101 == false) goto L24;
        return f.m.f522071e;
    L24:
        return f.l.f522070e;
    L19:
        if (r103 <= 1) goto L22;
        return f.n.f522072e;
    L22:
        return f.k.f522069e;
    L11:
        r105 = 0;
    L7:
        r103 = 0;
        goto L8
    }

    public RevSeiFrame(String r100) {
        this.C = r100;
        this.f90918a = LazyKt.lazy(new RevSeiFrame$rawHashCode$2(this));
        this.f90919b = LazyKt.lazy(new RevSeiFrame$seiJsonObject$2(this));
        this.f90920c = LazyKt.lazy(new RevSeiFrame$isGameLink$2(this));
        this.f90921d = LazyKt.lazy(new RevSeiFrame$version$2(this));
        this.f90922e = LazyKt.lazy(new RevSeiFrame$channelID$2(this));
        this.f90923f = LazyKt.lazy(new RevSeiFrame$appDataStr$2(this));
        this.f90924g = LazyKt.lazy(new RevSeiFrame$trimmedAppDataString$2(this));
        this.f90925h = LazyKt.lazy(new RevSeiFrame$appDataJSONObject$2(this));
        this.f90926i = LazyKt.lazy(new RevSeiFrame$appDataTs$2(this));
        this.f90927j = LazyKt.lazy(new RevSeiFrame$appData$2(this));
        this.f90928k = LazyKt.lazy(new RevSeiFrame$isPartnerLayout$2(this));
        this.f90929l = LazyKt.lazy(new RevSeiFrame$uiLayoutServerIndex$2(this));
        this.f90930m = LazyKt.lazy(new RevSeiFrame$isHorizontal$2(this));
        this.f90931n = LazyKt.lazy(new RevSeiFrame$cropSeiData$2(this));
        this.f90932o = LazyKt.lazy(new RevSeiFrame$isLiveCrop$2(this));
        this.f90933p = LazyKt.lazy(new RevSeiFrame$isLinkCrop$2(this));
        this.f90934q = LazyKt.lazy(new RevSeiFrame$canvasSize$2(this));
        this.f90935r = LazyKt.lazy(new RevSeiFrame$canvasWHRatio$2(this));
        this.f90936s = LazyKt.lazy(new RevSeiFrame$canvasWHRadioForScreenRecord$2(this));
        this.f90937t = LazyKt.lazy(new RevSeiFrame$gameFull$2(this));
        this.f90938u = LazyKt.lazy(new RevSeiFrame$gameType$2(this));
        this.f90939v = LazyKt.lazy(new RevSeiFrame$gameMixStreamType$2(this));
        this.f90940w = LazyKt.lazy(new RevSeiFrame$seiIndex$2(this));
        this.f90941x = LazyKt.lazy(new RevSeiFrame$uiLayoutKMPIndex$2(this));
        this.f90942y = LazyKt.lazy(new RevSeiFrame$layoutTypeIndex$2(this));
        this.f90943z = LazyKt.lazy(new RevSeiFrame$hasMixGrids$2(this));
        this.A = LazyKt.lazy(new RevSeiFrame$anchorGridsCount$2(this));
        this.B = LazyKt.lazy(new RevSeiFrame$appDataIndex$2(this));
    }

    public final f l(int r100) {
        Long r101 = q(this.C, r100);
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
    L6:
        int r103 = (int) r102;
        f.j r104 = f.j.f522068e;
        if (r103 == r104.f522058c) goto L41;
        f.b r105 = f.b.f522060e;
        if (r103 == r105.f522058c) goto L42;
        f.c r106 = f.c.f522061e;
        if (r103 == r106.f522058c) goto L43;
        f.d r107 = f.d.f522062e;
        if (r103 == r107.f522058c) goto L44;
        f.e r108 = f.e.f522063e;
        if (r103 == r108.f522058c) goto L45;
        f.k r109 = f.k.f522069e;
        if (r103 == r109.f522058c) goto L46;
        f.n r110 = f.n.f522072e;
        if (r103 == r110.f522058c) goto L47;
        f.l r111 = f.l.f522070e;
        if (r103 == r111.f522058c) goto L48;
        f.m r112 = f.m.f522071e;
        if (r103 == r112.f522058c) goto L49;
        f.i r113 = f.i.f522067e;
        if (r103 == r113.f522058c) goto L50;
        f.h r114 = f.h.f522066e;
        if (r103 != r114.f522058c) goto L40;
        return r114;
    L40:
        return new f.a(r103);
    L50:
        return r113;
    L49:
        return r112;
    L48:
        return r111;
    L47:
        return r110;
    L46:
        return r109;
    L45:
        return r108;
    L44:
        return r107;
    L43:
        return r106;
    L42:
        return r105;
    L41:
        return r104;
    L5:
        r102 = 0;
        goto L6
    }

    public static Long q(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "str");
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L17
        int r104 = r100.length();     // Catch: Throwable -> L17
        if (r101 >= 0) goto L6;
        return null;
    L6:
        if (r101 >= r104) goto L10;
        if (Character.isDigit(r100.charAt(r101)) == true) goto L10;
        r101 = r101 + 1;     // Catch: Throwable -> L17
    L10:
        long r105 = 0;
    L11:
        if (r101 >= r104) goto L15;
        if (Character.isDigit(r100.charAt(r101)) == false) goto L15;
        r105 = (r105 * ((long) 10)) + ((long) (r100.charAt(r101) - '0'));     // Catch: Throwable -> L17
        r101 = r101 + 1;     // Catch: Throwable -> L17
    L15:
        return Long.valueOf(r105);
    L17:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Object r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == true) goto L23;
        r102 = r107;
    L23:
        return (Long) r102;
    }

    public final f t(boolean r100, boolean r101) {
        if (c() >= 0) goto L7;
        return f.j.f522068e;
    L7:
        if (((Number) this.f90941x.getValue()).intValue() < 0) goto L11;
        return l(((Number) this.f90941x.getValue()).intValue());
    L11:
        if (i() >= 0) goto L31;
        Integer r102 = n();     // Catch: Throwable -> L51
        if (r102 != null) goto L16;
    L19:
        Integer r103 = n();     // Catch: Throwable -> L51
        if (r103 != null) goto L23;
    L30:
        return f.j.f522068e;
    L23:
        if (r103.intValue() != 19) goto L30;
        if (f.b.f522060e.f522057b != 0) goto L28;
        return f.h.f522066e;
    L28:
        return f.i.f522067e;
    L16:
        if (r102.intValue() != 2) goto L19;
        return k();
    L31:
        Long r104 = q(this.C, i());     // Catch: Throwable -> L51
        if (r104 == null) goto L34;
        int r105 = (int) r104.longValue();     // Catch: Throwable -> L51
    L35:
        Integer r106 = n();     // Catch: Throwable -> L51
        if (r106 != null) goto L39;
    L41:
        if (r106 != null) goto L44;
    L50:
        return j(r105, r100, r101);
    L44:
        if (r106.intValue() != 19) goto L50;
        if (r105 != f.b.f522060e.f522057b) goto L57;
        return f.h.f522066e;
    L57:
        return f.i.f522067e;
    L39:
        if (r106.intValue() != 2) goto L41;
        return k();
    L34:
        r105 = 0;
        goto L35
    L52:
        return f.j.f522068e;
    }

    public final f j(int r100, boolean r101, boolean r102) {
        f.j r103 = f.j.f522068e;
        if (r100 != r103.f522057b) goto L10;
        if (r102 == true) goto L7;
        return f.C7016f.f522064e;
    L7:
        if (Intrinsics.areEqual(o(), Boolean.TRUE) == false) goto L25;
        if (r102 == true) goto L27;
        return r103;
    L27:
        return f.g.f522065e;
    L25:
        return r103;
    L10:
        f r104 = f.b.f522060e;
        if (r100 == r104.f522057b) goto L28;
        r104 = f.c.f522061e;
        if (r100 != r104.f522057b) goto L29;
        Integer r105 = (Integer) this.f90930m.getValue();
        if (r105 != null) goto L19;
    L21:
        if (r101 == false) goto L28;
        return f.e.f522063e;
    L19:
        if (r105.intValue() != 1) goto L21;
        return f.d.f522062e;
    L29:
        return r103;
    L28:
        return r104;
    }
}
