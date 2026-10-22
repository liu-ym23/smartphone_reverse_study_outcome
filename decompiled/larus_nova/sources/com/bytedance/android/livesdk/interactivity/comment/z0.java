package com.bytedance.android.livesdk.interactivity.comment;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class z0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentWidget f136305a;

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.livesdk.interactivity.comment.x0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.android.livesdk.interactivity.comment.y0, java.lang.Object] */
    public final void a() {
        Long r100 = com.bytedance.android.livesdk.interactivity.comment.utils.e.f136256a;
        DataCenter r101 = this.f136305a.dataCenter;
        ?? r102 = new x0(this);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "hint");
        MiddlewareRoomContext.a r103 = MiddlewareRoomContext.Companion;
        MiddlewareRoomContext r104 = MiddlewareRoomContext.a.c(r103, r101, 0, 2);
        if (r104 == null) goto L5;
        int r105 = r104.hashCode();
    L7:
        if (com.bytedance.android.livesdk.interactivity.comment.utils.e.f136257b == r105) goto L16;
        Disposable r106 = Observable.timer(com.bytedance.android.livesdk.interactivity.comment.utils.e.f136256a.longValue(), TimeUnit.MILLISECONDS).subscribe(new com.bytedance.android.livesdk.interactivity.comment.utils.c(r102, r105), RxUtil.getNoOp());
        MiddlewareRoomContext r107 = MiddlewareRoomContext.a.c(r103, r101, 0, 2);
        if (r107 == null) goto L16;
        com.bytedance.live.datacontext.i<CompositeDisposable> r108 = r107.getCompositeDisposable();
        if (r108 == null) goto L16;
        CompositeDisposable r109 = r108.getValue();
        if (r109 == null) goto L16;
        r109.add(r106);
    L16:
        DataCenter r110 = this.f136305a.dataCenter;
        ?? r111 = new y0(this);
        Intrinsics.checkNotNullParameter(r110, "dataCenter");
        Intrinsics.checkNotNullParameter(r111, "hint");
        Disposable r112 = Observable.timer(com.bytedance.android.livesdk.interactivity.comment.utils.e.f136256a.longValue(), TimeUnit.MILLISECONDS).subscribe(new com.bytedance.android.livesdk.interactivity.comment.utils.d(r111), RxUtil.getNoOp());
        MiddlewareRoomContext r113 = MiddlewareRoomContext.a.c(r103, r110, 0, 2);
        if (r113 == null) goto L24;
        com.bytedance.live.datacontext.i<CompositeDisposable> r114 = r113.getCompositeDisposable();
        if (r114 == null) goto L25;
        CompositeDisposable r115 = r114.getValue();
        if (r115 == null) goto L26;
        r115.add(r112);
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r105 = 0;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public z0(CommentWidget r100) {
        this.f136305a = r100;
    }
}
