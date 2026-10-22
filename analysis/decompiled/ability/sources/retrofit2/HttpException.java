package retrofit2;

import F9.M;
import qa.L;

/* loaded from: classes4.dex */
public class HttpException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final int f5969a;
    public final String b;

    public HttpException(L l) {
        StringBuilder sb = new StringBuilder("HTTP ");
        M m = l.f5644a;
        int i = m.d;
        sb.append(i);
        sb.append(" ");
        String str = m.c;
        sb.append(str);
        super(sb.toString());
        this.f5969a = i;
        this.b = str;
    }
}
