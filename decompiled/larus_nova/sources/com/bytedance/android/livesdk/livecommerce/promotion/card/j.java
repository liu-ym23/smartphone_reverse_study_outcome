package com.bytedance.android.livesdk.livecommerce.promotion.card;

import com.ss.android.cert.manager.constants.EventConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<PromotionCardModuleName, IPromotionUIConfig.d> f150062a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public IPromotionUIConfig.c f150063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f150064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public IPromotionUIConfig.b f150065c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final j f150066d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PromotionCardModuleName f150067e;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotion.card.j$a$a, reason: collision with other inner class name */
        public static final class C2318a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f150068a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public float[] f150069b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public float f150070c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f150071d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f150072e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public String f150073f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public float f150074g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public float f150075h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final a f150076i;

            public C2318a(a r100, IPromotionUIConfig.b r101) {
                Intrinsics.checkNotNullParameter(r100, "styleFactory");
                this.f150076i = r100;
                boolean r102 = true;
                this.f150071d = true;
                float r103 = 1.0f;
                this.f150075h = 1.0f;
                String r104 = null;
                if (r101 == null) goto L5;
                String r105 = r101.b();
            L6:
                this.f150068a = r105;
                if (r101 == null) goto L9;
                float[] r106 = r101.i();
            L10:
                this.f150069b = r106;
                float r107 = 0.0f;
                if (r101 == null) goto L13;
                float r108 = r101.e();
            L14:
                this.f150070c = r108;
                if (r101 == null) goto L17;
                r102 = r101.f();
            L17:
                this.f150071d = r102;
                if (r101 == null) goto L20;
                int r109 = r101.g();
            L21:
                this.f150072e = r109;
                if (r101 == null) goto L24;
                r104 = r101.d();
            L24:
                this.f150073f = r104;
                if (r101 == null) goto L27;
                r107 = r101.h();
            L27:
                this.f150074g = r107;
                if (r101 == null) goto L30;
                r103 = r101.c();
            L30:
                this.f150075h = r103;
                return;
            L20:
                r109 = 0;
                goto L21
            L13:
                r108 = 0.0f;
                goto L14
            L9:
                r106 = null;
                goto L10
            L5:
                r105 = null;
                goto L6
            }
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f150077a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f150078b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Integer f150079c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Integer f150080d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Integer f150081e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Integer f150082f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public Integer f150083g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public Integer f150084h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public Integer f150085i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public Integer f150086j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final PromotionCardModuleName f150087k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final PromotionCardModuleName f150088l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final PromotionCardModuleName f150089m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final PromotionCardModuleName f150090n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final PromotionCardModuleName f150091o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public final PromotionCardModuleName f150092p;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            public final PromotionCardModuleName f150093q;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            public final PromotionCardModuleName f150094r;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            public final a f150095s;

            public b(a r100, IPromotionUIConfig.c r101) {
                Intrinsics.checkNotNullParameter(r100, "styleFactory");
                this.f150095s = r100;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = r101.r();
            L6:
                this.f150077a = r103;
                if (r101 == null) goto L9;
                r102 = r101.c();
            L9:
                this.f150078b = r102;
                PromotionCardModuleName r104 = null;
                if (r101 == null) goto L12;
                Integer r105 = r101.m();
            L13:
                this.f150079c = r105;
                if (r101 == null) goto L16;
                Integer r106 = r101.l();
            L17:
                this.f150080d = r106;
                if (r101 == null) goto L20;
                Integer r107 = r101.j();
            L21:
                this.f150081e = r107;
                if (r101 == null) goto L24;
                Integer r108 = r101.k();
            L25:
                this.f150082f = r108;
                if (r101 == null) goto L28;
                Integer r109 = r101.i();
            L29:
                this.f150083g = r109;
                if (r101 == null) goto L32;
                Integer r110 = r101.h();
            L33:
                this.f150084h = r110;
                if (r101 == null) goto L36;
                Integer r111 = r101.f();
            L37:
                this.f150085i = r111;
                if (r101 == null) goto L40;
                Integer r112 = r101.g();
            L41:
                this.f150086j = r112;
                if (r101 == null) goto L44;
                PromotionCardModuleName r113 = r101.d();
            L45:
                this.f150087k = r113;
                if (r101 == null) goto L48;
                PromotionCardModuleName r114 = r101.e();
            L49:
                this.f150088l = r114;
                if (r101 == null) goto L52;
                PromotionCardModuleName r115 = r101.n();
            L53:
                this.f150089m = r115;
                if (r101 == null) goto L56;
                PromotionCardModuleName r116 = r101.o();
            L57:
                this.f150090n = r116;
                if (r101 == null) goto L60;
                PromotionCardModuleName r117 = r101.q();
            L61:
                this.f150091o = r117;
                if (r101 == null) goto L64;
                PromotionCardModuleName r118 = r101.p();
            L65:
                this.f150092p = r118;
                if (r101 == null) goto L68;
                PromotionCardModuleName r119 = r101.b();
            L69:
                this.f150093q = r119;
                if (r101 == null) goto L72;
                r104 = r101.a();
            L72:
                this.f150094r = r104;
                return;
            L68:
                r119 = null;
                goto L69
            L64:
                r118 = null;
                goto L65
            L60:
                r117 = null;
                goto L61
            L56:
                r116 = null;
                goto L57
            L52:
                r115 = null;
                goto L53
            L48:
                r114 = null;
                goto L49
            L44:
                r113 = null;
                goto L45
            L40:
                r112 = null;
                goto L41
            L36:
                r111 = null;
                goto L37
            L32:
                r110 = null;
                goto L33
            L28:
                r109 = null;
                goto L29
            L24:
                r108 = null;
                goto L25
            L20:
                r107 = null;
                goto L21
            L16:
                r106 = null;
                goto L17
            L12:
                r105 = null;
                goto L13
            L5:
                r103 = 0;
                goto L6
            }
        }

        public final void a(Function1 r110) {
            Intrinsics.checkNotNullParameter(r110, "factory");
            C2318a r100 = new C2318a(this, this.f150065c);
            r110.invoke(r100);
            a r111 = r100.f150076i;
            r111.f150065c = new IPromotionUIConfig.b(r100.f150068a, r100.f150069b, r100.f150070c, r100.f150071d, r100.f150072e, r100.f150073f, r100.f150074g, r100.f150075h);
        }

        public final void b(Function1 r210) {
            Intrinsics.checkNotNullParameter(r210, "factory");
            b r100 = new b(this, this.f150063a);
            r210.invoke(r100);
            a r101 = r100.f150095s;
            r101.f150063a = new IPromotionUIConfig.c(r100.f150077a, r100.f150078b, r100.f150079c, r100.f150080d, r100.f150081e, r100.f150082f, r100.f150083g, r100.f150084h, r100.f150085i, r100.f150086j, r100.f150087k, r100.f150088l, r100.f150089m, r100.f150090n, r100.f150091o, r100.f150092p, r100.f150093q, r100.f150094r);
        }

        public a(j r100, PromotionCardModuleName r101, IPromotionUIConfig.d r102) {
            Intrinsics.checkNotNullParameter(r100, "configFactory");
            Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
            this.f150066d = r100;
            this.f150067e = r101;
            int r103 = -1;
            this.f150064b = -1;
            IPromotionUIConfig.b r104 = null;
            if (r102 == null) goto L5;
            IPromotionUIConfig.c r105 = r102.b();
        L6:
            this.f150063a = r105;
            if (r102 == null) goto L9;
            r103 = r102.c();
        L9:
            this.f150064b = r103;
            if (r102 == null) goto L12;
            r104 = r102.a();
        L12:
            this.f150065c = r104;
            return;
        L5:
            r105 = null;
            goto L6
        }
    }

    public j(Map<PromotionCardModuleName, IPromotionUIConfig.d> r100) {
        HashMap<PromotionCardModuleName, IPromotionUIConfig.d> r101 = new HashMap();
        this.f150062a = r101;
        if (r100 == null) goto L6;
        r101.putAll(r100);
        return;
    }

    public final j a(PromotionCardModuleName r100, Function1<? super a, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r101, "factory");
        a r102 = new a(this, r100, this.f150062a.get(r100));
        r101.invoke(r102);
        j r103 = r102.f150066d;
        PromotionCardModuleName r104 = r102.f150067e;
        IPromotionUIConfig.d r105 = new IPromotionUIConfig.d(r102.f150065c, r102.f150064b, r102.f150063a);
        r103.f150062a.put(r104, r105);
        return r102.f150066d;
    }
}
