package androidx.navigation;

import android.content.Intent;
import android.net.Uri;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f3842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3844c;

    public f(Uri r10, String r11, String r12) {
        this.f3842a = r10;
        this.f3843b = r11;
        this.f3844c = r12;
    }

    public String a() {
        return this.f3843b;
    }

    public String b() {
        return this.f3844c;
    }

    public Uri c() {
        return this.f3842a;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("NavDeepLinkRequest");
        r10.append("{");
        if (c() == null) goto L6;
        r10.append(" uri=");
        r10.append(String.valueOf(c()));
    L6:
        if (a() == null) goto L9;
        r10.append(" action=");
        r10.append(a());
    L9:
        if (b() == null) goto L11;
        r10.append(" mimetype=");
        r10.append(b());
    L11:
        r10.append(" }");
        String r11 = r10.toString();
        kotlin.jvm.internal.q.f(r11, "sb.toString()");
        return r11;
    }

    public f(Intent r10) {
        kotlin.jvm.internal.q.g(r10, MemorySourceLinkType.INTENT);
        this(r10.getData(), r10.getAction(), r10.getType());
    }
}
