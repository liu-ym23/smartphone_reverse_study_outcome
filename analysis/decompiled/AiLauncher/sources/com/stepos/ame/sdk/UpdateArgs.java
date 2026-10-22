package com.stepos.ame.sdk;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/stepos/ame/sdk/UpdateArgs;", "", "id", "", "newVector", "", "metadata", "", "", "<init>", "(J[FLjava/util/Map;)V", "getId", "()J", "getNewVector", "()[F", "getMetadata", "()Ljava/util/Map;", "validate", "Lcom/stepos/ame/sdk/AMEError;", "equals", "", "other", "hashCode", "", "Builder", "Companion", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateArgs {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long id;
    private final Map<String, Object> metadata;
    private final float[] newVector;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00002\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tJ\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stepos/ame/sdk/UpdateArgs$Builder;", "", "id", "", "newVector", "", "<init>", "(J[F)V", "metadata", "", "", "meta", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/stepos/ame/sdk/UpdateArgs;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        private final long id;
        private Map<String, ? extends Object> metadata;
        private final float[] newVector;

        public Builder(long j10, float[] newVector) {
            p.i(newVector, "newVector");
            this.id = j10;
            this.newVector = newVector;
        }

        public final UpdateArgs build() {
            return new UpdateArgs(this.id, this.newVector, this.metadata, null);
        }

        public final Builder metadata(Map<String, ? extends Object> meta) {
            this.metadata = meta;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/stepos/ame/sdk/UpdateArgs$Companion;", "", "<init>", "()V", "builder", "Lcom/stepos/ame/sdk/UpdateArgs$Builder;", "id", "", "newVector", "", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final Builder builder(long id, float[] newVector) {
            p.i(newVector, "newVector");
            return new Builder(id, newVector);
        }

        private Companion() {
        }
    }

    public /* synthetic */ UpdateArgs(long j10, float[] fArr, Map map, i iVar) {
        this(j10, fArr, map);
    }

    public static final Builder builder(long j10, float[] fArr) {
        return INSTANCE.builder(j10, fArr);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateArgs)) {
            return false;
        }
        UpdateArgs updateArgs = (UpdateArgs) other;
        return this.id == updateArgs.id && Arrays.equals(this.newVector, updateArgs.newVector) && p.d(this.metadata, updateArgs.metadata);
    }

    public final long getId() {
        return this.id;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final float[] getNewVector() {
        return this.newVector;
    }

    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.id) * 31) + Arrays.hashCode(this.newVector)) * 31;
        Map<String, Object> map = this.metadata;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public final AMEError validate() {
        if (this.newVector.length == 0) {
            return AMEError.ARGS_EMPTY_INPUT;
        }
        return null;
    }

    private UpdateArgs(long j10, float[] fArr, Map<String, ? extends Object> map) {
        this.id = j10;
        this.newVector = fArr;
        this.metadata = map;
    }
}
