package com.android.ttcjpaysdk.bindcard.base.ui.wrapper;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCircleCheckBox;
import com.android.ttcjpaysdk.base.ui.data.CJPayProtocolGroupBean;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayDebouncingClickableSpan;
import com.android.ttcjpaysdk.base.utils.CJPayExtentSizeUtils;
import com.android.ttcjpaysdk.thirdparty.utils.CJPayStyleUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0002#$B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J(\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\n2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0016J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u000eJ\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J&\u0010!\u001a\u00020\u00132\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/ui/wrapper/CJPayBindCardAgreementWrapper;", "", "textView", "Landroid/widget/TextView;", "checkBox", "Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCircleCheckBox;", "protocolGroupBeans", "", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayProtocolGroupBean;", "guideText", "", "(Landroid/widget/TextView;Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCircleCheckBox;Ljava/util/List;Ljava/lang/String;)V", "agreementTextView", "btnAction", "Lcom/android/ttcjpaysdk/bindcard/base/ui/wrapper/CJPayBindCardAgreementWrapper$OnActionListener;", "checkbox", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bindView", "", "doubleCheckVisibility", "getCheckBoxStatus", "", "initAgreementContent", "customText", "protocolGrouplist", "mNeedCheckBox", "initCheckBox", "setCheckBoxStatus", "isChecked", "setOnActionListener", "checkListener", "setOnTouchListener", "updateViewData", "needCheckBox", "OnActionListener", "TextClick", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayBindCardAgreementWrapper {
    private TextView agreementTextView;
    private OnActionListener btnAction;
    private CJPayCircleCheckBox checkbox;
    private Context context;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/ui/wrapper/CJPayBindCardAgreementWrapper$OnActionListener;", "", "onAgreementClick", "", "bean", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayProtocolGroupBean;", "onCheckStatusChanged", "isChecked", "", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnActionListener {
        void onAgreementClick(CJPayProtocolGroupBean r100);

        void onCheckStatusChanged(boolean r100);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/ui/wrapper/CJPayBindCardAgreementWrapper$TextClick;", "Lcom/android/ttcjpaysdk/base/utils/CJPayDebouncingClickableSpan;", "protocolGroupBean", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayProtocolGroupBean;", "(Lcom/android/ttcjpaysdk/bindcard/base/ui/wrapper/CJPayBindCardAgreementWrapper;Lcom/android/ttcjpaysdk/base/ui/data/CJPayProtocolGroupBean;)V", "getProtocolGroupBean", "()Lcom/android/ttcjpaysdk/base/ui/data/CJPayProtocolGroupBean;", "doClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class TextClick extends CJPayDebouncingClickableSpan {
        private final CJPayProtocolGroupBean protocolGroupBean;
        final /* synthetic */ CJPayBindCardAgreementWrapper this$0;

        public final CJPayProtocolGroupBean getProtocolGroupBean() {
            return this.protocolGroupBean;
        }

        @Override // com.android.ttcjpaysdk.base.utils.CJPayDebouncingClickableSpan
        public void doClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            if ((r100 instanceof TextView) == false) goto L5;
            View r101 = r100;
        L6:
            if (r101 == null) goto L8;
            ((TextView) r101).setHighlightColor(r100.getContext().getResources().getColor(R.color.transparent));
        L8:
            OnActionListener r102 = CJPayBindCardAgreementWrapper.access$getBtnAction$p(this.this$0);
            if (r102 == null) goto L12;
            r102.onAgreementClick(this.protocolGroupBean);
            return;
        L12:
            return;
        L5:
            r101 = null;
            goto L6
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
            r100.setColor(CJPayStyleUtils.getAgreementColorFromSettings(CJPayBindCardAgreementWrapper.access$getContext$p(this.this$0)));
            r100.setUnderlineText(false);
        }

        public TextClick(CJPayBindCardAgreementWrapper r100, CJPayProtocolGroupBean r101) {
            Intrinsics.checkNotNullParameter(r101, "protocolGroupBean");
            this.this$0 = r100;
            this.protocolGroupBean = r101;
        }
    }

    private final void doubleCheckVisibility() {
        TextView r100 = this.agreementTextView;
        if (r100 == null) goto L10;
        boolean r101 = false;
        if (r100 != null) goto L7;
    L9:
        if (r101 == true) goto L10;
        return;
    L7:
        if (r100.getVisibility() != 8) goto L9;
        r101 = true;
    L10:
        CJPayCircleCheckBox r102 = this.checkbox;
        if (r102 == null) goto L16;
        r102.setVisibility(8);
        return;
    }

    public final boolean getCheckBoxStatus() {
        CJPayCircleCheckBox r100 = this.checkbox;
        if (r100 != null) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L22;
        CJPayCircleCheckBox r102 = this.checkbox;
        if (r102 == null) goto L16;
        CheckBox r103 = r102.getCheckBox();
        if (r103 == null) goto L16;
        boolean r104 = r103.isChecked();
    L17:
        if (r104 == true) goto L23;
        return false;
    L23:
        return true;
    L16:
        r104 = false;
        goto L17
    L22:
        return true;
    L7:
        if (r100.getVisibility() != 8) goto L9;
        r101 = true;
        goto L10
    }

    public static final /* synthetic */ OnActionListener access$getBtnAction$p(CJPayBindCardAgreementWrapper r100) {
        return r100.btnAction;
    }

    public static final /* synthetic */ Context access$getContext$p(CJPayBindCardAgreementWrapper r100) {
        return r100.context;
    }

    private final void initCheckBox(boolean r100) {
        CJPayCircleCheckBox r101 = this.checkbox;
        if (r101 == null) goto L9;
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        goto L9
    L7:
        r102 = 8;
    L9:
        final CJPayCircleCheckBox r103 = this.checkbox;
        if (r103 != null) goto L12;
        return;
    L12:
        if (r103.getVisibility() != 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == true) goto L18;
        r103 = null;
    L18:
        if (r103 == null) goto L22;
        r103.setVisibility(0);
        r103.setIESNewStyle(true);
        r103.setWithCircleWhenUnchecked(true);
        r103.setChecked(false);
        r103.setOnClickListener(new CJPayBindCardAgreementWrapper$initCheckBox$2$1(r103, this));
        CJPayExtentSizeUtils.expendTouchArea(r103, new int[]{CJPayBasicUtils.dipToPX(this.context, 9.0f), CJPayBasicUtils.dipToPX(this.context, 8.0f), CJPayBasicUtils.dipToPX(this.context, 9.0f), CJPayBasicUtils.dipToPX(this.context, 8.0f)});
        return;
    L22:
        return;
    L14:
        r104 = false;
        goto L15
    }

    private final void setOnTouchListener(TextView r100) {
        r100.setOnTouchListener(new AnonymousClass1());
    }

    public final void setCheckBoxStatus(boolean r100) {
        CJPayCircleCheckBox r101 = this.checkbox;
        if (r101 == null) goto L6;
        r101.setChecked(r100);
        return;
    }

    public final void setOnActionListener(OnActionListener r100) {
        Intrinsics.checkNotNullParameter(r100, "checkListener");
        this.btnAction = r100;
    }

    private final void bindView(CJPayCircleCheckBox r100, TextView r101) {
        this.checkbox = r100;
        this.agreementTextView = r101;
    }

    private final void initAgreementContent(String r100, List<? extends CJPayProtocolGroupBean> r101, boolean r110) {
        TextView r102 = this.agreementTextView;
        if (r102 == null) goto L14;
        if (r101 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == false) goto L12;
        int r104 = 0;
    L13:
        r102.setVisibility(r104);
        goto L14
    L12:
        r104 = 8;
        goto L13
    L7:
        if ((!r101.isEmpty()) != true) goto L9;
        r103 = true;
    L14:
        TextView r105 = this.agreementTextView;
        if (r105 != null) goto L17;
        return;
    L17:
        if (r105.getVisibility() == 0) goto L19;
    L21:
        boolean r106 = false;
    L22:
        Integer r107 = null;
        if (r106 == true) goto L26;
        r105 = null;
    L26:
        if (r105 == null) goto L69;
        StringBuilder r108 = new StringBuilder();
        String r109 = "";
        if ((!StringsKt.isBlank(r100)) == true) goto L41;
        if (r110 == false) goto L36;
        Context r111 = this.context;
        if (r111 == null) goto L35;
        r100 = r111.getString(com.larus.nova.R.string.cj_pay_add_new_bank_card_agreement_base_str);
        if (r100 != null) goto L41;
    L35:
        r100 = "";
        goto L41
    L36:
        Context r112 = this.context;
        if (r112 == null) goto L35;
        r100 = r112.getString(com.larus.nova.R.string.cj_pay_pay_read_protocol);
        if (r100 == null) goto L35;
    L41:
        r108.append(r100);
        r108.append(' ');
        SpannableStringBuilder r113 = new SpannableStringBuilder(r108.toString());
        Context r114 = this.context;
        if (r114 == null) goto L46;
        Resources r115 = r114.getResources();
        if (r115 == null) goto L46;
        r107 = Integer.valueOf(r115.getColor(R.color.transparent));
    L46:
        Intrinsics.checkNotNull(r107);
        r105.setHighlightColor(r107.intValue());
        StringBuilder r116 = new StringBuilder();
        if (r101 == null) goto L53;
        Iterator<T> r117 = r101.iterator();
    L50:
        if (r117.hasNext() == false) goto L53;
        r116.append(((CJPayProtocolGroupBean) r117.next()).groupDesc);
        r116.append("、");
    L53:
        if (r116.length() <= 0) goto L55;
        boolean r118 = true;
    L56:
        if (r118 == false) goto L58;
        r109 = r116.substring(0, r116.length() - 1);
    L58:
        int r119 = r113.length();
        r113.append(r109);
        if (r101 == null) goto L64;
        Iterator<T> r120 = r101.iterator();
    L62:
        if (r120.hasNext() == false) goto L64;
        CJPayProtocolGroupBean r121 = (CJPayProtocolGroupBean) r120.next();
        TextClick r122 = new TextClick(this, r121);
        setOnTouchListener(r105);
        r113.setSpan(r122, r119, r121.groupDesc.length() + r119, 17);
        r119 = r119 + (r121.groupDesc.length() + 1);
    L64:
        r105.setText(r113);
        r105.setPadding(0, 0, 0, 0);
        return;
    L55:
        r118 = false;
        goto L56
    L69:
        return;
    L19:
        if (this.context == null) goto L21;
        r106 = true;
        goto L22
    }

    public final void updateViewData(List<? extends CJPayProtocolGroupBean> r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "customText");
        initCheckBox(r102);
        initAgreementContent(r101, r100, r102);
        doubleCheckVisibility();
    }

    public CJPayBindCardAgreementWrapper(TextView r100, CJPayCircleCheckBox r101, List<? extends CJPayProtocolGroupBean> r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Intrinsics.checkNotNullParameter(r103, "guideText");
        this.context = r100.getContext();
        bindView(r101, r100);
        if (r101 == null) goto L5;
        boolean r104 = true;
    L6:
        updateViewData(r102, r103, r104);
        return;
    L5:
        r104 = false;
        goto L6
    }

    public /* synthetic */ CJPayBindCardAgreementWrapper(TextView r100, CJPayCircleCheckBox r101, List r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = "";
    L8:
        this(r100, r101, r102, r103);
    }
}
