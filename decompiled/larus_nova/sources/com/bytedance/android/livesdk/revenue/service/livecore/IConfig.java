package com.bytedance.android.livesdk.revenue.service.livecore;

import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import fr2.f;
import fr2.g0;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes11.dex */
public interface IConfig {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/livecore/IConfig$IVendor;", "", "", "getName", "AGORA", "ZEGO", "BYTE", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum IVendor extends Enum<IVendor> {
        public static final IVendor AGORA = null;
        public static final IVendor BYTE = null;
        public static final IVendor ZEGO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ IVendor[] f157368a = null;

        static {
            IVendor r100 = new IVendor("AGORA", 0);
            AGORA = r100;
            IVendor r101 = new IVendor("ZEGO", 1);
            ZEGO = r101;
            IVendor r102 = new IVendor("BYTE", 2);
            BYTE = r102;
            f157368a = new IVendor[]{r100, r101, r102};
        }

        public static IVendor valueOf(String r100) {
            return (IVendor) r27.a.a(IVendor.class, r100);
        }

        public static IVendor[] values() {
            return (IVendor[]) f157368a.clone();
        }

        public final String getName() {
            int r100 = f.f478502a[ordinal()];
            if (r100 != 1) goto L5;
            return "agora";
        L5:
            if (r100 != 2) goto L7;
            return "zego";
        L7:
            if (r100 == 3) goto L9;
            return "unknown";
        L9:
            return "byte";
        }

