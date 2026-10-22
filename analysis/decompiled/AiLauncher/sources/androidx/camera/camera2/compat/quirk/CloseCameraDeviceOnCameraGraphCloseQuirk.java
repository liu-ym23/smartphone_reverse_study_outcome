package androidx.camera.camera2.compat.quirk;

import K.s0;
import android.annotation.SuppressLint;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import q.d;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/compat/quirk/CloseCameraDeviceOnCameraGraphCloseQuirk;", "LK/s0;", "<init>", "()V", "", "isExtensions", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Z)Z", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CameraXQuirksClassDetector"})
/* loaded from: classes.dex */
public final class CloseCameraDeviceOnCameraGraphCloseQuirk implements s0 {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f9417c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f9418d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f9419e;

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f9420f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f9421g;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/compat/quirk/CloseCameraDeviceOnCameraGraphCloseQuirk$a;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()Z", "isSamsungExynos7570Device", "Z", "isSamsungExynos7870Device", "isXiaomiProblematicDevice", "isSonyProblematicDevice", "isSamsungProblematicDevice", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.CloseCameraDeviceOnCameraGraphCloseQuirk$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean a() {
            return CloseCameraDeviceOnCameraGraphCloseQuirk.f9417c || CloseCameraDeviceOnCameraGraphCloseQuirk.f9418d || d.f38469a.s() || CloseCameraDeviceOnCameraGraphCloseQuirk.f9419e || CloseCameraDeviceOnCameraGraphCloseQuirk.f9421g || CloseCameraDeviceOnCameraGraphCloseQuirk.f9420f;
        }

        public Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
    static {
        /*
            androidx.camera.camera2.compat.quirk.CloseCameraDeviceOnCameraGraphCloseQuirk$a r0 = new androidx.camera.camera2.compat.quirk.CloseCameraDeviceOnCameraGraphCloseQuirk$a
            r1 = 0
            r0.<init>(r1)
            androidx.camera.camera2.compat.quirk.CloseCameraDeviceOnCameraGraphCloseQuirk.INSTANCE = r0
            java.lang.String r0 = android.os.Build.HARDWARE
            java.lang.String r1 = "samsungexynos7570"
            boolean r1 = kotlin.jvm.internal.p.d(r0, r1)
            androidx.camera.camera2.compat.quirk.CloseCameraDeviceOnCameraGraphCloseQuirk.f9417c = r1
            java.lang.String r1 = "samsungexynos7870"
            boolean r0 = kotlin.jvm.internal.p.d(r0, r1)
            androidx.camera.camera2.compat.quirk.CloseCameraDeviceOnCameraGraphCloseQuirk.f9418d = r0
            q.d r0 = q.d.f38469a
            boolean r1 = r0.t()
            java.lang.String r2 = "DEVICE"
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L46
            java.lang.String r1 = "aurora"
            java.lang.String r5 = "houji"
            java.lang.String[] r1 = new java.lang.String[]{r1, r5}
            java.lang.String r5 = android.os.Build.DEVICE
            kotlin.jvm.internal.p.h(r5, r2)
            java.util.Locale r6 = java.util.Locale.ROOT
            java.lang.String r5 = r5.toLowerCase(r6)
            java.lang.String r6 = "toLowerCase(...)"
            kotlin.jvm.internal.p.h(r5, r6)
            boolean r1 = Z8.r.R(r1, r5)
            if (r1 == 0) goto L46
            r1 = r4
            goto L47
        L46:
            r1 = r3
        L47:
            androidx.camera.camera2.compat.quirk.CloseCameraDeviceOnCameraGraphCloseQuirk.f9419e = r1
            boolean r0 = r0.p()
            if (r0 == 0) goto L8a
            java.lang.String r0 = "SO"
            java.lang.String r1 = "A301SO"
            java.lang.String r5 = "XQ-DQ"
            java.lang.String[] r0 = new java.lang.String[]{r5, r0, r1}
            java.util.List r0 = Z8.C1173v.p(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L6d
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L6d
            goto L8a
        L6d:
            java.util.Iterator r0 = r0.iterator()
        L71:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L8a
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r5 = android.os.Build.DEVICE
            kotlin.jvm.internal.p.h(r5, r2)
            boolean r1 = La.D.V(r5, r1, r4)
            if (r1 == 0) goto L71
            r0 = r4
            goto L8b
        L8a:
            r0 = r3
        L8b:
            androidx.camera.camera2.compat.quirk.CloseCameraDeviceOnCameraGraphCloseQuirk.f9420f = r0
            q.d r0 = q.d.f38469a
            boolean r0 = r0.o()
            if (r0 == 0) goto L9c
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 34
            if (r0 > r1) goto L9c
            r3 = r4
        L9c:
            androidx.camera.camera2.compat.quirk.CloseCameraDeviceOnCameraGraphCloseQuirk.f9421g = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.compat.quirk.CloseCameraDeviceOnCameraGraphCloseQuirk.<clinit>():void");
    }

    public final boolean h(boolean isExtensions) {
        if (f9419e || !(!f9421g || f9417c || f9418d)) {
            return isExtensions;
        }
        return true;
    }
}
