package com.android.server.devicepolicy;

import android.app.admin.PackageSetPolicyValue;
import android.app.admin.PolicyValue;
import android.util.Log;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class PackageSetPolicySerializer extends PolicySerializer<Set<String>> {
    private static final String ATTR_VALUES = "strings";
    private static final String ATTR_VALUES_SEPARATOR = ";";

    PackageSetPolicySerializer() {
    }

    @Override // com.android.server.devicepolicy.PolicySerializer
    /* bridge */ /* synthetic */ void saveToXml(TypedXmlSerializer r1, Set<String> r2) throws IOException {
        saveToXml2(r1, r2);
    }

    /* JADX INFO: renamed from: saveToXml, reason: avoid collision after fix types in other method */
    void saveToXml2(TypedXmlSerializer serializer, Set<String> value) throws IOException {
        value.getClass();
        serializer.attribute(null, ATTR_VALUES, String.join(ATTR_VALUES_SEPARATOR, value));
    }

    @Override // com.android.server.devicepolicy.PolicySerializer
    PolicyValue<Set<String>> readFromXml(TypedXmlPullParser parser) {
        String valuesStr = parser.getAttributeValue(null, ATTR_VALUES);
        if (valuesStr != null) goto L6;
        Log.e("DevicePolicyEngine", "Error parsing PackageSet policy value.");
        return null;
    L6:
        Set<String> values = Set.of(valuesStr.split(ATTR_VALUES_SEPARATOR));
        return new PackageSetPolicyValue(values);
    }
}
