package com.bytedance.bdinstall.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SigHashLoader.java */
/* JADX INFO: loaded from: classes.dex */
class z extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f6237e;

    z(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        super(true, false);
        this.f6237e = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.bdinstall.d.d
    public boolean a(JSONObject r4) {
        String r1 = null;
        PackageInfo r3 = this.f6237e.getPackageManager().getPackageInfo(this.f6237e.getPackageName(), 64);     // Catch: PackageManager.NameNotFoundException -> L5
    L7:
        if (r3 != null) goto L9;
    L15:
        if (r1 == null) goto L21;
        r4.put("sig_hash", r1);
        return true;
    L21:
        return true;
    L9:
        if (r3.signatures == null) goto L15;
        if (r3.signatures.length <= 0) goto L15;
        Signature r5 = r3.signatures[0];
        if (r5 == null) goto L15;
        r1 = com.bytedance.bdinstall.j.d.b(r5.toByteArray());
    L5:
        e = move-exception;
        com.bytedance.bdinstall.t.a(e);
        r3 = null;
        goto L7
    }
}
