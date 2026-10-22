package z2;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f16325d = {0, 4, 8};

    /* renamed from: e, reason: collision with root package name */
    public static final SparseIntArray f16326e;

    /* renamed from: f, reason: collision with root package name */
    public static final SparseIntArray f16327f;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f16328a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final boolean f16329b = true;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f16330c = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16326e = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f16327f = sparseIntArray2;
        sparseIntArray.append(82, 25);
        sparseIntArray.append(83, 26);
        sparseIntArray.append(85, 29);
        sparseIntArray.append(86, 30);
        sparseIntArray.append(92, 36);
        sparseIntArray.append(91, 35);
        sparseIntArray.append(63, 4);
        sparseIntArray.append(62, 3);
        sparseIntArray.append(58, 1);
        sparseIntArray.append(60, 91);
        sparseIntArray.append(59, 92);
        sparseIntArray.append(101, 6);
        sparseIntArray.append(102, 7);
        sparseIntArray.append(70, 17);
        sparseIntArray.append(71, 18);
        sparseIntArray.append(72, 19);
        sparseIntArray.append(54, 99);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(87, 32);
        sparseIntArray.append(88, 33);
        sparseIntArray.append(69, 10);
        sparseIntArray.append(68, 9);
        sparseIntArray.append(106, 13);
        sparseIntArray.append(109, 16);
        sparseIntArray.append(107, 14);
        sparseIntArray.append(104, 11);
        sparseIntArray.append(108, 15);
        sparseIntArray.append(105, 12);
        sparseIntArray.append(95, 40);
        sparseIntArray.append(80, 39);
        sparseIntArray.append(79, 41);
        sparseIntArray.append(94, 42);
        sparseIntArray.append(78, 20);
        sparseIntArray.append(93, 37);
        sparseIntArray.append(67, 5);
        sparseIntArray.append(81, 87);
        sparseIntArray.append(90, 87);
        sparseIntArray.append(84, 87);
        sparseIntArray.append(61, 87);
        sparseIntArray.append(57, 87);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(96, 95);
        sparseIntArray.append(73, 96);
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
        sparseIntArray.append(97, 54);
        sparseIntArray.append(74, 55);
        sparseIntArray.append(98, 56);
        sparseIntArray.append(75, 57);
        sparseIntArray.append(99, 58);
        sparseIntArray.append(76, 59);
        sparseIntArray.append(64, 61);
        sparseIntArray.append(66, 62);
        sparseIntArray.append(65, 63);
        sparseIntArray.append(28, 64);
        sparseIntArray.append(121, 65);
        sparseIntArray.append(35, 66);
        sparseIntArray.append(122, 67);
        sparseIntArray.append(113, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(112, 68);
        sparseIntArray.append(100, 69);
        sparseIntArray.append(77, 70);
        sparseIntArray.append(111, 97);
        sparseIntArray.append(32, 71);
        sparseIntArray.append(30, 72);
        sparseIntArray.append(31, 73);
        sparseIntArray.append(33, 74);
        sparseIntArray.append(29, 75);
        sparseIntArray.append(114, 76);
        sparseIntArray.append(89, 77);
        sparseIntArray.append(123, 78);
        sparseIntArray.append(56, 80);
        sparseIntArray.append(55, 81);
        sparseIntArray.append(116, 82);
        sparseIntArray.append(120, 83);
        sparseIntArray.append(119, 84);
        sparseIntArray.append(118, 85);
        sparseIntArray.append(117, 86);
        sparseIntArray2.append(85, 6);
        sparseIntArray2.append(85, 7);
        sparseIntArray2.append(0, 27);
        sparseIntArray2.append(89, 13);
        sparseIntArray2.append(92, 16);
        sparseIntArray2.append(90, 14);
        sparseIntArray2.append(87, 11);
        sparseIntArray2.append(91, 15);
        sparseIntArray2.append(88, 12);
        sparseIntArray2.append(78, 40);
        sparseIntArray2.append(71, 39);
        sparseIntArray2.append(70, 41);
        sparseIntArray2.append(77, 42);
        sparseIntArray2.append(69, 20);
        sparseIntArray2.append(76, 37);
        sparseIntArray2.append(60, 5);
        sparseIntArray2.append(72, 87);
        sparseIntArray2.append(75, 87);
        sparseIntArray2.append(73, 87);
        sparseIntArray2.append(57, 87);
        sparseIntArray2.append(56, 87);
        sparseIntArray2.append(5, 24);
        sparseIntArray2.append(7, 28);
        sparseIntArray2.append(23, 31);
        sparseIntArray2.append(24, 8);
        sparseIntArray2.append(6, 34);
        sparseIntArray2.append(8, 2);
        sparseIntArray2.append(3, 23);
        sparseIntArray2.append(4, 21);
        sparseIntArray2.append(79, 95);
        sparseIntArray2.append(64, 96);
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
        sparseIntArray2.append(80, 54);
        sparseIntArray2.append(65, 55);
        sparseIntArray2.append(81, 56);
        sparseIntArray2.append(66, 57);
        sparseIntArray2.append(82, 58);
        sparseIntArray2.append(67, 59);
        sparseIntArray2.append(59, 62);
        sparseIntArray2.append(58, 63);
        sparseIntArray2.append(28, 64);
        sparseIntArray2.append(105, 65);
        sparseIntArray2.append(34, 66);
        sparseIntArray2.append(106, 67);
        sparseIntArray2.append(96, 79);
        sparseIntArray2.append(1, 38);
        sparseIntArray2.append(97, 98);
        sparseIntArray2.append(95, 68);
        sparseIntArray2.append(83, 69);
        sparseIntArray2.append(68, 70);
        sparseIntArray2.append(32, 71);
        sparseIntArray2.append(30, 72);
        sparseIntArray2.append(31, 73);
        sparseIntArray2.append(33, 74);
        sparseIntArray2.append(29, 75);
        sparseIntArray2.append(98, 76);
        sparseIntArray2.append(74, 77);
        sparseIntArray2.append(107, 78);
        sparseIntArray2.append(55, 80);
        sparseIntArray2.append(54, 81);
        sparseIntArray2.append(100, 82);
        sparseIntArray2.append(104, 83);
        sparseIntArray2.append(103, 84);
        sparseIntArray2.append(102, 85);
        sparseIntArray2.append(101, 86);
        sparseIntArray2.append(94, 97);
    }

    public static int[] b(Barrier barrier, String str) throws IllegalAccessException, IllegalArgumentException {
        int iIntValue;
        String[] strArrSplit = str.split(",");
        Context context = barrier.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i = 0;
        int i3 = 0;
        while (i < strArrSplit.length) {
            String strTrim = strArrSplit[i].trim();
            Object obj = null;
            try {
                iIntValue = p.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && barrier.isInEditMode() && (barrier.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) barrier.getParent();
                if (strTrim != null) {
                    HashMap map = constraintLayout.f1007q;
                    if (map != null && map.containsKey(strTrim)) {
                        obj = constraintLayout.f1007q.get(strTrim);
                    }
                } else {
                    constraintLayout.getClass();
                }
                if (obj != null && (obj instanceof Integer)) {
                    iIntValue = ((Integer) obj).intValue();
                }
            }
            iArr[i3] = iIntValue;
            i++;
            i3++;
        }
        return i3 != strArrSplit.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    public static h c(Context context, AttributeSet attributeSet, boolean z10) throws NumberFormatException {
        int i;
        int i3;
        h hVar = new h();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z10 ? q.f16334c : q.f16332a);
        k kVar = hVar.f16255b;
        l lVar = hVar.f16258e;
        j jVar = hVar.f16256c;
        i iVar = hVar.f16257d;
        int[] iArr = f16325d;
        String[] strArr = v2.a.f14603a;
        SparseIntArray sparseIntArray = f16326e;
        if (z10) {
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            g gVar = new g();
            gVar.f16243a = new int[10];
            gVar.f16244b = new int[10];
            gVar.f16245c = 0;
            gVar.f16246d = new int[10];
            gVar.f16247e = new float[10];
            gVar.f16248f = 0;
            gVar.f16249g = new int[5];
            gVar.f16250h = new String[5];
            gVar.i = 0;
            gVar.f16251j = new int[4];
            gVar.f16252k = new boolean[4];
            gVar.f16253l = 0;
            jVar.getClass();
            iVar.getClass();
            lVar.getClass();
            int i10 = 0;
            while (i10 < indexCount) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                int i11 = indexCount;
                switch (f16327f.get(index)) {
                    case 2:
                        i3 = i10;
                        gVar.b(2, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.I));
                        continue;
                        i10 = i3 + 1;
                        indexCount = i11;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                    case 29:
                    case PolicyBasicListVO.TYPE_ID_HEAD_LIST /* 30 */:
                    case 32:
                    case 33:
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_ON /* 35 */:
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_LARGE /* 36 */:
                    case 61:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    default:
                        StringBuilder sb2 = new StringBuilder("Unknown attribute 0x");
                        i3 = i10;
                        sb2.append(Integer.toHexString(index));
                        sb2.append("   ");
                        sb2.append(sparseIntArray.get(index));
                        Log.w("ConstraintSet", sb2.toString());
                        break;
                    case 5:
                        i3 = i10;
                        gVar.c(5, typedArrayObtainStyledAttributes.getString(index));
                        continue;
                        i10 = i3 + 1;
                        indexCount = i11;
                    case 6:
                        i3 = i10;
                        gVar.b(6, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, iVar.C));
                        break;
                    case 7:
                        i3 = i10;
                        gVar.b(7, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, iVar.D));
                        break;
                    case 8:
                        i3 = i10;
                        gVar.b(8, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.J));
                        break;
                    case 11:
                        i3 = i10;
                        gVar.b(11, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.P));
                        break;
                    case 12:
                        i3 = i10;
                        gVar.b(12, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.Q));
                        break;
                    case 13:
                        i3 = i10;
                        gVar.b(13, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.M));
                        break;
                    case 14:
                        i3 = i10;
                        gVar.b(14, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.O));
                        break;
                    case 15:
                        i3 = i10;
                        gVar.b(15, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.R));
                        break;
                    case 16:
                        i3 = i10;
                        gVar.b(16, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.N));
                        break;
                    case 17:
                        i3 = i10;
                        gVar.b(17, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, iVar.f16267d));
                        break;
                    case 18:
                        i3 = i10;
                        gVar.b(18, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, iVar.f16269e));
                        break;
                    case 19:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getFloat(index, iVar.f16270f), 19);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getFloat(index, iVar.f16295w), 20);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i3 = i10;
                        gVar.b(21, typedArrayObtainStyledAttributes.getLayoutDimension(index, iVar.f16265c));
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        i3 = i10;
                        gVar.b(22, iArr[typedArrayObtainStyledAttributes.getInt(index, kVar.f16308a)]);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        i3 = i10;
                        gVar.b(23, typedArrayObtainStyledAttributes.getLayoutDimension(index, iVar.f16263b));
                        break;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        i3 = i10;
                        gVar.b(24, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.F));
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        i3 = i10;
                        gVar.b(27, typedArrayObtainStyledAttributes.getInt(index, iVar.E));
                        break;
                    case 28:
                        i3 = i10;
                        gVar.b(28, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.G));
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_NUMBER /* 31 */:
                        i3 = i10;
                        gVar.b(31, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.K));
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_OFF /* 34 */:
                        i3 = i10;
                        gVar.b(34, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.H));
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_DOUBLE_LINE_LARGE_TITLE /* 37 */:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getFloat(index, iVar.f16296x), 37);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE /* 38 */:
                        i3 = i10;
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, hVar.f16254a);
                        hVar.f16254a = resourceId;
                        gVar.b(38, resourceId);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE_TITLE /* 39 */:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getFloat(index, iVar.U), 39);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_NORMAL /* 40 */:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getFloat(index, iVar.T), 40);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_OPERATION /* 41 */:
                        i3 = i10;
                        gVar.b(41, typedArrayObtainStyledAttributes.getInt(index, iVar.V));
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_SUMMARY /* 42 */:
                        i3 = i10;
                        gVar.b(42, typedArrayObtainStyledAttributes.getInt(index, iVar.W));
                        break;
                    case 43:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getFloat(index, kVar.f16310c), 43);
                        break;
                    case 44:
                        i3 = i10;
                        gVar.d(44, true);
                        gVar.a(typedArrayObtainStyledAttributes.getDimension(index, lVar.f16324m), 44);
                        break;
                    case 45:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getFloat(index, lVar.f16314b), 45);
                        break;
                    case 46:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getFloat(index, lVar.f16315c), 46);
                        break;
                    case 47:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getFloat(index, lVar.f16316d), 47);
                        break;
                    case 48:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getFloat(index, lVar.f16317e), 48);
                        break;
                    case 49:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getDimension(index, lVar.f16318f), 49);
                        break;
                    case 50:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getDimension(index, lVar.f16319g), 50);
                        break;
                    case 51:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getDimension(index, lVar.i), 51);
                        break;
                    case 52:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getDimension(index, lVar.f16321j), 52);
                        break;
                    case FastDoubleMath.DOUBLE_SIGNIFICAND_WIDTH /* 53 */:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getDimension(index, lVar.f16322k), 53);
                        break;
                    case 54:
                        i3 = i10;
                        gVar.b(54, typedArrayObtainStyledAttributes.getInt(index, iVar.X));
                        break;
                    case 55:
                        i3 = i10;
                        gVar.b(55, typedArrayObtainStyledAttributes.getInt(index, iVar.Y));
                        break;
                    case 56:
                        i3 = i10;
                        gVar.b(56, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.Z));
                        break;
                    case 57:
                        i3 = i10;
                        gVar.b(57, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.f16262a0));
                        break;
                    case 58:
                        i3 = i10;
                        gVar.b(58, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.f16264b0));
                        break;
                    case 59:
                        i3 = i10;
                        gVar.b(59, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.f16266c0));
                        break;
                    case 60:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getFloat(index, lVar.f16313a), 60);
                        break;
                    case 62:
                        i3 = i10;
                        gVar.b(62, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.A));
                        break;
                    case 63:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getFloat(index, iVar.B), 63);
                        break;
                    case 64:
                        i3 = i10;
                        gVar.b(64, e(typedArrayObtainStyledAttributes, index, jVar.f16300a));
                        break;
                    case 65:
                        i3 = i10;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            gVar.c(65, typedArrayObtainStyledAttributes.getString(index));
                            break;
                        } else {
                            gVar.c(65, strArr[typedArrayObtainStyledAttributes.getInteger(index, 0)]);
                            break;
                        }
                    case 66:
                        i3 = i10;
                        gVar.b(66, typedArrayObtainStyledAttributes.getInt(index, 0));
                        break;
                    case 67:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getFloat(index, jVar.f16304e), 67);
                        break;
                    case 68:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getFloat(index, kVar.f16311d), 68);
                        break;
                    case 69:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getFloat(index, 1.0f), 69);
                        break;
                    case 70:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getFloat(index, 1.0f), 70);
                        break;
                    case 71:
                        i3 = i10;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i3 = i10;
                        gVar.b(72, typedArrayObtainStyledAttributes.getInt(index, iVar.f0));
                        break;
                    case 73:
                        i3 = i10;
                        gVar.b(73, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.f16272g0));
                        break;
                    case 74:
                        i3 = i10;
                        gVar.c(74, typedArrayObtainStyledAttributes.getString(index));
                        break;
                    case 75:
                        i3 = i10;
                        gVar.d(75, typedArrayObtainStyledAttributes.getBoolean(index, iVar.f16285n0));
                        break;
                    case 76:
                        i3 = i10;
                        gVar.b(76, typedArrayObtainStyledAttributes.getInt(index, jVar.f16302c));
                        break;
                    case 77:
                        i3 = i10;
                        gVar.c(77, typedArrayObtainStyledAttributes.getString(index));
                        break;
                    case 78:
                        i3 = i10;
                        gVar.b(78, typedArrayObtainStyledAttributes.getInt(index, kVar.f16309b));
                        break;
                    case 79:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getFloat(index, jVar.f16303d), 79);
                        break;
                    case 80:
                        i3 = i10;
                        gVar.d(80, typedArrayObtainStyledAttributes.getBoolean(index, iVar.f16281l0));
                        break;
                    case 81:
                        i3 = i10;
                        gVar.d(81, typedArrayObtainStyledAttributes.getBoolean(index, iVar.f16283m0));
                        break;
                    case 82:
                        i3 = i10;
                        gVar.b(82, typedArrayObtainStyledAttributes.getInteger(index, jVar.f16301b));
                        break;
                    case 83:
                        i3 = i10;
                        gVar.b(83, e(typedArrayObtainStyledAttributes, index, lVar.f16320h));
                        break;
                    case 84:
                        i3 = i10;
                        gVar.b(84, typedArrayObtainStyledAttributes.getInteger(index, jVar.f16306g));
                        break;
                    case 85:
                        i3 = i10;
                        gVar.a(typedArrayObtainStyledAttributes.getFloat(index, jVar.f16305f), 85);
                        break;
                    case 86:
                        i3 = i10;
                        int i12 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i12 == 1) {
                            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            jVar.i = resourceId2;
                            gVar.b(89, resourceId2);
                            if (jVar.i != -1) {
                                gVar.b(88, -2);
                                break;
                            }
                        } else if (i12 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            jVar.f16307h = string;
                            gVar.c(90, string);
                            if (jVar.f16307h.indexOf("/") > 0) {
                                int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                jVar.i = resourceId3;
                                gVar.b(89, resourceId3);
                                gVar.b(88, -2);
                                break;
                            } else {
                                gVar.b(88, -1);
                                break;
                            }
                        } else {
                            gVar.b(88, typedArrayObtainStyledAttributes.getInteger(index, jVar.i));
                            break;
                        }
                        break;
                    case 87:
                        i3 = i10;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                        break;
                    case 93:
                        i3 = i10;
                        gVar.b(93, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.L));
                        break;
                    case 94:
                        i3 = i10;
                        gVar.b(94, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, iVar.S));
                        break;
                    case 95:
                        i3 = i10;
                        f(gVar, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 96:
                        i3 = i10;
                        f(gVar, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    case 97:
                        i3 = i10;
                        gVar.b(97, typedArrayObtainStyledAttributes.getInt(index, iVar.f16287o0));
                        break;
                    case 98:
                        i3 = i10;
                        int i13 = y2.a.f15881w;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index);
                            break;
                        } else {
                            hVar.f16254a = typedArrayObtainStyledAttributes.getResourceId(index, hVar.f16254a);
                            break;
                        }
                    case 99:
                        i3 = i10;
                        gVar.d(99, typedArrayObtainStyledAttributes.getBoolean(index, iVar.f16271g));
                        break;
                }
                i10 = i3 + 1;
                indexCount = i11;
            }
        } else {
            int i14 = 0;
            for (int indexCount2 = typedArrayObtainStyledAttributes.getIndexCount(); i14 < indexCount2; indexCount2 = i) {
                int index2 = typedArrayObtainStyledAttributes.getIndex(i14);
                if (index2 != 1 && 23 != index2) {
                    if (24 != index2) {
                        jVar.getClass();
                        iVar.getClass();
                        lVar.getClass();
                    }
                }
                switch (sparseIntArray.get(index2)) {
                    case 1:
                        i = indexCount2;
                        iVar.f16288p = e(typedArrayObtainStyledAttributes, index2, iVar.f16288p);
                        continue;
                        i14++;
                    case 2:
                        i = indexCount2;
                        iVar.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.I);
                        continue;
                        i14++;
                    case 3:
                        i = indexCount2;
                        iVar.f16286o = e(typedArrayObtainStyledAttributes, index2, iVar.f16286o);
                        continue;
                        i14++;
                    case 4:
                        i = indexCount2;
                        iVar.f16284n = e(typedArrayObtainStyledAttributes, index2, iVar.f16284n);
                        continue;
                        i14++;
                    case 5:
                        i = indexCount2;
                        iVar.f16297y = typedArrayObtainStyledAttributes.getString(index2);
                        continue;
                        i14++;
                    case 6:
                        i = indexCount2;
                        iVar.C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, iVar.C);
                        continue;
                        i14++;
                    case 7:
                        i = indexCount2;
                        iVar.D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, iVar.D);
                        continue;
                        i14++;
                    case 8:
                        i = indexCount2;
                        iVar.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.J);
                        continue;
                        i14++;
                    case 9:
                        i = indexCount2;
                        iVar.f16294v = e(typedArrayObtainStyledAttributes, index2, iVar.f16294v);
                        continue;
                        i14++;
                    case 10:
                        i = indexCount2;
                        iVar.f16293u = e(typedArrayObtainStyledAttributes, index2, iVar.f16293u);
                        continue;
                        i14++;
                    case 11:
                        i = indexCount2;
                        iVar.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.P);
                        continue;
                        i14++;
                    case 12:
                        i = indexCount2;
                        iVar.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.Q);
                        continue;
                        i14++;
                    case 13:
                        i = indexCount2;
                        iVar.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.M);
                        continue;
                        i14++;
                    case 14:
                        i = indexCount2;
                        iVar.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.O);
                        continue;
                        i14++;
                    case 15:
                        i = indexCount2;
                        iVar.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.R);
                        continue;
                        i14++;
                    case 16:
                        i = indexCount2;
                        iVar.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.N);
                        continue;
                        i14++;
                    case 17:
                        i = indexCount2;
                        iVar.f16267d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, iVar.f16267d);
                        continue;
                        i14++;
                    case 18:
                        i = indexCount2;
                        iVar.f16269e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, iVar.f16269e);
                        continue;
                        i14++;
                    case 19:
                        i = indexCount2;
                        iVar.f16270f = typedArrayObtainStyledAttributes.getFloat(index2, iVar.f16270f);
                        continue;
                        i14++;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        i = indexCount2;
                        iVar.f16295w = typedArrayObtainStyledAttributes.getFloat(index2, iVar.f16295w);
                        continue;
                        i14++;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i = indexCount2;
                        iVar.f16265c = typedArrayObtainStyledAttributes.getLayoutDimension(index2, iVar.f16265c);
                        continue;
                        i14++;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        i = indexCount2;
                        int i15 = typedArrayObtainStyledAttributes.getInt(index2, kVar.f16308a);
                        kVar.f16308a = i15;
                        kVar.f16308a = iArr[i15];
                        continue;
                        i14++;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        i = indexCount2;
                        iVar.f16263b = typedArrayObtainStyledAttributes.getLayoutDimension(index2, iVar.f16263b);
                        continue;
                        i14++;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        i = indexCount2;
                        iVar.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.F);
                        continue;
                        i14++;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        i = indexCount2;
                        iVar.f16273h = e(typedArrayObtainStyledAttributes, index2, iVar.f16273h);
                        continue;
                        i14++;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        i = indexCount2;
                        iVar.i = e(typedArrayObtainStyledAttributes, index2, iVar.i);
                        continue;
                        i14++;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        i = indexCount2;
                        iVar.E = typedArrayObtainStyledAttributes.getInt(index2, iVar.E);
                        continue;
                        i14++;
                    case 28:
                        i = indexCount2;
                        iVar.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.G);
                        continue;
                        i14++;
                    case 29:
                        i = indexCount2;
                        iVar.f16276j = e(typedArrayObtainStyledAttributes, index2, iVar.f16276j);
                        continue;
                        i14++;
                    case PolicyBasicListVO.TYPE_ID_HEAD_LIST /* 30 */:
                        i = indexCount2;
                        iVar.f16278k = e(typedArrayObtainStyledAttributes, index2, iVar.f16278k);
                        continue;
                        i14++;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_NUMBER /* 31 */:
                        i = indexCount2;
                        iVar.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.K);
                        continue;
                        i14++;
                    case 32:
                        i = indexCount2;
                        iVar.f16291s = e(typedArrayObtainStyledAttributes, index2, iVar.f16291s);
                        continue;
                        i14++;
                    case 33:
                        i = indexCount2;
                        iVar.f16292t = e(typedArrayObtainStyledAttributes, index2, iVar.f16292t);
                        continue;
                        i14++;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_OFF /* 34 */:
                        i = indexCount2;
                        iVar.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.H);
                        continue;
                        i14++;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_ON /* 35 */:
                        i = indexCount2;
                        iVar.f16282m = e(typedArrayObtainStyledAttributes, index2, iVar.f16282m);
                        continue;
                        i14++;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_LARGE /* 36 */:
                        i = indexCount2;
                        iVar.f16280l = e(typedArrayObtainStyledAttributes, index2, iVar.f16280l);
                        continue;
                        i14++;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_DOUBLE_LINE_LARGE_TITLE /* 37 */:
                        i = indexCount2;
                        iVar.f16296x = typedArrayObtainStyledAttributes.getFloat(index2, iVar.f16296x);
                        continue;
                        i14++;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE /* 38 */:
                        i = indexCount2;
                        hVar.f16254a = typedArrayObtainStyledAttributes.getResourceId(index2, hVar.f16254a);
                        continue;
                        i14++;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE_TITLE /* 39 */:
                        i = indexCount2;
                        iVar.U = typedArrayObtainStyledAttributes.getFloat(index2, iVar.U);
                        continue;
                        i14++;
                    case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_NORMAL /* 40 */:
                        i = indexCount2;
                        iVar.T = typedArrayObtainStyledAttributes.getFloat(index2, iVar.T);
                        continue;
                        i14++;
                    case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_OPERATION /* 41 */:
                        i = indexCount2;
                        iVar.V = typedArrayObtainStyledAttributes.getInt(index2, iVar.V);
                        continue;
                        i14++;
                    case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_SUMMARY /* 42 */:
                        i = indexCount2;
                        iVar.W = typedArrayObtainStyledAttributes.getInt(index2, iVar.W);
                        continue;
                        i14++;
                    case 43:
                        i = indexCount2;
                        kVar.f16310c = typedArrayObtainStyledAttributes.getFloat(index2, kVar.f16310c);
                        continue;
                        i14++;
                    case 44:
                        i = indexCount2;
                        lVar.f16323l = true;
                        lVar.f16324m = typedArrayObtainStyledAttributes.getDimension(index2, lVar.f16324m);
                        continue;
                        i14++;
                    case 45:
                        i = indexCount2;
                        lVar.f16314b = typedArrayObtainStyledAttributes.getFloat(index2, lVar.f16314b);
                        continue;
                        i14++;
                    case 46:
                        i = indexCount2;
                        lVar.f16315c = typedArrayObtainStyledAttributes.getFloat(index2, lVar.f16315c);
                        continue;
                        i14++;
                    case 47:
                        i = indexCount2;
                        lVar.f16316d = typedArrayObtainStyledAttributes.getFloat(index2, lVar.f16316d);
                        continue;
                        i14++;
                    case 48:
                        i = indexCount2;
                        lVar.f16317e = typedArrayObtainStyledAttributes.getFloat(index2, lVar.f16317e);
                        continue;
                        i14++;
                    case 49:
                        i = indexCount2;
                        lVar.f16318f = typedArrayObtainStyledAttributes.getDimension(index2, lVar.f16318f);
                        continue;
                        i14++;
                    case 50:
                        i = indexCount2;
                        lVar.f16319g = typedArrayObtainStyledAttributes.getDimension(index2, lVar.f16319g);
                        continue;
                        i14++;
                    case 51:
                        i = indexCount2;
                        lVar.i = typedArrayObtainStyledAttributes.getDimension(index2, lVar.i);
                        continue;
                        i14++;
                    case 52:
                        i = indexCount2;
                        lVar.f16321j = typedArrayObtainStyledAttributes.getDimension(index2, lVar.f16321j);
                        continue;
                        i14++;
                    case FastDoubleMath.DOUBLE_SIGNIFICAND_WIDTH /* 53 */:
                        i = indexCount2;
                        lVar.f16322k = typedArrayObtainStyledAttributes.getDimension(index2, lVar.f16322k);
                        continue;
                        i14++;
                    case 54:
                        i = indexCount2;
                        iVar.X = typedArrayObtainStyledAttributes.getInt(index2, iVar.X);
                        continue;
                        i14++;
                    case 55:
                        i = indexCount2;
                        iVar.Y = typedArrayObtainStyledAttributes.getInt(index2, iVar.Y);
                        continue;
                        i14++;
                    case 56:
                        i = indexCount2;
                        iVar.Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.Z);
                        continue;
                        i14++;
                    case 57:
                        i = indexCount2;
                        iVar.f16262a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.f16262a0);
                        continue;
                        i14++;
                    case 58:
                        i = indexCount2;
                        iVar.f16264b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.f16264b0);
                        continue;
                        i14++;
                    case 59:
                        i = indexCount2;
                        iVar.f16266c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.f16266c0);
                        continue;
                        i14++;
                    case 60:
                        i = indexCount2;
                        lVar.f16313a = typedArrayObtainStyledAttributes.getFloat(index2, lVar.f16313a);
                        continue;
                        i14++;
                    case 61:
                        i = indexCount2;
                        iVar.f16298z = e(typedArrayObtainStyledAttributes, index2, iVar.f16298z);
                        continue;
                        i14++;
                    case 62:
                        i = indexCount2;
                        iVar.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.A);
                        continue;
                        i14++;
                    case 63:
                        i = indexCount2;
                        iVar.B = typedArrayObtainStyledAttributes.getFloat(index2, iVar.B);
                        continue;
                        i14++;
                    case 64:
                        i = indexCount2;
                        jVar.f16300a = e(typedArrayObtainStyledAttributes, index2, jVar.f16300a);
                        continue;
                        i14++;
                    case 65:
                        i = indexCount2;
                        if (typedArrayObtainStyledAttributes.peekValue(index2).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index2);
                            jVar.getClass();
                            break;
                        } else {
                            String str = strArr[typedArrayObtainStyledAttributes.getInteger(index2, 0)];
                            jVar.getClass();
                            i14++;
                        }
                    case 66:
                        i = indexCount2;
                        typedArrayObtainStyledAttributes.getInt(index2, 0);
                        jVar.getClass();
                        continue;
                        i14++;
                    case 67:
                        i = indexCount2;
                        jVar.f16304e = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f16304e);
                        break;
                    case 68:
                        i = indexCount2;
                        kVar.f16311d = typedArrayObtainStyledAttributes.getFloat(index2, kVar.f16311d);
                        break;
                    case 69:
                        i = indexCount2;
                        iVar.f16268d0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 70:
                        i = indexCount2;
                        iVar.e0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 71:
                        i = indexCount2;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i = indexCount2;
                        iVar.f0 = typedArrayObtainStyledAttributes.getInt(index2, iVar.f0);
                        break;
                    case 73:
                        i = indexCount2;
                        iVar.f16272g0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.f16272g0);
                        break;
                    case 74:
                        i = indexCount2;
                        iVar.f16277j0 = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 75:
                        i = indexCount2;
                        iVar.f16285n0 = typedArrayObtainStyledAttributes.getBoolean(index2, iVar.f16285n0);
                        break;
                    case 76:
                        i = indexCount2;
                        jVar.f16302c = typedArrayObtainStyledAttributes.getInt(index2, jVar.f16302c);
                        break;
                    case 77:
                        i = indexCount2;
                        iVar.f16279k0 = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 78:
                        i = indexCount2;
                        kVar.f16309b = typedArrayObtainStyledAttributes.getInt(index2, kVar.f16309b);
                        break;
                    case 79:
                        i = indexCount2;
                        jVar.f16303d = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f16303d);
                        break;
                    case 80:
                        i = indexCount2;
                        iVar.f16281l0 = typedArrayObtainStyledAttributes.getBoolean(index2, iVar.f16281l0);
                        break;
                    case 81:
                        i = indexCount2;
                        iVar.f16283m0 = typedArrayObtainStyledAttributes.getBoolean(index2, iVar.f16283m0);
                        break;
                    case 82:
                        i = indexCount2;
                        jVar.f16301b = typedArrayObtainStyledAttributes.getInteger(index2, jVar.f16301b);
                        break;
                    case 83:
                        i = indexCount2;
                        lVar.f16320h = e(typedArrayObtainStyledAttributes, index2, lVar.f16320h);
                        break;
                    case 84:
                        i = indexCount2;
                        jVar.f16306g = typedArrayObtainStyledAttributes.getInteger(index2, jVar.f16306g);
                        break;
                    case 85:
                        i = indexCount2;
                        jVar.f16305f = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f16305f);
                        break;
                    case 86:
                        i = indexCount2;
                        int i16 = typedArrayObtainStyledAttributes.peekValue(index2).type;
                        if (i16 == 1) {
                            jVar.i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                            break;
                        } else if (i16 == 3) {
                            String string2 = typedArrayObtainStyledAttributes.getString(index2);
                            jVar.f16307h = string2;
                            if (string2.indexOf("/") > 0) {
                                jVar.i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                                break;
                            }
                        } else {
                            typedArrayObtainStyledAttributes.getInteger(index2, jVar.i);
                            break;
                        }
                        break;
                    case 87:
                        i = indexCount2;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index2) + "   " + sparseIntArray.get(index2));
                        break;
                    case 88:
                    case 89:
                    case 90:
                    default:
                        StringBuilder sb3 = new StringBuilder("Unknown attribute 0x");
                        i = indexCount2;
                        sb3.append(Integer.toHexString(index2));
                        sb3.append("   ");
                        sb3.append(sparseIntArray.get(index2));
                        Log.w("ConstraintSet", sb3.toString());
                        break;
                    case 91:
                        i = indexCount2;
                        iVar.f16289q = e(typedArrayObtainStyledAttributes, index2, iVar.f16289q);
                        break;
                    case 92:
                        i = indexCount2;
                        iVar.f16290r = e(typedArrayObtainStyledAttributes, index2, iVar.f16290r);
                        break;
                    case 93:
                        i = indexCount2;
                        iVar.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.L);
                        break;
                    case 94:
                        i = indexCount2;
                        iVar.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, iVar.S);
                        break;
                    case 95:
                        i = indexCount2;
                        f(iVar, typedArrayObtainStyledAttributes, index2, 0);
                        continue;
                        i14++;
                    case 96:
                        i = indexCount2;
                        f(iVar, typedArrayObtainStyledAttributes, index2, 1);
                        break;
                    case 97:
                        i = indexCount2;
                        iVar.f16287o0 = typedArrayObtainStyledAttributes.getInt(index2, iVar.f16287o0);
                        break;
                }
                i14++;
            }
            if (iVar.f16277j0 != null) {
                iVar.f16275i0 = null;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return hVar;
    }

    public static int e(TypedArray typedArray, int i, int i3) {
        int resourceId = typedArray.getResourceId(i, i3);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f(java.lang.Object r7, android.content.res.TypedArray r8, int r9, int r10) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.m.f(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void g(d dVar, String str) throws NumberFormatException {
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i = -1;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                i = strSubstring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST) ? 0 : strSubstring.equalsIgnoreCase("H") ? 1 : -1;
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
                        float f5 = Float.parseFloat(strSubstring3);
                        float f10 = Float.parseFloat(strSubstring4);
                        if (f5 > 0.0f && f10 > 0.0f) {
                            if (i == 1) {
                                Math.abs(f10 / f5);
                            } else {
                                Math.abs(f5 / f10);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        dVar.G = str;
    }

    public final void a(int i, Context context) {
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        m mVar = this;
        ConstraintLayout constraintLayout3 = (ConstraintLayout) LayoutInflater.from(context).inflate(i, (ViewGroup) null);
        int childCount = constraintLayout3.getChildCount();
        HashMap map = mVar.f16330c;
        map.clear();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = constraintLayout3.getChildAt(i3);
            d dVar = (d) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (mVar.f16329b && id2 == -1) {
                od.f.o("All children of ConstraintLayout must have ids to use ConstraintSet");
                return;
            }
            if (!map.containsKey(Integer.valueOf(id2))) {
                map.put(Integer.valueOf(id2), new h());
            }
            h hVar = (h) map.get(Integer.valueOf(id2));
            if (hVar == null) {
                constraintLayout = constraintLayout3;
            } else {
                k kVar = hVar.f16255b;
                i iVar = hVar.f16257d;
                l lVar = hVar.f16258e;
                HashMap map2 = new HashMap();
                Class<?> cls = childAt.getClass();
                HashMap map3 = mVar.f16328a;
                for (String str : map3.keySet()) {
                    a aVar = (a) map3.get(str);
                    HashMap map4 = map3;
                    try {
                        if (str.equals("BackgroundColor")) {
                            constraintLayout2 = constraintLayout3;
                            try {
                                map2.put(str, new a(aVar, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                            } catch (IllegalAccessException e10) {
                                e = e10;
                                e.printStackTrace();
                                constraintLayout3 = constraintLayout2;
                                map3 = map4;
                            } catch (NoSuchMethodException e11) {
                                e = e11;
                                e.printStackTrace();
                                constraintLayout3 = constraintLayout2;
                                map3 = map4;
                            } catch (InvocationTargetException e12) {
                                e = e12;
                                e.printStackTrace();
                                constraintLayout3 = constraintLayout2;
                                map3 = map4;
                            }
                        } else {
                            constraintLayout2 = constraintLayout3;
                            map2.put(str, new a(aVar, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                        }
                    } catch (IllegalAccessException e13) {
                        e = e13;
                        constraintLayout2 = constraintLayout3;
                    } catch (NoSuchMethodException e14) {
                        e = e14;
                        constraintLayout2 = constraintLayout3;
                    } catch (InvocationTargetException e15) {
                        e = e15;
                        constraintLayout2 = constraintLayout3;
                    }
                    constraintLayout3 = constraintLayout2;
                    map3 = map4;
                }
                constraintLayout = constraintLayout3;
                hVar.f16259f = map2;
                hVar.f16254a = id2;
                iVar.f16273h = dVar.f16199e;
                iVar.i = dVar.f16200f;
                iVar.f16276j = dVar.f16201g;
                iVar.f16278k = dVar.f16203h;
                iVar.f16280l = dVar.i;
                iVar.f16282m = dVar.f16206j;
                iVar.f16284n = dVar.f16208k;
                iVar.f16286o = dVar.f16210l;
                iVar.f16288p = dVar.f16212m;
                iVar.f16289q = dVar.f16214n;
                iVar.f16290r = dVar.f16216o;
                iVar.f16291s = dVar.f16222s;
                iVar.f16292t = dVar.f16223t;
                iVar.f16293u = dVar.f16224u;
                iVar.f16294v = dVar.f16225v;
                iVar.f16295w = dVar.E;
                iVar.f16296x = dVar.F;
                iVar.f16297y = dVar.G;
                iVar.f16298z = dVar.f16218p;
                iVar.A = dVar.f16220q;
                iVar.B = dVar.f16221r;
                iVar.C = dVar.T;
                iVar.D = dVar.U;
                iVar.E = dVar.V;
                iVar.f16270f = dVar.f16195c;
                iVar.f16267d = dVar.f16191a;
                iVar.f16269e = dVar.f16193b;
                iVar.f16263b = ((ViewGroup.MarginLayoutParams) dVar).width;
                iVar.f16265c = ((ViewGroup.MarginLayoutParams) dVar).height;
                iVar.F = ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
                iVar.G = ((ViewGroup.MarginLayoutParams) dVar).rightMargin;
                iVar.H = ((ViewGroup.MarginLayoutParams) dVar).topMargin;
                iVar.I = ((ViewGroup.MarginLayoutParams) dVar).bottomMargin;
                iVar.L = dVar.D;
                iVar.T = dVar.I;
                iVar.U = dVar.H;
                iVar.W = dVar.K;
                iVar.V = dVar.J;
                iVar.f16281l0 = dVar.W;
                iVar.f16283m0 = dVar.X;
                iVar.X = dVar.L;
                iVar.Y = dVar.M;
                iVar.Z = dVar.P;
                iVar.f16262a0 = dVar.Q;
                iVar.f16264b0 = dVar.N;
                iVar.f16266c0 = dVar.O;
                iVar.f16268d0 = dVar.R;
                iVar.e0 = dVar.S;
                iVar.f16279k0 = dVar.Y;
                iVar.N = dVar.f16227x;
                iVar.P = dVar.f16229z;
                iVar.M = dVar.f16226w;
                iVar.O = dVar.f16228y;
                iVar.R = dVar.A;
                iVar.Q = dVar.B;
                iVar.S = dVar.C;
                iVar.f16287o0 = dVar.Z;
                iVar.J = dVar.getMarginEnd();
                iVar.K = dVar.getMarginStart();
                kVar.f16308a = childAt.getVisibility();
                kVar.f16310c = childAt.getAlpha();
                lVar.f16313a = childAt.getRotation();
                lVar.f16314b = childAt.getRotationX();
                lVar.f16315c = childAt.getRotationY();
                lVar.f16316d = childAt.getScaleX();
                lVar.f16317e = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    lVar.f16318f = pivotX;
                    lVar.f16319g = pivotY;
                }
                lVar.i = childAt.getTranslationX();
                lVar.f16321j = childAt.getTranslationY();
                lVar.f16322k = childAt.getTranslationZ();
                if (lVar.f16323l) {
                    lVar.f16324m = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    iVar.f16285n0 = barrier.getAllowsGoneWidget();
                    iVar.f16275i0 = barrier.getReferencedIds();
                    iVar.f0 = barrier.getType();
                    iVar.f16272g0 = barrier.getMargin();
                }
            }
            i3++;
            mVar = this;
            constraintLayout3 = constraintLayout;
        }
    }

    public final void d(int i, Context context) throws XmlPullParserException, Resources.NotFoundException, IOException, NumberFormatException {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    h hVarC = c(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        hVarC.f16257d.f16261a = true;
                    }
                    this.f16330c.put(Integer.valueOf(hVarC.f16254a), hVarC);
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }
}
