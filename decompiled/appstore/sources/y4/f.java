package y4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f26122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f26123j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f26124k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f26125l;

    static {
    }

    public f(int r10) {
        super(r10);
        this.f26122i = new ArrayList();
        this.f26123j = new ArrayList();
        this.f26124k = false;
        this.f26125l = false;
    }

    @Override // y4.c
    public boolean b(g6.b r10, Map r11) {
        if (this.f26124k == false) goto L5;
        return false;
    L5:
        if (g(r10) == true) goto L8;
        return false;
    L8:
        if (this.f26122i.isEmpty() == true) goto L20;
        LinkedHashMap r12 = new LinkedHashMap();
        if (r11.containsKey("x-tt-encrypt-queries") == false) goto L12;
        r12.put("x-tt-encrypt-queries", r11.get("x-tt-encrypt-queries"));
    L12:
        Iterator r13 = this.f26122i.iterator();
    L14:
        if (r13.hasNext() == false) goto L18;
        String r14 = (String) r13.next();
        if (r11.containsKey(r14) == false) goto L14;
        r12.put(r14, r11.get(r14));
        goto L14
    L18:
        r11.clear();
        r11.putAll(r12);
        return true;
    L20:
        if (this.f26123j.isEmpty() == true) goto L53;
        Iterator r15 = this.f26123j.iterator();
    L23:
        if (r15.hasNext() == false) goto L26;
        r11.remove((String) r15.next());
        goto L23
    L26:
        if (r10.D() == null) goto L28;
        String r16 = r10.D();
    L30:
        if (this.f26125l == true) goto L32;
        return true;
    L32:
        if (r16.contains("bgrm") == true) goto L55;
        Iterator r17 = this.f26123j.iterator();
    L35:
        if (r17.hasNext() == false) goto L56;
        if (r16.contains((String) r17.next()) == false) goto L35;
        ArrayList r18 = new ArrayList();
        r18.add("1");
        r11.put("bgrm", r18);
        return true;
    L56:
        return true;
    L55:
        return true;
    L28:
        r16 = "";
        goto L30
    L53:
        return true;
    }

    @Override // y4.c
    public void h(JSONObject r10) {
        i(r10);
        d.h(r10.optJSONArray("keep_list"), this.f26122i);
        d.h(r10.optJSONArray("remove_list"), this.f26123j);
        boolean r11 = false;
        if (r10.optInt("protect_background_request", 0) <= 0) goto L5;
        boolean r12 = true;
    L6:
        this.f26108c = r12;
        if (r10.optInt("add_background_rm_mark", 0) <= 0) goto L9;
        r11 = true;
    L9:
        this.f26125l = r11;
        if (this.f26122i.isEmpty() == false) goto L12;
        return;
    L12:
        if (this.f26123j.isEmpty() == true) goto L16;
        this.f26124k = true;
        return;
    L16:
        return;
    L5:
        r12 = false;
        goto L6
    }
}
