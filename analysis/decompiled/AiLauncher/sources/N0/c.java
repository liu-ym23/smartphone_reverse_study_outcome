package N0;

import android.content.Context;
import android.net.Uri;

/* loaded from: classes.dex */
public class c extends a {

    /* renamed from: b, reason: collision with root package name */
    public Context f4785b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f4786c;

    public c(a aVar, Context context, Uri uri) {
        super(aVar);
        this.f4785b = context;
        this.f4786c = uri;
    }

    @Override // N0.a
    public long b() {
        return b.b(this.f4785b, this.f4786c);
    }
}
