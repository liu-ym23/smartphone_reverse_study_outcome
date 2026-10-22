package com.stepos.ailauncher.taskstore.livenotification;

import android.graphics.Rect;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/c;", "", "Landroid/view/View;", "host", "Lkotlin/Function1;", "", "LY8/t;", "onExposed", "<init>", "(Landroid/view/View;Lp9/l;)V", "taskId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "", "isVisible", "e", "(Z)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "()V", "f", Const.INTENT_KEY_UMID, "()Z", "Landroid/view/View;", "Lp9/l;", "Ljava/lang/String;", "Ljava/lang/Runnable;", "exposeRunnable", "Ljava/lang/Runnable;", "Companion", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.livenotification.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3715c {
    public static final long EXPOSURE_DWELL_MS = 1000;
    private final Runnable exposeRunnable;
    private final View host;
    private final InterfaceC5074l<String, Y8.t> onExposed;
    private String taskId;

    /* JADX WARN: Multi-variable type inference failed */
    public C3715c(View host, InterfaceC5074l<? super String, Y8.t> onExposed) {
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(onExposed, "onExposed");
        this.host = host;
        this.onExposed = onExposed;
        this.exposeRunnable = new Runnable() { // from class: com.stepos.ailauncher.taskstore.livenotification.b
            @Override // java.lang.Runnable
            public final void run() {
                C3715c.c(this.f29292a);
            }
        };
    }

    public static final void c(C3715c c3715c) {
        String str = c3715c.taskId;
        if (str != null && c3715c.d()) {
            c3715c.onExposed.invoke(str);
        }
    }

    public final void b(String taskId) {
        g();
        if (taskId == null || La.H.x0(taskId)) {
            taskId = null;
        }
        this.taskId = taskId;
        if (this.host.isShown()) {
            f();
        }
    }

    public final boolean d() {
        if (this.host.getWindowVisibility() == 0 && this.host.isShown() && this.host.getWidth() > 0 && this.host.getHeight() > 0) {
            Rect rect = new Rect();
            if (this.host.getGlobalVisibleRect(rect) && !rect.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final void e(boolean isVisible) {
        if (isVisible) {
            f();
        } else {
            g();
        }
    }

    public final void f() {
        if (this.taskId == null) {
            return;
        }
        this.host.removeCallbacks(this.exposeRunnable);
        this.host.postDelayed(this.exposeRunnable, 1000L);
    }

    public final void g() {
        this.host.removeCallbacks(this.exposeRunnable);
    }
}
