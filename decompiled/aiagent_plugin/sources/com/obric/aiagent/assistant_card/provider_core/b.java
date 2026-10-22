package com.obric.aiagent.assistant_card.provider_core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import com.obric.aiagent.assistant_card.provider_core.a.g;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.f;
import d.h.a.m;
import d.n;
import d.o;
import d.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.da;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: compiled from: CardProviderManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "CardProviderManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16338a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, com.obric.aiagent.assistant_card.provider_core.a> f16339b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f f16340c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile IHostApi f16341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile Context f16342e;
    private static volatile String f;
    private static volatile long g;
    private static final CardProviderManager$onHostApiDeathRecipient$1 h = null;

    /* JADX INFO: compiled from: CardProviderManager.kt */
    @d.c.b.a.f(b = "CardProviderManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.assistant_card.provider_core.CardProviderManager$callHostMethod$1")
    static final class a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Bundle f16345c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f16346d;

        a(String r3, Bundle r4, d.c.d<? super a> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16344b = r3;
            this.f16345c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f16344b, this.f16345c, r6);
            r0.f16346d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f16343a != 0) goto L20;
            o.a(r5);
            am r6 = (am) ZeusTransformUtils.preCheckCast(this.f16346d, am.class, "com.obric.aiagent.plugin");
            String r7 = this.f16344b;
            Bundle r2 = this.f16345c;
            n.a r3 = n.f38560a;     // Catch: Throwable -> L12
            IHostApi r4 = b.c();     // Catch: Throwable -> L12
            if (r4 == null) goto L9;
            r4.callMethod(r7, r2);     // Catch: Throwable -> L12
            Object r8 = r4;
            if (r4 == null) goto L9;
        L10:
            Object r9 = n.f(r8);     // Catch: Throwable -> L12
        L14:
            String r10 = this.f16344b;
            Throwable r11 = n.c(r9);
            if (r11 == null) goto L18;
            com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(b.TAG, "callHostMethod: failed to call " + r10, r11);
        L18:
            return x.f38692a;
        L9:
            com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.b(b.TAG, "callHostMethod: failed to call " + r7 + ", hostApi is null");     // Catch: Throwable -> L12
            r8 = x.f38692a;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            n.a r12 = n.f38560a;
            r9 = n.f(o.a(th));
            goto L14
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.assistant_card.provider_core.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CardProviderManager.kt */
    @d.c.b.a.f(b = "CardProviderManager.kt", c = {230}, d = "invokeSuspend", e = "com.obric.aiagent.assistant_card.provider_core.CardProviderManager$handleCardAction$1")
    static final class C0327b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16348b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f16349c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16350d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Bundle f16351e;
        final /* synthetic */ Uri f;
        final /* synthetic */ Context g;

        C0327b(Bundle r3, Uri r4, Context r5, d.c.d<? super C0327b> r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16351e = r3;
            this.f = r4;
            this.g = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0327b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0327b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0327b(this.f16351e, this.f, this.g, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r15) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16350d;
            if (r1 == 0) goto L12;
            if (r1 != 1) goto L11;
            Uri r2 = (Uri) ZeusTransformUtils.preCheckCast(this.f16349c, Uri.class, "com.obric.aiagent.plugin");
            JSONObject r3 = (JSONObject) ZeusTransformUtils.preCheckCast(this.f16348b, JSONObject.class, "com.obric.aiagent.plugin");
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f16347a, String.class, "com.obric.aiagent.plugin");
            o.a(r15);     // Catch: Throwable -> L8
        L39:
            com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(b.TAG, "handlePendingAction: finish cardUri = " + r2 + ", actionName = " + r4 + ", actionParams = " + r3);     // Catch: Throwable -> L8
        L40:
            Object r16 = n.f(x.f38692a);     // Catch: Throwable -> L8
        L43:
            Uri r14 = this.f;
            Throwable r17 = n.c(r16);
            if (r17 == null) goto L47;
            com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(b.TAG, "handlePendingAction: failed " + r14, r17);
        L47:
            return x.f38692a;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            o.a(r15);
            String r18 = this.f16351e.getString("action_name");
            if (r18 != null) goto L15;
            r18 = "";
        L15:
            Bundle r5 = this.f16351e;
            Object r7 = null;
            n.a r8 = n.f38560a;     // Catch: Throwable -> L22
            String r6 = r5.getString("action_params");     // Catch: Throwable -> L22
            if (r6 == null) goto L19;
            JSONObject r9 = new JSONObject(r6);     // Catch: Throwable -> L22
        L20:
            Object r10 = n.f(r9);     // Catch: Throwable -> L22
        L24:
            Throwable r11 = n.c(r10);
            if (r11 == null) goto L28;
            com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(b.TAG, "handleCardAction: failed to parse actionParams", r11);
        L28:
            if (n.b(r10) == true) goto L31;
            r7 = r10;
        L31:
            r3 = (JSONObject) ZeusTransformUtils.preCheckCast(r7, JSONObject.class, "com.obric.aiagent.plugin");
            Uri r13 = this.f;
            Context r12 = this.g;
            n.a r19 = n.f38560a;     // Catch: Throwable -> L8
            com.obric.aiagent.assistant_card.provider_core.a r20 = (com.obric.aiagent.assistant_card.provider_core.a) ZeusTransformUtils.preCheckCast(b.d().get(g.a(r13)), com.obric.aiagent.assistant_card.provider_core.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
            if (r20 != null) goto L35;
            com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.b(b.TAG, "handlePendingAction: no cardProvider for cardType: " + g.a(r13));     // Catch: Throwable -> L8
            goto L40
        L35:
            com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(b.TAG, "handlePendingAction: start cardUri = " + r13 + ", actionName = " + r18 + ", actionParams = " + r3);     // Catch: Throwable -> L8
            this.f16347a = r18;     // Catch: Throwable -> L8
            this.f16348b = r3;     // Catch: Throwable -> L8
            this.f16349c = r13;     // Catch: Throwable -> L8
            this.f16350d = 1;     // Catch: Throwable -> L8
            if (r20.a(r12, r13, r18, r3, this) != r0) goto L38;
            return r0;
        L38:
            r4 = r18;
            r2 = r13;
            goto L39
        L19:
            r9 = null;
        L22:
            th = move-exception;
            n.a r21 = n.f38560a;
            r10 = n.f(o.a(th));
        L8:
            th = move-exception;
            n.a r22 = n.f38560a;
            r16 = n.f(o.a(th));
            goto L43
        }
    }

    /* JADX INFO: compiled from: CardProviderManager.kt */
    @d.c.b.a.f(b = "CardProviderManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.assistant_card.provider_core.CardProviderManager$notifyCardChanged$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Uri f16353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSONObject f16354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f16355d;

        c(Uri r3, JSONObject r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16353b = r3;
            this.f16354c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f16353b, this.f16354c, r6);
            r0.f16355d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v2, types: [com.obric.aiagent.assistant_card.provider_core.IHostApi] */
        /* JADX WARN: Type inference failed for: r4v5, types: [d.x] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            d.c.a.b.a();
            if (this.f16352a != 0) goto L36;
            o.a(r11);
            am r12 = (am) ZeusTransformUtils.preCheckCast(this.f16355d, am.class, "com.obric.aiagent.plugin");
            Uri r13 = this.f16353b;
            JSONObject r2 = this.f16354c;
            n.a r4 = n.f38560a;     // Catch: Throwable -> L25
            Object r5 = b.c();     // Catch: Throwable -> L25
            if (r5 != 0) goto L39;
        L22:
            com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(b.TAG, "notifyDataChanged: hostApi is null, will use cp to notify");     // Catch: Throwable -> L25
            b.a(b.f16338a, r13, r2);     // Catch: Throwable -> L25
            r5 = x.f38692a;     // Catch: Throwable -> L25
        L23:
            Object r14 = n.f(r5);     // Catch: Throwable -> L25
        L27:
            Uri r3 = this.f16353b;
            Throwable r6 = n.c(r14);
            if (r6 == null) goto L30;
            com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(b.TAG, "notifyDataChanged: failed to notify " + r3, r6);
        L30:
            Uri r10 = this.f16353b;
            if (n.a(r14) == false) goto L34;
            com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(b.TAG, "notifyDataChanged: notify " + r10 + " success");
        L34:
            return x.f38692a;
        L39:
            n.a r7 = n.f38560a;     // Catch: Throwable -> L13
            Bundle r8 = new Bundle();     // Catch: Throwable -> L13
            r8.putString("card_uri", r13.toString());     // Catch: Throwable -> L13
            if (r2 == null) goto L10;
            String r9 = r2.toString();     // Catch: Throwable -> L13
        L11:
            r8.putString("card_extra_params", r9);     // Catch: Throwable -> L13
            r5.notifyCardChanged(r8);     // Catch: Throwable -> L13
            Object r15 = n.f(x.f38692a);     // Catch: Throwable -> L13
        L15:
            Throwable r16 = n.c(r15);     // Catch: Throwable -> L25
            if (r16 == null) goto L19;
            com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(b.TAG, "notifyDataChanged: failed to notify " + r13 + ", error: " + r16.getMessage(), r16);     // Catch: Throwable -> L25
        L19:
            if (n.a(r15) == false) goto L21;
            x r17 = (x) ZeusTransformUtils.preCheckCast(r15, x.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
            com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(b.TAG, "notifyDataChanged succeed");     // Catch: Throwable -> L25
        L21:
            if (r5 != 0) goto L23;
        L10:
            r9 = null;
        L13:
            th = move-exception;
            n.a r18 = n.f38560a;     // Catch: Throwable -> L25
            r15 = n.f(o.a(th));     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            n.a r19 = n.f38560a;
            r14 = n.f(o.a(th));
            goto L27
        L36:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: CardProviderManager.kt */
    @d.c.b.a.f(b = "CardProviderManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.assistant_card.provider_core.CardProviderManager$setHostApi$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IHostApi f16357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f16358c;

        d(IHostApi r3, d.c.d<? super d> r4) {
            IHostApi r5 = (IHostApi) ZeusTransformUtils.wrapperContextForParams(r3, IHostApi.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16357b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            d r0 = new d(this.f16357b, r5);
            r0.f16358c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f16356a != 0) goto L31;
            o.a(r7);
            am r8 = (am) ZeusTransformUtils.preCheckCast(this.f16358c, am.class, "com.obric.aiagent.plugin");
            IHostApi r9 = b.c();
            if (r9 != null) goto L34;
        L14:
            b r10 = b.f16338a;
            b.a(this.f16357b);
            IHostApi r6 = this.f16357b;
            n.a r11 = n.f38560a;     // Catch: Throwable -> L23
            if (r6 == null) goto L20;
            IBinder r12 = r6.asBinder();     // Catch: Throwable -> L23
            if (r12 == null) goto L20;
            r12.linkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(b.e(), IBinder.DeathRecipient.class, "com.obric.aiagent.plugin"), 0);     // Catch: Throwable -> L23
            x r13 = x.f38692a;     // Catch: Throwable -> L23
        L21:
            Object r14 = n.f(r13);     // Catch: Throwable -> L23
        L25:
            Throwable r15 = n.c(r14);
            if (r15 == null) goto L29;
            com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(b.TAG, "setHostApi: failed to linkToDeath", r15);
        L29:
            return x.f38692a;
        L20:
            r13 = null;
        L23:
            th = move-exception;
            n.a r16 = n.f38560a;
            r14 = n.f(o.a(th));
            goto L25
        L34:
            n.a r3 = n.f38560a;     // Catch: Throwable -> L8
            Object r17 = n.f(d.c.b.a.b.a(r9.asBinder().unlinkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(b.e(), IBinder.DeathRecipient.class, "com.obric.aiagent.plugin"), 0)));     // Catch: Throwable -> L8
        L10:
            Throwable r4 = n.c(r17);
            if (r4 == null) goto L13;
            com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(b.TAG, "setHostApi: failed to unlinkToDeath", r4);
        L13:
            n.g(r17);
        L8:
            th = move-exception;
            n.a r5 = n.f38560a;
            r17 = n.f(o.a(th));
            goto L10
        L31:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ am lambda$IpjyRlBM5Dat9PXOMav5cW19SDM() {
        return g();
    }

    private b() {
    }

    public static final /* synthetic */ void a(IHostApi r2) {
        f16341d = (IHostApi) ZeusTransformUtils.wrapperContextForParams(r2, IHostApi.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(b r0, Uri r1, JSONObject r2) {
        r0.b(r1, r2);
    }

    public static final /* synthetic */ IHostApi c() {
        return f16341d;
    }

    public static final /* synthetic */ ConcurrentHashMap d() {
        return f16339b;
    }

    public static final /* synthetic */ CardProviderManager$onHostApiDeathRecipient$1 e() {
        return h;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.obric.aiagent.assistant_card.provider_core.CardProviderManager$onHostApiDeathRecipient$1] */
    static {
        f16338a = new b();
        f16339b = new ConcurrentHashMap();
        f16340c = d.g.a($$Lambda$b$IpjyRlBM5Dat9PXOMav5cW19SDM.INSTANCE);
        f = "";
        h = new CardProviderManager$onHostApiDeathRecipient$1();
    }

    private final am f() {
        return (am) ZeusTransformUtils.preCheckCast(f16340c.b(), am.class, "com.obric.aiagent.plugin");
    }

    private static final am g() {
        return an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(da.a(TAG), d.c.g.class, "com.obric.aiagent.plugin")));
    }

    public final String a() {
        return f;
    }

    public final long b() {
        return g;
    }

    public final void a(Context r3, com.obric.aiagent.assistant_card.provider_core.a.f r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.assistant_card.provider_core.a.f r5 = (com.obric.aiagent.assistant_card.provider_core.a.f) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.aiagent.assistant_card.provider_core.a.f.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "context");
        d.h.b.o.e(r5, "logger");
        f16342e = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(r5);
        com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(TAG, "init: packageName = " + r2.getPackageName() + ", logger = " + r5);
        PackageInfo r6 = r2.getPackageManager().getPackageInfo(r2.getPackageName(), 0);
        String r7 = r6.versionName;
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        f = r7;
        g = androidx.core.content.a.a.a(r6);
    }

    public final synchronized boolean a(com.obric.aiagent.assistant_card.provider_core.a r5) {
        monitor-enter(this);
        d.h.b.o.e(r5, "cardProvider");     // Catch: Throwable -> L12
        com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(TAG, "registerCardProvider: " + r5.a() + ", " + r5);     // Catch: Throwable -> L12
        ConcurrentHashMap<String, com.obric.aiagent.assistant_card.provider_core.a> r0 = f16339b;     // Catch: Throwable -> L12
        if (r0.containsKey(r5.a()) == true) goto L6;
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put(r5.a(), r5);     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    L6:
        monitor-exit(this);
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    public final void a(Uri r10, JSONObject r11) {
        com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(TAG, "notifyCardChanged: " + r10 + ", cardParams = " + r11);
        if (r10 != null) goto L5;
        return;
    L5:
        i.a(f(), null, null, (m) ZeusTransformUtils.preCheckCast(new c(r10, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void b(Uri r9, JSONObject r10) {
        com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(TAG, "notifyWithCP: cardUri = " + r9 + ", cardParams = " + r10);
        n.a r8 = n.f38560a;     // Catch: Throwable -> L13
        Context r11 = f16342e;     // Catch: Throwable -> L13
        Bundle r0 = null;
        String r1 = null;
        r0 = null;
        if (r11 == null) goto L11;
        ContentResolver r2 = r11.getContentResolver();     // Catch: Throwable -> L13
        if (r2 == null) goto L11;
        Uri r3 = com.obric.aiagent.assistant_card.provider_core.a.a.f16331a.a();     // Catch: Throwable -> L13
        Bundle r6 = new Bundle();     // Catch: Throwable -> L13
        r6.putString("card_uri", r9.toString());     // Catch: Throwable -> L13
        if (r10 == null) goto L10;
        r1 = r10.toString();     // Catch: Throwable -> L13
    L10:
        r6.putString("card_extra_params", r1);     // Catch: Throwable -> L13
        x r12 = x.f38692a;     // Catch: Throwable -> L13
        r0 = ZeusProviderTransform.call(r2, r3, "notify_card_change", "", r6, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
    L11:
        Object r13 = n.f(r0);     // Catch: Throwable -> L13
    L15:
        Throwable r14 = n.c(r13);
        if (r14 == null) goto L19;
        com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(TAG, "notifyWithCP failed: " + r14.getMessage(), r14);
    L19:
        if (n.a(r13) == false) goto L24;
        Bundle r15 = (Bundle) ZeusTransformUtils.preCheckCast(r13, Bundle.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(TAG, "notifyWithCP succeed");
        return;
    L24:
        return;
    L13:
        th = move-exception;
        n.a r16 = n.f38560a;
        r13 = n.f(o.a(th));
        goto L15
    }

    public final void a(com.obric.aiagent.assistant_card.provider_core.bean.b r3) {
        d.h.b.o.e(r3, "dialogBean");
        Bundle r0 = new Bundle();
        r0.putBundle("data_bean", r3.a());
        x r4 = x.f38692a;
        a("show_dialog", r0);
    }

    private final void a(String r10, Bundle r11) {
        com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(TAG, "callHostMethod: methodName = " + r10 + ", methodParams = " + r11);
        i.a(f(), null, null, (m) ZeusTransformUtils.preCheckCast(new a(r10, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final Bundle a(Context r9, Uri r10, JSONObject r11, boolean r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "context");
        d.h.b.o.e(r10, "cardUri");
        com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(TAG, "getCard: cardUri = " + r10);
        Bundle r0 = new Bundle();
        n.a r4 = n.f38560a;     // Catch: Throwable -> L22
        String r5 = g.a(r10);     // Catch: Throwable -> L22
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (r6 != null) goto L6;
    L9:
        boolean r7 = true;
    L10:
        if (r7 == false) goto L12;
        com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.b(TAG, "queryCard: empty cardType");     // Catch: Throwable -> L22
    L20:
        Object r14 = n.f(x.f38692a);     // Catch: Throwable -> L22
    L24:
        Throwable r15 = n.c(r14);
        if (r15 == null) goto L30;
        com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(TAG, "get card failed: " + r15.getMessage(), r15);
        r0.putBoolean("succeed", false);
        String r8 = r15.getMessage();
        if (r8 != null) goto L29;
        r8 = "";
    L29:
        r0.putString("error_msg", r8);
    L30:
        return r0;
    L12:
        com.obric.aiagent.assistant_card.provider_core.a r1 = (com.obric.aiagent.assistant_card.provider_core.a) ZeusTransformUtils.preCheckCast(f16339b.get(r5), com.obric.aiagent.assistant_card.provider_core.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (r1 != null) goto L15;
        com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.b(TAG, "queryCard: no cardProvider for cardType: " + r5);     // Catch: Throwable -> L22
        goto L20
    L15:
        com.obric.aiagent.assistant_card.provider_core.bean.c r16 = r1.a(r13, r10, r11, r12);     // Catch: Throwable -> L22
        if (r16 == null) goto L18;
        Bundle r17 = r16.a(Boolean.valueOf(r12));     // Catch: Throwable -> L22
    L19:
        r0.putBundle("remote_card", r17);     // Catch: Throwable -> L22
        r0.putBoolean("succeed", true);     // Catch: Throwable -> L22
        goto L20
    L18:
        r17 = null;
        goto L19
    L6:
        if (r6.length() == 0) goto L9;
        r7 = false;
    L22:
        th = move-exception;
        n.a r18 = n.f38560a;
        r14 = n.f(o.a(th));
        goto L24
    }

    public final void a(Context r11, Uri r12, Bundle r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r14, "context");
        d.h.b.o.e(r12, "cardUri");
        d.h.b.o.e(r13, "cardAction");
        com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(TAG, "handleCardAction: " + r12 + ", " + r13);
        i.a(f(), null, null, (m) ZeusTransformUtils.preCheckCast(new C0327b(r13, r12, r14, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(Context r10, IHostApi r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        IHostApi r13 = (IHostApi) ZeusTransformUtils.wrapperContextForParams(r11, IHostApi.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r12, "context");
        com.obric.aiagent.assistant_card.provider_core.a.b.f16333a.a(TAG, "setHostApi: " + r13);
        i.a(f(), null, null, (m) ZeusTransformUtils.preCheckCast(new d(r13, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
