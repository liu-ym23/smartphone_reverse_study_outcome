package com.bytedance.android.ec.core.vmsdk;

import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class j implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f45788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p.d f45789b;

    public /* synthetic */ j(p r100, p.d r101) {
        this.f45788a = r100;
        this.f45789b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r110) {
        p r100 = this.f45788a;
        p.d r101 = this.f45789b;
        Response r111 = (Response) r110;
        r100.getClass();
        if (r111 == null) goto L26;
        byte[] r102 = r111.j();
        if (r102 == null) goto L25;
        String r103 = r111.c();
        if (r102.length > 0) goto L29;
    L16:
        String r104 = null;
    L17:
        if (r104 == null) goto L25;
        if (r104.isEmpty() == true) goto L25;
        String r105 = r111.g(r111.f244319u);
        ResourceFrom r106 = r111.f244319u;
        if (r106 != ResourceFrom.GECKO) goto L23;
        boolean r107 = true;
    L24:
        r101.a(r104, r105, null, r107, r111.g(r106), r111.B);
    L28:
        return null;
    L23:
        r107 = false;
        goto L24
    L29:
        if (r103 != null) goto L11;
    L12:
        r103 = XML.CHARSET_UTF8;
    L13:
        r104 = new String(r102, r103);     // Catch: Exception -> L15
        goto L17
    L11:
        if (r103.isEmpty() == false) goto L13;
    L25:
        String r108 = r111.f244317s.toString();
    L27:
        r101.a(null, null, r108, false, "", 0);
        goto L28
    L26:
        r108 = null;
        goto L27
    }
}
