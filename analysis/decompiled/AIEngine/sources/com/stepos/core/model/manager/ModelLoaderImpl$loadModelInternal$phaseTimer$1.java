package com.stepos.core.model.manager;

import android.os.SystemClock;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public /* synthetic */ class ModelLoaderImpl$loadModelInternal$phaseTimer$1 extends FunctionReferenceImpl implements zb.a<Long> {
    public static final ModelLoaderImpl$loadModelInternal$phaseTimer$1 INSTANCE = new ModelLoaderImpl$loadModelInternal$phaseTimer$1();

    public ModelLoaderImpl$loadModelInternal$phaseTimer$1() {
        super(0, SystemClock.class, "elapsedRealtimeNanos", "elapsedRealtimeNanos()J", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // zb.a
    public final Long invoke() {
        return Long.valueOf(SystemClock.elapsedRealtimeNanos());
    }
}
