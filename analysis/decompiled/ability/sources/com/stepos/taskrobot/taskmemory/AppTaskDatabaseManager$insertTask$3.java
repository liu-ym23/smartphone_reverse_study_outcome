package com.stepos.taskrobot.taskmemory;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.taskrobot.taskmemory.AppTaskDatabaseManager", f = "AppTaskDatabaseManager.kt", l = {450}, m = "insertTask", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AppTaskDatabaseManager$insertTask$3 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4056a;
    public final /* synthetic */ a b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppTaskDatabaseManager$insertTask$3(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.b = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4056a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.a(null, this);
    }
}
