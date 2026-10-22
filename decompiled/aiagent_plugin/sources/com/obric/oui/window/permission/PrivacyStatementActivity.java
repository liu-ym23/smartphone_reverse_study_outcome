package com.obric.oui.window.permission;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.al;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.effects.VDPlayerEffectProviderImpl;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.sheet.v2.OSheet;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.h.a.m;
import d.h.a.q;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: PrivacyStatementActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
public class PrivacyStatementActivity extends AppCompatActivity {
    public static final a Companion = null;
    private static final String EXTRA_FLOATING_TRANSITION_ENABLED = "floatingTransitionEnabled";
    private static final String EXTRA__KEY_ACTIVITY_INSTANCE_ID = "PrivacyStatementActivityInstanceId";
    private static final String TAG = "PrivacyStatementActivity";
    private static final Map<String, a.AbstractC1007a> activityCustomizers = null;
    private static int counter;
    private static final Map<String, b> linkClickListeners = null;
    private static final Map<String, c> privacyConsentCallbacks = null;
    private static final Map<String, List<com.obric.oui.privacy.d>> privacyItems = null;
    private static final Map<String, List<String>> privacyPolicyLinkTextsList = null;
    private View contentChild;
    private ViewTreeObserver.OnPreDrawListener firstFramePreDrawListener;
    private boolean firstFrameReported;
    private View firstFrameTargetView;
    private boolean hasAgreed;
    private long onCreateStartElapsedRealtime;
    private com.obric.oui.privacy.a privacySheet;
    private View root;
    private boolean showNetworkConfirm;
    private boolean useLinkTextAsTitle;

    /* JADX INFO: compiled from: PrivacyStatementActivity.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.oui.window.permission.PrivacyStatementActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: PrivacyStatementActivity.kt */
        public static abstract class AbstractC1007a {
            public void a(Activity r2) {
                o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "activity");
            }

            public void a(Intent r1) {
                o.e(r1, MemorySourceLinkType.INTENT);
            }

