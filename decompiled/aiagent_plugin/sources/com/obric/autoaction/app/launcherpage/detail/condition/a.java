package com.obric.autoaction.app.launcherpage.detail.condition;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.obric.autoaction.app.launcherpage.detail.base.BaseDetailDialogFragment;
import com.obric.autoaction.app.launcherpage.detail.base.BaseOSheetDialogFragment;
import com.obric.autoaction.app.launcherpage.detail.condition.fragment.ConditionCreateFragmentV2;
import com.obric.autoaction.app.launcherpage.detail.condition.fragment.ConditionEventEditDetailFragmentV2;
import com.obric.autoaction.app.launcherpage.detail.shortcut.ShortCutCreateActivity;
import com.obric.autoaction.app.launcherpage.detail.shortcut.data.DetailParams;
import com.obric.autogui.util.ui.c;
import com.obric.eventkit.task.model.EventTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.o;

/* JADX INFO: compiled from: ConditionDetailLauncher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23400a = null;

    static {
        f23400a = new a();
    }

    private a() {
    }

    public static /* synthetic */ void a(a r1, Context r2, String r3, String r4, EventTask r5, int r6, Object r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.a(r8, r3, r4, r5);
    }

    public final void a(Context r3, String r4, String r5, EventTask r6) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "ctx");
        com.obric.autoaction.app.launcherpage.b.b.f22905a.a(r2);
        Intent r7 = new Intent(r2, ConditionEventDetailActivity.class);
        r7.putExtra("key_task_id", r5);
        r7.putExtra(ShortCutCreateActivity.KEY_ENTER_FROM, r4);
        r7.putExtra("key_event_task", (Parcelable) ZeusTransformUtils.preCheckCast(r6, Parcelable.class, "com.obric.aiagent.plugin"));
        if (c.a(r2) == true) goto L5;
        r7.addFlags(268435456);
    L5:
        ZeusTransformUtils.startActivity(r2, r7, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ void a(a r1, FragmentActivity r2, String r3, EventTask r4, int r5, Object r6) {
        FragmentActivity r7 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r2, FragmentActivity.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = null;
    L5:
        r1.a(r7, r3, r4);
    }

    public final void a(FragmentActivity r10, String r11, EventTask r12) {
        FragmentActivity r9 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r10, FragmentActivity.class, "com.obric.aiagent.plugin");
        o.e(r9, "activity");
        DetailParams r13 = new DetailParams(null, r11, r12, null, true, false, 40, null);
        BaseDetailDialogFragment.Companion.a(ConditionCreateFragmentV2.class, r13, "condition_task_create_sheet").show(r9.getSupportFragmentManager(), "ConditionEventCreate");
    }

    public static /* synthetic */ Object a(a r1, FragmentActivity r2, String r3, String r4, d r5, int r6, Object r7) {
        FragmentActivity r8 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r2, FragmentActivity.class, "com.obric.aiagent.plugin");
        d<? super EventTask> r9 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = "enter_from_condition_detail";
    L9:
        return r1.a(r8, r3, r4, r9);
    }

    public final Object a(FragmentActivity r11, String r12, String r13, d<? super EventTask> r14) {
        FragmentActivity r10 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r11, FragmentActivity.class, "com.obric.aiagent.plugin");
        d r15 = (d) ZeusTransformUtils.wrapperContextForParams(r14, d.class, "com.obric.aiagent.plugin");
        DetailParams r16 = new DetailParams(r12, r13, null, null, true, false, 44, null);
        return BaseOSheetDialogFragment.Companion.a((BaseOSheetDialogFragment) ZeusTransformUtils.preCheckCast(BaseDetailDialogFragment.Companion.a(ConditionEventEditDetailFragmentV2.class, r16, "condition_task_edit_detail"), BaseOSheetDialogFragment.class, "com.obric.aiagent.plugin"), r10, "ConditionEventEditDetail", r15);
    }
}
