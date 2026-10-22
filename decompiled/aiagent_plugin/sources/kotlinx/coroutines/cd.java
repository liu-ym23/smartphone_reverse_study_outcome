package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes4.dex */
public class cd extends ci implements z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f39183b;

    @Override // kotlinx.coroutines.ci
    public boolean m_() {
        return true;
    }

    public cd(ca r3) {
        ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
        super(true);
        a(r4);
        this.f39183b = g();
    }

    @Override // kotlinx.coroutines.ci
    public boolean q_() {
        return this.f39183b;
    }

    private final boolean g() {
        t r4 = m();
        if (ZeusTransformUtils.instanceOf(r4, u.class) == false) goto L5;
        u r5 = (u) ZeusTransformUtils.preCheckCast(r4, u.class, "com.obric.aiagent.plugin");
    L7:
        if (r5 == null) goto L22;
        ci r6 = r5.c();
        if (r6 == null) goto L22;
    L12:
        if (r6.q_() == true) goto L13;
        t r7 = r6.m();
        if (ZeusTransformUtils.instanceOf(r7, u.class) == false) goto L18;
        u r8 = (u) ZeusTransformUtils.preCheckCast(r7, u.class, "com.obric.aiagent.plugin");
    L19:
        if (r8 == null) goto L22;
        r6 = r8.c();
        if (r6 != null) goto L12;
    L18:
        r8 = null;
        goto L19
    L13:
        return true;
    L22:
        return false;
    L5:
        r5 = null;
        goto L7
    }
}
