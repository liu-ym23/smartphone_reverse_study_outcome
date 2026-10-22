package t1;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.stepos.stepclaw.R;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final int f5552a;

    /* renamed from: b, reason: collision with root package name */
    public final n f5553b;

    /* renamed from: c, reason: collision with root package name */
    public final int[][] f5554c;
    public final n[] d;

    /* renamed from: e, reason: collision with root package name */
    public final y f5555e;

    /* renamed from: f, reason: collision with root package name */
    public final y f5556f;

    /* renamed from: g, reason: collision with root package name */
    public final y f5557g;

    /* renamed from: h, reason: collision with root package name */
    public final y f5558h;

    public z(n6.l lVar) {
        this.f5552a = lVar.f4056b;
        this.f5553b = (n) lVar.f4057c;
        this.f5554c = (int[][]) lVar.d;
        this.d = (n[]) lVar.f4058e;
        this.f5555e = (y) lVar.f4059f;
        this.f5556f = (y) lVar.f4060g;
        this.f5557g = (y) lVar.f4061h;
        this.f5558h = (y) lVar.f4062i;
    }

    public static void a(n6.l lVar, Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
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
                int[] iArr = d1.a.f1771m;
                TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                n nVarA = n.a(context, typedArrayObtainAttributes.getResourceId(0, 0), typedArrayObtainAttributes.getResourceId(1, 0), new a(0)).a();
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i8 = 0;
                for (int i9 = 0; i9 < attributeCount; i9++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i9);
                    if (attributeNameResource != R.attr.shapeAppearance && attributeNameResource != R.attr.shapeAppearanceOverlay) {
                        int i10 = i8 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i9, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i8] = attributeNameResource;
                        i8 = i10;
                    }
                }
                lVar.a(StateSet.trimStateSet(iArr2, i8), nVarA);
            }
        }
    }

    public static z b(Context context, TypedArray typedArray, int i8) {
        XmlResourceParser xml;
        AttributeSet attributeSetAsAttributeSet;
        int next;
        int resourceId = typedArray.getResourceId(i8, 0);
        if (resourceId == 0 || !Objects.equals(context.getResources().getResourceTypeName(resourceId), "xml")) {
            return null;
        }
        n6.l lVar = new n6.l(1);
        lVar.d();
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
            lVar.d();
        }
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        if (xml.getName().equals("selector")) {
            a(lVar, context, xml, attributeSetAsAttributeSet, context.getTheme());
        }
        xml.close();
        if (lVar.f4056b == 0) {
            return null;
        }
        return new z(lVar);
    }

    public final n c() {
        n nVar = this.f5553b;
        y yVar = this.f5558h;
        y yVar2 = this.f5557g;
        y yVar3 = this.f5556f;
        y yVar4 = this.f5555e;
        if (yVar4 == null && yVar3 == null && yVar2 == null && yVar == null) {
            return nVar;
        }
        m mVarF = nVar.f();
        if (yVar4 != null) {
            mVarF.f5500e = yVar4.f5550b;
        }
        if (yVar3 != null) {
            mVarF.f5501f = yVar3.f5550b;
        }
        if (yVar2 != null) {
            mVarF.f5503h = yVar2.f5550b;
        }
        if (yVar != null) {
            mVarF.f5502g = yVar.f5550b;
        }
        return mVarF.a();
    }

    public final boolean d() {
        y yVar;
        y yVar2;
        y yVar3;
        y yVar4;
        return this.f5552a > 1 || ((yVar = this.f5555e) != null && yVar.f5549a > 1) || (((yVar2 = this.f5556f) != null && yVar2.f5549a > 1) || (((yVar3 = this.f5557g) != null && yVar3.f5549a > 1) || ((yVar4 = this.f5558h) != null && yVar4.f5549a > 1)));
    }
}
