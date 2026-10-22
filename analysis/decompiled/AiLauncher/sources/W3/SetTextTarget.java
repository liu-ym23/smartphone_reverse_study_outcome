package W3;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\t¨\u0006\u0016"}, d2 = {"LW3/h;", "", "LW3/a;", "node", "", "text", "<init>", "(LW3/a;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "LW3/a;", "()LW3/a;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: W3.h, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class SetTextTarget {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final EditTextNode node;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String text;

    public SetTextTarget(EditTextNode node, String text) {
        p.i(node, "node");
        p.i(text, "text");
        this.node = node;
        this.text = text;
    }

    /* renamed from: a, reason: from getter */
    public final EditTextNode getNode() {
        return this.node;
    }

    /* renamed from: b, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SetTextTarget)) {
            return false;
        }
        SetTextTarget setTextTarget = (SetTextTarget) other;
        return p.d(this.node, setTextTarget.node) && p.d(this.text, setTextTarget.text);
    }

    public int hashCode() {
        return (this.node.hashCode() * 31) + this.text.hashCode();
    }

    public String toString() {
        return "SetTextTarget(node=" + this.node + ", text=" + this.text + ")";
    }
}
