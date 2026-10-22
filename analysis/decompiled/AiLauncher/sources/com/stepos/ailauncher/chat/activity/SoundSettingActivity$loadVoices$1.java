package com.stepos.ailauncher.chat.activity;

import Ua.C1056g;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.api.SystemVoicesResponse;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.activity.SoundSettingActivity$loadVoices$1", f = "SoundSettingActivity.kt", l = {104}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SoundSettingActivity$loadVoices$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SoundSettingActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SoundSettingActivity$loadVoices$1(SoundSettingActivity soundSettingActivity, InterfaceC4014c<? super SoundSettingActivity$loadVoices$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = soundSettingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SoundSettingActivity$loadVoices$1 soundSettingActivity$loadVoices$1 = new SoundSettingActivity$loadVoices$1(this.this$0, interfaceC4014c);
        soundSettingActivity$loadVoices$1.L$0 = obj;
        return soundSettingActivity$loadVoices$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SoundSettingActivity$loadVoices$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        Ua.M m10 = (Ua.M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                Result.Companion companion = Result.INSTANCE;
                Ua.I iB = Ua.Y.b();
                SoundSettingActivity$loadVoices$1$result$1$1 soundSettingActivity$loadVoices$1$result$1$1 = new SoundSettingActivity$loadVoices$1$result$1$1(null);
                this.L$0 = g9.h.a(m10);
                this.L$1 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                obj = C1056g.j(iB, soundSettingActivity$loadVoices$1$result$1$1, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b((SystemVoicesResponse) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        SoundSettingActivity soundSettingActivity = this.this$0;
        if (Result.h(objB)) {
            List listF = soundSettingActivity.F((SystemVoicesResponse) objB);
            if (listF.isEmpty()) {
                String string = soundSettingActivity.getString(R$string.sound_setting_empty);
                kotlin.jvm.internal.p.h(string, "getString(...)");
                soundSettingActivity.T(string);
            } else {
                soundSettingActivity.U(listF, soundSettingActivity.L(listF));
            }
        }
        SoundSettingActivity soundSettingActivity2 = this.this$0;
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g("SoundSettingActivity", "loadVoices failed", thE, false, 8, null);
            String string2 = soundSettingActivity2.getString(R$string.sound_setting_load_failed);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            soundSettingActivity2.T(string2);
        }
        return Y8.t.f7040a;
    }
}
