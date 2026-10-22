package com.stepos.taskrobot.taskmemory.bean;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0011J&\u0010\u0017\u001a\u00020\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0011¨\u0006$"}, d2 = {"Lcom/stepos/taskrobot/taskmemory/bean/DurationData;", "", "", "", "", "durations", AppAgent.CONSTRUCT, "(Ljava/util/Map;)V", "key", TypedValues.TransitionType.S_DURATION, "LC7/r;", "addDuration", "(Ljava/lang/String;J)V", "getDuration", "(Ljava/lang/String;)Ljava/lang/Long;", "", "getAllDurations", "()Ljava/util/Map;", "removeDuration", "(Ljava/lang/String;)V", "clearDurations", "()V", "component1", "copy", "(Ljava/util/Map;)Lcom/stepos/taskrobot/taskmemory/bean/DurationData;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getDurations", "taskmemory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DurationData {
    private final Map<String, Long> durations;

    /* JADX WARN: Multi-variable type inference failed */
    public DurationData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DurationData copy$default(DurationData durationData, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = durationData.durations;
        }
        return durationData.copy(map);
    }

    public final void addDuration(String key, long duration) {
        k.f(key, "key");
        this.durations.put(key, Long.valueOf(duration));
    }

    public final void clearDurations() {
        this.durations.clear();
    }

    public final Map<String, Long> component1() {
        return this.durations;
    }

    public final DurationData copy(Map<String, Long> durations) {
        k.f(durations, "durations");
        return new DurationData(durations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DurationData) && k.b(this.durations, ((DurationData) other).durations);
    }

    public final Map<String, Long> getAllDurations() {
        return a.Y(this.durations);
    }

    public final Long getDuration(String key) {
        k.f(key, "key");
        return this.durations.get(key);
    }

    public final Map<String, Long> getDurations() {
        return this.durations;
    }

    public int hashCode() {
        return this.durations.hashCode();
    }

    public final void removeDuration(String key) {
        k.f(key, "key");
        this.durations.remove(key);
    }

    public String toString() {
        return "DurationData(durations=" + this.durations + ")";
    }

    public DurationData(Map<String, Long> durations) {
        k.f(durations, "durations");
        this.durations = durations;
    }

    public /* synthetic */ DurationData(Map map, int i, e eVar) {
        this((i & 1) != 0 ? new LinkedHashMap() : map);
    }
}
