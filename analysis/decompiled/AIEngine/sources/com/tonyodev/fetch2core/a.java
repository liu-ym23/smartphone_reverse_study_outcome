package com.tonyodev.fetch2core;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import com.stepos.core.ability.speech.AsrCloudConfig;
import com.tonyodev.fetch2core.Downloader;
import hb.i;
import hb.l;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8230a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8231b;

    public a(Context context, String defaultTempDir) {
        g.f(context, "context");
        g.f(defaultTempDir, "defaultTempDir");
        this.f8230a = context;
        this.f8231b = defaultTempDir;
    }

    @Override // com.tonyodev.fetch2core.d
    public final i a(Downloader.b bVar) {
        String str = bVar.f8214c;
        ContentResolver contentResolver = this.f8230a.getContentResolver();
        g.e(contentResolver, "getContentResolver(...)");
        return l.c(str, contentResolver);
    }

    @Override // com.tonyodev.fetch2core.d
    public final boolean b(String file) throws IOException {
        g.f(file, "file");
        if (file.length() == 0) {
            return false;
        }
        try {
            ContentResolver contentResolver = this.f8230a.getContentResolver();
            g.e(contentResolver, "getContentResolver(...)");
            l.c(file, contentResolver).close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.tonyodev.fetch2core.d
    public final String c(Downloader.b bVar) {
        return this.f8231b;
    }

    @Override // com.tonyodev.fetch2core.d
    public final boolean d(String file) {
        g.f(file, "file");
        Context context = this.f8230a;
        g.f(context, "context");
        if (!b.q(file)) {
            File file2 = new File(file);
            if (file2.exists() && file2.canWrite()) {
                return file2.delete();
            }
            return false;
        }
        Uri uri = Uri.parse(file);
        String scheme = uri.getScheme();
        if (scheme != null) {
            int iHashCode = scheme.hashCode();
            if (iHashCode != 3143036) {
                if (iHashCode == 951530617 && scheme.equals("content")) {
                    if (DocumentsContract.isDocumentUri(context, uri)) {
                        return DocumentsContract.deleteDocument(context.getContentResolver(), uri);
                    }
                    if (context.getContentResolver().delete(uri, null, null) > 0) {
                        return true;
                    }
                }
            } else if (scheme.equals(AsrCloudConfig.SCENE_MODE_FILE)) {
                File file3 = new File(String.valueOf(uri.getPath()));
                if (file3.canWrite() && file3.exists() && file3.exists() && file3.canWrite()) {
                    return file3.delete();
                }
            }
        }
        return false;
    }

    @Override // com.tonyodev.fetch2core.d
    public final String e(String file, boolean z) throws IOException {
        g.f(file, "file");
        Context context = this.f8230a;
        g.f(context, "context");
        if (!b.q(file)) {
            return l.b(file, z);
        }
        Uri uri = Uri.parse(file);
        String scheme = uri.getScheme();
        if (scheme != null) {
            int iHashCode = scheme.hashCode();
            if (iHashCode != 3143036) {
                if (iHashCode == 951530617 && scheme.equals("content")) {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "w");
                    if (parcelFileDescriptorOpenFileDescriptor == null) {
                        throw new IOException("FNC");
                    }
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return file;
                }
            } else if (scheme.equals(AsrCloudConfig.SCENE_MODE_FILE)) {
                String path = uri.getPath();
                if (path != null) {
                    file = path;
                }
                return l.b(file, z);
            }
        }
        throw new IOException("FNC");
    }

    @Override // com.tonyodev.fetch2core.d
    public final void f(long j10, String file) throws IOException {
        g.f(file, "file");
        if (file.length() == 0) {
            throw new FileNotFoundException(file.concat(" file_not_found"));
        }
        if (j10 < 1) {
            return;
        }
        Context context = this.f8230a;
        g.f(context, "context");
        if (!b.q(file)) {
            l.a(new File(file), j10);
            return;
        }
        Uri uri = Uri.parse(file);
        String scheme = uri.getScheme();
        if (scheme != null) {
            int iHashCode = scheme.hashCode();
            if (iHashCode != 3143036) {
                if (iHashCode == 951530617 && scheme.equals("content")) {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "w");
                    if (parcelFileDescriptorOpenFileDescriptor == null) {
                        throw new IOException("file_allocation_error");
                    }
                    if (j10 > 0) {
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                            if (fileOutputStream.getChannel().size() == j10) {
                                return;
                            }
                            fileOutputStream.getChannel().position(j10 - 1);
                            fileOutputStream.write(1);
                            return;
                        } catch (Exception unused) {
                            throw new IOException("file_allocation_error");
                        }
                    }
                    return;
                }
            } else if (scheme.equals(AsrCloudConfig.SCENE_MODE_FILE)) {
                String path = uri.getPath();
                if (path != null) {
                    file = path;
                }
                l.a(new File(file), j10);
                return;
            }
        }
        throw new IOException("file_allocation_error");
    }
}
