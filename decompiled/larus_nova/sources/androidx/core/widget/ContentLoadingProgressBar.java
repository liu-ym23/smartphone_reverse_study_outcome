package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes17.dex */
public class ContentLoadingProgressBar extends ProgressBar {
    private static final int MIN_DELAY_MS = 500;
    private static final int MIN_SHOW_TIME_MS = 500;
    private final Runnable mDelayedHide;
    private final Runnable mDelayedShow;
    boolean mDismissed;
    boolean mPostedHide;
    boolean mPostedShow;
    long mStartTime;

    public static /* synthetic */ void a(ContentLoadingProgressBar r100) {
        r100.lambda$new$0();
    }

    public static /* synthetic */ void b(ContentLoadingProgressBar r100) {
        r100.hideOnUiThread();
    }

    public static /* synthetic */ void c(ContentLoadingProgressBar r100) {
        r100.lambda$new$1();
    }

    public static /* synthetic */ void d(ContentLoadingProgressBar r100) {
        r100.showOnUiThread();
    }

    private void hideOnUiThread() {
        this.mDismissed = true;
        removeCallbacks(this.mDelayedShow);
        this.mPostedShow = false;
        long r100 = System.currentTimeMillis();
        long r101 = this.mStartTime;
        long r102 = r100 - r101;
        if (r102 < 500) goto L5;
    L10:
        setVisibility(8);
        return;
    L5:
        if (r101 == (-1)) goto L10;
        if (this.mPostedHide == true) goto L12;
        postDelayed(this.mDelayedHide, 500 - r102);
        this.mPostedHide = true;
        return;
    }

    private /* synthetic */ void lambda$new$0() {
        this.mPostedHide = false;
        this.mStartTime = -1;
        setVisibility(8);
    }

    private /* synthetic */ void lambda$new$1() {
        this.mPostedShow = false;
        if (this.mDismissed == true) goto L6;
        this.mStartTime = System.currentTimeMillis();
        setVisibility(0);
        return;
    }

    private void removeCallbacks() {
        removeCallbacks(this.mDelayedHide);
        removeCallbacks(this.mDelayedShow);
    }

    private void showOnUiThread() {
        this.mStartTime = -1;
        this.mDismissed = false;
        removeCallbacks(this.mDelayedHide);
        this.mPostedHide = false;
        if (this.mPostedShow == true) goto L6;
        postDelayed(this.mDelayedShow, 500);
        this.mPostedShow = true;
        return;
    }

    public void hide() {
        post(new b(this));
    }

    public void show() {
        post(new a(this));
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks();
    }

    public ContentLoadingProgressBar(Context r100) {
        this(r100, null);
    }

    public ContentLoadingProgressBar(Context r100, AttributeSet r101) {
        super(r100, r101, 0);
        this.mStartTime = -1;
        this.mPostedHide = false;
        this.mPostedShow = false;
        this.mDismissed = false;
        this.mDelayedHide = new c(this);
        this.mDelayedShow = new d(this);
    }
}
