package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;", "", "content", "", "style", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;)V", "getContent", "()Ljava/lang/String;", "getStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextBaseUIParams {

    @SerializedName("content")
    private final String content;

    @SerializedName("client_style")
    private final ProductStyle style;

    /* JADX WARN: Multi-variable type inference failed */
    public TextBaseUIParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TextBaseUIParams copy$default(TextBaseUIParams r100, String r101, ProductStyle r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.content;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.style;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.content;
    }

    public final ProductStyle component2() {
        return this.style;
    }

    public final TextBaseUIParams copy(String r100, ProductStyle r101) {
        return new TextBaseUIParams(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TextBaseUIParams) == false) goto L10;
        TextBaseUIParams r101 = (TextBaseUIParams) r100;
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.style, r101.style) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.content;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ProductStyle r104 = this.style;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "TextBaseUIParams(content=" + this.content + ", style=" + this.style + ")";
    }

    public final String getContent() {
        return this.content;
    }

    public final ProductStyle getStyle() {
        return this.style;
    }

    public TextBaseUIParams(String r100, ProductStyle r101) {
        this.content = r100;
        this.style = r101;
    }

    public /* synthetic */ TextBaseUIParams(String r100, ProductStyle r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
