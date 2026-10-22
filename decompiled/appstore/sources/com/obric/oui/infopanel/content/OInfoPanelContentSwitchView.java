package com.obric.oui.infopanel.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/infopanel/content/OInfoPanelContentSwitchView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvTitle", "Lcom/obric/oui/oswitch/OSwitch;", "b", "Lcom/obric/oui/oswitch/OSwitch;", "getOSwitch", "()Lcom/obric/oui/oswitch/OSwitch;", "oSwitch", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInfoPanelContentSwitchView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f15085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OSwitch f15086b;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OInfoPanelContentSwitchView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @NotNull
    public final OSwitch getOSwitch() {
        return this.f15086b;
    }

    @NotNull
    public final TextView getTvTitle() {
        return this.f15085a;
    }

    public /* synthetic */ OInfoPanelContentSwitchView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OInfoPanelContentSwitchView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        ViewGroup.inflate(r10, R$layout.o_info_panel_content_switch_view, this);
        ViewGroup.MarginLayoutParams r12 = new ViewGroup.MarginLayoutParams(-1, -2);
        r12.setMargins(0, f.r(this, 16), 0, f.r(this, 12));
        setLayoutParams(r12);
        setBackgroundResource(R$drawable.o_info_panel_content_switch_view_bg);
        int r13 = f.r(this, 16);
        setPadding(r13, r13, r13, r13);
        View r14 = findViewById(R$id.tv_title);
        q.f(r14, "findViewById(R.id.tv_title)");
        this.f15085a = (TextView) r14;
        View r15 = findViewById(R$id.o_switch);
        q.f(r15, "findViewById(R.id.o_switch)");
        OSwitch r16 = (OSwitch) r15;
        this.f15086b = r16;
        l.c(r16, f.r(this, 44));
    }
}
