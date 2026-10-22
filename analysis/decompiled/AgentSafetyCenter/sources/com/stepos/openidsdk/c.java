package com.stepos.openidsdk;

import android.text.TextUtils;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f2773a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2774b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f2775c;

    public c(String str, boolean z10) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        this.f2775c = !zIsEmpty;
        if (zIsEmpty) {
            return;
        }
        if (z10) {
            this.f2773a = "com.stepos.openid.permission.SECURESERVICE_OPEN_ID_CHANGE";
            this.f2774b = "content://com.stepos.secureservice.openidsdk/";
        } else {
            this.f2773a = "com.stepos.openid.permission.OPEN_ID_CHANGE";
            this.f2774b = "content://com.stepos.openidsdk/";
        }
    }
}
