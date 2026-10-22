package com.bytedance.android.ec.hybrid.list.util;

import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f47297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f47298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f47299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f47300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f47301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a.C0825a f47302f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a.C0825a f47303g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<Long> f47304h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f47305i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<b> f47306j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f47307k;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.ec.hybrid.list.util.d$a$a, reason: collision with other inner class name */
        public static final class C0825a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f47308a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f47309b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f47310c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f47311d;

            public C0825a() {
                this(0);
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof C0825a) == false) goto L14;
                C0825a r101 = (C0825a) r100;
                if (this.f47308a == r101.f47308a) goto L8;
                return false;
            L8:
                if (this.f47309b == r101.f47309b) goto L10;
                return false;
            L10:
                if (this.f47310c == r101.f47310c) goto L12;
                return false;
            L12:
                if (this.f47311d == r101.f47311d) goto L22;
                return false;
            L22:
                return true;
            L14:
                return false;
            }

            public final int hashCode() {
                return (((((this.f47308a * 31) + this.f47309b) * 31) + this.f47310c) * 31) + this.f47311d;
            }

            public final String toString() {
                return "ECLynxCardLoadCacheRecord(useKitViewCacheNum=" + this.f47308a + ", useRenderCacheNum=" + this.f47309b + ", useGeckoCacheNum=" + this.f47310c + ", useDecodeCacheNum=" + this.f47311d + ")";
            }

            public C0825a(int r100) {
                this.f47308a = 0;
                this.f47309b = 0;
                this.f47310c = 0;
                this.f47311d = 0;
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ECLynxCardHolder.LoadState f47312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f47313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f47314c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f47315d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, Long> f47316e;

        public final b a() {
            b r100 = new b();
            r100.f47312a = this.f47312a;
            r100.f47313b = this.f47313b;
            r100.f47314c = this.f47314c;
            r100.f47315d = this.f47315d;
            return r100;
        }

        public final String toString() {
            return "state:" + this.f47312a.name() + "\nschema:" + this.f47313b + "\nerrorCode:" + this.f47314c + "\nerrorMsg:" + this.f47315d + '\n';
        }

        public b() {
            this.f47312a = ECLynxCardHolder.LoadState.IDLE;
            this.f47316e = new LinkedHashMap();
        }
    }

    static {
    }

    public final String toString() {
        return "flag:" + this.f47307k + "\ntotalLynxCardCount:" + this.f47297a + "\nsuccessLynxCardCount:" + this.f47298b + "\nfailLynxCardCount:" + this.f47299c + "\nabnormalCardLoadResult:" + this.f47306j;
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, ForwardDependency$ForwardLocation.FLAG);
        this.f47307k = r100;
        this.f47302f = new a.C0825a(0);
        this.f47303g = new a.C0825a(0);
        this.f47306j = new ArrayList();
    }

    public static void a(a.C0825a r100, a.C0825a r101) {
        r100.f47311d += r101.f47311d;
        r100.f47308a += r101.f47308a;
        r100.f47310c += r101.f47310c;
        r100.f47309b += r101.f47309b;
    }
}
