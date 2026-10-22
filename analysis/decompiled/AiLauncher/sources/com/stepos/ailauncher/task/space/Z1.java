package com.stepos.ailauncher.task.space;

import android.os.Bundle;
import android.view.LifecycleOwner;
import android.view.View;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.R$string;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import y7.G;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/task/space/Z1;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "showsSheetDragHandle", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Z1 extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_IS_SKILL = "is_skill";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String NAV_TAG = "test_space_guide";

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/task/space/Z1$a;", "", "<init>", "()V", "", "isSkill", "Lcom/stepos/ailauncher/task/space/Z1;", Const.INTENT_KEY_APIKEY, "(Z)Lcom/stepos/ailauncher/task/space/Z1;", "", "NAV_TAG", "Ljava/lang/String;", "ARG_IS_SKILL", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.Z1$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Z1 a(boolean isSkill) {
            Z1 z12 = new Z1();
            Bundle bundle = new Bundle();
            bundle.putBoolean(Z1.ARG_IS_SKILL, isSkill);
            z12.setArguments(bundle);
            return z12;
        }

        public Companion() {
        }
    }

    public Z1() {
        super(R$layout.fragment_test_space_guide);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t C(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final void D(Z1 z12, View view) {
        if (z12.x()) {
            return;
        }
        z12.o();
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        com.stepos.ailauncher.container.glass.k.b(view, 0, 1, null);
        View viewFindViewById = view.findViewById(R$id.btnBack);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, null);
        kotlin.jvm.internal.p.f(viewFindViewById);
        C2773b6 c2773b6P = C2773b6.p(c2773b6, new View[]{viewFindViewById}, null, false, 6, null);
        View viewFindViewById2 = view.findViewById(R$id.topChromeBlur);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        C2773b6.j(c2773b6P, new View[]{viewFindViewById2}, G.a.f43886a.g(), null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.X1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Z1.C((A7.B) obj);
            }
        }, 4, null);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.Y1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Z1.D(this.f28900a, view2);
            }
        });
        Bundle arguments = getArguments();
        boolean z10 = arguments != null ? arguments.getBoolean(ARG_IS_SKILL, true) : true;
        C3577a2.INSTANCE.g(z10 ? C3577a2.TYPE_SKILL : "agent");
        ((TextView) view.findViewById(R$id.tvTitle)).setText(z10 ? R$string.test_space_guide_skill : R$string.test_space_guide_agent_title);
        ((TextView) view.findViewById(R$id.tvStep1Title)).setText(z10 ? R$string.test_space_guide_skill_step1_title : R$string.test_space_guide_agent_step1_title);
        ((TextView) view.findViewById(R$id.tvStep1Desc)).setText(z10 ? R$string.test_space_guide_skill_step1_desc : R$string.test_space_guide_agent_step1_desc);
        ((TextView) view.findViewById(R$id.tvStep2Title)).setText(z10 ? R$string.test_space_guide_skill_step2_title : R$string.test_space_guide_agent_step2_title);
        ((TextView) view.findViewById(R$id.tvStep2Desc)).setText(z10 ? R$string.test_space_guide_skill_step2_desc : R$string.test_space_guide_agent_step2_desc);
        view.findViewById(R$id.promptCard).setVisibility(z10 ? 0 : 8);
    }
}
