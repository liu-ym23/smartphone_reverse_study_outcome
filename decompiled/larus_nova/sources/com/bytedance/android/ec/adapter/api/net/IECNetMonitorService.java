package com.bytedance.android.ec.adapter.api.net;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cJ\u0010\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\u0006\u001a\u00020\u0005H&JN\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\nH&J#\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0013H&¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/adapter/api/net/IECNetMonitorService;", "", "", "interceptors", "netMonitorInterceptor", "", "canRecord", "isSuccessful", "", "netCode", "", "path", Segment.JsonKey.START, "msg", "", "duration", "Lje/a;", "timing", "logId", "", "reportECCommonNetRequestEvent", "info", "netRequestEnd", "Lorg/json/JSONObject;", "netReportParams", "(Ljava/lang/String;Ljava/lang/Long;)Lorg/json/JSONObject;", "preloadMonitorInterceptors", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECNetMonitorService {
    public static final int CODE_CLIENT_ERROR = 993;
    public static final int CODE_EMPTY_BODY = 994;
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f42682a = null;

        public a() {
        }

        static {
            f42682a = new a();
        }
    }

    static {
        Companion = a.f42682a;
    }

    boolean canRecord();

    List<Object> interceptors();

    Object netMonitorInterceptor();

    JSONObject netReportParams(String r100, Long r101);

    void preloadMonitorInterceptors();

    void reportECCommonNetRequestEvent(boolean r100, int r101, String r102, int r103, String r104, long r105, je.a r106, String r107);
}
