package com.bytedance.android.livesdk.chatroom.room.backend;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.xf;
import com.bytedance.android.livesdkapi.model.BackendGeneratedData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f110828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f110829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f110830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Consumer f110831d;

    public j(Class r100, long r101, boolean r102, Consumer r103) {
        this.f110828a = r100;
        this.f110829b = r101;
        this.f110830c = r102;
        this.f110831d = r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        if (r101 == null) goto L9;
        BackendGeneratedData r102 = (BackendGeneratedData) sh6.c.b(r101);
        if (r102 == null) goto L9;
        Long r103 = r102.getTypedRoomId(this.f110828a);
        if (r103 == null) goto L9;
        long r104 = r103.longValue();
    L11:
        if (xf.f121599a.getValue().booleanValue() == true) goto L13;
    L24:
        this.f110831d.accept(sh6.c.b(r101));
        return;
    L13:
        if (r104 == this.f110829b) goto L24;
        if (this.f110830c == true) goto L24;
        if (r104 == 0) goto L23;
        Class r105 = this.f110828a;
        if (r105 == null) goto L21;
        String r106 = r105.getSimpleName();
    L22:
        ALogger.i(r106, "current room: " + this.f110829b + ", observe backend data's: " + r104);
        goto L23
    L21:
        r106 = "BackendTag";
    L23:
        this.f110831d.accept(null);
        return;
    L9:
        r104 = 0;
        goto L11
    }
}
