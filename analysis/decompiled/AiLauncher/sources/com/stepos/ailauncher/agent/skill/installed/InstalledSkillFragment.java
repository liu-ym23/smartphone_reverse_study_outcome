package com.stepos.ailauncher.agent.skill.installed;

import Ua.C1060i;
import Ua.M;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.C1398p;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.MotionEvent;
import android.view.RepeatOnLifecycleKt;
import android.view.U;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.analytics.SkillAnalytics;
import com.stepos.ailauncher.agent.skill.InstallKind;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.adapter.DisplayScope;
import com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment;
import com.stepos.ailauncher.agent.skill.installed.adapter.InstalledRow;
import com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel;
import com.stepos.ailauncher.chat.view.T9;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.contract.api.feishu.IFeishuConnectService;
import com.stepos.ailauncher.contract.api.wecom.IWecomConnectService;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 L2\u00020\u0001:\u0002MNB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J%\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J!\u0010#\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0004H\u0016¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\u0004H\u0016¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\u0004H\u0016¢\u0006\u0004\b+\u0010\u0003R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010\u0005R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010;R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R&\u0010D\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C0A0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010\u0005R\u0014\u0010I\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010K\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010H¨\u0006O"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installed/InstalledSkillFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "LY8/t;", "Z", "b0", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "v0", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;)V", "Landroid/view/MotionEvent;", "ev", "f0", "(Landroid/view/MotionEvent;)V", "e0", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "Lkotlin/Function0;", "onUninstall", "B0", "(Landroid/view/View;Lp9/a;)V", "Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$b;", VoiceWakeupReceiver.EXTRA_STATE, "w0", "(Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$b;)V", "", "mainRes", "subRes", "A0", "(II)V", "z0", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "hidden", "onHiddenChanged", "(Z)V", "onResume", "onPause", "onDestroyView", "Landroid/widget/TextView;", "pagingFooter", "Landroid/widget/TextView;", "canLoadNextPage", "LY4/t;", "binding", "LY4/t;", "Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel;", "viewModel", "Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel;", "Lcom/stepos/ailauncher/agent/skill/installed/InstalledSkillFragment$b;", "adapter", "Lcom/stepos/ailauncher/agent/skill/installed/InstalledSkillFragment$b;", "Ly7/E;", "backGlassHandle", "Ly7/E;", "clearGlassHandle", "", "lastKeystrokeTsMs", "J", "", "Lkotlin/Pair;", "", "Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", "exposedKeys", "Ljava/util/Set;", "pageShowReported", "e", "()Z", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InstalledSkillFragment extends com.stepos.ailauncher.sheet.nav.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "installed_skill";
    private b adapter;
    private y7.E backGlassHandle;
    private Y4.t binding;
    private boolean canLoadNextPage;
    private y7.E clearGlassHandle;
    private final Set<Pair<String, DisplayScope>> exposedKeys;
    private long lastKeystrokeTsMs;
    private boolean pageShowReported;
    private TextView pagingFooter;
    private InstalledSkillViewModel viewModel;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installed/InstalledSkillFragment$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/agent/skill/installed/InstalledSkillFragment;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/agent/skill/installed/InstalledSkillFragment;", "", "TAG", "Ljava/lang/String;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.skill.installed.InstalledSkillFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final InstalledSkillFragment a() {
            return new InstalledSkillFragment();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0002\u0018\u0000 \u00192\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001a\u001bB5\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u00020\u00072\n\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0017R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installed/InstalledSkillFragment$b;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/stepos/ailauncher/agent/skill/installed/adapter/a;", "Lcom/stepos/ailauncher/agent/skill/installed/InstalledSkillFragment$b$c;", "Lkotlin/Function2;", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "Landroid/view/View;", "LY8/t;", "onUninstallClick", "Lkotlin/Function1;", "onCardClick", "<init>", "(Lp9/p;Lp9/l;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "f", "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/agent/skill/installed/InstalledSkillFragment$b$c;", "holder", "position", "e", "(Lcom/stepos/ailauncher/agent/skill/installed/InstalledSkillFragment$b$c;I)V", "Lp9/p;", "Lp9/l;", "Companion", "c", Const.INTENT_KEY_PKGNAME, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends ListAdapter<InstalledRow, c> {
        private static final a DIFF = new a();
        private final InterfaceC5074l<SkillItem, Y8.t> onCardClick;
        private final p9.p<SkillItem, View, Y8.t> onUninstallClick;

        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"com/stepos/ailauncher/agent/skill/installed/InstalledSkillFragment$b$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/stepos/ailauncher/agent/skill/installed/adapter/a;", "oldItem", "newItem", "", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/agent/skill/installed/adapter/a;Lcom/stepos/ailauncher/agent/skill/installed/adapter/a;)Z", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class a extends DiffUtil.ItemCallback<InstalledRow> {
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean areContentsTheSame(InstalledRow oldItem, InstalledRow newItem) {
                kotlin.jvm.internal.p.i(oldItem, "oldItem");
                kotlin.jvm.internal.p.i(newItem, "newItem");
                return kotlin.jvm.internal.p.d(oldItem, newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean areItemsTheSame(InstalledRow oldItem, InstalledRow newItem) {
                kotlin.jvm.internal.p.i(oldItem, "oldItem");
                kotlin.jvm.internal.p.i(newItem, "newItem");
                return kotlin.jvm.internal.p.d(oldItem.getItem().getIdentifier(), newItem.getItem().getIdentifier());
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installed/InstalledSkillFragment$b$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/stepos/ailauncher/agent/skill/installed/InstalledSkillFragment$b;Landroid/view/View;)V", "Lcom/stepos/ailauncher/agent/skill/installed/adapter/a;", "row", "LY8/t;", "c", "(Lcom/stepos/ailauncher/agent/skill/installed/adapter/a;)V", "Landroid/widget/ImageView;", "icon", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "subtitle", "more", "Landroid/view/View;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public final class c extends RecyclerView.ViewHolder {
            private final ImageView icon;
            private final View more;
            private final TextView subtitle;
            final /* synthetic */ b this$0;
            private final TextView title;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(b bVar, View itemView) {
                super(itemView);
                kotlin.jvm.internal.p.i(itemView, "itemView");
                this.this$0 = bVar;
                View viewFindViewById = itemView.findViewById(R$id.iv_item_icon);
                kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
                this.icon = (ImageView) viewFindViewById;
                View viewFindViewById2 = itemView.findViewById(R$id.tv_title);
                kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
                this.title = (TextView) viewFindViewById2;
                View viewFindViewById3 = itemView.findViewById(R$id.tv_subtitle);
                kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
                this.subtitle = (TextView) viewFindViewById3;
                View viewFindViewById4 = itemView.findViewById(R$id.btn_more);
                kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
                this.more = viewFindViewById4;
            }

            public static final void d(b bVar, SkillItem skillItem, View view) {
                bVar.onCardClick.invoke(skillItem);
            }

            public static final void e(InstalledRow installedRow, b bVar, SkillItem skillItem, c cVar, View view) {
                if (installedRow.getIsUninstalling()) {
                    return;
                }
                bVar.onUninstallClick.invoke(skillItem, cVar.more);
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void c(final com.stepos.ailauncher.agent.skill.installed.adapter.InstalledRow r11) {
                /*
                    r10 = this;
                    java.lang.String r0 = "row"
                    kotlin.jvm.internal.p.i(r11, r0)
                    com.stepos.ailauncher.agent.skill.SkillItem r0 = r11.getItem()
                    android.widget.TextView r1 = r10.title
                    java.lang.String r2 = r0.getDisplayName()
                    r3 = 0
                    if (r2 == 0) goto L1e
                    boolean r4 = La.H.x0(r2)
                    if (r4 != 0) goto L1a
                    goto L1b
                L1a:
                    r2 = r3
                L1b:
                    if (r2 == 0) goto L1e
                    goto L22
                L1e:
                    java.lang.String r2 = r0.getName()
                L22:
                    r1.setText(r2)
                    android.widget.TextView r1 = r10.subtitle
                    java.lang.String r2 = r0.getSummary()
                    r1.setText(r2)
                    java.lang.String r1 = r0.getIdentifier()
                    java.lang.String r2 = "lark-cli"
                    boolean r2 = kotlin.jvm.internal.p.d(r1, r2)
                    if (r2 == 0) goto L42
                    android.widget.ImageView r1 = r10.icon
                    int r2 = com.stepos.ailauncher.chat.R$drawable.ic_cli_feishu
                    r1.setImageResource(r2)
                    goto L62
                L42:
                    java.lang.String r2 = "wecom-cli"
                    boolean r1 = kotlin.jvm.internal.p.d(r1, r2)
                    if (r1 == 0) goto L53
                    android.widget.ImageView r1 = r10.icon
                    int r2 = com.stepos.ailauncher.chat.R$drawable.ic_cli_wecom
                    r1.setImageResource(r2)
                    goto L62
                L53:
                    android.widget.ImageView r4 = r10.icon
                    java.lang.String r5 = r0.getIconUrl()
                    int r6 = com.stepos.ailauncher.agent.R$drawable.ic_amoo_market_agent
                    r8 = 8
                    r9 = 0
                    r7 = 0
                    com.stepos.ailauncher.chat.view.C2765a9.c(r4, r5, r6, r7, r8, r9)
                L62:
                    android.view.View r1 = r10.itemView
                    boolean r2 = r11.getIsUninstalling()
                    if (r2 == 0) goto L6e
                    r2 = 1053609165(0x3ecccccd, float:0.4)
                    goto L70
                L6e:
                    r2 = 1065353216(0x3f800000, float:1.0)
                L70:
                    r1.setAlpha(r2)
                    android.view.View r1 = r10.itemView
                    com.stepos.ailauncher.agent.skill.installed.InstalledSkillFragment$b r2 = r10.this$0
                    com.stepos.ailauncher.agent.skill.installed.H r4 = new com.stepos.ailauncher.agent.skill.installed.H
                    r4.<init>()
                    r1.setOnClickListener(r4)
                    android.view.View r1 = r10.more
                    boolean r2 = r11.getIsUninstalling()
                    r2 = r2 ^ 1
                    r1.setEnabled(r2)
                    android.view.View r1 = r10.more
                    boolean r2 = r1 instanceof android.widget.ImageView
                    if (r2 == 0) goto L93
                    r3 = r1
                    android.widget.ImageView r3 = (android.widget.ImageView) r3
                L93:
                    if (r3 == 0) goto L9d
                    r1 = -2130706433(0xffffffff80ffffff, float:-2.3509886E-38)
                    android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
                    r3.setColorFilter(r1, r2)
                L9d:
                    android.view.View r1 = r10.more
                    com.stepos.ailauncher.agent.skill.installed.InstalledSkillFragment$b r2 = r10.this$0
                    com.stepos.ailauncher.agent.skill.installed.I r3 = new com.stepos.ailauncher.agent.skill.installed.I
                    r3.<init>()
                    r1.setOnClickListener(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installed.InstalledSkillFragment.b.c.c(com.stepos.ailauncher.agent.skill.installed.adapter.a):void");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(p9.p<? super SkillItem, ? super View, Y8.t> onUninstallClick, InterfaceC5074l<? super SkillItem, Y8.t> onCardClick) {
            super(DIFF);
            kotlin.jvm.internal.p.i(onUninstallClick, "onUninstallClick");
            kotlin.jvm.internal.p.i(onCardClick, "onCardClick");
            this.onUninstallClick = onUninstallClick;
            this.onCardClick = onCardClick;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(c holder, int position) {
            kotlin.jvm.internal.p.i(holder, "holder");
            InstalledRow item = getItem(position);
            kotlin.jvm.internal.p.h(item, "getItem(...)");
            holder.c(item);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public c onCreateViewHolder(ViewGroup parent, int viewType) {
            kotlin.jvm.internal.p.i(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_installed_skill_lite, parent, false);
            kotlin.jvm.internal.p.f(viewInflate);
            return new c(this, viewInflate);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/ailauncher/agent/skill/installed/InstalledSkillFragment$c", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "LY8/t;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
            InstalledSkillFragment.this.lastKeystrokeTsMs = System.currentTimeMillis();
            InstalledSkillViewModel installedSkillViewModel = InstalledSkillFragment.this.viewModel;
            Y4.t tVar = null;
            if (installedSkillViewModel == null) {
                kotlin.jvm.internal.p.A("viewModel");
                installedSkillViewModel = null;
            }
            String string = s10 != null ? s10.toString() : null;
            if (string == null) {
                string = "";
            }
            installedSkillViewModel.R(string);
            boolean z10 = s10 != null && s10.length() > 0;
            Y4.t tVar2 = InstalledSkillFragment.this.binding;
            if (tVar2 == null) {
                kotlin.jvm.internal.p.A("binding");
                tVar2 = null;
            }
            ImageView ivClear = tVar2.ivClear;
            kotlin.jvm.internal.p.h(ivClear, "ivClear");
            ivClear.setVisibility(z10 ? 0 : 8);
            Y4.t tVar3 = InstalledSkillFragment.this.binding;
            if (tVar3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                tVar = tVar3;
            }
            ImageView ivSearchClearInline = tVar.ivSearchClearInline;
            kotlin.jvm.internal.p.h(ivSearchClearInline, "ivSearchClearInline");
            ivSearchClearInline.setVisibility(z10 ? 0 : 8);
            if (z10) {
                InstalledSkillFragment.this.b0();
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.installed.InstalledSkillFragment$onViewCreated$15", f = "InstalledSkillFragment.kt", l = {146}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.skill.installed.InstalledSkillFragment$onViewCreated$15, reason: invalid class name */
    public static final class AnonymousClass15 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.installed.InstalledSkillFragment$onViewCreated$15$1", f = "InstalledSkillFragment.kt", l = {147}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.agent.skill.installed.InstalledSkillFragment$onViewCreated$15$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
            int label;
            final /* synthetic */ InstalledSkillFragment this$0;

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.agent.skill.installed.InstalledSkillFragment$onViewCreated$15$1$a */
            public static final class a<T> implements Xa.c {
                final /* synthetic */ InstalledSkillFragment this$0;

                public a(InstalledSkillFragment installedSkillFragment) {
                    this.this$0 = installedSkillFragment;
                }

                @Override // Xa.c
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object emit(InstalledSkillViewModel.InstalledSkillUiState installedSkillUiState, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    this.this$0.w0(installedSkillUiState);
                    return Y8.t.f7040a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(InstalledSkillFragment installedSkillFragment, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = installedSkillFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new AnonymousClass1(this.this$0, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    InstalledSkillViewModel installedSkillViewModel = this.this$0.viewModel;
                    if (installedSkillViewModel == null) {
                        kotlin.jvm.internal.p.A("viewModel");
                        installedSkillViewModel = null;
                    }
                    Xa.t<InstalledSkillViewModel.InstalledSkillUiState> tVarI = installedSkillViewModel.I();
                    a aVar = new a(this.this$0);
                    this.label = 1;
                    if (tVarI.collect(aVar, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        public AnonymousClass15(InterfaceC4014c<? super AnonymousClass15> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return InstalledSkillFragment.this.new AnonymousClass15(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass15) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                InstalledSkillFragment installedSkillFragment = InstalledSkillFragment.this;
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(installedSkillFragment, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.b(installedSkillFragment, state, anonymousClass1, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.installed.InstalledSkillFragment$onViewCreated$16", f = "InstalledSkillFragment.kt", l = {151}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.skill.installed.InstalledSkillFragment$onViewCreated$16, reason: invalid class name */
    public static final class AnonymousClass16 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.installed.InstalledSkillFragment$onViewCreated$16$1", f = "InstalledSkillFragment.kt", l = {152}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.agent.skill.installed.InstalledSkillFragment$onViewCreated$16$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
            int label;
            final /* synthetic */ InstalledSkillFragment this$0;

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.agent.skill.installed.InstalledSkillFragment$onViewCreated$16$1$a */
            public static final class a<T> implements Xa.c {
                final /* synthetic */ InstalledSkillFragment this$0;

                public a(InstalledSkillFragment installedSkillFragment) {
                    this.this$0 = installedSkillFragment;
                }

                @Override // Xa.c
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object emit(String str, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    Toast.makeText(this.this$0.requireContext(), str, 0).show();
                    return Y8.t.f7040a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(InstalledSkillFragment installedSkillFragment, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = installedSkillFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new AnonymousClass1(this.this$0, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    InstalledSkillViewModel installedSkillViewModel = this.this$0.viewModel;
                    if (installedSkillViewModel == null) {
                        kotlin.jvm.internal.p.A("viewModel");
                        installedSkillViewModel = null;
                    }
                    Xa.o<String> oVarG = installedSkillViewModel.G();
                    a aVar = new a(this.this$0);
                    this.label = 1;
                    if (oVarG.collect(aVar, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        public AnonymousClass16(InterfaceC4014c<? super AnonymousClass16> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return InstalledSkillFragment.this.new AnonymousClass16(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass16) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                InstalledSkillFragment installedSkillFragment = InstalledSkillFragment.this;
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(installedSkillFragment, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.b(installedSkillFragment, state, anonymousClass1, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    public InstalledSkillFragment() {
        super(R$layout.fragment_installed_skill);
        this.exposedKeys = new LinkedHashSet();
    }

    private final void Z() {
        if (this.backGlassHandle != null || isHidden()) {
            return;
        }
        Y4.t tVar = this.binding;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar = null;
        }
        ImageView ivBack = tVar.ivBack;
        kotlin.jvm.internal.p.h(ivBack, "ivBack");
        if (ivBack.isAttachedToWindow()) {
            com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
            y7.E eM = com.stepos.ailauncher.container.glass.h.m(hVar, ivBack, false, Float.valueOf(22.0f), null, false, 24, null);
            this.backGlassHandle = eM;
            hVar.G(ivBack, eM, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.installed.t
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return InstalledSkillFragment.a0(this.f24462a, (y7.E) obj);
                }
            });
        }
    }

    public static final Y8.t a0(InstalledSkillFragment installedSkillFragment, y7.E released) {
        kotlin.jvm.internal.p.i(released, "released");
        if (installedSkillFragment.backGlassHandle == released) {
            installedSkillFragment.backGlassHandle = null;
        }
        return Y8.t.f7040a;
    }

    public static final void c0(final InstalledSkillFragment installedSkillFragment, ImageView imageView) {
        if (installedSkillFragment.clearGlassHandle == null && !installedSkillFragment.isHidden() && imageView.isAttachedToWindow()) {
            com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
            y7.E eM = com.stepos.ailauncher.container.glass.h.m(hVar, imageView, false, Float.valueOf(20.0f), null, false, 24, null);
            installedSkillFragment.clearGlassHandle = eM;
            hVar.G(imageView, eM, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.installed.x
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return InstalledSkillFragment.d0(this.f24475a, (y7.E) obj);
                }
            });
        }
    }

    public static final Y8.t d0(InstalledSkillFragment installedSkillFragment, y7.E released) {
        kotlin.jvm.internal.p.i(released, "released");
        if (installedSkillFragment.clearGlassHandle == released) {
            installedSkillFragment.clearGlassHandle = null;
        }
        return Y8.t.f7040a;
    }

    private final void e0() {
        Object systemService = requireContext().getSystemService("input_method");
        Y4.t tVar = null;
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            Y4.t tVar2 = this.binding;
            if (tVar2 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                tVar = tVar2;
            }
            inputMethodManager.hideSoftInputFromWindow(tVar.etSearch.getWindowToken(), 0);
        }
    }

    public static final void g0(InstalledSkillFragment installedSkillFragment) {
        installedSkillFragment.Z();
    }

    public static final void h0(InstalledSkillFragment installedSkillFragment) {
        installedSkillFragment.Z();
    }

    public static final void i0(InstalledSkillFragment installedSkillFragment, View view) {
        if (installedSkillFragment.x()) {
            return;
        }
        installedSkillFragment.o();
    }

    public static final void j0(InstalledSkillFragment installedSkillFragment) {
        installedSkillFragment.Z();
    }

    public static final boolean k0(InstalledSkillFragment installedSkillFragment, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        Y4.t tVar = installedSkillFragment.binding;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar = null;
        }
        if (!tVar.etSearch.hasFocus()) {
            return false;
        }
        kotlin.jvm.internal.p.f(motionEvent);
        installedSkillFragment.f0(motionEvent);
        return false;
    }

    public static final void l0(InstalledSkillFragment installedSkillFragment, View view) {
        InstalledSkillViewModel installedSkillViewModel = installedSkillFragment.viewModel;
        if (installedSkillViewModel == null) {
            kotlin.jvm.internal.p.A("viewModel");
            installedSkillViewModel = null;
        }
        installedSkillViewModel.P(InstallKind.SKILL);
    }

    public static final void m0(InstalledSkillFragment installedSkillFragment, View view) {
        InstalledSkillViewModel installedSkillViewModel = installedSkillFragment.viewModel;
        if (installedSkillViewModel == null) {
            kotlin.jvm.internal.p.A("viewModel");
            installedSkillViewModel = null;
        }
        installedSkillViewModel.P(InstallKind.CLI);
    }

    public static final Y8.t n0(final InstalledSkillFragment installedSkillFragment, final SkillItem item, View anchor) {
        kotlin.jvm.internal.p.i(item, "item");
        kotlin.jvm.internal.p.i(anchor, "anchor");
        installedSkillFragment.B0(anchor, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.installed.w
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return InstalledSkillFragment.o0(this.f24473a, item);
            }
        });
        return Y8.t.f7040a;
    }

    public static final Y8.t o0(InstalledSkillFragment installedSkillFragment, SkillItem skillItem) {
        InstalledSkillViewModel installedSkillViewModel = installedSkillFragment.viewModel;
        if (installedSkillViewModel == null) {
            kotlin.jvm.internal.p.A("viewModel");
            installedSkillViewModel = null;
        }
        installedSkillViewModel.a0(skillItem);
        return Y8.t.f7040a;
    }

    public static final Y8.t p0(InstalledSkillFragment installedSkillFragment, SkillItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        installedSkillFragment.v0(item);
        return Y8.t.f7040a;
    }

    public static final void q0(InstalledSkillFragment installedSkillFragment, NestedScrollView v10, int i10, int i11, int i12, int i13) {
        kotlin.jvm.internal.p.i(v10, "v");
        View childAt = v10.getChildAt(0);
        if (childAt == null) {
            return;
        }
        if (i11 + v10.getHeight() >= childAt.getHeight() - (v10.getHeight() / 2) && installedSkillFragment.canLoadNextPage) {
            InstalledSkillViewModel installedSkillViewModel = installedSkillFragment.viewModel;
            if (installedSkillViewModel == null) {
                kotlin.jvm.internal.p.A("viewModel");
                installedSkillViewModel = null;
            }
            installedSkillViewModel.J();
        }
        installedSkillFragment.z0();
    }

    public static final void r0(InstalledSkillFragment installedSkillFragment, View view) {
        InstalledSkillViewModel installedSkillViewModel = installedSkillFragment.viewModel;
        if (installedSkillViewModel == null) {
            kotlin.jvm.internal.p.A("viewModel");
            installedSkillViewModel = null;
        }
        installedSkillViewModel.J();
    }

    public static final boolean s0(InstalledSkillFragment installedSkillFragment, TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 != 3) {
            return false;
        }
        installedSkillFragment.e0();
        Y4.t tVar = installedSkillFragment.binding;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar = null;
        }
        tVar.etSearch.clearFocus();
        return true;
    }

    public static final void t0(InstalledSkillFragment installedSkillFragment, View view) {
        Y4.t tVar = installedSkillFragment.binding;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar = null;
        }
        tVar.etSearch.setText("");
    }

    public static final void u0(InstalledSkillFragment installedSkillFragment, View view) {
        Y4.t tVar = installedSkillFragment.binding;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar = null;
        }
        tVar.etSearch.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(final InstalledSkillViewModel.InstalledSkillUiState state) {
        if (!this.pageShowReported) {
            this.pageShowReported = true;
            SkillAnalytics.INSTANCE.f(state.getSelectedTab());
        }
        Y4.t tVar = this.binding;
        Y4.t tVar2 = null;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar = null;
        }
        tVar.tvTabSkills.setText(getString(R$string.installed_skill_tab_skill) + " " + state.h());
        Y4.t tVar3 = this.binding;
        if (tVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar3 = null;
        }
        tVar3.tvTabCli.setText(getString(R$string.installed_skill_tab_cli) + " " + state.c());
        InstallKind selectedTab = state.getSelectedTab();
        b5.m mVar = b5.m.INSTANCE;
        Y4.t tVar4 = this.binding;
        if (tVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar4 = null;
        }
        TextView tvTabSkills = tVar4.tvTabSkills;
        kotlin.jvm.internal.p.h(tvTabSkills, "tvTabSkills");
        int iN = mVar.n(tvTabSkills);
        Y4.t tVar5 = this.binding;
        if (tVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar5 = null;
        }
        TextView tvTabSkills2 = tVar5.tvTabSkills;
        kotlin.jvm.internal.p.h(tvTabSkills2, "tvTabSkills");
        int iP = mVar.p(tvTabSkills2);
        Y4.t tVar6 = this.binding;
        if (tVar6 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar6 = null;
        }
        View view = tVar6.indicatorSkills;
        InstallKind installKind = InstallKind.SKILL;
        view.setVisibility(selectedTab == installKind ? 0 : 4);
        Y4.t tVar7 = this.binding;
        if (tVar7 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar7 = null;
        }
        View view2 = tVar7.indicatorCli;
        InstallKind installKind2 = InstallKind.CLI;
        view2.setVisibility(selectedTab == installKind2 ? 0 : 4);
        Y4.t tVar8 = this.binding;
        if (tVar8 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar8 = null;
        }
        tVar8.tvTabSkills.setTextColor(selectedTab == installKind ? iN : iP);
        Y4.t tVar9 = this.binding;
        if (tVar9 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar9 = null;
        }
        TextView textView = tVar9.tvTabCli;
        if (selectedTab != installKind2) {
            iN = iP;
        }
        textView.setTextColor(iN);
        InstalledSkillViewModel.TabState skillTab = state.getSelectedTab() == installKind ? state.getSkillTab() : state.getCliTab();
        this.canLoadNextPage = (skillTab.getIsLoading() || skillTab.getIsLoadingMore() || !skillTab.getHasMore() || skillTab.getLoadError()) ? false : true;
        TextView textView2 = this.pagingFooter;
        if (textView2 != null) {
            textView2.setVisibility(skillTab.getLoadError() ? 0 : 8);
            textView2.setEnabled(skillTab.getLoadError() && !skillTab.getIsLoading() && !skillTab.getIsLoadingMore() && skillTab.getHasMore());
            if (skillTab.getLoadError()) {
                textView2.setText(com.stepos.ailauncher.chat.R$string.list_page_retry);
            }
        }
        if (!skillTab.getLoadError() && !skillTab.getIsLoading() && !skillTab.getIsLoadingMore() && skillTab.getHasMore()) {
            Y4.t tVar10 = this.binding;
            if (tVar10 == null) {
                kotlin.jvm.internal.p.A("binding");
                tVar10 = null;
            }
            tVar10.scrollInstalled.post(new Runnable() { // from class: com.stepos.ailauncher.agent.skill.installed.u
                @Override // java.lang.Runnable
                public final void run() {
                    InstalledSkillFragment.x0(this.f24463a);
                }
            });
        }
        b bVar = this.adapter;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("adapter");
            bVar = null;
        }
        bVar.submitList(state.i(), new Runnable() { // from class: com.stepos.ailauncher.agent.skill.installed.v
            @Override // java.lang.Runnable
            public final void run() {
                InstalledSkillFragment.y0(this.f24464a, state);
            }
        });
        if (skillTab.getIsLoading() || skillTab.getIsLoadingMore() || skillTab.getHasMore() || skillTab.getLoadError()) {
            Y4.t tVar11 = this.binding;
            if (tVar11 == null) {
                kotlin.jvm.internal.p.A("binding");
                tVar11 = null;
            }
            tVar11.emptyView.setVisibility(8);
            Y4.t tVar12 = this.binding;
            if (tVar12 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                tVar2 = tVar12;
            }
            tVar2.rvInstalled.setVisibility(state.i().isEmpty() ? 8 : 0);
            return;
        }
        if (state.getIsEmptyAll()) {
            A0(R$string.installed_skill_empty_main, R$string.installed_skill_empty_sub);
            return;
        }
        if (state.getIsEmptySearch()) {
            A0(R$string.installed_skill_no_result_main, R$string.installed_skill_no_result_sub);
            return;
        }
        if (state.getIsEmptyTab()) {
            A0(R$string.installed_skill_empty_main, R$string.installed_skill_empty_sub);
            return;
        }
        Y4.t tVar13 = this.binding;
        if (tVar13 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar13 = null;
        }
        tVar13.emptyView.setVisibility(8);
        Y4.t tVar14 = this.binding;
        if (tVar14 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            tVar2 = tVar14;
        }
        tVar2.rvInstalled.setVisibility(0);
    }

    public static final void x0(InstalledSkillFragment installedSkillFragment) {
        if (installedSkillFragment.getView() == null || !installedSkillFragment.canLoadNextPage) {
            return;
        }
        Y4.t tVar = installedSkillFragment.binding;
        InstalledSkillViewModel installedSkillViewModel = null;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar = null;
        }
        if (tVar.scrollInstalled.canScrollVertically(1)) {
            return;
        }
        InstalledSkillViewModel installedSkillViewModel2 = installedSkillFragment.viewModel;
        if (installedSkillViewModel2 == null) {
            kotlin.jvm.internal.p.A("viewModel");
        } else {
            installedSkillViewModel = installedSkillViewModel2;
        }
        installedSkillViewModel.J();
    }

    public static final void y0(InstalledSkillFragment installedSkillFragment, InstalledSkillViewModel.InstalledSkillUiState installedSkillUiState) {
        if (installedSkillFragment.lastKeystrokeTsMs > 0) {
            C4148a.u("installed_skill", "search: adapter committed total_since_keystroke=" + (System.currentTimeMillis() - installedSkillFragment.lastKeystrokeTsMs) + "ms size=" + installedSkillUiState.i().size(), false, 4, null);
        }
        installedSkillFragment.z0();
    }

    private final void z0() {
        Object objB;
        b bVar;
        LinearLayoutManager linearLayoutManager;
        try {
            Result.Companion companion = Result.INSTANCE;
            Y4.t tVar = this.binding;
            bVar = null;
            if (tVar == null) {
                kotlin.jvm.internal.p.A("binding");
                tVar = null;
            }
            RecyclerView.LayoutManager layoutManager = tVar.rvInstalled.getLayoutManager();
            linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (linearLayoutManager == null) {
            return;
        }
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (iFindFirstVisibleItemPosition >= 0 && iFindLastVisibleItemPosition >= 0) {
            b bVar2 = this.adapter;
            if (bVar2 == null) {
                kotlin.jvm.internal.p.A("adapter");
            } else {
                bVar = bVar2;
            }
            List<InstalledRow> currentList = bVar.getCurrentList();
            kotlin.jvm.internal.p.h(currentList, "getCurrentList(...)");
            if (iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition) {
                while (true) {
                    if (iFindFirstVisibleItemPosition >= 0 && iFindFirstVisibleItemPosition < currentList.size()) {
                        InstalledRow installedRow = currentList.get(iFindFirstVisibleItemPosition);
                        Set<Pair<String, DisplayScope>> set = this.exposedKeys;
                        String identifier = installedRow.getItem().getIdentifier();
                        DisplayScope displayScope = DisplayScope.INSTALLED;
                        if (set.add(Y8.j.a(identifier, displayScope))) {
                            SkillAnalytics.INSTANCE.d(installedRow.getItem(), displayScope);
                        }
                    }
                    if (iFindFirstVisibleItemPosition == iFindLastVisibleItemPosition) {
                        break;
                    } else {
                        iFindFirstVisibleItemPosition++;
                    }
                }
            }
            objB = Result.b(Y8.t.f7040a);
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t("installed_skill", "reportVisibleExposure failed", thE, false, 8, null);
            }
        }
    }

    public final void A0(int mainRes, int subRes) {
        Y4.t tVar = this.binding;
        Y4.t tVar2 = null;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar = null;
        }
        tVar.emptyView.setVisibility(0);
        Y4.t tVar3 = this.binding;
        if (tVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar3 = null;
        }
        tVar3.rvInstalled.setVisibility(8);
        Y4.t tVar4 = this.binding;
        if (tVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar4 = null;
        }
        tVar4.tvEmptyMain.setText(mainRes);
        Y4.t tVar5 = this.binding;
        if (tVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            tVar2 = tVar5;
        }
        tVar2.tvEmptySub.setText(subRes);
    }

    public final void B0(View anchor, InterfaceC5063a<Y8.t> onUninstall) {
        T9.d(anchor, 0.0f, onUninstall, 2, null);
    }

    public final void b0() {
        if (this.clearGlassHandle != null) {
            return;
        }
        Y4.t tVar = this.binding;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar = null;
        }
        final ImageView ivClear = tVar.ivClear;
        kotlin.jvm.internal.p.h(ivClear, "ivClear");
        ivClear.post(new Runnable() { // from class: com.stepos.ailauncher.agent.skill.installed.s
            @Override // java.lang.Runnable
            public final void run() {
                InstalledSkillFragment.c0(this.f24460a, ivClear);
            }
        });
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean e() {
        return true;
    }

    public final void f0(MotionEvent ev) {
        Rect rect = new Rect();
        Y4.t tVar = this.binding;
        Y4.t tVar2 = null;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar = null;
        }
        tVar.etSearch.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        Y4.t tVar3 = this.binding;
        if (tVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar3 = null;
        }
        tVar3.ivClear.getGlobalVisibleRect(rect2);
        int rawX = (int) ev.getRawX();
        int rawY = (int) ev.getRawY();
        if (rect.contains(rawX, rawY) || rect2.contains(rawX, rawY)) {
            return;
        }
        e0();
        Y4.t tVar4 = this.binding;
        if (tVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            tVar2 = tVar4;
        }
        tVar2.etSearch.clearFocus();
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.pagingFooter = null;
        this.canLoadNextPage = false;
        this.exposedKeys.clear();
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        hVar.F(this.backGlassHandle);
        this.backGlassHandle = null;
        hVar.F(this.clearGlassHandle);
        this.clearGlassHandle = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Y4.t tVar = null;
        if (hidden) {
            com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
            hVar.F(this.backGlassHandle);
            this.backGlassHandle = null;
            hVar.F(this.clearGlassHandle);
            this.clearGlassHandle = null;
            return;
        }
        Y4.t tVar2 = this.binding;
        if (tVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar2 = null;
        }
        tVar2.ivBack.post(new Runnable() { // from class: com.stepos.ailauncher.agent.skill.installed.n
            @Override // java.lang.Runnable
            public final void run() {
                InstalledSkillFragment.g0(this.f24455a);
            }
        });
        Y4.t tVar3 = this.binding;
        if (tVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            tVar = tVar3;
        }
        ImageView ivClear = tVar.ivClear;
        kotlin.jvm.internal.p.h(ivClear, "ivClear");
        if (ivClear.getVisibility() == 0) {
            b0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        hVar.F(this.backGlassHandle);
        this.backGlassHandle = null;
        hVar.F(this.clearGlassHandle);
        this.clearGlassHandle = null;
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Y4.t tVar = this.binding;
        Y4.t tVar2 = null;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar = null;
        }
        tVar.ivBack.post(new Runnable() { // from class: com.stepos.ailauncher.agent.skill.installed.y
            @Override // java.lang.Runnable
            public final void run() {
                InstalledSkillFragment.h0(this.f24476a);
            }
        });
        Y4.t tVar3 = this.binding;
        if (tVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            tVar2 = tVar3;
        }
        ImageView ivClear = tVar2.ivClear;
        kotlin.jvm.internal.p.h(ivClear, "ivClear");
        if (ivClear.getVisibility() == 0) {
            b0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Y4.t tVarA = Y4.t.a(view);
        kotlin.jvm.internal.p.h(tVarA, "bind(...)");
        this.binding = tVarA;
        if (tVarA == null) {
            kotlin.jvm.internal.p.A("binding");
            tVarA = null;
        }
        tVarA.root.setBackgroundColor(-15658735);
        Y4.t tVar = this.binding;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar = null;
        }
        tVar.root.setFitsSystemWindows(false);
        Y4.t tVar2 = this.binding;
        if (tVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar2 = null;
        }
        tVar2.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.installed.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InstalledSkillFragment.i0(this.f24477a, view2);
            }
        });
        Y4.t tVar3 = this.binding;
        if (tVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar3 = null;
        }
        tVar3.ivBack.post(new Runnable() { // from class: com.stepos.ailauncher.agent.skill.installed.C
            @Override // java.lang.Runnable
            public final void run() {
                InstalledSkillFragment.j0(this.f24424a);
            }
        });
        this.viewModel = (InstalledSkillViewModel) new U(this).a(InstalledSkillViewModel.class);
        this.adapter = new b(new p9.p() { // from class: com.stepos.ailauncher.agent.skill.installed.D
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return InstalledSkillFragment.n0(this.f24425a, (SkillItem) obj, (View) obj2);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.installed.E
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return InstalledSkillFragment.p0(this.f24426a, (SkillItem) obj);
            }
        });
        Y4.t tVar4 = this.binding;
        if (tVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar4 = null;
        }
        tVar4.rvInstalled.setLayoutManager(new LinearLayoutManager(requireContext()));
        Y4.t tVar5 = this.binding;
        if (tVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar5 = null;
        }
        RecyclerView recyclerView = tVar5.rvInstalled;
        b bVar = this.adapter;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("adapter");
            bVar = null;
        }
        recyclerView.setAdapter(bVar);
        Y4.t tVar6 = this.binding;
        if (tVar6 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar6 = null;
        }
        tVar6.rvInstalled.setItemAnimator(null);
        Y4.t tVar7 = this.binding;
        if (tVar7 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar7 = null;
        }
        RecyclerView recyclerView2 = tVar7.rvInstalled;
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        recyclerView2.addItemDecoration(new com.stepos.ailauncher.agent.aispace.E(contextRequireContext, null, 2, null));
        Y4.t tVar8 = this.binding;
        if (tVar8 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar8 = null;
        }
        tVar8.scrollInstalled.setOnScrollChangeListener(new NestedScrollView.e() { // from class: com.stepos.ailauncher.agent.skill.installed.F
            @Override // androidx.core.widget.NestedScrollView.e
            public final void a(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
                InstalledSkillFragment.q0(this.f24427a, nestedScrollView, i10, i11, i12, i13);
            }
        });
        TextView textView = new TextView(requireContext());
        textView.setGravity(17);
        textView.setTextSize(13.0f);
        textView.setTextColor(-1711276033);
        int i10 = (int) (16 * textView.getResources().getDisplayMetrics().density);
        textView.setPadding(0, i10, 0, i10);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.installed.G
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InstalledSkillFragment.r0(this.f24428a, view2);
            }
        });
        Y4.t tVar9 = this.binding;
        if (tVar9 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar9 = null;
        }
        NestedScrollView scrollInstalled = tVar9.scrollInstalled;
        kotlin.jvm.internal.p.h(scrollInstalled, "scrollInstalled");
        Y4.t tVar10 = this.binding;
        if (tVar10 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar10 = null;
        }
        RecyclerView rvInstalled = tVar10.rvInstalled;
        kotlin.jvm.internal.p.h(rvInstalled, "rvInstalled");
        scrollInstalled.removeView(rvInstalled);
        LinearLayout linearLayout = new LinearLayout(requireContext());
        linearLayout.setOrientation(1);
        scrollInstalled.addView(linearLayout);
        linearLayout.addView(rvInstalled, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        this.pagingFooter = textView;
        Y4.t tVar11 = this.binding;
        if (tVar11 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar11 = null;
        }
        EditText etSearch = tVar11.etSearch;
        kotlin.jvm.internal.p.h(etSearch, "etSearch");
        b5.g.b(etSearch);
        Y4.t tVar12 = this.binding;
        if (tVar12 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar12 = null;
        }
        tVar12.etSearch.addTextChangedListener(new c());
        Y4.t tVar13 = this.binding;
        if (tVar13 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar13 = null;
        }
        tVar13.etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.stepos.ailauncher.agent.skill.installed.o
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i11, KeyEvent keyEvent) {
                return InstalledSkillFragment.s0(this.f24456a, textView2, i11, keyEvent);
            }
        });
        Y4.t tVar14 = this.binding;
        if (tVar14 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar14 = null;
        }
        tVar14.ivClear.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.installed.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InstalledSkillFragment.t0(this.f24457a, view2);
            }
        });
        Y4.t tVar15 = this.binding;
        if (tVar15 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar15 = null;
        }
        tVar15.ivSearchClearInline.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.installed.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InstalledSkillFragment.u0(this.f24458a, view2);
            }
        });
        Y4.t tVar16 = this.binding;
        if (tVar16 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar16 = null;
        }
        tVar16.root.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.ailauncher.agent.skill.installed.r
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return InstalledSkillFragment.k0(this.f24459a, view2, motionEvent);
            }
        });
        Y4.t tVar17 = this.binding;
        if (tVar17 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar17 = null;
        }
        tVar17.tabSkill.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.installed.A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InstalledSkillFragment.l0(this.f24422a, view2);
            }
        });
        Y4.t tVar18 = this.binding;
        if (tVar18 == null) {
            kotlin.jvm.internal.p.A("binding");
            tVar18 = null;
        }
        tVar18.tabCli.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.installed.B
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InstalledSkillFragment.m0(this.f24423a, view2);
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AnonymousClass15(null), 3, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner2), null, null, new AnonymousClass16(null), 3, null);
    }

    public final void v0(SkillItem item) {
        Fragment fragmentCreateConfigFragment$default;
        Fragment fragmentCreateConfigFragment$default2;
        SkillAnalytics.INSTANCE.c(item, DisplayScope.INSTALLED, SkillAnalytics.ClickTarget.CARD);
        String identifier = item.getIdentifier();
        if (kotlin.jvm.internal.p.d(identifier, "lark-cli")) {
            IFeishuConnectService iFeishuConnectService = (IFeishuConnectService) D5.a.INSTANCE.a(IFeishuConnectService.class);
            if (iFeishuConnectService == null || (fragmentCreateConfigFragment$default2 = IFeishuConnectService.createConfigFragment$default(iFeishuConnectService, item.getIdentifier(), false, requireContext(), 2, null)) == null) {
                return;
            }
            com.stepos.ailauncher.sheet.nav.a.z(this, fragmentCreateConfigFragment$default2, "feishu_connect", null, null, null, 28, null);
            return;
        }
        if (kotlin.jvm.internal.p.d(identifier, "wecom-cli")) {
            IWecomConnectService iWecomConnectService = (IWecomConnectService) D5.a.INSTANCE.a(IWecomConnectService.class);
            if (iWecomConnectService == null || (fragmentCreateConfigFragment$default = IWecomConnectService.createConfigFragment$default(iWecomConnectService, item.getIdentifier(), false, requireContext(), 2, null)) == null) {
                return;
            }
            com.stepos.ailauncher.sheet.nav.a.z(this, fragmentCreateConfigFragment$default, "wecom_connect", null, null, null, 28, null);
            return;
        }
        com.stepos.ailauncher.sheet.nav.a.z(this, SkillDetailFragment.Companion.b(SkillDetailFragment.INSTANCE, item.getIdentifier(), item.getDisplayName(), item.getSummary(), item, false, null, 48, null), "skill_detail_" + item.getIdentifier(), null, null, null, 28, null);
    }
}
