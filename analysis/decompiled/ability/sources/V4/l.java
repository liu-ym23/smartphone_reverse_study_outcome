package V4;

import java.util.List;

/* loaded from: classes3.dex */
public final class l extends j {
    public List c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public int h;
    public String i;

    /* renamed from: j, reason: collision with root package name */
    public String f1370j;

    public final String toString() {
        List list = this.c;
        String str = this.d;
        String str2 = this.e;
        String str3 = this.f;
        boolean z10 = this.g;
        int i = this.h;
        StringBuilder sb = new StringBuilder("ChatRequestInfo(content='");
        sb.append(list);
        sb.append("', role='");
        sb.append(str);
        sb.append("', conversationId=");
        androidx.constraintlayout.core.dsl.a.A(sb, str2, ", contentType=", str3, ", transferState=0, stream=");
        sb.append(z10);
        sb.append(", extra=null, _id=");
        sb.append(i);
        sb.append(", uid=null, customVariables=null)");
        return sb.toString();
    }
}
