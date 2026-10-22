package A4;

import V3.v;
import i4.InterfaceC0772l;
import i4.q;
import j4.l;
import s4.InterfaceC1080k;
import x4.C1294F;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final q<Object, Object, Object, Object> f178a = a.f184a;

    /* renamed from: b, reason: collision with root package name */
    private static final C1294F f179b = new C1294F("STATE_REG");

    /* renamed from: c, reason: collision with root package name */
    private static final C1294F f180c = new C1294F("STATE_COMPLETED");

    /* renamed from: d, reason: collision with root package name */
    private static final C1294F f181d = new C1294F("STATE_CANCELLED");

    /* renamed from: e, reason: collision with root package name */
    private static final C1294F f182e = new C1294F("NO_RESULT");

    /* renamed from: f, reason: collision with root package name */
    private static final C1294F f183f = new C1294F("PARAM_CLAUSE_0");

    static final class a extends l implements q {

        /* renamed from: a, reason: collision with root package name */
        public static final a f184a = new a();

        a() {
            super(3);
        }

        @Override // i4.q
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Void a(Object obj, Object obj2, Object obj3) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d a(int i5) {
        if (i5 == 0) {
            return d.f185a;
        }
        if (i5 == 1) {
            return d.f186b;
        }
        if (i5 == 2) {
            return d.f187c;
        }
        if (i5 == 3) {
            return d.f188d;
        }
        throw new IllegalStateException(("Unexpected internal result: " + i5).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(InterfaceC1080k<? super v> interfaceC1080k, InterfaceC0772l<? super Throwable, v> interfaceC0772l) {
        Object objE = interfaceC1080k.e(v.f5542a, null, interfaceC0772l);
        if (objE == null) {
            return false;
        }
        interfaceC1080k.h(objE);
        return true;
    }
}
