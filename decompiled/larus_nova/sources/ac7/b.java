package ac7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2747b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<g> f2748a;

    public static final class a {
        public static b a(List r100) {
            List r101 = r100;
            ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
            Iterator r103 = r101.iterator();
        L4:
            if (r103.hasNext() == false) goto L7;
            String r104 = (String) r103.next();
            int r105 = k.f2758a;
            r102.add(k.a.a(r104));
            goto L4
        L7:
            return new b(r102);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends g> r100) {
        this.f2748a = r100;
    }

    @Override // ac7.g
    public final boolean a(JSONObject r100) {
        Iterator<g> r101 = this.f2748a.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r101.next().a(r100) == true) goto L4;
        return false;
    L9:
        return true;
    }
}
