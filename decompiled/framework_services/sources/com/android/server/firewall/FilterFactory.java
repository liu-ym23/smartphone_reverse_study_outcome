package com.android.server.firewall;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FilterFactory {
    private final String mTag;

    public abstract Filter newFilter(XmlPullParser r1) throws IOException, XmlPullParserException;

    protected FilterFactory(String tag) {
        if (tag == null) goto L7;
        this.mTag = tag;
        return;
    L7:
        throw new NullPointerException();
    }

    public String getTagName() {
        return this.mTag;
    }
}
