package e2;

import android.content.Context;
import android.preference.PreferenceManager;
import y1.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f2348b = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final f f2349a;

    public a(g3.c cVar) {
        Context context = (Context) cVar.f2954a;
        String str = (String) cVar.f2955b;
        String str2 = (String) cVar.f2956c;
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        } else {
            applicationContext.getSharedPreferences(str2, 0).edit();
        }
        this.f2349a = (f) cVar.f2959g;
    }
}
