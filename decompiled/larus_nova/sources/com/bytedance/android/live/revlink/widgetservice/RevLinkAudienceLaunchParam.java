package com.bytedance.android.live.revlink.widgetservice;

import com.bytedance.android.livesdk.link.model.a6;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import sc0.b;
import sc0.d;

/* JADX INFO: loaded from: classes47.dex */
public final class RevLinkAudienceLaunchParam {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f98829i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f98830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f98831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Integer> f98832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Integer> f98833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a6 f98834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f98835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f98836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f98837h;

    public static final class Companion {
        public static RevLinkAudienceLaunchParam a(int r110, long r111) {
            return new RevLinkAudienceLaunchParam(r110, r111, RevLinkAudienceLaunchParam$Companion$genMergeSceneSwitchParam$1.INSTANCE, RevLinkAudienceLaunchParam$Companion$genMergeSceneSwitchParam$2.INSTANCE, null, null, 240);
        }
    }

    static {
    }

    public RevLinkAudienceLaunchParam() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RevLinkAudienceLaunchParam) == false) goto L22;
        RevLinkAudienceLaunchParam r101 = (RevLinkAudienceLaunchParam) r100;
        if (this.f98830a == r101.f98830a) goto L8;
        return false;
    L8:
        if (this.f98831b == r101.f98831b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f98832c, r101.f98832c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f98833d, r101.f98833d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f98834e, r101.f98834e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f98835f, r101.f98835f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f98836g, r101.f98836g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f98837h, r101.f98837h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f98830a * 31;
        long r101 = this.f98831b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        Function0<Integer> r103 = this.f98832c;
        int r104 = 0;
        if (r103 == null) goto L5;
        int r105 = r103.hashCode();
    L6:
        int r106 = (r102 + r105) * 31;
        Function0<Integer> r107 = this.f98833d;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        a6 r110 = this.f98834e;
        if (r110 == null) goto L13;
        int r111 = r110.hashCode();
    L14:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f98835f;
        if (r113 == null) goto L17;
        int r114 = r113.hashCode();
    L18:
        int r115 = (r112 + r114) * 31;
        b r116 = this.f98836g;
        if (r116 == null) goto L21;
        int r117 = r116.hashCode();
    L22:
        int r118 = (r115 + r117) * 31;
        d r119 = this.f98837h;
        if (r119 == null) goto L26;
        r104 = r119.hashCode();
    L26:
        return r118 + r104;
    L21:
        r117 = 0;
        goto L22
    L17:
        r114 = 0;
        goto L18
    L13:
        r111 = 0;
        goto L14
    L9:
        r108 = 0;
        goto L10
    L5:
        r105 = 0;
        goto L6
    }

    public final String toString() {
        return "RevLinkAudienceLaunchParam(scene=" + this.f98830a + ", channelID=" + this.f98831b + ", containerWidth=" + this.f98832c + ", containerHeight=" + this.f98833d + ", enterContent=" + this.f98834e + ", guestUID=" + this.f98835f + ", multiLinkAudienceSwitchContext=" + this.f98836g + ", pkAudienceSwitchContext=" + this.f98837h + ")";
    }

    public RevLinkAudienceLaunchParam(int r100, long r101, Function0 r102, Function0 r103, a6 r104, com.bytedance.android.live.revlink.impl.control.launchcontext.b r105, int r110) {
        if ((r110 & 4) == 0) goto L6;
        r102 = AnonymousClass1.INSTANCE;
    L6:
        if ((r110 & 8) == 0) goto L9;
        r103 = AnonymousClass2.INSTANCE;
    L9:
        if ((r110 & 16) == 0) goto L12;
        r104 = null;
    L12:
        if ((r110 & 64) == 0) goto L14;
        r105 = null;
    L14:
        Intrinsics.checkNotNullParameter(r102, "containerWidth");
        Intrinsics.checkNotNullParameter(r103, "containerHeight");
        this.f98830a = r100;
        this.f98831b = r101;
        this.f98832c = r102;
        this.f98833d = r103;
        this.f98834e = r104;
        this.f98835f = null;
        this.f98836g = r105;
        this.f98837h = null;
    }
}
