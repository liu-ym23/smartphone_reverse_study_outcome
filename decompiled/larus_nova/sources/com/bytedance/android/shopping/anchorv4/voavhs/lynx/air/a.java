package com.bytedance.android.shopping.anchorv4.voavhs.lynx.air;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.UI;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.gson.JsonObject;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends VOIdentifier {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f170001g = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f170002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f170003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f170004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f170005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ComponentDTO f170006f;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.lynx.air.a$a, reason: collision with other inner class name */
    public static final class C2556a {
        public static a a(ComponentDTO r100) {
            Intrinsics.checkNotNullParameter(r100, "componentDTO");
            r100.getComponentId();
            Objects.toString(r100.getTrack());
            UI r101 = r100.getUi();
            if (r101 == null) goto L5;
            r101.getResourceAddress();
        L5:
            VO r102 = r100.getVo();
            String r103 = null;
            if (r102 == null) goto L8;
            JsonObject r104 = r102.getMeta();
        L9:
            Objects.toString(r104);
            UI r105 = r100.getUi();
            if (r105 == null) goto L12;
            String r106 = r105.getResourceAddress();
        L13:
            VO r107 = r100.getVo();
            if (r107 == null) goto L18;
            JsonObject r108 = r107.getMeta();
            if (r108 == null) goto L18;
            r103 = r108.toString();
        L18:
            String r109 = r103;
            JsonObject r110 = r100.getTrack();
            if (r110 == null) goto L21;
            JSONObject r111 = tv5.a.c(r110);
        L23:
            return new a(r106, r109, r111, r100, 8);
        L21:
            r111 = new JSONObject(SliceInitService.DEFAULT_SWITCH);
            goto L23
        L12:
            r106 = null;
            goto L13
        L8:
            r104 = null;
            goto L9
        }
    }

    static {
    }

    public a() {
        this(null, null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f170002b, r101.f170002b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f170003c, r101.f170003c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f170004d, r101.f170004d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f170005e, r101.f170005e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f170006f, r101.f170006f) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f170002b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f170003c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        JSONObject r107 = this.f170004d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        JSONObject r110 = this.f170005e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ComponentDTO r113 = this.f170006f;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "AnchorV4LynxAirNodeVO(lynxAddress=" + this.f170002b + ", meta=" + this.f170003c + ", logParams=" + this.f170004d + ", originMetaParams=" + this.f170005e + ", component=" + this.f170006f + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public final String identifier() {
        ComponentDTO r100 = this.f170006f;
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

    public a(String r100, String r101, JSONObject r102, ComponentDTO r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 16) == 0) goto L14;
        r103 = null;
    L14:
        this.f170002b = r100;
        this.f170003c = r101;
        this.f170004d = r102;
        this.f170005e = null;
        this.f170006f = r103;
    }
}
