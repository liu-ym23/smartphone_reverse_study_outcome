package com.mdisdk.action;

import android.content.Intent;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.IntentEntity;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013J<\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\tHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/mdisdk/action/OpenAppArgs;", "", "packageName", "", "targetActivity", "Landroid/content/Intent;", "entity", "Lcom/mdisdk/capability/model/IntentEntity;", WindowStateInfo.KEY_DISPLAY_ID, "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Landroid/content/Intent;Lcom/mdisdk/capability/model/IntentEntity;Ljava/lang/Integer;)V", "getPackageName", "()Ljava/lang/String;", "getTargetActivity", "()Landroid/content/Intent;", "getEntity", "()Lcom/mdisdk/capability/model/IntentEntity;", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Landroid/content/Intent;Lcom/mdisdk/capability/model/IntentEntity;Ljava/lang/Integer;)Lcom/mdisdk/action/OpenAppArgs;", "equals", "", "other", "hashCode", "toString", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OpenAppArgs {
    private final Integer displayId;
    private final IntentEntity entity;
    private final String packageName;
    private final Intent targetActivity;

    public OpenAppArgs(String packageName, Intent intent, IntentEntity intentEntity, Integer num) {
        k.f(packageName, "packageName");
        this.packageName = packageName;
        this.targetActivity = intent;
        this.entity = intentEntity;
        this.displayId = num;
    }

    public static /* synthetic */ OpenAppArgs copy$default(OpenAppArgs openAppArgs, String str, Intent intent, IntentEntity intentEntity, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = openAppArgs.packageName;
        }
        if ((i & 2) != 0) {
            intent = openAppArgs.targetActivity;
        }
        if ((i & 4) != 0) {
            intentEntity = openAppArgs.entity;
        }
        if ((i & 8) != 0) {
            num = openAppArgs.displayId;
        }
        return openAppArgs.copy(str, intent, intentEntity, num);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final Intent getTargetActivity() {
        return this.targetActivity;
    }

    /* renamed from: component3, reason: from getter */
    public final IntentEntity getEntity() {
        return this.entity;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final OpenAppArgs copy(String packageName, Intent targetActivity, IntentEntity entity, Integer displayId) {
        k.f(packageName, "packageName");
        return new OpenAppArgs(packageName, targetActivity, entity, displayId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenAppArgs)) {
            return false;
        }
        OpenAppArgs openAppArgs = (OpenAppArgs) other;
        return k.b(this.packageName, openAppArgs.packageName) && k.b(this.targetActivity, openAppArgs.targetActivity) && k.b(this.entity, openAppArgs.entity) && k.b(this.displayId, openAppArgs.displayId);
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

    public final Intent getTargetActivity() {
        return this.targetActivity;
    }

    public int hashCode() {
        int iHashCode = this.packageName.hashCode() * 31;
        Intent intent = this.targetActivity;
        int iHashCode2 = (iHashCode + (intent == null ? 0 : intent.hashCode())) * 31;
        IntentEntity intentEntity = this.entity;
        int iHashCode3 = (iHashCode2 + (intentEntity == null ? 0 : intentEntity.hashCode())) * 31;
        Integer num = this.displayId;
        return iHashCode3 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "OpenAppArgs(packageName=" + this.packageName + ", targetActivity=" + this.targetActivity + ", entity=" + this.entity + ", displayId=" + this.displayId + ')';
    }
}
