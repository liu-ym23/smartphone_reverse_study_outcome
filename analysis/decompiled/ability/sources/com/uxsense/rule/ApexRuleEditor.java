package com.uxsense.rule;

import C7.r;
import C9.AbstractC0200b;
import C9.g;
import J7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.task.executor.e;
import com.uxsense.base.parse.ParseRule;
import com.uxsense.core.ApexMetadataFileManager;
import com.uxsense.core.ApexRuleManager;
import com.uxsense.parse.MetadataType;
import com.uxsense.parse.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\b\u0010\tJB\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJ4\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u0014\u0010\u0017J \u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u001c\u0010\u001aJ\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u001d\u0010\u0017J&\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@¢\u0006\u0004\b\u001f\u0010 J0\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b$\u0010\tJ\u0018\u0010%\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b%\u0010\tJ\u0015\u0010'\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/uxsense/rule/ApexRuleEditor;", "", AppAgent.CONSTRUCT, "()V", "", "packageName", "", "Lcom/uxsense/base/parse/ParseRule;", "list", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "activityClass", "windowTitle", "Lcom/uxsense/parse/MetadataType;", "type", "find", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/uxsense/parse/MetadataType;LH7/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lcom/uxsense/rule/ParseRuleBuilder;", "LC7/r;", "block", "create", "(Ljava/lang/String;Ljava/lang/String;LS7/k;LH7/c;)Ljava/lang/Object;", "rule", "(Lcom/uxsense/base/parse/ParseRule;LH7/c;)Ljava/lang/Object;", "jsonStr", "createFromJson", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "jsonArray", "createFromJsonArray", "update", "rules", "replaceAll", "(Ljava/lang/String;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "", "delete", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "deleteAll", "exportToJson", "", "hasRules", "(Ljava/lang/String;)Z", "LC9/b;", "json", "LC9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApexRuleEditor {
    public static final ApexRuleEditor INSTANCE = new ApexRuleEditor();
    private static final AbstractC0200b json = e.b(new b(1));

    @c(c = "com.uxsense.rule.ApexRuleEditor", f = "ApexRuleEditor.kt", l = {90, 91}, m = "create")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.rule.ApexRuleEditor$create$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexRuleEditor.this.create(null, null, null, this);
        }
    }

    @c(c = "com.uxsense.rule.ApexRuleEditor", f = "ApexRuleEditor.kt", l = {99, 100}, m = "create")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.rule.ApexRuleEditor$create$2, reason: invalid class name */
    public static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(H7.c<? super AnonymousClass2> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexRuleEditor.this.create(null, this);
        }
    }

    @c(c = "com.uxsense.rule.ApexRuleEditor", f = "ApexRuleEditor.kt", l = {115, 116}, m = "createFromJson")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.rule.ApexRuleEditor$createFromJson$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12931 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C12931(H7.c<? super C12931> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexRuleEditor.this.createFromJson(null, null, this);
        }
    }

    @c(c = "com.uxsense.rule.ApexRuleEditor", f = "ApexRuleEditor.kt", l = {129, 130}, m = "createFromJsonArray")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.rule.ApexRuleEditor$createFromJsonArray$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12941 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C12941(H7.c<? super C12941> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexRuleEditor.this.createFromJsonArray(null, null, this);
        }
    }

    @c(c = "com.uxsense.rule.ApexRuleEditor", f = "ApexRuleEditor.kt", l = {167, 168}, m = "delete")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.rule.ApexRuleEditor$delete$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12951 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12951(H7.c<? super C12951> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexRuleEditor.this.delete(null, null, null, this);
        }
    }

    @c(c = "com.uxsense.rule.ApexRuleEditor", f = "ApexRuleEditor.kt", l = {179, 180}, m = "deleteAll")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.rule.ApexRuleEditor$deleteAll$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12961 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12961(H7.c<? super C12961> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexRuleEditor.this.deleteAll(null, this);
        }
    }

    @c(c = "com.uxsense.rule.ApexRuleEditor", f = "ApexRuleEditor.kt", l = {189}, m = "exportToJson")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.rule.ApexRuleEditor$exportToJson$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12971 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C12971(H7.c<? super C12971> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexRuleEditor.this.exportToJson(null, this);
        }
    }

    @c(c = "com.uxsense.rule.ApexRuleEditor", f = "ApexRuleEditor.kt", l = {151, 152}, m = "replaceAll")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.rule.ApexRuleEditor$replaceAll$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12981 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12981(H7.c<? super C12981> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexRuleEditor.this.replaceAll(null, null, this);
        }
    }

    @c(c = "com.uxsense.rule.ApexRuleEditor", f = "ApexRuleEditor.kt", l = {140, 141}, m = "update")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.rule.ApexRuleEditor$update$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12991 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12991(H7.c<? super C12991> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexRuleEditor.this.update(null, this);
        }
    }

    private ApexRuleEditor() {
    }

    public static /* synthetic */ Object delete$default(ApexRuleEditor apexRuleEditor, String str, String str2, String str3, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return apexRuleEditor.delete(str, str2, str3, cVar);
    }

    public static /* synthetic */ Object find$default(ApexRuleEditor apexRuleEditor, String str, String str2, String str3, MetadataType metadataType, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            metadataType = null;
        }
        return apexRuleEditor.find(str, str2, str3, metadataType, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r json$lambda$0(g Json) {
        k.f(Json, "$this$Json");
        Json.c = true;
        Json.e = true;
        return r.f317a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object create(java.lang.String r5, java.lang.String r6, S7.k r7, H7.c<? super com.uxsense.base.parse.ParseRule> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.uxsense.rule.ApexRuleEditor.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.uxsense.rule.ApexRuleEditor$create$1 r0 = (com.uxsense.rule.ApexRuleEditor.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.rule.ApexRuleEditor$create$1 r0 = new com.uxsense.rule.ApexRuleEditor$create$1
            r0.<init>(r8)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L44
            if (r1 == r3) goto L36
            if (r1 != r2) goto L2e
            java.lang.Object r5 = r0.L$0
            com.uxsense.base.parse.ParseRule r5 = (com.uxsense.base.parse.ParseRule) r5
            kotlin.b.b(r4)
            return r5
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            java.lang.Object r5 = r0.L$1
            com.uxsense.base.parse.ParseRule r5 = (com.uxsense.base.parse.ParseRule) r5
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.b.b(r4)
            r4 = r5
            r5 = r6
            goto L62
        L44:
            kotlin.b.b(r4)
            com.uxsense.rule.ParseRuleBuilder r4 = new com.uxsense.rule.ParseRuleBuilder
            r4.<init>(r5, r6)
            r7.invoke(r4)
            com.uxsense.base.parse.ParseRule r4 = r4.build()
            com.uxsense.core.ApexMetadataFileManager r6 = com.uxsense.core.ApexMetadataFileManager.INSTANCE
            r0.L$0 = r5
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r6 = com.uxsense.core.ParseRuleExtensionsKt.saveRule(r6, r4, r0)
            if (r6 != r8) goto L62
            goto L71
        L62:
            com.uxsense.core.ApexRuleManager r6 = com.uxsense.core.ApexRuleManager.INSTANCE
            r0.L$0 = r4
            r7 = 0
            r0.L$1 = r7
            r0.label = r2
            java.lang.Object r5 = r6.refreshRules(r5, r0)
            if (r5 != r8) goto L72
        L71:
            return r8
        L72:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.rule.ApexRuleEditor.create(java.lang.String, java.lang.String, S7.k, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createFromJson(java.lang.String r5, java.lang.String r6, H7.c<? super com.uxsense.base.parse.ParseRule> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.uxsense.rule.ApexRuleEditor.C12931
            if (r0 == 0) goto L13
            r0 = r7
            com.uxsense.rule.ApexRuleEditor$createFromJson$1 r0 = (com.uxsense.rule.ApexRuleEditor.C12931) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.rule.ApexRuleEditor$createFromJson$1 r0 = new com.uxsense.rule.ApexRuleEditor$createFromJson$1
            r0.<init>(r7)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L44
            if (r1 == r3) goto L36
            if (r1 != r2) goto L2e
            java.lang.Object r5 = r0.L$0
            com.uxsense.base.parse.ParseRule r5 = (com.uxsense.base.parse.ParseRule) r5
            kotlin.b.b(r4)
            return r5
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            java.lang.Object r5 = r0.L$1
            com.uxsense.base.parse.ParseRule r5 = (com.uxsense.base.parse.ParseRule) r5
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.b.b(r4)
            r4 = r5
            r5 = r6
            goto L73
        L44:
            kotlin.b.b(r4)
            C9.b r4 = com.uxsense.rule.ApexRuleEditor.json
            r4.getClass()
            com.uxsense.base.parse.ParseRule$Companion r1 = com.uxsense.base.parse.ParseRule.INSTANCE
            x9.b r1 = r1.serializer()
            x9.a r1 = (x9.InterfaceC2123a) r1
            java.lang.Object r4 = r4.a(r1, r6)
            com.uxsense.base.parse.ParseRule r4 = (com.uxsense.base.parse.ParseRule) r4
            java.lang.String r6 = r4.getPackageName()
            boolean r6 = kotlin.jvm.internal.k.b(r6, r5)
            if (r6 == 0) goto L84
            com.uxsense.core.ApexMetadataFileManager r6 = com.uxsense.core.ApexMetadataFileManager.INSTANCE
            r0.L$0 = r5
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r6 = com.uxsense.core.ParseRuleExtensionsKt.saveRule(r6, r4, r0)
            if (r6 != r7) goto L73
            goto L82
        L73:
            com.uxsense.core.ApexRuleManager r6 = com.uxsense.core.ApexRuleManager.INSTANCE
            r0.L$0 = r4
            r1 = 0
            r0.L$1 = r1
            r0.label = r2
            java.lang.Object r5 = r6.refreshRules(r5, r0)
            if (r5 != r7) goto L83
        L82:
            return r7
        L83:
            return r4
        L84:
            java.lang.String r6 = "Rule packageName mismatch: expected="
            java.lang.String r7 = ", actual="
            java.lang.StringBuilder r5 = B7.a.v(r6, r5, r7)
            java.lang.String r4 = r4.getPackageName()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.rule.ApexRuleEditor.createFromJson(java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createFromJsonArray(java.lang.String r6, java.lang.String r7, H7.c<? super java.util.List<com.uxsense.base.parse.ParseRule>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.uxsense.rule.ApexRuleEditor.C12941
            if (r0 == 0) goto L13
            r0 = r8
            com.uxsense.rule.ApexRuleEditor$createFromJsonArray$1 r0 = (com.uxsense.rule.ApexRuleEditor.C12941) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.rule.ApexRuleEditor$createFromJsonArray$1 r0 = new com.uxsense.rule.ApexRuleEditor$createFromJsonArray$1
            r0.<init>(r8)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L44
            if (r1 == r3) goto L36
            if (r1 != r2) goto L2e
            java.lang.Object r6 = r0.L$0
            java.util.List r6 = (java.util.List) r6
            kotlin.b.b(r5)
            return r6
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            java.lang.Object r6 = r0.L$1
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.b.b(r5)
            r5 = r6
            r6 = r7
            goto L6c
        L44:
            kotlin.b.b(r5)
            C9.b r5 = com.uxsense.rule.ApexRuleEditor.json
            r5.getClass()
            B9.d r1 = new B9.d
            com.uxsense.base.parse.ParseRule$Companion r4 = com.uxsense.base.parse.ParseRule.INSTANCE
            x9.b r4 = r4.serializer()
            r1.<init>(r4)
            java.lang.Object r5 = r5.a(r1, r7)
            java.util.List r5 = (java.util.List) r5
            com.uxsense.core.ApexMetadataFileManager r7 = com.uxsense.core.ApexMetadataFileManager.INSTANCE
            r0.L$0 = r6
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r7 = com.uxsense.core.ParseRuleExtensionsKt.saveRules(r7, r6, r5, r0)
            if (r7 != r8) goto L6c
            goto L7b
        L6c:
            com.uxsense.core.ApexRuleManager r7 = com.uxsense.core.ApexRuleManager.INSTANCE
            r0.L$0 = r5
            r1 = 0
            r0.L$1 = r1
            r0.label = r2
            java.lang.Object r6 = r7.refreshRules(r6, r0)
            if (r6 != r8) goto L7c
        L7b:
            return r8
        L7c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.rule.ApexRuleEditor.createFromJsonArray(java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object delete(java.lang.String r11, java.lang.String r12, java.lang.String r13, H7.c<? super java.lang.Integer> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.uxsense.rule.ApexRuleEditor.C12951
            if (r0 == 0) goto L14
            r0 = r14
            com.uxsense.rule.ApexRuleEditor$delete$1 r0 = (com.uxsense.rule.ApexRuleEditor.C12951) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.uxsense.rule.ApexRuleEditor$delete$1 r0 = new com.uxsense.rule.ApexRuleEditor$delete$1
            r0.<init>(r14)
            goto L12
        L1a:
            java.lang.Object r10 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r14 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r0 = r6.label
            r9 = 2
            r1 = 1
            if (r0 == 0) goto L40
            if (r0 == r1) goto L38
            if (r0 != r9) goto L30
            java.lang.Object r11 = r6.L$0
            com.uxsense.file.FileResult r11 = (com.uxsense.file.FileResult) r11
            kotlin.b.b(r10)
            goto L69
        L30:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L38:
            java.lang.Object r11 = r6.L$0
            java.lang.String r11 = (java.lang.String) r11
            kotlin.b.b(r10)
            goto L59
        L40:
            kotlin.b.b(r10)
            r10 = r1
            com.uxsense.core.ApexMetadataFileManager r1 = com.uxsense.core.ApexMetadataFileManager.INSTANCE
            r6.L$0 = r11
            r6.label = r10
            r5 = 0
            r7 = 8
            r8 = 0
            r2 = r11
            r3 = r12
            r4 = r13
            java.lang.Object r10 = com.uxsense.core.ParseRuleExtensionsKt.deleteRule$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r10 != r14) goto L58
            goto L67
        L58:
            r11 = r2
        L59:
            com.uxsense.file.FileResult r10 = (com.uxsense.file.FileResult) r10
            com.uxsense.core.ApexRuleManager r12 = com.uxsense.core.ApexRuleManager.INSTANCE
            r6.L$0 = r10
            r6.label = r9
            java.lang.Object r11 = r12.refreshRules(r11, r6)
            if (r11 != r14) goto L68
        L67:
            return r14
        L68:
            r11 = r10
        L69:
            boolean r10 = r11 instanceof com.uxsense.file.FileResult.Success
            if (r10 == 0) goto L7a
            com.uxsense.file.FileResult$Success r11 = (com.uxsense.file.FileResult.Success) r11
            java.lang.Object r10 = r11.getData()
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            goto L7f
        L7a:
            boolean r10 = r11 instanceof com.uxsense.file.FileResult.Error
            if (r10 == 0) goto L85
            r10 = 0
        L7f:
            java.lang.Integer r11 = new java.lang.Integer
            r11.<init>(r10)
            return r11
        L85:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.rule.ApexRuleEditor.delete(java.lang.String, java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
    
        if (r4.refreshRules(r5, r0) == r6) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object deleteAll(java.lang.String r5, H7.c<? super C7.r> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.uxsense.rule.ApexRuleEditor.C12961
            if (r0 == 0) goto L13
            r0 = r6
            com.uxsense.rule.ApexRuleEditor$deleteAll$1 r0 = (com.uxsense.rule.ApexRuleEditor.C12961) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.rule.ApexRuleEditor$deleteAll$1 r0 = new com.uxsense.rule.ApexRuleEditor$deleteAll$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3a
            if (r1 == r3) goto L32
            if (r1 != r2) goto L2a
            kotlin.b.b(r4)
            goto L58
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.b.b(r4)
            goto L4a
        L3a:
            kotlin.b.b(r4)
            com.uxsense.core.ApexMetadataFileManager r4 = com.uxsense.core.ApexMetadataFileManager.INSTANCE
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = com.uxsense.core.ParseRuleExtensionsKt.deleteAllRules(r4, r5, r0)
            if (r4 != r6) goto L4a
            goto L57
        L4a:
            com.uxsense.core.ApexRuleManager r4 = com.uxsense.core.ApexRuleManager.INSTANCE
            r1 = 0
            r0.L$0 = r1
            r0.label = r2
            java.lang.Object r4 = r4.refreshRules(r5, r0)
            if (r4 != r6) goto L58
        L57:
            return r6
        L58:
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.rule.ApexRuleEditor.deleteAll(java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object exportToJson(java.lang.String r5, H7.c<? super java.lang.String> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.uxsense.rule.ApexRuleEditor.C12971
            if (r0 == 0) goto L13
            r0 = r6
            com.uxsense.rule.ApexRuleEditor$exportToJson$1 r0 = (com.uxsense.rule.ApexRuleEditor.C12971) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.rule.ApexRuleEditor$exportToJson$1 r0 = new com.uxsense.rule.ApexRuleEditor$exportToJson$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            kotlin.b.b(r4)
            goto L3d
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r4)
            com.uxsense.core.ApexRuleManager r4 = com.uxsense.core.ApexRuleManager.INSTANCE
            r0.label = r2
            java.lang.Object r4 = r4.getRules(r5, r0)
            if (r4 != r6) goto L3d
            return r6
        L3d:
            java.util.List r4 = (java.util.List) r4
            C9.b r5 = com.uxsense.rule.ApexRuleEditor.json
            r5.getClass()
            B9.d r6 = new B9.d
            com.uxsense.base.parse.ParseRule$Companion r0 = com.uxsense.base.parse.ParseRule.INSTANCE
            x9.b r0 = r0.serializer()
            r6.<init>(r0)
            java.lang.String r4 = r5.b(r6, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.rule.ApexRuleEditor.exportToJson(java.lang.String, H7.c):java.lang.Object");
    }

    public final Object find(String str, String str2, String str3, MetadataType metadataType, H7.c<? super List<ParseRule>> cVar) {
        return ApexRuleManager.INSTANCE.findRules(str, str2, str3, metadataType, cVar);
    }

    public final boolean hasRules(String packageName) {
        k.f(packageName, "packageName");
        return ApexMetadataFileManager.INSTANCE.getRuleFile(packageName).toFile().exists();
    }

    public final Object list(String str, H7.c<? super List<ParseRule>> cVar) {
        return ApexRuleManager.INSTANCE.getRules(str, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
    
        if (r4.refreshRules(r5, r0) == r7) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object replaceAll(java.lang.String r5, java.util.List<com.uxsense.base.parse.ParseRule> r6, H7.c<? super C7.r> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.uxsense.rule.ApexRuleEditor.C12981
            if (r0 == 0) goto L13
            r0 = r7
            com.uxsense.rule.ApexRuleEditor$replaceAll$1 r0 = (com.uxsense.rule.ApexRuleEditor.C12981) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.rule.ApexRuleEditor$replaceAll$1 r0 = new com.uxsense.rule.ApexRuleEditor$replaceAll$1
            r0.<init>(r7)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3a
            if (r1 == r3) goto L32
            if (r1 != r2) goto L2a
            kotlin.b.b(r4)
            goto L58
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.b.b(r4)
            goto L4a
        L3a:
            kotlin.b.b(r4)
            com.uxsense.core.ApexMetadataFileManager r4 = com.uxsense.core.ApexMetadataFileManager.INSTANCE
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = com.uxsense.core.ParseRuleExtensionsKt.saveRules(r4, r5, r6, r0)
            if (r4 != r7) goto L4a
            goto L57
        L4a:
            com.uxsense.core.ApexRuleManager r4 = com.uxsense.core.ApexRuleManager.INSTANCE
            r6 = 0
            r0.L$0 = r6
            r0.label = r2
            java.lang.Object r4 = r4.refreshRules(r5, r0)
            if (r4 != r7) goto L58
        L57:
            return r7
        L58:
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.rule.ApexRuleEditor.replaceAll(java.lang.String, java.util.List, H7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r4.refreshRules(r5, r0) == r6) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object update(com.uxsense.base.parse.ParseRule r5, H7.c<? super C7.r> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.uxsense.rule.ApexRuleEditor.C12991
            if (r0 == 0) goto L13
            r0 = r6
            com.uxsense.rule.ApexRuleEditor$update$1 r0 = (com.uxsense.rule.ApexRuleEditor.C12991) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.rule.ApexRuleEditor$update$1 r0 = new com.uxsense.rule.ApexRuleEditor$update$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3a
            if (r1 == r3) goto L32
            if (r1 != r2) goto L2a
            kotlin.b.b(r4)
            goto L5c
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            java.lang.Object r5 = r0.L$0
            com.uxsense.base.parse.ParseRule r5 = (com.uxsense.base.parse.ParseRule) r5
            kotlin.b.b(r4)
            goto L4a
        L3a:
            kotlin.b.b(r4)
            com.uxsense.core.ApexMetadataFileManager r4 = com.uxsense.core.ApexMetadataFileManager.INSTANCE
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = com.uxsense.core.ParseRuleExtensionsKt.saveRule(r4, r5, r0)
            if (r4 != r6) goto L4a
            goto L5b
        L4a:
            com.uxsense.core.ApexRuleManager r4 = com.uxsense.core.ApexRuleManager.INSTANCE
            java.lang.String r5 = r5.getPackageName()
            r1 = 0
            r0.L$0 = r1
            r0.label = r2
            java.lang.Object r4 = r4.refreshRules(r5, r0)
            if (r4 != r6) goto L5c
        L5b:
            return r6
        L5c:
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.rule.ApexRuleEditor.update(com.uxsense.base.parse.ParseRule, H7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r4.refreshRules(r5, r0) == r6) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object create(com.uxsense.base.parse.ParseRule r5, H7.c<? super C7.r> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.uxsense.rule.ApexRuleEditor.AnonymousClass2
            if (r0 == 0) goto L13
            r0 = r6
            com.uxsense.rule.ApexRuleEditor$create$2 r0 = (com.uxsense.rule.ApexRuleEditor.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.rule.ApexRuleEditor$create$2 r0 = new com.uxsense.rule.ApexRuleEditor$create$2
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3a
            if (r1 == r3) goto L32
            if (r1 != r2) goto L2a
            kotlin.b.b(r4)
            goto L5c
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            java.lang.Object r5 = r0.L$0
            com.uxsense.base.parse.ParseRule r5 = (com.uxsense.base.parse.ParseRule) r5
            kotlin.b.b(r4)
            goto L4a
        L3a:
            kotlin.b.b(r4)
            com.uxsense.core.ApexMetadataFileManager r4 = com.uxsense.core.ApexMetadataFileManager.INSTANCE
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = com.uxsense.core.ParseRuleExtensionsKt.saveRule(r4, r5, r0)
            if (r4 != r6) goto L4a
            goto L5b
        L4a:
            com.uxsense.core.ApexRuleManager r4 = com.uxsense.core.ApexRuleManager.INSTANCE
            java.lang.String r5 = r5.getPackageName()
            r1 = 0
            r0.L$0 = r1
            r0.label = r2
            java.lang.Object r4 = r4.refreshRules(r5, r0)
            if (r4 != r6) goto L5c
        L5b:
            return r6
        L5c:
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.rule.ApexRuleEditor.create(com.uxsense.base.parse.ParseRule, H7.c):java.lang.Object");
    }
}
