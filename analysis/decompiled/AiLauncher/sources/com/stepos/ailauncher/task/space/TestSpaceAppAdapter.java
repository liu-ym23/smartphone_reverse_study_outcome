package com.stepos.ailauncher.task.space;

import Z8.C1173v;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.view.C2765a9;
import com.stepos.ailauncher.chat.view.C2787c9;
import com.stepos.ailauncher.chat.view.T9;
import com.stepos.ailauncher.contract.model.MarketAppBrief;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.task.R$string;
import com.stepos.ailauncher.task.space.TestSpaceAppAdapter;
import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\b\u0018\u0000 12\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003234B/\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00052\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0012\u0010\u0013J5\u0010\u0016\u001a\u00020\u00052\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140\u000e¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010!\u001a\u00020\u00052\n\u0010\u001f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020\u0014H\u0016¢\u0006\u0004\b!\u0010\"J1\u0010&\u001a\u00020\u00052\n\u0010\u001f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020\u00142\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016¢\u0006\u0004\b&\u0010'R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010(R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010(R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00040)j\b\u0012\u0004\u0012\u00020\u0004`*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R \u00100\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010/¨\u00065"}, d2 = {"Lcom/stepos/ailauncher/task/space/TestSpaceAppAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/task/space/TestSpaceAppAdapter$a;", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/contract/model/MarketAppBrief;", "LY8/t;", "onAction", "onUninstall", "<init>", "(Lp9/l;Lp9/l;)V", "", "list", "l", "(Ljava/util/List;)V", "", "", "Lcom/stepos/ailauncher/task/space/TestSpaceAppAdapter$ActionState;", "states", "k", "(Ljava/util/Map;)V", "", "progress", "m", "(Ljava/util/Map;Ljava/util/Map;)V", "Landroid/view/ViewGroup;", "parent", "viewType", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/task/space/TestSpaceAppAdapter$a;", "getItemCount", "()I", "holder", "position", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/task/space/TestSpaceAppAdapter$a;I)V", "", "", "payloads", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/task/space/TestSpaceAppAdapter$a;ILjava/util/List;)V", "Lp9/l;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", DidiCardProvider.KEY_ITEMS, "Ljava/util/ArrayList;", "", "stateMap", "Ljava/util/Map;", "progressMap", "Companion", "ActionState", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TestSpaceAppAdapter extends RecyclerView.Adapter<a> {
    private static final String PAYLOAD_ACTION = "action_state";
    private final ArrayList<MarketAppBrief> items;
    private final InterfaceC5074l<MarketAppBrief, Y8.t> onAction;
    private final InterfaceC5074l<MarketAppBrief, Y8.t> onUninstall;
    private final Map<String, Integer> progressMap;
    private final Map<String, ActionState> stateMap;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/task/space/TestSpaceAppAdapter$ActionState;", "", "<init>", "(Ljava/lang/String;I)V", "DOWNLOAD", "DOWNLOAD_UNAVAILABLE", "DOWNLOADING", "UPDATE", "UPDATE_UNAVAILABLE", "OPEN", ModelFlowMeta.PLAN_NONE, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ActionState {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ ActionState[] $VALUES;
        public static final ActionState DOWNLOAD = new ActionState("DOWNLOAD", 0);
        public static final ActionState DOWNLOAD_UNAVAILABLE = new ActionState("DOWNLOAD_UNAVAILABLE", 1);
        public static final ActionState DOWNLOADING = new ActionState("DOWNLOADING", 2);
        public static final ActionState UPDATE = new ActionState("UPDATE", 3);
        public static final ActionState UPDATE_UNAVAILABLE = new ActionState("UPDATE_UNAVAILABLE", 4);
        public static final ActionState OPEN = new ActionState("OPEN", 5);
        public static final ActionState NONE = new ActionState(ModelFlowMeta.PLAN_NONE, 6);

        private static final /* synthetic */ ActionState[] $values() {
            return new ActionState[]{DOWNLOAD, DOWNLOAD_UNAVAILABLE, DOWNLOADING, UPDATE, UPDATE_UNAVAILABLE, OPEN, NONE};
        }

        static {
            ActionState[] actionStateArr$values = $values();
            $VALUES = actionStateArr$values;
            $ENTRIES = kotlin.enums.a.a(actionStateArr$values);
        }

        private ActionState(String str, int i10) {
        }

        public static InterfaceC4149a<ActionState> getEntries() {
            return $ENTRIES;
        }

        public static ActionState valueOf(String str) {
            return (ActionState) Enum.valueOf(ActionState.class, str);
        }

        public static ActionState[] values() {
            return (ActionState[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/task/space/TestSpaceAppAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lr6/p;", "binding", "<init>", "(Lcom/stepos/ailauncher/task/space/TestSpaceAppAdapter;Lr6/p;)V", "", "v", "l", "(I)I", "", AMapLocationStaticsEntity.FIRST_LOCATE, "last", "LY8/t;", "e", "(ZZ)V", "Lcom/stepos/ailauncher/contract/model/MarketAppBrief;", "item", "f", "(Lcom/stepos/ailauncher/contract/model/MarketAppBrief;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Landroid/widget/ImageView;", "icon", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "subtitle", "updateHint", "action", "envTag", "", "lastTouch", "[F", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class a extends RecyclerView.ViewHolder {
        private final TextView action;
        private final TextView envTag;
        private final ImageView icon;
        private final float[] lastTouch;
        private final TextView subtitle;
        final /* synthetic */ TestSpaceAppAdapter this$0;
        private final TextView title;
        private final TextView updateHint;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.task.space.TestSpaceAppAdapter$a$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0335a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ActionState.values().length];
                try {
                    iArr[ActionState.DOWNLOAD.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ActionState.DOWNLOAD_UNAVAILABLE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ActionState.DOWNLOADING.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ActionState.UPDATE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ActionState.UPDATE_UNAVAILABLE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ActionState.OPEN.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[ActionState.NONE.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TestSpaceAppAdapter testSpaceAppAdapter, r6.p binding) {
            super(binding.b());
            kotlin.jvm.internal.p.i(binding, "binding");
            this.this$0 = testSpaceAppAdapter;
            ImageView ivAppIcon = binding.ivAppIcon;
            kotlin.jvm.internal.p.h(ivAppIcon, "ivAppIcon");
            this.icon = ivAppIcon;
            TextView tvAppTitle = binding.tvAppTitle;
            kotlin.jvm.internal.p.h(tvAppTitle, "tvAppTitle");
            this.title = tvAppTitle;
            TextView tvAppSubtitle = binding.tvAppSubtitle;
            kotlin.jvm.internal.p.h(tvAppSubtitle, "tvAppSubtitle");
            this.subtitle = tvAppSubtitle;
            TextView tvAppUpdateHint = binding.tvAppUpdateHint;
            kotlin.jvm.internal.p.h(tvAppUpdateHint, "tvAppUpdateHint");
            this.updateHint = tvAppUpdateHint;
            TextView btnAppAction = binding.btnAppAction;
            kotlin.jvm.internal.p.h(btnAppAction, "btnAppAction");
            this.action = btnAppAction;
            TextView tvAppTag = binding.tvAppTag;
            kotlin.jvm.internal.p.h(tvAppTag, "tvAppTag");
            this.envTag = tvAppTag;
            this.lastTouch = new float[]{0.0f, 0.0f};
        }

        public static final boolean g(a aVar, View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 0) {
                aVar.lastTouch[0] = motionEvent.getRawX();
                aVar.lastTouch[1] = motionEvent.getRawY();
            }
            return false;
        }

        public static final boolean h(final TestSpaceAppAdapter testSpaceAppAdapter, final MarketAppBrief marketAppBrief, a aVar, View view) {
            ActionState actionState = (ActionState) testSpaceAppAdapter.stateMap.get(marketAppBrief.getAppId());
            boolean z10 = (TestSpaceAppLinkPolicy.INSTANCE.b(marketAppBrief.getAppType()) || La.H.x0(marketAppBrief.getPackageName()) || (actionState != ActionState.OPEN && actionState != ActionState.UPDATE && actionState != ActionState.UPDATE_UNAVAILABLE)) ? false : true;
            if (z10) {
                View itemView = aVar.itemView;
                kotlin.jvm.internal.p.h(itemView, "itemView");
                float[] fArr = aVar.lastTouch;
                T9.f(itemView, fArr[0], fArr[1], new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.w1
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return TestSpaceAppAdapter.a.i(testSpaceAppAdapter, marketAppBrief);
                    }
                });
            }
            return z10;
        }

        public static final Y8.t i(TestSpaceAppAdapter testSpaceAppAdapter, MarketAppBrief marketAppBrief) {
            testSpaceAppAdapter.onUninstall.invoke(marketAppBrief);
            return Y8.t.f7040a;
        }

        public static final void k(TestSpaceAppAdapter testSpaceAppAdapter, MarketAppBrief marketAppBrief, View view) {
            testSpaceAppAdapter.onAction.invoke(marketAppBrief);
        }

        private final int l(int v10) {
            return (int) (v10 * this.itemView.getResources().getDisplayMetrics().density);
        }

        public final void e(boolean first, boolean last) {
            this.itemView.setPaddingRelative(l(16), first ? l(16) : l(12), l(16), last ? l(16) : l(12));
        }

        public final void f(final MarketAppBrief item) {
            kotlin.jvm.internal.p.i(item, "item");
            C2765a9.c(this.icon, item.getIconUrl(), R$drawable.ic_amoo_market_agent, false, 8, null);
            this.title.setText(item.getName());
            C2787c9.INSTANCE.a(this.envTag, item.getEnv());
            String lowerCase = item.getAppType().toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            String string = kotlin.jvm.internal.p.d(lowerCase, "app") ? this.itemView.getContext().getString(R$string.test_space_app_type_app) : kotlin.jvm.internal.p.d(lowerCase, "game") ? this.itemView.getContext().getString(R$string.test_space_app_type_game) : "";
            kotlin.jvm.internal.p.f(string);
            TextView textView = this.subtitle;
            List listP = C1173v.p(item.getVersion(), string);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listP) {
                if (!La.H.x0((String) obj)) {
                    arrayList.add(obj);
                }
            }
            textView.setText(Z8.F.A0(arrayList, " · ", null, null, 0, null, null, 62, null));
            j(item);
            this.itemView.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.ailauncher.task.space.u1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return TestSpaceAppAdapter.a.g(this.f29118a, view, motionEvent);
                }
            });
            View view = this.itemView;
            final TestSpaceAppAdapter testSpaceAppAdapter = this.this$0;
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.stepos.ailauncher.task.space.v1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    return TestSpaceAppAdapter.a.h(testSpaceAppAdapter, item, this, view2);
                }
            });
        }

        public final void j(final MarketAppBrief item) {
            kotlin.jvm.internal.p.i(item, "item");
            ActionState actionState = (ActionState) this.this$0.stateMap.get(item.getAppId());
            if (actionState == null) {
                actionState = ActionState.DOWNLOAD;
            }
            TextView textView = this.updateHint;
            ActionState actionState2 = ActionState.UPDATE;
            textView.setVisibility((actionState == actionState2 || actionState == ActionState.UPDATE_UNAVAILABLE) ? 0 : 8);
            switch (C0335a.$EnumSwitchMapping$0[actionState.ordinal()]) {
                case 1:
                    this.action.setVisibility(0);
                    this.action.setEnabled(true);
                    this.action.setText(R$string.test_space_app_download);
                    this.action.setBackgroundResource(com.stepos.ailauncher.task.R$drawable.bg_test_space_btn_download);
                    this.action.setTextColor(-16777216);
                    break;
                case 2:
                    this.action.setVisibility(0);
                    this.action.setEnabled(false);
                    this.action.setText(R$string.test_space_app_download);
                    this.action.setBackgroundResource(com.stepos.ailauncher.task.R$drawable.bg_test_space_btn_download);
                    this.action.setTextColor(Integer.MIN_VALUE);
                    break;
                case 3:
                    this.action.setVisibility(0);
                    this.action.setEnabled(false);
                    Integer num = (Integer) this.this$0.progressMap.get(item.getAppId());
                    int iIntValue = num != null ? num.intValue() : 0;
                    this.action.setText((1 > iIntValue || iIntValue >= 101) ? this.itemView.getContext().getString(R$string.test_space_app_installing) : this.itemView.getContext().getString(R$string.test_space_app_downloading, Integer.valueOf(iIntValue)));
                    this.action.setBackgroundResource(com.stepos.ailauncher.task.R$drawable.bg_test_space_btn_download);
                    this.action.setTextColor(Integer.MIN_VALUE);
                    break;
                case 4:
                case 5:
                    boolean z10 = actionState == actionState2;
                    this.action.setVisibility(0);
                    this.action.setEnabled(z10);
                    this.action.setText(R$string.test_space_app_update);
                    this.action.setBackgroundResource(com.stepos.ailauncher.task.R$drawable.bg_test_space_btn_download);
                    this.action.setTextColor(z10 ? -16777216 : Integer.MIN_VALUE);
                    break;
                case 6:
                    this.action.setVisibility(0);
                    this.action.setEnabled(true);
                    this.action.setText(R$string.test_space_app_open);
                    this.action.setBackgroundResource(com.stepos.ailauncher.task.R$drawable.bg_test_space_btn_open);
                    this.action.setTextColor(-1);
                    break;
                case 7:
                    this.action.setVisibility(8);
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            TextView textView2 = this.action;
            final TestSpaceAppAdapter testSpaceAppAdapter = this.this$0;
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.t1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TestSpaceAppAdapter.a.k(testSpaceAppAdapter, item, view);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"com/stepos/ailauncher/task/space/TestSpaceAppAdapter$c", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "()I", "getNewListSize", "oldPos", "newPos", "", "areItemsTheSame", "(II)Z", "areContentsTheSame", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends DiffUtil.Callback {
        final /* synthetic */ List<MarketAppBrief> $deduped;

        public c(List<MarketAppBrief> list) {
            this.$deduped = list;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldPos, int newPos) {
            Object obj = TestSpaceAppAdapter.this.items.get(oldPos);
            kotlin.jvm.internal.p.h(obj, "get(...)");
            MarketAppBrief marketAppBrief = (MarketAppBrief) obj;
            MarketAppBrief marketAppBrief2 = this.$deduped.get(newPos);
            return kotlin.jvm.internal.p.d(marketAppBrief.getName(), marketAppBrief2.getName()) && kotlin.jvm.internal.p.d(marketAppBrief.getVersion(), marketAppBrief2.getVersion()) && kotlin.jvm.internal.p.d(marketAppBrief.getAppType(), marketAppBrief2.getAppType()) && kotlin.jvm.internal.p.d(marketAppBrief.getIconUrl(), marketAppBrief2.getIconUrl()) && kotlin.jvm.internal.p.d(marketAppBrief.getH5Url(), marketAppBrief2.getH5Url()) && kotlin.jvm.internal.p.d(marketAppBrief.getPackageName(), marketAppBrief2.getPackageName()) && kotlin.jvm.internal.p.d(marketAppBrief.getEnv(), marketAppBrief2.getEnv());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldPos, int newPos) {
            return kotlin.jvm.internal.p.d(((MarketAppBrief) TestSpaceAppAdapter.this.items.get(oldPos)).getAppId(), this.$deduped.get(newPos).getAppId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.$deduped.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return TestSpaceAppAdapter.this.items.size();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TestSpaceAppAdapter(InterfaceC5074l<? super MarketAppBrief, Y8.t> onAction, InterfaceC5074l<? super MarketAppBrief, Y8.t> onUninstall) {
        kotlin.jvm.internal.p.i(onAction, "onAction");
        kotlin.jvm.internal.p.i(onUninstall, "onUninstall");
        this.onAction = onAction;
        this.onUninstall = onUninstall;
        this.items = new ArrayList<>();
        this.stateMap = new LinkedHashMap();
        this.progressMap = new LinkedHashMap();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        holder.e(position == 0, position == C1173v.o(this.items));
        MarketAppBrief marketAppBrief = this.items.get(position);
        kotlin.jvm.internal.p.h(marketAppBrief, "get(...)");
        holder.f(marketAppBrief);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position, List<Object> payloads) {
        kotlin.jvm.internal.p.i(holder, "holder");
        kotlin.jvm.internal.p.i(payloads, "payloads");
        if (!payloads.contains(PAYLOAD_ACTION)) {
            super.onBindViewHolder(holder, position, payloads);
            return;
        }
        MarketAppBrief marketAppBrief = this.items.get(position);
        kotlin.jvm.internal.p.h(marketAppBrief, "get(...)");
        holder.j(marketAppBrief);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        r6.p pVarC = r6.p.c(LayoutInflater.from(parent.getContext()), parent, false);
        kotlin.jvm.internal.p.h(pVarC, "inflate(...)");
        return new a(this, pVarC);
    }

    public final void k(Map<String, ? extends ActionState> states) {
        kotlin.jvm.internal.p.i(states, "states");
        if (this.stateMap.isEmpty()) {
            this.stateMap.putAll(states);
        }
    }

    public final void l(List<MarketAppBrief> list) {
        kotlin.jvm.internal.p.i(list, "list");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (hashSet.add(((MarketAppBrief) obj).getAppId())) {
                arrayList.add(obj);
            }
        }
        if (this.items.isEmpty() || arrayList.isEmpty()) {
            this.items.clear();
            this.items.addAll(arrayList);
            notifyDataSetChanged();
        } else {
            DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new c(arrayList));
            kotlin.jvm.internal.p.h(diffResultCalculateDiff, "calculateDiff(...)");
            this.items.clear();
            this.items.addAll(arrayList);
            diffResultCalculateDiff.dispatchUpdatesTo(this);
        }
    }

    public final void m(Map<String, ? extends ActionState> states, Map<String, Integer> progress) {
        kotlin.jvm.internal.p.i(states, "states");
        kotlin.jvm.internal.p.i(progress, "progress");
        ArrayList<MarketAppBrief> arrayList = this.items;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            String appId = ((MarketAppBrief) it.next()).getAppId();
            if (this.stateMap.get(appId) == states.get(appId) && kotlin.jvm.internal.p.d(this.progressMap.get(appId), progress.get(appId))) {
                appId = null;
            }
            if (appId != null) {
                arrayList2.add(appId);
            }
        }
        Set<String> setR1 = Z8.F.r1(arrayList2);
        this.stateMap.clear();
        this.stateMap.putAll(states);
        this.progressMap.clear();
        this.progressMap.putAll(progress);
        for (String str : setR1) {
            Iterator<MarketAppBrief> it2 = this.items.iterator();
            int i10 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i10 = -1;
                    break;
                } else if (kotlin.jvm.internal.p.d(it2.next().getAppId(), str)) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 >= 0) {
                notifyItemChanged(i10, PAYLOAD_ACTION);
            }
        }
    }
}
