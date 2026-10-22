package k1;

import android.widget.EditText;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final C0098a f9834a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: k1.a$a, reason: collision with other inner class name */
    public static class C0098a extends b {

        /* renamed from: a, reason: collision with root package name */
        public final EditText f9835a;

        /* renamed from: b, reason: collision with root package name */
        public final g f9836b;

        public C0098a(EditText editText) {
            this.f9835a = editText;
            g gVar = new g(editText);
            this.f9836b = gVar;
            editText.addTextChangedListener(gVar);
            if (k1.b.f9838b == null) {
                synchronized (k1.b.f9837a) {
                    try {
                        if (k1.b.f9838b == null) {
                            k1.b bVar = new k1.b();
                            try {
                                k1.b.f9839c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, k1.b.class.getClassLoader());
                            } catch (Throwable unused) {
                            }
                            k1.b.f9838b = bVar;
                        }
                    } finally {
                    }
                }
            }
            editText.setEditableFactory(k1.b.f9838b);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {
    }

    public a(EditText editText) {
        this.f9834a = new C0098a(editText);
    }
}
