package com.bytedance.android.ec.host.api.ug;

import android.app.Activity;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J&\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/host/api/ug/IECUGHostService;", "", "addDeeplinkBackView", "", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "activity", "Landroid/app/Activity;", "scene", "", "removeDeeplinkBackView", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECUGHostService {
    void addDeeplinkBackView(ViewGroup r100, Activity r101, String r102);

    void removeDeeplinkBackView(ViewGroup r100, Activity r101, String r102);
}
