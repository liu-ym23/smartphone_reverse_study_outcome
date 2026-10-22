package com.bytedance.android.livesdk.livecommerce.skin.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.MobConstants;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinImageElement;", "Ljava/io/Serializable;", "resourceName", "", "tintColor", "", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinColors;", "url", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getResourceName", "()Ljava/lang/String;", "getTintColor", "()Ljava/util/List;", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveSkinImageElement implements Serializable {

    @SerializedName(MobConstants.RESOURCE_NAME)
    private final String resourceName;

    @SerializedName("tint_color")
    private final List<String> tintColor;

    @SerializedName("url")
    private final String url;

    public ECLiveSkinImageElement() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECLiveSkinImageElement copy$default(ECLiveSkinImageElement r100, String r101, List r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.resourceName;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.tintColor;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.url;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.resourceName;
    }

    public final List<String> component2() {
        return this.tintColor;
    }

    public final String component3() {
        return this.url;
    }

    public final ECLiveSkinImageElement copy(String r100, List<String> r101, String r102) {
        return new ECLiveSkinImageElement(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECLiveSkinImageElement) == false) goto L12;
        ECLiveSkinImageElement r101 = (ECLiveSkinImageElement) r100;
        if (Intrinsics.areEqual(this.resourceName, r101.resourceName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.tintColor, r101.tintColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.resourceName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.tintColor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.url;
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

    public String toString() {
        return "ECLiveSkinImageElement(resourceName=" + this.resourceName + ", tintColor=" + this.tintColor + ", url=" + this.url + ")";
    }

    public final String getResourceName() {
        return this.resourceName;
    }

    public final List<String> getTintColor() {
        return this.tintColor;
    }

    public final String getUrl() {
        return this.url;
    }

    public ECLiveSkinImageElement(String r100, List<String> r101, String r102) {
        this.resourceName = r100;
        this.tintColor = r101;
        this.url = r102;
    }

    public /* synthetic */ ECLiveSkinImageElement(String r100, List r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
