package com.stepos.ailauncher.oobe;

import Ua.C1060i;
import Z8.C1172u;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.a0;
import androidx.exifinterface.media.ExifInterface;
import b.AbstractC1417G;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.manager.ClawVMManager;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.oobe.AgentConfigActivity;
import com.stepos.ailauncher.oobe.api.OobeMemoryApi;
import com.stepos.widget.R;
import com.stepos.widget.dialog.StepOSAlertDialog;
import com.stepos.widget.toolbar.StepOSTitleBar;
import e9.InterfaceC4014c;
import f6.C4059a;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001:\u0018\u0000 =2\u00020\u0001:\u0002>?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001f\u0010\u0003R\u0014\u0010!\u001a\u00020 8\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010\u0014R\u0016\u00104\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010\u0014R\u0016\u00105\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010.R\u0016\u00106\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010\u0014R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006@"}, d2 = {"Lcom/stepos/ailauncher/oobe/AgentConfigActivity;", "Lcom/stepos/ailauncher/oobe/N;", "<init>", "()V", "LY8/t;", "initView", "b0", "g0", "f0", "", "Lcom/stepos/ailauncher/oobe/api/OobeMemoryApi$MemoryEntry;", "Q", "()Ljava/util/List;", "N", "O", "i0", "X", "R", "h0", ExifInterface.LONGITUDE_WEST, "Z", "Lcom/stepos/widget/dialog/StepOSAlertDialog;", C3081a.FOCUS_DIALOG_NAME, "M", "(Lcom/stepos/widget/dialog/StepOSAlertDialog;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroy", "", "TAG", "Ljava/lang/String;", "Lg6/b;", "binding", "Lg6/b;", "", "configStartTime", "J", "LUa/M;", "viewScope", "LUa/M;", "", "footerContentPaddingBottomPx", "I", "Landroid/view/ViewGroup;", "skipAction", "Landroid/view/ViewGroup;", "", "configCompleted", "videoResumed", "videoGeneration", "mascotPageLoaded", "Landroid/os/Handler;", "statusCheckHandler", "Landroid/os/Handler;", "com/stepos/ailauncher/oobe/AgentConfigActivity$e", "statusCheckRunnable", "Lcom/stepos/ailauncher/oobe/AgentConfigActivity$e;", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentConfigActivity extends N {
    private static final String MASCOT_DONE_VIDEO_URL = "https://appassets.androidplatform.net/oobe-agent-config/complete.webm";
    private static final String MASCOT_PAGE_URL = "https://appassets.androidplatform.net/oobe-agent-config/index.html";
    private static final String MASCOT_VIDEO_URL = "https://appassets.androidplatform.net/oobe-agent-config/video.webm";
    private static final long STATUS_CHECK_INTERVAL_MS = 3000;
    private static final long TIMEOUT_MS = 180000;
    private g6.b binding;
    private boolean configCompleted;
    private long configStartTime;
    private boolean mascotPageLoaded;
    private ViewGroup skipAction;
    private int videoGeneration;
    private boolean videoResumed;
    private Ua.M viewScope;
    private final String TAG = "AgentConfigActivity";
    private int footerContentPaddingBottomPx = -1;
    private final Handler statusCheckHandler = new Handler(Looper.getMainLooper());
    private final e statusCheckRunnable = new e();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/oobe/AgentConfigActivity$b;", "", "<init>", "(Lcom/stepos/ailauncher/oobe/AgentConfigActivity;)V", "", HomeGestureEligibilityContract.EXTRA_GENERATION, "LY8/t;", "onError", "(I)V", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class b {
        public b() {
        }

        public static final void b(AgentConfigActivity agentConfigActivity, int i10) {
            if (agentConfigActivity.videoResumed && i10 == agentConfigActivity.videoGeneration) {
                Log.w(agentConfigActivity.TAG, "Mascot WebM playback failed");
            }
        }

        @JavascriptInterface
        public final void onError(final int generation) {
            g6.b bVar = AgentConfigActivity.this.binding;
            if (bVar == null) {
                kotlin.jvm.internal.p.A("binding");
                bVar = null;
            }
            WebView webView = bVar.videoMascot;
            final AgentConfigActivity agentConfigActivity = AgentConfigActivity.this;
            webView.post(new Runnable() { // from class: com.stepos.ailauncher.oobe.k
                @Override // java.lang.Runnable
                public final void run() {
                    AgentConfigActivity.b.b(agentConfigActivity, generation);
                }
            });
        }
    }

    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"com/stepos/ailauncher/oobe/AgentConfigActivity$c", "Landroid/webkit/WebViewClient;", "Landroid/webkit/WebView;", "view", "Landroid/webkit/WebResourceRequest;", "request", "", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z", "", "url", "LY8/t;", "onPageFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "Landroid/webkit/WebResourceResponse;", "shouldInterceptRequest", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends WebViewClient {
        final /* synthetic */ WebView $this_apply;

        public c(WebView webView) {
            this.$this_apply = webView;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(url, "url");
            if (!kotlin.jvm.internal.p.d(url, AgentConfigActivity.MASCOT_PAGE_URL) || AgentConfigActivity.this.isDestroyed()) {
                return;
            }
            AgentConfigActivity.this.mascotPageLoaded = true;
            AgentConfigActivity.this.g0();
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(request, "request");
            String string = request.getUrl().toString();
            kotlin.jvm.internal.p.h(string, "toString(...)");
            String strW1 = La.H.w1(string, '?', null, 2, null);
            int iHashCode = strW1.hashCode();
            if (iHashCode != -2019512868) {
                if (iHashCode != -253829826) {
                    if (iHashCode == 2110738265 && strW1.equals(AgentConfigActivity.MASCOT_PAGE_URL)) {
                        return new WebResourceResponse("text/html", "UTF-8", AgentConfigActivity.this.getAssets().open("oobe_agent_config.html"));
                    }
                } else if (strW1.equals(AgentConfigActivity.MASCOT_VIDEO_URL)) {
                    return new WebResourceResponse("video/webm", null, this.$this_apply.getResources().openRawResource(R$raw.oobe_agent_config));
                }
            } else if (strW1.equals(AgentConfigActivity.MASCOT_DONE_VIDEO_URL)) {
                return new WebResourceResponse("video/webm", null, this.$this_apply.getResources().openRawResource(R$raw.oobe_agent_config_done));
            }
            return new WebResourceResponse(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30839B, "UTF-8", null);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(request, "request");
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/oobe/AgentConfigActivity$d", "Lb/G;", "LY8/t;", "handleOnBackPressed", "()V", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends AbstractC1417G {
        public d() {
            super(true);
        }

        @Override // b.AbstractC1417G
        public void handleOnBackPressed() {
            AgentConfigActivity.this.Z();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/oobe/AgentConfigActivity$e", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AgentConfigActivity.this.R();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.oobe.AgentConfigActivity$initView$5", f = "AgentConfigActivity.kt", l = {102}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.oobe.AgentConfigActivity$initView$5, reason: invalid class name */
    public static final class AnonymousClass5 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        Object L$0;
        int label;

        public AnonymousClass5(InterfaceC4014c<? super AnonymousClass5> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AgentConfigActivity.this.new AnonymousClass5(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass5) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                List<OobeMemoryApi.MemoryEntry> listQ = AgentConfigActivity.this.Q();
                String str = AgentConfigActivity.this.TAG;
                O o10 = O.INSTANCE;
                Log.i(str, "addMemory start nickname = " + o10.a() + " initStyleList = " + o10.b() + " initUserCustom = " + o10.c() + " entries.size = " + listQ.size() + " entries = " + listQ);
                OobeMemoryApi oobeMemoryApi = OobeMemoryApi.INSTANCE;
                this.L$0 = g9.h.a(listQ);
                this.label = 1;
                obj = oobeMemoryApi.addMemory(listQ, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            Log.i(AgentConfigActivity.this.TAG, "addMemory result = " + ((List) obj));
            return Y8.t.f7040a;
        }
    }

    public static final androidx.core.view.a0 P(AgentConfigActivity agentConfigActivity, View view, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(insets, "insets");
        t0.e eVarF = insets.f(a0.o.f());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        t0.e eVarF2 = insets.f(a0.o.e());
        kotlin.jvm.internal.p.h(eVarF2, "getInsets(...)");
        view.setPadding(eVarF.f41977a, eVarF.f41978b, eVarF.f41979c, view.getPaddingBottom());
        g6.b bVar = null;
        if (agentConfigActivity.footerContentPaddingBottomPx < 0) {
            g6.b bVar2 = agentConfigActivity.binding;
            if (bVar2 == null) {
                kotlin.jvm.internal.p.A("binding");
                bVar2 = null;
            }
            agentConfigActivity.footerContentPaddingBottomPx = bVar2.footerContent.getPaddingBottom();
        }
        g6.b bVar3 = agentConfigActivity.binding;
        if (bVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar3 = null;
        }
        LinearLayout footerContent = bVar3.footerContent;
        kotlin.jvm.internal.p.h(footerContent, "footerContent");
        footerContent.setPadding(footerContent.getPaddingLeft(), footerContent.getPaddingTop(), footerContent.getPaddingRight(), agentConfigActivity.footerContentPaddingBottomPx + eVarF2.f41980d);
        g6.b bVar4 = agentConfigActivity.binding;
        if (bVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            bVar = bVar4;
        }
        TextView tvTime = bVar.tvTime;
        kotlin.jvm.internal.p.h(tvTime, "tvTime");
        tvTime.setPadding(tvTime.getPaddingLeft(), tvTime.getPaddingTop(), tvTime.getPaddingRight(), eVarF2.f41980d);
        return insets;
    }

    public static final void S(AgentConfigActivity agentConfigActivity) {
        Toast.makeText(agentConfigActivity, R$string.oobe_config_timeout_retry, 1).show();
        agentConfigActivity.h0();
    }

    public static final Y8.t T(final AgentConfigActivity agentConfigActivity, String str) {
        int iHashCode;
        if (str != null && ((iHashCode = str.hashCode()) == -570634778 ? str.equals("DeployStatus_STARTING") : iHashCode == -67019681 ? str.equals("DeployStatus_CREATING") : iHashCode == -34121927 && str.equals("DeployStatus_RUNNING"))) {
            agentConfigActivity.statusCheckHandler.removeCallbacks(agentConfigActivity.statusCheckRunnable);
            AuthManager.INSTANCE.T0(true);
            agentConfigActivity.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.oobe.f
                @Override // java.lang.Runnable
                public final void run() {
                    AgentConfigActivity.U(this.f27598a);
                }
            });
        } else if (kotlin.jvm.internal.p.d(str, "") || str == null) {
            AuthManager.INSTANCE.T0(false);
            agentConfigActivity.statusCheckHandler.removeCallbacks(agentConfigActivity.statusCheckRunnable);
            agentConfigActivity.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.oobe.g
                @Override // java.lang.Runnable
                public final void run() {
                    AgentConfigActivity.V(this.f27600a);
                }
            });
        } else {
            agentConfigActivity.statusCheckHandler.postDelayed(agentConfigActivity.statusCheckRunnable, 3000L);
        }
        return Y8.t.f7040a;
    }

    public static final void U(AgentConfigActivity agentConfigActivity) {
        agentConfigActivity.W();
    }

    public static final void V(AgentConfigActivity agentConfigActivity) {
        Toast.makeText(agentConfigActivity, R$string.oobe_config_status_failed, 0).show();
        agentConfigActivity.h0();
    }

    public static final void Y(AgentConfigActivity agentConfigActivity) {
        agentConfigActivity.finishAffinity();
    }

    public static final void a0(AgentConfigActivity agentConfigActivity, DialogInterface dialogInterface, int i10) {
        Intent intent = new Intent(agentConfigActivity, (Class<?>) SdkInitNameActivity.class);
        intent.setFlags(603979776);
        agentConfigActivity.startActivity(intent);
        agentConfigActivity.finish();
    }

    public static final void c0(AgentConfigActivity agentConfigActivity, View view) {
        agentConfigActivity.Z();
    }

    public static final void d0(AgentConfigActivity agentConfigActivity, View view) {
        agentConfigActivity.statusCheckHandler.removeCallbacks(agentConfigActivity.statusCheckRunnable);
        O.INSTANCE.d(agentConfigActivity);
        agentConfigActivity.finishAffinity();
    }

    public static final void e0(AgentConfigActivity agentConfigActivity, View view) {
        agentConfigActivity.X();
    }

    private final void initView() {
        N();
        O();
        this.viewScope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c()));
        getOnBackPressedDispatcher().m(this, new d());
        g6.b bVar = this.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        bVar.titleBar.addStartAction(R.drawable.stepos_icon_navigation_back, getString(R$string.oobe_back), new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentConfigActivity.c0(this.f27593a, view);
            }
        });
        g6.b bVar2 = this.binding;
        if (bVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar2 = null;
        }
        StepOSTitleBar stepOSTitleBar = bVar2.titleBar;
        String string = getString(R$string.oobe_skip);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        LinearLayout linearLayoutAddEndTextAction = stepOSTitleBar.addEndTextAction(string, new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentConfigActivity.d0(this.f27595a, view);
            }
        });
        this.skipAction = linearLayoutAddEndTextAction;
        View childAt = linearLayoutAddEndTextAction != null ? linearLayoutAddEndTextAction.getChildAt(0) : null;
        TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
        if (textView != null) {
            textView.setTextColor(androidx.core.content.a.c(this, R$color.oobe_agreement_text_primary));
        }
        g6.b bVar3 = this.binding;
        if (bVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar3 = null;
        }
        bVar3.btnFinish.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentConfigActivity.e0(this.f27597a, view);
            }
        });
        b0();
        Ua.M m10 = this.viewScope;
        if (m10 != null) {
            C1060i.d(m10, null, null, new AnonymousClass5(null), 3, null);
        }
    }

    public final void M(StepOSAlertDialog dialog) {
        TextView textView = (TextView) dialog.findViewById(R.id.stepos_dialog_title);
        if (textView != null) {
            textView.setTextColor(androidx.core.content.a.c(this, R$color.oobe_agreement_text_primary));
            textView.setGravity(17);
        }
        TextView textView2 = (TextView) dialog.findViewById(R.id.stepos_dialog_message);
        if (textView2 != null) {
            textView2.setTextColor(androidx.core.content.a.c(this, R$color.oobe_config_dialog_message));
            textView2.setGravity(17);
        }
        Window window = dialog.getWindow();
        if (window != null) {
            N.INSTANCE.a(window);
            androidx.core.view.Y.b(window, false);
            window.setGravity(81);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = getResources().getDimensionPixelSize(R$dimen.oobe_config_dialog_margin_bottom);
            window.setAttributes(attributes);
        }
    }

    public final void N() {
        androidx.core.view.Y.b(getWindow(), false);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        getWindow().setNavigationBarContrastEnforced(false);
        androidx.core.view.b0 b0Var = new androidx.core.view.b0(getWindow(), getWindow().getDecorView());
        b0Var.e(false);
        b0Var.d(false);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() & (-8209));
        com.stepos.ailauncher.common.utils.H.d(getWindow());
        com.stepos.ailauncher.common.utils.H.c(getWindow(), false);
    }

    public final void O() {
        g6.b bVar = this.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        androidx.core.view.N.u0(bVar.configRoot, new androidx.core.view.A() { // from class: com.stepos.ailauncher.oobe.i
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return AgentConfigActivity.P(this.f27604a, view, a0Var);
            }
        });
    }

    public final List<OobeMemoryApi.MemoryEntry> Q() {
        OobeMemoryApi oobeMemoryApi = OobeMemoryApi.INSTANCE;
        String strTabTypeToCustomMemoryName = oobeMemoryApi.tabTypeToCustomMemoryName("about_me");
        String strTabTypeToCustomMemoryName2 = oobeMemoryApi.tabTypeToCustomMemoryName("communication");
        String strTabTypeToCustomMemoryName3 = oobeMemoryApi.tabTypeToCustomMemoryName("memo");
        List listC = C1172u.c();
        O o10 = O.INSTANCE;
        String strA = o10.a();
        if (La.H.x0(strA)) {
            strA = null;
        }
        if (strA != null) {
            listC.add(new OobeMemoryApi.MemoryEntry(strA, strTabTypeToCustomMemoryName));
        }
        listC.add(new OobeMemoryApi.MemoryEntry(o10.b().toString(), strTabTypeToCustomMemoryName2));
        listC.add(new OobeMemoryApi.MemoryEntry(o10.c(), strTabTypeToCustomMemoryName3));
        return C1172u.a(listC);
    }

    public final void R() {
        if (System.currentTimeMillis() - this.configStartTime < 180000) {
            ClawVMManager.INSTANCE.a().z(new InterfaceC5074l() { // from class: com.stepos.ailauncher.oobe.b
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentConfigActivity.T(this.f27591a, (String) obj);
                }
            });
        } else {
            this.statusCheckHandler.removeCallbacks(this.statusCheckRunnable);
            runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.oobe.a
                @Override // java.lang.Runnable
                public final void run() {
                    AgentConfigActivity.S(this.f27589a);
                }
            });
        }
    }

    public final void W() {
        this.configCompleted = true;
        g0();
        g6.b bVar = this.binding;
        g6.b bVar2 = null;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        bVar.tvTitle.setText(R$string.oobe_config_finish);
        g6.b bVar3 = this.binding;
        if (bVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar3 = null;
        }
        bVar3.tvDesc.setVisibility(8);
        g6.b bVar4 = this.binding;
        if (bVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar4 = null;
        }
        bVar4.tvTime.setVisibility(8);
        g6.b bVar5 = this.binding;
        if (bVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            bVar2 = bVar5;
        }
        bVar2.footerPanel.setVisibility(0);
        ViewGroup viewGroup = this.skipAction;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public final void X() {
        O.INSTANCE.d(this);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.stepos.ailauncher.oobe.h
            @Override // java.lang.Runnable
            public final void run() {
                AgentConfigActivity.Y(this.f27602a);
            }
        }, 1000L);
    }

    public final void Z() {
        C4059a.e(C4059a.INSTANCE, C4059a.STEP_SAVE_CONFIGURATION, "back", null, 4, null);
        StepOSAlertDialog stepOSAlertDialogCreate = new StepOSAlertDialog.Builder(this, 0, 2, null).setTitle(R$string.oobe_config_dialog_title).setMessage(R$string.oobe_config_dialog_message).setNegativeButton(R$string.oobe_dialog_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R$string.oobe_dialog_sure, new DialogInterface.OnClickListener() { // from class: com.stepos.ailauncher.oobe.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                AgentConfigActivity.a0(this.f27606a, dialogInterface, i10);
            }
        }).setHighLightButton(-1, 2).setGravity(80).create();
        stepOSAlertDialogCreate.create();
        M(stepOSAlertDialogCreate);
        stepOSAlertDialogCreate.show();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void b0() {
        com.stepos.ailauncher.common.memory.d.INSTANCE.v("oobeMascotWeb");
        g6.b bVar = this.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        WebView webView = bVar.videoMascot;
        webView.setBackgroundColor(0);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setBlockNetworkLoads(true);
        webView.setWebViewClient(new c(webView));
        webView.addJavascriptInterface(new b(), "MascotVideo");
        webView.setVisibility(0);
        webView.loadUrl(MASCOT_PAGE_URL);
    }

    public final void f0() {
        this.videoGeneration++;
        if (this.mascotPageLoaded) {
            g6.b bVar = this.binding;
            if (bVar == null) {
                kotlin.jvm.internal.p.A("binding");
                bVar = null;
            }
            bVar.videoMascot.evaluateJavascript("window.pauseMascot()", null);
        }
    }

    public final void g0() {
        if (this.videoResumed && this.mascotPageLoaded) {
            this.videoGeneration++;
            String str = this.configCompleted ? "complete" : "configuring";
            g6.b bVar = this.binding;
            if (bVar == null) {
                kotlin.jvm.internal.p.A("binding");
                bVar = null;
            }
            bVar.videoMascot.evaluateJavascript("window.setMascotState('" + str + "', " + this.videoGeneration + ")", null);
        }
    }

    public final void h0() {
        ViewGroup viewGroup = this.skipAction;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        g6.b bVar = this.binding;
        g6.b bVar2 = null;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        bVar.tvTime.setVisibility(8);
        g6.b bVar3 = this.binding;
        if (bVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            bVar2 = bVar3;
        }
        bVar2.footerPanel.setVisibility(0);
    }

    public final void i0() {
        ClawVMManager.INSTANCE.a().m(this);
        this.configStartTime = System.currentTimeMillis();
        this.statusCheckHandler.postDelayed(this.statusCheckRunnable, 3000L);
    }

    @Override // com.stepos.ailauncher.oobe.N, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        g6.b bVar = null;
        C4059a.h(C4059a.INSTANCE, C4059a.STEP_SAVE_CONFIGURATION, null, 2, null);
        g6.b bVarC = g6.b.c(getLayoutInflater());
        kotlin.jvm.internal.p.h(bVarC, "inflate(...)");
        this.binding = bVarC;
        if (bVarC == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            bVar = bVarC;
        }
        setContentView(bVar.b());
        initView();
        i0();
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        g6.b bVar = this.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        WebView webView = bVar.videoMascot;
        webView.removeJavascriptInterface("MascotVideo");
        ViewParent parent = webView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(webView);
        }
        com.stepos.ailauncher.common.memory.d.INSTANCE.w("oobeMascotWeb");
        webView.destroy();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onPause() {
        this.videoResumed = false;
        f0();
        g6.b bVar = this.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        bVar.videoMascot.onPause();
        super.onPause();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        this.videoResumed = true;
        g6.b bVar = this.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        bVar.videoMascot.onResume();
        g0();
    }
}
