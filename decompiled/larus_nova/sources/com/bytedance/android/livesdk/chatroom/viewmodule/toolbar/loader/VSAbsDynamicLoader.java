package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.KVData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/VSAbsDynamicLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsMiddlewareDynamicLoader;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class VSAbsDynamicLoader extends AbsMiddlewareDynamicLoader {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IRoom f116466g;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final boolean b() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader
    public final void e(KVData r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onUnLoad() {
        this.f116377a.removeObserver(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2
    public final String debugName() {
        return getClass().getSimpleName();
    }

    public VSAbsDynamicLoader(e r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        super(r100);
        this.f116466g = lu2.c.f(this.f116377a);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
    }
}
