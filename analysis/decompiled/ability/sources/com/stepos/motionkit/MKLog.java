package com.stepos.motionkit;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\tJ)\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/motionkit/MKLog;", "", AppAgent.CONSTRUCT, "()V", "", "subtag", NotificationCompat.CATEGORY_MESSAGE, "LC7/r;", "v", "(Ljava/lang/String;Ljava/lang/String;)V", "d", "i", "", "t", "w", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "e", "TAG", "Ljava/lang/String;", "", "enabled", "Z", "getEnabled", "()Z", "setEnabled", "(Z)V", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MKLog {
    private static final String TAG = "MotionKit";
    public static final MKLog INSTANCE = new MKLog();
    private static boolean enabled = true;

    private MKLog() {
    }

    public static /* synthetic */ void e$default(MKLog mKLog, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        mKLog.e(str, str2, th);
    }

    public static /* synthetic */ void w$default(MKLog mKLog, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        mKLog.w(str, str2, th);
    }

    public final void d(String subtag, String msg) {
        k.f(subtag, "subtag");
        k.f(msg, "msg");
        if (enabled) {
            Log.d("MotionKit/".concat(subtag), msg);
        }
    }

    public final void e(String subtag, String msg, Throwable t9) {
        k.f(subtag, "subtag");
        k.f(msg, "msg");
        if (enabled) {
            Log.e("MotionKit/".concat(subtag), msg, t9);
        }
    }

    public final boolean getEnabled() {
        return enabled;
    }

    public final void i(String subtag, String msg) {
        k.f(subtag, "subtag");
        k.f(msg, "msg");
        if (enabled) {
            Log.i("MotionKit/".concat(subtag), msg);
        }
    }

    public final void setEnabled(boolean z10) {
        enabled = z10;
    }

    public final void v(String subtag, String msg) {
        k.f(subtag, "subtag");
        k.f(msg, "msg");
        if (enabled) {
            Log.v("MotionKit/".concat(subtag), msg);
        }
    }

    public final void w(String subtag, String msg, Throwable t9) {
        k.f(subtag, "subtag");
        k.f(msg, "msg");
        if (enabled) {
            Log.w("MotionKit/".concat(subtag), msg, t9);
        }
    }
}
