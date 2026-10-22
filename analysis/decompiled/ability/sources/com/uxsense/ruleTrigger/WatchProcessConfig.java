package com.uxsense.ruleTrigger;

import C7.r;
import D7.N;
import O7.i;
import S7.n;
import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.ApexMetadataFileManager;
import j9.AbstractC1607a;
import j9.m;
import j9.t;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u00017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b \u0010!J\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\rH\u0086@¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0004¢\u0006\u0004\b%\u0010\u0003J\u0017\u0010)\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\rH\u0000¢\u0006\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010+R\u001c\u0010/\u001a\n .*\u0004\u0018\u00010-0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00101\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/uxsense/ruleTrigger/WatchProcessConfig;", "", AppAgent.CONSTRUCT, "()V", "LC7/r;", "loadConfig", "Lcom/uxsense/ruleTrigger/WatchProcessConfig$WatchConfig;", "readFromFile", "()Lcom/uxsense/ruleTrigger/WatchProcessConfig$WatchConfig;", "readFromAssets", "Lorg/json/JSONArray;", "array", "", "", "parseProcessArray", "(Lorg/json/JSONArray;)Ljava/util/Set;", "", "version", "updatedAt", "processes", "saveConfig", "(ILjava/lang/String;Ljava/util/Set;LH7/c;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "getWatchProcesses", "()Ljava/util/Set;", "getVersion", "()I", "processName", "", "isWatchedProcess", "(Ljava/lang/String;)Z", "remoteJson", "applyRemoteConfig", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "refresh", "jsonContent", "parseConfig$uxsense_release", "(Ljava/lang/String;)Lcom/uxsense/ruleTrigger/WatchProcessConfig$WatchConfig;", "parseConfig", "TAG", "Ljava/lang/String;", "ASSET_FILE_NAME", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "dateFormatter", "Ljava/time/format/DateTimeFormatter;", "applicationContext", "Landroid/content/Context;", "cachedProcesses", "Ljava/util/Set;", "cachedVersion", "I", "WatchConfig", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WatchProcessConfig {
    private static final String ASSET_FILE_NAME = "watch_processes.json";
    private static final String TAG = "WatchProcessConfig";
    private static volatile Context applicationContext;
    private static volatile int cachedVersion;
    public static final WatchProcessConfig INSTANCE = new WatchProcessConfig();
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static volatile Set<String> cachedProcesses = EmptySet.f4895a;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/uxsense/ruleTrigger/WatchProcessConfig$WatchConfig;", "", "version", "", "updatedAt", "", "processes", "", AppAgent.CONSTRUCT, "(ILjava/lang/String;Ljava/util/Set;)V", "getVersion", "()I", "getUpdatedAt", "()Ljava/lang/String;", "getProcesses", "()Ljava/util/Set;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class WatchConfig {
        private final Set<String> processes;
        private final String updatedAt;
        private final int version;

        public WatchConfig(int i, String str, Set<String> processes) {
            k.f(processes, "processes");
            this.version = i;
            this.updatedAt = str;
            this.processes = processes;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WatchConfig copy$default(WatchConfig watchConfig, int i, String str, Set set, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = watchConfig.version;
            }
            if ((i6 & 2) != 0) {
                str = watchConfig.updatedAt;
            }
            if ((i6 & 4) != 0) {
                set = watchConfig.processes;
            }
            return watchConfig.copy(i, str, set);
        }

        /* renamed from: component1, reason: from getter */
        public final int getVersion() {
            return this.version;
        }

        /* renamed from: component2, reason: from getter */
        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        public final Set<String> component3() {
            return this.processes;
        }

        public final WatchConfig copy(int version, String updatedAt, Set<String> processes) {
            k.f(processes, "processes");
            return new WatchConfig(version, updatedAt, processes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WatchConfig)) {
                return false;
            }
            WatchConfig watchConfig = (WatchConfig) other;
            return this.version == watchConfig.version && k.b(this.updatedAt, watchConfig.updatedAt) && k.b(this.processes, watchConfig.processes);
        }

        public final Set<String> getProcesses() {
            return this.processes;
        }

        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        public final int getVersion() {
            return this.version;
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.version) * 31;
            String str = this.updatedAt;
            return this.processes.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
        }

        public String toString() {
            return "WatchConfig(version=" + this.version + ", updatedAt=" + this.updatedAt + ", processes=" + this.processes + ')';
        }
    }

    @J7.c(c = "com.uxsense.ruleTrigger.WatchProcessConfig", f = "WatchProcessConfig.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT}, m = "applyRemoteConfig")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.ruleTrigger.WatchProcessConfig$applyRemoteConfig$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WatchProcessConfig.this.applyRemoteConfig(null, this);
        }
    }

    @J7.c(c = "com.uxsense.ruleTrigger.WatchProcessConfig$saveConfig$2", f = "WatchProcessConfig.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)I"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.ruleTrigger.WatchProcessConfig$saveConfig$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ Set<String> $processes;
        final /* synthetic */ String $updatedAt;
        final /* synthetic */ int $version;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i, String str, Set<String> set, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$version = i;
            this.$updatedAt = str;
            this.$processes = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$version, this.$updatedAt, this.$processes, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int iE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            try {
                File file = ApexMetadataFileManager.INSTANCE.getWatchProcessesFile().toFile();
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", this.$version);
                jSONObject.put("updatedAt", this.$updatedAt);
                JSONArray jSONArray = new JSONArray();
                Iterator<T> it = this.$processes.iterator();
                while (it.hasNext()) {
                    jSONArray.put((String) it.next());
                }
                jSONObject.put("processes", jSONArray);
                String string = jSONObject.toString(2);
                k.e(string, "toString(...)");
                i.Y(file, string);
                iE = Log.d(WatchProcessConfig.TAG, "saveConfig: saved v" + this.$version + " to " + file.getAbsolutePath());
            } catch (Exception e) {
                iE = Log.e(WatchProcessConfig.TAG, "saveConfig: failed", e);
            }
            return new Integer(iE);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Integer> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    private WatchProcessConfig() {
    }

    private final void loadConfig() throws IOException {
        WatchConfig fromFile = readFromFile();
        if (fromFile == null) {
            fromFile = readFromAssets();
        }
        if (fromFile == null) {
            Log.w(TAG, "loadConfig: no config found, using empty set");
            cachedProcesses = EmptySet.f4895a;
            cachedVersion = 0;
            return;
        }
        cachedProcesses = fromFile.getProcesses();
        cachedVersion = fromFile.getVersion();
        Log.d(TAG, "loadConfig: v" + fromFile.getVersion() + ", processes=" + fromFile.getProcesses().size());
    }

    private final Set<String> parseProcessArray(JSONArray array) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = array.length();
        for (int i = 0; i < length; i++) {
            String strOptString = array.optString(i, null);
            if (strOptString != null && !m.s0(strOptString)) {
                linkedHashSet.add(strOptString);
            }
        }
        return linkedHashSet;
    }

    private final WatchConfig readFromAssets() throws IOException {
        Context context = applicationContext;
        if (context == null) {
            return null;
        }
        try {
            InputStream inputStreamOpen = context.getAssets().open(ASSET_FILE_NAME);
            try {
                k.c(inputStreamOpen);
                String strO1 = S0.b.o1(new BufferedReader(new InputStreamReader(inputStreamOpen, AbstractC1607a.f4778a), 8192));
                N.t(inputStreamOpen, null);
                WatchConfig config$uxsense_release = parseConfig$uxsense_release(strO1);
                Log.d(TAG, "readFromAssets: loaded from assets/watch_processes.json");
                return config$uxsense_release;
            } finally {
            }
        } catch (Exception unused) {
            Log.d(TAG, "readFromAssets: assets/watch_processes.json not found");
            return null;
        }
    }

    private final WatchConfig readFromFile() {
        try {
            File file = ApexMetadataFileManager.INSTANCE.getWatchProcessesFile().toFile();
            if (!file.exists()) {
                return null;
            }
            WatchConfig config$uxsense_release = parseConfig$uxsense_release(i.X(file, AbstractC1607a.f4778a));
            Log.d(TAG, "readFromFile: loaded from " + file.getAbsolutePath());
            return config$uxsense_release;
        } catch (Exception e) {
            Log.e(TAG, "readFromFile: failed", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveConfig(int i, String str, Set<String> set, H7.c<? super Integer> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(i, str, set, null), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object applyRemoteConfig(java.lang.String r7, H7.c<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.uxsense.ruleTrigger.WatchProcessConfig.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.uxsense.ruleTrigger.WatchProcessConfig$applyRemoteConfig$1 r0 = (com.uxsense.ruleTrigger.WatchProcessConfig.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.ruleTrigger.WatchProcessConfig$applyRemoteConfig$1 r0 = new com.uxsense.ruleTrigger.WatchProcessConfig$applyRemoteConfig$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "WatchProcessConfig"
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r6 = r0.L$0
            com.uxsense.ruleTrigger.WatchProcessConfig$WatchConfig r6 = (com.uxsense.ruleTrigger.WatchProcessConfig.WatchConfig) r6
            kotlin.b.b(r8)
            goto Lad
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            kotlin.b.b(r8)
            com.uxsense.ruleTrigger.WatchProcessConfig$WatchConfig r7 = r6.parseConfig$uxsense_release(r7)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r2 = "applyRemoteConfig: remoteVersion="
            r8.<init>(r2)
            int r2 = r7.getVersion()
            r8.append(r2)
            java.lang.String r2 = ", localVersion="
            r8.append(r2)
            int r2 = com.uxsense.ruleTrigger.WatchProcessConfig.cachedVersion
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            android.util.Log.d(r4, r8)
            int r8 = r7.getVersion()
            int r2 = com.uxsense.ruleTrigger.WatchProcessConfig.cachedVersion
            if (r8 > r2) goto L86
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "applyRemoteConfig: skip, remote version "
            r6.<init>(r8)
            int r7 = r7.getVersion()
            r6.append(r7)
            java.lang.String r7 = " <= local "
            r6.append(r7)
            int r7 = com.uxsense.ruleTrigger.WatchProcessConfig.cachedVersion
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r4, r6)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        L86:
            java.lang.String r8 = r7.getUpdatedAt()
            if (r8 != 0) goto L96
            java.time.LocalDate r8 = java.time.LocalDate.now()
            java.time.format.DateTimeFormatter r2 = com.uxsense.ruleTrigger.WatchProcessConfig.dateFormatter
            java.lang.String r8 = r8.format(r2)
        L96:
            int r2 = r7.getVersion()
            kotlin.jvm.internal.k.c(r8)
            java.util.Set r5 = r7.getProcesses()
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r6 = r6.saveConfig(r2, r8, r5, r0)
            if (r6 != r1) goto Lac
            return r1
        Lac:
            r6 = r7
        Lad:
            java.util.Set r7 = r6.getProcesses()
            com.uxsense.ruleTrigger.WatchProcessConfig.cachedProcesses = r7
            int r7 = r6.getVersion()
            com.uxsense.ruleTrigger.WatchProcessConfig.cachedVersion = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "applyRemoteConfig: updated to v"
            r7.<init>(r8)
            int r8 = r6.getVersion()
            r7.append(r8)
            java.lang.String r8 = ", processes="
            r7.append(r8)
            java.util.Set r6 = r6.getProcesses()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            android.util.Log.i(r4, r6)
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ruleTrigger.WatchProcessConfig.applyRemoteConfig(java.lang.String, H7.c):java.lang.Object");
    }

    public final int getVersion() {
        return cachedVersion;
    }

    public final Set<String> getWatchProcesses() {
        return cachedProcesses;
    }

    public final void init(Context context) {
        k.f(context, "context");
        applicationContext = context.getApplicationContext();
        loadConfig();
    }

    public final boolean isWatchedProcess(String processName) {
        return processName != null && cachedProcesses.contains(processName);
    }

    public final WatchConfig parseConfig$uxsense_release(String jsonContent) {
        k.f(jsonContent, "jsonContent");
        if (t.e0(m.U0(jsonContent).toString(), "[", false)) {
            return new WatchConfig(0, null, parseProcessArray(new JSONArray(jsonContent)));
        }
        JSONObject jSONObject = new JSONObject(jsonContent);
        int iOptInt = jSONObject.optInt("version", 0);
        String strOptString = jSONObject.optString("updatedAt", null);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("processes");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        return new WatchConfig(iOptInt, strOptString, parseProcessArray(jSONArrayOptJSONArray));
    }

    public final void refresh() throws IOException {
        loadConfig();
    }
}
