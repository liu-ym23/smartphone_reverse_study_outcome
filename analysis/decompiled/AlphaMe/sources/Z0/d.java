package Z0;

import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public class d extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final Status f2147a;

    /* JADX WARN: Illegal instructions before constructor call */
    public d(Status status) {
        int i4 = status.f9612b;
        String str = status.f9613c;
        super(i4 + ": " + (str == null ? "" : str));
        this.f2147a = status;
    }
}
