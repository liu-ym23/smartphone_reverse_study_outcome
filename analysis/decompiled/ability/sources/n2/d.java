package n2;

import a.AbstractC0291a;
import android.content.Context;
import com.apm.insight.g;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;

/* loaded from: classes2.dex */
public final class d extends a {
    public static d v(StackTraceElement stackTraceElement, String str, String str2, String str3, String str4) {
        d dVar = new d();
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        int lineNumber = stackTraceElement.getLineNumber();
        dVar.e("exception", "event_type");
        dVar.e("core_exception_monitor", "log_type");
        dVar.e(Long.valueOf(System.currentTimeMillis()), "timestamp");
        dVar.e(Long.valueOf(System.currentTimeMillis()), "crash_time");
        dVar.e(className, "class_ref");
        dVar.e(methodName, GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD);
        dVar.e(Integer.valueOf(lineNumber), "line_num");
        dVar.e(str, "stack");
        dVar.e(1, "exception_type");
        dVar.e(str4, "ensure_type");
        dVar.e(1, "is_core");
        dVar.e(str2, "message");
        Context context = g.f2160a;
        dVar.e(com.stepos.statsrpk.d.o(), "process_name");
        dVar.e(str3, "crash_thread_name");
        AbstractC0291a.q(dVar.f5345a);
        return dVar;
    }
}
