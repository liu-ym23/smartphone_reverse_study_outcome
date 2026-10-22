package com.bytedance.android.live.revlink.impl.control.dialog;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: classes47.dex */
public interface r {
    void F4(boolean r100);

    void dismiss();

    IRoom getCurrentRoom();

    LifecycleOwner getLifecycleOwner();

    int s9();

    void so();

    void v0();

    void zD(RevInteractDialogFragmentBaseContract$View r100);
}
