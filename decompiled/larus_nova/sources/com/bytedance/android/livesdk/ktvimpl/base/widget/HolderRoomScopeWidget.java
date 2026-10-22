package com.bytedance.android.livesdk.ktvimpl.base.widget;

import be2.a;
import com.bytedance.android.livesdk.ktvapi.HolderRoomWidget;
import com.bytedance.android.scope.m;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import dn0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/widget/HolderRoomScopeWidget;", "Lcom/bytedance/android/livesdk/ktvapi/HolderRoomWidget;", "Lbe2/a;", "<init>", "()V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class HolderRoomScopeWidget extends HolderRoomWidget implements a {
    public HolderRoomScopeWidget() {
    }

    @Override // be2.a
    public final <T extends b> T getScopeServiceOrNullInMultiLinkRoom(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, NsdHelper.serviceTypeKey);
        Intrinsics.checkNotNullParameter(r100, NsdHelper.serviceTypeKey);
        bn0.b r101 = this.f142287b;
        b r102 = null;
        if (r101 == null) goto L20;
        m r103 = m.f163449e;
        Intrinsics.checkNotNull(r101);
        b r104 = (b) r103.d(r101, r100);
        if (r104 != null) goto L11;
        b r105 = this.f142288c.get(r100);
        if ((r105 instanceof b) == true) goto L9;
        r105 = null;
    L9:
        r104 = r105;
    L11:
        if (this.f142288c.containsKey(r100) == true) goto L19;
        if ((r104 instanceof b) == false) goto L16;
        r102 = r104;
    L16:
        if (r102 == null) goto L19;
        this.f142288c.put(r100, r102);
    L19:
        return (T) r104;
    L20:
        return null;
    }
}
