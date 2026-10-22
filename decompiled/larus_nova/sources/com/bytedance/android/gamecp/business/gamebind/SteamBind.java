package com.bytedance.android.gamecp.business.gamebind;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.gamecp.common.setting.config.b2;
import com.bytedance.android.gamecp.common.ui.k;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wu.d0;
import yr.c;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamebind/SteamBind;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/content/Context;", "c", "Landroid/app/Activity;", "getActivity", "", LiveCommonConstants.REASON_ON_DEDTROY, "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SteamBind implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b2 f53372a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Disposable f53373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Disposable f53374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WeakReference<k> f53375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SteamBind f53376e = null;

    private SteamBind() {
    }

    static {
        f53376e = new SteamBind();
        f53372a = d0.f561294a.getValue();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        c.a("SteamBind", "releaseAllWhenDestroy");
        Disposable r100 = f53373b;
        if (r100 != null) goto L5;
    L9:
        Disposable r101 = f53374c;
        if (r101 != null) goto L12;
    L14:
        WeakReference<k> r102 = f53375d;
        if (r102 == null) goto L17;
        k r103 = r102.get();
    L18:
        if (r103 == null) goto L36;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 != null) goto L22;
    L24:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L27 Exception -> L29
    L33:
        DialogLancet.afterDialogDismiss(r103);
        goto L36
    L29:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L27
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L27
        if (r105 == null) goto L33;
        d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L22:
        if (Looper.myLooper() == r104.getLooper()) goto L24;
        r104.post(DialogLancet.createDismissRunnable(r103));
    L36:
        f53374c = null;
        f53375d = null;
        ComponentCallbacks2 r106 = getActivity(null);
        if ((r106 instanceof LifecycleOwner) == false) goto L44;
        ((LifecycleOwner) r106).getLifecycle().removeObserver(this);
        return;
    L44:
        return;
    L17:
        r103 = null;
        goto L18
    L12:
        if (r101.isDisposed() == true) goto L14;
        Disposable r107 = f53374c;
        Intrinsics.checkNotNull(r107);
        r107.dispose();
        goto L14
    L5:
        if (r100.isDisposed() == true) goto L9;
        Disposable r108 = f53373b;
        if (r108 == null) goto L9;
        r108.dispose();
        goto L9
    }

    private final Activity getActivity(Context r100) {
    L3:
        if (r100 == null) goto L11;
        if ((r100 instanceof Activity) == true) goto L7;
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L7:
        return (Activity) r100;
    L11:
        return null;
    }
}
