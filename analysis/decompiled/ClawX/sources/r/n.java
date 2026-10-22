package r;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.crypto.params.SkeinParameters;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n {
    public static final int[] d = {0, 4, 8};

    /* renamed from: e, reason: collision with root package name */
    public static final SparseIntArray f5045e;

    /* renamed from: f, reason: collision with root package name */
    public static final SparseIntArray f5046f;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f5047a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final boolean f5048b = true;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f5049c = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f5045e = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f5046f = sparseIntArray2;
        sparseIntArray.append(81, 25);
        sparseIntArray.append(82, 26);
        sparseIntArray.append(84, 29);
        sparseIntArray.append(85, 30);
        sparseIntArray.append(91, 36);
        sparseIntArray.append(90, 35);
        sparseIntArray.append(62, 4);
        sparseIntArray.append(61, 3);
        sparseIntArray.append(57, 1);
        sparseIntArray.append(59, 91);
        sparseIntArray.append(58, 92);
        sparseIntArray.append(100, 6);
        sparseIntArray.append(101, 7);
        sparseIntArray.append(69, 17);
        sparseIntArray.append(70, 18);
        sparseIntArray.append(71, 19);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(86, 32);
        sparseIntArray.append(87, 33);
        sparseIntArray.append(68, 10);
        sparseIntArray.append(67, 9);
        sparseIntArray.append(105, 13);
        sparseIntArray.append(108, 16);
        sparseIntArray.append(106, 14);
        sparseIntArray.append(103, 11);
        sparseIntArray.append(107, 15);
        sparseIntArray.append(104, 12);
        sparseIntArray.append(94, 40);
        sparseIntArray.append(79, 39);
        sparseIntArray.append(78, 41);
        sparseIntArray.append(93, 42);
        sparseIntArray.append(77, 20);
        sparseIntArray.append(92, 37);
        sparseIntArray.append(66, 5);
        sparseIntArray.append(80, 87);
        sparseIntArray.append(89, 87);
        sparseIntArray.append(83, 87);
        sparseIntArray.append(60, 87);
        sparseIntArray.append(56, 87);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(95, 95);
        sparseIntArray.append(72, 96);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(96, 54);
        sparseIntArray.append(73, 55);
        sparseIntArray.append(97, 56);
        sparseIntArray.append(74, 57);
        sparseIntArray.append(98, 58);
        sparseIntArray.append(75, 59);
        sparseIntArray.append(63, 61);
        sparseIntArray.append(65, 62);
        sparseIntArray.append(64, 63);
        sparseIntArray.append(28, 64);
        sparseIntArray.append(120, 65);
        sparseIntArray.append(35, 66);
        sparseIntArray.append(121, 67);
        sparseIntArray.append(112, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(111, 68);
        sparseIntArray.append(99, 69);
        sparseIntArray.append(76, 70);
        sparseIntArray.append(110, 97);
        sparseIntArray.append(32, 71);
        sparseIntArray.append(30, 72);
        sparseIntArray.append(31, 73);
        sparseIntArray.append(33, 74);
        sparseIntArray.append(29, 75);
        sparseIntArray.append(113, 76);
        sparseIntArray.append(88, 77);
        sparseIntArray.append(122, 78);
        sparseIntArray.append(55, 80);
        sparseIntArray.append(54, 81);
        sparseIntArray.append(115, 82);
        sparseIntArray.append(119, 83);
        sparseIntArray.append(118, 84);
        sparseIntArray.append(117, 85);
        sparseIntArray.append(116, 86);
        sparseIntArray2.append(84, 6);
        sparseIntArray2.append(84, 7);
        sparseIntArray2.append(0, 27);
        sparseIntArray2.append(88, 13);
        sparseIntArray2.append(91, 16);
        sparseIntArray2.append(89, 14);
        sparseIntArray2.append(86, 11);
        sparseIntArray2.append(90, 15);
        sparseIntArray2.append(87, 12);
        sparseIntArray2.append(77, 40);
        sparseIntArray2.append(70, 39);
        sparseIntArray2.append(69, 41);
        sparseIntArray2.append(76, 42);
        sparseIntArray2.append(68, 20);
        sparseIntArray2.append(75, 37);
        sparseIntArray2.append(59, 5);
        sparseIntArray2.append(71, 87);
        sparseIntArray2.append(74, 87);
        sparseIntArray2.append(72, 87);
        sparseIntArray2.append(56, 87);
        sparseIntArray2.append(55, 87);
        sparseIntArray2.append(5, 24);
        sparseIntArray2.append(7, 28);
        sparseIntArray2.append(23, 31);
        sparseIntArray2.append(24, 8);
        sparseIntArray2.append(6, 34);
        sparseIntArray2.append(8, 2);
        sparseIntArray2.append(3, 23);
        sparseIntArray2.append(4, 21);
        sparseIntArray2.append(78, 95);
        sparseIntArray2.append(63, 96);
        sparseIntArray2.append(2, 22);
        sparseIntArray2.append(13, 43);
        sparseIntArray2.append(26, 44);
        sparseIntArray2.append(21, 45);
        sparseIntArray2.append(22, 46);
        sparseIntArray2.append(20, 60);
        sparseIntArray2.append(18, 47);
        sparseIntArray2.append(19, 48);
        sparseIntArray2.append(14, 49);
        sparseIntArray2.append(15, 50);
        sparseIntArray2.append(16, 51);
        sparseIntArray2.append(17, 52);
        sparseIntArray2.append(25, 53);
        sparseIntArray2.append(79, 54);
        sparseIntArray2.append(64, 55);
        sparseIntArray2.append(80, 56);
        sparseIntArray2.append(65, 57);
        sparseIntArray2.append(81, 58);
        sparseIntArray2.append(66, 59);
        sparseIntArray2.append(58, 62);
        sparseIntArray2.append(57, 63);
        sparseIntArray2.append(28, 64);
        sparseIntArray2.append(104, 65);
        sparseIntArray2.append(34, 66);
        sparseIntArray2.append(105, 67);
        sparseIntArray2.append(95, 79);
        sparseIntArray2.append(1, 38);
        sparseIntArray2.append(96, 98);
        sparseIntArray2.append(94, 68);
        sparseIntArray2.append(82, 69);
        sparseIntArray2.append(67, 70);
        sparseIntArray2.append(32, 71);
        sparseIntArray2.append(30, 72);
        sparseIntArray2.append(31, 73);
        sparseIntArray2.append(33, 74);
        sparseIntArray2.append(29, 75);
        sparseIntArray2.append(97, 76);
        sparseIntArray2.append(73, 77);
        sparseIntArray2.append(106, 78);
        sparseIntArray2.append(54, 80);
        sparseIntArray2.append(53, 81);
        sparseIntArray2.append(99, 82);
        sparseIntArray2.append(103, 83);
        sparseIntArray2.append(102, 84);
        sparseIntArray2.append(101, 85);
        sparseIntArray2.append(100, 86);
        sparseIntArray2.append(93, 97);
    }

    public static int[] c(a aVar, String str) throws IllegalAccessException, IllegalArgumentException {
        int iIntValue;
        String[] strArrSplit = str.split(",");
        Context context = aVar.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i8 = 0;
        int i9 = 0;
        while (i8 < strArrSplit.length) {
            String strTrim = strArrSplit[i8].trim();
            Object obj = null;
            try {
                iIntValue = q.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && aVar.isInEditMode() && (aVar.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) aVar.getParent();
                if (strTrim != null) {
                    HashMap map = constraintLayout.f371n;
                    if (map != null && map.containsKey(strTrim)) {
                        obj = constraintLayout.f371n.get(strTrim);
                    }
                } else {
                    constraintLayout.getClass();
                }
                if (obj != null && (obj instanceof Integer)) {
                    iIntValue = ((Integer) obj).intValue();
                }
            }
            iArr[i9] = iIntValue;
            i8++;
            i9++;
        }
        return i9 != strArrSplit.length ? Arrays.copyOf(iArr, i9) : iArr;
    }

    public static i d(Context context, AttributeSet attributeSet, boolean z) {
        int i8;
        int i9;
        i iVar = new i();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z ? r.f5052c : r.f5050a);
        l lVar = iVar.f4979b;
        m mVar = iVar.f4981e;
        k kVar = iVar.f4980c;
        j jVar = iVar.d;
        int[] iArr = d;
        String[] strArr = n.a.f3935a;
        SparseIntArray sparseIntArray = f5045e;
        if (z) {
            h hVar = new h();
            hVar.f4967a = new int[10];
            hVar.f4968b = new int[10];
            hVar.f4969c = 0;
            hVar.d = new int[10];
            hVar.f4970e = new float[10];
            hVar.f4971f = 0;
            hVar.f4972g = new int[5];
            hVar.f4973h = new String[5];
            hVar.f4974i = 0;
            hVar.f4975j = new int[4];
            hVar.f4976k = new boolean[4];
            hVar.f4977l = 0;
            kVar.getClass();
            jVar.getClass();
            mVar.getClass();
            int i10 = 0;
            for (int indexCount = typedArrayObtainStyledAttributes.getIndexCount(); i10 < indexCount; indexCount = i9) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                int i11 = i10;
                switch (f5046f.get(index)) {
                    case 2:
                        i9 = indexCount;
                        hVar.b(2, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.H));
                        continue;
                        i10 = i11 + 1;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case BERTags.GRAPHIC_STRING /* 25 */:
                    case BERTags.VISIBLE_STRING /* 26 */:
                    case BERTags.UNRESTRICTED_STRING /* 29 */:
                    case 30:
                    case 32:
                    case BERTags.DATE_TIME /* 33 */:
                    case BERTags.OBJECT_IDENTIFIER_IRI /* 35 */:
                    case BERTags.RELATIVE_OID_IRI /* 36 */:
                    case 61:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    default:
                        StringBuilder sb = new StringBuilder("Unknown attribute 0x");
                        i9 = indexCount;
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(sparseIntArray.get(index));
                        Log.w("ConstraintSet", sb.toString());
                        break;
                    case 5:
                        i9 = indexCount;
                        hVar.c(5, typedArrayObtainStyledAttributes.getString(index));
                        continue;
                        i10 = i11 + 1;
                    case 6:
                        i9 = indexCount;
                        hVar.b(6, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, jVar.B));
                        break;
                    case 7:
                        i9 = indexCount;
                        hVar.b(7, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, jVar.C));
                        break;
                    case 8:
                        i9 = indexCount;
                        hVar.b(8, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.I));
                        break;
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        i9 = indexCount;
                        hVar.b(11, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.O));
                        break;
                    case 12:
                        i9 = indexCount;
                        hVar.b(12, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.P));
                        break;
                    case BERTags.RELATIVE_OID /* 13 */:
                        i9 = indexCount;
                        hVar.b(13, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.L));
                        break;
                    case BERTags.TIME /* 14 */:
                        i9 = indexCount;
                        hVar.b(14, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.N));
                        break;
                    case 15:
                        i9 = indexCount;
                        hVar.b(15, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.Q));
                        break;
                    case 16:
                        i9 = indexCount;
                        hVar.b(16, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.M));
                        break;
                    case 17:
                        i9 = indexCount;
                        hVar.b(17, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, jVar.d));
                        break;
                    case BERTags.NUMERIC_STRING /* 18 */:
                        i9 = indexCount;
                        hVar.b(18, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, jVar.f4991e));
                        break;
                    case 19:
                        i9 = indexCount;
                        hVar.a(19, typedArrayObtainStyledAttributes.getFloat(index, jVar.f4993f));
                        break;
                    case 20:
                        i9 = indexCount;
                        hVar.a(20, typedArrayObtainStyledAttributes.getFloat(index, jVar.f5017v));
                        break;
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        i9 = indexCount;
                        hVar.b(21, typedArrayObtainStyledAttributes.getLayoutDimension(index, jVar.f4988c));
                        break;
                    case BERTags.IA5_STRING /* 22 */:
                        i9 = indexCount;
                        hVar.b(22, iArr[typedArrayObtainStyledAttributes.getInt(index, lVar.f5029a)]);
                        break;
                    case BERTags.UTC_TIME /* 23 */:
                        i9 = indexCount;
                        hVar.b(23, typedArrayObtainStyledAttributes.getLayoutDimension(index, jVar.f4986b));
                        break;
                    case 24:
                        i9 = indexCount;
                        hVar.b(24, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.E));
                        break;
                    case BERTags.GENERAL_STRING /* 27 */:
                        i9 = indexCount;
                        hVar.b(27, typedArrayObtainStyledAttributes.getInt(index, jVar.D));
                        break;
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        i9 = indexCount;
                        hVar.b(28, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.F));
                        break;
                    case BERTags.DATE /* 31 */:
                        i9 = indexCount;
                        hVar.b(31, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.J));
                        break;
                    case BERTags.DURATION /* 34 */:
                        i9 = indexCount;
                        hVar.b(34, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.G));
                        break;
                    case 37:
                        i9 = indexCount;
                        hVar.a(37, typedArrayObtainStyledAttributes.getFloat(index, jVar.f5018w));
                        break;
                    case 38:
                        i9 = indexCount;
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, iVar.f4978a);
                        iVar.f4978a = resourceId;
                        hVar.b(38, resourceId);
                        break;
                    case 39:
                        i9 = indexCount;
                        hVar.a(39, typedArrayObtainStyledAttributes.getFloat(index, jVar.T));
                        break;
                    case 40:
                        i9 = indexCount;
                        hVar.a(40, typedArrayObtainStyledAttributes.getFloat(index, jVar.S));
                        break;
                    case 41:
                        i9 = indexCount;
                        hVar.b(41, typedArrayObtainStyledAttributes.getInt(index, jVar.U));
                        break;
                    case 42:
                        i9 = indexCount;
                        hVar.b(42, typedArrayObtainStyledAttributes.getInt(index, jVar.V));
                        break;
                    case 43:
                        i9 = indexCount;
                        hVar.a(43, typedArrayObtainStyledAttributes.getFloat(index, lVar.f5031c));
                        break;
                    case 44:
                        i9 = indexCount;
                        hVar.d(44, true);
                        hVar.a(44, typedArrayObtainStyledAttributes.getDimension(index, mVar.f5044m));
                        break;
                    case 45:
                        i9 = indexCount;
                        hVar.a(45, typedArrayObtainStyledAttributes.getFloat(index, mVar.f5034b));
                        break;
                    case 46:
                        i9 = indexCount;
                        hVar.a(46, typedArrayObtainStyledAttributes.getFloat(index, mVar.f5035c));
                        break;
                    case 47:
                        i9 = indexCount;
                        hVar.a(47, typedArrayObtainStyledAttributes.getFloat(index, mVar.d));
                        break;
                    case 48:
                        i9 = indexCount;
                        hVar.a(48, typedArrayObtainStyledAttributes.getFloat(index, mVar.f5036e));
                        break;
                    case 49:
                        i9 = indexCount;
                        hVar.a(49, typedArrayObtainStyledAttributes.getDimension(index, mVar.f5037f));
                        break;
                    case 50:
                        i9 = indexCount;
                        hVar.a(50, typedArrayObtainStyledAttributes.getDimension(index, mVar.f5038g));
                        break;
                    case 51:
                        i9 = indexCount;
                        hVar.a(51, typedArrayObtainStyledAttributes.getDimension(index, mVar.f5040i));
                        break;
                    case 52:
                        i9 = indexCount;
                        hVar.a(52, typedArrayObtainStyledAttributes.getDimension(index, mVar.f5041j));
                        break;
                    case 53:
                        i9 = indexCount;
                        hVar.a(53, typedArrayObtainStyledAttributes.getDimension(index, mVar.f5042k));
                        break;
                    case 54:
                        i9 = indexCount;
                        hVar.b(54, typedArrayObtainStyledAttributes.getInt(index, jVar.W));
                        break;
                    case 55:
                        i9 = indexCount;
                        hVar.b(55, typedArrayObtainStyledAttributes.getInt(index, jVar.X));
                        break;
                    case 56:
                        i9 = indexCount;
                        hVar.b(56, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.Y));
                        break;
                    case 57:
                        i9 = indexCount;
                        hVar.b(57, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.Z));
                        break;
                    case 58:
                        i9 = indexCount;
                        hVar.b(58, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f4985a0));
                        break;
                    case 59:
                        i9 = indexCount;
                        hVar.b(59, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f4987b0));
                        break;
                    case 60:
                        i9 = indexCount;
                        hVar.a(60, typedArrayObtainStyledAttributes.getFloat(index, mVar.f5033a));
                        break;
                    case 62:
                        i9 = indexCount;
                        hVar.b(62, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.z));
                        break;
                    case SkeinParameters.PARAM_TYPE_OUTPUT /* 63 */:
                        i9 = indexCount;
                        hVar.a(63, typedArrayObtainStyledAttributes.getFloat(index, jVar.A));
                        break;
                    case 64:
                        i9 = indexCount;
                        hVar.b(64, f(typedArrayObtainStyledAttributes, index, kVar.f5021a));
                        break;
                    case 65:
                        i9 = indexCount;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            hVar.c(65, typedArrayObtainStyledAttributes.getString(index));
                            break;
                        } else {
                            hVar.c(65, strArr[typedArrayObtainStyledAttributes.getInteger(index, 0)]);
                            break;
                        }
                    case 66:
                        i9 = indexCount;
                        hVar.b(66, typedArrayObtainStyledAttributes.getInt(index, 0));
                        break;
                    case 67:
                        i9 = indexCount;
                        hVar.a(67, typedArrayObtainStyledAttributes.getFloat(index, kVar.f5024e));
                        break;
                    case 68:
                        i9 = indexCount;
                        hVar.a(68, typedArrayObtainStyledAttributes.getFloat(index, lVar.d));
                        break;
                    case 69:
                        i9 = indexCount;
                        hVar.a(69, typedArrayObtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 70:
                        i9 = indexCount;
                        hVar.a(70, typedArrayObtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 71:
                        i9 = indexCount;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i9 = indexCount;
                        hVar.b(72, typedArrayObtainStyledAttributes.getInt(index, jVar.f4992e0));
                        break;
                    case 73:
                        i9 = indexCount;
                        hVar.b(73, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f4994f0));
                        break;
                    case 74:
                        i9 = indexCount;
                        hVar.c(74, typedArrayObtainStyledAttributes.getString(index));
                        break;
                    case 75:
                        i9 = indexCount;
                        hVar.d(75, typedArrayObtainStyledAttributes.getBoolean(index, jVar.f5007m0));
                        break;
                    case 76:
                        i9 = indexCount;
                        hVar.b(76, typedArrayObtainStyledAttributes.getInt(index, kVar.f5023c));
                        break;
                    case 77:
                        i9 = indexCount;
                        hVar.c(77, typedArrayObtainStyledAttributes.getString(index));
                        break;
                    case 78:
                        i9 = indexCount;
                        hVar.b(78, typedArrayObtainStyledAttributes.getInt(index, lVar.f5030b));
                        break;
                    case 79:
                        i9 = indexCount;
                        hVar.a(79, typedArrayObtainStyledAttributes.getFloat(index, kVar.d));
                        break;
                    case 80:
                        i9 = indexCount;
                        hVar.d(80, typedArrayObtainStyledAttributes.getBoolean(index, jVar.k0));
                        break;
                    case 81:
                        i9 = indexCount;
                        hVar.d(81, typedArrayObtainStyledAttributes.getBoolean(index, jVar.f5005l0));
                        break;
                    case 82:
                        i9 = indexCount;
                        hVar.b(82, typedArrayObtainStyledAttributes.getInteger(index, kVar.f5022b));
                        break;
                    case 83:
                        i9 = indexCount;
                        hVar.b(83, f(typedArrayObtainStyledAttributes, index, mVar.f5039h));
                        break;
                    case 84:
                        i9 = indexCount;
                        hVar.b(84, typedArrayObtainStyledAttributes.getInteger(index, kVar.f5026g));
                        break;
                    case 85:
                        i9 = indexCount;
                        hVar.a(85, typedArrayObtainStyledAttributes.getFloat(index, kVar.f5025f));
                        break;
                    case 86:
                        i9 = indexCount;
                        int i12 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i12 == 1) {
                            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            kVar.f5028i = resourceId2;
                            hVar.b(89, resourceId2);
                            if (kVar.f5028i != -1) {
                                hVar.b(88, -2);
                                break;
                            }
                        } else if (i12 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            kVar.f5027h = string;
                            hVar.c(90, string);
                            if (kVar.f5027h.indexOf("/") > 0) {
                                int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                kVar.f5028i = resourceId3;
                                hVar.b(89, resourceId3);
                                hVar.b(88, -2);
                                break;
                            } else {
                                hVar.b(88, -1);
                                break;
                            }
                        } else {
                            hVar.b(88, typedArrayObtainStyledAttributes.getInteger(index, kVar.f5028i));
                            break;
                        }
                        break;
                    case 87:
                        i9 = indexCount;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                        break;
                    case 93:
                        i9 = indexCount;
                        hVar.b(93, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.K));
                        break;
                    case 94:
                        i9 = indexCount;
                        hVar.b(94, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.R));
                        break;
                    case 95:
                        i9 = indexCount;
                        g(hVar, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 96:
                        i9 = indexCount;
                        g(hVar, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    case 97:
                        i9 = indexCount;
                        hVar.b(97, typedArrayObtainStyledAttributes.getInt(index, jVar.f5009n0));
                        break;
                    case 98:
                        i9 = indexCount;
                        int i13 = q.a.f4837t;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index);
                            break;
                        } else {
                            iVar.f4978a = typedArrayObtainStyledAttributes.getResourceId(index, iVar.f4978a);
                            break;
                        }
                }
                i10 = i11 + 1;
            }
        } else {
            int i14 = 0;
            for (int indexCount2 = typedArrayObtainStyledAttributes.getIndexCount(); i14 < indexCount2; indexCount2 = i8) {
                int index2 = typedArrayObtainStyledAttributes.getIndex(i14);
                if (index2 != 1 && 23 != index2) {
                    if (24 != index2) {
                        kVar.getClass();
                        jVar.getClass();
                        mVar.getClass();
                    }
                }
                switch (sparseIntArray.get(index2)) {
                    case 1:
                        i8 = indexCount2;
                        jVar.f5010o = f(typedArrayObtainStyledAttributes, index2, jVar.f5010o);
                        continue;
                        i14++;
                    case 2:
                        i8 = indexCount2;
                        jVar.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.H);
                        continue;
                        i14++;
                    case 3:
                        i8 = indexCount2;
                        jVar.f5008n = f(typedArrayObtainStyledAttributes, index2, jVar.f5008n);
                        continue;
                        i14++;
                    case 4:
                        i8 = indexCount2;
                        jVar.f5006m = f(typedArrayObtainStyledAttributes, index2, jVar.f5006m);
                        continue;
                        i14++;
                    case 5:
                        i8 = indexCount2;
                        jVar.f5019x = typedArrayObtainStyledAttributes.getString(index2);
                        continue;
                        i14++;
                    case 6:
                        i8 = indexCount2;
                        jVar.B = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, jVar.B);
                        continue;
                        i14++;
                    case 7:
                        i8 = indexCount2;
                        jVar.C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, jVar.C);
                        continue;
                        i14++;
                    case 8:
                        i8 = indexCount2;
                        jVar.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.I);
                        continue;
                        i14++;
                    case 9:
                        i8 = indexCount2;
                        jVar.f5016u = f(typedArrayObtainStyledAttributes, index2, jVar.f5016u);
                        continue;
                        i14++;
                    case 10:
                        i8 = indexCount2;
                        jVar.f5015t = f(typedArrayObtainStyledAttributes, index2, jVar.f5015t);
                        continue;
                        i14++;
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        i8 = indexCount2;
                        jVar.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.O);
                        continue;
                        i14++;
                    case 12:
                        i8 = indexCount2;
                        jVar.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.P);
                        continue;
                        i14++;
                    case BERTags.RELATIVE_OID /* 13 */:
                        i8 = indexCount2;
                        jVar.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.L);
                        continue;
                        i14++;
                    case BERTags.TIME /* 14 */:
                        i8 = indexCount2;
                        jVar.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.N);
                        continue;
                        i14++;
                    case 15:
                        i8 = indexCount2;
                        jVar.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.Q);
                        continue;
                        i14++;
                    case 16:
                        i8 = indexCount2;
                        jVar.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.M);
                        continue;
                        i14++;
                    case 17:
                        i8 = indexCount2;
                        jVar.d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, jVar.d);
                        continue;
                        i14++;
                    case BERTags.NUMERIC_STRING /* 18 */:
                        i8 = indexCount2;
                        jVar.f4991e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, jVar.f4991e);
                        continue;
                        i14++;
                    case 19:
                        i8 = indexCount2;
                        jVar.f4993f = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f4993f);
                        continue;
                        i14++;
                    case 20:
                        i8 = indexCount2;
                        jVar.f5017v = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f5017v);
                        continue;
                        i14++;
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        i8 = indexCount2;
                        jVar.f4988c = typedArrayObtainStyledAttributes.getLayoutDimension(index2, jVar.f4988c);
                        continue;
                        i14++;
                    case BERTags.IA5_STRING /* 22 */:
                        i8 = indexCount2;
                        int i15 = typedArrayObtainStyledAttributes.getInt(index2, lVar.f5029a);
                        lVar.f5029a = i15;
                        lVar.f5029a = iArr[i15];
                        continue;
                        i14++;
                    case BERTags.UTC_TIME /* 23 */:
                        i8 = indexCount2;
                        jVar.f4986b = typedArrayObtainStyledAttributes.getLayoutDimension(index2, jVar.f4986b);
                        continue;
                        i14++;
                    case 24:
                        i8 = indexCount2;
                        jVar.E = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.E);
                        continue;
                        i14++;
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        i8 = indexCount2;
                        jVar.f4995g = f(typedArrayObtainStyledAttributes, index2, jVar.f4995g);
                        continue;
                        i14++;
                    case BERTags.VISIBLE_STRING /* 26 */:
                        i8 = indexCount2;
                        jVar.f4997h = f(typedArrayObtainStyledAttributes, index2, jVar.f4997h);
                        continue;
                        i14++;
                    case BERTags.GENERAL_STRING /* 27 */:
                        i8 = indexCount2;
                        jVar.D = typedArrayObtainStyledAttributes.getInt(index2, jVar.D);
                        continue;
                        i14++;
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        i8 = indexCount2;
                        jVar.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.F);
                        continue;
                        i14++;
                    case BERTags.UNRESTRICTED_STRING /* 29 */:
                        i8 = indexCount2;
                        jVar.f4999i = f(typedArrayObtainStyledAttributes, index2, jVar.f4999i);
                        continue;
                        i14++;
                    case 30:
                        i8 = indexCount2;
                        jVar.f5001j = f(typedArrayObtainStyledAttributes, index2, jVar.f5001j);
                        continue;
                        i14++;
                    case BERTags.DATE /* 31 */:
                        i8 = indexCount2;
                        jVar.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.J);
                        continue;
                        i14++;
                    case 32:
                        i8 = indexCount2;
                        jVar.f5013r = f(typedArrayObtainStyledAttributes, index2, jVar.f5013r);
                        continue;
                        i14++;
                    case BERTags.DATE_TIME /* 33 */:
                        i8 = indexCount2;
                        jVar.f5014s = f(typedArrayObtainStyledAttributes, index2, jVar.f5014s);
                        continue;
                        i14++;
                    case BERTags.DURATION /* 34 */:
                        i8 = indexCount2;
                        jVar.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.G);
                        continue;
                        i14++;
                    case BERTags.OBJECT_IDENTIFIER_IRI /* 35 */:
                        i8 = indexCount2;
                        jVar.f5004l = f(typedArrayObtainStyledAttributes, index2, jVar.f5004l);
                        continue;
                        i14++;
                    case BERTags.RELATIVE_OID_IRI /* 36 */:
                        i8 = indexCount2;
                        jVar.f5003k = f(typedArrayObtainStyledAttributes, index2, jVar.f5003k);
                        continue;
                        i14++;
                    case 37:
                        i8 = indexCount2;
                        jVar.f5018w = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f5018w);
                        continue;
                        i14++;
                    case 38:
                        i8 = indexCount2;
                        iVar.f4978a = typedArrayObtainStyledAttributes.getResourceId(index2, iVar.f4978a);
                        continue;
                        i14++;
                    case 39:
                        i8 = indexCount2;
                        jVar.T = typedArrayObtainStyledAttributes.getFloat(index2, jVar.T);
                        continue;
                        i14++;
                    case 40:
                        i8 = indexCount2;
                        jVar.S = typedArrayObtainStyledAttributes.getFloat(index2, jVar.S);
                        continue;
                        i14++;
                    case 41:
                        i8 = indexCount2;
                        jVar.U = typedArrayObtainStyledAttributes.getInt(index2, jVar.U);
                        continue;
                        i14++;
                    case 42:
                        i8 = indexCount2;
                        jVar.V = typedArrayObtainStyledAttributes.getInt(index2, jVar.V);
                        continue;
                        i14++;
                    case 43:
                        i8 = indexCount2;
                        lVar.f5031c = typedArrayObtainStyledAttributes.getFloat(index2, lVar.f5031c);
                        continue;
                        i14++;
                    case 44:
                        i8 = indexCount2;
                        mVar.f5043l = true;
                        mVar.f5044m = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f5044m);
                        continue;
                        i14++;
                    case 45:
                        i8 = indexCount2;
                        mVar.f5034b = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f5034b);
                        continue;
                        i14++;
                    case 46:
                        i8 = indexCount2;
                        mVar.f5035c = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f5035c);
                        continue;
                        i14++;
                    case 47:
                        i8 = indexCount2;
                        mVar.d = typedArrayObtainStyledAttributes.getFloat(index2, mVar.d);
                        continue;
                        i14++;
                    case 48:
                        i8 = indexCount2;
                        mVar.f5036e = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f5036e);
                        continue;
                        i14++;
                    case 49:
                        i8 = indexCount2;
                        mVar.f5037f = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f5037f);
                        continue;
                        i14++;
                    case 50:
                        i8 = indexCount2;
                        mVar.f5038g = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f5038g);
                        continue;
                        i14++;
                    case 51:
                        i8 = indexCount2;
                        mVar.f5040i = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f5040i);
                        continue;
                        i14++;
                    case 52:
                        i8 = indexCount2;
                        mVar.f5041j = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f5041j);
                        continue;
                        i14++;
                    case 53:
                        i8 = indexCount2;
                        mVar.f5042k = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f5042k);
                        continue;
                        i14++;
                    case 54:
                        i8 = indexCount2;
                        jVar.W = typedArrayObtainStyledAttributes.getInt(index2, jVar.W);
                        continue;
                        i14++;
                    case 55:
                        i8 = indexCount2;
                        jVar.X = typedArrayObtainStyledAttributes.getInt(index2, jVar.X);
                        continue;
                        i14++;
                    case 56:
                        i8 = indexCount2;
                        jVar.Y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.Y);
                        continue;
                        i14++;
                    case 57:
                        i8 = indexCount2;
                        jVar.Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.Z);
                        continue;
                        i14++;
                    case 58:
                        i8 = indexCount2;
                        jVar.f4985a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f4985a0);
                        continue;
                        i14++;
                    case 59:
                        i8 = indexCount2;
                        jVar.f4987b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f4987b0);
                        continue;
                        i14++;
                    case 60:
                        i8 = indexCount2;
                        mVar.f5033a = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f5033a);
                        continue;
                        i14++;
                    case 61:
                        i8 = indexCount2;
                        jVar.y = f(typedArrayObtainStyledAttributes, index2, jVar.y);
                        continue;
                        i14++;
                    case 62:
                        i8 = indexCount2;
                        jVar.z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.z);
                        continue;
                        i14++;
                    case SkeinParameters.PARAM_TYPE_OUTPUT /* 63 */:
                        i8 = indexCount2;
                        jVar.A = typedArrayObtainStyledAttributes.getFloat(index2, jVar.A);
                        continue;
                        i14++;
                    case 64:
                        i8 = indexCount2;
                        kVar.f5021a = f(typedArrayObtainStyledAttributes, index2, kVar.f5021a);
                        continue;
                        i14++;
                    case 65:
                        i8 = indexCount2;
                        if (typedArrayObtainStyledAttributes.peekValue(index2).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index2);
                            kVar.getClass();
                            break;
                        } else {
                            String str = strArr[typedArrayObtainStyledAttributes.getInteger(index2, 0)];
                            kVar.getClass();
                            i14++;
                        }
                    case 66:
                        i8 = indexCount2;
                        typedArrayObtainStyledAttributes.getInt(index2, 0);
                        kVar.getClass();
                        continue;
                        i14++;
                    case 67:
                        i8 = indexCount2;
                        kVar.f5024e = typedArrayObtainStyledAttributes.getFloat(index2, kVar.f5024e);
                        break;
                    case 68:
                        i8 = indexCount2;
                        lVar.d = typedArrayObtainStyledAttributes.getFloat(index2, lVar.d);
                        break;
                    case 69:
                        i8 = indexCount2;
                        jVar.f4989c0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 70:
                        i8 = indexCount2;
                        jVar.f4990d0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 71:
                        i8 = indexCount2;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i8 = indexCount2;
                        jVar.f4992e0 = typedArrayObtainStyledAttributes.getInt(index2, jVar.f4992e0);
                        break;
                    case 73:
                        i8 = indexCount2;
                        jVar.f4994f0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f4994f0);
                        break;
                    case 74:
                        i8 = indexCount2;
                        jVar.f5000i0 = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 75:
                        i8 = indexCount2;
                        jVar.f5007m0 = typedArrayObtainStyledAttributes.getBoolean(index2, jVar.f5007m0);
                        break;
                    case 76:
                        i8 = indexCount2;
                        kVar.f5023c = typedArrayObtainStyledAttributes.getInt(index2, kVar.f5023c);
                        break;
                    case 77:
                        i8 = indexCount2;
                        jVar.f5002j0 = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 78:
                        i8 = indexCount2;
                        lVar.f5030b = typedArrayObtainStyledAttributes.getInt(index2, lVar.f5030b);
                        break;
                    case 79:
                        i8 = indexCount2;
                        kVar.d = typedArrayObtainStyledAttributes.getFloat(index2, kVar.d);
                        break;
                    case 80:
                        i8 = indexCount2;
                        jVar.k0 = typedArrayObtainStyledAttributes.getBoolean(index2, jVar.k0);
                        break;
                    case 81:
                        i8 = indexCount2;
                        jVar.f5005l0 = typedArrayObtainStyledAttributes.getBoolean(index2, jVar.f5005l0);
                        break;
                    case 82:
                        i8 = indexCount2;
                        kVar.f5022b = typedArrayObtainStyledAttributes.getInteger(index2, kVar.f5022b);
                        break;
                    case 83:
                        i8 = indexCount2;
                        mVar.f5039h = f(typedArrayObtainStyledAttributes, index2, mVar.f5039h);
                        break;
                    case 84:
                        i8 = indexCount2;
                        kVar.f5026g = typedArrayObtainStyledAttributes.getInteger(index2, kVar.f5026g);
                        break;
                    case 85:
                        i8 = indexCount2;
                        kVar.f5025f = typedArrayObtainStyledAttributes.getFloat(index2, kVar.f5025f);
                        break;
                    case 86:
                        i8 = indexCount2;
                        int i16 = typedArrayObtainStyledAttributes.peekValue(index2).type;
                        if (i16 == 1) {
                            kVar.f5028i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                            break;
                        } else if (i16 == 3) {
                            String string2 = typedArrayObtainStyledAttributes.getString(index2);
                            kVar.f5027h = string2;
                            if (string2.indexOf("/") > 0) {
                                kVar.f5028i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                                break;
                            }
                        } else {
                            typedArrayObtainStyledAttributes.getInteger(index2, kVar.f5028i);
                            break;
                        }
                        break;
                    case 87:
                        i8 = indexCount2;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index2) + "   " + sparseIntArray.get(index2));
                        break;
                    case 88:
                    case 89:
                    case 90:
                    default:
                        StringBuilder sb2 = new StringBuilder("Unknown attribute 0x");
                        i8 = indexCount2;
                        sb2.append(Integer.toHexString(index2));
                        sb2.append("   ");
                        sb2.append(sparseIntArray.get(index2));
                        Log.w("ConstraintSet", sb2.toString());
                        break;
                    case 91:
                        i8 = indexCount2;
                        jVar.f5011p = f(typedArrayObtainStyledAttributes, index2, jVar.f5011p);
                        break;
                    case 92:
                        i8 = indexCount2;
                        jVar.f5012q = f(typedArrayObtainStyledAttributes, index2, jVar.f5012q);
                        break;
                    case 93:
                        i8 = indexCount2;
                        jVar.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.K);
                        break;
                    case 94:
                        i8 = indexCount2;
                        jVar.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.R);
                        break;
                    case 95:
                        i8 = indexCount2;
                        g(jVar, typedArrayObtainStyledAttributes, index2, 0);
                        continue;
                        i14++;
                    case 96:
                        i8 = indexCount2;
                        g(jVar, typedArrayObtainStyledAttributes, index2, 1);
                        break;
                    case 97:
                        i8 = indexCount2;
                        jVar.f5009n0 = typedArrayObtainStyledAttributes.getInt(index2, jVar.f5009n0);
                        break;
                }
                i14++;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return iVar;
    }

    public static int f(TypedArray typedArray, int i8, int i9) {
        int resourceId = typedArray.getResourceId(i8, i9);
        return resourceId == -1 ? typedArray.getInt(i8, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(java.lang.Object r7, android.content.res.TypedArray r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r.n.g(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void h(e eVar, String str) {
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i8 = -1;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                i8 = strSubstring.equalsIgnoreCase("W") ? 0 : strSubstring.equalsIgnoreCase("H") ? 1 : -1;
                i = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i);
                    if (strSubstring2.length() > 0) {
                        Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f3 = Float.parseFloat(strSubstring3);
                        float f7 = Float.parseFloat(strSubstring4);
                        if (f3 > 0.0f && f7 > 0.0f) {
                            if (i8 == 1) {
                                Math.abs(f7 / f3);
                            } else {
                                Math.abs(f3 / f7);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        eVar.F = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(ConstraintLayout constraintLayout) {
        HashSet hashSet;
        int i8;
        HashMap map;
        String resourceEntryName;
        n nVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map2 = nVar.f5049c;
        HashSet hashSet2 = new HashSet(map2.keySet());
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = constraintLayout.getChildAt(i9);
            int id = childAt.getId();
            if (!map2.containsKey(Integer.valueOf(id))) {
                StringBuilder sb = new StringBuilder("id unknown ");
                try {
                    resourceEntryName = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    resourceEntryName = "UNKNOWN";
                }
                sb.append(resourceEntryName);
                Log.w("ConstraintSet", sb.toString());
            } else {
                if (nVar.f5048b && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (map2.containsKey(Integer.valueOf(id))) {
                        hashSet2.remove(Integer.valueOf(id));
                        i iVar = (i) map2.get(Integer.valueOf(id));
                        if (iVar != null) {
                            l lVar = iVar.f4979b;
                            j jVar = iVar.d;
                            m mVar = iVar.f4981e;
                            if (childAt instanceof a) {
                                jVar.f4996g0 = 1;
                                a aVar = (a) childAt;
                                aVar.setId(id);
                                aVar.setType(jVar.f4992e0);
                                aVar.setMargin(jVar.f4994f0);
                                aVar.setAllowsGoneWidget(jVar.f5007m0);
                                int[] iArr = jVar.f4998h0;
                                if (iArr != null) {
                                    aVar.setReferencedIds(iArr);
                                } else {
                                    String str = jVar.f5000i0;
                                    if (str != null) {
                                        int[] iArrC = c(aVar, str);
                                        jVar.f4998h0 = iArrC;
                                        aVar.setReferencedIds(iArrC);
                                    }
                                }
                            }
                            e eVar = (e) childAt.getLayoutParams();
                            eVar.a();
                            iVar.a(eVar);
                            HashMap map3 = iVar.f4982f;
                            Class<?> cls = childAt.getClass();
                            for (String str2 : map3.keySet()) {
                                b bVar = (b) map3.get(str2);
                                HashSet hashSet3 = hashSet2;
                                String strC = !bVar.f4906a ? m0.f.c("set", str2) : str2;
                                int i10 = i9;
                                try {
                                    int iA = m.f.a(bVar.f4907b);
                                    Class cls2 = Float.TYPE;
                                    Class cls3 = Integer.TYPE;
                                    switch (iA) {
                                        case 0:
                                            map = map3;
                                            cls.getMethod(strC, cls3).invoke(childAt, Integer.valueOf(bVar.f4908c));
                                            break;
                                        case 1:
                                            map = map3;
                                            cls.getMethod(strC, cls2).invoke(childAt, Float.valueOf(bVar.d));
                                            break;
                                        case 2:
                                            map = map3;
                                            cls.getMethod(strC, cls3).invoke(childAt, Integer.valueOf(bVar.f4911g));
                                            break;
                                        case 3:
                                            Method method = cls.getMethod(strC, Drawable.class);
                                            map = map3;
                                            try {
                                                ColorDrawable colorDrawable = new ColorDrawable();
                                                colorDrawable.setColor(bVar.f4911g);
                                                method.invoke(childAt, colorDrawable);
                                            } catch (IllegalAccessException e9) {
                                                e = e9;
                                                Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                                                e.printStackTrace();
                                                hashSet2 = hashSet3;
                                                i9 = i10;
                                                map3 = map;
                                            } catch (NoSuchMethodException e10) {
                                                e = e10;
                                                Log.e("TransitionLayout", e.getMessage());
                                                Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                                                Log.e("TransitionLayout", cls.getName() + " must have a method " + strC);
                                                hashSet2 = hashSet3;
                                                i9 = i10;
                                                map3 = map;
                                            } catch (InvocationTargetException e11) {
                                                e = e11;
                                                Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                                                e.printStackTrace();
                                                hashSet2 = hashSet3;
                                                i9 = i10;
                                                map3 = map;
                                            }
                                        case 4:
                                            cls.getMethod(strC, CharSequence.class).invoke(childAt, bVar.f4909e);
                                            map = map3;
                                            break;
                                        case 5:
                                            cls.getMethod(strC, Boolean.TYPE).invoke(childAt, Boolean.valueOf(bVar.f4910f));
                                            map = map3;
                                            break;
                                        case 6:
                                            cls.getMethod(strC, cls2).invoke(childAt, Float.valueOf(bVar.d));
                                            map = map3;
                                            break;
                                        case 7:
                                            cls.getMethod(strC, cls3).invoke(childAt, Integer.valueOf(bVar.f4908c));
                                            map = map3;
                                            break;
                                        default:
                                            map = map3;
                                            break;
                                    }
                                } catch (IllegalAccessException e12) {
                                    e = e12;
                                    map = map3;
                                } catch (NoSuchMethodException e13) {
                                    e = e13;
                                    map = map3;
                                } catch (InvocationTargetException e14) {
                                    e = e14;
                                    map = map3;
                                }
                                hashSet2 = hashSet3;
                                i9 = i10;
                                map3 = map;
                            }
                            hashSet = hashSet2;
                            i8 = i9;
                            childAt.setLayoutParams(eVar);
                            if (lVar.f5030b == 0) {
                                childAt.setVisibility(lVar.f5029a);
                            }
                            childAt.setAlpha(lVar.f5031c);
                            childAt.setRotation(mVar.f5033a);
                            childAt.setRotationX(mVar.f5034b);
                            childAt.setRotationY(mVar.f5035c);
                            childAt.setScaleX(mVar.d);
                            childAt.setScaleY(mVar.f5036e);
                            if (mVar.f5039h != -1) {
                                if (((View) childAt.getParent()).findViewById(mVar.f5039h) != null) {
                                    float bottom = (r0.getBottom() + r0.getTop()) / 2.0f;
                                    float right = (r0.getRight() + r0.getLeft()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(right - childAt.getLeft());
                                        childAt.setPivotY(bottom - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(mVar.f5037f)) {
                                    childAt.setPivotX(mVar.f5037f);
                                }
                                if (!Float.isNaN(mVar.f5038g)) {
                                    childAt.setPivotY(mVar.f5038g);
                                }
                            }
                            childAt.setTranslationX(mVar.f5040i);
                            childAt.setTranslationY(mVar.f5041j);
                            childAt.setTranslationZ(mVar.f5042k);
                            if (mVar.f5043l) {
                                childAt.setElevation(mVar.f5044m);
                            }
                        }
                    } else {
                        hashSet = hashSet2;
                        i8 = i9;
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
                i9 = i8 + 1;
                nVar = this;
                hashSet2 = hashSet;
            }
            hashSet = hashSet2;
            i8 = i9;
            i9 = i8 + 1;
            nVar = this;
            hashSet2 = hashSet;
        }
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            i iVar2 = (i) map2.get(num);
            if (iVar2 != null) {
                j jVar2 = iVar2.d;
                if (jVar2.f4996g0 == 1) {
                    Context context = constraintLayout.getContext();
                    a aVar2 = new a(context);
                    aVar2.f4912a = new int[32];
                    aVar2.f4917g = new HashMap();
                    aVar2.f4914c = context;
                    o.a aVar3 = new o.a();
                    aVar3.f4184r0 = 0;
                    aVar3.f4185s0 = true;
                    aVar3.f4186t0 = 0;
                    aVar3.f4187u0 = false;
                    aVar2.f4905k = aVar3;
                    aVar2.d = aVar3;
                    aVar2.i();
                    aVar2.setVisibility(8);
                    aVar2.setId(num.intValue());
                    int[] iArr2 = jVar2.f4998h0;
                    if (iArr2 != null) {
                        aVar2.setReferencedIds(iArr2);
                    } else {
                        String str3 = jVar2.f5000i0;
                        if (str3 != null) {
                            int[] iArrC2 = c(aVar2, str3);
                            jVar2.f4998h0 = iArrC2;
                            aVar2.setReferencedIds(iArrC2);
                        }
                    }
                    aVar2.setType(jVar2.f4992e0);
                    aVar2.setMargin(jVar2.f4994f0);
                    e eVarG = ConstraintLayout.g();
                    aVar2.i();
                    iVar2.a(eVarG);
                    constraintLayout.addView(aVar2, eVarG);
                }
                if (jVar2.f4984a) {
                    View pVar = new p(constraintLayout.getContext());
                    pVar.setId(num.intValue());
                    e eVarG2 = ConstraintLayout.g();
                    iVar2.a(eVarG2);
                    constraintLayout.addView(pVar, eVarG2);
                }
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = constraintLayout.getChildAt(i11);
            if (childAt2 instanceof c) {
                ((c) childAt2).e(constraintLayout);
            }
        }
    }

    public final void b(ConstraintLayout constraintLayout) {
        int i8;
        HashMap map;
        HashMap map2;
        n nVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map3 = nVar.f5049c;
        map3.clear();
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = constraintLayout.getChildAt(i9);
            e eVar = (e) childAt.getLayoutParams();
            int id = childAt.getId();
            if (nVar.f5048b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map3.containsKey(Integer.valueOf(id))) {
                map3.put(Integer.valueOf(id), new i());
            }
            i iVar = (i) map3.get(Integer.valueOf(id));
            if (iVar == null) {
                i8 = childCount;
                map = map3;
            } else {
                l lVar = iVar.f4979b;
                j jVar = iVar.d;
                m mVar = iVar.f4981e;
                HashMap map4 = new HashMap();
                Class<?> cls = childAt.getClass();
                HashMap map5 = nVar.f5047a;
                for (String str : map5.keySet()) {
                    b bVar = (b) map5.get(str);
                    int i10 = childCount;
                    try {
                        if (str.equals("BackgroundColor")) {
                            map2 = map3;
                            try {
                                map4.put(str, new b(bVar, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                            } catch (IllegalAccessException e9) {
                                e = e9;
                                e.printStackTrace();
                                childCount = i10;
                                map3 = map2;
                            } catch (NoSuchMethodException e10) {
                                e = e10;
                                e.printStackTrace();
                                childCount = i10;
                                map3 = map2;
                            } catch (InvocationTargetException e11) {
                                e = e11;
                                e.printStackTrace();
                                childCount = i10;
                                map3 = map2;
                            }
                        } else {
                            map2 = map3;
                            map4.put(str, new b(bVar, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                        }
                    } catch (IllegalAccessException e12) {
                        e = e12;
                        map2 = map3;
                    } catch (NoSuchMethodException e13) {
                        e = e13;
                        map2 = map3;
                    } catch (InvocationTargetException e14) {
                        e = e14;
                        map2 = map3;
                    }
                    childCount = i10;
                    map3 = map2;
                }
                i8 = childCount;
                map = map3;
                iVar.f4982f = map4;
                iVar.f4978a = id;
                jVar.f4995g = eVar.d;
                jVar.f4997h = eVar.f4926e;
                jVar.f4999i = eVar.f4928f;
                jVar.f5001j = eVar.f4930g;
                jVar.f5003k = eVar.f4932h;
                jVar.f5004l = eVar.f4934i;
                jVar.f5006m = eVar.f4936j;
                jVar.f5008n = eVar.f4938k;
                jVar.f5010o = eVar.f4939l;
                jVar.f5011p = eVar.f4941m;
                jVar.f5012q = eVar.f4943n;
                jVar.f5013r = eVar.f4949r;
                jVar.f5014s = eVar.f4950s;
                jVar.f5015t = eVar.f4951t;
                jVar.f5016u = eVar.f4952u;
                jVar.f5017v = eVar.D;
                jVar.f5018w = eVar.E;
                jVar.f5019x = eVar.F;
                jVar.y = eVar.f4945o;
                jVar.z = eVar.f4947p;
                jVar.A = eVar.f4948q;
                jVar.B = eVar.S;
                jVar.C = eVar.T;
                jVar.D = eVar.U;
                jVar.f4993f = eVar.f4923c;
                jVar.d = eVar.f4919a;
                jVar.f4991e = eVar.f4921b;
                jVar.f4986b = ((ViewGroup.MarginLayoutParams) eVar).width;
                jVar.f4988c = ((ViewGroup.MarginLayoutParams) eVar).height;
                jVar.E = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
                jVar.F = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
                jVar.G = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                jVar.H = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                jVar.K = eVar.C;
                jVar.S = eVar.H;
                jVar.T = eVar.G;
                jVar.V = eVar.J;
                jVar.U = eVar.I;
                jVar.k0 = eVar.V;
                jVar.f5005l0 = eVar.W;
                jVar.W = eVar.K;
                jVar.X = eVar.L;
                jVar.Y = eVar.O;
                jVar.Z = eVar.P;
                jVar.f4985a0 = eVar.M;
                jVar.f4987b0 = eVar.N;
                jVar.f4989c0 = eVar.Q;
                jVar.f4990d0 = eVar.R;
                jVar.f5002j0 = eVar.X;
                jVar.M = eVar.f4954w;
                jVar.O = eVar.y;
                jVar.L = eVar.f4953v;
                jVar.N = eVar.f4955x;
                jVar.Q = eVar.z;
                jVar.P = eVar.A;
                jVar.R = eVar.B;
                jVar.f5009n0 = eVar.Y;
                jVar.I = eVar.getMarginEnd();
                jVar.J = eVar.getMarginStart();
                lVar.f5029a = childAt.getVisibility();
                lVar.f5031c = childAt.getAlpha();
                mVar.f5033a = childAt.getRotation();
                mVar.f5034b = childAt.getRotationX();
                mVar.f5035c = childAt.getRotationY();
                mVar.d = childAt.getScaleX();
                mVar.f5036e = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    mVar.f5037f = pivotX;
                    mVar.f5038g = pivotY;
                }
                mVar.f5040i = childAt.getTranslationX();
                mVar.f5041j = childAt.getTranslationY();
                mVar.f5042k = childAt.getTranslationZ();
                if (mVar.f5043l) {
                    mVar.f5044m = childAt.getElevation();
                }
                if (childAt instanceof a) {
                    a aVar = (a) childAt;
                    jVar.f5007m0 = aVar.getAllowsGoneWidget();
                    jVar.f4998h0 = aVar.getReferencedIds();
                    jVar.f4992e0 = aVar.getType();
                    jVar.f4994f0 = aVar.getMargin();
                }
            }
            i9++;
            nVar = this;
            childCount = i8;
            map3 = map;
        }
    }

    public final void e(Context context, int i8) {
        XmlResourceParser xml = context.getResources().getXml(i8);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    i iVarD = d(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        iVarD.d.f4984a = true;
                    }
                    this.f5049c.put(Integer.valueOf(iVarD.f4978a), iVarD);
                }
            }
        } catch (IOException e9) {
            e9.printStackTrace();
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        }
    }
}
