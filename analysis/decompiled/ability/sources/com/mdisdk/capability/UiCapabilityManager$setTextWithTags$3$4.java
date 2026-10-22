package com.mdisdk.capability;

import C7.r;
import J7.c;
import S7.q;
import com.mdisdk.capability.model.ViewNode;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@c(c = "com.mdisdk.capability.UiCapabilityManager$setTextWithTags$3$4", f = "UiCapabilityManager.kt", l = {271, 276}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "part", "", "start", "", "end", "byCodePoint"}, k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UiCapabilityManager$setTextWithTags$3$4 extends SuspendLambda implements q {
    final /* synthetic */ int $displayId;
    final /* synthetic */ ViewNode $editor;
    final /* synthetic */ String $targetActivityClass;
    final /* synthetic */ String $targetPackageName;
    final /* synthetic */ String $targetWindowTitle;
    final /* synthetic */ long $timeoutMillis;
    /* synthetic */ int I$0;
    /* synthetic */ int I$1;
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ UiCapabilityManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UiCapabilityManager$setTextWithTags$3$4(UiCapabilityManager uiCapabilityManager, int i, String str, String str2, String str3, ViewNode viewNode, long j5, H7.c<? super UiCapabilityManager$setTextWithTags$3$4> cVar) {
        super(5, cVar);
        this.this$0 = uiCapabilityManager;
        this.$displayId = i;
        this.$targetPackageName = str;
        this.$targetWindowTitle = str2;
        this.$targetActivityClass = str3;
        this.$editor = viewNode;
        this.$timeoutMillis = j5;
    }

    @Override // S7.q
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return invoke((String) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue(), ((Boolean) obj4).booleanValue(), (H7.c<? super Boolean>) obj5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
    
        if (r1 == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0088, code lost:
    
        if (r1 == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r14 = r17
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r14.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L23
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            kotlin.b.b(r18)
            r1 = r18
            goto L8b
        L15:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L1d:
            kotlin.b.b(r18)
            r1 = r18
            goto L5b
        L23:
            kotlin.b.b(r18)
            java.lang.Object r1 = r14.L$0
            java.lang.String r1 = (java.lang.String) r1
            int r4 = r14.I$0
            int r5 = r14.I$1
            boolean r6 = r14.Z$0
            if (r6 == 0) goto L62
            r6 = r1
            com.mdisdk.capability.UiCapabilityManager r1 = r14.this$0
            int r2 = r14.$displayId
            java.lang.String r8 = r14.$targetPackageName
            java.lang.String r9 = r14.$targetWindowTitle
            java.lang.String r10 = r14.$targetActivityClass
            com.mdisdk.capability.model.ViewNode r7 = r14.$editor
            long r11 = r7.getNodeId()
            java.lang.Long r7 = new java.lang.Long
            r7.<init>(r11)
            long r12 = r14.$timeoutMillis
            r14.label = r3
            r3 = r6
            r6 = 0
            r11 = r7
            r7 = 0
            r15 = 48
            r16 = 0
            java.lang.Object r1 = com.mdisdk.capability.UiCapabilityManager.replaceTextByCodePoint$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16)
            if (r1 != r0) goto L5b
            goto L8a
        L5b:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r0 = r1.booleanValue()
            goto L91
        L62:
            r3 = r1
            com.mdisdk.capability.UiCapabilityManager r1 = r14.this$0
            int r6 = r14.$displayId
            java.lang.String r8 = r14.$targetPackageName
            java.lang.String r9 = r14.$targetWindowTitle
            java.lang.String r10 = r14.$targetActivityClass
            com.mdisdk.capability.model.ViewNode r7 = r14.$editor
            long r11 = r7.getNodeId()
            java.lang.Long r7 = new java.lang.Long
            r7.<init>(r11)
            long r12 = r14.$timeoutMillis
            r14.label = r2
            r2 = r6
            r6 = 0
            r11 = r7
            r7 = 0
            r15 = 48
            r16 = 0
            java.lang.Object r1 = com.mdisdk.capability.UiCapabilityManager.replaceText$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16)
            if (r1 != r0) goto L8b
        L8a:
            return r0
        L8b:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r0 = r1.booleanValue()
        L91:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mdisdk.capability.UiCapabilityManager$setTextWithTags$3$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(String str, int i, int i6, boolean z10, H7.c<? super Boolean> cVar) {
        UiCapabilityManager$setTextWithTags$3$4 uiCapabilityManager$setTextWithTags$3$4 = new UiCapabilityManager$setTextWithTags$3$4(this.this$0, this.$displayId, this.$targetPackageName, this.$targetWindowTitle, this.$targetActivityClass, this.$editor, this.$timeoutMillis, cVar);
        uiCapabilityManager$setTextWithTags$3$4.L$0 = str;
        uiCapabilityManager$setTextWithTags$3$4.I$0 = i;
        uiCapabilityManager$setTextWithTags$3$4.I$1 = i6;
        uiCapabilityManager$setTextWithTags$3$4.Z$0 = z10;
        return uiCapabilityManager$setTextWithTags$3$4.invokeSuspend(r.f317a);
    }
}
