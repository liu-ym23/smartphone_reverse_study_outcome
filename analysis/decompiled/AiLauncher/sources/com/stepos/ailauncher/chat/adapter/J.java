package com.stepos.ailauncher.chat.adapter;

import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import android.content.Context;
import android.content.res.ColorStateList;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$color;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.adapter.J;
import com.stepos.ailauncher.contract.model.search.SearchTaskStatus;
import com.stepos.ailauncher.contract.model.search.SessionSearchHit;
import com.stepos.ailauncher.contract.model.search.TaskSearchHit;
import com.stepos.ailauncher.contract.model.search.UnifiedSearchResult;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5074l;
import v9.C5680i;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u000f()*B/\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001f\u0010 R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010!R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010!R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\"R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/J;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;", "LY8/t;", "onSessionClick", "Lcom/stepos/ailauncher/contract/model/search/TaskSearchHit;", "onTaskClick", "<init>", "(Lp9/l;Lp9/l;)V", "Lcom/stepos/ailauncher/contract/model/search/UnifiedSearchResult;", "result", "", "query", "c", "(Lcom/stepos/ailauncher/contract/model/search/UnifiedSearchResult;Ljava/lang/String;)V", "clear", "()V", "", "position", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "getItemCount", "()I", "Lp9/l;", "Ljava/lang/String;", "", "Lcom/stepos/ailauncher/chat/adapter/J$c;", DidiCardProvider.KEY_ITEMS, "Ljava/util/List;", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class J extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final a Companion = new a(null);
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_SESSION = 1;
    private static final int TYPE_TASK = 2;
    private List<? extends c> items;
    private final InterfaceC5074l<SessionSearchHit, Y8.t> onSessionClick;
    private final InterfaceC5074l<TaskSearchHit, Y8.t> onTaskClick;
    private String query;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/J$a;", "", "<init>", "()V", "", "TYPE_HEADER", "I", "TYPE_SESSION", "TYPE_TASK", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/J$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_APIKEY, "(I)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends RecyclerView.ViewHolder {
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R$id.tv_search_section_title);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.title = (TextView) viewFindViewById;
        }

        public final void a(int value) {
            this.title.setText(value);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/J$c;", "", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", "Lcom/stepos/ailauncher/chat/adapter/J$c$a;", "Lcom/stepos/ailauncher/chat/adapter/J$c$b;", "Lcom/stepos/ailauncher/chat/adapter/J$c$c;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface c {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/J$c$a;", "Lcom/stepos/ailauncher/chat/adapter/J$c;", "", "titleRes", "<init>", "(I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.adapter.J$c$a, reason: from toString */
        public static final /* data */ class Header implements c {
            private final int titleRes;

            public Header(int i10) {
                this.titleRes = i10;
            }

            /* renamed from: a, reason: from getter */
            public final int getTitleRes() {
                return this.titleRes;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Header) && this.titleRes == ((Header) other).titleRes;
            }

            public int hashCode() {
                return Integer.hashCode(this.titleRes);
            }

            public String toString() {
                return "Header(titleRes=" + this.titleRes + ")";
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/J$c$b;", "Lcom/stepos/ailauncher/chat/adapter/J$c;", "Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;", com.stepos.ailauncher.sla.G.JUDGE_HIT, "<init>", "(Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.adapter.J$c$b, reason: from toString */
        public static final /* data */ class Session implements c {
            private final SessionSearchHit hit;

            public Session(SessionSearchHit hit) {
                kotlin.jvm.internal.p.i(hit, "hit");
                this.hit = hit;
            }

            /* renamed from: a, reason: from getter */
            public final SessionSearchHit getHit() {
                return this.hit;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Session) && kotlin.jvm.internal.p.d(this.hit, ((Session) other).hit);
            }

            public int hashCode() {
                return this.hit.hashCode();
            }

            public String toString() {
                return "Session(hit=" + this.hit + ")";
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/J$c$c;", "Lcom/stepos/ailauncher/chat/adapter/J$c;", "Lcom/stepos/ailauncher/contract/model/search/TaskSearchHit;", com.stepos.ailauncher.sla.G.JUDGE_HIT, "<init>", "(Lcom/stepos/ailauncher/contract/model/search/TaskSearchHit;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/contract/model/search/TaskSearchHit;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/contract/model/search/TaskSearchHit;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.adapter.J$c$c, reason: collision with other inner class name and from toString */
        public static final /* data */ class Task implements c {
            private final TaskSearchHit hit;

            public Task(TaskSearchHit hit) {
                kotlin.jvm.internal.p.i(hit, "hit");
                this.hit = hit;
            }

            /* renamed from: a, reason: from getter */
            public final TaskSearchHit getHit() {
                return this.hit;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Task) && kotlin.jvm.internal.p.d(this.hit, ((Task) other).hit);
            }

            public int hashCode() {
                return this.hit.hashCode();
            }

            public String toString() {
                return "Task(hit=" + this.hit + ")";
            }
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0014\u001a\u00020\u000b*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0018\u001a\u00020\u0017*\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010#\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010!R\u0014\u0010$\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010!R\u0014\u0010'\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010!R\u0014\u0010(\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010!¨\u0006)"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/J$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;", com.stepos.ailauncher.sla.G.JUDGE_HIT, "", "query", "Lkotlin/Function1;", "LY8/t;", "onClick", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;Ljava/lang/String;Lp9/l;)V", "Lcom/stepos/ailauncher/contract/model/search/TaskSearchHit;", "f", "(Lcom/stepos/ailauncher/contract/model/search/TaskSearchHit;Ljava/lang/String;Lp9/l;)V", "Landroid/widget/TextView;", UxipConstants.f30680s, "c", "(Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/contract/model/search/SearchTaskStatus;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/contract/model/search/SearchTaskStatus;)I", "", "Lv9/i;", "ranges", "Landroid/text/SpannableString;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/util/List;)Landroid/text/SpannableString;", "title", "Landroid/widget/TextView;", "badge", "time", "secondary", "Landroid/view/View;", "status", "separator", "snippet", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends RecyclerView.ViewHolder {
        private final TextView badge;
        private final View secondary;
        private final TextView separator;
        private final TextView snippet;
        private final TextView status;
        private final TextView time;
        private final TextView title;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SearchTaskStatus.values().length];
                try {
                    iArr[SearchTaskStatus.WAITING_FOR_USER.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SearchTaskStatus.RUNNING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SearchTaskStatus.COMPLETED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[SearchTaskStatus.FAILED.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[SearchTaskStatus.CANCELLED.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[SearchTaskStatus.OTHER.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R$id.tv_search_result_title);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.title = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R$id.tv_search_result_badge);
            kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
            this.badge = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R$id.tv_search_result_time);
            kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
            this.time = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R$id.search_result_secondary);
            kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
            this.secondary = viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(R$id.tv_search_result_status);
            kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
            this.status = (TextView) viewFindViewById5;
            View viewFindViewById6 = itemView.findViewById(R$id.tv_search_result_separator);
            kotlin.jvm.internal.p.h(viewFindViewById6, "findViewById(...)");
            this.separator = (TextView) viewFindViewById6;
            View viewFindViewById7 = itemView.findViewById(R$id.tv_search_result_snippet);
            kotlin.jvm.internal.p.h(viewFindViewById7, "findViewById(...)");
            this.snippet = (TextView) viewFindViewById7;
        }

        public static final void e(InterfaceC5074l interfaceC5074l, SessionSearchHit sessionSearchHit, View view) {
            interfaceC5074l.invoke(sessionSearchHit);
        }

        public static final void g(InterfaceC5074l interfaceC5074l, TaskSearchHit taskSearchHit, View view) {
            interfaceC5074l.invoke(taskSearchHit);
        }

        public final void c(TextView textView, String str, String str2) {
            textView.setText(h(str, M.a(str, str2)));
            textView.setVisibility(La.H.x0(str) ? 8 : 0);
        }

        public final void d(final SessionSearchHit hit, String query, final InterfaceC5074l<? super SessionSearchHit, Y8.t> onClick) {
            kotlin.jvm.internal.p.i(hit, "hit");
            kotlin.jvm.internal.p.i(query, "query");
            kotlin.jvm.internal.p.i(onClick, "onClick");
            this.title.setText(hit.getTitle());
            c(this.snippet, hit.getSnippet(), query);
            this.secondary.setVisibility(La.H.x0(hit.getSnippet()) ? 8 : 0);
            this.status.setVisibility(8);
            this.separator.setVisibility(8);
            this.badge.setText(hit.getAgentLabel());
            this.badge.setVisibility(La.H.x0(hit.getAgentLabel()) ? 8 : 0);
            this.badge.setBackgroundTintList(ColorStateList.valueOf(androidx.core.content.a.c(this.itemView.getContext(), R$color.search_badge_neutral)));
            TextView textView = this.time;
            com.stepos.ailauncher.chat.util.s sVar = com.stepos.ailauncher.chat.util.s.INSTANCE;
            Context context = this.itemView.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            textView.setText(com.stepos.ailauncher.chat.util.s.c(sVar, context, hit.getUpdatedAt(), 0L, 4, null));
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.K
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    J.d.e(onClick, hit, view);
                }
            });
        }

        public final void f(final TaskSearchHit hit, String query, final InterfaceC5074l<? super TaskSearchHit, Y8.t> onClick) {
            kotlin.jvm.internal.p.i(hit, "hit");
            kotlin.jvm.internal.p.i(query, "query");
            kotlin.jvm.internal.p.i(onClick, "onClick");
            this.title.setText(hit.getTitle());
            c(this.snippet, hit.getSnippet(), query);
            this.badge.setVisibility(8);
            this.secondary.setVisibility(0);
            this.status.setText(hit.getStatusText());
            this.status.setVisibility(0);
            this.status.setTextColor(androidx.core.content.a.c(this.itemView.getContext(), i(hit.getStatus())));
            this.separator.setVisibility(La.H.x0(hit.getSnippet()) ? 8 : 0);
            TextView textView = this.time;
            com.stepos.ailauncher.chat.util.s sVar = com.stepos.ailauncher.chat.util.s.INSTANCE;
            Context context = this.itemView.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            textView.setText(com.stepos.ailauncher.chat.util.s.c(sVar, context, hit.getUpdatedAt(), 0L, 4, null));
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.L
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    J.d.g(onClick, hit, view);
                }
            });
        }

        public final SpannableString h(String value, List<C5680i> ranges) {
            SpannableString spannableString = new SpannableString(value);
            int iC = androidx.core.content.a.c(this.itemView.getContext(), R$color.search_match_highlight);
            for (C5680i c5680i : ranges) {
                spannableString.setSpan(new ForegroundColorSpan(iC), c5680i.getFirst(), c5680i.getLast() + 1, 33);
            }
            return spannableString;
        }

        public final int i(SearchTaskStatus searchTaskStatus) {
            switch (a.$EnumSwitchMapping$0[searchTaskStatus.ordinal()]) {
                case 1:
                    return R$color.search_status_waiting;
                case 2:
                    return R$color.search_status_running;
                case 3:
                    return R$color.search_status_completed;
                case 4:
                    return R$color.search_status_failed;
                case 5:
                case 6:
                    return R$color.search_badge_neutral;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public J(InterfaceC5074l<? super SessionSearchHit, Y8.t> onSessionClick, InterfaceC5074l<? super TaskSearchHit, Y8.t> onTaskClick) {
        kotlin.jvm.internal.p.i(onSessionClick, "onSessionClick");
        kotlin.jvm.internal.p.i(onTaskClick, "onTaskClick");
        this.onSessionClick = onSessionClick;
        this.onTaskClick = onTaskClick;
        this.query = "";
        this.items = C1173v.m();
    }

    public final void c(UnifiedSearchResult result, String query) {
        kotlin.jvm.internal.p.i(result, "result");
        kotlin.jvm.internal.p.i(query, "query");
        this.query = query;
        List listC = C1172u.c();
        if (!result.getSessions().isEmpty()) {
            listC.add(new c.Header(R$string.search_section_sessions));
            List<SessionSearchHit> sessions = result.getSessions();
            ArrayList arrayList = new ArrayList(C1174w.x(sessions, 10));
            Iterator<T> it = sessions.iterator();
            while (it.hasNext()) {
                arrayList.add(new c.Session((SessionSearchHit) it.next()));
            }
            listC.addAll(arrayList);
        }
        if (!result.getTasks().isEmpty()) {
            listC.add(new c.Header(R$string.search_section_related_tasks));
            List<TaskSearchHit> tasks = result.getTasks();
            ArrayList arrayList2 = new ArrayList(C1174w.x(tasks, 10));
            Iterator<T> it2 = tasks.iterator();
            while (it2.hasNext()) {
                arrayList2.add(new c.Task((TaskSearchHit) it2.next()));
            }
            listC.addAll(arrayList2);
        }
        this.items = C1172u.a(listC);
        notifyDataSetChanged();
    }

    public final void clear() {
        this.query = "";
        this.items = C1173v.m();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        c cVar = this.items.get(position);
        if (cVar instanceof c.Header) {
            return 0;
        }
        if (cVar instanceof c.Session) {
            return 1;
        }
        if (cVar instanceof c.Task) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        c cVar = this.items.get(position);
        if (cVar instanceof c.Header) {
            ((b) holder).a(((c.Header) cVar).getTitleRes());
        } else if (cVar instanceof c.Session) {
            ((d) holder).d(((c.Session) cVar).getHit(), this.query, this.onSessionClick);
        } else {
            if (!(cVar instanceof c.Task)) {
                throw new NoWhenBranchMatchedException();
            }
            ((d) holder).f(((c.Task) cVar).getHit(), this.query, this.onTaskClick);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            View viewInflate = layoutInflaterFrom.inflate(R$layout.item_search_section_header, parent, false);
            kotlin.jvm.internal.p.h(viewInflate, "inflate(...)");
            return new b(viewInflate);
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R$layout.item_search_result, parent, false);
        kotlin.jvm.internal.p.h(viewInflate2, "inflate(...)");
        return new d(viewInflate2);
    }
}
