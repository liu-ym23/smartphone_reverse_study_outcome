package com.stepos.ability.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ToolCallStart extends ToolCallEvent {
    private final Long abilityId;
    private final Bundle bundle;
    private final String toolCallId;
    private final String toolName;
    private final int version;
    public static final b Companion = new b();
    public static final Parcelable.Creator<ToolCallStart> CREATOR = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<ToolCallStart> {
        @Override // android.os.Parcelable.Creator
        public final ToolCallStart createFromParcel(Parcel source) {
            g.f(source, "source");
            int i10 = source.readInt();
            String string = source.readString();
            if (string == null) {
                string = "";
            }
            String str = string;
            Long lValueOf = source.readInt() != 0 ? Long.valueOf(source.readLong()) : null;
            String string2 = source.readString();
            Bundle bundle = source.readBundle(ToolCallStart.class.getClassLoader());
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
            Bundle bundle2 = bundle;
            g.c(bundle2);
            return new ToolCallStart(str, lValueOf, string2, bundle2, i10);
        }

        @Override // android.os.Parcelable.Creator
        public final ToolCallStart[] newArray(int i10) {
            return new ToolCallStart[i10];
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolCallStart(String toolCallId, Long l10, String str, Bundle bundle, int i10) {
        super(null);
        g.f(toolCallId, "toolCallId");
        g.f(bundle, "bundle");
        this.toolCallId = toolCallId;
        this.abilityId = l10;
        this.toolName = str;
        this.bundle = bundle;
        this.version = i10;
    }

    public static /* synthetic */ ToolCallStart copy$default(ToolCallStart toolCallStart, String str, Long l10, String str2, Bundle bundle, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = toolCallStart.toolCallId;
        }
        if ((i11 & 2) != 0) {
            l10 = toolCallStart.abilityId;
        }
        if ((i11 & 4) != 0) {
            str2 = toolCallStart.toolName;
        }
        if ((i11 & 8) != 0) {
            bundle = toolCallStart.bundle;
        }
        if ((i11 & 16) != 0) {
            i10 = toolCallStart.version;
        }
        int i12 = i10;
        String str3 = str2;
        return toolCallStart.copy(str, l10, str3, bundle, i12);
    }

    public final String component1() {
        return this.toolCallId;
    }

    public final Long component2() {
        return this.abilityId;
    }

    public final String component3() {
        return this.toolName;
    }

    public final Bundle component4() {
        return this.bundle;
    }

    public final int component5() {
        return this.version;
    }

    public final ToolCallStart copy(String toolCallId, Long l10, String str, Bundle bundle, int i10) {
        g.f(toolCallId, "toolCallId");
        g.f(bundle, "bundle");
        return new ToolCallStart(toolCallId, l10, str, bundle, i10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ToolCallStart)) {
            return false;
        }
        ToolCallStart toolCallStart = (ToolCallStart) obj;
        return g.b(this.toolCallId, toolCallStart.toolCallId) && g.b(this.abilityId, toolCallStart.abilityId) && g.b(this.toolName, toolCallStart.toolName) && g.b(this.bundle, toolCallStart.bundle) && this.version == toolCallStart.version;
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
        int iHashCode3 = str != null ? str.hashCode() : 0;
        return Integer.hashCode(this.version) + ((this.bundle.hashCode() + ((iHashCode2 + iHashCode3) * 31)) * 31);
    }

    public String toString() {
        String str = this.toolCallId;
        Long l10 = this.abilityId;
        String str2 = this.toolName;
        Bundle bundle = this.bundle;
        int i10 = this.version;
        StringBuilder sb2 = new StringBuilder("ToolCallStart(toolCallId=");
        sb2.append(str);
        sb2.append(", abilityId=");
        sb2.append(l10);
        sb2.append(", toolName=");
        sb2.append(str2);
        sb2.append(", bundle=");
        sb2.append(bundle);
        sb2.append(", version=");
        return ai.onnxruntime.a.j(")", i10, sb2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        parcel.writeInt(1);
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

    public /* synthetic */ ToolCallStart(String str, Long l10, String str2, Bundle bundle, int i10, int i11, e eVar) {
        this(str, (i11 & 2) != 0 ? null : l10, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? new Bundle() : bundle, (i11 & 16) != 0 ? 0 : i10);
    }
}
