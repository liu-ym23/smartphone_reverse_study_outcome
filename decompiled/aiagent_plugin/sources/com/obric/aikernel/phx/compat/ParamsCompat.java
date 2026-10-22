package com.obric.aikernel.phx.compat;

import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.os.Parcelable;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.SdkContext;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.ext.Params;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.n;
import d.o;
import d.x;

/* JADX INFO: compiled from: ParamsCompat.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ParamsCompat {
    public static final ParamsCompat INSTANCE = null;
    private static final String TAG = "ParamsCompat";

    /* JADX INFO: renamed from: com.obric.aikernel.phx.compat.ParamsCompat$grantUri$1, reason: invalid class name */
    /* JADX INFO: compiled from: ParamsCompat.kt */
    @f(b = "ParamsCompat.kt", c = {31}, d = "grantUri", e = "com.obric.aikernel.phx.compat.ParamsCompat")
    static final class AnonymousClass1 extends d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ParamsCompat this$0;

        AnonymousClass1(ParamsCompat r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return ParamsCompat.access$grantUri(this.this$0, null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.compat.ParamsCompat$onStartCompat$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ParamsCompat.kt */
    @f(b = "ParamsCompat.kt", c = {25}, d = "onStartCompat", e = "com.obric.aikernel.phx.compat.ParamsCompat")
    static final class C11171 extends d {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ParamsCompat this$0;

        C11171(ParamsCompat r3, d.c.d<? super C11171> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return ParamsCompat.access$onStartCompat(this.this$0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.compat.ParamsCompat$startCompat$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ParamsCompat.kt */
    @f(b = "ParamsCompat.kt", c = {16}, d = "startCompat", e = "com.obric.aikernel.phx.compat.ParamsCompat")
    static final class C11181 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ParamsCompat this$0;

        C11181(ParamsCompat r3, d.c.d<? super C11181> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.startCompat(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        INSTANCE = new ParamsCompat();
    }

    private ParamsCompat() {
    }

    public static final /* synthetic */ Object access$grantUri(ParamsCompat r6, String r7, AssetFileDescriptor r8, long r9, d.c.d r11) {
        return r6.grantUri(r7, r8, r9, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$onStartCompat(ParamsCompat r2, RequestParams r3, d.c.d r4) {
        return r2.onStartCompat(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final Object startCompat(RequestParams r6, d.c.d<? super Bundle> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, C11181.class) == false) goto L7;
        C11181 r0 = (C11181) ZeusTransformUtils.preCheckCast(r8, C11181.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = b.a();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        RequestParams r5 = (RequestParams) ZeusTransformUtils.preCheckCast(r0.L$0, RequestParams.class, "com.obric.aiagent.plugin");
        o.a(r9);
        r6 = r5;
    L20:
        return r6.start();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r9);
        if (SdkContext.INSTANCE.isLegacyArch() == false) goto L20;
        r0.L$0 = r6;
        r0.label = 1;
        if (onStartCompat(r6, r0) != r2) goto L20;
        return r2;
    L7:
        r0 = new C11181(this, r8);
        goto L8
    }

    private final Object onStartCompat(RequestParams r11, d.c.d<? super x> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, C11171.class) == false) goto L7;
        C11171 r0 = (C11171) ZeusTransformUtils.preCheckCast(r13, C11171.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        C11171 r7 = r0;
        Object r10 = r7.result;
        Object r14 = b.a();
        int r1 = r7.label;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L13;
        o.a(r10);
    L22:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r10);
        String r3 = r11.getBackend().getString(Params.FILE_PATH);
        if (r3 == null) goto L22;
        AssetFileDescriptor r4 = (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r11.getBackend().getParcelable(Params.FD_ASSET), AssetFileDescriptor.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L22;
        ParamsCompat r15 = INSTANCE;
        r7.label = 1;
        if (grantUri$default(r15, r3, r4, 0, r7, 4, null) != r14) goto L22;
        return r14;
    L7:
        r0 = new C11171(this, r13);
        goto L8
    }

    private final Object grantUri(String r7, AssetFileDescriptor r8, long r9, d.c.d<? super x> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r1 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r12, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r1.result;
        Object r3 = b.a();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        r9 = r1.J$0;
        r8 = (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r1.L$2, AssetFileDescriptor.class, "com.obric.aiagent.plugin");
        r7 = (String) ZeusTransformUtils.preCheckCast(r1.L$1, String.class, "com.obric.aiagent.plugin");
        ParamsCompat this = (ParamsCompat) ZeusTransformUtils.preCheckCast(r1.L$0, ParamsCompat.class, "com.obric.aiagent.plugin");
        o.a(r13);
    L17:
        AIKBinder r14 = (AIKBinder) ZeusTransformUtils.preCheckCast(r13, AIKBinder.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L27;
        ParamsCompat r6 = (ParamsCompat) ZeusTransformUtils.preCheckCast(this, ParamsCompat.class, "com.obric.aiagent.plugin");
        AIKLog.INSTANCE.w(TAG, "grantUri get null binder!");
    L26:
        return x.f38692a;
    L27:
        n.a r10 = n.f38560a;     // Catch: Throwable -> L21
        Bundle r15 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_GrantUri, TAG, "grantUri");     // Catch: Throwable -> L21
        r15.putString(IdlKeys.Args_GrantUri, r7);     // Catch: Throwable -> L21
        r15.putParcelable(IdlKeys.Args_GrantFd, (Parcelable) ZeusTransformUtils.preCheckCast(r8, Parcelable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21
        r15.putLong(IdlKeys.Args_Timeout, r9);     // Catch: Throwable -> L21
        Object r16 = n.f(r14.callModelSync(r15));     // Catch: Throwable -> L21
    L23:
        n.g(r16);
    L21:
        th = move-exception;
        n.a r17 = n.f38560a;
        r16 = n.f(o.a(th));
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r13);
        SdkContext r18 = SdkContext.INSTANCE;
        r1.L$0 = this;
        r1.L$1 = r7;
        r1.L$2 = r8;
        r1.J$0 = r9;
        r1.label = 1;
        r13 = r18.getBinder(r1);
        if (r13 != r3) goto L17;
        return r3;
    L7:
        r1 = new AnonymousClass1(this, r12);
        goto L8
    }

    static /* synthetic */ Object grantUri$default(ParamsCompat r6, String r7, AssetFileDescriptor r8, long r9, d.c.d r11, int r12, Object r13) {
        d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r12 & 4) == 0) goto L6;
        r9 = DownloadConstants.HOUR;
    L6:
        return r6.grantUri(r7, r8, r9, r5);
    }
}
