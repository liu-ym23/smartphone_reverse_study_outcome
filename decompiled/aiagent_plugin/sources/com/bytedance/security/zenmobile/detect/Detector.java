package com.bytedance.security.zenmobile.detect;

import android.content.Context;
import com.bytedance.security.zenmobile.detect.anchor.Finder;
import com.bytedance.security.zenmobile.detect.anchor.FinderStore;
import com.bytedance.security.zenmobile.detect.anchor.MatchRule;
import com.bytedance.security.zenmobile.detect.extension.Extender;
import com.bytedance.security.zenmobile.detect.extension.ExtenderFactory;
import com.bytedance.security.zenmobile.detect.extension.ExtensionResult;
import com.bytedance.security.zenmobile.detect.filter.Excluder;
import com.bytedance.security.zenmobile.detect.filter.ExcluderFactory;
import com.bytedance.security.zenmobile.io.AnchorFinder;
import com.bytedance.security.zenmobile.io.ExtensionExtender;
import com.bytedance.security.zenmobile.io.Match;
import com.bytedance.security.zenmobile.io.Profile;
import com.bytedance.security.zenmobile.io.Rule;
import com.bytedance.security.zenmobile.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Detector {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TAG = "ZenMobile-Detector";
    static Comparator<Match> matchesComparator;
    private FinderStore anchorFinderStore;
    private Map<Long, CompiledRule> compiledRules;
    private Profile profile;
    private boolean skipFailureCompilation;

    static {
        matchesComparator = $$Lambda$Detector$Tk5vVfg4U_U5d1kboZlfNSzGXWc.INSTANCE;
    }

    static /* synthetic */ int lambda$static$0(Match r2, Match r3) {
        int r0 = r2.getPriority();
        int r1 = r3.getPriority();
        int r4 = r2.getByteStart();
        int r5 = r3.getByteStart();
        if (r0 <= r1) goto L6;
        return -1;
    L6:
        if (r0 >= r1) goto L10;
        return 1;
    L10:
        return Integer.compare(r4, r5);
    }

    public Detector(Context r3, Profile r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L7;
        this.profile = r4;
        this.skipFailureCompilation = false;
        this.compiledRules = new HashMap();
        compileRules(r5);
        return;
    L7:
        throw new IllegalArgumentException("profile is null");
    }

    public Detector(Context r3, Profile r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L7;
        this.profile = r4;
        this.skipFailureCompilation = r5;
        this.compiledRules = new HashMap();
        compileRules(r6);
        return;
    L7:
        throw new IllegalArgumentException("profile is null");
    }

    public Profile getProfile() {
        return this.profile;
    }

    public List<Match> detect(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == false) goto L7;
        return null;
    L7:
        return detect(r2.getBytes(StandardCharsets.UTF_8));
    }

    public List<Match> detect(byte[] r26) {
        Detector this = this;
        if (r26 != null) goto L5;
    L125:
        LogUtils.e(TAG, "invalid input param");
        return null;
    L5:
        if (r26.length == 0) goto L125;
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        List<com.bytedance.security.zenmobile.detect.anchor.Match> r5 = this.anchorFinderStore.search(r26);
        if (r5 != null) goto L10;
    L123:
        LogUtils.e(TAG, "anchorMatches is null or empty");
        return r4;
    L10:
        if (r5.isEmpty() == true) goto L123;
        LogUtils.d(TAG, "anchorMatches.size(): " + r5.size());
        Iterator<com.bytedance.security.zenmobile.detect.anchor.Match> r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L121;
        com.bytedance.security.zenmobile.detect.anchor.Match r7 = (com.bytedance.security.zenmobile.detect.anchor.Match) ZeusTransformUtils.preCheckCast(r6.next(), com.bytedance.security.zenmobile.detect.anchor.Match.class, "com.obric.aiagent.plugin");
        Iterator<MatchRule> r8 = r7.getRules().iterator();
    L17:
        if (r8.hasNext() == false) goto L120;
        MatchRule r9 = (MatchRule) ZeusTransformUtils.preCheckCast(r8.next(), MatchRule.class, "com.obric.aiagent.plugin");
        LogUtils.d(TAG, "matchRule.getRuleId(): " + r9.getRuleId());
        LogUtils.d(TAG, "matchRule.getWord(): " + r9.getWord());
        boolean r10 = false;
        CompiledRule r11 = (CompiledRule) ZeusTransformUtils.preCheckCast(this.compiledRules.get(Long.valueOf(r9.getRuleId())), CompiledRule.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L17;
        if (r11.getRuleId() >= 1000) goto L24;
    L28:
        Iterator<com.bytedance.security.zenmobile.detect.anchor.Match> r24 = r6;
        if (r11.getCompiledAnchor() == null) goto L36;
        Iterator<Excluder> r0 = r11.getCompiledAnchor().getCompiledExcluders().iterator();
    L32:
        if (r0.hasNext() == false) goto L36;
        if (((Excluder) ZeusTransformUtils.preCheckCast(r0.next(), Excluder.class, "com.obric.aiagent.plugin")).exclude(r26, r7.getByteStart(), r7.getByteEnd()) == false) goto L32;
        r10 = true;
    L36:
        if (r10 == false) goto L39;
    L27:
        r6 = r24;
        goto L17
    L39:
        if (r9.isInValue() == false) goto L41;
        LogUtils.d(TAG, "matchRule.isInValue()");
        int r1 = r7.getByteStart();
        int r12 = r7.getByteEnd();
        LogUtils.d(TAG, "vStart: " + r1);
        LogUtils.d(TAG, "vEnd: " + r12);
    L42:
        int r13 = r7.getByteEnd();
        LogUtils.d(TAG, "fwd: " + r13);
        if (r11.getCompiledForward() == null) goto L71;
        Iterator<Extender> r14 = r11.getCompiledForward().getCompiledExtenders().iterator();
    L46:
        if (r14.hasNext() == false) goto L61;
        Extender r15 = (Extender) ZeusTransformUtils.preCheckCast(r14.next(), Extender.class, "com.obric.aiagent.plugin");
        LogUtils.d(TAG, "extender.mode: " + r15.getMode());
        ExtensionResult r16 = r15.extend(r26, r13);
        if (r16 == null) goto L60;
        if (r16.isMatched() == false) goto L60;
        if (r15.isInValue() == false) goto L59;
        if (r12 != r13) goto L57;
        LogUtils.d(TAG, "extender.isInValue()");
        r12 = r16.getEnd();
        goto L59
    L57:
        if (r12 != (-1)) goto L59;
        LogUtils.d(TAG, "!extender.isInValue()");
        r12 = r16.getEnd();
        r1 = r13;
    L59:
        r13 = r16.getEnd();
    L60:
        LogUtils.d(TAG, "forward extend failed");
        r10 = true;
    L61:
        if (r10 == false) goto L63;
        LogUtils.d(TAG, "forward - extenders failed");
        goto L27
    L63:
        Iterator<Excluder> r17 = r11.getCompiledForward().getCompiledExcluders().iterator();
    L65:
        if (r17.hasNext() == false) goto L69;
        if (((Excluder) ZeusTransformUtils.preCheckCast(r17.next(), Excluder.class, "com.obric.aiagent.plugin")).exclude(r26, r7.getByteEnd(), r13) == false) goto L65;
        LogUtils.d(TAG, "forward excluders failed");
        r10 = true;
    L69:
        if (r10 == false) goto L71;
        LogUtils.d(TAG, "forward - excluders failed");
    L71:
        int r18 = r7.getByteStart();
        if (r11.getCompiledBackward() == null) goto L102;
        Iterator<Extender> r19 = r11.getCompiledBackward().getCompiledExtenders().iterator();
    L75:
        if (r19.hasNext() == false) goto L92;
        Extender r110 = (Extender) ZeusTransformUtils.preCheckCast(r19.next(), Extender.class, "com.obric.aiagent.plugin");
        LogUtils.d(TAG, "extender.mode(): " + r110.getMode());
        ExtensionResult r111 = r110.extend(r26, r18);
        if (r111 == null) goto L91;
        if (r111.isMatched() == false) goto L91;
        if (r110.isInValue() == false) goto L90;
        LogUtils.d(TAG, "backward extender.isInValue()");
        if (r1 != r18) goto L88;
        r1 = r111.getEnd();
        goto L90
    L88:
        if (r1 != (-1)) goto L90;
        r1 = r111.getEnd();
        r12 = r18;
    L90:
        r18 = r111.getEnd();
    L91:
        LogUtils.d(TAG, "backward extend failed");
        r10 = true;
    L92:
        if (r10 == false) goto L94;
        LogUtils.d(TAG, "backward - extenders failed");
        goto L27
    L94:
        Iterator<Excluder> r112 = r11.getCompiledBackward().getCompiledExcluders().iterator();
    L96:
        if (r112.hasNext() == false) goto L100;
        if (((Excluder) ZeusTransformUtils.preCheckCast(r112.next(), Excluder.class, "com.obric.aiagent.plugin")).exclude(r26, r18, r7.getByteStart()) == false) goto L96;
        r10 = true;
    L100:
        if (r10 == false) goto L102;
        LogUtils.d(TAG, "backward - excluders failed");
    L102:
        int r20 = r12;
        if (r1 >= r20) goto L118;
        if (r1 < 0) goto L118;
        if (r20 > r26.length) goto L118;
        Iterator<Excluder> r21 = r11.getCompiledValueExcluders().iterator();
    L110:
        if (r21.hasNext() == false) goto L114;
        if (((Excluder) ZeusTransformUtils.preCheckCast(r21.next(), Excluder.class, "com.obric.aiagent.plugin")).exclude(r26, r1, r20) == false) goto L110;
        boolean r113 = true;
    L115:
        if (r113 == true) goto L27;
        r3.add(new Match(r11.getRuleId(), r11.getRuleVersion(), r11.getRuleNameEn(), r11.getRuleNameZh(), r11.getByteDataTagId(), r1, r20, new String(Arrays.copyOfRange(r26, r1, r20), StandardCharsets.UTF_8), r11.getSensitiveType(), r11.getPriority()));
        LogUtils.d(TAG, "sortable.size()" + r3.size());
    L119:
        r7 = r7;
        r8 = r8;
        goto L27
    L114:
        r113 = r10;
    L118:
        LogUtils.d(TAG, "invalid value extraction");
        LogUtils.d(TAG, "vStart: " + r1 + ", vEnd: " + r20 + ", input.length: " + r26.length);
        goto L119
    L41:
        LogUtils.d(TAG, "!matchRule.isInValue()");
        r1 = -1;
        r12 = -1;
        goto L42
    L24:
        if (r11.getRuleId() > 1100) goto L28;
        LogUtils.d(TAG, "Exact match rule");
        int r22 = r7.getByteStart();
        int r23 = r7.getByteEnd();
        r24 = r6;
        r3.add(new Match(r11.getRuleId(), r11.getRuleVersion(), r11.getRuleNameEn(), r11.getRuleNameZh(), r11.getByteDataTagId(), r22, r23, new String(Arrays.copyOfRange(r26, r22, r23), StandardCharsets.UTF_8), r11.getSensitiveType(), r11.getPriority()));
        goto L27
    L120:
        this = this;
        goto L14
    L121:
        r3.sort(matchesComparator);
        return r3;
    }

    private void compileRules(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        this.anchorFinderStore = new FinderStore();
        Iterator<Rule> r0 = this.profile.getRules().values().iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        Rule r2 = (Rule) ZeusTransformUtils.preCheckCast(r0.next(), Rule.class, "com.obric.aiagent.plugin");
        if (r2.isEnabled() == false) goto L4;
        CompiledRule r3 = compileRule(r9, r2);
        if (r3 != null) goto L9;
        if (this.skipFailureCompilation == false) goto L14;
        LogUtils.e(TAG, "rule compilation error for rule ID: " + r2.getRuleId());
        goto L4
    L14:
        throw new RuntimeException(String.format("rule compilation error for rule ID %d\n", new Object[]{Long.valueOf(r2.getRuleId())}));
    L9:
        this.compiledRules.put(Long.valueOf(r2.getRuleId()), r3);
        goto L4
    L15:
        this.anchorFinderStore.compile();
    }

    private CompiledRule compileRule(Context r21, Rule r22) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.aiagent.plugin");
        CompiledAnchor r9 = new CompiledAnchor();
        CompiledForward r10 = new CompiledForward();
        CompiledBackward r11 = new CompiledBackward();
        ArrayList r12 = new ArrayList();
        Iterator<AnchorFinder> r13 = r22.getAnchor().getFinders().iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        AnchorFinder r2 = (AnchorFinder) ZeusTransformUtils.preCheckCast(r13.next(), AnchorFinder.class, "com.obric.aiagent.plugin");
        Finder r4 = this.anchorFinderStore.getFinder(r2.getMode());
        if (r4 == null) goto L7;
        r4.addRule(r0, r2.getValues(), r22.getRuleId(), r2.isInValue(), r2.getExtra());
        goto L4
    L7:
        return null;
    L9:
        Iterator<com.bytedance.security.zenmobile.io.Excluder> r1 = r22.getAnchor().getExcluders().iterator();
    L11:
        if (r1.hasNext() == false) goto L16;
        com.bytedance.security.zenmobile.io.Excluder r3 = (com.bytedance.security.zenmobile.io.Excluder) ZeusTransformUtils.preCheckCast(r1.next(), com.bytedance.security.zenmobile.io.Excluder.class, "com.obric.aiagent.plugin");
        Excluder r5 = ExcluderFactory.createExcluder(r3.getMode(), r3.getValues());
        if (r5 == null) goto L14;
        r9.addExcluder(r5);
        goto L11
    L14:
        return null;
    L16:
        Iterator<ExtensionExtender> r6 = r22.getForward().getExtenders().iterator();
    L18:
        if (r6.hasNext() == false) goto L23;
        ExtensionExtender r7 = (ExtensionExtender) ZeusTransformUtils.preCheckCast(r6.next(), ExtensionExtender.class, "com.obric.aiagent.plugin");
        Extender r8 = ExtenderFactory.createExtender(r7.getMode(), 1, r7.getValues(), r7.getMinLength(), r7.getMaxLength(), r7.isInValue(), r7.getExtra());
        if (r8 == null) goto L21;
        r10.addExtender(r8);
        goto L18
    L21:
        return null;
    L23:
        Iterator<com.bytedance.security.zenmobile.io.Excluder> r14 = r22.getForward().getExcluders().iterator();
    L25:
        if (r14.hasNext() == false) goto L30;
        com.bytedance.security.zenmobile.io.Excluder r15 = (com.bytedance.security.zenmobile.io.Excluder) ZeusTransformUtils.preCheckCast(r14.next(), com.bytedance.security.zenmobile.io.Excluder.class, "com.obric.aiagent.plugin");
        Excluder r16 = ExcluderFactory.createExcluder(r15.getMode(), r15.getValues());
        if (r16 == null) goto L28;
        r10.addExcluder(r16);
        goto L25
    L28:
        return null;
    L30:
        Iterator<ExtensionExtender> r17 = r22.getBackward().getExtenders().iterator();
    L32:
        if (r17.hasNext() == false) goto L37;
        ExtensionExtender r18 = (ExtensionExtender) ZeusTransformUtils.preCheckCast(r17.next(), ExtensionExtender.class, "com.obric.aiagent.plugin");
        Extender r19 = ExtenderFactory.createExtender(r18.getMode(), -1, r18.getValues(), r18.getMinLength(), r18.getMaxLength(), r18.isInValue(), r18.getExtra());
        if (r19 == null) goto L35;
        r11.addExtender(r19);
        goto L32
    L35:
        return null;
    L37:
        Iterator<com.bytedance.security.zenmobile.io.Excluder> r20 = r22.getBackward().getExcluders().iterator();
    L39:
        if (r20.hasNext() == false) goto L44;
        com.bytedance.security.zenmobile.io.Excluder r23 = (com.bytedance.security.zenmobile.io.Excluder) ZeusTransformUtils.preCheckCast(r20.next(), com.bytedance.security.zenmobile.io.Excluder.class, "com.obric.aiagent.plugin");
        Excluder r24 = ExcluderFactory.createExcluder(r23.getMode(), r23.getValues());
        if (r24 == null) goto L42;
        r11.addExcluder(r24);
        goto L39
    L42:
        return null;
    L44:
        Iterator<com.bytedance.security.zenmobile.io.Excluder> r25 = r22.getValueExcluders().iterator();
    L46:
        if (r25.hasNext() == false) goto L51;
        com.bytedance.security.zenmobile.io.Excluder r26 = (com.bytedance.security.zenmobile.io.Excluder) ZeusTransformUtils.preCheckCast(r25.next(), com.bytedance.security.zenmobile.io.Excluder.class, "com.obric.aiagent.plugin");
        Excluder r27 = ExcluderFactory.createExcluder(r26.getMode(), r26.getValues());
        if (r27 == null) goto L49;
        r12.add(r27);
        goto L46
    L49:
        return null;
    L51:
        CompiledRule r28 = new CompiledRule();
        r28.setRuleId(r22.getRuleId());
        r28.setRuleVersion(r22.getRuleVersion());
        r28.setRuleNameEn(r22.getRuleNameEn());
        r28.setByteDataTagId(r22.getByteDataTagId());
        r28.setSensitiveType(r22.getSensitiveType());
        r28.setPriority(r22.getPriority());
        r28.setCompiledAnchor(r9);
        r28.setCompiledForward(r10);
        r28.setCompiledBackward(r11);
        r28.setCompiledValueExcluders(r12);
        return r28;
    }
}
