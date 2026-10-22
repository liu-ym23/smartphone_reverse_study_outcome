package K5;

import La.H;
import W3.EditTextNode;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"LK5/f;", "LK5/c;", "", "bizScene", "<init>", "(Ljava/lang/String;)V", "", "LW3/a;", "nodes", "LK5/d;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)Ljava/util/List;", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class f implements c {
    private final String bizScene;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Integer.valueOf(((EditTextNode) t10).getY()), Integer.valueOf(((EditTextNode) t11).getY()));
        }
    }

    public f(String bizScene) {
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
        int i10;
        p.i(nodes, "nodes");
        ArrayList arrayList = new ArrayList();
        for (Object obj : nodes) {
            if (((EditTextNode) obj).getIsEditable()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            i10 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (H.g0(((EditTextNode) next).getHint(), "标题", false, 2, null)) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (H.g0(((EditTextNode) obj2).getHint(), "正文", false, 2, null)) {
                arrayList3.add(obj2);
            }
        }
        if (arrayList2.size() == 1 && arrayList3.size() == 1 && !p.d(arrayList2.get(0), arrayList3.get(0))) {
            return C1173v.p(new SceneNode((EditTextNode) arrayList2.get(0), "current_title"), new SceneNode((EditTextNode) arrayList3.get(0), "current_body"));
        }
        List listF1 = F.f1(F.c1(arrayList, new a()), 2);
        ArrayList arrayList4 = new ArrayList(C1174w.x(listF1, 10));
        for (Object obj3 : listF1) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            arrayList4.add(new SceneNode((EditTextNode) obj3, i10 == 0 ? "current_title" : "current_body"));
            i10 = i11;
        }
        return arrayList4;
    }
}
