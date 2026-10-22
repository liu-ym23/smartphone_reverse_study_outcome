package com.android.contacts.obricsync;

import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ObricSyncSnapshotBulkConverger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&¨\u0006\b"}, d2 = {"Lcom/android/contacts/obricsync/CleanupScheduler;", "", "schedule", "", "delayMillis", "", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "Lkotlin/Function0;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CleanupScheduler {
    void schedule(long r1, Function0<Unit> r3);
}
