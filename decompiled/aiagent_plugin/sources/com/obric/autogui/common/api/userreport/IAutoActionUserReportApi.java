package com.obric.autogui.common.api.userreport;

import android.content.Context;
import com.obric.autogui.common.api.app.HostAppInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: IAutoActionUserReportApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionUserReportApi {

    /* JADX INFO: compiled from: IAutoActionUserReportApi.kt */
    public static final enum UploadingStatus extends Enum<UploadingStatus> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ UploadingStatus[] $VALUES = null;
        public static final UploadingStatus NotSupported = null;
        public static final UploadingStatus ServiceUnavailable = null;
        public static final UploadingStatus Success = null;
        public static final UploadingStatus UnmatchedApi = null;

        private static final /* synthetic */ UploadingStatus[] $values() {
            return new UploadingStatus[]{Success, NotSupported, UnmatchedApi, ServiceUnavailable};
        }

        public static a<UploadingStatus> getEntries() {
            return $ENTRIES;
        }

        private UploadingStatus(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Success = new UploadingStatus("Success", 0);
            NotSupported = new UploadingStatus("NotSupported", 1);
            UnmatchedApi = new UploadingStatus("UnmatchedApi", 2);
            ServiceUnavailable = new UploadingStatus("ServiceUnavailable", 3);
            UploadingStatus[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static UploadingStatus valueOf(String r2) {
            return (UploadingStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(UploadingStatus.class, r2), UploadingStatus.class, "com.obric.aiagent.plugin");
        }

        public static UploadingStatus[] values() {
            return (UploadingStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), UploadingStatus[].class, "com.obric.aiagent.plugin");
        }
    }

    void initUserReport(Context r1, HostAppInfo r2);

    UploadingStatus uploadUserReport(Context r1, UserReportInfo r2);
}
