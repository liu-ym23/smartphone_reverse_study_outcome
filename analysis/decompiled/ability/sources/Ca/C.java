package Ca;

import stepai.aios.guiexecutor.input.UserInputRequest;

/* loaded from: classes4.dex */
public final class C extends G {

    /* renamed from: a, reason: collision with root package name */
    public final String f340a;
    public final UserInputRequest b;
    public final String c;

    public C(String str, UserInputRequest userInputRequest, String str2) {
        this.f340a = str;
        this.b = userInputRequest;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C)) {
            return false;
        }
        C c = (C) obj;
        return kotlin.jvm.internal.k.b(this.f340a, c.f340a) && kotlin.jvm.internal.k.b(this.b, c.b) && kotlin.jvm.internal.k.b(this.c, c.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.f340a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserInputCancelled(sessionId=");
        sb.append(this.f340a);
        sb.append(", request=");
        sb.append(this.b);
        sb.append(", reason=");
        return B7.a.q(sb, this.c, ")");
    }
}
