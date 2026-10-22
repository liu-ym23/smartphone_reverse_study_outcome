package d.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StringNumberConversionsJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
class v extends u {
    public v() {
    }

    public static final Float b(String r4) {
        d.h.b.o.e(r4, "<this>");
        if (n.f38658b.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L11;
        return Float.valueOf(Float.parseFloat(r4));
    L11:
        return null;
    L12:
        return null;
    }

    public static final Double c(String r4) {
        d.h.b.o.e(r4, "<this>");
        if (n.f38658b.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L11;
        return Double.valueOf(Double.parseDouble(r4));
    L11:
        return null;
    L12:
        return null;
    }
}
