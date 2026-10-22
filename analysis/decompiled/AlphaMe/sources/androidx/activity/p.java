package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.AbstractC0328z;
import androidx.lifecycle.EnumC0326x;
import androidx.lifecycle.G;
import androidx.lifecycle.I;
import com.stepos.alphame.R;
import j0.C0631f;
import j0.C0632g;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class p extends Dialog implements G, B, j0.h {

    /* renamed from: a, reason: collision with root package name */
    public I f2401a;

    /* renamed from: b, reason: collision with root package name */
    public final C0632g f2402b;

    /* renamed from: c, reason: collision with root package name */
    public final A f2403c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, int i4) {
        super(context, i4);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2402b = E3.b.e(this);
        this.f2403c = new A(new d(2, this));
    }

    public static void a(p this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        c();
        super.addContentView(view, layoutParams);
    }

    public final I b() {
        I i4 = this.f2401a;
        if (i4 != null) {
            return i4;
        }
        I i5 = new I(this);
        this.f2401a = i5;
        return i5;
    }

    public final void c() {
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window!!.decorView");
        B0.f.r0(decorView, this);
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        View decorView2 = window2.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView2, "window!!.decorView");
        Intrinsics.checkNotNullParameter(decorView2, "<this>");
        Intrinsics.checkNotNullParameter(this, "onBackPressedDispatcherOwner");
        decorView2.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        View decorView3 = window3.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView3, "window!!.decorView");
        com.airbnb.lottie.h.E(decorView3, this);
    }

    @Override // androidx.lifecycle.G
    public final AbstractC0328z getLifecycle() {
        return b();
    }

    @Override // androidx.activity.B
    public final A getOnBackPressedDispatcher() {
        return this.f2403c;
    }

    @Override // j0.h
    public final C0631f getSavedStateRegistry() {
        return this.f2402b.f13127b;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.f2403c.a();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        OnBackInvokedDispatcher invoker = getOnBackInvokedDispatcher();
        Intrinsics.checkNotNullExpressionValue(invoker, "onBackInvokedDispatcher");
        A a4 = this.f2403c;
        a4.getClass();
        Intrinsics.checkNotNullParameter(invoker, "invoker");
        a4.f2376e = invoker;
        a4.b(a4.f2378g);
        this.f2402b.b(bundle);
        b().e(EnumC0326x.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkNotNullExpressionValue(bundleOnSaveInstanceState, "super.onSaveInstanceState()");
        this.f2402b.c(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        b().e(EnumC0326x.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        b().e(EnumC0326x.ON_DESTROY);
        this.f2401a = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i4) {
        c();
        super.setContentView(i4);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        c();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        c();
        super.setContentView(view, layoutParams);
    }
}
