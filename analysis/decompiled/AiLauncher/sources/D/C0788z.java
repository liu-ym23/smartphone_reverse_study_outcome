package D;

import androidx.camera.core.impl.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: D.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0788z {

    /* renamed from: D.z$a */
    public static final class a implements K.P {

        /* renamed from: a, reason: collision with root package name */
        public final List<androidx.camera.core.impl.m> f2198a;

        public a(List<androidx.camera.core.impl.m> list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Cannot set an empty CaptureStage list.");
            }
            this.f2198a = Collections.unmodifiableList(new ArrayList(list));
        }

        @Override // K.P
        public List<androidx.camera.core.impl.m> a() {
            return this.f2198a;
        }
    }

    public static K.P a(androidx.camera.core.impl.m... mVarArr) {
        return new a(Arrays.asList(mVarArr));
    }

    public static K.P b() {
        return a(new m.a());
    }
}
