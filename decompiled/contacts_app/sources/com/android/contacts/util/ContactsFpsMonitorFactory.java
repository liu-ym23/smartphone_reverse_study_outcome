package com.android.contacts.util;

import com.obric.contactsdk.loader.ContractKt;
import com.obric.matrix.platform.sdk.ones.commonmonitor.fps.FPSSceneMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactsFpsMonitorFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/contacts/util/ContactsFpsMonitorFactory;", "", "()V", ContractKt.OBRIC_ACTION_CREATE, "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSSceneMonitor;", "scene", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactsFpsMonitorFactory {
    public static final ContactsFpsMonitorFactory INSTANCE = null;

    static {
        INSTANCE = new ContactsFpsMonitorFactory();
    }

    private ContactsFpsMonitorFactory() {
    }

    public final FPSSceneMonitor create(String r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        return new FPSSceneMonitor(r3, false, null);
    }
}
