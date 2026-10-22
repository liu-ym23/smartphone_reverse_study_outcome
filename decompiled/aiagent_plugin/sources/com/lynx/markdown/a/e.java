package com.lynx.markdown.a;

import com.ttreader.tttext.lite.JavaFontManager;
import com.ttreader.tttext.lite.TTFont;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/* JADX INFO: compiled from: JavaResourceManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<c> f13875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Object, Integer> f13876b;

    public e() {
        ArrayList<c> r0 = new ArrayList();
        this.f13875a = r0;
        r0.add(null);
        this.f13876b = new Hashtable();
    }

    public int a(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return 0;
    L6:
        int r0 = a(r4);
        if (r0 == (-1)) goto L9;
        return r0;
    L9:
        this.f13875a.add(r4);
        int r1 = this.f13875a.size() - 1;
        this.f13876b.put(r4, Integer.valueOf(r1));
        return r1;
    }

    public int a(TTFont r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        return JavaFontManager.GetInstance().RegisterFont(r1);
    }

    public c a(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.f13875a.size()) goto L7;
        return null;
    L7:
        return (c) ZeusTransformUtils.preCheckCast(this.f13875a.get(r2), c.class, "com.obric.aiagent.plugin");
    }

    private int a(Object r3) {
        if (r3 != null) goto L5;
        return -1;
    L5:
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(this.f13876b.get(r3), Integer.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L9;
        return -1;
    L9:
        return r2.intValue();
    }
}
