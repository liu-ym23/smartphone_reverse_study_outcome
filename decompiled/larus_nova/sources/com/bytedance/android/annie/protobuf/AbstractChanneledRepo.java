package com.bytedance.android.annie.protobuf;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/annie/protobuf/AbstractChanneledRepo;", ExifInterface.GPS_DIRECTION_TRUE, "", "annie-protobuf_release"}, k = 1, mv = {1, 4, 3})
public class AbstractChanneledRepo<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f39734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<String, BufferedReader, T> f39735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, T> f39736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.annie.service.prefetch.b f39737e;

    public final void a() {
        Map r100 = c.a(this.f39737e, this.f39733a);
        Map r101 = c.a(this.f39737e, this.f39734b);
        if (AnnieConfigSettingKeys.ENABLE_LATCH_PB_COMPLETE.a().booleanValue() == false) goto L8;
        Iterator<T> r102 = MapsKt.asSequence(MapsKt.plus(r100, r101)).iterator();
    L6:
        if (r102.hasNext() == false) goto L12;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        BufferedReader r105 = (BufferedReader) r103.getValue();
        this.f39736d.put(r104, this.f39735c.invoke(r104, r105));
        goto L6
    L12:
        return;
    L8:
        Iterator<T> r106 = MapsKt.asSequence(r100).iterator();
    L10:
        if (r106.hasNext() == false) goto L15;
        Map.Entry r107 = (Map.Entry) r106.next();
        String r108 = (String) r107.getKey();
        BufferedReader r109 = (BufferedReader) r107.getValue();
        this.f39736d.put(r108, this.f39735c.invoke(r108, r109));
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractChanneledRepo(String r100, String r101, Function2<? super String, ? super BufferedReader, ? extends T> r102) {
        Intrinsics.checkNotNullParameter(r100, "relativePath");
        Intrinsics.checkNotNullParameter(r101, "relativePathV2");
        Intrinsics.checkNotNullParameter(r102, "createInstance");
        this.f39733a = r100;
        this.f39734b = r101;
        this.f39735c = r102;
        this.f39736d = new ConcurrentHashMap();
        this.f39737e = new com.bytedance.android.annie.service.prefetch.b(0);
    }
}
