package com.android.server.firewall;

import android.app.AppGlobals;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManagerInternal;
import android.os.Binder;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PatternMatcher;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.XmlUtils;
import com.android.server.EventLogTags;
import com.android.server.IntentResolver;
import com.android.server.LocalServices;
import com.android.server.pm.Computer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class IntentFirewall {
    private static final int LOG_PACKAGES_MAX_LENGTH = 150;
    private static final int LOG_PACKAGES_SUFFICIENT_LENGTH = 125;
    private static final File RULES_DIR = null;
    static final String TAG = "IntentFirewall";
    private static final String TAG_ACTIVITY = "activity";
    private static final String TAG_BROADCAST = "broadcast";
    private static final String TAG_RULES = "rules";
    private static final String TAG_SERVICE = "service";
    private static final int TYPE_ACTIVITY = 0;
    private static final int TYPE_BROADCAST = 1;
    private static final int TYPE_SERVICE = 2;
    private static final HashMap<String, FilterFactory> factoryMap = null;
    private FirewallIntentResolver mActivityResolver;
    private final AMSInterface mAms;
    private FirewallIntentResolver mBroadcastResolver;
    final FirewallHandler mHandler;
    private final RuleObserver mObserver;
    private PackageManagerInternal mPackageManager;
    private FirewallIntentResolver mServiceResolver;

    public interface AMSInterface {
        int checkComponentPermission(String r1, int r2, int r3, int r4, boolean r5);

        Object getAMSLock();
    }

    private final class FirewallHandler extends Handler {
        final /* synthetic */ IntentFirewall this$0;

        public FirewallHandler(IntentFirewall r2, Looper looper) {
            this.this$0 = r2;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            IntentFirewall.m4225$$Nest$mreadRulesDir(this.this$0, IntentFirewall.getRulesDir());
        }
    }

    private static class FirewallIntentFilter extends IntentFilter {
        private final Rule rule;

        /* JADX INFO: renamed from: -$$Nest$fgetrule, reason: not valid java name */
        static /* bridge */ /* synthetic */ Rule m4226$$Nest$fgetrule(FirewallIntentFilter r0) {
            return r0.rule;
        }

        public FirewallIntentFilter(Rule rule) {
            this.rule = rule;
        }
    }

    private static class FirewallIntentResolver extends IntentResolver<FirewallIntentFilter, Rule> {
        private final ArrayMap<ComponentName, Rule[]> mRulesByComponent;
        private final ArrayMap<String, Rule[]> mRulesByComponentClassExact;
        private final List<Rule> mRulesWithComponentClassPattern;

        /* JADX INFO: renamed from: -$$Nest$maddComponentClassExactFilter, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4227$$Nest$maddComponentClassExactFilter(FirewallIntentResolver r0, String r1, Rule r2) {
            r0.addComponentClassExactFilter(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$maddComponentClassPatternFilter, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4228$$Nest$maddComponentClassPatternFilter(FirewallIntentResolver r0, Rule r1) {
            r0.addComponentClassPatternFilter(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mqueryByComponentClass, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4229$$Nest$mqueryByComponentClass(FirewallIntentResolver r0, String r1, List r2) {
            r0.queryByComponentClass(r1, r2);
        }

        /* synthetic */ FirewallIntentResolver(IntentFirewallIA r1) {
            this();
        }

        private FirewallIntentResolver() {
            this.mRulesByComponent = new ArrayMap(0);
            this.mRulesByComponentClassExact = new ArrayMap();
            this.mRulesWithComponentClassPattern = new ArrayList();
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ boolean allowFilterResult(FirewallIntentFilter r1, List<Rule> r2) {
            return allowFilterResult2(r1, r2);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ IntentFilter getIntentFilter(FirewallIntentFilter r1) {
            return getIntentFilter2(r1);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ boolean isPackageForFilter(String r1, FirewallIntentFilter r2) {
            return isPackageForFilter2(r1, r2);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ FirewallIntentFilter[] newArray(int r1) {
            return newArray(r1);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ Rule newResult(Computer r8, FirewallIntentFilter r9, int r10, int r11, long r12) {
            return newResult2(r8, r9, r10, r11, r12);
        }

        /* JADX INFO: renamed from: allowFilterResult, reason: avoid collision after fix types in other method */
        protected boolean allowFilterResult2(FirewallIntentFilter filter, List<Rule> dest) {
            return !dest.contains(FirewallIntentFilter.m4226$$Nest$fgetrule(filter));
        }

        /* JADX INFO: renamed from: isPackageForFilter, reason: avoid collision after fix types in other method */
        protected boolean isPackageForFilter2(String packageName, FirewallIntentFilter filter) {
            return true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.android.server.IntentResolver
        protected FirewallIntentFilter[] newArray(int size) {
            return new FirewallIntentFilter[size];
        }

        /* JADX INFO: renamed from: newResult, reason: avoid collision after fix types in other method */
        protected Rule newResult2(Computer computer, FirewallIntentFilter filter, int match, int userId, long customFlags) {
            return FirewallIntentFilter.m4226$$Nest$fgetrule(filter);
        }

        @Override // com.android.server.IntentResolver
        protected void sortResults(List<Rule> results) {
        }

        /* JADX INFO: renamed from: getIntentFilter, reason: avoid collision after fix types in other method */
        protected IntentFilter getIntentFilter2(FirewallIntentFilter input) {
            return input;
        }

        public void queryByComponent(ComponentName componentName, List<Rule> candidateRules) {
            Rule[] rules = this.mRulesByComponent.get(componentName);
            if (rules == null) goto L6;
            candidateRules.addAll(Arrays.asList(rules));
            return;
        }

        private void queryByComponentClass(String className, List<Rule> candidateRules) {
            Rule[] rules = this.mRulesByComponentClassExact.get(className);
            if (rules == null) goto L5;
            candidateRules.addAll(Arrays.asList(rules));
        L5:
            int i = 0;
        L7:
            if (i >= this.mRulesWithComponentClassPattern.size()) goto L17;
            Rule rule = this.mRulesWithComponentClassPattern.get(i);
            int j = 0;
        L10:
            if (j >= rule.getComponentClassPatternFilterCount()) goto L15;
            if (rule.getComponentClassPatternMatcher(j).match(className) == false) goto L14;
            candidateRules.add(rule);
        L14:
            j = j + 1;
            goto L10
        L15:
            i = i + 1;
            goto L7
        }

        public void addComponentFilter(ComponentName componentName, Rule rule) {
            Rule[] rules = this.mRulesByComponent.get(componentName);
            Rule[] rules2 = (Rule[]) ArrayUtils.appendElement(Rule.class, rules, rule);
            this.mRulesByComponent.put(componentName, rules2);
        }

        private void addComponentClassExactFilter(String className, Rule rule) {
            Rule[] rules = this.mRulesByComponentClassExact.get(className);
            Rule[] rules2 = (Rule[]) ArrayUtils.appendElement(Rule.class, rules, rule);
            this.mRulesByComponentClassExact.put(className, rules2);
        }

        private void addComponentClassPatternFilter(Rule rule) {
            this.mRulesWithComponentClassPattern.add(rule);
        }
    }

    static class Rule extends AndFilter {
        private static final String ATTR_ADVANCED_PATTERN = "advancedPattern";
        private static final String ATTR_BLOCK = "block";
        private static final String ATTR_ENDS_WITH = "endsWith";
        private static final String ATTR_EQUALS = "equals";
        private static final String ATTR_LOG = "log";
        private static final String ATTR_NAME = "name";
        private static final String ATTR_PATTERN = "pattern";
        private static final String ATTR_STARTS_WITH = "startsWith";
        private static final String TAG_COMPONENT_CLASS_FILTER = "component-class-filter";
        private static final String TAG_COMPONENT_FILTER = "component-filter";
        private static final String TAG_INTENT_FILTER = "intent-filter";
        private boolean block;
        private boolean log;
        private final ArrayList<String> mComponentClassExactFilters;
        private final ArrayList<PatternMatcher> mComponentClassPatternMatchers;
        private final ArrayList<ComponentName> mComponentFilters;
        private final ArrayList<FirewallIntentFilter> mIntentFilters;
        private int mRuleType;

        @Override // com.android.server.firewall.FilterList
        public /* bridge */ /* synthetic */ FilterList readFromXml(XmlPullParser r1) throws IOException, XmlPullParserException {
            return readFromXml(r1);
        }

        Rule() {
            this.mIntentFilters = new ArrayList(1);
            this.mComponentFilters = new ArrayList(0);
            this.mComponentClassExactFilters = new ArrayList(0);
            this.mComponentClassPatternMatchers = new ArrayList(0);
        }

        @Override // com.android.server.firewall.FilterList
        public Rule readFromXml(XmlPullParser parser) throws IOException, XmlPullParserException {
            this.block = Boolean.parseBoolean(parser.getAttributeValue(null, ATTR_BLOCK));
            this.log = Boolean.parseBoolean(parser.getAttributeValue(null, ATTR_LOG));
            super.readFromXml(parser);
            return this;
        }

        @Override // com.android.server.firewall.FilterList
        protected void readChild(XmlPullParser parser) throws IOException, XmlPullParserException {
            String currentTag = parser.getName();
            if (currentTag.equals(TAG_INTENT_FILTER) == false) goto L6;
            FirewallIntentFilter intentFilter = new FirewallIntentFilter(this);
            intentFilter.readFromXml(parser);
            this.mIntentFilters.add(intentFilter);
            return;
        L6:
            if (currentTag.equals(TAG_COMPONENT_FILTER) == false) goto L17;
            String componentStr = parser.getAttributeValue(null, "name");
            if (componentStr == null) goto L15;
            ComponentName componentName = ComponentName.unflattenFromString(componentStr);
            if (componentName == null) goto L13;
            this.mComponentFilters.add(componentName);
            return;
        L13:
            throw new XmlPullParserException("Invalid component name: " + componentStr);
        L15:
            throw new XmlPullParserException("Component name must be specified.", parser, null);
        L17:
            if (this.mRuleType == 0) goto L19;
        L56:
            super.readChild(parser);
            return;
        L19:
            if (currentTag.equals(TAG_COMPONENT_CLASS_FILTER) == false) goto L56;
            if (parser.getAttributeCount() != 1) goto L55;
            byte r1 = 0;
            String newAttrName = parser.getAttributeName(0);
            String attrValue = parser.getAttributeValue(0);
            if (attrValue.isEmpty() == true) goto L53;
            switch(newAttrName.hashCode()) {
                case -1555538761: goto L40;
                case -1295482945: goto L37;
                case -791090288: goto L34;
                case -617803506: goto L31;
                case 1743158238: goto L28;
                default: goto L42;
            };
        L42:
            r1 = -1;
        L43:
            switch(r1) {
                case 0: goto L50;
                case 1: goto L49;
                case 2: goto L48;
                case 3: goto L47;
                case 4: goto L46;
                default: goto L45;
            };
        L46:
            this.mComponentClassPatternMatchers.add(new PatternMatcher(attrValue, 3));
            return;
        L47:
            this.mComponentClassPatternMatchers.add(new PatternMatcher(attrValue, 2));
            return;
        L48:
            this.mComponentClassPatternMatchers.add(new PatternMatcher(attrValue, 4));
            return;
        L49:
            this.mComponentClassPatternMatchers.add(new PatternMatcher(attrValue, 1));
            return;
        L50:
            this.mComponentClassExactFilters.add(attrValue);
            return;
        L45:
            throw new XmlPullParserException("component-class-filter only supports 'equals', 'startsWith' and 'endsWith' attribute.");
        L28:
            if (newAttrName.equals(ATTR_ENDS_WITH) == false) goto L42;
            r1 = 2;
            goto L43
        L31:
            if (newAttrName.equals(ATTR_ADVANCED_PATTERN) == false) goto L42;
            r1 = 4;
            goto L43
        L34:
            if (newAttrName.equals(ATTR_PATTERN) == false) goto L42;
            r1 = 3;
            goto L43
        L37:
            if (newAttrName.equals(ATTR_EQUALS) == false) goto L42;
        L40:
            if (newAttrName.equals(ATTR_STARTS_WITH) == false) goto L42;
            r1 = 1;
            goto L43
        L53:
            throw new XmlPullParserException("Attribute value cannot be empty in component-class-filter");
        L55:
            throw new XmlPullParserException("component-class-filter must have one and only one attributes.");
        }

        public int getIntentFilterCount() {
            return this.mIntentFilters.size();
        }

        public FirewallIntentFilter getIntentFilter(int index) {
            return this.mIntentFilters.get(index);
        }

        public int getComponentFilterCount() {
            return this.mComponentFilters.size();
        }

        public ComponentName getComponentFilter(int index) {
            return this.mComponentFilters.get(index);
        }

        public int getComponentClassExactFilterCount() {
            return this.mComponentClassExactFilters.size();
        }

        public String getComponentClassExactFilter(int index) {
            return this.mComponentClassExactFilters.get(index);
        }

        public int getComponentClassPatternFilterCount() {
            return this.mComponentClassPatternMatchers.size();
        }

        public PatternMatcher getComponentClassPatternMatcher(int index) {
            return this.mComponentClassPatternMatchers.get(index);
        }

        public boolean getBlock() {
            return this.block;
        }

        public boolean getLog() {
            return this.log;
        }

        public void setRuleType(int ruleType) {
            this.mRuleType = ruleType;
        }
    }

    private class RuleObserver extends FileObserver {
        private static final int MONITORED_EVENTS = 968;
        final /* synthetic */ IntentFirewall this$0;

        public RuleObserver(IntentFirewall r2, File monitoredDir) {
            this.this$0 = r2;
            super(monitoredDir.getAbsolutePath(), MONITORED_EVENTS);
        }

        @Override // android.os.FileObserver
        public void onEvent(int event, String path) {
            if (path != null) goto L4;
            return;
        L4:
            if (path.endsWith(".xml") == false) goto L8;
            this.this$0.mHandler.removeMessages(0);
            this.this$0.mHandler.sendEmptyMessageDelayed(0, 250);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mreadRulesDir, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4225$$Nest$mreadRulesDir(IntentFirewall r0, File r1) {
        r0.readRulesDir(r1);
    }

    static {
        RULES_DIR = new File(Environment.getDataSystemDirectory(), "ifw");
        FilterFactory[] factories = {AndFilter.FACTORY, OrFilter.FACTORY, NotFilter.FACTORY, StringFilter.ACTION, StringFilter.COMPONENT, StringFilter.COMPONENT_NAME, StringFilter.COMPONENT_PACKAGE, StringFilter.DATA, StringFilter.HOST, StringFilter.MIME_TYPE, StringFilter.SCHEME, StringFilter.PATH, StringFilter.SSP, CategoryFilter.FACTORY, SenderFilter.FACTORY, SenderPackageFilter.FACTORY, SenderPermissionFilter.FACTORY, PortFilter.FACTORY, ExtraKeyValueFilter.FACTORY};
        factoryMap = new HashMap((factories.length * 4) / 3);
        int i = 0;
    L4:
        if (i >= factories.length) goto L7;
        FilterFactory factory = factories[i];
        factoryMap.put(factory.getTagName(), factory);
        i = i + 1;
        goto L4
    }

    public IntentFirewall(AMSInterface ams, Handler handler) {
        this(ams, handler, getRulesDir());
    }

    public IntentFirewall(AMSInterface ams, Handler handler, File rulesDir) {
        IntentFirewallIA r1 = null;
        this.mActivityResolver = new FirewallIntentResolver(r1);
        this.mBroadcastResolver = new FirewallIntentResolver(r1);
        this.mServiceResolver = new FirewallIntentResolver(r1);
        this.mAms = ams;
        this.mHandler = new FirewallHandler(this, handler.getLooper());
        rulesDir.mkdirs();
        readRulesDir(rulesDir);
        this.mObserver = new RuleObserver(this, rulesDir);
        this.mObserver.startWatching();
    }

    PackageManagerInternal getPackageManager() {
        if (this.mPackageManager != null) goto L6;
        this.mPackageManager = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
    L6:
        return this.mPackageManager;
    }

    public boolean checkStartActivity(Intent intent, int callerUid, int callerPid, String resolvedType, ApplicationInfo resolvedApp) {
        return checkIntent(this.mActivityResolver, intent.getComponent(), 0, intent, callerUid, callerPid, resolvedType, resolvedApp.uid);
    }

    public boolean checkService(ComponentName resolvedService, Intent intent, int callerUid, int callerPid, String resolvedType, ApplicationInfo resolvedApp) {
        return checkIntent(this.mServiceResolver, resolvedService, 2, intent, callerUid, callerPid, resolvedType, resolvedApp.uid);
    }

    public boolean checkBroadcast(Intent intent, int callerUid, int callerPid, String resolvedType, int receivingUid) {
        return checkIntent(this.mBroadcastResolver, intent.getComponent(), 1, intent, callerUid, callerPid, resolvedType, receivingUid);
    }

    public boolean checkIntent(FirewallIntentResolver resolver, ComponentName resolvedComponent, int intentType, Intent intent, int callerUid, int callerPid, String resolvedType, int receivingUid) {
        ComponentName r6 = resolvedComponent;
        List<Rule> candidateRules = resolver.queryIntent(getPackageManager().snapshot(), intent, resolvedType, false, 0);
        if (candidateRules != null) goto L5;
        List<Rule> candidateRules2 = new ArrayList();
    L6:
        resolver.queryByComponent(r6, candidateRules2);
        if (r6 == null) goto L10;
        FirewallIntentResolver.m4229$$Nest$mqueryByComponentClass(resolver, r6.getClassName(), candidateRules2);
    L10:
        if (candidateRules2.isEmpty() == false) goto L13;
        return true;
    L13:
        ArraySet<Rule> ruleSet = new ArraySet(candidateRules2);
        boolean log = false;
        boolean block = false;
        int i = 0;
    L15:
        if (i >= ruleSet.size()) goto L23;
        Rule rule = ruleSet.valueAt(i);
        if (rule.matches(this, r6, intent, callerUid, callerPid, resolvedType, receivingUid) == false) goto L22;
        block = block | rule.getBlock();
        log = log | rule.getLog();
        if (block == false) goto L22;
        if (log == true) goto L23;
    L22:
        i = i + 1;
        r6 = resolvedComponent;
    L23:
        if (log == false) goto L27;
        logIntent(intentType, intent, callerUid, resolvedType);
    L27:
        return !block;
    L5:
        candidateRules2 = candidateRules;
        goto L6
    }

    private static void logIntent(int intentType, Intent intent, int callerUid, String resolvedType) {
        ComponentName cn = intent.getComponent();
        if (cn == null) goto L5;
        String shortComponent = cn.flattenToShortString();
        String shortComponent2 = shortComponent;
    L6:
        String callerPackages = null;
        int callerPackageCount = 0;
        IPackageManager pm = AppGlobals.getPackageManager();
        if (pm != null) goto L19;
        String callerPackages2 = null;
        int callerPackageCount2 = 0;
    L17:
        EventLogTags.writeIfwIntentMatched(intentType, shortComponent2, callerUid, callerPackageCount2, callerPackages2, intent.getAction(), resolvedType, intent.getDataString(), intent.getFlags());
        return;
    L19:
        String[] callerPackagesArray = pm.getPackagesForUid(callerUid);     // Catch: RemoteException -> L12
        if (callerPackagesArray == null) goto L14;
        callerPackageCount = callerPackagesArray.length;     // Catch: RemoteException -> L12
        callerPackages = joinPackages(callerPackagesArray);     // Catch: RemoteException -> L12
    L14:
        callerPackages2 = callerPackages;
        callerPackageCount2 = callerPackageCount;
    L12:
        ex = move-exception;
        Slog.e(TAG, "Remote exception while retrieving packages", ex);
        callerPackages2 = null;
        callerPackageCount2 = callerPackageCount;
        goto L17
    L5:
        shortComponent2 = null;
        goto L6
    }

    private static String joinPackages(String[] packages) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
    L4:
        if (i >= packages.length) goto L13;
        String pkg = packages[i];
        if ((sb.length() + pkg.length()) > 150) goto L9;
        sb.append(pkg);
        sb.append(',');
    L11:
        i = i + 1;
        goto L4
    L9:
        if (sb.length() <= 125) goto L11;
    L13:
        if (sb.isEmpty() == false) goto L17;
        String pkg2 = packages[0];
        return pkg2.substring((pkg2.length() - 150) + 1) + '-';
    L17:
        return sb.substring(0, sb.length() - 1);
    }

    public static File getRulesDir() {
        return RULES_DIR;
    }

    private void readRulesDir(File rulesDir) {
        FirewallIntentResolver[] resolvers = new FirewallIntentResolver[3];
        int i = 0;
    L4:
        if (i >= resolvers.length) goto L6;
        resolvers[i] = new FirewallIntentResolver(null);
        i = i + 1;
        goto L4
    L6:
        File[] files = rulesDir.listFiles();
        if (files == null) goto L15;
        int i2 = 0;
    L10:
        if (i2 >= files.length) goto L15;
        File file = files[i2];
        if (file.getName().endsWith(".xml") == false) goto L14;
        readRules(file, resolvers);
    L14:
        i2 = i2 + 1;
    L15:
        Slog.i(TAG, "Read new rules (A:" + resolvers[0].filterSet().size() + " B:" + resolvers[1].filterSet().size() + " S:" + resolvers[2].filterSet().size() + ")");
        Object r2 = this.mAms.getAMSLock();
        monitor-enter(r2);
        this.mActivityResolver = resolvers[0];     // Catch: Throwable -> L20
        this.mBroadcastResolver = resolvers[1];     // Catch: Throwable -> L20
        this.mServiceResolver = resolvers[2];     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    private void readRules(File rulesFile, FirewallIntentResolver[] resolvers) {
        List<List<Rule>> rulesByType = new ArrayList(3);
        int i = 0;
    L3:
        if (i >= 3) goto L92;
        rulesByType.add(new ArrayList());
        i = i + 1;
        goto L3
    L92:
        FileInputStream fis = new FileInputStream(rulesFile);     // Catch: FileNotFoundException -> L86
        XmlPullParser parser = Xml.newPullParser();     // Catch: Throwable -> L27 IOException -> L29 XmlPullParserException -> L31
        parser.setInput(fis, null);     // Catch: Throwable -> L27 IOException -> L29 XmlPullParserException -> L31
        XmlUtils.beginDocument(parser, TAG_RULES);     // Catch: Throwable -> L27 IOException -> L29 XmlPullParserException -> L31
        int outerDepth = parser.getDepth();     // Catch: Throwable -> L27 IOException -> L29 XmlPullParserException -> L31
    L9:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L97;
        String tagName = parser.getName();     // Catch: Throwable -> L27 IOException -> L29 XmlPullParserException -> L31
        if (tagName.equals("activity") == false) goto L15;
        int ruleType = 0;
    L22:
        if (ruleType == (-1)) goto L9;
        Rule rule = new Rule();     // Catch: Throwable -> L27 IOException -> L29 XmlPullParserException -> L31
        rule.setRuleType(ruleType);     // Catch: Throwable -> L27 IOException -> L29 XmlPullParserException -> L31
        List<Rule> rules = rulesByType.get(ruleType);     // Catch: Throwable -> L27 IOException -> L29 XmlPullParserException -> L31
        rule.readFromXml(parser);     // Catch: Throwable -> L27 IOException -> L29 Throwable -> L33
        rules.add(rule);     // Catch: Throwable -> L27 IOException -> L29 XmlPullParserException -> L31
    L33:
        ex = move-exception;
        Slog.e(TAG, "Error reading an intent firewall rule from " + rulesFile, ex);     // Catch: Throwable -> L27 IOException -> L29 XmlPullParserException -> L31
        goto L9
    L15:
        if (tagName.equals("broadcast") == false) goto L18;
        ruleType = 1;
        goto L22
    L18:
        if (tagName.equals("service") == false) goto L20;
        ruleType = 2;
        goto L22
    L20:
        ruleType = -1;
        goto L22
    L97:
        fis.close();     // Catch: IOException -> L40
    L42:
        int ruleType2 = 0;
    L44:
        if (ruleType2 >= rulesByType.size()) goto L66;
        List<Rule> rules2 = rulesByType.get(ruleType2);
        FirewallIntentResolver resolver = resolvers[ruleType2];
        int ruleIndex = 0;
    L47:
        if (ruleIndex >= rules2.size()) goto L64;
        Rule rule2 = rules2.get(ruleIndex);
        int i2 = 0;
    L50:
        if (i2 >= rule2.getIntentFilterCount()) goto L52;
        resolver.addFilter(null, rule2.getIntentFilter(i2));
        i2 = i2 + 1;
        goto L50
    L52:
        int i3 = 0;
    L54:
        if (i3 >= rule2.getComponentFilterCount()) goto L56;
        resolver.addComponentFilter(rule2.getComponentFilter(i3), rule2);
        i3 = i3 + 1;
        goto L54
    L56:
        int i4 = 0;
    L58:
        if (i4 >= rule2.getComponentClassExactFilterCount()) goto L60;
        FirewallIntentResolver.m4227$$Nest$maddComponentClassExactFilter(resolver, rule2.getComponentClassExactFilter(i4), rule2);
        i4 = i4 + 1;
        goto L58
    L60:
        int i5 = rule2.getComponentClassPatternFilterCount();
        if (i5 <= 0) goto L63;
        FirewallIntentResolver.m4228$$Nest$maddComponentClassPatternFilter(resolver, rule2);
    L63:
        ruleIndex = ruleIndex + 1;
        goto L47
    L64:
        ruleType2 = ruleType2 + 1;
        goto L44
    L66:
        return;
    L40:
        ex = move-exception;
        Slog.e(TAG, "Error while closing " + rulesFile, ex);
        goto L42
    L31:
        ex = move-exception;
        Slog.e(TAG, "Error reading intent firewall rules from " + rulesFile, ex);     // Catch: Throwable -> L27
        fis.close();     // Catch: IOException -> L78
        return;
    L78:
        ex = move-exception;
        Slog.e(TAG, "Error while closing " + rulesFile, ex);
        return;
    L29:
        ex = move-exception;
        Slog.e(TAG, "Error reading intent firewall rules from " + rulesFile, ex);     // Catch: Throwable -> L27
        fis.close();     // Catch: IOException -> L71
        return;
    L71:
        ex = move-exception;
        Slog.e(TAG, "Error while closing " + rulesFile, ex);
        return;
    L27:
        ex = move-exception;
        fis.close();     // Catch: IOException -> L83
        throw ex;
    L83:
        ex = move-exception;
        Slog.e(TAG, "Error while closing " + rulesFile, ex);
        throw ex;
    }

    static Filter parseFilter(XmlPullParser parser) throws IOException, XmlPullParserException {
        String elementName = parser.getName();
        FilterFactory factory = factoryMap.get(elementName);
        if (factory == null) goto L7;
        return factory.newFilter(parser);
    L7:
        throw new XmlPullParserException("Unknown element in filter list: " + elementName);
    }

    boolean checkComponentPermission(String permission, int pid, int uid, int owningUid, boolean exported) {
        if (this.mAms.checkComponentPermission(permission, pid, uid, owningUid, exported) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean signaturesMatch(int uid1, int uid2) {
        long token = Binder.clearCallingIdentity();
        if (getPackageManager().checkUidSignaturesForAllUsers(uid1, uid2) != 0) goto L6;
        boolean r2 = true;
    L7:
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        r2 = false;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }
}
