package com.stepos.familyguard.ui.base;

import C2.o;
import S1.b;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.C;
import com.stepos.common.widget.StepOSEditInputView;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.base.i;
import com.stepos.familyguard.ui.base.j;
import com.stepos.textinputlayout.TextInputLayout;
import f2.C0702g;
import g2.InterfaceC0731a;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public abstract class f<CR, VR> extends a {

    /* renamed from: c, reason: collision with root package name */
    protected String f14791c;

    /* renamed from: d, reason: collision with root package name */
    protected String f14792d;

    /* renamed from: e, reason: collision with root package name */
    protected i<CR, VR> f14793e;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(String str, String str2, TextView textView) {
        textView.setEnabled(!TextUtils.isEmpty(str) && w0(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(long j5, TextView textView) {
        if (j5 > 0) {
            textView.setText(getString(R.string.fg_duration_format1, Long.valueOf(j5)));
        } else {
            textView.setText(R.string.fg_login_regain_code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(TextView textView) {
        textView.setEnabled(v0(this.f14791c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(Editable editable) {
        String strA = o.a(editable);
        this.f14791c = strA;
        u0(strA, this.f14792d);
        Q1.c.e(q0()).c(new Q1.b() { // from class: r2.j
            @Override // Q1.b
            public final void accept(Object obj) {
                this.f19971a.C0((TextView) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0(StepOSEditInputView stepOSEditInputView) {
        EditText editText = stepOSEditInputView.getEditText();
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(13)});
        r0().setEnabled(false);
        editText.addTextChangedListener(new PhoneNumberFormattingTextWatcher(InterfaceC0731a.f17227a));
        editText.addTextChangedListener(new b.a().b(new Q1.b() { // from class: r2.g
            @Override // Q1.b
            public final void accept(Object obj) {
                this.f19968a.D0((Editable) obj);
            }
        }).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(Editable editable) {
        String string = editable.toString();
        this.f14792d = string;
        u0(this.f14791c, string);
        o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(StepOSEditInputView stepOSEditInputView) {
        stepOSEditInputView.getEditText().addTextChangedListener(new b.a().b(new Q1.b() { // from class: r2.e
            @Override // Q1.b
            public final void accept(Object obj) {
                this.f19966a.F0((Editable) obj);
            }
        }).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0(View view) {
        this.f14793e.p0(this.f14791c, this.f14792d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0(TextView textView) {
        textView.setOnClickListener(new View.OnClickListener() { // from class: r2.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19967a.H0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0(View view) {
        this.f14793e.k0(this.f14791c);
        Q1.c.e(s0()).c(new Q1.b() { // from class: r2.n
            @Override // Q1.b
            public final void accept(Object obj) {
                ((StepOSEditInputView) obj).getEditText().requestFocus();
            }
        });
        o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0(TextView textView) {
        textView.setOnClickListener(new View.OnClickListener() { // from class: r2.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19969a.J0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(String str, StepOSEditInputView stepOSEditInputView) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        TextInputLayout textInputLayout = stepOSEditInputView.getTextInputLayout();
        if (textInputLayout != null) {
            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError(str);
            m0(s0());
        }
    }

    public static /* synthetic */ void W(StepOSEditInputView stepOSEditInputView) {
        EditText editText = stepOSEditInputView.getEditText();
        View viewH = stepOSEditInputView.h(R.id.stepos_get_verify_code);
        if (editText == null || viewH == null) {
            return;
        }
        editText.setPaddingRelative(editText.getPaddingStart(), editText.getPaddingTop(), viewH.getWidth() + (stepOSEditInputView.getInputViewContentPaddingEnd() * 2), editText.getPaddingBottom());
    }

    private void m0(final StepOSEditInputView stepOSEditInputView) {
        stepOSEditInputView.post(new Runnable() { // from class: r2.l
            @Override // java.lang.Runnable
            public final void run() {
                com.stepos.familyguard.ui.base.f.W(stepOSEditInputView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(StepOSEditInputView stepOSEditInputView) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        TextInputLayout textInputLayout = stepOSEditInputView.getTextInputLayout();
        if (textInputLayout == null || !textInputLayout.i()) {
            return;
        }
        textInputLayout.setErrorEnabled(false);
        m0(s0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(String str, Long l5, TextView textView) {
        textView.setEnabled(v0(str) && l5.longValue() <= 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(final String str, final Long l5) {
        Q1.c.e(q0()).c(new Q1.b() { // from class: r2.p
            @Override // Q1.b
            public final void accept(Object obj) {
                this.f19979a.y0(str, l5, (TextView) obj);
            }
        });
    }

    protected void M0(final long j5) {
        t0(this.f14791c);
        Q1.c.e(q0()).c(new Q1.b() { // from class: r2.s
            @Override // Q1.b
            public final void accept(Object obj) {
                this.f19984a.B0(j5, (TextView) obj);
            }
        });
    }

    protected void N0(boolean z5) {
        C0702g.b("BaseVerifyCodeActivity", "onRequestVerifyCodeSuccess success = " + z5);
    }

    protected abstract void O0(boolean z5, String str, String str2, VR vr);

    @Override // com.stepos.familyguard.ui.base.a
    protected boolean P(String str) {
        P0(str);
        return true;
    }

    protected void P0(final String str) {
        Q1.c.e(s0()).c(new Q1.b() { // from class: r2.t
            @Override // Q1.b
            public final void accept(Object obj) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                this.f19986a.L0(str, (StepOSEditInputView) obj);
            }
        });
    }

    protected abstract i<CR, VR> n0();

    protected void o0() {
        Q1.c.e(s0()).c(new Q1.b() { // from class: r2.i
            @Override // Q1.b
            public final void accept(Object obj) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                this.f19970a.x0((StepOSEditInputView) obj);
            }
        });
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        i<CR, VR> iVarN0 = n0();
        this.f14793e = iVarN0;
        iVarN0.a0().g(this, new C() { // from class: com.stepos.familyguard.ui.base.b
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f14787a.M0(((Long) obj).longValue());
            }
        });
        this.f14793e.o0(new i.b() { // from class: com.stepos.familyguard.ui.base.c
            @Override // com.stepos.familyguard.ui.base.i.b
            public final void a(boolean z5, String str, String str2, Object obj) {
                this.f14788a.O0(z5, str, str2, obj);
            }
        });
        this.f14793e.n0(new i.a() { // from class: com.stepos.familyguard.ui.base.d
            @Override // com.stepos.familyguard.ui.base.i.a
            public final void a(boolean z5) {
                this.f14789a.N0(z5);
            }
        });
        this.f14793e.N().g(this, new C() { // from class: com.stepos.familyguard.ui.base.e
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f14790a.N((j.b) obj);
            }
        });
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        p0().getEditText().setText(bundle.getString("phone"));
        s0().getEditText().setText(bundle.getString("verify_code"));
    }

    @Override // stepos.support.v7.app.d, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("phone", this.f14791c);
        bundle.putString("verify_code", this.f14792d);
    }

    protected abstract StepOSEditInputView p0();

    protected abstract TextView q0();

    protected abstract TextView r0();

    protected abstract StepOSEditInputView s0();

    protected void t0(final String str) {
        Q1.c.e(this.f14793e.a0().e()).c(new Q1.b() { // from class: r2.m
            @Override // Q1.b
            public final void accept(Object obj) {
                this.f19976a.z0(str, (Long) obj);
            }
        });
    }

    protected void u0(final String str, final String str2) {
        Q1.c.e(r0()).c(new Q1.b() { // from class: r2.k
            @Override // Q1.b
            public final void accept(Object obj) {
                this.f19972a.A0(str, str2, (TextView) obj);
            }
        });
    }

    protected boolean v0(String str) {
        return !TextUtils.isEmpty(str);
    }

    protected boolean w0(String str) {
        return !TextUtils.isEmpty(str) && str.length() == 6;
    }

    @Override // i2.AbstractActivityC0758a
    public void y(View view, Bundle bundle) {
        super.y(view, bundle);
        Q1.c.e(p0()).c(new Q1.b() { // from class: r2.d
            @Override // Q1.b
            public final void accept(Object obj) {
                this.f19965a.E0((StepOSEditInputView) obj);
            }
        });
        Q1.c.e(s0()).c(new Q1.b() { // from class: r2.o
            @Override // Q1.b
            public final void accept(Object obj) {
                this.f19978a.G0((StepOSEditInputView) obj);
            }
        });
        Q1.c.e(r0()).c(new Q1.b() { // from class: r2.q
            @Override // Q1.b
            public final void accept(Object obj) {
                this.f19982a.I0((TextView) obj);
            }
        });
        Q1.c.e(q0()).c(new Q1.b() { // from class: r2.r
            @Override // Q1.b
            public final void accept(Object obj) {
                this.f19983a.K0((TextView) obj);
            }
        });
    }
}
