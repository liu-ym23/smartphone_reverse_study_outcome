package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.KVData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsMiddlewareDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsDynamicLoader extends AbsMiddlewareDynamicLoader {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Room f116376g;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public boolean b() {
        return !(this instanceof NewClearScreenDynamicLoader);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public void d() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader
    public void e(KVData r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public void onLoad() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public void onUnLoad() {
        this.f116377a.removeObserver(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2
    public final String debugName() {
        return getClass().getSimpleName();
    }

    public AbsDynamicLoader(e r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        super(r100);
        this.f116376g = (Room) this.f116377a.get("data_room");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, androidx.lifecycle.Observer
    public /* bridge */ /* synthetic */ void onChanged(Object r100) {
        e((KVData) r100);
    }
}
