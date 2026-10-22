package com.stepos.ailauncher.taskstore.widget;

import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class TaskMediumCardDecorationResolver$dedupProductParts$1 extends FunctionReferenceImpl implements InterfaceC5074l<TaskInfoPart, Boolean> {
    public TaskMediumCardDecorationResolver$dedupProductParts$1(Object obj) {
        super(1, obj, TaskMediumCardDecorationResolver.class, "isProductPart", "isProductPart(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;)Z", 0);
    }

    @Override // p9.InterfaceC5074l
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(TaskInfoPart p02) {
        kotlin.jvm.internal.p.i(p02, "p0");
        return Boolean.valueOf(((TaskMediumCardDecorationResolver) this.receiver).k(p02));
    }
}
