package d.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ReflectionFactory.java */
/* JADX INFO: loaded from: classes4.dex */
public class ab {
    public d.m.e a(k r1) {
        return r1;
    }

    public d.m.g a(r r1) {
        return r1;
    }

    public d.m.i a(v r1) {
        return r1;
    }

    public d.m.j a(x r1) {
        return r1;
    }

    public ab() {
    }

    public d.m.d a(Class r1, String r2) {
        return new t(r1, r2);
    }

    public d.m.c a(Class r1) {
        return new f(r1);
    }

    public String a(p r1) {
        return a(r1);
    }

    public String a(j r2) {
        String r1 = ((j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin")).getClass().getGenericInterfaces()[0].toString();
        if (r1.startsWith("kotlin.jvm.functions.") == true) goto L5;
        return r1;
    L5:
        return r1.substring(21);
    }
}
