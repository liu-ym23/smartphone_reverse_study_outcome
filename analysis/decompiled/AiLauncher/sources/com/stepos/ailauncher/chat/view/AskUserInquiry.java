package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/view/S;", "", "", "question", "", "choices", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.S, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class AskUserInquiry {
    private final List<String> choices;
    private final String question;

    public AskUserInquiry(String question, List<String> choices) {
        kotlin.jvm.internal.p.i(question, "question");
        kotlin.jvm.internal.p.i(choices, "choices");
        this.question = question;
        this.choices = choices;
    }

    public final List<String> a() {
        return this.choices;
    }

    /* renamed from: b, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AskUserInquiry)) {
            return false;
        }
        AskUserInquiry askUserInquiry = (AskUserInquiry) other;
        return kotlin.jvm.internal.p.d(this.question, askUserInquiry.question) && kotlin.jvm.internal.p.d(this.choices, askUserInquiry.choices);
    }

    public int hashCode() {
        return (this.question.hashCode() * 31) + this.choices.hashCode();
    }

    public String toString() {
        return "AskUserInquiry(question=" + this.question + ", choices=" + this.choices + ")";
    }
}
