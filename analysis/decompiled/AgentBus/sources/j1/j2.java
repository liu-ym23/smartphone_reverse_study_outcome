package j1;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;

/* loaded from: classes.dex */
public final class j2 extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5211a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5212b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j2(ka.g gVar, Handler handler) {
        super(handler);
        this.f5212b = gVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z4, Uri uri) {
        switch (this.f5211a) {
            case 0:
                ((ka.g) this.f5212b).u(c7.r.f1986a);
                break;
            default:
                super.onChange(z4, uri);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j2(Handler handler, Context context) {
        super(handler);
        this.f5212b = context;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z4) {
        switch (this.f5211a) {
            case 1:
                String str = "prod";
                try {
                    if (q7.k.a(Settings.Secure.getString(((Context) this.f5212b).getContentResolver(), "net_env"), "test")) {
                        str = "test";
                    }
                } catch (Throwable th) {
                    Log.e("EnvManager", "read net_env failed", th);
                }
                String str2 = u5.f.f10122b;
                u5.f.f10122b = str;
                if (!q7.k.a(str2, str)) {
                    Log.i("EnvManager", "net_env changed: " + str2 + " → " + str);
                    break;
                }
                break;
            default:
                super.onChange(z4);
                break;
        }
    }
}
