package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f5085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f5086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f5087c;

    public s(View r10) {
        this.f5085a = new HashMap();
        this.f5087c = new ArrayList();
        this.f5086b = r10;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof s) == false) goto L10;
        s r11 = (s) r10;
        if (this.f5086b == r11.f5086b) goto L7;
        return false;
    L7:
        if (this.f5085a.equals(r11.f5085a) == false) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        return (this.f5086b.hashCode() * 31) + this.f5085a.hashCode();
    }

    public String toString() {
        String r10 = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f5086b + "\n") + "    values:";
        Iterator r11 = this.f5085a.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        String r12 = (String) r11.next();
        r10 = r10 + "    " + r12 + ": " + this.f5085a.get(r12) + "\n";
        goto L4
    L6:
        return r10;
    }
}
