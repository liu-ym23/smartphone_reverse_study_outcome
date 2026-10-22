package com.bytedance.security.zenmobile.detect.extension;

import com.bytedance.security.zenmobile.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BoundaryExtender extends RegexpExtender {
    public static final String TAG = "ZenMobile-BoundaryExtender";

    public BoundaryExtender(int r10, List<String> r11, int r12, int r13, boolean r14, Map<String, Object> r15) {
        super(r10, (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin"), r12, r13, r14, (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin"));
        this.mode = "boundary";
    }

    @Override // com.bytedance.security.zenmobile.detect.extension.RegexpExtender, com.bytedance.security.zenmobile.detect.extension.Extender
    public ExtensionResult extend(byte[] r4, int r5) {
        if (r4 != null) goto L5;
    L19:
        LogUtils.e(TAG, "invalid params(bytes == null || bytes.length == 0)");
        return new ExtensionResult(false, r5);
    L5:
        if (r4.length == 0) goto L19;
        if (r5 >= 0) goto L9;
    L17:
        LogUtils.e(TAG, "invalid offset: " + r5);
        return new ExtensionResult(false, r5);
    L9:
        if (r5 > r4.length) goto L17;
        LogUtils.d(TAG, "direction: " + this.direction);
        if (this.direction != (-1)) goto L16;
        return extendBackward(r4, r5);
    L16:
        return extendForward(r4, r5);
    }

    @Override // com.bytedance.security.zenmobile.detect.extension.RegexpExtender
    public ExtensionResult extendForward(byte[] r2, int r3) {
        if (r3 != r2.length) goto L7;
        return new ExtensionResult(true, r3);
    L7:
        return super.extendForward(r2, r3);
    }

    @Override // com.bytedance.security.zenmobile.detect.extension.RegexpExtender
    public ExtensionResult extendBackward(byte[] r1, int r2) {
        if (r2 != 0) goto L6;
        return new ExtensionResult(true, r2);
    L6:
        return super.extendBackward(r1, r2);
    }
}
