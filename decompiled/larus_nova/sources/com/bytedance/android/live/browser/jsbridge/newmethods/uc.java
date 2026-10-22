package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.DialogInterface;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class uc implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f63686a;

    public uc(JSONObject r100) {
        this.f63686a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        this.f63686a.put("isCancel", 1);
    }
}
