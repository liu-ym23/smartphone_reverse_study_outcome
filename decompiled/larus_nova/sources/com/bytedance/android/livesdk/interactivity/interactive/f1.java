package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f137408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f137409b;

    public f1(Function1 r100, Function2 r101) {
        this.f137408a = r100;
        this.f137409b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        c1 r102 = (c1) r101.data;
        if (r102 == null) goto L7;
        boolean r103 = true;
        if (r102.b() != true) goto L7;
    L8:
        String r104 = null;
        if (r103 == false) goto L14;
        Function1 r105 = this.f137408a;
        c1 r106 = (c1) r101.data;
        if (r106 == null) goto L13;
        r104 = r106.a();
    L13:
        r105.invoke(r104);
        f2.c("发布成功", 0);
        return;
    L14:
        this.f137409b.invoke(0, "发布失败");
        RequestError r107 = r101.error;
        if (r107 == null) goto L17;
        r104 = r107.prompts;
    L17:
        f2.c(r104, 0);
        int r108 = h1.f137415a;
        Intrinsics.checkNotNullParameter("send comment failed, status code = 200, success = false}", "msg");
        ALogger.i("VSMsgBoard", "send comment failed, status code = 200, success = false}");
        return;
    L7:
        r103 = false;
        goto L8
    }
}
