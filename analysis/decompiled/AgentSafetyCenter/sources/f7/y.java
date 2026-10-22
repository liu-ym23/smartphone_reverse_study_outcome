package f7;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import com.stepos.agentsafetycenter.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public int f4033a;

    /* renamed from: b, reason: collision with root package name */
    public m f4034b;

    /* renamed from: c, reason: collision with root package name */
    public int[][] f4035c;

    /* renamed from: d, reason: collision with root package name */
    public m[] f4036d;

    public static void a(x xVar, Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
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
                int[] iArr = p6.a.f9820m;
                TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                m mVarA = m.a(context, typedArrayObtainAttributes.getResourceId(0, 0), typedArrayObtainAttributes.getResourceId(1, 0), new a(0)).a();
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i = 0;
                for (int i3 = 0; i3 < attributeCount; i3++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i3);
                    if (attributeNameResource != R.attr.shapeAppearance && attributeNameResource != R.attr.shapeAppearanceOverlay) {
                        int i10 = i + 1;
                        if (!attributeSet.getAttributeBooleanValue(i3, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i] = attributeNameResource;
                        i = i10;
                    }
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr2, i);
                int i11 = xVar.f4029a;
                if (i11 == 0 || iArrTrimStateSet.length == 0) {
                    xVar.f4030b = mVarA;
                }
                int[][] iArr3 = (int[][]) xVar.f4031c;
                if (i11 >= iArr3.length) {
                    int i12 = i11 + 10;
                    int[][] iArr4 = new int[i12][];
                    System.arraycopy(iArr3, 0, iArr4, 0, i11);
                    xVar.f4031c = iArr4;
                    m[] mVarArr = new m[i12];
                    System.arraycopy((m[]) xVar.f4032d, 0, mVarArr, 0, i11);
                    xVar.f4032d = mVarArr;
                }
                int[][] iArr5 = (int[][]) xVar.f4031c;
                int i13 = xVar.f4029a;
                iArr5[i13] = iArrTrimStateSet;
                ((m[]) xVar.f4032d)[i13] = mVarA;
                xVar.f4029a = i13 + 1;
            }
        }
    }
}
