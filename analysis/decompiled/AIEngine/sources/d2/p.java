package d2;

import android.annotation.SuppressLint;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"UnknownNullness"})
    public final View f8326b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f8325a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<i> f8327c = new ArrayList<>();

    @Deprecated
    public p() {
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f8326b == pVar.f8326b && this.f8325a.equals(pVar.f8325a);
    }

    public final int hashCode() {
        return this.f8325a.hashCode() + (this.f8326b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sbP = a0.a.p("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        sbP.append(this.f8326b);
        sbP.append("\n");
        String strJ = a0.a.j(sbP.toString(), "    values:");
        HashMap map = this.f8325a;
        for (String str : map.keySet()) {
            strJ = strJ + "    " + str + ": " + map.get(str) + "\n";
        }
        return strJ;
    }

    public p(View view) {
        this.f8326b = view;
    }
}
