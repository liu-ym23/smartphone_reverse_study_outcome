package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002'(B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\fJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0017R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010\u001b¨\u0006)"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/EmbeddedResource;", "Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContent;", "Lio/modelcontextprotocol/kotlin/sdk/ResourceContents;", "resource", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/ResourceContents;)V", "", "seen0", "", "type", "Lpb/T0;", "serializationConstructorMarker", "(ILio/modelcontextprotocol/kotlin/sdk/ResourceContents;Ljava/lang/String;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/EmbeddedResource;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Lio/modelcontextprotocol/kotlin/sdk/ResourceContents;", ChatTracker.CLICK_COPY, "(Lio/modelcontextprotocol/kotlin/sdk/ResourceContents;)Lio/modelcontextprotocol/kotlin/sdk/EmbeddedResource;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/modelcontextprotocol/kotlin/sdk/ResourceContents;", "getResource", "Ljava/lang/String;", "getType", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class EmbeddedResource implements PromptMessageContent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TYPE = "resource";
    private final ResourceContents resource;
    private final String type;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/EmbeddedResource$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/EmbeddedResource;", "serializer", "()Lkotlinx/serialization/KSerializer;", "", "TYPE", "Ljava/lang/String;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final KSerializer<EmbeddedResource> serializer() {
            return EmbeddedResource$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ EmbeddedResource(int i10, ResourceContents resourceContents, String str, T0 t02) {
        if (1 != (i10 & 1)) {
            E0.a(i10, 1, EmbeddedResource$$serializer.INSTANCE.getDescriptor());
        }
        this.resource = resourceContents;
        if ((i10 & 2) == 0) {
            this.type = "resource";
        } else {
            this.type = str;
        }
    }

    public static /* synthetic */ EmbeddedResource copy$default(EmbeddedResource embeddedResource, ResourceContents resourceContents, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            resourceContents = embeddedResource.resource;
        }
        return embeddedResource.copy(resourceContents);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(EmbeddedResource self, ob.d output, SerialDescriptor serialDesc) {
        output.x(serialDesc, 0, ResourceContentsPolymorphicSerializer.INSTANCE, self.resource);
        if (!output.y(serialDesc, 1) && kotlin.jvm.internal.p.d(self.getType(), "resource")) {
            return;
        }
        output.w(serialDesc, 1, self.getType());
    }

    /* renamed from: component1, reason: from getter */
    public final ResourceContents getResource() {
        return this.resource;
    }

    public final EmbeddedResource copy(ResourceContents resource) {
        kotlin.jvm.internal.p.i(resource, "resource");
        return new EmbeddedResource(resource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof EmbeddedResource) && kotlin.jvm.internal.p.d(this.resource, ((EmbeddedResource) other).resource);
    }

    public final ResourceContents getResource() {
        return this.resource;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.PromptMessageContent
    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.resource.hashCode();
    }

    public String toString() {
        return "EmbeddedResource(resource=" + this.resource + ')';
    }

    public EmbeddedResource(ResourceContents resource) {
        kotlin.jvm.internal.p.i(resource, "resource");
        this.resource = resource;
        this.type = "resource";
    }
}
