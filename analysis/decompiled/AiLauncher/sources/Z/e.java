package Z;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.params.SessionConfiguration;

/* loaded from: classes.dex */
public interface e {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f7090a;

        /* renamed from: b, reason: collision with root package name */
        public final int f7091b;

        /* renamed from: c, reason: collision with root package name */
        public final long f7092c;

        public a(int i10, int i11, long j10) {
            this.f7090a = i10;
            this.f7091b = i11;
            this.f7092c = j10;
        }

        public int a() {
            return this.f7090a;
        }
    }

    a a(SessionConfiguration sessionConfiguration) throws CameraAccessException;
}
