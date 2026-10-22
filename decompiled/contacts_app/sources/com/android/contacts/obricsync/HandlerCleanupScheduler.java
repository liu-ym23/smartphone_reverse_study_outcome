package com.android.contacts.obricsync;

import android.os.Handler;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObricSyncSnapshotBulkConverger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/contacts/obricsync/HandlerCleanupScheduler;", "Lcom/android/contacts/obricsync/CleanupScheduler;", "handler", "Landroid/os/Handler;", "(Landroid/os/Handler;)V", "schedule", "", "delayMillis", "", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "Lkotlin/Function0;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HandlerCleanupScheduler implements CleanupScheduler {
    private final Handler handler;

    public static /* synthetic */ void $r8$lambda$Wvx0NVmbcsl3aJW2x8ApRvFfE78(Function0 r0) {
        schedule$lambda$0(r0);
    }

    public HandlerCleanupScheduler(Handler r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.handler = r2;
    }

    private static final void schedule$lambda$0(Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "$tmp0");
        r1.invoke();
    }

    @Override // com.android.contacts.obricsync.CleanupScheduler
    public void schedule(long r2, final Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        this.handler.postDelayed(new HandlerCleanupScheduler$$ExternalSyntheticLambda0(r4), r2);
    }
}
