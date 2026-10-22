package stepos.support.v7.app;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.StyleRes;
import com.stepos.activeview.moveline.item.ViewTweenItem;
import com.stepos.alphame.R;
import stepos.support.v7.widget.PopupNestedScrollingLayout;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes2.dex */
public abstract class D extends AbstractActivityC0866k {
    public static final String EXTRA_KEY_IS_POPUP = "popup_activity";
    public static final String EXTRA_KEY_THEME_ID = "popup_theme_id";
    public static final String POPUP_STACK_TAG = "popup_stack";
    private G mLitePopup;
    private boolean mSubDecorInstalled;
    private Toolbar mToolbar;
    private Boolean mIsPopup = Boolean.TRUE;

    @StyleRes
    private int mThemeId = R.style.Theme_StepOS_AppCompat_Light_LitePopupOverlay;

    @Override // stepos.support.v7.app.AbstractActivityC0866k, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.mIsPopup.booleanValue()) {
            super.addContentView(view, layoutParams);
            return;
        }
        f();
        ((ViewGroup) findViewById(android.R.id.content)).addView(view, layoutParams);
        onContentChanged();
    }

    public void dismiss() {
        superOnBackPressed();
    }

    public final void f() {
        if (this.mSubDecorInstalled) {
            return;
        }
        super.setContentView(R.layout.activity_lite_popup);
        View viewFindViewById = findViewById(R.id.content_panel);
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        if (viewGroup != null) {
            viewGroup.setId(-1);
            viewFindViewById.setId(android.R.id.content);
            if (viewGroup instanceof FrameLayout) {
                ((FrameLayout) viewGroup).setForeground(null);
            }
        }
        this.mSubDecorInstalled = true;
        Toolbar toolbar = (Toolbar) findViewById(R.id.title_bar);
        this.mToolbar = toolbar;
        setSupportActionBar(toolbar);
        this.mLitePopup = new G(this);
    }

    public void finish(boolean z4) {
        finish();
    }

    public C getLitePopup() {
        return this.mLitePopup;
    }

    public boolean isPopup() {
        return this.mIsPopup.booleanValue();
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k, androidx.activity.o, android.app.Activity
    public void onBackPressed() {
        if (this.mIsPopup.booleanValue()) {
            this.mLitePopup.f14273d.superOnBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, androidx.activity.o, androidx.core.app.k, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.mIsPopup = Boolean.valueOf(bundle.getBoolean(EXTRA_KEY_IS_POPUP, this.mIsPopup.booleanValue()));
            this.mThemeId = bundle.getInt(EXTRA_KEY_THEME_ID, this.mThemeId);
        } else if (getIntent() != null) {
            Intent intent = getIntent();
            this.mIsPopup = Boolean.valueOf(intent.getBooleanExtra(EXTRA_KEY_IS_POPUP, this.mIsPopup.booleanValue()));
            this.mThemeId = intent.getIntExtra(EXTRA_KEY_THEME_ID, this.mThemeId);
        }
        if (isPopup()) {
            getTheme().applyStyle(this.mThemeId, true);
            f();
            G g4 = this.mLitePopup;
            D d4 = g4.f14273d;
            d4.getWindow().setBackgroundDrawable(g4.f14270a);
            g4.f14272c.getViewTreeObserver().addOnPreDrawListener(new A.e(3, g4));
            d4.overridePendingTransition(0, 0);
            g4.f14279j.setDecorFitsSystemWindows(false);
        } else {
            setTheme(this.mThemeId);
            overridePendingTransition(R.anim.stepos_activity_to_next_open_enter, R.anim.stepos_activity_to_next_open_exit);
        }
        super.onCreate(bundle);
        getWindow().setWindowAnimations(R.style.StepOS_Popup_Window_Animation_Style);
        if (isPopup()) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1280);
        }
    }

    public void onDismissProgress(float f4) {
    }

    public void onDismissed() {
    }

    public void onDragToDismissTriggered() {
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mIsPopup.booleanValue() && this.mLitePopup.c()) {
            Log.d(POPUP_STACK_TAG, " bottom stack resume, to reset state ");
            I iB = I.b();
            if (iB.f14287e) {
                Log.e(POPUP_STACK_TAG, " bottom stack resume, but still in stack, call exit ");
                iB.a();
            }
            iB.f14287e = false;
        }
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k, androidx.activity.o, androidx.core.app.k, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(EXTRA_KEY_IS_POPUP, this.mIsPopup.booleanValue());
        bundle.putInt(EXTRA_KEY_THEME_ID, this.mThemeId);
    }

    public void performDismissProgress(float f4) {
        onDismissProgress(f4);
    }

    public void performDismissed() {
        onDismissed();
    }

    public void performDragTriggered() {
        onDragToDismissTriggered();
    }

    public void prepareStackPopup(int i4) {
        G g4 = this.mLitePopup;
        g4.getClass();
        I iB = I.b();
        if (iB.f14283a == null) {
            D d4 = g4.f14273d;
            iB.f14283a = d4;
            iB.f14284b = (PopupNestedScrollingLayout) d4.findViewById(R.id.nested_scrolling_layout);
            iB.f14288f = i4;
        }
        iB.f14287e = true;
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k, androidx.activity.o, android.app.Activity
    public void setContentView(int i4) {
        if (!this.mIsPopup.booleanValue()) {
            super.setContentView(i4);
            return;
        }
        f();
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this).inflate(i4, viewGroup);
        onContentChanged();
    }

    public void superFinish() {
        super.finish();
    }

    public void superOnBackPressed() {
        super.onBackPressed();
        performDismissed();
    }

    @Override // android.app.Activity
    public void finish() {
        int i4 = 1;
        if (!this.mIsPopup.booleanValue()) {
            super.finish();
            overridePendingTransition(R.anim.stepos_activity_to_next_close_enter, R.anim.stepos_activity_to_next_close_exit);
            return;
        }
        G g4 = this.mLitePopup;
        AnimatorSet animatorSet = g4.f14277h;
        if (animatorSet == null || !animatorSet.isRunning()) {
            g4.f14277h = new AnimatorSet();
            PopupNestedScrollingLayout popupNestedScrollingLayout = g4.f14272c;
            int uncollapsibleHeight = popupNestedScrollingLayout.getCurrentScrollY() <= 0 ? popupNestedScrollingLayout.getUncollapsibleHeight() : popupNestedScrollingLayout.getMeasuredHeight();
            W.n nVar = new W.n();
            nVar.a(0.93f);
            nVar.b(400.0f);
            W.m mVar = g4.f14278i;
            mVar.f1974m = nVar;
            float f4 = uncollapsibleHeight;
            nVar.f1985i = f4;
            if (g4.a()) {
                mVar.i();
            } else {
                popupNestedScrollingLayout.setTranslationY(f4);
            }
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(g4.f14270a, ViewTweenItem.ALPHA, g4.f14276g, 0);
            objectAnimatorOfInt.setInterpolator(G.f14269k);
            objectAnimatorOfInt.setDuration(300L);
            g4.f14277h.playTogether(objectAnimatorOfInt);
            g4.f14277h.addListener(new F(g4, i4));
            g4.f14277h.start();
        }
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k, androidx.activity.o, android.app.Activity
    public void setContentView(View view) {
        if (!this.mIsPopup.booleanValue()) {
            super.setContentView(view);
            return;
        }
        f();
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        onContentChanged();
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.mIsPopup.booleanValue()) {
            super.setContentView(view, layoutParams);
            return;
        }
        f();
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        onContentChanged();
    }
}
