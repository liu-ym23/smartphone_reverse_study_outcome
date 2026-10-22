package com.obric.capabilitykit.sync;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityIdData {
    private final String id;
    private final long lastModifyTime;
    private final int type;

    public EntityIdData(String r2, int r3, long r4) {
        o.e(r2, DbHelper.COL_ID);
        this.id = r2;
        this.type = r3;
        this.lastModifyTime = r4;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, EntityIdData.class) == false) goto L10;
        EntityIdData r5 = (EntityIdData) ZeusTransformUtils.preCheckCast(r4, EntityIdData.class, "com.obric.aiagent.plugin");
        if (o.a(r5.id, this.id) == true) goto L7;
        return false;
    L7:
        if (r5.type != this.type) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final String getId() {
        return this.id;
    }

    public final long getLastModifyTime() {
        return this.lastModifyTime;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + Integer.hashCode(this.type);
    }
}
