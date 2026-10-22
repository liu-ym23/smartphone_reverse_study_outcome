package m5;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.sheet.O;
import com.stepos.ailauncher.sheet.S;
import com.stepos.ailauncher.sheet.SheetSettleState;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lm5/i;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "k", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", "", "allowOrientation", "R", "(Z)V", "H", "P", "(Landroid/view/View;)V", "Q", "(Landroid/view/View;Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class i extends com.stepos.ailauncher.sheet.nav.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lm5/i$a;", "", "<init>", "()V", "Lm5/i;", Const.INTENT_KEY_APIKEY, "()Lm5/i;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: m5.i$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final i a() {
            return new i();
        }

        public Companion() {
        }
    }

    public i() {
        super(R$layout.fragment_chat_sheet_demo);
    }

    public static final void I(i iVar, View view) {
        iVar.R(false);
    }

    public static final void J(i iVar, View view) {
        iVar.R(true);
    }

    public static final void K(i iVar, View view) {
        iVar.H();
    }

    public static final void L(i iVar, View view) {
        S sT = iVar.t();
        if (sT != null) {
            O.T3(sT, SheetSettleState.HALF, false, 2, null);
        }
    }

    public static final void M(i iVar, View view) {
        S sT = iVar.t();
        if (sT != null) {
            O.T3(sT, SheetSettleState.FULL, false, 2, null);
        }
    }

    public static final void N(i iVar, View view) {
        S sT = iVar.t();
        if (sT != null) {
            O.T3(sT, SheetSettleState.MINIFY, false, 2, null);
        }
    }

    public static final void O(i iVar, View view) {
        iVar.o();
    }

    public final void H() {
        View viewFindViewById;
        FrameLayout frameLayout;
        q(true);
        View view = getView();
        if (view != null && (frameLayout = (FrameLayout) view.findViewById(R$id.demoPreviewOverlay)) != null) {
            frameLayout.setVisibility(8);
        }
        View view2 = getView();
        if (view2 != null && (viewFindViewById = view2.findViewById(R$id.demoScroll)) != null) {
            viewFindViewById.setVisibility(0);
        }
        View view3 = getView();
        if (view3 != null) {
            P(view3);
        }
    }

    public final void P(View view) {
        ((TextView) view.findViewById(R$id.demoState)).setText(getString(R$string.chat_sheet_demo_state, w() ? "IMMERSIVE" : "?", String.valueOf(w())));
    }

    public final void Q(View view, SheetSettleState state) {
        ((TextView) view.findViewById(R$id.demoState)).setText(getString(R$string.chat_sheet_demo_state, state.name(), String.valueOf(w())));
    }

    public final void R(boolean allowOrientation) {
        View viewFindViewById;
        FrameLayout frameLayout;
        View view = getView();
        if (view != null && (frameLayout = (FrameLayout) view.findViewById(R$id.demoPreviewOverlay)) != null) {
            frameLayout.setVisibility(0);
        }
        View view2 = getView();
        if (view2 != null && (viewFindViewById = view2.findViewById(R$id.demoScroll)) != null) {
            viewFindViewById.setVisibility(4);
        }
        p(allowOrientation);
        View view3 = getView();
        if (view3 != null) {
            P(view3);
        }
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public void k(SheetSettleState state) {
        p.i(state, "state");
        View view = getView();
        if (view == null) {
            return;
        }
        if (state != SheetSettleState.IMMERSIVE) {
            ((FrameLayout) view.findViewById(R$id.demoPreviewOverlay)).setVisibility(8);
            view.findViewById(R$id.demoScroll).setVisibility(0);
        }
        Q(view, state);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        P(view);
        ((TextView) view.findViewById(R$id.btnPreviewPortrait)).setOnClickListener(new View.OnClickListener() { // from class: m5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i.I(this.f37162a, view2);
            }
        });
        ((TextView) view.findViewById(R$id.btnPreviewRotate)).setOnClickListener(new View.OnClickListener() { // from class: m5.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i.J(this.f37163a, view2);
            }
        });
        ((TextView) view.findViewById(R$id.btnClosePreview)).setOnClickListener(new View.OnClickListener() { // from class: m5.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i.K(this.f37164a, view2);
            }
        });
        ((TextView) view.findViewById(R$id.btnSettleHalf)).setOnClickListener(new View.OnClickListener() { // from class: m5.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i.L(this.f37165a, view2);
            }
        });
        ((TextView) view.findViewById(R$id.btnSettleFull)).setOnClickListener(new View.OnClickListener() { // from class: m5.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i.M(this.f37166a, view2);
            }
        });
        ((TextView) view.findViewById(R$id.btnSettleMinify)).setOnClickListener(new View.OnClickListener() { // from class: m5.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i.N(this.f37167a, view2);
            }
        });
        ((TextView) view.findViewById(R$id.btnDismiss)).setOnClickListener(new View.OnClickListener() { // from class: m5.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i.O(this.f37168a, view2);
            }
        });
        ((FrameLayout) view.findViewById(R$id.demoPreviewOverlay)).setVisibility(w() ? 0 : 8);
    }
}