            public void b(Activity r2) {
                o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "activity");
            }

            public void c(Activity r2) {
                o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "activity");
            }

            public void d(Activity r2) {
                o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "activity");
            }

            public void e(Activity r2) {
                o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "activity");
            }

            public void f(Activity r2) {
                o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "activity");
            }

            public AbstractC1007a() {
            }
        }

        /* JADX INFO: compiled from: PrivacyStatementActivity.kt */
        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Context f36908a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f36909b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private String f36910c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private String f36911d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private String f36912e;
            private CharSequence f;
            private List<String> g;
            private List<? extends com.obric.oui.privacy.d> h;
            private int i;
            private c j;
            private b k;
            private boolean l;
            private String[] m;
            private String n;
            private boolean o;
            private String p;
            private boolean q;
            private boolean r;
            private boolean s;
            private boolean t;
            private boolean u;

            public b(Context r4) {
                Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
                o.e(r5, "context");
                Context r6 = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
                this.f36908a = r6;
                String r7 = r6.getString(ZeusTransformUtils.mapRes(R.string.default_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "default_title"));
                o.c(r7, "context.getString(R.string.default_title)");
                this.f36909b = r7;
                this.g = p.b();
                this.h = p.b();
                this.i = ZeusTransformUtils.mapRes(R.drawable.ic_default_icon, "drawable", "ic_default_icon");
                this.l = true;
                this.m = new String[0];
                this.r = true;
                this.s = true;
            }

            public final b a(String r4) {
                o.e(r4, DBDefinition.TITLE);
                ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).f36909b = r4;
                return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
            }

            public final b b(String r4) {
                o.e(r4, "description");
                ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).f36910c = r4;
                return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
            }

            public final b c(String r4) {
                o.e(r4, "cancelText");
                ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).f36911d = r4;
                return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
            }

            public final b d(String r4) {
                o.e(r4, "agreeText");
                ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).f36912e = r4;
                return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
            }

            public final b a(CharSequence r4) {
                CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
                o.e(r5, "privacyText");
                ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).f = r5;
                return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
            }

            public final b a(int r4) {
                ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).i = r4;
                return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
            }

            public final b a(c r4) {
                c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
                o.e(r5, "callback");
                ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).j = r5;
                return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
            }

            public final void a() {
                a(null);
            }

            public final void a(AbstractC1007a r7) {
                com.obric.oui.d.a.b.b(PrivacyStatementActivity.TAG, VDPlayerEffectProviderImpl.METHOD_SHOW);
                Intent r0 = new Intent(this.f36908a, PrivacyStatementActivity.class);
                r0.putExtra(DBDefinition.TITLE, this.f36909b);
                r0.putExtra("description", this.f36910c);
                r0.putExtra("cancelText", this.f36911d);
                r0.putExtra("agreeText", this.f36912e);
                r0.putExtra("privacyText", this.f);
                r0.putExtra("iconResId", this.i);
                r0.putExtra(MonitorConstants.URLS, this.m);
                r0.putExtra("showNetworkConfirm", this.l);
                r0.putExtra("useLinkTextAsTitle", this.o);
                r0.putExtra("customPackageName", this.p);
                r0.putExtra("forceNightMode", this.q);
                r0.putExtra("enableDim", this.r);
                r0.putExtra("cancelable", this.s);
                r0.putExtra("enableEnterAnim", this.t);
                r0.putExtra(PrivacyStatementActivity.EXTRA_FLOATING_TRANSITION_ENABLED, this.u);
                String r1 = this.n;
                boolean r3 = true;
                if (r1 != null) goto L6;
            L4:
                r3 = false;
            L10:
                if (r3 == false) goto L12;
                r0.putExtra("customizedCancelText", this.n);
            L12:
                String r2 = a.a(PrivacyStatementActivity.Companion);
                r0.putExtra(PrivacyStatementActivity.EXTRA__KEY_ACTIVITY_INSTANCE_ID, r2);
                if (r7 == null) goto L15;
                PrivacyStatementActivity.access$getActivityCustomizers$cp().put(r2, r7);
                r7.a(r0);
            L15:
                PrivacyStatementActivity.access$getPrivacyItems$cp().put(r2, this.h);
                PrivacyStatementActivity.access$getPrivacyPolicyLinkTextsList$cp().put(r2, this.g);
                PrivacyStatementActivity.access$getPrivacyConsentCallbacks$cp().put(r2, this.j);
                PrivacyStatementActivity.access$getLinkClickListeners$cp().put(r2, this.k);
                ZeusTransformUtils.startActivity(this.f36908a, r0, "com.obric.aiagent.plugin");
                return;
            L6:
                if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L8;
                boolean r4 = true;
            L9:
                if (r4 != true) goto L4;
            L8:
                r4 = false;
                goto L9
            }
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ String a(a r0) {
            return r0.a();
        }

        private final String a() {
            StringBuilder r2 = new StringBuilder().append("PrivacyStatementActivity_").append(UUID.randomUUID()).append('_');
            int r0 = PrivacyStatementActivity.access$getCounter$cp();
            PrivacyStatementActivity.access$setCounter$cp(r0 + 1);
            return r2.append(r0).toString();
        }
    }

    /* JADX INFO: compiled from: PrivacyStatementActivity.kt */
    public interface b {
        void a(String r1, Context r2);
    }

    /* JADX INFO: compiled from: PrivacyStatementActivity.kt */
    public interface c {

        /* JADX INFO: compiled from: PrivacyStatementActivity.kt */
        public static final class a {
            public static boolean a(c r2, Activity r3) {
                c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
                Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
                o.e(r4, "this");
                o.e(r5, "activity");
                return false;
            }

            public static boolean b(c r2, Activity r3) {
                c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
                Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
                o.e(r4, "this");
                o.e(r5, "activity");
                return false;
            }
        }

        void a();

        boolean a(Activity r1);

        void b();

        boolean b(Activity r1);
    }

    /* JADX INFO: compiled from: PrivacyStatementActivity.kt */
    static final class d extends d.h.b.p implements q<Context, Integer, Integer, OButton> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f36918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<View, x> f36919b;

        d(String r3, d.h.a.b<? super View, x> r4) {
            d.h.a.b<View, x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
            this.f36918a = r3;
            this.f36919b = r5;
            super(3);
        }

        public static /* synthetic */ void lambda$lVMU_2_AxxoYmruclrhq2gBxxDk(d.h.a.b r0, View r1) {
            a(r0, r1);
        }

        @Override // d.h.a.q
        public /* synthetic */ OButton invoke(Context r3, Integer r4, Integer r5) {
            return a((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue());
        }

        public final OButton a(Context r10, int r11, int r12) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
            o.e(r2, "styledContext");
            OButton r13 = new OButton(r2, null, 0, 0, null, 28, null);
            String r14 = this.f36918a;
            final d.h.a.b<View, x> r9 = this.f36919b;
            r13.setText((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"));
            r13.setLayoutParams(new ViewGroup.LayoutParams(-1, r12));
            if (r9 != null) goto L5;
            View.OnClickListener r15 = null;
        L6:
            r13.setOnClickListener(r15);
            return r13;
        L5:
            r15 = new $$Lambda$PrivacyStatementActivity$d$lVMU_2_AxxoYmruclrhq2gBxxDk(r9);
            goto L6
        }

        private static final void a(d.h.a.b r2, View r3) {
            ((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3);
        }
    }

    /* JADX INFO: compiled from: PrivacyStatementActivity.kt */
    public static final class e implements com.obric.oui.privacy.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f36920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PrivacyStatementActivity f36921b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<String> f36922c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String[] f36923d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f36924e;
        final /* synthetic */ String f;

        /* JADX INFO: compiled from: PrivacyStatementActivity.kt */
        static final class a extends d.h.b.p implements m<DialogInterface, Integer, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ PrivacyStatementActivity f36925a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f36926b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ b f36927c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f36928d;

            a(PrivacyStatementActivity r3, String r4, b r5, String r6) {
                PrivacyStatementActivity r7 = (PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r3, PrivacyStatementActivity.class, "com.obric.aiagent.plugin");
                b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
                this.f36925a = r7;
                this.f36926b = r4;
                this.f36927c = r8;
                this.f36928d = r6;
                super(2);
            }

            @Override // d.h.a.m
            public /* synthetic */ x invoke(DialogInterface r3, Integer r4) {
                a((DialogInterface) ZeusTransformUtils.preCheckCast(r3, DialogInterface.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue());
                return x.f38692a;
            }

            public final void a(DialogInterface r5, int r6) {
                DialogInterface r7 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.class, "com.obric.aiagent.plugin");
                o.e(r7, "dialog");
                r7.dismiss();
                boolean r8 = true;
                PrivacyStatementActivity.access$setHasAgreed$p(this.f36925a, true);
                CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f36926b, CharSequence.class, "com.obric.aiagent.plugin");
                if (r9 != null) goto L5;
            L8:
                if (r8 == true) goto L16;
                b r10 = this.f36927c;
                if (r10 != null) goto L12;
                x r11 = null;
            L13:
                if (r11 != null) goto L17;
                PrivacyStatementActivity r12 = this.f36925a;
                String r0 = this.f36926b;
                o.c(r0, "url");
                PrivacyStatementActivity.access$openBrowser(r12, r0, this.f36928d);
                return;
            L17:
                return;
            L12:
                String r1 = this.f36926b;
                o.c(r1, "url");
                r10.a(r1, (Context) ZeusTransformUtils.preCheckCast(this.f36925a, Context.class, "com.obric.aiagent.plugin"));
                r11 = x.f38692a;
                goto L13
            L16:
                return;
            L5:
                if (r9.length() == 0) goto L8;
                r8 = false;
                goto L8
            }
        }

        /* JADX INFO: compiled from: PrivacyStatementActivity.kt */
        static final class b extends d.h.b.p implements m<DialogInterface, Integer, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f36929a = null;

            static {
                f36929a = new b();
            }

            b() {
                super(2);
            }

            @Override // d.h.a.m
            public /* synthetic */ x invoke(DialogInterface r3, Integer r4) {
                a((DialogInterface) ZeusTransformUtils.preCheckCast(r3, DialogInterface.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue());
                return x.f38692a;
            }

            public final void a(DialogInterface r1, int r2) {
                DialogInterface r0 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.aiagent.plugin");
                o.e(r0, "dialog");
                r0.dismiss();
            }
        }

        e(c r3, PrivacyStatementActivity r4, List<String> r5, String[] r6, b r7, String r8) {
            c r9 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
            PrivacyStatementActivity r10 = (PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r4, PrivacyStatementActivity.class, "com.obric.aiagent.plugin");
            List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            b r12 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.aiagent.plugin");
            this.f36920a = r9;
            this.f36921b = r10;
            this.f36922c = r11;
            this.f36923d = r6;
            this.f36924e = r12;
            this.f = r8;
        }

        @Override // com.obric.oui.privacy.c
        public void a() {
            c r0 = this.f36920a;
            boolean r1 = false;
            if (r0 != null) goto L6;
        L8:
            if (r1 == true) goto L18;
            c r2 = this.f36920a;
            if (r2 == null) goto L13;
            r2.b();
        L13:
            this.f36921b.onAgree();
            com.obric.oui.privacy.a r6 = PrivacyStatementActivity.access$getPrivacySheet$p(this.f36921b);
            if (r6 == null) goto L19;
            r6.b();
            return;
        L19:
            return;
        L18:
            return;
        L6:
            if (r0.a((Activity) ZeusTransformUtils.preCheckCast(this.f36921b, Activity.class, "com.obric.aiagent.plugin")) != true) goto L8;
            r1 = true;
            goto L8
        }

        @Override // com.obric.oui.privacy.c
        public void b() {
            c r0 = this.f36920a;
            boolean r1 = false;
            if (r0 != null) goto L6;
        L8:
            if (r1 == true) goto L18;
            c r2 = this.f36920a;
            if (r2 == null) goto L13;
            r2.a();
        L13:
            this.f36921b.onDisagree();
            com.obric.oui.privacy.a r6 = PrivacyStatementActivity.access$getPrivacySheet$p(this.f36921b);
            if (r6 == null) goto L19;
            r6.b();
            return;
        L19:
            return;
        L18:
            return;
        L6:
            if (r0.b((Activity) ZeusTransformUtils.preCheckCast(this.f36921b, Activity.class, "com.obric.aiagent.plugin")) != true) goto L8;
            r1 = true;
            goto L8
        }

        @Override // com.obric.oui.privacy.c
        public void a(String r9) {
            o.e(r9, "linkText");
            boolean r2 = true;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            return;
        L8:
            Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(this.f36922c, Collection.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L11;
        L14:
            boolean r3 = true;
        L15:
            if (r3 == false) goto L17;
            return;
        L17:
            String r10 = this.f36923d[this.f36922c.indexOf(r9)];
            if (PrivacyStatementActivity.access$getShowNetworkConfirm$p(this.f36921b) == true) goto L31;
            CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L22;
        L25:
            if (r2 == true) goto L48;
            b r5 = this.f36924e;
            if (r5 == null) goto L49;
            o.c(r10, "url");
            r5.a(r10, (Context) ZeusTransformUtils.preCheckCast(this.f36921b, Context.class, "com.obric.aiagent.plugin"));
            return;
        L49:
            return;
        L48:
            return;
        L22:
            if (r4.length() == 0) goto L25;
            r2 = false;
            goto L25
        L31:
            x r6 = null;
            if (PrivacyStatementActivity.access$getHasAgreed$p(this.f36921b) == false) goto L46;
            CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L36;
        L39:
            if (r2 == true) goto L50;
            b r8 = this.f36924e;
            if (r8 == null) goto L44;
            o.c(r10, "url");
            r8.a(r10, (Context) ZeusTransformUtils.preCheckCast(this.f36921b, Context.class, "com.obric.aiagent.plugin"));
            r6 = x.f38692a;
        L44:
            if (r6 != null) goto L51;
            PrivacyStatementActivity r11 = this.f36921b;
            o.c(r10, "url");
            PrivacyStatementActivity.access$openBrowser(r11, r10, this.f);
            return;
        L51:
            return;
        L50:
            return;
        L36:
            if (r7.length() == 0) goto L39;
            r2 = false;
            goto L39
        L46:
            com.obric.oui.dialog.v2.alert.a r12 = com.obric.oui.dialog.v2.alert.a.a(new com.obric.oui.dialog.v2.alert.a((Context) ZeusTransformUtils.preCheckCast(this.f36921b, Context.class, "com.obric.aiagent.plugin")).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(this.f36921b.getString(ZeusTransformUtils.mapRes(R.string.privacy_permisssion_dialog_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "privacy_permisssion_dialog_title")), CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(this.f36921b.getString(ZeusTransformUtils.mapRes(R.string.privacy_permisssion_dialog_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "privacy_permisssion_dialog_message")), CharSequence.class, "com.obric.aiagent.plugin"));
            String r13 = this.f36921b.getString(ZeusTransformUtils.mapRes(R.string.oui_agree, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_agree"));
            o.c(r13, "getString(R.string.oui_agree)");
            com.obric.oui.dialog.v2.alert.a r14 = r12.a((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new a(this.f36921b, r10, this.f36924e, this.f), m.class, "com.obric.aiagent.plugin"));
            String r15 = this.f36921b.getString(ZeusTransformUtils.mapRes(R.string.oui_cancel_only, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_cancel_only"));
            o.c(r15, "getString(R.string.oui_cancel_only)");
            ((OAlertDialog) ZeusTransformUtils.preCheckCast(r14.b((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(b.f36929a, m.class, "com.obric.aiagent.plugin")).g(), OAlertDialog.class, "com.obric.aiagent.plugin")).show();
            return;
        L11:
            if (r1.isEmpty() == true) goto L14;
            r3 = false;
            goto L15
        L5:
            r0 = false;
            goto L6
        }

        @Override // com.obric.oui.privacy.c
        public void c() {
            com.obric.oui.privacy.c.a.a((com.obric.oui.privacy.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.privacy.c.class, "com.obric.aiagent.plugin"));
            this.f36921b.onPageDismiss();
            PrivacyStatementActivity.access$clearCallbacksAndFinish(this.f36921b);
        }

        @Override // com.obric.oui.privacy.c
        public void d() {
            c r0 = this.f36920a;
            boolean r1 = false;
            if (r0 != null) goto L6;
        L8:
            if (r1 == true) goto L18;
            c r2 = this.f36920a;
            if (r2 == null) goto L13;
            r2.a();
        L13:
            this.f36921b.onDisagree();
            com.obric.oui.privacy.a r6 = PrivacyStatementActivity.access$getPrivacySheet$p(this.f36921b);
            if (r6 == null) goto L19;
            r6.b();
            return;
        L19:
            return;
        L18:
            return;
        L6:
            if (r0.b((Activity) ZeusTransformUtils.preCheckCast(this.f36921b, Activity.class, "com.obric.aiagent.plugin")) != true) goto L8;
            r1 = true;
            goto L8
        }
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ al lambda$1ANzXiodS2479Q1oZ46RpWHU4rg(View r0, al r1) {
        return m1243onContentChanged$lambda5$lambda4(r0, r1);
    }

    public boolean canFinishSelfInOnCreateIfCallbackNotSet() {
        return true;
    }

    public void onAgree() {
    }

    public void onDisagree() {
    }

    public void onPageDismiss() {
    }

    public PrivacyStatementActivity() {
        this.showNetworkConfirm = true;
    }

    public static final /* synthetic */ void access$clearCallbacksAndFinish(PrivacyStatementActivity r2) {
        ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.aiagent.plugin")).clearCallbacksAndFinish();
    }

    public static final /* synthetic */ Map access$getActivityCustomizers$cp() {
        return activityCustomizers;
    }

    public static final /* synthetic */ int access$getCounter$cp() {
        return counter;
    }

    public static final /* synthetic */ boolean access$getFirstFrameReported$p(PrivacyStatementActivity r2) {
        return ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.aiagent.plugin")).firstFrameReported;
    }

    public static final /* synthetic */ boolean access$getHasAgreed$p(PrivacyStatementActivity r2) {
        return ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.aiagent.plugin")).hasAgreed;
    }

    public static final /* synthetic */ Map access$getLinkClickListeners$cp() {
        return linkClickListeners;
    }

    public static final /* synthetic */ Map access$getPrivacyConsentCallbacks$cp() {
        return privacyConsentCallbacks;
    }

    public static final /* synthetic */ Map access$getPrivacyItems$cp() {
        return privacyItems;
    }

    public static final /* synthetic */ Map access$getPrivacyPolicyLinkTextsList$cp() {
        return privacyPolicyLinkTextsList;
    }

    public static final /* synthetic */ com.obric.oui.privacy.a access$getPrivacySheet$p(PrivacyStatementActivity r2) {
        return ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.aiagent.plugin")).privacySheet;
    }

    public static final /* synthetic */ boolean access$getShowNetworkConfirm$p(PrivacyStatementActivity r2) {
        return ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.aiagent.plugin")).showNetworkConfirm;
    }

    public static final /* synthetic */ void access$logPrivacySheetFirstFrame(PrivacyStatementActivity r2) {
        ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.aiagent.plugin")).logPrivacySheetFirstFrame();
    }

    public static final /* synthetic */ void access$openBrowser(PrivacyStatementActivity r2, String r3, String r4) {
        ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.aiagent.plugin")).openBrowser(r3, r4);
    }

    public static final /* synthetic */ void access$removeFirstFramePreDrawListener(PrivacyStatementActivity r2) {
        ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.aiagent.plugin")).removeFirstFramePreDrawListener();
    }

    public static final /* synthetic */ void access$setCounter$cp(int r0) {
        counter = r0;
    }

    public static final /* synthetic */ void access$setFirstFrameReported$p(PrivacyStatementActivity r2, boolean r3) {
        ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.aiagent.plugin")).firstFrameReported = r3;
    }

    public static final /* synthetic */ void access$setHasAgreed$p(PrivacyStatementActivity r2, boolean r3) {
        ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.aiagent.plugin")).hasAgreed = r3;
    }

    static {
        Companion = new a(null);
        privacyConsentCallbacks = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        linkClickListeners = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        activityCustomizers = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        privacyPolicyLinkTextsList = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        privacyItems = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r11) {
        this.onCreateStartElapsedRealtime = SystemClock.elapsedRealtime();
        if (getDelegate().getLocalNightMode() != 2) goto L5;
        boolean r0 = true;
    L7:
        if ((ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) != 32) goto L9;
        boolean r5 = true;
    L10:
        com.obric.oui.d.a.b.b(TAG, o.a("onCreate savedInstanceState: ", r11));
        com.obric.oui.d.a.b.b(TAG, o.a("onCreate delegate.localNightMode: ", Integer.valueOf(getDelegate().getLocalNightMode())));
        com.obric.oui.d.a.b.b(TAG, o.a("onCreate isLocalInNightMode: ", Boolean.valueOf(r0)));
        com.obric.oui.d.a.b.b(TAG, o.a("onCreate isConfigNightMode: ", Boolean.valueOf(r5)));
        boolean r1 = getIntent().getBooleanExtra("forceNightMode", false);
        com.obric.oui.d.a.b.b(TAG, o.a("onCreate forceNightMode: ", Boolean.valueOf(r1)));
        if (r5 == true) goto L14;
        if (r1 == false) goto L14;
        boolean r6 = true;
    L15:
        if (r11 != null) goto L18;
        if (r1 == false) goto L18;
        getIntent().putExtra("forceNightMode", false);
        getDelegate().setLocalNightMode(2);
    L18:
        super.onCreate(r11);
        if (r11 != null) goto L21;
    L24:
        getWindow().setWindowAnimations(0);
        overridePendingTransition(0, 0);
        String r2 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r2 == null) goto L32;
        a.AbstractC1007a r3 = (a.AbstractC1007a) ZeusTransformUtils.preCheckCast(activityCustomizers.get(r2), a.AbstractC1007a.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L32;
        r3.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"));
    L32:
        if (canFinishSelfInOnCreateIfCallbackNotSet() == false) goto L39;
        if (r11 == null) goto L39;
        com.obric.oui.d.a.b.d(TAG, "onCreate, savedInstanceState is not null");
        if (((c) ZeusTransformUtils.preCheckCast(privacyConsentCallbacks.get(getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID)), c.class, "com.obric.aiagent.plugin")) != null) goto L38;
        com.obric.oui.d.a.b.d(TAG, "privacyConsentCallbacks is null, finish");
        finish();
        return;
    L38:
        com.obric.oui.d.a.b.c(TAG, "privacyConsentCallbacks is not null");
    L39:
        Window r12 = getWindow();
        r12.clearFlags(1024);
        r12.setBackgroundDrawableResource(android.R.color.transparent);
        r12.getAttributes().format = -2;
        this.showNetworkConfirm = getIntent().getBooleanExtra("showNetworkConfirm", true);
        this.useLinkTextAsTitle = getIntent().getBooleanExtra("useLinkTextAsTitle", false);
        this.root = r12.getDecorView().getRootView();
        if (r6 == true) goto L43;
        Intent r13 = getIntent();
        o.c(r13, MemorySourceLinkType.INTENT);
        showSheetDialog(r13);
        getIntent().putExtra("finishShowSheet", true);
        return;
    L43:
        return;
    L21:
        if (getIntent().getBooleanExtra("finishShowSheet", false) == false) goto L24;
        com.obric.oui.d.a.b.b(TAG, "onCreate -> finish when savedInstanceState is not null and finishShowSheet is true");
        finish();
        return;
    L14:
        r6 = false;
        goto L15
    L9:
        r5 = false;
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    public final void showSheetDialog(Intent r24) {
        o.e(r24, MemorySourceLinkType.INTENT);
        String r1 = r24.getStringExtra(DBDefinition.TITLE);
        if (r1 != null) goto L5;
        r1 = getString(ZeusTransformUtils.mapRes(R.string.default_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "default_title"));
    L5:
        String r6 = r1;
        o.c(r6, "intent.getStringExtra(\"t…g(R.string.default_title)");
        String r11 = r24.getStringExtra("description");
        String r16 = r24.getStringExtra("cancelText");
        String r15 = r24.getStringExtra("agreeText");
        CharSequence r2 = r24.getCharSequenceExtra("privacyText");
        String[] r3 = r24.getStringArrayExtra(MonitorConstants.URLS);
        if (r3 != null) goto L8;
        r3 = new String[0];
    L8:
        String[] r4 = r3;
        boolean r17 = r24.getBooleanExtra("enableDim", true);
        boolean r18 = r24.getBooleanExtra("cancelable", true);
        boolean r19 = r24.getBooleanExtra("enableEnterAnim", false);
        c r5 = (c) ZeusTransformUtils.preCheckCast(privacyConsentCallbacks.get(r24.getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID)), c.class, "com.obric.aiagent.plugin");
        List r7 = (List) ZeusTransformUtils.preCheckCast(privacyItems.get(r24.getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID)), List.class, "com.obric.aiagent.plugin");
        List r20 = (List) ZeusTransformUtils.preCheckCast(privacyPolicyLinkTextsList.get(r24.getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID)), List.class, "com.obric.aiagent.plugin");
        b r21 = (b) ZeusTransformUtils.preCheckCast(linkClickListeners.get(r24.getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID)), b.class, "com.obric.aiagent.plugin");
        String r9 = getAppPackageName();
        if (r7 != null) goto L11;
        List r12 = p.b();
    L12:
        View r22 = null;
        if (r2 != null) goto L15;
        String r13 = null;
    L16:
        if (r20 != null) goto L18;
        List r8 = p.b();
    L19:
        com.obric.oui.privacy.a r0 = new com.obric.oui.privacy.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), new com.obric.oui.privacy.b(r9, r6, r11, r12, r13, r8, r15, r16, r17, r18, r19)).a((com.obric.oui.privacy.c) ZeusTransformUtils.preCheckCast(new e(r5, this, r20, r4, r21, r6), com.obric.oui.privacy.c.class, "com.obric.aiagent.plugin")).a();
        this.privacySheet = r0;
        if (r0 == null) goto L29;
        OSheet r10 = r0.d();
        if (r10 == null) goto L29;
        Window r14 = r10.getWindow();
        if (r14 == null) goto L29;
        r22 = r14.getDecorView();
    L29:
        reportPrivacySheetFirstFrame(r22);
        return;
    L18:
        r8 = r20;
        goto L19
    L15:
        r13 = r2.toString();
        goto L16
    L11:
        r12 = r7;
        goto L12
    }

    private final void reportPrivacySheetFirstFrame(View r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.firstFrameReported == true) goto L9;
        removeFirstFramePreDrawListener();
        this.firstFrameTargetView = r4;
        PrivacyStatementActivity$reportPrivacySheetFirstFrame$listener$1 r0 = new PrivacyStatementActivity$reportPrivacySheetFirstFrame$listener$1(this, r4);
        this.firstFramePreDrawListener = (ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(r0, ViewTreeObserver.OnPreDrawListener.class, "com.obric.aiagent.plugin");
        r4.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(r0, ViewTreeObserver.OnPreDrawListener.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final void removeFirstFramePreDrawListener() {
        ViewTreeObserver.OnPreDrawListener r0 = this.firstFramePreDrawListener;
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = this.firstFrameTargetView;
        if (r1 == null) goto L14;
        ViewTreeObserver r2 = r1.getViewTreeObserver();
        if (r2 == null) goto L14;
        if (r2.isAlive() == false) goto L14;
        r2.removeOnPreDrawListener(r0);
    L14:
        this.firstFrameTargetView = null;
        this.firstFramePreDrawListener = null;
    }

    private final void logPrivacySheetFirstFrame() {
        long r0 = SystemClock.elapsedRealtime();
        long r2 = r0 - this.onCreateStartElapsedRealtime;
        if (Build.VERSION.SDK_INT < 24) goto L5;
        long r6 = Process.getStartElapsedRealtime();
        INVOKESTATIC_com_obric_oui_window_permission_PrivacyStatementActivity_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, new StringBuilder().append("PrivacyStatementActivity first frame, processStartToPrivacyFirstFrameMs=").append(r0 - r6).append(", activityCreateToFirstFrameMs=").append(r2).append(", processStartElapsedRealtime=").append(r6).append(", firstFrameElapsedRealtime=").append(r0).toString());
        return;
    L5:
        INVOKESTATIC_com_obric_oui_window_permission_PrivacyStatementActivity_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "PrivacyStatementActivity first frame, processStartToPrivacyFirstFrameMs=unsupported, activityCreateToFirstFrameMs=" + r2 + ", firstFrameElapsedRealtime=" + r0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public void onContentChanged() {
        super.onContentChanged();
        this.contentChild = ((ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(android.R.id.content), ViewGroup.class, "com.obric.aiagent.plugin")).getChildAt(0);
        if (isEdgeToEdge() == false) goto L9;
        View r3 = this.contentChild;
        if (r3 == null) goto L10;
        ViewCompat.a(r3, $$Lambda$PrivacyStatementActivity$1ANzXiodS2479Q1oZ46RpWHU4rg.INSTANCE);
        return;
    L10:
        return;
    }

    /* JADX INFO: renamed from: onContentChanged$lambda-5$lambda-4, reason: not valid java name */
    private static final al m1243onContentChanged$lambda5$lambda4(View r4, al r5) {
        int r0 = r5.b();
        r5.d();
        o.c(r4, "v");
        r4.setPadding(r4.getPaddingLeft(), r0, r4.getPaddingRight(), 0);
        return r5;
    }

    private final boolean isEdgeToEdge() {
        View r1 = getWindow().getDecorView();
        o.c(r1, "window.decorView");
        return !r1.getFitsSystemWindows();
    }

    private final SpannableString processMessage(CharSequence r13, String[] r14, Context r15) {
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.aiagent.plugin");
        Context r17 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.aiagent.plugin");
        String r0 = r16.toString();
        int r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), "{", 0, false, 6, null);
        int r3 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), "}", 0, false, 6, null);
        int r4 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), "{", 0, false, 6, null);
        int r5 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), "}", 0, false, 6, null);
        if (this.useLinkTextAsTitle == false) goto L8;
        if (r2 == (-1)) goto L8;
        if (r3 == (-1)) goto L8;
        if (r2 >= r3) goto L8;
        String r6 = r0.substring(r2 + 1, r3);
        o.c(r6, "this as java.lang.String…ing(startIndex, endIndex)");
    L10:
        if (this.useLinkTextAsTitle == false) goto L15;
        if (r4 == (-1)) goto L15;
        if (r5 == (-1)) goto L15;
        if (r4 >= r5) goto L15;
        String r8 = r0.substring(r4 + 1, r5);
        o.c(r8, "this as java.lang.String…ing(startIndex, endIndex)");
    L16:
        ClickableSpan r7 = createClickableSpan(r17, (String) ZeusTransformUtils.preCheckCast(i.b(r14, 0), String.class, "com.obric.aiagent.plugin"), r6);
        ClickableSpan r18 = createClickableSpan(r17, (String) ZeusTransformUtils.preCheckCast(i.b(r14, 1), String.class, "com.obric.aiagent.plugin"), r8);
        SpannableStringBuilder r19 = new SpannableStringBuilder(r16);
        if (r2 == (-1)) goto L38;
        if (r3 == (-1)) goto L38;
        if (r4 == (-1)) goto L38;
        if (r5 == (-1)) goto L38;
        if (r2 != r4) goto L30;
        if (r3 != r5) goto L30;
        if (removeBracePair(r19, r2, r3) == true) goto L28;
        com.obric.oui.d.a.b.d(TAG, "processMessage single marker invalid, start=" + r2 + ", end=" + r3 + ", length=" + r19.length());
        return new SpannableString(r16);
    L28:
        applyClickableSpan(r19, r7, r2, r3 - 1);
    L40:
        return new SpannableString((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin"));
    L30:
        if (removeBracePair(r19, r4, r5) == true) goto L34;
        com.obric.oui.d.a.b.d(TAG, "processMessage user marker invalid, start=" + r4 + ", end=" + r5 + ", length=" + r19.length());
        return new SpannableString(r16);
    L34:
        if (removeBracePair(r19, r2, r3) == true) goto L37;
        com.obric.oui.d.a.b.d(TAG, "processMessage privacy marker invalid, start=" + r2 + ", end=" + r3 + ", length=" + r19.length());
        return new SpannableString(r16);
    L37:
        applyClickableSpan(r19, r7, r2, r3 - 1);
        applyClickableSpan(r19, r18, r4 - 2, r5 - 3);
    L38:
        com.obric.oui.d.a.b.d(TAG, o.a("processMessage marker not find, text=", r0));
    L15:
        r8 = getString(ZeusTransformUtils.mapRes(R.string.title_user_agreement, WsChannelMultiProcessSharedProvider.STRING_TYPE, "title_user_agreement"));
        o.c(r8, "{\n                getStr…_agreement)\n            }");
    L8:
        r6 = getString(ZeusTransformUtils.mapRes(R.string.title_privacy_policy, WsChannelMultiProcessSharedProvider.STRING_TYPE, "title_privacy_policy"));
        o.c(r6, "{\n                getStr…acy_policy)\n            }");
        goto L10
    }

    private final ClickableSpan createClickableSpan(Context r3, final String r4, final String r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        return (ClickableSpan) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r4, r5, r6), ClickableSpan.class, "com.obric.aiagent.plugin");
    }

    private final void applyClickableSpan(SpannableStringBuilder r1, ClickableSpan r2, int r3, int r4) {
        r1.setSpan(r2, r3, r4, 33);
    }

    private final boolean removeBracePair(SpannableStringBuilder r1, int r2, int r3) {
        if (r2 < 0) goto L10;
        if (r3 < 0) goto L12;
        if (r2 < r3) goto L6;
        return false;
    L6:
        if (r3 >= r1.length()) goto L14;
        r1.delete(r3, r3 + 1);
        r1.delete(r2, r2 + 1);
        return true;
    L14:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        c r0 = (c) ZeusTransformUtils.preCheckCast(privacyConsentCallbacks.get(getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID)), c.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        if (r1 == true) goto L14;
        if (r0 == null) goto L12;
        r0.a();
    L12:
        onDisagree();
        return;
    L14:
        return;
    L6:
        if (r0.b((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin")) != true) goto L8;
        r1 = true;
        goto L8
    }

    private final void openBrowser(String r4, String r5) {
        WebViewActivity.open((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), r4, r5, getIntent().getBooleanExtra(EXTRA_FLOATING_TRANSITION_ENABLED, false));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        String r0 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r0 == null) goto L10;
        a.AbstractC1007a r1 = (a.AbstractC1007a) ZeusTransformUtils.preCheckCast(activityCustomizers.get(r0), a.AbstractC1007a.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        r1.b((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        String r0 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r0 == null) goto L10;
        a.AbstractC1007a r1 = (a.AbstractC1007a) ZeusTransformUtils.preCheckCast(activityCustomizers.get(r0), a.AbstractC1007a.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        r1.c((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onPause() {
        super.onPause();
        String r0 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r0 == null) goto L10;
        a.AbstractC1007a r1 = (a.AbstractC1007a) ZeusTransformUtils.preCheckCast(activityCustomizers.get(r0), a.AbstractC1007a.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        r1.d((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        super.onStop();
        String r0 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r0 == null) goto L10;
        a.AbstractC1007a r1 = (a.AbstractC1007a) ZeusTransformUtils.preCheckCast(activityCustomizers.get(r0), a.AbstractC1007a.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        r1.e((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        com.obric.oui.d.a.b.b(TAG, "onDestroy");
        removeFirstFramePreDrawListener();
        View r1 = this.root;
        if (r1 != null) goto L27;
    L8:
        View r2 = this.contentChild;
        if (r2 != null) goto L29;
    L14:
        com.obric.oui.privacy.a r0 = this.privacySheet;
        if (r0 == null) goto L18;
        r0.c();
    L18:
        this.root = null;
        this.contentChild = null;
        this.privacySheet = null;
        super.onDestroy();
        String r3 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r3 == null) goto L31;
        Map<String, a.AbstractC1007a> r4 = activityCustomizers;
        a.AbstractC1007a r5 = (a.AbstractC1007a) ZeusTransformUtils.preCheckCast(r4.get(r3), a.AbstractC1007a.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L25;
        r5.f((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"));
    L25:
        a.AbstractC1007a r6 = (a.AbstractC1007a) ZeusTransformUtils.preCheckCast(r4.remove(r3), a.AbstractC1007a.class, "com.obric.aiagent.plugin");
        return;
    L31:
        return;
    L29:
        ViewCompat.a(r2, null);     // Catch: Exception -> L13
    L13:
        com.obric.oui.d.a.b.e(TAG, "removing contentChild WindowInsets listener failed");
        goto L14
    L27:
        r1.setOnApplyWindowInsetsListener(null);     // Catch: Exception -> L7
    L7:
        com.obric.oui.d.a.b.e(TAG, "removing root WindowInsets listener failed");
        goto L8
    }

    private final void clearCallbacksAndFinish() {
        String r0 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r0 == null) goto L6;
        privacyConsentCallbacks.remove(r0);
        linkClickListeners.remove(r0);
        privacyPolicyLinkTextsList.remove(r0);
        List r1 = (List) ZeusTransformUtils.preCheckCast(privacyItems.remove(r0), List.class, "com.obric.aiagent.plugin");
    L6:
        finish();
    }

    private final View createHeaderView(Context r4) {
        View r3 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.layout_privacy_statement_header, "layout", "layout_privacy_statement_header"), null, "com.obric.aiagent.plugin");
        o.c(r3, "headerView");
        return r3;
    }

    static /* synthetic */ View createSingleButton$default(PrivacyStatementActivity r2, Context r3, String r4, int r5, d.h.a.b r6, int r7, Object r8) {
        PrivacyStatementActivity r9 = (PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.aiagent.plugin");
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super View, x> r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L10;
        if ((r7 & 8) == 0) goto L8;
        r11 = null;
    L8:
        return r9.createSingleButton(r10, r4, r5, r11);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createSingleButton");
    }

    private final View createSingleButton(Context r2, String r3, int r4, d.h.a.b<? super View, x> r5) {
        return com.obric.oui.d.e.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r4, (q) ZeusTransformUtils.preCheckCast(new d(r3, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin")), q.class, "com.obric.aiagent.plugin"));
    }

    private final String getAppPackageName() {
        String r0 = getIntent().getStringExtra("customPackageName");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        String r3 = getPackageName();
        o.c(r3, "{\n            packageName\n        }");
        return r3;
    L11:
        com.obric.oui.d.a.b.d(TAG, o.a("using custom packageName: ", r0));
        return r0;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static /* synthetic */ void setSmartJustification$default(PrivacyStatementActivity r2, TextView r3, boolean r4, int r5, Object r6) {
        PrivacyStatementActivity r7 = (PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 1) == 0) goto L7;
        r4 = false;
    L7:
        r7.setSmartJustification(r3, r4);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSmartJustification");
    }

    public final void setSmartJustification(TextView r3, boolean r4) {
        o.e(r3, "<this>");
        if (Build.VERSION.SDK_INT < 29) goto L11;
        if (r4 == true) goto L9;
        Locale r5 = r3.getTextLocale();
        o.c(r5, "this.textLocale");
        if (shouldApplyJustification(r5) == true) goto L9;
        r3.setJustificationMode(0);
        return;
    L9:
        r3.setJustificationMode(1);
        return;
    }

    private final boolean shouldApplyJustification(Locale r1) {
        return !o.a(r1.getLanguage(), Locale.ENGLISH.getLanguage());
    }

    public final void setSystemInsetsAppearance(boolean r5) {
        Window r2 = null;
        if (Build.VERSION.SDK_INT < 23) goto L11;
        com.obric.oui.privacy.a r4 = this.privacySheet;
        if (r4 == null) goto L13;
        OSheet r6 = r4.d();
        if (r6 == null) goto L13;
        r2 = r6.getWindow();
    L13:
        if (Build.VERSION.SDK_INT < 30) goto L35;
        int r7 = 0;
        if (r2 == null) goto L25;
        WindowInsetsController r0 = r2.getInsetsController();
        if (r0 == null) goto L25;
        if (r5 == false) goto L23;
        int r3 = 8;
    L24:
        r0.setSystemBarsAppearance(r3, 8);
        goto L25
    L23:
        r3 = 0;
    L25:
        if (r2 == null) goto L45;
        WindowInsetsController r1 = r2.getInsetsController();
        if (r1 != null) goto L31;
        return;
    L31:
        if (r5 == false) goto L33;
        r7 = 16;
    L33:
        r1.setSystemBarsAppearance(r7, 16);
        return;
    L45:
        return;
    L35:
        if (Build.VERSION.SDK_INT < 23) goto L43;
        if (r2 == null) goto L47;
        if (r5 == false) goto L40;
        r2.getDecorView().setSystemUiVisibility(r2.getDecorView().getSystemUiVisibility() | 8192);
        return;
    L40:
        r2.getDecorView().setSystemUiVisibility(r2.getDecorView().getSystemUiVisibility() & (-8193));
        return;
    L47:
        return;
    L43:
        return;
    L11:
        r2 = (Window) ZeusTransformUtils.preCheckCast(null, Window.class, "com.obric.aiagent.plugin");
        goto L13
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_window_permission_PrivacyStatementActivity_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
