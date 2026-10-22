package com.stepos.ability.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0001\u0003\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/ability/bean/ToolCallEvent;", "Landroid/os/Parcelable;", "<init>", "()V", "", "getToolCallId", "()Ljava/lang/String;", "toolCallId", "", "getAbilityId", "()Ljava/lang/Long;", "abilityId", "getToolName", "toolName", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "bundle", "", "getVersion", "()I", "version", "Companion", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ability/bean/ToolCallProgress;", "Lcom/stepos/ability/bean/ToolCallResult;", "Lcom/stepos/ability/bean/ToolCallStart;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ToolCallEvent implements Parcelable {
    public static final int TYPE_PROGRESS = 2;
    public static final int TYPE_RESULT = 3;
    public static final int TYPE_START = 1;
    public static final Parcelable.Creator<ToolCallEvent> CREATOR = new a();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ability/bean/ToolCallEvent$a", "Landroid/os/Parcelable$Creator;", "Lcom/stepos/ability/bean/ToolCallEvent;", "Landroid/os/Parcel;", "source", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/stepos/ability/bean/ToolCallEvent;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcom/stepos/ability/bean/ToolCallEvent;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ToolCallEvent> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ToolCallEvent createFromParcel(Parcel source) {
            p.i(source, "source");
            int i10 = source.readInt();
            if (i10 == 1) {
                ToolCallStart toolCallStartCreateFromParcel = ToolCallStart.CREATOR.createFromParcel(source);
                p.h(toolCallStartCreateFromParcel, "createFromParcel(...)");
                return toolCallStartCreateFromParcel;
            }
            if (i10 == 2) {
                ToolCallProgress toolCallProgressCreateFromParcel = ToolCallProgress.CREATOR.createFromParcel(source);
                p.h(toolCallProgressCreateFromParcel, "createFromParcel(...)");
                return toolCallProgressCreateFromParcel;
            }
            if (i10 != 3) {
                throw new IllegalArgumentException("Unknown ToolCallEvent type");
            }
            ToolCallResult toolCallResultCreateFromParcel = ToolCallResult.CREATOR.createFromParcel(source);
            p.h(toolCallResultCreateFromParcel, "createFromParcel(...)");
            return toolCallResultCreateFromParcel;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ToolCallEvent[] newArray(int size) {
            return new ToolCallEvent[size];
        }
    }

    public /* synthetic */ ToolCallEvent(i iVar) {
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
