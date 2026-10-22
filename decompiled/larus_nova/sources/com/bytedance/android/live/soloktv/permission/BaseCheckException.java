package com.bytedance.android.live.soloktv.permission;

import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u000fB\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/soloktv/permission/BaseCheckException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "checkType", "Lcom/bytedance/android/live/soloktv/permission/BaseCheckException$CheckType;", "detailMessage", "", "(Lcom/bytedance/android/live/soloktv/permission/BaseCheckException$CheckType;Ljava/lang/String;)V", LynxError.LYNX_THROWABLE, "", "(Lcom/bytedance/android/live/soloktv/permission/BaseCheckException$CheckType;Ljava/lang/String;Ljava/lang/Throwable;)V", "getCheckType", "()Lcom/bytedance/android/live/soloktv/permission/BaseCheckException$CheckType;", "getDetailMessage", "()Ljava/lang/String;", "CheckType", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class BaseCheckException extends RuntimeException {
    private final CheckType checkType;
    private final String detailMessage;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/soloktv/permission/BaseCheckException$CheckType;", "", "AndroidPermission", "BluetoothPermission", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum CheckType extends Enum<CheckType> {
        public static final CheckType AndroidPermission = null;
        public static final CheckType BluetoothPermission = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CheckType[] f101425a = null;

        static {
            CheckType r100 = new CheckType("AndroidPermission", 0);
            AndroidPermission = r100;
            CheckType r101 = new CheckType("BluetoothPermission", 1);
            BluetoothPermission = r101;
            f101425a = new CheckType[]{r100, r101};
        }

        public static CheckType valueOf(String r100) {
            return (CheckType) a.a(CheckType.class, r100);
        }

        public static CheckType[] values() {
            return (CheckType[]) f101425a.clone();
        }

        public CheckType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final CheckType getCheckType() {
        return this.checkType;
    }

    public final String getDetailMessage() {
        return this.detailMessage;
    }

    public BaseCheckException(CheckType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "checkType");
        Intrinsics.checkNotNullParameter(r101, "detailMessage");
        super(r101);
        this.checkType = r100;
        this.detailMessage = r101;
    }

    public BaseCheckException(CheckType r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "checkType");
        Intrinsics.checkNotNullParameter(r101, "detailMessage");
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
        super(r101, r102);
        this.checkType = r100;
        this.detailMessage = r101;
    }
}
