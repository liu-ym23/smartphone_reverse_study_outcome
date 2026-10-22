package com.stepos.alphame.persona.domain.event;

import com.stepos.alphame.persona.data.config.PersonalPreferenceConfigs;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/alphame/persona/domain/event/EventId;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", PersonalPreferenceConfigs.KEY_TIME_AWAY_FROM_HOME, PersonalPreferenceConfigs.KEY_OFF_DUTY_TIME, PersonalPreferenceConfigs.KEY_SLEEP_TIME, PersonalPreferenceConfigs.KEY_WAKE_UP_TIME, PersonalPreferenceConfigs.KEY_CAR_BLUETOOTH, PersonalPreferenceConfigs.KEY_HOME_WIFI, PersonalPreferenceConfigs.KEY_COMPANY_WIFI, PersonalPreferenceConfigs.KEY_HOME_ADDRESS, PersonalPreferenceConfigs.KEY_COMPANY_ADDRESS, PersonalPreferenceConfigs.KEY_COMMUTING_MODE, "CLEAR_DATA", "INVALID", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EventId {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EventId[] $VALUES;
    private final int id;
    public static final EventId TIME_AWAY_FROM_HOME = new EventId(PersonalPreferenceConfigs.KEY_TIME_AWAY_FROM_HOME, 0, 0);
    public static final EventId OFF_DUTY_TIME = new EventId(PersonalPreferenceConfigs.KEY_OFF_DUTY_TIME, 1, 1);
    public static final EventId SLEEP_TIME = new EventId(PersonalPreferenceConfigs.KEY_SLEEP_TIME, 2, 2);
    public static final EventId WAKE_UP_TIME = new EventId(PersonalPreferenceConfigs.KEY_WAKE_UP_TIME, 3, 3);
    public static final EventId CAR_BLUETOOTH = new EventId(PersonalPreferenceConfigs.KEY_CAR_BLUETOOTH, 4, 4);
    public static final EventId HOME_WIFI = new EventId(PersonalPreferenceConfigs.KEY_HOME_WIFI, 5, 5);
    public static final EventId COMPANY_WIFI = new EventId(PersonalPreferenceConfigs.KEY_COMPANY_WIFI, 6, 6);
    public static final EventId HOME_ADDRESS = new EventId(PersonalPreferenceConfigs.KEY_HOME_ADDRESS, 7, 7);
    public static final EventId COMPANY_ADDRESS = new EventId(PersonalPreferenceConfigs.KEY_COMPANY_ADDRESS, 8, 8);
    public static final EventId COMMUTING_MODE = new EventId(PersonalPreferenceConfigs.KEY_COMMUTING_MODE, 9, 9);
    public static final EventId CLEAR_DATA = new EventId("CLEAR_DATA", 10, 10);
    public static final EventId INVALID = new EventId("INVALID", 11, 11);

    private static final /* synthetic */ EventId[] $values() {
        return new EventId[]{TIME_AWAY_FROM_HOME, OFF_DUTY_TIME, SLEEP_TIME, WAKE_UP_TIME, CAR_BLUETOOTH, HOME_WIFI, COMPANY_WIFI, HOME_ADDRESS, COMPANY_ADDRESS, COMMUTING_MODE, CLEAR_DATA, INVALID};
    }

    static {
        EventId[] eventIdArr$values = $values();
        $VALUES = eventIdArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(eventIdArr$values);
    }

    private EventId(String str, int i4, int i5) {
        this.id = i5;
    }

    @NotNull
    public static EnumEntries<EventId> getEntries() {
        return $ENTRIES;
    }

    public static EventId valueOf(String str) {
        return (EventId) Enum.valueOf(EventId.class, str);
    }

    public static EventId[] values() {
        return (EventId[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
