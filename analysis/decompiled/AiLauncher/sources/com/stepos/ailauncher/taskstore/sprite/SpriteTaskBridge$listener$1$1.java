package com.stepos.ailauncher.taskstore.sprite;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.sprite.SpriteTaskBridge$listener$1$1", f = "SpriteTaskBridge.kt", l = {91, 48}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SpriteTaskBridge$listener$1$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ TaskInfoCard $card;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpriteTaskBridge$listener$1$1(TaskInfoCard taskInfoCard, InterfaceC4014c<? super SpriteTaskBridge$listener$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$card = taskInfoCard;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SpriteTaskBridge$listener$1$1 spriteTaskBridge$listener$1$1 = new SpriteTaskBridge$listener$1$1(this.$card, interfaceC4014c);
        spriteTaskBridge$listener$1$1.L$0 = obj;
        return spriteTaskBridge$listener$1$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((SpriteTaskBridge$listener$1$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(1:(1:(9:6|37|7|22|27|(1:29)|32|33|34)(2:11|12))(1:13))(3:14|(1:17)|20)|39|18|(7:21|22|27|(0)|32|33|34)|20|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008b, code lost:
    
        r1 = r14;
        r14 = r0;
        r13 = r1;
        r1 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a0 A[Catch: all -> 0x00bf, TryCatch #2 {all -> 0x00bf, blocks: (B:27:0x009a, B:29:0x00a0, B:32:0x00c2, B:26:0x0090), top: B:41:0x0090 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.sprite.SpriteTaskBridge$listener$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
