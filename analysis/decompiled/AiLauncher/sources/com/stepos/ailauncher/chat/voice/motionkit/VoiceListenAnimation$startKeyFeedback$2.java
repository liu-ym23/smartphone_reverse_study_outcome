package com.stepos.ailauncher.chat.voice.motionkit;

import Ua.C1060i;
import android.os.SystemClock;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lkotlinx/coroutines/g;", "<anonymous>", "(LUa/M;)Lkotlinx/coroutines/g;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startKeyFeedback$2", f = "VoiceListenAnimation.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class VoiceListenAnimation$startKeyFeedback$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super kotlinx.coroutines.g>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VoiceListenAnimation this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startKeyFeedback$2$1", f = "VoiceListenAnimation.kt", l = {634}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startKeyFeedback$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;
        final /* synthetic */ VoiceListenAnimation this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(VoiceListenAnimation voiceListenAnimation, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = voiceListenAnimation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.this$0, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                VoiceListenAnimation voiceListenAnimation = this.this$0;
                float fA = voiceListenAnimation.getTiming().a();
                this.label = 1;
                if (voiceListenAnimation.e0(fA, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            if (!this.this$0.c1(true)) {
                return Y8.t.f7040a;
            }
            this.this$0.glowPlayAtMs = SystemClock.elapsedRealtime();
            this.this$0.glowOverlay.o(this.this$0.getSpeed());
            this.this$0.glowOverlay.m();
            this.this$0.B0();
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startKeyFeedback$2$2", f = "VoiceListenAnimation.kt", l = {642}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startKeyFeedback$2$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;
        final /* synthetic */ VoiceListenAnimation this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(VoiceListenAnimation voiceListenAnimation, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = voiceListenAnimation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.this$0, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                VoiceListenAnimation voiceListenAnimation = this.this$0;
                float fB = voiceListenAnimation.getTiming().b();
                this.label = 1;
                if (voiceListenAnimation.e0(fB, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            if (!this.this$0.c1(true)) {
                return Y8.t.f7040a;
            }
            this.this$0.ripplePlayAtMs = SystemClock.elapsedRealtime();
            this.this$0.F0();
            this.this$0.Y0();
            this.this$0.w0();
            this.this$0.B0();
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceListenAnimation$startKeyFeedback$2(VoiceListenAnimation voiceListenAnimation, InterfaceC4014c<? super VoiceListenAnimation$startKeyFeedback$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = voiceListenAnimation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        VoiceListenAnimation$startKeyFeedback$2 voiceListenAnimation$startKeyFeedback$2 = new VoiceListenAnimation$startKeyFeedback$2(this.this$0, interfaceC4014c);
        voiceListenAnimation$startKeyFeedback$2.L$0 = obj;
        return voiceListenAnimation$startKeyFeedback$2;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super kotlinx.coroutines.g> interfaceC4014c) {
        return ((VoiceListenAnimation$startKeyFeedback$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ua.M m10 = (Ua.M) this.L$0;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        C1060i.d(m10, null, null, new AnonymousClass1(this.this$0, null), 3, null);
        return C1060i.d(m10, null, null, new AnonymousClass2(this.this$0, null), 3, null);
    }
}
