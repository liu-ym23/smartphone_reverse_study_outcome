package com.stepos.ailauncher.agent.skill.detail;

import Ua.C1060i;
import Y4.C1125i;
import Z8.C1173v;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.C1398p;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.ailauncher.agent.R$color;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.analytics.SkillAnalytics;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillSource;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.agent.skill.adapter.DisplayScope;
import com.stepos.ailauncher.agent.skill.widget.IndeterminateSpinnerView;
import com.stepos.ailauncher.chat.view.C2765a9;
import com.stepos.ailauncher.chat.view.T9;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.text.Regex;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import y7.G;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\u0084\u0001\u0018\u0000  \u00012\u00020\u0001:\u0004¡\u0001¢\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\u0003J\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0003J!\u0010\u0019\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0082@¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\bH\u0002¢\u0006\u0004\b!\u0010\u0003J!\u0010&\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J)\u0010-\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0017H\u0002¢\u0006\u0004\b-\u0010.J\u0011\u0010/\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b/\u00100J\u001b\u00102\u001a\u0004\u0018\u00010\u00152\b\u00101\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b2\u00103J#\u00105\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u00104\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b5\u00106J3\u00109\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u00020\u0017H\u0002¢\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b;\u0010 J\u0017\u0010<\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b<\u0010 J\u0017\u0010=\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b=\u0010 J\u0017\u0010@\u001a\u00020\b2\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\b@\u0010AJ3\u0010H\u001a\u00020G2\u0006\u0010B\u001a\u00020\u00172\u0006\u0010D\u001a\u00020C2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\b0EH\u0002¢\u0006\u0004\bH\u0010IJ\u0019\u0010J\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\bJ\u0010 J\u001f\u0010L\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010K\u001a\u00020\u0017H\u0002¢\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\bN\u0010 J\u001f\u0010Q\u001a\u00020\b2\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\"H\u0002¢\u0006\u0004\bQ\u0010RJ\u001f\u0010T\u001a\u00020\b2\u0006\u0010O\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\"H\u0002¢\u0006\u0004\bT\u0010RJ\u0019\u0010W\u001a\u00020\"2\b\u0010V\u001a\u0004\u0018\u00010UH\u0002¢\u0006\u0004\bW\u0010XJ\u0019\u0010Z\u001a\u00020\"2\b\u0010Y\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\bZ\u0010[J/\u0010_\u001a\u00020\b2\b\u0010\\\u001a\u0004\u0018\u00010\"2\b\u0010]\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\b_\u0010`J\u000f\u0010b\u001a\u00020aH\u0002¢\u0006\u0004\bb\u0010cR\u0016\u0010e\u001a\u00020d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\be\u0010fR\u001b\u0010j\u001a\u00020a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010cR\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010kR\u0016\u0010l\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010n\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010kR\u001b\u0010r\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bo\u0010h\u001a\u0004\bp\u0010qR\u0018\u0010s\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u001c\u0010v\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010x\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010mR\u0018\u0010y\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010{\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010mR\u0016\u0010|\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0019\u0010\u007f\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0089\u0001R\u0018\u0010\u008b\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010mR\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u0089\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u0089\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0018\u0010\u0091\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010mR\u0018\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0002X\u0082D¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0017\u0010\u0097\u0001\u001a\u00020\u00178VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0017\u0010\u0099\u0001\u001a\u00020\u00178VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0096\u0001R\u0017\u0010\u009b\u0001\u001a\u00020\u00178BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u0096\u0001R\u001a\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009c\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001¨\u0006£\u0001"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/detail/SkillDetailFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "onDestroy", "footer", "T0", "(Landroid/view/View;)V", "u1", "q1", "t1", "r1", "K0", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "status", "", "isToggling", "I0", "(Lcom/stepos/ailauncher/agent/skill/SkillStatus;Z)V", "H0", "(Lcom/stepos/ailauncher/agent/skill/SkillStatus;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "p1", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;)V", "J0", "", "slug", "", "testing", "F0", "(Ljava/lang/String;I)V", "Lcom/stepos/ailauncher/agent/skill/detail/F;", "dto", SdCardDbCreator.FIELD_LASTLOC_ID, "(Lcom/stepos/ailauncher/agent/skill/detail/F;)V", "isUninstalling", "U0", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;ZZ)V", "w0", "()Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "tableStatus", "x0", "(Lcom/stepos/ailauncher/agent/skill/SkillStatus;)Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "currentStatus", "i1", "(Lcom/stepos/ailauncher/agent/skill/detail/F;Lcom/stepos/ailauncher/agent/skill/SkillStatus;)V", "isTogglingNow", "isUninstallingNow", "b1", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Lcom/stepos/ailauncher/agent/skill/SkillStatus;ZZ)V", "O0", "k1", "m1", "", "text", "o0", "(Ljava/lang/CharSequence;)V", "checked", "Lcom/stepos/ailauncher/agent/skill/detail/SkillDetailFragment$DetailSwitchMode;", "mode", "Lkotlin/Function1;", "onCheckChange", "Landroid/widget/FrameLayout;", "u0", "(ZLcom/stepos/ailauncher/agent/skill/detail/SkillDetailFragment$DetailSwitchMode;Lp9/l;)Landroid/widget/FrameLayout;", "L0", "enable", "M0", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Z)V", "N0", "rowRoot", "label", "r0", "(Landroid/view/View;Ljava/lang/String;)V", UxipConstants.f30680s, "s0", "", "count", "A0", "(Ljava/lang/Long;)Ljava/lang/String;", "raw", "z0", "(Ljava/lang/String;)Ljava/lang/String;", "identifier", "displayName", "iconUrl", "p0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lu8/e;", "t0", "()Lu8/e;", "LY4/i;", "binding", "LY4/i;", "markwon$delegate", "LY8/h;", "C0", "markwon", "Ljava/lang/String;", "isTesting", "Z", "assetEnv", "subscriberId$delegate", "E0", "()Ljava/lang/String;", "subscriberId", "fallbackItem", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "LXa/k;", "currentDtoFlow", "LXa/k;", "lastInstalledChecked", "pendingToggleEnable", "Ljava/lang/Boolean;", "pendingInstallRefetch", "baseBottomPaddingPx", "I", "Landroid/view/ViewTreeObserver;", "footerTreeObserver", "Landroid/view/ViewTreeObserver;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "footerLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "com/stepos/ailauncher/agent/skill/detail/SkillDetailFragment$c", "footerAttachListener", "Lcom/stepos/ailauncher/agent/skill/detail/SkillDetailFragment$c;", "Ly7/E;", "footerBlurHandle", "Ly7/E;", "bottomAreaBlurHandle", "bottomAreaBlurUnsupported", "backGlassHandle", "uninstallGlassHandle", "Landroid/widget/PopupWindow;", "actionMenuPopup", "Landroid/widget/PopupWindow;", "footerBlurUnsupported", "", "MENU_GAP_DP", "F", "e", "()Z", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "B0", "hidesAudited", "LX4/a;", "D0", "()LX4/a;", "operaService", "Companion", "DetailSwitchMode", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SkillDetailFragment extends com.stepos.ailauncher.sheet.nav.a {
    private static final int DESC_MAX_LINES_COLLAPSED = 3;
    private static final String EXTRA_DISPLAY_NAME = "extra.display_name";
    private static final String EXTRA_ENV = "extra.env";
    private static final String EXTRA_SKILL_ITEM = "extra.skill_item";
    private static final String EXTRA_SLUG = "extra.slug";
    private static final String EXTRA_SUMMARY = "extra.summary";
    private static final String EXTRA_TESTING = "extra.testing";
    private static final String TAG = "SkillDetailFragment";
    private final float MENU_GAP_DP;
    private PopupWindow actionMenuPopup;
    private String assetEnv;
    private y7.E backGlassHandle;
    private int baseBottomPaddingPx;
    private C1125i binding;
    private y7.E bottomAreaBlurHandle;
    private boolean bottomAreaBlurUnsupported;
    private final Xa.k<SkillDetailDto> currentDtoFlow;
    private SkillItem fallbackItem;
    private final c footerAttachListener;
    private y7.E footerBlurHandle;
    private boolean footerBlurUnsupported;
    private final ViewTreeObserver.OnGlobalLayoutListener footerLayoutListener;
    private ViewTreeObserver footerTreeObserver;
    private boolean isTesting;
    private boolean lastInstalledChecked;

    /* renamed from: markwon$delegate, reason: from kotlin metadata */
    private final Y8.h markwon;
    private boolean pendingInstallRefetch;
    private Boolean pendingToggleEnable;
    private String slug;

    /* renamed from: subscriberId$delegate, reason: from kotlin metadata */
    private final Y8.h subscriberId;
    private y7.E uninstallGlassHandle;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] PALETTE_RES_IDS = {R$color.skill_icon_palette_01, R$color.skill_icon_palette_02, R$color.skill_icon_palette_03, R$color.skill_icon_palette_04, R$color.skill_icon_palette_05, R$color.skill_icon_palette_06, R$color.skill_icon_palette_07, R$color.skill_icon_palette_08, R$color.skill_icon_palette_09, R$color.skill_icon_palette_10, R$color.skill_icon_palette_11, R$color.skill_icon_palette_12};
    private static final Regex YAML_FRONTMATTER = new Regex("^---[ \\t]*\\R[\\s\\S]*?\\R---[ \\t]*\\R?");

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/detail/SkillDetailFragment$DetailSwitchMode;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "LOADING", "GREYED", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class DetailSwitchMode {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ DetailSwitchMode[] $VALUES;
        public static final DetailSwitchMode NORMAL = new DetailSwitchMode("NORMAL", 0);
        public static final DetailSwitchMode LOADING = new DetailSwitchMode("LOADING", 1);
        public static final DetailSwitchMode GREYED = new DetailSwitchMode("GREYED", 2);

        private static final /* synthetic */ DetailSwitchMode[] $values() {
            return new DetailSwitchMode[]{NORMAL, LOADING, GREYED};
        }

        static {
            DetailSwitchMode[] detailSwitchModeArr$values = $values();
            $VALUES = detailSwitchModeArr$values;
            $ENTRIES = kotlin.enums.a.a(detailSwitchModeArr$values);
        }

        private DetailSwitchMode(String str, int i10) {
        }

        public static InterfaceC4149a<DetailSwitchMode> getEntries() {
            return $ENTRIES;
        }

        public static DetailSwitchMode valueOf(String str) {
            return (DetailSwitchMode) Enum.valueOf(DetailSwitchMode.class, str);
        }

        public static DetailSwitchMode[] values() {
            return (DetailSwitchMode[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007JO\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0014R\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0014R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/detail/SkillDetailFragment$a;", "", "<init>", "()V", "", "md", "c", "(Ljava/lang/String;)Ljava/lang/String;", "slug", "displayName", c.a.COL_SUMMARY, "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "skillItem", "", "testing", "env", "Lcom/stepos/ailauncher/agent/skill/detail/SkillDetailFragment;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/agent/skill/SkillItem;ZLjava/lang/String;)Lcom/stepos/ailauncher/agent/skill/detail/SkillDetailFragment;", "TAG", "Ljava/lang/String;", "", "DESC_MAX_LINES_COLLAPSED", "I", "", "PALETTE_RES_IDS", "[I", "EXTRA_SLUG", "EXTRA_DISPLAY_NAME", "EXTRA_SUMMARY", "EXTRA_SKILL_ITEM", "EXTRA_TESTING", "EXTRA_ENV", "Lkotlin/text/Regex;", "YAML_FRONTMATTER", "Lkotlin/text/Regex;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ SkillDetailFragment b(Companion companion, String str, String str2, String str3, SkillItem skillItem, boolean z10, String str4, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str2 = null;
            }
            if ((i10 & 4) != 0) {
                str3 = null;
            }
            if ((i10 & 8) != 0) {
                skillItem = null;
            }
            if ((i10 & 16) != 0) {
                z10 = false;
            }
            if ((i10 & 32) != 0) {
                str4 = null;
            }
            return companion.a(str, str2, str3, skillItem, z10, str4);
        }

        public final SkillDetailFragment a(String slug, String displayName, String summary, SkillItem skillItem, boolean testing, String env) {
            kotlin.jvm.internal.p.i(slug, "slug");
            SkillDetailFragment skillDetailFragment = new SkillDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(SkillDetailFragment.EXTRA_SLUG, slug);
            if (displayName != null && !La.H.x0(displayName)) {
                bundle.putString(SkillDetailFragment.EXTRA_DISPLAY_NAME, displayName);
            }
            if (summary != null && !La.H.x0(summary)) {
                bundle.putString(SkillDetailFragment.EXTRA_SUMMARY, summary);
            }
            if (skillItem != null) {
                bundle.putParcelable(SkillDetailFragment.EXTRA_SKILL_ITEM, skillItem);
            }
            if (testing) {
                bundle.putBoolean("extra.testing", true);
            }
            if (env != null && !La.H.x0(env)) {
                bundle.putString(SkillDetailFragment.EXTRA_ENV, env);
            }
            skillDetailFragment.setArguments(bundle);
            return skillDetailFragment;
        }

        public final String c(String md) {
            kotlin.jvm.internal.p.i(md, "md");
            return SkillDetailFragment.YAML_FRONTMATTER.l(md, "");
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SkillStatus.values().length];
            try {
                iArr[SkillStatus.INSTALLED_ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SkillStatus.INSTALLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SkillStatus.INSTALLED_DISABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SkillStatus.UNINSTALLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SkillStatus.INSTALL_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SkillStatus.INSTALLING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SkillStatus.QUEUED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/agent/skill/detail/SkillDetailFragment$c", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements View.OnAttachStateChangeListener {
        public c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            SkillDetailFragment.this.T0(v10);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            SkillDetailFragment.this.u1();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements View.OnLayoutChangeListener {
        public d() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            view.post(SkillDetailFragment.this.new e());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SkillDetailFragment.this.t1();
        }
    }

    public SkillDetailFragment() {
        super(R$layout.activity_skill_detail);
        this.markwon = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.detail.b0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SkillDetailFragment.G0(this.f24362a);
            }
        });
        this.assetEnv = "";
        this.subscriberId = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.detail.c0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SkillDetailFragment.o1(this.f24363a);
            }
        });
        this.currentDtoFlow = Xa.u.a(null);
        this.lastInstalledChecked = true;
        this.footerLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.stepos.ailauncher.agent.skill.detail.d0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                SkillDetailFragment.y0(this.f24364a);
            }
        };
        this.footerAttachListener = new c();
        this.MENU_GAP_DP = 8.0f;
    }

    private final String A0(Long count) {
        if (count == null) {
            return O6.l.DATE_SEPARATOR;
        }
        long jLongValue = count.longValue();
        if (jLongValue < 0) {
            return O6.l.DATE_SEPARATOR;
        }
        if (jLongValue < 1000) {
            return "↓ " + jLongValue;
        }
        if (jLongValue < 10000) {
            String str = String.format("↓ %.1fk", Arrays.copyOf(new Object[]{Double.valueOf(jLongValue / 1000.0d)}, 1));
            kotlin.jvm.internal.p.h(str, "format(...)");
            return str;
        }
        if (jLongValue >= 1000000) {
            String str2 = String.format("↓ %.1fm", Arrays.copyOf(new Object[]{Double.valueOf(jLongValue / 1000000.0d)}, 1));
            kotlin.jvm.internal.p.h(str2, "format(...)");
            return str2;
        }
        return "↓ " + (jLongValue / 1000) + "k";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final u8.e C0() {
        return (u8.e) this.markwon.getValue();
    }

    private final X4.a D0() {
        return (X4.a) D5.a.INSTANCE.a(X4.a.class);
    }

    private final String E0() {
        return (String) this.subscriberId.getValue();
    }

    private final void F0(String slug, int testing) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new SkillDetailFragment$loadDetail$1(slug, testing, this, null), 3, null);
    }

    public static final u8.e G0(SkillDetailFragment skillDetailFragment) {
        return skillDetailFragment.t0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object H0(com.stepos.ailauncher.agent.skill.SkillStatus r52, e9.InterfaceC4014c<? super Y8.t> r53) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment.H0(com.stepos.ailauncher.agent.skill.SkillStatus, e9.c):java.lang.Object");
    }

    private final void J0() {
        X4.a aVarD0 = D0();
        if (aVarD0 == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new SkillDetailFragment$observeOperaErrors$1(this, aVarD0, null), 3, null);
    }

    private final void K0() {
        X4.a aVarD0 = D0();
        if (aVarD0 == null) {
            C4148a.u(TAG, "observeOperaState: ISkillOperaService not registered", false, 4, null);
            U0(null, false, false);
        } else {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new SkillDetailFragment$observeOperaState$1(this, aVarD0, null), 3, null);
        }
    }

    private final void L0(SkillItem item) {
        SkillItem skillItem;
        SkillItem skillItemCopy$default;
        SkillItem skillItemG;
        if (item == null) {
            X4.a aVarD0 = D0();
            if (aVarD0 != null) {
                String str = this.slug;
                if (str == null) {
                    kotlin.jvm.internal.p.A("slug");
                    str = null;
                }
                skillItemG = aVarD0.g(str);
            } else {
                skillItemG = null;
            }
            if (skillItemG == null) {
                skillItemG = this.fallbackItem;
            }
            skillItem = skillItemG;
        } else {
            skillItem = item;
        }
        if (skillItem != null) {
            SkillStatus skillStatusX0 = x0(item != null ? item.getStatus() : null);
            if (skillStatusX0 == null) {
                skillStatusX0 = SkillStatus.UNINSTALLED;
            }
            skillItemCopy$default = SkillItem.copy$default(skillItem, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, 0, null, null, 0, null, null, null, null, null, null, null, skillStatusX0, null, null, null, this.isTesting ? SkillSource.TESTING : SkillSource.NORMAL, Integer.MAX_VALUE, 7, null);
        } else {
            skillItemCopy$default = null;
        }
        if (skillItemCopy$default == null) {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str2 = this.slug;
            if (str2 == null) {
                kotlin.jvm.internal.p.A("slug");
                str2 = null;
            }
            String str3 = String.format("action clicked but no SkillItem yet (slug=%s)", Arrays.copyOf(new Object[]{str2}, 1));
            kotlin.jvm.internal.p.h(str3, "format(...)");
            C4148a.d(TAG, str3, false, 4, null);
            Toast.makeText(requireContext(), getString(R$string.skill_detail_toast_loading), 0).show();
            return;
        }
        X4.a aVarD02 = D0();
        if (aVarD02 == null) {
            Toast.makeText(requireContext(), getString(R$string.skill_detail_toast_service_not_ready), 0).show();
            return;
        }
        kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
        String str4 = this.slug;
        if (str4 == null) {
            kotlin.jvm.internal.p.A("slug");
            str4 = null;
        }
        String str5 = String.format("action clicked slug=%s status=%s", Arrays.copyOf(new Object[]{str4, skillItemCopy$default.getStatus()}, 2));
        kotlin.jvm.internal.p.h(str5, "format(...)");
        C4148a.d(TAG, str5, false, 4, null);
        SkillStatus status = skillItemCopy$default.getStatus();
        if (status == null) {
            status = SkillStatus.UNINSTALLED;
        }
        int i10 = b.$EnumSwitchMapping$0[status.ordinal()];
        if (i10 == 4) {
            SkillAnalytics.INSTANCE.t(skillItemCopy$default, DisplayScope.SKILL_DETAIL);
            aVarD02.n(skillItemCopy$default);
        } else if (i10 == 5) {
            SkillAnalytics.INSTANCE.t(skillItemCopy$default, DisplayScope.SKILL_DETAIL);
            aVarD02.i(skillItemCopy$default);
        } else if (i10 == 6 || i10 == 7) {
            aVarD02.f(skillItemCopy$default);
        }
    }

    private final void M0(SkillItem item, boolean enable) {
        X4.a aVarD0 = D0();
        if (aVarD0 == null) {
            Toast.makeText(requireContext(), getString(R$string.skill_detail_toast_service_not_ready), 0).show();
            return;
        }
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = this.slug;
        if (str == null) {
            kotlin.jvm.internal.p.A("slug");
            str = null;
        }
        String str2 = String.format("toggle slug=%s enable=%s", Arrays.copyOf(new Object[]{str, Boolean.valueOf(enable)}, 2));
        kotlin.jvm.internal.p.h(str2, "format(...)");
        C4148a.d(TAG, str2, false, 4, null);
        this.pendingToggleEnable = Boolean.valueOf(enable);
        SkillAnalytics.INSTANCE.u(item, DisplayScope.SKILL_DETAIL);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new SkillDetailFragment$onToggle$1(enable, aVarD0, item, null), 3, null);
    }

    private final void N0(SkillItem item) {
        X4.a aVarD0 = D0();
        if (aVarD0 == null) {
            Toast.makeText(requireContext(), getString(R$string.skill_detail_toast_service_not_ready), 0).show();
            return;
        }
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = this.slug;
        if (str == null) {
            kotlin.jvm.internal.p.A("slug");
            str = null;
        }
        String str2 = String.format("uninstall via switch slug=%s status=%s", Arrays.copyOf(new Object[]{str, item.getStatus()}, 2));
        kotlin.jvm.internal.p.h(str2, "format(...)");
        C4148a.d(TAG, str2, false, 4, null);
        aVarD0.h(item);
    }

    private final void O0(SkillItem item) {
        String version;
        SkillItem skillItem;
        SkillItem skillItemCopy$default;
        String str;
        SkillItem skillItemG;
        SkillItem skillItem2 = this.fallbackItem;
        if (skillItem2 == null || (version = skillItem2.getVersion()) == null || La.H.x0(version)) {
            version = null;
        }
        if (item == null) {
            X4.a aVarD0 = D0();
            if (aVarD0 != null) {
                String str2 = this.slug;
                if (str2 == null) {
                    kotlin.jvm.internal.p.A("slug");
                    str2 = null;
                }
                skillItemG = aVarD0.g(str2);
            } else {
                skillItemG = null;
            }
            if (skillItemG == null) {
                skillItemG = this.fallbackItem;
            }
            skillItem = skillItemG;
        } else {
            skillItem = item;
        }
        if (skillItem != null) {
            SkillStatus skillStatusX0 = x0(item != null ? item.getStatus() : null);
            SkillSource skillSource = this.isTesting ? SkillSource.TESTING : SkillSource.NORMAL;
            if (version != null) {
                str = version;
                skillItemCopy$default = SkillItem.copy$default(skillItem, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, 0L, 0, null, null, 0, null, null, null, null, null, null, null, skillStatusX0, null, null, null, skillSource, 2147475455, 7, null);
            } else if (item != null) {
                version = item.getVersion();
                str = version;
                skillItemCopy$default = SkillItem.copy$default(skillItem, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, 0L, 0, null, null, 0, null, null, null, null, null, null, null, skillStatusX0, null, null, null, skillSource, 2147475455, 7, null);
            } else {
                str = null;
                skillItemCopy$default = SkillItem.copy$default(skillItem, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, 0L, 0, null, null, 0, null, null, null, null, null, null, null, skillStatusX0, null, null, null, skillSource, 2147475455, 7, null);
            }
        } else {
            skillItemCopy$default = null;
        }
        if (skillItemCopy$default == null) {
            Toast.makeText(requireContext(), getString(R$string.skill_detail_toast_loading), 0).show();
            return;
        }
        X4.a aVarD02 = D0();
        if (aVarD02 == null) {
            Toast.makeText(requireContext(), getString(R$string.skill_detail_toast_service_not_ready), 0).show();
            return;
        }
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str3 = this.slug;
        if (str3 == null) {
            kotlin.jvm.internal.p.A("slug");
            str3 = null;
        }
        String str4 = String.format("update clicked slug=%s status=%s", Arrays.copyOf(new Object[]{str3, skillItemCopy$default.getStatus()}, 2));
        kotlin.jvm.internal.p.h(str4, "format(...)");
        C4148a.d(TAG, str4, false, 4, null);
        SkillAnalytics.INSTANCE.j(skillItemCopy$default);
        aVarD02.k(skillItemCopy$default);
    }

    public static final void P0(SkillDetailFragment skillDetailFragment, View view) {
        if (skillDetailFragment.x()) {
            return;
        }
        skillDetailFragment.o();
    }

    public static final void Q0(SkillDetailFragment skillDetailFragment) {
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        C1125i c1125i = skillDetailFragment.binding;
        if (c1125i == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i = null;
        }
        ImageView ivBack = c1125i.ivBack;
        kotlin.jvm.internal.p.h(ivBack, "ivBack");
        skillDetailFragment.backGlassHandle = com.stepos.ailauncher.container.glass.h.m(hVar, ivBack, false, Float.valueOf(22.0f), y7.o.INSTANCE.i(), false, 16, null);
    }

    public static final void R0(SkillDetailFragment skillDetailFragment) {
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        C1125i c1125i = skillDetailFragment.binding;
        if (c1125i == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i = null;
        }
        View vTopFade = c1125i.vTopFade;
        kotlin.jvm.internal.p.h(vTopFade, "vTopFade");
        com.stepos.ailauncher.container.glass.h.v(hVar, vTopFade, false, G.a.f43886a.g(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.detail.e0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SkillDetailFragment.S0((A7.B) obj);
            }
        }, 2, null);
    }

    public static final Y8.t S0(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0(final SkillItem item, boolean isToggling, boolean isUninstalling) {
        FrameLayout frameLayoutU0;
        C1125i c1125i = null;
        SkillStatus status = item != null ? item.getStatus() : null;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = this.slug;
        if (str == null) {
            kotlin.jvm.internal.p.A("slug");
            str = null;
        }
        String str2 = String.format("renderActionArea slug=%s status=%s isToggling=%s isUninstalling=%s", Arrays.copyOf(new Object[]{str, status, Boolean.valueOf(isToggling), Boolean.valueOf(isUninstalling)}, 4));
        kotlin.jvm.internal.p.h(str2, "format(...)");
        C4148a.d(TAG, str2, false, 4, null);
        C1125i c1125i2 = this.binding;
        if (c1125i2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i2 = null;
        }
        c1125i2.heroRow.setAlpha(isUninstalling ? 0.4f : 1.0f);
        boolean z10 = isToggling || status == SkillStatus.TOGGLING;
        boolean z11 = isUninstalling || status == SkillStatus.UNINSTALLING;
        int i10 = status == null ? -1 : b.$EnumSwitchMapping$0[status.ordinal()];
        if (i10 == 1 || i10 == 2) {
            this.lastInstalledChecked = true;
        } else if (i10 == 3) {
            this.lastInstalledChecked = false;
        }
        boolean z12 = status == SkillStatus.INSTALLED || status == SkillStatus.INSTALLED_ENABLED || status == SkillStatus.INSTALLED_DISABLED || status == SkillStatus.TOGGLING || status == SkillStatus.UNINSTALLING || z10 || z11;
        C1125i c1125i3 = this.binding;
        if (c1125i3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i3 = null;
        }
        c1125i3.btnTopUninstall.setVisibility(z12 ? 0 : 8);
        C1125i c1125i4 = this.binding;
        if (c1125i4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i4 = null;
        }
        c1125i4.ivTopUninstall.setVisibility(z11 ? 8 : 0);
        C1125i c1125i5 = this.binding;
        if (c1125i5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i5 = null;
        }
        c1125i5.pbTopUninstall.setVisibility(z11 ? 0 : 8);
        if (!z12 || z11) {
            com.stepos.ailauncher.container.glass.h.INSTANCE.F(this.uninstallGlassHandle);
            this.uninstallGlassHandle = null;
            if (z11) {
                C1125i c1125i6 = this.binding;
                if (c1125i6 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    c1125i6 = null;
                }
                c1125i6.btnTopUninstall.setBackground(null);
            }
        } else if (this.uninstallGlassHandle == null) {
            com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
            C1125i c1125i7 = this.binding;
            if (c1125i7 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i7 = null;
            }
            FrameLayout btnTopUninstall = c1125i7.btnTopUninstall;
            kotlin.jvm.internal.p.h(btnTopUninstall, "btnTopUninstall");
            this.uninstallGlassHandle = com.stepos.ailauncher.container.glass.h.m(hVar, btnTopUninstall, false, Float.valueOf(22.0f), null, false, 24, null);
        }
        boolean z13 = (z10 || z11 || status == SkillStatus.INSTALLING) ? false : true;
        C1125i c1125i8 = this.binding;
        if (c1125i8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i8 = null;
        }
        c1125i8.btnTopUninstall.setEnabled(z13);
        C1125i c1125i9 = this.binding;
        if (c1125i9 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i9 = null;
        }
        c1125i9.btnTopUninstall.setClickable(z13);
        C1125i c1125i10 = this.binding;
        if (c1125i10 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i10 = null;
        }
        c1125i10.btnTopUninstall.setAlpha(((z10 || status == SkillStatus.INSTALLING) && !z11) ? 0.4f : 1.0f);
        if (!z12 || !z13) {
            PopupWindow popupWindow = this.actionMenuPopup;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
            this.actionMenuPopup = null;
        }
        C1125i c1125i11 = this.binding;
        if (c1125i11 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i11 = null;
        }
        c1125i11.btnTopUninstall.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.detail.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SkillDetailFragment.V0(item, this, view);
            }
        });
        C1125i c1125i12 = this.binding;
        if (c1125i12 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i12 = null;
        }
        c1125i12.actionArea.removeAllViews();
        if (z10) {
            frameLayoutU0 = u0(this.lastInstalledChecked, DetailSwitchMode.LOADING, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.detail.J
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return SkillDetailFragment.W0(((Boolean) obj).booleanValue());
                }
            });
        } else if (z11) {
            frameLayoutU0 = u0(this.lastInstalledChecked, DetailSwitchMode.GREYED, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.detail.K
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return SkillDetailFragment.X0(((Boolean) obj).booleanValue());
                }
            });
        } else {
            int i11 = status != null ? b.$EnumSwitchMapping$0[status.ordinal()] : -1;
            frameLayoutU0 = (i11 == 1 || i11 == 2) ? u0(true, DetailSwitchMode.NORMAL, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.detail.L
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return SkillDetailFragment.Y0(this.f24343a, item, ((Boolean) obj).booleanValue());
                }
            }) : i11 != 3 ? null : u0(false, DetailSwitchMode.NORMAL, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.detail.M
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return SkillDetailFragment.Z0(this.f24345a, item, ((Boolean) obj).booleanValue());
                }
            });
        }
        if (frameLayoutU0 != null) {
            C1125i c1125i13 = this.binding;
            if (c1125i13 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1125i = c1125i13;
            }
            c1125i.actionArea.addView(frameLayoutU0);
        }
        b1(item, status, z10, z11);
    }

    public static final void V0(SkillItem skillItem, SkillDetailFragment skillDetailFragment, View view) {
        if (skillItem != null) {
            skillDetailFragment.k1(skillItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t W0(boolean z10) {
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t X0(boolean z10) {
        return Y8.t.f7040a;
    }

    public static final Y8.t Y0(SkillDetailFragment skillDetailFragment, SkillItem skillItem, boolean z10) {
        kotlin.jvm.internal.p.f(skillItem);
        skillDetailFragment.M0(skillItem, false);
        return Y8.t.f7040a;
    }

    public static final Y8.t Z0(SkillDetailFragment skillDetailFragment, SkillItem skillItem, boolean z10) {
        kotlin.jvm.internal.p.f(skillItem);
        skillDetailFragment.M0(skillItem, true);
        return Y8.t.f7040a;
    }

    private final void b1(final SkillItem item, SkillStatus status, boolean isTogglingNow, boolean isUninstallingNow) {
        SkillDetailDto value = this.currentDtoFlow.getValue();
        boolean z10 = value != null && value.getNeedUpdate() == 1;
        SkillStatus skillStatusX0 = x0(status);
        boolean z11 = skillStatusX0 == SkillStatus.INSTALLED || skillStatusX0 == SkillStatus.INSTALLED_ENABLED || skillStatusX0 == SkillStatus.INSTALLED_DISABLED;
        boolean z12 = skillStatusX0 == SkillStatus.INSTALLING || skillStatusX0 == SkillStatus.QUEUED;
        C1125i c1125i = null;
        if (isTogglingNow || isUninstallingNow) {
            C1125i c1125i2 = this.binding;
            if (c1125i2 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i2 = null;
            }
            c1125i2.footerContainer.setVisibility(8);
            C1125i c1125i3 = this.binding;
            if (c1125i3 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i3 = null;
            }
            c1125i3.vBottomBlur.setVisibility(8);
            C1125i c1125i4 = this.binding;
            if (c1125i4 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1125i = c1125i4;
            }
            c1125i.footerContainer.requestLayout();
            return;
        }
        if (z12) {
            C1125i c1125i5 = this.binding;
            if (c1125i5 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i5 = null;
            }
            c1125i5.footerContainer.setVisibility(0);
            C1125i c1125i6 = this.binding;
            if (c1125i6 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i6 = null;
            }
            c1125i6.btnBottomUpdate.setVisibility(0);
            C1125i c1125i7 = this.binding;
            if (c1125i7 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i7 = null;
            }
            c1125i7.btnBottomUpdate.setText("");
            C1125i c1125i8 = this.binding;
            if (c1125i8 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i8 = null;
            }
            c1125i8.btnBottomUpdate.setClickable(false);
            C1125i c1125i9 = this.binding;
            if (c1125i9 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i9 = null;
            }
            c1125i9.btnBottomUpdate.setOnClickListener(null);
            C1125i c1125i10 = this.binding;
            if (c1125i10 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i10 = null;
            }
            c1125i10.pbBottomUpdate.setVisibility(0);
            C1125i c1125i11 = this.binding;
            if (c1125i11 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i11 = null;
            }
            IndeterminateSpinnerView indeterminateSpinnerView = c1125i11.pbBottomUpdate;
            b5.m mVar = b5.m.INSTANCE;
            Context contextRequireContext = requireContext();
            kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
            indeterminateSpinnerView.setColor(mVar.i(contextRequireContext));
            C1125i c1125i12 = this.binding;
            if (c1125i12 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i12 = null;
            }
            c1125i12.footerContainer.setOnClickListener(null);
            C1125i c1125i13 = this.binding;
            if (c1125i13 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i13 = null;
            }
            c1125i13.btnBottomUpdate.post(new Runnable() { // from class: com.stepos.ailauncher.agent.skill.detail.N
                @Override // java.lang.Runnable
                public final void run() {
                    SkillDetailFragment.c1(this.f24347a);
                }
            });
        } else if (skillStatusX0 == SkillStatus.UNINSTALLED || skillStatusX0 == SkillStatus.INSTALL_FAILED) {
            C1125i c1125i14 = this.binding;
            if (c1125i14 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i14 = null;
            }
            c1125i14.footerContainer.setVisibility(0);
            C1125i c1125i15 = this.binding;
            if (c1125i15 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i15 = null;
            }
            c1125i15.btnBottomUpdate.setVisibility(0);
            C1125i c1125i16 = this.binding;
            if (c1125i16 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i16 = null;
            }
            c1125i16.pbBottomUpdate.setVisibility(8);
            C1125i c1125i17 = this.binding;
            if (c1125i17 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i17 = null;
            }
            c1125i17.btnBottomUpdate.setText(getString(R$string.skill_detail_action_install_full));
            C1125i c1125i18 = this.binding;
            if (c1125i18 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i18 = null;
            }
            c1125i18.btnBottomUpdate.setEnabled(true);
            C1125i c1125i19 = this.binding;
            if (c1125i19 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i19 = null;
            }
            c1125i19.btnBottomUpdate.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.detail.O
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SkillDetailFragment.d1(this.f24348a, item, view);
                }
            });
            C1125i c1125i20 = this.binding;
            if (c1125i20 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i20 = null;
            }
            c1125i20.btnBottomUpdate.post(new Runnable() { // from class: com.stepos.ailauncher.agent.skill.detail.P
                @Override // java.lang.Runnable
                public final void run() {
                    SkillDetailFragment.e1(this.f24350a);
                }
            });
        } else if (z11 && z10) {
            C1125i c1125i21 = this.binding;
            if (c1125i21 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i21 = null;
            }
            c1125i21.footerContainer.setVisibility(0);
            C1125i c1125i22 = this.binding;
            if (c1125i22 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i22 = null;
            }
            c1125i22.btnBottomUpdate.setVisibility(0);
            C1125i c1125i23 = this.binding;
            if (c1125i23 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i23 = null;
            }
            c1125i23.pbBottomUpdate.setVisibility(8);
            C1125i c1125i24 = this.binding;
            if (c1125i24 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i24 = null;
            }
            c1125i24.btnBottomUpdate.setText(getString(R$string.skill_detail_action_update));
            C1125i c1125i25 = this.binding;
            if (c1125i25 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i25 = null;
            }
            c1125i25.btnBottomUpdate.setEnabled(true);
            C1125i c1125i26 = this.binding;
            if (c1125i26 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i26 = null;
            }
            c1125i26.btnBottomUpdate.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.detail.Q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SkillDetailFragment.f1(this.f24351a, item, view);
                }
            });
            C1125i c1125i27 = this.binding;
            if (c1125i27 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i27 = null;
            }
            c1125i27.btnBottomUpdate.post(new Runnable() { // from class: com.stepos.ailauncher.agent.skill.detail.S
                @Override // java.lang.Runnable
                public final void run() {
                    SkillDetailFragment.g1(this.f24353a);
                }
            });
        } else {
            C1125i c1125i28 = this.binding;
            if (c1125i28 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i28 = null;
            }
            c1125i28.footerContainer.setVisibility(8);
        }
        C1125i c1125i29 = this.binding;
        if (c1125i29 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i29 = null;
        }
        View view = c1125i29.vBottomBlur;
        C1125i c1125i30 = this.binding;
        if (c1125i30 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i30 = null;
        }
        view.setVisibility(c1125i30.footerContainer.getVisibility() != 0 ? 8 : 0);
        C1125i c1125i31 = this.binding;
        if (c1125i31 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i31 = null;
        }
        if (c1125i31.vBottomBlur.getVisibility() == 0) {
            C1125i c1125i32 = this.binding;
            if (c1125i32 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i32 = null;
            }
            c1125i32.vBottomBlur.post(new Runnable() { // from class: com.stepos.ailauncher.agent.skill.detail.T
                @Override // java.lang.Runnable
                public final void run() {
                    SkillDetailFragment.h1(this.f24354a);
                }
            });
        }
        C1125i c1125i33 = this.binding;
        if (c1125i33 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1125i = c1125i33;
        }
        c1125i.footerContainer.requestLayout();
    }

    public static final void c1(SkillDetailFragment skillDetailFragment) {
        skillDetailFragment.t1();
    }

    public static final void d1(SkillDetailFragment skillDetailFragment, SkillItem skillItem, View view) {
        skillDetailFragment.L0(skillItem);
    }

    public static final void e1(SkillDetailFragment skillDetailFragment) {
        skillDetailFragment.t1();
    }

    public static final void f1(SkillDetailFragment skillDetailFragment, SkillItem skillItem, View view) {
        skillDetailFragment.O0(skillItem);
    }

    public static final void g1(SkillDetailFragment skillDetailFragment) {
        skillDetailFragment.t1();
    }

    public static final void h1(SkillDetailFragment skillDetailFragment) {
        skillDetailFragment.r1();
    }

    private final void i1(SkillDetailDto dto, SkillStatus currentStatus) {
        String version;
        String packageSize;
        List listM;
        List<String> listD;
        boolean z10 = dto != null && dto.getNeedUpdate() == 1 && (x0(currentStatus) == SkillStatus.INSTALLED || x0(currentStatus) == SkillStatus.INSTALLED_ENABLED || x0(currentStatus) == SkillStatus.INSTALLED_DISABLED);
        C1125i c1125i = this.binding;
        C1125i c1125i2 = null;
        if (c1125i == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i = null;
        }
        c1125i.llUpdateBanner.setVisibility(z10 ? 0 : 8);
        if (z10) {
            if (dto == null || (version = dto.getVersion()) == null || La.H.x0(version)) {
                version = null;
            }
            C1125i c1125i3 = this.binding;
            if (c1125i3 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i3 = null;
            }
            c1125i3.tvUpdateBannerTitle.setText(version != null ? getString(R$string.skill_detail_update_banner_title_simple, version) : getString(R$string.skill_detail_action_update));
            if (dto == null || (packageSize = dto.getPackageSize()) == null || La.H.x0(packageSize)) {
                packageSize = null;
            }
            C1125i c1125i4 = this.binding;
            if (c1125i4 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i4 = null;
            }
            c1125i4.tvUpdateBannerSize.setVisibility(packageSize != null ? 0 : 8);
            if (packageSize != null) {
                C1125i c1125i5 = this.binding;
                if (c1125i5 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    c1125i5 = null;
                }
                c1125i5.tvUpdateBannerSize.setText(getString(R$string.skill_detail_update_banner_size_fmt, packageSize));
            }
            if (dto == null || (listD = dto.d()) == null) {
                listM = null;
            } else {
                listM = new ArrayList();
                for (Object obj : listD) {
                    if (!La.H.x0((String) obj)) {
                        listM.add(obj);
                    }
                }
            }
            if (listM == null) {
                listM = C1173v.m();
            }
            if (listM.isEmpty()) {
                C1125i c1125i6 = this.binding;
                if (c1125i6 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    c1125i2 = c1125i6;
                }
                c1125i2.tvUpdateBannerChangelog.setVisibility(8);
                return;
            }
            C1125i c1125i7 = this.binding;
            if (c1125i7 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i7 = null;
            }
            c1125i7.tvUpdateBannerChangelog.setVisibility(0);
            C1125i c1125i8 = this.binding;
            if (c1125i8 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1125i2 = c1125i8;
            }
            c1125i2.tvUpdateBannerChangelog.setText(Z8.F.A0(listM, "\n", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.detail.W
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return SkillDetailFragment.j1((String) obj2);
                }
            }, 30, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence j1(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return "- " + it;
    }

    public static final Y8.t l1(SkillDetailFragment skillDetailFragment, SkillItem skillItem) {
        skillDetailFragment.m1(skillItem);
        return Y8.t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024 A[PHI: r0
      0x0024: PHI (r0v7 java.lang.String) = (r0v4 java.lang.String), (r0v9 java.lang.String) binds: [B:17:0x0028, B:13:0x0021] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m1(final com.stepos.ailauncher.agent.skill.SkillItem r5) {
        /*
            r4 = this;
            Y4.i r0 = r4.binding
            r1 = 0
            if (r0 != 0) goto Lb
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.p.A(r0)
            r0 = r1
        Lb:
            android.widget.TextView r0 = r0.tvTitle
            java.lang.CharSequence r0 = r0.getText()
            if (r0 == 0) goto L26
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L26
            boolean r2 = La.H.x0(r0)
            if (r2 != 0) goto L20
            goto L21
        L20:
            r0 = r1
        L21:
            if (r0 != 0) goto L24
            goto L26
        L24:
            r1 = r0
            goto L30
        L26:
            java.lang.String r0 = r4.slug
            if (r0 != 0) goto L24
            java.lang.String r0 = "slug"
            kotlin.jvm.internal.p.A(r0)
        L30:
            com.stepos.ailauncher.agent.skill.detail.B0 r0 = new com.stepos.ailauncher.agent.skill.detail.B0
            android.content.Context r2 = r4.requireContext()
            java.lang.String r3 = "requireContext(...)"
            kotlin.jvm.internal.p.h(r2, r3)
            com.stepos.ailauncher.agent.skill.detail.I r3 = new com.stepos.ailauncher.agent.skill.detail.I
            r3.<init>()
            r0.<init>(r2, r1, r3)
            r0.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment.m1(com.stepos.ailauncher.agent.skill.SkillItem):void");
    }

    public static final Y8.t n1(SkillDetailFragment skillDetailFragment, SkillItem skillItem) {
        skillDetailFragment.N0(skillItem);
        return Y8.t.f7040a;
    }

    private final void o0(CharSequence text) {
        C1125i c1125i = this.binding;
        C1125i c1125i2 = null;
        if (c1125i == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i = null;
        }
        c1125i.llDescriptionToggle.setVisibility(8);
        com.stepos.ailauncher.common.widget.b bVar = com.stepos.ailauncher.common.widget.b.INSTANCE;
        C1125i c1125i3 = this.binding;
        if (c1125i3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1125i2 = c1125i3;
        }
        TextView tvDescription = c1125i2.tvDescription;
        kotlin.jvm.internal.p.h(tvDescription, "tvDescription");
        String string = getString(R$string.skill_detail_desc_expand);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = getString(R$string.skill_detail_desc_collapse);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        com.stepos.ailauncher.common.widget.b.c(bVar, tvDescription, text, 3, string, string2, -1, null, 64, null);
    }

    public static final String o1(SkillDetailFragment skillDetailFragment) {
        String str = skillDetailFragment.slug;
        if (str == null) {
            kotlin.jvm.internal.p.A("slug");
            str = null;
        }
        return "skillDetail_" + str + "_" + skillDetailFragment.hashCode();
    }

    private final void p0(String identifier, String displayName, String iconUrl) {
        d5.m mVar = d5.m.INSTANCE;
        int[] iArr = PALETTE_RES_IDS;
        int iC = androidx.core.content.a.c(requireContext(), iArr[mVar.e(identifier, iArr.length)]);
        C1125i c1125i = this.binding;
        C1125i c1125i2 = null;
        if (c1125i == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i = null;
        }
        Drawable background = c1125i.iconPlaceholder.getBackground();
        Drawable drawableMutate = background != null ? background.mutate() : null;
        GradientDrawable gradientDrawable = drawableMutate instanceof GradientDrawable ? (GradientDrawable) drawableMutate : null;
        if (gradientDrawable == null) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(iC);
            C1125i c1125i3 = this.binding;
            if (c1125i3 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i3 = null;
            }
            c1125i3.iconPlaceholder.setBackground(gradientDrawable);
        }
        if (background == null || !(background instanceof GradientDrawable)) {
            C1125i c1125i4 = this.binding;
            if (c1125i4 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i4 = null;
            }
            c1125i4.iconPlaceholder.setBackground(gradientDrawable);
        } else {
            gradientDrawable.setColor(iC);
        }
        C1125i c1125i5 = this.binding;
        if (c1125i5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i5 = null;
        }
        c1125i5.tvSkillIconChar.setText(mVar.a(displayName));
        C1125i c1125i6 = this.binding;
        if (c1125i6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i6 = null;
        }
        ImageView ivSkillIcon = c1125i6.ivSkillIcon;
        kotlin.jvm.internal.p.h(ivSkillIcon, "ivSkillIcon");
        C1125i c1125i7 = this.binding;
        if (c1125i7 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1125i2 = c1125i7;
        }
        TextView tvSkillIconChar = c1125i2.tvSkillIconChar;
        kotlin.jvm.internal.p.h(tvSkillIconChar, "tvSkillIconChar");
        C2765a9.a(ivSkillIcon, tvSkillIconChar, iconUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p1(SkillItem item) {
        SkillStatus status;
        SkillDetailDto value;
        i1(this.currentDtoFlow.getValue(), item != null ? item.getStatus() : null);
        if (item == null || (status = item.getStatus()) == null) {
            return;
        }
        if ((status == SkillStatus.INSTALLED || status == SkillStatus.INSTALLED_ENABLED || status == SkillStatus.INSTALLED_DISABLED) && (value = this.currentDtoFlow.getValue()) != null) {
            int needUpdate = (item.getNeedUpdate() == 0 && value.getNeedUpdate() == 1) ? 0 : value.getNeedUpdate();
            if (needUpdate == value.getNeedUpdate()) {
                return;
            }
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = this.slug;
            if (str == null) {
                kotlin.jvm.internal.p.A("slug");
                str = null;
            }
            String str2 = String.format("syncDtoFromTable slug=%s needUpdate:%s→%s (installVersion 不回写,交重拉 GetSkill)", Arrays.copyOf(new Object[]{str, Integer.valueOf(value.getNeedUpdate()), Integer.valueOf(needUpdate)}, 3));
            kotlin.jvm.internal.p.h(str2, "format(...)");
            C4148a.d(TAG, str2, false, 4, null);
            SkillDetailDto skillDetailDtoB = SkillDetailDto.b(value, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, needUpdate, null, null, null, null, 8126463, null);
            this.currentDtoFlow.setValue(skillDetailDtoB);
            i1(skillDetailDtoB, item.getStatus());
        }
    }

    public static /* synthetic */ void q0(SkillDetailFragment skillDetailFragment, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        skillDetailFragment.p0(str, str2, str3);
    }

    private final void q1() {
        C1125i c1125i;
        if (!isAdded() || (c1125i = this.binding) == null) {
            return;
        }
        C1125i c1125i2 = null;
        if (c1125i == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i = null;
        }
        FrameLayout footerContainer = c1125i.footerContainer;
        kotlin.jvm.internal.p.h(footerContainer, "footerContainer");
        int height = footerContainer.getVisibility() == 8 ? this.baseBottomPaddingPx : footerContainer.getHeight() + this.baseBottomPaddingPx;
        C1125i c1125i3 = this.binding;
        if (c1125i3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i3 = null;
        }
        if (c1125i3.scrollView.getPaddingBottom() != height) {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("sync scrollView paddingBottom=%d (footerVisible=%s footerH=%d)", Arrays.copyOf(new Object[]{Integer.valueOf(height), Boolean.valueOf(footerContainer.getVisibility() != 8), Integer.valueOf(footerContainer.getHeight())}, 3));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.p(TAG, str, false, 4, null);
            C1125i c1125i4 = this.binding;
            if (c1125i4 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1125i2 = c1125i4;
            }
            ScrollView scrollView = c1125i2.scrollView;
            kotlin.jvm.internal.p.h(scrollView, "scrollView");
            scrollView.setPadding(scrollView.getPaddingLeft(), scrollView.getPaddingTop(), scrollView.getPaddingRight(), height);
        }
    }

    private final void r0(View rowRoot, String label) {
        ((TextView) rowRoot.findViewById(R$id.tv_meta_label)).setText(label);
    }

    private final void s0(View rowRoot, String value) {
        TextView textView = (TextView) rowRoot.findViewById(R$id.tv_meta_value);
        if (La.H.x0(value)) {
            value = O6.l.DATE_SEPARATOR;
        }
        textView.setText(value);
    }

    public static final Y8.t s1(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        attachGradientBlur.n(64.0f);
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    private final u8.e t0() {
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        return SkillMarkwonFactoryKt.b(contextRequireContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1() {
        if (this.footerBlurHandle == null && !this.footerBlurUnsupported) {
            C1125i c1125i = this.binding;
            if (c1125i == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i = null;
            }
            TextView btnBottomUpdate = c1125i.btnBottomUpdate;
            kotlin.jvm.internal.p.h(btnBottomUpdate, "btnBottomUpdate");
            if (btnBottomUpdate.getVisibility() == 0) {
                y7.E eB = com.stepos.ailauncher.agent.aispace.F.b(com.stepos.ailauncher.agent.aispace.F.INSTANCE, btnBottomUpdate, 0.0f, 0.0f, 6, null);
                this.footerBlurHandle = eB;
                if (eB == null) {
                    this.footerBlurUnsupported = true;
                }
                kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                String str = String.format("attachFooterButtonBlur activeCount=%s unsupported=%s", Arrays.copyOf(new Object[]{eB != null ? Integer.valueOf(eB.c()) : null, Boolean.valueOf(this.footerBlurUnsupported)}, 2));
                kotlin.jvm.internal.p.h(str, "format(...)");
                C4148a.d(TAG, str, false, 4, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(InterfaceC5074l interfaceC5074l, boolean z10, View view) {
        interfaceC5074l.invoke(Boolean.valueOf(!z10));
    }

    private final SkillStatus w0() {
        X4.a aVarD0 = D0();
        if (aVarD0 != null) {
            String str = this.slug;
            if (str == null) {
                kotlin.jvm.internal.p.A("slug");
                str = null;
            }
            SkillItem skillItemG = aVarD0.g(str);
            if (skillItemG != null) {
                return skillItemG.getStatus();
            }
        }
        return null;
    }

    private final SkillStatus x0(SkillStatus tableStatus) {
        if (tableStatus != null) {
            return tableStatus;
        }
        SkillItem skillItem = this.fallbackItem;
        if (skillItem != null) {
            return skillItem.getStatus();
        }
        return null;
    }

    public static final void y0(SkillDetailFragment skillDetailFragment) {
        skillDetailFragment.q1();
    }

    private final String z0(String raw) {
        if (raw == null || La.H.x0(raw)) {
            return O6.l.DATE_SEPARATOR;
        }
        if (raw.length() < 10 || raw.charAt(4) != '-' || raw.charAt(7) != '-') {
            return raw;
        }
        String strSubstring = raw.substring(0, 10);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final boolean B0() {
        return this.isTesting && !kotlin.jvm.internal.p.d(this.assetEnv, "prod");
    }

    public final void I0(SkillStatus status, boolean isToggling) {
        int i10;
        Boolean bool = this.pendingToggleEnable;
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            if (isToggling || status == SkillStatus.TOGGLING) {
                return;
            }
            boolean z10 = status == SkillStatus.INSTALLED_ENABLED || status == SkillStatus.INSTALLED;
            boolean z11 = status == SkillStatus.INSTALLED_DISABLED;
            if (z10 || z11) {
                this.pendingToggleEnable = null;
                if (zBooleanValue && z10) {
                    i10 = R$string.skill_detail_toast_enabled;
                } else if (zBooleanValue || !z11) {
                    return;
                } else {
                    i10 = R$string.skill_detail_toast_disabled;
                }
                Toast.makeText(requireContext(), getString(i10), 0).show();
            }
        }
    }

    public final void T0(View footer) {
        ViewTreeObserver viewTreeObserver = footer.getViewTreeObserver();
        if (this.footerTreeObserver == viewTreeObserver) {
            return;
        }
        u1();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this.footerLayoutListener);
            this.footerTreeObserver = viewTreeObserver;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x018f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a1(com.stepos.ailauncher.agent.skill.detail.SkillDetailDto r18) {
        /*
            Method dump skipped, instructions count: 636
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment.a1(com.stepos.ailauncher.agent.skill.detail.F):void");
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean e() {
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    public final void k1(final SkillItem item) {
        PopupWindow popupWindow = this.actionMenuPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        C1125i c1125i = this.binding;
        if (c1125i == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i = null;
        }
        FrameLayout btnTopUninstall = c1125i.btnTopUninstall;
        kotlin.jvm.internal.p.h(btnTopUninstall, "btnTopUninstall");
        this.actionMenuPopup = T9.c(btnTopUninstall, this.MENU_GAP_DP, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.detail.V
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SkillDetailFragment.l1(this.f24355a, item);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        X4.a aVarD0;
        super.onDestroy();
        if (this.slug != null && (aVarD0 = D0()) != null) {
            aVarD0.a(E0());
        }
        y7.E e10 = this.footerBlurHandle;
        if (e10 != null) {
            e10.g();
        }
        this.footerBlurHandle = null;
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        hVar.F(this.bottomAreaBlurHandle);
        this.bottomAreaBlurHandle = null;
        this.bottomAreaBlurUnsupported = false;
        hVar.F(this.backGlassHandle);
        this.backGlassHandle = null;
        hVar.F(this.uninstallGlassHandle);
        this.uninstallGlassHandle = null;
        PopupWindow popupWindow = this.actionMenuPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.actionMenuPopup = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        C1125i c1125i = this.binding;
        if (c1125i != null) {
            if (c1125i == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i = null;
            }
            c1125i.footerContainer.removeOnAttachStateChangeListener(this.footerAttachListener);
            u1();
        }
        super.onDestroyView();
    }

    /* JADX WARN: Removed duplicated region for block: B:95:0x0205  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onViewCreated(android.view.View r55, android.os.Bundle r56) {
        /*
            Method dump skipped, instructions count: 770
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public final void r1() {
        if (this.bottomAreaBlurHandle == null && !this.bottomAreaBlurUnsupported) {
            C1125i c1125i = this.binding;
            if (c1125i == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i = null;
            }
            View vBottomBlur = c1125i.vBottomBlur;
            kotlin.jvm.internal.p.h(vBottomBlur, "vBottomBlur");
            if (vBottomBlur.getVisibility() == 0) {
                com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
                C1125i c1125i2 = this.binding;
                if (c1125i2 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    c1125i2 = null;
                }
                View vBottomBlur2 = c1125i2.vBottomBlur;
                kotlin.jvm.internal.p.h(vBottomBlur2, "vBottomBlur");
                y7.E eV = com.stepos.ailauncher.container.glass.h.v(hVar, vBottomBlur2, false, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.detail.U
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return SkillDetailFragment.s1((A7.B) obj);
                    }
                }, 4, null);
                this.bottomAreaBlurHandle = eV;
                if (eV == null) {
                    this.bottomAreaBlurUnsupported = true;
                }
                kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                String str = String.format("attachBottomAreaBlur activeCount=%s unsupported=%s", Arrays.copyOf(new Object[]{eV != null ? Integer.valueOf(eV.c()) : null, Boolean.valueOf(this.bottomAreaBlurUnsupported)}, 2));
                kotlin.jvm.internal.p.h(str, "format(...)");
                C4148a.d(TAG, str, false, 4, null);
            }
        }
    }

    public final FrameLayout u0(final boolean checked, DetailSwitchMode mode, final InterfaceC5074l<? super Boolean, Y8.t> onCheckChange) {
        float f10 = getResources().getDisplayMetrics().density;
        int i10 = (int) (40 * f10);
        int i11 = (int) (22 * f10);
        int i12 = (int) (14 * f10);
        int i13 = (int) (4 * f10);
        int iC = androidx.core.content.a.c(requireContext(), R$color.sd_link);
        int iC2 = androidx.core.content.a.c(requireContext(), R$color.skill_switch_track_off_value);
        FrameLayout frameLayout = new FrameLayout(requireContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(i10, i11));
        DetailSwitchMode detailSwitchMode = DetailSwitchMode.LOADING;
        if (mode != detailSwitchMode) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(i11 / 2.0f);
            if (!checked) {
                iC = iC2;
            }
            gradientDrawable.setColor(iC);
            frameLayout.setBackground(gradientDrawable);
        }
        if (mode == detailSwitchMode) {
            Context contextRequireContext = requireContext();
            kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
            IndeterminateSpinnerView indeterminateSpinnerView = new IndeterminateSpinnerView(contextRequireContext, null, 0, 6, null);
            b5.m mVar = b5.m.INSTANCE;
            Context contextRequireContext2 = requireContext();
            kotlin.jvm.internal.p.h(contextRequireContext2, "requireContext(...)");
            indeterminateSpinnerView.setColor(mVar.i(contextRequireContext2));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i11, i11);
            layoutParams.gravity = 17;
            Y8.t tVar = Y8.t.f7040a;
            frameLayout.addView(indeterminateSpinnerView, layoutParams);
            frameLayout.setClickable(false);
            return frameLayout;
        }
        View view = new View(requireContext());
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(-1);
        view.setBackground(gradientDrawable2);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i12, i12);
        layoutParams2.gravity = (checked ? 8388613 : 8388611) | 16;
        layoutParams2.setMarginStart(i13);
        layoutParams2.setMarginEnd(i13);
        Y8.t tVar2 = Y8.t.f7040a;
        frameLayout.addView(view, layoutParams2);
        if (mode == DetailSwitchMode.GREYED) {
            frameLayout.setAlpha(0.4f);
            frameLayout.setClickable(false);
            return frameLayout;
        }
        frameLayout.setClickable(true);
        frameLayout.setFocusable(true);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.detail.X
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SkillDetailFragment.v0(onCheckChange, checked, view2);
            }
        });
        return frameLayout;
    }

    public final void u1() {
        ViewTreeObserver viewTreeObserver = this.footerTreeObserver;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                viewTreeObserver = null;
            }
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this.footerLayoutListener);
            }
        }
        this.footerTreeObserver = null;
    }
}
