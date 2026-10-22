package com.stepos.ailauncher.agent.aispace.connect;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.AgentFileSyncProvider$fetchUrl$2", f = "AgentFileSyncProvider.kt", l = {51, 55}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentFileSyncProvider$fetchUrl$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super String>, Object> {
    final /* synthetic */ String $fileId;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentFileSyncProvider$fetchUrl$2(String str, InterfaceC4014c<? super AgentFileSyncProvider$fetchUrl$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$fileId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentFileSyncProvider$fetchUrl$2(this.$fileId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super String> interfaceC4014c) {
        return ((AgentFileSyncProvider$fetchUrl$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0093, code lost:
    
        if (r8.equals("3") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009c, code lost:
    
        if (r8.equals("2") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009f, code lost:
    
        return null;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d9 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00d2 -> B:47:0x00d3). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.AgentFileSyncProvider$fetchUrl$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
