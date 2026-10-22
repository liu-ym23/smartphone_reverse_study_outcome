package com.bytedance.security.zenmobile.detect.anchor;

import android.content.Context;
import com.bytedance.security.zenmobile.helpers.WordExpander;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class WordFinder extends Finder {
    static final String CASE_SENSITIVE = "case_sensitive";
    static final String STEP = "step";
    Map<String, List<MatchRule>> wordToRules;

    public WordFinder() {
        this.wordToRules = new HashMap();
        this.mode = "word";
    }

    @Override // com.bytedance.security.zenmobile.detect.anchor.Finder
    public void addRule(Context r10, List<String> r11, long r12, boolean r14, Map<String, Object> r15) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        List<String> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        Map r17 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin");
        int r18 = 0;
        if (r17 == null) goto L15;
        Object r0 = r17.get(CASE_SENSITIVE);
        if (ZeusTransformUtils.instanceOf(r0, Boolean.class) == false) goto L7;
        boolean r1 = ((Boolean) ZeusTransformUtils.preCheckCast(r0, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L8:
        Object r19 = r17.get(STEP);
        if (ZeusTransformUtils.instanceOf(r19, String.class) == false) goto L17;
        r18 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r19, String.class, "com.obric.aiagent.plugin"));     // Catch: NumberFormatException -> L12
    L12:
        e = move-exception;
        throw new IllegalArgumentException("invalid step value in extra map", e);
    L17:
        if (r18 > 0) goto L19;
    L20:
        r18 = 1;
    L21:
        if (r18 > 1) goto L25;
        if (r1 == true) goto L25;
        r16 = WordExpander.expandWords(r16);
    L25:
        Iterator<String> r110 = r16.iterator();
    L27:
        if (r110.hasNext() == false) goto L29;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r110.next(), String.class, "com.obric.aiagent.plugin");
        ((List) ZeusTransformUtils.preCheckCast(this.wordToRules.computeIfAbsent(r4, $$Lambda$WordFinder$Ew2lCZN0FpN7hmCcg_2DlFC9ts.INSTANCE), List.class, "com.obric.aiagent.plugin")).add(new MatchRule(r4, r12, r14, r18));
        goto L27
    L29:
        return;
    L19:
        if (r18 <= 10) goto L21;
    L7:
        r1 = false;
        goto L8
    L15:
        r1 = false;
        goto L17
    }

    static /* synthetic */ List lambda$addRule$0(String r0) {
        return new ArrayList();
    }

    @Override // com.bytedance.security.zenmobile.detect.anchor.Finder
    public Map<String, List<MatchRule>> getWordToRules() {
        return this.wordToRules;
    }
}
