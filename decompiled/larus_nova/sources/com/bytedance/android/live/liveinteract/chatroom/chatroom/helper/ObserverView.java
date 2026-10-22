package com.bytedance.android.live.liveinteract.chatroom.chatroom.helper;

import android.view.View;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes46.dex */
public class ObserverView<V extends View> implements Observer<KVData> {
    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getKey() != null) goto L7;
        return;
    L7:
        if (r101.getData() == null) goto L13;
        r101.getKey();
        r101.getData();
        throw null;
    }
}
