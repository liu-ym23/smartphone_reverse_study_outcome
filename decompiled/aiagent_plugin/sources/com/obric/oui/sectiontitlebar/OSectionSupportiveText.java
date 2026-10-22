package com.obric.oui.sectiontitlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;

/* JADX INFO: compiled from: OSectionSupportiveText.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OSectionSupportiveText extends FrameLayout {
    private final f sectionDes$delegate;

    /* JADX INFO: compiled from: OSectionSupportiveText.kt */
    static final class a extends p implements d.h.a.a<TextView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSectionSupportiveText f36141a;

        a(OSectionSupportiveText r1) {
            this.f36141a = r1;
            super(0);
        }

        public final TextView a() {
            return (TextView) ZeusTransformUtils.preCheckCast(this.f36141a.findViewById(ZeusTransformUtils.mapRes(R.id.section_des, DbHelper.COL_ID, "section_des")), TextView.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ TextView invoke() {
            return a();
        }
    }

    public OSectionSupportiveText(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OSectionSupportiveText(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ OSectionSupportiveText(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public OSectionSupportiveText(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        super(r9, r10, r8);
        this.sectionDes$delegate = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new a(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        ZeusTransformUtils.inflate(LayoutInflater.from(r9), ZeusTransformUtils.mapRes(R.layout.o_view_section_supportive_text, "layout", "o_view_section_supportive_text"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        int[] r0 = R.styleable.OSectionSupportiveText;
        o.c(r0, "OSectionSupportiveText");
        TypedArray r11 = r9.obtainStyledAttributes(r10, r0, r8, 0);
        o.c(r11, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        String r12 = r11.getString(ZeusTransformUtils.mapRes(R.styleable.OSectionSupportiveText_section_des_text, "styleable", "OSectionSupportiveText_section_des_text"));
        getSectionDes().setText((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"));
        r11.recycle();
    }

    private final TextView getSectionDes() {
        Object r2 = this.sectionDes$delegate.b();
        o.c(r2, "<get-sectionDes>(...)");
        return (TextView) ZeusTransformUtils.preCheckCast(r2, TextView.class, "com.obric.aiagent.plugin");
    }

    public final void setSectionDes(String r3) {
        o.e(r3, "sectionText");
        getSectionDes().setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }
}
