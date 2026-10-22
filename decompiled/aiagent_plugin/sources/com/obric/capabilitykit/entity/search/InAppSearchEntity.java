package com.obric.capabilitykit.entity.search;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class InAppSearchEntity {
    private final AppEntity appEntity;
    private final List<InAppSearchEntityParam> params;

    public InAppSearchEntity(AppEntity r3, List<InAppSearchEntityParam> r4) {
        List<InAppSearchEntityParam> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "appEntity");
        o.e(r5, "params");
        this.appEntity = r3;
        this.params = r5;
    }

    public static /* synthetic */ InAppSearchEntity copy$default(InAppSearchEntity r1, AppEntity r2, List r3, int r4, Object r5) {
        List<InAppSearchEntityParam> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.appEntity;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.params;
    L9:
        return r1.copy(r2, r6);
    }

    public final AppEntity component1() {
        return this.appEntity;
    }

    public final List<InAppSearchEntityParam> component2() {
        return this.params;
    }

    public final InAppSearchEntity copy(AppEntity r2, List<InAppSearchEntityParam> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r2, "appEntity");
        o.e(r1, "params");
        return new InAppSearchEntity(r2, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, InAppSearchEntity.class) == true) goto L8;
        return false;
    L8:
        InAppSearchEntity r6 = (InAppSearchEntity) ZeusTransformUtils.preCheckCast(r5, InAppSearchEntity.class, "com.obric.aiagent.plugin");
        if (o.a(this.appEntity, r6.appEntity) == true) goto L12;
        return false;
    L12:
        if (o.a(this.params, r6.params) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final AppEntity getAppEntity() {
        return this.appEntity;
    }

    public final List<InAppSearchEntityParam> getParams() {
        return this.params;
    }

    public int hashCode() {
        return (this.appEntity.hashCode() * 31) + this.params.hashCode();
    }

    public String toString() {
        return "InAppSearchEntity(appEntity=" + this.appEntity + ", params=" + this.params + ')';
    }
}
