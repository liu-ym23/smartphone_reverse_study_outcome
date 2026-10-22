package com.stepos.cloudsdk;

import java.io.InputStream;

/* loaded from: classes.dex */
public interface ICloudListener {
    ResultCode applyInputStream(String str, InputStream inputStream);

    public enum ResultCode {
        SUCCESS("SUCCESS"),
        FILE_NOT_EXIST("FILE_NOT_EXIST"),
        FILE_PATH_ERROR("FILE_PATH_ERROR"),
        FILE_INCOMPLETE("FILE_INCOMPLETE"),
        FILE_IO_ERROR("FILE_IO_ERROR"),
        VERSION_DOWNGRADE("VERSION_DOWNGRADE"),
        PERMISSION_ERROR("PERMISSION_ERROR"),
        KEY_NOT_DEFINE("KEY_NOT_DEFINE"),
        INNER_ERROR("INNER_ERROR"),
        VALUE_EMPTY("VALUE_EMPTY"),
        VALUE_FORMAT_ERROR("VALUE_FORMAT_ERROR"),
        UNKNOWN("UNKNOWN");

        private final String info;

        ResultCode(String str) {
            this.info = str;
        }

        public String getInfo() {
            return this.info;
        }

        public static String getIndexInfo(int i) {
            ResultCode[] resultCodeArrValues = values();
            if (i < 0 || i >= resultCodeArrValues.length) {
                return null;
            }
            return resultCodeArrValues[i].info;
        }
    }
}
