package com.tonyodev.fetch2;

import com.stepos.core.common.telemetry.FailStage;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.deepbinder.core.exception.ErrorCodes;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Error {
    public static final Error A;
    public static final Error B;
    public static final Error C;
    public static final Error D;
    public static final Error E;
    public static final Error F;
    public static final Error G;
    public static final Error H;
    public static final Error I;
    public static final Error J;
    public static final /* synthetic */ Error[] K;

    /* renamed from: b, reason: collision with root package name */
    public static final a f8153b;

    /* renamed from: c, reason: collision with root package name */
    public static final Error f8154c;

    /* renamed from: d, reason: collision with root package name */
    public static final Error f8155d;

    /* renamed from: e, reason: collision with root package name */
    public static final Error f8156e;
    public static final Error h;

    /* renamed from: j, reason: collision with root package name */
    public static final Error f8157j;

    /* renamed from: k, reason: collision with root package name */
    public static final Error f8158k;

    /* renamed from: l, reason: collision with root package name */
    public static final Error f8159l;

    /* renamed from: m, reason: collision with root package name */
    public static final Error f8160m;

    /* renamed from: n, reason: collision with root package name */
    public static final Error f8161n;

    /* renamed from: o, reason: collision with root package name */
    public static final Error f8162o;

    /* renamed from: p, reason: collision with root package name */
    public static final Error f8163p;

    /* renamed from: q, reason: collision with root package name */
    public static final Error f8164q;
    public static final Error r;

    /* renamed from: s, reason: collision with root package name */
    public static final Error f8165s;

    /* renamed from: t, reason: collision with root package name */
    public static final Error f8166t;

    /* renamed from: u, reason: collision with root package name */
    public static final Error f8167u;

    /* renamed from: v, reason: collision with root package name */
    public static final Error f8168v;

    /* renamed from: w, reason: collision with root package name */
    public static final Error f8169w;

    /* renamed from: x, reason: collision with root package name */
    public static final Error f8170x;

    /* renamed from: y, reason: collision with root package name */
    public static final Error f8171y;
    public static final Error z;

    /* renamed from: a, reason: collision with root package name */
    public final int f8172a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static Error a(int i10) {
            switch (i10) {
                case -1:
                    return Error.f8154c;
                case 0:
                    return Error.f8155d;
                case 1:
                    return Error.f8156e;
                case 2:
                    return Error.h;
                case 3:
                    return Error.f8157j;
                case 4:
                    return Error.f8158k;
                case 5:
                    return Error.f8159l;
                case 6:
                    return Error.f8160m;
                case 7:
                    return Error.f8161n;
                case 8:
                    return Error.f8162o;
                case 9:
                    return Error.f8163p;
                case 10:
                    return Error.f8164q;
                case 11:
                    return Error.r;
                case 12:
                case 14:
                case 18:
                default:
                    return Error.f8154c;
                case 13:
                    return Error.f8165s;
                case 15:
                    return Error.f8167u;
                case 16:
                    return Error.f8168v;
                case 17:
                    return Error.f8169w;
                case 19:
                    return Error.f8170x;
                case 20:
                    return Error.f8171y;
                case 21:
                    return Error.z;
                case 22:
                    return Error.A;
                case 23:
                    return Error.B;
                case ErrorCodes.GET_INSTANCE_METHOD_INVOCATION_ERROR /* 24 */:
                    return Error.C;
                case 25:
                    return Error.D;
                case 26:
                    return Error.E;
                case 27:
                    return Error.F;
                case ErrorCodes.GET_CONTENT_URI_ERROR /* 28 */:
                    return Error.G;
                case ErrorCodes.GET_PACKAGE_INFO_ERROR /* 29 */:
                    return Error.H;
                case 30:
                    return Error.I;
                case 31:
                    return Error.J;
            }
        }
    }

    static {
        Error error = new Error(FailStage.UNKNOWN, 0, -1);
        f8154c = error;
        Error error2 = new Error(ModelFlowMeta.PLAN_NONE, 1, 0);
        f8155d = error2;
        Error error3 = new Error("FILE_NOT_CREATED", 2, 1);
        f8156e = error3;
        Error error4 = new Error("CONNECTION_TIMED_OUT", 3, 2);
        h = error4;
        Error error5 = new Error("UNKNOWN_HOST", 4, 3);
        f8157j = error5;
        Error error6 = new Error("HTTP_NOT_FOUND", 5, 4);
        f8158k = error6;
        Error error7 = new Error("WRITE_PERMISSION_DENIED", 6, 5);
        f8159l = error7;
        Error error8 = new Error("NO_STORAGE_SPACE", 7, 6);
        f8160m = error8;
        Error error9 = new Error("NO_NETWORK_CONNECTION", 8, 7);
        f8161n = error9;
        Error error10 = new Error("EMPTY_RESPONSE_FROM_SERVER", 9, 8);
        f8162o = error10;
        Error error11 = new Error("REQUEST_ALREADY_EXIST", 10, 9);
        f8163p = error11;
        Error error12 = new Error("DOWNLOAD_NOT_FOUND", 11, 10);
        f8164q = error12;
        Error error13 = new Error("FETCH_DATABASE_ERROR", 12, 11);
        r = error13;
        Error error14 = new Error("REQUEST_WITH_ID_ALREADY_EXIST", 13, 13);
        f8165s = error14;
        Error error15 = new Error("REQUEST_WITH_FILE_PATH_ALREADY_EXIST", 14, 14);
        f8166t = error15;
        Error error16 = new Error("REQUEST_NOT_SUCCESSFUL", 15, 15);
        f8167u = error16;
        Error error17 = new Error("UNKNOWN_IO_ERROR", 16, 16);
        f8168v = error17;
        Error error18 = new Error("FILE_NOT_FOUND", 17, 17);
        f8169w = error18;
        Error error19 = new Error("FETCH_FILE_SERVER_URL_INVALID", 18, 19);
        f8170x = error19;
        Error error20 = new Error("INVALID_CONTENT_HASH", 19, 20);
        f8171y = error20;
        Error error21 = new Error("FAILED_TO_UPDATE_REQUEST", 20, 21);
        z = error21;
        Error error22 = new Error("FAILED_TO_ADD_COMPLETED_DOWNLOAD", 21, 22);
        A = error22;
        Error error23 = new Error("FETCH_FILE_SERVER_INVALID_RESPONSE", 22, 23);
        B = error23;
        Error error24 = new Error("REQUEST_DOES_NOT_EXIST", 23, 24);
        C = error24;
        Error error25 = new Error("ENQUEUE_NOT_SUCCESSFUL", 24, 25);
        D = error25;
        Error error26 = new Error("COMPLETED_NOT_ADDED_SUCCESSFULLY", 25, 26);
        E = error26;
        Error error27 = new Error("ENQUEUED_REQUESTS_ARE_NOT_DISTINCT", 26, 27);
        F = error27;
        Error error28 = new Error("FAILED_TO_RENAME_INCOMPLETE_DOWNLOAD_FILE", 27, 28);
        G = error28;
        Error error29 = new Error("FAILED_TO_RENAME_FILE", 28, 29);
        H = error29;
        Error error30 = new Error("FILE_ALLOCATION_FAILED", 29, 30);
        I = error30;
        Error error31 = new Error("HTTP_CONNECTION_NOT_ALLOWED", 30, 31);
        J = error31;
        Error[] errorArr = {error, error2, error3, error4, error5, error6, error7, error8, error9, error10, error11, error12, error13, error14, error15, error16, error17, error18, error19, error20, error21, error22, error23, error24, error25, error26, error27, error28, error29, error30, error31};
        K = errorArr;
        kotlin.enums.a.a(errorArr);
        f8153b = new a();
    }

    public Error() {
        throw null;
    }

    public Error(String str, int i10, int i11) {
        this.f8172a = i11;
    }

    public static Error valueOf(String str) {
        return (Error) Enum.valueOf(Error.class, str);
    }

    public static Error[] values() {
        return (Error[]) K.clone();
    }
}
