package btb;

import atb.a;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.AbstractNotification;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a<R extends atb.a> implements AbstractNotification.AbstractNotificationDisplayer.a<R> {
    public a() {
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer.a
    public final void a(R r100) {
        Intrinsics.checkNotNullParameter(r100, "notification");
        Log.w("NotificationFactory", "EmptyNotificationDisplayer showNotification");
    }
}
