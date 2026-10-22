package com.bytedance.security.zenmobile.detect.extension;

import com.bytedance.security.zenmobile.helpers.ByteCharSequence;
import com.bytedance.security.zenmobile.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class RegexpExtender extends Extender {
    public static final String TAG = "ZenMobile-RegexpExtender";
    Pattern backwardPattern;
    Pattern forwardPattern;

    public RegexpExtender(int r9, List<String> r10, int r11, int r12, boolean r13, Map<String, Object> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        super(r9, r15, r11, r12, r13);
        this.mode = "regexp";
        ArrayList r17 = new ArrayList(r15);
        String r18 = String.format("^(%s)", new Object[]{String.join("|", r17)});
        String r19 = String.format("(%s)$", new Object[]{String.join("|", r17)});
        LogUtils.d(TAG, "forward regexp: " + r18);
        LogUtils.d(TAG, "backward regexp: " + r19);
        this.forwardPattern = Pattern.compile(r18);
        this.backwardPattern = Pattern.compile(r19);
    }

    @Override // com.bytedance.security.zenmobile.detect.extension.Extender
    public ExtensionResult extend(byte[] r3, int r4) {
        if (r3 == null) goto L20;
        if (r3.length == 0) goto L20;
        if (r4 < 0) goto L18;
        if (r4 > r3.length) goto L18;
        if (this.direction != (-1)) goto L16;
        return extendBackward(r3, r4);
    L16:
        return extendForward(r3, r4);
    L18:
        return new ExtensionResult(false, r4);
    L20:
        return new ExtensionResult(false, r4);
    }

    public ExtensionResult extendForward(byte[] r6, int r7) {
        LogUtils.d(TAG, "bytes.length: " + r6.length);
        LogUtils.d(TAG, "offset: " + r7);
        LogUtils.d(TAG, "this.maxLength: " + this.maxLength);
        LogUtils.d(TAG, "offset + this.maxLength: " + (this.maxLength + r7));
        int r0 = Math.min(r6.length, this.maxLength + r7);
        LogUtils.d(TAG, "boundary: " + r0);
        ByteCharSequence r3 = new ByteCharSequence(r6, r7, r0 - r7);
        LogUtils.d(TAG, "slice.length(): " + r3.length());
        LogUtils.d(TAG, "slice: " + r3.toCharString());
        LogUtils.d(TAG, this.forwardPattern.pattern());
        Matcher r8 = this.forwardPattern.matcher(r3.toCharString());
        boolean r4 = false;
        if (r8.find() == true) goto L5;
    L7:
        int r9 = 0;
    L8:
        int r10 = r7 + r9;
        LogUtils.d(TAG, "length: " + r9);
        LogUtils.d(TAG, "this.minLength: " + this.minLength);
        LogUtils.d(TAG, "this.maxLength: " + this.maxLength);
        if (r9 < this.minLength) goto L14;
        if (r9 > this.maxLength) goto L14;
        r4 = true;
    L14:
        return new ExtensionResult(r4, r10);
    L5:
        if (r8.start() != 0) goto L7;
        LogUtils.d(TAG, "match");
        r9 = r8.group().getBytes(StandardCharsets.UTF_8).length;
        goto L8
    }

    public ExtensionResult extendBackward(byte[] r7, int r8) {
        boolean r1 = false;
        int r0 = Math.max(0, r8 - this.maxLength);
        int r3 = r8 - r0;
        ByteCharSequence r2 = new ByteCharSequence(r7, r0, r3);
        LogUtils.d(TAG, "this.backwardPattern.pattern(): " + this.backwardPattern.pattern());
        LogUtils.d(TAG, "this.maxLength: " + this.maxLength);
        LogUtils.d(TAG, "this.minLength: " + this.minLength);
        LogUtils.d(TAG, "offset: " + r8);
        LogUtils.d(TAG, "boundary: " + r0);
        LogUtils.d(TAG, "offset - boundary: " + r3);
        LogUtils.d(TAG, "slice.length: " + r2.length());
        LogUtils.d(TAG, "slice: " + r2.toCharString());
        Matcher r9 = this.backwardPattern.matcher(r2.toCharString());
        if (r9.find() == true) goto L5;
    L7:
        int r4 = 0;
    L8:
        int r10 = r8 - r4;
        if (r4 < this.minLength) goto L14;
        if (r4 > this.maxLength) goto L14;
        r1 = true;
    L14:
        return new ExtensionResult(r1, r10);
    L5:
        if (r9.group().getBytes(StandardCharsets.UTF_8).length != r3) goto L7;
        LogUtils.d(TAG, "match");
        r4 = r3 - r9.start();
        goto L8
    }
}
