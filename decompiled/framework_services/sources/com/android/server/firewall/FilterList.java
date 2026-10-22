package com.android.server.firewall;

import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
abstract class FilterList implements Filter {
    protected final ArrayList<Filter> children;

    FilterList() {
        this.children = new ArrayList();
    }

    public FilterList readFromXml(XmlPullParser parser) throws IOException, XmlPullParserException {
        int outerDepth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L6;
        readChild(parser);
        goto L4
    L6:
        return this;
    }

    protected void readChild(XmlPullParser parser) throws IOException, XmlPullParserException {
        Filter filter = IntentFirewall.parseFilter(parser);
        this.children.add(filter);
    }
}
