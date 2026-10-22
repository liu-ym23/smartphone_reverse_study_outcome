package com.obric.capabilitykit.search;

import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoScore {
    private String entityId;
    private float score;

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoScore() {
        this(null, 0.0f, 3, 0 == true ? 1 : 0);
    }

    public PhotoScore(String r2, float r3) {
        o.e(r2, "entityId");
        this.entityId = r2;
        this.score = r3;
    }

    public /* synthetic */ PhotoScore(String r1, float r2, int r3, h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 0.0f;
    L8:
        this(r1, r2);
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final float getScore() {
        return this.score;
    }

    public final void setEntityId(String r2) {
        o.e(r2, "<set-?>");
        this.entityId = r2;
    }

    public final void setScore(float r1) {
        this.score = r1;
    }
}
