package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.databind.ac;
import java.io.Serializable;

/* JADX INFO: compiled from: FilteredBeanPropertyWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: compiled from: FilteredBeanPropertyWriter.java */
    private static final class a extends com.fasterxml.jackson.databind.j.d implements Serializable {
        protected final com.fasterxml.jackson.databind.j.d w;
        protected final Class<?>[] x;

        @Override // com.fasterxml.jackson.databind.j.d
        public /* synthetic */ com.fasterxml.jackson.databind.j.d a(com.fasterxml.jackson.databind.l.q r1) {
            return c(r1);
        }

        public a(com.fasterxml.jackson.databind.j.d r1, Class<?>[] r2) {
            super(r1);
            this.w = r1;
            this.x = r2;
        }

        public a c(com.fasterxml.jackson.databind.l.q r3) {
            return new a(this.w.a(r3), this.x);
        }

        @Override // com.fasterxml.jackson.databind.j.d
        public void a(com.fasterxml.jackson.databind.p<Object> r1) {
            this.w.a(r1);
        }

        @Override // com.fasterxml.jackson.databind.j.d
        public void b(com.fasterxml.jackson.databind.p<Object> r1) {
            this.w.b(r1);
        }

        @Override // com.fasterxml.jackson.databind.j.d, com.fasterxml.jackson.databind.j.o
        public void a(Object r2, com.fasterxml.jackson.a.h r3, ac r4) {
            if (a(r4.e()) == false) goto L6;
            this.w.a(r2, r3, r4);
            return;
        L6:
            this.w.b(r2, r3, r4);
        }

        @Override // com.fasterxml.jackson.databind.j.d
        public void c(Object r2, com.fasterxml.jackson.a.h r3, ac r4) {
            if (a(r4.e()) == false) goto L6;
            this.w.c(r2, r3, r4);
            return;
        L6:
            this.w.d(r2, r3, r4);
        }

        private final boolean a(Class<?> r6) {
            if (r6 != null) goto L5;
            return true;
        L5:
            int r1 = this.x.length;
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L11;
            if (this.x[r3].isAssignableFrom(r6) == true) goto L9;
            r3 = r3 + 1;
            goto L6
        L9:
            return true;
        L11:
            return false;
        }
    }

    /* JADX INFO: compiled from: FilteredBeanPropertyWriter.java */
    private static final class b extends com.fasterxml.jackson.databind.j.d implements Serializable {
        protected final com.fasterxml.jackson.databind.j.d w;
        protected final Class<?> x;

        @Override // com.fasterxml.jackson.databind.j.d
        public /* synthetic */ com.fasterxml.jackson.databind.j.d a(com.fasterxml.jackson.databind.l.q r1) {
            return c(r1);
        }

        public b(com.fasterxml.jackson.databind.j.d r1, Class<?> r2) {
            super(r1);
            this.w = r1;
            this.x = r2;
        }

        public b c(com.fasterxml.jackson.databind.l.q r3) {
            return new b(this.w.a(r3), this.x);
        }

        @Override // com.fasterxml.jackson.databind.j.d
        public void a(com.fasterxml.jackson.databind.p<Object> r1) {
            this.w.a(r1);
        }

        @Override // com.fasterxml.jackson.databind.j.d
        public void b(com.fasterxml.jackson.databind.p<Object> r1) {
            this.w.b(r1);
        }

        @Override // com.fasterxml.jackson.databind.j.d, com.fasterxml.jackson.databind.j.o
        public void a(Object r3, com.fasterxml.jackson.a.h r4, ac r5) {
            Class<?> r0 = r5.e();
            if (r0 != null) goto L5;
        L8:
            this.w.a(r3, r4, r5);
            return;
        L5:
            if (this.x.isAssignableFrom(r0) == true) goto L8;
            this.w.b(r3, r4, r5);
        }

        @Override // com.fasterxml.jackson.databind.j.d
        public void c(Object r3, com.fasterxml.jackson.a.h r4, ac r5) {
            Class<?> r0 = r5.e();
            if (r0 != null) goto L5;
        L8:
            this.w.c(r3, r4, r5);
            return;
        L5:
            if (this.x.isAssignableFrom(r0) == true) goto L8;
            this.w.d(r3, r4, r5);
        }
    }

    public static com.fasterxml.jackson.databind.j.d a(com.fasterxml.jackson.databind.j.d r2, Class<?>[] r3) {
        if (r3.length != 1) goto L7;
        return new b(r2, r3[0]);
    L7:
        return new a(r2, r3);
    }
}
