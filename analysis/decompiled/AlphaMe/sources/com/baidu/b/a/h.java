package com.baidu.b.a;

import com.baidu.b.a.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class h extends g {

    /* renamed from: f, reason: collision with root package name */
    private a f4722f;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Class f4723a;

        /* renamed from: b, reason: collision with root package name */
        private Method f4724b;

        /* renamed from: c, reason: collision with root package name */
        private Method f4725c;

        private a() {
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object b() throws Exception {
            return this.f4723a.newInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long a(Object obj) throws e.a {
            try {
                return ((Long) this.f4725c.invoke(obj, new Object[0])).longValue();
            } catch (Exception unused) {
                throw new e.a("");
            }
        }

        private void a() {
            try {
                this.f4723a = Class.forName(e.a(d.a()), true, Object.class.getClassLoader());
                String strA = e.a(d.b());
                Class cls = this.f4723a;
                Class cls2 = Integer.TYPE;
                this.f4724b = e.a(cls, strA, new Class[]{byte[].class, cls2, cls2});
                this.f4725c = e.a(this.f4723a, e.a(d.c()), null);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Object obj, byte[] bArr, int i4, int i5) throws IllegalAccessException, IllegalArgumentException, e.a, InvocationTargetException {
            try {
                this.f4724b.invoke(obj, bArr, Integer.valueOf(i4), Integer.valueOf(i5));
            } catch (Exception unused) {
                throw new e.a("");
            }
        }
    }

    public h(int i4, int i5) {
        this.f4717a = 1099511627775L;
        this.f4718b = 4;
        this.f4719c = 32;
        this.f4720d = i4;
        this.f4721e = i5;
        this.f4722f = new a();
    }

    @Override // com.baidu.b.a.g
    public b a(byte[] bArr, int i4, int i5) {
        long jA;
        try {
            Object objB = this.f4722f.b();
            this.f4722f.a(objB, bArr, i4, i5);
            jA = this.f4722f.a(objB);
        } catch (Exception unused) {
            jA = 4294967295L;
        }
        return b.a(new long[]{jA});
    }
}
