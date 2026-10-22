package androidx.compose.runtime.collection;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003:\u0003uvwB!\b\u0001\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005H\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ\u001b\u0010\u001a\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010 J\u001c\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00072\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#J\u001c\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00072\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0017\u0010!\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0086\bJ\u0017\u0010!\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0086\bJ\u0019\u0010!\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010$J\u001c\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00072\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000%J\u0014\u0010!\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000%J(\u0010&\u001a\u00020\u001b2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J(\u0010)\u001a\u00020\u001b2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eJ\u0006\u0010+\u001a\u00020\u001eJ\u0016\u0010,\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001dJ\u0014\u0010-\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#J\u0014\u0010-\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000%J\u0014\u0010-\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0014\u0010.\u001a\u00020\u001b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0011\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u0007H\u0086\bJ\u0010\u00102\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u0007H\u0001J\u000b\u00103\u001a\u00028\u0000¢\u0006\u0002\u00104J-\u00103\u001a\u00028\u00002\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00105J\t\u00106\u001a\u000207H\u0081\bJ\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001J\u0010\u0010:\u001a\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0002\u00104J/\u0010:\u001a\u0004\u0018\u00018\u00002\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00105JP\u0010;\u001a\u0002H<\"\u0004\b\u0001\u0010<2\u0006\u0010=\u001a\u0002H<2'\u0010>\u001a#\u0012\u0013\u0012\u0011H<¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H<0?H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010CJe\u0010D\u001a\u0002H<\"\u0004\b\u0001\u0010<2\u0006\u0010=\u001a\u0002H<2<\u0010>\u001a8\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H<¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H<0EH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010FJP\u0010G\u001a\u0002H<\"\u0004\b\u0001\u0010<2\u0006\u0010=\u001a\u0002H<2'\u0010>\u001a#\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H<¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0004\u0012\u0002H<0?H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010CJe\u0010H\u001a\u0002H<\"\u0004\b\u0001\u0010<2\u0006\u0010=\u001a\u0002H<2<\u0010>\u001a8\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H<¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0004\u0012\u0002H<0EH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010FJ(\u0010I\u001a\u00020\u001e2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J.\u0010K\u001a\u00020\u001e2\u0018\u0010J\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e0?H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J(\u0010L\u001a\u00020\u001e2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J.\u0010M\u001a\u00020\u001e2\u0018\u0010J\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e0?H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0016\u0010N\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0007H\u0086\n¢\u0006\u0002\u0010OJ\u0013\u0010P\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010QJ(\u0010R\u001a\u00020\u00072\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J(\u0010S\u001a\u00020\u00072\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\t\u0010T\u001a\u00020\u001bH\u0086\bJ\t\u0010U\u001a\u00020\u001bH\u0086\bJ\u000b\u0010V\u001a\u00028\u0000¢\u0006\u0002\u00104J-\u0010V\u001a\u00028\u00002\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00105J\u0013\u0010W\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010QJ\u0010\u0010X\u001a\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0002\u00104J/\u0010X\u001a\u0004\u0018\u00018\u00002\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00105J;\u0010Y\u001a\b\u0012\u0004\u0012\u0002H<0\u0005\"\u0006\b\u0001\u0010<\u0018\u00012\u0012\u0010Z\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H<0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010[JP\u0010\\\u001a\b\u0012\u0004\u0012\u0002H<0\u0005\"\u0006\b\u0001\u0010<\u0018\u00012'\u0010Z\u001a#\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H<0?H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010]JM\u0010^\u001a\b\u0012\u0004\u0012\u0002H<0\u0000\"\u0006\b\u0001\u0010<\u0018\u00012)\u0010Z\u001a%\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u0001H<0?H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J8\u0010_\u001a\b\u0012\u0004\u0012\u0002H<0\u0000\"\u0006\b\u0001\u0010<\u0018\u00012\u0014\u0010Z\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u0001H<0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0016\u0010`\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010aJ\u0016\u0010b\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010aJ\u0013\u0010c\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ\u0014\u0010d\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#J\u0014\u0010d\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0014\u0010d\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000%J\u0013\u0010e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0007¢\u0006\u0002\u0010OJ\u0016\u0010f\u001a\u00020\u001e2\u0006\u0010g\u001a\u00020\u00072\u0006\u0010h\u001a\u00020\u0007J\u0010\u0010i\u001a\u00020\u001e2\u0006\u0010j\u001a\u00020\u0007H\u0001J\u001d\u0010k\u001a\u00020\u001e2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b0(H\u0086\bJ\u0014\u0010l\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000%J\u001e\u0010m\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010nJ\u001e\u0010o\u001a\u00020\u001e2\u0016\u0010p\u001a\u0012\u0012\u0004\u0012\u00028\u00000qj\b\u0012\u0004\u0012\u00028\u0000`rJ(\u0010s\u001a\u00020\u00072\u0012\u0010t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001R\"\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00058\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\f\u0012\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0014\u001a\u00020\u00158Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006x"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "content", "", "size", "", "<init>", "([Ljava/lang/Object;I)V", "getContent$annotations", "()V", "[Ljava/lang/Object;", "list", "", "value", "getSize", "()I", "lastIndex", "getLastIndex", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "getContent", "()[Ljava/lang/Object;", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", SlcElement.KEY_ELEMENTS, "", "([Ljava/lang/Object;)Z", "", "any", "predicate", "Lkotlin/Function1;", "reversedAny", "asMutableList", "clear", "contains", "containsAll", "contentEquals", "other", "ensureCapacity", "capacity", "resizeStorage", SoloKtvContext.SOLO_PAGE_FIRST, "()Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "throwNoSuchElementException", "", "message", "", "firstOrNull", "fold", "R", "initial", WikiFolderPushPlugin.OPT, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", MonitorConstants.CONNECT_TYPE_GET, "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "last", "lastIndexOf", "lastOrNull", "map", "transform", "(Lkotlin/jvm/functions/Function1;)[Ljava/lang/Object;", "mapIndexed", "(Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "mapIndexedNotNull", "mapNotNull", "plusAssign", "(Ljava/lang/Object;)V", "minusAssign", "remove", "removeAll", "removeAt", "removeRange", "start", "end", "setSize", "newSize", "removeIf", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "sortWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "sumBy", "selector", "VectorListIterator", "MutableVectorList", "SubList", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableVector<T> implements RandomAccess {
    public static final int $stable = 8;
    public T[] content;
    private List<T> list;
    private int size;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\u0016\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00020\bH\u0096\u0002¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0019H\u0096\u0002J\u0015\u0010\u001a\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0016J\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\u0016\u0010\u001e\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010!H\u0016J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010!2\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0015\u0010\"\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u0016\u0010#\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\u0015\u0010$\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u0014J\u0016\u0010%\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\u001e\u0010&\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006+"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector$MutableVectorList;", ExifInterface.GPS_DIRECTION_TRUE, "", "vector", "Landroidx/compose/runtime/collection/MutableVector;", "<init>", "(Landroidx/compose/runtime/collection/MutableVector;)V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", SlcElement.KEY_ELEMENTS, "", MonitorConstants.CONNECT_TYPE_GET, "index", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "add", "", "(ILjava/lang/Object;)V", "addAll", "clear", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MutableVectorList<T> implements List<T>, KMutableList {
        private final MutableVector<T> vector;

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] r100) {
            return (T[]) CollectionToArray.toArray(this, r100);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.vector.clear();
        }

        public int getSize() {
            return this.vector.getSize();
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            if (this.vector.getSize() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        public MutableVectorList(MutableVector<T> r100) {
            this.vector = r100;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T r100) {
            return this.vector.add(r100);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> r100) {
            return this.vector.addAll(r100);
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object r100) {
            return this.vector.contains(r100);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<?> r100) {
            return this.vector.containsAll(r100);
        }

        @Override // java.util.List
        public T get(int r100) {
            MutableVectorKt.checkIndex(this, r100);
            return this.vector.content[r100];
        }

        @Override // java.util.List
        public int indexOf(Object r100) {
            return this.vector.indexOf(r100);
        }

        @Override // java.util.List
        public int lastIndexOf(Object r100) {
            return this.vector.lastIndexOf(r100);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int r100) {
            return new VectorListIterator(this, r100);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object r100) {
            return this.vector.remove(r100);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<?> r100) {
            return this.vector.removeAll(r100);
        }

        public T removeAt(int r100) {
            MutableVectorKt.checkIndex(this, r100);
            return this.vector.removeAt(r100);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<?> r100) {
            return this.vector.retainAll(r100);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int r100) {
            return removeAt(r100);
        }

        @Override // java.util.List
        public void add(int r100, T r101) {
            this.vector.add(r100, r101);
        }

        @Override // java.util.List
        public boolean addAll(int r100, Collection<? extends T> r101) {
            return this.vector.addAll(r100, r101);
        }

        @Override // java.util.List
        public T set(int r100, T r101) {
            MutableVectorKt.checkIndex(this, r100);
            return this.vector.set(r100, r101);
        }

        @Override // java.util.List
        public List<T> subList(int r100, int r101) {
            MutableVectorKt.checkSubIndex(this, r100, r101);
            return new SubList(this, r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\u0016\u0010\u0013\u001a\u00028\u00012\u0006\u0010\u0014\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\rH\u0016J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u001aH\u0096\u0002J\u0015\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0017J\u0015\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000fJ\u001d\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\u0016\u0010\u001f\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\"H\u0016J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\"2\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0015\u0010#\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000fJ\u0016\u0010$\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\u0015\u0010%\u001a\u00028\u00012\u0006\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0015J\u0016\u0010&\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\u001e\u0010'\u001a\u00028\u00012\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010(J\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006,"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector$SubList;", ExifInterface.GPS_DIRECTION_TRUE, "", "list", "start", "", "end", "<init>", "(Ljava/util/List;II)V", "size", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", SlcElement.KEY_ELEMENTS, "", MonitorConstants.CONNECT_TYPE_GET, "index", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "add", "", "(ILjava/lang/Object;)V", "addAll", "clear", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SubList<T> implements List<T>, KMutableList {
        private int end;
        private final List<T> list;
        private final int start;

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] r100) {
            return (T[]) CollectionToArray.toArray(this, r100);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int r100 = this.end - 1;
            int r101 = this.start;
            if (r101 > r100) goto L7;
        L4:
            ListProtector.remove(this.list, r100);
            if (r100 == r101) goto L7;
            r100 = r100 - 1;
        L7:
            this.end = this.start;
        }

        public int getSize() {
            return this.end - this.start;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            if (this.end != this.start) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T r100) {
            List<T> r101 = this.list;
            int r102 = this.end;
            this.end = r102 + 1;
            ListProtector.add(r101, r102, r100);
            return true;
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> r100) {
            this.list.addAll(this.end, r100);
            int r101 = r100.size();
            this.end += r101;
            if (r101 <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object r100) {
            int r101 = this.start;
            int r102 = this.end;
        L3:
            if (r101 >= r102) goto L9;
            if (Intrinsics.areEqual(ListProtector.get(this.list, r101), r100) == true) goto L6;
            r101 = r101 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<?> r100) {
            Iterator<T> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L9;
            if (contains(r101.next()) == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // java.util.List
        public T get(int r100) {
            MutableVectorKt.checkIndex(this, r100);
            return (T) ListProtector.get(this.list, r100 + this.start);
        }

        @Override // java.util.List
        public int indexOf(Object r100) {
            int r101 = this.start;
            int r102 = this.end;
        L3:
            if (r101 >= r102) goto L9;
            if (Intrinsics.areEqual(ListProtector.get(this.list, r101), r100) == true) goto L7;
            r101 = r101 + 1;
            goto L3
        L7:
            return r101 - this.start;
        L9:
            return -1;
        }

        @Override // java.util.List
        public int lastIndexOf(Object r100) {
            int r101 = this.end - 1;
            int r102 = this.start;
            if (r102 <= r101) goto L5;
            return -1;
        L5:
            if (Intrinsics.areEqual(ListProtector.get(this.list, r101), r100) == true) goto L7;
            if (r101 == r102) goto L14;
            r101 = r101 - 1;
            goto L5
        L14:
            return -1;
        L7:
            return r101 - this.start;
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int r100) {
            return new VectorListIterator(this, r100);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object r100) {
            int r101 = this.start;
            int r102 = this.end;
        L3:
            if (r101 >= r102) goto L9;
            if (Intrinsics.areEqual(ListProtector.get(this.list, r101), r100) == true) goto L6;
            r101 = r101 + 1;
            goto L3
        L6:
            ListProtector.remove(this.list, r101);
            this.end--;
            return true;
        L9:
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<?> r100) {
            int r101 = this.end;
            Iterator<T> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L7;
            remove(r102.next());
            goto L4
        L7:
            if (r101 == this.end) goto L9;
            return true;
        L9:
            return false;
        }

        public T removeAt(int r100) {
            MutableVectorKt.checkIndex(this, r100);
            T r101 = (T) ListProtector.remove(this.list, r100 + this.start);
            this.end--;
            return r101;
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<?> r100) {
            int r101 = this.end;
            int r102 = r101 - 1;
            int r103 = this.start;
            if (r103 > r102) goto L10;
        L5:
            if (r100.contains(ListProtector.get(this.list, r102)) == true) goto L7;
            ListProtector.remove(this.list, r102);
            this.end--;
        L7:
            if (r102 == r103) goto L10;
            r102 = r102 - 1;
        L10:
            if (r101 == this.end) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int r100) {
            return removeAt(r100);
        }

        @Override // java.util.List
        public void add(int r100, T r101) {
            ListProtector.add(this.list, r100 + this.start, r101);
            this.end++;
        }

        @Override // java.util.List
        public boolean addAll(int r100, Collection<? extends T> r101) {
            this.list.addAll(r100 + this.start, r101);
            int r102 = r101.size();
            this.end += r102;
            if (r102 <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.List
        public T set(int r100, T r101) {
            MutableVectorKt.checkIndex(this, r100);
            return (T) ListProtector.set(this.list, r100 + this.start, r101);
        }

        @Override // java.util.List
        public List<T> subList(int r100, int r101) {
            MutableVectorKt.checkSubIndex(this, r100, r101);
            return new SubList(this, r100, r101);
        }

        public SubList(List<T> r100, int r101, int r102) {
            this.list = r100;
            this.start = r101;
            this.end = r102;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u000e\u0010\u000b\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\r\u0010\u0011\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector$VectorListIterator;", ExifInterface.GPS_DIRECTION_TRUE, "", "list", "", "index", "", "<init>", "(Ljava/util/List;I)V", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "()Ljava/lang/Object;", "remove", "", "hasPrevious", "nextIndex", "previous", "previousIndex", "add", "element", "(Ljava/lang/Object;)V", "set", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class VectorListIterator<T> implements ListIterator<T>, KMutableListIterator {
        private int index;
        private final List<T> list;

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.list.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.index <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            List<T> r100 = this.list;
            int r101 = this.index;
            this.index = r101 + 1;
            return (T) ListProtector.get(r100, r101);
        }

        @Override // java.util.ListIterator
        public T previous() {
            int r100 = this.index - 1;
            this.index = r100;
            return (T) ListProtector.get(this.list, r100);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int r100 = this.index - 1;
            this.index = r100;
            ListProtector.remove(this.list, r100);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public void add(T r100) {
            ListProtector.add(this.list, this.index, r100);
            this.index++;
        }

        @Override // java.util.ListIterator
        public void set(T r100) {
            ListProtector.set(this.list, this.index, r100);
        }

        public VectorListIterator(List<T> r100, int r101) {
            this.list = r100;
            this.index = r101;
        }
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public final IntRange getIndices() {
        return RangesKt.until(0, getSize());
    }

    public final List<T> asMutableList() {
        List<T> r100 = this.list;
        if (r100 != null) goto L6;
        MutableVectorList r101 = new MutableVectorList(this);
        this.list = r101;
        return r101;
    L6:
        return r100;
    }

    public final void clear() {
        T[] r100 = this.content;
        int r101 = this.size;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100[r102] = null;
        r102 = r102 + 1;
        goto L3
    L5:
        this.size = 0;
    }

    public final Void throwNoSuchElementException() {
        throwNoSuchElementException("MutableVector is empty.");
        throw new KotlinNothingValueException();
    }

    public final T first() {
        if (getSize() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        throwNoSuchElementException("MutableVector is empty.");
        throw new KotlinNothingValueException();
    L8:
        return this.content[0];
    L5:
        r100 = false;
        goto L6
    }

    public final T firstOrNull() {
        if (getSize() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        return null;
    L9:
        return this.content[0];
    L5:
        r100 = false;
        goto L6
    }

    public final int getLastIndex() {
        return getSize() - 1;
    }

    public final boolean isEmpty() {
        if (getSize() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNotEmpty() {
        if (getSize() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final T last() {
        if (getSize() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L9;
        int r101 = getSize() - 1;
        return this.content[r101];
    L9:
        throwNoSuchElementException("MutableVector is empty.");
        throw new KotlinNothingValueException();
    L5:
        r100 = false;
        goto L6
    }

    public final T lastOrNull() {
        if (getSize() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return null;
    L8:
        int r101 = getSize() - 1;
        return this.content[r101];
    L5:
        r100 = false;
        goto L6
    }

    public final T[] getContent() {
        return this.content;
    }

    public final int getSize() {
        return this.size;
    }

    public final boolean add(T r100) {
        int r101 = this.size + 1;
        if (this.content.length >= r101) goto L5;
        resizeStorage(r101);
    L5:
        T[] r102 = this.content;
        int r103 = this.size;
        r102[r103] = r100;
        this.size = r103 + 1;
        return true;
    }

    public final boolean addAll(T[] r100) {
        int r101 = r100.length;
        if (r101 != 0) goto L5;
        return false;
    L5:
        int r102 = this.size + r101;
        if (this.content.length >= r102) goto L8;
        resizeStorage(r102);
    L8:
        System.arraycopy(r100, 0, this.content, this.size, r101 + 0);
        this.size += r101;
        return true;
    }

    public final boolean any(Function1<? super T, Boolean> r100) {
        T[] r101 = this.content;
        int r102 = getSize();
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

    public final boolean contains(T r100) {
        int r101 = getSize() - 1;
        if (r101 < 0) goto L10;
        int r102 = 0;
    L6:
        if (Intrinsics.areEqual(this.content[r102], r100) == true) goto L7;
        if (r102 == r101) goto L10;
        r102 = r102 + 1;
        goto L6
    L7:
        return true;
    L10:
        return false;
    }

    public final boolean containsAll(MutableVector<T> r100) {
        IntRange r101 = RangesKt.until(0, r100.getSize());
        int r102 = r101.getFirst();
        int r103 = r101.getLast();
        if (r102 <= r103) goto L5;
        return true;
    L5:
        if (contains(r100.content[r102]) == false) goto L6;
        if (r102 == r103) goto L13;
        r102 = r102 + 1;
        goto L5
    L13:
        return true;
    L6:
        return false;
    }

    public final boolean contentEquals(MutableVector<T> r100) {
        if (r100.size == this.size) goto L5;
        return false;
    L5:
        int r101 = getSize() - 1;
        if (r101 < 0) goto L13;
        int r102 = 0;
    L9:
        if (Intrinsics.areEqual(r100.content[r102], this.content[r102]) == false) goto L10;
        if (r102 == r101) goto L13;
        r102 = r102 + 1;
        goto L9
    L10:
        return false;
    L13:
        return true;
    }

    public final void ensureCapacity(int r100) {
        if (this.content.length >= r100) goto L6;
        resizeStorage(r100);
        return;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, java.lang.Object] */
    public final T first(Function1<? super T, Boolean> r100) {
        T[] r101 = this.content;
        int r102 = getSize();
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
        throwNoSuchElementException("MutableVector contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, java.lang.Object] */
    public final T firstOrNull(Function1<? super T, Boolean> r100) {
        T[] r101 = this.content;
        int r102 = getSize();
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

    public final void forEach(Function1<? super T, Unit> r100) {
        T[] r101 = this.content;
        int r102 = getSize();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.invoke(r101[r103]);
        r103 = r103 + 1;
        goto L3
    }

    public final void forEachIndexed(Function2<? super Integer, ? super T, Unit> r100) {
        T[] r101 = this.content;
        int r102 = getSize();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.invoke(Integer.valueOf(r103), r101[r103]);
        r103 = r103 + 1;
        goto L3
    }

    public final void forEachReversed(Function1<? super T, Unit> r100) {
        int r101 = getSize() - 1;
        T[] r102 = this.content;
        if (r101 < r102.length) goto L5;
        return;
    L5:
        if (r101 < 0) goto L7;
        r100.invoke(r102[r101]);
        r101 = r101 - 1;
        goto L5
    }

    public final void forEachReversedIndexed(Function2<? super Integer, ? super T, Unit> r100) {
        int r101 = getSize() - 1;
        T[] r102 = this.content;
        if (r101 < r102.length) goto L5;
        return;
    L5:
        if (r101 < 0) goto L7;
        r100.invoke(Integer.valueOf(r101), r102[r101]);
        r101 = r101 - 1;
        goto L5
    }

    public final T get(int r100) {
        return this.content[r100];
    }

    public final int indexOf(T r100) {
        T[] r101 = this.content;
        int r102 = this.size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (Intrinsics.areEqual(r100, r101[r103]) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r103;
    L8:
        return -1;
    }

    public final int indexOfFirst(Function1<? super T, Boolean> r100) {
        T[] r101 = this.content;
        int r102 = getSize();
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

    public final int indexOfLast(Function1<? super T, Boolean> r100) {
        int r101 = getSize() - 1;
        T[] r102 = this.content;
        if (r101 >= r102.length) goto L9;
    L4:
        if (r101 < 0) goto L13;
        if (r100.invoke(r102[r101]).booleanValue() == true) goto L7;
        r101 = r101 - 1;
        goto L4
    L7:
        return r101;
    L13:
        return -1;
    L9:
        return -1;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    public final T last(Function1<? super T, Boolean> r100) {
        int r101 = getSize() - 1;
        T[] r102 = this.content;
    L3:
        if (r101 < 0) goto L8;
        ?? r103 = (Object) r102[r101];
        if (r100.invoke(r103).booleanValue() == true) goto L6;
        r101 = r101 - 1;
        goto L3
    L6:
        return r103;
    L8:
        throwNoSuchElementException("MutableVector contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    public final int lastIndexOf(T r100) {
        int r101 = this.size - 1;
        T[] r102 = this.content;
    L3:
        if (r101 < 0) goto L8;
        if (Intrinsics.areEqual(r100, r102[r101]) == true) goto L6;
        r101 = r101 - 1;
        goto L3
    L6:
        return r101;
    L8:
        return -1;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    public final T lastOrNull(Function1<? super T, Boolean> r100) {
        int r101 = getSize() - 1;
        T[] r102 = this.content;
    L3:
        if (r101 < 0) goto L8;
        ?? r103 = (Object) r102[r101];
        if (r100.invoke(r103).booleanValue() == true) goto L6;
        r101 = r101 - 1;
        goto L3
    L6:
        return r103;
    L8:
        return null;
    }

    public final /* synthetic */ <R> R[] map(Function1<? super T, ? extends R> r100) {
        int r101 = getSize();
        int r102 = 0;
        Intrinsics.reifiedOperationMarker(0, "R");
        R[] r103 = (R[]) new Object[r101];
    L3:
        if (r102 >= r101) goto L5;
        r103[r102] = r100.invoke(this.content[r102]);
        r102 = r102 + 1;
        goto L3
    L5:
        return r103;
    }

    public final /* synthetic */ <R> R[] mapIndexed(Function2<? super Integer, ? super T, ? extends R> r100) {
        int r101 = getSize();
        int r102 = 0;
        Intrinsics.reifiedOperationMarker(0, "R");
        R[] r103 = (R[]) new Object[r101];
    L3:
        if (r102 >= r101) goto L5;
        r103[r102] = r100.invoke(Integer.valueOf(r102), this.content[r102]);
        r102 = r102 + 1;
        goto L3
    L5:
        return r103;
    }

    public final /* synthetic */ <R> MutableVector<R> mapIndexedNotNull(Function2<? super Integer, ? super T, ? extends R> r100) {
        int r101 = getSize();
        int r102 = 0;
        Intrinsics.reifiedOperationMarker(0, "R?");
        Object[] r103 = new Object[r101];
        T[] r104 = this.content;
        int r105 = 0;
    L3:
        if (r102 >= r101) goto L9;
        R r106 = r100.invoke(Integer.valueOf(r102), r104[r102]);
        if (r106 == null) goto L7;
        r103[r105] = r106;
        r105 = r105 + 1;
    L7:
        r102 = r102 + 1;
        goto L3
    L9:
        return new MutableVector(r103, r105);
    }

    public final /* synthetic */ <R> MutableVector<R> mapNotNull(Function1<? super T, ? extends R> r100) {
        int r101 = getSize();
        int r102 = 0;
        Intrinsics.reifiedOperationMarker(0, "R?");
        Object[] r103 = new Object[r101];
        T[] r104 = this.content;
        int r105 = 0;
    L3:
        if (r102 >= r101) goto L9;
        R r106 = r100.invoke(r104[r102]);
        if (r106 == null) goto L7;
        r103[r105] = r106;
        r105 = r105 + 1;
    L7:
        r102 = r102 + 1;
        goto L3
    L9:
        return new MutableVector(r103, r105);
    }

    public final void minusAssign(T r100) {
        remove(r100);
    }

    public final void plusAssign(T r100) {
        add(r100);
    }

    public final boolean remove(T r100) {
        int r101 = indexOf(r100);
        if (r101 < 0) goto L6;
        removeAt(r101);
        return true;
    L6:
        return false;
    }

    public final boolean removeAll(Collection<? extends T> r100) {
        if (r100.isEmpty() == false) goto L5;
        return false;
    L5:
        int r101 = this.size;
        Iterator<T> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L10;
        remove(r102.next());
        goto L7
    L10:
        if (r101 == this.size) goto L14;
        return true;
    L14:
        return false;
    }

    public final T removeAt(int r100) {
        T[] r101 = this.content;
        T r102 = r101[r100];
        if (r100 == (getSize() - 1)) goto L5;
        int r103 = r100 + 1;
        System.arraycopy(r101, r103, r101, r100, this.size - r103);
    L5:
        int r104 = this.size - 1;
        this.size = r104;
        r101[r104] = null;
        return r102;
    }

    public final void removeIf(Function1<? super T, Boolean> r100) {
        int r101 = getSize();
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L10;
        if (r100.invoke(this.content[r102]).booleanValue() == false) goto L7;
        r103 = r103 + 1;
    L9:
        r102 = r102 + 1;
        goto L3
    L7:
        if (r103 <= 0) goto L9;
        T[] r104 = this.content;
        r104[r102 - r103] = r104[r102];
        goto L9
    L10:
        int r105 = r101 - r103;
        ArraysKt.fill(this.content, null, r105, r101);
        setSize(r105);
    }

    public final void resizeStorage(int r100) {
        T[] r101 = this.content;
        int r102 = r101.length;
        T[] r103 = (T[]) new Object[Math.max(r100, r102 * 2)];
        System.arraycopy(r101, 0, r103, 0, r102 - 0);
        this.content = r103;
    }

    public final boolean retainAll(Collection<? extends T> r100) {
        int r101 = this.size;
        int r102 = getSize() - 1;
    L4:
        if ((-1) >= r102) goto L10;
        if (r100.contains(this.content[r102]) == true) goto L8;
        removeAt(r102);
    L8:
        r102 = r102 - 1;
        goto L4
    L10:
        if (r101 != this.size) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean reversedAny(Function1<? super T, Boolean> r100) {
        T[] r101 = this.content;
        int r102 = getSize() - 1;
    L3:
        if (r102 < 0) goto L8;
        if (r100.invoke(r101[r102]).booleanValue() == true) goto L6;
        r102 = r102 - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    public final void setSize(int r100) {
        this.size = r100;
    }

    public final void sortWith(Comparator<T> r100) {
        ArraysKt.sortWith(this.content, r100, 0, this.size);
    }

    public final int sumBy(Function1<? super T, Integer> r100) {
        T[] r101 = this.content;
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= getSize()) goto L6;
        r103 = r103 + r100.invoke(r101[r102]).intValue();
        r102 = r102 + 1;
        goto L4
    L6:
        return r103;
    }

    public final Void throwNoSuchElementException(String r100) {
        throw new NoSuchElementException(r100);
    }

    public final boolean addAll(MutableVector<T> r100) {
        return addAll(getSize(), r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(List<? extends T> r100) {
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

    public final boolean removeAll(MutableVector<T> r100) {
        int r101 = this.size;
        int r102 = r100.getSize() - 1;
        if (r102 < 0) goto L9;
        int r103 = 0;
    L5:
        remove(r100.content[r103]);
        if (r103 == r102) goto L9;
        r103 = r103 + 1;
    L9:
        if (r101 != this.size) goto L14;
        return false;
    L14:
        return true;
    }

    public final boolean addAll(List<? extends T> r100) {
        return addAll(getSize(), r100);
    }

    public final boolean containsAll(Collection<? extends T> r100) {
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (contains(r101.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean removeAll(List<? extends T> r100) {
        int r101 = this.size;
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        remove(ListProtector.get(r100, r103));
        r103 = r103 + 1;
        goto L3
    L6:
        if (r101 == this.size) goto L10;
        return true;
    L10:
        return false;
    }

    public final boolean addAll(Collection<? extends T> r100) {
        return addAll(this.size, r100);
    }

    public MutableVector(T[] r100, int r101) {
        this.content = r100;
        this.size = r101;
    }

    public final void add(int r100, T r101) {
        int r102 = this.size + 1;
        if (this.content.length >= r102) goto L5;
        resizeStorage(r102);
    L5:
        T[] r103 = this.content;
        int r104 = this.size;
        if (r100 == r104) goto L8;
        System.arraycopy(r103, r100, r103, r100 + 1, r104 - r100);
    L8:
        r103[r100] = r101;
        this.size++;
    }

    public final boolean addAll(int r100, Collection<? extends T> r101) {
        int r102 = 0;
        if (r101.isEmpty() == false) goto L5;
        return false;
    L5:
        int r103 = r101.size();
        int r104 = this.size + r103;
        if (this.content.length >= r104) goto L8;
        resizeStorage(r104);
    L8:
        T[] r105 = this.content;
        int r106 = this.size;
        if (r100 == r106) goto L11;
        System.arraycopy(r105, r100, r105, r100 + r103, r106 - r100);
    L11:
        Iterator<T> r107 = r101.iterator();
    L13:
        if (r107.hasNext() == false) goto L18;
        T r108 = r107.next();
        int r109 = r102 + 1;
        if (r102 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        r105[r102 + r100] = r108;
        r102 = r109;
        goto L13
    L18:
        this.size += r103;
        return true;
    }

    public final <R> R fold(R r100, Function2<? super R, ? super T, ? extends R> r101) {
        T[] r102 = this.content;
        int r103 = getSize();
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

    public final <R> R foldIndexed(R r100, Function3<? super Integer, ? super R, ? super T, ? extends R> r101) {
        T[] r102 = this.content;
        int r103 = getSize();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        R r105 = r100;
        r100 = r101.invoke(Integer.valueOf(r104), r105, r102[r104]);
        r104 = r104 + 1;
        goto L3
    L5:
        return r100;
    }

    public final <R> R foldRight(R r100, Function2<? super T, ? super R, ? extends R> r101) {
        int r102 = getSize() - 1;
        T[] r103 = this.content;
        if (r102 < r103.length) goto L5;
        return r100;
    L5:
        if (r102 < 0) goto L7;
        r100 = r101.invoke(r103[r102], r100);
        r102 = r102 - 1;
        goto L5
    L7:
        return r100;
    }

    public final <R> R foldRightIndexed(R r100, Function3<? super Integer, ? super T, ? super R, ? extends R> r101) {
        int r102 = getSize() - 1;
        T[] r103 = this.content;
        if (r102 < r103.length) goto L5;
        return r100;
    L5:
        if (r102 < 0) goto L7;
        r100 = r101.invoke(Integer.valueOf(r102), r103[r102], r100);
        r102 = r102 - 1;
        goto L5
    L7:
        return r100;
    }

    public final void removeRange(int r100, int r101) {
        if (r101 <= r100) goto L15;
        int r102 = this.size;
        if (r101 >= r102) goto L6;
        T[] r103 = this.content;
        System.arraycopy(r103, r101, r103, r100, r102 - r101);
    L6:
        int r104 = this.size - (r101 - r100);
        int r105 = getSize() - 1;
        if (r104 > r105) goto L12;
        int r106 = r104;
    L9:
        this.content[r106] = null;
        if (r106 == r105) goto L12;
        r106 = r106 + 1;
    L12:
        this.size = r104;
        return;
    }

    public final T set(int r100, T r101) {
        T[] r102 = this.content;
        T r103 = r102[r100];
        r102[r100] = r101;
        return r103;
    }

    public final boolean addAll(int r100, List<? extends T> r101) {
        int r102 = 0;
        if (r101.isEmpty() == false) goto L5;
        return false;
    L5:
        int r103 = r101.size();
        int r104 = this.size + r103;
        if (this.content.length >= r104) goto L8;
        resizeStorage(r104);
    L8:
        Object[] r105 = (T[]) this.content;
        int r106 = this.size;
        if (r100 == r106) goto L11;
        System.arraycopy(r105, r100, r105, r100 + r103, r106 - r100);
    L11:
        int r107 = r101.size();
    L12:
        if (r102 >= r107) goto L14;
        r105[r100 + r102] = ListProtector.get(r101, r102);
        r102 = r102 + 1;
        goto L12
    L14:
        this.size += r103;
        return true;
    }

    public final boolean addAll(int r100, MutableVector<T> r101) {
        int r102 = r101.size;
        if (r102 != 0) goto L5;
        return false;
    L5:
        int r103 = this.size + r102;
        if (this.content.length >= r103) goto L8;
        resizeStorage(r103);
    L8:
        T[] r104 = this.content;
        int r105 = this.size;
        if (r100 == r105) goto L11;
        System.arraycopy(r104, r100, r104, r100 + r102, r105 - r100);
    L11:
        System.arraycopy(r101.content, 0, r104, r100, r102 + 0);
        this.size += r102;
        return true;
    }
}
