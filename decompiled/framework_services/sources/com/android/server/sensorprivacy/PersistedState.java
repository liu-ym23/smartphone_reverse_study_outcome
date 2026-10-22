package com.android.server.sensorprivacy;

import android.os.Environment;
import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.internal.util.function.QuadConsumer;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.IoThread;
import com.android.server.LocalServices;
import com.android.server.pm.UserManagerInternal;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import com.android.server.voiceinteraction.DatabaseHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
class PersistedState {
    private static final int CURRENT_PERSISTENCE_VERSION = 2;
    private static final int CURRENT_VERSION = 2;
    private static final String LOG_TAG = null;
    private static final String XML_ATTRIBUTE_LAST_CHANGE = "last-change";
    private static final String XML_ATTRIBUTE_PERSISTENCE_VERSION = "persistence-version";
    private static final String XML_ATTRIBUTE_SENSOR = "sensor";
    private static final String XML_ATTRIBUTE_STATE_TYPE = "state-type";
    private static final String XML_ATTRIBUTE_TOGGLE_TYPE = "toggle-type";
    private static final String XML_ATTRIBUTE_USER_ID = "user-id";
    private static final String XML_ATTRIBUTE_VERSION = "version";
    private static final String XML_TAG_SENSOR_PRIVACY = "sensor-privacy";
    private static final String XML_TAG_SENSOR_STATE = "sensor-state";
    private final AtomicFile mAtomicFile;
    private ArrayMap<TypeUserSensor, SensorState> mStates;

    private static class PVersion0 {
        private SparseArray<SensorState> mIndividualEnabled;

        /* JADX INFO: renamed from: -$$Nest$fgetmIndividualEnabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ SparseArray m8077$$Nest$fgetmIndividualEnabled(PVersion0 r0) {
            return r0.mIndividualEnabled;
        }

        /* JADX INFO: renamed from: -$$Nest$maddState, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8078$$Nest$maddState(PVersion0 r0, int r1, boolean r2) {
            r0.addState(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mupgrade, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8079$$Nest$mupgrade(PVersion0 r0) {
            r0.upgrade();
        }

        /* synthetic */ PVersion0(int r1, PersistedStateIA r2) {
            this(r1);
        }

        private PVersion0(int version) {
            this.mIndividualEnabled = new SparseArray();
            if (version != 0) goto L6;
            return;
        L6:
            throw new RuntimeException("Only version 0 supported");
        }

        private void addState(int sensor, boolean enabled) {
            this.mIndividualEnabled.put(sensor, new SensorState(enabled));
        }

        private void upgrade() {
        }
    }

    private static class PVersion1 {
        private SparseArray<SparseArray<SensorState>> mIndividualEnabled;

        /* JADX INFO: renamed from: -$$Nest$fgetmIndividualEnabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ SparseArray m8080$$Nest$fgetmIndividualEnabled(PVersion1 r0) {
            return r0.mIndividualEnabled;
        }

        /* JADX INFO: renamed from: -$$Nest$maddState, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8081$$Nest$maddState(PVersion1 r0, int r1, int r2, boolean r3) {
            r0.addState(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$mupgrade, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8082$$Nest$mupgrade(PVersion1 r0) {
            r0.upgrade();
        }

        /* JADX INFO: renamed from: -$$Nest$smfromPVersion0, reason: not valid java name */
        static /* bridge */ /* synthetic */ PVersion1 m8083$$Nest$smfromPVersion0(PVersion0 r0) {
            return fromPVersion0(r0);
        }

        /* synthetic */ PVersion1(int r1, PersistedStateIA r2) {
            this(r1);
        }

        private PVersion1(int version) {
            this.mIndividualEnabled = new SparseArray();
            if (version != 1) goto L6;
            return;
        L6:
            throw new RuntimeException("Only version 1 supported");
        }

