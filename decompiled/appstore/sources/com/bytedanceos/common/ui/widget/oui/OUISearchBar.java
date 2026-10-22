package com.bytedanceos.common.ui.widget.oui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewKt;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$styleable;
import com.obric.oui.button.OButton;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.forms.OInputView;
import com.obric.oui.searchbar.OSearchBar;

/* JADX INFO: loaded from: classes2.dex */
public class OUISearchBar extends LinearLayout {
    private static final int ANIM_DURATION_ALL = 300;
    private static final int ANIM_DURATION_ITEM = 200;
    private static final int ITEM_START_DELAY = 100;
    private AnimationListener animationListener;
    private int mActionCancelViewWidth;
    private int mActionFilterViewWidth;
    private final int mAnimDistance;
    private boolean mEnabled;
    private boolean mIsPlayingAnimation;
    private boolean mIsSearchMode;
    private final OButton mSearchActionCancel;
    protected final OButton mSearchActionFilter;
    private final OSearchBar mSearchBar;
    private int mSearchBarViewActiveWidth;
    private int mSearchBarViewInitWidth;
    protected final boolean mShowActionFilter;
    private OnCancelClickListener onCancelClickListener;
    private OnCommitCompletionListener onCommitCompletionListener;
    private OnEditorClickListener onEditorClickListener;
    private OnFilterClickListener onFilterClickListener;
    private OnSearchIconClickListener onSearchIconClickListener;
    private OnSecondaryFilterClickListener onSecondaryFilterClickListener;

    /* JADX INFO: renamed from: com.bytedanceos.common.ui.widget.oui.OUISearchBar$5, reason: invalid class name */
    public class AnonymousClass5 extends AnimatorListenerAdapter {
        final /* synthetic */ OUISearchBar this$0;
        final /* synthetic */ boolean val$toSearchMode;

        public AnonymousClass5(OUISearchBar r10, boolean r11) {
            this.this$0 = r10;
            this.val$toSearchMode = r11;
        }

        public static /* synthetic */ void a(AnonymousClass5 r10, boolean r11) {
            r10.lambda$onAnimationEnd$0(r11);
        }

        private /* synthetic */ void lambda$onAnimationEnd$0(boolean r10) {
            if (r10 == false) goto L4;
            this.this$0.showKeyboard();
            return;
        L4:
            this.this$0.hideKeyboard();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            super.onAnimationEnd(r10);
            OUISearchBar.access$702(this.this$0, false);
            if (OUISearchBar.access$800(this.this$0) == null) goto L5;
            OUISearchBar.access$800(this.this$0).onAnimationEnd();
        L5:
            OUISearchBar r11 = this.this$0;
            final boolean r12 = this.val$toSearchMode;
            r11.post(new i(this, r12));
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            super.onAnimationStart(r10);
            OUISearchBar.access$702(this.this$0, true);
            if (OUISearchBar.access$800(this.this$0) == null) goto L6;
            OUISearchBar.access$800(this.this$0).onAnimationStart();
            return;
        }
    }

    public interface AnimationListener {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public interface OnCancelClickListener {
        void onClick(View r10);
    }

    public interface OnCommitCompletionListener {
        void onCommitCompletion(CompletionInfo r10);
    }

    public interface OnEditorClickListener {
        void onClick(View r10);
    }

    public interface OnFilterClickListener {
        void onClick(View r10);
    }

    public interface OnSearchIconClickListener {
        void onClick(View r10);
    }

    public interface OnSecondaryFilterClickListener {
        void onClick(View r10);
    }

