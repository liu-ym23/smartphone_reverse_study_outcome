package androidx.appcompat.app;

import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Deque f385a;

    public j() {
        this.f385a = new ArrayDeque();
    }

    public static boolean b(XmlPullParser r10) {
        if (r10 == null) goto L14;
        if (r10.getEventType() == 3) goto L15;
        if (r10.getEventType() == 1) goto L16;
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

    public static XmlPullParser c(Deque r10) {
    L3:
        if (r10.isEmpty() == true) goto L8;
        XmlPullParser r11 = (XmlPullParser) ((WeakReference) r10.peek()).get();
        if (b(r11) == false) goto L7;
        r10.pop();
        goto L3
    L7:
        return r11;
    L8:
        return null;
    }

    public static boolean d(XmlPullParser r10, XmlPullParser r11) {
        if (r11 == null) goto L8;
        if (r10 == r11) goto L13;
        if (r11.getEventType() != 2) goto L14;
        return "include".equals(r11.getName());
    L14:
        return false;
    L15:
        return false;
    L13:
        return false;
    L8:
        return false;
    }

    public boolean a(AttributeSet r10) {
        if ((r10 instanceof XmlPullParser) == false) goto L9;
        XmlPullParser r11 = (XmlPullParser) r10;
        if (r11.getDepth() != 1) goto L11;
        XmlPullParser r12 = c(this.f385a);
        this.f385a.push(new WeakReference(r11));
        if (d(r11, r12) == false) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    L9:
        return false;
    }
}
