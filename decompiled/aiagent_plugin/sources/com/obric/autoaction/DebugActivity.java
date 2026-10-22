package com.obric.autoaction;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ICloudConfig;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.agents.scripted.api.IJSScriptService;
import com.obric.autogui.agents.scripted.impl.w;
import com.obric.autogui.common.a.k;
import com.obric.autogui.common.api.AODeviceSpecificTools;
import com.obric.autogui.common.api.AOFileUtil;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.platform.device.AODeviceInfo;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.database.AutoActionDatabase;
import com.obric.autogui.effects.VDPlayerEffectProviderImpl;
import com.obric.autogui.resourcemanage.ac;
import com.obric.autogui.resourcemanage.n;
import com.obric.autogui.tools.api.IAutoActionAppUpgradeApi;
import com.obric.eventkit.task.api.ILegacyTimerApi;
import com.obric.eventkit.task.model.TimerTask;
import com.obric.eventkit.task.model.TimerTaskAction;
import com.obric.eventkit.task.model.TimerTaskResult;
import com.obric.oui.dropdown.ODropdownTrigger;
import com.obric.oui.forms.OInputView;
import com.obric.oui.orecyclerview.widget.ItemTouchHelper;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;
import com.obric.oui.window.permission.PrivacyStatementActivity;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDAbstractUpload;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.al;
import d.a.ao;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.l.j;
import d.o;
import d.s;
import d.x;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bs;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: compiled from: DebugActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DebugActivity extends AppCompatActivity {
    public static final a Companion = null;
    private static final String DEFAULT_VD_PLAYER_DEBUG_BRIDGE_URL = "http://127.0.0.1:5174";
    private static DebugActivity instance;
    private final SimpleDateFormat builtDateFormat;
    private final List<String> environmentList;
    private File fileToShare;
    private Button mBtnConfirmPpeEnv;
    private Button mBtnDump;
    private Button mBtnMockPreCheckPerformance;
    private Button mBtnShareToGallery;
    private Button mBtnShareToNotes;
    private Button mBtnStart;
    private Button mBtnStop;
    private Button mBtnTaskList;
    private Button mBtnTestCloudConfig;
    private Button mBtnTestCpuExceptionConfig;
    private Button mBtnTestPowerMonitorConfig;
    private ODropdownTrigger mDropEnvironmentType;
    private ODropdownTrigger mDropModelType;
    private final com.obric.autoaction.userreport.a mEoSUserReportController;
    private File mGallerySavFile;
    private FrameLayout mLoadingBar;
    private final int mSaveMode;
    private OTextView mTvEarlyTermReason;
    private OTextView mTvPacificNotice;
    private OInputView mTvTask;
    private OInputView mTxtPpeEnv;
    private OSwitch mUsingMemory;
    private final String targetAppPackageName;
    private final List<String> vlmList;

    /* JADX INFO: compiled from: DebugActivity.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final DebugActivity a() {
            return (DebugActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DebugActivity.access$getInstance$cp(), "com.obric.aiagent.plugin"), DebugActivity.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: DebugActivity.kt */
    public static final class b implements PrivacyStatementActivity.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DebugActivity f22602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SharedPreferences f22603b;

        b(DebugActivity r3, SharedPreferences r4) {
            DebugActivity r5 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r3, DebugActivity.class, "com.obric.aiagent.plugin");
            SharedPreferences r6 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r4, SharedPreferences.class, "com.obric.aiagent.plugin");
            this.f22602a = r5;
            this.f22603b = r6;
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.c
        public boolean a(Activity r3) {
            return PrivacyStatementActivity.c.a.a(this, (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.c
        public boolean b(Activity r3) {
            return PrivacyStatementActivity.c.a.b(this, (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.c
        public void a() {
            this.f22602a.finish();
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.c
        public void b() {
            this.f22603b.edit().putBoolean("read_notice", true).apply();
        }
    }

    /* JADX INFO: compiled from: DebugActivity.kt */
    @d.c.b.a.f(b = "DebugActivity.kt", c = {BDAbstractUpload.KeyIsSocketReadTimeout}, d = "invokeSuspend", e = "com.obric.autoaction.DebugActivity$onCreateInternal$12$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22604a;

        c(d.c.d<? super c> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r21) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f22604a;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            o.a(r21);
            Object r0 = r21;
        L13:
            TimerTaskResult r3 = (TimerTaskResult) ZeusTransformUtils.preCheckCast(r0, TimerTaskResult.class, "com.obric.aiagent.plugin");
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r21);
            ILegacyTimerApi r4 = (ILegacyTimerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ILegacyTimerApi.class), ILegacyTimerApi.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L15;
            TimerTask r15 = new TimerTask("* */8 * * * ?", null, new TimerTaskAction("打开浏览器搜今天天气Mock Timer", null, 2, null).toString(), null, null, null, null, null, ao.a(new d.m[]{s.a("timeCondition", "每8小时 Mock Timer"), s.a(DownloadConstants.QUERY_KEY, "打开浏览器搜今天天气Mock Timer")}), ItemTouchHelper.a.DEFAULT_SWIPE_ANIMATION_DURATION, null);
            d.c.d<? super TimerTaskResult> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22604a = 1;
            r0 = r4.addTimerTask(r15, r5);
            if (r0 != r1) goto L13;
            return r1;
        }
    }

    /* JADX INFO: compiled from: DebugActivity.kt */
    @d.c.b.a.f(b = "DebugActivity.kt", c = {370}, d = "invokeSuspend", e = "com.obric.autoaction.DebugActivity$onCreateInternal$9$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DebugActivity f22606b;

        /* JADX INFO: renamed from: com.obric.autoaction.DebugActivity$d$1, reason: invalid class name */
        /* JADX INFO: compiled from: DebugActivity.kt */
        @d.c.b.a.f(b = "DebugActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.DebugActivity$onCreateInternal$9$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f22607a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ DebugActivity f22608b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ File f22609c;

            AnonymousClass1(DebugActivity r3, File r4, d.c.d<? super AnonymousClass1> r5) {
                DebugActivity r6 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r3, DebugActivity.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22608b = r6;
                this.f22609c = r4;
                super(2, r7);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f22608b, this.f22609c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f22607a != 0) goto L13;
                o.a(r4);
                Button r5 = DebugActivity.access$getMBtnDump$p(this.f22608b);
                if (r5 == null) goto L8;
                r5.setEnabled(true);
            L8:
                if (this.f22609c == null) goto L11;
                AOFileUtil.INSTANCE.openFileManager((Context) ZeusTransformUtils.preCheckCast(this.f22608b, Context.class, "com.obric.aiagent.plugin"), this.f22609c);
            L11:
                return x.f38692a;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        d(DebugActivity r3, d.c.d<? super d> r4) {
            DebugActivity r5 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r3, DebugActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22606b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f22606b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22605a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            File r6 = (File) ZeusTransformUtils.preCheckCast(r5, File.class, "com.obric.aiagent.plugin");
            AOThreadingTools.INSTANCE.launchUI((m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f22606b, r6, null), m.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            com.obric.autogui.evaluation.a r7 = com.obric.autogui.evaluation.a.f29063a;
            d.c.d<? super File> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22605a = 1;
            r5 = r7.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: DebugActivity.kt */
    @d.c.b.a.f(b = "DebugActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.DebugActivity$onSessionEnded$1")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DebugActivity f22611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22612c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f22613d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f22614e;
        final /* synthetic */ String f;
        final /* synthetic */ int g;
        final /* synthetic */ String h;

        e(DebugActivity r3, String r4, String r5, String r6, String r7, int r8, String r9, d.c.d<? super e> r10) {
            DebugActivity r11 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r3, DebugActivity.class, "com.obric.aiagent.plugin");
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22611b = r11;
            this.f22612c = r4;
            this.f22613d = r5;
            this.f22614e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            super(2, r12);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f22611b, this.f22612c, this.f22613d, this.f22614e, this.f, this.g, this.h, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f22610a != 0) goto L41;
            o.a(r8);
            Button r9 = DebugActivity.access$getMBtnStart$p(this.f22611b);
            if (r9 == null) goto L7;
            r9.setEnabled(true);
        L7:
            OInputView r10 = DebugActivity.access$getMTvTask$p(this.f22611b);
            if (r10 == null) goto L10;
            r10.setEnabled(true);
        L10:
            ODropdownTrigger r11 = DebugActivity.access$getMDropModelType$p(this.f22611b);
            if (r11 == null) goto L13;
            r11.setEnabled(true);
        L13:
            ODropdownTrigger r12 = DebugActivity.access$getMDropEnvironmentType$p(this.f22611b);
            if (r12 == null) goto L17;
            r12.setEnabled(true);
        L17:
            if (this.f22612c != null) goto L21;
            OTextView r13 = DebugActivity.access$getMTvEarlyTermReason$p(this.f22611b);
            if (r13 == null) goto L27;
            r13.setVisibility(8);
        L27:
            DebugActivity.access$getMEoSUserReportController$p(this.f22611b).a(new com.obric.autoaction.userreport.a.C0604a(this.f22613d, this.f22614e, this.f, this.g, this.h));
            if (this.f22612c == null) goto L39;
            StringBuilder r14 = new StringBuilder();
            r14.append("SessionId = " + this.f22613d);
            int r0 = this.g;
            if (r0 == 3) goto L39;
            if (r0 == 2) goto L39;
            int r1 = DebugActivity.access$terminationTypeToString(this.f22611b, r0);
            if (r1 == 0) goto L36;
            String r2 = this.f22611b.getString(r1);
        L37:
            d.h.b.o.a(r2);
            r14.append("\n推断失败原因：" + r2);
            r14.append("\n详细原因：" + this.f22612c);
            goto L39
        L36:
            r2 = "错误代码 " + this.g;
        L39:
            return x.f38692a;
        L21:
            OTextView r15 = DebugActivity.access$getMTvEarlyTermReason$p(this.f22611b);
            if (r15 == null) goto L24;
            r15.setText((CharSequence) ZeusTransformUtils.preCheckCast("前一回任务提前终止原因：" + this.f22612c, CharSequence.class, "com.obric.aiagent.plugin"));
        L24:
            OTextView r16 = DebugActivity.access$getMTvEarlyTermReason$p(this.f22611b);
            if (r16 == null) goto L27;
            r16.setVisibility(0);
            goto L27
        L41:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: DebugActivity.kt */
    @d.c.b.a.f(b = "DebugActivity.kt", c = {581}, d = "invokeSuspend", e = "com.obric.autoaction.DebugActivity$showClearResourceDialog$1$1")
    static final class f extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DebugActivity f22616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OTextView f22617c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f22618d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f22619e;

        /* JADX INFO: compiled from: DebugActivity.kt */
        @d.c.b.a.f(b = "DebugActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.DebugActivity$showClearResourceDialog$1$1$result$1")
        static final class a extends l implements m<am, d.c.d<? super n>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f22620a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ DebugActivity f22621b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f22622c;

            a(DebugActivity r3, String r4, d.c.d<? super a> r5) {
                DebugActivity r6 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r3, DebugActivity.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22621b = r6;
                this.f22622c = r4;
                super(2, r7);
            }

            public final Object a(am r3, d.c.d<? super n> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f22621b, this.f22622c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super n> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r10) {
                d.c.a.b.a();
                if (this.f22620a != 0) goto L11;
                o.a(r10);
                IJSScriptService r11 = (IJSScriptService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJSScriptService.class), IJSScriptService.class, "com.obric.aiagent.plugin");
                if (r11 == null) goto L9;
                n r12 = r11.clearLocalResource((Context) ZeusTransformUtils.preCheckCast(this.f22621b, Context.class, "com.obric.aiagent.plugin"), this.f22622c);
                if (r12 == null) goto L9;
                return r12;
            L9:
                return ac.a(ac.f30597a, (Context) ZeusTransformUtils.preCheckCast(this.f22621b, Context.class, "com.obric.aiagent.plugin"), this.f22622c, null, null, 12, null);
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        f(DebugActivity r3, OTextView r4, String r5, String r6, d.c.d<? super f> r7) {
            DebugActivity r8 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r3, DebugActivity.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22616b = r8;
            this.f22617c = r4;
            this.f22618d = r5;
            this.f22619e = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f22616b, this.f22617c, this.f22618d, this.f22619e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22615a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L11:
            n r9 = (n) ZeusTransformUtils.preCheckCast(r8, n.class, "com.obric.aiagent.plugin");
            DebugActivity.access$refreshResourceVersionText(this.f22616b, this.f22617c);
            DebugActivity.access$showClearResourceResultToast(this.f22616b, this.f22618d, r9);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            d.c.g r10 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin");
            m r2 = (m) ZeusTransformUtils.preCheckCast(new a(this.f22616b, this.f22619e, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22615a = 1;
            r8 = i.a(r10, r2, r4);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: DebugActivity.kt */
    @d.c.b.a.f(b = "DebugActivity.kt", c = {685}, d = "invokeSuspend", e = "com.obric.autoaction.DebugActivity$testConfigRead$1")
    static final class g extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DebugActivity f22624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22625c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f22626d;

        /* JADX INFO: compiled from: DebugActivity.kt */
        @d.c.b.a.f(b = "DebugActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.DebugActivity$testConfigRead$1$configJson$1")
        static final class a extends l implements m<am, d.c.d<? super JSONObject>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f22627a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f22628b;

            a(String r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22628b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super JSONObject> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f22628b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super JSONObject> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                d.c.a.b.a();
                if (this.f22627a != 0) goto L7;
                o.a(r2);
                return ICloudConfig.Companion.getSettingsConfig(this.f22628b);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        g(DebugActivity r3, String r4, d.c.d<? super g> r5) {
            DebugActivity r6 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r3, DebugActivity.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22624b = r6;
            this.f22625c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            g r0 = new g(this.f22624b, this.f22625c, r6);
            r0.f22626d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22623a;
            if (r1 == 0) goto L10;
            if (r1 != 1) goto L9;
            am r2 = (am) ZeusTransformUtils.preCheckCast(this.f22626d, am.class, "com.obric.aiagent.plugin");
            o.a(r10);     // Catch: Exception -> L25
        L14:
            JSONObject r11 = (JSONObject) ZeusTransformUtils.preCheckCast(r10, JSONObject.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L25
            ILogDepend.Companion.d("CloudConfigTest", "Config read result: " + r11);     // Catch: Exception -> L25
            if (r11 == null) goto L23;
            DebugActivity r3 = this.f22624b;     // Catch: Exception -> L25
            String r4 = this.f22625c;     // Catch: Exception -> L25
            ILogDepend.Companion.d("CloudConfigTest", "Config content: " + r11);     // Catch: Exception -> L25
            String r12 = r11.toString(2);     // Catch: Exception -> L20
        L22:
            if (new AlertDialog.a((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin")).a((CharSequence) ZeusTransformUtils.preCheckCast("Config: " + r4, CharSequence.class, "com.obric.aiagent.plugin")).b((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")).a((CharSequence) ZeusTransformUtils.preCheckCast("OK", CharSequence.class, "com.obric.aiagent.plugin"), null).b() == null) goto L23;
        L28:
            return x.f38692a;
        L20:
            r12 = r11.toString();     // Catch: Exception -> L25
        L23:
            DebugActivity r13 = this.f22624b;     // Catch: Exception -> L25
            String r5 = this.f22625c;     // Catch: Exception -> L25
            ILogDepend.Companion.e("CloudConfigTest", "Config is null");     // Catch: Exception -> L25
            Toast.makeText((Context) ZeusTransformUtils.preCheckCast(r13, Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Config not found: " + r5, CharSequence.class, "com.obric.aiagent.plugin"), 0).show();     // Catch: Exception -> L25
            x r9 = x.f38692a;     // Catch: Exception -> L25
            goto L28
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            o.a(r10);
            am r14 = (am) ZeusTransformUtils.preCheckCast(this.f22626d, am.class, "com.obric.aiagent.plugin");
            d.c.g r6 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L25
            m r7 = (m) ZeusTransformUtils.preCheckCast(new a(this.f22625c, null), m.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L25
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L25
            this.f22626d = r14;     // Catch: Exception -> L25
            this.f22623a = 1;     // Catch: Exception -> L25
            r10 = i.a(r6, r7, r8);     // Catch: Exception -> L25
            if (r10 != r0) goto L14;
            return r0;
        L25:
            e = move-exception;
            ILogDepend.Companion.e("CloudConfigTest", "Failed to read config", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            Toast.makeText((Context) ZeusTransformUtils.preCheckCast(this.f22624b, Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Failed to read config: " + e.getMessage(), CharSequence.class, "com.obric.aiagent.plugin"), 0).show();
            goto L28
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$-VW55qgTFlFQfHSA3XzQF6AAUHI, reason: not valid java name */
    public static /* synthetic */ void m431lambda$VW55qgTFlFQfHSA3XzQF6AAUHI(DebugActivity r0, k r1, String r2) {
        reloadVlmConfig$lambda$4$lambda$3$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$14KvDkWBOvV0wtEdarNbBoz3BDY(DebugActivity r0, OTextView r1, String r2, String r3, DialogInterface r4, int r5) {
        showClearResourceDialog$lambda$43(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$6UDuFTuYTBGtXH6p3FundWzX0-Q, reason: not valid java name */
    public static /* synthetic */ void m432lambda$6UDuFTuYTBGtXH6p3FundWzX0Q(DebugActivity r0, OTextView r1, View r2) {
        onCreateInternal$lambda$30(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$8mi5X9Nsg7fQmJwRqwhMaqR8Qow(DebugActivity r0, k r1, String r2) {
        reloadEnvironmentConfig$lambda$7$lambda$6$lambda$5(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$AI97JOoePc7fpsQnlWmJ_cBtDz4(DebugActivity r0, View r1) {
        onCreateInternal$lambda$28(r0, r1);
    }

    public static /* synthetic */ void lambda$AzScZ2lJzUSWhcHnjZrbQtaMxvM(DebugActivity r0, CompoundButton r1, boolean r2) {
        onCreateInternal$lambda$13(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$BtS6nMljKy8YXLVI4IEnqxmQR40(DebugActivity r0, OTextView r1, View r2) {
        onCreateInternal$lambda$31(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$EmDAsJjLDe162_cOTcsWUt6dUHg(DebugActivity r0, View r1) {
        onCreateInternal$lambda$33(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$HYmU-pXsnc8GZlwzB0Z2NUo_f0U, reason: not valid java name */
    public static /* synthetic */ void m433lambda$HYmUpXsnc8GZlwzB0Z2NUo_f0U(EditText r0, DebugActivity r1, DialogInterface r2, int r3) {
        showPasswordDialog$lambda$0(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$L4cdBm97Y2YRPrQpqWzmZF8VGkA(DebugActivity r0, View r1) {
        onCreateInternal$lambda$32(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$OCKZRl6Ivi4_i0MAggtwcDTkP-o, reason: not valid java name */
    public static /* synthetic */ void m434lambda$OCKZRl6Ivi4_i0MAggtwcDTkPo(View r0) {
        onCreateInternal$lambda$26(r0);
    }

    public static /* synthetic */ void lambda$Rxb7pWrxDMpYWN3Ryx4zkDh5WMg(View r0) {
        onCreateInternal$lambda$27(r0);
    }

    /* JADX INFO: renamed from: lambda$amtBWtLsg9nUgoRSsJIMz-CxKfc, reason: not valid java name */
    public static /* synthetic */ void m435lambda$amtBWtLsg9nUgoRSsJIMzCxKfc(EditText r0, EditText r1, EditText r2, DebugActivity r3, SharedPreferences r4, AlertDialog r5, View r6) {
        showSetScriptFailureCountDialog$lambda$42$lambda$41(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void lambda$aySqeRyZ9SqK93x1DlTF_yaS9Lo(DebugActivity r0, String r1, View r2) {
        onCreateInternal$lambda$15$lambda$14(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$bKCRzQiBLUMoWkXy9-m5vk5XDF0, reason: not valid java name */
    public static /* synthetic */ void m436lambda$bKCRzQiBLUMoWkXy9m5vk5XDF0(DebugActivity r0) {
        onSessionStarted$lambda$54(r0);
    }

    public static /* synthetic */ void lambda$hUW_xLCURvwPS2R4K4b8o_Uu6v8(AlertDialog r0, EditText r1, EditText r2, EditText r3, DebugActivity r4, SharedPreferences r5, DialogInterface r6) {
        showSetScriptFailureCountDialog$lambda$42(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void lambda$jGPw0aInOfYcOGmIcQNYqhuEacI(DebugActivity r0, View r1) {
        onCreateInternal$lambda$36(r0, r1);
    }

    public static /* synthetic */ void lambda$kqorn9GfHYXqhtkiu3_0DbscGBs(DebugActivity r0, View r1) {
        onCreateInternal$lambda$20(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$o8zYfE5z95WIu-8an95sTBzJO1Y, reason: not valid java name */
    public static /* synthetic */ void m437lambda$o8zYfE5z95WIu8an95sTBzJO1Y(DebugActivity r0, View r1) {
        onCreateInternal$lambda$12$lambda$11(r0, r1);
    }

    public static /* synthetic */ void lambda$pHvh79nwMxHsgrQPU2xA6HGdo9c(DebugActivity r0, View r1) {
        onCreateInternal$lambda$22(r0, r1);
    }

    public static /* synthetic */ void lambda$phF2Ys00NsqcB81N5G2dL6nYZl8(View r0) {
        onCreateInternal$lambda$29(r0);
    }

    /* JADX INFO: renamed from: lambda$rCpIFJEnvDm14-E8d2HIX6-lsLk, reason: not valid java name */
    public static /* synthetic */ void m438lambda$rCpIFJEnvDm14E8d2HIX6lsLk(DebugActivity r0, DialogInterface r1, int r2) {
        showPasswordDialog$lambda$1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$t4P-xYOaxlLho1IJW_DPqQXy3Dg, reason: not valid java name */
    public static /* synthetic */ void m439lambda$t4PxYOaxlLho1IJW_DPqQXy3Dg(DebugActivity r0, View r1) {
        onCreateInternal$lambda$16(r0, r1);
    }

    public static /* synthetic */ void lambda$uWgDm8ooL_zjw7ZcK5OAa4b2Zfc(DebugActivity r0, View r1) {
        onCreateInternal$lambda$35(r0, r1);
    }

    public static /* synthetic */ x lambda$ul6b85EYbY64aBotYs_KdQ8kEFA(DialogInterface r0, int r1) {
        return showInfoDialog$lambda$55(r0, r1);
    }

    public static /* synthetic */ void lambda$vKdd2IDp_g1gI2Y1kNSW7PJukB0(DebugActivity r0, View r1) {
        onCreateInternal$lambda$34(r0, r1);
    }

    public static /* synthetic */ void lambda$w4uMmhi_i14BOsX8rQ7N_dsCuUo(DebugActivity r0, View r1) {
        onCreateInternal$lambda$25(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$wm4iiyaVDP8XC-97VY6p4P6n3bE, reason: not valid java name */
    public static /* synthetic */ void m440lambda$wm4iiyaVDP8XC97VY6p4P6n3bE(DebugActivity r0, View r1) {
        onCreateInternal$lambda$21(r0, r1);
    }

    public static /* synthetic */ void lambda$znD88AI4Z7dN6vORaCQD5MjGtMg(DebugActivity r0, View r1) {
        onCreateInternal$lambda$18(r0, r1);
    }

    public final void onFinalStep(String r1) {
        d.h.b.o.e(r1, VDPlayerEffectProviderImpl.KEY_THOUGHT);
    }

    public DebugActivity() {
        this.vlmList = p.b(new String[]{"UI-Tars", "GUI-Thinker"});
        this.environmentList = p.b(new String[]{"线上(体验和测试)", "PPE(服务端联调)", "测试环境(MTBF，评测，自动化测试对应)"});
        this.builtDateFormat = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss", Locale.UK);
        this.mEoSUserReportController = new com.obric.autoaction.userreport.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        this.targetAppPackageName = "com.obric.notes";
        this.mSaveMode = 1;
    }

    public static final /* synthetic */ DebugActivity access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ Button access$getMBtnDump$p(DebugActivity r2) {
        return ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin")).mBtnDump;
    }

    public static final /* synthetic */ Button access$getMBtnStart$p(DebugActivity r2) {
        return ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin")).mBtnStart;
    }

    public static final /* synthetic */ ODropdownTrigger access$getMDropEnvironmentType$p(DebugActivity r2) {
        return ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin")).mDropEnvironmentType;
    }

    public static final /* synthetic */ ODropdownTrigger access$getMDropModelType$p(DebugActivity r2) {
        return ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin")).mDropModelType;
    }

    public static final /* synthetic */ com.obric.autoaction.userreport.a access$getMEoSUserReportController$p(DebugActivity r2) {
        return ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin")).mEoSUserReportController;
    }

    public static final /* synthetic */ OTextView access$getMTvEarlyTermReason$p(DebugActivity r2) {
        return ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin")).mTvEarlyTermReason;
    }

    public static final /* synthetic */ OInputView access$getMTvTask$p(DebugActivity r2) {
        return ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin")).mTvTask;
    }

    public static final /* synthetic */ void access$refreshResourceVersionText(DebugActivity r2, OTextView r3) {
        ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin")).refreshResourceVersionText(r3);
    }

    public static final /* synthetic */ void access$showClearResourceResultToast(DebugActivity r2, String r3, n r4) {
        ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin")).showClearResourceResultToast(r3, r4);
    }

    public static final /* synthetic */ int access$terminationTypeToString(DebugActivity r2, int r3) {
        return ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin")).terminationTypeToString(r3);
    }

    private final void showPasswordDialog() {
        if (IAppContext.Companion.isDebug() == false) goto L6;
        onCreateInternal();
        return;
    L6:
        AlertDialog.a r0 = new AlertDialog.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        r0.a((CharSequence) ZeusTransformUtils.preCheckCast("Enter Password to Proceed.", CharSequence.class, "com.obric.aiagent.plugin"));
        final EditText r1 = new EditText((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        r1.setInputType(129);
        r0.b((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"));
        r0.a((CharSequence) ZeusTransformUtils.preCheckCast("OK", CharSequence.class, "com.obric.aiagent.plugin"), new $$Lambda$DebugActivity$HYmUpXsnc8GZlwzB0Z2NUo_f0U(r1, this));
        r0.b((CharSequence) ZeusTransformUtils.preCheckCast("Cancel", CharSequence.class, "com.obric.aiagent.plugin"), new $$Lambda$DebugActivity$rCpIFJEnvDm14E8d2HIX6lsLk(this));
        r0.a(false);
        r0.b();
    }

    private static final void showPasswordDialog$lambda$0(EditText r1, DebugActivity r2, DialogInterface r3, int r4) {
        DebugActivity r5 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin");
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin");
        String r7 = r1.getText().toString();
        if (com.obric.autoaction.c.a.f24620a.a(r7) == false) goto L5;
        r6.dismiss();
        r5.onCreateInternal();
        return;
    L5:
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Incorrect Password", CharSequence.class, "com.obric.aiagent.plugin"), 0).show();
        r5.finish();
    }

    private static final void showPasswordDialog$lambda$1(DebugActivity r1, DialogInterface r2, int r3) {
        DebugActivity r4 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r1, DebugActivity.class, "com.obric.aiagent.plugin");
        ((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin")).cancel();
        r4.finish();
    }

    private final void reloadVlmConfig(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        final k r9 = com.obric.autogui.common.a.m.f28999a.a(r8);
        ODropdownTrigger r0 = this.mDropModelType;
        if (r0 == null) goto L6;
        com.obric.oui.dropdown.c r2 = new com.obric.oui.dropdown.c(this.vlmList, ((Number) ZeusTransformUtils.preCheckCast(r9.e().d(), Number.class, "com.obric.aiagent.plugin")).intValue());
        r2.a().add(new $$Lambda$DebugActivity$VW55qgTFlFQfHSA3XzQF6AAUHI(this, r9));
        r0.init((com.obric.oui.dropdown.b) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.dropdown.b.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(this.vlmList.get(((Number) ZeusTransformUtils.preCheckCast(r9.e().d(), Number.class, "com.obric.aiagent.plugin")).intValue()), CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    }

    private static final void reloadVlmConfig$lambda$4$lambda$3$lambda$2(DebugActivity r2, k r3, String r4) {
        DebugActivity r5 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "selectedValue");
        int r6 = r5.vlmList.indexOf(r4);
        r3.e().a(r6);
    }

    private final void refreshPpeEnvVisibility(k r5) {
        r5.h().a();
        if (((Number) ZeusTransformUtils.preCheckCast(r5.h().d(), Number.class, "com.obric.aiagent.plugin")).intValue() == 1) goto L5;
        int r6 = 8;
    L9:
        Button r0 = this.mBtnConfirmPpeEnv;
        if (r0 == null) goto L12;
        r0.setVisibility(r6);
    L12:
        OInputView r4 = this.mTxtPpeEnv;
        if (r4 == null) goto L16;
        r4.setVisibility(r6);
        return;
    L16:
        return;
    L5:
        OInputView r1 = this.mTxtPpeEnv;
        if (r1 == null) goto L8;
        r1.setText((String) ZeusTransformUtils.preCheckCast(r5.l().d(), String.class, "com.obric.aiagent.plugin"));
    L8:
        r6 = 0;
        goto L9
    }

    private final void reloadEnvironmentConfig(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        final k r9 = com.obric.autogui.common.a.m.f28999a.a(r8);
        ODropdownTrigger r0 = this.mDropEnvironmentType;
        if (r0 == null) goto L5;
        com.obric.oui.dropdown.c r2 = new com.obric.oui.dropdown.c(this.environmentList, ((Number) ZeusTransformUtils.preCheckCast(r9.h().d(), Number.class, "com.obric.aiagent.plugin")).intValue());
        r2.a().add(new $$Lambda$DebugActivity$8mi5X9Nsg7fQmJwRqwhMaqR8Qow(this, r9));
        r0.init((com.obric.oui.dropdown.b) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.dropdown.b.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(this.environmentList.get(((Number) ZeusTransformUtils.preCheckCast(r9.h().d(), Number.class, "com.obric.aiagent.plugin")).intValue()), CharSequence.class, "com.obric.aiagent.plugin"));
    L5:
        refreshPpeEnvVisibility(r9);
    }

    private static final void reloadEnvironmentConfig$lambda$7$lambda$6$lambda$5(DebugActivity r2, k r3, String r4) {
        DebugActivity r5 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "selectedValue");
        int r6 = r5.environmentList.indexOf(r4);
        r3.h().a(r6);
        r5.refreshPpeEnvVisibility(r3);
    }

    public final void setLightStatusBarIcon(boolean r2) {
        int r0 = getWindow().getDecorView().getSystemUiVisibility();
        if (r2 == false) goto L5;
        int r3 = r0 | 8192;
    L6:
        getWindow().getDecorView().setSystemUiVisibility(r3);
        return;
    L5:
        r3 = r0 & (-8193);
        goto L6
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r1) {
        instance = this;
        super.onCreate(r1);
        showPasswordDialog();
    }

    private final void onCreateInternal() {
        setContentView(ZeusTransformUtils.mapRes(R.layout.activity_main, "layout", "activity_main"));
        boolean r0 = true;
        setLightStatusBarIcon(true);
        Window r3 = getWindow();
        if (r3 == null) goto L5;
        r3.setStatusBarColor(getColor(ZeusTransformUtils.mapRes(R.color.oui_bg_title_bar, "color", "oui_bg_title_bar")));
    L5:
        setContentView(ZeusTransformUtils.mapRes(R.layout.activity_main, "layout", "activity_main"));
        setLightStatusBarIcon(true);
        Window r1 = getWindow();
        if (r1 == null) goto L8;
        r1.setStatusBarColor(getColor(ZeusTransformUtils.mapRes(R.color.oui_bg_title_bar, "color", "oui_bg_title_bar")));
    L8:
        ((OTextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.tv_build, DbHelper.COL_ID, "tv_build")), OTextView.class, "com.obric.aiagent.plugin")).setText((CharSequence) ZeusTransformUtils.preCheckCast("Build: " + this.builtDateFormat.format(AOHostAppTools.INSTANCE.getBuildTime()), CharSequence.class, "com.obric.aiagent.plugin"));
        this.mBtnStart = (Button) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.btn_start, DbHelper.COL_ID, "btn_start")), Button.class, "com.obric.aiagent.plugin");
        this.mBtnStop = (Button) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.btn_stop, DbHelper.COL_ID, "btn_stop")), Button.class, "com.obric.aiagent.plugin");
        this.mTvEarlyTermReason = (OTextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.tv_early_term_reason, DbHelper.COL_ID, "tv_early_term_reason")), OTextView.class, "com.obric.aiagent.plugin");
        this.mBtnTestCloudConfig = (Button) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.btn_test_cloud_config, DbHelper.COL_ID, "btn_test_cloud_config")), Button.class, "com.obric.aiagent.plugin");
        this.mBtnTestPowerMonitorConfig = (Button) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.btn_test_power_monitor_config, DbHelper.COL_ID, "btn_test_power_monitor_config")), Button.class, "com.obric.aiagent.plugin");
        this.mBtnTestCpuExceptionConfig = (Button) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.btn_test_cpu_exception_config, DbHelper.COL_ID, "btn_test_cpu_exception_config")), Button.class, "com.obric.aiagent.plugin");
        this.mBtnMockPreCheckPerformance = (Button) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.btn_mock_pre_check_performance, DbHelper.COL_ID, "btn_mock_pre_check_performance")), Button.class, "com.obric.aiagent.plugin");
        OTextView r2 = (OTextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.tv_pacific_notice, DbHelper.COL_ID, "tv_pacific_notice")), OTextView.class, "com.obric.aiagent.plugin");
        this.mTvPacificNotice = r2;
        if (r2 == null) goto L11;
        r2.setText((CharSequence) ZeusTransformUtils.preCheckCast(AODeviceSpecificTools.INSTANCE.generateDeviceInfo() + AODeviceInfo.INSTANCE.generateDeviceInfoText(), CharSequence.class, "com.obric.aiagent.plugin"));
    L11:
        this.mTvTask = (OInputView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.tv_vlm_task, DbHelper.COL_ID, "tv_vlm_task")), OInputView.class, "com.obric.aiagent.plugin");
        String r4 = getSharedPreferences("autogui-test", 0).getString("remembered_task_name", "");
        if (r4 != null) goto L14;
    L16:
        r0 = false;
    L17:
        if (r0 == false) goto L21;
        OInputView r5 = this.mTvTask;
        if (r5 == null) goto L21;
        r5.setText(r4);
    L21:
        this.mDropModelType = (ODropdownTrigger) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.drp_model_selection, DbHelper.COL_ID, "drp_model_selection")), ODropdownTrigger.class, "com.obric.aiagent.plugin");
        this.mTxtPpeEnv = (OInputView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.txt_ppe_env, DbHelper.COL_ID, "txt_ppe_env")), OInputView.class, "com.obric.aiagent.plugin");
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_confirm_ppe_env, DbHelper.COL_ID, "btn_confirm_ppe_env"));
        ((Button) ZeusTransformUtils.preCheckCast(r6, Button.class, "com.obric.aiagent.plugin")).setOnClickListener(new $$Lambda$DebugActivity$o8zYfE5z95WIu8an95sTBzJO1Y(this));
        this.mBtnConfirmPpeEnv = (Button) ZeusTransformUtils.preCheckCast(r6, Button.class, "com.obric.aiagent.plugin");
        this.mDropEnvironmentType = (ODropdownTrigger) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.drp_environment, DbHelper.COL_ID, "drp_environment")), ODropdownTrigger.class, "com.obric.aiagent.plugin");
        OSwitch r7 = (OSwitch) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.enable_memory_search, DbHelper.COL_ID, "enable_memory_search")), OSwitch.class, "com.obric.aiagent.plugin");
        this.mUsingMemory = r7;
        if (r7 == null) goto L24;
        r7.setOnCheckedChangeListener(new $$Lambda$DebugActivity$AzScZ2lJzUSWhcHnjZrbQtaMxvM(this));
    L24:
        OTextView r8 = (OTextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.tv_device_id, DbHelper.COL_ID, "tv_device_id")), OTextView.class, "com.obric.aiagent.plugin");
        final String r9 = "Device ID: " + AODeviceInfo.INSTANCE.getDeviceInfo().getDeviceId() + "\nRP-DeviceID: " + AODeviceInfo.INSTANCE.getRpDid();
        r8.setText((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"));
        r8.setOnClickListener(new $$Lambda$DebugActivity$aySqeRyZ9SqK93x1DlTF_yaS9Lo(this, r9));
        final OTextView r10 = (OTextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.tv_resource_version, DbHelper.COL_ID, "tv_resource_version")), OTextView.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r10);
        refreshResourceVersionText(r10);
        r10.setOnClickListener(new $$Lambda$DebugActivity$t4PxYOaxlLho1IJW_DPqQXy3Dg(this));
        reloadVlmConfig((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        reloadEnvironmentConfig((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        Button r11 = this.mBtnStart;
        if (r11 == null) goto L27;
        r11.setOnClickListener(new $$Lambda$DebugActivity$znD88AI4Z7dN6vORaCQD5MjGtMg(this));
    L27:
        Button r12 = this.mBtnStop;
        if (r12 == null) goto L30;
        r12.setOnClickListener(new $$Lambda$DebugActivity$kqorn9GfHYXqhtkiu3_0DbscGBs(this));
    L30:
        Button r13 = (Button) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.btn_dump, DbHelper.COL_ID, "btn_dump")), Button.class, "com.obric.aiagent.plugin");
        this.mBtnDump = r13;
        if (r13 == null) goto L33;
        r13.setOnClickListener(new $$Lambda$DebugActivity$wm4iiyaVDP8XC97VY6p4P6n3bE(this));
    L33:
        this.mBtnShareToNotes = (Button) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.btn_share_to_notes, DbHelper.COL_ID, "btn_share_to_notes")), Button.class, "com.obric.aiagent.plugin");
        this.mBtnShareToGallery = (Button) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.btn_share_to_gallery, DbHelper.COL_ID, "btn_share_to_gallery")), Button.class, "com.obric.aiagent.plugin");
        Button r14 = this.mBtnShareToNotes;
        if (r14 == null) goto L36;
        r14.setVisibility(8);
    L36:
        Button r15 = this.mBtnShareToGallery;
        if (r15 == null) goto L39;
        r15.setVisibility(8);
    L39:
        this.mBtnTaskList = (Button) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.btn_go_task_list, DbHelper.COL_ID, "btn_go_task_list")), Button.class, "com.obric.aiagent.plugin");
        this.mLoadingBar = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.progress_bar_container, DbHelper.COL_ID, "progress_bar_container")), FrameLayout.class, "com.obric.aiagent.plugin");
        Button r16 = (Button) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.btn_hook_toggle, DbHelper.COL_ID, "btn_hook_toggle")), Button.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L42;
        r16.setOnClickListener(new $$Lambda$DebugActivity$pHvh79nwMxHsgrQPU2xA6HGdo9c(this));
    L42:
        IAutoActionAppUpgradeApi r17 = (IAutoActionAppUpgradeApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionAppUpgradeApi.class), IAutoActionAppUpgradeApi.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L45;
        r17.bindActivity((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"), (androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin"));
    L45:
        AutoActionDatabase.f29019e.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        findViewById(ZeusTransformUtils.mapRes(R.id.btn_go_island, DbHelper.COL_ID, "btn_go_island")).setOnClickListener(new $$Lambda$DebugActivity$w4uMmhi_i14BOsX8rQ7N_dsCuUo(this));
        findViewById(ZeusTransformUtils.mapRes(R.id.add_old_timer_task, DbHelper.COL_ID, "add_old_timer_task")).setOnClickListener($$Lambda$DebugActivity$OCKZRl6Ivi4_i0MAggtwcDTkPo.INSTANCE);
        findViewById(ZeusTransformUtils.mapRes(R.id.clear_script_block_cache, DbHelper.COL_ID, "clear_script_block_cache")).setOnClickListener($$Lambda$DebugActivity$Rxb7pWrxDMpYWN3Ryx4zkDh5WMg.INSTANCE);
        findViewById(ZeusTransformUtils.mapRes(R.id.set_script_failure_count, DbHelper.COL_ID, "set_script_failure_count")).setOnClickListener(new $$Lambda$DebugActivity$AI97JOoePc7fpsQnlWmJ_cBtDz4(this));
        findViewById(ZeusTransformUtils.mapRes(R.id.clear_guide_keva, DbHelper.COL_ID, "clear_guide_keva")).setOnClickListener($$Lambda$DebugActivity$phF2Ys00NsqcB81N5G2dL6nYZl8.INSTANCE);
        findViewById(ZeusTransformUtils.mapRes(R.id.clear_script_resource, DbHelper.COL_ID, "clear_script_resource")).setOnClickListener(new $$Lambda$DebugActivity$6UDuFTuYTBGtXH6p3FundWzX0Q(this, r10));
        findViewById(ZeusTransformUtils.mapRes(R.id.clear_script_engine_resource, DbHelper.COL_ID, "clear_script_engine_resource")).setOnClickListener(new $$Lambda$DebugActivity$BtS6nMljKy8YXLVI4IEnqxmQR40(this, r10));
        Button r18 = this.mBtnTestCloudConfig;
        if (r18 == null) goto L48;
        r18.setOnClickListener(new $$Lambda$DebugActivity$L4cdBm97Y2YRPrQpqWzmZF8VGkA(this));
    L48:
        Button r19 = this.mBtnTestPowerMonitorConfig;
        if (r19 == null) goto L51;
        r19.setOnClickListener(new $$Lambda$DebugActivity$EmDAsJjLDe162_cOTcsWUt6dUHg(this));
    L51:
        Button r20 = this.mBtnTestCpuExceptionConfig;
        if (r20 == null) goto L54;
        r20.setOnClickListener(new $$Lambda$DebugActivity$vKdd2IDp_g1gI2Y1kNSW7PJukB0(this));
    L54:
        Button r21 = this.mBtnMockPreCheckPerformance;
        if (r21 == null) goto L57;
        r21.setOnClickListener(new $$Lambda$DebugActivity$uWgDm8ooL_zjw7ZcK5OAa4b2Zfc(this));
    L57:
        findViewById(ZeusTransformUtils.mapRes(R.id.btn_personal_search, DbHelper.COL_ID, "btn_personal_search")).setOnClickListener(new $$Lambda$DebugActivity$jGPw0aInOfYcOGmIcQNYqhuEacI(this));
        return;
    L14:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) != true) goto L16;
        goto L16
    }

    private static final void onCreateInternal$lambda$12$lambda$11(DebugActivity r4, View r5) {
        DebugActivity r6 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r4, DebugActivity.class, "com.obric.aiagent.plugin");
        k r7 = com.obric.autogui.common.a.m.f28999a.a((Context) ZeusTransformUtils.preCheckCast(r6, Context.class, "com.obric.aiagent.plugin"));
        OInputView r1 = r6.mTxtPpeEnv;
        if (r1 == null) goto L11;
        String r2 = r1.getText();
        if (r2 != null) goto L7;
        return;
    L7:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L9;
        return;
    L9:
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(r6, Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("已设置PPE环境为 " + r2, CharSequence.class, "com.obric.aiagent.plugin"), 0).show();
        r7.l().a(r2);
        return;
    }

    private static final void onCreateInternal$lambda$13(DebugActivity r2, CompoundButton r3, boolean r4) {
        DebugActivity r5 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin");
        com.obric.autogui.common.a.m.f28999a.a((Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.aiagent.plugin")).m().a(r4);
    }

    private static final void onCreateInternal$lambda$15$lambda$14(DebugActivity r3, String r4, View r5) {
        DebugActivity r6 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r3, DebugActivity.class, "com.obric.aiagent.plugin");
        Object r7 = r6.getSystemService("clipboard");
        d.h.b.o.a(r7, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) ZeusTransformUtils.preCheckCast(r7, ClipboardManager.class, "com.obric.aiagent.plugin")).setPrimaryClip(ClipData.newPlainText((CharSequence) ZeusTransformUtils.preCheckCast("Device Info", CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")));
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(r6, Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Copied to clipboard", CharSequence.class, "com.obric.aiagent.plugin"), 0).show();
    }

    private static final void onCreateInternal$lambda$16(DebugActivity r4, View r5) {
        DebugActivity r6 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r4, DebugActivity.class, "com.obric.aiagent.plugin");
        String r7 = w.f27103a.d();
        Object r1 = r6.getSystemService("clipboard");
        d.h.b.o.a(r1, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) ZeusTransformUtils.preCheckCast(r1, ClipboardManager.class, "com.obric.aiagent.plugin")).setPrimaryClip(ClipData.newPlainText((CharSequence) ZeusTransformUtils.preCheckCast("Resource Version", CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")));
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(r6, Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Copied to clipboard", CharSequence.class, "com.obric.aiagent.plugin"), 0).show();
    }

    private static final void onCreateInternal$lambda$18(DebugActivity r2, View r3) {
        DebugActivity r4 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin");
        OInputView r5 = r4.mTvTask;
        if (r5 == null) goto L6;
        String r6 = r5.getText();
        if (r6 == null) goto L6;
    L8:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L10;
        return;
    L10:
        r4.getSharedPreferences("autogui-test", 0).edit().putString("remembered_task_name", r6).apply();
        Intent r0 = new Intent("com.obric.autogui.evaluation.ACTION_EVAL");
        r0.putExtra("instruction", r6);
        r0.putExtra("need_feedback_ui", true);
        r4.mySendBroadcast(r0);
        return;
    L6:
        r6 = "";
        goto L8
    }

    private static final void onCreateInternal$lambda$20(DebugActivity r1, View r2) {
        ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r1, DebugActivity.class, "com.obric.aiagent.plugin")).mySendBroadcast(new Intent("com.obric.autogui.evaluation.ACTION_TERM"));
    }

    private static final void onCreateInternal$lambda$21(DebugActivity r7, View r8) {
        DebugActivity r9 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r7, DebugActivity.class, "com.obric.aiagent.plugin");
        Button r10 = r9.mBtnDump;
        if (r10 == null) goto L5;
        r10.setEnabled(false);
    L5:
        i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.a(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new d(r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private static final void onCreateInternal$lambda$22(DebugActivity r4, View r5) {
        DebugActivity r6 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r4, DebugActivity.class, "com.obric.aiagent.plugin");
        boolean r7 = com.obric.autogui.agents.vlm.models.impl.request.a.a.f28021a.a();
        com.obric.autogui.agents.vlm.models.impl.request.a.a.f28021a.a(!r7);
        AOUserInterfaceTools r1 = AOUserInterfaceTools.INSTANCE;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(r6, Context.class, "com.obric.aiagent.plugin");
        StringBuilder r2 = new StringBuilder().append("已 ");
        if (r7 == false) goto L5;
        String r9 = "关闭";
    L6:
        r1.showAppToast(r8, (CharSequence) ZeusTransformUtils.preCheckCast(r2.append(r9).append(" Hook Mode").toString(), CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r9 = "开启";
        goto L6
    }

    private static final void onCreateInternal$lambda$25(DebugActivity r3, View r4) {
        DebugActivity r5 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r3, DebugActivity.class, "com.obric.aiagent.plugin");
        Intent r6 = new Intent();
        r6.setAction("com.obric.appletapp.UPDATE_ALL_AIPACKAGE");
        r5.sendBroadcast(r6);
        Intent r7 = new Intent();
        r7.setClassName("com.obric.appletapp", "com.obric.appletapp.ui.HomeActivity");
        r7.addFlags(268435456);
        ZeusTransformUtils.startActivity(r5, r7, "com.obric.aiagent.plugin");
    }

    private static final void onCreateInternal$lambda$26(View r8) {
        i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new c(null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private static final void onCreateInternal$lambda$27(View r0) {
        com.obric.autogui.agents.scripted.impl.l.f27011a.b();
    }

    private static final void onCreateInternal$lambda$28(DebugActivity r1, View r2) {
        ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r1, DebugActivity.class, "com.obric.aiagent.plugin")).showSetScriptFailureCountDialog();
    }

    private static final void onCreateInternal$lambda$29(View r0) {
        com.obric.autoaction.app.launcherpage.utils.a.f24463a.a();
    }

    private static final void onCreateInternal$lambda$30(DebugActivity r1, OTextView r2, View r3) {
        DebugActivity r4 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r1, DebugActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r2);
        r4.showClearResourceDialog("剧本", "com.obric.ability.script", r2);
    }

    private static final void onCreateInternal$lambda$31(DebugActivity r1, OTextView r2, View r3) {
        DebugActivity r4 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r1, DebugActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r2);
        r4.showClearResourceDialog("引擎", "com.obric.script_engine", r2);
    }

    private static final void onCreateInternal$lambda$32(DebugActivity r1, View r2) {
        ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r1, DebugActivity.class, "com.obric.aiagent.plugin")).testCloudConfig();
    }

    private static final void onCreateInternal$lambda$33(DebugActivity r1, View r2) {
        ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r1, DebugActivity.class, "com.obric.aiagent.plugin")).testPowerMonitorConfig();
    }

    private static final void onCreateInternal$lambda$34(DebugActivity r1, View r2) {
        ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r1, DebugActivity.class, "com.obric.aiagent.plugin")).testCpuExceptionConfig();
    }

    private static final void onCreateInternal$lambda$35(DebugActivity r1, View r2) {
        ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r1, DebugActivity.class, "com.obric.aiagent.plugin")).mockPreCheckPerformanceTracking();
    }

    private static final void onCreateInternal$lambda$36(DebugActivity r3, View r4) {
        DebugActivity r5 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r3, DebugActivity.class, "com.obric.aiagent.plugin");
        ZeusTransformUtils.startActivity(r5, new Intent((Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.aiagent.plugin"), PersonalSearchActivity.class), "com.obric.aiagent.plugin");
    }

    private final void showSetScriptFailureCountDialog() {
        final SharedPreferences r8 = getSharedPreferences("autogui-test", 0);
        int r0 = com.obric.autogui.agents.scripted.impl.l.f27011a.a();
        final EditText r4 = new EditText((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        r4.setHint((CharSequence) ZeusTransformUtils.preCheckCast("Ability 名称", CharSequence.class, "com.obric.aiagent.plugin"));
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(r8.getString("script_block_ability", ""), CharSequence.class, "com.obric.aiagent.plugin"));
        r4.setSingleLine(true);
        final EditText r6 = new EditText((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        r6.setHint((CharSequence) ZeusTransformUtils.preCheckCast("Implementation 名称", CharSequence.class, "com.obric.aiagent.plugin"));
        r6.setText((CharSequence) ZeusTransformUtils.preCheckCast(r8.getString("script_block_implementation", ""), CharSequence.class, "com.obric.aiagent.plugin"));
        r6.setSingleLine(true);
        final EditText r7 = new EditText((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        r7.setHint((CharSequence) ZeusTransformUtils.preCheckCast("失败次数", CharSequence.class, "com.obric.aiagent.plugin"));
        r7.setInputType(2);
        r7.setText((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r8.getInt("script_block_failure_count", r0)), CharSequence.class, "com.obric.aiagent.plugin"));
        r7.setSingleLine(true);
        LinearLayout r5 = new LinearLayout((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        r5.setOrientation(1);
        float r9 = 24;
        r5.setPadding(d.i.a.a(TypedValue.applyDimension(1, r9, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r9, Resources.getSystem().getDisplayMetrics())), 0);
        r5.addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        r5.addView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));
        r5.addView((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"));
        final AlertDialog r1 = new AlertDialog.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")).a((CharSequence) ZeusTransformUtils.preCheckCast("设置剧本失败次数", CharSequence.class, "com.obric.aiagent.plugin")).b((CharSequence) ZeusTransformUtils.preCheckCast("永久 block 按 Ability + Implementation 记录；失败次数达到 " + r0 + " 时生效，填 0 可清除该条记录。", CharSequence.class, "com.obric.aiagent.plugin")).b((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin")).b((CharSequence) ZeusTransformUtils.preCheckCast("取消", CharSequence.class, "com.obric.aiagent.plugin"), null).a((CharSequence) ZeusTransformUtils.preCheckCast("设置", CharSequence.class, "com.obric.aiagent.plugin"), null).a();
        d.h.b.o.c(r1, "create(...)");
        r1.setOnShowListener(new $$Lambda$DebugActivity$hUW_xLCURvwPS2R4K4b8o_Uu6v8(r1, r4, r6, r7, this, r8));
        r1.show();
    }

    private static final void showSetScriptFailureCountDialog$lambda$42(final AlertDialog r9, final EditText r10, final EditText r11, final EditText r12, DebugActivity r13, SharedPreferences r14, DialogInterface r15) {
        final DebugActivity r6 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r13, DebugActivity.class, "com.obric.aiagent.plugin");
        final SharedPreferences r7 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r14, SharedPreferences.class, "com.obric.aiagent.plugin");
        DialogInterface r16 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r15, DialogInterface.class, "com.obric.aiagent.plugin");
        r9.getButton(-1).setOnClickListener(new $$Lambda$DebugActivity$amtBWtLsg9nUgoRSsJIMzCxKfc(r10, r11, r12, r6, r7, r9));
    }

    private static final void showSetScriptFailureCountDialog$lambda$42$lambda$41(EditText r4, EditText r5, EditText r6, DebugActivity r7, SharedPreferences r8, AlertDialog r9, View r10) {
        DebugActivity r11 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r7, DebugActivity.class, "com.obric.aiagent.plugin");
        SharedPreferences r12 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r8, SharedPreferences.class, "com.obric.aiagent.plugin");
        String r13 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4.getText().toString(), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        String r14 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5.getText().toString(), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        Integer r15 = d.o.o.d(r6.getText().toString());
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r16 = true;
    L6:
        if (r16 == false) goto L8;
    L24:
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(r11, Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("请填写 Ability、Implementation 和失败次数", CharSequence.class, "com.obric.aiagent.plugin"), 0).show();
        return;
    L8:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L10;
        boolean r17 = true;
    L11:
        if (r17 == true) goto L24;
        if (r15 == null) goto L24;
        if (com.obric.autogui.agents.scripted.impl.l.f27011a.a(r13, r14, r15.intValue()) == true) goto L18;
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(r11, Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("设置失败，请重试", CharSequence.class, "com.obric.aiagent.plugin"), 0).show();
        return;
    L18:
        r12.edit().putString("script_block_ability", r13).putString("script_block_implementation", r14).putInt("script_block_failure_count", r15.intValue()).apply();
        boolean r18 = com.obric.autogui.agents.scripted.impl.l.f27011a.a(r13).contains(r14);
        Context r19 = (Context) ZeusTransformUtils.preCheckCast(r11, Context.class, "com.obric.aiagent.plugin");
        StringBuilder r20 = new StringBuilder().append("已设置失败次数为 ").append(r15).append("，当前");
        if (r18 == false) goto L21;
        String r21 = "已 block";
    L22:
        Toast.makeText(r19, (CharSequence) ZeusTransformUtils.preCheckCast(r20.append(r21).toString(), CharSequence.class, "com.obric.aiagent.plugin"), 1).show();
        r9.dismiss();
        return;
    L21:
        r21 = "未 block";
        goto L22
    L10:
        r17 = false;
        goto L11
    L5:
        r16 = false;
        goto L6
    }

    private final void refreshResourceVersionText(OTextView r3) {
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(w.f27103a.c(), CharSequence.class, "com.obric.aiagent.plugin"));
    }

    private final void showClearResourceDialog(final String r5, final String r6, final OTextView r7) {
        new AlertDialog.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")).a((CharSequence) ZeusTransformUtils.preCheckCast("删除本地" + r5 + "资源", CharSequence.class, "com.obric.aiagent.plugin")).b((CharSequence) ZeusTransformUtils.preCheckCast("会删除本地" + r5 + "资源文件、zip 缓存，以及资源管理 Keva 记录。下次触发后会重新下载。", CharSequence.class, "com.obric.aiagent.plugin")).b((CharSequence) ZeusTransformUtils.preCheckCast("取消", CharSequence.class, "com.obric.aiagent.plugin"), null).a((CharSequence) ZeusTransformUtils.preCheckCast("删除", CharSequence.class, "com.obric.aiagent.plugin"), new $$Lambda$DebugActivity$14KvDkWBOvV0wtEdarNbBoz3BDY(this, r7, r5, r6)).b();
    }

    private static final void showClearResourceDialog$lambda$43(DebugActivity r9, OTextView r10, String r11, String r12, DialogInterface r13, int r14) {
        DebugActivity r2 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r9, DebugActivity.class, "com.obric.aiagent.plugin");
        DialogInterface r15 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r13, DialogInterface.class, "com.obric.aiagent.plugin");
        i.a((am) ZeusTransformUtils.preCheckCast(q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(r2, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new f(r2, r10, r11, r12, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void showClearResourceResultToast(String r9, n r10) {
        if (r10.e() == false) goto L6;
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("已删除本地" + r9 + "资源", CharSequence.class, "com.obric.aiagent.plugin"), 1).show();
        return;
    L6:
        StringBuilder r0 = new StringBuilder();
        StringBuilder r3 = r0.append("packageName=" + r10.a());
        d.h.b.o.c(r3, "append(...)");
        d.h.b.o.c(r3.append('\n'), "append(...)");
        StringBuilder r4 = r0.append("failedPaths=" + r10.c().size());
        d.h.b.o.c(r4, "append(...)");
        d.h.b.o.c(r4.append('\n'), "append(...)");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r10.c(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        StringBuilder r6 = r0.append((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r6, "append(...)");
        d.h.b.o.c(r6.append('\n'), "append(...)");
        goto L8
    L10:
        StringBuilder r7 = r0.append("remainingPaths=" + r10.d().size());
        d.h.b.o.c(r7, "append(...)");
        d.h.b.o.c(r7.append('\n'), "append(...)");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r10.d(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        StringBuilder r11 = r0.append((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r11, "append(...)");
        d.h.b.o.c(r11.append('\n'), "append(...)");
        goto L12
    L14:
        String r1 = r0.toString();
        d.h.b.o.c(r1, "toString(...)");
        String r2 = d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        Object r12 = getSystemService("clipboard");
        if (ZeusTransformUtils.instanceOf(r12, ClipboardManager.class) == false) goto L17;
        ClipboardManager r13 = (ClipboardManager) ZeusTransformUtils.preCheckCast(r12, ClipboardManager.class, "com.obric.aiagent.plugin");
    L18:
        if (r13 == null) goto L20;
        r13.setPrimaryClip(ClipData.newPlainText((CharSequence) ZeusTransformUtils.preCheckCast("resource clear result", CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")));
    L20:
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("本地" + r9 + "资源删除不完整，失败 " + r10.c().size() + " 项，残留 " + r10.d().size() + " 项，路径已复制", CharSequence.class, "com.obric.aiagent.plugin"), 1).show();
        return;
    L17:
        r13 = null;
        goto L18
    }

    public final String extractPartAfterSeparator(String r7) {
        d.h.b.o.e(r7, "name");
        int r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), "__", 0, false, 6, null);
        if (r6 == (-1)) goto L5;
        String r8 = r7.substring(r6 + 2);
        d.h.b.o.c(r8, "substring(...)");
        return r8;
    L5:
        return "";
    }

    private final void testCloudConfig() {
        testConfigRead("obric_script_toggle_map");
    }

    private final void testPowerMonitorConfig() {
        testConfigRead("obric_performance_power_monitor_config");
    }

    private final void testCpuExceptionConfig() {
        testConfigRead("obric_performance_cpu_exception_diagnosis_config");
    }

    private final void mockPreCheckPerformanceTracking() {
        com.obric.autogui.agents.scripted.impl.q r0 = new com.obric.autogui.agents.scripted.impl.q("script_pre_check_performance");
        r0.a("get_script_engine", 15);
        r0.a("get_bundle_file", 8);
        r0.a("pre_check_script", 120);
        r0.a("get_manifest", 5);
        r0.a("ability_list", p.b(new String[]{"open_app", "click", "scroll"})).a("ability_count", 3).a("session_id", "mock_session_" + System.currentTimeMillis()).a("is_worker_cache_hit", true).a("init_status", "success");
        r0.a();
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("report mock pre-check performance event track", CharSequence.class, "com.obric.aiagent.plugin"), 0).show();
    }

    private final void testConfigRead(String r9) {
        ILogDepend.Companion.d("CloudConfigTest", "Start testing config read: " + r9);
        i.a((am) ZeusTransformUtils.preCheckCast(q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new g(this, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ActivityCompat.f
    public void onRequestPermissionsResult(int r7, String[] r8, int[] r9) {
        d.h.b.o.e(r8, "permissions");
        d.h.b.o.e(r9, "grantResults");
        super.onRequestPermissionsResult(r7, r8, r9);
        if (r7 == 101) goto L5;
        return;
    L5:
        if (r9.length != 0) goto L7;
        boolean r10 = true;
    L9:
        if ((!r10) == true) goto L11;
        return;
    L11:
        if (r9[0] != 0) goto L20;
        File r2 = this.mGallerySavFile;
        if (r2 != null) goto L15;
        return;
    L15:
        if (r2.exists() == false) goto L22;
        com.obric.autogui.util.a.a.a(com.obric.autogui.util.a.a.f31494a, (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), r2, false, 4, null);
        return;
    L22:
        return;
    L20:
        return;
    L7:
        r10 = false;
        goto L9
    }

    private final void saveToGallery(File r8) {
        this.mGallerySavFile = r8;
        com.obric.autogui.util.a.a.a(com.obric.autogui.util.a.a.f31494a, (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), r8, false, 4, null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        if (com.obric.autogui.util.a.a.f31494a.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")) == true) goto L12;
        com.obric.autogui.util.a.a.f31494a.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final void requestNotes(List<? extends File> r12, String r13) {
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L8;
        Object r2 = r15.next();
        if (((File) ZeusTransformUtils.preCheckCast(r2, File.class, "com.obric.aiagent.plugin")).exists() == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        boolean r1 = !((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin")).isEmpty();
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        boolean r5 = !r4;
        if (r1 == true) goto L21;
        if (r5 == true) goto L21;
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("要分享的文字和图片必须有其一", CharSequence.class, "com.obric.aiagent.plugin"), 0).show();
        return;
    L21:
        if (r1 == false) goto L26;
        if (r16.size() <= 1) goto L26;
        Intent r6 = new Intent("android.intent.action.SEND_MULTIPLE");
        r6.setType("image/*");
    L29:
        if (r1 == false) goto L42;
        List r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r8 = r16.iterator();
    L32:
        if (r8.hasNext() == false) goto L39;
        File r9 = (File) ZeusTransformUtils.preCheckCast(r8.next(), File.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L36;
        Uri r10 = ZeusTransformUtils.getUriForFile((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), getPackageName() + ".fileprovider", r9, "com.obric.aiagent.plugin");
        r6.addFlags(1);
        d.h.b.o.a(r10);
    L37:
        r7.add(r10);
        goto L32
    L36:
        r10 = Uri.fromFile(r9);
        d.h.b.o.a(r10);
        goto L37
    L39:
        if (r16.size() <= 1) goto L41;
        r6.putParcelableArrayListExtra("android.intent.extra.STREAM", new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")));
        goto L42
    L41:
        r6.putExtra("android.intent.extra.STREAM", (Parcelable) ZeusTransformUtils.preCheckCast(p.k(r7), Parcelable.class, "com.obric.aiagent.plugin"));
    L42:
        if (r5 == false) goto L44;
        r6.putExtra("android.intent.extra.TEXT", r13);
    L44:
        r6.addFlags(268435456);
        List<ResolveInfo> r17 = getPackageManager().queryIntentActivities(r6, 0);
        d.h.b.o.c(r17, "queryIntentActivities(...)");
        Iterator<ResolveInfo> r18 = r17.iterator();
    L46:
        if (r18.hasNext() == false) goto L51;
        if (d.h.b.o.a(((ResolveInfo) ZeusTransformUtils.preCheckCast(r18.next(), ResolveInfo.class, "com.obric.aiagent.plugin")).activityInfo.packageName, this.targetAppPackageName) == false) goto L46;
        r6.setPackage(this.targetAppPackageName);
        ZeusTransformUtils.startActivity(this, r6, "com.obric.aiagent.plugin");
        return;
    L51:
        Button r19 = this.mBtnShareToNotes;
        if (r19 == null) goto L55;
        CharSequence r110 = r19.getText();
        if (r110 == null) goto L55;
    L56:
        ZeusTransformUtils.startActivity(this, Intent.createChooser(r6, r110), "com.obric.aiagent.plugin");
        return;
    L55:
        r110 = (CharSequence) ZeusTransformUtils.preCheckCast("分享内容到便签", CharSequence.class, "com.obric.aiagent.plugin");
    L26:
        if (r1 == false) goto L28;
        Intent r11 = new Intent("android.intent.action.SEND");
        r11.setType("image/*");
        r6 = r11;
        goto L29
    L28:
        Intent r20 = new Intent("android.intent.action.SEND");
        r20.setType("text/plain");
        r6 = r20;
        goto L29
    L11:
        if (d.o.o.d(r3) == true) goto L14;
        r4 = false;
        goto L15
    }

    public final String generateThoughtContent() {
        List r11 = p.c((Collection) ZeusTransformUtils.preCheckCast(p.b((Iterable) ZeusTransformUtils.preCheckCast(new d.l.c('a', 'z'), Iterable.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(new d.l.c('A', 'Z'), Iterable.class, "com.obric.aiagent.plugin")), Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(new d.l.c('0', '9'), Iterable.class, "com.obric.aiagent.plugin"));
        Random r0 = new Random();
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(new j(1, r0.nextInt(101) + 100), Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        ((al) ZeusTransformUtils.preCheckCast(r4, al.class, "com.obric.aiagent.plugin")).a();
        r3.add(Character.valueOf(((Character) ZeusTransformUtils.preCheckCast(r11.get(r0.nextInt(r11.size())), Character.class, "com.obric.aiagent.plugin")).charValue()));
        goto L4
    L7:
        return "" + p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        instance = null;
    }

    public final void onSessionStarted() {
        new Handler(Looper.getMainLooper()).post(new $$Lambda$DebugActivity$bKCRzQiBLUMoWkXy9m5vk5XDF0(this));
    }

    private static final void onSessionStarted$lambda$54(DebugActivity r2) {
        DebugActivity r3 = (DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin");
        Button r0 = r3.mBtnStart;
        if (r0 == null) goto L5;
        r0.setEnabled(false);
    L5:
        OInputView r1 = r3.mTvTask;
        if (r1 == null) goto L8;
        r1.setEnabled(false);
    L8:
        ODropdownTrigger r4 = r3.mDropModelType;
        if (r4 == null) goto L11;
        r4.setEnabled(false);
    L11:
        ODropdownTrigger r5 = r3.mDropEnvironmentType;
        if (r5 == null) goto L15;
        r5.setEnabled(false);
        return;
    }

    public final void onSessionEnded(String r12, int r13, String r14, String r15, String r16, String r17) {
        d.h.b.o.e(r14, ObricMemoryConstants.KEY_SESSION_ID);
        d.h.b.o.e(r15, "sessionKey");
        d.h.b.o.e(r16, "journalPath");
        d.h.b.o.e(r17, DownloadConstants.QUERY_KEY);
        AOThreadingTools.INSTANCE.launchUI((m) ZeusTransformUtils.preCheckCast(new e(this, r12, r14, r15, r16, r13, r17, null), m.class, "com.obric.aiagent.plugin"));
    }

    private final void maybeStartFirstTimePermissionNotice() {
        SharedPreferences r0 = getSharedPreferences("autogui-test", 0);
        if (r0.getBoolean("read_notice", false) == false) goto L5;
        return;
    L5:
        PrivacyStatementActivity.a.b r1 = new PrivacyStatementActivity.a.b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        String r2 = getString(ZeusTransformUtils.mapRes(R.string.app_welcome_text, WsChannelMultiProcessSharedProvider.STRING_TYPE, "app_welcome_text"));
        d.h.b.o.c(r2, "getString(...)");
        PrivacyStatementActivity.a.b r3 = r1.a(r2);
        String r4 = getString(ZeusTransformUtils.mapRes(R.string.app_welcome_desc, WsChannelMultiProcessSharedProvider.STRING_TYPE, "app_welcome_desc"));
        d.h.b.o.c(r4, "getString(...)");
        PrivacyStatementActivity.a.b r5 = r3.b(r4);
        String r6 = getString(ZeusTransformUtils.mapRes(R.string.cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "cancel"));
        d.h.b.o.c(r6, "getString(...)");
        PrivacyStatementActivity.a.b r7 = r5.c(r6);
        String r8 = getString(ZeusTransformUtils.mapRes(R.string.agree, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agree"));
        d.h.b.o.c(r8, "getString(...)");
        PrivacyStatementActivity.a.b r9 = r7.d(r8).a(ZeusTransformUtils.mapRes(R.drawable.auto_gui_logo, "drawable", "auto_gui_logo"));
        String r10 = getString(ZeusTransformUtils.mapRes(R.string.pacific_user_privacy_notice, WsChannelMultiProcessSharedProvider.STRING_TYPE, "pacific_user_privacy_notice"));
        d.h.b.o.c(r10, "getString(...)");
        r9.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).a((PrivacyStatementActivity.c) ZeusTransformUtils.preCheckCast(new b(this, r0), PrivacyStatementActivity.c.class, "com.obric.aiagent.plugin")).a();
    }

    private final void mySendBroadcast(Intent r4) {
        r4.setPackage(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName());
        sendBroadcast(r4);
    }

    private final void showInfoDialog() {
        com.obric.oui.dialog.alert.b r0 = new com.obric.oui.dialog.alert.b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")).a(ZeusTransformUtils.mapRes(R.string.app_name_localised, WsChannelMultiProcessSharedProvider.STRING_TYPE, "app_name_localised"));
        String r5 = getString(ZeusTransformUtils.mapRes(R.string.app_info_using_instruction, WsChannelMultiProcessSharedProvider.STRING_TYPE, "app_info_using_instruction"));
        d.h.b.o.c(r5, "getString(...)");
        com.obric.oui.dialog.alert.b r6 = r0.b((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin")).b(ZeusTransformUtils.mapRes(R.drawable.auto_gui_logo, "drawable", "auto_gui_logo"));
        float r1 = 44;
        com.obric.oui.dialog.alert.b.a(r6.a(d.i.a.a(TypedValue.applyDimension(1, r1, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r1, Resources.getSystem().getDisplayMetrics()))), false, 1, null).a(ZeusTransformUtils.mapRes(R.string.app_btn_close, WsChannelMultiProcessSharedProvider.STRING_TYPE, "app_btn_close"), $$Lambda$DebugActivity$ul6b85EYbY64aBotYs_KdQ8kEFA.INSTANCE).b(true).h();
    }

    private static final x showInfoDialog$lambda$55(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "dialog");
        r3.dismiss();
        return x.f38692a;
    }

    private final int terminationTypeToString(int r2) {
        switch(r2) {
            case 0: goto L13;
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            default: goto L4;
        };
    L4:
        return 0;
    L15:
        return ZeusTransformUtils.mapRes(R.string.term_type_api_request_bad_response, WsChannelMultiProcessSharedProvider.STRING_TYPE, "term_type_api_request_bad_response");
    L16:
        return ZeusTransformUtils.mapRes(R.string.term_type_api_request_timeout, WsChannelMultiProcessSharedProvider.STRING_TYPE, "term_type_api_request_timeout");
    L17:
        return ZeusTransformUtils.mapRes(R.string.term_type_api_request_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "term_type_api_request_failed");
    L18:
        return ZeusTransformUtils.mapRes(R.string.term_type_invalid_model_output, WsChannelMultiProcessSharedProvider.STRING_TYPE, "term_type_invalid_model_output");
    L19:
        return ZeusTransformUtils.mapRes(R.string.term_type_not_started_successfully, WsChannelMultiProcessSharedProvider.STRING_TYPE, "term_type_not_started_successfully");
    L20:
        return ZeusTransformUtils.mapRes(R.string.term_type_user_termination, WsChannelMultiProcessSharedProvider.STRING_TYPE, "term_type_user_termination");
    L21:
        return ZeusTransformUtils.mapRes(R.string.term_type_unspecified, WsChannelMultiProcessSharedProvider.STRING_TYPE, "term_type_unspecified");
    L13:
        return ZeusTransformUtils.mapRes(R.string.term_type_normal, WsChannelMultiProcessSharedProvider.STRING_TYPE, "term_type_normal");
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        IAutoActionAppUpgradeApi r2 = (IAutoActionAppUpgradeApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionAppUpgradeApi.class), IAutoActionAppUpgradeApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.onActivityResumed();
        return;
    }
}
