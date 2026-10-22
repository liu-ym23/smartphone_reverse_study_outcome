package com.bytedance.android.livesdk.live.listprovider;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f147558a;

    public b(String r100) {
        this.f147558a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Logger.d("DrawRoomListProvider", "tryUploadUnreadRoomByPull Collecting unread room result, extra: " + this.f147558a + ", statusCode: " + ((Response) r100).statusCode + '.');
    }
}
