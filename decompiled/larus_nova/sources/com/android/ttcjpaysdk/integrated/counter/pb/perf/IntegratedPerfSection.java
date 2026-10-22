package com.android.ttcjpaysdk.integrated.counter.pb.perf;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes28.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/pb/perf/IntegratedPerfSection;", "", "Companion", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface IntegratedPerfSection {
    public static final Companion Companion = null;
    public static final String DATA_CONVERT_TIME = "data_convert_time";
    public static final String DATA_PARSE_TIME = "data_parse_time";
    public static final String FUNCTION_CALL_TIME = "function_call_time";
    public static final String PAGE_FCP_TIME = "page_fcp_time";
    public static final String REQUEST_END_TIME = "request_end_time";
    public static final String REQUEST_START_TIME = "request_start_time";
    public static final String START_PAGE_TIME = "start_page_time";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/pb/perf/IntegratedPerfSection$Companion;", "", "()V", "DATA_CONVERT_TIME", "", "DATA_PARSE_TIME", "FUNCTION_CALL_TIME", "PAGE_FCP_TIME", "REQUEST_END_TIME", "REQUEST_START_TIME", "START_PAGE_TIME", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String DATA_CONVERT_TIME = "data_convert_time";
        public static final String DATA_PARSE_TIME = "data_parse_time";
        public static final String FUNCTION_CALL_TIME = "function_call_time";
        public static final String PAGE_FCP_TIME = "page_fcp_time";
        public static final String REQUEST_END_TIME = "request_end_time";
        public static final String REQUEST_START_TIME = "request_start_time";
        public static final String START_PAGE_TIME = "start_page_time";

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
