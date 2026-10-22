package com.obric.appstore.util;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class KeyboardHeightWatcher implements ViewTreeObserver.OnGlobalLayoutListener, DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lifecycle f11056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OnKeyboardHeightChangedListener f11057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference f11058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f11061f;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/appstore/util/KeyboardHeightWatcher$OnKeyboardHeightChangedListener;", "", "onKeyboardHeightChanged", "", Style.KEY_HEIGHT, "", "isVisible", "", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnKeyboardHeightChangedListener {
        void onKeyboardHeightChanged(int r10, boolean r11);
    }

    public KeyboardHeightWatcher(View r10, Lifecycle r11) {
        kotlin.jvm.internal.q.g(r10, "rootView");
        this.f11056a = r11;
        this.f11058c = new WeakReference(r10);
        if (r11 == null) goto L5;
        r11.a(this);
    L5:
        a();
    }

    public final void a() {
        if (this.f11061f == false) goto L5;
        return;
    L5:
        View r10 = (View) this.f11058c.get();
        if (r10 != null) goto L9;
        return;
    L9:
        if (r10.getViewTreeObserver().isAlive() == false) goto L12;
        r10.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.f11061f = true;
        return;
    }

    public final void b() {
        if (this.f11061f == true) goto L5;
        return;
    L5:
        View r10 = (View) this.f11058c.get();
        if (r10 != null) goto L8;
    L10:
        this.f11061f = false;
        return;
    L8:
        if (r10.getViewTreeObserver().isAlive() == false) goto L10;
        r10.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        goto L10
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner r10) {
        kotlin.jvm.internal.q.g(r10, "owner");
        this.f11057b = null;
        b();
        Lifecycle r11 = this.f11056a;
        if (r11 == null) goto L6;
        r11.d(this);
        return;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View r10 = (View) this.f11058c.get();
        if (r10 != null) goto L5;
        return;
    L5:
        View r11 = r10.getRootView();
        if (r11 != null) goto L8;
        return;
    L8:
        Rect r12 = new Rect();
        r10.getWindowVisibleDisplayFrame(r12);     // Catch: Exception -> L27
        int r13 = r11.getHeight();
        if (r13 > 0) goto L13;
        return;
    L13:
        int r14 = r13 - r12.bottom;
        boolean r15 = this.f11060e;
        if (r14 <= (((double) r13) * 0.15d)) goto L16;
        boolean r16 = true;
    L17:
        this.f11060e = r16;
        if (r14 != this.f11059d) goto L20;
        if (r15 != r16) goto L20;
        return;
    L20:
        if (r16 == true) goto L23;
        r14 = 0;
    L23:
        this.f11059d = r14;
        OnKeyboardHeightChangedListener r17 = this.f11057b;
        if (r17 == null) goto L31;
        r17.onKeyboardHeightChanged(r14, r16);
        return;
    L31:
        return;
    L16:
        r16 = false;
    }

    public final void setOnKeyboardHeightChangedListener(@Nullable OnKeyboardHeightChangedListener r10) {
        this.f11057b = r10;
    }
}
