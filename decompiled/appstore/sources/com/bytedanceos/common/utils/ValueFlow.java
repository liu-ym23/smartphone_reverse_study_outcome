package com.bytedanceos.common.utils;

import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&¨\u0006\u0005"}, d2 = {"Lcom/bytedanceos/common/utils/ValueFlow;", "T", "", "values", "Lkotlinx/coroutines/flow/Flow;", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ValueFlow<T> {
    @NotNull
    Flow<T> values();
}
