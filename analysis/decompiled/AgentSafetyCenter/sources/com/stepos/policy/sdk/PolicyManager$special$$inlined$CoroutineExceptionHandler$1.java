package com.stepos.policy.sdk;

import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import kc.q;
import kc.r;
import kc.s;
import nb.g;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyManager$special$$inlined$CoroutineExceptionHandler$1 extends nb.a implements r {
    public PolicyManager$special$$inlined$CoroutineExceptionHandler$1(q qVar) {
        super(qVar);
    }

    @Override // kc.r
    public void handleException(g gVar, Throwable th) {
        PolicySdkLogUtils.Companion.d("exceptionHandler", gVar.get(s.f7477f) + " 处理异常 ：" + th);
    }
}
