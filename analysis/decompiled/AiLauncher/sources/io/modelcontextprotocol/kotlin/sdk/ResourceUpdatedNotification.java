package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.modelcontextprotocol.kotlin.sdk.Method;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0002/.B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0007\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ$\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u001aJ\u0010\u0010 \u001a\u00020\tHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010'\u001a\u0004\b(\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010)\u001a\u0004\b*\u0010\u001cR\u001a\u0010\f\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010+\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ResourceUpdatedNotification;", "Lio/modelcontextprotocol/kotlin/sdk/ServerNotification;", "Lio/modelcontextprotocol/kotlin/sdk/WithMeta;", "", "uri", "Lqb/D;", "_meta", "<init>", "(Ljava/lang/String;Lqb/D;)V", "", "seen0", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "method", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/Method;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/ResourceUpdatedNotification;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()Lqb/D;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/ResourceUpdatedNotification;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUri", "Lqb/D;", "get_meta", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "getMethod", "()Lio/modelcontextprotocol/kotlin/sdk/Method;", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class ResourceUpdatedNotification implements ServerNotification, WithMeta {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final qb.D _meta;
    private final Method method;
    private final String uri;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ResourceUpdatedNotification$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/ResourceUpdatedNotification;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ResourceUpdatedNotification> serializer() {
            return ResourceUpdatedNotification$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ ResourceUpdatedNotification(int i10, String str, qb.D d10, Method method, T0 t02) {
        if (1 != (i10 & 1)) {
            E0.a(i10, 1, ResourceUpdatedNotification$$serializer.INSTANCE.getDescriptor());
        }
        this.uri = str;
        if ((i10 & 2) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d10;
        }
        if ((i10 & 4) == 0) {
            this.method = Method.Defined.NotificationsResourcesUpdated;
        } else {
            this.method = method;
        }
    }

    public static /* synthetic */ ResourceUpdatedNotification copy$default(ResourceUpdatedNotification resourceUpdatedNotification, String str, qb.D d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = resourceUpdatedNotification.uri;
        }
        if ((i10 & 2) != 0) {
            d10 = resourceUpdatedNotification._meta;
        }
        return resourceUpdatedNotification.copy(str, d10);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(ResourceUpdatedNotification self, ob.d output, SerialDescriptor serialDesc) {
        output.w(serialDesc, 0, self.uri);
        if (output.y(serialDesc, 1) || !kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
            output.x(serialDesc, 1, qb.E.f38623a, self.get_meta());
        }
        if (!output.y(serialDesc, 2) && self.getMethod() == Method.Defined.NotificationsResourcesUpdated) {
            return;
        }
        output.x(serialDesc, 2, RequestMethodSerializer.INSTANCE, self.getMethod());
    }

    /* renamed from: component1, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* renamed from: component2, reason: from getter */
    public final qb.D get_meta() {
        return this._meta;
    }

    public final ResourceUpdatedNotification copy(String uri, qb.D _meta) {
        kotlin.jvm.internal.p.i(uri, "uri");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        return new ResourceUpdatedNotification(uri, _meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResourceUpdatedNotification)) {
            return false;
        }
        ResourceUpdatedNotification resourceUpdatedNotification = (ResourceUpdatedNotification) other;
        return kotlin.jvm.internal.p.d(this.uri, resourceUpdatedNotification.uri) && kotlin.jvm.internal.p.d(this._meta, resourceUpdatedNotification._meta);
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.Notification
    public Method getMethod() {
        return this.method;
    }

    public final String getUri() {
        return this.uri;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
    public qb.D get_meta() {
        return this._meta;
    }

    public int hashCode() {
        return (this.uri.hashCode() * 31) + this._meta.hashCode();
    }

    public String toString() {
        return "ResourceUpdatedNotification(uri=" + this.uri + ", _meta=" + this._meta + ')';
    }

    public ResourceUpdatedNotification(String uri, qb.D _meta) {
        kotlin.jvm.internal.p.i(uri, "uri");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this.uri = uri;
        this._meta = _meta;
        this.method = Method.Defined.NotificationsResourcesUpdated;
    }

    public /* synthetic */ ResourceUpdatedNotification(String str, qb.D d10, int i10, kotlin.jvm.internal.i iVar) {
        this(str, (i10 & 2) != 0 ? Types_utilKt.getEmptyJsonObject() : d10);
    }
}
