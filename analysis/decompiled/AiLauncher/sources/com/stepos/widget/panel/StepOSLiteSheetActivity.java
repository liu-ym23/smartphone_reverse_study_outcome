package com.stepos.widget.panel;

import C0.c;
import C0.f;
import La.H;
import Y8.t;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.core.view.A;
import androidx.core.view.N;
import androidx.core.view.Y;
import androidx.core.view.a0;
import androidx.core.view.b0;
import b.AbstractC1417G;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.databinding.SteposLiteSheetActivityBinding;
import com.stepos.widget.glass.StepOSGlassImageButton;
import com.stepos.widget.panel.StepOSLiteSheetDismissGate;
import com.stepos.widget.toolbar.StepOSTitleBar;
import f.C4027a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import n9.C4946a;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b#\b'\u0018\u0000 °\u00012\u00020\u0001:\u0014±\u0001²\u0001³\u0001´\u0001µ\u0001¶\u0001·\u0001¸\u0001¹\u0001°\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u0019\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001f\u0010\u0010J\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\u001f\u0010\"J\u001f\u0010\u001f\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b\u001f\u0010%J\u001f\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b&\u0010%J!\u0010*\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\rH\u0014¢\u0006\u0004\b*\u0010+J!\u0010-\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010,\u001a\u00020\u0006H\u0007¢\u0006\u0004\b-\u0010.J\u0019\u0010/\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u0006H\u0007¢\u0006\u0004\b/\u00100J\r\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u00103\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u000101¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0004H\u0016¢\u0006\u0004\b5\u0010\u0003J\u0017\u00107\u001a\u00020\u00042\b\b\u0001\u00106\u001a\u00020\r¢\u0006\u0004\b7\u0010\u0010J\u0017\u00108\u001a\u00020\u00042\b\b\u0001\u00106\u001a\u00020\r¢\u0006\u0004\b8\u0010\u0010J\u0017\u0010:\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u000109¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u000109¢\u0006\u0004\b<\u0010;J\u0015\u0010>\u001a\u00020\u00042\u0006\u00102\u001a\u00020=¢\u0006\u0004\b>\u0010?J\u0015\u0010@\u001a\u00020\u00062\u0006\u00102\u001a\u00020=¢\u0006\u0004\b@\u0010AJ\u0015\u0010D\u001a\u00020\u00042\u0006\u0010C\u001a\u00020B¢\u0006\u0004\bD\u0010EJ\u0015\u0010F\u001a\u00020\u00062\u0006\u0010C\u001a\u00020B¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0004H\u0014¢\u0006\u0004\bH\u0010\u0003J\u0017\u0010J\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u001aH\u0014¢\u0006\u0004\bJ\u0010\u001dJ\u000f\u0010K\u001a\u00020\u0004H\u0014¢\u0006\u0004\bK\u0010\u0003R\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010PR\u0016\u0010R\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010PR\u0016\u0010S\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010PR\u0016\u0010T\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010PR\u0018\u0010V\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010Z\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010\\\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010[R\u0016\u0010]\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010PR\u0014\u0010_\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010a\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010c\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010[R\u0018\u0010e\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010h\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010iR\u0018\u0010k\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010m\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010lR$\u0010p\u001a\u0012\u0012\u0004\u0012\u00020=0nj\b\u0012\u0004\u0012\u00020=`o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR$\u0010r\u001a\u0012\u0012\u0004\u0012\u00020B0nj\b\u0012\u0004\u0012\u00020B`o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010qR*\u0010t\u001a\u00020\u00062\u0006\u0010s\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010P\u001a\u0004\bt\u0010\b\"\u0004\bu\u00100R*\u0010v\u001a\u00020\r2\u0006\u0010s\u001a\u00020\r8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010Y\u001a\u0004\bw\u0010x\"\u0004\by\u0010\u0010R*\u0010z\u001a\u00020\u00062\u0006\u0010s\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010P\u001a\u0004\bz\u0010\b\"\u0004\b{\u00100R*\u0010|\u001a\u00020\u00062\u0006\u0010s\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b|\u0010P\u001a\u0004\b|\u0010\b\"\u0004\b}\u00100R*\u0010~\u001a\u00020\u00062\u0006\u0010s\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b~\u0010P\u001a\u0004\b~\u0010\b\"\u0004\b\u007f\u00100R.\u0010\u0080\u0001\u001a\u00020\u00062\u0006\u0010s\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010P\u001a\u0005\b\u0080\u0001\u0010\b\"\u0005\b\u0081\u0001\u00100R.\u0010\u0082\u0001\u001a\u00020\u00062\u0006\u0010s\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010P\u001a\u0005\b\u0082\u0001\u0010\b\"\u0005\b\u0083\u0001\u00100R7\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00012\t\u0010s\u001a\u0005\u0018\u00010\u0084\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R7\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0084\u00012\t\u0010s\u001a\u0005\u0018\u00010\u0084\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u008b\u0001\u0010\u0086\u0001\u001a\u0006\b\u008c\u0001\u0010\u0088\u0001\"\u0006\b\u008d\u0001\u0010\u008a\u0001R5\u0010\u008e\u0001\u001a\u0004\u0018\u00010'2\b\u0010s\u001a\u0004\u0018\u00010'8\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R5\u0010\u0094\u0001\u001a\u0004\u0018\u00010'2\b\u0010s\u001a\u0004\u0018\u00010'8\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u008f\u0001\u001a\u0006\b\u0095\u0001\u0010\u0091\u0001\"\u0006\b\u0096\u0001\u0010\u0093\u0001R\u0018\u0010\u009a\u0001\u001a\u00030\u0097\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R'\u0010\u009d\u0001\u001a\u00020\r2\u0006\u0010s\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009b\u0001\u0010x\"\u0005\b\u009c\u0001\u0010\u0010R'\u0010 \u0001\u001a\u00020\r2\u0006\u0010s\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009e\u0001\u0010x\"\u0005\b\u009f\u0001\u0010\u0010R\u0013\u0010¡\u0001\u001a\u00020\u00068F¢\u0006\u0007\u001a\u0005\b¡\u0001\u0010\bR\u0013\u0010£\u0001\u001a\u00020\r8F¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010xR\u0013\u0010¥\u0001\u001a\u00020\r8F¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010xR\u0013\u0010§\u0001\u001a\u00020\r8F¢\u0006\u0007\u001a\u0005\b¦\u0001\u0010xR)\u0010ª\u0001\u001a\u00020\r2\b\b\u0001\u0010s\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¨\u0001\u0010x\"\u0005\b©\u0001\u0010\u0010R+\u0010¯\u0001\u001a\u00020d2\b\b\u0001\u0010s\u001a\u00020d8G@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001¨\u0006º\u0001"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetActivity;", "Landroidx/appcompat/app/d;", "<init>", "()V", "LY8/t;", "readGlassAppearance", "", "pinNightMode", "()Z", "readStyle", "Landroid/view/ViewGroup;", "contentParent", "()Landroid/view/ViewGroup;", "", "reason", "requestDismiss", "(I)V", VoiceWakeupReceiver.EXTRA_STATE, "requireAllowedState", "cancelPendingEnter", "finishSheet", "refreshActions", "applyGrabberVisibility", "updateConfiguration", "updateAccessibility", "updateTouchTargets", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "layoutResID", "setContentView", "Landroid/view/View;", "view", "(Landroid/view/View;)V", "Landroid/view/ViewGroup$LayoutParams;", "params", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "addContentView", "", "title", "color", "onTitleChanged", "(Ljava/lang/CharSequence;I)V", "animate", "setSheetState", "(IZ)V", DidiCardProvider.ACTION_DISMISS, "(Z)V", "Lcom/stepos/widget/panel/StepOSLiteSheetActivity$OnDismissRequestedListener;", "listener", "setOnDismissRequestedListener", "(Lcom/stepos/widget/panel/StepOSLiteSheetActivity$OnDismissRequestedListener;)V", "finish", "resource", "setStartIconResource", "setEndIconResource", "Landroid/view/View$OnClickListener;", "setOnStartIconClickListener", "(Landroid/view/View$OnClickListener;)V", "setOnEndIconClickListener", "Lcom/stepos/widget/panel/StepOSLiteSheetActivity$OnProgressChangedListener;", "addOnProgressChangedListener", "(Lcom/stepos/widget/panel/StepOSLiteSheetActivity$OnProgressChangedListener;)V", "removeOnProgressChangedListener", "(Lcom/stepos/widget/panel/StepOSLiteSheetActivity$OnProgressChangedListener;)Z", "Lcom/stepos/widget/panel/StepOSLiteSheetActivity$SheetCallback;", "callback", "registerSheetCallback", "(Lcom/stepos/widget/panel/StepOSLiteSheetActivity$SheetCallback;)V", "unregisterSheetCallback", "(Lcom/stepos/widget/panel/StepOSLiteSheetActivity$SheetCallback;)Z", UxipConstants.f30640D, "outState", "onSaveInstanceState", "onDestroy", "Lcom/stepos/widget/databinding/SteposLiteSheetActivityBinding;", "binding", "Lcom/stepos/widget/databinding/SteposLiteSheetActivityBinding;", "installing", "Z", "contentInstalled", AlipayXuiIsland.REASON_CLOSED, "initialWasSet", "restored", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "enterListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "initial", "I", "styledInitial", "Ljava/lang/Integer;", "configuredMode", "glassAppearanceSpecified", "Lcom/stepos/widget/panel/StepOSLiteSheetDismissGate;", "dismissGate", "Lcom/stepos/widget/panel/StepOSLiteSheetDismissGate;", "dismissListener", "Lcom/stepos/widget/panel/StepOSLiteSheetActivity$OnDismissRequestedListener;", "configuredPadding", "", "configuredRadius", "Ljava/lang/Float;", "Landroid/widget/ImageButton;", "startButton", "Landroid/widget/ImageButton;", "endButton", "startListener", "Landroid/view/View$OnClickListener;", "endListener", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "progressListeners", "Ljava/util/LinkedHashSet;", "callbacks", UxipConstants.f30680s, "isGlassEnabled", "setGlassEnabled", "glassAppearance", "getGlassAppearance", "()I", "setGlassAppearance", "isDraggable", "setDraggable", "isCancelable", "setCancelable", "isCanceledOnTouchOutside", "setCanceledOnTouchOutside", "isDragToDismissEnabled", "setDragToDismissEnabled", "isGrabberVisible", "setGrabberVisible", "Landroid/graphics/drawable/Drawable;", "startIcon", "Landroid/graphics/drawable/Drawable;", "getStartIcon", "()Landroid/graphics/drawable/Drawable;", "setStartIcon", "(Landroid/graphics/drawable/Drawable;)V", "endIcon", "getEndIcon", "setEndIcon", "startIconDescription", "Ljava/lang/CharSequence;", "getStartIconDescription", "()Ljava/lang/CharSequence;", "setStartIconDescription", "(Ljava/lang/CharSequence;)V", "endIconDescription", "getEndIconDescription", "setEndIconDescription", "Lcom/stepos/widget/panel/StepOSLiteSheetController;", "getController", "()Lcom/stepos/widget/panel/StepOSLiteSheetController;", "controller", "getInitialSheetState", "setInitialSheetState", "initialSheetState", "getSheetMode", "setSheetMode", "sheetMode", "isDismissPending", "getSheetState", "sheetState", "getTargetSheetState", "targetSheetState", "getMotionState", "motionState", "getContentPaddingHorizontal", "setContentPaddingHorizontal", "contentPaddingHorizontal", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "cornerRadius", "Companion", "OnProgressChangedListener", "OnDismissRequestedListener", "DismissRequest", "GlassAppearance", "SheetMode", "DismissReason", "SheetCallback", "SheetState", "MotionState", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class StepOSLiteSheetActivity extends androidx.appcompat.app.d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DISMISS_REASON_ACCESSIBILITY = 4;
    public static final int DISMISS_REASON_BACK = 2;
    public static final int DISMISS_REASON_DRAG = 1;
    public static final int DISMISS_REASON_OUTSIDE = 3;
    public static final int DISMISS_REASON_PROGRAMMATIC = 0;
    public static final String EXTRA_INITIAL_STATE = "com.stepos.widget.panel.extra.INITIAL_STATE";
    public static final int GLASS_APPEARANCE_DARK = 2;
    public static final int GLASS_APPEARANCE_FOLLOW_SYSTEM = 0;
    public static final int GLASS_APPEARANCE_LIGHT = 1;
    public static final int MODE_BOTH = 0;
    public static final int MODE_EXPANDED_ONLY = 2;
    public static final int MODE_HALF_ONLY = 1;
    public static final int MOTION_DRAGGING = 1;
    public static final int MOTION_IDLE = 0;
    public static final int MOTION_SETTLING = 2;
    private static final int OPAQUE_ALPHA = -16777216;
    private static final String SAVED_GLASS_APPEARANCE = "stepos.lite_sheet.glass_appearance";
    private static final String SAVED_MODE = "stepos.lite_sheet.mode";
    private static final String SAVED_STATE = "stepos.lite_sheet.state";
    public static final int STATE_EXPANDED = 0;
    public static final int STATE_HALF = 1;
    public static final int STATE_HIDDEN = 2;
    private SteposLiteSheetActivityBinding binding;
    private boolean closed;
    private Integer configuredMode;
    private Integer configuredPadding;
    private Float configuredRadius;
    private boolean contentInstalled;
    private OnDismissRequestedListener dismissListener;
    private ImageButton endButton;
    private Drawable endIcon;
    private CharSequence endIconDescription;
    private View.OnClickListener endListener;
    private ViewTreeObserver.OnPreDrawListener enterListener;
    private int glassAppearance;
    private boolean glassAppearanceSpecified;
    private boolean initialWasSet;
    private boolean installing;
    private boolean restored;
    private ImageButton startButton;
    private Drawable startIcon;
    private CharSequence startIconDescription;
    private View.OnClickListener startListener;
    private Integer styledInitial;
    private int initial = 1;
    private final StepOSLiteSheetDismissGate dismissGate = new StepOSLiteSheetDismissGate();
    private final LinkedHashSet<OnProgressChangedListener> progressListeners = new LinkedHashSet<>();
    private final LinkedHashSet<SheetCallback> callbacks = new LinkedHashSet<>();
    private boolean isGlassEnabled = true;
    private boolean isDraggable = true;
    private boolean isCancelable = true;
    private boolean isCanceledOnTouchOutside = true;
    private boolean isDragToDismissEnabled = true;
    private boolean isGrabberVisible = true;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\nR\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\nR\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\nR\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\nR\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\nR\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\nR\u0014\u0010\u001c\u001a\u00020\u001b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\nR\u0014\u0010\u001f\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001dR\u0014\u0010!\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001d¨\u0006\""}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetActivity$Companion;", "", "<init>", "()V", "", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "requireVisibleState", "(I)V", "GLASS_APPEARANCE_FOLLOW_SYSTEM", "I", "GLASS_APPEARANCE_LIGHT", "GLASS_APPEARANCE_DARK", "MODE_BOTH", "MODE_HALF_ONLY", "MODE_EXPANDED_ONLY", "DISMISS_REASON_PROGRAMMATIC", "DISMISS_REASON_DRAG", "DISMISS_REASON_BACK", "DISMISS_REASON_OUTSIDE", "DISMISS_REASON_ACCESSIBILITY", "STATE_EXPANDED", "STATE_HALF", "STATE_HIDDEN", "MOTION_IDLE", "MOTION_DRAGGING", "MOTION_SETTLING", "", "EXTRA_INITIAL_STATE", "Ljava/lang/String;", "OPAQUE_ALPHA", "SAVED_STATE", "SAVED_MODE", "SAVED_GLASS_APPEARANCE", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void requireVisibleState(int state) {
            if (state != 1 && state != 0) {
                throw new IllegalArgumentException("State must be STATE_HALF or STATE_EXPANDED; use dismiss() to close");
            }
        }

        private Companion() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetActivity$DismissReason;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface DismissReason {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetActivity$DismissRequest;", "", "", "reason", "Lcom/stepos/widget/panel/StepOSLiteSheetDismissGate$Decision;", "decision", "<init>", "(ILcom/stepos/widget/panel/StepOSLiteSheetDismissGate$Decision;)V", "LY8/t;", "confirm", "()V", "cancel", "I", "getReason", "()I", "Lcom/stepos/widget/panel/StepOSLiteSheetDismissGate$Decision;", "", "isPending", "()Z", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DismissRequest {
        private final StepOSLiteSheetDismissGate.Decision decision;
        private final int reason;

        public DismissRequest(int i10, StepOSLiteSheetDismissGate.Decision decision) {
            kotlin.jvm.internal.p.i(decision, "decision");
            this.reason = i10;
            this.decision = decision;
        }

        public final void cancel() {
            this.decision.resolve(false);
        }

        public final void confirm() {
            this.decision.resolve(true);
        }

        public final int getReason() {
            return this.reason;
        }

        public final boolean isPending() {
            return this.decision.isPending();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetActivity$GlassAppearance;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface GlassAppearance {
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetActivity$MotionState;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface MotionState {
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetActivity$OnDismissRequestedListener;", "", "Lcom/stepos/widget/panel/StepOSLiteSheetActivity;", ChatTracker.CONTENT_SHEET, "Lcom/stepos/widget/panel/StepOSLiteSheetActivity$DismissRequest;", "request", "LY8/t;", "onDismissRequested", "(Lcom/stepos/widget/panel/StepOSLiteSheetActivity;Lcom/stepos/widget/panel/StepOSLiteSheetActivity$DismissRequest;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnDismissRequestedListener {
        void onDismissRequested(StepOSLiteSheetActivity sheet, DismissRequest request);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetActivity$OnProgressChangedListener;", "", "Lcom/stepos/widget/panel/StepOSLiteSheetActivity;", ChatTracker.CONTENT_SHEET, "", "progress", "LY8/t;", "onProgressChanged", "(Lcom/stepos/widget/panel/StepOSLiteSheetActivity;F)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnProgressChangedListener {
        void onProgressChanged(StepOSLiteSheetActivity sheet, float progress);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\nJ!\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetActivity$SheetCallback;", "", "<init>", "()V", "Lcom/stepos/widget/panel/StepOSLiteSheetActivity;", ChatTracker.CONTENT_SHEET, "", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "onStateChanged", "(Lcom/stepos/widget/panel/StepOSLiteSheetActivity;I)V", "motion", "onMotionStateChanged", "", "progress", "onDismissProgress", "(Lcom/stepos/widget/panel/StepOSLiteSheetActivity;F)V", "onDismissed", "(Lcom/stepos/widget/panel/StepOSLiteSheetActivity;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class SheetCallback {
        public void onDismissProgress(StepOSLiteSheetActivity sheet, float progress) {
            kotlin.jvm.internal.p.i(sheet, "sheet");
        }

        public void onDismissed(StepOSLiteSheetActivity sheet) {
            kotlin.jvm.internal.p.i(sheet, "sheet");
        }

        public void onMotionStateChanged(StepOSLiteSheetActivity sheet, int motion) {
            kotlin.jvm.internal.p.i(sheet, "sheet");
        }

        public void onStateChanged(StepOSLiteSheetActivity sheet, int state) {
            kotlin.jvm.internal.p.i(sheet, "sheet");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetActivity$SheetMode;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface SheetMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetActivity$SheetState;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface SheetState {
    }

    private final void applyGrabberVisibility() {
        FrameLayout frameLayout;
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        if (steposLiteSheetActivityBinding == null || (frameLayout = steposLiteSheetActivityBinding.steposLiteSheetGrabber) == null) {
            return;
        }
        frameLayout.setVisibility(this.isGrabberVisible ? 0 : 8);
    }

    private final void cancelPendingEnter() {
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding;
        StepOSLiteSheetLayout root;
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.enterListener;
        if (onPreDrawListener != null && (steposLiteSheetActivityBinding = this.binding) != null && (root = steposLiteSheetActivityBinding.getRoot()) != null && (viewTreeObserver = root.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
        }
        this.enterListener = null;
    }

    private final ViewGroup contentParent() {
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        if (steposLiteSheetActivityBinding == null) {
            throw new IllegalStateException("Call super.onCreate before setContentView");
        }
        FrameLayout steposLiteSheetContent = steposLiteSheetActivityBinding.steposLiteSheetContent;
        kotlin.jvm.internal.p.h(steposLiteSheetContent, "steposLiteSheetContent");
        return steposLiteSheetContent;
    }

    public static /* synthetic */ void dismiss$default(StepOSLiteSheetActivity stepOSLiteSheetActivity, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dismiss");
        }
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        stepOSLiteSheetActivity.dismiss(z10);
    }

    private final void finishSheet() {
        StepOSLiteSheetSurface stepOSLiteSheetSurface;
        if (this.closed) {
            return;
        }
        this.closed = true;
        Iterator it = F.m1(this.callbacks).iterator();
        while (it.hasNext()) {
            ((SheetCallback) it.next()).onDismissed(this);
        }
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        if (steposLiteSheetActivityBinding != null && (stepOSLiteSheetSurface = steposLiteSheetActivityBinding.steposLiteSheetSurface) != null) {
            stepOSLiteSheetSurface.release();
        }
        super.finish();
        overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StepOSLiteSheetController getController() {
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        if (steposLiteSheetActivityBinding != null) {
            return steposLiteSheetActivityBinding.getRoot().getController();
        }
        throw new IllegalStateException("Call super.onCreate before using sheet state APIs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t onCreate$lambda$13(SteposLiteSheetActivityBinding steposLiteSheetActivityBinding, StepOSLiteSheetActivity stepOSLiteSheetActivity, float f10) {
        steposLiteSheetActivityBinding.getRoot().updatePosition();
        float fM = 1.0f - C5685n.m(stepOSLiteSheetActivity.getController().getVisualPosition(), 0.0f, 1.0f);
        Iterator it = F.m1(stepOSLiteSheetActivity.progressListeners).iterator();
        while (it.hasNext()) {
            ((OnProgressChangedListener) it.next()).onProgressChanged(stepOSLiteSheetActivity, fM);
        }
        Iterator it2 = F.m1(stepOSLiteSheetActivity.callbacks).iterator();
        while (it2.hasNext()) {
            ((SheetCallback) it2.next()).onDismissProgress(stepOSLiteSheetActivity, stepOSLiteSheetActivity.getController().getDismissProgress());
        }
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t onCreate$lambda$15(StepOSLiteSheetActivity stepOSLiteSheetActivity, int i10) {
        Iterator it = F.m1(stepOSLiteSheetActivity.callbacks).iterator();
        while (it.hasNext()) {
            ((SheetCallback) it.next()).onMotionStateChanged(stepOSLiteSheetActivity, i10);
        }
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t onCreate$lambda$17(StepOSLiteSheetActivity stepOSLiteSheetActivity, int i10) {
        stepOSLiteSheetActivity.updateAccessibility();
        Iterator it = F.m1(stepOSLiteSheetActivity.callbacks).iterator();
        while (it.hasNext()) {
            ((SheetCallback) it.next()).onStateChanged(stepOSLiteSheetActivity, i10);
        }
        if (i10 == 2) {
            stepOSLiteSheetActivity.finishSheet();
        }
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t onCreate$lambda$18(StepOSLiteSheetActivity stepOSLiteSheetActivity) {
        stepOSLiteSheetActivity.requestDismiss(1);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$19(StepOSLiteSheetActivity stepOSLiteSheetActivity, View view) {
        if (stepOSLiteSheetActivity.isCancelable && stepOSLiteSheetActivity.isCanceledOnTouchOutside) {
            stepOSLiteSheetActivity.requestDismiss(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 onCreate$lambda$22(SteposLiteSheetActivityBinding steposLiteSheetActivityBinding, View view, a0 insets) {
        kotlin.jvm.internal.p.i(view, "<unused var>");
        kotlin.jvm.internal.p.i(insets, "insets");
        t0.e eVarF = insets.f(a0.o.g() | a0.o.a());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        t0.e eVarF2 = insets.f(a0.o.b());
        kotlin.jvm.internal.p.h(eVarF2, "getInsets(...)");
        StepOSLiteSheetLayout root = steposLiteSheetActivityBinding.getRoot();
        root.setSafeTop(eVarF.f41978b);
        root.setSafeStart(eVarF.f41977a);
        root.setSafeEnd(eVarF.f41979c);
        root.setNavigationBottom(eVarF.f41980d);
        root.setImeBottom(insets.r(a0.o.b()) ? eVarF2.f41980d : 0);
        root.requestLayout();
        return insets;
    }

    private final boolean pinNightMode() {
        int i10;
        int i11 = this.glassAppearance;
        if (i11 != 1) {
            i10 = 2;
            if (i11 != 2) {
                return false;
            }
        } else {
            i10 = 1;
        }
        if (getDelegate().q() == i10) {
            return false;
        }
        getDelegate().N(i10);
        return true;
    }

    private final void readGlassAppearance() throws Exception {
        TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes(null, R.styleable.StepOSLiteSheetActivity, R.attr.steposLiteSheetStyle, R.style.StepOSWidget_LiteSheet);
        try {
            int i10 = R.styleable.StepOSLiteSheetActivity_steposLiteSheetGlassAppearance;
            if (!typedArrayObtainStyledAttributes.hasValue(i10)) {
                C4946a.a(typedArrayObtainStyledAttributes, null);
                return;
            }
            setGlassAppearance(typedArrayObtainStyledAttributes.getInt(i10, 0));
            t tVar = t.f7040a;
            C4946a.a(typedArrayObtainStyledAttributes, null);
        } finally {
        }
    }

    private final void readStyle() throws Exception {
        TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes(null, R.styleable.StepOSLiteSheetActivity, R.attr.steposLiteSheetStyle, R.style.StepOSWidget_LiteSheet);
        try {
            if (this.configuredMode == null) {
                this.configuredMode = Integer.valueOf(typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSLiteSheetActivity_steposLiteSheetMode, 0));
            }
            if (!this.initialWasSet) {
                int i10 = R.styleable.StepOSLiteSheetActivity_steposLiteSheetInitialState;
                if (typedArrayObtainStyledAttributes.hasValue(i10)) {
                    this.styledInitial = Integer.valueOf(typedArrayObtainStyledAttributes.getInt(i10, 1));
                }
            }
            CharSequence text = typedArrayObtainStyledAttributes.getText(R.styleable.StepOSLiteSheetActivity_steposLiteSheetTitle);
            if (text != null) {
                setTitle(text);
            }
            if (this.configuredPadding == null) {
                setContentPaddingHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSLiteSheetActivity_steposLiteSheetContentPaddingHorizontal, getContentPaddingHorizontal()));
            }
            if (this.configuredRadius == null) {
                setCornerRadius(typedArrayObtainStyledAttributes.getDimension(R.styleable.StepOSLiteSheetActivity_steposLiteSheetCornerRadius, getCornerRadius()));
            }
            setGlassEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSLiteSheetActivity_steposLiteSheetGlassEnabled, true));
            setDraggable(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSLiteSheetActivity_steposLiteSheetDraggable, true));
            setCancelable(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSLiteSheetActivity_steposLiteSheetCancelable, true));
            setCanceledOnTouchOutside(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSLiteSheetActivity_steposLiteSheetCanceledOnTouchOutside, true));
            setDragToDismissEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSLiteSheetActivity_steposLiteSheetDragToDismissEnabled, true));
            setGrabberVisible(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSLiteSheetActivity_steposLiteSheetGrabberVisible, true));
            setStartIconDescription(typedArrayObtainStyledAttributes.getText(R.styleable.StepOSLiteSheetActivity_steposLiteSheetStartIconDescription));
            setEndIconDescription(typedArrayObtainStyledAttributes.getText(R.styleable.StepOSLiteSheetActivity_steposLiteSheetEndIconDescription));
            setStartIcon(typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepOSLiteSheetActivity_steposLiteSheetStartIcon));
            setEndIcon(typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepOSLiteSheetActivity_steposLiteSheetEndIcon));
            t tVar = t.f7040a;
            C4946a.a(typedArrayObtainStyledAttributes, null);
        } finally {
        }
    }

    private final void refreshActions() {
        StepOSTitleBar stepOSTitleBar;
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        if (steposLiteSheetActivityBinding == null || (stepOSTitleBar = steposLiteSheetActivityBinding.steposLiteSheetTitleBar) == null) {
            return;
        }
        stepOSTitleBar.clearActions(0);
        stepOSTitleBar.clearActions(1);
        Drawable drawable = this.startIcon;
        this.startButton = drawable != null ? stepOSTitleBar.addStartAction(drawable, this.startIconDescription, new View.OnClickListener() { // from class: com.stepos.widget.panel.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepOSLiteSheetActivity.refreshActions$lambda$38$lambda$37(this.f31280a, view);
            }
        }) : null;
        Drawable drawable2 = this.endIcon;
        ImageButton imageButtonAddEndAction = drawable2 != null ? stepOSTitleBar.addEndAction(drawable2, this.endIconDescription, new View.OnClickListener() { // from class: com.stepos.widget.panel.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepOSLiteSheetActivity.refreshActions$lambda$40$lambda$39(this.f31284a, view);
            }
        }) : null;
        this.endButton = imageButtonAddEndAction;
        StepOSGlassImageButton stepOSGlassImageButton = imageButtonAddEndAction instanceof StepOSGlassImageButton ? (StepOSGlassImageButton) imageButtonAddEndAction : null;
        if (stepOSGlassImageButton != null) {
            stepOSGlassImageButton.setGlassEnabled(false);
            stepOSGlassImageButton.setSurfaceDrawable(C4027a.b(stepOSGlassImageButton.getContext(), R.drawable.stepos_lite_sheet_end_action));
            stepOSGlassImageButton.setImageTintList(ColorStateList.valueOf(getColor(R.color.stepos_lite_sheet_end_action_icon)));
        }
        stepOSTitleBar.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshActions$lambda$38$lambda$37(StepOSLiteSheetActivity stepOSLiteSheetActivity, View view) {
        View.OnClickListener onClickListener = stepOSLiteSheetActivity.startListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshActions$lambda$40$lambda$39(StepOSLiteSheetActivity stepOSLiteSheetActivity, View view) {
        View.OnClickListener onClickListener = stepOSLiteSheetActivity.endListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t requestDismiss$lambda$33(StepOSLiteSheetActivity stepOSLiteSheetActivity, boolean z10) {
        stepOSLiteSheetActivity.updateConfiguration();
        if (z10) {
            dismiss$default(stepOSLiteSheetActivity, false, 1, null);
        }
        return t.f7040a;
    }

    private final void requireAllowedState(int state) {
        if (!StepOSLiteSheetStatePolicy.INSTANCE.allows(getSheetMode(), state)) {
            throw new IllegalArgumentException("State conflicts with sheetMode");
        }
    }

    public static /* synthetic */ void setSheetState$default(StepOSLiteSheetActivity stepOSLiteSheetActivity, int i10, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSheetState");
        }
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        stepOSLiteSheetActivity.setSheetState(i10, z10);
    }

    private final void updateAccessibility() {
        StepOSLiteSheetSurface stepOSLiteSheetSurface;
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        if (steposLiteSheetActivityBinding == null || (stepOSLiteSheetSurface = steposLiteSheetActivityBinding.steposLiteSheetSurface) == null) {
            return;
        }
        N.k0(stepOSLiteSheetSurface, getTitle());
        N.A0(stepOSLiteSheetSurface, getString(getSheetState() == 0 ? R.string.stepos_lite_sheet_expanded : R.string.stepos_lite_sheet_half));
        c.a aVar = c.a.f1668w;
        N.b0(stepOSLiteSheetSurface, aVar.b());
        c.a aVar2 = c.a.f1669x;
        N.b0(stepOSLiteSheetSurface, aVar2.b());
        c.a aVar3 = c.a.f1670y;
        N.b0(stepOSLiteSheetSurface, aVar3.b());
        if (this.isDraggable && getSheetMode() == 0 && !this.dismissGate.isPending() && getTargetSheetState() != 2) {
            final boolean z10 = getSheetState() == 0;
            if (z10) {
                aVar = aVar2;
            }
            N.d0(stepOSLiteSheetSurface, aVar, getString(z10 ? R.string.stepos_lite_sheet_collapse : R.string.stepos_lite_sheet_expand), new C0.f() { // from class: com.stepos.widget.panel.b
                @Override // C0.f
                public final boolean a(View view, f.a aVar4) {
                    return StepOSLiteSheetActivity.updateAccessibility$lambda$43(this.f31281a, z10, view, aVar4);
                }
            });
        }
        if (!this.isCancelable || this.dismissGate.isPending() || getTargetSheetState() == 2) {
            return;
        }
        N.d0(stepOSLiteSheetSurface, aVar3, getString(R.string.stepos_lite_sheet_dismiss), new C0.f() { // from class: com.stepos.widget.panel.c
            @Override // C0.f
            public final boolean a(View view, f.a aVar4) {
                return StepOSLiteSheetActivity.updateAccessibility$lambda$44(this.f31283a, view, aVar4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateAccessibility$lambda$43(StepOSLiteSheetActivity stepOSLiteSheetActivity, boolean z10, View view, f.a aVar) {
        kotlin.jvm.internal.p.i(view, "<unused var>");
        setSheetState$default(stepOSLiteSheetActivity, z10 ? 1 : 0, false, 2, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateAccessibility$lambda$44(StepOSLiteSheetActivity stepOSLiteSheetActivity, View view, f.a aVar) {
        kotlin.jvm.internal.p.i(view, "<unused var>");
        stepOSLiteSheetActivity.requestDismiss(4);
        return true;
    }

    private final void updateConfiguration() {
        StepOSLiteSheetLayout root;
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        if (steposLiteSheetActivityBinding != null && (root = steposLiteSheetActivityBinding.getRoot()) != null) {
            boolean z10 = false;
            root.setDraggable(this.isDraggable && !this.dismissGate.isPending());
            if (this.isCancelable && this.isDragToDismissEnabled) {
                z10 = true;
            }
            root.setCanDismiss(z10);
            root.setCornerRadius(getCornerRadius());
            root.setGlassEnabled(this.isGlassEnabled);
            root.setGlassAppearance(this.glassAppearance);
            root.updatePosition();
        }
        updateAccessibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTouchTargets() throws Resources.NotFoundException {
        StepOSTitleBar stepOSTitleBar;
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        if (steposLiteSheetActivityBinding == null || (stepOSTitleBar = steposLiteSheetActivityBinding.steposLiteSheetTitleBar) == null) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_size_touch_target_min);
        List<ImageButton> listR = C1173v.r(this.startButton, this.endButton);
        final ArrayList arrayList = new ArrayList(C1174w.x(listR, 10));
        for (ImageButton imageButton : listR) {
            Rect rect = new Rect(0, 0, imageButton.getWidth(), imageButton.getHeight());
            stepOSTitleBar.offsetDescendantRectToMyCoords(imageButton, rect);
            rect.inset((-(C5685n.f(dimensionPixelSize - rect.width(), 0) + 1)) / 2, (-(C5685n.f(dimensionPixelSize - rect.height(), 0) + 1)) / 2);
            arrayList.add(new TouchDelegate(rect, imageButton));
        }
        stepOSTitleBar.setTouchDelegate(new TouchDelegate(stepOSTitleBar, new Rect()) { // from class: com.stepos.widget.panel.StepOSLiteSheetActivity.updateTouchTargets.1
            @Override // android.view.TouchDelegate
            public boolean onTouchEvent(MotionEvent event) {
                kotlin.jvm.internal.p.i(event, "event");
                for (TouchDelegate touchDelegate : arrayList) {
                    MotionEvent motionEventObtain = MotionEvent.obtain(event);
                    boolean zOnTouchEvent = touchDelegate.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    if (zOnTouchEvent) {
                        return true;
                    }
                }
                return false;
            }
        });
    }

    @Override // androidx.appcompat.app.d, b.q, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(params, "params");
        if (this.installing) {
            super.addContentView(view, params);
        } else {
            if (view.getParent() != null) {
                throw new IllegalArgumentException("Business content must not already have a parent");
            }
            contentParent().addView(view, params);
            this.contentInstalled = true;
            onContentChanged();
        }
    }

    public final void addOnProgressChangedListener(OnProgressChangedListener listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.progressListeners.add(listener);
    }

    public final void dismiss() {
        dismiss$default(this, false, 1, null);
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.binding == null) {
            super.finish();
        } else {
            dismiss$default(this, false, 1, null);
        }
    }

    public final int getContentPaddingHorizontal() {
        Integer num = this.configuredPadding;
        return num != null ? num.intValue() : getResources().getDimensionPixelSize(R.dimen.stepos_lite_sheet_content_padding_horizontal);
    }

    public final float getCornerRadius() {
        Float f10 = this.configuredRadius;
        return f10 != null ? f10.floatValue() : getResources().getDimension(R.dimen.stepos_lite_sheet_corner_radius);
    }

    public final Drawable getEndIcon() {
        return this.endIcon;
    }

    public final CharSequence getEndIconDescription() {
        return this.endIconDescription;
    }

    public final int getGlassAppearance() {
        return this.glassAppearance;
    }

    /* renamed from: getInitialSheetState, reason: from getter */
    public final int getInitial() {
        return this.initial;
    }

    public final int getMotionState() {
        StepOSLiteSheetLayout root;
        StepOSLiteSheetController controller;
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        if (steposLiteSheetActivityBinding == null || (root = steposLiteSheetActivityBinding.getRoot()) == null || (controller = root.getController()) == null) {
            return 0;
        }
        return controller.getMotion();
    }

    public final int getSheetMode() {
        Integer num = this.configuredMode;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final int getSheetState() {
        StepOSLiteSheetLayout root;
        StepOSLiteSheetController controller;
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        return (steposLiteSheetActivityBinding == null || (root = steposLiteSheetActivityBinding.getRoot()) == null || (controller = root.getController()) == null) ? this.initial : controller.getState();
    }

    public final Drawable getStartIcon() {
        return this.startIcon;
    }

    public final CharSequence getStartIconDescription() {
        return this.startIconDescription;
    }

    public final int getTargetSheetState() {
        StepOSLiteSheetLayout root;
        StepOSLiteSheetController controller;
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        return (steposLiteSheetActivityBinding == null || (root = steposLiteSheetActivityBinding.getRoot()) == null || (controller = root.getController()) == null) ? this.initial : controller.getTarget();
    }

    /* renamed from: isCancelable, reason: from getter */
    public final boolean getIsCancelable() {
        return this.isCancelable;
    }

    /* renamed from: isCanceledOnTouchOutside, reason: from getter */
    public final boolean getIsCanceledOnTouchOutside() {
        return this.isCanceledOnTouchOutside;
    }

    public final boolean isDismissPending() {
        return this.dismissGate.isPending();
    }

    /* renamed from: isDragToDismissEnabled, reason: from getter */
    public final boolean getIsDragToDismissEnabled() {
        return this.isDragToDismissEnabled;
    }

    /* renamed from: isDraggable, reason: from getter */
    public final boolean getIsDraggable() {
        return this.isDraggable;
    }

    /* renamed from: isGlassEnabled, reason: from getter */
    public final boolean getIsGlassEnabled() {
        return this.isGlassEnabled;
    }

    /* renamed from: isGrabberVisible, reason: from getter */
    public final boolean getIsGrabberVisible() {
        return this.isGrabberVisible;
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) throws Exception {
        Integer numValueOf;
        if (!this.glassAppearanceSpecified && savedInstanceState != null && savedInstanceState.containsKey(SAVED_GLASS_APPEARANCE)) {
            setGlassAppearance(savedInstanceState.getInt(SAVED_GLASS_APPEARANCE));
        }
        if (!this.glassAppearanceSpecified) {
            readGlassAppearance();
        }
        pinNightMode();
        super.onCreate(savedInstanceState);
        Y.b(getWindow(), false);
        boolean z10 = getResources().getBoolean(R.bool.stepos_lite_sheet_light_system_bars);
        b0 b0VarA = Y.a(getWindow(), getWindow().getDecorView());
        b0VarA.e(z10);
        b0VarA.d(z10);
        readStyle();
        this.restored = savedInstanceState != null && savedInstanceState.containsKey(SAVED_STATE);
        if (savedInstanceState != null && savedInstanceState.containsKey(SAVED_MODE)) {
            this.configuredMode = Integer.valueOf(savedInstanceState.getInt(SAVED_MODE));
        }
        if (savedInstanceState != null) {
            numValueOf = Integer.valueOf(savedInstanceState.getInt(SAVED_STATE));
        } else if (this.initialWasSet) {
            numValueOf = Integer.valueOf(this.initial);
        } else {
            Intent intent = getIntent();
            numValueOf = (intent == null || !intent.hasExtra(EXTRA_INITIAL_STATE)) ? this.styledInitial : Integer.valueOf(getIntent().getIntExtra(EXTRA_INITIAL_STATE, this.initial));
        }
        int iInitialState = StepOSLiteSheetStatePolicy.INSTANCE.initialState(getSheetMode(), numValueOf);
        this.initial = iInitialState;
        final SteposLiteSheetActivityBinding steposLiteSheetActivityBindingInflate = SteposLiteSheetActivityBinding.inflate(getLayoutInflater());
        kotlin.jvm.internal.p.h(steposLiteSheetActivityBindingInflate, "inflate(...)");
        this.binding = steposLiteSheetActivityBindingInflate;
        steposLiteSheetActivityBindingInflate.steposLiteSheetTitleBar.setBackdropBlurEnabled(false);
        steposLiteSheetActivityBindingInflate.steposLiteSheetTitleBar.setTitleCentered(true);
        steposLiteSheetActivityBindingInflate.steposLiteSheetTitleBar.setTitle(getTitle());
        steposLiteSheetActivityBindingInflate.steposLiteSheetTitleBar.setTitleTextColor(getColor(R.color.stepos_lite_sheet_title) | OPAQUE_ALPHA);
        this.installing = true;
        try {
            super.setContentView(steposLiteSheetActivityBindingInflate.getRoot());
            this.installing = false;
            getController().setOnPosition(new InterfaceC5074l() { // from class: com.stepos.widget.panel.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return StepOSLiteSheetActivity.onCreate$lambda$13(steposLiteSheetActivityBindingInflate, this, ((Float) obj).floatValue());
                }
            });
            getController().setOnMotion(new InterfaceC5074l() { // from class: com.stepos.widget.panel.f
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return StepOSLiteSheetActivity.onCreate$lambda$15(this.f31287a, ((Integer) obj).intValue());
                }
            });
            getController().setOnSettled(new InterfaceC5074l() { // from class: com.stepos.widget.panel.g
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return StepOSLiteSheetActivity.onCreate$lambda$17(this.f31288a, ((Integer) obj).intValue());
                }
            });
            getController().setMode(getSheetMode());
            getController().setOnDismissRequested(new InterfaceC5063a() { // from class: com.stepos.widget.panel.h
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return StepOSLiteSheetActivity.onCreate$lambda$18(this.f31289a);
                }
            });
            getController().restore(iInitialState);
            if (!this.restored) {
                ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.stepos.widget.panel.StepOSLiteSheetActivity$onCreate$listener$1
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        steposLiteSheetActivityBindingInflate.getRoot().getViewTreeObserver().removeOnPreDrawListener(this);
                        this.enterListener = null;
                        if (this.getController().getTarget() == 2) {
                            return false;
                        }
                        this.getController().enter();
                        return false;
                    }
                };
                this.enterListener = onPreDrawListener;
                steposLiteSheetActivityBindingInflate.getRoot().getViewTreeObserver().addOnPreDrawListener(onPreDrawListener);
            }
            setContentPaddingHorizontal(getContentPaddingHorizontal());
            refreshActions();
            applyGrabberVisibility();
            updateConfiguration();
            steposLiteSheetActivityBindingInflate.steposLiteSheetScrim.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.panel.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StepOSLiteSheetActivity.onCreate$lambda$19(this.f31290a, view);
                }
            });
            steposLiteSheetActivityBindingInflate.steposLiteSheetTitleBar.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.widget.panel.j
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) throws Resources.NotFoundException {
                    this.f31291a.updateTouchTargets();
                }
            });
            N.u0(steposLiteSheetActivityBindingInflate.getRoot(), new A() { // from class: com.stepos.widget.panel.k
                @Override // androidx.core.view.A
                public final a0 a(View view, a0 a0Var) {
                    return StepOSLiteSheetActivity.onCreate$lambda$22(steposLiteSheetActivityBindingInflate, view, a0Var);
                }
            });
            N.e0(steposLiteSheetActivityBindingInflate.getRoot());
            getOnBackPressedDispatcher().m(this, new AbstractC1417G() { // from class: com.stepos.widget.panel.StepOSLiteSheetActivity.onCreate.9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(true);
                }

                @Override // b.AbstractC1417G
                public void handleOnBackPressed() {
                    a0 a0VarB = N.B(steposLiteSheetActivityBindingInflate.getRoot());
                    if (a0VarB != null && a0VarB.r(a0.o.b())) {
                        Y.a(this.getWindow(), steposLiteSheetActivityBindingInflate.getRoot()).a(a0.o.b());
                    } else if (this.getIsCancelable()) {
                        this.requestDismiss(2);
                    }
                }
            });
        } catch (Throwable th) {
            this.installing = false;
            throw th;
        }
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        this.dismissGate.invalidate();
        this.dismissListener = null;
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        if (steposLiteSheetActivityBinding != null) {
            ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.enterListener;
            if (onPreDrawListener != null) {
                steposLiteSheetActivityBinding.getRoot().getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
            }
            this.enterListener = null;
            steposLiteSheetActivityBinding.getRoot().getController().dispose();
            steposLiteSheetActivityBinding.steposLiteSheetSurface.release();
            steposLiteSheetActivityBinding.steposLiteSheetTitleBar.setTouchDelegate(null);
            N.u0(steposLiteSheetActivityBinding.getRoot(), null);
        }
        this.startListener = null;
        this.endListener = null;
        this.startButton = null;
        this.endButton = null;
        this.progressListeners.clear();
        this.callbacks.clear();
        this.binding = null;
        super.onDestroy();
    }

    @Override // b.q, androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.p.i(outState, "outState");
        outState.putInt(SAVED_MODE, getSheetMode());
        outState.putInt(SAVED_GLASS_APPEARANCE, this.glassAppearance);
        outState.putInt(SAVED_STATE, getTargetSheetState() == 2 ? C5685n.j(getSheetState(), 1) : getTargetSheetState());
        super.onSaveInstanceState(outState);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onStart() {
        CharSequence charSequence;
        super.onStart();
        if (this.startIcon != null && ((charSequence = this.startIconDescription) == null || H.x0(charSequence))) {
            throw new IllegalArgumentException("A start icon requires startIconDescription");
        }
        if (this.endIcon != null) {
            CharSequence charSequence2 = this.endIconDescription;
            if (charSequence2 == null || H.x0(charSequence2)) {
                throw new IllegalArgumentException("An end icon requires endIconDescription");
            }
        }
    }

    @Override // androidx.appcompat.app.d, android.app.Activity
    public void onTitleChanged(CharSequence title, int color) {
        StepOSTitleBar stepOSTitleBar;
        super.onTitleChanged(title, color);
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        if (steposLiteSheetActivityBinding == null || (stepOSTitleBar = steposLiteSheetActivityBinding.steposLiteSheetTitleBar) == null) {
            return;
        }
        stepOSTitleBar.setTitle(title);
    }

    public final void registerSheetCallback(SheetCallback callback) {
        kotlin.jvm.internal.p.i(callback, "callback");
        this.callbacks.add(callback);
    }

    public final boolean removeOnProgressChangedListener(OnProgressChangedListener listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        return this.progressListeners.remove(listener);
    }

    public final void requestDismiss() {
        requestDismiss(0);
    }

    public final void setCancelable(boolean z10) {
        this.isCancelable = z10;
        updateConfiguration();
    }

    public final void setCanceledOnTouchOutside(boolean z10) {
        this.isCanceledOnTouchOutside = z10;
        updateConfiguration();
    }

    public final void setContentPaddingHorizontal(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("contentPaddingHorizontal must be >= 0 px");
        }
        this.configuredPadding = Integer.valueOf(i10);
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        if (steposLiteSheetActivityBinding != null) {
            steposLiteSheetActivityBinding.steposLiteSheetContent.setPaddingRelative(i10, 0, i10, 0);
            steposLiteSheetActivityBinding.steposLiteSheetTitleBar.setSidePadding(i10);
        }
    }

    @Override // androidx.appcompat.app.d, b.q, android.app.Activity
    public void setContentView(int layoutResID) {
        if (this.installing) {
            super.setContentView(layoutResID);
            return;
        }
        ViewGroup viewGroupContentParent = contentParent();
        viewGroupContentParent.removeAllViews();
        getLayoutInflater().inflate(layoutResID, viewGroupContentParent, true);
        this.contentInstalled = true;
        onContentChanged();
    }

    public final void setCornerRadius(float f10) {
        if (Float.isInfinite(f10) || Float.isNaN(f10) || f10 < 0.0f) {
            throw new IllegalArgumentException("cornerRadius must be finite and >= 0 px");
        }
        this.configuredRadius = Float.valueOf(f10);
        updateConfiguration();
    }

    public final void setDragToDismissEnabled(boolean z10) {
        this.isDragToDismissEnabled = z10;
        updateConfiguration();
    }

    public final void setDraggable(boolean z10) {
        StepOSLiteSheetLayout root;
        this.isDraggable = z10;
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        if (steposLiteSheetActivityBinding != null && (root = steposLiteSheetActivityBinding.getRoot()) != null && !z10 && root.getController().getMotion() == 1) {
            root.getController().cancelGesture();
        }
        updateConfiguration();
    }

    public final void setEndIcon(Drawable drawable) {
        Drawable drawableMutate;
        Drawable.ConstantState constantState;
        Drawable drawableNewDrawable;
        if (drawable == null || (constantState = drawable.getConstantState()) == null || (drawableNewDrawable = constantState.newDrawable(getResources())) == null || (drawableMutate = drawableNewDrawable.mutate()) == null) {
            drawableMutate = drawable != null ? drawable.mutate() : null;
        }
        this.endIcon = drawableMutate;
        refreshActions();
    }

    public final void setEndIconDescription(CharSequence charSequence) {
        this.endIconDescription = charSequence;
        ImageButton imageButton = this.endButton;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public final void setEndIconResource(int resource) {
        setEndIcon(resource == 0 ? null : C4027a.b(this, resource));
    }

    public final void setGlassAppearance(int i10) {
        if (i10 != 0 && i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException(("glassAppearance must be GLASS_APPEARANCE_FOLLOW_SYSTEM, GLASS_APPEARANCE_LIGHT, or GLASS_APPEARANCE_DARK but was " + i10).toString());
        }
        this.glassAppearanceSpecified = true;
        if (this.glassAppearance == i10) {
            return;
        }
        this.glassAppearance = i10;
        if (this.binding == null || pinNightMode()) {
            return;
        }
        updateConfiguration();
    }

    public final void setGlassEnabled(boolean z10) {
        this.isGlassEnabled = z10;
        updateConfiguration();
    }

    public final void setGrabberVisible(boolean z10) {
        this.isGrabberVisible = z10;
        applyGrabberVisibility();
    }

    public final void setInitialSheetState(int i10) {
        StepOSLiteSheetLayout root;
        StepOSLiteSheetController controller;
        INSTANCE.requireVisibleState(i10);
        requireAllowedState(i10);
        if (this.contentInstalled) {
            throw new IllegalStateException("Use setSheetState after setContentView");
        }
        if (this.dismissGate.isPending() || this.closed || (this.binding != null && getController().getTarget() == 2)) {
            throw new IllegalStateException("Cannot change initial state while dismissal is pending or closing");
        }
        this.initial = i10;
        this.initialWasSet = true;
        if (this.restored) {
            return;
        }
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        if (steposLiteSheetActivityBinding != null && (root = steposLiteSheetActivityBinding.getRoot()) != null && (controller = root.getController()) != null) {
            controller.restore(i10);
        }
        updateAccessibility();
    }

    public final void setOnDismissRequestedListener(OnDismissRequestedListener listener) {
        this.dismissGate.invalidate();
        this.dismissListener = listener;
        updateConfiguration();
    }

    public final void setOnEndIconClickListener(View.OnClickListener listener) {
        this.endListener = listener;
    }

    public final void setOnStartIconClickListener(View.OnClickListener listener) {
        this.startListener = listener;
    }

    public final void setSheetMode(int i10) {
        StepOSLiteSheetLayout root;
        StepOSLiteSheetStatePolicy stepOSLiteSheetStatePolicy = StepOSLiteSheetStatePolicy.INSTANCE;
        stepOSLiteSheetStatePolicy.requireMode(i10);
        if (this.dismissGate.isPending() || this.closed || (this.binding != null && getController().getTarget() == 2)) {
            throw new IllegalStateException("Cannot change sheetMode while dismissal is pending or closing");
        }
        if (this.binding == null) {
            if (!this.initialWasSet) {
                this.initial = stepOSLiteSheetStatePolicy.defaultState(i10);
            } else if (!stepOSLiteSheetStatePolicy.allows(i10, this.initial)) {
                throw new IllegalArgumentException("Initial state conflicts with sheetMode");
            }
            this.configuredMode = Integer.valueOf(i10);
            return;
        }
        if (getSheetMode() == i10) {
            return;
        }
        int target = getController().getTarget();
        this.configuredMode = Integer.valueOf(i10);
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        if (steposLiteSheetActivityBinding != null && (root = steposLiteSheetActivityBinding.getRoot()) != null) {
            root.resetGestures();
        }
        getController().setMode(i10);
        if (!stepOSLiteSheetStatePolicy.allows(i10, target)) {
            target = stepOSLiteSheetStatePolicy.defaultState(i10);
        }
        this.initial = target;
        getController().settle(target, false);
        updateConfiguration();
    }

    public final void setSheetState(int i10) {
        setSheetState$default(this, i10, false, 2, null);
    }

    public final void setStartIcon(Drawable drawable) {
        Drawable drawableMutate;
        Drawable.ConstantState constantState;
        Drawable drawableNewDrawable;
        if (drawable == null || (constantState = drawable.getConstantState()) == null || (drawableNewDrawable = constantState.newDrawable(getResources())) == null || (drawableMutate = drawableNewDrawable.mutate()) == null) {
            drawableMutate = drawable != null ? drawable.mutate() : null;
        }
        this.startIcon = drawableMutate;
        refreshActions();
    }

    public final void setStartIconDescription(CharSequence charSequence) {
        this.startIconDescription = charSequence;
        ImageButton imageButton = this.startButton;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public final void setStartIconResource(int resource) {
        setStartIcon(resource == 0 ? null : C4027a.b(this, resource));
    }

    public final boolean unregisterSheetCallback(SheetCallback callback) {
        kotlin.jvm.internal.p.i(callback, "callback");
        return this.callbacks.remove(callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestDismiss(int reason) {
        StepOSLiteSheetLayout root;
        if (this.binding == null) {
            throw new IllegalStateException("Call super.onCreate before requestDismiss");
        }
        if (!this.isCancelable || this.closed || getController().getTarget() == 2 || this.dismissGate.isPending()) {
            return;
        }
        OnDismissRequestedListener onDismissRequestedListener = this.dismissListener;
        if (onDismissRequestedListener == null) {
            dismiss$default(this, false, 1, null);
            return;
        }
        cancelPendingEnter();
        StepOSLiteSheetDismissGate.Decision decisionRequest = this.dismissGate.request(new InterfaceC5074l() { // from class: com.stepos.widget.panel.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSLiteSheetActivity.requestDismiss$lambda$33(this.f31293a, ((Boolean) obj).booleanValue());
            }
        });
        if (decisionRequest == null) {
            return;
        }
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        if (steposLiteSheetActivityBinding != null && (root = steposLiteSheetActivityBinding.getRoot()) != null) {
            root.resetGestures();
        }
        updateConfiguration();
        getController().settle(getController().getState(), true);
        if (decisionRequest.isPending()) {
            onDismissRequestedListener.onDismissRequested(this, new DismissRequest(reason, decisionRequest));
        }
    }

    public final void dismiss(boolean animate) {
        StepOSLiteSheetLayout root;
        if (this.binding == null) {
            throw new IllegalStateException("Call super.onCreate before dismiss");
        }
        if (this.closed || getController().getTarget() == 2) {
            return;
        }
        this.dismissGate.invalidate();
        SteposLiteSheetActivityBinding steposLiteSheetActivityBinding = this.binding;
        if (steposLiteSheetActivityBinding != null && (root = steposLiteSheetActivityBinding.getRoot()) != null) {
            root.resetGestures();
        }
        cancelPendingEnter();
        getController().settle(2, animate);
        updateAccessibility();
    }

    public final void setSheetState(int state, boolean animate) {
        INSTANCE.requireVisibleState(state);
        requireAllowedState(state);
        if (this.dismissGate.isPending()) {
            throw new IllegalStateException("Resolve the pending dismissal before changing state");
        }
        if (this.closed || getController().getTarget() == 2) {
            throw new IllegalStateException("Cannot change state while closing");
        }
        cancelPendingEnter();
        getController().settle(state, animate);
    }

    @Override // androidx.appcompat.app.d, b.q, android.app.Activity
    public void setContentView(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        if (this.installing) {
            super.setContentView(view);
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        setContentView(view, layoutParams);
    }

    @Override // androidx.appcompat.app.d, b.q, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(params, "params");
        if (this.installing) {
            super.setContentView(view, params);
            return;
        }
        if (view.getParent() == null) {
            ViewGroup viewGroupContentParent = contentParent();
            viewGroupContentParent.removeAllViews();
            viewGroupContentParent.addView(view, params);
            this.contentInstalled = true;
            onContentChanged();
            return;
        }
        throw new IllegalArgumentException("Business content must not already have a parent");
    }
}
