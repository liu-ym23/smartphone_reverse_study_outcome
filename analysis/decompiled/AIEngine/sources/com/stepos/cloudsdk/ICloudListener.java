package com.stepos.cloudsdk;

import com.stepos.core.common.telemetry.FailStage;
import java.io.InputStream;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface ICloudListener {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public enum ResultCode {
        SUCCESS("SUCCESS"),
        FILE_NOT_EXIST("FILE_NOT_EXIST"),
        /* JADX INFO: Fake field, exist only in values array */
        FILE_PATH_ERROR("FILE_PATH_ERROR"),
        /* JADX INFO: Fake field, exist only in values array */
        FILE_INCOMPLETE("FILE_INCOMPLETE"),
        FILE_IO_ERROR("FILE_IO_ERROR"),
        /* JADX INFO: Fake field, exist only in values array */
        VERSION_DOWNGRADE("VERSION_DOWNGRADE"),
        /* JADX INFO: Fake field, exist only in values array */
        PERMISSION_ERROR("PERMISSION_ERROR"),
        /* JADX INFO: Fake field, exist only in values array */
        KEY_NOT_DEFINE("KEY_NOT_DEFINE"),
        INNER_ERROR("INNER_ERROR"),
        /* JADX INFO: Fake field, exist only in values array */
        VALUE_EMPTY("VALUE_EMPTY"),
        VALUE_FORMAT_ERROR("VALUE_FORMAT_ERROR"),
        /* JADX INFO: Fake field, exist only in values array */
        UNKNOWN(FailStage.UNKNOWN);


        /* renamed from: a, reason: collision with root package name */
        public final String f6417a;

        ResultCode(String str) {
            this.f6417a = str;
        }
    }

    ResultCode applyInputStream(String str, InputStream inputStream);
}
