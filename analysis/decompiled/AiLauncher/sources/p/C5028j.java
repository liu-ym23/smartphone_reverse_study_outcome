package p;

import D.B;
import D.C0761b0;
import Z8.Y;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import p.C5027i;
import t.C5473b;
import u.C5555c;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lp/j;", "Lp/i$b;", "Landroid/hardware/camera2/params/DynamicRangeProfiles;", "dynamicRangeProfiles", "<init>", "(Landroid/hardware/camera2/params/DynamicRangeProfiles;)V", "LD/B;", "dynamicRange", "", Const.INTENT_KEY_PKGNAME, "(LD/B;)Ljava/util/Set;", Const.INTENT_KEY_APIKEY, "()Landroid/hardware/camera2/params/DynamicRangeProfiles;", "", Const.INTENT_KEY_UMID, "(LD/B;)Ljava/lang/Long;", "profile", "f", "(J)LD/B;", "profileSet", "e", "(Ljava/util/Set;)Ljava/util/Set;", "Landroid/hardware/camera2/params/DynamicRangeProfiles;", "c", "()Ljava/util/Set;", "supportedDynamicRanges", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: p.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5028j implements C5027i.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final DynamicRangeProfiles dynamicRangeProfiles;

    public C5028j(DynamicRangeProfiles dynamicRangeProfiles) {
        kotlin.jvm.internal.p.i(dynamicRangeProfiles, "dynamicRangeProfiles");
        this.dynamicRangeProfiles = dynamicRangeProfiles;
    }

    @Override // p.C5027i.b
    /* renamed from: a, reason: from getter */
    public DynamicRangeProfiles getDynamicRangeProfiles() {
        return this.dynamicRangeProfiles;
    }

    @Override // p.C5027i.b
    public Set<B> b(B dynamicRange) {
        kotlin.jvm.internal.p.i(dynamicRange, "dynamicRange");
        Long lD = d(dynamicRange);
        if (lD != null) {
            Set<Long> profileCaptureRequestConstraints = this.dynamicRangeProfiles.getProfileCaptureRequestConstraints(lD.longValue());
            kotlin.jvm.internal.p.h(profileCaptureRequestConstraints, "getProfileCaptureRequestConstraints(...)");
            return e(profileCaptureRequestConstraints);
        }
        throw new IllegalArgumentException(("DynamicRange is not supported: " + dynamicRange).toString());
    }

    @Override // p.C5027i.b
    public Set<B> c() {
        Set<Long> supportedProfiles = this.dynamicRangeProfiles.getSupportedProfiles();
        kotlin.jvm.internal.p.h(supportedProfiles, "getSupportedProfiles(...)");
        return e(supportedProfiles);
    }

    public final Long d(B dynamicRange) {
        return C5555c.f42362a.a(dynamicRange, this.dynamicRangeProfiles);
    }

    public final Set<B> e(Set<Long> profileSet) {
        if (profileSet.isEmpty()) {
            return Y.e();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Long> it = profileSet.iterator();
        while (it.hasNext()) {
            B bF = f(it.next().longValue());
            if (bF != null) {
                linkedHashSet.add(bF);
            }
        }
        Set<B> setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        kotlin.jvm.internal.p.h(setUnmodifiableSet, "unmodifiableSet(...)");
        return setUnmodifiableSet;
    }

    public final B f(long profile) {
        B b10 = C5555c.f42362a.b(profile);
        if (b10 == null) {
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.k("CXCP")) {
                Log.w(C5473b.TRUNCATED_TAG, "Dynamic range profile cannot be converted to a DynamicRange object: " + profile);
            }
        }
        return b10;
    }
}
