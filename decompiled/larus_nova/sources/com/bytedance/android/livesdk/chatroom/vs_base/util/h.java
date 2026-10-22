package com.bytedance.android.livesdk.chatroom.vs_base.util;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IRoom f118195a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Episode f118196b = null;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f118197a;

        public a(Function0 r100) {
            this.f118197a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            this.f118197a.invoke();
        }
    }

    static {
        f118195a = (IRoom) vh7.f.c(IRoom.class);
        f118196b = new Episode();
    }

    public static final Episode a(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$episode");
        return (Episode) r100.get("data_vs_episode_data", f118196b);
    }

    public static final boolean c(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMergeVSRoom");
        return e(r100).isMergeVSRoom();
    }

    public static final IRoom e(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$room");
        return (IRoom) r100.get("data_room", f118195a);
    }

    public static final Episode g(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$vsCompatRoomSafety");
        return (Episode) r100.get("data_vs_episode_data", null);
    }

    public static final Disposable b(DataCenter r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        vr1.u r102 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r100, null, 2);
        if (r102 != null) goto L5;
        return null;
    L5:
        com.bytedance.live.datacontext.n<?> r103 = r102.g();
        if (r103 == null) goto L8;
        Object r104 = r103.getValue();
    L9:
        if (r104 == null) goto L11;
        r101.invoke();
        return null;
    L11:
        r101.invoke();
        com.bytedance.live.datacontext.n<?> r105 = r102.g();
        if (r105 == null) goto L18;
        Observable<sh6.b<?>> r106 = r105.a();
        if (r106 != null) goto L16;
        return null;
    L16:
        return r106.subscribe(new a(r101));
    L18:
        return null;
    L8:
        r104 = null;
        goto L9
    }

    public static final boolean d(DataCenter r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$isPortrait");
        return ((Boolean) r100.get("data_is_portrait", Boolean.valueOf(r101))).booleanValue();
    }

    public static final void f(DataCenter r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        Object r102 = null;
        vr1.u r103 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r100, null, 2);
        if (r103 != null) goto L5;
        return;
    L5:
        com.bytedance.live.datacontext.n<?> r104 = r103.g();
        if (r104 == null) goto L8;
        r102 = r104.getValue();
    L8:
        if (r102 == null) goto L10;
        r101.invoke();
        return;
    L10:
        com.bytedance.live.datacontext.n<?> r105 = r103.g();
        if (r105 == null) goto L17;
        Observable<sh6.b<?>> r106 = r105.a();
        if (r106 == null) goto L18;
        r106.subscribe(new i(r101));
        return;
    L18:
        return;
    }
}
