package ao0;

import com.bytedance.android.live.api.exceptions.local.ApiLocalException;
import com.bytedance.android.live.api.exceptions.local.ResponseNoDataException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdkapi.ILiveResponseExtraInfo;
import com.bytedance.android.livesdkapi.ILiveResponseExtraInfoParser;
import com.bytedance.retrofit2.SsResponse;
import com.lynx.tasm.LynxError;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements ILiveResponseExtraInfoParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Class<?>> f15703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Class<? extends Throwable>> f15704b;

    public static final class a implements ILiveResponseExtraInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f15705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f15706b;

        @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfo
        public final long getServerTimestamp() {
            return ((BaseResponse) this.f15706b).extra.now;
        }

        @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfo
        public final ILiveResponseExtraInfo.IStatusInfo getStatusInfo() {
            e r100 = this.f15705a;
            int r101 = ((BaseResponse) this.f15706b).statusCode;
            r100.getClass();
            return new ao0.a(r101, "", "");
        }

        public a(e r100, Object r101) {
            this.f15705a = r100;
            this.f15706b = r101;
        }
    }

    public static final class b implements ILiveResponseExtraInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f15707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f15708b;

        @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfo
        public final long getServerTimestamp() {
            return ((BaseListResponse) this.f15708b).extra.now;
        }

        @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfo
        public final ILiveResponseExtraInfo.IStatusInfo getStatusInfo() {
            e r100 = this.f15707a;
            int r101 = ((BaseListResponse) this.f15708b).statusCode;
            r100.getClass();
            return new ao0.a(r101, "", "");
        }

        public b(e r100, Object r101) {
            this.f15707a = r100;
            this.f15708b = r101;
        }
    }

    public static final class c implements ILiveResponseExtraInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f15709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f15710b;

        @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfo
        public final long getServerTimestamp() {
            return ((com.bytedance.android.live.network.response.c) this.f15710b).a().now;
        }

        @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfo
        public final ILiveResponseExtraInfo.IStatusInfo getStatusInfo() {
            e r100 = this.f15709a;
            int r101 = ((com.bytedance.android.live.network.response.c) this.f15710b).getStatusCode();
            String r102 = ((com.bytedance.android.live.network.response.c) this.f15710b).getError().message;
            String r103 = ((com.bytedance.android.live.network.response.c) this.f15710b).getError().prompts;
            r100.getClass();
            return new ao0.a(r101, r102, r103);
        }

        public c(e r100, Object r101) {
            this.f15709a = r100;
            this.f15710b = r101;
        }
    }

    public e() {
        this.f15703a = SetsKt.mutableSetOf(new Class[]{ExtraResponse.class, BaseResponse.class, BaseListResponse.class});
        this.f15704b = SetsKt.mutableSetOf(new Class[]{ApiLocalException.class, ApiServerException.class});
    }

    @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfoParser
    public final Set<Class<?>> getTargetResponseTypes() {
        return this.f15703a;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfoParser
    public final Set<Class<? extends Throwable>> getTargetThrowableTypes() {
        return this.f15704b;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfoParser
    public final ILiveResponseExtraInfo parseFromThrowable(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        if ((r100 instanceof ResponseNoDataException) == false) goto L6;
        return new ao0.b(this, r100);
    L6:
        if ((r100 instanceof ApiLocalException) == false) goto L9;
        return new ao0.c(this, r100);
    L9:
        if ((r100 instanceof ApiServerException) == true) goto L15;
        return null;
    L15:
        return new d(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfoParser
    public final ILiveResponseExtraInfo parse(String r100, SsResponse<Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "response");
        Object r102 = r101.body();
        if ((r102 instanceof BaseResponse) == false) goto L6;
        return new a(this, r102);
    L6:
        if ((r102 instanceof BaseListResponse) == false) goto L9;
        return new b(this, r102);
    L9:
        if ((r102 instanceof com.bytedance.android.live.network.response.c) == true) goto L15;
        return null;
    L15:
        return new c(this, r102);
    }
}
