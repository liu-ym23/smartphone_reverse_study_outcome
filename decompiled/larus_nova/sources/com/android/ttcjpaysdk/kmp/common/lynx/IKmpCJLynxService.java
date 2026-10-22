package com.android.ttcjpaysdk.kmp.common.lynx;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import pd6.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&JE\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010\u000fJ@\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0005H&J\u001c\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005H&J \u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0019H&J \u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0019H&¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/lynx/IKmpCJLynxService;", "Lcom/bytedance/kmp/spi/IKmpService;", "openLynxPageBySchema", "", "schema", "", "callback", "Lcom/android/ttcjpaysdk/kmp/common/lynx/IKmpCJLynxActionCallback;", "openCJLynxDialog", "initData", "globalProps", NewBroadcastMonitor.STAGE.LIFECYCLE, "Lcom/android/ttcjpaysdk/kmp/common/lynx/IKmpCJLynxDialogLifecycle;", "needMask", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/kmp/common/lynx/IKmpCJLynxDialogLifecycle;Ljava/lang/Boolean;)Ljava/lang/String;", "openCJLynxDialogWithContainerId", "Lcom/android/ttcjpaysdk/kmp/common/lynx/IKmpCJLynxContainerIdCallback;", "dismissCJLynxDialog", "pageId", "sendJsEvent", "eventName", WsConstants.KEY_PAYLOAD, "subscribe", "callbackID", "Lcom/android/ttcjpaysdk/kmp/common/lynx/IKmpCJEventCallback;", "unsubscribe", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJLynxService extends a {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void openLynxPageBySchema$default(IKmpCJLynxService r100, String r101, IKmpCJLynxActionCallback r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.openLynxPageBySchema(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openLynxPageBySchema");
        }

        public static /* synthetic */ void sendJsEvent$default(IKmpCJLynxService r100, String r101, String r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.sendJsEvent(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendJsEvent");
        }

        public static /* synthetic */ String openCJLynxDialog$default(IKmpCJLynxService r100, String r101, String r102, String r110, IKmpCJLynxDialogLifecycle r111, Boolean r112, int r113, Object r114) {
            if (r114 != null) goto L21;
            if ((r113 & 2) == 0) goto L6;
            String r103 = null;
        L8:
            if ((r113 & 4) == 0) goto L10;
            String r104 = null;
        L12:
            if ((r113 & 8) == 0) goto L14;
            IKmpCJLynxDialogLifecycle r105 = null;
        L16:
            if ((r113 & 16) == 0) goto L19;
            r112 = Boolean.FALSE;
        L19:
            return r100.openCJLynxDialog(r101, r103, r104, r105, r112);
        L14:
            r105 = r111;
            goto L16
        L10:
            r104 = r110;
            goto L12
        L6:
            r103 = r102;
            goto L8
        L21:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openCJLynxDialog");
        }

        public static /* synthetic */ void openCJLynxDialogWithContainerId$default(IKmpCJLynxService r100, String r101, String r102, String r110, IKmpCJLynxDialogLifecycle r111, IKmpCJLynxContainerIdCallback r112, int r113, Object r114) {
            if (r114 != null) goto L22;
            if ((r113 & 2) == 0) goto L6;
            String r103 = null;
        L8:
            if ((r113 & 4) == 0) goto L10;
            String r104 = null;
        L12:
            if ((r113 & 8) == 0) goto L14;
            IKmpCJLynxDialogLifecycle r105 = null;
        L16:
            if ((r113 & 16) == 0) goto L18;
            IKmpCJLynxContainerIdCallback r106 = null;
        L19:
            r100.openCJLynxDialogWithContainerId(r101, r103, r104, r105, r106);
            return;
        L18:
            r106 = r112;
            goto L19
        L14:
            r105 = r111;
            goto L16
        L10:
            r104 = r110;
            goto L12
        L6:
            r103 = r102;
            goto L8
        L22:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openCJLynxDialogWithContainerId");
        }
    }

    void dismissCJLynxDialog(String r100);

    String openCJLynxDialog(String r100, String r101, String r102, IKmpCJLynxDialogLifecycle r103, Boolean r104);

    void openCJLynxDialogWithContainerId(String r100, String r101, String r102, IKmpCJLynxDialogLifecycle r103, IKmpCJLynxContainerIdCallback r104);

    void openLynxPageBySchema(String r100, IKmpCJLynxActionCallback r101);

    void sendJsEvent(String r100, String r101);

    void subscribe(String r100, String r101, IKmpCJEventCallback r102);

    void unsubscribe(String r100, String r101, IKmpCJEventCallback r102);
}
