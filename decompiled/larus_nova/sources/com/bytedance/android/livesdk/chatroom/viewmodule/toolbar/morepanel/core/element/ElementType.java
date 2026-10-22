package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element;

import com.larus.network.http.ServiceType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/morepanel/core/element/ElementType;", "", "", "id", "I", "getId", "()I", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Unknown", ServiceType.BASIC_SERVICE, "Extend", "ShareIM", "Toolbar", "SimpleDivider", "BottomSpace", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ElementType extends Enum<ElementType> {
    public static final ElementType Basic = null;
    public static final ElementType BottomSpace = null;
    public static final ElementType Extend = null;
    public static final ElementType ShareIM = null;
    public static final ElementType SimpleDivider = null;
    public static final ElementType Toolbar = null;
    public static final ElementType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ElementType[] f116597a = null;
    private final String desc;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f116598id;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f116599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f116600b = null;

        public a() {
        }

        public final synchronized int a() {
            monitor-enter(this);
            int r100 = f116599a;     // Catch: Throwable -> L6
            int r101 = r100 + 1000;     // Catch: Throwable -> L6
            f116599a = r100 + 1;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r101;
        L6:
            th = move-exception;
            throw th;
        }

        static {
            f116600b = new a();
        }
    }

    static {
        ElementType[] r100 = new ElementType[7];
        ElementType r101 = new ElementType("Unknown", 0, -1998, "未知类型");
        Unknown = r101;
        r100[0] = r101;
        ElementType r102 = new ElementType(ServiceType.BASIC_SERVICE, 1, 1, "基础功能块， 横向可滑动");
        Basic = r102;
        r100[1] = r102;
        ElementType r103 = new ElementType("Extend", 2, 2, "扩展块，横向可滑动");
        Extend = r103;
        r100[2] = r103;
        ElementType r104 = new ElementType("ShareIM", 3, 3, "分享行");
        ShareIM = r104;
        r100[3] = r104;
        a r105 = a.f116600b;
        monitor-enter(r105);
        int r106 = a.f116599a;     // Catch: Throwable -> L8
        int r107 = r106 + 1000;     // Catch: Throwable -> L8
        a.f116599a = r106 + 1;     // Catch: Throwable -> L8
        monitor-exit(r105);
        ElementType r108 = new ElementType("Toolbar", 4, r107, "toolbar区");
        Toolbar = r108;
        r100[4] = r108;
        ElementType r109 = new ElementType("SimpleDivider", 5, r105.a(), "简单的————————————分割线");
        SimpleDivider = r109;
        r100[5] = r109;
        ElementType r110 = new ElementType("BottomSpace", 6, r105.a(), "底部的间距");
        BottomSpace = r110;
        r100[6] = r110;
        f116597a = r100;
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static ElementType valueOf(String r100) {
        return (ElementType) r27.a.a(ElementType.class, r100);
    }

    public static ElementType[] values() {
        return (ElementType[]) f116597a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getId() {
        return this.f116598id;
    }

    public ElementType(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.f116598id = r102;
        this.desc = r103;
    }
}
