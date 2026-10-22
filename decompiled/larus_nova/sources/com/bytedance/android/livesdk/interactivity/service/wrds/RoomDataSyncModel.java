package com.bytedance.android.livesdk.interactivity.service.wrds;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.g;
import com.bytedance.android.livesdk.log.b0;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import dc2.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\b\b\u0000\u0010\b*\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\f\u001a\u00020\u000bH\u0004J)\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u000f\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0084\bR*\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u00118\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/wrds/RoomDataSyncModel;", "Landroidx/lifecycle/ViewModel;", "Lylc/b;", "wrdsManager", "", "bindManager", "release", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "type", "", "key", "Ldc2/c;", "createSettingItem", "Lcom/bytedance/android/livesdk/interactivity/service/wrds/RoomDataSyncModel$a;", "setting", "", "settings", "Ljava/util/Map;", "getSettings", "()Ljava/util/Map;", "bindWrdsManager", "Lylc/b;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoomDataSyncModel extends ViewModel {
    private ylc.b bindWrdsManager;
    private final Map<String, c<?>> settings;

    public static final class a<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final V f141078a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(c r100) {
            this.f141078a = r100;
        }

        public final V a(RoomDataSyncModel r100, KProperty<?> r101) {
            Intrinsics.checkNotNullParameter(r100, "thisRef");
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            return this.f141078a;
        }
    }

    public static final class b implements ylc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f141079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f141080b;

        @Override // ylc.c
        public final void onClear() {
            this.f141080b.onClear();
        }

        @Override // ylc.c
        public final void a(com.ss.ugc.live.sdk.message.wrsc.data.a r100) {
            Intrinsics.checkNotNullParameter(r100, "roomDataSync");
            b0 r101 = b0.o();
            String r102 = "wrds key: " + this.f141079a + " notify update, version: " + r100.f458180a + ", bizLogId: " + r100.f458182c;
            r101.getClass();
            g.i("LiveMessageTracer", r102);
            this.f141080b.a(r100);
        }

        public b(String r100, c r101) {
            this.f141079a = r100;
            this.f141080b = r101;
        }
    }

    public final void release() {
        ylc.b r100 = this.bindWrdsManager;
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, c<?>>> r101 = this.settings.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        ylc.c r102 = r101.next().getValue().f467851c;
        if (r102 == null) goto L7;
        r100.f(r102);
        goto L7
    }

    public RoomDataSyncModel() {
        this.settings = new HashMap();
    }

    public final Map<String, c<?>> getSettings() {
        return this.settings;
    }

    public final void bindManager(ylc.b r100) {
        Intrinsics.checkNotNullParameter(r100, "wrdsManager");
        this.bindWrdsManager = r100;
        Iterator<Map.Entry<String, c<?>>> r101 = this.settings.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<String, c<?>> r102 = r101.next();
        String r103 = r102.getKey();
        c<?> r104 = r102.getValue();
        r104.f467850b = r100.getRoomId();
        com.ss.ugc.live.sdk.message.wrsc.data.a r105 = r100.b(r103);
        if (r105 == null) goto L8;
        r104.a(r105);
    L8:
        b r106 = new b(r103, r104);
        r104.f467851c = r106;
        r100.a(r103, r106);
        goto L4
    }

    public final /* synthetic */ <T> a<c<T>> setting(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new a(access$createSettingItem(this, Object.class, r100));
    }

    public final <T> c<T> createSettingItem(Class<T> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "key");
        c<T> r102 = new c(r101);
        this.settings.put(r101, r102);
        dc2.a.a(r101, r100);
        return r102;
    }

    public static final /* synthetic */ c access$createSettingItem(RoomDataSyncModel r100, Class r101, String r102) {
        return r100.createSettingItem(r101, r102);
    }
}
