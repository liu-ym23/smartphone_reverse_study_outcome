package a9b;

import com.bytedance.lark.pb.basic.v1.UserInfo;
import com.bytedance.lark.pb.contact.v2.UserContactStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f2302c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UserInfo f2303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UserContactStatus f2304b;

    /* JADX INFO: renamed from: a9b.a$a, reason: collision with other inner class name */
    public static final class C0033a {
    }

    static {
    }

    public a() {
    }

    public final UserInfo a() {
        UserInfo r100 = this.f2303a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("userInfo");
        return null;
    }
}
