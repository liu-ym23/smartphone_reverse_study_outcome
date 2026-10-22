package com.stepos.core.model.manager;

import com.stepos.base.task.data.TaskPriority;
import com.stepos.core.model.manager.ModelCacheImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements zb.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7465a;

    public /* synthetic */ m(int i10) {
        this.f7465a = i10;
    }

    @Override // zb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f7465a) {
            case 0:
                return ModelCacheImpl.VersionRouter.confirmVersionHealthyAsync$lambda$5((Integer) obj, (Integer) obj2);
            default:
                return ModelCacheImpl.recordAcquireTier$lambda$75((TaskPriority) obj, (TaskPriority) obj2);
        }
    }
}
