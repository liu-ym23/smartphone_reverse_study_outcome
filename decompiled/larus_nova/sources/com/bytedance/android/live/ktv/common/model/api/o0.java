package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/o0;", "", "", "name", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "description", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "withStyle", "I", "getWithStyle", "()I", "", "extra", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "Lcom/bytedance/android/live/ktv/common/model/api/n0;", "titleFont", "Lcom/bytedance/android/live/ktv/common/model/api/n0;", "getTitleFont", "()Lcom/bytedance/android/live/ktv/common/model/api/n0;", "iconUrl", "getIconUrl", "setIconUrl", "(Ljava/lang/String;)V", "tabType", "e", "", "subLabelList", "Ljava/util/List;", "d", "()Ljava/util/List;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class o0 implements vh7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f69985a = 0;

    @SerializedName("description")
    protected String description;

    @SerializedName("extra")
    protected Map<String, String> extra;

    @SerializedName("icon_url")
    protected String iconUrl;

    @SerializedName("name")
    protected String name;

    @SerializedName("sub_tabs")
    protected List<o0> subLabelList;

    @SerializedName("tab_type")
    protected int tabType;

    @SerializedName("title_font")
    protected n0 titleFont;

    @SerializedName("with_style")
    protected int withStyle;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o0) == false) goto L22;
        o0 r101 = (o0) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L10;
        return false;
    L10:
        if (this.withStyle == r101.withStyle) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.titleFont, r101.titleFont) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L18;
        return false;
    L18:
        if (this.tabType == r101.tabType) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.subLabelList, r101.subLabelList) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.description;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.withStyle) * 31;
        Map<String, String> r107 = this.extra;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        n0 r110 = this.titleFont;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.iconUrl;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (((r112 + r114) * 31) + this.tabType) * 31;
        List<o0> r116 = this.subLabelList;
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
        return "PlaylistLabel(name=" + this.name + ", description=" + this.description + ", withStyle=" + this.withStyle + ", extra=" + this.extra + ", titleFont=" + this.titleFont + ", iconUrl=" + this.iconUrl + ", tabType=" + this.tabType + ", subLabelList=" + this.subLabelList + ")";
    }

    public final boolean f() {
        List<o0> r100 = this.subLabelList;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if ((!r100.isEmpty()) != true) goto L7;
        return true;
    }

    public o0() {
        this.name = "";
        this.description = "";
        this.withStyle = 0;
        this.extra = null;
        this.titleFont = null;
        this.iconUrl = null;
        this.tabType = 0;
        this.subLabelList = null;
    }

    public final String a() {
        return this.description;
    }

    public final Map<String, String> b() {
        return this.extra;
    }

    public final String c() {
        return this.name;
    }

    public final List<o0> d() {
        return this.subLabelList;
    }

    public final int e() {
        return this.tabType;
    }

    public o0(am3.g r110) {
        this.extra = new HashMap();
        this.subLabelList = new ArrayList();
        long r100 = r110.c();
        int r101 = 0;
    L3:
        int r102 = r110.f();
        String r103 = null;
        if (r102 == (-1)) goto L31;
        switch(r102) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.subLabelList.add(new o0(r110));
        goto L3
    L8:
        this.tabType = r110.i();
        r101 = r101 | 2;
        goto L3
    L9:
        this.iconUrl = am3.h.c(r110);
        goto L3
    L10:
        this.titleFont = new n0(r110);
        goto L3
    L11:
        long r104 = r110.c();
        String r105 = null;
    L12:
        int r111 = r110.f();
        if (r111 == (-1)) goto L20;
        if (r111 != 1) goto L16;
        r103 = am3.h.c(r110);
        goto L12
    L16:
        if (r111 != 2) goto L17;
        r105 = am3.h.c(r110);
        goto L12
    L17:
        am3.h.e(r110);
        goto L12
    L20:
        r110.d(r104);
        Map<String, String> r106 = this.extra;
        if (r103 == null) goto L27;
        if (r105 == null) goto L25;
        r106.put(r103, r105);
        goto L3
    L25:
        throw new IllegalStateException("Value must not be null");
    L27:
        throw new IllegalStateException("Key must not be null");
    L28:
        this.withStyle = (int) r110.j();
        r101 = r101 | 1;
        goto L3
    L29:
        this.description = am3.h.c(r110);
        goto L3
    L30:
        this.name = am3.h.c(r110);
        goto L3
    L6:
        am3.h.e(r110);
        goto L3
    L31:
        r110.d(r100);
        if (this.name != null) goto L35;
        this.name = "";
    L35:
        if (this.description != null) goto L38;
        this.description = "";
    L38:
        if ((r101 & 1) != 0) goto L41;
        this.withStyle = 0;
    L41:
        if (this.extra != null) goto L44;
        this.extra = null;
    L44:
        if (this.titleFont != null) goto L47;
        this.titleFont = null;
    L47:
        if (this.iconUrl != null) goto L50;
        this.iconUrl = null;
    L50:
        if ((r101 & 2) != 0) goto L53;
        this.tabType = 0;
    L53:
        if (this.subLabelList.isEmpty() == false) goto L87;
        this.subLabelList = null;
        return;
    }
}
