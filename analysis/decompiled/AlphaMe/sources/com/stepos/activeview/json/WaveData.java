package com.stepos.activeview.json;

import android.content.Context;
import com.stepos.activeview.utils.DisplayUnitUtil;
import java.util.List;

/* loaded from: classes.dex */
public class WaveData {
    private String cellsPointUnit;
    private List<List<Float[]>> endCells;
    private int hCellsNum;
    private float[][][] mEndCellsValue;
    private int vCellsNum;

    public String getCellsPointUnit() {
        return this.cellsPointUnit;
    }

    public List<List<Float[]>> getEndCells() {
        return this.endCells;
    }

    public float[][][] getEndCellsValue(Context context, float f4) {
        List<List<Float[]>> list;
        if (this.mEndCellsValue == null && (list = this.endCells) != null) {
            int size = list.size();
            this.mEndCellsValue = new float[size][][];
            this.cellsPointUnit = "dp";
            for (int i4 = 0; i4 < size; i4++) {
                List<Float[]> list2 = this.endCells.get(i4);
                int size2 = list2.size();
                float[][] fArr = new float[size2][];
                for (int i5 = 0; i5 < size2; i5++) {
                    float[] fArr2 = {list2.get(i5)[0].floatValue(), list2.get(i5)[1].floatValue()};
                    if (this.cellsPointUnit != null) {
                        fArr2[0] = DisplayUnitUtil.getPixelValue(context, r8, fArr2[0]) / f4;
                        fArr2[1] = DisplayUnitUtil.getPixelValue(context, this.cellsPointUnit, fArr2[1]) / f4;
                    }
                    fArr[i5] = fArr2;
                }
                this.mEndCellsValue[i4] = fArr;
            }
        }
        return this.mEndCellsValue;
    }

    public int getHCellsNum() {
        return this.hCellsNum;
    }

    public int getVCellsNum() {
        return this.vCellsNum;
    }

    public void setCellsPointUnit(String str) {
        this.cellsPointUnit = str;
    }

    public void setEndCells(List<List<Float[]>> list) {
        this.endCells = list;
    }

    public void setHCellsNum(int i4) {
        this.hCellsNum = i4;
    }

    public void setVCellsNum(int i4) {
        this.vCellsNum = i4;
    }
}
