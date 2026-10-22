package com.bytedance.android.live.revlink.impl.mergepk.pkdouble;

import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.v3;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<IBattleRivalTag> f92993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f92994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f92995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f92996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f92997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f92998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IBattleConfigSetting f92999g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f93000h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f93001i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f93002j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final v3 f93003k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f93004l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HashMap<String, String> f93005m;

    public f() {
        this(null, null, 0, null, 0, null, null, 0, 0, null, null, null, 8191);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L32;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f92993a, r101.f92993a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f92994b, r101.f92994b) == true) goto L10;
        return false;
    L10:
        if (this.f92995c == r101.f92995c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f92996d, r101.f92996d) == true) goto L14;
        return false;
    L14:
        if (this.f92997e == r101.f92997e) goto L16;
        return false;
    L16:
        if (this.f92998f == r101.f92998f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f92999g, r101.f92999g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f93000h, r101.f93000h) == true) goto L22;
        return false;
    L22:
        if (this.f93001i == r101.f93001i) goto L24;
        return false;
    L24:
        if (this.f93002j == r101.f93002j) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f93003k, r101.f93003k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f93004l, r101.f93004l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f93005m, r101.f93005m) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public final int hashCode() {
        List<IBattleRivalTag> r100 = this.f92993a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f92994b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f92995c) * 31;
        String r107 = this.f92996d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((((r106 + r108) * 31) + this.f92997e) * 31) + this.f92998f) * 31;
        IBattleConfigSetting r110 = this.f92999g;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f93000h;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (((r112 + r114) * 31) + this.f93001i) * 31;
        long r116 = this.f93002j;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        v3 r118 = this.f93003k;
        if (r118 == null) goto L25;
        int r119 = r118.hashCode();
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f93004l;
        if (r121 == null) goto L29;
        int r122 = r121.hashCode();
    L30:
        int r123 = (r120 + r122) * 31;
        HashMap<String, String> r124 = this.f93005m;
        if (r124 == null) goto L34;
        r101 = r124.hashCode();
    L34:
        return r123 + r101;
    L29:
        r122 = 0;
        goto L30
    L25:
        r119 = 0;
        goto L26
    L21:
        r114 = 0;
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

    public final String toString() {
        return "PkInviteParams(rivalTag=" + this.f92993a + ", theme=" + this.f92994b + ", duration=" + this.f92995c + ", activityName=" + this.f92996d + ", inviteSource=" + this.f92997e + ", multiPkMode=" + this.f92998f + ", battleConfigSetting=" + this.f92999g + ", battleAttachedInfo=" + this.f93000h + ", inviteIndex=" + this.f93001i + ", decideDuration=" + this.f93002j + ", clientAttachedInfo=" + this.f93003k + ", gameId=" + this.f93004l + ", logMap=" + this.f93005m + ")";
    }

    public f(List r110, String r111, int r112, String r210, int r211, IBattleConfigSetting r212, String r213, int r214, long r215, v3 r216, String r217, HashMap r218, int r310) {
        HashMap r100 = null;
        if ((r310 & 1) == 0) goto L5;
        List r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r102 = l51.a.m();
    L11:
        if ((r310 & 4) == 0) goto L13;
        int r103 = l51.a.j();
    L14:
        String r104 = "";
        if ((r310 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r310 & 16) == 0) goto L21;
        int r106 = 0;
    L23:
        if ((r310 & 64) == 0) goto L25;
        IBattleConfigSetting r113 = null;
    L27:
        if ((r310 & 128) != 0) goto L31;
        r104 = r213;
    L31:
        if ((r310 & 256) == 0) goto L33;
        int r114 = 0;
    L35:
        if ((r310 & 512) == 0) goto L37;
        long r115 = 0;
    L39:
        if ((r310 & 1024) == 0) goto L41;
        v3 r116 = null;
    L43:
        if ((r310 & 2048) == 0) goto L45;
        String r117 = null;
    L47:
        if ((r310 & 4096) != 0) goto L50;
        r100 = r218;
    L50:
        Intrinsics.checkNotNullParameter(r102, "theme");
        Intrinsics.checkNotNullParameter(r105, "activityName");
        this.f92993a = r101;
        this.f92994b = r102;
        this.f92995c = r103;
        this.f92996d = r105;
        this.f92997e = r106;
        this.f92998f = 0;
        this.f92999g = r113;
        this.f93000h = r104;
        this.f93001i = r114;
        this.f93002j = r115;
        this.f93003k = r116;
        this.f93004l = r117;
        this.f93005m = r100;
        return;
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
    L25:
        r113 = r212;
        goto L27
    L21:
        r106 = r211;
        goto L23
    L17:
        r105 = r210;
        goto L19
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
