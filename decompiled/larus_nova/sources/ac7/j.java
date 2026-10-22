package ac7;

import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class j extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2756b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<g> f2757a;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(List<? extends g> r100) {
        this.f2757a = r100;
    }

    @Override // ac7.g
    public final boolean a(JSONObject r100) {
        Iterator<g> r101 = this.f2757a.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r101.next().a(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
