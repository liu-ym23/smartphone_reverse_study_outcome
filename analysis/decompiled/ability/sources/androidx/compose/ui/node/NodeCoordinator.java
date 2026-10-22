package androidx.compose.ui.node;

import C7.r;
import S7.a;
import S7.k;
import S7.n;
import androidx.collection.MutableObjectIntMap;
import androidx.compose.foundation.b;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.FrameRateCategory;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.input.pointer.MatrixPositionCalculator;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import com.stepos.aiengine.data.InpaintImageAction;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000¤\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\bN\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b!\u0018\u0000 Ù\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004Ú\u0002Ù\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ4\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012J:\u0010\u0011\u001a\u00020\u000f\"\u0006\b\u0000\u0010\u0013\u0018\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\rH\u0086\b¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\u000fH\u0010¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u000fH&¢\u0006\u0004\b \u0010\u001eJ\u001f\u0010#\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0014¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020\u000fH\u0000¢\u0006\u0004\b%\u0010\u001eJ(\u0010-\u001a\u00020*2\u0006\u0010(\u001a\u00020'2\u000e\b\u0004\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020*0)H\u0084\b¢\u0006\u0004\b+\u0010,J\r\u0010.\u001a\u00020\u000f¢\u0006\u0004\b.\u0010\u001eJ\r\u0010/\u001a\u00020\u000f¢\u0006\u0004\b/\u0010\u001eJ5\u00108\u001a\u00020\u000f2\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u0002022\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0014¢\u0006\u0004\b6\u00107J'\u00108\u001a\u00020\u000f2\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u0002022\u0006\u0010:\u001a\u000209H\u0014¢\u0006\u0004\b6\u0010;J\r\u0010<\u001a\u00020\u000f¢\u0006\u0004\b<\u0010\u001eJ=\u0010?\u001a\u00020\u000f2\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u0002022\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r2\b\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b=\u0010>J\u001f\u0010C\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020@2\b\u0010B\u001a\u0004\u0018\u000109¢\u0006\u0004\bC\u0010DJ!\u0010E\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020@2\b\u0010B\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\bE\u0010DJ\r\u0010F\u001a\u00020\u000f¢\u0006\u0004\bF\u0010\u001eJ-\u0010H\u001a\u00020\u000f2\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r2\b\b\u0002\u0010G\u001a\u00020\u000b¢\u0006\u0004\bH\u0010IJ5\u0010U\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020J2\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N2\u0006\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020\u000b¢\u0006\u0004\bS\u0010TJ7\u0010W\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020J2\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N2\u0006\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020\u000bH\u0016¢\u0006\u0004\bV\u0010TJ\r\u0010Y\u001a\u00020X¢\u0006\u0004\bY\u0010ZJ\u0017\u0010^\u001a\u00020L2\u0006\u0010[\u001a\u00020LH\u0016¢\u0006\u0004\b\\\u0010]J\u0017\u0010a\u001a\u00020L2\u0006\u0010_\u001a\u00020LH\u0016¢\u0006\u0004\b`\u0010]J\u0017\u0010d\u001a\u00020L2\u0006\u0010b\u001a\u00020LH\u0016¢\u0006\u0004\bc\u0010]J\u0017\u0010f\u001a\u00020L2\u0006\u0010_\u001a\u00020LH\u0016¢\u0006\u0004\be\u0010]J\u001f\u0010k\u001a\u00020L2\u0006\u0010g\u001a\u00020\u00032\u0006\u0010h\u001a\u00020LH\u0016¢\u0006\u0004\bi\u0010jJ'\u0010k\u001a\u00020L2\u0006\u0010g\u001a\u00020\u00032\u0006\u0010h\u001a\u00020L2\u0006\u0010l\u001a\u00020\u000bH\u0016¢\u0006\u0004\bm\u0010nJ\u001f\u0010s\u001a\u00020\u000f2\u0006\u0010g\u001a\u00020\u00032\u0006\u0010p\u001a\u00020oH\u0016¢\u0006\u0004\bq\u0010rJ\u0017\u0010v\u001a\u00020\u000f2\u0006\u0010p\u001a\u00020oH\u0016¢\u0006\u0004\bt\u0010uJ\u001f\u0010x\u001a\u00020X2\u0006\u0010g\u001a\u00020\u00032\u0006\u0010w\u001a\u00020\u000bH\u0016¢\u0006\u0004\bx\u0010yJ\u0017\u0010{\u001a\u00020L2\u0006\u0010_\u001a\u00020LH\u0016¢\u0006\u0004\bz\u0010]J,\u0010|\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020@2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u000f0\rH\u0084\b¢\u0006\u0004\b|\u0010}J\"\u0010\u0080\u0001\u001a\u00020L2\u0006\u00101\u001a\u00020L2\b\b\u0002\u0010l\u001a\u00020\u000bH\u0016¢\u0006\u0004\b~\u0010\u007fJ#\u0010\u0082\u0001\u001a\u00020L2\u0006\u00101\u001a\u00020L2\b\b\u0002\u0010l\u001a\u00020\u000bH\u0016¢\u0006\u0005\b\u0081\u0001\u0010\u007fJ$\u0010\u0085\u0001\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020@2\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001H\u0004¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u000f\u0010\u0087\u0001\u001a\u00020\u000f¢\u0006\u0005\b\u0087\u0001\u0010\u001eJ\u000f\u0010\u0088\u0001\u001a\u00020\u000f¢\u0006\u0005\b\u0088\u0001\u0010\u001eJ/\u0010\u008e\u0001\u001a\u00020\u000f2\b\u0010\u008a\u0001\u001a\u00030\u0089\u00012\u0006\u0010w\u001a\u00020\u000b2\t\b\u0002\u0010\u008b\u0001\u001a\u00020\u000bH\u0000¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u001a\u0010\u0091\u0001\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020LH\u0004¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u001a\u0010\u0093\u0001\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020LH\u0004¢\u0006\u0006\b\u0092\u0001\u0010\u0090\u0001J\u0011\u0010\u0094\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\b\u0094\u0001\u0010\u001eJ\u0011\u0010\u0095\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\b\u0095\u0001\u0010\u001eJ\u001b\u0010\u0099\u0001\u001a\u00020\u00002\u0007\u0010\u0096\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u000f\u0010\u009a\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u009a\u0001\u0010\u001cJ\u001c\u0010\u009e\u0001\u001a\u00030\u009b\u00012\b\u0010\u009c\u0001\u001a\u00030\u009b\u0001H\u0004¢\u0006\u0005\b\u009d\u0001\u0010]J$\u0010¡\u0001\u001a\u0002022\u0006\u0010M\u001a\u00020L2\b\u0010\u009c\u0001\u001a\u00030\u009b\u0001H\u0004¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u001c\u0010¢\u0001\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u001e\u0010¦\u0001\u001a\u00020\u000b2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0002¢\u0006\u0006\b¤\u0001\u0010¥\u0001JB\u0010©\u0001\u001a\u00020\u000f2\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u0002022\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r2\t\u0010§\u0001\u001a\u0004\u0018\u000109H\u0002¢\u0006\u0005\b¨\u0001\u0010>J#\u0010ª\u0001\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020@2\b\u0010B\u001a\u0004\u0018\u000109H\u0002¢\u0006\u0005\bª\u0001\u0010DJ\u001d\u0010¬\u0001\u001a\u00020\u000b2\t\b\u0002\u0010«\u0001\u001a\u00020\u000bH\u0002¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001J@\u0010°\u0001\u001a\u00020\u000f*\u0004\u0018\u00010\u000e2\u0006\u0010K\u001a\u00020J2\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N2\u0006\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020\u000bH\u0002¢\u0006\u0006\b®\u0001\u0010¯\u0001JR\u0010µ\u0001\u001a\u00020\u000f*\u0004\u0018\u00010\u000e2\u0006\u0010K\u001a\u00020J2\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N2\u0006\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020\u000b2\u0007\u0010±\u0001\u001a\u0002022\u0007\u0010²\u0001\u001a\u00020\u000bH\u0002¢\u0006\u0006\b³\u0001\u0010´\u0001JI\u0010¸\u0001\u001a\u00020\u000f*\u0004\u0018\u00010\u000e2\u0006\u0010K\u001a\u00020J2\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N2\u0006\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020\u000b2\u0007\u0010±\u0001\u001a\u000202H\u0002¢\u0006\u0006\b¶\u0001\u0010·\u0001JI\u0010º\u0001\u001a\u00020\u000f*\u0004\u0018\u00010\u000e2\u0006\u0010K\u001a\u00020J2\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N2\u0006\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020\u000b2\u0007\u0010±\u0001\u001a\u000202H\u0002¢\u0006\u0006\b¹\u0001\u0010·\u0001J(\u0010½\u0001\u001a\u00020\u000b*\u0004\u0018\u00010\u000e2\u0006\u0010M\u001a\u00020L2\u0006\u0010Q\u001a\u00020PH\u0002¢\u0006\u0006\b»\u0001\u0010¼\u0001J\u0016\u0010¾\u0001\u001a\u00020\u0000*\u00020\u0003H\u0002¢\u0006\u0006\b¾\u0001\u0010¿\u0001J#\u0010Ã\u0001\u001a\u00020\u000f2\u0007\u0010À\u0001\u001a\u00020\u00002\u0006\u0010p\u001a\u00020oH\u0002¢\u0006\u0006\bÁ\u0001\u0010Â\u0001J#\u0010Å\u0001\u001a\u00020\u000f2\u0007\u0010À\u0001\u001a\u00020\u00002\u0006\u0010p\u001a\u00020oH\u0002¢\u0006\u0006\bÄ\u0001\u0010Â\u0001J,\u0010É\u0001\u001a\u00020L2\u0007\u0010À\u0001\u001a\u00020\u00002\u0007\u0010Æ\u0001\u001a\u00020L2\u0006\u0010l\u001a\u00020\u000bH\u0002¢\u0006\u0006\bÇ\u0001\u0010È\u0001J-\u0010É\u0001\u001a\u00020\u000f2\u0007\u0010À\u0001\u001a\u00020\u00002\b\u0010Ê\u0001\u001a\u00030\u0089\u00012\u0006\u0010w\u001a\u00020\u000bH\u0002¢\u0006\u0006\bÉ\u0001\u0010Ë\u0001J$\u0010Ì\u0001\u001a\u00020\u000f2\b\u0010\u008a\u0001\u001a\u00030\u0089\u00012\u0006\u0010w\u001a\u00020\u000bH\u0002¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J\u0019\u0010Ï\u0001\u001a\u00020L2\u0006\u0010M\u001a\u00020LH\u0002¢\u0006\u0005\bÎ\u0001\u0010]R\u001d\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\u0006\u0010Ð\u0001\u001a\u0006\bÑ\u0001\u0010Ò\u0001R(\u0010Ó\u0001\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\bÓ\u0001\u0010Ô\u0001\u001a\u0005\bÕ\u0001\u0010\u001c\"\u0006\bÖ\u0001\u0010×\u0001R(\u0010Ø\u0001\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\bØ\u0001\u0010Ô\u0001\u001a\u0005\bÙ\u0001\u0010\u001c\"\u0006\bÚ\u0001\u0010×\u0001R+\u0010Û\u0001\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÛ\u0001\u0010Ü\u0001\u001a\u0006\bÝ\u0001\u0010Þ\u0001\"\u0006\bß\u0001\u0010à\u0001R+\u0010á\u0001\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bá\u0001\u0010Ü\u0001\u001a\u0006\bâ\u0001\u0010Þ\u0001\"\u0006\bã\u0001\u0010à\u0001R\u0019\u0010ä\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0001\u0010Ô\u0001R\u0019\u0010å\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010Ô\u0001RD\u00105\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r2\u0015\u0010æ\u0001\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r8\u0004@BX\u0084\u000e¢\u0006\u000f\n\u0005\b5\u0010ç\u0001\u001a\u0006\bè\u0001\u0010é\u0001R\u001a\u0010ë\u0001\u001a\u00030ê\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bë\u0001\u0010ì\u0001R\u001a\u0010î\u0001\u001a\u00030í\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bî\u0001\u0010ï\u0001R\u0019\u0010ð\u0001\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bð\u0001\u0010ñ\u0001R\u001c\u0010ó\u0001\u001a\u0005\u0018\u00010ò\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bó\u0001\u0010ô\u0001R#\u0010÷\u0001\u001a\f\u0012\u0005\u0012\u00030ö\u0001\u0018\u00010õ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b÷\u0001\u0010ø\u0001R0\u00101\u001a\u0002002\u0007\u0010æ\u0001\u001a\u0002008\u0016@TX\u0096\u000e¢\u0006\u0017\n\u0005\b1\u0010ù\u0001\u001a\u0006\bú\u0001\u0010û\u0001\"\u0006\bü\u0001\u0010ý\u0001R0\u00103\u001a\u0002022\u0007\u0010æ\u0001\u001a\u0002028\u0006@DX\u0086\u000e¢\u0006\u0017\n\u0005\b3\u0010ñ\u0001\u001a\u0006\bþ\u0001\u0010ÿ\u0001\"\u0006\b\u0080\u0002\u0010\u0081\u0002R\u001c\u0010\u0082\u0002\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0002\u0010\u0083\u0002R\u001c\u0010\u0085\u0002\u001a\u0005\u0018\u00010\u0084\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0002\u0010\u0086\u0002R\u001b\u0010\u0087\u0002\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0002\u0010\u0088\u0002R\u001b\u0010\u0089\u0002\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0002\u0010\u008a\u0002R0\u0010\u008c\u0002\u001a\u0019\u0012\u0004\u0012\u00020@\u0012\u0006\u0012\u0004\u0018\u000109\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u008b\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0002\u0010\u008d\u0002R\u001d\u0010\u008e\u0002\u001a\b\u0012\u0004\u0012\u00020\u000f0)8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0002\u0010\u008f\u0002R)\u0010\u0090\u0002\u001a\u00020\u000b2\u0007\u0010æ\u0001\u001a\u00020\u000b8\u0000@BX\u0080\u000e¢\u0006\u000f\n\u0006\b\u0090\u0002\u0010Ô\u0001\u001a\u0005\b\u0091\u0002\u0010\u001cR.\u0010:\u001a\u0005\u0018\u00010\u0092\u00022\n\u0010æ\u0001\u001a\u0005\u0018\u00010\u0092\u00028\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\b:\u0010\u0093\u0002\u001a\u0006\b\u0094\u0002\u0010\u0095\u0002R\u001b\u0010§\u0001\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010\u0088\u0002R\u0017\u0010\u0098\u0002\u001a\u00020\u000e8&X¦\u0004¢\u0006\b\u001a\u0006\b\u0096\u0002\u0010\u0097\u0002R\u0018\u0010\u009b\u0002\u001a\u00030í\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0099\u0002\u0010\u009a\u0002R\u0017\u0010\u009d\u0002\u001a\u0002028VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009c\u0002\u0010ÿ\u0001R\u0017\u0010\u009f\u0002\u001a\u0002028VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009e\u0002\u0010ÿ\u0001R\u0019\u0010¢\u0002\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b \u0002\u0010¡\u0002R\u0017\u0010¥\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b£\u0002\u0010¤\u0002R\u0016\u0010§\u0002\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¦\u0002\u0010\u001cR\u0015\u0010ª\u0002\u001a\u00030¨\u00028F¢\u0006\b\u001a\u0006\b©\u0002\u0010û\u0001R\u0018\u0010®\u0002\u001a\u00030«\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b¬\u0002\u0010\u00ad\u0002R\u0019\u0010°\u0002\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¯\u0002\u0010¡\u0002R\u0016\u0010²\u0002\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b±\u0002\u0010\u001cR\u0016\u0010³\u0002\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b³\u0002\u0010\u001cR,\u0010¸\u0002\u001a\u00030ò\u00012\b\u0010æ\u0001\u001a\u00030ò\u00018P@PX\u0090\u000e¢\u0006\u0010\u001a\u0006\b´\u0002\u0010µ\u0002\"\u0006\b¶\u0002\u0010·\u0002R0\u0010¾\u0002\u001a\u0005\u0018\u00010¹\u00022\n\u0010æ\u0001\u001a\u0005\u0018\u00010¹\u00028&@dX¦\u000e¢\u0006\u0010\u001a\u0006\bº\u0002\u0010»\u0002\"\u0006\b¼\u0002\u0010½\u0002R\u001f\u0010Â\u0002\u001a\n\u0012\u0005\u0012\u00030ö\u00010¿\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bÀ\u0002\u0010Á\u0002R\u001a\u0010Æ\u0002\u001a\u0005\u0018\u00010Ã\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bÄ\u0002\u0010Å\u0002R\u0016\u0010È\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\b\u001a\u0006\bÇ\u0002\u0010¤\u0002R\u0016\u0010Ê\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\b\u001a\u0006\bÉ\u0002\u0010¤\u0002R\u0018\u0010Í\u0002\u001a\u00030\u0089\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\bË\u0002\u0010Ì\u0002R\u0017\u0010Ï\u0002\u001a\u00020'8@X\u0080\u0004¢\u0006\b\u001a\u0006\bÎ\u0002\u0010û\u0001R\u0016\u0010Ð\u0002\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÐ\u0002\u0010\u001cR\u0015\u0010\u009c\u0001\u001a\u00030\u009b\u00018F¢\u0006\b\u001a\u0006\bÑ\u0002\u0010û\u0001R\u0018\u0010Õ\u0002\u001a\u00030Ò\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\bÓ\u0002\u0010Ô\u0002R,\u0010Ø\u0002\u001a\u0017\u0012\u0004\u0012\u00020@\u0012\u0006\u0012\u0004\u0018\u000109\u0012\u0004\u0012\u00020\u000f0\u008b\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\bÖ\u0002\u0010×\u0002¨\u0006Û\u0002"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/node/LayoutNode;)V", "", InpaintImageAction.IMAGES_KEY_MASK, "", "includeTail", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Node;", "LC7/r;", "block", "visitNodes", "(IZLS7/k;)V", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/NodeKind;", "type", "visitNodes-aLcG6gQ", "(ILS7/k;)V", "head-H91voCI", "(I)Landroidx/compose/ui/Modifier$Node;", "head", "isTransparent", "()Z", "replace$ui_release", "()V", "replace", "ensureLookaheadDelegateCreated", "width", "height", "onMeasureResultChanged", "(II)V", "onCoordinatesUsed$ui_release", "onCoordinatesUsed", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/Placeable;", "performingMeasure-K40F9xA", "(JLS7/a;)Landroidx/compose/ui/layout/Placeable;", "performingMeasure", "onMeasured", "onUnplaced", "Landroidx/compose/ui/unit/IntOffset;", "position", "", "zIndex", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "layerBlock", "placeAt-f8xVGno", "(JFLS7/k;)V", "placeAt", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", WindowStateInfo.KEY_LAYER, "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "releaseLayer", "placeSelfApparentToRealOffset-MLgxB_4", "(JFLS7/k;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelfApparentToRealOffset", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "graphicsLayer", "draw", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "performDraw", "onPlaced", "forceUpdateLayerParameters", "updateLayerBlock", "(LS7/k;Z)V", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "hitTestSource", "Landroidx/compose/ui/geometry/Offset;", "pointerPosition", "Landroidx/compose/ui/node/HitTestResult;", "hitTestResult", "Landroidx/compose/ui/input/pointer/PointerType;", "pointerType", "isInLayer", "hitTest-qzLsGqo", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZ)V", "hitTest", "hitTestChild-qzLsGqo", "hitTestChild", "Landroidx/compose/ui/geometry/Rect;", "touchBoundsInRoot", "()Landroidx/compose/ui/geometry/Rect;", "relativeToScreen", "screenToLocal-MK-Hz9U", "(J)J", "screenToLocal", "relativeToLocal", "localToScreen-MK-Hz9U", "localToScreen", "relativeToWindow", "windowToLocal-MK-Hz9U", "windowToLocal", "localToWindow-MK-Hz9U", "localToWindow", "sourceCoordinates", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localPositionOf", "includeMotionFrameOfReference", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "Landroidx/compose/ui/graphics/Matrix;", "matrix", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFrom", "transformToScreen-58bKbWc", "([F)V", "transformToScreen", "clipBounds", "localBoundingBoxOf", "(Landroidx/compose/ui/layout/LayoutCoordinates;Z)Landroidx/compose/ui/geometry/Rect;", "localToRoot-MK-Hz9U", "localToRoot", "withPositionTranslation", "(Landroidx/compose/ui/graphics/Canvas;LS7/k;)V", "toParentPosition-8S9VItk", "(JZ)J", "toParentPosition", "fromParentPosition-8S9VItk", "fromParentPosition", "Landroidx/compose/ui/graphics/Paint;", "paint", "drawBorder", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Paint;)V", "onLayoutNodeDetach", "onRelease", "Landroidx/compose/ui/geometry/MutableRect;", "bounds", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "(Landroidx/compose/ui/geometry/MutableRect;ZZ)V", "rectInParent", "withinLayerBounds-k-4lQ0M", "(J)Z", "withinLayerBounds", "isPointerInBounds-k-4lQ0M", "isPointerInBounds", "invalidateLayer", "onLayoutModifierNodeChanged", "other", "findCommonAncestor$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)Landroidx/compose/ui/node/NodeCoordinator;", "findCommonAncestor", "shouldSharePointerInputWithSiblings", "Landroidx/compose/ui/geometry/Size;", "minimumTouchTargetSize", "calculateMinimumTouchTargetPadding-E7KxVPU", "calculateMinimumTouchTargetPadding", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "distanceInMinimumTouchTarget", "headNode", "(Z)Landroidx/compose/ui/Modifier$Node;", "hasNode-H91voCI", "(I)Z", "hasNode", "explicitLayer", "placeSelf-MLgxB_4", "placeSelf", "drawContainedDrawModifiers", "invokeOnLayoutChange", "updateLayerParameters", "(Z)Z", "hit-5ShdDok", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZ)V", "hit", "distanceFromEdge", "isHitInMinimumTouchTargetBetter", "outOfBoundsHit-8NAm7pk", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZFZ)V", "outOfBoundsHit", "hitNear-Fh5PU_I", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZF)V", "hitNear", "speculativeHit-Fh5PU_I", "speculativeHit", "isInExpandedTouchBounds-ThD-n1k", "(Landroidx/compose/ui/Modifier$Node;JI)Z", "isInExpandedTouchBounds", "toCoordinator", "(Landroidx/compose/ui/layout/LayoutCoordinates;)Landroidx/compose/ui/node/NodeCoordinator;", "ancestor", "transformToAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformToAncestor", "transformFromAncestor-EL8BTi8", "transformFromAncestor", TypedValues.CycleType.S_WAVE_OFFSET, "ancestorToLocal-S_NoaFU", "(Landroidx/compose/ui/node/NodeCoordinator;JZ)J", "ancestorToLocal", "rect", "(Landroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/geometry/MutableRect;Z)V", "fromParentRect", "(Landroidx/compose/ui/geometry/MutableRect;Z)V", "offsetFromEdge-MK-Hz9U", "offsetFromEdge", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "forcePlaceWithLookaheadOffset", "Z", "getForcePlaceWithLookaheadOffset$ui_release", "setForcePlaceWithLookaheadOffset$ui_release", "(Z)V", "forceMeasureWithLookaheadConstraints", "getForceMeasureWithLookaheadConstraints$ui_release", "setForceMeasureWithLookaheadConstraints$ui_release", "wrapped", "Landroidx/compose/ui/node/NodeCoordinator;", "getWrapped$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "released", "isClipping", "value", "LS7/k;", "getLayerBlock", "()LS7/k;", "Landroidx/compose/ui/unit/Density;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/LayoutDirection;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastLayerAlpha", "F", "Landroidx/compose/ui/layout/MeasureResult;", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/collection/MutableObjectIntMap;", "Landroidx/compose/ui/layout/AlignmentLine;", "oldAlignmentLines", "Landroidx/collection/MutableObjectIntMap;", "J", "getPosition-nOcc-ac", "()J", "setPosition--gyyYBs", "(J)V", "getZIndex", "()F", "setZIndex", "(F)V", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "Landroidx/compose/ui/node/LayerPositionalProperties;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "drawBlockParentLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "drawBlockCanvas", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/Function2;", "_drawBlock", "LS7/n;", "invalidateParentLayer", "LS7/a;", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "tail", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getDensity", "density", "getFontScale", "fontScale", "getParent", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "parent", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "getIntroducesMotionFrameOfReference", "introducesMotionFrameOfReference", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "size", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "alignmentLinesOwner", "getChild", "child", "getHasMeasureResult", "hasMeasureResult", "isAttached", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "measureResult", "Landroidx/compose/ui/node/LookaheadDelegate;", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "lookaheadDelegate", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "providedAlignmentLines", "", "getParentData", "()Ljava/lang/Object;", "parentData", "getParentLayoutCoordinates", "parentLayoutCoordinates", "getParentCoordinates", "parentCoordinates", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "rectCache", "getLastMeasurementConstraints-msEJaDk$ui_release", "lastMeasurementConstraints", "isValidOwnerScope", "getMinimumTouchTargetSize-NH-jbRc", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "snapshotObserver", "getDrawBlock", "()LS7/n;", "drawBlock", "Companion", "HitTestSource", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope {
    public static final int $stable = 0;
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    private n _drawBlock;
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private Canvas drawBlockCanvas;
    private GraphicsLayer drawBlockParentLayer;
    private GraphicsLayer explicitLayer;
    private boolean forceMeasureWithLookaheadConstraints;
    private boolean forcePlaceWithLookaheadOffset;
    private boolean isClipping;
    private boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private k layerBlock;
    private LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private MutableObjectIntMap<AlignmentLine> oldAlignmentLines;
    private boolean released;
    private NodeCoordinator wrapped;
    private NodeCoordinator wrappedBy;
    private float zIndex;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final k onCommitAffectingLayerParams = new k() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayerParams$1
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((NodeCoordinator) obj);
            return r.f317a;
        }

        public final void invoke(NodeCoordinator nodeCoordinator) {
            if (nodeCoordinator.isValidOwnerScope() && NodeCoordinator.updateLayerParameters$default(nodeCoordinator, false, 1, null)) {
                LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
                LayoutNodeLayoutDelegate layoutDelegate = layoutNode.getLayoutDelegate();
                if (layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                    if (layoutDelegate.getCoordinatesAccessedDuringModifierPlacement() || layoutDelegate.getCoordinatesAccessedDuringPlacement()) {
                        LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                    }
                    layoutDelegate.getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
                }
                layoutNode.invalidateOffsetFromRoot$ui_release();
                Owner ownerRequireOwner = LayoutNodeKt.requireOwner(layoutNode);
                ownerRequireOwner.getRectManager().onLayoutLayerPositionalPropertiesChanged(layoutNode);
                if (layoutNode.getGloballyPositionedObservers() > 0) {
                    ownerRequireOwner.requestOnPositionedCallback(layoutNode);
                }
            }
        }
    };
    private static final k onCommitAffectingLayer = new k() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayer$1
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((NodeCoordinator) obj);
            return r.f317a;
        }

        public final void invoke(NodeCoordinator nodeCoordinator) {
            OwnedLayer layer = nodeCoordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
        }
    };
    private static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    private static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    private static final float[] tmpMatrix = Matrix.m4380constructorimpl$default(null, 1, null);
    private static final HitTestSource PointerInputSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$PointerInputSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-qzLsGqo, reason: not valid java name */
        public void mo5852childHitTestqzLsGqo(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, int pointerType, boolean isInLayer) {
            layoutNode.m5757hitTest6fMxITs$ui_release(pointerPosition, hitTestResult, pointerType, isInLayer);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw, reason: not valid java name */
        public int mo5853entityTypeOLwlOKw() {
            return NodeKind.m5862constructorimpl(16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r9v0, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r9v1, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r9v10 */
        /* JADX WARN: Type inference failed for: r9v11 */
        /* JADX WARN: Type inference failed for: r9v12 */
        /* JADX WARN: Type inference failed for: r9v4 */
        /* JADX WARN: Type inference failed for: r9v5, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v7 */
        /* JADX WARN: Type inference failed for: r9v8 */
        /* JADX WARN: Type inference failed for: r9v9 */
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            int iM5862constructorimpl = NodeKind.m5862constructorimpl(16);
            MutableVector mutableVector = null;
            while (node != 0) {
                if (node instanceof PointerInputModifierNode) {
                    if (((PointerInputModifierNode) node).interceptOutOfBoundsChildEvents()) {
                        return true;
                    }
                } else if ((node.getKindSet() & iM5862constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                    Modifier.Node delegate = node.getDelegate();
                    int i = 0;
                    node = node;
                    while (delegate != null) {
                        if ((delegate.getKindSet() & iM5862constructorimpl) != 0) {
                            i++;
                            if (i == 1) {
                                node = delegate;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node != 0) {
                                    mutableVector.add(node);
                                    node = 0;
                                }
                                mutableVector.add(delegate);
                            }
                        }
                        delegate = delegate.getChild();
                        node = node;
                    }
                    if (i == 1) {
                    }
                }
                node = DelegatableNodeKt.pop(mutableVector);
            }
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
            return true;
        }
    };
    private static final HitTestSource SemanticsSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$SemanticsSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-qzLsGqo */
        public void mo5852childHitTestqzLsGqo(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, int pointerType, boolean isInLayer) {
            layoutNode.m5758hitTestSemantics6fMxITs$ui_release(pointerPosition, hitTestResult, pointerType, isInLayer);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw */
        public int mo5853entityTypeOLwlOKw() {
            return NodeKind.m5862constructorimpl(8);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
            SemanticsConfiguration semanticsConfiguration = parentLayoutNode.getSemanticsConfiguration();
            boolean z10 = false;
            if (semanticsConfiguration != null && semanticsConfiguration.getIsClearingSemantics()) {
                z10 = true;
            }
            return !z10;
        }
    };
    private Density layerDensity = getLayoutNode().getDensity();
    private LayoutDirection layerLayoutDirection = getLayoutNode().getLayoutDirection();
    private float lastLayerAlpha = 0.8f;
    private long position = IntOffset.INSTANCE.m6983getZeronOccac();
    private final a invalidateParentLayer = new a() { // from class: androidx.compose.ui.node.NodeCoordinator$invalidateParentLayer$1
        {
            super(0);
        }

        @Override // S7.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m5855invoke();
            return r.f317a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m5855invoke() {
            NodeCoordinator wrappedBy = this.this$0.getWrappedBy();
            if (wrappedBy != null) {
                wrappedBy.invalidateLayer();
            }
        }
    };

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$Companion;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "getSemanticsSource", "", "ExpectAttachedLayoutCoordinates", "Ljava/lang/String;", "UnmeasuredError", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", "LC7/r;", "onCommitAffectingLayerParams", "LS7/k;", "onCommitAffectingLayer", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "Landroidx/compose/ui/graphics/Matrix;", "tmpMatrix", "[F", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final HitTestSource getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        public final HitTestSource getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0013\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\bH&¢\u0006\u0004\b\u0018\u0010\u0019ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "entityType", "Landroidx/compose/ui/Modifier$Node;", "node", "", "interceptOutOfBoundsChildEvents", "(Landroidx/compose/ui/Modifier$Node;)Z", "Landroidx/compose/ui/node/LayoutNode;", "parentLayoutNode", "shouldHitTestChildren", "(Landroidx/compose/ui/node/LayoutNode;)Z", "layoutNode", "Landroidx/compose/ui/geometry/Offset;", "pointerPosition", "Landroidx/compose/ui/node/HitTestResult;", "hitTestResult", "Landroidx/compose/ui/input/pointer/PointerType;", "pointerType", "isInLayer", "LC7/r;", "childHitTest-qzLsGqo", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;IZ)V", "childHitTest", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface HitTestSource {
        /* renamed from: childHitTest-qzLsGqo */
        void mo5852childHitTestqzLsGqo(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, int pointerType, boolean isInLayer);

        /* renamed from: entityType-OLwlOKw */
        int mo5853entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(Modifier.Node node);

        boolean shouldHitTestChildren(LayoutNode parentLayoutNode);
    }

    public NodeCoordinator(LayoutNode layoutNode) {
        this.layoutNode = layoutNode;
    }

    private final void ancestorToLocal(NodeCoordinator ancestor, MutableRect rect, boolean clipBounds) {
        if (ancestor == this) {
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.ancestorToLocal(ancestor, rect, clipBounds);
        }
        fromParentRect(rect, clipBounds);
    }

    /* renamed from: ancestorToLocal-S_NoaFU, reason: not valid java name */
    private final long m5825ancestorToLocalS_NoaFU(NodeCoordinator ancestor, long offset, boolean includeMotionFrameOfReference) {
        if (ancestor == this) {
            return offset;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        return (nodeCoordinator == null || kotlin.jvm.internal.k.b(ancestor, nodeCoordinator)) ? m5840fromParentPosition8S9VItk(offset, includeMotionFrameOfReference) : m5840fromParentPosition8S9VItk(nodeCoordinator.m5825ancestorToLocalS_NoaFU(ancestor, offset, includeMotionFrameOfReference), includeMotionFrameOfReference);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas, GraphicsLayer graphicsLayer) {
        Modifier.Node nodeM5843headH91voCI = m5843headH91voCI(NodeKind.m5862constructorimpl(4));
        if (nodeM5843headH91voCI == null) {
            performDraw(canvas, graphicsLayer);
        } else {
            getLayoutNode().getMDrawScope$ui_release().m5772draweZhPAX0$ui_release(canvas, IntSizeKt.m7027toSizeozmzZPI(mo5557getSizeYbymL2g()), this, nodeM5843headH91voCI, graphicsLayer);
        }
    }

    /* renamed from: fromParentPosition-8S9VItk$default, reason: not valid java name */
    public static /* synthetic */ long m5826fromParentPosition8S9VItk$default(NodeCoordinator nodeCoordinator, long j5, boolean z10, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fromParentPosition-8S9VItk");
        }
        if ((i & 2) != 0) {
            z10 = true;
        }
        return nodeCoordinator.m5840fromParentPosition8S9VItk(j5, z10);
    }

    private final void fromParentRect(MutableRect bounds, boolean clipBounds) {
        float fM6972getXimpl = IntOffset.m6972getXimpl(getPosition());
        bounds.setLeft(bounds.getLeft() - fM6972getXimpl);
        bounds.setRight(bounds.getRight() - fM6972getXimpl);
        float fM6973getYimpl = IntOffset.m6973getYimpl(getPosition());
        bounds.setTop(bounds.getTop() - fM6973getYimpl);
        bounds.setBottom(bounds.getBottom() - fM6973getYimpl);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(bounds, true);
            if (this.isClipping && clipBounds) {
                bounds.intersect(0.0f, 0.0f, (int) (mo5557getSizeYbymL2g() >> 32), (int) (mo5557getSizeYbymL2g() & 4294967295L));
                bounds.isEmpty();
            }
        }
    }

    private final n getDrawBlock() {
        n nVar = this._drawBlock;
        if (nVar != null) {
            return nVar;
        }
        final a aVar = new a() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$drawBlockCallToDrawModifiers$1
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m5854invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m5854invoke() {
                NodeCoordinator nodeCoordinator = this.this$0;
                Canvas canvas = nodeCoordinator.drawBlockCanvas;
                kotlin.jvm.internal.k.c(canvas);
                nodeCoordinator.drawContainedDrawModifiers(canvas, this.this$0.drawBlockParentLayer);
            }
        };
        n nVar2 = new n() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Canvas) obj, (GraphicsLayer) obj2);
                return r.f317a;
            }

            public final void invoke(Canvas canvas, GraphicsLayer graphicsLayer) {
                if (!this.this$0.getLayoutNode().isPlaced()) {
                    this.this$0.lastLayerDrawingWasSkipped = true;
                    return;
                }
                this.this$0.drawBlockCanvas = canvas;
                this.this$0.drawBlockParentLayer = graphicsLayer;
                this.this$0.getSnapshotObserver().observeReads$ui_release(this.this$0, NodeCoordinator.onCommitAffectingLayer, aVar);
                this.this$0.lastLayerDrawingWasSkipped = false;
            }
        };
        this._drawBlock = nVar2;
        return nVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* renamed from: hasNode-H91voCI, reason: not valid java name */
    private final boolean m5827hasNodeH91voCI(int type) {
        Modifier.Node nodeHeadNode = headNode(NodeKindKt.m5871getIncludeSelfInTraversalH91voCI(type));
        return nodeHeadNode != null && DelegatableNodeKt.m5700has64DMado(nodeHeadNode, type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node headNode(boolean includeTail) {
        Modifier.Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes().getHead();
        }
        if (!includeTail) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null) {
                return nodeCoordinator.getTail();
            }
            return null;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 == null || (tail = nodeCoordinator2.getTail()) == null) {
            return null;
        }
        return tail.getChild();
    }

    /* renamed from: hit-5ShdDok, reason: not valid java name */
    private final void m5828hit5ShdDok(Modifier.Node node, HitTestSource hitTestSource, long j5, HitTestResult hitTestResult, int i, boolean z10) {
        if (node == null) {
            mo5746hitTestChildqzLsGqo(hitTestSource, j5, hitTestResult, i, z10);
            return;
        }
        int i6 = hitTestResult.hitDepth;
        hitTestResult.removeNodesInRange(hitTestResult.hitDepth + 1, hitTestResult.size());
        hitTestResult.hitDepth++;
        hitTestResult.values.add(node);
        hitTestResult.distanceFromEdgeAndFlags.add(HitTestResultKt.DistanceAndFlags(-1.0f, z10, false));
        m5828hit5ShdDok(NodeCoordinatorKt.m5860nextUntilhw7D004(node, hitTestSource.mo5853entityTypeOLwlOKw(), NodeKind.m5862constructorimpl(2)), hitTestSource, j5, hitTestResult, i, z10);
        hitTestResult.hitDepth = i6;
    }

    /* renamed from: hitNear-Fh5PU_I, reason: not valid java name */
    private final void m5829hitNearFh5PU_I(Modifier.Node node, HitTestSource hitTestSource, long j5, HitTestResult hitTestResult, int i, boolean z10, float f) {
        if (node == null) {
            mo5746hitTestChildqzLsGqo(hitTestSource, j5, hitTestResult, i, z10);
            return;
        }
        int i6 = hitTestResult.hitDepth;
        hitTestResult.removeNodesInRange(hitTestResult.hitDepth + 1, hitTestResult.size());
        hitTestResult.hitDepth++;
        hitTestResult.values.add(node);
        hitTestResult.distanceFromEdgeAndFlags.add(HitTestResultKt.DistanceAndFlags(f, z10, false));
        m5832outOfBoundsHit8NAm7pk(NodeCoordinatorKt.m5860nextUntilhw7D004(node, hitTestSource.mo5853entityTypeOLwlOKw(), NodeKind.m5862constructorimpl(2)), hitTestSource, j5, hitTestResult, i, z10, f, true);
        hitTestResult.hitDepth = i6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* renamed from: isInExpandedTouchBounds-ThD-n1k, reason: not valid java name */
    private final boolean m5830isInExpandedTouchBoundsThDn1k(Modifier.Node node, long j5, int i) {
        if (node == 0) {
            return false;
        }
        PointerType.Companion companion = PointerType.INSTANCE;
        if (!PointerType.m5492equalsimpl0(i, companion.m5498getStylusT8wyACA()) && !PointerType.m5492equalsimpl0(i, companion.m5496getEraserT8wyACA())) {
            return false;
        }
        int iM5862constructorimpl = NodeKind.m5862constructorimpl(16);
        MutableVector mutableVector = null;
        while (node != 0) {
            if (node instanceof PointerInputModifierNode) {
                long jMo5347getTouchBoundsExpansionRZrCHBk = ((PointerInputModifierNode) node).mo5347getTouchBoundsExpansionRZrCHBk();
                int i6 = (int) (j5 >> 32);
                if (Float.intBitsToFloat(i6) >= (-TouchBoundsExpansion.m5944computeLeftimpl$ui_release(jMo5347getTouchBoundsExpansionRZrCHBk, getLayoutDirection()))) {
                    if (Float.intBitsToFloat(i6) < TouchBoundsExpansion.m5945computeRightimpl$ui_release(jMo5347getTouchBoundsExpansionRZrCHBk, getLayoutDirection()) + getMeasuredWidth()) {
                        int i10 = (int) (j5 & 4294967295L);
                        if (Float.intBitsToFloat(i10) >= (-TouchBoundsExpansion.m5952getTopimpl(jMo5347getTouchBoundsExpansionRZrCHBk))) {
                            if (Float.intBitsToFloat(i10) < TouchBoundsExpansion.m5949getBottomimpl(jMo5347getTouchBoundsExpansionRZrCHBk) + getMeasuredHeight()) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            if ((node.getKindSet() & iM5862constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                Modifier.Node delegate$ui_release = node.getDelegate();
                int i11 = 0;
                node = node;
                while (delegate$ui_release != null) {
                    if ((delegate$ui_release.getKindSet() & iM5862constructorimpl) != 0) {
                        i11++;
                        if (i11 == 1) {
                            node = delegate$ui_release;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != 0) {
                                mutableVector.add(node);
                                node = 0;
                            }
                            mutableVector.add(delegate$ui_release);
                        }
                    }
                    delegate$ui_release = delegate$ui_release.getChild();
                    node = node;
                }
                if (i11 == 1) {
                }
            }
            node = DelegatableNodeKt.pop(mutableVector);
        }
        return false;
    }

    /* renamed from: offsetFromEdge-MK-Hz9U, reason: not valid java name */
    private final long m5831offsetFromEdgeMKHz9U(long pointerPosition) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (pointerPosition >> 32));
        float fMax = Math.max(0.0f, fIntBitsToFloat < 0.0f ? -fIntBitsToFloat : fIntBitsToFloat - getMeasuredWidth());
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(fMax) << 32) | (Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (pointerPosition & 4294967295L)) < 0.0f ? -r6 : r6 - getMeasuredHeight())) & 4294967295L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: outOfBoundsHit-8NAm7pk, reason: not valid java name */
    public final void m5832outOfBoundsHit8NAm7pk(final Modifier.Node node, final HitTestSource hitTestSource, final long j5, final HitTestResult hitTestResult, final int i, final boolean z10, final float f, final boolean z11) {
        if (node == null) {
            mo5746hitTestChildqzLsGqo(hitTestSource, j5, hitTestResult, i, z10);
            return;
        }
        if (m5830isInExpandedTouchBoundsThDn1k(node, j5, i)) {
            hitTestResult.hitExpandedTouchBounds(node, z10, new a() { // from class: androidx.compose.ui.node.NodeCoordinator$outOfBoundsHit$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m5856invoke();
                    return r.f317a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m5856invoke() {
                    this.this$0.m5832outOfBoundsHit8NAm7pk(NodeCoordinatorKt.m5860nextUntilhw7D004(node, hitTestSource.mo5853entityTypeOLwlOKw(), NodeKind.m5862constructorimpl(2)), hitTestSource, j5, hitTestResult, i, z10, f, z11);
                }
            });
        } else if (z11) {
            m5829hitNearFh5PU_I(node, hitTestSource, j5, hitTestResult, i, z10, f);
        } else {
            m5834speculativeHitFh5PU_I(node, hitTestSource, j5, hitTestResult, i, z10, f);
        }
    }

    /* renamed from: placeSelf-MLgxB_4, reason: not valid java name */
    private final void m5833placeSelfMLgxB_4(long position, float zIndex, k layerBlock, GraphicsLayer explicitLayer) {
        if (explicitLayer != null) {
            if (!(layerBlock == null)) {
                InlineClassHelperKt.throwIllegalArgumentException("both ways to create layers shouldn't be used together");
            }
            if (this.explicitLayer != explicitLayer) {
                this.explicitLayer = null;
                updateLayerBlock$default(this, null, false, 2, null);
                this.explicitLayer = explicitLayer;
            }
            if (this.layer == null) {
                OwnedLayer ownedLayerCreateLayer = LayoutNodeKt.requireOwner(getLayoutNode()).createLayer(getDrawBlock(), this.invalidateParentLayer, explicitLayer);
                ownedLayerCreateLayer.mo5920resizeozmzZPI(getMeasuredSize());
                ownedLayerCreateLayer.mo5919movegyyYBs(position);
                this.layer = ownedLayerCreateLayer;
                getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
            }
        } else {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
                updateLayerBlock$default(this, null, false, 2, null);
            }
            updateLayerBlock$default(this, layerBlock, false, 2, null);
        }
        if (!IntOffset.m6971equalsimpl0(getPosition(), position)) {
            LayoutNodeKt.requireOwner(getLayoutNode()).voteFrameRate(FrameRateCategory.INSTANCE.m3621getHighNSsRyOo());
            m5848setPositiongyyYBs(position);
            getLayoutNode().getLayoutDelegate().getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo5919movegyyYBs(position);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                layoutNodeArr[i].invalidateOffsetFromRoot$ui_release();
            }
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner = getLayoutNode().getOwner();
            if (owner != null) {
                owner.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = zIndex;
        if (!getIsPlacingForAlignment()) {
            captureRulersIfNeeded$ui_release(getMeasureResult$ui_release());
        }
        if (this == getLayoutNode().getOuterCoordinator$ui_release()) {
            LayoutNodeKt.requireOwner(getLayoutNode()).getRectManager().onLayoutPositionChanged(getLayoutNode(), !getLayoutNode().getMeasurePassDelegate$ui_release().getPlacedOnce());
        }
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z10, boolean z11, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i & 4) != 0) {
            z11 = false;
        }
        nodeCoordinator.rectInParent$ui_release(mutableRect, z10, z11);
    }

    /* renamed from: speculativeHit-Fh5PU_I, reason: not valid java name */
    private final void m5834speculativeHitFh5PU_I(final Modifier.Node node, final HitTestSource hitTestSource, final long j5, final HitTestResult hitTestResult, final int i, final boolean z10, final float f) {
        if (node == null) {
            mo5746hitTestChildqzLsGqo(hitTestSource, j5, hitTestResult, i, z10);
        } else if (hitTestSource.interceptOutOfBoundsChildEvents(node)) {
            hitTestResult.speculativeHit(node, f, z10, new a() { // from class: androidx.compose.ui.node.NodeCoordinator$speculativeHit$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m5857invoke();
                    return r.f317a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m5857invoke() {
                    this.this$0.m5832outOfBoundsHit8NAm7pk(NodeCoordinatorKt.m5860nextUntilhw7D004(node, hitTestSource.mo5853entityTypeOLwlOKw(), NodeKind.m5862constructorimpl(2)), hitTestSource, j5, hitTestResult, i, z10, f, false);
                }
            });
        } else {
            m5832outOfBoundsHit8NAm7pk(NodeCoordinatorKt.m5860nextUntilhw7D004(node, hitTestSource.mo5853entityTypeOLwlOKw(), NodeKind.m5862constructorimpl(2)), hitTestSource, j5, hitTestResult, i, z10, f, false);
        }
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates layoutCoordinates) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates = layoutCoordinates instanceof LookaheadLayoutCoordinates ? (LookaheadLayoutCoordinates) layoutCoordinates : null;
        if (lookaheadLayoutCoordinates != null && (coordinator = lookaheadLayoutCoordinates.getCoordinator()) != null) {
            return coordinator;
        }
        kotlin.jvm.internal.k.d(layoutCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) layoutCoordinates;
    }

    /* renamed from: toParentPosition-8S9VItk$default, reason: not valid java name */
    public static /* synthetic */ long m5835toParentPosition8S9VItk$default(NodeCoordinator nodeCoordinator, long j5, boolean z10, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toParentPosition-8S9VItk");
        }
        if ((i & 2) != 0) {
            z10 = true;
        }
        return nodeCoordinator.m5849toParentPosition8S9VItk(j5, z10);
    }

    /* renamed from: transformFromAncestor-EL8BTi8, reason: not valid java name */
    private final void m5836transformFromAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        if (kotlin.jvm.internal.k.b(ancestor, this)) {
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        kotlin.jvm.internal.k.c(nodeCoordinator);
        nodeCoordinator.m5836transformFromAncestorEL8BTi8(ancestor, matrix);
        if (!IntOffset.m6971equalsimpl0(getPosition(), IntOffset.INSTANCE.m6983getZeronOccac())) {
            float[] fArr = tmpMatrix;
            Matrix.m4389resetimpl(fArr);
            Matrix.m4402translateimpl$default(fArr, -IntOffset.m6972getXimpl(getPosition()), -IntOffset.m6973getYimpl(getPosition()), 0.0f, 4, null);
            Matrix.m4399timesAssign58bKbWc(matrix, fArr);
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo5916inverseTransform58bKbWc(matrix);
        }
    }

    /* renamed from: transformToAncestor-EL8BTi8, reason: not valid java name */
    private final void m5837transformToAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        while (!this.equals(ancestor)) {
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo5921transform58bKbWc(matrix);
            }
            if (!IntOffset.m6971equalsimpl0(this.getPosition(), IntOffset.INSTANCE.m6983getZeronOccac())) {
                float[] fArr = tmpMatrix;
                Matrix.m4389resetimpl(fArr);
                Matrix.m4402translateimpl$default(fArr, IntOffset.m6972getXimpl(r0), IntOffset.m6973getYimpl(r0), 0.0f, 4, null);
                Matrix.m4399timesAssign58bKbWc(matrix, fArr);
            }
            this = this.wrappedBy;
            kotlin.jvm.internal.k.c(this);
        }
    }

    public static /* synthetic */ void updateLayerBlock$default(NodeCoordinator nodeCoordinator, k kVar, boolean z10, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
        }
        if ((i & 2) != 0) {
            z10 = false;
        }
        nodeCoordinator.updateLayerBlock(kVar, z10);
    }

    private final boolean updateLayerParameters(boolean invokeOnLayoutChange) {
        Owner owner;
        if (this.explicitLayer != null) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer == null) {
            if (!(this.layerBlock == null)) {
                InlineClassHelperKt.throwIllegalStateException("null layer with a non-null layerBlock");
            }
            return false;
        }
        final k kVar = this.layerBlock;
        if (kVar == null) {
            throw b.x("updateLayerParameters requires a non-null layerBlock");
        }
        ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
        reusableGraphicsLayerScope.reset();
        reusableGraphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
        reusableGraphicsLayerScope.setLayoutDirection$ui_release(getLayoutNode().getLayoutDirection());
        reusableGraphicsLayerScope.m4462setSizeuvyYCjk(IntSizeKt.m7027toSizeozmzZPI(mo5557getSizeYbymL2g()));
        getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new a() { // from class: androidx.compose.ui.node.NodeCoordinator.updateLayerParameters.1
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m5858invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m5858invoke() {
                kVar.invoke(NodeCoordinator.graphicsLayerScope);
                NodeCoordinator.graphicsLayerScope.updateOutline$ui_release();
            }
        });
        LayerPositionalProperties layerPositionalProperties = this.layerPositionalProperties;
        if (layerPositionalProperties == null) {
            layerPositionalProperties = new LayerPositionalProperties();
            this.layerPositionalProperties = layerPositionalProperties;
        }
        LayerPositionalProperties layerPositionalProperties2 = tmpLayerPositionalProperties;
        layerPositionalProperties2.copyFrom(layerPositionalProperties);
        layerPositionalProperties.copyFrom(reusableGraphicsLayerScope);
        ownedLayer.updateLayerProperties(reusableGraphicsLayerScope);
        boolean z10 = this.isClipping;
        this.isClipping = reusableGraphicsLayerScope.getClip();
        this.lastLayerAlpha = reusableGraphicsLayerScope.getAlpha();
        boolean zHasSameValuesAs = layerPositionalProperties2.hasSameValuesAs(layerPositionalProperties);
        boolean z11 = !zHasSameValuesAs;
        if (invokeOnLayoutChange && ((!zHasSameValuesAs || z10 != this.isClipping) && (owner = getLayoutNode().getOwner()) != null)) {
            owner.onLayoutChange(getLayoutNode());
        }
        return z11;
    }

    public static /* synthetic */ boolean updateLayerParameters$default(NodeCoordinator nodeCoordinator, boolean z10, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
        }
        if ((i & 1) != 0) {
            z10 = true;
        }
        return nodeCoordinator.updateLayerParameters(z10);
    }

    /* renamed from: calculateMinimumTouchTargetPadding-E7KxVPU, reason: not valid java name */
    public final long m5838calculateMinimumTouchTargetPaddingE7KxVPU(long minimumTouchTargetSize) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (minimumTouchTargetSize >> 32)) - getMeasuredWidth();
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (minimumTouchTargetSize & 4294967295L)) - getMeasuredHeight();
        float fMax = Math.max(0.0f, fIntBitsToFloat / 2.0f);
        float fMax2 = Math.max(0.0f, fIntBitsToFloat2 / 2.0f);
        return Size.m3955constructorimpl((Float.floatToRawIntBits(fMax) << 32) | (Float.floatToRawIntBits(fMax2) & 4294967295L));
    }

    /* renamed from: distanceInMinimumTouchTarget-tz77jQw, reason: not valid java name */
    public final float m5839distanceInMinimumTouchTargettz77jQw(long pointerPosition, long minimumTouchTargetSize) {
        if (getMeasuredWidth() >= Float.intBitsToFloat((int) (minimumTouchTargetSize >> 32)) && getMeasuredHeight() >= Float.intBitsToFloat((int) (minimumTouchTargetSize & 4294967295L))) {
            return Float.POSITIVE_INFINITY;
        }
        long jM5838calculateMinimumTouchTargetPaddingE7KxVPU = m5838calculateMinimumTouchTargetPaddingE7KxVPU(minimumTouchTargetSize);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jM5838calculateMinimumTouchTargetPaddingE7KxVPU >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM5838calculateMinimumTouchTargetPaddingE7KxVPU & 4294967295L));
        long jM5831offsetFromEdgeMKHz9U = m5831offsetFromEdgeMKHz9U(pointerPosition);
        if ((fIntBitsToFloat > 0.0f || fIntBitsToFloat2 > 0.0f) && Float.intBitsToFloat((int) (jM5831offsetFromEdgeMKHz9U >> 32)) <= fIntBitsToFloat && Float.intBitsToFloat((int) (jM5831offsetFromEdgeMKHz9U & 4294967295L)) <= fIntBitsToFloat2) {
            return Offset.m3894getDistanceSquaredimpl(jM5831offsetFromEdgeMKHz9U);
        }
        return Float.POSITIVE_INFINITY;
    }

    public final void draw(Canvas canvas, GraphicsLayer graphicsLayer) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas, graphicsLayer);
            return;
        }
        float fM6972getXimpl = IntOffset.m6972getXimpl(getPosition());
        float fM6973getYimpl = IntOffset.m6973getYimpl(getPosition());
        canvas.translate(fM6972getXimpl, fM6973getYimpl);
        drawContainedDrawModifiers(canvas, graphicsLayer);
        canvas.translate(-fM6972getXimpl, -fM6973getYimpl);
    }

    public final void drawBorder(Canvas canvas, Paint paint) {
        canvas.drawRect(0.5f, 0.5f, ((int) (getMeasuredSize() >> 32)) - 0.5f, ((int) (getMeasuredSize() & 4294967295L)) - 0.5f, paint);
    }

    public abstract void ensureLookaheadDelegateCreated();

    public final NodeCoordinator findCommonAncestor$ui_release(NodeCoordinator other) {
        LayoutNode layoutNode = other.getLayoutNode();
        LayoutNode layoutNode2 = getLayoutNode();
        if (layoutNode == layoutNode2) {
            Modifier.Node tail = other.getTail();
            Modifier.Node tail2 = getTail();
            int iM5862constructorimpl = NodeKind.m5862constructorimpl(2);
            if (!tail2.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
            }
            for (Modifier.Node parent$ui_release = tail2.getNode().getParent(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent()) {
                if ((parent$ui_release.getKindSet() & iM5862constructorimpl) != 0 && parent$ui_release == tail) {
                    return other;
                }
            }
            return this;
        }
        while (layoutNode.getDepth() > layoutNode2.getDepth()) {
            layoutNode = layoutNode.getParent$ui_release();
            kotlin.jvm.internal.k.c(layoutNode);
        }
        while (layoutNode2.getDepth() > layoutNode.getDepth()) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            kotlin.jvm.internal.k.c(layoutNode2);
        }
        while (layoutNode != layoutNode2) {
            layoutNode = layoutNode.getParent$ui_release();
            layoutNode2 = layoutNode2.getParent$ui_release();
            if (layoutNode == null || layoutNode2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        if (layoutNode2 != getLayoutNode()) {
            if (layoutNode != other.getLayoutNode()) {
                return layoutNode.getInnerCoordinator$ui_release();
            }
            return other;
        }
        return this;
    }

    /* renamed from: fromParentPosition-8S9VItk, reason: not valid java name */
    public long m5840fromParentPosition8S9VItk(long position, boolean includeMotionFrameOfReference) {
        if (includeMotionFrameOfReference || !getIsPlacedUnderMotionFrameOfReference()) {
            position = IntOffsetKt.m6985minusNvtHpc(position, getPosition());
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer != null ? ownedLayer.mo5918mapOffset8S9VItk(position, true) : position;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate().getAlignmentLinesOwner$ui_release();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutCoordinates getCoordinates() {
        return this;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    /* renamed from: getForceMeasureWithLookaheadConstraints$ui_release, reason: from getter */
    public final boolean getForceMeasureWithLookaheadConstraints() {
        return this.forceMeasureWithLookaheadConstraints;
    }

    /* renamed from: getForcePlaceWithLookaheadOffset$ui_release, reason: from getter */
    public final boolean getForcePlaceWithLookaheadOffset() {
        return this.forcePlaceWithLookaheadOffset;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean getIntroducesMotionFrameOfReference() {
        return getIsPlacedUnderMotionFrameOfReference();
    }

    /* renamed from: getLastLayerDrawingWasSkipped$ui_release, reason: from getter */
    public final boolean getLastLayerDrawingWasSkipped() {
        return this.lastLayerDrawingWasSkipped;
    }

    /* renamed from: getLastMeasurementConstraints-msEJaDk$ui_release, reason: not valid java name */
    public final long m5841getLastMeasurementConstraintsmsEJaDk$ui_release() {
        return getMeasurementConstraints();
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    public final k getLayerBlock() {
        return this.layerBlock;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public abstract LookaheadDelegate getLookaheadDelegate();

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError);
    }

    /* renamed from: getMinimumTouchTargetSize-NH-jbRc, reason: not valid java name */
    public final long m5842getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.mo382toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().mo5764getMinimumTouchTargetSizeMYxV2XQ());
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentCoordinates() {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui_release();
        return this.wrappedBy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        if (!getLayoutNode().getNodes().m5818hasH91voCI$ui_release(NodeKind.m5862constructorimpl(64))) {
            return null;
        }
        getTail();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        for (Modifier.Node tail = getLayoutNode().getNodes().getTail(); tail != null; tail = tail.getParent()) {
            if ((NodeKind.m5862constructorimpl(64) & tail.getKindSet()) != 0) {
                int iM5862constructorimpl = NodeKind.m5862constructorimpl(64);
                MutableVector mutableVector = null;
                DelegatingNode delegatingNodePop = tail;
                while (delegatingNodePop != 0) {
                    if (delegatingNodePop instanceof ParentDataModifierNode) {
                        ref$ObjectRef.f4920a = ((ParentDataModifierNode) delegatingNodePop).modifyParentData(getLayoutNode().getDensity(), ref$ObjectRef.f4920a);
                    } else if ((delegatingNodePop.getKindSet() & iM5862constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                        Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                        int i = 0;
                        delegatingNodePop = delegatingNodePop;
                        while (delegate$ui_release != null) {
                            if ((delegate$ui_release.getKindSet() & iM5862constructorimpl) != 0) {
                                i++;
                                if (i == 1) {
                                    delegatingNodePop = delegate$ui_release;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (delegatingNodePop != 0) {
                                        mutableVector.add(delegatingNodePop);
                                        delegatingNodePop = 0;
                                    }
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                            delegate$ui_release = delegate$ui_release.getChild();
                            delegatingNodePop = delegatingNodePop;
                        }
                        if (i == 1) {
                        }
                    }
                    delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                }
            }
        }
        return ref$ObjectRef.f4920a;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui_release();
        return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* renamed from: getPosition-nOcc-ac, reason: from getter */
    public long getPosition() {
        return this.position;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        LinkedHashSet linkedHashSet = null;
        while (this != null) {
            MeasureResult measureResult = this._measureResult;
            Map<AlignmentLine, Integer> alignmentLines = measureResult != null ? measureResult.getAlignmentLines() : null;
            if (alignmentLines != null && (!alignmentLines.isEmpty())) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.addAll(alignmentLines.keySet());
            }
            this = this.wrapped;
        }
        return linkedHashSet == null ? EmptySet.f4895a : linkedHashSet;
    }

    public final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this._rectCache = mutableRect2;
        return mutableRect2;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public final long mo5557getSizeYbymL2g() {
        return getMeasuredSize();
    }

    public abstract Modifier.Node getTail();

    /* renamed from: getWrapped$ui_release, reason: from getter */
    public final NodeCoordinator getWrapped() {
        return this.wrapped;
    }

    /* renamed from: getWrappedBy$ui_release, reason: from getter */
    public final NodeCoordinator getWrappedBy() {
        return this.wrappedBy;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    /* renamed from: head-H91voCI, reason: not valid java name */
    public final Modifier.Node m5843headH91voCI(int type) {
        boolean zM5871getIncludeSelfInTraversalH91voCI = NodeKindKt.m5871getIncludeSelfInTraversalH91voCI(type);
        Modifier.Node tail = getTail();
        if (!zM5871getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return null;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM5871getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & type) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
            if ((nodeHeadNode.getKindSet() & type) != 0) {
                return nodeHeadNode;
            }
            if (nodeHeadNode == tail) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: hitTest-qzLsGqo, reason: not valid java name */
    public final void m5844hitTestqzLsGqo(HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, int pointerType, boolean isInLayer) {
        boolean z10;
        Modifier.Node nodeM5843headH91voCI = m5843headH91voCI(hitTestSource.mo5853entityTypeOLwlOKw());
        boolean z11 = false;
        if (!m5851withinLayerBoundsk4lQ0M(pointerPosition)) {
            if (PointerType.m5492equalsimpl0(pointerType, PointerType.INSTANCE.m5499getTouchT8wyACA())) {
                float fM5839distanceInMinimumTouchTargettz77jQw = m5839distanceInMinimumTouchTargettz77jQw(pointerPosition, m5842getMinimumTouchTargetSizeNHjbRc());
                if ((Float.floatToRawIntBits(fM5839distanceInMinimumTouchTargettz77jQw) & Integer.MAX_VALUE) >= 2139095040 || !hitTestResult.isHitInMinimumTouchTargetBetter(fM5839distanceInMinimumTouchTargettz77jQw, false)) {
                    return;
                }
                m5829hitNearFh5PU_I(nodeM5843headH91voCI, hitTestSource, pointerPosition, hitTestResult, pointerType, false, fM5839distanceInMinimumTouchTargettz77jQw);
                return;
            }
            return;
        }
        if (nodeM5843headH91voCI == null) {
            mo5746hitTestChildqzLsGqo(hitTestSource, pointerPosition, hitTestResult, pointerType, isInLayer);
            return;
        }
        if (m5845isPointerInBoundsk4lQ0M(pointerPosition)) {
            m5828hit5ShdDok(nodeM5843headH91voCI, hitTestSource, pointerPosition, hitTestResult, pointerType, isInLayer);
            return;
        }
        float fM5839distanceInMinimumTouchTargettz77jQw2 = !PointerType.m5492equalsimpl0(pointerType, PointerType.INSTANCE.m5499getTouchT8wyACA()) ? Float.POSITIVE_INFINITY : m5839distanceInMinimumTouchTargettz77jQw(pointerPosition, m5842getMinimumTouchTargetSizeNHjbRc());
        if ((Float.floatToRawIntBits(fM5839distanceInMinimumTouchTargettz77jQw2) & Integer.MAX_VALUE) < 2139095040) {
            z10 = isInLayer;
            if (hitTestResult.isHitInMinimumTouchTargetBetter(fM5839distanceInMinimumTouchTargettz77jQw2, z10)) {
                z11 = true;
            }
        } else {
            z10 = isInLayer;
        }
        m5832outOfBoundsHit8NAm7pk(nodeM5843headH91voCI, hitTestSource, pointerPosition, hitTestResult, pointerType, z10, fM5839distanceInMinimumTouchTargettz77jQw2, z11);
    }

    /* renamed from: hitTestChild-qzLsGqo */
    public void mo5746hitTestChildqzLsGqo(HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, int pointerType, boolean isInLayer) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m5844hitTestqzLsGqo(hitTestSource, m5826fromParentPosition8S9VItk$default(nodeCoordinator, pointerPosition, false, 2, null), hitTestResult, pointerType, isInLayer);
        }
    }

    public void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getTail().getIsAttached();
    }

    /* renamed from: isPointerInBounds-k-4lQ0M, reason: not valid java name */
    public final boolean m5845isPointerInBoundsk4lQ0M(long pointerPosition) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (pointerPosition >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (pointerPosition & 4294967295L));
        return fIntBitsToFloat >= 0.0f && fIntBitsToFloat2 >= 0.0f && fIntBitsToFloat < ((float) getMeasuredWidth()) && fIntBitsToFloat2 < ((float) getMeasuredHeight());
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return (this.layer == null || this.released || !getLayoutNode().isAttached()) ? false : true;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        if (!sourceCoordinates.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates " + sourceCoordinates + " is not attached!");
        }
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        MutableRect rectCache = getRectCache();
        rectCache.setLeft(0.0f);
        rectCache.setTop(0.0f);
        rectCache.setRight((int) (sourceCoordinates.mo5557getSizeYbymL2g() >> 32));
        rectCache.setBottom((int) (sourceCoordinates.mo5557getSizeYbymL2g() & 4294967295L));
        NodeCoordinator nodeCoordinator = coordinator;
        while (nodeCoordinator != nodeCoordinatorFindCommonAncestor$ui_release) {
            boolean z10 = clipBounds;
            rectInParent$ui_release$default(nodeCoordinator, rectCache, z10, false, 4, null);
            if (rectCache.isEmpty()) {
                return Rect.INSTANCE.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            kotlin.jvm.internal.k.c(nodeCoordinator);
            clipBounds = z10;
        }
        ancestorToLocal(nodeCoordinatorFindCommonAncestor$ui_release, rectCache, clipBounds);
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public long mo5558localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        return mo5559localPositionOfS_NoaFU(sourceCoordinates, relativeToSource, true);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-S_NoaFU */
    public long mo5559localPositionOfS_NoaFU(LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference) {
        if (sourceCoordinates instanceof LookaheadLayoutCoordinates) {
            LookaheadLayoutCoordinates lookaheadLayoutCoordinates = (LookaheadLayoutCoordinates) sourceCoordinates;
            lookaheadLayoutCoordinates.getCoordinator().onCoordinatesUsed$ui_release();
            return Offset.m3887constructorimpl(lookaheadLayoutCoordinates.mo5559localPositionOfS_NoaFU(this, Offset.m3887constructorimpl(relativeToSource ^ (-9223372034707292160L)), includeMotionFrameOfReference) ^ (-9223372034707292160L));
        }
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        while (coordinator != nodeCoordinatorFindCommonAncestor$ui_release) {
            relativeToSource = coordinator.m5849toParentPosition8S9VItk(relativeToSource, includeMotionFrameOfReference);
            coordinator = coordinator.wrappedBy;
            kotlin.jvm.internal.k.c(coordinator);
        }
        return m5825ancestorToLocalS_NoaFU(nodeCoordinatorFindCommonAncestor$ui_release, relativeToSource, includeMotionFrameOfReference);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public long mo5560localToRootMKHz9U(long relativeToLocal) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui_release();
        long jM5835toParentPosition8S9VItk$default = relativeToLocal;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
            jM5835toParentPosition8S9VItk$default = m5835toParentPosition8S9VItk$default(nodeCoordinator, jM5835toParentPosition8S9VItk$default, false, 2, null);
        }
        return jM5835toParentPosition8S9VItk$default;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToScreen-MK-Hz9U */
    public long mo5561localToScreenMKHz9U(long relativeToLocal) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        return LayoutNodeKt.requireOwner(getLayoutNode()).mo5501localToScreenMKHz9U(mo5560localToRootMKHz9U(relativeToLocal));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public long mo5562localToWindowMKHz9U(long relativeToLocal) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).mo5923calculatePositionInWindowMKHz9U(mo5560localToRootMKHz9U(relativeToLocal));
    }

    public final void onCoordinatesUsed$ui_release() {
        getLayoutNode().getLayoutDelegate().onCoordinatesUsed();
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final void onLayoutNodeDetach() {
        releaseLayer();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public void onMeasureResultChanged(int width, int height) {
        NodeCoordinator nodeCoordinator;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo5920resizeozmzZPI(IntSize.m7010constructorimpl((width << 32) | (height & 4294967295L)));
        } else if (getLayoutNode().isPlaced() && (nodeCoordinator = this.wrappedBy) != null) {
            nodeCoordinator.invalidateLayer();
        }
        m5615setMeasuredSizeozmzZPI(IntSize.m7010constructorimpl((height & 4294967295L) | (width << 32)));
        if (this.layerBlock != null) {
            updateLayerParameters(false);
        }
        int iM5862constructorimpl = NodeKind.m5862constructorimpl(4);
        boolean zM5871getIncludeSelfInTraversalH91voCI = NodeKindKt.m5871getIncludeSelfInTraversalH91voCI(iM5862constructorimpl);
        Modifier.Node tail = getTail();
        if (zM5871getIncludeSelfInTraversalH91voCI || (tail = tail.getParent()) != null) {
            for (Modifier.Node nodeHeadNode = headNode(zM5871getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & iM5862constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
                if ((nodeHeadNode.getKindSet() & iM5862constructorimpl) != 0) {
                    DelegatingNode delegatingNodePop = nodeHeadNode;
                    MutableVector mutableVector = null;
                    while (delegatingNodePop != 0) {
                        if (delegatingNodePop instanceof DrawModifierNode) {
                            ((DrawModifierNode) delegatingNodePop).onMeasureResultChanged();
                        } else if ((delegatingNodePop.getKindSet() & iM5862constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                            int i = 0;
                            delegatingNodePop = delegatingNodePop;
                            while (delegate$ui_release != null) {
                                if ((delegate$ui_release.getKindSet() & iM5862constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        delegatingNodePop = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (delegatingNodePop != 0) {
                                            mutableVector.add(delegatingNodePop);
                                            delegatingNodePop = 0;
                                        }
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                                delegate$ui_release = delegate$ui_release.getChild();
                                delegatingNodePop = delegatingNodePop;
                            }
                            if (i == 1) {
                            }
                        }
                        delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if (nodeHeadNode == tail) {
                    break;
                }
            }
        }
        Owner owner = getLayoutNode().getOwner();
        if (owner != null) {
            owner.onLayoutChange(getLayoutNode());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.Object] */
    public final void onMeasured() {
        Modifier.Node parent$ui_release;
        if (m5827hasNodeH91voCI(NodeKind.m5862constructorimpl(128))) {
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            k readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                int iM5862constructorimpl = NodeKind.m5862constructorimpl(128);
                boolean zM5871getIncludeSelfInTraversalH91voCI = NodeKindKt.m5871getIncludeSelfInTraversalH91voCI(iM5862constructorimpl);
                if (!zM5871getIncludeSelfInTraversalH91voCI) {
                    parent$ui_release = getTail().getParent();
                    if (parent$ui_release == null) {
                    }
                }
                parent$ui_release = getTail();
                for (Modifier.Node nodeHeadNode = headNode(zM5871getIncludeSelfInTraversalH91voCI); nodeHeadNode != null; nodeHeadNode = nodeHeadNode.getChild()) {
                    if ((nodeHeadNode.getAggregateChildKindSet() & iM5862constructorimpl) == 0) {
                        break;
                    }
                    if ((nodeHeadNode.getKindSet() & iM5862constructorimpl) != 0) {
                        MutableVector mutableVector = null;
                        DelegatingNode delegatingNodePop = nodeHeadNode;
                        while (delegatingNodePop != 0) {
                            if (delegatingNodePop instanceof LayoutAwareModifierNode) {
                                ((LayoutAwareModifierNode) delegatingNodePop).mo371onRemeasuredozmzZPI(getMeasuredSize());
                            } else if ((delegatingNodePop.getKindSet() & iM5862constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                                int i = 0;
                                delegatingNodePop = delegatingNodePop;
                                while (delegate$ui_release != null) {
                                    if ((delegate$ui_release.getKindSet() & iM5862constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            delegatingNodePop = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (delegatingNodePop != 0) {
                                                mutableVector.add(delegatingNodePop);
                                                delegatingNodePop = 0;
                                            }
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                    delegate$ui_release = delegate$ui_release.getChild();
                                    delegatingNodePop = delegatingNodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if (nodeHeadNode == parent$ui_release) {
                        break;
                    }
                }
            } finally {
                companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final void onPlaced() {
        int iM5862constructorimpl = NodeKind.m5862constructorimpl(128);
        boolean zM5871getIncludeSelfInTraversalH91voCI = NodeKindKt.m5871getIncludeSelfInTraversalH91voCI(iM5862constructorimpl);
        Modifier.Node tail = getTail();
        if (!zM5871getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM5871getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & iM5862constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
            if ((nodeHeadNode.getKindSet() & iM5862constructorimpl) != 0) {
                DelegatingNode delegatingNodePop = nodeHeadNode;
                MutableVector mutableVector = null;
                while (delegatingNodePop != 0) {
                    if (delegatingNodePop instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) delegatingNodePop).onPlaced(this);
                    } else if ((delegatingNodePop.getKindSet() & iM5862constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                        Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                        int i = 0;
                        delegatingNodePop = delegatingNodePop;
                        while (delegate$ui_release != null) {
                            if ((delegate$ui_release.getKindSet() & iM5862constructorimpl) != 0) {
                                i++;
                                if (i == 1) {
                                    delegatingNodePop = delegate$ui_release;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (delegatingNodePop != 0) {
                                        mutableVector.add(delegatingNodePop);
                                        delegatingNodePop = 0;
                                    }
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                            delegate$ui_release = delegate$ui_release.getChild();
                            delegatingNodePop = delegatingNodePop;
                        }
                        if (i == 1) {
                        }
                    }
                    delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                }
            }
            if (nodeHeadNode == tail) {
                return;
            }
        }
    }

    public final void onRelease() {
        this.released = true;
        this.invalidateParentLayer.invoke();
        releaseLayer();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public final void onUnplaced() {
        if (m5827hasNodeH91voCI(NodeKind.m5862constructorimpl(1048576))) {
            int iM5862constructorimpl = NodeKind.m5862constructorimpl(1048576);
            boolean zM5871getIncludeSelfInTraversalH91voCI = NodeKindKt.m5871getIncludeSelfInTraversalH91voCI(iM5862constructorimpl);
            Modifier.Node tail = getTail();
            if (!zM5871getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
                return;
            }
            for (Modifier.Node nodeHeadNode = headNode(zM5871getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & iM5862constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
                if ((nodeHeadNode.getKindSet() & iM5862constructorimpl) != 0) {
                    DelegatingNode delegatingNodePop = nodeHeadNode;
                    MutableVector mutableVector = null;
                    while (delegatingNodePop != 0) {
                        if (delegatingNodePop instanceof OnUnplacedModifierNode) {
                            ((OnUnplacedModifierNode) delegatingNodePop).onUnplaced();
                        } else if ((delegatingNodePop.getKindSet() & iM5862constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                            int i = 0;
                            delegatingNodePop = delegatingNodePop;
                            while (delegate$ui_release != null) {
                                if ((delegate$ui_release.getKindSet() & iM5862constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        delegatingNodePop = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (delegatingNodePop != 0) {
                                            mutableVector.add(delegatingNodePop);
                                            delegatingNodePop = 0;
                                        }
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                                delegate$ui_release = delegate$ui_release.getChild();
                                delegatingNodePop = delegatingNodePop;
                            }
                            if (i == 1) {
                            }
                        }
                        delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if (nodeHeadNode == tail) {
                    return;
                }
            }
        }
    }

    public void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.draw(canvas, graphicsLayer);
        }
    }

    /* renamed from: performingMeasure-K40F9xA, reason: not valid java name */
    public final Placeable m5846performingMeasureK40F9xA(long constraints, a block) {
        m5616setMeasurementConstraintsBRTryo0(constraints);
        return (Placeable) block.invoke();
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo5550placeAtf8xVGno(long position, float zIndex, k layerBlock) {
        if (!this.forcePlaceWithLookaheadOffset) {
            m5833placeSelfMLgxB_4(position, zIndex, layerBlock, null);
            return;
        }
        LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
        kotlin.jvm.internal.k.c(lookaheadDelegate);
        m5833placeSelfMLgxB_4(lookaheadDelegate.getPosition(), zIndex, layerBlock, null);
    }

    /* renamed from: placeSelfApparentToRealOffset-MLgxB_4, reason: not valid java name */
    public final void m5847placeSelfApparentToRealOffsetMLgxB_4(long position, float zIndex, k layerBlock, GraphicsLayer layer) {
        m5833placeSelfMLgxB_4(IntOffset.m6976plusqkQi6aY(position, getApparentToRealOffset()), zIndex, layerBlock, layer);
    }

    public final void rectInParent$ui_release(MutableRect bounds, boolean clipBounds, boolean clipToMinimumTouchTargetSize) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (clipToMinimumTouchTargetSize) {
                    long jM5842getMinimumTouchTargetSizeNHjbRc = m5842getMinimumTouchTargetSizeNHjbRc();
                    float fIntBitsToFloat = Float.intBitsToFloat((int) (jM5842getMinimumTouchTargetSizeNHjbRc >> 32)) / 2.0f;
                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM5842getMinimumTouchTargetSizeNHjbRc & 4294967295L)) / 2.0f;
                    bounds.intersect(-fIntBitsToFloat, -fIntBitsToFloat2, ((int) (mo5557getSizeYbymL2g() >> 32)) + fIntBitsToFloat, ((int) (4294967295L & mo5557getSizeYbymL2g())) + fIntBitsToFloat2);
                } else if (clipBounds) {
                    bounds.intersect(0.0f, 0.0f, (int) (mo5557getSizeYbymL2g() >> 32), (int) (4294967295L & mo5557getSizeYbymL2g()));
                }
                if (bounds.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(bounds, false);
        }
        float fM6972getXimpl = IntOffset.m6972getXimpl(getPosition());
        bounds.setLeft(bounds.getLeft() + fM6972getXimpl);
        bounds.setRight(bounds.getRight() + fM6972getXimpl);
        float fM6973getYimpl = IntOffset.m6973getYimpl(getPosition());
        bounds.setTop(bounds.getTop() + fM6973getYimpl);
        bounds.setBottom(bounds.getBottom() + fM6973getYimpl);
    }

    public final void releaseLayer() {
        if (this.layer != null) {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
            }
            updateLayerBlock$default(this, null, false, 2, null);
            LayoutNode.requestRelayout$ui_release$default(getLayoutNode(), false, 1, null);
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void replace$ui_release() {
        GraphicsLayer graphicsLayer = this.explicitLayer;
        if (graphicsLayer != null) {
            mo5614placeAtf8xVGno(getPosition(), this.zIndex, graphicsLayer);
        } else {
            mo5550placeAtf8xVGno(getPosition(), this.zIndex, this.layerBlock);
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo5563screenToLocalMKHz9U(long relativeToScreen) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        return mo5558localPositionOfR5De75A(LayoutCoordinatesKt.findRootCoordinates(this), LayoutNodeKt.requireOwner(getLayoutNode()).mo5502screenToLocalMKHz9U(relativeToScreen));
    }

    public final void setForceMeasureWithLookaheadConstraints$ui_release(boolean z10) {
        this.forceMeasureWithLookaheadConstraints = z10;
    }

    public final void setForcePlaceWithLookaheadOffset$ui_release(boolean z10) {
        this.forcePlaceWithLookaheadOffset = z10;
    }

    public abstract void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate);

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setMeasureResult$ui_release(androidx.compose.ui.layout.MeasureResult r4) {
        /*
            r3 = this;
            androidx.compose.ui.layout.MeasureResult r0 = r3._measureResult
            if (r4 == r0) goto L8c
            r3._measureResult = r4
            if (r0 == 0) goto L1c
            int r1 = r4.get$w()
            int r2 = r0.get$w()
            if (r1 != r2) goto L1c
            int r1 = r4.get$h()
            int r0 = r0.get$h()
            if (r1 == r0) goto L27
        L1c:
            int r0 = r4.get$w()
            int r1 = r4.get$h()
            r3.onMeasureResultChanged(r0, r1)
        L27:
            androidx.collection.MutableObjectIntMap<androidx.compose.ui.layout.AlignmentLine> r0 = r3.oldAlignmentLines
            if (r0 == 0) goto L34
            kotlin.jvm.internal.k.c(r0)
            boolean r0 = r0.isNotEmpty()
            if (r0 != 0) goto L3e
        L34:
            java.util.Map r0 = r4.getAlignmentLines()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L8c
        L3e:
            androidx.collection.MutableObjectIntMap<androidx.compose.ui.layout.AlignmentLine> r0 = r3.oldAlignmentLines
            java.util.Map r1 = r4.getAlignmentLines()
            boolean r0 = androidx.compose.ui.node.NodeCoordinatorKt.access$compareEquals(r0, r1)
            if (r0 != 0) goto L8c
            androidx.compose.ui.node.AlignmentLinesOwner r0 = r3.getAlignmentLinesOwner()
            androidx.compose.ui.node.AlignmentLines r0 = r0.getAlignmentLines()
            r0.onAlignmentsChanged()
            androidx.collection.MutableObjectIntMap<androidx.compose.ui.layout.AlignmentLine> r0 = r3.oldAlignmentLines
            if (r0 != 0) goto L5f
            androidx.collection.MutableObjectIntMap r0 = androidx.collection.ObjectIntMapKt.mutableObjectIntMapOf()
            r3.oldAlignmentLines = r0
        L5f:
            r0.clear()
            java.util.Map r3 = r4.getAlignmentLines()
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L6e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L8c
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r1 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r0.set(r1, r4)
            goto L6e
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeCoordinator.setMeasureResult$ui_release(androidx.compose.ui.layout.MeasureResult):void");
    }

    /* renamed from: setPosition--gyyYBs, reason: not valid java name */
    public void m5848setPositiongyyYBs(long j5) {
        this.position = j5;
    }

    public final void setWrapped$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    public final void setWrappedBy$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    public final void setZIndex(float f) {
        this.zIndex = f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final boolean shouldSharePointerInputWithSiblings() {
        Modifier.Node nodeHeadNode = headNode(NodeKindKt.m5871getIncludeSelfInTraversalH91voCI(NodeKind.m5862constructorimpl(16)));
        if (nodeHeadNode != null && nodeHeadNode.getIsAttached()) {
            int iM5862constructorimpl = NodeKind.m5862constructorimpl(16);
            if (!nodeHeadNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
            }
            Modifier.Node node = nodeHeadNode.getNode();
            if ((node.getAggregateChildKindSet() & iM5862constructorimpl) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & iM5862constructorimpl) != 0) {
                        DelegatingNode delegatingNodePop = node;
                        MutableVector mutableVector = null;
                        while (delegatingNodePop != 0) {
                            if (delegatingNodePop instanceof PointerInputModifierNode) {
                                if (((PointerInputModifierNode) delegatingNodePop).sharePointerInputWithSiblings()) {
                                    return true;
                                }
                            } else if ((delegatingNodePop.getKindSet() & iM5862constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                                int i = 0;
                                delegatingNodePop = delegatingNodePop;
                                while (delegate$ui_release != null) {
                                    if ((delegate$ui_release.getKindSet() & iM5862constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            delegatingNodePop = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (delegatingNodePop != 0) {
                                                mutableVector.add(delegatingNodePop);
                                                delegatingNodePop = 0;
                                            }
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                    delegate$ui_release = delegate$ui_release.getChild();
                                    delegatingNodePop = delegatingNodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    node = node.getChild();
                }
            }
        }
        return false;
    }

    /* renamed from: toParentPosition-8S9VItk, reason: not valid java name */
    public long m5849toParentPosition8S9VItk(long position, boolean includeMotionFrameOfReference) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            position = ownedLayer.mo5918mapOffset8S9VItk(position, false);
        }
        return (includeMotionFrameOfReference || !getIsPlacedUnderMotionFrameOfReference()) ? IntOffsetKt.m6987plusNvtHpc(position, getPosition()) : position;
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.INSTANCE.getZero();
        }
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect rectCache = getRectCache();
        long jM5838calculateMinimumTouchTargetPaddingE7KxVPU = m5838calculateMinimumTouchTargetPaddingE7KxVPU(m5842getMinimumTouchTargetSizeNHjbRc());
        int i = (int) (jM5838calculateMinimumTouchTargetPaddingE7KxVPU >> 32);
        rectCache.setLeft(-Float.intBitsToFloat(i));
        int i6 = (int) (jM5838calculateMinimumTouchTargetPaddingE7KxVPU & 4294967295L);
        rectCache.setTop(-Float.intBitsToFloat(i6));
        rectCache.setRight(Float.intBitsToFloat(i) + getMeasuredWidth());
        rectCache.setBottom(Float.intBitsToFloat(i6) + getMeasuredHeight());
        while (this != layoutCoordinatesFindRootCoordinates) {
            this.rectInParent$ui_release(rectCache, false, true);
            if (rectCache.isEmpty()) {
                return Rect.INSTANCE.getZero();
            }
            this = this.wrappedBy;
            kotlin.jvm.internal.k.c(this);
        }
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformFrom-EL8BTi8 */
    public void mo5564transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        Matrix.m4389resetimpl(matrix);
        coordinator.m5837transformToAncestorEL8BTi8(nodeCoordinatorFindCommonAncestor$ui_release, matrix);
        m5836transformFromAncestorEL8BTi8(nodeCoordinatorFindCommonAncestor$ui_release, matrix);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformToScreen-58bKbWc */
    public void mo5565transformToScreen58bKbWc(float[] matrix) {
        Owner ownerRequireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        NodeCoordinator coordinator = toCoordinator(LayoutCoordinatesKt.findRootCoordinates(this));
        m5837transformToAncestorEL8BTi8(coordinator, matrix);
        if (ownerRequireOwner instanceof MatrixPositionCalculator) {
            ((MatrixPositionCalculator) ownerRequireOwner).mo5350localToScreen58bKbWc(matrix);
            return;
        }
        long jPositionOnScreen = LayoutCoordinatesKt.positionOnScreen(coordinator);
        if ((9223372034707292159L & jPositionOnScreen) != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            Matrix.m4401translateimpl(matrix, Float.intBitsToFloat((int) (jPositionOnScreen >> 32)), Float.intBitsToFloat((int) (jPositionOnScreen & 4294967295L)), 0.0f);
        }
    }

    public final void updateLayerBlock(k layerBlock, boolean forceUpdateLayerParameters) {
        Owner owner;
        if (!(layerBlock == null || this.explicitLayer == null)) {
            InlineClassHelperKt.throwIllegalArgumentException("layerBlock can't be provided when explicitLayer is provided");
        }
        LayoutNode layoutNode = getLayoutNode();
        boolean z10 = (!forceUpdateLayerParameters && this.layerBlock == layerBlock && kotlin.jvm.internal.k.b(this.layerDensity, layoutNode.getDensity()) && this.layerLayoutDirection == layoutNode.getLayoutDirection()) ? false : true;
        this.layerDensity = layoutNode.getDensity();
        this.layerLayoutDirection = layoutNode.getLayoutDirection();
        if (!layoutNode.isAttached() || layerBlock == null) {
            this.layerBlock = null;
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.destroy();
                layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
                if (isAttached() && layoutNode.isPlaced() && (owner = layoutNode.getOwner()) != null) {
                    owner.onLayoutChange(layoutNode);
                }
            }
            this.layer = null;
            this.lastLayerDrawingWasSkipped = false;
            return;
        }
        this.layerBlock = layerBlock;
        if (this.layer != null) {
            if (z10 && updateLayerParameters$default(this, false, 1, null)) {
                LayoutNodeKt.requireOwner(layoutNode).getRectManager().onLayoutLayerPositionalPropertiesChanged(layoutNode);
                return;
            }
            return;
        }
        OwnedLayer ownedLayerCreateLayer$default = Owner.createLayer$default(LayoutNodeKt.requireOwner(layoutNode), getDrawBlock(), this.invalidateParentLayer, null, 4, null);
        ownedLayerCreateLayer$default.mo5920resizeozmzZPI(getMeasuredSize());
        ownedLayerCreateLayer$default.mo5919movegyyYBs(getPosition());
        this.layer = ownedLayerCreateLayer$default;
        updateLayerParameters$default(this, false, 1, null);
        layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
        this.invalidateParentLayer.invoke();
    }

    public final void visitNodes(int mask, boolean includeTail, k block) {
        Modifier.Node tail = getTail();
        if (!includeTail && (tail = tail.getParent()) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode = headNode(includeTail); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & mask) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
            if ((nodeHeadNode.getKindSet() & mask) != 0) {
                block.invoke(nodeHeadNode);
            }
            if (nodeHeadNode == tail) {
                return;
            }
        }
    }

    /* renamed from: visitNodes-aLcG6gQ, reason: not valid java name */
    public final <T> void m5850visitNodesaLcG6gQ(int type, k block) {
        boolean zM5871getIncludeSelfInTraversalH91voCI = NodeKindKt.m5871getIncludeSelfInTraversalH91voCI(type);
        Modifier.Node tail = getTail();
        if (!zM5871getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM5871getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & type) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
            if ((nodeHeadNode.getKindSet() & type) != 0) {
                kotlin.jvm.internal.k.m();
                throw null;
            }
            if (nodeHeadNode == tail) {
                return;
            }
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public long mo5566windowToLocalMKHz9U(long relativeToWindow) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        return mo5558localPositionOfR5De75A(layoutCoordinatesFindRootCoordinates, Offset.m3899minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).mo5922calculateLocalPositionMKHz9U(relativeToWindow), LayoutCoordinatesKt.positionInRoot(layoutCoordinatesFindRootCoordinates)));
    }

    public final void withPositionTranslation(Canvas canvas, k block) {
        float fM6972getXimpl = IntOffset.m6972getXimpl(getPosition());
        float fM6973getYimpl = IntOffset.m6973getYimpl(getPosition());
        canvas.translate(fM6972getXimpl, fM6973getYimpl);
        block.invoke(canvas);
        canvas.translate(-fM6972getXimpl, -fM6973getYimpl);
    }

    /* renamed from: withinLayerBounds-k-4lQ0M, reason: not valid java name */
    public final boolean m5851withinLayerBoundsk4lQ0M(long pointerPosition) {
        if ((((androidx.compose.ui.geometry.InlineClassHelperKt.DualFloatInfinityBase ^ (pointerPosition & androidx.compose.ui.geometry.InlineClassHelperKt.DualFloatInfinityBase)) - androidx.compose.ui.geometry.InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) != 0) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer == null || !this.isClipping || ownedLayer.mo5917isInLayerk4lQ0M(pointerPosition);
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo5614placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) {
        if (this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            kotlin.jvm.internal.k.c(lookaheadDelegate);
            m5833placeSelfMLgxB_4(lookaheadDelegate.getPosition(), zIndex, null, layer);
            return;
        }
        m5833placeSelfMLgxB_4(position, zIndex, null, layer);
    }
}
