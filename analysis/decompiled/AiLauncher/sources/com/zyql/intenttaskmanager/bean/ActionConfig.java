package com.zyql.intenttaskmanager.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.d;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u001a\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010\u0014¨\u0006#"}, d2 = {"Lcom/zyql/intenttaskmanager/bean/ActionConfig;", "Landroid/os/Parcelable;", "", d.EXTRA_ENABLED, "Lcom/zyql/intenttaskmanager/bean/ActionIntent;", "actionIntent", "<init>", "(ZLcom/zyql/intenttaskmanager/bean/ActionIntent;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Z", "component2", "()Lcom/zyql/intenttaskmanager/bean/ActionIntent;", ChatTracker.CLICK_COPY, "(ZLcom/zyql/intenttaskmanager/bean/ActionIntent;)Lcom/zyql/intenttaskmanager/bean/ActionConfig;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getEnabled", "Lcom/zyql/intenttaskmanager/bean/ActionIntent;", "getActionIntent", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ActionConfig implements Parcelable {
    public static final Parcelable.Creator<ActionConfig> CREATOR = new a();
    private final ActionIntent actionIntent;
    private final boolean enabled;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ActionConfig> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ActionConfig createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new ActionConfig(parcel.readInt() != 0, (ActionIntent) parcel.readParcelable(ActionConfig.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ActionConfig[] newArray(int i10) {
            return new ActionConfig[i10];
        }
    }

    public ActionConfig(boolean z10, ActionIntent actionIntent) {
        p.i(actionIntent, "actionIntent");
        this.enabled = z10;
        this.actionIntent = actionIntent;
    }

    public static /* synthetic */ ActionConfig copy$default(ActionConfig actionConfig, boolean z10, ActionIntent actionIntent, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = actionConfig.enabled;
        }
        if ((i10 & 2) != 0) {
            actionIntent = actionConfig.actionIntent;
        }
        return actionConfig.copy(z10, actionIntent);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component2, reason: from getter */
    public final ActionIntent getActionIntent() {
        return this.actionIntent;
    }

    public final ActionConfig copy(boolean enabled, ActionIntent actionIntent) {
        p.i(actionIntent, "actionIntent");
        return new ActionConfig(enabled, actionIntent);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionConfig)) {
            return false;
        }
        ActionConfig actionConfig = (ActionConfig) other;
        return this.enabled == actionConfig.enabled && p.d(this.actionIntent, actionConfig.actionIntent);
    }

    public final ActionIntent getActionIntent() {
        return this.actionIntent;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.enabled) * 31) + this.actionIntent.hashCode();
    }

    public String toString() {
        return "ActionConfig(enabled=" + this.enabled + ", actionIntent=" + this.actionIntent + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeInt(this.enabled ? 1 : 0);
        dest.writeParcelable(this.actionIntent, flags);
    }
}
