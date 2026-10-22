package com.stepos.taskrobot.appwhitelist.remote;

import J7.c;
import S0.b;
import S7.a;
import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.AbstractC1607a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/stepos/taskrobot/appwhitelist/remote/MockWhitelistRemoteSource;", "Lcom/stepos/taskrobot/appwhitelist/remote/WhitelistRemoteSource;", "Lkotlin/Function0;", "", "jsonProvider", AppAgent.CONSTRUCT, "(LS7/a;)V", "Landroid/content/Context;", "context", "(Landroid/content/Context;)V", "Lcom/stepos/taskrobot/appwhitelist/remote/dto/WhitelistManifestDto;", "fetch", "(LH7/c;)Ljava/lang/Object;", "LS7/a;", "Companion", "appwhitelist_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MockWhitelistRemoteSource implements WhitelistRemoteSource {
    public static final String ASSET_NAME = "whitelist_default.json";
    private final a jsonProvider;

    @c(c = "com.stepos.taskrobot.appwhitelist.remote.MockWhitelistRemoteSource", f = "MockWhitelistRemoteSource.kt", l = {22}, m = "fetch", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.appwhitelist.remote.MockWhitelistRemoteSource$fetch$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MockWhitelistRemoteSource.this.fetch(this);
        }
    }

    public MockWhitelistRemoteSource(a jsonProvider) {
        k.f(jsonProvider, "jsonProvider");
        this.jsonProvider = jsonProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$0(Context context) throws IOException {
        InputStream inputStreamOpen = context.getAssets().open(ASSET_NAME);
        k.e(inputStreamOpen, "open(...)");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, AbstractC1607a.f4778a), 8192);
        try {
            String strO1 = b.o1(bufferedReader);
            bufferedReader.close();
            return strO1;
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.taskrobot.appwhitelist.remote.WhitelistRemoteSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object fetch(H7.c<? super com.stepos.taskrobot.appwhitelist.remote.dto.WhitelistManifestDto> r5) throws com.google.gson.JsonSyntaxException {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.taskrobot.appwhitelist.remote.MockWhitelistRemoteSource.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.taskrobot.appwhitelist.remote.MockWhitelistRemoteSource$fetch$1 r0 = (com.stepos.taskrobot.appwhitelist.remote.MockWhitelistRemoteSource.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.appwhitelist.remote.MockWhitelistRemoteSource$fetch$1 r0 = new com.stepos.taskrobot.appwhitelist.remote.MockWhitelistRemoteSource$fetch$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.b.b(r5)
            goto L3d
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r5)
            r0.label = r3
            r2 = 200(0xc8, double:9.9E-322)
            java.lang.Object r5 = kotlinx.coroutines.a.f(r2, r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            S7.a r4 = r4.jsonProvider
            java.lang.Object r4 = r4.invoke()
            java.lang.String r4 = (java.lang.String) r4
            com.google.gson.Gson r5 = new com.google.gson.Gson
            r5.<init>()
            java.lang.Class<com.stepos.taskrobot.appwhitelist.remote.dto.WhitelistManifestDto> r0 = com.stepos.taskrobot.appwhitelist.remote.dto.WhitelistManifestDto.class
            java.lang.Object r4 = r5.fromJson(r4, r0)
            java.lang.String r5 = "fromJson(...)"
            kotlin.jvm.internal.k.e(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.appwhitelist.remote.MockWhitelistRemoteSource.fetch(H7.c):java.lang.Object");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MockWhitelistRemoteSource(Context context) {
        this(new F6.c(context, 2));
        k.f(context, "context");
    }
}
