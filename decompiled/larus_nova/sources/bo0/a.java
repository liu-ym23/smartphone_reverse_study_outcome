package bo0;

import com.bytedance.android.livesdk.config.a21;
import com.bytedance.android.livesdk.config.bj;
import com.bytedance.android.livesdk.config.cj;
import com.bytedance.android.livesdk.config.z11;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Boolean f19788a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z11 f19789b = null;

    static {
        f19788a = cj.f119956a.getValue();
        f19789b = bj.f119872a.getValue();
    }

    public static boolean a() {
        if (f19788a.booleanValue() == false) goto L13;
        Map<String, a21> r100 = f19789b.a();
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r100.isEmpty() == true) goto L9;
        r101 = true;
        goto L10
    L13:
        return false;
    }
}
