package com.android.server.sensorprivacy;

import android.os.Environment;
import android.os.Handler;
import android.util.AtomicFile;
import android.util.Log;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.IoThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class AllSensorStateController {
    private static final String LOG_TAG = null;
    private static final String SENSOR_PRIVACY_XML_FILE = "sensor_privacy.xml";
    private static final String XML_ATTRIBUTE_ENABLED = "enabled";
    private static final String XML_TAG_SENSOR_PRIVACY = "all-sensor-privacy";
    private static final String XML_TAG_SENSOR_PRIVACY_LEGACY = "sensor-privacy";
    private static AllSensorStateController sInstance;
    private final AtomicFile mAtomicFile;
    private boolean mEnabled;
    private SensorPrivacyStateController.AllSensorPrivacyListener mListener;
    private Handler mListenerHandler;

    public static /* synthetic */ void $r8$lambda$xChE0OJhLjTDhwgTSFp_J6v0xhA(AllSensorStateController r0, boolean r1) {
        r0.persist(r1);
    }

    static {
        LOG_TAG = AllSensorStateController.class.getSimpleName();
    }

    static AllSensorStateController getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new AllSensorStateController();
    L6:
        return sInstance;
    }

    private AllSensorStateController() {
        this.mAtomicFile = new AtomicFile(new File(Environment.getDataSystemDirectory(), SENSOR_PRIVACY_XML_FILE));
        if (this.mAtomicFile.exists() == true) goto L41;
        return;
    L41:
        FileInputStream inputStream = this.mAtomicFile.openRead();     // Catch: Throwable -> L29
        TypedXmlPullParser parser = Xml.resolvePullParser(inputStream);     // Catch: Throwable -> L14
    L9:
        if (parser.getEventType() == 1) goto L26;
        String tagName = parser.getName();     // Catch: Throwable -> L14
        if (XML_TAG_SENSOR_PRIVACY.equals(tagName) == true) goto L13;
        if (XML_TAG_SENSOR_PRIVACY_LEGACY.equals(tagName) == false) goto L20;
        this.mEnabled |= XmlUtils.readBooleanAttribute(parser, "enabled", false);     // Catch: Throwable -> L14
    L20:
        if ("user".equals(tagName) == false) goto L24;
        int user = XmlUtils.readIntAttribute(parser, "id", -1);     // Catch: Throwable -> L14
        if (user != 0) goto L24;
        this.mEnabled = XmlUtils.readBooleanAttribute(parser, "enabled") | this.mEnabled;     // Catch: Throwable -> L14
    L24:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L14
        goto L9
    L13:
        this.mEnabled |= XmlUtils.readBooleanAttribute(parser, "enabled", false);     // Catch: Throwable -> L14
    L26:
        if (inputStream == null) goto L51;
        inputStream.close();     // Catch: Throwable -> L29 Throwable -> L29
        return;
    L51:
        return;
    L14:
        th = move-exception;
        if (inputStream != null) goto L44;
    L38:
        throw th;     // Catch: Throwable -> L29 Throwable -> L29
    L44:
        inputStream.close();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L29 Throwable -> L29
    L29:
        e = move-exception;
        Log.e(LOG_TAG, "Caught an exception reading the state from storage: ", e);
        this.mEnabled = false;
    }

    public boolean getAllSensorStateLocked() {
        return this.mEnabled;
    }

    public void setAllSensorStateLocked(boolean enabled) {
        if (this.mEnabled == enabled) goto L10;
        this.mEnabled = enabled;
        if (this.mListener != null) goto L7;
        return;
    L7:
        if (this.mListenerHandler == null) goto L12;
        Handler r0 = this.mListenerHandler;
        final SensorPrivacyStateController.AllSensorPrivacyListener r1 = this.mListener;
        r1.getClass();
        r0.sendMessage(PooledLambda.obtainMessage(new AllSensorStateController$$ExternalSyntheticLambda0(r1), Boolean.valueOf(enabled)));
        return;
    L12:
        return;
    }

    void setAllSensorPrivacyListenerLocked(Handler handler, SensorPrivacyStateController.AllSensorPrivacyListener listener) {
        handler.getClass();
        listener.getClass();
        if (this.mListener != null) goto L7;
        this.mListener = listener;
        this.mListenerHandler = handler;
        return;
    L7:
        throw new IllegalStateException("Listener is already set");
    }

    public void schedulePersistLocked() {
        IoThread.getHandler().sendMessage(PooledLambda.obtainMessage(new AllSensorStateController$$ExternalSyntheticLambda1(this), Boolean.valueOf(this.mEnabled)));
    }

    private void persist(boolean enabled) {
        FileOutputStream outputStream = null;
        outputStream = this.mAtomicFile.startWrite();     // Catch: IOException -> L5
        TypedXmlSerializer serializer = Xml.resolveSerializer(outputStream);     // Catch: IOException -> L5
        serializer.startDocument(null, true);     // Catch: IOException -> L5
        serializer.startTag(null, XML_TAG_SENSOR_PRIVACY);     // Catch: IOException -> L5
        serializer.attributeBoolean(null, "enabled", enabled);     // Catch: IOException -> L5
        serializer.endTag(null, XML_TAG_SENSOR_PRIVACY);     // Catch: IOException -> L5
        serializer.endDocument();     // Catch: IOException -> L5
        this.mAtomicFile.finishWrite(outputStream);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        Log.e(LOG_TAG, "Caught an exception persisting the sensor privacy state: ", e);
        this.mAtomicFile.failWrite(outputStream);
    }

    void resetForTesting() {
        this.mListener = null;
        this.mListenerHandler = null;
        this.mEnabled = false;
    }

    void dumpLocked(DualDumpOutputStream dumpStream) {
    }
}
