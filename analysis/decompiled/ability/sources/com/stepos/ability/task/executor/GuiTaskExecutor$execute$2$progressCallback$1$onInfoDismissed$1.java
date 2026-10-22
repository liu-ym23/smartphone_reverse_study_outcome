package com.stepos.ability.task.executor;

import C7.r;
import S7.n;
import com.stepos.ability.api.task.listener.ITaskListener;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.task.executor.GuiTaskExecutor$execute$2$progressCallback$1$onInfoDismissed$1", f = "GuiTaskExecutor.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class GuiTaskExecutor$execute$2$progressCallback$1$onInfoDismissed$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f3270a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuiTaskExecutor$execute$2$progressCallback$1$onInfoDismissed$1(d dVar, String str, String str2, String str3, String str4, H7.c cVar) {
        super(2, cVar);
        this.f3270a = dVar;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new GuiTaskExecutor$execute$2$progressCallback$1$onInfoDismissed$1(this.f3270a, this.b, this.c, this.d, this.e, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        GuiTaskExecutor$execute$2$progressCallback$1$onInfoDismissed$1 guiTaskExecutor$execute$2$progressCallback$1$onInfoDismissed$1 = (GuiTaskExecutor$execute$2$progressCallback$1$onInfoDismissed$1) create((InterfaceC1733z) obj, (H7.c) obj2);
        r rVar = r.f317a;
        guiTaskExecutor$execute$2$progressCallback$1$onInfoDismissed$1.invokeSuspend(rVar);
        return rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        ITaskListener iTaskListener = this.f3270a.f3309a;
        String str = this.d;
        if (str == null) {
            str = "";
        }
        String str2 = this.e;
        iTaskListener.onInfoDismissed(this.b, this.c, str, str2 != null ? str2 : "");
        return r.f317a;
    }
}
