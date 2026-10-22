package com.bytedance.android.livehostapi.business.depend.livead;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveAdAnchorView;", "", "addOnClickListener", "", "listener", "Landroid/view/View$OnClickListener;", "getView", "Landroid/view/View;", "removeOnClickListener", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveAdAnchorView {
    void addOnClickListener(View.OnClickListener r100);

    View getView();

    void removeOnClickListener(View.OnClickListener r100);
}