        public IVendor(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a extends xh6.c, xh6.b {

        /* JADX INFO: renamed from: a1, reason: collision with root package name */
        public static final C2409a f157369a1 = null;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.revenue.service.livecore.IConfig$a$a, reason: collision with other inner class name */
        public static final class C2409a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f157370a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final a f157371b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final /* synthetic */ C2409a f157372c = null;

            public C2409a() {
            }

            static {
                f157372c = new C2409a();
                xh6.b r100 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(a.class), Character.ANCHOR);
                xh6.b r101 = null;
                if ((r100 instanceof a) == true) goto L5;
                r100 = null;
            L5:
                KmpEnv r102 = KmpEnv.f255139a;
                com.bytedance.live.kmp.core.b.a();
                f157370a = (a) r100;
                xh6.b r103 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(a.class), Character.GUEST);
                if ((r103 instanceof a) == false) goto L9;
                r101 = r103;
            L9:
                com.bytedance.live.kmp.core.b.a();
                f157371b = (a) r101;
            }
        }

        static {
            f157369a1 = C2409a.f157372c;
        }
    }

    public interface b extends xh6.c, xh6.b {

        /* JADX INFO: renamed from: c1, reason: collision with root package name */
        public static final a f157373c1 = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f157374a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final b f157375b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final b f157376c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final b f157377d = null;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final /* synthetic */ a f157378e = null;

            public a() {
            }

            static {
                f157378e = new a();
                xh6.b r100 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(b.class), IInteractModeEnumParam.MULTI_ANCHOR);
                xh6.b r101 = null;
                if ((r100 instanceof b) == true) goto L5;
                r100 = null;
            L5:
                KmpEnv r102 = KmpEnv.f255139a;
                com.bytedance.live.kmp.core.b.a();
                f157374a = (b) r100;
                xh6.b r103 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(b.class), IInteractModeEnumParam.PK);
                if ((r103 instanceof b) == true) goto L8;
                r103 = null;
            L8:
                com.bytedance.live.kmp.core.b.a();
                f157375b = (b) r103;
                xh6.b r104 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(b.class), IInteractModeEnumParam.GAME_AUDIO);
                if ((r104 instanceof b) == true) goto L11;
                r104 = null;
            L11:
                com.bytedance.live.kmp.core.b.a();
                f157376c = (b) r104;
                xh6.b r105 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(b.class), IInteractModeEnumParam.NORMAL);
                if ((r105 instanceof b) == false) goto L15;
                r101 = r105;
            L15:
                com.bytedance.live.kmp.core.b.a();
                f157377d = (b) r101;
            }
        }

        static {
            f157373c1 = a.f157378e;
        }
    }

    public interface c extends xh6.c, xh6.b {

        /* JADX INFO: renamed from: d1, reason: collision with root package name */
        public static final a f157379d1 = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f157380a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final c f157381b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final c f157382c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final /* synthetic */ a f157383d = null;

            public a() {
            }

            static {
                f157383d = new a();
                xh6.b r100 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(c.class), IMixStreamTypeEnumParam.SERVER_MIX);
                xh6.b r101 = null;
                if ((r100 instanceof c) == true) goto L5;
                r100 = null;
            L5:
                KmpEnv r102 = KmpEnv.f255139a;
                com.bytedance.live.kmp.core.b.a();
                f157380a = (c) r100;
                xh6.b r103 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(c.class), IMixStreamTypeEnumParam.CLIENT_MIX);
                if ((r103 instanceof c) == true) goto L8;
                r103 = null;
            L8:
                com.bytedance.live.kmp.core.b.a();
                f157381b = (c) r103;
                xh6.b r104 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(c.class), IMixStreamTypeEnumParam.RTC_CLIENT_MIX);
                if ((r104 instanceof c) == false) goto L12;
                r101 = r104;
            L12:
                com.bytedance.live.kmp.core.b.a();
                f157382c = (c) r101;
            }
        }

        static {
            f157379d1 = a.f157383d;
        }
    }

    public interface d extends xh6.c, xh6.b {

        /* JADX INFO: renamed from: e1, reason: collision with root package name */
        public static final a f157384e1 = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f157385a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final d f157386b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final /* synthetic */ a f157387c = null;

            public a() {
            }

            static {
                f157387c = new a();
                xh6.b r100 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(d.class), ITypeEnumParam.AUDIO);
                xh6.b r101 = null;
                if ((r100 instanceof d) == true) goto L5;
                r100 = null;
            L5:
                KmpEnv r102 = KmpEnv.f255139a;
                com.bytedance.live.kmp.core.b.a();
                f157385a = (d) r100;
                xh6.b r103 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(d.class), ITypeEnumParam.VIDEO);
                if ((r103 instanceof d) == false) goto L9;
                r101 = r103;
            L9:
                com.bytedance.live.kmp.core.b.a();
                f157386b = (d) r101;
            }
        }

        static {
            f157384e1 = a.f157387c;
        }
    }

    public interface e extends xh6.c, xh6.b {

        /* JADX INFO: renamed from: f1, reason: collision with root package name */
        public static final a f157388f1 = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f157389a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final e f157390b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final e f157391c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final e f157392d = null;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final e f157393e = null;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final e f157394f = null;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final e f157395g = null;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final /* synthetic */ a f157396h = null;

            public a() {
            }

            static {
                f157396h = new a();
                xh6.b r100 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(e.class), IVideoQualityEnumParam.MIN);
                xh6.b r101 = null;
                if ((r100 instanceof e) == true) goto L5;
                r100 = null;
            L5:
                KmpEnv r102 = KmpEnv.f255139a;
                com.bytedance.live.kmp.core.b.a();
                f157389a = (e) r100;
                xh6.b r103 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(e.class), IVideoQualityEnumParam.GUEST_NORMAL);
                if ((r103 instanceof e) == true) goto L8;
                r103 = null;
            L8:
                com.bytedance.live.kmp.core.b.a();
                f157390b = (e) r103;
                xh6.b r104 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(e.class), IVideoQualityEnumParam.GUEST_HIGH);
                if ((r104 instanceof e) == true) goto L11;
                r104 = null;
            L11:
                com.bytedance.live.kmp.core.b.a();
                f157391c = (e) r104;
                xh6.b r105 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(e.class), IVideoQualityEnumParam.ANCHOR_NORMAL);
                if ((r105 instanceof e) == true) goto L14;
                r105 = null;
            L14:
                com.bytedance.live.kmp.core.b.a();
                f157392d = (e) r105;
                xh6.b r106 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(e.class), IVideoQualityEnumParam.ANCHOR_HIGH);
                if ((r106 instanceof e) == true) goto L17;
                r106 = null;
            L17:
                com.bytedance.live.kmp.core.b.a();
                f157393e = (e) r106;
                xh6.b r107 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(e.class), IVideoQualityEnumParam.HORIZONTAL_4_3);
                if ((r107 instanceof e) == true) goto L20;
                r107 = null;
            L20:
                com.bytedance.live.kmp.core.b.a();
                f157394f = (e) r107;
                xh6.b r108 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(e.class), IVideoQualityEnumParam.HORIZONTAL_16_9);
                if ((r108 instanceof e) == false) goto L24;
                r101 = r108;
            L24:
                com.bytedance.live.kmp.core.b.a();
                f157395g = (e) r101;
            }
        }

        static {
            f157388f1 = a.f157396h;
        }

        int getHeight();

        int getWidth();
    }

    boolean G();

    void b();

    void e();

    void q0();
}
