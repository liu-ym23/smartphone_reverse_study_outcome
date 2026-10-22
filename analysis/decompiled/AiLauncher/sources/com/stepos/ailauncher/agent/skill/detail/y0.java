package com.stepos.ailauncher.agent.skill.detail;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$layout;
import com.stepos.ailauncher.agent.R$string;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import y7.G;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J!\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0003R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 ¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/detail/y0;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "LY8/t;", "I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "hidden", "onHiddenChanged", "(Z)V", "onResume", "onPause", "onDestroyView", "LY4/u;", "binding", "LY4/u;", "Lu8/e;", "markwon$delegate", "LY8/h;", "K", "()Lu8/e;", "markwon", "Ly7/E;", "backGlassHandle", "Ly7/E;", "e", "()Z", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class y0 extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_MARKDOWN = "markdown";
    private static final String ARG_TITLE = "title";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private y7.E backGlassHandle;
    private Y4.u binding;

    /* renamed from: markwon$delegate, reason: from kotlin metadata */
    private final Y8.h markwon;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/detail/y0$a;", "", "<init>", "()V", "", y0.ARG_MARKDOWN, "title", "Lcom/stepos/ailauncher/agent/skill/detail/y0;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/agent/skill/detail/y0;", "ARG_TITLE", "Ljava/lang/String;", "ARG_MARKDOWN", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.skill.detail.y0$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final y0 a(String markdown, String title) {
            kotlin.jvm.internal.p.i(markdown, "markdown");
            y0 y0Var = new y0();
            Bundle bundle = new Bundle();
            bundle.putString(y0.ARG_MARKDOWN, markdown);
            if (title != null && !La.H.x0(title)) {
                bundle.putString("title", title);
            }
            y0Var.setArguments(bundle);
            return y0Var;
        }

        public Companion() {
        }
    }

    public y0() {
        super(R$layout.fragment_skill_readme);
        this.markwon = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.detail.r0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return y0.L(this.f24397a);
            }
        });
    }

    private final void I() {
        if (this.backGlassHandle != null || isHidden()) {
            return;
        }
        Y4.u uVar = this.binding;
        if (uVar == null) {
            kotlin.jvm.internal.p.A("binding");
            uVar = null;
        }
        ImageView ivBack = uVar.ivBack;
        kotlin.jvm.internal.p.h(ivBack, "ivBack");
        if (ivBack.isAttachedToWindow()) {
            com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
            y7.E eM = com.stepos.ailauncher.container.glass.h.m(hVar, ivBack, false, Float.valueOf(22.0f), y7.o.INSTANCE.i(), false, 16, null);
            this.backGlassHandle = eM;
            hVar.G(ivBack, eM, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.detail.x0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return y0.J(this.f24409a, (y7.E) obj);
                }
            });
        }
    }

    public static final Y8.t J(y0 y0Var, y7.E released) {
        kotlin.jvm.internal.p.i(released, "released");
        if (y0Var.backGlassHandle == released) {
            y0Var.backGlassHandle = null;
        }
        return Y8.t.f7040a;
    }

    private final u8.e K() {
        return (u8.e) this.markwon.getValue();
    }

    public static final u8.e L(y0 y0Var) {
        Context contextRequireContext = y0Var.requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        return SkillMarkwonFactoryKt.b(contextRequireContext);
    }

    public static final void M(y0 y0Var) {
        y0Var.I();
    }

    public static final void N(y0 y0Var) {
        y0Var.I();
    }

    public static final void O(y0 y0Var, View view) {
        if (y0Var.x()) {
            return;
        }
        y0Var.o();
    }

    public static final void P(y0 y0Var) {
        y0Var.I();
    }

    public static final void Q(y0 y0Var) {
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        Y4.u uVar = y0Var.binding;
        if (uVar == null) {
            kotlin.jvm.internal.p.A("binding");
            uVar = null;
        }
        View topChromeBlur = uVar.topChromeBlur;
        kotlin.jvm.internal.p.h(topChromeBlur, "topChromeBlur");
        com.stepos.ailauncher.container.glass.h.v(hVar, topChromeBlur, false, G.a.f43886a.g(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.detail.w0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return y0.R((A7.B) obj);
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t R(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean e() {
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        com.stepos.ailauncher.container.glass.h.INSTANCE.F(this.backGlassHandle);
        this.backGlassHandle = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Y4.u uVar = null;
        if (hidden) {
            com.stepos.ailauncher.container.glass.h.INSTANCE.F(this.backGlassHandle);
            this.backGlassHandle = null;
            return;
        }
        Y4.u uVar2 = this.binding;
        if (uVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            uVar = uVar2;
        }
        uVar.ivBack.post(new Runnable() { // from class: com.stepos.ailauncher.agent.skill.detail.s0
            @Override // java.lang.Runnable
            public final void run() {
                y0.M(this.f24399a);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        com.stepos.ailauncher.container.glass.h.INSTANCE.F(this.backGlassHandle);
        this.backGlassHandle = null;
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Y4.u uVar = this.binding;
        if (uVar == null) {
            kotlin.jvm.internal.p.A("binding");
            uVar = null;
        }
        uVar.ivBack.post(new Runnable() { // from class: com.stepos.ailauncher.agent.skill.detail.q0
            @Override // java.lang.Runnable
            public final void run() {
                y0.N(this.f24394a);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Y4.u uVarA = Y4.u.a(view);
        kotlin.jvm.internal.p.h(uVarA, "bind(...)");
        this.binding = uVarA;
        Y4.u uVar = null;
        if (uVarA == null) {
            kotlin.jvm.internal.p.A("binding");
            uVarA = null;
        }
        uVarA.root.setBackgroundColor(-15658735);
        Y4.u uVar2 = this.binding;
        if (uVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            uVar2 = null;
        }
        uVar2.root.setFitsSystemWindows(false);
        Y4.u uVar3 = this.binding;
        if (uVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            uVar3 = null;
        }
        FrameLayout root = uVar3.root;
        kotlin.jvm.internal.p.h(root, "root");
        com.stepos.ailauncher.container.glass.k.b(root, 0, 1, null);
        Y4.u uVar4 = this.binding;
        if (uVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            uVar4 = null;
        }
        TextView textView = uVar4.tvTitle;
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("title") : null;
        if (string == null) {
            string = "";
        }
        if (La.H.x0(string)) {
            string = getString(R$string.skill_detail_section_readme);
            kotlin.jvm.internal.p.h(string, "getString(...)");
        }
        textView.setText(string);
        u8.e eVarK = K();
        Y4.u uVar5 = this.binding;
        if (uVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
            uVar5 = null;
        }
        TextView textView2 = uVar5.tvReadmeFull;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString(ARG_MARKDOWN) : null;
        String str = string2 != null ? string2 : "";
        if (La.H.x0(str)) {
            str = "—";
        }
        eVarK.f(textView2, str);
        Y4.u uVar6 = this.binding;
        if (uVar6 == null) {
            kotlin.jvm.internal.p.A("binding");
            uVar6 = null;
        }
        uVar6.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.detail.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                y0.O(this.f24400a, view2);
            }
        });
        Y4.u uVar7 = this.binding;
        if (uVar7 == null) {
            kotlin.jvm.internal.p.A("binding");
            uVar7 = null;
        }
        uVar7.ivBack.post(new Runnable() { // from class: com.stepos.ailauncher.agent.skill.detail.u0
            @Override // java.lang.Runnable
            public final void run() {
                y0.P(this.f24403a);
            }
        });
        Y4.u uVar8 = this.binding;
        if (uVar8 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            uVar = uVar8;
        }
        uVar.topChromeBlur.post(new Runnable() { // from class: com.stepos.ailauncher.agent.skill.detail.v0
            @Override // java.lang.Runnable
            public final void run() {
                y0.Q(this.f24406a);
            }
        });
    }
}
