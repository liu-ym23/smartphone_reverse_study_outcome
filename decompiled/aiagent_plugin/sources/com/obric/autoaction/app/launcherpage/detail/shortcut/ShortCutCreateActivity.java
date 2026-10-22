package com.obric.autoaction.app.launcherpage.detail.shortcut;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ai;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.i;
import androidx.lifecycle.o;
import com.obric.agent.omnimodel.IOmniModelService;
import com.obric.autoaction.app.launcherpage.detail.base.BaseDetailDialogFragment;
import com.obric.autoaction.app.launcherpage.detail.shortcut.data.e;
import com.obric.autoaction.app.launcherpage.utils.m;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.x;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: ShortCutCreateActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ShortCutCreateActivity extends AppCompatActivity {
    public static final a Companion = null;
    public static final String KEY_ENTER_FROM = "key_enter_from";
    public static final String KEY_QUERY = "key_query";
    public static final String KEY_SOURCE_MESSAGE_ID = "key_source_message_id";
    public static final String KEY_TASK_MODEL = "key_task_model";
    public static final int RESULT_CODE_CANCELED = 0;
    public static final int RESULT_CODE_SUCCESS = -1;
    private static final String TAG = "ShortCutCreateActivity";
    private final AtomicBoolean resultDelivered;
    private BaseDetailDialogFragment sheetFragment;

    /* JADX INFO: compiled from: ShortCutCreateActivity.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$uRxccjHD7CTTJ80yhsMXqMp-o8M, reason: not valid java name */
    public static /* synthetic */ x m490lambda$uRxccjHD7CTTJ80yhsMXqMpo8M(ShortCutCreateActivity r0, EventTask r1) {
        return showCreateSheet$lambda$4(r0, r1);
    }

    public static /* synthetic */ x lambda$zqh0iNTLAb0AkUilvelx2tqZeoc(ShortCutCreateActivity r0) {
        return showCreateSheet$lambda$5(r0);
    }

    public ShortCutCreateActivity() {
        this.resultDelivered = new AtomicBoolean(false);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        boolean r1 = false;
        ai.a(getWindow(), false);
        getWindow().setStatusBarColor(0);
        if (r10 == null) goto L6;
        finish();
        return;
    L6:
        String r11 = getIntent().getStringExtra(KEY_ENTER_FROM);
        if (r11 != null) goto L9;
    L16:
        r11 = "enter_from_add_instruct";
    L17:
        String r3 = getIntent().getStringExtra(KEY_QUERY);
        String r4 = "";
        if (r3 != null) goto L20;
        r3 = "";
    L20:
        String r5 = getIntent().getStringExtra(KEY_SOURCE_MESSAGE_ID);
        if (r5 != null) goto L23;
        r5 = "";
    L23:
        String r6 = getIntent().getStringExtra(KEY_TASK_MODEL);
        if (r6 == null) goto L27;
        r4 = r6;
    L27:
        Loog r7 = Loog.INSTANCE;
        StringBuilder r8 = new StringBuilder().append("onCreate, enterFrom=").append(r11).append(", queryLen=").append(r3.length()).append(", hasSourceMessageId=");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L30;
        boolean r9 = true;
    L31:
        StringBuilder r12 = r8.append(r9).append(", hasTaskModel=");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L34;
        r1 = true;
    L34:
        r7.i(TAG, r12.append(r1).toString());
        showCreateSheet(r11, r3, r5, r4);
        return;
    L30:
        r9 = false;
        goto L31
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L11;
        boolean r13 = true;
    L12:
        if (r13 == true) goto L15;
        r11 = null;
    L15:
        if (r11 != null) goto L17;
    L11:
        r13 = false;
        goto L12
    }

    private final void showCreateSheet(String r18, String r19, String r20, String r21) {
        String r5 = r19;
        boolean r6 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        boolean r3 = true;
    L6:
        ShortcutTask r8 = null;
        if (r3 == true) goto L10;
        r5 = null;
    L10:
        if (r5 == null) goto L23;
        r8 = e.a(r5, 0, 2, null);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L18;
        m.a(r8, r20);
    L18:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L21;
        r6 = false;
    L21:
        if (r6 == false) goto L23;
        r8.setOmniModel(IOmniModelService.Companion.a().parseEntryFromJson(r21).a());
        goto L23
    L14:
        r4 = false;
    L23:
        BaseDetailDialogFragment r1 = com.obric.autoaction.app.launcherpage.detail.shortcut.a.a(com.obric.autoaction.app.launcherpage.detail.shortcut.a.f23480a, (FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), r18, (EventTask) ZeusTransformUtils.preCheckCast(r8, EventTask.class, "com.obric.aiagent.plugin"), null, false, 8, null);
        this.sheetFragment = r1;
        r1.setOnResult(new $$Lambda$ShortCutCreateActivity$uRxccjHD7CTTJ80yhsMXqMpo8M(this));
        r1.setOnDismiss(new $$Lambda$ShortCutCreateActivity$zqh0iNTLAb0AkUilvelx2tqZeoc(this));
        r1.getLifecycle().a((o) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this), o.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r3 = false;
        goto L6
    }

    private static final x showCreateSheet$lambda$4(ShortCutCreateActivity r2, EventTask r3) {
        ShortCutCreateActivity r4 = (ShortCutCreateActivity) ZeusTransformUtils.wrapperContextForParams(r2, ShortCutCreateActivity.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        int r5 = -1;
    L6:
        r4.deliverResult(r5);
        return x.f38692a;
    L5:
        r5 = 0;
        goto L6
    }

    private static final x showCreateSheet$lambda$5(ShortCutCreateActivity r2) {
        ((ShortCutCreateActivity) ZeusTransformUtils.wrapperContextForParams(r2, ShortCutCreateActivity.class, "com.obric.aiagent.plugin")).deliverResult(0);
        return x.f38692a;
    }

    private final void deliverResult(int r4) {
        if (this.resultDelivered.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Loog.INSTANCE.i(TAG, "deliverResult, code=" + r4);
        ZeusTransformUtils.setResult(this, r4, "com.obric.aiagent.plugin");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        super.onStop();
        BaseDetailDialogFragment r0 = this.sheetFragment;
        if (r0 == null) goto L11;
        if (r0 == null) goto L8;
        i r1 = r0.getLifecycle();
        if (r1 == null) goto L8;
        i.b r2 = r1.b();
    L10:
        if (r2 == i.b.f2054a) goto L11;
        return;
    L8:
        r2 = null;
    L11:
        Loog.INSTANCE.i(TAG, "sheet is null or destroyed, finish activity");
        finish();
    }
}
