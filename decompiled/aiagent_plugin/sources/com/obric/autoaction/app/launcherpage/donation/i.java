package com.obric.autoaction.app.launcherpage.donation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.ap;
import com.obric.autoaction.app.launcherpage.donation.model.Question;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: QuestionAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends RecyclerView.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Question> f23767a;

    /* JADX INFO: compiled from: QuestionAdapter.kt */
    public static final class a extends RecyclerView.u {
        private final ap r;

        public static /* synthetic */ void lambda$xAz9IrfSYz9fzcE6c6TwKgMgnzc(a r0, Question r1, View r2) {
            a(r0, r1, r2);
        }

        public a(View r2) {
            o.e(r2, "itemView");
            super(r2);
            ap r3 = ap.a(r2);
            o.c(r3, "bind(...)");
            this.r = r3;
        }

        public final void a(final Question r12) {
            o.e(r12, "question");
            OCardListItem r0 = this.r.f22765b;
            r0.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r12.getName(), CharSequence.class, "com.obric.aiagent.plugin"));
            String r1 = r12.getReward();
            if (r1 != null) goto L5;
        L13:
            r0.setOnContentClickListener(new $$Lambda$i$a$xAz9IrfSYz9fzcE6c6TwKgMgnzc(this, r12));
            RecyclerView.a<? extends RecyclerView.u> r13 = h();
            if (r13 != null) goto L16;
        L18:
            boolean r14 = false;
        L19:
            if (r14 == false) goto L21;
            OCardListItem.setCardPosition$default(r0, 0, false, 2, null);
            return;
        L21:
            int r15 = f();
            RecyclerView.a<? extends RecyclerView.u> r11 = h();
            if (r11 == null) goto L24;
            int r16 = r11.a();
        L26:
            if (r15 != (r16 - 1)) goto L28;
            OCardListItem.setCardPosition$default(r0, 3, false, 2, null);
            return;
        L28:
            OCardListItem.setCardPosition$default(r0, 2, false, 2, null);
            return;
        L24:
            r16 = -1;
            goto L26
        L16:
            if (r13.a() != 1) goto L18;
            r14 = true;
            goto L19
        L5:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L7;
            boolean r7 = true;
        L8:
            if (r7 == true) goto L11;
            r1 = null;
        L11:
            if (r1 == null) goto L13;
            OCardListItem.setEndDetailText$default(r0, (CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.reward_text, WsChannelMultiProcessSharedProvider.STRING_TYPE, "reward_text"), new Object[]{r1}), CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
            goto L13
        L7:
            r7 = false;
            goto L8
        }

        private static final void a(a r2, Question r3, View r4) {
            DataDonationQuestionDescActivity.a r5 = DataDonationQuestionDescActivity.Companion;
            Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.f2390a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r6, "getContext(...)");
            r5.startActivity(r6, r3);
        }
    }

    public i() {
        this.f23767a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ RecyclerView.u a(ViewGroup r1, int r2) {
        return (RecyclerView.u) ZeusTransformUtils.preCheckCast(c(r1, r2), RecyclerView.u.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ void a(RecyclerView.u r3, int r4) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"), r4);
    }

    public final void a(List<Question> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "data");
        this.f23767a.clear();
        this.f23767a.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"));
        d();
    }

    public a c(ViewGroup r2, int r3) {
        o.e(r2, "parent");
        ap r1 = ap.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r2, false);
        o.c(r1, "inflate(...)");
        FrameLayout r4 = r1.b();
        o.c(r4, "getRoot(...)");
        return new a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a() {
        return this.f23767a.size();
    }

    public void a(a r2, int r3) {
        o.e(r2, "holder");
        r2.a((Question) ZeusTransformUtils.preCheckCast(this.f23767a.get(r3), Question.class, "com.obric.aiagent.plugin"));
    }
}
