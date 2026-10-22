package com.bytedance.android.livesdkapi.depend.model.broadcast;

import android.view.Surface;
import android.view.SurfaceView;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.texturerender.VideoSurfaceTexture;
import java.nio.ByteBuffer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\f\rJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u000bH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILiveCoreYuvExtraCameraListener;", "", "onLiveCoreSurfaceDestroy", "", "onReverseCamera", "cameraPosition", "", "registerOnFrameListener", "listener", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILiveCoreYuvExtraCameraListener$OnFrameListener;", "registerOnSurfaceSizeChange", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILiveCoreYuvExtraCameraListener$ExtraCameraListener;", "ExtraCameraListener", "OnFrameListener", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveCoreYuvExtraCameraListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILiveCoreYuvExtraCameraListener$ExtraCameraListener;", "", "onCreateSurface", "Landroid/view/Surface;", "onRenderViewChange", "", "renderView", "Landroid/view/SurfaceView;", "onShowingChange", "showing", "", WidgetCostModule.TYPE_ON_START, "previewStrategy", "", "surface", "onStop", "onSurfaceSizeChange", "location", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface ExtraCameraListener {
        Surface onCreateSurface();

        void onRenderViewChange(SurfaceView r100);

        void onShowingChange(boolean r100);

        void onStart(int r100, Surface r101);

        void onStop();

        void onSurfaceSizeChange(int[] r100);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILiveCoreYuvExtraCameraListener$OnFrameListener;", "", "onFrame", "", "width", "", "height", "rotation", VideoSurfaceTexture.KEY_TIME, "", "buffer", "Ljava/nio/ByteBuffer;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface OnFrameListener {
        void onFrame(int r100, int r101, int r102, long r103, ByteBuffer r104);
    }

    void onLiveCoreSurfaceDestroy();

    void onReverseCamera(int r100);

    void registerOnFrameListener(OnFrameListener r100);

    void registerOnSurfaceSizeChange(ExtraCameraListener r100);
}
