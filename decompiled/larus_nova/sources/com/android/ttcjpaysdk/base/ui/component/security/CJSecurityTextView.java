package com.android.ttcjpaysdk.base.ui.component.security;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.imageloader.ImageLoader;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000eJ\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/security/CJSecurityTextView;", "Landroid/widget/LinearLayout;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getAttrs", "()Landroid/util/AttributeSet;", "buttonAboveTipsIcon", "Landroid/widget/ImageView;", "buttonAboveTipsText", "Landroid/widget/TextView;", "iconUrl", "", "getMContext", "()Landroid/content/Context;", "tipsText", "getTipsText", "initView", "", "setIconUrl", "url", "setTipsText", "charSequence", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJSecurityTextView extends LinearLayout {
    private final AttributeSet attrs;
    private ImageView buttonAboveTipsIcon;
    private TextView buttonAboveTipsText;
    private String iconUrl;
    private final Context mContext;
    private String tipsText;

    private final void initView() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.cj_pay_component_security_layout, this, true);
        this.buttonAboveTipsText = (TextView) r100.findViewById(R.id.cj_pay_bottom_tips_text);
        this.buttonAboveTipsIcon = (ImageView) r100.findViewById(R.id.cj_pay_bottom_tips_icon);
    }

    public final AttributeSet getAttrs() {
        return this.attrs;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final String getTipsText() {
        return this.tipsText;
    }

    public static final /* synthetic */ ImageView access$getButtonAboveTipsIcon$p(CJSecurityTextView r100) {
        return r100.buttonAboveTipsIcon;
    }

    public final void setIconUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.iconUrl = r100;
        StringsKt.isBlank(r100);
        ImageView r101 = this.buttonAboveTipsIcon;
        if (r101 == null) goto L6;
        r101.setVisibility(0);
    L6:
        ImageLoader.Companion.getInstance().loadImage(r100, new CJSecurityTextView$setIconUrl$1$1(this));
    }

    public final void setTipsText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "charSequence");
        this.tipsText = r100.toString();
        TextView r101 = this.buttonAboveTipsText;
        if (r101 == null) goto L6;
        r101.setText(r100);
    L6:
        TextView r102 = this.buttonAboveTipsText;
        if (r102 == null) goto L11;
        r102.setVisibility(0);
        return;
    }

    public CJSecurityTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101);
        this.mContext = r100;
        this.attrs = r101;
        initView();
    }

    public /* synthetic */ CJSecurityTextView(Context r100, AttributeSet r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
