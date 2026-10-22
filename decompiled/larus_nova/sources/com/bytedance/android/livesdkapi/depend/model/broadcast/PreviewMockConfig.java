package com.bytedance.android.livesdkapi.depend.model.broadcast;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/PreviewMockConfig;", "", "width", "", "height", "leftMargin", "topMargin", "(IIII)V", "getHeight", "()I", "getLeftMargin", "getTopMargin", "getWidth", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewMockConfig {

    @SerializedName("height")
    private final int height;

    @SerializedName("leftMargin")
    private final int leftMargin;

    @SerializedName("topMargin")
    private final int topMargin;

    @SerializedName("width")
    private final int width;

    public PreviewMockConfig() {
        this(0, 0, 0, 0, 15, null);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLeftMargin() {
        return this.leftMargin;
    }

    public final int getTopMargin() {
        return this.topMargin;
    }

    public final int getWidth() {
        return this.width;
    }

    public PreviewMockConfig(int r100, int r101, int r102, int r103) {
        this.width = r100;
        this.height = r101;
        this.leftMargin = r102;
        this.topMargin = r103;
    }

    public /* synthetic */ PreviewMockConfig(int r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
