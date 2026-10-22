package com.uxsense.ruleTrigger.model;

import C7.r;
import C9.AbstractC0200b;
import C9.g;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.task.executor.e;
import com.uxsense.core.pattern.ParentFilter;
import com.uxsense.core.pattern.ViewPattern;
import com.uxsense.parse.b;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/uxsense/ruleTrigger/model/ViewPatternSerializer;", "", AppAgent.CONSTRUCT, "()V", "Lcom/uxsense/core/pattern/ViewPattern;", "viewPattern", "", "serializeViewPattern", "(Lcom/uxsense/core/pattern/ViewPattern;)Ljava/lang/String;", "jsonString", "deserializeViewPattern", "(Ljava/lang/String;)Lcom/uxsense/core/pattern/ViewPattern;", "Lcom/uxsense/core/pattern/ParentFilter;", "parentFilter", "serializeParentFilter", "(Lcom/uxsense/core/pattern/ParentFilter;)Ljava/lang/String;", "deserializeParentFilter", "(Ljava/lang/String;)Lcom/uxsense/core/pattern/ParentFilter;", "LC9/b;", "json", "LC9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewPatternSerializer {
    public static final ViewPatternSerializer INSTANCE = new ViewPatternSerializer();
    private static final AbstractC0200b json = e.b(new b(4));

    private ViewPatternSerializer() {
    }

    public static final ParentFilter deserializeParentFilter(String jsonString) {
        if (jsonString != null && jsonString.length() != 0) {
            try {
                AbstractC0200b abstractC0200b = json;
                abstractC0200b.getClass();
                return (ParentFilter) abstractC0200b.a(ParentFilter.INSTANCE.serializer(), jsonString);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static final ViewPattern deserializeViewPattern(String jsonString) {
        if (jsonString != null && jsonString.length() != 0) {
            try {
                AbstractC0200b abstractC0200b = json;
                abstractC0200b.getClass();
                return (ViewPattern) abstractC0200b.a(ViewPattern.INSTANCE.serializer(), jsonString);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r json$lambda$0(g Json) {
        k.f(Json, "$this$Json");
        Json.c = true;
        Json.d = true;
        Json.f325a = false;
        return r.f317a;
    }

    public static final String serializeParentFilter(ParentFilter parentFilter) {
        if (parentFilter == null) {
            return null;
        }
        try {
            AbstractC0200b abstractC0200b = json;
            abstractC0200b.getClass();
            return abstractC0200b.b(ParentFilter.INSTANCE.serializer(), parentFilter);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String serializeViewPattern(ViewPattern viewPattern) {
        if (viewPattern == null) {
            return null;
        }
        try {
            AbstractC0200b abstractC0200b = json;
            abstractC0200b.getClass();
            return abstractC0200b.b(ViewPattern.INSTANCE.serializer(), viewPattern);
        } catch (Exception unused) {
            return null;
        }
    }
}
