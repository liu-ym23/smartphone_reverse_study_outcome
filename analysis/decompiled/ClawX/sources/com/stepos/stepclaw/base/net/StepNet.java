package com.stepos.stepclaw.base.net;

import a6.w;
import android.app.Application;
import android.provider.Settings;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.net.bean.StepOSCredentials;
import h5.e;
import i6.c;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001'B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0012J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0006J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010%¨\u0006("}, d2 = {"Lcom/stepos/stepclaw/base/net/StepNet;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Lcom/stepos/stepclaw/base/net/StepNet$NetEnv;", "readNetEnv", "()Lcom/stepos/stepclaw/base/net/StepNet$NetEnv;", "Landroid/app/Application;", "app", "Lkotlin/Function1;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lb5/a0;", "newBaseUrlReady", "init", "(Landroid/app/Application;Lp5/l;)V", "handleNetEnvChanged", "(Lf5/c;)Ljava/lang/Object;", "getMemoryBaseUrl", "()Ljava/lang/String;", "getDataHubBaseUrl", "getStepOsBaseUrl", "getNetEnv", "Lcom/stepos/stepclaw/base/net/bean/StepOSCredentials;", "getSigningCredentials", "()Lcom/stepos/stepclaw/base/net/bean/StepOSCredentials;", "TAG", "Ljava/lang/String;", "application", "Landroid/app/Application;", "cachedNetEnv", "Lcom/stepos/stepclaw/base/net/StepNet$NetEnv;", "onNewBaseUrlReady", "Lp5/l;", "Li6/a;", "envMutex", "Li6/a;", "CREDENTIALS_TEST", "Lcom/stepos/stepclaw/base/net/bean/StepOSCredentials;", "CREDENTIALS_PROD", "NetEnv", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StepNet {
    private static final String TAG = "StepNet";
    private static Application application;
    private static l onNewBaseUrlReady;
    public static final StepNet INSTANCE = new StepNet();
    private static volatile NetEnv cachedNetEnv = NetEnv.PROD;
    private static final i6.a envMutex = new c();
    private static final StepOSCredentials CREDENTIALS_TEST = new StepOSCredentials("stepclaw-test", "2JeLrjkUCzh89Zdngiyo");
    private static final StepOSCredentials CREDENTIALS_PROD = new StepOSCredentials("45327196803966073098", "aVSD6N4s3M5kqzUGobyijAF9mpv0tOc1");

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/stepclaw/base/net/StepNet$NetEnv;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;I)V", "DEV", "TEST", "STG", "PROD", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class NetEnv {
        private static final /* synthetic */ i5.a $ENTRIES;
        private static final /* synthetic */ NetEnv[] $VALUES;
        public static final NetEnv DEV = new NetEnv("DEV", 0);
        public static final NetEnv TEST = new NetEnv("TEST", 1);
        public static final NetEnv STG = new NetEnv("STG", 2);
        public static final NetEnv PROD = new NetEnv("PROD", 3);

        private static final /* synthetic */ NetEnv[] $values() {
            return new NetEnv[]{DEV, TEST, STG, PROD};
        }

        static {
            NetEnv[] netEnvArr$values = $values();
            $VALUES = netEnvArr$values;
            $ENTRIES = a.a.F(netEnvArr$values);
        }

        private NetEnv(String str, int i8) {
        }

        public static i5.a getEntries() {
            return $ENTRIES;
        }

        public static NetEnv valueOf(String str) {
            return (NetEnv) Enum.valueOf(NetEnv.class, str);
        }

        public static NetEnv[] values() {
            return (NetEnv[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NetEnv.values().length];
            try {
                iArr[NetEnv.DEV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NetEnv.TEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NetEnv.STG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NetEnv.PROD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.base.net.StepNet", f = "StepNet.kt", l = {128}, m = "handleNetEnvChanged", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.base.net.StepNet$handleNetEnvChanged$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.c {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StepNet.this.handleNetEnvChanged(this);
        }
    }

    private StepNet() {
    }

    private final NetEnv readNetEnv() {
        Application application2 = application;
        if (application2 == null) {
            p.l("application");
            throw null;
        }
        String string = Settings.Secure.getString(application2.getContentResolver(), "net_env");
        if (string != null) {
            int iHashCode = string.hashCode();
            if (iHashCode != 99349) {
                if (iHashCode != 114214) {
                    if (iHashCode == 3556498 && string.equals("test")) {
                        return NetEnv.TEST;
                    }
                } else if (string.equals("stg")) {
                    return NetEnv.STG;
                }
            } else if (string.equals("dev")) {
                return NetEnv.DEV;
            }
        }
        return NetEnv.PROD;
    }

    public final String getDataHubBaseUrl() {
        int i8 = WhenMappings.$EnumSwitchMapping$0[cachedNetEnv.ordinal()];
        if (i8 == 1 || i8 == 2) {
            return "https://biz-gw.t-stepos.com";
        }
        if (i8 == 3 || i8 == 4) {
            return "https://biz-gw.stepos.com";
        }
        throw new w();
    }

    public final String getMemoryBaseUrl() {
        int i8 = WhenMappings.$EnumSwitchMapping$0[cachedNetEnv.ordinal()];
        if (i8 == 1 || i8 == 2) {
            return "https://biz-gw.t-stepos.com/mem/api/v1/lightMem";
        }
        if (i8 == 3 || i8 == 4) {
            return "https://biz-gw.stepos.com/mem/api/v1/lightMem";
        }
        throw new w();
    }

    public final NetEnv getNetEnv() {
        return cachedNetEnv;
    }

    public final StepOSCredentials getSigningCredentials() {
        int i8 = WhenMappings.$EnumSwitchMapping$0[cachedNetEnv.ordinal()];
        if (i8 == 1 || i8 == 2) {
            return CREDENTIALS_TEST;
        }
        if (i8 == 3 || i8 == 4) {
            return CREDENTIALS_PROD;
        }
        throw new w();
    }

    public final String getStepOsBaseUrl() {
        int i8 = WhenMappings.$EnumSwitchMapping$0[cachedNetEnv.ordinal()];
        if (i8 == 1 || i8 == 2) {
            return "https://biz-gw.t-stepos.com";
        }
        if (i8 == 3 || i8 == 4) {
            return "https://biz-gw.stepos.com";
        }
        throw new w();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleNetEnvChanged(f5.c r7) {
        /*
            r6 = this;
            b5.a0 r0 = b5.a0.f883a
            java.lang.String r1 = "net_env changed → "
            boolean r2 = r7 instanceof com.stepos.stepclaw.base.net.StepNet.AnonymousClass1
            if (r2 == 0) goto L17
            r2 = r7
            com.stepos.stepclaw.base.net.StepNet$handleNetEnvChanged$1 r2 = (com.stepos.stepclaw.base.net.StepNet.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.stepos.stepclaw.base.net.StepNet$handleNetEnvChanged$1 r2 = new com.stepos.stepclaw.base.net.StepNet$handleNetEnvChanged$1
            r2.<init>(r7)
        L1c:
            java.lang.Object r6 = r2.result
            g5.a r7 = g5.a.f2984a
            int r3 = r2.label
            r4 = 1
            if (r3 == 0) goto L37
            if (r3 != r4) goto L2f
            java.lang.Object r7 = r2.L$0
            i6.a r7 = (i6.a) r7
            a.a.c0(r6)
            goto L4d
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            a.a.c0(r6)
            i6.a r6 = com.stepos.stepclaw.base.net.StepNet.envMutex
            r2.L$0 = r6
            r3 = 0
            r2.I$0 = r3
            r2.label = r4
            i6.c r6 = (i6.c) r6
            java.lang.Object r2 = r6.c(r2)
            if (r2 != r7) goto L4c
            return r7
        L4c:
            r7 = r6
        L4d:
            r6 = 0
            com.stepos.stepclaw.base.net.StepNet r2 = com.stepos.stepclaw.base.net.StepNet.INSTANCE     // Catch: java.lang.Throwable -> L7e
            com.stepos.stepclaw.base.net.StepNet$NetEnv r3 = r2.readNetEnv()     // Catch: java.lang.Throwable -> L7e
            com.stepos.stepclaw.base.net.StepNet$NetEnv r4 = com.stepos.stepclaw.base.net.StepNet.cachedNetEnv     // Catch: java.lang.Throwable -> L7e
            if (r3 != r4) goto L5e
        L58:
            i6.c r7 = (i6.c) r7
            r7.e(r6)
            return r0
        L5e:
            com.stepos.stepclaw.base.net.StepNet.cachedNetEnv = r3     // Catch: java.lang.Throwable -> L7e
            java.lang.String r4 = "StepNet"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L7e
            r5.append(r3)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r1 = r5.toString()     // Catch: java.lang.Throwable -> L7e
            r3 = 4
            com.stepos.stepclaw.base.util.ALog.i$default(r4, r1, r6, r3, r6)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r1 = r2.getMemoryBaseUrl()     // Catch: java.lang.Throwable -> L7e
            p5.l r2 = com.stepos.stepclaw.base.net.StepNet.onNewBaseUrlReady     // Catch: java.lang.Throwable -> L7e
            if (r2 == 0) goto L80
            r2.invoke(r1)     // Catch: java.lang.Throwable -> L7e
            goto L58
        L7e:
            r0 = move-exception
            goto L86
        L80:
            java.lang.String r0 = "onNewBaseUrlReady"
            kotlin.jvm.internal.p.l(r0)     // Catch: java.lang.Throwable -> L7e
            throw r6     // Catch: java.lang.Throwable -> L7e
        L86:
            i6.c r7 = (i6.c) r7
            r7.e(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.base.net.StepNet.handleNetEnvChanged(f5.c):java.lang.Object");
    }

    public final void init(Application app, l newBaseUrlReady) {
        p.e(app, "app");
        p.e(newBaseUrlReady, "newBaseUrlReady");
        application = app;
        cachedNetEnv = readNetEnv();
        onNewBaseUrlReady = newBaseUrlReady;
        newBaseUrlReady.invoke(getMemoryBaseUrl());
    }
}
