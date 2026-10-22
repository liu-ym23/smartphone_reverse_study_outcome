package com.obric.autoaction.app.launcherpage.discovery.a;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DiscoveryModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("type")
    private final Integer f23603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("conditions")
    private final List<g> f23604b;

    /* JADX WARN: Multi-variable type inference failed */
    public h() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f23603a, r6.f23603a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f23604b, r6.f23604b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.f23603a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<g> r4 = this.f23604b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "InstructionConditionGroup(type=" + this.f23603a + ", conditions=" + this.f23604b + ')';
    }

    public h(Integer r3, List<g> r4) {
        List<g> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.f23603a = r3;
        this.f23604b = r5;
    }

    public /* synthetic */ h(Integer r2, List r3, int r4, d.h.b.h r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = null;
    L8:
        this(r2, r6);
    }

    public final Integer getType() {
        return this.f23603a;
    }

    public final ConditionGroup a(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "context");
        Integer r0 = this.f23603a;
        int r2 = i.f23606b.a();
        if (r0 != null) goto L6;
    L8:
        int r3 = i.f23607c.a();
        if (r0 != null) goto L12;
    L14:
        String r1 = null;
    L15:
        if (r1 != null) goto L17;
        return null;
    L17:
        List<g> r5 = this.f23604b;
        if (r5 == null) goto L27;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r8.iterator();
    L21:
        if (r9.hasNext() == false) goto L26;
        Condition r10 = ((g) ZeusTransformUtils.preCheckCast(r9.next(), g.class, "com.obric.aiagent.plugin")).a(r7);
        if (r10 == null) goto L21;
        r4.add(r10);
        goto L21
    L26:
        return new ConditionGroup(r1, new ArrayList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")));
    L27:
        return null;
    L12:
        if (r0.intValue() != r3) goto L14;
        r1 = "or";
        goto L15
    L6:
        if (r0.intValue() != r2) goto L8;
        r1 = "and";
        goto L15
    }
}
