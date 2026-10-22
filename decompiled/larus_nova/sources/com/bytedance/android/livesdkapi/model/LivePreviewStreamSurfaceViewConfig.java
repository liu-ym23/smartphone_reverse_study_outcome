package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LivePreviewStreamSurfaceViewConfig;", "", "()V", "mSurfaceRenderAudio", "", "getMSurfaceRenderAudio", "()Z", "setMSurfaceRenderAudio", "(Z)V", "mSurfaceRenderCommon", "getMSurfaceRenderCommon", "setMSurfaceRenderCommon", "mSurfaceRenderMedia", "getMSurfaceRenderMedia", "setMSurfaceRenderMedia", "mSurfaceRenderOther", "getMSurfaceRenderOther", "setMSurfaceRenderOther", "mSurfaceRenderScene", "", "", "getMSurfaceRenderScene", "()Ljava/util/List;", "setMSurfaceRenderScene", "(Ljava/util/List;)V", "mSurfaceRenderVR", "getMSurfaceRenderVR", "setMSurfaceRenderVR", "mSurfaceRenderVS", "getMSurfaceRenderVS", "setMSurfaceRenderVS", "previewSurfaceRender", "getPreviewSurfaceRender", "setPreviewSurfaceRender", "translationXOffset", "", "getTranslationXOffset", "()F", "setTranslationXOffset", "(F)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePreviewStreamSurfaceViewConfig {

    @SerializedName("surface_render_audio")
    private boolean mSurfaceRenderAudio;

    @SerializedName("surface_render_common")
    private boolean mSurfaceRenderCommon;

    @SerializedName("surface_render_media")
    private boolean mSurfaceRenderMedia;

    @SerializedName("surface_render_other")
    private boolean mSurfaceRenderOther;

    @SerializedName("surface_render_scene")
    private List<String> mSurfaceRenderScene;

    @SerializedName("surface_render_VR")
    private boolean mSurfaceRenderVR;

    @SerializedName("surface_render_vs")
    private boolean mSurfaceRenderVS;

    @SerializedName("preview_surface_render")
    private boolean previewSurfaceRender;

    @SerializedName("translation_x_offset")
    private float translationXOffset;

    public LivePreviewStreamSurfaceViewConfig() {
        this.mSurfaceRenderVS = true;
        this.mSurfaceRenderVR = true;
        this.mSurfaceRenderCommon = true;
        this.mSurfaceRenderMedia = true;
        this.mSurfaceRenderAudio = true;
        this.mSurfaceRenderOther = true;
        this.translationXOffset = 6.0f;
        this.mSurfaceRenderScene = new ArrayList();
    }

    public final boolean getMSurfaceRenderAudio() {
        return this.mSurfaceRenderAudio;
    }

    public final boolean getMSurfaceRenderCommon() {
        return this.mSurfaceRenderCommon;
    }

    public final boolean getMSurfaceRenderMedia() {
        return this.mSurfaceRenderMedia;
    }

    public final boolean getMSurfaceRenderOther() {
        return this.mSurfaceRenderOther;
    }

    public final List<String> getMSurfaceRenderScene() {
        return this.mSurfaceRenderScene;
    }

    public final boolean getMSurfaceRenderVR() {
        return this.mSurfaceRenderVR;
    }

    public final boolean getMSurfaceRenderVS() {
        return this.mSurfaceRenderVS;
    }

    public final boolean getPreviewSurfaceRender() {
        return this.previewSurfaceRender;
    }

    public final float getTranslationXOffset() {
        return this.translationXOffset;
    }

    public final void setMSurfaceRenderAudio(boolean r100) {
        this.mSurfaceRenderAudio = r100;
    }

    public final void setMSurfaceRenderCommon(boolean r100) {
        this.mSurfaceRenderCommon = r100;
    }

    public final void setMSurfaceRenderMedia(boolean r100) {
        this.mSurfaceRenderMedia = r100;
    }

    public final void setMSurfaceRenderOther(boolean r100) {
        this.mSurfaceRenderOther = r100;
    }

    public final void setMSurfaceRenderScene(List<String> r100) {
        this.mSurfaceRenderScene = r100;
    }

    public final void setMSurfaceRenderVR(boolean r100) {
        this.mSurfaceRenderVR = r100;
    }

    public final void setMSurfaceRenderVS(boolean r100) {
        this.mSurfaceRenderVS = r100;
    }

    public final void setPreviewSurfaceRender(boolean r100) {
        this.previewSurfaceRender = r100;
    }

    public final void setTranslationXOffset(float r100) {
        this.translationXOffset = r100;
    }
}
