package com.bytedance.android.livesdkapi.feed;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/IPkFeedView;", "", "getPkExpandType", "", "getProgressAnimUrl", "getTeamTaskExtendView", "Landroid/view/View;", "getViewState", "Lcom/bytedance/android/livesdkapi/feed/IFeedViewState;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPkFeedView {
    String getPkExpandType();

    String getProgressAnimUrl();

    View getTeamTaskExtendView();

    IFeedViewState getViewState();
}
