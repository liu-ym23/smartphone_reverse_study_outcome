package com.byted.cast.common.bean;

import java.util.Arrays;

/* JADX INFO: loaded from: classes39.dex */
public class DramaInfo {
    public DramaBean[] dramaBeans;
    public String dramaId;

    public DramaInfo() {
    }

    public String toString() {
        return "DramaInfo{dramaId='" + this.dramaId + "', dramaBeans=" + Arrays.toString(this.dramaBeans) + '}';
    }
}
