package com.bytedance.android.live.room.share.jsbridge;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.model.ShareReportResult;

/* JADX INFO: loaded from: classes47.dex */
public final class f<T> implements sy.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f100294a = null;

    static {
        f100294a = new f();
    }

    public f() {
    }

    @Override // sy.a
    public final void invoke(Object r100) {
        Response r101 = (Response) r100;
        if (r101 == null) goto L5;
        ShareReportResult r102 = (ShareReportResult) r101.data;
    L6:
        if (r102 == null) goto L15;
        ShareReportResult r103 = (ShareReportResult) r101.data;
        if (r103 == null) goto L10;
        long r104 = r103.getDeltaIntimacy();
    L12:
        if (r104 <= 0) goto L16;
        xs2.b.a().post(new b30.e((ShareReportResult) r101.data));
        return;
    L16:
        return;
    L10:
        r104 = 0;
        goto L12
    L15:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
