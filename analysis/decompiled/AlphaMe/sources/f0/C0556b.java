package f0;

import B0.g;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: f0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0556b {

    /* renamed from: e, reason: collision with root package name */
    public static final Object f12511e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public static C0556b f12512f;

    /* renamed from: a, reason: collision with root package name */
    public final Context f12513a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f12514b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f12515c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f12516d = new ArrayList();

    public C0556b(Context context) {
        this.f12513a = context;
        new HandlerC0555a(this, context.getMainLooper(), 0);
    }

    public final void a(Intent intent) {
        synchronized (this.f12514b) {
            try {
                intent.getAction();
                String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f12513a.getContentResolver());
                intent.getData();
                String scheme = intent.getScheme();
                intent.getCategories();
                boolean z4 = (intent.getFlags() & 8) != 0;
                if (z4) {
                    Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList arrayList = (ArrayList) this.f12515c.get(intent.getAction());
                if (arrayList != null) {
                    if (z4) {
                        Log.v("LocalBroadcastManager", "Action list: " + arrayList);
                    }
                    if (arrayList.size() > 0) {
                        g.y(arrayList.get(0));
                        if (!z4) {
                            throw null;
                        }
                        throw null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
