package com.obric.autoaction.app.launcherpage.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: OAutoSettingsHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f24476a = null;

    /* JADX INFO: compiled from: OAutoSettingsHelper.kt */
    @d.c.b.a.f(b = "OAutoSettingsHelper.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.utils.OAutoSettingsHelper$enablePermission$2")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Object>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f24478b;

        a(Context r3, d.c.d<? super a> r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24478b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<Object> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f24478b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Object> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f24477a != 0) goto L10;
            d.o.a(r7);
            return ZeusProviderTransform.call(this.f24478b.getContentResolver(), Uri.parse("content://com.obric.assistant.provider.ObricAutoAppCommonSettingProvider"), "enable_auto_settings", null, null, "com.obric.aiagent.plugin");
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: OAutoSettingsHelper.kt */
    @d.c.b.a.f(b = "OAutoSettingsHelper.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.utils.OAutoSettingsHelper$isPermissionEnabled$2")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f24480b;

        b(Context r3, d.c.d<? super b> r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24480b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f24480b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f24479a != 0) goto L13;
            d.o.a(r7);
            Uri r1 = Uri.parse("content://com.obric.assistant.provider.ObricAutoAppCommonSettingProvider");     // Catch: Exception -> L9
            Bundle r6 = ZeusProviderTransform.call(this.f24480b.getContentResolver(), r1, "get_auto_settings", null, null, "com.obric.aiagent.plugin");     // Catch: Exception -> L9
            boolean r8 = false;
            if (r6 == null) goto L11;
            r8 = r6.getBoolean("auto_action_enable", false);     // Catch: Exception -> L9
        L11:
            return d.c.b.a.b.a(r8);
        L9:
            r8 = true;
            goto L11
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f24476a = new f();
    }

    private f() {
    }

    public final Object a(Context r4, d.c.d<? super Boolean> r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    public final Object b(Context r4, d.c.d<Object> r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }
}
