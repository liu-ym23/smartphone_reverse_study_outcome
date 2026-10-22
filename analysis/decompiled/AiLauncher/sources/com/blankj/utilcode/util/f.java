package com.blankj.utilcode.util;

import android.content.Intent;
import android.net.Uri;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public final class f {
    public static Intent a(Intent intent, boolean z10) {
        return z10 ? intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY) : intent;
    }

    public static Intent b(String str, boolean z10) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + str));
        return a(intent, z10);
    }

    public static boolean c(Intent intent) {
        return p.a().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
