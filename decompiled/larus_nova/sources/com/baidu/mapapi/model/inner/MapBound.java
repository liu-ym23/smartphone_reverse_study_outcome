package com.baidu.mapapi.model.inner;

import com.baidu.platform.comapi.basestruct.Point;
import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class MapBound implements Serializable {
    public Point ptLB;
    public Point ptRT;

    public MapBound() {
        if (this.ptLB != null) goto L6;
        this.ptLB = new Point();
    L6:
        if (this.ptRT != null) goto L9;
        this.ptRT = new Point();
        return;
    }

    public Point getPtLB() {
        return this.ptLB;
    }

    public Point getPtRT() {
        return this.ptRT;
    }

    public void setPtLB(Point r100) {
        this.ptLB = r100;
    }

    public void setPtRT(Point r100) {
        this.ptRT = r100;
    }
}
