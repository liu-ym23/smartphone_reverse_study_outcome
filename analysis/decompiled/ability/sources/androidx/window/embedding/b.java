package androidx.window.embedding;

import B9.Q;
import R3.f;
import android.view.WindowMetrics;
import com.stepos.deepbinder.core.cache.CallbackCache;
import com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge;
import com.stepos.taskrobot.llmapi.stepfun.g;
import com.uxsense.search.ApexSearchIndexManager;
import com.uxsense.user.ApexAccountManager;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import io.modelcontextprotocol.util.KeepAliveScheduler;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class b implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2009a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b(Object obj, int i) {
        this.f2009a = i;
        this.b = obj;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.f2009a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                return EmbeddingAdapter.m7309translateParentMetricsPredicate$lambda4((SplitRule) obj2, (WindowMetrics) obj);
            case 1:
                return ((Boolean) ((Q) obj2).invoke(obj)).booleanValue();
            case 2:
                return SystemSdkBridge.onTaskCompleted$lambda$1((R3.c) obj2, obj);
            case 3:
                return ApexSearchIndexManager.removeCreationIndex$lambda$10$lambda$9((f) obj2, obj);
            case 4:
                return ApexAccountManager.invalidateCache$lambda$23((f) obj2, obj);
            case 5:
                return ((Boolean) ((d4.b) obj2).invoke(obj)).booleanValue();
            case 6:
                return ((McpStreamableServerSession.McpStreamableServerSessionStream) obj2).equals((McpStreamableServerSession.McpStreamableServerSessionStream) obj);
            case 7:
                return ((KeepAliveScheduler) obj2).lambda$start$5((Throwable) obj);
            case 8:
                return CallbackCache.removeCallback$lambda$7((g) obj2, obj);
            case 9:
                return CallbackCache.removeCallback$lambda$5((f) obj2, obj);
            case 10:
                return CallbackCache.notifyCallbackToRecycle$lambda$2((R3.c) obj2, obj);
            case 11:
                return ((Predicate) obj2).test((Throwable) obj);
            default:
                return ((Boolean) ((g) obj2).invoke(obj)).booleanValue();
        }
    }
}
