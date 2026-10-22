package com.obric.matrix.sdk.push;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: PushImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f33774a;

    /* JADX INFO: compiled from: PushImpl.kt */
    public static final class a implements com.obric.matrix.push.common.cross_process.a.a {
        a() {
        }

        @Override // com.obric.matrix.push.common.cross_process.a.a
        public void a(List<Object> r2) {
            com.obric.matrix.push.common.a.c.a("sdk event: " + ((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin")));
        }
    }

    /* JADX INFO: compiled from: PushImpl.kt */
    public static final class b implements com.obric.matrix.push.common.cross_process.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f33775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.sdk.push.b f33776b;

        b(e r3, com.obric.matrix.sdk.push.b r4) {
            com.obric.matrix.sdk.push.b r5 = (com.obric.matrix.sdk.push.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.matrix.sdk.push.b.class, "com.obric.aiagent.plugin");
            this.f33775a = r3;
            this.f33776b = r5;
        }

        @Override // com.obric.matrix.push.common.cross_process.a.a
        public void a(List<Object> r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            com.obric.matrix.push.common.a.c.a(e.a(this.f33775a), "on  register_channel method callback , params is " + r7);
            if (r7 == null) goto L9;
            com.obric.matrix.sdk.push.b r0 = this.f33776b;
            Object r2 = r7.get(0);
            Objects.requireNonNull(r2, "null cannot be cast to non-null type kotlin.String");
            String r3 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
            Object r8 = r7.get(1);
            Objects.requireNonNull(r8, "null cannot be cast to non-null type kotlin.String");
            String r9 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
            if (TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("success", CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L7;
            r0.a(r9);
        L8:
            x r10 = x.f38692a;
        L10:
            if (r10 != null) goto L13;
            com.obric.matrix.sdk.push.b r11 = this.f33776b;
            b r5 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
            r11.a("102", "error when call push_service!");
            return;
        L13:
            return;
        L7:
            r0.a("103", r9);
            goto L8
        L9:
            r10 = null;
            goto L10
        }
    }

    public e() {
        this.f33774a = "PushImpl";
    }

    public static final /* synthetic */ String a(e r0) {
        return r0.f33774a;
    }

    public final void a(Context r5, d r6, com.obric.matrix.sdk.push.b r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        com.obric.matrix.sdk.push.b r9 = (com.obric.matrix.sdk.push.b) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.matrix.sdk.push.b.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        o.e(r6, "pushConfiguration");
        o.e(r9, "registerCallback");
        com.obric.matrix.push.common.a.c.a(this.f33774a, "registerPush");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r6.a(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L7;
        r9.a("101", "appId is empty!");
        return;
    L7:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r6.b(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L10;
        r9.a("101", "appSecret is empty!");
        return;
    L10:
        ArrayList<Object> r0 = new ArrayList();
        r0.add(r6.a());
        r0.add(r6.b());
        com.obric.matrix.push.common.a.c.a(this.f33774a, "invoke register_channel");
        a(r8);     // Catch: Throwable -> L13
        com.obric.matrix.push.common.a.f33752a.a(r8).a("com.obric.matrix", "register_channel", r0, (com.obric.matrix.push.common.cross_process.a.a) ZeusTransformUtils.preCheckCast(new b(this, r9), com.obric.matrix.push.common.cross_process.a.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        r9.a("102", "error when call push_service! " + th.getMessage());
    }

    private final void a(Context r6) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        String r8 = r5.getPackageName();     // Catch: Throwable -> L5
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L5
        r1.put("package_name", r8);     // Catch: Throwable -> L5
        ArrayList<Object> r9 = new ArrayList();     // Catch: Throwable -> L5
        r9.add("push_sdk_register");     // Catch: Throwable -> L5
        r9.add(r1.toString());     // Catch: Throwable -> L5
        com.obric.matrix.push.common.a r2 = com.obric.matrix.push.common.a.f33752a;     // Catch: Throwable -> L5
        o.a(r7);     // Catch: Throwable -> L5
        r2.a(r7).a("com.obric.matrix", "sdk_event", r9, (com.obric.matrix.push.common.cross_process.a.a) ZeusTransformUtils.preCheckCast(new a(), com.obric.matrix.push.common.cross_process.a.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        String r10 = Log.getStackTraceString(th);
        o.c(r10, "getStackTraceString(e)");
        com.obric.matrix.push.common.a.c.c(r10);
    }
}
