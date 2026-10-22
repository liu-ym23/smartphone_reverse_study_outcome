package com.bytedance.android.livesdk.common;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends com.bytedance.android.livesdk.common.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f119693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f119694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f119695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f119696e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<a> f119697f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<PopupMenu.OnMenuItemClickListener> f119698g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f119699h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PopupMenu.OnMenuItemClickListener f119700i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f119701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f119702b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f119703c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (this.f119701a == r101.f119701a) goto L8;
            return false;
        L8:
            if (this.f119702b == r101.f119702b) goto L10;
            return false;
        L10:
            if (this.f119703c == r101.f119703c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        public final int hashCode() {
            int r100 = this.f119701a * 31;
            boolean r101 = this.f119702b;
            ?? r102 = r101;
            if (r101 == false) goto L6;
            r102 = 1;
        L6:
            return ((r100 + r102) * 31) + this.f119703c;
        }

        public final String toString() {
            return "ActionMenuItem(text=" + this.f119701a + ", disabled=" + this.f119702b + ", textColor=" + this.f119703c + ")";
        }

        public a(int r100, boolean r101, int r102) {
            int r103 = 0;
            if ((r102 & 2) == 0) goto L6;
            r101 = false;
        L6:
            if ((r102 & 4) == 0) goto L8;
            r103 = R.color.ttlive_core_hs_d1;
        L8:
            this.f119701a = r100;
            this.f119702b = r101;
            this.f119703c = r103;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.common.b, android.app.Dialog
    public final void onStart() {
        super.onStart();
        Window r100 = getWindow();
        if (r100 == null) goto L6;
        r100.setWindowAnimations(0);
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        int r102 = 0;
        if (r101 == null) goto L5;
        r101.setBackgroundDrawable(new ColorDrawable(0));
        r101.setGravity(80);
        r101.setLayout(-1, -2);
    L5:
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_bottom_sheet_action_picker, null));
        ((TextView) this.f119693b.getValue()).setText(this.f119696e);
        ((ViewGroup) this.f119694c.getValue()).removeAllViews();
        Iterator<T> r103 = this.f119697f.iterator();
    L7:
        if (r103.hasNext() == false) goto L18;
        Object r104 = r103.next();
        int r105 = r102 + 1;
        if (r102 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        a r106 = (a) r104;
        TextView r107 = new TextView(getContext());
        int r108 = s1.h(r106.f119703c);
        if (r106.f119702b == false) goto L14;
        r108 = r108 & Integer.MAX_VALUE;
    L14:
        r107.setTextColor(r108);
        r107.setBackgroundColor(s1.h(R.color.ttlive_white));
        r107.setTextSize(16.0f);
        r107.setGravity(17);
        PopupMenu.OnMenuItemClickListener r109 = (PopupMenu.OnMenuItemClickListener) CollectionsKt.getOrNull(this.f119698g, r102);
        if (r109 == null) goto L16;
        r107.setText(r106.f119701a);
        ViewGroup r110 = (ViewGroup) this.f119694c.getValue();
        LinearLayout.LayoutParams r111 = new LinearLayout.LayoutParams(-1, (int) s1.e(56.0f));
        r111.topMargin = s1.f(0.5f);
        Unit r112 = Unit.INSTANCE;
        r110.addView(r107, r111);
        r107.setOnClickListener(new f(r109, this));
        r102 = r105;
        goto L7
    L16:
        ALogger.e("BottomPickerDialog", "action is null when add item: " + r106);
        return;
    L18:
        ((TextView) this.f119695d.getValue()).setText(this.f119699h);
        ((TextView) this.f119695d.getValue()).setOnClickListener(new g(this));
    }

    public e(Context r100, List r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "options");
        Intrinsics.checkNotNullParameter(r102, "optionActions");
        super(r100, true);
        this.f119696e = R.string.ttlive_live_room_manage_admin;
        this.f119697f = r101;
        this.f119698g = r102;
        this.f119699h = R.string.ttlive_cancel;
        this.f119700i = null;
        this.f119693b = InfraKotlinExtsKt.mainThreadLazy(new BottomSheetActionPickerDialog$titleView$2(this));
        this.f119694c = InfraKotlinExtsKt.mainThreadLazy(new BottomSheetActionPickerDialog$itemContainer$2(this));
        this.f119695d = InfraKotlinExtsKt.mainThreadLazy(new BottomSheetActionPickerDialog$cancelView$2(this));
    }
}
