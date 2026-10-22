package com.obric.autogui.userreport;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.assistant.idl.IFlowFeedbackIDL;
import com.obric.aiagent.assistant.idl.bean.FeedbackBean;
import com.obric.aiagent.assistant.idl.z;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.app.HostAppInfo;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.userreport.IAutoActionUserReportApi;
import com.obric.autogui.common.api.userreport.UserReportInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: OAppUserReportImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OAppUserReportImpl implements IAutoActionUserReportApi {
    public static final a Companion = null;
    private static final String TAG = "OAppUserReportImpl";

    /* JADX INFO: compiled from: OAppUserReportImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OAppUserReportImpl.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31487a = null;

        static {
            int[] r0 = new int[UserReportInfo.UserSpecifiedTaskStatus.values().length];
            r0[UserReportInfo.UserSpecifiedTaskStatus.TaskSucceeded.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[UserReportInfo.UserSpecifiedTaskStatus.TaskSucceededPartly.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[UserReportInfo.UserSpecifiedTaskStatus.TaskFailed.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f31487a = r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public OAppUserReportImpl() {
    }

    @Override // com.obric.autogui.common.api.userreport.IAutoActionUserReportApi
    public void initUserReport(Context r2, HostAppInfo r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r3, "appInfo");
        Loog.INSTANCE.i(TAG, "Initialised UserReport via OApp.");
    }

    @Override // com.obric.autogui.common.api.userreport.IAutoActionUserReportApi
    public IAutoActionUserReportApi.UploadingStatus uploadUserReport(Context r9, UserReportInfo r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r11, "context");
        o.e(r10, "userReportInfo");
        String r4 = generateDescription(r11, r10);
        IFlowFeedbackIDL r8 = z.a(aa.b(IFlowFeedbackIDL.class));
        if (r8 != null) goto L17;
        Loog.INSTANCE.e(TAG, "IFlowFeedbackIDL IPC is null.");
        return IAutoActionUserReportApi.UploadingStatus.UnmatchedApi;
    L17:
        List<String> r12 = r10.getExtraPathsToUpload();     // Catch: Throwable -> L14
        if (r12 == null) goto L10;
        ArrayList r13 = (ArrayList) ZeusTransformUtils.preCheckCast(p.b((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin"), (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin")), ArrayList.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r13 == null) goto L10;
    L11:
        r8.onFeedback(new FeedbackBean(r13, r4, true, true, true));     // Catch: Throwable -> L14
        return IAutoActionUserReportApi.UploadingStatus.Success;
    L10:
        r13 = new ArrayList();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "IFlowFeedbackIDL onFeedback errored: " + th.getMessage(), th);
        return IAutoActionUserReportApi.UploadingStatus.ServiceUnavailable;
    }

    private final String generateDescription(Context r9, UserReportInfo r10) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        StringBuilder r11 = new StringBuilder();
        int r1 = b.f31487a[r10.getUserSpecifiedTaskStatus().ordinal()];
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L6;
        int r2 = ZeusTransformUtils.mapRes(R.string.platform_pacific_user_report_opinion_success_partly, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_pacific_user_report_opinion_success_partly");
    L11:
        String r3 = r8.getString(r2);
        o.c(r3, "getString(...)");
        r11.append(r8.getString(ZeusTransformUtils.mapRes(R.string.platform_pacific_user_report_upload_string_template, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_pacific_user_report_upload_string_template"), new Object[]{r3, r10.getTaskQuery(), r10.getSessionId()}));
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10.getUserSuggestion(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L14;
        r11.append(r8.getString(ZeusTransformUtils.mapRes(R.string.platform_pacific_user_report_upload_string_template_suggestion, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_pacific_user_report_upload_string_template_suggestion"), new Object[]{r10.getUserSuggestion()}));
    L14:
        String r12 = r11.toString();
        o.c(r12, "toString(...)");
        return r12;
    L6:
        if (r1 == 3) goto L8;
        r2 = ZeusTransformUtils.mapRes(R.string.platform_pacific_user_report_opinion_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_pacific_user_report_opinion_failed");
        goto L11
    L8:
        r2 = ZeusTransformUtils.mapRes(R.string.platform_pacific_user_report_opinion_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_pacific_user_report_opinion_failed");
        goto L11
    L10:
        r2 = ZeusTransformUtils.mapRes(R.string.platform_pacific_user_report_opinion_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_pacific_user_report_opinion_success");
        goto L11
    }
}
