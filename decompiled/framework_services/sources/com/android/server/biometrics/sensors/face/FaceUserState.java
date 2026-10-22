package com.android.server.biometrics.sensors.face;

import android.R;
import android.content.Context;
import android.hardware.face.Face;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.biometrics.sensors.BiometricUserState;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class FaceUserState extends BiometricUserState<Face> {
    private static final String ATTR_DEVICE_ID = "deviceId";
    private static final String ATTR_FACE_ID = "faceId";
    private static final String ATTR_NAME = "name";
    private static final String TAG = "FaceState";
    private static final String TAG_FACE = "face";
    private static final String TAG_FACES = "faces";

    public FaceUserState(Context ctx, int userId, String fileName) {
        super(ctx, userId, fileName);
    }

    @Override // com.android.server.biometrics.sensors.BiometricUserState
    protected String getBiometricsTag() {
        return TAG_FACES;
    }

    @Override // com.android.server.biometrics.sensors.BiometricUserState
    protected int getNameTemplateResource() {
        return R.string.forward_intent_to_owner;
    }

    @Override // com.android.server.biometrics.sensors.BiometricUserState
    protected ArrayList<Face> getCopy(ArrayList<Face> array) {
        ArrayList<Face> result = new ArrayList();
        Iterator<Face> r1 = array.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Face f = r1.next();
        result.add(new Face(f.getName(), f.getBiometricId(), f.getDeviceId()));
        goto L4
    L6:
        return result;
    }

    @Override // com.android.server.biometrics.sensors.BiometricUserState
    protected void doWriteState(TypedXmlSerializer serializer) throws Exception {
        monitor-enter(this);
        ArrayList<Face> faces = getCopy(this.mBiometrics);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        serializer.startTag(null, TAG_FACES);
        int count = faces.size();
        int i = 0;
    L6:
        if (i >= count) goto L8;
        Face f = faces.get(i);
        serializer.startTag(null, TAG_FACE);
        serializer.attributeInt(null, ATTR_FACE_ID, f.getBiometricId());
        serializer.attribute(null, "name", f.getName().toString());
        serializer.attributeLong(null, ATTR_DEVICE_ID, f.getDeviceId());
        serializer.endTag(null, TAG_FACE);
        i = i + 1;
        goto L6
    L8:
        serializer.endTag(null, TAG_FACES);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.android.server.biometrics.sensors.BiometricUserState
    protected void parseBiometricsLocked(TypedXmlPullParser r10) throws IOException, XmlPullParserException {
        int r0 = r10.getDepth();
    L3:
        int r1 = r10.next();
        if (r1 == 1) goto L18;
        if (r1 == 3) goto L8;
    L10:
        if (r1 == 3) goto L3;
        if (r1 == 4) goto L3;
        if (r10.getName().equals(TAG_FACE) == false) goto L3;
        String r3 = r10.getAttributeValue(null, "name");
        int r5 = r10.getAttributeInt(null, ATTR_FACE_ID);
        long r6 = r10.getAttributeLong(null, ATTR_DEVICE_ID);
        this.mBiometrics.add((T) new Face(r3, r5, r6));
        goto L3
    L8:
        if (r10.getDepth() > r0) goto L10;
        return;
    }
}
