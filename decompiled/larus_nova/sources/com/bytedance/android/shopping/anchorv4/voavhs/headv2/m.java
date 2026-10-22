package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.amap.api.col.s.ce;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMetaMappedMap;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR*\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/m;", "", "", "name", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "startIndex", "I", "e", "()I", "", "labelList", "Ljava/util/List;", "c", "()Ljava/util/List;", "totalCount", ce.f26391f, "", "trackMeta", "Ljava/util/Map;", "h", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f169811a;

    @SerializedName("label_list")
    private final List<String> labelList;

    @SerializedName("name")
    private final String name;

    @SerializedName("start_index")
    private final int startIndex;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT)
    private final int totalCount;

    @SerializedName(PageMetaMappedMap.TRACK_META_KEY)
    private final Map<String, Object> trackMeta;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L16;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
        return false;
    L8:
        if (this.startIndex == r101.startIndex) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.labelList, r101.labelList) == true) goto L12;
        return false;
    L12:
        if (this.totalCount == r101.totalCount) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.trackMeta, r101.trackMeta) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.startIndex) * 31;
        List<String> r104 = this.labelList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.totalCount) * 31;
        Map<String, Object> r107 = this.trackMeta;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "HeaderTab(name=" + this.name + ", startIndex=" + this.startIndex + ", labelList=" + this.labelList + ", totalCount=" + this.totalCount + ", trackMeta=" + this.trackMeta + ")";
    }

    public final String f() {
        Map<String, Object> r100 = this.trackMeta;
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get(com.bytedance.android.ec.core.event.a.KEY_IMAGE_TAB_NAME);
    L7:
        if ((r102 instanceof String) == false) goto L11;
        r101 = r102;
    L11:
        return (String) r101;
    L5:
        r102 = null;
        goto L7
    }

    public final List<String> c() {
        return this.labelList;
    }

    public final String d() {
        return this.name;
    }

    public final int e() {
        return this.startIndex;
    }

    public final int g() {
        return this.totalCount;
    }

    public final Map<String, Object> h() {
        return this.trackMeta;
    }

    public final boolean a(int r100) {
        int r101 = this.startIndex;
        if (r101 <= r100) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= (r101 + this.totalCount)) goto L7;
        return true;
    }

    public final String b(int r100) {
        List<String> r101 = this.labelList;
        if (r101 == null) goto L13;
        String r102 = (String) CollectionsKt.getOrNull(r101, r100 - this.startIndex);
        if (r102 != null) goto L7;
        return null;
    L7:
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L12;
        return null;
    L12:
        return r102;
    L9:
        r103 = false;
        goto L10
    L13:
        return null;
    }
}
