package com.stepos.ailauncher.agent.aispace.connect;

import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/Q0;", "", "<init>", "()V", "Landroid/view/ViewGroup;", "host", "", "initialName", "Lkotlin/Function1;", "LY8/t;", "onConfirm", "Lkotlin/Function0;", "m", "(Landroid/view/ViewGroup;Ljava/lang/String;Lp9/l;)Lp9/a;", "Landroid/view/View;", "view", "z", "(Landroid/view/View;)V", "l", "", UxipConstants.f30680s, "k", "(Landroid/view/View;I)I", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Q0 {
    public static final Q0 INSTANCE = new Q0();

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/ailauncher/agent/aispace/connect/Q0$a", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "LY8/t;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements TextWatcher {
        final /* synthetic */ Y4.p $binding;

        public a(Y4.p pVar) {
            this.$binding = pVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            Q0.x(this.$binding);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    public static final void n(Y4.p pVar, FrameLayout frameLayout, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewGroup viewGroup) {
        Q0 q02 = INSTANCE;
        EditText etRename = pVar.etRename;
        kotlin.jvm.internal.p.h(etRename, "etRename");
        q02.l(etRename);
        frameLayout.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        viewGroup.removeView(frameLayout);
    }

    public static final void o(FrameLayout frameLayout, Rect rect, ViewGroup viewGroup, Ref$IntRef ref$IntRef, Y4.p pVar) {
        frameLayout.getWindowVisibleDisplayFrame(rect);
        int iF = C5685n.f(frameLayout.getRootView().getHeight() - rect.bottom, 0);
        int[] iArr = new int[2];
        pVar.renamePanel.getLocationOnScreen(iArr);
        int iF2 = iF > 0 ? C5685n.f(((iArr[1] + pVar.renamePanel.getHeight()) - rect.bottom) + INSTANCE.k(viewGroup, 16), 0) : 0;
        if (iF2 != ref$IntRef.f34818a) {
            pVar.renamePanel.setTranslationY(-iF2);
            ref$IntRef.f34818a = iF2;
        }
    }

    public static final void p(Y4.p pVar, FrameLayout frameLayout, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewGroup viewGroup, View view) {
        n(pVar, frameLayout, onGlobalLayoutListener, viewGroup);
    }

    public static final void q(View view) {
    }

    public static final void r(Y4.p pVar, View view) {
        pVar.etRename.setText("");
    }

    public static final void s(Y4.p pVar, FrameLayout frameLayout, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewGroup viewGroup, View view) {
        n(pVar, frameLayout, onGlobalLayoutListener, viewGroup);
    }

    public static final void t(Y4.p pVar, InterfaceC5074l interfaceC5074l, FrameLayout frameLayout, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewGroup viewGroup, View view) {
        y(pVar, interfaceC5074l, frameLayout, onGlobalLayoutListener, viewGroup);
    }

    public static final boolean u(Y4.p pVar, InterfaceC5074l interfaceC5074l, FrameLayout frameLayout, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewGroup viewGroup, TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 != 6) {
            return false;
        }
        y(pVar, interfaceC5074l, frameLayout, onGlobalLayoutListener, viewGroup);
        return true;
    }

    public static final void v(Y4.p pVar) {
        pVar.etRename.requestFocus();
        Q0 q02 = INSTANCE;
        EditText etRename = pVar.etRename;
        kotlin.jvm.internal.p.h(etRename, "etRename");
        q02.z(etRename);
    }

    public static final Y8.t w(Y4.p pVar, FrameLayout frameLayout, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewGroup viewGroup) {
        n(pVar, frameLayout, onGlobalLayoutListener, viewGroup);
        return Y8.t.f7040a;
    }

    public static final void x(Y4.p pVar) {
        Editable text = pVar.etRename.getText();
        boolean z10 = text == null || text.length() == 0;
        pVar.btnClear.setVisibility(z10 ? 8 : 0);
        pVar.btnRenameConfirm.setEnabled(!z10);
        pVar.btnRenameConfirm.setAlpha(z10 ? 0.35f : 1.0f);
    }

    public static final void y(Y4.p pVar, InterfaceC5074l<? super String, Y8.t> interfaceC5074l, FrameLayout frameLayout, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewGroup viewGroup) {
        String string;
        Editable text = pVar.etRename.getText();
        String string2 = (text == null || (string = text.toString()) == null) ? null : La.H.D1(string).toString();
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() > 0) {
            n(pVar, frameLayout, onGlobalLayoutListener, viewGroup);
            interfaceC5074l.invoke(string2);
        }
    }

    public final int k(View view, int value) {
        return (int) (value * view.getResources().getDisplayMetrics().density);
    }

    public final void l(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public final InterfaceC5063a<Y8.t> m(final ViewGroup host, String initialName, final InterfaceC5074l<? super String, Y8.t> onConfirm) {
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(initialName, "initialName");
        kotlin.jvm.internal.p.i(onConfirm, "onConfirm");
        final Y4.p pVarC = Y4.p.c(LayoutInflater.from(host.getContext()), host, false);
        kotlin.jvm.internal.p.h(pVarC, "inflate(...)");
        final FrameLayout frameLayoutB = pVarC.b();
        kotlin.jvm.internal.p.h(frameLayoutB, "getRoot(...)");
        final Rect rect = new Rect();
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.H0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                Q0.o(frameLayoutB, rect, host, ref$IntRef, pVarC);
            }
        };
        frameLayoutB.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.I0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Q0.p(pVarC, frameLayoutB, onGlobalLayoutListener, host, view);
            }
        });
        pVarC.renamePanel.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.J0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Q0.q(view);
            }
        });
        pVarC.etRename.setText(initialName);
        pVarC.etRename.setSelection(initialName.length());
        x(pVarC);
        pVarC.etRename.addTextChangedListener(new a(pVarC));
        pVarC.btnClear.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.K0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Q0.r(pVarC, view);
            }
        });
        pVarC.btnRenameCancel.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.L0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Q0.s(pVarC, frameLayoutB, onGlobalLayoutListener, host, view);
            }
        });
        pVarC.btnRenameConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.M0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Q0.t(pVarC, onConfirm, frameLayoutB, onGlobalLayoutListener, host, view);
            }
        });
        pVarC.etRename.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.N0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                return Q0.u(pVarC, onConfirm, frameLayoutB, onGlobalLayoutListener, host, textView, i10, keyEvent);
            }
        });
        host.addView(frameLayoutB);
        frameLayoutB.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        pVarC.etRename.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.O0
            @Override // java.lang.Runnable
            public final void run() {
                Q0.v(pVarC);
            }
        });
        return new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.P0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Q0.w(pVarC, frameLayoutB, onGlobalLayoutListener, host);
            }
        };
    }

    public final void z(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(view, 1);
        }
    }
}
