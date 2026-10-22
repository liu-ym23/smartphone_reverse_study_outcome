package com.volcengine.tos.model.object;

import java.util.Map;

/* loaded from: classes3.dex */
public interface PreSignedPolicyURLGenerator {
    String getSignedURLForGetOrHead(String str, Map<String, String> map);

    String getSignedURLForList(Map<String, String> map);
}
