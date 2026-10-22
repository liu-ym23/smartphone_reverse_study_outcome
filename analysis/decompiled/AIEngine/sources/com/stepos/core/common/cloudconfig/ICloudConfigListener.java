package com.stepos.core.common.cloudconfig;

import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface ICloudConfigListener {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static List<String> dumpApplyState(ICloudConfigListener iCloudConfigListener) {
            return EmptyList.f10001a;
        }

        public static String getLocalName(ICloudConfigListener iCloudConfigListener) {
            return iCloudConfigListener.getFileName();
        }
    }

    List<String> dumpApplyState();

    String getFileName();

    String getKey();

    String getLocalName();

    CloudConfigResult onConfigReceived(String str, byte[] bArr);

    boolean validate(byte[] bArr);
}
