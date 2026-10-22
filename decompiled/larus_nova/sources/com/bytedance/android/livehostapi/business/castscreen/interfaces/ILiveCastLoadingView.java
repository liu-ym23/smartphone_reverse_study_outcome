package com.bytedance.android.livehostapi.business.castscreen.interfaces;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/interfaces/ILiveCastLoadingView;", "", "getView", "Landroid/view/View;", "isAnimating", "", "startAnimation", "", "stopAnimation", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveCastLoadingView {
    View getView();

    boolean isAnimating();

    void startAnimation();

    void stopAnimation();
}
