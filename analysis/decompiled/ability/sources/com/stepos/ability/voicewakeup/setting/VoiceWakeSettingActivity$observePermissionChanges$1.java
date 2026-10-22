package com.stepos.ability.voicewakeup.setting;

import C7.r;
import G4.i;
import J7.c;
import S7.n;
import android.view.Lifecycle;
import android.view.RepeatOnLifecycleKt;
import com.stepos.ability.voicewakeup.a;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.voicewakeup.setting.VoiceWakeSettingActivity$observePermissionChanges$1", f = "VoiceWakeSettingActivity.kt", l = {364}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class VoiceWakeSettingActivity$observePermissionChanges$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3345a;
    public final /* synthetic */ VoiceWakeSettingActivity b;

    @c(c = "com.stepos.ability.voicewakeup.setting.VoiceWakeSettingActivity$observePermissionChanges$1$1", f = "VoiceWakeSettingActivity.kt", l = {367}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.ability.voicewakeup.setting.VoiceWakeSettingActivity$observePermissionChanges$1$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public int f3346a;
        public final /* synthetic */ VoiceWakeSettingActivity b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(VoiceWakeSettingActivity voiceWakeSettingActivity, H7.c cVar) {
            super(2, cVar);
            this.b = voiceWakeSettingActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new AnonymousClass1(this.b, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f3346a;
            if (i == 0) {
                b.b(obj);
                String str = H3.b.g;
                VoiceWakeSettingActivity voiceWakeSettingActivity = this.b;
                p9.c cVarA = a.a(voiceWakeSettingActivity, str);
                i iVar = new i(voiceWakeSettingActivity, 0);
                this.f3346a = 1;
                if (cVarA.collect(iVar, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return r.f317a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceWakeSettingActivity$observePermissionChanges$1(VoiceWakeSettingActivity voiceWakeSettingActivity, H7.c cVar) {
        super(2, cVar);
        this.b = voiceWakeSettingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new VoiceWakeSettingActivity$observePermissionChanges$1(this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((VoiceWakeSettingActivity$observePermissionChanges$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3345a;
        if (i == 0) {
            b.b(obj);
            Lifecycle.State state = Lifecycle.State.STARTED;
            VoiceWakeSettingActivity voiceWakeSettingActivity = this.b;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(voiceWakeSettingActivity, null);
            this.f3345a = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(voiceWakeSettingActivity, state, anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
        }
        return r.f317a;
    }
}
