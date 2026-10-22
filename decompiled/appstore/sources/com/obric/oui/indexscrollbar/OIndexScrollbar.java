package com.obric.oui.indexscrollbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$integer;
import com.obric.common.oui.R$layout;
import com.tmall.wireless.tangram.structure.card.FixCard;
import com.ttnet.org.chromium.net.NetError;
import fd.i;
import fd.j;
import fd.k;
import fd.l;
import fd.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Þ\u00012\u00020\u0001:\u0007[Tß\u0001cà\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u000fJ\u000f\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\nJ\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\nJ\u000f\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\nJ\u000f\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\nJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\"\u0010 J\u000f\u0010#\u001a\u00020\fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\f2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010,\u001a\u00020\b2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\fH\u0002¢\u0006\u0004\b,\u0010-J\u001f\u0010.\u001a\u00020\b2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\fH\u0002¢\u0006\u0004\b.\u0010-J\u000f\u0010/\u001a\u00020\bH\u0002¢\u0006\u0004\b/\u0010\nJ\u0019\u00101\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\bH\u0002¢\u0006\u0004\b3\u0010\nJ\u0017\u00106\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u000104¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u000108¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\b¢\u0006\u0004\b;\u0010\nJ\u0015\u0010<\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u001d¢\u0006\u0004\b<\u0010 J\u0015\u0010=\u001a\u00020\b2\u0006\u0010+\u001a\u00020\f¢\u0006\u0004\b=\u0010\u000fJ\r\u0010>\u001a\u00020\u001d¢\u0006\u0004\b>\u0010?J\r\u0010@\u001a\u00020\b¢\u0006\u0004\b@\u0010\nJ\u0015\u0010B\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u001d¢\u0006\u0004\bB\u0010 J\u0015\u0010D\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u001d¢\u0006\u0004\bD\u0010 J\u0015\u0010E\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bE\u0010FJ\u001f\u0010I\u001a\u00020\b2\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\fH\u0014¢\u0006\u0004\bI\u0010JJ\u0017\u0010K\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\bK\u0010LJ\u001f\u0010O\u001a\u00020\b2\u0006\u0010M\u001a\u00020)2\u0006\u0010N\u001a\u00020\fH\u0014¢\u0006\u0004\bO\u0010-J7\u0010U\u001a\u00020\b2\u0006\u0010P\u001a\u00020\u001d2\u0006\u0010Q\u001a\u00020\f2\u0006\u0010R\u001a\u00020\f2\u0006\u0010S\u001a\u00020\f2\u0006\u0010T\u001a\u00020\fH\u0014¢\u0006\u0004\bU\u0010VJ\u000f\u0010X\u001a\u0004\u0018\u00010W¢\u0006\u0004\bX\u0010YR\u001a\u0010_\u001a\u00020Z8\u0006X\u0086D¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u0017\u0010b\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\bT\u0010`\u001a\u0004\ba\u0010?R\u0018\u0010e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010h\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010o\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u001c\u0010s\u001a\b\u0018\u00010pR\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010\u0011R\u0016\u0010w\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010\u0011R\u0016\u0010y\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010\u0011R\u0016\u0010{\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010\u0011R\u0016\u0010|\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010\u0011R\u0016\u0010~\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010\u0011R\u0015\u0010\u0080\u0001\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u007f\u0010\u0011R\u0016\u0010\u0082\u0001\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010\u0011R\u0016\u0010\u0084\u0001\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010\u0011R\u0018\u0010\u0086\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010\u0011R\u0018\u0010\u0088\u0001\u001a\u00030\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010;R\u0019\u0010\u008a\u0001\u001a\u00030\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010;R\u0018\u0010\u008b\u0001\u001a\u00030\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010;R\u001b\u0010\u008e\u0001\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001a\u0010\u0090\u0001\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b'\u0010\u008f\u0001R\u0017\u0010\u0091\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010`R\u0017\u0010\u0092\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010`R\u001e\u0010\u0096\u0001\u001a\n\u0012\u0005\u0012\u00030\u0094\u00010\u0093\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bB\u0010\u0095\u0001R\u001b\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001b\u0010\u0098\u0001R)\u0010\u009d\u0001\u001a\u0013\u0012\u000e\u0012\f\u0012\u0007\u0012\u0005\u0018\u00010\u009b\u00010\u009a\u00010\u009a\u00018\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\bE\u0010\u009c\u0001R\u0017\u0010\u009e\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010`R\u001d\u0010¡\u0001\u001a\u00020\f8\u0006X\u0086D¢\u0006\u000e\n\u0005\b\u009f\u0001\u0010\u0011\u001a\u0005\b \u0001\u0010$R\u001d\u0010¤\u0001\u001a\u00020\f8\u0006X\u0086D¢\u0006\u000e\n\u0005\b¢\u0001\u0010\u0011\u001a\u0005\b£\u0001\u0010$R\u0018\u0010¦\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¥\u0001\u0010\u0011R\u001b\u0010©\u0001\u001a\u0005\u0018\u00010§\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b;\u0010¨\u0001R\u001b\u0010¬\u0001\u001a\u0005\u0018\u00010ª\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\t\u0010«\u0001R\u001b\u0010¯\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b>\u0010®\u0001R\u0015\u0010°\u0001\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0011R\u0015\u0010±\u0001\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001c\u0010\u0011R\u0017\u0010²\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0011R\u0017\u0010³\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010\u0011R\u0018\u0010µ\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b´\u0001\u0010\u0011R\u0018\u0010·\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¶\u0001\u0010\u0011R\u0017\u0010¸\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010\u0011R\u0018\u0010º\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¹\u0001\u0010\u0011R\u0017\u0010»\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0017\u0010¼\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010\u0011R\u0018\u0010¾\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b½\u0001\u0010\u0011R\u0016\u0010À\u0001\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0007\n\u0005\b¿\u0001\u0010\u0011R\u001c\u0010Â\u0001\u001a\u0005\u0018\u00010§\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010¨\u0001R\u001c\u0010Æ\u0001\u001a\u0005\u0018\u00010Ã\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R\u0016\u0010È\u0001\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0007\n\u0005\bÇ\u0001\u0010\u0011R\u0018\u0010Ê\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÉ\u0001\u0010\u0011R\u0018\u0010Ì\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bË\u0001\u0010\u0011R\u001a\u0010Î\u0001\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÍ\u0001\u0010\\R\u001d\u0010Ñ\u0001\u001a\u00020\f8\u0006X\u0086D¢\u0006\u000e\n\u0005\bÏ\u0001\u0010\u0011\u001a\u0005\bÐ\u0001\u0010$R\u0018\u0010Ó\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÒ\u0001\u0010`R\u0018\u0010Õ\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÔ\u0001\u0010\u0011R\u0018\u0010×\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÖ\u0001\u0010`R\u001c\u0010Û\u0001\u001a\u0005\u0018\u00010Ø\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010Ú\u0001R\u001a\u0010Ý\u0001\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÜ\u0001\u0010n¨\u0006á\u0001"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexScrollbar;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "G", "()V", "B", "", "hostWidth", "setHostWidth", "(I)V", "measureSpec", "I", "(I)I", "Landroid/view/MotionEvent;", "event", "onMoveInLongPressState", "(Landroid/view/MotionEvent;)V", WsConstants.KEY_CONNECTION_STATE, "setState", "Q", "K", "z", "J", "", "showBg", "setLettersBarBg", "(Z)V", "visible", "setShadowVisible", "getScreenWidth", "()I", "", "dipValue", "v", "(D)I", "Landroid/view/View;", "alphabetView", "position", "L", "(Landroid/view/View;I)V", "O", "w", "anchorView", "R", "(Landroid/view/View;)V", "getParentxPos", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar$QBListener;", "listener", "setQBListener", "(Lcom/obric/oui/indexscrollbar/OIndexScrollbar$QBListener;)V", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar$SurnameListener;", "setSurnameListener", "(Lcom/obric/oui/indexscrollbar/OIndexScrollbar$SurnameListener;)V", "F", "setPoundVisibility", "setPoundPosition", "H", "()Z", FixCard.FixStyle.KEY_X, "withAnim", FixCard.FixStyle.KEY_Y, "enabled", "setLongPressEnabled", "A", "(Landroid/content/Context;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "changedView", "visibility", "onVisibilityChanged", "changed", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "Lcom/obric/oui/indexscrollbar/LettersBar;", "getLetterBar", "()Lcom/obric/oui/indexscrollbar/LettersBar;", "", "a", "Ljava/lang/String;", "getOIndexScrollbar_TAG", "()Ljava/lang/String;", "OIndexScrollbar_TAG", "Z", "getOIndexScrollbar_DEBUG", "OIndexScrollbar_DEBUG", "c", "Landroid/content/Context;", "mContext", "d", "Lcom/obric/oui/indexscrollbar/LettersBar;", "mLettersBar", "Landroid/widget/GridView;", "e", "Landroid/widget/GridView;", "mGridView", "f", "Landroid/view/View;", "mShadowView", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar$a;", "g", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar$a;", "mAlphabetsAdapter", "h", "mStartX", "i", "mEndX", "j", "mWidth", "k", "mLettersBarOccupiedWidth", "mLetterbarShadowWidth", "m", "mMeasuredHeight", "n", "STATE_START", "o", "STATE_MOVE", "p", "STATE_END", "q", "mState", "", "mMissX", "s", "mLastRawX", "mCurrentRawX", "u", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar$QBListener;", "mQBListener", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar$SurnameListener;", "mSurnameListener", "mIsPerformingHideAnim", "mIsPerformingShowAnim", "", "Lfd/b;", "Ljava/util/List;", "mLetters", "", "[I", "mSymbols", "", "Landroid/graphics/Bitmap;", "[[Landroid/graphics/Bitmap;", "mIconsForSymbols", "mPoundVisibility", "C", "getPOUND_POSITION_TOP", "POUND_POSITION_TOP", "D", "getPOUND_POSITION_BOTTOM", "POUND_POSITION_BOTTOM", "E", "mPoundPosition", "Landroid/widget/PopupWindow;", "Landroid/widget/PopupWindow;", "mPopupWindow", "Lcom/obric/oui/indexscrollbar/SurnameGridView;", "Lcom/obric/oui/indexscrollbar/SurnameGridView;", "mPopupGridView", "Lcom/obric/oui/indexscrollbar/SurnameFlowLayout;", "Lcom/obric/oui/indexscrollbar/SurnameFlowLayout;", "mPopupFlowLayout", "SURNAME_NUM_COLUMNS_THRESHOLD", "SURNAME_NUM_ROWS_THRESHOLD", "mSurnameGridViewItemWidth", "mSurnameGridViewItemHeight", "M", "mPopupYOffset", "N", "mPopupViewMaxHeight", "mPopupViewPendingVertical", "P", "mPopupViewPendingHorizontal", "mSurnameGridViewNumColumns", "mSurnameGridViewNumRows", "S", "mSurnameGridViewColumnsThreshold", "T", "mColumnCount", "U", "mSecondPopup", "Landroid/widget/TextView;", "V", "Landroid/widget/TextView;", "mSecondPopupView", "W", "DEFAULTX", "a0", "mHostX", "b0", "mMinXDistance", "c0", "lastVibratedLetter", "d0", "getVISIBILITY_LIMIT", "VISIBILITY_LIMIT", "e0", "mHasPerformedLongPress", "f0", "mPrePosition", "g0", "mLongPressEnabled", "Landroid/view/ViewGroup;", "h0", "Landroid/view/ViewGroup;", "mSecondPopupViewParent", "i0", "mSecondPopupViewArrow", "j0", "QBListener", "SurnameListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OIndexScrollbar extends LinearLayout {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final b f14892j0 = null;
    public Bitmap[][] A;
    public boolean B;
    public final int C;
    public final int D;
    public int E;
    public PopupWindow F;
    public SurnameGridView G;
    public SurnameFlowLayout H;
    public final int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final int f14893J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public final int T;
    public PopupWindow U;
    public TextView V;
    public final int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14894a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f14895a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14896b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f14897b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f14898c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public String f14899c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LettersBar f14900d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final int f14901d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public GridView f14902e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f14903e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f14904f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f14905f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f14906g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f14907g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14908h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public ViewGroup f14909h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14910i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public View f14911i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14913k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14914l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14915m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f14916n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f14917o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f14918p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14919q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f14920r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f14921s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f14922t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public QBListener f14923u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public SurnameListener f14924v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f14925w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f14926x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List f14927y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int[] f14928z;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexScrollbar$QBListener;", "", "onLetterChanged", "", "letter", "", "type", "", "onLetterGridHidden", "", "onLetterGridShow", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface QBListener {
        boolean onLetterChanged(@Nullable String r10, int r11);

        void onLetterGridHidden();

        void onLetterGridShow();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004H&¨\u0006\t"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexScrollbar$SurnameListener;", "", "getMatchedSurnames", "", "", "letter", "onSurnameClicked", "", "surname", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface SurnameListener {
        @Nullable
        List<String> getMatchedSurnames(@Nullable String r10);

        void onSurnameClicked(@Nullable String r10);
    }

    public final class a extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f14929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String[] f14930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f14931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f14932d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f14933e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ OIndexScrollbar f14934f;

        public a(OIndexScrollbar r10, Context r11) {
            q.g(r10, "this$0");
            this.f14934f = r10;
            this.f14929a = r11;
            String r12 = Locale.getDefault().getLanguage();
            q.f(r12, "getDefault().language");
            this.f14931c = r12;
            float r13 = fd.a.f19644a.j(r12);
            this.f14932d = r13;
            int r14 = ((int) Math.ceil(r13)) - 1;
            GridView r15 = OIndexScrollbar.g(r10);
            q.d(r15);
            this.f14933e = r14 * r15.getVerticalSpacing();
        }

        public String a(int r10) {
            String[] r11 = this.f14930b;
            if (r11 != null) goto L6;
            q.y("mAlphabets");
            r11 = null;
        L6:
            return r11[r10];
        }

        public final int b() {
            return (int) ((OIndexScrollbar.h(this.f14934f) - this.f14933e) / this.f14932d);
        }

        public final boolean c() {
            if (((int) ((OIndexScrollbar.h(this.f14934f) - this.f14933e) % this.f14932d)) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean d(int r10) {
            if (r10 != (getCount() - 1)) goto L5;
            return true;
        L5:
            if (r10 != (getCount() - 2)) goto L7;
            return true;
        L7:
            if (r10 == (getCount() - 3)) goto L13;
            return false;
        L13:
            return true;
        }

        public final void e(String[] r10) {
            if (r10 == null) goto L5;
            this.f14930b = r10;
            return;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f14930b != null) goto L5;
            q.y("mAlphabets");
        L5:
            String[] r10 = this.f14930b;
            if (r10 != null) goto L9;
            q.y("mAlphabets");
            r10 = null;
        L9:
            return r10.length;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r10) {
            return a(r10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r10) {
            return r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r11v1, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r11v4 */
        /* JADX WARN: Type inference failed for: r11v6, types: [android.widget.ImageView] */
        @Override // android.widget.Adapter
        public View getView(int r10, View r11, ViewGroup r12) {
            q.g(r12, "parent");
            String[] r13 = this.f14930b;
            if (r13 != null) goto L5;
            q.y("mAlphabets");
            r13 = null;
        L5:
            String r14 = r13[r10];
            int r15 = b();
            float r16 = OIndexScrollbar.h(this.f14934f) - this.f14933e;
            float r17 = this.f14932d;
            int r18 = (int) (r16 - (r15 * r17));
            if (r17 == 9.0f) goto L8;
        L12:
            if (r11 != 0) goto L27;
            fd.a r19 = fd.a.f19644a;
            if (r19.i(r14) == false) goto L16;
            r11 = new ImageView(this.f14929a);
            r11.setImageResource(R$drawable.letter_bar_unfold_button);
            r11.setScaleType(ImageView.ScaleType.CENTER);
            r11.setMinimumHeight(r15);
            goto L27
        L16:
            AlphabetView r20 = new AlphabetView(this.f14929a, null, 0, 6, null);
            r20.setHeight(r15);
            if (r19.c(r14) == false) goto L20;
            r20.setTextColor(Color.parseColor("#80000000"));
            r14 = r14.substring(1);
            q.f(r14, "this as java.lang.String).substring(startIndex)");
        L20:
            if (r19.f(r14) == true) goto L23;
            r20.setText(r14);
        L23:
            if (r19.g(r14) == false) goto L25;
            r20.setTypeface(null, 0);
        L25:
            r11 = r20;
        L27:
            if (((r10 / 3) % 2) != 0) goto L29;
            Context r21 = this.f14929a;
            q.d(r21);
            Drawable r22 = r21.getResources().getDrawable(R$drawable.quickbar_ex_alphabet_text_light_colorlist);
        L30:
            r11.setBackground(r22);
            return r11;
        L29:
            Context r23 = this.f14929a;
            q.d(r23);
            r22 = r23.getResources().getDrawable(R$drawable.quickbar_ex_alphabet_text_dark_colorlist);
            goto L30
        L8:
            if (c() == false) goto L12;
            if (d(r10) == false) goto L12;
            r15 = r15 + r18;
            goto L12
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r10) {
            fd.a r11 = fd.a.f19644a;
            String[] r12 = this.f14930b;
            String[] r13 = null;
            if (r12 != null) goto L6;
            q.y("mAlphabets");
            r12 = null;
        L6:
            if (r11.f(r12[r10]) == true) goto L14;
            String[] r14 = this.f14930b;
            if (r14 != null) goto L10;
            q.y("mAlphabets");
        L12:
            if (r11.c(r13[r10]) == true) goto L14;
            return true;
        L10:
            r13 = r14;
        L14:
            return false;
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public b() {
        }
    }

    public final class c extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f14935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f14936b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OIndexScrollbar f14937c;

        public c(OIndexScrollbar r10, Context r11, List r12) {
            q.g(r10, "this$0");
            this.f14937c = r10;
            this.f14935a = r11;
            this.f14936b = r12;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List r10 = this.f14936b;
            if (r10 != null) goto L6;
            return 0;
        L6:
            return r10.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r10) {
            List r11 = this.f14936b;
            if (r11 != null) goto L5;
            String r12 = null;
        L6:
            q.d(r12);
            return r12;
        L5:
            r12 = (String) r11.get(r10);
            goto L6
        }

        @Override // android.widget.Adapter
        public long getItemId(int r10) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int r10, View r11, ViewGroup r12) {
            q.g(r12, "parent");
            if (r11 != null) goto L5;
            r11 = LayoutInflater.from(this.f14935a).inflate(R$layout.o_surname_popup_item_ex, null);
            r11.setLayoutParams(new AbsListView.LayoutParams(OIndexScrollbar.m(this.f14937c), OIndexScrollbar.l(this.f14937c)));
        L5:
            int r13 = r10 % OIndexScrollbar.k(this.f14937c);
            if (r13 == 0) goto L8;
        L10:
            if (r13 != 0) goto L13;
            r11.setBackgroundResource(R$drawable.surname_popup_item_right);
        L19:
            List r14 = this.f14936b;
            q.d(r14);
            ((TextView) r11).setText(((String) r14.get(r10)).toString());
            return r11;
        L13:
            if (r13 != (OIndexScrollbar.k(this.f14937c) - 1)) goto L15;
        L18:
            r11.setBackgroundResource(R$drawable.surname_popup_item_left);
            goto L19
        L15:
            if (r10 == (getCount() - 1)) goto L18;
            r11.setBackgroundResource(R$drawable.surname_popup_item_middle);
            goto L19
        L8:
            if (r10 != (getCount() - 1)) goto L10;
            r11.setBackgroundResource(R$drawable.surname_popup_item_special);
            goto L19
        }
    }

    public static final class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OIndexScrollbar f14938a;

        public d(OIndexScrollbar r10) {
            this.f14938a = r10;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            q.g(r10, "arg0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            q.g(r10, "arg0");
            OIndexScrollbar.r(this.f14938a, false);
            OIndexScrollbar.n(this.f14938a);
            if (OIndexScrollbar.j(this.f14938a) == null) goto L6;
            QBListener r11 = OIndexScrollbar.j(this.f14938a);
            q.d(r11);
            r11.onLetterGridHidden();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r10) {
            q.g(r10, "arg0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            q.g(r10, "arg0");
            OIndexScrollbar.r(this.f14938a, true);
        }
    }

    public static final class e implements LettersBar.LBListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OIndexScrollbar f14939a;

        public e(OIndexScrollbar r10) {
            this.f14939a = r10;
        }

        @Override // com.obric.oui.indexscrollbar.LettersBar.LBListener
        public boolean onLetterChanged(String r10, int r11) {
            OIndexScrollbar.p(this.f14939a, r10);
            if (OIndexScrollbar.j(this.f14939a) == null) goto L7;
            QBListener r12 = OIndexScrollbar.j(this.f14939a);
            q.d(r12);
            if (r12.onLetterChanged(r10, r11) == false) goto L7;
            return true;
        L7:
            return false;
        }
    }

    public static final class f implements LettersBar.OnBackgroundVisibleChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OIndexScrollbar f14940a;

        public f(OIndexScrollbar r10) {
            this.f14940a = r10;
        }

        @Override // com.obric.oui.indexscrollbar.LettersBar.OnBackgroundVisibleChangedListener
        public void OnBackgroundVisibleChanged(boolean r10) {
            OIndexScrollbar.t(this.f14940a, r10);
        }
    }

    public static final class g implements SurnameGridView.OnPressChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OIndexScrollbar f14941a;

        public g(OIndexScrollbar r10) {
            this.f14941a = r10;
        }

        public static /* synthetic */ void a(OIndexScrollbar r10) {
            b(r10);
        }

        public static final void b(OIndexScrollbar r10) {
            q.g(r10, "this$0");
            OIndexScrollbar.u(r10, null);
        }

        @Override // com.obric.oui.indexscrollbar.SurnameGridView.OnPressChangeListener
        public void onTouched(int r10) {
            if (r10 != (-1)) goto L5;
            Handler r11 = new Handler(Looper.getMainLooper());
            final OIndexScrollbar r12 = this.f14941a;
            r11.postDelayed(new m(r12), 100);
            return;
        L5:
            SurnameGridView r13 = OIndexScrollbar.i(this.f14941a);
            q.d(r13);
            SurnameGridView r14 = OIndexScrollbar.i(this.f14941a);
            q.d(r14);
            View r15 = r13.getChildAt(r10 - r14.getFirstVisiblePosition());
            q.f(r15, "mPopupGridView!!.getChil…etFirstVisiblePosition())");
            SurnameGridView r16 = OIndexScrollbar.i(this.f14941a);
            q.d(r16);
            Object r17 = r16.getAdapter().getItem(r10);
            if (r17 == null) goto L10;
            r15.setTag((String) r17);
            OIndexScrollbar.u(this.f14941a, r15);
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    public static final class h implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OIndexScrollbar f14942a;

        public h(OIndexScrollbar r10) {
            this.f14942a = r10;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            q.g(r10, "arg0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            q.g(r10, "arg0");
            OIndexScrollbar.s(this.f14942a, false);
            OIndexScrollbar.o(this.f14942a);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r10) {
            q.g(r10, "arg0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            q.g(r10, "arg0");
            OIndexScrollbar.s(this.f14942a, true);
            OIndexScrollbar.q(this.f14942a, true);
        }
    }

    static {
        f14892j0 = new b(null);
    }

    public OIndexScrollbar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f14894a = "OIndexScrollbar";
        this.f14896b = Log.isLoggable("OIndexScrollbar", 3);
        this.f14916n = 1;
        this.f14917o = 2;
        this.f14918p = 3;
        this.f14919q = 1;
        this.f14927y = new ArrayList();
        this.B = true;
        this.C = 1;
        this.D = 2;
        this.E = 2;
        this.I = 8;
        this.f14893J = 8;
        this.T = 3;
        this.W = -99999;
        this.f14895a0 = -99999;
        A(r10);
        this.f14901d0 = 30;
        this.f14905f0 = -1;
        this.f14907g0 = true;
    }

    public static final void C(OIndexScrollbar r10, AdapterView r11, View r12, int r13, long r14) {
        q.g(r10, "this$0");
        fd.a r15 = fd.a.f19644a;
        a r16 = r10.f14906g;
        q.d(r16);
        if (r15.i(r16.a(r13)) == true) goto L7;
        QBListener r17 = r10.f14923u;
        q.d(r17);
        a r18 = r10.f14906g;
        q.d(r18);
        if (r17.onLetterChanged(r18.a(r13), 1) == false) goto L7;
        r10.invalidate();
    L7:
        r10.z();
    }

    public static final boolean D(OIndexScrollbar r10, View r11, MotionEvent r12) {
        q.g(r10, "this$0");
        if (r10.f14919q == r10.f14918p) goto L5;
        return false;
    L5:
        if (r12.getAction() != 0) goto L14;
        PopupWindow r13 = r10.F;
        if (r13 == null) goto L15;
        q.d(r13);
        if (r13.isShowing() == false) goto L16;
        PopupWindow r14 = r10.F;
        q.d(r14);
        r14.dismiss();
        return true;
    L16:
        return false;
    L15:
        return false;
    L14:
        return false;
    }

    public static final boolean E(OIndexScrollbar r10, AdapterView r11, View r12, int r13, long r14) {
        q.g(r10, "this$0");
        if (r10.f14907g0 == true) goto L5;
        return false;
    L5:
        fd.a r15 = fd.a.f19644a;
        a r16 = r10.f14906g;
        q.d(r16);
        if (r15.i(r16.a(r13)) == true) goto L13;
        String r17 = Locale.getDefault().getLanguage();
        q.f(r17, "getDefault().language");
        if (r15.k(r17) != 1) goto L10;
        q.f(r12, "view");
        r10.L(r12, r13);
    L11:
        r10.f14903e0 = true;
        return true;
    L10:
        q.f(r12, "view");
        r10.O(r12, r13);
        goto L11
    L13:
        return false;
    }

    public static final void M(OIndexScrollbar r10, View r11) {
        q.g(r10, "this$0");
        if (r11 == null) goto L7;
        String r12 = ((TextView) r11).getText().toString();
        SurnameListener r13 = r10.f14924v;
        q.d(r13);
        r13.onSurnameClicked(r12);
        r10.x();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public static final boolean N(OIndexScrollbar r10, TextView r11, View r12, MotionEvent r13) {
        q.g(r10, "this$0");
        q.g(r11, "$surnameView");
        if (r13.getAction() == 0) goto L9;
        if (r13.getAction() == 2) goto L9;
        r10.R(null);
        return false;
    L9:
        if (r10.U != null) goto L11;
    L15:
        r12.setTag(r11.getText());
        r10.R(r12);
        return false;
    L11:
        if (r10.V == null) goto L15;
        CharSequence r14 = r11.getText();
        TextView r15 = r10.V;
        q.d(r15);
        if (q.b(r14, r15.getText()) == true) goto L15;
        PopupWindow r16 = r10.U;
        q.d(r16);
        r16.dismiss();
        goto L15
    }

    public static final void P(OIndexScrollbar r10, AdapterView r11, View r12, int r13, long r14) {
        q.g(r10, "this$0");
        Object r15 = r11.getItemAtPosition(r13);
        if (r15 == null) goto L7;
        SurnameListener r16 = r10.f14924v;
        q.d(r16);
        r16.onSurnameClicked((String) r15);
        r10.x();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public static /* synthetic */ boolean a(OIndexScrollbar r10, View r11, MotionEvent r12) {
        return D(r10, r11, r12);
    }

    public static /* synthetic */ void b(OIndexScrollbar r10, AdapterView r11, View r12, int r13, long r14) {
        C(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void c(OIndexScrollbar r10, View r11) {
        M(r10, r11);
    }

    public static /* synthetic */ boolean d(OIndexScrollbar r10, AdapterView r11, View r12, int r13, long r14) {
        return E(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ boolean e(OIndexScrollbar r10, TextView r11, View r12, MotionEvent r13) {
        return N(r10, r11, r12, r13);
    }

    public static /* synthetic */ void f(OIndexScrollbar r10, AdapterView r11, View r12, int r13, long r14) {
        P(r10, r11, r12, r13, r14);
    }

    public static final /* synthetic */ GridView g(OIndexScrollbar r10) {
        return r10.f14902e;
    }

    private final void getParentxPos() {
        if (this.f14895a0 == this.W) goto L5;
        return;
    L5:
        Object r10 = getParent();
        q.f(r10, "this@OIndexScrollbar.getParent()");
        if ((r10 instanceof View) == false) goto L9;
        int[] r11 = new int[2];
        ((View) r10).getLocationInWindow(r11);
        this.f14895a0 = r11[0];
        return;
    }

    private final int getScreenWidth() {
        Point r10 = new Point();
        Context r11 = this.f14898c;
        q.d(r11);
        Object r12 = r11.getSystemService("window");
        if (r12 == null) goto L7;
        ((WindowManager) r12).getDefaultDisplay().getSize(r10);
        return r10.x;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public static final /* synthetic */ int h(OIndexScrollbar r10) {
        return r10.f14915m;
    }

    public static final /* synthetic */ SurnameGridView i(OIndexScrollbar r10) {
        return r10.G;
    }

    public static final /* synthetic */ QBListener j(OIndexScrollbar r10) {
        return r10.f14923u;
    }

    public static final /* synthetic */ int k(OIndexScrollbar r10) {
        return r10.S;
    }

    public static final /* synthetic */ int l(OIndexScrollbar r10) {
        return r10.L;
    }

    public static final /* synthetic */ int m(OIndexScrollbar r10) {
        return r10.K;
    }

    public static final /* synthetic */ void n(OIndexScrollbar r10) {
        r10.J();
    }

    public static final /* synthetic */ void o(OIndexScrollbar r10) {
        r10.K();
    }

    private final void onMoveInLongPressState(MotionEvent r13) {
        PopupWindow r10 = this.F;
        if (r10 == null) goto L45;
        q.d(r10);
        if (r10.isShowing() == false) goto L49;
        int r11 = (int) r13.getRawX();
        int r14 = (int) r13.getRawY();
        fd.a r12 = fd.a.f19644a;
        String r15 = Locale.getDefault().getLanguage();
        q.f(r15, "getDefault().language");
        if (r12.k(r15) != 1) goto L29;
        SurnameFlowLayout r16 = this.H;
        if (r16 == null) goto L46;
        int[] r17 = new int[2];
        q.d(r16);
        r16.getLocationOnScreen(r17);
        SurnameFlowLayout r18 = this.H;
        q.d(r18);
        int r19 = r18.getChildCount();
        int r20 = 0;
    L12:
        if (r20 >= r19) goto L17;
        int r21 = r20 + 1;
        SurnameFlowLayout r22 = this.H;
        q.d(r22);
        View r23 = r22.getChildAt(r20);
        q.f(r23, "mPopupFlowLayout!!.getChildAt(i)");
        Rect r110 = new Rect();
        r23.getHitRect(r110);
        if (r110.contains(r11 - r17[0], r14 - r17[1]) == true) goto L19;
        r20 = r21;
    L19:
        if (r20 >= 0) goto L21;
        SurnameFlowLayout r24 = this.H;
        q.d(r24);
        View r25 = r24.getChildAt(this.f14905f0);
        q.f(r25, "mPopupFlowLayout!!.getChildAt(mPrePosition)");
        r25.setPressed(false);
        R(null);
    L28:
        this.f14905f0 = r20;
        return;
    L21:
        if (this.f14905f0 == r20) goto L28;
        SurnameFlowLayout r26 = this.H;
        q.d(r26);
        View r27 = r26.getChildAt(this.f14905f0);
        q.f(r27, "mPopupFlowLayout!!.getChildAt(mPrePosition)");
        r27.setPressed(false);
        R(null);
        SurnameFlowLayout r111 = this.H;
        q.d(r111);
        View r112 = r111.getChildAt(r20);
        q.f(r112, "mPopupFlowLayout!!.getChildAt(position)");
        r112.setPressed(true);
        CharSequence r28 = ((TextView) r112).getText();
        if (r28 == null) goto L26;
        r112.setTag((String) r28);
        R(r112);
        goto L28
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L17:
        r20 = -1;
        goto L19
    L46:
        return;
    L29:
        SurnameGridView r29 = this.G;
        if (r29 == null) goto L48;
        int[] r30 = new int[2];
        q.d(r29);
        r29.getLocationOnScreen(r30);
        int r31 = r11 - r30[0];
        int r113 = r14 - r30[1];
        SurnameGridView r32 = this.G;
        q.d(r32);
        int r114 = r32.pointToPosition(r31, r113);
        if (r114 >= 0) goto L34;
        SurnameGridView r33 = this.G;
        q.d(r33);
        View r34 = r33.getChildAt(this.f14905f0);
        q.f(r34, "mPopupGridView!!.getChildAt(mPrePosition)");
        r34.setPressed(false);
        R(null);
    L41:
        this.f14905f0 = r114;
        return;
    L34:
        if (this.f14905f0 == r114) goto L41;
        SurnameGridView r35 = this.G;
        q.d(r35);
        View r36 = r35.getChildAt(this.f14905f0);
        q.f(r36, "mPopupGridView!!.getChildAt(mPrePosition)");
        r36.setPressed(false);
        R(null);
        SurnameGridView r37 = this.G;
        q.d(r37);
        View r38 = r37.getChildAt(r114);
        q.f(r38, "mPopupGridView!!.getChildAt(position)");
        r38.setPressed(true);
        SurnameGridView r39 = this.G;
        q.d(r39);
        Object r40 = r39.getAdapter().getItem(r114);
        if (r40 == null) goto L39;
        r38.setTag((String) r40);
        R(r38);
        goto L41
    L39:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L48:
        return;
    L49:
        return;
    }

    public static final /* synthetic */ void p(OIndexScrollbar r10, String r11) {
        r10.f14899c0 = r11;
    }

    public static final /* synthetic */ void q(OIndexScrollbar r10, boolean r11) {
        r10.setLettersBarBg(r11);
    }

    public static final /* synthetic */ void r(OIndexScrollbar r10, boolean r11) {
        r10.f14925w = r11;
    }

    public static final /* synthetic */ void s(OIndexScrollbar r10, boolean r11) {
        r10.f14926x = r11;
    }

    private final void setHostWidth(int r10) {
        int r11 = (r10 - this.f14913k) - this.f14914l;
        this.f14908h = r11;
        int r12 = r10 - this.f14912j;
        this.f14910i = r12;
        int r13 = this.f14919q;
        if (r13 != this.f14916n) goto L6;
        float r14 = r11;
    L9:
        setX(r14);
        if (this.f14896b == false) goto L12;
        Log.d(this.f14894a, q.p("mStartX = ", Integer.valueOf(this.f14908h)));
    L12:
        invalidate();
        return;
    L6:
        if (r13 != this.f14918p) goto L8;
        r14 = r12;
        goto L9
    L8:
        r14 = getX();
        goto L9
    }

    private final void setLettersBarBg(boolean r10) {
        LettersBar r11 = this.f14900d;
        q.d(r11);
        r11.setShowBg(r10);
        setShadowVisible(r10);
    }

    private final void setShadowVisible(boolean r10) {
        View r11 = this.f14904f;
        q.d(r11);
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        return;
    L5:
        r12 = 4;
        goto L6
    }

    private final void setState(int r10) {
        this.f14919q = r10;
        LettersBar r11 = this.f14900d;
        q.d(r11);
        if (r10 != this.f14916n) goto L5;
        boolean r12 = true;
    L6:
        r11.setSettled(r12);
        return;
    L5:
        r12 = false;
        goto L6
    }

    public static final /* synthetic */ void t(OIndexScrollbar r10, boolean r11) {
        r10.setShadowVisible(r11);
    }

    public static final /* synthetic */ void u(OIndexScrollbar r10, View r11) {
        r10.R(r11);
    }

    public final void A(Context r10) {
        q.g(r10, "context");
        this.f14898c = r10;
        q.d(r10);
        Resources r11 = r10.getResources();
        LayoutInflater.from(this.f14898c).inflate(R$layout.o_index_scrollbar, this, true);
        this.f14913k = tc.f.r(this, 22);
        int r12 = r11.getDimensionPixelOffset(R$dimen.bytedance_quickbar_grid_item_space);
        int r13 = r11.getDimensionPixelOffset(R$dimen.quickbar_ex_grid_column_width);
        this.f14897b0 = r11.getDimensionPixelOffset(R$dimen.bytedance_quickbar_min_distance);
        this.f14914l = r11.getDrawable(R$drawable.letters_bar_background_shadow).getIntrinsicWidth();
        int r14 = (r12 * 2) + this.f14913k;
        Context r15 = this.f14898c;
        q.d(r15);
        this.f14912j = (r14 + (r13 * r15.getResources().getInteger(R$integer.bytedance_letterbar_gridview_column_num))) + this.f14914l;
        G();
        B();
        this.f14904f = findViewById(R$id.iv_letter_bar_shadow);
        setLettersBarBg(false);
    }

    public final void B() {
        View r10 = findViewById(R$id.quickbar_right_grid_view);
        if (r10 == null) goto L7;
        this.f14902e = (GridView) r10;
        a r11 = new a(this, this.f14898c);
        this.f14906g = r11;
        q.d(r11);
        fd.a r12 = fd.a.f19644a;
        String r13 = Locale.getDefault().getLanguage();
        q.f(r13, "getDefault().language");
        r11.e(r12.a(r13));
        GridView r14 = this.f14902e;
        q.d(r14);
        r14.setAdapter(this.f14906g);
        GridView r15 = this.f14902e;
        q.d(r15);
        r15.setOnItemClickListener(new fd.g(this));
        GridView r16 = this.f14902e;
        q.d(r16);
        r16.setOnTouchListener(new fd.h(this));
        GridView r17 = this.f14902e;
        q.d(r17);
        r17.setOnItemLongClickListener(new i(this));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.GridView");
    }

    public final void F() {
        this.f14927y.clear();
        int[] r10 = this.f14928z;
        int r11 = 0;
        if (r10 == null) goto L11;
        q.d(r10);
        int r12 = r10.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L10;
        int r14 = r13 + 1;
        List r15 = this.f14927y;
        fd.b.a r16 = fd.b.f19650d;
        int[] r17 = this.f14928z;
        q.d(r17);
        String r18 = String.valueOf(r17[r13]);
        Bitmap[][] r19 = this.A;
        if (r19 != null) goto L9;
        q.y("mIconsForSymbols");
        r19 = null;
    L9:
        r15.add(r16.c(r18, r19[r13]));
        r13 = r14;
        goto L5
    L10:
        int[] r20 = this.f14928z;
        q.d(r20);
        int r21 = r20.length;
    L12:
        fd.e r22 = fd.e.f19657a;
        String r23 = Locale.getDefault().getLanguage();
        q.f(r23, "getDefault().language");
        String[] r24 = r22.b(r23);
        int r25 = r24.length - 1;
    L13:
        if (r11 >= r25) goto L20;
        int r26 = r11 + 1;
        fd.e r27 = fd.e.f19657a;
        String r28 = Locale.getDefault().getLanguage();
        q.f(r28, "getDefault().language");
        if (r27.a(r28, r11) == false) goto L17;
        this.f14927y.add(fd.b.f19650d.b(r24[r11]));
    L18:
        r11 = r26;
        goto L13
    L17:
        this.f14927y.add(fd.b.f19650d.a(r24[r11]));
        goto L18
    L20:
        if (this.B == true) goto L22;
    L25:
        invalidate();
        return;
    L22:
        if (this.E != this.C) goto L24;
        this.f14927y.add(r21, fd.b.f19650d.d());
        goto L25
    L24:
        this.f14927y.add(fd.b.f19650d.d());
        goto L25
    L11:
        r21 = 0;
        goto L12
    }

    public final void G() {
        View r10 = findViewById(R$id.quickbar_left_letters_bar);
        if (r10 == null) goto L7;
        LettersBar r11 = (LettersBar) r10;
        this.f14900d = r11;
        q.d(r11);
        r11.setLetters(this.f14927y);
        LettersBar r12 = this.f14900d;
        q.d(r12);
        r12.setListener(new e(this));
        LettersBar r13 = this.f14900d;
        q.d(r13);
        r13.setOnBackgroundVisibleChangedListener(new f(this));
        F();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.indexscrollbar.LettersBar");
    }

    public final boolean H() {
        if (this.f14925w == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f14919q == this.f14916n) goto L8;
        return false;
    }

    public final int I(int r10) {
        return View.MeasureSpec.getSize(r10);
    }

    public final void J() {
        setState(this.f14916n);
        setX(this.f14908h);
        setLettersBarBg(false);
    }

    public final void K() {
        setX(this.f14910i);
        setState(this.f14918p);
        setLettersBarBg(true);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void L(View r20, int r21) {
        if (this.f14924v == null) goto L143;
        fd.a r10 = fd.a.f19644a;
        String r11 = Locale.getDefault().getLanguage();
        q.f(r11, "getDefault().language");
        a r12 = this.f14906g;
        q.d(r12);
        if (r10.h(r11, r12.a(r21)) == true) goto L7;
        return;
    L7:
        SurnameListener r13 = this.f14924v;
        q.d(r13);
        a r14 = this.f14906g;
        q.d(r14);
        List<String> r15 = r13.getMatchedSurnames(r14.a(r21));
        if (r15 != null) goto L10;
        return;
    L10:
        if (r15.size() == 0) goto L148;
        ViewGroup r16 = null;
        View r17 = LayoutInflater.from(this.f14898c).inflate(R$layout.o_surname_flow_popup, null);
        q.f(r17, "from(mContext).inflate(R…surname_flow_popup, null)");
        View r18 = r17.findViewById(R$id.surname_content);
        if (r18 == null) goto L140;
        this.H = (SurnameFlowLayout) r18;
        this.M = v(7.0d);
        this.N = v((this.f14893J * 33) + 19);
        this.K = v(40.0d);
        this.L = v(33.0d);
        this.S = this.I;
        int r19 = v(98.0d);
        Drawable r22 = getResources().getDrawable(R$drawable.surname_popup_item_left);
        int r23 = this.S * this.K;
        Iterator<String> r24 = r15.iterator();
        int r110 = 1;
        int r111 = 0;
        int r112 = 0;
    L16:
        if (r24.hasNext() == false) goto L44;
        String r113 = r24.next();
        View r25 = LayoutInflater.from(this.f14898c).inflate(R$layout.o_surname_popup_item_ex, r16);
        if (r25 == null) goto L43;
        final TextView r26 = (TextView) r25;
        r26.setText(r113);
        ViewGroup.MarginLayoutParams r114 = new ViewGroup.MarginLayoutParams(-2, -2);
        r114.height = this.L;
        r26.setLayoutParams(r114);
        Drawable r115 = r22;
        r26.setPadding(v(10.0d), 0, v(10.0d), 0);
        if (r15.size() != 1) goto L22;
        r26.setBackgroundResource(R$drawable.surname_popup_item_special);
    L23:
        int r27 = (int) Math.ceil(r26.getPaint().measureText(r113));
        if (r115 == null) goto L30;
        int r116 = r115.getIntrinsicWidth();
        if (r116 <= 0) goto L30;
        int r117 = r110;
        double r118 = 20.0d;
        if (r116 <= (r27 + v(20.0d))) goto L31;
        r27 = r116 - v(20.0d);
    L31:
        if (r27 <= r19) goto L33;
        r27 = r19;
    L33:
        int r28 = r27 + v(r118);
        if ((r112 + r28) <= r23) goto L36;
        r110 = r117 + 1;
        r112 = 0;
    L37:
        r112 = r112 + r28;
        if (r111 > r112) goto L41;
        r111 = r112;
    L41:
        r26.setOnClickListener(new j(this));
        r26.setOnTouchListener(new k(this, r26));
        SurnameFlowLayout r29 = this.H;
        q.d(r29);
        r29.addView(r26);
        r22 = r115;
        r16 = null;
        goto L16
    L36:
        r110 = r117;
    L30:
        r117 = r110;
        r118 = 20.0d;
        goto L31
    L22:
        r26.setBackgroundResource(R$drawable.surname_popup_item_left);
        goto L23
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L44:
        this.R = r110;
        SurnameFlowLayout r30 = this.H;
        q.d(r30);
        r30.measure(0, 0);
        if (this.f14896b == false) goto L47;
        Log.d(this.f14894a, q.p("surname FlowLayout, width = ", Integer.valueOf(r111)));
        String r31 = this.f14894a;
        SurnameFlowLayout r32 = this.H;
        q.d(r32);
        Log.d(r31, q.p("surname FlowLayout, measuredHeight = ", Integer.valueOf(r32.getMeasuredHeight())));
    L47:
        SurnameFlowLayout r33 = this.H;
        q.d(r33);
        ViewGroup.LayoutParams r34 = r33.getLayoutParams();
        if (r34 == null) goto L138;
        FrameLayout.LayoutParams r35 = (FrameLayout.LayoutParams) r34;
        r35.width = r111;
        SurnameFlowLayout r36 = this.H;
        q.d(r36);
        r36.setLayoutParams(r35);
        if (this.F != null) goto L52;
        PopupWindow r37 = new PopupWindow();
        this.F = r37;
        q.d(r37);
        r37.setWindowLayoutMode(-2, -2);
        PopupWindow r38 = this.F;
        q.d(r38);
        r38.setBackgroundDrawable(getResources().getDrawable(R$color.Transparent));
        PopupWindow r39 = this.F;
        q.d(r39);
        r39.setClippingEnabled(true);
    L52:
        PopupWindow r40 = this.F;
        q.d(r40);
        r40.setContentView(r17);
        getLocationOnScreen(new int[2]);
        getLocationInWindow(new int[2]);
        int[] r41 = new int[2];
        r20.getLocationOnScreen(r41);
        int r42 = r41[0] + (r20.getWidth() / 2);
        int r43 = r41[1] + (r20.getHeight() / 2);
        if (this.f14896b == false) goto L55;
        String r44 = this.f14894a;
        StringBuilder r45 = new StringBuilder();
        r45.append("alphabet anchorX = ");
        int r119 = 0;
        r45.append(r41[0]);
        r45.append(", anchorY = ");
        r45.append(r41[1]);
        Log.d(r44, r45.toString());
    L56:
        r17.measure(r119, r119);
        int r46 = r17.getMeasuredWidth();
        int r47 = r17.getMeasuredHeight();
        if (this.f14896b == false) goto L59;
        Log.d(this.f14894a, "popMeasureWidth = " + r46 + ", popMeasureHeight = " + r47);
    L59:
        int r48 = this.T;
        if (r21 >= r48) goto L64;
        boolean r120 = true;
        if (this.R > 1) goto L85;
    L65:
        if (r21 < r48) goto L71;
        if (r21 >= (r48 * 2)) goto L71;
        if (this.R > 3) goto L85;
    L71:
        if (r21 < (r48 * 2)) goto L77;
        if (r21 >= (r48 * 3)) goto L77;
        if (this.R > 5) goto L85;
    L77:
        if (r21 >= (r48 * 3)) goto L79;
    L83:
        r120 = false;
        goto L85
    L79:
        if (r21 >= (r48 * 4)) goto L83;
        if (this.R <= 7) goto L83;
    L85:
        if (r120 == false) goto L92;
        View r49 = r17.findViewById(R$id.surname_popup_top_arrow);
        if (r49 == null) goto L91;
        ImageView r50 = (ImageView) r49;
        int r51 = r43 + this.M;
    L95:
        r50.setVisibility(0);
        r50.measure(0, 0);
        int r52 = r50.getMeasuredWidth();
        if (this.f14896b == false) goto L98;
        Log.d(this.f14894a, q.p("arrowWidth = ", Integer.valueOf(r52)));
    L98:
        int r121 = r46 / 2;
        int r122 = (int) Math.min(getScreenWidth() - r42, r121);
        int r53 = r42 - r121;
        int r54 = (r46 - r122) - (r52 / 2);
        View r55 = r17.findViewById(R$id.surname_top_mask);
        if (r55 == null) goto L134;
        ImageView r56 = (ImageView) r55;
        ViewGroup.LayoutParams r57 = r56.getLayoutParams();
        if (r57 == null) goto L132;
        FrameLayout.LayoutParams r58 = (FrameLayout.LayoutParams) r57;
        r58.width = r111;
        View r123 = r17.findViewById(R$id.surname_bottom_mask);
        if (r123 == null) goto L130;
        ImageView r124 = (ImageView) r123;
        ViewGroup.LayoutParams r59 = r124.getLayoutParams();
        if (r59 == null) goto L128;
        FrameLayout.LayoutParams r60 = (FrameLayout.LayoutParams) r59;
        r60.width = r111;
        View r61 = r17.findViewById(R$id.surname_container);
        if (r61 == null) goto L126;
        LinearLayout r62 = (LinearLayout) r61;
        ViewGroup.LayoutParams r125 = r62.getLayoutParams();
        if (r125 == null) goto L124;
        FrameLayout.LayoutParams r126 = (FrameLayout.LayoutParams) r125;
        SurnameFlowLayout r63 = this.H;
        q.d(r63);
        int r64 = r63.getMeasuredHeight();
        int r127 = this.N;
        if (r64 <= r127) goto L113;
        r126.height = r127;
    L113:
        r62.setLayoutParams(r126);
        if (r111 != (this.S * this.K)) goto L116;
        r62.setPadding(v(14.0d), v(1.5d), v(17.0d), v(4.0d));
        r54 = r54 + getResources().getDimensionPixelSize(R$dimen.surname_arrow_offset_x);
        r58.leftMargin = v(20.0d);
        r60.leftMargin = v(20.0d);
        r58.width -= v(10.0d);
        r60.width -= v(10.0d);
    L117:
        r56.setLayoutParams(r58);
        r124.setLayoutParams(r60);
        r50.setTranslationX(r54);
        if (Math.abs(getX() - this.f14910i) <= v(1.0d)) goto L121;
        Log.d(this.f14894a, "GridView is hiding now...");
        return;
    L121:
        PopupWindow r65 = this.F;
        q.d(r65);
        r65.showAtLocation(this, 0, r53, r51);
        return;
    L116:
        r53 = r53 - 1;
        goto L117
    L124:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L126:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
    L128:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L130:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L132:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L134:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L91:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L92:
        View r66 = r17.findViewById(R$id.surname_popup_bottom_arrow);
        if (r66 == null) goto L136;
        r51 = (r43 - r47) - this.M;
        r50 = (ImageView) r66;
        goto L95
    L136:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L64:
        r120 = true;
        goto L65
    L55:
        r119 = 0;
        goto L56
    L138:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L140:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.indexscrollbar.SurnameFlowLayout");
    L148:
        return;
    L143:
        throw new IllegalArgumentException("You must implements SurnameListener");
    }

    public final void O(View r18, int r19) {
        if (this.f14924v == null) goto L115;
        fd.a r10 = fd.a.f19644a;
        String r11 = Locale.getDefault().getLanguage();
        q.f(r11, "getDefault().language");
        a r12 = this.f14906g;
        q.d(r12);
        if (r10.h(r11, r12.a(r19)) == true) goto L7;
        return;
    L7:
        SurnameListener r13 = this.f14924v;
        q.d(r13);
        a r14 = this.f14906g;
        q.d(r14);
        List<String> r15 = r13.getMatchedSurnames(r14.a(r19));
        if (r15 != null) goto L10;
        return;
    L10:
        if (r15.size() == 0) goto L116;
        c r16 = new c(this, this.f14898c, r15);
        View r17 = LayoutInflater.from(this.f14898c).inflate(R$layout.o_surname_popup, null);
        q.f(r17, "from(mContext).inflate(R…ut.o_surname_popup, null)");
        View r20 = r17.findViewById(R$id.surname_content);
        if (r20 == null) goto L112;
        this.G = (SurnameGridView) r20;
        this.M = v(7.0d);
        this.L = v(33.0d);
        this.N = v((this.f14893J * 33) + 19);
        this.O = v(16.0d);
        this.P = v(6.0d);
        this.S = this.I;
        this.K = v(40.0d);
        int r21 = r15.size();
        int r22 = this.S;
        if (r21 >= r22) goto L18;
        r22 = r15.size();
    L18:
        this.Q = r22;
        int r23 = (int) Math.ceil((((double) r15.size()) * 1.0d) / ((double) this.Q));
        this.R = r23;
        int r24 = (this.Q * this.K) + (this.P * 2);
        if (r23 <= this.f14893J) goto L21;
        int r25 = this.N;
    L22:
        int r26 = r25 + (this.O * 2);
        if (this.f14896b == false) goto L25;
        Log.d(this.f14894a, "surname GridView, width = " + r24 + ", height = " + r26);
    L25:
        SurnameGridView r27 = this.G;
        q.d(r27);
        r27.setNumColumns(this.Q);
        SurnameGridView r28 = this.G;
        q.d(r28);
        r28.setLayoutParams(new LinearLayout.LayoutParams(r24, r26));
        SurnameGridView r29 = this.G;
        q.d(r29);
        r29.setGravity(17);
        SurnameGridView r30 = this.G;
        q.d(r30);
        r30.setAdapter(r16);
        SurnameGridView r31 = this.G;
        q.d(r31);
        r31.setOnPressChangeListener(new g(this));
        SurnameGridView r32 = this.G;
        q.d(r32);
        r32.setOnItemClickListener(new l(this));
        boolean r33 = true;
        if (this.F != null) goto L28;
        PopupWindow r34 = new PopupWindow();
        this.F = r34;
        q.d(r34);
        r34.setWindowLayoutMode(-2, -2);
        PopupWindow r35 = this.F;
        q.d(r35);
        r35.setBackgroundDrawable(getResources().getDrawable(R$color.Transparent));
        PopupWindow r36 = this.F;
        q.d(r36);
        r36.setClippingEnabled(true);
    L28:
        PopupWindow r37 = this.F;
        q.d(r37);
        r37.setContentView(r17);
        getLocationOnScreen(new int[2]);
        getLocationInWindow(new int[2]);
        int[] r38 = new int[2];
        r18.getLocationOnScreen(r38);
        if (this.f14896b == false) goto L31;
        Log.d(this.f14894a, "alphabetView.getWidth = " + r18.getWidth() + ", alphabetView.getHeight = " + r18.getHeight());
    L31:
        int r110 = r38[0] + (r18.getWidth() / 2);
        int r111 = r38[1] + (r18.getHeight() / 2);
        if (this.f14896b == false) goto L34;
        Log.d(this.f14894a, "alphabet anchorX = " + r38[0] + ", anchorY = " + r38[1]);
    L34:
        r17.measure(0, 0);
        int r39 = r17.getMeasuredWidth();
        int r40 = r17.getMeasuredHeight();
        if (this.f14896b == false) goto L37;
        Log.d(this.f14894a, "popMeasureWidth = " + r39 + ", popMeasureHeight = " + r40);
    L37:
        int r41 = this.T;
        if (r19 < r41) goto L40;
    L41:
        if (r19 < r41) goto L47;
        if (r19 >= (r41 * 2)) goto L47;
        if (this.R <= 3) goto L47;
    L61:
        if (r33 == false) goto L67;
        View r42 = r17.findViewById(R$id.surname_popup_top_arrow);
        if (r42 == null) goto L66;
        ImageView r43 = (ImageView) r42;
        int r112 = r111 + this.M;
    L70:
        r43.setVisibility(0);
        r43.measure(0, 0);
        int r44 = r43.getMeasuredWidth();
        if (this.f14896b == false) goto L73;
        Log.d(this.f14894a, q.p("arrowWidth = ", Integer.valueOf(r44)));
    L73:
        int r113 = r39 / 2;
        int r45 = r110 - r113;
        int r46 = r44 / 2;
        int r47 = (r39 - ((int) Math.min(getScreenWidth() - r110, r113))) - r46;
        View r48 = r17.findViewById(R$id.surname_top_mask);
        if (r48 == null) goto L108;
        ImageView r49 = (ImageView) r48;
        ViewGroup.LayoutParams r50 = r49.getLayoutParams();
        if (r50 == null) goto L106;
        FrameLayout.LayoutParams r51 = (FrameLayout.LayoutParams) r50;
        r51.width = this.Q * this.K;
        View r114 = r17.findViewById(R$id.surname_bottom_mask);
        if (r114 == null) goto L104;
        ImageView r115 = (ImageView) r114;
        ViewGroup.LayoutParams r52 = r115.getLayoutParams();
        if (r52 == null) goto L102;
        FrameLayout.LayoutParams r53 = (FrameLayout.LayoutParams) r52;
        r53.width = this.Q * this.K;
        View r54 = r17.findViewById(R$id.surname_container);
        if (r54 == null) goto L100;
        LinearLayout r55 = (LinearLayout) r54;
        int r116 = this.Q;
        int r117 = this.S;
        if (r116 != r117) goto L89;
        int r118 = this.I;
        if (r117 != r118) goto L88;
        r55.setPadding(v(14.0d), v(1.5d), v(17.0d), v(4.0d));
        r47 = r47 + getResources().getDimensionPixelSize(R$dimen.surname_arrow_offset_x);
        FrameLayout.LayoutParams r119 = r51;
        r119.leftMargin = v(20.0d);
        r53.leftMargin = v(20.0d);
    L91:
        if (this.f14896b == false) goto L93;
        Log.d(this.f14894a, q.p("arrowTranslationX = ", Integer.valueOf(r47)));
    L93:
        r43.setTranslationX(r47);
        r49.setLayoutParams(r119);
        r115.setLayoutParams(r53);
        if (Math.abs(getX() - this.f14910i) <= v(1.0d)) goto L97;
        Log.d(this.f14894a, "GridView is hiding now...");
        return;
    L97:
        PopupWindow r56 = this.F;
        q.d(r56);
        r56.showAtLocation(this, 0, r45, r112);
        return;
    L88:
        r119 = r51;
        int r120 = ((r118 * v(40.0d)) - (this.Q * this.K)) / 2;
        r55.setPadding(v(14.0d) + r120, v(1.5d), v(17.0d) + r120, v(4.0d));
        r47 = r110 - r46;
        r119.leftMargin = v(20.0d) + r120;
        r53.leftMargin = v(20.0d) + r120;
        goto L91
    L89:
        r119 = r51;
        r45 = r45 - 1;
        goto L91
    L100:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
    L102:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L104:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L106:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L108:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L66:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L67:
        View r57 = r17.findViewById(R$id.surname_popup_bottom_arrow);
        if (r57 == null) goto L110;
        r43 = (ImageView) r57;
        r112 = (r111 - r40) - this.M;
        goto L70
    L110:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L47:
        if (r19 < (r41 * 2)) goto L53;
        if (r19 >= (r41 * 3)) goto L53;
        if (this.R > 5) goto L61;
    L53:
        if (r19 >= (r41 * 3)) goto L55;
    L59:
        r33 = false;
        goto L61
    L55:
        if (r19 >= (r41 * 4)) goto L59;
        if (this.R <= 7) goto L59;
    L40:
        if (this.R > 1) goto L61;
    L21:
        r25 = r23 * this.L;
        goto L22
    L112:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.indexscrollbar.SurnameGridView");
    L116:
        return;
    L115:
        throw new IllegalArgumentException("You must implements SurnameListener");
    }

    public final void Q() {
        QBListener r10 = this.f14923u;
        if (r10 == null) goto L5;
        q.d(r10);
        r10.onLetterGridShow();
    L5:
        AnimatorSet r11 = new AnimatorSet();
        ObjectAnimator r12 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(FixCard.FixStyle.KEY_X, new float[]{getX(), this.f14910i})});
        q.f(r12, "ofPropertyValuesHolder(this, pvhX)");
        r11.play(r12);
        r11.setDuration(200);
        r11.addListener(new h(this));
        r11.start();
    }

    public final void R(View r11) {
        if (r11 != null) goto L8;
        PopupWindow r10 = this.U;
        if (r10 == null) goto L28;
        q.d(r10);
        r10.dismiss();
        return;
    L28:
        return;
    L8:
        if (this.U != null) goto L14;
        PopupWindow r12 = new PopupWindow();
        this.U = r12;
        q.d(r12);
        r12.setWindowLayoutMode(-2, -2);
        PopupWindow r13 = this.U;
        q.d(r13);
        r13.setBackgroundDrawable(getResources().getDrawable(R$color.Transparent));
        PopupWindow r14 = this.U;
        q.d(r14);
        r14.setClippingEnabled(true);
        ViewGroup r15 = (ViewGroup) LayoutInflater.from(getContext()).inflate(R$layout.o_surname_second_popup_ex, null);
        this.f14909h0 = r15;
        q.d(r15);
        this.f14911i0 = r15.getChildAt(1);
        ViewGroup r16 = this.f14909h0;
        q.d(r16);
        View r17 = r16.getChildAt(0);
        if (r17 == null) goto L13;
        this.V = (TextView) r17;
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L14:
        PopupWindow r18 = this.U;
        q.d(r18);
        r18.setContentView(this.f14909h0);
        int[] r19 = new int[2];
        r11.getLocationOnScreen(r19);
        Log.d(this.f14894a, "original anchorViewLocation[0] = " + r19[0] + ", anchorViewLocation[1] = " + r19[1]);
        int[] r20 = new int[2];
        getRootView().getLocationOnScreen(r20);
        Log.d(this.f14894a, "rootViewLocation[0] = " + r20[0] + ", rootViewLocation[1] = " + r20[1]);
        String r21 = r11.getTag().toString();
        TextView r22 = this.V;
        q.d(r22);
        r22.setText(r21);
        TextView r23 = this.V;
        q.d(r23);
        r23.measure(0, 0);
        TextView r24 = this.V;
        q.d(r24);
        int r25 = ((int) r24.getPaint().measureText(r21)) + v(40.0d);
        int r26 = v(320.0d);
        if (r25 <= r26) goto L17;
        r25 = r26;
    L17:
        TextView r27 = this.V;
        q.d(r27);
        int r28 = r27.getMeasuredHeight();
        int r29 = r11.getWidth();
        int r30 = r11.getHeight();
        int r31 = (r19[0] - r20[0]) + (r29 / 2);
        int r32 = (r19[1] - r20[1]) + (r30 / 2);
        int r33 = r25 / 2;
        int r34 = r31 - r33;
        int r35 = (r32 - r28) - 20;
        View r36 = this.f14911i0;
        q.d(r36);
        r36.getLocationOnScreen(new int[2]);
        View r37 = this.f14911i0;
        q.d(r37);
        r37.setTranslationX(0.0f);
        if (r34 >= 0) goto L20;
        View r38 = this.f14911i0;
        q.d(r38);
        r38.setTranslationX(r34);
    L24:
        if (this.f14896b == false) goto L26;
        Log.d(this.f14894a, "x = " + r34 + ", width = " + r25 + ", anchorView.getWidth() = " + r11.getWidth());
        Log.d(this.f14894a, "y = " + r35 + ", height = " + r28 + ", anchorView.getHeight() = " + r11.getHeight());
    L26:
        PopupWindow r110 = this.U;
        q.d(r110);
        r110.showAtLocation(this, 51, r34, r35);
        return;
    L20:
        int r39 = r31 + r33;
        if (r39 <= getScreenWidth()) goto L24;
        View r40 = this.f14911i0;
        q.d(r40);
        r40.setTranslationX(r39 - getScreenWidth());
        goto L24
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        q.g(r10, "event");
        fd.a r11 = fd.a.f19644a;
        String r12 = Locale.getDefault().getLanguage();
        q.f(r12, "getDefault().language");
        if (r11.b(r12) == false) goto L5;
        getParentxPos();
        int r13 = r10.getAction();
        r10.getX();
        r10.getY();
        float r14 = r10.getRawX() - this.f14895a0;
        if (r13 == 0) goto L56;
        if (r13 == 1) goto L31;
        if (r13 == 2) goto L15;
        if (r13 == 3) goto L31;
    L69:
        if (super.dispatchTouchEvent(r10) == false) goto L72;
        return true;
    L72:
        return false;
    L15:
        if (this.f14903e0 == false) goto L17;
        onMoveInLongPressState(r10);
        goto L69
    L17:
        float r15 = this.f14922t;
        this.f14921s = r15;
        this.f14922t = r14;
        int r16 = this.f14919q;
        if (r16 != this.f14916n) goto L21;
        int r17 = (r14 > this.f14908h ? 1 : (r14 == this.f14908h ? 0 : -1));
        goto L69
    L21:
        if (r16 == this.f14917o) goto L69;
        if (r16 != this.f14918p) goto L69;
        if ((r14 - r15) <= this.f14897b0) goto L69;
        if (r15 <= this.f14910i) goto L69;
        return true;
    L31:
        if (this.f14903e0 == false) goto L45;
        String r18 = Locale.getDefault().getLanguage();
        q.f(r18, "getDefault().language");
        if (r11.k(r18) != 1) goto L40;
        if (this.f14905f0 < 0) goto L44;
        SurnameFlowLayout r19 = this.H;
        if (r19 == null) goto L44;
        q.d(r19);
        View r20 = r19.getChildAt(this.f14905f0);
        q.f(r20, "mPopupFlowLayout!!.getChildAt(mPrePosition)");
        r20.setPressed(false);
        r20.performClick();
    L44:
        this.f14905f0 = -1;
        goto L69
    L40:
        if (this.f14905f0 < 0) goto L44;
        SurnameGridView r21 = this.G;
        if (r21 == null) goto L44;
        q.d(r21);
        View r22 = r21.getChildAt(this.f14905f0);
        q.f(r22, "mPopupGridView!!.getChildAt(mPrePosition)");
        r22.setPressed(false);
        SurnameGridView r23 = this.G;
        q.d(r23);
        r23.performItemClick(r22, this.f14905f0, -1);
        goto L44
    L45:
        this.f14920r = 0.0f;
        if (getX() != this.f14908h) goto L49;
        setLettersBarBg(false);
        goto L69
    L49:
        if (this.f14919q != this.f14917o) goto L69;
        if ((this.f14922t - this.f14921s) <= 0.0f) goto L53;
    L55:
        z();
        return true;
    L53:
        if (getX() >= (getScreenWidth() + NetError.ERR_SSL_PINNED_KEY_NOT_IN_CERT_CHAIN)) goto L55;
        Q();
        return true;
    L56:
        this.f14903e0 = false;
        this.f14922t = r14;
        this.f14921s = r14;
        int r24 = this.f14919q;
        if (r24 != this.f14916n) goto L59;
        this.f14920r = 0.0f;
    L59:
        int r25 = this.f14918p;
        if (r24 != r25) goto L62;
        this.f14920r = r14 - this.f14910i;
    L62:
        if (r24 != r25) goto L69;
        PopupWindow r26 = this.F;
        if (r26 == null) goto L69;
        q.d(r26);
        if (r26.isShowing() == false) goto L69;
        PopupWindow r27 = this.F;
        q.d(r27);
        r27.dismiss();
        goto L69
    L5:
        return super.dispatchTouchEvent(r10);
    }

    @Nullable
    public final LettersBar getLetterBar() {
        return this.f14900d;
    }

    public final boolean getOIndexScrollbar_DEBUG() {
        return this.f14896b;
    }

    @NotNull
    public final String getOIndexScrollbar_TAG() {
        return this.f14894a;
    }

    public final int getPOUND_POSITION_BOTTOM() {
        return this.D;
    }

    public final int getPOUND_POSITION_TOP() {
        return this.C;
    }

    public final int getVISIBILITY_LIMIT() {
        return this.f14901d0;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        this.f14915m = I(r11);
        int r12 = View.MeasureSpec.getSize(r10);
        Object r13 = getParent();
        if (r13 == null) goto L7;
        int r14 = ((View) r13).getMeasuredWidth();
        if (r14 <= 0) goto L9;
        setHostWidth(r14);
    L9:
        if (this.f14896b == false) goto L12;
        Log.d(this.f14894a, "measure width:" + r12 + "  parentWidth:" + r14);
        return;
    L12:
        return;
    L7:
        r14 = 0;
        goto L9
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r10, int r11) {
        q.g(r10, "changedView");
        super.onVisibilityChanged(r10, r11);
        if (r11 != 8) goto L11;
        if (r10 != this) goto L12;
        PopupWindow r12 = this.F;
        if (r12 == null) goto L13;
        q.d(r12);
        if (r12.isShowing() == false) goto L14;
        PopupWindow r13 = this.F;
        q.d(r13);
        r13.dismiss();
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }

    public final void setLongPressEnabled(boolean r10) {
        this.f14907g0 = r10;
    }

    public final void setPoundPosition(int r10) {
        this.E = r10;
    }

    public final void setPoundVisibility(boolean r10) {
        this.B = r10;
    }

    public final void setQBListener(@Nullable QBListener r10) {
        this.f14923u = r10;
    }

    public final void setSurnameListener(@Nullable SurnameListener r10) {
        this.f14924v = r10;
    }

    public final int v(double r10) {
        Context r11 = this.f14898c;
        q.d(r11);
        return (int) ((r10 * ((double) r11.getResources().getDisplayMetrics().density)) + ((double) 0.5f));
    }

    public final void w() {
        PopupWindow r10 = this.F;
        if (r10 == null) goto L5;
        q.d(r10);
        r10.dismiss();
        this.F = null;
        this.G = null;
        this.H = null;
    L5:
        PopupWindow r11 = this.U;
        if (r11 == null) goto L9;
        q.d(r11);
        r11.dismiss();
        this.U = null;
        this.V = null;
        return;
    }

    public final void x() {
        y(true);
    }

    public final void y(boolean r10) {
        w();
        if (H() == true) goto L8;
        if (r10 == false) goto L6;
        z();
        return;
    L6:
        J();
        return;
    }

    public final void z() {
        w();
        AnimatorSet r10 = new AnimatorSet();
        ObjectAnimator r11 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(FixCard.FixStyle.KEY_X, new float[]{getX(), this.f14908h})});
        q.f(r11, "ofPropertyValuesHolder(this, pvhX)");
        r10.play(r11);
        r10.setDuration(200);
        r10.addListener(new d(this));
        r10.start();
    }
}
