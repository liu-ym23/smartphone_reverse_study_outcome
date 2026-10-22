package com.bytedance.android.shopping.anchorv4.dto.business;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B3\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/GallerySliceVisibilityConfig;", "Ljava/io/Serializable;", "hide", "", "", "show", "animType", "(Ljava/util/List;Ljava/util/List;I)V", "getAnimType", "()I", "getHide", "()Ljava/util/List;", "getShow", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GallerySliceVisibilityConfig implements Serializable {

    @SerializedName("anim_type")
    private final int animType;

    @SerializedName("hide")
    private final List<Integer> hide;

    @SerializedName("show")
    private final List<Integer> show;

    public GallerySliceVisibilityConfig() {
        this(null, null, 0, 7, null);
    }

    public final int getAnimType() {
        return this.animType;
    }

    public final List<Integer> getHide() {
        return this.hide;
    }

    public final List<Integer> getShow() {
        return this.show;
    }

    public GallerySliceVisibilityConfig(List<Integer> r100, List<Integer> r101, int r102) {
        this.hide = r100;
        this.show = r101;
        this.animType = r102;
    }

    public /* synthetic */ GallerySliceVisibilityConfig(List r100, List r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 1;
    L11:
        this(r100, r101, r102);
    }
}
