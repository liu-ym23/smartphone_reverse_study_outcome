package com.stepos.aiengine.memory;

import com.stepos.aicgroup.memory.MemorySnapshot;
import com.stepos.aicgroup.memory.PressureLevel;
import com.stepos.aiengine.memory.a;
import com.stepos.base.model.ReleaseReason;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.aiengine.memory.AiModelPressureHandler", f = "AiModelPressureHandler.kt", l = {209}, m = "handle$app_release")
/* loaded from: classes.dex */
final class AiModelPressureHandler$handle$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public AiModelPressureHandler f5799a;

    /* renamed from: b, reason: collision with root package name */
    public PressureLevel f5800b;

    /* renamed from: c, reason: collision with root package name */
    public MemorySnapshot f5801c;

    /* renamed from: d, reason: collision with root package name */
    public a.AbstractC0038a.C0039a f5802d;

    /* renamed from: e, reason: collision with root package name */
    public ReleaseReason f5803e;
    public long h;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f5804j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ AiModelPressureHandler f5805k;

    /* renamed from: l, reason: collision with root package name */
    public int f5806l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiModelPressureHandler$handle$1(AiModelPressureHandler aiModelPressureHandler, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f5805k = aiModelPressureHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f5804j = obj;
        this.f5806l |= Integer.MIN_VALUE;
        return this.f5805k.b(null, null, 0L, this);
    }
}
