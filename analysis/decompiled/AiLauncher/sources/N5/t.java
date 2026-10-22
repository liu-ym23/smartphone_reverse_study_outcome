package N5;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0003J\r\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006,"}, d2 = {"LN5/t;", "", "<init>", "()V", "", "width", "height", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(II)Z", "Landroid/content/Context;", "context", "Landroid/graphics/Bitmap;", "bitmap", "p", "(Landroid/content/Context;Landroid/graphics/Bitmap;)Z", "LY8/t;", "o", "k", "f", "recycleBitmap", "l", "(Z)V", "", "DURATION_MS", "J", "REVEAL_DELAY_MS", "Landroid/os/Handler;", "mainHandler$delegate", "LY8/h;", "m", "()Landroid/os/Handler;", "mainHandler", "Landroid/view/WindowManager;", "windowManager", "Landroid/view/WindowManager;", "Landroid/widget/ImageView;", "overlayView", "Landroid/widget/ImageView;", "snapshot", "Landroid/graphics/Bitmap;", "Ljava/lang/Runnable;", "slideRunnable", "Ljava/lang/Runnable;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class t {
    public static final long DURATION_MS = 500;
    public static final long REVEAL_DELAY_MS = 80;
    private static ImageView overlayView;
    private static Bitmap snapshot;
    private static WindowManager windowManager;
    public static final t INSTANCE = new t();

    /* renamed from: mainHandler$delegate, reason: from kotlin metadata */
    private static final Y8.h mainHandler = C4848b.b(new InterfaceC5063a() { // from class: N5.o
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return t.n();
        }
    });
    private static final Runnable slideRunnable = new Runnable() { // from class: N5.p
        @Override // java.lang.Runnable
        public final void run() {
            t.q();
        }
    };

    public static final Y8.t g(ImageView imageView) {
        if (overlayView == imageView && imageView.isAttachedToWindow()) {
            Integer numValueOf = Integer.valueOf(imageView.getWidth());
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            int iIntValue = numValueOf != null ? numValueOf.intValue() : imageView.getResources().getDisplayMetrics().widthPixels;
            imageView.animate().cancel();
            imageView.animate().translationX(-iIntValue).setDuration(500L).setInterpolator(AnimationUtils.loadInterpolator(imageView.getContext(), R.interpolator.decelerate_quint)).withEndAction(new Runnable() { // from class: N5.s
                @Override // java.lang.Runnable
                public final void run() {
                    t.h();
                }
            }).start();
            R5.b.INSTANCE.c("view.slideOverlay.out", Y8.j.a("width", Integer.valueOf(iIntValue)));
        }
        return Y8.t.f7040a;
    }

    public static final void h() {
        INSTANCE.l(true);
    }

    public static final void i(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    public static final Handler n() {
        return new Handler(Looper.getMainLooper());
    }

    public static final void q() {
        INSTANCE.f();
    }

    public final void f() {
        final ImageView imageView = overlayView;
        if (imageView == null) {
            return;
        }
        final InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: N5.q
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return t.g(imageView);
            }
        };
        if (imageView.getWidth() > 0) {
            interfaceC5063a.invoke();
        } else {
            imageView.post(new Runnable() { // from class: N5.r
                @Override // java.lang.Runnable
                public final void run() {
                    t.i(interfaceC5063a);
                }
            });
        }
    }

    public final boolean j(int width, int height) {
        return width > 0 && height > 0;
    }

    public final void k() {
        l(true);
    }

    public final void l(boolean recycleBitmap) {
        Y8.t tVar;
        m().removeCallbacks(slideRunnable);
        ImageView imageView = overlayView;
        overlayView = null;
        if (imageView != null) {
            imageView.animate().cancel();
            try {
                Result.Companion companion = Result.INSTANCE;
                WindowManager windowManager2 = windowManager;
                if (windowManager2 != null) {
                    windowManager2.removeViewImmediate(imageView);
                    tVar = Y8.t.f7040a;
                } else {
                    tVar = null;
                }
                Result.b(tVar);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        windowManager = null;
        Bitmap bitmap = snapshot;
        snapshot = null;
        if (!recycleBitmap || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public final Handler m() {
        return (Handler) mainHandler.getValue();
    }

    public final void o() {
        if (overlayView == null) {
            return;
        }
        Handler handlerM = m();
        Runnable runnable = slideRunnable;
        handlerM.removeCallbacks(runnable);
        m().postDelayed(runnable, 80L);
    }

    public final boolean p(Context context, Bitmap bitmap) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        if (bitmap == null || bitmap.isRecycled() || !j(bitmap.getWidth(), bitmap.getHeight())) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        if (!Settings.canDrawOverlays(applicationContext)) {
            R5.b.INSTANCE.h("view.slideOverlay.noPerm", new Pair[0]);
            return false;
        }
        WindowManager windowManager2 = (WindowManager) applicationContext.getSystemService(WindowManager.class);
        if (windowManager2 == null) {
            return false;
        }
        l(true);
        ImageView imageView = new ImageView(applicationContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageBitmap(bitmap);
        imageView.setBackgroundColor(-16777216);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2038;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 8388659;
        layoutParams.format = -3;
        layoutParams.flags = 776;
        layoutParams.layoutInDisplayCutoutMode = 1;
        layoutParams.setTitle("CardOpenSlideOverlay");
        try {
            Result.Companion companion = Result.INSTANCE;
            windowManager2.addView(imageView, layoutParams);
            windowManager = windowManager2;
            overlayView = imageView;
            snapshot = bitmap;
            R5.b.INSTANCE.c("view.slideOverlay.show", Y8.j.a("w", Integer.valueOf(bitmap.getWidth())), Y8.j.a(Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Integer.valueOf(bitmap.getHeight())));
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("view.slideOverlay.add.fail", Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }
}
