package com.bytedance.android.livehostapi.platform.depend.im;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001e\b\u0002\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007H&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/platform/depend/im/ILiveIMCusSerMsgProxy;", "", "getIMDynamicView", "Lcom/bytedance/android/livehostapi/platform/depend/im/ILiveIMDynamicView;", "activity", "Landroid/app/Activity;", "sizeChangeCallback", "Lkotlin/Function2;", "", "", "onUnreadCountChanged", "spUid", "", "unreadCount", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveIMCusSerMsgProxy {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.platform.depend.im.ILiveIMCusSerMsgProxy$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ILiveIMDynamicView getIMDynamicView$default(ILiveIMCusSerMsgProxy r100, Activity r101, Function2 r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = null;
        L7:
            return r100.getIMDynamicView(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getIMDynamicView");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ ILiveIMDynamicView getIMDynamicView$default(ILiveIMCusSerMsgProxy r100, Activity r101, Function2 r102, int r103, Object r104) {
            return CC.getIMDynamicView$default(r100, r101, r102, r103, r104);
        }
    }

    ILiveIMDynamicView getIMDynamicView(Activity r100, Function2<? super Integer, ? super Integer, Unit> r101);

    void onUnreadCountChanged(long r100, int r101);
}
