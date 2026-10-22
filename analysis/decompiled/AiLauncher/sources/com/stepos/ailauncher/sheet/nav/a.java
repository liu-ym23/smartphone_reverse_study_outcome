package com.stepos.ailauncher.sheet.nav;

import Y8.t;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.r;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.sheet.O;
import com.stepos.ailauncher.sheet.S;
import com.stepos.ailauncher.sheet.SheetSettleState;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0013\b\u0016\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007JG\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0010H\u0004¢\u0006\u0004\b\u0016\u0010\u0004J\u0019\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u0013H\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u0013H\u0004¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0013H\u0016¢\u0006\u0004\b!\u0010\u0019R\u0016\u0010%\u001a\u0004\u0018\u00010\"8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u0004\u0018\u00010&8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\u00138DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0015R\u0016\u0010.\u001a\u0004\u0018\u00010\u001c8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u00100\u001a\u0004\u0018\u00010\u001c8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b/\u0010-¨\u00061"}, d2 = {"Lcom/stepos/ailauncher/sheet/nav/a;", "Landroidx/fragment/app/Fragment;", "Lcom/stepos/ailauncher/sheet/nav/d;", "<init>", "()V", "", "contentLayoutId", "(I)V", "fragment", "", "tag", "Landroid/os/Bundle;", "args", "name", "Lcom/stepos/ailauncher/sheet/nav/b;", "anim", "LY8/t;", "y", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;Lcom/stepos/ailauncher/sheet/nav/b;)V", "", "x", "()Z", "o", "allowOrientation", "p", "(Z)V", "animate", "q", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "k", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", "visible", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lcom/stepos/ailauncher/sheet/nav/h;", "u", "()Lcom/stepos/ailauncher/sheet/nav/h;", "sheetNavigator", "Lcom/stepos/ailauncher/sheet/S;", "t", "()Lcom/stepos/ailauncher/sheet/S;", "sheetHost", "w", "isSheetPreviewMode", "v", "()Lcom/stepos/ailauncher/sheet/SheetSettleState;", "sheetSettleState", "s", "sheetEffectiveSettleState", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public class a extends Fragment implements d {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sheet.nav.a$a, reason: collision with other inner class name */
    public static final /* synthetic */ class C0323a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SheetSettleState.values().length];
            try {
                iArr[SheetSettleState.HALF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SheetSettleState.FULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SheetSettleState.IMMERSIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public a() {
    }

    public static /* synthetic */ void r(a aVar, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exitSheetPreview");
        }
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        aVar.q(z10);
    }

    public static /* synthetic */ void z(a aVar, Fragment fragment, String str, Bundle bundle, String str2, SheetFragmentAnim sheetFragmentAnim, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pushSheetFragment");
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            bundle = null;
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        if ((i10 & 16) != 0) {
            sheetFragmentAnim = null;
        }
        aVar.y(fragment, str, bundle, str2, sheetFragmentAnim);
    }

    public /* bridge */ boolean c() {
        return super.c();
    }

    @Override // com.stepos.ailauncher.sheet.nav.d
    public /* bridge */ void d(float f10) {
        super.d(f10);
    }

    public /* bridge */ boolean e() {
        return super.e();
    }

    public /* bridge */ void f(float f10) {
        super.f(f10);
    }

    public void g(boolean visible) {
    }

    public /* bridge */ void h(boolean z10) {
        super.h(z10);
    }

    public /* bridge */ boolean j() {
        return super.j();
    }

    public void k(SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
    }

    public /* bridge */ boolean l(InterfaceC5063a<t> interfaceC5063a) {
        return super.l(interfaceC5063a);
    }

    public /* bridge */ boolean m() {
        return super.m();
    }

    public final void o() {
        S sT = t();
        if (sT != null) {
            sT.g1();
        }
    }

    public final void p(boolean allowOrientation) {
        S sT = t();
        if (sT != null) {
            O.r1(sT, allowOrientation, null, 2, null);
        }
    }

    public final void q(boolean animate) {
        S sT = t();
        if (sT != null) {
            sT.B1(animate);
        }
    }

    public final SheetSettleState s() {
        S sT;
        SheetSettleState sheetSettleStateU1;
        SheetSettleState sheetSettleStateV = v();
        int i10 = sheetSettleStateV == null ? -1 : C0323a.$EnumSwitchMapping$0[sheetSettleStateV.ordinal()];
        return (i10 == 1 || i10 == 2 || i10 == 3 || (sT = t()) == null || (sheetSettleStateU1 = sT.u1()) == null) ? sheetSettleStateV : sheetSettleStateU1;
    }

    public final S t() {
        r activity = getActivity();
        if (activity instanceof S) {
            return (S) activity;
        }
        return null;
    }

    public final h u() {
        r activity = getActivity();
        S s10 = activity instanceof S ? (S) activity : null;
        if (s10 != null) {
            return s10.t4();
        }
        return null;
    }

    public final SheetSettleState v() {
        S sT = t();
        if (sT != null) {
            return sT.N1();
        }
        return null;
    }

    public final boolean w() {
        S sT = t();
        return sT != null && sT.getPreviewMode();
    }

    public final boolean x() {
        h hVarU = u();
        return hVarU != null && hVarU.B();
    }

    public final void y(Fragment fragment, String tag, Bundle args, String name, SheetFragmentAnim anim) {
        kotlin.jvm.internal.p.i(fragment, "fragment");
        h hVarU = u();
        if (hVarU != null) {
            hVarU.F(fragment, tag, args, name, anim);
        }
    }

    public a(int i10) {
        super(i10);
    }
}
