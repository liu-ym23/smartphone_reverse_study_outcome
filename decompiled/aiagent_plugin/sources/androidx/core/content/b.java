package androidx.core.content;

import android.content.LocusId;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LocusIdCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocusId f1150b;

    public int hashCode() {
        String r1 = this.f1149a;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return 31 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L11;
        return false;
    L11:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        String r4 = this.f1149a;
        if (r4 != null) goto L19;
        if (r6.f1149a != null) goto L17;
        return true;
    L17:
        return false;
    L19:
        return r4.equals(r6.f1149a);
    }

    public String toString() {
        return "LocusIdCompat[" + b() + "]";
    }

    public LocusId a() {
        return this.f1150b;
    }

    private String b() {
        return this.f1149a.length() + "_chars";
    }
}
