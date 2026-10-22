package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.CallSuper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.o0;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class ComponentDialog extends Dialog implements LifecycleOwner, OnBackPressedDispatcherOwner, SavedStateRegistryOwner {

    @Nullable
    private LifecycleRegistry _lifecycleRegistry;

    @NotNull
    private final OnBackPressedDispatcher onBackPressedDispatcher;

    @NotNull
    private final SavedStateRegistryController savedStateRegistryController;

    public ComponentDialog(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        int r11 = 0;
        this(r10, r11, 2, null);
    }

    public static /* synthetic */ void a(ComponentDialog r10) {
        c(r10);
    }

    public static final void c(ComponentDialog r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        super.onBackPressed();
    }

    public static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }

    @Override // android.app.Dialog
    public void addContentView(View r10, ViewGroup.LayoutParams r11) {
        kotlin.jvm.internal.q.g(r10, "view");
        initializeViewTreeOwners();
        super.addContentView(r10, r11);
    }

    public final LifecycleRegistry b() {
        LifecycleRegistry r10 = this._lifecycleRegistry;
        if (r10 != null) goto L6;
        LifecycleRegistry r11 = new LifecycleRegistry(this);
        this._lifecycleRegistry = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        return b();
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    @NotNull
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    @NotNull
    public SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.b();
    }

    @CallSuper
    public void initializeViewTreeOwners() {
        Window r10 = getWindow();
        kotlin.jvm.internal.q.d(r10);
        View r11 = r10.getDecorView();
        kotlin.jvm.internal.q.f(r11, "window!!.decorView");
        o0.a(r11, this);
        Window r12 = getWindow();
        kotlin.jvm.internal.q.d(r12);
        View r13 = r12.getDecorView();
        kotlin.jvm.internal.q.f(r13, "window!!.decorView");
        r.a(r13, this);
        Window r14 = getWindow();
        kotlin.jvm.internal.q.d(r14);
        View r15 = r14.getDecorView();
        kotlin.jvm.internal.q.f(r15, "window!!.decorView");
        androidx.savedstate.c.a(r15, this);
    }

    @Override // android.app.Dialog
    @CallSuper
    public void onBackPressed() {
        this.onBackPressedDispatcher.k();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        if (Build.VERSION.SDK_INT < 33) goto L5;
        OnBackPressedDispatcher r11 = this.onBackPressedDispatcher;
        OnBackInvokedDispatcher r12 = getOnBackInvokedDispatcher();
        kotlin.jvm.internal.q.f(r12, "onBackInvokedDispatcher");
        r11.l(r12);
    L5:
        this.savedStateRegistryController.d(r10);
        b().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Dialog
    @NotNull
    public Bundle onSaveInstanceState() {
        Bundle r10 = super.onSaveInstanceState();
        kotlin.jvm.internal.q.f(r10, "super.onSaveInstanceState()");
        this.savedStateRegistryController.e(r10);
        return r10;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        b().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        b().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this._lifecycleRegistry = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int r10) {
        initializeViewTreeOwners();
        super.setContentView(r10);
    }

    public /* synthetic */ ComponentDialog(Context r10, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = 0;
    L5:
        this(r10, r11);
    }

    public ComponentDialog(Context r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10, r11);
        this.savedStateRegistryController = SavedStateRegistryController.f4729d.a(this);
        this.onBackPressedDispatcher = new OnBackPressedDispatcher(new h(this));
    }

    @Override // android.app.Dialog
    public void setContentView(View r10) {
        kotlin.jvm.internal.q.g(r10, "view");
        initializeViewTreeOwners();
        super.setContentView(r10);
    }

    @Override // android.app.Dialog
    public void setContentView(View r10, ViewGroup.LayoutParams r11) {
        kotlin.jvm.internal.q.g(r10, "view");
        initializeViewTreeOwners();
        super.setContentView(r10, r11);
    }
}
