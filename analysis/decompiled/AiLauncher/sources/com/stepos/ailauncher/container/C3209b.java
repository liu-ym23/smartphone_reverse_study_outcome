package com.stepos.ailauncher.container;

import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/container/b;", "", "<init>", "()V", "LY8/t;", "c", Const.INTENT_KEY_UMID, "", "RELEASE_GRACE_MS", "J", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "LXa/k;", "", "_dialogHoldsKeyboard", "LXa/k;", "LXa/t;", "dialogHoldsKeyboard", "LXa/t;", Const.INTENT_KEY_PKGNAME, "()LXa/t;", "releasePending", "Z", "Ljava/lang/Runnable;", "releaseRunnable", "Ljava/lang/Runnable;", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.container.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3209b {
    private static final long RELEASE_GRACE_MS = 350;
    private static final Xa.k<Boolean> _dialogHoldsKeyboard;
    private static final Xa.t<Boolean> dialogHoldsKeyboard;
    private static boolean releasePending;
    private static final Runnable releaseRunnable;
    public static final C3209b INSTANCE = new C3209b();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    static {
        Xa.k<Boolean> kVarA = Xa.u.a(Boolean.FALSE);
        _dialogHoldsKeyboard = kVarA;
        dialogHoldsKeyboard = Xa.d.c(kVarA);
        releaseRunnable = new Runnable() { // from class: com.stepos.ailauncher.container.a
            @Override // java.lang.Runnable
            public final void run() {
                C3209b.e();
            }
        };
    }

    public static final void e() {
        releasePending = false;
        _dialogHoldsKeyboard.setValue(Boolean.FALSE);
    }

    public final Xa.t<Boolean> b() {
        return dialogHoldsKeyboard;
    }

    public final void c() {
        mainHandler.removeCallbacks(releaseRunnable);
        releasePending = false;
        _dialogHoldsKeyboard.setValue(Boolean.TRUE);
    }

    public final void d() {
        if (!_dialogHoldsKeyboard.getValue().booleanValue() || releasePending) {
            return;
        }
        releasePending = true;
        mainHandler.postDelayed(releaseRunnable, 350L);
    }
}
