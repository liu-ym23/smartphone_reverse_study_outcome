package com.uxsense;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleFileBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0005\t\n\u000b\f\rB\u001d\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b\u0082\u0001\u0005\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/uxsense/ApexException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "cause", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Throwable;)V", "FileNotFound", "IoError", "InvalidArgument", "ParseError", "NotInitialized", "Lcom/uxsense/ApexException$FileNotFound;", "Lcom/uxsense/ApexException$InvalidArgument;", "Lcom/uxsense/ApexException$IoError;", "Lcom/uxsense/ApexException$NotInitialized;", "Lcom/uxsense/ApexException$ParseError;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ApexException extends Exception {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/ApexException$FileNotFound;", "Lcom/uxsense/ApexException;", SingleFileBundle.KEY_PATH, "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FileNotFound extends ApexException {
        private final String path;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public FileNotFound(String path) {
            super("File not found: ".concat(path), null, 2, 0 == true ? 1 : 0);
            k.f(path, "path");
            this.path = path;
        }

        public final String getPath() {
            return this.path;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/uxsense/ApexException$InvalidArgument;", "Lcom/uxsense/ApexException;", "message", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InvalidArgument extends ApexException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public InvalidArgument(String message) {
            super(message, null, 2, 0 == true ? 1 : 0);
            k.f(message, "message");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/uxsense/ApexException$IoError;", "Lcom/uxsense/ApexException;", SingleFileBundle.KEY_PATH, "", "cause", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getPath", "()Ljava/lang/String;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IoError extends ApexException {
        private final String path;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IoError(String path, Throwable cause) {
            super("IO error: ".concat(path), cause, null);
            k.f(path, "path");
            k.f(cause, "cause");
            this.path = path;
        }

        public final String getPath() {
            return this.path;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/uxsense/ApexException$NotInitialized;", "Lcom/uxsense/ApexException;", "message", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NotInitialized extends ApexException {
        /* JADX WARN: Multi-variable type inference failed */
        public NotInitialized() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public NotInitialized(String message) {
            super(message, null, 2, 0 == true ? 1 : 0);
            k.f(message, "message");
        }

        public /* synthetic */ NotInitialized(String str, int i, kotlin.jvm.internal.e eVar) {
            this((i & 1) != 0 ? "ApexSDK not initialized" : str);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/ApexException$ParseError;", "Lcom/uxsense/ApexException;", "message", "", "cause", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Throwable;)V", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ParseError extends ApexException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParseError(String message, Throwable th) {
            super(message, th, null);
            k.f(message, "message");
        }

        public /* synthetic */ ParseError(String str, Throwable th, int i, kotlin.jvm.internal.e eVar) {
            this(str, (i & 2) != 0 ? null : th);
        }
    }

    public /* synthetic */ ApexException(String str, Throwable th, kotlin.jvm.internal.e eVar) {
        this(str, th);
    }

    private ApexException(String str, Throwable th) {
        super(str, th);
    }

    public /* synthetic */ ApexException(String str, Throwable th, int i, kotlin.jvm.internal.e eVar) {
        this(str, (i & 2) != 0 ? null : th, null);
    }
}
