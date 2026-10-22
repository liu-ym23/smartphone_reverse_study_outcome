package j5;

import g5.c;
import j5.a;
import j5.b;
import j5.c;
import java.sql.Date;
import java.sql.Timestamp;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f9702a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f9703b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f9704c;

    /* renamed from: d, reason: collision with root package name */
    public static final a.C0095a f9705d;

    /* renamed from: e, reason: collision with root package name */
    public static final b.a f9706e;

    /* renamed from: f, reason: collision with root package name */
    public static final c.a f9707f;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends c.b<Date> {
        @Override // g5.c.b
        public final java.util.Date a(java.util.Date date) {
            return new Date(date.getTime());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends c.b<Timestamp> {
        @Override // g5.c.b
        public final java.util.Date a(java.util.Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        f9702a = z;
        if (z) {
            f9703b = new a(Date.class);
            f9704c = new b(Timestamp.class);
            f9705d = j5.a.f9696b;
            f9706e = j5.b.f9698b;
            f9707f = c.f9700b;
            return;
        }
        f9703b = null;
        f9704c = null;
        f9705d = null;
        f9706e = null;
        f9707f = null;
    }
}
