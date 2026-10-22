package com.bytedance.android.livesdkapi.distribution;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u001c\u0010%\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/EnterParams;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", KtvSubElement.CONTAINER, "Landroid/widget/FrameLayout;", "roomId", "", "uniqueKey", "bundle", "Landroid/os/Bundle;", "lifecyclCallback", "Lcom/bytedance/android/livesdkapi/distribution/ILiveExternalLifecycle;", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Landroid/widget/FrameLayout;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/bytedance/android/livesdkapi/distribution/ILiveExternalLifecycle;)V", "getBundle", "()Landroid/os/Bundle;", "getContainer", "()Landroid/widget/FrameLayout;", "getContext", "()Landroid/content/Context;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "getLifecyclCallback", "()Lcom/bytedance/android/livesdkapi/distribution/ILiveExternalLifecycle;", "setLifecyclCallback", "(Lcom/bytedance/android/livesdkapi/distribution/ILiveExternalLifecycle;)V", "outRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getOutRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "setOutRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "getRoomId", "()Ljava/lang/String;", "getUniqueKey", "updatedBundle", "getUpdatedBundle", "setUpdatedBundle", "(Landroid/os/Bundle;)V", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EnterParams {
    private final Bundle bundle;
    private final FrameLayout container;
    private final Context context;
    private final FragmentManager fragmentManager;
    private ILiveExternalLifecycle lifecyclCallback;
    private IRoom outRoom;
    private final String roomId;
    private final String uniqueKey;
    private Bundle updatedBundle;

    public final Bundle getBundle() {
        return this.bundle;
    }

    public final FrameLayout getContainer() {
        return this.container;
    }

    public final Context getContext() {
        return this.context;
    }

    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public final ILiveExternalLifecycle getLifecyclCallback() {
        return this.lifecyclCallback;
    }

    public final IRoom getOutRoom() {
        return this.outRoom;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getUniqueKey() {
        return this.uniqueKey;
    }

    public final Bundle getUpdatedBundle() {
        return this.updatedBundle;
    }

    public final void setLifecyclCallback(ILiveExternalLifecycle r100) {
        this.lifecyclCallback = r100;
    }

    public final void setOutRoom(IRoom r100) {
        this.outRoom = r100;
    }

    public final void setUpdatedBundle(Bundle r100) {
        this.updatedBundle = r100;
    }

    public EnterParams(Context r100, FragmentManager r101, FrameLayout r102, String r103, String r104, Bundle r105, ILiveExternalLifecycle r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "fragmentManager");
        Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r103, "roomId");
        Intrinsics.checkNotNullParameter(r104, "uniqueKey");
        Intrinsics.checkNotNullParameter(r105, "bundle");
        this.context = r100;
        this.fragmentManager = r101;
        this.container = r102;
        this.roomId = r103;
        this.uniqueKey = r104;
        this.bundle = r105;
        this.lifecyclCallback = r106;
    }
}
