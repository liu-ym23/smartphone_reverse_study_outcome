package com.stepos.ailauncher.chat.voice.motionkit;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\b\t*\u00013\b\u0000\u0018\u0000 92\u00020\u0001:\u0001:B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u000eJ\r\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u000eJ\r\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u000eJ\r\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u000eJ\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u000eJ\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u000eJ\u000f\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u000eR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010,R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0011\u00108\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/motionkit/m;", "", "Lkotlin/Function1;", "", "", "get", "<init>", "(Lp9/l;)V", "Landroid/view/ViewGroup;", Parameters.ROOT, "LY8/t;", "f", "(Landroid/view/ViewGroup;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()V", UxipConstants.f30680s, "o", "(F)V", "m", "n", "p", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "l", "e", "Lp9/l;", "Landroid/view/animation/PathInterpolator;", "enterEase", "Landroid/view/animation/PathInterpolator;", "exitEase", "parent", "Landroid/view/ViewGroup;", "Landroid/widget/FrameLayout;", "clip", "Landroid/widget/FrameLayout;", "Landroid/widget/ImageView;", "glow", "Landroid/widget/ImageView;", "Landroid/graphics/Bitmap;", "source", "Landroid/graphics/Bitmap;", "shown", "", "flipped", "Z", "", "playAtMs", "J", Const.JSON_KEY_SPEED, "F", "running", "com/stepos/ailauncher/chat/voice/motionkit/m$b", "tick", "Lcom/stepos/ailauncher/chat/voice/motionkit/m$b;", "k", "()Z", "hasBitmap", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.voice.motionkit.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3073m {
    private static final String ASSET = "motionkit/textures/ai_key_glow.png";
    private FrameLayout clip;
    private final PathInterpolator enterEase;
    private final PathInterpolator exitEase;
    private boolean flipped;
    private final InterfaceC5074l<String, Float> get;
    private ImageView glow;
    private ViewGroup parent;
    private long playAtMs;
    private boolean running;
    private Bitmap shown;
    private Bitmap source;
    private float speed;
    private final b tick;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/voice/motionkit/m$b", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.voice.motionkit.m$b */
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = C3073m.this.glow;
            if (imageView != null && C3073m.this.running) {
                C3073m.this.e();
                imageView.postOnAnimation(this);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3073m(InterfaceC5074l<? super String, Float> get) {
        kotlin.jvm.internal.p.i(get, "get");
        this.get = get;
        this.enterEase = new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);
        this.exitEase = new PathInterpolator(0.3f, 0.0f, 1.0f, 1.0f);
        this.speed = 1.0f;
        this.tick = new b();
    }

    public static final void g(C3073m c3073m) {
        c3073m.l();
    }

    public final void e() {
        FrameLayout frameLayout;
        ImageView imageView;
        ViewGroup viewGroup = this.parent;
        if (viewGroup == null || (frameLayout = this.clip) == null || (imageView = this.glow) == null || viewGroup.getWidth() <= 0) {
            return;
        }
        l();
        float fE = C5685n.e(((SystemClock.elapsedRealtime() - this.playAtMs) / 1000.0f) * this.speed, 0.0f);
        float fE2 = C5685n.e(this.get.invoke("uEnterDur").floatValue(), 0.001f);
        float fE3 = C5685n.e(this.get.invoke("uExitDur").floatValue(), 0.001f);
        float fFloatValue = this.get.invoke("uReleaseAt").floatValue();
        float fFloatValue2 = this.get.invoke("uHoldMs").floatValue();
        if (fFloatValue < 0.0f && fFloatValue2 > 0.5f) {
            fFloatValue = fE2 + (fFloatValue2 * 0.001f);
        }
        float interpolation = this.enterEase.getInterpolation(C5685n.m((fFloatValue >= 0.0f ? Math.min(fE, fFloatValue) : fE) / fE2, 0.0f, 1.0f));
        boolean z10 = this.get.invoke("uSide").floatValue() < 0.5f;
        float fFloatValue3 = this.get.invoke("uEnterX").floatValue();
        float fFloatValue4 = this.get.invoke("uEnterY").floatValue();
        float fFloatValue5 = this.get.invoke("uExitX").floatValue();
        float fFloatValue6 = this.get.invoke("uExitY").floatValue();
        float fAbs = Math.abs(fFloatValue3);
        if (z10) {
            fAbs = -fAbs;
        }
        float fAbs2 = z10 ? -Math.abs(fFloatValue5) : Math.abs(fFloatValue5);
        float f10 = (0.4f * interpolation) + 0.6f;
        float f11 = fAbs + ((0.0f - fAbs) * interpolation);
        float f12 = fFloatValue4 * interpolation;
        if (fFloatValue >= 0.0f && fE > fFloatValue) {
            float interpolation2 = this.exitEase.getInterpolation(C5685n.m((fE - fFloatValue) / fE3, 0.0f, 1.0f));
            interpolation *= 1.0f - interpolation2;
            f10 += (0.6f - f10) * interpolation2;
            f11 += (fAbs2 - f11) * interpolation2;
            f12 += (fFloatValue6 - f12) * interpolation2;
            if (interpolation2 >= 1.0f) {
                this.running = false;
                imageView.setAlpha(0.0f);
                return;
            }
        }
        float f13 = imageView.getResources().getDisplayMetrics().density;
        float fM = C5685n.m(this.get.invoke("uCenterY").floatValue(), 0.05f, 0.95f);
        float fM2 = C5685n.m(this.get.invoke("uIntensity").floatValue(), 0.0f, 3.0f);
        frameLayout.setTranslationX(f11 * f13);
        frameLayout.setTranslationY(((viewGroup.getHeight() * fM) - (frameLayout.getLayoutParams().height / 2.0f)) + (f12 * f13));
        imageView.setTranslationX(0.0f);
        imageView.setScaleX(f10);
        imageView.setScaleY(1.0f);
        imageView.setAlpha(C5685n.m(interpolation * fM2, 0.0f, 1.0f));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0034 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.view.ViewGroup r8) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "root"
            kotlin.jvm.internal.p.i(r8, r0)
            android.view.ViewGroup r0 = r7.parent
            r1 = 0
            if (r0 != r8) goto L1e
            android.widget.FrameLayout r0 = r7.clip
            if (r0 == 0) goto L14
            android.view.ViewParent r0 = r0.getParent()
            goto L15
        L14:
            r0 = r1
        L15:
            if (r0 != r8) goto L1e
            r7.j()
            r7.l()
            return
        L1e:
            r7.i()
            r7.parent = r8
            android.content.Context r0 = r8.getContext()
            android.graphics.Bitmap r2 = r7.source
            if (r2 == 0) goto L34
            kotlin.jvm.internal.p.f(r2)
            boolean r2 = r2.isRecycled()
            if (r2 == 0) goto L59
        L34:
            android.content.res.AssetManager r2 = r0.getAssets()     // Catch: java.lang.Exception -> L46
            java.lang.String r3 = "motionkit/textures/ai_key_glow.png"
            java.io.InputStream r2 = r2.open(r3)     // Catch: java.lang.Exception -> L46
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch: java.lang.Throwable -> L48
            l9.b.a(r2, r1)     // Catch: java.lang.Exception -> L46
            goto L57
        L46:
            r2 = move-exception
            goto L4f
        L48:
            r3 = move-exception
            throw r3     // Catch: java.lang.Throwable -> L4a
        L4a:
            r4 = move-exception
            l9.b.a(r2, r3)     // Catch: java.lang.Exception -> L46
            throw r4     // Catch: java.lang.Exception -> L46
        L4f:
            java.lang.String r3 = "KeyGlow"
            java.lang.String r4 = "load motionkit/textures/ai_key_glow.png failed"
            android.util.Log.e(r3, r4, r2)
            r3 = r1
        L57:
            r7.source = r3
        L59:
            com.stepos.ailauncher.chat.voice.motionkit.C3074n.b(r8)
            android.widget.FrameLayout r2 = new android.widget.FrameLayout
            r2.<init>(r0)
            r3 = 0
            r2.setClipChildren(r3)
            r2.setClipToPadding(r3)
            r4 = 0
            r2.setElevation(r4)
            r5 = 1115684864(0x42800000, float:64.0)
            r2.setTranslationZ(r5)
            r2.setOutlineProvider(r1)
            r2.setClickable(r3)
            r2.setFocusable(r3)
            android.widget.ImageView r5 = new android.widget.ImageView
            r5.<init>(r0)
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.FIT_XY
            r5.setScaleType(r0)
            r0 = 2
            r5.setImportantForAccessibility(r0)
            r5.setClickable(r3)
            r5.setFocusable(r3)
            r5.setAlpha(r4)
            r0 = 1058642330(0x3f19999a, float:0.6)
            r5.setScaleX(r0)
            r0 = 1065353216(0x3f800000, float:1.0)
            r5.setScaleY(r0)
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r4 = -1
            r0.<init>(r4, r4)
            r2.addView(r5, r0)
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r4 = 8388661(0x800035, float:1.1755018E-38)
            r6 = 1
            r0.<init>(r6, r6, r4)
            r8.addView(r2, r0)
            r7.clip = r2
            r7.glow = r5
            r7.shown = r1
            r7.flipped = r3
            r7.j()
            int r0 = r8.getWidth()
            if (r0 <= 0) goto Lc6
            r7.l()
            goto Lce
        Lc6:
            com.stepos.ailauncher.chat.voice.motionkit.l r0 = new com.stepos.ailauncher.chat.voice.motionkit.l
            r0.<init>()
            r8.post(r0)
        Lce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.voice.motionkit.C3073m.f(android.view.ViewGroup):void");
    }

    public final void h() {
        p();
        i();
        Bitmap bitmap = this.shown;
        if (bitmap != null) {
            if (bitmap == this.source || bitmap.isRecycled()) {
                bitmap = null;
            }
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
        this.shown = null;
        Bitmap bitmap2 = this.source;
        if (bitmap2 != null) {
            if (bitmap2.isRecycled()) {
                bitmap2 = null;
            }
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
        }
        this.source = null;
        this.parent = null;
    }

    public final void i() {
        ViewGroup viewGroup = this.parent;
        FrameLayout frameLayout = this.clip;
        if (viewGroup != null && frameLayout != null && frameLayout.getParent() == viewGroup) {
            viewGroup.removeView(frameLayout);
        }
        this.clip = null;
        this.glow = null;
    }

    public final void j() {
        FrameLayout frameLayout = this.clip;
        if (frameLayout != null) {
            frameLayout.bringToFront();
        }
    }

    public final boolean k() {
        Bitmap bitmap = this.source;
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = null;
        }
        return bitmap != null;
    }

    public final void l() {
        FrameLayout frameLayout;
        ImageView imageView;
        Bitmap bitmap;
        ViewGroup viewGroup = this.parent;
        if (viewGroup == null || (frameLayout = this.clip) == null || (imageView = this.glow) == null || (bitmap = this.source) == null) {
            return;
        }
        if (bitmap.isRecycled()) {
            bitmap = null;
        }
        if (bitmap != null && viewGroup.getWidth() > 0 && viewGroup.getHeight() > 0) {
            boolean z10 = this.get.invoke("uSide").floatValue() < 0.5f;
            Bitmap bitmap2 = this.shown;
            if (bitmap2 == null || this.flipped != z10) {
                if (bitmap2 != null) {
                    if (bitmap2 == bitmap || bitmap2.isRecycled()) {
                        bitmap2 = null;
                    }
                    if (bitmap2 != null) {
                        bitmap2.recycle();
                    }
                }
                Bitmap bitmapC = z10 ? C3074n.c(bitmap) : bitmap;
                this.shown = bitmapC;
                this.flipped = z10;
                imageView.setImageBitmap(bitmapC);
            }
            int iF = C5685n.f((int) (viewGroup.getHeight() * C5685n.m(this.get.invoke("uHeight").floatValue(), 0.15f, 1.2f)), 1);
            int iF2 = C5685n.f((int) ((bitmap.getWidth() * iF) / bitmap.getHeight()), 1);
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(iF2, iF);
            }
            int i10 = (z10 ? 8388611 : 8388613) | 48;
            if (layoutParams2.width != iF2 || layoutParams2.height != iF || layoutParams2.gravity != i10) {
                layoutParams2.width = iF2;
                layoutParams2.height = iF;
                layoutParams2.gravity = i10;
                frameLayout.setLayoutParams(layoutParams2);
            }
            imageView.setPivotX(z10 ? 0.0f : iF2);
            imageView.setPivotY(iF / 2.0f);
        }
    }

    public final void m() throws IOException {
        ViewGroup viewGroup = this.parent;
        if (this.glow == null && viewGroup != null) {
            f(viewGroup);
        }
        ImageView imageView = this.glow;
        if (imageView == null) {
            Log.e("KeyGlow", "play skipped: overlay not attached");
            return;
        }
        if (!k()) {
            Log.e("KeyGlow", "play skipped: missing motionkit/textures/ai_key_glow.png");
            return;
        }
        j();
        this.running = true;
        this.playAtMs = SystemClock.elapsedRealtime();
        imageView.removeCallbacks(this.tick);
        e();
        imageView.postOnAnimation(this.tick);
    }

    public final void n() throws IOException {
        if (this.running) {
            return;
        }
        m();
    }

    public final void o(float value) {
        this.speed = C5685n.e(value, 0.01f);
    }

    public final void p() {
        this.running = false;
        ImageView imageView = this.glow;
        if (imageView != null) {
            imageView.removeCallbacks(this.tick);
        }
        ImageView imageView2 = this.glow;
        if (imageView2 != null) {
            imageView2.setAlpha(0.0f);
        }
    }
}
