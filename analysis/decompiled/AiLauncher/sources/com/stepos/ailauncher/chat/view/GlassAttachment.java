package com.stepos.ailauncher.chat.view;

import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b%\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001ABw\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012*\b\u0002\u0010\u0011\u001a$\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJW\u0010&\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001dH\u0016¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u000b¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u000b¢\u0006\u0004\b*\u0010)J\u0019\u0010,\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u000bH\u0002¢\u0006\u0004\b.\u0010)J\u000f\u0010/\u001a\u00020\u000bH\u0002¢\u0006\u0004\b/\u0010)R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00100R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00101R\"\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00102R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u00103R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u00104R6\u0010\u0011\u001a$\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u00105R\u0018\u00106\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00108\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00101R\u0016\u0010;\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00101R\u0016\u0010<\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00101R\u0011\u0010?\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/stepos/ailauncher/chat/view/GlassAttachment;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "crossWindow", "Lkotlin/Function1;", "", "cornerRadiusDp", "Lkotlin/Function0;", "LY8/t;", "postAttach", "Ly7/o;", "effect", "Lkotlin/Function4;", "Ly7/E;", "materialFactory", "<init>", "(Landroid/view/View;ZLp9/l;Lp9/a;Ly7/o;Lp9/r;)V", "t", "()Lcom/stepos/ailauncher/chat/view/GlassAttachment;", UxipConstants.f30680s, "s", "(Z)V", "v", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "p", "()V", "n", "next", "r", "(Ly7/E;)V", "m", "q", "Landroid/view/View;", "Z", "Lp9/l;", "Lp9/a;", "Ly7/o;", "Lp9/r;", "handle", "Ly7/E;", "cornerDp", "Ljava/lang/Float;", "awaitingLayout", "disposed", "suspended", "o", "()Z", "isActive", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GlassAttachment implements View.OnAttachStateChangeListener, View.OnLayoutChangeListener {
    private static final a Companion = new a(null);

    @Deprecated
    public static final String GPU_KIND = "glass";
    private boolean awaitingLayout;
    private Float cornerDp;
    private final InterfaceC5074l<View, Float> cornerRadiusDp;
    private final boolean crossWindow;
    private boolean disposed;
    private final y7.o effect;
    private y7.E handle;
    private final p9.r<View, Boolean, Float, y7.o, y7.E> materialFactory;
    private final InterfaceC5063a<Y8.t> postAttach;
    private boolean suspended;
    private final View view;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.GlassAttachment$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements p9.r<View, Boolean, Float, y7.o, y7.E> {
        public AnonymousClass1(Object obj) {
            super(4, obj, C2851i7.class, "attach", "attach(Landroid/view/View;ZLjava/lang/Float;Lcom/stepos/motionkit/fx/material/GlassEffect;)Lcom/stepos/motionkit/fx/material/MaterialHandle;", 0);
        }

        @Override // p9.r
        public /* bridge */ /* synthetic */ y7.E invoke(View view, Boolean bool, Float f10, y7.o oVar) {
            return l(view, bool.booleanValue(), f10, oVar);
        }

        public final y7.E l(View p02, boolean z10, Float f10, y7.o p32) {
            kotlin.jvm.internal.p.i(p02, "p0");
            kotlin.jvm.internal.p.i(p32, "p3");
            return ((C2851i7) this.receiver).c(p02, z10, f10, p32);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/view/GlassAttachment$a;", "", "<init>", "()V", "", "GPU_KIND", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements View.OnLayoutChangeListener {
        public b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            GlassAttachment.this.awaitingLayout = false;
            if (GlassAttachment.this.disposed || GlassAttachment.this.suspended || GlassAttachment.this.handle != null || !GlassAttachment.this.view.isAttachedToWindow()) {
                return;
            }
            InterfaceC5074l interfaceC5074l = GlassAttachment.this.cornerRadiusDp;
            Float f10 = interfaceC5074l != null ? (Float) interfaceC5074l.invoke(GlassAttachment.this.view) : null;
            GlassAttachment.this.cornerDp = f10 == null ? Float.valueOf(Float.NaN) : f10;
            GlassAttachment glassAttachment = GlassAttachment.this;
            glassAttachment.r((y7.E) glassAttachment.materialFactory.invoke(GlassAttachment.this.view, Boolean.valueOf(GlassAttachment.this.crossWindow), f10, GlassAttachment.this.effect));
            InterfaceC5063a interfaceC5063a = GlassAttachment.this.postAttach;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GlassAttachment(View view, boolean z10, InterfaceC5074l<? super View, Float> interfaceC5074l, InterfaceC5063a<Y8.t> interfaceC5063a, y7.o effect, p9.r<? super View, ? super Boolean, ? super Float, ? super y7.o, y7.E> materialFactory) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(effect, "effect");
        kotlin.jvm.internal.p.i(materialFactory, "materialFactory");
        this.view = view;
        this.crossWindow = z10;
        this.cornerRadiusDp = interfaceC5074l;
        this.postAttach = interfaceC5063a;
        this.effect = effect;
        this.materialFactory = materialFactory;
    }

    public final void m() {
        if (this.disposed || this.suspended || this.handle != null || this.awaitingLayout) {
            return;
        }
        this.awaitingLayout = true;
        View view = this.view;
        if (!view.isLaidOut() || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new b());
            return;
        }
        this.awaitingLayout = false;
        if (this.disposed || this.suspended || this.handle != null || !this.view.isAttachedToWindow()) {
            return;
        }
        InterfaceC5074l interfaceC5074l = this.cornerRadiusDp;
        Float f10 = interfaceC5074l != null ? (Float) interfaceC5074l.invoke(this.view) : null;
        this.cornerDp = f10 == null ? Float.valueOf(Float.NaN) : f10;
        r((y7.E) this.materialFactory.invoke(this.view, Boolean.valueOf(this.crossWindow), f10, this.effect));
        InterfaceC5063a interfaceC5063a = this.postAttach;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public final void n() {
        this.disposed = true;
        q();
        this.view.removeOnAttachStateChangeListener(this);
        this.view.removeOnLayoutChangeListener(this);
    }

    public final boolean o() {
        return (this.handle == null || this.disposed || this.suspended) ? false : true;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View v10, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        y7.E e10;
        kotlin.jvm.internal.p.i(v10, "v");
        InterfaceC5074l<View, Float> interfaceC5074l = this.cornerRadiusDp;
        if (interfaceC5074l == null || (e10 = this.handle) == null) {
            return;
        }
        float fFloatValue = interfaceC5074l.invoke(this.view).floatValue();
        if (kotlin.jvm.internal.p.a(fFloatValue, this.cornerDp)) {
            return;
        }
        this.cornerDp = Float.valueOf(fFloatValue);
        C2851i7.INSTANCE.m(e10, fFloatValue, this.view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v10) {
        kotlin.jvm.internal.p.i(v10, "v");
        m();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v10) {
        kotlin.jvm.internal.p.i(v10, "v");
        q();
    }

    public final void p() {
        if (this.disposed || this.suspended) {
            return;
        }
        this.awaitingLayout = false;
        if (!this.view.isAttachedToWindow()) {
            q();
            return;
        }
        if (this.view.getWidth() <= 0 || this.view.getHeight() <= 0) {
            q();
            m();
            return;
        }
        y7.E e10 = this.handle;
        r(null);
        InterfaceC5074l<View, Float> interfaceC5074l = this.cornerRadiusDp;
        Float fInvoke = interfaceC5074l != null ? interfaceC5074l.invoke(this.view) : null;
        this.cornerDp = fInvoke == null ? Float.valueOf(Float.NaN) : fInvoke;
        r(this.materialFactory.invoke(this.view, Boolean.valueOf(this.crossWindow), fInvoke, this.effect));
        InterfaceC5063a<Y8.t> interfaceC5063a = this.postAttach;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        if (e10 == null || e10 == this.handle) {
            return;
        }
        C2851i7.INSTANCE.h(e10);
    }

    public final void q() {
        C2851i7.INSTANCE.h(this.handle);
        r(null);
    }

    public final void r(y7.E next) {
        boolean z10 = this.handle != null;
        boolean z11 = next != null;
        if (z10 != z11) {
            if (z11) {
                com.stepos.ailauncher.common.memory.d.INSTANCE.v(GPU_KIND);
            } else {
                com.stepos.ailauncher.common.memory.d.INSTANCE.w(GPU_KIND);
            }
        }
        this.handle = next;
    }

    public final void s(boolean value) {
        if (this.disposed || this.suspended == value) {
            return;
        }
        this.suspended = value;
        if (value) {
            q();
        } else if (this.view.isAttachedToWindow()) {
            m();
        }
    }

    public final GlassAttachment t() {
        if (!this.disposed) {
            this.view.addOnAttachStateChangeListener(this);
            this.view.addOnLayoutChangeListener(this);
            if (this.view.isAttachedToWindow()) {
                m();
            }
        }
        return this;
    }

    public /* synthetic */ GlassAttachment(View view, boolean z10, InterfaceC5074l interfaceC5074l, InterfaceC5063a interfaceC5063a, y7.o oVar, p9.r rVar, int i10, kotlin.jvm.internal.i iVar) {
        this(view, z10, (i10 & 4) != 0 ? null : interfaceC5074l, (i10 & 8) != 0 ? null : interfaceC5063a, (i10 & 16) != 0 ? y7.o.INSTANCE.l() : oVar, (i10 & 32) != 0 ? new AnonymousClass1(C2851i7.INSTANCE) : rVar);
    }
}
