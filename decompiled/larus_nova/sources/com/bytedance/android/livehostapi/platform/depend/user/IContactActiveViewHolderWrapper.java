package com.bytedance.android.livehostapi.platform.depend.user;

import com.bytedance.android.live.base.model.user.f;

/* JADX INFO: loaded from: classes7.dex */
public interface IContactActiveViewHolderWrapper {

    public interface IContactActiveCallback {
        void onActiveChanged(boolean r100);
    }

    void observeAndUpdateActiveStatus(f r100, IContactActiveCallback r101);
}
