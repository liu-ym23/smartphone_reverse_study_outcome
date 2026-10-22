package d.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Appendable.kt */
/* JADX INFO: loaded from: classes4.dex */
class p {
    public p() {
    }

    public static final <T> void a(Appendable r2, T r3, d.h.a.b<? super T, ? extends CharSequence> r4) {
        Appendable r5 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r2, Appendable.class, "com.obric.aiagent.plugin");
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (r6 == null) goto L5;
        r5.append((CharSequence) ZeusTransformUtils.preCheckCast(r6.invoke(r3), CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (r3 != null) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == false) goto L11;
        r5.append((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r3, Character.class) == false) goto L13;
        r5.append(((Character) ZeusTransformUtils.preCheckCast(r3, Character.class, "com.obric.aiagent.plugin")).charValue());
        return;
    L13:
        r5.append((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r3), CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        r7 = ZeusTransformUtils.instanceOf(r3, CharSequence.class);
        goto L8
    }
}
