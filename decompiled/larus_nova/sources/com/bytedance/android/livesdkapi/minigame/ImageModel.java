package com.bytedance.android.livesdkapi.minigame;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/ImageModel;", "Ljava/io/Serializable;", "mUrls", "", "", "(Ljava/util/List;)V", "getMUrls", "()Ljava/util/List;", "setMUrls", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageModel implements Serializable {

    @SerializedName(ScoreTags.STAR_URL_LIST)
    private List<String> mUrls;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageModel copy$default(ImageModel r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.mUrls;
    L6:
        return r100.copy(r101);
    }

    public final List<String> component1() {
        return this.mUrls;
    }

    public final ImageModel copy(List<String> r100) {
        return new ImageModel(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ImageModel) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.mUrls, ((ImageModel) r100).mUrls) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.mUrls;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "ImageModel(mUrls=" + this.mUrls + ")";
    }

    public final List<String> getMUrls() {
        return this.mUrls;
    }

    public ImageModel(List<String> r100) {
        this.mUrls = r100;
    }

    public final void setMUrls(List<String> r100) {
        this.mUrls = r100;
    }

    public /* synthetic */ ImageModel(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
