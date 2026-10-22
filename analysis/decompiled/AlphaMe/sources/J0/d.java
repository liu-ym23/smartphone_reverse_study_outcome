package J0;

import androidx.room.AbstractC0351g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final List f867a;

    /* renamed from: b, reason: collision with root package name */
    public final char f868b;

    /* renamed from: c, reason: collision with root package name */
    public final double f869c;

    /* renamed from: d, reason: collision with root package name */
    public final String f870d;

    /* renamed from: e, reason: collision with root package name */
    public final String f871e;

    public d(ArrayList arrayList, char c4, double d4, String str, String str2) {
        this.f867a = arrayList;
        this.f868b = c4;
        this.f869c = d4;
        this.f870d = str;
        this.f871e = str2;
    }

    public final int hashCode() {
        return this.f870d.hashCode() + AbstractC0351g.d(this.f871e, this.f868b * 31, 31);
    }
}
