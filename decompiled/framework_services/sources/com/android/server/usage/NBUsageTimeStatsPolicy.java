package com.android.server.usage;

import android.app.usage.UsageEvents;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class NBUsageTimeStatsPolicy {
    private static boolean DEBUG = false;
    private static long ONE_MINS = 0;
    private static final String TAG = "NBUsageTimeStatsPolicy";
    private static final List<String> mSkipCheckPermission = null;
    private static final SimpleDateFormat sDateFormat = null;

    private static class NBEvent {
        public int mEventType;
        public int mInstanceId;
        public String mPackage;
        public long mTimeStamp;

        /* synthetic */ NBEvent(NBUsageTimeStatsPolicyIA r1) {
            this();
        }

        private NBEvent() {
        }
    }

    public NBUsageTimeStatsPolicy() {
    }

    static {
        sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if ("eng".equals(Build.TYPE) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        DEBUG = r0;
        ONE_MINS = 60000;
        mSkipCheckPermission = Arrays.asList(new String[]{"cn.nubia.gamelauncher", "cn.nubia.gameassist", "cn.nubia.gamewidget", "com.zte.usebalance"});
        return;
    L5:
        if ("userdebug".equals(Build.TYPE) == true) goto L8;
        r0 = false;
        goto L9
    }

    public static Map<String, Integer> queryNbStatsCount(UsageEvents events, List<String> apps, long beginTime, long endTime, long threshold) {
        if (events == null) goto L85;
        if (apps == null) goto L85;
        if (apps.size() < 1) goto L85;
        Map<String, Integer> statsCountLauncher = new HashMap();
        ArrayList<UsageEvents.Event> eventListResumed = new ArrayList();
        ArrayList<UsageEvents.Event> eventListPaused = new ArrayList();
        ArrayList<UsageEvents.Event> eventListLocked = new ArrayList();
        ArrayList<UsageEvents.Event> eventListShutDown = new ArrayList();
        Map<String, Map<Integer, ArrayList<NBEvent>>> appCategoryEvents = new HashMap();
    L10:
        if (events.hasNextEvent() == false) goto L22;
        UsageEvents.Event event = new UsageEvents.Event();
        events.getNextEvent(event);
        switch(event.getEventType()) {
            case 1: goto L20;
            case 2: goto L19;
            case 17: goto L18;
            case 23: goto L17;
            case 26: goto L16;
            default: goto L14;
        };
    L16:
        eventListShutDown.add(event);
        goto L10
    L17:
        categorizeEventByPkg(event, apps, appCategoryEvents);
        goto L10
    L18:
        eventListLocked.add(event);
        goto L10
    L19:
        eventListPaused.add(event);
        categorizeEventByPkg(event, apps, appCategoryEvents);
        goto L10
    L20:
        eventListResumed.add(event);
        categorizeEventByPkg(event, apps, appCategoryEvents);
        goto L10
    L14:
        if (DEBUG == false) goto L10;
        Log.d(TAG, "Unable to offer received intent to queue");
        goto L10
    L22:
        Iterator<Map.Entry<String, Map<Integer, ArrayList<NBEvent>>>> r14 = appCategoryEvents.entrySet().iterator();
    L24:
        if (r14.hasNext() == false) goto L78;
        Map.Entry<String, Map<Integer, ArrayList<NBEvent>>> categoryEvents = r14.next();
        String pkgName = categoryEvents.getKey();
        Map<Integer, ArrayList<NBEvent>> appEvents = categoryEvents.getValue();
        Iterator<Map.Entry<Integer, ArrayList<NBEvent>>> r19 = appEvents.entrySet().iterator();
        Integer mTotalCountLauncher = 0;
    L27:
        if (r19.hasNext() == false) goto L76;
        Map.Entry<Integer, ArrayList<NBEvent>> instanceIdEvent = r19.next();
        Iterator<NBEvent> r22 = instanceIdEvent.getValue().iterator();
        Integer mTotalCountLauncher2 = mTotalCountLauncher;
        NBEvent preNBEvent = null;
        NBEvent lastNBEvent = null;
    L30:
        if (r22.hasNext() == false) goto L47;
        appCategoryEvents = appCategoryEvents;
        NBEvent nbevent = r22.next();
        lastNBEvent = nbevent;
        if (preNBEvent == null) goto L33;
        Iterator<Map.Entry<String, Map<Integer, ArrayList<NBEvent>>>> r24 = r14;
        if (preNBEvent.mEventType == 2) goto L37;
    L39:
        Map.Entry<String, Map<Integer, ArrayList<NBEvent>>> categoryEvents2 = categoryEvents;
        String prePkgname = findPreEventPkgName(beginTime, preNBEvent.mTimeStamp, eventListPaused);
        NBEvent nbevent2 = nbevent;
        long period = nbevent.mTimeStamp - preNBEvent.mTimeStamp;
        if (TextUtils.isEmpty(prePkgname) == false) goto L42;
    L46:
        preNBEvent = nbevent2;
        lastNBEvent = lastNBEvent;
        r14 = r24;
        categoryEvents = categoryEvents2;
        goto L30
    L42:
        if (prePkgname.equals(pkgName) == true) goto L46;
        if (period <= threshold) goto L46;
        mTotalCountLauncher2 = Integer.valueOf(mTotalCountLauncher2.intValue() + 1);
        goto L46
    L37:
        if (nbevent.mEventType != 1) goto L39;
        Log.d(TAG, "queryNbStatsCount, ignore !");
        nbevent2 = nbevent;
        categoryEvents2 = categoryEvents;
        goto L46
    L33:
        preNBEvent = nbevent;
        goto L30
    L47:
        Map<String, Map<Integer, ArrayList<NBEvent>>> appCategoryEvents2 = appCategoryEvents;
        Iterator<Map.Entry<String, Map<Integer, ArrayList<NBEvent>>>> r25 = r14;
        Map.Entry<String, Map<Integer, ArrayList<NBEvent>>> categoryEvents3 = categoryEvents;
        if (lastNBEvent.mEventType != 1) goto L75;
        String lastPkgname = findPreEventPkgName(beginTime, lastNBEvent.mTimeStamp, eventListPaused);
        if (TextUtils.isEmpty(lastPkgname) == true) goto L75;
        if (lastPkgname.equals(pkgName) == true) goto L75;
        long endTimefake = endTime;
        long nextLockTimestamp = findFakeEndTimestamp(lastNBEvent.mTimeStamp, endTime, eventListLocked);
        if (nextLockTimestamp > 0) goto L56;
    L58:
        long nextShutdownTimestamp = findFakeEndTimestamp(lastNBEvent.mTimeStamp, endTime, eventListShutDown);
        if (nextShutdownTimestamp > 0) goto L61;
    L63:
        long nextResumedTimestamp = findFakeEndTimestamp(lastNBEvent.mTimeStamp, endTime, eventListResumed);
        if (nextResumedTimestamp > 0) goto L66;
    L68:
        long lastPeriod = endTimefake - lastNBEvent.mTimeStamp;
        if (lastPeriod <= threshold) goto L75;
        mTotalCountLauncher2 = Integer.valueOf(mTotalCountLauncher2.intValue() + 1);
        goto L75
    L66:
        if (nextResumedTimestamp >= endTimefake) goto L68;
        endTimefake = nextResumedTimestamp;
        goto L68
    L61:
        if (nextShutdownTimestamp >= endTimefake) goto L63;
        endTimefake = nextShutdownTimestamp;
        goto L63
    L56:
        if (nextLockTimestamp >= endTimefake) goto L58;
        endTimefake = nextLockTimestamp;
    L75:
        mTotalCountLauncher = mTotalCountLauncher2;
        beginTime = beginTime;
        appCategoryEvents = appCategoryEvents2;
        r14 = r25;
        categoryEvents = categoryEvents3;
        goto L27
    L76:
        statsCountLauncher.put(pkgName, mTotalCountLauncher);
        goto L24
    L78:
        if (DEBUG == false) goto L83;
        Iterator<Map.Entry<String, Integer>> r0 = statsCountLauncher.entrySet().iterator();
    L81:
        if (r0.hasNext() == false) goto L83;
        Map.Entry<String, Integer> entry = r0.next();
        Log.d(TAG, "queryNbStatsCount, pkgname: " + entry.getKey() + ", count : " + entry.getValue());
    L83:
        return statsCountLauncher;
    L85:
        if (DEBUG == false) goto L88;
        Log.d(TAG, "queryNbStatsCount, apps is null !");
    L88:
        return new HashMap();
    }

    public static Map<String, Long> parseUsageEvents(UsageEvents events, List<String> apps, long beginTime, long endTime) {
        if (events == null) goto L120;
        if (apps == null) goto L120;
        if (apps.size() < 1) goto L120;
        ArrayList<UsageEvents.Event> eventListLocked = new ArrayList();
        ArrayList<UsageEvents.Event> eventListPaused = new ArrayList();
        ArrayList<UsageEvents.Event> eventListLocked2 = new ArrayList();
        ArrayList<UsageEvents.Event> eventListUnlocked = new ArrayList();
        ArrayList<UsageEvents.Event> eventListUnlocked2 = new ArrayList();
        Map<String, Map<Integer, ArrayList<NBEvent>>> appCategoryEvents = new HashMap();
    L10:
        if (events.hasNextEvent() == false) goto L23;
        UsageEvents.Event event = new UsageEvents.Event();
        events.getNextEvent(event);
        switch(event.getEventType()) {
            case 1: goto L21;
            case 2: goto L20;
            case 17: goto L19;
            case 18: goto L18;
            case 23: goto L17;
            case 26: goto L16;
            default: goto L14;
        };
    L16:
        eventListUnlocked2.add(event);
        goto L10
    L17:
        categorizeEventByPkg(event, apps, appCategoryEvents);
        goto L10
    L18:
        eventListUnlocked.add(event);
        goto L10
    L19:
        eventListLocked2.add(event);
        goto L10
    L20:
        eventListPaused.add(event);
        categorizeEventByPkg(event, apps, appCategoryEvents);
        goto L10
    L21:
        eventListLocked.add(event);
        categorizeEventByPkg(event, apps, appCategoryEvents);
        goto L10
    L14:
        if (DEBUG == false) goto L10;
        Log.d(TAG, "Unable to offer received intent to queue");
        goto L10
    L23:
        Map<String, Long> result = new HashMap();
        Iterator<Map.Entry<String, Map<Integer, ArrayList<NBEvent>>>> r15 = appCategoryEvents.entrySet().iterator();
    L25:
        if (r15.hasNext() == false) goto L115;
        Map.Entry<String, Map<Integer, ArrayList<NBEvent>>> categoryEvents = r15.next();
        String pkgName = categoryEvents.getKey();
        long mTotalTimeInForeground = -1;
        Map<Integer, ArrayList<NBEvent>> appEvents = categoryEvents.getValue();
        Iterator<Map.Entry<Integer, ArrayList<NBEvent>>> r20 = appEvents.entrySet().iterator();
    L28:
        if (r20.hasNext() == false) goto L106;
        Map.Entry<Integer, ArrayList<NBEvent>> instanceIdEvent = r20.next();
        int instanceId = instanceIdEvent.getKey().intValue();
        Iterator<NBEvent> r26 = instanceIdEvent.getValue().iterator();
        NBEvent nbevent = null;
        Map<String, Map<Integer, ArrayList<NBEvent>>> appCategoryEvents2 = appCategoryEvents;
        NBEvent lastNBEvent = null;
    L30:
        r15 = r15;
        if (r26.hasNext() == false) goto L78;
        pkgName = pkgName;
        nbevent = r26.next();
        lastNBEvent = nbevent;
        if (nbevent == null) goto L34;
        ArrayList<UsageEvents.Event> eventListResumed = eventListLocked;
        ArrayList<UsageEvents.Event> eventListLocked3 = eventListLocked2;
        ArrayList<UsageEvents.Event> eventListShutDown = eventListUnlocked2;
        Map<String, Long> result2 = result;
        ArrayList<UsageEvents.Event> eventListShutDown2 = eventListUnlocked;
        if (nbevent.mEventType != 2) goto L57;
        if (nbevent.mEventType != 1) goto L57;
        Log.d(TAG, "parseUsageEvents, ignore !");
        ArrayList<UsageEvents.Event> eventListLocked4 = eventListLocked3;
    L77:
        beginTime = beginTime;
        eventListLocked2 = eventListLocked4;
        eventListUnlocked = eventListShutDown2;
        result = result2;
        eventListLocked = eventListResumed;
        eventListUnlocked2 = eventListShutDown;
    L57:
        if (nbevent.mEventType == 2) goto L59;
    L70:
        eventListLocked4 = eventListLocked3;
        long period = nbevent.mTimeStamp - nbevent.mTimeStamp;
        if (period >= 0) goto L74;
        Log.d(TAG, "parseUsageEvents, period is error, preNBEvent[ " + nbevent.mPackage + ", " + nbevent.mInstanceId + ", " + nbevent.mTimeStamp + ", " + eventToString(nbevent.mEventType) + "], nbevent[" + nbevent.mPackage + ", " + nbevent.mInstanceId + ", " + nbevent.mTimeStamp + ", " + eventToString(nbevent.mEventType) + "]");
        goto L77
    L74:
        if (DEBUG == false) goto L76;
        Log.d(TAG, "parseUsageEvents, instanceId = " + instanceId + ", preNBEvent.mTimeStamp = " + sDateFormat.format(Long.valueOf(nbevent.mTimeStamp)));
    L76:
        mTotalTimeInForeground = mTotalTimeInForeground + period;
        goto L77
    L59:
        if (nbevent.mEventType != 2) goto L70;
        long fakeBeginTime = beginTime;
        long lastPausedTs = findFakeBeginTimestamp(beginTime, nbevent.mTimeStamp, eventListPaused);
        if (lastPausedTs <= fakeBeginTime) goto L63;
        fakeBeginTime = lastPausedTs;
    L63:
        eventListLocked4 = eventListLocked3;
        long lastUnlockTs = findFakeBeginTimestamp(beginTime, nbevent.mTimeStamp, eventListShutDown2);
        if (lastUnlockTs <= fakeBeginTime) goto L66;
        fakeBeginTime = lastUnlockTs;
    L66:
        long periodTime = nbevent.mTimeStamp - fakeBeginTime;
        if (periodTime <= 0) goto L77;
        mTotalTimeInForeground = mTotalTimeInForeground + periodTime;
        goto L77
    L34:
        Map<String, Long> result3 = result;
        if (nbevent.mEventType != 2) goto L50;
        long beginTimefake = beginTime;
        long lastPausedTimestamp = findFakeBeginTimestamp(beginTime, nbevent.mTimeStamp, eventListPaused);
        if (lastPausedTimestamp <= beginTimefake) goto L39;
        beginTimefake = lastPausedTimestamp;
    L39:
        long lastUnlockTimestamp = findFakeBeginTimestamp(beginTime, nbevent.mTimeStamp, eventListUnlocked);
        if (lastUnlockTimestamp <= beginTimefake) goto L42;
        beginTimefake = lastUnlockTimestamp;
    L42:
        long firstPeriod = nbevent.mTimeStamp - beginTimefake;
        if (firstPeriod <= 0) goto L46;
        mTotalTimeInForeground = mTotalTimeInForeground + firstPeriod;
    L46:
        if (DEBUG == false) goto L50;
        Log.d(TAG, "parseUsageEvents, lastUnlockTimestamp: " + sDateFormat.format(Long.valueOf(lastUnlockTimestamp)) + ", lastPausedTimestamp: " + sDateFormat.format(Long.valueOf(lastPausedTimestamp)) + ", mTimeStamp: " + sDateFormat.format(Long.valueOf(nbevent.mTimeStamp)) + ", firstPeriod: " + firstPeriod + ", instanceId = " + instanceId);
    L50:
        eventListLocked2 = eventListLocked2;
        eventListUnlocked = eventListUnlocked;
        result = result3;
        eventListLocked = eventListLocked;
        eventListUnlocked2 = eventListUnlocked2;
        goto L30
    L78:
        ArrayList<UsageEvents.Event> eventListResumed2 = eventListLocked;
        String pkgName2 = pkgName;
        ArrayList<UsageEvents.Event> eventListResumed3 = eventListLocked2;
        ArrayList<UsageEvents.Event> eventListShutDown3 = eventListUnlocked2;
        Map<String, Long> result4 = result;
        ArrayList<UsageEvents.Event> eventListShutDown4 = eventListUnlocked;
        if (lastNBEvent != null) goto L81;
    L104:
        ArrayList<UsageEvents.Event> eventListLocked5 = eventListResumed3;
        ArrayList<UsageEvents.Event> eventListResumed4 = eventListResumed2;
        ArrayList<UsageEvents.Event> eventListShutDown5 = eventListShutDown3;
    L105:
        eventListLocked2 = eventListLocked5;
        eventListUnlocked = eventListShutDown4;
        eventListLocked = eventListResumed4;
        appCategoryEvents = appCategoryEvents2;
        r15 = r15;
        pkgName = pkgName2;
        result = result4;
        beginTime = beginTime;
        eventListUnlocked2 = eventListShutDown5;
        goto L28
    L81:
        if (lastNBEvent.mEventType != 1) goto L104;
        long endTimefake = endTime;
        eventListLocked5 = eventListResumed3;
        long nextLockTimestamp = findFakeEndTimestamp(lastNBEvent.mTimeStamp, endTime, eventListLocked5);
        if (nextLockTimestamp > 0) goto L85;
    L87:
        long endTimefake2 = endTimefake;
        eventListShutDown5 = eventListShutDown3;
        long nextShutdownTimestamp = findFakeEndTimestamp(lastNBEvent.mTimeStamp, endTime, eventListShutDown5);
        if (nextShutdownTimestamp > 0) goto L90;
    L92:
        eventListResumed4 = eventListResumed2;
        long nextResumedTimestamp = findFakeEndTimestamp(lastNBEvent.mTimeStamp, endTime, eventListResumed4);
        if (nextResumedTimestamp > 0) goto L95;
    L97:
        long lastPeriod = endTimefake2 - lastNBEvent.mTimeStamp;
        if (lastPeriod <= 0) goto L101;
        mTotalTimeInForeground = mTotalTimeInForeground + lastPeriod;
    L101:
        if (DEBUG == false) goto L105;
        Log.d(TAG, "parseUsageEvents, lastNBEvent.mTimeStamp: " + sDateFormat.format(Long.valueOf(lastNBEvent.mTimeStamp)) + ", nextLockTimestamp: " + sDateFormat.format(Long.valueOf(nextLockTimestamp)) + ", nextShutdownTimestamp: " + sDateFormat.format(Long.valueOf(nextShutdownTimestamp)) + ", nextResumedTimestamp: " + sDateFormat.format(Long.valueOf(nextResumedTimestamp)) + ", lastPeriod: " + lastPeriod + ", instanceId = " + instanceId);
        goto L105
    L95:
        if (nextResumedTimestamp >= endTimefake2) goto L97;
        endTimefake2 = nextResumedTimestamp;
        goto L97
    L90:
        if (nextShutdownTimestamp >= endTimefake2) goto L92;
        endTimefake2 = nextShutdownTimestamp;
        goto L92
    L85:
        if (nextLockTimestamp >= endTimefake) goto L87;
        endTimefake = nextLockTimestamp;
        goto L87
    L106:
        String pkgName3 = pkgName;
        ArrayList<UsageEvents.Event> eventListLocked6 = eventListLocked2;
        ArrayList<UsageEvents.Event> eventListShutDown6 = eventListUnlocked2;
        Map<String, Map<Integer, ArrayList<NBEvent>>> appCategoryEvents3 = appCategoryEvents;
        Map<String, Long> result5 = result;
        Iterator<Map.Entry<String, Map<Integer, ArrayList<NBEvent>>>> r27 = r15;
        ArrayList<UsageEvents.Event> eventListResumed5 = eventListLocked;
        ArrayList<UsageEvents.Event> eventListShutDown7 = eventListUnlocked;
        if (mTotalTimeInForeground > 0) goto L109;
        Map<String, Long> result6 = result5;
    L114:
        eventListLocked2 = eventListLocked6;
        eventListUnlocked = eventListShutDown7;
        eventListLocked = eventListResumed5;
        appCategoryEvents = appCategoryEvents3;
        r15 = r27;
        result = result6;
        eventListUnlocked2 = eventListShutDown6;
        goto L25
    L109:
        if (mTotalTimeInForeground <= ONE_MINS) goto L111;
        long r0 = mTotalTimeInForeground;
    L112:
        result6 = result5;
        result6.put(pkgName3, Long.valueOf(r0));
        goto L114
    L111:
        r0 = ONE_MINS;
        goto L112
    L115:
        ArrayList<UsageEvents.Event> eventListLocked7 = eventListLocked2;
        ArrayList<UsageEvents.Event> eventListShutDown8 = eventListUnlocked2;
        Map<String, Map<Integer, ArrayList<NBEvent>>> appCategoryEvents4 = appCategoryEvents;
        Map<String, Long> result7 = result;
        ArrayList<UsageEvents.Event> eventListResumed6 = eventListLocked;
        ArrayList<UsageEvents.Event> eventListShutDown9 = eventListUnlocked;
        if (DEBUG == false) goto L118;
        debugCheckList(eventListResumed6, "ResumedEvent");
        debugCheckList(eventListPaused, "PausedEvent");
        debugCheckList(eventListLocked7, "LockedEvent");
        debugCheckList(eventListShutDown9, "UnlockedEvent");
        debugCheckList(eventListShutDown8, "ShutdownEvent");
        debugAppCategoryEvents(appCategoryEvents4);
    L118:
        return result7;
    L120:
        if (DEBUG == false) goto L123;
        Log.d(TAG, "parseUsageEvents, apps is null !");
    L123:
        return new HashMap();
    }

    private static String findPreEventPkgName(long beginTime, long endTime, ArrayList<UsageEvents.Event> eventList) {
        UsageEvents.Event[] events = (UsageEvents.Event[]) eventList.toArray(new UsageEvents.Event[eventList.size()]);
        int i = events.length - 1;
    L3:
        if (i < 0) goto L15;
        if (events[i].getTimeStamp() >= endTime) goto L9;
        if (events[i].getTimeStamp() <= beginTime) goto L9;
        String pkgname = events[i].getPackageName();
        return pkgname;
    L9:
        i = i - 1;
        goto L3
    L15:
        return null;
    }

    private static long findFakeBeginTimestamp(long beginTime, long endTime, ArrayList<UsageEvents.Event> eventList) {
        if (eventList != null) goto L5;
    L16:
        return 0;
    L5:
        if (eventList.size() < 1) goto L16;
        UsageEvents.Event[] events = (UsageEvents.Event[]) eventList.toArray(new UsageEvents.Event[eventList.size()]);
        int i = events.length - 1;
    L8:
        if (i < 0) goto L21;
        if (events[i].getTimeStamp() >= endTime) goto L14;
        if (events[i].getTimeStamp() <= beginTime) goto L14;
        long timestamp = events[i].getTimeStamp();
        return timestamp;
    L14:
        i = i - 1;
        goto L8
    L21:
        return 0;
    }

    private static long findFakeEndTimestamp(long beginTime, long endTime, ArrayList<UsageEvents.Event> eventList) {
        Iterator<UsageEvents.Event> r2 = eventList.iterator();
    L4:
        if (r2.hasNext() == false) goto L18;
        UsageEvents.Event event = r2.next();
        if (event.getTimeStamp() <= beginTime) goto L4;
        if (event.getTimeStamp() >= endTime) goto L4;
        long timestamp = event.getTimeStamp();
        return timestamp;
    L18:
        return 0;
    }

    private static void categorizeEventByPkg(UsageEvents.Event event, List<String> pkgs, Map<String, Map<Integer, ArrayList<NBEvent>>> categoryResult) {
        String pkgname = event.getPackageName();
        if (pkgs.contains(pkgname) == true) goto L5;
        return;
    L5:
        int instanceId = event.getInstanceId();
        if (instanceId > 0) goto L9;
        return;
    L9:
        if (categoryResult.containsKey(pkgname) == false) goto L21;
        Map<Integer, ArrayList<NBEvent>> events = categoryResult.get(pkgname);
        if (events.containsKey(Integer.valueOf(instanceId)) == true) goto L13;
        ArrayList<NBEvent> nbEvents = new ArrayList();
        NBEvent nbevent = eventToNBEvent(event);
        if (23 != event.getEventType()) goto L19;
        nbevent.mEventType = 2;
    L19:
        nbEvents.add(nbevent);
        events.put(Integer.valueOf(instanceId), nbEvents);
        return;
    L13:
        if (23 != event.getEventType()) goto L15;
        mergeStoppedEvent(events.get(Integer.valueOf(instanceId)), event);
        return;
    L15:
        events.get(Integer.valueOf(instanceId)).add(eventToNBEvent(event));
        return;
    L21:
        Map<Integer, ArrayList<NBEvent>> events2 = new HashMap();
        ArrayList<NBEvent> nbEvents2 = new ArrayList();
        NBEvent nbevent2 = eventToNBEvent(event);
        if (23 != event.getEventType()) goto L24;
        nbevent2.mEventType = 2;
    L24:
        nbEvents2.add(nbevent2);
        events2.put(Integer.valueOf(instanceId), nbEvents2);
        categoryResult.put(pkgname, events2);
    }

    private static void mergeStoppedEvent(ArrayList<NBEvent> eventList, UsageEvents.Event stoppedEvent) {
        int size = eventList.size();
        if (size >= 1) goto L5;
        return;
    L5:
        NBEvent preEvent = eventList.get(size - 1);
        if (1 != preEvent.mEventType) goto L9;
        NBEvent pausedEvent = eventToNBEvent(stoppedEvent);
        pausedEvent.mEventType = 2;
        eventList.add(pausedEvent);
        return;
    }

    private static NBEvent eventToNBEvent(UsageEvents.Event event) {
        NBEvent nbevent = new NBEvent(null);
        nbevent.mPackage = event.getPackageName();
        nbevent.mInstanceId = event.getInstanceId();
        nbevent.mTimeStamp = event.getTimeStamp();
        nbevent.mEventType = event.getEventType();
        return nbevent;
    }

    private static String eventToString(int eventType) {
        switch(eventType) {
            case 1: goto L15;
            case 2: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            case 23: goto L7;
            case 26: goto L5;
            default: goto L4;
        };
    L5:
        return "DEVICE_SHUTDOWN";
    L7:
        return "ACTIVITY_STOPPED";
    L9:
        return "KEYGUARD_HIDDEN";
    L11:
        return "KEYGUARD_SHOWN";
    L13:
        return "ACTIVITY_PAUSED";
    L15:
        return "ACTIVITY_RESUMED";
    L4:
        return "UNKNOWN_TYPE_" + eventType;
    }

    private static void debugCheckList(ArrayList<UsageEvents.Event> events, String eventTag) {
        Iterator<UsageEvents.Event> r0 = events.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        UsageEvents.Event event = r0.next();
        Log.d(TAG, "debugCheckList," + eventTag + ":" + sDateFormat.format(Long.valueOf(event.getTimeStamp())) + ", class = " + event.getClassName());
        goto L4
    }

    private static void debugAppCategoryEvents(Map<String, Map<Integer, ArrayList<NBEvent>>> categoryResult) {
        Iterator<Map.Entry<String, Map<Integer, ArrayList<NBEvent>>>> r0 = categoryResult.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        Map.Entry<String, Map<Integer, ArrayList<NBEvent>>> categoryEvents = r0.next();
        String pkgname = categoryEvents.getKey();
        Map<Integer, ArrayList<NBEvent>> appEvents = categoryEvents.getValue();
        Iterator<Map.Entry<Integer, ArrayList<NBEvent>>> r4 = appEvents.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L4;
        Map.Entry<Integer, ArrayList<NBEvent>> instanceIdEvent = r4.next();
        int instanceId = instanceIdEvent.getKey().intValue();
        Iterator<NBEvent> r7 = instanceIdEvent.getValue().iterator();
    L10:
        if (r7.hasNext() == false) goto L7;
        NBEvent nbevent = r7.next();
        Log.d(TAG, "debugAppCategoryEvents, pkgname :" + pkgname + ", instanceId : " + instanceId + ", mTimeStamp: " + sDateFormat.format(Long.valueOf(nbevent.mTimeStamp)) + ", mEventType : " + eventToString(nbevent.mEventType));
        goto L10
    }

    public static Map<String, Long> mergeStatsResult(Map<String, Long> resultByEvents, Map<String, Long> resultByUss) {
        Iterator<Map.Entry<String, Long>> r1 = resultByUss.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<String, Long> entry = r1.next();
        String pkgname = entry.getKey();
        long time = entry.getValue().longValue();
        if (resultByEvents.containsKey(pkgname) == true) goto L7;
        resultByEvents.put(pkgname, Long.valueOf(time));
        goto L4
    L7:
        long totalTime = resultByEvents.get(pkgname).longValue();
        resultByEvents.put(pkgname, Long.valueOf(totalTime + time));
        goto L4
    L10:
        return resultByEvents;
    }

    public static boolean skipCheckPermission(String callingPackage) {
        return mSkipCheckPermission.contains(callingPackage);
    }
}
