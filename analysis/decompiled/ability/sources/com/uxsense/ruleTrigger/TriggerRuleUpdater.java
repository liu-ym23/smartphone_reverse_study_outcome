package com.uxsense.ruleTrigger;

import D7.v;
import D7.w;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.ExecutionBundle;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\b\u0010\tJ1\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/uxsense/ruleTrigger/TriggerRuleUpdater;", "", AppAgent.CONSTRUCT, "()V", "", "packageName", "remoteJson", "", "applyRemoteRules", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "", "Lcom/uxsense/ruleTrigger/TriggerRule;", "localRules", "remoteRules", "mergeRules$uxsense_release", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "mergeRules", "TAG", "Ljava/lang/String;", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "dateFormatter", "Ljava/time/format/DateTimeFormatter;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TriggerRuleUpdater {
    private static final String TAG = "TriggerRuleUpdater";
    public static final TriggerRuleUpdater INSTANCE = new TriggerRuleUpdater();
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    @J7.c(c = "com.uxsense.ruleTrigger.TriggerRuleUpdater", f = "TriggerRuleUpdater.kt", l = {51}, m = "applyRemoteRules")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.ruleTrigger.TriggerRuleUpdater$applyRemoteRules$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerRuleUpdater.this.applyRemoteRules(null, null, this);
        }
    }

    private TriggerRuleUpdater() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object applyRemoteRules(java.lang.String r9, java.lang.String r10, H7.c<? super java.lang.Boolean> r11) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ruleTrigger.TriggerRuleUpdater.applyRemoteRules(java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    public final List<TriggerRule> mergeRules$uxsense_release(List<? extends TriggerRule> localRules, List<? extends TriggerRule> remoteRules) {
        k.f(localRules, "localRules");
        k.f(remoteRules, "remoteRules");
        ArrayList arrayList = new ArrayList();
        List<? extends TriggerRule> list = remoteRules;
        ArrayList arrayList2 = new ArrayList(w.c0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(((TriggerRule) it.next()).getName());
        }
        Set setJ1 = v.j1(arrayList2);
        Iterator<? extends TriggerRule> it2 = remoteRules.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        for (TriggerRule triggerRule : localRules) {
            if (k.b(triggerRule.getSource(), ExecutionBundle.PREF_LOCAL) && !setJ1.contains(triggerRule.getName())) {
                arrayList.add(triggerRule);
            }
        }
        return arrayList;
    }
}
