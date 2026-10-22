package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.checkbox.OCheckMark;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.text.OTextView;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.card.FixCard;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0002\u009d\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u000eJ\u000f\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u000eJ\u001f\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001c\u0010\u000eJ\u000f\u0010\u001d\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001d\u0010\u000eJ\u0015\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b!\u0010 J\u0015\u0010!\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\"¢\u0006\u0004\b!\u0010#J\r\u0010$\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b&\u0010#J\u0015\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0018¢\u0006\u0004\b(\u0010)J\u0015\u0010+\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0018¢\u0006\u0004\b+\u0010)J\r\u0010,\u001a\u00020\u0018¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u0006¢\u0006\u0004\b/\u0010 J\u001d\u00102\u001a\u00020\n2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\u0006¢\u0006\u0004\b4\u00105J!\u00108\u001a\u00020\n2\u0006\u00106\u001a\u00020\u00062\b\b\u0002\u00107\u001a\u00020\u0018H\u0007¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\u0006¢\u0006\u0004\b:\u00105J\r\u0010;\u001a\u00020\u0001¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\u0001¢\u0006\u0004\b=\u0010<J\r\u0010?\u001a\u00020>¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\bA\u0010BJ\u0015\u0010A\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u0006¢\u0006\u0004\bA\u0010 J\u0015\u0010E\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u0006¢\u0006\u0004\bE\u0010 J\u000f\u0010F\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010I\u001a\u0004\u0018\u00010H¢\u0006\u0004\bI\u0010JJ\u0015\u0010K\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0018¢\u0006\u0004\bK\u0010)J\u0017\u0010N\u001a\u00020\n2\b\u0010M\u001a\u0004\u0018\u00010L¢\u0006\u0004\bN\u0010OJ\u0015\u0010N\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u0006¢\u0006\u0004\bN\u0010 J\u0017\u0010P\u001a\u00020\n2\b\u0010M\u001a\u0004\u0018\u00010L¢\u0006\u0004\bP\u0010OJ\u0015\u0010P\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u0006¢\u0006\u0004\bP\u0010 J\r\u0010R\u001a\u00020Q¢\u0006\u0004\bR\u0010SJ\u0015\u0010T\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0018¢\u0006\u0004\bT\u0010)J\u0017\u0010W\u001a\u00020\n2\b\u0010V\u001a\u0004\u0018\u00010U¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u0004\u0018\u00010U¢\u0006\u0004\bY\u0010ZJ\r\u0010\\\u001a\u00020[¢\u0006\u0004\b\\\u0010]J\u0015\u0010^\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0018¢\u0006\u0004\b^\u0010)J\u0017\u0010_\u001a\u00020\n2\b\u0010V\u001a\u0004\u0018\u00010U¢\u0006\u0004\b_\u0010XJ\u000f\u0010`\u001a\u0004\u0018\u00010U¢\u0006\u0004\b`\u0010ZJ\r\u0010a\u001a\u00020[¢\u0006\u0004\ba\u0010]J\u0015\u0010b\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0018¢\u0006\u0004\bb\u0010)J\r\u0010d\u001a\u00020c¢\u0006\u0004\bd\u0010eJ+\u0010h\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010f\u001a\u00020\u00062\b\b\u0002\u0010g\u001a\u00020\u0018H\u0007¢\u0006\u0004\bh\u0010iJ)\u0010j\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u00062\b\b\u0002\u0010g\u001a\u00020\u0018H\u0007¢\u0006\u0004\bj\u0010kJ)\u0010m\u001a\u00020\n2\u0006\u0010l\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u00062\b\b\u0002\u0010g\u001a\u00020\u0018H\u0007¢\u0006\u0004\bm\u0010kJ\r\u0010n\u001a\u00020\n¢\u0006\u0004\bn\u0010\u000eJ\u0017\u0010o\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\bo\u0010BJ\u0015\u0010o\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u0006¢\u0006\u0004\bo\u0010 J\u0015\u0010q\u001a\u00020\n2\u0006\u0010p\u001a\u00020\u0006¢\u0006\u0004\bq\u0010 J\u000f\u0010r\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\br\u0010GJ\u000f\u0010s\u001a\u0004\u0018\u00010H¢\u0006\u0004\bs\u0010JJ\u000f\u0010u\u001a\u0004\u0018\u00010t¢\u0006\u0004\bu\u0010vJ\u000f\u0010x\u001a\u0004\u0018\u00010w¢\u0006\u0004\bx\u0010yJ\u000f\u0010z\u001a\u0004\u0018\u00010[¢\u0006\u0004\bz\u0010]J#\u0010|\u001a\u00020\n2\b\u0010V\u001a\u0004\u0018\u00010U2\b\b\u0002\u0010{\u001a\u00020\u0006H\u0007¢\u0006\u0004\b|\u0010}J\u0015\u0010~\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0018¢\u0006\u0004\b~\u0010)J\u0017\u0010\u007f\u001a\u00020\n2\b\u0010M\u001a\u0004\u0018\u00010L¢\u0006\u0004\b\u007f\u0010OJ\u0015\u0010\u007f\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u0006¢\u0006\u0004\b\u007f\u0010 J\u0018\u0010\u0081\u0001\u001a\u00020\n2\u0007\u0010\u0080\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u0081\u0001\u0010 J\u000f\u0010\u0082\u0001\u001a\u00020Q¢\u0006\u0005\b\u0082\u0001\u0010SJ\u0017\u0010\u0083\u0001\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0018¢\u0006\u0005\b\u0083\u0001\u0010)J\u0017\u0010\u0084\u0001\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0018¢\u0006\u0005\b\u0084\u0001\u0010)J\u0018\u0010\u0086\u0001\u001a\u00020\n2\u0007\u0010\u0085\u0001\u001a\u00020\u0018¢\u0006\u0005\b\u0086\u0001\u0010)J\u0018\u0010\u0087\u0001\u001a\u00020\n2\u0007\u0010\u0085\u0001\u001a\u00020\u0018¢\u0006\u0005\b\u0087\u0001\u0010)J\u0019\u0010\u0088\u0001\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0005\b\u0088\u0001\u0010BJ\u0017\u0010\u0088\u0001\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u0006¢\u0006\u0005\b\u0088\u0001\u0010 J\u0011\u0010\u008a\u0001\u001a\u00030\u0089\u0001¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u0011\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0016¢\u0006\u0005\b\u008c\u0001\u0010GJ\u001c\u0010\u008f\u0001\u001a\u00020\n2\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u0001¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u001c\u0010\u0092\u0001\u001a\u00020\n2\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u0091\u0001¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0019\u0010\u0094\u0001\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0005\b\u0094\u0001\u0010)J\u001e\u0010\u0097\u0001\u001a\u00020\n2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0014¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0018\u0010\u009c\u0001\u001a\u00030\u0099\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0019\u0010\u009f\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0018\u0010¡\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b \u0001\u0010\u0015R\u0017\u0010¤\u0001\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u0018\u0010¨\u0001\u001a\u00030¥\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u0017\u0010«\u0001\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u001c\u0010¯\u0001\u001a\u0005\u0018\u00010¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R\u0018\u0010±\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0012\u0010°\u0001R\u001a\u0010²\u0001\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0010\u0010°\u0001R\u0016\u0010³\u0001\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bn\u0010£\u0001R\u0016\u0010´\u0001\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u000b\u0010£\u0001R\u0016\u0010¶\u0001\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001a\u0010µ\u0001R\u001b\u0010¹\u0001\u001a\u0005\u0018\u00010·\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\r\u0010¸\u0001R\u0016\u0010»\u0001\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u000f\u0010º\u0001R\u0016\u0010½\u0001\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0014\u0010¼\u0001R\u0017\u0010¾\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0015R\u0016\u0010¿\u0001\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0013\u0010¼\u0001R\u0017\u0010À\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010\u0015R\u0017\u0010Â\u0001\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010£\u0001R\u0016\u0010Ã\u0001\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bj\u0010µ\u0001R\u0016\u0010Å\u0001\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bh\u0010Ä\u0001R\u001a\u0010É\u0001\u001a\u00030Æ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u0017\u0010Ê\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010\u0015R\u0018\u0010Ì\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bË\u0001\u0010\u0015R\u0019\u0010Î\u0001\u001a\u00030\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b|\u0010Í\u0001R\u0019\u0010Ð\u0001\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010£\u0001R\u0017\u0010Ñ\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010\u0015R\u0018\u0010Ò\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b~\u0010\u009e\u0001R\u0017\u0010Ó\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010\u0015R\u0018\u0010Ô\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010\u0015R\u0017\u0010Õ\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010\u0015R\u0017\u0010Ö\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010\u0015R0\u0010Ú\u0001\u001a\u00020\"2\u0007\u0010×\u0001\u001a\u00020\"8F@FX\u0086\u000e¢\u0006\u0016\n\u0006\b\u0083\u0001\u0010°\u0001\u001a\u0005\bØ\u0001\u0010%\"\u0005\bÙ\u0001\u0010#R/\u0010Û\u0001\u001a\u00020\u00182\u0007\u0010×\u0001\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\u0015\n\u0005\b^\u0010\u009e\u0001\u001a\u0005\bÛ\u0001\u0010-\"\u0005\bÜ\u0001\u0010)¨\u0006Ý\u0001"}, d2 = {"Lcom/obric/oui/lisitem/OCardListItem;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "k", "(Landroid/util/AttributeSet;)V", "m", "()V", "n", "i", "p", "h", "q", "o", "I", "Landroid/view/View;", "view", "", "enabled", "l", "(Landroid/view/View;Z)V", "onAttachedToWindow", "onDetachedFromWindow", "color", "setBgColor", "(I)V", "setContentColor", "Landroid/content/res/ColorStateList;", "(Landroid/content/res/ColorStateList;)V", "getContentColor", "()Landroid/content/res/ColorStateList;", "setContentMarkColor", CommonConfirmDialog.ARGS_CHECKED, "setContentChecked", "(Z)V", "show", "setShowCardBg", "getShowCardBg", "()Z", "type", "setCardType", "titleC", "subTitleC", "A", "(II)V", "getCardType", "()I", "position", "animate", "r", "(IZ)V", "getCardPosition", "getCardRoot", "()Landroid/widget/FrameLayout;", "getCardContainer", "Lcom/obric/oui/lisitem/OUICardConstraintLayout;", "getContentContainer", "()Lcom/obric/oui/lisitem/OUICardConstraintLayout;", "setCustomStartView", "(Landroid/view/View;)V", "resId", "defaultCustomStart", "setDefaultCustomStartView", "getCustomStartView", "()Landroid/view/View;", "Lcom/obric/oui/checkbox/OCheckBoxLayout;", "getStartCheckBox", "()Lcom/obric/oui/checkbox/OCheckBoxLayout;", "C", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "setAppIcon", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "E", "", "text", "setTitle", "(Ljava/lang/CharSequence;)V", "getTitle", "()Ljava/lang/CharSequence;", "Lcom/obric/oui/text/OTextView;", "getTitleView", "()Lcom/obric/oui/text/OTextView;", "H", "setSubTitle", "getSubTitle", "getSubTitleView", "F", "Landroid/widget/LinearLayout;", "getTitleContainer", "()Landroid/widget/LinearLayout;", SlideCard.KEY_INDEX, "matchParent", "u", "(Landroid/view/View;IZ)V", "t", "(IIZ)V", "defaultCustomTitle", "w", "j", "setCustomEndView", "defaultCustomEnd", "setDefaultCustomEndView", "getCustomEndView", "getEndCheckBox", "Lcom/obric/oui/oswitch/OSwitch;", "getEndSwitch", "()Lcom/obric/oui/oswitch/OSwitch;", "Lcom/obric/oui/checkbox/OCheckMark;", "getEndMark", "()Lcom/obric/oui/checkbox/OCheckMark;", "getEndDetail", "maxWidth", FixCard.FixStyle.KEY_Y, "(Ljava/lang/CharSequence;I)V", "B", "setTailIcon", "defaultTailIcon", "setDefaultTailIcon", "getTailIconView", "G", "D", "enable", "setEnableSwipeDivider", "setEnableSwipe", "setSwipeView", "Lcom/obric/oui/swipeaction/OSwipeLayout;", "getSwipeLayout", "()Lcom/obric/oui/swipeaction/OSwipeLayout;", "getSwipeView", "Landroid/view/View$OnClickListener;", "listener", "setOnContentClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/view/View$OnLongClickListener;", "setOnContentLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "setEnabled", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lcom/obric/oui/lisitem/OCardListItemPositionHelper;", "a", "Lcom/obric/oui/lisitem/OCardListItemPositionHelper;", "cardListItemPositionHelper", "b", "Z", "showCardBg", "c", Style.KEY_BG_COLOR, "d", "Landroid/widget/FrameLayout;", "root", "Lcom/obric/oui/layout/OUIFrameLayout;", "e", "Lcom/obric/oui/layout/OUIFrameLayout;", "cardContainer", "f", "Lcom/obric/oui/lisitem/OUICardConstraintLayout;", "contentContainer", "Lcom/obric/oui/common/style/OStateGradientDrawable;", "g", "Lcom/obric/oui/common/style/OStateGradientDrawable;", "contentContainerBg", "Landroid/content/res/ColorStateList;", "contentDefaultContainerBgColor", "contentMarkContainerBgColor", "customStartContainer", "iconContainer", "Landroid/widget/ImageView;", ServerElements.ICON, "Lcom/obric/oui/image/OImageAppIcon;", "Lcom/obric/oui/image/OImageAppIcon;", "appIcon", "Landroid/widget/LinearLayout;", "titleContainer", "Lcom/obric/oui/text/OTextView;", "title", "titleColor", "subTitle", "subTitleColor", "s", "customEndContainer", "tailIcon", "Landroid/view/View;", "divider", "Landroid/view/View$OnLayoutChangeListener;", "v", "Landroid/view/View$OnLayoutChangeListener;", "customStartLayoutChangeListener", "customDividerStart", FixCard.FixStyle.KEY_X, "customDividerEnd", "Lcom/obric/oui/swipeaction/OSwipeLayout;", "swipeLayout", "z", "swipeContainer", "currentSwipeOffset", "enableSwipeDivider", "currentPosition", "currentType", "maxTailTextWidth", "customTitleMode", CommonKey.KEY_VALUE, "getContentContainerBgColor", "setContentContainerBgColor", "contentContainerBgColor", "isMark", "setMark", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OCardListItem extends FrameLayout {
    public static final b I = null;
    public int A;
    public boolean B;
    public int C;
    public int D;
    public int E;
    public int F;
    public ColorStateList G;
    public boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCardListItemPositionHelper f15101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f15104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OUIFrameLayout f15105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final OUICardConstraintLayout f15106f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OStateGradientDrawable f15107g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ColorStateList f15108h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ColorStateList f15109i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FrameLayout f15110j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FrameLayout f15111k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImageView f15112l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OImageAppIcon f15113m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinearLayout f15114n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final OTextView f15115o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f15116p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final OTextView f15117q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f15118r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final FrameLayout f15119s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ImageView f15120t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final View f15121u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View.OnLayoutChangeListener f15122v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f15123w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f15124x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public OSwipeLayout f15125y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public FrameLayout f15126z;

    public static final class a implements OSwipeLayout.SwipeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OCardListItem f15127a;

        public a(OCardListItem r10) {
            this.f15127a = r10;
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
        public void onClose(OSwipeLayout r10) {
            this.f15127a.setContentChecked(false);
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
        public void onHandRelease(OSwipeLayout r10, float r11, float r12) {
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
        public void onOpen(OSwipeLayout r10) {
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
        public void onStartClose(OSwipeLayout r10) {
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
        public void onStartOpen(OSwipeLayout r10) {
            this.f15127a.setContentChecked(true);
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
        public void onUpdate(OSwipeLayout r10, int r11, int r12) {
            OCardListItem.g(this.f15127a, r11);
            if (OCardListItem.e(this.f15127a).getVisibility() != 0) goto L10;
            View r13 = OCardListItem.e(this.f15127a);
            if (OCardListItem.f(this.f15127a) == false) goto L7;
            float r14 = r11;
        L8:
            r13.setTranslationX(r14);
            return;
        L7:
            r14 = 0.0f;
            goto L8
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public b() {
        }
    }

    public static final class c extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OCardListItem f15128a;

        public c(OCardListItem r10) {
            this.f15128a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            q.g(r10, "view");
            q.g(r11, "outline");
            int r12 = r10.getWidth();
            int r13 = r10.getHeight();
            int r14 = OCardListItem.d(this.f15128a);
            OCardListItem r15 = this.f15128a;
            if (r14 != 0) goto L6;
            int r16 = 8;
        L7:
            r11.setRoundRect(0, 0, r12, r13, f.r(r15, r16));
            return;
        L6:
            r16 = 10;
            goto L7
        }
    }

    static {
        I = new b(null);
    }

    @JvmOverloads
    public OCardListItem(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final void J(OCardListItem r10) {
        q.g(r10, "this$0");
        int r11 = r10.f15123w;
        int r12 = r10.f15124x;
        ViewGroup.MarginLayoutParams r13 = null;
        if (r11 == (-1)) goto L5;
        if (r12 == (-1)) goto L5;
    L30:
        ViewGroup.LayoutParams r14 = r10.f15121u.getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L33;
        r13 = (ViewGroup.MarginLayoutParams) r14;
    L33:
        if (r13 == null) goto L36;
        r13.setMargins(r11, r13.topMargin, r12, r13.bottomMargin);
    L36:
        r10.f15121u.setLayoutParams(r13);
        return;
    L5:
        ViewGroup.LayoutParams r15 = r10.f15105e.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == true) goto L8;
        r15 = null;
    L8:
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        int r17 = 0;
        if (r16 == null) goto L11;
        int r18 = r16.leftMargin;
    L12:
        int r19 = r10.f15105e.getPaddingLeft();
        ViewGroup.LayoutParams r20 = r10.f15105e.getLayoutParams();
        if ((r20 instanceof ViewGroup.MarginLayoutParams) == true) goto L15;
        r20 = null;
    L15:
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r20;
        if (r21 == null) goto L18;
        r17 = r21.rightMargin;
    L18:
        int r22 = r10.f15105e.getPaddingRight();
        r11 = r18 + r19;
        if (r10.f15110j.getVisibility() != 0) goto L22;
        r11 = r11 + r10.f15110j.getWidth();
    L22:
        if (r10.f15111k.getVisibility() != 0) goto L25;
        r11 = r11 + r10.f15111k.getWidth();
    L25:
        if (r10.f15110j.getVisibility() == 8) goto L27;
    L29:
        r12 = (r17 + r22) + f.r(r10, 8);
        goto L30
    L27:
        if (r10.f15111k.getVisibility() != 8) goto L29;
        r11 = r11 + r10.f15114n.getPaddingLeft();
        goto L29
    L11:
        r18 = 0;
        goto L12
    }

    public static /* synthetic */ void a(OCardListItem r10, View r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        c(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ void b(OCardListItem r10) {
        J(r10);
    }

    public static final void c(OCardListItem r10, View r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        q.g(r10, "this$0");
        if (r10.f15121u.getVisibility() != 0) goto L6;
        r10.I();
        return;
    }

    public static final /* synthetic */ int d(OCardListItem r10) {
        return r10.D;
    }

    public static final /* synthetic */ View e(OCardListItem r10) {
        return r10.f15121u;
    }

    public static final /* synthetic */ boolean f(OCardListItem r10) {
        return r10.B;
    }

    public static final /* synthetic */ void g(OCardListItem r10, int r11) {
        r10.A = r11;
    }

    public static /* synthetic */ void s(OCardListItem r10, int r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        r10.r(r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCardPosition");
    }

    public static /* synthetic */ void v(OCardListItem r10, View r11, int r12, boolean r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L6;
        r13 = false;
    L6:
        r10.u(r11, r12, r13);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCustomTitleView");
    }

    public static /* synthetic */ void x(OCardListItem r10, int r11, int r12, boolean r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 4) == 0) goto L9;
        r13 = true;
        if (r11 == 1) goto L9;
        r13 = false;
    L9:
        r10.w(r11, r12, r13);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDefaultCustomTitleView");
    }

    public static /* synthetic */ void z(OCardListItem r10, CharSequence r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L6;
        r12 = -1;
    L6:
        r10.y(r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setEndDetailText");
    }

    public final void A(int r10, int r11) {
        this.f15116p = r10;
        this.f15118r = r11;
        this.f15115o.setTextColor(r10);
        this.f15117q.setTextColor(this.f15118r);
    }

    public final void B(boolean r10) {
        FrameLayout r11 = this.f15119s;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        o();
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public final void C(boolean r10) {
        FrameLayout r11 = this.f15110j;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        q();
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public final void D(boolean r10) {
        View r11 = this.f15121u;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        if (r10 == false) goto L14;
        View r13 = this.f15121u;
        if (this.B == false) goto L11;
        float r14 = this.A;
    L12:
        r13.setTranslationX(r14);
        I();
        return;
    L11:
        r14 = 0.0f;
        goto L12
    L14:
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public final void E(boolean r10) {
        FrameLayout r11 = this.f15111k;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        q();
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public final void F(boolean r10) {
        CharSequence r11 = getSubTitle();
        int r12 = 8;
        if (r11 != null) goto L5;
    L11:
        this.f15117q.setVisibility(8);
        return;
    L5:
        if (r11.length() == 0) goto L11;
        OTextView r13 = this.f15117q;
        if (r10 == false) goto L10;
        r12 = 0;
    L10:
        r13.setVisibility(r12);
    }

    public final void G(boolean r10) {
        ImageView r11 = this.f15120t;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        o();
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public final void H(boolean r10) {
        CharSequence r11 = getTitle();
        int r12 = 8;
        if (r11 != null) goto L5;
    L11:
        this.f15115o.setVisibility(8);
        return;
    L5:
        if (r11.length() == 0) goto L11;
        OTextView r13 = this.f15115o;
        if (r10 == false) goto L10;
        r12 = 0;
    L10:
        r13.setVisibility(r12);
    }

    public final void I() {
        this.f15121u.post(new com.obric.oui.lisitem.a(this));
        requestLayout();
    }

    @NotNull
    public final FrameLayout getCardContainer() {
        return this.f15105e;
    }

    public final int getCardPosition() {
        return this.C;
    }

    @NotNull
    public final FrameLayout getCardRoot() {
        return this.f15104d;
    }

    public final int getCardType() {
        return this.D;
    }

    @NotNull
    public final ColorStateList getContentColor() {
        return getContentContainerBgColor();
    }

    @NotNull
    public final OUICardConstraintLayout getContentContainer() {
        return this.f15106f;
    }

    @NotNull
    public final ColorStateList getContentContainerBgColor() {
        return this.G;
    }

    @Nullable
    public final View getCustomEndView() {
        if (this.f15119s.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.f15119s.getChildAt(0);
    }

    @Nullable
    public final View getCustomStartView() {
        if (this.f15110j.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.f15110j.getChildAt(0);
    }

    @Nullable
    public final OCheckBoxLayout getEndCheckBox() {
        if ((getCustomEndView() instanceof OCheckBoxLayout) == false) goto L10;
        View r10 = getCustomEndView();
        if (r10 == null) goto L9;
        return (OCheckBoxLayout) r10;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.checkbox.OCheckBoxLayout");
    L10:
        return null;
    }

    @Nullable
    public final OTextView getEndDetail() {
        if ((getCustomEndView() instanceof OTextView) == false) goto L10;
        View r10 = getCustomEndView();
        if (r10 == null) goto L9;
        return (OTextView) r10;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    L10:
        return null;
    }

    @Nullable
    public final OCheckMark getEndMark() {
        if ((getCustomEndView() instanceof OCheckMark) == false) goto L10;
        View r10 = getCustomEndView();
        if (r10 == null) goto L9;
        return (OCheckMark) r10;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.checkbox.OCheckMark");
    L10:
        return null;
    }

    @Nullable
    public final OSwitch getEndSwitch() {
        if ((getCustomEndView() instanceof OSwitch) == false) goto L10;
        View r10 = getCustomEndView();
        if (r10 == null) goto L9;
        return (OSwitch) r10;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.oswitch.OSwitch");
    L10:
        return null;
    }

    @NotNull
    public final ImageView getIconView() {
        return this.f15112l;
    }

    public final boolean getShowCardBg() {
        return this.f15102b;
    }

    @Nullable
    public final OCheckBoxLayout getStartCheckBox() {
        if ((getCustomStartView() instanceof OCheckBoxLayout) == false) goto L10;
        View r10 = getCustomStartView();
        if (r10 == null) goto L9;
        return (OCheckBoxLayout) r10;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.checkbox.OCheckBoxLayout");
    L10:
        return null;
    }

    @Nullable
    public final CharSequence getSubTitle() {
        return this.f15117q.getText();
    }

    @NotNull
    public final OTextView getSubTitleView() {
        return this.f15117q;
    }

    @NotNull
    public final OSwipeLayout getSwipeLayout() {
        return this.f15125y;
    }

    @Nullable
    public final View getSwipeView() {
        if (this.f15126z.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.f15126z.getChildAt(0);
    }

    @NotNull
    public final ImageView getTailIconView() {
        return this.f15120t;
    }

    @Nullable
    public final CharSequence getTitle() {
        return this.f15115o.getText();
    }

    @NotNull
    public final LinearLayout getTitleContainer() {
        return this.f15114n;
    }

    @NotNull
    public final OTextView getTitleView() {
        return this.f15115o;
    }

    public final void h() {
        FrameLayout r10 = this.f15111k;
        int r11 = R$id.o_list_item_app_icon;
        OImageAppIcon r12 = (OImageAppIcon) r10.findViewById(r11);
        this.f15113m = r12;
        if (r12 != null) goto L5;
        Context r13 = getContext();
        q.f(r13, "context");
        AttributeSet r14 = null;
        int r15 = 0;
        OImageAppIcon r16 = new OImageAppIcon(r13, r14, r15, 6, null);
        r16.setId(r11);
        r16.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f15113m = r16;
        this.f15111k.addView(r16);
        return;
    L5:
        if (r12 == null) goto L10;
        r12.setVisibility(0);
        return;
    }

    public final void i() {
        if (this.f15106f.hasOnClickListeners() == false) goto L5;
    L8:
        this.f15106f.setBackground(this.f15107g);
        return;
    L5:
        if (this.f15106f.hasOnLongClickListeners() == true) goto L8;
        this.f15106f.setBackground(null);
    }

    public final void j() {
        View r10 = this.f15114n.findViewById(R$id.custom_title_container);
        if (r10 == null) goto L7;
        this.f15114n.removeView(r10);
        return;
    }

    public final void k(AttributeSet r10) {
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.OCardListItemContainer);
        q.f(r11, "context.obtainStyledAttr…e.OCardListItemContainer)");
        int r12 = R$styleable.OCardListItemContainer_ocardlistitem_showCardBg;     // Catch: Throwable -> L6
        if (r11.hasValue(r12) == false) goto L8;
        this.f15102b = r11.getBoolean(r12, true);     // Catch: Throwable -> L6
    L8:
        this.f15103c = r11.getColor(R$styleable.OCardListItemContainer_ocardlistitem_bgColor, getResources().getColor(R$color.oui_fill_list_item_card));     // Catch: Throwable -> L6
        int r13 = R$styleable.OCardListItemContainer_ocardlistitem_contentColorList;     // Catch: Throwable -> L6
        if (r11.hasValue(r13) == false) goto L14;
        ColorStateList r14 = r11.getColorStateList(r13);     // Catch: Throwable -> L6
        if (r14 != null) goto L13;
        r14 = getResources().getColorStateList(R$color.o_card_list_item_content_bg_color);     // Catch: Throwable -> L6
        q.f(r14, "resources.getColorStateL…st_item_content_bg_color)");     // Catch: Throwable -> L6
    L13:
        this.f15108h = r14;     // Catch: Throwable -> L6
        setContentContainerBgColor(r14);     // Catch: Throwable -> L6
    L14:
        int r15 = R$styleable.OCardListItemContainer_ocardlistitem_cardType;     // Catch: Throwable -> L6
        if (r11.hasValue(r15) == false) goto L17;
        this.D = r11.getInt(r15, 0);     // Catch: Throwable -> L6
    L17:
        int r16 = R$styleable.OCardListItemContainer_ocardlistitem_cardPosition;     // Catch: Throwable -> L6
        if (r11.hasValue(r16) == false) goto L20;
        this.C = r11.getInt(r16, 0);     // Catch: Throwable -> L6
    L20:
        int r17 = R$styleable.OCardListItemContainer_ocardlistitem_customStart;     // Catch: Throwable -> L6
        if (r11.hasValue(r17) == false) goto L23;
        setCustomStartView(r11.getResourceId(r17, 0));     // Catch: Throwable -> L6
    L23:
        int r18 = R$styleable.OCardListItemContainer_ocardlistitem_defaultCustomStart;     // Catch: Throwable -> L6
        if (r11.hasValue(r18) == false) goto L26;
        setDefaultCustomStartView(r11.getInt(r18, 0));     // Catch: Throwable -> L6
    L26:
        int r19 = R$styleable.OCardListItemContainer_ocardlistitem_icon;     // Catch: Throwable -> L6
        if (r11.hasValue(r19) == false) goto L29;
        setIcon(r11.getResourceId(r19, 0));     // Catch: Throwable -> L6
    L29:
        int r20 = R$styleable.OCardListItemContainer_ocardlistitem_title;     // Catch: Throwable -> L6
        if (r11.hasValue(r20) == false) goto L32;
        setTitle(r11.getString(r20));     // Catch: Throwable -> L6
    L32:
        this.f15116p = r11.getColor(R$styleable.OCardListItemContainer_ocardlistitem_titleColor, getResources().getColor(R$color.oui_basic_text_1));     // Catch: Throwable -> L6
        int r21 = R$styleable.OCardListItemContainer_ocardlistitem_subTitle;     // Catch: Throwable -> L6
        if (r11.hasValue(r21) == false) goto L35;
        setSubTitle(r11.getString(r21));     // Catch: Throwable -> L6
    L35:
        this.f15118r = r11.getColor(R$styleable.OCardListItemContainer_ocardlistitem_subTitleColor, getResources().getColor(R$color.oui_basic_text_3));     // Catch: Throwable -> L6
        int r22 = R$styleable.OCardListItemContainer_ocardlistitem_defaultCustomTitle;     // Catch: Throwable -> L6
        if (r11.hasValue(r22) == false) goto L38;
        x(this, r11.getInt(r22, 0), 0, false, 4, null);     // Catch: Throwable -> L6
    L38:
        int r23 = R$styleable.OCardListItemContainer_ocardlistitem_customEnd;     // Catch: Throwable -> L6
        if (r11.hasValue(r23) == false) goto L41;
        setCustomEndView(r11.getResourceId(r23, 0));     // Catch: Throwable -> L6
    L41:
        int r24 = R$styleable.OCardListItemContainer_ocardlistitem_defaultCustomEnd;     // Catch: Throwable -> L6
        if (r11.hasValue(r24) == false) goto L44;
        setDefaultCustomEndView(r11.getInt(r24, 0));     // Catch: Throwable -> L6
    L44:
        int r25 = R$styleable.OCardListItemContainer_ocardlistitem_endDetailText;     // Catch: Throwable -> L6
        if (r11.hasValue(r25) == false) goto L47;
        z(this, r11.getString(r25), 0, 2, null);     // Catch: Throwable -> L6
    L47:
        int r26 = R$styleable.OCardListItemContainer_ocardlistitem_tailIcon;     // Catch: Throwable -> L6
        if (r11.hasValue(r26) == false) goto L50;
        setTailIcon(r11.getResourceId(r26, 0));     // Catch: Throwable -> L6
    L50:
        int r27 = R$styleable.OCardListItemContainer_ocardlistitem_defaultTailIcon;     // Catch: Throwable -> L6
        if (r11.hasValue(r27) == false) goto L53;
        setDefaultTailIcon(r11.getInt(r27, 0));     // Catch: Throwable -> L6
    L53:
        int r28 = R$styleable.OCardListItemContainer_ocardlistitem_showCustomStart;     // Catch: Throwable -> L6
        if (r11.hasValue(r28) == false) goto L56;
        C(r11.getBoolean(r28, false));     // Catch: Throwable -> L6
    L56:
        int r29 = R$styleable.OCardListItemContainer_ocardlistitem_showIcon;     // Catch: Throwable -> L6
        if (r11.hasValue(r29) == false) goto L59;
        E(r11.getBoolean(r29, false));     // Catch: Throwable -> L6
    L59:
        int r30 = R$styleable.OCardListItemContainer_ocardlistitem_showTitle;     // Catch: Throwable -> L6
        if (r11.hasValue(r30) == false) goto L62;
        H(r11.getBoolean(r30, false));     // Catch: Throwable -> L6
    L62:
        int r31 = R$styleable.OCardListItemContainer_ocardlistitem_showSubTitle;     // Catch: Throwable -> L6
        if (r11.hasValue(r31) == false) goto L65;
        F(r11.getBoolean(r31, false));     // Catch: Throwable -> L6
    L65:
        int r32 = R$styleable.OCardListItemContainer_ocardlistitem_showCustomEnd;     // Catch: Throwable -> L6
        if (r11.hasValue(r32) == false) goto L68;
        B(r11.getBoolean(r32, false));     // Catch: Throwable -> L6
    L68:
        int r33 = R$styleable.OCardListItemContainer_ocardlistitem_showTailIcon;     // Catch: Throwable -> L6
        if (r11.hasValue(r33) == false) goto L71;
        G(r11.getBoolean(r33, false));     // Catch: Throwable -> L6
    L71:
        int r34 = R$styleable.OCardListItemContainer_ocardlistitem_showDivider;     // Catch: Throwable -> L6
        if (r11.hasValue(r34) == false) goto L74;
        D(r11.getBoolean(r34, false));     // Catch: Throwable -> L6
    L74:
        r11.recycle();
        return;
    L6:
        th = move-exception;
        r11.recycle();
        throw th;
    }

    public final void l(View r10, boolean r11) {
        if ((r10 instanceof ViewGroup) == false) goto L7;
        ViewGroup r12 = (ViewGroup) r10;
        int r13 = r12.getChildCount();
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L9;
        int r15 = r14 + 1;
        View r16 = r12.getChildAt(r14);
        r16.setEnabled(r11);
        q.f(r16, "child");
        l(r16, r11);
        r14 = r15;
        goto L5
    L9:
        return;
    }

    public final void m() {
        if (this.f15102b == false) goto L6;
        int r10 = 12;
    L5:
        int r11 = f.r(this, r10);
        OStateGradientDrawable r12 = this.f15107g;
        if (r12 == null) goto L11;
        r12.setSolidColors(getContentContainerBgColor());
    L11:
        OStateGradientDrawable r13 = this.f15107g;
        if (r13 == null) goto L15;
        r13.setCornerRadius(r11);
    L15:
        i();
        return;
    L6:
        r10 = 20;
        goto L5
    }

    public final void n() {
        m();
        if (this.f15102b == false) goto L6;
        int r10 = 12;
    L5:
        int r11 = f.r(this, r10);
        OSwipeLayout r12 = this.f15125y;
        boolean r13 = this.f15102b;
        if (r13 == false) goto L10;
        int r14 = r11;
    L11:
        if (r13 == true) goto L14;
        r11 = 0;
    L14:
        r12.setRadius(r14, 0, r11, 0);
        if (this.f15121u.getVisibility() != 0) goto L18;
        I();
        return;
    L18:
        return;
    L10:
        r14 = 0;
        goto L11
    L6:
        r10 = 20;
        goto L5
    }

    public final void o() {
        if (this.f15119s.getVisibility() != 0) goto L39;
        View r10 = getCustomEndView();
        ViewGroup.LayoutParams r11 = this.f15119s.getLayoutParams();
        ViewGroup.MarginLayoutParams r12 = null;
        if ((r11 instanceof ConstraintLayout.LayoutParams) == false) goto L7;
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r11;
    L8:
        if (r10 == null) goto L18;
        if ((r10.getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L18;
        ViewGroup.LayoutParams r14 = r10.getLayoutParams();
        if (r14 == null) goto L16;
        ((FrameLayout.LayoutParams) r14).gravity = 8388613;
        goto L18
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L18:
        if ((r10 instanceof OTextView) == false) goto L36;
        OTextView r15 = (OTextView) r10;
        if (TextUtils.isEmpty(r15.getText()) == true) goto L36;
        if (r13 == null) goto L24;
        r13.T = this.E;
    L24:
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
        r12 = (ViewGroup.MarginLayoutParams) r16;
    L27:
        if (r12 == null) goto L35;
        int r17 = r12.leftMargin;
        int r18 = r12.topMargin;
        if (this.f15120t.getVisibility() != 0) goto L33;
        int r19 = 0;
    L34:
        r12.setMargins(r17, r18, f.r(this, r19), r12.bottomMargin);
        goto L35
    L33:
        r19 = 6;
    L35:
        r15.setLayoutParams(r12);
        return;
    L36:
        if (r13 == null) goto L47;
        r13.T = -2;
        return;
    L47:
        return;
    L7:
        r13 = null;
        goto L8
    L39:
        FrameLayout r20 = this.f15119s;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        if (r21 == null) goto L44;
        ConstraintLayout.LayoutParams r22 = (ConstraintLayout.LayoutParams) r21;
        r22.T = -2;
        r20.setLayoutParams(r22);
        return;
    L44:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OStateGradientDrawable r10 = this.f15107g;
        if (r10 == null) goto L6;
        r10.endAnimation();
    L6:
        this.f15110j.addOnLayoutChangeListener(this.f15122v);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        this.E = f.r(this, 168);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f15110j.removeOnLayoutChangeListener(this.f15122v);
    }

    public final void p() {
        this.f15112l.setClipToOutline(true);
        this.f15112l.setOutlineProvider(new c(this));
        this.f15112l.invalidateOutline();
    }

    public final void q() {
        if (this.f15110j.getVisibility() == 8) goto L8;
        if ((getCustomStartView() instanceof OCheckBoxLayout) == true) goto L8;
    L10:
        LinearLayout r10 = this.f15114n;
        r10.setPadding(0, r10.getPaddingTop(), this.f15114n.getPaddingRight(), this.f15114n.getPaddingBottom());
    L12:
        if (this.f15121u.getVisibility() != 0) goto L14;
        I();
    L14:
        requestLayout();
        return;
    L8:
        if (this.f15111k.getVisibility() != 8) goto L10;
        this.f15114n.setPadding(f.r(this, 12), this.f15114n.getPaddingTop(), this.f15114n.getPaddingRight(), this.f15114n.getPaddingBottom());
        goto L12
    }

    public final void r(int r10, boolean r11) {
        this.C = r10;
        this.f15101a.o(r10, r11);
    }

    public final void setAppIcon(@Nullable Drawable r10) {
        this.f15112l.setVisibility(8);
        h();
        if (r10 == null) goto L8;
        OImageAppIcon r11 = this.f15113m;
        if (r11 == null) goto L13;
        r11.setImageDrawable(r10);
    L13:
        if (this.f15121u.getVisibility() != 0) goto L16;
        I();
        return;
    L16:
        return;
    L8:
        OImageAppIcon r12 = this.f15113m;
        if (r12 == null) goto L13;
        r12.setImageDrawable(null);
        goto L13
    }

    public final void setBgColor(int r10) {
        this.f15101a.n(r10);
    }

    @JvmOverloads
    public final void setCardPosition(int r10) {
        s(this, r10, false, 2, null);
    }

    public final void setCardType(int r10) {
        this.D = r10;
        if (r10 != 0) goto L5;
        this.f15106f.setPaddingRelative(0, 0, f.r(this, 4), 0);
        this.f15106f.setMinimumHeight(f.r(this, 48));
        this.f15114n.setVisibility(0);
        FrameLayout r11 = this.f15110j;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L27;
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r12;
        ((ViewGroup.MarginLayoutParams) r13).width = -2;
        r11.setLayoutParams(r13);
        FrameLayout r14 = this.f15111k;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        r15.width = f.r(this, 48);
        r15.height = f.r(this, 48);
        r14.setLayoutParams(r15);
        this.f15111k.setPadding(f.r(this, 10), f.r(this, 10), f.r(this, 10), f.r(this, 10));
    L22:
        p();
        if (this.f15121u.getVisibility() != 0) goto L28;
        I();
        return;
    L28:
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L5:
        if (r10 != 1) goto L7;
        this.f15106f.setPaddingRelative(0, 0, f.r(this, 4), 0);
        this.f15106f.setMinimumHeight(f.r(this, 60));
        this.f15114n.setVisibility(0);
        FrameLayout r16 = this.f15110j;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L18;
        ConstraintLayout.LayoutParams r18 = (ConstraintLayout.LayoutParams) r17;
        ((ViewGroup.MarginLayoutParams) r18).width = -2;
        r16.setLayoutParams(r18);
        FrameLayout r19 = this.f15111k;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        r20.width = f.r(this, 60);
        r20.height = f.r(this, 60);
        r19.setLayoutParams(r20);
        this.f15111k.setPadding(f.r(this, 12), f.r(this, 12), f.r(this, 12), f.r(this, 12));
        goto L22
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L7:
        if (r10 != 2) goto L22;
        this.f15106f.setPaddingRelative(0, 0, 0, 0);
        this.f15106f.setMinimumHeight(0);
        this.f15114n.setVisibility(8);
        FrameLayout r21 = this.f15110j;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if (r22 == null) goto L13;
        ConstraintLayout.LayoutParams r23 = (ConstraintLayout.LayoutParams) r22;
        ((ViewGroup.MarginLayoutParams) r23).width = -1;
        r21.setLayoutParams(r23);
        C(true);
        goto L22
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setContentChecked(boolean r10) {
        if (r10 == false) goto L9;
        this.f15106f.setSelected(true);
        if (getContentContainerBgColor().isStateful() == true) goto L11;
        OStateGradientDrawable r11 = this.f15107g;
        if (r11 == null) goto L13;
        r11.setColor(getResources().getColor(R$color.oui_state_overlay_pressed));
        return;
    L13:
        return;
    L11:
        return;
    L9:
        this.f15106f.setSelected(false);
    }

    public final void setContentColor(int r10) {
        ColorStateList r11 = ColorStateList.valueOf(r10);
        q.f(r11, "valueOf(color)");
        setContentColor(r11);
    }

    public final void setContentContainerBgColor(@NotNull ColorStateList r10) {
        q.g(r10, CommonKey.KEY_VALUE);
        if (q.b(this.G, r10) == true) goto L9;
        this.G = r10;
        OStateGradientDrawable r11 = this.f15107g;
        if (r11 == null) goto L10;
        r11.setSolidColors(r10);
        return;
    L10:
        return;
    }

    public final void setContentMarkColor(@Nullable ColorStateList r10) {
        this.f15109i = r10;
        if (r10 != null) goto L6;
        setContentContainerBgColor(this.f15108h);
        return;
    }

    public final void setCustomEndView(@Nullable View r10) {
        this.f15119s.removeAllViews();
        if (r10 != null) goto L6;
    L13:
        o();
        return;
    L6:
        if ((r10.getParent() instanceof ViewGroup) == false) goto L12;
        ViewParent r11 = r10.getParent();
        if (r11 == null) goto L11;
        ((ViewGroup) r11).removeView(r10);
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L12:
        this.f15119s.addView(r10);
        goto L13
    }

    public final void setCustomStartView(@Nullable View r10) {
        this.f15110j.removeAllViews();
        if (r10 == null) goto L6;
        this.f15110j.addView(r10);
    L6:
        if (this.f15121u.getVisibility() != 0) goto L9;
        I();
        return;
    }

    public final void setDefaultCustomEndView(int r10) {
        this.f15119s.removeAllViews();
        if (r10 != 0) goto L5;
        setCustomEndView(R$layout.o_card_list_item_custom_end_checkbox);
        return;
    L5:
        if (r10 != 1) goto L7;
        setCustomEndView(R$layout.o_card_list_item_custom_end_switch);
        return;
    L7:
        if (r10 != 2) goto L9;
        setCustomEndView(R$layout.o_card_list_item_custom_end_mark);
        return;
    L9:
        if (r10 != 3) goto L11;
        setCustomEndView(R$layout.o_card_list_item_custom_end_detail);
        return;
    L11:
        if (r10 == 4) goto L13;
        setCustomEndView(null);
        return;
    L13:
        setCustomEndView(R$layout.o_card_list_item_custom_end_handle);
    }

    public final void setDefaultCustomStartView(int r10) {
        this.f15110j.removeAllViews();
        if (r10 != 0) goto L6;
        setCustomStartView(R$layout.o_card_list_item_custom_start_checkbox);
    L6:
        if (this.f15121u.getVisibility() != 0) goto L9;
        I();
        return;
    }

    public final void setDefaultTailIcon(int r10) {
        if (r10 != 0) goto L4;
        setTailIcon(getResources().getDrawable(R$drawable.o_card_list_item_tail_icon_arrow));
        return;
    L4:
        if (r10 != 1) goto L10;
        setTailIcon(getResources().getDrawable(R$drawable.o_card_list_item_tail_icon_chevron));
        return;
    }

    public final void setEnableSwipe(boolean r10) {
        this.f15125y.setSwipeEnabled(r10);
        FrameLayout r11 = this.f15126z;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public final void setEnableSwipeDivider(boolean r10) {
        this.B = r10;
        if (this.f15121u.getVisibility() != 0) goto L10;
        View r11 = this.f15121u;
        if (this.B == false) goto L7;
        float r12 = this.A;
    L8:
        r11.setTranslationX(r12);
        return;
    L7:
        r12 = 0.0f;
        goto L8
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        this.f15106f.setEnabled(r10);
        this.f15110j.setEnabled(r10);
        this.f15111k.setEnabled(r10);
        this.f15112l.setEnabled(r10);
        OImageAppIcon r11 = this.f15113m;
        if (r11 == null) goto L6;
        r11.setEnabled(r10);
    L6:
        this.f15114n.setEnabled(r10);
        this.f15115o.setEnabled(r10);
        this.f15117q.setEnabled(r10);
        this.f15119s.setEnabled(r10);
        this.f15120t.setEnabled(r10);
        this.f15125y.setEnabled(r10);
        l(this.f15110j, r10);
        l(this.f15119s, r10);
        l(this.f15126z, r10);
    }

    @JvmOverloads
    public final void setEndDetailText(@Nullable CharSequence r10) {
        z(this, r10, 0, 2, null);
    }

    public final void setIcon(@Nullable Drawable r10) {
        this.f15112l.setVisibility(0);
        OImageAppIcon r11 = this.f15113m;
        if (r11 == null) goto L6;
        r11.setVisibility(8);
    L6:
        if (r10 == null) goto L8;
        this.f15112l.setImageDrawable(r10);
    L10:
        if (this.f15121u.getVisibility() != 0) goto L13;
        I();
        return;
    L13:
        return;
    L8:
        this.f15112l.setImageDrawable(null);
        goto L10
    }

    public final void setMark(boolean r10) {
        if (this.H == r10) goto L12;
        this.H = r10;
        if (r10 == false) goto L10;
        ColorStateList r11 = this.f15109i;
        if (r11 == null) goto L14;
        setContentContainerBgColor(r11);
        return;
    L14:
        return;
    L10:
        setContentContainerBgColor(this.f15108h);
        return;
    }

    public final void setOnContentClickListener(@Nullable View.OnClickListener r10) {
        this.f15106f.setOnClickListener(r10);
        i();
    }

    public final void setOnContentLongClickListener(@Nullable View.OnLongClickListener r10) {
        this.f15106f.setOnLongClickListener(r10);
        i();
    }

    public final void setShowCardBg(boolean r10) {
        this.f15102b = r10;
        n();
        this.f15101a.p(this.f15102b);
    }

    public final void setSubTitle(@Nullable CharSequence r10) {
        this.f15117q.setText(r10);
    }

    public final void setSwipeView(@Nullable View r10) {
        this.f15126z.removeAllViews();
        if (r10 == null) goto L6;
        this.f15126z.addView(r10);
        return;
    }

    public final void setTailIcon(@Nullable Drawable r10) {
        if (r10 == null) goto L5;
        this.f15120t.setImageDrawable(r10);
        return;
    }

    public final void setTitle(@Nullable CharSequence r10) {
        this.f15115o.setText(r10);
    }

    public final void t(int r10, int r11, boolean r12) {
        if (r10 != 0) goto L14;
        return;
    L14:
        int r13 = 0;
        v(this, LayoutInflater.from(getContext()).inflate(r10, this.f15114n, false), r11, false, 4, null);     // Catch: Exception -> L13
        LinearLayout r14 = this.f15114n;     // Catch: Exception -> L13
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();     // Catch: Exception -> L13
        if (r15 == null) goto L11;
        ConstraintLayout.LayoutParams r16 = (ConstraintLayout.LayoutParams) r15;     // Catch: Exception -> L13
        if (r12 == true) goto L9;
        r13 = -2;
    L9:
        ((ViewGroup.MarginLayoutParams) r16).width = r13;     // Catch: Exception -> L13
        r16.f14087a0 = !r12;     // Catch: Exception -> L13
        r16.P = !r12 ? 1 : 0;     // Catch: Exception -> L13
        r14.setLayoutParams(r16);     // Catch: Exception -> L13
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");     // Catch: Exception -> L13
    }

    public final void u(View r10, int r11, boolean r12) {
        if (r10 == null) goto L5;
        this.f15114n.addView(r10, r11);
        return;
    }

    public final void w(int r10, int r11, boolean r12) {
        int r13 = this.F;
        if (r13 != r10) goto L16;
        if (r13 != 1) goto L10;
        LinearLayout r14 = this.f15114n;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L9;
        ConstraintLayout.LayoutParams r16 = (ConstraintLayout.LayoutParams) r15;
        ((ViewGroup.MarginLayoutParams) r16).width = 0;
        r16.f14087a0 = false;
        r16.P = 0;
        r14.setLayoutParams(r16);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L10:
        LinearLayout r17 = this.f15114n;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 == null) goto L15;
        ConstraintLayout.LayoutParams r19 = (ConstraintLayout.LayoutParams) r18;
        ((ViewGroup.MarginLayoutParams) r19).width = -2;
        r19.f14087a0 = true;
        r19.P = 1;
        r17.setLayoutParams(r19);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L16:
        if (r13 < 0) goto L19;
        if (r13 == r10) goto L19;
        j();
    L19:
        this.F = r10;
        if (r10 == 0) goto L28;
        if (r10 == 1) goto L27;
        this.F = -1;
        j();
        LinearLayout r20 = this.f15114n;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        if (r21 == null) goto L26;
        ConstraintLayout.LayoutParams r22 = (ConstraintLayout.LayoutParams) r21;
        ((ViewGroup.MarginLayoutParams) r22).width = -2;
        r22.f14087a0 = true;
        r22.P = 1;
        r20.setLayoutParams(r22);
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L27:
        t(R$layout.o_card_list_item_custom_title_detail, r11, r12);
        return;
    L28:
        t(R$layout.o_card_list_item_custom_title_icon, r11, r12);
    }

    public final void y(CharSequence r10, int r11) {
        if (r11 <= 0) goto L4;
        this.E = r11;
    L6:
        if ((getCustomEndView() instanceof OTextView) == false) goto L12;
        View r12 = getCustomEndView();
        if (r12 == null) goto L11;
        ((OTextView) r12).setText(r10);
    L19:
        o();
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    L12:
        setDefaultCustomEndView(3);
        if ((getCustomEndView() instanceof OTextView) == false) goto L19;
        View r13 = getCustomEndView();
        if (r13 == null) goto L18;
        ((OTextView) r13).setText(r10);
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    L4:
        this.E = f.r(this, 168);
        goto L6
    }

    @JvmOverloads
    public OCardListItem(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public final void setContentColor(@NotNull ColorStateList r10) {
        q.g(r10, "color");
        setContentContainerBgColor(r10);
    }

    public final void setTailIcon(int r10) {
        if (r10 == 0) goto L4;
        this.f15120t.setImageResource(r10);
        return;
    L4:
        this.f15120t.setImageDrawable(null);
    }

    public /* synthetic */ OCardListItem(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public final void setSwipeView(int r10) {
        this.f15126z.removeAllViews();
        if (r10 == 0) goto L9;
        FrameLayout.inflate(getContext(), r10, this.f15126z);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @JvmOverloads
    public OCardListItem(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f15102b = true;
        this.f15103c = getResources().getColor(R$color.oui_fill_list_item_card);
        this.f15107g = new OStateGradientDrawable();
        ColorStateList r13 = getResources().getColorStateList(R$color.o_card_list_item_content_bg_color);
        q.f(r13, "resources.getColorStateL…st_item_content_bg_color)");
        this.f15108h = r13;
        this.f15116p = getResources().getColor(R$color.oui_basic_text_1);
        this.f15118r = getResources().getColor(R$color.oui_basic_text_3);
        this.f15123w = -1;
        this.f15124x = -1;
        this.B = true;
        this.F = -1;
        this.G = this.f15108h;
        this.E = f.r(this, 168);
        setClipChildren(false);
        setClipToPadding(false);
        if (getLayoutParams() != null) goto L5;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    L5:
        View r14 = LayoutInflater.from(r10).inflate(R$layout.o_card_list_item_layout, this, true);
        if (r14 == null) goto L14;
        FrameLayout r15 = (FrameLayout) r14;
        View r16 = findViewById(R$id.card_list_item_root);
        q.f(r16, "findViewById(R.id.card_list_item_root)");
        FrameLayout r17 = (FrameLayout) r16;
        this.f15104d = r17;
        r17.setClickable(true);
        View r18 = findViewById(R$id.card_container);
        q.f(r18, "findViewById(R.id.card_container)");
        OUIFrameLayout r19 = (OUIFrameLayout) r18;
        this.f15105e = r19;
        r19.setChangeAlphaWhenPress(false);
        r19.setChangeAlphaWhenDisable(false);
        View r20 = findViewById(R$id.content_container);
        q.f(r20, "findViewById(R.id.content_container)");
        OUICardConstraintLayout r21 = (OUICardConstraintLayout) r20;
        this.f15106f = r21;
        r21.setChangeAlphaWhenPress(false);
        r21.setChangeAlphaWhenDisable(true);
        View r22 = findViewById(R$id.custom_start_container);
        q.f(r22, "findViewById(R.id.custom_start_container)");
        this.f15110j = (FrameLayout) r22;
        View r23 = findViewById(R$id.icon_container);
        q.f(r23, "findViewById(R.id.icon_container)");
        this.f15111k = (FrameLayout) r23;
        View r24 = findViewById(R$id.icon);
        q.f(r24, "findViewById(R.id.icon)");
        this.f15112l = (ImageView) r24;
        View r25 = findViewById(R$id.title_container);
        q.f(r25, "findViewById(R.id.title_container)");
        this.f15114n = (LinearLayout) r25;
        View r26 = findViewById(R$id.title);
        q.f(r26, "findViewById(R.id.title)");
        this.f15115o = (OTextView) r26;
        View r27 = findViewById(R$id.sub_title);
        q.f(r27, "findViewById(R.id.sub_title)");
        this.f15117q = (OTextView) r27;
        View r28 = findViewById(R$id.custom_end_container);
        q.f(r28, "findViewById(R.id.custom_end_container)");
        this.f15119s = (FrameLayout) r28;
        View r29 = findViewById(R$id.tail_icon);
        q.f(r29, "findViewById(R.id.tail_icon)");
        this.f15120t = (ImageView) r29;
        View r30 = findViewById(R$id.card_divider);
        q.f(r30, "findViewById(R.id.card_divider)");
        this.f15121u = r30;
        this.f15122v = new com.obric.oui.lisitem.b(this);
        View r31 = findViewById(R$id.swipe_layout);
        q.f(r31, "findViewById(R.id.swipe_layout)");
        OSwipeLayout r32 = (OSwipeLayout) r31;
        this.f15125y = r32;
        r32.setChangeAlphaWhenPress(false);
        this.f15125y.setChangeAlphaWhenDisable(false);
        this.f15125y.setSwipeEnabled(false);
        this.f15125y.s(new a(this));
        View r33 = findViewById(R$id.swip_container);
        q.f(r33, "findViewById(R.id.swip_container)");
        this.f15126z = (FrameLayout) r33;
        if (r11 == null) goto L11;
        k(r11);
    L11:
        n();
        setCardType(this.D);
        A(this.f15116p, this.f15118r);
        this.f15101a = new OCardListItemPositionHelper(r19, this.f15102b, this.f15103c, this.C);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public final void setCustomEndView(int r10) {
        this.f15119s.removeAllViews();
        if (r10 != 0) goto L8;
    L5:
        o();
        return;
    L8:
        FrameLayout.inflate(getContext(), r10, this.f15119s);     // Catch: Exception -> L7
        goto L5
    }

    public final void setCustomStartView(int r10) {
        this.f15110j.removeAllViews();
        if (r10 == 0) goto L6;
        FrameLayout.inflate(getContext(), r10, this.f15110j);     // Catch: Exception -> L9
    L6:
        if (this.f15121u.getVisibility() != 0) goto L12;
        I();
        return;
    }

    public final void setAppIcon(int r10) {
        this.f15112l.setVisibility(8);
        h();
        if (r10 == 0) goto L8;
        OImageAppIcon r11 = this.f15113m;
        if (r11 == null) goto L13;
        r11.setImageResource(r10);
    L13:
        if (this.f15121u.getVisibility() != 0) goto L16;
        I();
        return;
    L16:
        return;
    L8:
        OImageAppIcon r12 = this.f15113m;
        if (r12 == null) goto L13;
        r12.setImageDrawable(null);
        goto L13
    }

    public final void setIcon(int r10) {
        this.f15112l.setVisibility(0);
        OImageAppIcon r11 = this.f15113m;
        if (r11 == null) goto L6;
        r11.setVisibility(8);
    L6:
        if (r10 == 0) goto L8;
        this.f15112l.setImageResource(r10);
    L10:
        if (this.f15121u.getVisibility() != 0) goto L13;
        I();
        return;
    L13:
        return;
    L8:
        this.f15112l.setImageDrawable(null);
        goto L10
    }
}
