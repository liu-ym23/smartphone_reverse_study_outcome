package com.autonavi.base.ae.gmap.glinterface;

/* JADX INFO: loaded from: classes39.dex */
public class MapLabelItem {
    public static final int LABEL_TYPE_INDOOR = 2;
    public static final int LABEL_TYPE_NORMAL = 0;
    public static final int LABEL_TYPE_OPENLAYER = 6;
    public static final int LABEL_TYPE_SCENIC = 1;
    public static final int LABEL_TYPE_SEARCH_RESULT = 3;
    public int anchor;
    public int angle;
    public int borderColor;
    public int fontColor;
    public int fontSize;
    public int iconID;
    public int labelx;
    public int labely;
    public boolean mIsFouces;
    public int mSublayerId;
    public String name;
    public int pixel20X;
    public int pixel20Y;
    public int pixel20Z;
    public String poiid;
    public int strHeight;
    public int strWidth;
    public int timeStamp;
    public int type;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f30031x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f30032y;

    public MapLabelItem() {
        this.timeStamp = 0;
    }
}
