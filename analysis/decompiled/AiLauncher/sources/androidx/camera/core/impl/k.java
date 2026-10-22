package androidx.camera.core.impl;

import D.C0761b0;
import D.C0777n;
import K.N;
import Z8.C1174w;
import Z8.F;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.CameraValidator;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001c2\u00020\u0001:\u0003\u000b$\u0013B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0013\u001a\u00020\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0017\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001eR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u0014\u0010!\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010 R\u0014\u0010#\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\"¨\u0006%"}, d2 = {"Landroidx/camera/core/impl/k;", "Landroidx/camera/core/impl/CameraValidator;", "Landroid/content/Context;", "context", "Landroidx/camera/core/CameraSelector;", "availableCamerasSelector", "<init>", "(Landroid/content/Context;Landroidx/camera/core/CameraSelector;)V", "LK/N;", "cameraRepository", "LY8/t;", "c", "(LK/N;)V", "", "Landroidx/camera/core/impl/CameraInternal;", "currentCameras", "LD/n;", "removedCameras", "", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Set;Ljava/util/Set;)Z", "cameras", "selector", "e", "(Ljava/util/Set;Landroidx/camera/core/CameraSelector;)Z", "Landroidx/camera/core/impl/k$c;", Const.INTENT_KEY_UMID, "()Landroidx/camera/core/impl/k$c;", "f", "(Landroid/content/Context;)Z", "Landroid/content/Context;", "Landroidx/camera/core/CameraSelector;", "Z", "isVirtualDevice", "Landroidx/camera/core/impl/k$c;", "validationCriteria", Const.INTENT_KEY_APIKEY, "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class k implements CameraValidator {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final CameraSelector availableCamerasSelector;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final boolean isVirtualDevice;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final ValidationCriteria validationCriteria;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/camera/core/impl/k$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)I", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f11438a = new a();

        public final int a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            return context.getDeviceId();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0011\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"Landroidx/camera/core/impl/k$c;", "", "", "checkBack", "checkFront", "<init>", "(ZZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Z", "()Z", Const.INTENT_KEY_PKGNAME, "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.core.impl.k$c, reason: from toString */
    public static final /* data */ class ValidationCriteria {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean checkBack;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean checkFront;

        public ValidationCriteria(boolean z10, boolean z11) {
            this.checkBack = z10;
            this.checkFront = z11;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getCheckBack() {
            return this.checkBack;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getCheckFront() {
            return this.checkFront;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ValidationCriteria)) {
                return false;
            }
            ValidationCriteria validationCriteria = (ValidationCriteria) other;
            return this.checkBack == validationCriteria.checkBack && this.checkFront == validationCriteria.checkFront;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.checkBack) * 31) + Boolean.hashCode(this.checkFront);
        }

        public String toString() {
            return "ValidationCriteria(checkBack=" + this.checkBack + ", checkFront=" + this.checkFront + ')';
        }
    }

    public k(Context context, CameraSelector cameraSelector) {
        kotlin.jvm.internal.p.i(context, "context");
        this.context = context;
        this.availableCamerasSelector = cameraSelector;
        this.isVirtualDevice = f(context);
        this.validationCriteria = d();
    }

    @Override // androidx.camera.core.impl.CameraValidator
    public boolean b(Set<? extends CameraInternal> currentCameras, Set<C0777n> removedCameras) {
        kotlin.jvm.internal.p.i(currentCameras, "currentCameras");
        kotlin.jvm.internal.p.i(removedCameras, "removedCameras");
        if (this.isVirtualDevice || !(this.validationCriteria.getCheckBack() || this.validationCriteria.getCheckFront())) {
            return false;
        }
        CameraSelector DEFAULT_BACK_CAMERA = CameraSelector.f11144d;
        kotlin.jvm.internal.p.h(DEFAULT_BACK_CAMERA, "DEFAULT_BACK_CAMERA");
        boolean zE = e(currentCameras, DEFAULT_BACK_CAMERA);
        CameraSelector DEFAULT_FRONT_CAMERA = CameraSelector.f11143c;
        kotlin.jvm.internal.p.h(DEFAULT_FRONT_CAMERA, "DEFAULT_FRONT_CAMERA");
        boolean zE2 = e(currentCameras, DEFAULT_FRONT_CAMERA);
        Set<C0777n> set = removedCameras;
        ArrayList arrayList = new ArrayList(C1174w.x(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((C0777n) it.next()).b());
        }
        Set setR1 = F.r1(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : currentCameras) {
            if (!setR1.contains(((CameraInternal) obj).i().h())) {
                arrayList2.add(obj);
            }
        }
        Set<? extends CameraInternal> setR12 = F.r1(arrayList2);
        CameraSelector DEFAULT_BACK_CAMERA2 = CameraSelector.f11144d;
        kotlin.jvm.internal.p.h(DEFAULT_BACK_CAMERA2, "DEFAULT_BACK_CAMERA");
        boolean zE3 = e(setR12, DEFAULT_BACK_CAMERA2);
        CameraSelector DEFAULT_FRONT_CAMERA2 = CameraSelector.f11143c;
        kotlin.jvm.internal.p.h(DEFAULT_FRONT_CAMERA2, "DEFAULT_FRONT_CAMERA");
        return (this.validationCriteria.getCheckBack() && zE && !zE3) || (this.validationCriteria.getCheckFront() && zE2 && !e(setR12, DEFAULT_FRONT_CAMERA2));
    }

    @Override // androidx.camera.core.impl.CameraValidator
    public void c(N cameraRepository) throws CameraValidator.CameraIdListIncorrectException {
        kotlin.jvm.internal.p.i(cameraRepository, "cameraRepository");
        if (this.isVirtualDevice) {
            C0761b0.a("CameraValidator", "Virtual device with " + cameraRepository.m().size() + " cameras. Skipping validation.");
            return;
        }
        C0761b0.a("CameraValidator", "Verifying camera lens facing on " + Build.DEVICE);
        if (this.validationCriteria.getCheckBack()) {
            try {
                kotlin.jvm.internal.p.f(CameraSelector.f11144d.g(cameraRepository.m()));
                e = null;
            } catch (RuntimeException e10) {
                e = e10;
                C0761b0.p("CameraValidator", "Camera LENS_FACING_BACK verification failed", e);
            }
        } else {
            e = null;
        }
        if (this.validationCriteria.getCheckFront()) {
            try {
                kotlin.jvm.internal.p.f(CameraSelector.f11143c.g(cameraRepository.m()));
            } catch (RuntimeException e11) {
                C0761b0.p("CameraValidator", "Camera LENS_FACING_FRONT verification failed", e11);
                if (e == null) {
                    e = e11;
                }
            }
        }
        if (e != null) {
            throw new CameraValidator.CameraIdListIncorrectException("Expected camera missing from device.", cameraRepository.m().size(), e);
        }
    }

    public final ValidationCriteria d() {
        PackageManager packageManager = this.context.getPackageManager();
        CameraSelector cameraSelector = this.availableCamerasSelector;
        Integer numD = cameraSelector != null ? cameraSelector.d() : null;
        boolean zHasSystemFeature = packageManager.hasSystemFeature("android.hardware.camera");
        boolean zHasSystemFeature2 = packageManager.hasSystemFeature("android.hardware.camera.front");
        boolean z10 = false;
        boolean z11 = zHasSystemFeature && (numD == null || numD.intValue() == 1);
        if (zHasSystemFeature2 && (numD == null || numD.intValue() == 0)) {
            z10 = true;
        }
        return new ValidationCriteria(z11, z10);
    }

    public final boolean e(Set<? extends CameraInternal> cameras, CameraSelector selector) {
        try {
            selector.g(new LinkedHashSet<>(cameras));
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public final boolean f(Context context) {
        return a.f11438a.a(context) != 0;
    }
}
