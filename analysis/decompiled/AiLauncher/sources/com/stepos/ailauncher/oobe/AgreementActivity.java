package com.stepos.ailauncher.oobe;

import Z8.C1173v;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.a0;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.manager.ClawVMManager;
import com.stepos.policy.sdk.PolicyManager;
import com.stepos.widget.R;
import com.stepos.widget.button.StepOSButton;
import com.stepos.widget.glass.StepOSGlassPanel;
import com.stepos.widget.toolbar.StepOSCollapsingTitleBar;
import f6.C4059a;
import g6.C4105a;
import io.ktor.util.date.GMTDateParser;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import o6.C5009a;
import p7.AppUI;
import p9.InterfaceC5063a;
import t5.C5511d;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J/\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\u0004H\u0002¢\u0006\u0004\b&\u0010\u0003J\u0017\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020 H\u0002¢\u0006\u0004\b(\u0010)J\u001f\u0010,\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020 H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0003¢\u0006\u0004\b.\u0010/J'\u00105\u001a\u00020\u00162\u0006\u00100\u001a\u00020\n2\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b5\u00106J\u0019\u00109\u001a\u00020\u00042\b\u00108\u001a\u0004\u0018\u000107H\u0014¢\u0006\u0004\b9\u0010:J\u001d\u0010>\u001a\u00020\u00042\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020\u0016¢\u0006\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bE\u0010DR\u0016\u0010F\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010G\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bG\u0010DR\u001c\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001a0H8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010QR\u0016\u0010S\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010QR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006W"}, d2 = {"Lcom/stepos/ailauncher/oobe/AgreementActivity;", "Lcom/stepos/ailauncher/oobe/N;", "<init>", "()V", "LY8/t;", "k0", "Lcom/stepos/widget/toolbar/StepOSCollapsingTitleBar;", "titleBar", "Landroid/view/View;", "expandedTitle", "Landroid/widget/TextView;", "compactTitle", "Landroidx/core/widget/NestedScrollView;", "scrollView", "e0", "(Lcom/stepos/widget/toolbar/StepOSCollapsingTitleBar;Landroid/view/View;Landroid/widget/TextView;Landroidx/core/widget/NestedScrollView;)V", "P", "(Lcom/stepos/widget/toolbar/StepOSCollapsingTitleBar;Landroid/view/View;Landroidx/core/widget/NestedScrollView;)V", "M", "(Landroidx/core/widget/NestedScrollView;)V", "o0", "(Lcom/stepos/widget/toolbar/StepOSCollapsingTitleBar;Landroid/view/View;Landroid/widget/TextView;)V", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Lcom/stepos/widget/toolbar/StepOSCollapsingTitleBar;Landroid/view/View;)Z", "overlay", "Landroid/widget/CheckBox;", "checkBox", "c0", "(Landroid/view/View;Landroid/widget/CheckBox;)V", "", "viewId", "", "K", "(I)Ljava/lang/String;", "R", "()Ljava/lang/String;", "L", "N", "phrase", "b0", "(Ljava/lang/String;)V", "titleRes", QueryAlgorithmBundle.KEY_CATEGORY, "Q", "(ILjava/lang/String;)V", ExifInterface.GPS_DIRECTION_TRUE, "(Landroid/widget/CheckBox;)V", AppUI.TYPE_WIDGET, "Landroid/text/Spannable;", "buffer", "Landroid/view/MotionEvent;", "event", ExifInterface.LATITUDE_SOUTH, "(Landroid/widget/TextView;Landroid/text/Spannable;Landroid/view/MotionEvent;)Z", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "granted", "p0", "(Landroid/content/Context;Z)V", "Lg6/a;", "binding", "Lg6/a;", "cbAgreeAll", "Landroid/widget/CheckBox;", "cbUserAgreement", "cbVoiceprint", "cbImprovement", "", "consentBoxes", "Ljava/util/List;", "suppressSync", "Z", "Landroid/widget/Toast;", "consentToast", "Landroid/widget/Toast;", "baseExpandRangePx", "I", "footerContentPaddingBottomPx", "scrollFooterPaddingBottomPx", "Landroid/net/Uri;", "URI", "Landroid/net/Uri;", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgreementActivity extends N {
    private final Uri URI;
    private C4105a binding;
    private CheckBox cbAgreeAll;
    private CheckBox cbImprovement;
    private CheckBox cbUserAgreement;
    private CheckBox cbVoiceprint;
    private List<? extends CheckBox> consentBoxes;
    private Toast consentToast;
    private boolean suppressSync;
    private int baseExpandRangePx = -1;
    private int footerContentPaddingBottomPx = -1;
    private int scrollFooterPaddingBottomPx = -1;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/oobe/AgreementActivity$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AppUI.TYPE_WIDGET, "LY8/t;", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", Const.SP_KEY_DEVICE_SENSORS, "updateDrawState", "(Landroid/text/TextPaint;)V", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends ClickableSpan {
        final /* synthetic */ int $linkColor;
        final /* synthetic */ String $phrase;

        public a(String str, int i10) {
            this.$phrase = str;
            this.$linkColor = i10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            kotlin.jvm.internal.p.i(widget, "widget");
            AgreementActivity agreementActivity = AgreementActivity.this;
            String str = this.$phrase;
            kotlin.jvm.internal.p.f(str);
            agreementActivity.b0(str);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            kotlin.jvm.internal.p.i(ds, "ds");
            ds.setColor(this.$linkColor);
            ds.setUnderlineText(false);
        }
    }

    public AgreementActivity() {
        Uri uri = Uri.parse("content://com.stepos.ability.voicewakeup.permission/consent");
        kotlin.jvm.internal.p.h(uri, "parse(...)");
        this.URI = uri;
    }

    private final void L() {
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

    private final void N() {
        View viewFindViewById = findViewById(R$id.agreement_root);
        final View viewFindViewById2 = findViewById(R$id.footer_content);
        final NestedScrollView nestedScrollView = (NestedScrollView) findViewById(R$id.scroll_content);
        androidx.core.view.N.u0(viewFindViewById, new androidx.core.view.A() { // from class: com.stepos.ailauncher.oobe.w
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return AgreementActivity.O(this.f27640a, viewFindViewById2, nestedScrollView, view, a0Var);
            }
        });
    }

    public static final androidx.core.view.a0 O(AgreementActivity agreementActivity, View view, NestedScrollView nestedScrollView, View view2, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(view2, "view");
        kotlin.jvm.internal.p.i(insets, "insets");
        t0.e eVarF = insets.f(a0.o.f());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        t0.e eVarF2 = insets.f(a0.o.e());
        kotlin.jvm.internal.p.h(eVarF2, "getInsets(...)");
        view2.setPadding(eVarF.f41977a, eVarF.f41978b, eVarF.f41979c, view2.getPaddingBottom());
        if (agreementActivity.footerContentPaddingBottomPx < 0) {
            agreementActivity.footerContentPaddingBottomPx = view.getPaddingBottom();
        }
        if (agreementActivity.scrollFooterPaddingBottomPx < 0) {
            agreementActivity.scrollFooterPaddingBottomPx = nestedScrollView.getPaddingBottom();
        }
        kotlin.jvm.internal.p.f(view);
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), agreementActivity.footerContentPaddingBottomPx + eVarF2.f41980d);
        kotlin.jvm.internal.p.f(nestedScrollView);
        agreementActivity.M(nestedScrollView);
        return insets;
    }

    public static final boolean U(AgreementActivity agreementActivity, SpannableString spannableString, View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.p.g(view, "null cannot be cast to non-null type android.widget.TextView");
        kotlin.jvm.internal.p.f(motionEvent);
        return agreementActivity.S((TextView) view, spannableString, motionEvent);
    }

    public static final void W(AgreementActivity agreementActivity, CompoundButton compoundButton, boolean z10) {
        kotlin.jvm.internal.p.i(compoundButton, "<unused var>");
        if (agreementActivity.suppressSync) {
            return;
        }
        agreementActivity.suppressSync = true;
        List<? extends CheckBox> list = agreementActivity.consentBoxes;
        if (list == null) {
            kotlin.jvm.internal.p.A("consentBoxes");
            list = null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((CheckBox) it.next()).setChecked(z10);
        }
        agreementActivity.suppressSync = false;
    }

    public static final void X(AgreementActivity agreementActivity, CompoundButton buttonView, boolean z10) {
        String strK;
        kotlin.jvm.internal.p.i(buttonView, "buttonView");
        if (z10 && (strK = agreementActivity.K(buttonView.getId())) != null) {
            C4059a.INSTANCE.a(strK);
        }
        if (agreementActivity.suppressSync) {
            return;
        }
        boolean z11 = true;
        agreementActivity.suppressSync = true;
        CheckBox checkBox = agreementActivity.cbAgreeAll;
        List<? extends CheckBox> list = null;
        if (checkBox == null) {
            kotlin.jvm.internal.p.A("cbAgreeAll");
            checkBox = null;
        }
        List<? extends CheckBox> list2 = agreementActivity.consentBoxes;
        if (list2 == null) {
            kotlin.jvm.internal.p.A("consentBoxes");
        } else {
            list = list2;
        }
        List<? extends CheckBox> list3 = list;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it = list3.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (!((CheckBox) it.next()).isChecked()) {
                    z11 = false;
                    break;
                }
            }
        }
        checkBox.setChecked(z11);
        agreementActivity.suppressSync = false;
    }

    public static final void Y(AgreementActivity agreementActivity, View view) {
        C4059a.e(C4059a.INSTANCE, C4059a.STEP_AGREEMENT, "back", null, 4, null);
        agreementActivity.finish();
    }

    public static final void Z(AgreementActivity agreementActivity, View view) throws Resources.NotFoundException {
        C4059a.e(C4059a.INSTANCE, C4059a.STEP_AGREEMENT, C4059a.BUTTON_CONTINUE, null, 4, null);
        CheckBox checkBox = agreementActivity.cbUserAgreement;
        CheckBox checkBox2 = null;
        if (checkBox == null) {
            kotlin.jvm.internal.p.A("cbUserAgreement");
            checkBox = null;
        }
        if (!checkBox.isChecked()) {
            Toast toast = agreementActivity.consentToast;
            if (toast != null) {
                toast.cancel();
            }
            Toast toastMakeText = Toast.makeText(agreementActivity, R$string.oobe_perm1_consent_required, 0);
            toastMakeText.show();
            agreementActivity.consentToast = toastMakeText;
            return;
        }
        AuthManager authManager = AuthManager.INSTANCE;
        authManager.R0(true);
        authManager.N0(true);
        PolicyManager.INSTANCE.saveAgreeStatus(agreementActivity, 1);
        CheckBox checkBox3 = agreementActivity.cbImprovement;
        if (checkBox3 == null) {
            kotlin.jvm.internal.p.A("cbImprovement");
            checkBox3 = null;
        }
        if (checkBox3.isChecked()) {
            CheckBox checkBox4 = agreementActivity.cbImprovement;
            if (checkBox4 == null) {
                kotlin.jvm.internal.p.A("cbImprovement");
                checkBox4 = null;
            }
            authManager.P0(checkBox4.isChecked());
            agreementActivity.getContentResolver().notifyChange(C5511d.INSTANCE.a(), null);
        }
        if (com.stepos.ailauncher.foundation.account.f.INSTANCE.v()) {
            ClawVMManager.INSTANCE.a().m(agreementActivity);
        }
        C5009a c5009a = C5009a.INSTANCE;
        CheckBox checkBox5 = agreementActivity.cbVoiceprint;
        if (checkBox5 == null) {
            kotlin.jvm.internal.p.A("cbVoiceprint");
            checkBox5 = null;
        }
        C5009a.y(c5009a, AuthManager.KEY_VOICE_TRAINING, checkBox5.isChecked(), false, 4, null);
        CheckBox checkBox6 = agreementActivity.cbVoiceprint;
        if (checkBox6 == null) {
            kotlin.jvm.internal.p.A("cbVoiceprint");
        } else {
            checkBox2 = checkBox6;
        }
        if (checkBox2.isChecked()) {
            agreementActivity.p0(agreementActivity, true);
        } else {
            agreementActivity.p0(agreementActivity, false);
        }
        O.INSTANCE.e(agreementActivity);
    }

    public static final void a0(AgreementActivity agreementActivity, View view) {
        C4059a.e(C4059a.INSTANCE, C4059a.STEP_AGREEMENT, C4059a.BUTTON_LATER, null, 4, null);
        O.INSTANCE.d(agreementActivity);
        agreementActivity.finish();
    }

    public static final void d0(CheckBox checkBox, View view) {
        checkBox.setChecked(!checkBox.isChecked());
    }

    public static final Y8.t f0(AgreementActivity agreementActivity, StepOSCollapsingTitleBar stepOSCollapsingTitleBar, View view, TextView textView) {
        agreementActivity.o0(stepOSCollapsingTitleBar, view, textView);
        return Y8.t.f7040a;
    }

    public static final void g0(InterfaceC5063a interfaceC5063a, float f10) {
        interfaceC5063a.invoke();
    }

    public static final void h0(InterfaceC5063a interfaceC5063a, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        interfaceC5063a.invoke();
    }

    public static final void i0(InterfaceC5063a interfaceC5063a, View view, int i10, int i11, int i12, int i13) {
        interfaceC5063a.invoke();
    }

    public static final void j0(AgreementActivity agreementActivity, StepOSCollapsingTitleBar stepOSCollapsingTitleBar, View view, NestedScrollView nestedScrollView, InterfaceC5063a interfaceC5063a, View view2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) throws Resources.NotFoundException {
        agreementActivity.P(stepOSCollapsingTitleBar, view, nestedScrollView);
        interfaceC5063a.invoke();
    }

    public static final Y8.t l0(StepOSGlassPanel stepOSGlassPanel) {
        if (stepOSGlassPanel.isAttachedToWindow() && stepOSGlassPanel.getWidth() > 0 && stepOSGlassPanel.getHeight() > 0 && stepOSGlassPanel.getIsGlassEnabled() && !stepOSGlassPanel.isGlassActive()) {
            stepOSGlassPanel.setGlassEnabled(false);
            stepOSGlassPanel.setGlassEnabled(true);
        }
        return Y8.t.f7040a;
    }

    public static final void m0(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    public static final void n0(InterfaceC5063a interfaceC5063a, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        interfaceC5063a.invoke();
    }

    public final String K(int viewId) {
        if (viewId == R$id.cb_user_agreement) {
            return C4059a.AGREEMENT_USER_AGREEMENT_PRIVACY;
        }
        if (viewId == R$id.cb_voiceprint) {
            return C4059a.AGREEMENT_VOICEPRINT_AUTH;
        }
        if (viewId == R$id.cb_improvement) {
            return C4059a.AGREEMENT_EXPERIENCE_IMPROVEMENT_PLAN;
        }
        return null;
    }

    public final void M(NestedScrollView scrollView) {
        t0.e eVarF;
        if (this.scrollFooterPaddingBottomPx < 0) {
            this.scrollFooterPaddingBottomPx = scrollView.getPaddingBottom();
        }
        androidx.core.view.a0 a0VarB = androidx.core.view.N.B(scrollView);
        scrollView.setPadding(scrollView.getPaddingLeft(), scrollView.getPaddingTop(), scrollView.getPaddingRight(), this.scrollFooterPaddingBottomPx + ((a0VarB == null || (eVarF = a0VarB.f(a0.o.e())) == null) ? 0 : eVarF.f41980d) + getResources().getDimensionPixelSize(R$dimen.oobe_agreement_collapse_extra));
    }

    public final void P(StepOSCollapsingTitleBar titleBar, View expandedTitle, NestedScrollView scrollView) throws Resources.NotFoundException {
        int height = expandedTitle.getHeight();
        if (height <= 0) {
            return;
        }
        if (this.baseExpandRangePx < 0) {
            this.baseExpandRangePx = titleBar.getScrollRange();
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.oobe_agreement_collapse_extra);
        int i10 = this.baseExpandRangePx + height + dimensionPixelSize;
        if (titleBar.getScrollRange() != i10) {
            titleBar.setScrollRange(i10);
        }
        int i11 = -(height + dimensionPixelSize);
        ViewGroup.LayoutParams layoutParams = expandedTitle.getLayoutParams();
        kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams.topMargin != i11) {
            marginLayoutParams.topMargin = i11;
            expandedTitle.setLayoutParams(marginLayoutParams);
        }
        M(scrollView);
    }

    public final void Q(int titleRes, String category) {
        com.stepos.ailauncher.chat.util.j jVar = com.stepos.ailauncher.chat.util.j.INSTANCE;
        String string = getString(titleRes);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        jVar.c(this, category, string);
    }

    public final String R() {
        try {
            com.stepos.ailauncher.foundation.account.f fVar = com.stepos.ailauncher.foundation.account.f.INSTANCE;
            if (!fVar.v()) {
                return "";
            }
            String strK = fVar.k();
            if (strK.length() > 0) {
                return strK;
            }
            return null;
        } catch (Throwable unused) {
            return "";
        }
    }

    public final boolean S(TextView widget, Spannable buffer, MotionEvent event) {
        Layout layout;
        if ((event.getAction() != 0 && event.getAction() != 1) || (layout = widget.getLayout()) == null) {
            return false;
        }
        int x10 = (((int) event.getX()) - widget.getTotalPaddingLeft()) + widget.getScrollX();
        int lineForVertical = layout.getLineForVertical((((int) event.getY()) - widget.getTotalPaddingTop()) + widget.getScrollY());
        float f10 = x10;
        if (f10 < layout.getLineLeft(lineForVertical) || f10 > layout.getLineRight(lineForVertical)) {
            return false;
        }
        int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f10);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) buffer.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
        kotlin.jvm.internal.p.f(clickableSpanArr);
        if (clickableSpanArr.length == 0) {
            return false;
        }
        if (event.getAction() == 1) {
            clickableSpanArr[0].onClick(widget);
        }
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void T(CheckBox checkBox) throws Resources.NotFoundException {
        String string;
        CharSequence text = checkBox.getText();
        if (text == null || (string = text.toString()) == null) {
            return;
        }
        final SpannableString spannableString = new SpannableString(string);
        int iC = androidx.core.content.a.c(this, R$color.oobe_link_blue);
        int iT0 = La.H.t0(string, GMTDateParser.ANY, 0, false, 6, null);
        if (iT0 >= 0) {
            spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.a.c(this, R$color.oobe_required_star)), iT0, iT0 + 1, 33);
        }
        String[] stringArray = getResources().getStringArray(R$array.oobe_links);
        kotlin.jvm.internal.p.h(stringArray, "getStringArray(...)");
        for (String str : stringArray) {
            kotlin.jvm.internal.p.f(str);
            int iU0 = La.H.u0(string, str, 0, false, 6, null);
            while (iU0 >= 0) {
                int length = str.length() + iU0;
                spannableString.setSpan(new a(str, iC), iU0, length, 33);
                iU0 = La.H.u0(string, str, length, false, 4, null);
            }
        }
        checkBox.setText(spannableString);
        checkBox.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.ailauncher.oobe.r
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return AgreementActivity.U(this.f27629a, spannableString, view, motionEvent);
            }
        });
    }

    public final boolean V(StepOSCollapsingTitleBar titleBar, View expandedTitle) {
        if (expandedTitle.getHeight() <= 0) {
            return false;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        expandedTitle.getLocationInWindow(iArr);
        titleBar.getLocationInWindow(iArr2);
        return (iArr[1] + expandedTitle.getHeight()) - expandedTitle.getPaddingBottom() <= ((iArr2[1] + titleBar.getCollapsedHeight()) + getResources().getDimensionPixelSize(R$dimen.oobe_agreement_compact_title_lead)) - getResources().getDimensionPixelSize(R$dimen.oobe_agreement_compact_title_delay);
    }

    public final void b0(String phrase) {
        int i10 = R$string.oobe_link_privacy_policy;
        if (kotlin.jvm.internal.p.d(phrase, getString(i10))) {
            Q(i10, "pp");
            return;
        }
        int i11 = R$string.oobe_link_user_agreement;
        if (kotlin.jvm.internal.p.d(phrase, getString(i11))) {
            Q(i11, "up");
            return;
        }
        int i12 = R$string.oobe_link_voiceprint_auth;
        if (kotlin.jvm.internal.p.d(phrase, getString(i12))) {
            Q(i12, "vrs");
            return;
        }
        int i13 = R$string.oobe_link_improvement_plan;
        if (kotlin.jvm.internal.p.d(phrase, getString(i13))) {
            Q(i13, "ueip");
        }
    }

    public final void c0(View overlay, final CheckBox checkBox) {
        overlay.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgreementActivity.d0(checkBox, view);
            }
        });
    }

    public final void e0(final StepOSCollapsingTitleBar titleBar, final View expandedTitle, final TextView compactTitle, final NestedScrollView scrollView) {
        final InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.oobe.A
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgreementActivity.f0(this.f27526a, titleBar, expandedTitle, compactTitle);
            }
        };
        titleBar.addOnCollapseProgressListener(new StepOSCollapsingTitleBar.OnCollapseProgressListener() { // from class: com.stepos.ailauncher.oobe.m
            @Override // com.stepos.widget.toolbar.StepOSCollapsingTitleBar.OnCollapseProgressListener
            public final void onCollapseProgressChanged(float f10) {
                AgreementActivity.g0(interfaceC5063a, f10);
            }
        });
        titleBar.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.oobe.n
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                AgreementActivity.h0(interfaceC5063a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.stepos.ailauncher.oobe.o
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i10, int i11, int i12, int i13) {
                AgreementActivity.i0(interfaceC5063a, view, i10, i11, i12, i13);
            }
        });
        expandedTitle.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.oobe.p
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) throws Resources.NotFoundException {
                AgreementActivity.j0(this.f27621a, titleBar, expandedTitle, scrollView, interfaceC5063a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
        interfaceC5063a.invoke();
    }

    public final void k0() {
        C4105a c4105a = this.binding;
        if (c4105a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4105a = null;
        }
        final StepOSGlassPanel footerPanel = c4105a.footerPanel;
        kotlin.jvm.internal.p.h(footerPanel, "footerPanel");
        final InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.oobe.x
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgreementActivity.l0(footerPanel);
            }
        };
        footerPanel.post(new Runnable() { // from class: com.stepos.ailauncher.oobe.y
            @Override // java.lang.Runnable
            public final void run() {
                AgreementActivity.m0(interfaceC5063a);
            }
        });
        footerPanel.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.oobe.z
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                AgreementActivity.n0(interfaceC5063a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
    }

    public final void o0(StepOSCollapsingTitleBar titleBar, View expandedTitle, TextView compactTitle) {
        float f10 = V(titleBar, expandedTitle) ? 1.0f : 0.0f;
        titleBar.getExpandedTitleView().setAlpha(0.0f);
        titleBar.getExpandedTitleView().setImportantForAccessibility(2);
        compactTitle.setAlpha(f10);
        expandedTitle.setAlpha(1.0f - f10);
    }

    @Override // com.stepos.ailauncher.oobe.N, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) throws Resources.NotFoundException {
        super.onCreate(savedInstanceState);
        List<? extends CheckBox> list = null;
        C4059a.h(C4059a.INSTANCE, C4059a.STEP_AGREEMENT, null, 2, null);
        L();
        C4105a c4105aC = C4105a.c(getLayoutInflater());
        kotlin.jvm.internal.p.h(c4105aC, "inflate(...)");
        this.binding = c4105aC;
        if (c4105aC == null) {
            kotlin.jvm.internal.p.A("binding");
            c4105aC = null;
        }
        setContentView(c4105aC.b());
        N();
        k0();
        View viewFindViewById = findViewById(R$id.cb_agree_all);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        this.cbAgreeAll = (CheckBox) viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.cb_user_agreement);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.cbUserAgreement = (CheckBox) viewFindViewById2;
        View viewFindViewById3 = findViewById(R$id.cb_voiceprint);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        this.cbVoiceprint = (CheckBox) viewFindViewById3;
        View viewFindViewById4 = findViewById(R$id.cb_improvement);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        this.cbImprovement = (CheckBox) viewFindViewById4;
        CheckBox checkBox = this.cbUserAgreement;
        if (checkBox == null) {
            kotlin.jvm.internal.p.A("cbUserAgreement");
            checkBox = null;
        }
        CheckBox checkBox2 = this.cbVoiceprint;
        if (checkBox2 == null) {
            kotlin.jvm.internal.p.A("cbVoiceprint");
            checkBox2 = null;
        }
        CheckBox checkBox3 = this.cbImprovement;
        if (checkBox3 == null) {
            kotlin.jvm.internal.p.A("cbImprovement");
            checkBox3 = null;
        }
        this.consentBoxes = C1173v.p(checkBox, checkBox2, checkBox3);
        CheckBox checkBox4 = this.cbUserAgreement;
        if (checkBox4 == null) {
            kotlin.jvm.internal.p.A("cbUserAgreement");
            checkBox4 = null;
        }
        T(checkBox4);
        CheckBox checkBox5 = this.cbVoiceprint;
        if (checkBox5 == null) {
            kotlin.jvm.internal.p.A("cbVoiceprint");
            checkBox5 = null;
        }
        T(checkBox5);
        CheckBox checkBox6 = this.cbImprovement;
        if (checkBox6 == null) {
            kotlin.jvm.internal.p.A("cbImprovement");
            checkBox6 = null;
        }
        T(checkBox6);
        View viewFindViewById5 = findViewById(R$id.overlay_cb_agree_all);
        kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
        CheckBox checkBox7 = this.cbAgreeAll;
        if (checkBox7 == null) {
            kotlin.jvm.internal.p.A("cbAgreeAll");
            checkBox7 = null;
        }
        c0(viewFindViewById5, checkBox7);
        View viewFindViewById6 = findViewById(R$id.overlay_cb_user_agreement);
        kotlin.jvm.internal.p.h(viewFindViewById6, "findViewById(...)");
        CheckBox checkBox8 = this.cbUserAgreement;
        if (checkBox8 == null) {
            kotlin.jvm.internal.p.A("cbUserAgreement");
            checkBox8 = null;
        }
        c0(viewFindViewById6, checkBox8);
        View viewFindViewById7 = findViewById(R$id.overlay_cb_voiceprint);
        kotlin.jvm.internal.p.h(viewFindViewById7, "findViewById(...)");
        CheckBox checkBox9 = this.cbVoiceprint;
        if (checkBox9 == null) {
            kotlin.jvm.internal.p.A("cbVoiceprint");
            checkBox9 = null;
        }
        c0(viewFindViewById7, checkBox9);
        View viewFindViewById8 = findViewById(R$id.overlay_cb_improvement);
        kotlin.jvm.internal.p.h(viewFindViewById8, "findViewById(...)");
        CheckBox checkBox10 = this.cbImprovement;
        if (checkBox10 == null) {
            kotlin.jvm.internal.p.A("cbImprovement");
            checkBox10 = null;
        }
        c0(viewFindViewById8, checkBox10);
        CheckBox checkBox11 = this.cbAgreeAll;
        if (checkBox11 == null) {
            kotlin.jvm.internal.p.A("cbAgreeAll");
            checkBox11 = null;
        }
        checkBox11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.stepos.ailauncher.oobe.l
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                AgreementActivity.W(this.f27612a, compoundButton, z10);
            }
        });
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.stepos.ailauncher.oobe.s
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                AgreementActivity.X(this.f27632a, compoundButton, z10);
            }
        };
        List<? extends CheckBox> list2 = this.consentBoxes;
        if (list2 == null) {
            kotlin.jvm.internal.p.A("consentBoxes");
        } else {
            list = list2;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((CheckBox) it.next()).setOnCheckedChangeListener(onCheckedChangeListener);
        }
        StepOSCollapsingTitleBar stepOSCollapsingTitleBar = (StepOSCollapsingTitleBar) findViewById(R$id.collapsing_title_bar);
        View viewFindViewById9 = findViewById(R$id.title_section);
        TextView textView = (TextView) findViewById(R$id.tv_compact_title);
        NestedScrollView nestedScrollView = (NestedScrollView) findViewById(R$id.scroll_content);
        stepOSCollapsingTitleBar.addStartAction(R.drawable.stepos_icon_navigation_back, getString(R$string.oobe_back), new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgreementActivity.Y(this.f27634a, view);
            }
        });
        kotlin.jvm.internal.p.f(stepOSCollapsingTitleBar);
        kotlin.jvm.internal.p.f(viewFindViewById9);
        kotlin.jvm.internal.p.f(textView);
        kotlin.jvm.internal.p.f(nestedScrollView);
        e0(stepOSCollapsingTitleBar, viewFindViewById9, textView, nestedScrollView);
        ((StepOSButton) findViewById(R$id.btn_next)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                AgreementActivity.Z(this.f27636a, view);
            }
        });
        ((StepOSButton) findViewById(R$id.btn_later)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgreementActivity.a0(this.f27638a, view);
            }
        });
    }

    public final void p0(Context context, boolean granted) {
        kotlin.jvm.internal.p.i(context, "context");
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_id", R());
        contentValues.put("granted", Integer.valueOf(granted ? 1 : 0));
        try {
            if (context.getContentResolver().update(this.URI, contentValues, null, null) == 1) {
                Log.e("writeConsent", "writeConsent");
            }
        } catch (Exception unused) {
        }
    }
}
