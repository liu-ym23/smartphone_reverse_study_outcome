package com.android.ttcjpaysdk.base.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/IErrorInfo;", "", "getCode", "", "getMsg", "", "Companion", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IErrorInfo {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/IErrorInfo$Companion;", "", "()V", "error", "Lcom/android/ttcjpaysdk/base/service/IErrorInfo;", "code", "", "msg", "", "failed", "success", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final IErrorInfo failed(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            return error(1, r100);
        }

        public final IErrorInfo success(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            return error(0, r100);
        }

        public final IErrorInfo error(final int r100, final String r101) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            return new IErrorInfo$Companion$error$1(r100, r101);
        }

        public static /* synthetic */ IErrorInfo success$default(Companion r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = "";
        L6:
            return r100.success(r101);
        }

        public static /* synthetic */ IErrorInfo error$default(Companion r100, int r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = 0;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = "";
        L9:
            return r100.error(r101, r102);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    int getCode();

    String getMsg();
}
