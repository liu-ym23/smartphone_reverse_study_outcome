package V4;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.stepos.common.FunctionCall;
import com.stepos.common.LikeState;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class k extends j {
    public List c;
    public final String d;
    public final String e;
    public final String f;
    public final boolean g;
    public final Map h;
    public final long i;

    /* renamed from: j, reason: collision with root package name */
    public final int f1365j;
    public String k;
    public final int l;
    public final boolean m;
    public final String n;
    public final Integer o;
    public final Integer p;

    /* renamed from: q, reason: collision with root package name */
    public final LikeState f1366q;

    /* renamed from: r, reason: collision with root package name */
    public final String f1367r;

    /* renamed from: s, reason: collision with root package name */
    public final String f1368s;

    /* renamed from: t, reason: collision with root package name */
    public final String f1369t;

    public k(List list, String str, String str2, String str3, Map map, String str4, String str5, int i, boolean z10, Integer num, Integer num2, String str6, String str7, FunctionCall functionCall, int i6) {
        list = (i6 & 1) != 0 ? null : list;
        Map map2 = (i6 & 64) != 0 ? null : map;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String agentId = (i6 & 8192) != 0 ? "" : str4;
        String secretkey = (i6 & 16384) != 0 ? "" : str5;
        Integer num3 = (1048576 & i6) != 0 ? null : num;
        LikeState likeState = LikeState.f3542a;
        String str8 = (i6 & BasicMeasure.EXACTLY) == 0 ? str7 : null;
        kotlin.jvm.internal.k.f(agentId, "agentId");
        kotlin.jvm.internal.k.f(secretkey, "secretkey");
        this.c = list;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = true;
        this.h = map2;
        this.i = jCurrentTimeMillis;
        this.f1365j = 1;
        this.k = agentId;
        this.l = i;
        this.m = z10;
        this.n = "";
        this.o = num3;
        this.p = num2;
        this.f1366q = likeState;
        this.f1367r = "normal";
        this.f1368s = str6;
        this.f1369t = str8;
    }

    public final String toString() {
        List list = this.c;
        String str = this.k;
        StringBuilder sb = new StringBuilder("ChatReplyInfo(content='");
        sb.append(list);
        sb.append("', role='");
        sb.append(this.d);
        sb.append("', messageId=");
        androidx.constraintlayout.core.dsl.a.A(sb, this.f1368s, ", originMessageId=", this.f1369t, ", conversationId=");
        androidx.constraintlayout.core.dsl.a.A(sb, this.e, ", contentType=", this.f, ", transferState=0, stream=");
        sb.append(this.g);
        sb.append(", extra=");
        sb.append(this.h);
        sb.append(",  _id=0, uid=null, time=");
        sb.append(this.i);
        sb.append(", chatState=");
        sb.append(this.f1365j);
        sb.append(", contentId=0, agentId='");
        sb.append(str);
        sb.append("', platform=");
        sb.append(this.l);
        sb.append(", isFinish=");
        sb.append(this.m);
        sb.append(", type='");
        sb.append(this.n);
        sb.append("', seqId=0, requestId=");
        sb.append(this.o);
        sb.append(", index=0, failCode=null, event=");
        sb.append(this.p);
        sb.append(", likeState=");
        sb.append(this.f1366q);
        sb.append(", serverId=null, chatType=");
        sb.append(this.f1367r);
        sb.append(")");
        return sb.toString();
    }
}
