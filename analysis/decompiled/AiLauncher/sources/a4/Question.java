package a4;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0014\u0010\rR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u0017\u0010\u001c¨\u0006\u001d"}, d2 = {"La4/y;", "", "", "question", "header", "", "La4/x;", "options", "", "multiSelect", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "c", "Ljava/util/List;", "()Ljava/util/List;", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a4.y, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class Question {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String question;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String header;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<Option> options;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final Boolean multiSelect;

    public Question(String question, String header, List<Option> options, Boolean bool) {
        kotlin.jvm.internal.p.i(question, "question");
        kotlin.jvm.internal.p.i(header, "header");
        kotlin.jvm.internal.p.i(options, "options");
        this.question = question;
        this.header = header;
        this.options = options;
        this.multiSelect = bool;
    }

    /* renamed from: a, reason: from getter */
    public final String getHeader() {
        return this.header;
    }

    /* renamed from: b, reason: from getter */
    public final Boolean getMultiSelect() {
        return this.multiSelect;
    }

    public final List<Option> c() {
        return this.options;
    }

    /* renamed from: d, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Question)) {
            return false;
        }
        Question question = (Question) other;
        return kotlin.jvm.internal.p.d(this.question, question.question) && kotlin.jvm.internal.p.d(this.header, question.header) && kotlin.jvm.internal.p.d(this.options, question.options) && kotlin.jvm.internal.p.d(this.multiSelect, question.multiSelect);
    }

    public int hashCode() {
        int iHashCode = ((((this.question.hashCode() * 31) + this.header.hashCode()) * 31) + this.options.hashCode()) * 31;
        Boolean bool = this.multiSelect;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "Question(question=" + this.question + ", header=" + this.header + ", options=" + this.options + ", multiSelect=" + this.multiSelect + ")";
    }
}
