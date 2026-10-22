package com.stepos.taskrobot.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/taskrobot/common/bean/ActionInfo;", "Landroid/os/Parcelable;", "", "code", "", "message", "actionName", "actionParams", "Lcom/stepos/taskrobot/common/bean/BitmapInfo;", "bitmapInfo", AppAgent.CONSTRUCT, "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/taskrobot/common/bean/BitmapInfo;)V", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getCode", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "getActionName", "getActionParams", "Lcom/stepos/taskrobot/common/bean/BitmapInfo;", "getBitmapInfo", "()Lcom/stepos/taskrobot/common/bean/BitmapInfo;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ActionInfo implements Parcelable {
    public static final Parcelable.Creator<ActionInfo> CREATOR = new Creator();
    private final String actionName;
    private final String actionParams;
    private final BitmapInfo bitmapInfo;
    private final int code;
    private final String message;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ActionInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActionInfo createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new ActionInfo(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), BitmapInfo.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActionInfo[] newArray(int i) {
            return new ActionInfo[i];
        }
    }

    public ActionInfo(int i, String message, String actionName, String actionParams, BitmapInfo bitmapInfo) {
        k.f(message, "message");
        k.f(actionName, "actionName");
        k.f(actionParams, "actionParams");
        k.f(bitmapInfo, "bitmapInfo");
        this.code = i;
        this.message = message;
        this.actionName = actionName;
        this.actionParams = actionParams;
        this.bitmapInfo = bitmapInfo;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final String getActionParams() {
        return this.actionParams;
    }

    public final BitmapInfo getBitmapInfo() {
        return this.bitmapInfo;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeInt(this.code);
        dest.writeString(this.message);
        dest.writeString(this.actionName);
        dest.writeString(this.actionParams);
        this.bitmapInfo.writeToParcel(dest, flags);
    }
}
