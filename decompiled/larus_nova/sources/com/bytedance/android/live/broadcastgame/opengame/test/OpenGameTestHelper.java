package com.bytedance.android.live.broadcastgame.opengame.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.opengame.h;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.live.datacontext.k;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes45.dex */
public final class OpenGameTestHelper implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f61096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OpenGameTestFloatBall f61097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f61098c;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenGameTestHelper f61099a;

        public a(OpenGameTestHelper r100) {
            this.f61099a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Integer r101 = (Integer) r100;
            OpenGameTestHelper r102 = this.f61099a;
            View r103 = r102.f61098c;
            if (r102.f61097b != null) goto L22;
            if (r103 == null) goto L7;
            OpenGameTestFloatBall r104 = (OpenGameTestFloatBall) r103.findViewById(R.id.test_float_ball);
        L8:
            r102.f61097b = r104;
            AnchorGameContext.Companion.getClass();
            AnchorGameContext r105 = AnchorGameContext.a.a();
            if (r105 == null) goto L18;
            k<Boolean> r106 = r105.getOpenGameTestFloatBall();
            if (r106 == null) goto L19;
            PublishSubject r107 = r106.onEvent();
            if (r107 == null) goto L20;
            Disposable r108 = r107.subscribe(new b(r102));
            if (r108 == null) goto L21;
            RxUtilKt.c(r108, (CompositeDisposable) r102.f61096a.getValue());
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        L18:
            return;
        L7:
            r104 = null;
            goto L8
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.h
    public final void release() {
        ((CompositeDisposable) this.f61096a.getValue()).clear();
        OpenGameTestFloatBall r100 = this.f61097b;
        if (r100 == null) goto L6;
        r100.setGone();
        return;
    }

    public OpenGameTestHelper() {
        this.f61096a = LazyKt.lazy(OpenGameTestHelper$compositeDisposable$2.INSTANCE);
    }

    public final void a(ViewGroup r100, Context r101) {
        if (r100 == null) goto L15;
        if (r101 == null) goto L20;
        this.f61098c = LayoutInflater.from(r101).inflate(R.layout.ttlive_open_test_float_ball, r100);
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r102 = AnchorGameContext.a.a();
        if (r102 == null) goto L16;
        k<Integer> r103 = r102.getInitGameTestFloatBall();
        if (r103 == null) goto L17;
        PublishSubject r104 = r103.onEvent();
        if (r104 == null) goto L18;
        Disposable r105 = r104.subscribe(new a(this));
        if (r105 == null) goto L19;
        RxUtilKt.c(r105, (CompositeDisposable) this.f61096a.getValue());
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L20:
        return;
    }
}
