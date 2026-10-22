package com.byted.mgl.merge.service.api.share;

import org.json.JSONArray;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
public interface BdpShareCallback {

    public static final enum ProcessResult extends Enum<ProcessResult> {
        private static final /* synthetic */ ProcessResult[] $VALUES = null;
        public static final ProcessResult CUT_TEMPLATE_PROCESS_FAIL = null;

        static {
            ProcessResult r100 = new ProcessResult("CUT_TEMPLATE_PROCESS_FAIL", 0);
            CUT_TEMPLATE_PROCESS_FAIL = r100;
            $VALUES = new ProcessResult[]{r100};
        }

        public static ProcessResult[] values() {
            return (ProcessResult[]) $VALUES.clone();
        }

        public static ProcessResult valueOf(String r100) {
            return (ProcessResult) a.a(ProcessResult.class, r100);
        }

        private ProcessResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    void onCancel(String r100);

    void onFail(String r100, JSONArray r101);

    void onProcess(ProcessResult r100);

    void onPublishResponseFinish(boolean r100, String r101, boolean r102, String r103, boolean r104, String r105);

    void onSuccess(String r100, JSONArray r101);
}
