package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import androidx.core.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: GpsStatusWrapper.java */
/* JADX INFO: loaded from: classes.dex */
class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GpsStatus f1247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Iterator<GpsSatellite> f1249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private GpsSatellite f1251e;

    c(GpsStatus r3) {
        GpsStatus r4 = (GpsStatus) ZeusTransformUtils.preCheckCast(g.a(r3), GpsStatus.class, "com.obric.aiagent.plugin");
        this.f1247a = r4;
        this.f1248b = -1;
        this.f1249c = r4.getSatellites().iterator();
        this.f1250d = -1;
        this.f1251e = null;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L10;
        return false;
    L10:
        c r4 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin");
        return this.f1247a.equals(r4.f1247a);
    }

    public int hashCode() {
        return this.f1247a.hashCode();
    }
}
