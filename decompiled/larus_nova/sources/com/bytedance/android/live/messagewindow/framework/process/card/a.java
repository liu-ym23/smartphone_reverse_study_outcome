package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.common.wschannel.WsConstants;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a implements h71.f<com.bytedance.android.live.messagewindow.framework.process.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> f83169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PropertyOwner<c> f83170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PropertyOwner f83171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f83172d;

    /* JADX INFO: renamed from: com.bytedance.android.live.messagewindow.framework.process.card.a$a, reason: collision with other inner class name */
    public static final class C1267a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f83173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f83174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public p71.a f83175c;

        /* JADX INFO: renamed from: com.bytedance.android.live.messagewindow.framework.process.card.a$b$a, reason: collision with other inner class name */
        public static final class C1268a {
        }

        static {
            new b();
        }

        public b() {
            LinkedHashMap r100 = new LinkedHashMap();
            this.f83173a = r100;
            this.f83174b = r100;
        }

        public final void a(Pair... r100) {
            Intrinsics.checkNotNullParameter(r100, "pairs");
            MapsKt.putAll(this.f83173a, r100);
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f83176a;

        /* JADX INFO: renamed from: com.bytedance.android.live.messagewindow.framework.process.card.a$c$a, reason: collision with other inner class name */
        public static final class C1269a extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C1269a f83177b = null;

            public C1269a() {
                super(3);
            }

            static {
                f83177b = new C1269a();
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final b f83178b = null;

            public b() {
                super(2);
            }

            static {
                f83178b = new b();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.messagewindow.framework.process.card.a$c$c, reason: collision with other inner class name */
        public static final class C1270c extends f {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final b f83179c;

            @Override // com.bytedance.android.live.messagewindow.framework.process.card.a.c.f
            public final b a() {
                return this.f83179c;
            }

            public C1270c(b r100) {
                Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
                super(r100);
                this.f83179c = r100;
            }
        }

        public static final class d extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final d f83180b = null;

            public d() {
                super(-1);
            }

            static {
                f83180b = new d();
            }
        }

        public static final class e extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final e f83181b = null;

            public e() {
                super(1);
            }

            static {
                f83181b = new e();
            }
        }

        public static class f extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final b f83182b;

            public b a() {
                return this.f83182b;
            }

            public f(b r100) {
                Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
                super(2);
                this.f83182b = r100;
            }
        }

        public c(int r100) {
            this.f83176a = r100;
        }
    }

    static {
    }

    public abstract CardPsId b();

    public abstract void d(h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> r100);

    public final void e() {
        c(c.C1269a.f83177b);
        h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> r100 = this.f83169a;
        if (r100 == null) goto L5;
        r100.a(r100.d());
    L5:
        Disposable r101 = this.f83172d;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }

    public a() {
        PropertyOwner<c> r100 = new PropertyOwner(c.d.f83180b);
        this.f83170b = r100;
        this.f83171c = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h71.f
    public final void a(hm0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        this.f83169a = r100;
        com.bytedance.android.live.messagewindow.framework.process.a r101 = (com.bytedance.android.live.messagewindow.framework.process.a) r100.f485711a;
        c(c.e.f83181b);
        com.bytedance.android.live.room.api.messagewindow.monitor.i r102 = r101.f83133b.monitor();
        if (r102 == null) goto L6;
        CardAlogParamsBuilder r103 = new CardAlogParamsBuilder();
        r103.c("当前节点：" + b().name());
        Unit r104 = Unit.INSTANCE;
        r102.d(r103.b());
    L6:
        im0.a r105 = r101.f83132a;
        if (r105 == null) goto L23;
        Intrinsics.checkNotNullParameter(3, "state");
        if (Intrinsics.areEqual(3, r105.f83198b.f64752a) != true) goto L23;
        String r106 = b().name() + " process fail because the action is finish";
        if (r102 == null) goto L20;
        CardAlogParamsBuilder r107 = new CardAlogParamsBuilder();
        r107.c(r106);
        im0.a r108 = r101.f83132a;
        if (r108 == null) goto L18;
        Object r109 = r108.f83199c;
        if (r109 == null) goto L18;
    L19:
        r107.a("cmd", r109);
        Unit r110 = Unit.INSTANCE;
        r102.d(r107.b());
    L18:
        r109 = "unknown";
    L20:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r111 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_processor_handle_fail");
        r111.f99012b = 1000;
        r111.b(r106);
        com.bytedance.android.live.room.api.messagewindow.monitor.i r112 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r112 == null) goto L25;
        r112.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r111));
        return;
    L25:
        return;
    L23:
        d(r100);
    }

    public final void c(c r100) {
        Intrinsics.checkNotNullParameter(r100, "newState");
        this.f83170b.a(r100);
        if (r100.f83176a != 3) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        this.f83170b.onComplete();
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void f(Function1<? super b, Unit> r100) {
        if (r100 == null) goto L4;
        b r101 = new b();
        r100.invoke(r101);
        c r102 = new c.C1270c(r101);
    L5:
        c(r102);
        return;
    L4:
        r102 = c.b.f83178b;
        goto L5
    }
}
