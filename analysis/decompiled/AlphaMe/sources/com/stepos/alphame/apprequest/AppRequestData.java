package com.stepos.alphame.apprequest;

/* loaded from: classes.dex */
public class AppRequestData {
    private String meiTuanVersion;
    private MetaData metaData;

    public static class MetaData {
        private String appVersion;
        private String modelName;
        private String osVersion;

        public MetaData(String str, String str2, String str3) {
            this.appVersion = str;
            this.modelName = str2;
            this.osVersion = str3;
        }
    }

    public AppRequestData(MetaData metaData, String str) {
        this.metaData = metaData;
        this.meiTuanVersion = str;
    }
}
