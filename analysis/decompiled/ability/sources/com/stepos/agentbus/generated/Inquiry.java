package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentbus/generated/Inquiry;", "", "question", "", "choices", "", "allowMultiple", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/List;Z)V", "getQuestion", "()Ljava/lang/String;", "getChoices", "()Ljava/util/List;", "getAllowMultiple", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Inquiry {
    private final boolean allowMultiple;
    private final List<String> choices;
    private final String question;

    public Inquiry(String str, List list, boolean z10, int i, e eVar) {
        this(str, (i & 2) != 0 ? EmptyList.f4893a : list, (i & 4) != 0 ? false : z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Inquiry copy$default(Inquiry inquiry, String str, List list, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inquiry.question;
        }
        if ((i & 2) != 0) {
            list = inquiry.choices;
        }
        if ((i & 4) != 0) {
            z10 = inquiry.allowMultiple;
        }
        return inquiry.copy(str, list, z10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    public final List<String> component2() {
        return this.choices;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAllowMultiple() {
        return this.allowMultiple;
    }

    public final Inquiry copy(String question, List<String> choices, boolean allowMultiple) {
        k.f(question, "question");
        k.f(choices, "choices");
        return new Inquiry(question, choices, allowMultiple);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Inquiry)) {
            return false;
        }
        Inquiry inquiry = (Inquiry) other;
        return k.b(this.question, inquiry.question) && k.b(this.choices, inquiry.choices) && this.allowMultiple == inquiry.allowMultiple;
    }

    public final boolean getAllowMultiple() {
        return this.allowMultiple;
    }

    public final List<String> getChoices() {
        return this.choices;
    }

    public final String getQuestion() {
        return this.question;
    }

    public int hashCode() {
        return Boolean.hashCode(this.allowMultiple) + androidx.appfunctions.metadata.a.e(this.choices, this.question.hashCode() * 31, 31);
    }

    public String toString() {
        String str = this.question;
        List<String> list = this.choices;
        boolean z10 = this.allowMultiple;
        StringBuilder sb = new StringBuilder("Inquiry(question=");
        sb.append(str);
        sb.append(", choices=");
        sb.append(list);
        sb.append(", allowMultiple=");
        return B7.a.s(sb, z10, ")");
    }

    public Inquiry(String question, List<String> choices, boolean z10) {
        k.f(question, "question");
        k.f(choices, "choices");
        this.question = question;
        this.choices = choices;
        this.allowMultiple = z10;
    }
}
