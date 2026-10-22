package com.uxsense.base.metadata;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001aF\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003H\u0086@¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/uxsense/base/metadata/Chat;", "", "limit", "Lkotlin/Function2;", "", "LH7/c;", "Lcom/uxsense/base/metadata/MessagePage;", "", "loadPage", "", "Lcom/uxsense/base/metadata/ChatMessage;", "loadLatestMessages", "(Lcom/uxsense/base/metadata/Chat;ILS7/n;LH7/c;)Ljava/lang/Object;", "uxsense_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatKt {

    @c(c = "com.uxsense.base.metadata.ChatKt", f = "Chat.kt", l = {100}, m = "loadLatestMessages")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.base.metadata.ChatKt$loadLatestMessages$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChatKt.loadLatestMessages(null, 0, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0084 -> B:27:0x0087). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object loadLatestMessages(com.uxsense.base.metadata.Chat r7, int r8, S7.n r9, H7.c<? super java.util.List<com.uxsense.base.metadata.ChatMessage>> r10) {
        /*
            boolean r0 = r10 instanceof com.uxsense.base.metadata.ChatKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            com.uxsense.base.metadata.ChatKt$loadLatestMessages$1 r0 = (com.uxsense.base.metadata.ChatKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.base.metadata.ChatKt$loadLatestMessages$1 r0 = new com.uxsense.base.metadata.ChatKt$loadLatestMessages$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            int r7 = r0.I$0
            java.lang.Object r8 = r0.L$2
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$1
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            java.lang.Object r2 = r0.L$0
            S7.n r2 = (S7.n) r2
            kotlin.b.b(r10)
            goto L87
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            kotlin.b.b(r10)
            if (r8 > 0) goto L45
            kotlin.collections.EmptyList r7 = kotlin.collections.EmptyList.f4893a
            return r7
        L45:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>(r8)
            java.util.List r7 = r7.getPageIds()
            D7.K r7 = D7.v.r0(r7)
            java.util.Iterator r7 = r7.iterator()
            r6 = r8
            r8 = r7
            r7 = r6
            r6 = r10
            r10 = r9
            r9 = r6
        L5c:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lb4
            java.lang.Object r2 = r8.next()
            java.lang.Number r2 = (java.lang.Number) r2
            long r4 = r2.longValue()
            if (r7 <= 0) goto Lb4
            java.lang.Long r2 = new java.lang.Long
            r2.<init>(r4)
            r0.L$0 = r10
            r0.L$1 = r9
            r0.L$2 = r8
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r2 = r10.invoke(r2, r0)
            if (r2 != r1) goto L84
            return r1
        L84:
            r6 = r2
            r2 = r10
            r10 = r6
        L87:
            com.uxsense.base.metadata.MessagePage r10 = (com.uxsense.base.metadata.MessagePage) r10
            java.util.List r10 = r10.getMessages()
            int r4 = r10.size()
            if (r4 > r7) goto La0
            r4 = r10
            java.util.Collection r4 = (java.util.Collection) r4
            r9.addAll(r4)
            int r10 = r10.size()
            int r7 = r7 - r10
        L9e:
            r10 = r2
            goto L5c
        La0:
            int r4 = r10.size()
            int r4 = r4 - r7
            int r7 = r10.size()
            java.util.List r7 = r10.subList(r4, r7)
            java.util.Collection r7 = (java.util.Collection) r7
            r9.addAll(r7)
            r7 = 0
            goto L9e
        Lb4:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.base.metadata.ChatKt.loadLatestMessages(com.uxsense.base.metadata.Chat, int, S7.n, H7.c):java.lang.Object");
    }
}
