package Ka;

import android.util.Log;
import com.apm.insight.log.VLog;
import kotlin.jvm.internal.k;
import stepai.android.logger.ILogger;

/* loaded from: classes4.dex */
public final class a implements ILogger {

    /* renamed from: a, reason: collision with root package name */
    public static final a f916a = new a();

    @Override // stepai.android.logger.ILogger
    public final void d(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        Log.d(tag, msg);
        VLog.d(tag, msg);
    }

    @Override // stepai.android.logger.ILogger
    public final void e(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        Log.e(tag, msg);
        VLog.e(tag, msg);
    }

    @Override // stepai.android.logger.ILogger
    public final void i(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        Log.i(tag, msg);
        VLog.i(tag, msg);
    }

    @Override // stepai.android.logger.ILogger
    public final void v(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        Log.v(tag, msg);
        VLog.v(tag, msg);
    }

    @Override // stepai.android.logger.ILogger
    public final String vendorDid() {
        int i = b.f917a;
        return "";
    }

    @Override // stepai.android.logger.ILogger
    public final void w(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        Log.w(tag, msg);
        VLog.w(tag, msg);
    }
}
