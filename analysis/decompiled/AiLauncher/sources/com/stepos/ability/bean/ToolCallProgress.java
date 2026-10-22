package com.stepos.ability.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u00010B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0016J\u0010\u0010\u001a\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0014JF\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0016J\u0010\u0010 \u001a\u00020\tHÖ\u0001¢\u0006\u0004\b \u0010\u0014J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010(\u001a\u0004\b)\u0010\u0018R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b*\u0010\u0016R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010+\u001a\u0004\b,\u0010\u001bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010-\u001a\u0004\b.\u0010\u0014¨\u00061"}, d2 = {"Lcom/stepos/ability/bean/ToolCallProgress;", "Lcom/stepos/ability/bean/ToolCallEvent;", "", "toolCallId", "", "abilityId", "toolName", "Landroid/os/Bundle;", "bundle", "", "version", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Landroid/os/Bundle;I)V", "Landroid/os/Parcel;", "parcel", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "()Ljava/lang/Long;", "component3", "component4", "()Landroid/os/Bundle;", "component5", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Landroid/os/Bundle;I)Lcom/stepos/ability/bean/ToolCallProgress;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getToolCallId", "Ljava/lang/Long;", "getAbilityId", "getToolName", "Landroid/os/Bundle;", "getBundle", "I", "getVersion", "Companion", Const.INTENT_KEY_PKGNAME, "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ToolCallProgress extends ToolCallEvent {
    private final Long abilityId;
    private final Bundle bundle;
    private final String toolCallId;
    private final String toolName;
    private final int version;
    public static final Parcelable.Creator<ToolCallProgress> CREATOR = new a();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ability/bean/ToolCallProgress$a", "Landroid/os/Parcelable$Creator;", "Lcom/stepos/ability/bean/ToolCallProgress;", "Landroid/os/Parcel;", "source", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/stepos/ability/bean/ToolCallProgress;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcom/stepos/ability/bean/ToolCallProgress;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ToolCallProgress> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ToolCallProgress createFromParcel(Parcel source) {
            p.i(source, "source");
            int i10 = source.readInt();
            String string = source.readString();
            if (string == null) {
                string = "";
            }
            String str = string;
            Long lValueOf = source.readInt() != 0 ? Long.valueOf(source.readLong()) : null;
            String string2 = source.readString();
            Bundle bundle = source.readBundle(ToolCallProgress.class.getClassLoader());
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
            Bundle bundle2 = bundle;
            p.f(bundle2);
            return new ToolCallProgress(str, lValueOf, string2, bundle2, i10);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ToolCallProgress[] newArray(int size) {
            return new ToolCallProgress[size];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolCallProgress(String toolCallId, Long l10, String str, Bundle bundle, int i10) {
        super(null);
        p.i(toolCallId, "toolCallId");
        p.i(bundle, "bundle");
        this.toolCallId = toolCallId;
        this.abilityId = l10;
        this.toolName = str;
        this.bundle = bundle;
        this.version = i10;
    }

    public static /* synthetic */ ToolCallProgress copy$default(ToolCallProgress toolCallProgress, String str, Long l10, String str2, Bundle bundle, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = toolCallProgress.toolCallId;
        }
        if ((i11 & 2) != 0) {
            l10 = toolCallProgress.abilityId;
        }
        if ((i11 & 4) != 0) {
            str2 = toolCallProgress.toolName;
        }
        if ((i11 & 8) != 0) {
            bundle = toolCallProgress.bundle;
        }
        if ((i11 & 16) != 0) {
            i10 = toolCallProgress.version;
        }
        int i12 = i10;
        String str3 = str2;
        return toolCallProgress.copy(str, l10, str3, bundle, i12);
    }

    /* renamed from: component1, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getAbilityId() {
        return this.abilityId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component4, reason: from getter */
    public final Bundle getBundle() {
        return this.bundle;
    }

    /* renamed from: component5, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final ToolCallProgress copy(String toolCallId, Long abilityId, String toolName, Bundle bundle, int version) {
        p.i(toolCallId, "toolCallId");
        p.i(bundle, "bundle");
        return new ToolCallProgress(toolCallId, abilityId, toolName, bundle, version);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolCallProgress)) {
            return false;
        }
        ToolCallProgress toolCallProgress = (ToolCallProgress) other;
        return p.d(this.toolCallId, toolCallProgress.toolCallId) && p.d(this.abilityId, toolCallProgress.abilityId) && p.d(this.toolName, toolCallProgress.toolName) && p.d(this.bundle, toolCallProgress.bundle) && this.version == toolCallProgress.version;
    }

    @Override // com.stepos.ability.bean.ToolCallEvent
    public Long getAbilityId() {
        return this.abilityId;
    }

    @Override // com.stepos.ability.bean.ToolCallEvent
    public Bundle getBundle() {
        return this.bundle;
    }

    @Override // com.stepos.ability.bean.ToolCallEvent
    public String getToolCallId() {
        return this.toolCallId;
    }

    @Override // com.stepos.ability.bean.ToolCallEvent
    public String getToolName() {
        return this.toolName;
    }

    @Override // com.stepos.ability.bean.ToolCallEvent
    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iHashCode = this.toolCallId.hashCode() * 31;
        Long l10 = this.abilityId;
        int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str = this.toolName;
        return ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.bundle.hashCode()) * 31) + Integer.hashCode(this.version);
    }

    public String toString() {
        return "ToolCallProgress(toolCallId=" + this.toolCallId + ", abilityId=" + this.abilityId + ", toolName=" + this.toolName + ", bundle=" + this.bundle + ", version=" + this.version + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        parcel.writeInt(2);
        parcel.writeInt(getVersion());
        parcel.writeString(getToolCallId());
        if (getAbilityId() != null) {
            parcel.writeInt(1);
            parcel.writeLong(getAbilityId().longValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(getToolName());
        parcel.writeBundle(getBundle());
    }

    public /* synthetic */ ToolCallProgress(String str, Long l10, String str2, Bundle bundle, int i10, int i11, i iVar) {
        this(str, (i11 & 2) != 0 ? null : l10, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? new Bundle() : bundle, (i11 & 16) != 0 ? 0 : i10);
    }
}
