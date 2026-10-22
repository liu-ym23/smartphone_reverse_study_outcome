package W0;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import s.C5423E;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\n\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\f\b\u0000\u0010\r*\u00060\bj\u0002`\t2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u00060\bj\u0002`\t0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001d\u001a\f\u0012\b\u0012\u00060\bj\u0002`\t0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001f¨\u0006!"}, d2 = {"LW0/g;", "", "<init>", "()V", "LY8/t;", "e", "", "key", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "closeable", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/AutoCloseable;)V", ExifInterface.GPS_DIRECTION_TRUE, Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Ljava/lang/AutoCloseable;", "f", "(Ljava/lang/AutoCloseable;)V", "LW0/f;", Const.INTENT_KEY_APIKEY, "LW0/f;", "lock", "", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "keyToCloseables", "", "c", "Ljava/util/Set;", "closeables", "", "Z", "isCleared", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final f lock = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<String, AutoCloseable> keyToCloseables = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Set<AutoCloseable> closeables = new LinkedHashSet();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public volatile boolean isCleared;

    public final void d(String key, AutoCloseable closeable) {
        AutoCloseable autoCloseable;
        p.i(key, "key");
        p.i(closeable, "closeable");
        if (this.isCleared) {
            f(closeable);
            return;
        }
        synchronized (this.lock) {
            autoCloseable = (AutoCloseable) this.keyToCloseables.put(key, closeable);
        }
        f(autoCloseable);
    }

    public final void e() {
        if (this.isCleared) {
            return;
        }
        this.isCleared = true;
        synchronized (this.lock) {
            try {
                Iterator it = this.keyToCloseables.values().iterator();
                while (it.hasNext()) {
                    f((AutoCloseable) it.next());
                }
                Iterator it2 = this.closeables.iterator();
                while (it2.hasNext()) {
                    f((AutoCloseable) it2.next());
                }
                this.closeables.clear();
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(AutoCloseable closeable) {
        if (closeable != null) {
            try {
                C5423E.a(closeable);
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public final <T extends AutoCloseable> T g(String key) {
        T t10;
        p.i(key, "key");
        synchronized (this.lock) {
            t10 = (T) this.keyToCloseables.get(key);
        }
        return t10;
    }
}
