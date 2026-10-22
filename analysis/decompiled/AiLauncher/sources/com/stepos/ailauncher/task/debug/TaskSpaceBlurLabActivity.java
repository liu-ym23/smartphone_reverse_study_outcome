package com.stepos.ailauncher.task.debug;

import Z8.C1173v;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SwitchCompat;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.wake.blur.BlurConfig;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView;
import com.stepos.ailauncher.task.R$color;
import com.stepos.ailauncher.task.R$dimen;
import com.stepos.ailauncher.task.R$drawable;
import com.stepos.ailauncher.task.R$string;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5074l;
import r9.C5227b;
import v9.C5685n;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 \u008a\u00012\u00020\u0001:\b\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\tJ\u000f\u0010\u0013\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\tJ#\u0010\u0019\u001a\u00020\u0004*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ3\u0010!\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001c2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00040\u001eH\u0002¢\u0006\u0004\b!\u0010\"Jc\u0010)\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00152\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u001eH\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010\u0003J\u000f\u0010,\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010\u0003J\u000f\u0010-\u001a\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010\u0003J\u000f\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0004\b.\u0010\u0003J\u0019\u00101\u001a\u0002002\b\b\u0001\u0010/\u001a\u00020\u0017H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u000203H\u0002¢\u0006\u0004\b4\u00105J5\u0010;\u001a\u0002032\u0006\u00106\u001a\u00020\u00172\u0006\u00108\u001a\u0002072\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010:\u001a\u00020\u0017H\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0017H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0017H\u0002¢\u0006\u0004\b?\u0010>J\u000f\u0010@\u001a\u00020\u0017H\u0002¢\u0006\u0004\b@\u0010>J\u000f\u0010A\u001a\u00020\u0017H\u0002¢\u0006\u0004\bA\u0010>J\u0017\u0010B\u001a\u00020\u00152\u0006\u00106\u001a\u00020\u0017H\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\bD\u0010CJ\u000f\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0015H\u0002¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0015H\u0002¢\u0006\u0004\bJ\u0010IJ\u0017\u0010L\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u0017H\u0002¢\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001a\u00020\u00172\u0006\u0010K\u001a\u000207H\u0002¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u0017H\u0002¢\u0006\u0004\bP\u0010>J\u000f\u0010Q\u001a\u00020\u0017H\u0002¢\u0006\u0004\bQ\u0010>J\u001b\u0010T\u001a\u00020R*\u00020R2\u0006\u0010S\u001a\u00020\u0017H\u0002¢\u0006\u0004\bT\u0010UJ\u0019\u0010X\u001a\u00020\u00042\b\u0010W\u001a\u0004\u0018\u00010VH\u0014¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020\u0004H\u0014¢\u0006\u0004\bZ\u0010\u0003R\u0014\u0010\\\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020E0^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020b0a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010`R\u0016\u0010e\u001a\u00020d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010h\u001a\u00020g8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010j\u001a\u00020\u00078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010l\u001a\u00020\u00078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bl\u0010kR\u0016\u0010m\u001a\u00020\u00078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bm\u0010kR\u0016\u0010n\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010p\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010r\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010kR\u0018\u0010t\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010v\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010oR\u0018\u0010w\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010oR\u0018\u0010x\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010z\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010yR\u0018\u0010{\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010yR\u0018\u0010|\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010yR\u0018\u0010}\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010yR\u0018\u0010~\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010yR\u0018\u0010\u007f\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010yR\u0018\u0010\u0080\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010\u0012R\u0019\u0010\u0081\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0019\u0010\u0083\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0082\u0001R\u0019\u0010\u0084\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0082\u0001R\u0019\u0010\u0085\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0082\u0001R\u0019\u0010\u0086\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0082\u0001R\u0019\u0010\u0087\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0082\u0001R\u0017\u0010:\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b:\u0010\u0082\u0001R\u0019\u0010\u0088\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0082\u0001R\u0019\u0010\u0089\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0082\u0001¨\u0006\u008f\u0001"}, d2 = {"Lcom/stepos/ailauncher/task/debug/TaskSpaceBlurLabActivity;", "Lz5/a;", "<init>", "()V", "LY8/t;", "X", "N0", "Landroid/view/View;", "c0", "()Landroid/view/View;", "y0", "U0", "x0", "w0", "b0", "d0", "E0", "e0", "Z", "v0", "Landroid/widget/LinearLayout;", "", "text", "", ConstConfig.KEY_VIEW_ALPHA_PROPERTY, "P", "(Landroid/widget/LinearLayout;Ljava/lang/String;I)V", "title", "", "checked", "Lkotlin/Function1;", "onChanged", "Landroidx/appcompat/widget/SwitchCompat;", "C0", "(Ljava/lang/String;ZLp9/l;)Landroidx/appcompat/widget/SwitchCompat;", "min", "max", "initial", "suffix", "Landroid/widget/SeekBar;", "onSeekBarCreated", "z0", "(Ljava/lang/String;IIILjava/lang/String;Lp9/l;Lp9/l;)Landroid/view/View;", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "X0", "Y", "textRes", "Landroid/widget/TextView;", "M0", "(I)Landroid/widget/TextView;", "Landroid/graphics/drawable/GradientDrawable;", "L0", "()Landroid/graphics/drawable/GradientDrawable;", "color", "", "radiusDp", "strokeColor", "strokeWidthDp", "S0", "(IFLjava/lang/Integer;I)Landroid/graphics/drawable/GradientDrawable;", "U", "()I", "Q0", "W0", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "(I)Ljava/lang/String;", "R", "Lcom/stepos/ailauncher/task/debug/TaskSpaceBlurLabActivity$b;", "H0", "()Lcom/stepos/ailauncher/task/debug/TaskSpaceBlurLabActivity$b;", "I0", "()Ljava/lang/String;", "R0", UxipConstants.f30680s, "K0", "(I)I", "J0", "(F)I", "V0", "O0", "Landroid/widget/LinearLayout$LayoutParams;", "marginDp", "Y0", "(Landroid/widget/LinearLayout$LayoutParams;I)Landroid/widget/LinearLayout$LayoutParams;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Lcom/stepos/ailauncher/chat/wake/blur/c;", "cardBlur", "Lcom/stepos/ailauncher/chat/wake/blur/c;", "", "previewBackgrounds", "Ljava/util/List;", "", "Landroid/widget/Button;", "backgroundButtons", "Lcom/stepos/ailauncher/task/debug/TaskSpaceBlurLabActivity$c;", "backgroundView", "Lcom/stepos/ailauncher/task/debug/TaskSpaceBlurLabActivity$c;", "Landroid/widget/FrameLayout;", "previewCard", "Landroid/widget/FrameLayout;", "blurBg", "Landroid/view/View;", "baseBg", "overlayBg", "summaryText", "Landroid/widget/TextView;", "blurSwitch", "Landroidx/appcompat/widget/SwitchCompat;", "toolbarView", "Landroid/widget/PopupWindow;", "previewPopup", "Landroid/widget/PopupWindow;", "selectedBackgroundLabel", "previewLabel", "baseAlphaSeek", "Landroid/widget/SeekBar;", "blurRadiusSeek", "cornerRadiusSeek", "overlayAlphaSeek", "strokeAlphaSeek", "blurTintAlphaSeek", "cardHeightSeek", "blurEnabled", "blurRadiusDp", "I", "cornerRadiusDp", "baseAlpha", "overlayAlpha", "strokeAlpha", "blurTintAlpha", "cardHeightDp", "selectedBackgroundIndex", "Companion", Const.INTENT_KEY_PKGNAME, "PreviewBackgroundStyle", "c", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskSpaceBlurLabActivity extends ActivityC6361a {
    private static final a Companion = new a(null);

    @Deprecated
    public static final int PREVIEW_SLOT_HEIGHT_DP = 250;
    private c backgroundView;
    private SeekBar baseAlphaSeek;
    private View baseBg;
    private View blurBg;
    private SeekBar blurRadiusSeek;
    private SwitchCompat blurSwitch;
    private int blurTintAlpha;
    private SeekBar blurTintAlphaSeek;
    private SeekBar cardHeightSeek;
    private SeekBar cornerRadiusSeek;
    private SeekBar overlayAlphaSeek;
    private View overlayBg;
    private FrameLayout previewCard;
    private TextView previewLabel;
    private PopupWindow previewPopup;
    private int selectedBackgroundIndex;
    private TextView selectedBackgroundLabel;
    private SeekBar strokeAlphaSeek;
    private TextView summaryText;
    private View toolbarView;
    private final com.stepos.ailauncher.chat.wake.blur.c cardBlur = new com.stepos.ailauncher.chat.wake.blur.c();
    private final List<PreviewBackground> previewBackgrounds = C1173v.p(new PreviewBackground(R$string.task_space_blur_lab_background_grid, PreviewBackgroundStyle.GRID), new PreviewBackground(R$string.task_space_blur_lab_background_bands, PreviewBackgroundStyle.BANDS), new PreviewBackground(R$string.task_space_blur_lab_background_checker, PreviewBackgroundStyle.CHECKER), new PreviewBackground(R$string.task_space_blur_lab_background_spots, PreviewBackgroundStyle.SPOTS));
    private final List<Button> backgroundButtons = new ArrayList();
    private boolean blurEnabled = true;
    private int blurRadiusDp = 20;
    private int cornerRadiusDp = 16;
    private int baseAlpha = 153;
    private int overlayAlpha = 5;
    private int strokeAlpha = 26;
    private int strokeWidthDp = 1;
    private int cardHeightDp = 78;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/task/debug/TaskSpaceBlurLabActivity$PreviewBackgroundStyle;", "", "<init>", "(Ljava/lang/String;I)V", "GRID", "BANDS", "CHECKER", "SPOTS", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PreviewBackgroundStyle {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ PreviewBackgroundStyle[] $VALUES;
        public static final PreviewBackgroundStyle GRID = new PreviewBackgroundStyle("GRID", 0);
        public static final PreviewBackgroundStyle BANDS = new PreviewBackgroundStyle("BANDS", 1);
        public static final PreviewBackgroundStyle CHECKER = new PreviewBackgroundStyle("CHECKER", 2);
        public static final PreviewBackgroundStyle SPOTS = new PreviewBackgroundStyle("SPOTS", 3);

        private static final /* synthetic */ PreviewBackgroundStyle[] $values() {
            return new PreviewBackgroundStyle[]{GRID, BANDS, CHECKER, SPOTS};
        }

        static {
            PreviewBackgroundStyle[] previewBackgroundStyleArr$values = $values();
            $VALUES = previewBackgroundStyleArr$values;
            $ENTRIES = kotlin.enums.a.a(previewBackgroundStyleArr$values);
        }

        private PreviewBackgroundStyle(String str, int i10) {
        }

        public static InterfaceC4149a<PreviewBackgroundStyle> getEntries() {
            return $ENTRIES;
        }

        public static PreviewBackgroundStyle valueOf(String str) {
            return (PreviewBackgroundStyle) Enum.valueOf(PreviewBackgroundStyle.class, str);
        }

        public static PreviewBackgroundStyle[] values() {
            return (PreviewBackgroundStyle[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/task/debug/TaskSpaceBlurLabActivity$a;", "", "<init>", "()V", "", "PREVIEW_SLOT_HEIGHT_DP", "I", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/task/debug/TaskSpaceBlurLabActivity$b;", "", "", "titleRes", "Lcom/stepos/ailauncher/task/debug/TaskSpaceBlurLabActivity$PreviewBackgroundStyle;", "style", "<init>", "(ILcom/stepos/ailauncher/task/debug/TaskSpaceBlurLabActivity$PreviewBackgroundStyle;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/task/debug/TaskSpaceBlurLabActivity$PreviewBackgroundStyle;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/task/debug/TaskSpaceBlurLabActivity$PreviewBackgroundStyle;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.debug.TaskSpaceBlurLabActivity$b, reason: from toString */
    public static final /* data */ class PreviewBackground {
        private final PreviewBackgroundStyle style;
        private final int titleRes;

        public PreviewBackground(int i10, PreviewBackgroundStyle style) {
            kotlin.jvm.internal.p.i(style, "style");
            this.titleRes = i10;
            this.style = style;
        }

        /* renamed from: a, reason: from getter */
        public final PreviewBackgroundStyle getStyle() {
            return this.style;
        }

        /* renamed from: b, reason: from getter */
        public final int getTitleRes() {
            return this.titleRes;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PreviewBackground)) {
                return false;
            }
            PreviewBackground previewBackground = (PreviewBackground) other;
            return this.titleRes == previewBackground.titleRes && this.style == previewBackground.style;
        }

        public int hashCode() {
            return (Integer.hashCode(this.titleRes) * 31) + this.style.hashCode();
        }

        public String toString() {
            return "PreviewBackground(titleRes=" + this.titleRes + ", style=" + this.style + ")";
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u001f\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR*\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/stepos/ailauncher/task/debug/TaskSpaceBlurLabActivity$c;", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/graphics/Canvas;", "canvas", "LY8/t;", "onDraw", "(Landroid/graphics/Canvas;)V", "e", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "colors", Const.INTENT_KEY_UMID, "(Landroid/graphics/Canvas;[I)V", "", "x", "y", "radius", "", "color", "f", "(Landroid/graphics/Canvas;FFFI)V", UxipConstants.f30680s, Const.INTENT_KEY_APIKEY, "(F)F", "Lcom/stepos/ailauncher/task/debug/TaskSpaceBlurLabActivity$PreviewBackgroundStyle;", "style", "Lcom/stepos/ailauncher/task/debug/TaskSpaceBlurLabActivity$PreviewBackgroundStyle;", "getStyle", "()Lcom/stepos/ailauncher/task/debug/TaskSpaceBlurLabActivity$PreviewBackgroundStyle;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/task/debug/TaskSpaceBlurLabActivity$PreviewBackgroundStyle;)V", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "Landroid/graphics/RectF;", "rect", "Landroid/graphics/RectF;", "density", "F", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends View {
        private final float density;
        private final Paint paint;
        private final RectF rect;
        private PreviewBackgroundStyle style;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PreviewBackgroundStyle.values().length];
                try {
                    iArr[PreviewBackgroundStyle.GRID.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PreviewBackgroundStyle.BANDS.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PreviewBackgroundStyle.CHECKER.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[PreviewBackgroundStyle.SPOTS.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context) {
            super(context);
            kotlin.jvm.internal.p.i(context, "context");
            this.style = PreviewBackgroundStyle.GRID;
            this.paint = new Paint(1);
            this.rect = new RectF();
            this.density = getResources().getDisplayMetrics().density;
        }

        public final float a(float value) {
            return value * this.density;
        }

        public final void b(Canvas canvas) {
            d(canvas, new int[]{Color.parseColor("#190A2E"), Color.parseColor("#06374A"), Color.parseColor("#3C140C")});
            canvas.save();
            canvas.rotate(-18.0f, getWidth() / 2.0f, getHeight() / 2.0f);
            float fA = a(68.0f);
            int[] iArr = {Color.argb(184, 255, 83, 83), Color.argb(170, 255, 210, 63), Color.argb(com.stepos.ailauncher.chat.wake.circle.F.LOOP_END_FRAME, 53, 224, 161), Color.argb(168, 77, DidiCardView.FINISHED_SUMMARY_WIDTH_DP, 255), Color.argb(154, 193, 92, 255)};
            float f10 = -getHeight();
            int i10 = 0;
            while (f10 < getHeight() * 2.0f) {
                this.paint.setColor(iArr[i10 % 5]);
                this.rect.set((-getWidth()) * 0.3f, f10, getWidth() * 1.3f, f10 + fA);
                canvas.drawRect(this.rect, this.paint);
                f10 += 1.35f * fA;
                i10++;
            }
            canvas.restore();
        }

        public final void c(Canvas canvas) {
            d(canvas, new int[]{Color.parseColor("#090909"), Color.parseColor("#121212")});
            float fA = a(42.0f);
            float f10 = 0.0f;
            int i10 = 0;
            while (f10 < getHeight() + fA) {
                float f11 = 0.0f;
                int i11 = 0;
                while (f11 < getWidth() + fA) {
                    int i12 = (i10 + i11) % 4;
                    this.paint.setColor(i12 != 0 ? i12 != 1 ? i12 != 2 ? Color.argb(200, 255, 77, 127) : Color.argb(200, 38, 136, 255) : Color.argb(224, 12, 16, 22) : Color.argb(208, 255, 255, 255));
                    float f12 = f11 + fA;
                    this.rect.set(f11, f10, f12, f10 + fA);
                    canvas.drawRect(this.rect, this.paint);
                    i11++;
                    f11 = f12;
                }
                f10 += fA;
                i10++;
            }
        }

        public final void d(Canvas canvas, int[] colors) {
            this.paint.setShader(new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), colors, (float[]) null, Shader.TileMode.CLAMP));
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.paint);
            this.paint.setShader(null);
            this.paint.setStyle(Paint.Style.FILL);
        }

        public final void e(Canvas canvas) {
            d(canvas, new int[]{Color.parseColor("#05070B"), Color.parseColor("#17253B"), Color.parseColor("#090A10")});
            float fA = a(28.0f);
            this.paint.setStyle(Paint.Style.FILL);
            int i10 = 0;
            float f10 = 0.0f;
            while (f10 < getHeight() + fA) {
                int i11 = 0;
                float f11 = 0.0f;
                while (f11 < getWidth() + fA) {
                    if ((i10 + i11) % 3 == 0) {
                        this.paint.setColor(Color.argb((i10 * i11) % 5 == 0 ? 112 : 52, 255, 255, 255));
                        float f12 = 0.18f * fA;
                        float f13 = 0.46f * fA;
                        this.rect.set(f11 + f12, f12 + f10, f11 + f13, f13 + f10);
                        canvas.drawRect(this.rect, this.paint);
                    }
                    f11 += fA;
                    i11++;
                }
                f10 += fA;
                i10++;
            }
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(a(1.0f));
            this.paint.setColor(Color.argb(38, 255, 255, 255));
            for (float f14 = 0.0f; f14 < getWidth(); f14 += fA) {
                canvas.drawLine(f14, 0.0f, f14, getHeight(), this.paint);
            }
            for (float f15 = 0.0f; f15 < getHeight(); f15 += fA) {
                canvas.drawLine(0.0f, f15, getWidth(), f15, this.paint);
            }
            this.paint.setStyle(Paint.Style.FILL);
        }

        public final void f(Canvas canvas, float x10, float y10, float radius, int color) {
            this.paint.setShader(new RadialGradient(x10, y10, radius, new int[]{color, 0}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
            canvas.drawCircle(x10, y10, radius, this.paint);
            this.paint.setShader(null);
        }

        public final void g(Canvas canvas) {
            d(canvas, new int[]{Color.parseColor("#050510"), Color.parseColor("#101C2F"), Color.parseColor("#170814")});
            f(canvas, getWidth() * 0.2f, getHeight() * 0.24f, getWidth() * 0.42f, Color.parseColor("#DD33D6FF"));
            f(canvas, getWidth() * 0.78f, getHeight() * 0.3f, getWidth() * 0.36f, Color.parseColor("#DFFF7A45"));
            f(canvas, getWidth() * 0.5f, getHeight() * 0.58f, getWidth() * 0.48f, Color.parseColor("#CCF8FF52"));
            f(canvas, getWidth() * 0.18f, getHeight() * 0.82f, getWidth() * 0.34f, Color.parseColor("#CCB65CFF"));
        }

        public final void h(PreviewBackgroundStyle value) {
            kotlin.jvm.internal.p.i(value, "value");
            this.style = value;
            invalidate();
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            kotlin.jvm.internal.p.i(canvas, "canvas");
            int i10 = a.$EnumSwitchMapping$0[this.style.ordinal()];
            if (i10 == 1) {
                e(canvas);
                return;
            }
            if (i10 == 2) {
                b(canvas);
            } else if (i10 == 3) {
                c(canvas);
            } else {
                if (i10 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                g(canvas);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/task/debug/TaskSpaceBlurLabActivity$d", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "LY8/t;", "onProgressChanged", "(Landroid/widget/SeekBar;IZ)V", "onStartTrackingTouch", "(Landroid/widget/SeekBar;)V", "onStopTrackingTouch", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements SeekBar.OnSeekBarChangeListener {
        final /* synthetic */ int $initial;
        final /* synthetic */ InterfaceC5074l<Integer, Y8.t> $onChanged;
        final /* synthetic */ String $suffix;
        final /* synthetic */ TextView $valueText;
        final /* synthetic */ TaskSpaceBlurLabActivity this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public d(InterfaceC5074l<? super Integer, Y8.t> interfaceC5074l, TextView textView, String str, TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, int i10) {
            this.$onChanged = interfaceC5074l;
            this.$valueText = textView;
            this.$suffix = str;
            this.this$0 = taskSpaceBlurLabActivity;
            this.$initial = i10;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            TaskSpaceBlurLabActivity.B0(this.$valueText, this.$suffix, this.this$0, progress);
            if (fromUser) {
                this.$onChanged.invoke(Integer.valueOf(progress));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            this.$onChanged.invoke(Integer.valueOf(seekBar != null ? seekBar.getProgress() : this.$initial));
        }
    }

    public static /* synthetic */ View A0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, String str, int i10, int i11, int i12, String str2, InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, int i13, Object obj) {
        if ((i13 & 32) != 0) {
            interfaceC5074l = null;
        }
        return taskSpaceBlurLabActivity.z0(str, i10, i11, i12, str2, interfaceC5074l, interfaceC5074l2);
    }

    public static final void B0(TextView textView, String str, TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, int i10) {
        String str2;
        if (La.H.x0(str)) {
            str2 = i10 + " / " + taskSpaceBlurLabActivity.R(i10);
        } else {
            str2 = i10 + str;
        }
        textView.setText(str2);
    }

    public static final void D0(InterfaceC5074l interfaceC5074l, CompoundButton compoundButton, boolean z10) {
        kotlin.jvm.internal.p.i(compoundButton, "<unused var>");
        interfaceC5074l.invoke(Boolean.valueOf(z10));
    }

    private final View E0() {
        int iV0 = V0();
        LinearLayout linearLayout = new LinearLayout(this);
        this.toolbarView = linearLayout;
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(K0(12), iV0, K0(16), 0);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, K0(58) + iV0));
        TextView textView = new TextView(linearLayout.getContext());
        textView.setText("‹");
        textView.setTextSize(34.0f);
        textView.setGravity(17);
        textView.setTextColor(-1);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.debug.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskSpaceBlurLabActivity.F0(this.f28434a, view);
            }
        });
        linearLayout.addView(textView, new LinearLayout.LayoutParams(K0(42), -1));
        TextView textView2 = new TextView(linearLayout.getContext());
        textView2.setText(getString(R$string.task_space_blur_lab_title));
        textView2.setTextSize(18.0f);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setTextColor(-1);
        textView2.setGravity(16);
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(0, -1, 1.0f));
        Button button = new Button(linearLayout.getContext());
        button.setText(getString(R$string.task_space_blur_lab_copy));
        button.setTextSize(13.0f);
        button.setAllCaps(false);
        button.setTextColor(-1);
        button.setBackground(T0(this, Color.parseColor("#1FFFFFFF"), 16.0f, Integer.valueOf(Color.parseColor("#22FFFFFF")), 0, 8, null));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.debug.C
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskSpaceBlurLabActivity.G0(this.f28399a, view);
            }
        });
        linearLayout.addView(button, new LinearLayout.LayoutParams(K0(72), K0(36)));
        return linearLayout;
    }

    public static final void F0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, View view) {
        taskSpaceBlurLabActivity.finish();
    }

    public static final void G0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, View view) {
        taskSpaceBlurLabActivity.Y();
    }

    private final int J0(float value) {
        return (int) ((value * getResources().getDisplayMetrics().density) + 0.5f);
    }

    private final int K0(int value) {
        return (int) ((value * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static final void P0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity) {
        taskSpaceBlurLabActivity.U0();
        taskSpaceBlurLabActivity.S();
    }

    public static final void Q(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, int i10, View view) {
        taskSpaceBlurLabActivity.baseAlpha = i10;
        SeekBar seekBar = taskSpaceBlurLabActivity.baseAlphaSeek;
        if (seekBar != null) {
            seekBar.setProgress(i10);
        }
        taskSpaceBlurLabActivity.S();
    }

    public static /* synthetic */ GradientDrawable T0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, int i10, float f10, Integer num, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            num = null;
        }
        if ((i12 & 8) != 0) {
            i11 = 1;
        }
        return taskSpaceBlurLabActivity.S0(i10, f10, num, i11);
    }

    private final int V0() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", UxipConstants.f30662a);
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private final String W(int color) {
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format(Locale.US, "#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(color)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        return str;
    }

    private final void X0() {
        TextView textView = this.summaryText;
        if (textView == null) {
            return;
        }
        if (textView == null) {
            kotlin.jvm.internal.p.A("summaryText");
            textView = null;
        }
        textView.setText(La.w.n("\n            Preview:\n                background = " + I0() + "\n                card window = PopupWindow above Activity backdrop\n\n            BlurConfig(\n                radius = " + this.blurRadiusDp + "dp,\n                cornerRadius = " + this.cornerRadiusDp + "dp,\n                tintColor = " + W(V()) + "\n            )\n            cornerRadius is clip/card shape sync, not blur strength.\n\n            bg_taskspace_card_blur_base:\n                solid = " + W(U()) + "\n                corners = " + this.cornerRadiusDp + "dp\n\n            bg_taskspace_card_overlay:\n                solid = " + W(Q0()) + "\n                stroke = " + this.strokeWidthDp + "dp " + W(W0()) + "\n                corners = " + this.cornerRadiusDp + "dp\n\n            Preview only:\n                item height = " + this.cardHeightDp + "dp (not a blur parameter)\n\n            CrossWindowBlur supported = " + this.cardBlur.f() + "\n        "));
    }

    private final LinearLayout.LayoutParams Y0(LinearLayout.LayoutParams layoutParams, int i10) {
        layoutParams.bottomMargin = K0(i10);
        return layoutParams;
    }

    public static final void a0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, int i10, View view) {
        taskSpaceBlurLabActivity.selectedBackgroundIndex = i10;
        taskSpaceBlurLabActivity.T();
    }

    private final View c0() {
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(-16777216);
        Context context = frameLayout.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        c cVar = new c(context);
        cVar.h(H0().getStyle());
        this.backgroundView = cVar;
        frameLayout.addView(cVar, new FrameLayout.LayoutParams(-1, -1));
        View view = new View(frameLayout.getContext());
        view.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#26000000"), Color.parseColor("#33000000"), Color.parseColor("#B3050507")}));
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(E0());
        linearLayout.addView(y0());
        linearLayout.addView(d0(), new LinearLayout.LayoutParams(-1, 0, 1.0f));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private final View e0() throws Resources.NotFoundException {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(K0(20), K0(8), K0(20), K0(28));
        linearLayout.addView(M0(R$string.task_space_blur_lab_preview_background));
        linearLayout.addView(Z());
        linearLayout.addView(M0(R$string.task_space_blur_lab_section_blur));
        String string = getString(R$string.task_space_blur_lab_enable_cross_window_blur);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        SwitchCompat switchCompatC0 = C0(string, this.blurEnabled, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.D
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskSpaceBlurLabActivity.f0(this.f28400a, ((Boolean) obj).booleanValue());
            }
        });
        this.blurSwitch = switchCompatC0;
        if (switchCompatC0 == null) {
            kotlin.jvm.internal.p.A("blurSwitch");
            switchCompatC0 = null;
        }
        linearLayout.addView(switchCompatC0);
        String string2 = getString(R$string.task_space_blur_lab_blur_radius);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        linearLayout.addView(z0(string2, 0, 80, this.blurRadiusDp, "dp", new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskSpaceBlurLabActivity.g0(this.f28424a, (SeekBar) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskSpaceBlurLabActivity.n0(this.f28425a, ((Integer) obj).intValue());
            }
        }));
        String string3 = getString(R$string.task_space_blur_lab_blur_tint_alpha);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        linearLayout.addView(z0(string3, 0, 255, this.blurTintAlpha, "", new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskSpaceBlurLabActivity.o0(this.f28426a, (SeekBar) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.s
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskSpaceBlurLabActivity.p0(this.f28427a, ((Integer) obj).intValue());
            }
        }));
        linearLayout.addView(M0(R$string.task_space_blur_lab_section_visual_layer));
        linearLayout.addView(v0());
        String string4 = getString(R$string.task_space_blur_lab_base_alpha);
        kotlin.jvm.internal.p.h(string4, "getString(...)");
        linearLayout.addView(z0(string4, 0, 255, this.baseAlpha, "", new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.t
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskSpaceBlurLabActivity.q0(this.f28428a, (SeekBar) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.u
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskSpaceBlurLabActivity.r0(this.f28429a, ((Integer) obj).intValue());
            }
        }));
        String string5 = getString(R$string.task_space_blur_lab_overlay_alpha);
        kotlin.jvm.internal.p.h(string5, "getString(...)");
        linearLayout.addView(z0(string5, 0, 80, this.overlayAlpha, "", new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskSpaceBlurLabActivity.s0(this.f28430a, (SeekBar) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.w
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskSpaceBlurLabActivity.t0(this.f28431a, ((Integer) obj).intValue());
            }
        }));
        String string6 = getString(R$string.task_space_blur_lab_stroke_alpha);
        kotlin.jvm.internal.p.h(string6, "getString(...)");
        linearLayout.addView(z0(string6, 0, 128, this.strokeAlpha, "", new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.x
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskSpaceBlurLabActivity.u0(this.f28432a, (SeekBar) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.E
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskSpaceBlurLabActivity.h0(this.f28401a, ((Integer) obj).intValue());
            }
        }));
        String string7 = getString(R$string.task_space_blur_lab_stroke_width);
        kotlin.jvm.internal.p.h(string7, "getString(...)");
        linearLayout.addView(A0(this, string7, 0, 4, this.strokeWidthDp, "dp", null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.F
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskSpaceBlurLabActivity.i0(this.f28402a, ((Integer) obj).intValue());
            }
        }, 32, null));
        linearLayout.addView(M0(R$string.task_space_blur_lab_section_shape));
        String string8 = getString(R$string.task_space_blur_lab_corner_radius);
        kotlin.jvm.internal.p.h(string8, "getString(...)");
        linearLayout.addView(z0(string8, 0, 32, this.cornerRadiusDp, "dp", new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.G
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskSpaceBlurLabActivity.j0(this.f28403a, (SeekBar) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.H
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskSpaceBlurLabActivity.k0(this.f28404a, ((Integer) obj).intValue());
            }
        }));
        linearLayout.addView(M0(R$string.task_space_blur_lab_section_preview_helper));
        String string9 = getString(R$string.task_space_blur_lab_preview_card_height);
        kotlin.jvm.internal.p.h(string9, "getString(...)");
        linearLayout.addView(z0(string9, 64, 120, this.cardHeightDp, "dp", new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.I
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskSpaceBlurLabActivity.l0(this.f28405a, (SeekBar) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.J
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskSpaceBlurLabActivity.m0(this.f28406a, ((Integer) obj).intValue());
            }
        }));
        linearLayout.addView(M0(R$string.task_space_blur_lab_section_summary));
        TextView textView = new TextView(linearLayout.getContext());
        textView.setTextSize(12.0f);
        textView.setTextColor(Color.parseColor("#B3FFFFFF"));
        textView.setLineSpacing(K0(2), 1.0f);
        textView.setBackground(T0(this, Color.parseColor("#12FFFFFF"), 8.0f, Integer.valueOf(Color.parseColor("#1AFFFFFF")), 0, 8, null));
        textView.setPadding(K0(12), K0(10), K0(12), K0(10));
        this.summaryText = textView;
        linearLayout.addView(textView);
        return linearLayout;
    }

    public static final Y8.t f0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, boolean z10) {
        taskSpaceBlurLabActivity.blurEnabled = z10;
        taskSpaceBlurLabActivity.S();
        return Y8.t.f7040a;
    }

    public static final Y8.t g0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, SeekBar it) {
        kotlin.jvm.internal.p.i(it, "it");
        taskSpaceBlurLabActivity.blurRadiusSeek = it;
        return Y8.t.f7040a;
    }

    public static final Y8.t h0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, int i10) {
        taskSpaceBlurLabActivity.strokeAlpha = i10;
        taskSpaceBlurLabActivity.S();
        return Y8.t.f7040a;
    }

    public static final Y8.t i0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, int i10) {
        taskSpaceBlurLabActivity.strokeWidthDp = i10;
        taskSpaceBlurLabActivity.S();
        return Y8.t.f7040a;
    }

    public static final Y8.t j0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, SeekBar it) {
        kotlin.jvm.internal.p.i(it, "it");
        taskSpaceBlurLabActivity.cornerRadiusSeek = it;
        return Y8.t.f7040a;
    }

    public static final Y8.t k0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, int i10) {
        taskSpaceBlurLabActivity.cornerRadiusDp = i10;
        taskSpaceBlurLabActivity.S();
        return Y8.t.f7040a;
    }

    public static final Y8.t l0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, SeekBar it) {
        kotlin.jvm.internal.p.i(it, "it");
        taskSpaceBlurLabActivity.cardHeightSeek = it;
        return Y8.t.f7040a;
    }

    public static final Y8.t m0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, int i10) {
        taskSpaceBlurLabActivity.cardHeightDp = i10;
        taskSpaceBlurLabActivity.S();
        return Y8.t.f7040a;
    }

    public static final Y8.t n0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, int i10) {
        taskSpaceBlurLabActivity.blurRadiusDp = i10;
        taskSpaceBlurLabActivity.S();
        return Y8.t.f7040a;
    }

    public static final Y8.t o0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, SeekBar it) {
        kotlin.jvm.internal.p.i(it, "it");
        taskSpaceBlurLabActivity.blurTintAlphaSeek = it;
        return Y8.t.f7040a;
    }

    public static final Y8.t p0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, int i10) {
        taskSpaceBlurLabActivity.blurTintAlpha = i10;
        taskSpaceBlurLabActivity.S();
        return Y8.t.f7040a;
    }

    public static final Y8.t q0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, SeekBar it) {
        kotlin.jvm.internal.p.i(it, "it");
        taskSpaceBlurLabActivity.baseAlphaSeek = it;
        return Y8.t.f7040a;
    }

    public static final Y8.t r0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, int i10) {
        taskSpaceBlurLabActivity.baseAlpha = i10;
        taskSpaceBlurLabActivity.S();
        return Y8.t.f7040a;
    }

    public static final Y8.t s0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, SeekBar it) {
        kotlin.jvm.internal.p.i(it, "it");
        taskSpaceBlurLabActivity.overlayAlphaSeek = it;
        return Y8.t.f7040a;
    }

    public static final Y8.t t0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, int i10) {
        taskSpaceBlurLabActivity.overlayAlpha = i10;
        taskSpaceBlurLabActivity.S();
        return Y8.t.f7040a;
    }

    public static final Y8.t u0(TaskSpaceBlurLabActivity taskSpaceBlurLabActivity, SeekBar it) {
        kotlin.jvm.internal.p.i(it, "it");
        taskSpaceBlurLabActivity.strokeAlphaSeek = it;
        return Y8.t.f7040a;
    }

    public final SwitchCompat C0(String title, boolean checked, final InterfaceC5074l<? super Boolean, Y8.t> onChanged) throws Resources.NotFoundException {
        SwitchCompat switchCompat = new SwitchCompat(this);
        switchCompat.setText(title);
        switchCompat.setTextSize(14.0f);
        switchCompat.setTextColor(-1);
        switchCompat.setChecked(checked);
        switchCompat.setPadding(0, K0(4), 0, K0(12));
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.stepos.ailauncher.task.debug.y
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                TaskSpaceBlurLabActivity.D0(onChanged, compoundButton, z10);
            }
        });
        return switchCompat;
    }

    public final PreviewBackground H0() {
        List<PreviewBackground> list = this.previewBackgrounds;
        return list.get(C5685n.n(this.selectedBackgroundIndex, 0, C1173v.o(list)));
    }

    public final String I0() {
        String string = getString(H0().getTitleRes());
        kotlin.jvm.internal.p.h(string, "getString(...)");
        return string;
    }

    public final GradientDrawable L0() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#0AFFFFFF"));
        gradientDrawable.setStroke(K0(1), Color.parseColor("#33FFFFFF"));
        return gradientDrawable;
    }

    public final TextView M0(int textRes) {
        TextView textView = new TextView(this);
        textView.setText(getString(textRes));
        textView.setTextSize(13.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(Color.parseColor("#8FB1B7C9"));
        textView.setPadding(0, K0(14), 0, K0(8));
        return textView;
    }

    public final void N0() {
        float f10 = getResources().getDisplayMetrics().density;
        this.blurRadiusDp = C5227b.b(getResources().getDimensionPixelSize(R$dimen.task_space_card_blur_radius) / f10);
        this.cornerRadiusDp = C5227b.b(getResources().getDimension(R$dimen.task_space_card_radius) / f10);
        this.cardHeightDp = C5227b.b(getResources().getDimension(R$dimen.task_space_card_height) / f10);
        this.baseAlpha = Color.alpha(androidx.core.content.a.c(this, R$color.task_space_page_card_bg));
        this.blurTintAlpha = Color.alpha(androidx.core.content.a.c(this, R$color.task_space_page_card_blur_tint));
        this.overlayAlpha = Color.alpha(androidx.core.content.a.c(this, R$color.task_space_page_card_overlay));
        this.strokeAlpha = Color.alpha(androidx.core.content.a.c(this, R$color.task_space_page_card_stroke));
    }

    public final int O0() {
        int identifier = getResources().getIdentifier("navigation_bar_height", "dimen", UxipConstants.f30662a);
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final void P(LinearLayout linearLayout, String str, final int i10) {
        Button button = new Button(linearLayout.getContext());
        button.setText(str);
        button.setTextSize(12.0f);
        button.setAllCaps(false);
        button.setTextColor(-1);
        button.setBackground(T0(this, Color.parseColor("#18FFFFFF"), 12.0f, Integer.valueOf(Color.parseColor("#26FFFFFF")), 0, 8, null));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.debug.A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskSpaceBlurLabActivity.Q(this.f28395a, i10, view);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, K0(34), 1.0f);
        layoutParams.setMarginEnd(K0(6));
        Y8.t tVar = Y8.t.f7040a;
        linearLayout.addView(button, layoutParams);
    }

    public final int Q0() {
        return Color.argb(this.overlayAlpha, 255, 255, 255);
    }

    public final String R(int alpha) {
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format(Locale.US, "0x%02X", Arrays.copyOf(new Object[]{Integer.valueOf(C5685n.n(alpha, 0, 255))}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        return str;
    }

    public final String R0() {
        String string = getString(R$string.task_space_blur_lab_preview_title, I0());
        kotlin.jvm.internal.p.h(string, "getString(...)");
        return string;
    }

    public final void S() {
        FrameLayout frameLayout = this.previewCard;
        if (frameLayout == null) {
            return;
        }
        View view = null;
        if (frameLayout == null) {
            kotlin.jvm.internal.p.A("previewCard");
            frameLayout = null;
        }
        FrameLayout frameLayout2 = this.previewCard;
        if (frameLayout2 == null) {
            kotlin.jvm.internal.p.A("previewCard");
            frameLayout2 = null;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
        layoutParams.height = K0(this.cardHeightDp);
        frameLayout.setLayoutParams(layoutParams);
        View view2 = this.baseBg;
        if (view2 == null) {
            kotlin.jvm.internal.p.A("baseBg");
            view2 = null;
        }
        view2.setBackground(T0(this, U(), this.cornerRadiusDp, null, 0, 12, null));
        View view3 = this.overlayBg;
        if (view3 == null) {
            kotlin.jvm.internal.p.A("overlayBg");
            view3 = null;
        }
        view3.setBackground(S0(Q0(), this.cornerRadiusDp, Integer.valueOf(W0()), this.strokeWidthDp));
        if (this.blurEnabled) {
            com.stepos.ailauncher.chat.wake.blur.c cVar = this.cardBlur;
            View view4 = this.blurBg;
            if (view4 == null) {
                kotlin.jvm.internal.p.A("blurBg");
            } else {
                view = view4;
            }
            cVar.d(view, new BlurConfig(K0(this.blurRadiusDp), K0(this.cornerRadiusDp), V()));
        } else {
            this.cardBlur.g();
        }
        X0();
    }

    public final GradientDrawable S0(int color, float radiusDp, Integer strokeColor, int strokeWidthDp) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(J0(radiusDp));
        if (strokeColor != null && strokeWidthDp > 0) {
            gradientDrawable.setStroke(K0(strokeWidthDp), strokeColor.intValue());
        }
        return gradientDrawable;
    }

    public final void T() {
        c cVar = this.backgroundView;
        if (cVar != null) {
            if (cVar == null) {
                kotlin.jvm.internal.p.A("backgroundView");
                cVar = null;
            }
            cVar.h(H0().getStyle());
        }
        TextView textView = this.selectedBackgroundLabel;
        if (textView != null) {
            textView.setText(getString(R$string.task_space_blur_lab_current_background, I0()));
        }
        TextView textView2 = this.previewLabel;
        if (textView2 != null) {
            textView2.setText(R0());
        }
        int i10 = 0;
        for (Object obj : this.backgroundButtons) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            Button button = (Button) obj;
            boolean z10 = i10 == this.selectedBackgroundIndex;
            TaskSpaceBlurLabActivity taskSpaceBlurLabActivity = this;
            button.setBackground(T0(taskSpaceBlurLabActivity, Color.parseColor(z10 ? "#38FFFFFF" : "#18FFFFFF"), 12.0f, Integer.valueOf(Color.parseColor(z10 ? "#66FFFFFF" : "#26FFFFFF")), 0, 8, null));
            i10 = i11;
            this = taskSpaceBlurLabActivity;
        }
        this.X0();
    }

    public final int U() {
        return Color.argb(this.baseAlpha, 21, 21, 21);
    }

    public final void U0() {
        View view = this.toolbarView;
        if (view == null) {
            return;
        }
        PopupWindow popupWindow = this.previewPopup;
        if (popupWindow == null || !popupWindow.isShowing()) {
            PopupWindow popupWindow2 = new PopupWindow(x0(), -1, K0(250), false);
            popupWindow2.setTouchable(false);
            popupWindow2.setOutsideTouchable(false);
            popupWindow2.setElevation(0.0f);
            popupWindow2.setBackgroundDrawable(new ColorDrawable(0));
            popupWindow2.showAsDropDown(view, 0, 0);
            this.previewPopup = popupWindow2;
        }
    }

    public final int V() {
        int i10 = this.blurTintAlpha;
        if (i10 <= 0) {
            return 0;
        }
        return Color.argb(i10, 21, 21, 21);
    }

    public final int W0() {
        return Color.argb(this.strokeAlpha, 255, 255, 255);
    }

    public final void X() {
        getWindow().setBackgroundDrawable(new ColorDrawable(-16777216));
        getWindow().setStatusBarColor(-16777216);
        getWindow().setNavigationBarColor(-16777216);
    }

    public final void Y() {
        TextView textView = this.summaryText;
        if (textView == null) {
            kotlin.jvm.internal.p.A("summaryText");
            textView = null;
        }
        CharSequence text = textView.getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        Object systemService = getSystemService("clipboard");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(getString(R$string.task_space_blur_lab_clip_label), string));
        Toast.makeText(this, R$string.task_space_blur_lab_copied, 0).show();
    }

    public final View Z() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(linearLayout.getContext());
        textView.setTextSize(12.0f);
        textView.setTextColor(Color.parseColor("#B3FFFFFF"));
        textView.setPadding(0, 0, 0, K0(8));
        this.selectedBackgroundLabel = textView;
        linearLayout.addView(textView);
        this.backgroundButtons.clear();
        LinearLayout linearLayout2 = new LinearLayout(linearLayout.getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        final int i10 = 0;
        for (Object obj : this.previewBackgrounds) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            Button button = new Button(linearLayout2.getContext());
            button.setText(getString(((PreviewBackground) obj).getTitleRes()));
            button.setTextSize(12.0f);
            button.setAllCaps(false);
            button.setMinWidth(0);
            button.setMinHeight(0);
            button.setTextColor(-1);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.debug.B
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskSpaceBlurLabActivity.a0(this.f28397a, i10, view);
                }
            });
            this.backgroundButtons.add(button);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, K0(34), 1.0f);
            if (i10 < C1173v.o(this.previewBackgrounds)) {
                layoutParams.setMarginEnd(K0(6));
            }
            Y8.t tVar = Y8.t.f7040a;
            linearLayout2.addView(button, layoutParams);
            i10 = i11;
        }
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        T();
        return linearLayout;
    }

    public final View b0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(K0(20), K0(16), K0(20), K0(16));
        FrameLayout frameLayout = new FrameLayout(linearLayout.getContext());
        frameLayout.setBackground(L0());
        ImageView imageView = new ImageView(frameLayout.getContext());
        imageView.setImageResource(R$drawable.ic_taskspace_type_graph);
        imageView.setColorFilter(Color.parseColor("#99FFFFFF"));
        imageView.setContentDescription(null);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(K0(24), K0(24), 17));
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(K0(44), K0(44)));
        LinearLayout linearLayout2 = new LinearLayout(linearLayout.getContext());
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(linearLayout2.getContext());
        textView.setText(getString(R$string.task_space_blur_lab_preview_card_title));
        textView.setIncludeFontPadding(false);
        textView.setMaxLines(1);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        textView.setTextColor(Color.parseColor("#E6FFFFFF"));
        textView.setTextSize(2, 17.0f);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout3 = new LinearLayout(linearLayout2.getContext());
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        TextView textView2 = new TextView(linearLayout3.getContext());
        textView2.setText(getString(R$string.task_space_blur_lab_preview_status));
        textView2.setIncludeFontPadding(false);
        textView2.setTextColor(Color.parseColor("#B3FFFFFF"));
        textView2.setTextSize(2, 14.0f);
        linearLayout3.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
        TextView textView3 = new TextView(linearLayout3.getContext());
        textView3.setText(getString(R$string.task_space_blur_lab_preview_desc));
        textView3.setIncludeFontPadding(false);
        textView3.setMaxLines(1);
        textView3.setEllipsize(truncateAt);
        textView3.setTextColor(Color.parseColor("#99FFFFFF"));
        textView3.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMarginStart(K0(6));
        Y8.t tVar = Y8.t.f7040a;
        linearLayout3.addView(textView3, layoutParams);
        linearLayout2.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.setMarginStart(K0(10));
        linearLayout.addView(linearLayout2, layoutParams2);
        return linearLayout;
    }

    public final View d0() {
        ScrollView scrollView = new ScrollView(this);
        scrollView.setBackgroundColor(Color.parseColor("#E6050507"));
        scrollView.setPadding(0, 0, 0, O0());
        scrollView.addView(e0());
        return scrollView;
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        X();
        N0();
        setContentView(c0());
        getWindow().getDecorView().post(new Runnable() { // from class: com.stepos.ailauncher.task.debug.o
            @Override // java.lang.Runnable
            public final void run() {
                TaskSpaceBlurLabActivity.P0(this.f28423a);
            }
        });
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        PopupWindow popupWindow = this.previewPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.previewPopup = null;
        this.cardBlur.g();
        super.onDestroy();
    }

    public final View v0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(0, 0, 0, K0(10));
        String string = getString(R$string.task_space_blur_lab_preset_current);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        P(linearLayout, string, 153);
        String string2 = getString(R$string.task_space_blur_lab_preset_enhanced);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        P(linearLayout, string2, 204);
        String string3 = getString(R$string.task_space_blur_lab_preset_strong);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        P(linearLayout, string3, 230);
        String string4 = getString(R$string.task_space_blur_lab_preset_solid);
        kotlin.jvm.internal.p.h(string4, "getString(...)");
        P(linearLayout, string4, 255);
        return linearLayout;
    }

    public final View w0() {
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setClipToOutline(false);
        this.previewCard = frameLayout;
        this.blurBg = new View(this);
        this.baseBg = new View(this);
        this.overlayBg = new View(this);
        FrameLayout frameLayout2 = this.previewCard;
        FrameLayout frameLayout3 = null;
        if (frameLayout2 == null) {
            kotlin.jvm.internal.p.A("previewCard");
            frameLayout2 = null;
        }
        View view = this.blurBg;
        if (view == null) {
            kotlin.jvm.internal.p.A("blurBg");
            view = null;
        }
        frameLayout2.addView(view, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout4 = this.previewCard;
        if (frameLayout4 == null) {
            kotlin.jvm.internal.p.A("previewCard");
            frameLayout4 = null;
        }
        View view2 = this.baseBg;
        if (view2 == null) {
            kotlin.jvm.internal.p.A("baseBg");
            view2 = null;
        }
        frameLayout4.addView(view2, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout5 = this.previewCard;
        if (frameLayout5 == null) {
            kotlin.jvm.internal.p.A("previewCard");
            frameLayout5 = null;
        }
        View view3 = this.overlayBg;
        if (view3 == null) {
            kotlin.jvm.internal.p.A("overlayBg");
            view3 = null;
        }
        frameLayout5.addView(view3, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout6 = this.previewCard;
        if (frameLayout6 == null) {
            kotlin.jvm.internal.p.A("previewCard");
            frameLayout6 = null;
        }
        frameLayout6.addView(b0());
        FrameLayout frameLayout7 = this.previewCard;
        if (frameLayout7 == null) {
            kotlin.jvm.internal.p.A("previewCard");
        } else {
            frameLayout3 = frameLayout7;
        }
        frameLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, K0(this.cardHeightDp)));
        return frameLayout3;
    }

    public final View x0() {
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setPadding(K0(20), K0(18), K0(20), K0(18));
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        TextView textView = new TextView(linearLayout.getContext());
        this.previewLabel = textView;
        textView.setText(R0());
        textView.setTextSize(13.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(Color.parseColor("#D9FFFFFF"));
        textView.setShadowLayer(K0(1), 0.0f, K0(1), Color.parseColor("#80000000"));
        linearLayout.addView(textView, Y0(new LinearLayout.LayoutParams(-1, -2), 10));
        linearLayout.addView(w0());
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2, 17));
        return frameLayout;
    }

    public final View y0() {
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, K0(250)));
        return frameLayout;
    }

    public final View z0(String title, int min, int max, int initial, String suffix, InterfaceC5074l<? super SeekBar, Y8.t> onSeekBarCreated, InterfaceC5074l<? super Integer, Y8.t> onChanged) {
        TextView textView = new TextView(this);
        textView.setTextSize(13.0f);
        textView.setTextColor(Color.parseColor("#B3FFFFFF"));
        textView.setGravity(8388613);
        SeekBar seekBar = new SeekBar(this);
        seekBar.setMin(min);
        seekBar.setMax(max);
        seekBar.setProgress(C5685n.n(initial, min, max));
        if (onSeekBarCreated != null) {
            onSeekBarCreated.invoke(seekBar);
        }
        B0(textView, suffix, this, seekBar.getProgress());
        seekBar.setOnSeekBarChangeListener(new d(onChanged, textView, suffix, this, initial));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, K0(4), 0, K0(12));
        LinearLayout linearLayout2 = new LinearLayout(linearLayout.getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        TextView textView2 = new TextView(linearLayout2.getContext());
        textView2.setText(title);
        textView2.setTextSize(14.0f);
        textView2.setTextColor(-1);
        linearLayout2.addView(textView2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(K0(116), -2));
        linearLayout.addView(linearLayout2);
        linearLayout.addView(seekBar, new LinearLayout.LayoutParams(-1, -2));
        return linearLayout;
    }
}
