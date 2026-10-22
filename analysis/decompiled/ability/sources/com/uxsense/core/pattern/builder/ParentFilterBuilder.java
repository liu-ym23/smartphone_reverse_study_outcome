package com.uxsense.core.pattern.builder;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.uxsense.core.dsl.ViewPatternDsl;
import com.uxsense.core.pattern.ParentFilter;
import kotlin.Metadata;

@ViewPatternDsl
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001a\u001a\u00020\u001bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/uxsense/core/pattern/builder/ParentFilterBuilder;", "", AppAgent.CONSTRUCT, "()V", "className", "", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "classNameContains", "getClassNameContains", "setClassNameContains", "classNameRegex", "getClassNameRegex", "setClassNameRegex", "minChildCount", "", "getMinChildCount", "()Ljava/lang/Integer;", "setMinChildCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "maxChildCount", "getMaxChildCount", "setMaxChildCount", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/uxsense/core/pattern/ParentFilter;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ParentFilterBuilder {
    private String className;
    private String classNameContains;
    private String classNameRegex;
    private Integer maxChildCount;
    private Integer minChildCount;

    public final ParentFilter build() {
        return new ParentFilter(this.className, this.classNameContains, this.classNameRegex, this.minChildCount, this.maxChildCount);
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

    public final void setClassName(String str) {
        this.className = str;
    }

    public final void setClassNameContains(String str) {
        this.classNameContains = str;
    }

    public final void setClassNameRegex(String str) {
        this.classNameRegex = str;
    }

    public final void setMaxChildCount(Integer num) {
        this.maxChildCount = num;
    }

    public final void setMinChildCount(Integer num) {
        this.minChildCount = num;
    }
}
