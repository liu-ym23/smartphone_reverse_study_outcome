package bs7;

import com.byted.cast.proxy.Config;
import com.byted.cast.proxy.ILogger;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f20265f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f20266g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f20268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f20269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ILogger f20271e;

    static {
        f20265f = PatternProtector.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
        f20266g = PatternProtector.compile("GET /(.*) HTTP");
    }

    public final String toString() {
        return "GetRequest{rangeOffset=" + this.f20268b + ", partial=" + this.f20269c + ", uri='" + this.f20267a + "'}";
    }

    public a(String r100, Config r101) {
        this.f20270d = true;
        r100.getClass();
        if (r101 == null) goto L6;
        this.f20270d = r101.isEnableDebug();
        this.f20271e = r101.getLogger();
    L6:
        Matcher r102 = f20265f.matcher(r100);
        if (r102.find() == false) goto L9;
        long r103 = CastLongProtector.parseLong(r102.group(1));
    L10:
        long r104 = Math.max(0, r103);
        this.f20268b = r104;
        if (r103 < 0) goto L13;
        boolean r105 = true;
    L14:
        this.f20269c = r105;
        Matcher r106 = f20266g.matcher(r100);
        if (r106.find() == false) goto L23;
        this.f20267a = r106.group(1);
        String r107 = "offset is " + r103 + ", rangeOffset is " + r104 + ", partial is " + r105 + ", uri is " + this.f20267a + ", request is " + r100;
        if (this.f20270d == false) goto L24;
        ILogger r108 = this.f20271e;
        if (r108 == null) goto L25;
        r108.onDebug("GetRequest", r107);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        throw new IllegalArgumentException("Invalid request `" + r100 + "`: url not found!");
    L13:
        r105 = false;
        goto L14
    L9:
        r103 = -1;
        goto L10
    }
}
