package com.stepos.core.model.inference;

import androidx.work.Data;
import androidx.work.WorkInfo$State;
import androidx.work.impl.WorkDatabase;
import b7.k;
import h2.j;
import java.util.UUID;
import q2.n;
import q2.p;
import r2.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7413a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7414b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7415c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7416d;

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, int i10) {
        this.f7413a = i10;
        this.f7414b = obj;
        this.f7415c = obj2;
        this.f7416d = obj3;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f7413a) {
            case 0:
                return InferenceExecutorImpl.preprocess$lambda$9((InferenceExecutorImpl) this.f7414b, this.f7415c, (k) this.f7416d);
            case 1:
                return InferenceExecutorImpl.postprocess$lambda$7((InferenceExecutorImpl) this.f7414b, this.f7415c, (k) this.f7416d);
            default:
                q qVar = (q) this.f7414b;
                UUID uuid = (UUID) this.f7415c;
                Data data = (Data) this.f7416d;
                String string = uuid.toString();
                j jVarD = j.d();
                String str = q.f11716c;
                jVarD.a(str, "Updating progress for " + uuid + " (" + data + ")");
                WorkDatabase workDatabase = qVar.f11717a;
                workDatabase.c();
                try {
                    p pVarI = workDatabase.w().i(string);
                    if (pVarI == null) {
                        throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                    if (pVarI.f11506b == WorkInfo$State.f2793b) {
                        workDatabase.v().j(new n(string, data));
                    } else {
                        j.d().g(str, "Ignoring setProgressAsync(...). WorkSpec (" + string + ") is not in a RUNNING state.");
                    }
                    workDatabase.p();
                    workDatabase.k();
                    return null;
                } finally {
                }
        }
    }
}
