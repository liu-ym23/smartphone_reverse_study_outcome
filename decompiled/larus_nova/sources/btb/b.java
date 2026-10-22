package btb;

import atb.a;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b<R extends atb.a> implements AbstractNotification.AbstractNotificationDisplayer.a<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy<AbstractNotification.AbstractNotificationDisplayer.a<R>> f20708a;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Lazy<? extends AbstractNotification.AbstractNotificationDisplayer.a<R>> r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f20708a = r100;
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer.a
    public final void a(R r100) {
        Intrinsics.checkNotNullParameter(r100, "notification");
        this.f20708a.getValue().a(r100);
    }
}
