package androidx.compose.runtime.snapshots;

import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import defpackage.DeepThinkTopHeaderComponent$runCollapseAnimation$2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000\u001a>\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\tH\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aD\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\f0\u0005H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a8\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000f0\u0005H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a8\u0010\u0011\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000f0\u0005H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aP\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00030\u0013\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00140\u0005H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001ab\u0010\u0016\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\u00192\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0005H\u0000\u001a}\u0010\u001e\u001a\u0002H\u001f\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010\u001f*\u00060 j\u0002`!*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\"\u001a\u0002H\u001f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\u00192\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010#\u001a9\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00060 j\u0002`!2\u0006\u0010%\u001a\u0002H\u00022\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010&\u001aF\u0010'\u001a\b\u0012\u0004\u0012\u0002H\f0\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\f0\u0005H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aS\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032'\u0010\u0010\u001a#\u0012\u0013\u0012\u00110\n¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000f0\tH\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¨\u0006,"}, d2 = {"fastForEach", "", ExifInterface.GPS_DIRECTION_TRUE, "", "action", "Lkotlin/Function1;", "fastToSet", "", "fastForEachIndexed", "Lkotlin/Function2;", "", "fastMap", "R", "transform", "fastAny", "", "predicate", "fastAll", "fastGroupBy", "", "K", "keySelector", "fastJoinToString", "", "separator", "", "prefix", "postfix", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "truncated", "fastJoinTo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "buffer", "(Ljava/util/List;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "appendElement", "element", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "fastMapNotNull", "fastFilterIndexed", "Lkotlin/ParameterName;", "name", "index", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ListUtilsKt {
    public static final <T> Set<T> fastToSet(List<? extends T> r100) {
        HashSet r101 = new HashSet(r100.size());
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.add(ListProtector.get(r100, r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public static final <T> boolean fastAll(List<? extends T> r100, Function1<? super T, Boolean> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (r101.invoke((Object) ListProtector.get(r100, r103)).booleanValue() == false) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static final <T> boolean fastAny(List<? extends T> r100, Function1<? super T, Boolean> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r101.invoke((Object) ListProtector.get(r100, r103)).booleanValue() == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static final <T> List<T> fastFilterIndexed(List<? extends T> r100, Function2<? super Integer, ? super T, Boolean> r101) {
        ArrayList r102 = new ArrayList(r100.size());
        int r103 = r100.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r105 = (Object) ListProtector.get(r100, r104);
        if (r101.invoke(Integer.valueOf(r104), r105).booleanValue() == false) goto L7;
        r102.add(r105);
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        return r102;
    }

    public static final <T> void fastForEach(List<? extends T> r100, Function1<? super T, Unit> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.invoke((Object) ListProtector.get(r100, r103));
        r103 = r103 + 1;
        goto L3
    }

    public static final <T> void fastForEachIndexed(List<? extends T> r100, Function2<? super Integer, ? super T, Unit> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r104 = (Object) ListProtector.get(r100, r103);
        r101.invoke(Integer.valueOf(r103), r104);
        r103 = r103 + 1;
        goto L3
    }

    public static final <T, K> Map<K, List<T>> fastGroupBy(List<? extends T> r100, Function1<? super T, ? extends K> r101) {
        HashMap r102 = new HashMap(r100.size());
        int r103 = r100.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r105 = (Object) ListProtector.get(r100, r104);
        K r106 = r101.invoke(r105);
        Object r107 = r102.get(r106);
        if (r107 != null) goto L7;
        r107 = new ArrayList();
        r102.put(r106, r107);
    L7:
        ((ArrayList) r107).add(r105);
        r104 = r104 + 1;
        goto L3
    L8:
        return r102;
    }

    public static final <T, R> List<R> fastMap(List<? extends T> r100, Function1<? super T, ? extends R> r101) {
        ArrayList r102 = new ArrayList(r100.size());
        int r103 = r100.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r102.add(r101.invoke((Object) ListProtector.get(r100, r104)));
        r104 = r104 + 1;
        goto L3
    L5:
        return r102;
    }

    public static final <T, R> List<R> fastMapNotNull(List<? extends T> r100, Function1<? super T, ? extends R> r101) {
        ArrayList r102 = new ArrayList(r100.size());
        int r103 = r100.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        R r105 = r101.invoke((Object) ListProtector.get(r100, r104));
        if (r105 == null) goto L7;
        r102.add(r105);
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void appendElement(Appendable r100, T r101, Function1<? super T, ? extends CharSequence> r102) {
        if (r102 == null) goto L4;
        r100.append(r102.invoke(r101));
        return;
    L4:
        if (r101 != 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L10;
        r100.append((CharSequence) r101);
        return;
    L10:
        if ((r101 instanceof Character) == false) goto L12;
        r100.append(((Character) r101).charValue());
        return;
    L12:
        r100.append(r101.toString());
        return;
    L6:
        r103 = r101 instanceof CharSequence;
        goto L7
    }

    public static final <T> String fastJoinToString(List<? extends T> r100, CharSequence r101, CharSequence r110, CharSequence r111, int r112, CharSequence r113, Function1<? super T, ? extends CharSequence> r114) {
        return ((StringBuilder) fastJoinTo(r100, new StringBuilder(), r101, r110, r111, r112, r113, r114)).toString();
    }

    private static final <T, A extends Appendable> A fastJoinTo(List<? extends T> r100, A r101, CharSequence r102, CharSequence r103, CharSequence r104, int r105, CharSequence r110, Function1<? super T, ? extends CharSequence> r111) {
        r101.append(r103);
        int r106 = r100.size();
        int r107 = 0;
        int r108 = 0;
    L3:
        if (r107 >= r106) goto L10;
        Object r109 = ListProtector.get(r100, r107);
        r108 = r108 + 1;
        if (r108 <= 1) goto L7;
        r101.append(r102);
    L7:
        if (r105 < 0) goto L9;
        if (r108 > r105) goto L10;
    L9:
        appendElement(r101, r109, r111);
        r107 = r107 + 1;
    L10:
        if (r105 < 0) goto L13;
        if (r108 <= r105) goto L13;
        r101.append(r110);
    L13:
        r101.append(r104);
        return r101;
    }

    public static /* synthetic */ String fastJoinToString$default(List r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, Function1 r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L5;
        r101 = ", ";
    L5:
        CharSequence r106 = "";
        if ((r111 & 2) == 0) goto L8;
        CharSequence r113 = "";
    L10:
        if ((r111 & 4) != 0) goto L14;
        r106 = r103;
    L14:
        if ((r111 & 8) == 0) goto L16;
        int r107 = -1;
    L18:
        if ((r111 & 16) == 0) goto L20;
        r105 = "...";
    L20:
        CharSequence r108 = r105;
        if ((r111 & 32) == 0) goto L23;
        r110 = null;
    L23:
        Function1 r109 = r110;
        return fastJoinToString(r100, r101, r113, r106, r107, r108, r109);
    L16:
        r107 = r104;
        goto L18
    L8:
        r113 = r102;
        goto L10
    }

    public static /* synthetic */ Appendable fastJoinTo$default(List r100, Appendable r101, CharSequence r102, CharSequence r103, CharSequence r110, int r111, CharSequence r112, Function1 r113, int r114, Object r115) {
        if ((r114 & 2) == 0) goto L5;
        CharSequence r104 = ", ";
    L6:
        CharSequence r105 = "";
        if ((r114 & 4) == 0) goto L9;
        CharSequence r106 = "";
    L11:
        if ((r114 & 8) != 0) goto L15;
        r105 = r110;
    L15:
        if ((r114 & 16) == 0) goto L17;
        int r107 = -1;
    L19:
        if ((r114 & 32) == 0) goto L21;
        CharSequence r108 = "...";
    L23:
        if ((r114 & 64) == 0) goto L25;
        Function1 r109 = null;
    L27:
        return fastJoinTo(r100, r101, r104, r106, r105, r107, r108, r109);
    L25:
        r109 = r113;
        goto L27
    L21:
        r108 = r112;
        goto L23
    L17:
        r107 = r111;
        goto L19
    L9:
        r106 = r103;
        goto L11
    L5:
        r104 = r102;
        goto L6
    }
}
