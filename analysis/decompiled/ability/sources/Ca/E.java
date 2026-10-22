package Ca;

import stepai.aios.guiexecutor.input.UserInputRequest;

/* loaded from: classes4.dex */
public final class E extends G {

    /* renamed from: a, reason: collision with root package name */
    public final String f342a;
    public final UserInputRequest b;

    public E(String str, UserInputRequest userInputRequest) {
        this.f342a = str;
        this.b = userInputRequest;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof E)) {
            return false;
        }
        E e = (E) obj;
        return kotlin.jvm.internal.k.b(this.f342a, e.f342a) && kotlin.jvm.internal.k.b(this.b, e.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f342a.hashCode() * 31);
    }

    public final String toString() {
        return "UserInputTimeout(sessionId=" + this.f342a + ", request=" + this.b + ")";
    }
}
