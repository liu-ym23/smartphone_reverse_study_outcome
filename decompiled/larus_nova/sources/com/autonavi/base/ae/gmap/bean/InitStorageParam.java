package com.autonavi.base.ae.gmap.bean;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes39.dex */
public class InitStorageParam {
    private static final String DIR_NAME = "terrain_dem_files";
    private static final String INIT_STORAGE_DIR = "mapcache";
    private int maxFileCount;
    private long maxFileSize;
    private String path;
    private int version;

    public static class Holder {
        private static String sPath;

        public Holder() {
        }

        public static /* synthetic */ String access$000() {
            return sPath;
        }

        public static void initPath(String r100) {
            PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
            PolarisFileWrapper r102 = new PolarisFileWrapper(r101, InitStorageParam.INIT_STORAGE_DIR);
            if (r101.isDirectory() == true) goto L5;
            return;
        L5:
            if (r102.exists() == true) goto L7;
            r102.mkdir();
        L7:
            PolarisFileWrapper r103 = new PolarisFileWrapper(r102, InitStorageParam.DIR_NAME);
            if (r103.exists() == true) goto L10;
            r103.mkdir();
        L10:
            sPath = r103.getAbsolutePath();
        }
    }

    public static InitStorageParam obtain() {
        return new InitStorageParam();
    }

    public String toString() {
        return "InitStorageParam{version=" + this.version + ", maxFileCount=" + this.maxFileCount + ", maxFileSize=" + this.maxFileSize + ", path='" + this.path + "'}";
    }

    private InitStorageParam() {
        this(1, Holder.access$000(), 1000, 300000);
    }

    public int getMaxFileCount() {
        return this.maxFileCount;
    }

    public long getMaxFileSize() {
        return this.maxFileSize;
    }

    public String getPath() {
        return this.path;
    }

    public int getVersion() {
        return this.version;
    }

    public void setMaxFileCount(int r100) {
        this.maxFileCount = r100;
    }

    public void setMaxFileSize(long r100) {
        this.maxFileSize = r100;
    }

    public void setPath(String r100) {
        this.path = r100;
    }

    public void setVersion(int r100) {
        this.version = r100;
    }

    private InitStorageParam(int r100, String r101, int r102, long r103) {
        this.version = r100;
        this.path = r101;
        this.maxFileCount = r102;
        this.maxFileSize = r103;
    }

    public static InitStorageParam obtain(int r100, String r101, int r102, long r110) {
        return new InitStorageParam(r100, r101, r102, r110);
    }
}
