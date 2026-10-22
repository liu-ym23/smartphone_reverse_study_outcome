package io.objectbox.relation;

import T8.e;
import java.io.Serializable;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class ToOne<TARGET> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f34381a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f34382b;

    /* renamed from: c, reason: collision with root package name */
    public transient Field f34383c;

    /* renamed from: d, reason: collision with root package name */
    public long f34384d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f34385e;

    public long a() {
        if (this.f34382b) {
            return this.f34384d;
        }
        Field fieldB = b();
        try {
            Long l10 = (Long) fieldB.get(this.f34381a);
            if (l10 != null) {
                return l10.longValue();
            }
            return 0L;
        } catch (IllegalAccessException unused) {
            throw new RuntimeException("Could not access field " + fieldB);
        }
    }

    public final Field b() {
        Field field = this.f34383c;
        if (field != null) {
            return field;
        }
        e.a();
        this.f34381a.getClass();
        throw null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ToOne)) {
            return false;
        }
        ToOne toOne = (ToOne) obj;
        toOne.getClass();
        return a() == toOne.a();
    }

    public int hashCode() {
        long jA = a();
        return (int) (jA ^ (jA >>> 32));
    }

    public void setTargetId(long j10) throws IllegalAccessException, IllegalArgumentException {
        if (this.f34382b) {
            this.f34384d = j10;
        } else {
            try {
                b().set(this.f34381a, Long.valueOf(j10));
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Could not update to-one ID in entity", e10);
            }
        }
        if (j10 != 0) {
            this.f34385e = false;
        }
    }
}
