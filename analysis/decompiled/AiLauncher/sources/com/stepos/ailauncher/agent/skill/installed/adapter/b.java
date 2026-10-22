package com.stepos.ailauncher.agent.skill.installed.adapter;

import Y4.B;
import Y8.t;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.agent.skill.installed.adapter.b;
import com.stepos.ailauncher.chat.view.C2765a9;
import d5.l;
import d5.m;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.y;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \u001a2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001b\u001cBI\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0016\u001a\u00020\u00072\n\u0010\u0014\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0018R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0019R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installed/adapter/b;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/stepos/ailauncher/agent/skill/installed/adapter/a;", "Lcom/stepos/ailauncher/agent/skill/installed/adapter/b$c;", "Lkotlin/Function2;", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "", "LY8/t;", "onToggle", "Lkotlin/Function1;", "onUninstallClick", "onCardClick", "<init>", "(Lp9/p;Lp9/l;Lp9/l;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "f", "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/agent/skill/installed/adapter/b$c;", "holder", "position", "e", "(Lcom/stepos/ailauncher/agent/skill/installed/adapter/b$c;I)V", "Lp9/p;", "Lp9/l;", "Companion", "c", Const.INTENT_KEY_PKGNAME, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b extends ListAdapter<InstalledRow, c> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final a DIFF = new a();
    private final InterfaceC5074l<SkillItem, t> onCardClick;
    private final p<SkillItem, Boolean, t> onToggle;
    private final InterfaceC5074l<SkillItem, t> onUninstallClick;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u001f\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/agent/skill/installed/adapter/b$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/stepos/ailauncher/agent/skill/installed/adapter/a;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "", "(Lcom/stepos/ailauncher/agent/skill/installed/adapter/a;Lcom/stepos/ailauncher/agent/skill/installed/adapter/a;)Z", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends DiffUtil.ItemCallback<InstalledRow> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(InstalledRow a10, InstalledRow b10) {
            kotlin.jvm.internal.p.i(a10, "a");
            kotlin.jvm.internal.p.i(b10, "b");
            return kotlin.jvm.internal.p.d(a10, b10);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(InstalledRow a10, InstalledRow b10) {
            kotlin.jvm.internal.p.i(a10, "a");
            kotlin.jvm.internal.p.i(b10, "b");
            return kotlin.jvm.internal.p.d(a10.getItem().getIdentifier(), b10.getItem().getIdentifier());
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installed/adapter/b$b;", "", "<init>", "()V", "", "count", "", Const.INTENT_KEY_APIKEY, "(J)Ljava/lang/String;", "com/stepos/ailauncher/agent/skill/installed/adapter/b$a", "DIFF", "Lcom/stepos/ailauncher/agent/skill/installed/adapter/b$a;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.skill.installed.adapter.b$b, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final String a(long count) {
            if (count >= 1000000) {
                y yVar = y.f34840a;
                String str = String.format("%.1fM", Arrays.copyOf(new Object[]{Double.valueOf(count / 1000000.0d)}, 1));
                kotlin.jvm.internal.p.h(str, "format(...)");
                return str;
            }
            if (count < 1000) {
                return String.valueOf(count);
            }
            y yVar2 = y.f34840a;
            String str2 = String.format("%dk", Arrays.copyOf(new Object[]{Long.valueOf(count / 1000)}, 1));
            kotlin.jvm.internal.p.h(str2, "format(...)");
            return str2;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installed/adapter/b$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "LY4/B;", Const.INTENT_KEY_PKGNAME, "<init>", "(Lcom/stepos/ailauncher/agent/skill/installed/adapter/b;LY4/B;)V", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "LY8/t;", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/agent/skill/SkillItem;)V", "Lcom/stepos/ailauncher/agent/skill/installed/adapter/a;", "row", "e", "(Lcom/stepos/ailauncher/agent/skill/installed/adapter/a;)V", "LY4/B;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class c extends RecyclerView.ViewHolder {
        private final B b;
        final /* synthetic */ b this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, B b10) {
            super(b10.b());
            kotlin.jvm.internal.p.i(b10, "b");
            this.this$0 = bVar;
            this.b = b10;
        }

        private final void d(SkillItem item) {
            Context context = this.b.b().getContext();
            m mVar = m.INSTANCE;
            int iE = mVar.e(item.getIdentifier(), mVar.d());
            int iC = androidx.core.content.a.c(context, mVar.b()[iE]);
            int iC2 = androidx.core.content.a.c(context, mVar.c()[iE]);
            Drawable background = this.b.iconPlaceholder.getBackground();
            Drawable drawableMutate = background != null ? background.mutate() : null;
            GradientDrawable gradientDrawable = drawableMutate instanceof GradientDrawable ? (GradientDrawable) drawableMutate : null;
            if (gradientDrawable == null) {
                gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(1);
                gradientDrawable.setColor(iC);
                this.b.iconPlaceholder.setBackground(gradientDrawable);
            }
            if (background == null || !(background instanceof GradientDrawable)) {
                this.b.iconPlaceholder.setBackground(gradientDrawable);
            } else {
                gradientDrawable.setShape(1);
                gradientDrawable.setColor(iC);
            }
            this.b.tvSkillIconChar.setText(mVar.a(item.getDisplayName()));
            this.b.tvSkillIconChar.setTextColor(iC2);
            ImageView ivSkillIcon = this.b.ivSkillIcon;
            kotlin.jvm.internal.p.h(ivSkillIcon, "ivSkillIcon");
            TextView tvSkillIconChar = this.b.tvSkillIconChar;
            kotlin.jvm.internal.p.h(tvSkillIconChar, "tvSkillIconChar");
            C2765a9.a(ivSkillIcon, tvSkillIconChar, item.getIconUrl());
        }

        public static final t f(View it) {
            kotlin.jvm.internal.p.i(it, "it");
            return t.f7040a;
        }

        public static final t g(b bVar, SkillItem skillItem, boolean z10) {
            bVar.onToggle.invoke(skillItem, Boolean.valueOf(z10));
            return t.f7040a;
        }

        public static final void h(b bVar, SkillItem skillItem, View view) {
            bVar.onCardClick.invoke(skillItem);
        }

        public final void e(InstalledRow row) throws Resources.NotFoundException {
            FrameLayout frameLayoutL;
            kotlin.jvm.internal.p.i(row, "row");
            final SkillItem item = row.getItem();
            this.b.tvTitle.setText(item.getDisplayName());
            this.b.tvSourceDownload.setText(b.INSTANCE.a(item.getDownloadCount()));
            this.b.tvDescription.setText(item.getSummary());
            TextView textView = this.b.txtSource;
            String source = item.getSource();
            textView.setVisibility((source == null || source.length() <= 0 || kotlin.jvm.internal.p.d(item.getSource(), "skillhub")) ? 8 : 0);
            textView.setText("第三方");
            boolean z10 = item.getStatus() == SkillStatus.INSTALLED_ENABLED || item.getStatus() == SkillStatus.CONNECTED;
            this.b.actionArea.removeAllViews();
            if (row.getIsToggling() || row.getIsUninstalling() || item.getStatus() == SkillStatus.TOGGLING || item.getStatus() == SkillStatus.UNINSTALLING) {
                l lVar = l.INSTANCE;
                Context context = this.b.b().getContext();
                kotlin.jvm.internal.p.h(context, "getContext(...)");
                frameLayoutL = lVar.l(context, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.installed.adapter.c
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return b.c.f((View) obj);
                    }
                });
            } else {
                l lVar2 = l.INSTANCE;
                Context context2 = this.b.b().getContext();
                kotlin.jvm.internal.p.h(context2, "getContext(...)");
                final b bVar = this.this$0;
                frameLayoutL = lVar2.s(context2, z10, true, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.installed.adapter.d
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return b.c.g(bVar, item, ((Boolean) obj).booleanValue());
                    }
                });
            }
            this.b.actionArea.addView(frameLayoutL);
            this.b.b().setAlpha(item.getStatus() == SkillStatus.INSTALLED_DISABLED ? 0.4f : 1.0f);
            d(item);
            LinearLayout linearLayoutB = this.b.b();
            final b bVar2 = this.this$0;
            linearLayoutB.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.installed.adapter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.c.h(bVar2, item, view);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(p<? super SkillItem, ? super Boolean, t> onToggle, InterfaceC5074l<? super SkillItem, t> onUninstallClick, InterfaceC5074l<? super SkillItem, t> onCardClick) {
        super(DIFF);
        kotlin.jvm.internal.p.i(onToggle, "onToggle");
        kotlin.jvm.internal.p.i(onUninstallClick, "onUninstallClick");
        kotlin.jvm.internal.p.i(onCardClick, "onCardClick");
        this.onToggle = onToggle;
        this.onUninstallClick = onUninstallClick;
        this.onCardClick = onCardClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c holder, int position) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(holder, "holder");
        InstalledRow item = getItem(position);
        kotlin.jvm.internal.p.h(item, "getItem(...)");
        holder.e(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        B bC = B.c(LayoutInflater.from(parent.getContext()), parent, false);
        kotlin.jvm.internal.p.h(bC, "inflate(...)");
        return new c(this, bC);
    }
}
