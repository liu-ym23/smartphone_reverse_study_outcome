package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage.SelectedMsgABHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import fa2.a;
import ha2.b;
import ha2.c;
import ha2.d;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/PSSelectedMessageDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PSSelectedMessageDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f139456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f139457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f139458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataCenter f139459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f139460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f139461f;

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setGravity(80);
    L5:
        setContentView(R.layout.ttlive_layout_selected_message_more_panel);
        Window r102 = getWindow();
        if (r102 == null) goto L8;
        r102.setLayout(-1, -2);
    L8:
        this.f139456a = (TextView) findViewById(R.id.msg_preference_option);
        this.f139457b = (TextView) findViewById(R.id.close_selected_message);
        this.f139458c = (TextView) findViewById(R.id.cancel);
        TextView r103 = this.f139456a;
        if (r103 == null) goto L11;
        r103.setOnClickListener(new b(this));
    L11:
        TextView r104 = this.f139457b;
        if (r104 == null) goto L14;
        r104.setOnClickListener(new c(this));
    L14:
        TextView r105 = this.f139458c;
        if (r105 == null) goto L17;
        r105.setOnClickListener(new d(this));
    L17:
        TextView r106 = this.f139456a;
        if (r106 == null) goto L20;
        r106.setText(R.string.ttlive_selected_msg_option_intro_ai);
    L20:
        TextView r107 = this.f139457b;
        if (r107 == null) goto L24;
        r107.setText(R.string.ttlive_close_selected_msg_ai);
        return;
    }

    public PSSelectedMessageDialog(Context r100, DataCenter r101, CompositeDisposable r102, a r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "cd");
        Intrinsics.checkNotNullParameter(r103, "selectedDataSource");
        if (SelectedMsgABHelper.b().useAppcompactStyle == false) goto L5;
        int r104 = R.style.ttlive_common_bottom_dialog_normal_appcompat;
    L6:
        super(r100, r104);
        this.f139459d = r101;
        this.f139460e = r102;
        this.f139461f = r103;
        return;
    L5:
        r104 = R.style.ttlive_common_bottom_dialog_normal;
        goto L6
    }
}
