package k;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class[] f6844e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f6845f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f6846a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f6847b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f6848c;

    /* renamed from: d, reason: collision with root package name */
    public Object f6849d;

    static {
        Class[] clsArr = {Context.class};
        f6844e = clsArr;
        f6845f = clsArr;
    }

    public i(Context context) {
        super(context);
        this.f6848c = context;
        Object[] objArr = {context};
        this.f6846a = objArr;
        this.f6847b = objArr;
    }

    public static Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005d A[PHI: r3
      0x005d: PHI (r3v65 java.lang.String) = 
      (r3v1 java.lang.String)
      (r3v51 java.lang.String)
      (r3v1 java.lang.String)
      (r3v1 java.lang.String)
      (r3v1 java.lang.String)
      (r3v1 java.lang.String)
      (r3v1 java.lang.String)
      (r3v1 java.lang.String)
     binds: [B:40:0x00d1, B:88:0x024c, B:17:0x005b, B:38:0x00ca, B:30:0x008e, B:36:0x00b2, B:35:0x009a, B:26:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(org.xmlpull.v1.XmlPullParser r17, android.util.AttributeSet r18, android.view.Menu r19) throws org.xmlpull.v1.XmlPullParserException, java.lang.IllegalAccessException, java.io.IOException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 652
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.i.b(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i, Menu menu) {
        if (!(menu instanceof h3.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        boolean z10 = false;
        try {
            try {
                layout = this.f6848c.getResources().getLayout(i);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof l.l) {
                    l.l lVar = (l.l) menu;
                    if (!lVar.f7597p) {
                        lVar.w();
                        z10 = true;
                    }
                }
                b(layout, attributeSetAsAttributeSet, menu);
                if (z10) {
                    ((l.l) menu).v();
                }
                layout.close();
            } catch (IOException e10) {
                throw new InflateException("Error inflating menu XML", e10);
            } catch (XmlPullParserException e11) {
                throw new InflateException("Error inflating menu XML", e11);
            }
        } catch (Throwable th) {
            if (z10) {
                ((l.l) menu).v();
            }
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
