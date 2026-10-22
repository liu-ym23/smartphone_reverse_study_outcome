package ajc;

import android.text.TextUtils;
import com.ss.android.videoshop.log.VideoTraceState;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SimpleDateFormat f3967e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VideoTraceState f3968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Date f3970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f3971d;

    static {
        f3967e = new SimpleDateFormat("HH:mm:ss.SSS");
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        String r101 = f3967e.format(this.f3970c);     // Catch: Exception -> L5
    L6:
        r100.append(r101);
        r100.append(" ");
        r100.append(this.f3968a.name().toLowerCase());
        if (TextUtils.isEmpty(this.f3969b) == false) goto L9;
        String r102 = "";
    L10:
        r100.append(r102);
        return r100.toString();
    L9:
        r102 = ", extra='" + this.f3969b;
    L5:
        r101 = null;
        goto L6
    }

    public a(VideoTraceState r100, String r101, Object r102) {
        this.f3968a = r100;
        this.f3969b = r101;
        this.f3970c = new Date();
        this.f3971d = r102;
    }
}
