package com.bytedance.android.sdk.bdticketguard.init;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f163771a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c[] f163772a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Map<Integer, c> f163773b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ a f163774c = null;

        public a() {
        }

        static {
            f163774c = new a();
            int r100 = 0;
            c[] r101 = {d.f163776b, g.f163778b, b.f163775b, e.f163777b};
            f163772a = r101;
            LinkedHashMap r102 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r101.length), 16));
            int r103 = r101.length;
        L3:
            if (r100 >= r103) goto L5;
            c r104 = r101[r100];
            r102.put(Integer.valueOf(r104.a()), r104);
            r100 = r100 + 1;
            goto L3
        L5:
            f163773b = r102;
        }
    }

    public static final class b implements InterfaceC2499c, f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f163775b = null;

        public b() {
        }

        @Override // com.bytedance.android.sdk.bdticketguard.init.c
        public final int a() {
            return -1;
        }

        public final String toString() {
            return "FAILED";
        }

        static {
            f163775b = new b();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.sdk.bdticketguard.init.c$c, reason: collision with other inner class name */
    public interface InterfaceC2499c extends c {
    }

    public static final class d implements InterfaceC2499c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f163776b = null;

        public d() {
        }

        @Override // com.bytedance.android.sdk.bdticketguard.init.c
        public final int a() {
            return 0;
        }

        public final String toString() {
            return "NOT_STARTED";
        }

        static {
            f163776b = new d();
        }
    }

    public static final class e implements f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f163777b = null;

        public e() {
        }

        @Override // com.bytedance.android.sdk.bdticketguard.init.c
        public final int a() {
            return 2;
        }

        public final String toString() {
            return "REQUEST_CERT";
        }

        static {
            f163777b = new e();
        }
    }

    public interface f extends c {
    }

    public static final class g implements f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f163778b = null;

        public g() {
        }

        @Override // com.bytedance.android.sdk.bdticketguard.init.c
        public final int a() {
            return 1;
        }

        public final String toString() {
            return "SUCCESS";
        }

        static {
            f163778b = new g();
        }
    }

    static {
        f163771a = a.f163774c;
    }

    int a();
}
