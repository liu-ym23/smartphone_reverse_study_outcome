package com.bytedance.android.shopping.card_list.container.init;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.shopping.card_list.common_params.CardListContainerConfig;
import com.bytedance.android.shopping.card_list.container.CardListActivity;
import com.bytedance.android.shopping.card_list.container.CardListDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes13.dex */
public final class CardListObjectContainer implements com.bytedance.android.ec.core.async.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<KClass<? extends com.bytedance.android.shopping.card_list.components.a>, com.bytedance.android.shopping.card_list.components.a> f171541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<KClass<? extends com.bytedance.android.shopping.card_list.components.a>, Function0<com.bytedance.android.shopping.card_list.components.a>> f171542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatActivity f171543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Fragment f171544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.shopping.card_list.common_params.a f171545e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CardListContainerConfig f171546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f171547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ DisposableScope f171548h;

    @Override // com.bytedance.android.ec.core.async.b, fa3.d
    public final Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f171548h.add(r100);
        return r100;
    }

    @Override // com.bytedance.android.ec.core.async.b
    public final void clearDisposable() {
        this.f171548h.clearDisposable();
    }

    @Override // com.bytedance.android.ec.core.async.b
    public final void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f171548h.remove(r100);
    }

    public final void a() {
        Fragment r100 = this.f171544d;
        AppCompatActivity r101 = null;
        if ((r100 instanceof CardListDialogFragment) == true) goto L5;
        r100 = null;
    L5:
        CardListDialogFragment r102 = (CardListDialogFragment) r100;
        if (r102 != null) goto L21;
    L13:
        AppCompatActivity r103 = this.f171543c;
        if ((r103 instanceof CardListActivity) == false) goto L17;
        r101 = r103;
    L17:
        CardListActivity r104 = (CardListActivity) r101;
        if (r104 == null) goto L23;
        r104.finish();
        return;
    L23:
        return;
    L21:
        r102.dismissAllowingStateLoss();     // Catch: Exception -> L9
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r105 = DialogFragmentLancet.sLastShowStack;
        if (r105 == null) goto L13;
        com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L13
    }

    @Override // com.bytedance.android.ec.core.async.b
    public final CompositeDisposable compositeDisposable() {
        return this.f171548h.a();
    }

    public final Context getContext() {
        AppCompatActivity r100 = this.f171543c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Fragment r101 = this.f171544d;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.getContext();
    }

    public final AppCompatActivity getActivity() {
        return this.f171543c;
    }

    public final <T extends com.bytedance.android.shopping.card_list.components.a> T b(KClass<? extends com.bytedance.android.shopping.card_list.components.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        com.bytedance.android.shopping.card_list.components.a r101 = null;
        if (this.f171541a.containsKey(r100) == false) goto L9;
        com.bytedance.android.shopping.card_list.components.a r102 = this.f171541a.get(r100);
        if ((r102 instanceof com.bytedance.android.shopping.card_list.components.a) == false) goto L20;
        r101 = r102;
    L20:
        return (T) r101;
    L9:
        Function0<com.bytedance.android.shopping.card_list.components.a> r103 = this.f171542b.get(r100);
        if (r103 == null) goto L12;
        com.bytedance.android.shopping.card_list.components.a r104 = r103.invoke();
    L13:
        if (r104 == null) goto L16;
        this.f171541a.put(r100, r104);
        c(r104);
    L16:
        if ((r104 instanceof com.bytedance.android.shopping.card_list.components.a) == true) goto L19;
        return null;
    L19:
        return (T) r104;
    L12:
        r104 = null;
        goto L13
    }

    public final void c(com.bytedance.android.shopping.card_list.components.a r100) {
        AppCompatActivity r101 = this.f171543c;
        if (r101 == null) goto L6;
        Lifecycle r102 = r101.getLifecycle();
        if (r102 == null) goto L6;
    L10:
        if (r102 == null) goto L25;
        Lifecycle.State r103 = r102.getCurrentState();
        int r104 = d.f171555a[r103.ordinal()];
        if (r104 != 2) goto L14;
        r100.onCreate();
        return;
    L14:
        if (r104 != 3) goto L16;
        r100.onCreate();
        r100.onStart();
        return;
    L16:
        if (r104 != 4) goto L18;
        r100.onCreate();
        r100.onStart();
        r100.onResume();
        return;
    L18:
        if (r104 != 5) goto L29;
        r100.onCreate();
        r100.onStart();
        r100.onResume();
        r100.onPause();
        r100.onStop();
        r100.onDestroy();
        return;
    L29:
        return;
    L25:
        return;
    L6:
        Fragment r105 = this.f171544d;
        if (r105 == null) goto L9;
        r102 = r105.getLifecycle();
        goto L10
    L9:
        r102 = null;
        goto L10
    }

    public final <T extends View> T d(int r100) {
        AppCompatActivity r101 = this.f171543c;
        if (r101 == null) goto L6;
        T r102 = (T) r101.findViewById(r100);
        if (r102 == null) goto L6;
        return r102;
    L6:
        Fragment r103 = this.f171544d;
        if (r103 == null) goto L11;
        View r104 = r103.getView();
        if (r104 == null) goto L11;
        return (T) r104.findViewById(r100);
    L11:
        return null;
    }

    public final <T extends com.bytedance.android.shopping.card_list.components.a> void e(KClass<? extends com.bytedance.android.shopping.card_list.components.a> r100, Boolean r101, Function0<? extends T> r102) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r102, "func");
        this.f171542b.put(r100, r102);
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L11;
        Function0<com.bytedance.android.shopping.card_list.components.a> r103 = this.f171542b.get(r100);
        if (r103 == null) goto L7;
        com.bytedance.android.shopping.card_list.components.a r104 = r103.invoke();
    L8:
        if (r104 == null) goto L12;
        this.f171541a.put(r100, r104);
        c(r104);
        return;
    L12:
        return;
    L7:
        r104 = null;
        goto L8
    }

    public CardListObjectContainer(AppCompatActivity r100, Fragment r101, com.bytedance.android.shopping.card_list.common_params.a r102, CardListContainerConfig r103, g r104) {
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "config");
        Intrinsics.checkNotNullParameter(r104, "screenSizeService");
        this.f171548h = new DisposableScope();
        this.f171543c = r100;
        this.f171544d = r101;
        this.f171545e = r102;
        this.f171546f = r103;
        this.f171547g = r104;
        this.f171541a = new ConcurrentHashMap();
        this.f171542b = new ConcurrentHashMap();
        if (r100 == null) goto L6;
        Lifecycle r105 = r100.getLifecycle();
        if (r105 == null) goto L6;
    L9:
        if (r105 == null) goto L12;
        r105.addObserver(new AnonymousClass1(this));
        return;
    L12:
        return;
    L6:
        if (r101 == null) goto L8;
        r105 = r101.getLifecycle();
        goto L9
    L8:
        r105 = null;
        goto L9
    }
}
