package com.stepos.ailauncher.chat.manager;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity;
import io.ktor.http.ContentType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ!\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J!\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0014\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0011J\u001f\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u000fR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/W;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "Landroid/app/Dialog;", C3081a.FOCUS_DIALOG_NAME, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/app/Dialog;)V", Const.INTENT_KEY_APIKEY, "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", "savedInstanceState", "onActivityPreCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityDestroyed", "(Landroid/app/Activity;)V", "onActivityStarted", "onActivityStopped", "onActivityCreated", "onActivityResumed", "onActivityPaused", "outState", "onActivitySaveInstanceState", "Landroid/app/Application;", ContentType.Application.TYPE, "Landroid/app/Application;", "", "Lcom/stepos/ailauncher/chat/panelui/c;", "dialogs", "Ljava/util/Map;", "Lcom/stepos/ailauncher/chat/manager/X;", "viewers", "Lcom/stepos/ailauncher/chat/manager/X;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class W implements Application.ActivityLifecycleCallbacks {
    private static Application application;
    public static final W INSTANCE = new W();
    private static final Map<Dialog, com.stepos.ailauncher.chat.panelui.c> dialogs = new LinkedHashMap();
    private static X<Activity> viewers = new X<>();

    public final void a(Dialog dialog) {
        kotlin.jvm.internal.p.i(dialog, "dialog");
        Map<Dialog, com.stepos.ailauncher.chat.panelui.c> map = dialogs;
        map.remove(dialog);
        if (map.isEmpty()) {
            Application application2 = application;
            if (application2 != null) {
                application2.unregisterActivityLifecycleCallbacks(this);
            }
            application = null;
            viewers = new X<>();
        }
    }

    public final void b(Dialog dialog) {
        kotlin.jvm.internal.p.i(dialog, "dialog");
        Map<Dialog, com.stepos.ailauncher.chat.panelui.c> map = dialogs;
        if (map.containsKey(dialog)) {
            return;
        }
        Context applicationContext = dialog.getContext().getApplicationContext();
        Application application2 = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application2 == null) {
            return;
        }
        if (application == null) {
            application = application2;
            application2.registerActivityLifecycleCallbacks(this);
        }
        map.put(dialog, new com.stepos.ailauncher.chat.panelui.c(dialog));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        if (viewers.b(activity, activity.isChangingConfigurations())) {
            for (Map.Entry<Dialog, com.stepos.ailauncher.chat.panelui.c> entry : dialogs.entrySet()) {
                Dialog key = entry.getKey();
                com.stepos.ailauncher.chat.panelui.c value = entry.getValue();
                if (key.isShowing()) {
                    value.resume();
                }
            }
            AuthManager.INSTANCE.Q0(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(activity, "activity");
        if (activity instanceof PolicyHtmlViewerActivity) {
            viewers.a(activity);
            Iterator<T> it = dialogs.values().iterator();
            while (it.hasNext()) {
                ((com.stepos.ailauncher.chat.panelui.c) it.next()).a();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        kotlin.jvm.internal.p.i(activity, "activity");
        kotlin.jvm.internal.p.i(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        viewers.c(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        if (viewers.d(activity, activity.isFinishing(), activity.isChangingConfigurations())) {
            AuthManager.INSTANCE.o0(Z8.F.m1(dialogs.keySet()));
        }
    }
}
