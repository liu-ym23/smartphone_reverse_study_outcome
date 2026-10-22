package com.autonavi.base.amap.mapcore;

import java.util.Objects;

/* JADX INFO: loaded from: classes39.dex */
public class NativeFunctionRunnable {
    public static final String CLEAR_OVERLAY_FUNC = "clearOverlay";
    public static final String CREATE_OVERLAY_FUNC = "createOverlay";
    public static final String GET_OVERLAY_BOUND_RECT = "getOverlayBoundRect";
    public static final String REMOVE_OVERLAY_FUNC = "removeOverlay";
    public static final String UPDATE_OPTIONS_FUNC = "updateOptions";
    private String name;
    private Runnable runnable;
    private String type;

    public String getKey() {
        return this.type + "_" + this.name;
    }

    public int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "NativeFunctionRunnable{type='" + this.type + "', name='" + this.name + "', runnable=" + this.runnable + '}';
    }

    public Runnable getRunnable() {
        return this.runnable;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L15:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L15;
        NativeFunctionRunnable r101 = (NativeFunctionRunnable) r100;
        if (Objects.equals(this.type, r101.type) == true) goto L14;
        return false;
    L14:
        return Objects.equals(this.name, r101.name);
    }

    public NativeFunctionRunnable(String r100, String r101, Runnable r102) {
        this.type = r100;
        this.name = r101;
        this.runnable = r102;
    }
}
