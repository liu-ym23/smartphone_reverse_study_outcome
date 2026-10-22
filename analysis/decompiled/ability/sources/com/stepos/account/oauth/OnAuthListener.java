package com.stepos.account.oauth;

import android.content.Intent;

/* loaded from: classes3.dex */
public interface OnAuthListener {
    void onError(int i, String str, String str2);

    void onHandleIntent(Intent intent);

    void onSuccess(String str, String str2);
}
