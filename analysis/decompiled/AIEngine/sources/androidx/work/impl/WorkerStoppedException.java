package androidx.work.impl;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WorkerStoppedException extends CancellationException {

    /* renamed from: a, reason: collision with root package name */
    public final int f2844a;

    public WorkerStoppedException(int i10) {
        this.f2844a = i10;
    }
}
