package com.bytedance.android.live.browser.webview.fragment;

import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import b30.a0;
import b30.f0;
import b30.z;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.business.container.AnnieXLiveDialog;
import com.bytedance.android.annie.container.dialog.BaseDialogFragment;
import com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew;
import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.t;
import com.bytedance.android.live.browser.v;
import com.bytedance.android.live.browser.webview.config.LiveHybridSettingKeys;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.live.schema.vo.PopupHybridParamVo;
import com.bytedance.android.livesdk.WebDialogRecorder;
import com.bytedance.android.livesdk.config.ad0;
import com.bytedance.android.livesdk.config.j7;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.utils.LiveCardReleaseOpt;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ttnet.config.AppConfig;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/browser/webview/fragment/WebDialogFragmentForAnnie;", "Lcom/bytedance/android/live/browser/webview/fragment/BaseWebDialogFragment;", "Lcom/bytedance/android/live/browser/jsbridge/f;", "Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$AutoFloatEnable;", "Lcom/bytedance/android/live/browser/webview/fragment/l;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class WebDialogFragmentForAnnie extends BaseWebDialogFragment implements com.bytedance.android.live.browser.jsbridge.f, IVideoFloatManager.AutoFloatEnable, l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PopupHybridParamVo f64362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseHybridParamVo f64363e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f64364f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HybridDialog f64365g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public t f64366h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public gf1.a f64367i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.live.browser.q f64368j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public v f64369k;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebDialogFragmentForAnnie f64370a;

        public b(WebDialogFragmentForAnnie r100) {
            this.f64370a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            a0 r101 = (a0) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            BaseHybridParamVo r102 = this.f64370a.f64363e;
            if (r102 == null) goto L6;
            r102.K(r101.f17114a);
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebDialogFragmentForAnnie f64371a;

        public c(WebDialogFragmentForAnnie r100) {
            this.f64371a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            z r101 = (z) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            BaseHybridParamVo r102 = this.f64371a.f64363e;
            if (r102 == null) goto L10;
            boolean r103 = true;
            if (r101.f17166a == 1) goto L8;
            r103 = false;
        L8:
            r102.J(r103);
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebDialogFragmentForAnnie f64372a;

        public d(WebDialogFragmentForAnnie r100) {
            this.f64372a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Intrinsics.checkNotNullParameter((b30.c) r100, "event");
            HybridDialog r101 = this.f64372a.f64365g;
            if (r101 == null) goto L13;
            r101.dismissAllowingStateLoss();     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r102 = DialogFragmentLancet.sLastShowStack;
            if (r102 == null) goto L14;
            com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L14:
            return;
        }
    }

    public static final class e implements HybridDialog.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebDialogFragmentForAnnie f64373a;

        @Override // com.bytedance.android.annie.api.container.HybridDialog.a
        public final void onScroll(int r100) {
        }

        @Override // com.bytedance.android.annie.api.container.HybridDialog.a
        public final void onShow() {
        }

        @Override // com.bytedance.android.annie.api.container.HybridDialog.a
        public final void onDismiss() {
            Dialog r100 = this.f64373a.getDialog();
            if (r100 == null) goto L21;
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r102 == null) goto L18;
            com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L7:
            if (Looper.myLooper() == r101.getLooper()) goto L9;
            r101.post(DialogLancet.createDismissRunnable(r100));
            return;
        }

        public e(WebDialogFragmentForAnnie r100) {
            this.f64373a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.AutoFloatEnable
    public final void finish() {
        HybridDialog r100 = this.f64365g;
        IHybridComponent r101 = null;
        if (r100 == null) goto L5;
        IHybridComponent r102 = r100.getHybridComponent();
    L7:
        if ((r102 instanceof LiveAnnieFragment) == false) goto L10;
        r101 = r102;
    L10:
        LiveAnnieFragment r103 = (LiveAnnieFragment) r101;
        if (r103 == null) goto L14;
        r103.close();
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.AutoFloatEnable
    public final String getRequestPage() {
        HybridDialog r100 = this.f64365g;
        IHybridComponent r101 = null;
        if (r100 == null) goto L5;
        IHybridComponent r102 = r100.getHybridComponent();
    L7:
        if ((r102 instanceof LiveAnnieFragment) == false) goto L11;
        r101 = r102;
    L11:
        if (((LiveAnnieFragment) r101) == null) goto L13;
        return "LiveAnnieFragment";
    L13:
        return "WebDialogFragmentForAnnie";
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.l
    public final void hideLiveFloatWindow() {
        HybridDialog r100 = this.f64365g;
        IHybridComponent r101 = null;
        if (r100 == null) goto L5;
        IHybridComponent r102 = r100.getHybridComponent();
    L7:
        if ((r102 instanceof LiveAnnieFragment) == false) goto L10;
        r101 = r102;
    L10:
        LiveAnnieFragment r103 = (LiveAnnieFragment) r101;
        if (r103 == null) goto L14;
        r103.hideLiveFloatWindow();
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.AutoFloatEnable
    public final boolean isAutoFloatEnable() {
        HybridDialog r100 = this.f64365g;
        IHybridComponent r101 = null;
        if (r100 == null) goto L5;
        IHybridComponent r102 = r100.getHybridComponent();
    L7:
        if ((r102 instanceof LiveAnnieFragment) == false) goto L11;
        r101 = r102;
    L11:
        if (((LiveAnnieFragment) r101) == null) goto L13;
        return true;
    L13:
        return false;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.l
    public final boolean isShowLiveFloatWindow() {
        HybridDialog r100 = this.f64365g;
        IHybridComponent r101 = null;
        if (r100 == null) goto L5;
        IHybridComponent r102 = r100.getHybridComponent();
    L7:
        if ((r102 instanceof LiveAnnieFragment) == false) goto L10;
        r101 = r102;
    L10:
        LiveAnnieFragment r103 = (LiveAnnieFragment) r101;
        if (r103 != null) goto L15;
        return false;
    L15:
        return r103.ja0();
    L5:
        r102 = null;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.live.browser.q r100 = this.f64368j;
        if (r100 == null) goto L15;
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        Integer r101 = j7.f120503a.getValue();
        if (r101 == null) goto L15;
        if (r101.intValue() != 1) goto L15;
        Iterator r102 = ((LinkedHashMap) r100.f64156c).entrySet().iterator();
    L11:
        if (r102.hasNext() == false) goto L15;
        Map.Entry r103 = (Map.Entry) r102.next();
        if (Intrinsics.areEqual((BaseWebDialogFragment) r103.getValue(), this) == false) goto L11;
        r100.f64156c.remove(r103.getKey());
    L15:
        com.bytedance.android.live.browser.q r104 = this.f64368j;
        if (r104 == null) goto L28;
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        if (LiveCardReleaseOpt.INSTANCE.useWeakRef() == false) goto L27;
        Iterator<WeakReference<DialogFragment>> r105 = r104.f64155b.iterator();
    L21:
        if (r105.hasNext() == false) goto L25;
        WeakReference<DialogFragment> r106 = r105.next();
        if (Intrinsics.areEqual(r106.get(), this) == false) goto L21;
    L26:
        CopyOnWriteArrayList<WeakReference<DialogFragment>> r107 = r104.f64155b;
        r107.remove(r106);
        goto L28
    L25:
        r106 = null;
        goto L26
    L27:
        r104.f64154a.remove(this);
    L28:
        WebDialogRecorder r108 = (WebDialogRecorder) WebDialogRecorder.f102978c.getValue();
        if (r108.f102979a.isEmpty() == true) goto L38;
        r108.f102979a.pop();
        return;
    }

    public WebDialogFragmentForAnnie() {
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment
    public final void S90(boolean r100) {
        HybridDialog r101 = this.f64365g;
        if ((r101 instanceof BaseDialogFragment) == true) goto L5;
        r101 = null;
    L5:
        BaseDialogFragment r102 = (BaseDialogFragment) r101;
        if (r102 == null) goto L9;
        r102.U90(r100);
        return;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment
    public final void T90(t r100) {
        this.f64366h = r100;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment
    public final void U90(boolean r100) {
        HybridDialog r101 = this.f64365g;
        if ((r101 instanceof BaseDialogFragment) == true) goto L5;
        r101 = null;
    L5:
        BaseDialogFragment r102 = (BaseDialogFragment) r101;
        if (r102 == null) goto L9;
        r102.f39248k = r100;
        return;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment
    public final void V90(boolean r100) {
        HybridDialog r101 = this.f64365g;
        if ((r101 instanceof BaseDialogFragment) == true) goto L5;
        r101 = null;
    L5:
        BaseDialogFragment r102 = (BaseDialogFragment) r101;
        if (r102 == null) goto L9;
        r102.f39247j = r100;
        return;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment
    public final void X90(boolean r100) {
        HybridDialog r101 = this.f64365g;
        if ((r101 instanceof BaseDialogFragment) == true) goto L5;
        r101 = null;
    L5:
        BaseDialogFragment r102 = (BaseDialogFragment) r101;
        if (r102 == null) goto L9;
        r102.Z90(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        ((ObservableSubscribeProxy) xs2.b.a().b(a0.class).compose(RxUtil.bindUntilDestroy(this)).as(AutoDispose.bind(this))).subscribe(new b(this));
        ((ObservableSubscribeProxy) xs2.b.a().b(z.class).compose(RxUtil.bindUntilDestroy(this)).as(AutoDispose.bind(this))).subscribe(new c(this));
        ((ObservableSubscribeProxy) xs2.b.a().b(b30.c.class).compose(RxUtil.bindUntilDestroy(this)).as(AutoDispose.bind(this))).subscribe(new d(this));
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r210) {
        super.onCreate(r210);
        if (TTLiveService.getLiveService() != null) goto L12;
        ALogger.e("WebDialogFragmentForAnnie", "livesdk not init!");
        dismissAllowingStateLoss();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L191;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L191:
        return;
    L12:
        BrowserServiceImpl.Companion.getClass();
        s20.b r101 = (s20.b) BrowserServiceImpl.access$getDiComponent$cp();
        r101.getClass();
        s20.b r102 = r101.f540209b;
        this.f64368j = r102.f540213f.get();
        this.f64369k = r102.f540212e.get();
        Bundle r103 = getArguments();
        if (r103 == null) goto L34;
        int r104 = com.bytedance.android.live.schema.helper.a.f100513a;
        if (r103.get("hybrid_pop_vo") != null) goto L18;
        com.bytedance.android.live.schema.api.utils.a.d("tag_hybrid_parse", "HybridParamHelper->checkFullScreenVo: webHybridParamVo is null");
        r103.putParcelable("hybrid_pop_vo", com.bytedance.android.live.schema.helper.a.e(r103.getString("url"), null, r103));
    L18:
        this.f64362d = (PopupHybridParamVo) r103.getParcelable("hybrid_pop_vo");
        this.f64364f = r103.getString("arg_url");
        PopupHybridParamVo r105 = this.f64362d;
        if (r105 == null) goto L21;
        BaseHybridParamVo r106 = r105.f100547k;
    L22:
        this.f64363e = r106;
        ALogger.i("WebDialogFragmentForAnnie", String.valueOf(r105));
        if (TextUtils.isEmpty(this.f64364f) == true) goto L34;
        Uri r107 = UriProtector.parse(this.f64364f);
        if (r107 == null) goto L34;
        String r108 = UriProtector.getQueryParameter(r107, "open_animate");     // Catch: Exception -> L32
        if (TextUtils.isEmpty(r108) == true) goto L34;
        PopupHybridParamVo r109 = this.f64362d;     // Catch: Exception -> L32
        if (r109 == null) goto L34;
        r109.O(Intrinsics.areEqual("1", r108));     // Catch: Exception -> L32
        goto L34
    L21:
        r106 = null;
    L34:
        if (e5.j(getActivity()) == false) goto L36;
    L46:
        boolean r110 = true;
    L47:
        if (r110 == false) goto L50;
        setVertical(false);
    L50:
        if (Build.VERSION.SDK_INT >= 23) goto L52;
    L55:
        String r111 = this.f64364f;
        if (r111 == null) goto L127;
        List<? extends String> r112 = ad0.f119780a.getValue();
        if (r112 != null) goto L60;
    L90:
        boolean r113 = false;
    L91:
        if (r113 == false) goto L100;
        BaseHybridParamVo r114 = this.f64363e;
        if (r114 == null) goto L95;
        r114.J(true);
    L95:
        setShouldUseNewPanel(true);
        PopupHybridParamVo r115 = this.f64362d;
        if (r115 == null) goto L98;
        String r116 = r115.f100549m;
    L99:
        setAnimationType(r116);
        goto L100
    L98:
        r116 = null;
    L100:
        WebDialogRecorder r117 = (WebDialogRecorder) WebDialogRecorder.f102978c.getValue();
        r117.getClass();
        Intrinsics.checkNotNullParameter(r111, "url");
        r117.f102979a.push(r111);
        PopupHybridParamVo r118 = this.f64362d;
        if (r118 != null) goto L103;
    L112:
        com.bytedance.android.live.browser.q r119 = this.f64368j;
        if (r119 == null) goto L127;
        Intrinsics.checkNotNullParameter(r111, "scheme");
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        Integer r120 = j7.f120503a.getValue();
        if (r120 == null) goto L127;
        if (r120.intValue() != 1) goto L127;
        BaseWebDialogFragment r121 = r119.f64156c.put(r111, this);
        if (r121 == null) goto L127;
        r121.dismissAllowingStateLoss();     // Catch: Exception -> L123
    L123:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r122 = DialogFragmentLancet.sLastShowStack;
        if (r122 == null) goto L127;
        com.bytedance.crash.d.d(r122, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L127
    L103:
        if ((r118.a() & 80) != 80) goto L112;
        String r123 = UriProtector.getQueryParameter(UriProtector.parse(this.f64364f), AppConstants.BUNDLE_PULL_DOWN_CLOSE);     // Catch: Exception -> L111
        if (r123 == null) goto L112;
        BaseHybridParamVo r124 = this.f64363e;     // Catch: Exception -> L111
        if (r124 == null) goto L112;
        r124.J(Intrinsics.areEqual("1", r123));     // Catch: Exception -> L111
        goto L112
    L60:
        if ((!r112.isEmpty()) == false) goto L90;
        Iterator<? extends String> r125 = r112.iterator();
    L63:
        if (r125.hasNext() == false) goto L90;
        String r126 = r125.next();
        if (StringsKt.startsWith$default(r126, "http", false, 2, null) == true) goto L67;
        r126 = "http://" + r126;
    L67:
        Uri r127 = UriProtector.parse(r126);
        if (r127 == null) goto L63;
        if (r127.getPath() == null) goto L63;
        if (r127.getHost() == null) goto L63;
        String r128 = "";
        if (TextUtils.isEmpty(r127.getPath()) == true) goto L81;
        String r129 = r127.getPath();
        if (r129 != null) goto L79;
        r129 = "";
    L79:
        if (StringsKt.contains$default(r111, r129, false, 2, null) == false) goto L63;
    L81:
        if (TextUtils.isEmpty(r127.getHost()) == true) goto L88;
        String r130 = r127.getHost();
        if (r130 == null) goto L87;
        r128 = r130;
    L87:
        if (StringsKt.contains$default(r111, r128, false, 2, null) == false) goto L63;
    L88:
        r113 = true;
    L127:
        StringBuilder r131 = new StringBuilder("WebDialogFragmentForAnnie-> onCreate berfor ");
        PopupHybridParamVo r132 = this.f64362d;
        if (r132 == null) goto L130;
        String r133 = r132.toString();
    L131:
        r131.append(r133);
        ALogger.i("WebDialogFragmentForAnnie", r131.toString());
        com.bytedance.android.live.browser.q r134 = this.f64368j;
        if (r134 == null) goto L137;
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        if (LiveCardReleaseOpt.INSTANCE.useWeakRef() == false) goto L136;
        r134.f64155b.add(new WeakReference(this));
        goto L137
    L136:
        r134.f64154a.add(this);
    L137:
        BaseHybridParamVo r135 = this.f64363e;
        if (r135 == null) goto L140;
        String r136 = r135.f100521c;
    L141:
        if (r135 == null) goto L143;
        String r137 = r135.z();
    L145:
        if (TextUtils.isEmpty(r137) == true) goto L170;
        Intrinsics.checkNotNull(r137);
        if (StringsKt.startsWith$default(r137, "http", false, 2, null) == false) goto L170;
        if (LiveHybridSettingKeys.ENABLE_SHARE_COOKIE_URL_TO_HTTPS.getValue().booleanValue() == false) goto L170;
        Iterator<T> r138 = LiveHybridSettingKeys.SHARE_COOKIE_URL_TO_HTTPS_LIST.getValue().iterator();
    L153:
        if (r138.hasNext() == false) goto L157;
        if (StringsKt.contains$default(r137, (String) r138.next(), false, 2, null) == false) goto L153;
        boolean r139 = true;
    L158:
        if (r139 == true) goto L170;
        Application r140 = jc1.a.b();
        if (r140 == null) goto L163;
        List<String> r141 = AppConfig.getInstance(r140).getShareCookieHostList(r137);
    L165:
        if (StringsKt.startsWith$default(r137, "http", false, 2, null) == false) goto L170;
        if (r141 == null) goto L170;
        if ((!r141.isEmpty()) == false) goto L170;
        HashMap r142 = new HashMap();
        r142.put("url", r137);
        u.l().sendLog("live_sdk_webview_http_cookie", r142, new Object[0]);
        r137 = StringsKt.replaceFirst$default(r137, "http://", "https://", false, 4, null);
        goto L170
    L163:
        r141 = null;
        goto L165
    L157:
        r139 = false;
    L170:
        this.f64367i = new gf1.a(r136, r137, this.f64366h);
        return;
    L143:
        r137 = null;
        goto L145
    L140:
        r136 = null;
        goto L141
    L130:
        r133 = null;
        goto L131
    L52:
        if (isVertical() == false) goto L54;
        setStyle(1, R.style.ttlive_ShowWebDialog);
        goto L55
    L54:
        setStyle(1, R.style.ttlive_ShowNotFloatingWebDialog);
        goto L55
    L36:
        if (getActivity() != null) goto L38;
    L40:
        boolean r143 = false;
    L41:
        if (r143 == true) goto L43;
    L45:
        r110 = false;
        goto L47
    L43:
        if (LiveHybridSettingKeys.ENABLE_HYBRID_CONTAINER_ORIENTATION_BY_SIZE.getValue().booleanValue() == false) goto L45;
    L38:
        if (s1.y() <= s1.w()) goto L40;
        r143 = true;
        goto L41
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        if (r101 == null) goto L7;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        r102.clearFlags(6);
        r102.setDimAmount(0.0f);
    L7:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
        com.bytedance.android.livesdk.e.b().d();     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.l
    public final void showLiveFloatWindow(JSONObject r100) {
        HybridDialog r101 = this.f64365g;
        IHybridComponent r102 = null;
        if (r101 == null) goto L5;
        IHybridComponent r103 = r101.getHybridComponent();
    L7:
        if ((r103 instanceof LiveAnnieFragment) == false) goto L10;
        r102 = r103;
    L10:
        LiveAnnieFragment r104 = (LiveAnnieFragment) r102;
        if (r104 == null) goto L14;
        r104.showLiveFloatWindow(r100);
        return;
    L14:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment
    public final int show(FragmentTransaction r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "transaction");
        com.bytedance.android.livesdk.e.b().a();
        xs2.b.a().post(new f0(this.f64364f));
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_TRANSACTION;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r102);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, this, r102) == false) goto L9;
        return -1;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L7:
        return super.show(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment
    public final void showNow(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        com.bytedance.android.livesdk.e.b().a();
        xs2.b.a().post(new f0(this.f64364f));
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r102) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        super.showNow(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r102) == false) goto L10;
    L7:
        com.bytedance.android.livesdk.e.b().a();
        xs2.b.a().post(new f0(this.f64364f));
        return;
    L10:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        super.show(r100, r101);
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        String r100 = this.f64364f;
        PopupHybridParamVo r101 = this.f64362d;
        BaseHybridParamVo r102 = this.f64363e;
        WebDialogFragmentForAnnie$createSchemaUri$1 r103 = WebDialogFragmentForAnnie$createSchemaUri$1.INSTANCE;
        HybridDialog r104 = null;
        if (r100 == null) goto L7;
        if (r101 == null) goto L7;
        if (r102 == null) goto L7;
        Uri r105 = r103.invoke(r100, r101, r102);
    L8:
        Uri r106 = r105;
        if (r106 == null) goto L26;
        HybridDialog r107 = ((IBaseBrowserService) jc1.k.n(IBrowserService.class)).showHybridDialog(requireContext(), r106, new r(this), getArguments(), null);
        if (r107 == null) goto L31;
        r107.setJSBridgeListener(new q(this, r107));
    L31:
    L23:
        e = move-exception;
        e.getMessage();
    L25:
        r104 = r107;
        goto L26
    L14:
        if ((r107 instanceof AnnieXLiveDialog) == false) goto L17;
        r104 = r107;
    L17:
        AnnieXLiveDialog r108 = (AnnieXLiveDialog) r104;     // Catch: Exception -> L23
        if (r108 == null) goto L25;
        Intrinsics.checkNotNullParameter(l.class, "clazz");     // Catch: Exception -> L23
        com.bytedance.android.anniex.container.d r109 = r108.f38900g;     // Catch: Exception -> L23
        if (r109 == null) goto L25;
        r109.registerWeakHolder(l.class, this);     // Catch: Exception -> L23
    L26:
        this.f64365g = r104;
        if (r104 == null) goto L30;
        r104.T90(new e(this));
    L30:
        return super.onCreateView(r110, r111, r112);
    L7:
        r105 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment
    public final void W90(String r100, int r101, int r110, int r111, int r112, BaseHybridParamVo.HybridType r113) {
        Intrinsics.checkNotNullParameter(r113, "type");
        int r114 = p.f64412a[r113.ordinal()];
        if (r114 != 1) goto L5;
        BaseHybridParamVoNew.HybridType r115 = BaseHybridParamVoNew.HybridType.LYNX;
    L16:
        BaseHybridParamVoNew.HybridType r102 = r115;
        HybridDialog r116 = this.f64365g;
        if ((r116 instanceof BaseDialogFragment) == true) goto L19;
        r116 = null;
    L19:
        BaseDialogFragment r103 = (BaseDialogFragment) r116;
        if (r103 == null) goto L23;
        r103.la0(r100, r101, r110, r111, r112, r102);
        return;
    L23:
        return;
    L5:
        if (r114 != 2) goto L7;
        r115 = BaseHybridParamVoNew.HybridType.H5;
        goto L16
    L7:
        if (r114 != 3) goto L9;
        r115 = BaseHybridParamVoNew.HybridType.HOST_H5;
        goto L16
    L9:
        if (r114 != 4) goto L12;
        r115 = BaseHybridParamVoNew.HybridType.HOST_H5;
        goto L16
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
