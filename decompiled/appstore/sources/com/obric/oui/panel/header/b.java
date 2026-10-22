package com.obric.oui.panel.header;

import android.content.Context;
import android.view.View;
import com.obric.common.oui.R$style;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f15900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View.OnClickListener f15901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15902f;

    public /* synthetic */ b(Context r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        this(r10, r11, r12);
    }

    public static /* synthetic */ Context b(b r10, Context r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = r10.f15898b;
    L7:
        return r10.a(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateThemedContext");
    }

    public final Context a(Context r10, boolean r11) {
        q.g(r10, "baseContext");
        if (this.f15899c != 0) goto L10;
        if (r11 == false) goto L7;
        g.b r12 = new g.b(r10, R$style.OBasicPanelDayNightSwitch);
    L8:
        this.f15900d = r12;
        return r12;
    L7:
        r12 = new g.b(r10, R$style.OBasicPanelConstLight);
        goto L8
    L10:
        return new g.b(r10, this.f15899c);
    }

    public final boolean c() {
        return this.f15902f;
    }

    public final Context d() {
        Context r10 = this.f15900d;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return b(this, this.f15897a, false, 2, null);
    }

    public abstract View e();

    public void setCloseClickListenerOnPad(@Nullable View.OnClickListener r10) {
        this.f15901e = r10;
    }

    public b(Context r10, boolean r11, int r12) {
        this.f15897a = r10;
        this.f15898b = r11;
        this.f15899c = r12;
        this.f15902f = true;
    }

    public /* synthetic */ b(Context r10, boolean r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = false;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12, null);
    }
}
