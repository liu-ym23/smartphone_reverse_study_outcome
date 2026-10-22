package com.stepos.ability.task.executor;

import C7.r;
import S7.n;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.stepos.ability.bean.InternalTask;
import com.stepos.ability.bean.Task;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1717j;
import m9.InterfaceC1733z;
import m9.c0;

@J7.c(c = "com.stepos.ability.task.executor.GuiTaskExecutor$execute$2$progressCallback$1$onTaskAction$1", f = "GuiTaskExecutor.kt", l = {620}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class GuiTaskExecutor$execute$2$progressCallback$1$onTaskAction$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public c f3274a;
    public Bundle b;
    public kotlinx.coroutines.sync.a c;
    public InternalTask d;
    public int e;
    public /* synthetic */ Object f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f3275j;
    public final /* synthetic */ Bitmap k;
    public final /* synthetic */ String l;
    public final /* synthetic */ d m;
    public final /* synthetic */ Task n;
    public final /* synthetic */ String o;
    public final /* synthetic */ c0 p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ InternalTask f3276q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f3277r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ InterfaceC1717j f3278s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuiTaskExecutor$execute$2$progressCallback$1$onTaskAction$1(String str, String str2, String str3, String str4, Bitmap bitmap, String str5, d dVar, Task task, String str6, c0 c0Var, InternalTask internalTask, AtomicBoolean atomicBoolean, InterfaceC1717j interfaceC1717j, H7.c cVar) {
        super(2, cVar);
        this.g = str;
        this.h = str2;
        this.i = str3;
        this.f3275j = str4;
        this.k = bitmap;
        this.l = str5;
        this.m = dVar;
        this.n = task;
        this.o = str6;
        this.p = c0Var;
        this.f3276q = internalTask;
        this.f3277r = atomicBoolean;
        this.f3278s = interfaceC1717j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        GuiTaskExecutor$execute$2$progressCallback$1$onTaskAction$1 guiTaskExecutor$execute$2$progressCallback$1$onTaskAction$1 = new GuiTaskExecutor$execute$2$progressCallback$1$onTaskAction$1(this.g, this.h, this.i, this.f3275j, this.k, this.l, this.m, this.n, this.o, this.p, this.f3276q, this.f3277r, this.f3278s, cVar);
        guiTaskExecutor$execute$2$progressCallback$1$onTaskAction$1.f = obj;
        return guiTaskExecutor$execute$2$progressCallback$1$onTaskAction$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((GuiTaskExecutor$execute$2$progressCallback$1$onTaskAction$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x01d1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws android.os.RemoteException {
        /*
            Method dump skipped, instructions count: 545
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.task.executor.GuiTaskExecutor$execute$2$progressCallback$1$onTaskAction$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
