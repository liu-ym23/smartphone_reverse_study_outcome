package com.obric.oui.status;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OPageStatus.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0001-B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0014\u001a\u00020\nJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0017\u001a\u00020\u000fJ\u0006\u0010\u0018\u001a\u00020\u000fJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0007J\u0010\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0007J\u0010\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0007J\u0010\u0010%\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0007J\u000e\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/oui/status/OPageStatus;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "button", "Lcom/obric/oui/button/OButton;", "contentContainer", "loadingContainer", "Landroid/widget/FrameLayout;", "loadingResult", "Lcom/obric/oui/text/OTextView;", "loadingView", "Lcom/obric/oui/progress/ODownloadProgressView;", "messageView", "titleView", "getButton", "getLoadingResultView", "getLoadingView", "getMessageView", "getTitleView", "initAttrs", "", "initViews", "setLoadingLayout", "resId", "setLoadingResult", "text", "", "setLoadingResultColor", "color", "setMessage", "setMessageColor", "setTitle", "setTitleColor", "setType", "type", "showButton", "show", "", "showLoading", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPageStatus extends LinearLayout {
    public static final Companion Companion = null;
    public static final int HORIZONTAL_LOADING = 2;
    public static final int STATUS_CONTENT = 0;
    public static final int VERTICAL_LOADING = 1;
    private OButton button;
    private LinearLayout contentContainer;
    private FrameLayout loadingContainer;
    private OTextView loadingResult;
    private ODownloadProgressView loadingView;
    private OTextView messageView;
    private OTextView titleView;

    /* JADX INFO: compiled from: OPageStatus.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/status/OPageStatus$Companion;", "", "()V", "HORIZONTAL_LOADING", "", "STATUS_CONTENT", "VERTICAL_LOADING", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OPageStatus(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OPageStatus(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OPageStatus(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OPageStatus(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        LayoutInflater.from(r3).inflate(R.layout.o_page_status_layout, this, true);
        setGravity(1);
        initViews();
        if (r4 == null) goto L6;
        initAttrs(r4);
        return;
    }

    private final void initViews() {
        View r0 = findViewById(R.id.content_container);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.content_container)");
        this.contentContainer = (LinearLayout) r0;
        View r1 = findViewById(R.id.status_title);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.status_title)");
        this.titleView = (OTextView) r1;
        View r2 = findViewById(R.id.status_message);
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.status_message)");
        this.messageView = (OTextView) r2;
        View r3 = findViewById(R.id.status_button);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.status_button)");
        this.button = (OButton) r3;
        View r4 = findViewById(R.id.loading_container);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.loading_container)");
        this.loadingContainer = (FrameLayout) r4;
    }

    private final void initAttrs(AttributeSet r4) {
        TypedArray r5 = getContext().getTheme().obtainStyledAttributes(r4, R.styleable.OPageStatus, 0, 0);
        if (r5.hasValue(R.styleable.OPageStatus_opagestatus_type) == false) goto L6;
        setType(r5.getInt(R.styleable.OPageStatus_opagestatus_type, 0));
    L6:
        if (r5.hasValue(R.styleable.OPageStatus_opagestatus_title) == false) goto L9;
        setTitle(r5.getString(R.styleable.OPageStatus_opagestatus_title));
    L9:
        if (r5.hasValue(R.styleable.OPageStatus_opagestatus_titleColor) == false) goto L12;
        setTitleColor(r5.getColor(R.styleable.OPageStatus_opagestatus_titleColor, R.color.oui_basic_text_3));
    L12:
        if (r5.hasValue(R.styleable.OPageStatus_opagestatus_message) == false) goto L15;
        setMessage(r5.getString(R.styleable.OPageStatus_opagestatus_message));
    L15:
        if (r5.hasValue(R.styleable.OPageStatus_opagestatus_messageColor) == false) goto L18;
        setMessageColor(r5.getColor(R.styleable.OPageStatus_opagestatus_messageColor, R.color.oui_basic_text_3b));
    L18:
        if (r5.hasValue(R.styleable.OPageStatus_opagestatus_showLoading) == false) goto L21;
        showLoading(r5.getBoolean(R.styleable.OPageStatus_opagestatus_showLoading, false));
    L21:
        if (r5.hasValue(R.styleable.OPageStatus_opagestatus_loadingResult) == false) goto L24;
        setLoadingResult(r5.getString(R.styleable.OPageStatus_opagestatus_loadingResult));
    L24:
        if (r5.hasValue(R.styleable.OPageStatus_opagestatus_loadingResultColor) == false) goto L26;
        setLoadingResultColor(r5.getColor(R.styleable.OPageStatus_opagestatus_loadingResult, R.color.oui_basic_text_3));
    L26:
        r5.recycle();
    }

    public final void setType(int r7) {
        FrameLayout r4 = null;
        if (r7 != 0) goto L5;
        LinearLayout r8 = this.contentContainer;
        if (r8 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r8 = null;
    L28:
        r8.setVisibility(0);
        FrameLayout r9 = this.loadingContainer;
        if (r9 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
        r9 = null;
    L31:
        r9.setVisibility(8);
        setLoadingLayout(0);
        this.loadingView = null;
        this.loadingResult = null;
        return;
    L5:
        if (r7 != 1) goto L7;
        LinearLayout r10 = this.contentContainer;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r10 = null;
    L20:
        r10.setVisibility(8);
        FrameLayout r11 = this.loadingContainer;
        if (r11 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
    L24:
        r4.setVisibility(0);
        setLoadingLayout(R.layout.o_page_status_vertical_loading_item);
        this.loadingView = (ODownloadProgressView) findViewById(R.id.status_loading);
        this.loadingResult = (OTextView) findViewById(R.id.status_loading_result);
        return;
    L23:
        r4 = r11;
        goto L24
    L7:
        if (r7 != 2) goto L35;
        LinearLayout r12 = this.contentContainer;
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r12 = null;
    L12:
        r12.setVisibility(8);
        FrameLayout r13 = this.loadingContainer;
        if (r13 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
    L16:
        r4.setVisibility(0);
        setLoadingLayout(R.layout.o_page_status_horizontal_loading_item);
        this.loadingView = (ODownloadProgressView) findViewById(R.id.status_loading);
        this.loadingResult = (OTextView) findViewById(R.id.status_loading_result);
        return;
    L15:
        r4 = r13;
        goto L16
    }

    public final void setLoadingLayout(int r4) {
        FrameLayout r0 = this.loadingContainer;
        FrameLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
        r0 = null;
    L5:
        r0.removeAllViews();
        if (r4 == 0) goto L16;
        Context r2 = getContext();     // Catch: Exception -> L13
        FrameLayout r3 = this.loadingContainer;     // Catch: Exception -> L13
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");     // Catch: Exception -> L13
    L11:
        LinearLayout.inflate(r2, r4, r1);     // Catch: Exception -> L13
        return;
    L10:
        r1 = r3;
    L17:
        return;
    }

    public final OTextView getTitleView() {
        OTextView r0 = this.titleView;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        return null;
    L6:
        return r0;
    }

    public final void setTitle(CharSequence r1) {
        OTextView r0 = this.titleView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r0 = null;
    L5:
        r0.setText(r1);
    }

    public final void setTitleColor(int r1) {
        OTextView r0 = this.titleView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r0 = null;
    L5:
        r0.setTextColor(r1);
    }

    public final OTextView getMessageView() {
        OTextView r0 = this.messageView;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
        return null;
    L6:
        return r0;
    }

    public final void setMessage(CharSequence r4) {
        OTextView r0 = this.messageView;
        OTextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
        r0 = null;
    L5:
        r0.setText(r4);
        OTextView r3 = this.messageView;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
    L9:
        int r5 = 0;
        if (r4 != null) goto L12;
    L15:
        boolean r6 = true;
    L16:
        if (r6 == false) goto L18;
        r5 = 8;
    L18:
        r1.setVisibility(r5);
        return;
    L12:
        if (r4.length() == 0) goto L15;
        r6 = false;
        goto L16
    L8:
        r1 = r3;
        goto L9
    }

    public final void setMessageColor(int r1) {
        OTextView r0 = this.messageView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
        r0 = null;
    L5:
        r0.setTextColor(r1);
    }

    public final void showButton(boolean r1) {
        OButton r0 = this.button;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("button");
        r0 = null;
    L5:
        if (r1 == false) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    public final OButton getButton() {
        OButton r0 = this.button;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("button");
        return null;
    L6:
        return r0;
    }

    public final ODownloadProgressView getLoadingView() {
        return this.loadingView;
    }

    public final OTextView getLoadingResultView() {
        return this.loadingResult;
    }

    public final void setLoadingResult(CharSequence r1) {
        OTextView r0 = this.loadingResult;
        if (r0 == null) goto L7;
        r0.setText(r1);
        return;
    }

    public final void setLoadingResultColor(int r1) {
        OTextView r0 = this.loadingResult;
        if (r0 == null) goto L7;
        r0.setTextColor(r1);
        return;
    }

    public final void showLoading(boolean r1) {
        ODownloadProgressView r0 = this.loadingView;
        if (r0 == null) goto L10;
        if (r1 == false) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }
}
