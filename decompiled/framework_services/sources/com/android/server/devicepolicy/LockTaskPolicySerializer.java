package com.android.server.devicepolicy;

import android.app.admin.LockTaskPolicy;
import android.app.admin.PolicyValue;
import android.util.Log;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
final class LockTaskPolicySerializer extends PolicySerializer<LockTaskPolicy> {
    private static final String ATTR_FLAGS = "flags";
    private static final String ATTR_PACKAGES = "packages";
    private static final String ATTR_PACKAGES_SEPARATOR = ";";
    private static final String TAG = "LockTaskPolicySerializer";

    LockTaskPolicySerializer() {
    }

    @Override // com.android.server.devicepolicy.PolicySerializer
    /* bridge */ /* synthetic */ PolicyValue<LockTaskPolicy> readFromXml(TypedXmlPullParser r1) {
        return readFromXml2(r1);
    }

    @Override // com.android.server.devicepolicy.PolicySerializer
    /* bridge */ /* synthetic */ void saveToXml(TypedXmlSerializer r1, LockTaskPolicy r2) throws IOException {
        saveToXml2(r1, r2);
    }

    /* JADX INFO: renamed from: saveToXml, reason: avoid collision after fix types in other method */
    void saveToXml2(TypedXmlSerializer serializer, LockTaskPolicy value) throws IOException {
        value.getClass();
        serializer.attribute(null, ATTR_PACKAGES, String.join(ATTR_PACKAGES_SEPARATOR, value.getPackages()));
        serializer.attributeInt(null, ATTR_FLAGS, value.getFlags());
    }

    /* JADX INFO: renamed from: readFromXml, reason: avoid collision after fix types in other method */
    LockTaskPolicy readFromXml2(TypedXmlPullParser parser) {
        String packagesStr = parser.getAttributeValue(null, ATTR_PACKAGES);
        if (packagesStr != null) goto L6;
        Log.e(TAG, "Error parsing LockTask policy value.");
        return null;
    L6:
        Set<String> packages = Set.of(packagesStr.split(ATTR_PACKAGES_SEPARATOR));
        int flags = parser.getAttributeInt(null, ATTR_FLAGS);     // Catch: XmlPullParserException -> L9
        return new LockTaskPolicy(packages, flags);
    L9:
        e = move-exception;
        Log.e(TAG, "Error parsing LockTask policy value", e);
        return null;
    }
}
