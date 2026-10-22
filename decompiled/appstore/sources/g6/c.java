package g6;

import com.bytedance.retrofit2.mime.TypedInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f19990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TypedInput f19991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f19992f;

    public c(String r10, int r11, String r12, List r13, TypedInput r14) {
        if (r10 == null) goto L17;
        if (r11 < 200) goto L15;
        if (r12 == null) goto L13;
        if (r13 == null) goto L11;
        this.f19987a = r10;
        this.f19988b = r11;
        this.f19989c = r12;
        this.f19990d = Collections.unmodifiableList(new ArrayList(r13));
        this.f19991e = r14;
        return;
    L11:
        throw new IllegalArgumentException("headers == null");
    L13:
        throw new IllegalArgumentException("reason == null");
    L15:
        throw new IllegalArgumentException("Invalid status code: " + r11);
    L17:
        throw new IllegalArgumentException("url == null");
    }

    public TypedInput a() {
        return this.f19991e;
    }

    public Object b() {
        return this.f19992f;
    }

    public a c(String r10) {
        if (r10 == null) goto L13;
        List r11 = this.f19990d;
        if (r11 == null) goto L13;
        Iterator r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L13;
        a r13 = (a) r12.next();
        if (r10.equalsIgnoreCase(r13.a()) == false) goto L9;
        return r13;
    L13:
        return null;
    }

    public List d() {
        return this.f19990d;
    }

    public int e() {
        return this.f19988b;
    }

    public List f(String r10) {
        ArrayList r11 = null;
        if (r10 == null) goto L15;
        List r12 = this.f19990d;
        if (r12 == null) goto L15;
        Iterator r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L15;
        a r14 = (a) r13.next();
        if (r10.equalsIgnoreCase(r14.a()) == false) goto L9;
        if (r11 != null) goto L14;
        r11 = new ArrayList();
    L14:
        r11.add(r14);
    L15:
        return r11;
    }

    public boolean g() {
        int r10 = this.f19988b;
        if (r10 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r10 >= 300) goto L7;
        return true;
    }

    public void h(Object r10) {
        this.f19992f = r10;
    }
}
