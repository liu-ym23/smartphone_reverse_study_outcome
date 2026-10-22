package com.bytedance.android.live.room.api.messagewindow.builder.card;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.messagewindow.anim.CardAnimType;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class CommonCardBuilder implements u61.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f98942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super d, Unit> f98943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super b, Unit> f98944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super a, Unit> f98945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super c, Unit> f98946e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function1<? super CardAnimType, Unit> f98947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function1<? super CardAnimType, Unit> f98948b;

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function1<? super p71.a, Unit> f98949a;

        public b() {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function1<? super b71.a, Unit> f98950a;

        public c() {
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function0<Unit> f98951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function0<Unit> f98952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Function0<Unit> f98953c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Function0<Unit> f98954d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Function0<Unit> f98955e;

        public d() {
        }
    }

    public final com.bytedance.android.live.room.api.messagewindow.builder.card.c b() {
        if (this.f98942a != 0) goto L5;
        ALogger.e("CommonCardBuilder", "the value of type can't be 0");
    L5:
        int r100 = this.f98942a;
        b r101 = new b();
        this.f98944c.invoke(r101);
        a r102 = new a();
        this.f98945d.invoke(r102);
        d r103 = new d();
        this.f98943b.invoke(r103);
        c r104 = new c();
        this.f98946e.invoke(r104);
        return new com.bytedance.android.live.room.api.messagewindow.builder.card.c(new com.bytedance.android.live.room.api.messagewindow.builder.card.b(r100, r101, r102, r103, r104));
    }

    public CommonCardBuilder() {
        this.f98943b = CommonCardBuilder$lifeCycleCallback$1.INSTANCE;
        this.f98944c = CommonCardBuilder$failCallback$1.INSTANCE;
        this.f98945d = CommonCardBuilder$animCallback$1.INSTANCE;
        this.f98946e = CommonCardBuilder$hideReasonCallback$1.INSTANCE;
    }

    @Override // u61.b
    public final CommonCardBuilder a(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        r100.invoke(this);
        return this;
    }

    public final void c(Function1<? super b, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f98944c = r100;
    }
}
