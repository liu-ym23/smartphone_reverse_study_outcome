package com.bytedance.android.livesdkapi.depend.model;

import com.bytedance.android.live.base.model.ImageModel;

/* JADX INFO: loaded from: classes12.dex */
public class TextImageModel extends ImageModel {
    public static final int TYPE_FANS_GROUP = 1;
    public static final int TYPE_FRATERNITY = 4;
    public static final int TYPE_LOCAL_RES = 2;
    public static final int TYPE_NOBLE = 3;
    private int color;
    private String content;
    private int res;
    private int type;

    public int getColor() {
        return this.color;
    }

    public String getContent() {
        return this.content;
    }

    public int getRes() {
        return this.res;
    }

    public int getType() {
        return this.type;
    }

    public TextImageModel(int r100) {
        this.type = 2;
        this.res = r100;
    }

    public void setColor(int r100) {
        this.color = r100;
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setRes(int r100) {
        this.res = r100;
    }

    public TextImageModel(ImageModel r100, int r101) {
        setAvgColor(r100.getAvgColor());
        setUri(r100.getUri());
        setUrls(r100.getUrls());
        setWidth(r100.getWidth());
        setHeight(r100.getHeight());
        setColor(0);
        this.type = r101;
    }
}
