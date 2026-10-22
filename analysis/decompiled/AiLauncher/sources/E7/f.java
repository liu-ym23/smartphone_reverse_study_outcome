package E7;

import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import okhttp3.logging.HttpLoggingInterceptor;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"LE7/f;", "", "<init>", "()V", "", Parameters.DEBUG, "", "", "redactedHeaders", "tag", "Lokhttp3/logging/HttpLoggingInterceptor;", Const.INTENT_KEY_PKGNAME, "(ZLjava/util/Set;Ljava/lang/String;)Lokhttp3/logging/HttpLoggingInterceptor;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f2399a = new f();

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HttpLoggingInterceptor c(f fVar, boolean z10, Set set, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            set = C7.c.f1727a.a();
        }
        if ((i10 & 4) != 0) {
            str = "StepOsHttp";
        }
        return fVar.b(z10, set, str);
    }

    public static final void d(String str, String message) {
        p.i(message, "message");
        Log.d(str, message);
    }

    public final HttpLoggingInterceptor b(boolean debug, Set<String> redactedHeaders, final String tag) {
        p.i(redactedHeaders, "redactedHeaders");
        p.i(tag, "tag");
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.b() { // from class: E7.e
            @Override // okhttp3.logging.HttpLoggingInterceptor.b
            public final void a(String str) {
                f.d(tag, str);
            }
        });
        httpLoggingInterceptor.c(debug ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        Iterator<T> it = redactedHeaders.iterator();
        while (it.hasNext()) {
            httpLoggingInterceptor.e((String) it.next());
        }
        return httpLoggingInterceptor;
    }
}
