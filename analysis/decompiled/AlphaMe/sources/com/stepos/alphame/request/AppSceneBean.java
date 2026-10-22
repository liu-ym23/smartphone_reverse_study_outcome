package com.stepos.alphame.request;

import com.stepos.alphame.NotProguard;
import java.util.List;

@NotProguard
/* loaded from: classes.dex */
public class AppSceneBean {
    private List<String> packges;
    private int scene;

    public List<String> getPackges() {
        return this.packges;
    }

    public int getScene() {
        return this.scene;
    }

    public void setPackges(List<String> list) {
        this.packges = list;
    }

    public void setScene(int i4) {
        this.scene = i4;
    }
}
