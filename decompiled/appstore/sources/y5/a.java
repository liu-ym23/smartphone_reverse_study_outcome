package y5;

import d6.h;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class a extends w5.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f26126g;

    /* JADX INFO: renamed from: y5.a$a, reason: collision with other inner class name */
    public static class C0413a extends w5.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public w5.c f26127a;

        public C0413a(w5.c r10) {
            this.f26127a = r10;
        }

        @Override // w5.b
        public Object a(Object r10, Method r11, Object[] r12, Object r13) {
            return h.a(this.f26127a.e(), this.f26127a);
        }

        @Override // w5.b
        public Object b(Object r10, Method r11, Object[] r12) {
            return super.b(r10, r11, r12);
        }
    }

    public a(String r10, w5.c r11) {
        this.f26126g = r10;
        this.f25366a.put("queryLocalInterface", new C0413a(r11));
    }

    public void i() {
        new c(this.f26126g, this).a();
    }
}
