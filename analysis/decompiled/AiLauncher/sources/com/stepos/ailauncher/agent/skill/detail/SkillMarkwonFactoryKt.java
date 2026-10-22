package com.stepos.ailauncher.agent.skill.detail;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$color;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import u8.AbstractC5589a;
import v8.C5671a;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aD\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u0014H\u0080@¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroid/content/Context;", "context", "Lu8/e;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)Lu8/e;", "Landroid/view/View;", "card", "viewFull", "", "truncated", "LY8/t;", "e", "(Landroid/view/View;Landroid/view/View;Z)V", "Landroid/widget/TextView;", "tv", "markwon", "", "md", "", "maxHeightDp", "Lkotlin/Function1;", "onResult", "c", "(Landroid/widget/TextView;Lu8/e;Ljava/lang/String;ILp9/l;Le9/c;)Ljava/lang/Object;", "agent_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SkillMarkwonFactoryKt {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/agent/skill/detail/SkillMarkwonFactoryKt$a", "Lu8/a;", "Lv8/a$a;", "builder", "LY8/t;", "k", "(Lv8/a$a;)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AbstractC5589a {
        final /* synthetic */ int $codeBg;
        final /* synthetic */ int $divider;
        final /* synthetic */ float[] $headingMultipliers;
        final /* synthetic */ Typeface $headingTypeface;
        final /* synthetic */ int $link;

        public a(int i10, int i11, int i12, float[] fArr, Typeface typeface) {
            this.$link = i10;
            this.$divider = i11;
            this.$codeBg = i12;
            this.$headingMultipliers = fArr;
            this.$headingTypeface = typeface;
        }

        @Override // u8.AbstractC5589a, u8.i
        public void k(C5671a.C0540a builder) {
            kotlin.jvm.internal.p.i(builder, "builder");
            builder.Q(this.$link).y(this.$divider).S(this.$divider).C(this.$codeBg).D(this.$codeBg).N(this.$headingMultipliers).O(this.$headingTypeface);
        }
    }

    public static final u8.e b(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Typeface typefaceCreate = Typeface.create(Typeface.DEFAULT, 500, false);
        kotlin.jvm.internal.p.h(typefaceCreate, "create(...)");
        u8.e eVarBuild = u8.e.a(context).a(new a(androidx.core.content.a.c(context, R$color.sd_link), androidx.core.content.a.c(context, R$color.sd_card_stroke), 352321535, new float[]{1.2142857f, 1.2142857f, 1.2142857f, 1.0f, 0.9f, 0.85f}, typefaceCreate)).build();
        kotlin.jvm.internal.p.h(eVarBuild, "build(...)");
        return eVarBuild;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(final android.widget.TextView r7, u8.e r8, java.lang.String r9, int r10, final p9.InterfaceC5074l<? super java.lang.Boolean, Y8.t> r11, e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            boolean r0 = r12 instanceof com.stepos.ailauncher.agent.skill.detail.SkillMarkwonFactoryKt$renderReadmePreview$1
            if (r0 == 0) goto L13
            r0 = r12
            com.stepos.ailauncher.agent.skill.detail.SkillMarkwonFactoryKt$renderReadmePreview$1 r0 = (com.stepos.ailauncher.agent.skill.detail.SkillMarkwonFactoryKt$renderReadmePreview$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.detail.SkillMarkwonFactoryKt$renderReadmePreview$1 r0 = new com.stepos.ailauncher.agent.skill.detail.SkillMarkwonFactoryKt$renderReadmePreview$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L48
            if (r2 != r3) goto L40
            int r7 = r0.I$1
            java.lang.Object r8 = r0.L$3
            r11 = r8
            p9.l r11 = (p9.InterfaceC5074l) r11
            java.lang.Object r8 = r0.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r0.L$1
            u8.e r8 = (u8.e) r8
            java.lang.Object r9 = r0.L$0
            android.widget.TextView r9 = (android.widget.TextView) r9
            kotlin.C4849c.b(r12)
            r6 = r12
            r12 = r7
            r7 = r9
            r9 = r6
            goto L82
        L40:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L48:
            kotlin.C4849c.b(r12)
            float r12 = (float) r10
            android.content.res.Resources r2 = r7.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            float r2 = r2.density
            float r12 = r12 * r2
            int r12 = (int) r12
            r7.setMaxHeight(r12)
            r2 = 4
            r7.setVisibility(r2)
            Ua.I r2 = Ua.Y.a()
            com.stepos.ailauncher.agent.skill.detail.SkillMarkwonFactoryKt$renderReadmePreview$spanned$1 r4 = new com.stepos.ailauncher.agent.skill.detail.SkillMarkwonFactoryKt$renderReadmePreview$spanned$1
            r5 = 0
            r4.<init>(r8, r9, r5)
            r0.L$0 = r7
            r0.L$1 = r8
            java.lang.Object r9 = g9.h.a(r9)
            r0.L$2 = r9
            r0.L$3 = r11
            r0.I$0 = r10
            r0.I$1 = r12
            r0.label = r3
            java.lang.Object r9 = Ua.C1056g.j(r2, r4, r0)
            if (r9 != r1) goto L82
            return r1
        L82:
            java.lang.String r10 = "withContext(...)"
            kotlin.jvm.internal.p.h(r9, r10)
            android.text.Spanned r9 = (android.text.Spanned) r9
            r8.g(r7, r9)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            if (r8 == 0) goto La4
            r9 = -2
            r8.height = r9
            r7.setLayoutParams(r8)
            com.stepos.ailauncher.agent.skill.detail.m0 r8 = new com.stepos.ailauncher.agent.skill.detail.m0
            r8.<init>()
            r7.post(r8)
            Y8.t r7 = Y8.t.f7040a
            return r7
        La4:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.detail.SkillMarkwonFactoryKt.c(android.widget.TextView, u8.e, java.lang.String, int, p9.l, e9.c):java.lang.Object");
    }

    public static final void d(TextView textView, int i10, InterfaceC5074l interfaceC5074l) {
        textView.setVisibility(0);
        Layout layout = textView.getLayout();
        if (layout == null) {
            interfaceC5074l.invoke(Boolean.FALSE);
            return;
        }
        if (layout.getHeight() <= i10) {
            interfaceC5074l.invoke(Boolean.FALSE);
            return;
        }
        int lineForVertical = layout.getLineForVertical(i10);
        if (layout.getLineBottom(lineForVertical) > i10 && lineForVertical > 0) {
            lineForVertical--;
        }
        CharSequence text = textView.getText();
        while (lineForVertical > 0) {
            int lineStart = layout.getLineStart(lineForVertical);
            int lineEnd = layout.getLineEnd(lineForVertical);
            if (lineStart < lineEnd && !La.H.x0(text.subSequence(lineStart, lineEnd))) {
                break;
            } else {
                lineForVertical--;
            }
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.height = layout.getLineBottom(lineForVertical) + textView.getPaddingTop() + textView.getPaddingBottom();
        textView.setLayoutParams(layoutParams);
        interfaceC5074l.invoke(Boolean.TRUE);
    }

    public static final void e(View card, View viewFull, boolean z10) {
        kotlin.jvm.internal.p.i(card, "card");
        kotlin.jvm.internal.p.i(viewFull, "viewFull");
        viewFull.setVisibility(z10 ? 0 : 8);
        card.setPadding(card.getPaddingLeft(), card.getPaddingTop(), card.getPaddingRight(), z10 ? 0 : card.getPaddingTop());
    }
}
