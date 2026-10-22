package com.obric.oui.dialog.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.button.OButton;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
public final class ButtonStyleController implements StyleController {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f14272i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OButton f14275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OButton f14276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OButton f14277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OAlertDialog f14278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f14279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f14280h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/dialog/alert/ButtonStyleController$ButtonStyle;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ButtonStyle {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/alert/ButtonStyleController$TextColorType;", "", "(Ljava/lang/String;I)V", "TextReverse", "TextReverse2", "Negative", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum TextColorType extends Enum<TextColorType> {
        private static final /* synthetic */ TextColorType[] $VALUES = null;
        public static final TextColorType Negative = null;
        public static final TextColorType TextReverse = null;
        public static final TextColorType TextReverse2 = null;

        private static final /* synthetic */ TextColorType[] $values() {
            return new TextColorType[]{TextReverse, TextReverse2, Negative};
        }

        static {
            TextReverse = new TextColorType("TextReverse", 0);
            TextReverse2 = new TextColorType("TextReverse2", 1);
            Negative = new TextColorType("Negative", 2);
            $VALUES = $values();
        }

        private TextColorType(String r10, int r11) {
            super(r10, r11);
        }

        public static TextColorType valueOf(String r10) {
            return (TextColorType) Enum.valueOf(TextColorType.class, r10);
        }

        public static TextColorType[] values() {
            return (TextColorType[]) $VALUES.clone();
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14281a = null;

        static {
            int[] r10 = new int[TextColorType.values().length];
            r10[TextColorType.Negative.ordinal()] = 1;
            r10[TextColorType.TextReverse.ordinal()] = 2;
            r10[TextColorType.TextReverse2.ordinal()] = 3;
            f14281a = r10;
        }
    }

    static {
        f14272i = new a(null);
    }

    public ButtonStyleController(Context r10, int r11) {
        q.g(r10, "context");
        this.f14273a = r10;
        this.f14274b = r11;
    }

    public static /* synthetic */ void a(ButtonStyleController r10, DialogInterface.OnClickListener r11, View r12) {
        g(r10, r11, r12);
    }

    public static /* synthetic */ void b(ButtonStyleController r10, DialogInterface.OnClickListener r11, View r12) {
        k(r10, r11, r12);
    }

    public static /* synthetic */ void c(ButtonStyleController r10, DialogInterface.OnClickListener r11, View r12) {
        i(r10, r11, r12);
    }

    public static final void g(ButtonStyleController r10, DialogInterface.OnClickListener r11, View r12) {
        q.g(r10, "this$0");
        OAlertDialog r13 = r10.f14278f;
        if (r13 == null) goto L10;
        if (r11 == null) goto L8;
        r11.onClick(r13, -2);
    L8:
        r10.m();
        return;
    }

    public static final void i(ButtonStyleController r10, DialogInterface.OnClickListener r11, View r12) {
        q.g(r10, "this$0");
        OAlertDialog r13 = r10.f14278f;
        if (r13 == null) goto L10;
        if (r11 == null) goto L8;
        r11.onClick(r13, -3);
    L8:
        r10.m();
        return;
    }

