package com.obric.appstore.common.core.ui.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.i;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.widget.oui.OAppItemView;
import com.obric.oui.image.OImageAppIcon;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.x1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sa.m;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0001+B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0012\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001e\u0010\rJ\u000f\u0010\u001f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001f\u0010\rJ'\u0010%\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u000eH\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b'\u0010\u0015J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b(\u0010\u0015J\u000f\u0010)\u001a\u00020\u000bH\u0002¢\u0006\u0004\b)\u0010\rR\u0017\u0010/\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u00105\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0017\u00109\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u0018R$\u0010$\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010\u0015R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010C\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010BR\u0018\u0010H\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010GR\u0016\u0010K\u001a\u00020I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010JR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010MR\u0016\u0010Q\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010T¨\u0006W"}, d2 = {"Lcom/obric/appstore/common/core/ui/view/ObricAppItemViewForSettings;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedanceos/common/ui/widget/oui/OAppItemView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "bindIcon", "()V", "Lcom/bytedanceos/common/model/AppInfo;", ServerElements.INFO, "", "pageSource", "i", "(Lcom/bytedanceos/common/model/AppInfo;Ljava/lang/String;)V", "updateItemView", "(Lcom/bytedanceos/common/model/AppInfo;)V", "Lcom/obric/appstore/common/core/ui/view/ObricAppStatusView;", "getAppStatusView", "()Lcom/obric/appstore/common/core/ui/view/ObricAppStatusView;", "Landroid/view/View$OnClickListener;", "btnClickListener", "itemClickListener", "setOnClickListener", "(Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;)V", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/app/Activity;", "activity", "Landroid/view/View;", "v", "appInfo", "operateApp", "(Landroid/app/Activity;Landroid/view/View;Lcom/bytedanceos/common/model/AppInfo;)V", "j", "k", "h", "Lcom/obric/oui/image/OImageAppIcon;", "a", "Lcom/obric/oui/image/OImageAppIcon;", "getVIcon", "()Lcom/obric/oui/image/OImageAppIcon;", "vIcon", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "getVName", "()Landroid/widget/TextView;", "vName", "c", "Lcom/obric/appstore/common/core/ui/view/ObricAppStatusView;", "getVStatus", "vStatus", "d", "Lcom/bytedanceos/common/model/AppInfo;", "getAppInfo", "()Lcom/bytedanceos/common/model/AppInfo;", "setAppInfo", "e", "Ljava/lang/String;", "f", "Landroid/view/View$OnClickListener;", "onBtnClickListener", "g", "onItemClickListener", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "iconLoadJob", "", "Z", "isDetachedFlag", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "viewScope", "Lsa/m;", "l", "Lsa/m;", "binding", "m", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nObricAppItemViewForSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObricAppItemViewForSettings.kt\ncom/obric/appstore/common/core/ui/view/ObricAppItemViewForSettings\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,191:1\n48#2,4:192\n1#3:196\n*S KotlinDebug\n*F\n+ 1 ObricAppItemViewForSettings.kt\ncom/obric/appstore/common/core/ui/view/ObricAppItemViewForSettings\n*L\n53#1:192,4\n*E\n"})
public class ObricAppItemViewForSettings extends ConstraintLayout implements OAppItemView {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f10919m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OImageAppIcon f10920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f10921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ObricAppStatusView f10922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppInfo f10923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f10924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnClickListener f10925f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View.OnClickListener f10926g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Job f10927h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10928i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CoroutineExceptionHandler f10929j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CoroutineScope f10930k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final m f10931l;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends kotlin.coroutines.a implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.a r10) {
            super(r10);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext r10, Throwable r11) {
            i.b("ObricAppItemView", "icon load error: " + r11);
        }
    }

    static {
        f10919m = new a(null);
    }

    @JvmOverloads
    public ObricAppItemViewForSettings(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    private final void bindIcon() {
        AppInfo r10 = this.f10923d;
        if (r10 != null) goto L5;
        return;
    L5:
        j(r10);
    }

    public static final /* synthetic */ void g(ObricAppItemViewForSettings r10, AppInfo r11) {
        r10.k(r11);
    }

    @Nullable
    public final AppInfo getAppInfo() {
        return this.f10923d;
    }

    @NotNull
    public final ObricAppStatusView getAppStatusView() {
        return this.f10922c;
    }

    @NotNull
    public final OImageAppIcon getVIcon() {
        return this.f10920a;
    }

    @NotNull
    public final TextView getVName() {
        return this.f10921b;
    }

    @NotNull
    public final ObricAppStatusView getVStatus() {
        return this.f10922c;
    }

    public final void h() {
        AppInfo r10 = this.f10923d;
        if (r10 != null) goto L5;
        return;
    L5:
        this.f10922c.updateDownloadStatus(r10);
        View.OnClickListener r11 = this.f10925f;
        if (r11 == null) goto L9;
        this.f10922c.setOnClickListener(r11);
        return;
    }

    public final void i(AppInfo r10, String r11) {
        this.f10924e = r11;
        updateItemView(r10);
    }

    public final void j(AppInfo r11) {
        Job r10 = this.f10927h;
        if (r10 == null) goto L5;
        Job.a.b(r10, null, 1, null);
    L5:
        String r12 = r11.appPackageName;
        if (r12 != null) goto L8;
    L12:
        k(r11);
        return;
    L8:
        if (o.r(r12) == true) goto L12;
        com.bytedanceos.common.toolbox.glide.b.b(getContext(), this.f10920a);
        this.f10920a.setImageResource(R$drawable.oui_default_app_icon);
        this.f10927h = h.d(this.f10930k, null, null, new ObricAppItemViewForSettings$loadAppIconAsync$1(this, r11, r12, null), 3, null);
    }

    public final void k(AppInfo r10) {
        com.bytedanceos.common.toolbox.glide.b.b(getContext(), this.f10920a);
        RequestBuilder<Drawable> r11 = Glide.with(getContext()).load(com.bytedanceos.common.toolbox.glide.a.a(r10.appIcon));
        int r12 = R$drawable.oui_default_app_icon;
        r11.error(r12).placeholder(r12).dontAnimate().into(this.f10920a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (d0.f(this.f10930k) == true) goto L6;
        this.f10930k = d0.a(x1.b(null, 1, null).plus(l0.c()).plus(this.f10929j));
    L6:
        if (this.f10928i == false) goto L11;
        this.f10928i = false;
        AppInfo r10 = this.f10923d;
        if (r10 == null) goto L12;
        j(r10);
        return;
    L12:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Job r10 = this.f10927h;
        if (r10 == null) goto L5;
        Job.a.b(r10, null, 1, null);
    L5:
        d0.d(this.f10930k, null, 1, null);
        this.f10928i = true;
    }

    @Override // com.bytedanceos.common.ui.widget.oui.OAppItemView
    public void operateApp(Activity r10, View r11, AppInfo r12) {
        q.g(r10, "activity");
        q.g(r11, "v");
        q.g(r12, "appInfo");
        this.f10922c.operateApp(r10, r11, r12, String.valueOf(this.f10924e));
    }

    public final void setAppInfo(@Nullable AppInfo r10) {
        this.f10923d = r10;
    }

    public final void setOnClickListener(View.OnClickListener r10, View.OnClickListener r11) {
        this.f10925f = r10;
        this.f10926g = r11;
        setOnClickListener(r11);
        this.f10922c.setOnClickListener(this.f10925f);
    }

    public final void updateItemView(AppInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f10923d = r10;
        View.OnClickListener r11 = this.f10926g;
        if (r11 == null) goto L8;
        setOnClickListener(r11);
    L8:
        if (q.b(r10.appPackageName, "com.obric.recorder") == false) goto L10;
        j.n("[SysAppNameDebug][ObricAppItemViewForSettings] bind pageSource=" + this.f10924e + " pkg=" + r10.appPackageName + " name=" + r10.appName + " version=" + r10.appVersionCode + '/' + r10.appVersionName + " state=" + r10.appState + " appSource=" + r10.appSource + " icon=" + r10.appIcon + " preloadPath=" + r10.obricPreloadApkFilePath);
    L10:
        this.f10921b.setText(r10.appName);
        h();
        bindIcon();
    }

    @JvmOverloads
    public ObricAppItemViewForSettings(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ ObricAppItemViewForSettings(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public ObricAppItemViewForSettings(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        b r13 = new b(CoroutineExceptionHandler.Key);
        this.f10929j = r13;
        this.f10930k = d0.a(x1.b(null, 1, null).plus(l0.c()).plus(r13));
        m r14 = m.b(LayoutInflater.from(r10), this);
        q.f(r14, "inflate(...)");
        this.f10931l = r14;
        OImageAppIcon r15 = r14.f24603b;
        q.f(r15, "appIcon");
        this.f10920a = r15;
        TextView r16 = r14.f24605d;
        q.f(r16, "appName");
        this.f10921b = r16;
        ObricAppStatusView r17 = r14.f24606e;
        q.f(r17, "appStatusLay");
        this.f10922c = r17;
        r14.f24604c.setChangeAlphaWhenPress(false);
    }
}
