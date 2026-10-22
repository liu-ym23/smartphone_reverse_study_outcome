package com.stepos.ailauncher.agent.skill.detail;

import Ua.C1060i;
import Y4.C1125i;
import Z8.C1173v;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.view.C1398p;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.a0;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.ailauncher.agent.R$color;
import com.stepos.ailauncher.agent.R$id;
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
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u008d\u00012\u00020\u0001:\u0004\u008e\u0001\u008f\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J!\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0082@¢\u0006\u0004\b \u0010!J)\u0010%\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002¢\u0006\u0004\b%\u0010&J\u0011\u0010'\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b'\u0010(J\u001b\u0010*\u001a\u0004\u0018\u00010\r2\b\u0010)\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b*\u0010+J#\u0010-\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010,\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b-\u0010.J3\u00101\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\"H\u0002¢\u0006\u0004\b1\u00102J\u0019\u00103\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b3\u0010\u0014J\u0017\u00104\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b4\u0010\u0014J\u0017\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0006H\u0002¢\u0006\u0004\b9\u0010\u0003J\u0017\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\"H\u0002¢\u0006\u0004\b;\u0010<J3\u0010C\u001a\u00020B2\u0006\u0010=\u001a\u00020\"2\u0006\u0010?\u001a\u00020>2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00060@H\u0002¢\u0006\u0004\bC\u0010DJ\u0019\u0010E\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\bE\u0010\u0014J\u001f\u0010G\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010F\u001a\u00020\"H\u0002¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\bI\u0010\u0014J\u001f\u0010M\u001a\u00020\u00062\u0006\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020\u0016H\u0002¢\u0006\u0004\bM\u0010NJ\u001f\u0010P\u001a\u00020\u00062\u0006\u0010K\u001a\u00020J2\u0006\u0010O\u001a\u00020\u0016H\u0002¢\u0006\u0004\bP\u0010NJ\u0019\u0010S\u001a\u00020\u00162\b\u0010R\u001a\u0004\u0018\u00010QH\u0002¢\u0006\u0004\bS\u0010TJ\u0019\u0010V\u001a\u00020\u00162\b\u0010U\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\bV\u0010WJ/\u0010[\u001a\u00020\u00062\b\u0010X\u001a\u0004\u0018\u00010\u00162\b\u0010Y\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b[\u0010\\J\u000f\u0010^\u001a\u00020]H\u0002¢\u0006\u0004\b^\u0010_R\u0016\u0010a\u001a\u00020`8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\ba\u0010bR\u001b\u0010f\u001a\u00020]8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010_R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010gR\u0016\u0010h\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u001b\u0010m\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bj\u0010d\u001a\u0004\bk\u0010lR\u0018\u0010n\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010p\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010iR\u0018\u0010r\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u001c\u0010u\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010w\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010iR\u0016\u0010x\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010iR\u001b\u0010|\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\by\u0010d\u001a\u0004\bz\u0010{R\u0014\u0010~\u001a\u00020}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001c\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001c\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0082\u0001R\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0082\u0001R\u0018\u0010\u0085\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010iR\u0018\u0010\u0086\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010iR\u0019\u0010\u0087\u0001\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001¨\u0006\u0090\u0001"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/detail/SkillDetailActivity;", "Lz5/a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "n1", "p1", "G0", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "status", "E0", "(Lcom/stepos/ailauncher/agent/skill/SkillStatus;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "m1", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;)V", "F0", "", "slug", "", "testing", "C0", "(Ljava/lang/String;I)V", "Lcom/stepos/ailauncher/agent/skill/detail/F;", "dto", "i1", "(Lcom/stepos/ailauncher/agent/skill/detail/F;)V", "X0", "(Lcom/stepos/ailauncher/agent/skill/detail/F;Le9/c;)Ljava/lang/Object;", "", "isToggling", "isUninstalling", "Q0", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;ZZ)V", "t0", "()Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "tableStatus", "u0", "(Lcom/stepos/ailauncher/agent/skill/SkillStatus;)Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "currentStatus", "g1", "(Lcom/stepos/ailauncher/agent/skill/detail/F;Lcom/stepos/ailauncher/agent/skill/SkillStatus;)V", "isTogglingNow", "isUninstallingNow", SdCardDbCreator.FIELD_LASTLOC_ID, "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Lcom/stepos/ailauncher/agent/skill/SkillStatus;ZZ)V", "P0", "j1", "", "text", "g0", "(Ljava/lang/CharSequence;)V", "o1", "expanded", "k0", "(Z)V", "checked", "Lcom/stepos/ailauncher/agent/skill/detail/SkillDetailActivity$DetailSwitchMode;", "mode", "Lkotlin/Function1;", "onCheckChange", "Landroid/widget/FrameLayout;", "r0", "(ZLcom/stepos/ailauncher/agent/skill/detail/SkillDetailActivity$DetailSwitchMode;Lp9/l;)Landroid/widget/FrameLayout;", "H0", "enable", "N0", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Z)V", "O0", "Landroid/view/View;", "rowRoot", "label", "o0", "(Landroid/view/View;Ljava/lang/String;)V", UxipConstants.f30680s, "p0", "", "count", "x0", "(Ljava/lang/Long;)Ljava/lang/String;", "raw", "w0", "(Ljava/lang/String;)Ljava/lang/String;", "identifier", "displayName", "iconUrl", "l0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lu8/e;", "q0", "()Lu8/e;", "LY4/i;", "binding", "LY4/i;", "markwon$delegate", "LY8/h;", "z0", "markwon", "Ljava/lang/String;", "isTesting", "Z", "subscriberId$delegate", "B0", "()Ljava/lang/String;", "subscriberId", "fallbackItem", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "detailShowReported", "Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", "entrySource", "Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", "LXa/k;", "currentDtoFlow", "LXa/k;", "lastInstalledChecked", "pendingInstallRefetch", "baseBottomPaddingPx$delegate", "y0", "()I", "baseBottomPaddingPx", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "footerLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Ly7/E;", "footerBlurHandle", "Ly7/E;", "backGlassHandle", "uninstallGlassHandle", "footerBlurUnsupported", "descriptionExpanded", "descriptionFullText", "Ljava/lang/CharSequence;", "LX4/a;", "A0", "()LX4/a;", "operaService", "Companion", "DetailSwitchMode", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SkillDetailActivity extends ActivityC6361a {
    private static final int DESC_MAX_LINES_COLLAPSED = 2;
    private static final String EXTRA_DISPLAY_NAME = "extra.display_name";
    private static final String EXTRA_SKILL_ITEM = "extra.skill_item";
    private static final String EXTRA_SLUG = "extra.slug";
    private static final String EXTRA_SOURCE = "extra.source";
    private static final String EXTRA_SUMMARY = "extra.summary";
    private static final String EXTRA_TESTING = "extra.testing";
    private static final String TAG = "SkillDetailActivity";
    private y7.E backGlassHandle;
    private C1125i binding;
    private boolean descriptionExpanded;
    private boolean detailShowReported;
    private DisplayScope entrySource;
    private SkillItem fallbackItem;
    private y7.E footerBlurHandle;
    private boolean footerBlurUnsupported;
    private boolean isTesting;
    private boolean pendingInstallRefetch;
    private String slug;
    private y7.E uninstallGlassHandle;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] PALETTE_RES_IDS = {R$color.skill_icon_palette_01, R$color.skill_icon_palette_02, R$color.skill_icon_palette_03, R$color.skill_icon_palette_04, R$color.skill_icon_palette_05, R$color.skill_icon_palette_06, R$color.skill_icon_palette_07, R$color.skill_icon_palette_08, R$color.skill_icon_palette_09, R$color.skill_icon_palette_10, R$color.skill_icon_palette_11, R$color.skill_icon_palette_12};
    private static final Regex YAML_FRONTMATTER = new Regex("^---[ \\t]*\\R[\\s\\S]*?\\R---[ \\t]*\\R?");

    /* renamed from: markwon$delegate, reason: from kotlin metadata */
    private final Y8.h markwon = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.detail.y
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return SkillDetailActivity.D0(this.f24410a);
        }
    });

    /* renamed from: subscriberId$delegate, reason: from kotlin metadata */
    private final Y8.h subscriberId = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.detail.z
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return SkillDetailActivity.l1(this.f24411a);
        }
    });
    private final Xa.k<SkillDetailDto> currentDtoFlow = Xa.u.a(null);
    private boolean lastInstalledChecked = true;

    /* renamed from: baseBottomPaddingPx$delegate, reason: from kotlin metadata */
    private final Y8.h baseBottomPaddingPx = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.detail.A
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return Integer.valueOf(SkillDetailActivity.n0(this.f24336a));
        }
    });
    private final ViewTreeObserver.OnGlobalLayoutListener footerLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.stepos.ailauncher.agent.skill.detail.B
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            SkillDetailActivity.v0(this.f24338a);
        }
    };
    private CharSequence descriptionFullText = "";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/detail/SkillDetailActivity$DetailSwitchMode;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "LOADING", "GREYED", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007JY\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0017R\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0017R\u0014\u0010\"\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u0017R\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u0017R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/detail/SkillDetailActivity$a;", "", "<init>", "()V", "", "md", "c", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", "context", "slug", "displayName", c.a.COL_SUMMARY, "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "skillItem", "", "testing", "Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", "sourceScope", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/agent/skill/SkillItem;ZLcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;)V", "TAG", "Ljava/lang/String;", "", "DESC_MAX_LINES_COLLAPSED", "I", "", "PALETTE_RES_IDS", "[I", "EXTRA_SLUG", "EXTRA_DISPLAY_NAME", "EXTRA_SUMMARY", "EXTRA_SKILL_ITEM", "EXTRA_TESTING", "EXTRA_SOURCE", "Lkotlin/text/Regex;", "YAML_FRONTMATTER", "Lkotlin/text/Regex;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.skill.detail.SkillDetailActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, Context context, String str, String str2, String str3, SkillItem skillItem, boolean z10, DisplayScope displayScope, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                str2 = null;
            }
            if ((i10 & 8) != 0) {
                str3 = null;
            }
            if ((i10 & 16) != 0) {
                skillItem = null;
            }
            if ((i10 & 32) != 0) {
                z10 = false;
            }
            if ((i10 & 64) != 0) {
                displayScope = null;
            }
            companion.a(context, str, str2, str3, skillItem, z10, displayScope);
        }

        public final void a(Context context, String slug, String displayName, String summary, SkillItem skillItem, boolean testing, DisplayScope sourceScope) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(slug, "slug");
            Intent intent = new Intent(context, (Class<?>) SkillDetailActivity.class);
            intent.putExtra(SkillDetailActivity.EXTRA_SLUG, slug);
            if (displayName != null && !La.H.x0(displayName)) {
                intent.putExtra(SkillDetailActivity.EXTRA_DISPLAY_NAME, displayName);
            }
            if (summary != null && !La.H.x0(summary)) {
                intent.putExtra(SkillDetailActivity.EXTRA_SUMMARY, summary);
            }
            if (skillItem != null) {
                intent.putExtra(SkillDetailActivity.EXTRA_SKILL_ITEM, skillItem);
            }
            if (testing) {
                intent.putExtra("extra.testing", true);
            }
            if (sourceScope != null) {
                intent.putExtra(SkillDetailActivity.EXTRA_SOURCE, sourceScope.name());
            }
            b5.i.INSTANCE.a(context, intent);
        }

        public final String c(String md) {
            kotlin.jvm.internal.p.i(md, "md");
            return SkillDetailActivity.YAML_FRONTMATTER.l(md, "");
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

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements View.OnLayoutChangeListener {
        public c() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            view.post(SkillDetailActivity.this.new d());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SkillDetailActivity.this.p1();
        }
    }

    public static final u8.e D0(SkillDetailActivity skillDetailActivity) {
        return skillDetailActivity.q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.core.view.a0 I0(View v10, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(v10, "v");
        kotlin.jvm.internal.p.i(insets, "insets");
        t0.e eVarF = insets.f(a0.o.g());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        v10.setPadding(eVarF.f41977a, eVarF.f41978b, eVarF.f41979c, eVarF.f41980d);
        return insets;
    }

    public static final void J0(SkillDetailActivity skillDetailActivity, View view) {
        skillDetailActivity.finish();
    }

    public static final void K0(SkillDetailActivity skillDetailActivity) {
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        C1125i c1125i = skillDetailActivity.binding;
        if (c1125i == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i = null;
        }
        ImageView ivBack = c1125i.ivBack;
        kotlin.jvm.internal.p.h(ivBack, "ivBack");
        skillDetailActivity.backGlassHandle = com.stepos.ailauncher.container.glass.h.m(hVar, ivBack, false, Float.valueOf(22.0f), y7.o.INSTANCE.i(), false, 16, null);
    }

    public static final void L0(SkillDetailActivity skillDetailActivity) {
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        C1125i c1125i = skillDetailActivity.binding;
        if (c1125i == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i = null;
        }
        View vTopFade = c1125i.vTopFade;
        kotlin.jvm.internal.p.h(vTopFade, "vTopFade");
        com.stepos.ailauncher.container.glass.h.v(hVar, vTopFade, false, G.a.f43886a.g(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.detail.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SkillDetailActivity.M0((A7.B) obj);
            }
        }, 2, null);
    }

    public static final Y8.t M0(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final void R0(final SkillItem skillItem, final SkillDetailActivity skillDetailActivity, View view) {
        if (skillItem != null) {
            C1125i c1125i = skillDetailActivity.binding;
            if (c1125i == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i = null;
            }
            FrameLayout btnTopUninstall = c1125i.btnTopUninstall;
            kotlin.jvm.internal.p.h(btnTopUninstall, "btnTopUninstall");
            T9.c(btnTopUninstall, 8.0f, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.detail.u
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return SkillDetailActivity.S0(this.f24401a, skillItem);
                }
            });
        }
    }

    public static final Y8.t S0(SkillDetailActivity skillDetailActivity, SkillItem skillItem) {
        skillDetailActivity.j1(skillItem);
        return Y8.t.f7040a;
    }

    public static final Y8.t T0(boolean z10) {
        return Y8.t.f7040a;
    }

    public static final Y8.t U0(boolean z10) {
        return Y8.t.f7040a;
    }

    public static final Y8.t V0(SkillDetailActivity skillDetailActivity, SkillItem skillItem, boolean z10) {
        kotlin.jvm.internal.p.f(skillItem);
        skillDetailActivity.N0(skillItem, false);
        return Y8.t.f7040a;
    }

    public static final Y8.t W0(SkillDetailActivity skillDetailActivity, SkillItem skillItem, boolean z10) {
        kotlin.jvm.internal.p.f(skillItem);
        skillDetailActivity.N0(skillItem, true);
        return Y8.t.f7040a;
    }

    public static final Y8.t Y0(final SkillDetailActivity skillDetailActivity, final String str, boolean z10) {
        C1125i c1125i = skillDetailActivity.binding;
        C1125i c1125i2 = null;
        if (c1125i == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i = null;
        }
        LinearLayout cardReadme = c1125i.cardReadme;
        kotlin.jvm.internal.p.h(cardReadme, "cardReadme");
        C1125i c1125i3 = skillDetailActivity.binding;
        if (c1125i3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i3 = null;
        }
        TextView btnReadmeViewFull = c1125i3.btnReadmeViewFull;
        kotlin.jvm.internal.p.h(btnReadmeViewFull, "btnReadmeViewFull");
        SkillMarkwonFactoryKt.e(cardReadme, btnReadmeViewFull, z10);
        if (z10) {
            C1125i c1125i4 = skillDetailActivity.binding;
            if (c1125i4 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1125i2 = c1125i4;
            }
            c1125i2.btnReadmeViewFull.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.detail.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SkillDetailActivity.Z0(this.f24382a, str, view);
                }
            });
        }
        return Y8.t.f7040a;
    }

    public static final void Z0(SkillDetailActivity skillDetailActivity, String str, View view) {
        new p0(skillDetailActivity, skillDetailActivity.z0(), str).show();
    }

    public static final void b1(SkillDetailActivity skillDetailActivity) {
        skillDetailActivity.p1();
    }

    public static final void c1(SkillDetailActivity skillDetailActivity, SkillItem skillItem, View view) {
        skillDetailActivity.H0(skillItem);
    }

    public static final void d1(SkillDetailActivity skillDetailActivity) {
        skillDetailActivity.p1();
    }

    public static final void e1(SkillDetailActivity skillDetailActivity, SkillItem skillItem, View view) {
        skillDetailActivity.P0(skillItem);
    }

    public static final void f1(SkillDetailActivity skillDetailActivity) {
        skillDetailActivity.p1();
    }

    private final void g0(CharSequence text) {
        this.descriptionFullText = text;
        this.descriptionExpanded = false;
        C1125i c1125i = this.binding;
        C1125i c1125i2 = null;
        if (c1125i == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i = null;
        }
        c1125i.tvDescription.setText(text);
        C1125i c1125i3 = this.binding;
        if (c1125i3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i3 = null;
        }
        c1125i3.tvDescription.setMaxLines(2);
        C1125i c1125i4 = this.binding;
        if (c1125i4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i4 = null;
        }
        c1125i4.tvDescription.setEllipsize(TextUtils.TruncateAt.END);
        C1125i c1125i5 = this.binding;
        if (c1125i5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i5 = null;
        }
        c1125i5.llDescriptionToggle.setVisibility(8);
        C1125i c1125i6 = this.binding;
        if (c1125i6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i6 = null;
        }
        c1125i6.llDescriptionToggle.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.detail.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SkillDetailActivity.h0(this.f24379a, view);
            }
        });
        C1125i c1125i7 = this.binding;
        if (c1125i7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i7 = null;
        }
        c1125i7.tvDescriptionToggle.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.detail.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SkillDetailActivity.i0(this.f24380a, view);
            }
        });
        C1125i c1125i8 = this.binding;
        if (c1125i8 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1125i2 = c1125i8;
        }
        c1125i2.tvDescription.post(new Runnable() { // from class: com.stepos.ailauncher.agent.skill.detail.l
            @Override // java.lang.Runnable
            public final void run() {
                SkillDetailActivity.j0(this.f24381a);
            }
        });
    }

    public static final void h0(SkillDetailActivity skillDetailActivity, View view) {
        skillDetailActivity.o1();
    }

    public static final CharSequence h1(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return "- " + it;
    }

    public static final void i0(SkillDetailActivity skillDetailActivity, View view) {
        skillDetailActivity.o1();
    }

    public static final void j0(SkillDetailActivity skillDetailActivity) {
        C1125i c1125i = skillDetailActivity.binding;
        C1125i c1125i2 = null;
        if (c1125i == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i = null;
        }
        Layout layout = c1125i.tvDescription.getLayout();
        if (layout == null) {
            return;
        }
        if (layout.getLineCount() > 2 || (layout.getLineCount() == 2 && layout.getEllipsisCount(1) > 0)) {
            C1125i c1125i3 = skillDetailActivity.binding;
            if (c1125i3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1125i2 = c1125i3;
            }
            c1125i2.llDescriptionToggle.setVisibility(0);
            skillDetailActivity.k0(false);
            return;
        }
        C1125i c1125i4 = skillDetailActivity.binding;
        if (c1125i4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i4 = null;
        }
        c1125i4.tvDescription.setMaxLines(Integer.MAX_VALUE);
        C1125i c1125i5 = skillDetailActivity.binding;
        if (c1125i5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i5 = null;
        }
        c1125i5.tvDescription.setEllipsize(null);
        C1125i c1125i6 = skillDetailActivity.binding;
        if (c1125i6 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1125i2 = c1125i6;
        }
        c1125i2.llDescriptionToggle.setVisibility(8);
    }

    private final void k0(boolean expanded) {
        C1125i c1125i = null;
        if (expanded) {
            C1125i c1125i2 = this.binding;
            if (c1125i2 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i2 = null;
            }
            c1125i2.tvDescription.setMaxLines(Integer.MAX_VALUE);
            C1125i c1125i3 = this.binding;
            if (c1125i3 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i3 = null;
            }
            c1125i3.tvDescription.setEllipsize(null);
            C1125i c1125i4 = this.binding;
            if (c1125i4 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i4 = null;
            }
            c1125i4.vDescriptionFade.setVisibility(8);
            C1125i c1125i5 = this.binding;
            if (c1125i5 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1125i = c1125i5;
            }
            c1125i.tvDescriptionToggle.setText(getString(R$string.skill_detail_desc_collapse));
            return;
        }
        C1125i c1125i6 = this.binding;
        if (c1125i6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i6 = null;
        }
        c1125i6.tvDescription.setMaxLines(2);
        C1125i c1125i7 = this.binding;
        if (c1125i7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i7 = null;
        }
        c1125i7.tvDescription.setEllipsize(TextUtils.TruncateAt.END);
        C1125i c1125i8 = this.binding;
        if (c1125i8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i8 = null;
        }
        c1125i8.vDescriptionFade.setVisibility(0);
        C1125i c1125i9 = this.binding;
        if (c1125i9 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1125i = c1125i9;
        }
        c1125i.tvDescriptionToggle.setText(getString(R$string.skill_detail_desc_expand));
    }

    public static final Y8.t k1(SkillDetailActivity skillDetailActivity, SkillItem skillItem) {
        skillDetailActivity.O0(skillItem);
        return Y8.t.f7040a;
    }

    public static final String l1(SkillDetailActivity skillDetailActivity) {
        String str = skillDetailActivity.slug;
        if (str == null) {
            kotlin.jvm.internal.p.A("slug");
            str = null;
        }
        return "skillDetail_" + str + "_" + skillDetailActivity.hashCode();
    }

    public static /* synthetic */ void m0(SkillDetailActivity skillDetailActivity, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        skillDetailActivity.l0(str, str2, str3);
    }

    public static final int n0(SkillDetailActivity skillDetailActivity) {
        return (int) (20 * skillDetailActivity.getResources().getDisplayMetrics().density);
    }

    private final void o1() {
        boolean z10 = !this.descriptionExpanded;
        this.descriptionExpanded = z10;
        k0(z10);
    }

    public static final void s0(InterfaceC5074l interfaceC5074l, boolean z10, View view) {
        interfaceC5074l.invoke(Boolean.valueOf(!z10));
    }

    public static final void v0(SkillDetailActivity skillDetailActivity) {
        skillDetailActivity.n1();
    }

    private final String w0(String raw) {
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

    private final u8.e z0() {
        return (u8.e) this.markwon.getValue();
    }

    public final X4.a A0() {
        return (X4.a) D5.a.INSTANCE.a(X4.a.class);
    }

    public final String B0() {
        return (String) this.subscriberId.getValue();
    }

    public final void C0(String slug, int testing) {
        C1060i.d(C1398p.a(this), null, null, new SkillDetailActivity$loadDetail$1(slug, testing, this, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object E0(com.stepos.ailauncher.agent.skill.SkillStatus r55, e9.InterfaceC4014c<? super Y8.t> r56) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.detail.SkillDetailActivity.E0(com.stepos.ailauncher.agent.skill.SkillStatus, e9.c):java.lang.Object");
    }

    public final void F0() {
        X4.a aVarA0 = A0();
        if (aVarA0 == null) {
            return;
        }
        C1060i.d(C1398p.a(this), null, null, new SkillDetailActivity$observeOperaErrors$1(this, aVarA0, null), 3, null);
    }

    public final void G0() {
        X4.a aVarA0 = A0();
        if (aVarA0 != null) {
            C1060i.d(C1398p.a(this), null, null, new SkillDetailActivity$observeOperaState$1(this, aVarA0, null), 3, null);
        } else {
            C4148a.u(TAG, "observeOperaState: ISkillOperaService not registered", false, 4, null);
            Q0(null, false, false);
        }
    }

    public final void H0(SkillItem item) {
        SkillItem skillItem;
        SkillItem skillItemCopy$default;
        SkillItem skillItemG;
        if (item == null) {
            X4.a aVarA0 = A0();
            if (aVarA0 != null) {
                String str = this.slug;
                if (str == null) {
                    kotlin.jvm.internal.p.A("slug");
                    str = null;
                }
                skillItemG = aVarA0.g(str);
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
            skillItemCopy$default = SkillItem.copy$default(skillItem, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, 0, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, this.isTesting ? SkillSource.TESTING : SkillSource.NORMAL, -1, 7, null);
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
            Toast.makeText(this, getString(R$string.skill_detail_toast_loading), 0).show();
            return;
        }
        X4.a aVarA02 = A0();
        if (aVarA02 == null) {
            Toast.makeText(this, getString(R$string.skill_detail_toast_service_not_ready), 0).show();
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
        int i10 = status == null ? -1 : b.$EnumSwitchMapping$0[status.ordinal()];
        if (i10 == 4) {
            SkillAnalytics.INSTANCE.t(skillItemCopy$default, DisplayScope.SKILL_DETAIL);
            aVarA02.n(skillItemCopy$default);
        } else if (i10 == 5) {
            SkillAnalytics.INSTANCE.t(skillItemCopy$default, DisplayScope.SKILL_DETAIL);
            aVarA02.i(skillItemCopy$default);
        } else if (i10 == 6 || i10 == 7) {
            aVarA02.f(skillItemCopy$default);
        }
    }

    public final void N0(SkillItem item, boolean enable) {
        X4.a aVarA0 = A0();
        if (aVarA0 == null) {
            Toast.makeText(this, getString(R$string.skill_detail_toast_service_not_ready), 0).show();
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
        SkillAnalytics.INSTANCE.u(item, DisplayScope.SKILL_DETAIL);
        C1060i.d(C1398p.a(this), null, null, new SkillDetailActivity$onToggle$1(enable, aVarA0, item, null), 3, null);
    }

    public final void O0(SkillItem item) {
        X4.a aVarA0 = A0();
        if (aVarA0 == null) {
            Toast.makeText(this, getString(R$string.skill_detail_toast_service_not_ready), 0).show();
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
        SkillAnalytics skillAnalytics = SkillAnalytics.INSTANCE;
        DisplayScope displayScope = this.entrySource;
        if (displayScope == null) {
            displayScope = DisplayScope.SKILL_DETAIL;
        }
        skillAnalytics.v(item, displayScope);
        aVarA0.h(item);
    }

    public final void P0(SkillItem item) {
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
            X4.a aVarA0 = A0();
            if (aVarA0 != null) {
                String str2 = this.slug;
                if (str2 == null) {
                    kotlin.jvm.internal.p.A("slug");
                    str2 = null;
                }
                skillItemG = aVarA0.g(str2);
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
            SkillSource skillSource = this.isTesting ? SkillSource.TESTING : SkillSource.NORMAL;
            if (version != null) {
                str = version;
                skillItemCopy$default = SkillItem.copy$default(skillItem, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, 0L, 0, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, skillSource, -8193, 7, null);
            } else if (item != null) {
                version = item.getVersion();
                str = version;
                skillItemCopy$default = SkillItem.copy$default(skillItem, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, 0L, 0, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, skillSource, -8193, 7, null);
            } else {
                str = null;
                skillItemCopy$default = SkillItem.copy$default(skillItem, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, 0L, 0, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, skillSource, -8193, 7, null);
            }
        } else {
            skillItemCopy$default = null;
        }
        if (skillItemCopy$default == null) {
            Toast.makeText(this, getString(R$string.skill_detail_toast_loading), 0).show();
            return;
        }
        X4.a aVarA02 = A0();
        if (aVarA02 == null) {
            Toast.makeText(this, getString(R$string.skill_detail_toast_service_not_ready), 0).show();
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
        aVarA02.k(skillItemCopy$default);
    }

    public final void Q0(final SkillItem item, boolean isToggling, boolean isUninstalling) {
        FrameLayout frameLayoutR0;
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
        c1125i10.btnTopUninstall.setAlpha((!(z10 || status == SkillStatus.INSTALLING) || z11) ? 1.0f : 0.4f);
        C1125i c1125i11 = this.binding;
        if (c1125i11 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i11 = null;
        }
        c1125i11.btnTopUninstall.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.detail.C
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SkillDetailActivity.R0(item, this, view);
            }
        });
        C1125i c1125i12 = this.binding;
        if (c1125i12 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i12 = null;
        }
        c1125i12.actionArea.removeAllViews();
        if (z10) {
            frameLayoutR0 = r0(this.lastInstalledChecked, DetailSwitchMode.LOADING, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.detail.D
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return SkillDetailActivity.T0(((Boolean) obj).booleanValue());
                }
            });
        } else if (z11) {
            frameLayoutR0 = r0(this.lastInstalledChecked, DetailSwitchMode.GREYED, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.detail.d
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return SkillDetailActivity.U0(((Boolean) obj).booleanValue());
                }
            });
        } else {
            int i11 = status != null ? b.$EnumSwitchMapping$0[status.ordinal()] : -1;
            frameLayoutR0 = (i11 == 1 || i11 == 2) ? r0(true, DetailSwitchMode.NORMAL, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.detail.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return SkillDetailActivity.V0(this.f24365a, item, ((Boolean) obj).booleanValue());
                }
            }) : i11 != 3 ? null : r0(false, DetailSwitchMode.NORMAL, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.detail.f
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return SkillDetailActivity.W0(this.f24367a, item, ((Boolean) obj).booleanValue());
                }
            });
        }
        if (frameLayoutR0 != null) {
            C1125i c1125i13 = this.binding;
            if (c1125i13 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1125i = c1125i13;
            }
            c1125i.actionArea.addView(frameLayoutR0);
        }
        a1(item, status, z10, z11);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object X0(com.stepos.ailauncher.agent.skill.detail.SkillDetailDto r23, e9.InterfaceC4014c<? super Y8.t> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 733
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.detail.SkillDetailActivity.X0(com.stepos.ailauncher.agent.skill.detail.F, e9.c):java.lang.Object");
    }

    public final void a1(final SkillItem item, SkillStatus status, boolean isTogglingNow, boolean isUninstallingNow) {
        SkillDetailDto value = this.currentDtoFlow.getValue();
        boolean z10 = value != null && value.getNeedUpdate() == 1;
        boolean z11 = status == SkillStatus.INSTALLED || status == SkillStatus.INSTALLED_ENABLED || status == SkillStatus.INSTALLED_DISABLED;
        boolean z12 = status == SkillStatus.INSTALLING || status == SkillStatus.QUEUED;
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
            } else {
                c1125i = c1125i3;
            }
            c1125i.footerContainer.requestLayout();
            return;
        }
        if (z12) {
            C1125i c1125i4 = this.binding;
            if (c1125i4 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i4 = null;
            }
            c1125i4.footerContainer.setVisibility(0);
            C1125i c1125i5 = this.binding;
            if (c1125i5 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i5 = null;
            }
            c1125i5.btnBottomUpdate.setVisibility(0);
            C1125i c1125i6 = this.binding;
            if (c1125i6 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i6 = null;
            }
            c1125i6.btnBottomUpdate.setText("");
            C1125i c1125i7 = this.binding;
            if (c1125i7 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i7 = null;
            }
            c1125i7.btnBottomUpdate.setClickable(false);
            C1125i c1125i8 = this.binding;
            if (c1125i8 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i8 = null;
            }
            c1125i8.btnBottomUpdate.setOnClickListener(null);
            C1125i c1125i9 = this.binding;
            if (c1125i9 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i9 = null;
            }
            c1125i9.pbBottomUpdate.setVisibility(0);
            C1125i c1125i10 = this.binding;
            if (c1125i10 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i10 = null;
            }
            c1125i10.pbBottomUpdate.setColor(b5.m.INSTANCE.i(this));
            C1125i c1125i11 = this.binding;
            if (c1125i11 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i11 = null;
            }
            c1125i11.footerContainer.setOnClickListener(null);
            C1125i c1125i12 = this.binding;
            if (c1125i12 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i12 = null;
            }
            c1125i12.btnBottomUpdate.post(new Runnable() { // from class: com.stepos.ailauncher.agent.skill.detail.o
                @Override // java.lang.Runnable
                public final void run() {
                    SkillDetailActivity.b1(this.f24389a);
                }
            });
        } else if (status == SkillStatus.UNINSTALLED || status == SkillStatus.INSTALL_FAILED) {
            C1125i c1125i13 = this.binding;
            if (c1125i13 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i13 = null;
            }
            c1125i13.footerContainer.setVisibility(0);
            C1125i c1125i14 = this.binding;
            if (c1125i14 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i14 = null;
            }
            c1125i14.btnBottomUpdate.setVisibility(0);
            C1125i c1125i15 = this.binding;
            if (c1125i15 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i15 = null;
            }
            c1125i15.pbBottomUpdate.setVisibility(8);
            C1125i c1125i16 = this.binding;
            if (c1125i16 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i16 = null;
            }
            c1125i16.btnBottomUpdate.setText(getString(R$string.skill_detail_action_install_full));
            C1125i c1125i17 = this.binding;
            if (c1125i17 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i17 = null;
            }
            c1125i17.btnBottomUpdate.setEnabled(true);
            C1125i c1125i18 = this.binding;
            if (c1125i18 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i18 = null;
            }
            c1125i18.btnBottomUpdate.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.detail.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SkillDetailActivity.c1(this.f24391a, item, view);
                }
            });
            C1125i c1125i19 = this.binding;
            if (c1125i19 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i19 = null;
            }
            c1125i19.btnBottomUpdate.post(new Runnable() { // from class: com.stepos.ailauncher.agent.skill.detail.q
                @Override // java.lang.Runnable
                public final void run() {
                    SkillDetailActivity.d1(this.f24393a);
                }
            });
        } else if (z11 && z10) {
            C1125i c1125i20 = this.binding;
            if (c1125i20 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i20 = null;
            }
            c1125i20.footerContainer.setVisibility(0);
            C1125i c1125i21 = this.binding;
            if (c1125i21 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i21 = null;
            }
            c1125i21.btnBottomUpdate.setVisibility(0);
            C1125i c1125i22 = this.binding;
            if (c1125i22 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i22 = null;
            }
            c1125i22.pbBottomUpdate.setVisibility(8);
            C1125i c1125i23 = this.binding;
            if (c1125i23 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i23 = null;
            }
            c1125i23.btnBottomUpdate.setText(getString(R$string.skill_detail_action_update));
            C1125i c1125i24 = this.binding;
            if (c1125i24 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i24 = null;
            }
            c1125i24.btnBottomUpdate.setEnabled(true);
            C1125i c1125i25 = this.binding;
            if (c1125i25 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i25 = null;
            }
            c1125i25.btnBottomUpdate.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.detail.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SkillDetailActivity.e1(this.f24395a, item, view);
                }
            });
            C1125i c1125i26 = this.binding;
            if (c1125i26 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i26 = null;
            }
            c1125i26.btnBottomUpdate.post(new Runnable() { // from class: com.stepos.ailauncher.agent.skill.detail.s
                @Override // java.lang.Runnable
                public final void run() {
                    SkillDetailActivity.f1(this.f24398a);
                }
            });
        } else {
            C1125i c1125i27 = this.binding;
            if (c1125i27 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i27 = null;
            }
            c1125i27.footerContainer.setVisibility(8);
        }
        C1125i c1125i28 = this.binding;
        if (c1125i28 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1125i = c1125i28;
        }
        c1125i.footerContainer.requestLayout();
    }

    public final void g1(SkillDetailDto dto, SkillStatus currentStatus) {
        String version;
        String packageSize;
        List listM;
        List<String> listD;
        boolean z10 = dto != null && dto.getNeedUpdate() == 1 && (u0(currentStatus) == SkillStatus.INSTALLED || u0(currentStatus) == SkillStatus.INSTALLED_ENABLED || u0(currentStatus) == SkillStatus.INSTALLED_DISABLED);
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
            c1125i2.tvUpdateBannerChangelog.setText(Z8.F.A0(listM, "\n", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.detail.t
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return SkillDetailActivity.h1((String) obj2);
                }
            }, 30, null));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i1(com.stepos.ailauncher.agent.skill.detail.SkillDetailDto r6) {
        /*
            r5 = this;
            boolean r0 = r5.detailShowReported
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r5.detailShowReported = r0
            java.lang.String r0 = r6.getName()
            java.lang.String r1 = "slug"
            r2 = 0
            if (r0 == 0) goto L1c
            boolean r3 = La.H.x0(r0)
            if (r3 != 0) goto L19
            goto L1a
        L19:
            r0 = r2
        L1a:
            if (r0 != 0) goto L24
        L1c:
            java.lang.String r0 = r5.slug
            if (r0 != 0) goto L24
            kotlin.jvm.internal.p.A(r1)
            r0 = r2
        L24:
            java.lang.String r6 = com.stepos.ailauncher.agent.skill.detail.G.a(r6)
            if (r6 != 0) goto L2c
            java.lang.String r6 = ""
        L2c:
            X4.a r3 = r5.A0()
            if (r3 == 0) goto L49
            java.lang.String r4 = r5.slug
            if (r4 != 0) goto L3a
            kotlin.jvm.internal.p.A(r1)
            r4 = r2
        L3a:
            com.stepos.ailauncher.agent.skill.SkillItem r1 = r3.g(r4)
            if (r1 == 0) goto L49
            com.stepos.ailauncher.agent.skill.SkillStatus r1 = r1.getStatus()
            if (r1 != 0) goto L47
            goto L49
        L47:
            r2 = r1
            goto L51
        L49:
            com.stepos.ailauncher.agent.skill.SkillItem r5 = r5.fallbackItem
            if (r5 == 0) goto L51
            com.stepos.ailauncher.agent.skill.SkillStatus r2 = r5.getStatus()
        L51:
            com.stepos.ailauncher.agent.skill.SkillStatus r5 = com.stepos.ailauncher.agent.skill.SkillStatus.INSTALLED
            if (r2 == r5) goto L62
            com.stepos.ailauncher.agent.skill.SkillStatus r5 = com.stepos.ailauncher.agent.skill.SkillStatus.INSTALLED_ENABLED
            if (r2 == r5) goto L62
            com.stepos.ailauncher.agent.skill.SkillStatus r5 = com.stepos.ailauncher.agent.skill.SkillStatus.INSTALLED_DISABLED
            if (r2 != r5) goto L5e
            goto L62
        L5e:
            java.lang.String r5 = "uninstalled"
            goto L64
        L62:
            java.lang.String r5 = "installed"
        L64:
            com.stepos.ailauncher.agent.analytics.SkillAnalytics r1 = com.stepos.ailauncher.agent.analytics.SkillAnalytics.INSTANCE
            r1.i(r0, r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.detail.SkillDetailActivity.i1(com.stepos.ailauncher.agent.skill.detail.F):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024 A[PHI: r0
      0x0024: PHI (r0v7 java.lang.String) = (r0v4 java.lang.String), (r0v9 java.lang.String) binds: [B:17:0x0028, B:13:0x0021] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j1(final com.stepos.ailauncher.agent.skill.SkillItem r4) {
        /*
            r3 = this;
            Y4.i r0 = r3.binding
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
            java.lang.String r0 = r3.slug
            if (r0 != 0) goto L24
            java.lang.String r0 = "slug"
            kotlin.jvm.internal.p.A(r0)
        L30:
            com.stepos.ailauncher.agent.skill.detail.B0 r0 = new com.stepos.ailauncher.agent.skill.detail.B0
            com.stepos.ailauncher.agent.skill.detail.v r2 = new com.stepos.ailauncher.agent.skill.detail.v
            r2.<init>()
            r0.<init>(r3, r1, r2)
            r0.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.detail.SkillDetailActivity.j1(com.stepos.ailauncher.agent.skill.SkillItem):void");
    }

    public final void l0(String identifier, String displayName, String iconUrl) {
        d5.m mVar = d5.m.INSTANCE;
        int[] iArr = PALETTE_RES_IDS;
        int iC = androidx.core.content.a.c(this, iArr[mVar.e(identifier, iArr.length)]);
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

    public final void m1(SkillItem item) {
        SkillStatus status;
        SkillDetailDto value;
        g1(this.currentDtoFlow.getValue(), item != null ? item.getStatus() : null);
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
            g1(skillDetailDtoB, item.getStatus());
        }
    }

    public final void n1() {
        C1125i c1125i = this.binding;
        C1125i c1125i2 = null;
        if (c1125i == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i = null;
        }
        FrameLayout footerContainer = c1125i.footerContainer;
        kotlin.jvm.internal.p.h(footerContainer, "footerContainer");
        int iY0 = footerContainer.getVisibility() == 8 ? y0() : footerContainer.getHeight() + y0();
        C1125i c1125i3 = this.binding;
        if (c1125i3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i3 = null;
        }
        if (c1125i3.scrollView.getPaddingBottom() != iY0) {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("sync scrollView paddingBottom=%d (footerVisible=%s footerH=%d)", Arrays.copyOf(new Object[]{Integer.valueOf(iY0), Boolean.valueOf(footerContainer.getVisibility() != 8), Integer.valueOf(footerContainer.getHeight())}, 3));
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
            scrollView.setPadding(scrollView.getPaddingLeft(), scrollView.getPaddingTop(), scrollView.getPaddingRight(), iY0);
        }
    }

    public final void o0(View rowRoot, String label) {
        ((TextView) rowRoot.findViewById(R$id.tv_meta_label)).setText(label);
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x021d  */
    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r55) {
        /*
            Method dump skipped, instructions count: 764
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.detail.SkillDetailActivity.onCreate(android.os.Bundle):void");
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        X4.a aVarA0;
        super.onDestroy();
        if (this.slug != null && (aVarA0 = A0()) != null) {
            aVarA0.a(B0());
        }
        C1125i c1125i = this.binding;
        if (c1125i == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i = null;
        }
        c1125i.footerContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this.footerLayoutListener);
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        hVar.F(this.footerBlurHandle);
        this.footerBlurHandle = null;
        hVar.F(this.backGlassHandle);
        this.backGlassHandle = null;
        hVar.F(this.uninstallGlassHandle);
        this.uninstallGlassHandle = null;
    }

    public final void p0(View rowRoot, String value) {
        TextView textView = (TextView) rowRoot.findViewById(R$id.tv_meta_value);
        if (La.H.x0(value)) {
            value = O6.l.DATE_SEPARATOR;
        }
        textView.setText(value);
    }

    public final void p1() {
        if (this.footerBlurHandle == null && !this.footerBlurUnsupported) {
            C1125i c1125i = this.binding;
            if (c1125i == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i = null;
            }
            TextView btnBottomUpdate = c1125i.btnBottomUpdate;
            kotlin.jvm.internal.p.h(btnBottomUpdate, "btnBottomUpdate");
            if (btnBottomUpdate.getVisibility() == 0 && btnBottomUpdate.isAttachedToWindow()) {
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

    public final u8.e q0() {
        return SkillMarkwonFactoryKt.b(this);
    }

    public final FrameLayout r0(final boolean checked, DetailSwitchMode mode, final InterfaceC5074l<? super Boolean, Y8.t> onCheckChange) {
        float f10 = getResources().getDisplayMetrics().density;
        int i10 = (int) (40 * f10);
        int i11 = (int) (22 * f10);
        int i12 = (int) (14 * f10);
        int i13 = (int) (4 * f10);
        int iC = androidx.core.content.a.c(this, R$color.sd_link);
        int iC2 = androidx.core.content.a.c(this, R$color.skill_switch_track_off_value);
        FrameLayout frameLayout = new FrameLayout(this);
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
            IndeterminateSpinnerView indeterminateSpinnerView = new IndeterminateSpinnerView(this, null, 0, 6, null);
            indeterminateSpinnerView.setColor(b5.m.INSTANCE.i(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i11, i11);
            layoutParams.gravity = 17;
            Y8.t tVar = Y8.t.f7040a;
            frameLayout.addView(indeterminateSpinnerView, layoutParams);
            frameLayout.setClickable(false);
            return frameLayout;
        }
        View view = new View(this);
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
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.detail.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SkillDetailActivity.s0(onCheckChange, checked, view2);
            }
        });
        return frameLayout;
    }

    public final SkillStatus t0() {
        X4.a aVarA0 = A0();
        if (aVarA0 != null) {
            String str = this.slug;
            if (str == null) {
                kotlin.jvm.internal.p.A("slug");
                str = null;
            }
            SkillItem skillItemG = aVarA0.g(str);
            if (skillItemG != null) {
                return skillItemG.getStatus();
            }
        }
        return null;
    }

    public final SkillStatus u0(SkillStatus tableStatus) {
        if (tableStatus != null) {
            return tableStatus;
        }
        SkillItem skillItem = this.fallbackItem;
        if (skillItem != null) {
            return skillItem.getStatus();
        }
        return null;
    }

    public final String x0(Long count) {
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

    public final int y0() {
        return ((Number) this.baseBottomPaddingPx.getValue()).intValue();
    }
}
