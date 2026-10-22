package com.obric.oui.picker.reels.views;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bg.h;
import com.bytedance.apm.constant.CommonKey;
import com.google.common.primitives.Ints;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.common.res.R$color;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.popover.g;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.structure.card.FixCard;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.collections.n;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\bD\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\"*\u0002ª\u0001\u0018\u0000 02\u00020\u0001:\u0003MQUB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001a\u001a\u00020\f2\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001a\u001a\u00020\f2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001c¢\u0006\u0004\b\u001a\u0010\u001dJ%\u0010\u001f\u001a\u00020\f2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0010¢\u0006\u0004\b\"\u0010#J\u001d\u0010%\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0013¢\u0006\u0004\b%\u0010&J\u001f\u0010)\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0014¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\fH\u0002¢\u0006\u0004\b+\u0010,J\u0019\u0010-\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\fH\u0002¢\u0006\u0004\b/\u0010,J\u000f\u00100\u001a\u00020\fH\u0002¢\u0006\u0004\b0\u0010,J)\u00102\u001a\u00020\f2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b2\u00103J\u001f\u00106\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u0006H\u0002¢\u0006\u0004\b6\u00107J\u001f\u00109\u001a\u00020\f2\u0006\u00108\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0013H\u0002¢\u0006\u0004\b9\u0010\u0016J\u000f\u0010:\u001a\u00020\u0006H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0006H\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0013H\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020\f2\u0006\u0010C\u001a\u00020\u0006H\u0002¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\fH\u0002¢\u0006\u0004\bF\u0010,J\u0011\u0010H\u001a\u0004\u0018\u00010GH\u0002¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0006H\u0002¢\u0006\u0004\bJ\u0010;J\u000f\u0010K\u001a\u00020\u0006H\u0002¢\u0006\u0004\bK\u0010;R\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010[\u001a\u00060XR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010HR\u0016\u0010`\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u00109R\u0016\u0010b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010HR\u0016\u0010d\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u00109R\u0016\u0010f\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u00109R\u0016\u0010h\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u00109R\u0016\u0010j\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010HR\u0016\u0010l\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010HR\u0016\u0010n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010HR\u0016\u0010p\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010HR\u0016\u0010r\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010FR\u0016\u0010t\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010FR\u0016\u0010v\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010HR\u0016\u0010x\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010HR\u0016\u0010z\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010HR\u0016\u0010|\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010FR\u0016\u0010~\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010FR&\u0010\u0083\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\b\u007f\u0010F\u001a\u0005\b\u0080\u0001\u0010B\"\u0006\b\u0081\u0001\u0010\u0082\u0001R&\u0010\u0087\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010H\u001a\u0005\b\u0085\u0001\u0010;\"\u0005\b\u0086\u0001\u0010ER0\u0010\u008c\u0001\u001a\u00020\u00132\u0007\u0010\u0088\u0001\u001a\u00020\u00138\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0005\b\u0089\u0001\u0010F\u001a\u0005\b\u008a\u0001\u0010B\"\u0006\b\u008b\u0001\u0010\u0082\u0001R*\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0005\b\u0091\u0001\u0010#R6\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R/\u0010\u009e\u0001\u001a\u00020\u00062\u0007\u0010\u0093\u0001\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u009b\u0001\u0010H\u001a\u0005\b\u009c\u0001\u0010;\"\u0005\b\u009d\u0001\u0010ER/\u0010¢\u0001\u001a\u00020\u00062\u0007\u0010\u0093\u0001\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u009f\u0001\u0010H\u001a\u0005\b \u0001\u0010;\"\u0005\b¡\u0001\u0010ER+\u0010©\u0001\u001a\u0005\u0018\u00010£\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b=\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R\u0017\u0010¬\u0001\u001a\u00030ª\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bD\u0010«\u0001R(\u0010¯\u0001\u001a\u00020\u00062\u0007\u0010\u0093\u0001\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u00ad\u0001\u0010;\"\u0005\b®\u0001\u0010ER(\u0010²\u0001\u001a\u00020\u00062\u0007\u0010\u0093\u0001\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b°\u0001\u0010;\"\u0005\b±\u0001\u0010ER(\u0010µ\u0001\u001a\u00020\u00062\u0007\u0010\u0093\u0001\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b³\u0001\u0010;\"\u0005\b´\u0001\u0010ER(\u0010¸\u0001\u001a\u00020\u00062\u0007\u0010\u0093\u0001\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¶\u0001\u0010;\"\u0005\b·\u0001\u0010ER*\u0010½\u0001\u001a\u00020^2\u0007\u0010\u0093\u0001\u001a\u00020^8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R(\u0010À\u0001\u001a\u00020\u00062\u0007\u0010\u0093\u0001\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¾\u0001\u0010;\"\u0005\b¿\u0001\u0010ER*\u0010Ã\u0001\u001a\u00020^2\u0007\u0010\u0093\u0001\u001a\u00020^8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÁ\u0001\u0010º\u0001\"\u0006\bÂ\u0001\u0010¼\u0001R\u0013\u0010Å\u0001\u001a\u00020\u00068F¢\u0006\u0007\u001a\u0005\bÄ\u0001\u0010;R'\u0010È\u0001\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÆ\u0001\u0010;\"\u0005\bÇ\u0001\u0010ER\u0016\u0010Ê\u0001\u001a\u0004\u0018\u00010\u00108F¢\u0006\b\u001a\u0006\bÉ\u0001\u0010\u0090\u0001¨\u0006Ë\u0001"}, d2 = {"Lcom/obric/oui/picker/reels/views/WheelView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/content/res/Configuration;", "newConfig", "", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", SlideCard.KEY_INDEX, "", "K", "(I)Ljava/lang/CharSequence;", "", "animated", "S", "(IZ)V", "", "", "entries", "setEntries", "([Ljava/lang/String;)V", "", "(Ljava/util/List;)V", "selectedIndex", "T", "(Ljava/util/List;I)V", "tag", "setTagText", "(Ljava/lang/CharSequence;)V", "animate", "W", "(IZ)I", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Q", "()V", "M", "(Landroid/util/AttributeSet;)V", "R", "E", Card.KEY_ITEMS, "U", "(Ljava/util/List;Ljava/lang/Integer;)V", "dataIndex", "dataSize", "H", "(II)I", "position", "F", "L", "()I", "adapterPos", "C", "(I)I", "O", "(I)Z", "Y", "()Z", "delta", "D", "(I)V", "Z", "Landroid/view/View;", "I", "()Landroid/view/View;", "J", "P", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "a", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "recyclerView", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "tvTag", "Lcom/obric/oui/picker/reels/views/WheelLayoutManager;", "c", "Lcom/obric/oui/picker/reels/views/WheelLayoutManager;", "layoutManager", "Lcom/obric/oui/picker/reels/views/WheelView$b;", "d", "Lcom/obric/oui/picker/reels/views/WheelView$b;", "adapter", "e", "itemHeight", "", "f", "maxTextWidth", "g", "visibleRowCount", "h", "wheelTextSizePx", "i", "normalTextSizePx", "j", "selectedTextSizePx", "k", "horizontalPaddingPx", "l", "lastHapticIndex", "m", "lastCenterIndex", "n", "lastChangedDataIndex", "o", "userScrolling", "p", "programmaticScrolling", "q", "pendingInitialIndex", "r", "pendingInitialScrollPosition", "s", "pendingVerifyCenterAdapterPosition", "t", "suppressNextSnapOnce", "u", "hasSettledSinceDrag", "v", "getShowDivider", "setShowDivider", "(Z)V", "showDivider", "w", "getHighlightConorRadiusPx", "setHighlightConorRadiusPx", "highlightConorRadiusPx", "cyclic", FixCard.FixStyle.KEY_X, "N", "setCyclic", "isCyclic", FixCard.FixStyle.KEY_Y, "Ljava/lang/CharSequence;", "getWheelTagText", "()Ljava/lang/CharSequence;", "setWheelTagText", "wheelTagText", CommonKey.KEY_VALUE, "z", "Ljava/lang/Integer;", "getTagGap", "()Ljava/lang/Integer;", "setTagGap", "(Ljava/lang/Integer;)V", "tagGap", "A", "getSelectedTextColor", "setSelectedTextColor", "selectedTextColor", "B", "getNormalTextColor", "setNormalTextColor", "normalTextColor", "Lcom/obric/oui/picker/reels/views/OnWheelChangedListener;", "Lcom/obric/oui/picker/reels/views/OnWheelChangedListener;", "getOnWheelChangedListener", "()Lcom/obric/oui/picker/reels/views/OnWheelChangedListener;", "setOnWheelChangedListener", "(Lcom/obric/oui/picker/reels/views/OnWheelChangedListener;)V", "onWheelChangedListener", "com/obric/oui/picker/reels/views/WheelView$d", "Lcom/obric/oui/picker/reels/views/WheelView$d;", "scrollListener", "getStartIndex", "setStartIndex", "startIndex", "getItemCount", "setItemCount", "itemCount", "getItemHeightPx", "setItemHeightPx", "itemHeightPx", "getSelectedItemHeightPx", "setSelectedItemHeightPx", "selectedItemHeightPx", "getTextSizePx", "()F", "setTextSizePx", "(F)V", "textSizePx", "getTextColor", "setTextColor", "textColor", "getSelectedTextSizePxProp", "setSelectedTextSizePxProp", "selectedTextSizePxProp", "getItemSize", "itemSize", "getCurrentIndex", "setCurrentIndex", "currentIndex", "getCurrentItem", "currentItem", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WheelView extends FrameLayout {
    public static final a E = null;
    public int A;
    public int B;
    public OnWheelChangedListener C;
    public final d D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f15948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f15949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WheelLayoutManager f15950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f15951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f15953f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f15954g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f15955h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f15956i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f15957j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f15958k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f15959l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f15960m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f15961n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f15962o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f15963p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f15964q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f15965r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f15966s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f15967t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f15968u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f15969v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f15970w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f15971x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CharSequence f15972y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Integer f15973z;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public final class b extends RecyclerView.Adapter {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ArrayList f15974d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ WheelView f15975e;

        public b(WheelView r10) {
            q.g(r10, "this$0");
            this.f15975e = r10;
            this.f15974d = new ArrayList();
        }

        public static /* synthetic */ void u(c r10, WheelView r11, View r12) {
            y(r10, r11, r12);
        }

        public static /* synthetic */ void v(c r10, WheelView r11, View r12) {
            z(r10, r11, r12);
        }

        public static final void y(c r10, WheelView r11, View r12) {
            q.g(r10, "$holder");
            q.g(r11, "this$0");
            int r13 = r10.k();
            if (r13 == (-1)) goto L8;
            int r14 = WheelView.e(r11, r13);
            if (WheelView.s(r11, r14) == false) goto L9;
            r11.W(r14, true);
            return;
        L9:
            return;
        }

        public static final void z(c r10, WheelView r11, View r12) {
            q.g(r10, "$holder");
            q.g(r11, "this$0");
            int r13 = r10.k();
            if (r13 == (-1)) goto L8;
            int r14 = WheelView.e(r11, r13);
            if (WheelView.s(r11, r14) == false) goto L9;
            r11.W(r14, true);
            return;
        L9:
            return;
        }

        public c A(ViewGroup r10, int r11) {
            q.g(r10, "parent");
            TextView r12 = new TextView(r10.getContext());
            WheelView r13 = this.f15975e;
            r12.setId(R.id.text1);
            r12.setLayoutParams(new RecyclerView.LayoutParams(-1, WheelView.j(r13)));
            r12.setGravity(17);
            r12.setTextSize(0, WheelView.q(r13));
            r12.setIncludeFontPadding(false);
            return new c(r12);
        }

        public final void B(List r10) {
            q.g(r10, "data");
            this.f15974d.clear();
            this.f15974d.addAll(r10);
            i();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public int e() {
            int r10 = this.f15974d.size();
            if (r10 != 0) goto L7;
            return 0;
        L7:
            if (this.f15975e.N() == false) goto L10;
            return r10 * 1000;
        L10:
            return r10 + (WheelView.r(this.f15975e) * 2);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void k(RecyclerView.t r10, int r11) {
            x((c) r10, r11);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.t m(ViewGroup r10, int r11) {
            return A(r10, r11);
        }

        public final ArrayList w() {
            return this.f15974d;
        }

        public void x(final c r10, int r11) {
            q.g(r10, "holder");
            int r12 = WheelView.e(this.f15975e, r11);
            if (this.f15975e.N() == false) goto L6;
            r10.O().setAlpha(1.0f);
            r10.O().setTextSize(0, WheelView.q(this.f15975e));
            r10.O().setText((CharSequence) this.f15974d.get(r12));
            View r13 = r10.f15566a;
            final WheelView r14 = this.f15975e;
            r13.setOnClickListener(new com.obric.oui.picker.reels.views.d(r10, r14));
            return;
        L6:
            if (WheelView.s(this.f15975e, r12) == false) goto L8;
            r10.O().setAlpha(1.0f);
            r10.O().setTextSize(0, WheelView.q(this.f15975e));
            r10.O().setText((CharSequence) this.f15974d.get(r12));
            View r15 = r10.f15566a;
            final WheelView r16 = this.f15975e;
            r15.setOnClickListener(new e(r10, r16));
            return;
        L8:
            r10.O().setAlpha(0.0f);
            r10.O().setText("");
            r10.f15566a.setOnClickListener(null);
        }
    }

    public static final class c extends RecyclerView.t {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final TextView f15976u;

        public c(View r10) {
            q.g(r10, "itemView");
            super(r10);
            View r11 = r10.findViewById(R.id.text1);
            q.f(r11, "itemView.findViewById(android.R.id.text1)");
            this.f15976u = (TextView) r11;
        }

        public final TextView O() {
            return this.f15976u;
        }
    }

    public static final class d extends RecyclerView.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WheelView f15977a;

        public d(WheelView r10) {
            this.f15977a = r10;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r10, int r11) {
            q.g(r10, "rv");
            if (r11 == 0) goto L14;
            if (r11 != 1) goto L6;
            WheelView.A(this.f15977a, true);
            WheelView.t(this.f15977a, false);
            WheelView.y(this.f15977a, false);
            int r12 = WheelView.g(this.f15977a);
            if (r12 == (-1)) goto L40;
            int r13 = WheelView.e(this.f15977a, r12);
            if (WheelView.s(this.f15977a, r13) == false) goto L41;
            WheelView.w(this.f15977a, r12);
            WheelView.v(this.f15977a, r13);
            return;
        L41:
            return;
        L40:
            return;
        L6:
            if (r11 != 2) goto L47;
            WheelView.t(this.f15977a, true);
            return;
        L47:
            return;
        L14:
            WheelView.A(this.f15977a, false);
            WheelView.y(this.f15977a, false);
            int r14 = WheelView.m(this.f15977a);
            if (r14 == (-1)) goto L24;
            WheelView.x(this.f15977a, -1);
            int r15 = WheelView.g(this.f15977a);
            if (r15 == (-1)) goto L24;
            int r16 = WheelView.e(this.f15977a, r15);
            int r17 = WheelView.e(this.f15977a, r14);
            if (WheelView.s(this.f15977a, r17) == false) goto L24;
            if (r16 == r17) goto L24;
            WheelView.f(this.f15977a, r14, true);
            return;
        L24:
            if (WheelView.o(this.f15977a) == false) goto L26;
            WheelView.z(this.f15977a, false);
            boolean r18 = false;
        L28:
            if (WheelView.i(this.f15977a) == false) goto L43;
            if (r18 == true) goto L44;
            WheelView.t(this.f15977a, false);
            int r19 = WheelView.g(this.f15977a);
            if (r19 == (-1)) goto L45;
            int r20 = WheelView.e(this.f15977a, r19);
            if (WheelView.s(this.f15977a, r20) == false) goto L46;
            WheelView.u(this.f15977a, r19);
            OnWheelChangedListener r21 = this.f15977a.getOnWheelChangedListener();
            if (r21 == null) goto L48;
            r21.onStopped(r20);
            return;
        L48:
            return;
        L46:
            return;
        L45:
            return;
        L44:
            return;
        L43:
            return;
        L26:
            r18 = WheelView.B(this.f15977a);
            goto L28
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void b(RecyclerView r10, int r11, int r12) {
            q.g(r10, "rv");
            int r13 = WheelView.g(this.f15977a);
            if (r13 != (-1)) goto L5;
            return;
        L5:
            if (r10.getScrollState() != 0) goto L7;
            return;
        L7:
            if (WheelView.p(this.f15977a) == true) goto L9;
            return;
        L9:
            if (WheelView.n(this.f15977a) == true) goto L30;
            int r14 = WheelView.e(this.f15977a, r13);
            if (WheelView.s(this.f15977a, r14) == true) goto L13;
            return;
        L13:
            if (r13 == WheelView.l(this.f15977a)) goto L32;
            WheelView.w(this.f15977a, r13);
            dd.a.f19178a.a(this.f15977a, 3);
            int r15 = WheelView.k(this.f15977a);
            if (r14 == WheelView.k(this.f15977a)) goto L33;
            if (r15 >= 0) goto L18;
        L20:
            r15 = r14;
        L21:
            OnWheelChangedListener r16 = this.f15977a.getOnWheelChangedListener();
            if (r16 == null) goto L25;
            r16.onChanged(r15, r14);
        L25:
            WheelView.v(this.f15977a, r14);
            return;
        L18:
            if (r15 >= WheelView.h(this.f15977a).w().size()) goto L20;
        L33:
            return;
        L32:
            return;
        }
    }

    static {
        E = new a(null);
    }

    @JvmOverloads
    public WheelView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final /* synthetic */ void A(WheelView r10, boolean r11) {
        r10.f15962o = r11;
    }

    public static final /* synthetic */ boolean B(WheelView r10) {
        return r10.Y();
    }

    public static final void G(WheelView r10, int r11) {
        q.g(r10, "this$0");
        View r12 = r10.f15950c.A(r11);
        if (r12 == null) goto L7;
        int r13 = ((r12.getTop() + r12.getBottom()) / 2) - r10.P();
        if (r13 == 0) goto L9;
        r10.f15948a.scrollBy(0, r13);
        r10.f15967t = true;
        return;
    L9:
        return;
    L7:
        r10.f15965r = r11;
    }

    public static /* synthetic */ void V(WheelView r10, List r11, Integer r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r10.U(r11, r12);
    }

    public static final void X(int r10, int r11, Ref$IntRef r12, Ref$IntRef r13, int r14) {
        if (r14 < 0) goto L8;
        if (r14 >= r10) goto L9;
        int r15 = Math.abs(r14 - r11);
        if (r15 >= r12.element) goto L10;
        r13.element = r14;
        r12.element = r15;
        return;
    L10:
        return;
    L9:
        return;
    }

    public static /* synthetic */ void a(WheelView r10, int r11) {
        G(r10, r11);
    }

    public static /* synthetic */ void b(WheelView r10) {
        m23setItems$lambda6(r10);
    }

    public static /* synthetic */ void c(WheelView r10) {
        d(r10);
    }

    public static final void d(WheelView r10) {
        q.g(r10, "this$0");
        r10.Z();
        r10.E();
    }

    public static final /* synthetic */ int e(WheelView r10, int r11) {
        return r10.C(r11);
    }

    public static final /* synthetic */ void f(WheelView r10, int r11, boolean r12) {
        r10.F(r11, r12);
    }

    public static final /* synthetic */ int g(WheelView r10) {
        return r10.J();
    }

    public static final /* synthetic */ b h(WheelView r10) {
        return r10.f15951d;
    }

    public static final /* synthetic */ boolean i(WheelView r10) {
        return r10.f15968u;
    }

    public static final /* synthetic */ int j(WheelView r10) {
        return r10.f15952e;
    }

    public static final /* synthetic */ int k(WheelView r10) {
        return r10.f15961n;
    }

    public static final /* synthetic */ int l(WheelView r10) {
        return r10.f15959l;
    }

    public static final /* synthetic */ int m(WheelView r10) {
        return r10.f15966s;
    }

    public static final /* synthetic */ boolean n(WheelView r10) {
        return r10.f15963p;
    }

    public static final /* synthetic */ boolean o(WheelView r10) {
        return r10.f15967t;
    }

    public static final /* synthetic */ boolean p(WheelView r10) {
        return r10.f15962o;
    }

    public static final /* synthetic */ float q(WheelView r10) {
        return r10.f15955h;
    }

    public static final /* synthetic */ int r(WheelView r10) {
        return r10.L();
    }

    public static final /* synthetic */ boolean s(WheelView r10, int r11) {
        return r10.O(r11);
    }

    /* JADX INFO: renamed from: setItems$lambda-6, reason: not valid java name */
    private static final void m23setItems$lambda6(WheelView r10) {
        q.g(r10, "this$0");
        r10.requestLayout();
        r10.Z();
        if (r10.f15965r == (-1)) goto L5;
        r10.E();
        return;
    L5:
        r10.R();
    }

    public static final /* synthetic */ void t(WheelView r10, boolean r11) {
        r10.f15968u = r11;
    }

    public static final /* synthetic */ void u(WheelView r10, int r11) {
        r10.f15960m = r11;
    }

    public static final /* synthetic */ void v(WheelView r10, int r11) {
        r10.f15961n = r11;
    }

    public static final /* synthetic */ void w(WheelView r10, int r11) {
        r10.f15959l = r11;
    }

    public static final /* synthetic */ void x(WheelView r10, int r11) {
        r10.f15966s = r11;
    }

    public static final /* synthetic */ void y(WheelView r10, boolean r11) {
        r10.f15963p = r11;
    }

    public static final /* synthetic */ void z(WheelView r10, boolean r11) {
        r10.f15967t = r11;
    }

    public final int C(int r10) {
        int r11 = this.f15951d.w().size();
        if (r11 != 0) goto L7;
        return -1;
    L7:
        if (this.f15971x == false) goto L12;
        int r12 = r10 % r11;
        if (r12 < 0) goto L14;
        return r12;
    L14:
        return r12 + r11;
    L12:
        return r10 - L();
    }

    public final void D(int r10) {
        if (r10 == 0) goto L5;
        this.f15963p = true;
        g r11 = new g(0.61f);
        this.f15948a.k1(0, r10, r11, 400);
        return;
    }

    public final void E() {
        int r10 = this.f15965r;
        if (r10 != (-1)) goto L6;
        return;
    L6:
        if (this.f15951d.w().size() != 0) goto L9;
        return;
    L9:
        if (this.f15948a.getChildCount() != 0) goto L11;
        return;
    L11:
        this.f15965r = -1;
        F(r10, false);
    }

    public final void F(final int r10, boolean r11) {
        this.f15948a.p1();
        if (r11 == false) goto L7;
        this.f15963p = true;
        this.f15966s = r10;
        int r12 = this.f15950c.C1(r10);
        if (r12 == 0) goto L9;
        D(r12);
        return;
    L9:
        return;
    L7:
        this.f15963p = true;
        this.f15948a.d1(r10);
        post(new com.obric.oui.picker.reels.views.c(this, r10));
    }

    public final int H(int r10, int r11) {
        int r12 = h.k(r10, 0, r11 - 1);
        if (this.f15971x == false) goto L6;
        return ((r11 * 1000) / 2) + r12;
    L6:
        return r12 + L();
    }

    public final View I() {
        int r10 = P();
        int r11 = this.f15948a.getChildCount();
        View r12 = null;
        float r13 = Float.MAX_VALUE;
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L11;
        r14 = r14 + 1;
        View r15 = this.f15948a.getChildAt(r14);
        if (r15 == null) goto L3;
        float r16 = Math.abs(((r15.getTop() + r15.getBottom()) / 2.0f) - r10);
        if (r16 >= r13) goto L3;
        r12 = r15;
        r13 = r16;
        goto L3
    L11:
        return r12;
    }

    public final int J() {
        int r10 = this.f15950c.G1();
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        View r11 = I();
        if (r11 != null) goto L9;
        return -1;
    L9:
        return this.f15948a.b0(r11);
    }

    public final CharSequence K(int r10) {
        return (CharSequence) b0.a0(this.f15951d.w(), r10);
    }

    public final int L() {
        return h.d((this.f15954g + 2) / 2, 1);
    }

    public final void M(AttributeSet r18) {
        TypedArray r10 = getContext().obtainStyledAttributes(r18, R$styleable.OWheelView);
        q.f(r10, "context.obtainStyledAttr…, R.styleable.OWheelView)");
        boolean r11 = r10.getBoolean(R$styleable.OWheelView_oui_wheelCyclic, false);
        int r12 = r10.getInt(R$styleable.OWheelView_oui_wheelStartIndex, 0);
        int r13 = r10.getInt(R$styleable.OWheelView_oui_wheelItemCount, 5);
        int r14 = r10.getDimensionPixelOffset(R$styleable.OWheelView_oui_wheelItemHeight, f.r(this, 50));
        int r15 = R$styleable.OWheelView_oui_wheelTextSize;
        int r16 = r10.getDimensionPixelSize(r15, f.q(this, 22.0f));
        int r17 = r10.getDimensionPixelSize(r15, f.q(this, 14.0f));
        int r19 = r10.getColor(R$styleable.OWheelView_oui_wheelTextColor, ContextCompat.b(getContext(), R$color.oui_basic_text_1));
        int r110 = r10.getColor(R$styleable.OWheelView_oui_wheelSelectedTextColor, ContextCompat.b(getContext(), R$color.oui_accent_6_bg));
        int r20 = r10.getDimensionPixelSize(R$styleable.OWheelView_oui_wheelSelectedTextSize, f.q(this, 22.0f));
        CharSequence[] r111 = r10.getTextArray(R$styleable.OWheelView_oui_wheelEntries);
        if (r111 != null) goto L5;
        ArrayList r112 = null;
    L8:
        r10.recycle();
        setCyclic(r11);
        this.f15964q = r12;
        this.f15954g = r13;
        this.f15952e = r14;
        float r21 = r16;
        this.f15956i = r21;
        float r22 = r20;
        this.f15957j = r22;
        this.f15955h = h.c(r22, r21);
        setSelectedTextColor(r110);
        this.f15949b.setTextSize(0, r17);
        this.f15949b.setTextColor(r19);
        if (r112 == null) goto L11;
        V(this, r112, null, 2, null);
        return;
    L11:
        R();
        return;
    L5:
        r112 = new ArrayList(r111.length);
        int r113 = r111.length;
        int r114 = 0;
    L6:
        if (r114 >= r113) goto L8;
        r112.add(r111[r114].toString());
        r114 = r114 + 1;
        goto L6
    }

    public final boolean N() {
        return this.f15971x;
    }

    public final boolean O(int r10) {
        if (r10 >= 0) goto L5;
        return false;
    L5:
        if (r10 >= this.f15951d.w().size()) goto L9;
        return true;
    L9:
        return false;
    }

    public final int P() {
        return ((this.f15948a.getPaddingTop() + this.f15948a.getHeight()) - this.f15948a.getPaddingBottom()) / 2;
    }

    public final void Q() {
        this.f15958k = f.r(this, 28);
    }

    public final void R() {
        int r10 = this.f15951d.w().size();
        if (r10 != 0) goto L5;
        return;
    L5:
        int r11 = h.k(this.f15964q, 0, r10 - 1);
        if (this.f15971x == false) goto L8;
        int r12 = ((r10 * 1000) / 2) + r11;
    L9:
        this.f15965r = r12;
        if (this.f15948a.getChildCount() <= 0) goto L13;
        E();
        return;
    L13:
        return;
    L8:
        r12 = L() + r11;
        goto L9
    }

    public final void S(int r10, boolean r11) {
        int r12 = getCurrentIndex();
        int r13 = W(r10, r11);
        int r14 = this.f15951d.w().size();
        if (r14 <= 0) goto L18;
        int r15 = h.k(r10, 0, r14 - 1);
        if (r12 == r15) goto L19;
        OnWheelChangedListener r16 = this.C;
        if (r16 == null) goto L10;
        r16.onChanged(r12, r15);
    L10:
        OnWheelChangedListener r17 = this.C;
        if (r17 == null) goto L14;
        r17.onStopped(r15);
    L14:
        this.f15961n = r15;
        if (r13 == (-1)) goto L20;
        this.f15960m = r13;
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void T(List r10, int r11) {
        if (r10 != null) goto L4;
        List r12 = null;
    L9:
        if (r12 != null) goto L11;
        r12 = t.i();
    L11:
        U(r12, Integer.valueOf(r11));
        return;
    L4:
        ArrayList r13 = new ArrayList(u.r(r10, 10));
        Iterator r14 = r10.iterator();
    L6:
        if (r14.hasNext() == false) goto L8;
        r13.add((String) r14.next());
        goto L6
    L8:
        r12 = r13;
        goto L9
    }

    public final void U(List r10, Integer r11) {
        this.f15966s = -1;
        if (r11 != null) goto L5;
        Integer r12 = null;
    L10:
        if (r12 == null) goto L13;
        this.f15964q = r12.intValue();
    L13:
        boolean r13 = q.b(this.f15951d.w(), r10);
        if (r13 == true) goto L16;
        this.f15948a.p1();
        this.f15951d.B(r10);
    L16:
        TextView r14 = new TextView(getContext());
        r14.setTextSize(22.0f);
        TextPaint r15 = r14.getPaint();
        this.f15953f = 0.0f;
        Iterator r16 = r10.iterator();
    L18:
        if (r16.hasNext() == false) goto L22;
        float r17 = r15.measureText(((CharSequence) r16.next()).toString());
        if (r17 <= this.f15953f) goto L18;
        this.f15953f = r17;
        goto L18
    L22:
        ViewGroup.LayoutParams r18 = this.f15949b.getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == false) goto L29;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        int r20 = (int) (this.f15953f / 2.0f);
        Integer r21 = this.f15973z;
        if (r21 != null) goto L27;
        int r22 = 0;
    L28:
        r19.setMarginStart(r20 + (r22 * 2));
        this.f15949b.setLayoutParams(r18);
        goto L29
    L27:
        r22 = r21.intValue();
    L29:
        if (r12 != null) goto L31;
    L37:
        post(new com.obric.oui.picker.reels.views.b(this));
        return;
    L31:
        if (r10.isEmpty() == true) goto L37;
        if (r13 == true) goto L36;
        this.f15965r = H(r12.intValue(), r10.size());
        if (this.f15948a.getChildCount() <= 0) goto L37;
        E();
        goto L37
    L36:
        W(r12.intValue(), false);
        goto L37
    L5:
        int r23 = r11.intValue();
        if (r10.isEmpty() == true) goto L9;
        r23 = h.k(r23, 0, r10.size() - 1);
    L9:
        r12 = Integer.valueOf(r23);
        goto L10
    }

    public final int W(int r10, boolean r11) {
        this.f15965r = -1;
        this.f15966s = -1;
        int r12 = this.f15951d.w().size();
        if (r12 != 0) goto L6;
        this.f15964q = r10;
        return -1;
    L6:
        int r13 = h.k(r10, 0, r12 - 1);
        this.f15964q = r13;
        if (this.f15971x == false) goto L13;
        int r14 = J();
        if (this.f15948a.getChildCount() <= 0) goto L12;
        if (r14 == (-1)) goto L12;
        int r15 = this.f15951d.e();
        int r16 = (r14 - (r14 % r12)) + r13;
        Ref$IntRef r17 = new Ref$IntRef();
        r17.element = r16;
        Ref$IntRef r18 = new Ref$IntRef();
        r18.element = Math.abs(r16 - r14);
        X(r15, r14, r18, r17, r16 - r12);
        X(r15, r14, r18, r17, r16 + r12);
        int r19 = r17.element;
    L14:
        F(r19, r11);
        return r19;
    L12:
        r19 = r13 + ((r12 * 1000) / 2);
        goto L14
    L13:
        r19 = r13 + L();
        goto L14
    }

    public final boolean Y() {
        this.f15948a.p1();
        int r10 = this.f15950c.D1();
        if (r10 == 0) goto L6;
        this.f15967t = true;
        D(r10);
        return true;
    L6:
        return false;
    }

    public final void Z() {
        if (this.f15948a.getHeight() > 0) goto L5;
        return;
    L5:
        RecyclerView r10 = this.f15948a;
        r10.setPadding(r10.getPaddingLeft(), 0, this.f15948a.getPaddingRight(), 0);
    }

    public final int getCurrentIndex() {
        int r10 = J();
        if (r10 != (-1)) goto L5;
        return 0;
    L5:
        int r11 = C(r10);
        if (O(r11) == true) goto L8;
        return 0;
    L8:
        return r11;
    }

    @Nullable
    public final CharSequence getCurrentItem() {
        return K(getCurrentIndex());
    }

    public final int getHighlightConorRadiusPx() {
        return this.f15970w;
    }

    public final int getItemCount() {
        return this.f15954g;
    }

    public final int getItemHeightPx() {
        return this.f15952e;
    }

    public final int getItemSize() {
        return this.f15951d.w().size();
    }

    public final int getNormalTextColor() {
        return this.B;
    }

    @Nullable
    public final OnWheelChangedListener getOnWheelChangedListener() {
        return this.C;
    }

    public final int getSelectedItemHeightPx() {
        return this.f15952e;
    }

    public final int getSelectedTextColor() {
        return this.A;
    }

    public final float getSelectedTextSizePxProp() {
        return this.f15957j;
    }

    public final boolean getShowDivider() {
        return this.f15969v;
    }

    public final int getStartIndex() {
        return this.f15964q;
    }

    @Nullable
    public final Integer getTagGap() {
        return this.f15973z;
    }

    public final int getTextColor() {
        return this.B;
    }

    public final float getTextSizePx() {
        return this.f15956i;
    }

    @Nullable
    public final CharSequence getWheelTagText() {
        return this.f15972y;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        Q();
        requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        View.MeasureSpec.makeMeasureSpec((((int) (((this.f15952e / ((float) Math.tan(0.5235988f))) * 2.0f) + this.f15952e)) + getPaddingTop()) + getPaddingBottom(), Ints.MAX_POWER_OF_TWO);
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getSize(r10);
        int r14 = Math.max((int) (this.f15953f + this.f15958k), getMinimumWidth());
        if (r12 == Integer.MIN_VALUE) goto L6;
        if (r12 == 1073741824) goto L7;
        r13 = r14;
    L7:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r13, Ints.MAX_POWER_OF_TWO), r11);
        return;
    L6:
        r13 = Math.min(r14, r13);
        goto L7
    }

    public final void setCurrentIndex(int r10) {
        S(r10, false);
    }

    public final void setCyclic(boolean r10) {
        this.f15971x = r10;
        this.f15950c.J1(r10);
        WheelLayoutManager r11 = this.f15950c;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.K1(r12);
        requestLayout();
        return;
    L5:
        r12 = L();
        goto L6
    }

    public final void setEntries(@NotNull String... r10) {
        q.g(r10, "entries");
        V(this, n.K(r10), null, 2, null);
    }

    public final void setHighlightConorRadiusPx(int r10) {
        this.f15970w = r10;
    }

    public final void setItemCount(int r10) {
        this.f15954g = r10;
        WheelLayoutManager r11 = this.f15950c;
        if (this.f15971x == false) goto L5;
        int r12 = 0;
    L6:
        r11.K1(r12);
        requestLayout();
        return;
    L5:
        r12 = L();
        goto L6
    }

    public final void setItemHeightPx(int r10) {
        this.f15952e = r10;
        this.f15951d.i();
        requestLayout();
    }

    public final void setNormalTextColor(int r10) {
        this.B = r10;
        this.f15950c.L1(r10);
        this.f15948a.requestLayout();
    }

    public final void setOnWheelChangedListener(@Nullable OnWheelChangedListener r10) {
        this.C = r10;
    }

    public final void setSelectedItemHeightPx(int r10) {
        this.f15952e = r10;
        this.f15951d.i();
        requestLayout();
    }

    public final void setSelectedTextColor(int r10) {
        this.A = r10;
        this.f15950c.M1(r10);
        this.f15948a.requestLayout();
    }

    public final void setSelectedTextSizePxProp(float r10) {
        this.f15957j = r10;
        this.f15955h = Math.max(this.f15956i, r10);
        this.f15951d.i();
        requestLayout();
    }

    public final void setShowDivider(boolean r10) {
        this.f15969v = r10;
    }

    public final void setStartIndex(int r10) {
        this.f15964q = r10;
        if (this.f15951d.w().size() <= 0) goto L6;
        W(h.k(r10, 0, this.f15951d.w().size() - 1), false);
        return;
    }

    public final void setTagGap(@Nullable Integer r10) {
        this.f15973z = r10;
        requestLayout();
    }

    public final void setTagText(@NotNull CharSequence r10) {
        q.g(r10, "tag");
        this.f15972y = r10;
        if (r10 != null) goto L5;
    L8:
        this.f15949b.setVisibility(8);
        return;
    L5:
        if (r10.length() == 0) goto L8;
        this.f15949b.setVisibility(0);
        this.f15949b.setText(this.f15972y);
    }

    public final void setTextColor(int r10) {
        setNormalTextColor(r10);
    }

    public final void setTextSizePx(float r10) {
        this.f15956i = r10;
        this.f15955h = Math.max(r10, this.f15957j);
        this.f15951d.i();
        requestLayout();
    }

    public final void setWheelTagText(@Nullable CharSequence r10) {
        this.f15972y = r10;
    }

    @JvmOverloads
    public WheelView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public final void setEntries(@Nullable List<String> r10) {
        if (r10 != null) goto L5;
        List r11 = null;
    L9:
        if (r11 != null) goto L11;
        r11 = t.i();
    L11:
        V(this, r11, null, 2, null);
        return;
    L5:
        r11 = new ArrayList(u.r(r10, 10));
        Iterator<T> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r11.add((String) r12.next());
        goto L7
    }

    public /* synthetic */ WheelView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public WheelView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        WheelLayoutManager r13 = new WheelLayoutManager(r10);
        this.f15950c = r13;
        b r14 = new b(this);
        this.f15951d = r14;
        this.f15952e = f.q(this, 50.0f);
        this.f15954g = 5;
        this.f15955h = f.t(this, 22.0f);
        this.f15956i = f.t(this, 22.0f);
        this.f15957j = f.t(this, 22.0f);
        this.f15959l = -1;
        this.f15960m = -1;
        this.f15961n = -1;
        this.f15965r = -1;
        this.f15966s = -1;
        this.f15970w = f.r(this, 8);
        this.A = ContextCompat.b(r10, com.obric.common.oui.R$color.oui_accent_6_bg);
        this.B = ContextCompat.b(r10, com.obric.common.oui.R$color.oui_basic_text_1);
        d r15 = new d(this);
        this.D = r15;
        Q();
        FrameLayout.inflate(r10, R$layout.o_wheel_view, this);
        setTagGap(Integer.valueOf(f.r(this, 2)));
        View r16 = findViewById(R$id.recycler);
        q.f(r16, "findViewById(R.id.recycler)");
        RecyclerView r17 = (RecyclerView) r16;
        this.f15948a = r17;
        View r18 = findViewById(R$id.tv_tag);
        q.f(r18, "findViewById(R.id.tv_tag)");
        this.f15949b = (TextView) r18;
        r17.setLayoutManager(r13);
        r13.K1(L());
        r17.setAdapter(r14);
        r17.setClipToPadding(false);
        r17.setOverScrollMode(0);
        r17.addOnScrollListener(r15);
        r17.getViewTreeObserver().addOnGlobalLayoutListener(new com.obric.oui.picker.reels.views.a(this));
        M(r11);
    }
}
