package N0;

import android.content.Context;
import android.net.Uri;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final a f4784a;

    public a(a aVar) {
        this.f4784a = aVar;
    }

    public static a a(Context context, Uri uri) {
        return new c(null, context, uri);
    }

    public abstract long b();
}
