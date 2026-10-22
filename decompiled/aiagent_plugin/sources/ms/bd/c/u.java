package ms.bd.c;

import android.content.Context;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.ss.android.socialbase.downloader.setting.DownloadSettingValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class u implements t.c {
    private static final String A = null;
    private static final String B = null;
    private static final String C = null;
    private static final String D = null;
    private static final String E = null;
    private static volatile u F;
    private static HashMap<String, a> G;
    private static AtomicInteger H;
    private static HashMap<String, a> I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f39621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static int f39622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f39623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f39624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f39625e;
    private static int f;
    private static int g;
    private static int h;
    private static int i;
    private static int j;
    private static int k;
    private static int l;
    private static int m;
    private static AtomicInteger n;
    private static AtomicInteger o;
    private static AtomicInteger p;
    private static AtomicInteger q;
    private static AtomicInteger r;
    private static AtomicInteger s;
    private static final String t = null;
    private static final String u = null;
    private static final String v = null;
    private static final String w = null;
    private static final String x = null;
    private static final String y = null;
    private static final String z = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private volatile Object f39626J;

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f39627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f39628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f39629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f39630d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f39631e;
        int f;
        int g;
        String h;
        String i;
        String j;
        int k;
        long l;
        int m;
        int n;

        private a(int r1, int r2, int r3, int r4, String r5, int r6, int r7, String r8, String r9, String r10, int r11) {
            this.f39627a = r1;
            this.f39628b = r2;
            this.f39629c = r3;
            this.f39630d = r4;
            this.f39631e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.m = 0;
            this.i = r9;
            this.j = r10;
            this.k = r11;
            this.n = e.f39647a.a();
            this.l = 0;
        }

        /* synthetic */ a(int r1, int r2, int r3, int r4, String r5, int r6, int r7, String r8, String r9, String r10, int r11, int r12) {
            this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        }
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f39632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f39633b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f39634c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f39635d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f39636e;
        private int f;
        private int g;
        private String h;
        private String i;
        private String j;
        private int k;

        b(u r1) {
        }

        static /* synthetic */ void a(b r0, int r1) {
            r0.f39632a = r1;
        }

        static /* synthetic */ void a(b r0, String r1) {
            r0.getClass();
        }

        static /* synthetic */ void b(b r0, int r1) {
            r0.f39633b = r1;
        }

        static /* synthetic */ void b(b r0, String r1) {
            r0.f39636e = r1;
        }

        static /* synthetic */ void c(b r0, int r1) {
            r0.f39634c = r1;
        }

        static /* synthetic */ void c(b r0, String r1) {
            r0.i = r1;
        }

        static /* synthetic */ void d(b r0, int r1) {
            r0.f39635d = r1;
        }

        static /* synthetic */ void d(b r0, String r1) {
            r0.j = r1;
        }

        static /* synthetic */ void e(b r0, int r1) {
            r0.f = r1;
        }

        static /* synthetic */ void e(b r0, String r1) {
            r0.h = r1;
        }

        static /* synthetic */ void f(b r0, int r1) {
            r0.g = r1;
        }

        static /* synthetic */ void g(b r0, int r1) {
            r0.k = r1;
        }

        final a a() {
            return new a(this.f39632a, this.f39633b, this.f39634c, this.f39635d, this.f39636e, this.f, this.g, this.h, this.i, this.j, this.k, 0);
        }
    }

    static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f39637a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f39638b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f39639c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f39640d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f39641e = null;
        public static final c f = null;
        private int g;

        static {
            f39637a = new c(0, 0, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2da2b2", new byte[]{13, 71, 38, 111, 107, 0, 14, 113, 17, 81, 8, 89, 38, 127, 109, 0, 14, 112, 30, 73, 13, 73, 37, 104}), String.class, "com.obric.aiagent.plugin"));
            f39638b = new c(1, 2, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "75c0bb", new byte[]{8, 22, 36, 109, 107, 80, 11, 32, 19, 83, 13, 8, 36, 125, 109, 80, 11, 38, 23, 80, 9, 5, 36}), String.class, "com.obric.aiagent.plugin"));
            f39639c = new c(2, 4, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "68d14f", new byte[]{9, 27, 35, 108, 61, 84, 10, 45, 20, 82, 12, 5, 35, 124, 59, 84, 10, 33, 6, 78, 19, 31, 37}), String.class, "com.obric.aiagent.plugin"));
            f39640d = new c(3, 8, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "adc26b", new byte[]{94, 71, 36, 111, 63, 80, 93, 113, 19, 81, 91, 89, 36, 127, 57, 80, 93, 118, 17, 71, 94, 67, 47, 116, 44, 69, 77, 119, 6}), String.class, "com.obric.aiagent.plugin"));
            f39641e = new c(4, 16, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "d49e43", new byte[]{91, 23, 126, 56, 61, 1, 88, 33, 73, 6, 94, 9, 126, 40, 59, 1, 88, 61, 92, 1, 69}), String.class, "com.obric.aiagent.plugin"));
            f = new c(5, 32, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "3bfd11", new byte[]{12, 65, 33, 57, 56, 3, 15, 119, 22, 7, 9, 95, 33, 41, 62, 3, 15, 117, 18, 6, 11, 70, 44}), String.class, "com.obric.aiagent.plugin"));
        }

        private c(int r1, int r2, String r3) {
            super(r3, r1);
            this.g = r2;
        }

        final int a() {
            return this.g;
        }
    }

    static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f39642a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f39643b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f39644c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f39645d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final d f39646e = null;
        public static final d f = null;
        private static final /* synthetic */ d[] g = null;
        private int h;

        private d(int r1, int r2, String r3) {
            super(r3, r1);
            this.h = r2;
        }

        public static d[] a() {
            return (d[]) ZeusTransformUtils.preCheckCast(g.clone(), d[].class, "com.obric.aiagent.plugin");
        }

        final int b() {
            return this.h;
        }

        static {
            d r0 = new d(0, 0, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b1d2c4", new byte[]{69, 18, 59, 115, 121, 28, 66, 61, 17, 93, 93, 28, 57, 99}), String.class, "com.obric.aiagent.plugin"));
            f39642a = r0;
            d r2 = new d(1, 1, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "129c83", new byte[]{22, 17, 102, 34, 34, 27, 17, 62, 76, 12, 18, 25, 121, 60}), String.class, "com.obric.aiagent.plugin"));
            f39643b = r2;
            d r1 = new d(2, 2, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6c89a9", new byte[]{17, 64, 103, 120, 123, 17, 22, 111, 77, 86, 3, 88}), String.class, "com.obric.aiagent.plugin"));
            f39644c = r1;
            d r6 = new d(3, 3, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6fd040", new byte[]{17, 69, 59, 113, 46, 24, 22, 106, 17, 95, 31, 87, 56, 112, 46, 21}), String.class, "com.obric.aiagent.plugin"));
            f39645d = r6;
            d r9 = new d(4, 4, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "7792ce", new byte[]{16, 20, 102, 115, 121, 77, 23, 59, 76, 93, 14, 1, 126, 118, 99, 66, 21, 34, 64}), String.class, "com.obric.aiagent.plugin"));
            f39646e = r9;
            d r11 = new d(5, 5, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6d594b", new byte[]{17, 71, 106, 120, 46, 74, 22, 104, 64, 86, 17, 67, 116, 100, 45, 76}), String.class, "com.obric.aiagent.plugin"));
            f = r11;
            g = new d[]{r0, r2, r1, r6, r9, r11, new d(6, 6, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "a04b81", new byte[]{70, 19, 107, 35, 34, 25, 65, 60, 65, 13, 85, 28, 99}), String.class, "com.obric.aiagent.plugin"))};
        }
    }

    static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f39647a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f39648b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f39649c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f39650d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final e f39651e = null;
        public static final e f = null;
        public static final e g = null;
        public static final e h = null;
        public static final e i = null;
        public static final e j = null;
        public static final e k = null;
        public static final e l = null;
        public static final e m = null;
        public static final e n = null;
        public static final e o = null;
        public static final e p = null;
        public static final e q = null;
        private int r;

        static {
            f39647a = new e(0, 0, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6fc948", new byte[]{17, 69, 60, 120, 46, 16, 22, 106, 22, 86, 20, 80, 49, 121, 46, 16, 27, 104, 28, 76}), String.class, "com.obric.aiagent.plugin"));
            e r0 = new e(1, 10, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "8d5b93", new byte[]{31, 71, 106, 35, 35, 27, 24, 104, 64, 13, 26, 82, 103, 34, 35, 27, 11, 100, 86, 1, 12, 89, 100, 51, 33, 13, 21}), String.class, "com.obric.aiagent.plugin"));
            f39648b = r0;
            String r2 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "eef732", new byte[]{66, 70, 57, 118, 41, 26, 69, 105, 19, 88, 71, 83, 52, 119, 41, 26, 86, 101, 5, 84, 81, 88, 51, 98, 37, 9, 67, 96}), String.class, "com.obric.aiagent.plugin");
            e r1 = new e(2, r0.r + 5, r2);
            f39649c = r1;
            String r3 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "06492d", new byte[]{23, 21, 107, 120, 40, 76, 16, 58, 65, 86, 18, 0, 102, 121, 40, 76, 3, 54, 87, 90, 4, 11, 116, 120, 46, 80, 22, 36, 86}), String.class, "com.obric.aiagent.plugin");
            e r4 = new e(3, r1.r + 5, r3);
            f39650d = r4;
            String r5 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "fbb38d", new byte[]{65, 65, 61, 114, 34, 76, 70, 110, 23, 92, 68, 84, 48, 115, 34, 76, 65, 106, 0, 83, 86, 84, 50, 111, 56, 81, 64, 100, 26, 77}), String.class, "com.obric.aiagent.plugin");
            e r6 = new e(4, r4.r + 10, r5);
            f39651e = r6;
            String r7 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "73d9b3", new byte[]{16, 16, 59, 120, 120, 27, 23, 63, 17, 86, 21, 5, 54, 121, 120, 27, 16, 59, 6, 89, 7, 5, 52, 101, 98, 2, 21, 59, 25, 76, 2}), String.class, "com.obric.aiagent.plugin");
            e r8 = new e(5, r6.r + 5, r7);
            f = r8;
            String r9 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "7db054", new byte[]{16, 71, 61, 113, 47, 28, 23, 104, 23, 95, 21, 82, 48, 112, 47, 28, 16, 108, 0, 80, 7, 82, 50, 108, 53, 16, 1, 102, 16, 69, 21, 85}), String.class, "com.obric.aiagent.plugin");
            e r10 = new e(6, r8.r + 5, r9);
            g = r10;
            String r11 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "103d9a", new byte[]{22, 19, 108, 37, 35, 73, 17, 60, 70, 11, 19, 6, 97, 36, 35, 73, 6, 48, 81, 31, 31, 2, 117, 60, 42, 73, 16, 52, 69, 29, 14}), String.class, "com.obric.aiagent.plugin");
            e r12 = new e(7, r10.r + 10, r11);
            h = r12;
            String r13 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "4654ae", new byte[]{19, 21, 106, 117, 123, 77, 20, 58, 64, 91, 22, 0, 103, 116, 123, 77, 3, 54, 87, 79, 26, 4, 115, 108, 114, 77, 17, 54, 77, 72, 0, 16}), String.class, "com.obric.aiagent.plugin");
            e r14 = new e(8, r12.r + 5, r13);
            i = r14;
            String r15 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "10be24", new byte[]{22, 19, 61, 36, 40, 28, 17, 60, 23, 10, 19, 6, 48, 37, 40, 28, 6, 48, 0, 30, 31, 2, 36, 61, 33, 28, 1, 36, 16, 22, 5, 1, 34}), String.class, "com.obric.aiagent.plugin");
            e r16 = new e(9, r14.r + 5, r15);
            j = r16;
            String r17 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2e613c", new byte[]{21, 70, 105, 112, 41, 75, 18, 105, 67, 94, 16, 83, 100, 113, 41, 75, 5, 101, 84, 74, 28, 87, 119, 106, 33, 91, 5, 97, 88, 67, 6, 64, 108, 107}), String.class, "com.obric.aiagent.plugin");
            e r18 = new e(10, r16.r + 10, r17);
            k = r18;
            String r19 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e81062", new byte[]{66, 27, 110, 113, 44, 26, 69, 52, 68, 95, 71, 14, 99, 112, 44, 26, 82, 56, 83, 75, 75, 10, 112, 107, 36, 10, 82, 60, 95, 70, 85, 19, 110, 97, 45}), String.class, "com.obric.aiagent.plugin");
            l = new e(11, r18.r + 5, r19);
            String r20 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "c3bac1", new byte[]{68, 16, 61, 32, 121, 25, 67, 63, 23, 14, 65, 5, 48, 33, 121, 25, 84, 51, 0, 26, 77, 1, 35, 58, 113, 9, 84, 55, 12, 2, 71, 18, 50, 48, 111, 21}), String.class, "com.obric.aiagent.plugin");
            m = new e(13, 125, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "15b497", new byte[]{22, 22, 61, 117, 35, 31, 17, 57, 23, 91, 19, 3, 48, 116, 35, 31, 0, 49, 3, 75, 18, 3, 46, 110, 41, 31, 28, 49, 22, 64, 31, 19, 62, 110, 50, 31, 31, 59, 23, 77, 6, 14}), String.class, "com.obric.aiagent.plugin"));
            n = new e(14, ApWakeEvent.ACCELERATING_START, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "a86a9e", new byte[]{70, 27, 105, 32, 35, 77, 65, 52, 67, 14, 67, 14, 100, 33, 35, 77, 80, 60, 87, 30, 66, 14, 122, 59, 41, 77, 80, 60, 87, 30, 66, 14, 122, 56, 39, 92, 67, 62, 66, 3, 79, 30, 106, 59, 50, 77, 79, 54, 67, 24, 86, 3}), String.class, "com.obric.aiagent.plugin"));
            o = new e(15, 135, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6505bc", new byte[]{17, 22, 111, 116, 120, 75, 22, 57, 69, 90, 20, 3, 98, 117, 120, 75, 7, 49, 81, 74, 21, 3, 124, 99, 120, 83, 28, 58, 94, 79, 6, 1, 98, 126, 121, 91, 27, 32, 94, 72, 8, 19, 106, 103, 100}), String.class, "com.obric.aiagent.plugin"));
            p = new e(16, 230, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "aa295e", new byte[]{70, 66, 109, 120, 47, 77, 65, 109, 71, 86, 67, 87, 96, 121, 47, 77, 80, 101, 83, 70, 66, 87, 126, 107, 43, 91, 78, 101, 71, 86, 94, 66, 117, 100, 60, 87, 93, 100, 76, 71, 68, 92, 108, 98, 46, 91, 68, 121}), String.class, "com.obric.aiagent.plugin"));
            q = new e(17, 240, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "a05c1d", new byte[]{70, 19, 106, 34, 43, 76, 65, 60, 64, 12, 67, 6, 103, 35, 43, 76, 80, 52, 84, 28, 66, 6, 121, 36, 59, 80, 65, 52, 87, 0, 79, 28, 103, 35, 39, 69, 71, 46, 64, 28, 94, 6, 121, 58, 33, 87, 75, 55, 93}), String.class, "com.obric.aiagent.plugin"));
        }

        private e(int r1, int r2, String r3) {
            super(r3, r1);
            this.r = r2;
        }

        final int a() {
            return this.r;
        }
    }

    static final enum f extends Enum<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f39652a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f39653b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f39654c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final f f39655d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f39656e;

        static {
            f39652a = new f(0, 0, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "4bc9f7", new byte[]{19, 65, 60, 120, 124, 31, 5, 102, 2, 70, 23, 84, 47, 107, 107, 5, 6, 124, 28, 70, 11, 69}), String.class, "com.obric.aiagent.plugin"));
            f39653b = new f(1, 1, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "0fbae0", new byte[]{23, 69, 61, 32, 127, 24, 1, 98, 3, 30, 19, 80, 46, 51, 104, 2, 2, 120, 16, 28, 5, 91, 62, 59, 127, 19, 26, 106, 22}), String.class, "com.obric.aiagent.plugin"));
            String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "4c6d6e", new byte[]{19, 64, 105, 37, 44, 77, 5, 103, 87, 27, 23, 85, 122, 54, 59, 87, 6, 125, 82, 1, 12, 69, 122, 63, 39, 87, 3, 107, 74, 17}), String.class, "com.obric.aiagent.plugin");
            f39654c = new f(3, 3, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ddbe83", new byte[]{67, 71, 61, 36, 34, 27, 85, 96, 3, 26, 71, 82, 46, 55, 53, 1, 86, 122, 6, 0, 92, 66, 46, 52, 49, 1, 85, 124, 7, 28, 88, 67}), String.class, "com.obric.aiagent.plugin"));
            f39655d = new f(4, 4, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "7d6333", new byte[]{16, 71, 105, 114, 41, 27, 6, 96, 87, 76, 20, 82, 122, 97, 62, 1, 5, 122, 66, 77, 2}), String.class, "com.obric.aiagent.plugin"));
        }

        private f(int r1, int r2, String r3) {
            super(r3, r1);
            this.f39656e = r2;
        }

        final int a() {
            return this.f39656e;
        }
    }

    static final enum g extends Enum<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f39657a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f39658b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f39659c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final g f39660d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ g[] f39661e = null;
        private int f;

        private g(int r1, int r2, String r3) {
            super(r3, r1);
            this.f = r2;
        }

        public static g[] a() {
            return (g[]) ZeusTransformUtils.preCheckCast(f39661e.clone(), g[].class, "com.obric.aiagent.plugin");
        }

        final int b() {
            return this.f;
        }

        static {
            g r0 = new g(0, 0, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2fbab8", new byte[]{21, 69, 61, 32, 120, 16, 2, 114, 17, 14, 0, 73, 53, 42, 115, 0, 31, 98}), String.class, "com.obric.aiagent.plugin"));
            f39657a = r0;
            g r1 = new g(1, 1, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2e89ef", new byte[]{21, 70, 103, 120, 127, 78, 2, 113, 75, 86, 0, 74, 111, 114, 126, 72, 14, 96, 76, 89, 15, 72, 114, 114, 115, 85}), String.class, "com.obric.aiagent.plugin"));
            f39658b = r1;
            g r4 = new g(2, 2, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e063b5", new byte[]{66, 19, 105, 114, 120, 29, 85, 36, 69, 92, 87, 31, 97, 120, 121, 27, 89, 34, 68, 81, 93, 2, 113, 120, 104, 16, 74}), String.class, "com.obric.aiagent.plugin"));
            f39659c = r4;
            g r6 = new g(3, 3, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "5e9112", new byte[]{18, 70, 102, 112, 43, 26, 5, 113, 74, 94, 7, 74, 110, 122, 43, 11, 18}), String.class, "com.obric.aiagent.plugin"));
            f39660d = r6;
            f39661e = new g[]{r0, r1, r4, r6};
        }
    }

    static {
        t = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "5bebb7", new byte[]{50, 101, 4}), String.class, "com.obric.aiagent.plugin");
        u = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "003ea9", new byte[]{52, 39, 68}), String.class, "com.obric.aiagent.plugin");
        v = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f4d59b", new byte[]{116, 59, 19}), String.class, "com.obric.aiagent.plugin");
        w = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "82f5d1", new byte[]{58, 61, 17}), String.class, "com.obric.aiagent.plugin");
        x = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "768916", new byte[]{32, 38, 78}), String.class, "com.obric.aiagent.plugin");
        y = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "81c2a8", new byte[]{58, 48, 21}), String.class, "com.obric.aiagent.plugin");
        z = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "a5e6a0", new byte[]{99, 62, 18}), String.class, "com.obric.aiagent.plugin");
        A = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b19801", new byte[]{119, 35, 78}), String.class, "com.obric.aiagent.plugin");
        B = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "546240", new byte[]{32, 37, 70}), String.class, "com.obric.aiagent.plugin");
        C = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "732114", new byte[]{37, 57, 74}), String.class, "com.obric.aiagent.plugin");
        D = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "9bd566", new byte[]{56, 97, 5, 76}), String.class, "com.obric.aiagent.plugin");
        E = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2cf54f", new byte[]{46, 121, 7}), String.class, "com.obric.aiagent.plugin");
        f39621a = 257;
        f39622b = -1;
        f39623c = new AtomicBoolean(false);
        new AtomicBoolean(true);
        f39624d = 2;
        f39625e = 255;
        f = 5;
        g = 5;
        h = 5;
        i = 5;
        j = 3;
        k = 20;
        l = 50;
        m = DownloadSettingValues.SYNC_INTERVAL_MS_FG;
        n = new AtomicInteger(0);
        o = new AtomicInteger(0);
        p = new AtomicInteger(0);
        q = new AtomicInteger(0);
        r = new AtomicInteger(0);
        s = new AtomicInteger(0);
        G = new HashMap();
        H = new AtomicInteger(e.f39647a.a());
        I = new HashMap();
    }

    private u() {
        t.a().a(this);
    }

    public static u a() {
        if (F != null) goto L15;
        monitor-enter(u.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (F != null) goto L9;
        F = new u();     // Catch: Throwable -> L11
    L9:
        monitor-exit(u.class);     // Catch: Throwable -> L11
    L15:
        return F;
    }

    public static void a(String r3, String r4) {
        if (f39623c.compareAndSet(false, true) == false) goto L24;
        s.incrementAndGet();
        if (I.size() <= 0) goto L18;
        if (r4 == null) goto L18;
        if (r4.length() >= l) goto L18;
        if (s.incrementAndGet() < f39624d) goto L12;
        s.decrementAndGet();
        goto L18
    L12:
        if (t.a().a(t.b.f39615b, r4) == true) goto L18;
        if (s.decrementAndGet() >= 0) goto L18;
        s.set(0);
    L18:
        if (t.a().a(t.b.f39614a, r3) == true) goto L24;
        if (s.decrementAndGet() >= 0) goto L22;
        s.set(0);
    L22:
        f39623c.set(false);
    L24:
        if (s.get() <= f39624d) goto L27;
        t.a().a(t.b.f39616c, null);
        s.set(0);
        f39623c.set(false);
        return;
    }

    private static boolean a(a r5) {
        if (r5.f39630d != f.f39653b.a()) goto L5;
        int r0 = H.get();
    L7:
        if (r5.f39630d != f.f39654c.a()) goto L22;
        if (r5.m < r5.k) goto L12;
    L30:
        return false;
    L12:
        if ((System.currentTimeMillis() - r5.l) < m) goto L30;
        if (r0 != e.o.a()) goto L17;
    L31:
        return true;
    L17:
        if (r0 == e.m.a()) goto L31;
        if (r0 == e.q.a()) goto L31;
    L22:
        if (r0 == e.f39647a.a()) goto L31;
        if (r0 == e.i.a()) goto L31;
        if (r0 == e.p.a()) goto L31;
        if (r0 != e.n.a()) goto L30;
    L5:
        r0 = r5.n;
        goto L7
    }

    public final void a(String r24, int r25) {
        int r3 = d.f39642a.b();
        int r4 = e.f39648b.a();
        if (r25 != t.b.f39614a.b()) goto L5;
    L7:
        if (r24 != null) goto L10;
    L122:
        r4 = r4;
        a r1 = null;
    L123:
        int r6 = 0;
    L127:
        if (r1 != null) goto L129;
    L243:
        if (r1 != null) goto L245;
    L247:
        if (r6 > 0) goto L249;
    L256:
        if (r1 == null) goto L261;
        if (r4 <= r1.n) goto L261;
        r1.n = r4;
    L261:
        if (s.decrementAndGet() < f39624d) goto L263;
        t.a().a(t.b.f39616c, null);
        boolean r2 = false;
        s.set(0);
    L264:
        f39623c.set(r2);
        return;
    L263:
        r2 = false;
        goto L264
    L249:
        if (r3 != d.f39643b.b()) goto L251;
    L252:
        if (r1 != null) goto L254;
    L255:
        com.bytedance.mobsec.matrix.a.a(134217732, r6, r4, null, null);
        goto L256
    L254:
        if (r1.n >= r4) goto L256;
    L251:
        if (r3 != d.f39644c.b()) goto L256;
    L245:
        if (r1.f39630d != f.f39653b.a()) goto L247;
        H.set(r4);
        goto L247
    L129:
        if (r4 < e.f39650d.a()) goto L243;
        int r5 = r1.f39628b;
        d r7 = d.f39646e;
        if (r5 == r7.b()) goto L133;
    L135:
        e r8 = e.f39651e;
        r8.getClass();
        boolean r9 = a(r1);
        s r10 = s.f39603a;
        int r11 = r8.a();
        if (r9 == true) goto L138;
        boolean r12 = false;
        boolean r13 = true;
    L158:
        if (r11 < e.g.a()) goto L242;
        r1.m++;
        r1.l = System.currentTimeMillis();
        e.h.getClass();
        int r14 = f39622b;
        if (r12 == true) goto L163;
    L198:
        r14 = 0;
    L199:
        if (r14 == 0) goto L201;
        r4 = e.i.a();
        goto L243
    L201:
        if (r1.f39628b != r7.b()) goto L203;
        r4 = e.j.a();
        goto L243
    L203:
        e.k.getClass();
        int r15 = f39622b;
        int r16 = r10.ordinal();
        if (r16 == 2) goto L219;
        if (r16 != 3) goto L207;
        s r17 = s.f39605c;
    L217:
        r15 = a(r13, r1, r17.a());
    L218:
        boolean r18 = false;
    L220:
        if (r15 != 0) goto L240;
        e r19 = e.m;
        r19.getClass();
        if (r18 == true) goto L225;
        r4 = r19.a();
        goto L243
    L225:
        if (this.f39626J == null) goto L227;
    L236:
        Object r0 = this.f39626J;
        if (r0 != null) goto L239;
        r4 = e.n.a();
        goto L243
    L239:
        com.bytedance.mobsec.matrix.a.a(33554433, r1.f, ((Long) ZeusTransformUtils.preCheckCast(r0, Long.class, "com.obric.aiagent.plugin")).longValue(), r1.f39631e, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r4 = e.o.a();
        goto L243
    L227:
        monitor-enter(u.class);
    L233:
        th = move-exception;
        throw th;
    L229:
        if (this.f39626J != null) goto L231;
        this.f39626J = com.bytedance.mobsec.matrix.a.a(50331651, 0, 0, null, null);     // Catch: Throwable -> L233
    L231:
        monitor-exit(u.class);     // Catch: Throwable -> L233
        goto L236
    L240:
        r4 = e.l.a();
        goto L243
    L207:
        if (r16 != 4) goto L209;
        r17 = s.f39606d;
        goto L217
    L209:
        if (r16 != 5) goto L211;
        r17 = s.f39607e;
        goto L217
    L211:
        if (r16 != 6) goto L218;
        r17 = s.f;
        goto L217
    L219:
        r15 = a(r13, r1, s.f39606d.a());
        r18 = true;
        goto L220
    L163:
        if (r1.n >= e.j.a()) goto L198;
        if (r1.m > 3) goto L199;
        int r20 = g.a()[r1.f39629c].ordinal();
        if (r20 == 1) goto L172;
        if (r20 != 2) goto L199;
    L172:
        int r110 = r1.g;
        int r21 = r1.f39628b;
        c r111 = c.f39637a;
        r111.getClass();
        int r22 = d.a()[r21].ordinal();
        if (r22 == 1) goto L183;
        if (r22 == 2) goto L182;
        if (r22 == 3) goto L181;
        if (r22 == 4) goto L180;
        if (r22 == 5) goto L179;
        int r23 = r111.a();
    L186:
        if (r23 == r111.a()) goto L199;
        if (r1.f39629c != g.f39658b.b()) goto L194;
        if (r1.f39627a >= f39621a) goto L194;
        r110 = 1;
    L194:
        if (((Integer) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(134217729, r23, r110, r1.h, r1.j), Integer.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L196;
        boolean r112 = true;
    L197:
        if (r112 == false) goto L199;
    L196:
        r112 = false;
        goto L197
    L179:
        c r26 = c.f;
    L184:
        r23 = r26.a();
        goto L186
    L180:
        r26 = c.f39641e;
        goto L184
    L181:
        r26 = c.f39639c;
        goto L184
    L182:
        r26 = c.f39640d;
        goto L184
    L183:
        r26 = c.f39638b;
        goto L184
    L242:
        r4 = e.f.a();
        goto L243
    L138:
        int r27 = d.a()[r1.f39628b].ordinal();
        if (r27 == 1) goto L151;
        if (r27 == 2) goto L149;
        if (r27 == 3) goto L148;
        if (r27 == 4) goto L146;
        if (r27 == 5) goto L145;
        s r28 = r10;
        r12 = false;
    L147:
        r13 = true;
    L153:
        if (r28 == r10) goto L156;
        r11 = e.g.a();
    L156:
        r10 = r28;
        goto L158
    L145:
        r28 = s.f;
    L150:
        r12 = true;
    L152:
        r13 = false;
        goto L153
    L146:
        r28 = s.f39607e;
        r12 = true;
        goto L147
    L148:
        r28 = s.f39605c;
        goto L150
    L149:
        r28 = s.f39606d;
        goto L150
    L151:
        r28 = s.f39604b;
        r12 = false;
        goto L152
    L133:
        if (r25 == t.b.f39615b.b()) goto L135;
    L10:
        if (r25 != t.b.f39615b.b()) goto L266;
        r1 = (a) ZeusTransformUtils.preCheckCast(I.get(r24), a.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L123;
        int r29 = r1.f;
    L14:
        r6 = r29;
        goto L127
    L266:
        JSONObject r30 = new JSONObject(r24);     // Catch: Exception -> L124
        int r31 = Integer.parseInt(r30.getString(t));     // Catch: Exception -> L124
        int r32 = f39621a;     // Catch: Exception -> L124
        if (r31 < (r32 - 1)) goto L122;
        if (r31 > r32) goto L122;
        String r33 = r30.getString(u);     // Catch: Exception -> L124
        if (r33 == null) goto L122;
        a r113 = (a) ZeusTransformUtils.preCheckCast(G.get(r33), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L124
        if (r113 == null) goto L25;
        r4 = r113.n;     // Catch: Exception -> L121
        r1 = r113;
        r29 = 0;
        goto L14
    L25:
        r3 = Integer.parseInt(r30.getString(v));     // Catch: Exception -> L121
        String r114 = r30.getString(D);     // Catch: Exception -> L121
        String r115 = "";
        String r116 = "";
        if (r3 != d.f39643b.b()) goto L32;
        if (n.get() > f) goto L120;
        int r117 = 0;
        int r118 = 0;
    L74:
        String r34 = r30.getString(y);     // Catch: Exception -> L121
        if (r34 == null) goto L120;
        if (r34.length() > k) goto L120;
        r6 = Integer.parseInt(r30.getString(z));     // Catch: Exception -> L121
        if (r6 > 0) goto L268;
    L118:
        int r119 = r4;
    L119:
        r1 = r113;
        r4 = r119;
        goto L127
    L268:
    L117:
        r29 = r6;
        r1 = r113;
    L126:
        r4 = e.f39649c.a();
        goto L14
    L82:
        if (r6 > f39625e) goto L118;
        int r35 = Integer.parseInt(r30.getString(x));     // Catch: Exception -> L117
        r119 = r4;
        if (r35 >= f.f39655d.a()) goto L119;
        if (r35 <= f.f39652a.a()) goto L119;
        int r36 = Integer.parseInt(r30.getString(E));     // Catch: Exception -> L91
    L92:
        if (r36 < 0) goto L119;
        b r37 = new b(this);     // Catch: Exception -> L117
        b.a(r37, r33);     // Catch: Exception -> L117
        b.a(r37, r31);     // Catch: Exception -> L117
        b.b(r37, r3);     // Catch: Exception -> L117
        b.c(r37, r117);     // Catch: Exception -> L117
        b.d(r37, r35);     // Catch: Exception -> L117
        b.b(r37, r34);     // Catch: Exception -> L117
        b.e(r37, r6);     // Catch: Exception -> L117
        b.f(r37, r118);     // Catch: Exception -> L117
        b.c(r37, r114);     // Catch: Exception -> L117
        b.d(r37, r115);     // Catch: Exception -> L117
        b.g(r37, r36);     // Catch: Exception -> L117
        b.e(r37, r116);     // Catch: Exception -> L117
        r1 = r37.a();     // Catch: Exception -> L117
        G.put(r33, r1);     // Catch: Exception -> L116
        if (r3 != d.f39643b.b()) goto L99;
        AtomicInteger r38 = n;     // Catch: Exception -> L116
    L113:
        r38.incrementAndGet();     // Catch: Exception -> L116
    L114:
        r4 = e.f39650d.a();     // Catch: Exception -> L116
        r29 = r6;
        goto L14
    L99:
        if (r3 != d.f39644c.b()) goto L102;
        r38 = o;     // Catch: Exception -> L116
        goto L113
    L102:
        if (r3 != d.f39645d.b()) goto L105;
        r38 = p;     // Catch: Exception -> L116
        goto L113
    L105:
        if (r3 != d.f39646e.b()) goto L111;
        if (I.get(r114) != null) goto L109;
        I.put(r114, r1);     // Catch: Exception -> L116
    L109:
        r38 = q;     // Catch: Exception -> L116
        goto L113
    L111:
        if (r3 != d.f.b()) goto L114;
        r38 = r;     // Catch: Exception -> L116
    L116:
        r29 = r6;
    L91:
        r36 = 1;
    L120:
        r1 = r113;
        r4 = r4;
        goto L123
    L32:
        if (r3 != d.f39644c.b()) goto L37;
        if (o.get() > g) goto L120;
    L55:
        int r120 = Integer.parseInt(r30.getString(w));     // Catch: Exception -> L121
        if (r120 >= g.f39660d.b()) goto L120;
        if (r120 <= g.f39657a.b()) goto L120;
        int r121 = Integer.parseInt(r30.getString(A));     // Catch: Exception -> L121
        if (r121 < 0) goto L120;
        if (r120 != g.f39659c.b()) goto L70;
        r115 = r30.getString(B);     // Catch: Exception -> L121
        if (r115 == null) goto L120;
        if (r115.isEmpty() == true) goto L120;
    L70:
        String r122 = r30.getString(C);     // Catch: Exception -> L121
        if (r122 == null) goto L120;
        r117 = r120;
        r116 = r122;
        r118 = r121;
        goto L74
    L37:
        if (r3 != d.f39645d.b()) goto L42;
        if (p.get() <= h) goto L55;
    L42:
        if (r3 != d.f39646e.b()) goto L51;
        if (q.get() > i) goto L120;
        if (r114 == null) goto L120;
        if (r114.length() <= l) goto L55;
    L51:
        if (r3 != d.f.b()) goto L120;
        if (r.get() <= j) goto L55;
    L121:
        r1 = r113;
    L125:
        r29 = 0;
    L124:
        r1 = null;
        goto L125
    L5:
        if (r25 == t.b.f39615b.b()) goto L7;
        goto L7
    }

    static int a(boolean r6, a r7, int r8) {
        if (r6 == false) goto L4;
        int r9 = 134217731;
    L6:
        return ((Integer) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(r9, r8, r7.f, r7.f39631e, r7.i), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L4:
        r9 = 134217730;
        goto L6
    }
}