    public OUISearchBar(@NonNull Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ void a(OUISearchBar r10, View r11) {
        r10.lambda$new$1(r11);
    }

    public static /* synthetic */ int access$000(OUISearchBar r10) {
        return r10.mActionCancelViewWidth;
    }

    public static /* synthetic */ int access$002(OUISearchBar r10, int r11) {
        r10.mActionCancelViewWidth = r11;
        return r11;
    }

    public static /* synthetic */ OButton access$100(OUISearchBar r10) {
        return r10.mSearchActionCancel;
    }

    public static /* synthetic */ int access$200(OUISearchBar r10) {
        return r10.mActionFilterViewWidth;
    }

    public static /* synthetic */ int access$202(OUISearchBar r10, int r11) {
        r10.mActionFilterViewWidth = r11;
        return r11;
    }

    public static /* synthetic */ int access$300(OUISearchBar r10) {
        return r10.mSearchBarViewInitWidth;
    }

    public static /* synthetic */ int access$302(OUISearchBar r10, int r11) {
        r10.mSearchBarViewInitWidth = r11;
        return r11;
    }

    public static /* synthetic */ int access$402(OUISearchBar r10, int r11) {
        r10.mSearchBarViewActiveWidth = r11;
        return r11;
    }

    public static /* synthetic */ OSearchBar access$500(OUISearchBar r10) {
        return r10.mSearchBar;
    }

    public static /* synthetic */ void access$600(OUISearchBar r10, boolean r11) {
        r10.startAnimationInternal(r11);
    }

    public static /* synthetic */ boolean access$702(OUISearchBar r10, boolean r11) {
        r10.mIsPlayingAnimation = r11;
        return r11;
    }

    public static /* synthetic */ AnimationListener access$800(OUISearchBar r10) {
        return r10.animationListener;
    }

    public static /* synthetic */ void b(OUISearchBar r10, View r11, boolean r12) {
        r10.lambda$new$0(r11, r12);
    }

    public static /* synthetic */ void c(OUISearchBar r10, ValueAnimator r11) {
        r10.lambda$startAnimationInternal$4(r11);
    }

    public static /* synthetic */ void d(OUISearchBar r10, View r11) {
        r10.lambda$new$3(r11);
    }

    public static /* synthetic */ void e(OUISearchBar r10, View r11) {
        r10.lambda$setOnEditorClickListener$5(r11);
    }

    public static /* synthetic */ void f(OUISearchBar r10, View r11) {
        r10.lambda$new$2(r11);
    }

    private /* synthetic */ void lambda$new$0(View r10, boolean r11) {
        if (r11 == true) goto L4;
        return;
    L4:
        if (this.mIsSearchMode == true) goto L8;
        startAnimation(true);
        return;
    }

    private /* synthetic */ void lambda$new$1(View r10) {
        if (com.bytedanceos.common.toolbox.e.p0() == false) goto L5;
        return;
    L5:
        OnSearchIconClickListener r11 = this.onSearchIconClickListener;
        if (r11 == null) goto L9;
        r11.onClick(r10);
        return;
    }

    private /* synthetic */ void lambda$new$2(View r10) {
        if (com.bytedanceos.common.toolbox.e.p0() == false) goto L6;
        return;
    L6:
        if (this.mIsPlayingAnimation == false) goto L8;
        return;
    L8:
        OnFilterClickListener r11 = this.onFilterClickListener;
        if (r11 == null) goto L12;
        r11.onClick(r10);
        return;
    }

    private /* synthetic */ void lambda$new$3(View r10) {
        if (com.bytedanceos.common.toolbox.e.p0() == true) goto L6;
        return;
    L6:
        if (this.mIsPlayingAnimation == false) goto L8;
        return;
    L8:
        OnCancelClickListener r11 = this.onCancelClickListener;
        if (r11 == null) goto L11;
        r11.onClick(this.mSearchActionCancel);
    L11:
        this.mSearchBar.getInputView().clearFocus();
        if (this.mIsSearchMode == false) goto L15;
        startAnimation(false);
        return;
    }

    private /* synthetic */ void lambda$setOnEditorClickListener$5(View r10) {
        OnEditorClickListener r11 = this.onEditorClickListener;
        if (r11 == null) goto L6;
        r11.onClick(r10);
        return;
    }

    private /* synthetic */ void lambda$startAnimationInternal$4(ValueAnimator r10) {
        LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) this.mSearchBar.getLayoutParams();
        r11.width = ((Integer) r10.getAnimatedValue()).intValue();
        this.mSearchBar.setLayoutParams(r11);
    }

    private void startAnimationInternal(final boolean r17) {
        if (r17 == false) goto L5;
        ValueAnimator r10 = ValueAnimator.ofInt(new int[]{this.mSearchBarViewInitWidth, this.mSearchBarViewActiveWidth});
    L6:
        r10.addUpdateListener(new d(this));
        if (this.mShowActionFilter == false) goto L11;
        if (r17 == false) goto L10;
        r10.setStartDelay(100);
        r10.setDuration(200);
    L12:
        AnimatorSet r11 = new AnimatorSet();
        if (r17 == false) goto L15;
        ObjectAnimator r12 = ObjectAnimator.ofFloat(this.mSearchActionCancel, View.TRANSLATION_X, new float[]{this.mAnimDistance, 0.0f});
        ObjectAnimator r13 = ObjectAnimator.ofFloat(this.mSearchActionCancel, View.ALPHA, new float[]{0.0f, 1.0f});
        r11.setStartDelay(100);
    L16:
        r11.play(r12).with(r13);
        r11.setDuration(200);
        r11.addListener(new AnonymousClass3(this, r17));
        if (this.mShowActionFilter == false) goto L23;
        AnimatorSet r14 = new AnimatorSet();
        if (r17 == false) goto L21;
        r14.play(ObjectAnimator.ofFloat(this.mSearchActionFilter, View.TRANSLATION_X, new float[]{0.0f, this.mAnimDistance})).with(ObjectAnimator.ofFloat(this.mSearchActionFilter, View.ALPHA, new float[]{1.0f, 0.0f}));
        long r15 = 200;
    L22:
        r14.setDuration(r15);
        r14.addListener(new AnonymousClass4(this, r17));
    L24:
        AnimatorSet r16 = new AnimatorSet();
        AnimatorSet.Builder r18 = r16.play(r11).with(r10);
        if (r14 == null) goto L27;
        r18.with(r14);
    L27:
        r16.addListener(new AnonymousClass5(this, r17));
        r16.start();
        return;
    L21:
        r14.play(ObjectAnimator.ofFloat(this.mSearchActionFilter, View.TRANSLATION_X, new float[]{this.mAnimDistance, 0.0f})).with(ObjectAnimator.ofFloat(this.mSearchActionFilter, View.ALPHA, new float[]{0.0f, 1.0f}));
        r14.setStartDelay(100);
        r15 = 200;
        goto L22
    L23:
        r14 = null;
        goto L24
    L15:
        r12 = ObjectAnimator.ofFloat(this.mSearchActionCancel, View.TRANSLATION_X, new float[]{0.0f, this.mAnimDistance});
        r13 = ObjectAnimator.ofFloat(this.mSearchActionCancel, View.ALPHA, new float[]{1.0f, 0.0f});
        goto L16
    L10:
        r10.setDuration(300);
        goto L12
    L11:
        r10.setStartDelay(100);
        r10.setDuration(200);
        goto L12
    L5:
        r10 = ValueAnimator.ofInt(new int[]{this.mSearchBarViewActiveWidth, this.mSearchBarViewInitWidth});
        goto L6
    }

