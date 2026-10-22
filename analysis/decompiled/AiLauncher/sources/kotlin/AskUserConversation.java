package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R.\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\f¨\u0006\u001e"}, d2 = {"LK6/d;", "", "", "LK6/f;", "questions", "", "", "answers", "questionsJson", "<init>", "(Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "Ljava/util/Map;", Const.INTENT_KEY_APIKEY, "()Ljava/util/Map;", Const.INTENT_KEY_UMID, "(Ljava/util/Map;)V", "Ljava/lang/String;", "c", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.d, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class AskUserConversation {
    private Map<String, String> answers;
    private final List<AskUserQuestion> questions;
    private final String questionsJson;

    public AskUserConversation(List<AskUserQuestion> questions, Map<String, String> answers, String str) {
        p.i(questions, "questions");
        p.i(answers, "answers");
        this.questions = questions;
        this.answers = answers;
        this.questionsJson = str;
    }

    public final Map<String, String> a() {
        return this.answers;
    }

    public final List<AskUserQuestion> b() {
        return this.questions;
    }

    /* renamed from: c, reason: from getter */
    public final String getQuestionsJson() {
        return this.questionsJson;
    }

    public final void d(Map<String, String> map) {
        p.i(map, "<set-?>");
        this.answers = map;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AskUserConversation)) {
            return false;
        }
        AskUserConversation askUserConversation = (AskUserConversation) other;
        return p.d(this.questions, askUserConversation.questions) && p.d(this.answers, askUserConversation.answers) && p.d(this.questionsJson, askUserConversation.questionsJson);
    }

    public int hashCode() {
        int iHashCode = ((this.questions.hashCode() * 31) + this.answers.hashCode()) * 31;
        String str = this.questionsJson;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "AskUserConversation(questions=" + this.questions + ", answers=" + this.answers + ", questionsJson=" + this.questionsJson + ")";
    }
}
