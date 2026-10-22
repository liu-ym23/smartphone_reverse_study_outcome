package com.bytedance.android.livesdkapi.message;

import kotlin.Metadata;
import ylc.c;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/OnWRDSDataUpdateListener;", "", "", "syncKey", "value", "", "onWRDSDataUpdate", "Lylc/c;", "getDataSyncListener", "()Lylc/c;", "setDataSyncListener", "(Lylc/c;)V", "dataSyncListener", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface OnWRDSDataUpdateListener {
    c getDataSyncListener();

    void onWRDSDataUpdate(String r100, Object r101);

    void setDataSyncListener(c r100);
}
