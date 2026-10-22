package com.bytedance.android.livesdkapi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.SubInfo;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/view/KeepSurfaceControlRenderView;", "Lcom/bytedance/android/livesdkapi/view/SurfaceRenderView;", "Landroid/view/SurfaceHolder$Callback;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", SubInfo.KEY_FORMAT, "width", "height", "surfaceCreated", "surfaceDestroyed", "CustomSurfaceHolder", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class KeepSurfaceControlRenderView extends SurfaceRenderView implements SurfaceHolder.Callback {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u000bH\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u001aH\u0016J\u0012\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdkapi/view/KeepSurfaceControlRenderView$CustomSurfaceHolder;", "Landroid/view/SurfaceHolder;", "surfaceHolder", "surfaceView", "Lcom/bytedance/android/livesdkapi/view/SurfaceRenderView;", "(Landroid/view/SurfaceHolder;Lcom/bytedance/android/livesdkapi/view/SurfaceRenderView;)V", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "getSurfaceView", "()Lcom/bytedance/android/livesdkapi/view/SurfaceRenderView;", "addCallback", "", "callback", "Landroid/view/SurfaceHolder$Callback;", "getSurface", "Landroid/view/Surface;", "getSurfaceFrame", "Landroid/graphics/Rect;", "isCreating", "", "lockCanvas", "Landroid/graphics/Canvas;", "dirty", "removeCallback", "setFixedSize", "width", "", "height", "setFormat", SubInfo.KEY_FORMAT, "setKeepScreenOn", "screenOn", "setSizeFromLayout", "setType", "type", "unlockCanvasAndPost", "canvas", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CustomSurfaceHolder implements SurfaceHolder {
        private final SurfaceHolder surfaceHolder;
        private final SurfaceRenderView surfaceView;

        @Override // android.view.SurfaceHolder
        public Surface getSurface() {
            return this.surfaceHolder.getSurface();
        }

        @Override // android.view.SurfaceHolder
        public Rect getSurfaceFrame() {
            return this.surfaceHolder.getSurfaceFrame();
        }

        @Override // android.view.SurfaceHolder
        public boolean isCreating() {
            return this.surfaceHolder.isCreating();
        }

        @Override // android.view.SurfaceHolder
        public Canvas lockCanvas() {
            return this.surfaceHolder.lockCanvas();
        }

        @Override // android.view.SurfaceHolder
        public void setSizeFromLayout() {
            this.surfaceHolder.setSizeFromLayout();
        }

        public final SurfaceHolder getSurfaceHolder() {
            return this.surfaceHolder;
        }

        public final SurfaceRenderView getSurfaceView() {
            return this.surfaceView;
        }

        @Override // android.view.SurfaceHolder
        public void addCallback(SurfaceHolder.Callback r100) {
            this.surfaceHolder.addCallback(r100);
        }

        @Override // android.view.SurfaceHolder
        public Canvas lockCanvas(Rect r100) {
            return this.surfaceHolder.lockCanvas(r100);
        }

        @Override // android.view.SurfaceHolder
        public void removeCallback(SurfaceHolder.Callback r100) {
            this.surfaceHolder.removeCallback(r100);
        }

        @Override // android.view.SurfaceHolder
        public void setFormat(int r100) {
            this.surfaceHolder.setFormat(r100);
        }

        @Override // android.view.SurfaceHolder
        public void setKeepScreenOn(boolean r100) {
            this.surfaceHolder.setKeepScreenOn(r100);
        }

        @Override // android.view.SurfaceHolder
        public void setType(int r100) {
            this.surfaceHolder.setType(r100);
        }

        @Override // android.view.SurfaceHolder
        public void unlockCanvasAndPost(Canvas r100) {
            this.surfaceHolder.unlockCanvasAndPost(r100);
        }

        public CustomSurfaceHolder(SurfaceHolder r100, SurfaceRenderView r101) {
            Intrinsics.checkNotNullParameter(r100, "surfaceHolder");
            Intrinsics.checkNotNullParameter(r101, "surfaceView");
            this.surfaceHolder = r100;
            this.surfaceView = r101;
        }

        @Override // android.view.SurfaceHolder
        public void setFixedSize(int r100, int r101) {
            this.surfaceHolder.setFixedSize(r100, r101);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "holder");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
    }

    public KeepSurfaceControlRenderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        Field r101 = SurfaceView.class.getDeclaredField("mSurfaceHolder");     // Catch: Exception -> L5
        r101.setAccessible(true);     // Catch: Exception -> L5
        r101.set(this, new CustomSurfaceHolder(getHolder(), this));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public KeepSurfaceControlRenderView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        Field r102 = SurfaceView.class.getDeclaredField("mSurfaceHolder");     // Catch: Exception -> L5
        r102.setAccessible(true);     // Catch: Exception -> L5
        r102.set(this, new CustomSurfaceHolder(getHolder(), this));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public KeepSurfaceControlRenderView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        Field r103 = SurfaceView.class.getDeclaredField("mSurfaceHolder");     // Catch: Exception -> L5
        r103.setAccessible(true);     // Catch: Exception -> L5
        r103.set(this, new CustomSurfaceHolder(getHolder(), this));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }
}
