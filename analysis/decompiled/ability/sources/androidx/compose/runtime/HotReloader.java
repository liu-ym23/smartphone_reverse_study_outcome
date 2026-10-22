package androidx.compose.runtime;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/compose/runtime/HotReloader;", "", AppAgent.CONSTRUCT, "()V", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class HotReloader {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0015\u0010\u0003¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/HotReloader$Companion;", "", AppAgent.CONSTRUCT, "()V", "context", "saveStateAndDispose", "(Ljava/lang/Object;)Ljava/lang/Object;", "token", "LC7/r;", "loadStateAndCompose", "(Ljava/lang/Object;)V", "simulateHotReload$runtime", "simulateHotReload", "", "key", "invalidateGroupsWithKey", "(I)V", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors", "()Ljava/util/List;", "clearErrors", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private final void loadStateAndCompose(Object token) {
            Recomposer.INSTANCE.loadStateAndComposeForHotReload$runtime(token);
        }

        private final Object saveStateAndDispose(Object context) {
            return Recomposer.INSTANCE.saveStateAndDisposeForHotReload$runtime();
        }

        public final void clearErrors() {
            Recomposer.INSTANCE.clearErrors$runtime();
        }

        public final List<RecomposerErrorInfo> getCurrentErrors() {
            return Recomposer.INSTANCE.getCurrentErrors$runtime();
        }

        public final void invalidateGroupsWithKey(int key) {
            Recomposer.INSTANCE.invalidateGroupsWithKey$runtime(key);
        }

        public final void simulateHotReload$runtime(Object context) {
            loadStateAndCompose(saveStateAndDispose(context));
        }

        private Companion() {
        }
    }
}
