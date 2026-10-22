package n7;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings;
import com.stepos.core.common.settings.UserSetupState;
import o7.a;
import p7.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: n7.a$a, reason: collision with other inner class name */
    public static class C0112a extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        public final Context f10643a;

        /* renamed from: b, reason: collision with root package name */
        public final String f10644b;

        /* renamed from: c, reason: collision with root package name */
        public final String f10645c;

        public C0112a(Context context, String str, String str2) {
            super(new Handler(Looper.getMainLooper()));
            this.f10643a = context;
            this.f10644b = str;
            this.f10645c = str2;
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z) {
            Context context = this.f10643a;
            ContentResolver contentResolver = context.getContentResolver();
            if (Settings.Secure.getInt(contentResolver, UserSetupState.KEY_USER_SETUP_COMPLETE, 0) == 1) {
                StringBuilder sb2 = new StringBuilder("USER_SETUP_COMPLETE register start, appId: ");
                String str = this.f10644b;
                sb2.append(str);
                s7.a.b("5.0.7", sb2.toString());
                context.getSharedPreferences("com.stepos.push", 0).edit().putString("app_id", str).apply();
                c cVar = a.C0117a.f10777a.f10771a;
                cVar.f11458b = str;
                cVar.f11459c = this.f10645c;
                cVar.c(context);
                contentResolver.unregisterContentObserver(this);
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        if (s7.a.f11897a.compareAndSet(false, true)) {
            Process.myPid();
        }
        if (!"StepX".equalsIgnoreCase(Build.BRAND)) {
            s7.a.e("5.0.7", "please invoke register on device Build-in StepOS");
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        boolean z = Settings.Secure.getInt(contentResolver, UserSetupState.KEY_USER_SETUP_COMPLETE, 0) == 1;
        s7.a.b("5.0.7", "register start, appId: " + str + ", " + z);
        if (!z) {
            contentResolver.registerContentObserver(Settings.Secure.getUriFor(UserSetupState.KEY_USER_SETUP_COMPLETE), false, new C0112a(context, str, str2));
            return;
        }
        context.getSharedPreferences("com.stepos.push", 0).edit().putString("app_id", str).apply();
        c cVar = a.C0117a.f10777a.f10771a;
        cVar.f11458b = str;
        cVar.f11459c = str2;
        cVar.c(context);
    }
}
