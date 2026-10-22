package stepai.aios.guiagent.pipeline;

import C7.r;
import S7.k;
import com.stepos.statsrpk.service.c;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import va.InterfaceC2078a;
import wa.e;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class ExecutionPipeline$createTask$guiExecutor$1 extends FunctionReferenceImpl implements k {
    @Override // S7.k
    public final Object invoke(Object obj) {
        String p02 = (String) obj;
        kotlin.jvm.internal.k.f(p02, "p0");
        e eVar = (e) this.receiver;
        eVar.getClass();
        try {
            Iterator it = eVar.b.iterator();
            while (it.hasNext()) {
                ((InterfaceC2078a) it.next()).beforePerformAccessibilityAction(p02);
            }
        } catch (Exception e) {
            c.o("Error dispatching event ", "before_perform_accessibility_action", ": ", e.getMessage(), "TaskEventDispatcher");
        }
        return r.f317a;
    }
}
