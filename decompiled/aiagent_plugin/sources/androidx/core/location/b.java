package androidx.core.location;

import android.location.GnssStatus;
import androidx.core.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: GnssStatusWrapper.java */
/* JADX INFO: loaded from: classes.dex */
class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GnssStatus f1246a;

    b(Object r3) {
        this.f1246a = (GnssStatus) ZeusTransformUtils.preCheckCast(g.a((GnssStatus) ZeusTransformUtils.preCheckCast(r3, GnssStatus.class, "com.obric.aiagent.plugin")), GnssStatus.class, "com.obric.aiagent.plugin");
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L10;
        return false;
    L10:
        b r4 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
        return this.f1246a.equals(r4.f1246a);
    }

    public int hashCode() {
        return this.f1246a.hashCode();
    }
}
