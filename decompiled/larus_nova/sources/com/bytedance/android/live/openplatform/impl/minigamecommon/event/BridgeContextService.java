package com.bytedance.android.live.openplatform.impl.minigamecommon.event;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.livehostapi.business.depend.openplatform.IEventListener;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigamecommon/event/BridgeContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BridgeContextService extends OpenPlatformContextService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f85363a;

    public final void f() {
        Iterator r100 = CollectionsKt.toList(this.f85363a).iterator();
    L4:
        if (r100.hasNext() == false) goto L12;
        String r101 = (String) r100.next();
        Intrinsics.checkNotNullParameter(r101, "event");
        this.f85363a.remove(r101);
        OpenPlatformContext r102 = getOpenPlatformContext();
        if (r102 == null) goto L11;
        MiniAppInstance r103 = ((MiniGameContext) r102).getMiniGameInstance();
        if (r103 == null) goto L4;
        r103.unregisterEventListener(r101);
        goto L4
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext");
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        f();
    }

    public BridgeContextService(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
        this.f85363a = new LinkedHashSet();
    }

    public final void g(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "command");
        OpenPlatformContext r102 = getOpenPlatformContext();
        if (r102 == null) goto L9;
        MiniAppInstance r103 = ((MiniGameContext) r102).getMiniGameInstance();
        if (r103 == null) goto L10;
        r103.executeCommand(r100, r101);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext");
    }

    public final void h(String r100, IEventListener r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f85363a.add(r100);
        OpenPlatformContext r102 = getOpenPlatformContext();
        if (r102 == null) goto L9;
        MiniAppInstance r103 = ((MiniGameContext) r102).getMiniGameInstance();
        if (r103 == null) goto L10;
        r103.registerEventListener(r100, r101);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext");
    }
}
