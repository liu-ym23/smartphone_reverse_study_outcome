package com.tonyodev.fetch2core;

import android.net.Uri;
import hb.h;
import java.io.Closeable;
import java.io.InputStream;
import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface Downloader<T, R> extends Closeable {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class FileDownloaderType {

        /* renamed from: a, reason: collision with root package name */
        public static final FileDownloaderType f8203a;

        /* renamed from: b, reason: collision with root package name */
        public static final FileDownloaderType f8204b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ FileDownloaderType[] f8205c;

        static {
            FileDownloaderType fileDownloaderType = new FileDownloaderType("SEQUENTIAL", 0);
            f8203a = fileDownloaderType;
            FileDownloaderType fileDownloaderType2 = new FileDownloaderType("PARALLEL", 1);
            f8204b = fileDownloaderType2;
            FileDownloaderType[] fileDownloaderTypeArr = {fileDownloaderType, fileDownloaderType2};
            f8205c = fileDownloaderTypeArr;
            kotlin.enums.a.a(fileDownloaderTypeArr);
        }

        public FileDownloaderType() {
            throw null;
        }

        public static FileDownloaderType valueOf(String str) {
            return (FileDownloaderType) Enum.valueOf(FileDownloaderType.class, str);
        }

        public static FileDownloaderType[] values() {
            return (FileDownloaderType[]) f8205c.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f8206a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f8207b;

        /* renamed from: c, reason: collision with root package name */
        public final long f8208c;

        /* renamed from: d, reason: collision with root package name */
        public final InputStream f8209d;

        /* renamed from: e, reason: collision with root package name */
        public final AbstractMap f8210e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f8211f;

        public a(int i10, boolean z, long j10, InputStream inputStream, b bVar, String str, AbstractMap abstractMap, boolean z3, String str2) {
            this.f8206a = i10;
            this.f8207b = z;
            this.f8208c = j10;
            this.f8209d = inputStream;
            this.f8210e = abstractMap;
            this.f8211f = z3;
        }

        public final boolean a() {
            return this.f8211f;
        }

        public final long b() {
            return this.f8208c;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f8212a;

        /* renamed from: b, reason: collision with root package name */
        public final LinkedHashMap f8213b;

        /* renamed from: c, reason: collision with root package name */
        public final String f8214c;

        /* renamed from: d, reason: collision with root package name */
        public final String f8215d;

        /* renamed from: e, reason: collision with root package name */
        public final Extras f8216e;

        public b(int i10, String url, LinkedHashMap linkedHashMap, String file, Uri uri, String str, long j10, String str2, Extras extras, String str3, int i11) {
            g.f(url, "url");
            g.f(file, "file");
            g.f(extras, "extras");
            this.f8212a = url;
            this.f8213b = linkedHashMap;
            this.f8214c = file;
            this.f8215d = str2;
            this.f8216e = extras;
        }
    }

    a D0(b bVar, h hVar);

    void E(a aVar);

    void G(b bVar);

    void L(b bVar);

    void W(b bVar);

    FileDownloaderType q0(b bVar, Set<? extends FileDownloaderType> set);

    Set<FileDownloaderType> y0(b bVar);
}
