package com.bytedance.android.shopping.anchorv4.voavhs.lynx;

import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.UI;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends VOIdentifier {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f169990h = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f169991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f169992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f169993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f169994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ComponentDTO f169995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.dto.business.a f169996g;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.lynx.a$a, reason: collision with other inner class name */
    public static final class C2555a {
        public static a a(ComponentDTO r100) {
            Intrinsics.checkNotNullParameter(r100, "componentDTO");
            UI r101 = r100.getUi();
            if (r101 == null) goto L5;
            String r102 = r101.getResourceAddress();
        L6:
            VO r103 = r100.getVo();
            if (r103 == null) goto L9;
            JsonObject r104 = r103.getMeta();
        L10:
            String r105 = String.valueOf(r104);
            JSONObject r106 = tv5.a.c(r100.getTrack());
            UI r107 = r100.getUi();
            if (r107 == null) goto L13;
            com.bytedance.android.shopping.anchorv4.dto.business.a r108 = r107.getStyle();
        L15:
            return new a(r102, r105, r106, r100, r108, 8);
        L13:
            r108 = null;
            goto L15
        L9:
            r104 = null;
            goto L10
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
    }

    public a() {
        this(null, null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f169991b, r101.f169991b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f169992c, r101.f169992c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f169993d, r101.f169993d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f169994e, r101.f169994e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f169995f, r101.f169995f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f169996g, r101.f169996g) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f169991b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f169992c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        JSONObject r107 = this.f169993d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        JSONObject r110 = this.f169994e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ComponentDTO r113 = this.f169995f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        com.bytedance.android.shopping.anchorv4.dto.business.a r116 = this.f169996g;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "AnchorV4LynxNodeVO(lynxAddress=" + this.f169991b + ", meta=" + this.f169992c + ", logParams=" + this.f169993d + ", originMetaParams=" + this.f169994e + ", component=" + this.f169995f + ", style=" + this.f169996g + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public final String identifier() {
        ComponentDTO r100 = this.f169995f;
        if (r100 == null) goto L5;
        String r101 = r100.getComponentId();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public static a a(a r100, ComponentDTO r101) {
        String r102 = r100.f169991b;
        String r103 = r100.f169992c;
        JSONObject r104 = r100.f169993d;
        JSONObject r105 = r100.f169994e;
        com.bytedance.android.shopping.anchorv4.dto.business.a r106 = r100.f169996g;
        r100.getClass();
        return new a(r102, r103, r104, r105, r101, r106);
    }

    public /* synthetic */ a(String r110, String r111, JSONObject r112, ComponentDTO r113, com.bytedance.android.shopping.anchorv4.dto.business.a r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r115 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r115 & 4) == 0) goto L13;
        JSONObject r102 = null;
    L15:
        if ((r115 & 16) == 0) goto L17;
        ComponentDTO r103 = null;
    L19:
        if ((r115 & 32) == 0) goto L21;
        com.bytedance.android.shopping.anchorv4.dto.business.a r104 = null;
    L22:
        this(r100, r101, r102, null, r103, r104);
        return;
    L21:
        r104 = r114;
        goto L22
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

    public a(String r100, String r101, JSONObject r102, JSONObject r103, ComponentDTO r104, com.bytedance.android.shopping.anchorv4.dto.business.a r105) {
        this.f169991b = r100;
        this.f169992c = r101;
        this.f169993d = r102;
        this.f169994e = r103;
        this.f169995f = r104;
        this.f169996g = r105;
    }
}
