package com.stepos.taskrobot.base.util;

import C7.r;
import H7.c;
import S7.k;
import android.content.Context;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JT\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u0004H¦@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/base/util/LogUploadEntry;", "", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "LC7/r;", GuiTaskProgressKt.GuiTaskProgress_VALUE_METHOD_ONPRGRESS, "", "onSuccess", "", "onFailure", "uploadLogs", "(Landroid/content/Context;LS7/k;LS7/k;LS7/k;LH7/c;)Ljava/lang/Object;", "util_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LogUploadEntry {
    Object uploadLogs(Context context, k kVar, k kVar2, k kVar3, c<? super r> cVar);
}
