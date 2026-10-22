package com.stepos.ame.sdk;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/stepos/ame/sdk/InsertArgs;", "", "vector", "", "metadata", "", "", "<init>", "([FLjava/util/Map;)V", "getVector", "()[F", "getMetadata", "()Ljava/util/Map;", "validate", "Lcom/stepos/ame/sdk/AMEError;", "equals", "", "other", "hashCode", "", "Builder", "Companion", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InsertArgs {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<String, Object> metadata;
    private final float[] vector;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00002\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/ame/sdk/InsertArgs$Builder;", "", "vector", "", "<init>", "([F)V", "metadata", "", "", "meta", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/stepos/ame/sdk/InsertArgs;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        private Map<String, ? extends Object> metadata;
        private final float[] vector;

        public Builder(float[] vector) {
            p.i(vector, "vector");
            this.vector = vector;
        }

        public final InsertArgs build() {
            return new InsertArgs(this.vector, this.metadata, null);
        }

        public final Builder metadata(Map<String, ? extends Object> meta) {
            this.metadata = meta;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ame/sdk/InsertArgs$Companion;", "", "<init>", "()V", "builder", "Lcom/stepos/ame/sdk/InsertArgs$Builder;", "vector", "", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final Builder builder(float[] vector) {
            p.i(vector, "vector");
            return new Builder(vector);
        }

        private Companion() {
        }
    }

    public /* synthetic */ InsertArgs(float[] fArr, Map map, i iVar) {
        this(fArr, map);
    }

    public static final Builder builder(float[] fArr) {
        return INSTANCE.builder(fArr);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InsertArgs)) {
            return false;
        }
        InsertArgs insertArgs = (InsertArgs) other;
        return Arrays.equals(this.vector, insertArgs.vector) && p.d(this.metadata, insertArgs.metadata);
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final float[] getVector() {
        return this.vector;
    }

    public int hashCode() {
        int iHashCode = Arrays.hashCode(this.vector) * 31;
        Map<String, Object> map = this.metadata;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public final AMEError validate() {
        if (this.vector.length == 0) {
            return AMEError.ARGS_EMPTY_INPUT;
        }
        return null;
    }

    private InsertArgs(float[] fArr, Map<String, ? extends Object> map) {
        this.vector = fArr;
        this.metadata = map;
    }
}
