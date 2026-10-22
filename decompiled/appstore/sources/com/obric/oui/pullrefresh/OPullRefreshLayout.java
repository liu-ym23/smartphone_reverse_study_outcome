package com.obric.oui.pullrefresh;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewCompat;
import androidx.core.view.i;
import bg.h;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.google.common.primitives.Ints;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oui.R$styleable;
import com.obric.oui.pullrefresh.header.ODefaultRefreshHeader;
import com.obric.oui.pullrefresh.header.ORefreshHeader;
import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0015\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0017\u0018\u0000 Ð\u00012\u00020\u00012\u00020\u0002:\u0001mB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00072\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001c\u0010\u0011J\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\rH\u0002¢\u0006\u0004\b$\u0010\u0011J'\u0010)\u001a\u00020\r2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\r2\u0006\u0010+\u001a\u00020!H\u0002¢\u0006\u0004\b,\u0010-J\u001f\u00100\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020%H\u0002¢\u0006\u0004\b0\u00101J'\u00105\u001a\u00020%2\u0006\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020%H\u0002¢\u0006\u0004\b5\u00106J\u0015\u00107\u001a\u00020\r2\u0006\u00104\u001a\u00020%¢\u0006\u0004\b7\u00108J\u0015\u0010:\u001a\u00020\r2\u0006\u00109\u001a\u00020%¢\u0006\u0004\b:\u00108J\u0015\u0010<\u001a\u00020\r2\u0006\u0010;\u001a\u00020%¢\u0006\u0004\b<\u00108J\u0015\u0010>\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u0007¢\u0006\u0004\b>\u0010\u0016J\u0017\u0010A\u001a\u00020\r2\b\u0010@\u001a\u0004\u0018\u00010?¢\u0006\u0004\bA\u0010BJ!\u0010A\u001a\u00020\r2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0C¢\u0006\u0004\bA\u0010EJ\u0017\u0010G\u001a\u00020\r2\b\u0010@\u001a\u0004\u0018\u00010F¢\u0006\u0004\bG\u0010HJ-\u0010G\u001a\u00020\r2\u001e\u0010D\u001a\u001a\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0I¢\u0006\u0004\bG\u0010JJ\u0015\u0010M\u001a\u00020\r2\u0006\u0010L\u001a\u00020K¢\u0006\u0004\bM\u0010NJ=\u0010T\u001a\u00020\r2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010O2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010O2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010O2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010O¢\u0006\u0004\bT\u0010UJ\u0015\u0010W\u001a\u00020\r2\u0006\u0010V\u001a\u00020\u0007¢\u0006\u0004\bW\u0010\u0016J\u0015\u0010W\u001a\u00020\r2\u0006\u0010Y\u001a\u00020X¢\u0006\u0004\bW\u0010ZJ\u0015\u0010[\u001a\u00020\r2\u0006\u0010V\u001a\u00020\u0007¢\u0006\u0004\b[\u0010\u0016J\u0015\u0010\\\u001a\u00020\r2\u0006\u0010V\u001a\u00020\u0007¢\u0006\u0004\b\\\u0010\u0016J\u0015\u0010^\u001a\u00020\r2\u0006\u0010]\u001a\u00020!¢\u0006\u0004\b^\u0010-J\u000f\u0010_\u001a\u00020\rH\u0014¢\u0006\u0004\b_\u0010\u0011J\u000f\u0010a\u001a\u00020`H\u0014¢\u0006\u0004\ba\u0010bJ\u0019\u0010c\u001a\u00020`2\b\u0010\u0012\u001a\u0004\u0018\u00010`H\u0014¢\u0006\u0004\bc\u0010dJ\u0019\u0010c\u001a\u00020`2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\bc\u0010eJ\u0019\u0010f\u001a\u00020!2\b\u0010\u0012\u001a\u0004\u0018\u00010`H\u0014¢\u0006\u0004\bf\u0010gJ\u001f\u0010j\u001a\u00020\r2\u0006\u0010h\u001a\u00020\u00072\u0006\u0010i\u001a\u00020\u0007H\u0014¢\u0006\u0004\bj\u0010kJ7\u0010n\u001a\u00020\r2\u0006\u0010l\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u0007H\u0014¢\u0006\u0004\bn\u0010oJ/\u0010s\u001a\u00020!2\u0006\u0010p\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u001d2\u0006\u0010q\u001a\u00020\u00072\u0006\u0010r\u001a\u00020\u0007H\u0016¢\u0006\u0004\bs\u0010tJ/\u0010u\u001a\u00020\r2\u0006\u0010p\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u001d2\u0006\u0010q\u001a\u00020\u00072\u0006\u0010r\u001a\u00020\u0007H\u0016¢\u0006\u0004\bu\u0010vJ\u001f\u0010w\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u001d2\u0006\u0010r\u001a\u00020\u0007H\u0016¢\u0006\u0004\bw\u0010xJ7\u0010}\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u001d2\u0006\u0010y\u001a\u00020\u00072\u0006\u0010z\u001a\u00020\u00072\u0006\u0010|\u001a\u00020{2\u0006\u0010r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b}\u0010~JE\u0010\u0083\u0001\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u001d2\u0006\u0010\u007f\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u00072\u0007\u0010\u0081\u0001\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020\u00072\u0006\u0010r\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001JM\u0010\u0083\u0001\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u001d2\u0006\u0010\u007f\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u00072\u0007\u0010\u0081\u0001\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020\u00072\u0006\u0010r\u001a\u00020\u00072\u0006\u0010|\u001a\u00020{H\u0016¢\u0006\u0006\b\u0083\u0001\u0010\u0085\u0001J,\u0010\u0088\u0001\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u001d2\u0007\u0010\u0086\u0001\u001a\u00020%2\u0007\u0010\u0087\u0001\u001a\u00020%H\u0016¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J4\u0010\u008a\u0001\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u001d2\u0007\u0010\u0086\u0001\u001a\u00020%2\u0007\u0010\u0087\u0001\u001a\u00020%2\u0006\u0010|\u001a\u00020!H\u0016¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u0012\u0010\u008c\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u001c\u0010\u0090\u0001\u001a\u00020!2\b\u0010\u008f\u0001\u001a\u00030\u008e\u0001H\u0016¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u001c\u0010\u0093\u0001\u001a\u00020!2\b\u0010\u0092\u0001\u001a\u00030\u008e\u0001H\u0016¢\u0006\u0006\b\u0093\u0001\u0010\u0091\u0001J\u0019\u0010\u0094\u0001\u001a\u00020\r2\b\b\u0002\u0010S\u001a\u00020!¢\u0006\u0005\b\u0094\u0001\u0010-R\u0018\u0010\u0098\u0001\u001a\u00030\u0095\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001a\u0010\u009a\u0001\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bm\u0010\u0099\u0001R\u001b\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001b\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009c\u0001R\u001b\u0010¡\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010\u009c\u0001R\u0018\u0010(\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u0018\u0010¤\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001a\u0010£\u0001R\u0017\u00104\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b$\u0010¥\u0001R\u0017\u00109\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\"\u0010¥\u0001R\u0018\u0010§\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b0\u0010¦\u0001R\u001a\u0010©\u0001\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b)\u0010¨\u0001R\u001a\u0010«\u0001\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001c\u0010ª\u0001R\u001b\u0010®\u0001\u001a\u0005\u0018\u00010¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001f\u0010\u00ad\u0001R\u0019\u0010°\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010¯\u0001R\u0019\u0010²\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010¥\u0001R\u0018\u0010³\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0012\u0010¥\u0001R\u0019\u0010µ\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010¥\u0001R\u0018\u0010¶\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0015\u0010£\u0001R\u0016\u0010·\u0001\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b5\u0010£\u0001R\u0018\u0010¸\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bT\u0010¯\u0001R\u0018\u0010¹\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0013\u0010¯\u0001R\u0019\u0010¼\u0001\u001a\u00030º\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b,\u0010»\u0001R\u0018\u0010½\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0010\u0010£\u0001R\u0019\u0010¿\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010£\u0001R\u0019\u0010Á\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010£\u0001R\u0019\u0010Ã\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010¯\u0001R\u0019\u0010Å\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010¯\u0001R\u0019\u0010Ç\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010¥\u0001R'\u0010Ë\u0001\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÈ\u0001\u0010¯\u0001\u001a\u0005\bÉ\u0001\u0010#\"\u0005\bÊ\u0001\u0010-R\u0014\u0010Î\u0001\u001a\u00020\u000b8F¢\u0006\b\u001a\u0006\bÌ\u0001\u0010Í\u0001R\u0013\u0010Ï\u0001\u001a\u00020!8F¢\u0006\u0007\u001a\u0005\b´\u0001\u0010#¨\u0006Ñ\u0001"}, d2 = {"Lcom/obric/oui/pullrefresh/OPullRefreshLayout;", "Landroid/view/ViewGroup;", "Landroidx/core/view/NestedScrollingParent3;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/obric/oui/pullrefresh/RefreshState;", "newState", "", "setState", "(Lcom/obric/oui/pullrefresh/RefreshState;)V", "w", "()V", "p", "u", "targetOffset", "r", "(I)V", "target", "Lkotlin/Function0;", "endAction", "g", "(ILkotlin/jvm/functions/Function0;)V", "l", "Landroid/view/View;", "root", "m", "(Landroid/view/View;)Landroid/view/View;", "", "i", "()Z", "h", "", "fraction", "offsetY", "headerHeight", "k", "(FII)V", "enable", "v", "(Z)V", PerfConsts.KEY_CURRENT_GALVANIC, "deltaPull", "j", "(IF)I", "distance", "maxDistance", "dragDamping", "s", "(FFF)F", "setDragDamping", "(F)V", "triggerRate", "setTriggerRate", "headerInsetStartDp", "setHeaderInsetStartDp", "headerInsetStartPx", "setHeaderInsetStartPx", "Lcom/obric/oui/pullrefresh/OnRefreshListener;", "listener", "setOnRefreshListener", "(Lcom/obric/oui/pullrefresh/OnRefreshListener;)V", "Lkotlin/Function1;", "block", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/obric/oui/pullrefresh/OnStateChangeListener;", "setOnStateChangeListener", "(Lcom/obric/oui/pullrefresh/OnStateChangeListener;)V", "Lkotlin/Function3;", "(Lkotlin/jvm/functions/Function3;)V", "Lcom/obric/oui/pullrefresh/header/ORefreshHeader;", "header", "setRefreshHeader", "(Lcom/obric/oui/pullrefresh/header/ORefreshHeader;)V", "", "pull", "release", "refreshing", "success", "t", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "color", "setDefaultHeaderTextColor", "Landroid/content/res/ColorStateList;", "colors", "(Landroid/content/res/ColorStateList;)V", "setDefaultHeaderIconColor", "setDefaultHeaderProgressBackgroundColor", "enabled", "setNestedScrollEnabledWhileAnimatingOffset", "onFinishInflate", "Landroid/view/ViewGroup$LayoutParams;", "generateDefaultLayoutParams", "()Landroid/view/ViewGroup$LayoutParams;", "generateLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;", "(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;", "checkLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)Z", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "b", "onLayout", "(ZIIII)V", "child", "axes", "type", "onStartNestedScroll", "(Landroid/view/View;Landroid/view/View;II)Z", "onNestedScrollAccepted", "(Landroid/view/View;Landroid/view/View;II)V", "onStopNestedScroll", "(Landroid/view/View;I)V", "dx", "dy", "", "consumed", "onNestedPreScroll", "(Landroid/view/View;II[II)V", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScroll", "(Landroid/view/View;IIIII)V", "(Landroid/view/View;IIIII[I)V", "velocityX", "velocityY", "onNestedPreFling", "(Landroid/view/View;FF)Z", "onNestedFling", "(Landroid/view/View;FFZ)Z", "getNestedScrollAxes", "()I", "Landroid/view/MotionEvent;", "ev", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "event", "onTouchEvent", "n", "Landroidx/core/view/i;", "a", "Landroidx/core/view/i;", "parentHelper", "Lcom/obric/oui/pullrefresh/header/ORefreshHeader;", "refreshHeader", "c", "Landroid/view/View;", "headerView", "d", "contentView", "e", "scrollChild", "f", "I", "currentOffset", "F", "Lcom/obric/oui/pullrefresh/RefreshState;", "_state", "Lcom/obric/oui/pullrefresh/OnRefreshListener;", "onRefreshListener", "Lcom/obric/oui/pullrefresh/OnStateChangeListener;", "onStateChangeListener", "Ljb/d;", "Ljb/d;", "offsetAnimationManager", "Z", "isBeingDragged", "o", "initialDownY", "initialDownX", "q", "lastMotionY", "headerInsetStart", "touchSlop", "_isAnimatingOffset", "nestedScrollEnabledWhileAnimatingOffset", "", "J", "lastOnPullingDispatchTime", "selfOriginalLayerType", FixCard.FixStyle.KEY_X, "headerOriginalLayerType", FixCard.FixStyle.KEY_Y, "contentOriginalLayerType", "z", "layerTypeOverriddenForAnimation", "A", "isPerformedHapticFeedback", "B", "rubberRemainder", "C", "getRefreshEnable", "setRefreshEnable", "refreshEnable", "getState", "()Lcom/obric/oui/pullrefresh/RefreshState;", WsConstants.KEY_CONNECTION_STATE, "isRefreshing", "D", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPullRefreshLayout extends ViewGroup implements NestedScrollingParent3 {
    public static final b D = null;
    public boolean A;
    public float B;
    public boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f16453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ORefreshHeader f16454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f16455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f16456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f16457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f16458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f16459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f16460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f16461i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RefreshState f16462j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OnRefreshListener f16463k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OnStateChangeListener f16464l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public jb.d f16465m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f16466n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f16467o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f16468p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f16469q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f16470r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f16471s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f16472t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f16473u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f16474v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f16475w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f16476x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f16477y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f16478z;

    public static final class a implements ORefreshHeader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f16479a;

        public a(View r10) {
            this.f16479a = r10;
        }

        @Override // com.obric.oui.pullrefresh.header.ORefreshHeader
        public View getView() {
            View r10 = this.f16479a;
            q.f(r10, "view");
            return r10;
        }

        @Override // com.obric.oui.pullrefresh.header.ORefreshHeader
        public void onFinish(OPullRefreshLayout r10, boolean r11) {
            q.g(r10, "layout");
        }

        @Override // com.obric.oui.pullrefresh.header.ORefreshHeader
        public void onPulling(OPullRefreshLayout r10, float r11, float r12, float r13) {
            q.g(r10, "layout");
        }

        @Override // com.obric.oui.pullrefresh.header.ORefreshHeader
        public void onStateChanged(OPullRefreshLayout r10, RefreshState r11, RefreshState r12) {
            q.g(r10, "layout");
            q.g(r11, "oldState");
            q.g(r12, "newState");
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public b() {
        }
    }

    public static final class c implements OnRefreshListener, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f16480a;

        public c(Function1 r10) {
            this.f16480a = r10;
        }

        public final boolean equals(Object r10) {
            if ((r10 instanceof OnRefreshListener) == true) goto L5;
            return false;
        L5:
            if ((r10 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return q.b(getFunctionDelegate(), ((FunctionAdapter) r10).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return this.f16480a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // com.obric.oui.pullrefresh.OnRefreshListener
        public final /* synthetic */ void onRefresh(OPullRefreshLayout r10) {
            this.f16480a.invoke(r10);
        }
    }

    public static final class d implements OnStateChangeListener, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function3 f16481a;

        public d(Function3 r10) {
            this.f16481a = r10;
        }

        public final boolean equals(Object r10) {
            if ((r10 instanceof OnStateChangeListener) == true) goto L5;
            return false;
        L5:
            if ((r10 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return q.b(getFunctionDelegate(), ((FunctionAdapter) r10).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return this.f16481a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // com.obric.oui.pullrefresh.OnStateChangeListener
        public final /* synthetic */ void onStateChanged(OPullRefreshLayout r10, RefreshState r11, RefreshState r12) {
            this.f16481a.invoke(r10, r11, r12);
        }
    }

    static {
        D = new b(null);
    }

    @JvmOverloads
    public OPullRefreshLayout(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ void a(OPullRefreshLayout r10, boolean r11) {
        o(r10, r11);
    }

    public static final /* synthetic */ void b(OPullRefreshLayout r10, int r11) {
        r10.r(r11);
    }

    public static final /* synthetic */ void c(OPullRefreshLayout r10, jb.d r11) {
        r10.f16465m = r11;
    }

    public static final /* synthetic */ void d(OPullRefreshLayout r10, RefreshState r11) {
        r10.setState(r11);
    }

    public static final /* synthetic */ void e(OPullRefreshLayout r10, boolean r11) {
        r10.f16472t = r11;
    }

    public static final /* synthetic */ void f(OPullRefreshLayout r10, boolean r11) {
        r10.v(r11);
    }

    public static final void o(final OPullRefreshLayout r10, boolean r11) {
        q.g(r10, "this$0");
        ORefreshHeader r12 = r10.f16454b;
        if (r12 == null) goto L6;
        r12.onFinish(r10, r11);
    L6:
        r10.g(0, new OPullRefreshLayout$finishRefresh$1$1(r10));
    }

    private final void setState(RefreshState r10) {
        RefreshState r11 = this.f16462j;
        if (r11 != r10) goto L5;
        return;
    L5:
        this.f16462j = r10;
        ORefreshHeader r12 = this.f16454b;
        if (r12 == null) goto L9;
        r12.onStateChanged(this, r11, r10);
    L9:
        OnStateChangeListener r13 = this.f16464l;
        if (r13 == null) goto L14;
        r13.onStateChanged(this, r11, r10);
        return;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof ViewGroup.MarginLayoutParams;
    }

    public final void g(int r13, final Function0 r14) {
        int r10 = this.f16459g;
        if (r10 != r13) goto L8;
        if (r14 == null) goto L30;
        r14.invoke();
        return;
    L30:
        return;
    L8:
        int r11 = Math.abs(r10 - r13);
        if (ViewCompat.T(this) == true) goto L11;
    L21:
        jb.d r12 = this.f16465m;
        if (r12 == null) goto L25;
        jb.d.c(r12, false, 1, null);
    L25:
        r(r13);
        if (r14 == null) goto L31;
        r14.invoke();
        return;
    L31:
        return;
    L11:
        if (isAttachedToWindow() == false) goto L21;
        if (r11 <= 2) goto L21;
        jb.d r15 = this.f16465m;
        if (r15 == null) goto L19;
        jb.d.c(r15, false, 1, null);
    L19:
        this.f16465m = com.obric.common.oea.foundation.animation.builder.d.a.e(new com.obric.common.oea.foundation.animation.builder.d.a(), this.f16459g, r13, kb.a.d(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null), null, 8, null).g(new OPullRefreshLayout$animateOffsetTo$1(this)).f(new OPullRefreshLayout$animateOffsetTo$2(this, r14)).c().a();
        this.f16472t = true;
        v(true);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new ViewGroup.MarginLayoutParams(r10);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f16453a.a();
    }

    public final boolean getRefreshEnable() {
        return this.C;
    }

    @NotNull
    public final RefreshState getState() {
        return this.f16462j;
    }

    public final void h() {
        float r10 = this.f16459g;
        View r11 = this.f16455c;
        if (r11 != null) goto L6;
    L9:
        View r12 = this.f16456d;
        if (r12 != null) goto L13;
        return;
    L13:
        if (r12.getTranslationY() == r10) goto L18;
        r12.setTranslationY(r10);
        return;
    L18:
        return;
    L6:
        if (r11.getTranslationY() == r10) goto L9;
        r11.setTranslationY(r10);
        goto L9
    }

    public final boolean i() {
        View r10 = this.f16457e;
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.canScrollVertically(-1) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public final int j(int r10, float r11) {
        int r12 = this.f16458f;
        if (r12 <= 0) goto L5;
        float r13 = r12 * 2.0f;
    L6:
        float r14 = r10;
        float r15 = (s(h.c(r14 + r11, 0.0f), r13, this.f16460h) - s(r14, r13, this.f16460h)) + this.B;
        int r16 = (int) r15;
        this.B = r15 - r16;
        return r16;
    L5:
        r13 = h.c(getMeasuredHeight() * 2.0f, 1.0f);
        goto L6
    }

    public final void k(float r10, int r11, int r12) {
        long r13 = SystemClock.uptimeMillis();
        if ((r13 - this.f16474v) >= 16) goto L8;
        if (r11 == 0) goto L8;
        if (r11 == r12) goto L8;
        return;
    L8:
        this.f16474v = r13;
        ORefreshHeader r14 = this.f16454b;
        if (r14 == null) goto L13;
        r14.onPulling(this, r10, r11, r12);
        return;
    }

    public final void l() {
        if (this.f16456d == null) goto L5;
        return;
    L5:
        int r10 = getChildCount();
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L14;
        int r12 = r11 + 1;
        View r13 = getChildAt(r11);
        if (r13 != this.f16455c) goto L9;
        r11 = r12;
        goto L6
    L9:
        this.f16456d = r13;
        return;
    }

    public final View m(View r10) {
        if (r10 != null) goto L5;
    L24:
        return null;
    L5:
        if (r10 == this.f16455c) goto L24;
        if ((r10 instanceof ScrollView) == false) goto L10;
    L23:
        return r10;
    L10:
        if ((r10 instanceof AbsListView) == true) goto L23;
        if ((r10 instanceof NestedScrollingChild) == true) goto L23;
        if ((r10 instanceof ViewGroup) == false) goto L22;
        ViewGroup r11 = (ViewGroup) r10;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L17:
        if (r13 >= r12) goto L22;
        int r14 = r13 + 1;
        View r15 = m(r11.getChildAt(r13));
        if (r15 != null) goto L20;
        r13 = r14;
        goto L17
    L20:
        return r15;
    L22:
        return null;
    }

    public final void n(final boolean r10) {
        RefreshState r11 = this.f16462j;
        if (r11 != RefreshState.REFRESHING) goto L5;
    L7:
        setState(RefreshState.FINISH);
        postDelayed(new com.obric.oui.pullrefresh.a(this, r10), 200);
        return;
    L5:
        if (r11 == RefreshState.RELEASE_TO_REFRESH) goto L7;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        l();
        this.f16457e = m(this.f16456d);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        q.g(r10, "ev");
        boolean r11 = false;
        if (isEnabled() == true) goto L5;
    L57:
        return false;
    L5:
        if (this.C == false) goto L57;
        int r12 = r10.getActionMasked();
        if (r12 != 0) goto L10;
        this.f16466n = false;
        this.f16467o = r10.getY();
        this.f16468p = r10.getX();
        this.f16469q = this.f16467o;
    L56:
        return this.f16466n;
    L10:
        if (r12 != 1) goto L12;
    L53:
        this.f16466n = false;
        goto L56
    L12:
        if (r12 == 2) goto L17;
        if (r12 == 3) goto L53;
    L17:
        if (this.f16466n == true) goto L56;
        float r13 = r10.getY() - this.f16467o;
        float r14 = r10.getX() - this.f16468p;
        float r15 = Math.abs(r13);
        float r16 = Math.abs(r14);
        if (r15 <= this.f16471s) goto L56;
        if (r15 <= r16) goto L56;
        if (this.f16457e != null) goto L25;
    L28:
        boolean r17 = true;
    L30:
        if (r13 <= 0.0f) goto L32;
        boolean r18 = true;
    L34:
        if (r13 < 0.0f) goto L36;
    L38:
        boolean r19 = false;
    L40:
        if ((this.f16457e instanceof NestedScrollingChild) == true) goto L42;
    L44:
        if (r18 == false) goto L47;
        if (r11 == true) goto L47;
        if (r17 == false) goto L47;
    L49:
        this.f16466n = true;
        this.f16469q = r10.getY();
        ViewParent r20 = getParent();
        if (r20 == null) goto L56;
        r20.requestDisallowInterceptTouchEvent(true);
    L47:
        if (r19 == false) goto L56;
        if (r11 == true) goto L56;
    L42:
        if ((this.f16456d instanceof CoordinatorLayout) == true) goto L44;
        r11 = true;
        goto L44
    L36:
        if (this.f16459g <= 0) goto L38;
        r19 = true;
        goto L40
    L32:
        r18 = false;
        goto L34
    L25:
        if (i() == false) goto L28;
        r17 = false;
        goto L30
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        l();
        int r15 = getMeasuredWidth();
        int r16 = getMeasuredHeight();
        if (r15 == 0) goto L24;
        if (r16 == 0) goto L25;
        int r17 = getPaddingLeft();
        int r18 = getPaddingTop();
        int r19 = r15 - getPaddingRight();
        int r20 = r16 - getPaddingBottom();
        View r110 = this.f16455c;
        if (r110 == null) goto L12;
        ViewGroup.LayoutParams r21 = r110.getLayoutParams();
        if (r21 == null) goto L23;
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r21;
        int r23 = r110.getMeasuredHeight();
        int r24 = r22.leftMargin + r17;
        int r25 = ((r18 - r23) + this.f16470r) + r22.topMargin;
        r110.layout(r24, r25, r110.getMeasuredWidth() + r24, r23 + r25);
        goto L12
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L12:
        View r111 = this.f16456d;
        if (r111 == null) goto L18;
        ViewGroup.LayoutParams r26 = r111.getLayoutParams();
        if (r26 == null) goto L21;
        ViewGroup.MarginLayoutParams r27 = (ViewGroup.MarginLayoutParams) r26;
        r111.layout(r17 + r27.leftMargin, r18 + r27.topMargin, r19 - r27.rightMargin, r20 - r27.bottomMargin);
        goto L18
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L18:
        h();
        return;
    L25:
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        l();
        int r12 = getMeasuredWidth();
        int r13 = getMeasuredHeight();
        if (r12 == 0) goto L19;
        if (r13 == 0) goto L21;
        int r14 = View.MeasureSpec.makeMeasureSpec((r12 - getPaddingLeft()) - getPaddingRight(), Ints.MAX_POWER_OF_TWO);
        int r15 = View.MeasureSpec.makeMeasureSpec((r13 - getPaddingTop()) - getPaddingBottom(), Ints.MAX_POWER_OF_TWO);
        View r16 = this.f16456d;
        if (r16 == null) goto L10;
        r16.measure(r14, r15);
    L10:
        View r17 = this.f16455c;
        if (r17 == null) goto L20;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 == null) goto L18;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        r17.measure(ViewGroup.getChildMeasureSpec(r10, ((getPaddingLeft() + getPaddingRight()) + r19.leftMargin) + r19.rightMargin, r19.width), ViewGroup.getChildMeasureSpec(r11, ((getPaddingTop() + getPaddingBottom()) + r19.topMargin) + r19.bottomMargin, r19.height));
        this.f16458f = r17.getMeasuredHeight();
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L20:
        return;
    L21:
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r10, float r11, float r12, boolean r13) {
        q.g(r10, "target");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r10, float r11, float r12) {
        q.g(r10, "target");
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View r10, int r11, int r12, int[] r13, int r14) {
        q.g(r10, "target");
        q.g(r13, "consumed");
        if (r14 == 0) goto L6;
        return;
    L6:
        if (this.C == true) goto L9;
        return;
    L9:
        if (this.f16473u == true) goto L14;
        if (this.f16472t == false) goto L14;
        return;
    L14:
        if (r12 <= 0) goto L18;
        int r15 = this.f16459g;
        if (r15 <= 0) goto L18;
        int r16 = Math.min(r12, r15);
        r(this.f16459g - r16);
        r13[1] = r16;
    L18:
        if (r12 < 0) goto L20;
        return;
    L20:
        if (i() == false) goto L22;
        return;
    L22:
        if (this.f16462j == RefreshState.REFRESHING) goto L29;
        int r17 = j(this.f16459g, Math.abs(r12));
        if (r17 <= 0) goto L30;
        r(this.f16459g + r17);
        r13[1] = r12;
        return;
    L30:
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15) {
        q.g(r10, "target");
        onNestedScroll(r10, r11, r12, r13, r14, r15, new int[2]);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r10, View r11, int r12, int r13) {
        q.g(r10, "child");
        q.g(r11, "target");
        this.f16453a.c(r10, r11, r12, r13);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r10, View r11, int r12, int r13) {
        q.g(r10, "child");
        q.g(r11, "target");
        if (isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.C == false) goto L9;
        if ((r12 & 2) == 0) goto L9;
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r10, int r11) {
        q.g(r10, "target");
        this.f16453a.e(r10, r11);
        if (r11 == 0) goto L5;
        return;
    L5:
        if (this.f16462j == RefreshState.REFRESHING) goto L9;
        p();
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        q.g(r10, "event");
        if (isEnabled() == false) goto L62;
        if (this.C == false) goto L62;
        int r11 = r10.getActionMasked();
        if (r11 == 0) goto L59;
        if (r11 == 1) goto L52;
        if (r11 != 2) goto L13;
        float r12 = r10.getY();
        float r13 = r12 - this.f16469q;
        this.f16469q = r12;
        if (this.f16466n == true) goto L32;
        float r14 = r12 - this.f16467o;
        float r15 = r10.getX() - this.f16468p;
        float r16 = Math.abs(r14);
        float r17 = Math.abs(r15);
        if (r16 <= this.f16471s) goto L32;
        if (r16 <= r17) goto L32;
        if (r14 <= 0.0f) goto L32;
        if (this.f16457e != null) goto L26;
    L27:
        this.f16466n = true;
        this.f16469q = r12;
        ViewParent r18 = getParent();
        if (r18 == null) goto L32;
        r18.requestDisallowInterceptTouchEvent(true);
        goto L32
    L26:
        if (i() == false) goto L27;
    L32:
        if (this.f16466n == true) goto L34;
    L58:
        return super.onTouchEvent(r10);
    L34:
        if (r13 < 0.0f) goto L36;
    L38:
        if (r13 >= 0.0f) goto L48;
        int r19 = Math.min((int) Math.abs(r13), this.f16459g);
        if (r19 <= 0) goto L42;
        r(this.f16459g - r19);
    L42:
        this.B = 0.0f;
        if (((int) Math.abs(r13)) <= r19) goto L46;
        this.f16466n = false;
        return false;
    L46:
        return true;
    L48:
        if (q() == true) goto L50;
        int r110 = this.f16459g;
        r(r110 + j(r110, r13));
    L50:
        return true;
    L36:
        if (this.f16459g > 0) goto L38;
        return false;
    L13:
        if (r11 != 3) goto L58;
    L52:
        if (this.f16466n == false) goto L58;
        this.f16466n = false;
        if (this.f16462j == RefreshState.REFRESHING) goto L56;
        p();
    L56:
        return true;
    L59:
        this.f16466n = false;
        this.f16467o = r10.getY();
        this.f16468p = r10.getX();
        this.f16469q = this.f16467o;
        return true;
    L62:
        return super.onTouchEvent(r10);
    }

    public final void p() {
        int r10 = this.f16458f;
        if (r10 > 0) goto L6;
        return;
    L6:
        if (this.f16459g < ((int) (r10 * this.f16461i))) goto L12;
        RefreshState r11 = this.f16462j;
        if (r11 != RefreshState.RELEASE_TO_REFRESH) goto L10;
    L11:
        u();
        return;
    L10:
        if (r11 == RefreshState.PULL_TO_REFRESH) goto L11;
    L12:
        g(0, new OPullRefreshLayout$finishSpinner$1(this));
    }

    public final boolean q() {
        if (this.f16462j != RefreshState.REFRESHING) goto L5;
        return true;
    L5:
        return false;
    }

    public final void r(int r10) {
        int r11 = Math.max(0, r10);
        if (r11 != this.f16459g) goto L5;
        return;
    L5:
        this.f16459g = r11;
        h();
        int r12 = this.f16458f;
        if (r12 <= 0) goto L9;
        k(h.j(this.f16459g / r12, 0.0f, 1.0f), this.f16459g, this.f16458f);
    L9:
        if (this.f16462j == RefreshState.REFRESHING) goto L11;
    L14:
        w();
        ViewCompat.g0(this);
        return;
    L11:
        if (this.f16459g != 0) goto L14;
        n(true);
        ViewCompat.g0(this);
    }

    public final float s(float r10, float r11, float r12) {
        float r13 = h.j(r12, 0.01f, 1.0f);
        float r14 = Math.max(1.0f, r11);
        return (1.0f - (1.0f / (((r10 * r13) / r14) + 1.0f))) * r14;
    }

    public final void setDefaultHeaderIconColor(int r10) {
        ORefreshHeader r11 = this.f16454b;
        if ((r11 instanceof ODefaultRefreshHeader) == false) goto L5;
        ODefaultRefreshHeader r12 = (ODefaultRefreshHeader) r11;
    L6:
        if (r12 == null) goto L10;
        r12.setIconColor(r10);
        return;
    L10:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void setDefaultHeaderProgressBackgroundColor(int r10) {
        ORefreshHeader r11 = this.f16454b;
        if ((r11 instanceof ODefaultRefreshHeader) == false) goto L5;
        ODefaultRefreshHeader r12 = (ODefaultRefreshHeader) r11;
    L6:
        if (r12 == null) goto L10;
        r12.setProgressBackgroundColor(r10);
        return;
    L10:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void setDefaultHeaderTextColor(int r10) {
        ORefreshHeader r11 = this.f16454b;
        if ((r11 instanceof ODefaultRefreshHeader) == false) goto L5;
        ODefaultRefreshHeader r12 = (ODefaultRefreshHeader) r11;
    L6:
        if (r12 == null) goto L10;
        r12.setTextColor(r10);
        return;
    L10:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void setDragDamping(float r10) {
        this.f16460h = r10;
    }

    public final void setHeaderInsetStartDp(float r10) {
        this.f16470r = f.q(this, r10);
    }

    public final void setHeaderInsetStartPx(int r10) {
        this.f16470r = r10;
    }

    public final void setNestedScrollEnabledWhileAnimatingOffset(boolean r10) {
        this.f16473u = r10;
    }

    public final void setOnRefreshListener(@Nullable OnRefreshListener r10) {
        this.f16463k = r10;
    }

    public final void setOnStateChangeListener(@Nullable OnStateChangeListener r10) {
        this.f16464l = r10;
    }

    public final void setRefreshEnable(boolean r10) {
        this.C = r10;
    }

    public final void setRefreshHeader(@NotNull ORefreshHeader r10) {
        q.g(r10, "header");
        View r11 = this.f16455c;
        if (r11 == null) goto L6;
        removeView(r11);
    L6:
        this.f16454b = r10;
        View r12 = r10.getView();
        this.f16455c = r12;
        addView(r12, 0);
        requestLayout();
    }

    public final void setTriggerRate(float r10) {
        this.f16461i = r10;
    }

    public final void t(CharSequence r10, CharSequence r11, CharSequence r12, CharSequence r13) {
        ORefreshHeader r14 = this.f16454b;
        if ((r14 instanceof ODefaultRefreshHeader) == false) goto L5;
        ODefaultRefreshHeader r15 = (ODefaultRefreshHeader) r14;
    L6:
        if (r15 == null) goto L10;
        r15.b(r10, r11, r12, r13);
        return;
    L10:
        return;
    L5:
        r15 = null;
        goto L6
    }

    public final void u() {
        if (this.f16458f > 0) goto L11;
        View r10 = this.f16455c;
        if (r10 != null) goto L7;
        int r11 = 0;
    L8:
        this.f16458f = r11;
        if (r11 > 0) goto L11;
        return;
    L7:
        r11 = r10.getMeasuredHeight();
    L11:
        setState(RefreshState.REFRESHING);
        g(this.f16458f, null);
        OnRefreshListener r12 = this.f16463k;
        if (r12 == null) goto L16;
        r12.onRefresh(this);
        return;
    }

    public final void v(boolean r10) {
        View r11 = this.f16455c;
        View r12 = this.f16456d;
        int r13 = 0;
        if (r10 == false) goto L23;
        if (this.f16478z == true) goto L15;
        this.f16478z = true;
        this.f16475w = getLayerType();
        if (r11 != null) goto L9;
        int r14 = 0;
    L10:
        this.f16476x = r14;
        if (r12 == null) goto L14;
        r13 = r12.getLayerType();
    L14:
        this.f16477y = r13;
        goto L15
    L9:
        r14 = r11.getLayerType();
    L15:
        setLayerType(2, null);
        if (r11 == null) goto L19;
        r11.setLayerType(2, null);
    L19:
        if (r12 == null) goto L34;
        r12.setLayerType(2, null);
        return;
    L34:
        return;
    L23:
        if (this.f16478z == false) goto L33;
        this.f16478z = false;
        setLayerType(this.f16475w, null);
        if (r11 == null) goto L28;
        r11.setLayerType(this.f16476x, null);
    L28:
        if (r12 == null) goto L35;
        r12.setLayerType(this.f16477y, null);
        return;
    L35:
        return;
    }

    public final void w() {
        RefreshState r10 = this.f16462j;
        if (r10 != RefreshState.REFRESHING) goto L5;
        return;
    L5:
        if (r10 == RefreshState.FINISH) goto L19;
        int r11 = (int) (this.f16458f * this.f16461i);
        int r12 = this.f16459g;
        if (r12 > 0) goto L10;
        RefreshState r13 = RefreshState.IDLE;
    L16:
        setState(r13);
        return;
    L10:
        if (r12 >= r11) goto L13;
        this.A = false;
        r13 = RefreshState.PULL_TO_REFRESH;
        goto L16
    L13:
        if (this.A == true) goto L15;
        this.A = true;
        dd.a.f19178a.a(this, 4);
    L15:
        r13 = RefreshState.RELEASE_TO_REFRESH;
        goto L16
    }

    @JvmOverloads
    public OPullRefreshLayout(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return new ViewGroup.MarginLayoutParams(getContext(), r10);
    }

    public final void setDefaultHeaderTextColor(@NotNull ColorStateList r10) {
        q.g(r10, "colors");
        ORefreshHeader r11 = this.f16454b;
        if ((r11 instanceof ODefaultRefreshHeader) == false) goto L5;
        ODefaultRefreshHeader r12 = (ODefaultRefreshHeader) r11;
    L6:
        if (r12 == null) goto L10;
        r12.setTextColor(r10);
        return;
    L10:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void setOnRefreshListener(@NotNull Function1<? super OPullRefreshLayout, Unit> r10) {
        q.g(r10, "block");
        this.f16463k = new c(r10);
    }

    public final void setOnStateChangeListener(@NotNull Function3<? super OPullRefreshLayout, ? super RefreshState, ? super RefreshState, Unit> r10) {
        q.g(r10, "block");
        this.f16464l = new d(r10);
    }

    public /* synthetic */ OPullRefreshLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15, int[] r16) {
        q.g(r10, "target");
        q.g(r16, "consumed");
        if (r15 == 0) goto L6;
        return;
    L6:
        if (this.C == true) goto L9;
        return;
    L9:
        if (this.f16473u == false) goto L11;
    L13:
        if (r14 < 0) goto L15;
        return;
    L15:
        if (i() == false) goto L17;
        return;
    L17:
        if (q() == true) goto L24;
        int r17 = j(this.f16459g, Math.abs(r14));
        if (r17 <= 0) goto L25;
        r(this.f16459g + r17);
        r16[1] = r16[1] + r14;
        return;
    L25:
        return;
    L24:
        return;
    L11:
        if (this.f16472t == false) goto L13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OPullRefreshLayout(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f16453a = new i(this);
        this.f16460h = 0.8f;
        this.f16461i = 1.0f;
        this.f16462j = RefreshState.IDLE;
        this.f16471s = ViewConfiguration.get(r10).getScaledTouchSlop();
        this.f16473u = true;
        this.C = true;
        setChildrenDrawingOrderEnabled(true);
        setClipToPadding(true);
        setClipChildren(true);
        AttributeSet r13 = null;
        Object[] r14 = 0;
        if (r11 == null) goto L25;
        TypedArray r15 = r10.obtainStyledAttributes(r11, R$styleable.OPullRefreshLayout, r12, 0);
        q.f(r15, "context.obtainStyledAttr…          0\n            )");
        this.f16460h = h.j(r15.getFloat(R$styleable.OPullRefreshLayout_o_pr_dragDamping, 0.8f), 0.2f, 1.0f);
        this.f16461i = h.c(r15.getFloat(R$styleable.OPullRefreshLayout_o_pr_triggerRate, 1.0f), 0.5f);
        this.f16470r = r15.getDimensionPixelOffset(R$styleable.OPullRefreshLayout_o_pr_headerInsetStart, 0);
        this.C = r15.getBoolean(R$styleable.OPullRefreshLayout_o_pr_refreshEnable, true);
        String r16 = r15.getString(R$styleable.OPullRefreshLayout_o_pr_defaultHeaderTextPull);
        String r17 = r15.getString(R$styleable.OPullRefreshLayout_o_pr_defaultHeaderTextRelease);
        String r18 = r15.getString(R$styleable.OPullRefreshLayout_o_pr_defaultHeaderTextRefreshing);
        String r19 = r15.getString(R$styleable.OPullRefreshLayout_o_pr_defaultHeaderTextSuccess);
        int r20 = R$styleable.OPullRefreshLayout_o_pr_defaultHeaderTextColor;
        if (r15.hasValue(r20) == false) goto L7;
        Integer r21 = Integer.valueOf(r15.getColor(r20, 0));
    L8:
        int r22 = R$styleable.OPullRefreshLayout_o_pr_defaultHeaderIconColor;
        if (r15.hasValue(r22) == false) goto L11;
        Integer r23 = Integer.valueOf(r15.getColor(r22, 0));
    L12:
        int r24 = R$styleable.OPullRefreshLayout_o_pr_defaultHeaderProgressBackgroundColor;
        if (r15.hasValue(r24) == false) goto L15;
        Integer r25 = Integer.valueOf(r15.getColor(r24, 0));
    L16:
        int r26 = r15.getResourceId(R$styleable.OPullRefreshLayout_o_pr_headerView, 0);
        r15.recycle();
        if (r26 == 0) goto L27;
        View r110 = ViewGroup.inflate(r10, r26, null);
        if ((r110 instanceof ORefreshHeader) == false) goto L21;
        ORefreshHeader r27 = (ORefreshHeader) r110;
    L22:
        if (r27 == null) goto L24;
        setRefreshHeader(r27);
        goto L27
    L24:
        setRefreshHeader(new a(r110));
        goto L27
    L21:
        r27 = null;
    L27:
        if (this.f16454b != null) goto L29;
        setRefreshHeader(new ODefaultRefreshHeader(r10, r13, 2, r14 == true ? 1 : 0));
    L29:
        t(r16, r17, r18, r19);
        if (r21 == null) goto L33;
        setDefaultHeaderTextColor(r21.intValue());
    L33:
        if (r25 == null) goto L36;
        setDefaultHeaderProgressBackgroundColor(r25.intValue());
    L36:
        if (r23 == null) goto L40;
        setDefaultHeaderIconColor(r23.intValue());
        return;
    L40:
        return;
    L15:
        r25 = null;
        goto L16
    L11:
        r23 = null;
        goto L12
    L7:
        r21 = null;
        goto L8
    L25:
        r16 = null;
        r17 = null;
        r18 = null;
        r19 = null;
        r21 = null;
        r23 = null;
        r25 = null;
        goto L27
    }
}
