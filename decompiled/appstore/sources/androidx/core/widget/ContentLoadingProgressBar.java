package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f2800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Runnable f2801f;

    public ContentLoadingProgressBar(@NonNull Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ void a(ContentLoadingProgressBar r10) {
        r10.d();
    }

    public static /* synthetic */ void b(ContentLoadingProgressBar r10) {
        r10.c();
    }

    public final /* synthetic */ void c() {
        this.f2797b = false;
        this.f2796a = -1;
        setVisibility(8);
    }

    public final /* synthetic */ void d() {
        this.f2798c = false;
        if (this.f2799d == true) goto L6;
        this.f2796a = System.currentTimeMillis();
        setVisibility(0);
        return;
    }

    public final void e() {
        removeCallbacks(this.f2800e);
        removeCallbacks(this.f2801f);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    public ContentLoadingProgressBar(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11, 0);
        this.f2796a = -1;
        this.f2797b = false;
        this.f2798c = false;
        this.f2799d = false;
        this.f2800e = new d(this);
        this.f2801f = new e(this);
    }
}
