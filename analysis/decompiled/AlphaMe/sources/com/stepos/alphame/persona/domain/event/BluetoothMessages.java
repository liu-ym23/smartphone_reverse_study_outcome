package com.stepos.alphame.persona.domain.event;

import com.stepos.alphame.persona.carbluetooth.bean.BluetoothInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/stepos/alphame/persona/domain/event/BluetoothMessages;", "Lcom/stepos/alphame/persona/domain/event/Messages;", "eventId", "Lcom/stepos/alphame/persona/domain/event/EventId;", "bluetoothInfo", "Lcom/stepos/alphame/persona/carbluetooth/bean/BluetoothInfo;", "(Lcom/stepos/alphame/persona/domain/event/EventId;Lcom/stepos/alphame/persona/carbluetooth/bean/BluetoothInfo;)V", "getBluetoothInfo", "()Lcom/stepos/alphame/persona/carbluetooth/bean/BluetoothInfo;", "getEventId", "()Lcom/stepos/alphame/persona/domain/event/EventId;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BluetoothMessages extends Messages {

    @NotNull
    private final BluetoothInfo bluetoothInfo;

    @NotNull
    private final EventId eventId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BluetoothMessages(@NotNull EventId eventId, @NotNull BluetoothInfo bluetoothInfo) {
        super(eventId);
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(bluetoothInfo, "bluetoothInfo");
        this.eventId = eventId;
        this.bluetoothInfo = bluetoothInfo;
    }

    public static /* synthetic */ BluetoothMessages copy$default(BluetoothMessages bluetoothMessages, EventId eventId, BluetoothInfo bluetoothInfo, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            eventId = bluetoothMessages.eventId;
        }
        if ((i4 & 2) != 0) {
            bluetoothInfo = bluetoothMessages.bluetoothInfo;
        }
        return bluetoothMessages.copy(eventId, bluetoothInfo);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final EventId getEventId() {
        return this.eventId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final BluetoothInfo getBluetoothInfo() {
        return this.bluetoothInfo;
    }

    @NotNull
    public final BluetoothMessages copy(@NotNull EventId eventId, @NotNull BluetoothInfo bluetoothInfo) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(bluetoothInfo, "bluetoothInfo");
        return new BluetoothMessages(eventId, bluetoothInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BluetoothMessages)) {
            return false;
        }
        BluetoothMessages bluetoothMessages = (BluetoothMessages) other;
        return this.eventId == bluetoothMessages.eventId && Intrinsics.areEqual(this.bluetoothInfo, bluetoothMessages.bluetoothInfo);
    }

    @NotNull
    public final BluetoothInfo getBluetoothInfo() {
        return this.bluetoothInfo;
    }

    @NotNull
    public final EventId getEventId() {
        return this.eventId;
    }

    public int hashCode() {
        return this.bluetoothInfo.hashCode() + (this.eventId.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "BluetoothMessages(eventId=" + this.eventId + ", bluetoothInfo=" + this.bluetoothInfo + ")";
    }
}
