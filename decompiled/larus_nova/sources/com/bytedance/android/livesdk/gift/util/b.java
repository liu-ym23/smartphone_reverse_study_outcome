package com.bytedance.android.livesdk.gift.util;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.gift.platform.business.config.j;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftInRoomService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.OpenDialogService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u0;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.scope.m;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.k;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import i12.o;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static final j a() {
        GiftContext r100 = b();
        if (r100 == null) goto L9;
        i<j> r101 = r100.getGiftConfigStore();
        if (r101 == null) goto L9;
        j r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return new com.bytedance.android.livesdk.gift.platform.business.config.c().create();
    }

    public static final GiftContext b() {
        i12.e r100 = o.b();
        if (r100 == null) goto L5;
        Object r101 = m.f163449e.d(r100, GiftInRoomService.class);
    L6:
        GiftInRoomService r102 = (GiftInRoomService) r101;
        if (r102 == null) goto L15;
        Pair<GiftContext, ? extends Disposable> r103 = r102.f131280b;
        if (r103 == null) goto L11;
        GiftContext r104 = r103.getFirst();
    L12:
        if (r104 == null) goto L15;
    L24:
        return r104;
    L11:
        r104 = null;
    L15:
        i12.e r105 = o.a();
        if (r105 == null) goto L18;
        Object r106 = m.f163449e.d(r105, GiftInRoomService.class);
    L19:
        GiftInRoomService r107 = (GiftInRoomService) r106;
        if (r107 == null) goto L25;
        Pair<GiftContext, ? extends Disposable> r108 = r107.f131280b;
        if (r108 == null) goto L26;
        r104 = r108.getFirst();
        goto L24
    L26:
        return null;
    L25:
        return null;
    L18:
        r106 = null;
        goto L19
    L5:
        r101 = null;
        goto L6
    }

    public static final com.bytedance.android.livesdk.gift.platform.business.g c(boolean r100) {
        Object r101 = null;
        if (r100 == false) goto L8;
        i12.e r102 = o.a();
        if (r102 == null) goto L13;
        r101 = m.f163449e.d(r102, u0.class);
    L13:
        return (com.bytedance.android.livesdk.gift.platform.business.g) r101;
    L8:
        i12.e r103 = o.b();
        if (r103 == null) goto L12;
        r101 = m.f163449e.d(r103, u0.class);
    L12:
        return (com.bytedance.android.livesdk.gift.platform.business.g) r101;
    }

    public static final void e(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        GiftContext r101 = b();
        if (r101 == null) goto L12;
        i<Map<String, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a>> r102 = r101.getGiftViewModelMap();
        if (r102 == null) goto L14;
        Map<String, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a> r103 = r102.getValue();
        if (r103 == null) goto L15;
        Iterator<Map.Entry<String, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a>> r104 = r103.entrySet().iterator();
    L10:
        if (r104.hasNext() == false) goto L16;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r105 = r104.next().getValue();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "owner");
        r105.f127059a.removeObservers(r100);
        goto L10
    L16:
        return;
    L15:
        return;
    L14:
        return;
    }

    public static final void f(GiftStateMachineConfig.Event r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof GiftStateMachineConfig.Event.h) == false) goto L14;
        if (u.r() == true) goto L14;
        i12.e r101 = o.b();
        if (r101 == null) goto L9;
        Object r102 = m.f163449e.d(r101, OpenDialogService.class);
    L10:
        OpenDialogService r103 = (OpenDialogService) r102;
        if (r103 == null) goto L14;
        OpenDialogService.d(r103, ((GiftStateMachineConfig.Event.h) r100).f126987b, null, 2);
        goto L14
    L9:
        r102 = null;
    L14:
        if (r100.f126972a == false) goto L16;
        jy0.b.d("GiftStateEvent", "GiftViewModelNew: " + r100.a());
    L16:
        GiftContext r104 = b();
        if (r104 == null) goto L22;
        k<GiftStateMachineConfig.Event> r105 = r104.getGiftActionManager();
        if (r105 == null) goto L23;
        r105.post(r100);
        return;
    L23:
        return;
    }

    public static final void d(String r100, LifecycleOwner r101, Observer<GiftStateMachineConfig.g> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "observer");
        GiftContext r104 = b();
        if (r104 == null) goto L11;
        i<Map<String, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a>> r105 = r104.getGiftViewModelMap();
        if (r105 == null) goto L11;
        Map<String, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a> r106 = r105.getValue();
        if (r106 == null) goto L11;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r107 = r106.get(r100);
        if (r107 == null) goto L11;
        GiftStateMachineConfig.g r108 = r107.c(r101, r102);
    L12:
        if (r103 == false) goto L16;
        if (r108 == null) goto L17;
        r102.onChanged(r108);
        return;
    L17:
        return;
    L16:
        return;
    L11:
        r108 = null;
        goto L12
    }
}
