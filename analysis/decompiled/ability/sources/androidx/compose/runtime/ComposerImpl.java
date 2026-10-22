package androidx.compose.runtime;

import C7.r;
import D7.q;
import D7.v;
import S7.n;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.changelist.FixupList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.ComposeStackTraceBuilderKt;
import androidx.compose.runtime.tooling.ComposeStackTraceFrame;
import androidx.compose.runtime.tooling.ComposeStackTraceKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionErrorContext;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import androidx.compose.runtime.tooling.CompositionErrorContextKt;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.runtime.tooling.ObjectLocation;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.p;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000´\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0015*\u0002ç\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0004Ä\u0003Å\u0003BQ\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0017¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0017¢\u0006\u0004\b\u001b\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u0016H\u0017¢\u0006\u0004\b\u001c\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u0016H\u0017¢\u0006\u0004\b\u001d\u0010\u001aJ\u000f\u0010\u001e\u001a\u00020\u0016H\u0017¢\u0006\u0004\b\u001e\u0010\u001aJ!\u0010!\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0017¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0016H\u0017¢\u0006\u0004\b#\u0010\u001aJ\u000f\u0010%\u001a\u00020\u0016H\u0000¢\u0006\u0004\b$\u0010\u001aJ\u000f\u0010&\u001a\u00020\u0016H\u0016¢\u0006\u0004\b&\u0010\u001aJ\u000f\u0010(\u001a\u00020\u0016H\u0000¢\u0006\u0004\b'\u0010\u001aJ\u000f\u0010*\u001a\u00020\u0016H\u0000¢\u0006\u0004\b)\u0010\u001aJ\u000f\u0010.\u001a\u00020+H\u0000¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020\u0016H\u0016¢\u0006\u0004\b/\u0010\u001aJ\u000f\u00100\u001a\u00020\u0016H\u0016¢\u0006\u0004\b0\u0010\u001aJ#\u00104\u001a\u00020\u0016\"\u0004\b\u0000\u001012\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0016H\u0016¢\u0006\u0004\b6\u0010\u001aJ\u000f\u00107\u001a\u00020\u0016H\u0016¢\u0006\u0004\b7\u0010\u001aJ!\u00108\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b8\u0010\"J\u000f\u00109\u001a\u00020\u0016H\u0016¢\u0006\u0004\b9\u0010\u001aJ\u000f\u0010:\u001a\u00020\u0016H\u0016¢\u0006\u0004\b:\u0010\u001aJ\u000f\u0010;\u001a\u00020\u0016H\u0016¢\u0006\u0004\b;\u0010\u001aJ\r\u0010<\u001a\u00020\u0016¢\u0006\u0004\b<\u0010\u001aJ\r\u0010=\u001a\u00020\u0016¢\u0006\u0004\b=\u0010\u001aJ\u0017\u0010?\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u0014H\u0016¢\u0006\u0004\b?\u0010\u0018J=\u0010D\u001a\u00020\u0016\"\u0004\b\u0000\u0010@\"\u0004\b\u0001\u001012\u0006\u0010A\u001a\u00028\u00002\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00160BH\u0016¢\u0006\u0004\bD\u0010EJ#\u0010H\u001a\u00020\u001f2\b\u0010F\u001a\u0004\u0018\u00010\u001f2\b\u0010G\u001a\u0004\u0018\u00010\u001fH\u0017¢\u0006\u0004\bH\u0010IJ\u0011\u0010J\u001a\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0004\bJ\u0010KJ\u0011\u0010L\u001a\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0004\bL\u0010KJ\u0019\u0010M\u001a\u00020+2\b\u0010A\u001a\u0004\u0018\u00010\u001fH\u0017¢\u0006\u0004\bM\u0010NJ\u0019\u0010O\u001a\u00020+2\b\u0010A\u001a\u0004\u0018\u00010\u001fH\u0017¢\u0006\u0004\bO\u0010NJ\u0017\u0010M\u001a\u00020+2\u0006\u0010A\u001a\u00020PH\u0017¢\u0006\u0004\bM\u0010QJ\u0017\u0010M\u001a\u00020+2\u0006\u0010A\u001a\u00020RH\u0017¢\u0006\u0004\bM\u0010SJ\u0017\u0010M\u001a\u00020+2\u0006\u0010A\u001a\u00020TH\u0017¢\u0006\u0004\bM\u0010UJ\u0017\u0010M\u001a\u00020+2\u0006\u0010A\u001a\u00020+H\u0017¢\u0006\u0004\bM\u0010VJ\u0017\u0010M\u001a\u00020+2\u0006\u0010A\u001a\u00020WH\u0017¢\u0006\u0004\bM\u0010XJ\u0017\u0010M\u001a\u00020+2\u0006\u0010A\u001a\u00020YH\u0017¢\u0006\u0004\bM\u0010ZJ\u0017\u0010M\u001a\u00020+2\u0006\u0010A\u001a\u00020[H\u0017¢\u0006\u0004\bM\u0010\\J\u0017\u0010M\u001a\u00020+2\u0006\u0010A\u001a\u00020\u0014H\u0017¢\u0006\u0004\bM\u0010]J,\u0010_\u001a\u00028\u0000\"\u0004\b\u0000\u001012\u0006\u0010^\u001a\u00020+2\f\u0010C\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0087\b¢\u0006\u0004\b_\u0010`J\u0019\u0010a\u001a\u00020\u00162\b\u0010A\u001a\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0004\ba\u0010bJ\u0019\u0010c\u001a\u00020\u00162\b\u0010A\u001a\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0004\bc\u0010bJ\u001d\u0010e\u001a\u00020\u00162\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\u001602H\u0016¢\u0006\u0004\be\u00105J\u001b\u0010g\u001a\u00020\u00162\n\u0010A\u001a\u0006\u0012\u0002\b\u00030fH\u0017¢\u0006\u0004\bg\u0010hJ\u000f\u0010i\u001a\u00020\u0016H\u0017¢\u0006\u0004\bi\u0010\u001aJ#\u0010l\u001a\u00020\u00162\u0012\u0010k\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030f0jH\u0017¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020\u0016H\u0017¢\u0006\u0004\bn\u0010\u001aJ#\u0010p\u001a\u00028\u0000\"\u0004\b\u0000\u001012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000oH\u0017¢\u0006\u0004\bp\u0010qJ\u000f\u0010r\u001a\u00020\u0004H\u0016¢\u0006\u0004\br\u0010sJ!\u0010y\u001a\u00020+2\u0006\u0010u\u001a\u00020t2\b\u0010v\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0004\bw\u0010xJ\u000f\u0010|\u001a\u00020\u0014H\u0001¢\u0006\u0004\bz\u0010{J\u000f\u0010}\u001a\u00020\u0016H\u0017¢\u0006\u0004\b}\u0010\u001aJ\"\u0010\u0080\u0001\u001a\u00020+2\u0006\u0010~\u001a\u00020+2\u0006\u0010\u007f\u001a\u00020\u0014H\u0017¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0011\u0010\u0082\u0001\u001a\u00020\u0016H\u0017¢\u0006\u0005\b\u0082\u0001\u0010\u001aJ\u001a\u0010\u0083\u0001\u001a\u00020\u00162\u0006\u0010M\u001a\u00020+H\u0017¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001a\u0010\u0085\u0001\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0014H\u0017¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u0015\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0017¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J*\u0010\u008c\u0001\u001a\u00020\u00162\u000b\u0010A\u001a\u0007\u0012\u0002\b\u00030\u008a\u00012\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u001fH\u0017¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J3\u0010\u0092\u0001\u001a\u00020\u00162\u001f\u0010\u0091\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030\u0090\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0090\u00010\u008f\u00010\u008e\u0001H\u0017¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001c\u0010\u0095\u0001\u001a\u00020\u00162\b\u0010\u0095\u0001\u001a\u00030\u0094\u0001H\u0017¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J$\u0010\u0097\u0001\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0095\u0001\u001a\u00030\u0094\u0001H\u0017¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u0011\u0010\u0099\u0001\u001a\u00020\u0016H\u0017¢\u0006\u0005\b\u0099\u0001\u0010\u001aJ\u0011\u0010\u009a\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0005\b\u009a\u0001\u0010\u001aJ$\u0010\u009e\u0001\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u008e\u00012\b\u0010A\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u0018\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u008e\u0001¢\u0006\u0006\b\u009f\u0001\u0010 \u0001JI\u0010©\u0001\u001a\u00020\u00162\u0014\u0010¢\u0001\u001a\u000f\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020\u001f0¡\u00012\u0013\u0010¤\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001602¢\u0006\u0003\b£\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u0001H\u0000¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u001f\u0010«\u0001\u001a\u00020\u00162\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001602H\u0000¢\u0006\u0005\bª\u0001\u00105J4\u0010®\u0001\u001a\u00020+2\u0014\u0010¢\u0001\u001a\u000f\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020\u001f0¡\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u0001H\u0000¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001J&\u0010±\u0001\u001a\u00020\u00162\u0014\u0010¢\u0001\u001a\u000f\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020\u001f0¡\u0001¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u0011\u0010³\u0001\u001a\u00020\u0016H\u0000¢\u0006\u0005\b²\u0001\u0010\u001aJ\u0011\u0010µ\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0005\b´\u0001\u0010{J\u0013\u0010¶\u0001\u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0005\b¶\u0001\u0010KJ\u001b\u0010·\u0001\u001a\u00020\u00162\b\u0010A\u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0005\b·\u0001\u0010bJ\u001b\u0010¹\u0001\u001a\u00020\u00162\u0007\u0010u\u001a\u00030¸\u0001H\u0016¢\u0006\u0006\b¹\u0001\u0010º\u0001J\u0011\u0010»\u0001\u001a\u00020\u0016H\u0002¢\u0006\u0005\b»\u0001\u0010\u001aJ\u0011\u0010¼\u0001\u001a\u00020\u0016H\u0002¢\u0006\u0005\b¼\u0001\u0010\u001aJ\u0011\u0010½\u0001\u001a\u00020\u0016H\u0002¢\u0006\u0005\b½\u0001\u0010\u001aJ\u0019\u0010¾\u0001\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0005\b¾\u0001\u0010\u0018J#\u0010¾\u0001\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0005\b¾\u0001\u0010\"J\u0011\u0010¿\u0001\u001a\u00020\u0016H\u0002¢\u0006\u0005\b¿\u0001\u0010\u001aJ\u0011\u0010À\u0001\u001a\u00020\u0016H\u0002¢\u0006\u0005\bÀ\u0001\u0010\u001aJ\u001b\u0010Á\u0001\u001a\u00020\u00162\b\u0010A\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0005\bÁ\u0001\u0010bJ\u0015\u0010Ã\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0002¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001J\u0013\u0010Æ\u0001\u001a\u00030Å\u0001H\u0002¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001J\u001c\u0010Æ\u0001\u001a\u00030Å\u00012\u0007\u0010È\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0006\bÆ\u0001\u0010É\u0001J'\u0010Ì\u0001\u001a\u00030Å\u00012\b\u0010Ê\u0001\u001a\u00030Å\u00012\b\u0010Ë\u0001\u001a\u00030Å\u0001H\u0002¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J\u001c\u0010Ï\u0001\u001a\u00020\u00162\b\u0010Î\u0001\u001a\u00030Å\u0001H\u0002¢\u0006\u0006\bÏ\u0001\u0010Ð\u0001J\u0011\u0010Ñ\u0001\u001a\u00020\u0016H\u0002¢\u0006\u0005\bÑ\u0001\u0010\u001aJ\u0011\u0010Ò\u0001\u001a\u00020\u0016H\u0002¢\u0006\u0005\bÒ\u0001\u0010\u001aJ\u0011\u0010Ó\u0001\u001a\u00020\u0016H\u0002¢\u0006\u0005\bÓ\u0001\u0010\u001aJ&\u0010Ö\u0001\u001a\u00020\u00162\u0007\u0010Ô\u0001\u001a\u00020+2\t\u0010Õ\u0001\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0006\bÖ\u0001\u0010×\u0001J:\u0010Ý\u0001\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\t\u0010Ø\u0001\u001a\u0004\u0018\u00010\u001f2\b\u0010Ú\u0001\u001a\u00030Ù\u00012\t\u0010Õ\u0001\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001J'\u0010à\u0001\u001a\u00020\u00162\u0007\u0010Ô\u0001\u001a\u00020+2\n\u0010ß\u0001\u001a\u0005\u0018\u00010Þ\u0001H\u0002¢\u0006\u0006\bà\u0001\u0010á\u0001J$\u0010ä\u0001\u001a\u00020\u00162\u0007\u0010â\u0001\u001a\u00020\u00142\u0007\u0010ã\u0001\u001a\u00020+H\u0002¢\u0006\u0006\bä\u0001\u0010å\u0001J\u001b\u0010æ\u0001\u001a\u00020\u00162\u0007\u0010Ô\u0001\u001a\u00020+H\u0002¢\u0006\u0006\bæ\u0001\u0010\u0084\u0001J\u0011\u0010ç\u0001\u001a\u00020\u0016H\u0002¢\u0006\u0005\bç\u0001\u0010\u001aJ\u001b\u0010é\u0001\u001a\u00020\u00142\u0007\u0010è\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0006\bé\u0001\u0010ê\u0001J$\u0010ì\u0001\u001a\u00020\u00162\u0007\u0010È\u0001\u001a\u00020\u00142\u0007\u0010ë\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0006\bì\u0001\u0010í\u0001J6\u0010ñ\u0001\u001a\u00020\u00142\u0007\u0010î\u0001\u001a\u00020\u00142\u0007\u0010È\u0001\u001a\u00020\u00142\u0007\u0010ï\u0001\u001a\u00020\u00142\u0007\u0010ð\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0006\bñ\u0001\u0010ò\u0001J\u001b\u0010ó\u0001\u001a\u00020\u00142\u0007\u0010È\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0006\bó\u0001\u0010ê\u0001J\u001b\u0010ô\u0001\u001a\u00020\u00142\u0007\u0010È\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0006\bô\u0001\u0010ê\u0001J$\u0010ö\u0001\u001a\u00020\u00162\u0007\u0010È\u0001\u001a\u00020\u00142\u0007\u0010õ\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0006\bö\u0001\u0010í\u0001J\u0011\u0010÷\u0001\u001a\u00020\u0016H\u0002¢\u0006\u0005\b÷\u0001\u0010\u001aJ-\u0010û\u0001\u001a\u00020\u00162\u0007\u0010ø\u0001\u001a\u00020\u00142\u0007\u0010ù\u0001\u001a\u00020\u00142\u0007\u0010ú\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0006\bû\u0001\u0010ü\u0001J$\u0010þ\u0001\u001a\u00020\u00162\u0007\u0010È\u0001\u001a\u00020\u00142\u0007\u0010ý\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0006\bþ\u0001\u0010í\u0001J7\u0010\u0081\u0002\u001a\u00070Yj\u0003`ÿ\u00012\u0007\u0010È\u0001\u001a\u00020\u00142\u0007\u0010ï\u0001\u001a\u00020\u00142\f\u0010\u0080\u0002\u001a\u00070Yj\u0003`ÿ\u0001H\u0002¢\u0006\u0006\b\u0081\u0002\u0010\u0082\u0002J \u0010\u0084\u0002\u001a\u00020\u0014*\u00030\u0083\u00022\u0007\u0010È\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0006\b\u0084\u0002\u0010\u0085\u0002J\u0011\u0010\u0086\u0002\u001a\u00020\u0016H\u0002¢\u0006\u0005\b\u0086\u0002\u0010\u001aJ\u0011\u0010\u0087\u0002\u001a\u00020\u0016H\u0002¢\u0006\u0005\b\u0087\u0002\u0010\u001aJ\u001a\u0010\u0088\u0002\u001a\u00020\u00162\u0006\u0010u\u001a\u00020tH\u0002¢\u0006\u0006\b\u0088\u0002\u0010\u0089\u0002J*\u0010\u008c\u0002\u001a\u0012\u0012\u0005\u0012\u00030\u008b\u0002\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u008a\u00022\u0006\u0010u\u001a\u00020tH\u0002¢\u0006\u0006\b\u008c\u0002\u0010\u008d\u0002JB\u0010\u0090\u0002\u001a\u00020\u00162\u0010\u0010¤\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u008a\u00012\b\u0010\u008e\u0002\u001a\u00030Å\u00012\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u001f2\u0007\u0010\u008f\u0002\u001a\u00020+H\u0002¢\u0006\u0006\b\u0090\u0002\u0010\u0091\u0002J3\u0010\u0092\u0002\u001a\u00020\u00162\u001f\u0010\u0091\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030\u0090\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0090\u00010\u008f\u00010\u008e\u0001H\u0002¢\u0006\u0006\b\u0092\u0002\u0010\u0093\u0001J2\u0010\u0095\u0002\u001a\u00028\u0000\"\u0005\b\u0000\u0010\u0093\u00022\b\u0010\u0094\u0002\u001a\u00030\u0083\u00022\f\u0010C\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0082\b¢\u0006\u0006\b\u0095\u0002\u0010\u0096\u0002Jq\u0010\u009b\u0002\u001a\u00028\u0000\"\u0005\b\u0000\u0010\u0093\u00022\f\b\u0002\u0010\u0098\u0002\u001a\u0005\u0018\u00010\u0097\u00022\f\b\u0002\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u0097\u00022\u000b\b\u0002\u0010è\u0001\u001a\u0004\u0018\u00010\u00142\u001f\b\u0002\u0010\u009a\u0002\u001a\u0018\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u00020t\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u008f\u00010\u008e\u00012\f\u0010C\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0002¢\u0006\u0006\b\u009b\u0002\u0010\u009c\u0002J\u001a\u0010\u009d\u0002\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u008e\u0001H\u0002¢\u0006\u0006\b\u009d\u0002\u0010 \u0001J.\u0010\u009f\u0002\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u008e\u00012\u0007\u0010È\u0001\u001a\u00020\u00142\t\u0010\u009e\u0002\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0006\b\u009f\u0002\u0010 \u0002J?\u0010£\u0002\u001a\u00020\u00162\u0014\u0010¢\u0001\u001a\u000f\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020\u001f0¡\u00012\u0015\u0010¤\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u000102¢\u0006\u0003\b£\u0001H\u0002¢\u0006\u0006\b¡\u0002\u0010¢\u0002J\"\u0010¤\u0002\u001a\u0004\u0018\u00010\u001f*\u00030\u0083\u00022\u0007\u0010è\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0006\b¤\u0002\u0010¥\u0002J\u0011\u0010¦\u0002\u001a\u00020\u0016H\u0002¢\u0006\u0005\b¦\u0002\u0010\u001aJ\u0011\u0010§\u0002\u001a\u00020\u0016H\u0002¢\u0006\u0005\b§\u0002\u0010\u001aJ\u001c\u0010©\u0002\u001a\u00020\u00162\b\u0010¨\u0002\u001a\u00030Â\u0001H\u0002¢\u0006\u0006\b©\u0002\u0010ª\u0002J\u0011\u0010«\u0002\u001a\u00020\u0016H\u0002¢\u0006\u0005\b«\u0002\u0010\u001aJ\u001a\u0010\u00ad\u0002\u001a\u00020\u00162\u0007\u0010¬\u0002\u001a\u00020\u0014H\u0002¢\u0006\u0005\b\u00ad\u0002\u0010\u0018J\u0011\u0010®\u0002\u001a\u00020\u0016H\u0002¢\u0006\u0005\b®\u0002\u0010\u001aJ\u0011\u0010¯\u0002\u001a\u00020\u0016H\u0002¢\u0006\u0005\b¯\u0002\u0010\u001aJ\u0011\u0010°\u0002\u001a\u00020\u0016H\u0002¢\u0006\u0005\b°\u0002\u0010\u001aJ:\u0010³\u0002\u001a\u00020\u00162\u0007\u0010±\u0002\u001a\u00020\u00142\u0007\u0010²\u0002\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u001f2\t\u0010Õ\u0001\u001a\u0004\u0018\u00010\u001fH\u0082\b¢\u0006\u0006\b³\u0002\u0010´\u0002J%\u0010µ\u0002\u001a\u00020\u00162\u0007\u0010±\u0002\u001a\u00020\u00142\u0007\u0010²\u0002\u001a\u00020\u0014H\u0082\b¢\u0006\u0006\bµ\u0002\u0010í\u0001J:\u0010¶\u0002\u001a\u00020\u00162\u0007\u0010±\u0002\u001a\u00020\u00142\u0007\u0010²\u0002\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u001f2\t\u0010Õ\u0001\u001a\u0004\u0018\u00010\u001fH\u0082\b¢\u0006\u0006\b¶\u0002\u0010´\u0002J%\u0010·\u0002\u001a\u00020\u00162\u0007\u0010±\u0002\u001a\u00020\u00142\u0007\u0010²\u0002\u001a\u00020\u0014H\u0082\b¢\u0006\u0006\b·\u0002\u0010í\u0001R!\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\u0003\u0010¸\u0002\u001a\u0006\b¹\u0002\u0010º\u0002R\u0015\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0005\u0010»\u0002R\u0015\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0007\u0010¼\u0002R\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\n\u0010½\u0002R\u0017\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\f\u0010¾\u0002R\u0017\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\r\u0010¾\u0002R\u0015\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u000f\u0010¿\u0002R\u001d\u0010\u0011\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\u0011\u0010À\u0002\u001a\u0006\bÁ\u0002\u0010Â\u0002R!\u0010Ä\u0002\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010Þ\u00010Ã\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÄ\u0002\u0010Å\u0002R\u001c\u0010Æ\u0002\u001a\u0005\u0018\u00010Þ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0002\u0010Ç\u0002R\u0019\u0010È\u0002\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0002\u0010É\u0002R\u0019\u0010Ê\u0002\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0002\u0010É\u0002R\u0019\u0010²\u0002\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0002\u0010É\u0002R\u0018\u0010Ì\u0002\u001a\u00030Ë\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÌ\u0002\u0010Í\u0002R\u001c\u0010Ï\u0002\u001a\u0005\u0018\u00010Î\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0002\u0010Ð\u0002R\u001c\u0010Ò\u0002\u001a\u0005\u0018\u00010Ñ\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0002\u0010Ó\u0002R\u0017\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b.\u0010Ô\u0002R\u0019\u0010Õ\u0002\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0002\u0010Ô\u0002R\u0019\u0010Ö\u0002\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0002\u0010Ô\u0002R\u001f\u0010\u009a\u0002\u001a\n\u0012\u0005\u0012\u00030Ø\u00020×\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0002\u0010Ù\u0002R\u0018\u0010Ú\u0002\u001a\u00030Ë\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÚ\u0002\u0010Í\u0002R\u001a\u0010Û\u0002\u001a\u00030Å\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0002\u0010Ü\u0002R#\u0010Þ\u0002\u001a\f\u0012\u0005\u0012\u00030Å\u0001\u0018\u00010Ý\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0002\u0010ß\u0002R\u0019\u0010à\u0002\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0002\u0010Ô\u0002R\u0018\u0010á\u0002\u001a\u00030Ë\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bá\u0002\u0010Í\u0002R\u0019\u0010â\u0002\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0002\u0010Ô\u0002R\u0019\u0010ã\u0002\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0002\u0010É\u0002R\u0019\u0010ä\u0002\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0002\u0010É\u0002R\u0019\u0010å\u0002\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0002\u0010É\u0002R\u0019\u0010æ\u0002\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bæ\u0002\u0010Ô\u0002R\u0018\u0010è\u0002\u001a\u00030ç\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bè\u0002\u0010é\u0002R\u001e\u0010ê\u0002\u001a\t\u0012\u0004\u0012\u00020t0Ã\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bê\u0002\u0010Å\u0002R(\u0010ë\u0002\u001a\u00020+2\u0006\u0010A\u001a\u00020+8\u0000@BX\u0080\u000e¢\u0006\u000f\n\u0006\bë\u0002\u0010Ô\u0002\u001a\u0005\bì\u0002\u0010-R(\u0010í\u0002\u001a\u00020+2\u0006\u0010A\u001a\u00020+8\u0000@BX\u0080\u000e¢\u0006\u000f\n\u0006\bí\u0002\u0010Ô\u0002\u001a\u0005\bî\u0002\u0010-R*\u0010\u0094\u0002\u001a\u00030\u0083\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0094\u0002\u0010ï\u0002\u001a\u0006\bð\u0002\u0010ñ\u0002\"\u0006\bò\u0002\u0010ó\u0002R)\u0010ô\u0002\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bô\u0002\u0010¼\u0002\u001a\u0006\bõ\u0002\u0010ö\u0002\"\u0006\b÷\u0002\u0010ø\u0002R\u001a\u0010ú\u0002\u001a\u00030ù\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bú\u0002\u0010û\u0002R\u0019\u0010ü\u0002\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bü\u0002\u0010Ô\u0002R\u001c\u0010ý\u0002\u001a\u0005\u0018\u00010Å\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bý\u0002\u0010Ü\u0002R+\u0010þ\u0002\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bþ\u0002\u0010¾\u0002\u001a\u0006\bÿ\u0002\u0010\u0080\u0003\"\u0006\b\u0081\u0003\u0010\u0082\u0003R\u0018\u0010\u0084\u0003\u001a\u00030\u0083\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0003\u0010\u0085\u0003R\u001a\u0010\u0086\u0003\u001a\u00030Â\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0003\u0010\u0087\u0003R\u001a\u0010\u0089\u0003\u001a\u00030\u0088\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0003\u0010\u008a\u0003R\u0019\u0010\u008b\u0003\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0003\u0010Ô\u0002R\u001c\u0010\u008c\u0003\u001a\u0005\u0018\u00010¥\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0003\u0010\u008d\u0003R\"\u0010\u008f\u0003\u001a\u0005\u0018\u00010\u008e\u00038@X\u0080\u0004¢\u0006\u0010\n\u0006\b\u008f\u0003\u0010\u0090\u0003\u001a\u0006\b\u0091\u0003\u0010\u0092\u0003R \u0010\u0094\u0003\u001a\u00030\u0093\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0094\u0003\u0010\u0095\u0003\u001a\u0006\b\u0096\u0003\u0010\u0097\u0003R/\u0010ã\u0001\u001a\u00020+2\u0006\u0010A\u001a\u00020+8\u0016@RX\u0097\u000e¢\u0006\u0016\n\u0006\bã\u0001\u0010Ô\u0002\u0012\u0005\b\u0099\u0003\u0010\u001a\u001a\u0005\b\u0098\u0003\u0010-R:\u0010\u009a\u0003\u001a\u00070Yj\u0003`ÿ\u00012\u000b\u0010A\u001a\u00070Yj\u0003`ÿ\u00018\u0016@RX\u0097\u000e¢\u0006\u0017\n\u0006\b\u009a\u0003\u0010\u009b\u0003\u0012\u0005\b\u009e\u0003\u0010\u001a\u001a\u0006\b\u009c\u0003\u0010\u009d\u0003R\u001c\u0010 \u0003\u001a\u0005\u0018\u00010\u009f\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0003\u0010¡\u0003R\u0016\u0010£\u0003\u001a\u00020+8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b¢\u0003\u0010-R\u0016\u0010¥\u0003\u001a\u00020+8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b¤\u0003\u0010-R\u001d\u0010¨\u0003\u001a\u00020+8VX\u0097\u0004¢\u0006\u000e\u0012\u0005\b§\u0003\u0010\u001a\u001a\u0005\b¦\u0003\u0010-R\u001d\u0010«\u0003\u001a\u00020+8VX\u0097\u0004¢\u0006\u000e\u0012\u0005\bª\u0003\u0010\u001a\u001a\u0005\b©\u0003\u0010-R\u0016\u0010\u00ad\u0003\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¬\u0003\u0010{R\u0018\u0010°\u0003\u001a\u00030\u009f\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b®\u0003\u0010¯\u0003R\u0018\u0010´\u0003\u001a\u00030±\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b²\u0003\u0010³\u0003R\u0016\u0010¶\u0003\u001a\u00020\u00148@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bµ\u0003\u0010{R\u0019\u0010¹\u0003\u001a\u0004\u0018\u00010t8@X\u0080\u0004¢\u0006\b\u001a\u0006\b·\u0003\u0010¸\u0003R\u0013\u0010»\u0003\u001a\u00020+8F¢\u0006\u0007\u001a\u0005\bº\u0003\u0010-R\u001a\u0010¾\u0003\u001a\u0005\u0018\u00010¸\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¼\u0003\u0010½\u0003R\u0018\u0010À\u0003\u001a\u0004\u0018\u00010\u001f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¿\u0003\u0010KR\u001e\u0010Ã\u0003\u001a\u0004\u0018\u00010\u001f*\u00030\u0083\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\bÁ\u0003\u0010Â\u0003¨\u0006Æ\u0003"}, d2 = {"Landroidx/compose/runtime/ComposerImpl;", "Landroidx/compose/runtime/Composer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/CompositionContext;", "parentContext", "Landroidx/compose/runtime/SlotTable;", "slotTable", "", "Landroidx/compose/runtime/RememberObserver;", "abandonSet", "Landroidx/compose/runtime/changelist/ChangeList;", "changes", "lateChanges", "Landroidx/compose/runtime/CompositionObserverHolder;", "observerHolder", "Landroidx/compose/runtime/CompositionImpl;", "composition", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/SlotTable;Ljava/util/Set;Landroidx/compose/runtime/changelist/ChangeList;Landroidx/compose/runtime/changelist/ChangeList;Landroidx/compose/runtime/CompositionObserverHolder;Landroidx/compose/runtime/CompositionImpl;)V", "", "key", "LC7/r;", "startReplaceableGroup", "(I)V", "endReplaceableGroup", "()V", "startReplaceGroup", "endReplaceGroup", "startDefaults", "endDefaults", "", "dataKey", "startMovableGroup", "(ILjava/lang/Object;)V", "endMovableGroup", "changesApplied$runtime", "changesApplied", "collectParameterInformation", "dispose$runtime", "dispose", "deactivate$runtime", "deactivate", "", "forceRecomposeScopes$runtime", "()Z", "forceRecomposeScopes", "startNode", "startReusableNode", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "factory", "createNode", "(LS7/a;)V", "useNode", "endNode", "startReusableGroup", "endReusableGroup", "disableReusing", "enableReusing", "startReuseFromRoot", "endReuseFromRoot", "marker", "endToMarker", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "value", "Lkotlin/Function2;", "block", "apply", "(Ljava/lang/Object;LS7/n;)V", "left", "right", "joinKey", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "nextSlot", "()Ljava/lang/Object;", "nextSlotForCache", "changed", "(Ljava/lang/Object;)Z", "changedInstance", "", "(C)Z", "", "(B)Z", "", "(S)Z", "(Z)Z", "", "(F)Z", "", "(J)Z", "", "(D)Z", "(I)Z", "invalid", "cache", "(ZLS7/a;)Ljava/lang/Object;", "updateValue", "(Ljava/lang/Object;)V", "updateCachedValue", "effect", "recordSideEffect", "Landroidx/compose/runtime/ProvidedValue;", "startProvider", "(Landroidx/compose/runtime/ProvidedValue;)V", "endProvider", "", "values", "startProviders", "([Landroidx/compose/runtime/ProvidedValue;)V", "endProviders", "Landroidx/compose/runtime/CompositionLocal;", "consume", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "buildContext", "()Landroidx/compose/runtime/CompositionContext;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "scope", "instance", "tryImminentInvalidation$runtime", "(Landroidx/compose/runtime/RecomposeScopeImpl;Ljava/lang/Object;)Z", "tryImminentInvalidation", "parentKey$runtime", "()I", "parentKey", "skipCurrentGroup", "parametersChanged", "flags", "shouldExecute", "(ZI)Z", "skipToGroupEnd", "deactivateToEndGroup", "(Z)V", "startRestartGroup", "(I)Landroidx/compose/runtime/Composer;", "Landroidx/compose/runtime/ScopeUpdateScope;", "endRestartGroup", "()Landroidx/compose/runtime/ScopeUpdateScope;", "Landroidx/compose/runtime/MovableContent;", "parameter", "insertMovableContent", "(Landroidx/compose/runtime/MovableContent;Ljava/lang/Object;)V", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "references", "insertMovableContentReferences", "(Ljava/util/List;)V", "", "sourceInformation", "(Ljava/lang/String;)V", "sourceInformationMarkerStart", "(ILjava/lang/String;)V", "sourceInformationMarkerEnd", "disableSourceInformation", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "stackTraceForValue$runtime", "(Ljava/lang/Object;)Ljava/util/List;", "stackTraceForValue", "parentStackTrace", "()Ljava/util/List;", "Landroidx/compose/runtime/collection/ScopeMap;", "invalidationsRequested", "Landroidx/compose/runtime/Composable;", "content", "Landroidx/compose/runtime/ShouldPauseCallback;", "shouldPause", "composeContent--ZbOJvo$runtime", "(Landroidx/collection/MutableScatterMap;LS7/n;Landroidx/compose/runtime/ShouldPauseCallback;)V", "composeContent", "prepareCompose$runtime", "prepareCompose", "recompose-aFTiNEg$runtime", "(Landroidx/collection/MutableScatterMap;Landroidx/compose/runtime/ShouldPauseCallback;)Z", "recompose", "updateComposerInvalidations-RY85e9Y", "(Landroidx/collection/MutableScatterMap;)V", "updateComposerInvalidations", "verifyConsistent$runtime", "verifyConsistent", "stacksSize$runtime", "stacksSize", "rememberedValue", "updateRememberedValue", "Landroidx/compose/runtime/RecomposeScope;", "recordUsed", "(Landroidx/compose/runtime/RecomposeScope;)V", "startRoot", "endRoot", "abortRoot", "startGroup", "endGroup", "skipGroup", "updateSlot", "Landroidx/compose/runtime/Anchor;", "rememberObserverAnchor", "()Landroidx/compose/runtime/Anchor;", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "currentCompositionLocalScope", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "group", "(I)Landroidx/compose/runtime/PersistentCompositionLocalMap;", "parentScope", "currentProviders", "updateProviderMapGroup", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;Landroidx/compose/runtime/PersistentCompositionLocalMap;)Landroidx/compose/runtime/PersistentCompositionLocalMap;", "providers", "recordProviderUpdate", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", "ensureWriter", "createFreshInsertTable", "forceFreshInsertTable", "isNode", SettingsConfig.KEY_DATA, "startReaderGroup", "(ZLjava/lang/Object;)V", "objectKey", "Landroidx/compose/runtime/GroupKind;", "kind", "start-BaiHCIY", "(ILjava/lang/Object;ILjava/lang/Object;)V", "start", "Landroidx/compose/runtime/Pending;", "newPending", "enterGroup", "(ZLandroidx/compose/runtime/Pending;)V", "expectedNodeCount", "inserting", "exitGroup", "(IZ)V", "end", "recomposeToGroupEnd", "index", "insertedGroupVirtualIndex", "(I)I", "newCount", "updateNodeCountOverrides", "(II)V", "groupLocation", "recomposeGroup", "recomposeIndex", "nodeIndexOf", "(IIII)I", "rGroupIndexOf", "updatedNodeCount", "count", "updateNodeCount", "clearUpdatedNodeCounts", "oldGroup", "newGroup", "commonRoot", "recordUpsAndDowns", "(III)V", "nearestCommonRoot", "doRecordDownsFor", "Landroidx/compose/runtime/CompositeKeyHashCode;", "recomposeKey", "compositeKeyOf", "(IIJ)J", "Landroidx/compose/runtime/SlotReader;", "groupCompositeKeyPart", "(Landroidx/compose/runtime/SlotReader;I)I", "skipReaderToGroupEnd", "addRecomposeScope", "enterRecomposeScope", "(Landroidx/compose/runtime/RecomposeScopeImpl;)V", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "exitRecomposeScope", "(Landroidx/compose/runtime/RecomposeScopeImpl;)LS7/k;", "locals", "force", "invokeMovableContentLambda", "(Landroidx/compose/runtime/MovableContent;Landroidx/compose/runtime/PersistentCompositionLocalMap;Ljava/lang/Object;Z)V", "insertMovableContentGuarded", "R", "reader", "withReader", "(Landroidx/compose/runtime/SlotReader;LS7/a;)Ljava/lang/Object;", "Landroidx/compose/runtime/ControlledComposition;", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "invalidations", "recomposeMovableContent", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ControlledComposition;Ljava/lang/Integer;Ljava/util/List;LS7/a;)Ljava/lang/Object;", "currentStackTrace", "dataOffset", "stackTraceForGroup", "(ILjava/lang/Integer;)Ljava/util/List;", "doCompose-aFTiNEg", "(Landroidx/collection/MutableScatterMap;LS7/n;)V", "doCompose", "nodeAt", "(Landroidx/compose/runtime/SlotReader;I)Ljava/lang/Object;", "validateNodeExpected", "validateNodeNotExpected", "anchor", "recordInsert", "(Landroidx/compose/runtime/Anchor;)V", "recordDelete", "groupBeingRemoved", "reportFreeMovableContent", "reportAllMovableContent", "finalizeCompose", "cleanUpCompose", "groupKey", "rGroupIndex", "updateCompositeKeyWhenWeEnterGroup", "(IILjava/lang/Object;Ljava/lang/Object;)V", "updateCompositeKeyWhenWeEnterGroupKeyHash", "updateCompositeKeyWhenWeExitGroup", "updateCompositeKeyWhenWeExitGroupKeyHash", "Landroidx/compose/runtime/Applier;", "getApplier", "()Landroidx/compose/runtime/Applier;", "Landroidx/compose/runtime/CompositionContext;", "Landroidx/compose/runtime/SlotTable;", "Ljava/util/Set;", "Landroidx/compose/runtime/changelist/ChangeList;", "Landroidx/compose/runtime/CompositionObserverHolder;", "Landroidx/compose/runtime/CompositionImpl;", "getComposition", "()Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/Stack;", "pendingStack", "Ljava/util/ArrayList;", "pending", "Landroidx/compose/runtime/Pending;", "nodeIndex", "I", "groupNodeCount", "Landroidx/compose/runtime/IntStack;", "parentStateStack", "Landroidx/compose/runtime/IntStack;", "", "nodeCountOverrides", "[I", "Landroidx/collection/MutableIntIntMap;", "nodeCountVirtualOverrides", "Landroidx/collection/MutableIntIntMap;", "Z", "forciblyRecompose", "nodeExpected", "", "Landroidx/compose/runtime/Invalidation;", "Ljava/util/List;", "entersStack", "rootProvider", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "Landroidx/collection/MutableIntObjectMap;", "providerUpdates", "Landroidx/collection/MutableIntObjectMap;", "providersInvalid", "providersInvalidStack", "reusing", "reusingGroup", "childrenComposing", "compositionToken", "sourceMarkersEnabled", "androidx/compose/runtime/ComposerImpl$derivedStateObserver$1", "derivedStateObserver", "Landroidx/compose/runtime/ComposerImpl$derivedStateObserver$1;", "invalidateStack", "isComposing", "isComposing$runtime", "isDisposed", "isDisposed$runtime", "Landroidx/compose/runtime/SlotReader;", "getReader$runtime", "()Landroidx/compose/runtime/SlotReader;", "setReader$runtime", "(Landroidx/compose/runtime/SlotReader;)V", "insertTable", "getInsertTable$runtime", "()Landroidx/compose/runtime/SlotTable;", "setInsertTable$runtime", "(Landroidx/compose/runtime/SlotTable;)V", "Landroidx/compose/runtime/SlotWriter;", "writer", "Landroidx/compose/runtime/SlotWriter;", "writerHasAProvider", "providerCache", "deferredChanges", "getDeferredChanges$runtime", "()Landroidx/compose/runtime/changelist/ChangeList;", "setDeferredChanges$runtime", "(Landroidx/compose/runtime/changelist/ChangeList;)V", "Landroidx/compose/runtime/changelist/ComposerChangeListWriter;", "changeListWriter", "Landroidx/compose/runtime/changelist/ComposerChangeListWriter;", "insertAnchor", "Landroidx/compose/runtime/Anchor;", "Landroidx/compose/runtime/changelist/FixupList;", "insertFixups", "Landroidx/compose/runtime/changelist/FixupList;", "pausable", "shouldPauseCallback", "Landroidx/compose/runtime/ShouldPauseCallback;", "Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "errorContext", "Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "getErrorContext$runtime", "()Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "LH7/h;", "applyCoroutineContext", "LH7/h;", "getApplyCoroutineContext", "()LH7/h;", "getInserting", "getInserting$annotations", "compositeKeyHashCode", "J", "getCompositeKeyHashCode", "()J", "getCompositeKeyHashCode$annotations", "Landroidx/compose/runtime/tooling/CompositionData;", "_compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "getAreChildrenComposing$runtime", "areChildrenComposing", "getHasPendingChanges$runtime", "hasPendingChanges", "getDefaultsInvalid", "getDefaultsInvalid$annotations", "defaultsInvalid", "getSkipping", "getSkipping$annotations", "skipping", "getCurrentMarker", "currentMarker", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "compositionData", "Landroidx/compose/runtime/CompositionLocalMap;", "getCurrentCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "currentCompositionLocalMap", "getChangeCount$runtime", "changeCount", "getCurrentRecomposeScope$runtime", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "currentRecomposeScope", "getHasInvalidations", "hasInvalidations", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScope", "getRecomposeScopeIdentity", "recomposeScopeIdentity", "getNode", "(Landroidx/compose/runtime/SlotReader;)Ljava/lang/Object;", "node", "CompositionContextHolder", "CompositionContextImpl", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposerImpl implements Composer {
    public static final int $stable = 8;
    private CompositionData _compositionData;
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final H7.h applyCoroutineContext;
    private final ComposerChangeListWriter changeListWriter;
    private ChangeList changes;
    private int childrenComposing;
    private long compositeKeyHashCode;
    private final CompositionImpl composition;
    private int compositionToken;
    private ChangeList deferredChanges;
    private final ComposerImpl$derivedStateObserver$1 derivedStateObserver;
    private final CompositionErrorContextImpl errorContext;
    private boolean forceRecomposeScopes;
    private boolean forciblyRecompose;
    private int groupNodeCount;
    private Anchor insertAnchor;
    private FixupList insertFixups;
    private SlotTable insertTable;
    private boolean inserting;
    private final ArrayList invalidateStack;
    private boolean isComposing;
    private boolean isDisposed;
    private ChangeList lateChanges;
    private int[] nodeCountOverrides;
    private MutableIntIntMap nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parentContext;
    private boolean pausable;
    private Pending pending;
    private PersistentCompositionLocalMap providerCache;
    private MutableIntObjectMap<PersistentCompositionLocalMap> providerUpdates;
    private boolean providersInvalid;
    private int rGroupIndex;
    private SlotReader reader;
    private boolean reusing;
    private ShouldPauseCallback shouldPauseCallback;
    private final SlotTable slotTable;
    private boolean sourceMarkersEnabled;
    private SlotWriter writer;
    private boolean writerHasAProvider;
    private final ArrayList pendingStack = Stack.m3459constructorimpl$default(null, 1, null);
    private final IntStack parentStateStack = new IntStack();
    private final List<Invalidation> invalidations = new ArrayList();
    private final IntStack entersStack = new IntStack();
    private PersistentCompositionLocalMap rootProvider = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
    private final IntStack providersInvalidStack = new IntStack();
    private int reusingGroup = -1;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002R\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\tR\u001b\u0010\u0004\u001a\u00060\u0002R\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextHolder;", "Landroidx/compose/runtime/ReusableRememberObserver;", "Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/ComposerImpl;", "ref", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;)V", "LC7/r;", "onRemembered", "()V", "onAbandoned", "onForgotten", "Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "getRef", "()Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CompositionContextHolder implements ReusableRememberObserver {
        public static final int $stable = 8;
        private final CompositionContextImpl ref;

        public CompositionContextHolder(CompositionContextImpl compositionContextImpl) {
            this.ref = compositionContextImpl;
        }

        public final CompositionContextImpl getRef() {
            return this.ref;
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onAbandoned() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onForgotten() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onRemembered() {
        }
    }

    @Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B-\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0010¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0010¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010!\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0010¢\u0006\u0004\b\u001f\u0010 J*\u0010'\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\f0\"¢\u0006\u0002\b#H\u0010¢\u0006\u0004\b%\u0010&J8\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001d0*2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010)\u001a\u00020(2\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\f0\"¢\u0006\u0002\b#H\u0010¢\u0006\u0004\b+\u0010,J3\u00101\u001a\b\u0012\u0004\u0012\u00020\u001d0*2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010)\u001a\u00020(2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001d0*H\u0010¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0010¢\u0006\u0004\b2\u0010\u0019J\u0017\u00105\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0010¢\u0006\u0004\b4\u0010 J\u000f\u00109\u001a\u000206H\u0010¢\u0006\u0004\b7\u00108J\u0015\u0010:\u001a\u00020\f2\u0006\u0010\u001e\u001a\u000206¢\u0006\u0004\b:\u0010;J\u001d\u0010A\u001a\u00020\f2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020=0<H\u0010¢\u0006\u0004\b?\u0010@J\u000f\u0010C\u001a\u00020\fH\u0010¢\u0006\u0004\bB\u0010\u000eJ\u000f\u0010E\u001a\u00020\fH\u0010¢\u0006\u0004\bD\u0010\u000eJ\u0017\u0010J\u001a\u00020\f2\u0006\u0010G\u001a\u00020FH\u0010¢\u0006\u0004\bH\u0010IJ\u0017\u0010L\u001a\u00020\f2\u0006\u0010G\u001a\u00020FH\u0010¢\u0006\u0004\bK\u0010IJ\u0019\u0010P\u001a\u0004\u0018\u00010M2\u0006\u0010G\u001a\u00020FH\u0010¢\u0006\u0004\bN\u0010OJ+\u0010V\u001a\u00020\f2\u0006\u0010G\u001a\u00020F2\u0006\u0010Q\u001a\u00020M2\n\u0010S\u001a\u0006\u0012\u0002\b\u00030RH\u0010¢\u0006\u0004\bT\u0010UJ\u0017\u0010X\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0010¢\u0006\u0004\bW\u0010\u0019R\u001e\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u0004\u0010Y\u001a\u0004\bZ\u0010[R\u001a\u0010\u0006\u001a\u00020\u00058\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u0006\u0010\\\u001a\u0004\b]\u0010^R\u001a\u0010\u0007\u001a\u00020\u00058\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u0007\u0010\\\u001a\u0004\b_\u0010^R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\t\u0010`\u001a\u0004\ba\u0010bR0\u0010c\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<\u0018\u00010<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010@R\u001d\u0010i\u001a\b\u0012\u0004\u0012\u00020h0<8\u0006¢\u0006\f\n\u0004\bi\u0010d\u001a\u0004\bj\u0010fR+\u0010o\u001a\u0002062\u0006\u0010k\u001a\u0002068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\b9\u00108\"\u0004\bn\u0010;R\u0014\u0010q\u001a\u00020\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bp\u0010^R\u0014\u0010u\u001a\u00020r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bs\u0010tR\u001a\u0010x\u001a\u00020r8PX\u0090\u0004¢\u0006\f\u0012\u0004\bw\u0010\u000e\u001a\u0004\bv\u0010tR\u0014\u0010\u0017\u001a\u00020y8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bz\u0010{¨\u0006|"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "compositeKeyHashCode", "", "collectingParameterInformation", "collectingSourceInformation", "Landroidx/compose/runtime/CompositionObserverHolder;", "observerHolder", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/ComposerImpl;JZZLandroidx/compose/runtime/CompositionObserverHolder;)V", "LC7/r;", "dispose", "()V", "Landroidx/compose/runtime/Composer;", "composer", "registerComposer$runtime", "(Landroidx/compose/runtime/Composer;)V", "registerComposer", "unregisterComposer$runtime", "unregisterComposer", "Landroidx/compose/runtime/ControlledComposition;", "composition", "registerComposition$runtime", "(Landroidx/compose/runtime/ControlledComposition;)V", "registerComposition", "unregisterComposition$runtime", "unregisterComposition", "Landroidx/compose/runtime/RecomposeScopeImpl;", "scope", "reportPausedScope$runtime", "(Landroidx/compose/runtime/RecomposeScopeImpl;)V", "reportPausedScope", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "composeInitial$runtime", "(Landroidx/compose/runtime/ControlledComposition;LS7/n;)V", "composeInitial", "Landroidx/compose/runtime/ShouldPauseCallback;", "shouldPause", "Landroidx/collection/ScatterSet;", "composeInitialPaused$runtime", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;LS7/n;)Landroidx/collection/ScatterSet;", "composeInitialPaused", "invalidScopes", "recomposePaused$runtime", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;Landroidx/collection/ScatterSet;)Landroidx/collection/ScatterSet;", "recomposePaused", "invalidate$runtime", "invalidate", "invalidateScope$runtime", "invalidateScope", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "getCompositionLocalScope$runtime", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "getCompositionLocalScope", "updateCompositionLocalScope", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", "", "Landroidx/compose/runtime/tooling/CompositionData;", "table", "recordInspectionTable$runtime", "(Ljava/util/Set;)V", "recordInspectionTable", "startComposing$runtime", "startComposing", "doneComposing$runtime", "doneComposing", "Landroidx/compose/runtime/MovableContentStateReference;", TypedValues.Custom.S_REFERENCE, "insertMovableContent$runtime", "(Landroidx/compose/runtime/MovableContentStateReference;)V", "insertMovableContent", "deletedMovableContent$runtime", "deletedMovableContent", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateResolve$runtime", "(Landroidx/compose/runtime/MovableContentStateReference;)Landroidx/compose/runtime/MovableContentState;", "movableContentStateResolve", SettingsConfig.KEY_DATA, "Landroidx/compose/runtime/Applier;", "applier", "movableContentStateReleased$runtime", "(Landroidx/compose/runtime/MovableContentStateReference;Landroidx/compose/runtime/MovableContentState;Landroidx/compose/runtime/Applier;)V", "movableContentStateReleased", "reportRemovedComposition$runtime", "reportRemovedComposition", "J", "getCompositeKeyHashCode$runtime", "()J", "Z", "getCollectingParameterInformation$runtime", "()Z", "getCollectingSourceInformation$runtime", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime", "()Landroidx/compose/runtime/CompositionObserverHolder;", "inspectionTables", "Ljava/util/Set;", "getInspectionTables", "()Ljava/util/Set;", "setInspectionTables", "Landroidx/compose/runtime/ComposerImpl;", "composers", "getComposers", "<set-?>", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "setCompositionLocalScope", "compositionLocalScope", "getCollectingCallByInformation$runtime", "collectingCallByInformation", "LH7/h;", "getEffectCoroutineContext", "()LH7/h;", "effectCoroutineContext", "getRecomposeCoroutineContext$runtime", "getRecomposeCoroutineContext$runtime$annotations", "recomposeCoroutineContext", "Landroidx/compose/runtime/Composition;", "getComposition$runtime", "()Landroidx/compose/runtime/Composition;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;
        private final boolean collectingSourceInformation;
        private final long compositeKeyHashCode;
        private Set<Set<CompositionData>> inspectionTables;
        private final CompositionObserverHolder observerHolder;
        private final Set<ComposerImpl> composers = new LinkedHashSet();

        /* renamed from: compositionLocalScope$delegate, reason: from kotlin metadata */
        private final MutableState compositionLocalScope = SnapshotStateKt.mutableStateOf(PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf(), SnapshotStateKt.referentialEqualityPolicy());

        public CompositionContextImpl(long j5, boolean z10, boolean z11, CompositionObserverHolder compositionObserverHolder) {
            this.compositeKeyHashCode = j5;
            this.collectingParameterInformation = z10;
            this.collectingSourceInformation = z11;
            this.observerHolder = compositionObserverHolder;
        }

        private final PersistentCompositionLocalMap getCompositionLocalScope() {
            return (PersistentCompositionLocalMap) this.compositionLocalScope.getValue();
        }

        public static /* synthetic */ void getRecomposeCoroutineContext$runtime$annotations() {
        }

        private final void setCompositionLocalScope(PersistentCompositionLocalMap persistentCompositionLocalMap) {
            this.compositionLocalScope.setValue(persistentCompositionLocalMap);
        }

        @Override // androidx.compose.runtime.CompositionContext
        @ComposableInferredTarget(scheme = "[0[0]]")
        public void composeInitial$runtime(ControlledComposition composition, n content) {
            ComposerImpl.this.parentContext.composeInitial$runtime(composition, content);
        }

        @Override // androidx.compose.runtime.CompositionContext
        @ComposableInferredTarget(scheme = "[0[0]]")
        public ScatterSet<RecomposeScopeImpl> composeInitialPaused$runtime(ControlledComposition composition, ShouldPauseCallback shouldPause, n content) {
            return ComposerImpl.this.parentContext.composeInitialPaused$runtime(composition, shouldPause, content);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void deletedMovableContent$runtime(MovableContentStateReference reference) {
            ComposerImpl.this.parentContext.deletedMovableContent$runtime(reference);
        }

        public final void dispose() {
            if (this.composers.isEmpty()) {
                return;
            }
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                for (ComposerImpl composerImpl : this.composers) {
                    Iterator<Set<CompositionData>> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().remove(composerImpl.slotTable);
                    }
                }
            }
            this.composers.clear();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void doneComposing$runtime() {
            ComposerImpl.this.childrenComposing--;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getCollectingCallByInformation$runtime() {
            return ComposerImpl.this.parentContext.getCollectingCallByInformation$runtime();
        }

        @Override // androidx.compose.runtime.CompositionContext
        /* renamed from: getCollectingParameterInformation$runtime, reason: from getter */
        public boolean getCollectingParameterInformation() {
            return this.collectingParameterInformation;
        }

        @Override // androidx.compose.runtime.CompositionContext
        /* renamed from: getCollectingSourceInformation$runtime, reason: from getter */
        public boolean getCollectingSourceInformation() {
            return this.collectingSourceInformation;
        }

        public final Set<ComposerImpl> getComposers() {
            return this.composers;
        }

        @Override // androidx.compose.runtime.CompositionContext
        /* renamed from: getCompositeKeyHashCode$runtime, reason: from getter */
        public long getCompositeKeyHashCode() {
            return this.compositeKeyHashCode;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public Composition getComposition$runtime() {
            return ComposerImpl.this.getComposition();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public PersistentCompositionLocalMap getCompositionLocalScope$runtime() {
            return getCompositionLocalScope();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public H7.h getEffectCoroutineContext() {
            return ComposerImpl.this.parentContext.getEffectCoroutineContext();
        }

        public final Set<Set<CompositionData>> getInspectionTables() {
            return this.inspectionTables;
        }

        @Override // androidx.compose.runtime.CompositionContext
        /* renamed from: getObserverHolder$runtime, reason: from getter */
        public CompositionObserverHolder getObserverHolder() {
            return this.observerHolder;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public H7.h getRecomposeCoroutineContext$runtime() {
            return CompositionKt.getRecomposeCoroutineContext(ComposerImpl.this.getComposition());
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void insertMovableContent$runtime(MovableContentStateReference reference) {
            ComposerImpl.this.parentContext.insertMovableContent$runtime(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidate$runtime(ControlledComposition composition) {
            ComposerImpl.this.parentContext.invalidate$runtime(ComposerImpl.this.getComposition());
            ComposerImpl.this.parentContext.invalidate$runtime(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidateScope$runtime(RecomposeScopeImpl scope) {
            ComposerImpl.this.parentContext.invalidateScope$runtime(scope);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void movableContentStateReleased$runtime(MovableContentStateReference reference, MovableContentState data, Applier<?> applier) {
            ComposerImpl.this.parentContext.movableContentStateReleased$runtime(reference, data, applier);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public MovableContentState movableContentStateResolve$runtime(MovableContentStateReference reference) {
            return ComposerImpl.this.parentContext.movableContentStateResolve$runtime(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public ScatterSet<RecomposeScopeImpl> recomposePaused$runtime(ControlledComposition composition, ShouldPauseCallback shouldPause, ScatterSet<RecomposeScopeImpl> invalidScopes) {
            return ComposerImpl.this.parentContext.recomposePaused$runtime(composition, shouldPause, invalidScopes);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void recordInspectionTable$runtime(Set<CompositionData> table) {
            Set hashSet = this.inspectionTables;
            if (hashSet == null) {
                hashSet = new HashSet();
                this.inspectionTables = hashSet;
            }
            hashSet.add(table);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposer$runtime(Composer composer) {
            kotlin.jvm.internal.k.d(composer, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
            super.registerComposer$runtime((ComposerImpl) composer);
            this.composers.add(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposition$runtime(ControlledComposition composition) {
            ComposerImpl.this.parentContext.registerComposition$runtime(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void reportPausedScope$runtime(RecomposeScopeImpl scope) {
            ComposerImpl.this.parentContext.reportPausedScope$runtime(scope);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void reportRemovedComposition$runtime(ControlledComposition composition) {
            ComposerImpl.this.parentContext.reportRemovedComposition$runtime(composition);
        }

        public final void setInspectionTables(Set<Set<CompositionData>> set) {
            this.inspectionTables = set;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void startComposing$runtime() {
            ComposerImpl.this.childrenComposing++;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposer$runtime(Composer composer) {
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    Set set2 = (Set) it.next();
                    kotlin.jvm.internal.k.d(composer, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
                    set2.remove(((ComposerImpl) composer).slotTable);
                }
            }
            p.a(this.composers).remove(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposition$runtime(ControlledComposition composition) {
            ComposerImpl.this.parentContext.unregisterComposition$runtime(composition);
        }

        public final void updateCompositionLocalScope(PersistentCompositionLocalMap scope) {
            setCompositionLocalScope(scope);
        }
    }

    /* JADX WARN: Type inference failed for: r5v11, types: [androidx.compose.runtime.ComposerImpl$derivedStateObserver$1] */
    public ComposerImpl(Applier<?> applier, CompositionContext compositionContext, SlotTable slotTable, Set<RememberObserver> set, ChangeList changeList, ChangeList changeList2, CompositionObserverHolder compositionObserverHolder, CompositionImpl compositionImpl) {
        this.applier = applier;
        this.parentContext = compositionContext;
        this.slotTable = slotTable;
        this.abandonSet = set;
        this.changes = changeList;
        this.lateChanges = changeList2;
        this.observerHolder = compositionObserverHolder;
        this.composition = compositionImpl;
        this.sourceMarkersEnabled = compositionContext.getCollectingSourceInformation() || compositionContext.getCollectingCallByInformation$runtime();
        this.derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.ComposerImpl$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(DerivedState<?> derivedState) {
                this.this$0.childrenComposing--;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(DerivedState<?> derivedState) {
                this.this$0.childrenComposing++;
            }
        };
        this.invalidateStack = Stack.m3459constructorimpl$default(null, 1, null);
        SlotReader slotReaderOpenReader = slotTable.openReader();
        slotReaderOpenReader.close();
        this.reader = slotReaderOpenReader;
        SlotTable slotTable2 = new SlotTable();
        if (compositionContext.getCollectingSourceInformation()) {
            slotTable2.collectSourceInformation();
        }
        if (compositionContext.getCollectingCallByInformation$runtime()) {
            slotTable2.collectCalledByInformation();
        }
        this.insertTable = slotTable2;
        SlotWriter slotWriterOpenWriter = slotTable2.openWriter();
        slotWriterOpenWriter.close(true);
        this.writer = slotWriterOpenWriter;
        this.changeListWriter = new ComposerChangeListWriter(this, this.changes);
        SlotReader slotReaderOpenReader2 = this.insertTable.openReader();
        try {
            Anchor anchor = slotReaderOpenReader2.anchor(0);
            slotReaderOpenReader2.close();
            this.insertAnchor = anchor;
            this.insertFixups = new FixupList();
            this.errorContext = new CompositionErrorContextImpl(this);
            H7.h effectCoroutineContext = compositionContext.getEffectCoroutineContext();
            H7.h errorContext$runtime = getErrorContext$runtime();
            this.applyCoroutineContext = effectCoroutineContext.plus(errorContext$runtime == null ? EmptyCoroutineContext.f4908a : errorContext$runtime);
        } catch (Throwable th) {
            slotReaderOpenReader2.close();
            throw th;
        }
    }

    private final void abortRoot() {
        cleanUpCompose();
        Stack.m3457clearimpl(this.pendingStack);
        this.parentStateStack.clear();
        this.entersStack.clear();
        this.providersInvalidStack.clear();
        this.providerUpdates = null;
        this.insertFixups.clear();
        this.compositeKeyHashCode = 0;
        this.childrenComposing = 0;
        this.nodeExpected = false;
        this.inserting = false;
        this.reusing = false;
        this.isComposing = false;
        this.forciblyRecompose = false;
        this.reusingGroup = -1;
        if (!this.reader.getClosed()) {
            this.reader.close();
        }
        if (this.writer.getClosed()) {
            return;
        }
        forceFreshInsertTable();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void addRecomposeScope() {
        /*
            r4 = this;
            boolean r0 = r4.getInserting()
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl"
            if (r0 == 0) goto L20
            androidx.compose.runtime.RecomposeScopeImpl r0 = new androidx.compose.runtime.RecomposeScopeImpl
            androidx.compose.runtime.CompositionImpl r2 = r4.getComposition()
            kotlin.jvm.internal.k.d(r2, r1)
            r0.<init>(r2)
            java.util.ArrayList r1 = r4.invalidateStack
            androidx.compose.runtime.Stack.m3469pushimpl(r1, r0)
            r4.updateValue(r0)
            r4.enterRecomposeScope(r0)
            return
        L20:
            java.util.List<androidx.compose.runtime.Invalidation> r0 = r4.invalidations
            androidx.compose.runtime.SlotReader r2 = r4.reader
            int r2 = r2.getParent()
            androidx.compose.runtime.Invalidation r0 = androidx.compose.runtime.ComposerKt.access$removeLocation(r0, r2)
            androidx.compose.runtime.SlotReader r2 = r4.reader
            java.lang.Object r2 = r2.next()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.INSTANCE
            java.lang.Object r3 = r3.getEmpty()
            boolean r3 = kotlin.jvm.internal.k.b(r2, r3)
            if (r3 == 0) goto L4e
            androidx.compose.runtime.RecomposeScopeImpl r2 = new androidx.compose.runtime.RecomposeScopeImpl
            androidx.compose.runtime.CompositionImpl r3 = r4.getComposition()
            kotlin.jvm.internal.k.d(r3, r1)
            r2.<init>(r3)
            r4.updateValue(r2)
            goto L55
        L4e:
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl"
            kotlin.jvm.internal.k.d(r2, r1)
            androidx.compose.runtime.RecomposeScopeImpl r2 = (androidx.compose.runtime.RecomposeScopeImpl) r2
        L55:
            r1 = 0
            r3 = 1
            if (r0 != 0) goto L67
            boolean r0 = r2.getForcedRecompose()
            if (r0 == 0) goto L62
            r2.setForcedRecompose(r1)
        L62:
            if (r0 == 0) goto L65
            goto L67
        L65:
            r0 = r1
            goto L68
        L67:
            r0 = r3
        L68:
            r2.setRequiresRecompose(r0)
            java.util.ArrayList r0 = r4.invalidateStack
            androidx.compose.runtime.Stack.m3469pushimpl(r0, r2)
            r4.enterRecomposeScope(r2)
            boolean r0 = r2.getPaused()
            if (r0 == 0) goto L93
            r2.setPaused(r1)
            r2.setResuming(r3)
            androidx.compose.runtime.changelist.ComposerChangeListWriter r0 = r4.changeListWriter
            r0.startResumingScope(r2)
            boolean r0 = r4.reusing
            if (r0 != 0) goto L93
            boolean r0 = r2.getReusing()
            if (r0 == 0) goto L93
            r4.reusing = r3
            r2.setResetReusing(r3)
        L93:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.addRecomposeScope():void");
    }

    private final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.compositeKeyHashCode = 0L;
        this.nodeExpected = false;
        this.changeListWriter.resetTransientState();
        Stack.m3457clearimpl(this.invalidateStack);
        clearUpdatedNodeCounts();
    }

    private final void clearUpdatedNodeCounts() {
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    private final long compositeKeyOf(int group, int recomposeGroup, long recomposeKey) {
        long jRotateLeft;
        long jRotateLeft2 = 0;
        int i = 3;
        int i6 = 0;
        while (group >= 0) {
            if (group == recomposeGroup) {
                jRotateLeft = Long.rotateLeft(recomposeKey, i6);
            } else {
                int iGroupCompositeKeyPart = groupCompositeKeyPart(this.reader, group);
                if (iGroupCompositeKeyPart == 126665345) {
                    jRotateLeft = Long.rotateLeft(iGroupCompositeKeyPart, i6);
                } else {
                    jRotateLeft2 = (jRotateLeft2 ^ Long.rotateLeft(iGroupCompositeKeyPart, i)) ^ Long.rotateLeft(this.reader.hasObjectKey(group) ? 0 : rGroupIndexOf(group), i6);
                    i = (i + 6) % 64;
                    i6 = (i6 + 6) % 64;
                    group = this.reader.parent(group);
                }
            }
            return jRotateLeft ^ jRotateLeft2;
        }
        return jRotateLeft2;
    }

    private final void createFreshInsertTable() {
        if (!this.writer.getClosed()) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        forceFreshInsertTable();
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope() {
        PersistentCompositionLocalMap persistentCompositionLocalMap = this.providerCache;
        return persistentCompositionLocalMap != null ? persistentCompositionLocalMap : currentCompositionLocalScope(this.reader.getParent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ComposeStackTraceFrame> currentStackTrace() {
        if (!this.sourceMarkersEnabled) {
            return EmptyList.f4893a;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(ComposeStackTraceBuilderKt.buildTrace$default(this.writer, null, 0, null, 7, null));
        arrayList.addAll(ComposeStackTraceBuilderKt.buildTrace(this.reader));
        arrayList.addAll(parentStackTrace());
        return arrayList;
    }

    /* renamed from: doCompose-aFTiNEg, reason: not valid java name */
    private final void m3413doComposeaFTiNEg(MutableScatterMap<Object, Object> invalidationsRequested, n content) {
        if (this.isComposing) {
            ComposerKt.composeImmediateRuntimeError("Reentrant composition is not supported");
        }
        CompositionObserver compositionObserverCurrent = this.observerHolder.current();
        Trace trace = Trace.INSTANCE;
        Object objBeginSection = trace.beginSection("Compose:recompose");
        try {
            this.compositionToken = Long.hashCode(SnapshotKt.currentSnapshot().getSnapshotId());
            this.providerUpdates = null;
            m3417updateComposerInvalidationsRY85e9Y(invalidationsRequested);
            this.nodeIndex = 0;
            this.isComposing = true;
            if (compositionObserverCurrent != null) {
                compositionObserverCurrent.onBeginComposition(getComposition());
            }
            try {
                startRoot();
                Object objNextSlot = nextSlot();
                if (objNextSlot != content && content != null) {
                    updateValue(content);
                }
                ComposerImpl$derivedStateObserver$1 composerImpl$derivedStateObserver$1 = this.derivedStateObserver;
                MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
                try {
                    mutableVectorDerivedStateObservers.add(composerImpl$derivedStateObserver$1);
                    if (content != null) {
                        startGroup(200, ComposerKt.getInvocation());
                        Expect_jvmKt.invokeComposable(this, content);
                        endGroup();
                    } else if ((!this.forciblyRecompose && !this.providersInvalid) || objNextSlot == null || objNextSlot.equals(Composer.INSTANCE.getEmpty())) {
                        skipCurrentGroup();
                    } else {
                        startGroup(200, ComposerKt.getInvocation());
                        p.e(2, objNextSlot);
                        Expect_jvmKt.invokeComposable(this, (n) objNextSlot);
                        endGroup();
                    }
                    mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                    endRoot();
                    if (compositionObserverCurrent != null) {
                        compositionObserverCurrent.onEndComposition(getComposition());
                    }
                    this.isComposing = false;
                    this.invalidations.clear();
                    createFreshInsertTable();
                    trace.endSection(objBeginSection);
                } catch (Throwable th) {
                    mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                    throw th;
                }
            } finally {
            }
        } catch (Throwable th2) {
            Trace.INSTANCE.endSection(objBeginSection);
            throw th2;
        }
    }

    private final void doRecordDownsFor(int group, int nearestCommonRoot) {
        if (group <= 0 || group == nearestCommonRoot) {
            return;
        }
        doRecordDownsFor(this.reader.parent(group), nearestCommonRoot);
        if (this.reader.isNode(group)) {
            this.changeListWriter.moveDown(nodeAt(this.reader, group));
        }
    }

    private final void end(boolean isNode) {
        long jRotateRight;
        long j5;
        int remainingSlots;
        List<KeyInfo> list;
        List<KeyInfo> list2;
        long jRotateRight2;
        long j6;
        int iPeek2 = this.parentStateStack.peek2() - 1;
        if (getInserting()) {
            int parent = this.writer.getParent();
            int iGroupKey = this.writer.groupKey(parent);
            Object objGroupObjectKey = this.writer.groupObjectKey(parent);
            Object objGroupAux = this.writer.groupAux(parent);
            if (objGroupObjectKey != null) {
                int iOrdinal = objGroupObjectKey instanceof Enum ? ((Enum) objGroupObjectKey).ordinal() : objGroupObjectKey.hashCode();
                jRotateRight2 = Long.rotateRight(getCompositeKeyHashCode() ^ 0, 3);
                j6 = iOrdinal;
            } else if (objGroupAux == null || iGroupKey != 207 || objGroupAux.equals(Composer.INSTANCE.getEmpty())) {
                jRotateRight2 = Long.rotateRight(getCompositeKeyHashCode() ^ iPeek2, 3);
                j6 = iGroupKey;
            } else {
                this.compositeKeyHashCode = Long.rotateRight(objGroupAux.hashCode() ^ Long.rotateRight(getCompositeKeyHashCode() ^ iPeek2, 3), 3);
            }
            this.compositeKeyHashCode = Long.rotateRight(jRotateRight2 ^ j6, 3);
        } else {
            int parent2 = this.reader.getParent();
            int iGroupKey2 = this.reader.groupKey(parent2);
            Object objGroupObjectKey2 = this.reader.groupObjectKey(parent2);
            Object objGroupAux2 = this.reader.groupAux(parent2);
            if (objGroupObjectKey2 != null) {
                int iOrdinal2 = objGroupObjectKey2 instanceof Enum ? ((Enum) objGroupObjectKey2).ordinal() : objGroupObjectKey2.hashCode();
                jRotateRight = Long.rotateRight(getCompositeKeyHashCode() ^ 0, 3);
                j5 = iOrdinal2;
            } else if (objGroupAux2 == null || iGroupKey2 != 207 || objGroupAux2.equals(Composer.INSTANCE.getEmpty())) {
                jRotateRight = Long.rotateRight(getCompositeKeyHashCode() ^ iPeek2, 3);
                j5 = iGroupKey2;
            } else {
                this.compositeKeyHashCode = Long.rotateRight(objGroupAux2.hashCode() ^ Long.rotateRight(getCompositeKeyHashCode() ^ iPeek2, 3), 3);
            }
            this.compositeKeyHashCode = Long.rotateRight(jRotateRight ^ j5, 3);
        }
        int i = this.groupNodeCount;
        Pending pending = this.pending;
        if (pending != null && pending.getKeyInfos().size() > 0) {
            List<KeyInfo> keyInfos = pending.getKeyInfos();
            List<KeyInfo> used = pending.getUsed();
            Set setFastToSet = ListUtilsKt.fastToSet(used);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size = used.size();
            int size2 = keyInfos.size();
            int i6 = 0;
            int i10 = 0;
            int iUpdatedNodeCountOf = 0;
            while (i6 < size2) {
                KeyInfo keyInfo = keyInfos.get(i6);
                if (setFastToSet.contains(keyInfo)) {
                    list = keyInfos;
                    if (!linkedHashSet.contains(keyInfo)) {
                        if (i10 < size) {
                            KeyInfo keyInfo2 = used.get(i10);
                            if (keyInfo2 != keyInfo) {
                                int iNodePositionOf = pending.nodePositionOf(keyInfo2);
                                linkedHashSet.add(keyInfo2);
                                if (iNodePositionOf != iUpdatedNodeCountOf) {
                                    int iUpdatedNodeCountOf2 = pending.updatedNodeCountOf(keyInfo2);
                                    list2 = used;
                                    this.changeListWriter.moveNode(pending.getStartIndex() + iNodePositionOf, iUpdatedNodeCountOf + pending.getStartIndex(), iUpdatedNodeCountOf2);
                                    pending.registerMoveNode(iNodePositionOf, iUpdatedNodeCountOf, iUpdatedNodeCountOf2);
                                } else {
                                    list2 = used;
                                }
                            } else {
                                list2 = used;
                                i6++;
                            }
                            i10++;
                            iUpdatedNodeCountOf += pending.updatedNodeCountOf(keyInfo2);
                            keyInfos = list;
                            used = list2;
                        }
                    }
                    keyInfos = list;
                } else {
                    this.changeListWriter.removeNode(pending.nodePositionOf(keyInfo) + pending.getStartIndex(), keyInfo.getNodes());
                    pending.updateNodeCount(keyInfo.getLocation(), 0);
                    this.changeListWriter.moveReaderRelativeTo(keyInfo.getLocation());
                    this.reader.reposition(keyInfo.getLocation());
                    recordDelete();
                    this.reader.skipGroup();
                    list = keyInfos;
                    ComposerKt.removeRange(this.invalidations, keyInfo.getLocation(), this.reader.groupSize(keyInfo.getLocation()) + keyInfo.getLocation());
                }
                i6++;
                keyInfos = list;
            }
            this.changeListWriter.endNodeMovement();
            if (keyInfos.size() > 0) {
                this.changeListWriter.moveReaderRelativeTo(this.reader.getGroupEnd());
                this.reader.skipToGroupEnd();
            }
        }
        boolean inserting = getInserting();
        if (!inserting && (remainingSlots = this.reader.getRemainingSlots()) > 0) {
            this.changeListWriter.trimValues(remainingSlots);
        }
        int i11 = this.nodeIndex;
        while (!this.reader.isGroupEnd()) {
            int currentGroup = this.reader.getCurrentGroup();
            recordDelete();
            this.changeListWriter.removeNode(i11, this.reader.skipGroup());
            ComposerKt.removeRange(this.invalidations, currentGroup, this.reader.getCurrentGroup());
        }
        if (inserting) {
            if (isNode) {
                this.insertFixups.endNodeInsert();
                i = 1;
            }
            this.reader.endEmpty();
            int parent3 = this.writer.getParent();
            this.writer.endGroup();
            if (!this.reader.getInEmpty()) {
                int iInsertedGroupVirtualIndex = insertedGroupVirtualIndex(parent3);
                this.writer.endInsert();
                this.writer.close(true);
                recordInsert(this.insertAnchor);
                this.inserting = false;
                if (!this.slotTable.isEmpty()) {
                    updateNodeCount(iInsertedGroupVirtualIndex, 0);
                    updateNodeCountOverrides(iInsertedGroupVirtualIndex, i);
                }
            }
        } else {
            if (isNode) {
                this.changeListWriter.moveUp();
            }
            this.changeListWriter.endCurrentGroup();
            int parent4 = this.reader.getParent();
            if (i != updatedNodeCount(parent4)) {
                updateNodeCountOverrides(parent4, i);
            }
            if (isNode) {
                i = 1;
            }
            this.reader.endGroup();
            this.changeListWriter.endNodeMovement();
        }
        exitGroup(i, inserting);
    }

    private final void endGroup() {
        end(false);
    }

    private final void endRoot() {
        endGroup();
        this.parentContext.doneComposing$runtime();
        endGroup();
        this.changeListWriter.endRoot();
        finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
        this.providersInvalid = ComposerKt.asBool(this.providersInvalidStack.pop());
    }

    private final void ensureWriter() {
        if (this.writer.getClosed()) {
            SlotWriter slotWriterOpenWriter = this.insertTable.openWriter();
            this.writer = slotWriterOpenWriter;
            slotWriterOpenWriter.skipToGroupEnd();
            this.writerHasAProvider = false;
            this.providerCache = null;
        }
    }

    private final void enterGroup(boolean isNode, Pending newPending) {
        Stack.m3469pushimpl(this.pendingStack, this.pending);
        this.pending = newPending;
        this.parentStateStack.push(this.groupNodeCount);
        this.parentStateStack.push(this.rGroupIndex);
        this.parentStateStack.push(this.nodeIndex);
        if (isNode) {
            this.nodeIndex = 0;
        }
        this.groupNodeCount = 0;
        this.rGroupIndex = 0;
    }

    private final void enterRecomposeScope(RecomposeScopeImpl scope) {
        scope.start(this.compositionToken);
        CompositionObserver compositionObserverCurrent = this.observerHolder.current();
        if (compositionObserverCurrent != null) {
            compositionObserverCurrent.onScopeEnter(scope);
        }
    }

    private final void exitGroup(int expectedNodeCount, boolean inserting) {
        Pending pending = (Pending) Stack.m3468popimpl(this.pendingStack);
        if (pending != null && !inserting) {
            pending.setGroupIndex(pending.getGroupIndex() + 1);
        }
        this.pending = pending;
        this.nodeIndex = this.parentStateStack.pop() + expectedNodeCount;
        this.rGroupIndex = this.parentStateStack.pop();
        this.groupNodeCount = this.parentStateStack.pop() + expectedNodeCount;
    }

    private final S7.k exitRecomposeScope(RecomposeScopeImpl scope) {
        CompositionObserver compositionObserverCurrent = this.observerHolder.current();
        if (compositionObserverCurrent != null) {
            compositionObserverCurrent.onScopeExit(scope);
        }
        return scope.end(this.compositionToken);
    }

    private final void finalizeCompose() {
        this.changeListWriter.finalizeComposition();
        if (!Stack.m3464isEmptyimpl(this.pendingStack)) {
            ComposerKt.composeImmediateRuntimeError("Start/end imbalance");
        }
        cleanUpCompose();
    }

    private final void forceFreshInsertTable() {
        SlotTable slotTable = new SlotTable();
        if (this.sourceMarkersEnabled) {
            slotTable.collectSourceInformation();
        }
        if (this.parentContext.getCollectingCallByInformation$runtime()) {
            slotTable.collectCalledByInformation();
        }
        this.insertTable = slotTable;
        SlotWriter slotWriterOpenWriter = slotTable.openWriter();
        slotWriterOpenWriter.close(true);
        this.writer = slotWriterOpenWriter;
    }

    @InternalComposeApi
    public static /* synthetic */ void getCompositeKeyHashCode$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getDefaultsInvalid$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getInserting$annotations() {
    }

    private final Object getNode(SlotReader slotReader) {
        return slotReader.node(slotReader.getParent());
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getSkipping$annotations() {
    }

    private final int groupCompositeKeyPart(SlotReader slotReader, int i) {
        Object objGroupAux;
        if (!slotReader.hasObjectKey(i)) {
            int iGroupKey = slotReader.groupKey(i);
            return (iGroupKey != 207 || (objGroupAux = slotReader.groupAux(i)) == null || objGroupAux.equals(Composer.INSTANCE.getEmpty())) ? iGroupKey : objGroupAux.hashCode();
        }
        Object objGroupObjectKey = slotReader.groupObjectKey(i);
        if (objGroupObjectKey != null) {
            return objGroupObjectKey instanceof Enum ? ((Enum) objGroupObjectKey).ordinal() : objGroupObjectKey instanceof MovableContent ? MovableContentKt.movableContentKey : objGroupObjectKey.hashCode();
        }
        return 0;
    }

    private final void insertMovableContentGuarded(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) throws Throwable {
        ComposerChangeListWriter composerChangeListWriter;
        ChangeList changeList;
        ComposerChangeListWriter composerChangeListWriter2;
        ChangeList changeList2;
        SlotTable slotTable$runtime;
        Anchor anchor$runtime;
        SlotReader slotReader;
        MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap;
        ComposerChangeListWriter composerChangeListWriter3;
        ChangeList changeList3;
        int i;
        int i6;
        SlotTable slotTable$runtime2;
        List<Pair<MovableContentStateReference, MovableContentStateReference>> list = references;
        ComposerChangeListWriter composerChangeListWriter4 = this.changeListWriter;
        ChangeList changeList4 = this.lateChanges;
        ChangeList changeList5 = composerChangeListWriter4.getChangeList();
        try {
            composerChangeListWriter4.setChangeList(changeList4);
            this.changeListWriter.resetSlots();
            int size = list.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                try {
                    Pair<MovableContentStateReference, MovableContentStateReference> pair = list.get(i11);
                    final MovableContentStateReference movableContentStateReference = (MovableContentStateReference) pair.f4886a;
                    MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) pair.b;
                    Anchor anchor$runtime2 = movableContentStateReference.getAnchor();
                    int iAnchorIndex = movableContentStateReference.getSlotTable().anchorIndex(anchor$runtime2);
                    IntRef intRef = new IntRef(i10, 1, null);
                    this.changeListWriter.determineMovableContentNodeIndex(intRef, anchor$runtime2);
                    if (movableContentStateReference2 == null) {
                        if (kotlin.jvm.internal.k.b(movableContentStateReference.getSlotTable(), this.insertTable)) {
                            createFreshInsertTable();
                        }
                        final SlotReader slotReaderOpenReader = movableContentStateReference.getSlotTable().openReader();
                        try {
                            slotReaderOpenReader.reposition(iAnchorIndex);
                            this.changeListWriter.moveReaderToAbsolute(iAnchorIndex);
                            final ChangeList changeList6 = new ChangeList();
                            recomposeMovableContent$default(this, null, null, null, null, new S7.a() { // from class: androidx.compose.runtime.c
                                @Override // S7.a
                                public final Object invoke() {
                                    return ComposerImpl.insertMovableContentGuarded$lambda$41$lambda$40$lambda$34$lambda$33(this.f1748a, changeList6, slotReaderOpenReader, movableContentStateReference);
                                }
                            }, 15, null);
                            this.changeListWriter.includeOperationsIn(changeList6, intRef);
                            slotReaderOpenReader.close();
                            composerChangeListWriter2 = composerChangeListWriter4;
                            changeList2 = changeList5;
                            i = size;
                            i6 = i11;
                        } finally {
                        }
                    } else {
                        MovableContentState movableContentStateMovableContentStateResolve$runtime = this.parentContext.movableContentStateResolve$runtime(movableContentStateReference2);
                        if (movableContentStateMovableContentStateResolve$runtime == null || (slotTable$runtime = movableContentStateMovableContentStateResolve$runtime.getSlotTable()) == null) {
                            slotTable$runtime = movableContentStateReference2.getSlotTable();
                        }
                        if (movableContentStateMovableContentStateResolve$runtime == null || (slotTable$runtime2 = movableContentStateMovableContentStateResolve$runtime.getSlotTable()) == null || (anchor$runtime = slotTable$runtime2.anchor(0)) == null) {
                            anchor$runtime = movableContentStateReference2.getAnchor();
                        }
                        List<? extends Object> listCollectNodesFrom = ComposerKt.collectNodesFrom(slotTable$runtime, anchor$runtime);
                        if (!listCollectNodesFrom.isEmpty()) {
                            this.changeListWriter.copyNodesToNewAnchorLocation(listCollectNodesFrom, intRef);
                            if (kotlin.jvm.internal.k.b(movableContentStateReference.getSlotTable(), this.slotTable)) {
                                int iAnchorIndex2 = this.slotTable.anchorIndex(anchor$runtime2);
                                updateNodeCount(iAnchorIndex2, updatedNodeCount(iAnchorIndex2) + listCollectNodesFrom.size());
                            }
                        }
                        this.changeListWriter.copySlotTableToAnchorLocation(movableContentStateMovableContentStateResolve$runtime, this.parentContext, movableContentStateReference2, movableContentStateReference);
                        SlotReader slotReaderOpenReader2 = slotTable$runtime.openReader();
                        try {
                            SlotReader slotReader2 = this.reader;
                            int[] iArr = this.nodeCountOverrides;
                            MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap2 = this.providerUpdates;
                            this.nodeCountOverrides = null;
                            this.providerUpdates = null;
                            try {
                                this.reader = slotReaderOpenReader2;
                                int iAnchorIndex3 = slotTable$runtime.anchorIndex(anchor$runtime);
                                slotReaderOpenReader2.reposition(iAnchorIndex3);
                                this.changeListWriter.moveReaderToAbsolute(iAnchorIndex3);
                                ChangeList changeList7 = new ChangeList();
                                ComposerChangeListWriter composerChangeListWriter5 = this.changeListWriter;
                                ChangeList changeList8 = composerChangeListWriter5.getChangeList();
                                try {
                                    composerChangeListWriter5.setChangeList(changeList7);
                                    slotReader = slotReaderOpenReader2;
                                    try {
                                        ComposerChangeListWriter composerChangeListWriter6 = this.changeListWriter;
                                        i = size;
                                        boolean implicitRootStart = composerChangeListWriter6.getImplicitRootStart();
                                        try {
                                            composerChangeListWriter6.setImplicitRootStart(false);
                                            movableContentStateReference2.transferPendingInvalidations$runtime();
                                            try {
                                                i6 = i11;
                                                mutableIntObjectMap = mutableIntObjectMap2;
                                                composerChangeListWriter2 = composerChangeListWriter4;
                                                composerChangeListWriter3 = composerChangeListWriter5;
                                                changeList2 = changeList5;
                                                changeList3 = changeList8;
                                                try {
                                                    recomposeMovableContent(movableContentStateReference2.getComposition(), movableContentStateReference.getComposition(), Integer.valueOf(slotReader.getCurrentGroup()), movableContentStateReference2.getInvalidations$runtime(), new A6.i(10, this, movableContentStateReference));
                                                    try {
                                                        composerChangeListWriter6.setImplicitRootStart(implicitRootStart);
                                                        try {
                                                            composerChangeListWriter3.setChangeList(changeList3);
                                                            this.changeListWriter.includeOperationsIn(changeList7, intRef);
                                                            try {
                                                                this.reader = slotReader2;
                                                                this.nodeCountOverrides = iArr;
                                                                this.providerUpdates = mutableIntObjectMap;
                                                                try {
                                                                    slotReader.close();
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    composerChangeListWriter = composerChangeListWriter2;
                                                                    changeList = changeList2;
                                                                    composerChangeListWriter.setChangeList(changeList);
                                                                    throw th;
                                                                }
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                slotReader.close();
                                                                throw th;
                                                            }
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            this.reader = slotReader2;
                                                            this.nodeCountOverrides = iArr;
                                                            this.providerUpdates = mutableIntObjectMap;
                                                            throw th;
                                                        }
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        composerChangeListWriter3.setChangeList(changeList3);
                                                        throw th;
                                                    }
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    composerChangeListWriter6.setImplicitRootStart(implicitRootStart);
                                                    throw th;
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                mutableIntObjectMap = mutableIntObjectMap2;
                                                changeList3 = changeList8;
                                                composerChangeListWriter3 = composerChangeListWriter5;
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            mutableIntObjectMap = mutableIntObjectMap2;
                                            composerChangeListWriter3 = composerChangeListWriter5;
                                            changeList3 = changeList8;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        mutableIntObjectMap = mutableIntObjectMap2;
                                        composerChangeListWriter3 = composerChangeListWriter5;
                                        changeList3 = changeList8;
                                        composerChangeListWriter3.setChangeList(changeList3);
                                        throw th;
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    mutableIntObjectMap = mutableIntObjectMap2;
                                    slotReader = slotReaderOpenReader2;
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                mutableIntObjectMap = mutableIntObjectMap2;
                                slotReader = slotReaderOpenReader2;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            slotReader = slotReaderOpenReader2;
                        }
                    }
                    this.changeListWriter.skipToEndOfCurrentGroup();
                    i11 = i6 + 1;
                    list = references;
                    size = i;
                    composerChangeListWriter4 = composerChangeListWriter2;
                    changeList5 = changeList2;
                    i10 = 0;
                } catch (Throwable th12) {
                    th = th12;
                    composerChangeListWriter2 = composerChangeListWriter4;
                    changeList2 = changeList5;
                }
            }
            ComposerChangeListWriter composerChangeListWriter7 = composerChangeListWriter4;
            ChangeList changeList9 = changeList5;
            this.changeListWriter.endMovableContentPlacement();
            this.changeListWriter.moveReaderToAbsolute(0);
            composerChangeListWriter7.setChangeList(changeList9);
        } catch (Throwable th13) {
            th = th13;
            composerChangeListWriter = composerChangeListWriter4;
            changeList = changeList5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r insertMovableContentGuarded$lambda$41$lambda$40$lambda$34$lambda$33(ComposerImpl composerImpl, ChangeList changeList, SlotReader slotReader, MovableContentStateReference movableContentStateReference) {
        ComposerChangeListWriter composerChangeListWriter = composerImpl.changeListWriter;
        ChangeList changeList2 = composerChangeListWriter.getChangeList();
        try {
            composerChangeListWriter.setChangeList(changeList);
            SlotReader slotReader2 = composerImpl.reader;
            int[] iArr = composerImpl.nodeCountOverrides;
            MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap = composerImpl.providerUpdates;
            composerImpl.nodeCountOverrides = null;
            composerImpl.providerUpdates = null;
            try {
                composerImpl.reader = slotReader;
                ComposerChangeListWriter composerChangeListWriter2 = composerImpl.changeListWriter;
                boolean implicitRootStart = composerChangeListWriter2.getImplicitRootStart();
                try {
                    composerChangeListWriter2.setImplicitRootStart(false);
                    composerImpl.invokeMovableContentLambda(movableContentStateReference.getContent$runtime(), movableContentStateReference.getLocals(), movableContentStateReference.getParameter(), true);
                    composerChangeListWriter.setChangeList(changeList2);
                    return r.f317a;
                } finally {
                    composerChangeListWriter2.setImplicitRootStart(implicitRootStart);
                }
            } finally {
                composerImpl.reader = slotReader2;
                composerImpl.nodeCountOverrides = iArr;
                composerImpl.providerUpdates = mutableIntObjectMap;
            }
        } catch (Throwable th) {
            composerChangeListWriter.setChangeList(changeList2);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r insertMovableContentGuarded$lambda$41$lambda$40$lambda$39$lambda$38$lambda$37$lambda$36$lambda$35(ComposerImpl composerImpl, MovableContentStateReference movableContentStateReference) {
        composerImpl.invokeMovableContentLambda(movableContentStateReference.getContent$runtime(), movableContentStateReference.getLocals(), movableContentStateReference.getParameter(), true);
        return r.f317a;
    }

    private final int insertedGroupVirtualIndex(int index) {
        return (-2) - index;
    }

    private final void invokeMovableContentLambda(final MovableContent<Object> content, PersistentCompositionLocalMap locals, final Object parameter, boolean force) {
        startMovableGroup(MovableContentKt.movableContentKey, content);
        updateSlot(parameter);
        long compositeKeyHashCode = getCompositeKeyHashCode();
        try {
            this.compositeKeyHashCode = MovableContentKt.movableContentKey;
            boolean z10 = false;
            if (getInserting()) {
                SlotWriter.markGroup$default(this.writer, 0, 1, null);
            }
            if (!getInserting() && !kotlin.jvm.internal.k.b(this.reader.getGroupAux(), locals)) {
                z10 = true;
            }
            if (z10) {
                recordProviderUpdate(locals);
            }
            m3414startBaiHCIY(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.INSTANCE.m3428getGroupULZAiWs(), locals);
            this.providerCache = null;
            if (!getInserting() || force) {
                boolean z11 = this.providersInvalid;
                this.providersInvalid = z10;
                Expect_jvmKt.invokeComposable(this, ComposableLambdaKt.composableLambdaInstance(316014703, true, new n() { // from class: androidx.compose.runtime.ComposerImpl.invokeMovableContentLambda.1
                    @Override // S7.n
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return r.f317a;
                    }

                    @Composable
                    public final void invoke(Composer composer, int i) {
                        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(316014703, i, -1, "androidx.compose.runtime.ComposerImpl.invokeMovableContentLambda.<anonymous> (Composer.kt:3477)");
                        }
                        content.getContent().invoke(parameter, composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                this.providersInvalid = z11;
            } else {
                this.writerHasAProvider = true;
                SlotWriter slotWriter = this.writer;
                this.parentContext.insertMovableContent$runtime(new MovableContentStateReference(content, parameter, getComposition(), this.insertTable, slotWriter.anchor(slotWriter.parent(slotWriter.getParent())), EmptyList.f4893a, currentCompositionLocalScope(), null));
            }
        } catch (Throwable th) {
            try {
                throw ComposeStackTraceKt.attachComposeStackTrace(th, new b(this, 0));
            } finally {
                endGroup();
                this.providerCache = null;
                this.compositeKeyHashCode = compositeKeyHashCode;
                endMovableGroup();
            }
        }
    }

    private final Object nodeAt(SlotReader slotReader, int i) {
        return slotReader.node(i);
    }

    private final int nodeIndexOf(int groupLocation, int group, int recomposeGroup, int recomposeIndex) {
        int iParent = this.reader.parent(group);
        while (iParent != recomposeGroup && !this.reader.isNode(iParent)) {
            iParent = this.reader.parent(iParent);
        }
        if (this.reader.isNode(iParent)) {
            recomposeIndex = 0;
        }
        if (iParent == group) {
            return recomposeIndex;
        }
        int iUpdatedNodeCount = (updatedNodeCount(iParent) - this.reader.nodeCount(group)) + recomposeIndex;
        loop1: while (recomposeIndex < iUpdatedNodeCount && iParent != groupLocation) {
            iParent++;
            while (iParent < groupLocation) {
                int iGroupSize = this.reader.groupSize(iParent) + iParent;
                if (groupLocation >= iGroupSize) {
                    recomposeIndex += this.reader.isNode(iParent) ? 1 : updatedNodeCount(iParent);
                    iParent = iGroupSize;
                }
            }
            break loop1;
        }
        return recomposeIndex;
    }

    private final int rGroupIndexOf(int group) {
        int iParent = this.reader.parent(group) + 1;
        int i = 0;
        while (iParent < group) {
            if (!this.reader.hasObjectKey(iParent)) {
                i++;
            }
            iParent += this.reader.groupSize(iParent);
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: all -> 0x0025, TRY_LEAVE, TryCatch #0 {all -> 0x0025, blocks: (B:3:0x0005, B:5:0x0013, B:7:0x0021, B:11:0x002b, B:10:0x0027, B:14:0x0032, B:16:0x0038, B:18:0x003e), top: B:23:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final <R> R recomposeMovableContent(androidx.compose.runtime.ControlledComposition r7, androidx.compose.runtime.ControlledComposition r8, java.lang.Integer r9, java.util.List<? extends kotlin.Pair<androidx.compose.runtime.RecomposeScopeImpl, ? extends java.lang.Object>> r10, S7.a r11) {
        /*
            r6 = this;
            boolean r0 = r6.isComposing
            int r1 = r6.nodeIndex
            r2 = 1
            r6.isComposing = r2     // Catch: java.lang.Throwable -> L25
            r2 = 0
            r6.nodeIndex = r2     // Catch: java.lang.Throwable -> L25
            r3 = r10
            java.util.Collection r3 = (java.util.Collection) r3     // Catch: java.lang.Throwable -> L25
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L25
        L11:
            if (r2 >= r3) goto L2e
            java.lang.Object r4 = r10.get(r2)     // Catch: java.lang.Throwable -> L25
            kotlin.Pair r4 = (kotlin.Pair) r4     // Catch: java.lang.Throwable -> L25
            java.lang.Object r5 = r4.f4886a     // Catch: java.lang.Throwable -> L25
            androidx.compose.runtime.RecomposeScopeImpl r5 = (androidx.compose.runtime.RecomposeScopeImpl) r5     // Catch: java.lang.Throwable -> L25
            java.lang.Object r4 = r4.b     // Catch: java.lang.Throwable -> L25
            if (r4 == 0) goto L27
            r6.tryImminentInvalidation$runtime(r5, r4)     // Catch: java.lang.Throwable -> L25
            goto L2b
        L25:
            r7 = move-exception
            goto L47
        L27:
            r4 = 0
            r6.tryImminentInvalidation$runtime(r5, r4)     // Catch: java.lang.Throwable -> L25
        L2b:
            int r2 = r2 + 1
            goto L11
        L2e:
            if (r7 == 0) goto L3e
            if (r9 == 0) goto L37
            int r9 = r9.intValue()     // Catch: java.lang.Throwable -> L25
            goto L38
        L37:
            r9 = -1
        L38:
            java.lang.Object r7 = r7.delegateInvalidations(r8, r9, r11)     // Catch: java.lang.Throwable -> L25
            if (r7 != 0) goto L42
        L3e:
            java.lang.Object r7 = r11.invoke()     // Catch: java.lang.Throwable -> L25
        L42:
            r6.isComposing = r0
            r6.nodeIndex = r1
            return r7
        L47:
            r6.isComposing = r0
            r6.nodeIndex = r1
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.recomposeMovableContent(androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.ControlledComposition, java.lang.Integer, java.util.List, S7.a):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object recomposeMovableContent$default(ComposerImpl composerImpl, ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List list, S7.a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            controlledComposition = null;
        }
        if ((i & 2) != 0) {
            controlledComposition2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            list = EmptyList.f4893a;
        }
        return composerImpl.recomposeMovableContent(controlledComposition, controlledComposition2, num, list, aVar);
    }

    private final void recomposeToGroupEnd() {
        boolean z10 = this.isComposing;
        this.isComposing = true;
        int parent = this.reader.getParent();
        int iGroupSize = this.reader.groupSize(parent) + parent;
        int i = this.nodeIndex;
        long compositeKeyHashCode = getCompositeKeyHashCode();
        int i6 = this.groupNodeCount;
        int i10 = this.rGroupIndex;
        Invalidation invalidationFirstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), iGroupSize);
        boolean z11 = false;
        int i11 = parent;
        while (invalidationFirstInRange != null) {
            int location = invalidationFirstInRange.getLocation();
            RecomposeScopeImpl scope = invalidationFirstInRange.getScope();
            ComposerKt.removeLocation(this.invalidations, location);
            if (invalidationFirstInRange.isInvalid()) {
                this.reader.reposition(location);
                int currentGroup = this.reader.getCurrentGroup();
                recordUpsAndDowns(i11, currentGroup, parent);
                this.nodeIndex = nodeIndexOf(location, currentGroup, parent, i);
                this.rGroupIndex = rGroupIndexOf(currentGroup);
                this.compositeKeyHashCode = compositeKeyOf(this.reader.parent(currentGroup), parent, compositeKeyHashCode);
                this.providerCache = null;
                scope.compose(this);
                this.providerCache = null;
                this.reader.restoreParent(parent);
                z11 = true;
                i11 = currentGroup;
            } else {
                Stack.m3469pushimpl(this.invalidateStack, scope);
                CompositionObserver compositionObserverCurrent = this.observerHolder.current();
                if (compositionObserverCurrent != null) {
                    try {
                        compositionObserverCurrent.onScopeEnter(scope);
                        scope.rereadTrackedInstances();
                    } finally {
                        compositionObserverCurrent.onScopeExit(scope);
                    }
                } else {
                    scope.rereadTrackedInstances();
                }
                Stack.m3468popimpl(this.invalidateStack);
            }
            invalidationFirstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), iGroupSize);
        }
        if (z11) {
            recordUpsAndDowns(i11, parent, parent);
            this.reader.skipToGroupEnd();
            int iUpdatedNodeCount = updatedNodeCount(parent);
            this.nodeIndex = i + iUpdatedNodeCount;
            this.groupNodeCount = i6 + iUpdatedNodeCount;
            this.rGroupIndex = i10;
        } else {
            skipReaderToGroupEnd();
        }
        this.compositeKeyHashCode = compositeKeyHashCode;
        this.isComposing = z10;
    }

    private final void recordDelete() {
        reportFreeMovableContent(this.reader.getCurrentGroup());
        this.changeListWriter.removeCurrentGroup();
    }

    private final void recordInsert(Anchor anchor) {
        if (this.insertFixups.isEmpty()) {
            this.changeListWriter.insertSlots(anchor, this.insertTable);
        } else {
            this.changeListWriter.insertSlots(anchor, this.insertTable, this.insertFixups);
            this.insertFixups = new FixupList();
        }
    }

    private final void recordProviderUpdate(PersistentCompositionLocalMap providers) {
        MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap = this.providerUpdates;
        if (mutableIntObjectMap == null) {
            mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
            this.providerUpdates = mutableIntObjectMap;
        }
        mutableIntObjectMap.set(this.reader.getCurrentGroup(), providers);
    }

    private final void recordUpsAndDowns(int oldGroup, int newGroup, int commonRoot) {
        SlotReader slotReader = this.reader;
        int iNearestCommonRootOf = ComposerKt.nearestCommonRootOf(slotReader, oldGroup, newGroup, commonRoot);
        while (oldGroup > 0 && oldGroup != iNearestCommonRootOf) {
            if (slotReader.isNode(oldGroup)) {
                this.changeListWriter.moveUp();
            }
            oldGroup = slotReader.parent(oldGroup);
        }
        doRecordDownsFor(newGroup, iNearestCommonRootOf);
    }

    private final Anchor rememberObserverAnchor() {
        int i;
        int i6;
        if (getInserting()) {
            if (!ComposerKt.isAfterFirstChild(this.writer)) {
                return null;
            }
            int currentGroup = this.writer.getCurrentGroup() - 1;
            int iParent = this.writer.parent(currentGroup);
            while (true) {
                int i10 = iParent;
                i6 = currentGroup;
                currentGroup = i10;
                if (currentGroup == this.writer.getParent() || currentGroup < 0) {
                    break;
                }
                iParent = this.writer.parent(currentGroup);
            }
            return this.writer.anchor(i6);
        }
        if (!ComposerKt.isAfterFirstChild(this.reader)) {
            return null;
        }
        int currentGroup2 = this.reader.getCurrentGroup() - 1;
        int iParent2 = this.reader.parent(currentGroup2);
        while (true) {
            int i11 = iParent2;
            i = currentGroup2;
            currentGroup2 = i11;
            if (currentGroup2 == this.reader.getParent() || currentGroup2 < 0) {
                break;
            }
            iParent2 = this.reader.parent(currentGroup2);
        }
        return this.reader.anchor(i);
    }

    private final void reportAllMovableContent() {
        if (this.slotTable.containsMark()) {
            getComposition().updateMovingInvalidations$runtime();
            ChangeList changeList = new ChangeList();
            this.deferredChanges = changeList;
            SlotReader slotReaderOpenReader = this.slotTable.openReader();
            try {
                this.reader = slotReaderOpenReader;
                ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
                ChangeList changeList2 = composerChangeListWriter.getChangeList();
                try {
                    composerChangeListWriter.setChangeList(changeList);
                    reportFreeMovableContent(0);
                    this.changeListWriter.releaseMovableContent();
                } finally {
                    composerChangeListWriter.setChangeList(changeList2);
                }
            } finally {
                slotReaderOpenReader.close();
            }
        }
    }

    private final void reportFreeMovableContent(int groupBeingRemoved) {
        boolean zIsNode = this.reader.isNode(groupBeingRemoved);
        if (zIsNode) {
            this.changeListWriter.endNodeMovement();
            this.changeListWriter.moveDown(this.reader.node(groupBeingRemoved));
        }
        reportFreeMovableContent$reportGroup(this, groupBeingRemoved, groupBeingRemoved, zIsNode, 0);
        this.changeListWriter.endNodeMovement();
        if (zIsNode) {
            this.changeListWriter.moveUp();
        }
    }

    private static final MovableContentStateReference reportFreeMovableContent$createMovableContentReferenceForGroup(ComposerImpl composerImpl, int i, List<MovableContentStateReference> list) {
        Object objGroupObjectKey = composerImpl.reader.groupObjectKey(i);
        kotlin.jvm.internal.k.d(objGroupObjectKey, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        MovableContent movableContent = (MovableContent) objGroupObjectKey;
        Object objGroupGet = composerImpl.reader.groupGet(i, 0);
        Anchor anchor = composerImpl.reader.anchor(i);
        int iGroupSize = composerImpl.reader.groupSize(i) + i;
        ArrayList arrayList = new ArrayList();
        List<Invalidation> list2 = composerImpl.invalidations;
        for (int iFindInsertLocation = ComposerKt.findInsertLocation(list2, i); iFindInsertLocation < list2.size(); iFindInsertLocation++) {
            Invalidation invalidation = list2.get(iFindInsertLocation);
            if (invalidation.getLocation() >= iGroupSize) {
                break;
            }
            arrayList.add(new Pair(invalidation.getScope(), invalidation.getInstances()));
        }
        return new MovableContentStateReference(movableContent, objGroupGet, composerImpl.getComposition(), composerImpl.slotTable, anchor, arrayList, composerImpl.currentCompositionLocalScope(i), list);
    }

    private static final MovableContentStateReference reportFreeMovableContent$movableContentReferenceFor(ComposerImpl composerImpl, int i) {
        int iGroupKey = composerImpl.reader.groupKey(i);
        Object objGroupObjectKey = composerImpl.reader.groupObjectKey(i);
        ArrayList arrayList = null;
        if (iGroupKey != 126665345 || !(objGroupObjectKey instanceof MovableContent)) {
            return null;
        }
        if (composerImpl.reader.containsMark(i)) {
            ArrayList arrayList2 = new ArrayList();
            reportFreeMovableContent$movableContentReferenceFor$traverseGroups(composerImpl, arrayList2, i);
            if (!arrayList2.isEmpty()) {
                arrayList = arrayList2;
            }
        }
        return reportFreeMovableContent$createMovableContentReferenceForGroup(composerImpl, i, arrayList);
    }

    private static final void reportFreeMovableContent$movableContentReferenceFor$traverseGroups(ComposerImpl composerImpl, List<MovableContentStateReference> list, int i) {
        int iGroupSize = composerImpl.reader.groupSize(i) + i;
        int iGroupSize2 = i + 1;
        while (iGroupSize2 < iGroupSize) {
            if (composerImpl.reader.hasMark(iGroupSize2)) {
                MovableContentStateReference movableContentStateReferenceReportFreeMovableContent$movableContentReferenceFor = reportFreeMovableContent$movableContentReferenceFor(composerImpl, iGroupSize2);
                if (movableContentStateReferenceReportFreeMovableContent$movableContentReferenceFor != null) {
                    list.add(movableContentStateReferenceReportFreeMovableContent$movableContentReferenceFor);
                }
            } else if (composerImpl.reader.containsMark(iGroupSize2)) {
                reportFreeMovableContent$movableContentReferenceFor$traverseGroups(composerImpl, list, iGroupSize2);
            }
            iGroupSize2 += composerImpl.reader.groupSize(iGroupSize2);
        }
    }

    private static final int reportFreeMovableContent$reportGroup(ComposerImpl composerImpl, int i, int i6, boolean z10, int i10) {
        SlotReader slotReader = composerImpl.reader;
        if (!slotReader.hasMark(i6)) {
            if (!slotReader.containsMark(i6)) {
                if (slotReader.isNode(i6)) {
                    return 1;
                }
                return slotReader.nodeCount(i6);
            }
            int iGroupSize = slotReader.groupSize(i6) + i6;
            int iReportFreeMovableContent$reportGroup = 0;
            for (int iGroupSize2 = i6 + 1; iGroupSize2 < iGroupSize; iGroupSize2 += slotReader.groupSize(iGroupSize2)) {
                boolean zIsNode = slotReader.isNode(iGroupSize2);
                if (zIsNode) {
                    composerImpl.changeListWriter.endNodeMovement();
                    composerImpl.changeListWriter.moveDown(slotReader.node(iGroupSize2));
                }
                iReportFreeMovableContent$reportGroup += reportFreeMovableContent$reportGroup(composerImpl, i, iGroupSize2, zIsNode || z10, zIsNode ? 0 : i10 + iReportFreeMovableContent$reportGroup);
                if (zIsNode) {
                    composerImpl.changeListWriter.endNodeMovement();
                    composerImpl.changeListWriter.moveUp();
                }
            }
            if (slotReader.isNode(i6)) {
                return 1;
            }
            return iReportFreeMovableContent$reportGroup;
        }
        int iGroupKey = slotReader.groupKey(i6);
        Object objGroupObjectKey = slotReader.groupObjectKey(i6);
        if (iGroupKey == 126665345 && (objGroupObjectKey instanceof MovableContent)) {
            MovableContentStateReference movableContentStateReferenceReportFreeMovableContent$movableContentReferenceFor = reportFreeMovableContent$movableContentReferenceFor(composerImpl, i6);
            if (movableContentStateReferenceReportFreeMovableContent$movableContentReferenceFor != null) {
                composerImpl.parentContext.deletedMovableContent$runtime(movableContentStateReferenceReportFreeMovableContent$movableContentReferenceFor);
                composerImpl.changeListWriter.recordSlotEditing();
                composerImpl.changeListWriter.releaseMovableGroupAtCurrent(composerImpl.getComposition(), composerImpl.parentContext, movableContentStateReferenceReportFreeMovableContent$movableContentReferenceFor);
            }
            if (!z10 || i6 == i) {
                return slotReader.nodeCount(i6);
            }
            composerImpl.changeListWriter.endNodeMovementAndDeleteNode(i10, i6);
            return 0;
        }
        if (iGroupKey != 206 || !kotlin.jvm.internal.k.b(objGroupObjectKey, ComposerKt.getReference())) {
            if (slotReader.isNode(i6)) {
                return 1;
            }
            return slotReader.nodeCount(i6);
        }
        Object objGroupGet = slotReader.groupGet(i6, 0);
        CompositionContextHolder compositionContextHolder = objGroupGet instanceof CompositionContextHolder ? (CompositionContextHolder) objGroupGet : null;
        if (compositionContextHolder != null) {
            for (ComposerImpl composerImpl2 : compositionContextHolder.getRef().getComposers()) {
                composerImpl2.reportAllMovableContent();
                composerImpl.parentContext.reportRemovedComposition$runtime(composerImpl2.getComposition());
            }
        }
        return slotReader.nodeCount(i6);
    }

    private final void skipGroup() {
        this.groupNodeCount = this.reader.skipGroup() + this.groupNodeCount;
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodes();
        this.reader.skipToGroupEnd();
    }

    private final List<ComposeStackTraceFrame> stackTraceForGroup(int group, Integer dataOffset) {
        if (!this.sourceMarkersEnabled) {
            return EmptyList.f4893a;
        }
        SlotReader slotReaderOpenReader = this.slotTable.openReader();
        try {
            return ComposeStackTraceBuilderKt.traceForGroup(slotReaderOpenReader, group, dataOffset);
        } finally {
            slotReaderOpenReader.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean stackTraceForValue$lambda$43(Object obj, Object obj2) {
        if (obj2 == obj) {
            return true;
        }
        RememberObserverHolder rememberObserverHolder = obj2 instanceof RememberObserverHolder ? (RememberObserverHolder) obj2 : null;
        return (rememberObserverHolder != null ? rememberObserverHolder.getWrapped() : null) == obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00de  */
    /* renamed from: start-BaiHCIY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m3414startBaiHCIY(int r11, java.lang.Object r12, int r13, java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.m3414startBaiHCIY(int, java.lang.Object, int, java.lang.Object):void");
    }

    private final void startGroup(int key) {
        m3414startBaiHCIY(key, null, GroupKind.INSTANCE.m3428getGroupULZAiWs(), null);
    }

    private final void startReaderGroup(boolean isNode, Object data) {
        if (isNode) {
            this.reader.startNode();
            return;
        }
        if (data != null && this.reader.getGroupAux() != data) {
            this.changeListWriter.updateAuxData(data);
        }
        this.reader.startGroup();
    }

    private final void startRoot() {
        this.rGroupIndex = 0;
        this.reader = this.slotTable.openReader();
        startGroup(100);
        this.parentContext.startComposing$runtime();
        PersistentCompositionLocalMap compositionLocalScope$runtime = this.parentContext.getCompositionLocalScope$runtime();
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = changed(compositionLocalScope$runtime);
        this.providerCache = null;
        if (!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = this.parentContext.getCollectingParameterInformation();
        }
        if (!this.sourceMarkersEnabled) {
            this.sourceMarkersEnabled = this.parentContext.getCollectingSourceInformation();
        }
        if (this.sourceMarkersEnabled) {
            CompositionLocal<CompositionErrorContext> localCompositionErrorContext = CompositionErrorContextKt.getLocalCompositionErrorContext();
            kotlin.jvm.internal.k.d(localCompositionErrorContext, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
            compositionLocalScope$runtime = compositionLocalScope$runtime.putValue(localCompositionErrorContext, new StaticValueHolder(getErrorContext$runtime()));
        }
        this.rootProvider = compositionLocalScope$runtime;
        Set<CompositionData> set = (Set) CompositionLocalMapKt.read(compositionLocalScope$runtime, InspectionTablesKt.getLocalInspectionTables());
        if (set != null) {
            set.add(getCompositionData());
            this.parentContext.recordInspectionTable$runtime(set);
        }
        startGroup(Long.hashCode(this.parentContext.getCompositeKeyHashCode()));
    }

    private final void updateCompositeKeyWhenWeEnterGroup(int groupKey, int rGroupIndex, Object dataKey, Object data) {
        if (dataKey != null) {
            if (dataKey instanceof Enum) {
                this.compositeKeyHashCode = 0 ^ Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ ((Enum) dataKey).ordinal(), 3);
                return;
            } else {
                this.compositeKeyHashCode = 0 ^ Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ dataKey.hashCode(), 3);
                return;
            }
        }
        if (data == null || groupKey != 207 || data.equals(Composer.INSTANCE.getEmpty())) {
            this.compositeKeyHashCode = rGroupIndex ^ Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ groupKey, 3);
        } else {
            this.compositeKeyHashCode = rGroupIndex ^ Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ data.hashCode(), 3);
        }
    }

    private final void updateCompositeKeyWhenWeEnterGroupKeyHash(int groupKey, int rGroupIndex) {
        this.compositeKeyHashCode = rGroupIndex ^ Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ groupKey, 3);
    }

    private final void updateCompositeKeyWhenWeExitGroup(int groupKey, int rGroupIndex, Object dataKey, Object data) {
        if (dataKey != null) {
            if (dataKey instanceof Enum) {
                this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode() ^ 0, 3) ^ ((Enum) dataKey).ordinal(), 3);
                return;
            } else {
                this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode() ^ 0, 3) ^ dataKey.hashCode(), 3);
                return;
            }
        }
        if (data == null || groupKey != 207 || data.equals(Composer.INSTANCE.getEmpty())) {
            this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode() ^ rGroupIndex, 3) ^ groupKey, 3);
        } else {
            this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode() ^ rGroupIndex, 3) ^ data.hashCode(), 3);
        }
    }

    private final void updateCompositeKeyWhenWeExitGroupKeyHash(int groupKey, int rGroupIndex) {
        this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode() ^ rGroupIndex, 3) ^ groupKey, 3);
    }

    private final void updateNodeCount(int group, int count) {
        if (updatedNodeCount(group) != count) {
            int i = 0;
            if (group < 0) {
                MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
                if (mutableIntIntMap == null) {
                    mutableIntIntMap = new MutableIntIntMap(i, 1, null);
                    this.nodeCountVirtualOverrides = mutableIntIntMap;
                }
                mutableIntIntMap.set(group, count);
                return;
            }
            int[] iArr = this.nodeCountOverrides;
            if (iArr == null) {
                iArr = new int[this.reader.getGroupsSize()];
                q.g0(iArr, -1, 0, 6);
                this.nodeCountOverrides = iArr;
            }
            iArr[group] = count;
        }
    }

    private final void updateNodeCountOverrides(int group, int newCount) {
        int iUpdatedNodeCount = updatedNodeCount(group);
        if (iUpdatedNodeCount != newCount) {
            int i = newCount - iUpdatedNodeCount;
            int iM3462getSizeimpl = Stack.m3462getSizeimpl(this.pendingStack) - 1;
            while (group != -1) {
                int iUpdatedNodeCount2 = updatedNodeCount(group) + i;
                updateNodeCount(group, iUpdatedNodeCount2);
                int i6 = iM3462getSizeimpl;
                while (true) {
                    if (-1 < i6) {
                        Pending pending = (Pending) Stack.m3467peekimpl(this.pendingStack, i6);
                        if (pending != null && pending.updateNodeCount(group, iUpdatedNodeCount2)) {
                            iM3462getSizeimpl = i6 - 1;
                            break;
                        }
                        i6--;
                    } else {
                        break;
                    }
                }
                if (group < 0) {
                    group = this.reader.getParent();
                } else if (this.reader.isNode(group)) {
                    return;
                } else {
                    group = this.reader.parent(group);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.compose.runtime.PersistentCompositionLocalMap, java.lang.Object] */
    private final PersistentCompositionLocalMap updateProviderMapGroup(PersistentCompositionLocalMap parentScope, PersistentCompositionLocalMap currentProviders) {
        PersistentMap.Builder<CompositionLocal<Object>, ValueHolder<Object>> builder = parentScope.builder2();
        builder.putAll(currentProviders);
        ?? Build = builder.build2();
        startGroup(ComposerKt.providerMapsKey, ComposerKt.getProviderMaps());
        updateSlot(Build);
        updateSlot(currentProviders);
        endGroup();
        return Build;
    }

    private final void updateSlot(Object value) {
        nextSlot();
        updateValue(value);
    }

    private final int updatedNodeCount(int group) {
        int i;
        if (group >= 0) {
            int[] iArr = this.nodeCountOverrides;
            return (iArr == null || (i = iArr[group]) < 0) ? this.reader.nodeCount(group) : i;
        }
        MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
        if (mutableIntIntMap == null || !mutableIntIntMap.containsKey(group)) {
            return 0;
        }
        return mutableIntIntMap.get(group);
    }

    private final void validateNodeExpected() {
        if (!this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.nodeExpected = false;
    }

    private final void validateNodeNotExpected() {
        if (this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected");
        }
    }

    private final <R> R withReader(SlotReader reader, S7.a block) {
        SlotReader slotReader = this.reader;
        int[] iArr = this.nodeCountOverrides;
        MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap = this.providerUpdates;
        this.nodeCountOverrides = null;
        this.providerUpdates = null;
        try {
            this.reader = reader;
            return (R) block.invoke();
        } finally {
            this.reader = slotReader;
            this.nodeCountOverrides = iArr;
            this.providerUpdates = mutableIntObjectMap;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public <V, T> void apply(V value, n block) {
        if (getInserting()) {
            this.insertFixups.updateNode(value, block);
        } else {
            this.changeListWriter.updateNode(value, block);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionContext buildContext() {
        ComposerImpl composerImpl;
        startGroup(ComposerKt.referenceKey, ComposerKt.getReference());
        if (getInserting()) {
            SlotWriter.markGroup$default(this.writer, 0, 1, null);
        }
        Object objNextSlot = nextSlot();
        CompositionContextHolder compositionContextHolder = objNextSlot instanceof CompositionContextHolder ? (CompositionContextHolder) objNextSlot : null;
        if (compositionContextHolder == null) {
            long compositeKeyHashCode = getCompositeKeyHashCode();
            boolean z10 = this.forceRecomposeScopes;
            boolean z11 = this.sourceMarkersEnabled;
            CompositionImpl composition = getComposition();
            if (composition == null) {
                composition = null;
            }
            CompositionObserverHolder observerHolder$runtime = composition != null ? composition.getObserverHolder() : null;
            composerImpl = this;
            compositionContextHolder = new CompositionContextHolder(composerImpl.new CompositionContextImpl(compositeKeyHashCode, z10, z11, observerHolder$runtime));
            composerImpl.updateValue(compositionContextHolder);
        } else {
            composerImpl = this;
        }
        compositionContextHolder.getRef().updateCompositionLocalScope(composerImpl.currentCompositionLocalScope());
        composerImpl.endGroup();
        return compositionContextHolder.getRef();
    }

    @ComposeCompilerApi
    public final <T> T cache(boolean invalid, S7.a block) {
        T t9 = (T) nextSlotForCache();
        if (t9 != Composer.INSTANCE.getEmpty() && !invalid) {
            return t9;
        }
        T t10 = (T) block.invoke();
        updateCachedValue(t10);
        return t10;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(Object value) {
        if (kotlin.jvm.internal.k.b(nextSlot(), value)) {
            return false;
        }
        updateValue(value);
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changedInstance(Object value) {
        if (nextSlot() == value) {
            return false;
        }
        updateValue(value);
        return true;
    }

    public final void changesApplied$runtime() {
        this.providerUpdates = null;
    }

    @Override // androidx.compose.runtime.Composer
    public void collectParameterInformation() {
        this.forceRecomposeScopes = true;
        this.sourceMarkersEnabled = true;
        this.slotTable.collectSourceInformation();
        this.insertTable.collectSourceInformation();
        this.writer.updateToTableMaps();
    }

    /* renamed from: composeContent--ZbOJvo$runtime, reason: not valid java name */
    public final void m3415composeContentZbOJvo$runtime(MutableScatterMap<Object, Object> invalidationsRequested, n content, ShouldPauseCallback shouldPause) {
        if (!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }
        this.shouldPauseCallback = shouldPause;
        try {
            m3413doComposeaFTiNEg(invalidationsRequested, content);
        } finally {
            this.shouldPauseCallback = null;
        }
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public <T> T consume(CompositionLocal<T> key) {
        return (T) CompositionLocalMapKt.read(currentCompositionLocalScope(), key);
    }

    @Override // androidx.compose.runtime.Composer
    public <T> void createNode(S7.a factory) {
        validateNodeExpected();
        if (!getInserting()) {
            ComposerKt.composeImmediateRuntimeError("createNode() can only be called when inserting");
        }
        int iPeek = this.parentStateStack.peek();
        SlotWriter slotWriter = this.writer;
        Anchor anchor = slotWriter.anchor(slotWriter.getParent());
        this.groupNodeCount++;
        this.insertFixups.createAndInsertNode(factory, iPeek, anchor);
    }

    public final void deactivate$runtime() {
        Stack.m3457clearimpl(this.invalidateStack);
        this.invalidations.clear();
        this.changes.clear();
        this.providerUpdates = null;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void deactivateToEndGroup(boolean changed) {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling dactivateToEndGroup");
        }
        if (getInserting()) {
            return;
        }
        if (!changed) {
            skipReaderToGroupEnd();
            return;
        }
        int currentGroup = this.reader.getCurrentGroup();
        int currentEnd = this.reader.getCurrentEnd();
        this.changeListWriter.deactivateCurrentGroup();
        ComposerKt.removeRange(this.invalidations, currentGroup, currentEnd);
        this.reader.skipToGroupEnd();
    }

    @Override // androidx.compose.runtime.Composer
    public void disableReusing() {
        this.reusing = false;
    }

    @Override // androidx.compose.runtime.Composer
    public void disableSourceInformation() {
        this.sourceMarkersEnabled = false;
    }

    public final void dispose$runtime() {
        Trace trace = Trace.INSTANCE;
        Object objBeginSection = trace.beginSection("Compose:Composer.dispose");
        try {
            this.parentContext.unregisterComposer$runtime(this);
            deactivate$runtime();
            getApplier().clear();
            this.isDisposed = true;
            trace.endSection(objBeginSection);
        } catch (Throwable th) {
            Trace.INSTANCE.endSection(objBeginSection);
            throw th;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void enableReusing() {
        this.reusing = this.reusingGroup >= 0;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endDefaults() {
        endGroup();
        RecomposeScopeImpl currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime();
        if (currentRecomposeScope$runtime == null || !currentRecomposeScope$runtime.getUsed()) {
            return;
        }
        currentRecomposeScope$runtime.setDefaultsInScope(true);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endMovableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public void endNode() {
        end(true);
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void endProvider() {
        endGroup();
        endGroup();
        this.providersInvalid = ComposerKt.asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void endProviders() {
        endGroup();
        endGroup();
        this.providersInvalid = ComposerKt.asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endReplaceGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endReplaceableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public ScopeUpdateScope endRestartGroup() {
        Anchor anchor;
        RecomposeScopeImpl recomposeScopeImpl = null;
        RecomposeScopeImpl recomposeScopeImpl2 = Stack.m3465isNotEmptyimpl(this.invalidateStack) ? (RecomposeScopeImpl) Stack.m3468popimpl(this.invalidateStack) : null;
        if (recomposeScopeImpl2 != null) {
            recomposeScopeImpl2.setRequiresRecompose(false);
            S7.k kVarExitRecomposeScope = exitRecomposeScope(recomposeScopeImpl2);
            if (kVarExitRecomposeScope != null) {
                this.changeListWriter.endCompositionScope(kVarExitRecomposeScope, getComposition());
            }
            if (recomposeScopeImpl2.getResuming()) {
                recomposeScopeImpl2.setResuming(false);
                this.changeListWriter.endResumingScope(recomposeScopeImpl2);
                recomposeScopeImpl2.setReusing(false);
                if (recomposeScopeImpl2.getResetReusing()) {
                    recomposeScopeImpl2.setResetReusing(false);
                    this.reusing = false;
                }
            }
        }
        if (recomposeScopeImpl2 != null && !recomposeScopeImpl2.getSkipped$runtime() && (recomposeScopeImpl2.getUsed() || this.forceRecomposeScopes)) {
            if (recomposeScopeImpl2.getAnchor() == null) {
                if (getInserting()) {
                    SlotWriter slotWriter = this.writer;
                    anchor = slotWriter.anchor(slotWriter.getParent());
                } else {
                    SlotReader slotReader = this.reader;
                    anchor = slotReader.anchor(slotReader.getParent());
                }
                recomposeScopeImpl2.setAnchor(anchor);
            }
            recomposeScopeImpl2.setDefaultsInvalid(false);
            recomposeScopeImpl = recomposeScopeImpl2;
        }
        end(false);
        return recomposeScopeImpl;
    }

    @Override // androidx.compose.runtime.Composer
    public void endReusableGroup() {
        if (this.reusing && this.reader.getParent() == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }
        end(false);
    }

    public final void endReuseFromRoot() {
        if (!(!this.isComposing && this.reusingGroup == 100)) {
            PreconditionsKt.throwIllegalArgumentException("Cannot disable reuse from root if it was caused by other groups");
        }
        this.reusingGroup = -1;
        this.reusing = false;
    }

    @Override // androidx.compose.runtime.Composer
    public void endToMarker(int marker) {
        if (marker < 0) {
            int i = -marker;
            SlotWriter slotWriter = this.writer;
            while (true) {
                int parent = slotWriter.getParent();
                if (parent <= i) {
                    return;
                } else {
                    end(slotWriter.isNode(parent));
                }
            }
        } else {
            if (getInserting()) {
                SlotWriter slotWriter2 = this.writer;
                while (getInserting()) {
                    end(slotWriter2.isNode(slotWriter2.getParent()));
                }
            }
            SlotReader slotReader = this.reader;
            while (true) {
                int parent2 = slotReader.getParent();
                if (parent2 <= marker) {
                    return;
                } else {
                    end(slotReader.isNode(parent2));
                }
            }
        }
    }

    public final boolean forceRecomposeScopes$runtime() {
        if (this.forceRecomposeScopes) {
            return false;
        }
        this.forceRecomposeScopes = true;
        this.forciblyRecompose = true;
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public Applier<?> getApplier() {
        return this.applier;
    }

    @Override // androidx.compose.runtime.Composer
    public H7.h getApplyCoroutineContext() {
        return this.applyCoroutineContext;
    }

    public final boolean getAreChildrenComposing$runtime() {
        return this.childrenComposing > 0;
    }

    public final int getChangeCount$runtime() {
        return this.changes.getSize();
    }

    @Override // androidx.compose.runtime.Composer
    public long getCompositeKeyHashCode() {
        return this.compositeKeyHashCode;
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionData getCompositionData() {
        CompositionData compositionData = this._compositionData;
        if (compositionData != null) {
            return compositionData;
        }
        CompositionDataImpl compositionDataImpl = new CompositionDataImpl(getComposition());
        this._compositionData = compositionDataImpl;
        return compositionDataImpl;
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionLocalMap getCurrentCompositionLocalMap() {
        return currentCompositionLocalScope();
    }

    @Override // androidx.compose.runtime.Composer
    public int getCurrentMarker() {
        return getInserting() ? -this.writer.getParent() : this.reader.getParent();
    }

    public final RecomposeScopeImpl getCurrentRecomposeScope$runtime() {
        ArrayList arrayList = this.invalidateStack;
        if (this.childrenComposing == 0 && Stack.m3465isNotEmptyimpl(arrayList)) {
            return (RecomposeScopeImpl) Stack.m3466peekimpl(arrayList);
        }
        return null;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getDefaultsInvalid() {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        return !getSkipping() || this.providersInvalid || ((currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime()) != null && currentRecomposeScope$runtime.getDefaultsInvalid());
    }

    /* renamed from: getDeferredChanges$runtime, reason: from getter */
    public final ChangeList getDeferredChanges() {
        return this.deferredChanges;
    }

    public final CompositionErrorContextImpl getErrorContext$runtime() {
        if (this.sourceMarkersEnabled) {
            return this.errorContext;
        }
        return null;
    }

    public final boolean getHasInvalidations() {
        return !this.invalidations.isEmpty();
    }

    public final boolean getHasPendingChanges$runtime() {
        return this.changes.isNotEmpty();
    }

    /* renamed from: getInsertTable$runtime, reason: from getter */
    public final SlotTable getInsertTable() {
        return this.insertTable;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getInserting() {
        return this.inserting;
    }

    /* renamed from: getReader$runtime, reason: from getter */
    public final SlotReader getReader() {
        return this.reader;
    }

    @Override // androidx.compose.runtime.Composer
    public RecomposeScope getRecomposeScope() {
        return getCurrentRecomposeScope$runtime();
    }

    @Override // androidx.compose.runtime.Composer
    public Object getRecomposeScopeIdentity() {
        RecomposeScopeImpl currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime();
        if (currentRecomposeScope$runtime != null) {
            return currentRecomposeScope$runtime.getAnchor();
        }
        return null;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getSkipping() {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        return (getInserting() || this.reusing || this.providersInvalid || (currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime()) == null || currentRecomposeScope$runtime.getRequiresRecompose() || this.forciblyRecompose) ? false : true;
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void insertMovableContent(MovableContent<?> value, Object parameter) {
        kotlin.jvm.internal.k.d(value, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        invokeMovableContentLambda(value, currentCompositionLocalScope(), parameter, false);
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void insertMovableContentReferences(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        try {
            insertMovableContentGuarded(references);
            cleanUpCompose();
        } catch (Throwable th) {
            abortRoot();
            throw th;
        }
    }

    /* renamed from: isComposing$runtime, reason: from getter */
    public final boolean getIsComposing() {
        return this.isComposing;
    }

    /* renamed from: isDisposed$runtime, reason: from getter */
    public final boolean getIsDisposed() {
        return this.isDisposed;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public Object joinKey(Object left, Object right) {
        Object key = ComposerKt.getKey(this.reader.getGroupObjectKey(), left, right);
        return key == null ? new JoinedKey(left, right) : key;
    }

    public final Object nextSlot() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.INSTANCE.getEmpty();
        }
        Object next = this.reader.next();
        return (!this.reusing || (next instanceof ReusableRememberObserver)) ? next : Composer.INSTANCE.getEmpty();
    }

    public final Object nextSlotForCache() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.INSTANCE.getEmpty();
        }
        Object next = this.reader.next();
        return (!this.reusing || (next instanceof ReusableRememberObserver)) ? next instanceof RememberObserverHolder ? ((RememberObserverHolder) next).getWrapped() : next : Composer.INSTANCE.getEmpty();
    }

    public final int parentKey$runtime() {
        if (getInserting()) {
            SlotWriter slotWriter = this.writer;
            return slotWriter.groupKey(slotWriter.getParent());
        }
        SlotReader slotReader = this.reader;
        return slotReader.groupKey(slotReader.getParent());
    }

    public final List<ComposeStackTraceFrame> parentStackTrace() {
        Integer numFindSubcompositionContextGroup;
        Composition composition$runtime = this.parentContext.getComposition$runtime();
        CompositionImpl compositionImpl = composition$runtime instanceof CompositionImpl ? (CompositionImpl) composition$runtime : null;
        if (compositionImpl != null && (numFindSubcompositionContextGroup = ComposeStackTraceBuilderKt.findSubcompositionContextGroup(compositionImpl.getSlotTable(), this.parentContext)) != null) {
            SlotReader slotReaderOpenReader = compositionImpl.getSlotTable().openReader();
            try {
                return ComposeStackTraceBuilderKt.traceForGroup(slotReaderOpenReader, numFindSubcompositionContextGroup.intValue(), 0);
            } finally {
                slotReaderOpenReader.close();
            }
        }
        return EmptyList.f4893a;
    }

    public final void prepareCompose$runtime(S7.a block) {
        if (this.isComposing) {
            ComposerKt.composeImmediateRuntimeError("Preparing a composition while composing is not supported");
        }
        this.isComposing = true;
        try {
            block.invoke();
        } finally {
            this.isComposing = false;
        }
    }

    /* renamed from: recompose-aFTiNEg$runtime, reason: not valid java name */
    public final boolean m3416recomposeaFTiNEg$runtime(MutableScatterMap<Object, Object> invalidationsRequested, ShouldPauseCallback shouldPause) {
        if (!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }
        if (ScopeMap.m3579getSizeimpl(invalidationsRequested) <= 0 && this.invalidations.isEmpty() && !this.forciblyRecompose) {
            return false;
        }
        this.shouldPauseCallback = shouldPause;
        try {
            m3413doComposeaFTiNEg(invalidationsRequested, null);
            this.shouldPauseCallback = null;
            return this.changes.isNotEmpty();
        } catch (Throwable th) {
            this.shouldPauseCallback = null;
            throw th;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void recordSideEffect(S7.a effect) {
        this.changeListWriter.sideEffect(effect);
    }

    @Override // androidx.compose.runtime.Composer
    public void recordUsed(RecomposeScope scope) {
        RecomposeScopeImpl recomposeScopeImpl = scope instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) scope : null;
        if (recomposeScopeImpl != null) {
            recomposeScopeImpl.setUsed(true);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public Object rememberedValue() {
        return nextSlotForCache();
    }

    public final void setDeferredChanges$runtime(ChangeList changeList) {
        this.deferredChanges = changeList;
    }

    public final void setInsertTable$runtime(SlotTable slotTable) {
        this.insertTable = slotTable;
    }

    public final void setReader$runtime(SlotReader slotReader) {
        this.reader = slotReader;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean shouldExecute(boolean parametersChanged, int flags) {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        if ((flags & 1) == 0 && (getInserting() || this.reusing)) {
            ShouldPauseCallback shouldPauseCallback = this.shouldPauseCallback;
            if (shouldPauseCallback != null && (currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime()) != null && shouldPauseCallback.shouldPause()) {
                currentRecomposeScope$runtime.setUsed(true);
                currentRecomposeScope$runtime.setReusing(this.reusing);
                currentRecomposeScope$runtime.setPaused(true);
                this.changeListWriter.rememberPausingScope(currentRecomposeScope$runtime);
                this.parentContext.reportPausedScope$runtime(currentRecomposeScope$runtime);
                return false;
            }
        } else if (!parametersChanged && getSkipping()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c9  */
    @Override // androidx.compose.runtime.Composer
    @androidx.compose.runtime.ComposeCompilerApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void skipCurrentGroup() {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.skipCurrentGroup():void");
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void skipToGroupEnd() {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling skipAndEndGroup");
        }
        if (getInserting()) {
            return;
        }
        RecomposeScopeImpl currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime();
        if (currentRecomposeScope$runtime != null) {
            currentRecomposeScope$runtime.scopeSkipped();
        }
        if (this.invalidations.isEmpty()) {
            skipReaderToGroupEnd();
        } else {
            recomposeToGroupEnd();
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformation(String sourceInformation) {
        if (getInserting() && this.sourceMarkersEnabled) {
            this.writer.recordGroupSourceInformation(sourceInformation);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformationMarkerEnd() {
        if (getInserting() && this.sourceMarkersEnabled) {
            this.writer.recordGrouplessCallSourceInformationEnd();
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformationMarkerStart(int key, String sourceInformation) {
        if (getInserting() && this.sourceMarkersEnabled) {
            this.writer.recordGrouplessCallSourceInformationStart(key, sourceInformation);
        }
    }

    public final List<ComposeStackTraceFrame> stackTraceForValue$runtime(Object value) {
        ObjectLocation objectLocationFindLocation;
        if (this.sourceMarkersEnabled && (objectLocationFindLocation = ComposeStackTraceBuilderKt.findLocation(this.slotTable, new g(value, 2))) != null) {
            return v.Q0(parentStackTrace(), stackTraceForGroup(objectLocationFindLocation.getGroup(), objectLocationFindLocation.getDataOffset()));
        }
        return EmptyList.f4893a;
    }

    public final int stacksSize$runtime() {
        return Stack.m3462getSizeimpl(this.pendingStack) + Stack.m3462getSizeimpl(this.invalidateStack) + this.entersStack.tos + this.providersInvalidStack.tos + this.parentStateStack.tos;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startDefaults() {
        m3414startBaiHCIY(ComposerKt.defaultsKey, null, GroupKind.INSTANCE.m3428getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startMovableGroup(int key, Object dataKey) {
        m3414startBaiHCIY(key, dataKey, GroupKind.INSTANCE.m3428getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    public void startNode() {
        m3414startBaiHCIY(125, null, GroupKind.INSTANCE.m3429getNodeULZAiWs(), null);
        this.nodeExpected = true;
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void startProvider(ProvidedValue<?> value) {
        ValueHolder<?> valueHolder;
        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(ComposerKt.providerKey, ComposerKt.getProvider());
        Object objRememberedValue = rememberedValue();
        if (kotlin.jvm.internal.k.b(objRememberedValue, Composer.INSTANCE.getEmpty())) {
            valueHolder = null;
        } else {
            kotlin.jvm.internal.k.d(objRememberedValue, "null cannot be cast to non-null type androidx.compose.runtime.ValueHolder<kotlin.Any?>");
            valueHolder = (ValueHolder) objRememberedValue;
        }
        CompositionLocal<?> compositionLocal = value.getCompositionLocal();
        kotlin.jvm.internal.k.d(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        ValueHolder<?> valueHolderUpdatedStateOf$runtime = compositionLocal.updatedStateOf$runtime(value, valueHolder);
        boolean zB = kotlin.jvm.internal.k.b(valueHolderUpdatedStateOf$runtime, valueHolder);
        if (!zB) {
            updateRememberedValue(valueHolderUpdatedStateOf$runtime);
        }
        boolean z10 = true;
        boolean z11 = false;
        if (getInserting()) {
            if (value.getCanOverride() || !CompositionLocalMapKt.contains(persistentCompositionLocalMapCurrentCompositionLocalScope, compositionLocal)) {
                persistentCompositionLocalMapCurrentCompositionLocalScope = persistentCompositionLocalMapCurrentCompositionLocalScope.putValue(compositionLocal, valueHolderUpdatedStateOf$runtime);
            }
            this.writerHasAProvider = true;
        } else {
            SlotReader slotReader = this.reader;
            Object objGroupAux = slotReader.groupAux(slotReader.getCurrentGroup());
            kotlin.jvm.internal.k.d(objGroupAux, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) objGroupAux;
            if (!(getSkipping() && zB) && (value.getCanOverride() || !CompositionLocalMapKt.contains(persistentCompositionLocalMapCurrentCompositionLocalScope, compositionLocal))) {
                persistentCompositionLocalMapCurrentCompositionLocalScope = persistentCompositionLocalMapCurrentCompositionLocalScope.putValue(compositionLocal, valueHolderUpdatedStateOf$runtime);
            } else if ((zB && !this.providersInvalid) || !this.providersInvalid) {
                persistentCompositionLocalMapCurrentCompositionLocalScope = persistentCompositionLocalMap;
            }
            if (!this.reusing && persistentCompositionLocalMap == persistentCompositionLocalMapCurrentCompositionLocalScope) {
                z10 = false;
            }
            z11 = z10;
        }
        if (z11 && !getInserting()) {
            recordProviderUpdate(persistentCompositionLocalMapCurrentCompositionLocalScope);
        }
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = z11;
        this.providerCache = persistentCompositionLocalMapCurrentCompositionLocalScope;
        m3414startBaiHCIY(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.INSTANCE.m3428getGroupULZAiWs(), persistentCompositionLocalMapCurrentCompositionLocalScope);
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void startProviders(ProvidedValue<?>[] values) {
        PersistentCompositionLocalMap persistentCompositionLocalMapUpdateProviderMapGroup;
        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(ComposerKt.providerKey, ComposerKt.getProvider());
        boolean z10 = true;
        boolean z11 = false;
        if (getInserting()) {
            persistentCompositionLocalMapUpdateProviderMapGroup = updateProviderMapGroup(persistentCompositionLocalMapCurrentCompositionLocalScope, CompositionLocalMapKt.updateCompositionMap$default(values, persistentCompositionLocalMapCurrentCompositionLocalScope, null, 4, null));
            this.writerHasAProvider = true;
        } else {
            Object objGroupGet = this.reader.groupGet(0);
            kotlin.jvm.internal.k.d(objGroupGet, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) objGroupGet;
            Object objGroupGet2 = this.reader.groupGet(1);
            kotlin.jvm.internal.k.d(objGroupGet2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) objGroupGet2;
            PersistentCompositionLocalMap persistentCompositionLocalMapUpdateCompositionMap = CompositionLocalMapKt.updateCompositionMap(values, persistentCompositionLocalMapCurrentCompositionLocalScope, persistentCompositionLocalMap2);
            if (getSkipping() && !this.reusing && persistentCompositionLocalMap2.equals(persistentCompositionLocalMapUpdateCompositionMap)) {
                skipGroup();
                persistentCompositionLocalMapUpdateProviderMapGroup = persistentCompositionLocalMap;
            } else {
                persistentCompositionLocalMapUpdateProviderMapGroup = updateProviderMapGroup(persistentCompositionLocalMapCurrentCompositionLocalScope, persistentCompositionLocalMapUpdateCompositionMap);
                if (!this.reusing && kotlin.jvm.internal.k.b(persistentCompositionLocalMapUpdateProviderMapGroup, persistentCompositionLocalMap)) {
                    z10 = false;
                }
                z11 = z10;
            }
        }
        if (z11 && !getInserting()) {
            recordProviderUpdate(persistentCompositionLocalMapUpdateProviderMapGroup);
        }
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = z11;
        this.providerCache = persistentCompositionLocalMapUpdateProviderMapGroup;
        m3414startBaiHCIY(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.INSTANCE.m3428getGroupULZAiWs(), persistentCompositionLocalMapUpdateProviderMapGroup);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startReplaceGroup(int key) {
        if (this.pending != null) {
            m3414startBaiHCIY(key, null, GroupKind.INSTANCE.m3428getGroupULZAiWs(), null);
            return;
        }
        validateNodeNotExpected();
        this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ key, 3) ^ this.rGroupIndex;
        this.rGroupIndex++;
        SlotReader slotReader = this.reader;
        if (getInserting()) {
            slotReader.beginEmpty();
            this.writer.startGroup(key, Composer.INSTANCE.getEmpty());
            enterGroup(false, null);
            return;
        }
        if (slotReader.getGroupKey() == key && !slotReader.getHasObjectKey()) {
            slotReader.startGroup();
            enterGroup(false, null);
            return;
        }
        if (!slotReader.isGroupEnd()) {
            int i = this.nodeIndex;
            int currentGroup = slotReader.getCurrentGroup();
            recordDelete();
            this.changeListWriter.removeNode(i, slotReader.skipGroup());
            ComposerKt.removeRange(this.invalidations, currentGroup, slotReader.getCurrentGroup());
        }
        slotReader.beginEmpty();
        this.inserting = true;
        this.providerCache = null;
        ensureWriter();
        SlotWriter slotWriter = this.writer;
        slotWriter.beginInsert();
        int currentGroup2 = slotWriter.getCurrentGroup();
        slotWriter.startGroup(key, Composer.INSTANCE.getEmpty());
        this.insertAnchor = slotWriter.anchor(currentGroup2);
        enterGroup(false, null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startReplaceableGroup(int key) {
        m3414startBaiHCIY(key, null, GroupKind.INSTANCE.m3428getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public Composer startRestartGroup(int key) {
        startReplaceGroup(key);
        addRecomposeScope();
        return this;
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableGroup(int key, Object dataKey) {
        if (!getInserting() && this.reader.getGroupKey() == key && !kotlin.jvm.internal.k.b(this.reader.getGroupAux(), dataKey) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.getCurrentGroup();
            this.reusing = true;
        }
        m3414startBaiHCIY(key, null, GroupKind.INSTANCE.m3428getGroupULZAiWs(), dataKey);
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableNode() {
        m3414startBaiHCIY(125, null, GroupKind.INSTANCE.m3430getReusableNodeULZAiWs(), null);
        this.nodeExpected = true;
    }

    public final void startReuseFromRoot() {
        this.reusingGroup = 100;
        this.reusing = true;
    }

    public final boolean tryImminentInvalidation$runtime(RecomposeScopeImpl scope, Object instance) {
        Anchor anchor = scope.getAnchor();
        if (anchor == null) {
            return false;
        }
        int indexFor = anchor.toIndexFor(this.reader.getTable());
        if (!this.isComposing || indexFor < this.reader.getCurrentGroup()) {
            return false;
        }
        ComposerKt.insertIfMissing(this.invalidations, indexFor, scope, instance);
        return true;
    }

    public final void updateCachedValue(Object value) {
        if (value instanceof RememberObserver) {
            RememberObserverHolder rememberObserverHolder = new RememberObserverHolder((RememberObserver) value, rememberObserverAnchor());
            if (getInserting()) {
                this.changeListWriter.remember(rememberObserverHolder);
            }
            this.abandonSet.add(value);
            value = rememberObserverHolder;
        }
        updateValue(value);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
    /* renamed from: updateComposerInvalidations-RY85e9Y, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m3417updateComposerInvalidationsRY85e9Y(androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.util.List<androidx.compose.runtime.Invalidation> r2 = r0.invalidations
            int r2 = H4.o.H(r2)
        La:
            r3 = -1
            if (r3 >= r2) goto L3f
            java.util.List<androidx.compose.runtime.Invalidation> r3 = r0.invalidations
            java.lang.Object r3 = r3.get(r2)
            androidx.compose.runtime.Invalidation r3 = (androidx.compose.runtime.Invalidation) r3
            androidx.compose.runtime.RecomposeScopeImpl r4 = r3.getScope()
            androidx.compose.runtime.Anchor r4 = r4.getAnchor()
            if (r4 == 0) goto L37
            boolean r5 = r4.getValid()
            if (r5 == 0) goto L37
            int r5 = r3.getLocation()
            int r6 = r4.getLocation()
            if (r5 == r6) goto L3c
            int r4 = r4.getLocation()
            r3.setLocation(r4)
            goto L3c
        L37:
            java.util.List<androidx.compose.runtime.Invalidation> r3 = r0.invalidations
            r3.remove(r2)
        L3c:
            int r2 = r2 + (-1)
            goto La
        L3f:
            java.lang.Object[] r2 = r1.keys
            java.lang.Object[] r3 = r1.values
            long[] r1 = r1.metadata
            int r4 = r1.length
            int r4 = r4 + (-2)
            if (r4 < 0) goto La2
            r6 = 0
        L4b:
            r7 = r1[r6]
            long r9 = ~r7
            r11 = 7
            long r9 = r9 << r11
            long r9 = r9 & r7
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r11
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 == 0) goto L9d
            int r9 = r6 - r4
            int r9 = ~r9
            int r9 = r9 >>> 31
            r10 = 8
            int r9 = 8 - r9
            r11 = 0
        L65:
            if (r11 >= r9) goto L9b
            r12 = 255(0xff, double:1.26E-321)
            long r12 = r12 & r7
            r14 = 128(0x80, double:6.3E-322)
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 >= 0) goto L97
            int r12 = r6 << 3
            int r12 = r12 + r11
            r13 = r2[r12]
            r12 = r3[r12]
            java.lang.String r14 = "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl"
            kotlin.jvm.internal.k.d(r13, r14)
            androidx.compose.runtime.RecomposeScopeImpl r13 = (androidx.compose.runtime.RecomposeScopeImpl) r13
            androidx.compose.runtime.Anchor r14 = r13.getAnchor()
            if (r14 == 0) goto L97
            int r14 = r14.getLocation()
            java.util.List<androidx.compose.runtime.Invalidation> r15 = r0.invalidations
            androidx.compose.runtime.ScopeInvalidated r5 = androidx.compose.runtime.ScopeInvalidated.INSTANCE
            if (r12 != r5) goto L8f
            r12 = 0
        L8f:
            androidx.compose.runtime.Invalidation r5 = new androidx.compose.runtime.Invalidation
            r5.<init>(r13, r14, r12)
            r15.add(r5)
        L97:
            long r7 = r7 >> r10
            int r11 = r11 + 1
            goto L65
        L9b:
            if (r9 != r10) goto La2
        L9d:
            if (r6 == r4) goto La2
            int r6 = r6 + 1
            goto L4b
        La2:
            java.util.List<androidx.compose.runtime.Invalidation> r0 = r0.invalidations
            java.util.Comparator r1 = androidx.compose.runtime.ComposerKt.access$getInvalidationLocationAscending$p()
            D7.z.d0(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.m3417updateComposerInvalidationsRY85e9Y(androidx.collection.MutableScatterMap):void");
    }

    @Override // androidx.compose.runtime.Composer
    public void updateRememberedValue(Object value) {
        updateCachedValue(value);
    }

    public final void updateValue(Object value) {
        if (getInserting()) {
            this.writer.update(value);
            return;
        }
        if (!this.reader.getHadNext()) {
            ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
            SlotReader slotReader = this.reader;
            composerChangeListWriter.appendValue(slotReader.anchor(slotReader.getParent()), value);
            return;
        }
        int groupSlotIndex = this.reader.getGroupSlotIndex() - 1;
        if (!this.changeListWriter.getPastParent()) {
            this.changeListWriter.updateValue(value, groupSlotIndex);
            return;
        }
        ComposerChangeListWriter composerChangeListWriter2 = this.changeListWriter;
        SlotReader slotReader2 = this.reader;
        composerChangeListWriter2.updateAnchoredValue(value, slotReader2.anchor(slotReader2.getParent()), groupSlotIndex);
    }

    @Override // androidx.compose.runtime.Composer
    public void useNode() {
        validateNodeExpected();
        if (getInserting()) {
            ComposerKt.composeImmediateRuntimeError("useNode() called while inserting");
        }
        Object node = getNode(this.reader);
        this.changeListWriter.moveDown(node);
        if (this.reusing && (node instanceof ComposeNodeLifecycleCallback)) {
            this.changeListWriter.useNode(node);
        }
    }

    public final void verifyConsistent$runtime() {
        this.insertTable.verifyWellFormed();
    }

    private final void startGroup(int key, Object dataKey) {
        m3414startBaiHCIY(key, dataKey, GroupKind.INSTANCE.m3428getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionImpl getComposition() {
        return this.composition;
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope(int group) {
        PersistentCompositionLocalMap persistentCompositionLocalMap;
        if (getInserting() && this.writerHasAProvider) {
            int parent = this.writer.getParent();
            while (parent > 0) {
                if (this.writer.groupKey(parent) == 202 && kotlin.jvm.internal.k.b(this.writer.groupObjectKey(parent), ComposerKt.getCompositionLocalMap())) {
                    Object objGroupAux = this.writer.groupAux(parent);
                    kotlin.jvm.internal.k.d(objGroupAux, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                    PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) objGroupAux;
                    this.providerCache = persistentCompositionLocalMap2;
                    return persistentCompositionLocalMap2;
                }
                parent = this.writer.parent(parent);
            }
        }
        if (this.reader.getGroupsSize() > 0) {
            while (group > 0) {
                if (this.reader.groupKey(group) == 202 && kotlin.jvm.internal.k.b(this.reader.groupObjectKey(group), ComposerKt.getCompositionLocalMap())) {
                    MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap = this.providerUpdates;
                    if (mutableIntObjectMap == null || (persistentCompositionLocalMap = mutableIntObjectMap.get(group)) == null) {
                        Object objGroupAux2 = this.reader.groupAux(group);
                        kotlin.jvm.internal.k.d(objGroupAux2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                        persistentCompositionLocalMap = (PersistentCompositionLocalMap) objGroupAux2;
                    }
                    this.providerCache = persistentCompositionLocalMap;
                    return persistentCompositionLocalMap;
                }
                group = this.reader.parent(group);
            }
        }
        PersistentCompositionLocalMap persistentCompositionLocalMap3 = this.rootProvider;
        this.providerCache = persistentCompositionLocalMap3;
        return persistentCompositionLocalMap3;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(char value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Character) && value == ((Character) objNextSlot).charValue()) {
            return false;
        }
        updateValue(Character.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(byte value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Byte) && value == ((Number) objNextSlot).byteValue()) {
            return false;
        }
        updateValue(Byte.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(short value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Short) && value == ((Number) objNextSlot).shortValue()) {
            return false;
        }
        updateValue(Short.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(boolean value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Boolean) && value == ((Boolean) objNextSlot).booleanValue()) {
            return false;
        }
        updateValue(Boolean.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(float value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Float) && value == ((Number) objNextSlot).floatValue()) {
            return false;
        }
        updateValue(Float.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(long value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Long) && value == ((Number) objNextSlot).longValue()) {
            return false;
        }
        updateValue(Long.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(double value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Double) && value == ((Number) objNextSlot).doubleValue()) {
            return false;
        }
        updateValue(Double.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(int value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Integer) && value == ((Number) objNextSlot).intValue()) {
            return false;
        }
        updateValue(Integer.valueOf(value));
        return true;
    }
}
