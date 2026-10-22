package com.stepos.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.method.MovementMethod;
import android.util.Pair;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.button.StepOSButton;
import com.stepos.widget.dialog.StepOSAlertDialog;
import f.C4027a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000 \u008c\u00012\u00020\u00012\u00020\u0002:\b\u008d\u0001\u008e\u0001\u008f\u0001\u008c\u0001B\u001b\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0014\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\tB#\b\u0014\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\u000eJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0017¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0016\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u0013H\u0017¢\u0006\u0004\b\u001f\u0010\u0017J\u0019\u0010\"\u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010 H\u0017¢\u0006\u0004\b\"\u0010#J\u0019\u0010%\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010\u001aH\u0017¢\u0006\u0004\b%\u0010\u001dJA\u0010%\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010\u001a2\b\b\u0001\u0010&\u001a\u00020\u00052\b\b\u0001\u0010'\u001a\u00020\u00052\b\b\u0001\u0010(\u001a\u00020\u00052\b\b\u0001\u0010)\u001a\u00020\u0005H\u0017¢\u0006\u0004\b%\u0010*JM\u00102\u001a\u00020\u001522\u0010/\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-0,\u0018\u00010+j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-0,\u0018\u0001`.2\b\u00101\u001a\u0004\u0018\u000100H\u0017¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\u00152\u0006\u00104\u001a\u00020\nH\u0017¢\u0006\u0004\b5\u00106JM\u0010<\u001a\u00020\u00152\b\b\u0001\u00107\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u00010\u00132\b\b\u0001\u00109\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010;\u001a\u00020\u00052\n\b\u0002\u00101\u001a\u0004\u0018\u000100H\u0017¢\u0006\u0004\b<\u0010=JM\u0010<\u001a\u00020\u00152\b\u0010?\u001a\u0004\u0018\u00010>2\b\u00108\u001a\u0004\u0018\u00010\u00132\b\u0010@\u001a\u0004\u0018\u00010>2\b\u0010:\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010;\u001a\u00020\u00052\n\b\u0002\u00101\u001a\u0004\u0018\u000100H\u0017¢\u0006\u0004\b<\u0010AJ+\u0010E\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010B\u001a\u0004\u0018\u00010\u00132\b\u0010D\u001a\u0004\u0018\u00010CH\u0017¢\u0006\u0004\bE\u0010FJ+\u0010E\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010B\u001a\u0004\u0018\u00010\u00132\b\u00101\u001a\u0004\u0018\u000100H\u0017¢\u0006\u0004\bE\u0010GJ5\u0010E\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010B\u001a\u0004\u0018\u00010\u00132\b\u0010H\u001a\u0004\u0018\u00010>2\b\u00101\u001a\u0004\u0018\u000100H\u0017¢\u0006\u0004\bE\u0010IJ\u0019\u0010K\u001a\u00020\u00152\b\b\u0001\u0010J\u001a\u00020\u0005H\u0017¢\u0006\u0004\bK\u0010\u0019J\u0019\u0010K\u001a\u00020\u00152\b\u0010H\u001a\u0004\u0018\u00010>H\u0017¢\u0006\u0004\bK\u0010LJ\u0019\u0010M\u001a\u00020\u00152\b\b\u0001\u0010J\u001a\u00020\u0005H\u0007¢\u0006\u0004\bM\u0010\u0019J\u0019\u0010O\u001a\u00020\u00152\b\b\u0001\u0010N\u001a\u00020\u0005H\u0017¢\u0006\u0004\bO\u0010\u0019J\u0019\u0010Q\u001a\u00020\u00152\b\b\u0001\u0010P\u001a\u00020\u0005H\u0017¢\u0006\u0004\bQ\u0010\u0019J!\u0010S\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00052\b\b\u0001\u0010R\u001a\u00020\u0005H\u0017¢\u0006\u0004\bS\u0010TJ\u0017\u0010V\u001a\u00020\u00152\u0006\u0010U\u001a\u00020\nH\u0017¢\u0006\u0004\bV\u00106J7\u0010[\u001a\u00020\u00152\b\b\u0001\u0010W\u001a\u00020\u00052\b\b\u0001\u0010X\u001a\u00020\u00052\b\b\u0001\u0010Y\u001a\u00020\u00052\b\b\u0001\u0010Z\u001a\u00020\u0005H\u0017¢\u0006\u0004\b[\u0010\\J\u001f\u0010^\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\u0005H\u0017¢\u0006\u0004\b^\u0010TJ\u0019\u0010a\u001a\u00020\u00152\b\u0010`\u001a\u0004\u0018\u00010_H\u0014¢\u0006\u0004\ba\u0010bJ\u000f\u0010c\u001a\u00020\u0015H\u0014¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\u0015H\u0016¢\u0006\u0004\be\u0010dJ\u000f\u0010f\u001a\u00020\u0015H\u0014¢\u0006\u0004\bf\u0010dJ\u001f\u0010j\u001a\u00020\n2\u0006\u0010g\u001a\u00020\u00052\u0006\u0010i\u001a\u00020hH\u0016¢\u0006\u0004\bj\u0010kJ\u001f\u0010l\u001a\u00020\n2\u0006\u0010g\u001a\u00020\u00052\u0006\u0010i\u001a\u00020hH\u0016¢\u0006\u0004\bl\u0010kR\u0014\u0010n\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR$\u0010t\u001a\u00020\u00052\u0006\u0010p\u001a\u00020\u00058G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bq\u0010r\"\u0004\bs\u0010\u0019R$\u0010u\u001a\u00020\n2\u0006\u0010p\u001a\u00020\n8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bu\u0010v\"\u0004\bw\u00106R(\u0010}\u001a\u0004\u0018\u00010x2\b\u0010p\u001a\u0004\u0018\u00010x8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0018\u0010\u0081\u0001\u001a\u0004\u0018\u00010~8WX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001R)\u0010\u0084\u0001\u001a\u00020\u00052\b\b\u0001\u0010p\u001a\u00020\u00058G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0082\u0001\u0010r\"\u0005\b\u0083\u0001\u0010\u0019R)\u0010\u0087\u0001\u001a\u00020\u00052\b\b\u0001\u0010p\u001a\u00020\u00058G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0085\u0001\u0010r\"\u0005\b\u0086\u0001\u0010\u0019R,\u0010\u008b\u0001\u001a\u0004\u0018\u00010>2\b\u0010p\u001a\u0004\u0018\u00010>8G@GX\u0086\u000e¢\u0006\u000f\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0005\b\u008a\u0001\u0010L¨\u0006\u0090\u0001"}, d2 = {"Lcom/stepos/widget/dialog/StepOSAlertDialog;", "Landroid/app/Dialog;", "Landroid/content/DialogInterface;", "Landroid/content/Context;", "context", "", "themeResId", "<init>", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "", "cancelable", "Landroid/content/DialogInterface$OnCancelListener;", "cancelListener", "(Landroid/content/Context;ZLandroid/content/DialogInterface$OnCancelListener;)V", "whichButton", "Lcom/stepos/widget/button/StepOSButton;", "getButton", "(I)Lcom/stepos/widget/button/StepOSButton;", "", "title", "LY8/t;", "setTitle", "(Ljava/lang/CharSequence;)V", "titleId", "(I)V", "Landroid/view/View;", "customTitleView", "setCustomTitle", "(Landroid/view/View;)V", "message", "setMessage", "Landroid/text/method/MovementMethod;", "movementMethod", "setMessageMovementMethod", "(Landroid/text/method/MovementMethod;)V", "view", "setView", "viewSpacingLeft", "viewSpacingTop", "viewSpacingRight", "viewSpacingBottom", "(Landroid/view/View;IIII)V", "Ljava/util/ArrayList;", "Landroid/util/Pair;", "", "Lkotlin/collections/ArrayList;", DidiCardProvider.KEY_ITEMS, "Landroid/content/DialogInterface$OnClickListener;", "listener", "setListItems", "(Ljava/util/ArrayList;Landroid/content/DialogInterface$OnClickListener;)V", x5.d.EXTRA_ENABLED, "setListItemsScrollbarEnabled", "(Z)V", "leftIconRes", "leftLabel", "rightIconRes", "rightLabel", "selectedIndex", "setIconContent", "(ILjava/lang/CharSequence;ILjava/lang/CharSequence;ILandroid/content/DialogInterface$OnClickListener;)V", "Landroid/graphics/drawable/Drawable;", "leftIcon", "rightIcon", "(Landroid/graphics/drawable/Drawable;Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Ljava/lang/CharSequence;ILandroid/content/DialogInterface$OnClickListener;)V", "text", "Landroid/os/Message;", "msg", "setButton", "(ILjava/lang/CharSequence;Landroid/os/Message;)V", "(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V", "icon", "(ILjava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Landroid/content/DialogInterface$OnClickListener;)V", "resId", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "setIconBadgeResource", "attrId", "setIconAttribute", "height", "setMaxHeight", "colorResId", "setButtonTextColor", "(II)V", "show", "setAutoShowSoftInput", "space1", "space2", "space3", "space4", "setCustomPaddingRule", "(IIII)V", "color", "setHighLightButton", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", UxipConstants.f30640D, "()V", DidiCardProvider.ACTION_DISMISS, "onStop", "keyCode", "Landroid/view/KeyEvent;", "event", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "onKeyUp", "Lcom/stepos/widget/dialog/StepOSAlertController;", "controller", "Lcom/stepos/widget/dialog/StepOSAlertController;", UxipConstants.f30680s, "getButtonLayout", "()I", "setButtonLayout", "buttonLayout", "isGlassEnabled", "()Z", "setGlassEnabled", "Ly7/o;", "getGlassEffect", "()Ly7/o;", "setGlassEffect", "(Ly7/o;)V", "glassEffect", "Landroid/widget/ListView;", "getListView", "()Landroid/widget/ListView;", "listView", "getTitleMaxLines", "setTitleMaxLines", "titleMaxLines", "getMessageMaxLines", "setMessageMaxLines", "messageMaxLines", "getIconBadge", "()Landroid/graphics/drawable/Drawable;", "setIconBadge", "iconBadge", "Companion", "ButtonColor", "ButtonLayout", "Builder", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSAlertDialog extends Dialog implements DialogInterface {
    public static final int BUTTON_LAYOUT_AUTO = 0;
    public static final int BUTTON_LAYOUT_HORIZONTAL = 1;
    public static final int BUTTON_LAYOUT_VERTICAL = 2;
    public static final int COLOR_BLUE = 1;
    public static final int COLOR_NORMAL = 0;
    public static final int COLOR_POLESTAR = 3;
    public static final int COLOR_RED = 2;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StepOSAlertController controller;

    @Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002©\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00002\b\b\u0001\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\nJ\u0019\u0010\u0014\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0014\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\nJ\u0019\u0010\u001c\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u00020\u00002\b\b\u0001\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\nJ\u0019\u0010\u001f\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001f\u0010\u0017J\u0019\u0010!\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\nJ\u0019\u0010$\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010'\u001a\u00020\u00002\b\b\u0001\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\nJ\u0019\u0010'\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b'\u0010*J\u0019\u0010,\u001a\u00020\u00002\b\b\u0001\u0010+\u001a\u00020\u0004H\u0016¢\u0006\u0004\b,\u0010\nJ\u0019\u0010,\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b,\u0010*J\u0019\u0010.\u001a\u00020\u00002\b\b\u0001\u0010-\u001a\u00020\u0004H\u0016¢\u0006\u0004\b.\u0010\nJ#\u00102\u001a\u00020\u00002\b\b\u0001\u0010/\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b2\u00103J#\u00102\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u00152\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b2\u00105J\u0019\u00106\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b6\u0010*J#\u00107\u001a\u00020\u00002\b\b\u0001\u0010/\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b7\u00103J#\u00107\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u00152\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b7\u00105J\u0019\u00108\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b8\u0010*J#\u00109\u001a\u00020\u00002\b\b\u0001\u0010/\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b9\u00103J#\u00109\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u00152\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b9\u00105J\u0019\u0010:\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b:\u0010*J\u001f\u0010=\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u000bH\u0016¢\u0006\u0004\b@\u0010\u000eJ\u0019\u0010C\u001a\u00020\u00002\b\u0010B\u001a\u0004\u0018\u00010AH\u0016¢\u0006\u0004\bC\u0010DJ\u0019\u0010G\u001a\u00020\u00002\b\u0010F\u001a\u0004\u0018\u00010EH\u0016¢\u0006\u0004\bG\u0010HJ\u0019\u0010K\u001a\u00020\u00002\b\u0010J\u001a\u0004\u0018\u00010IH\u0016¢\u0006\u0004\bK\u0010LJ\u0017\u0010N\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u000bH\u0016¢\u0006\u0004\bN\u0010\u000eJ#\u0010P\u001a\u00020\u00002\b\b\u0001\u0010O\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\bP\u00103J+\u0010P\u001a\u00020\u00002\u0010\u0010R\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0015\u0018\u00010Q2\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\bP\u0010SJ+\u0010P\u001a\u00020\u00002\b\b\u0001\u0010O\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u0001002\u0006\u0010T\u001a\u00020\u000bH\u0016¢\u0006\u0004\bP\u0010UJ3\u0010P\u001a\u00020\u00002\u0010\u0010R\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0015\u0018\u00010Q2\b\u00101\u001a\u0004\u0018\u0001002\u0006\u0010T\u001a\u00020\u000bH\u0016¢\u0006\u0004\bP\u0010VJ5\u0010P\u001a\u00020\u00002\b\b\u0001\u0010O\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u0001002\u0006\u0010T\u001a\u00020\u000b2\b\u0010<\u001a\u0004\u0018\u00010WH\u0016¢\u0006\u0004\bP\u0010XJ=\u0010P\u001a\u00020\u00002\u0010\u0010R\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0015\u0018\u00010Q2\b\u00101\u001a\u0004\u0018\u0001002\u0006\u0010T\u001a\u00020\u000b2\b\u0010<\u001a\u0004\u0018\u00010WH\u0016¢\u0006\u0004\bP\u0010YJ;\u0010P\u001a\u00020\u00002\b\b\u0001\u0010O\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u0001002\u0006\u0010T\u001a\u00020\u000b2\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010QH\u0016¢\u0006\u0004\bP\u0010[JC\u0010P\u001a\u00020\u00002\u0010\u0010R\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0015\u0018\u00010Q2\b\u00101\u001a\u0004\u0018\u0001002\u0006\u0010T\u001a\u00020\u000b2\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010QH\u0016¢\u0006\u0004\bP\u0010\\J#\u0010_\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010]2\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b_\u0010`J-\u0010e\u001a\u00020\u00002\b\u0010b\u001a\u0004\u0018\u00010a2\b\u00101\u001a\u0004\u0018\u0001002\b\u0010d\u001a\u0004\u0018\u00010cH\u0016¢\u0006\u0004\be\u0010fJ-\u0010j\u001a\u00020\u00002\b\b\u0001\u0010O\u001a\u00020\u00042\b\u0010h\u001a\u0004\u0018\u00010g2\b\u00101\u001a\u0004\u0018\u00010iH\u0016¢\u0006\u0004\bj\u0010kJ5\u0010j\u001a\u00020\u00002\u0010\u0010R\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0015\u0018\u00010Q2\b\u0010h\u001a\u0004\u0018\u00010g2\b\u00101\u001a\u0004\u0018\u00010iH\u0016¢\u0006\u0004\bj\u0010lJ7\u0010j\u001a\u00020\u00002\b\u0010b\u001a\u0004\u0018\u00010a2\b\u0010m\u001a\u0004\u0018\u00010c2\b\u0010d\u001a\u0004\u0018\u00010c2\b\u00101\u001a\u0004\u0018\u00010iH\u0016¢\u0006\u0004\bj\u0010nJ+\u0010p\u001a\u00020\u00002\b\b\u0001\u0010O\u001a\u00020\u00042\u0006\u0010o\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\bp\u0010qJ3\u0010p\u001a\u00020\u00002\u0010\u0010R\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0015\u0018\u00010Q2\u0006\u0010o\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\bp\u0010rJ5\u0010p\u001a\u00020\u00002\b\u0010b\u001a\u0004\u0018\u00010a2\u0006\u0010o\u001a\u00020\u00042\b\u0010d\u001a\u0004\u0018\u00010c2\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\bp\u0010sJ+\u0010p\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010]2\u0006\u0010o\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\bp\u0010tJU\u0010y\u001a\u00020\u000022\u0010x\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020c0v\u0018\u00010uj\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020c0v\u0018\u0001`w2\u0006\u0010o\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\by\u0010zJW\u0010{\u001a\u00020\u000022\u0010x\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020c0v\u0018\u00010uj\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020c0v\u0018\u0001`w2\b\u0010h\u001a\u0004\u0018\u00010g2\b\u00101\u001a\u0004\u0018\u00010iH\u0016¢\u0006\u0004\b{\u0010|J\u0019\u0010~\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010}H\u0016¢\u0006\u0004\b~\u0010\u007fJP\u0010\u0080\u0001\u001a\u00020\u000022\u0010R\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020c0v\u0018\u00010uj\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020c0v\u0018\u0001`w2\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J-\u0010\u0080\u0001\u001a\u00020\u00002\u0010\u0010R\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0015\u0018\u00010Q2\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0005\b\u0080\u0001\u0010SJ\u0019\u0010\u0082\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0005\b\u0082\u0001\u0010\u000eJU\u0010\u0088\u0001\u001a\u00020\u00002\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00042\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00152\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u00042\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00152\t\b\u0002\u0010\u0087\u0001\u001a\u00020\u00042\n\b\u0002\u00101\u001a\u0004\u0018\u000100H\u0017¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001JU\u0010\u0088\u0001\u001a\u00020\u00002\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010(2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010(2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00152\t\b\u0002\u0010\u0087\u0001\u001a\u00020\u00042\n\b\u0002\u00101\u001a\u0004\u0018\u000100H\u0017¢\u0006\u0006\b\u0088\u0001\u0010\u008c\u0001J\u001c\u0010\u008e\u0001\u001a\u00020\u00002\t\b\u0001\u0010\u008d\u0001\u001a\u00020\u0004H\u0016¢\u0006\u0005\b\u008e\u0001\u0010\nJ\u001c\u0010\u008e\u0001\u001a\u00020\u00002\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0005\b\u008e\u0001\u0010\u001dJI\u0010\u008e\u0001\u001a\u00020\u00002\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u001a2\t\b\u0001\u0010\u0090\u0001\u001a\u00020\u00042\t\b\u0001\u0010\u0091\u0001\u001a\u00020\u00042\t\b\u0001\u0010\u0092\u0001\u001a\u00020\u00042\t\b\u0001\u0010\u0093\u0001\u001a\u00020\u0004H\u0016¢\u0006\u0006\b\u008e\u0001\u0010\u0094\u0001J\u001a\u0010\u0096\u0001\u001a\u00020\u00002\u0007\u0010\u0095\u0001\u001a\u00020\u0004H\u0016¢\u0006\u0005\b\u0096\u0001\u0010\nJ\u001c\u0010\u0098\u0001\u001a\u00020\u00002\t\b\u0001\u0010\u0097\u0001\u001a\u00020\u0004H\u0016¢\u0006\u0005\b\u0098\u0001\u0010\nJ\u001a\u0010\u009a\u0001\u001a\u00020\u00002\u0007\u0010\u0099\u0001\u001a\u00020\u000bH\u0017¢\u0006\u0005\b\u009a\u0001\u0010\u000eJ\u0019\u0010\u009b\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0005\b\u009b\u0001\u0010\u000eJ\u0013\u0010\u009d\u0001\u001a\u00030\u009c\u0001H\u0016¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J,\u0010\u009d\u0001\u001a\u00028\u0000\"\n\b\u0000\u0010\u009f\u0001*\u00030\u009c\u00012\u000e\u0010¡\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000 \u0001¢\u0006\u0006\b\u009d\u0001\u0010¢\u0001J\u0011\u0010M\u001a\u00030\u009c\u0001H\u0016¢\u0006\u0005\bM\u0010\u009e\u0001R\u0015\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0005\u0010£\u0001R\u0018\u0010¥\u0001\u001a\u00030¤\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u0013\u0010\u0003\u001a\u00020\u00028F¢\u0006\b\u001a\u0006\b§\u0001\u0010¨\u0001¨\u0006ª\u0001"}, d2 = {"Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "", "Landroid/content/Context;", "context", "", "themeResId", "<init>", "(Landroid/content/Context;I)V", "layout", "setButtonLayout", "(I)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "", x5.d.EXTRA_ENABLED, "setGlassEnabled", "(Z)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "Ly7/o;", "effect", "setGlassEffect", "(Ly7/o;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "titleId", "setTitle", "", "title", "(Ljava/lang/CharSequence;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "maxLines", "setTitleMaxLines", "Landroid/view/View;", "customTitleView", "setCustomTitle", "(Landroid/view/View;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "messageId", "setMessage", "message", "setMessageMaxLines", "Landroid/text/method/MovementMethod;", "movementMethod", "setMessageMovementMethod", "(Landroid/text/method/MovementMethod;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "iconId", "setIcon", "Landroid/graphics/drawable/Drawable;", "icon", "(Landroid/graphics/drawable/Drawable;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "resId", "setIconBadge", "attrId", "setIconAttribute", "textId", "Landroid/content/DialogInterface$OnClickListener;", "listener", "setPositiveButton", "(ILandroid/content/DialogInterface$OnClickListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "text", "(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "setPositiveButtonIcon", "setNegativeButton", "setNegativeButtonIcon", "setNeutralButton", "setNeutralButtonIcon", "whichButton", "color", "setHighLightButton", "(II)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "cancelable", "setCancelable", "Landroid/content/DialogInterface$OnCancelListener;", "onCancelListener", "setOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "Landroid/content/DialogInterface$OnDismissListener;", "onDismissListener", "setOnDismissListener", "(Landroid/content/DialogInterface$OnDismissListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "Landroid/content/DialogInterface$OnKeyListener;", "onKeyListener", "setOnKeyListener", "(Landroid/content/DialogInterface$OnKeyListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "show", "setAutoShowSoftInput", "itemsId", "setItems", "", DidiCardProvider.KEY_ITEMS, "([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "isCenter", "(ILandroid/content/DialogInterface$OnClickListener;Z)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;Z)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "Landroid/content/res/ColorStateList;", "(ILandroid/content/DialogInterface$OnClickListener;ZLandroid/content/res/ColorStateList;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;ZLandroid/content/res/ColorStateList;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "colors", "(ILandroid/content/DialogInterface$OnClickListener;Z[Landroid/content/res/ColorStateList;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;Z[Landroid/content/res/ColorStateList;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "Landroid/widget/ListAdapter;", "adapter", "setAdapter", "(Landroid/widget/ListAdapter;Landroid/content/DialogInterface$OnClickListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "Landroid/database/Cursor;", "cursor", "", "labelColumn", "setCursor", "(Landroid/database/Cursor;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "", "checkedItems", "Landroid/content/DialogInterface$OnMultiChoiceClickListener;", "setMultiChoiceItems", "(I[ZLandroid/content/DialogInterface$OnMultiChoiceClickListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "([Ljava/lang/CharSequence;[ZLandroid/content/DialogInterface$OnMultiChoiceClickListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "isCheckedColumn", "(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnMultiChoiceClickListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "checkedItem", "setSingleChoiceItems", "(IILandroid/content/DialogInterface$OnClickListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "([Ljava/lang/CharSequence;ILandroid/content/DialogInterface$OnClickListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "(Landroid/database/Cursor;ILjava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "(Landroid/widget/ListAdapter;ILandroid/content/DialogInterface$OnClickListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "Ljava/util/ArrayList;", "Landroid/util/Pair;", "Lkotlin/collections/ArrayList;", "detailedDescriptions", "setSingleMultipleLineChoiceItems", "(Ljava/util/ArrayList;ILandroid/content/DialogInterface$OnClickListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "setMultipleLineChoiceItems", "(Ljava/util/ArrayList;[ZLandroid/content/DialogInterface$OnMultiChoiceClickListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "Landroid/widget/AdapterView$OnItemSelectedListener;", "setOnItemSelectedListener", "(Landroid/widget/AdapterView$OnItemSelectedListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "setListItems", "(Ljava/util/ArrayList;Landroid/content/DialogInterface$OnClickListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "setListItemsScrollbarEnabled", "leftIconRes", "leftLabel", "rightIconRes", "rightLabel", "selectedIndex", "setIconContent", "(ILjava/lang/CharSequence;ILjava/lang/CharSequence;ILandroid/content/DialogInterface$OnClickListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "leftIcon", "rightIcon", "(Landroid/graphics/drawable/Drawable;Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Ljava/lang/CharSequence;ILandroid/content/DialogInterface$OnClickListener;)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "layoutResId", "setView", "view", "viewSpacingLeft", "viewSpacingTop", "viewSpacingRight", "viewSpacingBottom", "(Landroid/view/View;IIII)Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder;", "gravity", "setGravity", "height", "setMaxHeight", "useInverseBackground", "setInverseBackgroundForced", "setRecycleOnMeasureEnabled", "Lcom/stepos/widget/dialog/StepOSAlertDialog;", "create", "()Lcom/stepos/widget/dialog/StepOSAlertDialog;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder$DialogFactory;", "factory", "(Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder$DialogFactory;)Lcom/stepos/widget/dialog/StepOSAlertDialog;", "I", "Lcom/stepos/widget/dialog/StepOSAlertParams;", "params", "Lcom/stepos/widget/dialog/StepOSAlertParams;", "getContext", "()Landroid/content/Context;", "DialogFactory", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class Builder {
        private final StepOSAlertParams params;
        private final int themeResId;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001f\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/widget/dialog/StepOSAlertDialog$Builder$DialogFactory;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/stepos/widget/dialog/StepOSAlertDialog;", "", "newDialog", "context", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)Lcom/stepos/widget/dialog/StepOSAlertDialog;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public interface DialogFactory<T extends StepOSAlertDialog> {
            T newDialog(Context context, int themeResId);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Context context) {
            this(context, 0, 2, null);
            kotlin.jvm.internal.p.i(context, "context");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final StepOSAlertDialog create$lambda$67(Context context, int i10) {
            kotlin.jvm.internal.p.i(context, "context");
            return new StepOSAlertDialog(context, i10);
        }

        public static /* synthetic */ Builder setIconContent$default(Builder builder, int i10, CharSequence charSequence, int i11, CharSequence charSequence2, int i12, DialogInterface.OnClickListener onClickListener, int i13, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIconContent");
            }
            if ((i13 & 16) != 0) {
                i12 = 0;
            }
            int i14 = i12;
            if ((i13 & 32) != 0) {
                onClickListener = null;
            }
            return builder.setIconContent(i10, charSequence, i11, charSequence2, i14, onClickListener);
        }

        public StepOSAlertDialog create() {
            return create(new DialogFactory() { // from class: com.stepos.widget.dialog.j
                @Override // com.stepos.widget.dialog.StepOSAlertDialog.Builder.DialogFactory
                public final StepOSAlertDialog newDialog(Context context, int i10) {
                    return StepOSAlertDialog.Builder.create$lambda$67(context, i10);
                }
            });
        }

        public final Context getContext() {
            return this.params.getContext();
        }

        public Builder setAdapter(ListAdapter adapter, DialogInterface.OnClickListener listener) {
            this.params.setAdapter(adapter);
            this.params.setOnClickListener(listener);
            return this;
        }

        public Builder setAutoShowSoftInput(boolean show) {
            this.params.setAutoShowSoftInput(show);
            return this;
        }

        public final Builder setButtonLayout(int layout) {
            if (layout >= 0 && layout < 3) {
                this.params.setButtonLayout(layout);
                return this;
            }
            throw new IllegalArgumentException(("buttonLayout must be AUTO, HORIZONTAL or VERTICAL but was " + layout).toString());
        }

        public Builder setCancelable(boolean cancelable) {
            this.params.setCancelable(cancelable);
            return this;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener listener, String labelColumn) {
            this.params.setCursor(cursor);
            this.params.setLabelColumn(labelColumn);
            this.params.setOnClickListener(listener);
            return this;
        }

        public Builder setCustomTitle(View customTitleView) {
            this.params.setCustomTitleView(customTitleView);
            return this;
        }

        public final Builder setGlassEffect(y7.o effect) {
            this.params.setGlassEffect(effect);
            this.params.setGlassEffectSpecified(true);
            return this;
        }

        public final Builder setGlassEnabled(boolean enabled) {
            this.params.setGlassEnabled(enabled);
            return this;
        }

        public Builder setGravity(int gravity) {
            this.params.setGravity(gravity);
            return this;
        }

        public Builder setHighLightButton(int whichButton, int color) {
            this.params.setHighLightButton(whichButton);
            this.params.setHighLightColor(color);
            return this;
        }

        public Builder setIcon(int iconId) {
            this.params.setIconId(iconId);
            this.params.setIcon(null);
            return this;
        }

        public Builder setIconAttribute(int attrId) {
            this.params.setIconAttrId(attrId);
            return this;
        }

        public Builder setIconBadge(int resId) {
            this.params.setIconBadge(resId == 0 ? null : C4027a.b(getContext(), resId));
            return this;
        }

        public final Builder setIconContent(int i10, CharSequence charSequence, int i11, CharSequence charSequence2) {
            return setIconContent$default(this, i10, charSequence, i11, charSequence2, 0, (DialogInterface.OnClickListener) null, 48, (Object) null);
        }

        public Builder setInverseBackgroundForced(boolean useInverseBackground) {
            return this;
        }

        public Builder setItems(int itemsId, DialogInterface.OnClickListener listener) {
            StepOSAlertParams stepOSAlertParams = this.params;
            stepOSAlertParams.setItems(stepOSAlertParams.getContext().getResources().getTextArray(itemsId));
            this.params.setOnClickListener(listener);
            return this;
        }

        public Builder setListItems(ArrayList<Pair<String, String>> items, DialogInterface.OnClickListener listener) {
            this.params.setListItems(items);
            this.params.setOnClickListener(listener);
            this.params.setHasIconContent(false);
            return this;
        }

        public Builder setListItemsScrollbarEnabled(boolean enabled) {
            this.params.setListItemsScrollbarEnabled(enabled);
            return this;
        }

        public Builder setMaxHeight(int height) {
            this.params.setMaxHeight(height);
            return this;
        }

        public Builder setMessage(int messageId) {
            StepOSAlertParams stepOSAlertParams = this.params;
            stepOSAlertParams.setMessage(stepOSAlertParams.getContext().getText(messageId));
            return this;
        }

        public Builder setMessageMaxLines(int maxLines) {
            if (maxLines > 0) {
                this.params.setMessageMaxLines(maxLines);
                return this;
            }
            throw new IllegalArgumentException(("messageMaxLines must be > 0 but was " + maxLines).toString());
        }

        public Builder setMessageMovementMethod(MovementMethod movementMethod) {
            this.params.setMessageMovementMethod(movementMethod);
            return this;
        }

        public Builder setMultiChoiceItems(int itemsId, boolean[] checkedItems, DialogInterface.OnMultiChoiceClickListener listener) {
            StepOSAlertParams stepOSAlertParams = this.params;
            stepOSAlertParams.setItems(stepOSAlertParams.getContext().getResources().getTextArray(itemsId));
            this.params.setOnCheckboxClickListener(listener);
            this.params.setCheckedItems(checkedItems);
            this.params.setMultiChoice(true);
            return this;
        }

        public Builder setMultipleLineChoiceItems(ArrayList<Pair<String, String>> detailedDescriptions, boolean[] checkedItems, DialogInterface.OnMultiChoiceClickListener listener) {
            this.params.setItemData(detailedDescriptions);
            this.params.setOnCheckboxClickListener(listener);
            this.params.setCheckedItems(checkedItems);
            this.params.setMultiLines(true);
            return this;
        }

        public Builder setNegativeButton(int textId, DialogInterface.OnClickListener listener) {
            StepOSAlertParams stepOSAlertParams = this.params;
            stepOSAlertParams.setNegativeButtonText(stepOSAlertParams.getContext().getText(textId));
            this.params.setNegativeButtonListener(listener);
            return this;
        }

        public Builder setNegativeButtonIcon(Drawable icon) {
            this.params.setNegativeButtonIcon(icon);
            return this;
        }

        public Builder setNeutralButton(int textId, DialogInterface.OnClickListener listener) {
            StepOSAlertParams stepOSAlertParams = this.params;
            stepOSAlertParams.setNeutralButtonText(stepOSAlertParams.getContext().getText(textId));
            this.params.setNeutralButtonListener(listener);
            return this;
        }

        public Builder setNeutralButtonIcon(Drawable icon) {
            this.params.setNeutralButtonIcon(icon);
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.params.setOnCancelListener(onCancelListener);
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.params.setOnDismissListener(onDismissListener);
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener listener) {
            this.params.setOnItemSelectedListener(listener);
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.params.setOnKeyListener(onKeyListener);
            return this;
        }

        public Builder setPositiveButton(int textId, DialogInterface.OnClickListener listener) {
            StepOSAlertParams stepOSAlertParams = this.params;
            stepOSAlertParams.setPositiveButtonText(stepOSAlertParams.getContext().getText(textId));
            this.params.setPositiveButtonListener(listener);
            return this;
        }

        public Builder setPositiveButtonIcon(Drawable icon) {
            this.params.setPositiveButtonIcon(icon);
            return this;
        }

        public Builder setRecycleOnMeasureEnabled(boolean enabled) {
            this.params.setRecycleOnMeasure(enabled);
            return this;
        }

        public Builder setSingleChoiceItems(int itemsId, int checkedItem, DialogInterface.OnClickListener listener) {
            StepOSAlertParams stepOSAlertParams = this.params;
            stepOSAlertParams.setItems(stepOSAlertParams.getContext().getResources().getTextArray(itemsId));
            this.params.setOnClickListener(listener);
            this.params.setCheckedItem(checkedItem);
            this.params.setSingleChoice(true);
            return this;
        }

        public Builder setSingleMultipleLineChoiceItems(ArrayList<Pair<String, String>> detailedDescriptions, int checkedItem, DialogInterface.OnClickListener listener) {
            this.params.setItemData(detailedDescriptions);
            this.params.setOnClickListener(listener);
            this.params.setCheckedItem(checkedItem);
            this.params.setCheckedItems(null);
            this.params.setMultiLines(true);
            return this;
        }

        public Builder setTitle(int titleId) {
            StepOSAlertParams stepOSAlertParams = this.params;
            stepOSAlertParams.setTitle(stepOSAlertParams.getContext().getText(titleId));
            return this;
        }

        public Builder setTitleMaxLines(int maxLines) {
            if (maxLines > 0) {
                this.params.setTitleMaxLines(maxLines);
                return this;
            }
            throw new IllegalArgumentException(("titleMaxLines must be > 0 but was " + maxLines).toString());
        }

        public Builder setView(int layoutResId) {
            this.params.setView(null);
            this.params.setViewLayoutResId(layoutResId);
            this.params.setViewSpacingSpecified(false);
            this.params.setHasIconContent(false);
            return this;
        }

        public StepOSAlertDialog show() {
            StepOSAlertDialog stepOSAlertDialogCreate = create();
            stepOSAlertDialogCreate.show();
            return stepOSAlertDialogCreate;
        }

        public Builder(Context context, int i10) {
            kotlin.jvm.internal.p.i(context, "context");
            this.themeResId = i10;
            this.params = new StepOSAlertParams(new ContextThemeWrapper(context, StepOSAlertDialog.INSTANCE.resolveDialogTheme$StepOSWidget_release(context, i10)));
        }

        public static /* synthetic */ Builder setIconContent$default(Builder builder, Drawable drawable, CharSequence charSequence, Drawable drawable2, CharSequence charSequence2, int i10, DialogInterface.OnClickListener onClickListener, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIconContent");
            }
            if ((i11 & 16) != 0) {
                i10 = 0;
            }
            int i12 = i10;
            if ((i11 & 32) != 0) {
                onClickListener = null;
            }
            return builder.setIconContent(drawable, charSequence, drawable2, charSequence2, i12, onClickListener);
        }

        public final <T extends StepOSAlertDialog> T create(DialogFactory<T> factory) throws Resources.NotFoundException {
            kotlin.jvm.internal.p.i(factory, "factory");
            T t10 = (T) factory.newDialog(this.params.getContext(), this.themeResId);
            this.params.apply(((StepOSAlertDialog) t10).controller);
            t10.setCancelable(this.params.getCancelable());
            if (this.params.getCancelable()) {
                t10.setCanceledOnTouchOutside(true);
            }
            t10.setOnCancelListener(this.params.getOnCancelListener());
            t10.setOnDismissListener(this.params.getOnDismissListener());
            DialogInterface.OnKeyListener onKeyListener = this.params.getOnKeyListener();
            if (onKeyListener != null) {
                t10.setOnKeyListener(onKeyListener);
            }
            return t10;
        }

        public final Builder setIconContent(int i10, CharSequence charSequence, int i11, CharSequence charSequence2, int i12) {
            return setIconContent$default(this, i10, charSequence, i11, charSequence2, i12, (DialogInterface.OnClickListener) null, 32, (Object) null);
        }

        public Builder setMessage(CharSequence message) {
            this.params.setMessage(message);
            return this;
        }

        public Builder setTitle(CharSequence title) {
            this.params.setTitle(title);
            return this;
        }

        public Builder setIcon(Drawable icon) {
            this.params.setIcon(icon);
            this.params.setIconId(0);
            return this;
        }

        public final Builder setIconContent(Drawable drawable, CharSequence charSequence, Drawable drawable2, CharSequence charSequence2) {
            return setIconContent$default(this, drawable, charSequence, drawable2, charSequence2, 0, (DialogInterface.OnClickListener) null, 48, (Object) null);
        }

        public Builder setItems(CharSequence[] items, DialogInterface.OnClickListener listener) {
            this.params.setItems(items);
            this.params.setOnClickListener(listener);
            return this;
        }

        public Builder setNegativeButton(CharSequence text, DialogInterface.OnClickListener listener) {
            this.params.setNegativeButtonText(text);
            this.params.setNegativeButtonListener(listener);
            return this;
        }

        public Builder setNeutralButton(CharSequence text, DialogInterface.OnClickListener listener) {
            this.params.setNeutralButtonText(text);
            this.params.setNeutralButtonListener(listener);
            return this;
        }

        public Builder setPositiveButton(CharSequence text, DialogInterface.OnClickListener listener) {
            this.params.setPositiveButtonText(text);
            this.params.setPositiveButtonListener(listener);
            return this;
        }

        public Builder setIconBadge(Drawable icon) {
            this.params.setIconBadge(icon);
            return this;
        }

        public final Builder setIconContent(Drawable drawable, CharSequence charSequence, Drawable drawable2, CharSequence charSequence2, int i10) {
            return setIconContent$default(this, drawable, charSequence, drawable2, charSequence2, i10, (DialogInterface.OnClickListener) null, 32, (Object) null);
        }

        public Builder setListItems(CharSequence[] items, DialogInterface.OnClickListener listener) {
            StepOSAlertParams stepOSAlertParams = this.params;
            ArrayList<Pair<String, String>> arrayList = null;
            if (items != null) {
                ArrayList<Pair<String, String>> arrayList2 = new ArrayList<>(items.length);
                int length = items.length;
                for (int i10 = 0; i10 < length; i10++) {
                    CharSequence charSequence = items[i10];
                    String string = charSequence != null ? charSequence.toString() : null;
                    if (string == null) {
                        string = "";
                    }
                    arrayList2.add(Pair.create(string, ""));
                }
                arrayList = arrayList2;
            }
            stepOSAlertParams.setListItems(arrayList);
            this.params.setOnClickListener(listener);
            this.params.setHasIconContent(false);
            return this;
        }

        public Builder setIconContent(int leftIconRes, CharSequence leftLabel, int rightIconRes, CharSequence rightLabel, int selectedIndex, DialogInterface.OnClickListener listener) {
            this.params.setHasIconContent(true);
            this.params.setIconContentLeftIcon(null);
            this.params.setIconContentLeftIconId(leftIconRes);
            this.params.setIconContentLeftLabel(leftLabel);
            this.params.setIconContentRightIcon(null);
            this.params.setIconContentRightIconId(rightIconRes);
            this.params.setIconContentRightLabel(rightLabel);
            this.params.setIconContentSelectedIndex(selectedIndex);
            this.params.setIconContentListener(listener);
            this.params.setListItems(null);
            this.params.setView(null);
            this.params.setViewLayoutResId(0);
            return this;
        }

        public Builder setItems(int itemsId, DialogInterface.OnClickListener listener, boolean isCenter) {
            setItems(itemsId, listener);
            this.params.setListItemCenter(isCenter);
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] items, boolean[] checkedItems, DialogInterface.OnMultiChoiceClickListener listener) {
            this.params.setItems(items);
            this.params.setOnCheckboxClickListener(listener);
            this.params.setCheckedItems(checkedItems);
            this.params.setMultiChoice(true);
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] items, int checkedItem, DialogInterface.OnClickListener listener) {
            this.params.setItems(items);
            this.params.setOnClickListener(listener);
            this.params.setCheckedItem(checkedItem);
            this.params.setSingleChoice(true);
            return this;
        }

        public Builder setView(View view) {
            this.params.setView(view);
            this.params.setViewLayoutResId(0);
            this.params.setViewSpacingSpecified(false);
            this.params.setHasIconContent(false);
            return this;
        }

        public /* synthetic */ Builder(Context context, int i10, int i11, kotlin.jvm.internal.i iVar) {
            this(context, (i11 & 2) != 0 ? 0 : i10);
        }

        public Builder setItems(CharSequence[] items, DialogInterface.OnClickListener listener, boolean isCenter) {
            setItems(items, listener);
            this.params.setListItemCenter(isCenter);
            return this;
        }

        public Builder setItems(int itemsId, DialogInterface.OnClickListener listener, boolean isCenter, ColorStateList color) {
            setItems(itemsId, listener, isCenter);
            this.params.setListItemColor(color);
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String isCheckedColumn, String labelColumn, DialogInterface.OnMultiChoiceClickListener listener) {
            this.params.setCursor(cursor);
            this.params.setOnCheckboxClickListener(listener);
            this.params.setCheckedColumn(isCheckedColumn);
            this.params.setLabelColumn(labelColumn);
            this.params.setMultiChoice(true);
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int checkedItem, String labelColumn, DialogInterface.OnClickListener listener) {
            this.params.setCursor(cursor);
            this.params.setOnClickListener(listener);
            this.params.setCheckedItem(checkedItem);
            this.params.setLabelColumn(labelColumn);
            this.params.setSingleChoice(true);
            return this;
        }

        public Builder setView(View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight, int viewSpacingBottom) {
            this.params.setView(view);
            this.params.setViewLayoutResId(0);
            this.params.setViewSpacingSpecified(true);
            this.params.setViewSpacingLeft(viewSpacingLeft);
            this.params.setViewSpacingTop(viewSpacingTop);
            this.params.setViewSpacingRight(viewSpacingRight);
            this.params.setViewSpacingBottom(viewSpacingBottom);
            this.params.setHasIconContent(false);
            return this;
        }

        public Builder setItems(CharSequence[] items, DialogInterface.OnClickListener listener, boolean isCenter, ColorStateList color) {
            setItems(items, listener, isCenter);
            this.params.setListItemColor(color);
            return this;
        }

        public Builder setItems(int itemsId, DialogInterface.OnClickListener listener, boolean isCenter, ColorStateList[] colors) {
            setItems(itemsId, listener, isCenter);
            this.params.setListItemColors(colors);
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter adapter, int checkedItem, DialogInterface.OnClickListener listener) {
            this.params.setAdapter(adapter);
            this.params.setOnClickListener(listener);
            this.params.setCheckedItem(checkedItem);
            this.params.setSingleChoice(true);
            return this;
        }

        public Builder setItems(CharSequence[] items, DialogInterface.OnClickListener listener, boolean isCenter, ColorStateList[] colors) {
            setItems(items, listener, isCenter);
            this.params.setListItemColors(colors);
            return this;
        }

        public Builder setIconContent(Drawable leftIcon, CharSequence leftLabel, Drawable rightIcon, CharSequence rightLabel, int selectedIndex, DialogInterface.OnClickListener listener) {
            this.params.setHasIconContent(true);
            this.params.setIconContentLeftIcon(leftIcon);
            this.params.setIconContentLeftIconId(0);
            this.params.setIconContentLeftLabel(leftLabel);
            this.params.setIconContentRightIcon(rightIcon);
            this.params.setIconContentRightIconId(0);
            this.params.setIconContentRightLabel(rightLabel);
            this.params.setIconContentSelectedIndex(selectedIndex);
            this.params.setIconContentListener(listener);
            this.params.setListItems(null);
            this.params.setView(null);
            this.params.setViewLayoutResId(0);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/dialog/StepOSAlertDialog$ButtonColor;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface ButtonColor {
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/dialog/StepOSAlertDialog$ButtonLayout;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface ButtonLayout {
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stepos/widget/dialog/StepOSAlertDialog$Companion;", "", "<init>", "()V", "BUTTON_LAYOUT_AUTO", "", "BUTTON_LAYOUT_HORIZONTAL", "BUTTON_LAYOUT_VERTICAL", "COLOR_NORMAL", "COLOR_BLUE", "COLOR_RED", "COLOR_POLESTAR", "resolveDialogTheme", "context", "Landroid/content/Context;", "resId", "resolveDialogTheme$StepOSWidget_release", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final int resolveDialogTheme$StepOSWidget_release(Context context, int resId) {
            kotlin.jvm.internal.p.i(context, "context");
            if (((resId >>> 24) & 255) >= 1) {
                return resId;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.steposAlertDialogTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            return i10 != 0 ? i10 : R.style.StepOSTheme_Dialog_Alert;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSAlertDialog(Context context, int i10) {
        super(context, INSTANCE.resolveDialogTheme$StepOSWidget_release(context, i10));
        kotlin.jvm.internal.p.i(context, "context");
        Context context2 = getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        Window window = getWindow();
        if (window == null) {
            throw new IllegalStateException("Dialog window is null; check the dialog theme");
        }
        this.controller = new StepOSAlertController(context2, this, window);
    }

    public static /* synthetic */ void setIconContent$default(StepOSAlertDialog stepOSAlertDialog, int i10, CharSequence charSequence, int i11, CharSequence charSequence2, int i12, DialogInterface.OnClickListener onClickListener, int i13, Object obj) throws Resources.NotFoundException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIconContent");
        }
        if ((i13 & 16) != 0) {
            i12 = 0;
        }
        int i14 = i12;
        if ((i13 & 32) != 0) {
            onClickListener = null;
        }
        stepOSAlertDialog.setIconContent(i10, charSequence, i11, charSequence2, i14, onClickListener);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.controller.clearPendingMessages();
        super.dismiss();
    }

    public StepOSButton getButton(int whichButton) {
        return this.controller.getButton(whichButton);
    }

    public final int getButtonLayout() {
        return this.controller.getButtonLayout();
    }

    public final y7.o getGlassEffect() {
        return this.controller.getGlassEffect();
    }

    public final Drawable getIconBadge() {
        return this.controller.getIconBadge();
    }

    public ListView getListView() {
        return this.controller.getListView();
    }

    public final int getMessageMaxLines() {
        return this.controller.getMessageMaxLines();
    }

    public final int getTitleMaxLines() {
        return this.controller.getTitleMaxLines();
    }

    public final boolean isGlassEnabled() {
        return this.controller.getIsGlassEnabled();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle savedInstanceState) throws Resources.NotFoundException {
        super.onCreate(savedInstanceState);
        this.controller.installContent();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        return this.controller.onKeyDown(event) || super.onKeyDown(keyCode, event);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        return this.controller.onKeyUp(event) || super.onKeyUp(keyCode, event);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.controller.setUpAnimation();
    }

    @Override // android.app.Dialog
    public void onStop() {
        this.controller.clearPendingMessages();
        super.onStop();
    }

    public void setAutoShowSoftInput(boolean show) {
        this.controller.setAutoShowSoftInput(show);
    }

    public void setButton(int whichButton, CharSequence text, Message msg) {
        this.controller.setButton(whichButton, text, null, msg, null);
    }

    public final void setButtonLayout(int i10) {
        this.controller.setButtonLayout(i10);
    }

    public void setButtonTextColor(int whichButton, int colorResId) {
        this.controller.setButtonTextColor(whichButton, colorResId);
    }

    public void setCustomPaddingRule(int space1, int space2, int space3, int space4) {
        this.controller.setCustomPaddingRule(space1, space2, space3, space4);
    }

    public void setCustomTitle(View customTitleView) throws Resources.NotFoundException {
        this.controller.setCustomTitle(customTitleView);
    }

    public final void setGlassEffect(y7.o oVar) {
        this.controller.setGlassEffect(oVar);
    }

    public final void setGlassEnabled(boolean z10) {
        this.controller.setGlassEnabled(z10);
    }

    public void setHighLightButton(int whichButton, int color) {
        this.controller.setHighLightButton(whichButton, color);
    }

    public void setIcon(int resId) throws Resources.NotFoundException {
        this.controller.setIcon(resId);
    }

    public void setIconAttribute(int attrId) throws Resources.NotFoundException {
        StepOSAlertController stepOSAlertController = this.controller;
        stepOSAlertController.setIcon(stepOSAlertController.getIconAttributeResId(attrId));
    }

    public final void setIconBadge(Drawable drawable) throws Resources.NotFoundException {
        this.controller.setIconBadge(drawable);
    }

    public final void setIconBadgeResource(int resId) throws Resources.NotFoundException {
        setIconBadge(resId == 0 ? null : C4027a.b(getContext(), resId));
    }

    public final void setIconContent(int i10, CharSequence charSequence, int i11, CharSequence charSequence2) throws Resources.NotFoundException {
        setIconContent$default(this, i10, charSequence, i11, charSequence2, 0, (DialogInterface.OnClickListener) null, 48, (Object) null);
    }

    public void setListItems(ArrayList<Pair<String, String>> items, DialogInterface.OnClickListener listener) throws Resources.NotFoundException {
        this.controller.setListItems(items, listener);
    }

    public void setListItemsScrollbarEnabled(boolean enabled) {
        this.controller.setListItemsScrollbarEnabled(enabled);
    }

    public void setMaxHeight(int height) {
        this.controller.setMaxHeight(height);
    }

    public void setMessage(CharSequence message) throws Resources.NotFoundException {
        this.controller.setMessage(message);
    }

    public final void setMessageMaxLines(int i10) {
        this.controller.setMessageMaxLines(i10);
    }

    public void setMessageMovementMethod(MovementMethod movementMethod) {
        this.controller.setMessageMovementMethod(movementMethod);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence title) throws Resources.NotFoundException {
        super.setTitle(title);
        this.controller.setTitle(title);
    }

    public final void setTitleMaxLines(int i10) {
        this.controller.setTitleMaxLines(i10);
    }

    public void setView(View view) throws Resources.NotFoundException {
        this.controller.setView(view);
    }

    public static /* synthetic */ void setIconContent$default(StepOSAlertDialog stepOSAlertDialog, Drawable drawable, CharSequence charSequence, Drawable drawable2, CharSequence charSequence2, int i10, DialogInterface.OnClickListener onClickListener, int i11, Object obj) throws Resources.NotFoundException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIconContent");
        }
        if ((i11 & 16) != 0) {
            i10 = 0;
        }
        int i12 = i10;
        if ((i11 & 32) != 0) {
            onClickListener = null;
        }
        stepOSAlertDialog.setIconContent(drawable, charSequence, drawable2, charSequence2, i12, onClickListener);
    }

    public void setButton(int whichButton, CharSequence text, DialogInterface.OnClickListener listener) {
        this.controller.setButton(whichButton, text, listener, null, null);
    }

    public void setIcon(Drawable icon) throws Resources.NotFoundException {
        this.controller.setIcon(icon);
    }

    public final void setIconContent(int i10, CharSequence charSequence, int i11, CharSequence charSequence2, int i12) throws Resources.NotFoundException {
        setIconContent$default(this, i10, charSequence, i11, charSequence2, i12, (DialogInterface.OnClickListener) null, 32, (Object) null);
    }

    public void setView(View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight, int viewSpacingBottom) throws Resources.NotFoundException {
        this.controller.setView(view, viewSpacingLeft, viewSpacingTop, viewSpacingRight, viewSpacingBottom);
    }

    public void setButton(int whichButton, CharSequence text, Drawable icon, DialogInterface.OnClickListener listener) {
        this.controller.setButton(whichButton, text, listener, null, icon);
    }

    public final void setIconContent(Drawable drawable, CharSequence charSequence, Drawable drawable2, CharSequence charSequence2) throws Resources.NotFoundException {
        setIconContent$default(this, drawable, charSequence, drawable2, charSequence2, 0, (DialogInterface.OnClickListener) null, 48, (Object) null);
    }

    @Override // android.app.Dialog
    public void setTitle(int titleId) throws Resources.NotFoundException {
        setTitle(getContext().getText(titleId));
    }

    public final void setIconContent(Drawable drawable, CharSequence charSequence, Drawable drawable2, CharSequence charSequence2, int i10) throws Resources.NotFoundException {
        setIconContent$default(this, drawable, charSequence, drawable2, charSequence2, i10, (DialogInterface.OnClickListener) null, 32, (Object) null);
    }

    public void setIconContent(int leftIconRes, CharSequence leftLabel, int rightIconRes, CharSequence rightLabel, int selectedIndex, DialogInterface.OnClickListener listener) throws Resources.NotFoundException {
        this.controller.setIconContent(null, leftIconRes, leftLabel, null, rightIconRes, rightLabel, selectedIndex, listener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSAlertDialog(Context context) {
        this(context, 0);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public void setIconContent(Drawable leftIcon, CharSequence leftLabel, Drawable rightIcon, CharSequence rightLabel, int selectedIndex, DialogInterface.OnClickListener listener) throws Resources.NotFoundException {
        this.controller.setIconContent(leftIcon, 0, leftLabel, rightIcon, 0, rightLabel, selectedIndex, listener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSAlertDialog(Context context, boolean z10, DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        kotlin.jvm.internal.p.i(context, "context");
        setCancelable(z10);
        setOnCancelListener(onCancelListener);
    }
}
