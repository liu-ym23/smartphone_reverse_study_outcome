package o0;

import android.view.View;
import androidx.room.AbstractC0351g;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: o0.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0785A {

    /* renamed from: b, reason: collision with root package name */
    public final View f13674b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f13673a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f13675c = new ArrayList();

    public C0785A(View view) {
        this.f13674b = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0785A)) {
            return false;
        }
        C0785A c0785a = (C0785A) obj;
        return this.f13674b == c0785a.f13674b && this.f13673a.equals(c0785a.f13673a);
    }

    public final int hashCode() {
        return this.f13673a.hashCode() + (this.f13674b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sbV = B0.g.v("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        sbV.append(this.f13674b);
        sbV.append("\n");
        String strP = AbstractC0351g.p(sbV.toString(), "    values:");
        HashMap map = this.f13673a;
        for (String str : map.keySet()) {
            strP = strP + "    " + str + ": " + map.get(str) + "\n";
        }
        return strP;
    }
}
