package com.stepos.ailauncher.agent.aispace.skill.wecom;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.dynamicanimation.animation.e;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import p9.InterfaceC5063a;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\fJG\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\fR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010&\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/V;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", UxipConstants.f30640D, "()V", DidiCardProvider.ACTION_DISMISS, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Landroid/view/View;", "view", "Landroidx/dynamicanimation/animation/e$s;", "property", "", "to", "stiffness", "dampingRatio", "Lkotlin/Function0;", "onEnd", "l", "(Landroid/view/View;Landroidx/dynamicanimation/animation/e$s;FFFLp9/a;)V", "n", "(FLp9/a;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "card", "Landroid/view/View;", "", "exitRunning", "Z", "Ljava/util/ArrayList;", "Landroidx/dynamicanimation/animation/i;", "Lkotlin/collections/ArrayList;", "springs", "Ljava/util/ArrayList;", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class V extends Dialog {

    @Deprecated
    public static final float ALPHA_DAMPING = 0.9f;

    @Deprecated
    public static final float ALPHA_STIFFNESS = 900.0f;
    private static final a Companion = new a(null);

    @Deprecated
    public static final float DIM_TO = 0.5f;

    @Deprecated
    public static final float SCALE_DAMPING = 0.65f;

    @Deprecated
    public static final float SCALE_FROM = 0.8f;

    @Deprecated
    public static final float SCALE_STIFFNESS = 198.34f;

    @Deprecated
    public static final float SCALE_TO = 1.0f;
    private View card;
    private boolean exitRunning;
    private final ArrayList<androidx.dynamicanimation.animation.i> springs;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/V$a;", "", "<init>", "()V", "", "SCALE_FROM", "F", "SCALE_TO", "SCALE_STIFFNESS", "SCALE_DAMPING", "ALPHA_STIFFNESS", "ALPHA_DAMPING", "DIM_TO", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(Context context) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        kotlin.jvm.internal.p.i(context, "context");
        this.springs = new ArrayList<>(4);
    }

    public static final Y8.t h(Ref$IntRef ref$IntRef, V v10) {
        int i10 = ref$IntRef.f34818a - 1;
        ref$IntRef.f34818a = i10;
        if (i10 == 0) {
            v10.g();
            v10.card = null;
            super.dismiss();
        }
        return Y8.t.f7040a;
    }

    public static final void i(V v10, View view) {
        v10.dismiss();
    }

    public static final void k(V v10, View view) {
        if (!v10.isShowing() || v10.exitRunning) {
            return;
        }
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 2.0f);
        e.s SCALE_X = androidx.dynamicanimation.animation.e.f13693q;
        kotlin.jvm.internal.p.h(SCALE_X, "SCALE_X");
        v10.l(view, SCALE_X, 1.0f, 198.34f, 0.65f, null);
        e.s SCALE_Y = androidx.dynamicanimation.animation.e.f13694r;
        kotlin.jvm.internal.p.h(SCALE_Y, "SCALE_Y");
        v10.l(view, SCALE_Y, 1.0f, 198.34f, 0.65f, null);
        e.s ALPHA = androidx.dynamicanimation.animation.e.f13701y;
        kotlin.jvm.internal.p.h(ALPHA, "ALPHA");
        v10.l(view, ALPHA, 1.0f, 900.0f, 0.9f, null);
        v10.n(0.5f, null);
    }

    public static final void m(InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        if (z10) {
            return;
        }
        interfaceC5063a.invoke();
    }

    public static final void o(V v10, Window window, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        if (v10.isShowing()) {
            window.setDimAmount(C5685n.m(f10, 0.0f, 0.5f));
        }
    }

    public static final void p(InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        if (z10) {
            return;
        }
        interfaceC5063a.invoke();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        View view = this.card;
        if (view == null || !isShowing() || view.getWidth() == 0) {
            g();
            super.dismiss();
            return;
        }
        if (this.exitRunning) {
            return;
        }
        this.exitRunning = true;
        g();
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.f34818a = 3;
        InterfaceC5063a<Y8.t> interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.Q
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return V.h(ref$IntRef, this);
            }
        };
        e.s SCALE_X = androidx.dynamicanimation.animation.e.f13693q;
        kotlin.jvm.internal.p.h(SCALE_X, "SCALE_X");
        l(view, SCALE_X, 0.8f, 198.34f, 0.65f, interfaceC5063a);
        e.s SCALE_Y = androidx.dynamicanimation.animation.e.f13694r;
        kotlin.jvm.internal.p.h(SCALE_Y, "SCALE_Y");
        l(view, SCALE_Y, 0.8f, 198.34f, 0.65f, null);
        e.s ALPHA = androidx.dynamicanimation.animation.e.f13701y;
        kotlin.jvm.internal.p.h(ALPHA, "ALPHA");
        l(view, ALPHA, 0.0f, 900.0f, 0.9f, interfaceC5063a);
        n(0.0f, interfaceC5063a);
    }

    public final void g() {
        Iterator<T> it = this.springs.iterator();
        while (it.hasNext()) {
            ((androidx.dynamicanimation.animation.i) it.next()).d();
        }
        this.springs.clear();
    }

    public final void j() {
        final View view = this.card;
        if (view == null) {
            return;
        }
        this.exitRunning = false;
        view.setAlpha(0.0f);
        view.setScaleX(0.8f);
        view.setScaleY(0.8f);
        view.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.P
            @Override // java.lang.Runnable
            public final void run() {
                V.k(this.f24296a, view);
            }
        });
    }

    public final void l(View view, e.s property, float to, float stiffness, float dampingRatio, final InterfaceC5063a<Y8.t> onEnd) {
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(view, property, to);
        iVar.B(new androidx.dynamicanimation.animation.j(to).h(stiffness).f(dampingRatio));
        if (onEnd != null) {
            iVar.b(new e.q() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.S
                @Override // androidx.dynamicanimation.animation.e.q
                public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                    V.m(onEnd, eVar, z10, f10, f11);
                }
            });
        }
        this.springs.add(iVar);
        iVar.t();
    }

    public final void n(float to, final InterfaceC5063a<Y8.t> onEnd) {
        final Window window = getWindow();
        if (window == null) {
            if (onEnd != null) {
                onEnd.invoke();
                return;
            }
            return;
        }
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g(window.getAttributes().dimAmount));
        iVar.B(new androidx.dynamicanimation.animation.j(to).h(900.0f).f(0.9f));
        iVar.c(new e.r() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.T
            @Override // androidx.dynamicanimation.animation.e.r
            public final void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
                V.o(this.f24301a, window, eVar, f10, f11);
            }
        });
        if (onEnd != null) {
            iVar.b(new e.q() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.U
                @Override // androidx.dynamicanimation.animation.e.q
                public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                    V.p(onEnd, eVar, z10, f10, f11);
                }
            });
        }
        this.springs.add(iVar);
        iVar.t();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        Y4.q qVarC = Y4.q.c(getLayoutInflater());
        kotlin.jvm.internal.p.h(qVarC, "inflate(...)");
        this.card = qVarC.b();
        setContentView(qVarC.b());
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.addFlags(2);
            float f10 = window.getContext().getResources().getDisplayMetrics().density;
            int iB = C5227b.b(20.0f * f10);
            int iB2 = C5227b.b(f10 * 356.0f);
            WindowManager windowManager = (WindowManager) window.getContext().getSystemService(WindowManager.class);
            Integer num = null;
            if (windowManager != null && (currentWindowMetrics = windowManager.getCurrentWindowMetrics()) != null && (bounds = currentWindowMetrics.getBounds()) != null) {
                Integer numValueOf = Integer.valueOf(bounds.width());
                if (numValueOf.intValue() > 0) {
                    num = numValueOf;
                }
            }
            window.setLayout(Math.min(iB2, C5685n.f((num != null ? num.intValue() : window.getContext().getResources().getDisplayMetrics().widthPixels) - (iB * 2), 0)), -2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.0f;
            attributes.gravity = 17;
            window.setAttributes(attributes);
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1792);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        qVarC.btnLater.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.O
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                V.i(this.f24295a, view);
            }
        });
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        j();
    }
}
