package com.amap.api.maps.model;

/* JADX INFO: loaded from: classes28.dex */
public class BaseOptions {
    protected Object Field1;
    protected Object Field2;
    protected String type;

    public static class BaseUpdateFlags {
        protected boolean zIndexUpdate;

        public void reset() {
            this.zIndexUpdate = false;
        }

        public BaseUpdateFlags() {
            this.zIndexUpdate = false;
        }
    }

    public BaseUpdateFlags getUpdateFlags() {
        return null;
    }

    public Object method1(Object... r100) {
        return null;
    }

    public Object method2(Object... r100) {
        return null;
    }

    public void resetUpdateFlags() {
    }

    public BaseOptions() {
    }
}
