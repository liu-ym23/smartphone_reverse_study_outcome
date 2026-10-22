package androidx.collection;

import C7.r;
import D7.q;
import S7.k;
import S7.n;
import S7.p;
import androidx.annotation.IntRange;
import androidx.appfunctions.metadata.a;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.compose.foundation.text.selection.SingleSelectionLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import i9.i;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u001c\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001By\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0004\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u0007\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\t\u0012(\b\u0002\u0010\u000e\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0012J\r\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0012J\u001a\u0010\u0017\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u001a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u0001H\u0086\n¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010!\u001a\u00020\r2\u001a\u0010 \u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f0\u001e¢\u0006\u0004\b!\u0010\"J'\u0010!\u001a\u00020\r2\u0018\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f0#¢\u0006\u0004\b!\u0010$J'\u0010!\u001a\u00020\r2\u0018\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f0%¢\u0006\u0004\b!\u0010&J!\u0010!\u001a\u00020\r2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'¢\u0006\u0004\b!\u0010)J!\u0010!\u001a\u00020\r2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*¢\u0006\u0004\b!\u0010+J!\u0010!\u001a\u00020\r2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\b!\u0010,J$\u0010.\u001a\u00020\r2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001fH\u0086\n¢\u0006\u0004\b.\u0010/J,\u0010.\u001a\u00020\r2\u001a\u0010 \u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f0\u001eH\u0086\n¢\u0006\u0004\b.\u0010\"J*\u0010.\u001a\u00020\r2\u0018\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f0#H\u0086\n¢\u0006\u0004\b.\u0010$J*\u0010.\u001a\u00020\r2\u0018\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f0%H\u0086\n¢\u0006\u0004\b.\u0010&J$\u0010.\u001a\u00020\r2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'H\u0086\n¢\u0006\u0004\b.\u0010)J$\u0010.\u001a\u00020\r2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*H\u0086\n¢\u0006\u0004\b.\u0010+J$\u0010.\u001a\u00020\r2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0086\n¢\u0006\u0004\b.\u0010,J\u0017\u00100\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0004\b0\u0010\u0018J\u001d\u00100\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u0001¢\u0006\u0004\b0\u00101J'\u00103\u001a\u00020\r2\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b3\u00104J\u0018\u00105\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\b5\u00106J \u00105\u001a\u00020\r2\u000e\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001eH\u0086\n¢\u0006\u0004\b5\u00108J\u001e\u00105\u001a\u00020\r2\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0086\n¢\u0006\u0004\b5\u0010$J\u001e\u00105\u001a\u00020\r2\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0086\n¢\u0006\u0004\b5\u0010&J\u001e\u00105\u001a\u00020\r2\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u000009H\u0086\n¢\u0006\u0004\b5\u0010:J\u001e\u00105\u001a\u00020\r2\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000;H\u0086\n¢\u0006\u0004\b5\u0010<J\r\u0010=\u001a\u00020\r¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\r2\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b?\u0010@J\u0015\u0010A\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bA\u0010@J-\u0010C\u001a\u00020\r2\u0018\u0010B\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\r0\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\bC\u00104J'\u0010D\u001a\u00020\r2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\tH\u0086\bø\u0001\u0000¢\u0006\u0004\bD\u0010EJ'\u0010F\u001a\u00020\r2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\r0\tH\u0086\bø\u0001\u0000¢\u0006\u0004\bF\u0010EJ-\u0010G\u001a\u00020\f2\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\bG\u0010HJ-\u0010\u0011\u001a\u00020\f2\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010HJ\r\u0010I\u001a\u00020\u0004¢\u0006\u0004\bI\u0010JJ-\u0010I\u001a\u00020\u00042\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\bI\u0010KJ\u0018\u0010L\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\bL\u0010MJ\u0015\u0010N\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0004\bN\u0010MJ\u0015\u0010O\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00028\u0001¢\u0006\u0004\bO\u0010MJ\u000f\u0010Q\u001a\u00020\rH\u0000¢\u0006\u0004\bP\u0010>J\u000f\u0010S\u001a\u00020\rH\u0000¢\u0006\u0004\bR\u0010>J\u0017\u0010V\u001a\u00020\r2\u0006\u0010T\u001a\u00020\u0004H\u0000¢\u0006\u0004\bU\u0010@J'\u0010W\u001a\u00020\r2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\tH\u0081\bø\u0001\u0000¢\u0006\u0004\bW\u0010EJ\u000f\u0010X\u001a\u00020\u0004H\u0016¢\u0006\u0004\bX\u0010JJ\u001a\u0010Z\u001a\u00020\f2\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\bZ\u0010MJ\u000f\u0010\\\u001a\u00020[H\u0016¢\u0006\u0004\b\\\u0010]J\u0017\u0010^\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b^\u0010@J\u0017\u0010`\u001a\u00020\r2\u0006\u0010_\u001a\u00020\u0004H\u0002¢\u0006\u0004\b`\u0010@J\u000f\u0010a\u001a\u00020\rH\u0002¢\u0006\u0004\ba\u0010>J\u000f\u0010b\u001a\u00020\u0004H\u0002¢\u0006\u0004\bb\u0010JJ\u0018\u0010d\u001a\u00020\r2\u0006\u0010c\u001a\u00020\u0004H\u0082\b¢\u0006\u0004\bd\u0010@J\u0019\u0010e\u001a\u0004\u0018\u00018\u00012\u0006\u0010c\u001a\u00020\u0004H\u0002¢\u0006\u0004\be\u0010fJ\u0018\u0010g\u001a\u00020\r2\u0006\u0010c\u001a\u00020\u0004H\u0082\b¢\u0006\u0004\bg\u0010@J\u0018\u0010h\u001a\u00020\r2\u0006\u0010c\u001a\u00020\u0004H\u0082\b¢\u0006\u0004\bh\u0010@J\u0017\u0010i\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0004\bi\u0010jJ\u0017\u0010k\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0004\bk\u0010jJ\u0017\u0010m\u001a\u00020\u00042\u0006\u0010l\u001a\u00020\u0004H\u0002¢\u0006\u0004\bm\u0010nJ\u0017\u0010q\u001a\u00020\r2\u0006\u0010p\u001a\u00020oH\u0002¢\u0006\u0004\bq\u0010rJ\u0017\u0010q\u001a\u00020\r2\u0006\u0010p\u001a\u00020sH\u0002¢\u0006\u0004\bq\u0010tR&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010uR\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010vR4\u0010\u000e\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010wR\u001c\u0010x\u001a\u00020o8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bx\u0010y\u0012\u0004\bz\u0010>R$\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b7\u0010{\u0012\u0004\b|\u0010>R$\u0010}\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b}\u0010{\u0012\u0004\b~\u0010>R\u0016\u0010\u007f\u001a\u00020o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010yR\u0019\u0010\u0080\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0019\u0010\u0082\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0081\u0001R\u0019\u0010\u0083\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0081\u0001R\u0019\u0010\u0084\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0081\u0001R\u0019\u0010\u0085\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0081\u0001R\u0019\u0010\u0086\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0081\u0001R\u0019\u0010\u0087\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0081\u0001R\u0019\u0010\u0088\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0081\u0001R\u0013\u0010\u008a\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b\u0089\u0001\u0010JR\u0012\u0010\u0005\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b\u008b\u0001\u0010JR\u001c\u0010I\u001a\u00020\u00048FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u008d\u0001\u0010>\u001a\u0005\b\u008c\u0001\u0010JR\u0012\u0010_\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b\u008e\u0001\u0010J\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008f\u0001"}, d2 = {"Landroidx/collection/SieveCache;", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "maxSize", "initialCapacity", "Lkotlin/Function2;", "sizeOf", "Lkotlin/Function1;", "createValueFromKey", "Lkotlin/Function4;", "", "LC7/r;", "onEntryRemoved", AppAgent.CONSTRUCT, "(IILS7/n;LS7/k;LS7/p;)V", "any", "()Z", "none", "isEmpty", "isNotEmpty", "key", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "Lkotlin/Pair;", "pairs", "putAll", "([Lkotlin/Pair;)V", "", "(Ljava/lang/Iterable;)V", "Li9/i;", "(Li9/i;)V", "", TypedValues.TransitionType.S_FROM, "(Ljava/util/Map;)V", "Landroidx/collection/ScatterMap;", "(Landroidx/collection/ScatterMap;)V", "(Landroidx/collection/SieveCache;)V", "pair", "plusAssign", "(Lkotlin/Pair;)V", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "predicate", "removeIf", "(LS7/n;)V", "minusAssign", "(Ljava/lang/Object;)V", "keys", "([Ljava/lang/Object;)V", "Landroidx/collection/ScatterSet;", "(Landroidx/collection/ScatterSet;)V", "Landroidx/collection/ObjectList;", "(Landroidx/collection/ObjectList;)V", "evictAll", "()V", "resize", "(I)V", "trimToSize", "block", "forEach", "forEachKey", "(LS7/k;)V", "forEachValue", "all", "(LS7/n;)Z", "count", "()I", "(LS7/n;)I", "contains", "(Ljava/lang/Object;)Z", "containsKey", "containsValue", "adjustStorage$collection", "adjustStorage", "dropDeletes$collection", "dropDeletes", "newCapacity", "resizeStorage$collection", "resizeStorage", "forEachIndexed", "hashCode", "other", "equals", "", "toString", "()Ljava/lang/String;", "initializeStorage", "capacity", "initializeMetadata", "initializeGrowth", "findEvictionCandidate", "index", "moveNodeToHead", "removeValueAt", "(I)Ljava/lang/Object;", "removeNode", "markNodeVisited", "findKeyIndex", "(Ljava/lang/Object;)I", "findInsertIndex", "hash1", "findFirstAvailableSlot", "(I)I", "", "mapping", "fixupNodes", "([J)V", "", "([I)V", "LS7/n;", "LS7/k;", "LS7/p;", "metadata", "[J", "getMetadata$annotations", "[Ljava/lang/Object;", "getKeys$annotations", "values", "getValues$annotations", "nodes", "_capacity", "I", "growthLimit", "_count", "_maxSize", "_size", "head", "tail", "hand", "getSize", "size", "getMaxSize", "getCount", "getCount$annotations", "getCapacity", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SieveCache<K, V> {
    private int _capacity;
    private int _count;
    private int _maxSize;
    private int _size;
    private final k createValueFromKey;
    private int growthLimit;
    private int hand;
    private int head;
    public Object[] keys;
    public long[] metadata;
    private long[] nodes;
    private final p onEntryRemoved;
    private final n sizeOf;
    private int tail;
    public Object[] values;

    public SieveCache(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID, to = 2147483646) int i, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = 2147483646) int i6, n sizeOf, k createValueFromKey, p onEntryRemoved) {
        kotlin.jvm.internal.k.f(sizeOf, "sizeOf");
        kotlin.jvm.internal.k.f(createValueFromKey, "createValueFromKey");
        kotlin.jvm.internal.k.f(onEntryRemoved, "onEntryRemoved");
        this.sizeOf = sizeOf;
        this.createValueFromKey = createValueFromKey;
        this.onEntryRemoved = onEntryRemoved;
        this.metadata = ScatterMapKt.EmptyGroup;
        Object[] objArr = ContainerHelpersKt.EMPTY_OBJECTS;
        this.keys = objArr;
        this.values = objArr;
        this.nodes = SieveCacheKt.getEmptyNodes();
        this.head = Integer.MAX_VALUE;
        this.tail = Integer.MAX_VALUE;
        this.hand = Integer.MAX_VALUE;
        if (!(i > 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("maxSize must be > 0");
        }
        this._maxSize = i;
        initializeStorage(ScatterMapKt.unloadedCapacity(i6));
    }

    private final int findEvictionCandidate() {
        long[] jArr = this.nodes;
        int i = this.hand;
        if (i == Integer.MAX_VALUE) {
            i = this.tail;
        }
        while (i != Integer.MAX_VALUE) {
            long j5 = jArr[i];
            if (((int) ((j5 >> 62) & 1)) == 0) {
                break;
            }
            int i6 = (int) (SieveCacheKt.NodeLinkMask & (j5 >> 31));
            jArr[i] = 4611686018427387903L & j5;
            i = i6 != Integer.MAX_VALUE ? i6 : this.tail;
        }
        int i10 = (int) (SieveCacheKt.NodeLinkMask & (jArr[i] >> 31));
        this.hand = i10 != Integer.MAX_VALUE ? i10 : Integer.MAX_VALUE;
        return i;
    }

    private final int findFirstAvailableSlot(int hash1) {
        int i = this._capacity;
        int i6 = hash1 & i;
        int i10 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i11 = i6 >> 3;
            int i12 = (i6 & 7) << 3;
            long j5 = ((jArr[i11 + 1] << (64 - i12)) & ((-i12) >> 63)) | (jArr[i11] >>> i12);
            long j6 = j5 & ((~j5) << 7) & (-9187201950435737472L);
            if (j6 != 0) {
                return (i6 + (Long.numberOfTrailingZeros(j6) >> 3)) & i;
            }
            i10 += 8;
            i6 = (i6 + i10) & i;
        }
    }

    private final int findInsertIndex(K key) {
        int iHashCode = (key != null ? key.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i = iHashCode ^ (iHashCode << 16);
        int i6 = i >>> 7;
        int i10 = i & 127;
        int i11 = this._capacity;
        int i12 = i6 & i11;
        int i13 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i14 = i12 >> 3;
            int i15 = (i12 & 7) << 3;
            long j5 = ((jArr[i14 + 1] << (64 - i15)) & ((-i15) >> 63)) | (jArr[i14] >>> i15);
            long j6 = i10;
            int i16 = i10;
            long j10 = j5 ^ (j6 * ScatterMapKt.BitmaskLsb);
            for (long j11 = (~j10) & (j10 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j11 != 0; j11 &= j11 - 1) {
                int iNumberOfTrailingZeros = (i12 + (Long.numberOfTrailingZeros(j11) >> 3)) & i11;
                if (kotlin.jvm.internal.k.b(this.keys[iNumberOfTrailingZeros], key)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j5) << 6) & j5 & (-9187201950435737472L)) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i6);
                if (this.growthLimit == 0 && ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage$collection();
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i6);
                }
                this._count++;
                int i17 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i18 = iFindFirstAvailableSlot >> 3;
                long j12 = jArr2[i18];
                int i19 = (iFindFirstAvailableSlot & 7) << 3;
                this.growthLimit = i17 - (((j12 >> i19) & 255) == 128 ? 1 : 0);
                int i20 = this._capacity;
                long j13 = ((~(255 << i19)) & j12) | (j6 << i19);
                jArr2[i18] = j13;
                jArr2[(((iFindFirstAvailableSlot - 7) & i20) + (i20 & 7)) >> 3] = j13;
                return ~iFindFirstAvailableSlot;
            }
            i13 += 8;
            i12 = (i12 + i13) & i11;
            i10 = i16;
        }
    }

    private final int findKeyIndex(K key) {
        int i = 0;
        int iHashCode = (key != null ? key.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i6 = iHashCode ^ (iHashCode << 16);
        int i10 = i6 & 127;
        int i11 = this._capacity;
        int i12 = i6 >>> 7;
        while (true) {
            int i13 = i12 & i11;
            long[] jArr = this.metadata;
            int i14 = i13 >> 3;
            int i15 = (i13 & 7) << 3;
            long j5 = ((jArr[i14 + 1] << (64 - i15)) & ((-i15) >> 63)) | (jArr[i14] >>> i15);
            long j6 = (i10 * ScatterMapKt.BitmaskLsb) ^ j5;
            for (long j10 = (~j6) & (j6 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j10 != 0; j10 &= j10 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j10) >> 3) + i13) & i11;
                if (kotlin.jvm.internal.k.b(this.keys[iNumberOfTrailingZeros], key)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j5 & ((~j5) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i += 8;
            i12 = i13 + i;
        }
    }

    private final void fixupNodes(long[] mapping) {
        long[] jArr = this.nodes;
        int length = jArr.length;
        int i = 0;
        while (true) {
            int i6 = Integer.MAX_VALUE;
            if (i >= length) {
                break;
            }
            long j5 = jArr[i];
            int i10 = (int) ((j5 >> 31) & SieveCacheKt.NodeLinkMask);
            int i11 = (int) (j5 & SieveCacheKt.NodeLinkMask);
            long j6 = ((j5 & SieveCacheKt.NodeMetaMask) | (i10 == Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) (mapping[i10] & 4294967295L))) << 31;
            if (i11 != Integer.MAX_VALUE) {
                i6 = (int) (4294967295L & mapping[i11]);
            }
            jArr[i] = i6 | j6;
            i++;
        }
        int i12 = this.head;
        if (i12 != Integer.MAX_VALUE) {
            this.head = (int) (mapping[i12] & 4294967295L);
        }
        int i13 = this.tail;
        if (i13 != Integer.MAX_VALUE) {
            this.tail = (int) (mapping[i13] & 4294967295L);
        }
        int i14 = this.hand;
        if (i14 != Integer.MAX_VALUE) {
            this.hand = (int) (mapping[i14] & 4294967295L);
        }
    }

    public static /* synthetic */ void getCount$annotations() {
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(this._capacity) - get_count();
    }

    private final void initializeMetadata(int capacity) {
        long[] jArr;
        if (capacity == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            long[] jArr2 = new long[((capacity + 15) & (-8)) >> 3];
            q.h0(jArr2, -9187201950435737472L);
            int i = capacity >> 3;
            long j5 = 255 << ((capacity & 7) << 3);
            jArr2[i] = (jArr2[i] & (~j5)) | j5;
            jArr = jArr2;
        }
        this.metadata = jArr;
        initializeGrowth();
    }

    private final void initializeStorage(int initialCapacity) {
        long[] emptyNodes;
        int iMax = initialCapacity > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(initialCapacity)) : 0;
        this._capacity = iMax;
        initializeMetadata(iMax);
        this.keys = iMax == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[iMax];
        this.values = iMax == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[iMax];
        if (iMax == 0) {
            emptyNodes = SieveCacheKt.getEmptyNodes();
        } else {
            emptyNodes = new long[iMax];
            q.h0(emptyNodes, 4611686018427387903L);
        }
        this.nodes = emptyNodes;
    }

    private final void markNodeVisited(int index) {
        long[] jArr = this.nodes;
        jArr[index] = (jArr[index] & 4611686018427387903L) | SieveCacheKt.NodeVisitedBit;
    }

    private final void moveNodeToHead(int index) {
        long[] jArr = this.nodes;
        int i = this.head;
        jArr[index] = (i & SieveCacheKt.NodeLinkMask) | 4611686016279904256L;
        if (i != Integer.MAX_VALUE) {
            jArr[i] = ((index & SieveCacheKt.NodeLinkMask) << 31) | (jArr[i] & SieveCacheKt.NodeMetaAndNextMask);
        }
        this.head = index;
        if (this.tail == Integer.MAX_VALUE) {
            this.tail = index;
        }
    }

    private final void removeNode(int index) {
        long[] jArr = this.nodes;
        long j5 = jArr[index];
        int i = (int) ((j5 >> 31) & SieveCacheKt.NodeLinkMask);
        int i6 = (int) (j5 & SieveCacheKt.NodeLinkMask);
        if (i != Integer.MAX_VALUE) {
            jArr[i] = (jArr[i] & SieveCacheKt.NodeMetaAndPreviousMask) | (i6 & SieveCacheKt.NodeLinkMask);
        } else {
            this.head = i6;
        }
        if (i6 != Integer.MAX_VALUE) {
            jArr[i6] = ((i & SieveCacheKt.NodeLinkMask) << 31) | (jArr[i6] & SieveCacheKt.NodeMetaAndNextMask);
        } else {
            this.tail = i;
        }
        if (this.hand == index) {
            this.hand = i;
        }
        jArr[index] = 4611686018427387903L;
    }

    private final V removeValueAt(int index) {
        this._count--;
        long[] jArr = this.metadata;
        int i = this._capacity;
        int i6 = index >> 3;
        int i10 = (index & 7) << 3;
        long j5 = (jArr[i6] & (~(255 << i10))) | (254 << i10);
        jArr[i6] = j5;
        jArr[(((index - 7) & i) + (i & 7)) >> 3] = j5;
        this.keys[index] = null;
        Object[] objArr = this.values;
        V v10 = (V) objArr[index];
        objArr[index] = null;
        long[] jArr2 = this.nodes;
        long j6 = jArr2[index];
        int i11 = (int) ((j6 >> 31) & SieveCacheKt.NodeLinkMask);
        int i12 = (int) (j6 & SieveCacheKt.NodeLinkMask);
        if (i11 != Integer.MAX_VALUE) {
            jArr2[i11] = (jArr2[i11] & SieveCacheKt.NodeMetaAndPreviousMask) | (i12 & SieveCacheKt.NodeLinkMask);
        } else {
            this.head = i12;
        }
        if (i12 != Integer.MAX_VALUE) {
            jArr2[i12] = ((i11 & SieveCacheKt.NodeLinkMask) << 31) | (jArr2[i12] & SieveCacheKt.NodeMetaAndNextMask);
        } else {
            this.tail = i11;
        }
        if (this.hand == index) {
            this.hand = i11;
        }
        jArr2[index] = 4611686018427387903L;
        return v10;
    }

    public final void adjustStorage$collection() {
        if (this._capacity <= 8 || Long.compareUnsigned(get_count() * 32, this._capacity * 25) > 0) {
            resizeStorage$collection(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            dropDeletes$collection();
        }
    }

    public final boolean all(n predicate) {
        kotlin.jvm.internal.k.f(predicate, "predicate");
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        int i11 = (i << 3) + i10;
                        Object obj = objArr[i11];
                        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                        Object obj2 = objArr2[i11];
                        kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                        if (!((Boolean) predicate.invoke(obj, obj2)).booleanValue()) {
                            return false;
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return true;
                }
            }
            if (i == length) {
                return true;
            }
            i++;
        }
    }

    public final boolean any() {
        return this._count != 0;
    }

    public final boolean contains(K key) {
        kotlin.jvm.internal.k.f(key, "key");
        return findKeyIndex(key) >= 0;
    }

    public final boolean containsKey(K key) {
        kotlin.jvm.internal.k.f(key, "key");
        return findKeyIndex(key) >= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean containsValue(V r14) {
        /*
            r13 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.k.f(r14, r0)
            java.lang.Object[] r0 = r13.values
            long[] r13 = r13.metadata
            int r1 = r13.length
            int r1 = r1 + (-2)
            r2 = 0
            if (r1 < 0) goto L53
            r3 = r2
        L11:
            r4 = r13[r3]
            long r6 = ~r4
            r8 = 7
            long r6 = r6 << r8
            long r6 = r6 & r4
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L4e
            int r6 = r3 - r1
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r2
        L2b:
            if (r8 >= r6) goto L4c
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L48
            int r9 = r3 << 3
            int r9 = r9 + r8
            r9 = r0[r9]
            java.lang.String r10 = "null cannot be cast to non-null type V of androidx.collection.SieveCache"
            kotlin.jvm.internal.k.d(r9, r10)
            boolean r9 = r14.equals(r9)
            if (r9 == 0) goto L48
            r13 = 1
            return r13
        L48:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L2b
        L4c:
            if (r6 != r7) goto L53
        L4e:
            if (r3 == r1) goto L53
            int r3 = r3 + 1
            goto L11
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.SieveCache.containsValue(java.lang.Object):boolean");
    }

    public final int count() {
        return get_size();
    }

    public final void dropDeletes$collection() {
        int i;
        Object[] objArr;
        long[] jArr = this.metadata;
        if (jArr == null) {
            return;
        }
        int i6 = this._capacity;
        Object[] objArr2 = this.keys;
        Object[] objArr3 = this.values;
        long[] jArr2 = this.nodes;
        long[] jArr3 = new long[i6];
        int i10 = 0;
        long j5 = 9223372034707292159L;
        Arrays.fill(jArr3, 0, i6, 9223372034707292159L);
        int i11 = (i6 + 7) >> 3;
        for (int i12 = 0; i12 < i11; i12++) {
            long j6 = jArr[i12] & (-9187201950435737472L);
            jArr[i12] = (-72340172838076674L) & ((~j6) + (j6 >>> 7));
        }
        int length = jArr.length;
        int i13 = length - 1;
        int i14 = length - 2;
        jArr[i14] = (jArr[i14] & 72057594037927935L) | (-72057594037927936L);
        jArr[i13] = jArr[0];
        int i15 = 0;
        while (i15 != i6) {
            int i16 = i15 >> 3;
            int i17 = (i15 & 7) << 3;
            long j10 = (jArr[i16] >> i17) & 255;
            if (j10 != 128 && j10 == 254) {
                Object obj = objArr2[i15];
                int iHashCode = (obj != null ? obj.hashCode() : i10) * ScatterMapKt.MurmurHashC1;
                int i18 = (iHashCode ^ (iHashCode << 16)) >>> 7;
                int i19 = i10;
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i18);
                int i20 = i18 & i6;
                long j11 = j5;
                if (((iFindFirstAvailableSlot - i20) & i6) / 8 == ((i15 - i20) & i6) / 8) {
                    jArr[i16] = ((r12 & 127) << i17) | (jArr[i16] & (~(255 << i17)));
                    if (jArr3[i15] == j11) {
                        long j12 = i15;
                        jArr3[i15] = j12 | (j12 << 32);
                    }
                    jArr[jArr.length - 1] = jArr[i19];
                    i15++;
                    i10 = i19;
                    j5 = j11;
                } else {
                    int i21 = iFindFirstAvailableSlot >> 3;
                    long j13 = jArr[i21];
                    int i22 = (iFindFirstAvailableSlot & 7) << 3;
                    if (((j13 >> i22) & 255) == 128) {
                        i = i6;
                        objArr = objArr2;
                        jArr[i21] = ((~(255 << i22)) & j13) | ((r12 & 127) << i22);
                        jArr[i16] = (jArr[i16] & (~(255 << i17))) | (128 << i17);
                        objArr[iFindFirstAvailableSlot] = objArr[i15];
                        objArr[i15] = null;
                        objArr3[iFindFirstAvailableSlot] = objArr3[i15];
                        objArr3[i15] = null;
                        jArr2[iFindFirstAvailableSlot] = jArr2[i15];
                        jArr2[i15] = 4611686018427387903L;
                        int i23 = (int) ((jArr3[i15] >> 32) & 4294967295L);
                        if (i23 != Integer.MAX_VALUE) {
                            jArr3[i23] = (jArr3[i23] & (-4294967296L)) | iFindFirstAvailableSlot;
                            jArr3[i15] = (jArr3[i15] & 4294967295L) | (-4294967296L);
                        } else {
                            jArr3[i15] = (Integer.MAX_VALUE << 32) | iFindFirstAvailableSlot;
                        }
                        jArr3[iFindFirstAvailableSlot] = (i15 << 32) | Integer.MAX_VALUE;
                    } else {
                        i = i6;
                        objArr = objArr2;
                        jArr[i21] = ((r12 & 127) << i22) | ((~(255 << i22)) & j13);
                        Object obj2 = objArr[iFindFirstAvailableSlot];
                        objArr[iFindFirstAvailableSlot] = objArr[i15];
                        objArr[i15] = obj2;
                        Object obj3 = objArr3[iFindFirstAvailableSlot];
                        objArr3[iFindFirstAvailableSlot] = objArr3[i15];
                        objArr3[i15] = obj3;
                        long j14 = jArr2[iFindFirstAvailableSlot];
                        jArr2[iFindFirstAvailableSlot] = jArr2[i15];
                        jArr2[i15] = j14;
                        int i24 = (int) ((jArr3[i15] >> 32) & 4294967295L);
                        if (i24 != Integer.MAX_VALUE) {
                            long j15 = iFindFirstAvailableSlot;
                            jArr3[i24] = (jArr3[i24] & (-4294967296L)) | j15;
                            jArr3[i15] = (jArr3[i15] & 4294967295L) | (j15 << 32);
                        } else {
                            long j16 = iFindFirstAvailableSlot;
                            jArr3[i15] = j16 | (j16 << 32);
                            i24 = i15;
                        }
                        jArr3[iFindFirstAvailableSlot] = (i24 << 32) | i15;
                        i15--;
                    }
                    jArr[jArr.length - 1] = jArr[i19];
                    i15++;
                    i6 = i;
                    i10 = i19;
                    j5 = j11;
                    objArr2 = objArr;
                }
            } else {
                i15++;
            }
        }
        initializeGrowth();
        fixupNodes(jArr3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 1
            if (r1 != r0) goto L8
            return r2
        L8:
            boolean r3 = r1 instanceof androidx.collection.SieveCache
            r4 = 0
            if (r3 != 0) goto Le
            return r4
        Le:
            androidx.collection.SieveCache r1 = (androidx.collection.SieveCache) r1
            int r3 = r1.get_size()
            int r5 = r0.get_size()
            if (r3 != r5) goto L7a
            int r3 = r1._count
            int r5 = r0._count
            if (r3 == r5) goto L21
            goto L7a
        L21:
            java.lang.Object[] r3 = r0.keys
            java.lang.Object[] r5 = r0.values
            long[] r0 = r0.metadata
            int r6 = r0.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L79
            r7 = r4
        L2d:
            r8 = r0[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L74
            int r10 = r7 - r6
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r4
        L47:
            if (r12 >= r10) goto L72
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L6e
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r3[r13]
            java.lang.String r15 = "null cannot be cast to non-null type K of androidx.collection.SieveCache"
            kotlin.jvm.internal.k.d(r14, r15)
            r13 = r5[r13]
            java.lang.String r15 = "null cannot be cast to non-null type V of androidx.collection.SieveCache"
            kotlin.jvm.internal.k.d(r13, r15)
            java.lang.Object r14 = r1.get(r14)
            boolean r13 = r13.equals(r14)
            if (r13 != 0) goto L6e
            return r4
        L6e:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L47
        L72:
            if (r10 != r11) goto L79
        L74:
            if (r7 == r6) goto L79
            int r7 = r7 + 1
            goto L2d
        L79:
            return r2
        L7a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.SieveCache.equals(java.lang.Object):boolean");
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final void forEach(n block) {
        kotlin.jvm.internal.k.f(block, "block");
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        long[] jArr = this.metadata;
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
                        int i11 = (i << 3) + i10;
                        Object obj = objArr[i11];
                        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                        Object obj2 = objArr2[i11];
                        kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                        block.invoke(obj, obj2);
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

    public final void forEachIndexed(k block) {
        kotlin.jvm.internal.k.f(block, "block");
        long[] jArr = this.metadata;
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
                        a.y(i << 3, i10, block);
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

    public final void forEachKey(k block) {
        kotlin.jvm.internal.k.f(block, "block");
        Object[] objArr = this.keys;
        long[] jArr = this.metadata;
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
                        Object obj = objArr[(i << 3) + i10];
                        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                        block.invoke(obj);
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

    public final void forEachValue(k block) {
        kotlin.jvm.internal.k.f(block, "block");
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
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
                        Object obj = objArr[(i << 3) + i10];
                        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                        block.invoke(obj);
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

    public final V get(K key) {
        kotlin.jvm.internal.k.f(key, "key");
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex >= 0) {
            long[] jArr = this.nodes;
            jArr[iFindKeyIndex] = (jArr[iFindKeyIndex] & 4611686018427387903L) | SieveCacheKt.NodeVisitedBit;
            return (V) this.values[iFindKeyIndex];
        }
        V v10 = (V) this.createValueFromKey.invoke(key);
        if (v10 == null) {
            return null;
        }
        put(key, v10);
        return v10;
    }

    /* renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    /* renamed from: getCount, reason: from getter */
    public final int get_count() {
        return this._count;
    }

    /* renamed from: getMaxSize, reason: from getter */
    public final int get_maxSize() {
        return this._maxSize;
    }

    /* renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public int hashCode() {
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int iHashCode = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        int i11 = (i << 3) + i10;
                        Object obj = objArr[i11];
                        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                        Object obj2 = objArr2[i11];
                        kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                        iHashCode += obj2.hashCode() ^ obj.hashCode();
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return iHashCode;
                }
            }
            if (i == length) {
                return iHashCode;
            }
            i++;
        }
    }

    public final boolean isEmpty() {
        return this._count == 0;
    }

    public final boolean isNotEmpty() {
        return this._count != 0;
    }

    public final void minusAssign(K key) {
        kotlin.jvm.internal.k.f(key, "key");
        remove(key);
    }

    public final boolean none() {
        return this._count == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.k.f(pair, "pair");
        put(pair.f4886a, pair.b);
    }

    public final V put(K key, V value) {
        kotlin.jvm.internal.k.f(key, "key");
        kotlin.jvm.internal.k.f(value, "value");
        int iFindInsertIndex = findInsertIndex(key);
        if (iFindInsertIndex < 0) {
            iFindInsertIndex = ~iFindInsertIndex;
        }
        Object[] objArr = this.values;
        V v10 = (V) objArr[iFindInsertIndex];
        objArr[iFindInsertIndex] = value;
        this.keys[iFindInsertIndex] = key;
        int iIntValue = ((Number) this.sizeOf.invoke(key, value)).intValue() + this._size;
        this._size = iIntValue;
        if (v10 != null) {
            this._size = iIntValue - ((Number) this.sizeOf.invoke(key, v10)).intValue();
            this.onEntryRemoved.invoke(key, v10, value, Boolean.FALSE);
            trimToSize(this._maxSize);
            return v10;
        }
        trimToSize(this._maxSize);
        long[] jArr = this.nodes;
        int i = this.head;
        jArr[iFindInsertIndex] = (i & SieveCacheKt.NodeLinkMask) | 4611686016279904256L;
        if (i != Integer.MAX_VALUE) {
            jArr[i] = (jArr[i] & SieveCacheKt.NodeMetaAndNextMask) | ((SieveCacheKt.NodeLinkMask & iFindInsertIndex) << 31);
        }
        this.head = iFindInsertIndex;
        if (this.tail == Integer.MAX_VALUE) {
            this.tail = iFindInsertIndex;
        }
        return v10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.k.f(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            put(pair.f4886a, pair.b);
        }
    }

    public final V remove(K key) {
        V vRemoveValueAt;
        kotlin.jvm.internal.k.f(key, "key");
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex < 0 || (vRemoveValueAt = removeValueAt(iFindKeyIndex)) == null) {
            return null;
        }
        this._size -= ((Number) this.sizeOf.invoke(key, vRemoveValueAt)).intValue();
        this.onEntryRemoved.invoke(key, vRemoveValueAt, null, Boolean.FALSE);
        return vRemoveValueAt;
    }

    public final void removeIf(n predicate) {
        kotlin.jvm.internal.k.f(predicate, "predicate");
        long[] jArr = this.metadata;
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
                        int i11 = (i << 3) + i10;
                        Object obj = this.keys[i11];
                        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                        Object obj2 = this.values[i11];
                        kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                        if (((Boolean) predicate.invoke(obj, obj2)).booleanValue()) {
                            V vRemoveValueAt = removeValueAt(i11);
                            if (vRemoveValueAt == null) {
                                return;
                            }
                            this._size -= ((Number) this.sizeOf.invoke(obj, vRemoveValueAt)).intValue();
                            this.onEntryRemoved.invoke(obj, vRemoveValueAt, null, Boolean.FALSE);
                        } else {
                            continue;
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

    public final void resize(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID, to = 2147483646) int maxSize) {
        this._maxSize = maxSize;
        trimToSize(maxSize);
    }

    public final void resizeStorage$collection(int newCapacity) {
        long[] jArr;
        Object[] objArr;
        long[] jArr2 = this.metadata;
        Object[] objArr2 = this.keys;
        Object[] objArr3 = this.values;
        long[] jArr3 = this.nodes;
        int i = this._capacity;
        int[] iArr = new int[i];
        initializeStorage(newCapacity);
        long[] jArr4 = this.metadata;
        Object[] objArr4 = this.keys;
        Object[] objArr5 = this.values;
        long[] jArr5 = this.nodes;
        int i6 = this._capacity;
        int i10 = 0;
        while (i10 < i) {
            if (((jArr2[i10 >> 3] >> ((i10 & 7) << 3)) & 255) < 128) {
                Object obj = objArr2[i10];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
                int i11 = iHashCode ^ (iHashCode << 16);
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i11 >>> 7);
                jArr = jArr2;
                objArr = objArr2;
                long j5 = i11 & 127;
                int i12 = iFindFirstAvailableSlot >> 3;
                int i13 = (iFindFirstAvailableSlot & 7) << 3;
                long j6 = (jArr4[i12] & (~(255 << i13))) | (j5 << i13);
                jArr4[i12] = j6;
                jArr4[(((iFindFirstAvailableSlot - 7) & i6) + (i6 & 7)) >> 3] = j6;
                objArr4[iFindFirstAvailableSlot] = obj;
                objArr5[iFindFirstAvailableSlot] = objArr3[i10];
                jArr5[iFindFirstAvailableSlot] = jArr3[i10];
                iArr[i10] = iFindFirstAvailableSlot;
            } else {
                jArr = jArr2;
                objArr = objArr2;
            }
            i10++;
            jArr2 = jArr;
            objArr2 = objArr;
        }
        fixupNodes(iArr);
    }

    public final void set(K key, V value) {
        kotlin.jvm.internal.k.f(key, "key");
        kotlin.jvm.internal.k.f(value, "value");
        put(key, value);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SieveCache[maxSize=");
        sb.append(this._maxSize);
        sb.append(", size=");
        sb.append(this._size);
        sb.append(", capacity=");
        sb.append(this._capacity);
        sb.append(", count=");
        return B7.a.o(sb, this._count, ']');
    }

    public final void trimToSize(int maxSize) {
        int iFindEvictionCandidate;
        while (this._size > maxSize && get_count() != 0 && (iFindEvictionCandidate = findEvictionCandidate()) != Integer.MAX_VALUE) {
            Object obj = this.keys[iFindEvictionCandidate];
            kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
            V vRemoveValueAt = removeValueAt(iFindEvictionCandidate);
            if (vRemoveValueAt != null) {
                this._size -= ((Number) this.sizeOf.invoke(obj, vRemoveValueAt)).intValue();
                this.onEntryRemoved.invoke(obj, vRemoveValueAt, null, Boolean.TRUE);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean any(S7.n r15) {
        /*
            r14 = this;
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.k.f(r15, r0)
            java.lang.Object[] r0 = r14.keys
            java.lang.Object[] r1 = r14.values
            long[] r14 = r14.metadata
            int r2 = r14.length
            int r2 = r2 + (-2)
            r3 = 0
            if (r2 < 0) goto L61
            r4 = r3
        L12:
            r5 = r14[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L5c
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L2c:
            if (r9 >= r7) goto L5a
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L56
            int r10 = r4 << 3
            int r10 = r10 + r9
            r11 = r0[r10]
            java.lang.String r12 = "null cannot be cast to non-null type K of androidx.collection.SieveCache"
            kotlin.jvm.internal.k.d(r11, r12)
            r10 = r1[r10]
            java.lang.String r12 = "null cannot be cast to non-null type V of androidx.collection.SieveCache"
            kotlin.jvm.internal.k.d(r10, r12)
            java.lang.Object r10 = r15.invoke(r11, r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L56
            r14 = 1
            return r14
        L56:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L2c
        L5a:
            if (r7 != r8) goto L61
        L5c:
            if (r4 == r2) goto L61
            int r4 = r4 + 1
            goto L12
        L61:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.SieveCache.any(S7.n):boolean");
    }

    public final int count(n predicate) {
        kotlin.jvm.internal.k.f(predicate, "predicate");
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int i6 = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8 - ((~(i - length)) >>> 31);
                for (int i11 = 0; i11 < i10; i11++) {
                    if ((255 & j5) < 128) {
                        int i12 = (i << 3) + i11;
                        Object obj = objArr[i12];
                        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                        Object obj2 = objArr2[i12];
                        kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                        if (((Boolean) predicate.invoke(obj, obj2)).booleanValue()) {
                            i6++;
                        }
                    }
                    j5 >>= 8;
                }
                if (i10 != 8) {
                    return i6;
                }
            }
            if (i == length) {
                return i6;
            }
            i++;
        }
    }

    public final void minusAssign(K[] keys) {
        kotlin.jvm.internal.k.f(keys, "keys");
        for (K k : keys) {
            remove(k);
        }
    }

    public final void minusAssign(Iterable<? extends K> keys) {
        kotlin.jvm.internal.k.f(keys, "keys");
        Iterator<? extends K> it = keys.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final void plusAssign(Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.k.f(pairs, "pairs");
        putAll(pairs);
    }

    public final void plusAssign(Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.k.f(pairs, "pairs");
        putAll(pairs);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.k.f(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            put(pair.f4886a, pair.b);
        }
    }

    public final boolean remove(K key, V value) {
        V vRemoveValueAt;
        kotlin.jvm.internal.k.f(key, "key");
        kotlin.jvm.internal.k.f(value, "value");
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex < 0 || !kotlin.jvm.internal.k.b(this.values[iFindKeyIndex], value) || (vRemoveValueAt = removeValueAt(iFindKeyIndex)) == null) {
            return false;
        }
        this._size -= ((Number) this.sizeOf.invoke(key, vRemoveValueAt)).intValue();
        this.onEntryRemoved.invoke(key, vRemoveValueAt, null, Boolean.FALSE);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(i keys) {
        kotlin.jvm.internal.k.f(keys, "keys");
        Iterator it = keys.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final void plusAssign(i pairs) {
        kotlin.jvm.internal.k.f(pairs, "pairs");
        putAll(pairs);
    }

    public final void plusAssign(Map<K, ? extends V> from) {
        kotlin.jvm.internal.k.f(from, "from");
        putAll(from);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<K> keys) {
        kotlin.jvm.internal.k.f(keys, "keys");
        Object[] objArr = keys.elements;
        long[] jArr = keys.metadata;
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
                        remove(objArr[(i << 3) + i10]);
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

    public final void plusAssign(ScatterMap<K, V> from) {
        kotlin.jvm.internal.k.f(from, "from");
        putAll(from);
    }

    public final void plusAssign(SieveCache<K, V> from) {
        kotlin.jvm.internal.k.f(from, "from");
        putAll(from);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(i pairs) {
        kotlin.jvm.internal.k.f(pairs, "pairs");
        Iterator it = pairs.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            put(pair.f4886a, pair.b);
        }
    }

    private final void fixupNodes(int[] mapping) {
        long[] jArr = this.nodes;
        int length = jArr.length;
        int i = 0;
        while (true) {
            int i6 = Integer.MAX_VALUE;
            if (i >= length) {
                break;
            }
            long j5 = jArr[i];
            int i10 = (int) ((j5 >> 31) & SieveCacheKt.NodeLinkMask);
            int i11 = (int) (j5 & SieveCacheKt.NodeLinkMask);
            long j6 = ((j5 & SieveCacheKt.NodeMetaMask) | (i10 == Integer.MAX_VALUE ? Integer.MAX_VALUE : mapping[i10])) << 31;
            if (i11 != Integer.MAX_VALUE) {
                i6 = mapping[i11];
            }
            jArr[i] = j6 | i6;
            i++;
        }
        int i12 = this.head;
        if (i12 != Integer.MAX_VALUE) {
            this.head = mapping[i12];
        }
        int i13 = this.tail;
        if (i13 != Integer.MAX_VALUE) {
            this.tail = mapping[i13];
        }
        int i14 = this.hand;
        if (i14 != Integer.MAX_VALUE) {
            this.hand = mapping[i14];
        }
    }

    public final void putAll(Map<K, ? extends V> from) {
        kotlin.jvm.internal.k.f(from, "from");
        for (Map.Entry<K, ? extends V> entry : from.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ObjectList<K> keys) {
        kotlin.jvm.internal.k.f(keys, "keys");
        Object[] objArr = keys.content;
        int i = keys._size;
        for (int i6 = 0; i6 < i; i6++) {
            remove(objArr[i6]);
        }
    }

    public /* synthetic */ SieveCache(int i, int i6, n nVar, k kVar, p pVar, int i10, e eVar) {
        this(i, (i10 & 2) != 0 ? 6 : i6, (i10 & 4) != 0 ? new n() { // from class: androidx.collection.SieveCache.1
            @Override // S7.n
            public final Integer invoke(K k, V v10) {
                kotlin.jvm.internal.k.f(k, "<anonymous parameter 0>");
                kotlin.jvm.internal.k.f(v10, "<anonymous parameter 1>");
                return 1;
            }

            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((AnonymousClass1) obj, obj2);
            }
        } : nVar, (i10 & 8) != 0 ? new k() { // from class: androidx.collection.SieveCache.2
            @Override // S7.k
            public final Void invoke(K it) {
                kotlin.jvm.internal.k.f(it, "it");
                return null;
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((AnonymousClass2) obj);
            }
        } : kVar, (i10 & 16) != 0 ? new p() { // from class: androidx.collection.SieveCache.3
            public final void invoke(K k, V v10, V v11, boolean z10) {
                kotlin.jvm.internal.k.f(k, "<anonymous parameter 0>");
                kotlin.jvm.internal.k.f(v10, "<anonymous parameter 1>");
            }

            @Override // S7.p
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((AnonymousClass3) obj, obj2, obj3, ((Boolean) obj4).booleanValue());
                return r.f317a;
            }
        } : pVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(ScatterMap<K, V> from) {
        kotlin.jvm.internal.k.f(from, "from");
        Object[] objArr = from.keys;
        Object[] objArr2 = from.values;
        long[] jArr = from.metadata;
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
                        int i11 = (i << 3) + i10;
                        put(objArr[i11], objArr2[i11]);
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(SieveCache<K, V> from) {
        kotlin.jvm.internal.k.f(from, "from");
        Object[] objArr = from.keys;
        Object[] objArr2 = from.values;
        long[] jArr = from.metadata;
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
                        int i11 = (i << 3) + i10;
                        Object obj = objArr[i11];
                        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                        Object obj2 = objArr2[i11];
                        kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                        put(obj, obj2);
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
}
