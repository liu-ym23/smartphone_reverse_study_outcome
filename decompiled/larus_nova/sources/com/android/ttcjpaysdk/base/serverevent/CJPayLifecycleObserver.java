package com.android.ttcjpaysdk.base.serverevent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0007R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/base/serverevent/CJPayLifecycleObserver;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "page", "", "callback", "Lkotlin/Function2;", "", "", "(ILkotlin/jvm/functions/Function2;)V", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroidx/appcompat/app/AppCompatActivity;", "hasSwitchBackground", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onResume", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "start", "activity", "stop", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayLifecycleObserver implements DefaultLifecycleObserver {
    private WeakReference<AppCompatActivity> activityRef;
    private final Function2<Boolean, Integer, Unit> callback;
    private final AtomicBoolean hasSwitchBackground;
    private final int page;

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onCreate(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onCreate(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onDestroy(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onDestroy(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onPause(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onPause(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStart(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStart(this, r100);
    }

    public final void stop() {
        ProcessLifecycleOwner.Companion.get().getLifecycle().removeObserver(this);
    }

    public static final /* synthetic */ Function2 access$getCallback$p(CJPayLifecycleObserver r100) {
        return r100.callback;
    }

    public static final /* synthetic */ int access$getPage$p(CJPayLifecycleObserver r100) {
        return r100.page;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        if (this.hasSwitchBackground.get() == false) goto L6;
        this.callback.invoke(Boolean.TRUE, Integer.valueOf(this.page));
        this.hasSwitchBackground.set(false);
        return;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        this.hasSwitchBackground.set(true);
    }

    public final void start(AppCompatActivity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.activityRef = new WeakReference(r100);
        ProcessLifecycleOwner.Companion.get().getLifecycle().addObserver(this);
        WeakReference<AppCompatActivity> r101 = this.activityRef;
        if (r101 == null) goto L12;
        AppCompatActivity r102 = r101.get();
        if (r102 == null) goto L13;
        Lifecycle r103 = r102.getLifecycle();
        if (r103 == null) goto L14;
        r103.addObserver(new AnonymousClass1(this));
        return;
    L14:
        return;
    L13:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CJPayLifecycleObserver(int r100, Function2<? super Boolean, ? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.page = r100;
        this.callback = r101;
        this.hasSwitchBackground = new AtomicBoolean(false);
    }
}
