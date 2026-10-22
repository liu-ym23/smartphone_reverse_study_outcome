package K4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.uikit.code.CodeTokenKind;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"LK4/c;", "", "", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "Lcom/stepos/agentframework/uikit/code/CodeTokenKind;", "kind", "<init>", "(IILcom/stepos/agentframework/uikit/code/CodeTokenKind;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "c", Const.INTENT_KEY_APIKEY, "Lcom/stepos/agentframework/uikit/code/CodeTokenKind;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/uikit/code/CodeTokenKind;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K4.c, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class CodeToken {
    private final int end;
    private final CodeTokenKind kind;
    private final int start;

    public CodeToken(int i10, int i11, CodeTokenKind kind) {
        p.i(kind, "kind");
        this.start = i10;
        this.end = i11;
        this.kind = kind;
    }

    /* renamed from: a, reason: from getter */
    public final int getEnd() {
        return this.end;
    }

    /* renamed from: b, reason: from getter */
    public final CodeTokenKind getKind() {
        return this.kind;
    }

    /* renamed from: c, reason: from getter */
    public final int getStart() {
        return this.start;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CodeToken)) {
            return false;
        }
        CodeToken codeToken = (CodeToken) other;
        return this.start == codeToken.start && this.end == codeToken.end && this.kind == codeToken.kind;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.start) * 31) + Integer.hashCode(this.end)) * 31) + this.kind.hashCode();
    }

    public String toString() {
        return "CodeToken(start=" + this.start + ", end=" + this.end + ", kind=" + this.kind + ")";
    }
}
