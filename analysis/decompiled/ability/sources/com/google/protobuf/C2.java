package com.google.protobuf;

/* loaded from: classes3.dex */
public final class C2 implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2760a;
    public final J1 b;
    public final Descriptors$FieldDescriptor$JavaType c;

    public C2(D0 d02, Object obj) {
        if (obj instanceof J1) {
            this.b = (J1) obj;
        } else {
            this.f2760a = obj;
        }
        this.c = ((D0) d02.i().h().get(0)).g.f2824a;
    }

    public final Object a() {
        J1 j12 = this.b;
        if (j12 != null) {
            return j12.b;
        }
        return null;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        C2 c2 = (C2) obj;
        if (a() == null || c2.a() == null) {
            E2.f2828a.info("Invalid key for map field.");
            return -1;
        }
        int iOrdinal = this.c.ordinal();
        if (iOrdinal == 0) {
            Integer num = (Integer) a();
            num.intValue();
            Integer num2 = (Integer) c2.a();
            num2.intValue();
            return num.compareTo(num2);
        }
        if (iOrdinal == 1) {
            Long l = (Long) a();
            l.longValue();
            Long l5 = (Long) c2.a();
            l5.longValue();
            return l.compareTo(l5);
        }
        if (iOrdinal == 4) {
            Boolean bool = (Boolean) a();
            bool.booleanValue();
            Boolean bool2 = (Boolean) c2.a();
            bool2.booleanValue();
            return bool.compareTo(bool2);
        }
        if (iOrdinal != 5) {
            return 0;
        }
        String str = (String) a();
        String str2 = (String) c2.a();
        if (str == null && str2 == null) {
            return 0;
        }
        if (str == null && str2 != null) {
            return -1;
        }
        if (str == null || str2 != null) {
            return str.compareTo(str2);
        }
        return 1;
    }
}
