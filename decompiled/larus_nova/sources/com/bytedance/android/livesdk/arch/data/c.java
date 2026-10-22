package com.bytedance.android.livesdk.arch.data;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f103790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MiddlewareRoomContext f103791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IRoom f103792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataCenter f103793d;

    public abstract c b();

    public final z51.e<ne1.d> c() {
        com.bytedance.android.livesdk.arch.context.a.C1567a r100 = com.bytedance.android.livesdk.arch.context.a.K0;
        MiddlewareRoomContext r101 = this.f103791b;
        DataCenter r102 = this.f103793d;
        r100.getClass();
        com.bytedance.android.livesdk.arch.context.a r103 = com.bytedance.android.livesdk.arch.context.a.C1567a.a(r101, r102);
        if (r103 == null) goto L9;
        me1.a r104 = r103.stateDispatcher();
        if (r104 == null) goto L9;
        z51.e<ne1.d> r105 = r104.a();
        if (r105 == null) goto L9;
        int r106 = me1.a.f513447a;
        return r105;
    L9:
        return null;
    }

    public final boolean d() {
        DataCenter r100 = this.f103793d;
        if (r100 == null) goto L7;
        Boolean r101 = (Boolean) r100.get("data_is_portrait", Boolean.TRUE);
        if (r101 == null) goto L7;
        return r101.booleanValue();
    L7:
        return true;
    }

    public final Context getContext() {
        return this.f103790a;
    }

    public final <T extends c> T a(Function1<? super T, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "afterPs");
        c r101 = b();
        if (r101 == null) goto L7;
        r100.invoke(r101);
        return r101;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type T");
    }

    public c(Context r100, MiddlewareRoomContext r101, IRoom r102, DataCenter r103) {
        this.f103790a = r100;
        this.f103791b = r101;
        this.f103792c = r102;
        this.f103793d = r103;
    }
}