    private void updateLayout() {
        ViewKt.a(this, new AnonymousClass1(this));
    }

    public final void callOnCancelClick() {
        this.mSearchActionCancel.performClick();
    }

    public OInputView getInputView() {
        return this.mSearchBar.getInputView();
    }

    public OButton getSearchActionCancel() {
        return this.mSearchActionCancel;
    }

    public OButton getSearchActionFilter() {
        return this.mSearchActionFilter;
    }

    public void hideKeyboard() {
        View r10 = getFocusedChild();
        if (r10 != null) goto L5;
        return;
    L5:
        IBinder r11 = r10.getWindowToken();
        if (r11 != null) goto L8;
        return;
    L8:
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(r11, 2);
    }

    public Boolean isPlayingAnimation() {
        return Boolean.valueOf(this.mIsPlayingAnimation);
    }

    public boolean isSearchMode() {
        return this.mIsSearchMode;
    }

    public void setAnimationListener(AnimationListener r10) {
        this.animationListener = r10;
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        this.mEnabled = r10;
        this.mSearchBar.setEnabled(r10);
        super.setEnabled(r10);
    }

    public void setOnCancelClickListener(OnCancelClickListener r10) {
        this.onCancelClickListener = r10;
    }

    public void setOnCommitCompletionListener(OnCommitCompletionListener r10) {
        this.onCommitCompletionListener = r10;
    }

    public void setOnEditorClickListener(OnEditorClickListener r10) {
        if (r10 != null) goto L4;
        this.mSearchBar.getInputView().getVInput().setOnClickListener(null);
    L5:
        this.onEditorClickListener = r10;
        return;
    L4:
        this.mSearchBar.getInputView().getVInput().setOnClickListener(new c(this));
        goto L5
    }

    public void setOnFilterClickListener(OnFilterClickListener r10) {
        this.onFilterClickListener = r10;
    }

    public void setOnSearchIconClickListener(OnSearchIconClickListener r10) {
        this.onSearchIconClickListener = r10;
    }

    public void showKeyboard() {
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(getInputView().getVInput(), 0);
    }

    public void startAnimation(final boolean r10) {
        this.mIsSearchMode = r10;
        ViewKt.b(this, new AnonymousClass2(this, r10));
    }

    public OUISearchBar(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public OUISearchBar(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        this(r10, r11, r12, 0);
    }

    public OUISearchBar(@NonNull Context r10, @Nullable AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        TypedArray r14 = r10.obtainStyledAttributes(r11, R$styleable.OUISearchBar);
        boolean r15 = r14.getBoolean(R$styleable.OUISearchBar_show_filter, false);
        this.mShowActionFilter = r15;
        this.mEnabled = r14.getBoolean(R$styleable.OUISearchBar_android_enabled, true);
        r14.recycle();
        LayoutInflater.from(getContext()).inflate(R$layout.oui_global_search_bar, this, true);
        OSearchBar r16 = (OSearchBar) findViewById(R$id.oui_search_bar);
        this.mSearchBar = r16;
        OButton r17 = (OButton) findViewById(R$id.oui_search_cancel);
        this.mSearchActionCancel = r17;
        OButton r18 = (OButton) findViewById(R$id.oui_search_filter);
        this.mSearchActionFilter = r18;
        if (r15 == false) goto L5;
        int r19 = 0;
    L6:
        r18.setVisibility(r19);
        this.mAnimDistance = 0;
        KeyEvent.Callback r20 = r16.findViewById(R$id.o_input_border_container);
        if ((r20 instanceof IOUIAlpha) == false) goto L9;
        ((IOUIAlpha) r20).setChangeAlphaWhenDisable(false);
    L9:
        r16.setOnInputFocusChange(new e(this));
        View r21 = r16.getPrefixView();
        if (r21 == null) goto L12;
        r21.setOnClickListener(new f(this));
    L12:
        r18.setOnClickListener(new g(this));
        r17.setOnClickListener(new h(this));
        updateLayout();
        setEnabled(this.mEnabled);
        return;
    L5:
        r19 = 8;
        goto L6
    }
}
