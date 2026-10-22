package com.stepos.ailauncher.chat.adapter;

import Z8.C1173v;
import android.content.res.ColorStateList;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.adapter.h0;
import com.stepos.ailauncher.chat.fragment.CliKind;
import com.stepos.ailauncher.chat.fragment.Q1;
import com.stepos.ailauncher.chat.view.C2765a9;
import com.stepos.ailauncher.chat.view.C2787c9;
import com.stepos.ailauncher.chat.view.T9;
import com.stepos.ailauncher.contract.api.skill.ISkillUiService;
import com.stepos.ailauncher.contract.model.SkillItemBrief;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
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

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\f\u0018\u0000 =2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002>?BM\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0017\u001a\u00020\u00052\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u00020\u00052\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0004\b\u0019\u0010\u0018J#\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u001cH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u001cH\u0016¢\u0006\u0004\b$\u0010%J#\u0010'\u001a\u00020\u00052\n\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\"\u001a\u00020\u001cH\u0016¢\u0006\u0004\b'\u0010(J1\u0010,\u001a\u00020\u00052\n\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\"\u001a\u00020\u001c2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)H\u0016¢\u0006\u0004\b,\u0010-R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010.R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010.R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010.R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010/R$\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u000400j\b\u0012\u0004\u0012\u00020\u0004`18\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R \u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\"\u00107\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006@"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/h0;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/chat/adapter/h0$b;", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "LY8/t;", "onClick", "onInstall", "onUninstall", "", "testingMode", "<init>", "(Lp9/l;Lp9/l;Lp9/l;Z)V", "", "mList", "p", "(Ljava/util/List;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/util/List;", "", "", "Lcom/stepos/ailauncher/contract/api/skill/ISkillUiService$SkillUiStatus;", "status", "n", "(Ljava/util/Map;)V", "q", "Landroid/view/ViewGroup;", "parent", "", "viewType", "m", "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/chat/adapter/h0$b;", "getItemCount", "()I", "position", "", "getItemId", "(I)J", "holder", "k", "(Lcom/stepos/ailauncher/chat/adapter/h0$b;I)V", "", "", "payloads", "l", "(Lcom/stepos/ailauncher/chat/adapter/h0$b;ILjava/util/List;)V", "Lp9/l;", "Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", DidiCardProvider.KEY_ITEMS, "Ljava/util/ArrayList;", "", "statusMap", "Ljava/util/Map;", "highlightQuery", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/lang/String;", "o", "(Ljava/lang/String;)V", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h0 extends RecyclerView.Adapter<b> {
    private static final int HIGHLIGHT_COLOR = -14652161;
    private static final String PAYLOAD_ACTION_STATE = "action_state";
    private String highlightQuery;
    private final ArrayList<SkillItemBrief> items;
    private final InterfaceC5074l<SkillItemBrief, Y8.t> onClick;
    private final InterfaceC5074l<SkillItemBrief, Y8.t> onInstall;
    private final InterfaceC5074l<SkillItemBrief, Y8.t> onUninstall;
    private final Map<String, ISkillUiService.SkillUiStatus> statusMap;
    private final boolean testingMode;

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001c\u0010\u0016J\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b \u0010\u0016R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010&R\u0014\u0010(\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010)\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010&R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/h0$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/stepos/ailauncher/chat/adapter/h0;Landroid/view/View;)V", "", "resId", "l", "(I)Landroid/view/View;", "v", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(I)I", "", AMapLocationStaticsEntity.FIRST_LOCATE, "last", "LY8/t;", "e", "(ZZ)V", "Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "item", "f", "(Lcom/stepos/ailauncher/contract/model/SkillItemBrief;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "", "k", "(Lcom/stepos/ailauncher/contract/model/SkillItemBrief;)Ljava/lang/CharSequence;", "n", "Lcom/google/android/material/progressindicator/CircularProgressIndicator;", "m", "()Lcom/google/android/material/progressindicator/CircularProgressIndicator;", "q", "Landroid/widget/ImageView;", "icon", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "subtitle", "tagState", "tagUpdate", "Landroid/widget/FrameLayout;", "actionArea", "Landroid/widget/FrameLayout;", "", "renderedKey", "Ljava/lang/String;", "Lcom/stepos/ailauncher/contract/api/skill/ISkillUiService$SkillUiStatus;", "renderedStatus", "Lcom/stepos/ailauncher/contract/api/skill/ISkillUiService$SkillUiStatus;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class b extends RecyclerView.ViewHolder {
        private final FrameLayout actionArea;
        private final ImageView icon;
        private String renderedKey;
        private ISkillUiService.SkillUiStatus renderedStatus;
        private final TextView subtitle;
        private final TextView tagState;
        private final TextView tagUpdate;
        final /* synthetic */ h0 this$0;
        private final TextView title;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[CliKind.values().length];
                try {
                    iArr[CliKind.FEISHU.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CliKind.WECOM.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[ISkillUiService.SkillUiStatus.values().length];
                try {
                    iArr2[ISkillUiService.SkillUiStatus.NOT_INSTALLED.ordinal()] = 1;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr2[ISkillUiService.SkillUiStatus.INSTALL_FAILED.ordinal()] = 2;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr2[ISkillUiService.SkillUiStatus.INSTALLING.ordinal()] = 3;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr2[ISkillUiService.SkillUiStatus.QUEUED.ordinal()] = 4;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr2[ISkillUiService.SkillUiStatus.INSTALLED.ordinal()] = 5;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr2[ISkillUiService.SkillUiStatus.UNINSTALLING.ordinal()] = 6;
                } catch (NoSuchFieldError unused8) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h0 h0Var, View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
            this.this$0 = h0Var;
            View viewFindViewById = itemView.findViewById(R$id.ivSkillIcon);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.icon = (ImageView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R$id.tvSkillTitle);
            kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
            this.title = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R$id.tvSkillSubtitle);
            kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
            this.subtitle = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R$id.tvSkillTagState);
            kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
            this.tagState = (TextView) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(R$id.tvSkillTagUpdate);
            kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
            this.tagUpdate = (TextView) viewFindViewById5;
            View viewFindViewById6 = itemView.findViewById(R$id.actionArea);
            kotlin.jvm.internal.p.h(viewFindViewById6, "findViewById(...)");
            this.actionArea = (FrameLayout) viewFindViewById6;
        }

        public static final void g(h0 h0Var, SkillItemBrief skillItemBrief, View view) {
            h0Var.onClick.invoke(skillItemBrief);
        }

        private final int j(int v10) {
            return (int) (v10 * this.itemView.getResources().getDisplayMetrics().density);
        }

        private final View l(int resId) {
            ImageView imageView = new ImageView(this.actionArea.getContext());
            imageView.setImageResource(resId);
            imageView.setContentDescription(null);
            imageView.setImageTintList(ColorStateList.valueOf(-2130706433));
            imageView.setLayoutParams(new FrameLayout.LayoutParams(j(20), j(20), 17));
            return imageView;
        }

        public static final void o(h0 h0Var, SkillItemBrief skillItemBrief, View view) {
            h0Var.onInstall.invoke(skillItemBrief);
        }

        public static final void p(b bVar, SkillItemBrief skillItemBrief, View view) {
            bVar.q(skillItemBrief);
        }

        public static final Y8.t r(h0 h0Var, SkillItemBrief skillItemBrief) {
            h0Var.onUninstall.invoke(skillItemBrief);
            return Y8.t.f7040a;
        }

        public final void e(boolean first, boolean last) {
            this.itemView.setPaddingRelative(j(16), first ? j(16) : j(12), j(16), last ? j(16) : j(12));
        }

        public final void f(final SkillItemBrief item) {
            kotlin.jvm.internal.p.i(item, "item");
            CliKind cliKindA = Q1.a(item);
            int i10 = cliKindA == null ? -1 : a.$EnumSwitchMapping$0[cliKindA.ordinal()];
            if (i10 == -1) {
                C2765a9.c(this.icon, item.getIconUrl(), R$drawable.ic_amoo_market_agent, false, 8, null);
            } else if (i10 == 1) {
                this.icon.setImageResource(R$drawable.ic_cli_feishu);
            } else {
                if (i10 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                this.icon.setImageResource(R$drawable.ic_cli_wecom);
            }
            this.title.setText(k(item));
            if (this.this$0.testingMode) {
                i(item);
            } else {
                this.subtitle.setText(item.getDescription());
                this.tagState.setVisibility(8);
                this.tagUpdate.setVisibility(8);
                this.itemView.setAlpha(1.0f);
            }
            View view = this.itemView;
            final h0 h0Var = this.this$0;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.i0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    h0.b.g(h0Var, item, view2);
                }
            });
            n(item);
        }

        public final void h(SkillItemBrief item) {
            kotlin.jvm.internal.p.i(item, "item");
            n(item);
        }

        public final void i(SkillItemBrief item) {
            String versionName = item.getVersionName();
            if (La.H.x0(versionName)) {
                versionName = item.getVersion();
            }
            TextView textView = this.subtitle;
            if (La.H.x0(versionName) && (versionName = item.getDescription()) == null) {
                versionName = "";
            }
            textView.setText(versionName);
            C2787c9.INSTANCE.a(this.tagState, item.getEnv());
            if (item.getExpired()) {
                this.subtitle.setText(R$string.amoo_tag_expired);
                this.itemView.setAlpha(0.4f);
            } else {
                this.itemView.setAlpha(1.0f);
            }
            this.tagState.setVisibility(0);
        }

        public final CharSequence k(SkillItemBrief item) {
            String name = item.getName();
            if (name == null) {
                name = "";
            }
            String string = La.H.D1(this.this$0.getHighlightQuery()).toString();
            if (name.length() == 0 || string.length() == 0) {
                return name;
            }
            SpannableString spannableString = new SpannableString(name);
            Locale locale = Locale.ROOT;
            String lowerCase = name.toLowerCase(locale);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            String lowerCase2 = string.toLowerCase(locale);
            kotlin.jvm.internal.p.h(lowerCase2, "toLowerCase(...)");
            int iU0 = La.H.u0(lowerCase, lowerCase2, 0, false, 6, null);
            boolean z10 = false;
            while (iU0 >= 0) {
                spannableString.setSpan(new ForegroundColorSpan(h0.HIGHLIGHT_COLOR), iU0, string.length() + iU0, 33);
                Locale locale2 = Locale.ROOT;
                String lowerCase3 = name.toLowerCase(locale2);
                kotlin.jvm.internal.p.h(lowerCase3, "toLowerCase(...)");
                String lowerCase4 = string.toLowerCase(locale2);
                kotlin.jvm.internal.p.h(lowerCase4, "toLowerCase(...)");
                iU0 = La.H.u0(lowerCase3, lowerCase4, iU0 + string.length(), false, 4, null);
                z10 = true;
            }
            return z10 ? spannableString : name;
        }

        public final CircularProgressIndicator m() {
            CircularProgressIndicator circularProgressIndicator = new CircularProgressIndicator(this.actionArea.getContext());
            int iJ = j(20);
            circularProgressIndicator.setLayoutParams(new FrameLayout.LayoutParams(iJ, iJ, 17));
            circularProgressIndicator.setIndicatorSize(iJ);
            circularProgressIndicator.setTrackThickness(j(2));
            circularProgressIndicator.setIndicatorColor(-1);
            circularProgressIndicator.setTrackColor(872415231);
            circularProgressIndicator.setIndeterminate(true);
            return circularProgressIndicator;
        }

        public final void n(final SkillItemBrief item) {
            String strB = m0.b(item);
            ISkillUiService.SkillUiStatus skillUiStatus = (ISkillUiService.SkillUiStatus) this.this$0.statusMap.get(strB);
            if (skillUiStatus == null) {
                skillUiStatus = item.getInstalled() ? ISkillUiService.SkillUiStatus.INSTALLED : ISkillUiService.SkillUiStatus.NOT_INSTALLED;
            }
            if (this.this$0.testingMode) {
                this.tagUpdate.setVisibility((item.getNeedUpdate() && skillUiStatus == ISkillUiService.SkillUiStatus.INSTALLED && !item.getExpired()) ? 0 : 8);
            }
            if (kotlin.jvm.internal.p.d(this.renderedKey, strB) && this.renderedStatus == skillUiStatus) {
                return;
            }
            this.renderedKey = strB;
            this.renderedStatus = skillUiStatus;
            this.actionArea.removeAllViews();
            this.actionArea.setOnClickListener(null);
            switch (a.$EnumSwitchMapping$1[skillUiStatus.ordinal()]) {
                case 1:
                case 2:
                    this.actionArea.addView(l(R$drawable.ic_amoo_plus));
                    FrameLayout frameLayout = this.actionArea;
                    final h0 h0Var = this.this$0;
                    frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.j0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            h0.b.o(h0Var, item, view);
                        }
                    });
                    return;
                case 3:
                case 4:
                    this.actionArea.addView(m());
                    return;
                case 5:
                    this.actionArea.addView(l(R$drawable.ic_amoo_ellipsis));
                    this.actionArea.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.k0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            h0.b.p(this.f24952a, item, view);
                        }
                    });
                    return;
                case 6:
                    this.actionArea.addView(m());
                    return;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        public final void q(final SkillItemBrief item) {
            FrameLayout frameLayout = this.actionArea;
            final h0 h0Var = this.this$0;
            T9.d(frameLayout, 0.0f, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.adapter.l0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return h0.b.r(h0Var, item);
                }
            }, 2, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"com/stepos/ailauncher/chat/adapter/h0$c", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "()I", "getNewListSize", "oldPos", "newPos", "", "areItemsTheSame", "(II)Z", "areContentsTheSame", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends DiffUtil.Callback {
        final /* synthetic */ List<SkillItemBrief> $deduped;

        public c(List<SkillItemBrief> list) {
            this.$deduped = list;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldPos, int newPos) {
            Object obj = h0.this.items.get(oldPos);
            kotlin.jvm.internal.p.h(obj, "get(...)");
            SkillItemBrief skillItemBrief = (SkillItemBrief) obj;
            SkillItemBrief skillItemBrief2 = this.$deduped.get(newPos);
            if (!kotlin.jvm.internal.p.d(skillItemBrief.getName(), skillItemBrief2.getName()) || !kotlin.jvm.internal.p.d(skillItemBrief.getDescription(), skillItemBrief2.getDescription()) || !kotlin.jvm.internal.p.d(skillItemBrief.getIconUrl(), skillItemBrief2.getIconUrl()) || Q1.a(skillItemBrief) != Q1.a(skillItemBrief2)) {
                return false;
            }
            if (h0.this.testingMode) {
                return kotlin.jvm.internal.p.d(skillItemBrief.getEnv(), skillItemBrief2.getEnv()) && skillItemBrief.getExpired() == skillItemBrief2.getExpired() && kotlin.jvm.internal.p.d(skillItemBrief.getVersion(), skillItemBrief2.getVersion()) && kotlin.jvm.internal.p.d(skillItemBrief.getVersionName(), skillItemBrief2.getVersionName()) && skillItemBrief.getNeedUpdate() == skillItemBrief2.getNeedUpdate();
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldPos, int newPos) {
            Object obj = h0.this.items.get(oldPos);
            kotlin.jvm.internal.p.h(obj, "get(...)");
            return kotlin.jvm.internal.p.d(m0.b((SkillItemBrief) obj), m0.b(this.$deduped.get(newPos)));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.$deduped.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return h0.this.items.size();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h0(InterfaceC5074l<? super SkillItemBrief, Y8.t> onClick, InterfaceC5074l<? super SkillItemBrief, Y8.t> onInstall, InterfaceC5074l<? super SkillItemBrief, Y8.t> onUninstall, boolean z10) {
        kotlin.jvm.internal.p.i(onClick, "onClick");
        kotlin.jvm.internal.p.i(onInstall, "onInstall");
        kotlin.jvm.internal.p.i(onUninstall, "onUninstall");
        this.onClick = onClick;
        this.onInstall = onInstall;
        this.onUninstall = onUninstall;
        this.testingMode = z10;
        this.items = new ArrayList<>();
        this.statusMap = new LinkedHashMap();
        this.highlightQuery = "";
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        kotlin.jvm.internal.p.h(this.items.get(position), "get(...)");
        return m0.b(r0).hashCode();
    }

    public final List<SkillItemBrief> i() {
        return Z8.F.m1(this.items);
    }

    /* renamed from: j, reason: from getter */
    public final String getHighlightQuery() {
        return this.highlightQuery;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        holder.e(position == 0, position == C1173v.o(this.items));
        SkillItemBrief skillItemBrief = this.items.get(position);
        kotlin.jvm.internal.p.h(skillItemBrief, "get(...)");
        holder.f(skillItemBrief);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position, List<Object> payloads) {
        kotlin.jvm.internal.p.i(holder, "holder");
        kotlin.jvm.internal.p.i(payloads, "payloads");
        if (!payloads.contains(PAYLOAD_ACTION_STATE)) {
            super.onBindViewHolder(holder, position, payloads);
            return;
        }
        SkillItemBrief skillItemBrief = this.items.get(position);
        kotlin.jvm.internal.p.h(skillItemBrief, "get(...)");
        holder.h(skillItemBrief);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_web_search_skill, parent, false);
        kotlin.jvm.internal.p.f(viewInflate);
        return new b(this, viewInflate);
    }

    public final void n(Map<String, ? extends ISkillUiService.SkillUiStatus> status) {
        kotlin.jvm.internal.p.i(status, "status");
        if (this.statusMap.isEmpty()) {
            this.statusMap.putAll(status);
        }
    }

    public final void o(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.highlightQuery = str;
    }

    public final void p(List<SkillItemBrief> mList) {
        kotlin.jvm.internal.p.i(mList, "mList");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : mList) {
            if (hashSet.add(m0.b((SkillItemBrief) obj))) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() != mList.size()) {
            Log.w("SkillMarketAdapter", "submit: dropped " + (mList.size() - arrayList.size()) + " duplicate-key rows");
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

    public final void q(Map<String, ? extends ISkillUiService.SkillUiStatus> status) {
        kotlin.jvm.internal.p.i(status, "status");
        ArrayList<SkillItemBrief> arrayList = this.items;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            String strB = m0.b((SkillItemBrief) it.next());
            if (this.statusMap.get(strB) == status.get(strB)) {
                strB = null;
            }
            if (strB != null) {
                arrayList2.add(strB);
            }
        }
        Set<String> setR1 = Z8.F.r1(arrayList2);
        this.statusMap.clear();
        this.statusMap.putAll(status);
        for (String str : setR1) {
            Iterator<SkillItemBrief> it2 = this.items.iterator();
            int i10 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i10 = -1;
                    break;
                } else if (kotlin.jvm.internal.p.d(m0.b(it2.next()), str)) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 >= 0) {
                notifyItemChanged(i10, PAYLOAD_ACTION_STATE);
            }
        }
    }

    public /* synthetic */ h0(InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, InterfaceC5074l interfaceC5074l3, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this(interfaceC5074l, interfaceC5074l2, interfaceC5074l3, (i10 & 8) != 0 ? false : z10);
    }
}
