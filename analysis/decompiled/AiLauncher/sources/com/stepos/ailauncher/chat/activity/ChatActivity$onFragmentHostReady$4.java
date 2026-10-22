package com.stepos.ailauncher.chat.activity;

import android.content.res.Resources;
import com.stepos.ailauncher.chat.broadcast.RecentsWindowMonitor;
import com.stepos.ailauncher.chat.fragment.ChatInputFragment;
import com.stepos.ailauncher.chat.view.FloatInputView;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.activity.ChatActivity$onFragmentHostReady$4", f = "ChatActivity.kt", l = {2078}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatActivity$onFragmentHostReady$4 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ ChatActivity this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ ChatActivity this$0;

        public a(ChatActivity chatActivity) {
            this.this$0 = chatActivity;
        }

        public final Object b(boolean z10, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Resources.NotFoundException {
            FloatInputView inputView;
            if (RecentsWindowMonitor.INSTANCE.h() != RecentsWindowMonitor.RecentsState.IDLE) {
                return Y8.t.f7040a;
            }
            if (!z10 && !this.this$0.isFinishing() && !this.this$0.isDestroyed()) {
                com.stepos.ailauncher.chat.wake.Q.INSTANCE.h("minusOne overlay closed");
                ChatInputFragment residentInput = this.this$0.getResidentInput();
                if (residentInput != null && (inputView = residentInput.getInputView()) != null) {
                    inputView.d();
                }
                if (this.this$0.x7() == ChatScene.HOME_RESIDENT) {
                    C4148a.k(com.stepos.ailauncher.common.utils.v.OWNER_ACTIVITY, "overlay closed → home resident chat moveTaskToBack (keep-alive)", false, 4, null);
                    this.this$0.P9(true);
                    C4109a.a(this.this$0.moveTaskToBack(true));
                } else {
                    C4148a.k(com.stepos.ailauncher.common.utils.v.OWNER_ACTIVITY, "overlay closed → finish home overlay chat", false, 4, null);
                    this.this$0.finish();
                }
            }
            return Y8.t.f7040a;
        }

        @Override // Xa.c
        public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
            return b(((Boolean) obj).booleanValue(), interfaceC4014c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatActivity$onFragmentHostReady$4(ChatActivity chatActivity, InterfaceC4014c<? super ChatActivity$onFragmentHostReady$4> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = chatActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ChatActivity$onFragmentHostReady$4(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ChatActivity$onFragmentHostReady$4) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.t<Boolean> tVarI = com.stepos.ailauncher.container.m0.INSTANCE.i();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (tVarI.collect(aVar, this) == objG) {
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
