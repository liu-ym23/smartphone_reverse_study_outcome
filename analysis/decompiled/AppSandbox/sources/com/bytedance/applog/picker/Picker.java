package com.bytedance.applog.picker;

import android.app.Application;
import com.bytedance.applog.IPicker;
import com.bytedance.applog.InitConfig;

/* loaded from: classes.dex */
public class Picker implements IPicker {
    public String a;

    public Picker(Application application, InitConfig initConfig) {
    }

    @Override // com.bytedance.applog.IPicker
    public String getMarqueeCookie() {
        return this.a;
    }

    @Override // com.bytedance.applog.IPicker
    public void setMarqueeCookie(String str) {
        this.a = str;
    }
}
