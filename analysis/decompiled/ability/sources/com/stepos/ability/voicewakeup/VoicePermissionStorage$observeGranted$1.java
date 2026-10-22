package com.stepos.ability.voicewakeup;

import A6.i;
import C4.d;
import C7.r;
import J7.c;
import S7.n;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import o9.C1785k;
import o9.InterfaceC1786l;

@c(c = "com.stepos.ability.voicewakeup.VoicePermissionStorage$observeGranted$1", f = "VoicePermissionStorage.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lo9/l;", "", "LC7/r;", "<anonymous>", "(Lo9/l;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class VoicePermissionStorage$observeGranted$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3321a;
    public /* synthetic */ Object b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoicePermissionStorage$observeGranted$1(Context context, String str, H7.c cVar) {
        super(2, cVar);
        this.c = context;
        this.d = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        VoicePermissionStorage$observeGranted$1 voicePermissionStorage$observeGranted$1 = new VoicePermissionStorage$observeGranted$1(this.c, this.d, cVar);
        voicePermissionStorage$observeGranted$1.b = obj;
        return voicePermissionStorage$observeGranted$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((VoicePermissionStorage$observeGranted$1) create((InterfaceC1786l) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InterfaceC1786l interfaceC1786l = (InterfaceC1786l) this.b;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3321a;
        if (i == 0) {
            b.b(obj);
            Context applicationContext = this.c.getApplicationContext();
            Handler handler = new Handler(Looper.getMainLooper());
            String str = this.d;
            d dVar = new d(applicationContext, str, interfaceC1786l, handler);
            applicationContext.getContentResolver().registerContentObserver(VoicePermissionProvider.c, false, dVar);
            boolean z10 = applicationContext.getApplicationContext().getSharedPreferences("voice_wakeup_permission", 0).getBoolean("consent_".concat(str), false);
            Log.i("VoicePermissionStorage", "isGranted userId=" + str + " granted=" + z10);
            C1785k c1785k = (C1785k) interfaceC1786l;
            c1785k.a(Boolean.valueOf(z10));
            i iVar = new i(applicationContext, dVar);
            this.b = null;
            this.f3321a = 1;
            if (kotlinx.coroutines.channels.b.a(c1785k, iVar, this) == coroutineSingletons) {
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
