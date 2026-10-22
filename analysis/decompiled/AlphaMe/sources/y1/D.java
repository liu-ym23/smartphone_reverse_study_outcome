package y1;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import com.baidu.platform.comapi.map.MapController;
import com.stepos.alphame.R;
import java.io.IOException;
import m1.AbstractC0769a;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class D {

    /* renamed from: a, reason: collision with root package name */
    public int f16192a;

    /* renamed from: b, reason: collision with root package name */
    public com.google.android.gms.common.api.internal.p f16193b;

    /* renamed from: c, reason: collision with root package name */
    public int[][] f16194c;

    /* renamed from: d, reason: collision with root package name */
    public com.google.android.gms.common.api.internal.p[] f16195d;

    public final void a(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
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
                int[] iArr = AbstractC0769a.f13531F;
                TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                TypedValue typedValuePeekValue = typedArrayObtainAttributes.peekValue(0);
                C c4 = null;
                if (typedValuePeekValue != null) {
                    int i4 = typedValuePeekValue.type;
                    if (i4 == 5) {
                        c4 = new C(2, TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArrayObtainAttributes.getResources().getDisplayMetrics()));
                    } else if (i4 == 6) {
                        c4 = new C(1, typedValuePeekValue.getFraction(1.0f, 1.0f));
                    }
                }
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i5 = 0;
                for (int i6 = 0; i6 < attributeCount; i6++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i6);
                    if (attributeNameResource != R.attr.widthChange) {
                        int i7 = i5 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i6, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i5] = attributeNameResource;
                        i5 = i7;
                    }
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr2, i5);
                com.google.android.gms.common.api.internal.p pVar = new com.google.android.gms.common.api.internal.p(9, c4);
                int i8 = this.f16192a;
                if (i8 == 0 || iArrTrimStateSet.length == 0) {
                    this.f16193b = pVar;
                }
                int[][] iArr3 = this.f16194c;
                if (i8 >= iArr3.length) {
                    int i9 = i8 + 10;
                    int[][] iArr4 = new int[i9][];
                    System.arraycopy(iArr3, 0, iArr4, 0, i8);
                    this.f16194c = iArr4;
                    com.google.android.gms.common.api.internal.p[] pVarArr = new com.google.android.gms.common.api.internal.p[i9];
                    System.arraycopy(this.f16195d, 0, pVarArr, 0, i8);
                    this.f16195d = pVarArr;
                }
                int[][] iArr5 = this.f16194c;
                int i10 = this.f16192a;
                iArr5[i10] = iArrTrimStateSet;
                this.f16195d[i10] = pVar;
                this.f16192a = i10 + 1;
            }
        }
    }
}
