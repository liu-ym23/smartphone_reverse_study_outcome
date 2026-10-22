package com.bytedance.android.livehostapi.business;

import android.view.View;
import com.bytedance.android.live.base.IService;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&J8\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u00072\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nH&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IBcmSearchTrack;", "Lcom/bytedance/android/live/base/IService;", "appendSearchParams", "", "view", "Landroid/view/View;", "enterMerge", "", "enterMethod", "searchParams", "", "", "pageId", "params", "getPageId", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBcmSearchTrack extends IService {
    Map<String, Object> appendSearchParams(String r100, Map<String, ? extends Object> r101);

    void appendSearchParams(View r100, String r101, String r102, String r103);

    String getPageId(View r100);
}
