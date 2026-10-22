package stepai.aios.guiagent.tracer;

import O7.i;
import android.content.Context;
import android.util.Base64;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.statsrpk.service.c;
import io.modelcontextprotocol.spec.McpSchema;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u0003R\u0014\u0010\u001b\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lstepai/aios/guiagent/tracer/TraceScreenshotStore;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "LC7/r;", McpSchema.METHOD_INITIALIZE, "(Landroid/content/Context;)V", "", "sessionId", "stepId", "screenshotBase64", "Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;", "persist", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;", "ref", "", "readBytes", "(Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;)[B", "readBase64", "(Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;)Ljava/lang/String;", "deleteSession", "(Ljava/lang/String;)V", "deleteScreenshot", "(Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;)V", "clearAll", "TAG", "Ljava/lang/String;", "ROOT_DIR", "Ljava/io/File;", "traceDir", "Ljava/io/File;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TraceScreenshotStore {
    public static final TraceScreenshotStore INSTANCE = new TraceScreenshotStore();
    private static final String ROOT_DIR = "gui_traces";
    private static final String TAG = "TraceScreenshotStore";
    private static volatile File traceDir;

    private TraceScreenshotStore() {
    }

    public final void clearAll() {
        Object objA;
        File file = traceDir;
        if (file == null) {
            return;
        }
        try {
            objA = Boolean.valueOf(i.T(file));
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            c.n("Failed to clear trace screenshots: ", thA.getMessage(), TAG);
        }
        file.mkdirs();
    }

    public final void deleteScreenshot(GuiStepScreenshotRef ref) {
        File file;
        Object objA;
        if (ref == null || (file = traceDir) == null) {
            return;
        }
        File file2 = new File(new File(file, ref.getSessionId()), ref.getFileName());
        if (file2.exists()) {
            try {
                objA = Boolean.valueOf(file2.delete());
            } catch (Throwable th) {
                objA = b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                c.o("Failed to delete screenshot ", ref.getFileName(), ": ", thA.getMessage(), TAG);
            }
        }
    }

    public final void deleteSession(String sessionId) {
        Object objA;
        k.f(sessionId, "sessionId");
        File file = traceDir;
        if (file == null) {
            return;
        }
        File file2 = new File(file, sessionId);
        if (file2.exists()) {
            try {
                objA = Boolean.valueOf(i.T(file2));
            } catch (Throwable th) {
                objA = b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                c.n("Failed to delete session screenshots: ", thA.getMessage(), TAG);
            }
        }
    }

    public final void initialize(Context context) {
        k.f(context, "context");
        File file = new File(context.getCacheDir(), ROOT_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        traceDir = file;
    }

    public final GuiStepScreenshotRef persist(String sessionId, String stepId, String screenshotBase64) {
        Object objA;
        k.f(sessionId, "sessionId");
        k.f(stepId, "stepId");
        k.f(screenshotBase64, "screenshotBase64");
        File file = traceDir;
        Object obj = null;
        if (file == null) {
            return null;
        }
        try {
            File file2 = new File(file, sessionId);
            file2.mkdirs();
            String strConcat = stepId.concat(".img");
            File file3 = new File(file2, strConcat);
            byte[] bArrDecode = Base64.decode(screenshotBase64, 0);
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            try {
                fileOutputStream.write(bArrDecode);
                fileOutputStream.close();
                objA = new GuiStepScreenshotRef(sessionId, stepId, strConcat);
            } finally {
            }
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA == null) {
            obj = objA;
        } else {
            c.n("Failed to persist screenshot: ", thA.getMessage(), TAG);
        }
        return (GuiStepScreenshotRef) obj;
    }

    public final String readBase64(GuiStepScreenshotRef ref) {
        k.f(ref, "ref");
        byte[] bytes = readBytes(ref);
        if (bytes == null) {
            return null;
        }
        return Base64.encodeToString(bytes, 2);
    }

    public final byte[] readBytes(GuiStepScreenshotRef ref) {
        Object objA;
        k.f(ref, "ref");
        File file = traceDir;
        Object obj = null;
        if (file != null) {
            File file2 = new File(new File(file, ref.getSessionId()), ref.getFileName());
            if (file2.exists()) {
                try {
                    objA = i.V(file2);
                } catch (Throwable th) {
                    objA = b.a(th);
                }
                Throwable thA = Result.a(objA);
                if (thA == null) {
                    obj = objA;
                } else {
                    c.n("Failed to read screenshot: ", thA.getMessage(), TAG);
                }
                return (byte[]) obj;
            }
        }
        return null;
    }
}
