package com.stepos.taskrobot.dictionary.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/taskrobot/dictionary/model/RedirectGroup;", "", TypedValues.AttributesType.S_TARGET, "", "apps", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/List;)V", "getTarget", "()Ljava/lang/String;", "getApps", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "dictionary_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RedirectGroup {
    private final List<String> apps;
    private final String target;

    public RedirectGroup() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RedirectGroup copy$default(RedirectGroup redirectGroup, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = redirectGroup.target;
        }
        if ((i & 2) != 0) {
            list = redirectGroup.apps;
        }
        return redirectGroup.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTarget() {
        return this.target;
    }

    public final List<String> component2() {
        return this.apps;
    }

    public final RedirectGroup copy(String target, List<String> apps) {
        k.f(target, "target");
        k.f(apps, "apps");
        return new RedirectGroup(target, apps);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RedirectGroup)) {
            return false;
        }
        RedirectGroup redirectGroup = (RedirectGroup) other;
        return k.b(this.target, redirectGroup.target) && k.b(this.apps, redirectGroup.apps);
    }

    public final List<String> getApps() {
        return this.apps;
    }

    public final String getTarget() {
        return this.target;
    }

    public int hashCode() {
        return this.apps.hashCode() + (this.target.hashCode() * 31);
    }

    public String toString() {
        return "RedirectGroup(target=" + this.target + ", apps=" + this.apps + ")";
    }

    public RedirectGroup(String target, List<String> apps) {
        k.f(target, "target");
        k.f(apps, "apps");
        this.target = target;
        this.apps = apps;
    }

    public RedirectGroup(String str, List list, int i, e eVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? EmptyList.f4893a : list);
    }
}
