package com.bytedance.android.livesdk.chatroom.model;

import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class w2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f106977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f106978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f106979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f106980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f106981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f106982f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f106983g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f106984h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof w2) == false) goto L22;
        w2 r101 = (w2) r100;
        if (Intrinsics.areEqual(this.f106977a, r101.f106977a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f106978b, r101.f106978b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f106979c, r101.f106979c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f106980d, r101.f106980d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f106981e, r101.f106981e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f106982f, r101.f106982f) == true) goto L18;
        return false;
    L18:
        if (this.f106983g == r101.f106983g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f106984h, r101.f106984h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v24 */
    public final int hashCode() {
        String r100 = this.f106977a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f106978b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f106979c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f106980d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f106981e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f106982f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.f106983g;
        ?? r120 = r119;
        if (r119 == false) goto L29;
        r120 = 1;
    L29:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f106984h;
        if (r122 == null) goto L33;
        r101 = r122.hashCode();
    L33:
        return r121 + r101;
    L25:
        r117 = 0;
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
        return "ProfitOpenGameCenterItemModel(appId=" + this.f106977a + ", name=" + this.f106978b + ", iconUrl=" + this.f106979c + ", version=" + this.f106980d + ", config=" + this.f106981e + ", desc=" + this.f106982f + ", canStartByAudience=" + this.f106983g + ", gameCategory=" + this.f106984h + ")";
    }

    public w2(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "iconUrl");
        Intrinsics.checkNotNullParameter(r103, "version");
        Intrinsics.checkNotNullParameter(r104, "config");
        Intrinsics.checkNotNullParameter(r105, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r107, "gameCategory");
        this.f106977a = r100;
        this.f106978b = r101;
        this.f106979c = r102;
        this.f106980d = r103;
        this.f106981e = r104;
        this.f106982f = r105;
        this.f106983g = r106;
        this.f106984h = r107;
    }
}
