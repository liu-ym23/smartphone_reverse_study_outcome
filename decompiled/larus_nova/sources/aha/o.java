package aha;

import com.obric.assistant.state.api.multitask.state.ObricInteractionStateType;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class o {
    public static final jha.g<n> a(String r100, ObricInteractionStateType r101) {
        Intrinsics.checkNotNullParameter(r100, "ownerId");
        Intrinsics.checkNotNullParameter(r101, "interactionType");
        p r102 = p.f3649a;
        int r103 = com.obric.assistant.state.multitask.ext.f.f393299a;
        return TaskFlowDslKt.b(r102, com.obric.assistant.state.multitask.ext.g.a(new com.obric.assistant.state.multitask.ext.g(), new String[]{r100, r101.getTaskId()}));
    }
}
