package com.stepos.ailauncher.chat.view;

import android.view.InterfaceC1387e;
import android.view.LifecycleOwner;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import y7.G;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\r\u001a\u00020\u00002\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJE\u0010\u0013\u001a\u00020\u00002\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t2\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f¢\u0006\u0004\b\u0013\u0010\u0014J=\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\t2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u00162\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019JU\u0010 \u001a\u00020\u00002\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00102\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0016¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0004¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u001e¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010)R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010*R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010*¨\u00060"}, d2 = {"Lcom/stepos/ailauncher/chat/view/b6;", "Landroidx/lifecycle/e;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "crossWindow", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Z)V", "", "Landroid/view/View;", "targets", "Ly7/o;", "effect", "o", "([Landroid/view/View;Ly7/o;Z)Lcom/stepos/ailauncher/chat/view/b6;", "Lkotlin/Function3;", "", "Ly7/E;", "materialFactory", "n", "([Landroid/view/View;Lp9/q;)Lcom/stepos/ailauncher/chat/view/b6;", "target", "Lkotlin/Function1;", "cornerRadiusDp", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/view/View;Lp9/l;Ly7/o;Z)Lcom/stepos/ailauncher/chat/view/b6;", "Ly7/C;", "LA7/B;", ChatTracker.SEND_PRESET, "topCornerRadiusDp", "LY8/t;", "configure", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "([Landroid/view/View;Ly7/C;Ljava/lang/Float;Lp9/l;)Lcom/stepos/ailauncher/chat/view/b6;", "suspended", "u", "(Z)V", "onDestroy", "(Landroidx/lifecycle/LifecycleOwner;)V", "t", "()V", "Landroidx/lifecycle/LifecycleOwner;", "Z", "", "Lcom/stepos/ailauncher/chat/view/GlassAttachment;", "attachments", "Ljava/util/List;", "released", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.b6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2773b6 implements InterfaceC1387e {
    private final List<GlassAttachment> attachments;
    private final boolean crossWindow;
    private final LifecycleOwner owner;
    private boolean released;

    public C2773b6(LifecycleOwner owner, boolean z10) {
        kotlin.jvm.internal.p.i(owner, "owner");
        this.owner = owner;
        this.crossWindow = z10;
        this.attachments = new ArrayList();
        owner.getLifecycle().a(this);
    }

    public static /* synthetic */ C2773b6 h(C2773b6 c2773b6, View view, InterfaceC5074l interfaceC5074l, y7.o oVar, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            oVar = y7.o.INSTANCE.l();
        }
        if ((i10 & 8) != 0) {
            z10 = c2773b6.crossWindow;
        }
        return c2773b6.g(view, interfaceC5074l, oVar, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C2773b6 j(C2773b6 c2773b6, View[] viewArr, y7.C c10, Float f10, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            c10 = G.a.f43886a.f();
        }
        if ((i10 & 4) != 0) {
            f10 = null;
        }
        if ((i10 & 8) != 0) {
            interfaceC5074l = null;
        }
        return c2773b6.i(viewArr, c10, f10, interfaceC5074l);
    }

    public static final Y8.t k(Float f10, View view) {
        if (f10 != null) {
            C2851i7.INSTANCE.b(view, f10.floatValue());
        }
        return Y8.t.f7040a;
    }

    public static final y7.E m(y7.C c10, InterfaceC5074l interfaceC5074l, View v10, boolean z10, Float f10, y7.o oVar) {
        kotlin.jvm.internal.p.i(v10, "v");
        kotlin.jvm.internal.p.i(oVar, "<unused var>");
        return C2851i7.INSTANCE.e(v10, z10, c10, interfaceC5074l);
    }

    public static /* synthetic */ C2773b6 p(C2773b6 c2773b6, View[] viewArr, y7.o oVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            oVar = y7.o.INSTANCE.l();
        }
        if ((i10 & 4) != 0) {
            z10 = c2773b6.crossWindow;
        }
        return c2773b6.o(viewArr, oVar, z10);
    }

    public static final float q(View it) {
        kotlin.jvm.internal.p.i(it, "it");
        return (it.getHeight() / 2.0f) / it.getResources().getDisplayMetrics().density;
    }

    public static final float r(View it) {
        kotlin.jvm.internal.p.i(it, "it");
        return (it.getHeight() / 2.0f) / it.getResources().getDisplayMetrics().density;
    }

    public static final y7.E s(p9.q qVar, View v10, boolean z10, Float f10, y7.o oVar) {
        kotlin.jvm.internal.p.i(v10, "v");
        kotlin.jvm.internal.p.i(oVar, "<unused var>");
        return (y7.E) qVar.invoke(v10, Boolean.valueOf(z10), f10);
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void b(LifecycleOwner lifecycleOwner) {
        super.b(lifecycleOwner);
    }

    public final C2773b6 g(View target, InterfaceC5074l<? super View, Float> cornerRadiusDp, y7.o effect, boolean crossWindow) {
        kotlin.jvm.internal.p.i(target, "target");
        kotlin.jvm.internal.p.i(cornerRadiusDp, "cornerRadiusDp");
        kotlin.jvm.internal.p.i(effect, "effect");
        if (!this.released) {
            this.attachments.add(new GlassAttachment(target, crossWindow, cornerRadiusDp, null, effect, null, 40, null).t());
        }
        return this;
    }

    public final C2773b6 i(View[] targets, final y7.C<A7.B> preset, final Float topCornerRadiusDp, final InterfaceC5074l<? super A7.B, Y8.t> configure) {
        kotlin.jvm.internal.p.i(targets, "targets");
        kotlin.jvm.internal.p.i(preset, "preset");
        for (final View view : targets) {
            if (!this.released) {
                this.attachments.add(new GlassAttachment(view, this.crossWindow, null, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.W5
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return C2773b6.k(topCornerRadiusDp, view);
                    }
                }, null, new p9.r() { // from class: com.stepos.ailauncher.chat.view.X5
                    @Override // p9.r
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return C2773b6.m(preset, configure, (View) obj, ((Boolean) obj2).booleanValue(), (Float) obj3, (y7.o) obj4);
                    }
                }, 20, null).t());
            }
        }
        return this;
    }

    public final C2773b6 n(View[] targets, final p9.q<? super View, ? super Boolean, ? super Float, y7.E> materialFactory) {
        kotlin.jvm.internal.p.i(targets, "targets");
        kotlin.jvm.internal.p.i(materialFactory, "materialFactory");
        for (View view : targets) {
            if (!this.released) {
                this.attachments.add(new GlassAttachment(view, this.crossWindow, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.Y5
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return Float.valueOf(C2773b6.r((View) obj));
                    }
                }, null, null, new p9.r() { // from class: com.stepos.ailauncher.chat.view.Z5
                    @Override // p9.r
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return C2773b6.s(materialFactory, (View) obj, ((Boolean) obj2).booleanValue(), (Float) obj3, (y7.o) obj4);
                    }
                }, 24, null).t());
            }
        }
        return this;
    }

    public final C2773b6 o(View[] targets, y7.o effect, boolean crossWindow) {
        kotlin.jvm.internal.p.i(targets, "targets");
        kotlin.jvm.internal.p.i(effect, "effect");
        for (View view : targets) {
            g(view, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.a6
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Float.valueOf(C2773b6.q((View) obj));
                }
            }, effect, crossWindow);
        }
        return this;
    }

    @Override // android.view.InterfaceC1387e
    public void onDestroy(LifecycleOwner owner) {
        kotlin.jvm.internal.p.i(owner, "owner");
        t();
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void onPause(LifecycleOwner lifecycleOwner) {
        super.onPause(lifecycleOwner);
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void onResume(LifecycleOwner lifecycleOwner) {
        super.onResume(lifecycleOwner);
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void onStart(LifecycleOwner lifecycleOwner) {
        super.onStart(lifecycleOwner);
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void onStop(LifecycleOwner lifecycleOwner) {
        super.onStop(lifecycleOwner);
    }

    public final void t() {
        this.released = true;
        Iterator<T> it = this.attachments.iterator();
        while (it.hasNext()) {
            ((GlassAttachment) it.next()).n();
        }
        this.attachments.clear();
        this.owner.getLifecycle().d(this);
    }

    public final void u(boolean suspended) {
        if (this.released) {
            return;
        }
        Iterator<T> it = this.attachments.iterator();
        while (it.hasNext()) {
            ((GlassAttachment) it.next()).s(suspended);
        }
    }

    public /* synthetic */ C2773b6(LifecycleOwner lifecycleOwner, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this(lifecycleOwner, (i10 & 2) != 0 ? false : z10);
    }
}
