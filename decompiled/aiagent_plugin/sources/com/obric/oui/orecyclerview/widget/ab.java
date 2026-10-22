package com.obric.oui.orecyclerview.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ViewTypeStorage.java */
/* JADX INFO: loaded from: classes4.dex */
interface ab {

    /* JADX INFO: compiled from: ViewTypeStorage.java */
    public static class a implements ab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SparseArray<r> f35696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f35697b;

        /* JADX INFO: renamed from: com.obric.oui.orecyclerview.widget.ab$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ViewTypeStorage.java */
        class C0965a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final r f35698a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f35699b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private SparseIntArray f35700c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private SparseIntArray f35701d;

            C0965a(a r2, r r3) {
                this.f35699b = r2;
                this.f35700c = new SparseIntArray(1);
                this.f35701d = new SparseIntArray(1);
                this.f35698a = r3;
            }

            @Override // com.obric.oui.orecyclerview.widget.ab.c
            public int a(int r3) {
                int r0 = this.f35700c.indexOfKey(r3);
                if (r0 > (-1)) goto L5;
                int r1 = this.f35699b.b(this.f35698a);
                this.f35700c.put(r3, r1);
                this.f35701d.put(r1, r3);
                return r1;
            L5:
                return this.f35700c.valueAt(r0);
            }

            @Override // com.obric.oui.orecyclerview.widget.ab.c
            public int b(int r4) {
                int r0 = this.f35701d.indexOfKey(r4);
                if (r0 < 0) goto L7;
                return this.f35701d.valueAt(r0);
            L7:
                throw new IllegalStateException("requested global type " + r4 + " does not belong to the adapter:" + this.f35698a.f35826a);
            }
        }

        public a() {
            this.f35696a = new SparseArray();
            this.f35697b = 0;
        }

        int b(r r3) {
            int r0 = this.f35697b;
            this.f35697b = r0 + 1;
            this.f35696a.put(r0, r3);
            return r0;
        }

        @Override // com.obric.oui.orecyclerview.widget.ab
        public r a(int r3) {
            r r2 = (r) ZeusTransformUtils.preCheckCast(this.f35696a.get(r3), r.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L6;
            return r2;
        L6:
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + r3);
        }

        @Override // com.obric.oui.orecyclerview.widget.ab
        public c a(r r2) {
            return new C0965a(this, r2);
        }
    }

    /* JADX INFO: compiled from: ViewTypeStorage.java */
    public static class b implements ab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SparseArray<List<r>> f35702a;

        /* JADX INFO: compiled from: ViewTypeStorage.java */
        class a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final r f35703a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f35704b;

            @Override // com.obric.oui.orecyclerview.widget.ab.c
            public int b(int r1) {
                return r1;
            }

            a(b r1, r r2) {
                this.f35704b = r1;
                this.f35703a = r2;
            }

            @Override // com.obric.oui.orecyclerview.widget.ab.c
            public int a(int r4) {
                List<r> r0 = (List) ZeusTransformUtils.preCheckCast(this.f35704b.f35702a.get(r4), List.class, "com.obric.aiagent.plugin");
                if (r0 != null) goto L6;
                r0 = new ArrayList();
                this.f35704b.f35702a.put(r4, r0);
            L6:
                if (r0.contains(this.f35703a) == true) goto L8;
                r0.add(this.f35703a);
            L8:
                return r4;
            }
        }

        public b() {
            this.f35702a = new SparseArray();
        }

        @Override // com.obric.oui.orecyclerview.widget.ab
        public r a(int r3) {
            List r2 = (List) ZeusTransformUtils.preCheckCast(this.f35702a.get(r3), List.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L9;
            if (r2.isEmpty() == true) goto L9;
            return (r) ZeusTransformUtils.preCheckCast(r2.get(0), r.class, "com.obric.aiagent.plugin");
        L9:
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + r3);
        }

        @Override // com.obric.oui.orecyclerview.widget.ab
        public c a(r r2) {
            return new a(this, r2);
        }
    }

    /* JADX INFO: compiled from: ViewTypeStorage.java */
    public interface c {
        int a(int r1);

        int b(int r1);
    }

    c a(r r1);

    r a(int r1);
}
