package com.stepos.ailauncher.task.space;

import android.content.Context;
import android.os.Bundle;
import android.view.LifecycleOwner;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.space.AmooMemoryActivity;
import com.stepos.ailauncher.task.space.C3688x1;
import com.stepos.ailauncher.task.space.credential.ThirdPartyAuthListFragment;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import y7.G;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\u0012\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/task/space/D0;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "N", "(Landroid/view/View;)V", "", "tab", "scanSource", "scanType", "assetId", "H", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "showsSheetDragHandle", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class D0 extends com.stepos.ailauncher.sheet.nav.a {
    private static final long AUTO_OPEN_DELAY_MS = 500;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/task/space/D0$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/task/space/D0;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/task/space/D0;", "", "AUTO_OPEN_DELAY_MS", "J", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.D0$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final D0 a() {
            return new D0();
        }

        public Companion() {
        }
    }

    public D0() {
        super(R$layout.fragment_repair_root);
    }

    public static /* synthetic */ void I(D0 d02, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        if ((i10 & 8) != 0) {
            str4 = null;
        }
        d02.H(str, str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t J(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final Y8.t K(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final void L(D0 d02, View view) {
        d02.o();
    }

    public static final void M(D0 d02, C3688x1.PendingOpen pendingOpen) {
        d02.H(pendingOpen.getTab(), pendingOpen.getScanSource(), pendingOpen.getScanType(), pendingOpen.getAssetId());
    }

    public static final Y8.t O(D0 d02) {
        AmooMemoryActivity.Companion aVar = AmooMemoryActivity.INSTANCE;
        Context contextRequireContext = d02.requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        aVar.a(contextRequireContext);
        return Y8.t.f7040a;
    }

    public static final Y8.t P(D0 d02) {
        com.stepos.ailauncher.sheet.nav.a.z(d02, ThirdPartyAuthListFragment.INSTANCE.a(com.stepos.ailauncher.task.space.credential.P.ENTRY_REPAIR), ThirdPartyAuthListFragment.NAV_TAG, null, null, null, 28, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t Q(D0 d02) {
        I(d02, null, null, null, null, 15, null);
        return Y8.t.f7040a;
    }

    public final void H(String tab, String scanSource, String scanType, String assetId) {
        com.stepos.ailauncher.sheet.nav.a.z(this, TestSpaceFragment.INSTANCE.a(tab, scanSource, scanType, assetId), TestSpaceFragment.NAV_TAG, null, null, null, 28, null);
    }

    public final void N(View view) {
        RepairTabView repairTabView = (RepairTabView) view.findViewById(R$id.repair_content);
        repairTabView.setOnNavigateToMemory(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.A0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return D0.O(this.f28775a);
            }
        });
        repairTabView.setOnNavigateToThirdPartyAuth(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.B0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return D0.P(this.f28780a);
            }
        });
        repairTabView.setOnNavigateToTestSpace(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.C0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return D0.Q(this.f28786a);
            }
        });
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
        View viewFindViewById = view.findViewById(R$id.btn_close);
        View viewFindViewById2 = view.findViewById(R$id.ll_repair_top);
        View viewFindViewById3 = view.findViewById(R$id.v_repair_bottom_fade);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, null);
        kotlin.jvm.internal.p.f(viewFindViewById);
        C2773b6.p(c2773b6, new View[]{viewFindViewById}, null, false, 6, null);
        kotlin.jvm.internal.p.f(viewFindViewById2);
        C2773b6.j(c2773b6, new View[]{viewFindViewById2}, G.a.f43886a.g(), null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.w0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return D0.J((A7.B) obj);
            }
        }, 4, null);
        kotlin.jvm.internal.p.f(viewFindViewById3);
        C2773b6.j(c2773b6, new View[]{viewFindViewById3}, null, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.x0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return D0.K((A7.B) obj);
            }
        }, 6, null);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                D0.L(this.f29138a, view2);
            }
        });
        N(view);
        final C3688x1.PendingOpen pendingOpenA = C3688x1.INSTANCE.a();
        if (pendingOpenA != null) {
            view.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.task.space.z0
                @Override // java.lang.Runnable
                public final void run() {
                    D0.M(this.f29145a, pendingOpenA);
                }
            }, 500L);
        }
    }
}
