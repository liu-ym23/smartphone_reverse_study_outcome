package com.bytedance.mobsec.metasec.a;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e implements f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f8861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f8862c;

    e(c r3, Context r4, long r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r6, "context could not be null");
        this.f8862c = r3;
        this.f8861b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f8860a = r5;
    }

    @Override // com.bytedance.mobsec.metasec.a.f.a
    public final void a(int r7) {
        long r2 = this.f8860a;
        if (r2 == (-1)) goto L6;
        com.bytedance.mobsec.matrix.a.a(33554441, r7, r2, null, null);
        return;
    }

    @Override // com.bytedance.mobsec.metasec.a.f.a
    public final void a(String r8) {
        this.f8862c.f8853c = r8;
        long r3 = this.f8860a;
        if (r3 == (-1)) goto L6;
        com.bytedance.mobsec.matrix.a.a(33554434, 0, r3, r8, this.f8861b);
        return;
    }

    @Override // com.bytedance.mobsec.metasec.a.f.a
    public final void a(String r8, String r9) {
        if (this.f8860a != (-1)) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r8) == true) goto L9;
        com.bytedance.mobsec.matrix.a.a(33554433, 0, this.f8860a, r8, r9);
        return;
    }

    @Override // com.bytedance.mobsec.metasec.a.f.a
    public final void b(String r8) {
        this.f8862c.f8855e = r8;
        long r3 = this.f8860a;
        if (r3 == (-1)) goto L6;
        com.bytedance.mobsec.matrix.a.a(33554435, 0, r3, r8, this.f8861b);
        return;
    }

    @Override // com.bytedance.mobsec.metasec.a.f.a
    public final void c(String r7) {
        if (this.f8860a == (-1)) goto L14;
        if (TextUtils.isEmpty(r7) == false) goto L7;
        return;
    L7:
        if (r7.contains("content") == false) goto L9;
        r7 = new JSONObject(r7).getString("content");     // Catch: Exception -> L11
    L9:
        long r2 = this.f8860a;     // Catch: Exception -> L11
        com.bytedance.mobsec.matrix.a.a(33554447, 0, r2, r7, this.f8861b);     // Catch: Exception -> L11
        return;
    L16:
        return;
    }
}
