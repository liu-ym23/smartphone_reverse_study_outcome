package kotlin;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\rR\u001a\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"LK6/f;", "", "", "question", "header", "", "multiSelect", "", "LK6/e;", "options", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "Z", Const.INTENT_KEY_PKGNAME, "()Z", "Ljava/util/List;", "c", "()Ljava/util/List;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.f, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class AskUserQuestion {

    @SerializedName("header")
    private final String header;

    @SerializedName("multiSelect")
    private final boolean multiSelect;

    @SerializedName("options")
    private final List<AskUserOption> options;

    @SerializedName("question")
    private final String question;

    public AskUserQuestion() {
        this(null, null, false, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getHeader() {
        return this.header;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getMultiSelect() {
        return this.multiSelect;
    }

    public final List<AskUserOption> c() {
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
        if (!(other instanceof AskUserQuestion)) {
            return false;
        }
        AskUserQuestion askUserQuestion = (AskUserQuestion) other;
        return p.d(this.question, askUserQuestion.question) && p.d(this.header, askUserQuestion.header) && this.multiSelect == askUserQuestion.multiSelect && p.d(this.options, askUserQuestion.options);
    }

    public int hashCode() {
        return (((((this.question.hashCode() * 31) + this.header.hashCode()) * 31) + Boolean.hashCode(this.multiSelect)) * 31) + this.options.hashCode();
    }

    public String toString() {
        return "AskUserQuestion(question=" + this.question + ", header=" + this.header + ", multiSelect=" + this.multiSelect + ", options=" + this.options + ")";
    }

    public AskUserQuestion(String question, String header, boolean z10, List<AskUserOption> options) {
        p.i(question, "question");
        p.i(header, "header");
        p.i(options, "options");
        this.question = question;
        this.header = header;
        this.multiSelect = z10;
        this.options = options;
    }

    public /* synthetic */ AskUserQuestion(String str, String str2, boolean z10, List list, int i10, i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? C1173v.m() : list);
    }
}
