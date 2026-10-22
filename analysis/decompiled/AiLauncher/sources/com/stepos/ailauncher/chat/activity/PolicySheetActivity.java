package com.stepos.ailauncher.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import c9.C1507a;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.sheet.SheetExitAnim;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.util.PolicyHtmlDisplayAdapter;
import com.stepos.policy.sdk.util.PolicyHtmlLinkHandler;
import com.stepos.policy.sdk.util.PolicyHtmlLoader;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u000201B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\bJ!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\"\u0010\u0016J\u0011\u0010#\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b#\u0010\u0016R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010&R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b.\u0010-¨\u00062"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/PolicySheetActivity;", "Lcom/stepos/ailauncher/sheet/O;", "<init>", "()V", "LY8/t;", "B4", "", "Z3", "()Z", "Lcom/stepos/ailauncher/sheet/SheetExitAnim;", "x1", "()Lcom/stepos/ailauncher/sheet/SheetExitAnim;", "i1", "j1", "Landroid/widget/FrameLayout;", "container", "Landroid/os/Bundle;", "savedInstanceState", "F2", "(Landroid/widget/FrameLayout;Landroid/os/Bundle;)V", "", "I4", "()Ljava/lang/String;", "H4", "uri", "E4", "(Ljava/lang/String;)Ljava/lang/String;", "html", "y4", "(Ljava/lang/String;)V", "Lcom/stepos/ailauncher/chat/activity/PolicySheetActivity$State;", VoiceWakeupReceiver.EXTRA_STATE, "K4", "(Lcom/stepos/ailauncher/chat/activity/PolicySheetActivity$State;)V", "w4", "x4", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/TextView;", "tvContent", "Landroidx/core/widget/NestedScrollView;", "scrollView", "Landroidx/core/widget/NestedScrollView;", "Landroid/view/View;", "progress", "Landroid/view/View;", "errorView", "Companion", "State", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PolicySheetActivity extends com.stepos.ailauncher.sheet.O {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_CATEGORY = "extra_category";
    private static final String EXTRA_TITLE = "extra_title";
    private static final String EXTRA_URL = "extra_url";
    private static final long ONLINE_RESOLVE_TIMEOUT_MS = 10000;
    private static final String TAG = "PolicySheetActivity";
    private View errorView;
    private View progress;
    private NestedScrollView scrollView;
    private TextView tvContent;
    private TextView tvTitle;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/PolicySheetActivity$State;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "CONTENT", "ERROR", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class State {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State LOADING = new State("LOADING", 0);
        public static final State CONTENT = new State("CONTENT", 1);
        public static final State ERROR = new State("ERROR", 2);

        private static final /* synthetic */ State[] $values() {
            return new State[]{LOADING, CONTENT, ERROR};
        }

        static {
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = kotlin.enums.a.a(stateArr$values);
        }

        private State(String str, int i10) {
        }

        public static InterfaceC4149a<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000bJ\u001f\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/PolicySheetActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", QueryAlgorithmBundle.KEY_CATEGORY, "title", "LY8/t;", "c", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "url", Const.INTENT_KEY_UMID, "Landroid/view/View;", "panel", "", "radiusPx", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;F)V", "TAG", "Ljava/lang/String;", "EXTRA_CATEGORY", "EXTRA_URL", "EXTRA_TITLE", "", "ONLINE_RESOLVE_TIMEOUT_MS", "J", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.activity.PolicySheetActivity$a, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/activity/PolicySheetActivity$a$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.activity.PolicySheetActivity$a$a, reason: collision with other inner class name */
        public static final class C0272a extends ViewOutlineProvider {
            final /* synthetic */ float $radiusPx;

            public C0272a(float f10) {
                this.$radiusPx = f10;
            }

            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                kotlin.jvm.internal.p.i(view, "view");
                kotlin.jvm.internal.p.i(outline, "outline");
                int width = view.getWidth();
                int height = view.getHeight();
                float f10 = this.$radiusPx;
                outline.setRoundRect(0, 0, width, height + ((int) f10), f10);
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void b(View panel, float radiusPx) {
            panel.setClipToOutline(true);
            panel.setOutlineProvider(new C0272a(radiusPx));
            panel.invalidateOutline();
        }

        public final void c(Context context, String category, String title) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(category, "category");
            kotlin.jvm.internal.p.i(title, "title");
            Intent intentPutExtra = new Intent(context, (Class<?>) PolicySheetActivity.class).putExtra(PolicySheetActivity.EXTRA_CATEGORY, category).putExtra(PolicySheetActivity.EXTRA_TITLE, title);
            kotlin.jvm.internal.p.h(intentPutExtra, "putExtra(...)");
            C2739j.C(context, intentPutExtra, null, 4, null);
        }

        public final void d(Context context, String url, String title) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(url, "url");
            kotlin.jvm.internal.p.i(title, "title");
            Intent intentPutExtra = new Intent(context, (Class<?>) PolicySheetActivity.class).putExtra(PolicySheetActivity.EXTRA_URL, url).putExtra(PolicySheetActivity.EXTRA_TITLE, title);
            kotlin.jvm.internal.p.h(intentPutExtra, "putExtra(...)");
            C2739j.C(context, intentPutExtra, null, 4, null);
        }

        public Companion() {
        }
    }

    public static final Y8.t A4(PolicySheetActivity policySheetActivity, String url) {
        kotlin.jvm.internal.p.i(url, "url");
        PolicySdkToolsUtils.INSTANCE.startBrowser(policySheetActivity, url);
        return Y8.t.f7040a;
    }

    private final void B4() {
        K4(State.LOADING);
        C1507a.b(false, false, null, "policy-sheet-load", 0, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.t1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return PolicySheetActivity.C4(this.f24877a);
            }
        }, 23, null);
    }

    public static final Y8.t C4(final PolicySheetActivity policySheetActivity) {
        String strX4 = policySheetActivity.x4();
        String strI4 = strX4 == null ? policySheetActivity.I4() : strX4;
        final String strE4 = strI4 != null ? policySheetActivity.E4(strI4) : null;
        if ((strE4 == null || La.H.x0(strE4)) && strX4 == null) {
            String strH4 = policySheetActivity.H4();
            strE4 = strH4 != null ? policySheetActivity.E4(strH4) : null;
        }
        policySheetActivity.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.chat.activity.u1
            @Override // java.lang.Runnable
            public final void run() {
                PolicySheetActivity.D4(this.f24883a, strE4);
            }
        });
        return Y8.t.f7040a;
    }

    public static final void D4(PolicySheetActivity policySheetActivity, String str) {
        if (policySheetActivity.isDestroyed() || policySheetActivity.isFinishing()) {
            return;
        }
        if (str == null || La.H.x0(str)) {
            policySheetActivity.K4(State.ERROR);
        } else {
            policySheetActivity.y4(str);
        }
    }

    public static final void F4(PolicySheetActivity policySheetActivity, View view) throws Resources.NotFoundException {
        policySheetActivity.g1();
    }

    public static final void G4(PolicySheetActivity policySheetActivity, View view) {
        policySheetActivity.B4();
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.String] */
    public static final void J4(Ref$ObjectRef ref$ObjectRef, CountDownLatch countDownLatch, PolicySdkResultBean policySdkResultBean) {
        if (policySdkResultBean != null && policySdkResultBean.getCode() == 0) {
            ref$ObjectRef.f34820a = policySdkResultBean.getPolicyUrl();
        }
        countDownLatch.countDown();
    }

    public static final Y8.t z4(PolicySheetActivity policySheetActivity, String url, String str) {
        kotlin.jvm.internal.p.i(url, "url");
        INSTANCE.d(policySheetActivity, url, "");
        return Y8.t.f7040a;
    }

    public final String E4(String uri) {
        try {
            return PolicyHtmlLoader.loadHtml(this, uri);
        } catch (Exception e10) {
            C4148a.u(TAG, "loadHtml failed for " + uri + ": " + e10.getMessage(), false, 4, null);
            return null;
        }
    }

    @Override // com.stepos.ailauncher.sheet.O
    public void F2(FrameLayout container, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(container, "container");
        M3(false);
        M1().setPadding(0, 0, 0, M1().getPaddingBottom());
        int iViewerBackgroundColor = PolicyHtmlDisplayAdapter.viewerBackgroundColor(this);
        float fT2 = T2() * getResources().getDisplayMetrics().density;
        ViewGroup viewGroupY1 = Y1();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(iViewerBackgroundColor);
        gradientDrawable.setCornerRadii(new float[]{fT2, fT2, fT2, fT2, 0.0f, 0.0f, 0.0f, 0.0f});
        viewGroupY1.setBackground(gradientDrawable);
        INSTANCE.b(Y1(), fT2);
        container.setBackgroundColor(iViewerBackgroundColor);
        View viewInflate = getLayoutInflater().inflate(R$layout.activity_policy_sheet, (ViewGroup) container, true);
        View viewFindViewById = viewInflate.findViewById(R$id.tv_title);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        this.tvTitle = (TextView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R$id.tv_content);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.tvContent = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R$id.scroll_view);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        this.scrollView = (NestedScrollView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R$id.progress);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        this.progress = viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R$id.error_view);
        kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
        this.errorView = viewFindViewById5;
        TextView textView = this.tvTitle;
        if (textView == null) {
            kotlin.jvm.internal.p.A("tvTitle");
            textView = null;
        }
        String stringExtra = getIntent().getStringExtra(EXTRA_TITLE);
        if (stringExtra == null) {
            stringExtra = "";
        }
        textView.setText(stringExtra);
        TextView textView2 = this.tvContent;
        if (textView2 == null) {
            kotlin.jvm.internal.p.A("tvContent");
            textView2 = null;
        }
        textView2.setTextColor(PolicyHtmlDisplayAdapter.textColor(this));
        C2773b6 c2773b6 = new C2773b6(this, false, 2, null);
        int i10 = R$id.btn_close;
        View viewFindViewById6 = viewInflate.findViewById(i10);
        kotlin.jvm.internal.p.h(viewFindViewById6, "findViewById(...)");
        C2773b6.p(c2773b6, new View[]{viewFindViewById6}, y7.o.INSTANCE.i(), false, 4, null);
        viewInflate.findViewById(i10).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.r1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                PolicySheetActivity.F4(this.f24871a, view);
            }
        });
        viewInflate.findViewById(R$id.btn_retry).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.s1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PolicySheetActivity.G4(this.f24874a, view);
            }
        });
        B4();
    }

    public final String H4() {
        PolicySdkResultBean policyNewestPath = PolicySdk.getPolicyNewestPath(this, w4());
        if (policyNewestPath.getCode() != 0) {
            policyNewestPath = PolicySdk.getPolicyNewestPath(createDeviceProtectedStorageContext(), w4());
        }
        String policyNewestPath2 = policyNewestPath.getPolicyNewestPath();
        if (policyNewestPath.getCode() != 0 || policyNewestPath2 == null || policyNewestPath2.length() == 0) {
            return null;
        }
        return androidx.core.content.b.getUriForFile(this, getPackageName() + ".PolicySdk.FileProvider", new File(policyNewestPath2)).toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String I4() throws InterruptedException {
        String language = PolicySdkToolsUtils.INSTANCE.getLanguage();
        if (language == null || La.H.x0(language)) {
            language = null;
        }
        if (language == null) {
            language = "zh_CN";
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        PolicySdk.getOnlinePolicyUrl(language, w4(), new PolicySdk.PolicySdkCallback() { // from class: com.stepos.ailauncher.chat.activity.x1
            @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
            public final void getResult(PolicySdkResultBean policySdkResultBean) {
                PolicySheetActivity.J4(ref$ObjectRef, countDownLatch, policySdkResultBean);
            }
        });
        countDownLatch.await(10000L, TimeUnit.MILLISECONDS);
        String str = (String) ref$ObjectRef.f34820a;
        if (str == null || La.H.x0(str)) {
            return null;
        }
        return str;
    }

    public final void K4(State state) {
        NestedScrollView nestedScrollView = this.scrollView;
        View view = null;
        if (nestedScrollView == null) {
            kotlin.jvm.internal.p.A("scrollView");
            nestedScrollView = null;
        }
        nestedScrollView.setVisibility(state == State.CONTENT ? 0 : 8);
        View view2 = this.progress;
        if (view2 == null) {
            kotlin.jvm.internal.p.A("progress");
            view2 = null;
        }
        view2.setVisibility(state == State.LOADING ? 0 : 8);
        View view3 = this.errorView;
        if (view3 == null) {
            kotlin.jvm.internal.p.A("errorView");
        } else {
            view = view3;
        }
        view.setVisibility(state == State.ERROR ? 0 : 8);
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean Z3() {
        return false;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean i1() {
        return false;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean j1() {
        return true;
    }

    public final String w4() {
        String stringExtra = getIntent().getStringExtra(EXTRA_CATEGORY);
        return stringExtra == null ? "" : stringExtra;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public SheetExitAnim x1() {
        return SheetExitAnim.SLIDE_DOWN;
    }

    public final String x4() {
        String stringExtra = getIntent().getStringExtra(EXTRA_URL);
        if (stringExtra == null || La.H.x0(stringExtra)) {
            return null;
        }
        return stringExtra;
    }

    public final void y4(String html) {
        boolean zIsDarkMode = PolicyHtmlDisplayAdapter.isDarkMode(this);
        String strPrepareHtml = PolicyHtmlDisplayAdapter.prepareHtml(html, zIsDarkMode);
        String strExtractTitle = PolicyHtmlDisplayAdapter.extractTitle(html);
        String stringExtra = getIntent().getStringExtra(EXTRA_TITLE);
        if (stringExtra == null) {
            stringExtra = "";
        }
        String strResolveDisplayTitle = PolicyHtmlDisplayAdapter.resolveDisplayTitle(strExtractTitle, stringExtra);
        if (strResolveDisplayTitle != null && !La.H.x0(strResolveDisplayTitle)) {
            TextView textView = this.tvTitle;
            if (textView == null) {
                kotlin.jvm.internal.p.A("tvTitle");
                textView = null;
            }
            textView.setText(strResolveDisplayTitle);
        }
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            kotlin.jvm.internal.p.A("scrollView");
            nestedScrollView = null;
        }
        nestedScrollView.scrollTo(0, 0);
        TextView textView2 = null;
        PolicyHtmlLinkHandler policyHtmlLinkHandler = PolicyHtmlLinkHandler.INSTANCE;
        TextView textView3 = this.tvContent;
        if (textView3 == null) {
            kotlin.jvm.internal.p.A("tvContent");
        } else {
            textView2 = textView3;
        }
        String strX4 = x4();
        if (strX4 == null) {
            strX4 = "";
        }
        policyHtmlLinkHandler.bindHtmlLinks(textView2, strPrepareHtml, strX4, zIsDarkMode, PolicyHtmlDisplayAdapter.linkColor(this), new p9.p() { // from class: com.stepos.ailauncher.chat.activity.v1
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return PolicySheetActivity.z4(this.f24887a, (String) obj, (String) obj2);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.activity.w1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return PolicySheetActivity.A4(this.f24891a, (String) obj);
            }
        });
        K4(State.CONTENT);
    }
}
