package com.bytedance.android.live.base.model.push;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class LivePushInfo {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f58904e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.base.model.push.b f58905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f58906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InnerPushCallback f58907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f58908d;

    public static class InnerPushCallback extends b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Function1<? super e, Unit> f58909e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Function1<? super e, Unit> f58910f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Function1<? super e, Unit> f58911g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Function2<? super e, ? super Boolean, Unit> f58912h;

        @Override // com.bytedance.android.live.base.model.push.LivePushInfo.b
        public final Function1<e, Unit> a() {
            return this.f58909e;
        }

        @Override // com.bytedance.android.live.base.model.push.LivePushInfo.b
        public final Function1<e, Unit> b() {
            return this.f58911g;
        }

        @Override // com.bytedance.android.live.base.model.push.LivePushInfo.b
        public final Function2<e, Boolean, Unit> c() {
            return this.f58912h;
        }

        @Override // com.bytedance.android.live.base.model.push.LivePushInfo.b
        public final Function1<e, Unit> d() {
            return this.f58910f;
        }

        @Override // com.bytedance.android.live.base.model.push.LivePushInfo.b
        public final void e(Function1<? super e, Unit> r100) {
            this.f58909e = r100;
        }

        @Override // com.bytedance.android.live.base.model.push.LivePushInfo.b
        public final void f(Function1<? super e, Unit> r100) {
            this.f58911g = r100;
        }

        @Override // com.bytedance.android.live.base.model.push.LivePushInfo.b
        public final void g(Function2<? super e, ? super Boolean, Unit> r100) {
            this.f58912h = r100;
        }

        @Override // com.bytedance.android.live.base.model.push.LivePushInfo.b
        public final void h(Function1<? super e, Unit> r100) {
            this.f58910f = r100;
        }

        public InnerPushCallback(final b r100, final f r101) {
            this.f58909e = new LivePushInfo$InnerPushCallback$onCountdownFinish$1(r100);
            this.f58910f = new LivePushInfo$InnerPushCallback$onPushShow$1(r100, r101);
            this.f58911g = new LivePushInfo$InnerPushCallback$onPushClick$1(r100, r101);
            this.f58912h = new LivePushInfo$InnerPushCallback$onPushDismiss$1(r100);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function1<? super b, Unit> f58913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function1<? super f, Unit> f58914b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, String> f58915c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f58916d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final com.bytedance.android.live.base.model.push.b f58917e;

        public a(com.bytedance.android.live.base.model.push.b r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            this.f58917e = r100;
            LivePushViewStyle r101 = LivePushViewStyle.Normal;
            this.f58915c = new LinkedHashMap();
        }

        public final void a(Pair... r100) {
            Intrinsics.checkNotNullParameter(r100, "pairs");
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            Pair r103 = r100[r102];
            String r104 = (String) r103.getFirst();
            Object r105 = r103.getSecond();
            Intrinsics.checkNotNullParameter(r104, "key");
            this.f58915c.put(r104, String.valueOf(r105));
            r102 = r102 + 1;
            goto L3
        }

        public final void b(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            this.f58913a = r100;
        }

        public final void c(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.f58914b = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function1<? super e, Unit> f58918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function1<? super e, Unit> f58919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Function2<? super e, ? super Boolean, Unit> f58920c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Function1<? super e, Unit> f58921d;

        public b() {
        }

        public Function1<e, Unit> a() {
            return this.f58921d;
        }

        public Function1<e, Unit> b() {
            return this.f58919b;
        }

        public Function2<e, Boolean, Unit> c() {
            return this.f58920c;
        }

        public Function1<e, Unit> d() {
            return this.f58918a;
        }

        public void e(Function1<? super e, Unit> r100) {
            this.f58921d = r100;
        }

        public void f(Function1<? super e, Unit> r100) {
            this.f58919b = r100;
        }

        public void g(Function2<? super e, ? super Boolean, Unit> r100) {
            this.f58920c = r100;
        }

        public void h(Function1<? super e, Unit> r100) {
            this.f58918a = r100;
        }
    }

    public static final class c {
        public static a a(com.bytedance.android.live.base.model.push.b r100) {
            Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.PUSH_MSG);
            return new a(r100);
        }
    }

    public interface d {
        void dismiss();
    }

    public interface e {
        cv1.a getController();

        LivePushInfo getPushInfo();
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function1<? super LivePushInfo, Unit> f58922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function1<? super LivePushInfo, Unit> f58923b;

        public f() {
        }
    }

    static {
    }

    public LivePushInfo(a r100) {
        this.f58905a = r100.f58917e;
        this.f58906b = r100.f58915c;
        Function1<? super f, Unit> r101 = r100.f58914b;
        b r102 = null;
        if (r101 == null) goto L5;
        f r103 = new f();
        r101.invoke(r103);
    L6:
        Function1<? super b, Unit> r104 = r100.f58913a;
        if (r104 == null) goto L9;
        r102 = new b();
        r104.invoke(r102);
    L9:
        this.f58907c = new InnerPushCallback(r102, r103);
        this.f58908d = r100.f58916d;
        return;
    L5:
        r103 = null;
        goto L6
    }
}
