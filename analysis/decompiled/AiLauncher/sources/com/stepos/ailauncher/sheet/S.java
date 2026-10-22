package com.stepos.ailauncher.sheet;

import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H$¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0015¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u001eH\u0015¢\u0006\u0004\b#\u0010!J\u0017\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020$H\u0015¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\fH\u0016¢\u0006\u0004\b(\u0010\u0003J\u000f\u0010)\u001a\u00020$H\u0014¢\u0006\u0004\b)\u0010*J\u0019\u0010,\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0011\u00103\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/stepos/ailauncher/sheet/S;", "Lcom/stepos/ailauncher/sheet/O;", "<init>", "()V", "Landroidx/fragment/app/Fragment;", "s4", "()Landroidx/fragment/app/Fragment;", "", "z4", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "y4", "(Landroid/os/Bundle;)V", "Landroid/widget/FrameLayout;", "slot", AMapLocationStaticsEntity.IPV4, "(Landroid/widget/FrameLayout;)V", "Lkotlin/Function0;", "block", "A4", "(Lp9/a;)V", "container", "F2", "(Landroid/widget/FrameLayout;Landroid/os/Bundle;)V", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "S2", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", "", "fraction", "R2", "(F)V", "progress", "P2", "", "keyboardVisible", "I2", "(Z)V", "u4", "N2", "()Z", "top", "r4", "(Landroidx/fragment/app/Fragment;)V", "Lcom/stepos/ailauncher/sheet/nav/h;", "_fragments", "Lcom/stepos/ailauncher/sheet/nav/h;", "t4", "()Lcom/stepos/ailauncher/sheet/nav/h;", "fragments", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class S extends O {
    private com.stepos.ailauncher.sheet.nav.h _fragments;

    public static final Y8.t w4(S s10, Fragment fragment) {
        s10.r4(fragment);
        return Y8.t.f7040a;
    }

    public static final Y8.t x4(S s10) {
        com.stepos.ailauncher.sheet.nav.h hVar = s10._fragments;
        if (hVar != null) {
            hVar.L(s10.s4(), s10.z4());
        }
        return Y8.t.f7040a;
    }

    public void A4(InterfaceC5063a<Y8.t> block) {
        kotlin.jvm.internal.p.i(block, "block");
        block.invoke();
    }

    @Override // com.stepos.ailauncher.sheet.O
    public final void F2(FrameLayout container, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(container, "container");
        FragmentContainerView fragmentContainerView = new FragmentContainerView(this);
        int i10 = R$id.ail_fragment_container;
        fragmentContainerView.setId(i10);
        fragmentContainerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        container.addView(fragmentContainerView);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(R$id.ail_resident_bottom_slot);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 80));
        frameLayout.setClipChildren(false);
        if (U1()) {
            frameLayout.setElevation(Y1().getElevation());
            Z1().addView(frameLayout);
        } else {
            container.addView(frameLayout);
        }
        K3(frameLayout);
        if (!U1()) {
            X1().setMinifyContentView(frameLayout);
        }
        com.stepos.ailauncher.sheet.nav.h hVar = new com.stepos.ailauncher.sheet.nav.h(this, i10, null, 4, null);
        hVar.n(this);
        hVar.K(new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.P
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return S.w4(this.f27681a, (Fragment) obj);
            }
        });
        this._fragments = hVar;
        v4(frameLayout);
        if (savedInstanceState == null) {
            A4(new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.Q
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return S.x4(this.f27682a);
                }
            });
        }
        y4(savedInstanceState);
    }

    @Override // com.stepos.ailauncher.sheet.O
    public void I2(boolean keyboardVisible) {
        super.I2(keyboardVisible);
        com.stepos.ailauncher.sheet.nav.h hVar = this._fragments;
        Fragment fragmentW = hVar != null ? hVar.w() : null;
        com.stepos.ailauncher.sheet.nav.d dVar = fragmentW instanceof com.stepos.ailauncher.sheet.nav.d ? (com.stepos.ailauncher.sheet.nav.d) fragmentW : null;
        if (dVar != null) {
            dVar.h(keyboardVisible);
        }
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean N2() {
        if (getPreviewMode()) {
            O.C1(this, false, 1, null);
            return true;
        }
        com.stepos.ailauncher.sheet.nav.h hVar = this._fragments;
        if (hVar == null || !hVar.B()) {
            return super.N2();
        }
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public void P2(float progress) {
        super.P2(progress);
        com.stepos.ailauncher.sheet.nav.h hVar = this._fragments;
        if (hVar != null) {
            hVar.r(progress);
        }
    }

    @Override // com.stepos.ailauncher.sheet.O
    public void R2(float fraction) {
        super.R2(fraction);
        com.stepos.ailauncher.sheet.nav.h hVar = this._fragments;
        if (hVar != null) {
            hVar.s(fraction);
        }
    }

    @Override // com.stepos.ailauncher.sheet.O
    public void S2(SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
        super.S2(state);
        com.stepos.ailauncher.sheet.nav.h hVar = this._fragments;
        if (hVar != null) {
            hVar.t(state);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r4(Fragment top) {
        com.stepos.ailauncher.sheet.nav.d dVar = top instanceof com.stepos.ailauncher.sheet.nav.d ? (com.stepos.ailauncher.sheet.nav.d) top : null;
        M3(dVar != null ? dVar.j() : true);
        O3(dVar != null ? dVar.c() : true);
        L3(dVar != null ? dVar.e() : false);
    }

    public abstract Fragment s4();

    public final com.stepos.ailauncher.sheet.nav.h t4() {
        com.stepos.ailauncher.sheet.nav.h hVar = this._fragments;
        if (hVar != null) {
            return hVar;
        }
        throw new IllegalStateException("SheetFragmentNavigator not ready; only use after onCreateSheetContent");
    }

    public void u4() {
    }

    public void v4(FrameLayout slot) {
        kotlin.jvm.internal.p.i(slot, "slot");
    }

    public void y4(Bundle savedInstanceState) {
    }

    public String z4() {
        return com.stepos.ailauncher.sheet.nav.h.DEFAULT_ROOT_TAG;
    }
}
