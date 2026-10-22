package com.bytedance.android.livesdk.interactivity.comment.share;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.Items;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f136226a;

    public b(a r100) {
        this.f136226a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        if (r101.statusCode != 0) goto L37;
        com.bytedance.android.livesdk.interactivity.comment.share.model.a r102 = (com.bytedance.android.livesdk.interactivity.comment.share.model.a) r101.data;
        if (r102 == null) goto L7;
        final List<com.bytedance.android.livesdk.interactivity.comment.share.model.a.b> r103 = r102.a();
    L8:
        List<com.bytedance.android.livesdk.interactivity.comment.share.model.a.b> r104 = r103;
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == false) goto L19;
        a.InterfaceC2158a r106 = (a.InterfaceC2158a) this.f136226a.f531633a;
        if (r106 == null) goto L45;
        r106.C10();
        return;
    L45:
        return;
    L19:
        this.f136226a.getClass();
        Items r107 = new Items();
        Iterator<com.bytedance.android.livesdk.interactivity.comment.share.model.a.b> r108 = r103.iterator();
    L21:
        if (r108.hasNext() == false) goto L33;
        com.bytedance.android.livesdk.interactivity.comment.share.model.a.b r109 = r108.next();
        Iterator<T> r110 = r109.a().iterator();
    L24:
        if (r110.hasNext() == false) goto L26;
        com.bytedance.android.livesdk.interactivity.comment.share.model.a.C2159a r111 = (com.bytedance.android.livesdk.interactivity.comment.share.model.a.C2159a) r110.next();
        r111.f136238a = r109.b();
        goto L24
    L26:
        com.bytedance.android.livesdk.interactivity.comment.share.model.a.C2159a r112 = (com.bytedance.android.livesdk.interactivity.comment.share.model.a.C2159a) CollectionsKt.firstOrNull(r109.a());
        if (r112 == null) goto L29;
        r112.f136239b = true;
    L29:
        com.bytedance.android.livesdk.interactivity.comment.share.model.a.C2159a r113 = (com.bytedance.android.livesdk.interactivity.comment.share.model.a.C2159a) CollectionsKt.lastOrNull(r109.a());
        if (r113 == null) goto L32;
        r113.f136240c = true;
    L32:
        r107.addAll(r109.a());
        r107.add(new com.bytedance.android.livesdk.interactivity.comment.share.binder.a());
        goto L21
    L33:
        a.InterfaceC2158a r114 = (a.InterfaceC2158a) this.f136226a.f531633a;
        if (r114 == null) goto L36;
        r114.Ux(r107);
    L36:
        int r115 = InteractivityShareAppLogger.f136222a;
        Intrinsics.checkNotNullParameter(r103, "shareDataList");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_room_share_panel_show", new InteractivityShareAppLogger$sendSharePanelShow$1(r103));
        return;
    L11:
        if (r104.isEmpty() == true) goto L14;
        r105 = false;
        goto L15
    L7:
        r103 = null;
        goto L8
    L37:
        a.InterfaceC2158a r116 = (a.InterfaceC2158a) this.f136226a.f531633a;
        if (r116 == null) goto L48;
        r116.y10();
        return;
    }
}
