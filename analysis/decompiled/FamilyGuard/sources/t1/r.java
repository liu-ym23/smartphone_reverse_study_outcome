package t1;

import a1.C0409b;
import a1.C0418k;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    int f22476a;

    /* renamed from: b, reason: collision with root package name */
    private a f22477b;

    /* renamed from: c, reason: collision with root package name */
    int[][] f22478c = new int[10][];

    /* renamed from: d, reason: collision with root package name */
    a[] f22479d = new a[10];

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public b f22480a;

        a(b bVar) {
            this.f22480a = bVar;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        c f22481a;

        /* renamed from: b, reason: collision with root package name */
        float f22482b;

        b(c cVar, float f5) {
            this.f22481a = cVar;
            this.f22482b = f5;
        }

        public int a(int i5) {
            float f5;
            c cVar = this.f22481a;
            if (cVar == c.PERCENT) {
                f5 = this.f22482b * i5;
            } else {
                if (cVar != c.PIXELS) {
                    return 0;
                }
                f5 = this.f22482b;
            }
            return (int) f5;
        }
    }

    public enum c {
        PERCENT,
        PIXELS
    }

    private void a(int[] iArr, a aVar) {
        int i5 = this.f22476a;
        if (i5 == 0 || iArr.length == 0) {
            this.f22477b = aVar;
        }
        if (i5 >= this.f22478c.length) {
            f(i5, i5 + 10);
        }
        int[][] iArr2 = this.f22478c;
        int i6 = this.f22476a;
        iArr2[i6] = iArr;
        this.f22479d[i6] = aVar;
        this.f22476a = i6 + 1;
    }

    public static r b(Context context, TypedArray typedArray, int i5) throws Resources.NotFoundException {
        int next;
        int resourceId = typedArray.getResourceId(i5, 0);
        if (resourceId == 0 || !context.getResources().getResourceTypeName(resourceId).equals("xml")) {
            return null;
        }
        try {
            XmlResourceParser xml = context.getResources().getXml(resourceId);
            try {
                r rVar = new r();
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
                    rVar.h(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                xml.close();
                return rVar;
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
            return null;
        }
    }

    private b d(TypedArray typedArray, int i5, b bVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i5);
        if (typedValuePeekValue != null) {
            int i6 = typedValuePeekValue.type;
            if (i6 == 5) {
                return new b(c.PIXELS, TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i6 == 6) {
                return new b(c.PERCENT, typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return bVar;
    }

    private void f(int i5, int i6) {
        int[][] iArr = new int[i6][];
        System.arraycopy(this.f22478c, 0, iArr, 0, i5);
        this.f22478c = iArr;
        a[] aVarArr = new a[i6];
        System.arraycopy(this.f22479d, 0, aVarArr, 0, i5);
        this.f22479d = aVarArr;
    }

    private int g(int[] iArr) {
        int[][] iArr2 = this.f22478c;
        for (int i5 = 0; i5 < this.f22476a; i5++) {
            if (StateSet.stateSetMatches(iArr2[i5], iArr)) {
                return i5;
            }
        }
        return -1;
    }

    private void h(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
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
                TypedArray typedArrayObtainAttributes = theme == null ? context.getResources().obtainAttributes(attributeSet, C0418k.f6952C4) : theme.obtainStyledAttributes(attributeSet, C0418k.f6952C4, 0, 0);
                b bVarD = d(typedArrayObtainAttributes, C0418k.f6958D4, null);
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr = new int[attributeCount];
                int i5 = 0;
                for (int i6 = 0; i6 < attributeCount; i6++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i6);
                    if (attributeNameResource != C0409b.f6713W) {
                        int i7 = i5 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i6, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr[i5] = attributeNameResource;
                        i5 = i7;
                    }
                }
                a(StateSet.trimStateSet(iArr, i5), new a(bVarD));
            }
        }
    }

    public int c(int i5) {
        float fMax;
        int i6 = -i5;
        for (int i7 = 0; i7 < this.f22476a; i7++) {
            b bVar = this.f22479d[i7].f22480a;
            c cVar = bVar.f22481a;
            if (cVar == c.PIXELS) {
                fMax = Math.max(i6, bVar.f22482b);
            } else if (cVar == c.PERCENT) {
                fMax = Math.max(i6, i5 * bVar.f22482b);
            }
            i6 = (int) fMax;
        }
        return i6;
    }

    public a e(int[] iArr) {
        int iG = g(iArr);
        if (iG < 0) {
            iG = g(StateSet.WILD_CARD);
        }
        return iG < 0 ? this.f22477b : this.f22479d[iG];
    }
}
