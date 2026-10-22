package com.stepos.agentframework.chatui.view;

import Z8.C1173v;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import u4.m;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0010\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/agentframework/chatui/view/M;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "Lu4/m$c;", "files", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)V", "", "v", Const.INTENT_KEY_UMID, "(I)I", "f", "e", "(Lu4/m$c;)Landroid/widget/LinearLayout;", "Landroid/view/View;", "c", "()Landroid/view/View;", "Lkotlin/Function1;", "onFileClick", "Lp9/l;", "getOnFileClick", "()Lp9/l;", "setOnFileClick", "(Lp9/l;)V", "", "F", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class M extends LinearLayout {
    private final float d;
    private InterfaceC5074l<? super m.FileMessage, Y8.t> onFileClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.d = getResources().getDisplayMetrics().density;
        setOrientation(1);
        setPadding(d(16), d(16), d(16), d(16));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(d(16));
        gradientDrawable.setColor(695629440);
        setBackground(gradientDrawable);
    }

    public static final void f(M m10, m.FileMessage fileMessage, View view) {
        InterfaceC5074l<? super m.FileMessage, Y8.t> interfaceC5074l = m10.onFileClick;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(fileMessage);
        }
    }

    public final void b(List<m.FileMessage> files) {
        kotlin.jvm.internal.p.i(files, "files");
        removeAllViews();
        int i10 = 0;
        for (Object obj : files) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            m.FileMessage fileMessage = (m.FileMessage) obj;
            if (i10 > 0) {
                addView(c());
            }
            addView(e(fileMessage));
            i10 = i11;
        }
    }

    public final View c() {
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, d(1));
        layoutParams.topMargin = d(16);
        layoutParams.bottomMargin = d(16);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(234881023);
        return view;
    }

    public final int d(int v10) {
        return (int) (v10 * this.d);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.widget.LinearLayout e(final u4.m.FileMessage r9) {
        /*
            r8 = this;
            android.widget.LinearLayout r0 = new android.widget.LinearLayout
            android.content.Context r1 = r8.getContext()
            r0.<init>(r1)
            r1 = 0
            r0.setOrientation(r1)
            r2 = 16
            r0.setGravity(r2)
            r2 = 1
            r0.setClickable(r2)
            com.stepos.agentframework.chatui.view.L r3 = new com.stepos.agentframework.chatui.view.L
            r3.<init>()
            r0.setOnClickListener(r3)
            android.widget.ImageView r3 = new android.widget.ImageView
            android.content.Context r4 = r0.getContext()
            r3.<init>(r4)
            com.stepos.agentframework.chatui.Q1 r4 = com.stepos.agentframework.chatui.Q1.INSTANCE
            java.lang.String r5 = r9.getFileName()
            int r4 = r4.a(r5)
            r3.setImageResource(r4)
            android.widget.LinearLayout$LayoutParams r4 = new android.widget.LinearLayout$LayoutParams
            r5 = 24
            int r6 = r8.d(r5)
            int r7 = r8.d(r5)
            r4.<init>(r6, r7)
            r0.addView(r3, r4)
            android.widget.TextView r3 = new android.widget.TextView
            android.content.Context r4 = r0.getContext()
            r3.<init>(r4)
            java.lang.String r9 = r9.getFileName()
            if (r9 == 0) goto L60
            boolean r4 = La.H.x0(r9)
            if (r4 != 0) goto L5c
            goto L5d
        L5c:
            r9 = 0
        L5d:
            if (r9 == 0) goto L60
            goto L62
        L60:
            java.lang.String r9 = "文件"
        L62:
            r3.setText(r9)
            r9 = -1
            r3.setTextColor(r9)
            r9 = 1096810496(0x41600000, float:14.0)
            r3.setTextSize(r9)
            r3.setMaxLines(r2)
            android.text.TextUtils$TruncateAt r9 = android.text.TextUtils.TruncateAt.MIDDLE
            r3.setEllipsize(r9)
            android.widget.LinearLayout$LayoutParams r9 = new android.widget.LinearLayout$LayoutParams
            r2 = -2
            r4 = 1065353216(0x3f800000, float:1.0)
            r9.<init>(r1, r2, r4)
            r1 = 8
            int r2 = r8.d(r1)
            r9.setMarginStart(r2)
            int r1 = r8.d(r1)
            r9.setMarginEnd(r1)
            Y8.t r1 = Y8.t.f7040a
            r0.addView(r3, r9)
            android.widget.ImageView r9 = new android.widget.ImageView
            android.content.Context r1 = r0.getContext()
            r9.<init>(r1)
            int r1 = com.stepos.agentframework.R$drawable.ic_arrow_right_white
            r9.setImageResource(r1)
            r1 = 1058642330(0x3f19999a, float:0.6)
            r9.setAlpha(r1)
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams
            int r2 = r8.d(r5)
            int r8 = r8.d(r5)
            r1.<init>(r2, r8)
            r0.addView(r9, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.view.M.e(u4.m$c):android.widget.LinearLayout");
    }

    public final InterfaceC5074l<m.FileMessage, Y8.t> getOnFileClick() {
        return this.onFileClick;
    }

    public final void setOnFileClick(InterfaceC5074l<? super m.FileMessage, Y8.t> interfaceC5074l) {
        this.onFileClick = interfaceC5074l;
    }

    public /* synthetic */ M(Context context, AttributeSet attributeSet, int i10, kotlin.jvm.internal.i iVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
