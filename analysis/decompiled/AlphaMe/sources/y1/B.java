package y1;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.baidu.platform.comapi.map.MapController;
import com.stepos.alphame.R;
import java.io.IOException;
import java.util.Objects;
import m1.AbstractC0769a;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class B {

    /* renamed from: a, reason: collision with root package name */
    public final int f16182a;

    /* renamed from: b, reason: collision with root package name */
    public final n f16183b;

    /* renamed from: c, reason: collision with root package name */
    public final int[][] f16184c;

    /* renamed from: d, reason: collision with root package name */
    public final n[] f16185d;

    /* renamed from: e, reason: collision with root package name */
    public final z f16186e;

    /* renamed from: f, reason: collision with root package name */
    public final z f16187f;

    /* renamed from: g, reason: collision with root package name */
    public final z f16188g;

    /* renamed from: h, reason: collision with root package name */
    public final z f16189h;

    public B(C0986A c0986a) {
        this.f16182a = c0986a.f16174a;
        this.f16183b = c0986a.f16175b;
        this.f16184c = c0986a.f16176c;
        this.f16185d = c0986a.f16177d;
        this.f16186e = c0986a.f16178e;
        this.f16187f = c0986a.f16179f;
        this.f16188g = c0986a.f16180g;
        this.f16189h = c0986a.f16181h;
    }

    public static void a(C0986A c0986a, Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
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
            if (next == 2 && depth2 <= depth && xmlResourceParser.getName().equals(MapController.ITEM_LAYER_TAG)) {
                Resources resources = context.getResources();
                int[] iArr = AbstractC0769a.f13556v;
                TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                n nVarA = n.a(context, typedArrayObtainAttributes.getResourceId(0, 0), typedArrayObtainAttributes.getResourceId(1, 0), new C0987a(0)).a();
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i4 = 0;
                for (int i5 = 0; i5 < attributeCount; i5++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i5);
                    if (attributeNameResource != R.attr.shapeAppearance && attributeNameResource != R.attr.shapeAppearanceOverlay) {
                        int i6 = i4 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i5, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i4] = attributeNameResource;
                        i4 = i6;
                    }
                }
                c0986a.a(StateSet.trimStateSet(iArr2, i4), nVarA);
            }
        }
    }

    public static B b(Context context, TypedArray typedArray, int i4) {
        XmlResourceParser xml;
        int next;
        int resourceId = typedArray.getResourceId(i4, 0);
        if (resourceId == 0 || !Objects.equals(context.getResources().getResourceTypeName(resourceId), "xml")) {
            return null;
        }
        C0986A c0986a = new C0986A();
        c0986a.c();
        try {
            xml = context.getResources().getXml(resourceId);
        } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
            c0986a.c();
        }
        try {
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
                a(c0986a, context, xml, attributeSetAsAttributeSet, context.getTheme());
            }
            xml.close();
            return c0986a.b();
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
    }

    public final n c() {
        n nVar = this.f16183b;
        z zVar = this.f16189h;
        z zVar2 = this.f16188g;
        z zVar3 = this.f16187f;
        z zVar4 = this.f16186e;
        if (zVar4 == null && zVar3 == null && zVar2 == null && zVar == null) {
            return nVar;
        }
        m mVarF = nVar.f();
        if (zVar4 != null) {
            mVarF.f16264e = zVar4.f16324b;
        }
        if (zVar3 != null) {
            mVarF.f16265f = zVar3.f16324b;
        }
        if (zVar2 != null) {
            mVarF.f16267h = zVar2.f16324b;
        }
        if (zVar != null) {
            mVarF.f16266g = zVar.f16324b;
        }
        return mVarF.a();
    }

    public final boolean d() {
        if (this.f16182a > 1) {
            return true;
        }
        z zVar = this.f16186e;
        if (zVar != null && zVar.f16323a > 1) {
            return true;
        }
        z zVar2 = this.f16187f;
        if (zVar2 != null && zVar2.f16323a > 1) {
            return true;
        }
        z zVar3 = this.f16188g;
        if (zVar3 != null && zVar3.f16323a > 1) {
            return true;
        }
        z zVar4 = this.f16189h;
        return zVar4 != null && zVar4.f16323a > 1;
    }
}
