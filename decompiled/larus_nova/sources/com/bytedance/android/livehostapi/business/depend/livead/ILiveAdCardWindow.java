package com.bytedance.android.livehostapi.business.depend.livead;

import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0016J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J8\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0003H&¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveAdCardWindow;", "", "dismiss", "", "getContainer", "Landroid/view/View;", "getShowDelayMilliSeconds", "", "getShowDurationMilliSeconds", "isShowing", "removeAdCardShowPendingTask", "", "setListener", "listener", "Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveAdCardWindow$Listener;", "show", "anchorView", GXTemplateKey.GAIAX_LAYER_GRAVITY, "", "delay", "duration", "cardLoadFailed", "Listener", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveAdCardWindow {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.livead.ILiveAdCardWindow$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static long $default$getShowDelayMilliSeconds(ILiveAdCardWindow r100) {
            return 0;
        }

        public static long $default$getShowDurationMilliSeconds(ILiveAdCardWindow r100) {
            return 0;
        }

        public static /* synthetic */ long access$getShowDelayMilliSeconds$jd(ILiveAdCardWindow r100) {
            return $default$getShowDelayMilliSeconds(r100);
        }

        public static /* synthetic */ long access$getShowDurationMilliSeconds$jd(ILiveAdCardWindow r100) {
            return $default$getShowDurationMilliSeconds(r100);
        }

        public static /* synthetic */ boolean show$default(ILiveAdCardWindow r100, View r101, int r102, long r103, long r110, boolean r111, int r112, Object r113) {
            if (r113 != null) goto L22;
            if ((r112 & 2) == 0) goto L6;
            int r104 = 48;
        L8:
            if ((r112 & 4) == 0) goto L10;
            long r105 = r100.getShowDelayMilliSeconds();
        L12:
            if ((r112 & 8) == 0) goto L14;
            long r106 = r100.getShowDurationMilliSeconds();
        L16:
            if ((r112 & 16) == 0) goto L18;
            boolean r107 = false;
        L20:
            return r100.show(r101, r104, r105, r106, r107);
        L18:
            r107 = r111;
            goto L20
        L14:
            r106 = r110;
            goto L16
        L10:
            r105 = r103;
            goto L12
        L6:
            r104 = r102;
            goto L8
        L22:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static long getShowDelayMilliSeconds(ILiveAdCardWindow r100) {
            return CC.access$getShowDelayMilliSeconds$jd(r100);
        }

        public static long getShowDurationMilliSeconds(ILiveAdCardWindow r100) {
            return CC.access$getShowDurationMilliSeconds$jd(r100);
        }

        public static /* synthetic */ boolean show$default(ILiveAdCardWindow r100, View r101, int r102, long r103, long r104, boolean r105, int r106, Object r107) {
            return CC.show$default(r100, r101, r102, r103, r104, r105, r106, r107);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveAdCardWindow$Listener;", "", "onDismiss", "", SendEventContainerMethodParamModel.EventKinds.onShow, "onShowFail", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface Listener {
        void onDismiss();

        void onShow();

        void onShowFail();
    }

    boolean dismiss();

    View getContainer();

    long getShowDelayMilliSeconds();

    long getShowDurationMilliSeconds();

    boolean isShowing();

    void removeAdCardShowPendingTask();

    void setListener(Listener r100);

    boolean show(View r100, int r101, long r102, long r103, boolean r104);
}
