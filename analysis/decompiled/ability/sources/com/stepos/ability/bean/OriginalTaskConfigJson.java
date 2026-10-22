package com.stepos.ability.bean;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import j9.m;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/ability/bean/OriginalTaskConfigJson;", "", AppAgent.CONSTRUCT, "()V", "gson", "Lcom/google/gson/Gson;", "fromJson", "Lcom/stepos/ability/bean/OriginalTaskConfig;", "json", "", "toJson", "config", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class OriginalTaskConfigJson {
    public static final OriginalTaskConfigJson INSTANCE = new OriginalTaskConfigJson();
    private static final Gson gson = new Gson();

    private OriginalTaskConfigJson() {
    }

    public final OriginalTaskConfig fromJson(String json) {
        Object objA;
        if (json != null) {
            try {
                objA = m.s0(json) ? null : (OriginalTaskConfig) gson.fromJson(json, OriginalTaskConfig.class);
            } catch (Throwable th) {
                objA = b.a(th);
            }
        }
        return (OriginalTaskConfig) (objA instanceof Result.Failure ? null : objA);
    }

    public final String toJson(OriginalTaskConfig config) {
        k.f(config, "config");
        String json = gson.toJson(config);
        k.e(json, "toJson(...)");
        return json;
    }
}
