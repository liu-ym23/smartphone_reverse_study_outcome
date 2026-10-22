package com.bytedance.android.livesdk.ktvapi;

import androidx.lifecycle.ViewModelStore;
import bn0.b;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.chatroom.widget.f0;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/HolderRoomWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Lcom/bytedance/android/livesdk/chatroom/widget/f0;", "<init>", "()V", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public class HolderRoomWidget extends MiddlewareRoomWidget implements ViewModelStoreOwnerCompat, f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewModelStore f142286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f142287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Class<? extends dn0.b>, dn0.b> f142288c;

    @Override // com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat, androidx.lifecycle.ViewModelStoreOwner
    public final /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.CC.$default$getViewModelStore(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public void onDestroy() {
        this.f142286a.clear();
        super.onDestroy();
    }

    public HolderRoomWidget() {
        this.f142286a = new ViewModelStore();
        this.f142288c = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat
    public final ViewModelStore tf() {
        return this.f142286a;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.f0
    public final void setMultiLinkRoomScope(b r100) {
        this.f142287b = r100;
    }
}
