package com.stepos.ailauncher.chat.fragment;

import com.stepos.ailauncher.chat.view.UnifiedChatHostView;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.ChatFragment$onViewCreated$1$1", f = "ChatFragment.kt", l = {com.stepos.ailauncher.chat.wake.circle.F.GESTURE_HEIGHT_DP}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatFragment$onViewCreated$1$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ UnifiedChatHostView $host;
    final /* synthetic */ com.stepos.ailauncher.sheet.S $sheet;
    int label;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ UnifiedChatHostView $host;

        public a(UnifiedChatHostView unifiedChatHostView) {
            this.$host = unifiedChatHostView;
        }

        public final Object b(boolean z10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            this.$host.getChatLayout().setAutomaticBottomScrollPaused(z10);
            return Y8.t.f7040a;
        }

        @Override // Xa.c
        public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
            return b(((Boolean) obj).booleanValue(), interfaceC4014c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatFragment$onViewCreated$1$1(com.stepos.ailauncher.sheet.S s10, UnifiedChatHostView unifiedChatHostView, InterfaceC4014c<? super ChatFragment$onViewCreated$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$sheet = s10;
        this.$host = unifiedChatHostView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ChatFragment$onViewCreated$1$1(this.$sheet, this.$host, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ChatFragment$onViewCreated$1$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.t<Boolean> tVarV1 = this.$sheet.V1();
            a aVar = new a(this.$host);
            this.label = 1;
            if (tVarV1.collect(aVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
