package com.bytedanceos.common.ui.widget.oui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.CommonCache;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.SizeConverter;
import com.bytedanceos.common.toolbox.j;
import com.obric.oui.progress.ODownloadProgressView;
import com.tmall.wireless.tangram.structure.BaseCell;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import org.apache.http.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u0000 52\u00020\u00012\u00020\u0002:\u000256B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ,\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bJ(\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010#J\u000e\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\bJ\u000e\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\bJ\u0016\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010,\u001a\u00020\u0016J\u0010\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\bH\u0002J\u000e\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u000201J\u0010\u00102\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u001aH\u0016J\u0010\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u000201H\u0002R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedanceos/common/ui/widget/oui/OUIAppStatusView;", "Landroid/widget/RelativeLayout;", "Lcom/bytedanceos/common/ui/widget/oui/OAppStatusView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mStyle", "mViewData", "Lcom/bytedanceos/common/ui/widget/oui/OUIAppStatusView$ViewData;", "vContainer", "Landroid/view/View;", "vProgress", "Lcom/obric/oui/progress/ODownloadProgressView;", "vStatus", "Landroid/widget/Button;", "vText", "Landroid/widget/TextView;", "initClickListener", "", "cell", "Lcom/tmall/wireless/tangram/structure/BaseCell;", ServerElements.INFO, "Lcom/bytedanceos/common/model/AppInfo;", "textClickType", "iconClickType", "operateApp", "activity", "Landroid/app/Activity;", "v", "appInfo", "pageSource", "", "setAppSize", "size", "setBtnStyle", "style", "setBtnView", "resid", "setStatus", "status", "showAppSize", WsConstants.KEY_CONNECTION_STATE, "s", "updateBtnEnable", "enable", "", "updateDownloadStatus", "updateProgressVisible", "visible", "Companion", "ViewData", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOUIAppStatusView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OUIAppStatusView.kt\ncom/bytedanceos/common/ui/widget/oui/OUIAppStatusView\n+ 2 OUnitExtension.kt\ncom/obric/oui/common/util/OUnitExtensionKt\n*L\n1#1,320:1\n181#2,3:321\n180#2,5:324\n*S KotlinDebug\n*F\n+ 1 OUIAppStatusView.kt\ncom/bytedanceos/common/ui/widget/oui/OUIAppStatusView\n*L\n60#1:321,3\n60#1:324,5\n*E\n"})
public class OUIAppStatusView extends RelativeLayout implements OAppStatusView {
    public static final int BTN_STYLE_APPDETAIL = 2;
    public static final int BTN_STYLE_DEFAULT = 1;

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    private static final String ZERO_SIZE = "0B";
    private int mStyle;

    @Nullable
    private ViewData mViewData;

    @NotNull
    private final View vContainer;

    @NotNull
    private final ODownloadProgressView vProgress;

    @NotNull
    private final Button vStatus;

    @NotNull
    private final TextView vText;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedanceos/common/ui/widget/oui/OUIAppStatusView$Companion;", "", "()V", "BTN_STYLE_APPDETAIL", "", "BTN_STYLE_DEFAULT", "ZERO_SIZE", "", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0000J\b\u0010#\u001a\u00020\u000eH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/bytedanceos/common/ui/widget/oui/OUIAppStatusView$ViewData;", "", "appInfo", "Lcom/bytedanceos/common/model/AppInfo;", "mStatus", "", "(Lcom/bytedanceos/common/model/AppInfo;I)V", "mAppBytes", "", "getMAppBytes", "()J", "setMAppBytes", "(J)V", "mAppSize", "", "getMAppSize", "()Ljava/lang/String;", "setMAppSize", "(Ljava/lang/String;)V", "mDownloadProgress", "", "getMDownloadProgress", "()D", "setMDownloadProgress", "(D)V", "mPkg", "getMPkg", "setMPkg", "getMStatus", "()I", "setMStatus", "(I)V", "isSame", "", "viewData", "toString", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewData {
        private long mAppBytes;

        @Nullable
        private String mAppSize;
        private double mDownloadProgress;

        @NotNull
        private String mPkg;
        private int mStatus;

        public ViewData(@NotNull AppInfo r10, int r11) {
            q.g(r10, "appInfo");
            this.mStatus = r11;
            String r12 = r10.appPackageName;
            if (r12 != null) goto L5;
            r12 = "";
        L5:
            this.mPkg = r12;
            this.mDownloadProgress = r10.downloadProgress;
            this.mAppBytes = r10.appBytes;
        }

        public final long getMAppBytes() {
            return this.mAppBytes;
        }

        @Nullable
        public final String getMAppSize() {
            return this.mAppSize;
        }

        public final double getMDownloadProgress() {
            return this.mDownloadProgress;
        }

        @NotNull
        public final String getMPkg() {
            return this.mPkg;
        }

        public final int getMStatus() {
            return this.mStatus;
        }

        public final boolean isSame(@Nullable ViewData r10) {
            if (r10 != null) goto L6;
            return false;
        L6:
            if (this.mStatus == r10.mStatus) goto L8;
            return false;
        L8:
            if (TextUtils.equals(this.mPkg, r10.mPkg) == true) goto L10;
            return false;
        L10:
            if (this.mDownloadProgress == r10.mDownloadProgress) goto L12;
            return false;
        L12:
            if (this.mAppBytes != r10.mAppBytes) goto L18;
            return true;
        L18:
            return false;
        }

        public final void setMAppBytes(long r10) {
            this.mAppBytes = r10;
        }

        public final void setMAppSize(@Nullable String r10) {
            this.mAppSize = r10;
        }

        public final void setMDownloadProgress(double r10) {
            this.mDownloadProgress = r10;
        }

        public final void setMPkg(@NotNull String r10) {
            q.g(r10, "<set-?>");
            this.mPkg = r10;
        }

        public final void setMStatus(int r10) {
            this.mStatus = r10;
        }

        @NotNull
        public String toString() {
            return this.mStatus + " ," + this.mPkg + " ," + this.mDownloadProgress + " ," + this.mAppBytes;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmOverloads
    public OUIAppStatusView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    private static final void _init_$lambda$0(OUIAppStatusView r10, View r11) {
        q.g(r10, "this$0");
        r10.performClick();
    }

    private static final void _init_$lambda$1(OUIAppStatusView r10, View r11) {
        q.g(r10, "this$0");
        r10.performClick();
    }

    public static /* synthetic */ void a(OUIAppStatusView r10, View r11) {
        _init_$lambda$1(r10, r11);
    }

    public static /* synthetic */ void b(OUIAppStatusView r10, View r11) {
        _init_$lambda$0(r10, r11);
    }

    private final int state(int r10) {
        return 0;
    }

    private final void updateProgressVisible(boolean r10) {
        l.p(this.vProgress, r10);
        l.p(this.vStatus, !r10);
    }

    public final void initClickListener(@NotNull BaseCell<?> r10, @Nullable AppInfo r11, int r12, int r13) {
        q.g(r10, "cell");
        r10.setOnClickListener(this, r12);
        setTag(R$id.appinfo, r11);
    }

    @Override // com.bytedanceos.common.ui.widget.oui.OAppStatusView
    public void operateApp(@NotNull Activity r10, @NotNull View r11, @NotNull AppInfo r12, @NotNull String r13) {
        q.g(r10, "activity");
        q.g(r11, "v");
        q.g(r12, "appInfo");
        q.g(r13, "pageSource");
    }

    public final void setAppSize(@Nullable String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() == 0) goto L9;
        this.vText.setText(r10);
        return;
    }

    public final void setBtnStyle(int r10) {
        this.mStyle = r10;
    }

    public final void setBtnView(int r10) {
        if (this.mStyle != 2) goto L5;
        this.vStatus.setBackgroundResource(R$drawable.btn_appstatus_detail_bg);
        this.vStatus.setForeground(ContextCompat.d(getContext(), R$drawable.btn_appstatus_detail_fg));
        this.vStatus.setTextColor(getContext().getColor(R$color.oui_on_accent_default));
    L6:
        this.vStatus.setText(r10);
        return;
    L5:
        this.vStatus.setBackgroundResource(R$drawable.btn_appstatus_bg);
        this.vStatus.setForeground(ContextCompat.d(getContext(), R$drawable.btn_appstatus_fg));
        this.vStatus.setTextColor(getContext().getColor(R$color.oui_text_2));
        goto L6
    }

    public final void setStatus(int r10, @NotNull AppInfo r11) {
        q.g(r11, ServerElements.INFO);
        j.n("OUIAppStatusView setStatus " + r11.appPackageName + TokenParser.SP + r10 + TokenParser.SP + ((int) r11.downloadProgress));
        String r12 = r11.getAppSize();
        if (TextUtils.isEmpty(r12) == false) goto L5;
    L6:
        r12 = SizeConverter.BTrim.convert(r11.appBytes);
        if (q.b(ZERO_SIZE, r12) == false) goto L11;
        ViewData r13 = this.mViewData;
        if (r13 == null) goto L11;
        q.d(r13);
        r12 = r13.getMAppSize();
    L11:
        setAppSize(r12);
        setContentDescription(null);
        return;
    L5:
        if (r12 != "") goto L11;
        goto L6
    }

    public final void showAppSize() {
        this.vText.setVisibility(8);
    }

    public final void updateBtnEnable(boolean r10) {
        this.vStatus.setEnabled(r10);
    }

    @Override // com.bytedanceos.common.ui.widget.oui.OAppStatusView
    public void updateDownloadStatus(@NotNull AppInfo r10) {
        q.g(r10, "appInfo");
        String r11 = r10.appPackageName;
        CommonCache r12 = BaseApplication.c().b();
        AppInfo r13 = r12.s(r11);
        if (r13 == null) goto L17;
        if (r12.Y(r11) == false) goto L7;
        int r14 = r13.downloadStatus;
    L9:
        if (q.b("local", r10.appSource) == true) goto L11;
    L14:
        r10.appState = r13.appState;
        r10.downloadStatus = r13.downloadStatus;
    L15:
        r10.downloadProgress = r13.downloadProgress;
    L23:
        ViewData r15 = new ViewData(r10, r14);
        if (r15.isSame(this.mViewData) == true) goto L37;
        if (r13 == null) goto L27;
        r10.mRetryNum = r13.mRetryNum;
    L27:
        setStatus(r14, r10);
        invalidate();
        if (r10.getAppSize() == null) goto L33;
        if (q.b(ZERO_SIZE, r10.getAppSize()) == true) goto L33;
        r15.setMAppSize(r10.getAppSize());
    L33:
        if (TextUtils.isEmpty(r15.getMAppSize()) == false) goto L35;
        r15.setMAppSize(SizeConverter.BTrim.convert(r10.appBytes));
    L35:
        this.mViewData = r15;
        return;
    L37:
        return;
    L11:
        if (r10.downloadStatus != 8) goto L14;
        if (r14 != 32) goto L14;
        r14 = 8;
        goto L15
    L7:
        r14 = r13.appState;
        goto L9
    L17:
        if (r12.a0(r11) == false) goto L20;
        r14 = 16;
        goto L23
    L20:
        if (r12.f9566h.f9576a.containsKey(r11) == false) goto L22;
        r14 = 256;
        r10.appState = 256;
        goto L23
    L22:
        r10.appState = 32;
        r14 = r10.appState;
        goto L23
    }

    @JvmOverloads
    public OUIAppStatusView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OUIAppStatusView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OUIAppStatusView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.mStyle = 1;
        LayoutInflater.from(r10).inflate(R$layout.oui_appstatusview, this, true);
        this.vContainer = ViewExtKt.findView(this, R$id.container);
        this.vText = (TextView) ViewExtKt.findView(this, R$id.appCategorySize);
        ODownloadProgressView r13 = (ODownloadProgressView) ViewExtKt.findView(this, R$id.appStatusDownloadView);
        this.vProgress = r13;
        Button r14 = (Button) ViewExtKt.findView(this, R$id.appStatusButton);
        this.vStatus = r14;
        r14.setOnClickListener(new a(this));
        r13.setOnClickListener(new b(this));
        setMinimumWidth(yf.b.b(TypedValue.applyDimension(1, 52, Resources.getSystem().getDisplayMetrics())));
    }
}
