package com.stepos.alphame.dailyusage.sync;

import E0.c;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.common.data.DataStoreManager;
import com.stepos.alphame.common.data.DataStorePreferences;
import com.stepos.alphame.dailyusage.sync.DailyUsageSyncKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import s0.C0844b;
import s0.E;
import t0.C0913H;
import t0.C0929o;
import t0.M;
import t0.y;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/alphame/dailyusage/sync/DailyUsageSync;", "", "()V", "DATA_STORE_NAME", "", "KEY_SYNC_CONSTRAINTS_VERSION", "SYNC_CONSTRAINTS_VERSION", "", "save", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "dailyusage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DailyUsageSync {

    @NotNull
    private static final String DATA_STORE_NAME = "personalPreference";

    @NotNull
    public static final DailyUsageSync INSTANCE = new DailyUsageSync();

    @NotNull
    private static final String KEY_SYNC_CONSTRAINTS_VERSION = "daily_usage_sync_constraints_version";
    private static final int SYNC_CONSTRAINTS_VERSION = 1;

    private DailyUsageSync() {
    }

    public final void save(@NotNull Context context) {
        char c4;
        Intrinsics.checkNotNullParameter(context, "context");
        DataStorePreferences dataStore = DataStoreManager.INSTANCE.getDataStore(DATA_STORE_NAME);
        if (((Number) dataStore.getData(KEY_SYNC_CONSTRAINTS_VERSION, 0)).intValue() < 1) {
            dataStore.putData(KEY_SYNC_CONSTRAINTS_VERSION, 1);
            c4 = 1;
        } else {
            c4 = 2;
        }
        final C0913H c0913hE0 = C0913H.e0(context);
        final E workRequest = DailyUsageSyncWorker.INSTANCE.startUpDailyUsageWork();
        if (c4 != 3) {
            new y(c0913hE0, DailyUsageSyncKt.DAILY_USAGE_SYNC, c4 != 2 ? 1 : 2, Collections.singletonList(workRequest)).I0();
            return;
        }
        Intrinsics.checkNotNullParameter(c0913hE0, "<this>");
        Intrinsics.checkNotNullParameter(DailyUsageSyncKt.DAILY_USAGE_SYNC, "name");
        Intrinsics.checkNotNullParameter(workRequest, "workRequest");
        final C0929o c0929o = new C0929o();
        final M m4 = new M(workRequest, c0913hE0, c0929o);
        ((c) c0913hE0.f15328e).f400a.execute(new Runnable() { // from class: t0.K

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f15338b = DailyUsageSyncKt.DAILY_USAGE_SYNC;

            @Override // java.lang.Runnable
            public final void run() {
                C0913H this_enqueueUniquelyNamedPeriodic = c0913hE0;
                Intrinsics.checkNotNullParameter(this_enqueueUniquelyNamedPeriodic, "$this_enqueueUniquelyNamedPeriodic");
                String name = this.f15338b;
                Intrinsics.checkNotNullParameter(name, "$name");
                C0929o operation = c0929o;
                Intrinsics.checkNotNullParameter(operation, "$operation");
                Function0 enqueueNew = m4;
                Intrinsics.checkNotNullParameter(enqueueNew, "$enqueueNew");
                s0.I workRequest2 = workRequest;
                Intrinsics.checkNotNullParameter(workRequest2, "$workRequest");
                B0.u uVarG = this_enqueueUniquelyNamedPeriodic.f15327d.g();
                ArrayList arrayListJ = uVarG.j(name);
                if (arrayListJ.size() > 1) {
                    operation.a(new s0.y(new UnsupportedOperationException("Can't apply UPDATE policy to the chains of work.")));
                    return;
                }
                B0.q qVar = (B0.q) CollectionsKt___CollectionsKt.firstOrNull((List) arrayListJ);
                if (qVar == null) {
                    enqueueNew.invoke();
                    return;
                }
                String str = qVar.f164a;
                B0.r rVarI = uVarG.i(str);
                if (rVarI == null) {
                    operation.a(new s0.y(new IllegalStateException("WorkSpec with " + str + ", that matches a name \"" + name + "\", wasn't found")));
                    return;
                }
                if (!rVarI.d()) {
                    operation.a(new s0.y(new UnsupportedOperationException("Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.")));
                    return;
                }
                if (qVar.f165b == s0.G.f14158f) {
                    uVarG.a(str);
                    enqueueNew.invoke();
                    return;
                }
                B0.r rVarB = B0.r.b(workRequest2.f14164b, qVar.f164a, null, null, null, 0, 0L, 0, 0, 0L, 0, 8388606);
                try {
                    r processor = this_enqueueUniquelyNamedPeriodic.f15330g;
                    Intrinsics.checkNotNullExpressionValue(processor, "processor");
                    WorkDatabase workDatabase = this_enqueueUniquelyNamedPeriodic.f15327d;
                    Intrinsics.checkNotNullExpressionValue(workDatabase, "workDatabase");
                    C0844b configuration = this_enqueueUniquelyNamedPeriodic.f15326c;
                    Intrinsics.checkNotNullExpressionValue(configuration, "configuration");
                    List schedulers = this_enqueueUniquelyNamedPeriodic.f15329f;
                    Intrinsics.checkNotNullExpressionValue(schedulers, "schedulers");
                    com.airbnb.lottie.h.K(processor, workDatabase, configuration, schedulers, rVarB, workRequest2.f14165c);
                    operation.a(s0.B.f14148a);
                } catch (Throwable th) {
                    operation.a(new s0.y(th));
                }
            }
        });
    }
}
