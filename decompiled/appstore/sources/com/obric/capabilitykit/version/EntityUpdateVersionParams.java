package com.obric.capabilitykit.version;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006R*\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/version/EntityUpdateVersionParams;", "", "oldEntityVersions", "", "", "Lcom/obric/capabilitykit/version/EntityVersionData;", "(Ljava/util/Map;)V", "getOldEntityVersions", "()Ljava/util/Map;", "setOldEntityVersions", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityUpdateVersionParams {

    @NotNull
    public static final a Companion = null;

    @NotNull
    public static final String RESULT_KEY = "update_index_result";

    @SerializedName("oldEntityVersions")
    @NotNull
    private Map<Integer, EntityVersionData> oldEntityVersions;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
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

    @NotNull
    public final Map<Integer, EntityVersionData> getOldEntityVersions() {
        return this.oldEntityVersions;
    }

    public final void setOldEntityVersions(@NotNull Map<Integer, EntityVersionData> r10) {
        q.g(r10, "<set-?>");
        this.oldEntityVersions = r10;
    }

    public EntityUpdateVersionParams(@NotNull Map<Integer, EntityVersionData> r10) {
        q.g(r10, "oldEntityVersions");
        this.oldEntityVersions = r10;
    }

    public /* synthetic */ EntityUpdateVersionParams(Map r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = new LinkedHashMap();
    L5:
        this(r10);
    }
}
