package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.PicoInfo.VirtualLiveBgImages")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\fJ\u0006\u0010\u001e\u001a\u00020\u001fR$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/VirtualLiveBgImages;", "", "originalImage", "Lcom/bytedance/android/live/base/model/ImageModel;", "originalDigest", "", "isUpRight", "", "convertedImages", "", "convertedList", "Lcom/bytedance/android/livesdkapi/depend/model/live/ConvertedImage;", "(Lcom/bytedance/android/live/base/model/ImageModel;Ljava/lang/String;ZLjava/util/List;Ljava/util/List;)V", "getConvertedImages", "()Ljava/util/List;", "setConvertedImages", "(Ljava/util/List;)V", "getConvertedList", "setConvertedList", "()Z", "setUpRight", "(Z)V", "getOriginalDigest", "()Ljava/lang/String;", "setOriginalDigest", "(Ljava/lang/String;)V", "getOriginalImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setOriginalImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "toJsonObj", "Lorg/json/JSONObject;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VirtualLiveBgImages implements h {

    @SerializedName("converted_images")
    protected List<? extends ImageModel> convertedImages;

    @SerializedName("converted_list")
    protected List<ConvertedImage> convertedList;

    @SerializedName("is_upright")
    protected boolean isUpRight;

    @SerializedName("original_digest")
    protected String originalDigest;

    @SerializedName("original_image")
    protected ImageModel originalImage;

    public VirtualLiveBgImages(ImageModel r100, String r101, boolean r102, List<? extends ImageModel> r103, List<ConvertedImage> r104) {
        Intrinsics.checkNotNullParameter(r101, "originalDigest");
        Intrinsics.checkNotNullParameter(r103, "convertedImages");
        Intrinsics.checkNotNullParameter(r104, "convertedList");
        this.originalImage = r100;
        this.originalDigest = r101;
        this.isUpRight = r102;
        this.convertedImages = r103;
        this.convertedList = r104;
    }

    public final JSONObject toJsonObj() {
        JSONObject r100 = new JSONObject();
        ImageModel r101 = this.originalImage;
        if (r101 == null) goto L5;
        r100.put("original_image", ImageModel.toJsonString(r101));
    L5:
        r100.put("original_digest", this.originalDigest);
        r100.put("is_upright", this.isUpRight);
        List<? extends ImageModel> r102 = this.convertedImages;
        List<ConvertedImage> r103 = null;
        if ((!r102.isEmpty()) == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L15;
        JSONArray r104 = new JSONArray();
        Iterator<? extends ImageModel> r105 = r102.iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        r104.put(ImageModel.toJsonString(r105.next()));
        goto L12
    L14:
        Unit r106 = Unit.INSTANCE;
        r100.put("converted_images", r104);
    L15:
        List<ConvertedImage> r107 = this.convertedList;
        if ((!r107.isEmpty()) == false) goto L18;
        r103 = r107;
    L18:
        if (r103 == null) goto L24;
        JSONArray r108 = new JSONArray();
        Iterator<ConvertedImage> r109 = r103.iterator();
    L21:
        if (r109.hasNext() == false) goto L23;
        r108.put(r109.next().toJsonObj());
        goto L21
    L23:
        Unit r110 = Unit.INSTANCE;
        r100.put("converted_list", r108);
    L24:
        return r100;
    }

    public VirtualLiveBgImages() {
        this.originalImage = null;
        this.originalDigest = UUID.randomUUID().toString();
        this.isUpRight = false;
        this.convertedImages = CollectionsKt.emptyList();
        this.convertedList = CollectionsKt.emptyList();
    }

    public final List<ImageModel> getConvertedImages() {
        return this.convertedImages;
    }

    public final List<ConvertedImage> getConvertedList() {
        return this.convertedList;
    }

    public final String getOriginalDigest() {
        return this.originalDigest;
    }

    public final ImageModel getOriginalImage() {
        return this.originalImage;
    }

    public final boolean isUpRight() {
        return this.isUpRight;
    }

    public VirtualLiveBgImages(g r100) {
        this.convertedImages = new ArrayList();
        this.convertedList = new ArrayList();
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        if (r103 != 1) goto L7;
        this.originalImage = x.a(r100);
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.originalDigest = am3.h.c(r100);
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.isUpRight = am3.h.a(r100);
        r102 = r102 | true;
        goto L3
    L11:
        if (r103 == 4) goto L16;
        if (r103 != 5) goto L14;
        List r104 = this.convertedList;
        Object r105 = new ConvertedImage(r100);
    L17:
        r104.add(r105);
        goto L3
    L14:
        am3.h.e(r100);
        goto L3
    L16:
        r104 = this.convertedImages;
        r105 = x.a(r100);
        goto L17
    L21:
        r100.d(r101);
        if (this.originalImage != null) goto L25;
        this.originalImage = null;
    L25:
        if (this.originalDigest != null) goto L28;
        this.originalDigest = UUID.randomUUID().toString();
    L28:
        if ((r102 & true) == true) goto L31;
        this.isUpRight = false;
    L31:
        if (this.convertedImages.isEmpty() == false) goto L34;
        this.convertedImages = CollectionsKt.emptyList();
    L34:
        if (this.convertedList.isEmpty() == false) goto L53;
        this.convertedList = CollectionsKt.emptyList();
        return;
    }

    public final void setConvertedImages(List<? extends ImageModel> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.convertedImages = r100;
    }

    public final void setConvertedList(List<ConvertedImage> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.convertedList = r100;
    }

    public final void setOriginalDigest(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.originalDigest = r100;
    }

    public final void setOriginalImage(ImageModel r100) {
        this.originalImage = r100;
    }

    public final void setUpRight(boolean r100) {
        this.isUpRight = r100;
    }

    public /* synthetic */ VirtualLiveBgImages(ImageModel r100, String r101, boolean r102, List r103, List r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r101 = UUID.randomUUID().toString();
    L8:
        String r111 = r101;
        if ((r105 & 4) == 0) goto L11;
        boolean r106 = false;
    L13:
        if ((r105 & 8) == 0) goto L15;
        r103 = CollectionsKt.emptyList();
    L15:
        List r107 = r103;
        if ((r105 & 16) == 0) goto L18;
        r104 = CollectionsKt.emptyList();
    L18:
        List r108 = r104;
        this(r100, r111, r106, r107, r108);
        return;
    L11:
        r106 = r102;
        goto L13
    }
}
