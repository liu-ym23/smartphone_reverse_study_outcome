package com.obric.capabilitykit.version;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006R*\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/version/EntityUpdateVersionParams;", "", "oldEntityVersions", "", "", "Lcom/obric/capabilitykit/version/EntityVersionData;", "(Ljava/util/Map;)V", "getOldEntityVersions", "()Ljava/util/Map;", "setOldEntityVersions", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityUpdateVersionParams {
    public static final a Companion = null;
    public static final String RESULT_KEY = "update_index_result";

    @SerializedName("oldEntityVersions")
    private Map<Integer, EntityVersionData> oldEntityVersions;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/capabilitykit/version/EntityUpdateVersionParams$Companion;", "", "()V", "RESULT_KEY", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
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

    public EntityUpdateVersionParams(Map<Integer, EntityVersionData> r2) {
        Intrinsics.checkNotNullParameter(r2, "oldEntityVersions");
        this.oldEntityVersions = r2;
    }

    public /* synthetic */ EntityUpdateVersionParams(Map r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new LinkedHashMap();
    L5:
        this(r1);
    }

    public final Map<Integer, EntityVersionData> getOldEntityVersions() {
        return this.oldEntityVersions;
    }

    public final void setOldEntityVersions(Map<Integer, EntityVersionData> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.oldEntityVersions = r2;
    }
}
