package com.bytedance.android.livesdkapi.view;

import android.view.View;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/view/IExtraRenderView;", "", "isSurfaceView", "", "selfView", "Landroid/view/View;", "setVisibility", "", RemoteMessageConst.Notification.VISIBILITY, "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExtraRenderView {
    boolean isSurfaceView();

    View selfView();

    void setVisibility(int r100);
}
