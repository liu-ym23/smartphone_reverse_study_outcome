package com.bytedance.android.livesdk.gift.fastgift.task;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.livesdk.gift.fastgift.t;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ly1.b;
import my1.c;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/fastgift/task/FastTaskGiftConfirmDialog;", "Landroidx/appcompat/app/AppCompatDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FastTaskGiftConfirmDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f126188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f126189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Button f126190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f126191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f126192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f126193f;

    public interface a {
        void a();

        void cancel();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.ttlive_dialog_fast_task_gift_confirm);
        this.f126188a = (TextView) findViewById(R.id.fast_task_gift_main);
        this.f126189b = (TextView) findViewById(R.id.fast_task_gift_sub);
        this.f126190c = (Button) findViewById(R.id.fast_task_gift_send);
        this.f126191d = (TextView) findViewById(R.id.fast_task_gift_cancel);
        c r101 = this.f126192e;
        if (r101 == null) goto L10;
        TextView r102 = this.f126188a;
        if (r102 == null) goto L7;
        r102.setText(r101.mainText);
    L7:
        TextView r103 = this.f126189b;
        if (r103 == null) goto L10;
        r103.setText(r101.subText);
    L10:
        Button r104 = this.f126190c;
        if (r104 == null) goto L13;
        r104.setOnClickListener(new ly1.a(this));
    L13:
        TextView r105 = this.f126191d;
        if (r105 == null) goto L17;
        r105.setOnClickListener(new b(this));
        return;
    }

    public FastTaskGiftConfirmDialog(Context r100, c r101, t r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "callback");
        super(r100);
        this.f126192e = r101;
        this.f126193f = r102;
    }
}
