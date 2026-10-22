package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.livesdk.message.model.gn;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/VisibilityRangeServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VisibilityRangeServiceWidget extends RoomRecyclableWidget implements vlc.l, Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vlc.d f118737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f118738b;

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        vlc.d r100 = this.f118737a;
        if (r100 == null) goto L6;
        r100.removeMessageListener(this);
        return;
    }

    public VisibilityRangeServiceWidget() {
        this.f118738b = CollectionsKt.listOf(Integer.valueOf(MessageType.VISIBILITY_RANGE_CHANGE_MESSAGE.getIntType()));
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.hashCode() == (-1434292000)) goto L12;
        return;
    L12:
        if (r102.equals("data_message_manager") == false) goto L22;
        vlc.d r103 = (vlc.d) r101.getData();
        if (r103 == null) goto L30;
        this.f118737a = r103;
        Iterator<T> r104 = this.f118738b.iterator();
    L18:
        if (r104.hasNext() == false) goto L31;
        int r105 = ((Number) r104.next()).intValue();
        vlc.d r106 = this.f118737a;
        if (r106 == null) goto L18;
        r106.addMessageListener(r105, this);
        goto L18
    L31:
        return;
    L30:
        return;
    L22:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        DataCenter r101 = this.dataCenter;
        vlc.d r102 = null;
        if (r101 == null) goto L5;
        r102 = (vlc.d) r101.get("data_message_manager", null);
    L5:
        this.f118737a = r102;
        if (r102 == null) goto L13;
        Iterator<T> r103 = this.f118738b.iterator();
    L9:
        if (r103.hasNext() == false) goto L23;
        int r104 = ((Number) r103.next()).intValue();
        vlc.d r105 = this.f118737a;
        if (r105 == null) goto L9;
        r105.addMessageListener(r104, this);
        goto L9
    L23:
        return;
    L13:
        DataCenter r106 = this.dataCenter;
        if (r106 == null) goto L22;
        r106.observe("data_message_manager", this);
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof gn) == false) goto L14;
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L15;
        Room r102 = com.bytedance.android.live.core.utils.z.o(r101);
        if (r102 == null) goto L16;
        Long r103 = ((gn) r100).visibilityRange;
        if (r103 == null) goto L11;
        Integer r104 = Integer.valueOf((int) r103.longValue());
    L12:
        Intrinsics.checkNotNull(r104);
        r102.setVisibilityRange(r104.intValue());
        return;
    L11:
        r104 = null;
        goto L12
    L16:
        return;
    L15:
        return;
    }
}
