package z2;

import java.io.File;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final long f6937a;
    public long b;
    public final File c;
    public JSONObject d = null;

    public n(File file) throws NumberFormatException {
        long j5;
        this.c = file;
        String name = file.getName();
        int iIndexOf = name.indexOf("-");
        if (iIndexOf > 0) {
            this.f6937a = Long.parseLong(name.substring(0, iIndexOf));
            j5 = Long.parseLong(name.substring(iIndexOf + 1, name.lastIndexOf(".")));
        } else {
            j5 = 0;
            this.f6937a = 0L;
        }
        this.b = j5;
    }
}
