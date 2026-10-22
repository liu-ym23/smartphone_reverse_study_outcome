package cb;

import android.util.Log;
import com.obric.capabilitykit.logger.ILogger;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements ILogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f6112a = null;

    static {
        f6112a = new w();
    }

    public w() {
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void d(String r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "tag");
        Log.d(r10, String.valueOf(r11));
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void e(String r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "tag");
        Log.e(r10, String.valueOf(r11));
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void i(String r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "tag");
        Log.i(r10, String.valueOf(r11));
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public boolean isDebug() {
        return false;
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void v(String r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "tag");
        Log.v(r10, String.valueOf(r11));
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void w(String r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "tag");
        Log.w(r10, String.valueOf(r11));
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void e(String r10, String r11, Throwable r12) {
        kotlin.jvm.internal.q.g(r10, "tag");
        Log.e(r10, String.valueOf(r11), r12);
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void w(String r10, String r11, Throwable r12) {
        kotlin.jvm.internal.q.g(r10, "tag");
        Log.w(r10, String.valueOf(r11), r12);
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void w(String r10, Throwable r11) {
        kotlin.jvm.internal.q.g(r10, "tag");
        Log.w(r10, r11);
    }
}
