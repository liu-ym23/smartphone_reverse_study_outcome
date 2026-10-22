package com.android.server.alarm;

import android.util.IndentingPrintWriter;
import android.util.proto.ProtoOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public interface AlarmStore {

    @FunctionalInterface
    public interface AlarmDeliveryCalculator {
        boolean updateAlarmDelivery(Alarm r1);
    }

    void add(Alarm r1);

    void addAll(ArrayList<Alarm> r1);

    ArrayList<Alarm> asList();

    void dump(IndentingPrintWriter r1, long r2, SimpleDateFormat r4);

    void dumpProto(ProtoOutputStream r1, long r2);

    int getCount(Predicate<Alarm> r1);

    String getName();

    long getNextDeliveryTime();

    Alarm getNextWakeFromIdleAlarm();

    long getNextWakeupDeliveryTime();

    ArrayList<Alarm> remove(Predicate<Alarm> r1);

    ArrayList<Alarm> removePendingAlarms(long r1);

    void setAlarmClockRemovalListener(Runnable r1);

    int size();

    boolean updateAlarmDeliveries(AlarmDeliveryCalculator r1);
}
