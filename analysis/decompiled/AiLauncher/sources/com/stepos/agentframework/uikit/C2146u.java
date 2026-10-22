package com.stepos.agentframework.uikit;

import K8.a;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.uikit.MarkwonHelper;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.HashMap;
import kotlin.Metadata;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u001f\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR0\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e`\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcom/stepos/agentframework/uikit/u;", "LK8/a$b;", "LYb/j;", "Lcom/stepos/agentframework/uikit/u$a;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lcom/stepos/agentframework/uikit/u$a;", "Lu8/e;", "markwon", "holder", "node", "LY8/t;", "f", "(Lu8/e;Lcom/stepos/agentframework/uikit/u$a;LYb/j;)V", Const.INTENT_KEY_PKGNAME, "Landroid/content/Context;", "context", "", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;I)I", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;I)F", "Ljava/util/HashMap;", "Landroid/text/Spanned;", "Lkotlin/collections/HashMap;", "cache", "Ljava/util/HashMap;", "codeBlockMaxHeightPx", "Ljava/lang/Integer;", "getCodeBlockMaxHeightPx", "()Ljava/lang/Integer;", "k", "(Ljava/lang/Integer;)V", "", "codeSelectable", "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "l", "(Z)V", Const.INTENT_KEY_APIKEY, "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.uikit.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2146u extends a.b<Yb.j, a> {
    private final HashMap<Yb.j, Spanned> cache = new HashMap<>();
    private Integer codeBlockMaxHeightPx;
    private boolean codeSelectable;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/uikit/u$a;", "LK8/a$c;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "card", "Landroid/view/View;", Const.INTENT_KEY_PKGNAME, "()Landroid/view/View;", "Landroid/widget/TextView;", "langLabel", "Landroid/widget/TextView;", Const.INTENT_KEY_UMID, "()Landroid/widget/TextView;", "Lcom/stepos/agentframework/uikit/AgentMarkdownCodeScrollView;", "scroll", "Lcom/stepos/agentframework/uikit/AgentMarkdownCodeScrollView;", "e", "()Lcom/stepos/agentframework/uikit/AgentMarkdownCodeScrollView;", "codeText", "c", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.uikit.u$a */
    public static final class a extends a.c {
        private final View card;
        private final TextView codeText;
        private final TextView langLabel;
        private final AgentMarkdownCodeScrollView scroll;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
            this.card = itemView;
            View viewA = a(R$id.code_lang_label);
            kotlin.jvm.internal.p.h(viewA, "requireView(...)");
            this.langLabel = (TextView) viewA;
            View viewA2 = a(R$id.code_scroll);
            kotlin.jvm.internal.p.h(viewA2, "requireView(...)");
            this.scroll = (AgentMarkdownCodeScrollView) viewA2;
            View viewA3 = a(R$id.code_text);
            kotlin.jvm.internal.p.h(viewA3, "requireView(...)");
            TextView textView = (TextView) viewA3;
            this.codeText = textView;
            textView.setSpannableFactory(N8.d.a());
        }

        /* renamed from: b, reason: from getter */
        public final View getCard() {
            return this.card;
        }

        /* renamed from: c, reason: from getter */
        public final TextView getCodeText() {
            return this.codeText;
        }

        /* renamed from: d, reason: from getter */
        public final TextView getLangLabel() {
            return this.langLabel;
        }

        /* renamed from: e, reason: from getter */
        public final AgentMarkdownCodeScrollView getScroll() {
            return this.scroll;
        }
    }

    @Override // K8.a.b
    public void b() {
        this.cache.clear();
    }

    @Override // K8.a.b
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void a(u8.e markwon, a holder, Yb.j node) {
        kotlin.jvm.internal.p.i(markwon, "markwon");
        kotlin.jvm.internal.p.i(holder, "holder");
        kotlin.jvm.internal.p.i(node, "node");
        Context context = holder.itemView.getContext();
        boolean z10 = (context.getResources().getConfiguration().uiMode & 48) == 32;
        int iJ = z10 ? MarkwonHelper.J() : MarkwonHelper.I();
        int iB = z10 ? MarkwonHelper.B() : MarkwonHelper.A();
        int iN = z10 ? MarkwonHelper.N() : MarkwonHelper.M();
        kotlin.jvm.internal.p.f(context);
        float fI = i(context, MarkwonHelper.R());
        View card = holder.getCard();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(iB);
        gradientDrawable.setCornerRadius(fI);
        card.setBackground(gradientDrawable);
        holder.getCard().setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        holder.getCard().setClipToOutline(true);
        View card2 = holder.getCard();
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(0);
        gradientDrawable2.setCornerRadius(fI);
        gradientDrawable2.setStroke(C5685n.f(C5227b.b(MarkwonHelper.E() * context.getResources().getDisplayMetrics().density), 1), MarkwonHelper.D());
        card2.setForeground(gradientDrawable2);
        TextView langLabel = holder.getLangLabel();
        String strQ = node.q();
        String string = strQ != null ? La.H.D1(strQ).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() <= 0) {
            string = "text";
        }
        langLabel.setText(string);
        langLabel.setTextColor(iN);
        langLabel.setTextSize(2, MarkwonHelper.O());
        langLabel.setTypeface(MarkwonHelper.z0(C2145t.b()));
        langLabel.setPaddingRelative(h(context, MarkwonHelper.L()), 0, 0, 0);
        ViewGroup.LayoutParams layoutParams = langLabel.getLayoutParams();
        layoutParams.height = h(context, MarkwonHelper.K());
        langLabel.setLayoutParams(layoutParams);
        langLabel.setBackgroundColor(iJ);
        AgentMarkdownCodeScrollView scroll = holder.getScroll();
        Integer num = this.codeBlockMaxHeightPx;
        if (num != null) {
            scroll.setMaxHeightPx(num.intValue());
        }
        scroll.setBackgroundColor(0);
        scroll.setPaddingRelative(0, h(context, MarkwonHelper.F()), 0, h(context, MarkwonHelper.C()));
        HashMap<Yb.j, Spanned> map = this.cache;
        Spanned spannedE = map.get(node);
        if (spannedE == null) {
            spannedE = markwon.e(node);
            kotlin.jvm.internal.p.h(spannedE, "render(...)");
            map.put(node, spannedE);
        }
        markwon.g(holder.getCodeText(), spannedE);
        if (holder.getCodeText().isTextSelectable() != this.codeSelectable) {
            holder.getCodeText().setTextIsSelectable(this.codeSelectable);
        }
        if (!this.codeSelectable) {
            if (holder.getCodeText().getMovementMethod() instanceof LinkMovementMethod) {
                return;
            }
            holder.getCodeText().setMovementMethod(LinkMovementMethod.getInstance());
            return;
        }
        CharSequence text = holder.getCodeText().getText();
        Spannable spannable = text instanceof Spannable ? (Spannable) text : null;
        if (spannable != null) {
            Object[] spans = spannable.getSpans(0, spannable.length(), MarkwonHelper.d.class);
            kotlin.jvm.internal.p.h(spans, "getSpans(...)");
            for (Object obj : spans) {
                spannable.removeSpan((MarkwonHelper.d) obj);
            }
        }
    }

    @Override // K8.a.b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public a c(LayoutInflater inflater, ViewGroup parent) {
        kotlin.jvm.internal.p.i(inflater, "inflater");
        kotlin.jvm.internal.p.i(parent, "parent");
        View viewInflate = inflater.inflate(R$layout.agent_markdown_code_entry, parent, false);
        kotlin.jvm.internal.p.h(viewInflate, "inflate(...)");
        return new a(viewInflate);
    }

    public final int h(Context context, int value) {
        return (int) TypedValue.applyDimension(1, value, context.getResources().getDisplayMetrics());
    }

    public final float i(Context context, int value) {
        return TypedValue.applyDimension(1, value, context.getResources().getDisplayMetrics());
    }

    /* renamed from: j, reason: from getter */
    public final boolean getCodeSelectable() {
        return this.codeSelectable;
    }

    public final void k(Integer num) {
        this.codeBlockMaxHeightPx = num;
    }

    public final void l(boolean z10) {
        this.codeSelectable = z10;
    }
}
