package com.byted.mgl.merge.service.model;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes43.dex */
public class BdpMarkerOptions {
    public Bitmap icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f33891id;
    public BdpLatLng position;
    public String title;

    public BdpMarkerOptions() {
    }

    public BdpMarkerOptions icon(Bitmap r100) {
        this.icon = r100;
        return this;
    }

    public BdpMarkerOptions id(String r100) {
        this.f33891id = r100;
        return this;
    }

    public BdpMarkerOptions position(BdpLatLng r100) {
        this.position = r100;
        return this;
    }

    public BdpMarkerOptions title(String r100) {
        this.title = r100;
        return this;
    }
}
