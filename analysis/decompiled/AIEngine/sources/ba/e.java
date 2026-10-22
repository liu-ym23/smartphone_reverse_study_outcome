package ba;

import android.text.TextUtils;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f3154a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3155b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3156c;

    public e(String str, boolean z) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        this.f3156c = !zIsEmpty;
        if (zIsEmpty) {
            return;
        }
        if (z) {
            this.f3154a = "com.stepos.openid.permission.SECURESERVICE_OPEN_ID_CHANGE";
            this.f3155b = "content://com.stepos.secureservice.openidsdk/";
        } else {
            this.f3154a = "com.stepos.openid.permission.OPEN_ID_CHANGE";
            this.f3155b = "content://com.stepos.openidsdk/";
        }
    }
}
