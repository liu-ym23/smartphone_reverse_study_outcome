package a77;

import android.database.Cursor;
import com.bytedance.common.push.BaseJson;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends BaseJson {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2036e;

    public final String toString() {
        return "{id=" + this.f2032a + ", serviceName='" + this.f2033b + "', category='" + this.f2034c + "', metric='" + this.f2035d + "', extra='" + this.f2036e + "'}";
    }

    public b(Cursor r100) {
        this.f2032a = r100.getLong(0);
        this.f2033b = r100.getString(1);
        this.f2034c = r100.getString(2);
        this.f2035d = r100.getString(3);
        this.f2036e = r100.getString(4);
    }

    public b(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        this.f2033b = r100;
        if (r101 == null) goto L5;
        this.f2034c = r101.toString();
    L5:
        if (r102 == null) goto L7;
        this.f2035d = r102.toString();
    L7:
        if (r103 == null) goto L10;
        this.f2036e = r103.toString();
        return;
    }
}
