package x;

import android.app.admin.DevicePolicyManager;
import android.os.Trace;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\t¨\u0006\u000b"}, d2 = {"Lx/f;", "Lx/s0;", "Landroid/app/admin/DevicePolicyManager;", "devicePolicyManager", "<init>", "(Landroid/app/admin/DevicePolicyManager;)V", Const.INTENT_KEY_APIKEY, "Landroid/app/admin/DevicePolicyManager;", "", "()Z", "camerasDisabled", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5813f implements s0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final DevicePolicyManager devicePolicyManager;

    public C5813f(DevicePolicyManager devicePolicyManager) {
        kotlin.jvm.internal.p.i(devicePolicyManager, "devicePolicyManager");
        this.devicePolicyManager = devicePolicyManager;
    }

    @Override // x.s0
    public boolean a() {
        z.h hVar = z.h.f44503a;
        try {
            Trace.beginSection("DevicePolicyManager#getCameraDisabled");
            return this.devicePolicyManager.getCameraDisabled(null);
        } finally {
            Trace.endSection();
        }
    }
}
