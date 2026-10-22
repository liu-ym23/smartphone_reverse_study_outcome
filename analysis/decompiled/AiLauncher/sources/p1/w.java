package p1;

import android.annotation.SuppressLint;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class w {

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"UnknownNullness"})
    public View f38222b;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f38221a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<j> f38223c = new ArrayList<>();

    @Deprecated
    public w() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f38222b == wVar.f38222b && this.f38221a.equals(wVar.f38221a);
    }

    public int hashCode() {
        return (this.f38222b.hashCode() * 31) + this.f38221a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f38222b + "\n") + "    values:";
        for (String str2 : this.f38221a.keySet()) {
            str = str + "    " + str2 + ": " + this.f38221a.get(str2) + "\n";
        }
        return str;
    }

    public w(View view) {
        this.f38222b = view;
    }
}
