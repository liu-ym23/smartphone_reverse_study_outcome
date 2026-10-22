package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.List;
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
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u001c\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J:\u0010\u0019\u001a\u00020\u00182!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010\u001f\u001a\u00020\u00182!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0016\u0010 \u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020\u00182\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010$J\u0014\u0010\"\u001a\u00020\u00182\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000%J\u0014\u0010\"\u001a\u00020\u00182\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000&J\u0014\u0010\"\u001a\u00020\u00182\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0006\u0010'\u001a\u00020\u0004J:\u0010'\u001a\u00020\u00042!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u000b\u0010(\u001a\u00028\u0000¢\u0006\u0002\u0010)J?\u0010(\u001a\u00028\u00002!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0002\u0010)JA\u0010+\u001a\u0004\u0018\u00018\u00002!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010*Jb\u0010,\u001a\u0002H-\"\u0004\b\u0001\u0010-2\u0006\u0010.\u001a\u0002H-26\u0010/\u001a2\u0012\u0013\u0012\u0011H-¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(1\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u0002H-00H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00102Jw\u00103\u001a\u0002H-\"\u0004\b\u0001\u0010-2\u0006\u0010.\u001a\u0002H-2K\u0010/\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H-¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(1\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u0002H-04H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00106Jb\u00107\u001a\u0002H-\"\u0004\b\u0001\u0010-2\u0006\u0010.\u001a\u0002H-26\u0010/\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H-¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(1\u0012\u0004\u0012\u0002H-00H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00102Jw\u00108\u001a\u0002H-\"\u0004\b\u0001\u0010-2\u0006\u0010.\u001a\u0002H-2K\u0010/\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(5\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H-¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(1\u0012\u0004\u0012\u0002H-04H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00106J:\u00109\u001a\u00020:2!\u0010;\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020:0\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u0010<\u001a\u00020:26\u0010;\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(5\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020:00H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010=\u001a\u00020:2!\u0010;\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020:0\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u0010>\u001a\u00020:26\u0010;\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(5\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020:00H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0018\u0010?\u001a\u00028\u00002\b\b\u0001\u00105\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0002\u0010@J\u0015\u0010A\u001a\u00028\u00002\b\b\u0001\u00105\u001a\u00020\u0004¢\u0006\u0002\u0010@J\u0015\u0010B\u001a\u00020:2\u0006\u00105\u001a\u00020\u0004H\u0000¢\u0006\u0002\bCJ>\u0010D\u001a\u00028\u00002\b\b\u0001\u00105\u001a\u00020\u00042!\u0010E\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(5\u0012\u0004\u0012\u00028\u00000\u001bH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00028\u0000¢\u0006\u0002\u0010HJ:\u0010I\u001a\u00020\u00042!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010J\u001a\u00020\u00042!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010K\u001a\u00020\u0018J\u0006\u0010L\u001a\u00020\u0018J\u000b\u0010M\u001a\u00028\u0000¢\u0006\u0002\u0010)J?\u0010M\u001a\u00028\u00002!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010*J\u0010\u0010N\u001a\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0002\u0010)JA\u0010N\u001a\u0004\u0018\u00018\u00002!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010*J\u0013\u0010O\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00028\u0000¢\u0006\u0002\u0010HJR\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020S2\b\b\u0002\u0010T\u001a\u00020S2\b\b\u0002\u0010U\u001a\u00020S2\b\b\u0002\u0010V\u001a\u00020\u00042\b\b\u0002\u0010W\u001a\u00020S2\u0016\b\u0002\u0010X\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020S\u0018\u00010\u001bH\u0007J\u000e\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000%H&J\b\u0010Z\u001a\u00020\u0004H\u0016J\u0013\u0010[\u001a\u00020\u00182\b\u0010\\\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010]\u001a\u00020QH\u0016R\"\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\nR\u0011\u0010\u000e\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00048Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0012\u0010\u0013\u001a\u00020\u00148Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0082\u0001\u0001^\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006_"}, d2 = {"Landroidx/collection/ObjectList;", ExifInterface.LONGITUDE_EAST, "", "initialCapacity", "", "<init>", "(I)V", "content", "", "getContent$annotations", "()V", "[Ljava/lang/Object;", "_size", "get_size$annotations", "size", "getSize", "()I", "lastIndex", "getLastIndex", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "none", "", "any", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "reversedAny", "contains", "(Ljava/lang/Object;)Z", "containsAll", SlcElement.KEY_ELEMENTS, "([Ljava/lang/Object;)Z", "", "", "count", SoloKtvContext.SOLO_PAGE_FIRST, "()Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstOrNull", "fold", "R", "initial", WikiFolderPushPlugin.OPT, "Lkotlin/Function2;", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "index", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", MonitorConstants.CONNECT_TYPE_GET, "(I)Ljava/lang/Object;", "elementAt", "throwIndexOutOfBoundsExclusiveException", "throwIndexOutOfBoundsExclusiveException$collection", "elementAtOrElse", "defaultValue", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "last", "lastOrNull", "lastIndexOf", "joinToString", "", "separator", "", "prefix", "postfix", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "truncated", "transform", "asList", "hashCode", "equals", "other", "toString", "Landroidx/collection/MutableObjectList;", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ObjectList<E> {
    public int _size;
    public Object[] content;

    public /* synthetic */ ObjectList(int r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public static /* synthetic */ CharSequence a(ObjectList r100, Object r101) {
        return toString$lambda$22(r100, r101);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public abstract List<E> asList();

    public final IntRange getIndices() {
        return RangesKt.until(0, this._size);
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, null, 63, null);
    }

    public final String joinToString(CharSequence r110) {
        Intrinsics.checkNotNullParameter(r110, "separator");
        return joinToString$default(this, r110, null, null, 0, null, null, 62, null);
    }

    public final String joinToString(CharSequence r110, CharSequence r111) {
        Intrinsics.checkNotNullParameter(r110, "separator");
        Intrinsics.checkNotNullParameter(r111, "prefix");
        return joinToString$default(this, r110, r111, null, 0, null, null, 60, null);
    }

    public final String joinToString(CharSequence r110, CharSequence r111, CharSequence r112) {
        Intrinsics.checkNotNullParameter(r110, "separator");
        Intrinsics.checkNotNullParameter(r111, "prefix");
        Intrinsics.checkNotNullParameter(r112, "postfix");
        return joinToString$default(this, r110, r111, r112, 0, null, null, 56, null);
    }

    public final String joinToString(CharSequence r110, CharSequence r111, CharSequence r112, int r113) {
        Intrinsics.checkNotNullParameter(r110, "separator");
        Intrinsics.checkNotNullParameter(r111, "prefix");
        Intrinsics.checkNotNullParameter(r112, "postfix");
        return joinToString$default(this, r110, r111, r112, r113, null, null, 48, null);
    }

    public final String joinToString(CharSequence r110, CharSequence r111, CharSequence r112, int r113, CharSequence r114) {
        Intrinsics.checkNotNullParameter(r110, "separator");
        Intrinsics.checkNotNullParameter(r111, "prefix");
        Intrinsics.checkNotNullParameter(r112, "postfix");
        Intrinsics.checkNotNullParameter(r114, "truncated");
        return joinToString$default(this, r110, r111, r112, r113, r114, null, 32, null);
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, new a(this), 25, null);
    }

    public final int getLastIndex() {
        return this._size - 1;
    }

    public int hashCode() {
        Object[] r100 = this.content;
        int r101 = this._size;
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L9;
        Object r104 = r100[r102];
        if (r104 == null) goto L7;
        int r105 = r104.hashCode();
    L8:
        r103 = r103 + (r105 * 31);
        r102 = r102 + 1;
        goto L3
    L7:
        r105 = 0;
        goto L8
    L9:
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

    public final boolean any() {
        return isNotEmpty();
    }

    public final E first() {
        if (isEmpty() == false) goto L6;
        RuntimeHelpersKt.throwNoSuchElementException("ObjectList is empty.");
    L6:
        return (E) this.content[0];
    }

    public final E firstOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return get(0);
    }

    public final E last() {
        if (isEmpty() == false) goto L6;
        RuntimeHelpersKt.throwNoSuchElementException("ObjectList is empty.");
    L6:
        return (E) this.content[this._size - 1];
    }

    public final E lastOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return (E) this.content[this._size - 1];
    }

    public final boolean none() {
        return isEmpty();
    }

    public final int count() {
        return this._size;
    }

    public final int getSize() {
        return this._size;
    }

    private ObjectList(int r100) {
        if (r100 != 0) goto L5;
        Object[] r101 = ObjectListKt.access$getEmptyArray$p();
    L6:
        this.content = r101;
        return;
    L5:
        r101 = new Object[r100];
        goto L6
    }

    public final boolean any(Function1<? super E, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        Object[] r101 = this.content;
        int r102 = this._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r100.invoke(r101[r103]).booleanValue() == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final boolean contains(E r100) {
        if (indexOf(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(List<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (contains(ListProtector.get(r100, r102)) == false) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public final int count(Function1<? super E, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        Object[] r101 = this.content;
        int r102 = this._size;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (r100.invoke(r101[r103]).booleanValue() == false) goto L7;
        r104 = r104 + 1;
    L7:
        r103 = r103 + 1;
        goto L3
    L8:
        return r104;
    }

    public final E elementAt(int r100) {
        boolean r101 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r101 == true) goto L10;
        throwIndexOutOfBoundsExclusiveException$collection(r100);
    L10:
        return (E) this.content[r100];
    L5:
        if (r100 >= this._size) goto L7;
        r101 = true;
        goto L7
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ObjectList) == false) goto L16;
        ObjectList r101 = (ObjectList) r100;
        int r102 = r101._size;
        int r103 = this._size;
        if (r102 != r103) goto L16;
        Object[] r104 = this.content;
        Object[] r105 = r101.content;
        IntRange r106 = RangesKt.until(0, r103);
        int r107 = r106.getFirst();
        int r108 = r106.getLast();
        if (r107 <= r108) goto L10;
        return true;
    L10:
        if (Intrinsics.areEqual(r104[r107], r105[r107]) == false) goto L11;
        if (r107 == r108) goto L19;
        r107 = r107 + 1;
        goto L10
    L19:
        return true;
    L11:
        return false;
    L16:
        return false;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [E, java.lang.Object] */
    public final E first(Function1<? super E, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        Object[] r101 = this.content;
        int r102 = this._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        ?? r104 = (Object) r101[r103];
        if (r100.invoke(r104).booleanValue() == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [E, java.lang.Object] */
    public final E firstOrNull(Function1<? super E, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        Object[] r101 = this.content;
        int r102 = this._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ?? r104 = (Object) r101[r103];
        if (r100.invoke(r104).booleanValue() == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public final void forEach(Function1<? super E, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        Object[] r101 = this.content;
        int r102 = this._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.invoke(r101[r103]);
        r103 = r103 + 1;
        goto L3
    }

    public final void forEachIndexed(Function2<? super Integer, ? super E, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        Object[] r101 = this.content;
        int r102 = this._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.invoke(Integer.valueOf(r103), r101[r103]);
        r103 = r103 + 1;
        goto L3
    }

    public final void forEachReversed(Function1<? super E, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        Object[] r101 = this.content;
        int r102 = this._size;
    L3:
        r102 = r102 - 1;
        if ((-1) >= r102) goto L6;
        r100.invoke(r101[r102]);
        goto L3
    }

    public final void forEachReversedIndexed(Function2<? super Integer, ? super E, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        Object[] r101 = this.content;
        int r102 = this._size;
    L3:
        r102 = r102 - 1;
        if ((-1) >= r102) goto L6;
        r100.invoke(Integer.valueOf(r102), r101[r102]);
        goto L3
    }

    public final E get(int r100) {
        boolean r101 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r101 == true) goto L10;
        throwIndexOutOfBoundsExclusiveException$collection(r100);
    L10:
        return (E) this.content[r100];
    L5:
        if (r100 >= this._size) goto L7;
        r101 = true;
        goto L7
    }

    public final int indexOf(E r100) {
        int r101 = 0;
        if (r100 != null) goto L10;
        Object[] r102 = this.content;
        int r103 = this._size;
    L5:
        if (r101 >= r103) goto L16;
        if (r102[r101] == null) goto L8;
        r101 = r101 + 1;
        goto L5
    L8:
        return r101;
    L16:
        return -1;
    L10:
        Object[] r104 = this.content;
        int r105 = this._size;
    L11:
        if (r101 >= r105) goto L22;
        if (r100.equals(r104[r101]) == true) goto L14;
        r101 = r101 + 1;
        goto L11
    L14:
        return r101;
    L22:
        return -1;
    }

    public final int indexOfFirst(Function1<? super E, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        Object[] r101 = this.content;
        int r102 = this._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (r100.invoke(r101[r103]).booleanValue() == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r103;
    L8:
        return -1;
    }

    public final int indexOfLast(Function1<? super E, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        Object[] r101 = this.content;
        int r102 = this._size;
    L3:
        r102 = r102 - 1;
        if ((-1) >= r102) goto L9;
        if (r100.invoke(r101[r102]).booleanValue() == false) goto L3;
        return r102;
    L9:
        return -1;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [E, java.lang.Object] */
    public final E last(Function1<? super E, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        Object[] r101 = this.content;
        int r102 = this._size;
    L3:
        r102 = r102 - 1;
        if ((-1) >= r102) goto L10;
        ?? r103 = (Object) r101[r102];
        if (r100.invoke(r103).booleanValue() == false) goto L3;
        return r103;
    L10:
        throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
    }

    public final int lastIndexOf(E r100) {
        if (r100 != null) goto L10;
        Object[] r101 = this.content;
        int r102 = this._size - 1;
    L5:
        if ((-1) >= r102) goto L16;
        if (r101[r102] == null) goto L8;
        r102 = r102 - 1;
        goto L5
    L8:
        return r102;
    L16:
        return -1;
    L10:
        Object[] r103 = this.content;
        int r104 = this._size - 1;
    L11:
        if ((-1) >= r104) goto L16;
        if (r100.equals(r103[r104]) == true) goto L14;
        r104 = r104 - 1;
        goto L11
    L14:
        return r104;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [E, java.lang.Object] */
    public final E lastOrNull(Function1<? super E, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        Object[] r101 = this.content;
        int r102 = this._size;
    L3:
        r102 = r102 - 1;
        if ((-1) >= r102) goto L9;
        ?? r103 = (Object) r101[r102];
        if (r100.invoke(r103).booleanValue() == false) goto L3;
        return r103;
    L9:
        return null;
    }

    public final boolean reversedAny(Function1<? super E, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        Object[] r101 = this.content;
        int r102 = this._size - 1;
    L4:
        if ((-1) >= r102) goto L9;
        if (r100.invoke(r101[r102]).booleanValue() == true) goto L7;
        r102 = r102 - 1;
        goto L4
    L7:
        return true;
    L9:
        return false;
    }

    public final void throwIndexOutOfBoundsExclusiveException$collection(int r100) {
        StringBuilder r101 = new StringBuilder("Index ");
        r101.append(r100);
        r101.append(" must be in 0..");
        r101.append(this._size - 1);
        RuntimeHelpersKt.throwIndexOutOfBoundsException(r101.toString());
    }

    public final boolean containsAll(Iterable<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Iterator<? extends E> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (contains(r101.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(ObjectList<E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Object[] r101 = r100.content;
        int r102 = r100._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (contains(r101[r103]) == false) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public final boolean containsAll(E[] r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (contains(r100[r102]) == false) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private static final CharSequence toString$lambda$22(ObjectList r100, Object r101) {
        if (r101 != r100) goto L5;
        return "(this)";
    L5:
        return String.valueOf(r101);
    }

    public final E elementAtOrElse(int r100, Function1<? super Integer, ? extends E> r101) {
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        boolean r102 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r102 == true) goto L11;
        return r101.invoke(Integer.valueOf(r100));
    L11:
        return (E) this.content[r100];
    L5:
        if (r100 >= this._size) goto L7;
        r102 = true;
        goto L7
    }

    public final <R> R fold(R r100, Function2<? super R, ? super E, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        Object[] r102 = this.content;
        int r103 = this._size;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        R r105 = r100;
        r100 = r101.invoke(r105, r102[r104]);
        r104 = r104 + 1;
        goto L3
    L5:
        return r100;
    }

    public final <R> R foldIndexed(R r100, Function3<? super Integer, ? super R, ? super E, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        Object[] r102 = this.content;
        int r103 = this._size;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        Object r105 = r102[r104];
        r100 = r101.invoke(Integer.valueOf(r104), r100, r105);
        r104 = r104 + 1;
        goto L3
    L5:
        return r100;
    }

    public final <R> R foldRight(R r100, Function2<? super E, ? super R, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        Object[] r102 = this.content;
        int r103 = this._size;
    L3:
        r103 = r103 - 1;
        if ((-1) >= r103) goto L6;
        r100 = r101.invoke(r102[r103], r100);
        goto L3
    L6:
        return r100;
    }

    public final <R> R foldRightIndexed(R r100, Function3<? super Integer, ? super E, ? super R, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        Object[] r102 = this.content;
        int r103 = this._size;
    L3:
        r103 = r103 - 1;
        if ((-1) >= r103) goto L6;
        r100 = r101.invoke(Integer.valueOf(r103), r102[r103], r100);
        goto L3
    L6:
        return r100;
    }

    public final String joinToString(CharSequence r100, CharSequence r101, CharSequence r102, int r103, CharSequence r104, Function1<? super E, ? extends CharSequence> r110) {
        Intrinsics.checkNotNullParameter(r100, "separator");
        Intrinsics.checkNotNullParameter(r101, "prefix");
        Intrinsics.checkNotNullParameter(r102, "postfix");
        Intrinsics.checkNotNullParameter(r104, "truncated");
        StringBuilder r105 = new StringBuilder();
        r105.append(r101);
        Object[] r106 = this.content;
        int r107 = this._size;
        int r108 = 0;
    L3:
        if (r108 >= r107) goto L13;
        Object r109 = r106[r108];
        if (r108 == r103) goto L6;
        if (r108 == 0) goto L9;
        r105.append(r100);
    L9:
        if (r110 != null) goto L11;
        r105.append(r109);
    L12:
        r108 = r108 + 1;
        goto L3
    L11:
        r105.append(r110.invoke(r109));
        goto L12
    L6:
        r105.append(r104);
    L15:
        return r105.toString();
    L13:
        r105.append(r102);
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String joinToString$default(ObjectList r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, Function1 r110, int r111, Object r112) {
        if (r112 != null) goto L27;
        if ((r111 & 1) == 0) goto L6;
        r101 = ", ";
    L6:
        CharSequence r106 = "";
        if ((r111 & 2) == 0) goto L9;
        CharSequence r113 = "";
    L11:
        if ((r111 & 4) != 0) goto L15;
        r106 = r103;
    L15:
        if ((r111 & 8) == 0) goto L17;
        int r107 = -1;
    L19:
        if ((r111 & 16) == 0) goto L21;
        r105 = "...";
    L21:
        CharSequence r108 = r105;
        if ((r111 & 32) == 0) goto L24;
        r110 = null;
    L24:
        Function1 r109 = r110;
        return r100.joinToString(r101, r113, r106, r107, r108, r109);
    L17:
        r107 = r104;
        goto L19
    L9:
        r113 = r102;
        goto L11
    L27:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }
}
