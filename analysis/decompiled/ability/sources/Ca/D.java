package Ca;

import stepai.aios.guiexecutor.input.UserInputRequest;

/* loaded from: classes4.dex */
public final class D extends G {

    /* renamed from: a, reason: collision with root package name */
    public final String f341a;
    public final UserInputRequest b;

    public D(String str, UserInputRequest userInputRequest) {
        this.f341a = str;
        this.b = userInputRequest;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        D d = (D) obj;
        return kotlin.jvm.internal.k.b(this.f341a, d.f341a) && kotlin.jvm.internal.k.b(this.b, d.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f341a.hashCode() * 31);
    }

    public final String toString() {
        return "UserInputRequested(sessionId=" + this.f341a + ", request=" + this.b + ")";
    }
}
