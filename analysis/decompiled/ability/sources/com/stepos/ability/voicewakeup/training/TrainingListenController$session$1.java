package com.stepos.ability.voicewakeup.training;

import C7.r;
import S7.k;
import android.content.Intent;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class TrainingListenController$session$1 extends FunctionReferenceImpl implements k {
    @Override // S7.k
    public final Object invoke(Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        ((b) this.receiver).f3395a.getContext().sendBroadcast(new Intent("com.stepos.ACTION_ENTER_RECENTS").putExtra("enter", zBooleanValue));
        Log.d("TrainingListen", "已发送小白条显隐请求：hidden=" + zBooleanValue);
        return r.f317a;
    }
}
