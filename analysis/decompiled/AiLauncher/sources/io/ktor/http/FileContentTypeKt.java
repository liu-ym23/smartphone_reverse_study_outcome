package io.ktor.http;

import La.C0953c;
import Z8.C1173v;
import Z8.C1174w;
import Z8.Q;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.http.ContentType;
import io.ktor.util.CharsetKt;
import io.ktor.util.CollectionsKt;
import io.ktor.util.TextKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\r\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\n\u001a\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\b*\u00020\u0003¢\u0006\u0004\b\r\u0010\u000e\u001a\u0019\u0010\u000f\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00030\bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0013\u0010\u0012\u001a\u00020\u0011*\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0013\u0010\u0014\u001a\u00020\u0003*\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001aC\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u001a\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010\u0017*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00190\u0018H\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0013\u0010\u001d\u001a\u00020\u0003*\u00020\u0001H\u0000¢\u0006\u0004\b\u001d\u0010\u001e\"-\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"-\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"¨\u0006'"}, d2 = {"Lio/ktor/http/ContentType$Companion;", "", "extension", "Lio/ktor/http/ContentType;", "defaultForFileExtension", "(Lio/ktor/http/ContentType$Companion;Ljava/lang/String;)Lio/ktor/http/ContentType;", "path", "defaultForFilePath", "", "fromFilePath", "(Lio/ktor/http/ContentType$Companion;Ljava/lang/String;)Ljava/util/List;", "ext", "fromFileExtension", "fileExtensions", "(Lio/ktor/http/ContentType;)Ljava/util/List;", "selectDefault", "(Ljava/util/List;)Lio/ktor/http/ContentType;", "", "matchApplicationTypeWithCharset", "(Lio/ktor/http/ContentType;)Z", "withCharsetUTF8IfNeeded", "(Lio/ktor/http/ContentType;)Lio/ktor/http/ContentType;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "LKa/j;", "Lkotlin/Pair;", "", "groupByPairs", "(LKa/j;)Ljava/util/Map;", "toContentType", "(Ljava/lang/String;)Lio/ktor/http/ContentType;", "contentTypesByExtensions$delegate", "LY8/h;", "getContentTypesByExtensions", "()Ljava/util/Map;", "contentTypesByExtensions", "extensionsByContentType$delegate", "getExtensionsByContentType", "extensionsByContentType", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FileContentTypeKt {
    private static final Y8.h contentTypesByExtensions$delegate = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.http.t
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return FileContentTypeKt.contentTypesByExtensions_delegate$lambda$1();
        }
    });
    private static final Y8.h extensionsByContentType$delegate = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.http.u
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return FileContentTypeKt.extensionsByContentType_delegate$lambda$3();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map contentTypesByExtensions_delegate$lambda$1() {
        Map mapCaseInsensitiveMap = CollectionsKt.caseInsensitiveMap();
        mapCaseInsensitiveMap.putAll(groupByPairs(Z8.F.d0(MimesKt.getMimes())));
        return mapCaseInsensitiveMap;
    }

    public static final ContentType defaultForFileExtension(ContentType.Companion companion, String extension) {
        kotlin.jvm.internal.p.i(companion, "<this>");
        kotlin.jvm.internal.p.i(extension, "extension");
        return selectDefault(fromFileExtension(ContentType.INSTANCE, extension));
    }

    public static final ContentType defaultForFilePath(ContentType.Companion companion, String path) {
        kotlin.jvm.internal.p.i(companion, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        return selectDefault(fromFilePath(ContentType.INSTANCE, path));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map extensionsByContentType_delegate$lambda$3() {
        return groupByPairs(SequencesKt___SequencesKt.R(Z8.F.d0(MimesKt.getMimes()), new InterfaceC5074l() { // from class: io.ktor.http.s
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return FileContentTypeKt.extensionsByContentType_delegate$lambda$3$lambda$2((Pair) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair extensionsByContentType_delegate$lambda$3$lambda$2(Pair pair) {
        kotlin.jvm.internal.p.i(pair, "<destruct>");
        return Y8.j.a((ContentType) pair.b(), (String) pair.a());
    }

    public static final List<String> fileExtensions(ContentType contentType) {
        kotlin.jvm.internal.p.i(contentType, "<this>");
        List<String> list = getExtensionsByContentType().get(contentType);
        if (list != null) {
            return list;
        }
        List<String> list2 = getExtensionsByContentType().get(contentType.withoutParameters());
        return list2 == null ? C1173v.m() : list2;
    }

    public static final List<ContentType> fromFileExtension(ContentType.Companion companion, String ext) {
        kotlin.jvm.internal.p.i(companion, "<this>");
        kotlin.jvm.internal.p.i(ext, "ext");
        for (String lowerCasePreservingASCIIRules = TextKt.toLowerCasePreservingASCIIRules(La.H.R0(ext, ".")); lowerCasePreservingASCIIRules.length() > 0; lowerCasePreservingASCIIRules = La.H.n1(lowerCasePreservingASCIIRules, ".", "")) {
            List<ContentType> list = getContentTypesByExtensions().get(lowerCasePreservingASCIIRules);
            if (list != null) {
                return list;
            }
        }
        return C1173v.m();
    }

    public static final List<ContentType> fromFilePath(ContentType.Companion companion, String path) {
        kotlin.jvm.internal.p.i(companion, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        int iT0 = La.H.t0(path, '.', La.H.D0(path, CharsetKt.toCharArray("/\\"), 0, false, 6, null) + 1, false, 4, null);
        if (iT0 == -1) {
            return C1173v.m();
        }
        String strSubstring = path.substring(iT0 + 1);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return fromFileExtension(companion, strSubstring);
    }

    private static final Map<String, List<ContentType>> getContentTypesByExtensions() {
        return (Map) contentTypesByExtensions$delegate.getValue();
    }

    private static final Map<ContentType, List<String>> getExtensionsByContentType() {
        return (Map) extensionsByContentType$delegate.getValue();
    }

    public static final <A, B> Map<A, List<B>> groupByPairs(Ka.j<? extends Pair<? extends A, ? extends B>> jVar) {
        kotlin.jvm.internal.p.i(jVar, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair<? extends A, ? extends B> pair : jVar) {
            A aE = pair.e();
            Object arrayList = linkedHashMap.get(aE);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(aE, arrayList);
            }
            ((List) arrayList).add(pair);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(Q.e(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList2 = new ArrayList(C1174w.x(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Pair) it.next()).f());
            }
            linkedHashMap2.put(key, arrayList2);
        }
        return linkedHashMap2;
    }

    private static final boolean matchApplicationTypeWithCharset(ContentType contentType) {
        ContentType.Application application = ContentType.Application.INSTANCE;
        if (contentType.match(application.getAny())) {
            return contentType.match(application.getAtom()) || contentType.match(application.getJavaScript()) || contentType.match(application.getRss()) || contentType.match(application.getXml()) || contentType.match(application.getXml_Dtd());
        }
        return false;
    }

    public static final ContentType selectDefault(List<ContentType> list) {
        kotlin.jvm.internal.p.i(list, "<this>");
        ContentType octetStream = (ContentType) Z8.F.s0(list);
        if (octetStream == null) {
            octetStream = ContentType.Application.INSTANCE.getOctetStream();
        }
        return (octetStream.match(ContentType.Text.INSTANCE.getAny()) || octetStream.match(ContentType.Image.INSTANCE.getSVG()) || matchApplicationTypeWithCharset(octetStream)) ? withCharsetUTF8IfNeeded(octetStream) : octetStream;
    }

    public static final ContentType toContentType(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        try {
            return ContentType.INSTANCE.parse(str);
        } catch (Throwable th) {
            throw new IllegalArgumentException("Failed to parse " + str, th);
        }
    }

    private static final ContentType withCharsetUTF8IfNeeded(ContentType contentType) {
        return ContentTypesKt.charset(contentType) != null ? contentType : ContentTypesKt.withCharset(contentType, C0953c.UTF_8);
    }
}
