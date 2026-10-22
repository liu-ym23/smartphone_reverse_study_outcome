package androidx.appfunctions.internal;

import C7.f;
import P3.d;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RestrictTo;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import m9.AbstractC1702U;
import m9.AbstractC1729v;
import m9.C1703V;
import n9.AbstractC1749e;
import n9.AbstractC1750f;
import n9.C1748d;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\f\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Landroidx/appfunctions/internal/Dispatchers;", "", AppAgent.CONSTRUCT, "()V", "Lm9/v;", "Main$delegate", "LC7/f;", "getMain", "()Lm9/v;", "Main", "Worker$delegate", "getWorker", "Worker", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class Dispatchers {
    public static final Dispatchers INSTANCE = new Dispatchers();

    /* renamed from: Main$delegate, reason: from kotlin metadata */
    private static final f Main = kotlin.a.a(new d(9));

    /* renamed from: Worker$delegate, reason: from kotlin metadata */
    private static final f Worker = kotlin.a.a(new d(10));

    private Dispatchers() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC1749e Main_delegate$lambda$0() {
        Handler handler = new Handler(Looper.getMainLooper());
        int i = AbstractC1750f.f5371a;
        return new C1748d(handler, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC1702U Worker_delegate$lambda$0() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        k.e(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        return new C1703V(executorServiceNewSingleThreadExecutor);
    }

    public final AbstractC1729v getMain() {
        return (AbstractC1729v) Main.getF4884a();
    }

    public final AbstractC1729v getWorker() {
        return (AbstractC1729v) Worker.getF4884a();
    }
}
