package e3;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.stepos.ability.R;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: e3.C, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1409C {

    /* renamed from: a, reason: collision with root package name */
    public final int f4338a;
    public final p b;
    public final int[][] c;
    public final p[] d;
    public final C1408B e;
    public final C1408B f;
    public final C1408B g;
    public final C1408B h;

    public C1409C(F9.x xVar) {
        this.f4338a = xVar.b;
        this.b = (p) xVar.d;
        this.c = (int[][]) xVar.e;
        this.d = (p[]) xVar.f;
        this.e = (C1408B) xVar.g;
        this.f = (C1408B) xVar.h;
        this.g = (C1408B) xVar.c;
        this.h = (C1408B) xVar.i;
    }

    public static void a(F9.x xVar, Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlResourceParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth && xmlResourceParser.getName().equals("item")) {
                Resources resources = context.getResources();
                int[] iArr = P2.a.f1081w;
                TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                p pVarA = p.a(context, typedArrayObtainAttributes.getResourceId(0, 0), typedArrayObtainAttributes.getResourceId(1, 0), new C1412a(0)).a();
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i = 0;
                for (int i6 = 0; i6 < attributeCount; i6++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i6);
                    if (attributeNameResource != R.attr.shapeAppearance && attributeNameResource != R.attr.shapeAppearanceOverlay) {
                        int i10 = i + 1;
                        if (!attributeSet.getAttributeBooleanValue(i6, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i] = attributeNameResource;
                        i = i10;
                    }
                }
                xVar.c(StateSet.trimStateSet(iArr2, i), pVarA);
            }
        }
    }

    public static C1409C b(Context context, TypedArray typedArray, int i) {
        XmlResourceParser xml;
        AttributeSet attributeSetAsAttributeSet;
        int next;
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0 || !Objects.equals(context.getResources().getResourceTypeName(resourceId), "xml")) {
            return null;
        }
        F9.x xVar = new F9.x(2);
        xVar.i();
        try {
            xml = context.getResources().getXml(resourceId);
            try {
                attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
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
            xVar.i();
        }
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        if (xml.getName().equals("selector")) {
            a(xVar, context, xml, attributeSetAsAttributeSet, context.getTheme());
        }
        xml.close();
        if (xVar.b == 0) {
            return null;
        }
        return new C1409C(xVar);
    }

    public final p c() {
        p pVar = this.b;
        C1408B c1408b = this.h;
        C1408B c1408b2 = this.g;
        C1408B c1408b3 = this.f;
        C1408B c1408b4 = this.e;
        if (c1408b4 == null && c1408b3 == null && c1408b2 == null && c1408b == null) {
            return pVar;
        }
        o oVarF = pVar.f();
        if (c1408b4 != null) {
            oVarF.e = c1408b4.b;
        }
        if (c1408b3 != null) {
            oVarF.f = c1408b3.b;
        }
        if (c1408b2 != null) {
            oVarF.h = c1408b2.b;
        }
        if (c1408b != null) {
            oVarF.g = c1408b.b;
        }
        return oVarF.a();
    }

    public final boolean d() {
        C1408B c1408b;
        C1408B c1408b2;
        C1408B c1408b3;
        C1408B c1408b4;
        return this.f4338a > 1 || ((c1408b = this.e) != null && c1408b.f4337a > 1) || (((c1408b2 = this.f) != null && c1408b2.f4337a > 1) || (((c1408b3 = this.g) != null && c1408b3.f4337a > 1) || ((c1408b4 = this.h) != null && c1408b4.f4337a > 1)));
    }
}
