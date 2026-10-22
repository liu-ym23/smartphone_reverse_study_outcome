package f9;

import java.io.IOException;

/* loaded from: classes.dex */
public final class r extends IOException {

    /* renamed from: f, reason: collision with root package name */
    public a f3597f;

    public r(String str) {
        super(str);
        this.f3597f = null;
    }

    public static r a() {
        return new r("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }
}
