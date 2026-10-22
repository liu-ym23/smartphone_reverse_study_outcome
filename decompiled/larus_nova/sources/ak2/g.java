package ak2;

import com.bytedance.android.ec.adapter.api.handler.viewinterface.ECExternalViewGroupAction;
import com.bytedance.android.livesdk.livecommerce.room.widgets.start_live.StartLivePromotionButton;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements com.bytedance.android.livesdk.livecommerce.room.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3981a;

    public g(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        this.f3981a = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.a
    public final void a(StartLivePromotionButton r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Object r101 = this.f3981a;
        if ((r101 instanceof wd.f) == false) goto L6;
        ((wd.f) r101).a(r100);
        return;
    L6:
        if ((r101 instanceof IExternalViewGroup) == false) goto L10;
        ((IExternalViewGroup) r101).add(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.a
    public final void b(StartLivePromotionButton r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Object r101 = this.f3981a;
        if ((r101 instanceof wd.f) == false) goto L6;
        ((wd.f) r101).b(r100);
        return;
    L6:
        if ((r101 instanceof IExternalViewGroup) == false) goto L10;
        ((IExternalViewGroup) r101).remove(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.a
    public final void c(Function3<? super wd.f, ? super wd.e, ? super ECExternalViewGroupAction, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Object r101 = this.f3981a;
        if ((r101 instanceof wd.f) == false) goto L6;
        ((wd.f) r101).addListener(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.a
    public final void d(Function3<? super wd.f, ? super wd.e, ? super ECExternalViewGroupAction, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Object r101 = this.f3981a;
        if ((r101 instanceof wd.f) == false) goto L6;
        ((wd.f) r101).removeListener(r100);
        return;
    }
}
