package androidx.compose.ui.util;

import D7.A;
import D7.v;
import H4.o;
import S7.k;
import S7.n;
import androidx.collection.MutableScatterSet;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u001f\n\u0002\b\u001d\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\u0005\u001a?\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a?\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0007\u0010\u0006\u001aE\u0010\n\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a?\u0010\u000e\u001a\u00020\f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u0002H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a?\u0010\u0010\u001a\u00020\f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u0002H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0010\u0010\u000f\u001aA\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u0002H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a?\u0010\u0014\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u0002H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001aK\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001aQ\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00010\u001a*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u001b\u0010\u0012\u001a_\u0010\u001f\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0016\"\u0010\b\u0002\u0010\u001d*\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001e\u001a\u00028\u00022\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b\u001f\u0010 \u001aA\u0010!\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u0002H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b!\u0010\u0012\u001aE\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u0002H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\"\u0010\u0019\u001ag\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u00022\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\b\u0082\u0002\u0010\n\u0006\b\u0001\u0012\u0002\u0010\u0001\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b#\u0010$\u001aS\u0010'\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010%\u001a\u00028\u00012\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b'\u0010(\u001aQ\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b)\u0010*\u001aS\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b+\u0010*\u001aQ\u0010,\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00010\u001a*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b,\u0010-\u001aW\u0010/\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00010\u001a*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010.\u001a\u00028\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b/\u00100\u001aQ\u00101\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b1\u0010*\u001aO\u00103\u001a\u00028\u0000\"\u0004\b\u0000\u00102\"\b\b\u0001\u0010\u0000*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00012\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b3\u00104\u001ae\u00107\u001a\b\u0012\u0004\u0012\u00028\u00020\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0016\"\u0004\b\u0002\u00105*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u00010\u00012\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b7\u00108\u001aM\u00109\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0002H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b9\u0010\u0019\u001ag\u0010A\u001a\u00020@\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010;\u001a\u00020:2\b\b\u0002\u0010<\u001a\u00020:2\b\b\u0002\u0010=\u001a\u00020:2\b\b\u0002\u0010>\u001a\u00020\t2\b\b\u0002\u0010?\u001a\u00020:2\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020:\u0018\u00010\u0002¢\u0006\u0004\bA\u0010B\u001aK\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010C*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\bD\u0010\u0019\u001aQ\u0010E\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00010\u001a*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\bE\u0010\u0012\u001aQ\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010F0\u0002H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\bG\u0010\u0019\u001a)\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020H*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001¢\u0006\u0004\bI\u0010J\u001a?\u0010K\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u0002H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\bK\u0010\u0012\u001a\u007f\u0010P\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\f\b\u0001\u0010N*\u00060Lj\u0002`M*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010O\u001a\u00028\u00012\b\b\u0002\u0010;\u001a\u00020:2\b\b\u0002\u0010<\u001a\u00020:2\b\b\u0002\u0010=\u001a\u00020:2\b\b\u0002\u0010>\u001a\u00020\t2\b\b\u0002\u0010?\u001a\u00020:2\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020:\u0018\u00010\u0002H\u0002¢\u0006\u0004\bP\u0010Q\u001a;\u0010S\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u00060Lj\u0002`M2\u0006\u0010R\u001a\u00028\u00002\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020:\u0018\u00010\u0002H\u0002¢\u0006\u0004\bS\u0010T\u001a\u0017\u0010W\u001a\u00020V2\u0006\u0010U\u001a\u00020@H\u0001¢\u0006\u0004\bW\u0010X\u001a\u0017\u0010Y\u001a\u00020\u00032\u0006\u0010U\u001a\u00020@H\u0001¢\u0006\u0004\bY\u0010Z¨\u0006["}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/Function1;", "LC7/r;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "fastForEach", "(Ljava/util/List;LS7/k;)V", "fastForEachReversed", "Lkotlin/Function2;", "", "fastForEachIndexed", "(Ljava/util/List;LS7/n;)V", "", "predicate", "fastAll", "(Ljava/util/List;LS7/k;)Z", "fastAny", "fastFirstOrNull", "(Ljava/util/List;LS7/k;)Ljava/lang/Object;", "selector", "fastSumBy", "(Ljava/util/List;LS7/k;)I", "R", "transform", "fastMap", "(Ljava/util/List;LS7/k;)Ljava/util/List;", "", "fastMaxBy", "", "C", "destination", "fastMapTo", "(Ljava/util/List;Ljava/util/Collection;LS7/k;)Ljava/util/Collection;", "fastLastOrNull", "fastFilter", "fastFilteredMap", "(Ljava/util/List;LS7/k;LS7/k;)Ljava/util/List;", "initial", "operation", "fastFold", "(Ljava/util/List;Ljava/lang/Object;LS7/n;)Ljava/lang/Object;", "fastMapIndexed", "(Ljava/util/List;LS7/n;)Ljava/util/List;", "fastMapIndexedNotNull", "fastMaxOfOrNull", "(Ljava/util/List;LS7/k;)Ljava/lang/Comparable;", "defaultValue", "fastMaxOfOrDefault", "(Ljava/util/List;Ljava/lang/Comparable;LS7/k;)Ljava/lang/Comparable;", "fastZipWithNext", ExifInterface.LATITUDE_SOUTH, "fastReduce", "(Ljava/util/List;LS7/n;)Ljava/lang/Object;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "other", "fastZip", "(Ljava/util/List;Ljava/util/List;LS7/n;)Ljava/util/List;", "fastMapNotNull", "", "separator", "prefix", "postfix", "limit", "truncated", "", "fastJoinToString", "(Ljava/util/List;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;LS7/k;)Ljava/lang/String;", "K", "fastDistinctBy", "fastMinByOrNull", "", "fastFlatMap", "", "fastFilterNotNull", "(Ljava/util/List;)Ljava/util/List;", "fastFirst", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "buffer", "fastJoinTo", "(Ljava/util/List;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;LS7/k;)Ljava/lang/Appendable;", "element", "appendElement", "(Ljava/lang/Appendable;Ljava/lang/Object;LS7/k;)V", "message", "", "throwNoSuchElementException", "(Ljava/lang/String;)Ljava/lang/Void;", "throwUnsupportedOperationException", "(Ljava/lang/String;)V", "ui-util"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ListUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void appendElement(Appendable appendable, T t9, k kVar) throws IOException {
        if (kVar != null) {
            appendable.append((CharSequence) kVar.invoke(t9));
            return;
        }
        if (t9 == 0 ? true : t9 instanceof CharSequence) {
            appendable.append((CharSequence) t9);
        } else if (t9 instanceof Character) {
            appendable.append(((Character) t9).charValue());
        } else {
            appendable.append(t9.toString());
        }
    }

    public static final <T> boolean fastAll(List<? extends T> list, k kVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!((Boolean) kVar.invoke(list.get(i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean fastAny(List<? extends T> list, k kVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((Boolean) kVar.invoke(list.get(i))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <T, K> List<T> fastDistinctBy(List<? extends T> list, k kVar) {
        MutableScatterSet mutableScatterSet = new MutableScatterSet(list.size());
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T t9 = list.get(i);
            if (mutableScatterSet.add(kVar.invoke(t9))) {
                arrayList.add(t9);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> fastFilter(List<? extends T> list, k kVar) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T t9 = list.get(i);
            if (((Boolean) kVar.invoke(t9)).booleanValue()) {
                arrayList.add(t9);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> fastFilterNotNull(List<? extends T> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T t9 = list.get(i);
            if (t9 != null) {
                arrayList.add(t9);
            }
        }
        return arrayList;
    }

    public static final <T, R> List<R> fastFilteredMap(List<? extends T> list, k kVar, k kVar2) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T t9 = list.get(i);
            if (((Boolean) kVar.invoke(t9)).booleanValue()) {
                arrayList.add(kVar2.invoke(t9));
            }
        }
        return arrayList;
    }

    public static final <T> T fastFirst(List<? extends T> list, k kVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T t9 = list.get(i);
            if (((Boolean) kVar.invoke(t9)).booleanValue()) {
                return t9;
            }
        }
        throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    public static final <T> T fastFirstOrNull(List<? extends T> list, k kVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T t9 = list.get(i);
            if (((Boolean) kVar.invoke(t9)).booleanValue()) {
                return t9;
            }
        }
        return null;
    }

    public static final <T, R> List<R> fastFlatMap(List<? extends T> list, k kVar) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            A.e0((Iterable) kVar.invoke(list.get(i)), arrayList);
        }
        return arrayList;
    }

    public static final <T, R> R fastFold(List<? extends T> list, R r5, n nVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            r5 = (R) nVar.invoke(r5, list.get(i));
        }
        return r5;
    }

    public static final <T> void fastForEach(List<? extends T> list, k kVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            kVar.invoke(list.get(i));
        }
    }

    public static final <T> void fastForEachIndexed(List<? extends T> list, n nVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            nVar.invoke(Integer.valueOf(i), list.get(i));
        }
    }

    public static final <T> void fastForEachReversed(List<? extends T> list, k kVar) {
        int size = list.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i = size - 1;
            kVar.invoke(list.get(size));
            if (i < 0) {
                return;
            } else {
                size = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T, A extends Appendable> A fastJoinTo(List<? extends T> list, A a3, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, k kVar) throws IOException {
        a3.append(charSequence2);
        int size = list.size();
        int i6 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            T t9 = list.get(i10);
            i6++;
            if (i6 > 1) {
                a3.append(charSequence);
            }
            if (i >= 0 && i6 > i) {
                break;
            }
            appendElement(a3, t9, kVar);
        }
        if (i >= 0 && i6 > i) {
            a3.append(charSequence4);
        }
        a3.append(charSequence3);
        return a3;
    }

    public static final <T> String fastJoinToString(List<? extends T> list, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, k kVar) {
        return ((StringBuilder) fastJoinTo(list, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, kVar)).toString();
    }

    public static /* synthetic */ String fastJoinToString$default(List list, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, k kVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i6 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i6 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i6 & 8) != 0) {
            i = -1;
        }
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i6 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        k kVar2 = kVar;
        return fastJoinToString(list, charSequence, charSequence2, charSequence3, i, charSequence5, kVar2);
    }

    public static final <T> T fastLastOrNull(List<? extends T> list, k kVar) {
        int size = list.size() - 1;
        if (size < 0) {
            return null;
        }
        while (true) {
            int i = size - 1;
            T t9 = list.get(size);
            if (((Boolean) kVar.invoke(t9)).booleanValue()) {
                return t9;
            }
            if (i < 0) {
                return null;
            }
            size = i;
        }
    }

    public static final <T, R> List<R> fastMap(List<? extends T> list, k kVar) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(kVar.invoke(list.get(i)));
        }
        return arrayList;
    }

    public static final <T, R> List<R> fastMapIndexed(List<? extends T> list, n nVar) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(nVar.invoke(Integer.valueOf(i), list.get(i)));
        }
        return arrayList;
    }

    public static final <T, R> List<R> fastMapIndexedNotNull(List<? extends T> list, n nVar) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object objInvoke = nVar.invoke(Integer.valueOf(i), list.get(i));
            if (objInvoke != null) {
                arrayList.add(objInvoke);
            }
        }
        return arrayList;
    }

    public static final <T, R> List<R> fastMapNotNull(List<? extends T> list, k kVar) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object objInvoke = kVar.invoke(list.get(i));
            if (objInvoke != null) {
                arrayList.add(objInvoke);
            }
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C fastMapTo(List<? extends T> list, C c, k kVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            c.add(kVar.invoke(list.get(i)));
        }
        return c;
    }

    public static final <T, R extends Comparable<? super R>> T fastMaxBy(List<? extends T> list, k kVar) {
        if (list.isEmpty()) {
            return null;
        }
        T t9 = list.get(0);
        Comparable comparable = (Comparable) kVar.invoke(t9);
        int iH = o.H(list);
        int i = 1;
        if (1 <= iH) {
            while (true) {
                T t10 = list.get(i);
                Comparable comparable2 = (Comparable) kVar.invoke(t10);
                if (comparable.compareTo(comparable2) < 0) {
                    t9 = t10;
                    comparable = comparable2;
                }
                if (i == iH) {
                    break;
                }
                i++;
            }
        }
        return t9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R extends Comparable<? super R>> R fastMaxOfOrDefault(List<? extends T> list, R r5, k kVar) {
        if (list.isEmpty()) {
            return r5;
        }
        R r6 = (R) kVar.invoke(list.get(0));
        int iH = o.H(list);
        int i = 1;
        if (1 <= iH) {
            while (true) {
                Comparable comparable = (Comparable) kVar.invoke(list.get(i));
                if (comparable.compareTo(r6) > 0) {
                    r6 = comparable;
                }
                if (i == iH) {
                    break;
                }
                i++;
            }
        }
        return r6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R extends Comparable<? super R>> R fastMaxOfOrNull(List<? extends T> list, k kVar) {
        if (list.isEmpty()) {
            return null;
        }
        R r5 = (R) kVar.invoke(list.get(0));
        int iH = o.H(list);
        int i = 1;
        if (1 <= iH) {
            while (true) {
                Comparable comparable = (Comparable) kVar.invoke(list.get(i));
                if (comparable.compareTo(r5) > 0) {
                    r5 = comparable;
                }
                if (i == iH) {
                    break;
                }
                i++;
            }
        }
        return r5;
    }

    public static final <T, R extends Comparable<? super R>> T fastMinByOrNull(List<? extends T> list, k kVar) {
        if (list.isEmpty()) {
            return null;
        }
        T t9 = list.get(0);
        Comparable comparable = (Comparable) kVar.invoke(t9);
        int iH = o.H(list);
        int i = 1;
        if (1 <= iH) {
            while (true) {
                T t10 = list.get(i);
                Comparable comparable2 = (Comparable) kVar.invoke(t10);
                if (comparable.compareTo(comparable2) > 0) {
                    t9 = t10;
                    comparable = comparable2;
                }
                if (i == iH) {
                    break;
                }
                i++;
            }
        }
        return t9;
    }

    public static final <S, T extends S> S fastReduce(List<? extends T> list, n nVar) {
        if (list.isEmpty()) {
            throwUnsupportedOperationException("Empty collection can't be reduced.");
        }
        S s5 = (S) v.A0(list);
        int iH = o.H(list);
        int i = 1;
        if (1 <= iH) {
            while (true) {
                s5 = (S) nVar.invoke(s5, list.get(i));
                if (i == iH) {
                    break;
                }
                i++;
            }
        }
        return s5;
    }

    public static final <T> int fastSumBy(List<? extends T> list, k kVar) {
        int size = list.size();
        int iIntValue = 0;
        for (int i = 0; i < size; i++) {
            iIntValue += ((Number) kVar.invoke(list.get(i))).intValue();
        }
        return iIntValue;
    }

    public static final <T, R, V> List<V> fastZip(List<? extends T> list, List<? extends R> list2, n nVar) {
        int iMin = Math.min(list.size(), list2.size());
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(nVar.invoke(list.get(i), list2.get(i)));
        }
        return arrayList;
    }

    public static final <T, R> List<R> fastZipWithNext(List<? extends T> list, n nVar) {
        if (list.size() <= 1) {
            return EmptyList.f4893a;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        T t9 = list.get(0);
        int iH = o.H(list);
        while (i < iH) {
            i++;
            T t10 = list.get(i);
            arrayList.add(nVar.invoke(t9, t10));
            t9 = t10;
        }
        return arrayList;
    }

    public static final Void throwNoSuchElementException(String str) {
        throw new NoSuchElementException(str);
    }

    public static final void throwUnsupportedOperationException(String str) {
        throw new UnsupportedOperationException(str);
    }
}
