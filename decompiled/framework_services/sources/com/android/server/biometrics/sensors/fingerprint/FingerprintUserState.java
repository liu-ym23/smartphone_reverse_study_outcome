package com.android.server.biometrics.sensors.fingerprint;

import android.R;
import android.content.Context;
import android.hardware.fingerprint.Fingerprint;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.biometrics.sensors.BiometricUserState;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintUserState extends BiometricUserState<Fingerprint> {
    private static final String ATTR_DEVICE_ID = "deviceId";
    private static final String ATTR_FINGER_ID = "fingerId";
    private static final String ATTR_GROUP_ID = "groupId";
    private static final String ATTR_NAME = "name";
    private static final String TAG = "FingerprintState";
    private static final String TAG_FINGERPRINT = "fingerprint";
    private static final String TAG_FINGERPRINTS = "fingerprints";

    public FingerprintUserState(Context context, int userId, String fileName) {
        super(context, userId, fileName);
    }

    @Override // com.android.server.biometrics.sensors.BiometricUserState
    protected String getBiometricsTag() {
        return TAG_FINGERPRINTS;
    }

    @Override // com.android.server.biometrics.sensors.BiometricUserState
    protected int getNameTemplateResource() {
        return R.string.httpError;
    }

    @Override // com.android.server.biometrics.sensors.BiometricUserState
    protected ArrayList<Fingerprint> getCopy(ArrayList<Fingerprint> array) {
        ArrayList<Fingerprint> result = new ArrayList();
        Iterator<Fingerprint> r1 = array.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Fingerprint fp = r1.next();
        result.add(new Fingerprint(fp.getName(), fp.getGroupId(), fp.getBiometricId(), fp.getDeviceId()));
        goto L4
    L6:
        return result;
    }

    @Override // com.android.server.biometrics.sensors.BiometricUserState
    protected void doWriteState(TypedXmlSerializer serializer) throws Exception {
        monitor-enter(this);
        ArrayList<Fingerprint> fingerprints = getCopy(this.mBiometrics);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        serializer.startTag(null, TAG_FINGERPRINTS);
        int count = fingerprints.size();
        int i = 0;
    L6:
        if (i >= count) goto L8;
        Fingerprint fp = fingerprints.get(i);
        serializer.startTag(null, TAG_FINGERPRINT);
        serializer.attributeInt(null, ATTR_FINGER_ID, fp.getBiometricId());
        serializer.attribute(null, "name", fp.getName().toString());
        serializer.attributeInt(null, ATTR_GROUP_ID, fp.getGroupId());
        serializer.attributeLong(null, ATTR_DEVICE_ID, fp.getDeviceId());
        serializer.endTag(null, TAG_FINGERPRINT);
        i = i + 1;
        goto L6
    L8:
        serializer.endTag(null, TAG_FINGERPRINTS);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.android.server.biometrics.sensors.BiometricUserState
    protected void parseBiometricsLocked(TypedXmlPullParser r12) throws IOException, XmlPullParserException {
        int r0 = r12.getDepth();
    L3:
        int r1 = r12.next();
        if (r1 == 1) goto L18;
        if (r1 == 3) goto L8;
    L10:
        if (r1 == 3) goto L3;
        if (r1 == 4) goto L3;
        if (r12.getName().equals(TAG_FINGERPRINT) == false) goto L3;
        String r6 = r12.getAttributeValue(null, "name");
        int r7 = r12.getAttributeInt(null, ATTR_GROUP_ID);
        int r8 = r12.getAttributeInt(null, ATTR_FINGER_ID);
        long r9 = r12.getAttributeLong(null, ATTR_DEVICE_ID);
        this.mBiometrics.add((T) new Fingerprint(r6, r7, r8, r9));
        goto L3
    L8:
        if (r12.getDepth() > r0) goto L10;
        return;
    }
}
