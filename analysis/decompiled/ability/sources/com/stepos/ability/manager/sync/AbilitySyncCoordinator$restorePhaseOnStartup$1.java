package com.stepos.ability.manager.sync;

import J7.c;
import android.content.Context;
import androidx.core.location.LocationRequestCompat;
import com.stepos.ability.database.entity.SyncCacheMetaEntity;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.manager.sync.AbilitySyncCoordinator", f = "AbilitySyncCoordinator.kt", l = {LocationRequestCompat.QUALITY_LOW_POWER, 105}, m = "restorePhaseOnStartup", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AbilitySyncCoordinator$restorePhaseOnStartup$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Context f3155a;
    public String b;
    public SyncCacheMetaEntity c;
    public /* synthetic */ Object d;
    public final /* synthetic */ a e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilitySyncCoordinator$restorePhaseOnStartup$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.i(null, null, this);
    }
}
