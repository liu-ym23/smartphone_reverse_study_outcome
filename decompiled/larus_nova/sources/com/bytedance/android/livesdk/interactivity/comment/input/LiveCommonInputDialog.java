package com.bytedance.android.livesdk.interactivity.comment.input;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;
import com.bytedance.android.live.core.utils.d2;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.interactivity.api.comment.CommonInputParams;
import com.bytedance.android.livesdk.interactivity.comment.input.framework.InputPanelLayout;
import com.bytedance.android.livesdk.interactivity.comment.input.framework.PanelType;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.utils.t2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zg1.i1;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/LiveCommonInputDialog;", "Landroidx/fragment/app/DialogFragment;", "Lt22/c;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCommonInputDialog extends DialogFragment implements t22.c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f135018p = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CommonInputParams f135019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EditText f135020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MeasureLinearLayout f135021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public InputPanelLayout f135022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f135023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f135024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.comment.utils.j f135025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public t22.d f135026k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<TextWatcher> f135027l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j f135028m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f135029n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d f135030o;

    public static final class a {
    }

    public static final class b implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveCommonInputDialog f135031a;

        public b(LiveCommonInputDialog r100) {
            this.f135031a = r100;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
            if (r101 != 4) goto L15;
            Editable r103 = LiveCommonInputDialog.S90(this.f135031a).getText();
            if (r103 != null) goto L7;
        L10:
            boolean r104 = true;
        L11:
            if (r104 == false) goto L13;
            return false;
        L13:
            LiveCommonInputDialog.T90(this.f135031a);
            return true;
        L7:
            if (StringsKt.isBlank(r103) == true) goto L10;
            r104 = false;
            goto L11
        L15:
            return false;
        }
    }

    public static final class c implements v62.a.InterfaceC7966a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveCommonInputDialog f135032a;

        @Override // v62.a.InterfaceC7966a
        public final void a() {
            KeyEvent r100 = new KeyEvent(0, 67);
            LiveCommonInputDialog.S90(this.f135032a).dispatchKeyEvent(r100);
        }

        @Override // v62.a.InterfaceC7966a
        public final void dismissDialog() {
            LiveCommonInputDialog r100 = this.f135032a;
            int r101 = LiveCommonInputDialog.f135018p;
            r100.dismissDialog();
        }

        public c(LiveCommonInputDialog r100) {
            this.f135032a = r100;
        }

        @Override // v62.a.InterfaceC7966a
        public final void c(BaseEmoji r100, String r101) {
            if (r100 != null) goto L4;
            return;
        L4:
            com.bytedance.android.livesdk.interactivity.comment.utils.j r102 = this.f135032a.f135025j;
            if (r102 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("inputSizeChecker");
        L7:
            int r103 = r102.f136262b + 1;
            LiveCommonInputDialog r104 = this.f135032a;
            int r105 = r104.f135019d.f133031e;
            if (r103 <= r105) goto L11;
            f2.c(r104.getString(R.string.ttlive_input_max_counts, new Object[]{Integer.valueOf(r105)}), 1);
            return;
        L11:
            if (TextUtils.isEmpty(r100.getDescription()) == false) goto L13;
            return;
        L13:
            LiveCommonInputDialog.S90(this.f135032a).getText().insert(LiveCommonInputDialog.S90(this.f135032a).getSelectionStart(), ab2.a.f(r100.getDescription(), LiveCommonInputDialog.f135018p));
        }
    }

    public static final class d extends d2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveCommonInputDialog f135033a;

        public d(LiveCommonInputDialog r100) {
            this.f135033a = r100;
        }

        @Override // com.bytedance.android.live.core.utils.d2, android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            Iterator<T> r101 = this.f135033a.f135027l.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((TextWatcher) r101.next()).afterTextChanged(r100);
            goto L4
        }

        @Override // com.bytedance.android.live.core.utils.d2, android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
            Iterator<T> r104 = this.f135033a.f135027l.iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            ((TextWatcher) r104.next()).beforeTextChanged(r100, r101, r102, r103);
            goto L4
        }

        @Override // com.bytedance.android.live.core.utils.d2, android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            Iterator<T> r104 = this.f135033a.f135027l.iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            ((TextWatcher) r104.next()).onTextChanged(r100, r101, r102, r103);
            goto L4
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveCommonInputDialog f135034a;

        public e(LiveCommonInputDialog r100) {
            this.f135034a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveCommonInputDialog.S90(this.f135034a).requestFocus();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveCommonInputDialog f135035a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f135036a;

            public a(f r100) {
                this.f135036a = r100;
            }

            public final void a() {
                if (this.f135036a.f135035a.isAdded() == true) goto L6;
                return;
            L6:
                if (this.f135036a.f135035a.getActivity() == null) goto L12;
                FragmentActivity r100 = this.f135036a.f135035a.getActivity();
                if (r100 == null) goto L12;
                Window r101 = r100.getWindow();
                if (r101 == null) goto L12;
                r101.setSoftInputMode(48);
            L12:
                t2.b(this.f135036a.f135035a.getContext(), LiveCommonInputDialog.S90(this.f135036a.f135035a));
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public f(LiveCommonInputDialog r100) {
            this.f135035a = r100;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            r100.postDelayed(new a(this), 100);
            LiveCommonInputDialog.S90(this.f135035a).setOnFocusChangeListener(null);
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveCommonInputDialog f135037a;

        public g(LiveCommonInputDialog r100) {
            this.f135037a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveCommonInputDialog.S90(this.f135037a).setSelection(this.f135037a.f135019d.f133030d.length());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveCommonInputDialog f135038a;

        public h(LiveCommonInputDialog r100) {
            this.f135038a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveCommonInputDialog r101 = this.f135038a;
            int r102 = LiveCommonInputDialog.f135018p;
            r101.dismissDialog();
        }
    }

    public static final class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveCommonInputDialog f135039a;

        public i(LiveCommonInputDialog r100) {
            this.f135039a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            InputPanelLayout r101 = this.f135039a.f135022g;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
        L5:
            PanelType r102 = r101.getCurrentPanelType();
            PanelType r103 = PanelType.EMOJI;
            if (r102 != r103) goto L11;
            InputPanelLayout r104 = this.f135039a.f135022g;
            if (r104 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
        L10:
            r104.b(PanelType.KEYBOARD, LiveCommonInputDialog.S90(this.f135039a));
            return;
        L11:
            InputPanelLayout r105 = this.f135039a.f135022g;
            if (r105 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
        L14:
            r105.b(r103, LiveCommonInputDialog.S90(this.f135039a));
        }
    }

    public static final class j extends u62.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveCommonInputDialog f135040b;

        @Override // u62.b
        public final void b() {
        }

        @Override // u62.b
        public final int d() {
            InputPanelLayout r100 = this.f135040b.f135022g;
            if (r100 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
        L6:
            if (r100.getKeyboardHeight() == 0) goto L8;
            InputPanelLayout r101 = this.f135040b.f135022g;
            if (r101 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
        L16:
            return r101.getKeyboardHeight();
        L8:
            if (f() == false) goto L10;
            Integer r102 = l42.a.f507324k.getValue();
        L17:
            return r102.intValue();
        L10:
            r102 = l42.a.f507325l.getValue();
            goto L17
        }

        @Override // u62.b
        public final void e() {
            LiveCommonInputDialog.T90(this.f135040b);
        }

        public final boolean f() {
            return this.f135040b.f135019d.f133027a;
        }

        @Override // u62.b
        public Activity getActivity() {
            return this.f135040b.getActivity();
        }

        public final void g(v62.c r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            ((ArrayList) this.f135040b.f135027l).add(r100);
        }

        public j(LiveCommonInputDialog r100, c r101) {
            this.f135040b = r100;
            super(r101);
        }
    }

    static {
        f135018p = s1.f(18.0f);
    }

    public final void dismissDialog() {
        InputPanelLayout r100 = this.f135022g;     // Catch: Exception -> L16
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");     // Catch: Exception -> L16
    L5:
        PanelType r101 = PanelType.NONE;     // Catch: Exception -> L16
        EditText r102 = this.f135020e;     // Catch: Exception -> L16
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");     // Catch: Exception -> L16
    L8:
        r100.b(r101, r102);     // Catch: Exception -> L16
        dismissAllowingStateLoss();     // Catch: Exception -> L11
    L24:
        return;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L16
        Throwable r103 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L16
        if (r103 == null) goto L23;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L16
        return;
    L23:
        return;
    L16:
        e = move-exception;
        i40.h.a("dismiss input dialog exception: " + e.getMessage());
    }

    public LiveCommonInputDialog() {
        this.f135019d = new CommonInputParams(false, false, null, null, 31, 0);
        this.f135027l = new ArrayList();
        this.f135028m = new j(this, new c(this));
        this.f135029n = new b(this);
        this.f135030o = new d(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        MeasureLinearLayout r100 = this.f135021f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        i40.b r101 = r100.getKeyBoardObservable();
        InputPanelLayout r102 = this.f135022g;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L8:
        r101.b(r102);
        i40.h.a("registerKeyboardListener with keyBoardObservable");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        MeasureLinearLayout r100 = this.f135021f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        i40.b r101 = r100.getKeyBoardObservable();
        InputPanelLayout r102 = this.f135022g;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L8:
        r101.b(r102);
        i40.h.a("registerKeyboardListener with keyBoardObservable");
        EditText r103 = this.f135020e;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L11:
        r103.post(new e(this));
        EditText r104 = this.f135020e;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L14:
        r104.setOnFocusChangeListener(new f(this));
    }

    public static final /* synthetic */ EditText S90(LiveCommonInputDialog r100) {
        EditText r101 = r100.f135020e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L5:
        return r101;
    }

    public static final void T90(LiveCommonInputDialog r100) {
        EditText r101 = r100.f135020e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L5:
        String r102 = r101.getText().toString();
        if (r102 == null) goto L13;
        String r103 = StringsKt.trim(r102).toString();
        t22.d r104 = r100.f135026k;
        if (r104 == null) goto L10;
        r104.a(r103);
    L10:
        r100.dismissDialog();
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setLayout(-1, -1);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_emoji_input_dialog);
        Bundle r101 = getArguments();
        if (r101 == null) goto L9;
        CommonInputParams r102 = (CommonInputParams) r101.getParcelable("common_input_params");
        if (r102 != null) goto L7;
        r102 = new CommonInputParams(false, false, null, null, 31, 0);
    L7:
        this.f135019d = r102;
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setCanceledOnTouchOutside(false);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L5;
        r102.setGravity(80);
        r102.setLayout(-1, -1);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setSoftInputMode(19);
        r102.addFlags(32);
        r102.clearFlags(2);
    L5:
        return r101;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        com.bytedance.android.livesdk.f.d().f123394c = false;     // Catch: Throwable -> L5
        com.bytedance.android.livesdk.f.d().f();     // Catch: Throwable -> L5
        xs2.b.a().post(new i1(0, false));     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        EditText r102 = this.f135020e;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L5:
        r102.addTextChangedListener(this.f135030o);
        EditText r103 = this.f135020e;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L8:
        r103.setOnEditorActionListener(this.f135029n);
        EditText r104 = this.f135020e;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L11:
        r104.setHint(this.f135019d.f133029c);
        if (this.f135019d.f133030d.length() <= 0) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == false) goto L23;
        EditText r106 = this.f135020e;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L19:
        r106.setText(this.f135019d.f133030d);
        EditText r107 = this.f135020e;
        if (r107 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L22:
        r107.post(new g(this));
    L23:
        EditText r108 = this.f135020e;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L26:
        r108.setImeOptions(268435460);
        EditText r109 = this.f135020e;
        if (r109 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L29:
        r109.setInputType(1);
        this.f135021f = (MeasureLinearLayout) r100.findViewById(R.id.root_view);
        View r110 = this.f135024i;
        if (r110 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("emptyView");
    L32:
        r110.setOnClickListener(new h(this));
        ImageView r111 = this.f135023h;
        if (r111 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("iconSwitchEmoji");
    L35:
        r111.setOnClickListener(new i(this));
        HashSet r112 = new HashSet();
        r112.add(PanelType.EMOJI);
        r112.add(PanelType.KEYBOARD);
        InputPanelLayout r113 = this.f135022g;
        if (r113 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L38:
        r113.setPanelLayoutName("BottomPanelLayout");
        InputPanelLayout r114 = this.f135022g;
        if (r114 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L41:
        r114.setSupportPanels(r112);
        InputPanelLayout r115 = this.f135022g;
        if (r115 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L44:
        r115.setIsPortrait(this.f135019d.f133027a);
        InputPanelLayout r116 = this.f135022g;
        if (r116 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L47:
        j r117 = this.f135028m;
        v62.a r118 = new v62.a();
        r116.getClass();
        Intrinsics.checkNotNullParameter(r117, "panelBridge");
        Intrinsics.checkNotNullParameter(r118, "panelProvider");
        PanelType r119 = r118.f553384a;
        if (r116.f135162g.contains(r119) == true) goto L51;
    L57:
        InputPanelLayout r120 = this.f135022g;
        if (r120 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L60:
        com.bytedance.android.livesdk.interactivity.comment.input.f r121 = new com.bytedance.android.livesdk.interactivity.comment.input.f(this);
        r120.getClass();
        Intrinsics.checkNotNullParameter(r121, "onPanelSwitchListener");
        r120.f135161f.add(r121);
        return;
    L51:
        if (r116.f135159d.get(r119) != null) goto L57;
        View r122 = r118.d(r117);
        if (r122 == null) goto L57;
        r116.f135160e.put(r119, r118);
        r116.f135159d.put(r119, r122);
        r116.addView(r122);
        r122.setVisibility(8);
        goto L57
    L14:
        r105 = false;
        goto L15
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        com.bytedance.android.livesdk.f.d().f123394c = true;
        com.bytedance.android.livesdk.f.d().a();
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r102) == false) goto L10;
    L7:
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_msg", "common input dialog show");
        return;
    L10:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        super.show(r100, r101);
        goto L7
    }

    public final void show(Activity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "tag");
        FragmentManager r102 = ((FragmentActivity) r100).getSupportFragmentManager();
        LandscapeRestrictionOperation r103 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r103);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r102, this, r103) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        show(r102, r101);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_common_input, r101, false);
        this.f135020e = (EditText) r103.findViewById(R.id.et_single_line_input);
        this.f135022g = (InputPanelLayout) r103.findViewById(R.id.bottom_input_panel);
        this.f135023h = (ImageView) r103.findViewById(R.id.icon_switch_emoji);
        this.f135024i = r103.findViewById(R.id.empty_view);
        EditText r104 = this.f135020e;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L5:
        this.f135025j = new com.bytedance.android.livesdk.interactivity.comment.utils.j(r104, this.f135019d);
        return r103;
    }
}
