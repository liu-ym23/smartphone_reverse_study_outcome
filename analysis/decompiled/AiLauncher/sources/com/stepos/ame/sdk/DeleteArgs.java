package com.stepos.ame.sdk;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0002\u000f\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/ame/sdk/DeleteArgs;", "", "id", "", "<init>", "(J)V", "getId", "()J", "validate", "Lcom/stepos/ame/sdk/AMEError;", "equals", "", "other", "hashCode", "", "Builder", "Companion", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeleteArgs {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long id;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stepos/ame/sdk/DeleteArgs$Builder;", "", "id", "", "<init>", "(J)V", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/stepos/ame/sdk/DeleteArgs;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        private final long id;

        public Builder(long j10) {
            this.id = j10;
        }

        public final DeleteArgs build() {
            return new DeleteArgs(this.id, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ame/sdk/DeleteArgs$Companion;", "", "<init>", "()V", "builder", "Lcom/stepos/ame/sdk/DeleteArgs$Builder;", "id", "", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final Builder builder(long id) {
            return new Builder(id);
        }

        private Companion() {
        }
    }

    public /* synthetic */ DeleteArgs(long j10, i iVar) {
        this(j10);
    }

    public static final Builder builder(long j10) {
        return INSTANCE.builder(j10);
    }

    public boolean equals(Object other) {
        return (other instanceof DeleteArgs) && this.id == ((DeleteArgs) other).id;
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        return Long.hashCode(this.id);
    }

    public final AMEError validate() {
        return null;
    }

    private DeleteArgs(long j10) {
        this.id = j10;
    }
}
