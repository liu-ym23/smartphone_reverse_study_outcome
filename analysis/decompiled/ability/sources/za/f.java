package za;

import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.TaskConfig;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f7014a;
    public final Integer b;
    public final j c;
    public final TaskConfig d;
    public final List e;
    public final LinkedHashMap f;
    public final String g;

    public f(String task, Integer num, j jVar, TaskConfig taskConfig, LinkedHashMap linkedHashMap, String str) {
        EmptyList preOpenAppNames = EmptyList.f4893a;
        k.f(task, "task");
        k.f(preOpenAppNames, "preOpenAppNames");
        this.f7014a = task;
        this.b = num;
        this.c = jVar;
        this.d = taskConfig;
        this.e = preOpenAppNames;
        this.f = linkedHashMap;
        this.g = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return k.b(this.f7014a, fVar.f7014a) && k.b(this.b, fVar.b) && k.b(this.c, fVar.c) && k.b(this.d, fVar.d) && k.b(this.e, fVar.e) && k.b(this.f, fVar.f) && k.b(this.g, fVar.g);
    }

    public final int hashCode() {
        int iHashCode = this.f7014a.hashCode() * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 29791;
        j jVar = this.c;
        int iHashCode3 = (iHashCode2 + (jVar == null ? 0 : jVar.hashCode())) * 31;
        TaskConfig taskConfig = this.d;
        int iE = androidx.appfunctions.metadata.a.e(this.e, (iHashCode3 + (taskConfig == null ? 0 : taskConfig.hashCode())) * 31, 31);
        LinkedHashMap linkedHashMap = this.f;
        int iHashCode4 = (iE + (linkedHashMap == null ? 0 : linkedHashMap.hashCode())) * 31;
        String str = this.g;
        return Boolean.hashCode(false) + ((iHashCode4 + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SessionParam(task=");
        sb.append(this.f7014a);
        sb.append(", displayId=");
        sb.append(this.b);
        sb.append(", node=null, slotMap=null, taskTreeContext=");
        sb.append(this.c);
        sb.append(", taskConfig=");
        sb.append(this.d);
        sb.append(", preOpenAppNames=");
        sb.append(this.e);
        sb.append(", meta=");
        sb.append(this.f);
        sb.append(", openApp=");
        return B7.a.q(sb, this.g, ", enableExperience=false)");
    }
}
