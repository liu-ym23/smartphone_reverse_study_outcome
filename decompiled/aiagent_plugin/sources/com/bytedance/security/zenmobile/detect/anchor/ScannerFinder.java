package com.bytedance.security.zenmobile.detect.anchor;

import android.content.Context;
import com.bytedance.security.zenmobile.detect.anchor.scanner.WordGenerator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ScannerFinder extends Finder {
    Map<String, List<MatchRule>> patternToRules;
    Map<String, List<MatchRule>> wordToRules;

    public ScannerFinder() {
        this.patternToRules = new HashMap();
        this.wordToRules = new HashMap();
        this.mode = "scanner";
    }

    @Override // com.bytedance.security.zenmobile.detect.anchor.Finder
    public void addRule(Context r9, List<String> r10, long r11, boolean r13, Map<String, Object> r14) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        Iterator r17 = r15.iterator();
    L4:
        if (r17.hasNext() == false) goto L6;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin");
        ((List) ZeusTransformUtils.preCheckCast(this.patternToRules.computeIfAbsent(r18, $$Lambda$ScannerFinder$Se62Aj3nsGELQyLtPGQ2czmxQ.INSTANCE), List.class, "com.obric.aiagent.plugin")).add(new MatchRule("", r11, r13, 1));
        goto L4
    }

    static /* synthetic */ List lambda$addRule$0(String r0) {
        return new ArrayList();
    }

    @Override // com.bytedance.security.zenmobile.detect.anchor.Finder
    public Map<String, List<MatchRule>> getWordToRules() {
        final Map<String, List<String>> r0 = WordGenerator.generateAllWords();
        this.patternToRules.forEach(new $$Lambda$ScannerFinder$Nq70pCziEpngJxEMzG0cec0I(this, r0));
        return this.wordToRules;
    }

    public /* synthetic */ void lambda$getWordToRules$2$ScannerFinder(Map r11, String r12, List r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        if (r14.containsKey(r12) == false) goto L13;
        Iterator r16 = ((List) ZeusTransformUtils.preCheckCast(r14.get(r12), List.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r16.hasNext() == false) goto L11;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.aiagent.plugin");
        Iterator r0 = r15.iterator();
    L9:
        if (r0.hasNext() == false) goto L6;
        MatchRule r2 = (MatchRule) ZeusTransformUtils.preCheckCast(r0.next(), MatchRule.class, "com.obric.aiagent.plugin");
        ((List) ZeusTransformUtils.preCheckCast(this.wordToRules.computeIfAbsent(r17, $$Lambda$ScannerFinder$dUVYKyEJAmJLKnKEt1U69r5ZaDo.INSTANCE), List.class, "com.obric.aiagent.plugin")).add(new MatchRule(r17, r2.getRuleId(), r2.isInValue(), r2.getStep()));
        goto L9
    L11:
        return;
    L13:
        throw new IllegalArgumentException(String.format("scanner pattern (name=%s) does not exist", new Object[]{r12}));
    }

    static /* synthetic */ List lambda$getWordToRules$1(String r0) {
        return new ArrayList();
    }
}
