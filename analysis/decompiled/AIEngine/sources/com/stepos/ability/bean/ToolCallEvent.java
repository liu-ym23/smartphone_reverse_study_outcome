package com.stepos.ability.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ToolCallEvent implements Parcelable {
    public static final int TYPE_PROGRESS = 2;
    public static final int TYPE_RESULT = 3;
    public static final int TYPE_START = 1;
    public static final b Companion = new b();
    public static final Parcelable.Creator<ToolCallEvent> CREATOR = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<ToolCallEvent> {
        @Override // android.os.Parcelable.Creator
        public final ToolCallEvent createFromParcel(Parcel source) {
            g.f(source, "source");
            int i10 = source.readInt();
            if (i10 == 1) {
                ToolCallStart toolCallStartCreateFromParcel = ToolCallStart.CREATOR.createFromParcel(source);
                g.e(toolCallStartCreateFromParcel, "createFromParcel(...)");
                return toolCallStartCreateFromParcel;
            }
            if (i10 == 2) {
                ToolCallProgress toolCallProgressCreateFromParcel = ToolCallProgress.CREATOR.createFromParcel(source);
                g.e(toolCallProgressCreateFromParcel, "createFromParcel(...)");
                return toolCallProgressCreateFromParcel;
            }
            if (i10 != 3) {
                throw new IllegalArgumentException("Unknown ToolCallEvent type");
            }
            ToolCallResult toolCallResultCreateFromParcel = ToolCallResult.CREATOR.createFromParcel(source);
            g.e(toolCallResultCreateFromParcel, "createFromParcel(...)");
            return toolCallResultCreateFromParcel;
        }

        @Override // android.os.Parcelable.Creator
        public final ToolCallEvent[] newArray(int i10) {
            return new ToolCallEvent[i10];
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
    }

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
