package com.bytedance.android.livesdkapi.room.handler.viewinterface;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/ILivePlayFragmentCreatedEnv;", "", "getToolbarHandler", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IToolbarHandler;", "key", "", "registerToolbarHandler", "", "handler", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayFragmentCreatedEnv {
    IToolbarHandler getToolbarHandler(String r100);

    void registerToolbarHandler(String r100, IToolbarHandler r101);
}
