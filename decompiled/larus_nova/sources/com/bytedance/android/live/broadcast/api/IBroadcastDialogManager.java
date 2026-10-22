package com.bytedance.android.live.broadcast.api;

import android.app.Dialog;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes45.dex */
@ServiceLookup("com.bytedance.android.live.broadcast.viewmodel.dialog.BroadcastDialogManager")
@ServiceDummyLookup("com.bytedance.android.live.broadcast.api.dummy.BroadcastDialogManagerDummy")
public interface IBroadcastDialogManager extends IService {
    void addDialogToMananger(Dialog r100);

    void addToShow(int r100, LifecycleOwner r101, Observer<Integer> r102);

    void promoteTasks();
}
