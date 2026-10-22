package com.mdisdk.action;

import C7.r;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.IntentEntity;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import m9.C1724q;
import m9.InterfaceC1723p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B=\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0090@¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b \u0010\u0016¨\u0006!"}, d2 = {"Lcom/mdisdk/action/OpenAppAction;", "Lcom/mdisdk/action/Action;", "LC7/r;", "", "packageName", "Landroid/content/Intent;", "targetActivity", "Lcom/mdisdk/capability/model/IntentEntity;", "entity", "", WindowStateInfo.KEY_DISPLAY_ID, "tag", AppAgent.CONSTRUCT, "(Ljava/lang/String;Landroid/content/Intent;Lcom/mdisdk/capability/model/IntentEntity;Ljava/lang/Integer;Ljava/lang/String;)V", "Lcom/mdisdk/core/TaskContext;", "context", "Lcom/mdisdk/action/ActionResult;", "perform$mdisdk_release", "(Lcom/mdisdk/core/TaskContext;LH7/c;)Ljava/lang/Object;", "perform", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "Landroid/content/Intent;", "getTargetActivity", "()Landroid/content/Intent;", "Lcom/mdisdk/capability/model/IntentEntity;", "getEntity", "()Lcom/mdisdk/capability/model/IntentEntity;", "Ljava/lang/Integer;", "getDisplayId", "()Ljava/lang/Integer;", "getTag", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OpenAppAction extends Action<r> {
    private final Integer displayId;
    private final IntentEntity entity;
    private final String packageName;
    private final String tag;
    private final Intent targetActivity;

    public /* synthetic */ OpenAppAction(String str, Intent intent, IntentEntity intentEntity, Integer num, String str2, int i, e eVar) {
        this(str, (i & 2) != 0 ? null : intent, (i & 4) != 0 ? null : intentEntity, (i & 8) != 0 ? null : num, (i & 16) != 0 ? "" : str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void perform$lambda$1(int i, OpenAppAction openAppAction, Context context, InterfaceC1723p interfaceC1723p) {
        ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
        activityOptionsMakeBasic.setLaunchDisplayId(i);
        IntentEntity intentEntity = openAppAction.entity;
        if (intentEntity != null) {
            Intent intent = intentEntity.toIntent();
            k.e(intent, "toIntent(...)");
            intent.addFlags(335544320);
            context.startActivity(intent, activityOptionsMakeBasic.toBundle());
            ((C1724q) interfaceC1723p).U(Boolean.TRUE);
            return;
        }
        Intent intent2 = openAppAction.targetActivity;
        if (intent2 != null) {
            context.startActivity(intent2, activityOptionsMakeBasic.toBundle());
            ((C1724q) interfaceC1723p).U(Boolean.TRUE);
            return;
        }
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(openAppAction.packageName);
        if (launchIntentForPackage == null) {
            ((C1724q) interfaceC1723p).U(Boolean.FALSE);
        } else {
            launchIntentForPackage.addFlags(268435456);
            context.startActivity(launchIntentForPackage, activityOptionsMakeBasic.toBundle());
            ((C1724q) interfaceC1723p).U(Boolean.TRUE);
        }
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final IntentEntity getEntity() {
        return this.entity;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    @Override // com.mdisdk.action.Action
    public String getTag() {
        return this.tag;
    }

    public final Intent getTargetActivity() {
        return this.targetActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.mdisdk.action.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object perform$mdisdk_release(com.mdisdk.core.TaskContext r10, H7.c<? super com.mdisdk.action.ActionResult<? extends C7.r>> r11) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mdisdk.action.OpenAppAction.perform$mdisdk_release(com.mdisdk.core.TaskContext, H7.c):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenAppAction(String packageName, Intent intent, IntentEntity intentEntity, Integer num, String tag) {
        super(tag, new Object[]{packageName, intent, intentEntity, num});
        k.f(packageName, "packageName");
        k.f(tag, "tag");
        this.packageName = packageName;
        this.targetActivity = intent;
        this.entity = intentEntity;
        this.displayId = num;
        this.tag = tag;
    }
}
