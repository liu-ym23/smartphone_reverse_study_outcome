package ms.bd.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class m0 implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f39552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f39553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f39554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f39555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f39556e;
    public long f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f39557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f39558b;

        public a() {
        }

        public final String toString() {
            return String.format(Locale.US, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e4f5bf", new byte[]{49, 120, 68, 71, 17, 52, 40, 68, 49}), String.class, "com.obric.aiagent.plugin"), new Object[]{Float.valueOf(this.f39557a), Float.valueOf(this.f39558b)});
        }
    }

    static {
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "13b42e", new byte[0]), String.class, "com.obric.aiagent.plugin");
    }

    public m0() {
        this.f39556e = new a();
    }

    public final m0 a() {
        return (m0) ZeusTransformUtils.preCheckCast(super.clone(), m0.class, "com.obric.aiagent.plugin");
    L5:
        throw new AssertionError();
    }

    public final /* synthetic */ Object clone() {
        return a();
    }

    public final String toString() {
        this.f39556e.getClass();
        Locale r0 = Locale.US;
        String r1 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "c92395", new byte[]{55, 63, 13, 2, 2, 110, 37, 28, 47, 38, 118, 119, 4, 84}), String.class, "com.obric.aiagent.plugin");
        Object[] r2 = new Object[5];
        r2[0] = Long.valueOf(this.f39552a);
        r2[1] = Long.valueOf(this.f39553b);
        r2[2] = Long.valueOf(this.f39554c);
        long r3 = this.f39555d;
        long r5 = 0;
        if (r3 == 0) goto L6;
        r5 = this.f - r3;
    L6:
        r2[3] = Long.valueOf(r5);
        r2[4] = this.f39556e;
        return String.format(r0, r1, r2);
    }
}
