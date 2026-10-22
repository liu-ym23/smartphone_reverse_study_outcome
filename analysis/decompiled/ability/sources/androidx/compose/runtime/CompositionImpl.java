package androidx.compose.runtime;

import D7.q;
import D7.v;
import S7.n;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.compose.runtime.tooling.ObservableComposition;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000¨\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B'\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0013\u001a\u00020\u00102\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\b\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0015\u001a\u00020\u00102\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\b\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\"\u0010\u0017\u001a\u00020\u00162\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\b\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\u0019\u001a\u00020\u00162\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\b\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u001f\u0010\u001f\u001a\u00020\u00102\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\u00020\u00102\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\"\u0010)\u001a\u00020\u00102\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\b\u0011H\u0016¢\u0006\u0004\b)\u0010\u0014J\u000f\u0010,\u001a\u00020\u0010H\u0000¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020\u0010H\u0016¢\u0006\u0004\b-\u0010+J\u001d\u00101\u001a\u00020\u00102\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0.H\u0016¢\u0006\u0004\b1\u00102J\u001d\u00104\u001a\u0002032\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0.H\u0016¢\u0006\u0004\b4\u00105J\u001d\u00107\u001a\u00020\u00102\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b7\u00108J)\u0010@\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020/0<0;2\u0006\u0010:\u001a\u000209H\u0000¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020\u00102\u0006\u0010A\u001a\u00020/H\u0016¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u00020\u00102\u0006\u0010A\u001a\u00020/H\u0016¢\u0006\u0004\bD\u0010CJ\u000f\u0010E\u001a\u000203H\u0016¢\u0006\u0004\bE\u0010FJ+\u0010I\u001a\u00020\u00102\u001a\u0010H\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020G\u0012\u0006\u0012\u0004\u0018\u00010G0<0;H\u0016¢\u0006\u0004\bI\u0010JJ\u0017\u0010M\u001a\u00020\u00102\u0006\u0010L\u001a\u00020KH\u0016¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u0010H\u0016¢\u0006\u0004\bO\u0010+J\u000f\u0010P\u001a\u00020\u0010H\u0016¢\u0006\u0004\bP\u0010+J\u000f\u0010Q\u001a\u00020\u0010H\u0016¢\u0006\u0004\bQ\u0010+J\u000f\u0010R\u001a\u00020\u0010H\u0016¢\u0006\u0004\bR\u0010+J\u000f\u0010S\u001a\u00020\u0010H\u0016¢\u0006\u0004\bS\u0010+J\u000f\u0010T\u001a\u00020\u0010H\u0016¢\u0006\u0004\bT\u0010+J5\u0010X\u001a\u00028\u0000\"\u0004\b\u0000\u0010U2\b\u0010V\u001a\u0004\u0018\u00010\u00012\u0006\u0010W\u001a\u00020%2\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016¢\u0006\u0004\bX\u0010YJ\u001b\u0010\\\u001a\u0004\u0018\u00010Z2\b\u0010[\u001a\u0004\u0018\u00010ZH\u0016¢\u0006\u0004\b\\\u0010]J!\u0010a\u001a\u00020`2\u0006\u0010^\u001a\u00020=2\b\u0010_\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\ba\u0010bJ\u0017\u0010c\u001a\u00020\u00102\u0006\u0010^\u001a\u00020=H\u0016¢\u0006\u0004\bc\u0010dJ%\u0010g\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010e2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000fH\u0016¢\u0006\u0004\bg\u0010hJ\u001f\u0010k\u001a\u00020\u00102\u0006\u0010_\u001a\u00020/2\u0006\u0010^\u001a\u00020=H\u0000¢\u0006\u0004\bi\u0010jJ\u001b\u0010o\u001a\u00020\u00102\n\u0010L\u001a\u0006\u0012\u0002\b\u00030lH\u0000¢\u0006\u0004\bm\u0010nJ\u000f\u0010p\u001a\u00020\u0010H\u0016¢\u0006\u0004\bp\u0010+J\u000f\u0010s\u001a\u00020%H\u0000¢\u0006\u0004\bq\u0010rJ\"\u0010t\u001a\u00020\u00102\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\b\u0011H\u0002¢\u0006\u0004\bt\u0010\u0014J*\u0010v\u001a\u00020\u00162\u0006\u0010u\u001a\u0002032\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\b\u0011H\u0002¢\u0006\u0004\bv\u0010wJ\"\u0010x\u001a\u00020\u00102\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\b\u0011H\u0002¢\u0006\u0004\bx\u0010\u0014J\u000f\u0010y\u001a\u00020\u0010H\u0002¢\u0006\u0004\by\u0010+J\u000f\u0010z\u001a\u000203H\u0002¢\u0006\u0004\bz\u0010FJ\u000f\u0010{\u001a\u00020\u0010H\u0002¢\u0006\u0004\b{\u0010+J\u000f\u0010|\u001a\u00020\u0010H\u0002¢\u0006\u0004\b|\u0010+J\u000f\u0010}\u001a\u00020\u0010H\u0002¢\u0006\u0004\b}\u0010+J \u0010\u007f\u001a\u00020\u00102\u0006\u0010A\u001a\u00020/2\u0006\u0010~\u001a\u000203H\u0002¢\u0006\u0005\b\u007f\u0010\u0080\u0001J&\u0010\u007f\u001a\u00020\u00102\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010~\u001a\u000203H\u0002¢\u0006\u0005\b\u007f\u0010\u0081\u0001J\u0011\u0010\u0082\u0001\u001a\u00020\u0010H\u0002¢\u0006\u0005\b\u0082\u0001\u0010+J\u0019\u0010\u0083\u0001\u001a\u00020\u00102\u0006\u0010A\u001a\u00020/H\u0002¢\u0006\u0005\b\u0083\u0001\u0010CJ\u001c\u0010\u0086\u0001\u001a\u00020\u00102\b\u0010\u0085\u0001\u001a\u00030\u0084\u0001H\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J;\u0010\u008a\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010e2 \u00106\u001a\u001c\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020/0\u0089\u0001\u0012\u0004\u0012\u00028\u00000\u0088\u0001H\u0082\b¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J'\u0010\u008c\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010e2\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0082\b¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J$\u0010\u008e\u0001\u001a\u0002032\u0006\u0010^\u001a\u00020=2\b\u0010_\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J,\u0010\u0090\u0001\u001a\u00020`2\u0006\u0010^\u001a\u00020=2\u0006\u0010:\u001a\u0002092\b\u0010_\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u001f\u0010\u0094\u0001\u001a\u000f\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020/0\u0089\u0001H\u0002¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001c\u0010\u0097\u0001\u001a\u00020\u00102\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001H\u0002¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J'\u0010\u0099\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010e2\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0082\b¢\u0006\u0006\b\u0099\u0001\u0010\u008d\u0001J\u0012\u0010!\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0005\b!\u0010\u009a\u0001R\u001a\u0010\b\u001a\u00020\u00078G¢\u0006\u000f\n\u0005\b\b\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0019\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\n\u0010\u009e\u0001R-\u0010¡\u0001\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010/0\u009f\u0001j\u000b\u0012\u0006\u0012\u0004\u0018\u00010/` \u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u001c\u0010¤\u0001\u001a\u00070/j\u0003`£\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R&\u0010¨\u0001\u001a\n\u0012\u0005\u0012\u00030§\u00010¦\u00018\u0002X\u0082\u0004¢\u0006\u000f\n\u0006\b¨\u0001\u0010©\u0001\u0012\u0005\bª\u0001\u0010+R'\u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0000X\u0080\u0004¢\u0006\u0017\n\u0006\b\u0096\u0001\u0010«\u0001\u0012\u0005\b®\u0001\u0010+\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R$\u0010¯\u0001\u001a\u000f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020=0\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u001e\u0010²\u0001\u001a\t\u0012\u0004\u0012\u00020=0±\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u001e\u0010´\u0001\u001a\t\u0012\u0004\u0012\u00020=0±\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b´\u0001\u0010³\u0001R(\u0010µ\u0001\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\b\u0012\u0006\u0012\u0002\b\u00030l0\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010°\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010¶\u0001R\u0018\u0010·\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b·\u0001\u0010¶\u0001R$\u0010¸\u0001\u001a\u000f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020=0\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010°\u0001R&\u0010¹\u0001\u001a\u000f\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020/0\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010°\u0001R/\u0010º\u0001\u001a\u0002038\u0000@\u0000X\u0080\u000e¢\u0006\u001e\n\u0006\bº\u0001\u0010»\u0001\u0012\u0005\b¿\u0001\u0010+\u001a\u0005\b¼\u0001\u0010F\"\u0006\b½\u0001\u0010¾\u0001R\u0019\u0010[\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b[\u0010À\u0001R\u001c\u0010Â\u0001\u001a\u0005\u0018\u00010Á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u001b\u0010Ä\u0001\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R\u0019\u0010Æ\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R \u0010É\u0001\u001a\u00030È\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001R\u0018\u0010Î\u0001\u001a\u00030Í\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R \u0010Ñ\u0001\u001a\u00030Ð\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bÑ\u0001\u0010Ò\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001R\u0019\u0010Õ\u0001\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R\u001b\u0010×\u0001\u001a\u0002038\u0006¢\u0006\u000f\n\u0006\b×\u0001\u0010»\u0001\u001a\u0005\b×\u0001\u0010FR\u0017\u0010L\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bL\u0010Ç\u0001R3\u0010Ø\u0001\u001a\r\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\b\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bØ\u0001\u0010Ù\u0001\u001a\u0006\bÚ\u0001\u0010Û\u0001\"\u0005\bÜ\u0001\u0010\u0014R\u001d\u0010ß\u0001\u001a\b\u0012\u0004\u0012\u00020/0.8AX\u0080\u0004¢\u0006\b\u001a\u0006\bÝ\u0001\u0010Þ\u0001R\u001d\u0010á\u0001\u001a\b\u0012\u0004\u0012\u00020/0.8AX\u0080\u0004¢\u0006\b\u001a\u0006\bà\u0001\u0010Þ\u0001R\u001d\u0010ä\u0001\u001a\b\u0012\u0004\u0012\u00020=0;8AX\u0080\u0004¢\u0006\b\u001a\u0006\bâ\u0001\u0010ã\u0001R\u0013\u0010\f\u001a\u00020\u000b8F¢\u0006\b\u001a\u0006\bå\u0001\u0010æ\u0001R\u0016\u0010ç\u0001\u001a\u0002038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bç\u0001\u0010FR\u0016\u0010è\u0001\u001a\u0002038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bè\u0001\u0010FR\u0016\u0010ê\u0001\u001a\u0002038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bé\u0001\u0010FR\u0016\u0010ì\u0001\u001a\u0002038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bë\u0001\u0010FR\u0016\u0010î\u0001\u001a\u0002038BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bí\u0001\u0010F¨\u0006ï\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/ReusableComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "Landroidx/compose/runtime/CompositionServices;", "Landroidx/compose/runtime/PausableComposition;", "Landroidx/compose/runtime/tooling/ObservableComposition;", "Landroidx/compose/runtime/CompositionContext;", "parent", "Landroidx/compose/runtime/Applier;", "applier", "LH7/h;", "recomposeContext", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;LH7/h;)V", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "setContent", "(LS7/n;)V", "setContentWithReuse", "Landroidx/compose/runtime/PausedComposition;", "setPausableContent", "(LS7/n;)Landroidx/compose/runtime/PausedComposition;", "setPausableContentWithReuse", "Landroidx/collection/ScatterSet;", "Landroidx/compose/runtime/RememberObserverHolder;", "ignoreSet", "pausedCompositionFinished$runtime", "(Landroidx/collection/ScatterSet;)V", "pausedCompositionFinished", "Landroidx/compose/runtime/tooling/CompositionObserver;", "observer", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "setObserver", "(Landroidx/compose/runtime/tooling/CompositionObserver;)Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "", "key", "invalidateGroupsWithKey", "(I)V", "composeContent", "updateMovingInvalidations$runtime", "()V", "updateMovingInvalidations", "dispose", "", "", "values", "recordModificationsOf", "(Ljava/util/Set;)V", "", "observesAnyOf", "(Ljava/util/Set;)Z", "block", "prepareCompose", "(LS7/a;)V", "Landroidx/compose/runtime/Anchor;", "anchor", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "extractInvalidationsOf$runtime", "(Landroidx/compose/runtime/Anchor;)Ljava/util/List;", "extractInvalidationsOf", "value", "recordReadOf", "(Ljava/lang/Object;)V", "recordWriteOf", "recompose", "()Z", "Landroidx/compose/runtime/MovableContentStateReference;", "references", "insertMovableContent", "(Ljava/util/List;)V", "Landroidx/compose/runtime/MovableContentState;", "state", "disposeUnusedMovableContent", "(Landroidx/compose/runtime/MovableContentState;)V", "applyChanges", "applyLateChanges", "changesApplied", "abandonChanges", "invalidateAll", "verifyConsistent", "R", TypedValues.TransitionType.S_TO, "groupIndex", "delegateInvalidations", "(Landroidx/compose/runtime/ControlledComposition;ILS7/a;)Ljava/lang/Object;", "Landroidx/compose/runtime/ShouldPauseCallback;", "shouldPause", "getAndSetShouldPauseCallback", "(Landroidx/compose/runtime/ShouldPauseCallback;)Landroidx/compose/runtime/ShouldPauseCallback;", "scope", "instance", "Landroidx/compose/runtime/InvalidationResult;", "invalidate", "(Landroidx/compose/runtime/RecomposeScopeImpl;Ljava/lang/Object;)Landroidx/compose/runtime/InvalidationResult;", "recomposeScopeReleased", "(Landroidx/compose/runtime/RecomposeScopeImpl;)V", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/CompositionServiceKey;", "getCompositionService", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "removeObservation$runtime", "(Ljava/lang/Object;Landroidx/compose/runtime/RecomposeScopeImpl;)V", "removeObservation", "Landroidx/compose/runtime/DerivedState;", "removeDerivedStateObservation$runtime", "(Landroidx/compose/runtime/DerivedState;)V", "removeDerivedStateObservation", "deactivate", "composerStacksSizes$runtime", "()I", "composerStacksSizes", "composeInitial", "reusable", "composeInitialPaused", "(ZLS7/n;)Landroidx/compose/runtime/PausedComposition;", "composeInitialWithReuse", "ensureRunning", "clearDeactivated", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "drainPendingModificationsOutOfBandLocked", "forgetConditionalScopes", "addPendingInvalidationsLocked", "(Ljava/lang/Object;Z)V", "(Ljava/util/Set;Z)V", "cleanUpDerivedStateObservations", "invalidateScopeOfLocked", "Landroidx/compose/runtime/changelist/ChangeList;", "changes", "applyChangesInLocked", "(Landroidx/compose/runtime/changelist/ChangeList;)V", "Lkotlin/Function1;", "Landroidx/compose/runtime/collection/ScopeMap;", "guardInvalidationsLocked", "(LS7/k;)Ljava/lang/Object;", "guardChanges", "(LS7/a;)Ljava/lang/Object;", "tryImminentInvalidation", "(Landroidx/compose/runtime/RecomposeScopeImpl;Ljava/lang/Object;)Z", "invalidateChecked", "(Landroidx/compose/runtime/RecomposeScopeImpl;Landroidx/compose/runtime/Anchor;Ljava/lang/Object;)Landroidx/compose/runtime/InvalidationResult;", "takeInvalidations-afanTW4", "()Landroidx/collection/MutableScatterMap;", "takeInvalidations", "Landroidx/compose/runtime/SlotTable;", "slotTable", "validateRecomposeScopeAnchors", "(Landroidx/compose/runtime/SlotTable;)V", "trackAbandonedValues", "()Landroidx/compose/runtime/tooling/CompositionObserver;", "Landroidx/compose/runtime/CompositionContext;", "getParent", "()Landroidx/compose/runtime/CompositionContext;", "Landroidx/compose/runtime/Applier;", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/internal/AtomicReference;", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/platform/SynchronizedObject;", "lock", "Ljava/lang/Object;", "", "Landroidx/compose/runtime/RememberObserver;", "abandonSet", "Ljava/util/Set;", "getAbandonSet$annotations", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime", "()Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime$annotations", "observations", "Landroidx/collection/MutableScatterMap;", "Landroidx/collection/MutableScatterSet;", "invalidatedScopes", "Landroidx/collection/MutableScatterSet;", "conditionallyInvalidatedScopes", "derivedStates", "Landroidx/compose/runtime/changelist/ChangeList;", "lateChanges", "observationsProcessed", "invalidations", "pendingInvalidScopes", "Z", "getPendingInvalidScopes$runtime", "setPendingInvalidScopes$runtime", "(Z)V", "getPendingInvalidScopes$runtime$annotations", "Landroidx/compose/runtime/ShouldPauseCallback;", "Landroidx/compose/runtime/PausedCompositionImpl;", "pendingPausedComposition", "Landroidx/compose/runtime/PausedCompositionImpl;", "invalidationDelegate", "Landroidx/compose/runtime/CompositionImpl;", "invalidationDelegateGroup", "I", "Landroidx/compose/runtime/CompositionObserverHolder;", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime", "()Landroidx/compose/runtime/CompositionObserverHolder;", "Landroidx/compose/runtime/internal/RememberEventDispatcher;", "rememberManager", "Landroidx/compose/runtime/internal/RememberEventDispatcher;", "Landroidx/compose/runtime/ComposerImpl;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "getComposer$runtime", "()Landroidx/compose/runtime/ComposerImpl;", "_recomposeContext", "LH7/h;", "isRoot", "composable", "LS7/n;", "getComposable", "()LS7/n;", "setComposable", "getObservedObjects$runtime", "()Ljava/util/Set;", "observedObjects", "getDerivedStateDependencies$runtime", "derivedStateDependencies", "getConditionalScopes$runtime", "()Ljava/util/List;", "conditionalScopes", "getRecomposeContext", "()LH7/h;", "isComposing", "isDisposed", "getHasPendingChanges", "hasPendingChanges", "getHasInvalidations", "hasInvalidations", "getAreChildrenComposing", "areChildrenComposing", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CompositionImpl implements ControlledComposition, ReusableComposition, RecomposeScopeOwner, CompositionServices, PausableComposition, ObservableComposition {
    public static final int $stable = 8;
    private final H7.h _recomposeContext;
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final ChangeList changes;
    private n composable;
    private final ComposerImpl composer;
    private final MutableScatterSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final MutableScatterMap<Object, Object> derivedStates;
    private final MutableScatterSet<RecomposeScopeImpl> invalidatedScopes;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private MutableScatterMap<Object, Object> invalidations;
    private final boolean isRoot;
    private final ChangeList lateChanges;
    private final Object lock;
    private final MutableScatterMap<Object, Object> observations;
    private final MutableScatterMap<Object, Object> observationsProcessed;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private PausedCompositionImpl pendingPausedComposition;
    private final RememberEventDispatcher rememberManager;
    private ShouldPauseCallback shouldPause;
    private final SlotTable slotTable;
    private int state;

    public CompositionImpl(CompositionContext compositionContext, Applier<?> applier, H7.h hVar) {
        this.parent = compositionContext;
        this.applier = applier;
        kotlin.jvm.internal.e eVar = null;
        this.pendingModifications = new AtomicReference<>(null);
        this.lock = new Object();
        int i = 0;
        int i6 = 1;
        Set<RememberObserver> setAsMutableSet = new MutableScatterSet(i, i6, eVar).asMutableSet();
        this.abandonSet = setAsMutableSet;
        SlotTable slotTable = new SlotTable();
        if (compositionContext.getCollectingCallByInformation$runtime()) {
            slotTable.collectCalledByInformation();
        }
        if (compositionContext.getCollectingSourceInformation()) {
            slotTable.collectSourceInformation();
        }
        this.slotTable = slotTable;
        this.observations = ScopeMap.m3574constructorimpl$default(null, 1, null);
        this.invalidatedScopes = new MutableScatterSet<>(i, i6, eVar);
        this.conditionallyInvalidatedScopes = new MutableScatterSet<>(i, i6, eVar);
        this.derivedStates = ScopeMap.m3574constructorimpl$default(null, 1, null);
        ChangeList changeList = new ChangeList();
        this.changes = changeList;
        ChangeList changeList2 = new ChangeList();
        this.lateChanges = changeList2;
        this.observationsProcessed = ScopeMap.m3574constructorimpl$default(null, 1, null);
        this.invalidations = ScopeMap.m3574constructorimpl$default(null, 1, null);
        CompositionObserverHolder compositionObserverHolder = new CompositionObserverHolder(null, false, compositionContext, 3, null);
        this.observerHolder = compositionObserverHolder;
        this.rememberManager = new RememberEventDispatcher();
        ComposerImpl composerImpl = new ComposerImpl(applier, compositionContext, slotTable, setAsMutableSet, changeList, changeList2, compositionObserverHolder, this);
        compositionContext.registerComposer$runtime(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = hVar;
        this.isRoot = compositionContext instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.getLambda$954879418$runtime();
    }

    private final void addPendingInvalidationsLocked(Object value, boolean forgetConditionalScopes) {
        Object obj = this.observations.get(value);
        if (obj == null) {
            return;
        }
        if (!(obj instanceof MutableScatterSet)) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
            if (ScopeMap.m3581removeimpl(this.observationsProcessed, value, recomposeScopeImpl) || recomposeScopeImpl.invalidateForResult(value) == InvalidationResult.IGNORED) {
                return;
            }
            if (!recomposeScopeImpl.isConditional() || forgetConditionalScopes) {
                this.invalidatedScopes.add(recomposeScopeImpl);
                return;
            } else {
                this.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                return;
            }
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
        Object[] objArr = mutableScatterSet.elements;
        long[] jArr = mutableScatterSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) objArr[(i << 3) + i10];
                        if (!ScopeMap.m3581removeimpl(this.observationsProcessed, value, recomposeScopeImpl2) && recomposeScopeImpl2.invalidateForResult(value) != InvalidationResult.IGNORED) {
                            if (!recomposeScopeImpl2.isConditional() || forgetConditionalScopes) {
                                this.invalidatedScopes.add(recomposeScopeImpl2);
                            } else {
                                this.conditionallyInvalidatedScopes.add(recomposeScopeImpl2);
                            }
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    private final void applyChangesInLocked(ChangeList changes) {
        Applier<?> pausableApplier$runtime;
        RememberEventDispatcher rememberManager$runtime;
        long[] jArr;
        long[] jArr2;
        long j5;
        char c;
        long j6;
        int i;
        boolean zIsEmpty;
        long[] jArr3;
        this.rememberManager.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
        try {
            if (changes.isEmpty()) {
                try {
                    if (this.lateChanges.isEmpty() && this.pendingPausedComposition == null) {
                        this.rememberManager.dispatchAbandons();
                    }
                } finally {
                }
            } else {
                Trace trace = Trace.INSTANCE;
                Object objBeginSection = trace.beginSection("Compose:applyChanges");
                try {
                    PausedCompositionImpl pausedCompositionImpl = this.pendingPausedComposition;
                    if (pausedCompositionImpl == null || (pausableApplier$runtime = pausedCompositionImpl.getPausableApplier$runtime()) == null) {
                        pausableApplier$runtime = this.applier;
                    }
                    PausedCompositionImpl pausedCompositionImpl2 = this.pendingPausedComposition;
                    if (pausedCompositionImpl2 == null || (rememberManager$runtime = pausedCompositionImpl2.getRememberManager()) == null) {
                        rememberManager$runtime = this.rememberManager;
                    }
                    pausableApplier$runtime.onBeginChanges();
                    SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                    int i6 = 0;
                    try {
                        changes.executeAndFlushAllPendingChanges(pausableApplier$runtime, slotWriterOpenWriter, rememberManager$runtime, this.composer.getErrorContext$runtime());
                        slotWriterOpenWriter.close(true);
                        pausableApplier$runtime.onEndChanges();
                        trace.endSection(objBeginSection);
                        this.rememberManager.dispatchRememberObservers();
                        this.rememberManager.dispatchSideEffects();
                        if (this.pendingInvalidScopes) {
                            objBeginSection = trace.beginSection("Compose:unobserve");
                            try {
                                this.pendingInvalidScopes = false;
                                MutableScatterMap<Object, Object> mutableScatterMap = this.observations;
                                long[] jArr4 = mutableScatterMap.metadata;
                                int length = jArr4.length - 2;
                                if (length >= 0) {
                                    int i10 = 0;
                                    while (true) {
                                        long j10 = jArr4[i10];
                                        char c2 = 7;
                                        long j11 = -9187201950435737472L;
                                        if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i11 = 8;
                                            int i12 = 8 - ((~(i10 - length)) >>> 31);
                                            int i13 = i6;
                                            while (i13 < i12) {
                                                if ((j10 & 255) < 128) {
                                                    int i14 = (i10 << 3) + i13;
                                                    c = c2;
                                                    Object obj = mutableScatterMap.keys[i14];
                                                    Object obj2 = mutableScatterMap.values[i14];
                                                    j6 = j11;
                                                    if (obj2 instanceof MutableScatterSet) {
                                                        kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                                        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                                        Object[] objArr = mutableScatterSet.elements;
                                                        long[] jArr5 = mutableScatterSet.metadata;
                                                        int length2 = jArr5.length - 2;
                                                        if (length2 >= 0) {
                                                            j5 = j10;
                                                            int i15 = i11;
                                                            int i16 = 0;
                                                            while (true) {
                                                                long j12 = jArr5[i16];
                                                                Object[] objArr2 = objArr;
                                                                long[] jArr6 = jArr5;
                                                                if ((((~j12) << c) & j12 & j6) != j6) {
                                                                    int i17 = 8 - ((~(i16 - length2)) >>> 31);
                                                                    int i18 = 0;
                                                                    while (i18 < i17) {
                                                                        if ((j12 & 255) < 128) {
                                                                            jArr3 = jArr4;
                                                                            int i19 = (i16 << 3) + i18;
                                                                            if (!((RecomposeScopeImpl) objArr2[i19]).getValid()) {
                                                                                mutableScatterSet.removeElementAt(i19);
                                                                            }
                                                                        } else {
                                                                            jArr3 = jArr4;
                                                                        }
                                                                        j12 >>= i15;
                                                                        i18++;
                                                                        jArr4 = jArr3;
                                                                    }
                                                                    jArr2 = jArr4;
                                                                    if (i17 != i15) {
                                                                        break;
                                                                    }
                                                                } else {
                                                                    jArr2 = jArr4;
                                                                }
                                                                if (i16 == length2) {
                                                                    break;
                                                                }
                                                                i16++;
                                                                objArr = objArr2;
                                                                jArr5 = jArr6;
                                                                jArr4 = jArr2;
                                                                i15 = 8;
                                                            }
                                                        } else {
                                                            jArr2 = jArr4;
                                                            j5 = j10;
                                                        }
                                                        zIsEmpty = mutableScatterSet.isEmpty();
                                                    } else {
                                                        jArr2 = jArr4;
                                                        j5 = j10;
                                                        kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                                        zIsEmpty = !((RecomposeScopeImpl) obj2).getValid();
                                                    }
                                                    if (zIsEmpty) {
                                                        mutableScatterMap.removeValueAt(i14);
                                                    }
                                                    i = 8;
                                                } else {
                                                    jArr2 = jArr4;
                                                    j5 = j10;
                                                    c = c2;
                                                    j6 = j11;
                                                    i = i11;
                                                }
                                                j10 = j5 >> i;
                                                i13++;
                                                i11 = i;
                                                c2 = c;
                                                j11 = j6;
                                                jArr4 = jArr2;
                                            }
                                            jArr = jArr4;
                                            if (i12 != i11) {
                                                break;
                                            }
                                        } else {
                                            jArr = jArr4;
                                        }
                                        if (i10 == length) {
                                            break;
                                        }
                                        i10++;
                                        jArr4 = jArr;
                                        i6 = 0;
                                    }
                                }
                                cleanUpDerivedStateObservations();
                                Trace.INSTANCE.endSection(objBeginSection);
                            } finally {
                                Trace.INSTANCE.endSection(objBeginSection);
                            }
                        }
                        try {
                            if (this.lateChanges.isEmpty() && this.pendingPausedComposition == null) {
                                this.rememberManager.dispatchAbandons();
                            }
                        } finally {
                        }
                    } catch (Throwable th) {
                        slotWriterOpenWriter.close(false);
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                if (this.lateChanges.isEmpty() && this.pendingPausedComposition == null) {
                    this.rememberManager.dispatchAbandons();
                }
                throw th3;
            } finally {
            }
        }
    }

    private final void cleanUpDerivedStateObservations() {
        char c;
        long j5;
        long j6;
        long j10;
        long[] jArr;
        long[] jArr2;
        long j11;
        int i;
        char c2;
        long j12;
        long j13;
        int i6;
        boolean zIsEmpty;
        long[] jArr3;
        int i10;
        int i11;
        MutableScatterMap<Object, Object> mutableScatterMap = this.derivedStates;
        long[] jArr4 = mutableScatterMap.metadata;
        int length = jArr4.length - 2;
        char c5 = 7;
        long j14 = -9187201950435737472L;
        int i12 = 8;
        if (length >= 0) {
            int i13 = 0;
            long j15 = 128;
            while (true) {
                long j16 = jArr4[i13];
                j6 = 255;
                if ((((~j16) << c5) & j16 & j14) != j14) {
                    int i14 = 8 - ((~(i13 - length)) >>> 31);
                    int i15 = 0;
                    while (i15 < i14) {
                        if ((j16 & 255) < j15) {
                            c2 = c5;
                            int i16 = (i13 << 3) + i15;
                            j12 = j14;
                            Object obj = mutableScatterMap.keys[i16];
                            Object obj2 = mutableScatterMap.values[i16];
                            if (obj2 instanceof MutableScatterSet) {
                                kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr = mutableScatterSet.elements;
                                long[] jArr5 = mutableScatterSet.metadata;
                                int length2 = jArr5.length - 2;
                                if (length2 >= 0) {
                                    j13 = j15;
                                    int i17 = 0;
                                    int i18 = i12;
                                    while (true) {
                                        int i19 = length2;
                                        long j17 = jArr5[i17];
                                        j11 = j16;
                                        if ((((~j17) << c2) & j17 & j12) != j12) {
                                            int i20 = 8 - ((~(i17 - i19)) >>> 31);
                                            int i21 = 0;
                                            while (i21 < i20) {
                                                if ((j17 & 255) < j13) {
                                                    jArr3 = jArr4;
                                                    int i22 = (i17 << 3) + i21;
                                                    i10 = i21;
                                                    i11 = i15;
                                                    if (!ScopeMap.m3575containsimpl(this.observations, (DerivedState) objArr[i22])) {
                                                        mutableScatterSet.removeElementAt(i22);
                                                    }
                                                } else {
                                                    jArr3 = jArr4;
                                                    i10 = i21;
                                                    i11 = i15;
                                                }
                                                j17 >>= i18;
                                                i21 = i10 + 1;
                                                i15 = i11;
                                                jArr4 = jArr3;
                                            }
                                            jArr2 = jArr4;
                                            i = i15;
                                            if (i20 != i18) {
                                                break;
                                            }
                                        } else {
                                            jArr2 = jArr4;
                                            i = i15;
                                        }
                                        length2 = i19;
                                        if (i17 == length2) {
                                            break;
                                        }
                                        i17++;
                                        j16 = j11;
                                        i15 = i;
                                        jArr4 = jArr2;
                                        i18 = 8;
                                    }
                                } else {
                                    jArr2 = jArr4;
                                    j11 = j16;
                                    i = i15;
                                    j13 = j15;
                                }
                                zIsEmpty = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr4;
                                j11 = j16;
                                i = i15;
                                j13 = j15;
                                kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                zIsEmpty = !ScopeMap.m3575containsimpl(this.observations, (DerivedState) obj2);
                            }
                            if (zIsEmpty) {
                                mutableScatterMap.removeValueAt(i16);
                            }
                            i6 = 8;
                        } else {
                            jArr2 = jArr4;
                            j11 = j16;
                            i = i15;
                            c2 = c5;
                            j12 = j14;
                            j13 = j15;
                            i6 = i12;
                        }
                        j16 = j11 >> i6;
                        i15 = i + 1;
                        i12 = i6;
                        c5 = c2;
                        j14 = j12;
                        j15 = j13;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    c = c5;
                    j5 = j14;
                    j10 = j15;
                    if (i14 != i12) {
                        break;
                    }
                } else {
                    jArr = jArr4;
                    c = c5;
                    j5 = j14;
                    j10 = j15;
                }
                if (i13 == length) {
                    break;
                }
                i13++;
                c5 = c;
                j14 = j5;
                j15 = j10;
                jArr4 = jArr;
                i12 = 8;
            }
        } else {
            c = 7;
            j5 = -9187201950435737472L;
            j6 = 255;
            j10 = 128;
        }
        if (!this.conditionallyInvalidatedScopes.isNotEmpty()) {
            return;
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet2 = this.conditionallyInvalidatedScopes;
        Object[] objArr2 = mutableScatterSet2.elements;
        long[] jArr6 = mutableScatterSet2.metadata;
        int length3 = jArr6.length - 2;
        if (length3 < 0) {
            return;
        }
        int i23 = 0;
        while (true) {
            long j18 = jArr6[i23];
            if ((((~j18) << c) & j18 & j5) != j5) {
                int i24 = 8 - ((~(i23 - length3)) >>> 31);
                for (int i25 = 0; i25 < i24; i25++) {
                    if ((j18 & j6) < j10) {
                        int i26 = (i23 << 3) + i25;
                        if (!((RecomposeScopeImpl) objArr2[i26]).isConditional()) {
                            mutableScatterSet2.removeElementAt(i26);
                        }
                    }
                    j18 >>= 8;
                }
                if (i24 != 8) {
                    return;
                }
            }
            if (i23 == length3) {
                return;
            } else {
                i23++;
            }
        }
    }

    private final boolean clearDeactivated() {
        boolean z10;
        synchronized (this.lock) {
            z10 = true;
            if (this.state != 1) {
                z10 = false;
            }
            if (z10) {
                this.state = 0;
            }
        }
        return z10;
    }

    private final void composeInitial(n content) {
        this.composable = content;
        this.parent.composeInitial$runtime(this, content);
    }

    private final PausedComposition composeInitialPaused(boolean reusable, n content) {
        if (this.pendingPausedComposition != null) {
            PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
        }
        PausedCompositionImpl pausedCompositionImpl = new PausedCompositionImpl(this, this.parent, this.composer, this.abandonSet, content, reusable, this.applier, this.lock);
        this.pendingPausedComposition = pausedCompositionImpl;
        return pausedCompositionImpl;
    }

    private final void composeInitialWithReuse(n content) {
        this.composer.startReuseFromRoot();
        composeInitial(content);
        this.composer.endReuseFromRoot();
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object andSet = this.pendingModifications.getAndSet(CompositionKt.PendingApplyNoModifications);
        if (andSet != null) {
            if (andSet.equals(CompositionKt.PendingApplyNoModifications)) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set<? extends Object>) andSet, true);
                return;
            }
            if (!(andSet instanceof Object[])) {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new KotlinNothingValueException();
            }
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, true);
            }
        }
    }

    private final void drainPendingModificationsLocked() {
        Object andSet = this.pendingModifications.getAndSet(null);
        if (kotlin.jvm.internal.k.b(andSet, CompositionKt.PendingApplyNoModifications)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set<? extends Object>) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
            return;
        }
        if (andSet == null) {
            ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
        throw new KotlinNothingValueException();
    }

    private final void drainPendingModificationsOutOfBandLocked() {
        Object andSet = this.pendingModifications.getAndSet(EmptySet.f4895a);
        if (kotlin.jvm.internal.k.b(andSet, CompositionKt.PendingApplyNoModifications) || andSet == null) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set<? extends Object>) andSet, false);
            return;
        }
        if (!(andSet instanceof Object[])) {
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
        for (Set<? extends Object> set : (Set[]) andSet) {
            addPendingInvalidationsLocked(set, false);
        }
    }

    private final void ensureRunning() {
        int i = this.state;
        if (!(i == 0)) {
            PreconditionsKt.throwIllegalStateException(i != 1 ? i != 2 ? i != 3 ? "" : "The composition is disposed" : "A previous pausable composition for this composition was cancelled. This composition must be disposed." : "The composition should be activated before setting content.");
        }
        if (this.pendingPausedComposition == null) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
    }

    private static /* synthetic */ void getAbandonSet$annotations() {
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime();
    }

    public static /* synthetic */ void getPendingInvalidScopes$runtime$annotations() {
    }

    public static /* synthetic */ void getSlotTable$runtime$annotations() {
    }

    private final <T> T guardChanges(S7.a block) {
        try {
            return (T) block.invoke();
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                    } catch (Throwable th2) {
                        rememberEventDispatcher.clear();
                        throw th2;
                    }
                }
                throw th;
            } catch (Throwable th3) {
                this.abandonChanges();
                throw th3;
            }
        }
    }

    private final <T> T guardInvalidationsLocked(S7.k block) {
        MutableScatterMap<Object, Object> mutableScatterMapM3418takeInvalidationsafanTW4 = m3418takeInvalidationsafanTW4();
        try {
            return (T) block.invoke(ScopeMap.m3571boximpl(mutableScatterMapM3418takeInvalidationsafanTW4));
        } catch (Throwable th) {
            this.invalidations = mutableScatterMapM3418takeInvalidationsafanTW4;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a6 A[Catch: all -> 0x001e, EDGE_INSN: B:64:0x00a6->B:49:0x00a6 BREAK  A[LOOP:0: B:31:0x005d->B:45:0x009e], EDGE_INSN: B:65:0x00a6->B:49:0x00a6 BREAK  A[LOOP:0: B:31:0x005d->B:45:0x009e], TRY_LEAVE, TryCatch #0 {all -> 0x001e, blocks: (B:4:0x000b, B:6:0x0010, B:14:0x0023, B:16:0x0029, B:20:0x002f, B:21:0x0038, B:23:0x003c, B:24:0x0045, B:26:0x004d, B:28:0x0051, B:31:0x005d, B:33:0x006d, B:35:0x0079, B:37:0x0083, B:41:0x0092, B:45:0x009e, B:46:0x00a1, B:49:0x00a6), top: B:62:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.compose.runtime.InvalidationResult invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl r21, androidx.compose.runtime.Anchor r22, java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 198
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.Anchor, java.lang.Object):androidx.compose.runtime.InvalidationResult");
    }

    private final void invalidateScopeOfLocked(Object value) {
        Object obj = this.observations.get(value);
        if (obj == null) {
            return;
        }
        if (!(obj instanceof MutableScatterSet)) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
            if (recomposeScopeImpl.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                ScopeMap.m3568addimpl(this.observationsProcessed, value, recomposeScopeImpl);
                return;
            }
            return;
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
        Object[] objArr = mutableScatterSet.elements;
        long[] jArr = mutableScatterSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) objArr[(i << 3) + i10];
                        if (recomposeScopeImpl2.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                            ScopeMap.m3568addimpl(this.observationsProcessed, value, recomposeScopeImpl2);
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    private final CompositionObserver observer() {
        return this.observerHolder.current();
    }

    /* renamed from: takeInvalidations-afanTW4, reason: not valid java name */
    private final MutableScatterMap<Object, Object> m3418takeInvalidationsafanTW4() {
        MutableScatterMap<Object, Object> mutableScatterMap = this.invalidations;
        this.invalidations = ScopeMap.m3574constructorimpl$default(null, 1, null);
        return mutableScatterMap;
    }

    private final <T> T trackAbandonedValues(S7.a block) {
        try {
            return (T) block.invoke();
        } catch (Throwable th) {
            if (!this.abandonSet.isEmpty()) {
                RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                try {
                    rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                    rememberEventDispatcher.dispatchAbandons();
                } finally {
                    rememberEventDispatcher.clear();
                }
            }
            throw th;
        }
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl scope, Object instance) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime(scope, instance);
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable) {
        Object[] slots = slotTable.getSlots();
        ArrayList arrayList = new ArrayList();
        for (Object obj : slots) {
            RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
            if (recomposeScopeImpl != null) {
                arrayList.add(recomposeScopeImpl);
            }
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) arrayList.get(i);
            Anchor anchor = recomposeScopeImpl2.getAnchor();
            if (anchor != null && !slotTable.slotsOf$runtime(anchor.toIndexFor(slotTable)).contains(recomposeScopeImpl2)) {
                PreconditionsKt.throwIllegalStateException("Misaligned anchor " + anchor + " in scope " + recomposeScopeImpl2 + " encountered, scope found at " + q.u0(slotTable.getSlots(), recomposeScopeImpl2));
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        if (this.abandonSet.isEmpty()) {
            return;
        }
        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
        try {
            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
            rememberEventDispatcher.dispatchAbandons();
        } finally {
            rememberEventDispatcher.clear();
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                        } catch (Throwable th2) {
                            rememberEventDispatcher.clear();
                            throw th2;
                        }
                    }
                    throw th;
                } catch (Throwable th3) {
                    abandonChanges();
                    throw th3;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (this.lateChanges.isNotEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                        } catch (Throwable th2) {
                            rememberEventDispatcher.clear();
                            throw th2;
                        }
                    }
                    throw th;
                } finally {
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        RememberEventDispatcher rememberEventDispatcher;
        synchronized (this.lock) {
            try {
                this.composer.changesApplied$runtime();
                if (!this.abandonSet.isEmpty()) {
                    rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                    } finally {
                    }
                }
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                        } finally {
                        }
                    }
                    throw th;
                } catch (Throwable th2) {
                    abandonChanges();
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(n content) {
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                try {
                    this.composer.m3415composeContentZbOJvo$runtime(m3418takeInvalidationsafanTW4(), content, this.shouldPause);
                } finally {
                }
            }
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                    } catch (Throwable th2) {
                        rememberEventDispatcher.clear();
                        throw th2;
                    }
                }
                throw th;
            } catch (Throwable th3) {
                abandonChanges();
                throw th3;
            }
        }
    }

    public final int composerStacksSizes$runtime() {
        return this.composer.stacksSize$runtime();
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void deactivate() {
        synchronized (this.lock) {
            try {
                if (!(this.pendingPausedComposition == null)) {
                    PreconditionsKt.throwIllegalStateException("Deactivate is not supported while pausable composition is in progress");
                }
                boolean z10 = this.slotTable.getGroupsSize() > 0;
                if (z10 || !this.abandonSet.isEmpty()) {
                    Trace trace = Trace.INSTANCE;
                    Object objBeginSection = trace.beginSection("Compose:deactivate");
                    try {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            if (z10) {
                                this.applier.onBeginChanges();
                                SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                                try {
                                    ComposerKt.deactivateCurrentGroup(slotWriterOpenWriter, this.rememberManager);
                                    slotWriterOpenWriter.close(true);
                                    this.applier.onEndChanges();
                                    rememberEventDispatcher.dispatchRememberObservers();
                                } catch (Throwable th) {
                                    slotWriterOpenWriter.close(false);
                                    throw th;
                                }
                            }
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                            trace.endSection(objBeginSection);
                        } catch (Throwable th2) {
                            rememberEventDispatcher.clear();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        Trace.INSTANCE.endSection(objBeginSection);
                        throw th3;
                    }
                }
                ScopeMap.m3572clearimpl(this.observations);
                ScopeMap.m3572clearimpl(this.derivedStates);
                ScopeMap.m3572clearimpl(this.invalidations);
                this.changes.clear();
                this.lateChanges.clear();
                this.composer.deactivate$runtime();
                this.state = 1;
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(ControlledComposition to, int groupIndex, S7.a block) {
        if (to == null || to.equals(this) || groupIndex < 0) {
            return (R) block.invoke();
        }
        this.invalidationDelegate = (CompositionImpl) to;
        this.invalidationDelegateGroup = groupIndex;
        try {
            return (R) block.invoke();
        } finally {
            this.invalidationDelegate = null;
            this.invalidationDelegateGroup = 0;
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        synchronized (this.lock) {
            try {
                if (this.composer.getIsComposing()) {
                    PreconditionsKt.throwIllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
                }
                if (this.state != 3) {
                    this.state = 3;
                    this.composable = ComposableSingletons$CompositionKt.INSTANCE.getLambda$1918065384$runtime();
                    ChangeList deferredChanges = this.composer.getDeferredChanges();
                    if (deferredChanges != null) {
                        applyChangesInLocked(deferredChanges);
                    }
                    boolean z10 = this.slotTable.getGroupsSize() > 0;
                    if (z10 || !this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            if (z10) {
                                this.applier.onBeginChanges();
                                SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                                try {
                                    ComposerKt.removeCurrentGroup(slotWriterOpenWriter, this.rememberManager);
                                    slotWriterOpenWriter.close(true);
                                    this.applier.clear();
                                    this.applier.onEndChanges();
                                    rememberEventDispatcher.dispatchRememberObservers();
                                } catch (Throwable th) {
                                    slotWriterOpenWriter.close(false);
                                    throw th;
                                }
                            }
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                        } catch (Throwable th2) {
                            rememberEventDispatcher.clear();
                            throw th2;
                        }
                    }
                    this.composer.dispose$runtime();
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        this.parent.unregisterComposition$runtime(this);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(MovableContentState state) {
        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
        try {
            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
            SlotWriter slotWriterOpenWriter = state.getSlotTable().openWriter();
            try {
                ComposerKt.removeCurrentGroup(slotWriterOpenWriter, this.rememberManager);
                slotWriterOpenWriter.close(true);
                rememberEventDispatcher.dispatchRememberObservers();
            } catch (Throwable th) {
                slotWriterOpenWriter.close(false);
                throw th;
            }
        } finally {
            rememberEventDispatcher.clear();
        }
    }

    public final List<Pair<RecomposeScopeImpl, Object>> extractInvalidationsOf$runtime(Anchor anchor) {
        long[] jArr;
        long[] jArr2;
        long j5;
        char c;
        long j6;
        int i;
        int i6;
        boolean zIsEmpty;
        Object obj;
        Object obj2;
        long j10;
        int i10;
        if (ScopeMap.m3579getSizeimpl(this.invalidations) <= 0) {
            return EmptyList.f4893a;
        }
        ArrayList arrayList = new ArrayList();
        SlotTable slotTable = this.slotTable;
        MutableScatterMap<Object, Object> mutableScatterMap = this.invalidations;
        long[] jArr3 = mutableScatterMap.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                long j11 = jArr3[i11];
                char c2 = 7;
                long j12 = -9187201950435737472L;
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8;
                    int i13 = 8 - ((~(i11 - length)) >>> 31);
                    int i14 = 0;
                    while (i14 < i13) {
                        if ((j11 & 255) < 128) {
                            int i15 = (i11 << 3) + i14;
                            c = c2;
                            Object obj3 = mutableScatterMap.keys[i15];
                            j6 = j12;
                            Object obj4 = mutableScatterMap.values[i15];
                            kotlin.jvm.internal.k.d(obj3, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                            if (obj4 instanceof MutableScatterSet) {
                                kotlin.jvm.internal.k.d(obj4, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj4;
                                Object[] objArr = mutableScatterSet.elements;
                                int i16 = i12;
                                long[] jArr4 = mutableScatterSet.metadata;
                                jArr2 = jArr3;
                                int length2 = jArr4.length - 2;
                                j5 = j11;
                                if (length2 >= 0) {
                                    Object obj5 = obj3;
                                    int i17 = 0;
                                    while (true) {
                                        long j13 = jArr4[i17];
                                        Object[] objArr2 = objArr;
                                        i = i14;
                                        if ((((~j13) << c) & j13 & j6) != j6) {
                                            int i18 = 8 - ((~(i17 - length2)) >>> 31);
                                            int i19 = 0;
                                            while (i19 < i18) {
                                                if ((j13 & 255) < 128) {
                                                    obj2 = obj5;
                                                    int i20 = (i17 << 3) + i19;
                                                    j10 = j13;
                                                    Object obj6 = objArr2[i20];
                                                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj2;
                                                    i10 = i19;
                                                    Anchor anchor2 = recomposeScopeImpl.getAnchor();
                                                    if (anchor2 != null && slotTable.inGroup(anchor, anchor2)) {
                                                        arrayList.add(new Pair(recomposeScopeImpl, obj6));
                                                        mutableScatterSet.removeElementAt(i20);
                                                    }
                                                } else {
                                                    obj2 = obj5;
                                                    j10 = j13;
                                                    i10 = i19;
                                                }
                                                j13 = j10 >> i16;
                                                i19 = i10 + 1;
                                                obj5 = obj2;
                                            }
                                            obj = obj5;
                                            if (i18 != i16) {
                                                break;
                                            }
                                        } else {
                                            obj = obj5;
                                        }
                                        if (i17 == length2) {
                                            break;
                                        }
                                        i17++;
                                        i14 = i;
                                        objArr = objArr2;
                                        obj5 = obj;
                                        i16 = 8;
                                    }
                                } else {
                                    i = i14;
                                }
                                zIsEmpty = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr3;
                                j5 = j11;
                                i = i14;
                                kotlin.jvm.internal.k.d(obj4, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj3;
                                Anchor anchor3 = recomposeScopeImpl2.getAnchor();
                                if (anchor3 == null || !slotTable.inGroup(anchor, anchor3)) {
                                    zIsEmpty = false;
                                } else {
                                    arrayList.add(new Pair(recomposeScopeImpl2, obj4));
                                    zIsEmpty = true;
                                }
                            }
                            if (zIsEmpty) {
                                mutableScatterMap.removeValueAt(i15);
                            }
                            i6 = 8;
                        } else {
                            jArr2 = jArr3;
                            j5 = j11;
                            c = c2;
                            j6 = j12;
                            i = i14;
                            i6 = i12;
                        }
                        i14 = i + 1;
                        i12 = i6;
                        j11 = j5 >> i6;
                        c2 = c;
                        j12 = j6;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i13 != i12) {
                        break;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i11 == length) {
                    break;
                }
                i11++;
                jArr3 = jArr;
            }
        }
        return arrayList;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public ShouldPauseCallback getAndSetShouldPauseCallback(ShouldPauseCallback shouldPause) {
        ShouldPauseCallback shouldPauseCallback = this.shouldPause;
        this.shouldPause = shouldPause;
        return shouldPauseCallback;
    }

    public final n getComposable() {
        return this.composable;
    }

    /* renamed from: getComposer$runtime, reason: from getter */
    public final ComposerImpl getComposer() {
        return this.composer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.CompositionServices
    public <T> T getCompositionService(CompositionServiceKey<T> key) {
        if (kotlin.jvm.internal.k.b(key, CompositionKt.getObservableCompositionServiceKey())) {
            return this;
        }
        return null;
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime() {
        return v.f1(this.conditionallyInvalidatedScopes.asSet());
    }

    public final Set<Object> getDerivedStateDependencies$runtime() {
        return this.derivedStates.asMap().keySet();
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z10;
        synchronized (this.lock) {
            z10 = ScopeMap.m3579getSizeimpl(this.invalidations) > 0;
        }
        return z10;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime;
        synchronized (this.lock) {
            hasPendingChanges$runtime = this.composer.getHasPendingChanges$runtime();
        }
        return hasPendingChanges$runtime;
    }

    public final Set<Object> getObservedObjects$runtime() {
        return this.observations.asMap().keySet();
    }

    /* renamed from: getObserverHolder$runtime, reason: from getter */
    public final CompositionObserverHolder getObserverHolder() {
        return this.observerHolder;
    }

    public final CompositionContext getParent() {
        return this.parent;
    }

    /* renamed from: getPendingInvalidScopes$runtime, reason: from getter */
    public final boolean getPendingInvalidScopes() {
        return this.pendingInvalidScopes;
    }

    public final H7.h getRecomposeContext() {
        H7.h hVar = this._recomposeContext;
        return hVar == null ? this.parent.getRecomposeCoroutineContext$runtime() : hVar;
    }

    /* renamed from: getSlotTable$runtime, reason: from getter */
    public final SlotTable getSlotTable() {
        return this.slotTable;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        int size = references.size();
        boolean z10 = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z10 = true;
                break;
            } else if (!kotlin.jvm.internal.k.b(((MovableContentStateReference) references.get(i).f4886a).getComposition(), this)) {
                break;
            } else {
                i++;
            }
        }
        if (!z10) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        try {
            this.composer.insertMovableContentReferences(references);
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                    } catch (Throwable th2) {
                        rememberEventDispatcher.clear();
                        throw th2;
                    }
                }
                throw th;
            } catch (Throwable th3) {
                abandonChanges();
                throw th3;
            }
        }
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
        CompositionObserver compositionObserverObserver;
        CompositionImpl compositionImpl;
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(true);
        }
        Anchor anchor = scope.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (!this.slotTable.ownsAnchor(anchor)) {
            synchronized (this.lock) {
                compositionImpl = this.invalidationDelegate;
            }
            return (compositionImpl == null || !compositionImpl.tryImminentInvalidation(scope, instance)) ? InvalidationResult.IGNORED : InvalidationResult.IMMINENT;
        }
        if (!scope.getCanRecompose()) {
            return InvalidationResult.IGNORED;
        }
        InvalidationResult invalidationResultInvalidateChecked = invalidateChecked(scope, anchor, instance);
        if (invalidationResultInvalidateChecked != InvalidationResult.IGNORED && (compositionObserverObserver = observer()) != null) {
            compositionObserverObserver.onScopeInvalidated(scope, instance);
        }
        return invalidationResultInvalidateChecked;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        synchronized (this.lock) {
            try {
                for (Object obj : this.slotTable.getSlots()) {
                    RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                    if (recomposeScopeImpl != null) {
                        recomposeScopeImpl.invalidate();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void invalidateGroupsWithKey(int key) {
        List<RecomposeScopeImpl> listInvalidateGroupsWithKey$runtime;
        synchronized (this.lock) {
            listInvalidateGroupsWithKey$runtime = this.slotTable.invalidateGroupsWithKey$runtime(key);
        }
        if (listInvalidateGroupsWithKey$runtime != null) {
            int size = listInvalidateGroupsWithKey$runtime.size();
            for (int i = 0; i < size; i++) {
                if (listInvalidateGroupsWithKey$runtime.get(i).invalidateForResult(null) != InvalidationResult.IGNORED) {
                }
            }
            return;
        }
        if (this.composer.forceRecomposeScopes$runtime()) {
            this.parent.invalidate$runtime(this);
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.getIsComposing();
    }

    @Override // androidx.compose.runtime.Composition
    public boolean isDisposed() {
        return this.state == 3;
    }

    /* renamed from: isRoot, reason: from getter */
    public final boolean getIsRoot() {
        return this.isRoot;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean observesAnyOf(java.util.Set<? extends java.lang.Object> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof androidx.compose.runtime.collection.ScatterSetWrapper
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5c
            androidx.compose.runtime.collection.ScatterSetWrapper r15 = (androidx.compose.runtime.collection.ScatterSetWrapper) r15
            androidx.collection.ScatterSet r15 = r15.getSet$runtime()
            java.lang.Object[] r0 = r15.elements
            long[] r15 = r15.metadata
            int r3 = r15.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L7d
            r4 = r1
        L16:
            r5 = r15[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L57
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r1
        L30:
            if (r9 >= r7) goto L55
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L51
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r0[r10]
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r11 = r14.observations
            boolean r11 = androidx.compose.runtime.collection.ScopeMap.m3575containsimpl(r11, r10)
            if (r11 != 0) goto L50
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r11 = r14.derivedStates
            boolean r10 = androidx.compose.runtime.collection.ScopeMap.m3575containsimpl(r11, r10)
            if (r10 == 0) goto L51
        L50:
            return r2
        L51:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L30
        L55:
            if (r7 != r8) goto L7d
        L57:
            if (r4 == r3) goto L7d
            int r4 = r4 + 1
            goto L16
        L5c:
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.Iterator r15 = r15.iterator()
        L62:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L7d
            java.lang.Object r0 = r15.next()
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r3 = r14.observations
            boolean r3 = androidx.compose.runtime.collection.ScopeMap.m3575containsimpl(r3, r0)
            if (r3 != 0) goto L7c
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r3 = r14.derivedStates
            boolean r0 = androidx.compose.runtime.collection.ScopeMap.m3575containsimpl(r3, r0)
            if (r0 == 0) goto L62
        L7c:
            return r2
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.observesAnyOf(java.util.Set):boolean");
    }

    public final void pausedCompositionFinished$runtime(ScatterSet<RememberObserverHolder> ignoreSet) {
        this.pendingPausedComposition = null;
        if (ignoreSet != null) {
            this.rememberManager.ignoreForgotten(ignoreSet);
            this.state = 2;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(S7.a block) {
        this.composer.prepareCompose$runtime(block);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        synchronized (this.lock) {
            PausedCompositionImpl pausedCompositionImpl = this.pendingPausedComposition;
            if (pausedCompositionImpl != null && !pausedCompositionImpl.isRecomposing$runtime()) {
                pausedCompositionImpl.markIncomplete$runtime();
                return false;
            }
            drainPendingModificationsForCompositionLocked();
            try {
                MutableScatterMap<Object, Object> mutableScatterMapM3418takeInvalidationsafanTW4 = m3418takeInvalidationsafanTW4();
                try {
                    boolean zM3416recomposeaFTiNEg$runtime = this.composer.m3416recomposeaFTiNEg$runtime(mutableScatterMapM3418takeInvalidationsafanTW4, this.shouldPause);
                    if (!zM3416recomposeaFTiNEg$runtime) {
                        drainPendingModificationsLocked();
                    }
                    return zM3416recomposeaFTiNEg$runtime;
                } catch (Throwable th) {
                    this.invalidations = mutableScatterMapM3418takeInvalidationsafanTW4;
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                        } catch (Throwable th3) {
                            rememberEventDispatcher.clear();
                            throw th3;
                        }
                    }
                    throw th2;
                } catch (Throwable th4) {
                    abandonChanges();
                    throw th4;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public void recomposeScopeReleased(RecomposeScopeImpl scope) {
        this.pendingInvalidScopes = true;
        CompositionObserver compositionObserverObserver = observer();
        if (compositionObserverObserver != null) {
            compositionObserverObserver.onScopeDisposed(scope);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.Set[]] */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(Set<? extends Object> values) {
        Object obj;
        Set<? extends Object> set;
        do {
            obj = this.pendingModifications.get();
            if (obj == null || obj.equals(CompositionKt.PendingApplyNoModifications)) {
                set = values;
            } else if (obj instanceof Set) {
                set = new Set[]{obj, values};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                }
                Set[] setArr = (Set[]) obj;
                int length = setArr.length;
                ?? CopyOf = Arrays.copyOf(setArr, length + 1);
                CopyOf[length] = values;
                set = CopyOf;
            }
        } while (!this.pendingModifications.compareAndSet(obj, set));
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    public void recordReadOf(Object value) {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        int i;
        int i6;
        int i10;
        if (getAreChildrenComposing() || (currentRecomposeScope$runtime = this.composer.getCurrentRecomposeScope$runtime()) == null) {
            return;
        }
        int i11 = 1;
        currentRecomposeScope$runtime.setUsed(true);
        boolean zRecordRead = currentRecomposeScope$runtime.recordRead(value);
        CompositionObserver compositionObserverObserver = observer();
        if (compositionObserverObserver != null) {
            compositionObserverObserver.onReadInScope(currentRecomposeScope$runtime, value);
        }
        if (zRecordRead) {
            return;
        }
        if (value instanceof StateObjectImpl) {
            ((StateObjectImpl) value).m3611recordReadInh_f27i8$runtime(ReaderKind.m3598constructorimpl(1));
        }
        ScopeMap.m3568addimpl(this.observations, value, currentRecomposeScope$runtime);
        if (value instanceof DerivedState) {
            DerivedState<?> derivedState = (DerivedState) value;
            DerivedState.Record<?> currentRecord = derivedState.getCurrentRecord();
            ScopeMap.m3583removeScopeimpl(this.derivedStates, value);
            ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
            Object[] objArr = dependencies.keys;
            long[] jArr = dependencies.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i12 = 0;
                while (true) {
                    long j5 = jArr[i12];
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i13 = 8;
                        int i14 = 8 - ((~(i12 - length)) >>> 31);
                        int i15 = 0;
                        while (i15 < i14) {
                            if ((j5 & 255) < 128) {
                                i6 = i11;
                                StateObject stateObject = (StateObject) objArr[(i12 << 3) + i15];
                                if (stateObject instanceof StateObjectImpl) {
                                    i10 = i13;
                                    ((StateObjectImpl) stateObject).m3611recordReadInh_f27i8$runtime(ReaderKind.m3598constructorimpl(i6));
                                } else {
                                    i10 = i13;
                                }
                                ScopeMap.m3568addimpl(this.derivedStates, stateObject, value);
                            } else {
                                i6 = i11;
                                i10 = i13;
                            }
                            j5 >>= i10;
                            i15++;
                            i11 = i6;
                            i13 = i10;
                        }
                        i = i11;
                        if (i14 != i13) {
                            break;
                        }
                    } else {
                        i = i11;
                    }
                    if (i12 == length) {
                        break;
                    }
                    i12++;
                    i11 = i;
                }
            }
            currentRecomposeScope$runtime.recordDerivedStateValue(derivedState, currentRecord.getCurrentValue());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void recordWriteOf(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = r14.lock
            monitor-enter(r0)
            r14.invalidateScopeOfLocked(r15)     // Catch: java.lang.Throwable -> L4f
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r1 = r14.derivedStates     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r15 = r1.get(r15)     // Catch: java.lang.Throwable -> L4f
            if (r15 == 0) goto L61
            boolean r1 = r15 instanceof androidx.collection.MutableScatterSet     // Catch: java.lang.Throwable -> L4f
            if (r1 == 0) goto L5c
            androidx.collection.MutableScatterSet r15 = (androidx.collection.MutableScatterSet) r15     // Catch: java.lang.Throwable -> L4f
            java.lang.Object[] r1 = r15.elements     // Catch: java.lang.Throwable -> L4f
            long[] r15 = r15.metadata     // Catch: java.lang.Throwable -> L4f
            int r2 = r15.length     // Catch: java.lang.Throwable -> L4f
            int r2 = r2 + (-2)
            if (r2 < 0) goto L61
            r3 = 0
            r4 = r3
        L1f:
            r5 = r15[r4]     // Catch: java.lang.Throwable -> L4f
            long r7 = ~r5     // Catch: java.lang.Throwable -> L4f
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L57
            int r7 = r4 - r2
            int r7 = ~r7     // Catch: java.lang.Throwable -> L4f
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L39:
            if (r9 >= r7) goto L55
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L51
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]     // Catch: java.lang.Throwable -> L4f
            androidx.compose.runtime.DerivedState r10 = (androidx.compose.runtime.DerivedState) r10     // Catch: java.lang.Throwable -> L4f
            r14.invalidateScopeOfLocked(r10)     // Catch: java.lang.Throwable -> L4f
            goto L51
        L4f:
            r14 = move-exception
            goto L63
        L51:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L39
        L55:
            if (r7 != r8) goto L61
        L57:
            if (r4 == r2) goto L61
            int r4 = r4 + 1
            goto L1f
        L5c:
            androidx.compose.runtime.DerivedState r15 = (androidx.compose.runtime.DerivedState) r15     // Catch: java.lang.Throwable -> L4f
            r14.invalidateScopeOfLocked(r15)     // Catch: java.lang.Throwable -> L4f
        L61:
            monitor-exit(r0)
            return
        L63:
            monitor-exit(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.recordWriteOf(java.lang.Object):void");
    }

    public final void removeDerivedStateObservation$runtime(DerivedState<?> state) {
        if (ScopeMap.m3575containsimpl(this.observations, state)) {
            return;
        }
        ScopeMap.m3583removeScopeimpl(this.derivedStates, state);
    }

    public final void removeObservation$runtime(Object instance, RecomposeScopeImpl scope) {
        ScopeMap.m3581removeimpl(this.observations, instance, scope);
    }

    public final void setComposable(n nVar) {
        this.composable = nVar;
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(n content) {
        boolean zClearDeactivated = clearDeactivated();
        ensureRunning();
        if (zClearDeactivated) {
            composeInitialWithReuse(content);
        } else {
            composeInitial(content);
        }
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void setContentWithReuse(n content) {
        clearDeactivated();
        ensureRunning();
        composeInitialWithReuse(content);
    }

    @Override // androidx.compose.runtime.tooling.ObservableComposition
    public CompositionObserverHandle setObserver(final CompositionObserver observer) {
        synchronized (this.lock) {
            this.observerHolder.setObserver(observer);
            this.observerHolder.setRoot(true);
        }
        return new CompositionObserverHandle() { // from class: androidx.compose.runtime.CompositionImpl.setObserver.2
            @Override // androidx.compose.runtime.tooling.CompositionObserverHandle
            public void dispose() {
                Object obj = CompositionImpl.this.lock;
                CompositionImpl compositionImpl = CompositionImpl.this;
                CompositionObserver compositionObserver = observer;
                synchronized (obj) {
                    if (kotlin.jvm.internal.k.b(compositionImpl.getObserverHolder().getObserver(), compositionObserver)) {
                        compositionImpl.getObserverHolder().setObserver(null);
                        compositionImpl.getObserverHolder().setRoot(false);
                    }
                }
            }
        };
    }

    @Override // androidx.compose.runtime.PausableComposition
    public PausedComposition setPausableContent(n content) {
        return composeInitialPaused(clearDeactivated(), content);
    }

    @Override // androidx.compose.runtime.PausableComposition
    public PausedComposition setPausableContentWithReuse(n content) {
        clearDeactivated();
        ensureRunning();
        return composeInitialPaused(true, content);
    }

    public final void setPendingInvalidScopes$runtime(boolean z10) {
        this.pendingInvalidScopes = z10;
    }

    public final void updateMovingInvalidations$runtime() {
        synchronized (this.lock) {
            drainPendingModificationsOutOfBandLocked();
            try {
                this.composer.m3417updateComposerInvalidationsRY85e9Y(m3418takeInvalidationsafanTW4());
            } finally {
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void verifyConsistent() {
        synchronized (this.lock) {
            if (!isComposing()) {
                this.composer.verifyConsistent$runtime();
                this.slotTable.verifyWellFormed();
                validateRecomposeScopeAnchors(this.slotTable);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0176 A[EDGE_INSN: B:70:0x0176->B:219:0x0113 BREAK  A[LOOP:13: B:60:0x0144->B:71:0x0178]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void addPendingInvalidationsLocked(java.util.Set<? extends java.lang.Object> r36, boolean r37) {
        /*
            Method dump skipped, instructions count: 925
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.addPendingInvalidationsLocked(java.util.Set, boolean):void");
    }

    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier, H7.h hVar, int i, kotlin.jvm.internal.e eVar) {
        this(compositionContext, applier, (i & 4) != 0 ? null : hVar);
    }
}
