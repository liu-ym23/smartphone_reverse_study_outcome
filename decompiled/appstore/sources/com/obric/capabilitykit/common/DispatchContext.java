package com.obric.capabilitykit.common;

import android.content.Context;
import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J<\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/common/DispatchContext;", "", "context", "Landroid/content/Context;", "questionId", "", "ext", "", "", "(Landroid/content/Context;Ljava/lang/Long;Ljava/util/Map;)V", "getContext", "()Landroid/content/Context;", "getExt", "()Ljava/util/Map;", "getQuestionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Landroid/content/Context;Ljava/lang/Long;Ljava/util/Map;)Lcom/obric/capabilitykit/common/DispatchContext;", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DispatchContext {

    @NotNull
    private final Context context;

    @Nullable
    private final Map<String, String> ext;

    @Nullable
    private final Long questionId;

    public DispatchContext(@NotNull Context r10, @Nullable Long r11, @Nullable Map<String, String> r12) {
        kotlin.jvm.internal.q.g(r10, "context");
        this.context = r10;
        this.questionId = r11;
        this.ext = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DispatchContext copy$default(DispatchContext r10, Context r11, Long r12, Map r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.context;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.questionId;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.ext;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @NotNull
    public final Context component1() {
        return this.context;
    }

    @Nullable
    public final Long component2() {
        return this.questionId;
    }

    @Nullable
    public final Map<String, String> component3() {
        return this.ext;
    }

    @NotNull
    public final DispatchContext copy(@NotNull Context r10, @Nullable Long r11, @Nullable Map<String, String> r12) {
        kotlin.jvm.internal.q.g(r10, "context");
        return new DispatchContext(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof DispatchContext) == true) goto L8;
        return false;
    L8:
        DispatchContext r11 = (DispatchContext) r10;
        if (kotlin.jvm.internal.q.b(this.context, r11.context) == true) goto L12;
        return false;
    L12:
        if (kotlin.jvm.internal.q.b(this.questionId, r11.questionId) == true) goto L15;
        return false;
    L15:
        if (kotlin.jvm.internal.q.b(this.ext, r11.ext) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final Map<String, String> getExt() {
        return this.ext;
    }

    @Nullable
    public final Long getQuestionId() {
        return this.questionId;
    }

    public int hashCode() {
        int r10 = this.context.hashCode() * 31;
        Long r11 = this.questionId;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        Map<String, String> r15 = this.ext;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        return r14 + r12;
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "DispatchContext(context=" + this.context + ", questionId=" + this.questionId + ", ext=" + this.ext + ')';
    }

    public /* synthetic */ DispatchContext(Context r10, Long r11, Map r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        this(r10, r11, r12);
    }
}
