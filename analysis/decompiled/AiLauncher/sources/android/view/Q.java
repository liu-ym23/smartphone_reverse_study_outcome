package android.view;

import W0.g;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0006\u0010\u0003J!\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\n\u0010\u000b\u001a\u00060\tj\u0002`\n¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\f\b\u0000\u0010\u000e*\u00060\tj\u0002`\n2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/lifecycle/Q;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "", "key", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "closeable", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/AutoCloseable;)V", ExifInterface.GPS_DIRECTION_TRUE, "c", "(Ljava/lang/String;)Ljava/lang/AutoCloseable;", "LW0/g;", "impl", "LW0/g;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Q {
    private final g impl = new g();

    public final void a(String key, AutoCloseable closeable) {
        p.i(key, "key");
        p.i(closeable, "closeable");
        g gVar = this.impl;
        if (gVar != null) {
            gVar.d(key, closeable);
        }
    }

    public final void b() {
        g gVar = this.impl;
        if (gVar != null) {
            gVar.e();
        }
        d();
    }

    public final <T extends AutoCloseable> T c(String key) {
        p.i(key, "key");
        g gVar = this.impl;
        if (gVar != null) {
            return (T) gVar.g(key);
        }
        return null;
    }

    public void d() {
    }
}
