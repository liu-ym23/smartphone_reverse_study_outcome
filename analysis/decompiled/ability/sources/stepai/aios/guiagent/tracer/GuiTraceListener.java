package stepai.aios.guiagent.tracer;

import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lstepai/aios/guiagent/tracer/GuiTraceListener;", "", "Lstepai/aios/guiagent/tracer/GuiTraceUpdate;", "update", "LC7/r;", "onTraceUpdated", "(Lstepai/aios/guiagent/tracer/GuiTraceUpdate;)V", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface GuiTraceListener {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onTraceUpdated(GuiTraceListener guiTraceListener, GuiTraceUpdate update) {
            k.f(update, "update");
            GuiTraceListener.super.onTraceUpdated(update);
        }
    }

    default void onTraceUpdated(GuiTraceUpdate update) {
        k.f(update, "update");
    }
}
