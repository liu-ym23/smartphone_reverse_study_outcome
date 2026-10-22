package com.bytedance.android.annie.service.network;

import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.mime.TypedString;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f39917a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f39918a = null;

        static {
            int[] r100 = new int[RequestMethod.values().length];
            r100[RequestMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[RequestMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[RequestMethod.PUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[RequestMethod.DELETE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[RequestMethod.DOWNLOAD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f39918a = r100;
        }
    }

    static {
        f39917a = new p();
    }

    public p() {
    }

    public static Triple a(g r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Pair<String, String> r102 = UrlUtils.parseUrl(new UrlBuilder(r100.f39897a).build(), r101);
        return new Triple((String) r102.first, (String) r102.second, r101);
    }

    public static List b(g r100) {
        ArrayList r101 = new ArrayList();
        LinkedHashMap<String, String> r102 = r100.f39898b;
        if (r102 == null) goto L8;
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<String, String> r104 = r103.next();
        r101.add(new Header(r104.getKey(), r104.getValue()));
    L8:
        return r101;
    }

    public static int c(String r110) {
        if (r110 != null) goto L13;
        return 0;
    L13:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L7
        int r101 = StringsKt.lastIndexOf$default(r110, "InternalErrorCode=", 0, false, 6, null);     // Catch: Throwable -> L7
        return CastIntegerProtector.parseInt(r110.substring(r101 + 18, StringsKt.indexOf$default(r110, ',', r101, false, 4, null)));
    L7:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Object r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r111) == false) goto L12;
        r111 = 0;
    L12:
        return ((Number) r111).intValue();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, com.bytedance.retrofit2.mime.MultipartTypedOutput] */
    public static TypedOutput d(g r100) {
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        LinkedHashMap<String, File> r102 = r100.f39901e;
        if (r102 == null) goto L21;
        if ((!r102.isEmpty()) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L21;
        ?? r103 = new MultipartTypedOutput();
        Map<String, String> r104 = r100.f39900d;
        if (r104 == null) goto L15;
        Iterator<Map.Entry<String, String>> r105 = r104.entrySet().iterator();
    L13:
        if (r105.hasNext() == false) goto L15;
        Map.Entry<String, String> r106 = r105.next();
        r103.addPart(r106.getKey(), new TypedString(r106.getValue()));
    L15:
        Iterator<Map.Entry<String, File>> r107 = r102.entrySet().iterator();
    L17:
        if (r107.hasNext() == false) goto L19;
        Map.Entry<String, File> r108 = r107.next();
        r103.addPart(r108.getKey(), new TypedFile(null, r108.getValue()));
        goto L17
    L19:
        r101.element = r103;
    L21:
        return (TypedOutput) r101.element;
    }
}
