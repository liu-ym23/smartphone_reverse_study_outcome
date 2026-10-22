package com.obric.oui.privacy.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.privacy.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: PrivacySwitchViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends RecyclerView.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36089a = null;
    private final OCardListItem s;

    /* JADX INFO: compiled from: PrivacySwitchViewHolder.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final c a(Context r7) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            OCardListItem r6 = new OCardListItem(r1, null, 0, 6, null);
            r6.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            r6.setDefaultCustomEndView(1);
            r6.showCustomEnd(true);
            r6.showIcon(false);
            r6.showDivider(false);
            return new c(r6);
        }
    }

    static {
        f36089a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$pLsPMzN4KlHsrHR1jInqzW3UO-Y, reason: not valid java name */
    public static /* synthetic */ void m1145lambda$pLsPMzN4KlHsrHR1jInqzW3UOY(d.b r0, CompoundButton r1, boolean r2) {
        a(r0, r1, r2);
    }

    public c(OCardListItem r3) {
        o.e(r3, "cardListItem");
        super((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        this.s = r3;
    }

    public final void a(final d.b r7, int r8, int r9, int r10) {
        o.e(r7, "item");
        this.s.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r7.a(), CharSequence.class, "com.obric.aiagent.plugin"));
        int r2 = 1;
        if (r7.b() == null) goto L5;
        this.s.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(r7.b(), CharSequence.class, "com.obric.aiagent.plugin"));
        this.s.showSubTitle(true);
    L6:
        int r11 = r8 - r10;
        if (r9 != 1) goto L9;
        r2 = 0;
    L15:
        OCardListItem.setCardPosition$default(this.s, r2, false, 2, null);
        OSwitch r6 = this.s.getEndSwitch();
        if (r6 == null) goto L19;
        r6.setOnCheckedChangeListener(null);
    L19:
        if (r6 == null) goto L22;
        r6.setChecked(r7.c());
    L22:
        if (r6 == null) goto L26;
        r6.setOnCheckedChangeListener(new $$Lambda$c$pLsPMzN4KlHsrHR1jInqzW3UOY(r7));
        return;
    L26:
        return;
    L9:
        if (r11 == 0) goto L15;
        if (r11 != (r9 - 1)) goto L14;
        r2 = 3;
        goto L15
    L14:
        r2 = 2;
        goto L15
    L5:
        this.s.showSubTitle(false);
        goto L6
    }

    private static final void a(d.b r0, CompoundButton r1, boolean r2) {
        o.e(r0, "$item");
        d.h.a.b<Boolean, x> r3 = r0.d();
        if (r3 == null) goto L7;
        r3.invoke(Boolean.valueOf(r2));
        return;
    }
}
