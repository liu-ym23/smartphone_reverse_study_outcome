package Z0;

import com.google.android.gms.common.Feature;

/* loaded from: classes.dex */
public final class k extends UnsupportedOperationException {

    /* renamed from: a, reason: collision with root package name */
    public final Feature f2158a;

    public k(Feature feature) {
        this.f2158a = feature;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "Missing ".concat(String.valueOf(this.f2158a));
    }
}
