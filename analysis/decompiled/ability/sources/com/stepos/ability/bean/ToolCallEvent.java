package com.stepos.ability.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.commoninternal.Key;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0001\u0003\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/ability/bean/ToolCallEvent;", "Landroid/os/Parcelable;", AppAgent.CONSTRUCT, "()V", Key.KEY_TOOL_CALL_ID, "", "getToolCallId", "()Ljava/lang/String;", "abilityId", "", "getAbilityId", "()Ljava/lang/Long;", "toolName", "getToolName", "bundle", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "version", "", "getVersion", "()I", "Companion", "Lcom/stepos/ability/bean/ToolCallProgress;", "Lcom/stepos/ability/bean/ToolCallResult;", "Lcom/stepos/ability/bean/ToolCallStart;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ToolCallEvent implements Parcelable {
    public static final int TYPE_PROGRESS = 2;
    public static final int TYPE_RESULT = 3;
    public static final int TYPE_START = 1;
    public static final Parcelable.Creator<ToolCallEvent> CREATOR = new Parcelable.Creator<ToolCallEvent>() { // from class: com.stepos.ability.bean.ToolCallEvent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ToolCallEvent createFromParcel(Parcel source) {
            k.f(source, "source");
            int i = source.readInt();
            if (i == 1) {
                ToolCallStart toolCallStartCreateFromParcel = ToolCallStart.CREATOR.createFromParcel(source);
                k.e(toolCallStartCreateFromParcel, "createFromParcel(...)");
                return toolCallStartCreateFromParcel;
            }
            if (i == 2) {
                ToolCallProgress toolCallProgressCreateFromParcel = ToolCallProgress.CREATOR.createFromParcel(source);
                k.e(toolCallProgressCreateFromParcel, "createFromParcel(...)");
                return toolCallProgressCreateFromParcel;
            }
            if (i != 3) {
                throw new IllegalArgumentException("Unknown ToolCallEvent type");
            }
            ToolCallResult toolCallResultCreateFromParcel = ToolCallResult.CREATOR.createFromParcel(source);
            k.e(toolCallResultCreateFromParcel, "createFromParcel(...)");
            return toolCallResultCreateFromParcel;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ToolCallEvent[] newArray(int size) {
            return new ToolCallEvent[size];
        }
    };

    public /* synthetic */ ToolCallEvent(e eVar) {
        this();
    }

    public abstract Long getAbilityId();

    public abstract Bundle getBundle();

    public abstract String getToolCallId();

    public abstract String getToolName();

    public abstract int getVersion();

    private ToolCallEvent() {
    }
}
