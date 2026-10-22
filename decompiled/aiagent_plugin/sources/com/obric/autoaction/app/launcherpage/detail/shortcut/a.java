package com.obric.autoaction.app.launcherpage.detail.shortcut;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.obric.autoaction.app.launcherpage.b.b;
import com.obric.autoaction.app.launcherpage.detail.base.BaseDetailDialogFragment;
import com.obric.autoaction.app.launcherpage.detail.base.BaseOSheetDialogFragment;
import com.obric.autoaction.app.launcherpage.detail.shortcut.data.DetailParams;
import com.obric.autoaction.app.launcherpage.detail.shortcut.fragment.ShortcutCreateFragmentV2;
import com.obric.autoaction.app.launcherpage.detail.shortcut.fragment.ShortcutEditDetailFragmentV2;
import com.obric.autogui.common.api.presentation.AssistRemoteCardUIParams;
import com.obric.autogui.util.ui.c;
import com.obric.eventkit.task.model.EventTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.o;
import java.io.Serializable;

/* JADX INFO: compiled from: ShortcutDetailLauncher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23480a = null;

    static {
        f23480a = new a();
    }

    private a() {
    }

    public static /* synthetic */ void a(a r3, Context r4, String r5, String r6, EventTask r7, AssistRemoteCardUIParams r8, int r9, Object r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if ((r9 & 2) == 0) goto L5;
        r5 = "enter_from_auto_right_btn";
    L5:
        String r12 = r5;
        AssistRemoteCardUIParams r0 = null;
        if ((r9 & 4) == 0) goto L8;
        String r1 = null;
    L10:
        if ((r9 & 8) == 0) goto L12;
        EventTask r2 = null;
    L14:
        if ((r9 & 16) != 0) goto L17;
        r0 = r8;
    L17:
        r3.a(r11, r12, r1, r2, r0);
        return;
    L12:
        r2 = r7;
        goto L14
    L8:
        r1 = r6;
        goto L10
    }

    public final void a(Context r3, String r4, String r5, EventTask r6, AssistRemoteCardUIParams r7) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "ctx");
        b.f22905a.a(r2);
        Intent r8 = new Intent(r2, ShortcutDetailActivity.class);
        if (c.a(r2) == true) goto L5;
        r8.addFlags(268435456);
    L5:
        r8.putExtra("key_task_id", r5);
        r8.putExtra(ShortCutCreateActivity.KEY_ENTER_FROM, r4);
        r8.putExtra("key_event_task", (Parcelable) ZeusTransformUtils.preCheckCast(r6, Parcelable.class, "com.obric.aiagent.plugin"));
        if (r7 == null) goto L8;
        r8.putExtra("key_doubao_card_params", (Serializable) ZeusTransformUtils.preCheckCast(r7, Serializable.class, "com.obric.aiagent.plugin"));
    L8:
        ZeusTransformUtils.startActivity(r2, r8, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ BaseDetailDialogFragment a(a r3, FragmentActivity r4, String r5, EventTask r6, AssistRemoteCardUIParams r7, boolean r8, int r9, Object r10) {
        FragmentActivity r11 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r4, FragmentActivity.class, "com.obric.aiagent.plugin");
        if ((r9 & 2) == 0) goto L5;
        r5 = "enter_from_auto_right_btn";
    L5:
        String r12 = r5;
        AssistRemoteCardUIParams r0 = null;
        if ((r9 & 4) == 0) goto L8;
        EventTask r1 = null;
    L10:
        if ((r9 & 8) != 0) goto L14;
        r0 = r7;
    L14:
        if ((r9 & 16) == 0) goto L17;
        r8 = true;
    L17:
        return r3.a(r11, r12, r1, r0, r8);
    L8:
        r1 = r6;
        goto L10
    }

    public final BaseDetailDialogFragment a(FragmentActivity r8, String r9, EventTask r10, AssistRemoteCardUIParams r11, boolean r12) {
        FragmentActivity r7 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r8, FragmentActivity.class, "com.obric.aiagent.plugin");
        o.e(r7, "activity");
        DetailParams r13 = new DetailParams(null, r9, r10, r11, true, r12);
        BaseDetailDialogFragment r14 = BaseDetailDialogFragment.Companion.a(ShortcutCreateFragmentV2.class, r13, "shortcut_task_create_sheet");
        r14.show(r7.getSupportFragmentManager(), "ShortcutCreate");
        return r14;
    }

    public static /* synthetic */ Object a(a r1, FragmentActivity r2, String r3, String r4, d r5, int r6, Object r7) {
        FragmentActivity r8 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r2, FragmentActivity.class, "com.obric.aiagent.plugin");
        d<? super EventTask> r9 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = "enter_from_short_cut_detail";
    L9:
        return r1.a(r8, r3, r4, r9);
    }

    public final Object a(FragmentActivity r11, String r12, String r13, d<? super EventTask> r14) {
        FragmentActivity r10 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r11, FragmentActivity.class, "com.obric.aiagent.plugin");
        d r15 = (d) ZeusTransformUtils.wrapperContextForParams(r14, d.class, "com.obric.aiagent.plugin");
        DetailParams r16 = new DetailParams(r12, r13, null, null, true, false, 44, null);
        return BaseOSheetDialogFragment.Companion.a((BaseOSheetDialogFragment) ZeusTransformUtils.preCheckCast(BaseDetailDialogFragment.Companion.a(ShortcutEditDetailFragmentV2.class, r16, "shortcut_task_edit_detail"), BaseOSheetDialogFragment.class, "com.obric.aiagent.plugin"), r10, "ShortcutEditDetail", r15);
    }

    public final void a(FragmentActivity r10, String r11, String r12) {
        FragmentActivity r9 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r10, FragmentActivity.class, "com.obric.aiagent.plugin");
        o.e(r9, "activity");
        DetailParams r13 = new DetailParams(r11, r12, null, null, true, false, 44, null);
        BaseDetailDialogFragment.Companion.a(ShortcutEditDetailFragmentV2.class, r13, "shortcut_task_edit_detail").show(r9.getSupportFragmentManager(), "ShortcutEditDetail");
    }
}
