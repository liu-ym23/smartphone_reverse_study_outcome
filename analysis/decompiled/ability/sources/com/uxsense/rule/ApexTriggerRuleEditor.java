package com.uxsense.rule;

import C7.r;
import D7.v;
import J7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.ExecutionBundle;
import com.uxsense.core.ApexMetadataFileManager;
import com.uxsense.core.base.parse.KViewNode;
import com.uxsense.ruleTrigger.RuleMatchResult;
import com.uxsense.ruleTrigger.TriggerRule;
import com.uxsense.ruleTrigger.TriggerRuleParse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J,\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0\u0011H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u0014\u0010\u0016J&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u001a\u0010\u0016J&\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0086@¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010 \u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b \u0010\u0019J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b!\u0010\"J+\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u000b2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/uxsense/rule/ApexTriggerRuleEditor;", "", AppAgent.CONSTRUCT, "()V", "", "packageName", "Lcom/uxsense/ruleTrigger/TriggerRule;", "rule", "LC7/r;", "addRule", "(Ljava/lang/String;Lcom/uxsense/ruleTrigger/TriggerRule;LH7/c;)Ljava/lang/Object;", "", "list", "(Ljava/lang/String;)Ljava/util/List;", "activityClass", "find", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "Lkotlin/Function1;", "Lcom/uxsense/ruleTrigger/TriggerRule$Builder;", "block", "create", "(Ljava/lang/String;LS7/k;LH7/c;)Ljava/lang/Object;", "(Lcom/uxsense/ruleTrigger/TriggerRule;LH7/c;)Ljava/lang/Object;", "json", "createFromJson", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "update", "rules", "replaceAll", "(Ljava/lang/String;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "ruleName", "", "delete", "deleteAll", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lcom/uxsense/core/base/parse/KViewNode;", "rootNode", "Lcom/uxsense/ruleTrigger/RuleMatchResult;", "matchRules", "(Lcom/uxsense/core/base/parse/KViewNode;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "exportToJson", "(Ljava/lang/String;)Ljava/lang/String;", "hasRules", "(Ljava/lang/String;)Z", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApexTriggerRuleEditor {
    public static final ApexTriggerRuleEditor INSTANCE = new ApexTriggerRuleEditor();

    @c(c = "com.uxsense.rule.ApexTriggerRuleEditor", f = "ApexTriggerRuleEditor.kt", l = {64}, m = "create")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.rule.ApexTriggerRuleEditor$create$1, reason: invalid class name */
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
            return ApexTriggerRuleEditor.this.create(null, null, this);
        }
    }

    @c(c = "com.uxsense.rule.ApexTriggerRuleEditor", f = "ApexTriggerRuleEditor.kt", l = {87}, m = "createFromJson")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.rule.ApexTriggerRuleEditor$createFromJson$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13001 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C13001(H7.c<? super C13001> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexTriggerRuleEditor.this.createFromJson(null, null, this);
        }
    }

    @c(c = "com.uxsense.rule.ApexTriggerRuleEditor", f = "ApexTriggerRuleEditor.kt", l = {128}, m = "delete")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.rule.ApexTriggerRuleEditor$delete$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13011 extends ContinuationImpl {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C13011(H7.c<? super C13011> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexTriggerRuleEditor.this.delete(null, null, this);
        }
    }

    @c(c = "com.uxsense.rule.ApexTriggerRuleEditor", f = "ApexTriggerRuleEditor.kt", l = {137}, m = "deleteAll")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.rule.ApexTriggerRuleEditor$deleteAll$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13021 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C13021(H7.c<? super C13021> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexTriggerRuleEditor.this.deleteAll(null, this);
        }
    }

    private ApexTriggerRuleEditor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object addRule(String str, TriggerRule triggerRule, H7.c<? super r> cVar) {
        ArrayList arrayListG1 = v.g1(list(str));
        Iterator it = arrayListG1.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (k.b(((TriggerRule) it.next()).getName(), triggerRule.getName())) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            arrayListG1.set(i, triggerRule);
        } else {
            arrayListG1.add(triggerRule);
        }
        Object objSaveRules = TriggerRuleParse.saveRules(str, arrayListG1, cVar);
        return objSaveRules == CoroutineSingletons.f4909a ? objSaveRules : r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean delete$lambda$2(String str, TriggerRule it) {
        k.f(it, "it");
        return k.b(it.getName(), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object create(java.lang.String r5, S7.k r6, H7.c<? super com.uxsense.ruleTrigger.TriggerRule> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.uxsense.rule.ApexTriggerRuleEditor.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.uxsense.rule.ApexTriggerRuleEditor$create$1 r0 = (com.uxsense.rule.ApexTriggerRuleEditor.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.rule.ApexTriggerRuleEditor$create$1 r0 = new com.uxsense.rule.ApexTriggerRuleEditor$create$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            com.uxsense.ruleTrigger.TriggerRule r4 = (com.uxsense.ruleTrigger.TriggerRule) r4
            kotlin.b.b(r7)
            goto L62
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r7)
            com.uxsense.ruleTrigger.TriggerRule$Builder r7 = new com.uxsense.ruleTrigger.TriggerRule$Builder
            r7.<init>(r5)
            r6.invoke(r7)
            com.uxsense.ruleTrigger.TriggerRule r6 = r7.build()
            java.lang.String r7 = r6.getSource()
            java.lang.String r2 = "getSource(...)"
            kotlin.jvm.internal.k.e(r7, r2)
            int r7 = r7.length()
            if (r7 != 0) goto L56
            java.lang.String r7 = "local"
            r6.setSource(r7)
        L56:
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r4 = r4.addRule(r5, r6, r0)
            if (r4 != r1) goto L61
            return r1
        L61:
            r4 = r6
        L62:
            kotlin.jvm.internal.k.c(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.rule.ApexTriggerRuleEditor.create(java.lang.String, S7.k, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createFromJson(java.lang.String r5, java.lang.String r6, H7.c<? super java.util.List<? extends com.uxsense.ruleTrigger.TriggerRule>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.uxsense.rule.ApexTriggerRuleEditor.C13001
            if (r0 == 0) goto L13
            r0 = r7
            com.uxsense.rule.ApexTriggerRuleEditor$createFromJson$1 r0 = (com.uxsense.rule.ApexTriggerRuleEditor.C13001) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.rule.ApexTriggerRuleEditor$createFromJson$1 r0 = new com.uxsense.rule.ApexTriggerRuleEditor$createFromJson$1
            r0.<init>(r7)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            java.lang.Object r5 = r0.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.b.b(r4)
            return r5
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r4)
            com.uxsense.ruleTrigger.TriggerRuleParse r4 = com.uxsense.ruleTrigger.TriggerRuleParse.INSTANCE
            java.util.List r4 = r4.parseRulesFromJson$uxsense_release(r6)
            r0.L$0 = r4
            r0.label = r2
            java.lang.Object r5 = com.uxsense.ruleTrigger.TriggerRuleParse.saveRules(r5, r4, r0)
            if (r5 != r7) goto L47
            return r7
        L47:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.rule.ApexTriggerRuleEditor.createFromJson(java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object delete(java.lang.String r5, java.lang.String r6, H7.c<? super java.lang.Boolean> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.uxsense.rule.ApexTriggerRuleEditor.C13011
            if (r0 == 0) goto L13
            r0 = r7
            com.uxsense.rule.ApexTriggerRuleEditor$delete$1 r0 = (com.uxsense.rule.ApexTriggerRuleEditor.C13011) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.rule.ApexTriggerRuleEditor$delete$1 r0 = new com.uxsense.rule.ApexTriggerRuleEditor$delete$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            boolean r4 = r0.Z$0
            kotlin.b.b(r7)
            goto L57
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.b.b(r7)
            java.util.List r4 = r4.list(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.ArrayList r4 = D7.v.g1(r4)
            R3.c r7 = new R3.c
            r2 = 19
            r7.<init>(r6, r2)
            boolean r6 = D7.A.n0(r7, r4)
            if (r6 == 0) goto L58
            r0.Z$0 = r6
            r0.label = r3
            java.lang.Object r4 = com.uxsense.ruleTrigger.TriggerRuleParse.saveRules(r5, r4, r0)
            if (r4 != r1) goto L56
            return r1
        L56:
            r4 = r6
        L57:
            r6 = r4
        L58:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.rule.ApexTriggerRuleEditor.delete(java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object deleteAll(java.lang.String r5, H7.c<? super C7.r> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.uxsense.rule.ApexTriggerRuleEditor.C13021
            if (r0 == 0) goto L13
            r0 = r6
            com.uxsense.rule.ApexTriggerRuleEditor$deleteAll$1 r0 = (com.uxsense.rule.ApexTriggerRuleEditor.C13021) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.rule.ApexTriggerRuleEditor$deleteAll$1 r0 = new com.uxsense.rule.ApexTriggerRuleEditor$deleteAll$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.b.b(r4)
            goto L43
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r4)
            kotlin.collections.EmptyList r4 = kotlin.collections.EmptyList.f4893a
            r0.L$0 = r5
            r0.label = r2
            java.lang.Object r4 = com.uxsense.ruleTrigger.TriggerRuleParse.saveRules(r5, r4, r0)
            if (r4 != r6) goto L43
            return r6
        L43:
            com.uxsense.ruleTrigger.TriggerRuleParse.clearCache(r5)
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.rule.ApexTriggerRuleEditor.deleteAll(java.lang.String, H7.c):java.lang.Object");
    }

    public final String exportToJson(String packageName) throws JSONException {
        k.f(packageName, "packageName");
        List<TriggerRule> list = list(packageName);
        JSONArray jSONArray = new JSONArray();
        Iterator<TriggerRule> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(TriggerRuleParse.INSTANCE.ruleToJson$uxsense_release(it.next()));
        }
        String string = jSONArray.toString(2);
        k.e(string, "toString(...)");
        return string;
    }

    public final List<TriggerRule> find(String packageName, String activityClass) {
        k.f(packageName, "packageName");
        k.f(activityClass, "activityClass");
        List<TriggerRule> list = list(packageName);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((TriggerRule) obj).matchesActivity(activityClass)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final boolean hasRules(String packageName) {
        k.f(packageName, "packageName");
        return ApexMetadataFileManager.INSTANCE.getTriggerRuleFile(packageName).toFile().exists();
    }

    public final List<TriggerRule> list(String packageName) {
        k.f(packageName, "packageName");
        return TriggerRuleParse.getRulesByPackage(packageName);
    }

    public final List<RuleMatchResult> matchRules(KViewNode rootNode, String packageName, String activityClass) {
        k.f(rootNode, "rootNode");
        k.f(packageName, "packageName");
        k.f(activityClass, "activityClass");
        return TriggerRuleParse.parse(rootNode, packageName, activityClass);
    }

    public final Object replaceAll(String str, List<? extends TriggerRule> list, H7.c<? super r> cVar) {
        Object objSaveRules = TriggerRuleParse.saveRules(str, list, cVar);
        return objSaveRules == CoroutineSingletons.f4909a ? objSaveRules : r.f317a;
    }

    public final Object update(TriggerRule triggerRule, H7.c<? super r> cVar) {
        String packageName = triggerRule.getPackageName();
        k.e(packageName, "getPackageName(...)");
        ArrayList arrayListG1 = v.g1(list(packageName));
        Iterator it = arrayListG1.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (k.b(((TriggerRule) it.next()).getName(), triggerRule.getName())) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            arrayListG1.set(i, triggerRule);
        } else {
            arrayListG1.add(triggerRule);
        }
        String packageName2 = triggerRule.getPackageName();
        k.e(packageName2, "getPackageName(...)");
        Object objSaveRules = TriggerRuleParse.saveRules(packageName2, arrayListG1, cVar);
        return objSaveRules == CoroutineSingletons.f4909a ? objSaveRules : r.f317a;
    }

    public final Object create(TriggerRule triggerRule, H7.c<? super r> cVar) {
        String source = triggerRule.getSource();
        k.e(source, "getSource(...)");
        if (source.length() == 0) {
            triggerRule.setSource(ExecutionBundle.PREF_LOCAL);
        }
        String packageName = triggerRule.getPackageName();
        k.e(packageName, "getPackageName(...)");
        Object objAddRule = addRule(packageName, triggerRule, cVar);
        return objAddRule == CoroutineSingletons.f4909a ? objAddRule : r.f317a;
    }
}
