package K5;

import W3.EditTextNode;
import Z8.C1172u;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"LK5/e;", "LK5/c;", "", "bizScene", "<init>", "(Ljava/lang/String;)V", "", "LW3/a;", "nodes", "LK5/d;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)Ljava/util/List;", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e implements c {
    private final String bizScene;

    public e(String bizScene) {
        p.i(bizScene, "bizScene");
        this.bizScene = bizScene;
    }

    @Override // K5.c
    /* renamed from: a, reason: from getter */
    public String getBizScene() {
        return this.bizScene;
    }

    @Override // K5.c
    public List<SceneNode> b(List<EditTextNode> nodes) {
        Object obj;
        Object next;
        p.i(nodes, "nodes");
        List<EditTextNode> list = nodes;
        Iterator<T> it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            EditTextNode editTextNode = (EditTextNode) next;
            if (editTextNode.getIsEditable() && editTextNode.getIsFocused()) {
                break;
            }
        }
        EditTextNode editTextNode2 = (EditTextNode) next;
        if (editTextNode2 == null) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                if (((EditTextNode) next2).getIsEditable()) {
                    obj = next2;
                    break;
                }
            }
            editTextNode2 = (EditTextNode) obj;
            if (editTextNode2 == null) {
                return C1173v.m();
            }
        }
        return C1172u.e(new SceneNode(editTextNode2, "current_body"));
    }
}
