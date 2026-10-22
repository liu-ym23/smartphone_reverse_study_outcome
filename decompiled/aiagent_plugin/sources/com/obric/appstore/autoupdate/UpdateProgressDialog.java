package com.obric.appstore.autoupdate;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.progress.OProgressView;
import com.obric.oui.selection.OSelectionPanelBtnView;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class UpdateProgressDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f22445a = "UpdateProgressDialog";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f22446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f22447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f22448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private UpdateHandler f22449e;
    private TextView f;
    private OProgressView g;
    private OInsetSheet h;

    private class UpdateHandler extends Handler {
        final /* synthetic */ UpdateProgressDialog this$0;

        public static /* synthetic */ int access$000(String r0, String r1) {
            return Log.d(r0, r1);
        }

        private UpdateHandler(UpdateProgressDialog r1) {
            this.this$0 = r1;
        }

        /* synthetic */ UpdateHandler(UpdateProgressDialog r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r5) {
            if (r5.what != 297) goto L12;
            int r6 = ObricAutoUpdateUtils.a().b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(UpdateProgressDialog.a(this.this$0), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), UpdateProgressDialog.b(this.this$0));
            if (r6 >= 0) goto L8;
            INVOKESTATIC_com_obric_appstore_autoupdate_UpdateProgressDialog$UpdateHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(UpdateProgressDialog.d(), "appstore progress: -1" + UpdateProgressDialog.b(this.this$0));
            return;
        L8:
            if (r6 != 100) goto L10;
            INVOKESTATIC_com_obric_appstore_autoupdate_UpdateProgressDialog$UpdateHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(UpdateProgressDialog.d(), "appstore progress:" + r6);
            UpdateProgressDialog.a(this.this$0, r6);
            this.this$0.c();
            return;
        L10:
            UpdateProgressDialog.a(this.this$0, r6);
            sendEmptyMessageDelayed(297, 300);
            return;
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_appstore_autoupdate_UpdateProgressDialog$UpdateHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }
    }

    static {
    }

    static /* synthetic */ Context a(UpdateProgressDialog r0) {
        return r0.f22446b;
    }

    static /* synthetic */ void a(UpdateProgressDialog r0, int r1) {
        r0.a(r1);
    }

    static /* synthetic */ String b(UpdateProgressDialog r0) {
        return r0.f22447c;
    }

    static /* synthetic */ UpdateHandler c(UpdateProgressDialog r0) {
        return r0.f22449e;
    }

    static /* synthetic */ int d(UpdateProgressDialog r0) {
        return r0.f22448d;
    }

    static /* synthetic */ String d() {
        return f22445a;
    }

    public UpdateProgressDialog(Context r3, String r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f22448d = 0;
        this.f22446b = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        this.f22447c = r4;
        this.f22448d = r5;
        this.f22449e = new UpdateHandler(this, null);
        this.h = new OInsetSheet(r6);
        a();
    }

    public void a() {
        this.h.setRootWidth(OInsetSheet.b.f36197b);
        this.h.setHeaderView(e());
        this.h.setContainerView(f());
        this.h.setFooterView(g());
        this.h.setClearDimFlag(false);
        this.h.setCanceledOnTouchOutside(true);
        this.h.setCancelable(false);
    }

    private View e() {
        OInsetSheetTitleBar r0 = new OInsetSheetTitleBar(this.f22446b);
        r0.setShowLeftBack(false);
        r0.setTitleText(this.f22446b.getString(ZeusTransformUtils.mapRes(R.string.auto_progress_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_progress_title")));
        r0.sheetTitleBarStyle();
        return r0;
    }

    private View f() {
        View r0 = ZeusTransformUtils.inflate(LayoutInflater.from(this.f22446b), ZeusTransformUtils.mapRes(R.layout.obric_auto_downloading, "layout", "obric_auto_downloading"), null, "com.obric.aiagent.plugin");
        this.f = (TextView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.auto_downloading_percent, DbHelper.COL_ID, "auto_downloading_percent")), TextView.class, "com.obric.aiagent.plugin");
        this.g = (OProgressView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.auto_progressbar, DbHelper.COL_ID, "auto_progressbar")), OProgressView.class, "com.obric.aiagent.plugin");
        a(0);
        return r0;
    }

    private View g() {
        OSelectionPanelBtnView r0 = new OSelectionPanelBtnView(this.f22446b);
        r0.getBtnPositive().setVisibility(8);
        r0.getHorizontal_space().setVisibility(8);
        r0.getBtnNegative().setText(android.R.string.cancel);
        r0.getBtnNegative().setOnClickListener(new AnonymousClass1(this));
        return r0;
    }

    private void h() {
        OInsetSheet r0 = this.h;     // Catch: Exception -> L6
        if (r0 == null) goto L9;
        r0.dismiss();     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    private void a(int r5) {
        TextView r0 = this.f;
        if (r0 == null) goto L5;
        r0.setText(String.format("%d%%", new Object[]{Integer.valueOf(r5)}));
    L5:
        OProgressView r4 = this.g;
        if (r4 == null) goto L9;
        r4.setProgress(r5);
        return;
    }

    public void b() {
    L7:
        e = move-exception;
        a(f22445a, "show: ", e);
    L9:
        this.f22449e.sendEmptyMessageDelayed(297, 300);
        return;
    L3:
        if (ZeusTransformUtils.instanceOf(this.f22446b, Activity.class) == true) goto L5;
        this.h.getWindow().setType(2038);     // Catch: Exception -> L7
    L5:
        this.h.show();     // Catch: Exception -> L7
        goto L9
    }

    public void a(long r3) {
        if (r3 > 0) goto L6;
        b();
        return;
    L6:
        this.f22449e.postDelayed(new AnonymousClass2(this), r3);
    }

    public void c() {
        h();
        this.f22449e.removeMessages(297);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
