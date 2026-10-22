package com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine;

import com.bytedance.android.livesdk.link.model.IBattleBarConfig;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.ITeamTask;
import com.bytedance.android.livesdk.link.model.a1;
import com.bytedance.android.livesdk.link.model.a5;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.b1;
import com.bytedance.android.livesdk.link.model.c1;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.g7;
import com.bytedance.android.livesdk.link.model.i3;
import com.bytedance.android.livesdk.link.model.l9;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.u1;
import com.bytedance.android.livesdk.link.model.z2;
import com.bytedance.android.livesdk.link.model.z4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f92900p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBaseBattleSetting f92901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, IBattleUserInfo> f92902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a1> f92903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Long, g7> f92904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f92905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IBattleBarConfig f92906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.b f92907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, z2> f92908h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n3 f92909i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l9 f92910j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ITeamTask f92911k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f92912l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, String> f92913m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final z4 f92914n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final p0 f92915o;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a$a, reason: collision with other inner class name */
    public static final class C1448a {
        public static a a(c3 r310) {
            if (r310 == null) goto L29;
            c1 r100 = r310.getBattleSetting();
            List<a1> r101 = r310.getBattleScorePairList();
            Map<Long, g7> r102 = r310.getMultiPkTeam();
            c1 r103 = r310.getBattleSetting();
            if (r103 == null) goto L6;
            IBattleBarConfig r104 = r103.getBarConfig();
        L7:
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r105 = new com.bytedance.android.live.revlink.impl.mergepk.pkbase.b(r310.getSkinType(), r310.getSkinConfig());
            ITeamTask r110 = r310.getTeamTask();
            String r111 = r310.getTeamTaskJson();
            n3 r112 = r310.getBreakthroughInfo();
            Map<String, IBattleUserInfo> r106 = r310.getBattleUserInfoMap();
            l9 r113 = r310.getSurvivalInfo();
            c1 r107 = r310.getBattleSetting();
            if (r107 == null) goto L10;
            long r108 = r107.getFinished();
        L11:
            Map<String, String> r114 = h41.h.a(r310.getEventTrackingInfo());
            if (r101 == null) goto L14;
            List r109 = CollectionsKt.toList(r101);
        L15:
            if (r102 == null) goto L21;
            LinkedHashMap r115 = new LinkedHashMap(MapsKt.mapCapacity(r102.size()));
            Iterator<T> r116 = r102.entrySet().iterator();
        L18:
            if (r116.hasNext() == false) goto L20;
            Map.Entry r117 = (Map.Entry) r116.next();
            r115.put(Long.valueOf(((Number) r117.getKey()).longValue()), r117.getValue());
            goto L18
        L20:
            Map r118 = MapsKt.toMap(r115);
        L23:
            if (r106 == null) goto L25;
            Map r119 = MapsKt.toMap(r106);
        L27:
            return new a(r100, r119, r109, r118, r108, r104, r105, null, r112, r113, r110, r111, r114, null, null, 24704);
        L25:
            r119 = null;
            goto L27
        L21:
            r118 = null;
            goto L23
        L14:
            r109 = null;
            goto L15
        L10:
            r108 = 0;
            goto L11
        L6:
            r104 = null;
            goto L7
        L29:
            return new a(null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 32767);
        }

        public static a b(a5 r210, IBattleBarConfig r211, com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r212) {
            Intrinsics.checkNotNullParameter(r210, "battleFinishMessage");
            u1 r100 = r210.getBattleSetting();
            List<a1> r101 = r210.getBattleScorePairList();
            Map<String, IBattleUserInfo> r102 = r210.getBattleUserInfoMap();
            Map<String, z2> r103 = r210.getGradeChanges();
            n3 r110 = r210.getBreakthroughInfo();
            l9 r111 = r210.getSurvivalInfo();
            Map<String, String> r112 = h41.h.a(r210.getEventTrackingInfo());
            z4 r113 = r210.getBattleFinishExtra();
            List r104 = CollectionsKt.toList(r101);
            Map r105 = null;
            if (r102 == null) goto L5;
            Map r106 = MapsKt.toMap(r102);
        L7:
            if (r103 == null) goto L10;
            r105 = MapsKt.toMap(r103);
        L10:
            return new a(r100, r106, r104, null, 0, r211, r212, r105, r110, r111, null, null, r112, r113, null, 19480);
        L5:
            r106 = null;
            goto L7
        }
    }

    static {
    }

    public a() {
        this(null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 32767);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L36;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f92901a, r101.f92901a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f92902b, r101.f92902b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f92903c, r101.f92903c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f92904d, r101.f92904d) == true) goto L14;
        return false;
    L14:
        if (this.f92905e == r101.f92905e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f92906f, r101.f92906f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f92907g, r101.f92907g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f92908h, r101.f92908h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f92909i, r101.f92909i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f92910j, r101.f92910j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f92911k, r101.f92911k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f92912l, r101.f92912l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f92913m, r101.f92913m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f92914n, r101.f92914n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f92915o, r101.f92915o) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    public final int hashCode() {
        IBaseBattleSetting r100 = this.f92901a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, IBattleUserInfo> r104 = this.f92902b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<a1> r107 = this.f92903c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<Long, g7> r110 = this.f92904d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.f92905e;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        IBattleBarConfig r115 = this.f92906f;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r118 = this.f92907g;
        if (r118 == null) goto L25;
        int r119 = r118.hashCode();
    L26:
        int r120 = (r117 + r119) * 31;
        Map<String, z2> r121 = this.f92908h;
        if (r121 == null) goto L29;
        int r122 = r121.hashCode();
    L30:
        int r123 = (r120 + r122) * 31;
        n3 r124 = this.f92909i;
        if (r124 == null) goto L33;
        int r125 = r124.hashCode();
    L34:
        int r126 = (r123 + r125) * 31;
        l9 r127 = this.f92910j;
        if (r127 == null) goto L37;
        int r128 = r127.hashCode();
    L38:
        int r129 = (r126 + r128) * 31;
        ITeamTask r130 = this.f92911k;
        if (r130 == null) goto L41;
        int r131 = r130.hashCode();
    L42:
        int r132 = (r129 + r131) * 31;
        String r133 = this.f92912l;
        if (r133 == null) goto L45;
        int r134 = r133.hashCode();
    L46:
        int r135 = (r132 + r134) * 31;
        Map<String, String> r136 = this.f92913m;
        if (r136 == null) goto L49;
        int r137 = r136.hashCode();
    L50:
        int r138 = (r135 + r137) * 31;
        z4 r139 = this.f92914n;
        if (r139 == null) goto L53;
        int r140 = r139.hashCode();
    L54:
        int r141 = (r138 + r140) * 31;
        p0 r142 = this.f92915o;
        if (r142 == null) goto L58;
        r101 = r142.hashCode();
    L58:
        return r141 + r101;
    L53:
        r140 = 0;
        goto L54
    L49:
        r137 = 0;
        goto L50
    L45:
        r134 = 0;
        goto L46
    L41:
        r131 = 0;
        goto L42
    L37:
        r128 = 0;
        goto L38
    L33:
        r125 = 0;
        goto L34
    L29:
        r122 = 0;
        goto L30
    L25:
        r119 = 0;
        goto L26
    L21:
        r116 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final long a() {
        IBaseBattleSetting r100 = this.f92901a;
        if (r100 == null) goto L10;
        r100.setPunishDuration(af2.d.b(r100));
        if (r100.getPunishStartTimeMs() == 0) goto L7;
        long r101 = (r100.getPunishDuration() * ((long) 1000)) + r100.getPunishStartTimeMs();
        long r102 = com.bytedance.live.kmp.util.e.a();
    L9:
        return r101 - r102;
    L7:
        r101 = ((r100.getDuration() + r100.getPunishDuration()) * ((long) 1000)) + r100.getStartTimeMs();
        r102 = com.bytedance.live.kmp.util.e.a();
        goto L9
    L10:
        return 0;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("PKStateInfo {battleSetting : ");
        IBaseBattleSetting r101 = this.f92901a;
        ArrayList r102 = null;
        if (r101 == null) goto L5;
        String r103 = af2.d.e(r101);
    L6:
        r100.append(r103);
        r100.append(", battleUserInfoMap : ");
        Map<String, IBattleUserInfo> r104 = this.f92902b;
        if (r104 == null) goto L12;
        LinkedHashMap r105 = new LinkedHashMap(MapsKt.mapCapacity(r104.size()));
        Iterator<T> r106 = r104.entrySet().iterator();
    L10:
        if (r106.hasNext() == false) goto L13;
        Map.Entry r107 = (Map.Entry) r106.next();
        r105.put(r107.getKey(), i3.a((IBattleUserInfo) r107.getValue()));
    L13:
        r100.append(r105);
        r100.append(", battleScorePairList : ");
        List<a1> r108 = this.f92903c;
        if (r108 == null) goto L19;
        List<a1> r109 = r108;
        r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator<T> r110 = r109.iterator();
    L17:
        if (r110.hasNext() == false) goto L19;
        r102.add(b1.a((a1) r110.next()));
    L19:
        r100.append(r102);
        r100.append(", multiPKTeam : ");
        r100.append(this.f92904d);
        r100.append(", finished : ");
        r100.append(this.f92905e);
        return r100.toString();
    L12:
        r105 = null;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public a(IBaseBattleSetting r110, Map r111, List r112, Map r210, long r211, IBattleBarConfig r212, com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r213, Map r214, n3 r215, l9 r216, ITeamTask r217, String r218, Map r310, z4 r311, p0 r312, int r313) {
        if ((r313 & 1) == 0) goto L5;
        IBaseBattleSetting r100 = null;
    L7:
        if ((r313 & 2) == 0) goto L9;
        Map r101 = null;
    L11:
        if ((r313 & 4) == 0) goto L13;
        List r102 = null;
    L15:
        if ((r313 & 8) == 0) goto L17;
        Map r103 = null;
    L19:
        if ((r313 & 16) == 0) goto L21;
        long r104 = 0;
    L23:
        if ((r313 & 32) == 0) goto L25;
        IBattleBarConfig r105 = null;
    L27:
        if ((r313 & 64) == 0) goto L29;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r113 = null;
    L31:
        if ((r313 & 128) == 0) goto L33;
        Map r114 = null;
    L35:
        if ((r313 & 256) == 0) goto L37;
        n3 r115 = null;
    L39:
        if ((r313 & 512) == 0) goto L41;
        l9 r116 = null;
    L43:
        if ((r313 & 1024) == 0) goto L45;
        ITeamTask r117 = null;
    L47:
        if ((r313 & 2048) == 0) goto L49;
        String r118 = null;
    L51:
        if ((r313 & 4096) == 0) goto L53;
        Map r106 = null;
    L54:
        Map r119 = r106;
        if ((r313 & 8192) == 0) goto L57;
        z4 r107 = null;
    L59:
        if ((r313 & 16384) == 0) goto L61;
        p0 r108 = null;
    L62:
        this.f92901a = r100;
        this.f92902b = r101;
        this.f92903c = r102;
        this.f92904d = r103;
        this.f92905e = r104;
        this.f92906f = r105;
        this.f92907g = r113;
        this.f92908h = r114;
        this.f92909i = r115;
        this.f92910j = r116;
        this.f92911k = r117;
        this.f92912l = r118;
        this.f92913m = r119;
        this.f92914n = r107;
        this.f92915o = r108;
        return;
    L61:
        r108 = r312;
        goto L62
    L57:
        r107 = r311;
        goto L59
    L53:
        r106 = r310;
        goto L54
    L49:
        r118 = r218;
        goto L51
    L45:
        r117 = r217;
        goto L47
    L41:
        r116 = r216;
        goto L43
    L37:
        r115 = r215;
        goto L39
    L33:
        r114 = r214;
        goto L35
    L29:
        r113 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
