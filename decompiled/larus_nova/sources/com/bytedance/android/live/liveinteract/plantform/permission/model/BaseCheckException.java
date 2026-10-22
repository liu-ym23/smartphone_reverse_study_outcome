package com.bytedance.android.live.liveinteract.plantform.permission.model;

import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\f\b\u0017\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0017B3\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\b\u0010\u0016\u001a\u00020\nH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/permission/model/BaseCheckException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "linkType", "", "operateType", "Lcom/bytedance/android/live/liveinteract/plantform/permission/model/OperateType;", "checkType", "Lcom/bytedance/android/live/liveinteract/plantform/permission/model/BaseCheckException$CheckType;", "detailMessage", "", LynxError.LYNX_THROWABLE, "", "(ILcom/bytedance/android/live/liveinteract/plantform/permission/model/OperateType;Lcom/bytedance/android/live/liveinteract/plantform/permission/model/BaseCheckException$CheckType;Ljava/lang/String;Ljava/lang/Throwable;)V", "getCheckType", "()Lcom/bytedance/android/live/liveinteract/plantform/permission/model/BaseCheckException$CheckType;", "getDetailMessage", "()Ljava/lang/String;", "getLinkType", "()I", "getOperateType", "()Lcom/bytedance/android/live/liveinteract/plantform/permission/model/OperateType;", "toString", "CheckType", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public class BaseCheckException extends RuntimeException {
    private final CheckType checkType;
    private final String detailMessage;
    private final int linkType;
    private final OperateType operateType;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/permission/model/BaseCheckException$CheckType;", "", "", "checkTypeStr", "Ljava/lang/String;", "getCheckTypeStr", "()Ljava/lang/String;", UserChangedCallback.CHANGE_TYPE_LOGIN, "HostOperate", "AndroidPermission", "VideoShortPlugin", "InteractPlugin", "BroadcastPlugin", "ServerPermission", "Shield", "DeviceSupported", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum CheckType extends Enum<CheckType> {
        public static final CheckType AndroidPermission = null;
        public static final CheckType BroadcastPlugin = null;
        public static final CheckType DeviceSupported = null;
        public static final CheckType HostOperate = null;
        public static final CheckType InteractPlugin = null;
        public static final CheckType Login = null;
        public static final CheckType ServerPermission = null;
        public static final CheckType Shield = null;
        public static final CheckType VideoShortPlugin = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CheckType[] f77417a = null;
        private final String checkTypeStr;

        public static CheckType valueOf(String r100) {
            return (CheckType) a.a(CheckType.class, r100);
        }

        public static CheckType[] values() {
            return (CheckType[]) f77417a.clone();
        }

        static {
            CheckType r100 = new CheckType(UserChangedCallback.CHANGE_TYPE_LOGIN, 0, "login");
            Login = r100;
            CheckType r101 = new CheckType("HostOperate", 1, "host_operate");
            HostOperate = r101;
            CheckType r102 = new CheckType("AndroidPermission", 2, "android_permission");
            AndroidPermission = r102;
            CheckType r103 = new CheckType("VideoShortPlugin", 3, "video_short_plugin");
            VideoShortPlugin = r103;
            CheckType r104 = new CheckType("InteractPlugin", 4, IPerformanceManager.MODULE_INTERACT_PLUGIN);
            InteractPlugin = r104;
            CheckType r105 = new CheckType("BroadcastPlugin", 5, "broadcast_plugin");
            BroadcastPlugin = r105;
            CheckType r106 = new CheckType("ServerPermission", 6, "server_permission");
            ServerPermission = r106;
            CheckType r107 = new CheckType("Shield", 7, "shield");
            Shield = r107;
            CheckType r108 = new CheckType("DeviceSupported", 8, "device_supported");
            DeviceSupported = r108;
            f77417a = new CheckType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
        }

        public final String getCheckTypeStr() {
            return this.checkTypeStr;
        }

        public CheckType(String r100, int r101, String r102) {
            super(r100, r101);
            this.checkTypeStr = r102;
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "BaseCheckException(linkType=" + this.linkType + ", operateType=" + this.operateType + ", checkType=" + this.checkType + ", detailMessage='" + this.detailMessage + "')";
    }

    public final CheckType getCheckType() {
        return this.checkType;
    }

    public final String getDetailMessage() {
        return this.detailMessage;
    }

    public final int getLinkType() {
        return this.linkType;
    }

    public final OperateType getOperateType() {
        return this.operateType;
    }

    public BaseCheckException(int r100, OperateType r101, CheckType r102, String r103, Throwable r104) {
        Intrinsics.checkNotNullParameter(r101, "operateType");
        Intrinsics.checkNotNullParameter(r102, "checkType");
        Intrinsics.checkNotNullParameter(r103, "detailMessage");
        super(r103, r104);
        this.linkType = r100;
        this.operateType = r101;
        this.checkType = r102;
        this.detailMessage = r103;
    }

    public /* synthetic */ BaseCheckException(int r100, OperateType r101, CheckType r102, String r110, Throwable r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 16) == 0) goto L5;
        r111 = null;
    L5:
        this(r100, r101, r102, r110, r111);
    }
}
