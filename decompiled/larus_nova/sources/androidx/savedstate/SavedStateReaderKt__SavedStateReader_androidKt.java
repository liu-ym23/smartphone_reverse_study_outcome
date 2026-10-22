package androidx.savedstate;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0002\b\u0005\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0002\b\b\u001a3\u0010\t\u001a\u00020\n*\u00060\u0002j\u0002`\u00032\n\u0010\u000b\u001a\u00060\fj\u0002`\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000fH\u0002¢\u0006\u0002\b\u0010¨\u0006\u0011"}, d2 = {"contentDeepEquals", "", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "other", "contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt", "contentDeepHashCode", "", "contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt", "contentDeepToString", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt", "savedstate"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/savedstate/SavedStateReaderKt")
final /* synthetic */ class SavedStateReaderKt__SavedStateReader_androidKt {
    public static final /* synthetic */ int access$contentDeepHashCode(Bundle r100) {
        return contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt(r100);
    }

    private static final int contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt(Bundle r100) {
        Iterator<String> r101 = r100.keySet().iterator();
        int r102 = 1;
    L4:
        if (r101.hasNext() == false) goto L39;
        Object r103 = r100.get(r101.next());
        if ((r103 instanceof Bundle) == false) goto L9;
        int r104 = contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt((Bundle) r103);
    L38:
        r102 = (r102 * 31) + r104;
        goto L4
    L9:
        if ((r103 instanceof Object[]) == false) goto L12;
        r104 = ArraysKt.contentDeepHashCode((Object[]) r103);
        goto L38
    L12:
        if ((r103 instanceof byte[]) == false) goto L15;
        r104 = Arrays.hashCode((byte[]) r103);
        goto L38
    L15:
        if ((r103 instanceof short[]) == false) goto L18;
        r104 = Arrays.hashCode((short[]) r103);
        goto L38
    L18:
        if ((r103 instanceof int[]) == false) goto L21;
        r104 = Arrays.hashCode((int[]) r103);
        goto L38
    L21:
        if ((r103 instanceof long[]) == false) goto L24;
        r104 = Arrays.hashCode((long[]) r103);
        goto L38
    L24:
        if ((r103 instanceof float[]) == false) goto L27;
        r104 = Arrays.hashCode((float[]) r103);
        goto L38
    L27:
        if ((r103 instanceof double[]) == false) goto L30;
        r104 = Arrays.hashCode((double[]) r103);
        goto L38
    L30:
        if ((r103 instanceof char[]) == false) goto L33;
        r104 = Arrays.hashCode((char[]) r103);
        goto L38
    L33:
        if ((r103 instanceof boolean[]) == false) goto L35;
        r104 = Arrays.hashCode((boolean[]) r103);
        goto L38
    L35:
        if (r103 == null) goto L37;
        r104 = r103.hashCode();
        goto L38
    L37:
        r104 = 0;
        goto L38
    L39:
        return r102;
    }

    public static final /* synthetic */ boolean access$contentDeepEquals(Bundle r100, Bundle r101) {
        return contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt(r100, r101);
    }

    private static final boolean contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt(Bundle r100, Bundle r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100.size() == r101.size()) goto L8;
        return false;
    L8:
        Iterator<String> r102 = r100.keySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L91;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        Object r105 = r101.get(r103);
        if (r104 == r105) goto L10;
        if (Intrinsics.areEqual(r104, r105) == true) goto L10;
        if (r104 == null) goto L90;
        if (r105 == null) goto L90;
        if ((r104 instanceof Bundle) == false) goto L26;
        if ((r105 instanceof Bundle) == false) goto L26;
        if (contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt((Bundle) r104, (Bundle) r105) == true) goto L10;
        return false;
    L26:
        if ((r104 instanceof Object[]) == false) goto L33;
        if ((r105 instanceof Object[]) == false) goto L33;
        if (ArraysKt.contentDeepEquals((Object[]) r104, (Object[]) r105) == true) goto L10;
        return false;
    L33:
        if ((r104 instanceof byte[]) == false) goto L40;
        if ((r105 instanceof byte[]) == false) goto L40;
        if (Arrays.equals((byte[]) r104, (byte[]) r105) == true) goto L10;
        return false;
    L40:
        if ((r104 instanceof short[]) == false) goto L47;
        if ((r105 instanceof short[]) == false) goto L47;
        if (Arrays.equals((short[]) r104, (short[]) r105) == true) goto L10;
        return false;
    L47:
        if ((r104 instanceof int[]) == false) goto L54;
        if ((r105 instanceof int[]) == false) goto L54;
        if (Arrays.equals((int[]) r104, (int[]) r105) == true) goto L10;
        return false;
    L54:
        if ((r104 instanceof long[]) == false) goto L61;
        if ((r105 instanceof long[]) == false) goto L61;
        if (Arrays.equals((long[]) r104, (long[]) r105) == true) goto L10;
        return false;
    L61:
        if ((r104 instanceof float[]) == false) goto L68;
        if ((r105 instanceof float[]) == false) goto L68;
        if (Arrays.equals((float[]) r104, (float[]) r105) == true) goto L10;
        return false;
    L68:
        if ((r104 instanceof double[]) == false) goto L75;
        if ((r105 instanceof double[]) == false) goto L75;
        if (Arrays.equals((double[]) r104, (double[]) r105) == true) goto L10;
        return false;
    L75:
        if ((r104 instanceof char[]) == false) goto L82;
        if ((r105 instanceof char[]) == false) goto L82;
        if (Arrays.equals((char[]) r104, (char[]) r105) == true) goto L10;
        return false;
    L82:
        if ((r104 instanceof boolean[]) == false) goto L89;
        if ((r105 instanceof boolean[]) == false) goto L89;
        if (Arrays.equals((boolean[]) r104, (boolean[]) r105) == true) goto L10;
        return false;
    L89:
        if (Intrinsics.areEqual(r104, r105) == true) goto L10;
    L90:
        return false;
    L91:
        return true;
    }

    public static final /* synthetic */ void access$contentDeepToString(Bundle r100, StringBuilder r101, List r102) {
        contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt(r100, r101, r102);
    }

    private static final void contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt(Bundle r100, StringBuilder r101, List<Bundle> r102) {
        if (r102.contains(r100) == false) goto L6;
        r101.append("[...]");
        return;
    L6:
        r102.add(r100);
        r101.append('[');
        Iterator<T> r103 = r100.keySet().iterator();
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L47;
        int r105 = r104 + 1;
        String r106 = (String) r103.next();
        if (r104 == 0) goto L12;
        r101.append(", ");
    L12:
        r101.append(r106 + com.alipay.sdk.m.n.a.f25612h);
        Object r107 = r100.get(r106);
        if (r107 != null) goto L16;
        r101.append("null");
    L46:
        r104 = r105;
        goto L8
    L16:
        if ((r107 instanceof Bundle) == false) goto L19;
        contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt((Bundle) r107, r101, r102);
        Unit r108 = Unit.INSTANCE;
        goto L46
    L19:
        if ((r107 instanceof Object[]) == false) goto L22;
        r101.append(ArraysKt.contentDeepToString((Object[]) r107));
        goto L46
    L22:
        if ((r107 instanceof byte[]) == false) goto L25;
        r101.append(Arrays.toString((byte[]) r107));
        goto L46
    L25:
        if ((r107 instanceof short[]) == false) goto L28;
        r101.append(Arrays.toString((short[]) r107));
        goto L46
    L28:
        if ((r107 instanceof int[]) == false) goto L31;
        r101.append(Arrays.toString((int[]) r107));
        goto L46
    L31:
        if ((r107 instanceof long[]) == false) goto L34;
        r101.append(Arrays.toString((long[]) r107));
        goto L46
    L34:
        if ((r107 instanceof float[]) == false) goto L37;
        r101.append(Arrays.toString((float[]) r107));
        goto L46
    L37:
        if ((r107 instanceof double[]) == false) goto L40;
        r101.append(Arrays.toString((double[]) r107));
        goto L46
    L40:
        if ((r107 instanceof char[]) == false) goto L43;
        r101.append(Arrays.toString((char[]) r107));
        goto L46
    L43:
        if ((r107 instanceof boolean[]) == false) goto L45;
        r101.append(Arrays.toString((boolean[]) r107));
        goto L46
    L45:
        r101.append(r107.toString());
        goto L46
    L47:
        r101.append(']');
        ListProtector.remove(r102, CollectionsKt.getLastIndex(r102));
    }
}
