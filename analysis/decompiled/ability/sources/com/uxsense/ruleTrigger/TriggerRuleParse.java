package com.uxsense.ruleTrigger;

import C7.r;
import C9.AbstractC0200b;
import D7.F;
import D7.N;
import D7.v;
import D7.w;
import O7.i;
import S7.n;
import android.content.Context;
import android.util.Log;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.aiengine.args.ExecutionBundle;
import com.uxsense.ApexCore;
import com.uxsense.core.ApexMetadataFileManager;
import com.uxsense.core.base.parse.KViewNode;
import com.uxsense.core.model.ViewTrigger;
import com.uxsense.core.pattern.PatternMatchResult;
import com.uxsense.core.pattern.ViewPattern;
import com.uxsense.ruleTrigger.model.ActivityTrigger;
import com.uxsense.ruleTrigger.model.TriggerCondition;
import com.uxsense.ruleTrigger.model.TriggerMode;
import g1.AbstractC1451a;
import j9.AbstractC1607a;
import j9.m;
import j9.t;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w9.InterfaceC2108a;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0019\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001b\u0010\tJ\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b \u0010\u001eJ%\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010!2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\fH\u0002¢\u0006\u0004\b%\u0010&J\u0019\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010$\u001a\u00020\fH\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020\fH\u0002¢\u0006\u0004\b,\u0010-J\u0019\u00100\u001a\u00020/2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00105\u001a\u0002042\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u0002042\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b7\u00106J\u0017\u00108\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0004H\u0007¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0004H\u0007¢\u0006\u0004\b:\u00109J\u000f\u0010;\u001a\u00020\u0012H\u0007¢\u0006\u0004\b;\u0010\u0003J\u0017\u0010<\u001a\u0002042\u0006\u0010\u0015\u001a\u00020\u0004H\u0007¢\u0006\u0004\b<\u0010=J\u0019\u0010?\u001a\u0004\u0018\u00010/2\u0006\u0010>\u001a\u00020/H\u0002¢\u0006\u0004\b?\u0010@J\u0019\u0010B\u001a\u0004\u0018\u00010/2\u0006\u0010A\u001a\u00020/H\u0002¢\u0006\u0004\bB\u0010@J-\u0010G\u001a\b\u0012\u0004\u0012\u00020F0\u00062\u0006\u0010D\u001a\u00020C2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u0004H\u0007¢\u0006\u0004\bG\u0010HJ3\u0010G\u001a\b\u0012\u0004\u0012\u00020F0\u00062\u0006\u0010D\u001a\u00020C2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010E\u001a\u00020\u0004H\u0007¢\u0006\u0004\bG\u0010JJ&\u0010K\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0087@¢\u0006\u0004\bK\u0010LJ8\u0010O\u001a\u00020/2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010M\u001a\u00020/2\b\u0010N\u001a\u0004\u0018\u00010\u00042\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0087@¢\u0006\u0004\bO\u0010PJ\u0017\u0010Q\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\bQ\u0010RJ\u0017\u0010S\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0004H\u0007¢\u0006\u0004\bS\u0010RJ\u0017\u0010T\u001a\u00020/2\u0006\u0010\u0015\u001a\u00020\u0004H\u0007¢\u0006\u0004\bT\u0010UJ\u0017\u0010W\u001a\u0002022\u0006\u0010V\u001a\u000204H\u0002¢\u0006\u0004\bW\u0010XJ\u0017\u0010Y\u001a\u0002022\u0006\u0010V\u001a\u000204H\u0002¢\u0006\u0004\bY\u0010XR\u0014\u0010Z\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010\\\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\\\u0010[R\u0014\u0010]\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b]\u0010[R\u0018\u0010^\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010*\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010aR \u0010c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010d¨\u0006f"}, d2 = {"Lcom/uxsense/ruleTrigger/TriggerRuleParse;", "", AppAgent.CONSTRUCT, "()V", "", "jsonContent", "", "Lcom/uxsense/ruleTrigger/TriggerRule;", "parseRulesFromJson$uxsense_release", "(Ljava/lang/String;)Ljava/util/List;", "parseRulesFromJson", "rule", "Lorg/json/JSONObject;", "ruleToJson$uxsense_release", "(Lcom/uxsense/ruleTrigger/TriggerRule;)Lorg/json/JSONObject;", "ruleToJson", "Landroid/content/Context;", "context", "LC7/r;", "init", "(Landroid/content/Context;)V", "packageName", "Lcom/uxsense/ruleTrigger/TriggerRuleParse$RulesCache;", "getCache", "(Ljava/lang/String;)Lcom/uxsense/ruleTrigger/TriggerRuleParse$RulesCache;", "pkgName", "appVersion", "getRulesByPackage", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "getRulesInternal", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lcom/uxsense/ruleTrigger/VersionedRules;", "loadVersionedRulesInternal", "Lkotlin/Pair;", "readTriggerRulesJson", "(Ljava/lang/String;)Lkotlin/Pair;", "jsonObj", "parseRuleFromJson", "(Lorg/json/JSONObject;)Lcom/uxsense/ruleTrigger/TriggerRule;", "Lcom/uxsense/core/pattern/ViewPattern;", "parseViewPattern", "(Lorg/json/JSONObject;)Lcom/uxsense/core/pattern/ViewPattern;", "json", "Lcom/uxsense/ruleTrigger/model/TriggerCondition;", "parseTriggerCondition", "(Lorg/json/JSONObject;)Lcom/uxsense/ruleTrigger/model/TriggerCondition;", "value", "", "parseTriggerMode", "(Ljava/lang/Object;)I", "Lorg/json/JSONArray;", "jsonArray", "", "parseActivityTriggerArray", "(Lorg/json/JSONArray;)[I", "parseViewTriggerArray", "refreshRules", "(Ljava/lang/String;)V", "clearCache", "clearAllCache", "unionAllEvents", "(Ljava/lang/String;)[I", "activityTrigger", "mapActivityTriggerToEvent", "(I)Ljava/lang/Integer;", "viewTrigger", "mapViewTriggerToEvent", "Lcom/uxsense/core/base/parse/KViewNode;", "rootNode", "activityClass", "Lcom/uxsense/ruleTrigger/RuleMatchResult;", "parse", "(Lcom/uxsense/core/base/parse/KViewNode;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "rules", "(Lcom/uxsense/core/base/parse/KViewNode;Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "saveRules", "(Ljava/lang/String;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "version", "updatedAt", "saveVersionedRules", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "parseVersionedJson", "(Ljava/lang/String;)Lcom/uxsense/ruleTrigger/VersionedRules;", "loadVersionedRules", "getCachedVersion", "(Ljava/lang/String;)I", "arr", "activityTriggersToJsonArray", "([I)Lorg/json/JSONArray;", "viewTriggersToJsonArray", "TAG", "Ljava/lang/String;", "ASSET_TRIGGER_RULES_PREFIX", "ASSET_TRIGGER_RULES_SUFFIX", "applicationContext", "Landroid/content/Context;", "LC9/b;", "LC9/b;", "Ljava/util/concurrent/ConcurrentHashMap;", "rulesMap", "Ljava/util/concurrent/ConcurrentHashMap;", "RulesCache", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TriggerRuleParse {
    private static final String ASSET_TRIGGER_RULES_PREFIX = "trigger_rules_";
    private static final String ASSET_TRIGGER_RULES_SUFFIX = ".json";
    private static final String TAG = "TriggerRuleParse";
    private static volatile Context applicationContext;
    public static final TriggerRuleParse INSTANCE = new TriggerRuleParse();
    private static final AbstractC0200b json = com.stepos.ability.task.executor.e.b(new com.uxsense.parse.b(2));
    private static final ConcurrentHashMap<String, RulesCache> rulesMap = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J4\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u000eJ\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001c\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u000eR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010\u0010¨\u0006!"}, d2 = {"Lcom/uxsense/ruleTrigger/TriggerRuleParse$RulesCache;", "", "", "Lcom/uxsense/ruleTrigger/TriggerRule;", "rules", "", "version", "Lw9/a;", "mutex", AppAgent.CONSTRUCT, "(Ljava/util/List;ILw9/a;)V", "component1", "()Ljava/util/List;", "component2", "()I", "component3", "()Lw9/a;", "copy", "(Ljava/util/List;ILw9/a;)Lcom/uxsense/ruleTrigger/TriggerRuleParse$RulesCache;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getRules", "I", "getVersion", "Lw9/a;", "getMutex", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class RulesCache {
        private final InterfaceC2108a mutex;
        private final List<TriggerRule> rules;
        private final int version;

        public RulesCache() {
            this(null, 0, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RulesCache copy$default(RulesCache rulesCache, List list, int i, InterfaceC2108a interfaceC2108a, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                list = rulesCache.rules;
            }
            if ((i6 & 2) != 0) {
                i = rulesCache.version;
            }
            if ((i6 & 4) != 0) {
                interfaceC2108a = rulesCache.mutex;
            }
            return rulesCache.copy(list, i, interfaceC2108a);
        }

        public final List<TriggerRule> component1() {
            return this.rules;
        }

        /* renamed from: component2, reason: from getter */
        public final int getVersion() {
            return this.version;
        }

        /* renamed from: component3, reason: from getter */
        public final InterfaceC2108a getMutex() {
            return this.mutex;
        }

        public final RulesCache copy(List<? extends TriggerRule> rules, int version, InterfaceC2108a mutex) {
            k.f(rules, "rules");
            k.f(mutex, "mutex");
            return new RulesCache(rules, version, mutex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RulesCache)) {
                return false;
            }
            RulesCache rulesCache = (RulesCache) other;
            return k.b(this.rules, rulesCache.rules) && this.version == rulesCache.version && k.b(this.mutex, rulesCache.mutex);
        }

        public final InterfaceC2108a getMutex() {
            return this.mutex;
        }

        public final List<TriggerRule> getRules() {
            return this.rules;
        }

        public final int getVersion() {
            return this.version;
        }

        public int hashCode() {
            return this.mutex.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.version, this.rules.hashCode() * 31, 31);
        }

        public String toString() {
            return "RulesCache(rules=" + this.rules + ", version=" + this.version + ", mutex=" + this.mutex + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public RulesCache(List<? extends TriggerRule> rules, int i, InterfaceC2108a mutex) {
            k.f(rules, "rules");
            k.f(mutex, "mutex");
            this.rules = rules;
            this.version = i;
            this.mutex = mutex;
        }

        public RulesCache(List list, int i, InterfaceC2108a interfaceC2108a, int i6, kotlin.jvm.internal.e eVar) {
            this((i6 & 1) != 0 ? EmptyList.f4893a : list, (i6 & 2) != 0 ? 0 : i, (i6 & 4) != 0 ? new kotlinx.coroutines.sync.a() : interfaceC2108a);
        }
    }

    @J7.c(c = "com.uxsense.ruleTrigger.TriggerRuleParse$getRulesByPackage$1", f = "TriggerRuleParse.kt", l = {96}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/ruleTrigger/TriggerRule;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.ruleTrigger.TriggerRuleParse$getRulesByPackage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ String $pkgName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$pkgName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.$pkgName, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            TriggerRuleParse triggerRuleParse = TriggerRuleParse.INSTANCE;
            String str = this.$pkgName;
            this.label = 1;
            Object rulesInternal = triggerRuleParse.getRulesInternal(str, this);
            return rulesInternal == coroutineSingletons ? coroutineSingletons : rulesInternal;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<? extends TriggerRule>> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.ruleTrigger.TriggerRuleParse", f = "TriggerRuleParse.kt", l = {667, 117}, m = "getRulesInternal")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.ruleTrigger.TriggerRuleParse$getRulesInternal$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C13031(H7.c<? super C13031> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerRuleParse.this.getRulesInternal(null, this);
        }
    }

    @J7.c(c = "com.uxsense.ruleTrigger.TriggerRuleParse$loadVersionedRules$1", f = "TriggerRuleParse.kt", l = {590}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/uxsense/ruleTrigger/VersionedRules;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/ruleTrigger/VersionedRules;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.ruleTrigger.TriggerRuleParse$loadVersionedRules$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13041 extends SuspendLambda implements n {
        final /* synthetic */ String $packageName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13041(String str, H7.c<? super C13041> cVar) {
            super(2, cVar);
            this.$packageName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13041(this.$packageName, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            TriggerRuleParse triggerRuleParse = TriggerRuleParse.INSTANCE;
            String str = this.$packageName;
            this.label = 1;
            Object objLoadVersionedRulesInternal = triggerRuleParse.loadVersionedRulesInternal(str, this);
            return objLoadVersionedRulesInternal == coroutineSingletons ? coroutineSingletons : objLoadVersionedRulesInternal;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super VersionedRules> cVar) {
            return ((C13041) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.ruleTrigger.TriggerRuleParse$loadVersionedRulesInternal$2", f = "TriggerRuleParse.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/uxsense/ruleTrigger/VersionedRules;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/ruleTrigger/VersionedRules;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.ruleTrigger.TriggerRuleParse$loadVersionedRulesInternal$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ String $packageName;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$packageName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$packageName, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            try {
                Pair triggerRulesJson = TriggerRuleParse.INSTANCE.readTriggerRulesJson(this.$packageName);
                if (triggerRulesJson == null) {
                    Log.d(TriggerRuleParse.TAG, "loadRules: no trigger_rules content for " + this.$packageName);
                    return new VersionedRules(0, null, null, 7, null);
                }
                String str = (String) triggerRulesJson.f4886a;
                String str2 = (String) triggerRulesJson.b;
                VersionedRules versionedJson = TriggerRuleParse.parseVersionedJson(str);
                List<TriggerRule> rules = versionedJson.getRules();
                String str3 = this.$packageName;
                ArrayList<TriggerRule> arrayList = new ArrayList();
                for (Object obj2 : rules) {
                    if (k.b(((TriggerRule) obj2).getPackageName(), str3)) {
                        arrayList.add(obj2);
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("loadRules: source=");
                sb.append(str2);
                sb.append(" size=");
                sb.append(str.length());
                sb.append("B version=");
                sb.append(versionedJson.getVersion());
                sb.append(" rules=");
                sb.append(arrayList.size());
                sb.append(" names=");
                ArrayList arrayList2 = new ArrayList(w.c0(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((TriggerRule) it.next()).getName());
                }
                sb.append(arrayList2);
                Log.i(TriggerRuleParse.TAG, sb.toString());
                for (TriggerRule triggerRule : arrayList) {
                    Log.d(TriggerRuleParse.TAG, "loadRules: rule '" + triggerRule.getName() + "' source=" + triggerRule.getSource() + " viewPattern=" + triggerRule.getViewPattern());
                }
                Log.d(TriggerRuleParse.TAG, "loadRules success: " + arrayList.size() + " rules (v" + versionedJson.getVersion() + ") for " + this.$packageName);
                return new VersionedRules(versionedJson.getVersion(), versionedJson.getUpdatedAt(), arrayList);
            } catch (Exception e) {
                Log.e(TriggerRuleParse.TAG, "loadRules exception: " + e + " for " + this.$packageName);
                return new VersionedRules(0, null, null, 7, null);
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super VersionedRules> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.ruleTrigger.TriggerRuleParse$refreshRules$1", f = "TriggerRuleParse.kt", l = {667, 323}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.ruleTrigger.TriggerRuleParse$refreshRules$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13051 extends SuspendLambda implements n {
        final /* synthetic */ String $packageName;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13051(String str, H7.c<? super C13051> cVar) {
            super(2, cVar);
            this.$packageName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13051(this.$packageName, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            RulesCache cache;
            InterfaceC2108a interfaceC2108a;
            String str;
            Throwable th;
            InterfaceC2108a interfaceC2108a2;
            RulesCache rulesCache;
            String str2;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            try {
                if (i == 0) {
                    kotlin.b.b(obj);
                    cache = TriggerRuleParse.INSTANCE.getCache(this.$packageName);
                    InterfaceC2108a mutex = cache.getMutex();
                    String str3 = this.$packageName;
                    this.L$0 = cache;
                    this.L$1 = mutex;
                    this.L$2 = str3;
                    this.label = 1;
                    if (mutex.lock(null, this) != coroutineSingletons) {
                        interfaceC2108a = mutex;
                        str = str3;
                    }
                    return coroutineSingletons;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str2 = (String) this.L$2;
                    interfaceC2108a2 = (InterfaceC2108a) this.L$1;
                    RulesCache rulesCache2 = (RulesCache) this.L$0;
                    try {
                        kotlin.b.b(obj);
                        rulesCache = rulesCache2;
                        VersionedRules versionedRules = (VersionedRules) obj;
                        TriggerRuleParse.rulesMap.put(str2, RulesCache.copy$default(rulesCache, versionedRules.getRules(), versionedRules.getVersion(), null, 4, null));
                        interfaceC2108a2.unlock(null);
                        return r.f317a;
                    } catch (Throwable th2) {
                        th = th2;
                        interfaceC2108a2.unlock(null);
                        throw th;
                    }
                }
                str = (String) this.L$2;
                interfaceC2108a = (InterfaceC2108a) this.L$1;
                RulesCache rulesCache3 = (RulesCache) this.L$0;
                kotlin.b.b(obj);
                cache = rulesCache3;
                TriggerRuleParse triggerRuleParse = TriggerRuleParse.INSTANCE;
                this.L$0 = cache;
                this.L$1 = interfaceC2108a;
                this.L$2 = str;
                this.label = 2;
                Object objLoadVersionedRulesInternal = triggerRuleParse.loadVersionedRulesInternal(str, this);
                if (objLoadVersionedRulesInternal != coroutineSingletons) {
                    rulesCache = cache;
                    str2 = str;
                    interfaceC2108a2 = interfaceC2108a;
                    obj = objLoadVersionedRulesInternal;
                    VersionedRules versionedRules2 = (VersionedRules) obj;
                    TriggerRuleParse.rulesMap.put(str2, RulesCache.copy$default(rulesCache, versionedRules2.getRules(), versionedRules2.getVersion(), null, 4, null));
                    interfaceC2108a2.unlock(null);
                    return r.f317a;
                }
                return coroutineSingletons;
            } catch (Throwable th3) {
                th = th3;
                interfaceC2108a2 = interfaceC2108a;
                interfaceC2108a2.unlock(null);
                throw th;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C13051) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.ruleTrigger.TriggerRuleParse$saveVersionedRules$2", f = "TriggerRuleParse.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)I"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.ruleTrigger.TriggerRuleParse$saveVersionedRules$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13062 extends SuspendLambda implements n {
        final /* synthetic */ String $packageName;
        final /* synthetic */ List<TriggerRule> $rules;
        final /* synthetic */ String $updatedAt;
        final /* synthetic */ int $version;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C13062(String str, List<? extends TriggerRule> list, int i, String str2, H7.c<? super C13062> cVar) {
            super(2, cVar);
            this.$packageName = str;
            this.$rules = list;
            this.$version = i;
            this.$updatedAt = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13062(this.$packageName, this.$rules, this.$version, this.$updatedAt, cVar);
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
                File file = ApexMetadataFileManager.INSTANCE.getTriggerRuleFile(this.$packageName).toFile();
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                JSONArray jSONArray = new JSONArray();
                Iterator<TriggerRule> it = this.$rules.iterator();
                while (it.hasNext()) {
                    jSONArray.put(TriggerRuleParse.INSTANCE.ruleToJson$uxsense_release(it.next()));
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", this.$version);
                String str = this.$updatedAt;
                if (str != null) {
                    jSONObject.put("updatedAt", str);
                }
                jSONObject.put("rules", jSONArray);
                String string = jSONObject.toString(2);
                k.e(string, "toString(...)");
                i.Y(file, string);
                TriggerRuleParse.rulesMap.put(this.$packageName, RulesCache.copy$default(TriggerRuleParse.INSTANCE.getCache(this.$packageName), this.$rules, this.$version, null, 4, null));
                iE = Log.d(TriggerRuleParse.TAG, "saveVersionedRules success: " + this.$rules.size() + " rules (v" + this.$version + ") saved for " + this.$packageName);
            } catch (Exception e) {
                iE = Log.e(TriggerRuleParse.TAG, "saveVersionedRules exception: " + e + " for " + this.$packageName);
            }
            return new Integer(iE);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Integer> cVar) {
            return ((C13062) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    private TriggerRuleParse() {
    }

    private final JSONArray activityTriggersToJsonArray(int[] arr) {
        JSONArray jSONArray = new JSONArray();
        for (int i : arr) {
            jSONArray.put(ActivityTrigger.getName(i));
        }
        return jSONArray;
    }

    public static final void clearAllCache() {
        rulesMap.clear();
    }

    public static final void clearCache(String packageName) {
        k.f(packageName, "packageName");
        rulesMap.remove(packageName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RulesCache getCache(String packageName) {
        ConcurrentHashMap<String, RulesCache> concurrentHashMap = rulesMap;
        final com.uxsense.parse.b bVar = new com.uxsense.parse.b(3);
        RulesCache rulesCacheComputeIfAbsent = concurrentHashMap.computeIfAbsent(packageName, new Function() { // from class: com.uxsense.ruleTrigger.h
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return TriggerRuleParse.getCache$lambda$2(bVar, obj);
            }
        });
        k.e(rulesCacheComputeIfAbsent, "computeIfAbsent(...)");
        return rulesCacheComputeIfAbsent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RulesCache getCache$lambda$1(String it) {
        k.f(it, "it");
        return new RulesCache(null, 0, null, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RulesCache getCache$lambda$2(S7.k kVar, Object obj) {
        return (RulesCache) kVar.invoke(obj);
    }

    public static final int getCachedVersion(String packageName) {
        k.f(packageName, "packageName");
        RulesCache rulesCache = rulesMap.get(packageName);
        if (rulesCache != null) {
            return rulesCache.getVersion();
        }
        return 0;
    }

    public static final List<TriggerRule> getRulesByPackage(String pkgName, String appVersion) {
        k.f(pkgName, "pkgName");
        return (List) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new AnonymousClass1(pkgName, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getRulesInternal(java.lang.String r13, H7.c<? super java.util.List<? extends com.uxsense.ruleTrigger.TriggerRule>> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.uxsense.ruleTrigger.TriggerRuleParse.C13031
            if (r0 == 0) goto L13
            r0 = r14
            com.uxsense.ruleTrigger.TriggerRuleParse$getRulesInternal$1 r0 = (com.uxsense.ruleTrigger.TriggerRuleParse.C13031) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.ruleTrigger.TriggerRuleParse$getRulesInternal$1 r0 = new com.uxsense.ruleTrigger.TriggerRuleParse$getRulesInternal$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L55
            if (r2 == r4) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r12 = r0.L$2
            w9.a r12 = (w9.InterfaceC2108a) r12
            java.lang.Object r13 = r0.L$1
            com.uxsense.ruleTrigger.TriggerRuleParse$RulesCache r13 = (com.uxsense.ruleTrigger.TriggerRuleParse.RulesCache) r13
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.b.b(r14)     // Catch: java.lang.Throwable -> L39
        L36:
            r6 = r13
            goto La5
        L39:
            r0 = move-exception
            r13 = r0
            goto Lc3
        L3d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L45:
            java.lang.Object r12 = r0.L$2
            w9.a r12 = (w9.InterfaceC2108a) r12
            java.lang.Object r13 = r0.L$1
            com.uxsense.ruleTrigger.TriggerRuleParse$RulesCache r13 = (com.uxsense.ruleTrigger.TriggerRuleParse.RulesCache) r13
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.b.b(r14)
            goto L7e
        L55:
            kotlin.b.b(r14)
            com.uxsense.ruleTrigger.TriggerRuleParse$RulesCache r12 = r12.getCache(r13)
            java.util.List r14 = r12.getRules()
            java.util.Collection r14 = (java.util.Collection) r14
            boolean r2 = r14.isEmpty()
            if (r2 == 0) goto Lc7
            w9.a r14 = r12.getMutex()
            r0.L$0 = r13
            r0.L$1 = r12
            r0.L$2 = r14
            r0.label = r4
            java.lang.Object r2 = r14.lock(r5, r0)
            if (r2 != r1) goto L7b
            goto La2
        L7b:
            r2 = r13
            r13 = r12
            r12 = r14
        L7e:
            java.util.List r14 = r13.getRules()     // Catch: java.lang.Throwable -> L39
            java.util.Collection r14 = (java.util.Collection) r14     // Catch: java.lang.Throwable -> L39
            boolean r14 = r14.isEmpty()     // Catch: java.lang.Throwable -> L39
            if (r14 != 0) goto L92
            java.util.List r13 = r13.getRules()     // Catch: java.lang.Throwable -> L39
            r12.unlock(r5)
            return r13
        L92:
            com.uxsense.ruleTrigger.TriggerRuleParse r14 = com.uxsense.ruleTrigger.TriggerRuleParse.INSTANCE     // Catch: java.lang.Throwable -> L39
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L39
            r0.L$1 = r13     // Catch: java.lang.Throwable -> L39
            r0.L$2 = r12     // Catch: java.lang.Throwable -> L39
            r0.label = r3     // Catch: java.lang.Throwable -> L39
            java.lang.Object r14 = r14.loadVersionedRulesInternal(r2, r0)     // Catch: java.lang.Throwable -> L39
            if (r14 != r1) goto La3
        La2:
            return r1
        La3:
            r0 = r2
            goto L36
        La5:
            com.uxsense.ruleTrigger.VersionedRules r14 = (com.uxsense.ruleTrigger.VersionedRules) r14     // Catch: java.lang.Throwable -> L39
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.uxsense.ruleTrigger.TriggerRuleParse$RulesCache> r13 = com.uxsense.ruleTrigger.TriggerRuleParse.rulesMap     // Catch: java.lang.Throwable -> L39
            java.util.List r7 = r14.getRules()     // Catch: java.lang.Throwable -> L39
            int r8 = r14.getVersion()     // Catch: java.lang.Throwable -> L39
            r10 = 4
            r11 = 0
            r9 = 0
            com.uxsense.ruleTrigger.TriggerRuleParse$RulesCache r1 = com.uxsense.ruleTrigger.TriggerRuleParse.RulesCache.copy$default(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L39
            r13.put(r0, r1)     // Catch: java.lang.Throwable -> L39
            java.util.List r13 = r14.getRules()     // Catch: java.lang.Throwable -> L39
            r12.unlock(r5)
            return r13
        Lc3:
            r12.unlock(r5)
            throw r13
        Lc7:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ruleTrigger.TriggerRuleParse.getRulesInternal(java.lang.String, H7.c):java.lang.Object");
    }

    public static final void init(Context context) {
        k.f(context, "context");
        applicationContext = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r json$lambda$0(C9.g Json) {
        k.f(Json, "$this$Json");
        Json.c = true;
        Json.d = true;
        return r.f317a;
    }

    public static final VersionedRules loadVersionedRules(String packageName) {
        k.f(packageName, "packageName");
        return (VersionedRules) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C13041(packageName, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadVersionedRulesInternal(String str, H7.c<? super VersionedRules> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(str, null), cVar);
    }

    private final Integer mapActivityTriggerToEvent(int activityTrigger) {
        if (activityTrigger == 20) {
            return 20;
        }
        if (activityTrigger == 999) {
            return 999;
        }
        switch (activityTrigger) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            default:
                return null;
        }
    }

    private final Integer mapViewTriggerToEvent(int viewTrigger) {
        if (viewTrigger == ViewTrigger.ON_CLICK.ordinal()) {
            return 100;
        }
        return viewTrigger == ViewTrigger.ANY.ordinal() ? 999 : null;
    }

    public static final List<RuleMatchResult> parse(KViewNode rootNode, String packageName, String activityClass) {
        k.f(rootNode, "rootNode");
        k.f(packageName, "packageName");
        k.f(activityClass, "activityClass");
        List<TriggerRule> rulesByPackage = getRulesByPackage(packageName);
        if (!rulesByPackage.isEmpty()) {
            return parse(rootNode, rulesByPackage, activityClass);
        }
        Log.d(TAG, "parse: no rules found for ".concat(packageName));
        return EmptyList.f4893a;
    }

    private final int[] parseActivityTriggerArray(JSONArray jsonArray) throws JSONException {
        Y7.f fVarX = AbstractC1451a.X(0, jsonArray.length());
        ArrayList arrayList = new ArrayList();
        Iterator it = fVarX.iterator();
        while (it.hasNext()) {
            Object obj = jsonArray.get(((F) it).nextInt());
            Integer numValueOf = obj instanceof Integer ? (Integer) obj : obj instanceof Number ? Integer.valueOf(((Number) obj).intValue()) : obj instanceof String ? Integer.valueOf(ActivityTrigger.fromName((String) obj)) : null;
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
        }
        return v.e1(arrayList);
    }

    private final TriggerRule parseRuleFromJson(JSONObject jsonObj) throws JSONException {
        TriggerCondition triggerCondition;
        if (jsonObj.has("trigger")) {
            JSONObject jSONObject = jsonObj.getJSONObject("trigger");
            k.e(jSONObject, "getJSONObject(...)");
            triggerCondition = parseTriggerCondition(jSONObject);
        } else {
            triggerCondition = new TriggerCondition();
        }
        TriggerCondition triggerCondition2 = triggerCondition;
        return new TriggerRule(jsonObj.optString(HintConstants.AUTOFILL_HINT_NAME, ""), jsonObj.optString("description", ""), jsonObj.optString("packageName", ""), jsonObj.optString("activityClass", null), jsonObj.optString("windowTitle", null), parseViewPattern(jsonObj), null, triggerCondition2, jsonObj.optBoolean("enabled", true), jsonObj.optString(AgentBusWakeContract.EXTRA_SOURCE, ExecutionBundle.PREF_LOCAL));
    }

    private final TriggerCondition parseTriggerCondition(JSONObject json2) throws JSONException {
        int[] activityTriggerArray;
        int[] viewTriggerArray;
        if (json2.has("activityTriggers")) {
            JSONArray jSONArray = json2.getJSONArray("activityTriggers");
            k.e(jSONArray, "getJSONArray(...)");
            activityTriggerArray = parseActivityTriggerArray(jSONArray);
        } else {
            activityTriggerArray = new int[0];
        }
        int[] iArr = activityTriggerArray;
        if (json2.has("viewTriggers")) {
            JSONArray jSONArray2 = json2.getJSONArray("viewTriggers");
            k.e(jSONArray2, "getJSONArray(...)");
            viewTriggerArray = parseViewTriggerArray(jSONArray2);
        } else {
            viewTriggerArray = new int[0];
        }
        return new TriggerCondition(iArr, viewTriggerArray, parseTriggerMode(json2.opt("mode")), json2.optLong("delayMillis", 0L), json2.optLong("cooldownMillis", 0L), json2.optInt("maxTriggerCount", 0), json2.optBoolean("triggerOnce", false));
    }

    private final int parseTriggerMode(Object value) {
        if (!(value instanceof Integer) && !(value instanceof Number)) {
            if (value instanceof String) {
                return TriggerMode.fromName((String) value);
            }
            return 0;
        }
        return ((Number) value).intValue();
    }

    public static final VersionedRules parseVersionedJson(String jsonContent) {
        k.f(jsonContent, "jsonContent");
        if (t.e0(m.U0(jsonContent).toString(), "[", false)) {
            return new VersionedRules(0, null, INSTANCE.parseRulesFromJson$uxsense_release(jsonContent));
        }
        JSONObject jSONObject = new JSONObject(jsonContent);
        int iOptInt = jSONObject.optInt("version", 0);
        String strOptString = jSONObject.optString("updatedAt", null);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rules");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        TriggerRuleParse triggerRuleParse = INSTANCE;
        String string = jSONArrayOptJSONArray.toString();
        k.e(string, "toString(...)");
        return new VersionedRules(iOptInt, strOptString, triggerRuleParse.parseRulesFromJson$uxsense_release(string));
    }

    private final ViewPattern parseViewPattern(JSONObject jsonObj) {
        if (!jsonObj.has("viewPattern")) {
            return null;
        }
        try {
            String string = jsonObj.getJSONObject("viewPattern").toString();
            k.e(string, "toString(...)");
            AbstractC0200b abstractC0200b = json;
            abstractC0200b.getClass();
            return (ViewPattern) abstractC0200b.a(ViewPattern.INSTANCE.serializer(), string);
        } catch (Exception e) {
            androidx.constraintlayout.core.dsl.a.t(e, new StringBuilder("parseViewPattern failed: "), TAG);
            return null;
        }
    }

    private final int[] parseViewTriggerArray(JSONArray jsonArray) throws JSONException {
        Y7.f fVarX = AbstractC1451a.X(0, jsonArray.length());
        ArrayList arrayList = new ArrayList();
        Iterator it = fVarX.iterator();
        while (it.hasNext()) {
            Object obj = jsonArray.get(((F) it).nextInt());
            Integer numValueOf = obj instanceof Integer ? (Integer) obj : obj instanceof Number ? Integer.valueOf(((Number) obj).intValue()) : obj instanceof String ? Integer.valueOf(ViewTrigger.INSTANCE.fromName((String) obj)) : null;
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
        }
        return v.e1(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<String, String> readTriggerRulesJson(String packageName) throws IOException {
        File file = ApexMetadataFileManager.INSTANCE.getTriggerRuleFile(packageName).toFile();
        if (file.exists()) {
            return new Pair<>(i.X(file, AbstractC1607a.f4778a), file.getAbsolutePath());
        }
        Context context = applicationContext;
        if (context == null) {
            Log.w(TAG, "loadRules: file missing for " + packageName + " and applicationContext is null; call TriggerRuleParse.init(Context) for assets fallback");
            return null;
        }
        String strM = B7.a.m(ASSET_TRIGGER_RULES_PREFIX, packageName, ASSET_TRIGGER_RULES_SUFFIX);
        try {
            InputStream inputStreamOpen = context.getAssets().open(strM);
            try {
                k.c(inputStreamOpen);
                Pair<String, String> pair = new Pair<>(S0.b.o1(new BufferedReader(new InputStreamReader(inputStreamOpen, AbstractC1607a.f4778a), 8192)), "assets://" + strM);
                N.t(inputStreamOpen, null);
                return pair;
            } finally {
            }
        } catch (Exception unused) {
            Log.d(TAG, androidx.appfunctions.metadata.a.m("loadRules: no assets fallback for ", packageName, " (assets/", strM, " not found)"));
            return null;
        }
    }

    public static final void refreshRules(String packageName) throws Throwable {
        k.f(packageName, "packageName");
        AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C13051(packageName, null));
    }

    public static final Object saveRules(String str, List<? extends TriggerRule> list, H7.c<? super r> cVar) {
        Object objSaveVersionedRules = saveVersionedRules(str, getCachedVersion(str), null, list, cVar);
        return objSaveVersionedRules == CoroutineSingletons.f4909a ? objSaveVersionedRules : r.f317a;
    }

    public static final Object saveVersionedRules(String str, int i, String str2, List<? extends TriggerRule> list, H7.c<? super Integer> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C13062(str, list, i, str2, null), cVar);
    }

    public static final int[] unionAllEvents(String packageName) {
        k.f(packageName, "packageName");
        List<TriggerRule> rulesByPackage = getRulesByPackage(packageName);
        int i = 0;
        if (rulesByPackage.isEmpty()) {
            return new int[0];
        }
        TreeSet treeSet = new TreeSet();
        for (TriggerRule triggerRule : rulesByPackage) {
            if (triggerRule.isEnabled()) {
                for (int i6 : triggerRule.getTrigger().getActivityTriggers()) {
                    Integer numMapActivityTriggerToEvent = INSTANCE.mapActivityTriggerToEvent(i6);
                    if (numMapActivityTriggerToEvent != null) {
                        treeSet.add(Integer.valueOf(numMapActivityTriggerToEvent.intValue()));
                    }
                }
                for (int i10 : triggerRule.getTrigger().getViewTriggers()) {
                    Integer numMapViewTriggerToEvent = INSTANCE.mapViewTriggerToEvent(i10);
                    if (numMapViewTriggerToEvent != null) {
                        treeSet.add(Integer.valueOf(numMapViewTriggerToEvent.intValue()));
                    }
                }
                if (triggerRule.requiresViewMatching()) {
                    int[] activityTriggers = triggerRule.getTrigger().getActivityTriggers();
                    k.e(activityTriggers, "getActivityTriggers(...)");
                    if (activityTriggers.length == 0) {
                        treeSet.add(20);
                    }
                }
            }
        }
        int[] iArr = new int[treeSet.size()];
        Iterator it = treeSet.iterator();
        k.e(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            k.e(next, "next(...)");
            iArr[i] = ((Number) next).intValue();
            i++;
        }
        Log.d(TAG, "unionAllEvents(" + packageName + ") = " + treeSet);
        return iArr;
    }

    private final JSONArray viewTriggersToJsonArray(int[] arr) {
        String strValueOf;
        JSONArray jSONArray = new JSONArray();
        for (int i : arr) {
            ViewTrigger viewTrigger = (ViewTrigger) v.D0(i, ViewTrigger.getEntries());
            if (viewTrigger == null || (strValueOf = viewTrigger.name()) == null) {
                strValueOf = String.valueOf(i);
            }
            jSONArray.put(strValueOf);
        }
        return jSONArray;
    }

    public final List<TriggerRule> parseRulesFromJson$uxsense_release(String jsonContent) throws JSONException {
        k.f(jsonContent, "jsonContent");
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(jsonContent);
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            k.c(jSONObject);
            arrayList.add(parseRuleFromJson(jSONObject));
        }
        return arrayList;
    }

    public final JSONObject ruleToJson$uxsense_release(TriggerRule rule) throws JSONException {
        k.f(rule, "rule");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(HintConstants.AUTOFILL_HINT_NAME, rule.getName());
        jSONObject.put("description", rule.getDescription());
        jSONObject.put("packageName", rule.getPackageName());
        Object activityClass = rule.getActivityClass();
        if (activityClass == null) {
            activityClass = JSONObject.NULL;
        }
        jSONObject.put("activityClass", activityClass);
        Object windowTitle = rule.getWindowTitle();
        if (windowTitle == null) {
            windowTitle = JSONObject.NULL;
        }
        jSONObject.put("windowTitle", windowTitle);
        jSONObject.put("enabled", rule.isEnabled());
        jSONObject.put(AgentBusWakeContract.EXTRA_SOURCE, rule.getSource());
        JSONObject jSONObject2 = new JSONObject();
        TriggerCondition trigger = rule.getTrigger();
        k.e(trigger, "getTrigger(...)");
        int[] activityTriggers = trigger.getActivityTriggers();
        k.e(activityTriggers, "getActivityTriggers(...)");
        jSONObject2.put("activityTriggers", activityTriggersToJsonArray(activityTriggers));
        int[] viewTriggers = trigger.getViewTriggers();
        k.e(viewTriggers, "getViewTriggers(...)");
        jSONObject2.put("viewTriggers", viewTriggersToJsonArray(viewTriggers));
        jSONObject2.put("mode", TriggerMode.getName(trigger.getMode()));
        jSONObject2.put("delayMillis", trigger.getDelayMillis());
        jSONObject2.put("cooldownMillis", trigger.getCooldownMillis());
        jSONObject2.put("maxTriggerCount", trigger.getMaxTriggerCount());
        jSONObject2.put("triggerOnce", trigger.isTriggerOnce());
        jSONObject.put("trigger", jSONObject2);
        ViewPattern viewPattern = rule.getViewPattern();
        if (viewPattern != null) {
            try {
                jSONObject.put("viewPattern", new JSONObject(json.b(ViewPattern.INSTANCE.serializer(), viewPattern)));
            } catch (Exception e) {
                androidx.constraintlayout.core.dsl.a.t(e, new StringBuilder("ruleToJson: failed to serialize viewPattern: "), TAG);
            }
        }
        return jSONObject;
    }

    public static final List<TriggerRule> getRulesByPackage(String pkgName) {
        k.f(pkgName, "pkgName");
        return getRulesByPackage(pkgName, null);
    }

    public static final List<RuleMatchResult> parse(KViewNode rootNode, List<? extends TriggerRule> rules, String activityClass) {
        k.f(rootNode, "rootNode");
        k.f(rules, "rules");
        k.f(activityClass, "activityClass");
        Log.d(TAG, "parse: start, rules=" + rules.size() + ", activityClass=" + activityClass);
        if (rules.isEmpty()) {
            Log.d(TAG, "parse: no rules provided");
            return EmptyList.f4893a;
        }
        ArrayList arrayList = new ArrayList();
        for (TriggerRule triggerRule : rules) {
            Log.d(TAG, "parse: checking rule '" + triggerRule.getName() + "', ruleActivity=" + triggerRule.getActivityClass());
            boolean zMatchesActivity = triggerRule.matchesActivity(activityClass);
            StringBuilder sb = new StringBuilder("parse: activity matches=");
            sb.append(zMatchesActivity);
            Log.d(TAG, sb.toString());
            if (zMatchesActivity) {
                ViewPattern viewPattern = triggerRule.getViewPattern();
                if (viewPattern == null) {
                    Log.d(TAG, "parse: no viewPattern, add as activity-level match for rule '" + triggerRule.getName() + '\'');
                    arrayList.add(new RuleMatchResult(triggerRule, EmptyList.f4893a, 0));
                } else {
                    Log.d(TAG, "parse: has viewPattern, start view tree matching for rule '" + triggerRule.getName() + '\'');
                    List<PatternMatchResult> listMatch = ApexCore.INSTANCE.match(rootNode, viewPattern, triggerRule.getParentFilter());
                    Log.d(TAG, "parse: viewPattern match results=" + listMatch.size() + " for rule '" + triggerRule.getName() + '\'');
                    if (listMatch.isEmpty()) {
                        Log.d(TAG, "parse: viewPattern not matched, skip rule '" + triggerRule.getName() + '\'');
                    } else {
                        arrayList.add(new RuleMatchResult(triggerRule, listMatch, listMatch.size()));
                    }
                }
            } else {
                Log.d(TAG, "parse: activity not matched, skip rule '" + triggerRule.getName() + '\'');
            }
        }
        Log.d(TAG, "parse: found " + arrayList.size() + " matching rules for " + activityClass);
        return arrayList;
    }
}
