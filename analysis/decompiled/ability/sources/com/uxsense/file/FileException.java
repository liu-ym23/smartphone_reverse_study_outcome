package com.uxsense.file;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleFileBundle;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0006\t\n\u000b\f\r\u000eB\u001d\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b\u0082\u0001\u0006\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/uxsense/file/FileException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "cause", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Throwable;)V", "FileNotFound", "PermissionDenied", "ReadError", "WriteError", "InvalidPath", "DiskFull", "Lcom/uxsense/file/FileException$DiskFull;", "Lcom/uxsense/file/FileException$FileNotFound;", "Lcom/uxsense/file/FileException$InvalidPath;", "Lcom/uxsense/file/FileException$PermissionDenied;", "Lcom/uxsense/file/FileException$ReadError;", "Lcom/uxsense/file/FileException$WriteError;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class FileException extends Exception {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/uxsense/file/FileException$DiskFull;", "Lcom/uxsense/file/FileException;", SingleFileBundle.KEY_PATH, "Ljava/nio/file/Path;", AppAgent.CONSTRUCT, "(Ljava/nio/file/Path;)V", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DiskFull extends FileException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public DiskFull(Path path) {
            super("No enough space: " + path, null, 2, 0 == true ? 1 : 0);
            k.f(path, "path");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/uxsense/file/FileException$FileNotFound;", "Lcom/uxsense/file/FileException;", SingleFileBundle.KEY_PATH, "Ljava/nio/file/Path;", AppAgent.CONSTRUCT, "(Ljava/nio/file/Path;)V", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FileNotFound extends FileException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public FileNotFound(Path path) {
            super("File not found: " + path, null, 2, 0 == true ? 1 : 0);
            k.f(path, "path");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/uxsense/file/FileException$InvalidPath;", "Lcom/uxsense/file/FileException;", SingleFileBundle.KEY_PATH, "Ljava/nio/file/Path;", AppAgent.CONSTRUCT, "(Ljava/nio/file/Path;)V", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InvalidPath extends FileException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public InvalidPath(Path path) {
            super("Invalid path: " + path, null, 2, 0 == true ? 1 : 0);
            k.f(path, "path");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/uxsense/file/FileException$PermissionDenied;", "Lcom/uxsense/file/FileException;", SingleFileBundle.KEY_PATH, "Ljava/nio/file/Path;", AppAgent.CONSTRUCT, "(Ljava/nio/file/Path;)V", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PermissionDenied extends FileException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public PermissionDenied(Path path) {
            super("Permission denied: " + path, null, 2, 0 == true ? 1 : 0);
            k.f(path, "path");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/file/FileException$ReadError;", "Lcom/uxsense/file/FileException;", SingleFileBundle.KEY_PATH, "Ljava/nio/file/Path;", "cause", "", AppAgent.CONSTRUCT, "(Ljava/nio/file/Path;Ljava/lang/Throwable;)V", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReadError extends FileException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReadError(Path path, Throwable cause) {
            super("Read error: " + path, cause, null);
            k.f(path, "path");
            k.f(cause, "cause");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/file/FileException$WriteError;", "Lcom/uxsense/file/FileException;", SingleFileBundle.KEY_PATH, "Ljava/nio/file/Path;", "cause", "", AppAgent.CONSTRUCT, "(Ljava/nio/file/Path;Ljava/lang/Throwable;)V", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WriteError extends FileException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WriteError(Path path, Throwable cause) {
            super("Write error: " + path, cause, null);
            k.f(path, "path");
            k.f(cause, "cause");
        }
    }

    public /* synthetic */ FileException(String str, Throwable th, e eVar) {
        this(str, th);
    }

    private FileException(String str, Throwable th) {
        super(str, th);
    }

    public /* synthetic */ FileException(String str, Throwable th, int i, e eVar) {
        this(str, (i & 2) != 0 ? null : th, null);
    }
}
