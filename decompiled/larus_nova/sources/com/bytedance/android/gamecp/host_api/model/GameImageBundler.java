package com.bytedance.android.gamecp.host_api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.data.GameImageBundler")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "", "()V", "originImage", "Lcom/bytedance/android/gamecp/host_api/model/ImageModel;", "getOriginImage", "()Lcom/bytedance/android/gamecp/host_api/model/ImageModel;", "setOriginImage", "(Lcom/bytedance/android/gamecp/host_api/model/ImageModel;)V", "thumbHeifImage", "getThumbHeifImage", "setThumbHeifImage", "thumbImage", "getThumbImage", "setThumbImage", "getOriginImageUrl", "", "getThumbHeifImageUrl", "getThumbImageUrl", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameImageBundler implements vh7.h {

    @SerializedName("origin_image")
    protected ImageModel originImage;

    @SerializedName("thumb_heif_image")
    protected ImageModel thumbHeifImage;

    @SerializedName("thumb_image")
    protected ImageModel thumbImage;

    public GameImageBundler() {
    }

    public GameImageBundler(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.originImage = new ImageModel(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.thumbImage = new ImageModel(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.thumbHeifImage = new ImageModel(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final String getOriginImageUrl() {
        ImageModel r100 = this.originImage;
        if (r100 == null) goto L16;
        List<String> r101 = r100.getUrls();
        if (r101 != null) goto L7;
        return "";
    L7:
        if ((!r101.isEmpty()) == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L18;
        String r102 = (String) ListProtector.get(r101, 0);
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    L18:
        return "";
    L16:
        return "";
    }

    public final String getThumbHeifImageUrl() {
        ImageModel r100 = this.thumbHeifImage;
        if (r100 == null) goto L16;
        List<String> r101 = r100.getUrls();
        if (r101 != null) goto L7;
        return "";
    L7:
        if ((!r101.isEmpty()) == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L18;
        String r102 = (String) ListProtector.get(r101, 0);
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    L18:
        return "";
    L16:
        return "";
    }

    public final String getThumbImageUrl() {
        ImageModel r100 = this.thumbImage;
        if (r100 == null) goto L16;
        List<String> r101 = r100.getUrls();
        if (r101 != null) goto L7;
        return "";
    L7:
        if ((!r101.isEmpty()) == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L18;
        String r102 = (String) ListProtector.get(r101, 0);
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    L18:
        return "";
    L16:
        return "";
    }

    public final ImageModel getOriginImage() {
        return this.originImage;
    }

    public final ImageModel getThumbHeifImage() {
        return this.thumbHeifImage;
    }

    public final ImageModel getThumbImage() {
        return this.thumbImage;
    }

    public final void setOriginImage(ImageModel r100) {
        this.originImage = r100;
    }

    public final void setThumbHeifImage(ImageModel r100) {
        this.thumbHeifImage = r100;
    }

    public final void setThumbImage(ImageModel r100) {
        this.thumbImage = r100;
    }
}
