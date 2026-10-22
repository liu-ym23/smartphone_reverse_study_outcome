package androidx.compose.runtime.tooling;

import A6.i;
import H7.f;
import H7.g;
import H7.h;
import S7.n;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.changelist.OperationErrorContext;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import z2.l;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00192\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0019B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\f\u001a\u00020\u000b*\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0018\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "Landroidx/compose/runtime/tooling/CompositionErrorContext;", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "LH7/f;", "Landroidx/compose/runtime/ComposerImpl;", "composer", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/ComposerImpl;)V", "", "", "composeNode", "", "attachComposeStackTrace", "(Ljava/lang/Throwable;Ljava/lang/Object;)Z", "", "currentOffset", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "buildStackTrace", "(Ljava/lang/Integer;)Ljava/util/List;", "Landroidx/compose/runtime/ComposerImpl;", "LH7/g;", "getKey", "()LH7/g;", "key", "Key", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CompositionErrorContextImpl implements CompositionErrorContext, OperationErrorContext, f {
    private final ComposerImpl composer;

    /* renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/tooling/CompositionErrorContextImpl$Key;", "LH7/g;", "Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", AppAgent.CONSTRUCT, "()V", "", "toString", "()Ljava/lang/String;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.tooling.CompositionErrorContextImpl$Key, reason: from kotlin metadata */
    public static final class Companion implements g {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public String toString() {
            return "CompositionErrorContext";
        }

        private Companion() {
        }
    }

    public CompositionErrorContextImpl(ComposerImpl composerImpl) {
        this.composer = composerImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List attachComposeStackTrace$lambda$0(CompositionErrorContextImpl compositionErrorContextImpl, Object obj) {
        return compositionErrorContextImpl.composer.stackTraceForValue$runtime(obj);
    }

    @Override // androidx.compose.runtime.tooling.CompositionErrorContext
    public boolean attachComposeStackTrace(Throwable th, Object obj) {
        return ComposeStackTraceKt.tryAttachComposeStackTrace(th, new i(12, this, obj));
    }

    @Override // androidx.compose.runtime.changelist.OperationErrorContext
    public List<ComposeStackTraceFrame> buildStackTrace(Integer currentOffset) {
        return this.composer.parentStackTrace();
    }

    @Override // H7.h
    public <R> R fold(R r5, n nVar) {
        return (R) l.w(this, r5, nVar);
    }

    @Override // H7.h
    public <E extends f> E get(g gVar) {
        return (E) l.x(this, gVar);
    }

    @Override // H7.f
    public g getKey() {
        return INSTANCE;
    }

    @Override // H7.h
    public h minusKey(g gVar) {
        return l.C(this, gVar);
    }

    @Override // H7.h
    public h plus(h hVar) {
        return l.H(this, hVar);
    }
}
