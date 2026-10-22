package com.android.server.devicepolicy;

import android.app.admin.ComponentNamePolicyValue;
import android.app.admin.PolicyValue;
import android.content.ComponentName;
import android.util.Log;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class ComponentNamePolicySerializer extends PolicySerializer<ComponentName> {
    private static final String ATTR_CLASS_NAME = "class-name";
    private static final String ATTR_PACKAGE_NAME = "package-name";
    private static final String TAG = "ComponentNamePolicySerializer";

    ComponentNamePolicySerializer() {
    }

    @Override // com.android.server.devicepolicy.PolicySerializer
    /* bridge */ /* synthetic */ PolicyValue<ComponentName> readFromXml(TypedXmlPullParser r1) {
        return readFromXml2(r1);
    }

    @Override // com.android.server.devicepolicy.PolicySerializer
    /* bridge */ /* synthetic */ void saveToXml(TypedXmlSerializer r1, ComponentName r2) throws IOException {
        saveToXml2(r1, r2);
    }

    /* JADX INFO: renamed from: saveToXml, reason: avoid collision after fix types in other method */
    void saveToXml2(TypedXmlSerializer serializer, ComponentName value) throws IOException {
        value.getClass();
        serializer.attribute(null, ATTR_PACKAGE_NAME, value.getPackageName());
        serializer.attribute(null, ATTR_CLASS_NAME, value.getClassName());
    }

    /* JADX INFO: renamed from: readFromXml, reason: avoid collision after fix types in other method */
    ComponentNamePolicyValue readFromXml2(TypedXmlPullParser parser) {
        String packageName = parser.getAttributeValue(null, ATTR_PACKAGE_NAME);
        String className = parser.getAttributeValue(null, ATTR_CLASS_NAME);
        if (packageName == null) goto L8;
        if (className == null) goto L8;
        return new ComponentNamePolicyValue(new ComponentName(packageName, className));
    L8:
        Log.e(TAG, "Error parsing ComponentName policy.");
        return null;
    }
}
