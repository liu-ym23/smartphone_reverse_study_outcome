package com.bytedance.android.live.liveinteract.interactivesong.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.o;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVTab;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001cB'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004RA\u0010\u0013\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/panel/MvSelectTabView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "getTabViewSelectedTab", "", "Lcom/bytedance/android/livesdk/chatroom/model/interact/IMVTab;", "list", "", "setDataAndNotify", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "tab", "d", "Lkotlin/jvm/functions/Function1;", "getTabSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setTabSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "tabSelectedListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TabViewHolder", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MvSelectTabView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<IMVTab> f74121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f74122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MvSelectTabView$tabAdapter$1 f74123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super IMVTab, Unit> f74124d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/panel/MvSelectTabView$TabViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class TabViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public IMVTab f74125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f74126b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f74127c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ MvSelectTabView f74128d;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TabViewHolder f74129a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f74130b;

            public a(TabViewHolder r100, View r101) {
                this.f74129a = r100;
                this.f74130b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(this.f74130b.getWidth(), o.a(32.0f));     // Catch: Throwable -> L6
                r100.gravity = 17;     // Catch: Throwable -> L6
                View r101 = this.f74129a.f74127c;     // Catch: Throwable -> L6
                if (r101 == null) goto L9;
                r101.setLayoutParams(r100);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public static final class b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TabViewHolder f74131a;

            public b(TabViewHolder r100) {
                this.f74131a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                Function1<IMVTab, Unit> r101 = this.f74131a.f74128d.getTabSelectedListener();
                if (r101 == null) goto L6;
                Unit r102 = r101.invoke(this.f74131a.f74125a);
                return;
            }
        }

        public TabViewHolder(MvSelectTabView r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "rootView");
            this.f74128d = r100;
            super(r101);
            this.f74126b = (TextView) r101.findViewById(R.id.tab_name);
            this.f74127c = r101.findViewById(R.id.tab_bg);
            r101.post(new a(this, r101));
            r101.setOnClickListener(new b(this));
        }
    }

    public MvSelectTabView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MvSelectTabView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final String getTabViewSelectedTab() {
        String r100 = this.f74122b;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final Function1<IMVTab, Unit> getTabSelectedListener() {
        return this.f74124d;
    }

    public final void r(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tabName");
        if (((ArrayList) this.f74121a).size() != 0) goto L5;
        return;
    L5:
        int r101 = ((ArrayList) this.f74121a).size();
        int r102 = -1;
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L11;
        if (Intrinsics.areEqual(((IMVTab) ListProtector.get(this.f74121a, r103)).getName(), r100) == false) goto L10;
        r102 = r103;
    L10:
        r103 = r103 + 1;
        goto L6
    L11:
        int r104 = ((ArrayList) this.f74121a).size();
        if (r102 < 0) goto L16;
        if (r104 <= r102) goto L16;
        this.f74122b = r100;
        scrollToPosition(r102);
    L16:
        notifyDataSetChanged();
    }

    public final void setDataAndNotify(List<? extends IMVTab> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        ((ArrayList) this.f74121a).clear();
        ArrayList r101 = (ArrayList) this.f74121a;
        r101.addAll(r100);
        notifyDataSetChanged();
    }

    public final void setTabSelectedListener(Function1<? super IMVTab, Unit> r100) {
        this.f74124d = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.recyclerview.widget.RecyclerView$Adapter, com.bytedance.android.live.liveinteract.interactivesong.panel.MvSelectTabView$tabAdapter$1] */
    public MvSelectTabView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f74121a = new ArrayList();
        ?? r103 = new MvSelectTabView$tabAdapter$1(this);
        this.f74123c = r103;
        setLayoutManager(new SSLinearLayoutManager(r100, 0));
        setAdapter(r103);
        setNestedScrollingEnabled(false);
        addItemDecoration(new AnonymousClass1());
    }

    public /* synthetic */ MvSelectTabView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
