package com.stepos.ailauncher.task.space;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.MemoryFileEditFragment$saveContent$1", f = "MemoryFileEditFragment.kt", l = {218, 226, 239, 245}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class MemoryFileEditFragment$saveContent$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $content;
    int I$0;
    Object L$0;
    boolean Z$0;
    boolean Z$1;
    int label;
    final /* synthetic */ MemoryFileEditFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryFileEditFragment$saveContent$1(String str, MemoryFileEditFragment memoryFileEditFragment, InterfaceC4014c<? super MemoryFileEditFragment$saveContent$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$content = str;
        this.this$0 = memoryFileEditFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new MemoryFileEditFragment$saveContent$1(this.$content, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((MemoryFileEditFragment$saveContent$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d9, code lost:
    
        if (r12 == r0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x014e, code lost:
    
        if (r12 == r0) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.MemoryFileEditFragment$saveContent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
