package com.uxsense.base.parse;

import A9.d;
import B9.T;
import B9.d0;
import B9.h0;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.pattern.ParentFilter;
import com.uxsense.core.pattern.ParentFilter$$serializer;
import com.uxsense.core.pattern.ViewPattern;
import com.uxsense.parse.MetadataConfig;
import com.uxsense.parse.MetadataConfig$$serializer;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u0000 <2\u00020\u0001:\u0002=<BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eBa\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0013J'\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001eJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u001eJ\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u001eJ\u0010\u0010\"\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b$\u0010%J\u0012\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b&\u0010'J^\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010\u001eJ\u0010\u0010+\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010/\u001a\u00020.2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b/\u00100R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b2\u0010\u001eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00101\u001a\u0004\b3\u0010\u001eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00101\u001a\u0004\b4\u0010\u001eR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u00101\u001a\u0004\b5\u0010\u001eR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u00106\u001a\u0004\b7\u0010#R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u00108\u001a\u0004\b9\u0010%R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010:\u001a\u0004\b;\u0010'¨\u0006>"}, d2 = {"Lcom/uxsense/base/parse/ParseRule;", "", "", "packageName", "windowTitle", "activityClass", "appVersion", "Lcom/uxsense/core/pattern/ViewPattern;", "viewPattern", "Lcom/uxsense/core/pattern/ParentFilter;", "parentFilter", "Lcom/uxsense/parse/MetadataConfig;", "metadataConfig", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/uxsense/core/pattern/ViewPattern;Lcom/uxsense/core/pattern/ParentFilter;Lcom/uxsense/parse/MetadataConfig;)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/uxsense/core/pattern/ViewPattern;Lcom/uxsense/core/pattern/ParentFilter;Lcom/uxsense/parse/MetadataConfig;LB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/base/parse/ParseRule;LA9/d;Lz9/g;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "()Lcom/uxsense/core/pattern/ViewPattern;", "component6", "()Lcom/uxsense/core/pattern/ParentFilter;", "component7", "()Lcom/uxsense/parse/MetadataConfig;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/uxsense/core/pattern/ViewPattern;Lcom/uxsense/core/pattern/ParentFilter;Lcom/uxsense/parse/MetadataConfig;)Lcom/uxsense/base/parse/ParseRule;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPackageName", "getWindowTitle", "getActivityClass", "getAppVersion", "Lcom/uxsense/core/pattern/ViewPattern;", "getViewPattern", "Lcom/uxsense/core/pattern/ParentFilter;", "getParentFilter", "Lcom/uxsense/parse/MetadataConfig;", "getMetadataConfig", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ParseRule {
    private final String activityClass;
    private final String appVersion;
    private final MetadataConfig metadataConfig;
    private final String packageName;
    private final ParentFilter parentFilter;
    private final ViewPattern viewPattern;
    private final String windowTitle;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final f[] $childSerializers = {null, null, null, null, a.b(LazyThreadSafetyMode.b, new Ba.a(27)), null, null};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/base/parse/ParseRule$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/base/parse/ParseRule;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return ParseRule$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    public /* synthetic */ ParseRule(int i, String str, String str2, String str3, String str4, ViewPattern viewPattern, ParentFilter parentFilter, MetadataConfig metadataConfig, d0 d0Var) {
        if (19 != (i & 19)) {
            T.g(ParseRule$$serializer.INSTANCE.getDescriptor(), i, 19);
            throw null;
        }
        this.packageName = str;
        this.windowTitle = str2;
        if ((i & 4) == 0) {
            this.activityClass = null;
        } else {
            this.activityClass = str3;
        }
        if ((i & 8) == 0) {
            this.appVersion = null;
        } else {
            this.appVersion = str4;
        }
        this.viewPattern = viewPattern;
        if ((i & 32) == 0) {
            this.parentFilter = null;
        } else {
            this.parentFilter = parentFilter;
        }
        if ((i & 64) == 0) {
            this.metadataConfig = null;
        } else {
            this.metadataConfig = metadataConfig;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_() {
        return ViewPattern.INSTANCE.serializer();
    }

    public static /* synthetic */ ParseRule copy$default(ParseRule parseRule, String str, String str2, String str3, String str4, ViewPattern viewPattern, ParentFilter parentFilter, MetadataConfig metadataConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            str = parseRule.packageName;
        }
        if ((i & 2) != 0) {
            str2 = parseRule.windowTitle;
        }
        if ((i & 4) != 0) {
            str3 = parseRule.activityClass;
        }
        if ((i & 8) != 0) {
            str4 = parseRule.appVersion;
        }
        if ((i & 16) != 0) {
            viewPattern = parseRule.viewPattern;
        }
        if ((i & 32) != 0) {
            parentFilter = parseRule.parentFilter;
        }
        if ((i & 64) != 0) {
            metadataConfig = parseRule.metadataConfig;
        }
        ParentFilter parentFilter2 = parentFilter;
        MetadataConfig metadataConfig2 = metadataConfig;
        ViewPattern viewPattern2 = viewPattern;
        String str5 = str3;
        return parseRule.copy(str, str2, str5, str4, viewPattern2, parentFilter2, metadataConfig2);
    }

    public static final /* synthetic */ void write$Self$uxsense_release(ParseRule self, d output, g serialDesc) {
        f[] fVarArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.packageName);
        output.encodeStringElement(serialDesc, 1, self.windowTitle);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.activityClass != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, h0.f242a, self.activityClass);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.appVersion != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, h0.f242a, self.appVersion);
        }
        output.encodeSerializableElement(serialDesc, 4, (x9.f) fVarArr[4].getF4884a(), self.viewPattern);
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.parentFilter != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, ParentFilter$$serializer.INSTANCE, self.parentFilter);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.metadataConfig == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 6, MetadataConfig$$serializer.INSTANCE, self.metadataConfig);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getWindowTitle() {
        return this.windowTitle;
    }

    /* renamed from: component3, reason: from getter */
    public final String getActivityClass() {
        return this.activityClass;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: component5, reason: from getter */
    public final ViewPattern getViewPattern() {
        return this.viewPattern;
    }

    /* renamed from: component6, reason: from getter */
    public final ParentFilter getParentFilter() {
        return this.parentFilter;
    }

    /* renamed from: component7, reason: from getter */
    public final MetadataConfig getMetadataConfig() {
        return this.metadataConfig;
    }

    public final ParseRule copy(String packageName, String windowTitle, String activityClass, String appVersion, ViewPattern viewPattern, ParentFilter parentFilter, MetadataConfig metadataConfig) {
        k.f(packageName, "packageName");
        k.f(windowTitle, "windowTitle");
        k.f(viewPattern, "viewPattern");
        return new ParseRule(packageName, windowTitle, activityClass, appVersion, viewPattern, parentFilter, metadataConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParseRule)) {
            return false;
        }
        ParseRule parseRule = (ParseRule) other;
        return k.b(this.packageName, parseRule.packageName) && k.b(this.windowTitle, parseRule.windowTitle) && k.b(this.activityClass, parseRule.activityClass) && k.b(this.appVersion, parseRule.appVersion) && k.b(this.viewPattern, parseRule.viewPattern) && k.b(this.parentFilter, parseRule.parentFilter) && k.b(this.metadataConfig, parseRule.metadataConfig);
    }

    public final String getActivityClass() {
        return this.activityClass;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final MetadataConfig getMetadataConfig() {
        return this.metadataConfig;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final ParentFilter getParentFilter() {
        return this.parentFilter;
    }

    public final ViewPattern getViewPattern() {
        return this.viewPattern;
    }

    public final String getWindowTitle() {
        return this.windowTitle;
    }

    public int hashCode() {
        int iC = B7.a.c(this.packageName.hashCode() * 31, 31, this.windowTitle);
        String str = this.activityClass;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.appVersion;
        int iHashCode2 = (this.viewPattern.hashCode() + ((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31;
        ParentFilter parentFilter = this.parentFilter;
        int iHashCode3 = (iHashCode2 + (parentFilter == null ? 0 : parentFilter.hashCode())) * 31;
        MetadataConfig metadataConfig = this.metadataConfig;
        return iHashCode3 + (metadataConfig != null ? metadataConfig.hashCode() : 0);
    }

    public String toString() {
        return "ParseRule(packageName=" + this.packageName + ", windowTitle=" + this.windowTitle + ", activityClass=" + this.activityClass + ", appVersion=" + this.appVersion + ", viewPattern=" + this.viewPattern + ", parentFilter=" + this.parentFilter + ", metadataConfig=" + this.metadataConfig + ')';
    }

    public ParseRule(String packageName, String windowTitle, String str, String str2, ViewPattern viewPattern, ParentFilter parentFilter, MetadataConfig metadataConfig) {
        k.f(packageName, "packageName");
        k.f(windowTitle, "windowTitle");
        k.f(viewPattern, "viewPattern");
        this.packageName = packageName;
        this.windowTitle = windowTitle;
        this.activityClass = str;
        this.appVersion = str2;
        this.viewPattern = viewPattern;
        this.parentFilter = parentFilter;
        this.metadataConfig = metadataConfig;
    }

    public /* synthetic */ ParseRule(String str, String str2, String str3, String str4, ViewPattern viewPattern, ParentFilter parentFilter, MetadataConfig metadataConfig, int i, e eVar) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, viewPattern, (i & 32) != 0 ? null : parentFilter, (i & 64) != 0 ? null : metadataConfig);
    }
}
