package androidx.compose.runtime;

import C7.r;
import D7.A;
import S7.n;
import S7.o;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectList;
import androidx.collection.ObjectListKt;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.internal.SnapshotThreadLocal;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.internal.Utils_androidKt;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.snapshots.TransparentObserverMutableSnapshot;
import androidx.compose.runtime.snapshots.TransparentObserverSnapshot;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.compose.runtime.tooling.CompositionObserverKt;
import androidx.compose.runtime.tooling.CompositionRegistrationObserver;
import androidx.compose.runtime.tooling.ObservableComposition;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.PointerIconCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.C1718k;
import m9.InterfaceC1717j;
import m9.InterfaceC1725r;
import m9.InterfaceC1733z;
import m9.b0;
import m9.c0;
import m9.d0;
import p9.t;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000ö\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 \u0084\u00022\u00020\u0001:\n\u0085\u0002\u0086\u0002\u0087\u0002\u0088\u0002\u0084\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0002H\u0087@¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u0018\u0010\u000bJ*\u0010 \u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b\u001cH\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ8\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020!2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b\u001cH\u0010¢\u0006\u0004\b%\u0010&J3\u0010+\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020!2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020$0#H\u0010¢\u0006\u0004\b)\u0010*J\u0017\u0010/\u001a\u00020\t2\u0006\u0010,\u001a\u00020$H\u0010¢\u0006\u0004\b-\u0010.J\u0010\u00100\u001a\u00020\tH\u0086@¢\u0006\u0004\b0\u0010\u000bJ\r\u00101\u001a\u00020\t¢\u0006\u0004\b1\u0010\u0016J\r\u00102\u001a\u00020\t¢\u0006\u0004\b2\u0010\u0016J\u001d\u00108\u001a\u00020\t2\f\u00105\u001a\b\u0012\u0004\u0012\u00020403H\u0010¢\u0006\u0004\b6\u00107J\u0017\u0010;\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0010¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0010¢\u0006\u0004\b<\u0010:J\u0017\u0010?\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0010¢\u0006\u0004\b>\u0010:J\u0017\u0010A\u001a\u00020\t2\u0006\u0010,\u001a\u00020$H\u0010¢\u0006\u0004\b@\u0010.J\u0017\u0010F\u001a\u00020\t2\u0006\u0010C\u001a\u00020BH\u0010¢\u0006\u0004\bD\u0010EJ\u0017\u0010H\u001a\u00020\t2\u0006\u0010C\u001a\u00020BH\u0010¢\u0006\u0004\bG\u0010EJ+\u0010O\u001a\u00020\t2\u0006\u0010C\u001a\u00020B2\u0006\u0010J\u001a\u00020I2\n\u0010L\u001a\u0006\u0012\u0002\b\u00030KH\u0010¢\u0006\u0004\bM\u0010NJ\u0017\u0010Q\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0010¢\u0006\u0004\bP\u0010:J\u0019\u0010T\u001a\u0004\u0018\u00010I2\u0006\u0010C\u001a\u00020BH\u0010¢\u0006\u0004\bR\u0010SJ\u0017\u0010V\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010UH\u0002¢\u0006\u0004\bV\u0010WJ\u000f\u0010Y\u001a\u00020XH\u0002¢\u0006\u0004\bY\u0010ZJ$\u0010Y\u001a\u00020\t2\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\t0[H\u0082\b¢\u0006\u0004\bY\u0010]J\u0017\u0010`\u001a\u00020\t2\u0006\u0010_\u001a\u00020^H\u0002¢\u0006\u0004\b`\u0010aJ-\u0010f\u001a\u00020\t2\u0006\u0010c\u001a\u00020b2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010e\u001a\u00020XH\u0002¢\u0006\u0004\bf\u0010gJ\u001e\u0010i\u001a\u00020\t2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\t0\u001bH\u0082\b¢\u0006\u0004\bi\u0010jJ\u0015\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00190kH\u0002¢\u0006\u0004\bl\u0010mJ\u0015\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00190kH\u0002¢\u0006\u0004\bn\u0010mJ\u000f\u0010o\u001a\u00020\tH\u0002¢\u0006\u0004\bo\u0010\u0016J\u0017\u0010p\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\bp\u0010:J\u0017\u0010q\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\bq\u0010:J\u0017\u0010r\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\br\u0010:J\u0017\u0010s\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\bs\u0010:J\u0011\u0010u\u001a\u0004\u0018\u00010tH\u0002¢\u0006\u0004\bu\u0010vJ\u000f\u0010w\u001a\u00020\tH\u0002¢\u0006\u0004\bw\u0010\u0016J\u0017\u0010x\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\bx\u0010:J \u0010}\u001a\u00020\t2\u0006\u0010z\u001a\u00020y2\u0006\u0010|\u001a\u00020{H\u0082@¢\u0006\u0004\b}\u0010~J\u0010\u0010\u007f\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u007f\u0010\u000bJA\u0010\u0084\u0001\u001a\u00020\t2,\u0010h\u001a(\b\u0001\u0012\u0005\u0012\u00030\u0081\u0001\u0012\u0004\u0012\u00020y\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\t0\u0082\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0083\u00010\u0080\u0001H\u0082@¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0019\u0010\u0086\u0001\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0005\b\u0086\u0001\u0010:J/\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u0088\u0001\u001a\f\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u00010\u0087\u0001H\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J:\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190k2\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020B0k2\u0011\u0010\u0088\u0001\u001a\f\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u00010\u0087\u0001H\u0002¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u0011\u0010\u008e\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u008e\u0001\u0010\u0016J'\u0010\u008f\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0083\u0001\u0012\u0004\u0012\u00020\t0[2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J:\u0010\u0091\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0083\u0001\u0012\u0004\u0012\u00020\t0[2\u0006\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u0088\u0001\u001a\f\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u00010\u0087\u0001H\u0002¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001JC\u0010\u0094\u0001\u001a\u00028\u0000\"\u0005\b\u0000\u0010\u0093\u00012\u0006\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u0088\u0001\u001a\f\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u00010\u0087\u00012\f\u0010h\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0082\b¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u001c\u0010\u0098\u0001\u001a\u00020\t2\b\u0010\u0097\u0001\u001a\u00030\u0096\u0001H\u0002¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001R,\u0010\u009c\u0001\u001a\u00030\u009a\u00012\b\u0010\u009b\u0001\u001a\u00030\u009a\u00018\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0018\u0010¡\u0001\u001a\u00030 \u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u001d\u0010¤\u0001\u001a\b0\u0083\u0001j\u0003`£\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u001b\u0010¦\u0001\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u001b\u0010¨\u0001\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001e\u0010«\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190ª\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R!\u0010\u00ad\u0001\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010¬\u0001R!\u0010®\u0001\u001a\n\u0012\u0005\u0012\u00030\u0083\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001e\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190°\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u001e\u0010³\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190ª\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b³\u0001\u0010¬\u0001R\u001e\u0010´\u0001\u001a\t\u0012\u0004\u0012\u00020B0ª\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b´\u0001\u0010¬\u0001R.\u0010·\u0001\u001a\u0019\u0012\u000e\u0012\f\u0012\u0007\u0012\u0005\u0018\u00010\u0083\u00010¶\u0001\u0012\u0004\u0012\u00020B0µ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R\u0018\u0010º\u0001\u001a\u00030¹\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R$\u0010½\u0001\u001a\u000f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020I0¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¸\u0001R$\u0010¾\u0001\u001a\u000f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020B0µ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¸\u0001R\"\u0010¿\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0019\u0018\u00010ª\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010¬\u0001R!\u0010À\u0001\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R!\u0010Â\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u001a\u0010Å\u0001\u001a\u00030Ä\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u0019\u0010Ç\u0001\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u001b\u0010É\u0001\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R\u0019\u0010Ë\u0001\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010È\u0001R\u001f\u0010Î\u0001\u001a\n\u0012\u0005\u0012\u00030Í\u00010Ì\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R'\u0010Ñ\u0001\u001a\u0012\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020$\u0018\u00010\u0087\u00010Ð\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u0018\u0010Ô\u0001\u001a\u00030Ó\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u001d\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\u0003\u0010Ö\u0001\u001a\u0006\b×\u0001\u0010Ø\u0001R)\u0010Ú\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010Ù\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u000f\n\u0006\bÚ\u0001\u0010Û\u0001\u0012\u0005\bÜ\u0001\u0010\u0016R\u001c\u0010Þ\u0001\u001a\u00070Ý\u0001R\u00020\u00008\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÞ\u0001\u0010ß\u0001R\u0016\u0010\u0012\u001a\u00020\u00028PX\u0090\u0004¢\u0006\b\u001a\u0006\bà\u0001\u0010Ø\u0001R&\u0010å\u0001\u001a\n\u0012\u0005\u0012\u00030Í\u00010á\u00018FX\u0087\u0004¢\u0006\u000f\u0012\u0005\bä\u0001\u0010\u0016\u001a\u0006\bâ\u0001\u0010ã\u0001R\u001c\u0010é\u0001\u001a\n\u0012\u0005\u0012\u00030Í\u00010æ\u00018F¢\u0006\b\u001a\u0006\bç\u0001\u0010è\u0001R\u0013\u0010ë\u0001\u001a\u00020X8F¢\u0006\u0007\u001a\u0005\bê\u0001\u0010ZR\u001d\u0010î\u0001\u001a\b0\u009a\u0001j\u0003`ì\u00018PX\u0090\u0004¢\u0006\b\u001a\u0006\bí\u0001\u0010\u009f\u0001R\u0016\u0010ð\u0001\u001a\u00020X8PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bï\u0001\u0010ZR\u0016\u0010ò\u0001\u001a\u00020X8PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bñ\u0001\u0010ZR\u0016\u0010ô\u0001\u001a\u00020X8PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bó\u0001\u0010ZR\u0019\u0010\u001a\u001a\u0005\u0018\u00010õ\u00018PX\u0090\u0004¢\u0006\b\u001a\u0006\bö\u0001\u0010÷\u0001R\u0016\u0010ù\u0001\u001a\u00020X8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bø\u0001\u0010ZR\u0016\u0010û\u0001\u001a\u00020X8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bú\u0001\u0010ZR\u0016\u0010ý\u0001\u001a\u00020X8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bü\u0001\u0010ZR\u0016\u0010ÿ\u0001\u001a\u00020X8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bþ\u0001\u0010ZR\u0016\u0010\u0081\u0002\u001a\u00020X8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0080\u0002\u0010ZR\u0016\u0010\u0083\u0002\u001a\u00020X8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0082\u0002\u0010Z¨\u0006\u0089\u0002"}, d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "LH7/h;", "effectCoroutineContext", AppAgent.CONSTRUCT, "(LH7/h;)V", "Landroidx/compose/runtime/RecomposerInfo;", "asRecomposerInfo", "()Landroidx/compose/runtime/RecomposerInfo;", "LC7/r;", "runRecomposeAndApplyChanges", "(LH7/c;)Ljava/lang/Object;", "Landroidx/compose/runtime/tooling/CompositionRegistrationObserver;", "observer", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "addCompositionRegistrationObserver$runtime", "(Landroidx/compose/runtime/tooling/CompositionRegistrationObserver;)Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "addCompositionRegistrationObserver", "recomposeCoroutineContext", "runRecomposeConcurrentlyAndApplyChanges", "(LH7/h;LH7/c;)Ljava/lang/Object;", "cancel", "()V", "close", "join", "Landroidx/compose/runtime/ControlledComposition;", "composition", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "composeInitial$runtime", "(Landroidx/compose/runtime/ControlledComposition;LS7/n;)V", "composeInitial", "Landroidx/compose/runtime/ShouldPauseCallback;", "shouldPause", "Landroidx/collection/ScatterSet;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "composeInitialPaused$runtime", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;LS7/n;)Landroidx/collection/ScatterSet;", "composeInitialPaused", "invalidScopes", "recomposePaused$runtime", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;Landroidx/collection/ScatterSet;)Landroidx/collection/ScatterSet;", "recomposePaused", "scope", "reportPausedScope$runtime", "(Landroidx/compose/runtime/RecomposeScopeImpl;)V", "reportPausedScope", "awaitIdle", "pauseCompositionFrameClock", "resumeCompositionFrameClock", "", "Landroidx/compose/runtime/tooling/CompositionData;", "table", "recordInspectionTable$runtime", "(Ljava/util/Set;)V", "recordInspectionTable", "registerComposition$runtime", "(Landroidx/compose/runtime/ControlledComposition;)V", "registerComposition", "unregisterComposition$runtime", "unregisterComposition", "invalidate$runtime", "invalidate", "invalidateScope$runtime", "invalidateScope", "Landroidx/compose/runtime/MovableContentStateReference;", TypedValues.Custom.S_REFERENCE, "insertMovableContent$runtime", "(Landroidx/compose/runtime/MovableContentStateReference;)V", "insertMovableContent", "deletedMovableContent$runtime", "deletedMovableContent", "Landroidx/compose/runtime/MovableContentState;", SettingsConfig.KEY_DATA, "Landroidx/compose/runtime/Applier;", "applier", "movableContentStateReleased$runtime", "(Landroidx/compose/runtime/MovableContentStateReference;Landroidx/compose/runtime/MovableContentState;Landroidx/compose/runtime/Applier;)V", "movableContentStateReleased", "reportRemovedComposition$runtime", "reportRemovedComposition", "movableContentStateResolve$runtime", "(Landroidx/compose/runtime/MovableContentStateReference;)Landroidx/compose/runtime/MovableContentState;", "movableContentStateResolve", "Lm9/j;", "deriveStateLocked", "()Lm9/j;", "", "recordComposerModifications", "()Z", "Lkotlin/Function1;", "onEachInvalidComposition", "(LS7/k;)V", "Lm9/c0;", "callingJob", "registerRunnerJob", "(Lm9/c0;)V", "", "e", "failedInitialComposition", "recoverable", "processCompositionError", "(Ljava/lang/Throwable;Landroidx/compose/runtime/ControlledComposition;Z)V", "block", "withTransparentSnapshot", "(LS7/a;)V", "", "knownCompositions", "()Ljava/util/List;", "knownCompositionsLocked", "clearKnownCompositionsLocked", "removeKnownCompositionLocked", "addKnownCompositionLocked", "registerCompositionLocked", "unregisterCompositionLocked", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "resetErrorState", "()Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "recordFailedCompositionLocked", "Landroidx/compose/runtime/MonotonicFrameClock;", "parentFrameClock", "Landroidx/compose/runtime/ProduceFrameSignal;", "frameSignal", "runFrameLoop", "(Landroidx/compose/runtime/MonotonicFrameClock;Landroidx/compose/runtime/ProduceFrameSignal;LH7/c;)Ljava/lang/Object;", "awaitWorkAvailable", "Lkotlin/Function3;", "Lm9/z;", "LH7/c;", "", "recompositionRunner", "(LS7/o;LH7/c;)Ljava/lang/Object;", "performInitialMovableContentInserts", "Landroidx/collection/MutableScatterSet;", "modifiedValues", "performRecompose", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/collection/MutableScatterSet;)Landroidx/compose/runtime/ControlledComposition;", "references", "performInsertValues", "(Ljava/util/List;Landroidx/collection/MutableScatterSet;)Ljava/util/List;", "discardUnusedMovableContentState", "readObserverOf", "(Landroidx/compose/runtime/ControlledComposition;)LS7/k;", "writeObserverOf", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/collection/MutableScatterSet;)LS7/k;", ExifInterface.GPS_DIRECTION_TRUE, "composing", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/collection/MutableScatterSet;LS7/a;)Ljava/lang/Object;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", RequestInfo.FUNCTION_SNAPSHOT, "applyAndCheck", "(Landroidx/compose/runtime/snapshots/MutableSnapshot;)V", "", "value", "changeCount", "J", "getChangeCount", "()J", "Landroidx/compose/runtime/BroadcastFrameClock;", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "Landroidx/compose/runtime/platform/SynchronizedObject;", "stateLock", "Ljava/lang/Object;", "runnerJob", "Lm9/c0;", "closeCause", "Ljava/lang/Throwable;", "", "_knownCompositions", "Ljava/util/List;", "_knownCompositionsCache", "snapshotInvalidations", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/collection/MutableVector;", "compositionInvalidations", "Landroidx/compose/runtime/collection/MutableVector;", "compositionsAwaitingApply", "movableContentAwaitingInsert", "Landroidx/compose/runtime/collection/MultiValueMap;", "Landroidx/compose/runtime/MovableContent;", "movableContentRemoved", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/NestedContentMap;", "movableContentNestedStatesAvailable", "Landroidx/compose/runtime/NestedContentMap;", "Landroidx/collection/MutableScatterMap;", "movableContentStatesAvailable", "movableContentNestedExtractionsPending", "failedCompositions", "compositionsRemoved", "Ljava/util/Set;", "workContinuation", "Lm9/j;", "", "concurrentCompositionsOutstanding", "I", "isClosed", "Z", "errorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "frameClockPaused", "Lp9/j;", "Landroidx/compose/runtime/Recomposer$State;", "_state", "Lp9/j;", "Landroidx/compose/runtime/internal/SnapshotThreadLocal;", "pausedScopes", "Landroidx/compose/runtime/internal/SnapshotThreadLocal;", "Lm9/r;", "effectJob", "Lm9/r;", "LH7/h;", "getEffectCoroutineContext", "()LH7/h;", "Landroidx/collection/MutableObjectList;", "registrationObservers", "Landroidx/collection/MutableObjectList;", "getRegistrationObservers$annotations", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "getRecomposeCoroutineContext$runtime", "Lp9/c;", "getState", "()Lp9/c;", "getState$annotations", "state", "Lp9/t;", "getCurrentState", "()Lp9/t;", "currentState", "getHasPendingWork", "hasPendingWork", "Landroidx/compose/runtime/CompositeKeyHashCode;", "getCompositeKeyHashCode$runtime", "compositeKeyHashCode", "getCollectingCallByInformation$runtime", "collectingCallByInformation", "getCollectingParameterInformation$runtime", "collectingParameterInformation", "getCollectingSourceInformation$runtime", "collectingSourceInformation", "Landroidx/compose/runtime/Composition;", "getComposition$runtime", "()Landroidx/compose/runtime/Composition;", "getHasBroadcastFrameClockAwaitersLocked", "hasBroadcastFrameClockAwaitersLocked", "getHasBroadcastFrameClockAwaiters", "hasBroadcastFrameClockAwaiters", "getShouldKeepRecomposing", "shouldKeepRecomposing", "getHasSchedulingWork", "hasSchedulingWork", "getHasFrameWorkLocked", "hasFrameWorkLocked", "getHasConcurrentFrameWorkLocked", "hasConcurrentFrameWorkLocked", "Companion", "State", "RecomposerInfoImpl", "HotReloadable", "RecomposerErrorState", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Recomposer extends CompositionContext {
    private final List<ControlledComposition> _knownCompositions;
    private List<? extends ControlledComposition> _knownCompositionsCache;
    private final p9.j _state;
    private final BroadcastFrameClock broadcastFrameClock;
    private long changeCount;
    private Throwable closeCause;
    private final MutableVector<ControlledComposition> compositionInvalidations;
    private final List<ControlledComposition> compositionsAwaitingApply;
    private Set<ControlledComposition> compositionsRemoved;
    private int concurrentCompositionsOutstanding;
    private final H7.h effectCoroutineContext;
    private final InterfaceC1725r effectJob;
    private RecomposerErrorState errorState;
    private List<ControlledComposition> failedCompositions;
    private boolean frameClockPaused;
    private boolean isClosed;
    private final List<MovableContentStateReference> movableContentAwaitingInsert;
    private final MutableScatterMap<Object, Object> movableContentNestedExtractionsPending;
    private final NestedContentMap movableContentNestedStatesAvailable;
    private final MutableScatterMap<Object, Object> movableContentRemoved;
    private final MutableScatterMap<MovableContentStateReference, MovableContentState> movableContentStatesAvailable;
    private final SnapshotThreadLocal<MutableScatterSet<RecomposeScopeImpl>> pausedScopes;
    private final RecomposerInfoImpl recomposerInfo;
    private MutableObjectList<CompositionRegistrationObserver> registrationObservers;
    private c0 runnerJob;
    private MutableScatterSet<Object> snapshotInvalidations;
    private final Object stateLock;
    private InterfaceC1717j workContinuation;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final p9.j _runningRecomposers = p9.e.c(ExtensionsKt.persistentSetOf());
    private static final AtomicReference<Boolean> _hotReloadEnabled = new AtomicReference<>(Boolean.FALSE);

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004R\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004R\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0000¢\u0006\u0004\b#\u0010$J\u000f\u0010'\u001a\u00020\u0007H\u0000¢\u0006\u0004\b&\u0010\u0003R\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R$\u0010.\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0004R\u00020\u00050-0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R$\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u001000j\b\u0012\u0004\u0012\u00020\u0010`18\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00064"}, d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "info", "LC7/r;", "addRunning", "(Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;)V", "removeRunning", "", "Landroidx/compose/runtime/RecomposerInfo;", "currentRunningRecomposers$runtime", "()Ljava/util/Set;", "currentRunningRecomposers", "", "value", "setHotReloadEnabled$runtime", "(Z)V", "setHotReloadEnabled", "saveStateAndDisposeForHotReload$runtime", "()Ljava/lang/Object;", "saveStateAndDisposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime", "(Ljava/lang/Object;)V", "loadStateAndComposeForHotReload", "", "key", "invalidateGroupsWithKey$runtime", "(I)V", "invalidateGroupsWithKey", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime", "()Ljava/util/List;", "getCurrentErrors", "clearErrors$runtime", "clearErrors", "Lp9/t;", "getRunningRecomposers", "()Lp9/t;", "runningRecomposers", "Lp9/j;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "_runningRecomposers", "Lp9/j;", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/internal/AtomicReference;", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addRunning(RecomposerInfoImpl info) {
            PersistentSet persistentSet;
            Object objAdd;
            kotlinx.coroutines.flow.i iVar;
            do {
                persistentSet = (PersistentSet) ((kotlinx.coroutines.flow.i) Recomposer._runningRecomposers).getValue();
                objAdd = persistentSet.add((PersistentSet) info);
                if (persistentSet == objAdd) {
                    return;
                }
                iVar = (kotlinx.coroutines.flow.i) Recomposer._runningRecomposers;
                iVar.getClass();
                Object obj = q9.b.b;
                if (objAdd == null) {
                    objAdd = obj;
                }
            } while (!iVar.j(persistentSet, objAdd));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeRunning(RecomposerInfoImpl info) {
            PersistentSet persistentSet;
            Object objRemove;
            kotlinx.coroutines.flow.i iVar;
            do {
                persistentSet = (PersistentSet) ((kotlinx.coroutines.flow.i) Recomposer._runningRecomposers).getValue();
                objRemove = persistentSet.remove((PersistentSet) info);
                if (persistentSet == objRemove) {
                    return;
                }
                iVar = (kotlinx.coroutines.flow.i) Recomposer._runningRecomposers;
                iVar.getClass();
                Object obj = q9.b.b;
                if (objRemove == null) {
                    objRemove = obj;
                }
            } while (!iVar.j(persistentSet, objRemove));
        }

        public final void clearErrors$runtime() {
            Iterable iterable = (Iterable) ((kotlinx.coroutines.flow.i) Recomposer._runningRecomposers).getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                RecomposerErrorState recomposerErrorStateResetErrorState = ((RecomposerInfoImpl) it.next()).resetErrorState();
                if (recomposerErrorStateResetErrorState != null) {
                    arrayList.add(recomposerErrorStateResetErrorState);
                }
            }
        }

        public final Set<RecomposerInfo> currentRunningRecomposers$runtime() {
            return (Set) ((kotlinx.coroutines.flow.i) Recomposer._runningRecomposers).getValue();
        }

        public final List<RecomposerErrorInfo> getCurrentErrors$runtime() {
            Iterable iterable = (Iterable) ((kotlinx.coroutines.flow.i) Recomposer._runningRecomposers).getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                RecomposerErrorInfo currentError = ((RecomposerInfoImpl) it.next()).getCurrentError();
                if (currentError != null) {
                    arrayList.add(currentError);
                }
            }
            return arrayList;
        }

        public final t getRunningRecomposers() {
            return Recomposer._runningRecomposers;
        }

        public final void invalidateGroupsWithKey$runtime(int key) {
            Recomposer._hotReloadEnabled.set(Boolean.TRUE);
            for (RecomposerInfoImpl recomposerInfoImpl : (Iterable) ((kotlinx.coroutines.flow.i) Recomposer._runningRecomposers).getValue()) {
                RecomposerErrorInfo currentError = recomposerInfoImpl.getCurrentError();
                if (currentError == null || currentError.getRecoverable()) {
                    recomposerInfoImpl.resetErrorState();
                    recomposerInfoImpl.invalidateGroupsWithKey(key);
                    recomposerInfoImpl.retryFailedCompositions();
                }
            }
        }

        public final void loadStateAndComposeForHotReload$runtime(Object token) {
            Recomposer._hotReloadEnabled.set(Boolean.TRUE);
            Iterator it = ((Iterable) ((kotlinx.coroutines.flow.i) Recomposer._runningRecomposers).getValue()).iterator();
            while (it.hasNext()) {
                ((RecomposerInfoImpl) it.next()).resetErrorState();
            }
            kotlin.jvm.internal.k.d(token, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.runtime.Recomposer.HotReloadable>");
            List list = (List) token;
            List list2 = list;
            int size = list2.size();
            for (int i = 0; i < size; i++) {
                ((HotReloadable) list.get(i)).resetContent();
            }
            int size2 = list2.size();
            for (int i6 = 0; i6 < size2; i6++) {
                ((HotReloadable) list.get(i6)).recompose();
            }
            Iterator it2 = ((Iterable) ((kotlinx.coroutines.flow.i) Recomposer._runningRecomposers).getValue()).iterator();
            while (it2.hasNext()) {
                ((RecomposerInfoImpl) it2.next()).retryFailedCompositions();
            }
        }

        public final Object saveStateAndDisposeForHotReload$runtime() {
            Recomposer._hotReloadEnabled.set(Boolean.TRUE);
            Iterable iterable = (Iterable) ((kotlinx.coroutines.flow.i) Recomposer._runningRecomposers).getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                A.e0(((RecomposerInfoImpl) it.next()).saveStateAndDisposeForHotReload(), arrayList);
            }
            return arrayList;
        }

        public final void setHotReloadEnabled$runtime(boolean value) {
            Recomposer._hotReloadEnabled.set(Boolean.valueOf(value));
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR!\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "Landroidx/compose/runtime/CompositionImpl;", "composition", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/CompositionImpl;)V", "LC7/r;", "clearContent", "()V", "resetContent", "recompose", "Landroidx/compose/runtime/CompositionImpl;", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composable", "LS7/n;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class HotReloadable {
        private n composable;
        private final CompositionImpl composition;

        public HotReloadable(CompositionImpl compositionImpl) {
            this.composition = compositionImpl;
            this.composable = compositionImpl.getComposable();
        }

        public final void clearContent() {
            if (this.composition.getIsRoot()) {
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m3412getLambda$1091980426$runtime());
            }
        }

        public final void recompose() {
            if (this.composition.getIsRoot()) {
                this.composition.setContent(this.composable);
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "Landroidx/compose/runtime/RecomposerErrorInfo;", "recoverable", "", "cause", "", AppAgent.CONSTRUCT, "(ZLjava/lang/Throwable;)V", "getRecoverable", "()Z", "getCause", "()Ljava/lang/Throwable;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RecomposerErrorState implements RecomposerErrorInfo {
        private final Throwable cause;
        private final boolean recoverable;

        public RecomposerErrorState(boolean z10, Throwable th) {
            this.recoverable = z10;
            this.cause = th;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public Throwable getCause() {
            return this.cause;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public boolean getRecoverable() {
            return this.recoverable;
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0013\u0010'\u001a\u0004\u0018\u00010$8F¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/Recomposer;)V", "Landroidx/compose/runtime/tooling/CompositionRegistrationObserver;", "observer", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observe", "(Landroidx/compose/runtime/tooling/CompositionRegistrationObserver;)Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "", "key", "LC7/r;", "invalidateGroupsWithKey", "(I)V", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "saveStateAndDisposeForHotReload", "()Ljava/util/List;", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "resetErrorState", "()Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "()V", "Lp9/c;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lp9/c;", "state", "", "getHasPendingWork", "()Z", "hasPendingWork", "", "getChangeCount", "()J", "changeCount", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentError", "()Landroidx/compose/runtime/RecomposerErrorInfo;", "currentError", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class RecomposerInfoImpl implements RecomposerInfo {
        public RecomposerInfoImpl() {
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public long getChangeCount() {
            return Recomposer.this.getChangeCount();
        }

        public final RecomposerErrorInfo getCurrentError() {
            RecomposerErrorState recomposerErrorState;
            Object obj = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (obj) {
                recomposerErrorState = recomposer.errorState;
            }
            return recomposerErrorState;
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public boolean getHasPendingWork() {
            return Recomposer.this.getHasPendingWork();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public p9.c getState() {
            return Recomposer.this.getCurrentState();
        }

        public final void invalidateGroupsWithKey(int key) {
            List listKnownCompositions = Recomposer.this.knownCompositions();
            ArrayList arrayList = new ArrayList(listKnownCompositions.size());
            int size = listKnownCompositions.size();
            for (int i = 0; i < size; i++) {
                ControlledComposition controlledComposition = (ControlledComposition) listKnownCompositions.get(i);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            int size2 = arrayList.size();
            for (int i6 = 0; i6 < size2; i6++) {
                ((CompositionImpl) arrayList.get(i6)).invalidateGroupsWithKey(key);
            }
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public CompositionObserverHandle observe(CompositionRegistrationObserver observer) {
            return CompositionObserverKt.observe(Recomposer.this, observer);
        }

        public final RecomposerErrorState resetErrorState() {
            return Recomposer.this.resetErrorState();
        }

        public final void retryFailedCompositions() {
            Recomposer.this.retryFailedCompositions();
        }

        public final List<HotReloadable> saveStateAndDisposeForHotReload() {
            List listKnownCompositions = Recomposer.this.knownCompositions();
            ArrayList arrayList = new ArrayList(listKnownCompositions.size());
            int size = listKnownCompositions.size();
            for (int i = 0; i < size; i++) {
                ControlledComposition controlledComposition = (ControlledComposition) listKnownCompositions.get(i);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int i6 = 0; i6 < size2; i6++) {
                HotReloadable hotReloadable = new HotReloadable((CompositionImpl) arrayList.get(i6));
                hotReloadable.clearContent();
                arrayList2.add(hotReloadable);
            }
            return arrayList2;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class State {
        private static final /* synthetic */ K7.a $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State ShutDown = new State("ShutDown", 0);
        public static final State ShuttingDown = new State("ShuttingDown", 1);
        public static final State Inactive = new State("Inactive", 2);
        public static final State InactivePendingWork = new State("InactivePendingWork", 3);
        public static final State Idle = new State("Idle", 4);
        public static final State PendingWork = new State("PendingWork", 5);

        private static final /* synthetic */ State[] $values() {
            return new State[]{ShutDown, ShuttingDown, Inactive, InactivePendingWork, Idle, PendingWork};
        }

        static {
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = kotlin.enums.a.a(stateArr$values);
        }

        private State(String str, int i) {
        }

        public static K7.a getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    @J7.c(c = "androidx.compose.runtime.Recomposer$awaitIdle$2", f = "Recomposer.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/runtime/Recomposer$State;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.Recomposer$awaitIdle$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // S7.n
        public final Object invoke(State state, H7.c<? super Boolean> cVar) {
            return ((AnonymousClass2) create(state, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return Boolean.valueOf(((State) this.L$0).compareTo(State.Idle) > 0);
        }
    }

    @J7.c(c = "androidx.compose.runtime.Recomposer$join$2", f = "Recomposer.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/runtime/Recomposer$State;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.Recomposer$join$2, reason: invalid class name and case insensitive filesystem */
    public static final class C06892 extends SuspendLambda implements n {
        /* synthetic */ Object L$0;
        int label;

        public C06892(H7.c<? super C06892> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C06892 c06892 = new C06892(cVar);
            c06892.L$0 = obj;
            return c06892;
        }

        @Override // S7.n
        public final Object invoke(State state, H7.c<? super Boolean> cVar) {
            return ((C06892) create(state, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return Boolean.valueOf(((State) this.L$0) == State.ShutDown);
        }
    }

    @J7.c(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2", f = "Recomposer.kt", l = {1160}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2, reason: invalid class name and case insensitive filesystem */
    public static final class C06902 extends SuspendLambda implements n {
        final /* synthetic */ o $block;
        final /* synthetic */ MonotonicFrameClock $parentFrameClock;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        @J7.c(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2$2", f = "Recomposer.kt", l = {1160}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
        /* renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C01142 extends SuspendLambda implements n {
            final /* synthetic */ o $block;
            final /* synthetic */ MonotonicFrameClock $parentFrameClock;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01142(o oVar, MonotonicFrameClock monotonicFrameClock, H7.c<? super C01142> cVar) {
                super(2, cVar);
                this.$block = oVar;
                this.$parentFrameClock = monotonicFrameClock;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                C01142 c01142 = new C01142(this.$block, this.$parentFrameClock, cVar);
                c01142.L$0 = obj;
                return c01142;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    kotlin.b.b(obj);
                    InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
                    o oVar = this.$block;
                    MonotonicFrameClock monotonicFrameClock = this.$parentFrameClock;
                    this.label = 1;
                    if (oVar.invoke(interfaceC1733z, monotonicFrameClock, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C01142) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06902(o oVar, MonotonicFrameClock monotonicFrameClock, H7.c<? super C06902> cVar) {
            super(2, cVar);
            this.$block = oVar;
            this.$parentFrameClock = monotonicFrameClock;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:27:0x007c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final C7.r invokeSuspend$lambda$2(androidx.compose.runtime.Recomposer r17, java.util.Set r18, androidx.compose.runtime.snapshots.Snapshot r19) {
            /*
                r0 = r18
                java.lang.Object r1 = androidx.compose.runtime.Recomposer.access$getStateLock$p(r17)
                monitor-enter(r1)
                p9.j r2 = androidx.compose.runtime.Recomposer.access$get_state$p(r17)     // Catch: java.lang.Throwable -> L71
                kotlinx.coroutines.flow.i r2 = (kotlinx.coroutines.flow.i) r2     // Catch: java.lang.Throwable -> L71
                java.lang.Object r2 = r2.getValue()     // Catch: java.lang.Throwable -> L71
                androidx.compose.runtime.Recomposer$State r2 = (androidx.compose.runtime.Recomposer.State) r2     // Catch: java.lang.Throwable -> L71
                androidx.compose.runtime.Recomposer$State r3 = androidx.compose.runtime.Recomposer.State.Idle     // Catch: java.lang.Throwable -> L71
                int r2 = r2.compareTo(r3)     // Catch: java.lang.Throwable -> L71
                if (r2 < 0) goto Lac
                androidx.collection.MutableScatterSet r2 = androidx.compose.runtime.Recomposer.access$getSnapshotInvalidations$p(r17)     // Catch: java.lang.Throwable -> L71
                boolean r3 = r0 instanceof androidx.compose.runtime.collection.ScatterSetWrapper     // Catch: java.lang.Throwable -> L71
                r4 = 1
                if (r3 == 0) goto L81
                androidx.compose.runtime.collection.ScatterSetWrapper r0 = (androidx.compose.runtime.collection.ScatterSetWrapper) r0     // Catch: java.lang.Throwable -> L71
                androidx.collection.ScatterSet r0 = r0.getSet$runtime()     // Catch: java.lang.Throwable -> L71
                java.lang.Object[] r3 = r0.elements     // Catch: java.lang.Throwable -> L71
                long[] r0 = r0.metadata     // Catch: java.lang.Throwable -> L71
                int r5 = r0.length     // Catch: java.lang.Throwable -> L71
                int r5 = r5 + (-2)
                if (r5 < 0) goto La7
                r6 = 0
                r7 = r6
            L35:
                r8 = r0[r7]     // Catch: java.lang.Throwable -> L71
                long r10 = ~r8     // Catch: java.lang.Throwable -> L71
                r12 = 7
                long r10 = r10 << r12
                long r10 = r10 & r8
                r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r10 = r10 & r12
                int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
                if (r10 == 0) goto L7c
                int r10 = r7 - r5
                int r10 = ~r10     // Catch: java.lang.Throwable -> L71
                int r10 = r10 >>> 31
                r11 = 8
                int r10 = 8 - r10
                r12 = r6
            L4f:
                if (r12 >= r10) goto L7a
                r13 = 255(0xff, double:1.26E-321)
                long r13 = r13 & r8
                r15 = 128(0x80, double:6.3E-322)
                int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                if (r13 >= 0) goto L76
                int r13 = r7 << 3
                int r13 = r13 + r12
                r13 = r3[r13]     // Catch: java.lang.Throwable -> L71
                boolean r14 = r13 instanceof androidx.compose.runtime.snapshots.StateObjectImpl     // Catch: java.lang.Throwable -> L71
                if (r14 == 0) goto L73
                r14 = r13
                androidx.compose.runtime.snapshots.StateObjectImpl r14 = (androidx.compose.runtime.snapshots.StateObjectImpl) r14     // Catch: java.lang.Throwable -> L71
                int r15 = androidx.compose.runtime.snapshots.ReaderKind.m3598constructorimpl(r4)     // Catch: java.lang.Throwable -> L71
                boolean r14 = r14.m3610isReadInh_f27i8$runtime(r15)     // Catch: java.lang.Throwable -> L71
                if (r14 != 0) goto L73
                goto L76
            L71:
                r0 = move-exception
                goto Lb8
            L73:
                r2.add(r13)     // Catch: java.lang.Throwable -> L71
            L76:
                long r8 = r8 >> r11
                int r12 = r12 + 1
                goto L4f
            L7a:
                if (r10 != r11) goto La7
            L7c:
                if (r7 == r5) goto La7
                int r7 = r7 + 1
                goto L35
            L81:
                java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L71
                java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L71
            L87:
                boolean r3 = r0.hasNext()     // Catch: java.lang.Throwable -> L71
                if (r3 == 0) goto La7
                java.lang.Object r3 = r0.next()     // Catch: java.lang.Throwable -> L71
                boolean r5 = r3 instanceof androidx.compose.runtime.snapshots.StateObjectImpl     // Catch: java.lang.Throwable -> L71
                if (r5 == 0) goto La3
                r5 = r3
                androidx.compose.runtime.snapshots.StateObjectImpl r5 = (androidx.compose.runtime.snapshots.StateObjectImpl) r5     // Catch: java.lang.Throwable -> L71
                int r6 = androidx.compose.runtime.snapshots.ReaderKind.m3598constructorimpl(r4)     // Catch: java.lang.Throwable -> L71
                boolean r5 = r5.m3610isReadInh_f27i8$runtime(r6)     // Catch: java.lang.Throwable -> L71
                if (r5 != 0) goto La3
                goto L87
            La3:
                r2.add(r3)     // Catch: java.lang.Throwable -> L71
                goto L87
            La7:
                m9.j r0 = androidx.compose.runtime.Recomposer.access$deriveStateLocked(r17)     // Catch: java.lang.Throwable -> L71
                goto Lad
            Lac:
                r0 = 0
            Lad:
                monitor-exit(r1)
                if (r0 == 0) goto Lb5
                C7.r r1 = C7.r.f317a
                r0.resumeWith(r1)
            Lb5:
                C7.r r0 = C7.r.f317a
                return r0
            Lb8:
                monitor-exit(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C06902.invokeSuspend$lambda$2(androidx.compose.runtime.Recomposer, java.util.Set, androidx.compose.runtime.snapshots.Snapshot):C7.r");
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C06902 c06902 = Recomposer.this.new C06902(this.$block, this.$parentFrameClock, cVar);
            c06902.L$0 = obj;
            return c06902;
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 221
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C06902.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C06902) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "androidx.compose.runtime.Recomposer", f = "Recomposer.kt", l = {1030, 1037}, m = "runFrameLoop")
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.Recomposer$runFrameLoop$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Recomposer.this.runFrameLoop(null, null, this);
        }
    }

    @J7.c(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", l = {587, 598}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "Landroidx/compose/runtime/MonotonicFrameClock;", "parentFrameClock", "LC7/r;", "<anonymous>", "(Lm9/z;Landroidx/compose/runtime/MonotonicFrameClock;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2, reason: invalid class name and case insensitive filesystem */
    public static final class C06912 extends SuspendLambda implements o {
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        public C06912(H7.c<? super C06912> cVar) {
            super(3, cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0100  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static final void invokeSuspend$clearRecompositionState(androidx.compose.runtime.Recomposer r22, java.util.List<androidx.compose.runtime.ControlledComposition> r23, java.util.List<androidx.compose.runtime.MovableContentStateReference> r24, java.util.List<androidx.compose.runtime.ControlledComposition> r25, androidx.collection.MutableScatterSet<androidx.compose.runtime.ControlledComposition> r26, androidx.collection.MutableScatterSet<androidx.compose.runtime.ControlledComposition> r27, androidx.collection.MutableScatterSet<java.lang.Object> r28, androidx.collection.MutableScatterSet<androidx.compose.runtime.ControlledComposition> r29) {
            /*
                Method dump skipped, instructions count: 268
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C06912.invokeSuspend$clearRecompositionState(androidx.compose.runtime.Recomposer, java.util.List, java.util.List, java.util.List, androidx.collection.MutableScatterSet, androidx.collection.MutableScatterSet, androidx.collection.MutableScatterSet, androidx.collection.MutableScatterSet):void");
        }

        private static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer) {
            list.clear();
            synchronized (recomposer.stateLock) {
                try {
                    List list2 = recomposer.movableContentAwaitingInsert;
                    int size = list2.size();
                    for (int i = 0; i < size; i++) {
                        list.add((MovableContentStateReference) list2.get(i));
                    }
                    recomposer.movableContentAwaitingInsert.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:112:0x0206  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x017b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final C7.r invokeSuspend$lambda$22(androidx.compose.runtime.Recomposer r24, androidx.collection.MutableScatterSet r25, androidx.collection.MutableScatterSet r26, java.util.List r27, java.util.List r28, androidx.collection.MutableScatterSet r29, java.util.List r30, androidx.collection.MutableScatterSet r31, java.util.Set r32, long r33) {
            /*
                Method dump skipped, instructions count: 934
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C06912.invokeSuspend$lambda$22(androidx.compose.runtime.Recomposer, androidx.collection.MutableScatterSet, androidx.collection.MutableScatterSet, java.util.List, java.util.List, androidx.collection.MutableScatterSet, java.util.List, androidx.collection.MutableScatterSet, java.util.Set, long):C7.r");
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00dd  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x010d  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0116  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00ff -> B:24:0x0107). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x010d -> B:12:0x00aa). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instructions count: 281
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C06912.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.o
        public final Object invoke(InterfaceC1733z interfaceC1733z, MonotonicFrameClock monotonicFrameClock, H7.c<? super r> cVar) {
            C06912 c06912 = Recomposer.this.new C06912(cVar);
            c06912.L$0 = monotonicFrameClock;
            return c06912.invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2", f = "Recomposer.kt", l = {999, PointerIconCompat.TYPE_ZOOM_OUT, PointerIconCompat.TYPE_GRAB}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "Landroidx/compose/runtime/MonotonicFrameClock;", "parentFrameClock", "LC7/r;", "<anonymous>", "(Lm9/z;Landroidx/compose/runtime/MonotonicFrameClock;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2, reason: invalid class name and case insensitive filesystem */
    public static final class C06922 extends SuspendLambda implements o {
        final /* synthetic */ H7.h $recomposeCoroutineContext;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ Recomposer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06922(H7.h hVar, Recomposer recomposer, H7.c<? super C06922> cVar) {
            super(3, cVar);
            this.$recomposeCoroutineContext = hVar;
            this.this$0 = recomposer;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00b1, code lost:
        
            if (r10.awaitWorkAvailable(r17) == r1) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x0190, code lost:
        
            if (kotlinx.coroutines.a.e(r2, r17) != r1) goto L82;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0171  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00b1 -> B:25:0x00b5). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instructions count: 406
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C06922.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.o
        public final Object invoke(InterfaceC1733z interfaceC1733z, MonotonicFrameClock monotonicFrameClock, H7.c<? super r> cVar) {
            C06922 c06922 = new C06922(this.$recomposeCoroutineContext, this.this$0, cVar);
            c06922.L$0 = interfaceC1733z;
            c06922.L$1 = monotonicFrameClock;
            return c06922.invokeSuspend(r.f317a);
        }
    }

    public Recomposer(H7.h hVar) {
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new b(this, 2));
        this.broadcastFrameClock = broadcastFrameClock;
        this.stateLock = new Object();
        this._knownCompositions = new ArrayList();
        this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
        this.compositionInvalidations = new MutableVector<>(new ControlledComposition[16], 0);
        this.compositionsAwaitingApply = new ArrayList();
        this.movableContentAwaitingInsert = new ArrayList();
        this.movableContentRemoved = MultiValueMap.m3553constructorimpl$default(null, 1, null);
        this.movableContentNestedStatesAvailable = new NestedContentMap();
        this.movableContentStatesAvailable = ScatterMapKt.mutableScatterMapOf();
        this.movableContentNestedExtractionsPending = MultiValueMap.m3553constructorimpl$default(null, 1, null);
        this._state = p9.e.c(State.Inactive);
        this.pausedScopes = new SnapshotThreadLocal<>();
        d0 d0Var = new d0((c0) hVar.get(b0.f5325a));
        d0Var.w(new g(this, 5));
        this.effectJob = d0Var;
        this.effectCoroutineContext = hVar.plus(broadcastFrameClock).plus(d0Var);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    private final void addKnownCompositionLocked(ControlledComposition composition) {
        this._knownCompositions.add(composition);
        this._knownCompositionsCache = null;
        registerCompositionLocked(composition);
    }

    private final void applyAndCheck(MutableSnapshot snapshot) {
        try {
            if (snapshot.apply() instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.");
            }
        } finally {
            snapshot.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitWorkAvailable(H7.c<? super r> cVar) {
        C1718k c1718k;
        if (getHasSchedulingWork()) {
            return r.f317a;
        }
        C1718k c1718k2 = new C1718k(1, U7.a.I(cVar));
        c1718k2.y();
        synchronized (this.stateLock) {
            if (getHasSchedulingWork()) {
                c1718k = c1718k2;
            } else {
                this.workContinuation = c1718k2;
                c1718k = null;
            }
        }
        if (c1718k != null) {
            c1718k.resumeWith(r.f317a);
        }
        Object objX = c1718k2.x();
        return objX == CoroutineSingletons.f4909a ? objX : r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r broadcastFrameClock$lambda$2(Recomposer recomposer) {
        InterfaceC1717j interfaceC1717jDeriveStateLocked;
        synchronized (recomposer.stateLock) {
            interfaceC1717jDeriveStateLocked = recomposer.deriveStateLocked();
            if (((State) ((kotlinx.coroutines.flow.i) recomposer._state).getValue()).compareTo(State.ShuttingDown) <= 0) {
                Throwable th = recomposer.closeCause;
                CancellationException cancellationException = new CancellationException("Recomposer shutdown; frame clock awaiter will never resume");
                cancellationException.initCause(th);
                throw cancellationException;
            }
        }
        if (interfaceC1717jDeriveStateLocked != null) {
            interfaceC1717jDeriveStateLocked.resumeWith(r.f317a);
        }
        return r.f317a;
    }

    private final void clearKnownCompositionsLocked() {
        Iterator<T> it = knownCompositionsLocked().iterator();
        while (it.hasNext()) {
            unregisterCompositionLocked((ControlledComposition) it.next());
        }
        this._knownCompositions.clear();
        this._knownCompositionsCache = EmptyList.f4893a;
    }

    private final <T> T composing(ControlledComposition composition, MutableScatterSet<Object> modifiedValues, S7.a block) {
        MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
            try {
                return (T) block.invoke();
            } finally {
                mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
            }
        } finally {
            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
        }
    }

    private static final void deletedMovableContent$lambda$95$recordNestedStatesOf(Recomposer recomposer, MovableContentStateReference movableContentStateReference, MovableContentStateReference movableContentStateReference2) {
        List<MovableContentStateReference> nestedReferences$runtime = movableContentStateReference2.getNestedReferences$runtime();
        if (nestedReferences$runtime != null) {
            int size = nestedReferences$runtime.size();
            for (int i = 0; i < size; i++) {
                MovableContentStateReference movableContentStateReference3 = nestedReferences$runtime.get(i);
                recomposer.movableContentNestedStatesAvailable.add(movableContentStateReference3.getContent$runtime(), new NestedMovableContent(movableContentStateReference3, movableContentStateReference));
                deletedMovableContent$lambda$95$recordNestedStatesOf(recomposer, movableContentStateReference, movableContentStateReference3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC1717j deriveStateLocked() {
        State state;
        int i = 0;
        int i6 = 1;
        kotlin.jvm.internal.e eVar = null;
        if (((State) ((kotlinx.coroutines.flow.i) this._state).getValue()).compareTo(State.ShuttingDown) <= 0) {
            clearKnownCompositionsLocked();
            this.snapshotInvalidations = new MutableScatterSet<>(i, i6, eVar);
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.movableContentAwaitingInsert.clear();
            this.failedCompositions = null;
            InterfaceC1717j interfaceC1717j = this.workContinuation;
            if (interfaceC1717j != null) {
                interfaceC1717j.l(null);
            }
            this.workContinuation = null;
            this.errorState = null;
            return null;
        }
        if (this.errorState != null) {
            state = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations = new MutableScatterSet<>(i, i6, eVar);
            this.compositionInvalidations.clear();
            state = getHasBroadcastFrameClockAwaitersLocked() ? State.InactivePendingWork : State.Inactive;
        } else {
            state = (this.compositionInvalidations.getSize() == 0 && !this.snapshotInvalidations.isNotEmpty() && this.compositionsAwaitingApply.isEmpty() && this.movableContentAwaitingInsert.isEmpty() && this.concurrentCompositionsOutstanding <= 0 && !getHasBroadcastFrameClockAwaitersLocked() && !MultiValueMap.m3561isNotEmptyimpl(this.movableContentRemoved)) ? State.Idle : State.PendingWork;
        }
        ((kotlinx.coroutines.flow.i) this._state).i(state);
        if (state != State.PendingWork) {
            return null;
        }
        InterfaceC1717j interfaceC1717j2 = this.workContinuation;
        this.workContinuation = null;
        return interfaceC1717j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void discardUnusedMovableContentState() {
        int i;
        ObjectList objectListEmptyObjectList;
        synchronized (this.stateLock) {
            try {
                if (MultiValueMap.m3561isNotEmptyimpl(this.movableContentRemoved)) {
                    ObjectList objectListM3566valuesimpl = MultiValueMap.m3566valuesimpl(this.movableContentRemoved);
                    MultiValueMap.m3551clearimpl(this.movableContentRemoved);
                    this.movableContentNestedStatesAvailable.clear();
                    MultiValueMap.m3551clearimpl(this.movableContentNestedExtractionsPending);
                    MutableObjectList mutableObjectList = new MutableObjectList(objectListM3566valuesimpl.getSize());
                    Object[] objArr = objectListM3566valuesimpl.content;
                    int i6 = objectListM3566valuesimpl._size;
                    for (int i10 = 0; i10 < i6; i10++) {
                        MovableContentStateReference movableContentStateReference = (MovableContentStateReference) objArr[i10];
                        mutableObjectList.add(new Pair(movableContentStateReference, this.movableContentStatesAvailable.get(movableContentStateReference)));
                    }
                    this.movableContentStatesAvailable.clear();
                    objectListEmptyObjectList = mutableObjectList;
                } else {
                    objectListEmptyObjectList = ObjectListKt.emptyObjectList();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Object[] objArr2 = objectListEmptyObjectList.content;
        int i11 = objectListEmptyObjectList._size;
        for (i = 0; i < i11; i++) {
            Pair pair = (Pair) objArr2[i];
            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) pair.f4886a;
            MovableContentState movableContentState = (MovableContentState) pair.b;
            if (movableContentState != null) {
                movableContentStateReference2.getComposition().disposeUnusedMovableContent(movableContentState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r effectJob$lambda$10$lambda$9(Recomposer recomposer, Throwable th) {
        InterfaceC1717j interfaceC1717j;
        InterfaceC1717j interfaceC1717j2;
        CancellationException cancellationException = new CancellationException("Recomposer effect job completed");
        cancellationException.initCause(th);
        synchronized (recomposer.stateLock) {
            try {
                c0 c0Var = recomposer.runnerJob;
                interfaceC1717j = null;
                if (c0Var != null) {
                    ((kotlinx.coroutines.flow.i) recomposer._state).i(State.ShuttingDown);
                    if (recomposer.isClosed) {
                        interfaceC1717j2 = recomposer.workContinuation;
                        if (interfaceC1717j2 != null) {
                        }
                        recomposer.workContinuation = null;
                        c0Var.w(new R3.b(11, recomposer, th));
                        interfaceC1717j = interfaceC1717j2;
                    } else {
                        c0Var.cancel(cancellationException);
                    }
                    interfaceC1717j2 = null;
                    recomposer.workContinuation = null;
                    c0Var.w(new R3.b(11, recomposer, th));
                    interfaceC1717j = interfaceC1717j2;
                } else {
                    recomposer.closeCause = cancellationException;
                    ((kotlinx.coroutines.flow.i) recomposer._state).i(State.ShutDown);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (interfaceC1717j != null) {
            interfaceC1717j.resumeWith(r.f317a);
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r effectJob$lambda$10$lambda$9$lambda$8$lambda$7(Recomposer recomposer, Throwable th, Throwable th2) {
        synchronized (recomposer.stateLock) {
            if (th == null) {
                th = null;
            } else if (th2 != null) {
                try {
                    if (th2 instanceof CancellationException) {
                        th2 = null;
                    }
                    if (th2 != null) {
                        S0.b.e0(th, th2);
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            recomposer.closeCause = th;
            ((kotlinx.coroutines.flow.i) recomposer._state).i(State.ShutDown);
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasBroadcastFrameClockAwaiters() {
        boolean hasBroadcastFrameClockAwaitersLocked;
        synchronized (this.stateLock) {
            hasBroadcastFrameClockAwaitersLocked = getHasBroadcastFrameClockAwaitersLocked();
        }
        return hasBroadcastFrameClockAwaitersLocked;
    }

    private final boolean getHasBroadcastFrameClockAwaitersLocked() {
        return !this.frameClockPaused && this.broadcastFrameClock.getHasAwaiters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasConcurrentFrameWorkLocked() {
        return !this.compositionsAwaitingApply.isEmpty() || getHasBroadcastFrameClockAwaitersLocked();
    }

    private final boolean getHasFrameWorkLocked() {
        return this.compositionInvalidations.getSize() != 0 || getHasBroadcastFrameClockAwaitersLocked() || MultiValueMap.m3561isNotEmptyimpl(this.movableContentRemoved);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean getHasSchedulingWork() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.stateLock
            monitor-enter(r0)
            androidx.collection.MutableScatterSet<java.lang.Object> r1 = r2.snapshotInvalidations     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r1.isNotEmpty()     // Catch: java.lang.Throwable -> L1d
            if (r1 != 0) goto L1f
            androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.ControlledComposition> r1 = r2.compositionInvalidations     // Catch: java.lang.Throwable -> L1d
            int r1 = r1.getSize()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L14
            goto L1f
        L14:
            boolean r2 = r2.getHasBroadcastFrameClockAwaitersLocked()     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L1b
            goto L1f
        L1b:
            r2 = 0
            goto L20
        L1d:
            r2 = move-exception
            goto L22
        L1f:
            r2 = 1
        L20:
            monitor-exit(r0)
            return r2
        L22:
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.getHasSchedulingWork():boolean");
    }

    private static /* synthetic */ void getRegistrationObservers$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v7, types: [S7.n, kotlin.coroutines.jvm.internal.RestrictedSuspendLambda] */
    public final boolean getShouldKeepRecomposing() {
        boolean z10;
        synchronized (this.stateLock) {
            z10 = this.isClosed;
        }
        if (!z10) {
            return true;
        }
        i9.j jVarK = U7.a.K((RestrictedSuspendLambda) ((kotlinx.coroutines.c) this.effectJob).I().b);
        while (jVarK.hasNext()) {
            if (((c0) jVarK.next()).isActive()) {
                return true;
            }
        }
        return false;
    }

    @C7.c
    public static /* synthetic */ void getState$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ControlledComposition> knownCompositions() {
        List<ControlledComposition> listKnownCompositionsLocked;
        synchronized (this.stateLock) {
            listKnownCompositionsLocked = knownCompositionsLocked();
        }
        return listKnownCompositionsLocked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ControlledComposition> knownCompositionsLocked() {
        List list = this._knownCompositionsCache;
        if (list != null) {
            return list;
        }
        List<ControlledComposition> list2 = this._knownCompositions;
        List<ControlledComposition> arrayList = list2.isEmpty() ? EmptyList.f4893a : new ArrayList(list2);
        this._knownCompositionsCache = arrayList;
        return arrayList;
    }

    private final void performInitialMovableContentInserts(ControlledComposition composition) {
        synchronized (this.stateLock) {
            List<MovableContentStateReference> list = this.movableContentAwaitingInsert;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (kotlin.jvm.internal.k.b(list.get(i).getComposition(), composition)) {
                    ArrayList arrayList = new ArrayList();
                    performInitialMovableContentInserts$fillToInsert(arrayList, this, composition);
                    while (!arrayList.isEmpty()) {
                        performInsertValues(arrayList, null);
                        performInitialMovableContentInserts$fillToInsert(arrayList, this, composition);
                    }
                    return;
                }
            }
        }
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer, ControlledComposition controlledComposition) {
        list.clear();
        synchronized (recomposer.stateLock) {
            Iterator<MovableContentStateReference> it = recomposer.movableContentAwaitingInsert.iterator();
            while (it.hasNext()) {
                MovableContentStateReference next = it.next();
                if (kotlin.jvm.internal.k.b(next.getComposition(), controlledComposition)) {
                    list.add(next);
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x013e, code lost:
    
        r3 = r10.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0143, code lost:
    
        if (r4 >= r3) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014d, code lost:
    
        if (((kotlin.Pair) r10.get(r4)).b == null) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x014f, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0152, code lost:
    
        r3 = new java.util.ArrayList(r10.size());
        r4 = r10.size();
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0160, code lost:
    
        if (r9 >= r4) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0162, code lost:
    
        r11 = (kotlin.Pair) r10.get(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x016a, code lost:
    
        if (r11.b != null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x016c, code lost:
    
        r11 = (androidx.compose.runtime.MovableContentStateReference) r11.f4886a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0173, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0174, code lost:
    
        if (r11 == null) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0176, code lost:
    
        r3.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0179, code lost:
    
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x017c, code lost:
    
        r4 = r16.stateLock;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x017e, code lost:
    
        monitor-enter(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x017f, code lost:
    
        D7.A.e0(r3, r16.movableContentAwaitingInsert);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0186, code lost:
    
        monitor-exit(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0187, code lost:
    
        r3 = new java.util.ArrayList(r10.size());
        r4 = r10.size();
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0195, code lost:
    
        if (r9 >= r4) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0197, code lost:
    
        r11 = r10.get(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a0, code lost:
    
        if (((kotlin.Pair) r11).b == null) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01a2, code lost:
    
        r3.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a5, code lost:
    
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01a8, code lost:
    
        r10 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<androidx.compose.runtime.ControlledComposition> performInsertValues(java.util.List<androidx.compose.runtime.MovableContentStateReference> r17, androidx.collection.MutableScatterSet<java.lang.Object> r18) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.performInsertValues(java.util.List, androidx.collection.MutableScatterSet):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ControlledComposition performRecompose(ControlledComposition composition, MutableScatterSet<Object> modifiedValues) {
        if (composition.isComposing() || composition.isDisposed()) {
            return null;
        }
        Set<ControlledComposition> set = this.compositionsRemoved;
        if (set != null && set.contains(composition)) {
            return null;
        }
        MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
            if (modifiedValues != null) {
                try {
                    if (modifiedValues.isNotEmpty()) {
                        composition.prepareCompose(new A6.i(11, modifiedValues, composition));
                    }
                } catch (Throwable th) {
                    mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th;
                }
            }
            boolean zRecompose = composition.recompose();
            mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
            if (zRecompose) {
                return composition;
            }
            return null;
        } finally {
            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final C7.r performRecompose$lambda$68$lambda$67(androidx.collection.MutableScatterSet r13, androidx.compose.runtime.ControlledComposition r14) {
        /*
            java.lang.Object[] r0 = r13.elements
            long[] r13 = r13.metadata
            int r1 = r13.length
            int r1 = r1 + (-2)
            if (r1 < 0) goto L43
            r2 = 0
            r3 = r2
        Lb:
            r4 = r13[r3]
            long r6 = ~r4
            r8 = 7
            long r6 = r6 << r8
            long r6 = r6 & r4
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L3e
            int r6 = r3 - r1
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r2
        L25:
            if (r8 >= r6) goto L3c
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L38
            int r9 = r3 << 3
            int r9 = r9 + r8
            r9 = r0[r9]
            r14.recordWriteOf(r9)
        L38:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L25
        L3c:
            if (r6 != r7) goto L43
        L3e:
            if (r3 == r1) goto L43
            int r3 = r3 + 1
            goto Lb
        L43:
            C7.r r13 = C7.r.f317a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.performRecompose$lambda$68$lambda$67(androidx.collection.MutableScatterSet, androidx.compose.runtime.ControlledComposition):C7.r");
    }

    private final void processCompositionError(Throwable e, ControlledComposition failedInitialComposition, boolean recoverable) throws Throwable {
        int i = 0;
        if (!_hotReloadEnabled.get().booleanValue() || (e instanceof ComposeRuntimeError)) {
            synchronized (this.stateLock) {
                RecomposerErrorState recomposerErrorState = this.errorState;
                if (recomposerErrorState != null) {
                    throw recomposerErrorState.getCause();
                }
                this.errorState = new RecomposerErrorState(false, e);
            }
            throw e;
        }
        synchronized (this.stateLock) {
            try {
                Utils_androidKt.logError("Error was captured in composition while live edit was enabled.", e);
                this.compositionsAwaitingApply.clear();
                this.compositionInvalidations.clear();
                this.snapshotInvalidations = new MutableScatterSet<>(i, 1, null);
                this.movableContentAwaitingInsert.clear();
                MultiValueMap.m3551clearimpl(this.movableContentRemoved);
                this.movableContentStatesAvailable.clear();
                this.errorState = new RecomposerErrorState(recoverable, e);
                if (failedInitialComposition != null) {
                    recordFailedCompositionLocked(failedInitialComposition);
                }
                deriveStateLocked();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void processCompositionError$default(Recomposer recomposer, Throwable th, ControlledComposition controlledComposition, boolean z10, int i, Object obj) throws Throwable {
        if ((i & 2) != 0) {
            controlledComposition = null;
        }
        if ((i & 4) != 0) {
            z10 = false;
        }
        recomposer.processCompositionError(th, controlledComposition, z10);
    }

    private final S7.k readObserverOf(ControlledComposition composition) {
        return new g(composition, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r readObserverOf$lambda$85(ControlledComposition controlledComposition, Object obj) {
        controlledComposition.recordReadOf(obj);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object recompositionRunner(o oVar, H7.c<? super r> cVar) throws Throwable {
        Object objW = AbstractC1683A.w(this.broadcastFrameClock, new C06902(oVar, MonotonicFrameClockKt.getMonotonicFrameClock(cVar.getContext()), null), cVar);
        return objW == CoroutineSingletons.f4909a ? objW : r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean recordComposerModifications() {
        boolean hasFrameWorkLocked;
        EmptyList emptyList = EmptyList.f4893a;
        synchronized (this.stateLock) {
            if (this.snapshotInvalidations.isEmpty()) {
                return getHasFrameWorkLocked();
            }
            List<ControlledComposition> listKnownCompositionsLocked = knownCompositionsLocked();
            Set<? extends Object> setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(this.snapshotInvalidations);
            int i = 0;
            this.snapshotInvalidations = new MutableScatterSet<>(i, 1, null);
            try {
                int size = listKnownCompositionsLocked.size();
                while (i < size) {
                    listKnownCompositionsLocked.get(i).recordModificationsOf(setWrapIntoSet);
                    if (((State) ((kotlinx.coroutines.flow.i) this._state).getValue()).compareTo(State.ShuttingDown) <= 0) {
                        break;
                    }
                    i++;
                }
                synchronized (this.stateLock) {
                    if (deriveStateLocked() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
                    }
                    hasFrameWorkLocked = getHasFrameWorkLocked();
                }
                return hasFrameWorkLocked;
            } catch (Throwable th) {
                synchronized (this.stateLock) {
                    this.snapshotInvalidations.addAll(setWrapIntoSet);
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordFailedCompositionLocked(ControlledComposition composition) {
        List arrayList = this.failedCompositions;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.failedCompositions = arrayList;
        }
        if (!arrayList.contains(composition)) {
            arrayList.add(composition);
        }
        removeKnownCompositionLocked(composition);
    }

    private final void registerCompositionLocked(ControlledComposition composition) {
        MutableObjectList<CompositionRegistrationObserver> mutableObjectList = this.registrationObservers;
        if (mutableObjectList != null) {
            Object[] objArr = mutableObjectList.content;
            int i = mutableObjectList._size;
            for (int i6 = 0; i6 < i; i6++) {
                CompositionRegistrationObserver compositionRegistrationObserver = (CompositionRegistrationObserver) objArr[i6];
                if (composition instanceof ObservableComposition) {
                    compositionRegistrationObserver.onCompositionRegistered((ObservableComposition) composition);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerRunnerJob(c0 callingJob) {
        synchronized (this.stateLock) {
            Throwable th = this.closeCause;
            if (th != null) {
                throw th;
            }
            if (((State) ((kotlinx.coroutines.flow.i) this._state).getValue()).compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down");
            }
            if (this.runnerJob != null) {
                throw new IllegalStateException("Recomposer already running");
            }
            this.runnerJob = callingJob;
            deriveStateLocked();
        }
    }

    private final void removeKnownCompositionLocked(ControlledComposition composition) {
        if (this._knownCompositions.remove(composition)) {
            this._knownCompositionsCache = null;
            unregisterCompositionLocked(composition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecomposerErrorState resetErrorState() {
        RecomposerErrorState recomposerErrorState;
        synchronized (this.stateLock) {
            recomposerErrorState = this.errorState;
            if (recomposerErrorState != null) {
                this.errorState = null;
                deriveStateLocked();
            }
        }
        return recomposerErrorState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retryFailedCompositions() {
        List<ControlledComposition> list;
        int i;
        synchronized (this.stateLock) {
            list = this.failedCompositions;
            this.failedCompositions = null;
        }
        if (list == null) {
            return;
        }
        while (true) {
            i = 0;
            try {
                if (list.isEmpty()) {
                    break;
                }
                ControlledComposition controlledComposition = (ControlledComposition) A.o0(list);
                if (controlledComposition instanceof CompositionImpl) {
                    ((CompositionImpl) controlledComposition).invalidateAll();
                    ((CompositionImpl) controlledComposition).setContent(((CompositionImpl) controlledComposition).getComposable());
                    if (this.errorState != null) {
                        break;
                    }
                }
            } catch (Throwable th) {
                if (!list.isEmpty()) {
                    synchronized (this.stateLock) {
                        int size = list.size();
                        while (i < size) {
                            recordFailedCompositionLocked(list.get(i));
                            i++;
                        }
                    }
                }
                throw th;
            }
        }
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.stateLock) {
            int size2 = list.size();
            while (i < size2) {
                recordFailedCompositionLocked(list.get(i));
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0091, code lost:
    
        if (r5.withFrameNanos(r9, r0) != r1) goto L13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0091 -> B:13:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runFrameLoop(androidx.compose.runtime.MonotonicFrameClock r7, androidx.compose.runtime.ProduceFrameSignal r8, H7.c<? super C7.r> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.runtime.Recomposer.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = (androidx.compose.runtime.Recomposer.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = new androidx.compose.runtime.Recomposer$runFrameLoop$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L5a
            if (r2 == r4) goto L46
            if (r2 != r3) goto L3e
            java.lang.Object r7 = r0.L$3
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r0.L$2
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r2 = r0.L$1
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r5 = r0.L$0
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            kotlin.b.b(r9)
        L39:
            r9 = r8
            r8 = r2
            r2 = r7
            r7 = r5
            goto L67
        L3e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L46:
            java.lang.Object r7 = r0.L$3
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r0.L$2
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r2 = r0.L$1
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r5 = r0.L$0
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            kotlin.b.b(r9)
            goto L7e
        L5a:
            kotlin.b.b(r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L67:
            java.lang.Object r5 = r6.stateLock
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r2
            r0.label = r4
            java.lang.Object r5 = r8.awaitFrameRequest(r5, r0)
            if (r5 != r1) goto L7a
            goto L93
        L7a:
            r5 = r7
            r7 = r2
            r2 = r8
            r8 = r9
        L7e:
            androidx.compose.runtime.i r9 = new androidx.compose.runtime.i
            r9.<init>()
            r0.L$0 = r5
            r0.L$1 = r2
            r0.L$2 = r8
            r0.L$3 = r7
            r0.label = r3
            java.lang.Object r9 = r5.withFrameNanos(r9, r0)
            if (r9 != r1) goto L39
        L93:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.runFrameLoop(androidx.compose.runtime.MonotonicFrameClock, androidx.compose.runtime.ProduceFrameSignal, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC1717j runFrameLoop$lambda$51(Recomposer recomposer, List list, List list2, ProduceFrameSignal produceFrameSignal, long j5) {
        Object objBeginSection;
        int i;
        InterfaceC1717j interfaceC1717jDeriveStateLocked;
        if (recomposer.getHasBroadcastFrameClockAwaiters()) {
            Trace trace = Trace.INSTANCE;
            objBeginSection = trace.beginSection("Recomposer:animation");
            try {
                recomposer.broadcastFrameClock.sendFrame(j5);
                Snapshot.INSTANCE.sendApplyNotifications();
                trace.endSection(objBeginSection);
            } finally {
            }
        }
        objBeginSection = Trace.INSTANCE.beginSection("Recomposer:recompose");
        try {
            recomposer.recordComposerModifications();
            synchronized (recomposer.stateLock) {
                try {
                    List<ControlledComposition> list3 = recomposer.compositionsAwaitingApply;
                    int size = list3.size();
                    i = 0;
                    for (int i6 = 0; i6 < size; i6++) {
                        list2.add(list3.get(i6));
                    }
                    recomposer.compositionsAwaitingApply.clear();
                    MutableVector<ControlledComposition> mutableVector = recomposer.compositionInvalidations;
                    ControlledComposition[] controlledCompositionArr = mutableVector.content;
                    int size2 = mutableVector.getSize();
                    for (int i10 = 0; i10 < size2; i10++) {
                        list.add(controlledCompositionArr[i10]);
                    }
                    recomposer.compositionInvalidations.clear();
                    produceFrameSignal.takeFrameRequestLocked();
                } catch (Throwable th) {
                    throw th;
                }
            }
            MutableScatterSet<Object> mutableScatterSet = new MutableScatterSet<>(i, 1, null);
            try {
                int size3 = list.size();
                for (int i11 = 0; i11 < size3; i11++) {
                    ControlledComposition controlledCompositionPerformRecompose = recomposer.performRecompose((ControlledComposition) list.get(i11), mutableScatterSet);
                    if (controlledCompositionPerformRecompose != null) {
                        list2.add(controlledCompositionPerformRecompose);
                    }
                }
                list.clear();
                if (!list2.isEmpty()) {
                    recomposer.changeCount++;
                }
                try {
                    int size4 = list2.size();
                    while (i < size4) {
                        ((ControlledComposition) list2.get(i)).applyChanges();
                        i++;
                    }
                    list2.clear();
                    synchronized (recomposer.stateLock) {
                        interfaceC1717jDeriveStateLocked = recomposer.deriveStateLocked();
                    }
                    return interfaceC1717jDeriveStateLocked;
                } catch (Throwable th2) {
                    list2.clear();
                    throw th2;
                }
            } catch (Throwable th3) {
                list.clear();
                throw th3;
            }
        } finally {
        }
    }

    private final void unregisterCompositionLocked(ControlledComposition composition) {
        MutableObjectList<CompositionRegistrationObserver> mutableObjectList = this.registrationObservers;
        if (mutableObjectList != null) {
            Object[] objArr = mutableObjectList.content;
            int i = mutableObjectList._size;
            for (int i6 = 0; i6 < i; i6++) {
                CompositionRegistrationObserver compositionRegistrationObserver = (CompositionRegistrationObserver) objArr[i6];
                if (composition instanceof ObservableComposition) {
                    compositionRegistrationObserver.onCompositionUnregistered((ObservableComposition) composition);
                }
            }
        }
    }

    private final void withTransparentSnapshot(S7.a block) {
        Snapshot current = Snapshot.INSTANCE.getCurrent();
        Snapshot transparentObserverMutableSnapshot = current instanceof MutableSnapshot ? new TransparentObserverMutableSnapshot((MutableSnapshot) current, null, null, true, false) : new TransparentObserverSnapshot(current, null, true, false);
        try {
            Snapshot snapshotMakeCurrent = transparentObserverMutableSnapshot.makeCurrent();
            try {
                block.invoke();
                transparentObserverMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                transparentObserverMutableSnapshot.dispose();
            } catch (Throwable th) {
                transparentObserverMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                throw th;
            }
        } catch (Throwable th2) {
            transparentObserverMutableSnapshot.dispose();
            throw th2;
        }
    }

    private final S7.k writeObserverOf(ControlledComposition composition, MutableScatterSet<Object> modifiedValues) {
        return new R3.b(12, composition, modifiedValues);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r writeObserverOf$lambda$86(ControlledComposition controlledComposition, MutableScatterSet mutableScatterSet, Object obj) {
        controlledComposition.recordWriteOf(obj);
        if (mutableScatterSet != null) {
            mutableScatterSet.add(obj);
        }
        return r.f317a;
    }

    public final CompositionObserverHandle addCompositionRegistrationObserver$runtime(final CompositionRegistrationObserver observer) {
        synchronized (this.stateLock) {
            try {
                MutableObjectList<CompositionRegistrationObserver> mutableObjectList = this.registrationObservers;
                int i = 0;
                if (mutableObjectList == null) {
                    mutableObjectList = new MutableObjectList<>(i, 1, null);
                    this.registrationObservers = mutableObjectList;
                }
                mutableObjectList.add(observer);
                List<ControlledComposition> list = this._knownCompositions;
                int size = list.size();
                while (i < size) {
                    ControlledComposition controlledComposition = list.get(i);
                    if (controlledComposition instanceof ObservableComposition) {
                        observer.onCompositionRegistered((ObservableComposition) controlledComposition);
                    }
                    i++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return new CompositionObserverHandle() { // from class: androidx.compose.runtime.Recomposer$addCompositionRegistrationObserver$2
            @Override // androidx.compose.runtime.tooling.CompositionObserverHandle
            public void dispose() {
                Object obj = this.this$0.stateLock;
                Recomposer recomposer = this.this$0;
                CompositionRegistrationObserver compositionRegistrationObserver = observer;
                synchronized (obj) {
                    MutableObjectList mutableObjectList2 = recomposer.registrationObservers;
                    if (mutableObjectList2 != null) {
                        mutableObjectList2.remove(compositionRegistrationObserver);
                    }
                }
            }
        };
    }

    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    public final Object awaitIdle(H7.c<? super r> cVar) {
        Object objCollect = new p9.g((p9.n) getCurrentState(), (n) new AnonymousClass2(null)).collect(q9.i.f5626a, cVar);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        r rVar = r.f317a;
        if (objCollect != coroutineSingletons) {
            objCollect = rVar;
        }
        return objCollect == coroutineSingletons ? objCollect : rVar;
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            if (((State) ((kotlinx.coroutines.flow.i) this._state).getValue()).compareTo(State.Idle) >= 0) {
                ((kotlinx.coroutines.flow.i) this._state).i(State.ShuttingDown);
            }
        }
        ((kotlinx.coroutines.c) this.effectJob).cancel(null);
    }

    public final void close() {
        if (((d0) this.effectJob).U(r.f317a)) {
            synchronized (this.stateLock) {
                this.isClosed = true;
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    @ComposableInferredTarget(scheme = "[0[0]]")
    public void composeInitial$runtime(ControlledComposition composition, n content) throws Throwable {
        boolean z10;
        Recomposer recomposer;
        boolean zIsComposing = composition.isComposing();
        synchronized (this.stateLock) {
            if (((State) ((kotlinx.coroutines.flow.i) this._state).getValue()).compareTo(State.ShuttingDown) > 0) {
                boolean zContains = knownCompositionsLocked().contains(composition);
                z10 = !zContains;
                if (!zContains) {
                    addKnownCompositionLocked(composition);
                }
            } else {
                z10 = true;
            }
        }
        try {
            Snapshot.Companion companion = Snapshot.INSTANCE;
            MutableSnapshot mutableSnapshotTakeMutableSnapshot = companion.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, null));
            try {
                Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
                try {
                    composition.composeContent(content);
                    mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    applyAndCheck(mutableSnapshotTakeMutableSnapshot);
                    if (!zIsComposing) {
                        companion.notifyObjectsInitialized();
                    }
                    try {
                        performInitialMovableContentInserts(composition);
                        try {
                            composition.applyChanges();
                            composition.applyLateChanges();
                            if (zIsComposing) {
                                return;
                            }
                            companion.notifyObjectsInitialized();
                        } catch (Throwable th) {
                            processCompositionError$default(this, th, null, false, 6, null);
                        }
                    } catch (Throwable th2) {
                        processCompositionError(th2, composition, true);
                    }
                } catch (Throwable th3) {
                    recomposer = this;
                    try {
                        mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                        throw th3;
                    } catch (Throwable th4) {
                        th = th4;
                        Throwable th5 = th;
                        try {
                            recomposer.applyAndCheck(mutableSnapshotTakeMutableSnapshot);
                            throw th5;
                        } catch (Throwable th6) {
                            th = th6;
                            recomposer.processCompositionError(th, composition, true);
                            if (z10) {
                                synchronized (recomposer.stateLock) {
                                    recomposer.removeKnownCompositionLocked(composition);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                recomposer = this;
            }
        } catch (Throwable th8) {
            th = th8;
            recomposer = this;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    @ComposableInferredTarget(scheme = "[0[0]]")
    public ScatterSet<RecomposeScopeImpl> composeInitialPaused$runtime(ControlledComposition composition, ShouldPauseCallback shouldPause, n content) {
        try {
            ShouldPauseCallback andSetShouldPauseCallback = composition.getAndSetShouldPauseCallback(shouldPause);
            try {
                composeInitial$runtime(composition, content);
                ScatterSet<RecomposeScopeImpl> scatterSetEmptyScatterSet = (MutableScatterSet) this.pausedScopes.get();
                if (scatterSetEmptyScatterSet == null) {
                    scatterSetEmptyScatterSet = ScatterSetKt.emptyScatterSet();
                }
                return scatterSetEmptyScatterSet;
            } finally {
                composition.getAndSetShouldPauseCallback(andSetShouldPauseCallback);
            }
        } finally {
            this.pausedScopes.set(null);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void deletedMovableContent$runtime(MovableContentStateReference reference) {
        InterfaceC1717j interfaceC1717jDeriveStateLocked;
        synchronized (this.stateLock) {
            try {
                MultiValueMap.m3549addimpl(this.movableContentRemoved, reference.getContent$runtime(), reference);
                if (reference.getNestedReferences$runtime() != null) {
                    deletedMovableContent$lambda$95$recordNestedStatesOf(this, reference, reference);
                }
                interfaceC1717jDeriveStateLocked = deriveStateLocked();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (interfaceC1717jDeriveStateLocked != null) {
            interfaceC1717jDeriveStateLocked.resumeWith(r.f317a);
        }
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingCallByInformation$runtime() {
        return _hotReloadEnabled.get().booleanValue();
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* renamed from: getCollectingParameterInformation$runtime */
    public boolean getCollectingParameterInformation() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* renamed from: getCollectingSourceInformation$runtime */
    public boolean getCollectingSourceInformation() {
        return ComposerKt.getComposeStackTraceEnabled();
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* renamed from: getCompositeKeyHashCode$runtime */
    public long getCompositeKeyHashCode() {
        return 1000;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public Composition getComposition$runtime() {
        return null;
    }

    public final t getCurrentState() {
        return this._state;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public H7.h getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean getHasPendingWork() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.stateLock
            monitor-enter(r0)
            androidx.collection.MutableScatterSet<java.lang.Object> r1 = r2.snapshotInvalidations     // Catch: java.lang.Throwable -> L33
            boolean r1 = r1.isNotEmpty()     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto L35
            androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.ControlledComposition> r1 = r2.compositionInvalidations     // Catch: java.lang.Throwable -> L33
            int r1 = r1.getSize()     // Catch: java.lang.Throwable -> L33
            if (r1 == 0) goto L14
            goto L35
        L14:
            int r1 = r2.concurrentCompositionsOutstanding     // Catch: java.lang.Throwable -> L33
            if (r1 > 0) goto L35
            java.util.List<androidx.compose.runtime.ControlledComposition> r1 = r2.compositionsAwaitingApply     // Catch: java.lang.Throwable -> L33
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Throwable -> L33
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L33
            if (r1 == 0) goto L35
            boolean r1 = r2.getHasBroadcastFrameClockAwaitersLocked()     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto L35
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r2 = r2.movableContentRemoved     // Catch: java.lang.Throwable -> L33
            boolean r2 = androidx.compose.runtime.collection.MultiValueMap.m3561isNotEmptyimpl(r2)     // Catch: java.lang.Throwable -> L33
            if (r2 == 0) goto L31
            goto L35
        L31:
            r2 = 0
            goto L36
        L33:
            r2 = move-exception
            goto L38
        L35:
            r2 = 1
        L36:
            monitor-exit(r0)
            return r2
        L38:
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.getHasPendingWork():boolean");
    }

    @Override // androidx.compose.runtime.CompositionContext
    public H7.h getRecomposeCoroutineContext$runtime() {
        return EmptyCoroutineContext.f4908a;
    }

    public final p9.c getState() {
        return getCurrentState();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void insertMovableContent$runtime(MovableContentStateReference reference) {
        InterfaceC1717j interfaceC1717jDeriveStateLocked;
        synchronized (this.stateLock) {
            this.movableContentAwaitingInsert.add(reference);
            interfaceC1717jDeriveStateLocked = deriveStateLocked();
        }
        if (interfaceC1717jDeriveStateLocked != null) {
            interfaceC1717jDeriveStateLocked.resumeWith(r.f317a);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidate$runtime(ControlledComposition composition) {
        InterfaceC1717j interfaceC1717jDeriveStateLocked;
        synchronized (this.stateLock) {
            if (this.compositionInvalidations.contains(composition)) {
                interfaceC1717jDeriveStateLocked = null;
            } else {
                this.compositionInvalidations.add(composition);
                interfaceC1717jDeriveStateLocked = deriveStateLocked();
            }
        }
        if (interfaceC1717jDeriveStateLocked != null) {
            interfaceC1717jDeriveStateLocked.resumeWith(r.f317a);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidateScope$runtime(RecomposeScopeImpl scope) {
        InterfaceC1717j interfaceC1717jDeriveStateLocked;
        synchronized (this.stateLock) {
            this.snapshotInvalidations.add(scope);
            interfaceC1717jDeriveStateLocked = deriveStateLocked();
        }
        if (interfaceC1717jDeriveStateLocked != null) {
            interfaceC1717jDeriveStateLocked.resumeWith(r.f317a);
        }
    }

    public final Object join(H7.c<? super r> cVar) {
        Object objI = kotlinx.coroutines.flow.d.i(getCurrentState(), new C06892(null), cVar);
        return objI == CoroutineSingletons.f4909a ? objI : r.f317a;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    @Override // androidx.compose.runtime.CompositionContext
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void movableContentStateReleased$runtime(androidx.compose.runtime.MovableContentStateReference r18, androidx.compose.runtime.MovableContentState r19, androidx.compose.runtime.Applier<?> r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.Object r3 = r0.stateLock
            monitor-enter(r3)
            androidx.collection.MutableScatterMap<androidx.compose.runtime.MovableContentStateReference, androidx.compose.runtime.MovableContentState> r4 = r0.movableContentStatesAvailable     // Catch: java.lang.Throwable -> L63
            r4.set(r1, r2)     // Catch: java.lang.Throwable -> L63
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r4 = r0.movableContentNestedExtractionsPending     // Catch: java.lang.Throwable -> L63
            androidx.collection.ObjectList r1 = androidx.compose.runtime.collection.MultiValueMap.m3558getimpl(r4, r1)     // Catch: java.lang.Throwable -> L63
            boolean r4 = r1.isNotEmpty()     // Catch: java.lang.Throwable -> L63
            if (r4 == 0) goto L70
            r4 = r20
            androidx.collection.ScatterMap r1 = r2.extractNestedStates$runtime(r4, r1)     // Catch: java.lang.Throwable -> L63
            java.lang.Object[] r2 = r1.keys     // Catch: java.lang.Throwable -> L63
            java.lang.Object[] r4 = r1.values     // Catch: java.lang.Throwable -> L63
            long[] r1 = r1.metadata     // Catch: java.lang.Throwable -> L63
            int r5 = r1.length     // Catch: java.lang.Throwable -> L63
            int r5 = r5 + (-2)
            if (r5 < 0) goto L70
            r6 = 0
            r7 = r6
        L2d:
            r8 = r1[r7]     // Catch: java.lang.Throwable -> L63
            long r10 = ~r8     // Catch: java.lang.Throwable -> L63
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L6b
            int r10 = r7 - r5
            int r10 = ~r10     // Catch: java.lang.Throwable -> L63
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L47:
            if (r12 >= r10) goto L69
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L65
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r2[r13]     // Catch: java.lang.Throwable -> L63
            r13 = r4[r13]     // Catch: java.lang.Throwable -> L63
            androidx.compose.runtime.MovableContentState r13 = (androidx.compose.runtime.MovableContentState) r13     // Catch: java.lang.Throwable -> L63
            androidx.compose.runtime.MovableContentStateReference r14 = (androidx.compose.runtime.MovableContentStateReference) r14     // Catch: java.lang.Throwable -> L63
            androidx.collection.MutableScatterMap<androidx.compose.runtime.MovableContentStateReference, androidx.compose.runtime.MovableContentState> r15 = r0.movableContentStatesAvailable     // Catch: java.lang.Throwable -> L63
            r15.set(r14, r13)     // Catch: java.lang.Throwable -> L63
            goto L65
        L63:
            r0 = move-exception
            goto L72
        L65:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L47
        L69:
            if (r10 != r11) goto L70
        L6b:
            if (r7 == r5) goto L70
            int r7 = r7 + 1
            goto L2d
        L70:
            monitor-exit(r3)
            return
        L72:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.movableContentStateReleased$runtime(androidx.compose.runtime.MovableContentStateReference, androidx.compose.runtime.MovableContentState, androidx.compose.runtime.Applier):void");
    }

    @Override // androidx.compose.runtime.CompositionContext
    public MovableContentState movableContentStateResolve$runtime(MovableContentStateReference reference) {
        MovableContentState movableContentStateRemove;
        synchronized (this.stateLock) {
            movableContentStateRemove = this.movableContentStatesAvailable.remove(reference);
        }
        return movableContentStateRemove;
    }

    public final void pauseCompositionFrameClock() {
        synchronized (this.stateLock) {
            this.frameClockPaused = true;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public ScatterSet<RecomposeScopeImpl> recomposePaused$runtime(ControlledComposition composition, ShouldPauseCallback shouldPause, ScatterSet<RecomposeScopeImpl> invalidScopes) {
        try {
            recordComposerModifications();
            composition.recordModificationsOf(ScatterSetWrapperKt.wrapIntoSet(invalidScopes));
            ShouldPauseCallback andSetShouldPauseCallback = composition.getAndSetShouldPauseCallback(shouldPause);
            try {
                ControlledComposition controlledCompositionPerformRecompose = performRecompose(composition, null);
                if (controlledCompositionPerformRecompose != null) {
                    performInitialMovableContentInserts(composition);
                    controlledCompositionPerformRecompose.applyChanges();
                    controlledCompositionPerformRecompose.applyLateChanges();
                }
                ScatterSet<RecomposeScopeImpl> scatterSetEmptyScatterSet = (MutableScatterSet) this.pausedScopes.get();
                if (scatterSetEmptyScatterSet == null) {
                    scatterSetEmptyScatterSet = ScatterSetKt.emptyScatterSet();
                }
                return scatterSetEmptyScatterSet;
            } finally {
                composition.getAndSetShouldPauseCallback(andSetShouldPauseCallback);
            }
        } finally {
            this.pausedScopes.set(null);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void recordInspectionTable$runtime(Set<CompositionData> table) {
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void registerComposition$runtime(ControlledComposition composition) {
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void reportPausedScope$runtime(RecomposeScopeImpl scope) {
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSetMutableScatterSetOf = this.pausedScopes.get();
        if (mutableScatterSetMutableScatterSetOf == null) {
            mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
            this.pausedScopes.set(mutableScatterSetMutableScatterSetOf);
        }
        mutableScatterSetMutableScatterSetOf.add(scope);
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void reportRemovedComposition$runtime(ControlledComposition composition) {
        synchronized (this.stateLock) {
            try {
                Set linkedHashSet = this.compositionsRemoved;
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                    this.compositionsRemoved = linkedHashSet;
                }
                linkedHashSet.add(composition);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void resumeCompositionFrameClock() {
        InterfaceC1717j interfaceC1717jDeriveStateLocked;
        synchronized (this.stateLock) {
            if (this.frameClockPaused) {
                this.frameClockPaused = false;
                interfaceC1717jDeriveStateLocked = deriveStateLocked();
            } else {
                interfaceC1717jDeriveStateLocked = null;
            }
        }
        if (interfaceC1717jDeriveStateLocked != null) {
            interfaceC1717jDeriveStateLocked.resumeWith(r.f317a);
        }
    }

    public final Object runRecomposeAndApplyChanges(H7.c<? super r> cVar) throws Throwable {
        Object objRecompositionRunner = recompositionRunner(new C06912(null), cVar);
        return objRecompositionRunner == CoroutineSingletons.f4909a ? objRecompositionRunner : r.f317a;
    }

    @ExperimentalComposeApi
    public final Object runRecomposeConcurrentlyAndApplyChanges(H7.h hVar, H7.c<? super r> cVar) throws Throwable {
        Object objRecompositionRunner = recompositionRunner(new C06922(hVar, this, null), cVar);
        return objRecompositionRunner == CoroutineSingletons.f4909a ? objRecompositionRunner : r.f317a;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void unregisterComposition$runtime(ControlledComposition composition) {
        synchronized (this.stateLock) {
            removeKnownCompositionLocked(composition);
            this.compositionInvalidations.remove(composition);
            this.compositionsAwaitingApply.remove(composition);
        }
    }

    private final void recordComposerModifications(S7.k onEachInvalidComposition) {
        MutableScatterSet mutableScatterSet;
        int i;
        synchronized (this.stateLock) {
            mutableScatterSet = this.snapshotInvalidations;
            i = 0;
            if (mutableScatterSet.isNotEmpty()) {
                this.snapshotInvalidations = new MutableScatterSet(i, 1, null);
            }
        }
        Set<? extends Object> setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(mutableScatterSet);
        if (!setWrapIntoSet.isEmpty()) {
            List listKnownCompositionsLocked = knownCompositionsLocked();
            int size = listKnownCompositionsLocked.size();
            for (int i6 = 0; i6 < size; i6++) {
                ((ControlledComposition) listKnownCompositionsLocked.get(i6)).recordModificationsOf(setWrapIntoSet);
            }
        }
        MutableVector mutableVector = this.compositionInvalidations;
        Object[] objArr = mutableVector.content;
        int size2 = mutableVector.getSize();
        while (i < size2) {
            onEachInvalidComposition.invoke(objArr[i]);
            i++;
        }
        this.compositionInvalidations.clear();
        synchronized (this.stateLock) {
            if (deriveStateLocked() != null) {
                throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
            }
        }
    }
}
