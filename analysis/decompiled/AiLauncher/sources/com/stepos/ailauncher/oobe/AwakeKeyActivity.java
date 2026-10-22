package com.stepos.ailauncher.oobe;

import L4.AgentPlace;
import L4.b;
import L4.l;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Property;
import android.view.View;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.AbstractC1417G;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentsprite.view.AgentView;
import com.stepos.ailauncher.chat.wake.C3119f;
import com.stepos.ailauncher.chat.wake.effect.SpectrumBorderConfig;
import com.stepos.ailauncher.oobe.N;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import f6.C4059a;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/oobe/AwakeKeyActivity;", "Lb/q;", "<init>", "()V", "LY8/t;", "z", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", UxipConstants.f30640D, "onStop", "onDestroy", "L", "P", "O", "D", "C", "M", "LL4/b;", "ctrl$delegate", "LY8/h;", "B", "()LL4/b;", "ctrl", "Landroid/animation/ObjectAnimator;", "indicatorAnimator", "Landroid/animation/ObjectAnimator;", "Lcom/stepos/ailauncher/chat/wake/effect/g;", "spectrumBorder", "Lcom/stepos/ailauncher/chat/wake/effect/g;", "Companion", Const.INTENT_KEY_APIKEY, "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AwakeKeyActivity extends b.q {
    private static final SpectrumBorderConfig SPECTRUM_BORDER_CONFIG = new SpectrumBorderConfig(1.8f, 0.045f, 0.12f, 0.5f, 1.8f, 0.045f, 0.12f, 0.5f);
    private static final long SPECTRUM_BORDER_DURATION_MS = 3500;
    private static final long SPECTRUM_BORDER_FADE_OUT_MS = 1500;

    /* renamed from: ctrl$delegate, reason: from kotlin metadata */
    private final Y8.h ctrl = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.oobe.B
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return AwakeKeyActivity.A(this.f27531a);
        }
    });
    private ObjectAnimator indicatorAnimator;
    private com.stepos.ailauncher.chat.wake.effect.g spectrumBorder;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/oobe/AwakeKeyActivity$b", "Lb/G;", "LY8/t;", "handleOnBackPressed", "()V", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends AbstractC1417G {
        public b() {
            super(true);
        }

        @Override // b.AbstractC1417G
        public void handleOnBackPressed() {
            AwakeKeyActivity.this.C();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c implements Runnable {
        final /* synthetic */ LinearLayout $root$inlined;
        final /* synthetic */ View $this_doOnPreDraw;
        final /* synthetic */ AwakeKeyActivity this$0;

        public c(View view, AwakeKeyActivity awakeKeyActivity, LinearLayout linearLayout) {
            this.$this_doOnPreDraw = view;
            this.this$0 = awakeKeyActivity;
            this.$root$inlined = linearLayout;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AwakeKeyActivity awakeKeyActivity = this.this$0;
            kotlin.jvm.internal.p.f(this.$root$inlined);
            com.stepos.ailauncher.chat.wake.effect.g gVar = new com.stepos.ailauncher.chat.wake.effect.g(this.$root$inlined, AwakeKeyActivity.SPECTRUM_BORDER_CONFIG);
            gVar.k(AwakeKeyActivity.SPECTRUM_BORDER_DURATION_MS, 1500L);
            awakeKeyActivity.spectrumBorder = gVar;
        }
    }

    public static final L4.b A(AwakeKeyActivity awakeKeyActivity) {
        return N4.a.d(awakeKeyActivity, null, null, null, null, null, 31, null);
    }

    public static final void E(AwakeKeyActivity awakeKeyActivity, View view) {
        awakeKeyActivity.finish();
    }

    public static final void F(AwakeKeyActivity awakeKeyActivity, View view) {
        awakeKeyActivity.C();
    }

    public static final void G(AwakeKeyActivity awakeKeyActivity, View view) {
        C4059a.e(C4059a.INSTANCE, "aikey_wakeup", "skip", null, 4, null);
        O.INSTANCE.e(awakeKeyActivity);
        awakeKeyActivity.M();
    }

    public static final void H(AwakeKeyActivity awakeKeyActivity, View view) {
        C4059a.e(C4059a.INSTANCE, "aikey_wakeup", "skip", null, 4, null);
        O.INSTANCE.e(awakeKeyActivity);
        awakeKeyActivity.M();
    }

    public static final void I(AwakeKeyActivity awakeKeyActivity, View view) {
        C4059a.e(C4059a.INSTANCE, "aikey_wakeup", "next", null, 4, null);
        O.INSTANCE.e(awakeKeyActivity);
        awakeKeyActivity.M();
    }

    public static final void J(AwakeKeyActivity awakeKeyActivity, View view) {
        C4059a.e(C4059a.INSTANCE, "aikey_wakeup", C4059a.BUTTON_CONTINUE, null, 4, null);
        O.INSTANCE.e(awakeKeyActivity);
        awakeKeyActivity.M();
    }

    public static final boolean K(AwakeKeyActivity awakeKeyActivity, Intent it) {
        kotlin.jvm.internal.p.i(it, "it");
        awakeKeyActivity.D();
        return true;
    }

    public static final void N(AwakeKeyActivity awakeKeyActivity) {
        ((LinearLayout) awakeKeyActivity.findViewById(R$id.container)).setVisibility(0);
        ((FrameLayout) awakeKeyActivity.findViewById(R$id.complete)).setVisibility(8);
        ((LinearLayout) awakeKeyActivity.findViewById(R$id.root)).setBackgroundResource(R$color.oobe_dark_bg);
    }

    private final void z() {
        int iC = androidx.core.content.a.c(this, R$color.oobe_dark_bg);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(iC);
        getWindow().setNavigationBarColor(iC);
        androidx.core.view.b0 b0Var = new androidx.core.view.b0(getWindow(), getWindow().getDecorView());
        b0Var.e(false);
        b0Var.d(false);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() & (-8209));
        com.stepos.ailauncher.common.utils.H.c(getWindow(), false);
    }

    public final L4.b B() {
        return (L4.b) this.ctrl.getValue();
    }

    @SuppressLint({"ResourceAsColor"})
    public final void C() {
        int i10 = R$id.container;
        View viewFindViewById = findViewById(i10);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        if (viewFindViewById.getVisibility() != 8) {
            finish();
            return;
        }
        P();
        ((LinearLayout) findViewById(i10)).setVisibility(0);
        ((FrameLayout) findViewById(R$id.complete)).setVisibility(8);
        ((LinearLayout) findViewById(R$id.root)).setBackgroundColor(R$color.oobe_dark_bg);
    }

    public final void D() {
        C4059a.INSTANCE.l("aikey_wakeup", "success");
        ((LinearLayout) findViewById(R$id.container)).setVisibility(8);
        ((FrameLayout) findViewById(R$id.complete)).setVisibility(0);
        ((LinearLayout) findViewById(R$id.root)).setBackgroundResource(R$drawable.oobe_awake_complete_glow);
        L();
    }

    public final void L() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.root);
        P();
        kotlin.jvm.internal.p.f(linearLayout);
        androidx.core.view.D.a(linearLayout, new c(linearLayout, this, linearLayout));
    }

    public final void M() {
        P();
        new Handler().postDelayed(new Runnable() { // from class: com.stepos.ailauncher.oobe.J
            @Override // java.lang.Runnable
            public final void run() {
                AwakeKeyActivity.N(this.f27545a);
            }
        }, 500L);
    }

    public final void O() {
        ImageView imageView = (ImageView) findViewById(R$id.indicator);
        ObjectAnimator objectAnimator = this.indicatorAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) View.ALPHA, 1.0f, 0.2f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.start();
        this.indicatorAnimator = objectAnimatorOfFloat;
    }

    public final void P() {
        com.stepos.ailauncher.chat.wake.effect.g gVar = this.spectrumBorder;
        if (gVar != null) {
            gVar.o();
        }
        this.spectrumBorder = null;
    }

    @Override // b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        N.Companion companion = N.INSTANCE;
        Window window = getWindow();
        kotlin.jvm.internal.p.h(window, "getWindow(...)");
        companion.a(window);
        C4059a.h(C4059a.INSTANCE, "aikey_wakeup", null, 2, null);
        setContentView(R$layout.oobe_activity_awake_key);
        z();
        ((ImageButton) findViewById(R$id.btn_back)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.C
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AwakeKeyActivity.E(this.f27533a, view);
            }
        });
        ((ImageButton) findViewById(R$id.btn_back2)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.D
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AwakeKeyActivity.F(this.f27535a, view);
            }
        });
        ((TextView) findViewById(R$id.tv_skip)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AwakeKeyActivity.G(this.f27537a, view);
            }
        });
        ((TextView) findViewById(R$id.tv_skip2)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.F
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AwakeKeyActivity.H(this.f27538a, view);
            }
        });
        ((Button) findViewById(R$id.btn_next)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.G
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AwakeKeyActivity.I(this.f27540a, view);
            }
        });
        ((Button) findViewById(R$id.btn_continue)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.H
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AwakeKeyActivity.J(this.f27542a, view);
            }
        });
        getOnBackPressedDispatcher().m(this, new b());
        AgentView agentView = (AgentView) findViewById(R$id.agent);
        kotlin.jvm.internal.p.f(agentView);
        AgentView.t(agentView, B(), null, 2, null);
        B().a(AgentPlace.e.INSTANCE);
        b.a.a(B(), l.E.INSTANCE, 0L, 0, 6, null);
        O();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        ObjectAnimator objectAnimator = this.indicatorAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.indicatorAnimator = null;
        P();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        C3119f.INSTANCE.b(new C3119f.a() { // from class: com.stepos.ailauncher.oobe.I
            @Override // com.stepos.ailauncher.chat.wake.C3119f.a
            public final boolean a(Intent intent) {
                return AwakeKeyActivity.K(this.f27544a, intent);
            }
        });
    }

    @Override // android.app.Activity
    public void onStop() {
        C3119f.INSTANCE.b(null);
        super.onStop();
    }
}
