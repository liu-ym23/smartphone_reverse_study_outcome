package com.bytedance.android.live.liveinteract.api.data;

import cj0.k;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.sharedpref.d;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.j;
import fj0.c;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C1153a f71432h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f71433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f71434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f71435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f71436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f71437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f71438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f71439g;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.api.data.a$a, reason: collision with other inner class name */
    public static final class C1153a {
        public C1153a() {
        }

        @JvmStatic
        public static k b() {
            cj0.b r100 = ((IInteractService) jc1.k.n(IInteractService.class)).paidLinkMicService();
            if (r100 == null) goto L7;
            k r101 = r100.currentPaidLinkMicState();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return new k(0);
        }

        @JvmStatic
        public static a a() {
            boolean r100 = false;
            if (c.a() == false) goto L5;
            k r101 = b();
            return new a((int) r101.f23920b, (int) r101.f23921c, r101.f23919a, r100);
        L5:
            int r102 = com.bytedance.android.livesdk.sharedpref.c.f158308u.getValue().intValue();
            int r103 = com.bytedance.android.livesdk.sharedpref.c.f158311v.getValue().intValue();
            j<LivePlayModeLogContext> r104 = m.d().J();
            if (r104 == null) goto L15;
            LivePlayModeLogContext r105 = r104.getValue();
            if (r105 == null) goto L15;
            com.bytedance.live.datacontext.m<Set<Integer>> r106 = r105.getPlayModes();
            if (r106 == null) goto L15;
            Set<Integer> r107 = r106.getValue();
            if (r107 == null) goto L15;
            boolean r108 = r107.contains(11);
        L17:
            return new a(r102, r103, r108, r100);
        L15:
            r108 = false;
            goto L17
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public static int c() {
            if (c.a() == false) goto L6;
            return (int) b().f23921c;
        L6:
            if (e() == false) goto L9;
            return ((Number) d.L.getValue(null, d.f158327a[36])).intValue();
        L9:
            return ((Number) d.G.getValue(null, d.f158327a[31])).intValue();
        }

        @JvmStatic
        public static int d() {
            if (c.a() == false) goto L6;
            return (int) b().f23920b;
        L6:
            if (e() == false) goto L8;
            Integer r100 = com.bytedance.android.livesdk.sharedpref.c.B.getValue();
        L10:
            return r100.intValue();
        L8:
            r100 = com.bytedance.android.livesdk.sharedpref.c.f158297q0.getValue();
            goto L10
        }

        public static boolean e() {
            com.bytedance.live.datacontext.m<IRoom> r100 = m.i().getRoom();
            if (r100 == null) goto L11;
            IRoom r101 = r100.getValue();
            if (r101 == null) goto L11;
            Map<String, String> r102 = r101.getAnchorABMap();
            if (r102 == null) goto L11;
            String r103 = r102.get("opt_paid_link_feature_switch");
            if (r103 == null) goto L11;
            Integer r104 = StringsKt.toIntOrNull(r103);
        L13:
            if (r104 == null) goto L18;
            if (r104.intValue() != 1) goto L18;
            return true;
        L18:
            if (c.a() == true) goto L23;
            return false;
        L23:
            return true;
        L11:
            r104 = null;
            goto L13
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public static int f() {
            if (c.a() == false) goto L6;
            return (int) b().f23921c;
        L6:
            if (e() == false) goto L9;
            return ((Number) d.O.getValue(null, d.f158327a[39])).intValue();
        L9:
            return ((Number) d.I.getValue(null, d.f158327a[33])).intValue();
        }

        @JvmStatic
        public static int g() {
            if (c.a() == false) goto L6;
            return (int) b().f23920b;
        L6:
            if (e() == false) goto L8;
            Integer r100 = com.bytedance.android.livesdk.sharedpref.c.f158308u.getValue();
        L10:
            return r100.intValue();
        L8:
            r100 = com.bytedance.android.livesdk.sharedpref.c.f158314w.getValue();
            goto L10
        }

        @JvmStatic
        public static a h() {
            if (c.a() == false) goto L12;
            k r100 = b();
            int r101 = (int) r100.f23920b;
            int r102 = (int) r100.f23921c;
            boolean r103 = r100.f23919a;
            Integer r104 = com.bytedance.android.livesdk.sharedpref.c.f158299r.getValue();
            if (r104 != null) goto L8;
        L9:
            boolean r105 = true;
        L11:
            a r110 = new a(r101, r102, r103, false, r105, com.bytedance.android.livesdk.sharedpref.c.f158302s.getValue(), com.bytedance.android.livesdk.sharedpref.c.f158305t.getValue());
        L32:
            return r110;
        L8:
            if (r104.intValue() != 2) goto L9;
            r105 = false;
            goto L11
        L12:
            int r111 = d();
            int r112 = c();
            if (c.a() == false) goto L19;
            cj0.b r106 = ((IInteractService) jc1.k.n(IInteractService.class)).paidLinkMicService();
            if (r106 != null) goto L17;
        L23:
            boolean r113 = false;
        L24:
            Integer r107 = com.bytedance.android.livesdk.sharedpref.c.f158299r.getValue();
            if (r107 != null) goto L28;
        L29:
            boolean r114 = true;
        L31:
            r110 = new a(r111, r112, r113, false, r114, com.bytedance.android.livesdk.sharedpref.c.f158302s.getValue(), com.bytedance.android.livesdk.sharedpref.c.f158305t.getValue());
            goto L32
        L28:
            if (r107.intValue() != 2) goto L29;
            r114 = false;
            goto L31
        L17:
            if (r106.isPaidLinkOn() != true) goto L23;
        L22:
            r113 = true;
            goto L24
        L19:
            int r108 = d();
            if (r108 == (-1)) goto L23;
            if (r108 == 0) goto L23;
            goto L22
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public static boolean i() {
            if (c.a() == false) goto L5;
            return true;
        L5:
            if (e() == false) goto L8;
            boolean r100 = ((Boolean) d.N.getValue(null, d.f158327a[38])).booleanValue();
        L11:
            if (r100 == true) goto L16;
            return false;
        L16:
            return true;
        L8:
            if (((Number) d.H.getValue(null, d.f158327a[32])).intValue() == (-1)) goto L10;
            r100 = true;
            goto L11
        L10:
            r100 = false;
            goto L11
        }

        @JvmStatic
        public static boolean j() {
            if (c.a() == false) goto L10;
            cj0.b r100 = ((IInteractService) jc1.k.n(IInteractService.class)).paidLinkMicService();
            if (r100 != null) goto L7;
            return false;
        L7:
            if (r100.isPaidLinkOn() != true) goto L16;
            return true;
        L16:
            return false;
        L10:
            int r101 = g();
            if (r101 == (-1)) goto L17;
            if (r101 == 0) goto L18;
            return true;
        L18:
            return false;
        L17:
            return false;
        }

        @JvmStatic
        public static a k() {
            boolean r100 = true;
            if (c.a() == false) goto L6;
            k r101 = b();
            return new a((int) r101.f23920b, (int) r101.f23921c, r101.f23919a, r100);
        L6:
            return new a(g(), f(), j(), r100);
        }
    }

    @JvmStatic
    public static final a a() {
        f71432h.getClass();
        return C1153a.h();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (this.f71433a == r101.f71433a) goto L8;
        return false;
    L8:
        if (this.f71434b == r101.f71434b) goto L10;
        return false;
    L10:
        if (this.f71435c == r101.f71435c) goto L12;
        return false;
    L12:
        if (this.f71436d == r101.f71436d) goto L14;
        return false;
    L14:
        if (this.f71437e == r101.f71437e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f71438f, r101.f71438f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f71439g, r101.f71439g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public final int hashCode() {
        int r100 = ((this.f71433a * 31) + this.f71434b) * 31;
        boolean r101 = this.f71435c;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.f71436d;
        ?? r106 = r105;
        if (r105 == false) goto L8;
        r106 = 1;
    L8:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.f71437e;
        if (r108 == true) goto L12;
        r102 = r108;
    L12:
        int r109 = (r107 + r102) * 31;
        String r110 = this.f71438f;
        int r111 = 0;
        if (r110 == null) goto L15;
        int r112 = r110.hashCode();
    L16:
        int r113 = (r109 + r112) * 31;
        String r114 = this.f71439g;
        if (r114 == null) goto L20;
        r111 = r114.hashCode();
    L20:
        return r113 + r111;
    L15:
        r112 = 0;
        goto L16
    }

    public final String toString() {
        return "PaidLinkConfig(paidCount=" + this.f71433a + ", limitTime=" + this.f71434b + ", isOn=" + this.f71435c + ", isVideoTalk=" + this.f71436d + ", isReasonNecessary=" + this.f71437e + ", manualReason=" + this.f71438f + ", defaultReason=" + this.f71439g + ")";
    }

    static {
        f71432h = new C1153a();
    }

    public /* synthetic */ a(int r100, int r110, boolean r111, boolean r112) {
        this(r100, r110, r111, r112, true, "", "");
    }

    public a(int r100, int r101, boolean r102, boolean r103, boolean r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r105, "manualReason");
        Intrinsics.checkNotNullParameter(r106, "defaultReason");
        this.f71433a = r100;
        this.f71434b = r101;
        this.f71435c = r102;
        this.f71436d = r103;
        this.f71437e = r104;
        this.f71438f = r105;
        this.f71439g = r106;
    }
}
