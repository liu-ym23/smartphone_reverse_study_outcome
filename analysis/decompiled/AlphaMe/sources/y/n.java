package y;

import android.content.Context;
import android.content.res.Resources;
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
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.net.SyslogConstants;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.entity.pb.PoiResult;
import com.baidu.location.LocationConst;
import com.google.android.gms.location.Priority;
import com.stepos.alphame.utils.Property;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import net.zetetic.database.DatabaseUtils;
import org.xmlpull.v1.XmlPullParserException;
import u.AbstractC0935a;
import x.AbstractC0978a;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f16144d = {0, 4, 8};

    /* renamed from: e, reason: collision with root package name */
    public static final SparseIntArray f16145e;

    /* renamed from: f, reason: collision with root package name */
    public static final SparseIntArray f16146f;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f16147a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final boolean f16148b = true;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f16149c = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16145e = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f16146f = sparseIntArray2;
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
        sparseIntArray.append(Priority.PRIORITY_PASSIVE, 12);
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
        sparseIntArray.append(LocationConst.TrafficStatus.TRAFFIC_ERROR_PREDICT_MODEL_CUL_FAILED, 79);
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
        sparseIntArray.append(SyslogConstants.LOG_CLOCK, 83);
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
        sparseIntArray2.append(Priority.PRIORITY_PASSIVE, 65);
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

    public static int[] c(C0982a c0982a, String str) throws IllegalAccessException, IllegalArgumentException {
        int iIntValue;
        HashMap map;
        String[] strArrSplit = str.split(",");
        Context context = c0982a.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i4 = 0;
        int i5 = 0;
        while (i4 < strArrSplit.length) {
            String strTrim = strArrSplit[i4].trim();
            Object obj = null;
            try {
                iIntValue = q.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && c0982a.isInEditMode() && (c0982a.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) c0982a.getParent();
                constraintLayout.getClass();
                if ((strTrim instanceof String) && (map = constraintLayout.f3241m) != null && map.containsKey(strTrim)) {
                    obj = constraintLayout.f3241m.get(strTrim);
                }
                if (obj != null && (obj instanceof Integer)) {
                    iIntValue = ((Integer) obj).intValue();
                }
            }
            iArr[i5] = iIntValue;
            i4++;
            i5++;
        }
        return i5 != strArrSplit.length ? Arrays.copyOf(iArr, i5) : iArr;
    }

    public static i d(Context context, AttributeSet attributeSet, boolean z4) {
        int i4;
        String str;
        String str2;
        SparseIntArray sparseIntArray;
        String str3;
        i iVar = new i();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z4 ? r.f16153c : r.f16151a);
        int[] iArr = f16144d;
        SparseIntArray sparseIntArray2 = f16145e;
        String[] strArr = AbstractC0935a.f15448a;
        l lVar = iVar.f16044b;
        m mVar = iVar.f16047e;
        k kVar = iVar.f16045c;
        j jVar = iVar.f16046d;
        String str4 = "Unknown attribute 0x";
        if (z4) {
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            h hVar = new h();
            hVar.f16031a = new int[10];
            hVar.f16032b = new int[10];
            hVar.f16033c = 0;
            hVar.f16034d = new int[10];
            hVar.f16035e = new float[10];
            hVar.f16036f = 0;
            hVar.f16037g = new int[5];
            hVar.f16038h = new String[5];
            hVar.f16039i = 0;
            hVar.f16040j = new int[4];
            hVar.f16041k = new boolean[4];
            hVar.f16042l = 0;
            kVar.getClass();
            jVar.getClass();
            lVar.getClass();
            mVar.getClass();
            int i5 = 0;
            while (i5 < indexCount) {
                int index = typedArrayObtainStyledAttributes.getIndex(i5);
                int i6 = indexCount;
                switch (f16146f.get(index)) {
                    case 2:
                        str3 = str4;
                        hVar.b(2, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16058I));
                        continue;
                        i5++;
                        indexCount = i6;
                        str4 = str3;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case 25:
                    case 26:
                    case 29:
                    case 30:
                    case 32:
                    case 33:
                    case 35:
                    case 36:
                    case 61:
                    case 88:
                    case Opcodes.DUP /* 89 */:
                    case 90:
                    case 91:
                    case 92:
                    default:
                        StringBuilder sb = new StringBuilder(str4);
                        str3 = str4;
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(sparseIntArray2.get(index));
                        Log.w("ConstraintSet", sb.toString());
                        break;
                    case 5:
                        str3 = str4;
                        hVar.c(5, typedArrayObtainStyledAttributes.getString(index));
                        continue;
                        i5++;
                        indexCount = i6;
                        str4 = str3;
                    case 6:
                        str3 = str4;
                        hVar.b(6, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, jVar.f16052C));
                        break;
                    case 7:
                        str3 = str4;
                        hVar.b(7, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, jVar.f16053D));
                        break;
                    case 8:
                        str3 = str4;
                        hVar.b(8, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16059J));
                        break;
                    case 11:
                        str3 = str4;
                        hVar.b(11, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16065P));
                        break;
                    case 12:
                        str3 = str4;
                        hVar.b(12, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16066Q));
                        break;
                    case 13:
                        str3 = str4;
                        hVar.b(13, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16062M));
                        break;
                    case 14:
                        str3 = str4;
                        hVar.b(14, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16064O));
                        break;
                    case 15:
                        str3 = str4;
                        hVar.b(15, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16067R));
                        break;
                    case 16:
                        str3 = str4;
                        hVar.b(16, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16063N));
                        break;
                    case 17:
                        str3 = str4;
                        hVar.b(17, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, jVar.f16081d));
                        break;
                    case 18:
                        str3 = str4;
                        hVar.b(18, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, jVar.f16083e));
                        break;
                    case 19:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getFloat(index, jVar.f16085f), 19);
                        break;
                    case 20:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getFloat(index, jVar.f16112w), 20);
                        break;
                    case 21:
                        str3 = str4;
                        hVar.b(21, typedArrayObtainStyledAttributes.getLayoutDimension(index, jVar.f16079c));
                        break;
                    case 22:
                        str3 = str4;
                        hVar.b(22, iArr[typedArrayObtainStyledAttributes.getInt(index, lVar.f16126a)]);
                        break;
                    case 23:
                        str3 = str4;
                        hVar.b(23, typedArrayObtainStyledAttributes.getLayoutDimension(index, jVar.f16077b));
                        break;
                    case 24:
                        str3 = str4;
                        hVar.b(24, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16055F));
                        break;
                    case 27:
                        str3 = str4;
                        hVar.b(27, typedArrayObtainStyledAttributes.getInt(index, jVar.f16054E));
                        break;
                    case 28:
                        str3 = str4;
                        hVar.b(28, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16056G));
                        break;
                    case 31:
                        str3 = str4;
                        hVar.b(31, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16060K));
                        break;
                    case 34:
                        str3 = str4;
                        hVar.b(34, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16057H));
                        break;
                    case 37:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getFloat(index, jVar.f16113x), 37);
                        break;
                    case 38:
                        str3 = str4;
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, iVar.f16043a);
                        iVar.f16043a = resourceId;
                        hVar.b(38, resourceId);
                        break;
                    case 39:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getFloat(index, jVar.f16069U), 39);
                        break;
                    case 40:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getFloat(index, jVar.T), 40);
                        break;
                    case 41:
                        str3 = str4;
                        hVar.b(41, typedArrayObtainStyledAttributes.getInt(index, jVar.f16070V));
                        break;
                    case 42:
                        str3 = str4;
                        hVar.b(42, typedArrayObtainStyledAttributes.getInt(index, jVar.f16071W));
                        break;
                    case 43:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getFloat(index, lVar.f16128c), 43);
                        break;
                    case 44:
                        str3 = str4;
                        hVar.d(44, true);
                        hVar.a(typedArrayObtainStyledAttributes.getDimension(index, mVar.f16143m), 44);
                        break;
                    case 45:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getFloat(index, mVar.f16132b), 45);
                        break;
                    case 46:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getFloat(index, mVar.f16133c), 46);
                        break;
                    case 47:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getFloat(index, mVar.f16134d), 47);
                        break;
                    case 48:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getFloat(index, mVar.f16135e), 48);
                        break;
                    case 49:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getDimension(index, mVar.f16136f), 49);
                        break;
                    case 50:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getDimension(index, mVar.f16137g), 50);
                        break;
                    case 51:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getDimension(index, mVar.f16139i), 51);
                        break;
                    case 52:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getDimension(index, mVar.f16140j), 52);
                        break;
                    case 53:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getDimension(index, mVar.f16141k), 53);
                        break;
                    case 54:
                        str3 = str4;
                        hVar.b(54, typedArrayObtainStyledAttributes.getInt(index, jVar.f16072X));
                        break;
                    case 55:
                        str3 = str4;
                        hVar.b(55, typedArrayObtainStyledAttributes.getInt(index, jVar.f16073Y));
                        break;
                    case 56:
                        str3 = str4;
                        hVar.b(56, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16074Z));
                        break;
                    case 57:
                        str3 = str4;
                        hVar.b(57, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16076a0));
                        break;
                    case 58:
                        str3 = str4;
                        hVar.b(58, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16078b0));
                        break;
                    case PoiResult.Contents.CITY_FIELD_NUMBER /* 59 */:
                        str3 = str4;
                        hVar.b(59, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16080c0));
                        break;
                    case PoiResult.Contents.PROVINCE_FIELD_NUMBER /* 60 */:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getFloat(index, mVar.f16131a), 60);
                        break;
                    case 62:
                        str3 = str4;
                        hVar.b(62, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16050A));
                        break;
                    case 63:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getFloat(index, jVar.f16051B), 63);
                        break;
                    case 64:
                        str3 = str4;
                        hVar.b(64, f(typedArrayObtainStyledAttributes, index, kVar.f16117a));
                        break;
                    case 65:
                        str3 = str4;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type != 3) {
                            hVar.c(65, strArr[typedArrayObtainStyledAttributes.getInteger(index, 0)]);
                            break;
                        } else {
                            hVar.c(65, typedArrayObtainStyledAttributes.getString(index));
                            break;
                        }
                    case 66:
                        str3 = str4;
                        hVar.b(66, typedArrayObtainStyledAttributes.getInt(index, 0));
                        break;
                    case 67:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getFloat(index, kVar.f16121e), 67);
                        break;
                    case 68:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getFloat(index, lVar.f16129d), 68);
                        break;
                    case 69:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getFloat(index, 1.0f), 69);
                        break;
                    case 70:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getFloat(index, 1.0f), 70);
                        break;
                    case 71:
                        str3 = str4;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        str3 = str4;
                        hVar.b(72, typedArrayObtainStyledAttributes.getInt(index, jVar.f16086f0));
                        break;
                    case PoiResult.Contents.HEAD_RESULT_MSG_FIELD_NUMBER /* 73 */:
                        str3 = str4;
                        hVar.b(73, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16088g0));
                        break;
                    case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                        str3 = str4;
                        hVar.c(74, typedArrayObtainStyledAttributes.getString(index));
                        break;
                    case PoiResult.Contents.BAR_BUTTON_FIELD_NUMBER /* 75 */:
                        str3 = str4;
                        hVar.d(75, typedArrayObtainStyledAttributes.getBoolean(index, jVar.f16102n0));
                        break;
                    case 76:
                        str3 = str4;
                        hVar.b(76, typedArrayObtainStyledAttributes.getInt(index, kVar.f16119c));
                        break;
                    case PoiResult.Contents.CARD_TYPE_FIELD_NUMBER /* 77 */:
                        str3 = str4;
                        hVar.c(77, typedArrayObtainStyledAttributes.getString(index));
                        break;
                    case PoiResult.Contents.ADVERTISE_INFO_FIELD_NUMBER /* 78 */:
                        str3 = str4;
                        hVar.b(78, typedArrayObtainStyledAttributes.getInt(index, lVar.f16127b));
                        break;
                    case 79:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getFloat(index, kVar.f16120d), 79);
                        break;
                    case 80:
                        str3 = str4;
                        hVar.d(80, typedArrayObtainStyledAttributes.getBoolean(index, jVar.f16098l0));
                        break;
                    case 81:
                        str3 = str4;
                        hVar.d(81, typedArrayObtainStyledAttributes.getBoolean(index, jVar.f16100m0));
                        break;
                    case PoiResult.Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                        str3 = str4;
                        hVar.b(82, typedArrayObtainStyledAttributes.getInteger(index, kVar.f16118b));
                        break;
                    case 83:
                        str3 = str4;
                        hVar.b(83, f(typedArrayObtainStyledAttributes, index, mVar.f16138h));
                        break;
                    case PoiResult.Contents.FAV_BUBBLE_FIELD_NUMBER /* 84 */:
                        str3 = str4;
                        hVar.b(84, typedArrayObtainStyledAttributes.getInteger(index, kVar.f16123g));
                        break;
                    case PoiResult.Contents.GUILD_BUTTON_FIELD_NUMBER /* 85 */:
                        str3 = str4;
                        hVar.a(typedArrayObtainStyledAttributes.getFloat(index, kVar.f16122f), 85);
                        break;
                    case PoiResult.Contents.BOUND_FIELD_NUMBER /* 86 */:
                        str3 = str4;
                        int i7 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i7 != 1) {
                            if (i7 != 3) {
                                hVar.b(88, typedArrayObtainStyledAttributes.getInteger(index, kVar.f16125i));
                                break;
                            } else {
                                String string = typedArrayObtainStyledAttributes.getString(index);
                                kVar.f16124h = string;
                                hVar.c(90, string);
                                if (kVar.f16124h.indexOf("/") <= 0) {
                                    hVar.b(88, -1);
                                    break;
                                } else {
                                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                    kVar.f16125i = resourceId2;
                                    hVar.b(89, resourceId2);
                                    hVar.b(88, -2);
                                    break;
                                }
                            }
                        } else {
                            int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            kVar.f16125i = resourceId3;
                            hVar.b(89, resourceId3);
                            if (kVar.f16125i != -1) {
                                hVar.b(88, -2);
                                break;
                            }
                        }
                        break;
                    case 87:
                        str3 = str4;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray2.get(index));
                        break;
                    case 93:
                        str3 = str4;
                        hVar.b(93, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16061L));
                        break;
                    case 94:
                        str3 = str4;
                        hVar.b(94, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f16068S));
                        break;
                    case 95:
                        str3 = str4;
                        g(hVar, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 96:
                        str3 = str4;
                        g(hVar, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    case 97:
                        str3 = str4;
                        hVar.b(97, typedArrayObtainStyledAttributes.getInt(index, jVar.f16104o0));
                        break;
                    case 98:
                        str3 = str4;
                        int i8 = AbstractC0978a.f15868s;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type != 3) {
                            iVar.f16043a = typedArrayObtainStyledAttributes.getResourceId(index, iVar.f16043a);
                            break;
                        } else {
                            typedArrayObtainStyledAttributes.getString(index);
                            break;
                        }
                    case DatabaseUtils.STATEMENT_OTHER /* 99 */:
                        str3 = str4;
                        hVar.d(99, typedArrayObtainStyledAttributes.getBoolean(index, jVar.f16087g));
                        break;
                }
                i5++;
                indexCount = i6;
                str4 = str3;
            }
        } else {
            String str5 = "CURRENTLY UNSUPPORTED";
            String str6 = "Unknown attribute 0x";
            int indexCount2 = typedArrayObtainStyledAttributes.getIndexCount();
            int i9 = 0;
            while (i9 < indexCount2) {
                int index2 = typedArrayObtainStyledAttributes.getIndex(i9);
                if (index2 != 1 && 23 != index2 && 24 != index2) {
                    kVar.getClass();
                    jVar.getClass();
                    lVar.getClass();
                    mVar.getClass();
                }
                switch (sparseIntArray2.get(index2)) {
                    case 1:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16105p = f(typedArrayObtainStyledAttributes, index2, jVar.f16105p);
                        break;
                    case 2:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16058I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16058I);
                        break;
                    case 3:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16103o = f(typedArrayObtainStyledAttributes, index2, jVar.f16103o);
                        break;
                    case 4:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16101n = f(typedArrayObtainStyledAttributes, index2, jVar.f16101n);
                        break;
                    case 5:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16114y = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 6:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16052C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, jVar.f16052C);
                        break;
                    case 7:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16053D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, jVar.f16053D);
                        break;
                    case 8:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16059J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16059J);
                        break;
                    case 9:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16111v = f(typedArrayObtainStyledAttributes, index2, jVar.f16111v);
                        break;
                    case 10:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16110u = f(typedArrayObtainStyledAttributes, index2, jVar.f16110u);
                        break;
                    case 11:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16065P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16065P);
                        break;
                    case 12:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16066Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16066Q);
                        break;
                    case 13:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16062M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16062M);
                        break;
                    case 14:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16064O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16064O);
                        break;
                    case 15:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16067R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16067R);
                        break;
                    case 16:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16063N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16063N);
                        break;
                    case 17:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16081d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, jVar.f16081d);
                        break;
                    case 18:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16083e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, jVar.f16083e);
                        break;
                    case 19:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16085f = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f16085f);
                        break;
                    case 20:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16112w = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f16112w);
                        break;
                    case 21:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16079c = typedArrayObtainStyledAttributes.getLayoutDimension(index2, jVar.f16079c);
                        break;
                    case 22:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        lVar.f16126a = iArr[typedArrayObtainStyledAttributes.getInt(index2, lVar.f16126a)];
                        break;
                    case 23:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16077b = typedArrayObtainStyledAttributes.getLayoutDimension(index2, jVar.f16077b);
                        break;
                    case 24:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16055F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16055F);
                        break;
                    case 25:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16089h = f(typedArrayObtainStyledAttributes, index2, jVar.f16089h);
                        break;
                    case 26:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16091i = f(typedArrayObtainStyledAttributes, index2, jVar.f16091i);
                        break;
                    case 27:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16054E = typedArrayObtainStyledAttributes.getInt(index2, jVar.f16054E);
                        break;
                    case 28:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16056G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16056G);
                        break;
                    case 29:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16093j = f(typedArrayObtainStyledAttributes, index2, jVar.f16093j);
                        break;
                    case 30:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16095k = f(typedArrayObtainStyledAttributes, index2, jVar.f16095k);
                        break;
                    case 31:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16060K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16060K);
                        break;
                    case 32:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16108s = f(typedArrayObtainStyledAttributes, index2, jVar.f16108s);
                        break;
                    case 33:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16109t = f(typedArrayObtainStyledAttributes, index2, jVar.f16109t);
                        break;
                    case 34:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16057H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16057H);
                        break;
                    case 35:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16099m = f(typedArrayObtainStyledAttributes, index2, jVar.f16099m);
                        break;
                    case 36:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16097l = f(typedArrayObtainStyledAttributes, index2, jVar.f16097l);
                        break;
                    case 37:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16113x = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f16113x);
                        break;
                    case 38:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        iVar.f16043a = typedArrayObtainStyledAttributes.getResourceId(index2, iVar.f16043a);
                        break;
                    case 39:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16069U = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f16069U);
                        break;
                    case 40:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.T = typedArrayObtainStyledAttributes.getFloat(index2, jVar.T);
                        break;
                    case 41:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16070V = typedArrayObtainStyledAttributes.getInt(index2, jVar.f16070V);
                        break;
                    case 42:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16071W = typedArrayObtainStyledAttributes.getInt(index2, jVar.f16071W);
                        break;
                    case 43:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        lVar.f16128c = typedArrayObtainStyledAttributes.getFloat(index2, lVar.f16128c);
                        break;
                    case 44:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        mVar.f16142l = true;
                        mVar.f16143m = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f16143m);
                        break;
                    case 45:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        mVar.f16132b = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f16132b);
                        break;
                    case 46:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        mVar.f16133c = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f16133c);
                        break;
                    case 47:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        mVar.f16134d = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f16134d);
                        break;
                    case 48:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        mVar.f16135e = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f16135e);
                        break;
                    case 49:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        mVar.f16136f = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f16136f);
                        break;
                    case 50:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        mVar.f16137g = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f16137g);
                        break;
                    case 51:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        mVar.f16139i = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f16139i);
                        break;
                    case 52:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        mVar.f16140j = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f16140j);
                        break;
                    case 53:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        mVar.f16141k = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f16141k);
                        break;
                    case 54:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16072X = typedArrayObtainStyledAttributes.getInt(index2, jVar.f16072X);
                        break;
                    case 55:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16073Y = typedArrayObtainStyledAttributes.getInt(index2, jVar.f16073Y);
                        break;
                    case 56:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16074Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16074Z);
                        break;
                    case 57:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16076a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16076a0);
                        break;
                    case 58:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16078b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16078b0);
                        break;
                    case PoiResult.Contents.CITY_FIELD_NUMBER /* 59 */:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16080c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16080c0);
                        break;
                    case PoiResult.Contents.PROVINCE_FIELD_NUMBER /* 60 */:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        mVar.f16131a = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f16131a);
                        break;
                    case 61:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16115z = f(typedArrayObtainStyledAttributes, index2, jVar.f16115z);
                        break;
                    case 62:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16050A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16050A);
                        break;
                    case 63:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        jVar.f16051B = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f16051B);
                        break;
                    case 64:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        kVar.f16117a = f(typedArrayObtainStyledAttributes, index2, kVar.f16117a);
                        break;
                    case 65:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        sparseIntArray = sparseIntArray2;
                        if (typedArrayObtainStyledAttributes.peekValue(index2).type != 3) {
                            String str7 = strArr[typedArrayObtainStyledAttributes.getInteger(index2, 0)];
                            kVar.getClass();
                            break;
                        } else {
                            typedArrayObtainStyledAttributes.getString(index2);
                            kVar.getClass();
                            break;
                        }
                    case 66:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        typedArrayObtainStyledAttributes.getInt(index2, 0);
                        kVar.getClass();
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 67:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        kVar.f16121e = typedArrayObtainStyledAttributes.getFloat(index2, kVar.f16121e);
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 68:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        lVar.f16129d = typedArrayObtainStyledAttributes.getFloat(index2, lVar.f16129d);
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 69:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        jVar.f16082d0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 70:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        jVar.f16084e0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 71:
                        i4 = indexCount2;
                        str = str5;
                        str2 = str6;
                        Log.e("ConstraintSet", str);
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 72:
                        i4 = indexCount2;
                        str2 = str6;
                        jVar.f16086f0 = typedArrayObtainStyledAttributes.getInt(index2, jVar.f16086f0);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case PoiResult.Contents.HEAD_RESULT_MSG_FIELD_NUMBER /* 73 */:
                        i4 = indexCount2;
                        str2 = str6;
                        jVar.f16088g0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16088g0);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                        i4 = indexCount2;
                        str2 = str6;
                        jVar.f16094j0 = typedArrayObtainStyledAttributes.getString(index2);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case PoiResult.Contents.BAR_BUTTON_FIELD_NUMBER /* 75 */:
                        i4 = indexCount2;
                        str2 = str6;
                        jVar.f16102n0 = typedArrayObtainStyledAttributes.getBoolean(index2, jVar.f16102n0);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 76:
                        i4 = indexCount2;
                        str2 = str6;
                        kVar.f16119c = typedArrayObtainStyledAttributes.getInt(index2, kVar.f16119c);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case PoiResult.Contents.CARD_TYPE_FIELD_NUMBER /* 77 */:
                        i4 = indexCount2;
                        str2 = str6;
                        jVar.f16096k0 = typedArrayObtainStyledAttributes.getString(index2);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case PoiResult.Contents.ADVERTISE_INFO_FIELD_NUMBER /* 78 */:
                        i4 = indexCount2;
                        str2 = str6;
                        lVar.f16127b = typedArrayObtainStyledAttributes.getInt(index2, lVar.f16127b);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 79:
                        i4 = indexCount2;
                        str2 = str6;
                        kVar.f16120d = typedArrayObtainStyledAttributes.getFloat(index2, kVar.f16120d);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 80:
                        i4 = indexCount2;
                        str2 = str6;
                        jVar.f16098l0 = typedArrayObtainStyledAttributes.getBoolean(index2, jVar.f16098l0);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 81:
                        i4 = indexCount2;
                        str2 = str6;
                        jVar.f16100m0 = typedArrayObtainStyledAttributes.getBoolean(index2, jVar.f16100m0);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case PoiResult.Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                        i4 = indexCount2;
                        str2 = str6;
                        kVar.f16118b = typedArrayObtainStyledAttributes.getInteger(index2, kVar.f16118b);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 83:
                        i4 = indexCount2;
                        str2 = str6;
                        mVar.f16138h = f(typedArrayObtainStyledAttributes, index2, mVar.f16138h);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case PoiResult.Contents.FAV_BUBBLE_FIELD_NUMBER /* 84 */:
                        i4 = indexCount2;
                        str2 = str6;
                        kVar.f16123g = typedArrayObtainStyledAttributes.getInteger(index2, kVar.f16123g);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case PoiResult.Contents.GUILD_BUTTON_FIELD_NUMBER /* 85 */:
                        i4 = indexCount2;
                        str2 = str6;
                        kVar.f16122f = typedArrayObtainStyledAttributes.getFloat(index2, kVar.f16122f);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case PoiResult.Contents.BOUND_FIELD_NUMBER /* 86 */:
                        i4 = indexCount2;
                        str2 = str6;
                        int i10 = typedArrayObtainStyledAttributes.peekValue(index2).type;
                        if (i10 == 1) {
                            kVar.f16125i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                        } else if (i10 == 3) {
                            String string2 = typedArrayObtainStyledAttributes.getString(index2);
                            kVar.f16124h = string2;
                            if (string2.indexOf("/") > 0) {
                                kVar.f16125i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                            }
                        } else {
                            typedArrayObtainStyledAttributes.getInteger(index2, kVar.f16125i);
                        }
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 87:
                        i4 = indexCount2;
                        str2 = str6;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index2) + "   " + sparseIntArray2.get(index2));
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 88:
                    case Opcodes.DUP /* 89 */:
                    case 90:
                    default:
                        str2 = str6;
                        StringBuilder sb2 = new StringBuilder(str2);
                        i4 = indexCount2;
                        sb2.append(Integer.toHexString(index2));
                        sb2.append("   ");
                        sb2.append(sparseIntArray2.get(index2));
                        Log.w("ConstraintSet", sb2.toString());
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 91:
                        i4 = indexCount2;
                        str2 = str6;
                        jVar.f16106q = f(typedArrayObtainStyledAttributes, index2, jVar.f16106q);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 92:
                        i4 = indexCount2;
                        str2 = str6;
                        jVar.f16107r = f(typedArrayObtainStyledAttributes, index2, jVar.f16107r);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 93:
                        i4 = indexCount2;
                        str2 = str6;
                        jVar.f16061L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16061L);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 94:
                        i4 = indexCount2;
                        str2 = str6;
                        jVar.f16068S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f16068S);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 95:
                        i4 = indexCount2;
                        str2 = str6;
                        g(jVar, typedArrayObtainStyledAttributes, index2, 0);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 96:
                        i4 = indexCount2;
                        str2 = str6;
                        g(jVar, typedArrayObtainStyledAttributes, index2, 1);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                    case 97:
                        i4 = indexCount2;
                        str2 = str6;
                        jVar.f16104o0 = typedArrayObtainStyledAttributes.getInt(index2, jVar.f16104o0);
                        str = str5;
                        sparseIntArray = sparseIntArray2;
                        break;
                }
                i9++;
                indexCount2 = i4;
                str6 = str2;
                sparseIntArray2 = sparseIntArray;
                str5 = str;
            }
            if (jVar.f16094j0 != null) {
                jVar.f16092i0 = null;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return iVar;
    }

    public static int f(TypedArray typedArray, int i4, int i5) {
        int resourceId = typedArray.getResourceId(i4, i5);
        return resourceId == -1 ? typedArray.getInt(i4, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(java.lang.Object r7, android.content.res.TypedArray r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.n.g(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void h(e eVar, String str) throws NumberFormatException {
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i4 = -1;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                i4 = strSubstring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST) ? 0 : strSubstring.equalsIgnoreCase("H") ? 1 : -1;
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
                        float f4 = Float.parseFloat(strSubstring3);
                        float f5 = Float.parseFloat(strSubstring4);
                        if (f4 > Property.DEFAULT_FLOAT_VALUE && f5 > Property.DEFAULT_FLOAT_VALUE) {
                            if (i4 == 1) {
                                Math.abs(f5 / f4);
                            } else {
                                Math.abs(f4 / f5);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        eVar.f15959G = str;
    }

    public final void a(ConstraintLayout constraintLayout) throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ViewGroup viewGroup;
        int i4;
        int i5;
        String resourceEntryName;
        n nVar = this;
        ConstraintLayout constraintLayout2 = constraintLayout;
        int childCount = constraintLayout.getChildCount();
        HashMap map = nVar.f16149c;
        HashSet hashSet = new HashSet(map.keySet());
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = constraintLayout2.getChildAt(i6);
            int id = childAt.getId();
            if (!map.containsKey(Integer.valueOf(id))) {
                StringBuilder sb = new StringBuilder("id unknown ");
                try {
                    resourceEntryName = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    resourceEntryName = "UNKNOWN";
                }
                sb.append(resourceEntryName);
                Log.w("ConstraintSet", sb.toString());
            } else {
                if (nVar.f16148b && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (map.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        i iVar = (i) map.get(Integer.valueOf(id));
                        if (iVar != null) {
                            if (childAt instanceof C0982a) {
                                j jVar = iVar.f16046d;
                                jVar.f16090h0 = 1;
                                C0982a c0982a = (C0982a) childAt;
                                c0982a.setId(id);
                                c0982a.setType(jVar.f16086f0);
                                c0982a.setMargin(jVar.f16088g0);
                                c0982a.setAllowsGoneWidget(jVar.f16102n0);
                                int[] iArr = jVar.f16092i0;
                                if (iArr != null) {
                                    c0982a.setReferencedIds(iArr);
                                } else {
                                    String str = jVar.f16094j0;
                                    if (str != null) {
                                        int[] iArrC = c(c0982a, str);
                                        jVar.f16092i0 = iArrC;
                                        c0982a.setReferencedIds(iArrC);
                                    }
                                }
                            }
                            e eVar = (e) childAt.getLayoutParams();
                            eVar.a();
                            iVar.a(eVar);
                            HashMap map2 = iVar.f16048f;
                            Class<?> cls = childAt.getClass();
                            for (String str2 : map2.keySet()) {
                                C0983b c0983b = (C0983b) map2.get(str2);
                                String strM = !c0983b.f15938a ? B0.g.m("set", str2) : str2;
                                HashMap map3 = map2;
                                try {
                                    switch (t.h.a(c0983b.f15939b)) {
                                        case 0:
                                            i5 = childCount;
                                            Class<?>[] clsArr = new Class[1];
                                            try {
                                                clsArr[0] = Integer.TYPE;
                                                cls.getMethod(strM, clsArr).invoke(childAt, Integer.valueOf(c0983b.f15940c));
                                            } catch (IllegalAccessException e4) {
                                                e = e4;
                                                StringBuilder sbW = B0.g.w(" Custom Attribute \"", str2, "\" not found on ");
                                                sbW.append(cls.getName());
                                                Log.e("TransitionLayout", sbW.toString());
                                                e.printStackTrace();
                                                map2 = map3;
                                                childCount = i5;
                                            } catch (NoSuchMethodException e5) {
                                                e = e5;
                                                Log.e("TransitionLayout", e.getMessage());
                                                Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                                                Log.e("TransitionLayout", cls.getName() + " must have a method " + strM);
                                                map2 = map3;
                                                childCount = i5;
                                            } catch (InvocationTargetException e6) {
                                                e = e6;
                                                StringBuilder sbW2 = B0.g.w(" Custom Attribute \"", str2, "\" not found on ");
                                                sbW2.append(cls.getName());
                                                Log.e("TransitionLayout", sbW2.toString());
                                                e.printStackTrace();
                                                map2 = map3;
                                                childCount = i5;
                                            }
                                        case 1:
                                            i5 = childCount;
                                            cls.getMethod(strM, Float.TYPE).invoke(childAt, Float.valueOf(c0983b.f15941d));
                                            break;
                                        case 2:
                                            i5 = childCount;
                                            cls.getMethod(strM, Integer.TYPE).invoke(childAt, Integer.valueOf(c0983b.f15944g));
                                            break;
                                        case 3:
                                            i5 = childCount;
                                            Method method = cls.getMethod(strM, Drawable.class);
                                            ColorDrawable colorDrawable = new ColorDrawable();
                                            colorDrawable.setColor(c0983b.f15944g);
                                            method.invoke(childAt, colorDrawable);
                                            break;
                                        case 4:
                                            i5 = childCount;
                                            cls.getMethod(strM, CharSequence.class).invoke(childAt, c0983b.f15942e);
                                            break;
                                        case 5:
                                            i5 = childCount;
                                            cls.getMethod(strM, Boolean.TYPE).invoke(childAt, Boolean.valueOf(c0983b.f15943f));
                                            break;
                                        case 6:
                                            i5 = childCount;
                                            cls.getMethod(strM, Float.TYPE).invoke(childAt, Float.valueOf(c0983b.f15941d));
                                            break;
                                        case 7:
                                            i5 = childCount;
                                            try {
                                                cls.getMethod(strM, Integer.TYPE).invoke(childAt, Integer.valueOf(c0983b.f15940c));
                                            } catch (IllegalAccessException e7) {
                                                e = e7;
                                                StringBuilder sbW3 = B0.g.w(" Custom Attribute \"", str2, "\" not found on ");
                                                sbW3.append(cls.getName());
                                                Log.e("TransitionLayout", sbW3.toString());
                                                e.printStackTrace();
                                                map2 = map3;
                                                childCount = i5;
                                            } catch (NoSuchMethodException e8) {
                                                e = e8;
                                                Log.e("TransitionLayout", e.getMessage());
                                                Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                                                Log.e("TransitionLayout", cls.getName() + " must have a method " + strM);
                                                map2 = map3;
                                                childCount = i5;
                                            } catch (InvocationTargetException e9) {
                                                e = e9;
                                                StringBuilder sbW22 = B0.g.w(" Custom Attribute \"", str2, "\" not found on ");
                                                sbW22.append(cls.getName());
                                                Log.e("TransitionLayout", sbW22.toString());
                                                e.printStackTrace();
                                                map2 = map3;
                                                childCount = i5;
                                            }
                                        default:
                                            i5 = childCount;
                                            break;
                                    }
                                } catch (IllegalAccessException e10) {
                                    e = e10;
                                    i5 = childCount;
                                } catch (NoSuchMethodException e11) {
                                    e = e11;
                                    i5 = childCount;
                                } catch (InvocationTargetException e12) {
                                    e = e12;
                                    i5 = childCount;
                                }
                                map2 = map3;
                                childCount = i5;
                            }
                            i4 = childCount;
                            childAt.setLayoutParams(eVar);
                            l lVar = iVar.f16044b;
                            if (lVar.f16127b == 0) {
                                childAt.setVisibility(lVar.f16126a);
                            }
                            childAt.setAlpha(lVar.f16128c);
                            m mVar = iVar.f16047e;
                            childAt.setRotation(mVar.f16131a);
                            childAt.setRotationX(mVar.f16132b);
                            childAt.setRotationY(mVar.f16133c);
                            childAt.setScaleX(mVar.f16134d);
                            childAt.setScaleY(mVar.f16135e);
                            if (mVar.f16138h != -1) {
                                if (((View) childAt.getParent()).findViewById(mVar.f16138h) != null) {
                                    float bottom = (r1.getBottom() + r1.getTop()) / 2.0f;
                                    float right = (r1.getRight() + r1.getLeft()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(right - childAt.getLeft());
                                        childAt.setPivotY(bottom - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(mVar.f16136f)) {
                                    childAt.setPivotX(mVar.f16136f);
                                }
                                if (!Float.isNaN(mVar.f16137g)) {
                                    childAt.setPivotY(mVar.f16137g);
                                }
                            }
                            childAt.setTranslationX(mVar.f16139i);
                            childAt.setTranslationY(mVar.f16140j);
                            childAt.setTranslationZ(mVar.f16141k);
                            if (mVar.f16142l) {
                                childAt.setElevation(mVar.f16143m);
                            }
                        }
                    } else {
                        i4 = childCount;
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
                i6++;
                nVar = this;
                constraintLayout2 = constraintLayout;
                childCount = i4;
            }
            i4 = childCount;
            i6++;
            nVar = this;
            constraintLayout2 = constraintLayout;
            childCount = i4;
        }
        int i7 = childCount;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            i iVar2 = (i) map.get(num);
            if (iVar2 != null) {
                j jVar2 = iVar2.f16046d;
                if (jVar2.f16090h0 == 1) {
                    Context context = constraintLayout.getContext();
                    C0982a c0982a2 = new C0982a(context);
                    c0982a2.f15945a = new int[32];
                    c0982a2.f15951g = new HashMap();
                    c0982a2.f15947c = context;
                    c0982a2.g(null);
                    c0982a2.setVisibility(8);
                    c0982a2.setId(num.intValue());
                    int[] iArr2 = jVar2.f16092i0;
                    if (iArr2 != null) {
                        c0982a2.setReferencedIds(iArr2);
                    } else {
                        String str3 = jVar2.f16094j0;
                        if (str3 != null) {
                            int[] iArrC2 = c(c0982a2, str3);
                            jVar2.f16092i0 = iArrC2;
                            c0982a2.setReferencedIds(iArrC2);
                        }
                    }
                    c0982a2.setType(jVar2.f16086f0);
                    c0982a2.setMargin(jVar2.f16088g0);
                    e eVarA = ConstraintLayout.a();
                    c0982a2.i();
                    iVar2.a(eVarA);
                    viewGroup = constraintLayout;
                    viewGroup.addView(c0982a2, eVarA);
                } else {
                    viewGroup = constraintLayout;
                }
                if (jVar2.f16075a) {
                    p pVar = new p(constraintLayout.getContext());
                    pVar.setId(num.intValue());
                    e eVarA2 = ConstraintLayout.a();
                    iVar2.a(eVarA2);
                    viewGroup.addView(pVar, eVarA2);
                }
            }
        }
        for (int i8 = 0; i8 < i7; i8++) {
            View childAt2 = constraintLayout.getChildAt(i8);
            if (childAt2 instanceof AbstractC0984c) {
                ((AbstractC0984c) childAt2).e(constraintLayout);
            }
        }
    }

    public final void b(ConstraintLayout constraintLayout) {
        int i4;
        int i5;
        n nVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map = nVar.f16149c;
        map.clear();
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = constraintLayout.getChildAt(i6);
            e eVar = (e) childAt.getLayoutParams();
            int id = childAt.getId();
            if (nVar.f16148b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map.containsKey(Integer.valueOf(id))) {
                map.put(Integer.valueOf(id), new i());
            }
            i iVar = (i) map.get(Integer.valueOf(id));
            if (iVar == null) {
                i4 = childCount;
            } else {
                HashMap map2 = nVar.f16147a;
                HashMap map3 = new HashMap();
                Class<?> cls = childAt.getClass();
                for (String str : map2.keySet()) {
                    C0983b c0983b = (C0983b) map2.get(str);
                    try {
                        if (str.equals("BackgroundColor")) {
                            map3.put(str, new C0983b(c0983b, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                            i5 = childCount;
                        } else {
                            i5 = childCount;
                            try {
                                map3.put(str, new C0983b(c0983b, cls.getMethod("getMap" + str, new Class[0]).invoke(childAt, new Object[0])));
                            } catch (IllegalAccessException e4) {
                                e = e4;
                                e.printStackTrace();
                                childCount = i5;
                            } catch (NoSuchMethodException e5) {
                                e = e5;
                                e.printStackTrace();
                                childCount = i5;
                            } catch (InvocationTargetException e6) {
                                e = e6;
                                e.printStackTrace();
                                childCount = i5;
                            }
                        }
                    } catch (IllegalAccessException e7) {
                        e = e7;
                        i5 = childCount;
                    } catch (NoSuchMethodException e8) {
                        e = e8;
                        i5 = childCount;
                    } catch (InvocationTargetException e9) {
                        e = e9;
                        i5 = childCount;
                    }
                    childCount = i5;
                }
                i4 = childCount;
                iVar.f16048f = map3;
                iVar.f16043a = id;
                int i7 = eVar.f15986e;
                j jVar = iVar.f16046d;
                jVar.f16089h = i7;
                jVar.f16091i = eVar.f15988f;
                jVar.f16093j = eVar.f15990g;
                jVar.f16095k = eVar.f15992h;
                jVar.f16097l = eVar.f15994i;
                jVar.f16099m = eVar.f15996j;
                jVar.f16101n = eVar.f15998k;
                jVar.f16103o = eVar.f16000l;
                jVar.f16105p = eVar.f16002m;
                jVar.f16106q = eVar.f16004n;
                jVar.f16107r = eVar.f16006o;
                jVar.f16108s = eVar.f16012s;
                jVar.f16109t = eVar.f16013t;
                jVar.f16110u = eVar.f16014u;
                jVar.f16111v = eVar.f16015v;
                jVar.f16112w = eVar.f15957E;
                jVar.f16113x = eVar.f15958F;
                jVar.f16114y = eVar.f15959G;
                jVar.f16115z = eVar.f16008p;
                jVar.f16050A = eVar.f16010q;
                jVar.f16051B = eVar.f16011r;
                jVar.f16052C = eVar.T;
                jVar.f16053D = eVar.f15972U;
                jVar.f16054E = eVar.f15973V;
                jVar.f16085f = eVar.f15982c;
                jVar.f16081d = eVar.f15978a;
                jVar.f16083e = eVar.f15980b;
                jVar.f16077b = ((ViewGroup.MarginLayoutParams) eVar).width;
                jVar.f16079c = ((ViewGroup.MarginLayoutParams) eVar).height;
                jVar.f16055F = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
                jVar.f16056G = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
                jVar.f16057H = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                jVar.f16058I = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                jVar.f16061L = eVar.f15956D;
                jVar.T = eVar.f15961I;
                jVar.f16069U = eVar.f15960H;
                jVar.f16071W = eVar.f15963K;
                jVar.f16070V = eVar.f15962J;
                jVar.f16098l0 = eVar.f15974W;
                jVar.f16100m0 = eVar.f15975X;
                jVar.f16072X = eVar.f15964L;
                jVar.f16073Y = eVar.f15965M;
                jVar.f16074Z = eVar.f15968P;
                jVar.f16076a0 = eVar.f15969Q;
                jVar.f16078b0 = eVar.f15966N;
                jVar.f16080c0 = eVar.f15967O;
                jVar.f16082d0 = eVar.f15970R;
                jVar.f16084e0 = eVar.f15971S;
                jVar.f16096k0 = eVar.f15976Y;
                jVar.f16063N = eVar.f16017x;
                jVar.f16065P = eVar.f16019z;
                jVar.f16062M = eVar.f16016w;
                jVar.f16064O = eVar.f16018y;
                jVar.f16067R = eVar.f15953A;
                jVar.f16066Q = eVar.f15954B;
                jVar.f16068S = eVar.f15955C;
                jVar.f16104o0 = eVar.f15977Z;
                jVar.f16059J = eVar.getMarginEnd();
                jVar.f16060K = eVar.getMarginStart();
                int visibility = childAt.getVisibility();
                l lVar = iVar.f16044b;
                lVar.f16126a = visibility;
                lVar.f16128c = childAt.getAlpha();
                float rotation = childAt.getRotation();
                m mVar = iVar.f16047e;
                mVar.f16131a = rotation;
                mVar.f16132b = childAt.getRotationX();
                mVar.f16133c = childAt.getRotationY();
                mVar.f16134d = childAt.getScaleX();
                mVar.f16135e = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    mVar.f16136f = pivotX;
                    mVar.f16137g = pivotY;
                }
                mVar.f16139i = childAt.getTranslationX();
                mVar.f16140j = childAt.getTranslationY();
                mVar.f16141k = childAt.getTranslationZ();
                if (mVar.f16142l) {
                    mVar.f16143m = childAt.getElevation();
                }
                if (childAt instanceof C0982a) {
                    C0982a c0982a = (C0982a) childAt;
                    jVar.f16102n0 = c0982a.getAllowsGoneWidget();
                    jVar.f16092i0 = c0982a.getReferencedIds();
                    jVar.f16086f0 = c0982a.getType();
                    jVar.f16088g0 = c0982a.getMargin();
                }
            }
            i6++;
            nVar = this;
            childCount = i4;
        }
    }

    public final void e(int i4, Context context) throws XmlPullParserException, Resources.NotFoundException, IOException {
        XmlResourceParser xml = context.getResources().getXml(i4);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    i iVarD = d(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        iVarD.f16046d.f16075a = true;
                    }
                    this.f16149c.put(Integer.valueOf(iVarD.f16043a), iVarD);
                }
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        } catch (XmlPullParserException e5) {
            e5.printStackTrace();
        }
    }
}
