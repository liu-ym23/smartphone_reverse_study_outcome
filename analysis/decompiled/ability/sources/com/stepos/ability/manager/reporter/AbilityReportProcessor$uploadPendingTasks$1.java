package com.stepos.ability.manager.reporter;

import J7.c;
import com.stepos.ability.database.entity.AbilityReportTaskEntity;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.manager.reporter.AbilityReportProcessor", f = "AbilityReportProcessor.kt", l = {168, 179, 182, 185, 191, 196}, m = "uploadPendingTasks", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AbilityReportProcessor$uploadPendingTasks$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Iterator f3148a;
    public AbilityReportTaskEntity b;
    public /* synthetic */ Object c;
    public final /* synthetic */ a d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityReportProcessor$uploadPendingTasks$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.d = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return a.a(this.d, this);
    }
}
