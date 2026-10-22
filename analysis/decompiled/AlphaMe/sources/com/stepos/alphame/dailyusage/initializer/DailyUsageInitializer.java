package com.stepos.alphame.dailyusage.initializer;

import android.content.Context;
import android.util.Log;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.app.AppEventDataItem;
import com.stepos.alphame.dailyusage.DefaultDailyUsageEventHandler;
import com.stepos.alphame.data.model.dailyusage.DailyUsageSummaryKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import n0.b;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\b0\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/stepos/alphame/dailyusage/initializer/DailyUsageInitializer;", "Ln0/b;", "", "Landroid/content/Context;", CoreConstants.CONTEXT_SCOPE_VALUE, AppEventDataItem.APP_CREATE, "(Landroid/content/Context;)Ljava/lang/Boolean;", "", "Ljava/lang/Class;", "dependencies", "()Ljava/util/List;", "<init>", "()V", "dailyusage_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class DailyUsageInitializer implements b {
    @Override // n0.b
    @NotNull
    public List<Class<? extends b>> dependencies() {
        return CollectionsKt.emptyList();
    }

    @Override // n0.b
    @NotNull
    public Boolean create(@NotNull Context context) throws SecurityException {
        Intrinsics.checkNotNullParameter(context, "context");
        Log.i(DailyUsageSummaryKt.TAG, "DailyUsageInitializer create");
        DefaultDailyUsageEventHandler.INSTANCE.getINSTANCE().onInit(context);
        return Boolean.TRUE;
    }
}
