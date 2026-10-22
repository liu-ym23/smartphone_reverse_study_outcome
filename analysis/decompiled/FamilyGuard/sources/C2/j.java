package C2;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public final class j {
    private static void a(Context context) {
        Intent intent = new Intent("com.stepos.settings.broadcast.ACTION_REFRESH_APPLICATION_DATA");
        intent.setPackage("com.android.settings");
        context.sendBroadcast(intent);
    }

    public static void b(Context context, boolean z5) {
        T1.b.o(context.getContentResolver(), !z5);
        com.stepos.familyguard.admin.a.b().i(z5);
        a(context);
    }
}
