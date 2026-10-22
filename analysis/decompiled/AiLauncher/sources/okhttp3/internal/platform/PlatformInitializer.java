package okhttp3.internal.platform;

import Z8.C1173v;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\n0\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lokhttp3/internal/platform/PlatformInitializer;", "Ln1/b;", "Lokhttp3/internal/platform/c;", "<init>", "()V", "Landroid/content/Context;", "context", "c", "(Landroid/content/Context;)Lokhttp3/internal/platform/c;", "", "Ljava/lang/Class;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PlatformInitializer implements n1.b<c> {
    @Override // n1.b
    public List<Class<n1.b<?>>> a() {
        return C1173v.m();
    }

    @Override // n1.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c b(Context context) {
        p.i(context, "context");
        d.f37742a.d(context);
        return c.INSTANCE.e();
    }
}
