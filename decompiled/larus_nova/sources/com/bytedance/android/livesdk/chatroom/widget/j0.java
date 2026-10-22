package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.livesdk.chatroom.progressbar.IProgressCastService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public interface j0 {
    void a(ILivePlayerClient r100, String r101, NextLiveData<Boolean> r102, Map<String, String> r103, DataCenter r104);

    String c(DataCenter r100);

    boolean d(DataCenter r100);

    boolean e(DataCenter r100);

    NextLiveData<Boolean> f(DataCenter r100);

    boolean g(DataCenter r100);

    ILivePlayerClient getLivePlayerClient();

    IProgressCastService h();

    NextLiveData<Boolean> i(DataCenter r100);

    void j(DataCenter r100);
}
