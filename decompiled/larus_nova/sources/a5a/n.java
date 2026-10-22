package a5a;

import android.app.Activity;
import android.content.Context;
import com.lynx.basedevtool.logbox.LogBoxLogLevel;
import com.lynx.basedevtool.logbox.LogBoxProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHashMap<Context, l> f1905a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f1906a = null;

        static {
            f1906a = new n();
        }
    }

    public n() {
        this.f1905a = new WeakHashMap();
    }

    public final void a(String r100, LogBoxLogLevel r101, Context r102, LogBoxProxy r110) {
        if ((r102 instanceof Activity) == true) goto L6;
    L7:
        l r103 = null;
    L12:
        if (r103 == null) goto L54;
        if (r110 == null) goto L60;
        l.a r104 = (l.a) ((HashMap) r103.f1885b).get(r101);
        if (r104 == null) goto L61;
        r104.f1891d++;
        boolean r105 = false;
        if (((ArrayList) r104.f1889b).contains(r110) == true) goto L21;
        ((ArrayList) r104.f1889b).add(r110);
        boolean r106 = true;
    L22:
        b r107 = r103.f1887d;
        if (r107 == null) goto L49;
        if (r107.isShowing() == false) goto L49;
        m r108 = r103.f1886c;
        if (r108 == null) goto L30;
        ((HashMap) r108.f1895d).put(r101, Boolean.TRUE);
    L30:
        if (r103.f1887d.f1857d != r101) goto L62;
        int r109 = ((ArrayList) r104.f1889b).indexOf(r110);
        if (r109 != (-1)) goto L35;
    L37:
        if (r105 == false) goto L39;
        r103.f1887d.d(r110.getErrorNamespace(), r100);
        return;
    L39:
        if (r106 == false) goto L56;
        b r111 = r103.f1887d;
        int r112 = r104.f1890c + 1;
        int r113 = ((ArrayList) r104.f1889b).size();
        l.a r114 = (l.a) ((HashMap) r103.f1885b).get(r101);
        String r115 = "";
        if (r114 == null) goto L47;
        LogBoxProxy r116 = r114.a();
        if (r116 == null) goto L47;
        r115 = r116.getEntryUrlForLogSrc();
    L47:
        r111.e(r112, r113, r101, r115);
        return;
    L56:
        return;
    L35:
        if (r109 != r104.f1890c) goto L37;
        r105 = true;
        goto L37
    L62:
        return;
    L49:
        if (r103.f1886c != null) goto L51;
        return;
    L51:
        if (l.c(r103.f1884a.get()) == false) goto L59;
        r103.f1886c.c(r101, l.b(r100), r104.f1891d);
        return;
    L59:
        return;
    L21:
        r106 = false;
        goto L22
    L61:
        return;
    L60:
        return;
    L54:
        return;
    L6:
        if (((Activity) r102).isFinishing() == true) goto L7;
        l r117 = this.f1905a.get(r102);
        if (r117 != null) goto L11;
        r117 = new l(r102);
        this.f1905a.put(r102, r117);
    L11:
        r103 = r117;
        goto L12
    }
}
