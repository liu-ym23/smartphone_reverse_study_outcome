package com.bytedance.android.shopping.anchorv4.dto.business;

import com.bytedance.android.shopping.anchorv4.dto.PendantContainer;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryPendants;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryConfig;", "config", "Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryConfig;", "getConfig", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryConfig;", "", "Lcom/bytedance/android/ecom/arch/slice/g;", "slices", "Ljava/util/List;", "getSlices", "()Ljava/util/List;", "Lcom/bytedance/android/shopping/anchorv4/dto/PendantContainer;", "lynxs", "Lcom/bytedance/android/shopping/anchorv4/dto/PendantContainer;", "getLynxs", "()Lcom/bytedance/android/shopping/anchorv4/dto/PendantContainer;", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryConfig;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/PendantContainer;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GalleryPendants implements Serializable {

    @SerializedName("config")
    private final GalleryConfig config;

    @SerializedName("lynx_pendant_container")
    private final PendantContainer lynxs;

    @SerializedName("slices")
    private final List<com.bytedance.android.ecom.arch.slice.g> slices;

    public GalleryPendants() {
        this(null, null, null, 7, null);
    }

    public final GalleryConfig getConfig() {
        return this.config;
    }

    public final PendantContainer getLynxs() {
        return this.lynxs;
    }

    public final List<com.bytedance.android.ecom.arch.slice.g> getSlices() {
        return this.slices;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GalleryPendants(GalleryConfig r100, List<? extends com.bytedance.android.ecom.arch.slice.g> r101, PendantContainer r102) {
        this.config = r100;
        this.slices = r101;
        this.lynxs = r102;
    }

    public /* synthetic */ GalleryPendants(GalleryConfig r100, List r101, PendantContainer r102, int r103, DefaultConstructorMarker r104) {
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
