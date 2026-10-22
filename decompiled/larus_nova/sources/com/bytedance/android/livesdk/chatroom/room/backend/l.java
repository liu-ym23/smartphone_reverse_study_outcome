package com.bytedance.android.livesdk.chatroom.room.backend;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.xf;
import com.bytedance.android.livesdkapi.model.BackendGeneratedData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f110833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f110834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f110835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Consumer f110836d;

    public l(Class r100, long r101, boolean r102, Consumer r103) {
        this.f110833a = r100;
        this.f110834b = r101;
        this.f110835c = r102;
        this.f110836d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BackendGeneratedData r101 = (BackendGeneratedData) r100;
        if (r101 == null) goto L7;
        Long r102 = r101.getTypedRoomId(this.f110833a);
        if (r102 == null) goto L7;
        long r103 = r102.longValue();
    L9:
        if (xf.f121599a.getValue().booleanValue() == true) goto L11;
    L22:
        this.f110836d.accept(r101);
        return;
    L11:
        if (r103 == this.f110834b) goto L22;
        if (this.f110835c == true) goto L22;
        if (r103 == 0) goto L21;
        Class r104 = this.f110833a;
        if (r104 == null) goto L19;
        String r105 = r104.getSimpleName();
    L20:
        ALogger.i(r105, "current room: " + this.f110834b + ", observe backend data's: " + r103);
        goto L21
    L19:
        r105 = "BackendTag";
    L21:
        this.f110836d.accept(null);
        return;
    L7:
        r103 = 0;
        goto L9
    }
}
