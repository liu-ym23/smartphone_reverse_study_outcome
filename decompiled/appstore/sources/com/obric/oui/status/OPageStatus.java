package com.obric.oui.status;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OButton;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 >2\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\rJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\rJ\r\u0010\u0019\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u0012J\u0017\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u001a\u0010\u0016J\u0015\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\rJ\u0015\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010!\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b&\u0010\u0012J\u0017\u0010'\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b'\u0010\u0016J\u0015\u0010(\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b(\u0010\rJ\u0015\u0010)\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b)\u0010\u001fJ\u000f\u0010*\u001a\u00020\u000bH\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020\u00018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010.R\u0016\u00101\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u00100R\u0016\u00102\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u00100R\u0016\u00104\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00100¨\u0006?"}, d2 = {"Lcom/obric/oui/status/OPageStatus;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "type", "", "setType", "(I)V", "resId", "setLoadingLayout", "Lcom/obric/oui/text/OTextView;", "getTitleView", "()Lcom/obric/oui/text/OTextView;", "", "text", "setTitle", "(Ljava/lang/CharSequence;)V", "color", "setTitleColor", "getMessageView", "setMessage", "setMessageColor", "", "show", "c", "(Z)V", "Lcom/obric/oui/button/OButton;", "getButton", "()Lcom/obric/oui/button/OButton;", "Lcom/obric/oui/progress/ODownloadProgressView;", "getLoadingView", "()Lcom/obric/oui/progress/ODownloadProgressView;", "getLoadingResultView", "setLoadingResult", "setLoadingResultColor", "d", "b", "()V", "a", "(Landroid/util/AttributeSet;)V", "Landroid/widget/LinearLayout;", "contentContainer", "Lcom/obric/oui/text/OTextView;", "titleView", "messageView", "Lcom/obric/oui/button/OButton;", "button", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "loadingContainer", "f", "Lcom/obric/oui/progress/ODownloadProgressView;", "loadingView", "g", "loadingResult", "h", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPageStatus extends LinearLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f16999h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f17000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OTextView f17001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OTextView f17002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OButton f17003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f17004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ODownloadProgressView f17005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OTextView f17006g;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f16999h = new a(null);
    }

    @JvmOverloads
    public OPageStatus(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public final void a(AttributeSet r10) {
        TypedArray r11 = getContext().getTheme().obtainStyledAttributes(r10, R$styleable.OPageStatus, 0, 0);
        int r12 = R$styleable.OPageStatus_opagestatus_type;
        if (r11.hasValue(r12) == false) goto L5;
        setType(r11.getInt(r12, 0));
    L5:
        int r13 = R$styleable.OPageStatus_opagestatus_title;
        if (r11.hasValue(r13) == false) goto L8;
        setTitle(r11.getString(r13));
    L8:
        int r14 = R$styleable.OPageStatus_opagestatus_titleColor;
        if (r11.hasValue(r14) == false) goto L11;
        setTitleColor(r11.getColor(r14, R$color.oui_basic_text_3));
    L11:
        int r15 = R$styleable.OPageStatus_opagestatus_message;
        if (r11.hasValue(r15) == false) goto L14;
        setMessage(r11.getString(r15));
    L14:
        int r16 = R$styleable.OPageStatus_opagestatus_messageColor;
        if (r11.hasValue(r16) == false) goto L17;
        setMessageColor(r11.getColor(r16, R$color.oui_basic_text_3b));
    L17:
        int r17 = R$styleable.OPageStatus_opagestatus_showLoading;
        if (r11.hasValue(r17) == false) goto L20;
        d(r11.getBoolean(r17, false));
    L20:
        int r18 = R$styleable.OPageStatus_opagestatus_loadingResult;
        if (r11.hasValue(r18) == false) goto L24;
        setLoadingResult(r11.getString(r18));
    L24:
        if (r11.hasValue(R$styleable.OPageStatus_opagestatus_loadingResultColor) == false) goto L26;
        setLoadingResultColor(r11.getColor(r18, R$color.oui_basic_text_3));
    L26:
        r11.recycle();
    }

    public final void b() {
        View r10 = findViewById(R$id.content_container);
        q.f(r10, "findViewById(R.id.content_container)");
        this.f17000a = (LinearLayout) r10;
        View r11 = findViewById(R$id.status_title);
        q.f(r11, "findViewById(R.id.status_title)");
        this.f17001b = (OTextView) r11;
        View r12 = findViewById(R$id.status_message);
        q.f(r12, "findViewById(R.id.status_message)");
        this.f17002c = (OTextView) r12;
        View r13 = findViewById(R$id.status_button);
        q.f(r13, "findViewById(R.id.status_button)");
        this.f17003d = (OButton) r13;
        View r14 = findViewById(R$id.loading_container);
        q.f(r14, "findViewById(R.id.loading_container)");
        this.f17004e = (FrameLayout) r14;
    }

    public final void c(boolean r10) {
        OButton r11 = this.f17003d;
        if (r11 != null) goto L5;
        q.y("button");
        r11 = null;
    L5:
        if (r10 == false) goto L7;
        int r12 = 0;
    L8:
        r11.setVisibility(r12);
        return;
    L7:
        r12 = 8;
        goto L8
    }

    public final void d(boolean r10) {
        ODownloadProgressView r11 = this.f17005f;
        if (r11 == null) goto L10;
        if (r10 == false) goto L7;
        int r12 = 0;
    L8:
        r11.setVisibility(r12);
        return;
    L7:
        r12 = 8;
        goto L8
    }

    @NotNull
    public final OButton getButton() {
        OButton r10 = this.f17003d;
        if (r10 != null) goto L6;
        q.y("button");
        return null;
    L6:
        return r10;
    }

    @Nullable
    public final OTextView getLoadingResultView() {
        return this.f17006g;
    }

    @Nullable
    public final ODownloadProgressView getLoadingView() {
        return this.f17005f;
    }

    @NotNull
    public final OTextView getMessageView() {
        OTextView r10 = this.f17002c;
        if (r10 != null) goto L6;
        q.y("messageView");
        return null;
    L6:
        return r10;
    }

    @NotNull
    public final OTextView getTitleView() {
        OTextView r10 = this.f17001b;
        if (r10 != null) goto L6;
        q.y("titleView");
        return null;
    L6:
        return r10;
    }

    public final void setLoadingLayout(int r10) {
        FrameLayout r11 = this.f17004e;
        FrameLayout r12 = null;
        if (r11 != null) goto L5;
        q.y("loadingContainer");
        r11 = null;
    L5:
        r11.removeAllViews();
        if (r10 == 0) goto L16;
        Context r13 = getContext();     // Catch: Exception -> L13
        FrameLayout r14 = this.f17004e;     // Catch: Exception -> L13
        if (r14 != null) goto L10;
        q.y("loadingContainer");     // Catch: Exception -> L13
    L11:
        LinearLayout.inflate(r13, r10, r12);     // Catch: Exception -> L13
        return;
    L10:
        r12 = r14;
    L17:
        return;
    }

    public final void setLoadingResult(@Nullable CharSequence r10) {
        OTextView r11 = this.f17006g;
        if (r11 == null) goto L7;
        r11.setText(r10);
        return;
    }

    public final void setLoadingResultColor(int r10) {
        OTextView r11 = this.f17006g;
        if (r11 == null) goto L7;
        r11.setTextColor(r10);
        return;
    }

    public final void setMessage(@Nullable CharSequence r10) {
        OTextView r11 = this.f17002c;
        OTextView r12 = null;
        if (r11 != null) goto L5;
        q.y("messageView");
        r11 = null;
    L5:
        r11.setText(r10);
        OTextView r13 = this.f17002c;
        if (r13 != null) goto L8;
        q.y("messageView");
    L9:
        if (r10 != null) goto L11;
    L14:
        int r14 = 8;
    L15:
        r12.setVisibility(r14);
        return;
    L11:
        if (r10.length() == 0) goto L14;
        r14 = 0;
        goto L15
    L8:
        r12 = r13;
        goto L9
    }

    public final void setMessageColor(int r10) {
        OTextView r11 = this.f17002c;
        if (r11 != null) goto L5;
        q.y("messageView");
        r11 = null;
    L5:
        r11.setTextColor(r10);
    }

    public final void setTitle(@Nullable CharSequence r10) {
        OTextView r11 = this.f17001b;
        if (r11 != null) goto L5;
        q.y("titleView");
        r11 = null;
    L5:
        r11.setText(r10);
    }

    public final void setTitleColor(int r10) {
        OTextView r11 = this.f17001b;
        if (r11 != null) goto L5;
        q.y("titleView");
        r11 = null;
    L5:
        r11.setTextColor(r10);
    }

    public final void setType(int r10) {
        FrameLayout r11 = null;
        if (r10 != 0) goto L5;
        LinearLayout r12 = this.f17000a;
        if (r12 != null) goto L28;
        q.y("contentContainer");
        r12 = null;
    L28:
        r12.setVisibility(0);
        FrameLayout r13 = this.f17004e;
        if (r13 != null) goto L31;
        q.y("loadingContainer");
        r13 = null;
    L31:
        r13.setVisibility(8);
        setLoadingLayout(0);
        this.f17005f = null;
        this.f17006g = null;
        return;
    L5:
        if (r10 != 1) goto L7;
        LinearLayout r14 = this.f17000a;
        if (r14 != null) goto L20;
        q.y("contentContainer");
        r14 = null;
    L20:
        r14.setVisibility(8);
        FrameLayout r15 = this.f17004e;
        if (r15 != null) goto L23;
        q.y("loadingContainer");
    L24:
        r11.setVisibility(0);
        setLoadingLayout(R$layout.o_page_status_vertical_loading_item);
        this.f17005f = (ODownloadProgressView) findViewById(R$id.status_loading);
        this.f17006g = (OTextView) findViewById(R$id.status_loading_result);
        return;
    L23:
        r11 = r15;
        goto L24
    L7:
        if (r10 != 2) goto L35;
        LinearLayout r16 = this.f17000a;
        if (r16 != null) goto L12;
        q.y("contentContainer");
        r16 = null;
    L12:
        r16.setVisibility(8);
        FrameLayout r17 = this.f17004e;
        if (r17 != null) goto L15;
        q.y("loadingContainer");
    L16:
        r11.setVisibility(0);
        setLoadingLayout(R$layout.o_page_status_horizontal_loading_item);
        this.f17005f = (ODownloadProgressView) findViewById(R$id.status_loading);
        this.f17006g = (OTextView) findViewById(R$id.status_loading_result);
        return;
    L15:
        r11 = r17;
        goto L16
    }

    @JvmOverloads
    public OPageStatus(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OPageStatus(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OPageStatus(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        LayoutInflater.from(r10).inflate(R$layout.o_page_status_layout, this, true);
        setGravity(1);
        b();
        if (r11 == null) goto L6;
        a(r11);
        return;
    }
}
