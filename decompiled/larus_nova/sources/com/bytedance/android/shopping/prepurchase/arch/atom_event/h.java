package com.bytedance.android.shopping.prepurchase.arch.atom_event;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/atom_event/h;", "", "", "mediaType", "Ljava/lang/String;", "getMediaType", "()Ljava/lang/String;", "", "Lfj/d;", "videos", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "imageUrlArray", "b", "", "imageIndex", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "enterFrom", "getEnterFrom", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f180690a = 0;

    @SerializedName("enter_from")
    private final Integer enterFrom;

    @SerializedName("image_index")
    private final Integer imageIndex;

    @SerializedName("image_url_array")
    private final List<String> imageUrlArray;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE)
    private final String mediaType;

    @SerializedName("video")
    private final List<fj.d> videos;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L16;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.mediaType, r101.mediaType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.videos, r101.videos) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.imageUrlArray, r101.imageUrlArray) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageIndex, r101.imageIndex) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.mediaType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<fj.d> r104 = this.videos;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.imageUrlArray;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.imageIndex;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.enterFrom;
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
        return "PDPMediaPreviewActionAtomEventParam(mediaType=" + this.mediaType + ", videos=" + this.videos + ", imageUrlArray=" + this.imageUrlArray + ", imageIndex=" + this.imageIndex + ", enterFrom=" + this.enterFrom + ")";
    }

    public h() {
        this("", new ArrayList(), CollectionsKt.emptyList(), 0, 0);
    }

    public final Integer a() {
        return this.imageIndex;
    }

    public final List<String> b() {
        return this.imageUrlArray;
    }

    public final List<fj.d> c() {
        return this.videos;
    }

    public h(String r100, List<fj.d> r101, List<String> r102, Integer r103, Integer r104) {
        this.mediaType = r100;
        this.videos = r101;
        this.imageUrlArray = r102;
        this.imageIndex = r103;
        this.enterFrom = r104;
    }
}
