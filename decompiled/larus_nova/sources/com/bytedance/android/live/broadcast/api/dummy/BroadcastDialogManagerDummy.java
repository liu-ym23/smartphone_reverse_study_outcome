package com.bytedance.android.live.broadcast.api.dummy;

import android.app.Dialog;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.broadcast.api.IBroadcastDialogManager;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/dummy/BroadcastDialogManagerDummy;", "Lcom/bytedance/android/live/broadcast/api/IBroadcastDialogManager;", "()V", "addDialogToMananger", "", "dialog", "Landroid/app/Dialog;", "addToShow", "type", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "promoteTasks", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BroadcastDialogManagerDummy implements IBroadcastDialogManager {
    @Override // com.bytedance.android.live.broadcast.api.IBroadcastDialogManager
    public void addDialogToMananger(Dialog r100) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastDialogManager
    public void addToShow(int r100, LifecycleOwner r101, Observer<Integer> r102) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastDialogManager
    public void promoteTasks() {
    }

    public BroadcastDialogManagerDummy() {
        k.l(IBroadcastDialogManager.class, this);
    }
}
