package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.trigger;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.TriggerKey;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.c;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.d;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.revenue.platform.api.core.rx.f;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class TopicDismissTrigger extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TriggerKey f133459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f133460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f133461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f133462g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f133463h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f133464i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f133465j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Disposable f133466k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DataCenter f133467l;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TopicDismissTrigger f133468a;

        public a(TopicDismissTrigger r100) {
            this.f133468a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            TopicDismissTrigger r102 = this.f133468a;
            m.a r103 = r102.f133434a;
            if (r103 == null) goto L6;
            r103.a(r102.f());
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TopicDismissTrigger f133469a;

        public b(TopicDismissTrigger r100) {
            this.f133469a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Integer r101 = (Integer) r100;
            ALogger.i(this.f133469a.f133463h, "监听到用户发评行为");
            TopicDismissTrigger r102 = this.f133469a;
            if (r102.f133464i == true) goto L5;
            return;
        L5:
            if (r102.f133465j == true) goto L21;
            ALogger.i(r102.f133463h, "监听到点击后发评行为，创建三阶定时器");
            TopicDismissTrigger r103 = this.f133469a;
            String r104 = r103.c(r103.f133462g);
            if (r104 == null) goto L22;
            Long r105 = StringsKt.toLongOrNull(r104);
            if (r105 != null) goto L11;
            return;
        L11:
            if (r105.longValue() <= 0) goto L13;
            boolean r106 = true;
        L14:
            if (r106 == true) goto L17;
            r105 = null;
        L17:
            if (r105 == null) goto L24;
            long r107 = r105.longValue();
            this.f133469a.e(r107);
            this.f133469a.f133465j = true;
            return;
        L24:
            return;
        L13:
            r106 = false;
            goto L14
        L22:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.d
    public final void d() {
        String r100 = c(this.f133460e);
        if (r100 == null) goto L15;
        Long r101 = StringsKt.toLongOrNull(r100);
        if (r101 == null) goto L15;
        if (r101.longValue() <= 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L13;
        r101 = null;
    L13:
        if (r101 == null) goto L15;
        long r103 = r101.longValue();
        ALogger.i(this.f133463h, "创建无点击退场计时器");
        e(r103);
        goto L15
    L9:
        r102 = false;
    L15:
        Function1<q42.a, Unit> r104 = new TopicDismissTrigger$onStart$3(this);
        Intrinsics.checkNotNullParameter(q42.a.class, "event");
        Intrinsics.checkNotNullParameter(r104, "onEvent");
        Disposable r105 = xs2.b.a().b(q42.a.class).subscribe(new c(r104));
        f.a(r105, this.f133436c);
        RxUtilKt.c(r105, this.f133436c);
        h r106 = i.b(this.f133467l, 1);
        if (r106 == null) goto L27;
        com.bytedance.live.datacontext.m<Integer> r107 = r106.getSendCommentCount();
        if (r107 == null) goto L28;
        Observable<Integer> r108 = r107.a();
        if (r108 == null) goto L29;
        Observable<Integer> r109 = r108.observeOn(AndroidSchedulers.mainThread());
        if (r109 == null) goto L30;
        Disposable r110 = r109.subscribe(new b(this));
        if (r110 == null) goto L31;
        RxUtilKt.c(r110, this.f133436c);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.d, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m
    public final void release() {
        super.release();
        Disposable r100 = this.f133466k;
        if (r100 != null) goto L5;
    L10:
        this.f133466k = null;
        return;
    L5:
        if ((!r100.isDisposed()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r100.dispose();
        goto L10
    }

    public final TriggerKey f() {
        return this.f133459d;
    }

    public TopicDismissTrigger(DataCenter r100) {
        this.f133467l = r100;
        this.f133459d = TriggerKey.TopicDismiss;
        this.f133460e = "no_click_time_ms";
        this.f133461f = "no_comment_time_ms";
        this.f133462g = "after_comment_ms";
        this.f133463h = "TopicDismissTrigger";
    }

    public final void e(long r100) {
        Disposable r101 = this.f133466k;
        if (r101 != null) goto L5;
    L10:
        this.f133466k = null;
        ALogger.i(this.f133463h, "计时器创建成功，时长:" + r100 + " 毫秒");
        this.f133466k = Observable.timer(r100, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        return;
    L5:
        if ((!r101.isDisposed()) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L10;
        r101.dispose();
        goto L10
    }
}
