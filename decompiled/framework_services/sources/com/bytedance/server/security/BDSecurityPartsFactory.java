package com.bytedance.server.security;

import com.bytedance.server.security.behaviorrecord.IBDAppBehaviorRecord;
import com.bytedance.server.security.behaviorrecord.record.BDAppBehaviorManager;

/* JADX INFO: loaded from: classes3.dex */
public class BDSecurityPartsFactory {
    public BDSecurityPartsFactory() {
    }

    public static IBDAppBehaviorRecord getBDAppBehaviorRecord() {
        return BDAppBehaviorManager.getInstance();
    }
}
