package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.uikit.dialog.AlertDialog;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class a4 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f63286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TokenCert f63287b;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public final void k() {
        if (this.f63286a == null) goto L5;
        Intent r100 = new Intent();
        r100.setAction("android.intent.action.PICK");
        r100.addCategory("android.intent.category.DEFAULT");
        r100.setType("vnd.android.cursor.dir/phone_v2");
        this.f63286a.startActivityForResult(r100, 998);
        return;
    L5:
        finishWithFailure();
    }

    public a4(Fragment r100) {
        this.f63287b = TokenCert.with("bpea-live_getContactMethod_jsb_get_read_contacts");
        this.f63286a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) throws Exception {
        JSONObject r102 = r100;
        if (r101 != null) goto L5;
    L19:
        finishWithFailure();
        return;
    L5:
        if ((r101.getContext() instanceof Activity) == false) goto L19;
        String r103 = r102.optString("token", "");
        if (r103 != null) goto L10;
    L12:
        Activity r104 = (Activity) r101.getContext();
        AlertDialog.setNightMode(new y3());
        if (Build.VERSION.SDK_INT < 23) goto L16;
        SettingKey<Boolean> r105 = m60.i.f512260a;
        new m60.i.b(r104).b(new z3(this), null, this.f63287b, new String[]{"android.permission.READ_CONTACTS"});
        return;
    L16:
        if (m60.c.d(r104, new String[]{"android.permission.READ_CONTACTS"}) == false) goto L18;
        k();
        return;
    L18:
        finishWithFailure();
        return;
    L10:
        if (r103.isEmpty() == true) goto L12;
        this.f63287b = TokenCert.with(r103);
        goto L12
    }

    public static Cursor j(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, null, null, null};
        f06.b r113 = new f06.b();
        f06.d r114 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r113);
        if (r114.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r113, false);
        return (Cursor) r114.f474983b;
    L6:
        Cursor r115 = r110.query(r111, r112, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r115, r113, true);
        return r115;
    }
}
