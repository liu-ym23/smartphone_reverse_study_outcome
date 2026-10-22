package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import androidx.camera.video.AudioStats;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.PicoInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010,\u001a\u00020-R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PicoInfo;", "", "picoLiveType", "", "picoVirtualLiveBgImageUri", "", "picoCreateScene", "customInfo", "picoVirtualLiveBgImageDigest", "virtualLiveBgImages", "Lcom/bytedance/android/livesdkapi/depend/model/live/VirtualLiveBgImages;", TextureRenderKeys.KEY_IS_PITCH, "", "clientLiveType", "isInPreview", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/livesdkapi/depend/model/live/VirtualLiveBgImages;DIZ)V", "getClientLiveType", "()I", "setClientLiveType", "(I)V", "getCustomInfo", "()Ljava/lang/String;", "setCustomInfo", "(Ljava/lang/String;)V", "()Z", "setInPreview", "(Z)V", "getPicoCreateScene", "setPicoCreateScene", "getPicoLiveType", "setPicoLiveType", "getPicoVirtualLiveBgImageDigest", "setPicoVirtualLiveBgImageDigest", "getPicoVirtualLiveBgImageUri", "setPicoVirtualLiveBgImageUri", "getPitch", "()D", "setPitch", "(D)V", "getVirtualLiveBgImages", "()Lcom/bytedance/android/livesdkapi/depend/model/live/VirtualLiveBgImages;", "setVirtualLiveBgImages", "(Lcom/bytedance/android/livesdkapi/depend/model/live/VirtualLiveBgImages;)V", "toJsonObj", "Lorg/json/JSONObject;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PicoInfo implements h {

    @SerializedName("client_live_type")
    protected int clientLiveType;

    @SerializedName("custom_info")
    protected String customInfo;
    private boolean isInPreview;

    @SerializedName("pico_create_scene")
    protected String picoCreateScene;

    @SerializedName("pico_live_type")
    protected int picoLiveType;

    @SerializedName("pico_virtual_live_bg_image_digest")
    protected String picoVirtualLiveBgImageDigest;

    @SerializedName("pico_virtual_live_bg_image_uri")
    protected String picoVirtualLiveBgImageUri;

    @SerializedName(TextureRenderKeys.KEY_IS_PITCH)
    protected double pitch;

    @SerializedName("virtual_live_bg_images")
    protected VirtualLiveBgImages virtualLiveBgImages;

    public PicoInfo(int r100, String r101, String r102, String r103, String r104, VirtualLiveBgImages r105, double r106, int r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r101, "picoVirtualLiveBgImageUri");
        Intrinsics.checkNotNullParameter(r102, "picoCreateScene");
        Intrinsics.checkNotNullParameter(r103, "customInfo");
        Intrinsics.checkNotNullParameter(r104, "picoVirtualLiveBgImageDigest");
        this.picoLiveType = r100;
        this.picoVirtualLiveBgImageUri = r101;
        this.picoCreateScene = r102;
        this.customInfo = r103;
        this.picoVirtualLiveBgImageDigest = r104;
        this.virtualLiveBgImages = r105;
        this.pitch = r106;
        this.clientLiveType = r110;
        this.isInPreview = r111;
    }

    public final JSONObject toJsonObj() {
        JSONObject r100 = new JSONObject();
        r100.put("pico_live_type", this.picoLiveType);
        r100.put("pico_virtual_live_bg_image_uri", this.picoVirtualLiveBgImageUri);
        r100.put("pico_create_scene", this.picoCreateScene);
        r100.put("custom_info", this.customInfo);
        r100.put("pico_virtual_live_bg_image_digest", this.picoVirtualLiveBgImageDigest);
        VirtualLiveBgImages r101 = this.virtualLiveBgImages;
        if (r101 == null) goto L5;
        r100.put("virtual_live_bg_images", r101.toJsonObj());
    L5:
        r100.put(TextureRenderKeys.KEY_IS_PITCH, this.pitch);
        r100.put("client_live_type", this.clientLiveType);
        r100.put("is_in_preview", this.isInPreview);
        return r100;
    }

    public PicoInfo() {
        this.picoLiveType = -1;
        this.picoVirtualLiveBgImageUri = "";
        this.picoCreateScene = "";
        this.customInfo = "";
        this.picoVirtualLiveBgImageDigest = "";
        this.virtualLiveBgImages = null;
        this.pitch = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.clientLiveType = -1;
    }

    public final int getClientLiveType() {
        return this.clientLiveType;
    }

    public final String getCustomInfo() {
        return this.customInfo;
    }

    public final String getPicoCreateScene() {
        return this.picoCreateScene;
    }

    public final int getPicoLiveType() {
        return this.picoLiveType;
    }

    public final String getPicoVirtualLiveBgImageDigest() {
        return this.picoVirtualLiveBgImageDigest;
    }

    public final String getPicoVirtualLiveBgImageUri() {
        return this.picoVirtualLiveBgImageUri;
    }

    public final double getPitch() {
        return this.pitch;
    }

    public final VirtualLiveBgImages getVirtualLiveBgImages() {
        return this.virtualLiveBgImages;
    }

    public final boolean isInPreview() {
        return this.isInPreview;
    }

    public PicoInfo(g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        switch(r103) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.clientLiveType = (int) r100.j();
        r102 = r102 | 4;
        goto L3
    L8:
        this.pitch = Float.intBitsToFloat(r100.g());
        r102 = r102 | 2;
        goto L3
    L9:
        this.virtualLiveBgImages = new VirtualLiveBgImages(r100);
        goto L3
    L10:
        this.picoVirtualLiveBgImageDigest = am3.h.c(r100);
        goto L3
    L11:
        this.customInfo = am3.h.c(r100);
        goto L3
    L12:
        this.picoCreateScene = am3.h.c(r100);
        goto L3
    L13:
        this.picoVirtualLiveBgImageUri = am3.h.c(r100);
        goto L3
    L14:
        this.picoLiveType = (int) r100.j();
        r102 = r102 | 1;
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L19;
        this.picoLiveType = -1;
    L19:
        if (this.picoVirtualLiveBgImageUri != null) goto L22;
        this.picoVirtualLiveBgImageUri = "";
    L22:
        if (this.picoCreateScene != null) goto L25;
        this.picoCreateScene = "";
    L25:
        if (this.customInfo != null) goto L28;
        this.customInfo = "";
    L28:
        if (this.picoVirtualLiveBgImageDigest != null) goto L31;
        this.picoVirtualLiveBgImageDigest = "";
    L31:
        if (this.virtualLiveBgImages != null) goto L34;
        this.virtualLiveBgImages = null;
    L34:
        if ((r102 & 2) != 0) goto L37;
        this.pitch = AudioStats.AUDIO_AMPLITUDE_NONE;
    L37:
        if ((r102 & 4) != 0) goto L60;
        this.clientLiveType = -1;
        return;
    }

    public final void setClientLiveType(int r100) {
        this.clientLiveType = r100;
    }

    public final void setCustomInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.customInfo = r100;
    }

    public final void setInPreview(boolean r100) {
        this.isInPreview = r100;
    }

    public final void setPicoCreateScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.picoCreateScene = r100;
    }

    public final void setPicoLiveType(int r100) {
        this.picoLiveType = r100;
    }

    public final void setPicoVirtualLiveBgImageDigest(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.picoVirtualLiveBgImageDigest = r100;
    }

    public final void setPicoVirtualLiveBgImageUri(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.picoVirtualLiveBgImageUri = r100;
    }

    public final void setPitch(double r100) {
        this.pitch = r100;
    }

    public final void setVirtualLiveBgImages(VirtualLiveBgImages r100) {
        this.virtualLiveBgImages = r100;
    }

    public /* synthetic */ PicoInfo(int r110, String r111, String r112, String r113, String r114, VirtualLiveBgImages r115, double r116, int r210, boolean r211, int r212, DefaultConstructorMarker r213) {
        int r100 = -1;
        if ((r212 & 1) == 0) goto L5;
        int r101 = -1;
    L6:
        String r102 = "";
        if ((r212 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r212 & 16) != 0) goto L23;
        r102 = r114;
    L23:
        if ((r212 & 32) == 0) goto L25;
        VirtualLiveBgImages r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        double r107 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L31:
        if ((r212 & 128) != 0) goto L35;
        r100 = r210;
    L35:
        if ((r212 & 256) == 0) goto L37;
        boolean r108 = false;
    L38:
        this(r101, r103, r104, r105, r102, r106, r107, r100, r108);
        return;
    L37:
        r108 = r211;
        goto L38
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
