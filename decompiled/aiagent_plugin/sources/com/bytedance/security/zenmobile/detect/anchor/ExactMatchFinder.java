package com.bytedance.security.zenmobile.detect.anchor;

import android.content.Context;
import com.bytedance.security.zenmobile.detect.helpers.PersistentIdentifierUtils;
import com.bytedance.security.zenmobile.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ExactMatchFinder extends Finder {
    private static final String TAG = "ZenMobile-ExactMatchFinder";
    Map<String, List<MatchRule>> wordToRules;

    public ExactMatchFinder() {
        this.wordToRules = new HashMap();
        this.mode = "exact_match";
    }

    @Override // com.bytedance.security.zenmobile.detect.anchor.Finder
    public void addRule(Context r9, List<String> r10, long r11, boolean r13, Map<String, Object> r14) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        String r3 = PersistentIdentifierUtils.getSpecPersistentId(r12, r11);
        LogUtils.d(TAG, "ruleId: " + r11 + ", getSpecPersistentId: " + r3);
        if (r3.equals("") == true) goto L6;
        ((List) ZeusTransformUtils.preCheckCast(this.wordToRules.computeIfAbsent(r3, $$Lambda$ExactMatchFinder$Z1caHgK1s5B8rmTdE4MdoKeI4Q.INSTANCE), List.class, "com.obric.aiagent.plugin")).add(new MatchRule(r3, r11, r13, 1));
        return;
    }

    static /* synthetic */ List lambda$addRule$0(String r0) {
        return new ArrayList();
    }

    @Override // com.bytedance.security.zenmobile.detect.anchor.Finder
    public Map<String, List<MatchRule>> getWordToRules() {
        return this.wordToRules;
    }
}
