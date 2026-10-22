package H0;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import u1.C2031a;
import u1.d;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f724a;
    public final B1.c b;
    public final d c;
    public String d;
    public final C2031a e;
    public long f;
    public long g;
    public final /* synthetic */ b h;

    public a(b bVar, Context context, B1.c cVar, C2031a c2031a) {
        this.h = bVar;
        this.b = cVar;
        this.e = c2031a;
        String str = (String) cVar.f180a;
        this.f724a = str;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("type is empty.");
        }
        if (d.f == null) {
            synchronized (d.class) {
                try {
                    if (d.f == null) {
                        d.f = new d(context);
                    }
                } finally {
                }
            }
        }
        d dVar = d.f;
        this.c = dVar;
        if (((AtomicBoolean) dVar.d).get()) {
            return;
        }
        ((ConcurrentHashMap) dVar.b).put(str, this);
    }
}
