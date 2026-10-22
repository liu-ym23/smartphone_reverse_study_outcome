package com.bytedance.android.livesdkapi.arch;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J+\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/arch/INewShareContext;", "", "shareByUniqueId", "", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "uniqueId", "", "shareGlobalSingleInstance", "shareToScope", "roomId", "", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;Ljava/lang/Long;Ljava/lang/String;)V", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface INewShareContext {
    void shareByUniqueId(DataCenter r100, String r101);

    void shareGlobalSingleInstance();

    void shareToScope(DataCenter r100, Long r101, String r102);
}
