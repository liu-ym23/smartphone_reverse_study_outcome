package com.stepos.activeview.json;

import java.util.List;

/* loaded from: classes.dex */
public class CustomEvent {
    private List<Animation> animations;
    private String key;

    public List<Animation> getAnimations() {
        return this.animations;
    }

    public String getKey() {
        return this.key;
    }

    public void setAnimations(List<Animation> list) {
        this.animations = list;
    }

    public void setKey(String str) {
        this.key = str;
    }
}
