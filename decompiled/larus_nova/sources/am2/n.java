package am2;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class n implements k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static n f4311i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4318g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4319h;

    public static n f() {
        if (f4311i != null) goto L6;
        f4311i = new n();
    L6:
        return f4311i;
    }

    public final String a() {
        String r100 = this.f4317f;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.f4319h) == false) goto L9;
    L8:
        return "";
    L9:
        return new JSONObject(this.f4319h).optString(DbJsonConstants.DBJSON_KEY_TASK_KEY);
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public final String c() {
        if (TextUtils.isEmpty(this.f4313b) == false) goto L5;
        return "";
    L5:
        return e(this.f4313b, "creativeID");
    }

    public final String d() {
        if (TextUtils.isEmpty(this.f4313b) == false) goto L5;
        return "";
    L5:
        return e(this.f4313b, "log_extra");
    }

    public final boolean g() {
        if (TextUtils.isEmpty(this.f4315d) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(IPerformanceManager.SCENE_CLICK_DOU_PLUS, this.f4315d) == false) goto L7;
        return true;
    }

    public final boolean h() {
        if (TextUtils.isEmpty(this.f4315d) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(com.bytedance.android.ec.core.event.a.VALUE_EFFECTIVE_AD, this.f4315d) == false) goto L7;
        return true;
    }

    public n() {
        this.f4312a = "";
        this.f4318g = false;
    }

    public static String e(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L10:
        return "";
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L10;
        return new JSONObject(r100).optString(r101, "");
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}
