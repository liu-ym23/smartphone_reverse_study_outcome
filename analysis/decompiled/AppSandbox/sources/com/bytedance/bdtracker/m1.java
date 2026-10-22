package com.bytedance.bdtracker;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.util.SensitiveUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class m1 extends p1 {
    public final Context e;

    public m1(Context context) {
        super(true, false);
        this.e = context;
    }

    @Override // com.bytedance.bdtracker.p1
    public String a() {
        return "AppKey";
    }

    @Override // com.bytedance.bdtracker.p1
    public boolean a(JSONObject jSONObject) {
        try {
            Bundle bundle = this.e.getPackageManager().getApplicationInfo(this.e.getPackageName(), 128).metaData;
            if (bundle == null || TextUtils.isEmpty(SensitiveUtils.CHANNEL_APP_KEY)) {
                return true;
            }
            jSONObject.put("appkey", bundle.getString(SensitiveUtils.CHANNEL_APP_KEY));
            return true;
        } catch (Throwable th) {
            LoggerImpl.global().error("Load app key failed.", th, new Object[0]);
            return true;
        }
    }
}
