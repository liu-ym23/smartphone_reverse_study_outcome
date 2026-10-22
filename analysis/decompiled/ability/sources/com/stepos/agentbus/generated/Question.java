package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012J>\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/stepos/agentbus/generated/Question;", "", "question", "", "header", "options", "", "Lcom/stepos/agentbus/generated/Option;", "multiSelect", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "getQuestion", "()Ljava/lang/String;", "getHeader", "getOptions", "()Ljava/util/List;", "getMultiSelect", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)Lcom/stepos/agentbus/generated/Question;", "equals", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Question {
    private final String header;
    private final Boolean multiSelect;
    private final List<Option> options;
    private final String question;

    public Question(String question, String header, List<Option> options, Boolean bool) {
        k.f(question, "question");
        k.f(header, "header");
        k.f(options, "options");
        this.question = question;
        this.header = header;
        this.options = options;
        this.multiSelect = bool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Question copy$default(Question question, String str, String str2, List list, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = question.question;
        }
        if ((i & 2) != 0) {
            str2 = question.header;
        }
        if ((i & 4) != 0) {
            list = question.options;
        }
        if ((i & 8) != 0) {
            bool = question.multiSelect;
        }
        return question.copy(str, str2, list, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHeader() {
        return this.header;
    }

    public final List<Option> component3() {
        return this.options;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getMultiSelect() {
        return this.multiSelect;
    }

    public final Question copy(String question, String header, List<Option> options, Boolean multiSelect) {
        k.f(question, "question");
        k.f(header, "header");
        k.f(options, "options");
        return new Question(question, header, options, multiSelect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Question)) {
            return false;
        }
        Question question = (Question) other;
        return k.b(this.question, question.question) && k.b(this.header, question.header) && k.b(this.options, question.options) && k.b(this.multiSelect, question.multiSelect);
    }

    public final String getHeader() {
        return this.header;
    }

    public final Boolean getMultiSelect() {
        return this.multiSelect;
    }

    public final List<Option> getOptions() {
        return this.options;
    }

    public final String getQuestion() {
        return this.question;
    }

    public int hashCode() {
        int iE = androidx.appfunctions.metadata.a.e(this.options, B7.a.c(this.question.hashCode() * 31, 31, this.header), 31);
        Boolean bool = this.multiSelect;
        return iE + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        String str = this.question;
        String str2 = this.header;
        List<Option> list = this.options;
        Boolean bool = this.multiSelect;
        StringBuilder sbW = B7.a.w("Question(question=", str, ", header=", str2, ", options=");
        sbW.append(list);
        sbW.append(", multiSelect=");
        sbW.append(bool);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ Question(String str, String str2, List list, Boolean bool, int i, e eVar) {
        this(str, str2, list, (i & 8) != 0 ? null : bool);
    }
}
