package com.bytedance.security.zenmobile.detect.anchor;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Match {
    private int byteEnd;
    private int byteStart;
    private List<MatchRule> rules;
    private String word;

    public Match(int r3, int r4, String r5, List<MatchRule> r6) {
        List<MatchRule> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        this.byteStart = r3;
        this.byteEnd = r4;
        this.word = r5;
        this.rules = r7;
    }

    public int getByteStart() {
        return this.byteStart;
    }

    public void setByteStart(int r1) {
        this.byteStart = r1;
    }

    public int getByteEnd() {
        return this.byteEnd;
    }

    public void setByteEnd(int r1) {
        this.byteEnd = r1;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String r1) {
        this.word = r1;
    }

    public List<MatchRule> getRules() {
        return this.rules;
    }

    public void setRules(List<MatchRule> r3) {
        this.rules = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }
}
