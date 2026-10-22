package A5;

import La.H;
import android.content.Context;
import android.os.StatFs;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.File;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"LA5/a;", "", "<init>", "()V", "Ljava/io/File;", "path", "", "f", "(Ljava/io/File;)J", "Landroid/content/Context;", "context", "minBytes", "", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;J)Z", "", "reason", "LY8/t;", "e", "(Ljava/lang/String;)V", "", "t", Const.INTENT_KEY_UMID, "(Ljava/lang/Throwable;)Z", "MIN_USABLE_BYTES", "J", UxipConstants.f30680s, "storeWriteDisabled", "Z", Const.INTENT_KEY_APIKEY, "()Z", "TAG", "Ljava/lang/String;", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    public static final long MIN_USABLE_BYTES = 33554432;
    private static final String TAG = "DiskSpaceGate";
    private static volatile boolean storeWriteDisabled;

    public static /* synthetic */ boolean c(a aVar, Context context, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = MIN_USABLE_BYTES;
        }
        return aVar.b(context, j10);
    }

    public final boolean a() {
        return storeWriteDisabled;
    }

    public final boolean b(Context context, long minBytes) {
        p.i(context, "context");
        File filesDir = context.getFilesDir();
        p.h(filesDir, "getFilesDir(...)");
        return f(filesDir) >= minBytes;
    }

    public final boolean d(Throwable t10) {
        while (t10 != null) {
            String message = t10.getMessage();
            if (message == null) {
                message = "";
            }
            if (H.e0(message, "ENOSPC", true) || H.e0(message, "No space left", true) || H.e0(message, "SQLITE_FULL", true)) {
                return true;
            }
            t10 = t10.getCause();
        }
        return false;
    }

    public final void e(String reason) {
        p.i(reason, "reason");
        storeWriteDisabled = true;
        Log.w(TAG, "store write disabled: " + reason);
    }

    public final long f(File path) {
        Object objB;
        File parentFile;
        p.i(path, "path");
        try {
            Result.Companion companion = Result.INSTANCE;
            if (!path.isDirectory() && (parentFile = path.getParentFile()) != null) {
                path = parentFile;
            }
            objB = Result.b(Long.valueOf(!path.exists() ? Long.MAX_VALUE : new StatFs(path.getAbsolutePath()).getAvailableBytes()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = 0L;
        }
        return ((Number) objB).longValue();
    }
}
