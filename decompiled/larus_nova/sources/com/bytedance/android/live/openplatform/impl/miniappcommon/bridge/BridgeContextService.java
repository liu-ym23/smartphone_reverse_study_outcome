package com.bytedance.android.live.openplatform.impl.miniappcommon.bridge;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.android.livehostapi.business.depend.openplatform.IEventListener;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/bridge/BridgeContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BridgeContextService extends OpenPlatformContextService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f85008a;

    public final void f() {
        Iterator r100 = CollectionsKt.toList(this.f85008a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        i((String) r100.next());
        goto L4
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        f();
    }

    public BridgeContextService(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
        this.f85008a = new LinkedHashSet();
    }

    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f85008a.remove(r100);
        OpenPlatformContext r101 = getOpenPlatformContext();
        if (r101 == null) goto L9;
        MiniAppInstance r102 = ((MiniAppContext) r101).getMiniAppInstance();
        if (r102 == null) goto L10;
        r102.unregisterEventListener(r100);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext");
    }

    public static void g(BridgeContextService r100, String r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "command");
        OpenPlatformContext r102 = r100.getOpenPlatformContext();
        if (r102 == null) goto L9;
        MiniAppInstance r103 = ((MiniAppContext) r102).getMiniAppInstance();
        if (r103 == null) goto L10;
        r103.executeCommand(r101, null);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext");
    }

    public final void h(String r100, IEventListener r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f85008a.add(r100);
        OpenPlatformContext r102 = getOpenPlatformContext();
        if (r102 == null) goto L9;
        MiniAppInstance r103 = ((MiniAppContext) r102).getMiniAppInstance();
        if (r103 == null) goto L10;
        r103.registerEventListener(r100, r101);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext");
    }
}
