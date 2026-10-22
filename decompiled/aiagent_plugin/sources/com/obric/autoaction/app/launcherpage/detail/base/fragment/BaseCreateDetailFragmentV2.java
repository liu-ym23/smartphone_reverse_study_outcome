package com.obric.autoaction.app.launcherpage.detail.base.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.obric.autoaction.app.launcherpage.a;
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

/* JADX INFO: compiled from: BaseCreateDetailFragmentV2.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseCreateDetailFragmentV2 extends BaseDetailFragmentV2 {
    public static /* synthetic */ x lambda$Nbexomw98qaAAOUVZO8K7ZFIDmA(BaseCreateDetailFragmentV2 r0, View r1) {
        return configTitleBar$lambda$1(r0, r1);
    }

    public static /* synthetic */ x lambda$ZYiiu1HGLWJvov1ozGW3RYp8FGg(BaseCreateDetailFragmentV2 r0, View r1) {
        return configTitleBar$lambda$0(r0, r1);
    }

    public abstract String listTabName();

    public BaseCreateDetailFragmentV2() {
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public c getDetailMode() {
        return c.f23285a;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public void configTitleBar() {
        k.a((View) ZeusTransformUtils.preCheckCast(getTitleBar(), View.class, "com.obric.aiagent.plugin"));
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "requireContext(...)");
        p.a(r1, getTitleBar(), Integer.valueOf(getTitleRes()), null, defaultEnableRightButton(), new $$Lambda$BaseCreateDetailFragmentV2$ZYiiu1HGLWJvov1ozGW3RYp8FGg(this), new $$Lambda$BaseCreateDetailFragmentV2$Nbexomw98qaAAOUVZO8K7ZFIDmA(this), 8, null);
    }

    private static final x configTitleBar$lambda$0(BaseCreateDetailFragmentV2 r1, View r2) {
        o.e(r2, "it");
        r1.clickConfirmButton(r2);
        return x.f38692a;
    }

    private static final x configTitleBar$lambda$1(BaseCreateDetailFragmentV2 r1, View r2) {
        o.e(r2, "it");
        r1.clickCancelButton(r2);
        return x.f38692a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public void onClosePage(EventTaskResult r6) {
        if (e.a(r6) == false) goto L29;
        Object r1 = null;
        if (getDetailParams().getNavigateToListAfterSave() == false) goto L19;
        String r0 = getTaskId();
        String r2 = r0;
        if (r0 != null) goto L17;
        if (r6 == null) goto L14;
        List<EventTask> r7 = r6.getData();
        if (r7 == null) goto L14;
        EventTask r8 = (EventTask) ZeusTransformUtils.preCheckCast(d.a.p.l(r7), EventTask.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L14;
        r1 = r8.getId();
    L14:
        if (r1 != null) goto L16;
        r2 = "";
        goto L17
    L16:
        r2 = r1;
    L17:
        a r9 = a.f22698a;
        FragmentActivity r3 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
        o.c(r3, "requireActivity(...)");
        Activity r4 = (Activity) ZeusTransformUtils.preCheckCast(r3, Activity.class, "com.obric.aiagent.plugin");
        String r5 = listTabName();
        Bundle r10 = new Bundle();
        r10.putString("key_task_id", r2);
        x r11 = x.f38692a;
        r9.a(r4, r5, r10);
    L27:
        closeHost();
        return;
    L19:
        if (isDialogMode() == false) goto L27;
        b<EventTask, x> r12 = getOnResult();
        if (r12 == 0) goto L27;
        if (r6 == null) goto L26;
        List<EventTask> r13 = r6.getData();
        if (r13 == null) goto L26;
        r1 = (EventTask) ZeusTransformUtils.preCheckCast(d.a.p.l(r13), EventTask.class, "com.obric.aiagent.plugin");
    L26:
        r12.invoke(r1);
        goto L27
    }
}
