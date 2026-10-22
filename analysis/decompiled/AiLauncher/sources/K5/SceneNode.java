package K5;

import W3.EditTextNode;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"LK5/d;", "", "LW3/a;", "node", "", HomeGestureEligibilityContract.EXTRA_SCENE, "<init>", "(LW3/a;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "LW3/a;", Const.INTENT_KEY_APIKEY, "()LW3/a;", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K5.d, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SceneNode {
    private final EditTextNode node;
    private final String scene;

    public SceneNode(EditTextNode node, String scene) {
        p.i(node, "node");
        p.i(scene, "scene");
        this.node = node;
        this.scene = scene;
    }

    /* renamed from: a, reason: from getter */
    public final EditTextNode getNode() {
        return this.node;
    }

    /* renamed from: b, reason: from getter */
    public final String getScene() {
        return this.scene;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SceneNode)) {
            return false;
        }
        SceneNode sceneNode = (SceneNode) other;
        return p.d(this.node, sceneNode.node) && p.d(this.scene, sceneNode.scene);
    }

    public int hashCode() {
        return (this.node.hashCode() * 31) + this.scene.hashCode();
    }

    public String toString() {
        return "SceneNode(node=" + this.node + ", scene=" + this.scene + ")";
    }
}
