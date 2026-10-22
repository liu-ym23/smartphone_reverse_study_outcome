package com.bytedance.ai.bridge.method.message;

import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final XmlPullParserFactory f35610a = null;

    static {
        f35610a = XmlPullParserFactory.newInstance();
    }

    public static final void a(XmlSerializer r100, String r101, String r102) {
        r100.startTag(null, r101);
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        r100.text(r102);
    L11:
        r100.endTag(null, r101);
        return;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
