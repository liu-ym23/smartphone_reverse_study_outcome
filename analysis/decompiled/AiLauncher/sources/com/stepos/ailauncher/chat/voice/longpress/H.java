package com.stepos.ailauncher.chat.voice.longpress;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u001c\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0013R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/H;", "", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "Lkotlin/Function0;", "inputBody", "", "canCancel", "shouldYieldOutsideTouch", "LY8/t;", "cancelListening", "<init>", "(Landroid/view/View;Lp9/a;Lp9/a;Lp9/a;Lp9/a;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroid/view/View;", "Lp9/a;", "Landroid/graphics/Rect;", "inputRect", "Landroid/graphics/Rect;", "guardRect", "observingDown", "Z", x5.d.EXTRA_ENABLED, "Lcom/stepos/ailauncher/chat/voice/longpress/r;", "layer", "Lcom/stepos/ailauncher/chat/voice/longpress/r;", "Ljava/lang/Runnable;", "removeLayer", "Ljava/lang/Runnable;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class H {
    private final View anchor;
    private final InterfaceC5063a<Boolean> canCancel;
    private final InterfaceC5063a<Y8.t> cancelListening;
    private boolean enabled;
    private final Rect guardRect;
    private final InterfaceC5063a<View> inputBody;
    private final Rect inputRect;
    private r layer;
    private boolean observingDown;
    private final Runnable removeLayer;
    private final InterfaceC5063a<Boolean> shouldYieldOutsideTouch;

    /* JADX WARN: Multi-variable type inference failed */
    public H(View anchor, InterfaceC5063a<? extends View> inputBody, InterfaceC5063a<Boolean> canCancel, InterfaceC5063a<Boolean> shouldYieldOutsideTouch, InterfaceC5063a<Y8.t> cancelListening) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        kotlin.jvm.internal.p.i(inputBody, "inputBody");
        kotlin.jvm.internal.p.i(canCancel, "canCancel");
        kotlin.jvm.internal.p.i(shouldYieldOutsideTouch, "shouldYieldOutsideTouch");
        kotlin.jvm.internal.p.i(cancelListening, "cancelListening");
        this.anchor = anchor;
        this.inputBody = inputBody;
        this.canCancel = canCancel;
        this.shouldYieldOutsideTouch = shouldYieldOutsideTouch;
        this.cancelListening = cancelListening;
        this.inputRect = new Rect();
        this.guardRect = new Rect();
        this.removeLayer = new Runnable() { // from class: com.stepos.ailauncher.chat.voice.longpress.D
            @Override // java.lang.Runnable
            public final void run() {
                H.f(this.f26437a);
            }
        };
    }

    public static final void f(H h10) {
        if (h10.enabled) {
            return;
        }
        h10.g();
    }

    public static final boolean j(H h10) {
        return h10.enabled && h10.canCancel.invoke().booleanValue() && !h10.shouldYieldOutsideTouch.invoke().booleanValue();
    }

    public static final boolean k(H h10, float f10, float f11) {
        View viewInvoke = h10.inputBody.invoke();
        r rVar = h10.layer;
        if (viewInvoke == null || rVar == null || !viewInvoke.getGlobalVisibleRect(h10.inputRect) || !rVar.getGlobalVisibleRect(h10.guardRect)) {
            return false;
        }
        Rect rect = h10.inputRect;
        Rect rect2 = h10.guardRect;
        return rect.contains((int) (f10 + ((float) rect2.left)), (int) (f11 + ((float) rect2.top)));
    }

    public static final Y8.t l(H h10) {
        h10.observingDown = true;
        h10.enabled = false;
        try {
            h10.cancelListening.invoke();
            h10.observingDown = false;
            h10.anchor.removeCallbacks(h10.removeLayer);
            h10.anchor.post(h10.removeLayer);
            return Y8.t.f7040a;
        } catch (Throwable th) {
            h10.observingDown = false;
            h10.anchor.removeCallbacks(h10.removeLayer);
            h10.anchor.post(h10.removeLayer);
            throw th;
        }
    }

    public final void e() {
        this.enabled = false;
        this.anchor.removeCallbacks(this.removeLayer);
        g();
    }

    public final void g() {
        r rVar = this.layer;
        if (rVar != null) {
            ViewParent parent = rVar.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(rVar);
            }
        }
        this.layer = null;
    }

    public final void h() {
        this.enabled = false;
        this.anchor.removeCallbacks(this.removeLayer);
        if (this.observingDown) {
            this.anchor.post(this.removeLayer);
        } else {
            g();
        }
    }

    public final void i() {
        this.enabled = this.canCancel.invoke().booleanValue();
        this.anchor.removeCallbacks(this.removeLayer);
        if (!this.enabled) {
            h();
            return;
        }
        View rootView = this.anchor.getRootView();
        ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
        if (viewGroup != null && this.anchor.isAttachedToWindow()) {
            r rVar = this.layer;
            if (rVar == null) {
                Context context = this.anchor.getContext();
                kotlin.jvm.internal.p.h(context, "getContext(...)");
                rVar = new r(context, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.longpress.E
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return Boolean.valueOf(H.j(this.f26438a));
                    }
                }, new p9.p() { // from class: com.stepos.ailauncher.chat.voice.longpress.F
                    @Override // p9.p
                    public final Object invoke(Object obj, Object obj2) {
                        return Boolean.valueOf(H.k(this.f26439a, ((Float) obj).floatValue(), ((Float) obj2).floatValue()));
                    }
                }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.longpress.G
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return H.l(this.f26440a);
                    }
                });
                this.layer = rVar;
            }
            if (rVar.getParent() != viewGroup) {
                ViewParent parent = rVar.getParent();
                ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup2 != null) {
                    viewGroup2.removeView(rVar);
                }
                viewGroup.addView(rVar, new ViewGroup.LayoutParams(-1, -1));
            }
            int childCount = viewGroup.getChildCount();
            float fMax = 0.0f;
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt != rVar) {
                    fMax = Math.max(fMax, childAt.getZ());
                }
            }
            rVar.setTranslationZ(fMax + 1.0f);
            rVar.bringToFront();
        }
    }
}
