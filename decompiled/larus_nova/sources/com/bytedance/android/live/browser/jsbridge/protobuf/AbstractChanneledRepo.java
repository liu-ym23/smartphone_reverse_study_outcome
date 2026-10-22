package com.bytedance.android.live.browser.jsbridge.protobuf;

import androidx.exifinterface.media.ExifInterface;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/protobuf/AbstractChanneledRepo;", ExifInterface.GPS_DIRECTION_TRUE, "", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AbstractChanneledRepo<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, T> f63824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f63825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f63826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<String, BufferedReader, T> f63827d;

    public final void a() {
        if (this.f63826c.length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        Map<String, BufferedReader> r101 = FileContentUtilKt.a(this.f63826c);
    L10:
        if (r101.isEmpty() == false) goto L12;
        r101 = FileContentUtilKt.a(this.f63825b);
    L12:
        Iterator<T> r102 = MapsKt.asSequence(r101).iterator();
    L14:
        if (r102.hasNext() == false) goto L16;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        BufferedReader r105 = (BufferedReader) r103.getValue();
        this.f63824a.put(r104, this.f63827d.invoke(r104, r105));
        goto L14
    L16:
        return;
    L8:
        r101 = FileContentUtilKt.a(this.f63825b);
        goto L10
    L5:
        r100 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractChanneledRepo(String r100, String r101, Function2<? super String, ? super BufferedReader, ? extends T> r102) {
        Intrinsics.checkNotNullParameter(r100, "relativePath");
        Intrinsics.checkNotNullParameter(r101, "relativePathV2");
        Intrinsics.checkNotNullParameter(r102, "createInstance");
        this.f63825b = r100;
        this.f63826c = r101;
        this.f63827d = r102;
        this.f63824a = new ConcurrentHashMap();
    }
}
