package com.stepos.ailauncher.chat.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsController;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$color;
import com.stepos.ailauncher.chat.R$id;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a=\u0010\b\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\n\u001a\u00020\u0004*\u00020\u0000H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\r\u001a\u00020\u0004*\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000e\"\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014\"\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroid/view/View;", "", "initialTitle", "Lkotlin/Function1;", "LY8/t;", "onConfirm", "Lkotlin/Function0;", "onClose", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/view/View;Ljava/lang/String;Lp9/l;Lp9/a;)V", "n", "(Landroid/view/View;)V", "card", "o", "(Landroid/view/View;Landroid/view/View;)V", "", "MAX_TITLE_LENGTH", "I", "", "LENGTH_TOAST_DURATION_MS", "J", "LENGTH_TOAST_FADE_MS", "", "IME_GAP_DP", "F", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.t7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2971t7 {
    private static final float IME_GAP_DP = 16.0f;
    private static final long LENGTH_TOAST_DURATION_MS = 1500;
    private static final long LENGTH_TOAST_FADE_MS = 200;
    private static final int MAX_TITLE_LENGTH = 20;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/ailauncher/chat/view/t7$a", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "LY8/t;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.t7$a */
    public static final class a implements TextWatcher {
        final /* synthetic */ int $colorActive;
        final /* synthetic */ int $colorDisabled;
        final /* synthetic */ ImageView $ivClearInput;
        final /* synthetic */ TextView $tvConfirm;

        public a(TextView textView, int i10, int i11, ImageView imageView) {
            this.$tvConfirm = textView;
            this.$colorActive = i10;
            this.$colorDisabled = i11;
            this.$ivClearInput = imageView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            CharSequence charSequenceD1;
            boolean z10 = (s10 == null || (charSequenceD1 = La.H.D1(s10)) == null || charSequenceD1.length() <= 0) ? false : true;
            this.$tvConfirm.setTextColor(z10 ? this.$colorActive : this.$colorDisabled);
            this.$tvConfirm.setEnabled(z10);
            this.$ivClearInput.setVisibility((s10 == null || s10.length() == 0) ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/view/t7$b", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "", "hasFocus", "LY8/t;", "onWindowFocusChanged", "(Z)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.t7$b */
    public static final class b implements ViewTreeObserver.OnWindowFocusChangeListener {
        final /* synthetic */ EditText $etTitleInput;
        final /* synthetic */ View $this_focusRenameInputAndShowIme;

        public b(View view, EditText editText) {
            this.$this_focusRenameInputAndShowIme = view;
            this.$etTitleInput = editText;
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean hasFocus) {
            if (hasFocus) {
                this.$this_focusRenameInputAndShowIme.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
                this.$etTitleInput.requestFocus();
                WindowInsetsController windowInsetsController = this.$etTitleInput.getWindowInsetsController();
                if (windowInsetsController != null) {
                    windowInsetsController.show(WindowInsets.Type.ime());
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/chat/view/t7$c", "Landroid/view/WindowInsetsAnimation$Callback;", "Landroid/view/WindowInsetsAnimation;", "animation", "LY8/t;", "onPrepare", "(Landroid/view/WindowInsetsAnimation;)V", "Landroid/view/WindowInsets;", "insets", "", "runningAnimations", "onProgress", "(Landroid/view/WindowInsets;Ljava/util/List;)Landroid/view/WindowInsets;", "onEnd", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.t7$c */
    public static final class c extends WindowInsetsAnimation.Callback {
        final /* synthetic */ InterfaceC5074l<Integer, Y8.t> $alignCardAboveIme;
        final /* synthetic */ Ref$BooleanRef $imeAnimating;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(Ref$BooleanRef ref$BooleanRef, InterfaceC5074l<? super Integer, Y8.t> interfaceC5074l) {
            super(1);
            this.$imeAnimating = ref$BooleanRef;
            this.$alignCardAboveIme = interfaceC5074l;
        }

        @Override // android.view.WindowInsetsAnimation.Callback
        public void onEnd(WindowInsetsAnimation animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if ((animation.getTypeMask() & WindowInsets.Type.ime()) != 0) {
                this.$imeAnimating.f34815a = false;
            }
        }

        @Override // android.view.WindowInsetsAnimation.Callback
        public void onPrepare(WindowInsetsAnimation animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if ((animation.getTypeMask() & WindowInsets.Type.ime()) != 0) {
                this.$imeAnimating.f34815a = true;
            }
        }

        @Override // android.view.WindowInsetsAnimation.Callback
        public WindowInsets onProgress(WindowInsets insets, List<WindowInsetsAnimation> runningAnimations) {
            kotlin.jvm.internal.p.i(insets, "insets");
            kotlin.jvm.internal.p.i(runningAnimations, "runningAnimations");
            this.$alignCardAboveIme.invoke(Integer.valueOf(insets.getInsets(WindowInsets.Type.ime()).bottom));
            return insets;
        }
    }

    public static final void h(View view, final String initialTitle, final InterfaceC5074l<? super String, Y8.t> onConfirm, final InterfaceC5063a<Y8.t> onClose) {
        kotlin.jvm.internal.p.i(view, "<this>");
        kotlin.jvm.internal.p.i(initialTitle, "initialTitle");
        kotlin.jvm.internal.p.i(onConfirm, "onConfirm");
        kotlin.jvm.internal.p.i(onClose, "onClose");
        final EditText editText = (EditText) view.findViewById(R$id.et_title_input);
        ImageView imageView = (ImageView) view.findViewById(R$id.iv_clear_input);
        TextView textView = (TextView) view.findViewById(R$id.tv_cancel);
        TextView textView2 = (TextView) view.findViewById(R$id.tv_confirm);
        View viewFindViewById = view.findViewById(R$id.fl_overlay);
        TextView textView3 = (TextView) view.findViewById(R$id.tv_length_toast);
        View viewFindViewById2 = view.findViewById(R$id.ll_dialog_card);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.m7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2971t7.i(onClose, view2);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.n7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2971t7.j(onClose, view2);
            }
        });
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.o7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C2971t7.k(view2);
                }
            });
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.p7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2971t7.l(editText, view2);
            }
        });
        kotlin.jvm.internal.p.f(textView3);
        editText.setFilters(new C2820f9[]{new C2820f9(textView3)});
        o(view, viewFindViewById2);
        editText.addTextChangedListener(new a(textView2, androidx.core.content.a.c(view.getContext(), R$color.rename_btn_confirm_text), androidx.core.content.a.c(view.getContext(), R$color.rename_btn_confirm_text_disabled), imageView));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.q7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2971t7.m(editText, initialTitle, onConfirm, onClose, view2);
            }
        });
        editText.setText(initialTitle);
        editText.setSelection(initialTitle.length());
    }

    public static final void i(InterfaceC5063a interfaceC5063a, View view) {
        interfaceC5063a.invoke();
    }

    public static final void j(InterfaceC5063a interfaceC5063a, View view) {
        interfaceC5063a.invoke();
    }

    public static final void k(View view) {
    }

    public static final void l(EditText editText, View view) {
        editText.setText("");
        editText.requestFocus();
    }

    public static final void m(EditText editText, String str, InterfaceC5074l interfaceC5074l, InterfaceC5063a interfaceC5063a, View view) {
        String string = La.H.D1(editText.getText().toString()).toString();
        if (string.length() == 0) {
            return;
        }
        if (!kotlin.jvm.internal.p.d(string, str)) {
            interfaceC5074l.invoke(string);
        }
        interfaceC5063a.invoke();
    }

    public static final void n(View view) {
        kotlin.jvm.internal.p.i(view, "<this>");
        EditText editText = (EditText) view.findViewById(R$id.et_title_input);
        if (editText == null) {
            return;
        }
        editText.requestFocus();
        if (!view.hasWindowFocus()) {
            view.getViewTreeObserver().addOnWindowFocusChangeListener(new b(view, editText));
            return;
        }
        WindowInsetsController windowInsetsController = editText.getWindowInsetsController();
        if (windowInsetsController != null) {
            windowInsetsController.show(WindowInsets.Type.ime());
        }
    }

    public static final void o(final View view, final View view2) {
        final float f10 = view.getResources().getDisplayMetrics().density * 16.0f;
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.r7
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C2971t7.p(view2, view, f10, ((Integer) obj).intValue());
            }
        };
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.stepos.ailauncher.chat.view.s7
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view3, WindowInsets windowInsets) {
                return C2971t7.q(ref$BooleanRef, interfaceC5074l, view3, windowInsets);
            }
        });
        view.setWindowInsetsAnimationCallback(new c(ref$BooleanRef, interfaceC5074l));
    }

    public static final Y8.t p(View view, View view2, float f10, int i10) {
        int height;
        if (view != null && (height = view2.getHeight()) != 0) {
            float bottom = (view.getBottom() + f10) - (height - i10);
            view.setTranslationY(bottom > 0.0f ? -bottom : 0.0f);
            return Y8.t.f7040a;
        }
        return Y8.t.f7040a;
    }

    public static final WindowInsets q(Ref$BooleanRef ref$BooleanRef, InterfaceC5074l interfaceC5074l, View view, WindowInsets insets) {
        kotlin.jvm.internal.p.i(view, "<unused var>");
        kotlin.jvm.internal.p.i(insets, "insets");
        if (!ref$BooleanRef.f34815a) {
            interfaceC5074l.invoke(Integer.valueOf(insets.getInsets(WindowInsets.Type.ime()).bottom));
        }
        return insets;
    }
}
