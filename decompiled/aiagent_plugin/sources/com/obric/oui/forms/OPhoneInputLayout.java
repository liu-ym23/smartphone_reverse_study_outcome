package com.obric.oui.forms;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.d.a.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;

/* JADX INFO: compiled from: OPhoneInputLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OPhoneInputLayout extends OInputLayout {
    private static final String CHINA_AREA_CODE = "+86";
    public static final a Companion = null;
    private String areaCode;
    private boolean enableArrowIcon;
    private boolean isChinesePhoneNumber;
    private boolean isTextFormating;
    private boolean showAreaCode;
    private final LinearLayout vAreaCodeContainer;
    private final TextView vAreaCodeText;
    private final ImageView vArrowIcon;

    /* JADX INFO: compiled from: OPhoneInputLayout.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public OPhoneInputLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OPhoneInputLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ OPhoneInputLayout(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public OPhoneInputLayout(Context r7, AttributeSet r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        super(r10, r11, r9);
        this.enableArrowIcon = true;
        setType(0);
        setCustomStart(ZeusTransformUtils.mapRes(R.layout.o_input_custom_start_area_code, "layout", "o_input_custom_start_area_code"));
        showCustomStart(true);
        setInputType(3);
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_area_code_container, DbHelper.COL_ID, "o_input_area_code_container"));
        o.c(r0, "findViewById(R.id.o_input_area_code_container)");
        this.vAreaCodeContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r0, LinearLayout.class, "com.obric.aiagent.plugin");
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_area_code_text, DbHelper.COL_ID, "o_input_area_code_text"));
        o.c(r1, "findViewById(R.id.o_input_area_code_text)");
        this.vAreaCodeText = (TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.aiagent.plugin");
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_area_code_arrow, DbHelper.COL_ID, "o_input_area_code_arrow"));
        o.c(r2, "findViewById(R.id.o_input_area_code_arrow)");
        this.vArrowIcon = (ImageView) ZeusTransformUtils.preCheckCast(r2, ImageView.class, "com.obric.aiagent.plugin");
        TypedArray r12 = r10.getTheme().obtainStyledAttributes(r11, R.styleable.OPhoneInputLayout, r9, 0);
        setAreaCode(r12.getString(ZeusTransformUtils.mapRes(R.styleable.OPhoneInputLayout_oinput_areaCode, "styleable", "OPhoneInputLayout_oinput_areaCode")));
        r12.recycle();
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setType(int r1) {
        if (r1 == 0) goto L4;
        return;
    L4:
        super.setType(r1);
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setCustomStart(int r3) {
        super.setCustomStart(ZeusTransformUtils.mapRes(R.layout.o_input_custom_start_area_code, "layout", "o_input_custom_start_area_code"));
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setDefaultCustomStart(int r3) {
        super.setCustomStart(ZeusTransformUtils.mapRes(R.layout.o_input_custom_start_area_code, "layout", "o_input_custom_start_area_code"));
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void showCustomStart(boolean r2) {
        if (this.showAreaCode != r2) goto L5;
        return;
    L5:
        this.showAreaCode = r2;
        super.showCustomStart(r2);
        doAfterTextStateChange(getVInput().getText());
    }

    @Override // com.obric.oui.forms.OInputLayout
    public CharSequence getText() {
        if (this.isChinesePhoneNumber == false) goto L14;
        Editable r7 = getVInput().getText();
        String r0 = null;
        if (r7 == null) goto L12;
        String r1 = r7.toString();
        if (r1 == null) goto L12;
        r0 = d.o.o.a(r1, " ", "", false, 4, null);
    L12:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
    L14:
        return super.getText();
    }

    public final void setAreaCode(String r5) {
        if (r5 == null) goto L10;
        String r0 = this.areaCode;
        if (r0 != null) goto L6;
    L8:
        this.areaCode = r5;
        this.vAreaCodeText.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"));
        doAfterTextStateChange(getVInput().getText());
        moveCursorToEnd();
        return;
    L6:
        if (d.o.o.a(r0, r5, false, 2, null) == false) goto L8;
        return;
    }

    public final String getAreaCode() {
        return this.areaCode;
    }

    public final void setAreaClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.vAreaCodeContainer.setOnClickListener(r4);
    }

    @Override // com.obric.oui.forms.OInputLayout
    public int getConstraintLength(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (this.isChinesePhoneNumber == false) goto L8;
    L11:
        int r2 = 0;
    L13:
        if (r0 >= r4.length()) goto L22;
        if (Character.isDigit(r4.charAt(r0)) == false) goto L17;
        r2 = r2 + 1;
    L17:
        r0 = r0 + 1;
        goto L13
    L22:
        return r2;
    L8:
        if (shouldApplyChinaMainlandConstraint() == true) goto L11;
        return r4.length();
    }

    private final boolean shouldApplyChinaMainlandConstraint() {
        if ((getInputType() & 15) == 3) goto L5;
    L13:
        return false;
    L5:
        if (this.showAreaCode == false) goto L13;
        String r2 = this.areaCode;
        if (r2 != null) goto L9;
        String r3 = null;
    L11:
        if (o.a(r3, CHINA_AREA_CODE) == false) goto L13;
        return true;
    L9:
        r3 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        goto L11
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void doAfterTextStateChange(Editable r3) {
        Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.aiagent.plugin");
        if (shouldApplyChinaMainlandConstraint() == false) goto L11;
        if (r4 != null) goto L6;
        r4 = getVInput().getText();
    L6:
        if (r4 == null) goto L9;
        formatChinesePhoneNumber(r4);
    L9:
        this.isChinesePhoneNumber = true;
        return;
    L11:
        if (this.isChinesePhoneNumber == false) goto L20;
        if (r4 != null) goto L14;
        r4 = getVInput().getText();
    L14:
        if (r4 == null) goto L17;
        resetFromChinesePhoneNumber(r4);
    L17:
        this.isChinesePhoneNumber = false;
        return;
    }

    private final void moveCursorToEnd() {
        Editable r0 = getVInput().getText();
        if (r0 != null) goto L5;
        int r1 = 0;
    L11:
        getVInput().setSelection(r1);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        b.d(OInputLayout.TAG, o.a("Failed to move cursor to end: ", e.getMessage()));
        return;
    L5:
        r1 = r0.length();
        goto L11
    }

    private final void formatChinesePhoneNumber(Editable r13) {
        Editable r14 = (Editable) ZeusTransformUtils.wrapperContextForParams(r13, Editable.class, "com.obric.aiagent.plugin");
        if (this.isTextFormating == false) goto L5;
        return;
    L5:
        String r0 = r14.toString();
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
        Appendable r3 = (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(), Appendable.class, "com.obric.aiagent.plugin");
        int r4 = r2.length();
        int r6 = 0;
    L6:
        if (r6 >= r4) goto L11;
        char r7 = r2.charAt(r6);
        if (Character.isDigit(r7) == false) goto L10;
        r3.append(r7);
    L10:
        r6 = r6 + 1;
        goto L6
    L11:
        String r5 = ((StringBuilder) ZeusTransformUtils.preCheckCast(r3, StringBuilder.class, "com.obric.aiagent.plugin")).toString();
        o.c(r5, "filterTo(StringBuilder(), predicate).toString()");
        StringBuilder r8 = new StringBuilder();
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        int r10 = 0;
        int r11 = 0;
    L13:
        if (r10 >= r9.length()) goto L22;
        int r12 = r11 + 1;
        r8.append(r9.charAt(r10));
        if (r11 == 2) goto L19;
        if (r11 == 6) goto L19;
    L21:
        r10 = r10 + 1;
        r11 = r12;
    L19:
        if (r11 == d.o.o.e((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) goto L21;
        r8.append(' ');
        goto L21
    L22:
        String r15 = r8.toString();
        o.c(r15, "StringBuilder().apply(builderAction).toString()");
        if (o.a(r15, r0) == false) goto L25;
        return;
    L25:
        this.isTextFormating = true;
        r14.replace(0, r14.length(), (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"));
        if (this.isChinesePhoneNumber == true) goto L48;
    L46:
        this.isTextFormating = false;
        return;
    L48:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(p.b(new Integer[]{3, 8}), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L44
    L29:
        if (r16.hasNext() == false) goto L46;
        int r17 = ((Number) ZeusTransformUtils.preCheckCast(r16.next(), Number.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Exception -> L44
        int r18 = r17 + 1;     // Catch: Exception -> L44
        if (r0.length() < r17) goto L29;
        if (r15.length() < r17) goto L29;
        if (r0.charAt(r17) == ' ') goto L29;
        if (r15.charAt(r17) != ' ') goto L29;
        if (getVInput().getSelectionStart() != r18) goto L29;
        if (getVInput().getSelectionEnd() != r18) goto L29;
        getVInput().setSelection(r18 + 1);     // Catch: Exception -> L44
    L44:
        e = move-exception;
        b.d(OInputLayout.TAG, o.a("Failed to move cursor when formating: ", e.getMessage()));
        goto L46
    }

    private final void resetFromChinesePhoneNumber(Editable r9) {
        Editable r10 = (Editable) ZeusTransformUtils.wrapperContextForParams(r9, Editable.class, "com.obric.aiagent.plugin");
        if (this.isTextFormating == false) goto L5;
        return;
    L5:
        String r0 = r10.toString();
        String r2 = d.o.o.a(r0, " ", "", false, 4, null);
        if (o.a(r2, r0) == false) goto L8;
        return;
    L8:
        this.isTextFormating = true;
        r10.replace(0, r10.length(), (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"));
        this.isTextFormating = false;
    }

    public final void setEnableArrowIcon(boolean r2) {
        if (this.enableArrowIcon != r2) goto L5;
        return;
    L5:
        this.enableArrowIcon = r2;
        ImageView r1 = this.vArrowIcon;
        if (r1 == null) goto L12;
        if (r2 == false) goto L9;
        float r3 = 1.0f;
    L10:
        r1.setAlpha(r3);
        return;
    L9:
        r3 = 0.3f;
        goto L10
    }

    public final boolean getEnableArrowIcon() {
        return this.enableArrowIcon;
    }
}
