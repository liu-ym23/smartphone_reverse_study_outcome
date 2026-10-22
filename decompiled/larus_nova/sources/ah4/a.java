package ah4;

import org.json.JSONArray;
import zg4.i;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3414b;

    public final String toString() {
        return "CoreDumpConfig{isEnable=" + this.f3413a + ", nativeCrashFeature=null}";
    }

    public a(JSONArray r100, boolean r101, boolean r102) {
        this.f3414b = null;
        int r103 = 0;
        if (r101 == false) goto L6;
        if (r102 == false) goto L6;
        boolean r104 = true;
    L7:
        this.f3413a = r104;
        if (r100 != null) goto L10;
    L11:
        this.f3413a = false;
    L13:
        if (this.f3413a == false) goto L20;
        StringBuffer r105 = new StringBuffer("");
        boolean r106 = "1".equals(r100.optString(0));
    L16:
        if (r103 >= r100.length()) goto L18;
        r105.append(r100.optString(r103) + "#");
        r103 = r103 + 1;
        goto L16
    L18:
        this.f3413a = r106;
        this.f3414b = r105.toString();
        return;
    L20:
        if (i.b() == false) goto L25;
        this.f3413a = true;
        this.f3414b = "1#all#all#null#lib#SIG#0#0#7#";
        return;
    L25:
        return;
    L10:
        if (r100.length() < 10) goto L13;
    L6:
        r104 = false;
        goto L7
    }
}
