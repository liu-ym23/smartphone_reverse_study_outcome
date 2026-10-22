package g3;

import android.text.TextUtils;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f2960a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2961b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f2962c;

    public d(String str, boolean z) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        this.f2962c = !zIsEmpty;
        if (zIsEmpty) {
            return;
        }
        if (z) {
            this.f2960a = "com.meizu.flyme.openid.permission.SECURESERVICE_OPEN_ID_CHANGE";
            this.f2961b = "content://com.flyme.secureservice.openidsdk/";
        } else {
            this.f2960a = "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE";
            this.f2961b = "content://com.meizu.flyme.openidsdk/";
        }
    }
}
