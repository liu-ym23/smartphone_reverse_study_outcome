package com.stepos.ailauncher.oobe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.core.view.a0;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.common.permission.C3191h;
import com.stepos.ailauncher.common.permission.PermScene;
import com.stepos.widget.R;
import com.stepos.widget.button.StepOSButton;
import com.stepos.widget.toolbar.StepOSTitleBar;
import d.AbstractC3936b;
import d.InterfaceC3935a;
import f6.C4059a;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/oobe/RecordWakeWordActivity;", "Lcom/stepos/ailauncher/oobe/N;", "<init>", "()V", "LY8/t;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "D", "J", "", "footerContentPaddingBottomPx", "I", "scrollFooterPaddingBottomPx", "", "micPermissionDenied", "Z", "Ld/b;", "Landroid/content/Intent;", "trainingLauncher", "Ld/b;", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RecordWakeWordActivity extends N {
    private boolean micPermissionDenied;
    private int footerContentPaddingBottomPx = -1;
    private int scrollFooterPaddingBottomPx = -1;
    private final AbstractC3936b<Intent> trainingLauncher = registerForActivityResult(new e.e(), new InterfaceC3935a() { // from class: com.stepos.ailauncher.oobe.T
        @Override // d.InterfaceC3935a
        public final void a(Object obj) {
            RecordWakeWordActivity.K(this.f27568a, (ActivityResult) obj);
        }
    });

    private final void A() {
        androidx.core.view.Y.b(getWindow(), false);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        getWindow().setNavigationBarContrastEnforced(false);
        androidx.core.view.b0 b0Var = new androidx.core.view.b0(getWindow(), getWindow().getDecorView());
        b0Var.e(false);
        b0Var.d(false);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() & (-8209));
        com.stepos.ailauncher.common.utils.H.d(getWindow());
        com.stepos.ailauncher.common.utils.H.c(getWindow(), false);
    }

    private final void B() {
        View viewFindViewById = findViewById(R$id.wakeword_root);
        final View viewFindViewById2 = findViewById(R$id.footer_content);
        final NestedScrollView nestedScrollView = (NestedScrollView) findViewById(R$id.scroll_content);
        androidx.core.view.N.u0(viewFindViewById, new androidx.core.view.A() { // from class: com.stepos.ailauncher.oobe.W
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return RecordWakeWordActivity.C(this.f27575a, viewFindViewById2, nestedScrollView, view, a0Var);
            }
        });
    }

    public static final androidx.core.view.a0 C(RecordWakeWordActivity recordWakeWordActivity, View view, NestedScrollView nestedScrollView, View view2, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(view2, "view");
        kotlin.jvm.internal.p.i(insets, "insets");
        t0.e eVarF = insets.f(a0.o.f());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        t0.e eVarF2 = insets.f(a0.o.e());
        kotlin.jvm.internal.p.h(eVarF2, "getInsets(...)");
        view2.setPadding(eVarF.f41977a, eVarF.f41978b, eVarF.f41979c, view2.getPaddingBottom());
        if (recordWakeWordActivity.footerContentPaddingBottomPx < 0) {
            recordWakeWordActivity.footerContentPaddingBottomPx = view.getPaddingBottom();
        }
        if (recordWakeWordActivity.scrollFooterPaddingBottomPx < 0) {
            recordWakeWordActivity.scrollFooterPaddingBottomPx = nestedScrollView.getPaddingBottom();
        }
        kotlin.jvm.internal.p.f(view);
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), recordWakeWordActivity.footerContentPaddingBottomPx + eVarF2.f41980d);
        kotlin.jvm.internal.p.f(nestedScrollView);
        nestedScrollView.setPadding(nestedScrollView.getPaddingLeft(), nestedScrollView.getPaddingTop(), nestedScrollView.getPaddingRight(), recordWakeWordActivity.scrollFooterPaddingBottomPx + eVarF2.f41980d);
        return insets;
    }

    public static final Y8.t E(RecordWakeWordActivity recordWakeWordActivity) {
        AbstractC3936b<Intent> abstractC3936b = recordWakeWordActivity.trainingLauncher;
        Intent intent = new Intent("com.stepos.ability.action.VOICE_WAKEUP_WORD_SELECTION").setPackage("com.stepos.ability");
        kotlin.jvm.internal.p.h(intent, "setPackage(...)");
        abstractC3936b.a(intent);
        return Y8.t.f7040a;
    }

    public static final Y8.t F(RecordWakeWordActivity recordWakeWordActivity, boolean z10) {
        recordWakeWordActivity.micPermissionDenied = true;
        recordWakeWordActivity.J();
        return Y8.t.f7040a;
    }

    public static final void G(RecordWakeWordActivity recordWakeWordActivity, View view) {
        recordWakeWordActivity.finish();
    }

    public static final void H(RecordWakeWordActivity recordWakeWordActivity, View view) {
        C4059a.e(C4059a.INSTANCE, "voice_wakeup", "skip", null, 4, null);
        recordWakeWordActivity.startActivity(new Intent(recordWakeWordActivity, (Class<?>) SdkInitNameActivity.class));
    }

    public static final void I(RecordWakeWordActivity recordWakeWordActivity, View view) {
        C4059a.e(C4059a.INSTANCE, "voice_wakeup", "next", null, 4, null);
        recordWakeWordActivity.D();
    }

    public static final void K(RecordWakeWordActivity recordWakeWordActivity, ActivityResult result) {
        kotlin.jvm.internal.p.i(result, "result");
        if (result.getResultCode() == -1) {
            recordWakeWordActivity.startActivity(new Intent(recordWakeWordActivity, (Class<?>) SdkInitNameActivity.class));
        }
    }

    public final void D() {
        if (this.micPermissionDenied) {
            J();
        } else {
            com.stepos.ailauncher.common.permission.G.F(com.stepos.ailauncher.common.permission.G.INSTANCE, this, PermScene.MICROPHONE, null, new InterfaceC5063a() { // from class: com.stepos.ailauncher.oobe.U
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return RecordWakeWordActivity.E(this.f27571a);
                }
            }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.oobe.V
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return RecordWakeWordActivity.F(this.f27573a, ((Boolean) obj).booleanValue());
                }
            }, 4, null);
        }
    }

    public final void J() {
        startActivity(new Intent(this, (Class<?>) SdkInitNameActivity.class).putExtra(SdkInitNameActivity.EXTRA_MIC_DENIED_SKIP, true));
    }

    @Override // com.stepos.ailauncher.oobe.N, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C3191h.INSTANCE.c(this);
        setContentView(R$layout.oobe_activity_record_wakeword);
        A();
        B();
        StepOSTitleBar stepOSTitleBar = (StepOSTitleBar) findViewById(R$id.title_bar);
        stepOSTitleBar.addStartAction(R.drawable.stepos_icon_navigation_back, getString(R$string.oobe_back), new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.P
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordWakeWordActivity.G(this.f27561a, view);
            }
        });
        String string = getString(R$string.oobe_skip);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        stepOSTitleBar.addEndTextAction(string, new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordWakeWordActivity.H(this.f27563a, view);
            }
        });
        ((StepOSButton) findViewById(R$id.btn_next)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.S
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordWakeWordActivity.I(this.f27566a, view);
            }
        });
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        C3191h.INSTANCE.d(this);
        super.onDestroy();
    }
}
