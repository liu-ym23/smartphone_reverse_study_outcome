package L1;

import java.io.IOException;

/* loaded from: classes.dex */
public final class e extends IOException {
    public static e a() {
        return new e("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }
}
