package com.bytedance.android.livesdk.chatroom.roommanage.manage.banuser;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f111450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f111451b;

    public b(f r100, Function0 r101) {
        this.f111450a = r100;
        this.f111451b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        f r102 = this.f111450a;
        int r103 = r102.f111476e - 1;
        r102.f111476e = r103;
        if (r103 < 0) goto L5;
        r102.f111481j.b(r103, r102.f111477f);
    L5:
        this.f111451b.invoke();
        this.f111450a.f111475d = false;
    }
}
