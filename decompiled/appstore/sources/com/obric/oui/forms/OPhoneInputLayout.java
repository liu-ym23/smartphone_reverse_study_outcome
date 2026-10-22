package com.obric.oui.forms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.utils.log.L;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.StringsKt__StringsKt;
import org.apache.http.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 12\u00020\u0001:\u0001HB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0012¢\u0006\u0004\b*\u0010\u0015J\r\u0010+\u001a\u00020\u0012¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0012H\u0002¢\u0006\u0004\b-\u0010,J\u000f\u0010.\u001a\u00020\u000bH\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b0\u0010(J\u0017\u00101\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b1\u0010(R\u0016\u00104\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00103R\u0016\u00108\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00103R\u0018\u0010;\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010ER\u0016\u0010G\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u00103¨\u0006I"}, d2 = {"Lcom/obric/oui/forms/OPhoneInputLayout;", "Lcom/obric/oui/forms/OInputLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "type", "", "setType", "(I)V", "resId", "setCustomStart", "defaultStart", "setDefaultCustomStart", "", "show", "w", "(Z)V", "", "getText", "()Ljava/lang/CharSequence;", "", "s", "setAreaCode", "(Ljava/lang/String;)V", "getAreaCode", "()Ljava/lang/String;", "Landroid/view/View$OnClickListener;", "listener", "setAreaClickListener", "(Landroid/view/View$OnClickListener;)V", "n", "(Ljava/lang/CharSequence;)I", "Landroid/text/Editable;", "editable", "l", "(Landroid/text/Editable;)V", "enableArrow", "setEnableArrowIcon", "getEnableArrowIcon", "()Z", "N", "L", "()V", "K", "M", "E", "Z", "isChinesePhoneNumber", "F", "isTextFormating", "G", "showAreaCode", "H", "Ljava/lang/String;", "areaCode", "Landroid/widget/LinearLayout;", "I", "Landroid/widget/LinearLayout;", "vAreaCodeContainer", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "vAreaCodeText", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "vArrowIcon", "enableArrowIcon", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ClickableViewAccessibility"})
public class OPhoneInputLayout extends OInputLayout {
    public static final a M = null;
    public boolean E;
    public boolean F;
    public boolean G;
    public String H;
    public final LinearLayout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final TextView f14798J;
    public final ImageView K;
    public boolean L;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        M = new a(null);
    }

    @JvmOverloads
    public OPhoneInputLayout(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public final void K(Editable r10) {
        if (this.F == false) goto L5;
        return;
    L5:
        String r11 = r10.toString();
        StringBuilder r12 = new StringBuilder();
        int r13 = r11.length();
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L11;
        char r15 = r11.charAt(r14);
        if (Character.isDigit(r15) == false) goto L10;
        r12.append(r15);
    L10:
        r14 = r14 + 1;
        goto L6
    L11:
        String r16 = r12.toString();
        q.f(r16, "filterTo(StringBuilder(), predicate).toString()");
        StringBuilder r17 = new StringBuilder();
        int r18 = 0;
        int r19 = 0;
    L13:
        if (r18 >= r16.length()) goto L22;
        int r20 = r19 + 1;
        r17.append(r16.charAt(r18));
        if (r19 == 2) goto L19;
        if (r19 == 6) goto L19;
    L21:
        r18 = r18 + 1;
        r19 = r20;
    L19:
        if (r19 == StringsKt__StringsKt.K(r16)) goto L21;
        r17.append(TokenParser.SP);
        goto L21
    L22:
        String r21 = r17.toString();
        q.f(r21, "StringBuilder().apply(builderAction).toString()");
        if (q.b(r21, r11) == false) goto L25;
        return;
    L25:
        this.F = true;
        r10.replace(0, r10.length(), r21);
        if (this.E == true) goto L49;
    L47:
        this.F = false;
        return;
    L49:
        Iterator r110 = t.l(new Integer[]{3, 8}).iterator();     // Catch: Exception -> L45
    L30:
        if (r110.hasNext() == false) goto L47;
        int r22 = ((Number) r110.next()).intValue();     // Catch: Exception -> L45
        int r23 = r22 + 1;     // Catch: Exception -> L45
        if (r11.length() < r22) goto L30;
        if (r21.length() < r22) goto L30;
        if (r11.charAt(r22) == ' ') goto L30;
        if (r21.charAt(r22) != ' ') goto L30;
        if (getVInput().getSelectionStart() != r23) goto L30;
        if (getVInput().getSelectionEnd() != r23) goto L30;
        getVInput().setSelection(r22 + 2);     // Catch: Exception -> L45
    L45:
        e = move-exception;
        L.j("OInputLayout", q.p("Failed to move cursor when formating: ", e.getMessage()));
        goto L47
    }

    public final void L() {
        Editable r10 = getVInput().getText();
        if (r10 != null) goto L5;
        int r11 = 0;
    L11:
        getVInput().setSelection(r11);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        L.j("OInputLayout", q.p("Failed to move cursor to end: ", e.getMessage()));
        return;
    L5:
        r11 = r10.length();
        goto L11
    }

    public final void M(Editable r10) {
        if (this.F == false) goto L5;
        return;
    L5:
        String r11 = r10.toString();
        String r12 = kotlin.text.o.x(r11, " ", "", false, 4, null);
        if (q.b(r12, r11) == false) goto L8;
        return;
    L8:
        this.F = true;
        r10.replace(0, r10.length(), r12);
        this.F = false;
    }

    public final boolean N() {
        if ((getInputType() & 15) == 3) goto L5;
    L13:
        return false;
    L5:
        if (this.G == false) goto L13;
        String r10 = this.H;
        if (r10 != null) goto L9;
        String r11 = null;
    L11:
        if (q.b(r11, "+86") == false) goto L13;
        return true;
    L9:
        r11 = StringsKt__StringsKt.z0(r10).toString();
        goto L11
    }

    @Nullable
    public final String getAreaCode() {
        return this.H;
    }

    public final boolean getEnableArrowIcon() {
        return this.L;
    }

    @Override // com.obric.oui.forms.OInputLayout
    @Nullable
    public CharSequence getText() {
        if (this.E == false) goto L13;
        Editable r10 = getVInput().getText();
        if (r10 == null) goto L14;
        String r11 = r10.toString();
        if (r11 != null) goto L11;
        return null;
    L11:
        return kotlin.text.o.x(r11, " ", "", false, 4, null);
    L14:
        return null;
    L13:
        return super.getText();
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void l(Editable r10) {
        if (N() == false) goto L11;
        if (r10 != null) goto L6;
        r10 = getVInput().getText();
    L6:
        if (r10 == null) goto L9;
        K(r10);
    L9:
        this.E = true;
        return;
    L11:
        if (this.E == false) goto L20;
        if (r10 != null) goto L14;
        r10 = getVInput().getText();
    L14:
        if (r10 == null) goto L17;
        M(r10);
    L17:
        this.E = false;
        return;
    }

    @Override // com.obric.oui.forms.OInputLayout
    public int n(CharSequence r10) {
        int r11 = 0;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (this.E == false) goto L8;
    L11:
        int r12 = 0;
    L13:
        if (r11 >= r10.length()) goto L22;
        if (Character.isDigit(r10.charAt(r11)) == false) goto L17;
        r12 = r12 + 1;
    L17:
        r11 = r11 + 1;
        goto L13
    L22:
        return r12;
    L8:
        if (N() == true) goto L11;
        return r10.length();
    }

    public final void setAreaClickListener(@NotNull View.OnClickListener r10) {
        q.g(r10, "listener");
        this.I.setOnClickListener(r10);
    }

    public final void setAreaCode(@Nullable String r10) {
        if (r10 == null) goto L10;
        String r11 = this.H;
        if (r11 != null) goto L6;
    L8:
        this.H = r10;
        this.f14798J.setText(r10);
        l(getVInput().getText());
        L();
        return;
    L6:
        if (kotlin.text.o.q(r11, r10, false, 2, null) == false) goto L8;
        return;
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setCustomStart(int r10) {
        super.setCustomStart(R$layout.o_input_custom_start_area_code);
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setDefaultCustomStart(int r10) {
        super.setCustomStart(R$layout.o_input_custom_start_area_code);
    }

    public final void setEnableArrowIcon(boolean r10) {
        if (this.L != r10) goto L5;
        return;
    L5:
        this.L = r10;
        ImageView r11 = this.K;
        if (r11 == null) goto L12;
        if (r10 == false) goto L9;
        float r12 = 1.0f;
    L10:
        r11.setAlpha(r12);
        return;
    L9:
        r12 = 0.3f;
        goto L10
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setType(int r10) {
        if (r10 == 0) goto L4;
        return;
    L4:
        super.setType(r10);
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void w(boolean r10) {
        if (this.G != r10) goto L5;
        return;
    L5:
        this.G = r10;
        super.w(r10);
        l(getVInput().getText());
    }

    @JvmOverloads
    public OPhoneInputLayout(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OPhoneInputLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OPhoneInputLayout(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.L = true;
        setType(0);
        setCustomStart(R$layout.o_input_custom_start_area_code);
        w(true);
        setInputType(3);
        View r13 = findViewById(R$id.o_input_area_code_container);
        q.f(r13, "findViewById(R.id.o_input_area_code_container)");
        this.I = (LinearLayout) r13;
        View r14 = findViewById(R$id.o_input_area_code_text);
        q.f(r14, "findViewById(R.id.o_input_area_code_text)");
        this.f14798J = (TextView) r14;
        View r15 = findViewById(R$id.o_input_area_code_arrow);
        q.f(r15, "findViewById(R.id.o_input_area_code_arrow)");
        this.K = (ImageView) r15;
        TypedArray r16 = r10.getTheme().obtainStyledAttributes(r11, R$styleable.OPhoneInputLayout, r12, 0);
        setAreaCode(r16.getString(R$styleable.OPhoneInputLayout_oinput_areaCode));
        r16.recycle();
    }
}
