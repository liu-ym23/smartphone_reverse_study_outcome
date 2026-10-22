package androidx.compose.ui.node;

import android.view.View;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.tooling.CompositionErrorContext;
import androidx.compose.runtime.tooling.CompositionErrorContextKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.dtf.toyger.base.face.ToygerFaceAlgorithmConfig;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tb2.c;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u008c\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0001\u0018\u0000 \u009f\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\b\u009e\u0003\u009f\u0003 \u0003¡\u0003B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010=\u001a\u00020>H\u0002J\b\u0010E\u001a\u00020>H\u0002J\r\u0010I\u001a\u00020>H\u0000¢\u0006\u0002\bJJ\u001d\u0010K\u001a\u00020>2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020>0MH\u0086\bJ#\u0010N\u001a\u00020>2\u0018\u0010L\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020>0OH\u0086\bJ\u0015\u0010b\u001a\n\u0018\u00010cj\u0004\u0018\u0001`dH\u0017¢\u0006\u0002\u0010eJ\u001d\u0010w\u001a\u00020>2\u0006\u0010x\u001a\u00020\f2\u0006\u0010y\u001a\u00020\u0000H\u0000¢\u0006\u0002\bzJ\u0010\u0010{\u001a\u00020|2\u0006\u0010y\u001a\u00020\u0000H\u0002J\r\u0010}\u001a\u00020>H\u0000¢\u0006\u0002\b~J\u001f\u0010\u007f\u001a\u00020>2\u0006\u0010x\u001a\u00020\f2\u0007\u0010\u0080\u0001\u001a\u00020\fH\u0000¢\u0006\u0003\b\u0081\u0001J\u000f\u0010\u0082\u0001\u001a\u00020>H\u0000¢\u0006\u0003\b\u0083\u0001J\u0012\u0010\u0084\u0001\u001a\u00020>2\u0007\u0010\u0085\u0001\u001a\u00020\u0000H\u0002J*\u0010\u0086\u0001\u001a\u00020>2\u0007\u0010\u0087\u0001\u001a\u00020\f2\u0007\u0010\u0088\u0001\u001a\u00020\f2\u0007\u0010\u0080\u0001\u001a\u00020\fH\u0000¢\u0006\u0003\b\u0089\u0001J\t\u0010\u008a\u0001\u001a\u00020\nH\u0016J\u000f\u0010\u008e\u0001\u001a\u00020>H\u0000¢\u0006\u0003\b\u008f\u0001J\u000f\u0010\u0090\u0001\u001a\u00020>H\u0000¢\u0006\u0003\b\u0091\u0001J\n\u0010\u0098\u0001\u001a\u00030\u0093\u0001H\u0002J\u0017\u0010\u0099\u0001\u001a\u00020>2\u0006\u0010W\u001a\u00020VH\u0000¢\u0006\u0003\b\u009a\u0001J\u000f\u0010\u009b\u0001\u001a\u00020>H\u0000¢\u0006\u0003\b\u009c\u0001J\t\u0010¤\u0001\u001a\u00020|H\u0016J\u0013\u0010§\u0001\u001a\u00020|2\b\b\u0002\u0010g\u001a\u00020\fH\u0002J\n\u0010°\u0001\u001a\u00030¯\u0001H\u0002J\u0010\u0010±\u0001\u001a\u00020\f2\u0007\u0010²\u0001\u001a\u00020\fJ\u0010\u0010³\u0001\u001a\u00020\f2\u0007\u0010´\u0001\u001a\u00020\fJ\u0010\u0010µ\u0001\u001a\u00020\f2\u0007\u0010²\u0001\u001a\u00020\fJ\u0010\u0010¶\u0001\u001a\u00020\f2\u0007\u0010´\u0001\u001a\u00020\fJ\u0010\u0010·\u0001\u001a\u00020\f2\u0007\u0010²\u0001\u001a\u00020\fJ\u0010\u0010¸\u0001\u001a\u00020\f2\u0007\u0010´\u0001\u001a\u00020\fJ\u0010\u0010¹\u0001\u001a\u00020\f2\u0007\u0010²\u0001\u001a\u00020\fJ\u0010\u0010º\u0001\u001a\u00020\f2\u0007\u0010´\u0001\u001a\u00020\fJ\u0012\u0010×\u0001\u001a\u00030Ø\u00012\b\u0010Ù\u0001\u001a\u00030Ú\u0001J\t\u0010Û\u0001\u001a\u00020>H\u0002J\u000f\u0010\u0095\u0002\u001a\u00020>H\u0000¢\u0006\u0003\b\u0096\u0002J\u0013\u0010¡\u0002\u001a\u00020>2\b\u0010\u009c\u0002\u001a\u00030\u0098\u0002H\u0002J\t\u0010¢\u0002\u001a\u00020>H\u0002J\u000f\u0010£\u0002\u001a\u00020>H\u0000¢\u0006\u0003\b¤\u0002J!\u0010·\u0002\u001a\u00020>2\u0007\u0010¸\u0002\u001a\u00020\f2\u0007\u0010¹\u0002\u001a\u00020\fH\u0000¢\u0006\u0003\bº\u0002J\u000f\u0010»\u0002\u001a\u00020>H\u0000¢\u0006\u0003\b¼\u0002J\u000f\u0010½\u0002\u001a\u00020>H\u0000¢\u0006\u0003\b¾\u0002J%\u0010¿\u0002\u001a\u00020>2\b\u0010À\u0002\u001a\u00030Á\u00022\n\u0010Â\u0002\u001a\u0005\u0018\u00010Ã\u0002H\u0000¢\u0006\u0003\bÄ\u0002J=\u0010Å\u0002\u001a\u00020>2\b\u0010Æ\u0002\u001a\u00030Ç\u00022\b\u0010È\u0002\u001a\u00030É\u00022\n\b\u0002\u0010Ê\u0002\u001a\u00030Ë\u00022\t\b\u0002\u0010Ì\u0002\u001a\u00020\nH\u0000¢\u0006\u0006\bÍ\u0002\u0010Î\u0002J=\u0010Ï\u0002\u001a\u00020>2\b\u0010Æ\u0002\u001a\u00030Ç\u00022\b\u0010Ð\u0002\u001a\u00030É\u00022\n\b\u0002\u0010Ê\u0002\u001a\u00030Ë\u00022\t\b\u0002\u0010Ì\u0002\u001a\u00020\nH\u0000¢\u0006\u0006\bÑ\u0002\u0010Î\u0002J\u0018\u0010Ò\u0002\u001a\u00020>2\u0007\u0010Ó\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\bÔ\u0002J0\u0010Õ\u0002\u001a\u00020>2\t\b\u0002\u0010Ö\u0002\u001a\u00020\n2\t\b\u0002\u0010×\u0002\u001a\u00020\n2\t\b\u0002\u0010Ø\u0002\u001a\u00020\nH\u0000¢\u0006\u0003\bÙ\u0002J0\u0010Ú\u0002\u001a\u00020>2\t\b\u0002\u0010Ö\u0002\u001a\u00020\n2\t\b\u0002\u0010×\u0002\u001a\u00020\n2\t\b\u0002\u0010Ø\u0002\u001a\u00020\nH\u0000¢\u0006\u0003\bÛ\u0002J\u000f\u0010Ü\u0002\u001a\u00020>H\u0000¢\u0006\u0003\bÝ\u0002J\u000f\u0010Þ\u0002\u001a\u00020>H\u0000¢\u0006\u0003\bß\u0002J\t\u0010à\u0002\u001a\u00020>H\u0002J\u000f\u0010á\u0002\u001a\u00020>H\u0000¢\u0006\u0003\bâ\u0002J*\u0010v\u001a\u0003Hã\u0002\"\u0005\b\u0000\u0010ã\u00022\u000e\u0010L\u001a\n\u0012\u0005\u0012\u0003Hã\u00020ä\u0002H\u0080\b¢\u0006\u0006\bå\u0002\u0010æ\u0002J\u001a\u0010ç\u0002\u001a\u00020>2\t\b\u0002\u0010Ö\u0002\u001a\u00020\nH\u0000¢\u0006\u0003\bè\u0002J\u001a\u0010é\u0002\u001a\u00020>2\t\b\u0002\u0010Ö\u0002\u001a\u00020\nH\u0000¢\u0006\u0003\bê\u0002J\u000f\u0010ë\u0002\u001a\u00020>H\u0000¢\u0006\u0003\bì\u0002J\u0010\u0010í\u0002\u001a\t\u0012\u0005\u0012\u00030î\u000208H\u0016J\u000f\u0010ï\u0002\u001a\u00020>H\u0000¢\u0006\u0003\bð\u0002J\u001d\u0010ñ\u0002\u001a\u00020\n2\f\b\u0002\u0010ò\u0002\u001a\u0005\u0018\u00010ó\u0002H\u0000¢\u0006\u0003\bô\u0002J\u001d\u0010õ\u0002\u001a\u00020\n2\f\b\u0002\u0010ò\u0002\u001a\u0005\u0018\u00010ó\u0002H\u0000¢\u0006\u0003\bö\u0002J\u000f\u0010ÿ\u0002\u001a\u00020>H\u0000¢\u0006\u0003\b\u0080\u0003J\u000f\u0010\u0081\u0003\u001a\u00020>H\u0000¢\u0006\u0003\b\u0082\u0003J\u000f\u0010\u0083\u0003\u001a\u00020>H\u0000¢\u0006\u0003\b\u0084\u0003J\u0012\u0010\u0085\u0003\u001a\u00020>2\t\b\u0002\u0010\u0086\u0003\u001a\u00020\nJ\u000f\u0010\u0087\u0003\u001a\u00020>H\u0000¢\u0006\u0003\b\u0088\u0003J\t\u0010\u0089\u0003\u001a\u00020>H\u0016J\t\u0010\u008a\u0003\u001a\u00020>H\u0016J%\u0010\u008b\u0003\u001a\u00020>2\u0013\u0010L\u001a\u000f\u0012\u0005\u0012\u00030\u008c\u0003\u0012\u0004\u0012\u00020>0MH\u0080\b¢\u0006\u0003\b\u008d\u0003J%\u0010\u008e\u0003\u001a\u00020>2\u0013\u0010L\u001a\u000f\u0012\u0005\u0012\u00030ü\u0001\u0012\u0004\u0012\u00020>0MH\u0080\b¢\u0006\u0003\b\u008f\u0003J\u000f\u0010\u0090\u0003\u001a\u00020>H\u0000¢\u0006\u0003\b\u0091\u0003J\t\u0010\u0092\u0003\u001a\u00020>H\u0002J\u000f\u0010\u0093\u0003\u001a\u00020>H\u0000¢\u0006\u0003\b\u0094\u0003J\t\u0010\u009b\u0003\u001a\u00020>H\u0016J\t\u0010\u009c\u0003\u001a\u00020>H\u0016J\t\u0010\u009d\u0003\u001a\u00020>H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u0014X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u00020\u001bX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\u001c\u0010\u001e\u001a\u00020\u0014X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001a\u0010!\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0010\"\u0004\b(\u0010\u0012R\u001a\u0010)\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R(\u0010-\u001a\u0004\u0018\u00010\u00002\b\u0010,\u001a\u0004\u0018\u00010\u0000@BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0013\u00102\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b2\u00103R\u000e\u00104\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u000006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u0000088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0016\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020@088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bA\u0010:R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020@088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bC\u0010:R\u000e\u0010D\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00000<8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u0000088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010:R\u0010\u0010R\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010S\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bT\u0010/R\"\u0010W\u001a\u0004\u0018\u00010V2\b\u0010U\u001a\u0004\u0018\u00010V@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR$\u0010Z\u001a\n\u0018\u00010[j\u0004\u0018\u0001`\\X\u0080\u000e¢\u0006\u0010\n\u0002\u0010a\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0014\u0010f\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bf\u0010#R\u001a\u0010g\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0010\"\u0004\bi\u0010\u0012R\u0014\u0010j\u001a\u00020k8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0016\u0010n\u001a\u0004\u0018\u00010o8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bp\u0010qR\u0014\u0010r\u001a\u00020s8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR\u000e\u0010v\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u008b\u0001\u001a\u00020\nX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010#\"\u0005\b\u008d\u0001\u0010%R\u0012\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u000f\u0010\u0097\u0001\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u009e\u0001\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000<8@X\u0081\u0004¢\u0006\u000f\u0012\u0006\b \u0001\u0010¡\u0001\u001a\u0005\b¢\u0001\u0010HR\u0016\u0010£\u0001\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b£\u0001\u0010#R\u0016\u0010¥\u0001\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b¦\u0001\u0010#R+\u0010©\u0001\u001a\u00030¨\u00012\u0007\u0010U\u001a\u00030¨\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R\u0012\u0010®\u0001\u001a\u0005\u0018\u00010¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010¼\u0001\u001a\u00030»\u00012\u0007\u0010U\u001a\u00030»\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R+\u0010Â\u0001\u001a\u00030Á\u00012\u0007\u0010U\u001a\u00030Á\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R+\u0010È\u0001\u001a\u00030Ç\u00012\u0007\u0010U\u001a\u00030Ç\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÉ\u0001\u0010Ê\u0001\"\u0006\bË\u0001\u0010Ì\u0001R+\u0010Î\u0001\u001a\u00030Í\u00012\u0007\u0010U\u001a\u00030Í\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÏ\u0001\u0010Ð\u0001\"\u0006\bÑ\u0001\u0010Ò\u0001R\u001a\u0010Ó\u0001\u001a\u0005\u0018\u00010Ô\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÕ\u0001\u0010Ö\u0001R\u0016\u0010´\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÜ\u0001\u0010\u0010R\u0016\u0010²\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÝ\u0001\u0010\u0010R\u0016\u0010Þ\u0001\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bß\u0001\u0010#R\u0018\u0010à\u0001\u001a\u00030á\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bâ\u0001\u0010ã\u0001R\u0016\u0010ä\u0001\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bä\u0001\u0010#R\u0013\u0010å\u0001\u001a\u00020\n8F¢\u0006\u0007\u001a\u0005\bå\u0001\u0010#R\u0016\u0010æ\u0001\u001a\u00020\f8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bç\u0001\u0010\u0010R\u0018\u0010è\u0001\u001a\u00030é\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bê\u0001\u0010ë\u0001R\u0018\u0010ì\u0001\u001a\u00030é\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bí\u0001\u0010ë\u0001R \u0010î\u0001\u001a\u00030é\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bï\u0001\u0010ë\u0001\"\u0006\bð\u0001\u0010ñ\u0001R\u0010\u0010ò\u0001\u001a\u00030é\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010ó\u0001\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0000\u0012\u0006\bô\u0001\u0010¡\u0001\u001a\u0005\bõ\u0001\u0010#\"\u0005\bö\u0001\u0010%R\u0018\u0010÷\u0001\u001a\u00030ø\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\bù\u0001\u0010ú\u0001R\u0018\u0010û\u0001\u001a\u00030ü\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bý\u0001\u0010þ\u0001R\u0018\u0010ÿ\u0001\u001a\u00030\u0080\u0002X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0081\u0002\u0010\u0082\u0002R\u0018\u0010\u0083\u0002\u001a\u00030ü\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0084\u0002\u0010þ\u0001R\u0018\u0010\u0085\u0002\u001a\u00030\u0086\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0087\u0002\u0010\u0088\u0002R\"\u0010\u0089\u0002\u001a\u0005\u0018\u00010\u008a\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0002\u0010\u008c\u0002\"\u0006\b\u008d\u0002\u0010\u008e\u0002R\u0012\u0010\u008f\u0002\u001a\u0005\u0018\u00010ü\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0090\u0002\u001a\u00020\nX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0002\u0010#\"\u0005\b\u0092\u0002\u0010%R\u001a\u0010\u0093\u0002\u001a\u0005\u0018\u00010ü\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0094\u0002\u0010þ\u0001R\u0010\u0010\u0097\u0002\u001a\u00030\u0098\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u0098\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u009a\u0002\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u009b\u0002\u0010#R+\u0010\u009c\u0002\u001a\u00030\u0098\u00022\u0007\u0010U\u001a\u00030\u0098\u00028V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u009d\u0002\u0010\u009e\u0002\"\u0006\b\u009f\u0002\u0010 \u0002R\u0018\u0010¥\u0002\u001a\u00030¦\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b§\u0002\u0010¨\u0002R-\u0010©\u0002\u001a\u0010\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020>\u0018\u00010MX\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bª\u0002\u0010«\u0002\"\u0006\b¬\u0002\u0010\u00ad\u0002R-\u0010®\u0002\u001a\u0010\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020>\u0018\u00010MX\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¯\u0002\u0010«\u0002\"\u0006\b°\u0002\u0010\u00ad\u0002R\u001d\u0010±\u0002\u001a\u00020\nX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0002\u0010#\"\u0005\b³\u0002\u0010%R'\u0010´\u0002\u001a\u00020\f2\u0006\u0010U\u001a\u00020\f@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0002\u0010\u0010\"\u0005\b¶\u0002\u0010\u0012R\u0016\u0010÷\u0002\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bø\u0002\u0010#R\u0016\u0010ù\u0002\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bú\u0002\u0010#R\u0016\u0010û\u0002\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bü\u0002\u0010#R\u0016\u0010ý\u0002\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bþ\u0002\u0010#R\u0019\u0010\u0095\u0003\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0096\u0003\u0010\u0097\u0003R\u001c\u0010\u0098\u0003\u001a\b\u0012\u0004\u0012\u00020\u0005088VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0099\u0003\u0010:R \u0010\u009a\u0003\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n@RX\u0096\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u009a\u0003\u0010#¨\u0006¢\u0003"}, d2 = {"Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/layout/Remeasurement;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/layout/LayoutInfo;", "Landroidx/compose/ui/semantics/SemanticsInfo;", "Landroidx/compose/ui/node/ComposeUiNode;", "Landroidx/compose/ui/node/InteroperableComposeUiNode;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "isVirtual", "", "semanticsId", "", "<init>", "(ZI)V", "getSemanticsId", "()I", "setSemanticsId", "(I)V", "offsetFromRoot", "Landroidx/compose/ui/unit/IntOffset;", "getOffsetFromRoot-nOcc-ac$ui_release", "()J", "setOffsetFromRoot--gyyYBs$ui_release", "(J)V", "J", "lastSize", "Landroidx/compose/ui/unit/IntSize;", "getLastSize-YbymL2g$ui_release", "setLastSize-ozmzZPI$ui_release", "outerToInnerOffset", "getOuterToInnerOffset-nOcc-ac$ui_release", "setOuterToInnerOffset--gyyYBs$ui_release", "outerToInnerOffsetDirty", "getOuterToInnerOffsetDirty$ui_release", "()Z", "setOuterToInnerOffsetDirty$ui_release", "(Z)V", "compositeKeyHash", "getCompositeKeyHash", "setCompositeKeyHash", "isVirtualLookaheadRoot", "isVirtualLookaheadRoot$ui_release", "setVirtualLookaheadRoot$ui_release", "newRoot", "lookaheadRoot", "getLookaheadRoot$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "setLookaheadRoot", "(Landroidx/compose/ui/node/LayoutNode;)V", "isPlacedInLookahead", "()Ljava/lang/Boolean;", "virtualChildrenCount", "_foldedChildren", "Landroidx/compose/ui/node/MutableVectorWithMutationTracking;", "foldedChildren", "", "getFoldedChildren$ui_release", "()Ljava/util/List;", "_unfoldedChildren", "Landroidx/compose/runtime/collection/MutableVector;", "recreateUnfoldedChildrenIfDirty", "", "childMeasurables", "Landroidx/compose/ui/layout/Measurable;", "getChildMeasurables$ui_release", "childLookaheadMeasurables", "getChildLookaheadMeasurables$ui_release", "unfoldedVirtualChildrenListDirty", "invalidateUnfoldedVirtualChildren", "_children", "get_children$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "updateChildrenIfDirty", "updateChildrenIfDirty$ui_release", "forEachChild", "block", "Lkotlin/Function1;", "forEachChildIndexed", "Lkotlin/Function2;", "children", "getChildren$ui_release", "_foldedParent", "parent", "getParent$ui_release", "value", "Landroidx/compose/ui/node/Owner;", "owner", "getOwner$ui_release", "()Landroidx/compose/ui/node/Owner;", "interopViewFactoryHolder", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/viewinterop/InteropViewFactoryHolder;", "getInteropViewFactoryHolder$ui_release", "()Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "setInteropViewFactoryHolder$ui_release", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;)V", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "getInteropView", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/InteropView;", "()Landroid/view/View;", "isAttached", ToygerFaceAlgorithmConfig.DEPTH, "getDepth$ui_release", "setDepth$ui_release", "layoutState", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadPassDelegate", "Landroidx/compose/ui/node/LookaheadPassDelegate;", "getLookaheadPassDelegate$ui_release", "()Landroidx/compose/ui/node/LookaheadPassDelegate;", "measurePassDelegate", "Landroidx/compose/ui/node/MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/MeasurePassDelegate;", "ignoreRemeasureRequests", "insertAt", "index", "instance", "insertAt$ui_release", "exceptionMessageForParentingOrOwnership", "", "onZSortedChildrenInvalidated", "onZSortedChildrenInvalidated$ui_release", "removeAt", "count", "removeAt$ui_release", "removeAll", "removeAll$ui_release", "onChildRemoved", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "move", "from", RemoteMessageConst.TO, "move$ui_release", "isTransparent", "isSemanticsInvalidated", "isSemanticsInvalidated$ui_release", "setSemanticsInvalidated$ui_release", "requestAutofill", "requestAutofill$ui_release", "invalidateSemantics", "invalidateSemantics$ui_release", "_semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "semanticsConfiguration", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "isCurrentlyCalculatingSemanticsConfiguration", "calculateSemanticsConfiguration", LynxViewpagerItem.BIND_ON_ATTACH, "attach$ui_release", "detach", "detach$ui_release", "_zSortedChildren", "zSortedChildrenInvalidated", "zSortedChildren", "getZSortedChildren$annotations", "()V", "getZSortedChildren", "isValidOwnerScope", "toString", "hasFixedInnerContentConstraints", "getHasFixedInnerContentConstraints$ui_release", "debugTreeToString", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "intrinsicsPolicy", "Landroidx/compose/ui/node/IntrinsicsPolicy;", "getOrCreateIntrinsicsPolicy", "minLookaheadIntrinsicWidth", "height", "minLookaheadIntrinsicHeight", "width", "maxLookaheadIntrinsicWidth", "maxLookaheadIntrinsicHeight", "minIntrinsicWidth", "minIntrinsicHeight", "maxIntrinsicWidth", "maxIntrinsicHeight", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "setViewConfiguration", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "Landroidx/compose/runtime/CompositionLocalMap;", "compositionLocalMap", "getCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "setCompositionLocalMap", "(Landroidx/compose/runtime/CompositionLocalMap;)V", "traceContext", "Landroidx/compose/runtime/tooling/CompositionErrorContext;", "getTraceContext", "()Landroidx/compose/runtime/tooling/CompositionErrorContext;", "rethrowWithComposeStackTrace", "", "e", "", "onDensityOrLayoutDirectionChanged", "getWidth", "getHeight", "alignmentLinesRequired", "getAlignmentLinesRequired$ui_release", "mDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getMDrawScope$ui_release", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "isPlaced", "isPlacedByParent", "placeOrder", "getPlaceOrder$ui_release", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "measuredByParentInLookahead", "getMeasuredByParentInLookahead$ui_release", "intrinsicsUsageByParent", "getIntrinsicsUsageByParent$ui_release", "setIntrinsicsUsageByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "previousIntrinsicsUsageByParent", "canMultiMeasure", "getCanMultiMeasure$ui_release$annotations", "getCanMultiMeasure$ui_release", "setCanMultiMeasure$ui_release", "nodes", "Landroidx/compose/ui/node/NodeChain;", "getNodes$ui_release", "()Landroidx/compose/ui/node/NodeChain;", "innerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "layoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "getLayoutDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "outerCoordinator", "getOuterCoordinator$ui_release", "zIndex", "", "getZIndex", "()F", "subcompositionsState", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "getSubcompositionsState$ui_release", "()Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "setSubcompositionsState$ui_release", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "_innerLayerCoordinator", "innerLayerCoordinatorIsDirty", "getInnerLayerCoordinatorIsDirty$ui_release", "setInnerLayerCoordinatorIsDirty$ui_release", "innerLayerCoordinator", "getInnerLayerCoordinator$ui_release", "invalidateLayer", "invalidateLayer$ui_release", "_modifier", "Landroidx/compose/ui/Modifier;", "pendingModifier", "applyingModifierOnAttach", "getApplyingModifierOnAttach$ui_release", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "applyModifier", "resetModifierState", "invalidateParentData", "invalidateParentData$ui_release", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "onAttach", "getOnAttach$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnAttach$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onDetach", "getOnDetach$ui_release", "setOnDetach$ui_release", "needsOnGloballyPositionedDispatch", "getNeedsOnGloballyPositionedDispatch$ui_release", "setNeedsOnGloballyPositionedDispatch$ui_release", "globallyPositionedObservers", "getGloballyPositionedObservers", "setGloballyPositionedObservers", "place", "x", "y", "place$ui_release", "replace", "replace$ui_release", "lookaheadReplace", "lookaheadReplace$ui_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "draw$ui_release", "hitTest", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "isInLayer", "hitTest-6fMxITs$ui_release", "(JLandroidx/compose/ui/node/HitTestResult;IZ)V", "hitTestSemantics", "hitSemanticsEntities", "hitTestSemantics-6fMxITs$ui_release", "rescheduleRemeasureOrRelayout", "it", "rescheduleRemeasureOrRelayout$ui_release", "requestRemeasure", "forceRequest", "scheduleMeasureAndLayout", "invalidateIntrinsics", "requestRemeasure$ui_release", "requestLookaheadRemeasure", "requestLookaheadRemeasure$ui_release", "invalidateMeasurements", "invalidateMeasurements$ui_release", "invalidateOnPositioned", "invalidateOnPositioned$ui_release", "invalidateOffsetFromRoot", "onCoordinatorPositionChanged", "onCoordinatorPositionChanged$ui_release", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "ignoreRemeasureRequests$ui_release", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "requestRelayout", "requestRelayout$ui_release", "requestLookaheadRelayout", "requestLookaheadRelayout$ui_release", "dispatchOnPositionedCallbacks", "dispatchOnPositionedCallbacks$ui_release", "getModifierInfo", "Landroidx/compose/ui/layout/ModifierInfo;", "invalidateLayers", "invalidateLayers$ui_release", "lookaheadRemeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lookaheadRemeasure-_Sx5XlM$ui_release", "remeasure", "remeasure-_Sx5XlM$ui_release", "measurePending", "getMeasurePending$ui_release", "layoutPending", "getLayoutPending$ui_release", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui_release", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui_release", "markLayoutPending", "markLayoutPending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui_release", "invalidateSubtree", "isRootOfInvalidation", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui_release", "forceRemeasure", "onLayoutComplete", "forEachCoordinator", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "forEachCoordinator$ui_release", "forEachCoordinatorIncludingInner", "forEachCoordinatorIncludingInner$ui_release", "clearSubtreeIntrinsicsUsage", "clearSubtreeIntrinsicsUsage$ui_release", "clearSubtreePlacementIntrinsicsUsage", "resetSubtreeIntrinsicsUsage", "resetSubtreeIntrinsicsUsage$ui_release", "parentInfo", "getParentInfo", "()Landroidx/compose/ui/semantics/SemanticsInfo;", "childrenInfo", "getChildrenInfo", "isDeactivated", "onReuse", "onDeactivate", "onRelease", "NoIntrinsicsMeasurePolicy", "Companion", "LayoutState", "UsageByParent", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LayoutNode implements ComposeNodeLifecycleCallback, Remeasurement, OwnerScope, LayoutInfo, SemanticsInfo, ComposeUiNode, InteroperableComposeUiNode, Owner.OnLayoutCompletedListener {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Function0<LayoutNode> Constructor = null;
    private static final ViewConfiguration DummyViewConfiguration = null;
    private static final NoIntrinsicsMeasurePolicy ErrorMeasurePolicy = null;
    public static final int NotPlacedPlaceOrder = Integer.MAX_VALUE;
    private static final Comparator<LayoutNode> ZComparator = null;
    private final MutableVectorWithMutationTracking<LayoutNode> _foldedChildren;
    private LayoutNode _foldedParent;
    private NodeCoordinator _innerLayerCoordinator;
    private Modifier _modifier;
    private SemanticsConfiguration _semanticsConfiguration;
    private MutableVector<LayoutNode> _unfoldedChildren;
    private final MutableVector<LayoutNode> _zSortedChildren;
    private boolean canMultiMeasure;
    private int compositeKeyHash;
    private CompositionLocalMap compositionLocalMap;
    private Density density;
    private int depth;
    private int globallyPositionedObservers;
    private boolean ignoreRemeasureRequests;
    private boolean innerLayerCoordinatorIsDirty;
    private AndroidViewHolder interopViewFactoryHolder;
    private IntrinsicsPolicy intrinsicsPolicy;
    private UsageByParent intrinsicsUsageByParent;
    private boolean isCurrentlyCalculatingSemanticsConfiguration;
    private boolean isDeactivated;
    private boolean isSemanticsInvalidated;
    private final boolean isVirtual;
    private boolean isVirtualLookaheadRoot;
    private long lastSize;
    private final LayoutNodeLayoutDelegate layoutDelegate;
    private LayoutDirection layoutDirection;
    private LayoutNode lookaheadRoot;
    private MeasurePolicy measurePolicy;
    private boolean needsOnGloballyPositionedDispatch;
    private final NodeChain nodes;
    private long offsetFromRoot;
    private Function1<? super Owner, Unit> onAttach;
    private Function1<? super Owner, Unit> onDetach;
    private long outerToInnerOffset;
    private boolean outerToInnerOffsetDirty;
    private Owner owner;
    private Modifier pendingModifier;
    private UsageByParent previousIntrinsicsUsageByParent;
    private int semanticsId;
    private LayoutNodeSubcompositionsState subcompositionsState;
    private boolean unfoldedVirtualChildrenListDirty;
    private ViewConfiguration viewConfiguration;
    private int virtualChildrenCount;
    private boolean zSortedChildrenInvalidated;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0013j\b\u0012\u0004\u0012\u00020\u000b`\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$Companion;", "", "<init>", "()V", "ErrorMeasurePolicy", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "NotPlacedPlaceOrder", "", "getNotPlacedPlaceOrder$ui_release$annotations", "Constructor", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "getConstructor$ui_release", "()Lkotlin/jvm/functions/Function0;", "DummyViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getDummyViewConfiguration$ui_release", "()Landroidx/compose/ui/platform/ViewConfiguration;", "ZComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getZComparator$ui_release", "()Ljava/util/Comparator;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ void getNotPlacedPlaceOrder$ui_release$annotations() {
        }

        public final Function0<LayoutNode> getConstructor$ui_release() {
            return LayoutNode.access$getConstructor$cp();
        }

        public final ViewConfiguration getDummyViewConfiguration$ui_release() {
            return LayoutNode.access$getDummyViewConfiguration$cp();
        }

        public final Comparator<LayoutNode> getZComparator$ui_release() {
            return LayoutNode.access$getZComparator$cp();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$LayoutState;", "", "<init>", "(Ljava/lang/String;I)V", "Measuring", "LookaheadMeasuring", "LayingOut", "LookaheadLayingOut", "Idle", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum LayoutState extends Enum<LayoutState> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ LayoutState[] $VALUES = null;
        public static final LayoutState Idle = null;
        public static final LayoutState LayingOut = null;
        public static final LayoutState LookaheadLayingOut = null;
        public static final LayoutState LookaheadMeasuring = null;
        public static final LayoutState Measuring = null;

        private static final /* synthetic */ LayoutState[] $values() {
            return new LayoutState[]{Measuring, LookaheadMeasuring, LayingOut, LookaheadLayingOut, Idle};
        }

        public static EnumEntries<LayoutState> getEntries() {
            return $ENTRIES;
        }

        static {
            Measuring = new LayoutState("Measuring", 0);
            LookaheadMeasuring = new LayoutState("LookaheadMeasuring", 1);
            LayingOut = new LayoutState("LayingOut", 2);
            LookaheadLayingOut = new LayoutState("LookaheadLayingOut", 3);
            Idle = new LayoutState("Idle", 4);
            LayoutState[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static LayoutState[] values() {
            return (LayoutState[]) $VALUES.clone();
        }

        public static LayoutState valueOf(String r100) {
            return (LayoutState) r27.a.a(LayoutState.class, r100);
        }

        private LayoutState(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b!\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u000e\u001a\u00020\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\"\u0010\u0010\u001a\u00020\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u0011\u001a\u00020\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "error", "", "<init>", "(Ljava/lang/String;)V", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {
        public static final int $stable = 0;
        private final String error;

        public NoIntrinsicsMeasurePolicy(String r100) {
            this.error = r100;
        }

        /* JADX INFO: renamed from: maxIntrinsicHeight, reason: collision with other method in class */
        public Void m6474maxIntrinsicHeight(IntrinsicMeasureScope r100, List<? extends IntrinsicMeasurable> r101, int r102) {
            throw new IllegalStateException(this.error.toString());
        }

        /* JADX INFO: renamed from: maxIntrinsicWidth, reason: collision with other method in class */
        public Void m6475maxIntrinsicWidth(IntrinsicMeasureScope r100, List<? extends IntrinsicMeasurable> r101, int r102) {
            throw new IllegalStateException(this.error.toString());
        }

        /* JADX INFO: renamed from: minIntrinsicHeight, reason: collision with other method in class */
        public Void m6476minIntrinsicHeight(IntrinsicMeasureScope r100, List<? extends IntrinsicMeasurable> r101, int r102) {
            throw new IllegalStateException(this.error.toString());
        }

        /* JADX INFO: renamed from: minIntrinsicWidth, reason: collision with other method in class */
        public Void m6477minIntrinsicWidth(IntrinsicMeasureScope r100, List<? extends IntrinsicMeasurable> r101, int r102) {
            throw new IllegalStateException(this.error.toString());
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r100, List r101, int r102) {
            return ((Number) m6474maxIntrinsicHeight(r100, r101, r102)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r100, List r101, int r102) {
            return ((Number) m6475maxIntrinsicWidth(r100, r101, r102)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r100, List r101, int r102) {
            return ((Number) m6476minIntrinsicHeight(r100, r101, r102)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r100, List r101, int r102) {
            return ((Number) m6477minIntrinsicWidth(r100, r101, r102)).intValue();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "", "<init>", "(Ljava/lang/String;I)V", "InMeasureBlock", "InLayoutBlock", "NotUsed", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum UsageByParent extends Enum<UsageByParent> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ UsageByParent[] $VALUES = null;
        public static final UsageByParent InLayoutBlock = null;
        public static final UsageByParent InMeasureBlock = null;
        public static final UsageByParent NotUsed = null;

        private static final /* synthetic */ UsageByParent[] $values() {
            return new UsageByParent[]{InMeasureBlock, InLayoutBlock, NotUsed};
        }

        public static EnumEntries<UsageByParent> getEntries() {
            return $ENTRIES;
        }

        static {
            InMeasureBlock = new UsageByParent("InMeasureBlock", 0);
            InLayoutBlock = new UsageByParent("InLayoutBlock", 1);
            NotUsed = new UsageByParent("NotUsed", 2);
            UsageByParent[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static UsageByParent[] values() {
            return (UsageByParent[]) $VALUES.clone();
        }

        public static UsageByParent valueOf(String r100) {
            return (UsageByParent) r27.a.a(UsageByParent.class, r100);
        }

        private UsageByParent(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[LayoutState.values().length];
            r100[LayoutState.Idle.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            $EnumSwitchMapping$0 = r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutNode() {
        boolean r100 = false;
        Object[] r101 = 0 == true ? 1 : 0;
        this(r100, r101, 3, null);
    }

    public static /* synthetic */ int a(LayoutNode r100, LayoutNode r101) {
        return ZComparator$lambda$42(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, androidx.compose.ui.semantics.SemanticsConfiguration] */
    private final SemanticsConfiguration calculateSemanticsConfiguration() {
        this.isCurrentlyCalculatingSemanticsConfiguration = true;
        final kotlin.jvm.internal.Ref.ObjectRef r100 = new kotlin.jvm.internal.Ref.ObjectRef();
        r100.element = new SemanticsConfiguration();
        LayoutNodeKt.requireOwner(this).getSnapshotObserver().observeSemanticsReads$ui_release(this, new AnonymousClass1(this, r100));
        this.isCurrentlyCalculatingSemanticsConfiguration = false;
        return (SemanticsConfiguration) r100.element;
    }

    @Deprecated(message = "Temporary API to support ConstraintLayout prototyping.")
    public static /* synthetic */ void getCanMultiMeasure$ui_release$annotations() {
    }

    public static /* synthetic */ void getZSortedChildren$annotations() {
    }

    public final void onCoordinatorPositionChanged$ui_release() {
        this.outerToInnerOffsetDirty = true;
        MutableVector<LayoutNode> r100 = get_children$ui_release();
        LayoutNode[] r101 = r100.content;
        int r102 = r100.getSize();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101[r103].invalidateOffsetFromRoot();
        r103 = r103 + 1;
        goto L3
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        ErrorMeasurePolicy = new LayoutNode$Companion$ErrorMeasurePolicy$1();
        Constructor = LayoutNode$Companion$Constructor$1.INSTANCE;
        DummyViewConfiguration = new LayoutNode$Companion$DummyViewConfiguration$1();
        ZComparator = new a();
    }

    private final void clearSubtreePlacementIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> r100 = get_children$ui_release();
        LayoutNode[] r101 = r100.content;
        int r102 = r100.getSize();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        LayoutNode r104 = r101[r103];
        if (r104.intrinsicsUsageByParent != UsageByParent.InLayoutBlock) goto L7;
        r104.clearSubtreePlacementIntrinsicsUsage();
    L7:
        r103 = r103 + 1;
        goto L3
    }

    private final IntrinsicsPolicy getOrCreateIntrinsicsPolicy() {
        IntrinsicsPolicy r100 = this.intrinsicsPolicy;
        if (r100 != null) goto L6;
        IntrinsicsPolicy r101 = new IntrinsicsPolicy(this, getMeasurePolicy());
        this.intrinsicsPolicy = r101;
        return r101;
    L6:
        return r100;
    }

    private final void invalidateOffsetFromRoot() {
        long r100 = this.offsetFromRoot;
        IntOffset.Companion r101 = IntOffset.Companion;
        if (IntOffset.m7675equalsimpl0(r100, r101.m7686getMaxnOccac()) == false) goto L5;
        return;
    L5:
        this.offsetFromRoot = r101.m7686getMaxnOccac();
        MutableVector<LayoutNode> r102 = get_children$ui_release();
        LayoutNode[] r103 = r102.content;
        int r104 = r102.getSize();
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L8;
        r103[r105].invalidateOffsetFromRoot();
        r105 = r105 + 1;
        goto L6
    }

    private final void invalidateUnfoldedVirtualChildren() {
        if (this.virtualChildrenCount <= 0) goto L6;
        this.unfoldedVirtualChildrenListDirty = true;
    L6:
        if (this.isVirtual == false) goto L11;
        LayoutNode r100 = this._foldedParent;
        if (r100 == null) goto L12;
        r100.invalidateUnfoldedVirtualChildren();
        return;
    L12:
        return;
    }

    private final void recreateUnfoldedChildrenIfDirty() {
        if (this.unfoldedVirtualChildrenListDirty == false) goto L19;
        int r100 = 0;
        this.unfoldedVirtualChildrenListDirty = false;
        MutableVector<LayoutNode> r101 = this._unfoldedChildren;
        if (r101 != null) goto L7;
        r101 = new MutableVector(new LayoutNode[16], 0);
        this._unfoldedChildren = r101;
    L7:
        r101.clear();
        MutableVector<LayoutNode> r102 = this._foldedChildren.getVector();
        LayoutNode[] r103 = r102.content;
        int r104 = r102.getSize();
    L8:
        if (r100 >= r104) goto L14;
        LayoutNode r105 = r103[r100];
        if (r105.isVirtual == false) goto L12;
        MutableVector<LayoutNode> r106 = r105.get_children$ui_release();
        r101.addAll(r101.getSize(), r106);
    L13:
        r100 = r100 + 1;
        goto L8
    L12:
        r101.add(r105);
        goto L13
    L14:
        this.layoutDelegate.markChildrenDirty();
        return;
    }

    private final void resetModifierState() {
        this.nodes.resetState$ui_release();
    }

    public final void clearSubtreeIntrinsicsUsage$ui_release() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> r100 = get_children$ui_release();
        LayoutNode[] r101 = r100.content;
        int r102 = r100.getSize();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        LayoutNode r104 = r101[r103];
        if (r104.intrinsicsUsageByParent == UsageByParent.NotUsed) goto L7;
        r104.clearSubtreeIntrinsicsUsage$ui_release();
    L7:
        r103 = r103 + 1;
        goto L3
    }

    public final void detach$ui_release() {
        Owner r100 = this.owner;
        String r101 = null;
        if (r100 != null) goto L9;
        StringBuilder r102 = new StringBuilder("Cannot detach node that is already detached!  Tree: ");
        LayoutNode r103 = getParent$ui_release();
        if (r103 == null) goto L7;
        r101 = debugTreeToString$default(r103, 0, 1, null);
    L7:
        r102.append(r101);
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(r102.toString());
        throw new KotlinNothingValueException();
    L9:
        LayoutNode r104 = getParent$ui_release();
        if (r104 == null) goto L14;
        r104.invalidateLayer$ui_release();
        r104.invalidateMeasurements$ui_release();
        MeasurePassDelegate r105 = getMeasurePassDelegate$ui_release();
        UsageByParent r106 = UsageByParent.NotUsed;
        r105.setMeasuredByParent$ui_release(r106);
        LookaheadPassDelegate r107 = getLookaheadPassDelegate$ui_release();
        if (r107 == null) goto L14;
        r107.setMeasuredByParent$ui_release(r106);
    L14:
        this.layoutDelegate.resetAlignmentLines();
        NodeCoordinator r108 = getOuterCoordinator$ui_release();
        NodeCoordinator r109 = getInnerCoordinator$ui_release().getWrapped$ui_release();
    L16:
        if (Intrinsics.areEqual(r108, r109) == true) goto L19;
        if (r108 == null) goto L19;
        r108.onLayoutNodeDetach();
        r108 = r108.getWrapped$ui_release();
    L19:
        Function1<? super Owner, Unit> r110 = this.onDetach;
        if (r110 == null) goto L23;
        r110.invoke(r100);
    L23:
        if (ComposeUiFlags.isSemanticAutofillEnabled == false) goto L25;
    L27:
        this.nodes.runDetachLifecycle$ui_release();
        access$setIgnoreRemeasureRequests$p(this, true);
        MutableVector<LayoutNode> r111 = this._foldedChildren.getVector();
        LayoutNode[] r112 = r111.content;
        int r113 = r111.getSize();
        int r114 = 0;
    L28:
        if (r114 >= r113) goto L30;
        r112[r114].detach$ui_release();
        r114 = r114 + 1;
        goto L28
    L30:
        Unit r115 = Unit.INSTANCE;
        access$setIgnoreRemeasureRequests$p(this, false);
        this.nodes.markAsDetached$ui_release();
        r100.onDetach(this);
        this.owner = null;
        this.offsetFromRoot = IntOffset.Companion.m7686getMaxnOccac();
        setLookaheadRoot(null);
        this.depth = 0;
        getMeasurePassDelegate$ui_release().onNodeDetached();
        LookaheadPassDelegate r116 = getLookaheadPassDelegate$ui_release();
        if (r116 == null) goto L34;
        r116.onNodeDetached();
    L34:
        if (ComposeUiFlags.isSemanticAutofillEnabled == true) goto L36;
        return;
    L36:
        if (this.nodes.m6517hasH91voCI$ui_release(NodeKind.m6556constructorimpl(8)) == false) goto L43;
        SemanticsConfiguration r117 = this._semanticsConfiguration;
        this._semanticsConfiguration = null;
        this.isSemanticsInvalidated = false;
        r100.getSemanticsOwner().notifySemanticsChange$ui_release(this, r117);
        r100.onSemanticsChange();
        return;
    L43:
        return;
    L25:
        if (this.nodes.m6517hasH91voCI$ui_release(NodeKind.m6556constructorimpl(8)) == false) goto L27;
        invalidateSemantics$ui_release();
        goto L27
    }

    @Override // androidx.compose.ui.layout.Remeasurement
    public void forceRemeasure() {
        if (this.lookaheadRoot == null) goto L5;
        requestLookaheadRemeasure$ui_release$default(this, false, false, false, 5, null);
    L6:
        Constraints r100 = this.layoutDelegate.m6480getLastConstraintsDWUhwKw();
        if (r100 == null) goto L11;
        Owner r101 = this.owner;
        if (r101 == null) goto L15;
        r101.mo6619measureAndLayout0kLqBqw(this, r100.m7493unboximpl());
        return;
    L15:
        return;
    L11:
        Owner r102 = this.owner;
        if (r102 == null) goto L17;
        Owner.CC.measureAndLayout$default(r102, false, 1, null);
        return;
    L17:
        return;
    L5:
        requestRemeasure$ui_release$default(this, false, false, false, 5, null);
        goto L6
    }

    public final boolean getAlignmentLinesRequired$ui_release() {
        LayoutNodeLayoutDelegate r100 = this.layoutDelegate;
        if (r100.getAlignmentLinesOwner$ui_release().getAlignmentLines().getRequired$ui_release() == true) goto L16;
        AlignmentLinesOwner r101 = r100.getLookaheadAlignmentLinesOwner$ui_release();
        if (r101 == null) goto L11;
        AlignmentLines r102 = r101.getAlignmentLines();
        if (r102 == null) goto L11;
        if (r102.getRequired$ui_release() != true) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        r103 = false;
        goto L12
    L16:
        return true;
    }

    public final boolean getApplyingModifierOnAttach$ui_release() {
        if (this.pendingModifier == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final List<LayoutNode> getFoldedChildren$ui_release() {
        return this._foldedChildren.getVector().asMutableList();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int getHeight() {
        return this.layoutDelegate.getHeight$ui_release();
    }

    public final NodeCoordinator getInnerCoordinator$ui_release() {
        return this.nodes.getInnerCoordinator$ui_release();
    }

    public final NodeCoordinator getInnerLayerCoordinator$ui_release() {
        if (this.innerLayerCoordinatorIsDirty == false) goto L15;
        NodeCoordinator r100 = getInnerCoordinator$ui_release();
        NodeCoordinator r101 = getOuterCoordinator$ui_release().getWrappedBy$ui_release();
        this._innerLayerCoordinator = null;
    L6:
        if (Intrinsics.areEqual(r100, r101) == true) goto L15;
        if (r100 == null) goto L9;
        OwnedLayer r102 = r100.getLayer();
    L10:
        if (r102 != null) goto L11;
        if (r100 != null) goto L13;
        r100 = null;
        goto L6
    L13:
        r100 = r100.getWrappedBy$ui_release();
        goto L6
    L11:
        this._innerLayerCoordinator = r100;
        goto L15
    L9:
        r102 = null;
    L15:
        NodeCoordinator r103 = this._innerLayerCoordinator;
        if (r103 != null) goto L18;
    L22:
        return r103;
    L18:
        if (r103.getLayer() != null) goto L22;
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("layer was not set");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.node.InteroperableComposeUiNode
    public View getInteropView() {
        AndroidViewHolder r100 = this.interopViewFactoryHolder;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getInteropView();
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutDelegate.getLayoutPending$ui_release();
    }

    public final LayoutState getLayoutState$ui_release() {
        return this.layoutDelegate.getLayoutState$ui_release();
    }

    public final boolean getLookaheadLayoutPending$ui_release() {
        return this.layoutDelegate.getLookaheadLayoutPending$ui_release();
    }

    public final boolean getLookaheadMeasurePending$ui_release() {
        return this.layoutDelegate.getLookaheadMeasurePending$ui_release();
    }

    public final LookaheadPassDelegate getLookaheadPassDelegate$ui_release() {
        return this.layoutDelegate.getLookaheadPassDelegate$ui_release();
    }

    public final MeasurePassDelegate getMeasurePassDelegate$ui_release() {
        return this.layoutDelegate.getMeasurePassDelegate$ui_release();
    }

    public final boolean getMeasurePending$ui_release() {
        return this.layoutDelegate.getMeasurePending$ui_release();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public List<ModifierInfo> getModifierInfo() {
        return this.nodes.getModifierInfo();
    }

    public final NodeCoordinator getOuterCoordinator$ui_release() {
        return this.nodes.getOuterCoordinator$ui_release();
    }

    public final LayoutNode getParent$ui_release() {
        LayoutNode r100 = this._foldedParent;
    L3:
        boolean r101 = false;
        if (r100 != null) goto L6;
    L8:
        if (r101 == false) goto L10;
        r100 = r100._foldedParent;
        goto L3
    L10:
        return r100;
    L6:
        if (r100.isVirtual != true) goto L8;
        r101 = true;
        goto L8
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int getWidth() {
        return this.layoutDelegate.getWidth$ui_release();
    }

    public final MutableVector<LayoutNode> getZSortedChildren() {
        if (this.zSortedChildrenInvalidated == false) goto L6;
        this._zSortedChildren.clear();
        MutableVector<LayoutNode> r100 = this._zSortedChildren;
        MutableVector<LayoutNode> r101 = get_children$ui_release();
        r100.addAll(r100.getSize(), r101);
        this._zSortedChildren.sortWith(ZComparator);
        this.zSortedChildrenInvalidated = false;
    L6:
        return this._zSortedChildren;
    }

    public final void invalidateMeasurements$ui_release() {
        if (this.isVirtual == false) goto L9;
        LayoutNode r100 = getParent$ui_release();
        if (r100 == null) goto L13;
        r100.invalidateMeasurements$ui_release();
        return;
    L13:
        return;
    L9:
        if (this.lookaheadRoot == null) goto L11;
        requestLookaheadRemeasure$ui_release$default(this, false, false, false, 7, null);
        return;
    L11:
        requestRemeasure$ui_release$default(this, false, false, false, 7, null);
    }

    public final void invalidateOnPositioned$ui_release() {
        if (this.globallyPositionedObservers != 0) goto L5;
        return;
    L5:
        if (getLayoutPending$ui_release() == false) goto L7;
        return;
    L7:
        if (getMeasurePending$ui_release() == false) goto L9;
        return;
    L9:
        if (this.needsOnGloballyPositionedDispatch == true) goto L16;
        LayoutNodeKt.requireOwner(this).requestOnPositionedCallback(this);
        return;
    }

    public final void invalidateParentData$ui_release() {
        this.layoutDelegate.invalidateParentData();
    }

    public final void invalidateSemantics$ui_release() {
        if (this.isCurrentlyCalculatingSemanticsConfiguration == false) goto L6;
        return;
    L6:
        if (ComposeUiFlags.isSemanticAutofillEnabled == true) goto L9;
        this._semanticsConfiguration = null;
        LayoutNodeKt.requireOwner(this).onSemanticsChange();
        return;
    L9:
        if (this.nodes.isUpdating$ui_release() == false) goto L11;
    L14:
        this.isSemanticsInvalidated = true;
        return;
    L11:
        if (getApplyingModifierOnAttach$ui_release() == true) goto L14;
        SemanticsConfiguration r100 = this._semanticsConfiguration;
        this._semanticsConfiguration = calculateSemanticsConfiguration();
        this.isSemanticsInvalidated = false;
        Owner r101 = LayoutNodeKt.requireOwner(this);
        r101.getSemanticsOwner().notifySemanticsChange$ui_release(this, r100);
        r101.onSemanticsChange();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public boolean isAttached() {
        if (this.owner == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void lookaheadReplace$ui_release() {
        if (this.intrinsicsUsageByParent != UsageByParent.NotUsed) goto L5;
        clearSubtreePlacementIntrinsicsUsage();
    L5:
        LookaheadPassDelegate r100 = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(r100);
        r100.replace();
    }

    public final void markLayoutPending$ui_release() {
        this.layoutDelegate.markLayoutPending$ui_release();
    }

    public final void markLookaheadLayoutPending$ui_release() {
        this.layoutDelegate.markLookaheadLayoutPending$ui_release();
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.layoutDelegate.markLookaheadMeasurePending$ui_release();
    }

    public final void markMeasurePending$ui_release() {
        this.layoutDelegate.markMeasurePending$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onDeactivate() {
        AndroidViewHolder r100 = this.interopViewFactoryHolder;
        if (r100 == null) goto L5;
        r100.onDeactivate();
    L5:
        LayoutNodeSubcompositionsState r101 = this.subcompositionsState;
        if (r101 == null) goto L8;
        r101.onDeactivate();
    L8:
        this.isDeactivated = true;
        resetModifierState();
        if (isAttached() == true) goto L11;
    L14:
        Owner r102 = this.owner;
        if (r102 == null) goto L18;
        r102.onLayoutNodeDeactivated(this);
        return;
    L18:
        return;
    L11:
        if (ComposeUiFlags.isSemanticAutofillEnabled == true) goto L13;
        invalidateSemantics$ui_release();
        goto L14
    L13:
        this._semanticsConfiguration = null;
        this.isSemanticsInvalidated = false;
        goto L14
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onRelease() {
        AndroidViewHolder r100 = this.interopViewFactoryHolder;
        if (r100 == null) goto L5;
        r100.onRelease();
    L5:
        LayoutNodeSubcompositionsState r101 = this.subcompositionsState;
        if (r101 == null) goto L8;
        r101.onRelease();
    L8:
        NodeCoordinator r102 = getOuterCoordinator$ui_release();
        NodeCoordinator r103 = getInnerCoordinator$ui_release().getWrapped$ui_release();
    L10:
        if (Intrinsics.areEqual(r102, r103) == true) goto L13;
        if (r102 == null) goto L16;
        r102.onRelease();
        r102 = r102.getWrapped$ui_release();
        goto L10
    L16:
        return;
    }

    public final void onZSortedChildrenInvalidated$ui_release() {
        if (this.isVirtual == false) goto L7;
        LayoutNode r100 = getParent$ui_release();
        if (r100 == null) goto L9;
        r100.onZSortedChildrenInvalidated$ui_release();
        return;
    L9:
        return;
    L7:
        this.zSortedChildrenInvalidated = true;
    }

    public final void removeAll$ui_release() {
        int r100 = this._foldedChildren.getVector().getSize();
    L3:
        r100 = r100 - 1;
        if ((-1) >= r100) goto L6;
        onChildRemoved(this._foldedChildren.getVector().content[r100]);
        goto L3
    L6:
        this._foldedChildren.clear();
    }

    public final void replace$ui_release() {
        if (this.intrinsicsUsageByParent != UsageByParent.NotUsed) goto L5;
        clearSubtreePlacementIntrinsicsUsage();
    L5:
        getMeasurePassDelegate$ui_release().replace();
    }

    public final void requestAutofill$ui_release() {
        if (this.isCurrentlyCalculatingSemanticsConfiguration == false) goto L5;
        return;
    L5:
        LayoutNodeKt.requireOwner(this).requestAutofill(this);
    }

    public String toString() {
        return JvmActuals_jvmKt.simpleIdentityToString(this, null) + " children: " + getChildren$ui_release().size() + " measurePolicy: " + getMeasurePolicy() + " deactivated: " + isDeactivated();
    }

    public final void updateChildrenIfDirty$ui_release() {
        if (this.virtualChildrenCount <= 0) goto L6;
        recreateUnfoldedChildrenIfDirty();
        return;
    }

    private final CompositionErrorContext getTraceContext() {
        return (CompositionErrorContext) getCompositionLocalMap().get(CompositionErrorContextKt.getLocalCompositionErrorContext());
    }

    private final float getZIndex() {
        return getMeasurePassDelegate$ui_release().getZIndex$ui_release();
    }

    private final void onDensityOrLayoutDirectionChanged() {
        invalidateMeasurements$ui_release();
        LayoutNode r100 = getParent$ui_release();
        if (r100 == null) goto L5;
        r100.invalidateLayer$ui_release();
    L5:
        invalidateLayers$ui_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6 */
    public final void dispatchOnPositionedCallbacks$ui_release() {
        if (getLayoutState$ui_release() == LayoutState.Idle) goto L5;
        return;
    L5:
        if (getLayoutPending$ui_release() == false) goto L7;
        return;
    L7:
        if (getMeasurePending$ui_release() == false) goto L9;
        return;
    L9:
        if (isDeactivated() == false) goto L12;
        return;
    L12:
        if (isPlaced() == true) goto L14;
        return;
    L14:
        NodeChain r100 = this.nodes;
        int r101 = NodeKind.m6556constructorimpl(256);
        if ((NodeChain.access$getAggregateChildKindSet(r100) & r101) == 0) goto L71;
        Modifier.Node r102 = r100.getHead$ui_release();
    L17:
        if (r102 == null) goto L73;
        if ((r102.getKindSet$ui_release() & r101) == 0) goto L52;
        Modifier.Node r103 = r102;
        MutableVector r104 = null;
    L21:
        if (r103 == 0) goto L52;
        if ((r103 instanceof GlobalPositionAwareModifierNode) == true) goto L24;
        if ((r103.getKindSet$ui_release() & r101) == 0) goto L28;
        boolean r105 = true;
    L29:
        if (r105 == false) goto L50;
        if ((r103 instanceof DelegatingNode) == false) goto L50;
        Modifier.Node r106 = ((DelegatingNode) r103).getDelegate$ui_release();
        int r107 = 0;
        r103 = r103;
    L33:
        if (r106 == null) goto L48;
        if ((r106.getKindSet$ui_release() & r101) == 0) goto L37;
        boolean r110 = true;
    L38:
        if (r110 == false) goto L47;
        r107 = r107 + 1;
        if (r107 != 1) goto L42;
        r103 = r106;
        goto L47
    L42:
        if (r104 != null) goto L44;
        r104 = new MutableVector(new Modifier.Node[16], 0);
    L44:
        if (r103 == 0) goto L46;
        r104.add(r103);
        r103 = 0;
    L46:
        r104.add(r106);
    L47:
        r106 = r106.getChild$ui_release();
        r103 = r103;
        goto L33
    L37:
        r110 = false;
        goto L38
    L48:
        if (r107 == 1) goto L21;
    L50:
        r103 = DelegatableNodeKt.access$pop(r104);
        goto L21
    L28:
        r105 = false;
        goto L29
    L24:
        GlobalPositionAwareModifierNode r108 = (GlobalPositionAwareModifierNode) r103;
        r108.onGloballyPositioned(DelegatableNodeKt.m6409requireCoordinator64DMado(r108, NodeKind.m6556constructorimpl(256)));
    L52:
        if ((r102.getAggregateChildKindSet$ui_release() & r101) == 0) goto L74;
        r102 = r102.getChild$ui_release();
        goto L17
    L74:
        return;
    L73:
        return;
    }

    public final List<Measurable> getChildLookaheadMeasurables$ui_release() {
        LookaheadPassDelegate r100 = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(r100);
        return r100.getChildDelegates$ui_release();
    }

    public final List<Measurable> getChildMeasurables$ui_release() {
        return getMeasurePassDelegate$ui_release().getChildDelegates$ui_release();
    }

    public final List<LayoutNode> getChildren$ui_release() {
        return get_children$ui_release().asMutableList();
    }

    @Override // androidx.compose.ui.semantics.SemanticsInfo
    public List<SemanticsInfo> getChildrenInfo() {
        return getChildren$ui_release();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public LayoutCoordinates getCoordinates() {
        return getInnerCoordinator$ui_release();
    }

    public final boolean getHasFixedInnerContentConstraints$ui_release() {
        long r100 = getInnerCoordinator$ui_release().m6540getLastMeasurementConstraintsmsEJaDk$ui_release();
        if (Constraints.m7485getHasFixedWidthimpl(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (Constraints.m7484getHasFixedHeightimpl(r100) == false) goto L7;
        return true;
    }

    public final LayoutNodeDrawScope getMDrawScope$ui_release() {
        return LayoutNodeKt.requireOwner(this).getSharedDrawScope();
    }

    public final UsageByParent getMeasuredByParent$ui_release() {
        return getMeasurePassDelegate$ui_release().getMeasuredByParent$ui_release();
    }

    public final UsageByParent getMeasuredByParentInLookahead$ui_release() {
        LookaheadPassDelegate r100 = getLookaheadPassDelegate$ui_release();
        if (r100 == null) goto L7;
        UsageByParent r101 = r100.getMeasuredByParent$ui_release();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return UsageByParent.NotUsed;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public /* bridge */ /* synthetic */ LayoutInfo getParentInfo() {
        return getParentInfo();
    }

    public final int getPlaceOrder$ui_release() {
        return getMeasurePassDelegate$ui_release().getPlaceOrder$ui_release();
    }

    @Override // androidx.compose.ui.semantics.SemanticsInfo
    public SemanticsConfiguration getSemanticsConfiguration() {
        if (isAttached() == true) goto L5;
        return null;
    L5:
        if (isDeactivated() == false) goto L7;
        return null;
    L7:
        if (this.nodes.m6517hasH91voCI$ui_release(NodeKind.m6556constructorimpl(8)) == true) goto L10;
        return null;
    L10:
        if (ComposeUiFlags.isSemanticAutofillEnabled == true) goto L15;
        if (this._semanticsConfiguration != null) goto L15;
        this._semanticsConfiguration = calculateSemanticsConfiguration();
    L15:
        return this._semanticsConfiguration;
    }

    public final MutableVector<LayoutNode> get_children$ui_release() {
        updateChildrenIfDirty$ui_release();
        if (this.virtualChildrenCount == 0) goto L7;
        MutableVector<LayoutNode> r100 = this._unfoldedChildren;
        Intrinsics.checkNotNull(r100);
        return r100;
    L7:
        return this._foldedChildren.getVector();
    }

    public final void invalidateLayer$ui_release() {
        NodeCoordinator r100 = getInnerLayerCoordinator$ui_release();
        if (r100 == null) goto L5;
        r100.invalidateLayer();
        return;
    L5:
        LayoutNode r101 = getParent$ui_release();
        if (r101 == null) goto L10;
        r101.invalidateLayer$ui_release();
        return;
    }

    public final void invalidateLayers$ui_release() {
        NodeCoordinator r100 = getOuterCoordinator$ui_release();
        NodeCoordinator r101 = getInnerCoordinator$ui_release();
    L3:
        if (r100 == r101) goto L8;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
        LayoutModifierNodeCoordinator r102 = (LayoutModifierNodeCoordinator) r100;
        OwnedLayer r103 = r102.getLayer();
        if (r103 == null) goto L7;
        r103.invalidate();
    L7:
        r100 = r102.getWrapped$ui_release();
        goto L3
    L8:
        OwnedLayer r104 = getInnerCoordinator$ui_release().getLayer();
        if (r104 == null) goto L15;
        r104.invalidate();
        return;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public boolean isPlaced() {
        return getMeasurePassDelegate$ui_release().isPlaced();
    }

    public final boolean isPlacedByParent() {
        return getMeasurePassDelegate$ui_release().isPlacedByParent();
    }

    public final Boolean isPlacedInLookahead() {
        LookaheadPassDelegate r100 = getLookaheadPassDelegate$ui_release();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r100.isPlaced());
    }

    @Override // androidx.compose.ui.semantics.SemanticsInfo
    public boolean isTransparent() {
        return getOuterCoordinator$ui_release().isTransparent();
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return isAttached();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // androidx.compose.ui.node.Owner.OnLayoutCompletedListener
    public void onLayoutComplete() {
        NodeCoordinator r100 = getInnerCoordinator$ui_release();
        int r101 = NodeKind.m6556constructorimpl(128);
        boolean r102 = NodeKindKt.m6565getIncludeSelfInTraversalH91voCI(r101);
        Modifier.Node r103 = r100.getTail();
        if (r102 == true) goto L8;
        r103 = r103.getParent$ui_release();
        if (r103 != null) goto L8;
        return;
    L8:
        Modifier.Node r104 = NodeCoordinator.access$headNode(r100, r102);
    L9:
        if (r104 == null) goto L63;
        if ((r104.getAggregateChildKindSet$ui_release() & r101) == 0) goto L64;
        if ((r104.getKindSet$ui_release() & r101) == 0) goto L45;
        Modifier.Node r105 = r104;
        MutableVector r106 = null;
    L15:
        if (r105 == 0) goto L45;
        if ((r105 instanceof LayoutAwareModifierNode) == true) goto L18;
        if ((r105.getKindSet$ui_release() & r101) == 0) goto L22;
        boolean r107 = true;
    L23:
        if (r107 == false) goto L44;
        if ((r105 instanceof DelegatingNode) == false) goto L44;
        Modifier.Node r108 = ((DelegatingNode) r105).getDelegate$ui_release();
        int r109 = 0;
        r105 = r105;
    L27:
        if (r108 == null) goto L42;
        if ((r108.getKindSet$ui_release() & r101) == 0) goto L31;
        boolean r110 = true;
    L32:
        if (r110 == false) goto L41;
        r109 = r109 + 1;
        if (r109 != 1) goto L36;
        r105 = r108;
        goto L41
    L36:
        if (r106 != null) goto L38;
        r106 = new MutableVector(new Modifier.Node[16], 0);
    L38:
        if (r105 == 0) goto L40;
        r106.add(r105);
        r105 = 0;
    L40:
        r106.add(r108);
    L41:
        r108 = r108.getChild$ui_release();
        r105 = r105;
        goto L27
    L31:
        r110 = false;
        goto L32
    L42:
        if (r109 == 1) goto L15;
    L44:
        r105 = DelegatableNodeKt.access$pop(r106);
        goto L15
    L22:
        r107 = false;
        goto L23
    L18:
        ((LayoutAwareModifierNode) r105).onPlaced(getInnerCoordinator$ui_release());
    L45:
        if (r104 == r103) goto L65;
        r104 = r104.getChild$ui_release();
        goto L9
    L65:
        return;
    L64:
        return;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onReuse() {
        if (isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalArgumentException("onReuse is only expected on attached node");
    L5:
        AndroidViewHolder r100 = this.interopViewFactoryHolder;
        if (r100 == null) goto L8;
        r100.onReuse();
    L8:
        LayoutNodeSubcompositionsState r101 = this.subcompositionsState;
        if (r101 == null) goto L11;
        r101.onReuse();
    L11:
        this.isCurrentlyCalculatingSemanticsConfiguration = false;
        if (isDeactivated() == false) goto L16;
        this.isDeactivated = false;
        if (ComposeUiFlags.isSemanticAutofillEnabled == true) goto L17;
        invalidateSemantics$ui_release();
    L17:
        int r102 = getSemanticsId();
        setSemanticsId(SemanticsModifierKt.generateSemanticsId());
        Owner r103 = this.owner;
        if (r103 == null) goto L20;
        r103.onPreLayoutNodeReused(this, r102);
    L20:
        this.nodes.markAsAttached();
        this.nodes.runAttachLifecycle();
        if (ComposeUiFlags.isSemanticAutofillEnabled == true) goto L23;
    L25:
        rescheduleRemeasureOrRelayout$ui_release(this);
        Owner r104 = this.owner;
        if (r104 == null) goto L29;
        r104.onPostLayoutNodeReused(this, r102);
        return;
    L29:
        return;
    L23:
        if (this.nodes.m6517hasH91voCI$ui_release(NodeKind.m6556constructorimpl(8)) == false) goto L25;
        invalidateSemantics$ui_release();
        goto L25
    L16:
        resetModifierState();
        goto L17
    }

    public final void resetSubtreeIntrinsicsUsage$ui_release() {
        MutableVector<LayoutNode> r100 = get_children$ui_release();
        LayoutNode[] r101 = r100.content;
        int r102 = r100.getSize();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        LayoutNode r104 = r101[r103];
        UsageByParent r105 = r104.previousIntrinsicsUsageByParent;
        r104.intrinsicsUsageByParent = r105;
        if (r105 == UsageByParent.NotUsed) goto L7;
        r104.resetSubtreeIntrinsicsUsage$ui_release();
    L7:
        r103 = r103 + 1;
        goto L3
    }

    public static final /* synthetic */ Function0 access$getConstructor$cp() {
        return Constructor;
    }

    public static final /* synthetic */ ViewConfiguration access$getDummyViewConfiguration$cp() {
        return DummyViewConfiguration;
    }

    public static final /* synthetic */ Comparator access$getZComparator$cp() {
        return ZComparator;
    }

    public final boolean getCanMultiMeasure$ui_release() {
        return this.canMultiMeasure;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public int getCompositeKeyHash() {
        return this.compositeKeyHash;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public CompositionLocalMap getCompositionLocalMap() {
        return this.compositionLocalMap;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo, androidx.compose.ui.node.ComposeUiNode
    public Density getDensity() {
        return this.density;
    }

    public final int getDepth$ui_release() {
        return this.depth;
    }

    public final int getGloballyPositionedObservers() {
        return this.globallyPositionedObservers;
    }

    public final boolean getInnerLayerCoordinatorIsDirty$ui_release() {
        return this.innerLayerCoordinatorIsDirty;
    }

    public final AndroidViewHolder getInteropViewFactoryHolder$ui_release() {
        return this.interopViewFactoryHolder;
    }

    public final UsageByParent getIntrinsicsUsageByParent$ui_release() {
        return this.intrinsicsUsageByParent;
    }

    /* JADX INFO: renamed from: getLastSize-YbymL2g$ui_release, reason: not valid java name */
    public final long m6462getLastSizeYbymL2g$ui_release() {
        return this.lastSize;
    }

    public final LayoutNodeLayoutDelegate getLayoutDelegate$ui_release() {
        return this.layoutDelegate;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo, androidx.compose.ui.node.ComposeUiNode
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final LayoutNode getLookaheadRoot$ui_release() {
        return this.lookaheadRoot;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public Modifier getModifier() {
        return this._modifier;
    }

    public final boolean getNeedsOnGloballyPositionedDispatch$ui_release() {
        return this.needsOnGloballyPositionedDispatch;
    }

    public final NodeChain getNodes$ui_release() {
        return this.nodes;
    }

    /* JADX INFO: renamed from: getOffsetFromRoot-nOcc-ac$ui_release, reason: not valid java name */
    public final long m6463getOffsetFromRootnOccac$ui_release() {
        return this.offsetFromRoot;
    }

    public final Function1<Owner, Unit> getOnAttach$ui_release() {
        return this.onAttach;
    }

    public final Function1<Owner, Unit> getOnDetach$ui_release() {
        return this.onDetach;
    }

    /* JADX INFO: renamed from: getOuterToInnerOffset-nOcc-ac$ui_release, reason: not valid java name */
    public final long m6464getOuterToInnerOffsetnOccac$ui_release() {
        return this.outerToInnerOffset;
    }

    public final boolean getOuterToInnerOffsetDirty$ui_release() {
        return this.outerToInnerOffsetDirty;
    }

    public final Owner getOwner$ui_release() {
        return this.owner;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int getSemanticsId() {
        return this.semanticsId;
    }

    public final LayoutNodeSubcompositionsState getSubcompositionsState$ui_release() {
        return this.subcompositionsState;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo, androidx.compose.ui.node.ComposeUiNode
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public boolean isDeactivated() {
        return this.isDeactivated;
    }

    public final boolean isSemanticsInvalidated$ui_release() {
        return this.isSemanticsInvalidated;
    }

    public final boolean isVirtualLookaheadRoot$ui_release() {
        return this.isVirtualLookaheadRoot;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public SemanticsInfo getParentInfo() {
        return getParent$ui_release();
    }

    private final void applyModifier(Modifier r100) {
        boolean r101 = this.nodes.m6517hasH91voCI$ui_release(NodeKind.m6556constructorimpl(16));
        boolean r102 = this.nodes.m6517hasH91voCI$ui_release(NodeKind.m6556constructorimpl(1024));
        this._modifier = r100;
        this.nodes.updateFrom$ui_release(r100);
        boolean r103 = this.nodes.m6517hasH91voCI$ui_release(NodeKind.m6556constructorimpl(16));
        boolean r104 = this.nodes.m6517hasH91voCI$ui_release(NodeKind.m6556constructorimpl(1024));
        this.layoutDelegate.updateParentData();
        if (this.lookaheadRoot == null) goto L5;
    L7:
        if (r101 != r103) goto L9;
        if (r102 != r104) goto L9;
        return;
    L9:
        LayoutNodeKt.requireOwner(this).getRectManager().updateFlagsFor(this, r104, r103);
        return;
    L5:
        if (this.nodes.m6517hasH91voCI$ui_release(NodeKind.m6556constructorimpl(512)) == false) goto L7;
        setLookaheadRoot(this);
        goto L7
    }

    private final String debugTreeToString(int r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101.append(c.DEFAULT_TEXT);
        r102 = r102 + 1;
        goto L3
    L5:
        r101.append("|-");
        r101.append(toString());
        r101.append('\n');
        MutableVector<LayoutNode> r103 = get_children$ui_release();
        LayoutNode[] r104 = r103.content;
        int r105 = r103.getSize();
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L8;
        r101.append(r104[r106].debugTreeToString(r100 + 1));
        r106 = r106 + 1;
        goto L6
    L8:
        String r107 = r101.toString();
        if (r100 == 0) goto L11;
        return r107;
    L11:
        return r107.substring(0, r107.length() - 1);
    }

    private final String exceptionMessageForParentingOrOwnership(LayoutNode r100) {
        StringBuilder r101 = new StringBuilder("Cannot insert ");
        r101.append(r100);
        r101.append(" because it already has a parent or an owner. This tree: ");
        String r102 = null;
        r101.append(debugTreeToString$default(this, 0, 1, null));
        r101.append(" Other tree: ");
        LayoutNode r103 = r100._foldedParent;
        if (r103 == null) goto L5;
        r102 = debugTreeToString$default(r103, 0, 1, null);
    L5:
        r101.append(r102);
        return r101.toString();
    }

    private final void onChildRemoved(LayoutNode r100) {
        if (r100.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() <= 0) goto L6;
        LayoutNodeLayoutDelegate r101 = this.layoutDelegate;
        r101.setChildrenAccessingCoordinatesDuringPlacement(r101.getChildrenAccessingCoordinatesDuringPlacement() - 1);
    L6:
        if (this.owner == null) goto L8;
        r100.detach$ui_release();
    L8:
        r100._foldedParent = null;
        if (r100.globallyPositionedObservers <= 0) goto L11;
        setGloballyPositionedObservers(this.globallyPositionedObservers - 1);
    L11:
        r100.getOuterCoordinator$ui_release().setWrappedBy$ui_release(null);
        if (r100.isVirtual == false) goto L16;
        this.virtualChildrenCount--;
        MutableVector<LayoutNode> r102 = r100._foldedChildren.getVector();
        LayoutNode[] r103 = r102.content;
        int r104 = r102.getSize();
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L16;
        r103[r105].getOuterCoordinator$ui_release().setWrappedBy$ui_release(null);
        r105 = r105 + 1;
    L16:
        invalidateUnfoldedVirtualChildren();
        onZSortedChildrenInvalidated$ui_release();
    }

    private final void setLookaheadRoot(LayoutNode r100) {
        if (Intrinsics.areEqual(r100, this.lookaheadRoot) == true) goto L16;
        this.lookaheadRoot = r100;
        if (r100 == null) goto L11;
        this.layoutDelegate.ensureLookaheadDelegateCreated$ui_release();
        NodeCoordinator r101 = getOuterCoordinator$ui_release();
        NodeCoordinator r102 = getInnerCoordinator$ui_release().getWrapped$ui_release();
    L8:
        if (Intrinsics.areEqual(r101, r102) == true) goto L12;
        if (r101 == null) goto L12;
        r101.ensureLookaheadDelegateCreated();
        r101 = r101.getWrapped$ui_release();
    L12:
        invalidateMeasurements$ui_release();
        return;
    L11:
        this.layoutDelegate.onRemovedFromLookaheadScope();
        goto L12
    }

    public final void attach$ui_release(Owner r100) {
        int r101 = 0;
        if (this.owner != null) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L9;
        InlineClassHelperKt.throwIllegalStateException("Cannot attach " + this + " as it already is attached.  Tree: " + debugTreeToString$default(this, 0, 1, null));
    L9:
        LayoutNode r103 = this._foldedParent;
        if (r103 == null) goto L18;
        if (r103 == null) goto L13;
        Owner r104 = r103.owner;
    L15:
        if (Intrinsics.areEqual(r104, r100) == true) goto L18;
        boolean r105 = false;
    L19:
        if (r105 == true) goto L29;
        StringBuilder r106 = new StringBuilder("Attaching to a different owner(");
        r106.append(r100);
        r106.append(") than the parent's owner(");
        LayoutNode r107 = getParent$ui_release();
        if (r107 == null) goto L23;
        Owner r108 = r107.owner;
    L24:
        r106.append(r108);
        r106.append("). This tree: ");
        r106.append(debugTreeToString$default(this, 0, 1, null));
        r106.append(" Parent tree: ");
        LayoutNode r109 = this._foldedParent;
        if (r109 == null) goto L27;
        String r110 = debugTreeToString$default(r109, 0, 1, null);
    L28:
        r106.append(r110);
        InlineClassHelperKt.throwIllegalStateException(r106.toString());
        goto L29
    L27:
        r110 = null;
        goto L28
    L23:
        r108 = null;
    L29:
        LayoutNode r111 = getParent$ui_release();
        if (r111 != null) goto L34;
        getMeasurePassDelegate$ui_release().setPlaced$ui_release(true);
        LookaheadPassDelegate r112 = getLookaheadPassDelegate$ui_release();
        if (r112 == null) goto L34;
        r112.onAttachedToNullParent();
    L34:
        NodeCoordinator r113 = getOuterCoordinator$ui_release();
        if (r111 == null) goto L37;
        NodeCoordinator r114 = r111.getInnerCoordinator$ui_release();
    L38:
        r113.setWrappedBy$ui_release(r114);
        this.owner = r100;
        if (r111 == null) goto L41;
        int r115 = r111.depth;
    L42:
        this.depth = r115 + 1;
        Modifier r116 = this.pendingModifier;
        if (r116 == null) goto L45;
        applyModifier(r116);
    L45:
        this.pendingModifier = null;
        if (ComposeUiFlags.isSemanticAutofillEnabled == false) goto L48;
    L50:
        r100.onPreAttach(this);
        if (this.isVirtualLookaheadRoot == false) goto L53;
        setLookaheadRoot(this);
    L64:
        if (isDeactivated() == true) goto L66;
        this.nodes.markAsAttached();
    L66:
        MutableVector<LayoutNode> r117 = this._foldedChildren.getVector();
        LayoutNode[] r118 = r117.content;
        int r119 = r117.getSize();
    L67:
        if (r101 >= r119) goto L70;
        r118[r101].attach$ui_release(r100);
        r101 = r101 + 1;
        goto L67
    L70:
        if (isDeactivated() == true) goto L72;
        this.nodes.runAttachLifecycle();
    L72:
        invalidateMeasurements$ui_release();
        if (r111 == null) goto L75;
        r111.invalidateMeasurements$ui_release();
    L75:
        Function1<? super Owner, Unit> r120 = this.onAttach;
        if (r120 == null) goto L78;
        r120.invoke(r100);
    L78:
        this.layoutDelegate.updateParentData();
        if (ComposeUiFlags.isSemanticAutofillEnabled == true) goto L81;
    L85:
        r100.onPostAttach(this);
        return;
    L81:
        if (isDeactivated() == true) goto L85;
        if (this.nodes.m6517hasH91voCI$ui_release(NodeKind.m6556constructorimpl(8)) == false) goto L85;
        invalidateSemantics$ui_release();
        goto L85
    L53:
        LayoutNode r121 = this._foldedParent;
        if (r121 == null) goto L57;
        LayoutNode r122 = r121.lookaheadRoot;
        if (r122 == null) goto L57;
    L58:
        setLookaheadRoot(r122);
        if (this.lookaheadRoot != null) goto L64;
        if (this.nodes.m6517hasH91voCI$ui_release(NodeKind.m6556constructorimpl(512)) == false) goto L64;
        setLookaheadRoot(this);
    L57:
        r122 = this.lookaheadRoot;
        goto L58
    L48:
        if (this.nodes.m6517hasH91voCI$ui_release(NodeKind.m6556constructorimpl(8)) == false) goto L50;
        invalidateSemantics$ui_release();
        goto L50
    L41:
        r115 = -1;
        goto L42
    L37:
        r114 = null;
        goto L38
    L13:
        r104 = null;
    L18:
        r105 = true;
        goto L19
    L5:
        r102 = false;
        goto L7
    }

    public final void forEachChild(Function1<? super LayoutNode, Unit> r100) {
        MutableVector<LayoutNode> r101 = get_children$ui_release();
        LayoutNode[] r102 = r101.content;
        int r103 = r101.getSize();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r100.invoke(r102[r104]);
        r104 = r104 + 1;
        goto L3
    }

    public final void forEachChildIndexed(Function2<? super Integer, ? super LayoutNode, Unit> r100) {
        MutableVector<LayoutNode> r101 = get_children$ui_release();
        LayoutNode[] r102 = r101.content;
        int r103 = r101.getSize();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r100.invoke(Integer.valueOf(r104), r102[r104]);
        r104 = r104 + 1;
        goto L3
    }

    public final void forEachCoordinator$ui_release(Function1<? super LayoutModifierNodeCoordinator, Unit> r100) {
        NodeCoordinator r101 = getOuterCoordinator$ui_release();
        NodeCoordinator r102 = getInnerCoordinator$ui_release();
    L3:
        if (r101 == r102) goto L5;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
        LayoutModifierNodeCoordinator r103 = (LayoutModifierNodeCoordinator) r101;
        r100.invoke(r103);
        r101 = r103.getWrapped$ui_release();
        goto L3
    }

    public final void forEachCoordinatorIncludingInner$ui_release(Function1<? super NodeCoordinator, Unit> r100) {
        NodeCoordinator r101 = getOuterCoordinator$ui_release();
        NodeCoordinator r102 = getInnerCoordinator$ui_release().getWrapped$ui_release();
    L4:
        if (Intrinsics.areEqual(r101, r102) == true) goto L7;
        if (r101 == null) goto L10;
        r100.invoke(r101);
        r101 = r101.getWrapped$ui_release();
        goto L4
    L10:
        return;
    }

    public final <T> T ignoreRemeasureRequests$ui_release(Function0<? extends T> r100) {
        access$setIgnoreRemeasureRequests$p(this, true);
        T r101 = r100.invoke();
        access$setIgnoreRemeasureRequests$p(this, false);
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final void invalidateSubtree(boolean r110) {
        if (r110 == false) goto L6;
        LayoutNode r111 = getParent$ui_release();
        if (r111 == null) goto L6;
        r111.invalidateLayer$ui_release();
    L6:
        invalidateSemantics$ui_release();
        requestRemeasure$ui_release$default(this, false, false, false, 7, null);
        NodeChain r112 = this.nodes;
        int r100 = NodeKind.m6556constructorimpl(2);
        if ((NodeChain.access$getAggregateChildKindSet(r112) & r100) == 0) goto L48;
        Modifier.Node r113 = r112.getHead$ui_release();
    L9:
        if (r113 == null) goto L48;
        if ((r113.getKindSet$ui_release() & r100) == 0) goto L46;
        Modifier.Node r101 = r113;
        MutableVector r102 = null;
    L13:
        if (r101 == 0) goto L46;
        if ((r101 instanceof LayoutModifierNode) == true) goto L16;
        if ((r101.getKindSet$ui_release() & r100) == 0) goto L22;
        boolean r103 = true;
    L23:
        if (r103 == false) goto L44;
        if ((r101 instanceof DelegatingNode) == false) goto L44;
        Modifier.Node r104 = ((DelegatingNode) r101).getDelegate$ui_release();
        int r105 = 0;
        r101 = r101;
    L27:
        if (r104 == null) goto L42;
        if ((r104.getKindSet$ui_release() & r100) == 0) goto L31;
        boolean r106 = true;
    L32:
        if (r106 == false) goto L41;
        r105 = r105 + 1;
        if (r105 != 1) goto L36;
        r101 = r104;
        goto L41
    L36:
        if (r102 != null) goto L38;
        r102 = new MutableVector(new Modifier.Node[16], 0);
    L38:
        if (r101 == 0) goto L40;
        r102.add(r101);
        r101 = 0;
    L40:
        r102.add(r104);
    L41:
        r104 = r104.getChild$ui_release();
        r101 = r101;
        goto L27
    L31:
        r106 = false;
        goto L32
    L42:
        if (r105 == 1) goto L13;
    L44:
        r101 = DelegatableNodeKt.access$pop(r102);
        goto L13
    L22:
        r103 = false;
        goto L23
    L16:
        OwnedLayer r107 = DelegatableNodeKt.m6409requireCoordinator64DMado((LayoutModifierNode) r101, NodeKind.m6556constructorimpl(2)).getLayer();
        if (r107 == null) goto L44;
        r107.invalidate();
    L46:
        if ((r113.getAggregateChildKindSet$ui_release() & r100) == 0) goto L48;
        r113 = r113.getChild$ui_release();
    L48:
        MutableVector<LayoutNode> r114 = get_children$ui_release();
        LayoutNode[] r108 = r114.content;
        int r115 = r114.getSize();
        int r109 = 0;
    L49:
        if (r109 >= r115) goto L51;
        r108[r109].invalidateSubtree(false);
        r109 = r109 + 1;
        goto L49
    }

    /* JADX INFO: renamed from: lookaheadRemeasure-_Sx5XlM$ui_release, reason: not valid java name */
    public final boolean m6467lookaheadRemeasure_Sx5XlM$ui_release(Constraints r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.lookaheadRoot == null) goto L6;
        LookaheadPassDelegate r101 = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(r101);
        return r101.m6501remeasureBRTryo0(r100.m7493unboximpl());
    }

    public final int maxIntrinsicHeight(int r100) {
        return getOrCreateIntrinsicsPolicy().maxIntrinsicHeight(r100);
    }

    public final int maxIntrinsicWidth(int r100) {
        return getOrCreateIntrinsicsPolicy().maxIntrinsicWidth(r100);
    }

    public final int maxLookaheadIntrinsicHeight(int r100) {
        return getOrCreateIntrinsicsPolicy().maxLookaheadIntrinsicHeight(r100);
    }

    public final int maxLookaheadIntrinsicWidth(int r100) {
        return getOrCreateIntrinsicsPolicy().maxLookaheadIntrinsicWidth(r100);
    }

    public final int minIntrinsicHeight(int r100) {
        return getOrCreateIntrinsicsPolicy().minIntrinsicHeight(r100);
    }

    public final int minIntrinsicWidth(int r100) {
        return getOrCreateIntrinsicsPolicy().minIntrinsicWidth(r100);
    }

    public final int minLookaheadIntrinsicHeight(int r100) {
        return getOrCreateIntrinsicsPolicy().minLookaheadIntrinsicHeight(r100);
    }

    public final int minLookaheadIntrinsicWidth(int r100) {
        return getOrCreateIntrinsicsPolicy().minLookaheadIntrinsicWidth(r100);
    }

    /* JADX INFO: renamed from: remeasure-_Sx5XlM$ui_release, reason: not valid java name */
    public final boolean m6468remeasure_Sx5XlM$ui_release(Constraints r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (this.intrinsicsUsageByParent != UsageByParent.NotUsed) goto L9;
        clearSubtreeIntrinsicsUsage$ui_release();
    L9:
        return getMeasurePassDelegate$ui_release().m6512remeasureBRTryo0(r100.m7493unboximpl());
    }

    public final void requestLookaheadRelayout$ui_release(boolean r100) {
        if (this.isVirtual == true) goto L8;
        Owner r101 = this.owner;
        if (r101 == null) goto L9;
        r101.onRequestRelayout(this, true, r100);
        return;
    L9:
        return;
    }

    public final void requestRelayout$ui_release(boolean r100) {
        if (this.isVirtual == true) goto L8;
        Owner r101 = this.owner;
        if (r101 == null) goto L9;
        Owner.CC.onRequestRelayout$default(r101, this, false, r100, 2, null);
        return;
    L9:
        return;
    }

    public final void rescheduleRemeasureOrRelayout$ui_release(LayoutNode r100) {
        if (WhenMappings.$EnumSwitchMapping$0[r100.getLayoutState$ui_release().ordinal()] != 1) goto L18;
        if (r100.getLookaheadMeasurePending$ui_release() == false) goto L8;
        requestLookaheadRemeasure$ui_release$default(r100, true, false, false, 6, null);
        return;
    L8:
        if (r100.getLookaheadLayoutPending$ui_release() == false) goto L11;
        r100.requestLookaheadRelayout$ui_release(true);
    L11:
        if (r100.getMeasurePending$ui_release() == false) goto L14;
        requestRemeasure$ui_release$default(r100, true, false, false, 6, null);
        return;
    L14:
        if (r100.getLayoutPending$ui_release() == false) goto L21;
        r100.requestRelayout$ui_release(true);
        return;
    L21:
        return;
    L18:
        throw new IllegalStateException("Unexpected state " + r100.getLayoutState$ui_release());
    }

    public final Void rethrowWithComposeStackTrace(Throwable r100) {
        CompositionErrorContext r101 = getTraceContext();
        if (r101 == null) goto L6;
        r101.attachComposeStackTrace(r100, this);
        throw r100;
    L6:
        throw r100;
    }

    public final void setCanMultiMeasure$ui_release(boolean r100) {
        this.canMultiMeasure = r100;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setCompositeKeyHash(int r100) {
        this.compositeKeyHash = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setCompositionLocalMap(CompositionLocalMap r110) {
        this.compositionLocalMap = r110;
        setDensity((Density) r110.get(CompositionLocalsKt.getLocalDensity()));
        setLayoutDirection((LayoutDirection) r110.get(CompositionLocalsKt.getLocalLayoutDirection()));
        setViewConfiguration((ViewConfiguration) r110.get(CompositionLocalsKt.getLocalViewConfiguration()));
        NodeChain r111 = this.nodes;
        int r100 = NodeKind.m6556constructorimpl(32768);
        if ((NodeChain.access$getAggregateChildKindSet(r111) & r100) == 0) goto L45;
        Modifier.Node r112 = r111.getHead$ui_release();
    L5:
        if (r112 == null) goto L60;
        if ((r112.getKindSet$ui_release() & r100) == 0) goto L43;
        Modifier.Node r101 = r112;
        MutableVector r102 = null;
    L9:
        if (r101 == 0) goto L43;
        if ((r101 instanceof CompositionLocalConsumerModifierNode) == true) goto L12;
        if ((r101.getKindSet$ui_release() & r100) == 0) goto L19;
        boolean r103 = true;
    L20:
        if (r103 == false) goto L41;
        if ((r101 instanceof DelegatingNode) == false) goto L41;
        Modifier.Node r104 = ((DelegatingNode) r101).getDelegate$ui_release();
        int r105 = 0;
        r101 = r101;
    L24:
        if (r104 == null) goto L39;
        if ((r104.getKindSet$ui_release() & r100) == 0) goto L28;
        boolean r106 = true;
    L29:
        if (r106 == false) goto L38;
        r105 = r105 + 1;
        if (r105 != 1) goto L33;
        r101 = r104;
        goto L38
    L33:
        if (r102 != null) goto L35;
        r102 = new MutableVector(new Modifier.Node[16], 0);
    L35:
        if (r101 == 0) goto L37;
        r102.add(r101);
        r101 = 0;
    L37:
        r102.add(r104);
    L38:
        r104 = r104.getChild$ui_release();
        r101 = r101;
        goto L24
    L28:
        r106 = false;
        goto L29
    L39:
        if (r105 == 1) goto L9;
    L41:
        r101 = DelegatableNodeKt.access$pop(r102);
        goto L9
    L19:
        r103 = false;
        goto L20
    L12:
        Modifier.Node r107 = ((CompositionLocalConsumerModifierNode) r101).getNode();
        if (r107.isAttached() == false) goto L15;
        NodeKindKt.autoInvalidateUpdatedNode(r107);
        goto L41
    L15:
        r107.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
    L43:
        if ((r112.getAggregateChildKindSet$ui_release() & r100) == 0) goto L61;
        r112 = r112.getChild$ui_release();
        goto L5
    L61:
        return;
    L60:
        return;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setDensity(Density r100) {
        if (Intrinsics.areEqual(this.density, r100) == true) goto L7;
        this.density = r100;
        onDensityOrLayoutDirectionChanged();
        Modifier.Node r101 = this.nodes.getHead$ui_release();
    L5:
        if (r101 == null) goto L9;
        r101.onDensityChange();
        r101 = r101.getChild$ui_release();
        goto L5
    L9:
        return;
    }

    public final void setDepth$ui_release(int r100) {
        this.depth = r100;
    }

    public final void setGloballyPositionedObservers(int r100) {
        int r101 = this.globallyPositionedObservers;
        if (r101 == r100) goto L17;
        if (r100 <= 0) goto L9;
        if (r101 != 0) goto L9;
        LayoutNode r102 = getParent$ui_release();
        if (r102 == null) goto L9;
        r102.setGloballyPositionedObservers(r102.globallyPositionedObservers + 1);
    L9:
        if (r100 == 0) goto L11;
    L15:
        this.globallyPositionedObservers = r100;
        return;
    L11:
        if (this.globallyPositionedObservers <= 0) goto L15;
        LayoutNode r103 = getParent$ui_release();
        if (r103 == null) goto L15;
        r103.setGloballyPositionedObservers(r103.globallyPositionedObservers - 1);
        goto L15
    }

    public final void setInnerLayerCoordinatorIsDirty$ui_release(boolean r100) {
        this.innerLayerCoordinatorIsDirty = r100;
    }

    public final void setInteropViewFactoryHolder$ui_release(AndroidViewHolder r100) {
        this.interopViewFactoryHolder = r100;
    }

    public final void setIntrinsicsUsageByParent$ui_release(UsageByParent r100) {
        this.intrinsicsUsageByParent = r100;
    }

    /* JADX INFO: renamed from: setLastSize-ozmzZPI$ui_release, reason: not valid java name */
    public final void m6469setLastSizeozmzZPI$ui_release(long r100) {
        this.lastSize = r100;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setLayoutDirection(LayoutDirection r100) {
        if (this.layoutDirection == r100) goto L7;
        this.layoutDirection = r100;
        onDensityOrLayoutDirectionChanged();
        Modifier.Node r101 = this.nodes.getHead$ui_release();
    L5:
        if (r101 == null) goto L9;
        r101.onLayoutDirectionChange();
        r101 = r101.getChild$ui_release();
        goto L5
    L9:
        return;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setMeasurePolicy(MeasurePolicy r100) {
        if (Intrinsics.areEqual(this.measurePolicy, r100) == true) goto L9;
        this.measurePolicy = r100;
        IntrinsicsPolicy r101 = this.intrinsicsPolicy;
        if (r101 == null) goto L7;
        r101.updateFrom(getMeasurePolicy());
    L7:
        invalidateMeasurements$ui_release();
        return;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setModifier(Modifier r100) {
        if (this.isVirtual == true) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L12;
        InlineClassHelperKt.throwIllegalArgumentException("Modifiers are not supported on virtual LayoutNodes");
    L12:
        if ((!isDeactivated()) == true) goto L15;
        InlineClassHelperKt.throwIllegalArgumentException("modifier is updated when deactivated");
    L15:
        if (isAttached() == false) goto L19;
        applyModifier(r100);
        if (this.isSemanticsInvalidated == false) goto L21;
        invalidateSemantics$ui_release();
        return;
    L21:
        return;
    L19:
        this.pendingModifier = r100;
        return;
    L5:
        if (getModifier() == Modifier.Companion) goto L8;
        r101 = false;
        goto L9
    }

    public final void setNeedsOnGloballyPositionedDispatch$ui_release(boolean r100) {
        this.needsOnGloballyPositionedDispatch = r100;
    }

    /* JADX INFO: renamed from: setOffsetFromRoot--gyyYBs$ui_release, reason: not valid java name */
    public final void m6470setOffsetFromRootgyyYBs$ui_release(long r100) {
        this.offsetFromRoot = r100;
    }

    public final void setOnAttach$ui_release(Function1<? super Owner, Unit> r100) {
        this.onAttach = r100;
    }

    public final void setOnDetach$ui_release(Function1<? super Owner, Unit> r100) {
        this.onDetach = r100;
    }

    /* JADX INFO: renamed from: setOuterToInnerOffset--gyyYBs$ui_release, reason: not valid java name */
    public final void m6471setOuterToInnerOffsetgyyYBs$ui_release(long r100) {
        this.outerToInnerOffset = r100;
    }

    public final void setOuterToInnerOffsetDirty$ui_release(boolean r100) {
        this.outerToInnerOffsetDirty = r100;
    }

    public void setSemanticsId(int r100) {
        this.semanticsId = r100;
    }

    public final void setSemanticsInvalidated$ui_release(boolean r100) {
        this.isSemanticsInvalidated = r100;
    }

    public final void setSubcompositionsState$ui_release(LayoutNodeSubcompositionsState r100) {
        this.subcompositionsState = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6 */
    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setViewConfiguration(ViewConfiguration r110) {
        if (Intrinsics.areEqual(this.viewConfiguration, r110) == true) goto L44;
        this.viewConfiguration = r110;
        NodeChain r111 = this.nodes;
        int r100 = NodeKind.m6556constructorimpl(16);
        if ((NodeChain.access$getAggregateChildKindSet(r111) & r100) == 0) goto L59;
        Modifier.Node r112 = r111.getHead$ui_release();
    L7:
        if (r112 == null) goto L60;
        if ((r112.getKindSet$ui_release() & r100) == 0) goto L42;
        Modifier.Node r101 = r112;
        MutableVector r102 = null;
    L11:
        if (r101 == 0) goto L42;
        if ((r101 instanceof PointerInputModifierNode) == true) goto L14;
        if ((r101.getKindSet$ui_release() & r100) == 0) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == false) goto L40;
        if ((r101 instanceof DelegatingNode) == false) goto L40;
        Modifier.Node r104 = ((DelegatingNode) r101).getDelegate$ui_release();
        int r105 = 0;
        r101 = r101;
    L23:
        if (r104 == null) goto L38;
        if ((r104.getKindSet$ui_release() & r100) == 0) goto L27;
        boolean r106 = true;
    L28:
        if (r106 == false) goto L37;
        r105 = r105 + 1;
        if (r105 != 1) goto L32;
        r101 = r104;
        goto L37
    L32:
        if (r102 != null) goto L34;
        r102 = new MutableVector(new Modifier.Node[16], 0);
    L34:
        if (r101 == 0) goto L36;
        r102.add(r101);
        r101 = 0;
    L36:
        r102.add(r104);
    L37:
        r104 = r104.getChild$ui_release();
        r101 = r101;
        goto L23
    L27:
        r106 = false;
        goto L28
    L38:
        if (r105 == 1) goto L11;
    L40:
        r101 = DelegatableNodeKt.access$pop(r102);
        goto L11
    L18:
        r103 = false;
        goto L19
    L14:
        ((PointerInputModifierNode) r101).onViewConfigurationChange();
    L42:
        if ((r112.getAggregateChildKindSet$ui_release() & r100) == 0) goto L61;
        r112 = r112.getChild$ui_release();
        goto L7
    L61:
        return;
    L60:
        return;
    L59:
        return;
    }

    public final void setVirtualLookaheadRoot$ui_release(boolean r100) {
        this.isVirtualLookaheadRoot = r100;
    }

    public LayoutNode(boolean r100, int r101) {
        this.isVirtual = r100;
        this.semanticsId = r101;
        IntOffset.Companion r102 = IntOffset.Companion;
        this.offsetFromRoot = r102.m7686getMaxnOccac();
        this.lastSize = IntSize.Companion.m7724getZeroYbymL2g();
        this.outerToInnerOffset = r102.m7686getMaxnOccac();
        this.outerToInnerOffsetDirty = true;
        this._foldedChildren = new MutableVectorWithMutationTracking(new MutableVector(new LayoutNode[16], 0), new LayoutNode$_foldedChildren$1(this));
        this._zSortedChildren = new MutableVector(new LayoutNode[16], 0);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = ErrorMeasurePolicy;
        this.density = LayoutNodeKt.access$getDefaultDensity$p();
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = DummyViewConfiguration;
        this.compositionLocalMap = CompositionLocalMap.Companion.getEmpty();
        UsageByParent r103 = UsageByParent.NotUsed;
        this.intrinsicsUsageByParent = r103;
        this.previousIntrinsicsUsageByParent = r103;
        this.nodes = new NodeChain(this);
        this.layoutDelegate = new LayoutNodeLayoutDelegate(this);
        this.innerLayerCoordinatorIsDirty = true;
        this._modifier = Modifier.Companion;
    }

    private static final int ZComparator$lambda$42(LayoutNode r100, LayoutNode r101) {
        if (r100.getZIndex() != r101.getZIndex()) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return Intrinsics.compare(r100.getPlaceOrder$ui_release(), r101.getPlaceOrder$ui_release());
    L9:
        return Float.compare(r100.getZIndex(), r101.getZIndex());
    L5:
        r102 = false;
        goto L6
    }

    public static final /* synthetic */ void access$setIgnoreRemeasureRequests$p(LayoutNode r100, boolean r101) {
        r100.ignoreRemeasureRequests = r101;
    }

    public final void draw$ui_release(Canvas r100, GraphicsLayer r101) {
        getOuterCoordinator$ui_release().draw(r100, r101);     // Catch: Throwable -> L4
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        rethrowWithComposeStackTrace(th);
        throw new KotlinNothingValueException();
    }

    public final void insertAt$ui_release(int r100, LayoutNode r101) {
        if (r101._foldedParent != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        InlineClassHelperKt.throwIllegalStateException(exceptionMessageForParentingOrOwnership(r101));
    L11:
        r101._foldedParent = this;
        this._foldedChildren.add(r100, r101);
        onZSortedChildrenInvalidated$ui_release();
        if (r101.isVirtual == false) goto L14;
        this.virtualChildrenCount++;
    L14:
        invalidateUnfoldedVirtualChildren();
        Owner r103 = this.owner;
        if (r103 == null) goto L18;
        r101.attach$ui_release(r103);
    L18:
        if (r101.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() <= 0) goto L21;
        LayoutNodeLayoutDelegate r104 = this.layoutDelegate;
        r104.setChildrenAccessingCoordinatesDuringPlacement(r104.getChildrenAccessingCoordinatesDuringPlacement() + 1);
    L21:
        if (r101.globallyPositionedObservers <= 0) goto L24;
        setGloballyPositionedObservers(this.globallyPositionedObservers + 1);
        return;
    L24:
        return;
    L5:
        if (r101.owner == null) goto L8;
        r102 = false;
        goto L9
    }

    public final void place$ui_release(int r100, int r110) {
        if (this.intrinsicsUsageByParent != UsageByParent.NotUsed) goto L5;
        clearSubtreePlacementIntrinsicsUsage();
    L5:
        LayoutNode r101 = getParent$ui_release();
        if (r101 == null) goto L11;
        NodeCoordinator r102 = r101.getInnerCoordinator$ui_release();
        if (r102 == null) goto L11;
        Placeable.PlacementScope r103 = r102.getPlacementScope();
        if (r103 == null) goto L11;
    L12:
        Placeable.PlacementScope.placeRelative$default(r103, getMeasurePassDelegate$ui_release(), r100, r110, 0.0f, 4, null);
        return;
    L11:
        r103 = LayoutNodeKt.requireOwner(this).getPlacementScope();
        goto L12
    }

    public final void removeAt$ui_release(int r100, int r101) {
        if (r101 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("count (" + r101 + ") must be greater than 0");
    L8:
        int r103 = (r101 + r100) - 1;
        if (r100 > r103) goto L13;
    L10:
        onChildRemoved(this._foldedChildren.getVector().content[r103]);
        LayoutNode r104 = this._foldedChildren.removeAt(r103);
        if (r103 == r100) goto L15;
        r103 = r103 - 1;
        goto L10
    L15:
        return;
    L13:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void move$ui_release(int r100, int r101, int r102) {
        if (r100 != r101) goto L4;
        return;
    L4:
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L13;
        if (r100 <= r101) goto L8;
        int r104 = r100 + r103;
    L9:
        if (r100 <= r101) goto L11;
        int r105 = r101 + r103;
    L12:
        this._foldedChildren.add(r105, this._foldedChildren.removeAt(r104));
        r103 = r103 + 1;
        goto L5
    L11:
        r105 = (r101 + r102) - 2;
        goto L12
    L8:
        r104 = r100;
        goto L9
    L13:
        onZSortedChildrenInvalidated$ui_release();
        invalidateUnfoldedVirtualChildren();
        invalidateMeasurements$ui_release();
    }

    public final void requestLookaheadRemeasure$ui_release(boolean r100, boolean r101, boolean r102) {
        if (this.lookaheadRoot == null) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
        InlineClassHelperKt.throwIllegalStateException("Lookahead measure cannot be requested on a node that is not a part of the LookaheadScope");
    L8:
        Owner r104 = this.owner;
        if (r104 != null) goto L12;
        return;
    L12:
        if (this.ignoreRemeasureRequests == false) goto L14;
        return;
    L14:
        if (this.isVirtual == true) goto L20;
        r104.onRequestMeasure(this, true, r100, r101);
        if (r102 == false) goto L21;
        LookaheadPassDelegate r105 = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(r105);
        r105.invalidateIntrinsicsParent(r100);
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void requestRemeasure$ui_release(boolean r100, boolean r110, boolean r111) {
        if (this.ignoreRemeasureRequests == false) goto L5;
        return;
    L5:
        if (this.isVirtual == true) goto L14;
        Owner r101 = this.owner;
        if (r101 != null) goto L9;
        return;
    L9:
        Owner.CC.onRequestMeasure$default(r101, this, false, r100, r110, 2, null);
        if (r111 == false) goto L15;
        getMeasurePassDelegate$ui_release().invalidateIntrinsicsParent(r100);
        return;
    L15:
        return;
    }

    public /* synthetic */ LayoutNode(boolean r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = SemanticsModifierKt.generateSemanticsId();
    L8:
        this(r100, r101);
    }

    public static /* synthetic */ String debugTreeToString$default(LayoutNode r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        return r100.debugTreeToString(r101);
    }

    public static /* synthetic */ void invalidateSubtree$default(LayoutNode r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = true;
    L5:
        r100.invalidateSubtree(r101);
    }

    /* JADX INFO: renamed from: lookaheadRemeasure-_Sx5XlM$ui_release$default, reason: not valid java name */
    public static /* synthetic */ boolean m6460lookaheadRemeasure_Sx5XlM$ui_release$default(LayoutNode r100, Constraints r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.layoutDelegate.m6481getLastLookaheadConstraintsDWUhwKw();
    L6:
        return r100.m6467lookaheadRemeasure_Sx5XlM$ui_release(r101);
    }

    /* JADX INFO: renamed from: remeasure-_Sx5XlM$ui_release$default, reason: not valid java name */
    public static /* synthetic */ boolean m6461remeasure_Sx5XlM$ui_release$default(LayoutNode r100, Constraints r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.layoutDelegate.m6480getLastConstraintsDWUhwKw();
    L6:
        return r100.m6468remeasure_Sx5XlM$ui_release(r101);
    }

    public static /* synthetic */ void requestLookaheadRelayout$ui_release$default(LayoutNode r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = false;
    L5:
        r100.requestLookaheadRelayout$ui_release(r101);
    }

    public static /* synthetic */ void requestRelayout$ui_release$default(LayoutNode r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = false;
    L5:
        r100.requestRelayout$ui_release(r101);
    }

    /* JADX INFO: renamed from: hitTest-6fMxITs$ui_release, reason: not valid java name */
    public final void m6465hitTest6fMxITs$ui_release(long r110, HitTestResult r111, int r112, boolean r113) {
        long r100 = NodeCoordinator.m6525fromParentPosition8S9VItk$default(getOuterCoordinator$ui_release(), r110, false, 2, null);
        getOuterCoordinator$ui_release().m6543hitTestqzLsGqo(NodeCoordinator.Companion.getPointerInputSource(), r100, r111, r112, r113);
    }

    /* JADX INFO: renamed from: hitTestSemantics-6fMxITs$ui_release, reason: not valid java name */
    public final void m6466hitTestSemantics6fMxITs$ui_release(long r110, HitTestResult r111, int r112, boolean r113) {
        long r100 = NodeCoordinator.m6525fromParentPosition8S9VItk$default(getOuterCoordinator$ui_release(), r110, false, 2, null);
        getOuterCoordinator$ui_release().m6543hitTestqzLsGqo(NodeCoordinator.Companion.getSemanticsSource(), r100, r111, PointerType.Companion.m6205getTouchT8wyACA(), r113);
    }

    public static /* synthetic */ void requestLookaheadRemeasure$ui_release$default(LayoutNode r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = true;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = true;
    L11:
        r100.requestLookaheadRemeasure$ui_release(r101, r102, r103);
    }

    public static /* synthetic */ void requestRemeasure$ui_release$default(LayoutNode r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = true;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = true;
    L11:
        r100.requestRemeasure$ui_release(r101, r102, r103);
    }

    /* JADX INFO: renamed from: hitTest-6fMxITs$ui_release$default, reason: not valid java name */
    public static /* synthetic */ void m6458hitTest6fMxITs$ui_release$default(LayoutNode r100, long r101, HitTestResult r102, int r110, boolean r111, int r112, Object r113) {
        if ((r112 & 4) == 0) goto L5;
        r110 = PointerType.Companion.m6206getUnknownT8wyACA();
    L5:
        int r103 = r110;
        if ((r112 & 8) == 0) goto L8;
        boolean r104 = true;
    L9:
        r100.m6465hitTest6fMxITs$ui_release(r101, r102, r103, r104);
        return;
    L8:
        r104 = r111;
        goto L9
    }

    /* JADX INFO: renamed from: hitTestSemantics-6fMxITs$ui_release$default, reason: not valid java name */
    public static /* synthetic */ void m6459hitTestSemantics6fMxITs$ui_release$default(LayoutNode r100, long r101, HitTestResult r102, int r110, boolean r111, int r112, Object r113) {
        if ((r112 & 4) == 0) goto L5;
        r110 = PointerType.Companion.m6205getTouchT8wyACA();
    L5:
        int r103 = r110;
        if ((r112 & 8) == 0) goto L8;
        boolean r104 = true;
    L9:
        r100.m6466hitTestSemantics6fMxITs$ui_release(r101, r102, r103, r104);
        return;
    L8:
        r104 = r111;
        goto L9
    }
}
