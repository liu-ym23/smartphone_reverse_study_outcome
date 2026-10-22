package com.obric.autoaction.app.launcherpage.detail.base.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.obric.autoaction.app.launcherpage.detail.base.b.c;
import com.obric.autoaction.app.launcherpage.detail.base.e;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskResult;
import com.obric.oui.common.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.o;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: BaseEditDetailFragmentV2.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseEditDetailFragmentV2 extends BaseDetailFragmentV2 {
    /* JADX INFO: renamed from: lambda$Pb-L5KCcf35tmD_K5YY_wjVdinE, reason: not valid java name */
    public static /* synthetic */ x m487lambda$PbL5KCcf35tmD_K5YY_wjVdinE(BaseEditDetailFragmentV2 r0, View r1) {
        return configTitleBar$lambda$0(r0, r1);
    }

    public static /* synthetic */ x lambda$hW13IeubdwlrWGqkMAUKnB5dtf8(BaseEditDetailFragmentV2 r0, View r1) {
        return configTitleBar$lambda$1(r0, r1);
    }

    public BaseEditDetailFragmentV2() {
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public c getDetailMode() {
        return c.f23287c;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public void configTitleBar() {
        k.a((View) ZeusTransformUtils.preCheckCast(getTitleBar(), View.class, "com.obric.aiagent.plugin"));
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "requireContext(...)");
        p.a(r1, getTitleBar(), Integer.valueOf(getTitleRes()), null, defaultEnableRightButton(), new $$Lambda$BaseEditDetailFragmentV2$PbL5KCcf35tmD_K5YY_wjVdinE(this), new $$Lambda$BaseEditDetailFragmentV2$hW13IeubdwlrWGqkMAUKnB5dtf8(this), 8, null);
    }

    private static final x configTitleBar$lambda$0(BaseEditDetailFragmentV2 r1, View r2) {
        o.e(r2, "it");
        r1.clickConfirmButton(r2);
        return x.f38692a;
    }

    private static final x configTitleBar$lambda$1(BaseEditDetailFragmentV2 r1, View r2) {
        o.e(r2, "it");
        r1.clickCancelButton(r2);
        return x.f38692a;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public void onClosePage(EventTaskResult r6) {
        if (e.a(r6) == true) goto L5;
        return;
    L5:
        if (r6 == null) goto L9;
        List<EventTask> r7 = r6.getData();
        if (r7 == null) goto L9;
        EventTask r8 = (EventTask) ZeusTransformUtils.preCheckCast(d.a.p.l(r7), EventTask.class, "com.obric.aiagent.plugin");
    L11:
        if (isDialogMode() == false) goto L15;
        b<EventTask, x> r0 = getOnResult();
        if (r0 == null) goto L19;
        r0.invoke(r8);
    L19:
        closeHost();
        return;
    L15:
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
        Intent r3 = new Intent();
        if (r8 == null) goto L18;
        r3.putExtra("key_edit_result", (Parcelable) ZeusTransformUtils.preCheckCast(r8, Parcelable.class, "com.obric.aiagent.plugin"));
    L18:
        x r9 = x.f38692a;
        ZeusTransformUtils.setResult(r1, -1, r3, "com.obric.aiagent.plugin");
    L9:
        r8 = null;
        goto L11
    }
}
