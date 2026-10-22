package U3;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\tB!\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\n\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0001\u0011¨\u0006\u0012"}, d2 = {"LU3/a;", "", "", "code", "msg", "", "numericCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "()Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", "I", "getNumericCode", "()I", "LU3/a$a;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String code;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String msg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int numericCode;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\tB!\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u0082\u0001\u0001\n¨\u0006\u000b"}, d2 = {"LU3/a$a;", "LU3/a;", "", "code", "msg", "", "numericCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", Const.INTENT_KEY_APIKEY, "LU3/a$a$a;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: U3.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0107a extends a {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"LU3/a$a$a;", "LU3/a$a;", "<init>", "()V", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: U3.a$a$a, reason: collision with other inner class name */
        public static final class C0108a extends AbstractC0107a {

            /* renamed from: d, reason: collision with root package name */
            public static final C0108a f6290d = new C0108a();

            public C0108a() {
                super("META_INFO_QUERY_FAILED", "元信息查询失败", 30004, null);
            }
        }

        public /* synthetic */ AbstractC0107a(String str, String str2, int i10, i iVar) {
            this(str, str2, i10);
        }

        public AbstractC0107a(String str, String str2, int i10) {
            super(str, str2, i10, null);
        }
    }

    public /* synthetic */ a(String str, String str2, int i10, i iVar) {
        this(str, str2, i10);
    }

    /* renamed from: a, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: b, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public a(String str, String str2, int i10) {
        this.code = str;
        this.msg = str2;
        this.numericCode = i10;
    }
}
