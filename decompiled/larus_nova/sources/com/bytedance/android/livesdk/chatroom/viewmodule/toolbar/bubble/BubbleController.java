package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.utils.MorePanelBubbleAlog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class BubbleController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f115770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f115771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f115772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f115773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BubbleEnv f115774e;

    public final List<? extends h> a() {
        return (List) this.f115771b.getValue();
    }

    public final void b() {
        if (this.f115774e.a().d() == false) goto L6;
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r100 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r100.d(this.f115770a);
        r100.c("受频控影响无法加载气泡");
        MorePanelBubbleAlog.a(r100.b());
        return;
    L6:
        Function0<Unit> r101 = new BubbleController$onLoad$2(this);
        RoomContext r102 = this.f115774e.f115776b;
        if (r102 == null) goto L21;
        n<Room> r103 = r102.getInteractionDataPrepared();
        if (r103 == null) goto L21;
        if (r103.getValue() == null) goto L14;
        r101.invoke();
        return;
    L14:
        Observable<sh6.b<Room>> r104 = r103.a();
        if (r104 == null) goto L24;
        Observable r105 = RxUtilKt.h(r104);
        if (r105 == null) goto L25;
        Disposable r106 = r105.subscribe(new f(r101));
        if (r106 == null) goto L26;
        RxUtilKt.c(r106, this.f115773d);
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L21:
        r101.invoke();
    }

    public BubbleController(BubbleEnv r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        this.f115774e = r100;
        this.f115770a = "BubbleController";
        this.f115771b = LazyKt.lazy(new BubbleController$bubbleLoaders$2(this));
        this.f115772c = LazyKt.lazy(new BubbleController$interceptors$2(this));
        this.f115773d = new CompositeDisposable();
    }
}
