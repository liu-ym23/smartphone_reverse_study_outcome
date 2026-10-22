package com.android.server.devicepolicy;

import android.app.admin.IntegerPolicyValue;
import android.app.admin.PolicyValue;
import android.util.Log;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class IntegerPolicySerializer extends PolicySerializer<Integer> {
    private static final String ATTR_VALUE = "value";
    private static final String TAG = "IntegerPolicySerializer";

    IntegerPolicySerializer() {
    }

    @Override // com.android.server.devicepolicy.PolicySerializer
    /* bridge */ /* synthetic */ PolicyValue<Integer> readFromXml(TypedXmlPullParser r1) {
        return readFromXml2(r1);
    }

    @Override // com.android.server.devicepolicy.PolicySerializer
    /* bridge */ /* synthetic */ void saveToXml(TypedXmlSerializer r1, Integer r2) throws IOException {
        saveToXml2(r1, r2);
    }

    /* JADX INFO: renamed from: saveToXml, reason: avoid collision after fix types in other method */
    void saveToXml2(TypedXmlSerializer serializer, Integer value) throws IOException {
        value.getClass();
        serializer.attributeInt(null, ATTR_VALUE, value.intValue());
    }

    /* JADX INFO: renamed from: readFromXml, reason: avoid collision after fix types in other method */
    IntegerPolicyValue readFromXml2(TypedXmlPullParser parser) {
        return new IntegerPolicyValue(parser.getAttributeInt(null, ATTR_VALUE));
    L5:
        e = move-exception;
        Log.e(TAG, "Error parsing Integer policy value", e);
        return null;
    }
}
