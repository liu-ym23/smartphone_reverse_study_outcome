package com.uxsense;

import S7.n;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.ApexMetadataFileManager;
import com.uxsense.rule.ApexTriggerRuleEditor;
import com.uxsense.ruleTrigger.ApexTriggerManager;
import com.uxsense.ruleTrigger.TriggerRule;
import com.uxsense.ruleTrigger.WatchProcessConfig;
import com.uxsense.utils.ALog;
import io.modelcontextprotocol.spec.McpSchema;
import j9.m;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\b\u0004*\u0001F\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J,\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u000f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\b0\u0013H\u0087@¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0016H\u0087@¢\u0006\u0004\b\u0017\u0010\u001aJ&\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087@¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0016H\u0087@¢\u0006\u0004\b\u001f\u0010\u001aJ \u0010!\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH\u0087@¢\u0006\u0004\b!\u0010\u001eJ\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0087@¢\u0006\u0004\b\"\u0010#J\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c2\u0006\u0010\u0012\u001a\u00020\u000fH\u0007¢\u0006\u0004\b$\u0010%J \u0010'\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000fH\u0087@¢\u0006\u0004\b'\u0010\u001eJ\u0018\u0010(\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u000fH\u0087@¢\u0006\u0004\b(\u0010#J\u0015\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0)H\u0007¢\u0006\u0004\b*\u0010+J\u0019\u0010.\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010,H\u0007¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020,H\u0007¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0007¢\u0006\u0004\b2\u00103J\u001f\u00104\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020,H\u0007¢\u0006\u0004\b4\u00101J\u000f\u00105\u001a\u00020\bH\u0002¢\u0006\u0004\b5\u0010\u0003J\u0017\u00106\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b6\u00103J\u000f\u00107\u001a\u00020\bH\u0002¢\u0006\u0004\b7\u0010\u0003J1\u0010.\u001a\u00020\b2\u001c\b\u0004\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u000209\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0004\u0012\u00020\b08H\u0086\bø\u0001\u0000¢\u0006\u0004\b.\u0010;J1\u00100\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000f2\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u000209\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0004\u0012\u00020\b08¢\u0006\u0004\b0\u0010<R\u0014\u0010=\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u0010>R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010@R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010AR&\u0010D\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0C0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010H\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006I"}, d2 = {"Lcom/uxsense/ApexSDK;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "Lcom/uxsense/ApexConfig;", "config", "LC7/r;", McpSchema.METHOD_INITIALIZE, "(Landroid/content/Context;Lcom/uxsense/ApexConfig;)V", "release", "", "isInitialized", "()Z", "", "getVersion", "()Ljava/lang/String;", "packageName", "Lkotlin/Function1;", "Lcom/uxsense/ruleTrigger/TriggerRule$Builder;", "block", "Lcom/uxsense/ruleTrigger/TriggerRule;", "createTriggerRule", "(Ljava/lang/String;LS7/k;LH7/c;)Ljava/lang/Object;", "rule", "(Lcom/uxsense/ruleTrigger/TriggerRule;LH7/c;)Ljava/lang/Object;", "json", "", "createTriggerRulesFromJson", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "updateTriggerRule", "ruleName", "deleteTriggerRule", "deleteAllTriggerRules", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "listTriggerRules", "(Ljava/lang/String;)Ljava/util/List;", "remoteJson", "applyRemoteTriggerRules", "applyRemoteWatchProcesses", "", "getWatchProcesses", "()Ljava/util/Set;", "Lcom/uxsense/ruleTrigger/ApexTriggerManager$OnTriggerEventListener;", "listener", "setOnTriggerEventListener", "(Lcom/uxsense/ruleTrigger/ApexTriggerManager$OnTriggerEventListener;)V", "addOnTriggerEventListener", "(Ljava/lang/String;Lcom/uxsense/ruleTrigger/ApexTriggerManager$OnTriggerEventListener;)V", "removeOnTriggerEventListeners", "(Ljava/lang/String;)V", "removeOnTriggerEventListener", "ensureDispatchListenerInstalled", "pushRules", "checkInit", "Lkotlin/Function2;", "", "Landroid/content/Intent;", "(LS7/n;)V", "(Ljava/lang/String;LS7/n;)V", "TAG", "Ljava/lang/String;", "VERSION", "Z", "Lcom/uxsense/ApexConfig;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "packageListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "com/uxsense/ApexSDK$dispatchListener$1", "dispatchListener", "Lcom/uxsense/ApexSDK$dispatchListener$1;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApexSDK {
    private static final String TAG = "ApexSDK";
    public static final String VERSION = "1.0.0";
    private static volatile boolean isInitialized;
    public static final ApexSDK INSTANCE = new ApexSDK();
    private static volatile ApexConfig config = ApexConfig.DEFAULT;
    private static final ConcurrentHashMap<String, List<ApexTriggerManager.OnTriggerEventListener>> packageListeners = new ConcurrentHashMap<>();
    private static final ApexSDK$dispatchListener$1 dispatchListener = new ApexTriggerManager.OnTriggerEventListener() { // from class: com.uxsense.ApexSDK$dispatchListener$1
        @Override // com.uxsense.ruleTrigger.ApexTriggerManager.OnTriggerEventListener
        public void onTriggerEvent(int resultCode, Intent resultIntent) {
            List list;
            String stringExtra = null;
            String stringExtra2 = resultIntent != null ? resultIntent.getStringExtra("targetWindowTitle") : null;
            if (stringExtra2 != null) {
                stringExtra = m.L0(stringExtra2, "/");
            } else if (resultIntent != null) {
                stringExtra = resultIntent.getStringExtra("apex.package");
            }
            if (stringExtra == null || (list = (List) ApexSDK.packageListeners.get(stringExtra)) == null) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((ApexTriggerManager.OnTriggerEventListener) it.next()).onTriggerEvent(resultCode, resultIntent);
            }
        }
    };

    @J7.c(c = "com.uxsense.ApexSDK", f = "ApexSDK.kt", l = {228}, m = "applyRemoteTriggerRules")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.ApexSDK$applyRemoteTriggerRules$1, reason: invalid class name */
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
            return ApexSDK.applyRemoteTriggerRules(null, null, this);
        }
    }

    @J7.c(c = "com.uxsense.ApexSDK", f = "ApexSDK.kt", l = {249}, m = "applyRemoteWatchProcesses")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.ApexSDK$applyRemoteWatchProcesses$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12121 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C12121(H7.c<? super C12121> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSDK.applyRemoteWatchProcesses(null, this);
        }
    }

    @J7.c(c = "com.uxsense.ApexSDK", f = "ApexSDK.kt", l = {141}, m = "createTriggerRule")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.ApexSDK$createTriggerRule$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12131 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12131(H7.c<? super C12131> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSDK.createTriggerRule(null, null, this);
        }
    }

    @J7.c(c = "com.uxsense.ApexSDK", f = "ApexSDK.kt", l = {152}, m = "createTriggerRule")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.ApexSDK$createTriggerRule$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12142 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12142(H7.c<? super C12142> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSDK.createTriggerRule(null, this);
        }
    }

    @J7.c(c = "com.uxsense.ApexSDK", f = "ApexSDK.kt", l = {166}, m = "createTriggerRulesFromJson")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.ApexSDK$createTriggerRulesFromJson$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12151 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12151(H7.c<? super C12151> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSDK.createTriggerRulesFromJson(null, null, this);
        }
    }

    @J7.c(c = "com.uxsense.ApexSDK", f = "ApexSDK.kt", l = {ComposerKt.compositionLocalMapKey}, m = "deleteAllTriggerRules")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.ApexSDK$deleteAllTriggerRules$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12161 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12161(H7.c<? super C12161> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSDK.deleteAllTriggerRules(null, this);
        }
    }

    @J7.c(c = "com.uxsense.ApexSDK", f = "ApexSDK.kt", l = {191}, m = "deleteTriggerRule")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.ApexSDK$deleteTriggerRule$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12171 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12171(H7.c<? super C12171> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSDK.deleteTriggerRule(null, null, this);
        }
    }

    @J7.c(c = "com.uxsense.ApexSDK", f = "ApexSDK.kt", l = {177}, m = "updateTriggerRule")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.ApexSDK$updateTriggerRule$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12191 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12191(H7.c<? super C12191> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSDK.updateTriggerRule(null, this);
        }
    }

    private ApexSDK() {
    }

    public static final void addOnTriggerEventListener(String packageName, ApexTriggerManager.OnTriggerEventListener listener) {
        k.f(packageName, "packageName");
        k.f(listener, "listener");
        ConcurrentHashMap<String, List<ApexTriggerManager.OnTriggerEventListener>> concurrentHashMap = packageListeners;
        final c cVar = new c(9);
        concurrentHashMap.computeIfAbsent(packageName, new Function() { // from class: com.uxsense.e
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ApexSDK.addOnTriggerEventListener$lambda$1(cVar, obj);
            }
        }).add(listener);
        INSTANCE.ensureDispatchListenerInstalled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List addOnTriggerEventListener$lambda$0(String it) {
        k.f(it, "it");
        return new CopyOnWriteArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List addOnTriggerEventListener$lambda$1(S7.k kVar, Object obj) {
        return (List) kVar.invoke(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object applyRemoteTriggerRules(java.lang.String r4, java.lang.String r5, H7.c<? super java.lang.Boolean> r6) {
        /*
            boolean r0 = r6 instanceof com.uxsense.ApexSDK.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.uxsense.ApexSDK$applyRemoteTriggerRules$1 r0 = (com.uxsense.ApexSDK.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.ApexSDK$applyRemoteTriggerRules$1 r0 = new com.uxsense.ApexSDK$applyRemoteTriggerRules$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            java.lang.String r4 = (java.lang.String) r4
            kotlin.b.b(r6)
            goto L48
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r6)
            com.uxsense.ApexSDK r6 = com.uxsense.ApexSDK.INSTANCE
            r6.checkInit()
            com.uxsense.ruleTrigger.TriggerRuleUpdater r6 = com.uxsense.ruleTrigger.TriggerRuleUpdater.INSTANCE
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.applyRemoteRules(r4, r5, r0)
            if (r6 != r1) goto L48
            return r1
        L48:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r5 = r6.booleanValue()
            if (r5 == 0) goto L55
            com.uxsense.ApexSDK r6 = com.uxsense.ApexSDK.INSTANCE
            r6.pushRules(r4)
        L55:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ApexSDK.applyRemoteTriggerRules(java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object applyRemoteWatchProcesses(java.lang.String r4, H7.c<? super java.lang.Boolean> r5) {
        /*
            boolean r0 = r5 instanceof com.uxsense.ApexSDK.C12121
            if (r0 == 0) goto L13
            r0 = r5
            com.uxsense.ApexSDK$applyRemoteWatchProcesses$1 r0 = (com.uxsense.ApexSDK.C12121) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.ApexSDK$applyRemoteWatchProcesses$1 r0 = new com.uxsense.ApexSDK$applyRemoteWatchProcesses$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.b.b(r5)
            goto L42
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r5)
            com.uxsense.ApexSDK r5 = com.uxsense.ApexSDK.INSTANCE
            r5.checkInit()
            com.uxsense.ruleTrigger.WatchProcessConfig r5 = com.uxsense.ruleTrigger.WatchProcessConfig.INSTANCE
            r0.label = r3
            java.lang.Object r5 = r5.applyRemoteConfig(r4, r0)
            if (r5 != r1) goto L42
            return r1
        L42:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r4 = r5.booleanValue()
            if (r4 == 0) goto L51
            com.uxsense.ruleTrigger.ApexTriggerManager r5 = com.uxsense.ruleTrigger.ApexTriggerManager.getInstance()
            r5.onWatchProcessesUpdated()
        L51:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ApexSDK.applyRemoteWatchProcesses(java.lang.String, H7.c):java.lang.Object");
    }

    private final void checkInit() {
        if (!isInitialized) {
            throw new IllegalStateException("ApexSDK not initialized. Call ApexSDK.initialize(context) first.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object createTriggerRule(java.lang.String r4, S7.k r5, H7.c<? super com.uxsense.ruleTrigger.TriggerRule> r6) {
        /*
            boolean r0 = r6 instanceof com.uxsense.ApexSDK.C12131
            if (r0 == 0) goto L13
            r0 = r6
            com.uxsense.ApexSDK$createTriggerRule$1 r0 = (com.uxsense.ApexSDK.C12131) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.ApexSDK$createTriggerRule$1 r0 = new com.uxsense.ApexSDK$createTriggerRule$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            java.lang.String r4 = (java.lang.String) r4
            kotlin.b.b(r6)
            goto L48
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r6)
            com.uxsense.ApexSDK r6 = com.uxsense.ApexSDK.INSTANCE
            r6.checkInit()
            com.uxsense.rule.ApexTriggerRuleEditor r6 = com.uxsense.rule.ApexTriggerRuleEditor.INSTANCE
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.create(r4, r5, r0)
            if (r6 != r1) goto L48
            return r1
        L48:
            com.uxsense.ruleTrigger.TriggerRule r6 = (com.uxsense.ruleTrigger.TriggerRule) r6
            com.uxsense.ApexSDK r5 = com.uxsense.ApexSDK.INSTANCE
            r5.pushRules(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ApexSDK.createTriggerRule(java.lang.String, S7.k, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object createTriggerRulesFromJson(java.lang.String r4, java.lang.String r5, H7.c<? super java.util.List<? extends com.uxsense.ruleTrigger.TriggerRule>> r6) {
        /*
            boolean r0 = r6 instanceof com.uxsense.ApexSDK.C12151
            if (r0 == 0) goto L13
            r0 = r6
            com.uxsense.ApexSDK$createTriggerRulesFromJson$1 r0 = (com.uxsense.ApexSDK.C12151) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.ApexSDK$createTriggerRulesFromJson$1 r0 = new com.uxsense.ApexSDK$createTriggerRulesFromJson$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            java.lang.String r4 = (java.lang.String) r4
            kotlin.b.b(r6)
            goto L48
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r6)
            com.uxsense.ApexSDK r6 = com.uxsense.ApexSDK.INSTANCE
            r6.checkInit()
            com.uxsense.rule.ApexTriggerRuleEditor r6 = com.uxsense.rule.ApexTriggerRuleEditor.INSTANCE
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.createFromJson(r4, r5, r0)
            if (r6 != r1) goto L48
            return r1
        L48:
            java.util.List r6 = (java.util.List) r6
            com.uxsense.ApexSDK r5 = com.uxsense.ApexSDK.INSTANCE
            r5.pushRules(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ApexSDK.createTriggerRulesFromJson(java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object deleteAllTriggerRules(java.lang.String r4, H7.c<? super C7.r> r5) {
        /*
            boolean r0 = r5 instanceof com.uxsense.ApexSDK.C12161
            if (r0 == 0) goto L13
            r0 = r5
            com.uxsense.ApexSDK$deleteAllTriggerRules$1 r0 = (com.uxsense.ApexSDK.C12161) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.ApexSDK$deleteAllTriggerRules$1 r0 = new com.uxsense.ApexSDK$deleteAllTriggerRules$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            java.lang.String r4 = (java.lang.String) r4
            kotlin.b.b(r5)
            goto L48
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r5)
            com.uxsense.ApexSDK r5 = com.uxsense.ApexSDK.INSTANCE
            r5.checkInit()
            com.uxsense.rule.ApexTriggerRuleEditor r5 = com.uxsense.rule.ApexTriggerRuleEditor.INSTANCE
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.deleteAll(r4, r0)
            if (r5 != r1) goto L48
            return r1
        L48:
            com.uxsense.ApexSDK r5 = com.uxsense.ApexSDK.INSTANCE
            r5.pushRules(r4)
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ApexSDK.deleteAllTriggerRules(java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object deleteTriggerRule(java.lang.String r4, java.lang.String r5, H7.c<? super java.lang.Boolean> r6) {
        /*
            boolean r0 = r6 instanceof com.uxsense.ApexSDK.C12171
            if (r0 == 0) goto L13
            r0 = r6
            com.uxsense.ApexSDK$deleteTriggerRule$1 r0 = (com.uxsense.ApexSDK.C12171) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.ApexSDK$deleteTriggerRule$1 r0 = new com.uxsense.ApexSDK$deleteTriggerRule$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            java.lang.String r4 = (java.lang.String) r4
            kotlin.b.b(r6)
            goto L48
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r6)
            com.uxsense.ApexSDK r6 = com.uxsense.ApexSDK.INSTANCE
            r6.checkInit()
            com.uxsense.rule.ApexTriggerRuleEditor r6 = com.uxsense.rule.ApexTriggerRuleEditor.INSTANCE
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.delete(r4, r5, r0)
            if (r6 != r1) goto L48
            return r1
        L48:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r5 = r6.booleanValue()
            if (r5 == 0) goto L55
            com.uxsense.ApexSDK r6 = com.uxsense.ApexSDK.INSTANCE
            r6.pushRules(r4)
        L55:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ApexSDK.deleteTriggerRule(java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    private final void ensureDispatchListenerInstalled() {
        ApexTriggerManager.setOnTriggerEventListener(dispatchListener);
    }

    public static final String getVersion() {
        return VERSION;
    }

    public static final Set<String> getWatchProcesses() {
        INSTANCE.checkInit();
        return WatchProcessConfig.INSTANCE.getWatchProcesses();
    }

    public static final void initialize(Context context) {
        k.f(context, "context");
        initialize$default(context, null, 2, null);
    }

    public static /* synthetic */ void initialize$default(Context context, ApexConfig apexConfig, int i, Object obj) {
        if ((i & 2) != 0) {
            apexConfig = ApexConfig.DEFAULT;
        }
        initialize(context, apexConfig);
    }

    public static final boolean isInitialized() {
        return isInitialized;
    }

    public static final List<TriggerRule> listTriggerRules(String packageName) {
        k.f(packageName, "packageName");
        INSTANCE.checkInit();
        return ApexTriggerRuleEditor.INSTANCE.list(packageName);
    }

    private final void pushRules(String packageName) {
        ApexTriggerManager.getInstance().pushRulesToApp(packageName);
    }

    public static final void release() {
        if (isInitialized) {
            ApexTriggerManager.getInstance().release();
            config = ApexConfig.DEFAULT;
            isInitialized = false;
            ALog.i$default(TAG, "ApexSDK released", null, 4, null);
        }
    }

    public static final void removeOnTriggerEventListener(String packageName, ApexTriggerManager.OnTriggerEventListener listener) {
        k.f(packageName, "packageName");
        k.f(listener, "listener");
        ConcurrentHashMap<String, List<ApexTriggerManager.OnTriggerEventListener>> concurrentHashMap = packageListeners;
        List<ApexTriggerManager.OnTriggerEventListener> list = concurrentHashMap.get(packageName);
        if (list != null) {
            list.remove(listener);
        }
        List<ApexTriggerManager.OnTriggerEventListener> list2 = concurrentHashMap.get(packageName);
        if (list2 == null || !list2.isEmpty()) {
            return;
        }
        concurrentHashMap.remove(packageName);
    }

    public static final void removeOnTriggerEventListeners(String packageName) {
        k.f(packageName, "packageName");
        ConcurrentHashMap<String, List<ApexTriggerManager.OnTriggerEventListener>> concurrentHashMap = packageListeners;
        concurrentHashMap.remove(packageName);
        if (concurrentHashMap.isEmpty()) {
            ApexTriggerManager.setOnTriggerEventListener(null);
        }
    }

    public static final void setOnTriggerEventListener(ApexTriggerManager.OnTriggerEventListener listener) {
        ApexTriggerManager.setOnTriggerEventListener(listener);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object updateTriggerRule(com.uxsense.ruleTrigger.TriggerRule r4, H7.c<? super C7.r> r5) {
        /*
            boolean r0 = r5 instanceof com.uxsense.ApexSDK.C12191
            if (r0 == 0) goto L13
            r0 = r5
            com.uxsense.ApexSDK$updateTriggerRule$1 r0 = (com.uxsense.ApexSDK.C12191) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.ApexSDK$updateTriggerRule$1 r0 = new com.uxsense.ApexSDK$updateTriggerRule$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            com.uxsense.ruleTrigger.TriggerRule r4 = (com.uxsense.ruleTrigger.TriggerRule) r4
            kotlin.b.b(r5)
            goto L48
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r5)
            com.uxsense.ApexSDK r5 = com.uxsense.ApexSDK.INSTANCE
            r5.checkInit()
            com.uxsense.rule.ApexTriggerRuleEditor r5 = com.uxsense.rule.ApexTriggerRuleEditor.INSTANCE
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.update(r4, r0)
            if (r5 != r1) goto L48
            return r1
        L48:
            com.uxsense.ApexSDK r5 = com.uxsense.ApexSDK.INSTANCE
            java.lang.String r4 = r4.getPackageName()
            java.lang.String r0 = "getPackageName(...)"
            kotlin.jvm.internal.k.e(r4, r0)
            r5.pushRules(r4)
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ApexSDK.updateTriggerRule(com.uxsense.ruleTrigger.TriggerRule, H7.c):java.lang.Object");
    }

    public static final void initialize(Context context, ApexConfig config2) {
        k.f(context, "context");
        k.f(config2, "config");
        if (isInitialized) {
            return;
        }
        config = config2;
        ApexMetadataFileManager.INSTANCE.init(context);
        if (config2.getLogger() != null) {
            ApexCore.INSTANCE.initLogger(config2.getLogger());
        } else if (config2.getUseAndroidLog()) {
            ApexCore.INSTANCE.useAndroidLogger();
        }
        ApexTriggerManager.getInstance().init(context);
        isInitialized = true;
        ALog.i$default(TAG, "ApexSDK initialized, version=1.0.0", null, 4, null);
    }

    public final void setOnTriggerEventListener(final n block) {
        k.f(block, "block");
        setOnTriggerEventListener(new ApexTriggerManager.OnTriggerEventListener() { // from class: com.uxsense.ApexSDK.setOnTriggerEventListener.1
            @Override // com.uxsense.ruleTrigger.ApexTriggerManager.OnTriggerEventListener
            public void onTriggerEvent(int resultCode, Intent resultIntent) {
                block.invoke(Integer.valueOf(resultCode), resultIntent);
            }
        });
    }

    public final void addOnTriggerEventListener(String packageName, final n block) {
        k.f(packageName, "packageName");
        k.f(block, "block");
        addOnTriggerEventListener(packageName, new ApexTriggerManager.OnTriggerEventListener() { // from class: com.uxsense.ApexSDK.addOnTriggerEventListener.2
            @Override // com.uxsense.ruleTrigger.ApexTriggerManager.OnTriggerEventListener
            public void onTriggerEvent(int resultCode, Intent resultIntent) {
                block.invoke(Integer.valueOf(resultCode), resultIntent);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object createTriggerRule(com.uxsense.ruleTrigger.TriggerRule r4, H7.c<? super C7.r> r5) {
        /*
            boolean r0 = r5 instanceof com.uxsense.ApexSDK.C12142
            if (r0 == 0) goto L13
            r0 = r5
            com.uxsense.ApexSDK$createTriggerRule$2 r0 = (com.uxsense.ApexSDK.C12142) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.ApexSDK$createTriggerRule$2 r0 = new com.uxsense.ApexSDK$createTriggerRule$2
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            com.uxsense.ruleTrigger.TriggerRule r4 = (com.uxsense.ruleTrigger.TriggerRule) r4
            kotlin.b.b(r5)
            goto L48
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r5)
            com.uxsense.ApexSDK r5 = com.uxsense.ApexSDK.INSTANCE
            r5.checkInit()
            com.uxsense.rule.ApexTriggerRuleEditor r5 = com.uxsense.rule.ApexTriggerRuleEditor.INSTANCE
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.create(r4, r0)
            if (r5 != r1) goto L48
            return r1
        L48:
            com.uxsense.ApexSDK r5 = com.uxsense.ApexSDK.INSTANCE
            java.lang.String r4 = r4.getPackageName()
            java.lang.String r0 = "getPackageName(...)"
            kotlin.jvm.internal.k.e(r4, r0)
            r5.pushRules(r4)
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ApexSDK.createTriggerRule(com.uxsense.ruleTrigger.TriggerRule, H7.c):java.lang.Object");
    }
}
