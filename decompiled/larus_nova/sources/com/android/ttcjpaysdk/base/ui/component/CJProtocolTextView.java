package com.android.ttcjpaysdk.base.ui.component;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.theme.CJPayThemeUtils;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002#$B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0014J,\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\fJ\u0012\u0010\u001a\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u001a\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/CJProtocolTextView;", "Lcom/android/ttcjpaysdk/base/ui/component/CJTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mColor", "mContext", "mListener", "Lcom/android/ttcjpaysdk/base/ui/component/CJProtocolTextView$ITextListener;", "mUnderLine", "", "stringBuilder", "Landroid/text/SpannableStringBuilder;", "applyStyles", "", "getTagName", "", "initProtocol", "textContent", "urlMap", "", "listener", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setText", "text", "", "type", "Landroid/widget/TextView$BufferType;", "setTextView", "ClickTextSpan", "ITextListener", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJProtocolTextView extends CJTextView {
    private int mColor;
    private final Context mContext;
    private ITextListener mListener;
    private boolean mUnderLine;
    private final SpannableStringBuilder stringBuilder;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/CJProtocolTextView$ClickTextSpan;", "Landroid/text/style/ClickableSpan;", "mUrl", "", "(Lcom/android/ttcjpaysdk/base/ui/component/CJProtocolTextView;Ljava/lang/String;)V", SendEventContainerMethodParamModel.EventKinds.onClick, "", "view", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ClickTextSpan extends ClickableSpan {
        private final String mUrl;
        final /* synthetic */ CJProtocolTextView this$0;

        @Override // android.text.style.ClickableSpan
        public void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            ITextListener r101 = CJProtocolTextView.access$getMListener$p(this.this$0);
            if (r101 == null) goto L6;
            r101.onClickText(this.mUrl);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
            super.updateDrawState(r100);
            r100.setColor(CJProtocolTextView.access$getMContext$p(this.this$0).getResources().getColor(CJProtocolTextView.access$getMColor$p(this.this$0)));
            r100.setUnderlineText(CJProtocolTextView.access$getMUnderLine$p(this.this$0));
        }

        public ClickTextSpan(CJProtocolTextView r100, String r101) {
            this.this$0 = r100;
            this.mUrl = r101;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/CJProtocolTextView$ITextListener;", "", "onClickText", "", "url", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ITextListener {
        void onClickText(String r100);
    }

    public CJProtocolTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public CJProtocolTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    private final void setTextView() {
        setHighlightColor(0);
        setLineSpacing(getTextSize() / 2, 1.0f);
        applyStyles(getContext());
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // com.android.ttcjpaysdk.base.ui.component.CJTextView
    public String getTagName() {
        return "CJProtocol";
    }

    public static final /* synthetic */ int access$getMColor$p(CJProtocolTextView r100) {
        return r100.mColor;
    }

    public static final /* synthetic */ Context access$getMContext$p(CJProtocolTextView r100) {
        return r100.mContext;
    }

    public static final /* synthetic */ ITextListener access$getMListener$p(CJProtocolTextView r100) {
        return r100.mListener;
    }

    public static final /* synthetic */ boolean access$getMUnderLine$p(CJProtocolTextView r100) {
        return r100.mUnderLine;
    }

    private final void applyStyles(Context r100) {
        setTextColor(CJPayThemeUtils.getColor(r100, R.attr.cj_std_ui_component_textview_color));
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        applyStyles(getContext());
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r100, TextView.BufferType r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        super.setText(r100, r101);
        setTextView();
    }

    public CJProtocolTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.stringBuilder = new SpannableStringBuilder();
        if (r101 == null) goto L10;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.textSize});
        setTextSize(2, r103.getDimension(0, 14.0f));     // Catch: Throwable -> L7
        r103.recycle();
    L11:
        this.mContext = r100;
        this.mUnderLine = false;
        this.mColor = R.color.cj_pay_color_blue_04498D;
        return;
    L7:
        th = move-exception;
        r103.recycle();
        throw th;
    L10:
        setTextSize(14.0f);
        goto L11
    }

    public final void initProtocol(String r100, Map<String, String> r110, ITextListener r111) {
        Intrinsics.checkNotNullParameter(r100, "textContent");
        Intrinsics.checkNotNullParameter(r110, "urlMap");
        this.stringBuilder.append(r100);
        setText(this.stringBuilder);
        Iterator<Map.Entry<String, String>> r112 = r110.entrySet().iterator();
    L4:
        if (r112.hasNext() == false) goto L6;
        Map.Entry<String, String> r101 = r112.next();
        String r102 = r101.getKey();
        String r103 = r101.getValue();
        int r104 = StringsKt.indexOf$default(r100, r102, 0, false, 6, null);
        int r105 = r102.length() + r104;
        ClickTextSpan r106 = new ClickTextSpan(this, r103);
        this.stringBuilder.setSpan(r106, r104, r105, 34);
        goto L4
    L6:
        this.mListener = r111;
    }

    public /* synthetic */ CJProtocolTextView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
