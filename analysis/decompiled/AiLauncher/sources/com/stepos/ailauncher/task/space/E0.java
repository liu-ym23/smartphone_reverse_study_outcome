package com.stepos.ailauncher.task.space;

import android.content.Context;
import com.stepos.ailauncher.contract.api.repair.IRepairService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/task/space/E0;", "Lcom/stepos/ailauncher/contract/api/repair/IRepairService;", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", "openPage", "(Landroid/content/Context;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class E0 implements IRepairService {
    @Override // com.stepos.ailauncher.contract.api.repair.IRepairService
    public void openPage(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        RepairActivity.INSTANCE.a(context);
    }
}
