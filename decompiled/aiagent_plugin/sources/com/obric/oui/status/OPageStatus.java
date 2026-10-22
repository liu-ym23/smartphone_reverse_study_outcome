package com.obric.oui.status;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OPageStatus.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OPageStatus extends LinearLayout {
    public static final a Companion = null;
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

    public OPageStatus(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OPageStatus(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ OPageStatus(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public OPageStatus(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8, r6);
        ZeusTransformUtils.inflate(LayoutInflater.from(r7), ZeusTransformUtils.mapRes(R.layout.o_page_status_layout, "layout", "o_page_status_layout"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        setGravity(1);
        initViews();
        if (r8 == null) goto L6;
        initAttrs(r8);
        return;
    }

    private final void initViews() {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.content_container, DbHelper.COL_ID, "content_container"));
        o.c(r0, "findViewById(R.id.content_container)");
        this.contentContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r0, LinearLayout.class, "com.obric.aiagent.plugin");
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.status_title, DbHelper.COL_ID, "status_title"));
        o.c(r1, "findViewById(R.id.status_title)");
        this.titleView = (OTextView) ZeusTransformUtils.preCheckCast(r1, OTextView.class, "com.obric.aiagent.plugin");
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.status_message, DbHelper.COL_ID, "status_message"));
        o.c(r2, "findViewById(R.id.status_message)");
        this.messageView = (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.aiagent.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.status_button, DbHelper.COL_ID, "status_button"));
        o.c(r3, "findViewById(R.id.status_button)");
        this.button = (OButton) ZeusTransformUtils.preCheckCast(r3, OButton.class, "com.obric.aiagent.plugin");
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.loading_container, DbHelper.COL_ID, "loading_container"));
        o.c(r4, "findViewById(R.id.loading_container)");
        this.loadingContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r4, FrameLayout.class, "com.obric.aiagent.plugin");
    }

    private final void initAttrs(AttributeSet r9) {
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.aiagent.plugin");
        TypedArray r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme().obtainStyledAttributes(r10, R.styleable.OPageStatus, 0, 0);
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_type, "styleable", "OPageStatus_opagestatus_type")) == false) goto L6;
        setType(r11.getInt(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_type, "styleable", "OPageStatus_opagestatus_type"), 0));
    L6:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_title, "styleable", "OPageStatus_opagestatus_title")) == false) goto L9;
        setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r11.getString(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_title, "styleable", "OPageStatus_opagestatus_title")), CharSequence.class, "com.obric.aiagent.plugin"));
    L9:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_titleColor, "styleable", "OPageStatus_opagestatus_titleColor")) == false) goto L12;
        setTitleColor(r11.getColor(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_titleColor, "styleable", "OPageStatus_opagestatus_titleColor"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3")));
    L12:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_message, "styleable", "OPageStatus_opagestatus_message")) == false) goto L15;
        setMessage((CharSequence) ZeusTransformUtils.preCheckCast(r11.getString(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_message, "styleable", "OPageStatus_opagestatus_message")), CharSequence.class, "com.obric.aiagent.plugin"));
    L15:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_messageColor, "styleable", "OPageStatus_opagestatus_messageColor")) == false) goto L18;
        setMessageColor(r11.getColor(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_messageColor, "styleable", "OPageStatus_opagestatus_messageColor"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3b, "color", "oui_basic_text_3b")));
    L18:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_showLoading, "styleable", "OPageStatus_opagestatus_showLoading")) == false) goto L21;
        showLoading(r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_showLoading, "styleable", "OPageStatus_opagestatus_showLoading"), false));
    L21:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_loadingResult, "styleable", "OPageStatus_opagestatus_loadingResult")) == false) goto L24;
        setLoadingResult((CharSequence) ZeusTransformUtils.preCheckCast(r11.getString(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_loadingResult, "styleable", "OPageStatus_opagestatus_loadingResult")), CharSequence.class, "com.obric.aiagent.plugin"));
    L24:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_loadingResultColor, "styleable", "OPageStatus_opagestatus_loadingResultColor")) == false) goto L26;
        setLoadingResultColor(r11.getColor(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_loadingResult, "styleable", "OPageStatus_opagestatus_loadingResult"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3")));
    L26:
        r11.recycle();
    }

    public final void setType(int r12) {
        FrameLayout r4 = null;
        if (r12 != 0) goto L5;
        LinearLayout r13 = this.contentContainer;
        if (r13 != null) goto L28;
        o.c("contentContainer");
        r13 = null;
    L28:
        r13.setVisibility(0);
        FrameLayout r14 = this.loadingContainer;
        if (r14 != null) goto L31;
        o.c("loadingContainer");
        r14 = null;
    L31:
        r14.setVisibility(8);
        setLoadingLayout(0);
        this.loadingView = null;
        this.loadingResult = null;
        return;
    L5:
        if (r12 != 1) goto L7;
        LinearLayout r15 = this.contentContainer;
        if (r15 != null) goto L20;
        o.c("contentContainer");
        r15 = null;
    L20:
        r15.setVisibility(8);
        FrameLayout r16 = this.loadingContainer;
        if (r16 != null) goto L23;
        o.c("loadingContainer");
    L24:
        r4.setVisibility(0);
        setLoadingLayout(ZeusTransformUtils.mapRes(R.layout.o_page_status_vertical_loading_item, "layout", "o_page_status_vertical_loading_item"));
        this.loadingView = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.status_loading, DbHelper.COL_ID, "status_loading")), ODownloadProgressView.class, "com.obric.aiagent.plugin");
        this.loadingResult = (OTextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.status_loading_result, DbHelper.COL_ID, "status_loading_result")), OTextView.class, "com.obric.aiagent.plugin");
        return;
    L23:
        r4 = r16;
        goto L24
    L7:
        if (r12 != 2) goto L35;
        LinearLayout r17 = this.contentContainer;
        if (r17 != null) goto L12;
        o.c("contentContainer");
        r17 = null;
    L12:
        r17.setVisibility(8);
        FrameLayout r18 = this.loadingContainer;
        if (r18 != null) goto L15;
        o.c("loadingContainer");
    L16:
        r4.setVisibility(0);
        setLoadingLayout(ZeusTransformUtils.mapRes(R.layout.o_page_status_horizontal_loading_item, "layout", "o_page_status_horizontal_loading_item"));
        this.loadingView = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.status_loading, DbHelper.COL_ID, "status_loading")), ODownloadProgressView.class, "com.obric.aiagent.plugin");
        this.loadingResult = (OTextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.status_loading_result, DbHelper.COL_ID, "status_loading_result")), OTextView.class, "com.obric.aiagent.plugin");
        return;
    L15:
        r4 = r18;
        goto L16
    }

    public final void setLoadingLayout(int r6) {
        FrameLayout r1 = this.loadingContainer;
        FrameLayout r2 = null;
        if (r1 != null) goto L5;
        o.c("loadingContainer");
        r1 = null;
    L5:
        r1.removeAllViews();
        if (r6 == 0) goto L16;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L13
        FrameLayout r5 = this.loadingContainer;     // Catch: Exception -> L13
        if (r5 != null) goto L10;
        o.c("loadingContainer");     // Catch: Exception -> L13
    L11:
        LinearLayout.inflate(r3, r6, (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L13
        return;
    L10:
        r2 = r5;
    L17:
        return;
    }

    public final OTextView getTitleView() {
        OTextView r0 = this.titleView;
        if (r0 != null) goto L6;
        o.c("titleView");
        return null;
    L6:
        return r0;
    }

    public final void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        OTextView r2 = this.titleView;
        if (r2 != null) goto L5;
        o.c("titleView");
        r2 = null;
    L5:
        r2.setText(r4);
    }

    public final void setTitleColor(int r1) {
        OTextView r0 = this.titleView;
        if (r0 != null) goto L5;
        o.c("titleView");
        r0 = null;
    L5:
        r0.setTextColor(r1);
    }

    public final OTextView getMessageView() {
        OTextView r0 = this.messageView;
        if (r0 != null) goto L6;
        o.c("messageView");
        return null;
    L6:
        return r0;
    }

    public final void setMessage(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        OTextView r0 = this.messageView;
        OTextView r1 = null;
        if (r0 != null) goto L5;
        o.c("messageView");
        r0 = null;
    L5:
        r0.setText(r5);
        OTextView r3 = this.messageView;
        if (r3 != null) goto L8;
        o.c("messageView");
    L9:
        int r6 = 0;
        if (r5 != null) goto L12;
    L15:
        boolean r7 = true;
    L16:
        if (r7 == false) goto L18;
        r6 = 8;
    L18:
        r1.setVisibility(r6);
        return;
    L12:
        if (r5.length() == 0) goto L15;
        r7 = false;
        goto L16
    L8:
        r1 = r3;
        goto L9
    }

    public final void setMessageColor(int r1) {
        OTextView r0 = this.messageView;
        if (r0 != null) goto L5;
        o.c("messageView");
        r0 = null;
    L5:
        r0.setTextColor(r1);
    }

    public final void showButton(boolean r1) {
        OButton r0 = this.button;
        if (r0 != null) goto L5;
        o.c("button");
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
        o.c("button");
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

    public final void setLoadingResult(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        OTextView r2 = this.loadingResult;
        if (r2 == null) goto L7;
        r2.setText(r4);
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
