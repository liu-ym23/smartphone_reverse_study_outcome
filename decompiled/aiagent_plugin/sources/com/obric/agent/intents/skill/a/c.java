package com.obric.agent.intents.skill.a;

import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;

/* JADX INFO: compiled from: IntentActionExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface c<ActionContextT, ActionRequestT> {
    g<ActionRequestT> a(f r1);

    Object a(ActionContextT r1, ActionRequestT r2, DispatchContext r3, d.c.d<? super IntentResult<Empty>> r4);

    String a();
}
