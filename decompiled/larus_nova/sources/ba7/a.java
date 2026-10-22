package ba7;

import android.text.TextUtils;
import ca7.c;
import ca7.d;
import ca7.g;
import ca7.j;
import ca7.l;
import ca7.n;
import com.bytedance.ruler.base.models.f;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Object, c> f18419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Object, l> f18420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<g> f18421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<j> f18422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<fa7.a> f18423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<l> f18424f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, n> f18425g;

    public a() {
        this.f18419a = new HashMap();
        this.f18420b = new HashMap();
        this.f18421c = new ArrayList();
        this.f18422d = new ArrayList();
        this.f18423e = new ArrayList();
        this.f18424f = new ArrayList();
        this.f18425g = new HashMap();
    }

    public final c a(Object r100) {
        c r101 = this.f18419a.get(r100);
        if (r101 != null) goto L6;
        d r102 = new d(r100);
        this.f18419a.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    public final g b(String r100) {
        Iterator<g> r101 = this.f18421c.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        g r102 = r101.next();
        if (TextUtils.equals(r102.f22959c, r100) == false) goto L4;
    L9:
        if (r102 != null) goto L15;
        g r103 = new g(r100);
        this.f18421c.add(r103);
        return r103;
    L15:
        return r102;
    L8:
        r102 = null;
        goto L9
    }

    public final List<Object> c(Map<String, Object> r100, ga7.d r101, boolean r102, Map<String, v97.b> r103) {
        da7.b r104 = new da7.b(r100, r101, r102);
        Iterator<l> r105 = this.f18424f.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r105.next().c(r104);
        goto L4
    L6:
        Iterator<g> r106 = this.f18421c.iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        r106.next().c(r104);
        goto L8
    L10:
        r104.f467700d = true;
        Iterator<j> r107 = this.f18422d.iterator();
    L12:
        if (r107.hasNext() == false) goto L15;
        r107.next().c(r104);
        goto L12
    L15:
        if (this.f18423e.size() <= 0) goto L29;
        int r108 = z97.b.f571020a;
        f r109 = z97.b.a(this.f18423e, r102, r100, r103);
        r101.f480574a.putAll(r109.f267672g);
        if (r109.f267668c != 0) goto L29;
        Iterator<com.bytedance.ruler.base.models.c> r110 = r109.f267674i.iterator();
    L20:
        if (r110.hasNext() == false) goto L29;
        com.bytedance.ruler.base.models.c r111 = r110.next();
        if (r111.f267661a != 0) goto L20;
        JsonElement r112 = r111.f267665e;
        if (r112 == null) goto L20;
        String r113 = r112.toString();
        l r114 = this.f18420b.get(r113);
        if (r114 != null) goto L28;
        r114 = new l(r112);
        this.f18420b.put(r113, r114);
    L28:
        r114.c(r104);
    L29:
        ArrayList r115 = new ArrayList();
        if (r102 == true) goto L32;
        Iterator<l> r116 = r104.f467701e.iterator();
    L36:
        if (r116.hasNext() == false) goto L38;
        r115.add(r116.next().f22966c);
    L38:
        return r115;
    L32:
        if (r104.f467701e.size() <= 0) goto L38;
        r115.add(r104.f467701e.first().f22966c);
        goto L38
    }
}
