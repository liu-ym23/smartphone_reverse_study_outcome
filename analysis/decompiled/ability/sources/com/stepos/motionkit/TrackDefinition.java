package com.stepos.motionkit;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/stepos/motionkit/TrackDefinition;", "", "uniformName", "", "type", "Lcom/stepos/motionkit/TrackType;", "component", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lcom/stepos/motionkit/TrackType;I)V", "getUniformName", "()Ljava/lang/String;", "getType", "()Lcom/stepos/motionkit/TrackType;", "getComponent", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TrackDefinition {
    private final int component;
    private final TrackType type;
    private final String uniformName;

    public TrackDefinition(String uniformName, TrackType type, int i) {
        k.f(uniformName, "uniformName");
        k.f(type, "type");
        this.uniformName = uniformName;
        this.type = type;
        this.component = i;
    }

    public static /* synthetic */ TrackDefinition copy$default(TrackDefinition trackDefinition, String str, TrackType trackType, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = trackDefinition.uniformName;
        }
        if ((i6 & 2) != 0) {
            trackType = trackDefinition.type;
        }
        if ((i6 & 4) != 0) {
            i = trackDefinition.component;
        }
        return trackDefinition.copy(str, trackType, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUniformName() {
        return this.uniformName;
    }

    /* renamed from: component2, reason: from getter */
    public final TrackType getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final int getComponent() {
        return this.component;
    }

    public final TrackDefinition copy(String uniformName, TrackType type, int component) {
        k.f(uniformName, "uniformName");
        k.f(type, "type");
        return new TrackDefinition(uniformName, type, component);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDefinition)) {
            return false;
        }
        TrackDefinition trackDefinition = (TrackDefinition) other;
        return k.b(this.uniformName, trackDefinition.uniformName) && k.b(this.type, trackDefinition.type) && this.component == trackDefinition.component;
    }

    public final int getComponent() {
        return this.component;
    }

    public final TrackType getType() {
        return this.type;
    }

    public final String getUniformName() {
        return this.uniformName;
    }

    public int hashCode() {
        return Integer.hashCode(this.component) + ((this.type.hashCode() + (this.uniformName.hashCode() * 31)) * 31);
    }

    public String toString() {
        String str = this.uniformName;
        TrackType trackType = this.type;
        int i = this.component;
        StringBuilder sb = new StringBuilder("TrackDefinition(uniformName=");
        sb.append(str);
        sb.append(", type=");
        sb.append(trackType);
        sb.append(", component=");
        return a.o(sb, ")", i);
    }

    public /* synthetic */ TrackDefinition(String str, TrackType trackType, int i, int i6, e eVar) {
        this(str, trackType, (i6 & 4) != 0 ? -1 : i);
    }
}
