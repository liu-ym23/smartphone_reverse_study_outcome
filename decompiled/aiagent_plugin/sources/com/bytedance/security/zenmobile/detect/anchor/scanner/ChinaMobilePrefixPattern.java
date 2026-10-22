package com.bytedance.security.zenmobile.detect.anchor.scanner;

import com.obric.cae.libs.useraware.ApWakeEvent;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ChinaMobilePrefixPattern extends Pattern {
    public ChinaMobilePrefixPattern() {
        this.name = "china_mobile_prefix";
    }

    @Override // com.bytedance.security.zenmobile.detect.anchor.scanner.Pattern
    public List<String> generateWords() {
        ArrayList r2 = new ArrayList(80);
        int r0 = ApWakeEvent.ACCELERATING_START;
    L4:
        if (r0 > 199) goto L6;
        r2.add(Integer.toString(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        return r2;
    }
}
