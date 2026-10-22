package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.vs.model.VSRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAppearance;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/VSOgcDynamicLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/VSAbsDynamicLoader;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSOgcDynamicLoader extends VSAbsDynamicLoader {
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        VSRoom r100 = (VSRoom) com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(this.f116382f.f116472a).castToOrNull(VSRoom.class);
        if (r100 == null) goto L25;
        IRoomAppearance r101 = r100.getAppearance();
        if (r101 == null) goto L25;
        ju2.c r102 = (ju2.c) r101.castToOrNull(ju2.c.class);
        if (r102 == null) goto L25;
        List<IVSToolbarConfigData> r103 = r102.getToolbarConfigList();
        if (r103 == null) goto L25;
        IVSToolbarConfigData r104 = (IVSToolbarConfigData) CollectionsKt.firstOrNull(r103);
        if (r104 == null) goto L23;
        HashSet r105 = new HashSet();
        k r106 = r104.getIcon();
        if (r106 == null) goto L15;
        List<String> r107 = r106.getUrls();
    L16:
        if (r107 == null) goto L21;
        if ((!r107.isEmpty()) == false) goto L21;
        r105.add(r.y().n(ToolbarButton.VS_ACTIVITY_ONE.extended(), r107));
    L21:
        return CollectionsKt.toList(r105);
    L15:
        r107 = null;
        goto L16
    L23:
        return CollectionsKt.emptyList();
    L25:
        return CollectionsKt.emptyList();
    }

    public VSOgcDynamicLoader(e r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        super(r100);
    }
}
