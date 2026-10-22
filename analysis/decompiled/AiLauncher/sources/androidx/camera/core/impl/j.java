package androidx.camera.core.impl;

import D.C0761b0;
import K.F0;
import K.x0;
import androidx.camera.core.impl.CameraValidator;
import androidx.camera.core.k;

/* loaded from: classes.dex */
public final class j implements x0 {

    /* renamed from: d, reason: collision with root package name */
    public final androidx.camera.core.k f11429d;

    public class a implements androidx.camera.core.k {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f11430d;

        public a(long j10) {
            this.f11430d = j10;
        }

        @Override // androidx.camera.core.k
        public long a() {
            return this.f11430d;
        }

        @Override // androidx.camera.core.k
        public k.c b(k.b bVar) {
            return bVar.getStatus() == 1 ? k.c.f11622d : k.c.f11623e;
        }
    }

    public static final class b implements x0 {

        /* renamed from: d, reason: collision with root package name */
        public final androidx.camera.core.k f11432d;

        public b(long j10) {
            this.f11432d = new j(j10);
        }

        @Override // androidx.camera.core.k
        public long a() {
            return this.f11432d.a();
        }

        @Override // androidx.camera.core.k
        public k.c b(k.b bVar) {
            if (this.f11432d.b(bVar).d()) {
                return k.c.f11623e;
            }
            Throwable thA = bVar.a();
            if (thA instanceof CameraValidator.CameraIdListIncorrectException) {
                C0761b0.c("CameraX", "The device might underreport the amount of the cameras. Finish the initialize task since we are already reaching the maximum number of retries.");
                if (((CameraValidator.CameraIdListIncorrectException) thA).getAvailableCameraCount() > 0) {
                    return k.c.f11625g;
                }
            }
            return k.c.f11622d;
        }

        @Override // K.x0
        public androidx.camera.core.k c(long j10) {
            return new b(j10);
        }
    }

    public j(long j10) {
        this.f11429d = new F0(j10, new a(j10));
    }

    @Override // androidx.camera.core.k
    public long a() {
        return this.f11429d.a();
    }

    @Override // androidx.camera.core.k
    public k.c b(k.b bVar) {
        return this.f11429d.b(bVar);
    }

    @Override // K.x0
    public androidx.camera.core.k c(long j10) {
        return new j(j10);
    }
}
