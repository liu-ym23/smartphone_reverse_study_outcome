package ck4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pk4.j;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f24032a;

    /* JADX INFO: renamed from: ck4.a$a, reason: collision with other inner class name */
    public static class C0455a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f24033a = null;

        static {
            f24033a = new a();
        }
    }

    public a() {
        this.f24032a = new ArrayList();
    }

    public final void a(String r100, boolean r101) {
        List<b> r102 = this.f24032a;
        if (r102 != null) goto L5;
    L15:
        j.d("DoraHeadPhoneLogReportEngine", "errorRuleStrategyList is null");
        return;
    L5:
        if (((ArrayList) r102).isEmpty() == true) goto L15;
        Iterator r103 = ((ArrayList) this.f24032a).iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        b r104 = (b) r103.next();
        boolean r105 = r104.b(r100);
        if (r105 == true) goto L12;
        j.d("DoraHeadPhoneLogReportEngine", "not hit: " + r105);
        goto L9
    L12:
        r104.a(Boolean.valueOf(r101));
        goto L9
    }
}
