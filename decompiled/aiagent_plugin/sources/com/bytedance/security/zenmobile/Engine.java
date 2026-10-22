package com.bytedance.security.zenmobile;

import com.bytedance.security.zenmobile.deidentify.Deidentifier;
import com.bytedance.security.zenmobile.detect.Detector;
import com.bytedance.security.zenmobile.io.Match;
import com.bytedance.security.zenmobile.io.Profile;
import com.bytedance.security.zenmobile.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Engine {
    public static final String TAG = "ZenMobile-Engine";
    public static final byte[] TRUNCATION_SUFFIX = null;
    public static final int TRUNCATION_SUFFIX_LENGTH = 12;
    private Deidentifier deidentifier;
    private Detector detector;
    private int maxDetectionLen;
    private Profile profile;
    private boolean skipFailure;
    private int truncationLen;

    static {
        TRUNCATION_SUFFIX = "[TRUNCATION]".getBytes(StandardCharsets.UTF_8);
    }

    public Engine(Detector r2, Deidentifier r3) {
        this.profile = r2.getProfile();
        this.detector = r2;
        this.deidentifier = r3;
    }

    public boolean isSkipFailure() {
        return this.skipFailure;
    }

    public void setSkipFailure(boolean r1) {
        this.skipFailure = r1;
    }

    public Profile getProfile() {
        return this.profile;
    }

    public Detector getDetector() {
        return this.detector;
    }

    public void setDetector(Detector r2) {
        this.profile = r2.getProfile();
        this.detector = r2;
    }

    public Deidentifier getDeidentifier() {
        return this.deidentifier;
    }

    public void setDeidentifier(Deidentifier r1) {
        this.deidentifier = r1;
    }

    public int getMaxDetectionLen() {
        return this.maxDetectionLen;
    }

    public void setMaxDetectionLen(int r1) {
        this.maxDetectionLen = r1;
    }

    public int getTruncationLen() {
        return this.truncationLen;
    }

    public void setTruncationLen(int r1) {
        this.truncationLen = r1;
    }

    public String DetectAndDeidentify(String r4) {
        if (r4 != null) goto L5;
    L9:
        LogUtils.e(TAG, "input string is null or empty");
        return "";
    L5:
        if (r4.isEmpty() == true) goto L9;
        LogUtils.d(TAG, "text.length(): " + r4.length());
        byte[] r5 = r4.getBytes(StandardCharsets.UTF_8);
        LogUtils.d(TAG, "full.length: " + r5.length);
        DetectAndDeidentify(r5);
        return new String(r5, StandardCharsets.UTF_8);
    }

    public void DetectAndDeidentify(byte[] r7) {
        if (r7 != null) goto L5;
    L27:
        LogUtils.e(TAG, "input byteArray is null or empty");
        return;
    L5:
        if (r7.length == 0) goto L27;
        int r1 = this.maxDetectionLen;
        if (r1 > 0) goto L10;
    L13:
        int r2 = this.truncationLen;
        if (r2 > 0) goto L16;
    L18:
        List<Match> r3 = this.detector.detect(r7);
        if (r3.isEmpty() == false) goto L22;
        LogUtils.d(TAG, "matches.isEmpty()");
        return;
    L22:
        LogUtils.d(TAG, "matches.size(): " + r3.size());
        Iterator<Match> r4 = r3.iterator();
    L24:
        if (r4.hasNext() == false) goto L26;
        Match r5 = (Match) ZeusTransformUtils.preCheckCast(r4.next(), Match.class, "com.obric.aiagent.plugin");
        LogUtils.d(TAG, "match.getByteStart(): " + r5.getByteStart());
        LogUtils.d(TAG, "match.getByteEnd(): " + r5.getByteEnd());
        LogUtils.d(TAG, "match.getSensitiveType(): " + r5.getSensitiveType());
        this.deidentifier.deidentify(r7, r5.getByteStart(), r5.getByteEnd(), r5.getSensitiveType());
        goto L24
    L26:
        return;
    L16:
        if (r7.length <= r2) goto L18;
        byte[] r6 = new byte[r2 + 12];
        System.arraycopy(r7, 0, r6, 0, r2);
        System.arraycopy(TRUNCATION_SUFFIX, 0, r6, this.truncationLen, 12);
        r7 = r6;
        goto L18
    L10:
        if (r7.length <= r1) goto L13;
        LogUtils.e(TAG, "input length:" + r7.length + " is larger than maxDetectionLen: " + this.maxDetectionLen);
    }
}
