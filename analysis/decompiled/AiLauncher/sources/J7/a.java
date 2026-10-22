package J7;

import android.content.Context;
import android.os.Build;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010¨\u0006\u0012"}, d2 = {"LJ7/a;", "", "<init>", "()V", "", Const.INTENT_KEY_UMID, "()Ljava/lang/String;", "c", "e", "Landroid/content/Context;", "context", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)Ljava/lang/String;", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)I", "Ljava/lang/Object;", "deviceIdLock", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3739a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Object deviceIdLock = new Object();

    public final int a(Context context) {
        p.i(context, "context");
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
    }

    public final String b(Context context) {
        p.i(context, "context");
        String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        return str == null ? "1.0.0" : str;
    }

    public final String c() {
        String str = Build.BRAND;
        return str == null ? "unknown" : str;
    }

    public final String d() {
        String str = Build.MODEL;
        return str == null ? "unknown" : str;
    }

    public final String e() {
        String str = Build.VERSION.RELEASE;
        if (str == null) {
            str = "unknown";
        }
        return "Android " + str;
    }
}
