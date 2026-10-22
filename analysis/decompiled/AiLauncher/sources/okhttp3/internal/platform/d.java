package okhttp3.internal.platform;

import android.content.Context;
import android.os.Build;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/platform/d;", "", "<init>", "()V", "Lokhttp3/internal/platform/c;", Const.INTENT_KEY_APIKEY, "()Lokhttp3/internal/platform/c;", "", "c", "()Z", "isAndroid", "Landroid/content/Context;", UxipConstants.f30680s, Const.INTENT_KEY_PKGNAME, "()Landroid/content/Context;", Const.INTENT_KEY_UMID, "(Landroid/content/Context;)V", "applicationContext", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f37742a = new d();

    public final c a() {
        Fb.c.f2742a.b();
        c cVarA = a.INSTANCE.a();
        if (cVarA == null) {
            cVarA = b.INSTANCE.a();
        }
        if (cVarA != null) {
            return cVarA;
        }
        throw new IllegalStateException("Expected Android API level 21+ but was " + Build.VERSION.SDK_INT);
    }

    public final Context b() {
        Object objE = c.INSTANCE.e();
        Eb.a aVar = objE instanceof Eb.a ? (Eb.a) objE : null;
        if (aVar != null) {
            return aVar.getApplicationContext();
        }
        return null;
    }

    public final boolean c() {
        return true;
    }

    public final void d(Context context) {
        Object objE = c.INSTANCE.e();
        Eb.a aVar = objE instanceof Eb.a ? (Eb.a) objE : null;
        if (aVar != null) {
            aVar.a(context);
        }
    }
}
