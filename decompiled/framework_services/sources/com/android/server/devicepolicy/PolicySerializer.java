package com.android.server.devicepolicy;

import android.app.admin.PolicyValue;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
abstract class PolicySerializer<V> {
    abstract PolicyValue<V> readFromXml(TypedXmlPullParser r1);

    abstract void saveToXml(TypedXmlSerializer r1, V r2) throws IOException;

    PolicySerializer() {
    }
}
