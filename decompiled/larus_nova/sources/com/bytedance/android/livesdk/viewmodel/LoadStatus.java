package com.bytedance.android.livesdk.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.n;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/viewmodel/LoadStatus;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadStatus<T> extends NextLiveData<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f159314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f159315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Throwable f159316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n<List<T>> f159317d;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadStatus f159318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f159319b;

        public b(LoadStatus r100, e r101) {
            this.f159318a = r100;
            this.f159319b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            if (r101 != null) goto L6;
        L8:
            if (r101 != null) goto L11;
        L13:
            if (r101 != null) goto L16;
            return;
        L16:
            if (r101.intValue() != 2) goto L21;
            this.f159319b.onError(this.f159318a.f159316c);
            return;
        L21:
            return;
        L11:
            if (r101.intValue() != 3) goto L13;
            this.f159319b.onSuccess(this.f159318a.f159317d.getValue(), this.f159318a.f159314a);
            return;
        L6:
            if (r101.intValue() != 1) goto L8;
            this.f159319b.onLoading();
        }
    }

    static {
    }

    public LoadStatus(n<List<T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f159317d = r100;
        setValue(0);
    }

    public final void b(boolean r100) {
        this.f159315b = r100;
        if (r100 == false) goto L6;
        setValue(1);
        return;
    }

    public final void a(LifecycleOwner r100, e<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "listListener");
        observe(r100, new b(this, r101));
    }
}
