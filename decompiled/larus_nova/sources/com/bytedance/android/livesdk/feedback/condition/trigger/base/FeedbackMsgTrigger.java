package com.bytedance.android.livesdk.feedback.condition.trigger.base;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import fx1.d;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import vlc.l;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/condition/trigger/base/FeedbackMsgTrigger;", "Lfx1/d;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class FeedbackMsgTrigger extends d implements l, Observer<KVData> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public vlc.d f124690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataCenter f124691e;

    public List<String> g() {
        return null;
    }

    public abstract List<Integer> h();

    public abstract void i(tlc.d r100);

    @Override // fx1.c, fx1.e
    public final void a() {
        super.a();
        DataCenter r100 = this.f124691e;
        vlc.d r101 = null;
        if (r100 == null) goto L5;
        r101 = (vlc.d) r100.get("data_message_manager", null);
    L5:
        this.f124690d = r101;
        if (r101 == null) goto L8;
        j(r101);
        return;
    L8:
        DataCenter r102 = this.f124691e;
        if (r102 == null) goto L13;
        r102.observe("data_message_manager", this);
        return;
    }

    @Override // fx1.c, fx1.e
    public final void reset() {
        super.reset();
        vlc.d r100 = this.f124690d;
        if (r100 == null) goto L6;
        r100.removeMessageListener(this);
        return;
    }

    public FeedbackMsgTrigger(DataCenter r100) {
        this.f124691e = r100;
    }

    public final void j(vlc.d r100) {
        Iterator<T> r101 = h().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.addMessageListener(((Number) r101.next()).intValue(), this);
        goto L4
    L6:
        List<String> r102 = g();
        if (r102 == null) goto L12;
        Iterator<T> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L15;
        r100.addMessageListener((String) r103.next(), this);
        goto L10
    L15:
        return;
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
        if (r102.equals("data_message_manager") == false) goto L18;
        vlc.d r103 = (vlc.d) r101.getData();
        if (r103 == null) goto L21;
        this.f124690d = r103;
        j(r103);
        return;
    L21:
        return;
    L18:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (r100 == null) goto L5;
        i(r100);
        return;
    }
}