        private static PVersion1 fromPVersion0(PVersion0 version0) {
            PVersion0.m8079$$Nest$mupgrade(version0);
            PVersion1 result = new PVersion1(1);
            int[] users = {0};
            users = ((UserManagerInternal) LocalServices.getService(UserManagerInternal.class)).getUserIds();     // Catch: Exception -> L5
        L7:
            int i = 0;
        L9:
            if (i >= users.length) goto L16;
            int userId = users[i];
            int j = 0;
        L12:
            if (j >= PVersion0.m8077$$Nest$fgetmIndividualEnabled(version0).size()) goto L14;
            int sensor = PVersion0.m8077$$Nest$fgetmIndividualEnabled(version0).keyAt(j);
            SensorState sensorState = (SensorState) PVersion0.m8077$$Nest$fgetmIndividualEnabled(version0).valueAt(j);
            result.addState(userId, sensor, sensorState.isEnabled());
            j = j + 1;
            goto L12
        L14:
            i = i + 1;
            goto L9
        L16:
            return result;
        L5:
            e = move-exception;
            Log.e(PersistedState.m8076$$Nest$sfgetLOG_TAG(), "Unable to get users.", e);
            goto L7
        }

        private void addState(int userId, int sensor, boolean enabled) {
            SparseArray<SensorState> userIndividualSensorEnabled = this.mIndividualEnabled.get(userId, new SparseArray());
            this.mIndividualEnabled.put(userId, userIndividualSensorEnabled);
            userIndividualSensorEnabled.put(sensor, new SensorState(enabled));
        }

        private void upgrade() {
        }
    }

    private static class PVersion2 {
        private ArrayMap<TypeUserSensor, SensorState> mStates;

        /* JADX INFO: renamed from: -$$Nest$fgetmStates, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayMap m8084$$Nest$fgetmStates(PVersion2 r0) {
            return r0.mStates;
        }

        /* JADX INFO: renamed from: -$$Nest$maddState, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8085$$Nest$maddState(PVersion2 r0, int r1, int r2, int r3, int r4, long r5) {
            r0.addState(r1, r2, r3, r4, r5);
        }

        /* JADX INFO: renamed from: -$$Nest$smfromPVersion1, reason: not valid java name */
        static /* bridge */ /* synthetic */ PVersion2 m8086$$Nest$smfromPVersion1(PVersion1 r0) {
            return fromPVersion1(r0);
        }

        /* synthetic */ PVersion2(int r1, PersistedStateIA r2) {
            this(r1);
        }

        private PVersion2(int version) {
            this.mStates = new ArrayMap();
            if (version != 2) goto L6;
            return;
        L6:
            throw new RuntimeException("Only version 2 supported");
        }

        private static PVersion2 fromPVersion1(PVersion1 version1) {
            PVersion1.m8082$$Nest$mupgrade(version1);
            PVersion2 result = new PVersion2(2);
            SparseArray<SparseArray<SensorState>> individualEnabled = PVersion1.m8080$$Nest$fgetmIndividualEnabled(version1);
            int numUsers = individualEnabled.size();
            int i = 0;
        L3:
            if (i >= numUsers) goto L9;
            int userId = individualEnabled.keyAt(i);
            SparseArray<SensorState> userIndividualEnabled = individualEnabled.valueAt(i);
            int numSensors = userIndividualEnabled.size();
            int j = 0;
        L5:
            if (j >= numSensors) goto L7;
            int sensor = userIndividualEnabled.keyAt(j);
            SensorState sensorState = userIndividualEnabled.valueAt(j);
            result.addState(1, userId, sensor, sensorState.getState(), sensorState.getLastChange());
            j = j + 1;
            goto L5
        L7:
            i = i + 1;
            goto L3
        L9:
            return result;
        }

        private void addState(int toggleType, int userId, int sensor, int state, long lastChange) {
            this.mStates.put(new TypeUserSensor(toggleType, userId, sensor), new SensorState(state, lastChange));
        }
    }

    private static class TypeUserSensor {
        int mSensor;
        int mType;
        int mUserId;

