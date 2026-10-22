package Ca;

import stepai.aios.guiexecutor.input.UserInputRequest;

/* loaded from: classes4.dex */
public final class F extends G {

    /* renamed from: a, reason: collision with root package name */
    public final String f343a;
    public final UserInputRequest b;
    public final String c;

    public F(String str, UserInputRequest userInputRequest, String str2) {
        this.f343a = str;
        this.b = userInputRequest;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof F)) {
            return false;
        }
        F f = (F) obj;
        return kotlin.jvm.internal.k.b(this.f343a, f.f343a) && kotlin.jvm.internal.k.b(this.b, f.b) && kotlin.jvm.internal.k.b(this.c, f.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.f343a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserInputValidationFailed(sessionId=");
        sb.append(this.f343a);
        sb.append(", request=");
        sb.append(this.b);
        sb.append(", errorMessage=");
        return B7.a.q(sb, this.c, ")");
    }
}
