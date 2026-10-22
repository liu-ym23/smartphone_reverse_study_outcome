package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.commentbutton;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.b1;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.business.gamedetail.base.model.h;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f54204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f54205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f54206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f54207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f54208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f54209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f54210h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f54211i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f54212j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f54213k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b1 f54214l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b1 f54215m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b1 f54216n;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L34;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f54203a, r101.f54203a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54204b, r101.f54204b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54205c, r101.f54205c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54206d, r101.f54206d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f54207e, r101.f54207e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f54208f, r101.f54208f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f54209g, r101.f54209g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f54210h, r101.f54210h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f54211i, r101.f54211i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f54212j, r101.f54212j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f54213k, r101.f54213k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f54214l, r101.f54214l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f54215m, r101.f54215m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f54216n, r101.f54216n) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 46;
    }

    public final int hashCode() {
        String r100 = this.f54203a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JSONObject r104 = this.f54204b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        h r107 = this.f54205c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f54206d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.f54207e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f54208f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f54209g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f54210h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f54211i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f54212j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f54213k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        b1 r134 = this.f54214l;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        b1 r137 = this.f54215m;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        b1 r140 = this.f54216n;
        if (r140 == null) goto L58;
        r101 = r140.hashCode();
    L58:
        return r139 + r101;
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
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
        return "NewCommentProps(ID=" + this.f54203a + ", rawData=" + this.f54204b + ", commonParams=" + this.f54205c + ", isSingleButton=" + this.f54206d + ", isCompleted=" + this.f54207e + ", nodeSelector=" + this.f54208f + ", evaluationId=" + this.f54209g + ", iconUrl=" + this.f54210h + ", commentButtonSchema=" + this.f54211i + ", openWriteCommentUrl=" + this.f54212j + ", openCommentDetailUrl=" + this.f54213k + ", unCommentStyle=" + this.f54214l + ", commentStyle=" + this.f54215m + ", commentDoubleStyle=" + this.f54216n + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54203a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public c(String r100, JSONObject r101, h r102, Boolean r103, Boolean r104, String r105, String r106, String r107, String r110, String r111, String r112, b1 r113, b1 r114, b1 r115) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f54203a = r100;
        this.f54204b = r101;
        this.f54205c = r102;
        this.f54206d = r103;
        this.f54207e = r104;
        this.f54208f = r105;
        this.f54209g = r106;
        this.f54210h = r107;
        this.f54211i = r110;
        this.f54212j = r111;
        this.f54213k = r112;
        this.f54214l = r113;
        this.f54215m = r114;
        this.f54216n = r115;
    }
}
