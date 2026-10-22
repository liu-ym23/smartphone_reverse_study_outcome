package com.bytedance.android.livesdkapi.depend.model.broadcast;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.View;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.texturerender.VideoSurfaceTexture;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0003\u0019\u001a\u001bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0003H&J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\nH&¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILiveCoreExtraCameraListener;", "", "getCameraType", "", "getFrameRotation", "onLiveCoreSurfaceDestroy", "", "reason", "", "isClosing", "", "onLiveTextureViewReady", "onReverseCamera", "cameraPosition", "processAlgorithm", "texID", "matrix", "", "registerOnFrameListener", "listener", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILiveCoreExtraCameraListener$OnFrameListener;", "registerOnSurfaceSizeChange", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILiveCoreExtraCameraListener$ExtraCameraListener;", "setNeedAddSurfaceWhenResume", "enable", "ExtraCameraListener", "OnFrameListener", "SurfaceInfo", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveCoreExtraCameraListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\rH&J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H&J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019H&¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILiveCoreExtraCameraListener$ExtraCameraListener;", "", "getPreviewFps", "", "getSurfaceView", "Landroid/view/View;", "getTouchEventDelegate", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILivePreviewTouchEventDelegate;", "onCreateSurface", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILiveCoreExtraCameraListener$SurfaceInfo;", "rotation", "", "onRenderViewChange", "", "renderView", "onShowLiveLayout", "onShowingChange", "showing", "", WidgetCostModule.TYPE_ON_START, "shareSurfaceView", "surface", "Landroid/view/Surface;", "onStop", "reason", "", "isClosing", "onSurfaceSizeChange", "location", "", "sendCameraPipelineLog", "type", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface ExtraCameraListener {
        float getPreviewFps();

        View getSurfaceView();

        ILivePreviewTouchEventDelegate getTouchEventDelegate();

        SurfaceInfo onCreateSurface(int r100);

        void onRenderViewChange(View r100);

        void onShowLiveLayout();

        void onShowingChange(boolean r100);

        void onStart(boolean r100, Surface r101);

        void onStop(String r100, boolean r101);

        void onSurfaceSizeChange(int[] r100);

        void sendCameraPipelineLog(String r100, String r101);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILiveCoreExtraCameraListener$OnFrameListener;", "", "onFrame", "", "width", "", "height", "rotation", VideoSurfaceTexture.KEY_TIME, "", "buffer", "Ljava/nio/ByteBuffer;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface OnFrameListener {
        void onFrame(int r100, int r101, int r102, long r103, ByteBuffer r104);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILiveCoreExtraCameraListener$SurfaceInfo;", "", "oesTex", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "(ILandroid/view/Surface;Landroid/graphics/SurfaceTexture;)V", "getOesTex", "()I", "getSurface", "()Landroid/view/Surface;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SurfaceInfo {
        private final int oesTex;
        private final Surface surface;
        private final SurfaceTexture surfaceTexture;

        public static /* synthetic */ SurfaceInfo copy$default(SurfaceInfo r100, int r101, Surface r102, SurfaceTexture r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.oesTex;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.surface;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.surfaceTexture;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final int component1() {
            return this.oesTex;
        }

        public final Surface component2() {
            return this.surface;
        }

        public final SurfaceTexture component3() {
            return this.surfaceTexture;
        }

        public final SurfaceInfo copy(int r100, Surface r101, SurfaceTexture r102) {
            Intrinsics.checkNotNullParameter(r101, "surface");
            return new SurfaceInfo(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof SurfaceInfo) == false) goto L12;
            SurfaceInfo r101 = (SurfaceInfo) r100;
            if (this.oesTex == r101.oesTex) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.surface, r101.surface) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.surfaceTexture, r101.surfaceTexture) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            int r100 = this.oesTex * 31;
            Surface r101 = this.surface;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            SurfaceTexture r105 = this.surfaceTexture;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            return r104 + r102;
        L5:
            r103 = 0;
            goto L6
        }

        public String toString() {
            return "SurfaceInfo(oesTex=" + this.oesTex + ", surface=" + this.surface + ", surfaceTexture=" + this.surfaceTexture + ")";
        }

        public final int getOesTex() {
            return this.oesTex;
        }

        public final Surface getSurface() {
            return this.surface;
        }

        public final SurfaceTexture getSurfaceTexture() {
            return this.surfaceTexture;
        }

        public SurfaceInfo(int r100, Surface r101, SurfaceTexture r102) {
            Intrinsics.checkNotNullParameter(r101, "surface");
            this.oesTex = r100;
            this.surface = r101;
            this.surfaceTexture = r102;
        }
    }

    int getCameraType();

    int getFrameRotation();

    void onLiveCoreSurfaceDestroy(String r100, boolean r101);

    void onLiveTextureViewReady();

    void onReverseCamera(int r100);

    int processAlgorithm(int r100, float[] r101);

    void registerOnFrameListener(OnFrameListener r100);

    void registerOnSurfaceSizeChange(ExtraCameraListener r100);

    void setNeedAddSurfaceWhenResume(boolean r100);
}
