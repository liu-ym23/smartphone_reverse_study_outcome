package ak2;

import com.bytedance.android.livesdkapi.room.handler.IExternalMessageListener;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i implements com.bytedance.android.livesdk.livecommerce.room.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3985a;

    public i(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f3985a = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.d
    public final void b(td.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Object r101 = this.f3985a;
        if ((r101 instanceof td.c) == false) goto L6;
        ((td.c) r101).b(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.d
    public final void c(IExternalMessageListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Object r101 = this.f3985a;
        if ((r101 instanceof ILiveRoomMessageHandler) == false) goto L6;
        ((ILiveRoomMessageHandler) r101).removeListener(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.d
    public final void d(IExternalMessageListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Object r101 = this.f3985a;
        if ((r101 instanceof ILiveRoomMessageHandler) == false) goto L6;
        ((ILiveRoomMessageHandler) r101).addListener(1003, r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.d
    public final void a(int r100, td.a r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        Object r102 = this.f3985a;
        if ((r102 instanceof td.c) == false) goto L6;
        ((td.c) r102).a(r100, r101);
        return;
    }
}
