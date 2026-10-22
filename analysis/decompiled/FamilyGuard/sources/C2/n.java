package C2;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

/* loaded from: classes.dex */
public class n {
    public static void a(Context context, boolean z5) {
        Log.i("StartupUtils", "setStartup allow = " + z5);
        int i5 = z5 ? 1 : 2;
        int i6 = i5;
        Uri uri = Uri.parse("content://com.android.permissioncontroller.StartPolicyProvider");
        try {
            l0.e eVar = new l0.e();
            eVar.put("pkg", "com.stepos.familyguard");
            eVar.put("mode", 1);
            eVar.put("self_start", Integer.valueOf(i5));
            eVar.put("rel_start", Integer.valueOf(i6));
            eVar.put("bg", 1);
            Log.i("StartupUtils", "setStartup json = " + eVar);
            if (context.getContentResolver().update(uri, new ContentValues(), null, new String[]{eVar.toString()}) > 0) {
                Log.d("StartupUtils", "update success");
            }
        } catch (Exception e6) {
            Log.e("StartupUtils", "update fail;" + uri.toString() + ";" + e6.getMessage());
        }
    }
}
