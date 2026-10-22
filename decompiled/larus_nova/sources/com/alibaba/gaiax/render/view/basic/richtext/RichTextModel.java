package com.alibaba.gaiax.render.view.basic.richtext;

import com.alibaba.gaiax.utils.GXExtJsonKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B3\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J5\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/richtext/RichTextModel;", "", "text", "", "images", "", "Lcom/alibaba/gaiax/render/view/basic/richtext/ImageInfo;", "ranges", "Lcom/alibaba/gaiax/render/view/basic/richtext/RangeInfo;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getImages", "()Ljava/util/List;", "getRanges", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RichTextModel {
    public static final Companion Companion = null;
    private final List<ImageInfo> images;
    private final List<RangeInfo> ranges;
    private final String text;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u001a\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¨\u0006\u000e"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/richtext/RichTextModel$Companion;", "", "()V", "createByExtend", "Lcom/alibaba/gaiax/render/view/basic/richtext/RichTextModel;", "textModel", "Lorg/json/JSONObject;", "createImageList", "", "imageJSONArray", "Lorg/json/JSONArray;", "richTextModel", "createRangeList", "rangeJSONArray", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final RichTextModel createByExtend(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "textModel");
            RichTextModel r101 = new RichTextModel(r100.optString("text", null), null, null, 6, null);
            Companion r102 = RichTextModel.Companion;
            r102.createImageList(r100.optJSONArray("images"), r101);
            r102.createRangeList(r100.optJSONArray("ranges"), r101);
            return r101;
        }

        private final void createImageList(JSONArray r100, final RichTextModel r101) {
            if (r100 == null) goto L5;
            GXExtJsonKt.forEach(r100, new RichTextModel$Companion$createImageList$1(r101));
            return;
        }

        private final void createRangeList(JSONArray r100, final RichTextModel r101) {
            if (r100 == null) goto L5;
            GXExtJsonKt.forEach(r100, new RichTextModel$Companion$createRangeList$1(r101));
            return;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RichTextModel() {
        this(null, null, null, 7, null);
    }

    public RichTextModel(String r100) {
        this(r100, null, null, 6, null);
    }

    public RichTextModel(String r100, List<ImageInfo> r101) {
        Intrinsics.checkNotNullParameter(r101, "images");
        this(r100, r101, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RichTextModel copy$default(RichTextModel r100, String r101, List r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.images;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.ranges;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.text;
    }

    public final List<ImageInfo> component2() {
        return this.images;
    }

    public final List<RangeInfo> component3() {
        return this.ranges;
    }

    public final RichTextModel copy(String r100, List<ImageInfo> r101, List<RangeInfo> r102) {
        Intrinsics.checkNotNullParameter(r101, "images");
        Intrinsics.checkNotNullParameter(r102, "ranges");
        return new RichTextModel(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RichTextModel) == true) goto L8;
        return false;
    L8:
        RichTextModel r101 = (RichTextModel) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.images, r101.images) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ranges, r101.ranges) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.text;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.images.hashCode()) * 31) + this.ranges.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "RichTextModel(text=" + this.text + ", images=" + this.images + ", ranges=" + this.ranges + ')';
    }

    public final List<ImageInfo> getImages() {
        return this.images;
    }

    public final List<RangeInfo> getRanges() {
        return this.ranges;
    }

    public final String getText() {
        return this.text;
    }

    public RichTextModel(String r100, List<ImageInfo> r101, List<RangeInfo> r102) {
        Intrinsics.checkNotNullParameter(r101, "images");
        Intrinsics.checkNotNullParameter(r102, "ranges");
        this.text = r100;
        this.images = r101;
        this.ranges = r102;
    }

    public /* synthetic */ RichTextModel(String r100, List r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = new ArrayList();
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = new ArrayList();
    L11:
        this(r100, r101, r102);
    }
}
