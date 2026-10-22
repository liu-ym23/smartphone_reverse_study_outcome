package com.bytedance.security.zenmobile.io;

import android.content.Context;
import com.bytedance.security.zenmobile.helpers.ResourceLoader;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.b.a.b;
import com.fasterxml.jackson.databind.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Profile {

    @JsonProperty("rules")
    private List<Rule> ruleSlice;

    @JsonIgnore
    private Map<Long, Rule> rules;

    @JsonProperty("version")
    private long version;

    public Profile() {
        this.rules = new HashMap();
        this.ruleSlice = new ArrayList();
    }

    public Profile(List<Rule> r7) {
        List<Rule> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        this.rules = new HashMap();
        Iterator<Rule> r0 = r8.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Rule r2 = (Rule) ZeusTransformUtils.preCheckCast(r0.next(), Rule.class, "com.obric.aiagent.plugin");
        this.rules.put(Long.valueOf(r2.getRuleId()), r2);
        goto L4
    L6:
        this.ruleSlice = r8;
    }

    public static Profile mergeProfiles(Profile[] r8) {
        Profile r0 = new Profile();
        int r1 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        Iterator<Rule> r3 = r8[r2].ruleSlice.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Rule r4 = (Rule) ZeusTransformUtils.preCheckCast(r3.next(), Rule.class, "com.obric.aiagent.plugin");
        if (r4.isEnabled() == false) goto L6;
        r0.ruleSlice.add(r4);
        r0.rules.put(Long.valueOf(r4.getRuleId()), r4);
        goto L6
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return r0;
    }

    public Map<Long, Rule> getRules() {
        return this.rules;
    }

    public void setRules(Map<Long, Rule> r3) {
        this.rules = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public List<Rule> getRuleSlice() {
        return this.ruleSlice;
    }

    public void setRuleSlice(List<Rule> r3) {
        this.ruleSlice = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public static Profile fromJson(String r6) {
        Profile r7 = (Profile) ZeusTransformUtils.preCheckCast(new t().a(r6, Profile.class), Profile.class, "com.obric.aiagent.plugin");
        Iterator<Rule> r0 = r7.ruleSlice.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Rule r2 = (Rule) ZeusTransformUtils.preCheckCast(r0.next(), Rule.class, "com.obric.aiagent.plugin");
        r7.rules.put(Long.valueOf(r2.getRuleId()), r2);
        goto L4
    L6:
        return r7;
    }

    public static Profile fromYaml(String r6) {
        Profile r7 = (Profile) ZeusTransformUtils.preCheckCast(new t(new b()).a(r6, Profile.class), Profile.class, "com.obric.aiagent.plugin");
        Iterator<Rule> r0 = r7.ruleSlice.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Rule r2 = (Rule) ZeusTransformUtils.preCheckCast(r0.next(), Rule.class, "com.obric.aiagent.plugin");
        r7.rules.put(Long.valueOf(r2.getRuleId()), r2);
        goto L4
    L6:
        return r7;
    }

    public static Profile defaultProfile(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Profile r0 = new Profile();
        return fromJson(ResourceLoader.loadString(r3, "static_profiles/default.json"));
    L5:
        e = move-exception;
        e.printStackTrace();
        return r0;
    }

    public void addRule(long r2, Rule r4) {
        r4.setRuleId(r2);
        r4.setEnabled(true);
        this.ruleSlice.add(r4);
        this.rules.put(Long.valueOf(r2), r4);
    }

    public void onlyEnableRules(long... r6) {
        HashSet r0 = new HashSet();
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(Long.valueOf(r6[r2]));
        r2 = r2 + 1;
        goto L3
    L5:
        Iterator<Rule> r5 = this.rules.values().iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        Rule r7 = (Rule) ZeusTransformUtils.preCheckCast(r5.next(), Rule.class, "com.obric.aiagent.plugin");
        r7.setEnabled(r0.contains(Long.valueOf(r7.getRuleId())));
        goto L7
    }

    public void disableRule(long r3) {
        if (this.rules.containsKey(Long.valueOf(r3)) == false) goto L6;
        ((Rule) ZeusTransformUtils.preCheckCast(this.rules.get(Long.valueOf(r3)), Rule.class, "com.obric.aiagent.plugin")).setEnabled(false);
        return;
    }

    public long getNextAvailableRuleID() {
        Iterator<Rule> r5 = this.ruleSlice.iterator();
        long r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L9;
        Rule r2 = (Rule) ZeusTransformUtils.preCheckCast(r5.next(), Rule.class, "com.obric.aiagent.plugin");
        if (r2.getRuleId() <= r0) goto L4;
        r0 = r2.getRuleId();
        goto L4
    L9:
        return r0 + 1;
    }
}
