package com.stepos.alphame.utils.net;

import h3.C0611u;
import h3.D;
import h3.J;
import h3.Z;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class RequestBodyUtils {
    public static Z getFormBody(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (map != null) {
            for (String name : map.keySet()) {
                String value = map.get(name);
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(value, "value");
                char[] cArr = J.f12721k;
                arrayList.add(C0611u.c(name, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, null, 91));
                arrayList2.add(C0611u.c(value, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, null, 91));
            }
        }
        return new D(arrayList, arrayList2);
    }
}
