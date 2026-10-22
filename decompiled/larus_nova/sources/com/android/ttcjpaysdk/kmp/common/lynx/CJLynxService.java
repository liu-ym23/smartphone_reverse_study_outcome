package com.android.ttcjpaysdk.kmp.common.lynx;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J=\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J8\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u001a\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u001bH\u0016J \u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u001bH\u0016¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/lynx/CJLynxService;", "Lcom/android/ttcjpaysdk/kmp/common/lynx/IKmpCJLynxService;", "<init>", "()V", "openLynxPageBySchema", "", "schema", "", "callback", "Lcom/android/ttcjpaysdk/kmp/common/lynx/IKmpCJLynxActionCallback;", "openCJLynxDialog", "initData", "globalProps", NewBroadcastMonitor.STAGE.LIFECYCLE, "Lcom/android/ttcjpaysdk/kmp/common/lynx/IKmpCJLynxDialogLifecycle;", "needMask", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/kmp/common/lynx/IKmpCJLynxDialogLifecycle;Ljava/lang/Boolean;)Ljava/lang/String;", "openCJLynxDialogWithContainerId", "Lcom/android/ttcjpaysdk/kmp/common/lynx/IKmpCJLynxContainerIdCallback;", "dismissCJLynxDialog", "pageId", "sendJsEvent", "eventName", WsConstants.KEY_PAYLOAD, "subscribe", "callbackID", "Lcom/android/ttcjpaysdk/kmp/common/lynx/IKmpCJEventCallback;", "unsubscribe", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJLynxService implements IKmpCJLynxService {
    public static final int $stable = 0;
    public static final CJLynxService INSTANCE = null;

    static {
        INSTANCE = new CJLynxService();
    }

    private CJLynxService() {
    }

    @Override // com.android.ttcjpaysdk.kmp.common.lynx.IKmpCJLynxService
    public void dismissCJLynxDialog(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageId");
        b r101 = c.f528682a;
        IKmpCJLynxService r102 = (IKmpCJLynxService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJLynxService.class));
        if (r102 == null) goto L6;
        r102.dismissCJLynxDialog(r100);
        return;
    }

    @Override // com.android.ttcjpaysdk.kmp.common.lynx.IKmpCJLynxService
    public void openLynxPageBySchema(String r100, IKmpCJLynxActionCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        b r102 = c.f528682a;
        IKmpCJLynxService r103 = (IKmpCJLynxService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJLynxService.class));
        if (r103 == null) goto L6;
        r103.openLynxPageBySchema(r100, r101);
        return;
    }

    @Override // com.android.ttcjpaysdk.kmp.common.lynx.IKmpCJLynxService
    public void sendJsEvent(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        b r102 = c.f528682a;
        IKmpCJLynxService r103 = (IKmpCJLynxService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJLynxService.class));
        if (r103 == null) goto L6;
        r103.sendJsEvent(r100, r101);
        return;
    }

    @Override // com.android.ttcjpaysdk.kmp.common.lynx.IKmpCJLynxService
    public void subscribe(String r100, String r101, IKmpCJEventCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "callbackID");
        Intrinsics.checkNotNullParameter(r102, "callback");
        b r103 = c.f528682a;
        IKmpCJLynxService r104 = (IKmpCJLynxService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJLynxService.class));
        if (r104 == null) goto L6;
        r104.subscribe(r100, r101, r102);
        return;
    }

    @Override // com.android.ttcjpaysdk.kmp.common.lynx.IKmpCJLynxService
    public void unsubscribe(String r100, String r101, IKmpCJEventCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "callbackID");
        Intrinsics.checkNotNullParameter(r102, "callback");
        b r103 = c.f528682a;
        IKmpCJLynxService r104 = (IKmpCJLynxService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJLynxService.class));
        if (r104 == null) goto L6;
        r104.unsubscribe(r100, r101, r102);
        return;
    }

    @Override // com.android.ttcjpaysdk.kmp.common.lynx.IKmpCJLynxService
    public String openCJLynxDialog(String r100, String r101, String r110, IKmpCJLynxDialogLifecycle r111, Boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        b r102 = c.f528682a;
        IKmpCJLynxService r103 = (IKmpCJLynxService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJLynxService.class));
        if (r103 == null) goto L6;
        String r104 = r103.openCJLynxDialog(r100, r101, r110, r111, r112);
        if (r104 == null) goto L6;
        return r104;
    L6:
        return "";
    }

    @Override // com.android.ttcjpaysdk.kmp.common.lynx.IKmpCJLynxService
    public void openCJLynxDialogWithContainerId(String r100, String r101, String r110, IKmpCJLynxDialogLifecycle r111, IKmpCJLynxContainerIdCallback r112) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        b r102 = c.f528682a;
        IKmpCJLynxService r103 = (IKmpCJLynxService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJLynxService.class));
        if (r103 == null) goto L6;
        r103.openCJLynxDialogWithContainerId(r100, r101, r110, r111, r112);
        return;
    }
}
