package y1;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import com.baidu.platform.comapi.map.MapController;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import java.io.IOException;
import m1.AbstractC0769a;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public int f16323a;

    /* renamed from: b, reason: collision with root package name */
    public InterfaceC0990d f16324b;

    /* renamed from: c, reason: collision with root package name */
    public int[][] f16325c = new int[10][];

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC0990d[] f16326d = new InterfaceC0990d[10];

    public static z b(InterfaceC0990d interfaceC0990d) {
        z zVar = new z();
        zVar.a(StateSet.WILD_CARD, interfaceC0990d);
        return zVar;
    }

    public final void a(int[] iArr, InterfaceC0990d interfaceC0990d) {
        int i4 = this.f16323a;
        if (i4 == 0 || iArr.length == 0) {
            this.f16324b = interfaceC0990d;
        }
        int[][] iArr2 = this.f16325c;
        if (i4 >= iArr2.length) {
            int i5 = i4 + 10;
            int[][] iArr3 = new int[i5][];
            System.arraycopy(iArr2, 0, iArr3, 0, i4);
            this.f16325c = iArr3;
            InterfaceC0990d[] interfaceC0990dArr = new InterfaceC0990d[i5];
            System.arraycopy(this.f16326d, 0, interfaceC0990dArr, 0, i4);
            this.f16326d = interfaceC0990dArr;
        }
        int[][] iArr4 = this.f16325c;
        int i6 = this.f16323a;
        iArr4[i6] = iArr;
        this.f16326d[i6] = interfaceC0990d;
        this.f16323a = i6 + 1;
    }

    public final InterfaceC0990d c(int[] iArr) {
        int i4;
        int[][] iArr2 = this.f16325c;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i4 = -1;
            if (i6 >= this.f16323a) {
                i6 = -1;
                break;
            }
            if (StateSet.stateSetMatches(iArr2[i6], iArr)) {
                break;
            }
            i6++;
        }
        if (i6 < 0) {
            int[] iArr3 = StateSet.WILD_CARD;
            int[][] iArr4 = this.f16325c;
            while (true) {
                if (i5 >= this.f16323a) {
                    break;
                }
                if (StateSet.stateSetMatches(iArr4[i5], iArr3)) {
                    i4 = i5;
                    break;
                }
                i5++;
            }
            i6 = i4;
        }
        return i6 < 0 ? this.f16324b : this.f16326d[i6];
    }

    public final void d(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
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
                int[] iArr = AbstractC0769a.f13528C;
                TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                InterfaceC0990d interfaceC0990dC = n.c(typedArrayObtainAttributes, 5, new C0987a(Property.DEFAULT_FLOAT_VALUE));
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i4 = 0;
                for (int i5 = 0; i5 < attributeCount; i5++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i5);
                    if (attributeNameResource != R.attr.cornerSize) {
                        int i6 = i4 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i5, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i4] = attributeNameResource;
                        i4 = i6;
                    }
                }
                a(StateSet.trimStateSet(iArr2, i4), interfaceC0990dC);
            }
        }
    }
}
