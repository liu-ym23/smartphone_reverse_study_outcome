package com.uxsense.core.pattern;

import A9.d;
import B9.F;
import B9.d0;
import B9.h0;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000243BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nBM\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\t\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001eJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u001eJ\u0012\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b#\u0010\"JL\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b&\u0010\u001eJ\u0010\u0010'\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010*\u001a\u00020\u001a2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010\u001eR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010,\u001a\u0004\b.\u0010\u001eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b/\u0010\u001eR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00100\u001a\u0004\b1\u0010\"R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u00100\u001a\u0004\b2\u0010\"¨\u00065"}, d2 = {"Lcom/uxsense/core/pattern/ParentFilter;", "", "", "className", "classNameContains", "classNameRegex", "", "minChildCount", "maxChildCount", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;LB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/core/pattern/ParentFilter;LA9/d;Lz9/g;)V", "write$Self", "Lcom/uxsense/core/base/parse/KViewNode;", "node", "", "matches", "(Lcom/uxsense/core/base/parse/KViewNode;)Z", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Ljava/lang/Integer;", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/uxsense/core/pattern/ParentFilter;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getClassName", "getClassNameContains", "getClassNameRegex", "Ljava/lang/Integer;", "getMinChildCount", "getMaxChildCount", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ParentFilter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String className;
    private final String classNameContains;
    private final String classNameRegex;
    private final Integer maxChildCount;
    private final Integer minChildCount;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/core/pattern/ParentFilter$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/core/pattern/ParentFilter;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return ParentFilter$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    public ParentFilter() {
        this((String) null, (String) null, (String) null, (Integer) null, (Integer) null, 31, (e) null);
    }

    public static /* synthetic */ ParentFilter copy$default(ParentFilter parentFilter, String str, String str2, String str3, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = parentFilter.className;
        }
        if ((i & 2) != 0) {
            str2 = parentFilter.classNameContains;
        }
        if ((i & 4) != 0) {
            str3 = parentFilter.classNameRegex;
        }
        if ((i & 8) != 0) {
            num = parentFilter.minChildCount;
        }
        if ((i & 16) != 0) {
            num2 = parentFilter.maxChildCount;
        }
        Integer num3 = num2;
        String str4 = str3;
        return parentFilter.copy(str, str2, str4, num, num3);
    }

    public static final /* synthetic */ void write$Self$uxsense_release(ParentFilter self, d output, g serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.className != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, h0.f242a, self.className);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.classNameContains != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, h0.f242a, self.classNameContains);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.classNameRegex != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, h0.f242a, self.classNameRegex);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.minChildCount != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, F.f218a, self.minChildCount);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.maxChildCount == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, F.f218a, self.maxChildCount);
    }

    /* renamed from: component1, reason: from getter */
    public final String getClassName() {
        return this.className;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClassNameContains() {
        return this.classNameContains;
    }

    /* renamed from: component3, reason: from getter */
    public final String getClassNameRegex() {
        return this.classNameRegex;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getMinChildCount() {
        return this.minChildCount;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getMaxChildCount() {
        return this.maxChildCount;
    }

    public final ParentFilter copy(String className, String classNameContains, String classNameRegex, Integer minChildCount, Integer maxChildCount) {
        return new ParentFilter(className, classNameContains, classNameRegex, minChildCount, maxChildCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParentFilter)) {
            return false;
        }
        ParentFilter parentFilter = (ParentFilter) other;
        return k.b(this.className, parentFilter.className) && k.b(this.classNameContains, parentFilter.classNameContains) && k.b(this.classNameRegex, parentFilter.classNameRegex) && k.b(this.minChildCount, parentFilter.minChildCount) && k.b(this.maxChildCount, parentFilter.maxChildCount);
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getClassNameContains() {
        return this.classNameContains;
    }

    public final String getClassNameRegex() {
        return this.classNameRegex;
    }

    public final Integer getMaxChildCount() {
        return this.maxChildCount;
    }

    public final Integer getMinChildCount() {
        return this.minChildCount;
    }

    public int hashCode() {
        String str = this.className;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.classNameContains;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.classNameRegex;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.minChildCount;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.maxChildCount;
        return iHashCode4 + (num2 != null ? num2.hashCode() : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean matches(com.uxsense.core.base.parse.KViewNode r6) {
        /*
            r5 = this;
            java.lang.String r0 = "node"
            kotlin.jvm.internal.k.f(r6, r0)
            java.lang.String r0 = r5.className
            r1 = 0
            if (r0 == 0) goto L15
            java.lang.String r2 = r6.getClassName()
            boolean r0 = kotlin.jvm.internal.k.b(r2, r0)
            if (r0 != 0) goto L15
            goto L60
        L15:
            java.lang.String r0 = r5.classNameContains
            r2 = 1
            if (r0 == 0) goto L26
            java.lang.String r3 = r6.getClassName()
            if (r3 == 0) goto L60
            boolean r0 = j9.m.h0(r3, r0, r1)
            if (r0 != r2) goto L60
        L26:
            java.lang.String r0 = r5.classNameRegex
            if (r0 == 0) goto L3b
            java.lang.String r3 = r6.getClassName()
            if (r3 == 0) goto L60
            kotlin.text.Regex r4 = new kotlin.text.Regex
            r4.<init>(r0)
            boolean r0 = r4.d(r3)
            if (r0 != r2) goto L60
        L3b:
            java.lang.Integer r0 = r5.minChildCount
            if (r0 == 0) goto L4e
            int r0 = r0.intValue()
            java.util.List r3 = r6.getChildren()
            int r3 = r3.size()
            if (r3 >= r0) goto L4e
            goto L60
        L4e:
            java.lang.Integer r5 = r5.maxChildCount
            if (r5 == 0) goto L61
            int r5 = r5.intValue()
            java.util.List r6 = r6.getChildren()
            int r6 = r6.size()
            if (r6 <= r5) goto L61
        L60:
            return r1
        L61:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.pattern.ParentFilter.matches(com.uxsense.core.base.parse.KViewNode):boolean");
    }

    public String toString() {
        return "ParentFilter(className=" + this.className + ", classNameContains=" + this.classNameContains + ", classNameRegex=" + this.classNameRegex + ", minChildCount=" + this.minChildCount + ", maxChildCount=" + this.maxChildCount + ')';
    }

    public /* synthetic */ ParentFilter(int i, String str, String str2, String str3, Integer num, Integer num2, d0 d0Var) {
        if ((i & 1) == 0) {
            this.className = null;
        } else {
            this.className = str;
        }
        if ((i & 2) == 0) {
            this.classNameContains = null;
        } else {
            this.classNameContains = str2;
        }
        if ((i & 4) == 0) {
            this.classNameRegex = null;
        } else {
            this.classNameRegex = str3;
        }
        if ((i & 8) == 0) {
            this.minChildCount = null;
        } else {
            this.minChildCount = num;
        }
        if ((i & 16) == 0) {
            this.maxChildCount = null;
        } else {
            this.maxChildCount = num2;
        }
    }

    public ParentFilter(String str, String str2, String str3, Integer num, Integer num2) {
        this.className = str;
        this.classNameContains = str2;
        this.classNameRegex = str3;
        this.minChildCount = num;
        this.maxChildCount = num2;
    }

    public /* synthetic */ ParentFilter(String str, String str2, String str3, Integer num, Integer num2, int i, e eVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2);
    }
}
