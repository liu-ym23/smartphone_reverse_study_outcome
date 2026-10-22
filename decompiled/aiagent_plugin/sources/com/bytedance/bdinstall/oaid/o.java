package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OaidSp.java */
/* JADX INFO: loaded from: classes.dex */
final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f6424a;

    o(Context r3) {
        this.f6424a = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getSharedPreferences("device_register_oaid_refine", 0);
    }

    void a(m r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.f6424a.edit().putString("oaid", r2.b().toString()).apply();
    }

    m a() {
        return m.a(this.f6424a.getString("oaid", ""));
    }

    public void b() {
        ba.a(this.f6424a, new String[]{"oaid"});
    }
}
