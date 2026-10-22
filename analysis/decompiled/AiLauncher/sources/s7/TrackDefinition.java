package s7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u0012\u0010\r¨\u0006\u0019"}, d2 = {"Ls7/u;", "", "", "uniformName", "Ls7/v;", "type", "", "component", "<init>", "(Ljava/lang/String;Ls7/v;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "c", Const.INTENT_KEY_PKGNAME, "Ls7/v;", "()Ls7/v;", "I", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: s7.u, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class TrackDefinition {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String uniformName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final v type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int component;

    public TrackDefinition(String uniformName, v type, int i10) {
        kotlin.jvm.internal.p.i(uniformName, "uniformName");
        kotlin.jvm.internal.p.i(type, "type");
        this.uniformName = uniformName;
        this.type = type;
        this.component = i10;
    }

    /* renamed from: a, reason: from getter */
    public final int getComponent() {
        return this.component;
    }

    /* renamed from: b, reason: from getter */
    public final v getType() {
        return this.type;
    }

    /* renamed from: c, reason: from getter */
    public final String getUniformName() {
        return this.uniformName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDefinition)) {
            return false;
        }
        TrackDefinition trackDefinition = (TrackDefinition) other;
        return kotlin.jvm.internal.p.d(this.uniformName, trackDefinition.uniformName) && kotlin.jvm.internal.p.d(this.type, trackDefinition.type) && this.component == trackDefinition.component;
    }

    public int hashCode() {
        return (((this.uniformName.hashCode() * 31) + this.type.hashCode()) * 31) + Integer.hashCode(this.component);
    }

    public String toString() {
        return "TrackDefinition(uniformName=" + this.uniformName + ", type=" + this.type + ", component=" + this.component + ")";
    }
}
