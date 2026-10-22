package com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f85033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f85034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f85035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f85036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageModel f85037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f85038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f85039g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f85040h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f85041i;

    public b() {
        this(null, null, null, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L24;
        b r101 = (b) r100;
        if (this.f85033a == r101.f85033a) goto L8;
        return false;
    L8:
        if (this.f85034b == r101.f85034b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f85035c, r101.f85035c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f85036d, r101.f85036d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f85037e, r101.f85037e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f85038f, r101.f85038f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f85039g, r101.f85039g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f85040h, r101.f85040h) == true) goto L22;
        return false;
    L22:
        if (this.f85041i == r101.f85041i) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f85033a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f85034b) * 31;
        String r102 = this.f85035c;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f85036d;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        ImageModel r109 = this.f85037e;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f85038f;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f85039g;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f85040h;
        if (r118 == null) goto L26;
        r103 = r118.hashCode();
    L26:
        return ((r117 + r103) * 31) + this.f85041i;
    L21:
        r116 = 0;
        goto L22
    L17:
        r113 = 0;
        goto L18
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "ExplainCardInfo(cardId=" + this.f85033a + ", titleType=" + this.f85034b + ", title=" + this.f85035c + ", cover=" + this.f85036d + ", icon=" + this.f85037e + ", appName=" + this.f85038f + ", btnText=" + this.f85039g + ", topIcon=" + this.f85040h + ", showDuration=" + this.f85041i + ")";
    }

    public static b a(b r110, String r111, String r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        long r100 = r110.f85033a;
    L6:
        long r101 = r100;
        if ((r113 & 2) == 0) goto L9;
        int r102 = r110.f85034b;
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r103 = r110.f85035c;
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r104 = r110.f85036d;
    L19:
        if ((r113 & 16) == 0) goto L21;
        ImageModel r114 = r110.f85037e;
    L23:
        if ((r113 & 32) == 0) goto L25;
        String r115 = r110.f85038f;
    L27:
        if ((r113 & 64) == 0) goto L29;
        String r116 = r110.f85039g;
    L31:
        if ((r113 & 128) == 0) goto L33;
        String r117 = r110.f85040h;
    L35:
        if ((r113 & 256) == 0) goto L37;
        int r118 = r110.f85041i;
    L39:
        return new b(r101, r102, r103, r104, r114, r115, r116, r117, r118);
    L37:
        r118 = 0;
        goto L39
    L33:
        r117 = null;
        goto L35
    L29:
        r116 = null;
        goto L31
    L25:
        r115 = null;
        goto L27
    L21:
        r114 = null;
        goto L23
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = 0;
        goto L11
    L5:
        r100 = 0;
        goto L6
    }

    public /* synthetic */ b(String r110, String r111, ImageModel r112, String r113, String r114, int r115) {
        if ((r115 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r115 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r115 & 16) == 0) goto L13;
        ImageModel r102 = null;
    L15:
        if ((r115 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r115 & 64) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r115 & 128) == 0) goto L27;
        uc1 r105 = ee0.f120119a.getValue();
        if (r105 == null) goto L27;
        String r116 = r105.n();
    L28:
        this(0, 0, r100, r101, r102, r103, r104, r116, 0);
        return;
    L27:
        r116 = null;
        goto L28
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
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

    public b(long r100, int r101, String r102, String r103, ImageModel r104, String r105, String r106, String r107, int r110) {
        this.f85033a = r100;
        this.f85034b = r101;
        this.f85035c = r102;
        this.f85036d = r103;
        this.f85037e = r104;
        this.f85038f = r105;
        this.f85039g = r106;
        this.f85040h = r107;
        this.f85041i = r110;
    }
}
