package e9;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: g, reason: collision with root package name */
    public static final Uri f3668g;

    /* renamed from: h, reason: collision with root package name */
    public static final Uri f3669h;
    public static final Uri i;

    /* renamed from: j, reason: collision with root package name */
    public static final Uri f3670j;

    /* renamed from: a, reason: collision with root package name */
    public ContentResolver f3671a;

    /* renamed from: b, reason: collision with root package name */
    public m7.e f3672b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f3673c;

    /* renamed from: d, reason: collision with root package name */
    public Uri f3674d;

    /* renamed from: e, reason: collision with root package name */
    public Uri f3675e;

    /* renamed from: f, reason: collision with root package name */
    public Uri f3676f;

    static {
        Uri uri = Uri.parse("content://com.stepos.taskrobot.settingsprovider/master_switch");
        uri.getClass();
        f3668g = uri;
        Uri uri2 = Uri.parse("content://com.stepos.taskrobot.settingsprovider/whitelist");
        uri2.getClass();
        f3669h = uri2;
        Uri uri3 = Uri.parse("content://com.stepos.taskrobot.settingsprovider/local_run");
        uri3.getClass();
        i = uri3;
        Uri uri4 = Uri.parse("content://com.stepos.taskrobot.settingsprovider/host_activity_dismissed");
        uri4.getClass();
        f3670j = uri4;
    }

    public final boolean a() {
        Boolean boolV0;
        try {
            Cursor cursorQuery = this.f3671a.query(this.f3675e, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(0) : null;
                    cursorQuery.close();
                } finally {
                }
            }
            boolean zBooleanValue = (string == null || (boolV0 = hc.h.v0(string)) == null) ? false : boolV0.booleanValue();
            Log.d("TaskRobotSettingsClient", "getLocalRun: uri=" + this.f3675e + ", raw=" + string + ", enabled=" + zBooleanValue);
            return zBooleanValue;
        } catch (Exception e10) {
            Log.e("TaskRobotSettingsClient", "getLocalRun failed", e10);
            return false;
        }
    }

    public final boolean b() {
        Uri uri = this.f3676f;
        try {
            int iUpdate = this.f3671a.update(uri, new ContentValues(), null, null);
            Log.i("TaskRobotSettingsClient", "notifyHostActivityDismissed updatedRows=" + iUpdate + " uri=" + uri);
            return iUpdate > 0;
        } catch (Exception e10) {
            Log.e("TaskRobotSettingsClient", "notifyHostActivityDismissed failed", e10);
            return false;
        }
    }
}
