package com.bytedance.android.window.shop.repository.tab.entity;

import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d0 extends f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f189535k = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<b> f189536j;

    public static final class a {
        public static d0 a(List r110) {
            Intrinsics.checkNotNullParameter(r110, "sortTypeDtoList");
            d0 r100 = new d0();
            Iterator r111 = r110.iterator();
        L4:
            if (r111.hasNext() == false) goto L10;
            com.bytedance.android.ec.window.base.repository.dto.q r101 = (com.bytedance.android.ec.window.base.repository.dto.q) r111.next();
            List<b> r102 = r100.f189536j;
            int r103 = b.f189537f;
            Intrinsics.checkNotNullParameter(r101, "dto");
            long r104 = r101.d();
            String r105 = r101.e();
            boolean r106 = r101.b();
            boolean r107 = true;
            if (r101.c() == 1) goto L9;
            r107 = false;
        L9:
            ArrayList r108 = (ArrayList) r102;
            r108.add(new b(r104, r105, r106, r107, r101.f()));
            goto L4
        L10:
            return r100;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int f189537f = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f189538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f189539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f189540c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f189541d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f189542e;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L16;
            b r101 = (b) r100;
            if (this.f189538a == r101.f189538a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f189539b, r101.f189539b) == true) goto L10;
            return false;
        L10:
            if (this.f189540c == r101.f189540c) goto L12;
            return false;
        L12:
            if (this.f189541d == r101.f189541d) goto L14;
            return false;
        L14:
            if (this.f189542e == r101.f189542e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4 */
        public final int hashCode() {
            long r100 = this.f189538a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            String r102 = this.f189539b;
            if (r102 == null) goto L5;
            int r103 = r102.hashCode();
        L6:
            int r104 = (r101 + r103) * 31;
            boolean r105 = this.f189540c;
            ?? r106 = 1;
            ?? r107 = r105;
            if (r105 == false) goto L9;
            r107 = 1;
        L9:
            int r108 = (r104 + r107) * 31;
            boolean r109 = this.f189541d;
            ?? r110 = r109;
            if (r109 == false) goto L12;
            r110 = 1;
        L12:
            int r111 = (r108 + r110) * 31;
            boolean r112 = this.f189542e;
            if (r112 == true) goto L17;
            r106 = r112;
        L17:
            return r111 + r106;
        L5:
            r103 = 0;
            goto L6
        }

        public final String toString() {
            return "Sorter(id=" + this.f189538a + ", title=" + this.f189539b + ", canReverse=" + this.f189540c + ", initialAscend=" + this.f189541d + ", isCurrent=" + this.f189542e + ")";
        }

        public b(long r100, String r101, boolean r102, boolean r103, boolean r104) {
            Intrinsics.checkNotNullParameter(r101, "title");
            this.f189538a = r100;
            this.f189539b = r101;
            this.f189540c = r102;
            this.f189541d = r103;
            this.f189542e = r104;
        }
    }

    static {
    }

    public d0() {
        super(AVMDLDataLoader.KeyIsPreconnectNum);
        this.f189536j = new ArrayList();
    }

    public final void e(long r100, Boolean r101) {
        Iterator<T> r102 = this.f189536j.iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        b r103 = (b) r102.next();
        long r104 = r103.f189538a;
        if (r100 != r104) goto L8;
        boolean r105 = true;
    L9:
        r103.f189542e = r105;
        if (r100 != r104) goto L4;
        if (r101 == null) goto L4;
        r103.f189541d = r101.booleanValue();
        goto L4
    L8:
        r105 = false;
        goto L9
    }
}
