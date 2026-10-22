package com.obric.memorydata.sdk.awareness;

import d.h.b.o;

/* JADX INFO: compiled from: EventNames.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EventNames {
    public static final String ALARM_CHANGED = "alarm_changed";
    public static final String ARRIVE_COMPANY = "arrive_company";
    public static final String ARRIVE_COMPANY_ENTRANCE = "arrive_company_entrance";
    public static final String ARRIVE_HOME = "arrive_home";
    public static final String ARRIVE_HOME_ENTRANCE = "arrive_home_entrance";
    public static final String ARRIVE_POI = "arrive_poi";
    public static final String AUTO_MEMORY_CHANGED = "auto_memory_changed";
    public static final String BLUETOOTH_DEVICE_CONNECTED = "bluetooth_device_connected";
    public static final String CALENDAR_EVENT_CHANGED = "calendar_event_changed";
    public static final String CALL_HISTORY_CHANGED = "call_history_changed";
    public static final String COUNTDOWN_CHANGED = "countdown_changed";
    public static final String ENTER_AIRPORT = "enter_airport";
    public static final String ENTER_COMPANY_GEOFENCE = "enter_company_geofence";
    public static final String ENTER_HOME_GEOFENCE = "enter_home_geofence";
    public static final String ENTER_MALL = "enter_mall";
    public static final String ENTER_RAILWAY_STATION = "enter_railway_station";
    public static final String ENTER_SUBWAY_STATION = "enter_subway_station";
    public static final String EPISODIC_MEMORY_CHANGED = "episodic_memory_changed";
    public static final String EXIT_AIRPORT = "exit_airport";
    public static final String EXIT_COMPANY_GEOFENCE = "exit_company_geofence";
    public static final String EXIT_HOME_GEOFENCE = "exit_home_geofence";
    public static final String EXIT_MALL = "exit_mall";
    public static final String EXIT_RAILWAY_STATION = "exit_railway_station";
    public static final String EXIT_SUBWAY_STATION = "exit_subway_station";
    public static final String FALL_DETECTED = "fall_detected";
    public static final String FILE_CHANGED = "file_changed";
    public static final String GEOFENCE_ENTERED = "geofence_entered";
    public static final String GEOFENCE_EXITED = "geofence_exited";
    public static final String GLASSES_PUT_ON = "glasses_put_on";
    public static final String GLASSES_TAKEN_OFF = "glasses_taken_off";
    public static final EventNames INSTANCE = null;
    public static final String LEAVE_COMPANY = "leave_company";
    public static final String LEAVE_COMPANY_ENTRANCE = "leave_company_entrance";
    public static final String LEAVE_HOME = "leave_home";
    public static final String LEAVE_HOME_ENTRANCE = "leave_home_entrance";
    public static final String LEAVE_POI = "leave_poi";
    public static final String NOTE_CHANGED = "note_changed";
    public static final String PHOTO_CREATED = "photo_created";
    public static final String PROLONGED_HEAD_DOWN_ENDED = "prolonged_head_down_ended";
    public static final String PROLONGED_HEAD_DOWN_STARTED = "prolonged_head_down_started";
    public static final String RECEIVE_NOTIFICATION = "receive_notification";
    public static final String RECEIVE_SMS = "receive_sms";
    public static final String RECORDING_SUMMARY_GENERATED = "recording_summary_generated";
    public static final String SEDENTARY_ENDED = "sedentary_ended";
    public static final String SEDENTARY_STARTED = "sedentary_started";
    public static final String SEND_SMS = "send_sms";

    static {
        INSTANCE = new EventNames();
    }

    private EventNames() {
    }

    public final boolean isGeoFenceEvent(String r1) {
        o.e(r1, "eventName");
        if (o.a(r1, GEOFENCE_ENTERED) == false) goto L5;
    L8:
        return true;
    L5:
        if (o.a(r1, GEOFENCE_EXITED) == true) goto L8;
        return false;
    }
}
