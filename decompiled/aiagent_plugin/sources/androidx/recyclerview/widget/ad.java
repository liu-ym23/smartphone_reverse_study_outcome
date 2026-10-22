package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ViewTypeStorage.java */
/* JADX INFO: loaded from: classes.dex */
interface ad {

    /* JADX INFO: compiled from: ViewTypeStorage.java */
    public static class a implements ad {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SparseArray<s> f2442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2443b;

        /* JADX INFO: renamed from: androidx.recyclerview.widget.ad$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ViewTypeStorage.java */
        class C0072a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final s f2444a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f2445b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private SparseIntArray f2446c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private SparseIntArray f2447d;

            C0072a(a r2, s r3) {
                this.f2445b = r2;
                this.f2446c = new SparseIntArray(1);
                this.f2447d = new SparseIntArray(1);
                this.f2444a = r3;
            }

            @Override // androidx.recyclerview.widget.ad.c
            public int a(int r3) {
                int r0 = this.f2446c.indexOfKey(r3);
                if (r0 > (-1)) goto L5;
                int r1 = this.f2445b.b(this.f2444a);
                this.f2446c.put(r3, r1);
                this.f2447d.put(r1, r3);
                return r1;
            L5:
                return this.f2446c.valueAt(r0);
            }

            @Override // androidx.recyclerview.widget.ad.c
            public int b(int r4) {
                int r0 = this.f2447d.indexOfKey(r4);
                if (r0 < 0) goto L7;
                return this.f2447d.valueAt(r0);
            L7:
                throw new IllegalStateException("requested global type " + r4 + " does not belong to the adapter:" + this.f2444a.f2576a);
            }
        }

        public a() {
            this.f2442a = new SparseArray();
            this.f2443b = 0;
        }

        int b(s r3) {
            int r0 = this.f2443b;
            this.f2443b = r0 + 1;
            this.f2442a.put(r0, r3);
            return r0;
        }

        @Override // androidx.recyclerview.widget.ad
        public s a(int r3) {
            s r2 = (s) ZeusTransformUtils.preCheckCast(this.f2442a.get(r3), s.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L6;
            return r2;
        L6:
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + r3);
        }

        @Override // androidx.recyclerview.widget.ad
        public c a(s r2) {
            return new C0072a(this, r2);
        }
    }

    /* JADX INFO: compiled from: ViewTypeStorage.java */
    public static class b implements ad {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SparseArray<List<s>> f2448a;

        /* JADX INFO: compiled from: ViewTypeStorage.java */
        class a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final s f2449a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f2450b;

            @Override // androidx.recyclerview.widget.ad.c
            public int b(int r1) {
                return r1;
            }

            a(b r1, s r2) {
                this.f2450b = r1;
                this.f2449a = r2;
            }

            @Override // androidx.recyclerview.widget.ad.c
            public int a(int r4) {
                List<s> r0 = (List) ZeusTransformUtils.preCheckCast(this.f2450b.f2448a.get(r4), List.class, "com.obric.aiagent.plugin");
                if (r0 != null) goto L6;
                r0 = new ArrayList();
                this.f2450b.f2448a.put(r4, r0);
            L6:
                if (r0.contains(this.f2449a) == true) goto L8;
                r0.add(this.f2449a);
            L8:
                return r4;
            }
        }

        public b() {
            this.f2448a = new SparseArray();
        }

        @Override // androidx.recyclerview.widget.ad
        public s a(int r3) {
            List r2 = (List) ZeusTransformUtils.preCheckCast(this.f2448a.get(r3), List.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L9;
            if (r2.isEmpty() == true) goto L9;
            return (s) ZeusTransformUtils.preCheckCast(r2.get(0), s.class, "com.obric.aiagent.plugin");
        L9:
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + r3);
        }

        @Override // androidx.recyclerview.widget.ad
        public c a(s r2) {
            return new a(this, r2);
        }
    }

    /* JADX INFO: compiled from: ViewTypeStorage.java */
    public interface c {
        int a(int r1);

        int b(int r1);
    }

    c a(s r1);

    s a(int r1);
}
