package com.bytedance.android.livehostapi.business.depend;

import android.view.View;
import com.bytedance.android.live.base.model.user.f;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u001e\u0010\u0007\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J.\u0010\u000e\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u001e\u0010\u000f\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/ISharePanelStateListener;", "", "", "", "params", "", SendEventContainerMethodParamModel.EventKinds.onShow, "onDismiss", "Landroid/view/View;", "view", "onClose", "", "Lcom/bytedance/android/live/base/model/user/f;", "contacts", "onInvite", "onGenCodeShare", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ISharePanelStateListener {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.ISharePanelStateListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onClose(ISharePanelStateListener r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "view");
        }

        public static void $default$onDismiss(ISharePanelStateListener r100, Map r101) {
        }

        public static void $default$onGenCodeShare(ISharePanelStateListener r100, Map r101) {
        }

        public static void $default$onInvite(ISharePanelStateListener r100, List r101, Map r102) {
        }

        public static void $default$onShow(ISharePanelStateListener r100, Map r101) {
        }

        public static /* synthetic */ void access$onClose$jd(ISharePanelStateListener r100, View r101) {
            $default$onClose(r100, r101);
        }

        public static /* synthetic */ void access$onDismiss$jd(ISharePanelStateListener r100, Map r101) {
            $default$onDismiss(r100, r101);
        }

        public static /* synthetic */ void access$onGenCodeShare$jd(ISharePanelStateListener r100, Map r101) {
            $default$onGenCodeShare(r100, r101);
        }

        public static /* synthetic */ void access$onShow$jd(ISharePanelStateListener r100, Map r101) {
            $default$onShow(r100, r101);
        }

        public static /* synthetic */ void access$onInvite$jd(ISharePanelStateListener r100, List r101, Map r102) {
            $default$onInvite(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onClose(ISharePanelStateListener r100, View r101) {
            CC.access$onClose$jd(r100, r101);
        }

        public static void onDismiss(ISharePanelStateListener r100, Map<String, String> r101) {
            CC.access$onDismiss$jd(r100, r101);
        }

        public static void onGenCodeShare(ISharePanelStateListener r100, Map<String, String> r101) {
            CC.access$onGenCodeShare$jd(r100, r101);
        }

        public static void onShow(ISharePanelStateListener r100, Map<String, String> r101) {
            CC.access$onShow$jd(r100, r101);
        }

        public static void onInvite(ISharePanelStateListener r100, List<? extends f> r101, Map<String, String> r102) {
            CC.access$onInvite$jd(r100, r101, r102);
        }
    }

    void onClose(View r100);

    void onDismiss(Map<String, String> r100);

    void onGenCodeShare(Map<String, String> r100);

    void onInvite(List<? extends f> r100, Map<String, String> r101);

    void onShow(Map<String, String> r100);
}