        TypeUserSensor(int type, int userId, int sensor) {
            this.mType = type;
            this.mUserId = userId;
            this.mSensor = sensor;
        }

        TypeUserSensor(TypeUserSensor typeUserSensor) {
            this(typeUserSensor.mType, typeUserSensor.mUserId, typeUserSensor.mSensor);
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof TypeUserSensor) == true) goto L8;
            return false;
        L8:
            TypeUserSensor that = (TypeUserSensor) o;
            if (this.mType != that.mType) goto L16;
            if (this.mUserId != that.mUserId) goto L16;
            if (this.mSensor != that.mSensor) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            return (((this.mType * 31) + this.mUserId) * 31) + this.mSensor;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$7IQf-UpFyGa5zIamP1HgWaOc-kY, reason: not valid java name */
    public static /* synthetic */ void m8075$r8$lambda$7IQfUpFyGa5zIamP1HgWaOckY(PersistedState r0, ArrayMap r1) {
        r0.persist(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetLOG_TAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8076$$Nest$sfgetLOG_TAG() {
        return LOG_TAG;
    }

    static {
        LOG_TAG = PersistedState.class.getSimpleName();
    }

    static PersistedState fromFile(String fileName) {
        return new PersistedState(fileName);
    }

    private PersistedState(String fileName) {
        this.mStates = new ArrayMap();
        this.mAtomicFile = new AtomicFile(new File(Environment.getDataSystemDirectory(), fileName));
        readState();
    }

    private void readState() {
        AtomicFile file = this.mAtomicFile;
        if (file.exists() == true) goto L26;
        AtomicFile fileToMigrateFrom = new AtomicFile(new File(Environment.getDataSystemDirectory(), "sensor_privacy.xml"));
        if (fileToMigrateFrom.exists() == false) goto L26;
        FileInputStream inputStream = fileToMigrateFrom.openRead();     // Catch: XmlPullParserException -> L12 IOException -> L14
        XmlUtils.beginDocument(Xml.resolvePullParser(inputStream), XML_TAG_SENSOR_PRIVACY);     // Catch: Throwable -> L17
        file = fileToMigrateFrom;
        if (inputStream == null) goto L26;
        inputStream.close();     // Catch: XmlPullParserException -> L12 IOException -> L14
    L17:
        th = move-exception;
        if (inputStream != null) goto L69;
    L24:
        throw th;     // Catch: XmlPullParserException -> L12 IOException -> L14
    L69:
        inputStream.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: XmlPullParserException -> L12 IOException -> L14
    L14:
        e = move-exception;
        Log.e(LOG_TAG, "Caught an exception reading the state from storage: ", e);
        fileToMigrateFrom.delete();
    L26:
        Object nonupgradedState = null;
        int r5 = 2;
        PersistedStateIA r6 = null;
        if (file.exists() == true) goto L73;
    L56:
        if (nonupgradedState != null) goto L59;
        nonupgradedState = new PVersion2(r5, r6);
    L59:
        if ((nonupgradedState instanceof PVersion0) == false) goto L62;
        nonupgradedState = PVersion1.m8083$$Nest$smfromPVersion0((PVersion0) nonupgradedState);
    L62:
        if ((nonupgradedState instanceof PVersion1) == false) goto L65;
        nonupgradedState = PVersion2.m8086$$Nest$smfromPVersion1((PVersion1) nonupgradedState);
    L65:
        if ((nonupgradedState instanceof PVersion2) == false) goto L67;
        PVersion2 upgradedState = (PVersion2) nonupgradedState;
        this.mStates = PVersion2.m8084$$Nest$fgetmStates(upgradedState);
        return;
    L67:
        Log.e(LOG_TAG, "State not successfully upgraded.");
        this.mStates = new ArrayMap();
        return;
    L73:
        FileInputStream inputStream2 = file.openRead();     // Catch: Throwable -> L45
        TypedXmlPullParser parser = Xml.resolvePullParser(inputStream2);     // Catch: Throwable -> L33
        XmlUtils.beginDocument(parser, XML_TAG_SENSOR_PRIVACY);     // Catch: Throwable -> L33
        int persistenceVersion = parser.getAttributeInt(null, XML_ATTRIBUTE_PERSISTENCE_VERSION, 0);     // Catch: Throwable -> L33
        if (persistenceVersion != 0) goto L36;
        int version = 0;
        PVersion0 version0 = new PVersion0(version, r6);     // Catch: Throwable -> L33
        nonupgradedState = version0;
        readPVersion0(parser, version0);     // Catch: Throwable -> L33
    L42:
        if (inputStream2 == null) goto L56;
        inputStream2.close();     // Catch: Throwable -> L45 Throwable -> L45 Throwable -> L45
        goto L56
    L36:
        if (persistenceVersion != 1) goto L38;
        int version2 = parser.getAttributeInt(null, XML_ATTRIBUTE_VERSION, 1);     // Catch: Throwable -> L33
        PVersion1 version1 = new PVersion1(version2, r6);     // Catch: Throwable -> L33
        nonupgradedState = version1;
        readPVersion1(parser, version1);     // Catch: Throwable -> L33
        goto L42
    L38:
        if (persistenceVersion != 2) goto L40;
        int version3 = parser.getAttributeInt(null, XML_ATTRIBUTE_VERSION, 2);     // Catch: Throwable -> L33
        PVersion2 version4 = new PVersion2(version3, r6);     // Catch: Throwable -> L33
        nonupgradedState = version4;
        readPVersion2(parser, version4);     // Catch: Throwable -> L33
        goto L42
    L40:
        Log.e(LOG_TAG, "Unknown persistence version: " + persistenceVersion + ". Deleting.", new RuntimeException());     // Catch: Throwable -> L33
        file.delete();     // Catch: Throwable -> L33
        nonupgradedState = null;
    L33:
        th = move-exception;
        if (inputStream2 != null) goto L71;
    L54:
        throw th;     // Catch: Throwable -> L45 Throwable -> L45 Throwable -> L45
    L71:
        inputStream2.close();     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L45 Throwable -> L45 Throwable -> L45
    L45:
        e = move-exception;
        Log.e(LOG_TAG, "Caught an exception reading the state from storage: ", e);
        file.delete();
        nonupgradedState = null;
        goto L56
    }

    private static void readPVersion0(TypedXmlPullParser parser, PVersion0 version0) throws XmlPullParserException, IOException {
        XmlUtils.nextElement(parser);
    L4:
        if (parser.getEventType() == 1) goto L9;
        if ("individual-sensor-privacy".equals(parser.getName()) == true) goto L7;
        XmlUtils.nextElement(parser);
        goto L4
    L7:
        int sensor = XmlUtils.readIntAttribute(parser, XML_ATTRIBUTE_SENSOR);
        boolean indEnabled = XmlUtils.readBooleanAttribute(parser, ServiceConfigAccessor.PROVIDER_MODE_ENABLED);
        PVersion0.m8078$$Nest$maddState(version0, sensor, indEnabled);
        XmlUtils.skipCurrentTag(parser);
        goto L4
    }

    private static void readPVersion1(TypedXmlPullParser parser, PVersion1 version1) throws XmlPullParserException, IOException {
    L3:
        if (parser.getEventType() == 1) goto L13;
        XmlUtils.nextElement(parser);
        if ("user".equals(parser.getName()) == false) goto L3;
        int currentUserId = parser.getAttributeInt(null, "id");
        int depth = parser.getDepth();
    L8:
        if (XmlUtils.nextElementWithin(parser, depth) == false) goto L3;
        if ("individual-sensor-privacy".equals(parser.getName()) == false) goto L8;
        int sensor = parser.getAttributeInt(null, XML_ATTRIBUTE_SENSOR);
        boolean isEnabled = parser.getAttributeBoolean(null, ServiceConfigAccessor.PROVIDER_MODE_ENABLED);
        PVersion1.m8081$$Nest$maddState(version1, currentUserId, sensor, isEnabled);
        goto L8
    }

    private static void readPVersion2(TypedXmlPullParser parser, PVersion2 version2) throws XmlPullParserException, IOException {
    L3:
        if (parser.getEventType() == 1) goto L8;
        XmlUtils.nextElement(parser);
        if (XML_TAG_SENSOR_STATE.equals(parser.getName()) == true) goto L6;
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L6:
        int toggleType = parser.getAttributeInt(null, XML_ATTRIBUTE_TOGGLE_TYPE);
        int userId = parser.getAttributeInt(null, XML_ATTRIBUTE_USER_ID);
        int sensor = parser.getAttributeInt(null, XML_ATTRIBUTE_SENSOR);
        int state = parser.getAttributeInt(null, XML_ATTRIBUTE_STATE_TYPE);
        long lastChange = parser.getAttributeLong(null, XML_ATTRIBUTE_LAST_CHANGE);
        PVersion2.m8085$$Nest$maddState(version2, toggleType, userId, sensor, state, lastChange);
        goto L3
    }

    public SensorState getState(int toggleType, int userId, int sensor) {
        return this.mStates.get(new TypeUserSensor(toggleType, userId, sensor));
    }

    public SensorState setState(int toggleType, int userId, int sensor, SensorState sensorState) {
        return this.mStates.put(new TypeUserSensor(toggleType, userId, sensor), sensorState);
    }

    void schedulePersist() {
        int numStates = this.mStates.size();
        ArrayMap<TypeUserSensor, SensorState> statesCopy = new ArrayMap();
        int i = 0;
    L3:
        if (i >= numStates) goto L5;
        statesCopy.put(new TypeUserSensor(this.mStates.keyAt(i)), new SensorState(this.mStates.valueAt(i)));
        i = i + 1;
        goto L3
    L5:
        IoThread.getHandler().sendMessage(PooledLambda.obtainMessage(new PersistedState$$ExternalSyntheticLambda0(), this, statesCopy));
    }

    private void persist(ArrayMap<TypeUserSensor, SensorState> states) {
        FileOutputStream outputStream = null;
        outputStream = this.mAtomicFile.startWrite();     // Catch: IOException -> L11
        TypedXmlSerializer serializer = Xml.resolveSerializer(outputStream);     // Catch: IOException -> L11
        serializer.startDocument(null, true);     // Catch: IOException -> L11
        serializer.startTag(null, XML_TAG_SENSOR_PRIVACY);     // Catch: IOException -> L11
        serializer.attributeInt(null, XML_ATTRIBUTE_PERSISTENCE_VERSION, 2);     // Catch: IOException -> L11
        serializer.attributeInt(null, XML_ATTRIBUTE_VERSION, 2);     // Catch: IOException -> L11
        int i = 0;
    L5:
        if (i >= states.size()) goto L13;
        TypeUserSensor userSensor = states.keyAt(i);     // Catch: IOException -> L11
        SensorState sensorState = states.valueAt(i);     // Catch: IOException -> L11
        if (userSensor.mType != 1) goto L10;
        serializer.startTag(null, XML_TAG_SENSOR_STATE);     // Catch: IOException -> L11
        serializer.attributeInt(null, XML_ATTRIBUTE_TOGGLE_TYPE, userSensor.mType);     // Catch: IOException -> L11
        serializer.attributeInt(null, XML_ATTRIBUTE_USER_ID, userSensor.mUserId);     // Catch: IOException -> L11
        serializer.attributeInt(null, XML_ATTRIBUTE_SENSOR, userSensor.mSensor);     // Catch: IOException -> L11
        serializer.attributeInt(null, XML_ATTRIBUTE_STATE_TYPE, sensorState.getState());     // Catch: IOException -> L11
        serializer.attributeLong(null, XML_ATTRIBUTE_LAST_CHANGE, sensorState.getLastChange());     // Catch: IOException -> L11
        serializer.endTag(null, XML_TAG_SENSOR_STATE);     // Catch: IOException -> L11
    L10:
        i = i + 1;     // Catch: IOException -> L11
        goto L5
    L13:
        serializer.endTag(null, XML_TAG_SENSOR_PRIVACY);     // Catch: IOException -> L11
        serializer.endDocument();     // Catch: IOException -> L11
        this.mAtomicFile.finishWrite(outputStream);     // Catch: IOException -> L11
        return;
    L11:
        e = move-exception;
        Log.e(LOG_TAG, "Caught an exception persisting the sensor privacy state: ", e);
        this.mAtomicFile.failWrite(outputStream);
    }

    void dump(DualDumpOutputStream dumpStream) {
        SparseArray<SparseArray<Pair<Integer, SensorState>>> statesMatrix = new SparseArray();
        int numStates = this.mStates.size();
        int i = 0;
    L3:
        if (i >= numStates) goto L8;
        int toggleType = this.mStates.keyAt(i).mType;
        int userId = this.mStates.keyAt(i).mUserId;
        int sensor = this.mStates.keyAt(i).mSensor;
        SparseArray<Pair<Integer, SensorState>> userStates = statesMatrix.get(userId);
        if (userStates != null) goto L7;
        userStates = new SparseArray();
        statesMatrix.put(userId, userStates);
    L7:
        userStates.put(sensor, new Pair(Integer.valueOf(toggleType), this.mStates.valueAt(i)));
        i = i + 1;
        goto L3
    L8:
        dumpStream.write("storage_implementation", 1138166333444L, SensorPrivacyStateControllerImpl.class.getName());
        int numUsers = statesMatrix.size();
        int i2 = 0;
    L9:
        if (i2 >= numUsers) goto L15;
        int userId2 = statesMatrix.keyAt(i2);
        long userToken = dumpStream.start(DatabaseHelper.SoundModelContract.KEY_USERS, 2246267895811L);
        dumpStream.write("user_id", 1120986464257L, userId2);
        SparseArray<Pair<Integer, SensorState>> userStates2 = statesMatrix.valueAt(i2);
        int numSensors = userStates2.size();
        int j = 0;
    L11:
        if (j >= numSensors) goto L13;
        int sensor2 = userStates2.keyAt(j);
        int toggleType2 = ((Integer) userStates2.valueAt(j).first).intValue();
        SensorState sensorState = (SensorState) userStates2.valueAt(j).second;
        SparseArray<Pair<Integer, SensorState>> userStates3 = userStates2;
        long sensorToken = dumpStream.start("sensors", 2246267895812L);
        dumpStream.write(XML_ATTRIBUTE_SENSOR, 1120986464257L, sensor2);
        long toggleToken = dumpStream.start("toggles", 2246267895810L);
        dumpStream.write("toggle_type", 1159641169924L, toggleType2);
        dumpStream.write("state_type", 1159641169925L, sensorState.getState());
        dumpStream.write("last_change", 1112396529667L, sensorState.getLastChange());
        dumpStream.end(toggleToken);
        dumpStream.end(sensorToken);
        j = j + 1;
        userStates2 = userStates3;
        numSensors = numSensors;
        statesMatrix = statesMatrix;
        numStates = numStates;
        numUsers = numUsers;
        i2 = i2;
        goto L11
    L13:
        dumpStream.end(userToken);
        i2 = i2 + 1;
        goto L9
    }

    void forEachKnownState(QuadConsumer<Integer, Integer, Integer, SensorState> consumer) {
        int numStates = this.mStates.size();
        int i = 0;
    L3:
        if (i >= numStates) goto L6;
        TypeUserSensor tus = this.mStates.keyAt(i);
        SensorState sensorState = this.mStates.valueAt(i);
        consumer.accept(Integer.valueOf(tus.mType), Integer.valueOf(tus.mUserId), Integer.valueOf(tus.mSensor), sensorState);
        i = i + 1;
        goto L3
    }

    public void resetForTesting() {
        this.mStates = new ArrayMap();
    }
}
