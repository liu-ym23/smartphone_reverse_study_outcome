package v7;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\rH\u0002¢\u0006\u0004\b%\u0010&R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010'R\u0016\u0010*\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010,R\u0016\u00100\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00102R\u0016\u00108\u001a\u0004\u0018\u00010+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010;\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010=\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010:¨\u0006>"}, d2 = {"Lv7/D;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lv7/c;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/view/View;", Const.INTENT_KEY_PKGNAME, "()Landroid/view/View;", "Landroid/view/ViewGroup;", "parent", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/ViewGroup;)V", "", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "setRenderScale", "(F)V", "Lkotlin/Function0;", "callback", "setOnReady", "(Lp9/a;)V", "Landroid/graphics/SurfaceTexture;", "st", "", "width", "height", "onSurfaceTextureAvailable", "(Landroid/graphics/SurfaceTexture;II)V", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "(Landroid/graphics/SurfaceTexture;)Z", "onSurfaceTextureUpdated", "(Landroid/graphics/SurfaceTexture;)V", "c", "()V", "Lp9/a;", "onReady", "Z", "ready", "Landroid/view/Surface;", "Landroid/view/Surface;", "cachedSurface", Const.INTENT_KEY_UMID, "F", "pendingScale", "e", "I", "bufferWidth", "f", "bufferHeight", "getSurface", "()Landroid/view/Surface;", "surface", "getRenderWidth", "()I", "renderWidth", "getRenderHeight", "renderHeight", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class D extends TextureView implements TextureView.SurfaceTextureListener, InterfaceC5666c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public InterfaceC5063a<Y8.t> onReady;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean ready;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Surface cachedSurface;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public float pendingScale;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int bufferWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int bufferHeight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(Context context) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        this.pendingScale = 1.0f;
        setOpaque(false);
        setSurfaceTextureListener(this);
    }

    @Override // v7.InterfaceC5666c
    public void a(ViewGroup parent) {
        kotlin.jvm.internal.p.i(parent, "parent");
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        parent.addView(this);
    }

    @Override // v7.InterfaceC5666c
    public View b() {
        return this;
    }

    public final void c() {
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture == null) {
            return;
        }
        this.bufferWidth = C5685n.f((int) (getResources().getDisplayMetrics().widthPixels * this.pendingScale), 1);
        int iF = C5685n.f((int) (getResources().getDisplayMetrics().heightPixels * this.pendingScale), 1);
        this.bufferHeight = iF;
        surfaceTexture.setDefaultBufferSize(this.bufferWidth, iF);
    }

    @Override // v7.i
    /* renamed from: getRenderHeight, reason: from getter */
    public int getBufferHeight() {
        return this.bufferHeight;
    }

    @Override // v7.i
    /* renamed from: getRenderWidth, reason: from getter */
    public int getBufferWidth() {
        return this.bufferWidth;
    }

    @Override // v7.i
    public Surface getSurface() {
        Surface surface = this.cachedSurface;
        if (surface == null || !surface.isValid()) {
            return null;
        }
        return surface;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture st, int width, int height) {
        kotlin.jvm.internal.p.i(st, "st");
        c();
        this.cachedSurface = new Surface(st);
        this.ready = true;
        InterfaceC5063a<Y8.t> interfaceC5063a = this.onReady;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        this.onReady = null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture st) {
        kotlin.jvm.internal.p.i(st, "st");
        this.ready = false;
        Surface surface = this.cachedSurface;
        if (surface != null) {
            surface.release();
        }
        this.cachedSurface = null;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture st, int width, int height) {
        kotlin.jvm.internal.p.i(st, "st");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture st) {
        kotlin.jvm.internal.p.i(st, "st");
    }

    @Override // v7.InterfaceC5666c
    public void setOnReady(InterfaceC5063a<Y8.t> callback) {
        kotlin.jvm.internal.p.i(callback, "callback");
        if (this.ready) {
            callback.invoke();
        } else {
            this.onReady = callback;
        }
    }

    @Override // v7.InterfaceC5666c
    public void setRenderScale(float scale) {
        this.pendingScale = scale;
        c();
    }
}
