package com.obric.callandsms.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallSmsEntityChangeCallBack.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/callandsms/common/CallSmsEntityChangeObserver;", "", "()V", "delegate", "Lcom/obric/callandsms/common/CallSmsEntityChangeCallBack;", "bulkDelete", "", "entityIds", "", "", "entityType", "", "bulkIndex", "entities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "setDelegate", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallSmsEntityChangeObserver {
    public static final CallSmsEntityChangeObserver INSTANCE = null;
    private static CallSmsEntityChangeCallBack delegate;

    static {
        INSTANCE = new CallSmsEntityChangeObserver();
    }

    private CallSmsEntityChangeObserver() {
    }

    public final void setDelegate(CallSmsEntityChangeCallBack r1) {
        Intrinsics.checkNotNullParameter(r1, "delegate");
        delegate = r1;
    }

    public final void bulkIndex(List<? extends AppEntity> r1) {
        Intrinsics.checkNotNullParameter(r1, "entities");
        CallSmsEntityChangeCallBack r0 = delegate;
        if (r0 == null) goto L6;
        r0.onBulkIndex(r1);
        return;
    }

    public final void bulkDelete(List<String> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "entityIds");
        CallSmsEntityChangeCallBack r0 = delegate;
        if (r0 == null) goto L6;
        r0.onBulkDelete(r1, r2);
        return;
    }
}
