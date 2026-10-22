package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$drawable;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.structure.card.FixCard;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import fd.b;
import fd.c;
import fd.d;
import fd.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 ²\u00012\u00020\u0001:\u0005Wº\u0001»\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ/\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001f\u0010\u001dJ/\u0010 \u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002¢\u0006\u0004\b \u0010\u001dJ\u0019\u0010#\u001a\u00020\"2\b\b\u0001\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010'J/\u0010,\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00062\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00060)j\b\u0012\u0004\u0012\u00020\u0006`*H\u0002¢\u0006\u0004\b,\u0010-J\u001f\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00060)j\b\u0012\u0004\u0012\u00020\u0006`*H\u0002¢\u0006\u0004\b\u0011\u0010.J\u0017\u00100\u001a\u00020/2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b2\u0010\u0016J\u0019\u00105\u001a\u00020\n2\b\u00104\u001a\u0004\u0018\u000103H\u0014¢\u0006\u0004\b5\u00106J\u001d\u0010:\u001a\u00020\n2\u000e\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u000107¢\u0006\u0004\b:\u0010;J\u001f\u0010?\u001a\u00020\n2\u0010\u0010>\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010=\u0018\u00010<¢\u0006\u0004\b?\u0010@J\u0017\u0010C\u001a\u00020\n2\b\u0010B\u001a\u0004\u0018\u00010A¢\u0006\u0004\bC\u0010DJ\u0015\u0010F\u001a\u00020\n2\u0006\u0010E\u001a\u00020/¢\u0006\u0004\bF\u0010GJ\u0015\u0010I\u001a\u00020\n2\u0006\u0010H\u001a\u00020/¢\u0006\u0004\bI\u0010GJ\u0017\u0010K\u001a\u00020\n2\b\u0010B\u001a\u0004\u0018\u00010J¢\u0006\u0004\bK\u0010LJ\u001f\u0010O\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0006H\u0014¢\u0006\u0004\bO\u0010PJ\u0017\u0010S\u001a\u00020/2\u0006\u0010R\u001a\u00020QH\u0016¢\u0006\u0004\bS\u0010TJ\u0017\u0010U\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0014¢\u0006\u0004\bU\u0010VR\u0018\u0010Y\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u001e\u0010\\\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010]R\u0016\u0010a\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R \u0010c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010=\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010bR\u0016\u0010d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010]R\u0016\u0010e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010]R\u0016\u0010f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010]R\u0016\u0010g\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010]R\u0016\u0010h\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010]R\u0016\u0010i\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010]R\u0014\u0010l\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0014\u0010m\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010kR\u0018\u0010o\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010nR\u0016\u0010p\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010]R\u0016\u0010r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010]R\"\u0010v\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010]\u001a\u0004\bs\u0010t\"\u0004\bu\u0010\u0016R\"\u0010z\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010]\u001a\u0004\bx\u0010t\"\u0004\by\u0010\u0016R\u0018\u0010|\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010nR\u0016\u0010~\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010]R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0083\u0001\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010`R\u001b\u0010\u0086\u0001\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u008a\u0001\u001a\u00030\u0087\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0018\u0010\u008c\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010]R\u0019\u0010\u008f\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001b\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R)\u0010\u0098\u0001\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u008e\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R)\u0010\u009c\u0001\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u008e\u0001\u001a\u0006\b\u009a\u0001\u0010\u0095\u0001\"\u0006\b\u009b\u0001\u0010\u0097\u0001R&\u0010 \u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009d\u0001\u0010]\u001a\u0005\b\u009e\u0001\u0010t\"\u0005\b\u009f\u0001\u0010\u0016R&\u0010¤\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¡\u0001\u0010]\u001a\u0005\b¢\u0001\u0010t\"\u0005\b£\u0001\u0010\u0016R&\u0010§\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008e\u0001\u0010]\u001a\u0005\b¥\u0001\u0010t\"\u0005\b¦\u0001\u0010\u0016R\u001d\u0010\u00ad\u0001\u001a\u00030¨\u00018\u0006¢\u0006\u0010\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001R\u001d\u0010°\u0001\u001a\u00030¨\u00018\u0006¢\u0006\u0010\n\u0006\b®\u0001\u0010ª\u0001\u001a\u0006\b¯\u0001\u0010¬\u0001R)\u0010·\u0001\u001a\u00030±\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b]\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R\u0016\u0010¹\u0001\u001a\u00020/8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bj\u0010¸\u0001¨\u0006¼\u0001"}, d2 = {"Lcom/obric/oui/indexscrollbar/LettersBar;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "k", "(Landroid/content/Context;)V", "o", "()V", "", "scene", "c", "q", "(Ljava/lang/String;I)V", SlideCard.KEY_INDEX, "setLetterPaint", "(I)V", "Landroid/graphics/Canvas;", "canvas", "", "xPos", "yPos", "f", "(ILandroid/graphics/Canvas;FF)V", "h", "g", "e", "tintColor", "Landroid/graphics/Paint;", "i", "(I)Landroid/graphics/Paint;", "measureSpec", "n", "(I)I", "totalHeight", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "visibleLetters", "j", "(ILjava/util/ArrayList;)F", "()Ljava/util/ArrayList;", "", "m", "(I)Z", "setTouchedLetter", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "", "Lfd/b;", "letters", "setLetters", "(Ljava/util/List;)V", "", "Landroid/graphics/Bitmap;", "bitmaps", "setBitmapsSelected", "([Landroid/graphics/Bitmap;)V", "Lcom/obric/oui/indexscrollbar/LettersBar$LBListener;", "listener", "setListener", "(Lcom/obric/oui/indexscrollbar/LettersBar$LBListener;)V", "settled", "setSettled", "(Z)V", "showBg", "setShowBg", "Lcom/obric/oui/indexscrollbar/LettersBar$OnBackgroundVisibleChangedListener;", "setOnBackgroundVisibleChangedListener", "(Lcom/obric/oui/indexscrollbar/LettersBar$OnBackgroundVisibleChangedListener;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "onDraw", "(Landroid/graphics/Canvas;)V", "a", "Landroid/content/Context;", "mContext", "b", "Ljava/util/List;", "mLetters", "I", "mChosenLetterIndex", "d", "Z", "mSettled", "[Landroid/graphics/Bitmap;", "mIconsForSymbolsSelected", "mLettersBarWidth", "mSingleLetterMinHeight", "mLetterFontSize", "mLetterLocaleFontSize", "mLetterFontCenterX", "mLetterBarHeight", "l", "Landroid/graphics/Paint;", "mLetterPaint", "mBitmapPaint", "Landroid/graphics/Bitmap;", "mHighlightIcon", "mHighlightIconStartX", "p", "mHighlightIconHeight", "getMHasChosenLetterFontColor", "()I", "setMHasChosenLetterFontColor", "mHasChosenLetterFontColor", "r", "getMNoChosenLetterFontColor", "setMNoChosenLetterFontColor", "mNoChosenLetterFontColor", "s", "mDotIcon", "t", "mDotIconX", "u", "Lcom/obric/oui/indexscrollbar/LettersBar$LBListener;", "mListener", "v", "mShowBg", "w", "Lcom/obric/oui/indexscrollbar/LettersBar$OnBackgroundVisibleChangedListener;", "mBackgroundChangeListener", "Lfd/f;", FixCard.FixStyle.KEY_X, "Lfd/f;", "mPopupWindow", FixCard.FixStyle.KEY_Y, "mScreenWidth", "z", "F", "dotLetterTextSizePx", "A", "Ljava/lang/String;", "lastPopupLetter", "B", "getDownX", "()F", "setDownX", "(F)V", "downX", "C", "getDownY", "setDownY", "downY", "D", "getTouchSlop", "setTouchSlop", "touchSlop", "E", "getOldChosen", "setOldChosen", "oldChosen", "getNewChosen", "setNewChosen", "newChosen", "Ljava/lang/Runnable;", "G", "Ljava/lang/Runnable;", "getShowPopupTask", "()Ljava/lang/Runnable;", "showPopupTask", "H", "getDismissPopupTask", "dismissPopupTask", "", "J", "getShowPopupTaskStartTime", "()J", "setShowPopupTaskStartTime", "(J)V", "showPopupTaskStartTime", "()Z", "isHolderState", "LBListener", "OnBackgroundVisibleChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LettersBar extends View {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final a f14865J = null;
    public String A;
    public float B;
    public float C;
    public int D;
    public int E;
    public int F;
    public final Runnable G;
    public final Runnable H;
    public long I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f14866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f14867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap[] f14870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14876k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f14877l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f14878m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Bitmap f14879n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14880o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14881p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14882q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f14883r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Bitmap f14884s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f14885t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LBListener f14886u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f14887v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public OnBackgroundVisibleChangedListener f14888w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final f f14889x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f14890y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f14891z;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/indexscrollbar/LettersBar$LBListener;", "", "onLetterChanged", "", "letter", "", "type", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface LBListener {
        boolean onLetterChanged(@Nullable String r10, int r11);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/indexscrollbar/LettersBar$OnBackgroundVisibleChangedListener;", "", "OnBackgroundVisibleChanged", "", "visible", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBackgroundVisibleChangedListener {
        void OnBackgroundVisibleChanged(boolean r10);
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f14865J = new a(null);
    }

    @JvmOverloads
    public LettersBar(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ void a(LettersBar r10) {
        p(r10);
    }

    public static /* synthetic */ void b(LettersBar r10) {
        d(r10);
    }

    public static final void d(LettersBar r10) {
        q.g(r10, "this$0");
        if (r10.f14889x.b() == false) goto L6;
        r10.f14889x.a();
        r10.setTouchedLetter(-1);
        r10.setShowBg(false);
        return;
    }

    public static final void p(LettersBar r10) {
        q.g(r10, "this$0");
        int r11 = r10.E;
        int r12 = r10.F;
        if (r11 == r12) goto L11;
        if (r12 < 0) goto L11;
        List r13 = r10.f14867b;
        q.d(r13);
        if (r12 >= r13.size()) goto L11;
        r10.q("ACTION_DOWN", r10.F);
        LBListener r14 = r10.f14886u;
        if (r14 == null) goto L10;
        q.d(r14);
        List r15 = r10.f14867b;
        q.d(r15);
        r14.onLetterChanged(((b) r15.get(r10.F)).b(), 1);
    L10:
        dd.a.f19178a.a(r10, 26);
        r10.setTouchedLetter(r10.F);
    L11:
        r10.I = -1;
    }

    private final void setLetterPaint(int r10) {
        if (m(r10) == false) goto L5;
        this.f14877l.setColor(this.f14882q);
    L6:
        this.f14877l.setFakeBoldText(false);
        this.f14877l.setTextSize(this.f14891z);
        List r11 = this.f14867b;
        q.d(r11);
        if (o.B(((b) r11.get(r10)).b(), LibrarianImpl.Constants.DOT, false, 2, null) == true) goto L13;
        List r12 = this.f14867b;
        q.d(r12);
        if (((b) r12.get(r10)).d() != 1) goto L11;
        this.f14877l.setTextSize(this.f14874i);
        this.f14877l.setFakeBoldText(true);
        return;
    L11:
        this.f14877l.setTextSize(this.f14873h);
        return;
    L13:
        return;
    L5:
        this.f14877l.setColor(this.f14883r);
        goto L6
    }

    private final void setTouchedLetter(int r10) {
        this.f14868c = r10;
        invalidate();
    }

    public final ArrayList c() {
        ArrayList r10 = new ArrayList();
        int r11 = this.f14876k;
        List r12 = this.f14867b;
        q.d(r12);
        if ((r11 / r12.size()) >= this.f14872g) goto L5;
        List r13 = this.f14867b;
        q.d(r13);
        int r14 = (int) Math.max(2.0d, ((int) Math.ceil(r13.size() / ((this.f14876k / this.f14872g) - 2))) * 2);
    L6:
        r10.add(0);
        List r15 = this.f14867b;
        q.d(r15);
        if (r14 >= (r15.size() / 2)) goto L12;
        int r16 = r14;
    L9:
        List r17 = this.f14867b;
        q.d(r17);
        if (r16 >= (r17.size() - 1)) goto L12;
        r10.add(Integer.valueOf(r16));
        r16 = r16 + r14;
    L12:
        List r18 = this.f14867b;
        q.d(r18);
        if (r14 >= r18.size()) goto L15;
        List r19 = this.f14867b;
        q.d(r19);
        r10.add(Integer.valueOf(r19.size() - 1));
    L15:
        return r10;
    L5:
        r14 = 1;
        goto L6
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent r12) {
        q.g(r12, "event");
        super.dispatchTouchEvent(r12);
        int r10 = r12.getAction();
        float r11 = r12.getY();
        this.E = this.f14868c;
        float r13 = (r11 - getPaddingTop()) / ((getHeight() - getPaddingTop()) - getPaddingBottom());
        List r14 = this.f14867b;
        q.d(r14);
        int r15 = (int) (r13 * r14.size());
        this.F = r15;
        if (r10 != 0) goto L5;
        removeCallbacks(this.H);
        this.B = r12.getX();
        this.C = r12.getY();
        this.D = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (this.f14889x.b() == true) goto L49;
        this.I = System.currentTimeMillis();
        postDelayed(this.G, 200);
    L49:
        this.A = null;
        setShowBg(false);
    L50:
        return true;
    L5:
        if (r10 != 1) goto L7;
        removeCallbacks(this.G);
        if ((System.currentTimeMillis() - this.I) >= 100) goto L39;
        if (this.f14889x.b() == true) goto L39;
        this.I = -1;
        this.G.run();
        postDelayed(this.H, 200);
        return true;
    L39:
        if (this.f14889x.b() == false) goto L41;
        removeCallbacks(this.H);
    L41:
        this.I = -1;
        if (this.f14869d == false) goto L44;
        this.f14889x.a();
        setTouchedLetter(-1);
        setShowBg(false);
    L45:
        invalidate();
        goto L50
    L44:
        this.f14889x.a();
        goto L45
    L7:
        if (r10 == 2) goto L16;
        if (r10 != 3) goto L50;
        removeCallbacks(this.G);
        if (this.f14889x.b() == false) goto L14;
        removeCallbacks(this.H);
    L14:
        this.I = -1;
        this.f14889x.a();
        setTouchedLetter(-1);
        goto L50
    L16:
        if (Math.sqrt(Math.pow(r12.getX() - this.B, 2.0d) + Math.pow(r12.getY() - this.C, 2.0d)) >= this.D) goto L19;
        return true;
    L19:
        if (this.f14889x.b() == false) goto L31;
        if (r15 < 0) goto L31;
        List r16 = this.f14867b;
        q.d(r16);
        if (r15 >= r16.size()) goto L31;
        if (this.f14869d == true) goto L26;
    L30:
        setTouchedLetter(r15);
        goto L31
    L26:
        if (this.E == r15) goto L30;
        if (this.f14886u == null) goto L30;
        removeCallbacks(this.H);
        q("ACTION_MOVE", r15);
        dd.a.f19178a.a(this, 26);
        LBListener r17 = this.f14886u;
        q.d(r17);
        List r18 = this.f14867b;
        q.d(r18);
        r17.onLetterChanged(((b) r18.get(r15)).b(), 0);
    L31:
        setShowBg(false);
        goto L50
    }

    public final void e(int r10, Canvas r11, float r12, float r13) {
        Bitmap r14 = this.f14884s;
        if (r14 == null) goto L7;
        r11.drawBitmap(r14, this.f14885t, r13 - (r14.getHeight() / 2), i(this.f14877l.getColor()));
        return;
    }

    public final void f(int r10, Canvas r11, float r12, float r13) {
        if (m(r10) == true) goto L5;
        return;
    L5:
        if (this.f14869d == false) goto L9;
        Paint r14 = new Paint();
        r14.setColor(getContext().getResources().getColor(R$color.Transparent));
        int r15 = tc.f.r(this, 14);
        tc.f.r(this, 14);
        float r16 = r15 / 2.0f;
        int r17 = this.f14875j;
        r11.drawRoundRect(new RectF(r17 - r16, r13 - r16, r17 + r16, r13 + r16), r16, r16, r14);
        return;
    }

    public final void g(int r10, Canvas r11, float r12, float r13) {
        List r14 = this.f14867b;
        q.d(r14);
        String r15 = ((b) r14.get(r10)).b();
        if (o.B(r15, LibrarianImpl.Constants.DOT, false, 2, null) == false) goto L5;
        e(r10, r11, r12, r13);
        return;
    L5:
        Paint.FontMetricsInt r16 = this.f14877l.getFontMetricsInt();
        int r17 = r16.bottom;
        int r18 = r16.top;
        r11.drawText(r15, r12, (r13 - ((r17 - r18) / 2)) - r18, this.f14877l);
    }

    @NotNull
    public final Runnable getDismissPopupTask() {
        return this.H;
    }

    public final float getDownX() {
        return this.B;
    }

    public final float getDownY() {
        return this.C;
    }

    public final int getMHasChosenLetterFontColor() {
        return this.f14882q;
    }

    public final int getMNoChosenLetterFontColor() {
        return this.f14883r;
    }

    public final int getNewChosen() {
        return this.F;
    }

    public final int getOldChosen() {
        return this.E;
    }

    @NotNull
    public final Runnable getShowPopupTask() {
        return this.G;
    }

    public final long getShowPopupTaskStartTime() {
        return this.I;
    }

    public final int getTouchSlop() {
        return this.D;
    }

    public final void h(int r10, Canvas r11, float r12, float r13) {
        List r14 = this.f14867b;
        if (r14 != null) goto L5;
        b r15 = null;
    L6:
        if (r15 != null) goto L8;
        return;
    L8:
        Bitmap[] r16 = r15.c();
        if (r16 != null) goto L12;
        return;
    L12:
        if (m(r10) == true) goto L14;
    L16:
        boolean r17 = false;
    L18:
        if (l() == false) goto L20;
    L23:
        boolean r18 = true;
    L25:
        if (r17 == false) goto L27;
        Bitmap r19 = r16[2];
    L30:
        if (r19 != null) goto L34;
        r19 = r16[0];
        if (r19 != null) goto L34;
        return;
    L34:
        if (r17 == false) goto L36;
        int r20 = this.f14882q;
    L37:
        r11.drawBitmap(r19, this.f14875j - (r19.getWidth() / 2), r13 - (r19.getHeight() / 2), i(r20));
        return;
    L36:
        r20 = this.f14883r;
        goto L37
    L27:
        if (r18 == false) goto L29;
        r19 = r16[1];
        goto L30
    L29:
        r19 = r16[0];
        goto L30
    L20:
        if (this.f14869d == false) goto L23;
        r18 = false;
        goto L25
    L14:
        if (this.f14869d == false) goto L16;
        r17 = true;
        goto L18
    L5:
        r15 = (b) b0.a0(r14, r10);
        goto L6
    }

    public final Paint i(int r10) {
        this.f14878m.setColorFilter(new PorterDuffColorFilter(r10, PorterDuff.Mode.SRC_IN));
        return this.f14878m;
    }

    public final float j(int r10, ArrayList r11) {
        return (float) Math.max(r10 / r11.size(), this.f14872g);
    }

    public final void k(Context r10) {
        this.f14866a = r10;
        o();
        Context r11 = this.f14866a;
        q.d(r11);
        Resources r12 = r11.getResources();
        this.f14872g = r12.getDimensionPixelSize(R$dimen.letters_bar_single_letter_min_height);
        this.f14871f = tc.f.r(this, 14);
        this.f14873h = r12.getDimensionPixelOffset(R$dimen.letters_bar_letter_font_size);
        this.f14874i = r12.getDimensionPixelOffset(R$dimen.letters_bar_letter_locale_font_size);
        this.f14875j = (this.f14871f / 2) + getPaddingLeft();
        int r13 = R$drawable.letters_bar_highlight_icon;
        this.f14879n = BitmapFactory.decodeResource(r12, r13);
        Drawable r14 = r12.getDrawable(r13);
        this.f14880o = this.f14875j - (r14.getIntrinsicWidth() / 2);
        this.f14881p = r14.getIntrinsicHeight();
        this.f14882q = r12.getColor(R$color.oui_functional_blue_6);
        this.f14883r = r12.getColor(R$color.oui_text_3b);
        Bitmap r15 = BitmapFactory.decodeResource(r12, R$drawable.letters_bar_dot);
        this.f14884s = r15;
        int r16 = this.f14875j;
        q.d(r15);
        this.f14885t = r16 - (r15.getWidth() / 2);
        this.f14877l.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        this.f14877l.setTextSize(this.f14873h);
        this.f14877l.setAntiAlias(true);
        this.f14890y = r10.getResources().getDisplayMetrics().widthPixels;
    }

    public final boolean l() {
        if (this.f14868c == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean m(int r10) {
        if (this.f14868c != r10) goto L5;
        return true;
    L5:
        return false;
    }

    public final int n(int r10) {
        int r11 = View.MeasureSpec.getMode(r10);
        int r12 = View.MeasureSpec.getSize(r10);
        if (r11 != Integer.MIN_VALUE) goto L5;
        return r12;
    L5:
        if (r11 == 1073741824) goto L9;
        return 0;
    L9:
        return r12;
    }

    public final void o() {
        this.f14891z = tc.f.u(this, 10);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        o();
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        q.g(r10, "canvas");
        super.onDraw(r10);
        r10.save();
        r10.translate(0.0f, getPaddingTop());
        ArrayList r11 = c();
        float r12 = j(this.f14876k, r11);
        Iterator r13 = r11.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L10;
        Integer r15 = (Integer) r13.next();
        q.f(r15, SlideCard.KEY_INDEX);
        setLetterPaint(r15.intValue());
        float r16 = this.f14875j;
        Paint r17 = this.f14877l;
        List r18 = this.f14867b;
        q.d(r18);
        float r19 = 2;
        float r20 = r16 - (r17.measureText(((b) r18.get(r15.intValue())).b()) / r19);
        float r21 = (r14 * r12) + (r12 / r19);
        f(r15.intValue(), r10, r20, r21);
        List r22 = this.f14867b;
        q.d(r22);
        if (((b) r22.get(r15.intValue())).d() != 2) goto L8;
        h(r15.intValue(), r10, r20, r21);
    L9:
        r14 = r14 + 1;
        goto L4
    L8:
        g(r15.intValue(), r10, r20, r21);
        goto L9
    L10:
        r10.restore();
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        this.f14876k = (n(r11) - getPaddingTop()) - getPaddingBottom();
    }

    public final void q(String r11, int r12) {
        float r10 = j(this.f14876k, c());
        List r13 = this.f14867b;
        q.d(r13);
        String r14 = ((b) r13.get(r12)).b();
        if (q.b(r14, this.A) == false) goto L5;
        return;
    L5:
        L.a("LettersBar", "showPopupWindow, scene: " + r11 + ", c = " + r12 + ", letter = " + r14 + ", lastPopupLetter = " + this.A);
        Bitmap[] r15 = this.f14870e;
        if (r15 != null) goto L8;
        Integer r16 = null;
    L9:
        List r17 = this.f14867b;
        q.d(r17);
        if (((b) r17.get(r12)).d() != 2) goto L15;
        if (r16 == null) goto L15;
        if (Integer.parseInt(r14) > r16.intValue()) goto L15;
        Bitmap[] r18 = this.f14870e;
        q.d(r18);
        Bitmap r19 = r18[Integer.parseInt(r14) - 1];
    L16:
        int r20 = getResources().getDimensionPixelSize(R$dimen.oui_h_title_bar_window);
        int r21 = (this.f14890y - getWidth()) - tc.f.r(this, 68);
        int r22 = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r22 <= 0) goto L19;
        r20 = r20 + getResources().getDimensionPixelSize(r22);
    L19:
        int r23 = r20;
        int[] r24 = new int[2];
        getLocationInWindow(r24);
        this.f14889x.c(this, r14, r19, r21, (int) (((r24[1] + getPaddingTop()) + (r12 * r10)) + (r10 / 2)), r23);
        this.A = r14;
        return;
    L15:
        r19 = null;
        goto L16
    L8:
        r16 = Integer.valueOf(r15.length);
        goto L9
    }

    public final void setBitmapsSelected(@Nullable Bitmap[] r10) {
        this.f14870e = r10;
    }

    public final void setDownX(float r10) {
        this.B = r10;
    }

    public final void setDownY(float r10) {
        this.C = r10;
    }

    public final void setLetters(@Nullable List<b> r10) {
        this.f14867b = r10;
    }

    public final void setListener(@Nullable LBListener r10) {
        this.f14886u = r10;
    }

    public final void setMHasChosenLetterFontColor(int r10) {
        this.f14882q = r10;
    }

    public final void setMNoChosenLetterFontColor(int r10) {
        this.f14883r = r10;
    }

    public final void setNewChosen(int r10) {
        this.F = r10;
    }

    public final void setOldChosen(int r10) {
        this.E = r10;
    }

    public final void setOnBackgroundVisibleChangedListener(@Nullable OnBackgroundVisibleChangedListener r10) {
        this.f14888w = r10;
    }

    public final void setSettled(boolean r10) {
        this.f14869d = r10;
        if (r10 == false) goto L5;
        setTouchedLetter(-1);
    L5:
        invalidate();
    }

    public final void setShowBg(boolean r10) {
        if (this.f14887v == r10) goto L12;
        this.f14887v = r10;
        if (r10 == false) goto L7;
        Drawable r11 = getResources().getDrawable(R$drawable.letters_bar_background);
    L8:
        setBackground(r11);
        OnBackgroundVisibleChangedListener r12 = this.f14888w;
        if (r12 == null) goto L13;
        q.d(r12);
        r12.OnBackgroundVisibleChanged(this.f14887v);
        return;
    L13:
        return;
    L7:
        r11 = null;
        goto L8
    }

    public final void setShowPopupTaskStartTime(long r10) {
        this.I = r10;
    }

    public final void setTouchSlop(int r10) {
        this.D = r10;
    }

    @JvmOverloads
    public LettersBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ LettersBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public LettersBar(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f14868c = -1;
        this.f14869d = true;
        this.f14877l = new Paint();
        Paint r13 = new Paint(1);
        r13.setFilterBitmap(true);
        r13.setDither(true);
        this.f14878m = r13;
        this.f14889x = new f(r10);
        k(r10);
        this.E = -1;
        this.F = -1;
        this.G = new c(this);
        this.H = new d(this);
        this.I = -1;
    }
}
