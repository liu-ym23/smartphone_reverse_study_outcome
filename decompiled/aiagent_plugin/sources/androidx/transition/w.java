package androidx.transition;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: TransitionValues.java */
/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f2869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f2870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayList<s> f2871c;

    @Deprecated
    public w() {
        this.f2869a = new HashMap();
        this.f2871c = new ArrayList();
    }

    public w(View r2) {
        this.f2869a = new HashMap();
        this.f2871c = new ArrayList();
        this.f2870b = r2;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, w.class) == true) goto L5;
        return false;
    L5:
        if (this.f2870b == ((w) ZeusTransformUtils.preCheckCast(r5, w.class, "com.obric.aiagent.plugin")).f2870b) goto L7;
        return false;
    L7:
        if (this.f2869a.equals(((w) ZeusTransformUtils.preCheckCast(r5, w.class, "com.obric.aiagent.plugin")).f2869a) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public int hashCode() {
        return (this.f2870b.hashCode() * 31) + this.f2869a.hashCode();
    }

    public String toString() {
        String r0 = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f2870b + "\n") + "    values:";
        Iterator<String> r2 = this.f2869a.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");
        r0 = r0 + "    " + r3 + ": " + this.f2869a.get(r3) + "\n";
        goto L4
    L6:
        return r0;
    }
}
