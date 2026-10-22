package com.bytedance.android.livesdk.feedback.condition.trigger;

import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import com.bytedance.android.livesdk.message.model.o4;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import vlc.l;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/condition/trigger/ReceiveLiveRoomFeedbackMsgTrigger;", "Lfx1/c;", "Lcom/bytedance/android/livesdk/message/model/o4;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReceiveLiveRoomFeedbackMsgTrigger extends fx1.c<o4> implements l, Observer<KVData> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f124664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TriggerId f124665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public vlc.d f124666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DataCenter f124667g;

    @Override // fx1.c, fx1.e
    public final void a() {
        super.a();
        DataCenter r100 = this.f124667g;
        vlc.d r101 = null;
        if (r100 == null) goto L5;
        r101 = (vlc.d) r100.get("data_message_manager", null);
    L5:
        this.f124666f = r101;
        if (r101 == null) goto L13;
        Iterator<T> r102 = this.f124664d.iterator();
    L9:
        if (r102.hasNext() == false) goto L23;
        int r103 = ((Number) r102.next()).intValue();
        vlc.d r104 = this.f124666f;
        if (r104 == null) goto L9;
        r104.addMessageListener(r103, this);
        goto L9
    L23:
        return;
    L13:
        DataCenter r105 = this.f124667g;
        if (r105 == null) goto L22;
        r105.observe("data_message_manager", this);
        return;
    }

    @Override // fx1.c, fx1.e
    public final void reset() {
        super.reset();
        vlc.d r100 = this.f124666f;
        if (r100 == null) goto L6;
        r100.removeMessageListener(this);
        return;
    }

    @Override // fx1.e
    public final TriggerId getId() {
        return this.f124665e;
    }

    public ReceiveLiveRoomFeedbackMsgTrigger(DataCenter r100) {
        this.f124667g = r100;
        this.f124664d = CollectionsKt.listOf(Integer.valueOf(MessageType.FEEDBACK_CARD_MESSAGE.getIntType()));
        this.f124665e = TriggerId.RECEIVE_LIVE_ROOM_FEEDBACK_MSG;
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
        this.f124666f = r103;
        Iterator<T> r104 = this.f124664d.iterator();
    L18:
        if (r104.hasNext() == false) goto L31;
        int r105 = ((Number) r104.next()).intValue();
        vlc.d r106 = this.f124666f;
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

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r100 instanceof o4) == false) goto L8;
        e(r100);
        return;
    }
}
