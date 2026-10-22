package com.obric.capabilitykit.version;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityUpdateVersionParams {
    public static final a Companion = null;
    public static final String RESULT_KEY = "update_index_result";

    @SerializedName("oldEntityVersions")
    private Map<Integer, EntityVersionData> oldEntityVersions;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EntityUpdateVersionParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public EntityUpdateVersionParams(Map<Integer, EntityVersionData> r3) {
        Map<Integer, EntityVersionData> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r4, "oldEntityVersions");
        this.oldEntityVersions = r4;
    }

    public /* synthetic */ EntityUpdateVersionParams(Map r2, int r3, h r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = new LinkedHashMap();
    L5:
        this(r5);
    }

    public final Map<Integer, EntityVersionData> getOldEntityVersions() {
        return this.oldEntityVersions;
    }

    public final void setOldEntityVersions(Map<Integer, EntityVersionData> r3) {
        Map<Integer, EntityVersionData> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.oldEntityVersions = r4;
    }
}
