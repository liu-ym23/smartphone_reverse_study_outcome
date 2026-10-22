package com.bytedance.bdturing.identityverify;

import android.app.Activity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: IdentityVerifyParam.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Activity f6583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.bdturing.c.b f6584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HashMap<String, String> f6585d;

    public c(Activity r3, HashMap<String, String> r4, boolean r5) {
        this.f6583b = ZeusTransformUtils.wrapperContext2Activity((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f6585d = r4;
        this.f6582a = r5;
    }

    public Activity getActivity() {
        return this.f6583b;
    }

    public void a(com.bytedance.bdturing.c.b r1) {
        this.f6584c = r1;
    }
}
