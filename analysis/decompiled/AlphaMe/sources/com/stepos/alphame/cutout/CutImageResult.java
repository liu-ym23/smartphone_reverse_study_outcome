package com.stepos.alphame.cutout;

import android.graphics.Rect;
import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CutImageResult {
    private float proportion;
    private String filePath = null;
    private List<List<List<Integer>>> contoursValue = new ArrayList();
    private List<List<Integer>> hierarchyValue = new ArrayList();
    private List<Integer> rectPoints = new ArrayList();
    private int sampleSize = 1;

    public static CutImageResult fromJsonString(String str) {
        return (CutImageResult) JSON.parseObject(str).toJavaObject(CutImageResult.class);
    }

    public List<List<List<Integer>>> getContoursValue() {
        return this.contoursValue;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public List<List<Integer>> getHierarchyValue() {
        return this.hierarchyValue;
    }

    public float getProportion() {
        return this.proportion;
    }

    public Rect getRectFromPoints() {
        Rect rect = new Rect(0, 0, 0, 0);
        List<Integer> rectPoints = getRectPoints();
        int size = rectPoints != null ? rectPoints.size() : 0;
        if (size >= 1) {
            rect.left = rectPoints.get(0).intValue();
        }
        if (size >= 2) {
            rect.top = rectPoints.get(1).intValue();
        }
        if (size >= 3) {
            rect.right = rectPoints.get(2).intValue();
        }
        if (size >= 4) {
            rect.bottom = rectPoints.get(3).intValue();
        }
        return rect;
    }

    public List<Integer> getRectPoints() {
        return this.rectPoints;
    }

    public int getSampleSize() {
        return this.sampleSize;
    }

    public void setContoursValue(List<List<List<Integer>>> list) {
        this.contoursValue = list;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setHierarchyValue(List<List<Integer>> list) {
        this.hierarchyValue = list;
    }

    public void setProportion(float f4) {
        this.proportion = f4;
    }

    public void setRectPoints(List<Integer> list) {
        this.rectPoints = list;
    }

    public void setSampleSize(int i4) {
        this.sampleSize = i4;
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }
}
