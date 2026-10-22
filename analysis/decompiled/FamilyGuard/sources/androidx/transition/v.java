package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class v {

    /* renamed from: b, reason: collision with root package name */
    public View f11493b;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f11492a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList<k> f11494c = new ArrayList<>();

    @Deprecated
    public v() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f11493b == vVar.f11493b && this.f11492a.equals(vVar.f11492a);
    }

    public int hashCode() {
        return (this.f11493b.hashCode() * 31) + this.f11492a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f11493b + "\n") + "    values:";
        for (String str2 : this.f11492a.keySet()) {
            str = str + "    " + str2 + ": " + this.f11492a.get(str2) + "\n";
        }
        return str;
    }

    public v(View view) {
        this.f11493b = view;
    }
}
