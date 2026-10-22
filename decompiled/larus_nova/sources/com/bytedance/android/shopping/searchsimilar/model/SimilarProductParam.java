package com.bytedance.android.shopping.searchsimilar.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001$BA\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\t\u001a\u00020\u0002HÆ\u0003JJ\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/model/SimilarProductParam;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "", "component4", "()Ljava/lang/Integer;", "component5", "awemeId", "enterFrom", "authorId", "totalPanelHeight", "monitorName", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/searchsimilar/model/SimilarProductParam;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getAwemeId", "()Ljava/lang/String;", "getEnterFrom", "getAuthorId", "Ljava/lang/Integer;", "getTotalPanelHeight", "getMonitorName", "setMonitorName", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarProductParam implements Serializable {
    public static final String AUTHOR_id = "author_id";
    public static final String AWEME_ID = "aweme_id";
    public static final a Companion = null;
    public static final String ENTER_FROM = "enter_from";
    public static final String TOTAL_PANEL_HEIGHT = "total_panel_height";
    private final String authorId;
    private final String awemeId;
    private final String enterFrom;
    private String monitorName;
    private final Integer totalPanelHeight;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SimilarProductParam() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SimilarProductParam copy$default(SimilarProductParam r100, String r101, String r102, String r103, Integer r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.awemeId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.enterFrom;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.authorId;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.totalPanelHeight;
    L14:
        Integer r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.monitorName;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.awemeId;
    }

    public final String component2() {
        return this.enterFrom;
    }

    public final String component3() {
        return this.authorId;
    }

    public final Integer component4() {
        return this.totalPanelHeight;
    }

    public final String component5() {
        return this.monitorName;
    }

    public final SimilarProductParam copy(String r100, String r101, String r110, Integer r111, String r112) {
        Intrinsics.checkNotNullParameter(r112, "monitorName");
        return new SimilarProductParam(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SimilarProductParam) == false) goto L16;
        SimilarProductParam r101 = (SimilarProductParam) r100;
        if (Intrinsics.areEqual(this.awemeId, r101.awemeId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.authorId, r101.authorId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.totalPanelHeight, r101.totalPanelHeight) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.monitorName, r101.monitorName) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.awemeId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.enterFrom;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.authorId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.totalPanelHeight;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.monitorName;
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

    public String toString() {
        return "SimilarProductParam(awemeId=" + this.awemeId + ", enterFrom=" + this.enterFrom + ", authorId=" + this.authorId + ", totalPanelHeight=" + this.totalPanelHeight + ", monitorName=" + this.monitorName + ")";
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getAwemeId() {
        return this.awemeId;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getMonitorName() {
        return this.monitorName;
    }

    public final Integer getTotalPanelHeight() {
        return this.totalPanelHeight;
    }

    public final void setMonitorName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.monitorName = r100;
    }

    public SimilarProductParam(String r100, String r101, String r102, Integer r103, String r104) {
        Intrinsics.checkNotNullParameter(r104, "monitorName");
        this.awemeId = r100;
        this.enterFrom = r101;
        this.authorId = r102;
        this.totalPanelHeight = r103;
        this.monitorName = r104;
    }

    public /* synthetic */ SimilarProductParam(String r100, String r101, String r102, Integer r103, String r104, int r105, DefaultConstructorMarker r110) {
        Integer r106 = null;
        if ((r105 & 1) == 0) goto L5;
        String r111 = null;
    L7:
        if ((r105 & 2) == 0) goto L9;
        String r107 = null;
    L11:
        if ((r105 & 4) == 0) goto L13;
        String r108 = null;
    L15:
        if ((r105 & 8) != 0) goto L19;
        r106 = r103;
    L19:
        if ((r105 & 16) == 0) goto L21;
        r104 = "";
    L21:
        this(r111, r107, r108, r106, r104);
        return;
    L13:
        r108 = r102;
        goto L15
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
