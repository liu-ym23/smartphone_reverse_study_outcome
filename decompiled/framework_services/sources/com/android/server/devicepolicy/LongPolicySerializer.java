package com.android.server.devicepolicy;

import android.app.admin.LongPolicyValue;
import android.app.admin.PolicyValue;
import android.util.Log;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class LongPolicySerializer extends PolicySerializer<Long> {
    private static final String ATTR_VALUE = "value";
    private static final String TAG = "LongPolicySerializer";

    LongPolicySerializer() {
    }

    @Override // com.android.server.devicepolicy.PolicySerializer
    /* bridge */ /* synthetic */ PolicyValue<Long> readFromXml(TypedXmlPullParser r1) {
        return readFromXml2(r1);
    }

    @Override // com.android.server.devicepolicy.PolicySerializer
    /* bridge */ /* synthetic */ void saveToXml(TypedXmlSerializer r1, Long r2) throws IOException {
        saveToXml2(r1, r2);
    }

    /* JADX INFO: renamed from: saveToXml, reason: avoid collision after fix types in other method */
    void saveToXml2(TypedXmlSerializer serializer, Long value) throws IOException {
        value.getClass();
        serializer.attributeLong(null, ATTR_VALUE, value.longValue());
    }

    /* JADX INFO: renamed from: readFromXml, reason: avoid collision after fix types in other method */
    LongPolicyValue readFromXml2(TypedXmlPullParser parser) {
        return new LongPolicyValue(parser.getAttributeLong(null, ATTR_VALUE));
    L5:
        e = move-exception;
        Log.e(TAG, "Error parsing Long policy value", e);
        return null;
    }
}
