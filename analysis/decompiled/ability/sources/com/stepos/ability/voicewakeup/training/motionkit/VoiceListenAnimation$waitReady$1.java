package com.stepos.ability.voicewakeup.training.motionkit;

import J7.c;
import android.view.View;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation", f = "VoiceListenAnimation.kt", l = {579, 593}, m = "waitReady", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class VoiceListenAnimation$waitReady$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f3409a;
    public View b;
    public /* synthetic */ Object c;
    public final /* synthetic */ a d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceListenAnimation$waitReady$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.d = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.y(this);
    }
}
