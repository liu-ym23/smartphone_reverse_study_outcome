package com.stepos.ailauncher.chat.voice.longpress;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.motionkit.C3069i;
import com.stepos.ailauncher.chat.voice.motionkit.C3073m;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001\u001e\b\u0000\u0018\u00002\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/c;", "", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "<init>", "(Landroid/view/View;)V", "LY8/t;", "e", "()V", "f", "", "name", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)F", "Landroid/view/View;", "", "", "defaults", "Ljava/util/Map;", "Lcom/stepos/ailauncher/chat/voice/motionkit/m;", "glow", "Lcom/stepos/ailauncher/chat/voice/motionkit/m;", "", "Lcom/stepos/ailauncher/chat/voice/longpress/c$a;", "clipStates", "Ljava/util/List;", "Ljava/lang/Runnable;", "cleanup", "Ljava/lang/Runnable;", "com/stepos/ailauncher/chat/voice/longpress/c$b", "detachListener", "Lcom/stepos/ailauncher/chat/voice/longpress/c$b;", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.voice.longpress.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3038c {
    private final View anchor;
    private final Runnable cleanup;
    private final List<ClipState> clipStates;
    private final Map<String, float[]> defaults;
    private final b detachListener;
    private final C3073m glow;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/c$a;", "", "Landroid/view/ViewGroup;", "view", "", "children", "padding", "<init>", "(Landroid/view/ViewGroup;ZZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Landroid/view/ViewGroup;", "c", "()Landroid/view/ViewGroup;", "Z", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.voice.longpress.c$a, reason: from toString */
    public static final /* data */ class ClipState {
        private final boolean children;
        private final boolean padding;
        private final ViewGroup view;

        public ClipState(ViewGroup view, boolean z10, boolean z11) {
            kotlin.jvm.internal.p.i(view, "view");
            this.view = view;
            this.children = z10;
            this.padding = z11;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getChildren() {
            return this.children;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getPadding() {
            return this.padding;
        }

        /* renamed from: c, reason: from getter */
        public final ViewGroup getView() {
            return this.view;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClipState)) {
                return false;
            }
            ClipState clipState = (ClipState) other;
            return kotlin.jvm.internal.p.d(this.view, clipState.view) && this.children == clipState.children && this.padding == clipState.padding;
        }

        public int hashCode() {
            return (((this.view.hashCode() * 31) + Boolean.hashCode(this.children)) * 31) + Boolean.hashCode(this.padding);
        }

        public String toString() {
            return "ClipState(view=" + this.view + ", children=" + this.children + ", padding=" + this.padding + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/voice/longpress/c$b", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.voice.longpress.c$b */
    public static final class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            C3038c.this.f();
        }
    }

    public C3038c(View anchor) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        this.anchor = anchor;
        this.defaults = com.stepos.ailauncher.chat.voice.motionkit.O.l(C3069i.a());
        this.glow = new C3073m(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.voice.longpress.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Float.valueOf(C3038c.d(this.f26452a, (String) obj));
            }
        });
        this.clipStates = new ArrayList();
        this.cleanup = new Runnable() { // from class: com.stepos.ailauncher.chat.voice.longpress.b
            @Override // java.lang.Runnable
            public final void run() {
                C3038c.c(this.f26455a);
            }
        };
        this.detachListener = new b();
    }

    public static final void c(C3038c c3038c) {
        c3038c.f();
    }

    public static final float d(C3038c c3038c, String name) {
        kotlin.jvm.internal.p.i(name, "name");
        return kotlin.jvm.internal.p.d(name, "uReleaseAt") ? c3038c.g("uEnterDur") : c3038c.g(name);
    }

    public final void e() {
        f();
        View rootView = this.anchor.getRootView();
        ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
        if (viewGroup != null && this.anchor.isAttachedToWindow() && viewGroup.getWidth() > 0 && viewGroup.getHeight() > 0) {
            ViewGroup viewGroup2 = viewGroup;
            for (int i10 = 0; i10 < 4; i10++) {
                if (viewGroup2 != null) {
                    this.clipStates.add(new ClipState(viewGroup2, viewGroup2.getClipChildren(), viewGroup2.getClipToPadding()));
                    ViewParent parent = viewGroup2.getParent();
                    viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                }
            }
            this.anchor.addOnAttachStateChangeListener(this.detachListener);
            try {
                this.glow.f(viewGroup);
                this.glow.m();
                this.anchor.postDelayed(this.cleanup, (long) Math.ceil((g("uEnterDur") + g("uExitDur")) * 1000.0d));
            } catch (RuntimeException e10) {
                Log.w("AiKeyClickFeedback", "Unable to show key feedback", e10);
                f();
            }
        }
    }

    public final void f() {
        this.anchor.removeCallbacks(this.cleanup);
        this.anchor.removeOnAttachStateChangeListener(this.detachListener);
        this.glow.h();
        for (ClipState clipState : this.clipStates) {
            clipState.getView().setClipChildren(clipState.getChildren());
            clipState.getView().setClipToPadding(clipState.getPadding());
        }
        this.clipStates.clear();
    }

    public final float g(String name) {
        Float fY;
        float[] fArr = this.defaults.get(name);
        if (fArr == null || (fY = Z8.r.Y(fArr)) == null) {
            return 0.0f;
        }
        return fY.floatValue();
    }
}
