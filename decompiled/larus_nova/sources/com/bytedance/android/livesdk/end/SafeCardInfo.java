package com.bytedance.android.livesdk.end;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yu1.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J!\u0010\u0007\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/end/SafeCardInfo;", "Lyu1/a;", "", "component1", "component2", ThumbGlideUrl.SOURCE_TEMPLATE, "data", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getTemplate", "()Ljava/lang/String;", "setTemplate", "(Ljava/lang/String;)V", "getData", "setData", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SafeCardInfo extends a {

    @SerializedName("data")
    private String data;

    @SerializedName(ThumbGlideUrl.SOURCE_TEMPLATE)
    private String template;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCardInfo() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SafeCardInfo copy$default(SafeCardInfo r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.template;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.data;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.template;
    }

    public final String component2() {
        return this.data;
    }

    public final SafeCardInfo copy(String r100, String r101) {
        return new SafeCardInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SafeCardInfo) == false) goto L10;
        SafeCardInfo r101 = (SafeCardInfo) r100;
        if (Intrinsics.areEqual(this.template, r101.template) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.template;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.data;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SafeCardInfo(template=" + this.template + ", data=" + this.data + ")";
    }

    public final String getData() {
        return this.data;
    }

    public final String getTemplate() {
        return this.template;
    }

    public final void setData(String r100) {
        this.data = r100;
    }

    public final void setTemplate(String r100) {
        this.template = r100;
    }

    public SafeCardInfo(String r100, String r101) {
        this.template = r100;
        this.data = r101;
    }

    public /* synthetic */ SafeCardInfo(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
