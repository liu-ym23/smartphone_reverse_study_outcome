package com.bytedance.android.ec.host.api.info;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u0000 \t2\u00020\u0001:\u0001\nJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/host/api/info/IECHostDeviceInfoService;", "", "", "isFoldDevice", "()Ljava/lang/Boolean;", "", "getFoldStatus", "()Ljava/lang/Integer;", "getFoldType", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECHostDeviceInfoService {
    public static final a Companion = null;
    public static final int FOLD_STATUS_UNKNOWN = 0;
    public static final int FOLD_TYPE_UNKNOWN = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f46179a = null;

        public a() {
        }

        static {
            f46179a = new a();
        }
    }

    static {
        Companion = a.f46179a;
    }

    Integer getFoldStatus();

    Integer getFoldType();

    Boolean isFoldDevice();
}
