package com.bytedance.android.livesdkapi.imagerecognition;

import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0014\u001a\u00020\u0012H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/imagerecognition/ImageRecognitionButton;", "", "descRes", "", "getDescRes", "()I", "iconRes", "getIconRes", "scene", "getScene", "canShow", "", "canShowRedDot", "getBtmToken", "", BaseSwitches.V, "Landroid/view/View;", SendEventContainerMethodParamModel.EventKinds.onClick, "", "onHide", SendEventContainerMethodParamModel.EventKinds.onShow, "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ImageRecognitionButton {
    boolean canShow();

    boolean canShowRedDot();

    String getBtmToken(View r100);

    int getDescRes();

    int getIconRes();

    int getScene();

    void onClick(View r100);

    void onHide();

    void onShow();
}
