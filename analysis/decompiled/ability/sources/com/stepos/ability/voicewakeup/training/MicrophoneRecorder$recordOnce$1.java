package com.stepos.ability.voicewakeup.training;

import S7.n;
import androidx.core.location.LocationRequestCompat;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$BooleanRef;

@J7.c(c = "com.stepos.ability.voicewakeup.training.MicrophoneRecorder", f = "MicrophoneRecorder.kt", l = {LocationRequestCompat.QUALITY_LOW_POWER, 106}, m = "recordOnce", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class MicrophoneRecorder$recordOnce$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f3354a;
    public int b;
    public int c;
    public int d;
    public int e;
    public n f;
    public S7.a g;
    public n h;
    public Ref$BooleanRef i;

    /* renamed from: j, reason: collision with root package name */
    public long[] f3355j;
    public long k;
    public /* synthetic */ Object l;
    public final /* synthetic */ a m;
    public int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicrophoneRecorder$recordOnce$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.m = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.l = obj;
        this.n |= Integer.MIN_VALUE;
        return this.m.b(0, 0, null, null, null, this);
    }
}
