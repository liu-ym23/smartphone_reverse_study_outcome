package K5;

import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\f\u0010\u000bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"LK5/b;", "", "<init>", "()V", "", "pkg", "LK5/a;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)LK5/a;", "", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "c", "apps", "Ljava/util/List;", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final b INSTANCE = new b();
    private static final List<ExpressApp> apps = C1173v.p(new ExpressApp("com.xingin.xhs", "xhs_post_lifecycle", new f("xiaohongshu")), new ExpressApp("com.dianping.v1", "dianping_comment_lifecycle", new e("dianping")));

    public final List<ExpressApp> a() {
        return apps;
    }

    public final ExpressApp b(String pkg) {
        Object next;
        Iterator<T> it = apps.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (p.d(((ExpressApp) next).getPkg(), pkg)) {
                break;
            }
        }
        return (ExpressApp) next;
    }

    public final List<String> c() {
        List<ExpressApp> list = apps;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ExpressApp) it.next()).getPkg());
        }
        return arrayList;
    }
}
