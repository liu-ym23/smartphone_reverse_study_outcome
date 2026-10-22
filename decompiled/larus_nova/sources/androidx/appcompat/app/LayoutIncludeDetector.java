package androidx.appcompat.app;

import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
class LayoutIncludeDetector {
    private final Deque<WeakReference<XmlPullParser>> mXmlParserStack;

    public LayoutIncludeDetector() {
        this.mXmlParserStack = new ArrayDeque();
    }

    private static boolean isParserOutdated(XmlPullParser r100) {
        if (r100 == null) goto L14;
        if (r100.getEventType() == 3) goto L15;
        if (r100.getEventType() == 1) goto L16;
        return false;
    L16:
        return true;
    L15:
        return true;
    L17:
        return true;
    L14:
        return true;
    }

    private static XmlPullParser popOutdatedAttrHolders(Deque<WeakReference<XmlPullParser>> r100) {
    L3:
        if (r100.isEmpty() == true) goto L8;
        XmlPullParser r101 = r100.peek().get();
        if (isParserOutdated(r101) == false) goto L7;
        r100.pop();
        goto L3
    L7:
        return r101;
    L8:
        return null;
    }

    public boolean detect(AttributeSet r100) {
        if ((r100 instanceof XmlPullParser) == false) goto L9;
        XmlPullParser r101 = (XmlPullParser) r100;
        if (r101.getDepth() != 1) goto L11;
        XmlPullParser r102 = popOutdatedAttrHolders(this.mXmlParserStack);
        this.mXmlParserStack.push(new WeakReference(r101));
        if (shouldInheritContext(r101, r102) == false) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    L9:
        return false;
    }

    private static boolean shouldInheritContext(XmlPullParser r100, XmlPullParser r101) {
        if (r101 == null) goto L8;
        if (r100 == r101) goto L13;
        if (r101.getEventType() != 2) goto L14;
        return "include".equals(r101.getName());
    L14:
        return false;
    L15:
        return false;
    L13:
        return false;
    L8:
        return false;
    }
}
