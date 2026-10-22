package org.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.b.b.j;
import org.b.e;

/* JADX INFO: compiled from: SubstituteLoggingEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b f40271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    List<e> f40272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f40273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    j f40274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f40275e;
    String f;
    Object[] g;
    long h;
    Throwable i;

    public d() {
    }

    public b a() {
        return this.f40271a;
    }

    public void a(b r1) {
        this.f40271a = r1;
    }

    public void a(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return;
    L6:
        if (this.f40272b != null) goto L8;
        this.f40272b = new ArrayList(2);
    L8:
        this.f40272b.add(r4);
    }

    public void a(String r1) {
        this.f40273c = r1;
    }

    public j b() {
        return this.f40274d;
    }

    public void a(j r1) {
        this.f40274d = r1;
    }

    public void b(String r1) {
        this.f = r1;
    }

    public void a(Object[] r1) {
        this.g = r1;
    }

    public void a(long r1) {
        this.h = r1;
    }

    public void c(String r1) {
        this.f40275e = r1;
    }

    public void a(Throwable r1) {
        this.i = r1;
    }
}
