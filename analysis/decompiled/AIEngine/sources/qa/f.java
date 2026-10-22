package qa;

import android.content.Context;
import android.content.SharedPreferences;
import com.tonyodev.fetch2core.server.FileResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {
    public static boolean a(Context context) {
        ta.c.d("SharedPreferencesHelper", "init SharedPreferences, name: com.stepos.statsapp.v3.request_feq_restrict");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.stepos.statsapp.v3.request_feq_restrict", 0);
        ta.c.a("SharedPreferencesHelper", "com.stepos.statsapp.v3.request_feq_restrict structure complete");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH");
        String string = sharedPreferences.getString(FileResponse.FIELD_DATE, "");
        String str = simpleDateFormat.format(new Date());
        if (!string.equals(str)) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(FileResponse.FIELD_DATE, str);
            editorEdit.putLong("current_request", 1L);
            editorEdit.commit();
            ta.c.a("RequestFreqRestrict", "isAllow true");
            return true;
        }
        long j10 = sharedPreferences.getLong("current_request", 0L);
        if (j10 > 10) {
            ta.c.a("RequestFreqRestrict", "isAllow false");
            return false;
        }
        sharedPreferences.edit().putLong("current_request", j10 + 1).commit();
        ta.c.a("RequestFreqRestrict", "isAllow true");
        return true;
    }
}
