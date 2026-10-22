package aha;

import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;

/* JADX INFO: loaded from: classes33.dex */
public final class e {
    public static final jha.g<d> a(String r100, String r101) {
        if (r100 != null) goto L4;
        r100 = "unknown_session";
    L4:
        if (r101 != null) goto L6;
        r101 = "unknown_task";
    L6:
        c r102 = c.f3491a;
        int r103 = com.obric.assistant.state.multitask.ext.f.f393299a;
        return TaskFlowDslKt.b(r102, r100 + '#' + r101);
    }
}
