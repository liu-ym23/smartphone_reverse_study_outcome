package androidx.compose.runtime;

import androidx.collection.IntSetKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.compose.ui.spatial.RectListKt;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.larus.trace.CopyContentTypeString;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0001\u0018\u0000 Ø\u00012\u00020\u0001:\u0002Ø\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u00103\u001a\u00020/2\u0006\u00108\u001a\u00020\u0019J\u000e\u0010!\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J\u000e\u00109\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J\u0010\u0010:\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0019J\u000e\u0010;\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J\u0010\u0010<\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0019J\u000e\u0010=\u001a\u00020/2\u0006\u00108\u001a\u00020\u0019J\u000e\u0010>\u001a\u00020/2\u0006\u00108\u001a\u00020\u0019J\u0016\u0010?\u001a\u00020/2\u0006\u00108\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0019J\u0010\u0010A\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0019J\u0010\u0010A\u001a\u0004\u0018\u00010\u00012\u0006\u0010B\u001a\u00020\u000fJ\u000e\u0010C\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J\u000e\u0010C\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u000fJ\u000e\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020/J\u0006\u0010J\u001a\u00020HJ\u0012\u0010K\u001a\u0004\u0018\u00010\u00012\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0014\u0010L\u001a\u0004\u0018\u00010\u00012\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0002J\u0018\u0010M\u001a\u00020H2\u0006\u0010B\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u000e\u0010N\u001a\u00020H2\u0006\u0010O\u001a\u00020\u0019J\u0010\u0010P\u001a\u00020H2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0010\u0010Q\u001a\u00020H2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0006\u0010R\u001a\u00020HJ\u000e\u0010S\u001a\u00020H2\u0006\u0010T\u001a\u00020UJ\u0016\u0010V\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\u0006\u0010(\u001a\u00020UJ\u0006\u0010X\u001a\u00020HJ\u001c\u0010Y\u001a\u0004\u0018\u00010\u00132\u0006\u0010C\u001a\u00020\u00192\b\u0010T\u001a\u0004\u0018\u00010UH\u0002J\u0010\u0010Z\u001a\u00020H2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0018\u0010Z\u001a\u00020H2\u0006\u0010B\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0010\u0010[\u001a\u00020H2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\\\u001a\u00020H2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u001d\u0010\\\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0086\bJ\u0016\u0010]\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J\"\u0010\\\u001a\u0004\u0018\u00010\u00012\u0006\u0010@\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u0010\u0010^\u001a\u0004\u0018\u00010\u00012\u0006\u0010_\u001a\u00020\u0019J\b\u0010`\u001a\u0004\u0018\u00010\u0001J\u0018\u0010a\u001a\u0004\u0018\u00010\u00012\u0006\u0010B\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u0019J\u0018\u0010a\u001a\u0004\u0018\u00010\u00012\u0006\u0010b\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J5\u0010c\u001a\u00020H2\u0006\u0010b\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u00192\u001a\u0010d\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020H0eH\u0086\bJ\u0015\u0010f\u001a\u00020\u00192\u0006\u0010b\u001a\u00020\u0019H\u0000¢\u0006\u0002\bgJ\u0015\u0010h\u001a\u00020\u00192\u0006\u0010b\u001a\u00020\u0019H\u0000¢\u0006\u0002\biJ\u0015\u0010j\u001a\u00020\u00192\u0006\u0010b\u001a\u00020\u0019H\u0000¢\u0006\u0002\bkJ\u000e\u0010n\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0019J\u000e\u0010o\u001a\u00020H2\u0006\u0010p\u001a\u00020\u0019J\u000e\u0010q\u001a\u00020H2\u0006\u0010B\u001a\u00020\u000fJ\u0006\u0010r\u001a\u00020HJ\u0006\u0010s\u001a\u00020HJ\u0006\u0010t\u001a\u00020HJ\u0006\u0010u\u001a\u00020HJ\u000e\u0010u\u001a\u00020H2\u0006\u0010W\u001a\u00020\u0019J\u0018\u0010u\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\b\u0010v\u001a\u0004\u0018\u00010\u0001J\u0018\u0010w\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\b\u0010x\u001a\u0004\u0018\u00010\u0001J\"\u0010w\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\b\u0010x\u001a\u0004\u0018\u00010\u00012\b\u0010A\u001a\u0004\u0018\u00010\u0001J\"\u0010y\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\b\u0010x\u001a\u0004\u0018\u00010\u00012\b\u0010z\u001a\u0004\u0018\u00010\u0001J\u0018\u0010y\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\b\u0010z\u001a\u0004\u0018\u00010\u0001J,\u0010u\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00192\b\u0010x\u001a\u0004\u0018\u00010\u00012\u0006\u00103\u001a\u00020/2\b\u0010z\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010{\u001a\u00020\u0019J\u000e\u0010|\u001a\u00020H2\u0006\u00108\u001a\u00020\u0019J\u000e\u0010|\u001a\u00020H2\u0006\u0010B\u001a\u00020\u000fJ\u0006\u0010}\u001a\u00020\u0019J\u0006\u0010~\u001a\u00020/J\u000f\u0010\u007f\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0080\u0001JQ\u0010\u0081\u0001\u001a\u00020H2\u0006\u0010@\u001a\u00020\u00192=\u0010d\u001a9\u0012\u0015\u0012\u00130\u0019¢\u0006\u000e\b\u0082\u0001\u0012\t\b\u0083\u0001\u0012\u0004\b\b(8\u0012\u0018\u0012\u0016\u0018\u00010\u0001¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0084\u0001\u0012\u0004\u0012\u00020H0eH\u0086\bJb\u0010\u0085\u0001\u001a\u00020H2\u0006\u0010@\u001a\u00020\u00192&\u0010\u0086\u0001\u001a!\u0012\u0016\u0012\u00140\u0019¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0088\u0001\u0012\u0004\u0012\u00020H0\u0087\u00012&\u0010\u0089\u0001\u001a!\u0012\u0016\u0012\u00140\u0019¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0088\u0001\u0012\u0004\u0012\u00020H0\u0087\u0001H\u0086\bJN\u0010\u008a\u0001\u001a\u00020H2\u0006\u0010@\u001a\u00020\u00192=\u0010d\u001a9\u0012\u0015\u0012\u00130\u0019¢\u0006\u000e\b\u0082\u0001\u0012\t\b\u0083\u0001\u0012\u0004\b\b(8\u0012\u0018\u0012\u0016\u0018\u00010\u0001¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0084\u0001\u0012\u0004\u0012\u00020H0eJ\u0010\u0010\u008b\u0001\u001a\u00020H2\u0007\u0010\u008c\u0001\u001a\u00020\u0019J\u0018\u0010\u008d\u0001\u001a\u00020/2\u0007\u0010\u008e\u0001\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fJ(\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0090\u00012\u0006\u0010B\u001a\u00020\u000f2\u0007\u0010\u008c\u0001\u001a\u00020\u00192\u0007\u0010\u0091\u0001\u001a\u00020\u0000J)\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0090\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00192\t\b\u0002\u0010\u0093\u0001\u001a\u00020/J\u0007\u0010\u0094\u0001\u001a\u00020HJ'\u0010\u0095\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0090\u00012\u0007\u0010\u008c\u0001\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0019J\u0010\u0010B\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u0019J\u0011\u0010\u0096\u0001\u001a\u00020H2\b\b\u0002\u0010@\u001a\u00020\u0019J\u0011\u0010\u0097\u0001\u001a\u00020/2\u0006\u0010@\u001a\u00020\u0019H\u0002J\u0011\u0010\u0098\u0001\u001a\u00020/2\u0006\u0010@\u001a\u00020\u0019H\u0002J\t\u0010\u009c\u0001\u001a\u00020HH\u0002J\u0011\u0010\u009d\u0001\u001a\u00020H2\u0006\u0010@\u001a\u00020\u0019H\u0002J#\u0010\u009e\u0001\u001a\u00020H2\u0006\u0010@\u001a\u00020\u00192\u0007\u0010\\\u001a\u00030\u009a\u0001H\u0002¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u0011\u0010¡\u0001\u001a\u00020/2\u0006\u0010@\u001a\u00020\u0019H\u0002J\u000f\u0010¢\u0001\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u000fJ\t\u0010£\u0001\u001a\u00020UH\u0016J\t\u0010¤\u0001\u001a\u00020HH\u0002J\t\u0010¥\u0001\u001a\u00020\u0019H\u0002J\"\u0010¦\u0001\u001a\u00020H2\u0006\u0010C\u001a\u00020\u00192\u0006\u0010{\u001a\u00020\u00192\u0007\u0010§\u0001\u001a\u00020\u0019H\u0002J\u0011\u0010¨\u0001\u001a\u00020H2\u0006\u00108\u001a\u00020\u0019H\u0002J\u0019\u0010©\u0001\u001a\u00020H2\u0006\u00108\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0019H\u0002J\t\u0010ª\u0001\u001a\u00020HH\u0002J\u0012\u0010«\u0001\u001a\u00020H2\u0007\u0010¬\u0001\u001a\u00020\u0019H\u0002J\u001a\u0010\u00ad\u0001\u001a\u00020H2\u0007\u0010¬\u0001\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0019H\u0002J\u001b\u0010®\u0001\u001a\u00020/2\u0007\u0010¯\u0001\u001a\u00020\u00192\u0007\u0010°\u0001\u001a\u00020\u0019H\u0002J\u0019\u0010±\u0001\u001a\u0004\u0018\u00010\u00132\u0006\u0010@\u001a\u00020\u0019H\u0000¢\u0006\u0003\b²\u0001J\u0019\u0010³\u0001\u001a\u0004\u0018\u00010\u000f2\u0006\u0010@\u001a\u00020\u0019H\u0000¢\u0006\u0003\b´\u0001J#\u0010µ\u0001\u001a\u00020H2\u0007\u0010¯\u0001\u001a\u00020\u00192\u0007\u0010°\u0001\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0019H\u0002J\u001b\u0010¶\u0001\u001a\u00020H2\u0006\u00108\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0002J\u001b\u0010·\u0001\u001a\u00020H2\u0007\u0010¸\u0001\u001a\u00020\u00192\u0007\u0010¹\u0001\u001a\u00020\u0019H\u0002JC\u0010º\u0001\u001a\u00020/2\u0007\u0010»\u0001\u001a\u00020\u00192\u0007\u0010¬\u0001\u001a\u00020\u00192&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014H\u0002J$\u0010¼\u0001\u001a\u00020H2\u0007\u0010½\u0001\u001a\u00020\u00192\u0007\u0010¾\u0001\u001a\u00020\u00192\u0007\u0010¬\u0001\u001a\u00020\u0019H\u0002J\u0007\u0010¿\u0001\u001a\u00020UJ\u001b\u0010À\u0001\u001a\u00020H*\b0Á\u0001j\u0003`Â\u00012\u0006\u00108\u001a\u00020\u0019H\u0002J\u000f\u0010Ã\u0001\u001a\u00020HH\u0000¢\u0006\u0003\bÄ\u0001J\u000f\u0010Å\u0001\u001a\u00020HH\u0000¢\u0006\u0003\bÆ\u0001J\u0011\u0010Ê\u0001\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019H\u0002J\u0012\u0010Ë\u0001\u001a\u00020\u00192\u0007\u0010Ì\u0001\u001a\u00020\u0019H\u0002J\u0014\u0010C\u001a\u00020\u0019*\u00020\t2\u0006\u00108\u001a\u00020\u0019H\u0002J\u0011\u0010Ì\u0001\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019H\u0002J\u0016\u0010Ì\u0001\u001a\u00020\u0019*\u00020\t2\u0007\u0010Í\u0001\u001a\u00020\u0019H\u0002J\u0015\u0010_\u001a\u00020\u0019*\u00020\t2\u0007\u0010Í\u0001\u001a\u00020\u0019H\u0002J\u001f\u0010Î\u0001\u001a\u00020H*\u00020\t2\u0007\u0010Í\u0001\u001a\u00020\u00192\u0007\u0010Ì\u0001\u001a\u00020\u0019H\u0002J\u0016\u0010Ï\u0001\u001a\u00020\u0019*\u00020\t2\u0007\u0010Í\u0001\u001a\u00020\u0019H\u0002J\u0016\u0010Ð\u0001\u001a\u00020\u0019*\u00020\t2\u0007\u0010Í\u0001\u001a\u00020\u0019H\u0002J\u0014\u0010Ñ\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190\u0090\u0001*\u00020\tH\u0002J\u0010\u0010Ò\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190\u0090\u0001H\u0002J,\u0010Ó\u0001\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00192\u0007\u0010»\u0001\u001a\u00020\u00192\u0007\u0010Ô\u0001\u001a\u00020\u00192\u0007\u0010È\u0001\u001a\u00020\u0019H\u0002J#\u0010Õ\u0001\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u00192\u0007\u0010Ô\u0001\u001a\u00020\u00192\u0007\u0010È\u0001\u001a\u00020\u0019H\u0002J\u001a\u0010Ö\u0001\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00192\u0007\u0010»\u0001\u001a\u00020\u0019H\u0002J\u0011\u0010×\u0001\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010'\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0011\u0010.\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b.\u00100R\u0011\u00101\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b2\u0010+R\u0011\u00103\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b3\u00100R\u0011\u00104\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b5\u00100R\u0011\u00106\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b7\u00100R\u001e\u0010C\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010+R\u001e\u0010E\u001a\u00020/2\u0006\u0010(\u001a\u00020/@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u00100R\u0014\u0010l\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bm\u0010+R\u0015\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001X\u0082\u000e¢\u0006\u0005\n\u0003\u0010\u009b\u0001R\u0016\u0010¬\u0001\u001a\u00020\u00198@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÇ\u0001\u0010+R\u0016\u0010È\u0001\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÉ\u0001\u0010+¨\u0006Ù\u0001"}, d2 = {"Landroidx/compose/runtime/SlotWriter;", "", CopyContentTypeString.TABLE, "Landroidx/compose/runtime/SlotTable;", "<init>", "(Landroidx/compose/runtime/SlotTable;)V", "getTable$runtime", "()Landroidx/compose/runtime/SlotTable;", "groups", "", "slots", "", "[Ljava/lang/Object;", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/GroupSourceInformation;", "Lkotlin/collections/HashMap;", "calledByMap", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "groupGapStart", "", "groupGapLen", "currentSlot", "currentSlotEnd", "slotsGapStart", "slotsGapLen", "slotsGapOwner", "insertCount", "nodeCount", "startStack", "Landroidx/compose/runtime/IntStack;", "endStack", "nodeCountStack", "deferredSlotWrites", "Landroidx/collection/MutableObjectList;", "value", "currentGroup", "getCurrentGroup", "()I", "currentGroupEnd", "getCurrentGroupEnd", "isGroupEnd", "", "()Z", "slotsSize", "getSlotsSize", "isNode", "collectingSourceInformation", "getCollectingSourceInformation", "collectingCalledInformation", "getCollectingCalledInformation", "index", "groupKey", "groupObjectKey", "groupSize", "groupAux", "indexInParent", "indexInCurrentGroup", "indexInGroup", "group", "node", "anchor", "parent", "getParent", PTYSocketStateCallback.CLOSED, "getClosed", "close", "", "normalClose", BasicTestActionHandler.TEST_ACTION_RESET, "update", "rawUpdate", "appendSlot", "trimTailSlots", "count", "updateAux", "insertAux", "updateToTableMaps", "recordGroupSourceInformation", "sourceInformation", "", "recordGrouplessCallSourceInformationStart", "key", "recordGrouplessCallSourceInformationEnd", "groupSourceInformationFor", "updateNode", "updateParentNode", "set", "slotIndexOfGroupSlotIndex", "clear", "slotIndex", "skip", "slot", "groupIndex", "forEachTailSlot", "block", "Lkotlin/Function2;", "slotsStartIndex", "slotsStartIndex$runtime", "slotsEndIndex", "slotsEndIndex$runtime", "slotsEndAllIndex", "slotsEndAllIndex$runtime", "currentGroupSlotIndex", "getCurrentGroupSlotIndex", "groupSlotIndex", "advanceBy", "amount", "seek", "skipToGroupEnd", "beginInsert", "endInsert", "startGroup", "dataKey", "startNode", "objectKey", "startData", "aux", "endGroup", "ensureStarted", "skipGroup", "removeGroup", "groupSlots", "", "forAllData", "Lkotlin/ParameterName;", "name", "data", "traverseGroupAndChildren", "enter", "Lkotlin/Function1;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "exit", "forAllDataInRememberOrder", "moveGroup", "offset", "inGroup", "groupAnchor", "moveTo", "", "writer", "moveFrom", "removeSourceGroup", "bashCurrentGroup", "moveIntoGroupFrom", "markGroup", "containsGroupMark", "containsAnyGroupMarks", "pendingRecalculateMarks", "Landroidx/compose/runtime/PrioritySet;", "Landroidx/collection/MutableIntList;", "recalculateMarks", "updateContainsMark", "updateContainsMarkNow", "updateContainsMarkNow-XpTMRCE", "(ILandroidx/collection/MutableIntList;)V", "childContainsAnyMarks", "anchorIndex", "toString", "saveCurrentGroupEnd", "restoreCurrentGroupEnd", "fixParentAnchorsFor", "firstChild", "moveGroupGapTo", "moveSlotGapTo", "clearSlotGap", "insertGroups", "size", "insertSlots", "removeGroups", "start", "len", "sourceInformationOf", "sourceInformationOf$runtime", "tryAnchor", "tryAnchor$runtime", "removeSlots", "updateNodeOfGroup", "updateAnchors", "previousGapStart", "newGapStart", "removeAnchors", "gapStart", "moveAnchors", "originalLocation", "newLocation", "toDebugString", "groupAsString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "verifyDataAnchors", "verifyDataAnchors$runtime", "verifyParentAnchors", "verifyParentAnchors$runtime", "getSize$runtime", "capacity", "getCapacity", "groupIndexToAddress", "dataIndexToDataAddress", "dataIndex", "address", "updateDataIndex", "nodeIndex", "auxIndex", "dataIndexes", "keys", "dataIndexToDataAnchor", "gapLen", "dataAnchorToDataIndex", "parentIndexToAnchor", "parentAnchorToIndex", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SlotWriter {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private ArrayList<Anchor> anchors;
    private MutableIntObjectMap<MutableIntSet> calledByMap;
    private boolean closed;
    private int currentGroup;
    private int currentGroupEnd;
    private int currentSlot;
    private int currentSlotEnd;
    private MutableIntObjectMap<MutableObjectList<Object>> deferredSlotWrites;
    private final IntStack endStack;
    private int groupGapLen;
    private int groupGapStart;
    private int[] groups;
    private int insertCount;
    private int nodeCount;
    private final IntStack nodeCountStack;
    private int parent;
    private MutableIntList pendingRecalculateMarks;
    private Object[] slots;
    private int slotsGapLen;
    private int slotsGapOwner;
    private int slotsGapStart;
    private HashMap<Anchor, GroupSourceInformation> sourceInformationMap;
    private final IntStack startStack;
    private final SlotTable table;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0002¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/SlotWriter$Companion;", "", "<init>", "()V", "moveGroup", "", "Landroidx/compose/runtime/Anchor;", "fromWriter", "Landroidx/compose/runtime/SlotWriter;", "fromIndex", "", "toWriter", "updateFromCursor", "", "updateToCursor", "removeSourceGroup", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final List<Anchor> moveGroup(SlotWriter r210, int r211, SlotWriter r212, boolean r213, boolean r214, boolean r310) {
            int r100 = r210.groupSize(r211);
            int r101 = r211 + r100;
            int r102 = SlotWriter.access$dataIndex(r210, r211);
            int r103 = SlotWriter.access$dataIndex(r210, r101);
            int r104 = r103 - r102;
            boolean r105 = SlotWriter.access$containsAnyGroupMarks(r210, r211);
            SlotWriter.access$insertGroups(r212, r100);
            SlotWriter.access$insertSlots(r212, r104, r212.getCurrentGroup());
            if (SlotWriter.access$getGroupGapStart$p(r210) >= r101) goto L6;
            SlotWriter.access$moveGroupGapTo(r210, r101);
        L6:
            if (SlotWriter.access$getSlotsGapStart$p(r210) >= r103) goto L8;
            SlotWriter.access$moveSlotGapTo(r210, r103, r101);
        L8:
            int[] r106 = SlotWriter.access$getGroups$p(r212);
            int r107 = r212.getCurrentGroup();
            int r110 = r107 * 5;
            ArraysKt.copyInto(SlotWriter.access$getGroups$p(r210), r106, r110, r211 * 5, r101 * 5);
            Object[] r111 = SlotWriter.access$getSlots$p(r212);
            int r112 = SlotWriter.access$getCurrentSlot$p(r212);
            System.arraycopy(SlotWriter.access$getSlots$p(r210), r102, r111, r112, r104);
            int r113 = r212.getParent();
            r106[r110 + 2] = r113;
            int r114 = r107 - r211;
            int r115 = r107 + r100;
            int r116 = r112 - SlotWriter.access$dataIndex(r212, r106, r107);
            int r117 = SlotWriter.access$getSlotsGapOwner$p(r212);
            int r108 = SlotWriter.access$getSlotsGapLen$p(r212);
            int r118 = r111.length;
            int r119 = r117;
            int r120 = r107;
        L9:
            boolean r215 = false;
            if (r120 >= r115) goto L21;
            if (r120 == r107) goto L13;
            int r216 = (r120 * 5) + 2;
            r106[r216] = r106[r216] + r114;
        L13:
            int r217 = r107;
            int r109 = SlotWriter.access$dataIndex(r212, r106, r120) + r116;
            if (r119 >= r120) goto L16;
            int r121 = 0;
        L17:
            r106[(r120 * 5) + 4] = SlotWriter.access$dataIndexToDataAnchor(r212, r109, r121, r108, r118);
            if (r120 != r119) goto L20;
            r119 = r119 + 1;
        L20:
            r120 = r120 + 1;
            r115 = r115;
            r107 = r217;
            goto L9
        L16:
            r121 = SlotWriter.access$getSlotsGapStart$p(r212);
            goto L17
        L21:
            int r218 = r115;
            SlotWriter.access$setSlotsGapOwner$p(r212, r119);
            int r122 = SlotTableKt.access$locationOf(SlotWriter.access$getAnchors$p(r210), r211, r210.getSize$runtime());
            int r123 = SlotTableKt.access$locationOf(SlotWriter.access$getAnchors$p(r210), r101, r210.getSize$runtime());
            if (r122 >= r123) goto L27;
            ArrayList r124 = SlotWriter.access$getAnchors$p(r210);
            ArrayList r125 = new ArrayList(r123 - r122);
            int r126 = r122;
        L24:
            if (r126 >= r123) goto L26;
            Anchor r127 = (Anchor) ListProtector.get(r124, r126);
            r127.setLocation$runtime(r127.getLocation$runtime() + r114);
            r125.add(r127);
            r126 = r126 + 1;
            goto L24
        L26:
            SlotWriter.access$getAnchors$p(r212).addAll(SlotTableKt.access$locationOf(SlotWriter.access$getAnchors$p(r212), r212.getCurrentGroup(), r212.getSize$runtime()), r125);
            r124.subList(r122, r123).clear();
            List<Anchor> r128 = r125;
        L28:
            List<Anchor> r129 = r128;
            int r130 = 1;
            if ((!r129.isEmpty()) == false) goto L39;
            HashMap r131 = SlotWriter.access$getSourceInformationMap$p(r210);
            HashMap r132 = SlotWriter.access$getSourceInformationMap$p(r212);
            if (r131 == null) goto L39;
            if (r132 == null) goto L39;
            int r133 = r129.size();
            int r134 = 0;
        L34:
            if (r134 >= r133) goto L39;
            Anchor r135 = (Anchor) ListProtector.get(r128, r134);
            GroupSourceInformation r136 = (GroupSourceInformation) r131.get(r135);
            if (r136 == null) goto L38;
            r131.remove(r135);
            r132.put(r135, r136);
        L38:
            r134 = r134 + 1;
        L39:
            int r137 = r212.getParent();
            GroupSourceInformation r138 = r212.sourceInformationOf$runtime(r113);
            if (r138 == null) goto L45;
            int r139 = r137 + 1;
            int r140 = r212.getCurrentGroup();
            int r141 = -1;
        L42:
            if (r139 >= r140) goto L44;
            r141 = r139;
            r139 = SlotTableKt.access$groupSize(SlotWriter.access$getGroups$p(r212), r139) + r139;
            goto L42
        L44:
            r138.addGroupAfter(r212, r141, r140);
        L45:
            int r142 = r210.parent(r211);
            if (r310 == true) goto L48;
            boolean r143 = false;
        L59:
            if ((!r143) == true) goto L61;
            ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
        L61:
            int r144 = SlotWriter.access$getNodeCount$p(r212);
            int r145 = r106[r110 + 1];
            if ((1073741824 & r145) == 0) goto L64;
            r215 = true;
        L64:
            if (r215 == true) goto L67;
            r130 = r145 & RectListKt.Lower26Bits;
        L67:
            SlotWriter.access$setNodeCount$p(r212, r144 + r130);
            if (r214 == false) goto L70;
            SlotWriter.access$setCurrentGroup$p(r212, r218);
            SlotWriter.access$setCurrentSlot$p(r212, r112 + r104);
        L70:
            if (r105 == false) goto L72;
            SlotWriter.access$updateContainsMark(r212, r113);
        L72:
            return r128;
        L48:
            if (r213 == false) goto L57;
            if (r142 < 0) goto L51;
            boolean r146 = true;
        L52:
            if (r146 == false) goto L54;
            r210.startGroup();
            r210.advanceBy(r142 - r210.getCurrentGroup());
            r210.startGroup();
        L54:
            r210.advanceBy(r211 - r210.getCurrentGroup());
            r143 = r210.removeGroup();
            if (r146 == false) goto L59;
            r210.skipToGroupEnd();
            r210.endGroup();
            r210.skipToGroupEnd();
            r210.endGroup();
            goto L59
        L51:
            r146 = false;
            goto L52
        L57:
            boolean r147 = SlotWriter.access$removeGroups(r210, r211, r100);
            SlotWriter.access$removeSlots(r210, r102, r104, r211 - 1);
            r143 = r147;
            goto L59
        L27:
            r128 = CollectionsKt.emptyList();
            goto L28
        }

        public static final /* synthetic */ List access$moveGroup(Companion r100, SlotWriter r101, int r102, SlotWriter r103, boolean r104, boolean r105, boolean r106) {
            return r100.moveGroup(r101, r102, r103, r104, r105, r106);
        }

        public static /* synthetic */ List moveGroup$default(Companion r100, SlotWriter r101, int r102, SlotWriter r110, boolean r111, boolean r112, boolean r113, int r114, Object r115) {
            if ((r114 & 32) == 0) goto L5;
            boolean r103 = true;
        L7:
            return r100.moveGroup(r101, r102, r110, r111, r112, r103);
        L5:
            r103 = r113;
            goto L7
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.SlotWriter$groupSlots$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"androidx/compose/runtime/SlotWriter$groupSlots$1", "", "", "current", "", "getCurrent", "()I", "setCurrent", "(I)V", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<Object>, KMappedMarker {
        final /* synthetic */ int $end;
        private int current;
        final /* synthetic */ SlotWriter this$0;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.current >= this.$end) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext() == false) goto L5;
            Object[] r100 = SlotWriter.access$getSlots$p(this.this$0);
            SlotWriter r101 = this.this$0;
            int r102 = this.current;
            this.current = r102 + 1;
            return r100[SlotWriter.access$dataIndexToDataAddress(r101, r102)];
        L5:
            return null;
        }

        public final int getCurrent() {
            return this.current;
        }

        public final void setCurrent(int r100) {
            this.current = r100;
        }

        public AnonymousClass1(int r100, int r101, SlotWriter r102) {
            this.$end = r101;
            this.this$0 = r102;
            this.current = r100;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    private final int dataAnchorToDataIndex(int r100, int r101, int r102) {
        if (r100 < 0) goto L4;
        return r100;
    L4:
        return ((r102 - r101) + r100) + 1;
    }

    private final int dataIndexToDataAnchor(int r100, int r101, int r102, int r103) {
        if (r100 > r101) goto L4;
        return r100;
    L4:
        return -(((r103 - r102) - r100) + 1);
    }

    private final void clearSlotGap() {
        int r100 = this.slotsGapStart;
        int r101 = this.slotsGapLen + r100;
        ArraysKt.fill(this.slots, null, r100, r101);
    }

    private final int getCapacity() {
        return this.groups.length / 5;
    }

    private final int getCurrentGroupSlotIndex() {
        return groupSlotIndex(this.parent);
    }

    private final List<Integer> keys() {
        List r100 = SlotTableKt.keys$default(this.groups, 0, 1, null);
        ArrayList r101 = new ArrayList(r100.size());
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L14;
        Object r104 = ListProtector.get(r100, r103);
        ((Number) r104).intValue();
        int r105 = this.groupGapStart;
        if (r103 >= r105) goto L7;
    L10:
        boolean r106 = true;
    L11:
        if (r106 == false) goto L13;
        r101.add(r104);
    L13:
        r103 = r103 + 1;
        goto L3
    L7:
        if (r103 >= (r105 + this.groupGapLen)) goto L10;
        r106 = false;
        goto L11
    L14:
        return r101;
    }

    private final void recalculateMarks() {
        MutableIntList r100 = this.pendingRecalculateMarks;
        if (r100 != null) goto L5;
        return;
    L5:
        if (PrioritySet.m4133isNotEmptyimpl(r100) == false) goto L9;
        m4147updateContainsMarkNowXpTMRCE(PrioritySet.m4135takeMaximpl(r100), r100);
        goto L5
    }

    private final void saveCurrentGroupEnd() {
        this.endStack.push((getCapacity() - this.groupGapLen) - this.currentGroupEnd);
    }

    public final void bashCurrentGroup() {
        SlotTableKt.access$updateGroupKey(this.groups, this.currentGroup, -3);
    }

    public final void beginInsert() {
        int r100 = this.insertCount;
        this.insertCount = r100 + 1;
        if (r100 != 0) goto L6;
        saveCurrentGroupEnd();
        return;
    }

    public final int endGroup() {
        int r100 = 0;
        if (this.insertCount <= 0) goto L5;
        boolean r101 = true;
    L6:
        int r102 = this.currentGroup;
        int r103 = this.currentGroupEnd;
        int r104 = this.parent;
        int r105 = groupIndexToAddress(r104);
        int r106 = this.nodeCount;
        int r107 = r102 - r104;
        int r110 = (r105 * 5) + 1;
        if ((this.groups[r110] & 1073741824) == 0) goto L9;
        boolean r108 = true;
    L10:
        if (r101 == false) goto L31;
        MutableIntObjectMap<MutableObjectList<Object>> r109 = this.deferredSlotWrites;
        if (r109 == null) goto L19;
        MutableObjectList<Object> r111 = r109.get(r104);
        if (r111 == null) goto L19;
        Object[] r112 = r111.content;
        int r113 = r111._size;
        int r114 = 0;
    L16:
        if (r114 >= r113) goto L18;
        rawUpdate(r112[r114]);
        r114 = r114 + 1;
        goto L16
    L18:
        MutableObjectList<Object> r115 = r109.remove(r104);
    L19:
        SlotTableKt.access$updateGroupSize(this.groups, r105, r107);
        SlotTableKt.access$updateNodeCount(this.groups, r105, r106);
        int r116 = this.nodeCountStack.pop();
        if (r108 == false) goto L22;
        int r117 = 1;
    L23:
        this.nodeCount = r116 + r117;
        int r118 = parent(this.groups, r104);
        this.parent = r118;
        if (r118 >= 0) goto L26;
        int r119 = getSize$runtime();
    L27:
        if (r119 < 0) goto L30;
        r100 = dataIndex(this.groups, r119);
    L30:
        this.currentSlot = r100;
        this.currentSlotEnd = r100;
    L65:
        return r106;
    L26:
        r119 = groupIndexToAddress(r118 + 1);
        goto L27
    L22:
        r117 = r106;
        goto L23
    L31:
        if (r102 != r103) goto L33;
        boolean r120 = true;
    L34:
        if (r120 == true) goto L36;
        ComposerKt.composeImmediateRuntimeError("Expected to be at the end of a group");
    L36:
        int r121 = SlotTableKt.access$groupSize(this.groups, r105);
        int[] r122 = this.groups;
        int r123 = r122[r110] & RectListKt.Lower26Bits;
        SlotTableKt.access$updateGroupSize(r122, r105, r107);
        SlotTableKt.access$updateNodeCount(this.groups, r105, r106);
        int r124 = this.startStack.pop();
        restoreCurrentGroupEnd();
        this.parent = r124;
        int r125 = parent(this.groups, r104);
        int r126 = this.nodeCountStack.pop();
        this.nodeCount = r126;
        if (r125 != r124) goto L42;
        if (r108 == true) goto L41;
        r100 = r106 - r123;
    L41:
        this.nodeCount = r126 + r100;
        goto L65
    L42:
        int r127 = r107 - r121;
        if (r108 == false) goto L45;
        int r128 = 0;
    L46:
        if (r127 != 0) goto L48;
        if (r128 != 0) goto L48;
    L64:
        this.nodeCount += r128;
    L48:
        if (r125 == 0) goto L64;
        if (r125 == r124) goto L64;
        if (r128 != 0) goto L52;
        if (r127 == 0) goto L64;
    L52:
        int r129 = groupIndexToAddress(r125);
        if (r127 == 0) goto L55;
        SlotTableKt.access$updateGroupSize(this.groups, r129, SlotTableKt.access$groupSize(this.groups, r129) + r127);
    L55:
        if (r128 == 0) goto L57;
        int[] r130 = this.groups;
        SlotTableKt.access$updateNodeCount(r130, r129, (r130[(r129 * 5) + 1] & RectListKt.Lower26Bits) + r128);
    L57:
        int[] r131 = this.groups;
        if ((r131[(r129 * 5) + 1] & 1073741824) == 0) goto L60;
        boolean r132 = true;
    L61:
        if (r132 == false) goto L63;
        r128 = 0;
    L63:
        r125 = parent(r131, r125);
        goto L48
    L60:
        r132 = false;
        goto L61
    L45:
        r128 = r106 - r123;
        goto L46
    L33:
        r120 = false;
        goto L34
    L9:
        r108 = false;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    public final void endInsert() {
        boolean r100 = true;
        if (this.insertCount <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        PreconditionsKt.throwIllegalStateException("Unbalanced begin/end insert");
    L8:
        int r102 = this.insertCount - 1;
        this.insertCount = r102;
        if (r102 == 0) goto L11;
        return;
    L11:
        if (this.nodeCountStack.tos == this.startStack.tos) goto L14;
        r100 = false;
    L14:
        if (r100 == true) goto L16;
        ComposerKt.composeImmediateRuntimeError("startGroup/endGroup mismatch while inserting");
    L16:
        restoreCurrentGroupEnd();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final boolean getCollectingCalledInformation() {
        if (this.calledByMap == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getCollectingSourceInformation() {
        if (this.sourceInformationMap == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getSlotsSize() {
        return this.slots.length - this.slotsGapLen;
    }

    public final Iterator<Object> groupSlots() {
        int r100 = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int[] r101 = this.groups;
        int r102 = this.currentGroup;
        return new AnonymousClass1(r100, dataIndex(r101, groupIndexToAddress(r102 + groupSize(r102))), this);
    }

    public final boolean isGroupEnd() {
        if (this.currentGroup != this.currentGroupEnd) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNode() {
        int r100 = this.currentGroup;
        if (r100 < this.currentGroupEnd) goto L5;
        return false;
    L5:
        if ((this.groups[(groupIndexToAddress(r100) * 5) + 1] & 1073741824) == 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = false;
        goto L8
    }

    public final void recordGrouplessCallSourceInformationEnd() {
        if (this.insertCount <= 0) goto L8;
        GroupSourceInformation r100 = groupSourceInformationFor(this.parent, null);
        if (r100 == null) goto L9;
        r100.endGrouplessCall(getCurrentGroupSlotIndex());
        return;
    L9:
        return;
    }

    public final boolean removeGroup() {
        if (this.insertCount != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        ComposerKt.composeImmediateRuntimeError("Cannot remove group while inserting");
    L8:
        int r101 = this.currentGroup;
        int r102 = this.currentSlot;
        int r103 = dataIndex(this.groups, groupIndexToAddress(r101));
        int r104 = skipGroup();
        GroupSourceInformation r105 = sourceInformationOf$runtime(this.parent);
        if (r105 == null) goto L13;
        Anchor r106 = tryAnchor$runtime(r101);
        if (r106 == null) goto L13;
        r105.removeAnchor(r106);
    L13:
        MutableIntList r107 = this.pendingRecalculateMarks;
        if (r107 != null) goto L16;
    L20:
        boolean r108 = removeGroups(r101, this.currentGroup - r101);
        removeSlots(r103, this.currentSlot - r103, r101 - 1);
        this.currentGroup = r101;
        this.currentSlot = r102;
        this.nodeCount -= r104;
        return r108;
    L16:
        if (PrioritySet.m4133isNotEmptyimpl(r107) == false) goto L20;
        if (PrioritySet.m4134peekimpl(r107) < r101) goto L20;
        PrioritySet.m4135takeMaximpl(r107);
        goto L16
    L5:
        r100 = false;
        goto L6
    }

    public final void reset() {
        if (this.insertCount != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        ComposerKt.composeImmediateRuntimeError("Cannot reset when inserting");
    L8:
        recalculateMarks();
        this.currentGroup = 0;
        this.currentGroupEnd = getCapacity() - this.groupGapLen;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
        this.nodeCount = 0;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final Object skip() {
        if (this.insertCount <= 0) goto L5;
        insertSlots(1, this.parent);
    L5:
        Object[] r100 = this.slots;
        int r101 = this.currentSlot;
        this.currentSlot = r101 + 1;
        return r100[dataIndexToDataAddress(r101)];
    }

    public final int skipGroup() {
        int r100 = groupIndexToAddress(this.currentGroup);
        int r101 = this.currentGroup + SlotTableKt.access$groupSize(this.groups, r100);
        this.currentGroup = r101;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(r101));
        int r102 = this.groups[(r100 * 5) + 1];
        if ((1073741824 & r102) == 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return 1;
    L9:
        return r102 & RectListKt.Lower26Bits;
    L5:
        r103 = false;
        goto L6
    }

    public final void skipToGroupEnd() {
        int r100 = this.currentGroupEnd;
        this.currentGroup = r100;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(r100));
    }

    public final void startGroup() {
        if (this.insertCount != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        ComposerKt.composeImmediateRuntimeError("Key must be supplied when inserting");
    L8:
        Composer.Companion r101 = Composer.Companion;
        startGroup(0, r101.getEmpty(), false, r101.getEmpty());
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final String toDebugString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(toString());
        r100.append('\n');
        r100.append("  parent:    " + this.parent);
        r100.append('\n');
        r100.append("  current:   " + this.currentGroup);
        r100.append('\n');
        r100.append("  group gap: " + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + '(' + this.groupGapLen + ')');
        r100.append('\n');
        r100.append("  slots gap: " + this.slotsGapStart + '-' + (this.slotsGapStart + this.slotsGapLen) + '(' + this.slotsGapLen + ')');
        r100.append('\n');
        StringBuilder r101 = new StringBuilder("  gap owner: ");
        r101.append(this.slotsGapOwner);
        r100.append(r101.toString());
        r100.append('\n');
        int r102 = getSize$runtime();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        groupAsString(r100, r103);
        r100.append('\n');
        r103 = r103 + 1;
        goto L3
    L6:
        return r100.toString();
    }

    public String toString() {
        return "SlotWriter(current = " + this.currentGroup + " end=" + this.currentGroupEnd + " size = " + getSize$runtime() + " gap=" + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + ')';
    }

    public final void updateToTableMaps() {
        this.sourceInformationMap = this.table.getSourceInformationMap$runtime();
        this.calledByMap = this.table.getCalledByMap$runtime();
    }

    public final void verifyDataAnchors$runtime() {
        int r100 = this.slotsGapOwner;
        int r101 = this.slots.length - this.slotsGapLen;
        int r102 = getSize$runtime();
        int r103 = 0;
        int r104 = 0;
        boolean r105 = false;
    L3:
        if (r103 >= r102) goto L24;
        int r106 = groupIndexToAddress(r103);
        int[] r107 = this.groups;
        int r108 = r107[(r106 * 5) + 4];
        int r109 = dataIndex(r107, r106);
        if (r109 < r104) goto L7;
        boolean r110 = true;
    L8:
        if (r110 == true) goto L10;
        PreconditionsKt.throwIllegalStateException("Data index out of order at " + r103 + ", previous = " + r104 + ", current = " + r109);
    L10:
        if (r109 > r101) goto L12;
        boolean r111 = true;
    L13:
        if (r111 == true) goto L15;
        PreconditionsKt.throwIllegalStateException("Data index, " + r109 + ", out of bound at " + r103);
    L15:
        if (r108 >= 0) goto L23;
        if (r105 == true) goto L23;
        if (r100 != r103) goto L19;
        boolean r112 = true;
    L20:
        if (r112 == true) goto L22;
        PreconditionsKt.throwIllegalStateException("Expected the slot gap owner to be " + r100 + " found gap at " + r103);
    L22:
        r105 = true;
        goto L23
    L19:
        r112 = false;
    L23:
        r103 = r103 + 1;
        r104 = r109;
        goto L3
    L12:
        r111 = false;
        goto L13
    L7:
        r110 = false;
        goto L8
    }

    public final void verifyParentAnchors$runtime() {
        int r100 = this.groupGapStart;
        int r101 = this.groupGapLen;
        int r102 = getCapacity();
        int r103 = 0;
    L3:
        boolean r104 = true;
        if (r103 >= r100) goto L12;
        if (this.groups[(r103 * 5) + 2] > (-2)) goto L9;
        r104 = false;
    L9:
        if (r104 == true) goto L11;
        PreconditionsKt.throwIllegalStateException("Expected a start relative anchor at " + r103);
    L11:
        r103 = r103 + 1;
        goto L3
    L12:
        int r105 = r101 + r100;
    L13:
        if (r105 >= r102) goto L27;
        int r106 = this.groups[(r105 * 5) + 2];
        if (parentAnchorToIndex(r106) >= r100) goto L21;
        if (r106 <= (-2)) goto L18;
        boolean r107 = true;
    L19:
        if (r107 == true) goto L26;
        PreconditionsKt.throwIllegalStateException("Expected a start relative anchor at " + r105);
    L26:
        r105 = r105 + 1;
        goto L13
    L18:
        r107 = false;
        goto L19
    L21:
        if (r106 > (-2)) goto L23;
        boolean r108 = true;
    L24:
        if (r108 == true) goto L26;
        PreconditionsKt.throwIllegalStateException("Expected an end relative anchor at " + r105);
        goto L26
    L23:
        r108 = false;
        goto L24
    }

    private final int restoreCurrentGroupEnd() {
        int r100 = (getCapacity() - this.groupGapLen) - this.endStack.pop();
        this.currentGroupEnd = r100;
        return r100;
    }

    public final int getSize$runtime() {
        return getCapacity() - this.groupGapLen;
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final int getCurrentGroupEnd() {
        return this.currentGroupEnd;
    }

    public final int getParent() {
        return this.parent;
    }

    public final SlotTable getTable$runtime() {
        return this.table;
    }

    public SlotWriter(SlotTable r100) {
        this.table = r100;
        this.groups = r100.getGroups();
        this.slots = r100.getSlots();
        this.anchors = r100.getAnchors$runtime();
        this.sourceInformationMap = r100.getSourceInformationMap$runtime();
        this.calledByMap = r100.getCalledByMap$runtime();
        this.groupGapStart = r100.getGroupsSize();
        this.groupGapLen = (this.groups.length / 5) - r100.getGroupsSize();
        this.slotsGapStart = r100.getSlotsSize();
        this.slotsGapLen = this.slots.length - r100.getSlotsSize();
        this.slotsGapOwner = r100.getGroupsSize();
        this.startStack = new IntStack();
        this.endStack = new IntStack();
        this.nodeCountStack = new IntStack();
        this.currentGroupEnd = r100.getGroupsSize();
        this.parent = -1;
    }

    public static final /* synthetic */ ArrayList access$getAnchors$p(SlotWriter r100) {
        return r100.anchors;
    }

    public static final /* synthetic */ int access$getCurrentSlot$p(SlotWriter r100) {
        return r100.currentSlot;
    }

    public static final /* synthetic */ int access$getGroupGapStart$p(SlotWriter r100) {
        return r100.groupGapStart;
    }

    public static final /* synthetic */ int[] access$getGroups$p(SlotWriter r100) {
        return r100.groups;
    }

    public static final /* synthetic */ int access$getNodeCount$p(SlotWriter r100) {
        return r100.nodeCount;
    }

    public static final /* synthetic */ Object[] access$getSlots$p(SlotWriter r100) {
        return r100.slots;
    }

    public static final /* synthetic */ int access$getSlotsGapLen$p(SlotWriter r100) {
        return r100.slotsGapLen;
    }

    public static final /* synthetic */ int access$getSlotsGapOwner$p(SlotWriter r100) {
        return r100.slotsGapOwner;
    }

    public static final /* synthetic */ int access$getSlotsGapStart$p(SlotWriter r100) {
        return r100.slotsGapStart;
    }

    public static final /* synthetic */ HashMap access$getSourceInformationMap$p(SlotWriter r100) {
        return r100.sourceInformationMap;
    }

    private final boolean childContainsAnyMarks(int r100) {
        int r101 = r100 + 1;
        int r102 = r100 + groupSize(r100);
    L3:
        boolean r103 = false;
        if (r101 >= r102) goto L11;
        if ((this.groups[(groupIndexToAddress(r101) * 5) + 1] & 201326592) == 0) goto L8;
        r103 = true;
    L8:
        if (r103 == true) goto L9;
        r101 = r101 + groupSize(r101);
        goto L3
    L9:
        return true;
    L11:
        return false;
    }

    private final boolean containsAnyGroupMarks(int r100) {
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if ((this.groups[(groupIndexToAddress(r100) * 5) + 1] & 201326592) == 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = false;
        goto L8
    }

    private final boolean containsGroupMark(int r100) {
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if ((this.groups[(groupIndexToAddress(r100) * 5) + 1] & 67108864) == 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = false;
        goto L8
    }

    private final int dataIndex(int r100) {
        return dataIndex(this.groups, groupIndexToAddress(r100));
    }

    private final int dataIndexToDataAddress(int r100) {
        int r101 = this.slotsGapLen;
        if (r100 >= this.slotsGapStart) goto L5;
        int r102 = 0;
    L7:
        return r100 + (r101 * r102);
    L5:
        r102 = 1;
        goto L7
    }

    private final List<Integer> dataIndexes(int[] r100) {
        int r101 = 0;
        List r102 = SlotTableKt.dataAnchors$default(this.groups, 0, 1, null);
        List r103 = CollectionsKt.plus(CollectionsKt.slice(r102, RangesKt.until(0, this.groupGapStart)), CollectionsKt.slice(r102, RangesKt.until(this.groupGapStart + this.groupGapLen, r100.length / 5)));
        ArrayList r104 = new ArrayList(r103.size());
        int r105 = r103.size();
    L3:
        if (r101 >= r105) goto L5;
        r104.add(Integer.valueOf(dataAnchorToDataIndex(((Number) ListProtector.get(r103, r101)).intValue(), this.slotsGapLen, this.slots.length)));
        r101 = r101 + 1;
        goto L3
    L5:
        return r104;
    }

    private final int groupIndexToAddress(int r100) {
        int r101 = this.groupGapLen;
        if (r100 >= this.groupGapStart) goto L5;
        int r102 = 0;
    L7:
        return r100 + (r101 * r102);
    L5:
        r102 = 1;
        goto L7
    }

    private final void insertGroups(int r110) {
        if (r110 <= 0) goto L25;
        int r100 = this.currentGroup;
        moveGroupGapTo(r100);
        int r101 = this.groupGapStart;
        int r102 = this.groupGapLen;
        int[] r103 = this.groups;
        int r104 = r103.length / 5;
        int r105 = r104 - r102;
        int r106 = 0;
        if (r102 >= r110) goto L6;
        int r107 = Math.max(Math.max(r104 * 2, r105 + r110), 32);
        int[] r108 = new int[r107 * 5];
        int r109 = r107 - r105;
        ArraysKt.copyInto(r103, r108, 0, 0, r101 * 5);
        ArraysKt.copyInto(r103, r108, (r101 + r109) * 5, (r102 + r101) * 5, r104 * 5);
        this.groups = r108;
        r102 = r109;
    L6:
        int r111 = this.currentGroupEnd;
        if (r111 < r101) goto L9;
        this.currentGroupEnd = r111 + r110;
    L9:
        int r112 = r101 + r110;
        this.groupGapStart = r112;
        this.groupGapLen = r102 - r110;
        if (r105 <= 0) goto L12;
        int r113 = dataIndex(r100 + r110);
    L14:
        if (this.slotsGapOwner < r101) goto L17;
        r106 = this.slotsGapStart;
    L17:
        int r114 = dataIndexToDataAnchor(r113, r106, this.slotsGapLen, this.slots.length);
        int r115 = r101;
    L18:
        if (r115 >= r112) goto L20;
        this.groups[(r115 * 5) + 4] = r114;
        r115 = r115 + 1;
        goto L18
    L20:
        int r116 = this.slotsGapOwner;
        if (r116 < r101) goto L26;
        this.slotsGapOwner = r116 + r110;
        return;
    L26:
        return;
    L12:
        r113 = 0;
        goto L14
    }

    private final void moveGroupGapTo(int r100) {
        int r101 = this.groupGapLen;
        int r102 = this.groupGapStart;
        if (r102 == r100) goto L27;
        boolean r103 = true;
        if ((!this.anchors.isEmpty()) == false) goto L7;
        updateAnchors(r102, r100);
    L7:
        if (r101 <= 0) goto L12;
        int[] r104 = this.groups;
        int r105 = r100 * 5;
        int r106 = r101 * 5;
        int r107 = r102 * 5;
        if (r100 >= r102) goto L11;
        ArraysKt.copyInto(r104, r104, r106 + r105, r105, r107);
        goto L12
    L11:
        ArraysKt.copyInto(r104, r104, r107, r107 + r106, r105 + r106);
    L12:
        if (r100 >= r102) goto L14;
        r102 = r100 + r101;
    L14:
        int r108 = getCapacity();
        if (r102 < r108) goto L18;
        r103 = false;
    L18:
        if (r103 == true) goto L20;
        ComposerKt.composeImmediateRuntimeError("Check failed");
    L20:
        if (r102 >= r108) goto L27;
        int r109 = (r102 * 5) + 2;
        int r110 = this.groups[r109];
        int r111 = parentIndexToAnchor(parentAnchorToIndex(r110), r100);
        if (r111 == r110) goto L24;
        this.groups[r109] = r111;
    L24:
        r102 = r102 + 1;
        if (r102 != r100) goto L20;
        r102 = r102 + r101;
    L27:
        this.groupGapStart = r100;
    }

    private final int parentAnchorToIndex(int r100) {
        if (r100 <= (-2)) goto L6;
        return r100;
    L6:
        return (getSize$runtime() + r100) + 2;
    }

    private final Object rawUpdate(Object r100) {
        Object r101 = skip();
        set(r100);
        return r101;
    }

    private final void updateContainsMark(int r100) {
        if (r100 < 0) goto L8;
        MutableIntList r101 = this.pendingRecalculateMarks;
        if (r101 != null) goto L6;
        r101 = PrioritySet.m4128constructorimpl$default(null, 1, null);
        this.pendingRecalculateMarks = r101;
    L6:
        PrioritySet.m4125addimpl(r101, r100);
        return;
    }

    public final void advanceBy(int r100) {
        boolean r101 = true;
        if (r100 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        ComposerKt.composeImmediateRuntimeError("Cannot seek backwards");
    L9:
        if (this.insertCount > 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == true) goto L14;
        PreconditionsKt.throwIllegalStateException("Cannot call seek() while inserting");
    L14:
        if (r100 != 0) goto L16;
        return;
    L16:
        int r104 = this.currentGroup + r100;
        if (r104 >= this.parent) goto L19;
    L21:
        r101 = false;
    L22:
        if (r101 == true) goto L24;
        ComposerKt.composeImmediateRuntimeError("Cannot seek outside the current group (" + this.parent + '-' + this.currentGroupEnd + ')');
    L24:
        this.currentGroup = r104;
        int r105 = dataIndex(this.groups, groupIndexToAddress(r104));
        this.currentSlot = r105;
        this.currentSlotEnd = r105;
        return;
    L19:
        if (r104 > this.currentGroupEnd) goto L21;
    L11:
        r103 = false;
        goto L12
    L5:
        r102 = false;
        goto L6
    }

    public final Anchor anchor(int r100) {
        ArrayList<Anchor> r101 = this.anchors;
        int r102 = SlotTableKt.access$search(r101, r100, getSize$runtime());
        if (r102 >= 0) goto L10;
        if (r100 <= this.groupGapStart) goto L8;
        r100 = -(getSize$runtime() - r100);
    L8:
        Anchor r103 = new Anchor(r100);
        ListProtector.add(r101, -(r102 + 1), r103);
        return r103;
    L10:
        return (Anchor) ListProtector.get(r101, r102);
    }

    public final int anchorIndex(Anchor r100) {
        int r101 = r100.getLocation$runtime();
        if (r101 < 0) goto L5;
        return r101;
    L5:
        return r101 + getSize$runtime();
    }

    public final Object clear(int r100) {
        int r101 = dataIndexToDataAddress(r100);
        Object[] r102 = this.slots;
        Object r103 = r102[r101];
        r102[r101] = Composer.Companion.getEmpty();
        return r103;
    }

    public final void close(boolean r110) {
        boolean r100 = true;
        this.closed = true;
        if (r110 == true) goto L5;
    L10:
        this.table.close$runtime(this, this.groups, this.groupGapStart, this.slots, this.slotsGapStart, this.anchors, this.sourceInformationMap, this.calledByMap);
        return;
    L5:
        if (this.startStack.tos == 0) goto L8;
        r100 = false;
    L8:
        if (r100 == false) goto L10;
        moveGroupGapTo(getSize$runtime());
        moveSlotGapTo(this.slots.length - this.slotsGapLen, this.groupGapStart);
        clearSlotGap();
        recalculateMarks();
        goto L10
    }

    public final void ensureStarted(int r100) {
        boolean r101 = true;
        if (this.insertCount > 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        ComposerKt.composeImmediateRuntimeError("Cannot call ensureStarted() while inserting");
    L8:
        int r103 = this.parent;
        if (r103 == r100) goto L19;
        if (r100 >= r103) goto L12;
    L14:
        r101 = false;
    L15:
        if (r101 == true) goto L17;
        ComposerKt.composeImmediateRuntimeError("Started group at " + r100 + " must be a subgroup of the group at " + r103);
    L17:
        int r104 = this.currentGroup;
        int r105 = this.currentSlot;
        int r106 = this.currentSlotEnd;
        this.currentGroup = r100;
        startGroup();
        this.currentGroup = r104;
        this.currentSlot = r105;
        this.currentSlotEnd = r106;
        return;
    L12:
        if (r100 >= this.currentGroupEnd) goto L14;
    L19:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final Object groupAux(int r100) {
        int r101 = groupIndexToAddress(r100);
        int[] r102 = this.groups;
        boolean r103 = true;
        if ((r102[(r101 * 5) + 1] & 268435456) != 0) goto L6;
        r103 = false;
    L6:
        if (r103 == false) goto L9;
        return this.slots[auxIndex(r102, r101)];
    L9:
        return Composer.Companion.getEmpty();
    }

    public final int groupKey(int r100) {
        return this.groups[groupIndexToAddress(r100) * 5];
    }

    public final Object groupObjectKey(int r100) {
        int r101 = groupIndexToAddress(r100);
        int[] r102 = this.groups;
        boolean r103 = true;
        if ((r102[(r101 * 5) + 1] & 536870912) != 0) goto L6;
        r103 = false;
    L6:
        if (r103 == true) goto L10;
        return null;
    L10:
        return this.slots[SlotTableKt.access$objectKeyIndex(r102, r101)];
    }

    public final int groupSize(int r100) {
        return SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(r100));
    }

    public final int groupSlotIndex(int r100) {
        int r101 = this.currentSlot - slotsStartIndex$runtime(r100);
        MutableIntObjectMap<MutableObjectList<Object>> r102 = this.deferredSlotWrites;
        if (r102 == null) goto L7;
        MutableObjectList<Object> r103 = r102.get(r100);
        if (r103 == null) goto L7;
        int r104 = r103.getSize();
    L9:
        return r101 + r104;
    L7:
        r104 = 0;
        goto L9
    }

    public final boolean indexInCurrentGroup(int r100) {
        return indexInGroup(r100, this.currentGroup);
    }

    public final boolean indexInParent(int r100) {
        int r101 = this.parent;
        if (r100 > r101) goto L5;
    L6:
        if (r101 != 0) goto L9;
        if (r100 != 0) goto L9;
    L8:
        return true;
    L9:
        return false;
    L5:
        if (r100 < this.currentGroupEnd) goto L8;
        goto L6
    }

    public final void insertAux(Object r100) {
        boolean r101 = false;
        if (this.insertCount < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        ComposerKt.composeImmediateRuntimeError("Cannot insert auxiliary data when not inserting");
    L8:
        int r103 = this.parent;
        int r104 = groupIndexToAddress(r103);
        if ((this.groups[(r104 * 5) + 1] & 268435456) == 0) goto L11;
        boolean r105 = true;
    L13:
        if ((!r105) == true) goto L15;
        ComposerKt.composeImmediateRuntimeError("Group already has auxiliary data");
    L15:
        insertSlots(1, r103);
        int r106 = auxIndex(this.groups, r104);
        int r107 = dataIndexToDataAddress(r106);
        int r108 = this.currentSlot;
        if (r108 <= r106) goto L25;
        int r109 = r108 - r106;
        if (r109 >= 3) goto L20;
        r101 = true;
    L20:
        if (r101 == true) goto L22;
        PreconditionsKt.throwIllegalStateException("Moving more than two slot not supported");
    L22:
        if (r109 <= 1) goto L24;
        Object[] r110 = this.slots;
        r110[r107 + 2] = r110[r107 + 1];
    L24:
        Object[] r111 = this.slots;
        r111[r107 + 1] = r111[r107];
    L25:
        SlotTableKt.access$addAux(this.groups, r104);
        this.slots[r107] = r100;
        this.currentSlot++;
        return;
    L11:
        r105 = false;
        goto L13
    L5:
        r102 = false;
        goto L6
    }

    public final boolean isNode(int r100) {
        if ((this.groups[(groupIndexToAddress(r100) * 5) + 1] & 1073741824) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final void markGroup(int r100) {
        int r101 = groupIndexToAddress(r100);
        int[] r102 = this.groups;
        boolean r103 = true;
        int r104 = (r101 * 5) + 1;
        if ((r102[r104] & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == true) goto L14;
        SlotTableKt.access$updateMark(r102, r101, true);
        if ((this.groups[r104] & 67108864) != 0) goto L11;
        r103 = false;
    L11:
        if (r103 == true) goto L15;
        updateContainsMark(parent(r100));
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r105 = false;
        goto L6
    }

    public final void moveGroup(int r110) {
        if (this.insertCount != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        ComposerKt.composeImmediateRuntimeError("Cannot move a group while inserting");
    L8:
        if (r110 < 0) goto L10;
        boolean r101 = true;
    L12:
        if (r101 == true) goto L14;
        ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
    L14:
        if (r110 != 0) goto L16;
        return;
    L16:
        int r102 = this.currentGroup;
        int r103 = this.parent;
        int r104 = this.currentGroupEnd;
        int r105 = r110;
        int r106 = r102;
    L17:
        if (r105 <= 0) goto L25;
        r106 = r106 + SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(r106));
        if (r106 > r104) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == true) goto L24;
        ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
    L24:
        r105 = r105 - 1;
        goto L17
    L21:
        r107 = false;
        goto L22
    L25:
        int r108 = SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(r106));
        int r109 = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int r111 = dataIndex(this.groups, groupIndexToAddress(r106));
        int r112 = r106 + r108;
        int r113 = dataIndex(this.groups, groupIndexToAddress(r112));
        int r114 = r113 - r111;
        insertSlots(r114, Math.max(this.currentGroup - 1, 0));
        insertGroups(r108);
        int[] r115 = this.groups;
        int r116 = groupIndexToAddress(r112) * 5;
        ArraysKt.copyInto(r115, r115, groupIndexToAddress(r102) * 5, r116, (r108 * 5) + r116);
        if (r114 <= 0) goto L28;
        Object[] r117 = this.slots;
        int r118 = dataIndexToDataAddress(r111 + r114);
        System.arraycopy(r117, r118, r117, r109, dataIndexToDataAddress(r113 + r114) - r118);
    L28:
        int r119 = r111 + r114;
        int r120 = r119 - r109;
        int r121 = this.slotsGapStart;
        int r122 = this.slotsGapLen;
        int r123 = this.slots.length;
        int r124 = this.slotsGapOwner;
        int r125 = r102 + r108;
        int r126 = r102;
    L29:
        if (r126 >= r125) goto L35;
        int r127 = groupIndexToAddress(r126);
        int r128 = r121;
        int r129 = dataIndex(r115, r127) - r120;
        int r130 = r120;
        if (r124 >= r127) goto L33;
        int r131 = 0;
    L34:
        updateDataIndex(r115, r127, dataIndexToDataAnchor(r129, r131, r122, r123));
        r126 = r126 + 1;
        r121 = r128;
        r120 = r130;
        goto L29
    L33:
        r131 = r128;
        goto L34
    L35:
        moveAnchors(r112, r102, r108);
        if ((!removeGroups(r112, r108)) == true) goto L38;
        ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
    L38:
        fixParentAnchorsFor(r103, this.currentGroupEnd, r102);
        if (r114 <= 0) goto L48;
        removeSlots(r119, r114, r112 - 1);
        return;
    L48:
        return;
    L10:
        r101 = false;
        goto L12
    L5:
        r100 = false;
        goto L6
    }

    public final Object node(int r100) {
        int r101 = groupIndexToAddress(r100);
        int[] r102 = this.groups;
        boolean r103 = true;
        if ((r102[(r101 * 5) + 1] & 1073741824) != 0) goto L6;
        r103 = false;
    L6:
        if (r103 == true) goto L10;
        return null;
    L10:
        return this.slots[dataIndexToDataAddress(nodeIndex(r102, r101))];
    }

    public final int nodeCount(int r100) {
        return this.groups[(groupIndexToAddress(r100) * 5) + 1] & RectListKt.Lower26Bits;
    }

    public final int parent(Anchor r100) {
        if (r100.getValid() == true) goto L7;
        return -1;
    L7:
        return parent(this.groups, anchorIndex(r100));
    }

    public final void recordGroupSourceInformation(String r100) {
        if (this.insertCount <= 0) goto L6;
        groupSourceInformationFor(this.parent, r100);
        return;
    }

    public final void seek(Anchor r100) {
        advanceBy(r100.toIndexFor(this) - this.currentGroup);
    }

    public final void set(Object r100) {
        if (this.currentSlot > this.currentSlotEnd) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        ComposerKt.composeImmediateRuntimeError("Writing to an invalid slot");
    L8:
        this.slots[dataIndexToDataAddress(this.currentSlot - 1)] = r100;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final int slotsEndAllIndex$runtime(int r100) {
        return dataIndex(this.groups, groupIndexToAddress(r100 + groupSize(r100)));
    }

    public final int slotsEndIndex$runtime(int r100) {
        return dataIndex(this.groups, groupIndexToAddress(r100 + 1));
    }

    public final int slotsStartIndex$runtime(int r100) {
        return slotIndex(this.groups, groupIndexToAddress(r100));
    }

    public final GroupSourceInformation sourceInformationOf$runtime(int r100) {
        HashMap<Anchor, GroupSourceInformation> r101 = this.sourceInformationMap;
        if (r101 == null) goto L8;
        Anchor r102 = tryAnchor$runtime(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r101.get(r102);
    L8:
        return null;
    }

    public final void startGroup(int r100) {
        Composer.Companion r101 = Composer.Companion;
        startGroup(r100, r101.getEmpty(), false, r101.getEmpty());
    }

    public final void trimTailSlots(int r100) {
        boolean r101 = false;
        if (r100 <= 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L9;
        ComposerKt.composeImmediateRuntimeError("Check failed");
    L9:
        int r103 = this.parent;
        int r104 = slotIndex(this.groups, groupIndexToAddress(r103));
        int r105 = dataIndex(this.groups, groupIndexToAddress(r103 + 1)) - r100;
        if (r105 < r104) goto L12;
        r101 = true;
    L12:
        if (r101 == true) goto L14;
        ComposerKt.composeImmediateRuntimeError("Check failed");
    L14:
        removeSlots(r105, r100, r103);
        int r106 = this.currentSlot;
        if (r106 < r104) goto L18;
        this.currentSlot = r106 - r100;
        return;
    L18:
        return;
    L5:
        r102 = false;
        goto L7
    }

    public final Anchor tryAnchor$runtime(int r100) {
        boolean r101 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r101 == true) goto L11;
        return null;
    L11:
        return SlotTableKt.access$find(this.anchors, r100, getSize$runtime());
    L5:
        if (r100 >= getSize$runtime()) goto L7;
        r101 = true;
        goto L7
    }

    public final Object update(Object r100) {
        if (this.insertCount <= 0) goto L15;
        if (this.currentSlot == this.slotsGapStart) goto L15;
        MutableIntObjectMap<MutableObjectList<Object>> r101 = this.deferredSlotWrites;
        DefaultConstructorMarker r102 = null;
        int r103 = 1;
        int r104 = 0;
        if (r101 != null) goto L9;
        r101 = new MutableIntObjectMap(r104, r103, r102);
    L9:
        this.deferredSlotWrites = r101;
        int r105 = this.parent;
        MutableObjectList<Object> r106 = r101.get(r105);
        if (r106 != null) goto L12;
        r106 = new MutableObjectList(r104, r103, r102);
        r101.set(r105, r106);
    L12:
        r106.add(r100);
        return Composer.Companion.getEmpty();
    L15:
        return rawUpdate(r100);
    }

    public final void updateAux(Object r100) {
        int r101 = groupIndexToAddress(this.currentGroup);
        boolean r102 = true;
        if ((this.groups[(r101 * 5) + 1] & 268435456) != 0) goto L6;
        r102 = false;
    L6:
        if (r102 == true) goto L8;
        ComposerKt.composeImmediateRuntimeError("Updating the data of a group that was not created with a data slot");
    L8:
        this.slots[dataIndexToDataAddress(auxIndex(this.groups, r101))] = r100;
    }

    public final void updateNode(Object r100) {
        updateNodeOfGroup(this.currentGroup, r100);
    }

    public final void updateParentNode(Object r100) {
        updateNodeOfGroup(this.parent, r100);
    }

    public final void ensureStarted(Anchor r100) {
        ensureStarted(r100.toIndexFor(this));
    }

    public final Object node(Anchor r100) {
        return node(r100.toIndexFor(this));
    }

    public final int parent(int r100) {
        return parent(this.groups, r100);
    }

    public static final /* synthetic */ boolean access$containsAnyGroupMarks(SlotWriter r100, int r101) {
        return r100.containsAnyGroupMarks(r101);
    }

    public static final /* synthetic */ int access$dataIndex(SlotWriter r100, int r101) {
        return r100.dataIndex(r101);
    }

    public static final /* synthetic */ int access$dataIndexToDataAddress(SlotWriter r100, int r101) {
        return r100.dataIndexToDataAddress(r101);
    }

    public static final /* synthetic */ int access$groupIndexToAddress(SlotWriter r100, int r101) {
        return r100.groupIndexToAddress(r101);
    }

    public static final /* synthetic */ void access$insertGroups(SlotWriter r100, int r101) {
        r100.insertGroups(r101);
    }

    public static final /* synthetic */ void access$moveGroupGapTo(SlotWriter r100, int r101) {
        r100.moveGroupGapTo(r101);
    }

    public static final /* synthetic */ void access$setCurrentGroup$p(SlotWriter r100, int r101) {
        r100.currentGroup = r101;
    }

    public static final /* synthetic */ void access$setCurrentSlot$p(SlotWriter r100, int r101) {
        r100.currentSlot = r101;
    }

    public static final /* synthetic */ void access$setNodeCount$p(SlotWriter r100, int r101) {
        r100.nodeCount = r101;
    }

    public static final /* synthetic */ void access$setSlotsGapOwner$p(SlotWriter r100, int r101) {
        r100.slotsGapOwner = r101;
    }

    public static final /* synthetic */ void access$updateContainsMark(SlotWriter r100, int r101) {
        r100.updateContainsMark(r101);
    }

    private final int auxIndex(int[] r100, int r101) {
        return dataIndex(r100, r101) + Integer.bitCount(r100[(r101 * 5) + 1] >> 29);
    }

    private final int dataIndex(int[] r100, int r101) {
        if (r101 < getCapacity()) goto L6;
        return this.slots.length - this.slotsGapLen;
    L6:
        return dataAnchorToDataIndex(r100[(r101 * 5) + 4], this.slotsGapLen, this.slots.length);
    }

    private final void groupAsString(StringBuilder r100, int r110) {
        int r101 = groupIndexToAddress(r110);
        r100.append("Group(");
        if (r110 >= 10) goto L6;
        r100.append(' ');
    L6:
        if (r110 >= 100) goto L9;
        r100.append(' ');
    L9:
        if (r110 >= 1000) goto L11;
        r100.append(' ');
    L11:
        r100.append(r110);
        if (r101 == r110) goto L14;
        r100.append("(");
        r100.append(r101);
        r100.append(")");
    L14:
        r100.append('#');
        r100.append(SlotTableKt.access$groupSize(this.groups, r101));
        r100.append('^');
        int r102 = r101 * 5;
        int r103 = r102 + 2;
        r100.append(parentAnchorToIndex(this.groups[r103]));
        r100.append(": key=");
        r100.append(this.groups[r102]);
        r100.append(", nodes=");
        int r104 = r102 + 1;
        r100.append(this.groups[r104] & RectListKt.Lower26Bits);
        r100.append(", dataAnchor=");
        r100.append(this.groups[r102 + 4]);
        r100.append(", parentAnchor=");
        r100.append(this.groups[r103]);
        if ((this.groups[r104] & 1073741824) == 0) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == false) goto L20;
        r100.append(", node=" + SlotTableKt.access$summarize(String.valueOf(this.slots[dataIndexToDataAddress(nodeIndex(this.groups, r101))]), 10));
    L20:
        int r106 = slotIndex(this.groups, r101);
        int r111 = dataIndex(this.groups, groupIndexToAddress(r110 + 1));
        if (r111 <= r106) goto L28;
        r100.append(", [");
        int r107 = r106;
    L23:
        if (r107 >= r111) goto L27;
        if (r107 == r106) goto L26;
        r100.append(", ");
    L26:
        r100.append(SlotTableKt.access$summarize(String.valueOf(this.slots[dataIndexToDataAddress(r107)]), 10));
        r107 = r107 + 1;
        goto L23
    L27:
        r100.append(']');
    L28:
        r100.append(")");
        return;
    L17:
        r105 = false;
        goto L18
    }

    private final GroupSourceInformation groupSourceInformationFor(int r100, String r101) {
        HashMap<Anchor, GroupSourceInformation> r102 = this.sourceInformationMap;
        if (r102 == null) goto L13;
        Anchor r103 = anchor(r100);
        GroupSourceInformation r104 = r102.get(r103);
        if (r104 != null) goto L16;
        r104 = new GroupSourceInformation(0, r101, 0);
        if (r101 != null) goto L11;
        int r105 = r100 + 1;
        int r106 = this.currentGroup;
    L9:
        if (r105 >= r106) goto L11;
        r104.reportGroup(this, r105);
        r105 = r105 + SlotTableKt.access$groupSize(this.groups, r105);
    L11:
        r102.put(r103, r104);
    L16:
        return r104;
    L13:
        return null;
    }

    private final void insertSlots(int r110, int r111) {
        if (r110 <= 0) goto L15;
        moveSlotGapTo(this.currentSlot, r111);
        int r112 = this.slotsGapStart;
        int r100 = this.slotsGapLen;
        if (r100 >= r110) goto L9;
        Object[] r101 = this.slots;
        int r102 = r101.length;
        int r103 = r102 - r100;
        int r104 = Math.max(Math.max(r102 * 2, r103 + r110), 32);
        Object[] r105 = new Object[r104];
        int r106 = 0;
    L6:
        if (r106 >= r104) goto L8;
        r105[r106] = null;
        r106 = r106 + 1;
        goto L6
    L8:
        int r107 = r104 - r103;
        int r108 = r100 + r112;
        System.arraycopy(r101, 0, r105, 0, r112 + 0);
        System.arraycopy(r101, r108, r105, r112 + r107, r102 - r108);
        this.slots = r105;
        r100 = r107;
    L9:
        int r109 = this.currentSlotEnd;
        if (r109 < r112) goto L12;
        this.currentSlotEnd = r109 + r110;
    L12:
        this.slotsGapStart = r112 + r110;
        this.slotsGapLen = r100 - r110;
        return;
    }

    private final void moveSlotGapTo(int r110, int r111) {
        int r100 = this.slotsGapLen;
        int r101 = this.slotsGapStart;
        int r102 = this.slotsGapOwner;
        if (r101 == r110) goto L8;
        Object[] r103 = this.slots;
        if (r110 >= r101) goto L7;
        System.arraycopy(r103, r110, r103, r110 + r100, r101 - r110);
        goto L8
    L7:
        int r104 = r101 + r100;
        System.arraycopy(r103, r104, r103, r101, (r110 + r100) - r104);
    L8:
        int r112 = Math.min(r111 + 1, getSize$runtime());
        if (r102 == r112) goto L35;
        int r105 = this.slots.length - r100;
        if (r112 >= r102) goto L23;
        int r106 = groupIndexToAddress(r112);
        int r107 = groupIndexToAddress(r102);
        int r108 = this.groupGapStart;
    L13:
        if (r106 >= r107) goto L34;
        int r109 = (r106 * 5) + 4;
        int r113 = this.groups[r109];
        if (r113 < 0) goto L17;
        boolean r114 = true;
    L18:
        if (r114 == true) goto L20;
        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a positive anchor");
    L20:
        this.groups[r109] = -((r105 - r113) + 1);
        r106 = r106 + 1;
        if (r106 != r108) goto L13;
        r106 = r106 + this.groupGapLen;
        goto L13
    L17:
        r114 = false;
    L34:
        this.slotsGapOwner = r112;
        goto L35
    L23:
        int r115 = groupIndexToAddress(r102);
        int r116 = groupIndexToAddress(r112);
    L24:
        if (r115 >= r116) goto L34;
        int r117 = (r115 * 5) + 4;
        int r118 = this.groups[r117];
        if (r118 >= 0) goto L28;
        boolean r119 = true;
    L29:
        if (r119 == true) goto L31;
        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a negative anchor");
    L31:
        this.groups[r117] = (r118 + r105) + 1;
        r115 = r115 + 1;
        if (r115 != this.groupGapStart) goto L24;
        r115 = r115 + this.groupGapLen;
        goto L24
    L28:
        r119 = false;
    L35:
        this.slotsGapStart = r110;
    }

    private final int nodeIndex(int[] r100, int r101) {
        return dataIndex(r100, r101);
    }

    private final int parent(int[] r100, int r101) {
        return parentAnchorToIndex(r100[(groupIndexToAddress(r101) * 5) + 2]);
    }

    private final int parentIndexToAnchor(int r100, int r101) {
        if (r100 >= r101) goto L5;
        return r100;
    L5:
        return -((getSize$runtime() - r100) + 2);
    }

    private final boolean removeGroups(int r100, int r101) {
        boolean r102 = false;
        if (r101 <= 0) goto L16;
        ArrayList<Anchor> r103 = this.anchors;
        moveGroupGapTo(r100);
        if ((!r103.isEmpty()) == false) goto L7;
        r102 = removeAnchors(r100, r101, this.sourceInformationMap);
    L7:
        this.groupGapStart = r100;
        this.groupGapLen += r101;
        int r104 = this.slotsGapOwner;
        if (r104 <= r100) goto L10;
        this.slotsGapOwner = Math.max(r100, r104 - r101);
    L10:
        int r105 = this.currentGroupEnd;
        if (r105 < this.groupGapStart) goto L13;
        this.currentGroupEnd = r105 - r101;
    L13:
        int r106 = this.parent;
        if (containsGroupMark(r106) == false) goto L16;
        updateContainsMark(r106);
    L16:
        return r102;
    }

    private final int slotIndex(int[] r100, int r101) {
        if (r101 < getCapacity()) goto L6;
        return this.slots.length - this.slotsGapLen;
    L6:
        return dataAnchorToDataIndex(SlotTableKt.access$slotAnchor(r100, r101), this.slotsGapLen, this.slots.length);
    }

    private final void updateAnchors(int r100, int r101) {
        int r102 = this.groupGapLen;
        int r103 = getCapacity() - r102;
        if (r100 >= r101) goto L12;
        int r104 = SlotTableKt.access$locationOf(this.anchors, r100, r103);
    L6:
        if (r104 >= this.anchors.size()) goto L18;
        Anchor r105 = (Anchor) ListProtector.get(this.anchors, r104);
        int r106 = r105.getLocation$runtime();
        if (r106 >= 0) goto L24;
        int r107 = r106 + r103;
        if (r107 >= r101) goto L25;
        r105.setLocation$runtime(r107);
        r104 = r104 + 1;
        goto L6
    L25:
        return;
    L24:
        return;
    L18:
        return;
    L12:
        int r108 = SlotTableKt.access$locationOf(this.anchors, r101, r103);
    L14:
        if (r108 >= this.anchors.size()) goto L27;
        Anchor r109 = (Anchor) ListProtector.get(this.anchors, r108);
        int r110 = r109.getLocation$runtime();
        if (r110 < 0) goto L26;
        r109.setLocation$runtime(-(r103 - r110));
        r108 = r108 + 1;
        goto L14
    L26:
        return;
    }

    /* JADX INFO: renamed from: updateContainsMarkNow-XpTMRCE, reason: not valid java name */
    private final void m4147updateContainsMarkNowXpTMRCE(int r100, MutableIntList r101) {
        int r102 = groupIndexToAddress(r100);
        boolean r103 = childContainsAnyMarks(r100);
        int[] r104 = this.groups;
        boolean r105 = true;
        if ((r104[(r102 * 5) + 1] & 67108864) == 0) goto L5;
        boolean r106 = true;
    L6:
        if (r106 != r103) goto L9;
        r105 = false;
    L9:
        if (r105 == false) goto L14;
        SlotTableKt.access$updateContainsMark(r104, r102, r103);
        int r107 = parent(r100);
        if (r107 < 0) goto L15;
        PrioritySet.m4125addimpl(r101, r107);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r106 = false;
        goto L6
    }

    private final void updateNodeOfGroup(int r100, Object r101) {
        int r102 = groupIndexToAddress(r100);
        int[] r103 = this.groups;
        boolean r104 = false;
        if (r102 < r103.length) goto L5;
    L10:
        if (r104 == true) goto L12;
        ComposerKt.composeImmediateRuntimeError("Updating the node of a group at " + r100 + " that was not created with as a node group");
    L12:
        this.slots[dataIndexToDataAddress(nodeIndex(this.groups, r102))] = r101;
        return;
    L5:
        if ((r103[(r102 * 5) + 1] & 1073741824) == 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L10;
        r104 = true;
        goto L10
    L7:
        r105 = false;
        goto L8
    }

    public final void appendSlot(Anchor r100, Object r101) {
        if (this.insertCount != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        ComposerKt.composeImmediateRuntimeError("Can only append a slot if not current inserting");
    L8:
        int r103 = this.currentSlot;
        int r104 = this.currentSlotEnd;
        int r105 = anchorIndex(r100);
        int r106 = dataIndex(this.groups, groupIndexToAddress(r105 + 1));
        this.currentSlot = r106;
        this.currentSlotEnd = r106;
        insertSlots(1, r105);
        if (r103 < r106) goto L11;
        r103 = r103 + 1;
        r104 = r104 + 1;
    L11:
        this.slots[r106] = r101;
        this.currentSlot = r103;
        this.currentSlotEnd = r104;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void forAllData(int r100, Function2<? super Integer, Object, Unit> r101) {
        int r102 = access$groupIndexToAddress(this, r100);
        int r103 = access$dataIndex(this, access$getGroups$p(this), r102);
        int r104 = access$dataIndex(this, access$getGroups$p(this), access$groupIndexToAddress(this, getCurrentGroup() + groupSize(getCurrentGroup())));
    L3:
        if (r103 >= r104) goto L5;
        r101.invoke(Integer.valueOf(r103), access$getSlots$p(this)[access$dataIndexToDataAddress(this, r103)]);
        r103 = r103 + 1;
        goto L3
    }

    public final void forAllDataInRememberOrder(int r210, Function2<? super Integer, Object, Unit> r211) {
        int r100 = parent(r210);
        int r101 = getSize$runtime();
        int r102 = groupSize(r210) + r210;
        DefaultConstructorMarker r103 = null;
        int r104 = r210;
        MutableIntSet r105 = null;
        MutableIntList r106 = null;
    L3:
        if (r104 >= r102) goto L47;
        int r110 = dataIndex(r104);
        int r111 = r104 + 1;
        int r112 = dataIndex(r111);
    L5:
        int r113 = 0;
        if (r110 >= r112) goto L21;
        Object r114 = this.slots[dataIndexToDataAddress(r110)];
        if ((r114 instanceof RememberObserverHolder) == false) goto L19;
        Anchor r115 = ((RememberObserverHolder) r114).getAfter();
        if (r115 == null) goto L19;
        if (r115.getValid() == false) goto L19;
        int r116 = anchorIndex(r115);
        if (r105 != null) goto L16;
        r105 = IntSetKt.mutableIntSetOf();
    L16:
        if (r106 != null) goto L18;
        r106 = new MutableIntList(r113, 1, r103);
    L18:
        r105.add(r116);
        r106.add(r116);
        r106.add(r110);
    L20:
        r110 = r110 + 1;
    L19:
        r211.invoke(Integer.valueOf(r110), r114);
        goto L20
    L21:
        if (r111 >= r101) goto L23;
        int r117 = parent(r111);
    L24:
        if (r117 == r104) goto L45;
    L25:
        if (r106 == null) goto L41;
        if (r105 == null) goto L41;
        if (r105.remove(r104) == false) goto L41;
        int r118 = r106._size;
        int r119 = r118 / 2;
        int r107 = 0;
        int r120 = 0;
    L30:
        if (r120 >= r119) goto L38;
        int r121 = r120 * 2;
        int r122 = r101;
        int r108 = r106.get(r121);
        if (r108 != r104) goto L34;
        int r109 = r106.get(r121 + 1);
        r211.invoke(Integer.valueOf(r109), this.slots[dataIndexToDataAddress(r109)]);
    L37:
        r120 = r120 + 1;
        r211 = r211;
        r101 = r122;
        goto L30
    L34:
        if (r121 == r107) goto L36;
        int r123 = r107 + 1;
        r106.set(r107, r108);
        r107 = r123 + 1;
        r106.set(r123, r106.get(r121 + 1));
        goto L37
    L36:
        r107 = r107 + 2;
        goto L37
    L38:
        int r124 = r101;
        if (r107 == r118) goto L42;
        r106.removeRange(r107, r118);
    L42:
        if (r104 == r210) goto L46;
        if (r100 == r117) goto L46;
        r104 = r100;
        r101 = r124;
        r100 = parent(r100);
        r211 = r211;
    L46:
        r100 = r117;
        r104 = r111;
        r101 = r124;
        r103 = null;
    L41:
        r124 = r101;
        goto L42
    L45:
        r124 = r101;
        goto L46
    L23:
        r117 = -1;
        goto L24
    }

    public final boolean inGroup(Anchor r100, Anchor r101) {
        int r102 = anchorIndex(r100);
        int r103 = SlotTableKt.access$groupSize(this.groups, r102) + r102;
        int r104 = r101.getLocation$runtime();
        if (r102 > r104) goto L7;
        if (r104 >= r103) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }

    public final boolean indexInGroup(int r100, int r101) {
        if (r101 != this.parent) goto L6;
        int r102 = this.currentGroupEnd;
    L13:
        if (r100 <= r101) goto L17;
        if (r100 >= r102) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L6:
        if (r101 <= this.startStack.peekOr(0)) goto L9;
        int r103 = groupSize(r101);
    L8:
        r102 = r103 + r101;
        goto L13
    L9:
        int r104 = this.startStack.indexOf(r101);
        if (r104 >= 0) goto L12;
        r103 = groupSize(r101);
        goto L8
    L12:
        r102 = (getCapacity() - this.groupGapLen) - this.endStack.peek(r104);
        goto L13
    }

    public final void recordGrouplessCallSourceInformationStart(int r100, String r101) {
        if (this.insertCount <= 0) goto L11;
        MutableIntObjectMap<MutableIntSet> r102 = this.calledByMap;
        if (r102 == null) goto L7;
        SlotTableKt.access$add(r102, r100, groupKey(this.parent));
    L7:
        GroupSourceInformation r103 = groupSourceInformationFor(this.parent, null);
        if (r103 == null) goto L12;
        r103.startGrouplessCall(r100, r101, getCurrentGroupSlotIndex());
        return;
    L12:
        return;
    }

    public final Object set(int r100, Object r101) {
        return set(getCurrentGroup(), r100, r101);
    }

    public final Object slot(int r100, int r101) {
        int r102 = groupIndexToAddress(r100);
        int r103 = slotIndex(this.groups, r102);
        boolean r104 = true;
        int r105 = dataIndex(this.groups, groupIndexToAddress(r100 + 1));
        int r106 = r101 + r103;
        if (r103 > r106) goto L6;
        if (r106 >= r105) goto L6;
    L7:
        if (r104 == false) goto L9;
        int r107 = dataIndexToDataAddress(r106);
        return this.slots[r107];
    L9:
        return Composer.Companion.getEmpty();
    L6:
        r104 = false;
        goto L7
    }

    public final int slotIndexOfGroupSlotIndex(int r100, int r101) {
        int r102 = slotIndex(this.groups, groupIndexToAddress(r100));
        int r103 = dataIndex(this.groups, groupIndexToAddress(r100 + 1));
        int r104 = r102 + r101;
        if (r104 < r102) goto L6;
        if (r104 >= r103) goto L6;
        boolean r105 = true;
    L7:
        if (r105 == true) goto L9;
        ComposerKt.composeImmediateRuntimeError("Write to an invalid slot index " + r101 + " for group " + r100);
    L9:
        return r104;
    L6:
        r105 = false;
        goto L7
    }

    public final void startData(int r100, Object r101) {
        startGroup(r100, Composer.Companion.getEmpty(), false, r101);
    }

    public final void startGroup(int r100, Object r101) {
        startGroup(r100, r101, false, Composer.Companion.getEmpty());
    }

    public final void startNode(int r100, Object r101) {
        startGroup(r100, r101, true, Composer.Companion.getEmpty());
    }

    public final void updateNode(Anchor r100, Object r101) {
        updateNodeOfGroup(r100.toIndexFor(this), r101);
    }

    public final Object slot(Anchor r100, int r101) {
        return slot(anchorIndex(r100), r101);
    }

    public static final /* synthetic */ int access$dataIndex(SlotWriter r100, int[] r101, int r102) {
        return r100.dataIndex(r101, r102);
    }

    public static final /* synthetic */ void access$insertSlots(SlotWriter r100, int r101, int r102) {
        r100.insertSlots(r101, r102);
    }

    public static final /* synthetic */ void access$moveSlotGapTo(SlotWriter r100, int r101, int r102) {
        r100.moveSlotGapTo(r101, r102);
    }

    public static final /* synthetic */ boolean access$removeGroups(SlotWriter r100, int r101, int r102) {
        return r100.removeGroups(r101, r102);
    }

    private final void fixParentAnchorsFor(int r100, int r101, int r102) {
        int r103 = parentIndexToAnchor(r100, this.groupGapStart);
    L3:
        if (r102 >= r101) goto L5;
        this.groups[(groupIndexToAddress(r102) * 5) + 2] = r103;
        int r104 = SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(r102)) + r102;
        fixParentAnchorsFor(r102, r104, r102 + 1);
        r102 = r104;
        goto L3
    }

    private final void moveAnchors(int r100, int r101, int r102) {
        int r103 = r102 + r100;
        int r104 = getSize$runtime();
        int r105 = SlotTableKt.access$locationOf(this.anchors, r100, r104);
        ArrayList r106 = new ArrayList();
        if (r105 >= 0) goto L5;
    L10:
        int r107 = r101 - r100;
        int r108 = r106.size();
        int r109 = 0;
    L11:
        if (r109 >= r108) goto L17;
        Anchor r110 = (Anchor) ListProtector.get(r106, r109);
        int r111 = anchorIndex(r110) + r107;
        if (r111 < this.groupGapStart) goto L15;
        r110.setLocation$runtime(-(r104 - r111));
    L16:
        int r112 = SlotTableKt.access$locationOf(this.anchors, r111, r104);
        ListProtector.add(this.anchors, r112, r110);
        r109 = r109 + 1;
        goto L11
    L15:
        r110.setLocation$runtime(r111);
        goto L16
    L17:
        return;
    L5:
        if (r105 >= this.anchors.size()) goto L10;
        Anchor r113 = (Anchor) ListProtector.get(this.anchors, r105);
        int r114 = anchorIndex(r113);
        if (r114 < r100) goto L10;
        if (r114 >= r103) goto L10;
        r106.add(r113);
        Anchor r115 = (Anchor) ListProtector.remove(this.anchors, r105);
        goto L5
    }

    private final boolean removeAnchors(int r100, int r101, HashMap<Anchor, GroupSourceInformation> r102) {
        int r103 = r101 + r100;
        int r104 = SlotTableKt.access$locationOf(this.anchors, r103, getCapacity() - this.groupGapLen);
        if (r104 < this.anchors.size()) goto L5;
        r104 = r104 - 1;
    L5:
        int r105 = r104 + 1;
        boolean r106 = false;
        int r107 = 0;
    L6:
        if (r104 < 0) goto L17;
        Anchor r108 = (Anchor) ListProtector.get(this.anchors, r104);
        int r109 = anchorIndex(r108);
        if (r109 < r100) goto L17;
        if (r109 >= r103) goto L16;
        r108.setLocation$runtime(Integer.MIN_VALUE);
        if (r102 == null) goto L13;
        GroupSourceInformation r110 = r102.remove(r108);
    L13:
        if (r107 != 0) goto L15;
        r107 = r104 + 1;
    L15:
        r105 = r104;
    L16:
        r104 = r104 - 1;
    L17:
        if (r105 >= r107) goto L19;
        r106 = true;
    L19:
        if (r106 == false) goto L21;
        this.anchors.subList(r105, r107).clear();
    L21:
        return r106;
    }

    private final void removeSlots(int r100, int r101, int r102) {
        if (r101 <= 0) goto L7;
        int r103 = this.slotsGapLen;
        int r104 = r100 + r101;
        moveSlotGapTo(r104, r102);
        this.slotsGapStart = r100;
        this.slotsGapLen = r103 + r101;
        ArraysKt.fill(this.slots, null, r100, r104);
        int r105 = this.currentSlotEnd;
        if (r105 < r100) goto L8;
        this.currentSlotEnd = r105 - r101;
        return;
    L8:
        return;
    }

    private final void updateDataIndex(int[] r100, int r101, int r102) {
        int r103 = (r101 * 5) + 4;
        r100[r103] = dataIndexToDataAnchor(r102, this.slotsGapStart, this.slotsGapLen, this.slots.length);
    }

    public final void forEachTailSlot(int r100, int r101, Function2<? super Integer, Object, Unit> r102) {
        int r103 = slotsStartIndex$runtime(r100);
        int r104 = slotsEndIndex$runtime(r100);
        int r105 = Math.max(r103, r104 - r101);
    L3:
        if (r105 >= r104) goto L5;
        r102.invoke(Integer.valueOf(r105), access$getSlots$p(this)[access$dataIndexToDataAddress(this, r105)]);
        r105 = r105 + 1;
        goto L3
    }

    public final List<Anchor> moveFrom(SlotTable r110, int r111, boolean r112) {
        if (this.insertCount <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        ComposerKt.composeImmediateRuntimeError("Check failed");
    L8:
        if (r111 == 0) goto L10;
    L17:
        SlotWriter r113 = r110.openWriter();
        List<Anchor> r114 = Companion.access$moveGroup(Companion, r113, r111, this, true, true, r112);     // Catch: Throwable -> L21
        r113.close(true);
        return r114;
    L21:
        th = move-exception;
        r113.close(false);
        throw th;
    L10:
        if (this.currentGroup != 0) goto L17;
        if (this.table.getGroupsSize() != 0) goto L17;
        if (SlotTableKt.access$groupSize(r110.getGroups(), r111) != r110.getGroupsSize()) goto L17;
        int[] r101 = this.groups;
        Object[] r102 = this.slots;
        ArrayList<Anchor> r103 = this.anchors;
        HashMap<Anchor, GroupSourceInformation> r115 = this.sourceInformationMap;
        MutableIntObjectMap<MutableIntSet> r116 = this.calledByMap;
        int[] r117 = r110.getGroups();
        int r118 = r110.getGroupsSize();
        Object[] r104 = r110.getSlots();
        int r105 = r110.getSlotsSize();
        HashMap<Anchor, GroupSourceInformation> r106 = r110.getSourceInformationMap$runtime();
        MutableIntObjectMap<MutableIntSet> r107 = r110.getCalledByMap$runtime();
        this.groups = r117;
        this.slots = r104;
        this.anchors = r110.getAnchors$runtime();
        this.groupGapStart = r118;
        this.groupGapLen = (r117.length / 5) - r118;
        this.slotsGapStart = r105;
        this.slotsGapLen = r104.length - r105;
        this.slotsGapOwner = r118;
        this.sourceInformationMap = r106;
        this.calledByMap = r107;
        r110.setTo$runtime(r101, 0, r102, 0, r103, r115, r116);
        return this.anchors;
    L5:
        r100 = false;
        goto L6
    }

    public final List<Anchor> moveIntoGroupFrom(int r110, SlotTable r111, int r112) {
        if (this.insertCount <= 0) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == true) goto L10;
        ComposerKt.composeImmediateRuntimeError("Check failed");
    L10:
        int r101 = this.currentGroup;
        int r113 = this.currentSlot;
        int r114 = this.currentSlotEnd;
        advanceBy(r110);
        startGroup();
        beginInsert();
        SlotWriter r115 = r111.openWriter();
        List<Anchor> r102 = Companion.moveGroup$default(Companion, r115, r112, this, false, true, false, 32, null);     // Catch: Throwable -> L14
        r115.close(true);
        endInsert();
        endGroup();
        this.currentGroup = r101;
        this.currentSlot = r113;
        this.currentSlotEnd = r114;
        return r102;
    L14:
        th = move-exception;
        r115.close(false);
        throw th;
    L5:
        if (groupSize(this.currentGroup + r110) != 1) goto L7;
        r100 = true;
        goto L8
    }

    public final List<Anchor> moveTo(Anchor r110, int r111, SlotWriter r210) {
        boolean r112 = true;
        if (r210.insertCount <= 0) goto L5;
        boolean r100 = true;
    L7:
        if (r100 == true) goto L10;
        ComposerKt.composeImmediateRuntimeError("Check failed");
    L10:
        if (this.insertCount != 0) goto L12;
        boolean r101 = true;
    L13:
        if (r101 == true) goto L16;
        ComposerKt.composeImmediateRuntimeError("Check failed");
    L16:
        if (r110.getValid() == true) goto L18;
        ComposerKt.composeImmediateRuntimeError("Check failed");
    L18:
        int r102 = anchorIndex(r110) + r111;
        int r113 = this.currentGroup;
        if (r113 <= r102) goto L21;
    L23:
        boolean r103 = false;
    L24:
        if (r103 == true) goto L26;
        ComposerKt.composeImmediateRuntimeError("Check failed");
    L26:
        int r114 = parent(r102);
        int r115 = groupSize(r102);
        if (isNode(r102) == false) goto L29;
        int r104 = 1;
    L30:
        int r116 = r104;
        List<Anchor> r105 = Companion.moveGroup$default(Companion, this, r102, r210, false, false, false, 32, null);
        updateContainsMark(r114);
        if (r116 <= 0) goto L33;
        boolean r106 = true;
    L34:
        if (r114 < r113) goto L45;
        int r107 = groupIndexToAddress(r114);
        int[] r108 = this.groups;
        SlotTableKt.access$updateGroupSize(r108, r107, SlotTableKt.access$groupSize(r108, r107) - r115);
        if (r106 == false) goto L44;
        int[] r109 = this.groups;
        int r117 = r109[(r107 * 5) + 1];
        if ((1073741824 & r117) == 0) goto L40;
        boolean r118 = true;
    L41:
        if (r118 == false) goto L43;
        r106 = false;
        goto L44
    L43:
        SlotTableKt.access$updateNodeCount(r109, r107, (r117 & RectListKt.Lower26Bits) - r116);
        goto L44
    L40:
        r118 = false;
    L44:
        r114 = parent(r114);
        goto L34
    L45:
        if (r106 == true) goto L47;
    L53:
        return r105;
    L47:
        if (this.nodeCount >= r116) goto L50;
        r112 = false;
    L50:
        if (r112 == true) goto L52;
        ComposerKt.composeImmediateRuntimeError("Check failed");
    L52:
        this.nodeCount -= r116;
        goto L53
    L33:
        r106 = false;
        goto L34
    L29:
        r104 = nodeCount(r102);
        goto L30
    L21:
        if (r102 >= this.currentGroupEnd) goto L23;
        r103 = true;
        goto L24
    L12:
        r101 = false;
        goto L13
    L5:
        r100 = false;
        goto L7
    }

    public final Object set(int r100, int r101, Object r102) {
        int r103 = dataIndexToDataAddress(slotIndexOfGroupSlotIndex(r100, r101));
        Object[] r104 = this.slots;
        Object r105 = r104[r103];
        r104[r103] = r102;
        return r105;
    }

    public final void startData(int r100, Object r101, Object r102) {
        startGroup(r100, r101, false, r102);
    }

    public final void startNode(int r100, Object r101, Object r102) {
        startGroup(r100, r101, true, r102);
    }

    public final void traverseGroupAndChildren(int r100, Function1<? super Integer, Unit> r110, Function1<? super Integer, Unit> r111) {
        int r101 = parent(r100);
        int r102 = getSize$runtime();
        int r103 = groupSize(r100) + r100;
        int r104 = r100;
    L3:
        if (r104 >= r103) goto L14;
        r110.invoke(Integer.valueOf(r104));
        int r105 = r104 + 1;
        if (r105 >= r102) goto L7;
        int r106 = parent(r105);
    L8:
        if (r106 == r104) goto L13;
    L9:
        r111.invoke(Integer.valueOf(r104));
        if (r104 == r100) goto L13;
        if (r101 == r106) goto L13;
        r104 = r101;
        r101 = parent(r101);
    L13:
        r104 = r105;
        r101 = r106;
        goto L3
    L7:
        r106 = -1;
        goto L8
    }

    public static final /* synthetic */ void access$removeSlots(SlotWriter r100, int r101, int r102, int r103) {
        r100.removeSlots(r101, r102, r103);
    }

    public static /* synthetic */ Anchor anchor$default(SlotWriter r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.currentGroup;
    L6:
        return r100.anchor(r101);
    }

    public static /* synthetic */ void markGroup$default(SlotWriter r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = r100.parent;
    L5:
        r100.markGroup(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void startGroup(int r110, Object r111, boolean r112, Object r210) {
        int r113 = this.parent;
        if (this.insertCount <= 0) goto L5;
        boolean r100 = true;
    L6:
        this.nodeCountStack.push(this.nodeCount);
        if (r100 == false) goto L37;
        int r114 = this.currentGroup;
        int r101 = dataIndex(this.groups, groupIndexToAddress(r114));
        insertGroups(1);
        this.currentSlot = r101;
        this.currentSlotEnd = r101;
        int r102 = groupIndexToAddress(r114);
        Composer.Companion r103 = Composer.Companion;
        if (r111 == r103.getEmpty()) goto L11;
        int r115 = 1;
    L12:
        if (r112 == false) goto L14;
    L16:
        int r116 = 0;
    L17:
        int r104 = this.slotsGapLen;
        int r105 = dataIndexToDataAnchor(r101, this.slotsGapStart, r104, this.slots.length);
        if (r105 >= 0) goto L20;
    L22:
        int r106 = r105;
        boolean r107 = r115;
        boolean r108 = r116;
        SlotTableKt.access$initGroup(this.groups, r102, r110, r112, r107, r108, this.parent, r106);
        int r109 = ((r112 ? 1 : 0) + r115) + r116;
        if (r109 <= 0) goto L32;
        insertSlots(r109, r114);
        Object[] r117 = this.slots;
        int r118 = this.currentSlot;
        if (r112 == false) goto L27;
        r117[r118] = r210;
        r118 = r118 + 1;
    L27:
        if (r115 == 0) goto L29;
        r117[r118] = r111;
        r118 = r118 + 1;
    L29:
        if (r116 == 0) goto L31;
        r117[r118] = r210;
        r118 = r118 + 1;
    L31:
        this.currentSlot = r118;
    L32:
        this.nodeCount = 0;
        int r119 = r114 + 1;
        this.parent = r114;
        this.currentGroup = r119;
        if (r113 < 0) goto L43;
        GroupSourceInformation r120 = sourceInformationOf$runtime(r113);
        if (r120 == null) goto L43;
        r120.reportGroup(this, r114);
    L43:
        this.currentGroupEnd = r119;
        return;
    L20:
        if (this.slotsGapOwner >= r114) goto L22;
        r105 = -(((this.slots.length - this.slotsGapLen) - r105) + 1);
        goto L22
    L14:
        if (r210 == r103.getEmpty()) goto L16;
        r116 = 1;
        goto L17
    L11:
        r115 = 0;
        goto L12
    L37:
        this.startStack.push(r113);
        saveCurrentGroupEnd();
        int r121 = this.currentGroup;
        int r122 = groupIndexToAddress(r121);
        if (Intrinsics.areEqual(r210, Composer.Companion.getEmpty()) == true) goto L42;
        if (r112 == false) goto L41;
        updateNode(r210);
        goto L42
    L41:
        updateAux(r210);
    L42:
        this.currentSlot = slotIndex(this.groups, r122);
        this.currentSlotEnd = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
        int[] r123 = this.groups;
        this.nodeCount = r123[(r122 * 5) + 1] & RectListKt.Lower26Bits;
        this.parent = r121;
        this.currentGroup = r121 + 1;
        r119 = r121 + SlotTableKt.access$groupSize(r123, r122);
        goto L43
    L5:
        r100 = false;
        goto L6
    }

    public static final /* synthetic */ int access$dataIndexToDataAnchor(SlotWriter r100, int r101, int r102, int r103, int r104) {
        return r100.dataIndexToDataAnchor(r101, r102, r103, r104);
    }

    public static /* synthetic */ List moveFrom$default(SlotWriter r100, SlotTable r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = true;
    L6:
        return r100.moveFrom(r101, r102, r103);
    }
}
