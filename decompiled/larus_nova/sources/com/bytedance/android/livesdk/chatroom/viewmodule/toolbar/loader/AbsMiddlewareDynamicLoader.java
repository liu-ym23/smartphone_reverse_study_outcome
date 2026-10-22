package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0002¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsMiddlewareDynamicLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/data/g$c;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/a2;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsMiddlewareDynamicLoader implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c<a2>, Observer<KVData>, a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f116377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LiveMode f116378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f116379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f116380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IRoom f116381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f116382f;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public boolean b() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public void d() {
    }

    public void e(KVData r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public void onLoad() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public void onUnLoad() {
        this.f116377a.removeObserver(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2
    public String debugName() {
        return getClass().getSimpleName();
    }

    public AbsMiddlewareDynamicLoader(e r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        this.f116382f = r100;
        DataCenter r101 = r100.f116472a;
        this.f116377a = r101;
        this.f116380d = true;
        this.f116378b = (LiveMode) r101.get("data_live_mode", LiveMode.VIDEO);
        this.f116379c = ((Boolean) r101.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.f116380d = ((Boolean) r101.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        this.f116381e = (IRoom) r101.get("data_room");
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r100) {
        e((KVData) r100);
    }
}
