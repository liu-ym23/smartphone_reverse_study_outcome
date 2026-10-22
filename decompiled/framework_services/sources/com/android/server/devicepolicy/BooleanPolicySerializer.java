package com.android.server.devicepolicy;

import android.app.admin.BooleanPolicyValue;
import android.app.admin.PolicyValue;
import android.util.Log;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class BooleanPolicySerializer extends PolicySerializer<Boolean> {
    private static final String ATTR_VALUE = "value";
    private static final String TAG = "BooleanPolicySerializer";

    BooleanPolicySerializer() {
    }

    @Override // com.android.server.devicepolicy.PolicySerializer
    /* bridge */ /* synthetic */ PolicyValue<Boolean> readFromXml(TypedXmlPullParser r1) {
        return readFromXml2(r1);
    }

    @Override // com.android.server.devicepolicy.PolicySerializer
    /* bridge */ /* synthetic */ void saveToXml(TypedXmlSerializer r1, Boolean r2) throws IOException {
        saveToXml2(r1, r2);
    }

    /* JADX INFO: renamed from: saveToXml, reason: avoid collision after fix types in other method */
    void saveToXml2(TypedXmlSerializer serializer, Boolean value) throws IOException {
        value.getClass();
        serializer.attributeBoolean(null, ATTR_VALUE, value.booleanValue());
    }

    /* JADX INFO: renamed from: readFromXml, reason: avoid collision after fix types in other method */
    BooleanPolicyValue readFromXml2(TypedXmlPullParser parser) {
        return new BooleanPolicyValue(parser.getAttributeBoolean(null, ATTR_VALUE));
    L5:
        e = move-exception;
        Log.e(TAG, "Error parsing Boolean policy value", e);
        return null;
    }
}
