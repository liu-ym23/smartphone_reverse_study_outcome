package d.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PropertyReference1Impl.java */
/* JADX INFO: loaded from: classes4.dex */
public class y extends x {
    public y(d.m.d r9, String r10, String r11) {
        d.m.d r12 = (d.m.d) ZeusTransformUtils.wrapperContextForParams(r9, d.m.d.class, "com.obric.aiagent.plugin");
        super(NO_RECEIVER, ((e) ZeusTransformUtils.preCheckCast(r12, e.class, "com.obric.aiagent.plugin")).a(), r10, r11, !ZeusTransformUtils.instanceOf(r12, d.m.c.class) ? 1 : 0);
    }

    public y(Class r7, String r8, String r9, int r10) {
        super(NO_RECEIVER, r7, r8, r9, r10);
    }

    public Object a(Object r3) {
        return a().call(new Object[]{r3});
    }
}
