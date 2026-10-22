package com.stepos.common.utils.filestorage.exceptions;

import a0.a;
import gc.q;
import h0.e;
import java.io.IOException;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class FileStorageException extends Exception {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class AuditBlocked extends FileStorageException {

        /* renamed from: a, reason: collision with root package name */
        public final String f6637a;

        /* renamed from: b, reason: collision with root package name */
        public final String f6638b;

        /* renamed from: c, reason: collision with root package name */
        public final String f6639c;

        /* renamed from: d, reason: collision with root package name */
        public final String f6640d;

        /* renamed from: e, reason: collision with root package name */
        public final Boolean f6641e;

        /* JADX WARN: Illegal instructions before constructor call */
        public AuditBlocked(String fileId, String str, String str2, String str3, String str4, String str5, Boolean bool) {
            String strC;
            g.f(fileId, "fileId");
            if (str3 == null || q.t0(str3)) {
                if (g.b(str4, "BLOCK")) {
                    strC = a.k("Content blocked by sensitive-detection (level=", str5 != null ? str5 : "-", ")");
                } else {
                    strC = e.c("Content blocked by safety-audit (decision=", str, ", riskLevel=", str2 != null ? str2 : "-", ")");
                }
            } else {
                strC = "Content blocked: ".concat(str3);
            }
            super(strC, null);
            this.f6637a = str;
            this.f6638b = str2;
            this.f6639c = str4;
            this.f6640d = str5;
            this.f6641e = bool;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class AuditFailed extends FileStorageException {

        /* renamed from: a, reason: collision with root package name */
        public final String f6642a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuditFailed(String fileId, String str) {
            super(str, null);
            g.f(fileId, "fileId");
            this.f6642a = fileId;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class BizError extends FileStorageException {

        /* renamed from: a, reason: collision with root package name */
        public final String f6643a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6644b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BizError(String str, int i10, String message) {
            super(message, null);
            g.f(message, "message");
            this.f6643a = str;
            this.f6644b = i10;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class GatewayException extends FileStorageException {

        /* renamed from: a, reason: collision with root package name */
        public final int f6645a;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class DuplicateRequest extends GatewayException {
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class MissingCommonParam extends GatewayException {
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Other extends GatewayException {
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class SignatureInvalid extends GatewayException {
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class SystemMaintenance extends GatewayException {
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class TokenInvalid extends GatewayException {
        }

        public GatewayException(int i10, String str) {
            super(str, null);
            this.f6645a = i10;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Network extends FileStorageException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Network(String message, IOException iOException) {
            super(message, iOException);
            g.f(message, "message");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class NotInitialized extends FileStorageException {

        /* renamed from: a, reason: collision with root package name */
        public static final NotInitialized f6646a = new NotInitialized();

        private NotInitialized() {
            super("FileStorageManager.setup() not called", null);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TosPutFailed extends FileStorageException {

        /* renamed from: a, reason: collision with root package name */
        public final int f6647a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TosPutFailed(int i10, String message, Throwable th) {
            super(message, th);
            g.f(message, "message");
            this.f6647a = i10;
        }
    }
}
