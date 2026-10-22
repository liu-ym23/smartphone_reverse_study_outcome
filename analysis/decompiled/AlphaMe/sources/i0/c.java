package i0;

import androidx.room.AbstractC0351g;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f13001a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13002b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13003c;

    /* renamed from: d, reason: collision with root package name */
    public final List f13004d;

    /* renamed from: e, reason: collision with root package name */
    public final List f13005e;

    public c(String referenceTable, String onDelete, String onUpdate, List columnNames, List referenceColumnNames) {
        Intrinsics.checkNotNullParameter(referenceTable, "referenceTable");
        Intrinsics.checkNotNullParameter(onDelete, "onDelete");
        Intrinsics.checkNotNullParameter(onUpdate, "onUpdate");
        Intrinsics.checkNotNullParameter(columnNames, "columnNames");
        Intrinsics.checkNotNullParameter(referenceColumnNames, "referenceColumnNames");
        this.f13001a = referenceTable;
        this.f13002b = onDelete;
        this.f13003c = onUpdate;
        this.f13004d = columnNames;
        this.f13005e = referenceColumnNames;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (Intrinsics.areEqual(this.f13001a, cVar.f13001a) && Intrinsics.areEqual(this.f13002b, cVar.f13002b) && Intrinsics.areEqual(this.f13003c, cVar.f13003c) && Intrinsics.areEqual(this.f13004d, cVar.f13004d)) {
            return Intrinsics.areEqual(this.f13005e, cVar.f13005e);
        }
        return false;
    }

    public final int hashCode() {
        return this.f13005e.hashCode() + ((this.f13004d.hashCode() + AbstractC0351g.d(this.f13003c, AbstractC0351g.d(this.f13002b, this.f13001a.hashCode() * 31, 31), 31)) * 31);
    }

    public final String toString() {
        return "ForeignKey{referenceTable='" + this.f13001a + "', onDelete='" + this.f13002b + " +', onUpdate='" + this.f13003c + "', columnNames=" + this.f13004d + ", referenceColumnNames=" + this.f13005e + '}';
    }
}
