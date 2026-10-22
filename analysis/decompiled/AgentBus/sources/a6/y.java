package a6;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final Set f383a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f384b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f385c;

    /* renamed from: d, reason: collision with root package name */
    public final Boolean f386d;

    /* renamed from: e, reason: collision with root package name */
    public final Boolean f387e;

    /* renamed from: f, reason: collision with root package name */
    public final Long f388f;

    public y(HashSet hashSet, Set set, Set set2, Boolean bool, Boolean bool2, Long l6) {
        this.f383a = hashSet;
        this.f384b = set;
        this.f385c = set2;
        this.f386d = bool;
        this.f387e = bool2;
        this.f388f = l6;
    }

    public final boolean a() {
        return this.f383a == null && this.f384b == null && this.f385c == null && this.f386d == null && this.f387e == null && this.f388f == null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return q7.k.a(this.f383a, yVar.f383a) && q7.k.a(this.f384b, yVar.f384b) && q7.k.a(this.f385c, yVar.f385c) && q7.k.a(this.f386d, yVar.f386d) && q7.k.a(this.f387e, yVar.f387e) && q7.k.a(this.f388f, yVar.f388f);
    }

    public final int hashCode() {
        Set set = this.f383a;
        int iHashCode = (set == null ? 0 : set.hashCode()) * 31;
        Set set2 = this.f384b;
        int iHashCode2 = (iHashCode + (set2 == null ? 0 : set2.hashCode())) * 31;
        Set set3 = this.f385c;
        int iHashCode3 = (iHashCode2 + (set3 == null ? 0 : set3.hashCode())) * 31;
        Boolean bool = this.f386d;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.f387e;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Long l6 = this.f388f;
        return iHashCode5 + (l6 != null ? l6.hashCode() : 0);
    }

    public final String toString() {
        return "SkillFilter(sources=" + this.f383a + ", tagsAny=" + this.f384b + ", tagsAll=" + this.f385c + ", enabled=" + this.f386d + ", hasSkillMd=" + this.f387e + ", modifiedOnOrAfterMs=" + this.f388f + ")";
    }
}
