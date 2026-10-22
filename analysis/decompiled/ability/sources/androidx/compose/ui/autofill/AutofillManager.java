package androidx.compose.ui.autofill;

import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0003¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/autofill/AutofillManager;", "", AppAgent.CONSTRUCT, "()V", "LC7/r;", "commit", "cancel", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AutofillManager {
    public static final int $stable = 0;

    public abstract void cancel();

    public abstract void commit();
}
