package rd;

import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.k0;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f23876a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f23877b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f23878c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f23879d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f23880e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map f23881f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f23882g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f23883h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f23884i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f23885j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f23886k = null;

    static {
        f23876a = new c();
        Locale r13 = Locale.CHINA;
        q.f(r13, "CHINA");
        d r10 = new d(r13, new Pair("yyyy年M月d日 H:mm:ss.SSS", "yyyy年M月d日 a h:mm:ss.SSS"), new Pair("yyyy年", "yyyy年"), new Pair("yyyy年M月", "yyyy年M月"), new Pair("yyyy年M月d日", "yyyy年M月d日"), new Pair("M月d日", "M月d日"), new Pair("yyyy年M月d日 H:mm", "yyyy年M月d日 a h:mm"), new Pair("yyyy年M月d日 EEEE H:mm", "yyyy年M月d日 EEEE a h:mm"), new Pair("H:mm", "a h:mm"), new Pair("M/d", "M/d"), new Pair("yyyy/M/d H:mm", "yyyy/M/d a h:mm"));
        f23877b = r10;
        Locale r11 = Locale.UK;
        q.f(r11, "UK");
        d r12 = new d(r11, new Pair("d MMMM yyyy H:mm:ss.SSS", "d MMMM yyyy h:mm:ss.SSS a"), new Pair("yyyy", "yyyy"), new Pair("MMMM yyyy", "MMMM yyyy"), new Pair("d MMMM yyyy", "d MMMM yyyy"), new Pair("d MMMM", "d MMMM"), new Pair("d MMMM yyyy H:mm", "d MMMM yyyy h:mm a"), new Pair("d MMMM yyyy EEEE H:mm", "d MMMM yyyy EEEE h:mm a"), new Pair("H:mm", "h:mm a"), new Pair("d/M", "d/M"), new Pair("d/M/yyyy H:mm", "d/M/yyyy h:mm a"));
        f23878c = r12;
        Locale r14 = Locale.US;
        q.f(r14, "US");
        d r15 = new d(r14, new Pair("MMMM d, yyyy H:mm:ss.SSS", "MMMM d, yyyy h:mm:ss.SSS a"), new Pair("yyyy", "yyyy"), new Pair("MMMM yyyy", "MMMM yyyy"), new Pair("MMMM d, yyyy", "MMMM d, yyyy"), new Pair("MMMM d", "MMMM d"), new Pair("MMMM d, yyyy H:mm", "MMMM d, yyyy h:mm a"), new Pair("MMMM d, yyyy EEEE H:mm", "MMMM d, yyyy EEEE h:mm a"), new Pair("H:mm", "h:mm a"), new Pair("M/d", "M/d"), new Pair("M/d/yyyy H:mm", "M/d/yyyy h:mm a"));
        f23879d = r15;
        Locale r16 = Locale.TRADITIONAL_CHINESE;
        q.f(r16, "TRADITIONAL_CHINESE");
        d r17 = new d(r16, new Pair("yyyy年M月d日 H:mm:ss.SSS", "yyyy年M月d日 a h:mm:ss.SSS"), new Pair("yyyy年", "yyyy年"), new Pair("yyyy年M月", "yyyy年M月"), new Pair("yyyy年M月d日", "yyyy年M月d日"), new Pair("M月d日", "M月d日"), new Pair("yyyy年M月d日 H:mm", "yyyy年M月d日 a h:mm"), new Pair("yyyy年M月d日 EEEE H:mm", "yyyy年M月d日 EEEE a h:mm"), new Pair("H:mm", "a h:mm"), new Pair("M/d", "M/d"), new Pair("yyyy/M/d H:mm", "yyyy/M/d a h:mm"));
        f23880e = r17;
        f23881f = k0.j(new Pair[]{kotlin.d.a(r13, r10), kotlin.d.a(r16, r17), kotlin.d.a(r11, r12), kotlin.d.a(r14, r15)});
        f23882g = new a("刚刚", new Pair("H:mm", "a h:mm"), "今天", "昨天", "明天", "前天", "后天", "EEEE", "M月d日", "yyyy年M月d日", "yyyy/M/d", "%d 秒前", "%d 秒后", "%d 分钟前", "%d 分钟后", "%d 小时前", "%d 小时后", "%d 天前", "%d 天后", "%d 个月前", "%d 个月后", "%d 年前", "%d 年后");
        f23883h = new a("Just now", new Pair("H:mm", "h:mm a"), "today", "Yesterday", "Tomorrow", "Before yesterday", "After tomorrow", "EEEE", "MMMM d", "MMMM d, yyyy", "M/d/yyyy", "%d seconds ago", "%d seconds from now", "%d minutes ago", "%d minutes from now", "%d hours ago", "%d hours from now", "%d days ago", "%d days from now", "%d months ago", "%d months from now", "%d years ago", "%d years from now");
        f23884i = new a("Just now", new Pair("H:mm", "h:mm a"), "today", "Yesterday", "Tomorrow", "Before yesterday", "After tomorrow", "EEEE", "d MMMM", "d MMMM, yyyy", "d/M/yyyy", "%d seconds ago", "%d seconds from now", "%d minutes ago", "%d minutes from now", "%d hours ago", "%d hours from now", "%d days ago", "%d days from now", "%d months ago", "%d months from now", "%d years ago", "%d years from now");
        f23885j = new a("剛剛", new Pair("H:mm", "a h:mm"), "今天", "昨天", "明天", "前天", "後天", "EEEE", "M月d日", "yyyy年M月d日", "yyyy/M/d", "%d 秒前", "%d 秒後", "%d 分鐘前", "%d 分鐘後", "%d 小時前", "%d 小時後", "%d 天前", "%d 天後", "%d 個月前", "%d 個月後", "%d 年前", "%d 年後");
        f23886k = new a("剛剛", new Pair("H:mm", "a h:mm"), "今日", "昨日", "明日", "前日", "後日", "EEEE", "M月d日", "yyyy年M月d日", "yyyy/M/d", "%d 秒前", "%d 秒後", "%d 分鐘前", "%d 分鐘後", "%d 小時前", "%d 小時後", "%d 日前", "%d 日後", "%d 個月前", "%d 個月後", "%d 年前", "%d 年後");
    }

    public c() {
    }

    public final d a(Locale r10) {
        q.g(r10, "locale");
        if (q.b(r10, Locale.CHINA) == false) goto L6;
        return f23877b;
    L6:
        if (q.b(r10, Locale.TAIWAN) == false) goto L9;
        return f23880e;
    L9:
        if (q.b(r10, Locale.UK) == false) goto L12;
        return f23878c;
    L12:
        if (q.b(r10, Locale.US) == false) goto L15;
        return f23879d;
    L15:
        if (q.b(r10.getCountry(), "HK") == false) goto L18;
        return f23880e;
    L18:
        return f23879d;
    }
}
