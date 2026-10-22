package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import k.c;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010)\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010*\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B?\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u001d\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u001eJ\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J\b\u0010 \u001a\u00020\u000bH\u0002J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010!\u001a\u00020\u000bH\u0002J\u001d\u0010\"\u001a\u00020#2\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010%J'\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010'J-\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010)\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010*J\u001f\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\b\u0010,\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010-J\u0015\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010\u0018J\u0015\u0010/\u001a\u00020#2\u0006\u0010,\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00100J?\u00101\u001a\u0002022\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u00105J?\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00107\u001a\u00020\u000bH\u0002¢\u0006\u0002\u00108J\u0016\u00109\u001a\u00020#2\f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;H\u0016J=\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010=\u001a\u00020\u000b2\u000e\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0?H\u0002¢\u0006\u0002\u0010@JE\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\u000b2\u0014\u0010B\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0007H\u0002¢\u0006\u0002\u0010CJM\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0014\u0010E\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070?H\u0002¢\u0006\u0002\u0010FJ\u001d\u0010/\u001a\u0002022\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010,\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010HJ/\u0010I\u001a\u0002022\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010,\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010JJG\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00107\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010\b2\u0006\u0010L\u001a\u00020MH\u0002¢\u0006\u0002\u0010NJ\u001e\u00109\u001a\u00020#2\u0006\u0010G\u001a\u00020\u000b2\f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;H\u0016J[\u0010K\u001a\u0002022\f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020\u000b2\u0016\u0010B\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010P\u001a\u00020\u000b2\u000e\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010RJU\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010T\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020\u000b2\u0016\u0010B\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010P\u001a\u00020\u000b2\u000e\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010UJk\u0010V\u001a\u0002022\f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;2\u0006\u0010G\u001a\u00020\u000b2\u000e\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010X\u001a\u00020\u000b2\u0016\u0010B\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010P\u001a\u00020\u000b2\u000e\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010YJ\u0016\u0010Z\u001a\u00028\u00002\u0006\u0010G\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u0010[J\u001d\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010G\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010]J\u0015\u0010^\u001a\u00028\u00002\u0006\u0010G\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010[J9\u0010_\u001a\u0004\u0018\u00010\b2\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010`J=\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00107\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020MH\u0002¢\u0006\u0002\u0010cJ/\u0010d\u001a\u0002022\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010eJ?\u0010f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00107\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010b\u001a\u00020MH\u0002¢\u0006\u0002\u0010cJ\u0016\u0010g\u001a\u00020#2\f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;H\u0016J\u001a\u0010h\u001a\u00020#2\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020#0jJ\u001c\u0010g\u001a\u00020#2\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020#0jH\u0002J/\u0010k\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u001b\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010*J5\u0010l\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010G\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010mJ,\u0010n\u001a\u00020\u000b2\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020#0j2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010o\u001a\u00020MH\u0002JA\u0010g\u001a\u00020\u000b2\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020#0j2\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010p\u001a\u00020\u000b2\u0006\u0010o\u001a\u00020MH\u0002¢\u0006\u0002\u0010qJu\u0010r\u001a\u00020\u000b2\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020#0j2\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010p\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u000b2\u0006\u0010o\u001a\u00020M2\u0014\u0010t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070u2\u0014\u0010B\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070uH\u0002¢\u0006\u0002\u0010vJ\u001e\u0010w\u001a\u00028\u00002\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010,\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010xJE\u0010y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00107\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010z\u001a\u00028\u00002\u0006\u0010{\u001a\u00020MH\u0002¢\u0006\u0002\u0010NJ\u000f\u0010|\u001a\b\u0012\u0004\u0012\u00028\u00000}H\u0096\u0002J\u000e\u0010~\u001a\b\u0012\u0004\u0012\u00028\u00000\u007fH\u0016J\u0016\u0010~\u001a\b\u0012\u0004\u0012\u00028\u00000\u007f2\u0006\u0010G\u001a\u00020\u000bH\u0016J \u0010\u0080\u0001\u001a\u0011\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0081\u00012\u0006\u0010G\u001a\u00020\u000bH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007@BX\u0080\u000e¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0017\u0010\u0018R0\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007@BX\u0080\u000e¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u001a\u0010\u0018R\u001e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010¨\u0006\u0082\u0001"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "vector", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "vectorRoot", "", "", "vectorTail", "rootShift", "", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;[Ljava/lang/Object;[Ljava/lang/Object;I)V", "[Ljava/lang/Object;", "getRootShift$runtime", "()I", "setRootShift$runtime", "(I)V", "ownership", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "value", RootDescription.ROOT_ELEMENT, "getRoot$runtime", "()[Ljava/lang/Object;", "tail", "getTail$runtime", "size", "getSize", "getModCount", "getModCount$runtime", "build", "rootSize", "tailSize", "isMutable", "", "buffer", "([Ljava/lang/Object;)Z", "makeMutable", "([Ljava/lang/Object;)[Ljava/lang/Object;", "makeMutableShiftingRight", "distance", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "mutableBufferWith", "element", "(Ljava/lang/Object;)[Ljava/lang/Object;", "mutableBuffer", "add", "(Ljava/lang/Object;)Z", "pushFilledTail", "", "filledTail", "newTail", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)V", "pushTail", "shift", "([Ljava/lang/Object;[Ljava/lang/Object;I)[Ljava/lang/Object;", "addAll", SlcElement.KEY_ELEMENTS, "", "copyToBuffer", "bufferIndex", "sourceIterator", "", "([Ljava/lang/Object;ILjava/util/Iterator;)[Ljava/lang/Object;", "pushBuffersIncreasingHeightIfNeeded", "buffers", "([Ljava/lang/Object;I[[Ljava/lang/Object;)[Ljava/lang/Object;", "pushBuffers", "buffersIterator", "([Ljava/lang/Object;IILjava/util/Iterator;)[Ljava/lang/Object;", "index", "(ILjava/lang/Object;)V", "insertIntoTail", "([Ljava/lang/Object;ILjava/lang/Object;)V", "insertIntoRoot", "elementCarry", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;", "([Ljava/lang/Object;IILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "rightShift", "nullBuffers", "nextBuffer", "(Ljava/util/Collection;II[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "shiftLeafBuffers", "startLeafIndex", "(II[[Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "splitToBuffers", "startBuffer", "startBufferSize", "(Ljava/util/Collection;I[Ljava/lang/Object;I[[Ljava/lang/Object;I[Ljava/lang/Object;)V", MonitorConstants.CONNECT_TYPE_GET, "(I)Ljava/lang/Object;", "bufferFor", "(I)[Ljava/lang/Object;", "removeAt", "removeFromTailAt", "([Ljava/lang/Object;III)Ljava/lang/Object;", "removeFromRootAt", "tailCarry", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "pullLastBufferFromRoot", "([Ljava/lang/Object;II)V", "pullLastBuffer", "removeAll", "removeAllWithPredicate", "predicate", "Lkotlin/Function1;", "retainFirst", "nullifyAfter", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "removeAllFromTail", "bufferRef", "bufferSize", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)I", "recyclableRemoveAll", "toBufferSize", "recyclableBuffers", "", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;Ljava/util/List;Ljava/util/List;)I", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "setInRoot", "e", "oldElementCarry", "iterator", "", "listIterator", "", "leafBufferIterator", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersistentVectorBuilder<E> extends AbstractMutableList<E> implements PersistentList.Builder<E> {
    public static final int $stable = 8;
    private MutabilityOwnership ownership;
    private Object[] root;
    private int rootShift;
    private int size;
    private Object[] tail;
    private PersistentList<? extends E> vector;
    private Object[] vectorRoot;
    private Object[] vectorTail;

    public static /* synthetic */ boolean a(Collection r100, Object r101) {
        return removeAll$lambda$5(r100, r101);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    private final Object[] mutableBuffer() {
        Object[] r100 = new Object[33];
        r100[32] = this.ownership;
        return r100;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder
    public PersistentList<E> build() {
        if (this.root == this.vectorRoot) goto L5;
    L7:
        this.ownership = new MutabilityOwnership();
        Object[] r100 = this.root;
        this.vectorRoot = r100;
        Object[] r101 = this.tail;
        this.vectorTail = r101;
        if (r100 == null) goto L10;
        Object[] r102 = this.root;
        Intrinsics.checkNotNull(r102);
        PersistentVector r103 = new PersistentVector(r102, this.tail, size(), this.rootShift);
    L17:
        this.vector = r103;
        return (PersistentList<E>) r103;
    L10:
        if (r101.length != 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        r103 = UtilsKt.persistentVectorOf();
        goto L17
    L15:
        r103 = new SmallPersistentVector(Arrays.copyOf(this.tail, size()));
        goto L17
    L12:
        r104 = false;
        goto L13
    L5:
        if (this.tail != this.vectorTail) goto L7;
        r103 = this.vector;
        goto L17
    }

    private final int rootSize() {
        if (size() > 32) goto L7;
        return 0;
    L7:
        return UtilsKt.rootSize(size());
    }

    private final int tailSize() {
        return tailSize(size());
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator();
    }

    public final int getModCount$runtime() {
        return ((AbstractList) this).modCount;
    }

    public final Object[] getRoot$runtime() {
        return this.root;
    }

    public final int getRootShift$runtime() {
        return this.rootShift;
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    public final Object[] getTail$runtime() {
        return this.tail;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder
    public /* bridge */ /* synthetic */ PersistentCollection build() {
        return build();
    }

    private final Object[] bufferFor(int r100) {
        if (rootSize() <= r100) goto L5;
        Object[] r101 = this.root;
        Intrinsics.checkNotNull(r101);
        int r102 = this.rootShift;
    L7:
        if (r102 <= 0) goto L9;
        Object[] r103 = r101[UtilsKt.indexSegment(r100, r102)];
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r101 = r103;
        r102 = r102 - 5;
        goto L7
    L9:
        return r101;
    L5:
        return this.tail;
    }

    private final boolean isMutable(Object[] r100) {
        if (r100.length == 33) goto L5;
    L7:
        return false;
    L5:
        if (r100[32] != this.ownership) goto L7;
        return true;
    }

    private final ListIterator<Object[]> leafBufferIterator(int r100) {
        Object[] r101 = this.root;
        if (r101 == null) goto L11;
        int r102 = rootSize() >> 5;
        ListImplementation.checkPositionIndex$runtime(r100, r102);
        int r103 = this.rootShift;
        if (r103 != 0) goto L9;
        return new SingleElementListIterator(r101, r100);
    L9:
        return new TrieIterator(r101, r100, r102, r103 / 5);
    L11:
        throw new IllegalStateException("Invalid root".toString());
    }

    private final Object[] makeMutable(Object[] r100) {
        if (r100 != null) goto L6;
        return mutableBuffer();
    L6:
        if (isMutable(r100) == false) goto L9;
        return r100;
    L9:
        return ArraysKt.copyInto$default(r100, mutableBuffer(), 0, 0, RangesKt.coerceAtMost(r100.length, 32), 6, null);
    }

    private final Object[] mutableBufferWith(Object r100) {
        Object[] r101 = new Object[33];
        r101[0] = r100;
        r101[32] = this.ownership;
        return r101;
    }

    private final boolean removeAll(Function1<? super E, Boolean> r110) {
        int r111 = tailSize();
        ObjectRef r112 = new ObjectRef(null);
        if (this.root == null) goto L5;
        ListIterator<Object[]> r113 = leafBufferIterator(0);
        int r100 = 32;
    L9:
        if (r100 != 32) goto L13;
        if (r113.hasNext() == false) goto L13;
        r100 = removeAll(r110, r113.next(), 32, r112);
    L13:
        if (r100 != 32) goto L20;
        CommonFunctionsKt.m4281assert(!r113.hasNext());
        int r101 = removeAllFromTail(r110, r111, r112);
        if (r101 != 0) goto L17;
        pullLastBufferFromRoot(this.root, size(), this.rootShift);
    L17:
        if (r101 == r111) goto L34;
        return true;
    L34:
        return false;
    L20:
        int r102 = r113.previousIndex() << 5;
        ArrayList r114 = new ArrayList();
        ArrayList r115 = new ArrayList();
        int r103 = r100;
    L22:
        if (r113.hasNext() == false) goto L24;
        r103 = recyclableRemoveAll(r110, r113.next(), 32, r103, r112, r115, r114);
        r102 = r102;
        goto L22
    L24:
        int r116 = r102;
        int r104 = recyclableRemoveAll(r110, this.tail, r111, r103, r112, r115, r114);
        Object r105 = r112.getValue();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] r106 = (Object[]) r105;
        ArraysKt.fill(r106, null, r104, 32);
        if (r114.isEmpty() == false) goto L27;
        Object[] r107 = this.root;
        Intrinsics.checkNotNull(r107);
    L28:
        int r108 = r116 + (r114.size() << 5);
        this.root = retainFirst(r107, r108);
        this.tail = r106;
        this.size = r108 + r104;
        return true;
    L27:
        r107 = pushBuffers(this.root, r116, this.rootShift, r114.iterator());
        goto L28
    L5:
        if (removeAllFromTail(r110, r111, r112) == r111) goto L33;
        return true;
    L33:
        return false;
    }

    private final int tailSize(int r100) {
        if (r100 > 32) goto L6;
        return r100;
    L6:
        return r100 - UtilsKt.rootSize(r100);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r100) {
        ((AbstractList) this).modCount++;
        int r101 = tailSize();
        if (r101 >= 32) goto L5;
        Object[] r102 = makeMutable(this.tail);
        r102[r101] = r100;
        this.tail = r102;
        this.size = size() + 1;
    L6:
        return true;
    L5:
        pushFilledTail(this.root, this.tail, mutableBufferWith(r100));
        goto L6
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r100) {
        if (r100.isEmpty() == false) goto L5;
        return false;
    L5:
        ((AbstractList) this).modCount++;
        int r101 = tailSize();
        Iterator<? extends E> r102 = r100.iterator();
        if ((32 - r101) < r100.size()) goto L8;
        this.tail = copyToBuffer(makeMutable(this.tail), r101, r102);
        this.size = size() + r100.size();
    L12:
        return true;
    L8:
        int r103 = ((r100.size() + r101) - 1) / 32;
        Object[][] r104 = new Object[r103][];
        r104[0] = copyToBuffer(makeMutable(this.tail), r101, r102);
        int r105 = 1;
    L9:
        if (r105 >= r103) goto L11;
        r104[r105] = copyToBuffer(mutableBuffer(), 0, r102);
        r105 = r105 + 1;
        goto L9
    L11:
        this.root = pushBuffersIncreasingHeightIfNeeded(this.root, rootSize(), r104);
        this.tail = copyToBuffer(mutableBuffer(), 0, r102);
        this.size = size() + r100.size();
        goto L12
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r100) {
        ListImplementation.checkElementIndex$runtime(r100, size());
        return (E) bufferFor(r100)[r100 & 31];
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int r100) {
        ListImplementation.checkPositionIndex$runtime(r100, size());
        return new PersistentVectorMutableIterator(this, r100);
    }

    public final boolean removeAllWithPredicate(Function1<? super E, Boolean> r100) {
        boolean r101 = removeAll(r100);
        if (r101 == false) goto L5;
        ((AbstractList) this).modCount++;
    L5:
        return r101;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int r100) {
        ListImplementation.checkElementIndex$runtime(r100, size());
        ((AbstractList) this).modCount++;
        int r101 = rootSize();
        if (r100 >= r101) goto L5;
        ObjectRef r102 = new ObjectRef(this.tail[0]);
        Object[] r103 = this.root;
        Intrinsics.checkNotNull(r103);
        removeFromTailAt(removeFromRootAt(r103, this.rootShift, r100, r102), r101, this.rootShift, 0);
        return (E) r102.getValue();
    L5:
        return (E) removeFromTailAt(this.root, r101, this.rootShift, r100 - r101);
    }

    public final void setRootShift$runtime(int r100) {
        this.rootShift = r100;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(final Collection<?> r100) {
        return removeAllWithPredicate(new c(r100));
    }

    private final Object[] makeMutableShiftingRight(Object[] r100, int r101) {
        if (isMutable(r100) == false) goto L7;
        return ArraysKt.copyInto(r100, r100, r101, 0, 32 - r101);
    L7:
        return ArraysKt.copyInto(r100, mutableBuffer(), r101, 0, 32 - r101);
    }

    private static final boolean removeAll$lambda$5(Collection r100, Object r101) {
        return r100.contains(r101);
    }

    private final Object[] retainFirst(Object[] r100, int r101) {
        if ((r101 & 31) != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        PreconditionsKt.throwIllegalArgumentException("invalid size");
    L8:
        if (r101 != 0) goto L11;
        this.rootShift = 0;
        return null;
    L11:
        int r103 = r101 - 1;
    L12:
        int r104 = this.rootShift;
        if ((r103 >> r104) != 0) goto L16;
        this.rootShift = r104 - 5;
        Object[] r105 = r100[0];
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r100 = r105;
        goto L12
    L16:
        return nullifyAfter(r100, r103, r104);
    L5:
        r102 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int r100, E r110) {
        ListImplementation.checkPositionIndex$runtime(r100, size());
        if (r100 != size()) goto L6;
        add(r110);
        return;
    L6:
        ((AbstractList) this).modCount++;
        int r101 = rootSize();
        if (r100 < r101) goto L10;
        insertIntoTail(this.root, r100 - r101, r110);
        return;
    L10:
        ObjectRef r102 = new ObjectRef(null);
        Object[] r103 = this.root;
        Intrinsics.checkNotNull(r103);
        insertIntoTail(insertIntoRoot(r103, this.rootShift, r100, r110, r102), 0, r102.getValue());
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r110, Collection<? extends E> r111) {
        ListImplementation.checkPositionIndex$runtime(r110, size());
        if (r110 == size()) goto L5;
        boolean r100 = false;
        if (r111.isEmpty() == false) goto L9;
        return false;
    L9:
        ((AbstractList) this).modCount++;
        int r101 = (r110 >> 5) << 5;
        int r102 = (((size() - r101) + r111.size()) - 1) / 32;
        if (r102 == 0) goto L12;
        Object[][] r112 = new Object[r102][];
        int r103 = tailSize();
        int r104 = tailSize(size() + r111.size());
        if (r110 < rootSize()) goto L19;
        Object[] r105 = mutableBuffer();
        splitToBuffers(r111, r110, this.tail, r103, r112, r102, r105);
    L22:
        this.root = pushBuffersIncreasingHeightIfNeeded(this.root, r101, r112);
        this.tail = r105;
        this.size = size() + r111.size();
        return true;
    L19:
        if (r104 <= r103) goto L21;
        int r106 = r104 - r103;
        r105 = makeMutableShiftingRight(this.tail, r106);
        insertIntoRoot(r111, r110, r106, r112, r102, r105);
        goto L22
    L21:
        int r107 = r103 - r104;
        r105 = ArraysKt.copyInto(this.tail, mutableBuffer(), 0, r107, r103);
        int r108 = 32 - r107;
        Object[] r109 = makeMutableShiftingRight(this.tail, r108);
        int r113 = r102 - 1;
        r112[r113] = r109;
        insertIntoRoot(r111, r110, r108, r112, r113, r109);
        goto L22
    L12:
        if (r110 < rootSize()) goto L14;
        r100 = true;
    L14:
        CommonFunctionsKt.m4281assert(r100);
        int r114 = r110 & 31;
        int r115 = ((r110 + r111.size()) - 1) & 31;
        Object[] r116 = this.tail;
        Object[] r117 = ArraysKt.copyInto(r116, makeMutable(r116), r115 + 1, r114, tailSize());
        copyToBuffer(r117, r114, r111.iterator());
        this.tail = r117;
        this.size = size() + r111.size();
        return true;
    L5:
        return addAll(r111);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int r100, E r110) {
        ListImplementation.checkElementIndex$runtime(r100, size());
        if (rootSize() > r100) goto L9;
        Object[] r101 = makeMutable(this.tail);
        if (r101 == this.tail) goto L7;
        ((AbstractList) this).modCount++;
    L7:
        int r102 = r100 & 31;
        E r103 = (E) r101[r102];
        r101[r102] = r110;
        this.tail = r101;
        return r103;
    L9:
        ObjectRef r104 = new ObjectRef(null);
        Object[] r105 = this.root;
        Intrinsics.checkNotNull(r105);
        this.root = setInRoot(r105, this.rootShift, r100, r110, r104);
        return (E) r104.getValue();
    }

    private final Object[] copyToBuffer(Object[] r100, int r101, Iterator<? extends Object> r102) {
    L3:
        if (r101 >= 32) goto L7;
        if (r102.hasNext() == false) goto L7;
        r100[r101] = r102.next();
        r101 = r101 + 1;
    L7:
        return r100;
    }

    private final void insertIntoTail(Object[] r100, int r101, E r102) {
        int r103 = tailSize();
        Object[] r104 = makeMutable(this.tail);
        if (r103 >= 32) goto L5;
        ArraysKt.copyInto(this.tail, r104, r101 + 1, r101, r103);
        r104[r101] = r102;
        this.root = r100;
        this.tail = r104;
        this.size = size() + 1;
        return;
    L5:
        Object[] r105 = this.tail;
        Object r106 = r105[31];
        ArraysKt.copyInto(r105, r104, r101 + 1, r101, 31);
        r104[r101] = r102;
        pushFilledTail(r100, r104, mutableBufferWith(r106));
    }

    private final Object[] nullifyAfter(Object[] r100, int r101, int r102) {
        if (r102 < 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
        PreconditionsKt.throwIllegalArgumentException("shift should be positive");
    L8:
        if (r102 != 0) goto L10;
        return r100;
    L10:
        int r104 = UtilsKt.indexSegment(r101, r102);
        Object r105 = r100[r104];
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object r106 = nullifyAfter((Object[]) r105, r101, r102 - 5);
        if (r104 >= 31) goto L19;
        int r107 = r104 + 1;
        if (r100[r107] == null) goto L19;
        if (isMutable(r100) == false) goto L17;
        ArraysKt.fill(r100, null, r107, 32);
    L17:
        r100 = ArraysKt.copyInto(r100, mutableBuffer(), 0, 0, r107);
    L19:
        if (r106 == r100[r104]) goto L22;
        Object[] r108 = makeMutable(r100);
        r108[r104] = r106;
        return r108;
    L22:
        return r100;
    L5:
        r103 = false;
        goto L6
    }

    private final void pullLastBufferFromRoot(Object[] r100, int r101, int r102) {
        if (r102 != 0) goto L9;
        this.root = null;
        if (r100 != null) goto L7;
        r100 = new Object[0];
    L7:
        this.tail = r100;
        this.size = r101;
        this.rootShift = r102;
        return;
    L9:
        ObjectRef r103 = new ObjectRef(null);
        Intrinsics.checkNotNull(r100);
        Object[] r104 = pullLastBuffer(r100, r102, r101, r103);
        Intrinsics.checkNotNull(r104);
        Object r105 = r103.getValue();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        this.tail = (Object[]) r105;
        this.size = r101;
        if (r104[1] != null) goto L12;
        this.root = (Object[]) r104[0];
        this.rootShift = r102 - 5;
        return;
    L12:
        this.root = r104;
        this.rootShift = r102;
    }

    private final Object[] pushBuffersIncreasingHeightIfNeeded(Object[] r100, int r101, Object[][] r102) {
        Iterator<Object[]> r103 = ArrayIteratorKt.iterator(r102);
        int r104 = r101 >> 5;
        int r105 = this.rootShift;
        if (r104 >= (1 << r105)) goto L5;
        Object[] r106 = pushBuffers(r100, r101, r105, r103);
    L7:
        if (r103.hasNext() == false) goto L9;
        this.rootShift += 5;
        r106 = mutableBufferWith(r106);
        int r107 = this.rootShift;
        pushBuffers(r106, 1 << r107, r107, r103);
        goto L7
    L9:
        return r106;
    L5:
        r106 = makeMutable(r100);
        goto L7
    }

    private final void pushFilledTail(Object[] r100, Object[] r101, Object[] r102) {
        int r103 = size() >> 5;
        int r104 = this.rootShift;
        if (r103 <= (1 << r104)) goto L5;
        this.root = pushTail(mutableBufferWith(r100), r101, this.rootShift + 5);
        this.tail = r102;
        this.rootShift += 5;
        this.size = size() + 1;
        return;
    L5:
        if (r100 != null) goto L7;
        this.root = r101;
        this.tail = r102;
        this.size = size() + 1;
        return;
    L7:
        this.root = pushTail(r100, r101, r104);
        this.tail = r102;
        this.size = size() + 1;
    }

    private final Object[] pushTail(Object[] r100, Object[] r101, int r102) {
        int r103 = UtilsKt.indexSegment(size() - 1, r102);
        Object[] r104 = makeMutable(r100);
        if (r102 != 5) goto L5;
        r104[r103] = r101;
    L6:
        return r104;
    L5:
        r104[r103] = pushTail((Object[]) r104[r103], r101, r102 - 5);
        goto L6
    }

    private final int removeAllFromTail(Function1<? super E, Boolean> r100, int r101, ObjectRef r102) {
        int r103 = removeAll(r100, this.tail, r101, r102);
        if (r103 == r101) goto L5;
        Object r104 = r102.getValue();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] r105 = (Object[]) r104;
        ArraysKt.fill(r105, null, r103, r101);
        this.tail = r105;
        this.size = size() - (r101 - r103);
        return r103;
    L5:
        if (r102.getValue() != this.tail) goto L7;
        boolean r106 = true;
    L8:
        CommonFunctionsKt.m4281assert(r106);
        return r101;
    L7:
        r106 = false;
        goto L8
    }

    public PersistentVectorBuilder(PersistentList<? extends E> r100, Object[] r101, Object[] r102, int r103) {
        this.vector = r100;
        this.vectorRoot = r101;
        this.vectorTail = r102;
        this.rootShift = r103;
        this.ownership = new MutabilityOwnership();
        this.root = this.vectorRoot;
        this.tail = this.vectorTail;
        this.size = this.vector.size();
    }

    private final Object[] pullLastBuffer(Object[] r100, int r101, int r102, ObjectRef r103) {
        int r104 = UtilsKt.indexSegment(r102 - 1, r101);
        if (r101 != 5) goto L5;
        r103.setValue(r100[r104]);
        Object[] r105 = null;
    L6:
        if (r105 != null) goto L9;
        if (r104 != 0) goto L9;
        return null;
    L9:
        Object[] r106 = makeMutable(r100);
        r106[r104] = r105;
        return r106;
    L5:
        Object r107 = r100[r104];
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r105 = pullLastBuffer((Object[]) r107, r101 - 5, r102, r103);
        goto L6
    }

    private final Object[] pushBuffers(Object[] r100, int r101, int r102, Iterator<Object[]> r103) {
        if (r103.hasNext() == true) goto L6;
        PreconditionsKt.throwIllegalArgumentException("invalid buffersIterator");
    L6:
        if (r102 < 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L11;
        PreconditionsKt.throwIllegalArgumentException("negative shift");
    L11:
        if (r102 == 0) goto L13;
        Object[] r105 = makeMutable(r100);
        int r106 = UtilsKt.indexSegment(r101, r102);
        int r107 = r102 - 5;
        r105[r106] = pushBuffers((Object[]) r105[r106], r101, r107, r103);
    L15:
        r106 = r106 + 1;
        if (r106 >= 32) goto L20;
        if (r103.hasNext() == false) goto L20;
        r105[r106] = pushBuffers((Object[]) r105[r106], 0, r107, r103);
    L20:
        return r105;
    L13:
        return r103.next();
    L8:
        r104 = false;
        goto L9
    }

    private final int removeAll(Function1<? super E, Boolean> r100, Object[] r101, int r102, ObjectRef r110) {
        int r103 = 0;
        Object[] r104 = r101;
        int r105 = r102;
        boolean r106 = false;
    L3:
        if (r103 >= r102) goto L11;
        Object r107 = r101[r103];
        if (r100.invoke(r107).booleanValue() == false) goto L8;
        if (r106 == true) goto L10;
        r104 = makeMutable(r101);
        r106 = true;
        r105 = r103;
    L10:
        r103 = r103 + 1;
        goto L3
    L8:
        if (r106 == false) goto L10;
        r104[r105] = r107;
        r105 = r105 + 1;
        goto L10
    L11:
        r110.setValue(r104);
        return r105;
    }

    private final Object[] removeFromRootAt(Object[] r100, int r101, int r102, ObjectRef r110) {
        int r103 = UtilsKt.indexSegment(r102, r101);
        int r104 = 31;
        if (r101 != 0) goto L7;
        Object r105 = r100[r103];
        Object[] r106 = ArraysKt.copyInto(r100, makeMutable(r100), r103, r103 + 1, 32);
        r106[31] = r110.getValue();
        r110.setValue(r105);
        return r106;
    L7:
        if (r100[31] != null) goto L9;
        r104 = UtilsKt.indexSegment(rootSize() - 1, r101);
    L9:
        Object[] r107 = makeMutable(r100);
        int r108 = r101 - 5;
        int r109 = r103 + 1;
        if (r109 > r104) goto L14;
    L11:
        Object r111 = r107[r104];
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r107[r104] = removeFromRootAt((Object[]) r111, r108, 0, r110);
        if (r104 == r109) goto L14;
        r104 = r104 - 1;
    L14:
        Object r112 = r107[r103];
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r107[r103] = removeFromRootAt((Object[]) r112, r108, r102, r110);
        return r107;
    }

    private final Object removeFromTailAt(Object[] r100, int r101, int r102, int r110) {
        int r103 = size() - r101;
        if (r110 >= r103) goto L5;
        boolean r104 = true;
    L6:
        CommonFunctionsKt.m4281assert(r104);
        if (r103 != 1) goto L9;
        Object r111 = this.tail[0];
        pullLastBufferFromRoot(r100, r101, r102);
        return r111;
    L9:
        Object[] r105 = this.tail;
        Object r106 = r105[r110];
        Object[] r112 = ArraysKt.copyInto(r105, makeMutable(r105), r110, r110 + 1, r103);
        r112[r103 - 1] = null;
        this.root = r100;
        this.tail = r112;
        this.size = (r101 + r103) - 1;
        this.rootShift = r102;
        return r106;
    L5:
        r104 = false;
        goto L6
    }

    private final Object[] insertIntoRoot(Object[] r100, int r110, int r111, Object r112, ObjectRef r113) {
        int r101 = UtilsKt.indexSegment(r111, r110);
        if (r110 != 0) goto L6;
        r113.setValue(r100[31]);
        Object[] r102 = ArraysKt.copyInto(r100, makeMutable(r100), r101 + 1, r101, 31);
        r102[r101] = r112;
        return r102;
    L6:
        Object[] r103 = makeMutable(r100);
        int r114 = r110 - 5;
        Object r104 = r103[r101];
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r103[r101] = insertIntoRoot((Object[]) r104, r114, r111, r112, r113);
    L7:
        r101 = r101 + 1;
        if (r101 >= 32) goto L12;
        Object r115 = r103[r101];
        if (r115 == null) goto L12;
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r103[r101] = insertIntoRoot((Object[]) r115, r114, 0, r113.getValue(), r113);
    L12:
        return r103;
    }

    private final Object[] setInRoot(Object[] r110, int r111, int r112, E r113, ObjectRef r114) {
        int r100 = UtilsKt.indexSegment(r112, r111);
        Object[] r101 = makeMutable(r110);
        if (r111 != 0) goto L8;
        if (r101 == r110) goto L6;
        ((AbstractList) this).modCount++;
    L6:
        r114.setValue(r101[r100]);
        r101[r100] = r113;
        return r101;
    L8:
        Object r115 = r101[r100];
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r101[r100] = setInRoot((Object[]) r115, r111 - 5, r112, r113, r114);
        return r101;
    }

    private final Object[] shiftLeafBuffers(int r100, int r101, Object[][] r102, int r103, Object[] r110) {
        if (this.root == null) goto L11;
        ListIterator<Object[]> r104 = leafBufferIterator(rootSize() >> 5);
    L6:
        if (r104.previousIndex() == r100) goto L9;
        Object[] r105 = r104.previous();
        ArraysKt.copyInto(r105, r110, 0, 32 - r101, 32);
        r110 = makeMutableShiftingRight(r105, r101);
        r103 = r103 - 1;
        r102[r103] = r110;
        goto L6
    L9:
        return r104.previous();
    L11:
        throw new IllegalStateException("root is null".toString());
    }

    private final void insertIntoRoot(Collection<? extends E> r110, int r111, int r112, Object[][] r113, int r114, Object[] r115) {
        if (this.root == null) goto L10;
        int r100 = r111 >> 5;
        Object[] r101 = shiftLeafBuffers(r100, r112, r113, r114, r115);
        int r102 = r114 - (((rootSize() >> 5) - 1) - r100);
        if (r102 >= r114) goto L7;
        r115 = r113[r102];
        Intrinsics.checkNotNull(r115);
    L7:
        splitToBuffers(r110, r111, r101, 32, r113, r102, r115);
        return;
    L10:
        throw new IllegalStateException("root is null".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int recyclableRemoveAll(Function1<? super E, Boolean> r100, Object[] r101, int r102, int r110, ObjectRef r111, List<Object[]> r112, List<Object[]> r113) {
        if (isMutable(r101) == false) goto L5;
        r112.add(r101);
    L5:
        Object r103 = r111.getValue();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] r104 = (Object[]) r103;
        Object[] r105 = r104;
        int r106 = 0;
    L6:
        if (r106 >= r102) goto L18;
        Object r107 = r101[r106];
        if (r100.invoke(r107).booleanValue() == true) goto L17;
        if (r110 == 32) goto L12;
    L16:
        r105[r110] = r107;
        r110 = r110 + 1;
        goto L17
    L12:
        if ((!r112.isEmpty()) == false) goto L14;
        Object[] r114 = (Object[]) ListProtector.remove(r112, r112.size() - 1);
    L15:
        r105 = r114;
        r110 = 0;
        goto L16
    L14:
        r114 = mutableBuffer();
    L17:
        r106 = r106 + 1;
        goto L6
    L18:
        r111.setValue(r105);
        if (r104 == r111.getValue()) goto L21;
        r113.add(r104);
    L21:
        return r110;
    }

    private final void splitToBuffers(Collection<? extends E> r100, int r101, Object[] r102, int r103, Object[][] r110, int r111, Object[] r112) {
        int r104 = 1;
        if (r111 < 1) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == true) goto L8;
        PreconditionsKt.throwIllegalArgumentException("requires at least one nullBuffer");
    L8:
        Object[] r106 = makeMutable(r102);
        r110[0] = r106;
        int r107 = r101 & 31;
        int r108 = ((r101 + r100.size()) - 1) & 31;
        int r109 = (r103 - r107) + r108;
        if (r109 >= 32) goto L11;
        ArraysKt.copyInto(r106, r112, r108 + 1, r107, r103);
    L16:
        Iterator<? extends E> r113 = r100.iterator();
        copyToBuffer(r106, r107, r113);
    L17:
        if (r104 >= r111) goto L19;
        r110[r104] = copyToBuffer(mutableBuffer(), 0, r113);
        r104 = r104 + 1;
        goto L17
    L19:
        copyToBuffer(r112, 0, r113);
        return;
    L11:
        int r114 = (r109 - 32) + 1;
        if (r111 != 1) goto L14;
        Object[] r115 = r106;
    L15:
        int r116 = r103 - r114;
        ArraysKt.copyInto(r106, r112, 0, r116, r103);
        ArraysKt.copyInto(r106, r115, r108 + 1, r107, r116);
        r112 = r115;
        goto L16
    L14:
        r115 = mutableBuffer();
        r111 = r111 - 1;
        r110[r111] = r115;
        goto L15
    L5:
        r105 = false;
        goto L6
    }
}
