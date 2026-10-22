package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0015\u001a\u00020\u0016H\u0086\bJ\t\u0010\u0017\u001a\u00020\u0016H\u0086\bJ:\u0010\u0017\u001a\u00020\u00162!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00160\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010\u001e\u001a\u00020\u00162!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00160\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0011\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001aH\u0086\u0002J\u000e\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0000J\t\u0010\"\u001a\u00020\u0003H\u0086\bJ:\u0010\"\u001a\u00020\u00032!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00160\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010#\u001a\u00020\u001aJ:\u0010#\u001a\u00020\u001a2!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00160\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001Jb\u0010$\u001a\u0002H%\"\u0004\b\u0000\u0010%2\u0006\u0010&\u001a\u0002H%26\u0010'\u001a2\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u0002H%0(H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010*Jw\u0010+\u001a\u0002H%\"\u0004\b\u0000\u0010%2\u0006\u0010&\u001a\u0002H%2K\u0010'\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(-\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u0002H%0,H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010.Jb\u0010/\u001a\u0002H%\"\u0004\b\u0000\u0010%2\u0006\u0010&\u001a\u0002H%26\u0010'\u001a2\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b()\u0012\u0004\u0012\u0002H%0(H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010*Jw\u00100\u001a\u0002H%\"\u0004\b\u0000\u0010%2\u0006\u0010&\u001a\u0002H%2K\u0010'\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b()\u0012\u0004\u0012\u0002H%0,H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010.J:\u00101\u001a\u0002022!\u00103\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u0002020\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u00104\u001a\u00020226\u00103\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u0002020(H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u00105\u001a\u0002022!\u00103\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u0002020\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u00106\u001a\u00020226\u00103\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u0002020(H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0013\u00107\u001a\u00020\u001a2\b\b\u0001\u0010-\u001a\u00020\u0003H\u0086\u0002J\u0010\u00108\u001a\u00020\u001a2\b\b\u0001\u0010-\u001a\u00020\u0003J9\u00109\u001a\u00020\u001a2\b\b\u0001\u0010-\u001a\u00020\u00032!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u001a0\u0019H\u0086\bø\u0001\u0000J\u000e\u0010;\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001aJ:\u0010<\u001a\u00020\u00032!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00160\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010=\u001a\u00020\u00032!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00160\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\t\u0010>\u001a\u00020\u0016H\u0086\bJ\t\u0010?\u001a\u00020\u0016H\u0086\bJ\u0006\u0010@\u001a\u00020\u001aJ:\u0010@\u001a\u00020\u001a2!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00160\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u000e\u0010A\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001aJ$\u0010B\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010C\u001a\u00020\u00032\b\b\u0002\u0010D\u001a\u00020\u0003H\u0007J:\u0010E\u001a\u00020F2\b\b\u0002\u0010G\u001a\u00020H2\b\b\u0002\u0010I\u001a\u00020H2\b\b\u0002\u0010J\u001a\u00020H2\b\b\u0002\u0010K\u001a\u00020\u00032\b\b\u0002\u0010L\u001a\u00020HH\u0007JT\u0010E\u001a\u00020F2\b\b\u0002\u0010G\u001a\u00020H2\b\b\u0002\u0010I\u001a\u00020H2\b\b\u0002\u0010J\u001a\u00020H2\b\b\u0002\u0010K\u001a\u00020\u00032\b\b\u0002\u0010L\u001a\u00020H2\u0014\b\u0004\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020H0\u0019H\u0087\bø\u0001\u0000J\b\u0010N\u001a\u00020\u0003H\u0016J\u0013\u0010O\u001a\u00020\u00162\b\u0010P\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010Q\u001a\u00020FH\u0016R\u0018\u0010\u0006\u001a\u00020\u00078\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u00020\u00038\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u00038Ç\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u00038Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0012\u0010\u0011\u001a\u00020\u00128Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0001\u0001R\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006S"}, d2 = {"Landroidx/collection/DoubleList;", "", "initialCapacity", "", "<init>", "(I)V", "content", "", "getContent$annotations", "()V", "_size", "get_size$annotations", "size", "getSize", "()I", "lastIndex", "getLastIndex", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "none", "", "any", "predicate", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "element", "reversedAny", "contains", "containsAll", SlcElement.KEY_ELEMENTS, "count", SoloKtvContext.SOLO_PAGE_FIRST, "fold", "R", "initial", WikiFolderPushPlugin.OPT, "Lkotlin/Function2;", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "index", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", MonitorConstants.CONNECT_TYPE_GET, "elementAt", "elementAtOrElse", "defaultValue", "indexOf", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "last", "lastIndexOf", "binarySearch", "fromIndex", "toIndex", "joinToString", "", "separator", "", "prefix", "postfix", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "truncated", "transform", "hashCode", "equals", "other", "toString", "Landroidx/collection/MutableDoubleList;", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class DoubleList {
    public int _size;
    public double[] content;

    public /* synthetic */ DoubleList(int r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public final int binarySearch(int r100) {
        return binarySearch$default(this, r100, 0, 0, 6, null);
    }

    public final int binarySearch(int r100, int r101) {
        return binarySearch$default(this, r100, r101, 0, 4, null);
    }

    public final IntRange getIndices() {
        return RangesKt.until(0, this._size);
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final String joinToString(CharSequence r110) {
        Intrinsics.checkNotNullParameter(r110, "separator");
        return joinToString$default(this, r110, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence r110, CharSequence r111) {
        Intrinsics.checkNotNullParameter(r110, "separator");
        Intrinsics.checkNotNullParameter(r111, "prefix");
        return joinToString$default(this, r110, r111, null, 0, null, 28, null);
    }

    public final String joinToString(CharSequence r110, CharSequence r111, CharSequence r112) {
        Intrinsics.checkNotNullParameter(r110, "separator");
        Intrinsics.checkNotNullParameter(r111, "prefix");
        Intrinsics.checkNotNullParameter(r112, "postfix");
        return joinToString$default(this, r110, r111, r112, 0, null, 24, null);
    }

    public final String joinToString(CharSequence r110, CharSequence r111, CharSequence r112, int r113) {
        Intrinsics.checkNotNullParameter(r110, "separator");
        Intrinsics.checkNotNullParameter(r111, "prefix");
        Intrinsics.checkNotNullParameter(r112, "postfix");
        return joinToString$default(this, r110, r111, r112, r113, null, 16, null);
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }

    public final boolean any() {
        if (this._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final double first() {
        if (this._size != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        RuntimeHelpersKt.throwNoSuchElementException("DoubleList is empty.");
    L9:
        return this.content[0];
    L5:
        r100 = false;
        goto L6
    }

    public final int getLastIndex() {
        return this._size - 1;
    }

    public int hashCode() {
        double[] r100 = this.content;
        int r101 = this._size;
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L5;
        long r104 = Double.doubleToLongBits(r100[r102]);
        r103 = r103 + (((int) (r104 ^ (r104 >>> 32))) * 31);
        r102 = r102 + 1;
        goto L3
    L5:
        return r103;
    }

    public final boolean isEmpty() {
        if (this._size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNotEmpty() {
        if (this._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final double last() {
        if (this._size != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        RuntimeHelpersKt.throwNoSuchElementException("DoubleList is empty.");
    L9:
        return this.content[this._size - 1];
    L5:
        r100 = false;
        goto L6
    }

    public final boolean none() {
        if (this._size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int count() {
        return this._size;
    }

    public final int getSize() {
        return this._size;
    }

    private DoubleList(int r100) {
        if (r100 != 0) goto L5;
        double[] r101 = DoubleSetKt.getEmptyDoubleArray();
    L6:
        this.content = r101;
        return;
    L5:
        r101 = new double[r100];
        goto L6
    }

    public final boolean any(Function1<? super Double, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        double[] r101 = this.content;
        int r102 = this._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r100.invoke(Double.valueOf(r101[r103])).booleanValue() == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final boolean contains(double r100) {
        double[] r101 = this.content;
        int r102 = this._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        if (r101[r103] != r100) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L9;
        r103 = r103 + 1;
        goto L3
    L9:
        return true;
    L7:
        r104 = false;
        goto L8
    L11:
        return false;
    }

    public final boolean containsAll(DoubleList r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        IntRange r101 = RangesKt.until(0, r100._size);
        int r102 = r101.getFirst();
        int r103 = r101.getLast();
        if (r102 <= r103) goto L5;
        return true;
    L5:
        if (contains(r100.get(r102)) == false) goto L6;
        if (r102 == r103) goto L13;
        r102 = r102 + 1;
        goto L5
    L13:
        return true;
    L6:
        return false;
    }

    public final int count(Function1<? super Double, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        double[] r101 = this.content;
        int r102 = this._size;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (r100.invoke(Double.valueOf(r101[r103])).booleanValue() == false) goto L7;
        r104 = r104 + 1;
    L7:
        r103 = r103 + 1;
        goto L3
    L8:
        return r104;
    }

    public final double elementAt(int r100) {
        boolean r101 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r101 == true) goto L10;
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
    L10:
        return this.content[r100];
    L5:
        if (r100 >= this._size) goto L7;
        r101 = true;
        goto L7
    }

    public boolean equals(Object r110) {
        if ((r110 instanceof DoubleList) == false) goto L18;
        DoubleList r111 = (DoubleList) r110;
        int r100 = r111._size;
        int r101 = this._size;
        if (r100 != r101) goto L18;
        double[] r102 = this.content;
        double[] r112 = r111.content;
        IntRange r103 = RangesKt.until(0, r101);
        int r104 = r103.getFirst();
        int r105 = r103.getLast();
        if (r104 <= r105) goto L10;
    L17:
        return true;
    L10:
        if (r102[r104] != r112[r104]) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L14;
        if (r104 == r105) goto L17;
        r104 = r104 + 1;
        goto L10
    L14:
        return false;
    L12:
        r106 = false;
    L18:
        return false;
    }

    public final double first(Function1<? super Double, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        double[] r101 = this.content;
        int r102 = this._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        double r104 = r101[r103];
        if (r100.invoke(Double.valueOf(r104)).booleanValue() == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        throw new NoSuchElementException("DoubleList contains no element matching the predicate.");
    }

    public final void forEach(Function1<? super Double, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        double[] r101 = this.content;
        int r102 = this._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.invoke(Double.valueOf(r101[r103]));
        r103 = r103 + 1;
        goto L3
    }

    public final void forEachIndexed(Function2<? super Integer, ? super Double, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        double[] r101 = this.content;
        int r102 = this._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.invoke(Integer.valueOf(r103), Double.valueOf(r101[r103]));
        r103 = r103 + 1;
        goto L3
    }

    public final void forEachReversed(Function1<? super Double, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        double[] r101 = this.content;
        int r102 = this._size;
    L3:
        r102 = r102 - 1;
        if ((-1) >= r102) goto L6;
        r100.invoke(Double.valueOf(r101[r102]));
        goto L3
    }

    public final void forEachReversedIndexed(Function2<? super Integer, ? super Double, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        double[] r101 = this.content;
        int r102 = this._size;
    L3:
        r102 = r102 - 1;
        if ((-1) >= r102) goto L6;
        r100.invoke(Integer.valueOf(r102), Double.valueOf(r101[r102]));
        goto L3
    }

    public final double get(int r100) {
        boolean r101 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r101 == true) goto L10;
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
    L10:
        return this.content[r100];
    L5:
        if (r100 >= this._size) goto L7;
        r101 = true;
        goto L7
    }

    public final int indexOf(double r100) {
        double[] r101 = this.content;
        int r102 = this._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        if (r100 != r101[r103]) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L9;
        r103 = r103 + 1;
        goto L3
    L9:
        return r103;
    L7:
        r104 = false;
        goto L8
    L11:
        return -1;
    }

    public final int indexOfFirst(Function1<? super Double, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        double[] r101 = this.content;
        int r102 = this._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (r100.invoke(Double.valueOf(r101[r103])).booleanValue() == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r103;
    L8:
        return -1;
    }

    public final int indexOfLast(Function1<? super Double, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        double[] r101 = this.content;
        int r102 = this._size;
    L3:
        r102 = r102 - 1;
        if ((-1) >= r102) goto L9;
        if (r100.invoke(Double.valueOf(r101[r102])).booleanValue() == false) goto L3;
        return r102;
    L9:
        return -1;
    }

    public final String joinToString(Function1<? super Double, ? extends CharSequence> r100) {
        Intrinsics.checkNotNullParameter(r100, "transform");
        StringBuilder r101 = new StringBuilder("");
        double[] r102 = this.content;
        int r103 = this._size;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L10;
        double r105 = r102[r104];
        if (r104 == (-1)) goto L6;
        if (r104 == 0) goto L9;
        r101.append(", ");
    L9:
        r101.append(r100.invoke(Double.valueOf(r105)));
        r104 = r104 + 1;
        goto L3
    L6:
        r101.append("...");
    L12:
        return r101.toString();
    L10:
        r101.append("");
        goto L12
    }

    public final double last(Function1<? super Double, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        double[] r101 = this.content;
        int r102 = this._size;
    L3:
        r102 = r102 - 1;
        if ((-1) >= r102) goto L10;
        double r103 = r101[r102];
        if (r100.invoke(Double.valueOf(r103)).booleanValue() == false) goto L3;
        return r103;
    L10:
        throw new NoSuchElementException("DoubleList contains no element matching the predicate.");
    }

    public final int lastIndexOf(double r100) {
        double[] r101 = this.content;
        int r102 = this._size - 1;
    L4:
        if ((-1) >= r102) goto L12;
        if (r101[r102] != r100) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L10;
        r102 = r102 - 1;
        goto L4
    L10:
        return r102;
    L8:
        r103 = false;
        goto L9
    L12:
        return -1;
    }

    public final boolean reversedAny(Function1<? super Double, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        double[] r101 = this.content;
        int r102 = this._size - 1;
    L4:
        if ((-1) >= r102) goto L9;
        if (r100.invoke(Double.valueOf(r101[r102])).booleanValue() == true) goto L7;
        r102 = r102 - 1;
        goto L4
    L7:
        return true;
    L9:
        return false;
    }

    public final double elementAtOrElse(int r100, Function1<? super Integer, Double> r101) {
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        boolean r102 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r102 == true) goto L11;
        return r101.invoke(Integer.valueOf(r100)).doubleValue();
    L11:
        return this.content[r100];
    L5:
        if (r100 >= this._size) goto L7;
        r102 = true;
        goto L7
    }

    public final <R> R fold(R r100, Function2<? super R, ? super Double, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        double[] r102 = this.content;
        int r103 = this._size;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        R r105 = r100;
        r100 = r101.invoke(r105, Double.valueOf(r102[r104]));
        r104 = r104 + 1;
        goto L3
    L5:
        return r100;
    }

    public final <R> R foldIndexed(R r100, Function3<? super Integer, ? super R, ? super Double, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        double[] r102 = this.content;
        int r103 = this._size;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        double r105 = r102[r104];
        R r106 = r100;
        r100 = r101.invoke(Integer.valueOf(r104), r106, Double.valueOf(r105));
        r104 = r104 + 1;
        goto L3
    L5:
        return r100;
    }

    public final <R> R foldRight(R r100, Function2<? super Double, ? super R, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        double[] r102 = this.content;
        int r103 = this._size;
    L3:
        r103 = r103 - 1;
        if ((-1) >= r103) goto L6;
        r100 = r101.invoke(Double.valueOf(r102[r103]), r100);
        goto L3
    L6:
        return r100;
    }

    public final <R> R foldRightIndexed(R r100, Function3<? super Integer, ? super Double, ? super R, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        double[] r102 = this.content;
        int r103 = this._size;
    L3:
        r103 = r103 - 1;
        if ((-1) >= r103) goto L6;
        r100 = r101.invoke(Integer.valueOf(r103), Double.valueOf(r102[r103]), r100);
        goto L3
    L6:
        return r100;
    }

    public final String joinToString(CharSequence r100, Function1<? super Double, ? extends CharSequence> r110) {
        Intrinsics.checkNotNullParameter(r100, "separator");
        Intrinsics.checkNotNullParameter(r110, "transform");
        StringBuilder r101 = new StringBuilder("");
        double[] r102 = this.content;
        int r103 = this._size;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L10;
        double r105 = r102[r104];
        if (r104 == (-1)) goto L6;
        if (r104 == 0) goto L9;
        r101.append(r100);
    L9:
        r101.append(r110.invoke(Double.valueOf(r105)));
        r104 = r104 + 1;
        goto L3
    L6:
        r101.append("...");
    L12:
        return r101.toString();
    L10:
        r101.append("");
        goto L12
    }

    public final int binarySearch(int r100, int r101, int r102) {
        if (r101 < 0) goto L6;
        if (r101 >= r102) goto L6;
        if (r102 > this._size) goto L6;
    L7:
        int r103 = r102 - 1;
    L8:
        if (r101 > r103) goto L17;
        int r104 = (r101 + r103) >>> 1;
        double r105 = this.content[r104];
        double r106 = r100;
        if (r105 < r106) goto L11;
        if (r105 <= r106) goto L15;
        r103 = r104 - 1;
        goto L8
    L15:
        return r104;
    L11:
        r101 = r104 + 1;
        goto L8
    L17:
        return -(r101 + 1);
    L6:
        RuntimeHelpersKt.throwIndexOutOfBoundsException("");
        goto L7
    }

    public final String joinToString(CharSequence r100, CharSequence r101, Function1<? super Double, ? extends CharSequence> r102) {
        Intrinsics.checkNotNullParameter(r100, "separator");
        Intrinsics.checkNotNullParameter(r101, "prefix");
        Intrinsics.checkNotNullParameter(r102, "transform");
        StringBuilder r103 = new StringBuilder();
        r103.append(r101);
        double[] r104 = this.content;
        int r105 = this._size;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L10;
        double r107 = r104[r106];
        if (r106 == (-1)) goto L6;
        if (r106 == 0) goto L9;
        r103.append(r100);
    L9:
        r103.append(r102.invoke(Double.valueOf(r107)));
        r106 = r106 + 1;
        goto L3
    L6:
        r103.append("...");
    L12:
        return r103.toString();
    L10:
        r103.append("");
        goto L12
    }

    public final String joinToString(CharSequence r100, CharSequence r101, CharSequence r102, Function1<? super Double, ? extends CharSequence> r110) {
        Intrinsics.checkNotNullParameter(r100, "separator");
        Intrinsics.checkNotNullParameter(r101, "prefix");
        Intrinsics.checkNotNullParameter(r102, "postfix");
        Intrinsics.checkNotNullParameter(r110, "transform");
        StringBuilder r103 = new StringBuilder();
        r103.append(r101);
        double[] r104 = this.content;
        int r105 = this._size;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L10;
        double r107 = r104[r106];
        if (r106 == (-1)) goto L6;
        if (r106 == 0) goto L9;
        r103.append(r100);
    L9:
        r103.append(r110.invoke(Double.valueOf(r107)));
        r106 = r106 + 1;
        goto L3
    L6:
        r103.append("...");
    L12:
        return r103.toString();
    L10:
        r103.append(r102);
        goto L12
    }

    public final String joinToString(CharSequence r100, CharSequence r101, CharSequence r102, int r103, Function1<? super Double, ? extends CharSequence> r110) {
        Intrinsics.checkNotNullParameter(r100, "separator");
        Intrinsics.checkNotNullParameter(r101, "prefix");
        Intrinsics.checkNotNullParameter(r102, "postfix");
        Intrinsics.checkNotNullParameter(r110, "transform");
        StringBuilder r104 = new StringBuilder();
        r104.append(r101);
        double[] r105 = this.content;
        int r106 = this._size;
        int r107 = 0;
    L3:
        if (r107 >= r106) goto L10;
        double r108 = r105[r107];
        if (r107 == r103) goto L6;
        if (r107 == 0) goto L9;
        r104.append(r100);
    L9:
        r104.append(r110.invoke(Double.valueOf(r108)));
        r107 = r107 + 1;
        goto L3
    L6:
        r104.append("...");
    L12:
        return r104.toString();
    L10:
        r104.append(r102);
        goto L12
    }

    public final String joinToString(CharSequence r100, CharSequence r101, CharSequence r102, int r103, CharSequence r110) {
        Intrinsics.checkNotNullParameter(r100, "separator");
        Intrinsics.checkNotNullParameter(r101, "prefix");
        Intrinsics.checkNotNullParameter(r102, "postfix");
        Intrinsics.checkNotNullParameter(r110, "truncated");
        StringBuilder r104 = new StringBuilder();
        r104.append(r101);
        double[] r105 = this.content;
        int r106 = this._size;
        int r107 = 0;
    L3:
        if (r107 >= r106) goto L10;
        double r108 = r105[r107];
        if (r107 == r103) goto L6;
        if (r107 == 0) goto L9;
        r104.append(r100);
    L9:
        r104.append(r108);
        r107 = r107 + 1;
        goto L3
    L6:
        r104.append(r110);
    L12:
        return r104.toString();
    L10:
        r104.append(r102);
        goto L12
    }

    public static /* synthetic */ int binarySearch$default(DoubleList r100, int r101, int r102, int r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = 0;
    L7:
        if ((r104 & 4) == 0) goto L10;
        r103 = r100._size;
    L10:
        return r100.binarySearch(r101, r102, r103);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: binarySearch");
    }

    public final String joinToString(CharSequence r100, CharSequence r101, CharSequence r102, int r103, CharSequence r110, Function1<? super Double, ? extends CharSequence> r111) {
        Intrinsics.checkNotNullParameter(r100, "separator");
        Intrinsics.checkNotNullParameter(r101, "prefix");
        Intrinsics.checkNotNullParameter(r102, "postfix");
        Intrinsics.checkNotNullParameter(r110, "truncated");
        Intrinsics.checkNotNullParameter(r111, "transform");
        StringBuilder r104 = new StringBuilder();
        r104.append(r101);
        double[] r105 = this.content;
        int r106 = this._size;
        int r107 = 0;
    L3:
        if (r107 >= r106) goto L10;
        double r108 = r105[r107];
        if (r107 == r103) goto L6;
        if (r107 == 0) goto L9;
        r104.append(r100);
    L9:
        r104.append(r111.invoke(Double.valueOf(r108)));
        r107 = r107 + 1;
        goto L3
    L6:
        r104.append(r110);
    L12:
        return r104.toString();
    L10:
        r104.append(r102);
        goto L12
    }

    public static /* synthetic */ String joinToString$default(DoubleList r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, int r106, Object r110) {
        if (r110 != null) goto L24;
        if ((r106 & 1) == 0) goto L6;
        r101 = ", ";
    L6:
        CharSequence r107 = "";
        if ((r106 & 2) == 0) goto L9;
        CharSequence r111 = "";
    L11:
        if ((r106 & 4) != 0) goto L15;
        r107 = r103;
    L15:
        if ((r106 & 8) == 0) goto L17;
        int r108 = -1;
    L19:
        if ((r106 & 16) == 0) goto L21;
        r105 = "...";
    L21:
        CharSequence r109 = r105;
        return r100.joinToString(r101, r111, r107, r108, r109);
    L17:
        r108 = r104;
        goto L19
    L9:
        r111 = r102;
        goto L11
    L24:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public static /* synthetic */ String joinToString$default(DoubleList r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, Function1 r106, int r107, Object r110) {
        if (r110 != null) goto L30;
        if ((r107 & 1) == 0) goto L7;
        r101 = ", ";
    L7:
        if ((r107 & 2) == 0) goto L10;
        r102 = "";
    L10:
        if ((r107 & 4) == 0) goto L13;
        r103 = "";
    L13:
        if ((r107 & 8) == 0) goto L16;
        r104 = -1;
    L16:
        if ((r107 & 16) == 0) goto L18;
        r105 = "...";
    L18:
        Intrinsics.checkNotNullParameter(r101, "separator");
        Intrinsics.checkNotNullParameter(r102, "prefix");
        Intrinsics.checkNotNullParameter(r103, "postfix");
        Intrinsics.checkNotNullParameter(r105, "truncated");
        Intrinsics.checkNotNullParameter(r106, "transform");
        StringBuilder r108 = new StringBuilder();
        r108.append(r102);
        double[] r109 = r100.content;
        int r111 = r100._size;
        int r112 = 0;
    L19:
        if (r112 >= r111) goto L26;
        double r113 = r109[r112];
        if (r112 == r104) goto L22;
        if (r112 == 0) goto L25;
        r108.append(r101);
    L25:
        r108.append((CharSequence) r106.invoke(Double.valueOf(r113)));
        r112 = r112 + 1;
        goto L19
    L22:
        r108.append(r105);
    L28:
        return r108.toString();
    L26:
        r108.append(r103);
        goto L28
    L30:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }
}
