package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CompoundTrimPathContent {
    private final List<TrimPathContent> contents;

    public CompoundTrimPathContent() {
        this.contents = new ArrayList();
    }

    void addTrimPath(TrimPathContent r1) {
        this.contents.add(r1);
    }

    public void apply(Path r3) {
        int r0 = this.contents.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        Utils.applyTrimPathIfNeeded(r3, this.contents.get(r0));
        r0 = r0 - 1;
        goto L3
    }
}
