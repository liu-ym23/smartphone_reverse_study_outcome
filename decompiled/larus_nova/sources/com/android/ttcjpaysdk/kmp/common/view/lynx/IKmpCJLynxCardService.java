package com.android.ttcjpaysdk.kmp.common.view.lynx;

import android.app.Activity;
import android.view.View;
import com.android.ttcjpaysdk.kmp.common.lynx.IKmpCJEventCallback;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&JR\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/lynx/IKmpCJLynxCardService;", "Lcom/android/ttcjpaysdk/kmp/common/view/lynx/IKmpCJLynxCardBaseService;", "createLynxCardView", "Landroid/view/View;", "activity", "Landroid/app/Activity;", "schema", "", "initData", "globalProps", NewBroadcastMonitor.STAGE.LIFECYCLE, "Lcom/android/ttcjpaysdk/kmp/common/view/lynx/IKmpCJLynxCardLifecycle;", "viewConfig", "Lcom/android/ttcjpaysdk/kmp/common/view/lynx/KmpCJLynxCardViewConfig;", "createCJAnnieXCard", "eventCallback", "Lcom/android/ttcjpaysdk/kmp/common/lynx/IKmpCJEventCallback;", "releaseCJAnnieXCard", "", "cardView", "getLynxCardContainerId", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJLynxCardService extends IKmpCJLynxCardBaseService {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static View createCJAnnieXCard(IKmpCJLynxCardService r100, Activity r101, String r102, String r103, String r104, IKmpCJLynxCardLifecycle r105, KmpCJLynxCardViewConfig r106, IKmpCJEventCallback r107) {
            Intrinsics.checkNotNullParameter(r102, "schema");
            return null;
        }

        public static String getLynxCardContainerId(IKmpCJLynxCardService r100, View r101) {
            return null;
        }

        public static void releaseCJAnnieXCard(IKmpCJLynxCardService r100, View r101) {
        }

        public static /* synthetic */ View createLynxCardView$default(IKmpCJLynxCardService r100, Activity r101, String r102, String r110, String r111, IKmpCJLynxCardLifecycle r112, KmpCJLynxCardViewConfig r113, int r114, Object r115) {
            if (r115 != null) goto L9;
            if ((r114 & 1) == 0) goto L7;
            r101 = null;
        L7:
            return r100.createLynxCardView(r101, r102, r110, r111, r112, r113);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLynxCardView");
        }

        public static /* synthetic */ View createCJAnnieXCard$default(IKmpCJLynxCardService r110, Activity r111, String r112, String r113, String r114, IKmpCJLynxCardLifecycle r115, KmpCJLynxCardViewConfig r116, IKmpCJEventCallback r117, int r118, Object r119) {
            if (r119 != null) goto L14;
            if ((r118 & 1) == 0) goto L6;
            Activity r100 = null;
        L8:
            if ((r118 & 64) == 0) goto L10;
            IKmpCJEventCallback r101 = null;
        L12:
            return r110.createCJAnnieXCard(r100, r112, r113, r114, r115, r116, r101);
        L10:
            r101 = r117;
            goto L12
        L6:
            r100 = r111;
            goto L8
        L14:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createCJAnnieXCard");
        }
    }

    View createCJAnnieXCard(Activity r100, String r101, String r102, String r103, IKmpCJLynxCardLifecycle r104, KmpCJLynxCardViewConfig r105, IKmpCJEventCallback r106);

    View createLynxCardView(Activity r100, String r101, String r102, String r103, IKmpCJLynxCardLifecycle r104, KmpCJLynxCardViewConfig r105);

    String getLynxCardContainerId(View r100);

    void releaseCJAnnieXCard(View r100);
}
