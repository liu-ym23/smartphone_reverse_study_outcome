package O0;

import android.util.JsonReader;

/* loaded from: classes.dex */
public final class d implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1526a = new d();

    @Override // O0.k
    public final Object a(JsonReader jsonReader, float f4) {
        return Integer.valueOf(Math.round(com.stepos.statsrpk.c.Q(jsonReader) * f4));
    }
}
