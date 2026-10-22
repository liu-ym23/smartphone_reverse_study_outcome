package com.stepos.ability.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.commoninternal.Key;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u0001/B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0016J\u0010\u0010\u001a\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0014JF\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0016J\u0010\u0010 \u001a\u00020\tHÖ\u0001¢\u0006\u0004\b \u0010\u0014J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010(\u001a\u0004\b)\u0010\u0018R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b*\u0010\u0016R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010+\u001a\u0004\b,\u0010\u001bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010-\u001a\u0004\b.\u0010\u0014¨\u00060"}, d2 = {"Lcom/stepos/ability/bean/ToolCallResult;", "Lcom/stepos/ability/bean/ToolCallEvent;", "", Key.KEY_TOOL_CALL_ID, "", "abilityId", "toolName", "Landroid/os/Bundle;", "bundle", "", "version", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Landroid/os/Bundle;I)V", "Landroid/os/Parcel;", "parcel", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "()Ljava/lang/Long;", "component3", "component4", "()Landroid/os/Bundle;", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Landroid/os/Bundle;I)Lcom/stepos/ability/bean/ToolCallResult;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getToolCallId", "Ljava/lang/Long;", "getAbilityId", "getToolName", "Landroid/os/Bundle;", "getBundle", "I", "getVersion", "Companion", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ToolCallResult extends ToolCallEvent {
    private final Long abilityId;
    private final Bundle bundle;
    private final String toolCallId;
    private final String toolName;
    private final int version;
    public static final Parcelable.Creator<ToolCallResult> CREATOR = new Parcelable.Creator<ToolCallResult>() { // from class: com.stepos.ability.bean.ToolCallResult$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ToolCallResult createFromParcel(Parcel source) {
            k.f(source, "source");
            int i = source.readInt();
            String string = source.readString();
            if (string == null) {
                string = "";
            }
            String str = string;
            Long lValueOf = source.readInt() != 0 ? Long.valueOf(source.readLong()) : null;
            String string2 = source.readString();
            Bundle bundle = source.readBundle(ToolCallResult.class.getClassLoader());
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
            Bundle bundle2 = bundle;
            k.c(bundle2);
            return new ToolCallResult(str, lValueOf, string2, bundle2, i);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ToolCallResult[] newArray(int size) {
            return new ToolCallResult[size];
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolCallResult(String toolCallId, Long l, String str, Bundle bundle, int i) {
        super(null);
        k.f(toolCallId, "toolCallId");
        k.f(bundle, "bundle");
        this.toolCallId = toolCallId;
        this.abilityId = l;
        this.toolName = str;
        this.bundle = bundle;
        this.version = i;
    }

    public static /* synthetic */ ToolCallResult copy$default(ToolCallResult toolCallResult, String str, Long l, String str2, Bundle bundle, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = toolCallResult.toolCallId;
        }
        if ((i6 & 2) != 0) {
            l = toolCallResult.abilityId;
        }
        if ((i6 & 4) != 0) {
            str2 = toolCallResult.toolName;
        }
        if ((i6 & 8) != 0) {
            bundle = toolCallResult.bundle;
        }
        if ((i6 & 16) != 0) {
            i = toolCallResult.version;
        }
        int i10 = i;
        String str3 = str2;
        return toolCallResult.copy(str, l, str3, bundle, i10);
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

    public final ToolCallResult copy(String toolCallId, Long abilityId, String toolName, Bundle bundle, int version) {
        k.f(toolCallId, "toolCallId");
        k.f(bundle, "bundle");
        return new ToolCallResult(toolCallId, abilityId, toolName, bundle, version);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolCallResult)) {
            return false;
        }
        ToolCallResult toolCallResult = (ToolCallResult) other;
        return k.b(this.toolCallId, toolCallResult.toolCallId) && k.b(this.abilityId, toolCallResult.abilityId) && k.b(this.toolName, toolCallResult.toolName) && k.b(this.bundle, toolCallResult.bundle) && this.version == toolCallResult.version;
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
        Long l = this.abilityId;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.toolName;
        int iHashCode3 = str != null ? str.hashCode() : 0;
        return Integer.hashCode(this.version) + ((this.bundle.hashCode() + ((iHashCode2 + iHashCode3) * 31)) * 31);
    }

    public String toString() {
        String str = this.toolCallId;
        Long l = this.abilityId;
        String str2 = this.toolName;
        Bundle bundle = this.bundle;
        int i = this.version;
        StringBuilder sb = new StringBuilder("ToolCallResult(toolCallId=");
        sb.append(str);
        sb.append(", abilityId=");
        sb.append(l);
        sb.append(", toolName=");
        sb.append(str2);
        sb.append(", bundle=");
        sb.append(bundle);
        sb.append(", version=");
        return a.o(sb, ")", i);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeInt(3);
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

    public /* synthetic */ ToolCallResult(String str, Long l, String str2, Bundle bundle, int i, int i6, e eVar) {
        this(str, (i6 & 2) != 0 ? null : l, (i6 & 4) != 0 ? null : str2, (i6 & 8) != 0 ? new Bundle() : bundle, (i6 & 16) != 0 ? 0 : i);
    }
}
