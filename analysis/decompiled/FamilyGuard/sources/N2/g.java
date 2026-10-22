package N2;

import android.text.TextUtils;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f4241a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4242b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f4243c;

    public g(String str, boolean z5) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        this.f4243c = !zIsEmpty;
        if (zIsEmpty) {
            return;
        }
        if (z5) {
            this.f4241a = "com.stepos.openid.permission.SECURESERVICE_OPEN_ID_CHANGE";
            this.f4242b = "content://com.stepos.secureservice.openidsdk/";
        } else {
            this.f4241a = "com.stepos.openid.permission.OPEN_ID_CHANGE";
            this.f4242b = "content://com.stepos.openidsdk/";
        }
    }
}
