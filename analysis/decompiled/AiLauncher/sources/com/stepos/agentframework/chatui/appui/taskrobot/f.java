package com.stepos.agentframework.chatui.appui.taskrobot;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 92\u00020\u00012\u00020\u0002:\u0002:;B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\rH\u0014¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u001cH\u0016¢\u0006\u0004\b'\u0010#J/\u0010,\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0014¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\rH\u0002¢\u0006\u0004\b.\u0010%R\u0014\u00100\u001a\u00020/8\u0002X\u0082D¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0018\u00107\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/taskrobot/f;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "width", "height", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(II)V", "Lcom/stepos/agentframework/chatui/appui/taskrobot/f$b;", "callback", "setSurfaceCallback", "(Lcom/stepos/agentframework/chatui/appui/taskrobot/f$b;)V", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "onSurfaceTextureAvailable", "(Landroid/graphics/SurfaceTexture;II)V", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "(Landroid/graphics/SurfaceTexture;)Z", "onSurfaceTextureUpdated", "(Landroid/graphics/SurfaceTexture;)V", "hasWindowFocus", "onWindowFocusChanged", "(Z)V", "onAttachedToWindow", "()V", "isVisible", "onVisibilityAggregated", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "f", "", "tagName", "Ljava/lang/String;", "surface", "Landroid/view/Surface;", "targetWidth", "I", "targetHeight", "surfaceCallback", "Lcom/stepos/agentframework/chatui/appui/taskrobot/f$b;", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class f extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicInteger liveSurfaces = new AtomicInteger(0);
    private Surface surface;
    private b surfaceCallback;
    private final String tagName;
    private int targetHeight;
    private int targetWidth;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/taskrobot/f$a;", "", "<init>", "()V", "Ljava/util/concurrent/atomic/AtomicInteger;", "liveSurfaces", "Ljava/util/concurrent/atomic/AtomicInteger;", Const.INTENT_KEY_APIKEY, "()Ljava/util/concurrent/atomic/AtomicInteger;", "getLiveSurfaces$annotations", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.appui.taskrobot.f$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AtomicInteger a() {
            return f.liveSurfaces;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/taskrobot/f$b;", "", "Landroid/view/Surface;", "surface", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/Surface;)V", Const.INTENT_KEY_APIKEY, "()V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface b {
        void a();

        void b(Surface surface);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.tagName = "CustomTextureView";
        setSurfaceTextureListener(this);
        setKeepScreenOn(true);
        setOpaque(true);
    }

    public static final int e(int i10) {
        if (i10 > 0) {
            return i10 - 1;
        }
        return 0;
    }

    public static final void g(f fVar) {
        SurfaceTexture surfaceTexture = fVar.getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(fVar.targetWidth, fVar.targetHeight);
        }
        fVar.requestLayout();
        fVar.invalidate();
    }

    public static final AtomicInteger getLiveSurfaces() {
        return INSTANCE.a();
    }

    public static final void h(f fVar) {
        SurfaceTexture surfaceTexture = fVar.getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(fVar.targetWidth, fVar.targetHeight);
        }
        fVar.invalidate();
    }

    public final void f() {
        if (!isAttachedToWindow() || this.targetWidth <= 0 || this.targetHeight <= 0) {
            return;
        }
        setTransform(new Matrix());
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(this.targetWidth, this.targetHeight);
        }
        requestLayout();
        invalidate();
        post(new Runnable() { // from class: com.stepos.agentframework.chatui.appui.taskrobot.c
            @Override // java.lang.Runnable
            public final void run() {
                f.g(this.f22846a);
            }
        });
        postDelayed(new Runnable() { // from class: com.stepos.agentframework.chatui.appui.taskrobot.d
            @Override // java.lang.Runnable
            public final void run() {
                f.h(this.f22847a);
            }
        }, 120L);
    }

    public final Surface getSurface() {
        return this.surface;
    }

    public final void i(int width, int height) {
        this.targetWidth = width;
        this.targetHeight = height;
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(width, height);
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f();
    }

    @Override // android.view.TextureView, android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        if (w10 <= 0 || h10 <= 0) {
            return;
        }
        if (w10 == oldw && h10 == oldh) {
            return;
        }
        f();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
        b bVar;
        int i10;
        kotlin.jvm.internal.p.i(surfaceTexture, "surfaceTexture");
        C4148a.k(this.tagName, "onSurfaceTextureAvailable w:" + width + " h:" + height, false, 4, null);
        int i11 = this.targetWidth;
        if (i11 > 0 && (i10 = this.targetHeight) > 0) {
            surfaceTexture.setDefaultBufferSize(i11, i10);
        }
        this.surface = new Surface(surfaceTexture);
        liveSurfaces.incrementAndGet();
        Surface surface = this.surface;
        if (surface == null || (bVar = this.surfaceCallback) == null) {
            return;
        }
        bVar.b(surface);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        kotlin.jvm.internal.p.i(surfaceTexture, "surfaceTexture");
        C4148a.k(this.tagName, "onSurfaceTextureDestroyed", false, 4, null);
        b bVar = this.surfaceCallback;
        if (bVar != null) {
            bVar.a();
        }
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
        }
        this.surface = null;
        liveSurfaces.updateAndGet(new IntUnaryOperator() { // from class: com.stepos.agentframework.chatui.appui.taskrobot.e
            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i10) {
                return f.e(i10);
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int width, int height) {
        int i10;
        kotlin.jvm.internal.p.i(surfaceTexture, "surfaceTexture");
        C4148a.k(this.tagName, "onSurfaceTextureSizeChanged w:" + width + " h:" + height, false, 4, null);
        int i11 = this.targetWidth;
        if (i11 <= 0 || (i10 = this.targetHeight) <= 0) {
            return;
        }
        surfaceTexture.setDefaultBufferSize(i11, i10);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        kotlin.jvm.internal.p.i(surfaceTexture, "surfaceTexture");
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean isVisible) {
        super.onVisibilityAggregated(isVisible);
        if (isVisible) {
            f();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus) {
            f();
        }
    }

    public final void setSurfaceCallback(b callback) {
        kotlin.jvm.internal.p.i(callback, "callback");
        this.surfaceCallback = callback;
    }

    public /* synthetic */ f(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
