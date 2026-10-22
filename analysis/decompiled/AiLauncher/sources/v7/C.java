package v7;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010 \u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\"\u0010\u001bR\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010$R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010&R\u0016\u0010+\u001a\u0004\u0018\u00010(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010-¨\u00061"}, d2 = {"Lv7/C;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback;", "Lv7/c;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/view/View;", Const.INTENT_KEY_PKGNAME, "()Landroid/view/View;", "Landroid/view/ViewGroup;", "parent", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/ViewGroup;)V", "", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "setRenderScale", "(F)V", "Lkotlin/Function0;", "callback", "setOnReady", "(Lp9/a;)V", "Landroid/view/SurfaceHolder;", "holder", "surfaceCreated", "(Landroid/view/SurfaceHolder;)V", "", "format", "width", "height", "surfaceChanged", "(Landroid/view/SurfaceHolder;III)V", "surfaceDestroyed", "", "Z", "surfaceReady", "Lp9/a;", "onReady", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "surface", "getRenderWidth", "()I", "renderWidth", "getRenderHeight", "renderHeight", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class C extends SurfaceView implements SurfaceHolder.Callback, InterfaceC5666c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean surfaceReady;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public InterfaceC5063a<Y8.t> onReady;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(Context context) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        setZOrderOnTop(true);
        getHolder().setFormat(-3);
        getHolder().addCallback(this);
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

    @Override // v7.i
    /* renamed from: getRenderHeight */
    public int getBufferHeight() {
        return getHolder().getSurfaceFrame().height();
    }

    @Override // v7.i
    /* renamed from: getRenderWidth */
    public int getBufferWidth() {
        return getHolder().getSurfaceFrame().width();
    }

    @Override // v7.i
    public Surface getSurface() {
        Surface surface = getHolder().getSurface();
        if (surface == null || !surface.isValid()) {
            return null;
        }
        return surface;
    }

    @Override // v7.InterfaceC5666c
    public void setOnReady(InterfaceC5063a<Y8.t> callback) {
        kotlin.jvm.internal.p.i(callback, "callback");
        if (this.surfaceReady) {
            callback.invoke();
        } else {
            this.onReady = callback;
        }
    }

    @Override // v7.InterfaceC5666c
    public void setRenderScale(float scale) {
        getHolder().setFixedSize(C5685n.f((int) (getResources().getDisplayMetrics().widthPixels * scale), 1), C5685n.f((int) (getResources().getDisplayMetrics().heightPixels * scale), 1));
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        kotlin.jvm.internal.p.i(holder, "holder");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        kotlin.jvm.internal.p.i(holder, "holder");
        this.surfaceReady = true;
        InterfaceC5063a<Y8.t> interfaceC5063a = this.onReady;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        this.onReady = null;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        kotlin.jvm.internal.p.i(holder, "holder");
        this.surfaceReady = false;
    }
}
