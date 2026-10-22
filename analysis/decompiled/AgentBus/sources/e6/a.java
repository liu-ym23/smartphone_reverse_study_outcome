package e6;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import g6.c;

/* loaded from: classes.dex */
public final class a extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3073a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3074b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3075c;

    public a(Context context) {
        super(new Handler(Looper.getMainLooper()));
        this.f3073a = context;
        this.f3074b = "154941";
        this.f3075c = "ca4a93c75257460694410f63a178a9e0";
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z4) {
        Context context = this.f3073a;
        ContentResolver contentResolver = context.getContentResolver();
        if (Settings.Secure.getInt(contentResolver, "user_setup_complete", 0) == 1) {
            StringBuilder sb2 = new StringBuilder("USER_SETUP_COMPLETE register start, appId: ");
            String str = this.f3074b;
            sb2.append(str);
            j6.a.b("5.0.7", sb2.toString());
            context.getSharedPreferences("com.stepos.push", 0).edit().putString("app_id", str).apply();
            c cVar = (c) f6.a.f3454a.f192f;
            cVar.f3853c = str;
            cVar.f3854d = this.f3075c;
            cVar.c(context);
            contentResolver.unregisterContentObserver(this);
        }
    }
}
