package com.bytedance.android.ec.common.api.image;

import android.graphics.drawable.Animatable;
import com.facebook.datasource.DataSubscriber;
import com.facebook.imagepipeline.request.ImageRequest;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\bg\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aJB\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\tH&J6\u0010\u0015\u001a\u00020\u00112\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010\u0016\u001a\u00020\u000bH&J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/common/api/image/IECImageOptService;", "", "", "id", "image", "Landroid/graphics/drawable/Animatable;", "animatable", "Lcom/facebook/imagepipeline/request/ImageRequest;", "imageRequest", "", "extra", "", "onFinalImageSet", "Lcom/facebook/datasource/DataSubscriber;", "dataSubscriber", "Ljava/util/concurrent/Executor;", "executor", "", "isFailure", "isCancellation", "dataSource", "notifyDataSubscriber", "initMainHandlerOptConfig", "imageCallerContext", "isUseNetworkPriorityOpt", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public interface IECImageOptService {
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f42829a = null;

        public a() {
        }

        static {
            f42829a = new a();
        }
    }

    static {
        Companion = a.f42829a;
    }

    void initMainHandlerOptConfig();

    boolean isUseNetworkPriorityOpt(Object r100);

    boolean notifyDataSubscriber(DataSubscriber<?> r100, Executor r101, boolean r102, boolean r103, Object r104);

    void onFinalImageSet(String r100, Object r101, Animatable r102, ImageRequest r103, Map<?, ?> r104);
}