    public static final void k(ButtonStyleController r10, DialogInterface.OnClickListener r11, View r12) {
        q.g(r10, "this$0");
        OAlertDialog r13 = r10.f14278f;
        if (r13 == null) goto L10;
        if (r11 == null) goto L8;
        r11.onClick(r13, -1);
    L8:
        r10.m();
        return;
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public void attachToDialog(OAlertDialog r10) {
        q.g(r10, "dialog");
        this.f14278f = r10;
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public void attachToParent(Context r10, FrameLayout r11) {
        q.g(r10, "context");
        q.g(r11, "parent");
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-1, -2);
        int r13 = this.f14274b;
        if (r13 != 0) goto L5;
        int r14 = R$layout.o_dialog_button_horizontal;
    L9:
        View r15 = LayoutInflater.from(r10).inflate(r14, r11, false);
        r11.addView(r15, r12);
        this.f14279g = r15;
        if (r15 == null) goto L13;
        r15.setVisibility(8);
    L13:
        this.f14275c = (OButton) r15.findViewById(R$id.actionPositive);
        this.f14276d = (OButton) r15.findViewById(R$id.actionNegative);
        this.f14277e = (OButton) r15.findViewById(R$id.actionNeutral);
        this.f14280h = (FrameLayout) r15.findViewById(R$id.custom_container);
        return;
    L5:
        if (r13 == 1) goto L7;
        r14 = R$layout.o_dialog_button_primary;
        goto L9
    L7:
        r14 = R$layout.o_dialog_button_vertical;
        goto L9
    }

    public final void d() {
    }

    public final void e(View r10) {
        q.g(r10, "view");
        if (this.f14274b == 2) goto L5;
        return;
    L5:
        if (this.f14280h == null) goto L20;
        View r11 = this.f14279g;
        if (r11 == null) goto L10;
        r11.setVisibility(0);
    L10:
        FrameLayout r12 = this.f14280h;
        if (r12 == null) goto L14;
        r12.addView(r10);
    L14:
        FrameLayout r13 = this.f14280h;
        if (r13 == null) goto L21;
        l.m(r13);
        return;
    L21:
        return;
    }

    public final void f(CharSequence r10, final DialogInterface.OnClickListener r11, TextColorType r12) {
        OButton r13 = this.f14276d;
        if (r13 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L9;
        r13.setVisibility(8);
        return;
    L9:
        View r14 = this.f14279g;
        if (r14 == null) goto L13;
        r14.setVisibility(0);
    L13:
        r13.setText(r10);
        l(r13, r12);
        r13.setVisibility(0);
        r13.setOnClickListener(new com.obric.oui.dialog.alert.a(this, r11));
    }

    public final void h(CharSequence r10, final DialogInterface.OnClickListener r11, TextColorType r12) {
        OButton r13 = this.f14277e;
        if (r13 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L9;
        r13.setVisibility(8);
        return;
    L9:
        View r14 = this.f14279g;
        if (r14 == null) goto L13;
        r14.setVisibility(0);
    L13:
        r13.setText(r10);
        l(r13, r12);
        r13.setVisibility(0);
        r13.setOnClickListener(new com.obric.oui.dialog.alert.b(this, r11));
    }

    public final void j(CharSequence r10, final DialogInterface.OnClickListener r11, TextColorType r12, boolean r13) {
        OButton r14 = this.f14275c;
        if (r14 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L9;
        r14.setVisibility(8);
        return;
    L9:
        View r15 = this.f14279g;
        if (r15 == null) goto L13;
        r15.setVisibility(0);
    L13:
        if (r13 == false) goto L15;
        r14.setBackgroundTintList(ContextCompat.c(this.f14273a, R$color.oui_red_6));
        r14.setTextColor(ContextCompat.b(this.f14273a, R$color.white));
    L15:
        r14.setText(r10);
        l(r14, r12);
        r14.setVisibility(0);
        r14.setOnClickListener(new c(this, r11));
    }

    public final void l(OButton r10, TextColorType r11) {
        if (r11 == null) goto L16;
        int r12 = b.f14281a[r11.ordinal()];
        if (r12 != 1) goto L6;
        int r13 = R$color.Negative;
    L14:
        r10.setTextColor(ContextCompat.b(r10.getContext(), r13));
        return;
    L6:
        if (r12 != 2) goto L8;
        r13 = R$color.TextReverse;
        goto L14
    L8:
        if (r12 != 3) goto L11;
        r13 = R$color.TextReverse2;
        goto L14
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public final void m() {
        OAlertDialog r10 = this.f14278f;
        if (r10 != null) goto L6;
    L8:
        OAlertDialog r11 = this.f14278f;
        if (r11 == null) goto L13;
        r11.dismiss();
        return;
    L13:
        return;
    L6:
        if (r10.isAutoDismiss() == true) goto L8;
    }
}
