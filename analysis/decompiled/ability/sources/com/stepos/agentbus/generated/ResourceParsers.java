package com.stepos.agentbus.generated;

import D7.v;
import D7.w;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.CallingMethod;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.deepbinder.core.constant.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u001c\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fJ\u001c\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fJ\u001c\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fJ\u001c\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fJ\u001c\u0010\u0016\u001a\u00020\u00172\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fJ\u001c\u0010\u0018\u001a\u00020\u00192\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fJ\u001c\u0010\u001a\u001a\u00020\u001b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fJ\u001c\u0010\u001c\u001a\u00020\u001d2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fJ\u001c\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\u0006\u0010\u001f\u001a\u00020 J\u001c\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\u0006\u0010\"\u001a\u00020#J\u001c\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\u0006\u0010\"\u001a\u00020%J\u001c\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\u0006\u0010'\u001a\u00020\u0019J\u001c\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\u0006\u0010'\u001a\u00020\u0015¨\u0006)"}, d2 = {"Lcom/stepos/agentbus/generated/ResourceParsers;", "", AppAgent.CONSTRUCT, "()V", "parseInstallSource", "Lcom/stepos/agentbus/generated/InstallSource;", "s", "", "parseToolType", "Lcom/stepos/agentbus/generated/ToolType;", "parseCronRunStatus", "Lcom/stepos/agentbus/generated/CronRunStatus;", "parseSkillSpec", "Lcom/stepos/agentbus/generated/SkillSpec;", "o", "", "parseToolSpec", "Lcom/stepos/agentbus/generated/ToolSpec;", "parseChannelSpec", "Lcom/stepos/agentbus/generated/ChannelSpec;", "parseCronJobSpec", "Lcom/stepos/agentbus/generated/CronJobSpec;", "parseCronRunLog", "Lcom/stepos/agentbus/generated/CronRunLogSpec;", "parseModelConfig", "Lcom/stepos/agentbus/generated/ModelConfig;", "parseGatewayStatus", "Lcom/stepos/agentbus/generated/GatewayStatus;", "parseOperationResult", "Lcom/stepos/agentbus/generated/OperationResult;", "installRequestToMap", "r", "Lcom/stepos/agentbus/generated/InstallRequest;", "skillFilterToMap", "f", "Lcom/stepos/agentbus/generated/SkillFilter;", "toolFilterToMap", "Lcom/stepos/agentbus/generated/ToolFilter;", "modelConfigToMap", "c", "cronJobSpecToMap", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ResourceParsers {
    public static final ResourceParsers INSTANCE = new ResourceParsers();

    private ResourceParsers() {
    }

    public final Map<String, Object> cronJobSpecToMap(CronJobSpec c) {
        k.f(c, "c");
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.put("jobId", c.getJobId());
        mapBuilder.put(HintConstants.AUTOFILL_HINT_NAME, c.getName());
        mapBuilder.put("schedule", c.getSchedule());
        mapBuilder.put("actionTarget", c.getActionTarget());
        mapBuilder.put("isEnabled", Boolean.valueOf(c.isEnabled()));
        mapBuilder.put("deleteAfterRun", Boolean.valueOf(c.getDeleteAfterRun()));
        Long nextRunAtMs = c.getNextRunAtMs();
        if (nextRunAtMs != null) {
            mapBuilder.put("nextRunAtMs", Long.valueOf(nextRunAtMs.longValue()));
        }
        String payloadText = c.getPayloadText();
        if (payloadText != null) {
            mapBuilder.put("payloadText", payloadText);
        }
        return mapBuilder.b();
    }

    public final Map<String, Object> installRequestToMap(InstallRequest r5) {
        k.f(r5, "r");
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.put("id", r5.getId());
        mapBuilder.put("version", r5.getVersion());
        mapBuilder.put("blobRef", r5.getBlobRef());
        mapBuilder.put(AgentBusWakeContract.EXTRA_SOURCE, r5.getSource().name());
        if (!r5.getExtras().isEmpty()) {
            mapBuilder.put(GuiTaskProgressKt.GuiTaskProgress_KEY_EXTRAS, r5.getExtras());
        }
        String catalogDescription = r5.getCatalogDescription();
        if (catalogDescription != null) {
            mapBuilder.put("catalogDescription", catalogDescription);
        }
        return mapBuilder.b();
    }

    public final Map<String, Object> modelConfigToMap(ModelConfig c) {
        k.f(c, "c");
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.put("provider", c.getProvider());
        mapBuilder.put(AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, c.getModel());
        String baseUrl = c.getBaseUrl();
        if (baseUrl != null) {
            mapBuilder.put("baseUrl", baseUrl);
        }
        String api = c.getApi();
        if (api != null) {
            mapBuilder.put("api", api);
        }
        String apiKey = c.getApiKey();
        if (apiKey != null) {
            mapBuilder.put("apiKey", apiKey);
        }
        return mapBuilder.b();
    }

    public final ChannelSpec parseChannelSpec(Map<String, ? extends Object> o) {
        List arrayList;
        k.f(o, "o");
        String string$default = AgentBusMapExtensionsKt.getString$default(o, "id", null, 2, null);
        String string$default2 = AgentBusMapExtensionsKt.getString$default(o, "channelId", null, 2, null);
        String string$default3 = AgentBusMapExtensionsKt.getString$default(o, HintConstants.AUTOFILL_HINT_NAME, null, 2, null);
        String stringOrNull = AgentBusMapExtensionsKt.getStringOrNull(o, "status");
        String stringOrNull2 = AgentBusMapExtensionsKt.getStringOrNull(o, "version");
        Object obj = o.get("tags");
        List list = obj instanceof List ? (List) obj : null;
        if (list != null) {
            arrayList = new ArrayList();
            for (Object obj2 : list) {
                String str = obj2 instanceof String ? (String) obj2 : null;
                if (str != null) {
                    arrayList.add(str);
                }
            }
        } else {
            arrayList = EmptyList.f4893a;
        }
        List list2 = arrayList;
        boolean z10 = AgentBusMapExtensionsKt.getBoolean(o, "isEnabled", true);
        String stringOrNull3 = AgentBusMapExtensionsKt.getStringOrNull(o, "description");
        Map<String, Object> map = AgentBusMapExtensionsKt.getMap(o, "metadata");
        if (map == null) {
            map = kotlin.collections.a.M();
        }
        return new ChannelSpec(string$default, string$default2, string$default3, stringOrNull, stringOrNull2, list2, z10, stringOrNull3, map);
    }

    public final CronJobSpec parseCronJobSpec(Map<String, ? extends Object> o) {
        k.f(o, "o");
        String string$default = AgentBusMapExtensionsKt.getString$default(o, "jobId", null, 2, null);
        String string$default2 = AgentBusMapExtensionsKt.getString$default(o, HintConstants.AUTOFILL_HINT_NAME, null, 2, null);
        String string$default3 = AgentBusMapExtensionsKt.getString$default(o, "schedule", null, 2, null);
        String string$default4 = AgentBusMapExtensionsKt.getString$default(o, "actionTarget", null, 2, null);
        boolean z10 = AgentBusMapExtensionsKt.getBoolean(o, "isEnabled", true);
        boolean boolean$default = AgentBusMapExtensionsKt.getBoolean$default(o, "deleteAfterRun", false, 2, null);
        Object obj = o.get("nextRunAtMs");
        Number number = obj instanceof Number ? (Number) obj : null;
        return new CronJobSpec(string$default, string$default2, string$default3, string$default4, z10, boolean$default, number != null ? Long.valueOf(number.longValue()) : null, AgentBusMapExtensionsKt.getStringOrNull(o, "payloadText"));
    }

    public final CronRunLogSpec parseCronRunLog(Map<String, ? extends Object> o) {
        k.f(o, "o");
        long long$default = AgentBusMapExtensionsKt.getLong$default(o, "tsMs", 0L, 2, null);
        String string$default = AgentBusMapExtensionsKt.getString$default(o, "jobId", null, 2, null);
        CronRunStatus cronRunStatus = parseCronRunStatus(AgentBusMapExtensionsKt.getStringOrNull(o, "status"));
        String stringOrNull = AgentBusMapExtensionsKt.getStringOrNull(o, "summary");
        String stringOrNull2 = AgentBusMapExtensionsKt.getStringOrNull(o, "error");
        Object obj = o.get("nextRunAtMs");
        Number number = obj instanceof Number ? (Number) obj : null;
        Long lValueOf = number != null ? Long.valueOf(number.longValue()) : null;
        Object obj2 = o.get("durationMs");
        Number number2 = obj2 instanceof Number ? (Number) obj2 : null;
        Long lValueOf2 = number2 != null ? Long.valueOf(number2.longValue()) : null;
        Object obj3 = o.get("runAtMs");
        Number number3 = obj3 instanceof Number ? (Number) obj3 : null;
        return new CronRunLogSpec(long$default, string$default, cronRunStatus, stringOrNull, stringOrNull2, lValueOf, lValueOf2, number3 != null ? Long.valueOf(number3.longValue()) : null, AgentBusMapExtensionsKt.getStringOrNull(o, "sessionKey"));
    }

    public final CronRunStatus parseCronRunStatus(String s5) {
        String upperCase;
        if (s5 != null) {
            upperCase = s5.toUpperCase(Locale.ROOT);
            k.e(upperCase, "toUpperCase(...)");
        } else {
            upperCase = null;
        }
        if (upperCase == null) {
            return null;
        }
        int iHashCode = upperCase.hashCode();
        if (iHashCode == -1429540080) {
            if (upperCase.equals("SKIPPED")) {
                return CronRunStatus.SKIPPED;
            }
            return null;
        }
        if (iHashCode == 2524) {
            if (upperCase.equals("OK")) {
                return CronRunStatus.OK;
            }
            return null;
        }
        if (iHashCode == 66247144 && upperCase.equals("ERROR")) {
            return CronRunStatus.ERROR;
        }
        return null;
    }

    public final GatewayStatus parseGatewayStatus(Map<String, ? extends Object> o) {
        k.f(o, "o");
        boolean boolean$default = AgentBusMapExtensionsKt.getBoolean$default(o, "isReady", false, 2, null);
        boolean boolean$default2 = AgentBusMapExtensionsKt.getBoolean$default(o, "processAlive", false, 2, null);
        Object obj = o.get(Constants.PARAM_PID);
        Number number = obj instanceof Number ? (Number) obj : null;
        return new GatewayStatus(boolean$default, boolean$default2, number != null ? Long.valueOf(number.longValue()) : null, AgentBusMapExtensionsKt.getStringOrNull(o, "vendor"), AgentBusMapExtensionsKt.getStringOrNull(o, "version"));
    }

    public final InstallSource parseInstallSource(String s5) {
        String upperCase;
        if (s5 != null) {
            upperCase = s5.toUpperCase(Locale.ROOT);
            k.e(upperCase, "toUpperCase(...)");
        } else {
            upperCase = null;
        }
        if (upperCase != null) {
            int iHashCode = upperCase.hashCode();
            if (iHashCode != -1881281466) {
                if (iHashCode != 72607563) {
                    if (iHashCode == 953314306 && upperCase.equals("BUNDLED")) {
                        return InstallSource.BUNDLED;
                    }
                } else if (upperCase.equals(CallingMethod.LOCAL)) {
                    return InstallSource.LOCAL;
                }
            } else if (upperCase.equals("REMOTE")) {
                return InstallSource.REMOTE;
            }
        }
        return InstallSource.UNKNOWN;
    }

    public final ModelConfig parseModelConfig(Map<String, ? extends Object> o) {
        k.f(o, "o");
        return new ModelConfig(AgentBusMapExtensionsKt.getString$default(o, "provider", null, 2, null), AgentBusMapExtensionsKt.getString$default(o, AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, null, 2, null), AgentBusMapExtensionsKt.getStringOrNull(o, "baseUrl"), AgentBusMapExtensionsKt.getStringOrNull(o, "api"), AgentBusMapExtensionsKt.getStringOrNull(o, "apiKey"));
    }

    public final OperationResult parseOperationResult(Map<String, ? extends Object> o) {
        k.f(o, "o");
        boolean boolean$default = AgentBusMapExtensionsKt.getBoolean$default(o, "success", false, 2, null);
        String stringOrNull = AgentBusMapExtensionsKt.getStringOrNull(o, "id");
        String stringOrNull2 = AgentBusMapExtensionsKt.getStringOrNull(o, "errorCode");
        String stringOrNull3 = AgentBusMapExtensionsKt.getStringOrNull(o, "message");
        Map<String, Object> map = AgentBusMapExtensionsKt.getMap(o, "details");
        if (map == null) {
            map = kotlin.collections.a.M();
        }
        return new OperationResult(boolean$default, stringOrNull, stringOrNull2, stringOrNull3, map);
    }

    public final SkillSpec parseSkillSpec(Map<String, ? extends Object> o) {
        List arrayList;
        k.f(o, "o");
        String string$default = AgentBusMapExtensionsKt.getString$default(o, "id", null, 2, null);
        String string$default2 = AgentBusMapExtensionsKt.getString$default(o, HintConstants.AUTOFILL_HINT_NAME, null, 2, null);
        String stringOrNull = AgentBusMapExtensionsKt.getStringOrNull(o, "description");
        String stringOrNull2 = AgentBusMapExtensionsKt.getStringOrNull(o, "version");
        Object obj = o.get("tags");
        List list = obj instanceof List ? (List) obj : null;
        if (list != null) {
            arrayList = new ArrayList();
            for (Object obj2 : list) {
                String str = obj2 instanceof String ? (String) obj2 : null;
                if (str != null) {
                    arrayList.add(str);
                }
            }
        } else {
            arrayList = EmptyList.f4893a;
        }
        List list2 = arrayList;
        boolean z10 = AgentBusMapExtensionsKt.getBoolean(o, "isEnabled", true);
        boolean boolean$default = AgentBusMapExtensionsKt.getBoolean$default(o, "hasSkillMd", false, 2, null);
        InstallSource installSource = parseInstallSource(AgentBusMapExtensionsKt.getStringOrNull(o, AgentBusWakeContract.EXTRA_SOURCE));
        Object obj3 = o.get("modifiedAtMs");
        Number number = obj3 instanceof Number ? (Number) obj3 : null;
        Long lValueOf = number != null ? Long.valueOf(number.longValue()) : null;
        Map<String, Object> map = AgentBusMapExtensionsKt.getMap(o, "metadata");
        if (map == null) {
            map = kotlin.collections.a.M();
        }
        return new SkillSpec(string$default, string$default2, stringOrNull, stringOrNull2, list2, z10, boolean$default, installSource, lValueOf, map);
    }

    public final ToolSpec parseToolSpec(Map<String, ? extends Object> o) {
        List arrayList;
        k.f(o, "o");
        String string$default = AgentBusMapExtensionsKt.getString$default(o, "id", null, 2, null);
        String string$default2 = AgentBusMapExtensionsKt.getString$default(o, HintConstants.AUTOFILL_HINT_NAME, null, 2, null);
        String stringOrNull = AgentBusMapExtensionsKt.getStringOrNull(o, "description");
        String stringOrNull2 = AgentBusMapExtensionsKt.getStringOrNull(o, "version");
        Object obj = o.get("tags");
        List list = obj instanceof List ? (List) obj : null;
        if (list != null) {
            arrayList = new ArrayList();
            for (Object obj2 : list) {
                String str = obj2 instanceof String ? (String) obj2 : null;
                if (str != null) {
                    arrayList.add(str);
                }
            }
        } else {
            arrayList = EmptyList.f4893a;
        }
        List list2 = arrayList;
        boolean z10 = AgentBusMapExtensionsKt.getBoolean(o, "isEnabled", true);
        ToolType toolType = parseToolType(AgentBusMapExtensionsKt.getStringOrNull(o, "type"));
        String stringOrNull3 = AgentBusMapExtensionsKt.getStringOrNull(o, QueryAlgorithmBundle.KEY_CATEGORY);
        InstallSource installSource = parseInstallSource(AgentBusMapExtensionsKt.getStringOrNull(o, AgentBusWakeContract.EXTRA_SOURCE));
        Object obj3 = o.get("modifiedAtMs");
        Number number = obj3 instanceof Number ? (Number) obj3 : null;
        Long lValueOf = number != null ? Long.valueOf(number.longValue()) : null;
        Map<String, Object> map = AgentBusMapExtensionsKt.getMap(o, "metadata");
        if (map == null) {
            map = kotlin.collections.a.M();
        }
        return new ToolSpec(string$default, string$default2, stringOrNull, stringOrNull2, list2, z10, toolType, stringOrNull3, installSource, lValueOf, map);
    }

    public final ToolType parseToolType(String s5) {
        String upperCase;
        if (s5 != null) {
            upperCase = s5.toUpperCase(Locale.ROOT);
            k.e(upperCase, "toUpperCase(...)");
        } else {
            upperCase = null;
        }
        return k.b(upperCase, "CORE") ? ToolType.CORE : ToolType.INSTALLED;
    }

    public final Map<String, Object> skillFilterToMap(SkillFilter f) {
        k.f(f, "f");
        MapBuilder mapBuilder = new MapBuilder();
        Set<InstallSource> sources = f.getSources();
        if (sources != null) {
            Set<InstallSource> set = sources;
            ArrayList arrayList = new ArrayList(w.c0(set, 10));
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                arrayList.add(((InstallSource) it.next()).name());
            }
            mapBuilder.put("sources", arrayList);
        }
        Set<String> tagsAny = f.getTagsAny();
        if (tagsAny != null) {
            mapBuilder.put("tagsAny", v.f1(tagsAny));
        }
        Set<String> tagsAll = f.getTagsAll();
        if (tagsAll != null) {
            mapBuilder.put("tagsAll", v.f1(tagsAll));
        }
        Boolean enabled = f.getEnabled();
        if (enabled != null) {
            mapBuilder.put("enabled", enabled);
        }
        Boolean hasSkillMd = f.getHasSkillMd();
        if (hasSkillMd != null) {
            mapBuilder.put("hasSkillMd", hasSkillMd);
        }
        Long modifiedOnOrAfterMs = f.getModifiedOnOrAfterMs();
        if (modifiedOnOrAfterMs != null) {
            mapBuilder.put("modifiedOnOrAfterMs", Long.valueOf(modifiedOnOrAfterMs.longValue()));
        }
        return mapBuilder.b();
    }

    public final Map<String, Object> toolFilterToMap(ToolFilter f) {
        k.f(f, "f");
        MapBuilder mapBuilder = new MapBuilder();
        Set<ToolType> types = f.getTypes();
        if (types != null) {
            Set<ToolType> set = types;
            ArrayList arrayList = new ArrayList(w.c0(set, 10));
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                arrayList.add(((ToolType) it.next()).name());
            }
            mapBuilder.put("types", arrayList);
        }
        Set<String> tagsAny = f.getTagsAny();
        if (tagsAny != null) {
            mapBuilder.put("tagsAny", v.f1(tagsAny));
        }
        Boolean enabled = f.getEnabled();
        if (enabled != null) {
            mapBuilder.put("enabled", enabled);
        }
        return mapBuilder.b();
    }
}
