package e4;

import com.bytedance.common.wschannel.converter.MsgConverter;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static MsgConverter f19288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static MsgConverter f19289b;

    static {
        b r10 = new b();
        f19288a = r10;
        f19289b = r10;
    }

    public static MsgConverter a() {
        return f19289b;
    }
}
