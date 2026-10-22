package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.C5100i;
import pb.E0;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u00020/BA\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001cJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001cJL\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u001aJ\u0010\u0010#\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010&\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010\u001cR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010*\u001a\u0004\b,\u0010\u001cR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b-\u0010\u001cR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010*\u001a\u0004\b.\u0010\u001c¨\u00061"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ToolAnnotations;", "", "", "title", "", "readOnlyHint", "destructiveHint", "idempotentHint", "openWorldHint", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/ToolAnnotations;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()Ljava/lang/Boolean;", "component3", "component4", "component5", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lio/modelcontextprotocol/kotlin/sdk/ToolAnnotations;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Ljava/lang/Boolean;", "getReadOnlyHint", "getDestructiveHint", "getIdempotentHint", "getOpenWorldHint", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class ToolAnnotations {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean destructiveHint;
    private final Boolean idempotentHint;
    private final Boolean openWorldHint;
    private final Boolean readOnlyHint;
    private final String title;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ToolAnnotations$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/ToolAnnotations;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ToolAnnotations> serializer() {
            return ToolAnnotations$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ ToolAnnotations(int i10, String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, T0 t02) {
        if (1 != (i10 & 1)) {
            E0.a(i10, 1, ToolAnnotations$$serializer.INSTANCE.getDescriptor());
        }
        this.title = str;
        if ((i10 & 2) == 0) {
            this.readOnlyHint = Boolean.FALSE;
        } else {
            this.readOnlyHint = bool;
        }
        if ((i10 & 4) == 0) {
            this.destructiveHint = Boolean.TRUE;
        } else {
            this.destructiveHint = bool2;
        }
        if ((i10 & 8) == 0) {
            this.idempotentHint = Boolean.FALSE;
        } else {
            this.idempotentHint = bool3;
        }
        if ((i10 & 16) == 0) {
            this.openWorldHint = Boolean.TRUE;
        } else {
            this.openWorldHint = bool4;
        }
    }

    public static /* synthetic */ ToolAnnotations copy$default(ToolAnnotations toolAnnotations, String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = toolAnnotations.title;
        }
        if ((i10 & 2) != 0) {
            bool = toolAnnotations.readOnlyHint;
        }
        if ((i10 & 4) != 0) {
            bool2 = toolAnnotations.destructiveHint;
        }
        if ((i10 & 8) != 0) {
            bool3 = toolAnnotations.idempotentHint;
        }
        if ((i10 & 16) != 0) {
            bool4 = toolAnnotations.openWorldHint;
        }
        Boolean bool5 = bool4;
        Boolean bool6 = bool2;
        return toolAnnotations.copy(str, bool, bool6, bool3, bool5);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(ToolAnnotations self, ob.d output, SerialDescriptor serialDesc) {
        output.k(serialDesc, 0, Y0.f38329a, self.title);
        if (output.y(serialDesc, 1) || !kotlin.jvm.internal.p.d(self.readOnlyHint, Boolean.FALSE)) {
            output.k(serialDesc, 1, C5100i.f38363a, self.readOnlyHint);
        }
        if (output.y(serialDesc, 2) || !kotlin.jvm.internal.p.d(self.destructiveHint, Boolean.TRUE)) {
            output.k(serialDesc, 2, C5100i.f38363a, self.destructiveHint);
        }
        if (output.y(serialDesc, 3) || !kotlin.jvm.internal.p.d(self.idempotentHint, Boolean.FALSE)) {
            output.k(serialDesc, 3, C5100i.f38363a, self.idempotentHint);
        }
        if (!output.y(serialDesc, 4) && kotlin.jvm.internal.p.d(self.openWorldHint, Boolean.TRUE)) {
            return;
        }
        output.k(serialDesc, 4, C5100i.f38363a, self.openWorldHint);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getReadOnlyHint() {
        return this.readOnlyHint;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getDestructiveHint() {
        return this.destructiveHint;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getIdempotentHint() {
        return this.idempotentHint;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getOpenWorldHint() {
        return this.openWorldHint;
    }

    public final ToolAnnotations copy(String title, Boolean readOnlyHint, Boolean destructiveHint, Boolean idempotentHint, Boolean openWorldHint) {
        return new ToolAnnotations(title, readOnlyHint, destructiveHint, idempotentHint, openWorldHint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolAnnotations)) {
            return false;
        }
        ToolAnnotations toolAnnotations = (ToolAnnotations) other;
        return kotlin.jvm.internal.p.d(this.title, toolAnnotations.title) && kotlin.jvm.internal.p.d(this.readOnlyHint, toolAnnotations.readOnlyHint) && kotlin.jvm.internal.p.d(this.destructiveHint, toolAnnotations.destructiveHint) && kotlin.jvm.internal.p.d(this.idempotentHint, toolAnnotations.idempotentHint) && kotlin.jvm.internal.p.d(this.openWorldHint, toolAnnotations.openWorldHint);
    }

    public final Boolean getDestructiveHint() {
        return this.destructiveHint;
    }

    public final Boolean getIdempotentHint() {
        return this.idempotentHint;
    }

    public final Boolean getOpenWorldHint() {
        return this.openWorldHint;
    }

    public final Boolean getReadOnlyHint() {
        return this.readOnlyHint;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.readOnlyHint;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.destructiveHint;
        int iHashCode3 = (iHashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.idempotentHint;
        int iHashCode4 = (iHashCode3 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.openWorldHint;
        return iHashCode4 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        return "ToolAnnotations(title=" + this.title + ", readOnlyHint=" + this.readOnlyHint + ", destructiveHint=" + this.destructiveHint + ", idempotentHint=" + this.idempotentHint + ", openWorldHint=" + this.openWorldHint + ')';
    }

    public ToolAnnotations(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        this.title = str;
        this.readOnlyHint = bool;
        this.destructiveHint = bool2;
        this.idempotentHint = bool3;
        this.openWorldHint = bool4;
    }

    public /* synthetic */ ToolAnnotations(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, int i10, kotlin.jvm.internal.i iVar) {
        this(str, (i10 & 2) != 0 ? Boolean.FALSE : bool, (i10 & 4) != 0 ? Boolean.TRUE : bool2, (i10 & 8) != 0 ? Boolean.FALSE : bool3, (i10 & 16) != 0 ? Boolean.TRUE : bool4);
    }
}
