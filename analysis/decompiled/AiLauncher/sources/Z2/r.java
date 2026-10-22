package Z2;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public int f7260a;

    /* renamed from: b, reason: collision with root package name */
    public d f7261b;

    /* renamed from: c, reason: collision with root package name */
    public int[][] f7262c = new int[10][];

    /* renamed from: d, reason: collision with root package name */
    public d[] f7263d = new d[10];

    public static r b(d dVar) {
        r rVar = new r();
        rVar.a(StateSet.WILD_CARD, dVar);
        return rVar;
    }

    public static r c(Context context, TypedArray typedArray, int i10, d dVar) throws Resources.NotFoundException {
        int next;
        int resourceId = typedArray.getResourceId(i10, 0);
        if (resourceId != 0 && context.getResources().getResourceTypeName(resourceId).equals("xml")) {
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
                        rVar.i(context, xml, attributeSetAsAttributeSet, context.getTheme());
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
                return b(dVar);
            }
        }
        return b(l.m(typedArray, i10, dVar));
    }

    public final void a(int[] iArr, d dVar) {
        int i10 = this.f7260a;
        if (i10 == 0 || iArr.length == 0) {
            this.f7261b = dVar;
        }
        if (i10 >= this.f7262c.length) {
            f(i10, i10 + 10);
        }
        int[][] iArr2 = this.f7262c;
        int i11 = this.f7260a;
        iArr2[i11] = iArr;
        this.f7263d[i11] = dVar;
        this.f7260a = i11 + 1;
    }

    public d d(int[] iArr) {
        int iG = g(iArr);
        if (iG < 0) {
            iG = g(StateSet.WILD_CARD);
        }
        return iG < 0 ? this.f7261b : this.f7263d[iG];
    }

    public d e() {
        return this.f7261b;
    }

    public final void f(int i10, int i11) {
        int[][] iArr = new int[i11][];
        System.arraycopy(this.f7262c, 0, iArr, 0, i10);
        this.f7262c = iArr;
        d[] dVarArr = new d[i11];
        System.arraycopy(this.f7263d, 0, dVarArr, 0, i10);
        this.f7263d = dVarArr;
    }

    public final int g(int[] iArr) {
        int[][] iArr2 = this.f7262c;
        for (int i10 = 0; i10 < this.f7260a; i10++) {
            if (StateSet.stateSetMatches(iArr2[i10], iArr)) {
                return i10;
            }
        }
        return -1;
    }

    public boolean h() {
        return this.f7260a > 1;
    }

    public final void i(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
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
                TypedArray typedArrayObtainAttributes = theme == null ? context.getResources().obtainAttributes(attributeSet, R$styleable.ShapeAppearance) : theme.obtainStyledAttributes(attributeSet, R$styleable.ShapeAppearance, 0, 0);
                d dVarM = l.m(typedArrayObtainAttributes, R$styleable.ShapeAppearance_cornerSize, new a(0.0f));
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr = new int[attributeCount];
                int i10 = 0;
                for (int i11 = 0; i11 < attributeCount; i11++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i11);
                    if (attributeNameResource != R$attr.cornerSize) {
                        int i12 = i10 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i11, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr[i10] = attributeNameResource;
                        i10 = i12;
                    }
                }
                a(StateSet.trimStateSet(iArr, i10), dVarM);
            }
        }
    }
}
