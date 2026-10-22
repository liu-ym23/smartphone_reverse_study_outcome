package com.stepos.ability.task.executor;

import C7.r;
import S7.n;
import com.stepos.ability.api.task.listener.ITaskListener;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.task.executor.GuiTaskExecutor$execute$2$progressCallback$1$onPackageConflict$1", f = "GuiTaskExecutor.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class GuiTaskExecutor$execute$2$progressCallback$1$onPackageConflict$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f3272a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuiTaskExecutor$execute$2$progressCallback$1$onPackageConflict$1(d dVar, int i, String str, String str2, String str3, String str4, String str5, H7.c cVar) {
        super(2, cVar);
        this.f3272a = dVar;
        this.b = i;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new GuiTaskExecutor$execute$2$progressCallback$1$onPackageConflict$1(this.f3272a, this.b, this.c, this.d, this.e, this.f, this.g, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        GuiTaskExecutor$execute$2$progressCallback$1$onPackageConflict$1 guiTaskExecutor$execute$2$progressCallback$1$onPackageConflict$1 = (GuiTaskExecutor$execute$2$progressCallback$1$onPackageConflict$1) create((InterfaceC1733z) obj, (H7.c) obj2);
        r rVar = r.f317a;
        guiTaskExecutor$execute$2$progressCallback$1$onPackageConflict$1.invokeSuspend(rVar);
        return rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        ITaskListener iTaskListener = this.f3272a.f3309a;
        String str = this.c;
        String str2 = str == null ? "" : str;
        String str3 = this.d;
        String str4 = str3 == null ? "" : str3;
        String str5 = this.e;
        String str6 = str5 == null ? "" : str5;
        String str7 = this.f;
        String str8 = str7 == null ? "" : str7;
        String str9 = this.g;
        iTaskListener.onPackageConflict(this.b, str2, str4, str6, str8, str9 == null ? "" : str9);
        return r.f317a;
    }
}
