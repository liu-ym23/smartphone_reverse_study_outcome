package com.stepos.ailauncher.chat.voice.longpress;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.longpress.A;
import com.stepos.ailauncher.chat.wake.circle.CircleSelectController;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.motionkit.fx.material.capability.BlurGradient;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import r9.C5227b;
import v9.C5685n;
import y7.G;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00029@\b\u0000\u0018\u0000 L2\u00020\u0001:\u0001MB+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u000fJ\u000f\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u000fJ\u000f\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u000fJ\u000f\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010+R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00108R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010\u001eR\u0014\u0010D\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010%R\u0018\u0010E\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010\u001aR\u0016\u0010F\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010/R\u0016\u0010G\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u00108R\u0016\u0010H\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u00108R\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006N"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/A;", "", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "Lkotlin/Function0;", "", "canTap", "LY8/t;", "onBackdropTap", "<init>", "(Landroid/view/View;Lp9/a;Lp9/a;)V", "onReady", "v", "(Lp9/a;)Z", "o", "()V", "z", "n", "", "stage", "t", "(Ljava/lang/String;)V", "C", "x", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "u", "Landroid/view/View;", "Lp9/a;", "Landroid/widget/FrameLayout;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Landroid/widget/FrameLayout;", "q", "()Landroid/widget/FrameLayout;", com.stepos.ailauncher.chat.trace.h.APP_FOREGROUND, "r", "Landroid/widget/PopupWindow;", "foregroundPopup", "Landroid/widget/PopupWindow;", "Lcom/stepos/ailauncher/chat/voice/longpress/s;", "windowRoot", "Lcom/stepos/ailauncher/chat/voice/longpress/s;", "", "density", "F", "designHeight", "", "visibleHeight", "I", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "backdropAlpha", "Landroid/animation/ValueAnimator;", "enterAnimator", "Landroid/animation/ValueAnimator;", "exiting", "Z", "com/stepos/ailauncher/chat/voice/longpress/A$d", "layer", "Lcom/stepos/ailauncher/chat/voice/longpress/A$d;", "Ly7/E;", "blurHandle", "Ly7/E;", "blurAttachAttempted", "com/stepos/ailauncher/chat/voice/longpress/A$b", "blurLayer", "Lcom/stepos/ailauncher/chat/voice/longpress/A$b;", "backdrop", "popup", Parameters.ROOT, HomeGestureEligibilityContract.EXTRA_GENERATION, "loggedFirstMaterial", "loggedOpaqueMaterial", "Landroid/view/View$OnLayoutChangeListener;", "layoutListener", "Landroid/view/View$OnLayoutChangeListener;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class A {
    private static final long BACKDROP_ENTER_DURATION_MS = 100;
    private static final float BLUR_RADIUS_DP = 32.0f;
    public static final long EXIT_DURATION_MS = 150;
    private final View anchor;
    private final FrameLayout backdrop;
    private float backdropAlpha;
    private boolean blurAttachAttempted;
    private y7.E blurHandle;
    private final b blurLayer;
    private final InterfaceC5063a<Boolean> canTap;
    private final FrameLayout content;
    private final float density;
    private final float designHeight;
    private ValueAnimator enterAnimator;
    private boolean exiting;
    private final FrameLayout foreground;
    private final PopupWindow foregroundPopup;
    private int generation;
    private final d layer;
    private final View.OnLayoutChangeListener layoutListener;
    private boolean loggedFirstMaterial;
    private boolean loggedOpaqueMaterial;
    private final Paint paint;
    private final PopupWindow popup;
    private View root;
    private final int visibleHeight;
    private final C3053s windowRoot;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/voice/longpress/A$b", "Landroid/view/View;", "LY8/t;", "onDetachedFromWindow", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends View {
        public b(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void onDetachedFromWindow() {
            A.this.u();
            super.onDetachedFromWindow();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/voice/longpress/A$c", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "Landroid/os/IBinder;", "getWindowToken", "()Landroid/os/IBinder;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends FrameLayout {
        public c(ContextWrapper contextWrapper) {
            super(contextWrapper);
        }

        @Override // android.view.View
        public View getRootView() {
            return this;
        }

        @Override // android.view.View
        public IBinder getWindowToken() {
            IBinder windowToken = A.this.anchor.getWindowToken();
            return windowToken == null ? super.getWindowToken() : windowToken;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/chat/voice/longpress/A$d", "Landroid/view/View;", "", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "LY8/t;", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends View {
        public d(Context context) {
            super(context);
        }

        public static final void b(A a10) {
            a10.A();
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            kotlin.jvm.internal.p.i(canvas, "canvas");
            A.this.paint.setAlpha(C5227b.b(A.this.backdropAlpha * 255.0f));
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), A.this.paint);
        }

        @Override // android.view.View
        public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
            A.this.paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, A.this.designHeight, 0, -16777216, Shader.TileMode.CLAMP));
            final A a10 = A.this;
            post(new Runnable() { // from class: com.stepos.ailauncher.chat.voice.longpress.B
                @Override // java.lang.Runnable
                public final void run() {
                    A.d.b(a10);
                }
            });
        }
    }

    public A(View anchor, InterfaceC5063a<Boolean> canTap, InterfaceC5063a<Y8.t> onBackdropTap) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        kotlin.jvm.internal.p.i(canTap, "canTap");
        kotlin.jvm.internal.p.i(onBackdropTap, "onBackdropTap");
        this.anchor = anchor;
        this.canTap = canTap;
        c cVar = new c(new ContextWrapper(anchor.getContext()));
        cVar.setId(R.id.content);
        cVar.setClipChildren(false);
        cVar.setClipToPadding(false);
        this.content = cVar;
        FrameLayout frameLayout = new FrameLayout(anchor.getContext());
        this.foreground = frameLayout;
        PopupWindow popupWindow = new PopupWindow((View) frameLayout, 1, 1, false);
        popupWindow.setWindowLayoutType(1002);
        popupWindow.setTouchable(false);
        popupWindow.setFocusable(false);
        popupWindow.setInputMethodMode(2);
        popupWindow.setAnimationStyle(0);
        popupWindow.setClippingEnabled(false);
        popupWindow.setElevation(0.0f);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setIsLaidOutInScreen(true);
        this.foregroundPopup = popupWindow;
        Context context = anchor.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        C3053s c3053s = new C3053s(context, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.longpress.v
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(A.E(this.f26484a));
            }
        }, onBackdropTap);
        c3053s.setClipChildren(false);
        c3053s.setClipToPadding(false);
        c3053s.setBackgroundColor(0);
        this.windowRoot = c3053s;
        float f10 = anchor.getResources().getDisplayMetrics().density;
        this.density = f10;
        float f11 = 252.0f * f10;
        this.designHeight = f11;
        int iB = C5227b.b(f10 * 248.0f);
        this.visibleHeight = iB;
        this.paint = new Paint();
        d dVar = new d(anchor.getContext());
        dVar.setImportantForAccessibility(2);
        this.layer = dVar;
        b bVar = new b(anchor.getContext());
        bVar.setImportantForAccessibility(2);
        this.blurLayer = bVar;
        FrameLayout frameLayout2 = new FrameLayout(anchor.getContext());
        frameLayout2.setClipChildren(true);
        frameLayout2.setClipToPadding(true);
        frameLayout2.addView(bVar, new FrameLayout.LayoutParams(-1, C5227b.b(f11), 48));
        frameLayout2.addView(dVar, new FrameLayout.LayoutParams(-1, -1));
        this.backdrop = frameLayout2;
        PopupWindow popupWindow2 = new PopupWindow((View) c3053s, 1, 1, false);
        popupWindow2.setTouchable(true);
        popupWindow2.setFocusable(false);
        popupWindow2.setInputMethodMode(2);
        popupWindow2.setAnimationStyle(0);
        popupWindow2.setClippingEnabled(false);
        popupWindow2.setElevation(0.0f);
        popupWindow2.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow2.setIsLaidOutInScreen(true);
        this.popup = popupWindow2;
        this.layoutListener = new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.chat.voice.longpress.w
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                A.s(this.f26485a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        c3053s.addView(frameLayout2, new FrameLayout.LayoutParams(-1, iB, 80));
        c3053s.addView(cVar, new FrameLayout.LayoutParams(-1, -1));
    }

    public static final Y8.t B(A a10, A7.B apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.n(a10.density * BLUR_RADIUS_DP);
        apply.z(BlurGradient.TOP_TO_BOTTOM);
        apply.o(0);
        apply.D(0);
        apply.C(0);
        apply.A(0);
        apply.l(0.0f);
        apply.k(0.0f);
        return Y8.t.f7040a;
    }

    public static final void D(A a10) {
        a10.A();
    }

    public static final boolean E(A a10) {
        return (a10.root == null || CircleSelectController.INSTANCE.d() || !a10.canTap.invoke().booleanValue()) ? false : true;
    }

    public static final void p(A a10, ValueAnimator it) {
        kotlin.jvm.internal.p.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        a10.backdropAlpha = ((Float) animatedValue).floatValue();
        a10.A();
    }

    public static final void s(A a10, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        a10.C();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0023, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void w(int r3, com.stepos.ailauncher.chat.voice.longpress.A r4, p9.InterfaceC5063a r5) {
        /*
            int r0 = r4.generation
            if (r3 != r0) goto L52
            android.widget.PopupWindow r0 = r4.popup
            boolean r0 = r0.isShowing()
            if (r0 == 0) goto L52
            android.widget.FrameLayout r0 = r4.content
            boolean r0 = r0.isAttachedToWindow()
            if (r0 == 0) goto L52
            com.stepos.ailauncher.chat.voice.longpress.s r0 = r4.windowRoot
            android.view.ViewParent r0 = r0.getParent()
            boolean r1 = r0 instanceof android.view.View
            r2 = 0
            if (r1 == 0) goto L22
            android.view.View r0 = (android.view.View) r0
            goto L23
        L22:
            r0 = r2
        L23:
            if (r0 == 0) goto L34
            r1 = 0
            r0.setBackgroundColor(r1)
            android.view.ViewParent r0 = r0.getParent()
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L22
            android.view.View r0 = (android.view.View) r0
            goto L23
        L34:
            r4.A()
            r4.z()
            r5.invoke()
            java.lang.String r5 = "sdk-ready"
            r4.t(r5)
            int r5 = r4.generation
            if (r3 != r5) goto L52
            android.widget.PopupWindow r3 = r4.popup
            boolean r3 = r3.isShowing()
            if (r3 == 0) goto L52
            r4.x()
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.voice.longpress.A.w(int, com.stepos.ailauncher.chat.voice.longpress.A, p9.a):void");
    }

    public static final void y(A a10, ValueAnimator it) {
        kotlin.jvm.internal.p.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        a10.backdropAlpha = ((Float) animatedValue).floatValue();
        a10.A();
    }

    public final void A() {
        if (!this.popup.isShowing() || !this.blurLayer.isAttachedToWindow() || this.blurLayer.getWidth() <= 0 || this.blurLayer.getHeight() <= 0) {
            return;
        }
        if (!this.blurAttachAttempted) {
            this.blurAttachAttempted = true;
            y7.E eU = y7.H.a(s7.p.f40121a, this.blurLayer).x(true).j(G.a.f43886a.f(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.voice.longpress.u
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return A.B(this.f26483a, (A7.B) obj);
                }
            }).u();
            this.blurHandle = eU;
            float f10 = this.density * BLUR_RADIUS_DP;
            List<String> listD = eU != null ? eU.d() : null;
            Drawable background = this.blurLayer.getBackground();
            C4148a.k("ListeningBackdrop", "ListeningBlur backend=MotionKitGradientBlur radiusPx=" + f10 + " activeIds=" + listD + " drawable=" + (background != null ? background.getClass().getName() : null) + " (binding is not visual confirmation)", false, 4, null);
        }
        Drawable background2 = this.blurLayer.getBackground();
        if (background2 != null) {
            background2.setAlpha(C5685n.n(C5227b.b(this.backdropAlpha * 255.0f), 0, 255));
        }
        if (!this.loggedFirstMaterial || (!this.loggedOpaqueMaterial && this.backdropAlpha >= 1.0f)) {
            t(this.backdropAlpha >= 1.0f ? "enter-complete" : "first-material");
            this.loggedFirstMaterial = true;
            if (this.backdropAlpha >= 1.0f) {
                this.loggedOpaqueMaterial = true;
            }
        }
        this.layer.invalidate();
    }

    public final void C() {
        View view = this.root;
        if (view != null && this.popup.isShowing()) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            this.popup.update(iArr[0], iArr[1], view.getWidth(), view.getHeight());
            if (this.foregroundPopup.isShowing()) {
                this.foregroundPopup.update(iArr[0], iArr[1], view.getWidth(), view.getHeight());
            }
            this.content.post(new Runnable() { // from class: com.stepos.ailauncher.chat.voice.longpress.y
                @Override // java.lang.Runnable
                public final void run() {
                    A.D(this.f26489a);
                }
            });
        }
    }

    public final void n() {
        this.windowRoot.d();
        if (this.popup.isShowing()) {
            t(DidiCardProvider.ACTION_DISMISS);
        }
        this.generation++;
        ValueAnimator valueAnimator = this.enterAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.enterAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.enterAnimator = null;
        this.backdropAlpha = 0.0f;
        u();
        this.layer.invalidate();
        View view = this.root;
        if (view != null) {
            view.removeOnLayoutChangeListener(this.layoutListener);
        }
        this.root = null;
        if (this.foregroundPopup.isShowing()) {
            this.foregroundPopup.dismiss();
        }
        if (this.popup.isShowing()) {
            this.popup.dismiss();
        }
    }

    public final void o() {
        if (this.exiting || !this.popup.isShowing()) {
            return;
        }
        this.exiting = true;
        ValueAnimator valueAnimator = this.enterAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.enterAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.enterAnimator = null;
        if (!ValueAnimator.areAnimatorsEnabled()) {
            this.backdropAlpha = 0.0f;
            A();
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.backdropAlpha, 0.0f);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.voice.longpress.t
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                A.p(this.f26482a, valueAnimator3);
            }
        });
        valueAnimatorOfFloat.start();
        this.enterAnimator = valueAnimatorOfFloat;
    }

    /* renamed from: q, reason: from getter */
    public final FrameLayout getContent() {
        return this.content;
    }

    /* renamed from: r, reason: from getter */
    public final FrameLayout getForeground() {
        return this.foreground;
    }

    public final void t(String stage) {
        int i10 = this.generation;
        boolean zIsShowing = this.popup.isShowing();
        boolean zIsAttachedToWindow = this.windowRoot.isAttachedToWindow();
        View view = this.root;
        Integer numValueOf = view != null ? Integer.valueOf(view.getWidth()) : null;
        View view2 = this.root;
        Integer numValueOf2 = view2 != null ? Integer.valueOf(view2.getHeight()) : null;
        C4148a.k("ListeningBackdrop", "ListeningBlur stage=" + stage + " session=" + i10 + " showing=" + zIsShowing + " attached=" + zIsAttachedToWindow + " host=" + numValueOf + "x" + numValueOf2 + " root=" + System.identityHashCode(this.windowRoot.getRootView()) + " window=" + this.windowRoot.getWidth() + "x" + this.windowRoot.getHeight() + " layer=" + this.layer.getLeft() + Const.STR_MART_COMMA + this.layer.getTop() + Const.STR_MART_COMMA + this.layer.getRight() + Const.STR_MART_COMMA + this.layer.getBottom() + " density=" + this.density + " alpha=" + this.backdropAlpha, false, 4, null);
    }

    public final void u() {
        Drawable background = this.blurLayer.getBackground();
        if (background != null) {
            background.setAlpha(0);
        }
        y7.E e10 = this.blurHandle;
        if (e10 != null) {
            e10.g();
        }
        this.blurHandle = null;
        this.blurAttachAttempted = false;
    }

    public final boolean v(final InterfaceC5063a<Y8.t> onReady) {
        kotlin.jvm.internal.p.i(onReady, "onReady");
        n();
        this.exiting = false;
        this.loggedFirstMaterial = false;
        this.loggedOpaqueMaterial = false;
        View rootView = this.anchor.getRootView();
        if (!rootView.isAttachedToWindow() || rootView.getWindowToken() == null || rootView.getWidth() <= 0 || rootView.getHeight() <= 0) {
            t("show-rejected");
            return false;
        }
        final int i10 = this.generation;
        this.root = rootView;
        rootView.addOnLayoutChangeListener(this.layoutListener);
        this.popup.setWidth(rootView.getWidth());
        this.popup.setHeight(rootView.getHeight());
        this.popup.setTouchable(C.a(CircleSelectController.INSTANCE.d()));
        try {
            int[] iArr = new int[2];
            rootView.getLocationOnScreen(iArr);
            this.popup.showAtLocation(rootView, 51, iArr[0], iArr[1]);
            this.foregroundPopup.setWidth(rootView.getWidth());
            this.foregroundPopup.setHeight(rootView.getHeight());
            this.foregroundPopup.showAtLocation(rootView, 51, iArr[0], iArr[1]);
            String string = Arrays.toString(iArr);
            kotlin.jvm.internal.p.h(string, "toString(...)");
            t("show-requested offset=" + string);
            this.content.post(new Runnable() { // from class: com.stepos.ailauncher.chat.voice.longpress.x
                @Override // java.lang.Runnable
                public final void run() {
                    A.w(i10, this, onReady);
                }
            });
            return true;
        } catch (RuntimeException e10) {
            Log.w("ListeningBackdrop", "Unable to attach backdrop", e10);
            n();
            return false;
        }
    }

    public final void x() {
        if (this.exiting) {
            return;
        }
        if (!ValueAnimator.areAnimatorsEnabled()) {
            this.backdropAlpha = 1.0f;
            A();
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.voice.longpress.z
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                A.y(this.f26490a, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
        this.enterAnimator = valueAnimatorOfFloat;
    }

    public final void z() {
        if (this.popup.isShowing()) {
            CircleSelectController.Companion companion = CircleSelectController.INSTANCE;
            boolean zA = C.a(companion.d());
            if (this.popup.isTouchable() == zA) {
                return;
            }
            this.windowRoot.d();
            this.popup.setTouchable(zA);
            this.popup.update();
            C4148a.k("ListeningBackdrop", "touchable=" + zA + " circleActive=" + companion.d(), false, 4, null);
        }
    }
}
