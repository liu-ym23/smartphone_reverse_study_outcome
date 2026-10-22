package t1;

import a1.C0409b;
import a1.C0418k;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    int f22456a;

    /* renamed from: b, reason: collision with root package name */
    private InterfaceC1111d f22457b;

    /* renamed from: c, reason: collision with root package name */
    int[][] f22458c = new int[10][];

    /* renamed from: d, reason: collision with root package name */
    InterfaceC1111d[] f22459d = new InterfaceC1111d[10];

    private void a(int[] iArr, InterfaceC1111d interfaceC1111d) {
        int i5 = this.f22456a;
        if (i5 == 0 || iArr.length == 0) {
            this.f22457b = interfaceC1111d;
        }
        if (i5 >= this.f22458c.length) {
            f(i5, i5 + 10);
        }
        int[][] iArr2 = this.f22458c;
        int i6 = this.f22456a;
        iArr2[i6] = iArr;
        this.f22459d[i6] = interfaceC1111d;
        this.f22456a = i6 + 1;
    }

    public static p b(Context context, TypedArray typedArray, int i5, InterfaceC1111d interfaceC1111d) throws Resources.NotFoundException {
        int next;
        int resourceId = typedArray.getResourceId(i5, 0);
        if (resourceId != 0 && context.getResources().getResourceTypeName(resourceId).equals("xml")) {
            try {
                XmlResourceParser xml = context.getResources().getXml(resourceId);
                try {
                    p pVar = new p();
                    AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                    do {
                        next = xml.next();
                        if (next == 2) {
                            break;
                        }
                    } while (next != 1);
                    if (next != 2) {
                        throw new XmlPullParserException("No start tag found");
                    }
                    if (xml.getName().equals("selector")) {
                        pVar.i(context, xml, attributeSetAsAttributeSet, context.getTheme());
                    }
                    xml.close();
                    return pVar;
                } catch (Throwable th) {
                    if (xml != null) {
                        try {
                            xml.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
                return c(interfaceC1111d);
            }
        }
        return c(l.m(typedArray, i5, interfaceC1111d));
    }

    public static p c(InterfaceC1111d interfaceC1111d) {
        p pVar = new p();
        pVar.a(StateSet.WILD_CARD, interfaceC1111d);
        return pVar;
    }

    private void f(int i5, int i6) {
        int[][] iArr = new int[i6][];
        System.arraycopy(this.f22458c, 0, iArr, 0, i5);
        this.f22458c = iArr;
        InterfaceC1111d[] interfaceC1111dArr = new InterfaceC1111d[i6];
        System.arraycopy(this.f22459d, 0, interfaceC1111dArr, 0, i5);
        this.f22459d = interfaceC1111dArr;
    }

    private int g(int[] iArr) {
        int[][] iArr2 = this.f22458c;
        for (int i5 = 0; i5 < this.f22456a; i5++) {
            if (StateSet.stateSetMatches(iArr2[i5], iArr)) {
                return i5;
            }
        }
        return -1;
    }

    private void i(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayObtainAttributes = theme == null ? context.getResources().obtainAttributes(attributeSet, C0418k.f7077X3) : theme.obtainStyledAttributes(attributeSet, C0418k.f7077X3, 0, 0);
                InterfaceC1111d interfaceC1111dM = l.m(typedArrayObtainAttributes, C0418k.f7117d4, new C1108a(0.0f));
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr = new int[attributeCount];
                int i5 = 0;
                for (int i6 = 0; i6 < attributeCount; i6++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i6);
                    if (attributeNameResource != C0409b.f6721h) {
                        int i7 = i5 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i6, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr[i5] = attributeNameResource;
                        i5 = i7;
                    }
                }
                a(StateSet.trimStateSet(iArr, i5), interfaceC1111dM);
            }
        }
    }

    public InterfaceC1111d d(int[] iArr) {
        int iG = g(iArr);
        if (iG < 0) {
            iG = g(StateSet.WILD_CARD);
        }
        return iG < 0 ? this.f22457b : this.f22459d[iG];
    }

    public InterfaceC1111d e() {
        return this.f22457b;
    }

    public boolean h() {
        return this.f22456a > 1;
    }
}
